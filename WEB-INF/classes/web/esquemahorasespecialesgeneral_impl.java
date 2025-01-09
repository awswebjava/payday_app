package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class esquemahorasespecialesgeneral_impl extends GXWebComponent
{
   public esquemahorasespecialesgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public esquemahorasespecialesgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esquemahorasespecialesgeneral_impl.class ));
   }

   public esquemahorasespecialesgeneral_impl( int remoteHandle ,
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
      dynConvHsPDiaTipTra = new HTMLChoice();
      cmbConveHsPDiaDia = new HTMLChoice();
      cmbConveTarifaPDCri = new HTMLChoice();
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
               A1327ConveHsExSec = (short)(GXutil.lval( httpContext.GetPar( "ConveHsExSec"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A3CliCod),Short.valueOf(A1564CliPaiConve),A1565CliConvenio,Short.valueOf(A1327ConveHsExSec)});
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
         paQG2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Esquema Horas Especiales General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.esquemahorasespecialesgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.ltrimstr(A1327ConveHsExSec,4,0))}, new String[] {"CliCod","CliPaiConve","CliConvenio","ConveHsExSec"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1327ConveHsExSec", GXutil.ltrim( localUtil.ntoc( wcpOA1327ConveHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormQG2( )
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
      return "EsquemaHorasEspecialesGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Esquema Horas Especiales General", "") ;
   }

   public void wbQG0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.esquemahorasespecialesgeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynConvHsPDiaTipTra.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynConvHsPDiaTipTra.getInternalname(), httpContext.getMessage( "Tipo de trabajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynConvHsPDiaTipTra, dynConvHsPDiaTipTra.getInternalname(), GXutil.rtrim( A1326ConvHsPDiaTipTra), 1, dynConvHsPDiaTipTra.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, dynConvHsPDiaTipTra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_EsquemaHorasEspecialesGeneral.htm");
         dynConvHsPDiaTipTra.setValue( GXutil.rtrim( A1326ConvHsPDiaTipTra) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynConvHsPDiaTipTra.getInternalname(), "Values", dynConvHsPDiaTipTra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveHsPDiaDia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConveHsPDiaDia.getInternalname(), httpContext.getMessage( "Día", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveHsPDiaDia, cmbConveHsPDiaDia.getInternalname(), GXutil.trim( GXutil.str( A1328ConveHsPDiaDia, 1, 0)), 1, cmbConveHsPDiaDia.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConveHsPDiaDia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_EsquemaHorasEspecialesGeneral.htm");
         cmbConveHsPDiaDia.setValue( GXutil.trim( GXutil.str( A1328ConveHsPDiaDia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveHsPDiaDia.getInternalname(), "Values", cmbConveHsPDiaDia.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveHsPDiaDesde_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveHsPDiaDesde_Internalname, httpContext.getMessage( "Hora desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveHsPDiaDesde_Internalname, GXutil.rtrim( A1329ConveHsPDiaDesde), GXutil.rtrim( localUtil.format( A1329ConveHsPDiaDesde, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveHsPDiaDesde_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveHsPDiaDesde_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EsquemaHorasEspecialesGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveTarifaPDia_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveTarifaPDia_Internalname, httpContext.getMessage( "Aumento de horas extras sobre hora normal", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveTarifaPDia_Internalname, GXutil.ltrim( localUtil.ntoc( A1330ConveTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveTarifaPDia_Enabled!=0) ? localUtil.format( A1330ConveTarifaPDia, "9.9999") : localUtil.format( A1330ConveTarifaPDia, "9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveTarifaPDia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveTarifaPDia_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_EsquemaHorasEspecialesGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveTarifaPDRec_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtConveTarifaPDRec_Internalname, httpContext.getMessage( "Recargo a hora normal diurna", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveTarifaPDRec_Internalname, GXutil.ltrim( localUtil.ntoc( A1350ConveTarifaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveTarifaPDRec_Enabled!=0) ? localUtil.format( A1350ConveTarifaPDRec, "9.9999") : localUtil.format( A1350ConveTarifaPDRec, "9.9999"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveTarifaPDRec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveTarifaPDRec_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_EsquemaHorasEspecialesGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveTarifaPDCri.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbConveTarifaPDCri.getInternalname(), httpContext.getMessage( "Criterio de aplicación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveTarifaPDCri, cmbConveTarifaPDCri.getInternalname(), GXutil.rtrim( A2432ConveTarifaPDCri), 1, cmbConveTarifaPDCri.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConveTarifaPDCri.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_EsquemaHorasEspecialesGeneral.htm");
         cmbConveTarifaPDCri.setValue( GXutil.rtrim( A2432ConveTarifaPDCri) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveTarifaPDCri.getInternalname(), "Values", cmbConveTarifaPDCri.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11qg1_client"+"'", TempTags, "", 2, "HLP_EsquemaHorasEspecialesGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12qg1_client"+"'", TempTags, "", 2, "HLP_EsquemaHorasEspecialesGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EsquemaHorasEspecialesGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_EsquemaHorasEspecialesGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, 0, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EsquemaHorasEspecialesGeneral.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtConveHsExSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1327ConveHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1327ConveHsExSec), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveHsExSec_Jsonclick, 0, "Attribute", "", "", "", "", edtConveHsExSec_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EsquemaHorasEspecialesGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startQG2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Esquema Horas Especiales General", ""), (short)(0)) ;
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
            strupQG0( ) ;
         }
      }
   }

   public void wsQG2( )
   {
      startQG2( ) ;
      evtQG2( ) ;
   }

   public void evtQG2( )
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
                              strupQG0( ) ;
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
                              strupQG0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13QG2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupQG0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14QG2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupQG0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15QG2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupQG0( ) ;
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
                              strupQG0( ) ;
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

   public void weQG2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormQG2( ) ;
         }
      }
   }

   public void paQG2( )
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

   public void gxdlaconvhspdiatiptraQG1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconvhspdiatiptra_dataQG1( ) ;
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

   public void gxaconvhspdiatiptra_htmlQG1( )
   {
      String gxdynajaxvalue;
      gxdlaconvhspdiatiptra_dataQG1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConvHsPDiaTipTra.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynConvHsPDiaTipTra.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynConvHsPDiaTipTra.getItemCount() > 0 )
      {
         A1326ConvHsPDiaTipTra = dynConvHsPDiaTipTra.getValidValue(A1326ConvHsPDiaTipTra) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1326ConvHsPDiaTipTra", A1326ConvHsPDiaTipTra);
      }
   }

   protected void gxdlaconvhspdiatiptra_dataQG1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00QG2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00QG2_A1292TipoTraId[0]));
         gxdynajaxctrldescr.add(H00QG2_A1293TipoTraNom[0]);
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
         dynConvHsPDiaTipTra.setName( "CONVHSPDIATIPTRA" );
         dynConvHsPDiaTipTra.setWebtags( "" );
         dynConvHsPDiaTipTra.removeAllItems();
         /* Using cursor H00QG3 */
         pr_default.execute(1);
         while ( (pr_default.getStatus(1) != 101) )
         {
            dynConvHsPDiaTipTra.addItem(H00QG3_A1292TipoTraId[0], H00QG3_A1293TipoTraNom[0], (short)(0));
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( dynConvHsPDiaTipTra.getItemCount() > 0 )
         {
            A1326ConvHsPDiaTipTra = dynConvHsPDiaTipTra.getValidValue(A1326ConvHsPDiaTipTra) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1326ConvHsPDiaTipTra", A1326ConvHsPDiaTipTra);
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynConvHsPDiaTipTra.getItemCount() > 0 )
      {
         A1326ConvHsPDiaTipTra = dynConvHsPDiaTipTra.getValidValue(A1326ConvHsPDiaTipTra) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1326ConvHsPDiaTipTra", A1326ConvHsPDiaTipTra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConvHsPDiaTipTra.setValue( GXutil.rtrim( A1326ConvHsPDiaTipTra) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynConvHsPDiaTipTra.getInternalname(), "Values", dynConvHsPDiaTipTra.ToJavascriptSource(), true);
      }
      if ( cmbConveHsPDiaDia.getItemCount() > 0 )
      {
         A1328ConveHsPDiaDia = (byte)(GXutil.lval( cmbConveHsPDiaDia.getValidValue(GXutil.trim( GXutil.str( A1328ConveHsPDiaDia, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1328ConveHsPDiaDia", GXutil.str( A1328ConveHsPDiaDia, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveHsPDiaDia.setValue( GXutil.trim( GXutil.str( A1328ConveHsPDiaDia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveHsPDiaDia.getInternalname(), "Values", cmbConveHsPDiaDia.ToJavascriptSource(), true);
      }
      if ( cmbConveTarifaPDCri.getItemCount() > 0 )
      {
         A2432ConveTarifaPDCri = cmbConveTarifaPDCri.getValidValue(A2432ConveTarifaPDCri) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2432ConveTarifaPDCri", A2432ConveTarifaPDCri);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveTarifaPDCri.setValue( GXutil.rtrim( A2432ConveTarifaPDCri) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbConveTarifaPDCri.getInternalname(), "Values", cmbConveTarifaPDCri.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfQG2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV20Pgmname = "EsquemaHorasEspecialesGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rfQG2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15QG2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00QG4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Short.valueOf(A1327ConveHsExSec)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A2432ConveTarifaPDCri = H00QG4_A2432ConveTarifaPDCri[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2432ConveTarifaPDCri", A2432ConveTarifaPDCri);
            A1350ConveTarifaPDRec = H00QG4_A1350ConveTarifaPDRec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1350ConveTarifaPDRec", GXutil.ltrimstr( A1350ConveTarifaPDRec, 6, 4));
            A1330ConveTarifaPDia = H00QG4_A1330ConveTarifaPDia[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1330ConveTarifaPDia", GXutil.ltrimstr( A1330ConveTarifaPDia, 6, 4));
            A1329ConveHsPDiaDesde = H00QG4_A1329ConveHsPDiaDesde[0] ;
            n1329ConveHsPDiaDesde = H00QG4_n1329ConveHsPDiaDesde[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1329ConveHsPDiaDesde", A1329ConveHsPDiaDesde);
            A1328ConveHsPDiaDia = H00QG4_A1328ConveHsPDiaDia[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1328ConveHsPDiaDia", GXutil.str( A1328ConveHsPDiaDia, 1, 0));
            A1326ConvHsPDiaTipTra = H00QG4_A1326ConvHsPDiaTipTra[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1326ConvHsPDiaTipTra", A1326ConvHsPDiaTipTra);
            /* Execute user event: Load */
            e14QG2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(2);
         wbQG0( ) ;
      }
   }

   public void send_integrity_lvl_hashesQG2( )
   {
   }

   public void before_start_formulas( )
   {
      AV20Pgmname = "EsquemaHorasEspecialesGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupQG0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13QG2 ();
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
         wcpOA1327ConveHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1327ConveHsExSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         dynConvHsPDiaTipTra.setValue( httpContext.cgiGet( dynConvHsPDiaTipTra.getInternalname()) );
         A1326ConvHsPDiaTipTra = httpContext.cgiGet( dynConvHsPDiaTipTra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1326ConvHsPDiaTipTra", A1326ConvHsPDiaTipTra);
         cmbConveHsPDiaDia.setValue( httpContext.cgiGet( cmbConveHsPDiaDia.getInternalname()) );
         A1328ConveHsPDiaDia = (byte)(GXutil.lval( httpContext.cgiGet( cmbConveHsPDiaDia.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1328ConveHsPDiaDia", GXutil.str( A1328ConveHsPDiaDia, 1, 0));
         A1329ConveHsPDiaDesde = httpContext.cgiGet( edtConveHsPDiaDesde_Internalname) ;
         n1329ConveHsPDiaDesde = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1329ConveHsPDiaDesde", A1329ConveHsPDiaDesde);
         A1330ConveTarifaPDia = localUtil.ctond( httpContext.cgiGet( edtConveTarifaPDia_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1330ConveTarifaPDia", GXutil.ltrimstr( A1330ConveTarifaPDia, 6, 4));
         A1350ConveTarifaPDRec = localUtil.ctond( httpContext.cgiGet( edtConveTarifaPDRec_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1350ConveTarifaPDRec", GXutil.ltrimstr( A1350ConveTarifaPDRec, 6, 4));
         cmbConveTarifaPDCri.setValue( httpContext.cgiGet( cmbConveTarifaPDCri.getInternalname()) );
         A2432ConveTarifaPDCri = httpContext.cgiGet( cmbConveTarifaPDCri.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2432ConveTarifaPDCri", A2432ConveTarifaPDCri);
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
      e13QG2 ();
      if (returnInSub) return;
   }

   public void e13QG2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      esquemahorasespecialesgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e14QG2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
      edtCliConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Visible), 5, 0), true);
      edtConveHsExSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConveHsExSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsExSec_Visible), 5, 0), true);
      GXt_boolean4 = AV13TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaHorasEspeciales_Update", GXv_boolean5) ;
      esquemahorasespecialesgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV13TempBoolean = GXt_boolean4 ;
      if ( ! ( AV13TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV13TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaHorasEspeciales_Delete", GXv_boolean5) ;
      esquemahorasespecialesgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "EsquemaHorasEspeciales" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15QG2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      esquemahorasespecialesgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
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
      A1327ConveHsExSec = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
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
      paQG2( ) ;
      wsQG2( ) ;
      weQG2( ) ;
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
      sCtrlA1327ConveHsExSec = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paQG2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "esquemahorasespecialesgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paQG2( ) ;
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
         A1327ConveHsExSec = ((Number) GXutil.testNumericType( getParm(obj,5,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
      }
      wcpOA3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1565CliConvenio = httpContext.cgiGet( sPrefix+"wcpOA1565CliConvenio") ;
      wcpOA1327ConveHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1327ConveHsExSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( A3CliCod != wcpOA3CliCod ) || ( A1564CliPaiConve != wcpOA1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, wcpOA1565CliConvenio) != 0 ) || ( A1327ConveHsExSec != wcpOA1327ConveHsExSec ) ) )
      {
         setjustcreated();
      }
      wcpOA3CliCod = A3CliCod ;
      wcpOA1564CliPaiConve = A1564CliPaiConve ;
      wcpOA1565CliConvenio = A1565CliConvenio ;
      wcpOA1327ConveHsExSec = A1327ConveHsExSec ;
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
      sCtrlA1327ConveHsExSec = httpContext.cgiGet( sPrefix+"A1327ConveHsExSec_CTRL") ;
      if ( GXutil.len( sCtrlA1327ConveHsExSec) > 0 )
      {
         A1327ConveHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA1327ConveHsExSec), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1327ConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1327ConveHsExSec), 4, 0));
      }
      else
      {
         A1327ConveHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1327ConveHsExSec_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paQG2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsQG2( ) ;
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
      wsQG2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1327ConveHsExSec_PARM", GXutil.ltrim( localUtil.ntoc( A1327ConveHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1327ConveHsExSec)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1327ConveHsExSec_CTRL", GXutil.rtrim( sCtrlA1327ConveHsExSec));
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
      weQG2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251817522388", true, true);
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
      httpContext.AddJavascriptSource("esquemahorasespecialesgeneral.js", "?20251817522388", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynConvHsPDiaTipTra.setInternalname( sPrefix+"CONVHSPDIATIPTRA" );
      cmbConveHsPDiaDia.setInternalname( sPrefix+"CONVEHSPDIADIA" );
      edtConveHsPDiaDesde_Internalname = sPrefix+"CONVEHSPDIADESDE" ;
      edtConveTarifaPDia_Internalname = sPrefix+"CONVETARIFAPDIA" ;
      edtConveTarifaPDRec_Internalname = sPrefix+"CONVETARIFAPDREC" ;
      cmbConveTarifaPDCri.setInternalname( sPrefix+"CONVETARIFAPDCRI" );
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtCliPaiConve_Internalname = sPrefix+"CLIPAICONVE" ;
      edtCliConvenio_Internalname = sPrefix+"CLICONVENIO" ;
      edtConveHsExSec_Internalname = sPrefix+"CONVEHSEXSEC" ;
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
      edtConveHsExSec_Jsonclick = "" ;
      edtConveHsExSec_Visible = 1 ;
      edtCliConvenio_Jsonclick = "" ;
      edtCliConvenio_Visible = 1 ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      cmbConveTarifaPDCri.setJsonclick( "" );
      cmbConveTarifaPDCri.setEnabled( 0 );
      edtConveTarifaPDRec_Jsonclick = "" ;
      edtConveTarifaPDRec_Enabled = 0 ;
      edtConveTarifaPDia_Jsonclick = "" ;
      edtConveTarifaPDia_Enabled = 0 ;
      edtConveHsPDiaDesde_Jsonclick = "" ;
      edtConveHsPDiaDesde_Enabled = 0 ;
      cmbConveHsPDiaDia.setJsonclick( "" );
      cmbConveHsPDiaDia.setEnabled( 0 );
      dynConvHsPDiaTipTra.setJsonclick( "" );
      dynConvHsPDiaTipTra.setEnabled( 0 );
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
      dynConvHsPDiaTipTra.setName( "CONVHSPDIATIPTRA" );
      dynConvHsPDiaTipTra.setWebtags( "" );
      dynConvHsPDiaTipTra.removeAllItems();
      /* Using cursor H00QG5 */
      pr_default.execute(3);
      while ( (pr_default.getStatus(3) != 101) )
      {
         dynConvHsPDiaTipTra.addItem(H00QG5_A1292TipoTraId[0], H00QG5_A1293TipoTraNom[0], (short)(0));
         pr_default.readNext(3);
      }
      pr_default.close(3);
      if ( dynConvHsPDiaTipTra.getItemCount() > 0 )
      {
      }
      cmbConveHsPDiaDia.setName( "CONVEHSPDIADIA" );
      cmbConveHsPDiaDia.setWebtags( "" );
      cmbConveHsPDiaDia.addItem("1", httpContext.getMessage( "Domingo", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("2", httpContext.getMessage( "Lunes", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("3", httpContext.getMessage( "Martes", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("4", httpContext.getMessage( "Miércoles", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("5", httpContext.getMessage( "Jueves", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("6", httpContext.getMessage( "Viernes", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("7", httpContext.getMessage( "Sábado", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("8", httpContext.getMessage( "Feriado", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("9", httpContext.getMessage( "Día hábil no especificado", ""), (short)(0));
      if ( cmbConveHsPDiaDia.getItemCount() > 0 )
      {
      }
      cmbConveTarifaPDCri.setName( "CONVETARIFAPDCRI" );
      cmbConveTarifaPDCri.setWebtags( "" );
      cmbConveTarifaPDCri.addItem("exceso", httpContext.getMessage( "Por exceder las horas normales", ""), (short)(0));
      cmbConveTarifaPDCri.addItem("horario", httpContext.getMessage( "Por fecha y horario determinado", ""), (short)(0));
      if ( cmbConveTarifaPDCri.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1327ConveHsExSec',fld:'CONVEHSEXSEC',pic:'ZZZ9'},{av:'dynConvHsPDiaTipTra'},{av:'A1326ConvHsPDiaTipTra',fld:'CONVHSPDIATIPTRA',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11QG1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1327ConveHsExSec',fld:'CONVEHSEXSEC',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12QG1',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1327ConveHsExSec',fld:'CONVEHSEXSEC',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[]}");
      setEventMetadata("VALID_CONVEHSEXSEC","{handler:'valid_Convehsexsec',iparms:[]");
      setEventMetadata("VALID_CONVEHSEXSEC",",oparms:[]}");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A1565CliConvenio = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A1326ConvHsPDiaTipTra = "" ;
      A1329ConveHsPDiaDesde = "" ;
      A1330ConveTarifaPDia = DecimalUtil.ZERO ;
      A1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      A2432ConveTarifaPDCri = "" ;
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
      H00QG2_A1292TipoTraId = new String[] {""} ;
      H00QG2_A1293TipoTraNom = new String[] {""} ;
      H00QG3_A1292TipoTraId = new String[] {""} ;
      H00QG3_A1293TipoTraNom = new String[] {""} ;
      AV20Pgmname = "" ;
      H00QG4_A3CliCod = new int[1] ;
      H00QG4_A1564CliPaiConve = new short[1] ;
      H00QG4_A1565CliConvenio = new String[] {""} ;
      H00QG4_A1327ConveHsExSec = new short[1] ;
      H00QG4_A2432ConveTarifaPDCri = new String[] {""} ;
      H00QG4_A1350ConveTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00QG4_A1330ConveTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00QG4_A1329ConveHsPDiaDesde = new String[] {""} ;
      H00QG4_n1329ConveHsPDiaDesde = new boolean[] {false} ;
      H00QG4_A1328ConveHsPDiaDia = new byte[1] ;
      H00QG4_A1326ConvHsPDiaTipTra = new String[] {""} ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA3CliCod = "" ;
      sCtrlA1564CliPaiConve = "" ;
      sCtrlA1565CliConvenio = "" ;
      sCtrlA1327ConveHsExSec = "" ;
      H00QG5_A1292TipoTraId = new String[] {""} ;
      H00QG5_A1293TipoTraNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.esquemahorasespecialesgeneral__default(),
         new Object[] {
             new Object[] {
            H00QG2_A1292TipoTraId, H00QG2_A1293TipoTraNom
            }
            , new Object[] {
            H00QG3_A1292TipoTraId, H00QG3_A1293TipoTraNom
            }
            , new Object[] {
            H00QG4_A3CliCod, H00QG4_A1564CliPaiConve, H00QG4_A1565CliConvenio, H00QG4_A1327ConveHsExSec, H00QG4_A2432ConveTarifaPDCri, H00QG4_A1350ConveTarifaPDRec, H00QG4_A1330ConveTarifaPDia, H00QG4_A1329ConveHsPDiaDesde, H00QG4_n1329ConveHsPDiaDesde, H00QG4_A1328ConveHsPDiaDia,
            H00QG4_A1326ConvHsPDiaTipTra
            }
            , new Object[] {
            H00QG5_A1292TipoTraId, H00QG5_A1293TipoTraNom
            }
         }
      );
      AV20Pgmname = "EsquemaHorasEspecialesGeneral" ;
      /* GeneXus formulas. */
      AV20Pgmname = "EsquemaHorasEspecialesGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A1328ConveHsPDiaDia ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA1564CliPaiConve ;
   private short wcpOA1327ConveHsExSec ;
   private short A1564CliPaiConve ;
   private short A1327ConveHsExSec ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int A3CliCod ;
   private int edtConveHsPDiaDesde_Enabled ;
   private int edtConveTarifaPDia_Enabled ;
   private int edtConveTarifaPDRec_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtCliCod_Visible ;
   private int edtCliPaiConve_Visible ;
   private int edtCliConvenio_Visible ;
   private int edtConveHsExSec_Visible ;
   private int gxdynajaxindex ;
   private int AV14CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private java.math.BigDecimal A1330ConveTarifaPDia ;
   private java.math.BigDecimal A1350ConveTarifaPDRec ;
   private String wcpOA1565CliConvenio ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A1565CliConvenio ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String A1326ConvHsPDiaTipTra ;
   private String edtConveHsPDiaDesde_Internalname ;
   private String A1329ConveHsPDiaDesde ;
   private String edtConveHsPDiaDesde_Jsonclick ;
   private String edtConveTarifaPDia_Internalname ;
   private String edtConveTarifaPDia_Jsonclick ;
   private String edtConveTarifaPDRec_Internalname ;
   private String edtConveTarifaPDRec_Jsonclick ;
   private String A2432ConveTarifaPDCri ;
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
   private String edtConveHsExSec_Internalname ;
   private String edtConveHsExSec_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV20Pgmname ;
   private String sCtrlA3CliCod ;
   private String sCtrlA1564CliPaiConve ;
   private String sCtrlA1565CliConvenio ;
   private String sCtrlA1327ConveHsExSec ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1329ConveHsPDiaDesde ;
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
   private HTMLChoice dynConvHsPDiaTipTra ;
   private HTMLChoice cmbConveHsPDiaDia ;
   private HTMLChoice cmbConveTarifaPDCri ;
   private IDataStoreProvider pr_default ;
   private String[] H00QG2_A1292TipoTraId ;
   private String[] H00QG2_A1293TipoTraNom ;
   private String[] H00QG3_A1292TipoTraId ;
   private String[] H00QG3_A1293TipoTraNom ;
   private int[] H00QG4_A3CliCod ;
   private short[] H00QG4_A1564CliPaiConve ;
   private String[] H00QG4_A1565CliConvenio ;
   private short[] H00QG4_A1327ConveHsExSec ;
   private String[] H00QG4_A2432ConveTarifaPDCri ;
   private java.math.BigDecimal[] H00QG4_A1350ConveTarifaPDRec ;
   private java.math.BigDecimal[] H00QG4_A1330ConveTarifaPDia ;
   private String[] H00QG4_A1329ConveHsPDiaDesde ;
   private boolean[] H00QG4_n1329ConveHsPDiaDesde ;
   private byte[] H00QG4_A1328ConveHsPDiaDia ;
   private String[] H00QG4_A1326ConvHsPDiaTipTra ;
   private String[] H00QG5_A1292TipoTraId ;
   private String[] H00QG5_A1293TipoTraNom ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class esquemahorasespecialesgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00QG2", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo ORDER BY TipoTraNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00QG3", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo ORDER BY TipoTraNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00QG4", "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsExSec, ConveTarifaPDCri, ConveTarifaPDRec, ConveTarifaPDia, ConveHsPDiaDesde, ConveHsPDiaDia, ConvHsPDiaTipTra FROM Convenio_horasextras_porDia WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveHsExSec = ? ORDER BY CliCod, CliPaiConve, CliConvenio, ConveHsExSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00QG5", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo ORDER BY TipoTraNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((String[]) buf[7])[0] = rslt.getString(8, 5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 20);
               return;
            case 3 :
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
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

