package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class paisbase_calculogeneral_impl extends GXWebComponent
{
   public paisbase_calculogeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public paisbase_calculogeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisbase_calculogeneral_impl.class ));
   }

   public paisbase_calculogeneral_impl( int remoteHandle ,
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
      cmbPaiBaseClaseLeg = new HTMLChoice();
      cmbPaiBaseTipo = new HTMLChoice();
      chkPaiLicAdju = UIFactory.getCheckbox(this);
      chkPaiLicAdjuObl = UIFactory.getCheckbox(this);
      chkPaiLicNecAut = UIFactory.getCheckbox(this);
      chkPaiLicIngMot = UIFactory.getCheckbox(this);
      chkPaiLicMotObl = UIFactory.getCheckbox(this);
      cmbPaiBasePromTCnt = new HTMLChoice();
      dynPaiBaseRelSec = new HTMLChoice();
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
               A1440PaiBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "PaiBaseClaseLeg"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
               A1441PaiBaseTipo = httpContext.GetPar( "PaiBaseTipo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
               A1442PaiBaseCod1 = httpContext.GetPar( "PaiBaseCod1") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
               A1443PaiBaseCod2 = httpContext.GetPar( "PaiBaseCod2") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(A46PaiCod),Byte.valueOf(A1440PaiBaseClaseLeg),A1441PaiBaseTipo,A1442PaiBaseCod1,A1443PaiBaseCod2});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"PAIBASERELSEC") == 0 )
            {
               AV13CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlapaibaserelsecGF2( AV13CliCod) ;
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
         paGF2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Paisbase_calculo General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.paisbase_calculogeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A46PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1440PaiBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(A1441PaiBaseTipo)),GXutil.URLEncode(GXutil.rtrim(A1442PaiBaseCod1)),GXutil.URLEncode(GXutil.rtrim(A1443PaiBaseCod2))}, new String[] {"PaiCod","PaiBaseClaseLeg","PaiBaseTipo","PaiBaseCod1","PaiBaseCod2"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1440PaiBaseClaseLeg", GXutil.ltrim( localUtil.ntoc( wcpOA1440PaiBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1441PaiBaseTipo", GXutil.rtrim( wcpOA1441PaiBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1442PaiBaseCod1", GXutil.rtrim( wcpOA1442PaiBaseCod1));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1443PaiBaseCod2", GXutil.rtrim( wcpOA1443PaiBaseCod2));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV13CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormGF2( )
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
      return "Paisbase_calculoGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Paisbase_calculo General", "") ;
   }

   public void wbGF0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.paisbase_calculogeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiBaseClaseLeg.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbPaiBaseClaseLeg.getInternalname(), httpContext.getMessage( "Clase de legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiBaseClaseLeg, cmbPaiBaseClaseLeg.getInternalname(), GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0)), 1, cmbPaiBaseClaseLeg.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbPaiBaseClaseLeg.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Paisbase_calculoGeneral.htm");
         cmbPaiBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiBaseClaseLeg.getInternalname(), "Values", cmbPaiBaseClaseLeg.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiBaseTipo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbPaiBaseTipo.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiBaseTipo, cmbPaiBaseTipo.getInternalname(), GXutil.rtrim( A1441PaiBaseTipo), 1, cmbPaiBaseTipo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPaiBaseTipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Paisbase_calculoGeneral.htm");
         cmbPaiBaseTipo.setValue( GXutil.rtrim( A1441PaiBaseTipo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiBaseTipo.getInternalname(), "Values", cmbPaiBaseTipo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPaibasecod1_cell_Internalname, 1, 0, "px", 0, "px", divPaibasecod1_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtPaiBaseCod1_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiBaseCod1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiBaseCod1_Internalname, httpContext.getMessage( "Código 1", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiBaseCod1_Internalname, GXutil.rtrim( A1442PaiBaseCod1), GXutil.rtrim( localUtil.format( A1442PaiBaseCod1, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiBaseCod1_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiBaseCod1_Visible, edtPaiBaseCod1_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paisbase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPaibasecod2_cell_Internalname, 1, 0, "px", 0, "px", divPaibasecod2_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtPaiBaseCod2_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiBaseCod2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiBaseCod2_Internalname, httpContext.getMessage( "Código 2", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiBaseCod2_Internalname, GXutil.rtrim( A1443PaiBaseCod2), GXutil.rtrim( localUtil.format( A1443PaiBaseCod2, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiBaseCod2_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiBaseCod2_Visible, edtPaiBaseCod2_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paisbase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiBasePlus_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiBasePlus_Internalname, httpContext.getMessage( "Porcentaje para plus", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiBasePlus_Internalname, GXutil.ltrim( localUtil.ntoc( A1444PaiBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiBasePlus_Enabled!=0) ? localUtil.format( A1444PaiBasePlus, "9.9999") : localUtil.format( A1444PaiBasePlus, "9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiBasePlus_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiBasePlus_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Paisbase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPailicdlim_cell_Internalname, 1, 0, "px", 0, "px", divPailicdlim_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtPaiLicDLim_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiLicDLim_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiLicDLim_Internalname, httpContext.getMessage( "Cantidad de días permitidos por licencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiLicDLim_Internalname, GXutil.ltrim( localUtil.ntoc( A1629PaiLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiLicDLim_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1629PaiLicDLim), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1629PaiLicDLim), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiLicDLim_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiLicDLim_Visible, edtPaiLicDLim_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPailicdseman_cell_Internalname, 1, 0, "px", 0, "px", divPailicdseman_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtPaiLicDSeman_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiLicDSeman_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiLicDSeman_Internalname, httpContext.getMessage( "Cantidad de días permitidos por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiLicDSeman_Internalname, GXutil.ltrim( localUtil.ntoc( A1630PaiLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiLicDSeman_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1630PaiLicDSeman), "9") : localUtil.format( DecimalUtil.doubleToDec(A1630PaiLicDSeman), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiLicDSeman_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiLicDSeman_Visible, edtPaiLicDSeman_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPailicdmes_cell_Internalname, 1, 0, "px", 0, "px", divPailicdmes_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtPaiLicDMes_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiLicDMes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiLicDMes_Internalname, httpContext.getMessage( "Cantidad de días permitidos por mes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiLicDMes_Internalname, GXutil.ltrim( localUtil.ntoc( A1631PaiLicDMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiLicDMes_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1631PaiLicDMes), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1631PaiLicDMes), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiLicDMes_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiLicDMes_Visible, edtPaiLicDMes_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPailicdsemes_cell_Internalname, 1, 0, "px", 0, "px", divPailicdsemes_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtPaiLicDSemes_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiLicDSemes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiLicDSemes_Internalname, httpContext.getMessage( "Cantidad de días permitidos por semestre", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiLicDSemes_Internalname, GXutil.ltrim( localUtil.ntoc( A1632PaiLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiLicDSemes_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1632PaiLicDSemes), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1632PaiLicDSemes), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiLicDSemes_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiLicDSemes_Visible, edtPaiLicDSemes_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPailicdanual_cell_Internalname, 1, 0, "px", 0, "px", divPailicdanual_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtPaiLicDAnual_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiLicDAnual_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiLicDAnual_Internalname, httpContext.getMessage( "Cantidad de días permitidos por año", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiLicDAnual_Internalname, GXutil.ltrim( localUtil.ntoc( A1633PaiLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiLicDAnual_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1633PaiLicDAnual), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1633PaiLicDAnual), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiLicDAnual_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiLicDAnual_Visible, edtPaiLicDAnual_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPailicadju_cell_Internalname, 1, 0, "px", 0, "px", divPailicadju_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkPaiLicAdju.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiLicAdju.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkPaiLicAdju.getInternalname(), httpContext.getMessage( "Permite adjuntar documento", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiLicAdju.getInternalname(), GXutil.booltostr( A1634PaiLicAdju), "", httpContext.getMessage( "Permite adjuntar documento", ""), chkPaiLicAdju.getVisible(), chkPaiLicAdju.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPailicadjuobl_cell_Internalname, 1, 0, "px", 0, "px", divPailicadjuobl_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkPaiLicAdjuObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiLicAdjuObl.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkPaiLicAdjuObl.getInternalname(), httpContext.getMessage( "Obliga a adjuntar documento", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiLicAdjuObl.getInternalname(), GXutil.booltostr( A1635PaiLicAdjuObl), "", httpContext.getMessage( "Obliga a adjuntar documento", ""), chkPaiLicAdjuObl.getVisible(), chkPaiLicAdjuObl.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPailicnecaut_cell_Internalname, 1, 0, "px", 0, "px", divPailicnecaut_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkPaiLicNecAut.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiLicNecAut.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkPaiLicNecAut.getInternalname(), httpContext.getMessage( "Necesita autorización", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiLicNecAut.getInternalname(), GXutil.booltostr( A1636PaiLicNecAut), "", httpContext.getMessage( "Necesita autorización", ""), chkPaiLicNecAut.getVisible(), chkPaiLicNecAut.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPailicingmot_cell_Internalname, 1, 0, "px", 0, "px", divPailicingmot_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkPaiLicIngMot.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiLicIngMot.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkPaiLicIngMot.getInternalname(), httpContext.getMessage( "Permite ingresar motivo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiLicIngMot.getInternalname(), GXutil.booltostr( A1637PaiLicIngMot), "", httpContext.getMessage( "Permite ingresar motivo", ""), chkPaiLicIngMot.getVisible(), chkPaiLicIngMot.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPailicmotobl_cell_Internalname, 1, 0, "px", 0, "px", divPailicmotobl_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkPaiLicMotObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiLicMotObl.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkPaiLicMotObl.getInternalname(), httpContext.getMessage( "Obliga a ingresar motivo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiLicMotObl.getInternalname(), GXutil.booltostr( A1638PaiLicMotObl), "", httpContext.getMessage( "Obliga a ingresar motivo", ""), chkPaiLicMotObl.getVisible(), chkPaiLicMotObl.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiBasePromCnt1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiBasePromCnt1_Internalname, httpContext.getMessage( "Cantidad de días/meses a promediar", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiBasePromCnt1_Internalname, GXutil.ltrim( localUtil.ntoc( A1451PaiBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiBasePromCnt1_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiBasePromCnt1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiBasePromCnt1_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiBasePromCnt2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiBasePromCnt2_Internalname, httpContext.getMessage( "segunda alternativa", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiBasePromCnt2_Internalname, GXutil.ltrim( localUtil.ntoc( A1452PaiBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiBasePromCnt2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiBasePromCnt2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiBasePromCnt2_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiBasePromTCnt.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbPaiBasePromTCnt.getInternalname(), httpContext.getMessage( "Días o Meses", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiBasePromTCnt, cmbPaiBasePromTCnt.getInternalname(), GXutil.rtrim( A1453PaiBasePromTCnt), 1, cmbPaiBasePromTCnt.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPaiBasePromTCnt.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Paisbase_calculoGeneral.htm");
         cmbPaiBasePromTCnt.setValue( GXutil.rtrim( A1453PaiBasePromTCnt) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiBasePromTCnt.getInternalname(), "Values", cmbPaiBasePromTCnt.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynPaiBaseRelSec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynPaiBaseRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynPaiBaseRelSec, dynPaiBaseRelSec.getInternalname(), GXutil.trim( GXutil.str( A2053PaiBaseRelSec, 6, 0)), 1, dynPaiBaseRelSec.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynPaiBaseRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Paisbase_calculoGeneral.htm");
         dynPaiBaseRelSec.setValue( GXutil.trim( GXutil.str( A2053PaiBaseRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynPaiBaseRelSec.getInternalname(), "Values", dynPaiBaseRelSec.ToJavascriptSource(), true);
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
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11gf1_client"+"'", TempTags, "", 2, "HLP_Paisbase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 111,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12gf1_client"+"'", TempTags, "", 2, "HLP_Paisbase_calculoGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Paisbase_calculoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startGF2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Paisbase_calculo General", ""), (short)(0)) ;
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
            strupGF0( ) ;
         }
      }
   }

   public void wsGF2( )
   {
      startGF2( ) ;
      evtGF2( ) ;
   }

   public void evtGF2( )
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
                              strupGF0( ) ;
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
                              strupGF0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13GF2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupGF0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14GF2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupGF0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15GF2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupGF0( ) ;
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
                              strupGF0( ) ;
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

   public void weGF2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormGF2( ) ;
         }
      }
   }

   public void paGF2( )
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

   public void gxdlapaibaserelsecGF2( int AV13CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlapaibaserelsec_dataGF2( AV13CliCod) ;
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

   public void gxapaibaserelsec_htmlGF2( int AV13CliCod )
   {
      int gxdynajaxvalue;
      gxdlapaibaserelsec_dataGF2( AV13CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynPaiBaseRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynPaiBaseRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlapaibaserelsec_dataGF2( int AV13CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00GF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00GF2_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00GF2_A1880CliReDTChar[0]);
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
      if ( cmbPaiBaseClaseLeg.getItemCount() > 0 )
      {
         A1440PaiBaseClaseLeg = (byte)(GXutil.lval( cmbPaiBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiBaseClaseLeg.getInternalname(), "Values", cmbPaiBaseClaseLeg.ToJavascriptSource(), true);
      }
      if ( cmbPaiBaseTipo.getItemCount() > 0 )
      {
         A1441PaiBaseTipo = cmbPaiBaseTipo.getValidValue(A1441PaiBaseTipo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseTipo.setValue( GXutil.rtrim( A1441PaiBaseTipo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiBaseTipo.getInternalname(), "Values", cmbPaiBaseTipo.ToJavascriptSource(), true);
      }
      A1634PaiLicAdju = GXutil.strtobool( GXutil.booltostr( A1634PaiLicAdju)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1634PaiLicAdju", A1634PaiLicAdju);
      A1635PaiLicAdjuObl = GXutil.strtobool( GXutil.booltostr( A1635PaiLicAdjuObl)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1635PaiLicAdjuObl", A1635PaiLicAdjuObl);
      A1636PaiLicNecAut = GXutil.strtobool( GXutil.booltostr( A1636PaiLicNecAut)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1636PaiLicNecAut", A1636PaiLicNecAut);
      A1637PaiLicIngMot = GXutil.strtobool( GXutil.booltostr( A1637PaiLicIngMot)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1637PaiLicIngMot", A1637PaiLicIngMot);
      A1638PaiLicMotObl = GXutil.strtobool( GXutil.booltostr( A1638PaiLicMotObl)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1638PaiLicMotObl", A1638PaiLicMotObl);
      if ( cmbPaiBasePromTCnt.getItemCount() > 0 )
      {
         A1453PaiBasePromTCnt = cmbPaiBasePromTCnt.getValidValue(A1453PaiBasePromTCnt) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1453PaiBasePromTCnt", A1453PaiBasePromTCnt);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBasePromTCnt.setValue( GXutil.rtrim( A1453PaiBasePromTCnt) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiBasePromTCnt.getInternalname(), "Values", cmbPaiBasePromTCnt.ToJavascriptSource(), true);
      }
      if ( dynPaiBaseRelSec.getItemCount() > 0 )
      {
         A2053PaiBaseRelSec = (int)(GXutil.lval( dynPaiBaseRelSec.getValidValue(GXutil.trim( GXutil.str( A2053PaiBaseRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2053PaiBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2053PaiBaseRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPaiBaseRelSec.setValue( GXutil.trim( GXutil.str( A2053PaiBaseRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynPaiBaseRelSec.getInternalname(), "Values", dynPaiBaseRelSec.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfGF2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV18Pgmname = "Paisbase_calculoGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rfGF2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15GF2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00GF3 */
         pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2053PaiBaseRelSec = H00GF3_A2053PaiBaseRelSec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2053PaiBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2053PaiBaseRelSec), 6, 0));
            A1453PaiBasePromTCnt = H00GF3_A1453PaiBasePromTCnt[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1453PaiBasePromTCnt", A1453PaiBasePromTCnt);
            A1452PaiBasePromCnt2 = H00GF3_A1452PaiBasePromCnt2[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1452PaiBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), 3, 0));
            A1451PaiBasePromCnt1 = H00GF3_A1451PaiBasePromCnt1[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1451PaiBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), 3, 0));
            A1638PaiLicMotObl = H00GF3_A1638PaiLicMotObl[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1638PaiLicMotObl", A1638PaiLicMotObl);
            A1637PaiLicIngMot = H00GF3_A1637PaiLicIngMot[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1637PaiLicIngMot", A1637PaiLicIngMot);
            A1636PaiLicNecAut = H00GF3_A1636PaiLicNecAut[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1636PaiLicNecAut", A1636PaiLicNecAut);
            A1635PaiLicAdjuObl = H00GF3_A1635PaiLicAdjuObl[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1635PaiLicAdjuObl", A1635PaiLicAdjuObl);
            A1634PaiLicAdju = H00GF3_A1634PaiLicAdju[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1634PaiLicAdju", A1634PaiLicAdju);
            A1633PaiLicDAnual = H00GF3_A1633PaiLicDAnual[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1633PaiLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1633PaiLicDAnual), 3, 0));
            A1632PaiLicDSemes = H00GF3_A1632PaiLicDSemes[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1632PaiLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1632PaiLicDSemes), 3, 0));
            A1631PaiLicDMes = H00GF3_A1631PaiLicDMes[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1631PaiLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1631PaiLicDMes), 2, 0));
            A1630PaiLicDSeman = H00GF3_A1630PaiLicDSeman[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1630PaiLicDSeman", GXutil.str( A1630PaiLicDSeman, 1, 0));
            A1629PaiLicDLim = H00GF3_A1629PaiLicDLim[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1629PaiLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1629PaiLicDLim), 3, 0));
            A1444PaiBasePlus = H00GF3_A1444PaiBasePlus[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1444PaiBasePlus", GXutil.ltrimstr( A1444PaiBasePlus, 6, 4));
            /* Execute user event: Load */
            e14GF2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         wbGF0( ) ;
      }
   }

   public void send_integrity_lvl_hashesGF2( )
   {
   }

   public void before_start_formulas( )
   {
      AV18Pgmname = "Paisbase_calculoGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupGF0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13GF2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1440PaiBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1440PaiBaseClaseLeg"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1441PaiBaseTipo = httpContext.cgiGet( sPrefix+"wcpOA1441PaiBaseTipo") ;
         wcpOA1442PaiBaseCod1 = httpContext.cgiGet( sPrefix+"wcpOA1442PaiBaseCod1") ;
         wcpOA1443PaiBaseCod2 = httpContext.cgiGet( sPrefix+"wcpOA1443PaiBaseCod2") ;
         /* Read variables values. */
         A1444PaiBasePlus = localUtil.ctond( httpContext.cgiGet( edtPaiBasePlus_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1444PaiBasePlus", GXutil.ltrimstr( A1444PaiBasePlus, 6, 4));
         A1629PaiLicDLim = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1629PaiLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1629PaiLicDLim), 3, 0));
         A1630PaiLicDSeman = (byte)(localUtil.ctol( httpContext.cgiGet( edtPaiLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1630PaiLicDSeman", GXutil.str( A1630PaiLicDSeman, 1, 0));
         A1631PaiLicDMes = (byte)(localUtil.ctol( httpContext.cgiGet( edtPaiLicDMes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1631PaiLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1631PaiLicDMes), 2, 0));
         A1632PaiLicDSemes = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1632PaiLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1632PaiLicDSemes), 3, 0));
         A1633PaiLicDAnual = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1633PaiLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1633PaiLicDAnual), 3, 0));
         A1634PaiLicAdju = GXutil.strtobool( httpContext.cgiGet( chkPaiLicAdju.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1634PaiLicAdju", A1634PaiLicAdju);
         A1635PaiLicAdjuObl = GXutil.strtobool( httpContext.cgiGet( chkPaiLicAdjuObl.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1635PaiLicAdjuObl", A1635PaiLicAdjuObl);
         A1636PaiLicNecAut = GXutil.strtobool( httpContext.cgiGet( chkPaiLicNecAut.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1636PaiLicNecAut", A1636PaiLicNecAut);
         A1637PaiLicIngMot = GXutil.strtobool( httpContext.cgiGet( chkPaiLicIngMot.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1637PaiLicIngMot", A1637PaiLicIngMot);
         A1638PaiLicMotObl = GXutil.strtobool( httpContext.cgiGet( chkPaiLicMotObl.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1638PaiLicMotObl", A1638PaiLicMotObl);
         A1451PaiBasePromCnt1 = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1451PaiBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), 3, 0));
         A1452PaiBasePromCnt2 = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1452PaiBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), 3, 0));
         cmbPaiBasePromTCnt.setValue( httpContext.cgiGet( cmbPaiBasePromTCnt.getInternalname()) );
         A1453PaiBasePromTCnt = httpContext.cgiGet( cmbPaiBasePromTCnt.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1453PaiBasePromTCnt", A1453PaiBasePromTCnt);
         dynPaiBaseRelSec.setValue( httpContext.cgiGet( dynPaiBaseRelSec.getInternalname()) );
         A2053PaiBaseRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynPaiBaseRelSec.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2053PaiBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2053PaiBaseRelSec), 6, 0));
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
      e13GF2 ();
      if (returnInSub) return;
   }

   public void e13GF2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      paisbase_calculogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e14GF2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), true);
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisbase_calculo_Update", GXv_boolean5) ;
      paisbase_calculogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisbase_calculo_Delete", GXv_boolean5) ;
      paisbase_calculogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtndelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Paibasetipo, "horaNormal") != 0 ) ) )
      {
         edtPaiBaseCod1_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiBaseCod1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod1_Visible), 5, 0), true);
         divPaibasecod1_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPaibasecod1_cell_Internalname, "Class", divPaibasecod1_cell_Class, true);
      }
      else
      {
         edtPaiBaseCod1_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiBaseCod1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod1_Visible), 5, 0), true);
         divPaibasecod1_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPaibasecod1_cell_Internalname, "Class", divPaibasecod1_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Paibasetipo, "horaNormal") != 0 ) ) )
      {
         edtPaiBaseCod2_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiBaseCod2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod2_Visible), 5, 0), true);
         divPaibasecod2_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPaibasecod2_cell_Internalname, "Class", divPaibasecod2_cell_Class, true);
      }
      else
      {
         edtPaiBaseCod2_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiBaseCod2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod2_Visible), 5, 0), true);
         divPaibasecod2_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPaibasecod2_cell_Internalname, "Class", divPaibasecod2_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Paibasetipo, "licencia") == 0 ) ) )
      {
         edtPaiLicDLim_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDLim_Visible), 5, 0), true);
         divPailicdlim_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicdlim_cell_Internalname, "Class", divPailicdlim_cell_Class, true);
      }
      else
      {
         edtPaiLicDLim_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDLim_Visible), 5, 0), true);
         divPailicdlim_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicdlim_cell_Internalname, "Class", divPailicdlim_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Paibasetipo, "licencia") == 0 ) ) )
      {
         edtPaiLicDSeman_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDSeman_Visible), 5, 0), true);
         divPailicdseman_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicdseman_cell_Internalname, "Class", divPailicdseman_cell_Class, true);
      }
      else
      {
         edtPaiLicDSeman_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDSeman_Visible), 5, 0), true);
         divPailicdseman_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicdseman_cell_Internalname, "Class", divPailicdseman_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Paibasetipo, "licencia") == 0 ) ) )
      {
         edtPaiLicDMes_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiLicDMes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDMes_Visible), 5, 0), true);
         divPailicdmes_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicdmes_cell_Internalname, "Class", divPailicdmes_cell_Class, true);
      }
      else
      {
         edtPaiLicDMes_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiLicDMes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDMes_Visible), 5, 0), true);
         divPailicdmes_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicdmes_cell_Internalname, "Class", divPailicdmes_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Paibasetipo, "licencia") == 0 ) ) )
      {
         edtPaiLicDSemes_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDSemes_Visible), 5, 0), true);
         divPailicdsemes_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicdsemes_cell_Internalname, "Class", divPailicdsemes_cell_Class, true);
      }
      else
      {
         edtPaiLicDSemes_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDSemes_Visible), 5, 0), true);
         divPailicdsemes_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicdsemes_cell_Internalname, "Class", divPailicdsemes_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Paibasetipo, "licencia") == 0 ) ) )
      {
         edtPaiLicDAnual_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDAnual_Visible), 5, 0), true);
         divPailicdanual_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicdanual_cell_Internalname, "Class", divPailicdanual_cell_Class, true);
      }
      else
      {
         edtPaiLicDAnual_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDAnual_Visible), 5, 0), true);
         divPailicdanual_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicdanual_cell_Internalname, "Class", divPailicdanual_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Paibasetipo, "licencia") == 0 ) ) )
      {
         chkPaiLicAdju.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicAdju.getVisible(), 5, 0), true);
         divPailicadju_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicadju_cell_Internalname, "Class", divPailicadju_cell_Class, true);
      }
      else
      {
         chkPaiLicAdju.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicAdju.getVisible(), 5, 0), true);
         divPailicadju_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicadju_cell_Internalname, "Class", divPailicadju_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Paibasetipo, "licencia") == 0 ) ) )
      {
         chkPaiLicAdjuObl.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicAdjuObl.getVisible(), 5, 0), true);
         divPailicadjuobl_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicadjuobl_cell_Internalname, "Class", divPailicadjuobl_cell_Class, true);
      }
      else
      {
         chkPaiLicAdjuObl.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicAdjuObl.getVisible(), 5, 0), true);
         divPailicadjuobl_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicadjuobl_cell_Internalname, "Class", divPailicadjuobl_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Paibasetipo, "licencia") == 0 ) ) )
      {
         chkPaiLicNecAut.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicNecAut.getVisible(), 5, 0), true);
         divPailicnecaut_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicnecaut_cell_Internalname, "Class", divPailicnecaut_cell_Class, true);
      }
      else
      {
         chkPaiLicNecAut.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicNecAut.getVisible(), 5, 0), true);
         divPailicnecaut_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicnecaut_cell_Internalname, "Class", divPailicnecaut_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Paibasetipo, "licencia") == 0 ) ) )
      {
         chkPaiLicIngMot.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicIngMot.getVisible(), 5, 0), true);
         divPailicingmot_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicingmot_cell_Internalname, "Class", divPailicingmot_cell_Class, true);
      }
      else
      {
         chkPaiLicIngMot.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicIngMot.getVisible(), 5, 0), true);
         divPailicingmot_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicingmot_cell_Internalname, "Class", divPailicingmot_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV17Paibasetipo, "licencia") == 0 ) ) )
      {
         chkPaiLicMotObl.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicMotObl.getVisible(), 5, 0), true);
         divPailicmotobl_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicmotobl_cell_Internalname, "Class", divPailicmotobl_cell_Class, true);
      }
      else
      {
         chkPaiLicMotObl.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicMotObl.getVisible(), 5, 0), true);
         divPailicmotobl_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divPailicmotobl_cell_Internalname, "Class", divPailicmotobl_cell_Class, true);
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Paisbase_calculo" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15GF2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      paisbase_calculogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A1440PaiBaseClaseLeg = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
      A1441PaiBaseTipo = (String)getParm(obj,2,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
      A1442PaiBaseCod1 = (String)getParm(obj,3,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
      A1443PaiBaseCod2 = (String)getParm(obj,4,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
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
      paGF2( ) ;
      wsGF2( ) ;
      weGF2( ) ;
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
      sCtrlA1440PaiBaseClaseLeg = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlA1441PaiBaseTipo = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlA1442PaiBaseCod1 = (String)getParm(obj,3,TypeConstants.STRING) ;
      sCtrlA1443PaiBaseCod2 = (String)getParm(obj,4,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paGF2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "paisbase_calculogeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paGF2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1440PaiBaseClaseLeg = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
         A1441PaiBaseTipo = (String)getParm(obj,4,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
         A1442PaiBaseCod1 = (String)getParm(obj,5,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
         A1443PaiBaseCod2 = (String)getParm(obj,6,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
      }
      wcpOA46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1440PaiBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1440PaiBaseClaseLeg"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1441PaiBaseTipo = httpContext.cgiGet( sPrefix+"wcpOA1441PaiBaseTipo") ;
      wcpOA1442PaiBaseCod1 = httpContext.cgiGet( sPrefix+"wcpOA1442PaiBaseCod1") ;
      wcpOA1443PaiBaseCod2 = httpContext.cgiGet( sPrefix+"wcpOA1443PaiBaseCod2") ;
      if ( ! GetJustCreated( ) && ( ( A46PaiCod != wcpOA46PaiCod ) || ( A1440PaiBaseClaseLeg != wcpOA1440PaiBaseClaseLeg ) || ( GXutil.strcmp(A1441PaiBaseTipo, wcpOA1441PaiBaseTipo) != 0 ) || ( GXutil.strcmp(A1442PaiBaseCod1, wcpOA1442PaiBaseCod1) != 0 ) || ( GXutil.strcmp(A1443PaiBaseCod2, wcpOA1443PaiBaseCod2) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOA46PaiCod = A46PaiCod ;
      wcpOA1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
      wcpOA1441PaiBaseTipo = A1441PaiBaseTipo ;
      wcpOA1442PaiBaseCod1 = A1442PaiBaseCod1 ;
      wcpOA1443PaiBaseCod2 = A1443PaiBaseCod2 ;
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
      sCtrlA1440PaiBaseClaseLeg = httpContext.cgiGet( sPrefix+"A1440PaiBaseClaseLeg_CTRL") ;
      if ( GXutil.len( sCtrlA1440PaiBaseClaseLeg) > 0 )
      {
         A1440PaiBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( sCtrlA1440PaiBaseClaseLeg), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
      }
      else
      {
         A1440PaiBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1440PaiBaseClaseLeg_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlA1441PaiBaseTipo = httpContext.cgiGet( sPrefix+"A1441PaiBaseTipo_CTRL") ;
      if ( GXutil.len( sCtrlA1441PaiBaseTipo) > 0 )
      {
         A1441PaiBaseTipo = httpContext.cgiGet( sCtrlA1441PaiBaseTipo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
      }
      else
      {
         A1441PaiBaseTipo = httpContext.cgiGet( sPrefix+"A1441PaiBaseTipo_PARM") ;
      }
      sCtrlA1442PaiBaseCod1 = httpContext.cgiGet( sPrefix+"A1442PaiBaseCod1_CTRL") ;
      if ( GXutil.len( sCtrlA1442PaiBaseCod1) > 0 )
      {
         A1442PaiBaseCod1 = httpContext.cgiGet( sCtrlA1442PaiBaseCod1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
      }
      else
      {
         A1442PaiBaseCod1 = httpContext.cgiGet( sPrefix+"A1442PaiBaseCod1_PARM") ;
      }
      sCtrlA1443PaiBaseCod2 = httpContext.cgiGet( sPrefix+"A1443PaiBaseCod2_CTRL") ;
      if ( GXutil.len( sCtrlA1443PaiBaseCod2) > 0 )
      {
         A1443PaiBaseCod2 = httpContext.cgiGet( sCtrlA1443PaiBaseCod2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
      }
      else
      {
         A1443PaiBaseCod2 = httpContext.cgiGet( sPrefix+"A1443PaiBaseCod2_PARM") ;
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
      paGF2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsGF2( ) ;
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
      wsGF2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1440PaiBaseClaseLeg_PARM", GXutil.ltrim( localUtil.ntoc( A1440PaiBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1440PaiBaseClaseLeg)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1440PaiBaseClaseLeg_CTRL", GXutil.rtrim( sCtrlA1440PaiBaseClaseLeg));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1441PaiBaseTipo_PARM", GXutil.rtrim( A1441PaiBaseTipo));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1441PaiBaseTipo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1441PaiBaseTipo_CTRL", GXutil.rtrim( sCtrlA1441PaiBaseTipo));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1442PaiBaseCod1_PARM", GXutil.rtrim( A1442PaiBaseCod1));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1442PaiBaseCod1)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1442PaiBaseCod1_CTRL", GXutil.rtrim( sCtrlA1442PaiBaseCod1));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1443PaiBaseCod2_PARM", GXutil.rtrim( A1443PaiBaseCod2));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1443PaiBaseCod2)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1443PaiBaseCod2_CTRL", GXutil.rtrim( sCtrlA1443PaiBaseCod2));
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
      weGF2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025131761279", true, true);
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
      httpContext.AddJavascriptSource("paisbase_calculogeneral.js", "?2025131761279", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      cmbPaiBaseClaseLeg.setInternalname( sPrefix+"PAIBASECLASELEG" );
      cmbPaiBaseTipo.setInternalname( sPrefix+"PAIBASETIPO" );
      edtPaiBaseCod1_Internalname = sPrefix+"PAIBASECOD1" ;
      divPaibasecod1_cell_Internalname = sPrefix+"PAIBASECOD1_CELL" ;
      edtPaiBaseCod2_Internalname = sPrefix+"PAIBASECOD2" ;
      divPaibasecod2_cell_Internalname = sPrefix+"PAIBASECOD2_CELL" ;
      edtPaiBasePlus_Internalname = sPrefix+"PAIBASEPLUS" ;
      edtPaiLicDLim_Internalname = sPrefix+"PAILICDLIM" ;
      divPailicdlim_cell_Internalname = sPrefix+"PAILICDLIM_CELL" ;
      edtPaiLicDSeman_Internalname = sPrefix+"PAILICDSEMAN" ;
      divPailicdseman_cell_Internalname = sPrefix+"PAILICDSEMAN_CELL" ;
      edtPaiLicDMes_Internalname = sPrefix+"PAILICDMES" ;
      divPailicdmes_cell_Internalname = sPrefix+"PAILICDMES_CELL" ;
      edtPaiLicDSemes_Internalname = sPrefix+"PAILICDSEMES" ;
      divPailicdsemes_cell_Internalname = sPrefix+"PAILICDSEMES_CELL" ;
      edtPaiLicDAnual_Internalname = sPrefix+"PAILICDANUAL" ;
      divPailicdanual_cell_Internalname = sPrefix+"PAILICDANUAL_CELL" ;
      chkPaiLicAdju.setInternalname( sPrefix+"PAILICADJU" );
      divPailicadju_cell_Internalname = sPrefix+"PAILICADJU_CELL" ;
      chkPaiLicAdjuObl.setInternalname( sPrefix+"PAILICADJUOBL" );
      divPailicadjuobl_cell_Internalname = sPrefix+"PAILICADJUOBL_CELL" ;
      chkPaiLicNecAut.setInternalname( sPrefix+"PAILICNECAUT" );
      divPailicnecaut_cell_Internalname = sPrefix+"PAILICNECAUT_CELL" ;
      chkPaiLicIngMot.setInternalname( sPrefix+"PAILICINGMOT" );
      divPailicingmot_cell_Internalname = sPrefix+"PAILICINGMOT_CELL" ;
      chkPaiLicMotObl.setInternalname( sPrefix+"PAILICMOTOBL" );
      divPailicmotobl_cell_Internalname = sPrefix+"PAILICMOTOBL_CELL" ;
      edtPaiBasePromCnt1_Internalname = sPrefix+"PAIBASEPROMCNT1" ;
      edtPaiBasePromCnt2_Internalname = sPrefix+"PAIBASEPROMCNT2" ;
      cmbPaiBasePromTCnt.setInternalname( sPrefix+"PAIBASEPROMTCNT" );
      dynPaiBaseRelSec.setInternalname( sPrefix+"PAIBASERELSEC" );
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
      dynPaiBaseRelSec.setJsonclick( "" );
      dynPaiBaseRelSec.setEnabled( 0 );
      cmbPaiBasePromTCnt.setJsonclick( "" );
      cmbPaiBasePromTCnt.setEnabled( 0 );
      edtPaiBasePromCnt2_Jsonclick = "" ;
      edtPaiBasePromCnt2_Enabled = 0 ;
      edtPaiBasePromCnt1_Jsonclick = "" ;
      edtPaiBasePromCnt1_Enabled = 0 ;
      chkPaiLicMotObl.setEnabled( 0 );
      chkPaiLicMotObl.setVisible( 1 );
      divPailicmotobl_cell_Class = "col-xs-12" ;
      chkPaiLicIngMot.setEnabled( 0 );
      chkPaiLicIngMot.setVisible( 1 );
      divPailicingmot_cell_Class = "col-xs-12" ;
      chkPaiLicNecAut.setEnabled( 0 );
      chkPaiLicNecAut.setVisible( 1 );
      divPailicnecaut_cell_Class = "col-xs-12" ;
      chkPaiLicAdjuObl.setEnabled( 0 );
      chkPaiLicAdjuObl.setVisible( 1 );
      divPailicadjuobl_cell_Class = "col-xs-12" ;
      chkPaiLicAdju.setEnabled( 0 );
      chkPaiLicAdju.setVisible( 1 );
      divPailicadju_cell_Class = "col-xs-12" ;
      edtPaiLicDAnual_Jsonclick = "" ;
      edtPaiLicDAnual_Enabled = 0 ;
      edtPaiLicDAnual_Visible = 1 ;
      divPailicdanual_cell_Class = "col-xs-12" ;
      edtPaiLicDSemes_Jsonclick = "" ;
      edtPaiLicDSemes_Enabled = 0 ;
      edtPaiLicDSemes_Visible = 1 ;
      divPailicdsemes_cell_Class = "col-xs-12" ;
      edtPaiLicDMes_Jsonclick = "" ;
      edtPaiLicDMes_Enabled = 0 ;
      edtPaiLicDMes_Visible = 1 ;
      divPailicdmes_cell_Class = "col-xs-12" ;
      edtPaiLicDSeman_Jsonclick = "" ;
      edtPaiLicDSeman_Enabled = 0 ;
      edtPaiLicDSeman_Visible = 1 ;
      divPailicdseman_cell_Class = "col-xs-12" ;
      edtPaiLicDLim_Jsonclick = "" ;
      edtPaiLicDLim_Enabled = 0 ;
      edtPaiLicDLim_Visible = 1 ;
      divPailicdlim_cell_Class = "col-xs-12" ;
      edtPaiBasePlus_Jsonclick = "" ;
      edtPaiBasePlus_Enabled = 0 ;
      edtPaiBaseCod2_Jsonclick = "" ;
      edtPaiBaseCod2_Enabled = 0 ;
      edtPaiBaseCod2_Visible = 1 ;
      divPaibasecod2_cell_Class = "col-xs-12" ;
      edtPaiBaseCod1_Jsonclick = "" ;
      edtPaiBaseCod1_Enabled = 0 ;
      edtPaiBaseCod1_Visible = 1 ;
      divPaibasecod1_cell_Class = "col-xs-12" ;
      cmbPaiBaseTipo.setJsonclick( "" );
      cmbPaiBaseTipo.setEnabled( 0 );
      cmbPaiBaseClaseLeg.setJsonclick( "" );
      cmbPaiBaseClaseLeg.setEnabled( 0 );
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
      cmbPaiBaseClaseLeg.setName( "PAIBASECLASELEG" );
      cmbPaiBaseClaseLeg.setWebtags( "" );
      cmbPaiBaseClaseLeg.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbPaiBaseClaseLeg.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbPaiBaseClaseLeg.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbPaiBaseClaseLeg.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbPaiBaseClaseLeg.getItemCount() > 0 )
      {
      }
      cmbPaiBaseTipo.setName( "PAIBASETIPO" );
      cmbPaiBaseTipo.setWebtags( "" );
      cmbPaiBaseTipo.addItem("licencia", httpContext.getMessage( "Licencia", ""), (short)(0));
      cmbPaiBaseTipo.addItem("feriado", httpContext.getMessage( "Feriado/No laborable", ""), (short)(0));
      cmbPaiBaseTipo.addItem("horaNormal", httpContext.getMessage( "Hora Normal", ""), (short)(0));
      if ( cmbPaiBaseTipo.getItemCount() > 0 )
      {
      }
      chkPaiLicAdju.setName( "PAILICADJU" );
      chkPaiLicAdju.setWebtags( "" );
      chkPaiLicAdju.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicAdju.getInternalname(), "TitleCaption", chkPaiLicAdju.getCaption(), true);
      chkPaiLicAdju.setCheckedValue( "false" );
      chkPaiLicAdjuObl.setName( "PAILICADJUOBL" );
      chkPaiLicAdjuObl.setWebtags( "" );
      chkPaiLicAdjuObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicAdjuObl.getInternalname(), "TitleCaption", chkPaiLicAdjuObl.getCaption(), true);
      chkPaiLicAdjuObl.setCheckedValue( "false" );
      chkPaiLicNecAut.setName( "PAILICNECAUT" );
      chkPaiLicNecAut.setWebtags( "" );
      chkPaiLicNecAut.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicNecAut.getInternalname(), "TitleCaption", chkPaiLicNecAut.getCaption(), true);
      chkPaiLicNecAut.setCheckedValue( "false" );
      chkPaiLicIngMot.setName( "PAILICINGMOT" );
      chkPaiLicIngMot.setWebtags( "" );
      chkPaiLicIngMot.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicIngMot.getInternalname(), "TitleCaption", chkPaiLicIngMot.getCaption(), true);
      chkPaiLicIngMot.setCheckedValue( "false" );
      chkPaiLicMotObl.setName( "PAILICMOTOBL" );
      chkPaiLicMotObl.setWebtags( "" );
      chkPaiLicMotObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiLicMotObl.getInternalname(), "TitleCaption", chkPaiLicMotObl.getCaption(), true);
      chkPaiLicMotObl.setCheckedValue( "false" );
      cmbPaiBasePromTCnt.setName( "PAIBASEPROMTCNT" );
      cmbPaiBasePromTCnt.setWebtags( "" );
      cmbPaiBasePromTCnt.addItem("dias", httpContext.getMessage( "días", ""), (short)(0));
      cmbPaiBasePromTCnt.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
      if ( cmbPaiBasePromTCnt.getItemCount() > 0 )
      {
      }
      dynPaiBaseRelSec.setName( "PAIBASERELSEC" );
      dynPaiBaseRelSec.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'cmbPaiBaseClaseLeg'},{av:'A1440PaiBaseClaseLeg',fld:'PAIBASECLASELEG',pic:'9'},{av:'cmbPaiBaseTipo'},{av:'A1441PaiBaseTipo',fld:'PAIBASETIPO',pic:''},{av:'A1442PaiBaseCod1',fld:'PAIBASECOD1',pic:''},{av:'A1443PaiBaseCod2',fld:'PAIBASECOD2',pic:''},{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11GF1',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'cmbPaiBaseClaseLeg'},{av:'A1440PaiBaseClaseLeg',fld:'PAIBASECLASELEG',pic:'9'},{av:'cmbPaiBaseTipo'},{av:'A1441PaiBaseTipo',fld:'PAIBASETIPO',pic:''},{av:'A1442PaiBaseCod1',fld:'PAIBASECOD1',pic:''},{av:'A1443PaiBaseCod2',fld:'PAIBASECOD2',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12GF1',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'cmbPaiBaseClaseLeg'},{av:'A1440PaiBaseClaseLeg',fld:'PAIBASECLASELEG',pic:'9'},{av:'cmbPaiBaseTipo'},{av:'A1441PaiBaseTipo',fld:'PAIBASETIPO',pic:''},{av:'A1442PaiBaseCod1',fld:'PAIBASECOD1',pic:''},{av:'A1443PaiBaseCod2',fld:'PAIBASECOD2',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_PAIBASECLASELEG","{handler:'valid_Paibaseclaseleg',iparms:[]");
      setEventMetadata("VALID_PAIBASECLASELEG",",oparms:[]}");
      setEventMetadata("VALID_PAIBASETIPO","{handler:'valid_Paibasetipo',iparms:[]");
      setEventMetadata("VALID_PAIBASETIPO",",oparms:[]}");
      setEventMetadata("VALID_PAIBASECOD1","{handler:'valid_Paibasecod1',iparms:[]");
      setEventMetadata("VALID_PAIBASECOD1",",oparms:[]}");
      setEventMetadata("VALID_PAIBASECOD2","{handler:'valid_Paibasecod2',iparms:[]");
      setEventMetadata("VALID_PAIBASECOD2",",oparms:[]}");
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
      wcpOA1441PaiBaseTipo = "" ;
      wcpOA1442PaiBaseCod1 = "" ;
      wcpOA1443PaiBaseCod2 = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A1441PaiBaseTipo = "" ;
      A1442PaiBaseCod1 = "" ;
      A1443PaiBaseCod2 = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A1444PaiBasePlus = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      A1453PaiBasePromTCnt = "" ;
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
      H00GF2_A1885CliRelSec = new int[1] ;
      H00GF2_A1880CliReDTChar = new String[] {""} ;
      H00GF2_A3CliCod = new int[1] ;
      AV18Pgmname = "" ;
      H00GF3_A46PaiCod = new short[1] ;
      H00GF3_A1440PaiBaseClaseLeg = new byte[1] ;
      H00GF3_A1441PaiBaseTipo = new String[] {""} ;
      H00GF3_A1442PaiBaseCod1 = new String[] {""} ;
      H00GF3_A1443PaiBaseCod2 = new String[] {""} ;
      H00GF3_A2053PaiBaseRelSec = new int[1] ;
      H00GF3_A1453PaiBasePromTCnt = new String[] {""} ;
      H00GF3_A1452PaiBasePromCnt2 = new short[1] ;
      H00GF3_A1451PaiBasePromCnt1 = new short[1] ;
      H00GF3_A1638PaiLicMotObl = new boolean[] {false} ;
      H00GF3_A1637PaiLicIngMot = new boolean[] {false} ;
      H00GF3_A1636PaiLicNecAut = new boolean[] {false} ;
      H00GF3_A1635PaiLicAdjuObl = new boolean[] {false} ;
      H00GF3_A1634PaiLicAdju = new boolean[] {false} ;
      H00GF3_A1633PaiLicDAnual = new short[1] ;
      H00GF3_A1632PaiLicDSemes = new short[1] ;
      H00GF3_A1631PaiLicDMes = new byte[1] ;
      H00GF3_A1630PaiLicDSeman = new byte[1] ;
      H00GF3_A1629PaiLicDLim = new short[1] ;
      H00GF3_A1444PaiBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV17Paibasetipo = "" ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA46PaiCod = "" ;
      sCtrlA1440PaiBaseClaseLeg = "" ;
      sCtrlA1441PaiBaseTipo = "" ;
      sCtrlA1442PaiBaseCod1 = "" ;
      sCtrlA1443PaiBaseCod2 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisbase_calculogeneral__default(),
         new Object[] {
             new Object[] {
            H00GF2_A1885CliRelSec, H00GF2_A1880CliReDTChar, H00GF2_A3CliCod
            }
            , new Object[] {
            H00GF3_A46PaiCod, H00GF3_A1440PaiBaseClaseLeg, H00GF3_A1441PaiBaseTipo, H00GF3_A1442PaiBaseCod1, H00GF3_A1443PaiBaseCod2, H00GF3_A2053PaiBaseRelSec, H00GF3_A1453PaiBasePromTCnt, H00GF3_A1452PaiBasePromCnt2, H00GF3_A1451PaiBasePromCnt1, H00GF3_A1638PaiLicMotObl,
            H00GF3_A1637PaiLicIngMot, H00GF3_A1636PaiLicNecAut, H00GF3_A1635PaiLicAdjuObl, H00GF3_A1634PaiLicAdju, H00GF3_A1633PaiLicDAnual, H00GF3_A1632PaiLicDSemes, H00GF3_A1631PaiLicDMes, H00GF3_A1630PaiLicDSeman, H00GF3_A1629PaiLicDLim, H00GF3_A1444PaiBasePlus
            }
         }
      );
      AV18Pgmname = "Paisbase_calculoGeneral" ;
      /* GeneXus formulas. */
      AV18Pgmname = "Paisbase_calculoGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte wcpOA1440PaiBaseClaseLeg ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A1440PaiBaseClaseLeg ;
   private byte A1630PaiLicDSeman ;
   private byte A1631PaiLicDMes ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA46PaiCod ;
   private short A46PaiCod ;
   private short wbEnd ;
   private short wbStart ;
   private short A1629PaiLicDLim ;
   private short A1632PaiLicDSemes ;
   private short A1633PaiLicDAnual ;
   private short A1451PaiBasePromCnt1 ;
   private short A1452PaiBasePromCnt2 ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int edtPaiBaseCod1_Visible ;
   private int edtPaiBaseCod1_Enabled ;
   private int edtPaiBaseCod2_Visible ;
   private int edtPaiBaseCod2_Enabled ;
   private int edtPaiBasePlus_Enabled ;
   private int edtPaiLicDLim_Visible ;
   private int edtPaiLicDLim_Enabled ;
   private int edtPaiLicDSeman_Visible ;
   private int edtPaiLicDSeman_Enabled ;
   private int edtPaiLicDMes_Visible ;
   private int edtPaiLicDMes_Enabled ;
   private int edtPaiLicDSemes_Visible ;
   private int edtPaiLicDSemes_Enabled ;
   private int edtPaiLicDAnual_Visible ;
   private int edtPaiLicDAnual_Enabled ;
   private int edtPaiBasePromCnt1_Enabled ;
   private int edtPaiBasePromCnt2_Enabled ;
   private int A2053PaiBaseRelSec ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtPaiCod_Visible ;
   private int gxdynajaxindex ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private java.math.BigDecimal A1444PaiBasePlus ;
   private String wcpOA1441PaiBaseTipo ;
   private String wcpOA1442PaiBaseCod1 ;
   private String wcpOA1443PaiBaseCod2 ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A1441PaiBaseTipo ;
   private String A1442PaiBaseCod1 ;
   private String A1443PaiBaseCod2 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String divPaibasecod1_cell_Internalname ;
   private String divPaibasecod1_cell_Class ;
   private String edtPaiBaseCod1_Internalname ;
   private String edtPaiBaseCod1_Jsonclick ;
   private String divPaibasecod2_cell_Internalname ;
   private String divPaibasecod2_cell_Class ;
   private String edtPaiBaseCod2_Internalname ;
   private String edtPaiBaseCod2_Jsonclick ;
   private String edtPaiBasePlus_Internalname ;
   private String edtPaiBasePlus_Jsonclick ;
   private String divPailicdlim_cell_Internalname ;
   private String divPailicdlim_cell_Class ;
   private String edtPaiLicDLim_Internalname ;
   private String edtPaiLicDLim_Jsonclick ;
   private String divPailicdseman_cell_Internalname ;
   private String divPailicdseman_cell_Class ;
   private String edtPaiLicDSeman_Internalname ;
   private String edtPaiLicDSeman_Jsonclick ;
   private String divPailicdmes_cell_Internalname ;
   private String divPailicdmes_cell_Class ;
   private String edtPaiLicDMes_Internalname ;
   private String edtPaiLicDMes_Jsonclick ;
   private String divPailicdsemes_cell_Internalname ;
   private String divPailicdsemes_cell_Class ;
   private String edtPaiLicDSemes_Internalname ;
   private String edtPaiLicDSemes_Jsonclick ;
   private String divPailicdanual_cell_Internalname ;
   private String divPailicdanual_cell_Class ;
   private String edtPaiLicDAnual_Internalname ;
   private String edtPaiLicDAnual_Jsonclick ;
   private String divPailicadju_cell_Internalname ;
   private String divPailicadju_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String divPailicadjuobl_cell_Internalname ;
   private String divPailicadjuobl_cell_Class ;
   private String divPailicnecaut_cell_Internalname ;
   private String divPailicnecaut_cell_Class ;
   private String divPailicingmot_cell_Internalname ;
   private String divPailicingmot_cell_Class ;
   private String divPailicmotobl_cell_Internalname ;
   private String divPailicmotobl_cell_Class ;
   private String edtPaiBasePromCnt1_Internalname ;
   private String edtPaiBasePromCnt1_Jsonclick ;
   private String edtPaiBasePromCnt2_Internalname ;
   private String edtPaiBasePromCnt2_Jsonclick ;
   private String A1453PaiBasePromTCnt ;
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
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV18Pgmname ;
   private String AV17Paibasetipo ;
   private String sCtrlA46PaiCod ;
   private String sCtrlA1440PaiBaseClaseLeg ;
   private String sCtrlA1441PaiBaseTipo ;
   private String sCtrlA1442PaiBaseCod1 ;
   private String sCtrlA1443PaiBaseCod2 ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A1634PaiLicAdju ;
   private boolean A1635PaiLicAdjuObl ;
   private boolean A1636PaiLicNecAut ;
   private boolean A1637PaiLicIngMot ;
   private boolean A1638PaiLicMotObl ;
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
   private HTMLChoice cmbPaiBaseClaseLeg ;
   private HTMLChoice cmbPaiBaseTipo ;
   private ICheckbox chkPaiLicAdju ;
   private ICheckbox chkPaiLicAdjuObl ;
   private ICheckbox chkPaiLicNecAut ;
   private ICheckbox chkPaiLicIngMot ;
   private ICheckbox chkPaiLicMotObl ;
   private HTMLChoice cmbPaiBasePromTCnt ;
   private HTMLChoice dynPaiBaseRelSec ;
   private IDataStoreProvider pr_default ;
   private int[] H00GF2_A1885CliRelSec ;
   private String[] H00GF2_A1880CliReDTChar ;
   private int[] H00GF2_A3CliCod ;
   private short[] H00GF3_A46PaiCod ;
   private byte[] H00GF3_A1440PaiBaseClaseLeg ;
   private String[] H00GF3_A1441PaiBaseTipo ;
   private String[] H00GF3_A1442PaiBaseCod1 ;
   private String[] H00GF3_A1443PaiBaseCod2 ;
   private int[] H00GF3_A2053PaiBaseRelSec ;
   private String[] H00GF3_A1453PaiBasePromTCnt ;
   private short[] H00GF3_A1452PaiBasePromCnt2 ;
   private short[] H00GF3_A1451PaiBasePromCnt1 ;
   private boolean[] H00GF3_A1638PaiLicMotObl ;
   private boolean[] H00GF3_A1637PaiLicIngMot ;
   private boolean[] H00GF3_A1636PaiLicNecAut ;
   private boolean[] H00GF3_A1635PaiLicAdjuObl ;
   private boolean[] H00GF3_A1634PaiLicAdju ;
   private short[] H00GF3_A1633PaiLicDAnual ;
   private short[] H00GF3_A1632PaiLicDSemes ;
   private byte[] H00GF3_A1631PaiLicDMes ;
   private byte[] H00GF3_A1630PaiLicDSeman ;
   private short[] H00GF3_A1629PaiLicDLim ;
   private java.math.BigDecimal[] H00GF3_A1444PaiBasePlus ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class paisbase_calculogeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00GF2", "SELECT CliRelSec, CliReDTChar, CliCod FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00GF3", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseRelSec, PaiBasePromTCnt, PaiBasePromCnt2, PaiBasePromCnt1, PaiLicMotObl, PaiLicIngMot, PaiLicNecAut, PaiLicAdjuObl, PaiLicAdju, PaiLicDAnual, PaiLicDSemes, PaiLicDMes, PaiLicDSeman, PaiLicDLim, PaiBasePlus FROM Paisbase_calculo WHERE PaiCod = ? and PaiBaseClaseLeg = ? and PaiBaseTipo = ( ?) and PaiBaseCod1 = ( ?) and PaiBaseCod2 = ( ?) ORDER BY PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((byte[]) buf[17])[0] = rslt.getByte(18);
               ((short[]) buf[18])[0] = rslt.getShort(19);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,4);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
      }
   }

}

