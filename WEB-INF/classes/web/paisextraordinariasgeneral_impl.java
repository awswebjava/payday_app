package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class paisextraordinariasgeneral_impl extends GXWebComponent
{
   public paisextraordinariasgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public paisextraordinariasgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisextraordinariasgeneral_impl.class ));
   }

   public paisextraordinariasgeneral_impl( int remoteHandle ,
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
      dynPaiHsPDiaTipTra = new HTMLChoice();
      cmbPaiHsPDiaDia = new HTMLChoice();
      cmbPaiTarifaPDCri = new HTMLChoice();
      dynPaiExtraordRelSec = new HTMLChoice();
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
               A1332PaiHsExSec = (short)(GXutil.lval( httpContext.GetPar( "PaiHsExSec"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(A46PaiCod),Short.valueOf(A1332PaiHsExSec)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"PAIEXTRAORDRELSEC") == 0 )
            {
               AV14CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlapaiextraordrelsecJA2( AV14CliCod) ;
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
         paJA2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Pais Extraordinarias General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.paisextraordinariasgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A46PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1332PaiHsExSec,4,0))}, new String[] {"PaiCod","PaiHsExSec"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1332PaiHsExSec", GXutil.ltrim( localUtil.ntoc( wcpOA1332PaiHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV14CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormJA2( )
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
      return "PaisExtraordinariasGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Pais Extraordinarias General", "") ;
   }

   public void wbJA0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.paisextraordinariasgeneral");
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
         web.GxWebStd.gx_label_element( httpContext, edtPaiCod_Internalname, httpContext.getMessage( "Pais", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_PaisExtraordinariasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiHsExSec_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiHsExSec_Internalname, httpContext.getMessage( "Secuencial", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiHsExSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1332PaiHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiHsExSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1332PaiHsExSec), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1332PaiHsExSec), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiHsExSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiHsExSec_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisExtraordinariasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynPaiHsPDiaTipTra.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynPaiHsPDiaTipTra.getInternalname(), httpContext.getMessage( "Tipo de trabajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynPaiHsPDiaTipTra, dynPaiHsPDiaTipTra.getInternalname(), GXutil.rtrim( A1331PaiHsPDiaTipTra), 1, dynPaiHsPDiaTipTra.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, dynPaiHsPDiaTipTra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_PaisExtraordinariasGeneral.htm");
         dynPaiHsPDiaTipTra.setValue( GXutil.rtrim( A1331PaiHsPDiaTipTra) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynPaiHsPDiaTipTra.getInternalname(), "Values", dynPaiHsPDiaTipTra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiHsPDiaDia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbPaiHsPDiaDia.getInternalname(), httpContext.getMessage( "Día", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiHsPDiaDia, cmbPaiHsPDiaDia.getInternalname(), GXutil.trim( GXutil.str( A1333PaiHsPDiaDia, 1, 0)), 1, cmbPaiHsPDiaDia.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbPaiHsPDiaDia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_PaisExtraordinariasGeneral.htm");
         cmbPaiHsPDiaDia.setValue( GXutil.trim( GXutil.str( A1333PaiHsPDiaDia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiHsPDiaDia.getInternalname(), "Values", cmbPaiHsPDiaDia.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiHsPDiaDesde_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiHsPDiaDesde_Internalname, httpContext.getMessage( "Hora desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiHsPDiaDesde_Internalname, GXutil.rtrim( A1334PaiHsPDiaDesde), GXutil.rtrim( localUtil.format( A1334PaiHsPDiaDesde, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiHsPDiaDesde_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiHsPDiaDesde_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PaisExtraordinariasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTarifaPDia_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiTarifaPDia_Internalname, httpContext.getMessage( "Aumento de horas extras sobre hora normal", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTarifaPDia_Internalname, GXutil.ltrim( localUtil.ntoc( A1335PaiTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTarifaPDia_Enabled!=0) ? localUtil.format( A1335PaiTarifaPDia, "9.9999") : localUtil.format( A1335PaiTarifaPDia, "9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTarifaPDia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTarifaPDia_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_PaisExtraordinariasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTarifaPDRec_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiTarifaPDRec_Internalname, httpContext.getMessage( "Recargo a hora normal diurna", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTarifaPDRec_Internalname, GXutil.ltrim( localUtil.ntoc( A1348PaiTarifaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTarifaPDRec_Enabled!=0) ? localUtil.format( A1348PaiTarifaPDRec, "9.9999") : localUtil.format( A1348PaiTarifaPDRec, "9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTarifaPDRec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTarifaPDRec_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_PaisExtraordinariasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiTarifaPDCri.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbPaiTarifaPDCri.getInternalname(), httpContext.getMessage( "Criterio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiTarifaPDCri, cmbPaiTarifaPDCri.getInternalname(), GXutil.rtrim( A2434PaiTarifaPDCri), 1, cmbPaiTarifaPDCri.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPaiTarifaPDCri.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_PaisExtraordinariasGeneral.htm");
         cmbPaiTarifaPDCri.setValue( GXutil.rtrim( A2434PaiTarifaPDCri) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiTarifaPDCri.getInternalname(), "Values", cmbPaiTarifaPDCri.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynPaiExtraordRelSec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynPaiExtraordRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynPaiExtraordRelSec, dynPaiExtraordRelSec.getInternalname(), GXutil.trim( GXutil.str( A2057PaiExtraordRelSec, 6, 0)), 1, dynPaiExtraordRelSec.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynPaiExtraordRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_PaisExtraordinariasGeneral.htm");
         dynPaiExtraordRelSec.setValue( GXutil.trim( GXutil.str( A2057PaiExtraordRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynPaiExtraordRelSec.getInternalname(), "Values", dynPaiExtraordRelSec.ToJavascriptSource(), true);
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
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11ja1_client"+"'", TempTags, "", 2, "HLP_PaisExtraordinariasGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12ja1_client"+"'", TempTags, "", 2, "HLP_PaisExtraordinariasGeneral.htm");
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

   public void startJA2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Pais Extraordinarias General", ""), (short)(0)) ;
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
            strupJA0( ) ;
         }
      }
   }

   public void wsJA2( )
   {
      startJA2( ) ;
      evtJA2( ) ;
   }

   public void evtJA2( )
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
                              strupJA0( ) ;
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
                              strupJA0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13JA2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJA0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14JA2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJA0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15JA2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupJA0( ) ;
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
                              strupJA0( ) ;
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

   public void weJA2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormJA2( ) ;
         }
      }
   }

   public void paJA2( )
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

   public void gxdlapaihspdiatiptraJA1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlapaihspdiatiptra_dataJA1( ) ;
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

   public void gxapaihspdiatiptra_htmlJA1( )
   {
      String gxdynajaxvalue;
      gxdlapaihspdiatiptra_dataJA1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynPaiHsPDiaTipTra.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynPaiHsPDiaTipTra.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynPaiHsPDiaTipTra.getItemCount() > 0 )
      {
         A1331PaiHsPDiaTipTra = dynPaiHsPDiaTipTra.getValidValue(A1331PaiHsPDiaTipTra) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
      }
   }

   protected void gxdlapaihspdiatiptra_dataJA1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00JA2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00JA2_A1292TipoTraId[0]));
         gxdynajaxctrldescr.add(H00JA2_A1293TipoTraNom[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlapaiextraordrelsecJA2( int AV14CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlapaiextraordrelsec_dataJA2( AV14CliCod) ;
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

   public void gxapaiextraordrelsec_htmlJA2( int AV14CliCod )
   {
      int gxdynajaxvalue;
      gxdlapaiextraordrelsec_dataJA2( AV14CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynPaiExtraordRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynPaiExtraordRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlapaiextraordrelsec_dataJA2( int AV14CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00JA3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV14CliCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00JA3_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00JA3_A1880CliReDTChar[0]);
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
         dynPaiHsPDiaTipTra.setName( "PAIHSPDIATIPTRA" );
         dynPaiHsPDiaTipTra.setWebtags( "" );
         dynPaiHsPDiaTipTra.removeAllItems();
         /* Using cursor H00JA4 */
         pr_default.execute(2);
         while ( (pr_default.getStatus(2) != 101) )
         {
            dynPaiHsPDiaTipTra.addItem(H00JA4_A1292TipoTraId[0], H00JA4_A1293TipoTraNom[0], (short)(0));
            pr_default.readNext(2);
         }
         pr_default.close(2);
         if ( dynPaiHsPDiaTipTra.getItemCount() > 0 )
         {
            A1331PaiHsPDiaTipTra = dynPaiHsPDiaTipTra.getValidValue(A1331PaiHsPDiaTipTra) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynPaiHsPDiaTipTra.getItemCount() > 0 )
      {
         A1331PaiHsPDiaTipTra = dynPaiHsPDiaTipTra.getValidValue(A1331PaiHsPDiaTipTra) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPaiHsPDiaTipTra.setValue( GXutil.rtrim( A1331PaiHsPDiaTipTra) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynPaiHsPDiaTipTra.getInternalname(), "Values", dynPaiHsPDiaTipTra.ToJavascriptSource(), true);
      }
      if ( cmbPaiHsPDiaDia.getItemCount() > 0 )
      {
         A1333PaiHsPDiaDia = (byte)(GXutil.lval( cmbPaiHsPDiaDia.getValidValue(GXutil.trim( GXutil.str( A1333PaiHsPDiaDia, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1333PaiHsPDiaDia", GXutil.str( A1333PaiHsPDiaDia, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiHsPDiaDia.setValue( GXutil.trim( GXutil.str( A1333PaiHsPDiaDia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiHsPDiaDia.getInternalname(), "Values", cmbPaiHsPDiaDia.ToJavascriptSource(), true);
      }
      if ( cmbPaiTarifaPDCri.getItemCount() > 0 )
      {
         A2434PaiTarifaPDCri = cmbPaiTarifaPDCri.getValidValue(A2434PaiTarifaPDCri) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2434PaiTarifaPDCri", A2434PaiTarifaPDCri);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiTarifaPDCri.setValue( GXutil.rtrim( A2434PaiTarifaPDCri) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiTarifaPDCri.getInternalname(), "Values", cmbPaiTarifaPDCri.ToJavascriptSource(), true);
      }
      if ( dynPaiExtraordRelSec.getItemCount() > 0 )
      {
         A2057PaiExtraordRelSec = (int)(GXutil.lval( dynPaiExtraordRelSec.getValidValue(GXutil.trim( GXutil.str( A2057PaiExtraordRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2057PaiExtraordRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2057PaiExtraordRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPaiExtraordRelSec.setValue( GXutil.trim( GXutil.str( A2057PaiExtraordRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynPaiExtraordRelSec.getInternalname(), "Values", dynPaiExtraordRelSec.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfJA2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV20Pgmname = "PaisExtraordinariasGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rfJA2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15JA2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00JA5 */
         pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A2057PaiExtraordRelSec = H00JA5_A2057PaiExtraordRelSec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2057PaiExtraordRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2057PaiExtraordRelSec), 6, 0));
            A2434PaiTarifaPDCri = H00JA5_A2434PaiTarifaPDCri[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2434PaiTarifaPDCri", A2434PaiTarifaPDCri);
            A1348PaiTarifaPDRec = H00JA5_A1348PaiTarifaPDRec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1348PaiTarifaPDRec", GXutil.ltrimstr( A1348PaiTarifaPDRec, 6, 4));
            A1335PaiTarifaPDia = H00JA5_A1335PaiTarifaPDia[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1335PaiTarifaPDia", GXutil.ltrimstr( A1335PaiTarifaPDia, 6, 4));
            A1334PaiHsPDiaDesde = H00JA5_A1334PaiHsPDiaDesde[0] ;
            n1334PaiHsPDiaDesde = H00JA5_n1334PaiHsPDiaDesde[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1334PaiHsPDiaDesde", A1334PaiHsPDiaDesde);
            A1333PaiHsPDiaDia = H00JA5_A1333PaiHsPDiaDia[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1333PaiHsPDiaDia", GXutil.str( A1333PaiHsPDiaDia, 1, 0));
            A1331PaiHsPDiaTipTra = H00JA5_A1331PaiHsPDiaTipTra[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
            /* Execute user event: Load */
            e14JA2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(3);
         wbJA0( ) ;
      }
   }

   public void send_integrity_lvl_hashesJA2( )
   {
   }

   public void before_start_formulas( )
   {
      AV20Pgmname = "PaisExtraordinariasGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupJA0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13JA2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1332PaiHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1332PaiHsExSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         dynPaiHsPDiaTipTra.setValue( httpContext.cgiGet( dynPaiHsPDiaTipTra.getInternalname()) );
         A1331PaiHsPDiaTipTra = httpContext.cgiGet( dynPaiHsPDiaTipTra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
         cmbPaiHsPDiaDia.setValue( httpContext.cgiGet( cmbPaiHsPDiaDia.getInternalname()) );
         A1333PaiHsPDiaDia = (byte)(GXutil.lval( httpContext.cgiGet( cmbPaiHsPDiaDia.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1333PaiHsPDiaDia", GXutil.str( A1333PaiHsPDiaDia, 1, 0));
         A1334PaiHsPDiaDesde = httpContext.cgiGet( edtPaiHsPDiaDesde_Internalname) ;
         n1334PaiHsPDiaDesde = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1334PaiHsPDiaDesde", A1334PaiHsPDiaDesde);
         A1335PaiTarifaPDia = localUtil.ctond( httpContext.cgiGet( edtPaiTarifaPDia_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1335PaiTarifaPDia", GXutil.ltrimstr( A1335PaiTarifaPDia, 6, 4));
         A1348PaiTarifaPDRec = localUtil.ctond( httpContext.cgiGet( edtPaiTarifaPDRec_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1348PaiTarifaPDRec", GXutil.ltrimstr( A1348PaiTarifaPDRec, 6, 4));
         cmbPaiTarifaPDCri.setValue( httpContext.cgiGet( cmbPaiTarifaPDCri.getInternalname()) );
         A2434PaiTarifaPDCri = httpContext.cgiGet( cmbPaiTarifaPDCri.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2434PaiTarifaPDCri", A2434PaiTarifaPDCri);
         dynPaiExtraordRelSec.setValue( httpContext.cgiGet( dynPaiExtraordRelSec.getInternalname()) );
         A2057PaiExtraordRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynPaiExtraordRelSec.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2057PaiExtraordRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2057PaiExtraordRelSec), 6, 0));
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
      e13JA2 ();
      if (returnInSub) return;
   }

   public void e13JA2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      paisextraordinariasgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
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

   protected void e14JA2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean4 = AV13TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisExtraordinarias_Update", GXv_boolean5) ;
      paisextraordinariasgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV13TempBoolean = GXt_boolean4 ;
      if ( ! ( AV13TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV13TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisExtraordinarias_Delete", GXv_boolean5) ;
      paisextraordinariasgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV13TempBoolean = GXt_boolean4 ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "PaisExtraordinarias" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15JA2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      paisextraordinariasgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A1332PaiHsExSec = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
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
      paJA2( ) ;
      wsJA2( ) ;
      weJA2( ) ;
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
      sCtrlA1332PaiHsExSec = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paJA2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "paisextraordinariasgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paJA2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1332PaiHsExSec = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
      }
      wcpOA46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1332PaiHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1332PaiHsExSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A46PaiCod != wcpOA46PaiCod ) || ( A1332PaiHsExSec != wcpOA1332PaiHsExSec ) ) )
      {
         setjustcreated();
      }
      wcpOA46PaiCod = A46PaiCod ;
      wcpOA1332PaiHsExSec = A1332PaiHsExSec ;
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
      sCtrlA1332PaiHsExSec = httpContext.cgiGet( sPrefix+"A1332PaiHsExSec_CTRL") ;
      if ( GXutil.len( sCtrlA1332PaiHsExSec) > 0 )
      {
         A1332PaiHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA1332PaiHsExSec), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
      }
      else
      {
         A1332PaiHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1332PaiHsExSec_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paJA2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsJA2( ) ;
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
      wsJA2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1332PaiHsExSec_PARM", GXutil.ltrim( localUtil.ntoc( A1332PaiHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1332PaiHsExSec)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1332PaiHsExSec_CTRL", GXutil.rtrim( sCtrlA1332PaiHsExSec));
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
      weJA2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251818313986", true, true);
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
      httpContext.AddJavascriptSource("paisextraordinariasgeneral.js", "?20251818313987", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtPaiCod_Internalname = sPrefix+"PAICOD" ;
      edtPaiHsExSec_Internalname = sPrefix+"PAIHSEXSEC" ;
      dynPaiHsPDiaTipTra.setInternalname( sPrefix+"PAIHSPDIATIPTRA" );
      cmbPaiHsPDiaDia.setInternalname( sPrefix+"PAIHSPDIADIA" );
      edtPaiHsPDiaDesde_Internalname = sPrefix+"PAIHSPDIADESDE" ;
      edtPaiTarifaPDia_Internalname = sPrefix+"PAITARIFAPDIA" ;
      edtPaiTarifaPDRec_Internalname = sPrefix+"PAITARIFAPDREC" ;
      cmbPaiTarifaPDCri.setInternalname( sPrefix+"PAITARIFAPDCRI" );
      dynPaiExtraordRelSec.setInternalname( sPrefix+"PAIEXTRAORDRELSEC" );
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
      dynPaiExtraordRelSec.setJsonclick( "" );
      dynPaiExtraordRelSec.setEnabled( 0 );
      cmbPaiTarifaPDCri.setJsonclick( "" );
      cmbPaiTarifaPDCri.setEnabled( 0 );
      edtPaiTarifaPDRec_Jsonclick = "" ;
      edtPaiTarifaPDRec_Enabled = 0 ;
      edtPaiTarifaPDia_Jsonclick = "" ;
      edtPaiTarifaPDia_Enabled = 0 ;
      edtPaiHsPDiaDesde_Jsonclick = "" ;
      edtPaiHsPDiaDesde_Enabled = 0 ;
      cmbPaiHsPDiaDia.setJsonclick( "" );
      cmbPaiHsPDiaDia.setEnabled( 0 );
      dynPaiHsPDiaTipTra.setJsonclick( "" );
      dynPaiHsPDiaTipTra.setEnabled( 0 );
      edtPaiHsExSec_Jsonclick = "" ;
      edtPaiHsExSec_Enabled = 0 ;
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
      dynPaiHsPDiaTipTra.setName( "PAIHSPDIATIPTRA" );
      dynPaiHsPDiaTipTra.setWebtags( "" );
      dynPaiHsPDiaTipTra.removeAllItems();
      /* Using cursor H00JA6 */
      pr_default.execute(4);
      while ( (pr_default.getStatus(4) != 101) )
      {
         dynPaiHsPDiaTipTra.addItem(H00JA6_A1292TipoTraId[0], H00JA6_A1293TipoTraNom[0], (short)(0));
         pr_default.readNext(4);
      }
      pr_default.close(4);
      if ( dynPaiHsPDiaTipTra.getItemCount() > 0 )
      {
      }
      cmbPaiHsPDiaDia.setName( "PAIHSPDIADIA" );
      cmbPaiHsPDiaDia.setWebtags( "" );
      cmbPaiHsPDiaDia.addItem("1", httpContext.getMessage( "Domingo", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("2", httpContext.getMessage( "Lunes", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("3", httpContext.getMessage( "Martes", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("4", httpContext.getMessage( "Miércoles", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("5", httpContext.getMessage( "Jueves", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("6", httpContext.getMessage( "Viernes", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("7", httpContext.getMessage( "Sábado", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("8", httpContext.getMessage( "Feriado", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("9", httpContext.getMessage( "Día hábil no especificado", ""), (short)(0));
      if ( cmbPaiHsPDiaDia.getItemCount() > 0 )
      {
      }
      cmbPaiTarifaPDCri.setName( "PAITARIFAPDCRI" );
      cmbPaiTarifaPDCri.setWebtags( "" );
      cmbPaiTarifaPDCri.addItem("exceso", httpContext.getMessage( "Por exceder las horas normales", ""), (short)(0));
      cmbPaiTarifaPDCri.addItem("horario", httpContext.getMessage( "Por fecha y horario determinado", ""), (short)(0));
      if ( cmbPaiTarifaPDCri.getItemCount() > 0 )
      {
      }
      dynPaiExtraordRelSec.setName( "PAIEXTRAORDRELSEC" );
      dynPaiExtraordRelSec.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A1332PaiHsExSec',fld:'PAIHSEXSEC',pic:'ZZZ9'},{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11JA1',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A1332PaiHsExSec',fld:'PAIHSEXSEC',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12JA1',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A1332PaiHsExSec',fld:'PAIHSEXSEC',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[]");
      setEventMetadata("VALID_PAICOD",",oparms:[]}");
      setEventMetadata("VALID_PAIHSEXSEC","{handler:'valid_Paihsexsec',iparms:[]");
      setEventMetadata("VALID_PAIHSEXSEC",",oparms:[]}");
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
      A1331PaiHsPDiaTipTra = "" ;
      A1334PaiHsPDiaDesde = "" ;
      A1335PaiTarifaPDia = DecimalUtil.ZERO ;
      A1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      A2434PaiTarifaPDCri = "" ;
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
      H00JA2_A1292TipoTraId = new String[] {""} ;
      H00JA2_A1293TipoTraNom = new String[] {""} ;
      H00JA3_A1885CliRelSec = new int[1] ;
      H00JA3_A1880CliReDTChar = new String[] {""} ;
      H00JA3_A3CliCod = new int[1] ;
      H00JA4_A1292TipoTraId = new String[] {""} ;
      H00JA4_A1293TipoTraNom = new String[] {""} ;
      AV20Pgmname = "" ;
      H00JA5_A46PaiCod = new short[1] ;
      H00JA5_A1332PaiHsExSec = new short[1] ;
      H00JA5_A2057PaiExtraordRelSec = new int[1] ;
      H00JA5_A2434PaiTarifaPDCri = new String[] {""} ;
      H00JA5_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00JA5_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00JA5_A1334PaiHsPDiaDesde = new String[] {""} ;
      H00JA5_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      H00JA5_A1333PaiHsPDiaDia = new byte[1] ;
      H00JA5_A1331PaiHsPDiaTipTra = new String[] {""} ;
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
      sCtrlA1332PaiHsExSec = "" ;
      H00JA6_A1292TipoTraId = new String[] {""} ;
      H00JA6_A1293TipoTraNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisextraordinariasgeneral__default(),
         new Object[] {
             new Object[] {
            H00JA2_A1292TipoTraId, H00JA2_A1293TipoTraNom
            }
            , new Object[] {
            H00JA3_A1885CliRelSec, H00JA3_A1880CliReDTChar, H00JA3_A3CliCod
            }
            , new Object[] {
            H00JA4_A1292TipoTraId, H00JA4_A1293TipoTraNom
            }
            , new Object[] {
            H00JA5_A46PaiCod, H00JA5_A1332PaiHsExSec, H00JA5_A2057PaiExtraordRelSec, H00JA5_A2434PaiTarifaPDCri, H00JA5_A1348PaiTarifaPDRec, H00JA5_A1335PaiTarifaPDia, H00JA5_A1334PaiHsPDiaDesde, H00JA5_n1334PaiHsPDiaDesde, H00JA5_A1333PaiHsPDiaDia, H00JA5_A1331PaiHsPDiaTipTra
            }
            , new Object[] {
            H00JA6_A1292TipoTraId, H00JA6_A1293TipoTraNom
            }
         }
      );
      AV20Pgmname = "PaisExtraordinariasGeneral" ;
      /* GeneXus formulas. */
      AV20Pgmname = "PaisExtraordinariasGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A1333PaiHsPDiaDia ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA46PaiCod ;
   private short wcpOA1332PaiHsExSec ;
   private short A46PaiCod ;
   private short A1332PaiHsExSec ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int edtPaiCod_Enabled ;
   private int edtPaiHsExSec_Enabled ;
   private int edtPaiHsPDiaDesde_Enabled ;
   private int edtPaiTarifaPDia_Enabled ;
   private int edtPaiTarifaPDRec_Enabled ;
   private int A2057PaiExtraordRelSec ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int gxdynajaxindex ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private java.math.BigDecimal A1335PaiTarifaPDia ;
   private java.math.BigDecimal A1348PaiTarifaPDRec ;
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
   private String edtPaiHsExSec_Internalname ;
   private String edtPaiHsExSec_Jsonclick ;
   private String A1331PaiHsPDiaTipTra ;
   private String edtPaiHsPDiaDesde_Internalname ;
   private String A1334PaiHsPDiaDesde ;
   private String edtPaiHsPDiaDesde_Jsonclick ;
   private String edtPaiTarifaPDia_Internalname ;
   private String edtPaiTarifaPDia_Jsonclick ;
   private String edtPaiTarifaPDRec_Internalname ;
   private String edtPaiTarifaPDRec_Jsonclick ;
   private String A2434PaiTarifaPDCri ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV20Pgmname ;
   private String sCtrlA46PaiCod ;
   private String sCtrlA1332PaiHsExSec ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1334PaiHsPDiaDesde ;
   private boolean returnInSub ;
   private boolean AV13TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private HTMLChoice dynPaiHsPDiaTipTra ;
   private HTMLChoice cmbPaiHsPDiaDia ;
   private HTMLChoice cmbPaiTarifaPDCri ;
   private HTMLChoice dynPaiExtraordRelSec ;
   private IDataStoreProvider pr_default ;
   private String[] H00JA2_A1292TipoTraId ;
   private String[] H00JA2_A1293TipoTraNom ;
   private int[] H00JA3_A1885CliRelSec ;
   private String[] H00JA3_A1880CliReDTChar ;
   private int[] H00JA3_A3CliCod ;
   private String[] H00JA4_A1292TipoTraId ;
   private String[] H00JA4_A1293TipoTraNom ;
   private short[] H00JA5_A46PaiCod ;
   private short[] H00JA5_A1332PaiHsExSec ;
   private int[] H00JA5_A2057PaiExtraordRelSec ;
   private String[] H00JA5_A2434PaiTarifaPDCri ;
   private java.math.BigDecimal[] H00JA5_A1348PaiTarifaPDRec ;
   private java.math.BigDecimal[] H00JA5_A1335PaiTarifaPDia ;
   private String[] H00JA5_A1334PaiHsPDiaDesde ;
   private boolean[] H00JA5_n1334PaiHsPDiaDesde ;
   private byte[] H00JA5_A1333PaiHsPDiaDia ;
   private String[] H00JA5_A1331PaiHsPDiaTipTra ;
   private String[] H00JA6_A1292TipoTraId ;
   private String[] H00JA6_A1293TipoTraNom ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class paisextraordinariasgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00JA2", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo ORDER BY TipoTraNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00JA3", "SELECT CliRelSec, CliReDTChar, CliCod FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00JA4", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo ORDER BY TipoTraNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00JA5", "SELECT PaiCod, PaiHsExSec, PaiExtraordRelSec, PaiTarifaPDCri, PaiTarifaPDRec, PaiTarifaPDia, PaiHsPDiaDesde, PaiHsPDiaDia, PaiHsPDiaTipTra FROM Paishorasextras_pordia WHERE PaiCod = ? and PaiHsExSec = ? ORDER BY PaiCod, PaiHsExSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00JA6", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo ORDER BY TipoTraNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getString(7, 5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

