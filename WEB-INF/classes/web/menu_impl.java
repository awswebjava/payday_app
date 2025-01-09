package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class menu_impl extends GXDataArea
{
   public menu_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public menu_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menu_impl.class ));
   }

   public menu_impl( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      try
      {
         AV35MenuOpcCod = (String) args[0];
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      nGotPars = 1 ;
      webExecute();
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "MenuOpcCod") ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "MenuOpcCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "MenuOpcCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridopciones") == 0 )
         {
            gxnrgridopciones_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridopciones") == 0 )
         {
            gxgrgridopciones_refresh_invoke( ) ;
            return  ;
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV35MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35MenuOpcCod", AV35MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV35MenuOpcCod, ""))));
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridopciones_newrow_invoke( )
   {
      nRC_GXsfl_15 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_15"))) ;
      nGXsfl_15_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_15_idx"))) ;
      sGXsfl_15_idx = httpContext.GetPar( "sGXsfl_15_idx") ;
      edtavMenuitemsdescription_Class = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMenuitemsdescription_Internalname, "Class", edtavMenuitemsdescription_Class, !bGXsfl_15_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridopciones_newrow( ) ;
      /* End function gxnrGridopciones_newrow_invoke */
   }

   public void gxgrgridopciones_refresh_invoke( )
   {
      edtavMenuitemsdescription_Class = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMenuitemsdescription_Internalname, "Class", edtavMenuitemsdescription_Class, !bGXsfl_15_Refreshing);
      A1923RolId = (byte)(GXutil.lval( httpContext.GetPar( "RolId"))) ;
      A1925PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
      A1928MenuVerId = GXutil.lval( httpContext.GetPar( "MenuVerId")) ;
      A1933MenuOpcPadre = httpContext.GetPar( "MenuOpcPadre") ;
      n1933MenuOpcPadre = false ;
      A1940MenuItemOrd = (byte)(GXutil.lval( httpContext.GetPar( "MenuItemOrd"))) ;
      AV31RolId = (byte)(GXutil.lval( httpContext.GetPar( "RolId"))) ;
      AV32PerfilId = (byte)(GXutil.lval( httpContext.GetPar( "PerfilId"))) ;
      AV30MenuVerId = GXutil.lval( httpContext.GetPar( "MenuVerId")) ;
      AV35MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      A1935SVGId = httpContext.GetPar( "SVGId") ;
      n1935SVGId = false ;
      A1941MenuItemImg = httpContext.GetPar( "MenuItemImg") ;
      A1943MenuItemImgNom = httpContext.GetPar( "MenuItemImgNom") ;
      A1942MenuItemImgExt = httpContext.GetPar( "MenuItemImgExt") ;
      A1936SVGValor = httpContext.GetPar( "SVGValor") ;
      AV5CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV6EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      A1937MenuItemId = httpContext.GetPar( "MenuItemId") ;
      A1929MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      A1931MenuOpcTitulo = httpContext.GetPar( "MenuOpcTitulo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV46urls);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridopciones_refresh( A1923RolId, A1925PerfilId, A1928MenuVerId, A1933MenuOpcPadre, A1940MenuItemOrd, AV31RolId, AV32PerfilId, AV30MenuVerId, AV35MenuOpcCod, A1935SVGId, A1941MenuItemImg, A1943MenuItemImgNom, A1942MenuItemImgExt, A1936SVGValor, AV5CliCod, AV6EmpCod, A1937MenuItemId, A1929MenuOpcCod, A1931MenuOpcTitulo, AV46urls) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridopciones_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
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
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public byte executeStartEvent( )
   {
      paL12( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startL12( ) ;
      }
      return gxajaxcallmode ;
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
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
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
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
      httpContext.AddJavascriptSource("UserControls/A3LLinkTablaRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.menu", new String[] {GXutil.URLEncode(GXutil.rtrim(AV35MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV31RolId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV32PerfilId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUVERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30MenuVerId), "ZZZZZZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV35MenuOpcCod, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_15", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_15, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ROLID", GXutil.ltrim( localUtil.ntoc( A1923RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PERFILID", GXutil.ltrim( localUtil.ntoc( A1925PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUVERID", GXutil.ltrim( localUtil.ntoc( A1928MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCPADRE", GXutil.rtrim( A1933MenuOpcPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMORD", GXutil.ltrim( localUtil.ntoc( A1940MenuItemOrd, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vROLID", GXutil.ltrim( localUtil.ntoc( AV31RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV31RolId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPERFILID", GXutil.ltrim( localUtil.ntoc( AV32PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV32PerfilId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUVERID", GXutil.ltrim( localUtil.ntoc( AV30MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUVERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30MenuVerId), "ZZZZZZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV35MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV35MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "SVGID", GXutil.rtrim( A1935SVGId));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMIMG", A1941MenuItemImg);
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMIMGNOM", A1943MenuItemImgNom);
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMIMGEXT", GXutil.rtrim( A1942MenuItemImgExt));
      web.GxWebStd.gx_hidden_field( httpContext, "SVGVALOR", A1936SVGValor);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV5CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV6EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "MENUITEMID", A1937MenuItemId);
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCCOD", A1929MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "MENUOPCTITULO", A1931MenuOpcTitulo);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vURLS", AV46urls);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vURLS", AV46urls);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "A3LLINKTABLAMENU_Linkrowid", GXutil.rtrim( A3llinktablamenu_Linkrowid));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LLINKTABLAMENU_Urls", GXutil.rtrim( A3llinktablamenu_Urls));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDOPCIONES_Class", GXutil.rtrim( subGridopciones_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDOPCIONES_Flexwrap", GXutil.rtrim( subGridopciones_Flexwrap));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUITEMSDESCRIPTION_Class", GXutil.rtrim( edtavMenuitemsdescription_Class));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         weL12( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtL12( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.menu", new String[] {GXutil.URLEncode(GXutil.rtrim(AV35MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "Menu" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Menu", "") ;
   }

   public void wbL10( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
         wb_table1_9_L12( true) ;
      }
      else
      {
         wb_table1_9_L12( false) ;
      }
      return  ;
   }

   public void wb_table1_9_L12e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucA3llinktablamenu.render(context, "a3llinktabla", A3llinktablamenu_Internalname, "A3LLINKTABLAMENUContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 15 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridopcionesContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridopcionesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridopciones", GridopcionesContainer, subGridopciones_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridopcionesContainerData", GridopcionesContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridopcionesContainerData"+"V", GridopcionesContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridopcionesContainerData"+"V"+"\" value='"+GridopcionesContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startL12( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Menu", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupL10( ) ;
   }

   public void wsL12( )
   {
      startL12( ) ;
      evtL12( ) ;
   }

   public void evtL12( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 17), "GRIDOPCIONES.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 20), "GRIDOPCIONES.REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_15_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_152( ) ;
                           AV7ImageMenuItemIcon = httpContext.cgiGet( edtavImagemenuitemicon_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavImagemenuitemicon_Internalname, "Bitmap", ((GXutil.strcmp("", AV7ImageMenuItemIcon)==0) ? AV52Imagemenuitemicon_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV7ImageMenuItemIcon))), !bGXsfl_15_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavImagemenuitemicon_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV7ImageMenuItemIcon), true);
                           AV9MenuItemsDescription = httpContext.cgiGet( edtavMenuitemsdescription_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavMenuitemsdescription_Internalname, AV9MenuItemsDescription);
                           AV26TituloOpciones = httpContext.cgiGet( edtavTituloopciones_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavTituloopciones_Internalname, AV26TituloOpciones);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e11L12 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e12L12 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e13L12 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDOPCIONES.REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e14L12 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void weL12( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void paL12( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
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

   public void gxnrgridopciones_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_152( ) ;
      while ( nGXsfl_15_idx <= nRC_GXsfl_15 )
      {
         sendrow_152( ) ;
         nGXsfl_15_idx = ((subGridopciones_Islastpage==1)&&(nGXsfl_15_idx+1>subgridopciones_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridopcionesContainer)) ;
      /* End function gxnrGridopciones_newrow */
   }

   public void gxgrgridopciones_refresh( byte A1923RolId ,
                                         byte A1925PerfilId ,
                                         long A1928MenuVerId ,
                                         String A1933MenuOpcPadre ,
                                         byte A1940MenuItemOrd ,
                                         byte AV31RolId ,
                                         byte AV32PerfilId ,
                                         long AV30MenuVerId ,
                                         String AV35MenuOpcCod ,
                                         String A1935SVGId ,
                                         String A1941MenuItemImg ,
                                         String A1943MenuItemImgNom ,
                                         String A1942MenuItemImgExt ,
                                         String A1936SVGValor ,
                                         int AV5CliCod ,
                                         short AV6EmpCod ,
                                         String A1937MenuItemId ,
                                         String A1929MenuOpcCod ,
                                         String A1931MenuOpcTitulo ,
                                         GXSimpleCollection<String> AV46urls )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e13L12 ();
      GRIDOPCIONES_nCurrentRecord = 0 ;
      rfL12( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridopciones_refresh */
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      /* Execute user event: Refresh */
      e13L12 ();
      rfL12( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV50Pgmname = "Menu" ;
      Gx_err = (short)(0) ;
      edtavMenuitemsdescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMenuitemsdescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMenuitemsdescription_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavTituloopciones_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTituloopciones_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTituloopciones_Enabled), 5, 0), !bGXsfl_15_Refreshing);
   }

   public void rfL12( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridopcionesContainer.ClearRows();
      }
      wbStart = (short)(15) ;
      e14L12 ();
      nGXsfl_15_idx = 1 ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
      bGXsfl_15_Refreshing = true ;
      GridopcionesContainer.AddObjectProperty("GridName", "Gridopciones");
      GridopcionesContainer.AddObjectProperty("CmpContext", "");
      GridopcionesContainer.AddObjectProperty("InMasterPage", "false");
      GridopcionesContainer.AddObjectProperty("Class", GXutil.rtrim( "gridOpciones"));
      GridopcionesContainer.AddObjectProperty("Class", "gridOpciones");
      GridopcionesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridopcionesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridopcionesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridopciones_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridopcionesContainer.setPageSize( subgridopciones_fnc_recordsperpage( ) );
      if ( subGridopciones_Islastpage != 0 )
      {
         GRIDOPCIONES_nFirstRecordOnPage = (long)(subgridopciones_fnc_recordcount( )-subgridopciones_fnc_recordsperpage( )) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRIDOPCIONES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDOPCIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         GridopcionesContainer.AddObjectProperty("GRIDOPCIONES_nFirstRecordOnPage", GRIDOPCIONES_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_152( ) ;
         e12L12 ();
         wbEnd = (short)(15) ;
         wbL10( ) ;
      }
      bGXsfl_15_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesL12( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vROLID", GXutil.ltrim( localUtil.ntoc( AV31RolId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV31RolId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPERFILID", GXutil.ltrim( localUtil.ntoc( AV32PerfilId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV32PerfilId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUVERID", GXutil.ltrim( localUtil.ntoc( AV30MenuVerId, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUVERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30MenuVerId), "ZZZZZZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV5CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV6EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6EmpCod), "ZZZ9")));
   }

   public int subgridopciones_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridopciones_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridopciones_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridopciones_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      AV50Pgmname = "Menu" ;
      Gx_err = (short)(0) ;
      edtavMenuitemsdescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMenuitemsdescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMenuitemsdescription_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavTituloopciones_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTituloopciones_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTituloopciones_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupL10( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11L12 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_15 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_15"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A3llinktablamenu_Linkrowid = httpContext.cgiGet( "A3LLINKTABLAMENU_Linkrowid") ;
         A3llinktablamenu_Urls = httpContext.cgiGet( "A3LLINKTABLAMENU_Urls") ;
         subGridopciones_Class = httpContext.cgiGet( "GRIDOPCIONES_Class") ;
         subGridopciones_Flexwrap = httpContext.cgiGet( "GRIDOPCIONES_Flexwrap") ;
         /* Read variables values. */
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
      e11L12 ();
      if (returnInSub) return;
   }

   public void e11L12( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV20websession.setValue(httpContext.getMessage( "&sel_Menu_Modo", ""), "");
      AV20websession.setValue(httpContext.getMessage( "&sel_HeadTitle", ""), "");
      AV20websession.setValue(httpContext.getMessage( "&selMenuOpcCod", ""), AV35MenuOpcCod);
      new web.msgdebug_prod(remoteHandle, context).execute( AV50Pgmname, httpContext.getMessage( "setea  ", "")+GXutil.trim( AV35MenuOpcCod)) ;
      GXt_int1 = AV5CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      menu_impl.this.GXt_int1 = GXv_int2[0] ;
      AV5CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      GXt_int3 = AV6EmpCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int4) ;
      menu_impl.this.GXt_int3 = GXv_int4[0] ;
      AV6EmpCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6EmpCod), "ZZZ9")));
      divTabletituloopciones_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTabletituloopciones_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTabletituloopciones_Visible), 5, 0), !bGXsfl_15_Refreshing);
      edtavMenuitemsdescription_Class = httpContext.getMessage( "AttributeMenuItem", "") ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMenuitemsdescription_Internalname, "Class", edtavMenuitemsdescription_Class, !bGXsfl_15_Refreshing);
      AV28filas = (short)(6) ;
      GXt_int3 = AV34SecUserId ;
      GXv_int4[0] = GXt_int3 ;
      new web.getusuloggedid(remoteHandle, context).execute( GXv_int4) ;
      menu_impl.this.GXt_int3 = GXv_int4[0] ;
      AV34SecUserId = GXt_int3 ;
      GXv_int5[0] = AV31RolId ;
      GXv_int6[0] = AV32PerfilId ;
      GXv_int7[0] = AV30MenuVerId ;
      new web.getusumenu(remoteHandle, context).execute( AV34SecUserId, GXv_int5, GXv_int6, GXv_int7) ;
      menu_impl.this.AV31RolId = GXv_int5[0] ;
      menu_impl.this.AV32PerfilId = GXv_int6[0] ;
      menu_impl.this.AV30MenuVerId = GXv_int7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31RolId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31RolId), 2, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV31RolId), "Z9")));
      httpContext.ajax_rsp_assign_attri("", false, "AV32PerfilId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32PerfilId), 2, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERFILID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV32PerfilId), "Z9")));
      httpContext.ajax_rsp_assign_attri("", false, "AV30MenuVerId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30MenuVerId), 15, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUVERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30MenuVerId), "ZZZZZZZZZZZZZZ9")));
   }

   private void e12L12( )
   {
      /* Gridopciones_Load Routine */
      returnInSub = false ;
      /* Using cursor H00L12 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV31RolId), Byte.valueOf(AV32PerfilId), Long.valueOf(AV30MenuVerId), AV35MenuOpcCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1923RolId = H00L12_A1923RolId[0] ;
         A1925PerfilId = H00L12_A1925PerfilId[0] ;
         A1928MenuVerId = H00L12_A1928MenuVerId[0] ;
         A1933MenuOpcPadre = H00L12_A1933MenuOpcPadre[0] ;
         n1933MenuOpcPadre = H00L12_n1933MenuOpcPadre[0] ;
         A1943MenuItemImgNom = H00L12_A1943MenuItemImgNom[0] ;
         A1941MenuItemImg_Filename = A1943MenuItemImgNom ;
         A1942MenuItemImgExt = H00L12_A1942MenuItemImgExt[0] ;
         A1941MenuItemImg_Filetype = A1942MenuItemImgExt ;
         A1935SVGId = H00L12_A1935SVGId[0] ;
         n1935SVGId = H00L12_n1935SVGId[0] ;
         A1941MenuItemImg = H00L12_A1941MenuItemImg[0] ;
         A1936SVGValor = H00L12_A1936SVGValor[0] ;
         A1937MenuItemId = H00L12_A1937MenuItemId[0] ;
         A1929MenuOpcCod = H00L12_A1929MenuOpcCod[0] ;
         A1931MenuOpcTitulo = H00L12_A1931MenuOpcTitulo[0] ;
         A1940MenuItemOrd = H00L12_A1940MenuItemOrd[0] ;
         A1936SVGValor = H00L12_A1936SVGValor[0] ;
         if ( H00L12_n1935SVGId[0] )
         {
            edtavImagemenuitemicon_Visible = 1 ;
            lblSvg_Visible = 0 ;
            AV7ImageMenuItemIcon = A1941MenuItemImg ;
            httpContext.ajax_rsp_assign_attri("", false, edtavImagemenuitemicon_Internalname, AV7ImageMenuItemIcon);
            AV52Imagemenuitemicon_GXI = com.genexus.GXDbFile.getUriFromFile( A1943MenuItemImgNom, A1942MenuItemImgExt, A1941MenuItemImg) ;
         }
         else
         {
            edtavImagemenuitemicon_Visible = 0 ;
            lblSvg_Visible = 1 ;
            lblSvg_Caption = GXutil.trim( A1936SVGValor) ;
         }
         GXt_char8 = AV33URL ;
         GXv_char9[0] = GXt_char8 ;
         new web.getlinkmenu(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV32PerfilId, A1937MenuItemId, A1929MenuOpcCod, GXv_char9) ;
         menu_impl.this.GXt_char8 = GXv_char9[0] ;
         AV33URL = GXt_char8 ;
         AV9MenuItemsDescription = GXutil.trim( A1931MenuOpcTitulo) ;
         httpContext.ajax_rsp_assign_attri("", false, edtavMenuitemsdescription_Internalname, AV9MenuItemsDescription);
         AV46urls.add(AV33URL, 0);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(15) ;
         }
         sendrow_152( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_15_Refreshing )
         {
            httpContext.doAjaxLoad(15, GridopcionesRow);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      A3llinktablamenu_Linkrowid = httpContext.getMessage( "GridopcionesContainerRow", "") ;
      ucA3llinktablamenu.sendProperty(context, "", false, A3llinktablamenu_Internalname, "linkRowId", A3llinktablamenu_Linkrowid);
      A3llinktablamenu_Urls = AV46urls.toJSonString(false) ;
      ucA3llinktablamenu.sendProperty(context, "", false, A3llinktablamenu_Internalname, "urls", A3llinktablamenu_Urls);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV46urls", AV46urls);
   }

   public void e13L12( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV5CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      menu_impl.this.GXt_int1 = GXv_int2[0] ;
      AV5CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      /*  Sending Event outputs  */
   }

   public void e14L12( )
   {
      /* Gridopciones_Refresh Routine */
      returnInSub = false ;
      AV46urls.clear();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV46urls", AV46urls);
   }

   public void wb_table1_9_L12( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gridOpcionesCell", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridopcionesContainer.SetIsFreestyle(true);
         GridopcionesContainer.SetWrapped(nGXWrapped);
         startgridcontrol15( ) ;
      }
      if ( wbEnd == 15 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_15 = (int)(nGXsfl_15_idx-1) ;
         if ( GridopcionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridopcionesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridopciones", GridopcionesContainer, subGridopciones_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridopcionesContainerData", GridopcionesContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridopcionesContainerData"+"V", GridopcionesContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridopcionesContainerData"+"V"+"\" value='"+GridopcionesContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_L12e( true) ;
      }
      else
      {
         wb_table1_9_L12e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV35MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35MenuOpcCod", AV35MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV35MenuOpcCod, ""))));
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
      paL12( ) ;
      wsL12( ) ;
      weL12( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025187482586", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("menu.js", "?2025187482586", false, true);
         httpContext.AddJavascriptSource("UserControls/A3LLinkTablaRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_152( )
   {
      edtavImagemenuitemicon_Internalname = "vIMAGEMENUITEMICON_"+sGXsfl_15_idx ;
      lblSvg_Internalname = "SVG_"+sGXsfl_15_idx ;
      edtavMenuitemsdescription_Internalname = "vMENUITEMSDESCRIPTION_"+sGXsfl_15_idx ;
      edtavTituloopciones_Internalname = "vTITULOOPCIONES_"+sGXsfl_15_idx ;
   }

   public void subsflControlProps_fel_152( )
   {
      edtavImagemenuitemicon_Internalname = "vIMAGEMENUITEMICON_"+sGXsfl_15_fel_idx ;
      lblSvg_Internalname = "SVG_"+sGXsfl_15_fel_idx ;
      edtavMenuitemsdescription_Internalname = "vMENUITEMSDESCRIPTION_"+sGXsfl_15_fel_idx ;
      edtavTituloopciones_Internalname = "vTITULOOPCIONES_"+sGXsfl_15_fel_idx ;
   }

   public void sendrow_152( )
   {
      subsflControlProps_152( ) ;
      wbL10( ) ;
      GridopcionesRow = GXWebRow.GetNew(context,GridopcionesContainer) ;
      if ( subGridopciones_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridopciones_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridopciones_Class, "") != 0 )
         {
            subGridopciones_Linesclass = subGridopciones_Class+"Odd" ;
         }
      }
      else if ( subGridopciones_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridopciones_Backstyle = (byte)(0) ;
         subGridopciones_Backcolor = subGridopciones_Allbackcolor ;
         if ( GXutil.strcmp(subGridopciones_Class, "") != 0 )
         {
            subGridopciones_Linesclass = subGridopciones_Class+"Uniform" ;
         }
      }
      else if ( subGridopciones_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridopciones_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridopciones_Class, "") != 0 )
         {
            subGridopciones_Linesclass = subGridopciones_Class+"Odd" ;
         }
         subGridopciones_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridopciones_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridopciones_Backstyle = (byte)(1) ;
         subGridopciones_Backcolor = (int)(0xFFFFFF) ;
         if ( GXutil.strcmp(subGridopciones_Class, "") != 0 )
         {
            subGridopciones_Linesclass = subGridopciones_Class+"Odd" ;
         }
      }
      /* Start of Columns property logic. */
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableitem_Internalname+"_"+sGXsfl_15_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","flex-wrap:wrap;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","align-self:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTablecenter_Internalname+"_"+sGXsfl_15_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableMenuItemCard","left","top"," "+"data-gx-flex"+" ","flex-direction:column;justify-content:center;align-items:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","align-self:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableiconoitem_Internalname+"_"+sGXsfl_15_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","flex-direction:column;flex-wrap:wrap;justify-content:center;align-items:center;align-content:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Attribute/Variable Label */
      GridopcionesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "Image Menu Item Icon", ""),"gx-form-item menuIconLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Static Bitmap Variable */
      ClassString = "menuIcon" + " " + ((GXutil.strcmp(edtavImagemenuitemicon_gximage, "")==0) ? "" : "GX_Image_"+edtavImagemenuitemicon_gximage+"_Class") ;
      StyleString = "" ;
      AV7ImageMenuItemIcon_IsBlob = (boolean)(((GXutil.strcmp("", AV7ImageMenuItemIcon)==0)&&(GXutil.strcmp("", AV52Imagemenuitemicon_GXI)==0))||!(GXutil.strcmp("", AV7ImageMenuItemIcon)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV7ImageMenuItemIcon)==0) ? AV52Imagemenuitemicon_GXI : httpContext.getResourceRelative(AV7ImageMenuItemIcon)) ;
      GridopcionesRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavImagemenuitemicon_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtavImagemenuitemicon_Visible),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV7ImageMenuItemIcon_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Text block */
      GridopcionesRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblSvg_Internalname,lblSvg_Caption,"","",lblSvg_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(lblSvg_Visible),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(1)});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTabletituloitem_Internalname+"_"+sGXsfl_15_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table MT5 TextAlignCenter","left","top"," "+"data-gx-flex"+" ","flex-direction:column;flex-wrap:wrap;justify-content:center;align-items:center;align-content:center;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Attribute/Variable Label */
      GridopcionesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavMenuitemsdescription_Internalname,httpContext.getMessage( "Menu Items Description", ""),"gx-form-item textGray08Label",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Single line edit */
      ROClassString = edtavMenuitemsdescription_Class ;
      GridopcionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavMenuitemsdescription_Internalname,GXutil.rtrim( AV9MenuItemsDescription),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavMenuitemsdescription_Jsonclick,Integer.valueOf(0),edtavMenuitemsdescription_Class,"",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavMenuitemsdescription_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTabletituloopciones_Internalname+"_"+sGXsfl_15_idx,Integer.valueOf(divTabletituloopciones_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Section","left","top","","","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Div Control */
      GridopcionesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Attribute/Variable Label */
      GridopcionesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavTituloopciones_Internalname,httpContext.getMessage( "Titulo Opciones", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      /* Single line edit */
      ROClassString = "Attribute" ;
      GridopcionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavTituloopciones_Internalname,GXutil.rtrim( AV26TituloOpciones),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavTituloopciones_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavTituloopciones_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      GridopcionesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridopcionesRow.AddRenderProperties(GridopcionesColumn);
      send_integrity_lvl_hashesL12( ) ;
      /* End of Columns property logic. */
      GridopcionesContainer.AddRow(GridopcionesRow);
      nGXsfl_15_idx = ((subGridopciones_Islastpage==1)&&(nGXsfl_15_idx+1>subgridopciones_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
      /* End function sendrow_152 */
   }

   public void startgridcontrol15( )
   {
      if ( GridopcionesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridopcionesContainer"+"DivS\" data-gxgridid=\"15\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridopciones_Internalname, subGridopciones_Internalname, "", "gridOpciones", 0, "", "", 1, 2, sStyleString, "", "", 0);
         GridopcionesContainer.AddObjectProperty("GridName", "Gridopciones");
      }
      else
      {
         GridopcionesContainer.AddObjectProperty("GridName", "Gridopciones");
         GridopcionesContainer.AddObjectProperty("Header", subGridopciones_Header);
         GridopcionesContainer.AddObjectProperty("Class", GXutil.rtrim( "gridOpciones"));
         GridopcionesContainer.AddObjectProperty("Class", "gridOpciones");
         GridopcionesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridopcionesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridopcionesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridopciones_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridopcionesContainer.AddObjectProperty("CmpContext", "");
         GridopcionesContainer.AddObjectProperty("InMasterPage", "false");
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesColumn.AddObjectProperty("Value", httpContext.convertURL( AV7ImageMenuItemIcon));
         GridopcionesColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavImagemenuitemicon_Visible, (byte)(5), (byte)(0), ".", "")));
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesColumn.AddObjectProperty("Value", lblSvg_Caption);
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesColumn.AddObjectProperty("Value", GXutil.rtrim( AV9MenuItemsDescription));
         GridopcionesColumn.AddObjectProperty("Class", GXutil.rtrim( edtavMenuitemsdescription_Class));
         GridopcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavMenuitemsdescription_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridopcionesColumn.AddObjectProperty("Value", GXutil.rtrim( AV26TituloOpciones));
         GridopcionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavTituloopciones_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridopcionesContainer.AddColumnProperties(GridopcionesColumn);
         GridopcionesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridopciones_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridopcionesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridopciones_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridopcionesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridopciones_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridopcionesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridopciones_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridopcionesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridopciones_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridopcionesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridopciones_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridopcionesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridopciones_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      edtavImagemenuitemicon_Internalname = "vIMAGEMENUITEMICON" ;
      lblSvg_Internalname = "SVG" ;
      divTableiconoitem_Internalname = "TABLEICONOITEM" ;
      edtavMenuitemsdescription_Internalname = "vMENUITEMSDESCRIPTION" ;
      divTabletituloitem_Internalname = "TABLETITULOITEM" ;
      divTablecenter_Internalname = "TABLECENTER" ;
      edtavTituloopciones_Internalname = "vTITULOOPCIONES" ;
      divTabletituloopciones_Internalname = "TABLETITULOOPCIONES" ;
      divTableitem_Internalname = "TABLEITEM" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      A3llinktablamenu_Internalname = "A3LLINKTABLAMENU" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridopciones_Internalname = "GRIDOPCIONES" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subGridopciones_Allowcollapsing = (byte)(0) ;
      lblSvg_Caption = httpContext.getMessage( "svg", "") ;
      edtavTituloopciones_Jsonclick = "" ;
      edtavTituloopciones_Enabled = 0 ;
      divTabletituloopciones_Visible = 1 ;
      edtavMenuitemsdescription_Jsonclick = "" ;
      edtavMenuitemsdescription_Enabled = 0 ;
      lblSvg_Caption = httpContext.getMessage( "svg", "") ;
      lblSvg_Visible = 1 ;
      edtavImagemenuitemicon_gximage = "" ;
      edtavImagemenuitemicon_Visible = 1 ;
      subGridopciones_Backcolorstyle = (byte)(0) ;
      subGridopciones_Flexwrap = "wrap" ;
      subGridopciones_Class = "gridOpciones" ;
      A3llinktablamenu_Urls = "" ;
      A3llinktablamenu_Linkrowid = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Menu", "") );
      edtavMenuitemsdescription_Class = "textGray08" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDOPCIONES_nFirstRecordOnPage'},{av:'GRIDOPCIONES_nEOF'},{av:'edtavMenuitemsdescription_Class',ctrl:'vMENUITEMSDESCRIPTION',prop:'Class'},{av:'A1923RolId',fld:'ROLID',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE',pic:''},{av:'A1940MenuItemOrd',fld:'MENUITEMORD',pic:'Z9'},{av:'A1935SVGId',fld:'SVGID',pic:''},{av:'A1941MenuItemImg',fld:'MENUITEMIMG',pic:''},{av:'A1943MenuItemImgNom',fld:'MENUITEMIMGNOM',pic:''},{av:'A1942MenuItemImgExt',fld:'MENUITEMIMGEXT',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR',pic:''},{av:'A1937MenuItemId',fld:'MENUITEMID',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD',pic:''},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO',pic:''},{av:'AV46urls',fld:'vURLS',pic:''},{av:'AV31RolId',fld:'vROLID',pic:'Z9',hsh:true},{av:'AV32PerfilId',fld:'vPERFILID',pic:'Z9',hsh:true},{av:'AV30MenuVerId',fld:'vMENUVERID',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'AV35MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV6EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("GRIDOPCIONES.LOAD","{handler:'e12L12',iparms:[{av:'A1923RolId',fld:'ROLID',pic:'Z9'},{av:'A1925PerfilId',fld:'PERFILID',pic:'Z9'},{av:'A1928MenuVerId',fld:'MENUVERID',pic:'ZZZZZZZZZZZZZZ9'},{av:'A1933MenuOpcPadre',fld:'MENUOPCPADRE',pic:''},{av:'A1940MenuItemOrd',fld:'MENUITEMORD',pic:'Z9'},{av:'AV31RolId',fld:'vROLID',pic:'Z9',hsh:true},{av:'AV32PerfilId',fld:'vPERFILID',pic:'Z9',hsh:true},{av:'AV30MenuVerId',fld:'vMENUVERID',pic:'ZZZZZZZZZZZZZZ9',hsh:true},{av:'AV35MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'A1935SVGId',fld:'SVGID',pic:''},{av:'A1941MenuItemImg',fld:'MENUITEMIMG',pic:''},{av:'A1943MenuItemImgNom',fld:'MENUITEMIMGNOM',pic:''},{av:'A1942MenuItemImgExt',fld:'MENUITEMIMGEXT',pic:''},{av:'A1936SVGValor',fld:'SVGVALOR',pic:''},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV6EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A1937MenuItemId',fld:'MENUITEMID',pic:''},{av:'A1929MenuOpcCod',fld:'MENUOPCCOD',pic:''},{av:'A1931MenuOpcTitulo',fld:'MENUOPCTITULO',pic:''},{av:'AV46urls',fld:'vURLS',pic:''}]");
      setEventMetadata("GRIDOPCIONES.LOAD",",oparms:[{av:'AV7ImageMenuItemIcon',fld:'vIMAGEMENUITEMICON',pic:''},{av:'lblSvg_Caption',ctrl:'SVG',prop:'Caption'},{av:'edtavImagemenuitemicon_Visible',ctrl:'vIMAGEMENUITEMICON',prop:'Visible'},{av:'lblSvg_Visible',ctrl:'SVG',prop:'Visible'},{av:'AV9MenuItemsDescription',fld:'vMENUITEMSDESCRIPTION',pic:''},{av:'AV46urls',fld:'vURLS',pic:''},{av:'A3llinktablamenu_Linkrowid',ctrl:'A3LLINKTABLAMENU',prop:'linkRowId'},{av:'A3llinktablamenu_Urls',ctrl:'A3LLINKTABLAMENU',prop:'urls'}]}");
      setEventMetadata("GRIDOPCIONES.REFRESH","{handler:'e14L12',iparms:[]");
      setEventMetadata("GRIDOPCIONES.REFRESH",",oparms:[{av:'AV46urls',fld:'vURLS',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Tituloopciones',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
      wcpOAV35MenuOpcCod = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV35MenuOpcCod = "" ;
      A1933MenuOpcPadre = "" ;
      A1935SVGId = "" ;
      A1941MenuItemImg = "" ;
      A1943MenuItemImgNom = "" ;
      A1942MenuItemImgExt = "" ;
      A1936SVGValor = "" ;
      A1937MenuItemId = "" ;
      A1929MenuOpcCod = "" ;
      A1931MenuOpcTitulo = "" ;
      AV46urls = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ucA3llinktablamenu = new com.genexus.webpanels.GXUserControl();
      GridopcionesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV7ImageMenuItemIcon = "" ;
      AV52Imagemenuitemicon_GXI = "" ;
      AV9MenuItemsDescription = "" ;
      AV26TituloOpciones = "" ;
      AV50Pgmname = "" ;
      AV20websession = httpContext.getWebSession();
      GXv_int4 = new short[1] ;
      GXv_int5 = new byte[1] ;
      GXv_int6 = new byte[1] ;
      GXv_int7 = new long[1] ;
      scmdbuf = "" ;
      H00L12_A1923RolId = new byte[1] ;
      H00L12_A1925PerfilId = new byte[1] ;
      H00L12_A1928MenuVerId = new long[1] ;
      H00L12_A1933MenuOpcPadre = new String[] {""} ;
      H00L12_n1933MenuOpcPadre = new boolean[] {false} ;
      H00L12_A1943MenuItemImgNom = new String[] {""} ;
      H00L12_A1942MenuItemImgExt = new String[] {""} ;
      H00L12_A1935SVGId = new String[] {""} ;
      H00L12_n1935SVGId = new boolean[] {false} ;
      H00L12_A1941MenuItemImg = new String[] {""} ;
      H00L12_A1936SVGValor = new String[] {""} ;
      H00L12_A1937MenuItemId = new String[] {""} ;
      H00L12_A1929MenuOpcCod = new String[] {""} ;
      H00L12_A1931MenuOpcTitulo = new String[] {""} ;
      H00L12_A1940MenuItemOrd = new byte[1] ;
      A1941MenuItemImg_Filename = "" ;
      A1941MenuItemImg_Filetype = "" ;
      AV33URL = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      GridopcionesRow = new com.genexus.webpanels.GXWebRow();
      GXv_int2 = new int[1] ;
      ClassString = "" ;
      StyleString = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridopciones_Linesclass = "" ;
      GridopcionesColumn = new com.genexus.webpanels.GXWebColumn();
      sImgUrl = "" ;
      lblSvg_Jsonclick = "" ;
      ROClassString = "" ;
      subGridopciones_Header = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.menu__default(),
         new Object[] {
             new Object[] {
            H00L12_A1923RolId, H00L12_A1925PerfilId, H00L12_A1928MenuVerId, H00L12_A1933MenuOpcPadre, H00L12_n1933MenuOpcPadre, H00L12_A1943MenuItemImgNom, H00L12_A1942MenuItemImgExt, H00L12_A1935SVGId, H00L12_n1935SVGId, H00L12_A1941MenuItemImg,
            H00L12_A1936SVGValor, H00L12_A1937MenuItemId, H00L12_A1929MenuOpcCod, H00L12_A1931MenuOpcTitulo, H00L12_A1940MenuItemOrd
            }
         }
      );
      AV50Pgmname = "Menu" ;
      /* GeneXus formulas. */
      AV50Pgmname = "Menu" ;
      Gx_err = (short)(0) ;
      edtavMenuitemsdescription_Enabled = 0 ;
      edtavTituloopciones_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte A1923RolId ;
   private byte A1925PerfilId ;
   private byte A1940MenuItemOrd ;
   private byte AV31RolId ;
   private byte AV32PerfilId ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte subGridopciones_Backcolorstyle ;
   private byte GXv_int5[] ;
   private byte GXv_int6[] ;
   private byte GRIDOPCIONES_nEOF ;
   private byte subGridopciones_Backstyle ;
   private byte subGridopciones_Allowselection ;
   private byte subGridopciones_Allowhovering ;
   private byte subGridopciones_Allowcollapsing ;
   private byte subGridopciones_Collapsed ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV6EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV28filas ;
   private short AV34SecUserId ;
   private short GXt_int3 ;
   private short GXv_int4[] ;
   private int nRC_GXsfl_15 ;
   private int nGXsfl_15_idx=1 ;
   private int AV5CliCod ;
   private int subGridopciones_Islastpage ;
   private int edtavMenuitemsdescription_Enabled ;
   private int edtavTituloopciones_Enabled ;
   private int divTabletituloopciones_Visible ;
   private int edtavImagemenuitemicon_Visible ;
   private int lblSvg_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private int subGridopciones_Backcolor ;
   private int subGridopciones_Allbackcolor ;
   private int subGridopciones_Selectedindex ;
   private int subGridopciones_Selectioncolor ;
   private int subGridopciones_Hoveringcolor ;
   private long A1928MenuVerId ;
   private long AV30MenuVerId ;
   private long GRIDOPCIONES_nCurrentRecord ;
   private long GRIDOPCIONES_nFirstRecordOnPage ;
   private long GXv_int7[] ;
   private String edtavMenuitemsdescription_Class ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_15_idx="0001" ;
   private String edtavMenuitemsdescription_Internalname ;
   private String A1933MenuOpcPadre ;
   private String A1935SVGId ;
   private String A1942MenuItemImgExt ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String A3llinktablamenu_Linkrowid ;
   private String A3llinktablamenu_Urls ;
   private String subGridopciones_Class ;
   private String subGridopciones_Flexwrap ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String A3llinktablamenu_Internalname ;
   private String sStyleString ;
   private String subGridopciones_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavImagemenuitemicon_Internalname ;
   private String AV9MenuItemsDescription ;
   private String AV26TituloOpciones ;
   private String edtavTituloopciones_Internalname ;
   private String AV50Pgmname ;
   private String divTabletituloopciones_Internalname ;
   private String scmdbuf ;
   private String A1941MenuItemImg_Filename ;
   private String A1941MenuItemImg_Filetype ;
   private String lblSvg_Caption ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String lblSvg_Internalname ;
   private String sGXsfl_15_fel_idx="0001" ;
   private String subGridopciones_Linesclass ;
   private String divTableitem_Internalname ;
   private String divTablecenter_Internalname ;
   private String divTableiconoitem_Internalname ;
   private String edtavImagemenuitemicon_gximage ;
   private String sImgUrl ;
   private String lblSvg_Jsonclick ;
   private String divTabletituloitem_Internalname ;
   private String ROClassString ;
   private String edtavMenuitemsdescription_Jsonclick ;
   private String edtavTituloopciones_Jsonclick ;
   private String subGridopciones_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_15_Refreshing=false ;
   private boolean n1933MenuOpcPadre ;
   private boolean n1935SVGId ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV7ImageMenuItemIcon_IsBlob ;
   private String A1936SVGValor ;
   private String A1941MenuItemImg ;
   private String wcpOAV35MenuOpcCod ;
   private String AV35MenuOpcCod ;
   private String A1943MenuItemImgNom ;
   private String A1937MenuItemId ;
   private String A1929MenuOpcCod ;
   private String A1931MenuOpcTitulo ;
   private String AV52Imagemenuitemicon_GXI ;
   private String AV33URL ;
   private String AV7ImageMenuItemIcon ;
   private com.genexus.webpanels.GXWebGrid GridopcionesContainer ;
   private com.genexus.webpanels.GXWebRow GridopcionesRow ;
   private com.genexus.webpanels.GXWebColumn GridopcionesColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucA3llinktablamenu ;
   private IDataStoreProvider pr_default ;
   private byte[] H00L12_A1923RolId ;
   private byte[] H00L12_A1925PerfilId ;
   private long[] H00L12_A1928MenuVerId ;
   private String[] H00L12_A1933MenuOpcPadre ;
   private boolean[] H00L12_n1933MenuOpcPadre ;
   private String[] H00L12_A1943MenuItemImgNom ;
   private String[] H00L12_A1942MenuItemImgExt ;
   private String[] H00L12_A1935SVGId ;
   private boolean[] H00L12_n1935SVGId ;
   private String[] H00L12_A1941MenuItemImg ;
   private String[] H00L12_A1936SVGValor ;
   private String[] H00L12_A1937MenuItemId ;
   private String[] H00L12_A1929MenuOpcCod ;
   private String[] H00L12_A1931MenuOpcTitulo ;
   private byte[] H00L12_A1940MenuItemOrd ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV20websession ;
   private GXSimpleCollection<String> AV46urls ;
}

final  class menu__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00L12", "SELECT T1.RolId, T1.PerfilId, T1.MenuVerId, T1.MenuOpcPadre, T1.MenuItemImgNom, T1.MenuItemImgExt, T1.SVGId, T1.MenuItemImg, T2.SVGValor, T1.MenuItemId, T1.MenuOpcCod, T1.MenuOpcTitulo, T1.MenuItemOrd FROM (MenuVersionesOpciones T1 LEFT JOIN SVG T2 ON T2.SVGId = T1.SVGId) WHERE T1.RolId = ? and T1.PerfilId = ? and T1.MenuVerId = ? and T1.MenuOpcPadre = ( ?) ORDER BY T1.RolId, T1.PerfilId, T1.MenuVerId, T1.MenuOpcPadre, T1.MenuItemOrd ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getBLOBFile(8, rslt.getString(6, 20), rslt.getVarchar(5));
               ((String[]) buf[10])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((String[]) buf[12])[0] = rslt.getVarchar(11);
               ((String[]) buf[13])[0] = rslt.getVarchar(12);
               ((byte[]) buf[14])[0] = rslt.getByte(13);
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setVarchar(4, (String)parms[3], 100);
               return;
      }
   }

}

