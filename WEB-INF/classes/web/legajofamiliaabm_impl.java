package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajofamiliaabm_impl extends GXDataArea
{
   public legajofamiliaabm_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajofamiliaabm_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajofamiliaabm_impl.class ));
   }

   public legajofamiliaabm_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynavLegajofamilia_parcod = new HTMLChoice();
      chkavLegajofamilia_famdiscap = UIFactory.getCheckbox(this);
      chkavLegajofamilia_famadherente = UIFactory.getCheckbox(this);
      dynavLegajofamilia_guarcod = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "TrnMode") ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"LEGAJOFAMILIA_PARCOD") == 0 )
         {
            AV14CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvlegajofamilia_parcod8P2( AV14CliCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"LEGAJOFAMILIA_GUARCOD") == 0 )
         {
            AV14CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
            AV15EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15EmpCod), "ZZZ9")));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvlegajofamilia_guarcod8P2( AV14CliCod, AV15EmpCod) ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "TrnMode") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "TrnMode") ;
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
            AV11TrnMode = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11TrnMode", AV11TrnMode);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11TrnMode, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV14CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14CliCod), 6, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
               AV15EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15EmpCod), "ZZZ9")));
               AV16LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16LegNumero), 8, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16LegNumero), "ZZZZZZZ9")));
               AV17LegOrden = (short)(GXutil.lval( httpContext.GetPar( "LegOrden"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV17LegOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17LegOrden), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGORDEN", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17LegOrden), "ZZZ9")));
            }
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
      pa8P2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start8P2( ) ;
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.legajofamiliaabm", new String[] {GXutil.URLEncode(GXutil.rtrim(AV11TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV14CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV16LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV17LegOrden,4,0))}, new String[] {"TrnMode","CliCod","EmpCod","LegNumero","LegOrden"}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV33Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGORDEN", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17LegOrden), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Legajofamilia", AV7LegajoFamilia);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Legajofamilia", AV7LegajoFamilia);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTRNMODE", GXutil.rtrim( AV11TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV16LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV33Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV33Pgmname, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCHECKREQUIREDFIELDSRESULT", AV8CheckRequiredFieldsResult);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMESSAGES", AV10Messages);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMESSAGES", AV10Messages);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGORDEN", GXutil.ltrim( localUtil.ntoc( AV17LegOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGORDEN", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17LegOrden), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV14CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV15EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15EmpCod), "ZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGAJOFAMILIA", AV7LegajoFamilia);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGAJOFAMILIA", AV7LegajoFamilia);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
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
      httpContext.writeTextNL( "</form>") ;
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
         we8P2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt8P2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.legajofamiliaabm", new String[] {GXutil.URLEncode(GXutil.rtrim(AV11TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV14CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV16LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV17LegOrden,4,0))}, new String[] {"TrnMode","CliCod","EmpCod","LegNumero","LegOrden"})  ;
   }

   public String getPgmname( )
   {
      return "LegajoFamiliaABM" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Legajo Familia ABM", "") ;
   }

   public void wb8P0( )
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
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
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
         wb_table1_9_8P2( true) ;
      }
      else
      {
         wb_table1_9_8P2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_8P2e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegajofamilia_clicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Clicod(), (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Clicod()), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,76);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegajofamilia_clicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavLegajofamilia_clicod_Visible, 1, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajoFamiliaABM.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegajofamilia_empcod_Internalname, GXutil.ltrim( localUtil.ntoc( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Empcod(), (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Empcod()), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,77);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegajofamilia_empcod_Jsonclick, 0, "Attribute", "", "", "", "", edtavLegajofamilia_empcod_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajoFamiliaABM.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegajofamilia_legnumero_Internalname, GXutil.ltrim( localUtil.ntoc( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Legnumero(), (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Legnumero()), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,78);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegajofamilia_legnumero_Jsonclick, 0, "Attribute", "", "", "", "", edtavLegajofamilia_legnumero_Visible, 1, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajoFamiliaABM.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegajofamilia_legorden_Internalname, GXutil.ltrim( localUtil.ntoc( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Legorden(), (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Legorden()), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegajofamilia_legorden_Jsonclick, 0, "Attribute", "", "", "", "", edtavLegajofamilia_legorden_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajoFamiliaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start8P2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Legajo Familia ABM", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup8P0( ) ;
   }

   public void ws8P2( )
   {
      start8P2( ) ;
      evt8P2( ) ;
   }

   public void evt8P2( )
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e118P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e128P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              Rfr0gs = false ;
                              if ( ! Rfr0gs )
                              {
                                 /* Execute user event: Enter */
                                 e138P2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LEGAJOFAMILIA_PARCOD.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e148P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e158P2 ();
                           /* No code required for Cancel button. It is implemented as the Reset button. */
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
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we8P2( )
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

   public void pa8P2( )
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
            GX_FocusControl = edtavLegidnomape_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvlegajofamilia_parcod8P2( int AV14CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvlegajofamilia_parcod_data8P2( AV14CliCod) ;
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

   public void gxvlegajofamilia_parcod_html8P2( int AV14CliCod )
   {
      String gxdynajaxvalue;
      gxdlvlegajofamilia_parcod_data8P2( AV14CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavLegajofamilia_parcod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavLegajofamilia_parcod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavLegajofamilia_parcod.getItemCount() > 0 )
      {
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Parcod( dynavLegajofamilia_parcod.getValidValue(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod()) );
      }
   }

   protected void gxdlvlegajofamilia_parcod_data8P2( int AV14CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H008P2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H008P2_A30ParCod[0]));
         gxdynajaxctrldescr.add(H008P2_A313ParDescrip[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvlegajofamilia_guarcod8P2( int AV14CliCod ,
                                              short AV15EmpCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvlegajofamilia_guarcod_data8P2( AV14CliCod, AV15EmpCod) ;
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

   public void gxvlegajofamilia_guarcod_html8P2( int AV14CliCod ,
                                                 short AV15EmpCod )
   {
      short gxdynajaxvalue;
      gxdlvlegajofamilia_guarcod_data8P2( AV14CliCod, AV15EmpCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavLegajofamilia_guarcod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavLegajofamilia_guarcod.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvlegajofamilia_guarcod_data8P2( int AV14CliCod ,
                                                      short AV15EmpCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H008P3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV15EmpCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H008P3_A1547GuarCod[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H008P3_A1548GuarNom[0]);
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
         gxvlegajofamilia_parcod_html8P2( AV14CliCod) ;
         gxvlegajofamilia_guarcod_html8P2( AV14CliCod, AV15EmpCod) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynavLegajofamilia_parcod.getItemCount() > 0 )
      {
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Parcod( dynavLegajofamilia_parcod.getValidValue(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavLegajofamilia_parcod.setValue( GXutil.rtrim( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod()) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegajofamilia_parcod.getInternalname(), "Values", dynavLegajofamilia_parcod.ToJavascriptSource(), true);
      }
      if ( dynavLegajofamilia_guarcod.getItemCount() > 0 )
      {
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Guarcod( (short)(GXutil.lval( dynavLegajofamilia_guarcod.getValidValue(GXutil.trim( GXutil.str( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Guarcod(), 4, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavLegajofamilia_guarcod.setValue( GXutil.trim( GXutil.str( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Guarcod(), 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegajofamilia_guarcod.getInternalname(), "Values", dynavLegajofamilia_guarcod.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf8P2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV33Pgmname = "LegajoFamiliaABM" ;
      Gx_err = (short)(0) ;
      edtavLegidnomape_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLegidnomape_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegidnomape_Enabled), 5, 0), true);
   }

   public void rf8P2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e128P2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e158P2 ();
         wb8P0( ) ;
      }
   }

   public void send_integrity_lvl_hashes8P2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vTRNMODE", GXutil.rtrim( AV11TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV14CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV15EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV16LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV33Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV33Pgmname, ""))));
   }

   public void before_start_formulas( )
   {
      AV33Pgmname = "LegajoFamiliaABM" ;
      Gx_err = (short)(0) ;
      edtavLegidnomape_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLegidnomape_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegidnomape_Enabled), 5, 0), true);
      gxvlegajofamilia_parcod_html8P2( AV14CliCod) ;
      gxvlegajofamilia_guarcod_html8P2( AV14CliCod, AV15EmpCod) ;
      fix_multi_value_controls( ) ;
   }

   public void strup8P0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e118P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGAJOFAMILIA"), AV7LegajoFamilia);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Legajofamilia"), AV7LegajoFamilia);
         /* Read saved values. */
         Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
         Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
         Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
         Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
         Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
         Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
         Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
         Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
         Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
         Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
         /* Read variables values. */
         AV18LegIdNomApe = httpContext.cgiGet( edtavLegidnomape_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18LegIdNomApe", AV18LegIdNomApe);
         dynavLegajofamilia_parcod.setValue( httpContext.cgiGet( dynavLegajofamilia_parcod.getInternalname()) );
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Parcod( httpContext.cgiGet( dynavLegajofamilia_parcod.getInternalname()) );
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Famnrodoc( httpContext.cgiGet( edtavLegajofamilia_famnrodoc_Internalname) );
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Famnomape( httpContext.cgiGet( edtavLegajofamilia_famnomape_Internalname) );
         if ( localUtil.vcdate( httpContext.cgiGet( edtavLegajofamilia_famfecnac_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "LEGAJOFAMILIA_FAMFECNAC");
            GX_FocusControl = edtavLegajofamilia_famfecnac_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Famfecnac( GXutil.nullDate() );
         }
         else
         {
            AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Famfecnac( localUtil.ctod( httpContext.cgiGet( edtavLegajofamilia_famfecnac_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) );
         }
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Famdiscap( GXutil.strtobool( httpContext.cgiGet( chkavLegajofamilia_famdiscap.getInternalname())) );
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavLegajofamilia_famtomadeducimpgan_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavLegajofamilia_famtomadeducimpgan_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGAJOFAMILIA_FAMTOMADEDUCIMPGAN");
            GX_FocusControl = edtavLegajofamilia_famtomadeducimpgan_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Famtomadeducimpgan( DecimalUtil.ZERO );
         }
         else
         {
            AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Famtomadeducimpgan( localUtil.ctond( httpContext.cgiGet( edtavLegajofamilia_famtomadeducimpgan_Internalname)) );
         }
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Famadherente( GXutil.strtobool( httpContext.cgiGet( chkavLegajofamilia_famadherente.getInternalname())) );
         dynavLegajofamilia_guarcod.setValue( httpContext.cgiGet( dynavLegajofamilia_guarcod.getInternalname()) );
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Guarcod( (short)(GXutil.lval( httpContext.cgiGet( dynavLegajofamilia_guarcod.getInternalname()))) );
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLegajofamilia_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLegajofamilia_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGAJOFAMILIA_CLICOD");
            GX_FocusControl = edtavLegajofamilia_clicod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Clicod( 0 );
         }
         else
         {
            AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Clicod( (int)(localUtil.ctol( httpContext.cgiGet( edtavLegajofamilia_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLegajofamilia_empcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLegajofamilia_empcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGAJOFAMILIA_EMPCOD");
            GX_FocusControl = edtavLegajofamilia_empcod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Empcod( (short)(0) );
         }
         else
         {
            AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Empcod( (short)(localUtil.ctol( httpContext.cgiGet( edtavLegajofamilia_empcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLegajofamilia_legnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLegajofamilia_legnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGAJOFAMILIA_LEGNUMERO");
            GX_FocusControl = edtavLegajofamilia_legnumero_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Legnumero( 0 );
         }
         else
         {
            AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Legnumero( (int)(localUtil.ctol( httpContext.cgiGet( edtavLegajofamilia_legnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLegajofamilia_legorden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLegajofamilia_legorden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGAJOFAMILIA_LEGORDEN");
            GX_FocusControl = edtavLegajofamilia_legorden_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Legorden( (short)(0) );
         }
         else
         {
            AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Legorden( (short)(localUtil.ctol( httpContext.cgiGet( edtavLegajofamilia_legorden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         gxvlegajofamilia_parcod_html8P2( AV14CliCod) ;
         gxvlegajofamilia_guarcod_html8P2( AV14CliCod, AV15EmpCod) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e118P2 ();
      if (returnInSub) return;
   }

   public void e118P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_char1[0] = AV18LegIdNomApe ;
      new web.getlegidnomape(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV16LegNumero, GXv_char1) ;
      legajofamiliaabm_impl.this.AV18LegIdNomApe = GXv_char1[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18LegIdNomApe", AV18LegIdNomApe);
      new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "Clicod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))+httpContext.getMessage( " Empcod ", "")+GXutil.trim( GXutil.str( AV15EmpCod, 4, 0))+httpContext.getMessage( " legnumero ", "")+GXutil.trim( GXutil.str( AV16LegNumero, 8, 0))) ;
      if ( GXutil.strcmp(AV11TrnMode, "INS") == 0 )
      {
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Clicod( AV14CliCod );
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Empcod( AV15EmpCod );
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Legnumero( AV16LegNumero );
      }
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      AV12LoadSuccess = true ;
      if ( ( ( GXutil.strcmp(AV11TrnMode, "DSP") == 0 ) ) || ( ( GXutil.strcmp(AV11TrnMode, "INS") == 0 ) ) || ( ( GXutil.strcmp(AV11TrnMode, "UPD") == 0 ) ) || ( ( GXutil.strcmp(AV11TrnMode, "DLT") == 0 ) ) )
      {
         if ( GXutil.strcmp(AV11TrnMode, "INS") != 0 )
         {
            AV7LegajoFamilia.Load(AV14CliCod, AV15EmpCod, AV16LegNumero, AV17LegOrden);
            AV12LoadSuccess = AV7LegajoFamilia.Success() ;
            if ( ! AV12LoadSuccess )
            {
               AV10Messages = AV7LegajoFamilia.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
            if ( ( GXutil.strcmp(AV11TrnMode, "DSP") == 0 ) || ( GXutil.strcmp(AV11TrnMode, "DLT") == 0 ) )
            {
               dynavLegajofamilia_parcod.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, dynavLegajofamilia_parcod.getInternalname(), "Enabled", GXutil.ltrimstr( dynavLegajofamilia_parcod.getEnabled(), 5, 0), true);
               edtavLegajofamilia_famnrodoc_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavLegajofamilia_famnrodoc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegajofamilia_famnrodoc_Enabled), 5, 0), true);
               edtavLegajofamilia_famnomape_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavLegajofamilia_famnomape_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegajofamilia_famnomape_Enabled), 5, 0), true);
               edtavLegajofamilia_famfecnac_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavLegajofamilia_famfecnac_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegajofamilia_famfecnac_Enabled), 5, 0), true);
               chkavLegajofamilia_famdiscap.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavLegajofamilia_famdiscap.getInternalname(), "Enabled", GXutil.ltrimstr( chkavLegajofamilia_famdiscap.getEnabled(), 5, 0), true);
               edtavLegajofamilia_famtomadeducimpgan_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavLegajofamilia_famtomadeducimpgan_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegajofamilia_famtomadeducimpgan_Enabled), 5, 0), true);
               chkavLegajofamilia_famadherente.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavLegajofamilia_famadherente.getInternalname(), "Enabled", GXutil.ltrimstr( chkavLegajofamilia_famadherente.getEnabled(), 5, 0), true);
               dynavLegajofamilia_guarcod.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, dynavLegajofamilia_guarcod.getInternalname(), "Enabled", GXutil.ltrimstr( dynavLegajofamilia_guarcod.getEnabled(), 5, 0), true);
            }
         }
      }
      else
      {
         AV12LoadSuccess = false ;
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      if ( AV12LoadSuccess )
      {
         if ( GXutil.strcmp(AV11TrnMode, "DLT") == 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "GXM_confdelete", ""));
         }
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if (returnInSub) return;
      edtavLegajofamilia_clicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLegajofamilia_clicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegajofamilia_clicod_Visible), 5, 0), true);
      edtavLegajofamilia_empcod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLegajofamilia_empcod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegajofamilia_empcod_Visible), 5, 0), true);
      edtavLegajofamilia_legnumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLegajofamilia_legnumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegajofamilia_legnumero_Visible), 5, 0), true);
      edtavLegajofamilia_legorden_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLegajofamilia_legorden_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegajofamilia_legorden_Visible), 5, 0), true);
   }

   public void e128P2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S132 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e138P2 ();
      if (returnInSub) return;
   }

   public void e138P2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV11TrnMode, "INS") == 0 )
      {
         GXt_int2 = (short)(0) ;
         GXv_int3[0] = GXt_int2 ;
         new web.obtnroordenlegfamilia(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV16LegNumero, GXv_int3) ;
         legajofamiliaabm_impl.this.GXt_int2 = GXv_int3[0] ;
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Legorden( GXt_int2 );
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 1Clicod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))+httpContext.getMessage( " Empcod ", "")+GXutil.trim( GXutil.str( AV15EmpCod, 4, 0))+httpContext.getMessage( " legnumero ", "")+GXutil.trim( GXutil.str( AV16LegNumero, 8, 0))+httpContext.getMessage( " &TrnMode ", "")+AV11TrnMode) ;
      if ( (0==AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Guarcod()) )
      {
         AV7LegajoFamilia.setgxTv_SdtLegajoFamilia_Guarcod_SetNull();
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 11", "")) ;
      if ( false )
      {
         if ( GXutil.strcmp(AV11TrnMode, "DSP") != 0 )
         {
            if ( GXutil.strcmp(AV11TrnMode, "DLT") != 0 )
            {
               /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
               S142 ();
               if (returnInSub) return;
            }
            if ( ( GXutil.strcmp(AV11TrnMode, "DLT") == 0 ) || AV8CheckRequiredFieldsResult )
            {
               if ( GXutil.strcmp(AV11TrnMode, "DLT") == 0 )
               {
                  AV7LegajoFamilia.Delete();
               }
               else
               {
                  AV7LegajoFamilia.Save();
               }
               if ( AV7LegajoFamilia.Success() )
               {
                  /* Execute user subroutine: 'AFTER_TRN' */
                  S152 ();
                  if (returnInSub) return;
               }
               else
               {
                  AV10Messages = AV7LegajoFamilia.GetMessages() ;
                  /* Execute user subroutine: 'SHOW MESSAGES' */
                  S112 ();
                  if (returnInSub) return;
               }
            }
         }
      }
      else
      {
         if ( GXutil.strcmp(AV11TrnMode, "DSP") != 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 12", "")) ;
            if ( GXutil.strcmp(AV11TrnMode, "DLT") != 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 13", "")) ;
               /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
               S142 ();
               if (returnInSub) return;
               new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 14", "")) ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 15", "")) ;
            if ( ( GXutil.strcmp(AV11TrnMode, "DLT") == 0 ) || AV8CheckRequiredFieldsResult )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 16", "")) ;
               if ( GXutil.strcmp(AV11TrnMode, "DLT") == 0 )
               {
                  AV7LegajoFamilia.Delete();
               }
               else
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 31 CliCod ", "")+GXutil.trim( GXutil.str( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Clicod(), 6, 0))+httpContext.getMessage( " EmpCod ", "")+GXutil.trim( GXutil.str( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Empcod(), 4, 0))+httpContext.getMessage( " LegOrden ", "")+GXutil.trim( GXutil.str( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Legorden(), 4, 0))+httpContext.getMessage( " legnumero ", "")+GXutil.trim( GXutil.str( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Legnumero(), 8, 0))) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 31 FamAdherente ", "")+GXutil.trim( GXutil.booltostr( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famadherente()))+httpContext.getMessage( " FamApellido ", "")+AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famapellido()+httpContext.getMessage( " FamAsigFam ", "")+GXutil.trim( GXutil.booltostr( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famasigfam()))+httpContext.getMessage( " FamDiscap ", "")+GXutil.trim( GXutil.booltostr( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famdiscap()))+httpContext.getMessage( " FamFecNac ", "")+GXutil.trim( localUtil.dtoc( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famfecnac(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " FamMesDesde ", "")+GXutil.trim( GXutil.str( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Fammesdesde(), 4, 0))+httpContext.getMessage( " FamMesHasta ", "")+GXutil.trim( GXutil.str( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Fammeshasta(), 4, 0))+httpContext.getMessage( " FamNombres ", "")+AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famnombres()+httpContext.getMessage( " FamNroDoc ", "")+AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famnrodoc()+httpContext.getMessage( " FamTomaDeducImpGan ", "")+GXutil.trim( GXutil.str( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famtomadeducimpgan(), 6, 4))+httpContext.getMessage( " guarcod ", "")+GXutil.trim( GXutil.str( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Guarcod(), 4, 0))+httpContext.getMessage( " ParCod ", "")+AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod()+httpContext.getMessage( " ParDescrip ", "")+AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Pardescrip()) ;
                  AV7LegajoFamilia.Save();
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 17", "")) ;
               if ( AV7LegajoFamilia.Success() )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 18", "")) ;
                  /* Execute user subroutine: 'AFTER_TRN' */
                  S152 ();
                  if (returnInSub) return;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 19", "")) ;
               }
               else
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 20", "")) ;
                  AV10Messages = AV7LegajoFamilia.GetMessages() ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 21", "")) ;
                  /* Execute user subroutine: 'SHOW MESSAGES' */
                  S112 ();
                  if (returnInSub) return;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 22", "")) ;
               }
            }
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "enter 2 Clicod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))+httpContext.getMessage( " Empcod ", "")+GXutil.trim( GXutil.str( AV15EmpCod, 4, 0))+httpContext.getMessage( " legnumero ", "")+GXutil.trim( GXutil.str( AV16LegNumero, 8, 0))) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV7LegajoFamilia", AV7LegajoFamilia);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10Messages", AV10Messages);
   }

   public void S132( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(AV11TrnMode, "DSP") != 0 ) ) )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      }
   }

   public void S142( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV8CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8CheckRequiredFieldsResult", AV8CheckRequiredFieldsResult);
      if ( (GXutil.strcmp("", AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famnrodoc())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nro. Doc.", ""), "", "", "", "", "", "", "", ""), "error", edtavLegajofamilia_famnrodoc_Internalname, "true", ""));
         AV8CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8CheckRequiredFieldsResult", AV8CheckRequiredFieldsResult);
      }
      if ( ( ( GXutil.strcmp(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod(), new web.getparametro(remoteHandle, context).executeUdp( AV14CliCod, new web.parentescoconyuge_codigoparam(remoteHandle, context).executeUdp( ))) != 0 ) ) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famfecnac())) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha de nacimiento", ""), "", "", "", "", "", "", "", ""), "error", edtavLegajofamilia_famfecnac_Internalname, "true", ""));
         AV8CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8CheckRequiredFieldsResult", AV8CheckRequiredFieldsResult);
      }
      if ( ( GXutil.strcmp(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod(), new web.getparametro(remoteHandle, context).executeUdp( AV14CliCod, new web.parentescoconyuge_codigoparam(remoteHandle, context).executeUdp( ))) == 0 ) && ( DecimalUtil.compareTo(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famtomadeducimpgan(), DecimalUtil.stringToDec("0.5")) == 0 ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Conyuge no puede deducir 50%", ""), "", "", "", "", "", "", "", ""), "error", edtavLegajofamilia_famtomadeducimpgan_Internalname, "true", ""));
         AV8CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8CheckRequiredFieldsResult", AV8CheckRequiredFieldsResult);
      }
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod(), new web.getparametro(remoteHandle, context).executeUdp( AV14CliCod, new web.parentescoconyuge_codigoparam(remoteHandle, context).executeUdp( ))) != 0 ) ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         edtavLegajofamilia_famfecnac_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLegajofamilia_famfecnac_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegajofamilia_famfecnac_Visible), 5, 0), true);
         divLegajofamilia_famfecnac_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divLegajofamilia_famfecnac_cell_Internalname, "Class", divLegajofamilia_famfecnac_cell_Class, true);
      }
      else
      {
         edtavLegajofamilia_famfecnac_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLegajofamilia_famfecnac_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegajofamilia_famfecnac_Visible), 5, 0), true);
         divLegajofamilia_famfecnac_cell_Class = "col-xs-12 RequiredDataContentCell" ;
         httpContext.ajax_rsp_assign_prop("", false, divLegajofamilia_famfecnac_cell_Internalname, "Class", divLegajofamilia_famfecnac_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod(), new web.getparametro(remoteHandle, context).executeUdp( AV14CliCod, new web.parentescoconyuge_codigoparam(remoteHandle, context).executeUdp( ))) != 0 ) ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         chkavLegajofamilia_famdiscap.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavLegajofamilia_famdiscap.getInternalname(), "Visible", GXutil.ltrimstr( chkavLegajofamilia_famdiscap.getVisible(), 5, 0), true);
         divLegajofamilia_famdiscap_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divLegajofamilia_famdiscap_cell_Internalname, "Class", divLegajofamilia_famdiscap_cell_Class, true);
      }
      else
      {
         chkavLegajofamilia_famdiscap.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavLegajofamilia_famdiscap.getInternalname(), "Visible", GXutil.ltrimstr( chkavLegajofamilia_famdiscap.getVisible(), 5, 0), true);
         divLegajofamilia_famdiscap_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop("", false, divLegajofamilia_famdiscap_cell_Internalname, "Class", divLegajofamilia_famdiscap_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod(), new web.getparametro(remoteHandle, context).executeUdp( AV14CliCod, new web.parentescoconyuge_codigoparam(remoteHandle, context).executeUdp( ))) != 0 ) ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         dynavLegajofamilia_guarcod.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegajofamilia_guarcod.getInternalname(), "Visible", GXutil.ltrimstr( dynavLegajofamilia_guarcod.getVisible(), 5, 0), true);
         divLegajofamilia_guarcod_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divLegajofamilia_guarcod_cell_Internalname, "Class", divLegajofamilia_guarcod_cell_Class, true);
      }
      else
      {
         dynavLegajofamilia_guarcod.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegajofamilia_guarcod.getInternalname(), "Visible", GXutil.ltrimstr( dynavLegajofamilia_guarcod.getVisible(), 5, 0), true);
         divLegajofamilia_guarcod_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop("", false, divLegajofamilia_guarcod_cell_Internalname, "Class", divLegajofamilia_guarcod_cell_Class, true);
      }
   }

   public void S112( )
   {
      /* 'SHOW MESSAGES' Routine */
      returnInSub = false ;
      AV35GXV13 = 1 ;
      while ( AV35GXV13 <= AV10Messages.size() )
      {
         AV9Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV10Messages.elementAt(-1+AV35GXV13));
         httpContext.GX_msglist.addItem(AV9Message.getgxTv_SdtMessages_Message_Description());
         AV35GXV13 = (int)(AV35GXV13+1) ;
      }
   }

   public void S152( )
   {
      /* 'AFTER_TRN' Routine */
      returnInSub = false ;
      Application.commitDataStores(context, remoteHandle, pr_default, "legajofamiliaabm");
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   public void e148P2( )
   {
      /* Legajofamilia_parcod_Click Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod(), new web.getparametro(remoteHandle, context).executeUdp( AV14CliCod, new web.parentescoconyuge_codigoparam(remoteHandle, context).executeUdp( ))) != 0 ) ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         edtavLegajofamilia_famfecnac_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLegajofamilia_famfecnac_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegajofamilia_famfecnac_Visible), 5, 0), true);
         divLegajofamilia_famfecnac_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divLegajofamilia_famfecnac_cell_Internalname, "Class", divLegajofamilia_famfecnac_cell_Class, true);
      }
      else
      {
         edtavLegajofamilia_famfecnac_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLegajofamilia_famfecnac_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegajofamilia_famfecnac_Visible), 5, 0), true);
         divLegajofamilia_famfecnac_cell_Class = "col-xs-12 RequiredDataContentCell" ;
         httpContext.ajax_rsp_assign_prop("", false, divLegajofamilia_famfecnac_cell_Internalname, "Class", divLegajofamilia_famfecnac_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod(), new web.getparametro(remoteHandle, context).executeUdp( AV14CliCod, new web.parentescoconyuge_codigoparam(remoteHandle, context).executeUdp( ))) != 0 ) ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         chkavLegajofamilia_famdiscap.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavLegajofamilia_famdiscap.getInternalname(), "Visible", GXutil.ltrimstr( chkavLegajofamilia_famdiscap.getVisible(), 5, 0), true);
         divLegajofamilia_famdiscap_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divLegajofamilia_famdiscap_cell_Internalname, "Class", divLegajofamilia_famdiscap_cell_Class, true);
      }
      else
      {
         chkavLegajofamilia_famdiscap.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavLegajofamilia_famdiscap.getInternalname(), "Visible", GXutil.ltrimstr( chkavLegajofamilia_famdiscap.getVisible(), 5, 0), true);
         divLegajofamilia_famdiscap_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop("", false, divLegajofamilia_famdiscap_cell_Internalname, "Class", divLegajofamilia_famdiscap_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod(), new web.getparametro(remoteHandle, context).executeUdp( AV14CliCod, new web.parentescoconyuge_codigoparam(remoteHandle, context).executeUdp( ))) != 0 ) ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         dynavLegajofamilia_guarcod.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegajofamilia_guarcod.getInternalname(), "Visible", GXutil.ltrimstr( dynavLegajofamilia_guarcod.getVisible(), 5, 0), true);
         divLegajofamilia_guarcod_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divLegajofamilia_guarcod_cell_Internalname, "Class", divLegajofamilia_guarcod_cell_Class, true);
      }
      else
      {
         dynavLegajofamilia_guarcod.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegajofamilia_guarcod.getInternalname(), "Visible", GXutil.ltrimstr( dynavLegajofamilia_guarcod.getVisible(), 5, 0), true);
         divLegajofamilia_guarcod_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop("", false, divLegajofamilia_guarcod_cell_Internalname, "Class", divLegajofamilia_guarcod_cell_Class, true);
      }
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e158P2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_9_8P2( boolean wbgen )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
         ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
         ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
         ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
         ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
         ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
         ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
         ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
         ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
         ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
         ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLegidnomape_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLegidnomape_Internalname, httpContext.getMessage( "Legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegidnomape_Internalname, AV18LegIdNomApe, GXutil.rtrim( localUtil.format( AV18LegIdNomApe, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegidnomape_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavLegidnomape_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LegajoFamiliaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavLegajofamilia_parcod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavLegajofamilia_parcod.getInternalname(), httpContext.getMessage( "Parentesco", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavLegajofamilia_parcod, dynavLegajofamilia_parcod.getInternalname(), GXutil.rtrim( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod()), 1, dynavLegajofamilia_parcod.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"ELEGAJOFAMILIA_PARCOD.CLICK."+"'", "char", "", 1, dynavLegajofamilia_parcod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "", true, (byte)(0), "HLP_LegajoFamiliaABM.htm");
         dynavLegajofamilia_parcod.setValue( GXutil.rtrim( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Parcod()) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegajofamilia_parcod.getInternalname(), "Values", dynavLegajofamilia_parcod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLegajofamilia_famnrodoc_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLegajofamilia_famnrodoc_Internalname, httpContext.getMessage( "Nro. Doc.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegajofamilia_famnrodoc_Internalname, GXutil.rtrim( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famnrodoc()), GXutil.rtrim( localUtil.format( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famnrodoc(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegajofamilia_famnrodoc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavLegajofamilia_famnrodoc_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LegajoFamiliaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLegajofamilia_famnomape_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLegajofamilia_famnomape_Internalname, httpContext.getMessage( "Nombre y apellido", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegajofamilia_famnomape_Internalname, AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famnomape(), GXutil.rtrim( localUtil.format( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famnomape(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegajofamilia_famnomape_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavLegajofamilia_famnomape_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LegajoFamiliaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLegajofamilia_famfecnac_cell_Internalname, 1, 0, "px", 0, "px", divLegajofamilia_famfecnac_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavLegajofamilia_famfecnac_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLegajofamilia_famfecnac_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLegajofamilia_famfecnac_Internalname, httpContext.getMessage( "Fecha de nacimiento", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavLegajofamilia_famfecnac_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegajofamilia_famfecnac_Internalname, localUtil.format(AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famfecnac(), "99/99/9999"), localUtil.format( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famfecnac(), "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegajofamilia_famfecnac_Jsonclick, 0, "AttributeDate", "", "", "", "", edtavLegajofamilia_famfecnac_Visible, edtavLegajofamilia_famfecnac_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajoFamiliaABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavLegajofamilia_famfecnac_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavLegajofamilia_famfecnac_Visible==0)||(edtavLegajofamilia_famfecnac_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LegajoFamiliaABM.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLegajofamilia_famdiscap_cell_Internalname, 1, 0, "px", 0, "px", divLegajofamilia_famdiscap_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkavLegajofamilia_famdiscap.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavLegajofamilia_famdiscap.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavLegajofamilia_famdiscap.getInternalname(), httpContext.getMessage( "Posee discapacidad", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavLegajofamilia_famdiscap.getInternalname(), GXutil.booltostr( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famdiscap()), "", httpContext.getMessage( "Posee discapacidad", ""), chkavLegajofamilia_famdiscap.getVisible(), chkavLegajofamilia_famdiscap.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(47, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,47);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLegajofamilia_famtomadeducimpgan_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLegajofamilia_famtomadeducimpgan_Internalname, httpContext.getMessage( "Deduce ganancias", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegajofamilia_famtomadeducimpgan_Internalname, GXutil.ltrim( localUtil.ntoc( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famtomadeducimpgan(), (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famtomadeducimpgan(), "9.9999")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegajofamilia_famtomadeducimpgan_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavLegajofamilia_famtomadeducimpgan_Enabled, 1, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajoFamiliaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavLegajofamilia_famadherente.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavLegajofamilia_famadherente.getInternalname(), httpContext.getMessage( "Es adherente adicional a la obra social", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavLegajofamilia_famadherente.getInternalname(), GXutil.booltostr( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Famadherente()), "", httpContext.getMessage( "Es adherente adicional a la obra social", ""), 1, chkavLegajofamilia_famadherente.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(57, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,57);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLegajofamilia_guarcod_cell_Internalname, 1, 0, "px", 0, "px", divLegajofamilia_guarcod_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", dynavLegajofamilia_guarcod.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavLegajofamilia_guarcod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavLegajofamilia_guarcod.getInternalname(), httpContext.getMessage( "Guardería", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavLegajofamilia_guarcod, dynavLegajofamilia_guarcod.getInternalname(), GXutil.trim( GXutil.str( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Guarcod(), 4, 0)), 1, dynavLegajofamilia_guarcod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynavLegajofamilia_guarcod.getVisible(), dynavLegajofamilia_guarcod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", "", true, (byte)(0), "HLP_LegajoFamiliaABM.htm");
         dynavLegajofamilia_guarcod.setValue( GXutil.trim( GXutil.str( AV7LegajoFamilia.getgxTv_SdtLegajoFamilia_Guarcod(), 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegajofamilia_guarcod.getInternalname(), "Values", dynavLegajofamilia_guarcod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
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
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LegajoFamiliaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LegajoFamiliaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_8P2e( true) ;
      }
      else
      {
         wb_table1_9_8P2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV11TrnMode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11TrnMode", AV11TrnMode);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11TrnMode, ""))));
      AV14CliCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
      AV15EmpCod = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15EmpCod), "ZZZ9")));
      AV16LegNumero = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16LegNumero), 8, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16LegNumero), "ZZZZZZZ9")));
      AV17LegOrden = ((Number) GXutil.testNumericType( getParm(obj,4), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17LegOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17LegOrden), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGORDEN", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17LegOrden), "ZZZ9")));
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
      pa8P2( ) ;
      ws8P2( ) ;
      we8P2( ) ;
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
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202017466", true, true);
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
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("legajofamiliaabm.js", "?202412202017466", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavLegidnomape_Internalname = "vLEGIDNOMAPE" ;
      dynavLegajofamilia_parcod.setInternalname( "LEGAJOFAMILIA_PARCOD" );
      edtavLegajofamilia_famnrodoc_Internalname = "LEGAJOFAMILIA_FAMNRODOC" ;
      edtavLegajofamilia_famnomape_Internalname = "LEGAJOFAMILIA_FAMNOMAPE" ;
      edtavLegajofamilia_famfecnac_Internalname = "LEGAJOFAMILIA_FAMFECNAC" ;
      divLegajofamilia_famfecnac_cell_Internalname = "LEGAJOFAMILIA_FAMFECNAC_CELL" ;
      chkavLegajofamilia_famdiscap.setInternalname( "LEGAJOFAMILIA_FAMDISCAP" );
      divLegajofamilia_famdiscap_cell_Internalname = "LEGAJOFAMILIA_FAMDISCAP_CELL" ;
      edtavLegajofamilia_famtomadeducimpgan_Internalname = "LEGAJOFAMILIA_FAMTOMADEDUCIMPGAN" ;
      chkavLegajofamilia_famadherente.setInternalname( "LEGAJOFAMILIA_FAMADHERENTE" );
      dynavLegajofamilia_guarcod.setInternalname( "LEGAJOFAMILIA_GUARCOD" );
      divLegajofamilia_guarcod_cell_Internalname = "LEGAJOFAMILIA_GUARCOD_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavLegajofamilia_clicod_Internalname = "LEGAJOFAMILIA_CLICOD" ;
      edtavLegajofamilia_empcod_Internalname = "LEGAJOFAMILIA_EMPCOD" ;
      edtavLegajofamilia_legnumero_Internalname = "LEGAJOFAMILIA_LEGNUMERO" ;
      edtavLegajofamilia_legorden_Internalname = "LEGAJOFAMILIA_LEGORDEN" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      bttBtnenter_Visible = 1 ;
      dynavLegajofamilia_guarcod.setJsonclick( "" );
      dynavLegajofamilia_guarcod.setEnabled( 1 );
      dynavLegajofamilia_guarcod.setVisible( 1 );
      chkavLegajofamilia_famadherente.setEnabled( 1 );
      edtavLegajofamilia_famtomadeducimpgan_Jsonclick = "" ;
      edtavLegajofamilia_famtomadeducimpgan_Enabled = 1 ;
      chkavLegajofamilia_famdiscap.setEnabled( 1 );
      chkavLegajofamilia_famdiscap.setVisible( 1 );
      edtavLegajofamilia_famfecnac_Jsonclick = "" ;
      edtavLegajofamilia_famfecnac_Enabled = 1 ;
      edtavLegajofamilia_famfecnac_Visible = 1 ;
      edtavLegajofamilia_famnomape_Jsonclick = "" ;
      edtavLegajofamilia_famnomape_Enabled = 1 ;
      edtavLegajofamilia_famnrodoc_Jsonclick = "" ;
      edtavLegajofamilia_famnrodoc_Enabled = 1 ;
      dynavLegajofamilia_parcod.setJsonclick( "" );
      dynavLegajofamilia_parcod.setEnabled( 1 );
      edtavLegidnomape_Jsonclick = "" ;
      edtavLegidnomape_Enabled = 1 ;
      divLegajofamilia_guarcod_cell_Class = "col-xs-12" ;
      divLegajofamilia_famdiscap_cell_Class = "col-xs-12" ;
      divLegajofamilia_famfecnac_cell_Class = "col-xs-12" ;
      dynavLegajofamilia_guarcod.setEnabled( 1 );
      chkavLegajofamilia_famadherente.setEnabled( 1 );
      edtavLegajofamilia_famtomadeducimpgan_Enabled = 1 ;
      chkavLegajofamilia_famdiscap.setEnabled( 1 );
      edtavLegajofamilia_famfecnac_Enabled = 1 ;
      edtavLegajofamilia_famnomape_Enabled = 1 ;
      edtavLegajofamilia_famnrodoc_Enabled = 1 ;
      dynavLegajofamilia_parcod.setEnabled( 1 );
      edtavLegajofamilia_legorden_Jsonclick = "" ;
      edtavLegajofamilia_legorden_Visible = 1 ;
      edtavLegajofamilia_legnumero_Jsonclick = "" ;
      edtavLegajofamilia_legnumero_Visible = 1 ;
      edtavLegajofamilia_empcod_Jsonclick = "" ;
      edtavLegajofamilia_empcod_Visible = 1 ;
      edtavLegajofamilia_clicod_Jsonclick = "" ;
      edtavLegajofamilia_clicod_Visible = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "Familiar", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Legajo Familia ABM", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      dynavLegajofamilia_parcod.setName( "LEGAJOFAMILIA_PARCOD" );
      dynavLegajofamilia_parcod.setWebtags( "" );
      chkavLegajofamilia_famdiscap.setName( "LEGAJOFAMILIA_FAMDISCAP" );
      chkavLegajofamilia_famdiscap.setWebtags( "" );
      chkavLegajofamilia_famdiscap.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavLegajofamilia_famdiscap.getInternalname(), "TitleCaption", chkavLegajofamilia_famdiscap.getCaption(), true);
      chkavLegajofamilia_famdiscap.setCheckedValue( "false" );
      chkavLegajofamilia_famadherente.setName( "LEGAJOFAMILIA_FAMADHERENTE" );
      chkavLegajofamilia_famadherente.setWebtags( "" );
      chkavLegajofamilia_famadherente.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavLegajofamilia_famadherente.getInternalname(), "TitleCaption", chkavLegajofamilia_famadherente.getCaption(), true);
      chkavLegajofamilia_famadherente.setCheckedValue( "false" );
      dynavLegajofamilia_guarcod.setName( "LEGAJOFAMILIA_GUARCOD" );
      dynavLegajofamilia_guarcod.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV7LegajoFamilia',fld:'vLEGAJOFAMILIA',pic:''},{av:'GXV5',fld:'LEGAJOFAMILIA_FAMDISCAP',pic:''},{av:'GXV7',fld:'LEGAJOFAMILIA_FAMADHERENTE',pic:''},{av:'AV11TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV16LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV33Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17LegOrden',fld:'vLEGORDEN',pic:'ZZZ9',hsh:true},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV15EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{ctrl:'BTNENTER',prop:'Visible'}]}");
      setEventMetadata("ENTER","{handler:'e138P2',iparms:[{av:'AV11TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV15EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV16LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV7LegajoFamilia',fld:'vLEGAJOFAMILIA',pic:''},{av:'AV33Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV8CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV10Messages',fld:'vMESSAGES',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7LegajoFamilia',fld:'vLEGAJOFAMILIA',pic:''},{av:'AV10Messages',fld:'vMESSAGES',pic:''},{av:'AV8CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("LEGAJOFAMILIA_PARCOD.CLICK","{handler:'e148P2',iparms:[{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7LegajoFamilia',fld:'vLEGAJOFAMILIA',pic:''}]");
      setEventMetadata("LEGAJOFAMILIA_PARCOD.CLICK",",oparms:[{ctrl:'LEGAJOFAMILIA_FAMFECNAC',prop:'Visible'},{av:'divLegajofamilia_famfecnac_cell_Class',ctrl:'LEGAJOFAMILIA_FAMFECNAC_CELL',prop:'Class'},{ctrl:'LEGAJOFAMILIA_FAMDISCAP',prop:'Visible'},{av:'divLegajofamilia_famdiscap_cell_Class',ctrl:'LEGAJOFAMILIA_FAMDISCAP_CELL',prop:'Class'},{ctrl:'LEGAJOFAMILIA_GUARCOD',prop:'Visible'},{av:'divLegajofamilia_guarcod_cell_Class',ctrl:'LEGAJOFAMILIA_GUARCOD_CELL',prop:'Class'}]}");
      setEventMetadata("VALIDV_GXV6","{handler:'validv_Gxv6',iparms:[]");
      setEventMetadata("VALIDV_GXV6",",oparms:[]}");
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
      wcpOAV11TrnMode = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV11TrnMode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV33Pgmname = "" ;
      GXKey = "" ;
      AV7LegajoFamilia = new web.SdtLegajoFamilia(remoteHandle);
      AV10Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H008P2_A30ParCod = new String[] {""} ;
      H008P2_A313ParDescrip = new String[] {""} ;
      H008P2_A3CliCod = new int[1] ;
      H008P3_A1547GuarCod = new short[1] ;
      H008P3_A1548GuarNom = new String[] {""} ;
      H008P3_A3CliCod = new int[1] ;
      H008P3_A1EmpCod = new short[1] ;
      AV18LegIdNomApe = "" ;
      GXv_char1 = new String[1] ;
      Gx_mode = "" ;
      GXv_int3 = new short[1] ;
      AV9Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      ClassString = "" ;
      StyleString = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajofamiliaabm__default(),
         new Object[] {
             new Object[] {
            H008P2_A30ParCod, H008P2_A313ParDescrip, H008P2_A3CliCod
            }
            , new Object[] {
            H008P3_A1547GuarCod, H008P3_A1548GuarNom, H008P3_A3CliCod, H008P3_A1EmpCod
            }
         }
      );
      AV33Pgmname = "LegajoFamiliaABM" ;
      /* GeneXus formulas. */
      AV33Pgmname = "LegajoFamiliaABM" ;
      Gx_err = (short)(0) ;
      edtavLegidnomape_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOAV15EmpCod ;
   private short wcpOAV17LegOrden ;
   private short AV15EmpCod ;
   private short AV17LegOrden ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXt_int2 ;
   private short GXv_int3[] ;
   private int wcpOAV14CliCod ;
   private int wcpOAV16LegNumero ;
   private int AV14CliCod ;
   private int AV16LegNumero ;
   private int edtavLegajofamilia_clicod_Visible ;
   private int edtavLegajofamilia_empcod_Visible ;
   private int edtavLegajofamilia_legnumero_Visible ;
   private int edtavLegajofamilia_legorden_Visible ;
   private int gxdynajaxindex ;
   private int edtavLegidnomape_Enabled ;
   private int edtavLegajofamilia_famnrodoc_Enabled ;
   private int edtavLegajofamilia_famnomape_Enabled ;
   private int edtavLegajofamilia_famfecnac_Enabled ;
   private int edtavLegajofamilia_famtomadeducimpgan_Enabled ;
   private int bttBtnenter_Visible ;
   private int edtavLegajofamilia_famfecnac_Visible ;
   private int AV35GXV13 ;
   private int idxLst ;
   private String wcpOAV11TrnMode ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV11TrnMode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV33Pgmname ;
   private String GXKey ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String edtavLegajofamilia_clicod_Internalname ;
   private String edtavLegajofamilia_clicod_Jsonclick ;
   private String edtavLegajofamilia_empcod_Internalname ;
   private String edtavLegajofamilia_empcod_Jsonclick ;
   private String edtavLegajofamilia_legnumero_Internalname ;
   private String edtavLegajofamilia_legnumero_Jsonclick ;
   private String edtavLegajofamilia_legorden_Internalname ;
   private String edtavLegajofamilia_legorden_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavLegidnomape_Internalname ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String edtavLegajofamilia_famnrodoc_Internalname ;
   private String edtavLegajofamilia_famnomape_Internalname ;
   private String edtavLegajofamilia_famfecnac_Internalname ;
   private String edtavLegajofamilia_famtomadeducimpgan_Internalname ;
   private String GXv_char1[] ;
   private String Gx_mode ;
   private String bttBtnenter_Internalname ;
   private String divLegajofamilia_famfecnac_cell_Class ;
   private String divLegajofamilia_famfecnac_cell_Internalname ;
   private String divLegajofamilia_famdiscap_cell_Class ;
   private String divLegajofamilia_famdiscap_cell_Internalname ;
   private String divLegajofamilia_guarcod_cell_Class ;
   private String divLegajofamilia_guarcod_cell_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtavLegidnomape_Jsonclick ;
   private String edtavLegajofamilia_famnrodoc_Jsonclick ;
   private String edtavLegajofamilia_famnomape_Jsonclick ;
   private String edtavLegajofamilia_famfecnac_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtavLegajofamilia_famtomadeducimpgan_Jsonclick ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8CheckRequiredFieldsResult ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV12LoadSuccess ;
   private boolean Cond_result ;
   private String AV18LegIdNomApe ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private HTMLChoice dynavLegajofamilia_parcod ;
   private ICheckbox chkavLegajofamilia_famdiscap ;
   private ICheckbox chkavLegajofamilia_famadherente ;
   private HTMLChoice dynavLegajofamilia_guarcod ;
   private IDataStoreProvider pr_default ;
   private String[] H008P2_A30ParCod ;
   private String[] H008P2_A313ParDescrip ;
   private int[] H008P2_A3CliCod ;
   private short[] H008P3_A1547GuarCod ;
   private String[] H008P3_A1548GuarNom ;
   private int[] H008P3_A3CliCod ;
   private short[] H008P3_A1EmpCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV10Messages ;
   private com.genexus.SdtMessages_Message AV9Message ;
   private web.SdtLegajoFamilia AV7LegajoFamilia ;
}

final  class legajofamiliaabm__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H008P2", "SELECT ParCod, ParDescrip, CliCod FROM Parentesco WHERE CliCod = ? ORDER BY ParDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H008P3", "SELECT GuarCod, GuarNom, CliCod, EmpCod FROM EmpresaGuarderias WHERE (CliCod = ?) AND (EmpCod = ?) ORDER BY GuarNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

