package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class registronucleo_impl extends GXDataArea
{
   public registronucleo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public registronucleo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( registronucleo_impl.class ));
   }

   public registronucleo_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavMultiempresa = new HTMLChoice();
      dynavActcomcodigo = new HTMLChoice();
      chkavNucleoes = UIFactory.getCheckbox(this);
      chkavConveniadores = UIFactory.getCheckbox(this);
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
            AV17TrnMode = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17TrnMode", AV17TrnMode);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17TrnMode, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV21SecUserId = (short)(GXutil.lval( httpContext.GetPar( "SecUserId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV21SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21SecUserId), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21SecUserId), "ZZZ9")));
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
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.workwithplusmasterpageempty");
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
      paG92( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startG92( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.registronucleo", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV21SecUserId,4,0))}, new String[] {"TrnMode","SecUserId"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV49Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHAY", getSecureSignedToken( "", AV26hay));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSEREMPNOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV24SecUserEmpNom, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21SecUserId), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Secuser", AV7SecUser);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Secuser", AV7SecUser);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Secpaicod", AV25SecPaiCod);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Secpaicod", AV25SecPaiCod);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTRNMODE", GXutil.rtrim( AV17TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV49Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV49Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTERMINOINICIALIZACION", GXutil.rtrim( AV27terminoInicializacion));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCHECKREQUIREDFIELDSRESULT", AV19CheckRequiredFieldsResult);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CLIENTESISTEMA", A747ClienteSistema);
      web.GxWebStd.gx_hidden_field( httpContext, "CLIPAICOD", GXutil.ltrim( localUtil.ntoc( A4CliPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vHAY", AV26hay);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHAY", getSecureSignedToken( "", AV26hay));
      web.GxWebStd.gx_hidden_field( httpContext, "vSECUSEREMPNOM", AV24SecUserEmpNom);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSEREMPNOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV24SecUserEmpNom, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMESSAGES", AV16Messages);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMESSAGES", AV16Messages);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vSECUSERID", GXutil.ltrim( localUtil.ntoc( AV21SecUserId, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21SecUserId), "ZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECUSER", AV7SecUser);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECUSER", AV7SecUser);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECPAICOD", AV25SecPaiCod);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECPAICOD", AV25SecPaiCod);
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEMP1_Width", GXutil.rtrim( Dvpanel_panelemp1_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEMP1_Autowidth", GXutil.booltostr( Dvpanel_panelemp1_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEMP1_Autoheight", GXutil.booltostr( Dvpanel_panelemp1_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEMP1_Cls", GXutil.rtrim( Dvpanel_panelemp1_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEMP1_Title", GXutil.rtrim( Dvpanel_panelemp1_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEMP1_Collapsible", GXutil.booltostr( Dvpanel_panelemp1_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEMP1_Collapsed", GXutil.booltostr( Dvpanel_panelemp1_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEMP1_Showcollapseicon", GXutil.booltostr( Dvpanel_panelemp1_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEMP1_Iconposition", GXutil.rtrim( Dvpanel_panelemp1_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEMP1_Autoscroll", GXutil.booltostr( Dvpanel_panelemp1_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "vHTTPREQUEST_Baseurl", GXutil.rtrim( AV22httpRequest.getBaseURL()));
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
         weG92( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtG92( ) ;
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
      return formatLink("web.registronucleo", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV21SecUserId,4,0))}, new String[] {"TrnMode","SecUserId"})  ;
   }

   public String getPgmname( )
   {
      return "RegistroNucleo" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Registro núcleo", "") ;
   }

   public void wbG90( )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingBottom", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheadercontent_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 15,'',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgVolver_gximage, "")==0) ? "GX_Image_VolverIcon_Class" : "GX_Image_"+imgVolver_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "11248daf-d5b7-49c1-9201-63944b55a495", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgVolver_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", httpContext.getMessage( "Volver", ""), 0, 0, 0, "px", 0, "px", 0, 0, 5, imgVolver_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOVOLVER\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_RegistroNucleo.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Nuevo Usuario", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP ML10", 0, "", 1, 1, 0, (short)(0), "HLP_RegistroNucleo.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "CellMarginTop10", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-lg-6", "left", "top", "", "", "div");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuser_secuserpername_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecuser_secuserpername_Internalname, httpContext.getMessage( "Tu nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecuser_secuserpername_Internalname, AV7SecUser.getgxTv_SdtSecUser_Secuserpername(), GXutil.rtrim( localUtil.format( AV7SecUser.getgxTv_SdtSecUser_Secuserpername(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuser_secuserpername_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSecuser_secuserpername_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RegistroNucleo.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuser_secuserperlastname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecuser_secuserperlastname_Internalname, httpContext.getMessage( "Tu Apellido", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecuser_secuserperlastname_Internalname, AV7SecUser.getgxTv_SdtSecUser_Secuserperlastname(), GXutil.rtrim( localUtil.format( AV7SecUser.getgxTv_SdtSecUser_Secuserperlastname(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuser_secuserperlastname_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSecuser_secuserperlastname_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RegistroNucleo.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuser_secusername_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecuser_secusername_Internalname, httpContext.getMessage( "Correo electrónico", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecuser_secusername_Internalname, AV7SecUser.getgxTv_SdtSecUser_Secusername(), GXutil.rtrim( localUtil.format( AV7SecUser.getgxTv_SdtSecUser_Secusername(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuser_secusername_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSecuser_secusername_Enabled, 1, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RegistroNucleo.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuser_secuserpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecuser_secuserpassword_Internalname, httpContext.getMessage( "Contraseña", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavSecuser_secuserpassword_Internalname, AV7SecUser.getgxTv_SdtSecUser_Secuserpassword(), "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", (short)(0), 1, edtavSecuser_secuserpassword_Enabled, 1, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_RegistroNucleo.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuserpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecuserpassword_Internalname, httpContext.getMessage( "Repetir contraseña", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavSecuserpassword_Internalname, AV11SecUserPassword, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", (short)(0), 1, edtavSecuserpassword_Enabled, 1, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_RegistroNucleo.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavMultiempresa.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavMultiempresa.getInternalname(), httpContext.getMessage( "Empresas", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavMultiempresa, cmbavMultiempresa.getInternalname(), GXutil.rtrim( AV12MultiEmpresa), 1, cmbavMultiempresa.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavMultiempresa.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "", true, (byte)(0), "HLP_RegistroNucleo.htm");
         cmbavMultiempresa.setValue( GXutil.rtrim( AV12MultiEmpresa) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMultiempresa.getInternalname(), "Values", cmbavMultiempresa.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-lg-6", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelemp1.setProperty("Width", Dvpanel_panelemp1_Width);
         ucDvpanel_panelemp1.setProperty("AutoWidth", Dvpanel_panelemp1_Autowidth);
         ucDvpanel_panelemp1.setProperty("AutoHeight", Dvpanel_panelemp1_Autoheight);
         ucDvpanel_panelemp1.setProperty("Cls", Dvpanel_panelemp1_Cls);
         ucDvpanel_panelemp1.setProperty("Title", Dvpanel_panelemp1_Title);
         ucDvpanel_panelemp1.setProperty("Collapsible", Dvpanel_panelemp1_Collapsible);
         ucDvpanel_panelemp1.setProperty("Collapsed", Dvpanel_panelemp1_Collapsed);
         ucDvpanel_panelemp1.setProperty("ShowCollapseIcon", Dvpanel_panelemp1_Showcollapseicon);
         ucDvpanel_panelemp1.setProperty("IconPosition", Dvpanel_panelemp1_Iconposition);
         ucDvpanel_panelemp1.setProperty("AutoScroll", Dvpanel_panelemp1_Autoscroll);
         ucDvpanel_panelemp1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelemp1_Internalname, "DVPANEL_PANELEMP1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELEMP1Container"+"PanelEmp1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPanelemp1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuser_secuserempnom_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecuser_secuserempnom_Internalname, httpContext.getMessage( "Razón Social", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecuser_secuserempnom_Internalname, AV7SecUser.getgxTv_SdtSecUser_Secuserempnom(), GXutil.rtrim( localUtil.format( AV7SecUser.getgxTv_SdtSecUser_Secuserempnom(), "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuser_secuserempnom_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSecuser_secuserempnom_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RegistroNucleo.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuserempcuit_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecuserempcuit_Internalname, httpContext.getMessage( "Cuit", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecuserempcuit_Internalname, GXutil.ltrim( localUtil.ntoc( AV8SecUserEmpCuit, (byte)(13), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV8SecUserEmpCuit), "ZZ-ZZZZZZZZ-9")), TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,73);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuserempcuit_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSecuserempcuit_Enabled, 1, "text", "", 13, "chr", 1, "row", 13, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RegistroNucleo.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavActcomcodigo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavActcomcodigo.getInternalname(), httpContext.getMessage( "Actividad económica", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavActcomcodigo, dynavActcomcodigo.getInternalname(), GXutil.rtrim( AV29ActComCodigo), 1, dynavActcomcodigo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavActcomcodigo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,78);\"", "", true, (byte)(0), "HLP_RegistroNucleo.htm");
         dynavActcomcodigo.setValue( GXutil.rtrim( AV29ActComCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, dynavActcomcodigo.getInternalname(), "Values", dynavActcomcodigo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavNucleoes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavNucleoes.getInternalname(), httpContext.getMessage( "nucleo Es", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavNucleoes.getInternalname(), GXutil.booltostr( AV33nucleoEs), "", httpContext.getMessage( "nucleo Es", ""), 1, chkavNucleoes.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(83, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,83);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPaicod_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavPaicod_Internalname, httpContext.getMessage( "Código de pais", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavPaicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV35PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavPaicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV35PaiCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV35PaiCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,88);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPaicod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavPaicod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RegistroNucleo.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavConveniadores.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavConveniadores.getInternalname(), httpContext.getMessage( "conveniador Es", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavConveniadores.getInternalname(), GXutil.booltostr( AV34conveniadorEs), "", httpContext.getMessage( "conveniador Es", ""), 1, chkavConveniadores.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(93, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,93);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RegistroNucleo.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'',false,'',0)\"" ;
         ClassString = "BtnDefault" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RegistroNucleo.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtntest_Internalname, "", httpContext.getMessage( "Test", ""), bttBtntest_Jsonclick, 7, httpContext.getMessage( "Test", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e11g91_client"+"'", TempTags, "", 2, "HLP_RegistroNucleo.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 106,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavActcodigo_Internalname, GXutil.rtrim( AV10ActCodigo), GXutil.rtrim( localUtil.format( AV10ActCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,106);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavActcodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtavActcodigo_Visible, 1, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RegistroNucleo.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecuser_secuserid_Internalname, GXutil.ltrim( localUtil.ntoc( AV7SecUser.getgxTv_SdtSecUser_Secuserid(), (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7SecUser.getgxTv_SdtSecUser_Secuserid()), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,107);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuser_secuserid_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecuser_secuserid_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RegistroNucleo.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecpaicod_secuserpaicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV25SecPaiCod.getgxTv_SdtSecUser_Secuserpaicod(), (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV25SecPaiCod.getgxTv_SdtSecUser_Secuserpaicod()), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,108);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecpaicod_secuserpaicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecpaicod_secuserpaicod_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RegistroNucleo.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startG92( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Registro núcleo", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupG90( ) ;
   }

   public void wsG92( )
   {
      startG92( ) ;
      evtG92( ) ;
   }

   public void evtG92( )
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
                           e12G92 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e13G92 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOVOLVER'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoVolver' */
                           e14G92 ();
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
                                 e15G92 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e16G92 ();
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

   public void weG92( )
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

   public void paG92( )
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
            GX_FocusControl = edtavSecuser_secuserpername_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvvactcomcodigoG91( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvactcomcodigo_dataG91( ) ;
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

   public void gxvvactcomcodigo_htmlG91( )
   {
      String gxdynajaxvalue;
      gxdlvvactcomcodigo_dataG91( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavActcomcodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavActcomcodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavActcomcodigo.getItemCount() > 0 )
      {
         AV29ActComCodigo = dynavActcomcodigo.getValidValue(AV29ActComCodigo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29ActComCodigo", AV29ActComCodigo);
      }
   }

   protected void gxdlvvactcomcodigo_dataG91( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00G92 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00G92_A903ActComCodigo[0]));
         gxdynajaxctrldescr.add(H00G92_A904ActComDescripcion[0]);
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
         dynavActcomcodigo.setName( "vACTCOMCODIGO" );
         dynavActcomcodigo.setWebtags( "" );
         dynavActcomcodigo.removeAllItems();
         /* Using cursor H00G93 */
         pr_default.execute(1);
         while ( (pr_default.getStatus(1) != 101) )
         {
            dynavActcomcodigo.addItem(H00G93_A903ActComCodigo[0], H00G93_A904ActComDescripcion[0], (short)(0));
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( dynavActcomcodigo.getItemCount() > 0 )
         {
            AV29ActComCodigo = dynavActcomcodigo.getValidValue(AV29ActComCodigo) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29ActComCodigo", AV29ActComCodigo);
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavMultiempresa.getItemCount() > 0 )
      {
         AV12MultiEmpresa = cmbavMultiempresa.getValidValue(AV12MultiEmpresa) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12MultiEmpresa", AV12MultiEmpresa);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavMultiempresa.setValue( GXutil.rtrim( AV12MultiEmpresa) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMultiempresa.getInternalname(), "Values", cmbavMultiempresa.ToJavascriptSource(), true);
      }
      if ( dynavActcomcodigo.getItemCount() > 0 )
      {
         AV29ActComCodigo = dynavActcomcodigo.getValidValue(AV29ActComCodigo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29ActComCodigo", AV29ActComCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavActcomcodigo.setValue( GXutil.rtrim( AV29ActComCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, dynavActcomcodigo.getInternalname(), "Values", dynavActcomcodigo.ToJavascriptSource(), true);
      }
      AV33nucleoEs = GXutil.strtobool( GXutil.booltostr( AV33nucleoEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33nucleoEs", AV33nucleoEs);
      AV34conveniadorEs = GXutil.strtobool( GXutil.booltostr( AV34conveniadorEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34conveniadorEs", AV34conveniadorEs);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfG92( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV49Pgmname = "RegistroNucleo" ;
      Gx_err = (short)(0) ;
   }

   public void rfG92( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e13G92 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e16G92 ();
         wbG90( ) ;
      }
   }

   public void send_integrity_lvl_hashesG92( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV49Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV49Pgmname, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vHAY", AV26hay);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHAY", getSecureSignedToken( "", AV26hay));
      web.GxWebStd.gx_hidden_field( httpContext, "vSECUSEREMPNOM", AV24SecUserEmpNom);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSEREMPNOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV24SecUserEmpNom, "@!"))));
   }

   public void before_start_formulas( )
   {
      AV49Pgmname = "RegistroNucleo" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupG90( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12G92 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSECUSER"), AV7SecUser);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSECPAICOD"), AV25SecPaiCod);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Secuser"), AV7SecUser);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Secpaicod"), AV25SecPaiCod);
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
         Dvpanel_panelemp1_Width = httpContext.cgiGet( "DVPANEL_PANELEMP1_Width") ;
         Dvpanel_panelemp1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEMP1_Autowidth")) ;
         Dvpanel_panelemp1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEMP1_Autoheight")) ;
         Dvpanel_panelemp1_Cls = httpContext.cgiGet( "DVPANEL_PANELEMP1_Cls") ;
         Dvpanel_panelemp1_Title = httpContext.cgiGet( "DVPANEL_PANELEMP1_Title") ;
         Dvpanel_panelemp1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEMP1_Collapsible")) ;
         Dvpanel_panelemp1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEMP1_Collapsed")) ;
         Dvpanel_panelemp1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEMP1_Showcollapseicon")) ;
         Dvpanel_panelemp1_Iconposition = httpContext.cgiGet( "DVPANEL_PANELEMP1_Iconposition") ;
         Dvpanel_panelemp1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEMP1_Autoscroll")) ;
         /* Read variables values. */
         AV7SecUser.setgxTv_SdtSecUser_Secuserpername( httpContext.cgiGet( edtavSecuser_secuserpername_Internalname) );
         AV7SecUser.setgxTv_SdtSecUser_Secuserperlastname( httpContext.cgiGet( edtavSecuser_secuserperlastname_Internalname) );
         AV7SecUser.setgxTv_SdtSecUser_Secusername( httpContext.cgiGet( edtavSecuser_secusername_Internalname) );
         AV7SecUser.setgxTv_SdtSecUser_Secuserpassword( httpContext.cgiGet( edtavSecuser_secuserpassword_Internalname) );
         AV11SecUserPassword = httpContext.cgiGet( edtavSecuserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11SecUserPassword", AV11SecUserPassword);
         cmbavMultiempresa.setValue( httpContext.cgiGet( cmbavMultiempresa.getInternalname()) );
         AV12MultiEmpresa = httpContext.cgiGet( cmbavMultiempresa.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12MultiEmpresa", AV12MultiEmpresa);
         AV7SecUser.setgxTv_SdtSecUser_Secuserempnom( GXutil.upper( httpContext.cgiGet( edtavSecuser_secuserempnom_Internalname)) );
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuserempcuit_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuserempcuit_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSECUSEREMPCUIT");
            GX_FocusControl = edtavSecuserempcuit_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV8SecUserEmpCuit = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8SecUserEmpCuit", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SecUserEmpCuit), 11, 0));
         }
         else
         {
            AV8SecUserEmpCuit = localUtil.ctol( httpContext.cgiGet( edtavSecuserempcuit_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8SecUserEmpCuit", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SecUserEmpCuit), 11, 0));
         }
         dynavActcomcodigo.setValue( httpContext.cgiGet( dynavActcomcodigo.getInternalname()) );
         AV29ActComCodigo = httpContext.cgiGet( dynavActcomcodigo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29ActComCodigo", AV29ActComCodigo);
         AV33nucleoEs = GXutil.strtobool( httpContext.cgiGet( chkavNucleoes.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33nucleoEs", AV33nucleoEs);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavPaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavPaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPAICOD");
            GX_FocusControl = edtavPaicod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV35PaiCod = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35PaiCod), 4, 0));
         }
         else
         {
            AV35PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavPaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35PaiCod), 4, 0));
         }
         AV34conveniadorEs = GXutil.strtobool( httpContext.cgiGet( chkavConveniadores.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34conveniadorEs", AV34conveniadorEs);
         AV10ActCodigo = httpContext.cgiGet( edtavActcodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10ActCodigo", AV10ActCodigo);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuser_secuserid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuser_secuserid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SECUSER_SECUSERID");
            GX_FocusControl = edtavSecuser_secuserid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7SecUser.setgxTv_SdtSecUser_Secuserid( (short)(0) );
         }
         else
         {
            AV7SecUser.setgxTv_SdtSecUser_Secuserid( (short)(localUtil.ctol( httpContext.cgiGet( edtavSecuser_secuserid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecpaicod_secuserpaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecpaicod_secuserpaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SECPAICOD_SECUSERPAICOD");
            GX_FocusControl = edtavSecpaicod_secuserpaicod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV25SecPaiCod.setgxTv_SdtSecUser_Secuserpaicod( (short)(0) );
         }
         else
         {
            AV25SecPaiCod.setgxTv_SdtSecUser_Secuserpaicod( (short)(localUtil.ctol( httpContext.cgiGet( edtavSecpaicod_secuserpaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
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
      e12G92 ();
      if (returnInSub) return;
   }

   public void e12G92( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_char1 = AV29ActComCodigo ;
      GXv_char2[0] = GXt_char1 ;
      new web.actcomconstruccion(remoteHandle, context).execute( GXv_char2) ;
      registronucleo_impl.this.GXt_char1 = GXv_char2[0] ;
      AV29ActComCodigo = GXt_char1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29ActComCodigo", AV29ActComCodigo);
      GXv_boolean3[0] = AV26hay ;
      new web.hayalguncliente(remoteHandle, context).execute( GXv_boolean3) ;
      registronucleo_impl.this.AV26hay = GXv_boolean3[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26hay", AV26hay);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHAY", getSecureSignedToken( "", AV26hay));
      if ( ! AV26hay )
      {
         AV7SecUser.setgxTv_SdtSecUser_Secusername( httpContext.getMessage( "argentina@a3l.com.ar", "") );
      }
      else
      {
         GXv_int4[0] = AV31CliCUIT ;
         GXv_date5[0] = AV32Date ;
         GXv_boolean3[0] = false ;
         GXv_char2[0] = "" ;
         new web.getdatoscliente(remoteHandle, context).execute( 3, GXv_int4, GXv_date5, GXv_boolean3, GXv_char2) ;
         registronucleo_impl.this.AV31CliCUIT = GXv_int4[0] ;
         registronucleo_impl.this.AV32Date = GXv_date5[0] ;
         if ( (0==AV31CliCUIT) )
         {
            AV7SecUser.setgxTv_SdtSecUser_Secusername( httpContext.getMessage( "convenios.argentina@a3l.com.ar", "") );
         }
         else
         {
            AV7SecUser.setgxTv_SdtSecUser_Secusername( httpContext.getMessage( "adrian.garcia@a3l.com", "") );
         }
         AV12MultiEmpresa = "2" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12MultiEmpresa", AV12MultiEmpresa);
      }
      AV10ActCodigo = "49" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10ActCodigo", AV10ActCodigo);
      new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, "1") ;
      if ( (GXutil.strcmp("", new web.getactcomdescrip(remoteHandle, context).executeUdp( new web.actcomconstruccion(remoteHandle, context).executeUdp( )))==0) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, "2") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, "3") ;
         new web.inicializardatos_sin_cliente(remoteHandle, context).execute( (short)(0)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, "4") ;
      }
      GXv_int4[0] = AV31CliCUIT ;
      GXv_date5[0] = AV32Date ;
      GXv_boolean3[0] = false ;
      GXv_char2[0] = "" ;
      new web.getdatoscliente(remoteHandle, context).execute( 2, GXv_int4, GXv_date5, GXv_boolean3, GXv_char2) ;
      registronucleo_impl.this.AV31CliCUIT = GXv_int4[0] ;
      registronucleo_impl.this.AV32Date = GXv_date5[0] ;
      if ( (0==AV31CliCUIT) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         if ( ! AV26hay )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV7SecUser.setgxTv_SdtSecUser_Secuserempnom( httpContext.getMessage( "NUCLEO", "") );
         }
         else
         {
            AV7SecUser.setgxTv_SdtSecUser_Secuserempnom( httpContext.getMessage( "A3L - Software factory S.A.", "") );
         }
         AV7SecUser.setgxTv_SdtSecUser_Secuserpassword( httpContext.getMessage( "asdf", "") );
         AV11SecUserPassword = httpContext.getMessage( "asdf", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11SecUserPassword", AV11SecUserPassword);
         AV7SecUser.setgxTv_SdtSecUser_Secuserperlastname( httpContext.getMessage( "Apellido", "") );
         AV7SecUser.setgxTv_SdtSecUser_Secuserpername( httpContext.getMessage( "Nombre", "") );
         if ( ! AV26hay )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV8SecUserEmpCuit = 12345678910L ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8SecUserEmpCuit", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SecUserEmpCuit), 11, 0));
         }
         else
         {
            AV8SecUserEmpCuit = 20309828950L ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8SecUserEmpCuit", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SecUserEmpCuit), 11, 0));
         }
      }
      else
      {
         GXv_int4[0] = AV31CliCUIT ;
         GXv_date5[0] = AV32Date ;
         GXv_boolean3[0] = false ;
         GXv_char2[0] = "" ;
         new web.getdatoscliente(remoteHandle, context).execute( 3, GXv_int4, GXv_date5, GXv_boolean3, GXv_char2) ;
         registronucleo_impl.this.AV31CliCUIT = GXv_int4[0] ;
         registronucleo_impl.this.AV32Date = GXv_date5[0] ;
         if ( (0==AV31CliCUIT) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV7SecUser.setgxTv_SdtSecUser_Secuserempnom( httpContext.getMessage( "aguigar@gmail.com", "") );
            AV7SecUser.setgxTv_SdtSecUser_Secuserpassword( httpContext.getMessage( "asdf", "") );
            AV11SecUserPassword = httpContext.getMessage( "asdf", "") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11SecUserPassword", AV11SecUserPassword);
            AV7SecUser.setgxTv_SdtSecUser_Secuserperlastname( httpContext.getMessage( "aguigar@gmail.com", "") );
            AV7SecUser.setgxTv_SdtSecUser_Secuserpername( httpContext.getMessage( "aguigar@gmail.com", "") );
            AV8SecUserEmpCuit = 12345478910L ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8SecUserEmpCuit", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SecUserEmpCuit), 11, 0));
         }
      }
      AV7SecUser.setgxTv_SdtSecUser_Secuserpaicod_SetNull();
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      AV18LoadSuccess = true ;
      if ( ( ( GXutil.strcmp(AV17TrnMode, "DSP") == 0 ) ) || ( ( GXutil.strcmp(AV17TrnMode, "INS") == 0 ) ) || ( ( GXutil.strcmp(AV17TrnMode, "UPD") == 0 ) ) || ( ( GXutil.strcmp(AV17TrnMode, "DLT") == 0 ) ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         if ( GXutil.strcmp(AV17TrnMode, "INS") != 0 )
         {
            AV7SecUser.Load(AV21SecUserId);
            AV18LoadSuccess = AV7SecUser.Success() ;
            if ( ! AV18LoadSuccess )
            {
               AV16Messages = AV7SecUser.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
            if ( ( GXutil.strcmp(AV17TrnMode, "DSP") == 0 ) || ( GXutil.strcmp(AV17TrnMode, "DLT") == 0 ) )
            {
               edtavSecuser_secuserempnom_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavSecuser_secuserempnom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuser_secuserempnom_Enabled), 5, 0), true);
               edtavSecuserempcuit_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavSecuserempcuit_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuserempcuit_Enabled), 5, 0), true);
               dynavActcomcodigo.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, dynavActcomcodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynavActcomcodigo.getEnabled(), 5, 0), true);
               edtavSecuser_secuserpername_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavSecuser_secuserpername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuser_secuserpername_Enabled), 5, 0), true);
               edtavSecuser_secuserperlastname_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavSecuser_secuserperlastname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuser_secuserperlastname_Enabled), 5, 0), true);
               edtavSecuser_secusername_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavSecuser_secusername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuser_secusername_Enabled), 5, 0), true);
               edtavSecuser_secuserpassword_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavSecuser_secuserpassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuser_secuserpassword_Enabled), 5, 0), true);
               edtavSecuserpassword_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavSecuserpassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuserpassword_Enabled), 5, 0), true);
               cmbavMultiempresa.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavMultiempresa.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavMultiempresa.getEnabled(), 5, 0), true);
            }
         }
      }
      else
      {
         AV18LoadSuccess = false ;
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      if ( AV18LoadSuccess )
      {
         if ( GXutil.strcmp(AV17TrnMode, "DLT") == 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "GXM_confdelete", ""));
         }
      }
      edtavActcodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavActcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavActcodigo_Visible), 5, 0), true);
      edtavSecuser_secuserid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecuser_secuserid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuser_secuserid_Visible), 5, 0), true);
      edtavSecpaicod_secuserpaicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecpaicod_secuserpaicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecpaicod_secuserpaicod_Visible), 5, 0), true);
   }

   public void e13G92( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e14G92( )
   {
      /* 'DoVolver' Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e15G92 ();
      if (returnInSub) return;
   }

   public void e15G92( )
   {
      /* Enter Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "enter 1", "")) ;
      GXv_boolean3[0] = AV28hayTipoEmpl ;
      new web.haytipodeempleador(remoteHandle, context).execute( GXv_boolean3) ;
      registronucleo_impl.this.AV28hayTipoEmpl = GXv_boolean3[0] ;
      if ( AV28hayTipoEmpl )
      {
         AV27terminoInicializacion = httpContext.getMessage( "S", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27terminoInicializacion", AV27terminoInicializacion);
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "enter 2", "")) ;
      if ( GXutil.strcmp(AV27terminoInicializacion, httpContext.getMessage( "S", "")) != 0 )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "<#CLEAR#>", ""));
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "enter 3", "")) ;
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "Se están inicializando los datos para el nuevo usuario, por favor aguarde unos instantes e intente nuevamente", "")) ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "enter 4", "")) ;
         AV7SecUser.setgxTv_SdtSecUser_Clicod_SetNull();
         AV7SecUser.setgxTv_SdtSecUser_Rolid_SetNull();
         AV7SecUser.setgxTv_SdtSecUser_Perfilid_SetNull();
         AV7SecUser.setgxTv_SdtSecUser_Menuverid_SetNull();
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "enter 5", "")) ;
         if ( GXutil.strcmp(AV17TrnMode, "DSP") != 0 )
         {
            if ( GXutil.strcmp(AV17TrnMode, "DLT") != 0 )
            {
               /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
               S132 ();
               if (returnInSub) return;
            }
            if ( ( GXutil.strcmp(AV17TrnMode, "DLT") == 0 ) || AV19CheckRequiredFieldsResult )
            {
               if ( GXutil.strcmp(AV17TrnMode, "DLT") == 0 )
               {
                  AV7SecUser.Delete();
               }
               else
               {
                  AV7SecUser.Save();
               }
               if ( AV7SecUser.Success() )
               {
                  /* Execute user subroutine: 'AFTER_TRN' */
                  S142 ();
                  if (returnInSub) return;
               }
               else
               {
                  AV16Messages = AV7SecUser.GetMessages() ;
                  /* Execute user subroutine: 'SHOW MESSAGES' */
                  S112 ();
                  if (returnInSub) return;
               }
            }
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "enter 6", "")) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV7SecUser", AV7SecUser);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV16Messages", AV16Messages);
   }

   public void S122( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(AV17TrnMode, "DSP") != 0 ) ) )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'SHOW MESSAGES' Routine */
      returnInSub = false ;
      AV50GXV8 = 1 ;
      while ( AV50GXV8 <= AV16Messages.size() )
      {
         AV15Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV16Messages.elementAt(-1+AV50GXV8));
         httpContext.GX_msglist.addItem(AV15Message.getgxTv_SdtMessages_Message_Description());
         AV50GXV8 = (int)(AV50GXV8+1) ;
      }
   }

   public void S142( )
   {
      /* 'AFTER_TRN' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "after trn 1", "")) ;
      if ( true )
      {
         if ( GXutil.strcmp(AV17TrnMode, httpContext.getMessage( "INS", "")) == 0 )
         {
            GXv_char2[0] = AV38hash ;
            GXv_char6[0] = AV39salt ;
            new web.createhashforpsw(remoteHandle, context).execute( AV7SecUser.getgxTv_SdtSecUser_Secuserpassword(), "", GXv_char2, GXv_char6) ;
            registronucleo_impl.this.AV38hash = GXv_char2[0] ;
            registronucleo_impl.this.AV39salt = GXv_char6[0] ;
            AV7SecUser.setgxTv_SdtSecUser_Secuserpassword( AV38hash );
            AV7SecUser.setgxTv_SdtSecUser_Secusersal( AV39salt );
         }
         Application.commitDataStores(context, remoteHandle, pr_default, "registronucleo");
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "after trn 2", "")) ;
         if ( GXutil.strcmp(AV12MultiEmpresa, "2") == 0 )
         {
            AV23multi = true ;
         }
         else
         {
            AV23multi = false ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "after trn 3", "")) ;
         if ( ( GXutil.strcmp(AV7SecUser.getgxTv_SdtSecUser_Secuserempnom(), httpContext.getMessage( "NUCLEO", "")) == 0 ) && ! AV26hay )
         {
            AV7SecUser.setgxTv_SdtSecUser_Secuserempnom( AV7SecUser.getgxTv_SdtSecUser_Secuserempnom()+httpContext.getMessage( " ARGENTINA", "") );
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "after trn 4", "")) ;
         if ( ! (0==AV35PaiCod) && ( AV33nucleoEs ) && ! AV34conveniadorEs )
         {
            new web.inicializardatos_sin_cliente(remoteHandle, context).execute( AV35PaiCod) ;
         }
         new web.inicializardatos(remoteHandle, context).execute( AV7SecUser.getgxTv_SdtSecUser_Secuserid(), AV7SecUser.getgxTv_SdtSecUser_Secuserempnom(), AV8SecUserEmpCuit, AV24SecUserEmpNom, AV8SecUserEmpCuit, AV23multi, AV7SecUser.getgxTv_SdtSecUser_Secusertipempl(), AV10ActCodigo, AV22httpRequest.getBaseURL(), AV35PaiCod, AV33nucleoEs, AV29ActComCodigo, AV34conveniadorEs) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "after trn 5", "")) ;
         AV51Sleep = DecimalUtil.doubleToDec(GXutil.sleep( 2)) ;
         callWebObject(formatLink("web.nuevousuario", new String[] {GXutil.URLEncode(GXutil.rtrim(AV7SecUser.getgxTv_SdtSecUser_Secusername()))}, new String[] {"SecUserName"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "registronucleo");
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void S132( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV19CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19CheckRequiredFieldsResult", AV19CheckRequiredFieldsResult);
      if ( (GXutil.strcmp("", AV29ActComCodigo)==0) )
      {
         AV19CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19CheckRequiredFieldsResult", AV19CheckRequiredFieldsResult);
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Debe seleccionar actividad económica", "")) ;
      }
      /* Using cursor H00G94 */
      pr_default.execute(2);
      while ( (pr_default.getStatus(2) != 101) )
      {
         A747ClienteSistema = H00G94_A747ClienteSistema[0] ;
         AV36clienteNucleoExiste = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(2);
      }
      pr_default.close(2);
      if ( ( AV36clienteNucleoExiste ) && (0==AV35PaiCod) )
      {
         AV19CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19CheckRequiredFieldsResult", AV19CheckRequiredFieldsResult);
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Debe ingresar pais", "")) ;
      }
      if ( AV33nucleoEs )
      {
         /* Using cursor H00G95 */
         pr_default.execute(3, new Object[] {Short.valueOf(AV35PaiCod)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A4CliPaiCod = H00G95_A4CliPaiCod[0] ;
            n4CliPaiCod = H00G95_n4CliPaiCod[0] ;
            A747ClienteSistema = H00G95_A747ClienteSistema[0] ;
            AV19CheckRequiredFieldsResult = false ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19CheckRequiredFieldsResult", AV19CheckRequiredFieldsResult);
            new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Ya existe un cliente nucleo de pais", "")) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(3);
         }
         pr_default.close(3);
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e16G92( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV17TrnMode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17TrnMode", AV17TrnMode);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17TrnMode, ""))));
      AV21SecUserId = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21SecUserId), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21SecUserId), "ZZZ9")));
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
      paG92( ) ;
      wsG92( ) ;
      weG92( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020382089", true, true);
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
      httpContext.AddJavascriptSource("registronucleo.js", "?2024122020382089", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      imgVolver_Internalname = "VOLVER" ;
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      divTableactions_Internalname = "TABLEACTIONS" ;
      divTableheadercontent_Internalname = "TABLEHEADERCONTENT" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavSecuser_secuserpername_Internalname = "SECUSER_SECUSERPERNAME" ;
      edtavSecuser_secuserperlastname_Internalname = "SECUSER_SECUSERPERLASTNAME" ;
      edtavSecuser_secusername_Internalname = "SECUSER_SECUSERNAME" ;
      edtavSecuser_secuserpassword_Internalname = "SECUSER_SECUSERPASSWORD" ;
      edtavSecuserpassword_Internalname = "vSECUSERPASSWORD" ;
      cmbavMultiempresa.setInternalname( "vMULTIEMPRESA" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      edtavSecuser_secuserempnom_Internalname = "SECUSER_SECUSEREMPNOM" ;
      edtavSecuserempcuit_Internalname = "vSECUSEREMPCUIT" ;
      dynavActcomcodigo.setInternalname( "vACTCOMCODIGO" );
      chkavNucleoes.setInternalname( "vNUCLEOES" );
      edtavPaicod_Internalname = "vPAICOD" ;
      chkavConveniadores.setInternalname( "vCONVENIADORES" );
      divPanelemp1_Internalname = "PANELEMP1" ;
      Dvpanel_panelemp1_Internalname = "DVPANEL_PANELEMP1" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      bttBtntest_Internalname = "BTNTEST" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavActcodigo_Internalname = "vACTCODIGO" ;
      edtavSecuser_secuserid_Internalname = "SECUSER_SECUSERID" ;
      edtavSecpaicod_secuserpaicod_Internalname = "SECPAICOD_SECUSERPAICOD" ;
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
      edtavSecuser_secuserpassword_Enabled = 1 ;
      edtavSecuser_secusername_Enabled = 1 ;
      edtavSecuser_secuserperlastname_Enabled = 1 ;
      edtavSecuser_secuserpername_Enabled = 1 ;
      edtavSecuser_secuserempnom_Enabled = 1 ;
      edtavSecpaicod_secuserpaicod_Jsonclick = "" ;
      edtavSecpaicod_secuserpaicod_Visible = 1 ;
      edtavSecuser_secuserid_Jsonclick = "" ;
      edtavSecuser_secuserid_Visible = 1 ;
      edtavActcodigo_Jsonclick = "" ;
      edtavActcodigo_Visible = 1 ;
      bttBtnenter_Visible = 1 ;
      chkavConveniadores.setEnabled( 1 );
      edtavPaicod_Jsonclick = "" ;
      edtavPaicod_Enabled = 1 ;
      chkavNucleoes.setEnabled( 1 );
      dynavActcomcodigo.setJsonclick( "" );
      dynavActcomcodigo.setEnabled( 1 );
      edtavSecuserempcuit_Jsonclick = "" ;
      edtavSecuserempcuit_Enabled = 1 ;
      edtavSecuser_secuserempnom_Jsonclick = "" ;
      edtavSecuser_secuserempnom_Enabled = 1 ;
      cmbavMultiempresa.setJsonclick( "" );
      cmbavMultiempresa.setEnabled( 1 );
      edtavSecuserpassword_Enabled = 1 ;
      edtavSecuser_secuserpassword_Enabled = 1 ;
      edtavSecuser_secusername_Jsonclick = "" ;
      edtavSecuser_secusername_Enabled = 1 ;
      edtavSecuser_secuserperlastname_Jsonclick = "" ;
      edtavSecuser_secuserperlastname_Enabled = 1 ;
      edtavSecuser_secuserpername_Jsonclick = "" ;
      edtavSecuser_secuserpername_Enabled = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Dvpanel_panelemp1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelemp1_Iconposition = "Right" ;
      Dvpanel_panelemp1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelemp1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelemp1_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_panelemp1_Title = httpContext.getMessage( "Empresa Principal", "") ;
      Dvpanel_panelemp1_Cls = "DVBootstrapResponsivePanel" ;
      Dvpanel_panelemp1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelemp1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelemp1_Width = "100%" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "DVBootstrapResponsivePanel" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Registro núcleo", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavMultiempresa.setName( "vMULTIEMPRESA" );
      cmbavMultiempresa.setWebtags( "" );
      cmbavMultiempresa.addItem("1", httpContext.getMessage( "Administrar una sola Empresa / Empleador", ""), (short)(0));
      cmbavMultiempresa.addItem("2", httpContext.getMessage( "Multi-Empresa", ""), (short)(0));
      if ( cmbavMultiempresa.getItemCount() > 0 )
      {
         AV12MultiEmpresa = cmbavMultiempresa.getValidValue(AV12MultiEmpresa) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12MultiEmpresa", AV12MultiEmpresa);
      }
      dynavActcomcodigo.setName( "vACTCOMCODIGO" );
      dynavActcomcodigo.setWebtags( "" );
      dynavActcomcodigo.removeAllItems();
      /* Using cursor H00G96 */
      pr_default.execute(4);
      while ( (pr_default.getStatus(4) != 101) )
      {
         dynavActcomcodigo.addItem(H00G96_A903ActComCodigo[0], H00G96_A904ActComDescripcion[0], (short)(0));
         pr_default.readNext(4);
      }
      pr_default.close(4);
      if ( dynavActcomcodigo.getItemCount() > 0 )
      {
         AV29ActComCodigo = dynavActcomcodigo.getValidValue(AV29ActComCodigo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29ActComCodigo", AV29ActComCodigo);
      }
      chkavNucleoes.setName( "vNUCLEOES" );
      chkavNucleoes.setWebtags( "" );
      chkavNucleoes.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavNucleoes.getInternalname(), "TitleCaption", chkavNucleoes.getCaption(), true);
      chkavNucleoes.setCheckedValue( "false" );
      AV33nucleoEs = GXutil.strtobool( GXutil.booltostr( AV33nucleoEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33nucleoEs", AV33nucleoEs);
      chkavConveniadores.setName( "vCONVENIADORES" );
      chkavConveniadores.setWebtags( "" );
      chkavConveniadores.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavConveniadores.getInternalname(), "TitleCaption", chkavConveniadores.getCaption(), true);
      chkavConveniadores.setCheckedValue( "false" );
      AV34conveniadorEs = GXutil.strtobool( GXutil.booltostr( AV34conveniadorEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34conveniadorEs", AV34conveniadorEs);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'dynavActcomcodigo'},{av:'AV29ActComCodigo',fld:'vACTCOMCODIGO',pic:''},{av:'AV33nucleoEs',fld:'vNUCLEOES',pic:''},{av:'AV34conveniadorEs',fld:'vCONVENIADORES',pic:''},{av:'AV17TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV49Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV26hay',fld:'vHAY',pic:'',hsh:true},{av:'AV24SecUserEmpNom',fld:'vSECUSEREMPNOM',pic:'@!',hsh:true},{av:'AV21SecUserId',fld:'vSECUSERID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{ctrl:'BTNENTER',prop:'Visible'}]}");
      setEventMetadata("'DOTEST'","{handler:'e11G91',iparms:[]");
      setEventMetadata("'DOTEST'",",oparms:[]}");
      setEventMetadata("'DOVOLVER'","{handler:'e14G92',iparms:[]");
      setEventMetadata("'DOVOLVER'",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e15G92',iparms:[{av:'AV49Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV27terminoInicializacion',fld:'vTERMINOINICIALIZACION',pic:''},{av:'AV7SecUser',fld:'vSECUSER',pic:''},{av:'AV17TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV19CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'dynavActcomcodigo'},{av:'AV29ActComCodigo',fld:'vACTCOMCODIGO',pic:''},{av:'A747ClienteSistema',fld:'CLIENTESISTEMA',pic:''},{av:'AV35PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV33nucleoEs',fld:'vNUCLEOES',pic:''},{av:'A4CliPaiCod',fld:'CLIPAICOD',pic:'ZZZ9'},{av:'cmbavMultiempresa'},{av:'AV12MultiEmpresa',fld:'vMULTIEMPRESA',pic:''},{av:'AV26hay',fld:'vHAY',pic:'',hsh:true},{av:'AV34conveniadorEs',fld:'vCONVENIADORES',pic:''},{av:'AV24SecUserEmpNom',fld:'vSECUSEREMPNOM',pic:'@!',hsh:true},{av:'AV8SecUserEmpCuit',fld:'vSECUSEREMPCUIT',pic:'ZZ-ZZZZZZZZ-9'},{av:'AV10ActCodigo',fld:'vACTCODIGO',pic:''},{av:'AV22httpRequest.getBaseURL()',ctrl:'vHTTPREQUEST',prop:'Baseurl'},{av:'AV16Messages',fld:'vMESSAGES',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV27terminoInicializacion',fld:'vTERMINOINICIALIZACION',pic:''},{av:'AV7SecUser',fld:'vSECUSER',pic:''},{av:'AV16Messages',fld:'vMESSAGES',pic:''},{av:'AV19CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("VALIDV_GXV3","{handler:'validv_Gxv3',iparms:[]");
      setEventMetadata("VALIDV_GXV3",",oparms:[]}");
      setEventMetadata("VALIDV_PAICOD","{handler:'validv_Paicod',iparms:[]");
      setEventMetadata("VALIDV_PAICOD",",oparms:[]}");
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
      wcpOAV17TrnMode = "" ;
      AV22httpRequest = httpContext.getHttpRequest();
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV17TrnMode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV49Pgmname = "" ;
      AV24SecUserEmpNom = "" ;
      GXKey = "" ;
      AV7SecUser = new web.wwpbaseobjects.SdtSecUser(remoteHandle);
      AV25SecPaiCod = new web.wwpbaseobjects.SdtSecUser(remoteHandle);
      AV27terminoInicializacion = "" ;
      AV16Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      ClassString = "" ;
      imgVolver_gximage = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      imgVolver_Jsonclick = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      AV11SecUserPassword = "" ;
      AV12MultiEmpresa = "" ;
      ucDvpanel_panelemp1 = new com.genexus.webpanels.GXUserControl();
      AV29ActComCodigo = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      bttBtntest_Jsonclick = "" ;
      AV10ActCodigo = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H00G92_A903ActComCodigo = new String[] {""} ;
      H00G92_A904ActComDescripcion = new String[] {""} ;
      H00G93_A903ActComCodigo = new String[] {""} ;
      H00G93_A904ActComDescripcion = new String[] {""} ;
      GXt_char1 = "" ;
      AV32Date = GXutil.nullDate() ;
      GXv_int4 = new long[1] ;
      GXv_date5 = new java.util.Date[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV15Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV38hash = "" ;
      GXv_char2 = new String[1] ;
      AV39salt = "" ;
      GXv_char6 = new String[1] ;
      AV51Sleep = DecimalUtil.ZERO ;
      H00G94_A3CliCod = new int[1] ;
      H00G94_A747ClienteSistema = new boolean[] {false} ;
      H00G95_A3CliCod = new int[1] ;
      H00G95_A4CliPaiCod = new short[1] ;
      H00G95_n4CliPaiCod = new boolean[] {false} ;
      H00G95_A747ClienteSistema = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      H00G96_A903ActComCodigo = new String[] {""} ;
      H00G96_A904ActComDescripcion = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.registronucleo__default(),
         new Object[] {
             new Object[] {
            H00G92_A903ActComCodigo, H00G92_A904ActComDescripcion
            }
            , new Object[] {
            H00G93_A903ActComCodigo, H00G93_A904ActComDescripcion
            }
            , new Object[] {
            H00G94_A3CliCod, H00G94_A747ClienteSistema
            }
            , new Object[] {
            H00G95_A3CliCod, H00G95_A4CliPaiCod, H00G95_n4CliPaiCod, H00G95_A747ClienteSistema
            }
            , new Object[] {
            H00G96_A903ActComCodigo, H00G96_A904ActComDescripcion
            }
         }
      );
      AV49Pgmname = "RegistroNucleo" ;
      /* GeneXus formulas. */
      AV49Pgmname = "RegistroNucleo" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOAV21SecUserId ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV21SecUserId ;
   private short A4CliPaiCod ;
   private short wbEnd ;
   private short wbStart ;
   private short AV35PaiCod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavSecuser_secuserpername_Enabled ;
   private int edtavSecuser_secuserperlastname_Enabled ;
   private int edtavSecuser_secusername_Enabled ;
   private int edtavSecuser_secuserpassword_Enabled ;
   private int edtavSecuserpassword_Enabled ;
   private int edtavSecuser_secuserempnom_Enabled ;
   private int edtavSecuserempcuit_Enabled ;
   private int edtavPaicod_Enabled ;
   private int bttBtnenter_Visible ;
   private int edtavActcodigo_Visible ;
   private int edtavSecuser_secuserid_Visible ;
   private int edtavSecpaicod_secuserpaicod_Visible ;
   private int gxdynajaxindex ;
   private int AV50GXV8 ;
   private int idxLst ;
   private long AV8SecUserEmpCuit ;
   private long AV31CliCUIT ;
   private long GXv_int4[] ;
   private java.math.BigDecimal AV51Sleep ;
   private String wcpOAV17TrnMode ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV17TrnMode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV49Pgmname ;
   private String GXKey ;
   private String AV27terminoInicializacion ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_panelemp1_Width ;
   private String Dvpanel_panelemp1_Cls ;
   private String Dvpanel_panelemp1_Title ;
   private String Dvpanel_panelemp1_Iconposition ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divTableheader_Internalname ;
   private String divTableheadercontent_Internalname ;
   private String divTableactions_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String imgVolver_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgVolver_Internalname ;
   private String imgVolver_Jsonclick ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Jsonclick ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtavSecuser_secuserpername_Internalname ;
   private String edtavSecuser_secuserpername_Jsonclick ;
   private String edtavSecuser_secuserperlastname_Internalname ;
   private String edtavSecuser_secuserperlastname_Jsonclick ;
   private String edtavSecuser_secusername_Internalname ;
   private String edtavSecuser_secusername_Jsonclick ;
   private String edtavSecuser_secuserpassword_Internalname ;
   private String edtavSecuserpassword_Internalname ;
   private String AV12MultiEmpresa ;
   private String Dvpanel_panelemp1_Internalname ;
   private String divPanelemp1_Internalname ;
   private String edtavSecuser_secuserempnom_Internalname ;
   private String edtavSecuser_secuserempnom_Jsonclick ;
   private String edtavSecuserempcuit_Internalname ;
   private String edtavSecuserempcuit_Jsonclick ;
   private String AV29ActComCodigo ;
   private String edtavPaicod_Internalname ;
   private String edtavPaicod_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String bttBtntest_Internalname ;
   private String bttBtntest_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavActcodigo_Internalname ;
   private String AV10ActCodigo ;
   private String edtavActcodigo_Jsonclick ;
   private String edtavSecuser_secuserid_Internalname ;
   private String edtavSecuser_secuserid_Jsonclick ;
   private String edtavSecpaicod_secuserpaicod_Internalname ;
   private String edtavSecpaicod_secuserpaicod_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String GXv_char6[] ;
   private java.util.Date AV32Date ;
   private java.util.Date GXv_date5[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV26hay ;
   private boolean AV19CheckRequiredFieldsResult ;
   private boolean A747ClienteSistema ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_panelemp1_Autowidth ;
   private boolean Dvpanel_panelemp1_Autoheight ;
   private boolean Dvpanel_panelemp1_Collapsible ;
   private boolean Dvpanel_panelemp1_Collapsed ;
   private boolean Dvpanel_panelemp1_Showcollapseicon ;
   private boolean Dvpanel_panelemp1_Autoscroll ;
   private boolean wbLoad ;
   private boolean AV33nucleoEs ;
   private boolean AV34conveniadorEs ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private boolean AV18LoadSuccess ;
   private boolean AV28hayTipoEmpl ;
   private boolean GXv_boolean3[] ;
   private boolean AV23multi ;
   private boolean AV36clienteNucleoExiste ;
   private boolean n4CliPaiCod ;
   private String AV24SecUserEmpNom ;
   private String AV11SecUserPassword ;
   private String AV38hash ;
   private String AV39salt ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV22httpRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelemp1 ;
   private HTMLChoice cmbavMultiempresa ;
   private HTMLChoice dynavActcomcodigo ;
   private ICheckbox chkavNucleoes ;
   private ICheckbox chkavConveniadores ;
   private IDataStoreProvider pr_default ;
   private String[] H00G92_A903ActComCodigo ;
   private String[] H00G92_A904ActComDescripcion ;
   private String[] H00G93_A903ActComCodigo ;
   private String[] H00G93_A904ActComDescripcion ;
   private int[] H00G94_A3CliCod ;
   private boolean[] H00G94_A747ClienteSistema ;
   private int[] H00G95_A3CliCod ;
   private short[] H00G95_A4CliPaiCod ;
   private boolean[] H00G95_n4CliPaiCod ;
   private boolean[] H00G95_A747ClienteSistema ;
   private String[] H00G96_A903ActComCodigo ;
   private String[] H00G96_A904ActComDescripcion ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV16Messages ;
   private com.genexus.SdtMessages_Message AV15Message ;
   private web.wwpbaseobjects.SdtSecUser AV7SecUser ;
   private web.wwpbaseobjects.SdtSecUser AV25SecPaiCod ;
}

final  class registronucleo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00G92", "SELECT ActComCodigo, ActComDescripcion FROM actividadcomercial ORDER BY ActComDescripcion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00G93", "SELECT ActComCodigo, ActComDescripcion FROM actividadcomercial ORDER BY ActComDescripcion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00G94", "SELECT CliCod, ClienteSistema FROM Cliente WHERE ClienteSistema = TRUE ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00G95", "SELECT CliCod, CliPaiCod, ClienteSistema FROM Cliente WHERE (CliPaiCod = ?) AND (ClienteSistema = TRUE) ORDER BY CliPaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00G96", "SELECT ActComCodigo, ActComDescripcion FROM actividadcomercial ORDER BY ActComDescripcion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
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
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

