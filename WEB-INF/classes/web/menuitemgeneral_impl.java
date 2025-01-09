package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class menuitemgeneral_impl extends GXWebComponent
{
   public menuitemgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public menuitemgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuitemgeneral_impl.class ));
   }

   public menuitemgeneral_impl( int remoteHandle ,
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
      dynMItemIcoSVG = new HTMLChoice();
      chkMItemEsMenu = UIFactory.getCheckbox(this);
      chkMItemPadreObl = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "PerfilId") ;
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
               A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
               A1937MenuItemId = httpContext.GetPar( "MenuItemId") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1937MenuItemId", A1937MenuItemId);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Byte.valueOf(A1925PerfilId),A1937MenuItemId});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"MITEMICOSVG") == 0 )
            {
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlamitemicosvgLJ2( ) ;
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
               gxfirstwebparm = httpContext.GetFirstPar( "PerfilId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "PerfilId") ;
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
         paLJ2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Menu Item General", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.menuitemgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A1925PerfilId,2,0)),GXutil.URLEncode(GXutil.rtrim(A1937MenuItemId))}, new String[] {"PerfilId","MenuItemId"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1925PerfilId", GXutil.ltrim( localUtil.ntoc( wcpOA1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA1937MenuItemId", wcpOA1937MenuItemId);
   }

   public void renderHtmlCloseFormLJ2( )
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
      return "MenuItemGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Menu Item General", "") ;
   }

   public void wbLJ0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.menuitemgeneral");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPerfilId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtPerfilId_Internalname, httpContext.getMessage( "Perfil", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPerfilId_Internalname, GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPerfilId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1925PerfilId), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1925PerfilId), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPerfilId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPerfilId_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MenuItemGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMenuItemId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMenuItemId_Internalname, httpContext.getMessage( "Menú item ID", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMenuItemId_Internalname, A1937MenuItemId, GXutil.rtrim( localUtil.format( A1937MenuItemId, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMenuItemId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMenuItemId_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MenuItemGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMenuItemTitulo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMenuItemTitulo_Internalname, httpContext.getMessage( "Título por defecto", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMenuItemTitulo_Internalname, A1939MenuItemTitulo, "", "", (short)(0), 1, edtMenuItemTitulo_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_MenuItemGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynMItemIcoSVG.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynMItemIcoSVG.getInternalname(), httpContext.getMessage( "SVG de ícono por defecto", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynMItemIcoSVG, dynMItemIcoSVG.getInternalname(), GXutil.rtrim( A1957MItemIcoSVG), 1, dynMItemIcoSVG.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, dynMItemIcoSVG.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_MenuItemGeneral.htm");
         dynMItemIcoSVG.setValue( GXutil.rtrim( A1957MItemIcoSVG) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynMItemIcoSVG.getInternalname(), "Values", dynMItemIcoSVG.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMitemIcoImg_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMitemIcoImg_Internalname, httpContext.getMessage( "Img de ícono por defecto", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         ClassString = "Attribute" ;
         StyleString = "" ;
         edtMitemIcoImg_Filename = A1960MitemIcoImgNom ;
         edtMitemIcoImg_Filetype = "" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMitemIcoImg_Internalname, "Filetype", edtMitemIcoImg_Filetype, true);
         edtMitemIcoImg_Filetype = A1959MItemIcoImgExt ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMitemIcoImg_Internalname, "Filetype", edtMitemIcoImg_Filetype, true);
         if ( ! (GXutil.strcmp("", A1958MitemIcoImg)==0) )
         {
            gxblobfileaux.setSource( A1958MitemIcoImg );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtMitemIcoImg_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtMitemIcoImg_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               A1958MitemIcoImg = gxblobfileaux.getURI() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1958MitemIcoImg", A1958MitemIcoImg);
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMitemIcoImg_Internalname, "URL", httpContext.getResourceRelative(A1958MitemIcoImg), true);
               edtMitemIcoImg_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMitemIcoImg_Internalname, "Filetype", edtMitemIcoImg_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMitemIcoImg_Internalname, "URL", httpContext.getResourceRelative(A1958MitemIcoImg), true);
         }
         web.GxWebStd.gx_blob_field( httpContext, edtMitemIcoImg_Internalname, GXutil.rtrim( A1958MitemIcoImg), httpContext.getResourceRelative(A1958MitemIcoImg), ((GXutil.strcmp("", edtMitemIcoImg_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtMitemIcoImg_Filetype)==0) ? A1958MitemIcoImg : edtMitemIcoImg_Filetype)) : edtMitemIcoImg_Contenttype), true, "", edtMitemIcoImg_Parameters, 0, edtMitemIcoImg_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtMitemIcoImg_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+"", "", "", "HLP_MenuItemGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkMItemEsMenu.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkMItemEsMenu.getInternalname(), httpContext.getMessage( "Es menú", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkMItemEsMenu.getInternalname(), GXutil.booltostr( A1938MItemEsMenu), "", httpContext.getMessage( "Es menú", ""), 1, chkMItemEsMenu.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMItemPadreDef_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMItemPadreDef_Internalname, httpContext.getMessage( "Padre default", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtMItemPadreDef_Internalname, A1944MItemPadreDef, GXutil.rtrim( localUtil.format( A1944MItemPadreDef, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMItemPadreDef_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMItemPadreDef_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MenuItemGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkMItemPadreObl.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkMItemPadreObl.getInternalname(), httpContext.getMessage( "Padre default es obligatorio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkMItemPadreObl.getInternalname(), GXutil.booltostr( A1945MItemPadreObl), "", httpContext.getMessage( "Padre default es obligatorio", ""), 1, chkMItemPadreObl.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMItemBienTitDef_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMItemBienTitDef_Internalname, httpContext.getMessage( "Título de bienvenida por defecto", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMItemBienTitDef_Internalname, A1955MItemBienTitDef, "", "", (short)(0), 1, edtMItemBienTitDef_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_MenuItemGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMItemBienTextDef_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMItemBienTextDef_Internalname, httpContext.getMessage( "Texto de bienvenida por defecto", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMItemBienTextDef_Internalname, A1956MItemBienTextDef, "", "", (short)(0), 1, edtMItemBienTextDef_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_MenuItemGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMItemBienImgDef_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMItemBienImgDef_Internalname, httpContext.getMessage( "Imagen de bienvenida por defecto", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         ClassString = "Attribute" ;
         StyleString = "" ;
         edtMItemBienImgDef_Filename = A1954MItemBienImgNom ;
         edtMItemBienImgDef_Filetype = "" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMItemBienImgDef_Internalname, "Filetype", edtMItemBienImgDef_Filetype, true);
         edtMItemBienImgDef_Filetype = A1953MItemBienImgExt ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMItemBienImgDef_Internalname, "Filetype", edtMItemBienImgDef_Filetype, true);
         if ( ! (GXutil.strcmp("", A1952MItemBienImgDef)==0) )
         {
            gxblobfileaux.setSource( A1952MItemBienImgDef );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtMItemBienImgDef_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtMItemBienImgDef_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               A1952MItemBienImgDef = gxblobfileaux.getURI() ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1952MItemBienImgDef", A1952MItemBienImgDef);
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMItemBienImgDef_Internalname, "URL", httpContext.getResourceRelative(A1952MItemBienImgDef), true);
               edtMItemBienImgDef_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMItemBienImgDef_Internalname, "Filetype", edtMItemBienImgDef_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMItemBienImgDef_Internalname, "URL", httpContext.getResourceRelative(A1952MItemBienImgDef), true);
         }
         web.GxWebStd.gx_blob_field( httpContext, edtMItemBienImgDef_Internalname, GXutil.rtrim( A1952MItemBienImgDef), httpContext.getResourceRelative(A1952MItemBienImgDef), ((GXutil.strcmp("", edtMItemBienImgDef_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtMItemBienImgDef_Filetype)==0) ? A1952MItemBienImgDef : edtMItemBienImgDef_Filetype)) : edtMItemBienImgDef_Contenttype), true, "", edtMItemBienImgDef_Parameters, 0, edtMItemBienImgDef_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtMItemBienImgDef_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+"", "", "", "HLP_MenuItemGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMItemHelp_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtMItemHelp_Internalname, httpContext.getMessage( "Help", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtMItemHelp_Internalname, A1961MItemHelp, "", "", (short)(0), 1, edtMItemHelp_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_MenuItemGeneral.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", httpContext.getMessage( "GXM_update", ""), bttBtnupdate_Jsonclick, 7, httpContext.getMessage( "GXM_update", ""), "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11lj1_client"+"'", TempTags, "", 2, "HLP_MenuItemGeneral.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtndelete_Jsonclick, 7, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12lj1_client"+"'", TempTags, "", 2, "HLP_MenuItemGeneral.htm");
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

   public void startLJ2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Menu Item General", ""), (short)(0)) ;
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
            strupLJ0( ) ;
         }
      }
   }

   public void wsLJ2( )
   {
      startLJ2( ) ;
      evtLJ2( ) ;
   }

   public void evtLJ2( )
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
                              strupLJ0( ) ;
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
                              strupLJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13LJ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupLJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14LJ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupLJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15LJ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupLJ0( ) ;
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
                              strupLJ0( ) ;
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

   public void weLJ2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormLJ2( ) ;
         }
      }
   }

   public void paLJ2( )
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

   public void gxdlamitemicosvgLJ2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlamitemicosvg_dataLJ2( ) ;
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

   public void gxamitemicosvg_htmlLJ2( )
   {
      String gxdynajaxvalue;
      gxdlamitemicosvg_dataLJ2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynMItemIcoSVG.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynMItemIcoSVG.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlamitemicosvg_dataLJ2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00LJ2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00LJ2_A1957MItemIcoSVG[0]));
         gxdynajaxctrldescr.add(GXutil.rtrim( H00LJ2_A1957MItemIcoSVG[0]));
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
         gxamitemicosvg_htmlLJ2( ) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynMItemIcoSVG.getItemCount() > 0 )
      {
         A1957MItemIcoSVG = dynMItemIcoSVG.getValidValue(A1957MItemIcoSVG) ;
         n1957MItemIcoSVG = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1957MItemIcoSVG", A1957MItemIcoSVG);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynMItemIcoSVG.setValue( GXutil.rtrim( A1957MItemIcoSVG) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynMItemIcoSVG.getInternalname(), "Values", dynMItemIcoSVG.ToJavascriptSource(), true);
      }
      A1938MItemEsMenu = GXutil.strtobool( GXutil.booltostr( A1938MItemEsMenu)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1938MItemEsMenu", A1938MItemEsMenu);
      A1945MItemPadreObl = GXutil.strtobool( GXutil.booltostr( A1945MItemPadreObl)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1945MItemPadreObl", A1945MItemPadreObl);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfLJ2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV17Pgmname = "MenuItemGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rfLJ2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15LJ2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00LJ3 */
         pr_default.execute(1, new Object[] {Byte.valueOf(A1925PerfilId), A1937MenuItemId});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A1954MItemBienImgNom = H00LJ3_A1954MItemBienImgNom[0] ;
            edtMItemBienImgDef_Filename = A1954MItemBienImgNom ;
            A1960MitemIcoImgNom = H00LJ3_A1960MitemIcoImgNom[0] ;
            edtMitemIcoImg_Filename = A1960MitemIcoImgNom ;
            A1953MItemBienImgExt = H00LJ3_A1953MItemBienImgExt[0] ;
            edtMItemBienImgDef_Filetype = A1953MItemBienImgExt ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMItemBienImgDef_Internalname, "Filetype", edtMItemBienImgDef_Filetype, true);
            A1959MItemIcoImgExt = H00LJ3_A1959MItemIcoImgExt[0] ;
            edtMitemIcoImg_Filetype = A1959MItemIcoImgExt ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMitemIcoImg_Internalname, "Filetype", edtMitemIcoImg_Filetype, true);
            A1961MItemHelp = H00LJ3_A1961MItemHelp[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1961MItemHelp", A1961MItemHelp);
            A1952MItemBienImgDef = H00LJ3_A1952MItemBienImgDef[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1952MItemBienImgDef", A1952MItemBienImgDef);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMItemBienImgDef_Internalname, "URL", httpContext.getResourceRelative(A1952MItemBienImgDef), true);
            A1956MItemBienTextDef = H00LJ3_A1956MItemBienTextDef[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1956MItemBienTextDef", A1956MItemBienTextDef);
            A1955MItemBienTitDef = H00LJ3_A1955MItemBienTitDef[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1955MItemBienTitDef", A1955MItemBienTitDef);
            A1945MItemPadreObl = H00LJ3_A1945MItemPadreObl[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1945MItemPadreObl", A1945MItemPadreObl);
            A1944MItemPadreDef = H00LJ3_A1944MItemPadreDef[0] ;
            n1944MItemPadreDef = H00LJ3_n1944MItemPadreDef[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1944MItemPadreDef", A1944MItemPadreDef);
            A1938MItemEsMenu = H00LJ3_A1938MItemEsMenu[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1938MItemEsMenu", A1938MItemEsMenu);
            A1958MitemIcoImg = H00LJ3_A1958MitemIcoImg[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1958MitemIcoImg", A1958MitemIcoImg);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMitemIcoImg_Internalname, "URL", httpContext.getResourceRelative(A1958MitemIcoImg), true);
            A1957MItemIcoSVG = H00LJ3_A1957MItemIcoSVG[0] ;
            n1957MItemIcoSVG = H00LJ3_n1957MItemIcoSVG[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1957MItemIcoSVG", A1957MItemIcoSVG);
            A1939MenuItemTitulo = H00LJ3_A1939MenuItemTitulo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1939MenuItemTitulo", A1939MenuItemTitulo);
            gxamitemicosvg_htmlLJ2( ) ;
            /* Execute user event: Load */
            e14LJ2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         wbLJ0( ) ;
      }
   }

   public void send_integrity_lvl_hashesLJ2( )
   {
   }

   public void before_start_formulas( )
   {
      AV17Pgmname = "MenuItemGeneral" ;
      Gx_err = (short)(0) ;
      gxamitemicosvg_htmlLJ2( ) ;
      fix_multi_value_controls( ) ;
   }

   public void strupLJ0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13LJ2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1925PerfilId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOA1937MenuItemId = httpContext.cgiGet( sPrefix+"wcpOA1937MenuItemId") ;
         /* Read variables values. */
         A1939MenuItemTitulo = httpContext.cgiGet( edtMenuItemTitulo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1939MenuItemTitulo", A1939MenuItemTitulo);
         dynMItemIcoSVG.setValue( httpContext.cgiGet( dynMItemIcoSVG.getInternalname()) );
         A1957MItemIcoSVG = httpContext.cgiGet( dynMItemIcoSVG.getInternalname()) ;
         n1957MItemIcoSVG = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1957MItemIcoSVG", A1957MItemIcoSVG);
         A1958MitemIcoImg = httpContext.cgiGet( edtMitemIcoImg_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1958MitemIcoImg", A1958MitemIcoImg);
         A1938MItemEsMenu = GXutil.strtobool( httpContext.cgiGet( chkMItemEsMenu.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1938MItemEsMenu", A1938MItemEsMenu);
         A1944MItemPadreDef = httpContext.cgiGet( edtMItemPadreDef_Internalname) ;
         n1944MItemPadreDef = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1944MItemPadreDef", A1944MItemPadreDef);
         A1945MItemPadreObl = GXutil.strtobool( httpContext.cgiGet( chkMItemPadreObl.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1945MItemPadreObl", A1945MItemPadreObl);
         A1955MItemBienTitDef = httpContext.cgiGet( edtMItemBienTitDef_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1955MItemBienTitDef", A1955MItemBienTitDef);
         A1956MItemBienTextDef = httpContext.cgiGet( edtMItemBienTextDef_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1956MItemBienTextDef", A1956MItemBienTextDef);
         A1952MItemBienImgDef = httpContext.cgiGet( edtMItemBienImgDef_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1952MItemBienImgDef", A1952MItemBienImgDef);
         A1961MItemHelp = httpContext.cgiGet( edtMItemHelp_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1961MItemHelp", A1961MItemHelp);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         gxamitemicosvg_htmlLJ2( ) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e13LJ2 ();
      if (returnInSub) return;
   }

   public void e13LJ2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      menuitemgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
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

   protected void e14LJ2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuItem_Update", GXv_boolean5) ;
      menuitemgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV12TempBoolean = GXt_boolean4 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean4 = AV12TempBoolean ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMenuItem_Delete", GXv_boolean5) ;
      menuitemgeneral_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "MenuItem" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e15LJ2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV13CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      menuitemgeneral_impl.this.GXt_int1 = GXv_int2[0] ;
      AV13CliCod = GXt_int1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A1925PerfilId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
      A1937MenuItemId = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1937MenuItemId", A1937MenuItemId);
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
      paLJ2( ) ;
      wsLJ2( ) ;
      weLJ2( ) ;
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
      sCtrlA1925PerfilId = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlA1937MenuItemId = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paLJ2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "menuitemgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paLJ2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A1925PerfilId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1925PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1925PerfilId), 2, 0));
         A1937MenuItemId = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1937MenuItemId", A1937MenuItemId);
      }
      wcpOA1925PerfilId = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA1925PerfilId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOA1937MenuItemId = httpContext.cgiGet( sPrefix+"wcpOA1937MenuItemId") ;
      if ( ! GetJustCreated( ) && ( ( A1925PerfilId != wcpOA1925PerfilId ) || ( GXutil.strcmp(A1937MenuItemId, wcpOA1937MenuItemId) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOA1925PerfilId = A1925PerfilId ;
      wcpOA1937MenuItemId = A1937MenuItemId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
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
      sCtrlA1937MenuItemId = httpContext.cgiGet( sPrefix+"A1937MenuItemId_CTRL") ;
      if ( GXutil.len( sCtrlA1937MenuItemId) > 0 )
      {
         A1937MenuItemId = httpContext.cgiGet( sCtrlA1937MenuItemId) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1937MenuItemId", A1937MenuItemId);
      }
      else
      {
         A1937MenuItemId = httpContext.cgiGet( sPrefix+"A1937MenuItemId_PARM") ;
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
      paLJ2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsLJ2( ) ;
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
      wsLJ2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1925PerfilId_PARM", GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA1925PerfilId)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1925PerfilId_CTRL", GXutil.rtrim( sCtrlA1925PerfilId));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1937MenuItemId_PARM", A1937MenuItemId);
      if ( GXutil.len( GXutil.rtrim( sCtrlA1937MenuItemId)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A1937MenuItemId_CTRL", GXutil.rtrim( sCtrlA1937MenuItemId));
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
      weLJ2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202028792", true, true);
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
      httpContext.AddJavascriptSource("menuitemgeneral.js", "?202412202028792", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtPerfilId_Internalname = sPrefix+"PERFILID" ;
      edtMenuItemId_Internalname = sPrefix+"MENUITEMID" ;
      edtMenuItemTitulo_Internalname = sPrefix+"MENUITEMTITULO" ;
      dynMItemIcoSVG.setInternalname( sPrefix+"MITEMICOSVG" );
      edtMitemIcoImg_Internalname = sPrefix+"MITEMICOIMG" ;
      chkMItemEsMenu.setInternalname( sPrefix+"MITEMESMENU" );
      edtMItemPadreDef_Internalname = sPrefix+"MITEMPADREDEF" ;
      chkMItemPadreObl.setInternalname( sPrefix+"MITEMPADREOBL" );
      edtMItemBienTitDef_Internalname = sPrefix+"MITEMBIENTITDEF" ;
      edtMItemBienTextDef_Internalname = sPrefix+"MITEMBIENTEXTDEF" ;
      edtMItemBienImgDef_Internalname = sPrefix+"MITEMBIENIMGDEF" ;
      edtMItemHelp_Internalname = sPrefix+"MITEMHELP" ;
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
      edtMItemHelp_Enabled = 0 ;
      edtMItemBienImgDef_Jsonclick = "" ;
      edtMItemBienImgDef_Parameters = "" ;
      edtMItemBienImgDef_Contenttype = "" ;
      edtMItemBienImgDef_Filetype = "" ;
      edtMItemBienImgDef_Enabled = 0 ;
      edtMItemBienTextDef_Enabled = 0 ;
      edtMItemBienTitDef_Enabled = 0 ;
      chkMItemPadreObl.setEnabled( 0 );
      edtMItemPadreDef_Jsonclick = "" ;
      edtMItemPadreDef_Enabled = 0 ;
      chkMItemEsMenu.setEnabled( 0 );
      edtMitemIcoImg_Jsonclick = "" ;
      edtMitemIcoImg_Parameters = "" ;
      edtMitemIcoImg_Contenttype = "" ;
      edtMitemIcoImg_Filetype = "" ;
      edtMitemIcoImg_Enabled = 0 ;
      dynMItemIcoSVG.setJsonclick( "" );
      dynMItemIcoSVG.setEnabled( 0 );
      edtMenuItemTitulo_Enabled = 0 ;
      edtMenuItemId_Jsonclick = "" ;
      edtMenuItemId_Enabled = 0 ;
      edtPerfilId_Jsonclick = "" ;
      edtPerfilId_Enabled = 0 ;
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
      dynMItemIcoSVG.setName( "MITEMICOSVG" );
      dynMItemIcoSVG.setWebtags( "" );
      chkMItemEsMenu.setName( "MITEMESMENU" );
      chkMItemEsMenu.setWebtags( "" );
      chkMItemEsMenu.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkMItemEsMenu.getInternalname(), "TitleCaption", chkMItemEsMenu.getCaption(), true);
      chkMItemEsMenu.setCheckedValue( "false" );
      chkMItemPadreObl.setName( "MITEMPADREOBL" );
      chkMItemPadreObl.setWebtags( "" );
      chkMItemPadreObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkMItemPadreObl.getInternalname(), "TitleCaption", chkMItemPadreObl.getCaption(), true);
      chkMItemPadreObl.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'},{av:'A1937MenuItemId',fld:'MENUITEMID',pic:''},{av:'dynMItemIcoSVG'},{av:'A1957MItemIcoSVG',fld:'MITEMICOSVG',pic:''},{av:'A1938MItemEsMenu',fld:'MITEMESMENU',pic:''},{av:'A1945MItemPadreObl',fld:'MITEMPADREOBL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11LJ1',iparms:[{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'},{av:'A1937MenuItemId',fld:'MENUITEMID',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12LJ1',iparms:[{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'},{av:'A1937MenuItemId',fld:'MENUITEMID',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_PERFILID","{handler:'valid_Perfilid',iparms:[]");
      setEventMetadata("VALID_PERFILID",",oparms:[]}");
      setEventMetadata("VALID_MENUITEMID","{handler:'valid_Menuitemid',iparms:[]");
      setEventMetadata("VALID_MENUITEMID",",oparms:[]}");
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
      wcpOA1937MenuItemId = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A1937MenuItemId = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1939MenuItemTitulo = "" ;
      A1957MItemIcoSVG = "" ;
      edtMitemIcoImg_Filename = "" ;
      A1960MitemIcoImgNom = "" ;
      A1959MItemIcoImgExt = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      A1958MitemIcoImg = "" ;
      A1944MItemPadreDef = "" ;
      A1955MItemBienTitDef = "" ;
      A1956MItemBienTextDef = "" ;
      edtMItemBienImgDef_Filename = "" ;
      A1954MItemBienImgNom = "" ;
      A1953MItemBienImgExt = "" ;
      A1952MItemBienImgDef = "" ;
      A1961MItemHelp = "" ;
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
      H00LJ2_A1957MItemIcoSVG = new String[] {""} ;
      H00LJ2_n1957MItemIcoSVG = new boolean[] {false} ;
      AV17Pgmname = "" ;
      H00LJ3_A1925PerfilId = new byte[1] ;
      H00LJ3_A1937MenuItemId = new String[] {""} ;
      H00LJ3_A1954MItemBienImgNom = new String[] {""} ;
      H00LJ3_A1960MitemIcoImgNom = new String[] {""} ;
      H00LJ3_A1953MItemBienImgExt = new String[] {""} ;
      H00LJ3_A1959MItemIcoImgExt = new String[] {""} ;
      H00LJ3_A1961MItemHelp = new String[] {""} ;
      H00LJ3_A1952MItemBienImgDef = new String[] {""} ;
      H00LJ3_A1956MItemBienTextDef = new String[] {""} ;
      H00LJ3_A1955MItemBienTitDef = new String[] {""} ;
      H00LJ3_A1945MItemPadreObl = new boolean[] {false} ;
      H00LJ3_A1944MItemPadreDef = new String[] {""} ;
      H00LJ3_n1944MItemPadreDef = new boolean[] {false} ;
      H00LJ3_A1938MItemEsMenu = new boolean[] {false} ;
      H00LJ3_A1958MitemIcoImg = new String[] {""} ;
      H00LJ3_A1957MItemIcoSVG = new String[] {""} ;
      H00LJ3_n1957MItemIcoSVG = new boolean[] {false} ;
      H00LJ3_A1939MenuItemTitulo = new String[] {""} ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      GXv_int2 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA1925PerfilId = "" ;
      sCtrlA1937MenuItemId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.menuitemgeneral__default(),
         new Object[] {
             new Object[] {
            H00LJ2_A1957MItemIcoSVG
            }
            , new Object[] {
            H00LJ3_A1925PerfilId, H00LJ3_A1937MenuItemId, H00LJ3_A1954MItemBienImgNom, H00LJ3_A1960MitemIcoImgNom, H00LJ3_A1953MItemBienImgExt, H00LJ3_A1959MItemIcoImgExt, H00LJ3_A1961MItemHelp, H00LJ3_A1952MItemBienImgDef, H00LJ3_A1956MItemBienTextDef, H00LJ3_A1955MItemBienTitDef,
            H00LJ3_A1945MItemPadreObl, H00LJ3_A1944MItemPadreDef, H00LJ3_n1944MItemPadreDef, H00LJ3_A1938MItemEsMenu, H00LJ3_A1958MitemIcoImg, H00LJ3_A1957MItemIcoSVG, H00LJ3_n1957MItemIcoSVG, H00LJ3_A1939MenuItemTitulo
            }
         }
      );
      AV17Pgmname = "MenuItemGeneral" ;
      /* GeneXus formulas. */
      AV17Pgmname = "MenuItemGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte wcpOA1925PerfilId ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A1925PerfilId ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtPerfilId_Enabled ;
   private int edtMenuItemId_Enabled ;
   private int edtMenuItemTitulo_Enabled ;
   private int edtMitemIcoImg_Enabled ;
   private int edtMItemPadreDef_Enabled ;
   private int edtMItemBienTitDef_Enabled ;
   private int edtMItemBienTextDef_Enabled ;
   private int edtMItemBienImgDef_Enabled ;
   private int edtMItemHelp_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int gxdynajaxindex ;
   private int AV13CliCod ;
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
   private String edtPerfilId_Internalname ;
   private String edtPerfilId_Jsonclick ;
   private String edtMenuItemId_Internalname ;
   private String edtMenuItemId_Jsonclick ;
   private String edtMenuItemTitulo_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String A1957MItemIcoSVG ;
   private String edtMitemIcoImg_Internalname ;
   private String edtMitemIcoImg_Filename ;
   private String edtMitemIcoImg_Filetype ;
   private String A1959MItemIcoImgExt ;
   private String edtMitemIcoImg_Contenttype ;
   private String edtMitemIcoImg_Parameters ;
   private String edtMitemIcoImg_Jsonclick ;
   private String edtMItemPadreDef_Internalname ;
   private String edtMItemPadreDef_Jsonclick ;
   private String edtMItemBienTitDef_Internalname ;
   private String edtMItemBienTextDef_Internalname ;
   private String edtMItemBienImgDef_Internalname ;
   private String edtMItemBienImgDef_Filename ;
   private String edtMItemBienImgDef_Filetype ;
   private String A1953MItemBienImgExt ;
   private String edtMItemBienImgDef_Contenttype ;
   private String edtMItemBienImgDef_Parameters ;
   private String edtMItemBienImgDef_Jsonclick ;
   private String edtMItemHelp_Internalname ;
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
   private String sCtrlA1925PerfilId ;
   private String sCtrlA1937MenuItemId ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A1938MItemEsMenu ;
   private boolean A1945MItemPadreObl ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1957MItemIcoSVG ;
   private boolean n1944MItemPadreDef ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String A1956MItemBienTextDef ;
   private String A1961MItemHelp ;
   private String A1958MitemIcoImg ;
   private String A1952MItemBienImgDef ;
   private String wcpOA1937MenuItemId ;
   private String A1937MenuItemId ;
   private String A1939MenuItemTitulo ;
   private String A1960MitemIcoImgNom ;
   private String A1944MItemPadreDef ;
   private String A1955MItemBienTitDef ;
   private String A1954MItemBienImgNom ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private HTMLChoice dynMItemIcoSVG ;
   private ICheckbox chkMItemEsMenu ;
   private ICheckbox chkMItemPadreObl ;
   private IDataStoreProvider pr_default ;
   private String[] H00LJ2_A1957MItemIcoSVG ;
   private boolean[] H00LJ2_n1957MItemIcoSVG ;
   private byte[] H00LJ3_A1925PerfilId ;
   private String[] H00LJ3_A1937MenuItemId ;
   private String[] H00LJ3_A1954MItemBienImgNom ;
   private String[] H00LJ3_A1960MitemIcoImgNom ;
   private String[] H00LJ3_A1953MItemBienImgExt ;
   private String[] H00LJ3_A1959MItemIcoImgExt ;
   private String[] H00LJ3_A1961MItemHelp ;
   private String[] H00LJ3_A1952MItemBienImgDef ;
   private String[] H00LJ3_A1956MItemBienTextDef ;
   private String[] H00LJ3_A1955MItemBienTitDef ;
   private boolean[] H00LJ3_A1945MItemPadreObl ;
   private String[] H00LJ3_A1944MItemPadreDef ;
   private boolean[] H00LJ3_n1944MItemPadreDef ;
   private boolean[] H00LJ3_A1938MItemEsMenu ;
   private String[] H00LJ3_A1958MitemIcoImg ;
   private String[] H00LJ3_A1957MItemIcoSVG ;
   private boolean[] H00LJ3_n1957MItemIcoSVG ;
   private String[] H00LJ3_A1939MenuItemTitulo ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class menuitemgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00LJ2", "SELECT SVGId AS MItemIcoSVG FROM SVG ORDER BY SVGId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LJ3", "SELECT PerfilId, MenuItemId, MItemBienImgNom, MitemIcoImgNom, MItemBienImgExt, MItemIcoImgExt, MItemHelp, MItemBienImgDef, MItemBienTextDef, MItemBienTitDef, MItemPadreObl, MItemPadreDef, MItemEsMenu, MitemIcoImg, MItemIcoSVG, MenuItemTitulo FROM MenuItem WHERE PerfilId = ? and MenuItemId = ( ?) ORDER BY PerfilId, MenuItemId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getBLOBFile(8, rslt.getString(5, 20), rslt.getVarchar(3));
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((boolean[]) buf[13])[0] = rslt.getBoolean(13);
               ((String[]) buf[14])[0] = rslt.getBLOBFile(14, rslt.getString(6, 20), rslt.getVarchar(4));
               ((String[]) buf[15])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getVarchar(16);
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
      }
   }

}

