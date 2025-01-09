package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class tipo_obligaciongeneral_impl extends GXWebComponent
{
   public tipo_obligaciongeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public tipo_obligaciongeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipo_obligaciongeneral_impl.class ));
   }

   public tipo_obligaciongeneral_impl( int remoteHandle ,
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
      chkTipoOblAnti = UIFactory.getCheckbox(this);
      cmbTipoOblTotTipo = new HTMLChoice();
      chkTipoOblSoloDescu = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "TipoOblSec") ;
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
               A1163TipoOblSec = (short)(GXutil.lval( httpContext.GetPar( "TipoOblSec"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(A1163TipoOblSec)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "TipoOblSec") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "TipoOblSec") ;
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
         paC82( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "tipo_obligacion General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.tipo_obligaciongeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A1163TipoOblSec,4,0))}, new String[] {"TipoOblSec"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1163TipoOblSec", GXutil.ltrim( localUtil.ntoc( wcpOA1163TipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormC82( )
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
      return "tipo_obligacionGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "tipo_obligacion General", "") ;
   }

   public void wbC80( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.tipo_obligaciongeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoOblSec_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtTipoOblSec_Internalname, httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtTipoOblSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1163TipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTipoOblSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1163TipoOblSec), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1163TipoOblSec), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoOblSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTipoOblSec_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_tipo_obligacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoOblCodigo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtTipoOblCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtTipoOblCodigo_Internalname, GXutil.rtrim( A1164TipoOblCodigo), GXutil.rtrim( localUtil.format( A1164TipoOblCodigo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoOblCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTipoOblCodigo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_tipo_obligacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoOblDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtTipoOblDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtTipoOblDescrip_Internalname, A1165TipoOblDescrip, "", "", (short)(0), 1, edtTipoOblDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_tipo_obligacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTipooblpaicod_description_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavTipooblpaicod_description_Internalname, httpContext.getMessage( "Pai Cod", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTipooblpaicod_description_Internalname, AV12TipoOblPaiCod_Description, GXutil.rtrim( localUtil.format( AV12TipoOblPaiCod_Description, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTipooblpaicod_description_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTipooblpaicod_description_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_tipo_obligacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkTipoOblAnti.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkTipoOblAnti.getInternalname(), httpContext.getMessage( "Es por anticipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkTipoOblAnti.getInternalname(), GXutil.booltostr( A1167TipoOblAnti), "", httpContext.getMessage( "Es por anticipo", ""), 1, chkTipoOblAnti.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbTipoOblTotTipo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbTipoOblTotTipo.getInternalname(), httpContext.getMessage( "Total", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbTipoOblTotTipo, cmbTipoOblTotTipo.getInternalname(), GXutil.trim( GXutil.str( A1168TipoOblTotTipo, 1, 0)), 1, cmbTipoOblTotTipo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbTipoOblTotTipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_tipo_obligacionGeneral.htm");
         cmbTipoOblTotTipo.setValue( GXutil.trim( GXutil.str( A1168TipoOblTotTipo, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbTipoOblTotTipo.getInternalname(), "Values", cmbTipoOblTotTipo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmbargaDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtEmbargaDescrip_Internalname, httpContext.getMessage( "embargabilidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmbargaDescrip_Internalname, A1162EmbargaDescrip, GXutil.rtrim( localUtil.format( A1162EmbargaDescrip, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmbargaDescrip_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmbargaDescrip_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_tipo_obligacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkTipoOblSoloDescu.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkTipoOblSoloDescu.getInternalname(), httpContext.getMessage( "Solo descuentos", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkTipoOblSoloDescu.getInternalname(), GXutil.booltostr( A2346TipoOblSoloDescu), "", httpContext.getMessage( "Solo descuentos", ""), 1, chkTipoOblSoloDescu.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11c81_client"+"'", TempTags, "", 2, "HLP_tipo_obligacionGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12c81_client"+"'", TempTags, "", 2, "HLP_tipo_obligacionGeneral.htm");
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

   public void startC82( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "tipo_obligacion General", ""), (short)(0)) ;
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
            strupC80( ) ;
         }
      }
   }

   public void wsC82( )
   {
      startC82( ) ;
      evtC82( ) ;
   }

   public void evtC82( )
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
                              strupC80( ) ;
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
                              strupC80( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13C82 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupC80( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14C82 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupC80( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15C82 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupC80( ) ;
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
                              strupC80( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavTipooblpaicod_description_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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

   public void weC82( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormC82( ) ;
         }
      }
   }

   public void paC82( )
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
            GX_FocusControl = edtavTipooblpaicod_description_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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
      A1167TipoOblAnti = GXutil.strtobool( GXutil.booltostr( A1167TipoOblAnti)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1167TipoOblAnti", A1167TipoOblAnti);
      if ( cmbTipoOblTotTipo.getItemCount() > 0 )
      {
         A1168TipoOblTotTipo = (byte)(GXutil.lval( cmbTipoOblTotTipo.getValidValue(GXutil.trim( GXutil.str( A1168TipoOblTotTipo, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1168TipoOblTotTipo", GXutil.str( A1168TipoOblTotTipo, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbTipoOblTotTipo.setValue( GXutil.trim( GXutil.str( A1168TipoOblTotTipo, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbTipoOblTotTipo.getInternalname(), "Values", cmbTipoOblTotTipo.ToJavascriptSource(), true);
      }
      A2346TipoOblSoloDescu = GXutil.strtobool( GXutil.booltostr( A2346TipoOblSoloDescu)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2346TipoOblSoloDescu", A2346TipoOblSoloDescu);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfC82( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV20Pgmname = "tipo_obligacionGeneral" ;
      Gx_err = (short)(0) ;
      edtavTipooblpaicod_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTipooblpaicod_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTipooblpaicod_description_Enabled), 5, 0), true);
   }

   public void rfC82( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15C82 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00C82 */
         pr_default.execute(0, new Object[] {Short.valueOf(A1163TipoOblSec)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1161EmbargaSec = H00C82_A1161EmbargaSec[0] ;
            n1161EmbargaSec = H00C82_n1161EmbargaSec[0] ;
            A2346TipoOblSoloDescu = H00C82_A2346TipoOblSoloDescu[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2346TipoOblSoloDescu", A2346TipoOblSoloDescu);
            A1162EmbargaDescrip = H00C82_A1162EmbargaDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1162EmbargaDescrip", A1162EmbargaDescrip);
            A1168TipoOblTotTipo = H00C82_A1168TipoOblTotTipo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1168TipoOblTotTipo", GXutil.str( A1168TipoOblTotTipo, 1, 0));
            A1167TipoOblAnti = H00C82_A1167TipoOblAnti[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1167TipoOblAnti", A1167TipoOblAnti);
            A1165TipoOblDescrip = H00C82_A1165TipoOblDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1165TipoOblDescrip", A1165TipoOblDescrip);
            A1164TipoOblCodigo = H00C82_A1164TipoOblCodigo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1164TipoOblCodigo", A1164TipoOblCodigo);
            A1162EmbargaDescrip = H00C82_A1162EmbargaDescrip[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1162EmbargaDescrip", A1162EmbargaDescrip);
            /* Execute user event: Load */
            e14C82 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wbC80( ) ;
      }
   }

   public void send_integrity_lvl_hashesC82( )
   {
   }

   public void before_start_formulas( )
   {
      AV20Pgmname = "tipo_obligacionGeneral" ;
      Gx_err = (short)(0) ;
      edtavTipooblpaicod_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTipooblpaicod_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTipooblpaicod_description_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strupC80( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13C82 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA1163TipoOblSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1163TipoOblSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         A1164TipoOblCodigo = httpContext.cgiGet( edtTipoOblCodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1164TipoOblCodigo", A1164TipoOblCodigo);
         A1165TipoOblDescrip = httpContext.cgiGet( edtTipoOblDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1165TipoOblDescrip", A1165TipoOblDescrip);
         AV12TipoOblPaiCod_Description = httpContext.cgiGet( edtavTipooblpaicod_description_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12TipoOblPaiCod_Description", AV12TipoOblPaiCod_Description);
         A1167TipoOblAnti = GXutil.strtobool( httpContext.cgiGet( chkTipoOblAnti.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1167TipoOblAnti", A1167TipoOblAnti);
         cmbTipoOblTotTipo.setValue( httpContext.cgiGet( cmbTipoOblTotTipo.getInternalname()) );
         A1168TipoOblTotTipo = (byte)(GXutil.lval( httpContext.cgiGet( cmbTipoOblTotTipo.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1168TipoOblTotTipo", GXutil.str( A1168TipoOblTotTipo, 1, 0));
         A1162EmbargaDescrip = GXutil.upper( httpContext.cgiGet( edtEmbargaDescrip_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1162EmbargaDescrip", A1162EmbargaDescrip);
         A2346TipoOblSoloDescu = GXutil.strtobool( httpContext.cgiGet( chkTipoOblSoloDescu.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2346TipoOblSoloDescu", A2346TipoOblSoloDescu);
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
      e13C82 ();
      if (returnInSub) return;
   }

   public void e13C82( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      tipo_obligaciongeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
      GXv_SdtWWPContext3[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV6WWPContext = GXv_SdtWWPContext3[0] ;
      GXt_char4 = AV16Combo_DataJson ;
      GXv_char5[0] = AV17ComboSelectedValue ;
      GXv_char6[0] = AV12TipoOblPaiCod_Description ;
      GXv_char7[0] = GXt_char4 ;
      new web.tipo_obligacionloaddvcombo(remoteHandle, context).execute( "TipoOblPaiCod", "UPD", false, A1163TipoOblSec, "", GXv_char5, GXv_char6, GXv_char7) ;
      tipo_obligaciongeneral_impl.this.AV17ComboSelectedValue = GXv_char5[0] ;
      tipo_obligaciongeneral_impl.this.AV12TipoOblPaiCod_Description = GXv_char6[0] ;
      tipo_obligaciongeneral_impl.this.GXt_char4 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12TipoOblPaiCod_Description", AV12TipoOblPaiCod_Description);
      AV16Combo_DataJson = GXt_char4 ;
      GXt_char4 = AV16Combo_DataJson ;
      GXv_char7[0] = AV17ComboSelectedValue ;
      GXv_char6[0] = AV12TipoOblPaiCod_Description ;
      GXv_char5[0] = GXt_char4 ;
      new web.tipo_obligacionloaddvcombo(remoteHandle, context).execute( "TipoOblPaiCod", "UPD", false, A1163TipoOblSec, "", GXv_char7, GXv_char6, GXv_char5) ;
      tipo_obligaciongeneral_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
      tipo_obligaciongeneral_impl.this.AV12TipoOblPaiCod_Description = GXv_char6[0] ;
      tipo_obligaciongeneral_impl.this.GXt_char4 = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12TipoOblPaiCod_Description", AV12TipoOblPaiCod_Description);
      AV16Combo_DataJson = GXt_char4 ;
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e14C82( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean8 = AV13TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_obligacion_Update", GXv_boolean9) ;
      tipo_obligaciongeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV13TempBoolean = GXt_boolean8 ;
      if ( AV13TempBoolean )
      {
         GXt_boolean8 = AV13TempBoolean ;
         GXv_boolean9[0] = GXt_boolean8 ;
         new web.wwpbaseobjects.esclientenucleogeneral2(remoteHandle, context).execute( GXv_boolean9) ;
         tipo_obligaciongeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
         AV13TempBoolean = (boolean)((GXt_boolean8)) ;
         if ( ! ( AV13TempBoolean ) )
         {
            bttBtnupdate_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
         }
      }
      else
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean8 = AV13TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_obligacion_Delete", GXv_boolean9) ;
      tipo_obligaciongeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV13TempBoolean = GXt_boolean8 ;
      if ( AV13TempBoolean )
      {
         GXt_boolean8 = AV13TempBoolean ;
         GXv_boolean9[0] = GXt_boolean8 ;
         new web.wwpbaseobjects.esclientenucleogeneral2(remoteHandle, context).execute( GXv_boolean9) ;
         tipo_obligaciongeneral_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
         AV13TempBoolean = (boolean)((GXt_boolean8)) ;
         if ( ! ( AV13TempBoolean ) )
         {
            bttBtndelete_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
         }
      }
      else
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "tipo_obligacion" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15C82( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      tipo_obligaciongeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A1163TipoOblSec = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
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
      paC82( ) ;
      wsC82( ) ;
      weC82( ) ;
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
      sCtrlA1163TipoOblSec = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paC82( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "tipo_obligaciongeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paC82( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A1163TipoOblSec = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
      }
      wcpOA1163TipoOblSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1163TipoOblSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A1163TipoOblSec != wcpOA1163TipoOblSec ) ) )
      {
         setjustcreated();
      }
      wcpOA1163TipoOblSec = A1163TipoOblSec ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA1163TipoOblSec = httpContext.cgiGet( sPrefix+"A1163TipoOblSec_CTRL") ;
      if ( GXutil.len( sCtrlA1163TipoOblSec) > 0 )
      {
         A1163TipoOblSec = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA1163TipoOblSec), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1163TipoOblSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1163TipoOblSec), 4, 0));
      }
      else
      {
         A1163TipoOblSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1163TipoOblSec_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paC82( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsC82( ) ;
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
      wsC82( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1163TipoOblSec_PARM", GXutil.ltrim( localUtil.ntoc( A1163TipoOblSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1163TipoOblSec)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1163TipoOblSec_CTRL", GXutil.rtrim( sCtrlA1163TipoOblSec));
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
      weC82( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202043298", true, true);
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
      httpContext.AddJavascriptSource("tipo_obligaciongeneral.js", "?202412202043298", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtTipoOblSec_Internalname = sPrefix+"TIPOOBLSEC" ;
      edtTipoOblCodigo_Internalname = sPrefix+"TIPOOBLCODIGO" ;
      edtTipoOblDescrip_Internalname = sPrefix+"TIPOOBLDESCRIP" ;
      edtavTipooblpaicod_description_Internalname = sPrefix+"vTIPOOBLPAICOD_DESCRIPTION" ;
      chkTipoOblAnti.setInternalname( sPrefix+"TIPOOBLANTI" );
      cmbTipoOblTotTipo.setInternalname( sPrefix+"TIPOOBLTOTTIPO" );
      edtEmbargaDescrip_Internalname = sPrefix+"EMBARGADESCRIP" ;
      chkTipoOblSoloDescu.setInternalname( sPrefix+"TIPOOBLSOLODESCU" );
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
      chkTipoOblSoloDescu.setEnabled( 0 );
      edtEmbargaDescrip_Jsonclick = "" ;
      edtEmbargaDescrip_Enabled = 0 ;
      cmbTipoOblTotTipo.setJsonclick( "" );
      cmbTipoOblTotTipo.setEnabled( 0 );
      chkTipoOblAnti.setEnabled( 0 );
      edtavTipooblpaicod_description_Jsonclick = "" ;
      edtavTipooblpaicod_description_Enabled = 1 ;
      edtTipoOblDescrip_Enabled = 0 ;
      edtTipoOblCodigo_Jsonclick = "" ;
      edtTipoOblCodigo_Enabled = 0 ;
      edtTipoOblSec_Jsonclick = "" ;
      edtTipoOblSec_Enabled = 0 ;
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
      chkTipoOblAnti.setName( "TIPOOBLANTI" );
      chkTipoOblAnti.setWebtags( "" );
      chkTipoOblAnti.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkTipoOblAnti.getInternalname(), "TitleCaption", chkTipoOblAnti.getCaption(), true);
      chkTipoOblAnti.setCheckedValue( "false" );
      cmbTipoOblTotTipo.setName( "TIPOOBLTOTTIPO" );
      cmbTipoOblTotTipo.setWebtags( "" );
      cmbTipoOblTotTipo.addItem("0", httpContext.getMessage( "Sin total", ""), (short)(0));
      cmbTipoOblTotTipo.addItem("1", httpContext.getMessage( "Total fijo", ""), (short)(0));
      cmbTipoOblTotTipo.addItem("2", httpContext.getMessage( "Total liquidado", ""), (short)(0));
      if ( cmbTipoOblTotTipo.getItemCount() > 0 )
      {
      }
      chkTipoOblSoloDescu.setName( "TIPOOBLSOLODESCU" );
      chkTipoOblSoloDescu.setWebtags( "" );
      chkTipoOblSoloDescu.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkTipoOblSoloDescu.getInternalname(), "TitleCaption", chkTipoOblSoloDescu.getCaption(), true);
      chkTipoOblSoloDescu.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'},{av:'A1167TipoOblAnti',fld:'TIPOOBLANTI',pic:''},{av:'A2346TipoOblSoloDescu',fld:'TIPOOBLSOLODESCU',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11C81',iparms:[{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12C81',iparms:[{av:'A1163TipoOblSec',fld:'TIPOOBLSEC',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_TIPOOBLSEC","{handler:'valid_Tipooblsec',iparms:[]");
      setEventMetadata("VALID_TIPOOBLSEC",",oparms:[]}");
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
      A1164TipoOblCodigo = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1165TipoOblDescrip = "" ;
      TempTags = "" ;
      AV12TipoOblPaiCod_Description = "" ;
      A1162EmbargaDescrip = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV20Pgmname = "" ;
      scmdbuf = "" ;
      H00C82_A1161EmbargaSec = new short[1] ;
      H00C82_n1161EmbargaSec = new boolean[] {false} ;
      H00C82_A1163TipoOblSec = new short[1] ;
      H00C82_A2346TipoOblSoloDescu = new boolean[] {false} ;
      H00C82_A1162EmbargaDescrip = new String[] {""} ;
      H00C82_A1168TipoOblTotTipo = new byte[1] ;
      H00C82_A1167TipoOblAnti = new boolean[] {false} ;
      H00C82_A1165TipoOblDescrip = new String[] {""} ;
      H00C82_A1164TipoOblCodigo = new String[] {""} ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV16Combo_DataJson = "" ;
      AV17ComboSelectedValue = "" ;
      GXt_char4 = "" ;
      GXv_char7 = new String[1] ;
      GXv_char6 = new String[1] ;
      GXv_char5 = new String[1] ;
      GXv_boolean9 = new boolean[1] ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA1163TipoOblSec = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipo_obligaciongeneral__default(),
         new Object[] {
             new Object[] {
            H00C82_A1161EmbargaSec, H00C82_n1161EmbargaSec, H00C82_A1163TipoOblSec, H00C82_A2346TipoOblSoloDescu, H00C82_A1162EmbargaDescrip, H00C82_A1168TipoOblTotTipo, H00C82_A1167TipoOblAnti, H00C82_A1165TipoOblDescrip, H00C82_A1164TipoOblCodigo
            }
         }
      );
      AV20Pgmname = "tipo_obligacionGeneral" ;
      /* GeneXus formulas. */
      AV20Pgmname = "tipo_obligacionGeneral" ;
      Gx_err = (short)(0) ;
      edtavTipooblpaicod_description_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A1168TipoOblTotTipo ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA1163TipoOblSec ;
   private short A1163TipoOblSec ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A1161EmbargaSec ;
   private int edtTipoOblSec_Enabled ;
   private int edtTipoOblCodigo_Enabled ;
   private int edtTipoOblDescrip_Enabled ;
   private int edtavTipooblpaicod_description_Enabled ;
   private int edtEmbargaDescrip_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int AV14CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
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
   private String edtTipoOblSec_Internalname ;
   private String edtTipoOblSec_Jsonclick ;
   private String edtTipoOblCodigo_Internalname ;
   private String A1164TipoOblCodigo ;
   private String edtTipoOblCodigo_Jsonclick ;
   private String edtTipoOblDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtavTipooblpaicod_description_Internalname ;
   private String TempTags ;
   private String edtavTipooblpaicod_description_Jsonclick ;
   private String edtEmbargaDescrip_Internalname ;
   private String edtEmbargaDescrip_Jsonclick ;
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
   private String GXt_char4 ;
   private String GXv_char7[] ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String sCtrlA1163TipoOblSec ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A1167TipoOblAnti ;
   private boolean A2346TipoOblSoloDescu ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1161EmbargaSec ;
   private boolean returnInSub ;
   private boolean AV13TempBoolean ;
   private boolean GXt_boolean8 ;
   private boolean GXv_boolean9[] ;
   private String AV16Combo_DataJson ;
   private String A1165TipoOblDescrip ;
   private String AV12TipoOblPaiCod_Description ;
   private String A1162EmbargaDescrip ;
   private String AV17ComboSelectedValue ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private ICheckbox chkTipoOblAnti ;
   private HTMLChoice cmbTipoOblTotTipo ;
   private ICheckbox chkTipoOblSoloDescu ;
   private IDataStoreProvider pr_default ;
   private short[] H00C82_A1161EmbargaSec ;
   private boolean[] H00C82_n1161EmbargaSec ;
   private short[] H00C82_A1163TipoOblSec ;
   private boolean[] H00C82_A2346TipoOblSoloDescu ;
   private String[] H00C82_A1162EmbargaDescrip ;
   private byte[] H00C82_A1168TipoOblTotTipo ;
   private boolean[] H00C82_A1167TipoOblAnti ;
   private String[] H00C82_A1165TipoOblDescrip ;
   private String[] H00C82_A1164TipoOblCodigo ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class tipo_obligaciongeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00C82", "SELECT T1.EmbargaSec, T1.TipoOblSec, T1.TipoOblSoloDescu, T2.EmbargaDescrip, T1.TipoOblTotTipo, T1.TipoOblAnti, T1.TipoOblDescrip, T1.TipoOblCodigo FROM (tipo_obligacion T1 LEFT JOIN embargabilidad T2 ON T2.EmbargaSec = T1.EmbargaSec) WHERE T1.TipoOblSec = ? ORDER BY T1.TipoOblSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
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

