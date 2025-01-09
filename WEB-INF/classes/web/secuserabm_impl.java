package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secuserabm_impl extends GXDataArea
{
   public secuserabm_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secuserabm_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secuserabm_impl.class ));
   }

   public secuserabm_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavSecuser_secusuactivo = UIFactory.getCheckbox(this);
      dynavSecuser_rolid = new HTMLChoice();
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
            AV12TrnMode = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12TrnMode", AV12TrnMode);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12TrnMode, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV15SecUserId = (short)(GXutil.lval( httpContext.GetPar( "SecUserId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15SecUserId), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15SecUserId), "ZZZ9")));
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
      pa2Z2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2Z2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.secuserabm", new String[] {GXutil.URLEncode(GXutil.rtrim(AV12TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV15SecUserId,4,0))}, new String[] {"TrnMode","SecUserId"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15SecUserId), "ZZZ9")));
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
      web.GxWebStd.gx_hidden_field( httpContext, "vTRNMODE", GXutil.rtrim( AV12TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12TrnMode, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCHECKREQUIREDFIELDSRESULT", AV9CheckRequiredFieldsResult);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMESSAGES", AV11Messages);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMESSAGES", AV11Messages);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vSECUSERID", GXutil.ltrim( localUtil.ntoc( AV15SecUserId, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15SecUserId), "ZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECUSER", AV7SecUser);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECUSER", AV7SecUser);
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
         we2Z2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2Z2( ) ;
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
      return formatLink("web.secuserabm", new String[] {GXutil.URLEncode(GXutil.rtrim(AV12TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV15SecUserId,4,0))}, new String[] {"TrnMode","SecUserId"})  ;
   }

   public String getPgmname( )
   {
      return "SecUserABM" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Sec User ABM", "") ;
   }

   public void wb2Z0( )
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
         wb_table1_9_2Z2( true) ;
      }
      else
      {
         wb_table1_9_2Z2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_2Z2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecuser_secuserid_Internalname, GXutil.ltrim( localUtil.ntoc( AV7SecUser.getgxTv_SdtSecUser_Secuserid(), (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7SecUser.getgxTv_SdtSecUser_Secuserid()), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuser_secuserid_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecuser_secuserid_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_SecUserABM.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecuser_clicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV7SecUser.getgxTv_SdtSecUser_Clicod(), (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7SecUser.getgxTv_SdtSecUser_Clicod()), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuser_clicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecuser_clicod_Visible, 1, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_SecUserABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start2Z2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Sec User ABM", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2Z0( ) ;
   }

   public void ws2Z2( )
   {
      start2Z2( ) ;
      evt2Z2( ) ;
   }

   public void evt2Z2( )
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
                           e112Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e122Z2 ();
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
                                 e132Z2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e142Z2 ();
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

   public void we2Z2( )
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

   public void pa2Z2( )
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
            GX_FocusControl = edtavSecuser_secusername_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvsecuser_rolid2Z1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvsecuser_rolid_data2Z1( ) ;
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

   public void gxvsecuser_rolid_html2Z1( )
   {
      byte gxdynajaxvalue;
      gxdlvsecuser_rolid_data2Z1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavSecuser_rolid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (byte)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavSecuser_rolid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 2, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavSecuser_rolid.getItemCount() > 0 )
      {
         AV7SecUser.setgxTv_SdtSecUser_Rolid( (byte)(GXutil.lval( dynavSecuser_rolid.getValidValue(GXutil.trim( GXutil.str( AV7SecUser.getgxTv_SdtSecUser_Rolid(), 2, 0))))) );
      }
   }

   protected void gxdlvsecuser_rolid_data2Z1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H002Z2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H002Z2_A1923RolId[0], (byte)(2), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H002Z2_A1924RolNombre[0]);
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
         dynavSecuser_rolid.setName( "SECUSER_ROLID" );
         dynavSecuser_rolid.setWebtags( "" );
         dynavSecuser_rolid.removeAllItems();
         /* Using cursor H002Z3 */
         pr_default.execute(1);
         while ( (pr_default.getStatus(1) != 101) )
         {
            dynavSecuser_rolid.addItem(GXutil.trim( GXutil.str( H002Z3_A1923RolId[0], 2, 0)), H002Z3_A1924RolNombre[0], (short)(0));
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( dynavSecuser_rolid.getItemCount() > 0 )
         {
            AV7SecUser.setgxTv_SdtSecUser_Rolid( (byte)(GXutil.lval( dynavSecuser_rolid.getValidValue(GXutil.trim( GXutil.str( AV7SecUser.getgxTv_SdtSecUser_Rolid(), 2, 0))))) );
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynavSecuser_rolid.getItemCount() > 0 )
      {
         AV7SecUser.setgxTv_SdtSecUser_Rolid( (byte)(GXutil.lval( dynavSecuser_rolid.getValidValue(GXutil.trim( GXutil.str( AV7SecUser.getgxTv_SdtSecUser_Rolid(), 2, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavSecuser_rolid.setValue( GXutil.trim( GXutil.str( AV7SecUser.getgxTv_SdtSecUser_Rolid(), 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavSecuser_rolid.getInternalname(), "Values", dynavSecuser_rolid.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2Z2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   public void rf2Z2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e122Z2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H002Z4 */
         pr_default.execute(2);
         while ( (pr_default.getStatus(2) != 101) )
         {
            A68SecUserName = H002Z4_A68SecUserName[0] ;
            /* Execute user event: Load */
            e142Z2 ();
            pr_default.readNext(2);
         }
         pr_default.close(2);
         wb2Z0( ) ;
      }
   }

   public void send_integrity_lvl_hashes2Z2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vTRNMODE", GXutil.rtrim( AV12TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12TrnMode, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup2Z0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e112Z2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSECUSER"), AV7SecUser);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Secuser"), AV7SecUser);
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
         AV7SecUser.setgxTv_SdtSecUser_Secusername( httpContext.cgiGet( edtavSecuser_secusername_Internalname) );
         AV7SecUser.setgxTv_SdtSecUser_Secuserpername( httpContext.cgiGet( edtavSecuser_secuserpername_Internalname) );
         AV7SecUser.setgxTv_SdtSecUser_Secuserperlastname( httpContext.cgiGet( edtavSecuser_secuserperlastname_Internalname) );
         AV19password = httpContext.cgiGet( edtavPassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19password", AV19password);
         AV8SecUserPassword = httpContext.cgiGet( edtavSecuserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8SecUserPassword", AV8SecUserPassword);
         AV7SecUser.setgxTv_SdtSecUser_Secusuactivo( GXutil.strtobool( httpContext.cgiGet( chkavSecuser_secusuactivo.getInternalname())) );
         dynavSecuser_rolid.setValue( httpContext.cgiGet( dynavSecuser_rolid.getInternalname()) );
         AV7SecUser.setgxTv_SdtSecUser_Rolid( (byte)(GXutil.lval( httpContext.cgiGet( dynavSecuser_rolid.getInternalname()))) );
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
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuser_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuser_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SECUSER_CLICOD");
            GX_FocusControl = edtavSecuser_clicod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7SecUser.setgxTv_SdtSecUser_Clicod( 0 );
         }
         else
         {
            AV7SecUser.setgxTv_SdtSecUser_Clicod( (int)(localUtil.ctol( httpContext.cgiGet( edtavSecuser_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
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
      e112Z2 ();
      if (returnInSub) return;
   }

   public void e112Z2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      AV13LoadSuccess = true ;
      if ( ( ( GXutil.strcmp(AV12TrnMode, "DSP") == 0 ) ) || ( ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) ) || ( ( GXutil.strcmp(AV12TrnMode, "UPD") == 0 ) ) || ( ( GXutil.strcmp(AV12TrnMode, "DLT") == 0 ) ) )
      {
         if ( GXutil.strcmp(AV12TrnMode, "INS") != 0 )
         {
            AV7SecUser.Load(AV15SecUserId);
            AV13LoadSuccess = AV7SecUser.Success() ;
            if ( ! AV13LoadSuccess )
            {
               AV11Messages = AV7SecUser.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
            if ( ( GXutil.strcmp(AV12TrnMode, "DSP") == 0 ) || ( GXutil.strcmp(AV12TrnMode, "DLT") == 0 ) )
            {
               edtavSecuser_secusername_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavSecuser_secusername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuser_secusername_Enabled), 5, 0), true);
               edtavSecuser_secuserpername_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavSecuser_secuserpername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuser_secuserpername_Enabled), 5, 0), true);
               edtavSecuser_secuserperlastname_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavSecuser_secuserperlastname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuser_secuserperlastname_Enabled), 5, 0), true);
               edtavPassword_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavPassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPassword_Enabled), 5, 0), true);
               edtavSecuserpassword_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavSecuserpassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuserpassword_Enabled), 5, 0), true);
               chkavSecuser_secusuactivo.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavSecuser_secusuactivo.getInternalname(), "Enabled", GXutil.ltrimstr( chkavSecuser_secusuactivo.getEnabled(), 5, 0), true);
               dynavSecuser_rolid.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, dynavSecuser_rolid.getInternalname(), "Enabled", GXutil.ltrimstr( dynavSecuser_rolid.getEnabled(), 5, 0), true);
            }
         }
      }
      else
      {
         AV13LoadSuccess = false ;
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      if ( AV13LoadSuccess )
      {
         if ( GXutil.strcmp(AV12TrnMode, "DLT") == 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "GXM_confdelete", ""));
         }
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if (returnInSub) return;
      edtavSecuser_secuserid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecuser_secuserid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuser_secuserid_Visible), 5, 0), true);
      edtavSecuser_clicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecuser_clicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuser_clicod_Visible), 5, 0), true);
      if ( GXutil.strcmp(AV12TrnMode, "INS") == 0 )
      {
         AV7SecUser.setgxTv_SdtSecUser_Secuserpaicod_SetNull();
         AV7SecUser.setgxTv_SdtSecUser_Secusuactivo( true );
         AV7SecUser.setgxTv_SdtSecUser_Secuserempnom( "-" );
         GXt_int1 = 0 ;
         GXv_int2[0] = GXt_int1 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
         secuserabm_impl.this.GXt_int1 = GXv_int2[0] ;
         AV7SecUser.setgxTv_SdtSecUser_Clicod( GXt_int1 );
         GXv_int3[0] = AV7SecUser.getgxTv_SdtSecUser_Rolid() ;
         GXv_int4[0] = AV7SecUser.getgxTv_SdtSecUser_Perfilid() ;
         GXv_int5[0] = AV7SecUser.getgxTv_SdtSecUser_Menuverid() ;
         new web.getusumenu(remoteHandle, context).execute( new web.getusuloggedid(remoteHandle, context).executeUdp( ), GXv_int3, GXv_int4, GXv_int5) ;
         AV7SecUser.setgxTv_SdtSecUser_Rolid( GXv_int3[0] );
         AV7SecUser.setgxTv_SdtSecUser_Perfilid( GXv_int4[0] );
         AV7SecUser.setgxTv_SdtSecUser_Menuverid( GXv_int5[0] );
      }
      GXv_int4[0] = AV16miRolId ;
      new web.getrolusu(remoteHandle, context).execute( new web.getusuloggedid(remoteHandle, context).executeUdp( ), GXv_int4) ;
      secuserabm_impl.this.AV16miRolId = GXv_int4[0] ;
      if ( AV16miRolId > 1 )
      {
         dynavSecuser_rolid.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynavSecuser_rolid.getInternalname(), "Enabled", GXutil.ltrimstr( dynavSecuser_rolid.getEnabled(), 5, 0), true);
         dynavSecuser_rolid.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynavSecuser_rolid.getInternalname(), "Visible", GXutil.ltrimstr( dynavSecuser_rolid.getVisible(), 5, 0), true);
      }
   }

   public void e122Z2( )
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
      e132Z2 ();
      if (returnInSub) return;
   }

   public void e132Z2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", "")) == 0 )
      {
         GXv_char6[0] = AV17hash ;
         GXv_char7[0] = AV18salt ;
         new web.createhashforpsw(remoteHandle, context).execute( AV19password, "", GXv_char6, GXv_char7) ;
         secuserabm_impl.this.AV17hash = GXv_char6[0] ;
         secuserabm_impl.this.AV18salt = GXv_char7[0] ;
         AV7SecUser.setgxTv_SdtSecUser_Secuserpassword( AV17hash );
         AV7SecUser.setgxTv_SdtSecUser_Secusersal( AV18salt );
      }
      if ( GXutil.strcmp(AV12TrnMode, "DSP") != 0 )
      {
         if ( GXutil.strcmp(AV12TrnMode, "DLT") != 0 )
         {
            /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
            S142 ();
            if (returnInSub) return;
         }
         if ( ( GXutil.strcmp(AV12TrnMode, "DLT") == 0 ) || AV9CheckRequiredFieldsResult )
         {
            if ( GXutil.strcmp(AV12TrnMode, "DLT") == 0 )
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
               S152 ();
               if (returnInSub) return;
            }
            else
            {
               AV11Messages = AV7SecUser.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV7SecUser", AV7SecUser);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11Messages", AV11Messages);
   }

   public void S132( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(AV12TrnMode, "DSP") != 0 ) ) )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      }
   }

   public void S142( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV9CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9CheckRequiredFieldsResult", AV9CheckRequiredFieldsResult);
      if ( (GXutil.strcmp("", AV7SecUser.getgxTv_SdtSecUser_Secusername())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Usuario (Mail)", ""), "", "", "", "", "", "", "", ""), "error", edtavSecuser_secusername_Internalname, "true", ""));
         AV9CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CheckRequiredFieldsResult", AV9CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV7SecUser.getgxTv_SdtSecUser_Secuserpername())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nombre", ""), "", "", "", "", "", "", "", ""), "error", edtavSecuser_secuserpername_Internalname, "true", ""));
         AV9CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CheckRequiredFieldsResult", AV9CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV7SecUser.getgxTv_SdtSecUser_Secuserperlastname())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Apellido", ""), "", "", "", "", "", "", "", ""), "error", edtavSecuser_secuserperlastname_Internalname, "true", ""));
         AV9CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CheckRequiredFieldsResult", AV9CheckRequiredFieldsResult);
      }
      if ( ( ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", "")) == 0 ) ) && (GXutil.strcmp("", AV19password)==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Contraseña", ""), "", "", "", "", "", "", "", ""), "error", edtavPassword_Internalname, "true", ""));
         AV9CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CheckRequiredFieldsResult", AV9CheckRequiredFieldsResult);
      }
      if ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", "")) == 0 )
      {
         if ( GXutil.strcmp(AV19password, AV8SecUserPassword) != 0 )
         {
            httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", httpContext.getMessage( "Las contraseñas no coinciden", ""), "error", edtavPassword_Internalname, "true", ""));
            AV9CheckRequiredFieldsResult = false ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9CheckRequiredFieldsResult", AV9CheckRequiredFieldsResult);
         }
      }
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", "")) == 0 ) ) )
      {
         edtavPassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavPassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPassword_Visible), 5, 0), true);
         divPassword_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divPassword_cell_Internalname, "Class", divPassword_cell_Class, true);
      }
      else
      {
         edtavPassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavPassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPassword_Visible), 5, 0), true);
         divPassword_cell_Class = "col-xs-12 RequiredDataContentCell" ;
         httpContext.ajax_rsp_assign_prop("", false, divPassword_cell_Internalname, "Class", divPassword_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", "")) == 0 ) ) )
      {
         edtavSecuserpassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecuserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuserpassword_Visible), 5, 0), true);
         divSecuserpassword_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divSecuserpassword_cell_Internalname, "Class", divSecuserpassword_cell_Class, true);
      }
      else
      {
         edtavSecuserpassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecuserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuserpassword_Visible), 5, 0), true);
         divSecuserpassword_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop("", false, divSecuserpassword_cell_Internalname, "Class", divSecuserpassword_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(A68SecUserName, new web.getusulogged(remoteHandle, context).executeUdp( )) != 0 ) ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         chkavSecuser_secusuactivo.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavSecuser_secusuactivo.getInternalname(), "Visible", GXutil.ltrimstr( chkavSecuser_secusuactivo.getVisible(), 5, 0), true);
         divSecuser_secusuactivo_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divSecuser_secusuactivo_cell_Internalname, "Class", divSecuser_secusuactivo_cell_Class, true);
      }
      else
      {
         chkavSecuser_secusuactivo.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavSecuser_secusuactivo.getInternalname(), "Visible", GXutil.ltrimstr( chkavSecuser_secusuactivo.getVisible(), 5, 0), true);
         divSecuser_secusuactivo_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop("", false, divSecuser_secusuactivo_cell_Internalname, "Class", divSecuser_secusuactivo_cell_Class, true);
      }
   }

   public void S112( )
   {
      /* 'SHOW MESSAGES' Routine */
      returnInSub = false ;
      AV30GXV8 = 1 ;
      while ( AV30GXV8 <= AV11Messages.size() )
      {
         AV10Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV11Messages.elementAt(-1+AV30GXV8));
         httpContext.GX_msglist.addItem(AV10Message.getgxTv_SdtMessages_Message_Description());
         AV30GXV8 = (int)(AV30GXV8+1) ;
      }
   }

   public void S152( )
   {
      /* 'AFTER_TRN' Routine */
      returnInSub = false ;
      Application.commitDataStores(context, remoteHandle, pr_default, "secuserabm");
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e142Z2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_9_2Z2( boolean wbgen )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuser_secusername_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecuser_secusername_Internalname, httpContext.getMessage( "Usuario (Mail)", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecuser_secusername_Internalname, AV7SecUser.getgxTv_SdtSecUser_Secusername(), GXutil.rtrim( localUtil.format( AV7SecUser.getgxTv_SdtSecUser_Secusername(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuser_secusername_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSecuser_secusername_Enabled, 1, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_SecUserABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuser_secuserpername_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecuser_secuserpername_Internalname, httpContext.getMessage( "Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecuser_secuserpername_Internalname, AV7SecUser.getgxTv_SdtSecUser_Secuserpername(), GXutil.rtrim( localUtil.format( AV7SecUser.getgxTv_SdtSecUser_Secuserpername(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuser_secuserpername_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSecuser_secuserpername_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_SecUserABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuser_secuserperlastname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecuser_secuserperlastname_Internalname, httpContext.getMessage( "Apellido", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecuser_secuserperlastname_Internalname, AV7SecUser.getgxTv_SdtSecUser_Secuserperlastname(), GXutil.rtrim( localUtil.format( AV7SecUser.getgxTv_SdtSecUser_Secuserperlastname(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuser_secuserperlastname_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSecuser_secuserperlastname_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_SecUserABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPassword_cell_Internalname, 1, 0, "px", 0, "px", divPassword_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavPassword_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavPassword_Internalname, httpContext.getMessage( "Contraseña", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavPassword_Internalname, AV19password, GXutil.rtrim( localUtil.format( AV19password, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPassword_Jsonclick, 0, "Attribute", "", "", "", "", edtavPassword_Visible, edtavPassword_Enabled, 1, "text", "", 80, "chr", 1, "row", 100, (byte)(-1), (short)(0), 0, (byte)(0), (byte)(0), (byte)(-1), true, "password", "left", true, "", "HLP_SecUserABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divSecuserpassword_cell_Internalname, 1, 0, "px", 0, "px", divSecuserpassword_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavSecuserpassword_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuserpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecuserpassword_Internalname, httpContext.getMessage( "Sec User Password", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecuserpassword_Internalname, AV8SecUserPassword, GXutil.rtrim( localUtil.format( AV8SecUserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuserpassword_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecuserpassword_Visible, edtavSecuserpassword_Enabled, 1, "text", "", 80, "chr", 1, "row", 100, (byte)(-1), (short)(0), 0, (byte)(0), (byte)(0), (byte)(-1), true, "password", "left", true, "", "HLP_SecUserABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divSecuser_secusuactivo_cell_Internalname, 1, 0, "px", 0, "px", divSecuser_secusuactivo_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkavSecuser_secusuactivo.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavSecuser_secusuactivo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavSecuser_secusuactivo.getInternalname(), httpContext.getMessage( "Activo", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavSecuser_secusuactivo.getInternalname(), GXutil.booltostr( AV7SecUser.getgxTv_SdtSecUser_Secusuactivo()), "", httpContext.getMessage( "Activo", ""), chkavSecuser_secusuactivo.getVisible(), chkavSecuser_secusuactivo.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(47, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,47);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", dynavSecuser_rolid.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavSecuser_rolid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavSecuser_rolid.getInternalname(), httpContext.getMessage( "Rol", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavSecuser_rolid, dynavSecuser_rolid.getInternalname(), GXutil.trim( GXutil.str( AV7SecUser.getgxTv_SdtSecUser_Rolid(), 2, 0)), 1, dynavSecuser_rolid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynavSecuser_rolid.getVisible(), dynavSecuser_rolid.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "", true, (byte)(0), "HLP_SecUserABM.htm");
         dynavSecuser_rolid.setValue( GXutil.trim( GXutil.str( AV7SecUser.getgxTv_SdtSecUser_Rolid(), 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavSecuser_rolid.getInternalname(), "Values", dynavSecuser_rolid.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SecUserABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SecUserABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_2Z2e( true) ;
      }
      else
      {
         wb_table1_9_2Z2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV12TrnMode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12TrnMode", AV12TrnMode);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12TrnMode, ""))));
      AV15SecUserId = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15SecUserId), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15SecUserId), "ZZZ9")));
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
      pa2Z2( ) ;
      ws2Z2( ) ;
      we2Z2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020392259", true, true);
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
      httpContext.AddJavascriptSource("secuserabm.js", "?2024122020392259", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavSecuser_secusername_Internalname = "SECUSER_SECUSERNAME" ;
      edtavSecuser_secuserpername_Internalname = "SECUSER_SECUSERPERNAME" ;
      edtavSecuser_secuserperlastname_Internalname = "SECUSER_SECUSERPERLASTNAME" ;
      edtavPassword_Internalname = "vPASSWORD" ;
      divPassword_cell_Internalname = "PASSWORD_CELL" ;
      edtavSecuserpassword_Internalname = "vSECUSERPASSWORD" ;
      divSecuserpassword_cell_Internalname = "SECUSERPASSWORD_CELL" ;
      chkavSecuser_secusuactivo.setInternalname( "SECUSER_SECUSUACTIVO" );
      divSecuser_secusuactivo_cell_Internalname = "SECUSER_SECUSUACTIVO_CELL" ;
      dynavSecuser_rolid.setInternalname( "SECUSER_ROLID" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavSecuser_secuserid_Internalname = "SECUSER_SECUSERID" ;
      edtavSecuser_clicod_Internalname = "SECUSER_CLICOD" ;
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
      dynavSecuser_rolid.setJsonclick( "" );
      dynavSecuser_rolid.setEnabled( 1 );
      dynavSecuser_rolid.setVisible( 1 );
      chkavSecuser_secusuactivo.setEnabled( 1 );
      chkavSecuser_secusuactivo.setVisible( 1 );
      edtavSecuserpassword_Jsonclick = "" ;
      edtavPassword_Jsonclick = "" ;
      edtavSecuser_secuserperlastname_Jsonclick = "" ;
      edtavSecuser_secuserperlastname_Enabled = 1 ;
      edtavSecuser_secuserpername_Jsonclick = "" ;
      edtavSecuser_secuserpername_Enabled = 1 ;
      edtavSecuser_secusername_Jsonclick = "" ;
      edtavSecuser_secusername_Enabled = 1 ;
      divSecuser_secusuactivo_cell_Class = "col-xs-12" ;
      divSecuserpassword_cell_Class = "col-xs-12" ;
      edtavSecuserpassword_Visible = 1 ;
      divPassword_cell_Class = "col-xs-12" ;
      edtavPassword_Visible = 1 ;
      dynavSecuser_rolid.setEnabled( 1 );
      chkavSecuser_secusuactivo.setEnabled( 1 );
      edtavSecuserpassword_Enabled = 1 ;
      edtavPassword_Enabled = 1 ;
      edtavSecuser_secuserperlastname_Enabled = 1 ;
      edtavSecuser_secuserpername_Enabled = 1 ;
      edtavSecuser_secusername_Enabled = 1 ;
      edtavSecuser_clicod_Jsonclick = "" ;
      edtavSecuser_clicod_Visible = 1 ;
      edtavSecuser_secuserid_Jsonclick = "" ;
      edtavSecuser_secuserid_Visible = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Sec User ABM", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      chkavSecuser_secusuactivo.setName( "SECUSER_SECUSUACTIVO" );
      chkavSecuser_secusuactivo.setWebtags( "" );
      chkavSecuser_secusuactivo.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavSecuser_secusuactivo.getInternalname(), "TitleCaption", chkavSecuser_secusuactivo.getCaption(), true);
      chkavSecuser_secusuactivo.setCheckedValue( "false" );
      dynavSecuser_rolid.setName( "SECUSER_ROLID" );
      dynavSecuser_rolid.setWebtags( "" );
      dynavSecuser_rolid.removeAllItems();
      /* Using cursor H002Z5 */
      pr_default.execute(3);
      while ( (pr_default.getStatus(3) != 101) )
      {
         dynavSecuser_rolid.addItem(GXutil.trim( GXutil.str( H002Z5_A1923RolId[0], 2, 0)), H002Z5_A1924RolNombre[0], (short)(0));
         pr_default.readNext(3);
      }
      pr_default.close(3);
      if ( dynavSecuser_rolid.getItemCount() > 0 )
      {
         AV7SecUser.setgxTv_SdtSecUser_Rolid( (byte)(GXutil.lval( dynavSecuser_rolid.getValidValue(GXutil.trim( GXutil.str( AV7SecUser.getgxTv_SdtSecUser_Rolid(), 2, 0))))) );
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'dynavSecuser_rolid'},{av:'GXV5',fld:'SECUSER_ROLID',pic:'Z9'},{av:'GXV4',fld:'SECUSER_SECUSUACTIVO',pic:''},{av:'AV12TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV15SecUserId',fld:'vSECUSERID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{ctrl:'BTNENTER',prop:'Visible'}]}");
      setEventMetadata("ENTER","{handler:'e132Z2',iparms:[{av:'AV12TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV19password',fld:'vPASSWORD',pic:''},{av:'AV7SecUser',fld:'vSECUSER',pic:''},{av:'AV9CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV8SecUserPassword',fld:'vSECUSERPASSWORD',pic:''},{av:'AV11Messages',fld:'vMESSAGES',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7SecUser',fld:'vSECUSER',pic:''},{av:'AV11Messages',fld:'vMESSAGES',pic:''},{av:'AV9CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("VALIDV_GXV1","{handler:'validv_Gxv1',iparms:[]");
      setEventMetadata("VALIDV_GXV1",",oparms:[]}");
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
      wcpOAV12TrnMode = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV12TrnMode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV7SecUser = new web.wwpbaseobjects.SdtSecUser(remoteHandle);
      AV11Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
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
      H002Z2_A1923RolId = new byte[1] ;
      H002Z2_A1924RolNombre = new String[] {""} ;
      H002Z3_A1923RolId = new byte[1] ;
      H002Z3_A1924RolNombre = new String[] {""} ;
      H002Z4_A67SecUserId = new short[1] ;
      H002Z4_A68SecUserName = new String[] {""} ;
      A68SecUserName = "" ;
      AV19password = "" ;
      AV8SecUserPassword = "" ;
      Gx_mode = "" ;
      GXv_int2 = new int[1] ;
      GXv_int3 = new byte[1] ;
      GXv_int5 = new long[1] ;
      GXv_int4 = new byte[1] ;
      AV17hash = "" ;
      GXv_char6 = new String[1] ;
      AV18salt = "" ;
      GXv_char7 = new String[1] ;
      AV10Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      ClassString = "" ;
      StyleString = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      H002Z5_A1923RolId = new byte[1] ;
      H002Z5_A1924RolNombre = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.secuserabm__default(),
         new Object[] {
             new Object[] {
            H002Z2_A1923RolId, H002Z2_A1924RolNombre
            }
            , new Object[] {
            H002Z3_A1923RolId, H002Z3_A1924RolNombre
            }
            , new Object[] {
            H002Z4_A67SecUserId, H002Z4_A68SecUserName
            }
            , new Object[] {
            H002Z5_A1923RolId, H002Z5_A1924RolNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte GXv_int3[] ;
   private byte AV16miRolId ;
   private byte GXv_int4[] ;
   private byte nGXWrapped ;
   private short wcpOAV15SecUserId ;
   private short AV15SecUserId ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavSecuser_secuserid_Visible ;
   private int edtavSecuser_clicod_Visible ;
   private int gxdynajaxindex ;
   private int edtavSecuser_secusername_Enabled ;
   private int edtavSecuser_secuserpername_Enabled ;
   private int edtavSecuser_secuserperlastname_Enabled ;
   private int edtavPassword_Enabled ;
   private int edtavSecuserpassword_Enabled ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int bttBtnenter_Visible ;
   private int edtavPassword_Visible ;
   private int edtavSecuserpassword_Visible ;
   private int AV30GXV8 ;
   private int idxLst ;
   private long GXv_int5[] ;
   private String wcpOAV12TrnMode ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV12TrnMode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
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
   private String edtavSecuser_secuserid_Internalname ;
   private String edtavSecuser_secuserid_Jsonclick ;
   private String edtavSecuser_clicod_Internalname ;
   private String edtavSecuser_clicod_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavSecuser_secusername_Internalname ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String edtavSecuser_secuserpername_Internalname ;
   private String edtavSecuser_secuserperlastname_Internalname ;
   private String edtavPassword_Internalname ;
   private String edtavSecuserpassword_Internalname ;
   private String Gx_mode ;
   private String GXv_char6[] ;
   private String GXv_char7[] ;
   private String bttBtnenter_Internalname ;
   private String divPassword_cell_Class ;
   private String divPassword_cell_Internalname ;
   private String divSecuserpassword_cell_Class ;
   private String divSecuserpassword_cell_Internalname ;
   private String divSecuser_secusuactivo_cell_Class ;
   private String divSecuser_secusuactivo_cell_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtavSecuser_secusername_Jsonclick ;
   private String edtavSecuser_secuserpername_Jsonclick ;
   private String edtavSecuser_secuserperlastname_Jsonclick ;
   private String edtavPassword_Jsonclick ;
   private String edtavSecuserpassword_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV9CheckRequiredFieldsResult ;
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
   private boolean AV13LoadSuccess ;
   private boolean Cond_result ;
   private String A68SecUserName ;
   private String AV19password ;
   private String AV8SecUserPassword ;
   private String AV17hash ;
   private String AV18salt ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private ICheckbox chkavSecuser_secusuactivo ;
   private HTMLChoice dynavSecuser_rolid ;
   private IDataStoreProvider pr_default ;
   private byte[] H002Z2_A1923RolId ;
   private String[] H002Z2_A1924RolNombre ;
   private byte[] H002Z3_A1923RolId ;
   private String[] H002Z3_A1924RolNombre ;
   private short[] H002Z4_A67SecUserId ;
   private String[] H002Z4_A68SecUserName ;
   private byte[] H002Z5_A1923RolId ;
   private String[] H002Z5_A1924RolNombre ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV11Messages ;
   private com.genexus.SdtMessages_Message AV10Message ;
   private web.wwpbaseobjects.SdtSecUser AV7SecUser ;
}

final  class secuserabm__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002Z2", "SELECT RolId, RolNombre FROM RolUsuario ORDER BY RolNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002Z3", "SELECT RolId, RolNombre FROM RolUsuario ORDER BY RolNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002Z4", "SELECT SecUserId, SecUserName FROM SecUser ORDER BY SecUserId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002Z5", "SELECT RolId, RolNombre FROM RolUsuario ORDER BY RolNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
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
      }
   }

}

