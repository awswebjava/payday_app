package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class paistipotrabajogeneral_impl extends GXWebComponent
{
   public paistipotrabajogeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public paistipotrabajogeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paistipotrabajogeneral_impl.class ));
   }

   public paistipotrabajogeneral_impl( int remoteHandle ,
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
      chkPaiTipoTraIns = UIFactory.getCheckbox(this);
      cmbPaiTipoHsMaxMes = new HTMLChoice();
      dynPaiTipoTraRelSec = new HTMLChoice();
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
               A1294PaiTipoTraId = httpContext.GetPar( "PaiTipoTraId") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(A46PaiCod),A1294PaiTipoTraId});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"PAITIPOTRARELSEC") == 0 )
            {
               AV13CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlapaitipotrarelsecGU2( AV13CliCod) ;
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
         paGU2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Pais Tipo Trabajo General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.paistipotrabajogeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A46PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(A1294PaiTipoTraId))}, new String[] {"PaiCod","PaiTipoTraId"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1294PaiTipoTraId", GXutil.rtrim( wcpOA1294PaiTipoTraId));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PAICOD", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PAITIPOTRAID", GXutil.rtrim( A1294PaiTipoTraId));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV13CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormGU2( )
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
      return "PaisTipoTrabajoGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Pais Tipo Trabajo General", "") ;
   }

   public void wbGU0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.paistipotrabajogeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiNom_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiNom_Internalname, httpContext.getMessage( "Pais", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiNom_Internalname, A312PaiNom, GXutil.rtrim( localUtil.format( A312PaiNom, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiNom_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiNom_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_PaisTipoTrabajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTipoTraNom_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiTipoTraNom_Internalname, httpContext.getMessage( "Tipo Trabajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTipoTraNom_Internalname, A1295PaiTipoTraNom, GXutil.rtrim( localUtil.format( A1295PaiTipoTraNom, "@!")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTipoTraNom_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTipoTraNom_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_PaisTipoTrabajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiTipoTraIns.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkPaiTipoTraIns.getInternalname(), httpContext.getMessage( "Trabajo insalubre", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiTipoTraIns.getInternalname(), GXutil.booltostr( A1297PaiTipoTraIns), "", httpContext.getMessage( "Trabajo insalubre", ""), 1, chkPaiTipoTraIns.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTipoHsDia_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiTipoHsDia_Internalname, httpContext.getMessage( "Límite de horas normales por día", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTipoHsDia_Internalname, GXutil.ltrim( localUtil.ntoc( A1336PaiTipoHsDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTipoHsDia_Enabled!=0) ? localUtil.format( A1336PaiTipoHsDia, "9.9") : localUtil.format( A1336PaiTipoHsDia, "9.9"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTipoHsDia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTipoHsDia_Enabled, 0, "text", "", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisTipoTrabajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTipoHsSem_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiTipoHsSem_Internalname, httpContext.getMessage( "Límite de horas normales por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTipoHsSem_Internalname, GXutil.ltrim( localUtil.ntoc( A1337PaiTipoHsSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTipoHsSem_Enabled!=0) ? localUtil.format( A1337PaiTipoHsSem, "Z9.9") : localUtil.format( A1337PaiTipoHsSem, "Z9.9"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTipoHsSem_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTipoHsSem_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisTipoTrabajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTipoHsMaxDia_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiTipoHsMaxDia_Internalname, httpContext.getMessage( "Máximo de horas extras por día", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTipoHsMaxDia_Internalname, GXutil.ltrim( localUtil.ntoc( A1383PaiTipoHsMaxDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTipoHsMaxDia_Enabled!=0) ? localUtil.format( A1383PaiTipoHsMaxDia, "9.9") : localUtil.format( A1383PaiTipoHsMaxDia, "9.9"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTipoHsMaxDia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTipoHsMaxDia_Enabled, 0, "text", "", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisTipoTrabajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTipoHsMaxSem_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiTipoHsMaxSem_Internalname, httpContext.getMessage( "Máximo de horas extras por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTipoHsMaxSem_Internalname, GXutil.ltrim( localUtil.ntoc( A1384PaiTipoHsMaxSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTipoHsMaxSem_Enabled!=0) ? localUtil.format( A1384PaiTipoHsMaxSem, "Z9.9") : localUtil.format( A1384PaiTipoHsMaxSem, "Z9.9"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTipoHsMaxSem_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTipoHsMaxSem_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisTipoTrabajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiTipoHsMaxMes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbPaiTipoHsMaxMes.getInternalname(), httpContext.getMessage( "Máximo de horas extras por mes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiTipoHsMaxMes, cmbPaiTipoHsMaxMes.getInternalname(), GXutil.strNoRound( A1385PaiTipoHsMaxMes, 5, 1), 1, cmbPaiTipoHsMaxMes.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "decimal", "", 1, cmbPaiTipoHsMaxMes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_PaisTipoTrabajoGeneral.htm");
         cmbPaiTipoHsMaxMes.setValue( GXutil.strNoRound( A1385PaiTipoHsMaxMes, 5, 1) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiTipoHsMaxMes.getInternalname(), "Values", cmbPaiTipoHsMaxMes.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTipoHsMaxAnu_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPaiTipoHsMaxAnu_Internalname, httpContext.getMessage( "Máximoi de horas extras por año", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTipoHsMaxAnu_Internalname, GXutil.ltrim( localUtil.ntoc( A1390PaiTipoHsMaxAnu, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTipoHsMaxAnu_Enabled!=0) ? localUtil.format( A1390PaiTipoHsMaxAnu, "ZZ9.9") : localUtil.format( A1390PaiTipoHsMaxAnu, "ZZ9.9"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTipoHsMaxAnu_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTipoHsMaxAnu_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisTipoTrabajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynPaiTipoTraRelSec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynPaiTipoTraRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynPaiTipoTraRelSec, dynPaiTipoTraRelSec.getInternalname(), GXutil.trim( GXutil.str( A2055PaiTipoTraRelSec, 6, 0)), 1, dynPaiTipoTraRelSec.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynPaiTipoTraRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_PaisTipoTrabajoGeneral.htm");
         dynPaiTipoTraRelSec.setValue( GXutil.trim( GXutil.str( A2055PaiTipoTraRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynPaiTipoTraRelSec.getInternalname(), "Values", dynPaiTipoTraRelSec.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11gu1_client"+"'", TempTags, "", 2, "HLP_PaisTipoTrabajoGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12gu1_client"+"'", TempTags, "", 2, "HLP_PaisTipoTrabajoGeneral.htm");
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

   public void startGU2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Pais Tipo Trabajo General", ""), (short)(0)) ;
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
            strupGU0( ) ;
         }
      }
   }

   public void wsGU2( )
   {
      startGU2( ) ;
      evtGU2( ) ;
   }

   public void evtGU2( )
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
                              strupGU0( ) ;
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
                              strupGU0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13GU2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupGU0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14GU2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupGU0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15GU2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupGU0( ) ;
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
                              strupGU0( ) ;
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

   public void weGU2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormGU2( ) ;
         }
      }
   }

   public void paGU2( )
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

   public void gxdlapaitipotrarelsecGU2( int AV13CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlapaitipotrarelsec_dataGU2( AV13CliCod) ;
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

   public void gxapaitipotrarelsec_htmlGU2( int AV13CliCod )
   {
      int gxdynajaxvalue;
      gxdlapaitipotrarelsec_dataGU2( AV13CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynPaiTipoTraRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynPaiTipoTraRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlapaitipotrarelsec_dataGU2( int AV13CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00GU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00GU2_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00GU2_A1880CliReDTChar[0]);
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
      A1297PaiTipoTraIns = GXutil.strtobool( GXutil.booltostr( A1297PaiTipoTraIns)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1297PaiTipoTraIns", A1297PaiTipoTraIns);
      if ( cmbPaiTipoHsMaxMes.getItemCount() > 0 )
      {
         A1385PaiTipoHsMaxMes = DecimalUtil.stringToDec( cmbPaiTipoHsMaxMes.getValidValue(GXutil.strNoRound( A1385PaiTipoHsMaxMes, 5, 1))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1385PaiTipoHsMaxMes", GXutil.ltrimstr( A1385PaiTipoHsMaxMes, 5, 1));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiTipoHsMaxMes.setValue( GXutil.strNoRound( A1385PaiTipoHsMaxMes, 5, 1) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPaiTipoHsMaxMes.getInternalname(), "Values", cmbPaiTipoHsMaxMes.ToJavascriptSource(), true);
      }
      if ( dynPaiTipoTraRelSec.getItemCount() > 0 )
      {
         A2055PaiTipoTraRelSec = (int)(GXutil.lval( dynPaiTipoTraRelSec.getValidValue(GXutil.trim( GXutil.str( A2055PaiTipoTraRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2055PaiTipoTraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2055PaiTipoTraRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPaiTipoTraRelSec.setValue( GXutil.trim( GXutil.str( A2055PaiTipoTraRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynPaiTipoTraRelSec.getInternalname(), "Values", dynPaiTipoTraRelSec.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfGU2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "PaisTipoTrabajoGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rfGU2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15GU2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00GU3 */
         pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A1292TipoTraId = H00GU3_A1292TipoTraId[0] ;
            A1293TipoTraNom = H00GU3_A1293TipoTraNom[0] ;
            A2055PaiTipoTraRelSec = H00GU3_A2055PaiTipoTraRelSec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2055PaiTipoTraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2055PaiTipoTraRelSec), 6, 0));
            A1390PaiTipoHsMaxAnu = H00GU3_A1390PaiTipoHsMaxAnu[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1390PaiTipoHsMaxAnu", GXutil.ltrimstr( A1390PaiTipoHsMaxAnu, 5, 1));
            A1385PaiTipoHsMaxMes = H00GU3_A1385PaiTipoHsMaxMes[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1385PaiTipoHsMaxMes", GXutil.ltrimstr( A1385PaiTipoHsMaxMes, 5, 1));
            A1384PaiTipoHsMaxSem = H00GU3_A1384PaiTipoHsMaxSem[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1384PaiTipoHsMaxSem", GXutil.ltrimstr( A1384PaiTipoHsMaxSem, 4, 1));
            A1383PaiTipoHsMaxDia = H00GU3_A1383PaiTipoHsMaxDia[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1383PaiTipoHsMaxDia", GXutil.ltrimstr( A1383PaiTipoHsMaxDia, 3, 1));
            A1337PaiTipoHsSem = H00GU3_A1337PaiTipoHsSem[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1337PaiTipoHsSem", GXutil.ltrimstr( A1337PaiTipoHsSem, 4, 1));
            A1336PaiTipoHsDia = H00GU3_A1336PaiTipoHsDia[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1336PaiTipoHsDia", GXutil.ltrimstr( A1336PaiTipoHsDia, 3, 1));
            A1297PaiTipoTraIns = H00GU3_A1297PaiTipoTraIns[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1297PaiTipoTraIns", A1297PaiTipoTraIns);
            /* Execute user event: Load */
            e14GU2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         wbGU0( ) ;
      }
   }

   public void send_integrity_lvl_hashesGU2( )
   {
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "PaisTipoTrabajoGeneral" ;
      Gx_err = (short)(0) ;
      /* Using cursor H00GU4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod)});
      A312PaiNom = H00GU4_A312PaiNom[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A312PaiNom", A312PaiNom);
      pr_default.close(2);
      /* Using cursor H00GU5 */
      pr_default.execute(3, new Object[] {A1294PaiTipoTraId});
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(3);
      fix_multi_value_controls( ) ;
   }

   public void strupGU0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13GU2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1294PaiTipoTraId = httpContext.cgiGet( sPrefix+"wcpOA1294PaiTipoTraId") ;
         A1294PaiTipoTraId = httpContext.cgiGet( sPrefix+"PAITIPOTRAID") ;
         A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"PAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         A312PaiNom = GXutil.upper( httpContext.cgiGet( edtPaiNom_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A312PaiNom", A312PaiNom);
         A1295PaiTipoTraNom = GXutil.upper( httpContext.cgiGet( edtPaiTipoTraNom_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1295PaiTipoTraNom", A1295PaiTipoTraNom);
         A1297PaiTipoTraIns = GXutil.strtobool( httpContext.cgiGet( chkPaiTipoTraIns.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1297PaiTipoTraIns", A1297PaiTipoTraIns);
         A1336PaiTipoHsDia = localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsDia_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1336PaiTipoHsDia", GXutil.ltrimstr( A1336PaiTipoHsDia, 3, 1));
         A1337PaiTipoHsSem = localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsSem_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1337PaiTipoHsSem", GXutil.ltrimstr( A1337PaiTipoHsSem, 4, 1));
         A1383PaiTipoHsMaxDia = localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsMaxDia_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1383PaiTipoHsMaxDia", GXutil.ltrimstr( A1383PaiTipoHsMaxDia, 3, 1));
         A1384PaiTipoHsMaxSem = localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsMaxSem_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1384PaiTipoHsMaxSem", GXutil.ltrimstr( A1384PaiTipoHsMaxSem, 4, 1));
         cmbPaiTipoHsMaxMes.setValue( httpContext.cgiGet( cmbPaiTipoHsMaxMes.getInternalname()) );
         A1385PaiTipoHsMaxMes = DecimalUtil.stringToDec( httpContext.cgiGet( cmbPaiTipoHsMaxMes.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1385PaiTipoHsMaxMes", GXutil.ltrimstr( A1385PaiTipoHsMaxMes, 5, 1));
         A1390PaiTipoHsMaxAnu = localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsMaxAnu_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1390PaiTipoHsMaxAnu", GXutil.ltrimstr( A1390PaiTipoHsMaxAnu, 5, 1));
         dynPaiTipoTraRelSec.setValue( httpContext.cgiGet( dynPaiTipoTraRelSec.getInternalname()) );
         A2055PaiTipoTraRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynPaiTipoTraRelSec.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A2055PaiTipoTraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2055PaiTipoTraRelSec), 6, 0));
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
      e13GU2 ();
      if (returnInSub) return;
   }

   public void e13GU2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      paistipotrabajogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e14GU2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisTipoTrabajo_Update", GXv_boolean5) ;
      paistipotrabajogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisTipoTrabajo_Delete", GXv_boolean5) ;
      paistipotrabajogeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "PaisTipoTrabajo" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15GU2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      paistipotrabajogeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A1294PaiTipoTraId = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
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
      paGU2( ) ;
      wsGU2( ) ;
      weGU2( ) ;
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
      sCtrlA1294PaiTipoTraId = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paGU2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "paistipotrabajogeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paGU2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1294PaiTipoTraId = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
      wcpOA46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1294PaiTipoTraId = httpContext.cgiGet( sPrefix+"wcpOA1294PaiTipoTraId") ;
      if ( ! GetJustCreated( ) && ( ( A46PaiCod != wcpOA46PaiCod ) || ( GXutil.strcmp(A1294PaiTipoTraId, wcpOA1294PaiTipoTraId) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOA46PaiCod = A46PaiCod ;
      wcpOA1294PaiTipoTraId = A1294PaiTipoTraId ;
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
      sCtrlA1294PaiTipoTraId = httpContext.cgiGet( sPrefix+"A1294PaiTipoTraId_CTRL") ;
      if ( GXutil.len( sCtrlA1294PaiTipoTraId) > 0 )
      {
         A1294PaiTipoTraId = httpContext.cgiGet( sCtrlA1294PaiTipoTraId) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
      else
      {
         A1294PaiTipoTraId = httpContext.cgiGet( sPrefix+"A1294PaiTipoTraId_PARM") ;
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
      paGU2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsGU2( ) ;
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
      wsGU2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1294PaiTipoTraId_PARM", GXutil.rtrim( A1294PaiTipoTraId));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1294PaiTipoTraId)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1294PaiTipoTraId_CTRL", GXutil.rtrim( sCtrlA1294PaiTipoTraId));
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
      weGU2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181932154", true, true);
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
      httpContext.AddJavascriptSource("paistipotrabajogeneral.js", "?2025181932155", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtPaiNom_Internalname = sPrefix+"PAINOM" ;
      edtPaiTipoTraNom_Internalname = sPrefix+"PAITIPOTRANOM" ;
      chkPaiTipoTraIns.setInternalname( sPrefix+"PAITIPOTRAINS" );
      edtPaiTipoHsDia_Internalname = sPrefix+"PAITIPOHSDIA" ;
      edtPaiTipoHsSem_Internalname = sPrefix+"PAITIPOHSSEM" ;
      edtPaiTipoHsMaxDia_Internalname = sPrefix+"PAITIPOHSMAXDIA" ;
      edtPaiTipoHsMaxSem_Internalname = sPrefix+"PAITIPOHSMAXSEM" ;
      cmbPaiTipoHsMaxMes.setInternalname( sPrefix+"PAITIPOHSMAXMES" );
      edtPaiTipoHsMaxAnu_Internalname = sPrefix+"PAITIPOHSMAXANU" ;
      dynPaiTipoTraRelSec.setInternalname( sPrefix+"PAITIPOTRARELSEC" );
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
      dynPaiTipoTraRelSec.setJsonclick( "" );
      dynPaiTipoTraRelSec.setEnabled( 0 );
      edtPaiTipoHsMaxAnu_Jsonclick = "" ;
      edtPaiTipoHsMaxAnu_Enabled = 0 ;
      cmbPaiTipoHsMaxMes.setJsonclick( "" );
      cmbPaiTipoHsMaxMes.setEnabled( 0 );
      edtPaiTipoHsMaxSem_Jsonclick = "" ;
      edtPaiTipoHsMaxSem_Enabled = 0 ;
      edtPaiTipoHsMaxDia_Jsonclick = "" ;
      edtPaiTipoHsMaxDia_Enabled = 0 ;
      edtPaiTipoHsSem_Jsonclick = "" ;
      edtPaiTipoHsSem_Enabled = 0 ;
      edtPaiTipoHsDia_Jsonclick = "" ;
      edtPaiTipoHsDia_Enabled = 0 ;
      chkPaiTipoTraIns.setEnabled( 0 );
      edtPaiTipoTraNom_Jsonclick = "" ;
      edtPaiTipoTraNom_Enabled = 0 ;
      edtPaiNom_Jsonclick = "" ;
      edtPaiNom_Enabled = 0 ;
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
      chkPaiTipoTraIns.setName( "PAITIPOTRAINS" );
      chkPaiTipoTraIns.setWebtags( "" );
      chkPaiTipoTraIns.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkPaiTipoTraIns.getInternalname(), "TitleCaption", chkPaiTipoTraIns.getCaption(), true);
      chkPaiTipoTraIns.setCheckedValue( "false" );
      cmbPaiTipoHsMaxMes.setName( "PAITIPOHSMAXMES" );
      cmbPaiTipoHsMaxMes.setWebtags( "" );
      if ( cmbPaiTipoHsMaxMes.getItemCount() > 0 )
      {
      }
      dynPaiTipoTraRelSec.setName( "PAITIPOTRARELSEC" );
      dynPaiTipoTraRelSec.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''},{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11GU1',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12GU1',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
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
      wcpOA1294PaiTipoTraId = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A1294PaiTipoTraId = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      A312PaiNom = "" ;
      A1295PaiTipoTraNom = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1336PaiTipoHsDia = DecimalUtil.ZERO ;
      A1337PaiTipoHsSem = DecimalUtil.ZERO ;
      A1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      A1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      A1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      A1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
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
      H00GU2_A1885CliRelSec = new int[1] ;
      H00GU2_A1880CliReDTChar = new String[] {""} ;
      H00GU2_A3CliCod = new int[1] ;
      AV17Pgmname = "" ;
      H00GU3_A1292TipoTraId = new String[] {""} ;
      H00GU3_A1293TipoTraNom = new String[] {""} ;
      H00GU3_A46PaiCod = new short[1] ;
      H00GU3_A1294PaiTipoTraId = new String[] {""} ;
      H00GU3_A2055PaiTipoTraRelSec = new int[1] ;
      H00GU3_A1390PaiTipoHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00GU3_A1385PaiTipoHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00GU3_A1384PaiTipoHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00GU3_A1383PaiTipoHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00GU3_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00GU3_A1336PaiTipoHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00GU3_A1297PaiTipoTraIns = new boolean[] {false} ;
      H00GU3_A312PaiNom = new String[] {""} ;
      A1292TipoTraId = "" ;
      A1293TipoTraNom = "" ;
      H00GU4_A312PaiNom = new String[] {""} ;
      H00GU5_A1292TipoTraId = new String[] {""} ;
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
      sCtrlA1294PaiTipoTraId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paistipotrabajogeneral__default(),
         new Object[] {
             new Object[] {
            H00GU2_A1885CliRelSec, H00GU2_A1880CliReDTChar, H00GU2_A3CliCod
            }
            , new Object[] {
            H00GU3_A1292TipoTraId, H00GU3_A1293TipoTraNom, H00GU3_A46PaiCod, H00GU3_A1294PaiTipoTraId, H00GU3_A2055PaiTipoTraRelSec, H00GU3_A1390PaiTipoHsMaxAnu, H00GU3_A1385PaiTipoHsMaxMes, H00GU3_A1384PaiTipoHsMaxSem, H00GU3_A1383PaiTipoHsMaxDia, H00GU3_A1337PaiTipoHsSem,
            H00GU3_A1336PaiTipoHsDia, H00GU3_A1297PaiTipoTraIns, H00GU3_A312PaiNom
            }
            , new Object[] {
            H00GU4_A312PaiNom
            }
            , new Object[] {
            H00GU5_A1292TipoTraId
            }
         }
      );
      AV17Pgmname = "PaisTipoTrabajoGeneral" ;
      /* GeneXus formulas. */
      AV17Pgmname = "PaisTipoTrabajoGeneral" ;
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
   private int AV13CliCod ;
   private int edtPaiNom_Enabled ;
   private int edtPaiTipoTraNom_Enabled ;
   private int edtPaiTipoHsDia_Enabled ;
   private int edtPaiTipoHsSem_Enabled ;
   private int edtPaiTipoHsMaxDia_Enabled ;
   private int edtPaiTipoHsMaxSem_Enabled ;
   private int edtPaiTipoHsMaxAnu_Enabled ;
   private int A2055PaiTipoTraRelSec ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int gxdynajaxindex ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private java.math.BigDecimal A1336PaiTipoHsDia ;
   private java.math.BigDecimal A1337PaiTipoHsSem ;
   private java.math.BigDecimal A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal A1390PaiTipoHsMaxAnu ;
   private String wcpOA1294PaiTipoTraId ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A1294PaiTipoTraId ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtPaiNom_Internalname ;
   private String edtPaiNom_Jsonclick ;
   private String edtPaiTipoTraNom_Internalname ;
   private String edtPaiTipoTraNom_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtPaiTipoHsDia_Internalname ;
   private String edtPaiTipoHsDia_Jsonclick ;
   private String edtPaiTipoHsSem_Internalname ;
   private String edtPaiTipoHsSem_Jsonclick ;
   private String edtPaiTipoHsMaxDia_Internalname ;
   private String edtPaiTipoHsMaxDia_Jsonclick ;
   private String edtPaiTipoHsMaxSem_Internalname ;
   private String edtPaiTipoHsMaxSem_Jsonclick ;
   private String edtPaiTipoHsMaxAnu_Internalname ;
   private String edtPaiTipoHsMaxAnu_Jsonclick ;
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
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV17Pgmname ;
   private String A1292TipoTraId ;
   private String sCtrlA46PaiCod ;
   private String sCtrlA1294PaiTipoTraId ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A1297PaiTipoTraIns ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String A312PaiNom ;
   private String A1295PaiTipoTraNom ;
   private String A1293TipoTraNom ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private ICheckbox chkPaiTipoTraIns ;
   private HTMLChoice cmbPaiTipoHsMaxMes ;
   private HTMLChoice dynPaiTipoTraRelSec ;
   private IDataStoreProvider pr_default ;
   private int[] H00GU2_A1885CliRelSec ;
   private String[] H00GU2_A1880CliReDTChar ;
   private int[] H00GU2_A3CliCod ;
   private String[] H00GU3_A1292TipoTraId ;
   private String[] H00GU3_A1293TipoTraNom ;
   private short[] H00GU3_A46PaiCod ;
   private String[] H00GU3_A1294PaiTipoTraId ;
   private int[] H00GU3_A2055PaiTipoTraRelSec ;
   private java.math.BigDecimal[] H00GU3_A1390PaiTipoHsMaxAnu ;
   private java.math.BigDecimal[] H00GU3_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] H00GU3_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] H00GU3_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] H00GU3_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] H00GU3_A1336PaiTipoHsDia ;
   private boolean[] H00GU3_A1297PaiTipoTraIns ;
   private String[] H00GU3_A312PaiNom ;
   private String[] H00GU4_A312PaiNom ;
   private String[] H00GU5_A1292TipoTraId ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class paistipotrabajogeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00GU2", "SELECT CliRelSec, CliReDTChar, CliCod FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00GU3", "SELECT T3.TipoTraId, T3.TipoTraNom, T1.PaiCod, T1.PaiTipoTraId, T1.PaiTipoTraRelSec, T1.PaiTipoHsMaxAnu, T1.PaiTipoHsMaxMes, T1.PaiTipoHsMaxSem, T1.PaiTipoHsMaxDia, T1.PaiTipoHsSem, T1.PaiTipoHsDia, T1.PaiTipoTraIns, T2.PaiNom FROM ((PaisTipoTrabajo T1 INNER JOIN Pais T2 ON T2.PaiCod = T1.PaiCod) INNER JOIN TipoTrabajo T3 ON T3.TipoTraId = T1.PaiTipoTraId) WHERE T1.PaiCod = ? and T1.PaiTipoTraId = ( ?) ORDER BY T1.PaiCod, T1.PaiTipoTraId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00GU4", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00GU5", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,1);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

