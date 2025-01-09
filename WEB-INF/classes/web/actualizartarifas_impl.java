package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class actualizartarifas_impl extends GXDataArea
{
   public actualizartarifas_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public actualizartarifas_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizartarifas_impl.class ));
   }

   public actualizartarifas_impl( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynavConvecodigo = new HTMLChoice();
      cmbavOrigen = new HTMLChoice();
      cmbavDecimales = new HTMLChoice();
      chkavTarifases = UIFactory.getCheckbox(this);
      chkavAdicionalimpes = UIFactory.getCheckbox(this);
      chkavConvenioimpes = UIFactory.getCheckbox(this);
      cmbavClirelsec = new HTMLChoice();
      cmbavConvscraptdoc = new HTMLChoice();
      cmbavConvscraptipo = new HTMLChoice();
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vCONVECODIGO") == 0 )
         {
            AV13PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13PaiCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13PaiCod), "ZZZ9")));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvconvecodigoH72( AV13PaiCod) ;
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
            AV46MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46MenuOpcCod", AV46MenuOpcCod);
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
      paH72( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startH72( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.actualizartarifas", new String[] {GXutil.URLEncode(GXutil.rtrim(AV46MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV53Pgmname, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"ActualizarTarifas");
      AV15tarifasEs = GXutil.strtobool( GXutil.booltostr( AV15tarifasEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15tarifasEs", AV15tarifasEs);
      forbiddenHiddens.add("tarifasEs", GXutil.booltostr( AV15tarifasEs));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("actualizartarifas:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCHECKREQUIREDFIELDSRESULT", AV22CheckRequiredFieldsResult);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV53Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV53Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV46MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "vDD", GXutil.ltrim( localUtil.ntoc( AV42DD, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMM", GXutil.ltrim( localUtil.ntoc( AV43MM, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vAAAA", GXutil.ltrim( localUtil.ntoc( AV41AAAA, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vAAAAMMDD_STR", GXutil.rtrim( AV40AAAAMMDD_str));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV13PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Title", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Result", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Result", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Result));
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
         weH72( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtH72( ) ;
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
      return formatLink("web.actualizartarifas", new String[] {GXutil.URLEncode(GXutil.rtrim(AV46MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "ActualizarTarifas" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Actualizar tarifas por porcentaje", "") ;
   }

   public void wbH70( )
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
         wb_table1_9_H72( true) ;
      }
      else
      {
         wb_table1_9_H72( false) ;
      }
      return  ;
   }

   public void wb_table1_9_H72e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavOrigen_catvigencia_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavOrigen_catvigencia_Internalname, localUtil.format(AV12origen_CatVigencia, "99/99/9999"), localUtil.format( AV12origen_CatVigencia, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,129);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOrigen_catvigencia_Jsonclick, 0, "Attribute", "", "", "", "", edtavOrigen_catvigencia_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ActualizarTarifas.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavOrigen_catvigencia_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavOrigen_catvigencia_Visible==0)||(1==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_ActualizarTarifas.htm");
         httpContext.writeTextNL( "</div>") ;
         wb_table2_130_H72( true) ;
      }
      else
      {
         wb_table2_130_H72( false) ;
      }
      return  ;
   }

   public void wb_table2_130_H72e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startH72( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Actualizar tarifas por porcentaje", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupH70( ) ;
   }

   public void wsH72( )
   {
      startH72( ) ;
      evtH72( ) ;
   }

   public void evtH72( )
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
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_CONFIRMAR.CLOSE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11H72 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e12H72 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCONFIRMAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoConfirmar' */
                           e13H72 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCANCELAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoCancelar' */
                           e14H72 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOSCRAPEVISIBILIZAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoScrapeVisibilizar' */
                           e15H72 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBUSCAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoBuscar' */
                           e16H72 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e17H72 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VCATVIGENCIA.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18H72 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e19H72 ();
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

   public void weH72( )
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

   public void paH72( )
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
            GX_FocusControl = dynavConvecodigo.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvvconvecodigoH72( short AV13PaiCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvconvecodigo_dataH72( AV13PaiCod) ;
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

   public void gxvvconvecodigo_htmlH72( short AV13PaiCod )
   {
      String gxdynajaxvalue;
      gxdlvvconvecodigo_dataH72( AV13PaiCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavConvecodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavConvecodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavConvecodigo.getItemCount() > 0 )
      {
         AV9ConveCodigo = dynavConvecodigo.getValidValue(AV9ConveCodigo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9ConveCodigo", AV9ConveCodigo);
      }
   }

   protected void gxdlvvconvecodigo_dataH72( short AV13PaiCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00H72 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV13PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00H72_A1565CliConvenio[0]));
         gxdynajaxctrldescr.add(H00H72_A1567CliConvenioDescrip[0]);
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
      if ( dynavConvecodigo.getItemCount() > 0 )
      {
         AV9ConveCodigo = dynavConvecodigo.getValidValue(AV9ConveCodigo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9ConveCodigo", AV9ConveCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavConvecodigo.setValue( GXutil.rtrim( AV9ConveCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, dynavConvecodigo.getInternalname(), "Values", dynavConvecodigo.ToJavascriptSource(), true);
      }
      if ( cmbavOrigen.getItemCount() > 0 )
      {
         AV37origen = (int)(GXutil.lval( cmbavOrigen.getValidValue(GXutil.trim( GXutil.str( AV37origen, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37origen", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37origen), 8, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavOrigen.setValue( GXutil.trim( GXutil.str( AV37origen, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavOrigen.getInternalname(), "Values", cmbavOrigen.ToJavascriptSource(), true);
      }
      if ( cmbavDecimales.getItemCount() > 0 )
      {
         AV14decimales = cmbavDecimales.getValidValue(AV14decimales) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14decimales", AV14decimales);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDecimales.setValue( GXutil.rtrim( AV14decimales) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDecimales.getInternalname(), "Values", cmbavDecimales.ToJavascriptSource(), true);
      }
      AV15tarifasEs = GXutil.strtobool( GXutil.booltostr( AV15tarifasEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15tarifasEs", AV15tarifasEs);
      AV16adicionalImpEs = GXutil.strtobool( GXutil.booltostr( AV16adicionalImpEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16adicionalImpEs", AV16adicionalImpEs);
      AV19convenioImpEs = GXutil.strtobool( GXutil.booltostr( AV19convenioImpEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19convenioImpEs", AV19convenioImpEs);
      if ( cmbavClirelsec.getItemCount() > 0 )
      {
         AV20CliRelSec = (int)(GXutil.lval( cmbavClirelsec.getValidValue(GXutil.trim( GXutil.str( AV20CliRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20CliRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavClirelsec.setValue( GXutil.trim( GXutil.str( AV20CliRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavClirelsec.getInternalname(), "Values", cmbavClirelsec.ToJavascriptSource(), true);
      }
      if ( cmbavConvscraptdoc.getItemCount() > 0 )
      {
         AV26ConvScrapTDoc = cmbavConvscraptdoc.getValidValue(AV26ConvScrapTDoc) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ConvScrapTDoc", AV26ConvScrapTDoc);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConvscraptdoc.setValue( GXutil.rtrim( AV26ConvScrapTDoc) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavConvscraptdoc.getInternalname(), "Values", cmbavConvscraptdoc.ToJavascriptSource(), true);
      }
      if ( cmbavConvscraptipo.getItemCount() > 0 )
      {
         AV27ConvScrapTipo = cmbavConvscraptipo.getValidValue(AV27ConvScrapTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ConvScrapTipo", AV27ConvScrapTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConvscraptipo.setValue( GXutil.rtrim( AV27ConvScrapTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavConvscraptipo.getInternalname(), "Values", cmbavConvscraptipo.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfH72( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV53Pgmname = "ActualizarTarifas" ;
      Gx_err = (short)(0) ;
      chkavTarifases.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavTarifases.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTarifases.getEnabled(), 5, 0), true);
      edtavUrl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUrl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrl_Enabled), 5, 0), true);
      edtavValorcrudo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValorcrudo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValorcrudo_Enabled), 5, 0), true);
   }

   public void rfH72( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e17H72 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e19H72 ();
         wbH70( ) ;
      }
   }

   public void send_integrity_lvl_hashesH72( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV13PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV53Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV53Pgmname, ""))));
   }

   public void before_start_formulas( )
   {
      AV53Pgmname = "ActualizarTarifas" ;
      Gx_err = (short)(0) ;
      chkavTarifases.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavTarifases.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTarifases.getEnabled(), 5, 0), true);
      edtavUrl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUrl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrl_Enabled), 5, 0), true);
      edtavValorcrudo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavValorcrudo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavValorcrudo_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strupH70( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12H72 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      gxvvconvecodigo_htmlH72( AV13PaiCod) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         AV42DD = (byte)(localUtil.ctol( httpContext.cgiGet( "vDD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV43MM = (byte)(localUtil.ctol( httpContext.cgiGet( "vMM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV41AAAA = (short)(localUtil.ctol( httpContext.cgiGet( "vAAAA"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV40AAAAMMDD_str = httpContext.cgiGet( "vAAAAMMDD_STR") ;
         Dvelop_confirmpanel_confirmar_Title = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Title") ;
         Dvelop_confirmpanel_confirmar_Confirmationtext = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Confirmationtext") ;
         Dvelop_confirmpanel_confirmar_Yesbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Yesbuttoncaption") ;
         Dvelop_confirmpanel_confirmar_Nobuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Nobuttoncaption") ;
         Dvelop_confirmpanel_confirmar_Cancelbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_confirmar_Yesbuttonposition = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Yesbuttonposition") ;
         Dvelop_confirmpanel_confirmar_Confirmtype = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Confirmtype") ;
         Dvelop_confirmpanel_confirmar_Result = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Result") ;
         /* Read variables values. */
         dynavConvecodigo.setValue( httpContext.cgiGet( dynavConvecodigo.getInternalname()) );
         AV9ConveCodigo = httpContext.cgiGet( dynavConvecodigo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9ConveCodigo", AV9ConveCodigo);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavCatvigencia_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vCATVIGENCIA");
            GX_FocusControl = edtavCatvigencia_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV10CatVigencia = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CatVigencia", localUtil.format(AV10CatVigencia, "99/99/9999"));
         }
         else
         {
            AV10CatVigencia = localUtil.ctod( httpContext.cgiGet( edtavCatvigencia_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CatVigencia", localUtil.format(AV10CatVigencia, "99/99/9999"));
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavPorunaje_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavPorunaje_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPORUNAJE");
            GX_FocusControl = edtavPorunaje_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11porUnaje = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11porUnaje", GXutil.ltrimstr( AV11porUnaje, 6, 4));
         }
         else
         {
            AV11porUnaje = localUtil.ctond( httpContext.cgiGet( edtavPorunaje_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11porUnaje", GXutil.ltrimstr( AV11porUnaje, 6, 4));
         }
         cmbavOrigen.setValue( httpContext.cgiGet( cmbavOrigen.getInternalname()) );
         AV37origen = (int)(GXutil.lval( httpContext.cgiGet( cmbavOrigen.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37origen", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37origen), 8, 0));
         cmbavDecimales.setValue( httpContext.cgiGet( cmbavDecimales.getInternalname()) );
         AV14decimales = httpContext.cgiGet( cmbavDecimales.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14decimales", AV14decimales);
         AV15tarifasEs = GXutil.strtobool( httpContext.cgiGet( chkavTarifases.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15tarifasEs", AV15tarifasEs);
         AV16adicionalImpEs = GXutil.strtobool( httpContext.cgiGet( chkavAdicionalimpes.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16adicionalImpEs", AV16adicionalImpEs);
         AV19convenioImpEs = GXutil.strtobool( httpContext.cgiGet( chkavConvenioimpes.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19convenioImpEs", AV19convenioImpEs);
         cmbavClirelsec.setValue( httpContext.cgiGet( cmbavClirelsec.getInternalname()) );
         AV20CliRelSec = (int)(GXutil.lval( httpContext.cgiGet( cmbavClirelsec.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20CliRelSec), 6, 0));
         AV28Url = httpContext.cgiGet( edtavUrl_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28Url", AV28Url);
         AV29valorCrudo = httpContext.cgiGet( edtavValorcrudo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29valorCrudo", AV29valorCrudo);
         AV24ConvBusGoogle = httpContext.cgiGet( edtavConvbusgoogle_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24ConvBusGoogle", AV24ConvBusGoogle);
         AV23ConvBaseURL = httpContext.cgiGet( edtavConvbaseurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23ConvBaseURL", AV23ConvBaseURL);
         AV25ConvBusWeb = httpContext.cgiGet( edtavConvbusweb_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ConvBusWeb", AV25ConvBusWeb);
         cmbavConvscraptdoc.setValue( httpContext.cgiGet( cmbavConvscraptdoc.getInternalname()) );
         AV26ConvScrapTDoc = httpContext.cgiGet( cmbavConvscraptdoc.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ConvScrapTDoc", AV26ConvScrapTDoc);
         cmbavConvscraptipo.setValue( httpContext.cgiGet( cmbavConvscraptipo.getInternalname()) );
         AV27ConvScrapTipo = httpContext.cgiGet( cmbavConvscraptipo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ConvScrapTipo", AV27ConvScrapTipo);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavScrapefecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vSCRAPEFECHA");
            GX_FocusControl = edtavScrapefecha_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV35scrapeFecha = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35scrapeFecha", localUtil.format(AV35scrapeFecha, "99/99/9999"));
         }
         else
         {
            AV35scrapeFecha = localUtil.ctod( httpContext.cgiGet( edtavScrapefecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35scrapeFecha", localUtil.format(AV35scrapeFecha, "99/99/9999"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavOrigen_catvigencia_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vORIGEN_CATVIGENCIA");
            GX_FocusControl = edtavOrigen_catvigencia_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV12origen_CatVigencia = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12origen_CatVigencia", localUtil.format(AV12origen_CatVigencia, "99/99/9999"));
         }
         else
         {
            AV12origen_CatVigencia = localUtil.ctod( httpContext.cgiGet( edtavOrigen_catvigencia_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12origen_CatVigencia", localUtil.format(AV12origen_CatVigencia, "99/99/9999"));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", "hsh"+"ActualizarTarifas");
         AV15tarifasEs = GXutil.strtobool( httpContext.cgiGet( chkavTarifases.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15tarifasEs", AV15tarifasEs);
         forbiddenHiddens.add("tarifasEs", GXutil.booltostr( AV15tarifasEs));
         hsh = httpContext.cgiGet( "hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("actualizartarifas:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e12H72 ();
      if (returnInSub) return;
   }

   public void e12H72( )
   {
      /* Start Routine */
      returnInSub = false ;
      tblTablescrape_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, tblTablescrape_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablescrape_Visible), 5, 0), true);
      tblTablerecap_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, tblTablerecap_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablerecap_Visible), 5, 0), true);
      AV47headTitle = Form.getCaption() ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", "", AV47headTitle) ;
      GXt_int1 = AV7CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      actualizartarifas_impl.this.GXt_int1 = GXv_int2[0] ;
      AV7CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      edtavUrl_Linktarget = "_blank" ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUrl_Internalname, "Linktarget", edtavUrl_Linktarget, true);
      edtavUrl_Link = AV28Url ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUrl_Internalname, "Link", edtavUrl_Link, true);
      edtavOrigen_catvigencia_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOrigen_catvigencia_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOrigen_catvigencia_Visible), 5, 0), true);
      GXt_int1 = AV7CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      actualizartarifas_impl.this.GXt_int1 = GXv_int2[0] ;
      AV7CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      GXt_int3 = AV13PaiCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.clientegetpais(remoteHandle, context).execute( AV7CliCod, GXv_int4) ;
      actualizartarifas_impl.this.GXt_int3 = GXv_int4[0] ;
      AV13PaiCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13PaiCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13PaiCod), "ZZZ9")));
      GXt_char5 = AV9ConveCodigo ;
      GXv_char6[0] = GXt_char5 ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char6) ;
      actualizartarifas_impl.this.GXt_char5 = GXv_char6[0] ;
      AV9ConveCodigo = GXt_char5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9ConveCodigo", AV9ConveCodigo);
      dynavConvecodigo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynavConvecodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynavConvecodigo.getEnabled(), 5, 0), true);
      AV15tarifasEs = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15tarifasEs", AV15tarifasEs);
      AV19convenioImpEs = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19convenioImpEs", AV19convenioImpEs);
      AV50GXLvl32 = (byte)(0) ;
      /* Using cursor H00H73 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV13PaiCod), AV9ConveCodigo});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1000ConveAdiImporte = H00H73_A1000ConveAdiImporte[0] ;
         A1565CliConvenio = H00H73_A1565CliConvenio[0] ;
         A1564CliPaiConve = H00H73_A1564CliPaiConve[0] ;
         A3CliCod = H00H73_A3CliCod[0] ;
         AV50GXLvl32 = (byte)(1) ;
         AV16adicionalImpEs = true ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16adicionalImpEs", AV16adicionalImpEs);
         chkavAdicionalimpes.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavAdicionalimpes.getInternalname(), "Enabled", GXutil.ltrimstr( chkavAdicionalimpes.getEnabled(), 5, 0), true);
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV50GXLvl32 == 0 )
      {
         AV16adicionalImpEs = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16adicionalImpEs", AV16adicionalImpEs);
         chkavAdicionalimpes.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavAdicionalimpes.getInternalname(), "Enabled", GXutil.ltrimstr( chkavAdicionalimpes.getEnabled(), 5, 0), true);
      }
      cmbavClirelsec.addItem("0", httpContext.getMessage( "Seleccionar", ""), (short)(0));
      /* Using cursor H00H74 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A3CliCod = H00H74_A3CliCod[0] ;
         A1880CliReDTChar = H00H74_A1880CliReDTChar[0] ;
         A1885CliRelSec = H00H74_A1885CliRelSec[0] ;
         cmbavClirelsec.addItem(GXutil.trim( GXutil.str( A1885CliRelSec, 6, 0)), GXutil.trim( A1880CliReDTChar), (short)(0));
         pr_default.readNext(2);
      }
      pr_default.close(2);
      GXv_date7[0] = AV10CatVigencia ;
      new web.getconvenextvig(remoteHandle, context).execute( AV7CliCod, AV13PaiCod, AV9ConveCodigo, GXv_date7) ;
      actualizartarifas_impl.this.AV10CatVigencia = GXv_date7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10CatVigencia", localUtil.format(AV10CatVigencia, "99/99/9999"));
      GXv_char6[0] = AV24ConvBusGoogle ;
      GXv_char8[0] = AV25ConvBusWeb ;
      GXv_char9[0] = AV23ConvBaseURL ;
      GXv_char10[0] = AV27ConvScrapTipo ;
      GXv_char11[0] = AV26ConvScrapTDoc ;
      new web.getconvbusqueda(remoteHandle, context).execute( AV13PaiCod, AV9ConveCodigo, AV10CatVigencia, GXv_char6, GXv_char8, GXv_char9, GXv_char10, GXv_char11) ;
      actualizartarifas_impl.this.AV24ConvBusGoogle = GXv_char6[0] ;
      actualizartarifas_impl.this.AV25ConvBusWeb = GXv_char8[0] ;
      actualizartarifas_impl.this.AV23ConvBaseURL = GXv_char9[0] ;
      actualizartarifas_impl.this.AV27ConvScrapTipo = GXv_char10[0] ;
      actualizartarifas_impl.this.AV26ConvScrapTDoc = GXv_char11[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ConvBusGoogle", AV24ConvBusGoogle);
      httpContext.ajax_rsp_assign_attri("", false, "AV25ConvBusWeb", AV25ConvBusWeb);
      httpContext.ajax_rsp_assign_attri("", false, "AV23ConvBaseURL", AV23ConvBaseURL);
      httpContext.ajax_rsp_assign_attri("", false, "AV27ConvScrapTipo", AV27ConvScrapTipo);
      httpContext.ajax_rsp_assign_attri("", false, "AV26ConvScrapTDoc", AV26ConvScrapTDoc);
      if ( (GXutil.strcmp("", AV24ConvBusGoogle)==0) )
      {
         lblScrapevisibilizar_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblScrapevisibilizar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblScrapevisibilizar_Visible), 5, 0), true);
      }
      cmbavOrigen.removeAllItems();
      cmbavOrigen.addItem("0", httpContext.getMessage( "Seleccionar", ""), (short)(0));
      /* Using cursor H00H75 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV13PaiCod), AV9ConveCodigo});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A1565CliConvenio = H00H75_A1565CliConvenio[0] ;
         A1564CliPaiConve = H00H75_A1564CliPaiConve[0] ;
         A3CliCod = H00H75_A3CliCod[0] ;
         A907CatVigencia = H00H75_A907CatVigencia[0] ;
         AV40AAAAMMDD_str = GXutil.trim( GXutil.str( GXutil.year( A907CatVigencia), 10, 0)) + GXutil.padl( GXutil.str( GXutil.month( A907CatVigencia), 10, 0), (short)(2), "0") + GXutil.padl( GXutil.str( GXutil.day( A907CatVigencia), 10, 0), (short)(2), "0") ;
         cmbavOrigen.addItem(GXutil.trim( GXutil.str( CommonUtil.decimalVal( AV40AAAAMMDD_str, "."), 8, 0)), GXutil.trim( localUtil.dtoc( A907CatVigencia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), (short)(0));
         pr_default.readNext(3);
      }
      pr_default.close(3);
   }

   public void e13H72( )
   {
      /* 'DoConfirmar' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
      S112 ();
      if (returnInSub) return;
      if ( AV22CheckRequiredFieldsResult )
      {
         this.executeUsercontrolMethod("", false, "DVELOP_CONFIRMPANEL_CONFIRMARContainer", "Confirm", "", new Object[] {});
      }
      /*  Sending Event outputs  */
   }

   public void e11H72( )
   {
      /* Dvelop_confirmpanel_confirmar_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_confirmar_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ACTION CONFIRMAR' */
         S122 ();
         if (returnInSub) return;
      }
   }

   public void e14H72( )
   {
      /* 'DoCancelar' Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   public void e15H72( )
   {
      /* 'DoScrapeVisibilizar' Routine */
      returnInSub = false ;
      tblTablescrape_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, tblTablescrape_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablescrape_Visible), 5, 0), true);
      /* Execute user subroutine: 'SCRAPE' */
      S132 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavOrigen.setValue( GXutil.trim( GXutil.str( AV37origen, 8, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavOrigen.getInternalname(), "Values", cmbavOrigen.ToJavascriptSource(), true);
   }

   public void e16H72( )
   {
      /* 'DoBuscar' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SCRAPE' */
      S132 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavOrigen.setValue( GXutil.trim( GXutil.str( AV37origen, 8, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavOrigen.getInternalname(), "Values", cmbavOrigen.ToJavascriptSource(), true);
   }

   public void S122( )
   {
      /* 'DO ACTION CONFIRMAR' Routine */
      returnInSub = false ;
      GXv_boolean12[0] = AV21aplicadoHay ;
      new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, AV20CliRelSec, GXv_boolean12) ;
      actualizartarifas_impl.this.AV21aplicadoHay = GXv_boolean12[0] ;
      if ( AV21aplicadoHay )
      {
         new web.alert(remoteHandle, context).execute( "error", new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod)) ;
      }
      else
      {
         if ( AV15tarifasEs )
         {
            new web.ajustartarifas(remoteHandle, context).execute( AV7CliCod, AV13PaiCod, AV9ConveCodigo, AV12origen_CatVigencia, AV11porUnaje, AV10CatVigencia, AV14decimales, AV20CliRelSec) ;
         }
         if ( AV16adicionalImpEs )
         {
            new web.ajustarimporteadicional(remoteHandle, context).execute( AV7CliCod, AV13PaiCod, AV9ConveCodigo, AV12origen_CatVigencia, AV11porUnaje, AV10CatVigencia, AV14decimales, AV20CliRelSec) ;
         }
         if ( AV19convenioImpEs )
         {
            new web.ajustarimporteconvenio(remoteHandle, context).execute( AV7CliCod, AV13PaiCod, AV9ConveCodigo, AV12origen_CatVigencia, AV11porUnaje, AV10CatVigencia, AV14decimales, AV20CliRelSec) ;
         }
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void S112( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV22CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22CheckRequiredFieldsResult", AV22CheckRequiredFieldsResult);
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CatVigencia)) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nueva fecha de Vigencia", ""), "", "", "", "", "", "", "", ""), "error", edtavCatvigencia_Internalname, "true", ""));
         AV22CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22CheckRequiredFieldsResult", AV22CheckRequiredFieldsResult);
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV11porUnaje)==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Porcentaje de aumento", ""), "", "", "", "", "", "", "", ""), "error", edtavPorunaje_Internalname, "true", ""));
         AV22CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22CheckRequiredFieldsResult", AV22CheckRequiredFieldsResult);
      }
      if ( (0==AV20CliRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha/hora de liberación", ""), "", "", "", "", "", "", "", ""), "error", cmbavClirelsec.getInternalname(), "true", ""));
         AV22CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22CheckRequiredFieldsResult", AV22CheckRequiredFieldsResult);
      }
   }

   public void e17H72( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV7CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      actualizartarifas_impl.this.GXt_int1 = GXv_int2[0] ;
      AV7CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      GXt_char5 = AV9ConveCodigo ;
      GXv_char11[0] = GXt_char5 ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char11) ;
      actualizartarifas_impl.this.GXt_char5 = GXv_char11[0] ;
      AV9ConveCodigo = GXt_char5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9ConveCodigo", AV9ConveCodigo);
      /*  Sending Event outputs  */
      dynavConvecodigo.setValue( GXutil.rtrim( AV9ConveCodigo) );
      httpContext.ajax_rsp_assign_prop("", false, dynavConvecodigo.getInternalname(), "Values", dynavConvecodigo.ToJavascriptSource(), true);
   }

   public void e18H72( )
   {
      /* Catvigencia_Controlvaluechanged Routine */
      returnInSub = false ;
      GXv_char11[0] = AV24ConvBusGoogle ;
      GXv_char10[0] = AV25ConvBusWeb ;
      GXv_char9[0] = AV23ConvBaseURL ;
      GXv_char8[0] = AV27ConvScrapTipo ;
      GXv_char6[0] = AV26ConvScrapTDoc ;
      new web.getconvbusqueda(remoteHandle, context).execute( AV13PaiCod, AV9ConveCodigo, AV10CatVigencia, GXv_char11, GXv_char10, GXv_char9, GXv_char8, GXv_char6) ;
      actualizartarifas_impl.this.AV24ConvBusGoogle = GXv_char11[0] ;
      actualizartarifas_impl.this.AV25ConvBusWeb = GXv_char10[0] ;
      actualizartarifas_impl.this.AV23ConvBaseURL = GXv_char9[0] ;
      actualizartarifas_impl.this.AV27ConvScrapTipo = GXv_char8[0] ;
      actualizartarifas_impl.this.AV26ConvScrapTDoc = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ConvBusGoogle", AV24ConvBusGoogle);
      httpContext.ajax_rsp_assign_attri("", false, "AV25ConvBusWeb", AV25ConvBusWeb);
      httpContext.ajax_rsp_assign_attri("", false, "AV23ConvBaseURL", AV23ConvBaseURL);
      httpContext.ajax_rsp_assign_attri("", false, "AV27ConvScrapTipo", AV27ConvScrapTipo);
      httpContext.ajax_rsp_assign_attri("", false, "AV26ConvScrapTDoc", AV26ConvScrapTDoc);
      /*  Sending Event outputs  */
      cmbavConvscraptdoc.setValue( GXutil.rtrim( AV26ConvScrapTDoc) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavConvscraptdoc.getInternalname(), "Values", cmbavConvscraptdoc.ToJavascriptSource(), true);
      cmbavConvscraptipo.setValue( GXutil.rtrim( AV27ConvScrapTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavConvscraptipo.getInternalname(), "Values", cmbavConvscraptipo.ToJavascriptSource(), true);
   }

   public void S132( )
   {
      /* 'SCRAPE' Routine */
      returnInSub = false ;
      GXv_char11[0] = AV44ConDescrip ;
      new web.getconvenio2(remoteHandle, context).execute( AV13PaiCod, AV9ConveCodigo, GXv_char11) ;
      actualizartarifas_impl.this.AV44ConDescrip = GXv_char11[0] ;
      GXv_char11[0] = AV29valorCrudo ;
      GXv_char10[0] = AV28Url ;
      GXv_char9[0] = AV30error ;
      new web.scrape(remoteHandle, context).execute( AV7CliCod, AV23ConvBaseURL, AV27ConvScrapTipo, AV26ConvScrapTDoc, AV24ConvBusGoogle, AV25ConvBusWeb, "", GXutil.trim( AV44ConDescrip), GXv_char11, GXv_char10, GXv_char9) ;
      actualizartarifas_impl.this.AV29valorCrudo = GXv_char11[0] ;
      actualizartarifas_impl.this.AV28Url = GXv_char10[0] ;
      actualizartarifas_impl.this.AV30error = GXv_char9[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29valorCrudo", AV29valorCrudo);
      httpContext.ajax_rsp_assign_attri("", false, "AV28Url", AV28Url);
      if ( ! (GXutil.strcmp("", AV30error)==0) )
      {
         httpContext.GX_msglist.addItem(AV30error);
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV28Url)==0) )
         {
            edtavUrl_Link = formatLink(AV28Url, new String[] {}, new String[] {})  ;
            httpContext.ajax_rsp_assign_prop("", false, edtavUrl_Internalname, "Link", edtavUrl_Link, true);
         }
      }
      tblTablerecap_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, tblTablerecap_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablerecap_Visible), 5, 0), true);
      if ( (GXutil.strcmp("", AV29valorCrudo)==0) )
      {
         if ( (GXutil.strcmp("", AV30error)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "No se encontró valor con la búsqueda especificada", ""));
         }
      }
      else
      {
         edtavValorcrudo_Fontbold = (byte)(1) ;
         httpContext.ajax_rsp_assign_prop("", false, edtavValorcrudo_Internalname, "Fontbold", GXutil.str( edtavValorcrudo_Fontbold, 1, 0), true);
         GXv_char11[0] = AV29valorCrudo ;
         GXv_decimal13[0] = AV11porUnaje ;
         GXv_date7[0] = AV12origen_CatVigencia ;
         GXv_int2[0] = AV37origen ;
         new web.parseartextoconveniotarifas(remoteHandle, context).execute( AV7CliCod, AV13PaiCod, AV9ConveCodigo, AV25ConvBusWeb, GXv_char11, GXv_decimal13, GXv_date7, GXv_int2) ;
         actualizartarifas_impl.this.AV29valorCrudo = GXv_char11[0] ;
         actualizartarifas_impl.this.AV11porUnaje = GXv_decimal13[0] ;
         actualizartarifas_impl.this.AV12origen_CatVigencia = GXv_date7[0] ;
         actualizartarifas_impl.this.AV37origen = GXv_int2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29valorCrudo", AV29valorCrudo);
         httpContext.ajax_rsp_assign_attri("", false, "AV11porUnaje", GXutil.ltrimstr( AV11porUnaje, 6, 4));
         httpContext.ajax_rsp_assign_attri("", false, "AV12origen_CatVigencia", localUtil.format(AV12origen_CatVigencia, "99/99/9999"));
         httpContext.ajax_rsp_assign_attri("", false, "AV37origen", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37origen), 8, 0));
         new web.msgdebug_prod(remoteHandle, context).execute( AV53Pgmname, httpContext.getMessage( "&origen ", "")+GXutil.trim( GXutil.str( AV37origen, 8, 0))) ;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e19H72( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table2_130_H72( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_confirmar_Internalname, tblTabledvelop_confirmpanel_confirmar_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_confirmar.setProperty("Title", Dvelop_confirmpanel_confirmar_Title);
         ucDvelop_confirmpanel_confirmar.setProperty("ConfirmationText", Dvelop_confirmpanel_confirmar_Confirmationtext);
         ucDvelop_confirmpanel_confirmar.setProperty("YesButtonCaption", Dvelop_confirmpanel_confirmar_Yesbuttoncaption);
         ucDvelop_confirmpanel_confirmar.setProperty("NoButtonCaption", Dvelop_confirmpanel_confirmar_Nobuttoncaption);
         ucDvelop_confirmpanel_confirmar.setProperty("CancelButtonCaption", Dvelop_confirmpanel_confirmar_Cancelbuttoncaption);
         ucDvelop_confirmpanel_confirmar.setProperty("YesButtonPosition", Dvelop_confirmpanel_confirmar_Yesbuttonposition);
         ucDvelop_confirmpanel_confirmar.setProperty("ConfirmType", Dvelop_confirmpanel_confirmar_Confirmtype);
         ucDvelop_confirmpanel_confirmar.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_confirmar_Internalname, "DVELOP_CONFIRMPANEL_CONFIRMARContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVELOP_CONFIRMPANEL_CONFIRMARContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_130_H72e( true) ;
      }
      else
      {
         wb_table2_130_H72e( false) ;
      }
   }

   public void wb_table1_9_H72( boolean wbgen )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table3_15_H72( true) ;
      }
      else
      {
         wb_table3_15_H72( false) ;
      }
      return  ;
   }

   public void wb_table3_15_H72e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 123,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnconfirmar_Internalname, "", httpContext.getMessage( "Confirmar", ""), bttBtnconfirmar_Jsonclick, 5, httpContext.getMessage( "Confirmar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCONFIRMAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ActualizarTarifas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 125,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancelar_Internalname, "", httpContext.getMessage( "Cancelar", ""), bttBtncancelar_Jsonclick, 5, httpContext.getMessage( "Cancelar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCANCELAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ActualizarTarifas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_H72e( true) ;
      }
      else
      {
         wb_table1_9_H72e( false) ;
      }
   }

   public void wb_table3_15_H72( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+dynavConvecodigo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavConvecodigo.getInternalname(), httpContext.getMessage( "Convenio", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavConvecodigo, dynavConvecodigo.getInternalname(), GXutil.rtrim( AV9ConveCodigo), 1, dynavConvecodigo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavConvecodigo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,20);\"", "", true, (byte)(0), "HLP_ActualizarTarifas.htm");
         dynavConvecodigo.setValue( GXutil.rtrim( AV9ConveCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, dynavConvecodigo.getInternalname(), "Values", dynavConvecodigo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='Required'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavCatvigencia_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavCatvigencia_Internalname, httpContext.getMessage( "Nueva fecha de Vigencia", ""), "gx-form-item AttributeDateLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavCatvigencia_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavCatvigencia_Internalname, localUtil.format(AV10CatVigencia, "99/99/9999"), localUtil.format( AV10CatVigencia, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCatvigencia_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavCatvigencia_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ActualizarTarifas.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavCatvigencia_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavCatvigencia_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_ActualizarTarifas.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='Required'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavPorunaje_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavPorunaje_Internalname, httpContext.getMessage( "Porcentaje de aumento", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavPorunaje_Internalname, GXutil.ltrim( localUtil.ntoc( AV11porUnaje, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavPorunaje_Enabled!=0) ? localUtil.format( AV11porUnaje, "9.9999") : localUtil.format( AV11porUnaje, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,30);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPorunaje_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavPorunaje_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_ActualizarTarifas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavOrigen.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavOrigen.getInternalname(), httpContext.getMessage( "Fecha de vigencia origen", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavOrigen, cmbavOrigen.getInternalname(), GXutil.trim( GXutil.str( AV37origen, 8, 0)), 1, cmbavOrigen.getJsonclick(), 7, "'"+""+"'"+",false,"+"'"+"e20h71_client"+"'", "int", "", 1, cmbavOrigen.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "", true, (byte)(0), "HLP_ActualizarTarifas.htm");
         cmbavOrigen.setValue( GXutil.trim( GXutil.str( AV37origen, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavOrigen.getInternalname(), "Values", cmbavOrigen.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavDecimales.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavDecimales.getInternalname(), httpContext.getMessage( "Decimales", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDecimales, cmbavDecimales.getInternalname(), GXutil.rtrim( AV14decimales), 1, cmbavDecimales.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavDecimales.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,40);\"", "", true, (byte)(0), "HLP_ActualizarTarifas.htm");
         cmbavDecimales.setValue( GXutil.rtrim( AV14decimales) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDecimales.getInternalname(), "Values", cmbavDecimales.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+chkavTarifases.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavTarifases.getInternalname(), httpContext.getMessage( "Actualizar tarifas de categorías", ""), "gx-form-item AttributeCheckBoxLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTarifases.getInternalname(), GXutil.booltostr( AV15tarifasEs), "", httpContext.getMessage( "Actualizar tarifas de categorías", ""), 1, chkavTarifases.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(45, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+chkavAdicionalimpes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavAdicionalimpes.getInternalname(), httpContext.getMessage( "Actualizar importes de adicionales", ""), "gx-form-item AttributeCheckBoxLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAdicionalimpes.getInternalname(), GXutil.booltostr( AV16adicionalImpEs), "", httpContext.getMessage( "Actualizar importes de adicionales", ""), 1, chkavAdicionalimpes.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(50, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,50);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+chkavConvenioimpes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavConvenioimpes.getInternalname(), httpContext.getMessage( "Actualizar importes de convenio (por ejemplo tope indemnizatorio)", ""), "gx-form-item AttributeCheckBoxLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavConvenioimpes.getInternalname(), GXutil.booltostr( AV19convenioImpEs), "", httpContext.getMessage( "Actualizar importes de convenio (por ejemplo tope indemnizatorio)", ""), 1, chkavConvenioimpes.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(55, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,55);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='Required'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavClirelsec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavClirelsec.getInternalname(), httpContext.getMessage( "Fecha/hora de liberación", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavClirelsec, cmbavClirelsec.getInternalname(), GXutil.trim( GXutil.str( AV20CliRelSec, 6, 0)), 1, cmbavClirelsec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavClirelsec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,60);\"", "", true, (byte)(0), "HLP_ActualizarTarifas.htm");
         cmbavClirelsec.setValue( GXutil.trim( GXutil.str( AV20CliRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavClirelsec.getInternalname(), "Values", cmbavClirelsec.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblScrapevisibilizar_Internalname, httpContext.getMessage( "<i class=\"fab fa-google fab fa-google\"></i>", ""), "", "", lblScrapevisibilizar_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOSCRAPEVISIBILIZAR\\'."+"'", "", "TextBlock", 5, "", lblScrapevisibilizar_Visible, 1, 0, (short)(1), "HLP_ActualizarTarifas.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavUrl_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavUrl_Internalname, AV28Url, GXutil.rtrim( localUtil.format( AV28Url, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", edtavUrl_Link, edtavUrl_Linktarget, "", "", edtavUrl_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavUrl_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ActualizarTarifas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavValorcrudo_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavValorcrudo_Internalname, AV29valorCrudo, GXutil.rtrim( localUtil.format( AV29valorCrudo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,73);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValorcrudo_Jsonclick, 0, "Attribute", ((edtavValorcrudo_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"), "", "", "", 1, edtavValorcrudo_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ActualizarTarifas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table4_76_H72( true) ;
      }
      else
      {
         wb_table4_76_H72( false) ;
      }
      return  ;
   }

   public void wb_table4_76_H72e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_15_H72e( true) ;
      }
      else
      {
         wb_table3_15_H72e( false) ;
      }
   }

   public void wb_table4_76_H72( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTablescrape_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTablescrape_Internalname, tblTablescrape_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnrecapturar_Internalname, "", httpContext.getMessage( "Editar búsqueda", ""), bttBtnrecapturar_Jsonclick, 7, httpContext.getMessage( "Editar búsqueda", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e21h71_client"+"'", TempTags, "", 2, "HLP_ActualizarTarifas.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table5_82_H72( true) ;
      }
      else
      {
         wb_table5_82_H72( false) ;
      }
      return  ;
   }

   public void wb_table5_82_H72e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_76_H72e( true) ;
      }
      else
      {
         wb_table4_76_H72e( false) ;
      }
   }

   public void wb_table5_82_H72( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTablerecap_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTablerecap_Internalname, tblTablerecap_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavConvbusgoogle_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavConvbusgoogle_Internalname, httpContext.getMessage( "Buscar en google", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavConvbusgoogle_Internalname, AV24ConvBusGoogle, GXutil.rtrim( localUtil.format( AV24ConvBusGoogle, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,87);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConvbusgoogle_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavConvbusgoogle_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ActualizarTarifas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavConvbaseurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavConvbaseurl_Internalname, httpContext.getMessage( "Solo resultados de la página", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavConvbaseurl_Internalname, AV23ConvBaseURL, GXutil.rtrim( localUtil.format( AV23ConvBaseURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,92);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConvbaseurl_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavConvbaseurl_Enabled, 0, "text", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_ActualizarTarifas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavConvbusweb_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavConvbusweb_Internalname, httpContext.getMessage( "Buscar el título", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavConvbusweb_Internalname, AV25ConvBusWeb, GXutil.rtrim( localUtil.format( AV25ConvBusWeb, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,97);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConvbusweb_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavConvbusweb_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ActualizarTarifas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConvscraptdoc.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConvscraptdoc.getInternalname(), httpContext.getMessage( "En documentos tipo", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConvscraptdoc, cmbavConvscraptdoc.getInternalname(), GXutil.rtrim( AV26ConvScrapTDoc), 1, cmbavConvscraptdoc.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavConvscraptdoc.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,102);\"", "", true, (byte)(0), "HLP_ActualizarTarifas.htm");
         cmbavConvscraptdoc.setValue( GXutil.rtrim( AV26ConvScrapTDoc) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavConvscraptdoc.getInternalname(), "Values", cmbavConvscraptdoc.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConvscraptipo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConvscraptipo.getInternalname(), httpContext.getMessage( "En", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConvscraptipo, cmbavConvscraptipo.getInternalname(), GXutil.rtrim( AV27ConvScrapTipo), 1, cmbavConvscraptipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavConvscraptipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,107);\"", "", true, (byte)(0), "HLP_ActualizarTarifas.htm");
         cmbavConvscraptipo.setValue( GXutil.rtrim( AV27ConvScrapTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavConvscraptipo.getInternalname(), "Values", cmbavConvscraptipo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 110,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnbuscar_Internalname, "", httpContext.getMessage( "Buscar", ""), bttBtnbuscar_Jsonclick, 5, httpContext.getMessage( "Buscar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBUSCAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ActualizarTarifas.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavScrapefecha_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavScrapefecha_Internalname, httpContext.getMessage( "scrape Fecha", ""), "gx-form-item AttributeDateLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 115,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavScrapefecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavScrapefecha_Internalname, localUtil.format(AV35scrapeFecha, "99/99/9999"), localUtil.format( AV35scrapeFecha, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,115);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavScrapefecha_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavScrapefecha_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_ActualizarTarifas.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavScrapefecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavScrapefecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_ActualizarTarifas.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_82_H72e( true) ;
      }
      else
      {
         wb_table5_82_H72e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV46MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46MenuOpcCod", AV46MenuOpcCod);
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
      paH72( ) ;
      wsH72( ) ;
      weH72( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202518718960", true, true);
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
      httpContext.AddJavascriptSource("actualizartarifas.js", "?202518718960", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynavConvecodigo.setInternalname( "vCONVECODIGO" );
      edtavCatvigencia_Internalname = "vCATVIGENCIA" ;
      edtavPorunaje_Internalname = "vPORUNAJE" ;
      cmbavOrigen.setInternalname( "vORIGEN" );
      cmbavDecimales.setInternalname( "vDECIMALES" );
      chkavTarifases.setInternalname( "vTARIFASES" );
      chkavAdicionalimpes.setInternalname( "vADICIONALIMPES" );
      chkavConvenioimpes.setInternalname( "vCONVENIOIMPES" );
      cmbavClirelsec.setInternalname( "vCLIRELSEC" );
      lblScrapevisibilizar_Internalname = "SCRAPEVISIBILIZAR" ;
      edtavUrl_Internalname = "vURL" ;
      edtavValorcrudo_Internalname = "vVALORCRUDO" ;
      bttBtnrecapturar_Internalname = "BTNRECAPTURAR" ;
      edtavConvbusgoogle_Internalname = "vCONVBUSGOOGLE" ;
      edtavConvbaseurl_Internalname = "vCONVBASEURL" ;
      edtavConvbusweb_Internalname = "vCONVBUSWEB" ;
      cmbavConvscraptdoc.setInternalname( "vCONVSCRAPTDOC" );
      cmbavConvscraptipo.setInternalname( "vCONVSCRAPTIPO" );
      bttBtnbuscar_Internalname = "BTNBUSCAR" ;
      edtavScrapefecha_Internalname = "vSCRAPEFECHA" ;
      tblTablerecap_Internalname = "TABLERECAP" ;
      tblTablescrape_Internalname = "TABLESCRAPE" ;
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnconfirmar_Internalname = "BTNCONFIRMAR" ;
      bttBtncancelar_Internalname = "BTNCANCELAR" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavOrigen_catvigencia_Internalname = "vORIGEN_CATVIGENCIA" ;
      Dvelop_confirmpanel_confirmar_Internalname = "DVELOP_CONFIRMPANEL_CONFIRMAR" ;
      tblTabledvelop_confirmpanel_confirmar_Internalname = "TABLEDVELOP_CONFIRMPANEL_CONFIRMAR" ;
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
      edtavScrapefecha_Jsonclick = "" ;
      edtavScrapefecha_Enabled = 1 ;
      cmbavConvscraptipo.setJsonclick( "" );
      cmbavConvscraptipo.setEnabled( 1 );
      cmbavConvscraptdoc.setJsonclick( "" );
      cmbavConvscraptdoc.setEnabled( 1 );
      edtavConvbusweb_Jsonclick = "" ;
      edtavConvbusweb_Enabled = 1 ;
      edtavConvbaseurl_Jsonclick = "" ;
      edtavConvbaseurl_Enabled = 1 ;
      edtavConvbusgoogle_Jsonclick = "" ;
      edtavConvbusgoogle_Enabled = 1 ;
      edtavValorcrudo_Jsonclick = "" ;
      edtavValorcrudo_Enabled = 1 ;
      edtavUrl_Jsonclick = "" ;
      edtavUrl_Enabled = 1 ;
      lblScrapevisibilizar_Visible = 1 ;
      cmbavClirelsec.setJsonclick( "" );
      cmbavClirelsec.setEnabled( 1 );
      chkavConvenioimpes.setEnabled( 1 );
      chkavTarifases.setEnabled( 1 );
      cmbavDecimales.setJsonclick( "" );
      cmbavDecimales.setEnabled( 1 );
      cmbavOrigen.setJsonclick( "" );
      cmbavOrigen.setEnabled( 1 );
      edtavPorunaje_Jsonclick = "" ;
      edtavPorunaje_Enabled = 1 ;
      edtavCatvigencia_Jsonclick = "" ;
      edtavCatvigencia_Enabled = 1 ;
      dynavConvecodigo.setJsonclick( "" );
      edtavValorcrudo_Fontbold = (byte)(0) ;
      chkavAdicionalimpes.setEnabled( 1 );
      dynavConvecodigo.setEnabled( 1 );
      edtavUrl_Link = "" ;
      edtavUrl_Linktarget = "" ;
      tblTablerecap_Visible = 1 ;
      tblTablescrape_Visible = 1 ;
      edtavOrigen_catvigencia_Jsonclick = "" ;
      edtavOrigen_catvigencia_Visible = 1 ;
      Dvelop_confirmpanel_confirmar_Confirmtype = "1" ;
      Dvelop_confirmpanel_confirmar_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_confirmar_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_confirmar_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_confirmar_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_confirmar_Confirmationtext = "¿Confirma crear registros nuevos de escalas salariales?" ;
      Dvelop_confirmpanel_confirmar_Title = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Actualizar tarifas por porcentaje", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      dynavConvecodigo.setName( "vCONVECODIGO" );
      dynavConvecodigo.setWebtags( "" );
      cmbavOrigen.setName( "vORIGEN" );
      cmbavOrigen.setWebtags( "" );
      if ( cmbavOrigen.getItemCount() > 0 )
      {
         AV37origen = (int)(GXutil.lval( cmbavOrigen.getValidValue(GXutil.trim( GXutil.str( AV37origen, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37origen", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37origen), 8, 0));
      }
      cmbavDecimales.setName( "vDECIMALES" );
      cmbavDecimales.setWebtags( "" );
      cmbavDecimales.addItem("Con", httpContext.getMessage( "ConDecimales", ""), (short)(0));
      cmbavDecimales.addItem("Truncar", httpContext.getMessage( "Truncar", ""), (short)(0));
      cmbavDecimales.addItem("Redondear", httpContext.getMessage( "Redondear", ""), (short)(0));
      cmbavDecimales.addItem("RedondearArriba", httpContext.getMessage( "Redondear para arriba siempre", ""), (short)(0));
      if ( cmbavDecimales.getItemCount() > 0 )
      {
         AV14decimales = cmbavDecimales.getValidValue(AV14decimales) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14decimales", AV14decimales);
      }
      chkavTarifases.setName( "vTARIFASES" );
      chkavTarifases.setWebtags( "" );
      chkavTarifases.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavTarifases.getInternalname(), "TitleCaption", chkavTarifases.getCaption(), true);
      chkavTarifases.setCheckedValue( "false" );
      AV15tarifasEs = GXutil.strtobool( GXutil.booltostr( AV15tarifasEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15tarifasEs", AV15tarifasEs);
      chkavAdicionalimpes.setName( "vADICIONALIMPES" );
      chkavAdicionalimpes.setWebtags( "" );
      chkavAdicionalimpes.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavAdicionalimpes.getInternalname(), "TitleCaption", chkavAdicionalimpes.getCaption(), true);
      chkavAdicionalimpes.setCheckedValue( "false" );
      AV16adicionalImpEs = GXutil.strtobool( GXutil.booltostr( AV16adicionalImpEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16adicionalImpEs", AV16adicionalImpEs);
      chkavConvenioimpes.setName( "vCONVENIOIMPES" );
      chkavConvenioimpes.setWebtags( "" );
      chkavConvenioimpes.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavConvenioimpes.getInternalname(), "TitleCaption", chkavConvenioimpes.getCaption(), true);
      chkavConvenioimpes.setCheckedValue( "false" );
      AV19convenioImpEs = GXutil.strtobool( GXutil.booltostr( AV19convenioImpEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19convenioImpEs", AV19convenioImpEs);
      cmbavClirelsec.setName( "vCLIRELSEC" );
      cmbavClirelsec.setWebtags( "" );
      cmbavClirelsec.addItem(GXutil.trim( GXutil.str( 0, 6, 0)), httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      if ( cmbavClirelsec.getItemCount() > 0 )
      {
         AV20CliRelSec = (int)(GXutil.lval( cmbavClirelsec.getValidValue(GXutil.trim( GXutil.str( AV20CliRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20CliRelSec), 6, 0));
      }
      cmbavConvscraptdoc.setName( "vCONVSCRAPTDOC" );
      cmbavConvscraptdoc.setWebtags( "" );
      cmbavConvscraptdoc.addItem("HTML", httpContext.getMessage( "Html", ""), (short)(0));
      cmbavConvscraptdoc.addItem("PDF", httpContext.getMessage( "PDF", ""), (short)(0));
      if ( cmbavConvscraptdoc.getItemCount() > 0 )
      {
         AV26ConvScrapTDoc = cmbavConvscraptdoc.getValidValue(AV26ConvScrapTDoc) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ConvScrapTDoc", AV26ConvScrapTDoc);
      }
      cmbavConvscraptipo.setName( "vCONVSCRAPTIPO" );
      cmbavConvscraptipo.setWebtags( "" );
      cmbavConvscraptipo.addItem("Tabla", httpContext.getMessage( "Tabla", ""), (short)(0));
      cmbavConvscraptipo.addItem("Texto", httpContext.getMessage( "Texto", ""), (short)(0));
      cmbavConvscraptipo.addItem("Imagen", httpContext.getMessage( "Imagen", ""), (short)(0));
      if ( cmbavConvscraptipo.getItemCount() > 0 )
      {
         AV27ConvScrapTipo = cmbavConvscraptipo.getValidValue(AV27ConvScrapTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ConvScrapTipo", AV27ConvScrapTipo);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV16adicionalImpEs',fld:'vADICIONALIMPES',pic:''},{av:'AV19convenioImpEs',fld:'vCONVENIOIMPES',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV53Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV15tarifasEs',fld:'vTARIFASES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynavConvecodigo'},{av:'AV9ConveCodigo',fld:'vCONVECODIGO',pic:''}]}");
      setEventMetadata("'DOCONFIRMAR'","{handler:'e13H72',iparms:[{av:'AV22CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV10CatVigencia',fld:'vCATVIGENCIA',pic:''},{av:'AV11porUnaje',fld:'vPORUNAJE',pic:'9.9999'},{av:'cmbavClirelsec'},{av:'AV20CliRelSec',fld:'vCLIRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("'DOCONFIRMAR'",",oparms:[{av:'AV22CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_CONFIRMAR.CLOSE","{handler:'e11H72',iparms:[{av:'Dvelop_confirmpanel_confirmar_Result',ctrl:'DVELOP_CONFIRMPANEL_CONFIRMAR',prop:'Result'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'cmbavClirelsec'},{av:'AV20CliRelSec',fld:'vCLIRELSEC',pic:'ZZZZZ9'},{av:'AV15tarifasEs',fld:'vTARIFASES',pic:''},{av:'AV13PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynavConvecodigo'},{av:'AV9ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV12origen_CatVigencia',fld:'vORIGEN_CATVIGENCIA',pic:''},{av:'AV11porUnaje',fld:'vPORUNAJE',pic:'9.9999'},{av:'AV10CatVigencia',fld:'vCATVIGENCIA',pic:''},{av:'cmbavDecimales'},{av:'AV14decimales',fld:'vDECIMALES',pic:''},{av:'AV16adicionalImpEs',fld:'vADICIONALIMPES',pic:''},{av:'AV19convenioImpEs',fld:'vCONVENIOIMPES',pic:''}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_CONFIRMAR.CLOSE",",oparms:[]}");
      setEventMetadata("'DOCANCELAR'","{handler:'e14H72',iparms:[]");
      setEventMetadata("'DOCANCELAR'",",oparms:[]}");
      setEventMetadata("'DOSCRAPEVISIBILIZAR'","{handler:'e15H72',iparms:[{av:'AV13PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynavConvecodigo'},{av:'AV9ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV23ConvBaseURL',fld:'vCONVBASEURL',pic:''},{av:'cmbavConvscraptipo'},{av:'AV27ConvScrapTipo',fld:'vCONVSCRAPTIPO',pic:''},{av:'cmbavConvscraptdoc'},{av:'AV26ConvScrapTDoc',fld:'vCONVSCRAPTDOC',pic:''},{av:'AV24ConvBusGoogle',fld:'vCONVBUSGOOGLE',pic:''},{av:'AV25ConvBusWeb',fld:'vCONVBUSWEB',pic:''},{av:'AV53Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("'DOSCRAPEVISIBILIZAR'",",oparms:[{av:'tblTablescrape_Visible',ctrl:'TABLESCRAPE',prop:'Visible'},{av:'AV28Url',fld:'vURL',pic:''},{av:'AV29valorCrudo',fld:'vVALORCRUDO',pic:''},{av:'edtavUrl_Link',ctrl:'vURL',prop:'Link'},{av:'tblTablerecap_Visible',ctrl:'TABLERECAP',prop:'Visible'},{av:'edtavValorcrudo_Fontbold',ctrl:'vVALORCRUDO',prop:'Fontbold'},{av:'cmbavOrigen'},{av:'AV37origen',fld:'vORIGEN',pic:'ZZZZZZZ9'},{av:'AV12origen_CatVigencia',fld:'vORIGEN_CATVIGENCIA',pic:''},{av:'AV11porUnaje',fld:'vPORUNAJE',pic:'9.9999'}]}");
      setEventMetadata("'DORECAPTURAR'","{handler:'e21H71',iparms:[]");
      setEventMetadata("'DORECAPTURAR'",",oparms:[{av:'tblTablerecap_Visible',ctrl:'TABLERECAP',prop:'Visible'}]}");
      setEventMetadata("'DOBUSCAR'","{handler:'e16H72',iparms:[{av:'AV13PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynavConvecodigo'},{av:'AV9ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV23ConvBaseURL',fld:'vCONVBASEURL',pic:''},{av:'cmbavConvscraptipo'},{av:'AV27ConvScrapTipo',fld:'vCONVSCRAPTIPO',pic:''},{av:'cmbavConvscraptdoc'},{av:'AV26ConvScrapTDoc',fld:'vCONVSCRAPTDOC',pic:''},{av:'AV24ConvBusGoogle',fld:'vCONVBUSGOOGLE',pic:''},{av:'AV25ConvBusWeb',fld:'vCONVBUSWEB',pic:''},{av:'AV53Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("'DOBUSCAR'",",oparms:[{av:'AV28Url',fld:'vURL',pic:''},{av:'AV29valorCrudo',fld:'vVALORCRUDO',pic:''},{av:'edtavUrl_Link',ctrl:'vURL',prop:'Link'},{av:'tblTablerecap_Visible',ctrl:'TABLERECAP',prop:'Visible'},{av:'edtavValorcrudo_Fontbold',ctrl:'vVALORCRUDO',prop:'Fontbold'},{av:'cmbavOrigen'},{av:'AV37origen',fld:'vORIGEN',pic:'ZZZZZZZ9'},{av:'AV12origen_CatVigencia',fld:'vORIGEN_CATVIGENCIA',pic:''},{av:'AV11porUnaje',fld:'vPORUNAJE',pic:'9.9999'}]}");
      setEventMetadata("VORIGEN.CLICK","{handler:'e20H71',iparms:[{av:'cmbavOrigen'},{av:'AV37origen',fld:'vORIGEN',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VORIGEN.CLICK",",oparms:[{av:'AV12origen_CatVigencia',fld:'vORIGEN_CATVIGENCIA',pic:''}]}");
      setEventMetadata("VCATVIGENCIA.CONTROLVALUECHANGED","{handler:'e18H72',iparms:[{av:'AV13PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynavConvecodigo'},{av:'AV9ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV10CatVigencia',fld:'vCATVIGENCIA',pic:''}]");
      setEventMetadata("VCATVIGENCIA.CONTROLVALUECHANGED",",oparms:[{av:'cmbavConvscraptdoc'},{av:'AV26ConvScrapTDoc',fld:'vCONVSCRAPTDOC',pic:''},{av:'cmbavConvscraptipo'},{av:'AV27ConvScrapTipo',fld:'vCONVSCRAPTIPO',pic:''},{av:'AV23ConvBaseURL',fld:'vCONVBASEURL',pic:''},{av:'AV25ConvBusWeb',fld:'vCONVBUSWEB',pic:''},{av:'AV24ConvBusGoogle',fld:'vCONVBUSGOOGLE',pic:''}]}");
      setEventMetadata("VALIDV_CONVECODIGO","{handler:'validv_Convecodigo',iparms:[]");
      setEventMetadata("VALIDV_CONVECODIGO",",oparms:[]}");
      setEventMetadata("VALIDV_URL","{handler:'validv_Url',iparms:[]");
      setEventMetadata("VALIDV_URL",",oparms:[]}");
      setEventMetadata("VALIDV_CONVBASEURL","{handler:'validv_Convbaseurl',iparms:[]");
      setEventMetadata("VALIDV_CONVBASEURL",",oparms:[]}");
      setEventMetadata("VALIDV_CONVSCRAPTDOC","{handler:'validv_Convscraptdoc',iparms:[]");
      setEventMetadata("VALIDV_CONVSCRAPTDOC",",oparms:[]}");
      setEventMetadata("VALIDV_CONVSCRAPTIPO","{handler:'validv_Convscraptipo',iparms:[]");
      setEventMetadata("VALIDV_CONVSCRAPTIPO",",oparms:[]}");
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
      wcpOAV46MenuOpcCod = "" ;
      Dvelop_confirmpanel_confirmar_Result = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV46MenuOpcCod = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV53Pgmname = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      AV40AAAAMMDD_str = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      AV12origen_CatVigencia = GXutil.nullDate() ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      AV9ConveCodigo = "" ;
      scmdbuf = "" ;
      H00H72_A3CliCod = new int[1] ;
      H00H72_A1565CliConvenio = new String[] {""} ;
      H00H72_A1567CliConvenioDescrip = new String[] {""} ;
      H00H72_A1564CliPaiConve = new short[1] ;
      AV14decimales = "" ;
      AV26ConvScrapTDoc = "" ;
      AV27ConvScrapTipo = "" ;
      AV10CatVigencia = GXutil.nullDate() ;
      AV11porUnaje = DecimalUtil.ZERO ;
      AV28Url = "" ;
      AV29valorCrudo = "" ;
      AV24ConvBusGoogle = "" ;
      AV23ConvBaseURL = "" ;
      AV25ConvBusWeb = "" ;
      AV35scrapeFecha = GXutil.nullDate() ;
      hsh = "" ;
      AV47headTitle = "" ;
      GXv_int4 = new short[1] ;
      H00H73_A996ConveAdicod = new String[] {""} ;
      H00H73_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      H00H73_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00H73_A1565CliConvenio = new String[] {""} ;
      H00H73_A1564CliPaiConve = new short[1] ;
      H00H73_A3CliCod = new int[1] ;
      A1000ConveAdiImporte = DecimalUtil.ZERO ;
      A1565CliConvenio = "" ;
      H00H74_A3CliCod = new int[1] ;
      H00H74_A1880CliReDTChar = new String[] {""} ;
      H00H74_A1885CliRelSec = new int[1] ;
      A1880CliReDTChar = "" ;
      H00H75_A8CatCodigo = new String[] {""} ;
      H00H75_A1565CliConvenio = new String[] {""} ;
      H00H75_A1564CliPaiConve = new short[1] ;
      H00H75_A3CliCod = new int[1] ;
      H00H75_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      A907CatVigencia = GXutil.nullDate() ;
      GXv_boolean12 = new boolean[1] ;
      GXt_char5 = "" ;
      GXv_char8 = new String[1] ;
      GXv_char6 = new String[1] ;
      AV44ConDescrip = "" ;
      GXv_char10 = new String[1] ;
      AV30error = "" ;
      GXv_char9 = new String[1] ;
      GXv_char11 = new String[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_date7 = new java.util.Date[1] ;
      GXv_int2 = new int[1] ;
      sStyleString = "" ;
      ucDvelop_confirmpanel_confirmar = new com.genexus.webpanels.GXUserControl();
      ClassString = "" ;
      StyleString = "" ;
      bttBtnconfirmar_Jsonclick = "" ;
      bttBtncancelar_Jsonclick = "" ;
      lblScrapevisibilizar_Jsonclick = "" ;
      bttBtnrecapturar_Jsonclick = "" ;
      bttBtnbuscar_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizartarifas__default(),
         new Object[] {
             new Object[] {
            H00H72_A3CliCod, H00H72_A1565CliConvenio, H00H72_A1567CliConvenioDescrip, H00H72_A1564CliPaiConve
            }
            , new Object[] {
            H00H73_A996ConveAdicod, H00H73_A999ConveAdiVig, H00H73_A1000ConveAdiImporte, H00H73_A1565CliConvenio, H00H73_A1564CliPaiConve, H00H73_A3CliCod
            }
            , new Object[] {
            H00H74_A3CliCod, H00H74_A1880CliReDTChar, H00H74_A1885CliRelSec
            }
            , new Object[] {
            H00H75_A8CatCodigo, H00H75_A1565CliConvenio, H00H75_A1564CliPaiConve, H00H75_A3CliCod, H00H75_A907CatVigencia
            }
         }
      );
      AV53Pgmname = "ActualizarTarifas" ;
      /* GeneXus formulas. */
      AV53Pgmname = "ActualizarTarifas" ;
      Gx_err = (short)(0) ;
      chkavTarifases.setEnabled( 0 );
      edtavUrl_Enabled = 0 ;
      edtavValorcrudo_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte AV42DD ;
   private byte AV43MM ;
   private byte nDonePA ;
   private byte AV50GXLvl32 ;
   private byte edtavValorcrudo_Fontbold ;
   private byte nGXWrapped ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV13PaiCod ;
   private short AV41AAAA ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXt_int3 ;
   private short GXv_int4[] ;
   private short A1564CliPaiConve ;
   private int AV7CliCod ;
   private int edtavOrigen_catvigencia_Visible ;
   private int gxdynajaxindex ;
   private int AV37origen ;
   private int AV20CliRelSec ;
   private int edtavUrl_Enabled ;
   private int edtavValorcrudo_Enabled ;
   private int tblTablescrape_Visible ;
   private int tblTablerecap_Visible ;
   private int A3CliCod ;
   private int A1885CliRelSec ;
   private int lblScrapevisibilizar_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtavCatvigencia_Enabled ;
   private int edtavPorunaje_Enabled ;
   private int edtavConvbusgoogle_Enabled ;
   private int edtavConvbaseurl_Enabled ;
   private int edtavConvbusweb_Enabled ;
   private int edtavScrapefecha_Enabled ;
   private int idxLst ;
   private java.math.BigDecimal AV11porUnaje ;
   private java.math.BigDecimal A1000ConveAdiImporte ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private String Dvelop_confirmpanel_confirmar_Result ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV53Pgmname ;
   private String GXKey ;
   private String AV40AAAAMMDD_str ;
   private String Dvelop_confirmpanel_confirmar_Title ;
   private String Dvelop_confirmpanel_confirmar_Confirmationtext ;
   private String Dvelop_confirmpanel_confirmar_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_confirmar_Nobuttoncaption ;
   private String Dvelop_confirmpanel_confirmar_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_confirmar_Yesbuttonposition ;
   private String Dvelop_confirmpanel_confirmar_Confirmtype ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String edtavOrigen_catvigencia_Internalname ;
   private String edtavOrigen_catvigencia_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String AV9ConveCodigo ;
   private String scmdbuf ;
   private String AV14decimales ;
   private String AV26ConvScrapTDoc ;
   private String AV27ConvScrapTipo ;
   private String edtavUrl_Internalname ;
   private String edtavValorcrudo_Internalname ;
   private String edtavCatvigencia_Internalname ;
   private String edtavPorunaje_Internalname ;
   private String edtavConvbusgoogle_Internalname ;
   private String edtavConvbaseurl_Internalname ;
   private String edtavConvbusweb_Internalname ;
   private String edtavScrapefecha_Internalname ;
   private String hsh ;
   private String tblTablescrape_Internalname ;
   private String tblTablerecap_Internalname ;
   private String edtavUrl_Linktarget ;
   private String edtavUrl_Link ;
   private String A1565CliConvenio ;
   private String lblScrapevisibilizar_Internalname ;
   private String GXt_char5 ;
   private String GXv_char8[] ;
   private String GXv_char6[] ;
   private String GXv_char10[] ;
   private String GXv_char9[] ;
   private String GXv_char11[] ;
   private String sStyleString ;
   private String tblTabledvelop_confirmpanel_confirmar_Internalname ;
   private String Dvelop_confirmpanel_confirmar_Internalname ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnconfirmar_Internalname ;
   private String bttBtnconfirmar_Jsonclick ;
   private String bttBtncancelar_Internalname ;
   private String bttBtncancelar_Jsonclick ;
   private String tblUnnamedtable1_Internalname ;
   private String edtavCatvigencia_Jsonclick ;
   private String edtavPorunaje_Jsonclick ;
   private String lblScrapevisibilizar_Jsonclick ;
   private String edtavUrl_Jsonclick ;
   private String edtavValorcrudo_Jsonclick ;
   private String bttBtnrecapturar_Internalname ;
   private String bttBtnrecapturar_Jsonclick ;
   private String edtavConvbusgoogle_Jsonclick ;
   private String edtavConvbaseurl_Jsonclick ;
   private String edtavConvbusweb_Jsonclick ;
   private String bttBtnbuscar_Internalname ;
   private String bttBtnbuscar_Jsonclick ;
   private String edtavScrapefecha_Jsonclick ;
   private java.util.Date AV12origen_CatVigencia ;
   private java.util.Date AV10CatVigencia ;
   private java.util.Date AV35scrapeFecha ;
   private java.util.Date A907CatVigencia ;
   private java.util.Date GXv_date7[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV15tarifasEs ;
   private boolean AV22CheckRequiredFieldsResult ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean AV16adicionalImpEs ;
   private boolean AV19convenioImpEs ;
   private boolean returnInSub ;
   private boolean AV21aplicadoHay ;
   private boolean GXv_boolean12[] ;
   private String wcpOAV46MenuOpcCod ;
   private String AV46MenuOpcCod ;
   private String AV28Url ;
   private String AV29valorCrudo ;
   private String AV24ConvBusGoogle ;
   private String AV23ConvBaseURL ;
   private String AV25ConvBusWeb ;
   private String AV47headTitle ;
   private String A1880CliReDTChar ;
   private String AV44ConDescrip ;
   private String AV30error ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_confirmar ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynavConvecodigo ;
   private HTMLChoice cmbavOrigen ;
   private HTMLChoice cmbavDecimales ;
   private ICheckbox chkavTarifases ;
   private ICheckbox chkavAdicionalimpes ;
   private ICheckbox chkavConvenioimpes ;
   private HTMLChoice cmbavClirelsec ;
   private HTMLChoice cmbavConvscraptdoc ;
   private HTMLChoice cmbavConvscraptipo ;
   private IDataStoreProvider pr_default ;
   private int[] H00H72_A3CliCod ;
   private String[] H00H72_A1565CliConvenio ;
   private String[] H00H72_A1567CliConvenioDescrip ;
   private short[] H00H72_A1564CliPaiConve ;
   private String[] H00H73_A996ConveAdicod ;
   private java.util.Date[] H00H73_A999ConveAdiVig ;
   private java.math.BigDecimal[] H00H73_A1000ConveAdiImporte ;
   private String[] H00H73_A1565CliConvenio ;
   private short[] H00H73_A1564CliPaiConve ;
   private int[] H00H73_A3CliCod ;
   private int[] H00H74_A3CliCod ;
   private String[] H00H74_A1880CliReDTChar ;
   private int[] H00H74_A1885CliRelSec ;
   private String[] H00H75_A8CatCodigo ;
   private String[] H00H75_A1565CliConvenio ;
   private short[] H00H75_A1564CliPaiConve ;
   private int[] H00H75_A3CliCod ;
   private java.util.Date[] H00H75_A907CatVigencia ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class actualizartarifas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00H72", "SELECT T1.CliCod, T1.CliConvenio AS CliConvenio, T2.ConveDescri AS CliConvenioDescrip, T1.CliPaiConve AS CliPaiConve FROM (ClienteConvenios T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE T1.CliPaiConve = ? ORDER BY T2.ConveDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00H73", "SELECT ConveAdicod, ConveAdiVig, ConveAdiImporte, CliConvenio, CliPaiConve, CliCod FROM convenio_adicionalimportes WHERE (CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?)) AND (ConveAdiImporte > 0) ORDER BY CliCod, CliPaiConve, CliConvenio  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00H74", "SELECT CliCod, CliReDTChar, CliRelSec FROM Cliente_Release WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00H75", "SELECT CatCodigo, CliConvenio, CliPaiConve, CliCod, CatVigencia FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

