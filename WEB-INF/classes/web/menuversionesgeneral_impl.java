package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class menuversionesgeneral_impl extends GXWebComponent
{
   public menuversionesgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public menuversionesgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuversionesgeneral_impl.class ));
   }

   public menuversionesgeneral_impl( int remoteHandle ,
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
      dynPerfilId = new HTMLChoice();
      dynMenuPais = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "RolId") ;
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
               A1923RolId = (byte)(GXutil.lval( httpContext.GetPar( "RolId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
               A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
               A1928MenuVerId = GXutil.lval( httpContext.GetPar( "MenuVerId")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Byte.valueOf(A1923RolId),Byte.valueOf(A1925PerfilId),Long.valueOf(A1928MenuVerId)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"MENUPAIS") == 0 )
            {
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlamenupaisLA2( ) ;
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
               gxfirstwebparm = httpContext.GetFirstPar( "RolId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "RolId") ;
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
         paLA2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Menu Versiones General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.menuversionesgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A1923RolId,2,0)),GXutil.URLEncode(GXutil.ltrimstr(A1925PerfilId,2,0)),GXutil.URLEncode(GXutil.ltrimstr(A1928MenuVerId,15,0))}, new String[] {"RolId","PerfilId","MenuVerId"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1923RolId", GXutil.ltrim( localUtil.ntoc( wcpOA1923RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1925PerfilId", GXutil.ltrim( localUtil.ntoc( wcpOA1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1928MenuVerId", GXutil.ltrim( localUtil.ntoc( wcpOA1928MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseFormLA2( )
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
      return "MenuVersionesGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Menu Versiones General", "") ;
   }

   public void wbLA0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.menuversionesgeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynPerfilId.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynPerfilId.getInternalname(), httpContext.getMessage( "Perfil", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynPerfilId, dynPerfilId.getInternalname(), GXutil.trim( GXutil.str( A1925PerfilId, 2, 0)), 1, dynPerfilId.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynPerfilId.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_MenuVersionesGeneral.htm");
         dynPerfilId.setValue( GXutil.trim( GXutil.str( A1925PerfilId, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynPerfilId.getInternalname(), "Values", dynPerfilId.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMenuVerId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMenuVerId_Internalname, httpContext.getMessage( "Versión de menú", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMenuVerId_Internalname, GXutil.ltrim( localUtil.ntoc( A1928MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMenuVerId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1928MenuVerId), "ZZZZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1928MenuVerId), "ZZZZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMenuVerId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMenuVerId_Enabled, 0, "text", "1", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "ID", "right", false, "", "HLP_MenuVersionesGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynMenuPais.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynMenuPais.getInternalname(), httpContext.getMessage( "Pais", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynMenuPais, dynMenuPais.getInternalname(), GXutil.trim( GXutil.str( A1927MenuPais, 4, 0)), 1, dynMenuPais.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynMenuPais.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_MenuVersionesGeneral.htm");
         dynMenuPais.setValue( GXutil.trim( GXutil.str( A1927MenuPais, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynMenuPais.getInternalname(), "Values", dynMenuPais.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11la1_client"+"'", TempTags, "", 2, "HLP_MenuVersionesGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12la1_client"+"'", TempTags, "", 2, "HLP_MenuVersionesGeneral.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtRolId_Internalname, GXutil.ltrim( localUtil.ntoc( A1923RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1923RolId), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRolId_Jsonclick, 0, "Attribute", "", "", "", "", edtRolId_Visible, 0, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MenuVersionesGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startLA2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Menu Versiones General", ""), (short)(0)) ;
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
            strupLA0( ) ;
         }
      }
   }

   public void wsLA2( )
   {
      startLA2( ) ;
      evtLA2( ) ;
   }

   public void evtLA2( )
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
                              strupLA0( ) ;
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
                              strupLA0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13LA2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupLA0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14LA2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupLA0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15LA2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupLA0( ) ;
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
                              strupLA0( ) ;
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

   public void weLA2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormLA2( ) ;
         }
      }
   }

   public void paLA2( )
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

   public void gxdlaperfilidLA1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaperfilid_dataLA1( ) ;
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

   public void gxaperfilid_htmlLA1( )
   {
      byte gxdynajaxvalue;
      gxdlaperfilid_dataLA1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynPerfilId.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (byte)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynPerfilId.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 2, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynPerfilId.getItemCount() > 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValidValue(GXutil.trim( GXutil.str( A1925PerfilId, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
      }
   }

   protected void gxdlaperfilid_dataLA1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00LA2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00LA2_A1925PerfilId[0], (byte)(2), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00LA2_A1926PerfilNombre[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlamenupaisLA2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlamenupais_dataLA2( ) ;
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

   public void gxamenupais_htmlLA2( )
   {
      short gxdynajaxvalue;
      gxdlamenupais_dataLA2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynMenuPais.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynMenuPais.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlamenupais_dataLA2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00LA3 */
      pr_default.execute(1);
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00LA3_A1927MenuPais[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00LA3_A312PaiNom[0]);
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
         gxamenupais_htmlLA2( ) ;
         dynPerfilId.setName( "PERFILID" );
         dynPerfilId.setWebtags( "" );
         dynPerfilId.removeAllItems();
         /* Using cursor H00LA4 */
         pr_default.execute(2);
         while ( (pr_default.getStatus(2) != 101) )
         {
            dynPerfilId.addItem(GXutil.trim( GXutil.str( H00LA4_A1925PerfilId[0], 2, 0)), H00LA4_A1926PerfilNombre[0], (short)(0));
            pr_default.readNext(2);
         }
         pr_default.close(2);
         if ( dynPerfilId.getItemCount() > 0 )
         {
            A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValidValue(GXutil.trim( GXutil.str( A1925PerfilId, 2, 0))))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynPerfilId.getItemCount() > 0 )
      {
         A1925PerfilId = (byte)(GXutil.lval( dynPerfilId.getValidValue(GXutil.trim( GXutil.str( A1925PerfilId, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPerfilId.setValue( GXutil.trim( GXutil.str( A1925PerfilId, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynPerfilId.getInternalname(), "Values", dynPerfilId.ToJavascriptSource(), true);
      }
      if ( dynMenuPais.getItemCount() > 0 )
      {
         A1927MenuPais = (short)(GXutil.lval( dynMenuPais.getValidValue(GXutil.trim( GXutil.str( A1927MenuPais, 4, 0))))) ;
         n1927MenuPais = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1927MenuPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1927MenuPais), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynMenuPais.setValue( GXutil.trim( GXutil.str( A1927MenuPais, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynMenuPais.getInternalname(), "Values", dynMenuPais.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfLA2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "MenuVersionesGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rfLA2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15LA2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00LA5 */
         pr_default.execute(3, new Object[] {Byte.valueOf(A1923RolId), Byte.valueOf(A1925PerfilId), Long.valueOf(A1928MenuVerId)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A1927MenuPais = H00LA5_A1927MenuPais[0] ;
            n1927MenuPais = H00LA5_n1927MenuPais[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1927MenuPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1927MenuPais), 4, 0));
            gxamenupais_htmlLA2( ) ;
            /* Execute user event: Load */
            e14LA2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(3);
         wbLA0( ) ;
      }
   }

   public void send_integrity_lvl_hashesLA2( )
   {
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "MenuVersionesGeneral" ;
      Gx_err = (short)(0) ;
      gxamenupais_htmlLA2( ) ;
      fix_multi_value_controls( ) ;
   }

   public void strupLA0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13LA2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA1923RolId = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1923RolId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1925PerfilId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1928MenuVerId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1928MenuVerId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         /* Read variables values. */
         dynMenuPais.setValue( httpContext.cgiGet( dynMenuPais.getInternalname()) );
         A1927MenuPais = (short)(GXutil.lval( httpContext.cgiGet( dynMenuPais.getInternalname()))) ;
         n1927MenuPais = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1927MenuPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1927MenuPais), 4, 0));
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         gxamenupais_htmlLA2( ) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e13LA2 ();
      if (returnInSub) return;
   }

   public void e13LA2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      menuversionesgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e14LA2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtRolId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtRolId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRolId_Visible), 5, 0), true);
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuVersiones_Update", GXv_boolean5) ;
      menuversionesgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuVersiones_Delete", GXv_boolean5) ;
      menuversionesgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "MenuVersiones" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15LA2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      menuversionesgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A1923RolId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
      A1925PerfilId = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
      A1928MenuVerId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
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
      paLA2( ) ;
      wsLA2( ) ;
      weLA2( ) ;
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
      sCtrlA1923RolId = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlA1925PerfilId = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlA1928MenuVerId = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paLA2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "menuversionesgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paLA2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A1923RolId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
         A1925PerfilId = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1928MenuVerId = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.LONG), TypeConstants.LONG)).longValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
      }
      wcpOA1923RolId = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1923RolId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1925PerfilId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1928MenuVerId = localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1928MenuVerId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      if ( ! GetJustCreated( ) && ( ( A1923RolId != wcpOA1923RolId ) || ( A1925PerfilId != wcpOA1925PerfilId ) || ( A1928MenuVerId != wcpOA1928MenuVerId ) ) )
      {
         setjustcreated();
      }
      wcpOA1923RolId = A1923RolId ;
      wcpOA1925PerfilId = A1925PerfilId ;
      wcpOA1928MenuVerId = A1928MenuVerId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA1923RolId = httpContext.cgiGet( sPrefix+"A1923RolId_CTRL") ;
      if ( GXutil.len( sCtrlA1923RolId) > 0 )
      {
         A1923RolId = (byte)(localUtil.ctol( httpContext.cgiGet( sCtrlA1923RolId), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1923RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1923RolId), 2, 0));
      }
      else
      {
         A1923RolId = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1923RolId_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlA1925PerfilId = httpContext.cgiGet( sPrefix+"A1925PerfilId_CTRL") ;
      if ( GXutil.len( sCtrlA1925PerfilId) > 0 )
      {
         A1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( sCtrlA1925PerfilId), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
      }
      else
      {
         A1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A1925PerfilId_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlA1928MenuVerId = httpContext.cgiGet( sPrefix+"A1928MenuVerId_CTRL") ;
      if ( GXutil.len( sCtrlA1928MenuVerId) > 0 )
      {
         A1928MenuVerId = localUtil.ctol( httpContext.cgiGet( sCtrlA1928MenuVerId), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1928MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1928MenuVerId), 15, 0));
      }
      else
      {
         A1928MenuVerId = localUtil.ctol( httpContext.cgiGet( sPrefix+"A1928MenuVerId_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
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
      paLA2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsLA2( ) ;
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
      wsLA2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1923RolId_PARM", GXutil.ltrim( localUtil.ntoc( A1923RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1923RolId)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1923RolId_CTRL", GXutil.rtrim( sCtrlA1923RolId));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1925PerfilId_PARM", GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1925PerfilId)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1925PerfilId_CTRL", GXutil.rtrim( sCtrlA1925PerfilId));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1928MenuVerId_PARM", GXutil.ltrim( localUtil.ntoc( A1928MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1928MenuVerId)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1928MenuVerId_CTRL", GXutil.rtrim( sCtrlA1928MenuVerId));
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
      weLA2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025187483317", true, true);
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
      httpContext.AddJavascriptSource("menuversionesgeneral.js", "?2025187483317", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynPerfilId.setInternalname( sPrefix+"PERFILID" );
      edtMenuVerId_Internalname = sPrefix+"MENUVERID" ;
      dynMenuPais.setInternalname( sPrefix+"MENUPAIS" );
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtRolId_Internalname = sPrefix+"ROLID" ;
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
      edtRolId_Jsonclick = "" ;
      edtRolId_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      dynMenuPais.setJsonclick( "" );
      dynMenuPais.setEnabled( 0 );
      edtMenuVerId_Jsonclick = "" ;
      edtMenuVerId_Enabled = 0 ;
      dynPerfilId.setJsonclick( "" );
      dynPerfilId.setEnabled( 0 );
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
      dynPerfilId.setName( "PERFILID" );
      dynPerfilId.setWebtags( "" );
      dynPerfilId.removeAllItems();
      /* Using cursor H00LA6 */
      pr_default.execute(4);
      while ( (pr_default.getStatus(4) != 101) )
      {
         dynPerfilId.addItem(GXutil.trim( GXutil.str( H00LA6_A1925PerfilId[0], 2, 0)), H00LA6_A1926PerfilNombre[0], (short)(0));
         pr_default.readNext(4);
      }
      pr_default.close(4);
      if ( dynPerfilId.getItemCount() > 0 )
      {
      }
      dynMenuPais.setName( "MENUPAIS" );
      dynMenuPais.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A1923RolId',fld:'ROLID',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID',pic:'ZZZZZZZZZZZZZZ9'},{av:'dynMenuPais'},{av:'A1927MenuPais',fld:'MENUPAIS',pic:'ZZZ9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11LA1',iparms:[{av:'A1923RolId',fld:'ROLID',pic:'Z9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID',pic:'ZZZZZZZZZZZZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12LA1',iparms:[{av:'A1923RolId',fld:'ROLID',pic:'Z9'},{av:'dynPerfilId'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID',pic:'ZZZZZZZZZZZZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_PERFILID","{handler:'valid_Perfilid',iparms:[]");
      setEventMetadata("VALID_PERFILID",",oparms:[]}");
      setEventMetadata("VALID_MENUVERID","{handler:'valid_Menuverid',iparms:[]");
      setEventMetadata("VALID_MENUVERID",",oparms:[]}");
      setEventMetadata("VALID_ROLID","{handler:'valid_Rolid',iparms:[]");
      setEventMetadata("VALID_ROLID",",oparms:[]}");
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
      H00LA2_A1925PerfilId = new byte[1] ;
      H00LA2_A1926PerfilNombre = new String[] {""} ;
      H00LA3_A1927MenuPais = new short[1] ;
      H00LA3_n1927MenuPais = new boolean[] {false} ;
      H00LA3_A312PaiNom = new String[] {""} ;
      H00LA3_n312PaiNom = new boolean[] {false} ;
      H00LA4_A1925PerfilId = new byte[1] ;
      H00LA4_A1926PerfilNombre = new String[] {""} ;
      AV17Pgmname = "" ;
      H00LA5_A1923RolId = new byte[1] ;
      H00LA5_A1925PerfilId = new byte[1] ;
      H00LA5_A1928MenuVerId = new long[1] ;
      H00LA5_A1927MenuPais = new short[1] ;
      H00LA5_n1927MenuPais = new boolean[] {false} ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA1923RolId = "" ;
      sCtrlA1925PerfilId = "" ;
      sCtrlA1928MenuVerId = "" ;
      H00LA6_A1925PerfilId = new byte[1] ;
      H00LA6_A1926PerfilNombre = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.menuversionesgeneral__default(),
         new Object[] {
             new Object[] {
            H00LA2_A1925PerfilId, H00LA2_A1926PerfilNombre
            }
            , new Object[] {
            H00LA3_A1927MenuPais, H00LA3_A312PaiNom, H00LA3_n312PaiNom
            }
            , new Object[] {
            H00LA4_A1925PerfilId, H00LA4_A1926PerfilNombre
            }
            , new Object[] {
            H00LA5_A1923RolId, H00LA5_A1925PerfilId, H00LA5_A1928MenuVerId, H00LA5_A1927MenuPais, H00LA5_n1927MenuPais
            }
            , new Object[] {
            H00LA6_A1925PerfilId, H00LA6_A1926PerfilNombre
            }
         }
      );
      AV17Pgmname = "MenuVersionesGeneral" ;
      /* GeneXus formulas. */
      AV17Pgmname = "MenuVersionesGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte wcpOA1923RolId ;
   private byte wcpOA1925PerfilId ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A1923RolId ;
   private byte A1925PerfilId ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short A1927MenuPais ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtMenuVerId_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtRolId_Visible ;
   private int gxdynajaxindex ;
   private int AV13CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private long wcpOA1928MenuVerId ;
   private long A1928MenuVerId ;
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
   private String edtMenuVerId_Internalname ;
   private String edtMenuVerId_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtRolId_Internalname ;
   private String edtRolId_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV17Pgmname ;
   private String sCtrlA1923RolId ;
   private String sCtrlA1925PerfilId ;
   private String sCtrlA1928MenuVerId ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1927MenuPais ;
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
   private HTMLChoice dynPerfilId ;
   private HTMLChoice dynMenuPais ;
   private IDataStoreProvider pr_default ;
   private byte[] H00LA2_A1925PerfilId ;
   private String[] H00LA2_A1926PerfilNombre ;
   private short[] H00LA3_A1927MenuPais ;
   private boolean[] H00LA3_n1927MenuPais ;
   private String[] H00LA3_A312PaiNom ;
   private boolean[] H00LA3_n312PaiNom ;
   private byte[] H00LA4_A1925PerfilId ;
   private String[] H00LA4_A1926PerfilNombre ;
   private byte[] H00LA5_A1923RolId ;
   private byte[] H00LA5_A1925PerfilId ;
   private long[] H00LA5_A1928MenuVerId ;
   private short[] H00LA5_A1927MenuPais ;
   private boolean[] H00LA5_n1927MenuPais ;
   private byte[] H00LA6_A1925PerfilId ;
   private String[] H00LA6_A1926PerfilNombre ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class menuversionesgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00LA2", "SELECT PerfilId, PerfilNombre FROM Perfil ORDER BY PerfilNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LA3", "SELECT PaiCod AS MenuPais, PaiNom FROM Pais ORDER BY PaiNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LA4", "SELECT PerfilId, PerfilNombre FROM Perfil ORDER BY PerfilNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LA5", "SELECT RolId, PerfilId, MenuVerId, MenuPais FROM MenuVersiones WHERE RolId = ? and PerfilId = ? and MenuVerId = ? ORDER BY RolId, PerfilId, MenuVerId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00LA6", "SELECT PerfilId, PerfilNombre FROM Perfil ORDER BY PerfilNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 2 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 4 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
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
            case 3 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
      }
   }

}

