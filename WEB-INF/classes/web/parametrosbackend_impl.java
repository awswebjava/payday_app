package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class parametrosbackend_impl extends GXDataArea
{
   public parametrosbackend_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public parametrosbackend_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( parametrosbackend_impl.class ));
   }

   public parametrosbackend_impl( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavModotest = UIFactory.getCheckbox(this);
      chkavA3lutilitiesesdocker = UIFactory.getCheckbox(this);
      chkavScrapecuil = UIFactory.getCheckbox(this);
      chkavLiquidarauxparalelos = UIFactory.getCheckbox(this);
      cmbavAuto_imprimir_pdfliqleg = new HTMLChoice();
      cmbavPdf_automatico_estilo = new HTMLChoice();
      cmbavLiqprinmodopalabra = new HTMLChoice();
      cmbavLiqlsdmodopalabra = new HTMLChoice();
      cmbavLiqcontrmodopalabra = new HTMLChoice();
      cmbavLiqotrosmodopalabra = new HTMLChoice();
      cmbavLiqrecibosmodopalabra = new HTMLChoice();
      cmbavLiquploadmodopalabra = new HTMLChoice();
      cmbavLiqpdfmodopalabra = new HTMLChoice();
      cmbavImgas3modopalabra = new HTMLChoice();
      chkavLambda_desgloce = UIFactory.getCheckbox(this);
      cmbavMetodoinvocapdf = new HTMLChoice();
      cmbavFlujo_gen_rec = new HTMLChoice();
      chkavGrabarhtmlrecibodb = UIFactory.getCheckbox(this);
      chkavModoahorros3 = UIFactory.getCheckbox(this);
      cmbavNiveldebug = new HTMLChoice();
      chkavTliqhabilitada = UIFactory.getCheckbox(this);
      chkavS3_gx_es = UIFactory.getCheckbox(this);
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid1") == 0 )
         {
            gxnrgrid1_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid1") == 0 )
         {
            gxgrgrid1_refresh_invoke( ) ;
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
            AV46MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46MenuOpcCod", AV46MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV46MenuOpcCod, ""))));
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

   public void gxnrgrid1_newrow_invoke( )
   {
      nRC_GXsfl_270 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_270"))) ;
      nGXsfl_270_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_270_idx"))) ;
      sGXsfl_270_idx = httpContext.GetPar( "sGXsfl_270_idx") ;
      chkavTliqhabilitada.setEnabled( (int)(GXutil.lval( httpContext.GetNextPar( ))) );
      httpContext.ajax_rsp_assign_prop("", false, chkavTliqhabilitada.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTliqhabilitada.getEnabled(), 5, 0), !bGXsfl_270_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid1_newrow( ) ;
      /* End function gxnrGrid1_newrow_invoke */
   }

   public void gxgrgrid1_refresh_invoke( )
   {
      subGrid1_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid1_Rows"))) ;
      AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      chkavTliqhabilitada.setEnabled( (int)(GXutil.lval( httpContext.GetNextPar( ))) );
      httpContext.ajax_rsp_assign_prop("", false, chkavTliqhabilitada.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTliqhabilitada.getEnabled(), 5, 0), !bGXsfl_270_Refreshing);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV43sdt_tipo_liqs);
      AV52modoTest = GXutil.strtobool( httpContext.GetPar( "modoTest")) ;
      AV47a3lutilitiesEsDocker = GXutil.strtobool( httpContext.GetPar( "a3lutilitiesEsDocker")) ;
      AV61scrapeCuil = GXutil.strtobool( httpContext.GetPar( "scrapeCuil")) ;
      AV60liquidarAuxParalelos = GXutil.strtobool( httpContext.GetPar( "liquidarAuxParalelos")) ;
      AV79lambda_desgloce = GXutil.strtobool( httpContext.GetPar( "lambda_desgloce")) ;
      AV90grabarHtmlReciboDB = GXutil.strtobool( httpContext.GetPar( "grabarHtmlReciboDB")) ;
      AV55modoAhorroS3 = GXutil.strtobool( httpContext.GetPar( "modoAhorroS3")) ;
      AV86s3_Gx_Es = GXutil.strtobool( httpContext.GetPar( "s3_Gx_Es")) ;
      AV105Pgmname = httpContext.GetPar( "Pgmname") ;
      AV46MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid1_refresh( subGrid1_Rows, AV7CliCod, AV43sdt_tipo_liqs, AV52modoTest, AV47a3lutilitiesEsDocker, AV61scrapeCuil, AV60liquidarAuxParalelos, AV79lambda_desgloce, AV90grabarHtmlReciboDB, AV55modoAhorroS3, AV86s3_Gx_Es, AV105Pgmname, AV46MenuOpcCod) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid1_refresh_invoke */
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
      paMK2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startMK2( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.parametrosbackend", new String[] {GXutil.URLEncode(GXutil.rtrim(AV46MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV105Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV46MenuOpcCod, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_270", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_270, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDT_TIPO_LIQS", AV43sdt_tipo_liqs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDT_TIPO_LIQS", AV43sdt_tipo_liqs);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV105Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV105Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV46MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV46MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid1_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "vTLIQHABILITADA_Enabled", GXutil.ltrim( localUtil.ntoc( chkavTliqhabilitada.getEnabled(), (byte)(5), (byte)(0), ".", "")));
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
         weMK2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtMK2( ) ;
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
      return formatLink("web.parametrosbackend", new String[] {GXutil.URLEncode(GXutil.rtrim(AV46MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "ParametrosBackend" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Parámetros", "") ;
   }

   public void wbMK0( )
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
         wb_table1_9_MK2( true) ;
      }
      else
      {
         wb_table1_9_MK2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_MK2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 316,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavAuto_imprimir_pdfliq_Internalname, GXutil.rtrim( AV53auto_imprimir_PDFLiq), GXutil.rtrim( localUtil.format( AV53auto_imprimir_PDFLiq, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,316);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuto_imprimir_pdfliq_Jsonclick, 0, "Attribute", "", "", "", "", edtavAuto_imprimir_pdfliq_Visible, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ParametrosBackend.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 317,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqmodo_Internalname, GXutil.rtrim( AV85liqModo), GXutil.rtrim( localUtil.format( AV85liqModo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,317);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqmodo_Jsonclick, 0, "Attribute", "", "", "", "", edtavLiqmodo_Visible, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ParametrosBackend.htm");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 318,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavS3_gx_es.getInternalname(), GXutil.booltostr( AV86s3_Gx_Es), "", "", chkavS3_gx_es.getVisible(), 1, "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(318, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,318);\"");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 319,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavUrl_sqs_calcliqsecundarios_Internalname, AV76url_sqs_CalcLiqSecundarios, GXutil.rtrim( localUtil.format( AV76url_sqs_CalcLiqSecundarios, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,319);\"", "'"+""+"'"+",false,"+"'"+""+"'", AV76url_sqs_CalcLiqSecundarios, "_blank", "", "", edtavUrl_sqs_calcliqsecundarios_Jsonclick, 0, "Attribute", "", "", "", "", edtavUrl_sqs_calcliqsecundarios_Visible, 1, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ParametrosBackend.htm");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 320,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavHostnodepublico_Internalname, AV59hostNodePublico, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,320);\"", (short)(0), edtavHostnodepublico_Visible, 1, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_ParametrosBackend.htm");
         /* User Defined Control */
         ucGrid1_empowerer.render(context, "wwp.gridempowerer", Grid1_empowerer_Internalname, "GRID1_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 270 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Grid1Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Grid1Container.AddObjectProperty("GRID1_nEOF", GRID1_nEOF);
               Grid1Container.AddObjectProperty("GRID1_nFirstRecordOnPage", GRID1_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Grid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid1", Grid1Container, subGrid1_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData", Grid1Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData"+"V", Grid1Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid1ContainerData"+"V"+"\" value='"+Grid1Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startMK2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Parámetros", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupMK0( ) ;
   }

   public void wsMK2( )
   {
      startMK2( ) ;
      evtMK2( ) ;
   }

   public void evtMK2( )
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
                        else if ( GXutil.strcmp(sEvt, "'DOCONFIRMAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoConfirmar' */
                           e11MK2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCANCELAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoCancelar' */
                           e12MK2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOPROGRAMAS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoProgramas' */
                           e13MK2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRID1PAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRID1PAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid1_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid1_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid1_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid1_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID1.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "'DOVOLVER'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_270_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_270_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_270_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2702( ) ;
                           A32TLiqCod = httpContext.cgiGet( edtTLiqCod_Internalname) ;
                           A340TliqDesc = GXutil.upper( httpContext.cgiGet( edtTliqDesc_Internalname)) ;
                           AV37TLiqHabilitada = GXutil.strtobool( httpContext.cgiGet( chkavTliqhabilitada.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavTliqhabilitada.getInternalname(), AV37TLiqHabilitada);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e14MK2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15MK2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID1.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e16MK2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "'DOVOLVER'") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoVolver' */
                                 e17MK2 ();
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

   public void weMK2( )
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

   public void paMK2( )
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
            GX_FocusControl = chkavModotest.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid1_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2702( ) ;
      while ( nGXsfl_270_idx <= nRC_GXsfl_270 )
      {
         sendrow_2702( ) ;
         nGXsfl_270_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_270_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_270_idx+1) ;
         sGXsfl_270_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_270_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2702( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid1Container)) ;
      /* End function gxnrGrid1_newrow */
   }

   public void gxgrgrid1_refresh( int subGrid1_Rows ,
                                  int AV7CliCod ,
                                  GXBaseCollection<web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem> AV43sdt_tipo_liqs ,
                                  boolean AV52modoTest ,
                                  boolean AV47a3lutilitiesEsDocker ,
                                  boolean AV61scrapeCuil ,
                                  boolean AV60liquidarAuxParalelos ,
                                  boolean AV79lambda_desgloce ,
                                  boolean AV90grabarHtmlReciboDB ,
                                  boolean AV55modoAhorroS3 ,
                                  boolean AV86s3_Gx_Es ,
                                  String AV105Pgmname ,
                                  String AV46MenuOpcCod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e15MK2 ();
      GRID1_nCurrentRecord = 0 ;
      rfMK2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid1_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_TLIQCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A32TLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "TLIQCOD", GXutil.rtrim( A32TLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_TLIQDESC", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A340TliqDesc, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "TLIQDESC", A340TliqDesc);
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
      AV52modoTest = GXutil.strtobool( GXutil.booltostr( AV52modoTest)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52modoTest", AV52modoTest);
      AV47a3lutilitiesEsDocker = GXutil.strtobool( GXutil.booltostr( AV47a3lutilitiesEsDocker)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47a3lutilitiesEsDocker", AV47a3lutilitiesEsDocker);
      AV61scrapeCuil = GXutil.strtobool( GXutil.booltostr( AV61scrapeCuil)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61scrapeCuil", AV61scrapeCuil);
      AV60liquidarAuxParalelos = GXutil.strtobool( GXutil.booltostr( AV60liquidarAuxParalelos)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60liquidarAuxParalelos", AV60liquidarAuxParalelos);
      if ( cmbavAuto_imprimir_pdfliqleg.getItemCount() > 0 )
      {
         AV54auto_imprimir_PDFLiqLeg = cmbavAuto_imprimir_pdfliqleg.getValidValue(AV54auto_imprimir_PDFLiqLeg) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV54auto_imprimir_PDFLiqLeg", AV54auto_imprimir_PDFLiqLeg);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavAuto_imprimir_pdfliqleg.setValue( GXutil.rtrim( AV54auto_imprimir_PDFLiqLeg) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAuto_imprimir_pdfliqleg.getInternalname(), "Values", cmbavAuto_imprimir_pdfliqleg.ToJavascriptSource(), true);
      }
      if ( cmbavPdf_automatico_estilo.getItemCount() > 0 )
      {
         AV64pdf_automatico_estilo = cmbavPdf_automatico_estilo.getValidValue(AV64pdf_automatico_estilo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64pdf_automatico_estilo", AV64pdf_automatico_estilo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPdf_automatico_estilo.setValue( GXutil.rtrim( AV64pdf_automatico_estilo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPdf_automatico_estilo.getInternalname(), "Values", cmbavPdf_automatico_estilo.ToJavascriptSource(), true);
      }
      if ( cmbavLiqprinmodopalabra.getItemCount() > 0 )
      {
         AV92liqPrinModoPalabra = cmbavLiqprinmodopalabra.getValidValue(AV92liqPrinModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV92liqPrinModoPalabra", AV92liqPrinModoPalabra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqprinmodopalabra.setValue( GXutil.rtrim( AV92liqPrinModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqprinmodopalabra.getInternalname(), "Values", cmbavLiqprinmodopalabra.ToJavascriptSource(), true);
      }
      if ( cmbavLiqlsdmodopalabra.getItemCount() > 0 )
      {
         AV93liqLSDModoPalabra = cmbavLiqlsdmodopalabra.getValidValue(AV93liqLSDModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV93liqLSDModoPalabra", AV93liqLSDModoPalabra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqlsdmodopalabra.setValue( GXutil.rtrim( AV93liqLSDModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqlsdmodopalabra.getInternalname(), "Values", cmbavLiqlsdmodopalabra.ToJavascriptSource(), true);
      }
      if ( cmbavLiqcontrmodopalabra.getItemCount() > 0 )
      {
         AV97liqContrModoPalabra = cmbavLiqcontrmodopalabra.getValidValue(AV97liqContrModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV97liqContrModoPalabra", AV97liqContrModoPalabra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqcontrmodopalabra.setValue( GXutil.rtrim( AV97liqContrModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqcontrmodopalabra.getInternalname(), "Values", cmbavLiqcontrmodopalabra.ToJavascriptSource(), true);
      }
      if ( cmbavLiqotrosmodopalabra.getItemCount() > 0 )
      {
         AV94liqOtrosModoPalabra = cmbavLiqotrosmodopalabra.getValidValue(AV94liqOtrosModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV94liqOtrosModoPalabra", AV94liqOtrosModoPalabra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqotrosmodopalabra.setValue( GXutil.rtrim( AV94liqOtrosModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqotrosmodopalabra.getInternalname(), "Values", cmbavLiqotrosmodopalabra.ToJavascriptSource(), true);
      }
      if ( cmbavLiqrecibosmodopalabra.getItemCount() > 0 )
      {
         AV95liqRecibosModoPalabra = cmbavLiqrecibosmodopalabra.getValidValue(AV95liqRecibosModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV95liqRecibosModoPalabra", AV95liqRecibosModoPalabra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqrecibosmodopalabra.setValue( GXutil.rtrim( AV95liqRecibosModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqrecibosmodopalabra.getInternalname(), "Values", cmbavLiqrecibosmodopalabra.ToJavascriptSource(), true);
      }
      if ( cmbavLiquploadmodopalabra.getItemCount() > 0 )
      {
         AV98liqUploadModoPalabra = cmbavLiquploadmodopalabra.getValidValue(AV98liqUploadModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV98liqUploadModoPalabra", AV98liqUploadModoPalabra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiquploadmodopalabra.setValue( GXutil.rtrim( AV98liqUploadModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiquploadmodopalabra.getInternalname(), "Values", cmbavLiquploadmodopalabra.ToJavascriptSource(), true);
      }
      if ( cmbavLiqpdfmodopalabra.getItemCount() > 0 )
      {
         AV96liqPDFModoPalabra = cmbavLiqpdfmodopalabra.getValidValue(AV96liqPDFModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV96liqPDFModoPalabra", AV96liqPDFModoPalabra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqpdfmodopalabra.setValue( GXutil.rtrim( AV96liqPDFModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqpdfmodopalabra.getInternalname(), "Values", cmbavLiqpdfmodopalabra.ToJavascriptSource(), true);
      }
      if ( cmbavImgas3modopalabra.getItemCount() > 0 )
      {
         AV99ImgAS3ModoPalabra = cmbavImgas3modopalabra.getValidValue(AV99ImgAS3ModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV99ImgAS3ModoPalabra", AV99ImgAS3ModoPalabra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavImgas3modopalabra.setValue( GXutil.rtrim( AV99ImgAS3ModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavImgas3modopalabra.getInternalname(), "Values", cmbavImgas3modopalabra.ToJavascriptSource(), true);
      }
      AV79lambda_desgloce = GXutil.strtobool( GXutil.booltostr( AV79lambda_desgloce)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79lambda_desgloce", AV79lambda_desgloce);
      if ( cmbavMetodoinvocapdf.getItemCount() > 0 )
      {
         AV88metodoInvocaPDF = cmbavMetodoinvocapdf.getValidValue(AV88metodoInvocaPDF) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV88metodoInvocaPDF", AV88metodoInvocaPDF);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavMetodoinvocapdf.setValue( GXutil.rtrim( AV88metodoInvocaPDF) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMetodoinvocapdf.getInternalname(), "Values", cmbavMetodoinvocapdf.ToJavascriptSource(), true);
      }
      if ( cmbavFlujo_gen_rec.getItemCount() > 0 )
      {
         AV89flujo_gen_rec = cmbavFlujo_gen_rec.getValidValue(AV89flujo_gen_rec) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV89flujo_gen_rec", AV89flujo_gen_rec);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavFlujo_gen_rec.setValue( GXutil.rtrim( AV89flujo_gen_rec) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavFlujo_gen_rec.getInternalname(), "Values", cmbavFlujo_gen_rec.ToJavascriptSource(), true);
      }
      AV90grabarHtmlReciboDB = GXutil.strtobool( GXutil.booltostr( AV90grabarHtmlReciboDB)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV90grabarHtmlReciboDB", AV90grabarHtmlReciboDB);
      AV55modoAhorroS3 = GXutil.strtobool( GXutil.booltostr( AV55modoAhorroS3)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55modoAhorroS3", AV55modoAhorroS3);
      if ( cmbavNiveldebug.getItemCount() > 0 )
      {
         AV68nivelDebug = cmbavNiveldebug.getValidValue(AV68nivelDebug) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV68nivelDebug", AV68nivelDebug);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavNiveldebug.setValue( GXutil.rtrim( AV68nivelDebug) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavNiveldebug.getInternalname(), "Values", cmbavNiveldebug.ToJavascriptSource(), true);
      }
      AV86s3_Gx_Es = GXutil.strtobool( GXutil.booltostr( AV86s3_Gx_Es)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV86s3_Gx_Es", AV86s3_Gx_Es);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfMK2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV105Pgmname = "ParametrosBackend" ;
      Gx_err = (short)(0) ;
   }

   public void rfMK2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid1Container.ClearRows();
      }
      wbStart = (short)(270) ;
      /* Execute user event: Refresh */
      e15MK2 ();
      nGXsfl_270_idx = 1 ;
      sGXsfl_270_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_270_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2702( ) ;
      bGXsfl_270_Refreshing = true ;
      Grid1Container.AddObjectProperty("GridName", "Grid1");
      Grid1Container.AddObjectProperty("CmpContext", "");
      Grid1Container.AddObjectProperty("InMasterPage", "false");
      Grid1Container.AddObjectProperty("Class", "WorkWith");
      Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Grid1Container.setPageSize( subgrid1_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2702( ) ;
         GXPagingFrom2 = (int)(((subGrid1_Rows==0) ? 0 : GRID1_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid1_Rows==0) ? 10000 : subgrid1_fnc_recordsperpage( )+1) ;
         /* Using cursor H00MK2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV7CliCod), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_270_idx = 1 ;
         sGXsfl_270_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_270_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2702( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid1_Rows == 0 ) || ( GRID1_nCurrentRecord < subgrid1_fnc_recordsperpage( ) ) ) ) )
         {
            A3CliCod = H00MK2_A3CliCod[0] ;
            A340TliqDesc = H00MK2_A340TliqDesc[0] ;
            A32TLiqCod = H00MK2_A32TLiqCod[0] ;
            e16MK2 ();
            pr_default.readNext(0);
         }
         GRID1_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(270) ;
         wbMK0( ) ;
      }
      bGXsfl_270_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesMK2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV105Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV105Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_TLIQCOD"+"_"+sGXsfl_270_idx, getSecureSignedToken( sGXsfl_270_idx, GXutil.rtrim( localUtil.format( A32TLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_TLIQDESC"+"_"+sGXsfl_270_idx, getSecureSignedToken( sGXsfl_270_idx, GXutil.rtrim( localUtil.format( A340TliqDesc, "@!"))));
   }

   public int subgrid1_fnc_pagecount( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( ((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID1_nRecordCount/ (double) (subgrid1_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID1_nRecordCount/ (double) (subgrid1_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid1_fnc_recordcount( )
   {
      /* Using cursor H00MK3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV7CliCod)});
      GRID1_nRecordCount = H00MK3_AGRID1_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID1_nRecordCount) ;
   }

   public int subgrid1_fnc_recordsperpage( )
   {
      if ( subGrid1_Rows > 0 )
      {
         return subGrid1_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid1_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRID1_nFirstRecordOnPage/ (double) (subgrid1_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid1_firstpage( )
   {
      GRID1_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV7CliCod, AV43sdt_tipo_liqs, AV52modoTest, AV47a3lutilitiesEsDocker, AV61scrapeCuil, AV60liquidarAuxParalelos, AV79lambda_desgloce, AV90grabarHtmlReciboDB, AV55modoAhorroS3, AV86s3_Gx_Es, AV105Pgmname, AV46MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid1_nextpage( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( ( GRID1_nRecordCount >= subgrid1_fnc_recordsperpage( ) ) && ( GRID1_nEOF == 0 ) )
      {
         GRID1_nFirstRecordOnPage = (long)(GRID1_nFirstRecordOnPage+subgrid1_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("GRID1_nFirstRecordOnPage", GRID1_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV7CliCod, AV43sdt_tipo_liqs, AV52modoTest, AV47a3lutilitiesEsDocker, AV61scrapeCuil, AV60liquidarAuxParalelos, AV79lambda_desgloce, AV90grabarHtmlReciboDB, AV55modoAhorroS3, AV86s3_Gx_Es, AV105Pgmname, AV46MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID1_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid1_previouspage( )
   {
      if ( GRID1_nFirstRecordOnPage >= subgrid1_fnc_recordsperpage( ) )
      {
         GRID1_nFirstRecordOnPage = (long)(GRID1_nFirstRecordOnPage-subgrid1_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV7CliCod, AV43sdt_tipo_liqs, AV52modoTest, AV47a3lutilitiesEsDocker, AV61scrapeCuil, AV60liquidarAuxParalelos, AV79lambda_desgloce, AV90grabarHtmlReciboDB, AV55modoAhorroS3, AV86s3_Gx_Es, AV105Pgmname, AV46MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid1_lastpage( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( GRID1_nRecordCount > subgrid1_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( )))) == 0 )
         {
            GRID1_nFirstRecordOnPage = (long)(GRID1_nRecordCount-subgrid1_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID1_nFirstRecordOnPage = (long)(GRID1_nRecordCount-((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID1_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV7CliCod, AV43sdt_tipo_liqs, AV52modoTest, AV47a3lutilitiesEsDocker, AV61scrapeCuil, AV60liquidarAuxParalelos, AV79lambda_desgloce, AV90grabarHtmlReciboDB, AV55modoAhorroS3, AV86s3_Gx_Es, AV105Pgmname, AV46MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid1_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID1_nFirstRecordOnPage = (long)(subgrid1_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID1_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV7CliCod, AV43sdt_tipo_liqs, AV52modoTest, AV47a3lutilitiesEsDocker, AV61scrapeCuil, AV60liquidarAuxParalelos, AV79lambda_desgloce, AV90grabarHtmlReciboDB, AV55modoAhorroS3, AV86s3_Gx_Es, AV105Pgmname, AV46MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV105Pgmname = "ParametrosBackend" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupMK0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e14MK2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_270 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_270"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID1_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID1_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID1_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID1_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid1_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID1_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
         Grid1_empowerer_Gridinternalname = httpContext.cgiGet( "GRID1_EMPOWERER_Gridinternalname") ;
         /* Read variables values. */
         AV52modoTest = GXutil.strtobool( httpContext.cgiGet( chkavModotest.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52modoTest", AV52modoTest);
         AV47a3lutilitiesEsDocker = GXutil.strtobool( httpContext.cgiGet( chkavA3lutilitiesesdocker.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47a3lutilitiesEsDocker", AV47a3lutilitiesEsDocker);
         AV61scrapeCuil = GXutil.strtobool( httpContext.cgiGet( chkavScrapecuil.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV61scrapeCuil", AV61scrapeCuil);
         AV48a3lutilitiesHost = httpContext.cgiGet( edtavA3lutilitieshost_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48a3lutilitiesHost", AV48a3lutilitiesHost);
         AV63nodeBaseUrl = httpContext.cgiGet( edtavNodebaseurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV63nodeBaseUrl", AV63nodeBaseUrl);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavHtmlapdf_puerto_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavHtmlapdf_puerto_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vHTMLAPDF_PUERTO");
            GX_FocusControl = edtavHtmlapdf_puerto_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV49htmlapdf_puerto = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49htmlapdf_puerto", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49htmlapdf_puerto), 8, 0));
         }
         else
         {
            AV49htmlapdf_puerto = (int)(localUtil.ctol( httpContext.cgiGet( edtavHtmlapdf_puerto_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49htmlapdf_puerto", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49htmlapdf_puerto), 8, 0));
         }
         AV60liquidarAuxParalelos = GXutil.strtobool( httpContext.cgiGet( chkavLiquidarauxparalelos.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV60liquidarAuxParalelos", AV60liquidarAuxParalelos);
         AV56conceptos_aux_Metodo = httpContext.cgiGet( edtavConceptos_aux_metodo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56conceptos_aux_Metodo", AV56conceptos_aux_Metodo);
         cmbavAuto_imprimir_pdfliqleg.setName( cmbavAuto_imprimir_pdfliqleg.getInternalname() );
         cmbavAuto_imprimir_pdfliqleg.setValue( httpContext.cgiGet( cmbavAuto_imprimir_pdfliqleg.getInternalname()) );
         AV54auto_imprimir_PDFLiqLeg = httpContext.cgiGet( cmbavAuto_imprimir_pdfliqleg.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV54auto_imprimir_PDFLiqLeg", AV54auto_imprimir_PDFLiqLeg);
         cmbavPdf_automatico_estilo.setName( cmbavPdf_automatico_estilo.getInternalname() );
         cmbavPdf_automatico_estilo.setValue( httpContext.cgiGet( cmbavPdf_automatico_estilo.getInternalname()) );
         AV64pdf_automatico_estilo = httpContext.cgiGet( cmbavPdf_automatico_estilo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64pdf_automatico_estilo", AV64pdf_automatico_estilo);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCantlegporloteliq_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCantlegporloteliq_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCANTLEGPORLOTELIQ");
            GX_FocusControl = edtavCantlegporloteliq_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV66cantLegPorLoteLiq = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66cantLegPorLoteLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66cantLegPorLoteLiq), 4, 0));
         }
         else
         {
            AV66cantLegPorLoteLiq = (short)(localUtil.ctol( httpContext.cgiGet( edtavCantlegporloteliq_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66cantLegPorLoteLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66cantLegPorLoteLiq), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCantloteporliq_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCantloteporliq_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCANTLOTEPORLIQ");
            GX_FocusControl = edtavCantloteporliq_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV65cantLotePorLiq = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65cantLotePorLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65cantLotePorLiq), 4, 0));
         }
         else
         {
            AV65cantLotePorLiq = (short)(localUtil.ctol( httpContext.cgiGet( edtavCantloteporliq_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65cantLotePorLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65cantLotePorLiq), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCantlotpdfporlote_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCantlotpdfporlote_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCANTLOTPDFPORLOTE");
            GX_FocusControl = edtavCantlotpdfporlote_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV91cantLotPDFPorLote = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91cantLotPDFPorLote", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV91cantLotPDFPorLote), 4, 0));
         }
         else
         {
            AV91cantLotPDFPorLote = (short)(localUtil.ctol( httpContext.cgiGet( edtavCantlotpdfporlote_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91cantLotPDFPorLote", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV91cantLotPDFPorLote), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCantreplicasprocesos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCantreplicasprocesos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCANTREPLICASPROCESOS");
            GX_FocusControl = edtavCantreplicasprocesos_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV67cantReplicasProcesos = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67cantReplicasProcesos", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67cantReplicasProcesos), 4, 0));
         }
         else
         {
            AV67cantReplicasProcesos = (short)(localUtil.ctol( httpContext.cgiGet( edtavCantreplicasprocesos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67cantReplicasProcesos", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67cantReplicasProcesos), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSegundosesperaporlegajo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSegundosesperaporlegajo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSEGUNDOSESPERAPORLEGAJO");
            GX_FocusControl = edtavSegundosesperaporlegajo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV78segundosEsperaPorLegajo = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78segundosEsperaPorLegajo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78segundosEsperaPorLegajo), 4, 0));
         }
         else
         {
            AV78segundosEsperaPorLegajo = (short)(localUtil.ctol( httpContext.cgiGet( edtavSegundosesperaporlegajo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78segundosEsperaPorLegajo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78segundosEsperaPorLegajo), 4, 0));
         }
         cmbavLiqprinmodopalabra.setName( cmbavLiqprinmodopalabra.getInternalname() );
         cmbavLiqprinmodopalabra.setValue( httpContext.cgiGet( cmbavLiqprinmodopalabra.getInternalname()) );
         AV92liqPrinModoPalabra = httpContext.cgiGet( cmbavLiqprinmodopalabra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV92liqPrinModoPalabra", AV92liqPrinModoPalabra);
         cmbavLiqlsdmodopalabra.setName( cmbavLiqlsdmodopalabra.getInternalname() );
         cmbavLiqlsdmodopalabra.setValue( httpContext.cgiGet( cmbavLiqlsdmodopalabra.getInternalname()) );
         AV93liqLSDModoPalabra = httpContext.cgiGet( cmbavLiqlsdmodopalabra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV93liqLSDModoPalabra", AV93liqLSDModoPalabra);
         cmbavLiqcontrmodopalabra.setName( cmbavLiqcontrmodopalabra.getInternalname() );
         cmbavLiqcontrmodopalabra.setValue( httpContext.cgiGet( cmbavLiqcontrmodopalabra.getInternalname()) );
         AV97liqContrModoPalabra = httpContext.cgiGet( cmbavLiqcontrmodopalabra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV97liqContrModoPalabra", AV97liqContrModoPalabra);
         cmbavLiqotrosmodopalabra.setName( cmbavLiqotrosmodopalabra.getInternalname() );
         cmbavLiqotrosmodopalabra.setValue( httpContext.cgiGet( cmbavLiqotrosmodopalabra.getInternalname()) );
         AV94liqOtrosModoPalabra = httpContext.cgiGet( cmbavLiqotrosmodopalabra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV94liqOtrosModoPalabra", AV94liqOtrosModoPalabra);
         cmbavLiqrecibosmodopalabra.setName( cmbavLiqrecibosmodopalabra.getInternalname() );
         cmbavLiqrecibosmodopalabra.setValue( httpContext.cgiGet( cmbavLiqrecibosmodopalabra.getInternalname()) );
         AV95liqRecibosModoPalabra = httpContext.cgiGet( cmbavLiqrecibosmodopalabra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV95liqRecibosModoPalabra", AV95liqRecibosModoPalabra);
         cmbavLiquploadmodopalabra.setName( cmbavLiquploadmodopalabra.getInternalname() );
         cmbavLiquploadmodopalabra.setValue( httpContext.cgiGet( cmbavLiquploadmodopalabra.getInternalname()) );
         AV98liqUploadModoPalabra = httpContext.cgiGet( cmbavLiquploadmodopalabra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV98liqUploadModoPalabra", AV98liqUploadModoPalabra);
         cmbavLiqpdfmodopalabra.setName( cmbavLiqpdfmodopalabra.getInternalname() );
         cmbavLiqpdfmodopalabra.setValue( httpContext.cgiGet( cmbavLiqpdfmodopalabra.getInternalname()) );
         AV96liqPDFModoPalabra = httpContext.cgiGet( cmbavLiqpdfmodopalabra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV96liqPDFModoPalabra", AV96liqPDFModoPalabra);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavMax_pdf_paralelos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavMax_pdf_paralelos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vMAX_PDF_PARALELOS");
            GX_FocusControl = edtavMax_pdf_paralelos_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV102MAX_PDF_PARALELOS = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV102MAX_PDF_PARALELOS", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV102MAX_PDF_PARALELOS), 4, 0));
         }
         else
         {
            AV102MAX_PDF_PARALELOS = (short)(localUtil.ctol( httpContext.cgiGet( edtavMax_pdf_paralelos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV102MAX_PDF_PARALELOS", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV102MAX_PDF_PARALELOS), 4, 0));
         }
         cmbavImgas3modopalabra.setName( cmbavImgas3modopalabra.getInternalname() );
         cmbavImgas3modopalabra.setValue( httpContext.cgiGet( cmbavImgas3modopalabra.getInternalname()) );
         AV99ImgAS3ModoPalabra = httpContext.cgiGet( cmbavImgas3modopalabra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV99ImgAS3ModoPalabra", AV99ImgAS3ModoPalabra);
         AV79lambda_desgloce = GXutil.strtobool( httpContext.cgiGet( chkavLambda_desgloce.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV79lambda_desgloce", AV79lambda_desgloce);
         AV75url_sqs_CalcLiqTodo = httpContext.cgiGet( edtavUrl_sqs_calcliqtodo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75url_sqs_CalcLiqTodo", AV75url_sqs_CalcLiqTodo);
         AV80url_sqs_DEPLSD = httpContext.cgiGet( edtavUrl_sqs_deplsd_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV80url_sqs_DEPLSD", AV80url_sqs_DEPLSD);
         AV81url_sqs_contr = httpContext.cgiGet( edtavUrl_sqs_contr_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV81url_sqs_contr", AV81url_sqs_contr);
         AV82url_sqs_otr = httpContext.cgiGet( edtavUrl_sqs_otr_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV82url_sqs_otr", AV82url_sqs_otr);
         AV77url_sqs_GenerarRecibos = httpContext.cgiGet( edtavUrl_sqs_generarrecibos_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV77url_sqs_GenerarRecibos", AV77url_sqs_GenerarRecibos);
         AV100url_sqs_generarPDF = httpContext.cgiGet( edtavUrl_sqs_generarpdf_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV100url_sqs_generarPDF", AV100url_sqs_generarPDF);
         AV87url_sqs_uploadFilesS3 = httpContext.cgiGet( edtavUrl_sqs_uploadfiless3_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV87url_sqs_uploadFilesS3", AV87url_sqs_uploadFilesS3);
         AV83eventBr_detType_genRecibo = httpContext.cgiGet( edtavEventbr_dettype_genrecibo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV83eventBr_detType_genRecibo", AV83eventBr_detType_genRecibo);
         AV84eventBr_source_genRecibo = httpContext.cgiGet( edtavEventbr_source_genrecibo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV84eventBr_source_genRecibo", AV84eventBr_source_genRecibo);
         cmbavMetodoinvocapdf.setName( cmbavMetodoinvocapdf.getInternalname() );
         cmbavMetodoinvocapdf.setValue( httpContext.cgiGet( cmbavMetodoinvocapdf.getInternalname()) );
         AV88metodoInvocaPDF = httpContext.cgiGet( cmbavMetodoinvocapdf.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV88metodoInvocaPDF", AV88metodoInvocaPDF);
         cmbavFlujo_gen_rec.setName( cmbavFlujo_gen_rec.getInternalname() );
         cmbavFlujo_gen_rec.setValue( httpContext.cgiGet( cmbavFlujo_gen_rec.getInternalname()) );
         AV89flujo_gen_rec = httpContext.cgiGet( cmbavFlujo_gen_rec.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV89flujo_gen_rec", AV89flujo_gen_rec);
         AV90grabarHtmlReciboDB = GXutil.strtobool( httpContext.cgiGet( chkavGrabarhtmlrecibodb.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV90grabarHtmlReciboDB", AV90grabarHtmlReciboDB);
         AV55modoAhorroS3 = GXutil.strtobool( httpContext.cgiGet( chkavModoahorros3.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55modoAhorroS3", AV55modoAhorroS3);
         AV57bucketName = httpContext.cgiGet( edtavBucketname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV57bucketName", AV57bucketName);
         AV58bucketNamePDF = httpContext.cgiGet( edtavBucketnamepdf_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV58bucketNamePDF", AV58bucketNamePDF);
         cmbavNiveldebug.setName( cmbavNiveldebug.getInternalname() );
         cmbavNiveldebug.setValue( httpContext.cgiGet( cmbavNiveldebug.getInternalname()) );
         AV68nivelDebug = httpContext.cgiGet( cmbavNiveldebug.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV68nivelDebug", AV68nivelDebug);
         AV70grossigup_Concepto = httpContext.cgiGet( edtavGrossigup_concepto_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV70grossigup_Concepto", AV70grossigup_Concepto);
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavMargennetogrossing_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavMargennetogrossing_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vMARGENNETOGROSSING");
            GX_FocusControl = edtavMargennetogrossing_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV71margenNetoGrossing = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71margenNetoGrossing", GXutil.ltrimstr( AV71margenNetoGrossing, 6, 4));
         }
         else
         {
            AV71margenNetoGrossing = localUtil.ctond( httpContext.cgiGet( edtavMargennetogrossing_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71margenNetoGrossing", GXutil.ltrimstr( AV71margenNetoGrossing, 6, 4));
         }
         AV72grossigup_Excluir = httpContext.cgiGet( edtavGrossigup_excluir_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV72grossigup_Excluir", AV72grossigup_Excluir);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavGrossigup_maxintent_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavGrossigup_maxintent_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vGROSSIGUP_MAXINTENT");
            GX_FocusControl = edtavGrossigup_maxintent_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV73grossigup_maxIntent = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73grossigup_maxIntent", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV73grossigup_maxIntent), 4, 0));
         }
         else
         {
            AV73grossigup_maxIntent = (short)(localUtil.ctol( httpContext.cgiGet( edtavGrossigup_maxintent_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73grossigup_maxIntent", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV73grossigup_maxIntent), 4, 0));
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavGrossigup_multiplicador_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavGrossigup_multiplicador_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vGROSSIGUP_MULTIPLICADOR");
            GX_FocusControl = edtavGrossigup_multiplicador_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV74grossigup_Multiplicador = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74grossigup_Multiplicador", GXutil.ltrimstr( AV74grossigup_Multiplicador, 6, 4));
         }
         else
         {
            AV74grossigup_Multiplicador = localUtil.ctond( httpContext.cgiGet( edtavGrossigup_multiplicador_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74grossigup_Multiplicador", GXutil.ltrimstr( AV74grossigup_Multiplicador, 6, 4));
         }
         AV53auto_imprimir_PDFLiq = httpContext.cgiGet( edtavAuto_imprimir_pdfliq_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV53auto_imprimir_PDFLiq", AV53auto_imprimir_PDFLiq);
         AV85liqModo = httpContext.cgiGet( edtavLiqmodo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV85liqModo", AV85liqModo);
         AV86s3_Gx_Es = GXutil.strtobool( httpContext.cgiGet( chkavS3_gx_es.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV86s3_Gx_Es", AV86s3_Gx_Es);
         AV76url_sqs_CalcLiqSecundarios = httpContext.cgiGet( edtavUrl_sqs_calcliqsecundarios_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76url_sqs_CalcLiqSecundarios", AV76url_sqs_CalcLiqSecundarios);
         AV59hostNodePublico = httpContext.cgiGet( edtavHostnodepublico_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59hostNodePublico", AV59hostNodePublico);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e14MK2 ();
      if (returnInSub) return;
   }

   public void e14MK2( )
   {
      /* Start Routine */
      returnInSub = false ;
      lblLinkrestconexiones_Link = formatLink("web.rest_locationww", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "Conexiones REST", "")))}, new String[] {"MenuOpcCod"})  ;
      httpContext.ajax_rsp_assign_prop("", false, lblLinkrestconexiones_Internalname, "Link", lblLinkrestconexiones_Link, true);
      new web.setopcionmenusesion(remoteHandle, context).execute( AV46MenuOpcCod, "", "") ;
      GXt_int1 = AV7CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      parametrosbackend_impl.this.GXt_int1 = GXv_int2[0] ;
      AV7CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      edtavAuto_imprimir_pdfliq_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAuto_imprimir_pdfliq_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuto_imprimir_pdfliq_Visible), 5, 0), true);
      edtavLiqmodo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqmodo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqmodo_Visible), 5, 0), true);
      chkavS3_gx_es.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavS3_gx_es.getInternalname(), "Visible", GXutil.ltrimstr( chkavS3_gx_es.getVisible(), 5, 0), true);
      edtavUrl_sqs_calcliqsecundarios_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUrl_sqs_calcliqsecundarios_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrl_sqs_calcliqsecundarios_Visible), 5, 0), true);
      edtavHostnodepublico_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavHostnodepublico_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavHostnodepublico_Visible), 5, 0), true);
      Grid1_empowerer_Gridinternalname = subGrid1_Internalname ;
      ucGrid1_empowerer.sendProperty(context, "", false, Grid1_empowerer_Internalname, "GridInternalName", Grid1_empowerer_Gridinternalname);
      subGrid1_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
      GXt_char3 = AV92liqPrinModoPalabra ;
      GXt_char4 = AV92liqPrinModoPalabra ;
      GXv_char5[0] = GXt_char4 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_prin", GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      GXv_char6[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char4, GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      AV92liqPrinModoPalabra = GXt_char3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV92liqPrinModoPalabra", AV92liqPrinModoPalabra);
      GXt_char4 = AV93liqLSDModoPalabra ;
      GXt_char3 = AV93liqLSDModoPalabra ;
      GXv_char6[0] = GXt_char3 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_lsd", GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV93liqLSDModoPalabra = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV93liqLSDModoPalabra", AV93liqLSDModoPalabra);
      GXt_char4 = AV97liqContrModoPalabra ;
      GXt_char3 = AV97liqContrModoPalabra ;
      GXv_char6[0] = GXt_char3 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_contr", GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV97liqContrModoPalabra = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV97liqContrModoPalabra", AV97liqContrModoPalabra);
      GXt_char4 = AV94liqOtrosModoPalabra ;
      GXt_char3 = AV94liqOtrosModoPalabra ;
      GXv_char6[0] = GXt_char3 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_otros", GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV94liqOtrosModoPalabra = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV94liqOtrosModoPalabra", AV94liqOtrosModoPalabra);
      GXt_char4 = AV95liqRecibosModoPalabra ;
      GXt_char3 = AV95liqRecibosModoPalabra ;
      GXv_char6[0] = GXt_char3 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_recibos", GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV95liqRecibosModoPalabra = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV95liqRecibosModoPalabra", AV95liqRecibosModoPalabra);
      GXt_char4 = AV98liqUploadModoPalabra ;
      GXt_char3 = AV98liqUploadModoPalabra ;
      GXv_char6[0] = GXt_char3 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_upload_html", GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV98liqUploadModoPalabra = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV98liqUploadModoPalabra", AV98liqUploadModoPalabra);
      GXt_char4 = AV96liqPDFModoPalabra ;
      GXt_char3 = AV96liqPDFModoPalabra ;
      GXv_char6[0] = GXt_char3 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_pdf", GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV96liqPDFModoPalabra = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV96liqPDFModoPalabra", AV96liqPDFModoPalabra);
      GXt_char4 = AV99ImgAS3ModoPalabra ;
      GXt_char3 = AV99ImgAS3ModoPalabra ;
      GXv_char6[0] = GXt_char3 ;
      new web.uploadimgas3_modo_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV99ImgAS3ModoPalabra = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV99ImgAS3ModoPalabra", AV99ImgAS3ModoPalabra);
      GXt_char4 = AV85liqModo ;
      GXt_char3 = AV85liqModo ;
      GXv_char6[0] = GXt_char3 ;
      new web.liq_modo_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV85liqModo = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV85liqModo", AV85liqModo);
      /* Execute user subroutine: 'LAMBDA VISIBLE' */
      S122 ();
      if (returnInSub) return;
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.s3gxes_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV86s3_Gx_Es = GXutil.boolval( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV86s3_Gx_Es", AV86s3_Gx_Es);
      GXt_char4 = AV87url_sqs_uploadFilesS3 ;
      GXt_char3 = AV87url_sqs_uploadFilesS3 ;
      GXv_char6[0] = GXt_char3 ;
      new web.url_sqs_uploadfiless3_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV87url_sqs_uploadFilesS3 = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV87url_sqs_uploadFilesS3", AV87url_sqs_uploadFilesS3);
      GXt_char4 = AV100url_sqs_generarPDF ;
      GXt_char3 = AV100url_sqs_generarPDF ;
      GXv_char6[0] = GXt_char3 ;
      new web.url_sqs_generarpdf_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV100url_sqs_generarPDF = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV100url_sqs_generarPDF", AV100url_sqs_generarPDF);
      GXt_char4 = AV88metodoInvocaPDF ;
      GXt_char3 = AV88metodoInvocaPDF ;
      GXv_char6[0] = GXt_char3 ;
      new web.metodoinvocapdf_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV88metodoInvocaPDF = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV88metodoInvocaPDF", AV88metodoInvocaPDF);
      GXt_char4 = AV89flujo_gen_rec ;
      GXt_char3 = AV89flujo_gen_rec ;
      GXv_char6[0] = GXt_char3 ;
      new web.flujo_gen_rec_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV89flujo_gen_rec = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV89flujo_gen_rec", AV89flujo_gen_rec);
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.lambda_desgloce_codigo(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV79lambda_desgloce = GXutil.boolval( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79lambda_desgloce", AV79lambda_desgloce);
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.max_pdf_paralelos_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV102MAX_PDF_PARALELOS = (short)(GXutil.lval( AV14ParmValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV102MAX_PDF_PARALELOS", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV102MAX_PDF_PARALELOS), 4, 0));
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.cantlegporloteliq_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV66cantLegPorLoteLiq = (short)(GXutil.lval( AV14ParmValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66cantLegPorLoteLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66cantLegPorLoteLiq), 4, 0));
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.cantlotpdfporlote_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV91cantLotPDFPorLote = (short)(GXutil.lval( AV14ParmValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV91cantLotPDFPorLote", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV91cantLotPDFPorLote), 4, 0));
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.cantloteporliq_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV65cantLotePorLiq = (short)(GXutil.lval( AV14ParmValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65cantLotePorLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65cantLotePorLiq), 4, 0));
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.cantreplicasprocesos_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV67cantReplicasProcesos = (short)(GXutil.lval( AV14ParmValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67cantReplicasProcesos", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67cantReplicasProcesos), 4, 0));
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.grabarhtmlrecibodb_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV90grabarHtmlReciboDB = GXutil.boolval( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV90grabarHtmlReciboDB", AV90grabarHtmlReciboDB);
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.scrapecuil_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV61scrapeCuil = GXutil.boolval( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61scrapeCuil", AV61scrapeCuil);
      GXt_char4 = AV68nivelDebug ;
      GXt_char3 = AV68nivelDebug ;
      GXv_char6[0] = GXt_char3 ;
      new web.niveldebug_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV68nivelDebug = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68nivelDebug", AV68nivelDebug);
      GXt_char4 = AV48a3lutilitiesHost ;
      GXt_char3 = AV48a3lutilitiesHost ;
      GXv_char6[0] = GXt_char3 ;
      new web.a3lutilitieshost_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV48a3lutilitiesHost = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48a3lutilitiesHost", AV48a3lutilitiesHost);
      GXt_char4 = AV59hostNodePublico ;
      GXt_char3 = AV59hostNodePublico ;
      GXv_char6[0] = GXt_char3 ;
      new web.hostnodepublico_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV59hostNodePublico = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59hostNodePublico", AV59hostNodePublico);
      GXt_char4 = AV57bucketName ;
      GXt_char3 = AV57bucketName ;
      GXv_char6[0] = GXt_char3 ;
      new web.bucketname_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV57bucketName = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57bucketName", AV57bucketName);
      GXt_char4 = AV58bucketNamePDF ;
      GXt_char3 = AV58bucketNamePDF ;
      GXv_char6[0] = GXt_char3 ;
      new web.bucketnamepdf_codigo(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV58bucketNamePDF = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV58bucketNamePDF", AV58bucketNamePDF);
      GXt_char4 = AV63nodeBaseUrl ;
      GXt_char3 = AV63nodeBaseUrl ;
      GXv_char6[0] = GXt_char3 ;
      new web.nodebaseurl_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV63nodeBaseUrl = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63nodeBaseUrl", AV63nodeBaseUrl);
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.htmlapdf_puerto_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV49htmlapdf_puerto = (int)(GXutil.lval( AV14ParmValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49htmlapdf_puerto", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49htmlapdf_puerto), 8, 0));
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.modotest_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV52modoTest = GXutil.boolval( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52modoTest", AV52modoTest);
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.liquidarauxparalelos_param(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV60liquidarAuxParalelos = GXutil.boolval( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60liquidarAuxParalelos", AV60liquidarAuxParalelos);
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.auto_imprimir_pdfliq_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV53auto_imprimir_PDFLiq = GXutil.trim( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53auto_imprimir_PDFLiq", AV53auto_imprimir_PDFLiq);
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.pdf_automatico_estilo_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV64pdf_automatico_estilo = GXutil.trim( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64pdf_automatico_estilo", AV64pdf_automatico_estilo);
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.auto_imprimir_pdfliqleg_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV54auto_imprimir_PDFLiqLeg = GXutil.trim( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54auto_imprimir_PDFLiqLeg", AV54auto_imprimir_PDFLiqLeg);
      new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, httpContext.getMessage( "&auto_imprimir_PDFLiqLeg \"", "")+AV54auto_imprimir_PDFLiqLeg+"\"") ;
      GXt_char4 = AV14ParmValue ;
      GXt_char3 = AV14ParmValue ;
      GXv_char6[0] = GXt_char3 ;
      new web.modoahorros3_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV14ParmValue = GXt_char4 ;
      AV55modoAhorroS3 = GXutil.boolval( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55modoAhorroS3", AV55modoAhorroS3);
      GXt_char4 = AV56conceptos_aux_Metodo ;
      GXt_char3 = AV56conceptos_aux_Metodo ;
      GXv_char6[0] = GXt_char3 ;
      new web.conceptos_aux_metodo_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV56conceptos_aux_Metodo = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56conceptos_aux_Metodo", AV56conceptos_aux_Metodo);
      new web.gettipoliqshabilitadas(remoteHandle, context).execute( AV7CliCod, true, AV43sdt_tipo_liqs) ;
      chkavTliqhabilitada.setEnabled( 1 );
      httpContext.ajax_rsp_assign_prop("", false, chkavTliqhabilitada.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTliqhabilitada.getEnabled(), 5, 0), !bGXsfl_270_Refreshing);
      GXt_char4 = AV70grossigup_Concepto ;
      GXt_char3 = AV70grossigup_Concepto ;
      GXv_char6[0] = GXt_char3 ;
      new web.grossigup_concepto_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV70grossigup_Concepto = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV70grossigup_Concepto", AV70grossigup_Concepto);
      GXt_char4 = AV72grossigup_Excluir ;
      GXt_char3 = AV72grossigup_Excluir ;
      GXv_char6[0] = GXt_char3 ;
      new web.grossigup_excluir_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      parametrosbackend_impl.this.GXt_char3 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char3, GXv_char5) ;
      parametrosbackend_impl.this.GXt_char4 = GXv_char5[0] ;
      AV72grossigup_Excluir = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72grossigup_Excluir", AV72grossigup_Excluir);
      GXv_char6[0] = AV14ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.grossigup_maxintent_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
      parametrosbackend_impl.this.AV14ParmValue = GXv_char6[0] ;
      AV73grossigup_maxIntent = (short)(GXutil.lval( AV14ParmValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV73grossigup_maxIntent", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV73grossigup_maxIntent), 4, 0));
      GXv_char6[0] = AV14ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.grossigup_multiplicador_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
      parametrosbackend_impl.this.AV14ParmValue = GXv_char6[0] ;
      AV74grossigup_Multiplicador = CommonUtil.decimalVal( AV14ParmValue, ".") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74grossigup_Multiplicador", GXutil.ltrimstr( AV74grossigup_Multiplicador, 6, 4));
      GXv_char6[0] = AV14ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.margennetogrossing_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
      parametrosbackend_impl.this.AV14ParmValue = GXv_char6[0] ;
      AV71margenNetoGrossing = CommonUtil.decimalVal( AV14ParmValue, ".") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71margenNetoGrossing", GXutil.ltrimstr( AV71margenNetoGrossing, 6, 4));
      GXv_char6[0] = AV14ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.segundosesperaporlegajo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
      parametrosbackend_impl.this.AV14ParmValue = GXv_char6[0] ;
      AV78segundosEsperaPorLegajo = (short)(GXutil.lval( AV14ParmValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78segundosEsperaPorLegajo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78segundosEsperaPorLegajo), 4, 0));
      GXv_char6[0] = AV75url_sqs_CalcLiqTodo ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_calcliqtodo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
      parametrosbackend_impl.this.AV75url_sqs_CalcLiqTodo = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV75url_sqs_CalcLiqTodo", AV75url_sqs_CalcLiqTodo);
      GXv_char6[0] = AV76url_sqs_CalcLiqSecundarios ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_calcliqsecundarios_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
      parametrosbackend_impl.this.AV76url_sqs_CalcLiqSecundarios = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76url_sqs_CalcLiqSecundarios", AV76url_sqs_CalcLiqSecundarios);
      GXv_char6[0] = AV77url_sqs_GenerarRecibos ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_generarrecibos_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
      parametrosbackend_impl.this.AV77url_sqs_GenerarRecibos = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77url_sqs_GenerarRecibos", AV77url_sqs_GenerarRecibos);
      GXv_char6[0] = AV80url_sqs_DEPLSD ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_deplsd_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
      parametrosbackend_impl.this.AV80url_sqs_DEPLSD = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV80url_sqs_DEPLSD", AV80url_sqs_DEPLSD);
      GXv_char6[0] = AV81url_sqs_contr ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_contr_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
      parametrosbackend_impl.this.AV81url_sqs_contr = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81url_sqs_contr", AV81url_sqs_contr);
      GXv_char6[0] = AV82url_sqs_otr ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_otr_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
      parametrosbackend_impl.this.AV82url_sqs_otr = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82url_sqs_otr", AV82url_sqs_otr);
      GXv_char6[0] = AV83eventBr_detType_genRecibo ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.eventbr_dettype_genrecibo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
      parametrosbackend_impl.this.AV83eventBr_detType_genRecibo = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV83eventBr_detType_genRecibo", AV83eventBr_detType_genRecibo);
      GXv_char6[0] = AV84eventBr_source_genRecibo ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.eventbr_source_genrecibo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
      parametrosbackend_impl.this.AV84eventBr_source_genRecibo = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV84eventBr_source_genRecibo", AV84eventBr_source_genRecibo);
      /* Execute user subroutine: 'SQS UPLOADFILE VISIBLE' */
      S132 ();
      if (returnInSub) return;
   }

   public void e15MK2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   private void e16MK2( )
   {
      /* Grid1_Load Routine */
      returnInSub = false ;
      AV37TLiqHabilitada = false ;
      httpContext.ajax_rsp_assign_attri("", false, chkavTliqhabilitada.getInternalname(), AV37TLiqHabilitada);
      AV106GXV1 = 1 ;
      while ( AV106GXV1 <= AV43sdt_tipo_liqs.size() )
      {
         AV44item = (web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem)((web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem)AV43sdt_tipo_liqs.elementAt(-1+AV106GXV1));
         if ( GXutil.strcmp(AV44item.getgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod(), A32TLiqCod) == 0 )
         {
            AV37TLiqHabilitada = true ;
            httpContext.ajax_rsp_assign_attri("", false, chkavTliqhabilitada.getInternalname(), AV37TLiqHabilitada);
            if (true) break;
         }
         AV106GXV1 = (int)(AV106GXV1+1) ;
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(270) ;
      }
      sendrow_2702( ) ;
      GRID1_nCurrentRecord = (long)(GRID1_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_270_Refreshing )
      {
         httpContext.doAjaxLoad(270, Grid1Row);
      }
      /*  Sending Event outputs  */
   }

   public void e11MK2( )
   {
      /* 'DoConfirmar' Routine */
      returnInSub = false ;
      AV101ok = true ;
      if ( ( AV90grabarHtmlReciboDB ) && ( GXutil.strcmp(AV88metodoInvocaPDF, httpContext.getMessage( "TRIGGER", "")) == 0 ) )
      {
         AV101ok = false ;
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "\"Grabar html de recibo en base de datos\" no es compatible con el método e invocación \"Trigger lambda desde S3\"", "")) ;
      }
      if ( AV101ok )
      {
         if ( ( GXutil.strcmp(AV53auto_imprimir_PDFLiq, httpContext.getMessage( "TODO", "")) == 0 ) && ( GXutil.strcmp(AV88metodoInvocaPDF, httpContext.getMessage( "TRIGGER", "")) == 0 ) )
         {
            new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Pdfs en modo \"Todo\" (genera html y pdf de una vez), no es compatible con \"Trigger lambda desde S3\"", "")) ;
         }
         else
         {
            if ( ( GXutil.strcmp(AV53auto_imprimir_PDFLiq, httpContext.getMessage( "MASIVO", "")) == 0 ) && ( GXutil.strcmp(AV88metodoInvocaPDF, httpContext.getMessage( "ASINCRONO", "")) == 0 ) )
            {
               new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Pdfs en modo \"Masivo\", no es compatible con \"Asincrono\"", "")) ;
            }
            else
            {
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.s3gxes_codigoparam(remoteHandle, context).executeUdp( ), GXutil.booltostr( AV86s3_Gx_Es), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_uploadfiless3_codigoparam(remoteHandle, context).executeUdp( ), AV87url_sqs_uploadFilesS3, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_generarpdf_codigoparam(remoteHandle, context).executeUdp( ), AV100url_sqs_generarPDF, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.metodoinvocapdf_codigoparam(remoteHandle, context).executeUdp( ), AV88metodoInvocaPDF, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.liq_modo_codigoparam(remoteHandle, context).executeUdp( ), AV85liqModo, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.liq_modo2_codigoparam(remoteHandle, context).executeUdp( "liq_modo_prin"), AV92liqPrinModoPalabra, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.liq_modo2_codigoparam(remoteHandle, context).executeUdp( "liq_modo_lsd"), AV93liqLSDModoPalabra, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.liq_modo2_codigoparam(remoteHandle, context).executeUdp( "liq_modo_contr"), AV97liqContrModoPalabra, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.liq_modo2_codigoparam(remoteHandle, context).executeUdp( "liq_modo_otros"), AV94liqOtrosModoPalabra, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.liq_modo2_codigoparam(remoteHandle, context).executeUdp( "liq_modo_recibos"), AV95liqRecibosModoPalabra, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.liq_modo2_codigoparam(remoteHandle, context).executeUdp( "liq_modo_upload_html"), AV98liqUploadModoPalabra, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.liq_modo2_codigoparam(remoteHandle, context).executeUdp( "liq_modo_pdf"), AV96liqPDFModoPalabra, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.uploadimgas3_modo_codigoparam(remoteHandle, context).executeUdp( ), AV99ImgAS3ModoPalabra, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.eventbr_source_genrecibo_codigoparam(remoteHandle, context).executeUdp( ), AV84eventBr_source_genRecibo, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.eventbr_dettype_genrecibo_codigoparam(remoteHandle, context).executeUdp( ), AV83eventBr_detType_genRecibo, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_deplsd_codigoparam(remoteHandle, context).executeUdp( ), AV80url_sqs_DEPLSD, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_contr_codigoparam(remoteHandle, context).executeUdp( ), AV81url_sqs_contr, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_otr_codigoparam(remoteHandle, context).executeUdp( ), AV82url_sqs_otr, "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.lambda_desgloce_codigo(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.booltostr( AV79lambda_desgloce)), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.max_pdf_paralelos_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.str( AV102MAX_PDF_PARALELOS, 4, 0)), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.cantlegporloteliq_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.str( AV66cantLegPorLoteLiq, 4, 0)), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.cantlotpdfporlote_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.str( AV91cantLotPDFPorLote, 4, 0)), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.cantloteporliq_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.str( AV65cantLotePorLiq, 4, 0)), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.cantreplicasprocesos_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.str( AV67cantReplicasProcesos, 4, 0)), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.grabarhtmlrecibodb_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.booltostr( AV90grabarHtmlReciboDB)), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.scrapecuil_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.booltostr( AV61scrapeCuil)), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.a3lutilitieshost_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV48a3lutilitiesHost), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.niveldebug_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV68nivelDebug), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.hostnodepublico_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV59hostNodePublico), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.bucketname_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV57bucketName), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.bucketnamepdf_codigo(remoteHandle, context).executeUdp( ), GXutil.trim( AV58bucketNamePDF), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.nodebaseurl_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV63nodeBaseUrl), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.htmlapdf_puerto_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.str( AV49htmlapdf_puerto, 8, 0)), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.modotest_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.booltostr( AV52modoTest)), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.liquidarauxparalelos_param(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.booltostr( AV60liquidarAuxParalelos)), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.auto_imprimir_pdfliq_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV53auto_imprimir_PDFLiq), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.pdf_automatico_estilo_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV64pdf_automatico_estilo), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.auto_imprimir_pdfliqleg_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV54auto_imprimir_PDFLiqLeg), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.modoahorros3_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.booltostr( AV55modoAhorroS3)), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.conceptos_aux_metodo_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV56conceptos_aux_Metodo), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV105Pgmname, "1") ;
               AV43sdt_tipo_liqs.clear();
               /* Start For Each Line */
               nRC_GXsfl_270 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_270"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               nGXsfl_270_fel_idx = 0 ;
               while ( nGXsfl_270_fel_idx < nRC_GXsfl_270 )
               {
                  nGXsfl_270_fel_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_270_fel_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_270_fel_idx+1) ;
                  sGXsfl_270_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_270_fel_idx), 4, 0), (short)(4), "0") ;
                  subsflControlProps_fel_2702( ) ;
                  A32TLiqCod = httpContext.cgiGet( edtTLiqCod_Internalname) ;
                  A340TliqDesc = GXutil.upper( httpContext.cgiGet( edtTliqDesc_Internalname)) ;
                  AV37TLiqHabilitada = GXutil.strtobool( httpContext.cgiGet( chkavTliqhabilitada.getInternalname())) ;
                  if ( AV37TLiqHabilitada )
                  {
                     AV44item = (web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem)new web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem(remoteHandle, context);
                     AV44item.setgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod( A32TLiqCod );
                     AV44item.setgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc( A340TliqDesc );
                     AV43sdt_tipo_liqs.add(AV44item, 0);
                  }
                  /* End For Each Line */
               }
               if ( nGXsfl_270_fel_idx == 0 )
               {
                  nGXsfl_270_idx = 1 ;
                  sGXsfl_270_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_270_idx), 4, 0), (short)(4), "0") ;
                  subsflControlProps_2702( ) ;
               }
               nGXsfl_270_fel_idx = 1 ;
               new web.actualizartipoliqshabilitada(remoteHandle, context).execute( AV7CliCod, AV43sdt_tipo_liqs) ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.segundosesperaporlegajo_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.str( AV78segundosEsperaPorLegajo, 4, 0)), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.grossigup_concepto_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV70grossigup_Concepto), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.grossigup_excluir_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV72grossigup_Excluir), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.margennetogrossing_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.str( AV71margenNetoGrossing, 6, 4)), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.grossigup_maxintent_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.str( AV73grossigup_maxIntent, 4, 0)), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.grossigup_multiplicador_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.str( AV74grossigup_Multiplicador, 6, 4)), "") ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_calcliqtodo_codigoparam(remoteHandle, context).executeUdp( ), AV75url_sqs_CalcLiqTodo, httpContext.getMessage( "URL SQS Liquidación conceptos principales", "")) ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_calcliqsecundarios_codigoparam(remoteHandle, context).executeUdp( ), AV76url_sqs_CalcLiqSecundarios, httpContext.getMessage( "URL SQS Liquidación conceptos secundarios", "")) ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.url_sqs_generarrecibos_codigoparam(remoteHandle, context).executeUdp( ), AV77url_sqs_GenerarRecibos, httpContext.getMessage( "URL SQS Generar Recibos", "")) ;
               new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.flujo_gen_rec_codigoparam(remoteHandle, context).executeUdp( ), AV89flujo_gen_rec, httpContext.getMessage( "Flujo de generación de recibos", "")) ;
               httpContext.setWebReturnParms(new Object[] {});
               httpContext.setWebReturnParmsMetadata(new Object[] {});
               httpContext.wjLocDisableFrm = (byte)(1) ;
               httpContext.nUserReturn = (byte)(1) ;
               returnInSub = true;
               if (true) return;
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43sdt_tipo_liqs", AV43sdt_tipo_liqs);
   }

   public void e12MK2( )
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

   public void e13MK2( )
   {
      /* 'DoProgramas' Routine */
      returnInSub = false ;
      httpContext.popup(formatLink("web.debugww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0))}, new String[] {"CliCod"}) , new Object[] {});
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
   }

   public void S142( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean7 = AV69TempBoolean ;
      GXv_boolean8[0] = GXt_boolean7 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDebug", GXv_boolean8) ;
      parametrosbackend_impl.this.GXt_boolean7 = GXv_boolean8[0] ;
      AV69TempBoolean = GXt_boolean7 ;
      if ( ! ( AV69TempBoolean ) )
      {
         bttBtnprogramas_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnprogramas_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnprogramas_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( false ) )
      {
         grpUnnamedgroup24_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, grpUnnamedgroup24_Internalname, "Class", grpUnnamedgroup24_Class, true);
      }
      else
      {
         grpUnnamedgroup24_Class = "Group" ;
         httpContext.ajax_rsp_assign_prop("", false, grpUnnamedgroup24_Internalname, "Class", grpUnnamedgroup24_Class, true);
      }
   }

   public void e17MK2( )
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

   public void S122( )
   {
      /* 'LAMBDA VISIBLE' Routine */
      returnInSub = false ;
   }

   public void S132( )
   {
      /* 'SQS UPLOADFILE VISIBLE' Routine */
      returnInSub = false ;
   }

   public void wb_table1_9_MK2( boolean wbgen )
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
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup2_Internalname, httpContext.getMessage( "General", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ParametrosBackend.htm");
         wb_table2_16_MK2( true) ;
      }
      else
      {
         wb_table2_16_MK2( false) ;
      }
      return  ;
   }

   public void wb_table2_16_MK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup4_Internalname, httpContext.getMessage( "Node", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ParametrosBackend.htm");
         wb_table3_35_MK2( true) ;
      }
      else
      {
         wb_table3_35_MK2( false) ;
      }
      return  ;
   }

   public void wb_table3_35_MK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup6_Internalname, httpContext.getMessage( "Proceso Liquidación", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ParametrosBackend.htm");
         wb_table4_54_MK2( true) ;
      }
      else
      {
         wb_table4_54_MK2( false) ;
      }
      return  ;
   }

   public void wb_table4_54_MK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup8_Internalname, httpContext.getMessage( "S3 AWS", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ParametrosBackend.htm");
         wb_table5_232_MK2( true) ;
      }
      else
      {
         wb_table5_232_MK2( false) ;
      }
      return  ;
   }

   public void wb_table5_232_MK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup10_Internalname, httpContext.getMessage( "Logs", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ParametrosBackend.htm");
         wb_table6_251_MK2( true) ;
      }
      else
      {
         wb_table6_251_MK2( false) ;
      }
      return  ;
   }

   public void wb_table6_251_MK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup12_Internalname, httpContext.getMessage( "Liquidación", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ParametrosBackend.htm");
         wb_table7_263_MK2( true) ;
      }
      else
      {
         wb_table7_263_MK2( false) ;
      }
      return  ;
   }

   public void wb_table7_263_MK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 310,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnconfirmar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 270, 3, 0)+","+"null"+");", httpContext.getMessage( "Confirmar", ""), bttBtnconfirmar_Jsonclick, 5, httpContext.getMessage( "Confirmar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCONFIRMAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 312,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancelar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 270, 3, 0)+","+"null"+");", httpContext.getMessage( "Cancelar", ""), bttBtncancelar_Jsonclick, 5, httpContext.getMessage( "Cancelar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCANCELAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_MK2e( true) ;
      }
      else
      {
         wb_table1_9_MK2e( false) ;
      }
   }

   public void wb_table7_263_MK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable11_Internalname, tblUnnamedtable11_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup14_Internalname, httpContext.getMessage( "Tipos de liquidación habilitadas", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ParametrosBackend.htm");
         wb_table8_267_MK2( true) ;
      }
      else
      {
         wb_table8_267_MK2( false) ;
      }
      return  ;
   }

   public void wb_table8_267_MK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup16_Internalname, httpContext.getMessage( "Grossing up", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ParametrosBackend.htm");
         wb_table9_277_MK2( true) ;
      }
      else
      {
         wb_table9_277_MK2( false) ;
      }
      return  ;
   }

   public void wb_table9_277_MK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_263_MK2e( true) ;
      }
      else
      {
         wb_table7_263_MK2e( false) ;
      }
   }

   public void wb_table9_277_MK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable15_Internalname, tblUnnamedtable15_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavGrossigup_concepto_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavGrossigup_concepto_Internalname, httpContext.getMessage( "Concepto Grossing up", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 282,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavGrossigup_concepto_Internalname, GXutil.rtrim( AV70grossigup_Concepto), GXutil.rtrim( localUtil.format( AV70grossigup_Concepto, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,282);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGrossigup_concepto_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavGrossigup_concepto_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavMargennetogrossing_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavMargennetogrossing_Internalname, httpContext.getMessage( "Margen de desvío superior para grossing up", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 287,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavMargennetogrossing_Internalname, GXutil.ltrim( localUtil.ntoc( AV71margenNetoGrossing, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavMargennetogrossing_Enabled!=0) ? localUtil.format( AV71margenNetoGrossing, "9.9999") : localUtil.format( AV71margenNetoGrossing, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,287);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavMargennetogrossing_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavMargennetogrossing_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavGrossigup_excluir_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavGrossigup_excluir_Internalname, httpContext.getMessage( "Conceptos a Excluir de grossing up", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 292,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavGrossigup_excluir_Internalname, AV72grossigup_Excluir, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,292);\"", (short)(0), 1, edtavGrossigup_excluir_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavGrossigup_maxintent_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavGrossigup_maxintent_Internalname, httpContext.getMessage( "Cantidad de iteraciones máximas al calcular grossing up", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 297,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavGrossigup_maxintent_Internalname, GXutil.ltrim( localUtil.ntoc( AV73grossigup_maxIntent, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavGrossigup_maxintent_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV73grossigup_maxIntent), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV73grossigup_maxIntent), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,297);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGrossigup_maxintent_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavGrossigup_maxintent_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavGrossigup_multiplicador_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavGrossigup_multiplicador_Internalname, httpContext.getMessage( "Multiplicador", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 302,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavGrossigup_multiplicador_Internalname, GXutil.ltrim( localUtil.ntoc( AV74grossigup_Multiplicador, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavGrossigup_multiplicador_Enabled!=0) ? localUtil.format( AV74grossigup_Multiplicador, "9.9999") : localUtil.format( AV74grossigup_Multiplicador, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,302);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGrossigup_multiplicador_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavGrossigup_multiplicador_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table9_277_MK2e( true) ;
      }
      else
      {
         wb_table9_277_MK2e( false) ;
      }
   }

   public void wb_table8_267_MK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable13_Internalname, tblUnnamedtable13_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='HasGridEmpowerer'>") ;
         /*  Grid Control  */
         Grid1Container.SetWrapped(nGXWrapped);
         startgridcontrol270( ) ;
      }
      if ( wbEnd == 270 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_270 = (int)(nGXsfl_270_idx-1) ;
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            Grid1Container.AddObjectProperty("GRID1_nEOF", GRID1_nEOF);
            Grid1Container.AddObjectProperty("GRID1_nFirstRecordOnPage", GRID1_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Grid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid1", Grid1Container, subGrid1_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData", Grid1Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData"+"V", Grid1Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid1ContainerData"+"V"+"\" value='"+Grid1Container.GridValuesHidden()+"'/>") ;
            }
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table8_267_MK2e( true) ;
      }
      else
      {
         wb_table8_267_MK2e( false) ;
      }
   }

   public void wb_table6_251_MK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable9_Internalname, tblUnnamedtable9_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavNiveldebug.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavNiveldebug.getInternalname(), httpContext.getMessage( "Nivel de log", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 256,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavNiveldebug, cmbavNiveldebug.getInternalname(), GXutil.rtrim( AV68nivelDebug), 1, cmbavNiveldebug.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavNiveldebug.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,256);\"", "", true, (byte)(0), "HLP_ParametrosBackend.htm");
         cmbavNiveldebug.setValue( GXutil.rtrim( AV68nivelDebug) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavNiveldebug.getInternalname(), "Values", cmbavNiveldebug.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 259,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnprogramas_Internalname, "gx.evt.setGridEvt("+GXutil.str( 270, 3, 0)+","+"null"+");", httpContext.getMessage( "Programas", ""), bttBtnprogramas_Jsonclick, 5, httpContext.getMessage( "Programas", ""), "", StyleString, ClassString, bttBtnprogramas_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOPROGRAMAS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ParametrosBackend.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_251_MK2e( true) ;
      }
      else
      {
         wb_table6_251_MK2e( false) ;
      }
   }

   public void wb_table5_232_MK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable7_Internalname, tblUnnamedtable7_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+chkavModoahorros3.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavModoahorros3.getInternalname(), httpContext.getMessage( "Modo de ahorro para S3 activado", ""), "gx-form-item AttributeCheckBoxLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 237,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavModoahorros3.getInternalname(), GXutil.booltostr( AV55modoAhorroS3), "", httpContext.getMessage( "Modo de ahorro para S3 activado", ""), 1, chkavModoahorros3.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(237, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,237);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavBucketname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavBucketname_Internalname, httpContext.getMessage( "Bucket name imagenes", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 242,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBucketname_Internalname, AV57bucketName, GXutil.rtrim( localUtil.format( AV57bucketName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,242);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBucketname_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavBucketname_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "texto", "left", true, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavBucketnamepdf_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavBucketnamepdf_Internalname, httpContext.getMessage( "Bucket name pdfs", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 247,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBucketnamepdf_Internalname, AV58bucketNamePDF, GXutil.rtrim( localUtil.format( AV58bucketNamePDF, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,247);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBucketnamepdf_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavBucketnamepdf_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "texto", "left", true, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_232_MK2e( true) ;
      }
      else
      {
         wb_table5_232_MK2e( false) ;
      }
   }

   public void wb_table4_54_MK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable5_Internalname, tblUnnamedtable5_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+chkavLiquidarauxparalelos.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavLiquidarauxparalelos.getInternalname(), httpContext.getMessage( "Correr procesos de liquidación de conceptos auxiliares y generación de pdfs inmediatamente después de liquidación", ""), "gx-form-item AttributeCheckBoxLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavLiquidarauxparalelos.getInternalname(), GXutil.booltostr( AV60liquidarAuxParalelos), "", httpContext.getMessage( "Correr procesos de liquidación de conceptos auxiliares y generación de pdfs inmediatamente después de liquidación", ""), 1, chkavLiquidarauxparalelos.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(59, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,59);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavConceptos_aux_metodo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavConceptos_aux_metodo_Internalname, httpContext.getMessage( "Método de ejecución de conceptos auxiliares: CALL o SUBMIT", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavConceptos_aux_metodo_Internalname, AV56conceptos_aux_Metodo, GXutil.rtrim( localUtil.format( AV56conceptos_aux_Metodo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConceptos_aux_metodo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavConceptos_aux_metodo_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "texto", "left", true, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavAuto_imprimir_pdfliqleg.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavAuto_imprimir_pdfliqleg.getInternalname(), httpContext.getMessage( "Generar pdfs de recibo en el proceso de liquidación", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavAuto_imprimir_pdfliqleg, cmbavAuto_imprimir_pdfliqleg.getInternalname(), GXutil.rtrim( AV54auto_imprimir_PDFLiqLeg), 1, cmbavAuto_imprimir_pdfliqleg.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavAuto_imprimir_pdfliqleg.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "", true, (byte)(0), "HLP_ParametrosBackend.htm");
         cmbavAuto_imprimir_pdfliqleg.setValue( GXutil.rtrim( AV54auto_imprimir_PDFLiqLeg) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAuto_imprimir_pdfliqleg.getInternalname(), "Values", cmbavAuto_imprimir_pdfliqleg.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPdf_automatico_estilo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavPdf_automatico_estilo.getInternalname(), httpContext.getMessage( "Estilo de pdf para el proceso de generación automática", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPdf_automatico_estilo, cmbavPdf_automatico_estilo.getInternalname(), GXutil.rtrim( AV64pdf_automatico_estilo), 1, cmbavPdf_automatico_estilo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavPdf_automatico_estilo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "", true, (byte)(0), "HLP_ParametrosBackend.htm");
         cmbavPdf_automatico_estilo.setValue( GXutil.rtrim( AV64pdf_automatico_estilo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPdf_automatico_estilo.getInternalname(), "Values", cmbavPdf_automatico_estilo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavCantlegporloteliq_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavCantlegporloteliq_Internalname, httpContext.getMessage( "Cantidad de legajos por lote en liquidación para procesar en paralelo", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavCantlegporloteliq_Internalname, GXutil.ltrim( localUtil.ntoc( AV66cantLegPorLoteLiq, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCantlegporloteliq_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV66cantLegPorLoteLiq), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV66cantLegPorLoteLiq), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCantlegporloteliq_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavCantlegporloteliq_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavCantloteporliq_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavCantloteporliq_Internalname, httpContext.getMessage( "Cantidad máxima de lotes por liquidación para procesar en paralelo", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavCantloteporliq_Internalname, GXutil.ltrim( localUtil.ntoc( AV65cantLotePorLiq, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCantloteporliq_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV65cantLotePorLiq), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV65cantLotePorLiq), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCantloteporliq_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavCantloteporliq_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavCantlotpdfporlote_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavCantlotpdfporlote_Internalname, httpContext.getMessage( "Cantidad de lotes paralelos de generación de pdfs por lote de liquidación", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavCantlotpdfporlote_Internalname, GXutil.ltrim( localUtil.ntoc( AV91cantLotPDFPorLote, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCantlotpdfporlote_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV91cantLotPDFPorLote), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV91cantLotPDFPorLote), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,89);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCantlotpdfporlote_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavCantlotpdfporlote_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavCantreplicasprocesos_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavCantreplicasprocesos_Internalname, httpContext.getMessage( "Cantidad total de contenedores disponibles", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavCantreplicasprocesos_Internalname, GXutil.ltrim( localUtil.ntoc( AV67cantReplicasProcesos, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCantreplicasprocesos_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV67cantReplicasProcesos), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV67cantReplicasProcesos), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,94);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCantreplicasprocesos_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavCantreplicasprocesos_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavSegundosesperaporlegajo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSegundosesperaporlegajo_Internalname, httpContext.getMessage( "Cantidad límite de segundos de espera de proceso de liquidación por legajo", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSegundosesperaporlegajo_Internalname, GXutil.ltrim( localUtil.ntoc( AV78segundosEsperaPorLegajo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavSegundosesperaporlegajo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV78segundosEsperaPorLegajo), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV78segundosEsperaPorLegajo), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,99);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSegundosesperaporlegajo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSegundosesperaporlegajo_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup18_Internalname, httpContext.getMessage( "Microservicios", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ParametrosBackend.htm");
         wb_table10_103_MK2( true) ;
      }
      else
      {
         wb_table10_103_MK2( false) ;
      }
      return  ;
   }

   public void wb_table10_103_MK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavMetodoinvocapdf.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavMetodoinvocapdf.getInternalname(), httpContext.getMessage( "Método de invocación de servicio de htm a pdf", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 218,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavMetodoinvocapdf, cmbavMetodoinvocapdf.getInternalname(), GXutil.rtrim( AV88metodoInvocaPDF), 1, cmbavMetodoinvocapdf.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavMetodoinvocapdf.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,218);\"", "", true, (byte)(0), "HLP_ParametrosBackend.htm");
         cmbavMetodoinvocapdf.setValue( GXutil.rtrim( AV88metodoInvocaPDF) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMetodoinvocapdf.getInternalname(), "Values", cmbavMetodoinvocapdf.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavFlujo_gen_rec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavFlujo_gen_rec.getInternalname(), httpContext.getMessage( "Flujo de generación de recibos", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 223,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavFlujo_gen_rec, cmbavFlujo_gen_rec.getInternalname(), GXutil.rtrim( AV89flujo_gen_rec), 1, cmbavFlujo_gen_rec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavFlujo_gen_rec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,223);\"", "", true, (byte)(0), "HLP_ParametrosBackend.htm");
         cmbavFlujo_gen_rec.setValue( GXutil.rtrim( AV89flujo_gen_rec) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavFlujo_gen_rec.getInternalname(), "Values", cmbavFlujo_gen_rec.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+chkavGrabarhtmlrecibodb.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavGrabarhtmlrecibodb.getInternalname(), httpContext.getMessage( "Grabar html de recibo en base de datos", ""), "gx-form-item AttributeCheckBoxLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 228,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavGrabarhtmlrecibodb.getInternalname(), GXutil.booltostr( AV90grabarHtmlReciboDB), "", httpContext.getMessage( "Grabar html de recibo en base de datos", ""), 1, chkavGrabarhtmlrecibodb.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(228, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,228);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_54_MK2e( true) ;
      }
      else
      {
         wb_table4_54_MK2e( false) ;
      }
   }

   public void wb_table10_103_MK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable17_Internalname, tblUnnamedtable17_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup20_Internalname, httpContext.getMessage( "Habilitación de Microservicios", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ParametrosBackend.htm");
         wb_table11_107_MK2( true) ;
      }
      else
      {
         wb_table11_107_MK2( false) ;
      }
      return  ;
   }

   public void wb_table11_107_MK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+chkavLambda_desgloce.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavLambda_desgloce.getInternalname(), httpContext.getMessage( "Desglosar ejecución por microservicios separados de conceptos principales, generación de recibos, dependencias lsd, contribuciones, y otros", ""), "gx-form-item AttributeCheckBoxLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 157,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavLambda_desgloce.getInternalname(), GXutil.booltostr( AV79lambda_desgloce), "", httpContext.getMessage( "Desglosar ejecución por microservicios separados de conceptos principales, generación de recibos, dependencias lsd, contribuciones, y otros", ""), 1, chkavLambda_desgloce.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(157, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,157);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblLinkrestconexiones_Internalname, httpContext.getMessage( "Conexiones rest", ""), lblLinkrestconexiones_Link, "", lblLinkrestconexiones_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ParametrosBackend.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup22_Internalname, httpContext.getMessage( "SQS", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ParametrosBackend.htm");
         wb_table12_164_MK2( true) ;
      }
      else
      {
         wb_table12_164_MK2( false) ;
      }
      return  ;
   }

   public void wb_table12_164_MK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup24_Internalname, httpContext.getMessage( "Event bridge", ""), 1, 0, "px", 0, "px", grpUnnamedgroup24_Class, "", "HLP_ParametrosBackend.htm");
         wb_table13_203_MK2( true) ;
      }
      else
      {
         wb_table13_203_MK2( false) ;
      }
      return  ;
   }

   public void wb_table13_203_MK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table10_103_MK2e( true) ;
      }
      else
      {
         wb_table10_103_MK2e( false) ;
      }
   }

   public void wb_table13_203_MK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable23_Internalname, tblUnnamedtable23_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavEventbr_dettype_genrecibo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEventbr_dettype_genrecibo_Internalname, httpContext.getMessage( "Detail Type para regla de ejecución de generación de recibos", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 208,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavEventbr_dettype_genrecibo_Internalname, AV83eventBr_detType_genRecibo, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,208);\"", (short)(0), 1, edtavEventbr_dettype_genrecibo_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavEventbr_source_genrecibo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEventbr_source_genrecibo_Internalname, httpContext.getMessage( "Source para regla de ejecución de generación de recibos", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 213,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavEventbr_source_genrecibo_Internalname, AV84eventBr_source_genRecibo, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,213);\"", (short)(0), 1, edtavEventbr_source_genrecibo_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table13_203_MK2e( true) ;
      }
      else
      {
         wb_table13_203_MK2e( false) ;
      }
   }

   public void wb_table12_164_MK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable21_Internalname, tblUnnamedtable21_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavUrl_sqs_calcliqtodo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavUrl_sqs_calcliqtodo_Internalname, httpContext.getMessage( "URL SQS Liquidación conceptos principales", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 169,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavUrl_sqs_calcliqtodo_Internalname, AV75url_sqs_CalcLiqTodo, GXutil.rtrim( localUtil.format( AV75url_sqs_CalcLiqTodo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,169);\"", "'"+""+"'"+",false,"+"'"+""+"'", AV75url_sqs_CalcLiqTodo, "_blank", "", "", edtavUrl_sqs_calcliqtodo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavUrl_sqs_calcliqtodo_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavUrl_sqs_deplsd_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavUrl_sqs_deplsd_Internalname, httpContext.getMessage( "URL SQS Liquidación conceptos dependencias de LSD", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 174,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavUrl_sqs_deplsd_Internalname, AV80url_sqs_DEPLSD, GXutil.rtrim( localUtil.format( AV80url_sqs_DEPLSD, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,174);\"", "'"+""+"'"+",false,"+"'"+""+"'", AV80url_sqs_DEPLSD, "_blank", "", "", edtavUrl_sqs_deplsd_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavUrl_sqs_deplsd_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavUrl_sqs_contr_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavUrl_sqs_contr_Internalname, httpContext.getMessage( "URL SQS Liquidación conceptos de contribuciones", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 179,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavUrl_sqs_contr_Internalname, AV81url_sqs_contr, GXutil.rtrim( localUtil.format( AV81url_sqs_contr, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,179);\"", "'"+""+"'"+",false,"+"'"+""+"'", AV81url_sqs_contr, "_blank", "", "", edtavUrl_sqs_contr_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavUrl_sqs_contr_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavUrl_sqs_otr_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavUrl_sqs_otr_Internalname, httpContext.getMessage( "URL SQS Liquidación conceptos de otros auxiliares para liquidaciones futuras", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 184,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavUrl_sqs_otr_Internalname, AV82url_sqs_otr, GXutil.rtrim( localUtil.format( AV82url_sqs_otr, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,184);\"", "'"+""+"'"+",false,"+"'"+""+"'", AV82url_sqs_otr, "_blank", "", "", edtavUrl_sqs_otr_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavUrl_sqs_otr_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavUrl_sqs_generarrecibos_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavUrl_sqs_generarrecibos_Internalname, httpContext.getMessage( "URL SQS Generar Recibos", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 189,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavUrl_sqs_generarrecibos_Internalname, AV77url_sqs_GenerarRecibos, GXutil.rtrim( localUtil.format( AV77url_sqs_GenerarRecibos, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,189);\"", "'"+""+"'"+",false,"+"'"+""+"'", AV77url_sqs_GenerarRecibos, "_blank", "", "", edtavUrl_sqs_generarrecibos_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavUrl_sqs_generarrecibos_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavUrl_sqs_generarpdf_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavUrl_sqs_generarpdf_Internalname, httpContext.getMessage( "URL SQS Generaración de PDF desde html", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 194,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavUrl_sqs_generarpdf_Internalname, AV100url_sqs_generarPDF, GXutil.rtrim( localUtil.format( AV100url_sqs_generarPDF, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,194);\"", "'"+""+"'"+",false,"+"'"+""+"'", AV100url_sqs_generarPDF, "_blank", "", "", edtavUrl_sqs_generarpdf_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavUrl_sqs_generarpdf_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavUrl_sqs_uploadfiless3_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavUrl_sqs_uploadfiless3_Internalname, httpContext.getMessage( "URL SQS Upload de archivos a S3", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 199,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavUrl_sqs_uploadfiless3_Internalname, AV87url_sqs_uploadFilesS3, GXutil.rtrim( localUtil.format( AV87url_sqs_uploadFilesS3, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,199);\"", "'"+""+"'"+",false,"+"'"+""+"'", AV87url_sqs_uploadFilesS3, "_blank", "", "", edtavUrl_sqs_uploadfiless3_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavUrl_sqs_uploadfiless3_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table12_164_MK2e( true) ;
      }
      else
      {
         wb_table12_164_MK2e( false) ;
      }
   }

   public void wb_table11_107_MK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable19_Internalname, tblUnnamedtable19_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiqprinmodopalabra.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqprinmodopalabra.getInternalname(), httpContext.getMessage( "Cálculo conceptos principales", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqprinmodopalabra, cmbavLiqprinmodopalabra.getInternalname(), GXutil.rtrim( AV92liqPrinModoPalabra), 1, cmbavLiqprinmodopalabra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavLiqprinmodopalabra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,112);\"", "", true, (byte)(0), "HLP_ParametrosBackend.htm");
         cmbavLiqprinmodopalabra.setValue( GXutil.rtrim( AV92liqPrinModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqprinmodopalabra.getInternalname(), "Values", cmbavLiqprinmodopalabra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiqlsdmodopalabra.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqlsdmodopalabra.getInternalname(), httpContext.getMessage( "Cálculo conceptos LSD", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 117,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqlsdmodopalabra, cmbavLiqlsdmodopalabra.getInternalname(), GXutil.rtrim( AV93liqLSDModoPalabra), 1, cmbavLiqlsdmodopalabra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavLiqlsdmodopalabra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,117);\"", "", true, (byte)(0), "HLP_ParametrosBackend.htm");
         cmbavLiqlsdmodopalabra.setValue( GXutil.rtrim( AV93liqLSDModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqlsdmodopalabra.getInternalname(), "Values", cmbavLiqlsdmodopalabra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiqcontrmodopalabra.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqcontrmodopalabra.getInternalname(), httpContext.getMessage( "Cálculo contribuciones", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 122,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqcontrmodopalabra, cmbavLiqcontrmodopalabra.getInternalname(), GXutil.rtrim( AV97liqContrModoPalabra), 1, cmbavLiqcontrmodopalabra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavLiqcontrmodopalabra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,122);\"", "", true, (byte)(0), "HLP_ParametrosBackend.htm");
         cmbavLiqcontrmodopalabra.setValue( GXutil.rtrim( AV97liqContrModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqcontrmodopalabra.getInternalname(), "Values", cmbavLiqcontrmodopalabra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiqotrosmodopalabra.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqotrosmodopalabra.getInternalname(), httpContext.getMessage( "Cälculo otros conceptos para liquidaciones futuras", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 127,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqotrosmodopalabra, cmbavLiqotrosmodopalabra.getInternalname(), GXutil.rtrim( AV94liqOtrosModoPalabra), 1, cmbavLiqotrosmodopalabra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavLiqotrosmodopalabra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,127);\"", "", true, (byte)(0), "HLP_ParametrosBackend.htm");
         cmbavLiqotrosmodopalabra.setValue( GXutil.rtrim( AV94liqOtrosModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqotrosmodopalabra.getInternalname(), "Values", cmbavLiqotrosmodopalabra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiqrecibosmodopalabra.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqrecibosmodopalabra.getInternalname(), httpContext.getMessage( "Generación de recibos html", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 132,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqrecibosmodopalabra, cmbavLiqrecibosmodopalabra.getInternalname(), GXutil.rtrim( AV95liqRecibosModoPalabra), 1, cmbavLiqrecibosmodopalabra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavLiqrecibosmodopalabra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,132);\"", "", true, (byte)(0), "HLP_ParametrosBackend.htm");
         cmbavLiqrecibosmodopalabra.setValue( GXutil.rtrim( AV95liqRecibosModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqrecibosmodopalabra.getInternalname(), "Values", cmbavLiqrecibosmodopalabra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiquploadmodopalabra.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiquploadmodopalabra.getInternalname(), httpContext.getMessage( "Upload de html de recibo a S3", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 137,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiquploadmodopalabra, cmbavLiquploadmodopalabra.getInternalname(), GXutil.rtrim( AV98liqUploadModoPalabra), 1, cmbavLiquploadmodopalabra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavLiquploadmodopalabra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,137);\"", "", true, (byte)(0), "HLP_ParametrosBackend.htm");
         cmbavLiquploadmodopalabra.setValue( GXutil.rtrim( AV98liqUploadModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiquploadmodopalabra.getInternalname(), "Values", cmbavLiquploadmodopalabra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiqpdfmodopalabra.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqpdfmodopalabra.getInternalname(), httpContext.getMessage( "Conversión de html a pdf", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 142,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqpdfmodopalabra, cmbavLiqpdfmodopalabra.getInternalname(), GXutil.rtrim( AV96liqPDFModoPalabra), 1, cmbavLiqpdfmodopalabra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavLiqpdfmodopalabra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,142);\"", "", true, (byte)(0), "HLP_ParametrosBackend.htm");
         cmbavLiqpdfmodopalabra.setValue( GXutil.rtrim( AV96liqPDFModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLiqpdfmodopalabra.getInternalname(), "Values", cmbavLiqpdfmodopalabra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavMax_pdf_paralelos_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavMax_pdf_paralelos_Internalname, httpContext.getMessage( "Máximo de pdfs en paralelo para convertir html en modo daemon", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 147,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavMax_pdf_paralelos_Internalname, GXutil.ltrim( localUtil.ntoc( AV102MAX_PDF_PARALELOS, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavMax_pdf_paralelos_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV102MAX_PDF_PARALELOS), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV102MAX_PDF_PARALELOS), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,147);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavMax_pdf_paralelos_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavMax_pdf_paralelos_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavImgas3modopalabra.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavImgas3modopalabra.getInternalname(), httpContext.getMessage( "Upload de imagen de legajo y empresa a S3", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 152,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavImgas3modopalabra, cmbavImgas3modopalabra.getInternalname(), GXutil.rtrim( AV99ImgAS3ModoPalabra), 1, cmbavImgas3modopalabra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavImgas3modopalabra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,152);\"", "", true, (byte)(0), "HLP_ParametrosBackend.htm");
         cmbavImgas3modopalabra.setValue( GXutil.rtrim( AV99ImgAS3ModoPalabra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavImgas3modopalabra.getInternalname(), "Values", cmbavImgas3modopalabra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table11_107_MK2e( true) ;
      }
      else
      {
         wb_table11_107_MK2e( false) ;
      }
   }

   public void wb_table3_35_MK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable3_Internalname, tblUnnamedtable3_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavA3lutilitieshost_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavA3lutilitieshost_Internalname, httpContext.getMessage( "Host de nodejs", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavA3lutilitieshost_Internalname, AV48a3lutilitiesHost, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,40);\"", (short)(0), 1, edtavA3lutilitieshost_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavNodebaseurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavNodebaseurl_Internalname, httpContext.getMessage( "Base URL de NodeJs", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavNodebaseurl_Internalname, AV63nodeBaseUrl, GXutil.rtrim( localUtil.format( AV63nodeBaseUrl, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNodebaseurl_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavNodebaseurl_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "texto", "left", true, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavHtmlapdf_puerto_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavHtmlapdf_puerto_Internalname, httpContext.getMessage( "Puerto de nodejs", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavHtmlapdf_puerto_Internalname, GXutil.ltrim( localUtil.ntoc( AV49htmlapdf_puerto, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavHtmlapdf_puerto_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV49htmlapdf_puerto), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV49htmlapdf_puerto), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,50);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavHtmlapdf_puerto_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavHtmlapdf_puerto_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ParametrosBackend.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_35_MK2e( true) ;
      }
      else
      {
         wb_table3_35_MK2e( false) ;
      }
   }

   public void wb_table2_16_MK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+chkavModotest.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavModotest.getInternalname(), httpContext.getMessage( "Modo test", ""), "gx-form-item AttributeCheckBoxLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavModotest.getInternalname(), GXutil.booltostr( AV52modoTest), "", httpContext.getMessage( "Modo test", ""), 1, chkavModotest.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(21, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,21);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+chkavA3lutilitiesesdocker.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavA3lutilitiesesdocker.getInternalname(), httpContext.getMessage( "NodeJs de A3L Utilities es un contenedor de docker", ""), "gx-form-item AttributeCheckBoxLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavA3lutilitiesesdocker.getInternalname(), GXutil.booltostr( AV47a3lutilitiesEsDocker), "", httpContext.getMessage( "NodeJs de A3L Utilities es un contenedor de docker", ""), 1, chkavA3lutilitiesesdocker.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(26, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,26);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+chkavScrapecuil.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavScrapecuil.getInternalname(), httpContext.getMessage( "Scrape CUIL en importacion del egajos", ""), "gx-form-item AttributeCheckBoxLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'" + sGXsfl_270_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavScrapecuil.getInternalname(), GXutil.booltostr( AV61scrapeCuil), "", httpContext.getMessage( "Scrape CUIL en importacion del egajos", ""), 1, chkavScrapecuil.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(31, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,31);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_16_MK2e( true) ;
      }
      else
      {
         wb_table2_16_MK2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV46MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46MenuOpcCod", AV46MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV46MenuOpcCod, ""))));
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
      paMK2( ) ;
      wsMK2( ) ;
      weMK2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025139535627", true, true);
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
         httpContext.AddJavascriptSource("parametrosbackend.js", "?2025139535627", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_2702( )
   {
      edtTLiqCod_Internalname = "TLIQCOD_"+sGXsfl_270_idx ;
      edtTliqDesc_Internalname = "TLIQDESC_"+sGXsfl_270_idx ;
      chkavTliqhabilitada.setInternalname( "vTLIQHABILITADA_"+sGXsfl_270_idx );
   }

   public void subsflControlProps_fel_2702( )
   {
      edtTLiqCod_Internalname = "TLIQCOD_"+sGXsfl_270_fel_idx ;
      edtTliqDesc_Internalname = "TLIQDESC_"+sGXsfl_270_fel_idx ;
      chkavTliqhabilitada.setInternalname( "vTLIQHABILITADA_"+sGXsfl_270_fel_idx );
   }

   public void sendrow_2702( )
   {
      subsflControlProps_2702( ) ;
      wbMK0( ) ;
      if ( ( subGrid1_Rows * 1 == 0 ) || ( nGXsfl_270_idx <= subgrid1_fnc_recordsperpage( ) * 1 ) )
      {
         Grid1Row = GXWebRow.GetNew(context,Grid1Container) ;
         if ( subGrid1_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid1_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Odd" ;
            }
         }
         else if ( subGrid1_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid1_Backstyle = (byte)(0) ;
            subGrid1_Backcolor = subGrid1_Allbackcolor ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Uniform" ;
            }
         }
         else if ( subGrid1_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid1_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Odd" ;
            }
            subGrid1_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid1_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid1_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_270_idx) % (2))) == 0 )
            {
               subGrid1_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Even" ;
               }
            }
            else
            {
               subGrid1_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Odd" ;
               }
            }
         }
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_270_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTLiqCod_Internalname,GXutil.rtrim( A32TLiqCod),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTLiqCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(270),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodigoCaracter","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTliqDesc_Internalname,A340TliqDesc,GXutil.rtrim( localUtil.format( A340TliqDesc, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTliqDesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(270),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionMedia","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Check box */
         TempTags = " " + ((chkavTliqhabilitada.getEnabled()!=0)&&(chkavTliqhabilitada.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 273,'',false,'"+sGXsfl_270_idx+"',270)\"" : " ") ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vTLIQHABILITADA_" + sGXsfl_270_idx ;
         chkavTliqhabilitada.setName( GXCCtl );
         chkavTliqhabilitada.setWebtags( "" );
         chkavTliqhabilitada.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavTliqhabilitada.getInternalname(), "TitleCaption", chkavTliqhabilitada.getCaption(), !bGXsfl_270_Refreshing);
         chkavTliqhabilitada.setCheckedValue( "false" );
         AV37TLiqHabilitada = GXutil.strtobool( GXutil.booltostr( AV37TLiqHabilitada)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavTliqhabilitada.getInternalname(), AV37TLiqHabilitada);
         Grid1Row.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavTliqhabilitada.getInternalname(),GXutil.booltostr( AV37TLiqHabilitada),"","",Integer.valueOf(-1),Integer.valueOf(chkavTliqhabilitada.getEnabled()),"true","",StyleString,ClassString,"WWColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(273, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+((chkavTliqhabilitada.getEnabled()!=0)&&(chkavTliqhabilitada.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,273);\"" : " ")});
         send_integrity_lvl_hashesMK2( ) ;
         Grid1Container.AddRow(Grid1Row);
         nGXsfl_270_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_270_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_270_idx+1) ;
         sGXsfl_270_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_270_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2702( ) ;
      }
      /* End function sendrow_2702 */
   }

   public void startgridcontrol270( )
   {
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Grid1Container"+"DivS\" data-gxgridid=\"270\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid1_Internalname, subGrid1_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid1_Backcolorstyle == 0 )
         {
            subGrid1_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid1_Class) > 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Title" ;
            }
         }
         else
         {
            subGrid1_Titlebackstyle = (byte)(1) ;
            if ( subGrid1_Backcolorstyle == 1 )
            {
               subGrid1_Titlebackcolor = subGrid1_Allbackcolor ;
               if ( GXutil.len( subGrid1_Class) > 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid1_Class) > 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de Liquidación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripcion", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Grid1Container.AddObjectProperty("GridName", "Grid1");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Grid1Container.Clear();
         }
         Grid1Container.SetWrapped(nGXWrapped);
         Grid1Container.AddObjectProperty("GridName", "Grid1");
         Grid1Container.AddObjectProperty("Header", subGrid1_Header);
         Grid1Container.AddObjectProperty("Class", "WorkWith");
         Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("CmpContext", "");
         Grid1Container.AddObjectProperty("InMasterPage", "false");
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", GXutil.rtrim( A32TLiqCod));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", A340TliqDesc);
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", GXutil.booltostr( AV37TLiqHabilitada));
         Grid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkavTliqhabilitada.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid1_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      chkavModotest.setInternalname( "vMODOTEST" );
      chkavA3lutilitiesesdocker.setInternalname( "vA3LUTILITIESESDOCKER" );
      chkavScrapecuil.setInternalname( "vSCRAPECUIL" );
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      grpUnnamedgroup2_Internalname = "UNNAMEDGROUP2" ;
      edtavA3lutilitieshost_Internalname = "vA3LUTILITIESHOST" ;
      edtavNodebaseurl_Internalname = "vNODEBASEURL" ;
      edtavHtmlapdf_puerto_Internalname = "vHTMLAPDF_PUERTO" ;
      tblUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      grpUnnamedgroup4_Internalname = "UNNAMEDGROUP4" ;
      chkavLiquidarauxparalelos.setInternalname( "vLIQUIDARAUXPARALELOS" );
      edtavConceptos_aux_metodo_Internalname = "vCONCEPTOS_AUX_METODO" ;
      cmbavAuto_imprimir_pdfliqleg.setInternalname( "vAUTO_IMPRIMIR_PDFLIQLEG" );
      cmbavPdf_automatico_estilo.setInternalname( "vPDF_AUTOMATICO_ESTILO" );
      edtavCantlegporloteliq_Internalname = "vCANTLEGPORLOTELIQ" ;
      edtavCantloteporliq_Internalname = "vCANTLOTEPORLIQ" ;
      edtavCantlotpdfporlote_Internalname = "vCANTLOTPDFPORLOTE" ;
      edtavCantreplicasprocesos_Internalname = "vCANTREPLICASPROCESOS" ;
      edtavSegundosesperaporlegajo_Internalname = "vSEGUNDOSESPERAPORLEGAJO" ;
      cmbavLiqprinmodopalabra.setInternalname( "vLIQPRINMODOPALABRA" );
      cmbavLiqlsdmodopalabra.setInternalname( "vLIQLSDMODOPALABRA" );
      cmbavLiqcontrmodopalabra.setInternalname( "vLIQCONTRMODOPALABRA" );
      cmbavLiqotrosmodopalabra.setInternalname( "vLIQOTROSMODOPALABRA" );
      cmbavLiqrecibosmodopalabra.setInternalname( "vLIQRECIBOSMODOPALABRA" );
      cmbavLiquploadmodopalabra.setInternalname( "vLIQUPLOADMODOPALABRA" );
      cmbavLiqpdfmodopalabra.setInternalname( "vLIQPDFMODOPALABRA" );
      edtavMax_pdf_paralelos_Internalname = "vMAX_PDF_PARALELOS" ;
      cmbavImgas3modopalabra.setInternalname( "vIMGAS3MODOPALABRA" );
      tblUnnamedtable19_Internalname = "UNNAMEDTABLE19" ;
      grpUnnamedgroup20_Internalname = "UNNAMEDGROUP20" ;
      chkavLambda_desgloce.setInternalname( "vLAMBDA_DESGLOCE" );
      lblLinkrestconexiones_Internalname = "LINKRESTCONEXIONES" ;
      edtavUrl_sqs_calcliqtodo_Internalname = "vURL_SQS_CALCLIQTODO" ;
      edtavUrl_sqs_deplsd_Internalname = "vURL_SQS_DEPLSD" ;
      edtavUrl_sqs_contr_Internalname = "vURL_SQS_CONTR" ;
      edtavUrl_sqs_otr_Internalname = "vURL_SQS_OTR" ;
      edtavUrl_sqs_generarrecibos_Internalname = "vURL_SQS_GENERARRECIBOS" ;
      edtavUrl_sqs_generarpdf_Internalname = "vURL_SQS_GENERARPDF" ;
      edtavUrl_sqs_uploadfiless3_Internalname = "vURL_SQS_UPLOADFILESS3" ;
      tblUnnamedtable21_Internalname = "UNNAMEDTABLE21" ;
      grpUnnamedgroup22_Internalname = "UNNAMEDGROUP22" ;
      edtavEventbr_dettype_genrecibo_Internalname = "vEVENTBR_DETTYPE_GENRECIBO" ;
      edtavEventbr_source_genrecibo_Internalname = "vEVENTBR_SOURCE_GENRECIBO" ;
      tblUnnamedtable23_Internalname = "UNNAMEDTABLE23" ;
      grpUnnamedgroup24_Internalname = "UNNAMEDGROUP24" ;
      tblUnnamedtable17_Internalname = "UNNAMEDTABLE17" ;
      grpUnnamedgroup18_Internalname = "UNNAMEDGROUP18" ;
      cmbavMetodoinvocapdf.setInternalname( "vMETODOINVOCAPDF" );
      cmbavFlujo_gen_rec.setInternalname( "vFLUJO_GEN_REC" );
      chkavGrabarhtmlrecibodb.setInternalname( "vGRABARHTMLRECIBODB" );
      tblUnnamedtable5_Internalname = "UNNAMEDTABLE5" ;
      grpUnnamedgroup6_Internalname = "UNNAMEDGROUP6" ;
      chkavModoahorros3.setInternalname( "vMODOAHORROS3" );
      edtavBucketname_Internalname = "vBUCKETNAME" ;
      edtavBucketnamepdf_Internalname = "vBUCKETNAMEPDF" ;
      tblUnnamedtable7_Internalname = "UNNAMEDTABLE7" ;
      grpUnnamedgroup8_Internalname = "UNNAMEDGROUP8" ;
      cmbavNiveldebug.setInternalname( "vNIVELDEBUG" );
      bttBtnprogramas_Internalname = "BTNPROGRAMAS" ;
      tblUnnamedtable9_Internalname = "UNNAMEDTABLE9" ;
      grpUnnamedgroup10_Internalname = "UNNAMEDGROUP10" ;
      edtTLiqCod_Internalname = "TLIQCOD" ;
      edtTliqDesc_Internalname = "TLIQDESC" ;
      chkavTliqhabilitada.setInternalname( "vTLIQHABILITADA" );
      tblUnnamedtable13_Internalname = "UNNAMEDTABLE13" ;
      grpUnnamedgroup14_Internalname = "UNNAMEDGROUP14" ;
      edtavGrossigup_concepto_Internalname = "vGROSSIGUP_CONCEPTO" ;
      edtavMargennetogrossing_Internalname = "vMARGENNETOGROSSING" ;
      edtavGrossigup_excluir_Internalname = "vGROSSIGUP_EXCLUIR" ;
      edtavGrossigup_maxintent_Internalname = "vGROSSIGUP_MAXINTENT" ;
      edtavGrossigup_multiplicador_Internalname = "vGROSSIGUP_MULTIPLICADOR" ;
      tblUnnamedtable15_Internalname = "UNNAMEDTABLE15" ;
      grpUnnamedgroup16_Internalname = "UNNAMEDGROUP16" ;
      tblUnnamedtable11_Internalname = "UNNAMEDTABLE11" ;
      grpUnnamedgroup12_Internalname = "UNNAMEDGROUP12" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnconfirmar_Internalname = "BTNCONFIRMAR" ;
      bttBtncancelar_Internalname = "BTNCANCELAR" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavAuto_imprimir_pdfliq_Internalname = "vAUTO_IMPRIMIR_PDFLIQ" ;
      edtavLiqmodo_Internalname = "vLIQMODO" ;
      chkavS3_gx_es.setInternalname( "vS3_GX_ES" );
      edtavUrl_sqs_calcliqsecundarios_Internalname = "vURL_SQS_CALCLIQSECUNDARIOS" ;
      edtavHostnodepublico_Internalname = "vHOSTNODEPUBLICO" ;
      Grid1_empowerer_Internalname = "GRID1_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid1_Internalname = "GRID1" ;
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
      subGrid1_Allowcollapsing = (byte)(0) ;
      subGrid1_Allowselection = (byte)(0) ;
      subGrid1_Header = "" ;
      chkavTliqhabilitada.setCaption( "" );
      chkavTliqhabilitada.setVisible( -1 );
      edtTliqDesc_Jsonclick = "" ;
      edtTLiqCod_Jsonclick = "" ;
      subGrid1_Class = "WorkWith" ;
      subGrid1_Backcolorstyle = (byte)(0) ;
      chkavScrapecuil.setEnabled( 1 );
      chkavA3lutilitiesesdocker.setEnabled( 1 );
      chkavModotest.setEnabled( 1 );
      edtavHtmlapdf_puerto_Jsonclick = "" ;
      edtavHtmlapdf_puerto_Enabled = 1 ;
      edtavNodebaseurl_Jsonclick = "" ;
      edtavNodebaseurl_Enabled = 1 ;
      edtavA3lutilitieshost_Enabled = 1 ;
      cmbavImgas3modopalabra.setJsonclick( "" );
      cmbavImgas3modopalabra.setEnabled( 1 );
      edtavMax_pdf_paralelos_Jsonclick = "" ;
      edtavMax_pdf_paralelos_Enabled = 1 ;
      cmbavLiqpdfmodopalabra.setJsonclick( "" );
      cmbavLiqpdfmodopalabra.setEnabled( 1 );
      cmbavLiquploadmodopalabra.setJsonclick( "" );
      cmbavLiquploadmodopalabra.setEnabled( 1 );
      cmbavLiqrecibosmodopalabra.setJsonclick( "" );
      cmbavLiqrecibosmodopalabra.setEnabled( 1 );
      cmbavLiqotrosmodopalabra.setJsonclick( "" );
      cmbavLiqotrosmodopalabra.setEnabled( 1 );
      cmbavLiqcontrmodopalabra.setJsonclick( "" );
      cmbavLiqcontrmodopalabra.setEnabled( 1 );
      cmbavLiqlsdmodopalabra.setJsonclick( "" );
      cmbavLiqlsdmodopalabra.setEnabled( 1 );
      cmbavLiqprinmodopalabra.setJsonclick( "" );
      cmbavLiqprinmodopalabra.setEnabled( 1 );
      edtavUrl_sqs_uploadfiless3_Jsonclick = "" ;
      edtavUrl_sqs_uploadfiless3_Enabled = 1 ;
      edtavUrl_sqs_generarpdf_Jsonclick = "" ;
      edtavUrl_sqs_generarpdf_Enabled = 1 ;
      edtavUrl_sqs_generarrecibos_Jsonclick = "" ;
      edtavUrl_sqs_generarrecibos_Enabled = 1 ;
      edtavUrl_sqs_otr_Jsonclick = "" ;
      edtavUrl_sqs_otr_Enabled = 1 ;
      edtavUrl_sqs_contr_Jsonclick = "" ;
      edtavUrl_sqs_contr_Enabled = 1 ;
      edtavUrl_sqs_deplsd_Jsonclick = "" ;
      edtavUrl_sqs_deplsd_Enabled = 1 ;
      edtavUrl_sqs_calcliqtodo_Jsonclick = "" ;
      edtavUrl_sqs_calcliqtodo_Enabled = 1 ;
      edtavEventbr_source_genrecibo_Enabled = 1 ;
      edtavEventbr_dettype_genrecibo_Enabled = 1 ;
      lblLinkrestconexiones_Link = "" ;
      chkavLambda_desgloce.setEnabled( 1 );
      chkavGrabarhtmlrecibodb.setEnabled( 1 );
      cmbavFlujo_gen_rec.setJsonclick( "" );
      cmbavFlujo_gen_rec.setEnabled( 1 );
      cmbavMetodoinvocapdf.setJsonclick( "" );
      cmbavMetodoinvocapdf.setEnabled( 1 );
      edtavSegundosesperaporlegajo_Jsonclick = "" ;
      edtavSegundosesperaporlegajo_Enabled = 1 ;
      edtavCantreplicasprocesos_Jsonclick = "" ;
      edtavCantreplicasprocesos_Enabled = 1 ;
      edtavCantlotpdfporlote_Jsonclick = "" ;
      edtavCantlotpdfporlote_Enabled = 1 ;
      edtavCantloteporliq_Jsonclick = "" ;
      edtavCantloteporliq_Enabled = 1 ;
      edtavCantlegporloteliq_Jsonclick = "" ;
      edtavCantlegporloteliq_Enabled = 1 ;
      cmbavPdf_automatico_estilo.setJsonclick( "" );
      cmbavPdf_automatico_estilo.setEnabled( 1 );
      cmbavAuto_imprimir_pdfliqleg.setJsonclick( "" );
      cmbavAuto_imprimir_pdfliqleg.setEnabled( 1 );
      edtavConceptos_aux_metodo_Jsonclick = "" ;
      edtavConceptos_aux_metodo_Enabled = 1 ;
      chkavLiquidarauxparalelos.setEnabled( 1 );
      edtavBucketnamepdf_Jsonclick = "" ;
      edtavBucketnamepdf_Enabled = 1 ;
      edtavBucketname_Jsonclick = "" ;
      edtavBucketname_Enabled = 1 ;
      chkavModoahorros3.setEnabled( 1 );
      bttBtnprogramas_Visible = 1 ;
      cmbavNiveldebug.setJsonclick( "" );
      cmbavNiveldebug.setEnabled( 1 );
      edtavGrossigup_multiplicador_Jsonclick = "" ;
      edtavGrossigup_multiplicador_Enabled = 1 ;
      edtavGrossigup_maxintent_Jsonclick = "" ;
      edtavGrossigup_maxintent_Enabled = 1 ;
      edtavGrossigup_excluir_Enabled = 1 ;
      edtavMargennetogrossing_Jsonclick = "" ;
      edtavMargennetogrossing_Enabled = 1 ;
      edtavGrossigup_concepto_Jsonclick = "" ;
      edtavGrossigup_concepto_Enabled = 1 ;
      grpUnnamedgroup24_Class = "Group" ;
      edtavHostnodepublico_Visible = 1 ;
      edtavUrl_sqs_calcliqsecundarios_Jsonclick = "" ;
      edtavUrl_sqs_calcliqsecundarios_Visible = 1 ;
      chkavS3_gx_es.setVisible( 1 );
      edtavLiqmodo_Jsonclick = "" ;
      edtavLiqmodo_Visible = 1 ;
      edtavAuto_imprimir_pdfliq_Jsonclick = "" ;
      edtavAuto_imprimir_pdfliq_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Parámetros", "") );
      chkavTliqhabilitada.setEnabled( 1 );
      subGrid1_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      chkavModotest.setName( "vMODOTEST" );
      chkavModotest.setWebtags( "" );
      chkavModotest.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavModotest.getInternalname(), "TitleCaption", chkavModotest.getCaption(), true);
      chkavModotest.setCheckedValue( "false" );
      AV52modoTest = GXutil.strtobool( GXutil.booltostr( AV52modoTest)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52modoTest", AV52modoTest);
      chkavA3lutilitiesesdocker.setName( "vA3LUTILITIESESDOCKER" );
      chkavA3lutilitiesesdocker.setWebtags( "" );
      chkavA3lutilitiesesdocker.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavA3lutilitiesesdocker.getInternalname(), "TitleCaption", chkavA3lutilitiesesdocker.getCaption(), true);
      chkavA3lutilitiesesdocker.setCheckedValue( "false" );
      AV47a3lutilitiesEsDocker = GXutil.strtobool( GXutil.booltostr( AV47a3lutilitiesEsDocker)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47a3lutilitiesEsDocker", AV47a3lutilitiesEsDocker);
      chkavScrapecuil.setName( "vSCRAPECUIL" );
      chkavScrapecuil.setWebtags( "" );
      chkavScrapecuil.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavScrapecuil.getInternalname(), "TitleCaption", chkavScrapecuil.getCaption(), true);
      chkavScrapecuil.setCheckedValue( "false" );
      AV61scrapeCuil = GXutil.strtobool( GXutil.booltostr( AV61scrapeCuil)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61scrapeCuil", AV61scrapeCuil);
      chkavLiquidarauxparalelos.setName( "vLIQUIDARAUXPARALELOS" );
      chkavLiquidarauxparalelos.setWebtags( "" );
      chkavLiquidarauxparalelos.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavLiquidarauxparalelos.getInternalname(), "TitleCaption", chkavLiquidarauxparalelos.getCaption(), true);
      chkavLiquidarauxparalelos.setCheckedValue( "false" );
      AV60liquidarAuxParalelos = GXutil.strtobool( GXutil.booltostr( AV60liquidarAuxParalelos)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60liquidarAuxParalelos", AV60liquidarAuxParalelos);
      cmbavAuto_imprimir_pdfliqleg.setName( "vAUTO_IMPRIMIR_PDFLIQLEG" );
      cmbavAuto_imprimir_pdfliqleg.setWebtags( "" );
      cmbavAuto_imprimir_pdfliqleg.addItem("NO", httpContext.getMessage( "No", ""), (short)(0));
      cmbavAuto_imprimir_pdfliqleg.addItem("TODO", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavAuto_imprimir_pdfliqleg.addItem("SOLO_HTML", httpContext.getMessage( "SoloHTML", ""), (short)(0));
      if ( cmbavAuto_imprimir_pdfliqleg.getItemCount() > 0 )
      {
         AV54auto_imprimir_PDFLiqLeg = cmbavAuto_imprimir_pdfliqleg.getValidValue(AV54auto_imprimir_PDFLiqLeg) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV54auto_imprimir_PDFLiqLeg", AV54auto_imprimir_PDFLiqLeg);
      }
      cmbavPdf_automatico_estilo.setName( "vPDF_AUTOMATICO_ESTILO" );
      cmbavPdf_automatico_estilo.setWebtags( "" );
      cmbavPdf_automatico_estilo.addItem("VERTICAL", httpContext.getMessage( "Vertical", ""), (short)(0));
      cmbavPdf_automatico_estilo.addItem("APAISADO", httpContext.getMessage( "Apaisado", ""), (short)(0));
      cmbavPdf_automatico_estilo.addItem("AMBOS", httpContext.getMessage( "Ambos", ""), (short)(0));
      if ( cmbavPdf_automatico_estilo.getItemCount() > 0 )
      {
         AV64pdf_automatico_estilo = cmbavPdf_automatico_estilo.getValidValue(AV64pdf_automatico_estilo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64pdf_automatico_estilo", AV64pdf_automatico_estilo);
      }
      cmbavLiqprinmodopalabra.setName( "vLIQPRINMODOPALABRA" );
      cmbavLiqprinmodopalabra.setWebtags( "" );
      cmbavLiqprinmodopalabra.addItem("MONOLITICO", httpContext.getMessage( "Monolítico", ""), (short)(0));
      cmbavLiqprinmodopalabra.addItem("DAEMON", httpContext.getMessage( "Microservicio daemon (docker)", ""), (short)(0));
      cmbavLiqprinmodopalabra.addItem("DOCKER", httpContext.getMessage( "Microservicio http (docker)", ""), (short)(0));
      cmbavLiqprinmodopalabra.addItem("LAMBDA", httpContext.getMessage( "Microservicio SQS (trigger lambda)", ""), (short)(0));
      if ( cmbavLiqprinmodopalabra.getItemCount() > 0 )
      {
         AV92liqPrinModoPalabra = cmbavLiqprinmodopalabra.getValidValue(AV92liqPrinModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV92liqPrinModoPalabra", AV92liqPrinModoPalabra);
      }
      cmbavLiqlsdmodopalabra.setName( "vLIQLSDMODOPALABRA" );
      cmbavLiqlsdmodopalabra.setWebtags( "" );
      cmbavLiqlsdmodopalabra.addItem("MONOLITICO", httpContext.getMessage( "Monolítico", ""), (short)(0));
      cmbavLiqlsdmodopalabra.addItem("DAEMON", httpContext.getMessage( "Microservicio daemon (docker)", ""), (short)(0));
      cmbavLiqlsdmodopalabra.addItem("DOCKER", httpContext.getMessage( "Microservicio http (docker)", ""), (short)(0));
      cmbavLiqlsdmodopalabra.addItem("LAMBDA", httpContext.getMessage( "Microservicio SQS (trigger ambda)", ""), (short)(0));
      if ( cmbavLiqlsdmodopalabra.getItemCount() > 0 )
      {
         AV93liqLSDModoPalabra = cmbavLiqlsdmodopalabra.getValidValue(AV93liqLSDModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV93liqLSDModoPalabra", AV93liqLSDModoPalabra);
      }
      cmbavLiqcontrmodopalabra.setName( "vLIQCONTRMODOPALABRA" );
      cmbavLiqcontrmodopalabra.setWebtags( "" );
      cmbavLiqcontrmodopalabra.addItem("MONOLITICO", httpContext.getMessage( "Monolítico", ""), (short)(0));
      cmbavLiqcontrmodopalabra.addItem("DAEMON", httpContext.getMessage( "Microservicio daemon (docker)", ""), (short)(0));
      cmbavLiqcontrmodopalabra.addItem("DOCKER", httpContext.getMessage( "Microservicio http (docker)", ""), (short)(0));
      cmbavLiqcontrmodopalabra.addItem("LAMBDA", httpContext.getMessage( "Microservicio SQS (trigger lambda)", ""), (short)(0));
      if ( cmbavLiqcontrmodopalabra.getItemCount() > 0 )
      {
         AV97liqContrModoPalabra = cmbavLiqcontrmodopalabra.getValidValue(AV97liqContrModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV97liqContrModoPalabra", AV97liqContrModoPalabra);
      }
      cmbavLiqotrosmodopalabra.setName( "vLIQOTROSMODOPALABRA" );
      cmbavLiqotrosmodopalabra.setWebtags( "" );
      cmbavLiqotrosmodopalabra.addItem("MONOLITICO", httpContext.getMessage( "Monolítico", ""), (short)(0));
      cmbavLiqotrosmodopalabra.addItem("DAEMON", httpContext.getMessage( "Microservicio daemon (docker)", ""), (short)(0));
      cmbavLiqotrosmodopalabra.addItem("DOCKER", httpContext.getMessage( "Microservicio http (docker)", ""), (short)(0));
      cmbavLiqotrosmodopalabra.addItem("LAMBDA", httpContext.getMessage( "Microservicio SQS ( trigger lambda)", ""), (short)(0));
      if ( cmbavLiqotrosmodopalabra.getItemCount() > 0 )
      {
         AV94liqOtrosModoPalabra = cmbavLiqotrosmodopalabra.getValidValue(AV94liqOtrosModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV94liqOtrosModoPalabra", AV94liqOtrosModoPalabra);
      }
      cmbavLiqrecibosmodopalabra.setName( "vLIQRECIBOSMODOPALABRA" );
      cmbavLiqrecibosmodopalabra.setWebtags( "" );
      cmbavLiqrecibosmodopalabra.addItem("MONOLITICO", httpContext.getMessage( "Monolítico", ""), (short)(0));
      cmbavLiqrecibosmodopalabra.addItem("DAEMON", httpContext.getMessage( "Microservicio daemon (docker)", ""), (short)(0));
      cmbavLiqrecibosmodopalabra.addItem("DOCKER", httpContext.getMessage( "Microservicio http (docker)", ""), (short)(0));
      cmbavLiqrecibosmodopalabra.addItem("LAMBDA", httpContext.getMessage( "Microservicio SQS (trigger lambda)", ""), (short)(0));
      if ( cmbavLiqrecibosmodopalabra.getItemCount() > 0 )
      {
         AV95liqRecibosModoPalabra = cmbavLiqrecibosmodopalabra.getValidValue(AV95liqRecibosModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV95liqRecibosModoPalabra", AV95liqRecibosModoPalabra);
      }
      cmbavLiquploadmodopalabra.setName( "vLIQUPLOADMODOPALABRA" );
      cmbavLiquploadmodopalabra.setWebtags( "" );
      cmbavLiquploadmodopalabra.addItem("DOCKER", httpContext.getMessage( "Microservicio http (docker)", ""), (short)(0));
      cmbavLiquploadmodopalabra.addItem("LAMBDA", httpContext.getMessage( "Microservicio SQS (trigger lambda)", ""), (short)(0));
      cmbavLiquploadmodopalabra.addItem("", httpContext.getMessage( "Deshabilitado", ""), (short)(0));
      if ( cmbavLiquploadmodopalabra.getItemCount() > 0 )
      {
         AV98liqUploadModoPalabra = cmbavLiquploadmodopalabra.getValidValue(AV98liqUploadModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV98liqUploadModoPalabra", AV98liqUploadModoPalabra);
      }
      cmbavLiqpdfmodopalabra.setName( "vLIQPDFMODOPALABRA" );
      cmbavLiqpdfmodopalabra.setWebtags( "" );
      cmbavLiqpdfmodopalabra.addItem("DOCKER", httpContext.getMessage( "Microservicio http (docker)", ""), (short)(0));
      cmbavLiqpdfmodopalabra.addItem("DAEMON", httpContext.getMessage( "Microservicio daemon (docker)", ""), (short)(0));
      cmbavLiqpdfmodopalabra.addItem("LAMBDA", httpContext.getMessage( "Microservicio SQS (trigger lambda)", ""), (short)(0));
      if ( cmbavLiqpdfmodopalabra.getItemCount() > 0 )
      {
         AV96liqPDFModoPalabra = cmbavLiqpdfmodopalabra.getValidValue(AV96liqPDFModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV96liqPDFModoPalabra", AV96liqPDFModoPalabra);
      }
      cmbavImgas3modopalabra.setName( "vIMGAS3MODOPALABRA" );
      cmbavImgas3modopalabra.setWebtags( "" );
      cmbavImgas3modopalabra.addItem("DOCKER", httpContext.getMessage( "Microservicio http (docker)", ""), (short)(0));
      cmbavImgas3modopalabra.addItem("LAMBDA", httpContext.getMessage( "Microservicio SQS (trigger lambda)", ""), (short)(0));
      if ( cmbavImgas3modopalabra.getItemCount() > 0 )
      {
         AV99ImgAS3ModoPalabra = cmbavImgas3modopalabra.getValidValue(AV99ImgAS3ModoPalabra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV99ImgAS3ModoPalabra", AV99ImgAS3ModoPalabra);
      }
      chkavLambda_desgloce.setName( "vLAMBDA_DESGLOCE" );
      chkavLambda_desgloce.setWebtags( "" );
      chkavLambda_desgloce.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavLambda_desgloce.getInternalname(), "TitleCaption", chkavLambda_desgloce.getCaption(), true);
      chkavLambda_desgloce.setCheckedValue( "false" );
      AV79lambda_desgloce = GXutil.strtobool( GXutil.booltostr( AV79lambda_desgloce)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79lambda_desgloce", AV79lambda_desgloce);
      cmbavMetodoinvocapdf.setName( "vMETODOINVOCAPDF" );
      cmbavMetodoinvocapdf.setWebtags( "" );
      cmbavMetodoinvocapdf.addItem("DIRECTA", httpContext.getMessage( "Síncrona", ""), (short)(0));
      cmbavMetodoinvocapdf.addItem("ASINCRONA", httpContext.getMessage( "Asíncrona", ""), (short)(0));
      if ( cmbavMetodoinvocapdf.getItemCount() > 0 )
      {
         AV88metodoInvocaPDF = cmbavMetodoinvocapdf.getValidValue(AV88metodoInvocaPDF) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV88metodoInvocaPDF", AV88metodoInvocaPDF);
      }
      cmbavFlujo_gen_rec.setName( "vFLUJO_GEN_REC" );
      cmbavFlujo_gen_rec.setWebtags( "" );
      cmbavFlujo_gen_rec.addItem("1", httpContext.getMessage( "Esperar a que terminen los conceptos principales de todos los legajos del lote, ", ""), (short)(0));
      cmbavFlujo_gen_rec.addItem("2", httpContext.getMessage( "Procesar el recibo de cada legajo inmediatamente después de procesar los conceptos principales del legajo, sin esperar a que terminen todos los legajos del lote, y en microservicio separado", ""), (short)(0));
      cmbavFlujo_gen_rec.addItem("3", httpContext.getMessage( "Procesar el recibo de cada legajo inmediatamente después de procesar los conceptos principales del legajo, sin esperar a que terminen todos los legajos del lote, y en mismo microservicio de liquidación de conceptos principales", ""), (short)(0));
      if ( cmbavFlujo_gen_rec.getItemCount() > 0 )
      {
         AV89flujo_gen_rec = cmbavFlujo_gen_rec.getValidValue(AV89flujo_gen_rec) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV89flujo_gen_rec", AV89flujo_gen_rec);
      }
      chkavGrabarhtmlrecibodb.setName( "vGRABARHTMLRECIBODB" );
      chkavGrabarhtmlrecibodb.setWebtags( "" );
      chkavGrabarhtmlrecibodb.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavGrabarhtmlrecibodb.getInternalname(), "TitleCaption", chkavGrabarhtmlrecibodb.getCaption(), true);
      chkavGrabarhtmlrecibodb.setCheckedValue( "false" );
      AV90grabarHtmlReciboDB = GXutil.strtobool( GXutil.booltostr( AV90grabarHtmlReciboDB)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV90grabarHtmlReciboDB", AV90grabarHtmlReciboDB);
      chkavModoahorros3.setName( "vMODOAHORROS3" );
      chkavModoahorros3.setWebtags( "" );
      chkavModoahorros3.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavModoahorros3.getInternalname(), "TitleCaption", chkavModoahorros3.getCaption(), true);
      chkavModoahorros3.setCheckedValue( "false" );
      AV55modoAhorroS3 = GXutil.strtobool( GXutil.booltostr( AV55modoAhorroS3)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55modoAhorroS3", AV55modoAhorroS3);
      cmbavNiveldebug.setName( "vNIVELDEBUG" );
      cmbavNiveldebug.setWebtags( "" );
      cmbavNiveldebug.addItem("NADA", httpContext.getMessage( "Nada", ""), (short)(0));
      cmbavNiveldebug.addItem("TODO", httpContext.getMessage( "Todo", ""), (short)(0));
      cmbavNiveldebug.addItem("ESPECIFICO", httpContext.getMessage( "Específico", ""), (short)(0));
      if ( cmbavNiveldebug.getItemCount() > 0 )
      {
         AV68nivelDebug = cmbavNiveldebug.getValidValue(AV68nivelDebug) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV68nivelDebug", AV68nivelDebug);
      }
      GXCCtl = "vTLIQHABILITADA_" + sGXsfl_270_idx ;
      chkavTliqhabilitada.setName( GXCCtl );
      chkavTliqhabilitada.setWebtags( "" );
      chkavTliqhabilitada.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavTliqhabilitada.getInternalname(), "TitleCaption", chkavTliqhabilitada.getCaption(), !bGXsfl_270_Refreshing);
      chkavTliqhabilitada.setCheckedValue( "false" );
      AV37TLiqHabilitada = GXutil.strtobool( GXutil.booltostr( AV37TLiqHabilitada)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavTliqhabilitada.getInternalname(), AV37TLiqHabilitada);
      chkavS3_gx_es.setName( "vS3_GX_ES" );
      chkavS3_gx_es.setWebtags( "" );
      chkavS3_gx_es.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavS3_gx_es.getInternalname(), "TitleCaption", chkavS3_gx_es.getCaption(), true);
      chkavS3_gx_es.setCheckedValue( "false" );
      AV86s3_Gx_Es = GXutil.strtobool( GXutil.booltostr( AV86s3_Gx_Es)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV86s3_Gx_Es", AV86s3_Gx_Es);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'chkavTliqhabilitada.getEnabled()',ctrl:'vTLIQHABILITADA',prop:'Enabled'},{av:'AV43sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'AV52modoTest',fld:'vMODOTEST',pic:''},{av:'AV47a3lutilitiesEsDocker',fld:'vA3LUTILITIESESDOCKER',pic:''},{av:'AV61scrapeCuil',fld:'vSCRAPECUIL',pic:''},{av:'AV60liquidarAuxParalelos',fld:'vLIQUIDARAUXPARALELOS',pic:''},{av:'AV79lambda_desgloce',fld:'vLAMBDA_DESGLOCE',pic:''},{av:'AV90grabarHtmlReciboDB',fld:'vGRABARHTMLRECIBODB',pic:''},{av:'AV55modoAhorroS3',fld:'vMODOAHORROS3',pic:''},{av:'AV86s3_Gx_Es',fld:'vS3_GX_ES',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV105Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV46MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{ctrl:'BTNPROGRAMAS',prop:'Visible'}]}");
      setEventMetadata("GRID1.LOAD","{handler:'e16MK2',iparms:[{av:'AV43sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'A32TLiqCod',fld:'TLIQCOD',pic:'',hsh:true}]");
      setEventMetadata("GRID1.LOAD",",oparms:[{av:'AV37TLiqHabilitada',fld:'vTLIQHABILITADA',pic:''}]}");
      setEventMetadata("'DOCONFIRMAR'","{handler:'e11MK2',iparms:[{av:'AV90grabarHtmlReciboDB',fld:'vGRABARHTMLRECIBODB',pic:''},{av:'cmbavMetodoinvocapdf'},{av:'AV88metodoInvocaPDF',fld:'vMETODOINVOCAPDF',pic:''},{av:'AV53auto_imprimir_PDFLiq',fld:'vAUTO_IMPRIMIR_PDFLIQ',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV86s3_Gx_Es',fld:'vS3_GX_ES',pic:''},{av:'AV87url_sqs_uploadFilesS3',fld:'vURL_SQS_UPLOADFILESS3',pic:''},{av:'AV100url_sqs_generarPDF',fld:'vURL_SQS_GENERARPDF',pic:''},{av:'AV85liqModo',fld:'vLIQMODO',pic:''},{av:'cmbavLiqprinmodopalabra'},{av:'AV92liqPrinModoPalabra',fld:'vLIQPRINMODOPALABRA',pic:''},{av:'cmbavLiqlsdmodopalabra'},{av:'AV93liqLSDModoPalabra',fld:'vLIQLSDMODOPALABRA',pic:''},{av:'cmbavLiqcontrmodopalabra'},{av:'AV97liqContrModoPalabra',fld:'vLIQCONTRMODOPALABRA',pic:''},{av:'cmbavLiqotrosmodopalabra'},{av:'AV94liqOtrosModoPalabra',fld:'vLIQOTROSMODOPALABRA',pic:''},{av:'cmbavLiqrecibosmodopalabra'},{av:'AV95liqRecibosModoPalabra',fld:'vLIQRECIBOSMODOPALABRA',pic:''},{av:'cmbavLiquploadmodopalabra'},{av:'AV98liqUploadModoPalabra',fld:'vLIQUPLOADMODOPALABRA',pic:''},{av:'cmbavLiqpdfmodopalabra'},{av:'AV96liqPDFModoPalabra',fld:'vLIQPDFMODOPALABRA',pic:''},{av:'cmbavImgas3modopalabra'},{av:'AV99ImgAS3ModoPalabra',fld:'vIMGAS3MODOPALABRA',pic:''},{av:'AV84eventBr_source_genRecibo',fld:'vEVENTBR_SOURCE_GENRECIBO',pic:''},{av:'AV83eventBr_detType_genRecibo',fld:'vEVENTBR_DETTYPE_GENRECIBO',pic:''},{av:'AV80url_sqs_DEPLSD',fld:'vURL_SQS_DEPLSD',pic:''},{av:'AV81url_sqs_contr',fld:'vURL_SQS_CONTR',pic:''},{av:'AV82url_sqs_otr',fld:'vURL_SQS_OTR',pic:''},{av:'AV79lambda_desgloce',fld:'vLAMBDA_DESGLOCE',pic:''},{av:'AV102MAX_PDF_PARALELOS',fld:'vMAX_PDF_PARALELOS',pic:'ZZZ9'},{av:'AV66cantLegPorLoteLiq',fld:'vCANTLEGPORLOTELIQ',pic:'ZZZ9'},{av:'AV91cantLotPDFPorLote',fld:'vCANTLOTPDFPORLOTE',pic:'ZZZ9'},{av:'AV65cantLotePorLiq',fld:'vCANTLOTEPORLIQ',pic:'ZZZ9'},{av:'AV67cantReplicasProcesos',fld:'vCANTREPLICASPROCESOS',pic:'ZZZ9'},{av:'AV105Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV61scrapeCuil',fld:'vSCRAPECUIL',pic:''},{av:'AV48a3lutilitiesHost',fld:'vA3LUTILITIESHOST',pic:''},{av:'cmbavNiveldebug'},{av:'AV68nivelDebug',fld:'vNIVELDEBUG',pic:''},{av:'AV59hostNodePublico',fld:'vHOSTNODEPUBLICO',pic:''},{av:'AV57bucketName',fld:'vBUCKETNAME',pic:''},{av:'AV58bucketNamePDF',fld:'vBUCKETNAMEPDF',pic:''},{av:'AV63nodeBaseUrl',fld:'vNODEBASEURL',pic:''},{av:'AV49htmlapdf_puerto',fld:'vHTMLAPDF_PUERTO',pic:'ZZZZZZZ9'},{av:'AV52modoTest',fld:'vMODOTEST',pic:''},{av:'AV60liquidarAuxParalelos',fld:'vLIQUIDARAUXPARALELOS',pic:''},{av:'cmbavPdf_automatico_estilo'},{av:'AV64pdf_automatico_estilo',fld:'vPDF_AUTOMATICO_ESTILO',pic:''},{av:'cmbavAuto_imprimir_pdfliqleg'},{av:'AV54auto_imprimir_PDFLiqLeg',fld:'vAUTO_IMPRIMIR_PDFLIQLEG',pic:''},{av:'AV55modoAhorroS3',fld:'vMODOAHORROS3',pic:''},{av:'AV56conceptos_aux_Metodo',fld:'vCONCEPTOS_AUX_METODO',pic:''},{av:'AV37TLiqHabilitada',fld:'vTLIQHABILITADA',grid:270,pic:''},{av:'GRID1_nFirstRecordOnPage'},{av:'nRC_GXsfl_270',ctrl:'GRID1',grid:270,prop:'GridRC',grid:270},{av:'A32TLiqCod',fld:'TLIQCOD',grid:270,pic:'',hsh:true},{av:'A340TliqDesc',fld:'TLIQDESC',grid:270,pic:'@!',hsh:true},{av:'AV78segundosEsperaPorLegajo',fld:'vSEGUNDOSESPERAPORLEGAJO',pic:'ZZZ9'},{av:'AV70grossigup_Concepto',fld:'vGROSSIGUP_CONCEPTO',pic:''},{av:'AV72grossigup_Excluir',fld:'vGROSSIGUP_EXCLUIR',pic:''},{av:'AV71margenNetoGrossing',fld:'vMARGENNETOGROSSING',pic:'9.9999'},{av:'AV73grossigup_maxIntent',fld:'vGROSSIGUP_MAXINTENT',pic:'ZZZ9'},{av:'AV74grossigup_Multiplicador',fld:'vGROSSIGUP_MULTIPLICADOR',pic:'9.9999'},{av:'AV75url_sqs_CalcLiqTodo',fld:'vURL_SQS_CALCLIQTODO',pic:''},{av:'AV76url_sqs_CalcLiqSecundarios',fld:'vURL_SQS_CALCLIQSECUNDARIOS',pic:''},{av:'AV77url_sqs_GenerarRecibos',fld:'vURL_SQS_GENERARRECIBOS',pic:''},{av:'cmbavFlujo_gen_rec'},{av:'AV89flujo_gen_rec',fld:'vFLUJO_GEN_REC',pic:''}]");
      setEventMetadata("'DOCONFIRMAR'",",oparms:[{av:'AV43sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''}]}");
      setEventMetadata("'DOCANCELAR'","{handler:'e12MK2',iparms:[]");
      setEventMetadata("'DOCANCELAR'",",oparms:[]}");
      setEventMetadata("'DOPROGRAMAS'","{handler:'e13MK2',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'chkavTliqhabilitada.getEnabled()',ctrl:'vTLIQHABILITADA',prop:'Enabled'},{av:'AV43sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'AV52modoTest',fld:'vMODOTEST',pic:''},{av:'AV47a3lutilitiesEsDocker',fld:'vA3LUTILITIESESDOCKER',pic:''},{av:'AV61scrapeCuil',fld:'vSCRAPECUIL',pic:''},{av:'AV60liquidarAuxParalelos',fld:'vLIQUIDARAUXPARALELOS',pic:''},{av:'AV79lambda_desgloce',fld:'vLAMBDA_DESGLOCE',pic:''},{av:'AV90grabarHtmlReciboDB',fld:'vGRABARHTMLRECIBODB',pic:''},{av:'AV55modoAhorroS3',fld:'vMODOAHORROS3',pic:''},{av:'AV86s3_Gx_Es',fld:'vS3_GX_ES',pic:''},{av:'AV105Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV46MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true}]");
      setEventMetadata("'DOPROGRAMAS'",",oparms:[{ctrl:'BTNPROGRAMAS',prop:'Visible'}]}");
      setEventMetadata("'DOVOLVER'","{handler:'e17MK2',iparms:[]");
      setEventMetadata("'DOVOLVER'",",oparms:[]}");
      setEventMetadata("GRID1_FIRSTPAGE","{handler:'subgrid1_firstpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'chkavTliqhabilitada.getEnabled()',ctrl:'vTLIQHABILITADA',prop:'Enabled'},{av:'AV43sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'AV105Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV46MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV52modoTest',fld:'vMODOTEST',pic:''},{av:'AV47a3lutilitiesEsDocker',fld:'vA3LUTILITIESESDOCKER',pic:''},{av:'AV61scrapeCuil',fld:'vSCRAPECUIL',pic:''},{av:'AV60liquidarAuxParalelos',fld:'vLIQUIDARAUXPARALELOS',pic:''},{av:'AV79lambda_desgloce',fld:'vLAMBDA_DESGLOCE',pic:''},{av:'AV90grabarHtmlReciboDB',fld:'vGRABARHTMLRECIBODB',pic:''},{av:'AV55modoAhorroS3',fld:'vMODOAHORROS3',pic:''},{av:'AV86s3_Gx_Es',fld:'vS3_GX_ES',pic:''}]");
      setEventMetadata("GRID1_FIRSTPAGE",",oparms:[{ctrl:'BTNPROGRAMAS',prop:'Visible'}]}");
      setEventMetadata("GRID1_PREVPAGE","{handler:'subgrid1_previouspage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'chkavTliqhabilitada.getEnabled()',ctrl:'vTLIQHABILITADA',prop:'Enabled'},{av:'AV43sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'AV105Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV46MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV52modoTest',fld:'vMODOTEST',pic:''},{av:'AV47a3lutilitiesEsDocker',fld:'vA3LUTILITIESESDOCKER',pic:''},{av:'AV61scrapeCuil',fld:'vSCRAPECUIL',pic:''},{av:'AV60liquidarAuxParalelos',fld:'vLIQUIDARAUXPARALELOS',pic:''},{av:'AV79lambda_desgloce',fld:'vLAMBDA_DESGLOCE',pic:''},{av:'AV90grabarHtmlReciboDB',fld:'vGRABARHTMLRECIBODB',pic:''},{av:'AV55modoAhorroS3',fld:'vMODOAHORROS3',pic:''},{av:'AV86s3_Gx_Es',fld:'vS3_GX_ES',pic:''}]");
      setEventMetadata("GRID1_PREVPAGE",",oparms:[{ctrl:'BTNPROGRAMAS',prop:'Visible'}]}");
      setEventMetadata("GRID1_NEXTPAGE","{handler:'subgrid1_nextpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'chkavTliqhabilitada.getEnabled()',ctrl:'vTLIQHABILITADA',prop:'Enabled'},{av:'AV43sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'AV105Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV46MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV52modoTest',fld:'vMODOTEST',pic:''},{av:'AV47a3lutilitiesEsDocker',fld:'vA3LUTILITIESESDOCKER',pic:''},{av:'AV61scrapeCuil',fld:'vSCRAPECUIL',pic:''},{av:'AV60liquidarAuxParalelos',fld:'vLIQUIDARAUXPARALELOS',pic:''},{av:'AV79lambda_desgloce',fld:'vLAMBDA_DESGLOCE',pic:''},{av:'AV90grabarHtmlReciboDB',fld:'vGRABARHTMLRECIBODB',pic:''},{av:'AV55modoAhorroS3',fld:'vMODOAHORROS3',pic:''},{av:'AV86s3_Gx_Es',fld:'vS3_GX_ES',pic:''}]");
      setEventMetadata("GRID1_NEXTPAGE",",oparms:[{ctrl:'BTNPROGRAMAS',prop:'Visible'}]}");
      setEventMetadata("GRID1_LASTPAGE","{handler:'subgrid1_lastpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'chkavTliqhabilitada.getEnabled()',ctrl:'vTLIQHABILITADA',prop:'Enabled'},{av:'AV43sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'AV105Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV46MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV52modoTest',fld:'vMODOTEST',pic:''},{av:'AV47a3lutilitiesEsDocker',fld:'vA3LUTILITIESESDOCKER',pic:''},{av:'AV61scrapeCuil',fld:'vSCRAPECUIL',pic:''},{av:'AV60liquidarAuxParalelos',fld:'vLIQUIDARAUXPARALELOS',pic:''},{av:'AV79lambda_desgloce',fld:'vLAMBDA_DESGLOCE',pic:''},{av:'AV90grabarHtmlReciboDB',fld:'vGRABARHTMLRECIBODB',pic:''},{av:'AV55modoAhorroS3',fld:'vMODOAHORROS3',pic:''},{av:'AV86s3_Gx_Es',fld:'vS3_GX_ES',pic:''}]");
      setEventMetadata("GRID1_LASTPAGE",",oparms:[{ctrl:'BTNPROGRAMAS',prop:'Visible'}]}");
      setEventMetadata("VALIDV_URL_SQS_CALCLIQTODO","{handler:'validv_Url_sqs_calcliqtodo',iparms:[]");
      setEventMetadata("VALIDV_URL_SQS_CALCLIQTODO",",oparms:[]}");
      setEventMetadata("VALIDV_URL_SQS_DEPLSD","{handler:'validv_Url_sqs_deplsd',iparms:[]");
      setEventMetadata("VALIDV_URL_SQS_DEPLSD",",oparms:[]}");
      setEventMetadata("VALIDV_URL_SQS_CONTR","{handler:'validv_Url_sqs_contr',iparms:[]");
      setEventMetadata("VALIDV_URL_SQS_CONTR",",oparms:[]}");
      setEventMetadata("VALIDV_URL_SQS_OTR","{handler:'validv_Url_sqs_otr',iparms:[]");
      setEventMetadata("VALIDV_URL_SQS_OTR",",oparms:[]}");
      setEventMetadata("VALIDV_URL_SQS_GENERARRECIBOS","{handler:'validv_Url_sqs_generarrecibos',iparms:[]");
      setEventMetadata("VALIDV_URL_SQS_GENERARRECIBOS",",oparms:[]}");
      setEventMetadata("VALIDV_URL_SQS_GENERARPDF","{handler:'validv_Url_sqs_generarpdf',iparms:[]");
      setEventMetadata("VALIDV_URL_SQS_GENERARPDF",",oparms:[]}");
      setEventMetadata("VALIDV_URL_SQS_UPLOADFILESS3","{handler:'validv_Url_sqs_uploadfiless3',iparms:[]");
      setEventMetadata("VALIDV_URL_SQS_UPLOADFILESS3",",oparms:[]}");
      setEventMetadata("VALIDV_URL_SQS_CALCLIQSECUNDARIOS","{handler:'validv_Url_sqs_calcliqsecundarios',iparms:[]");
      setEventMetadata("VALIDV_URL_SQS_CALCLIQSECUNDARIOS",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Tliqhabilitada',iparms:[]");
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
      wcpOAV46MenuOpcCod = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV46MenuOpcCod = "" ;
      AV43sdt_tipo_liqs = new GXBaseCollection<web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem>(web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem.class, "sdt_tipo_liqsItem", "PayDay", remoteHandle);
      AV105Pgmname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      Grid1_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      AV53auto_imprimir_PDFLiq = "" ;
      AV85liqModo = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV76url_sqs_CalcLiqSecundarios = "" ;
      AV59hostNodePublico = "" ;
      ucGrid1_empowerer = new com.genexus.webpanels.GXUserControl();
      Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A32TLiqCod = "" ;
      A340TliqDesc = "" ;
      AV54auto_imprimir_PDFLiqLeg = "" ;
      AV64pdf_automatico_estilo = "" ;
      AV92liqPrinModoPalabra = "" ;
      AV93liqLSDModoPalabra = "" ;
      AV97liqContrModoPalabra = "" ;
      AV94liqOtrosModoPalabra = "" ;
      AV95liqRecibosModoPalabra = "" ;
      AV98liqUploadModoPalabra = "" ;
      AV96liqPDFModoPalabra = "" ;
      AV99ImgAS3ModoPalabra = "" ;
      AV88metodoInvocaPDF = "" ;
      AV89flujo_gen_rec = "" ;
      AV68nivelDebug = "" ;
      scmdbuf = "" ;
      H00MK2_A3CliCod = new int[1] ;
      H00MK2_A340TliqDesc = new String[] {""} ;
      H00MK2_A32TLiqCod = new String[] {""} ;
      H00MK3_AGRID1_nRecordCount = new long[1] ;
      AV48a3lutilitiesHost = "" ;
      AV63nodeBaseUrl = "" ;
      AV56conceptos_aux_Metodo = "" ;
      AV75url_sqs_CalcLiqTodo = "" ;
      AV80url_sqs_DEPLSD = "" ;
      AV81url_sqs_contr = "" ;
      AV82url_sqs_otr = "" ;
      AV77url_sqs_GenerarRecibos = "" ;
      AV100url_sqs_generarPDF = "" ;
      AV87url_sqs_uploadFilesS3 = "" ;
      AV83eventBr_detType_genRecibo = "" ;
      AV84eventBr_source_genRecibo = "" ;
      AV57bucketName = "" ;
      AV58bucketNamePDF = "" ;
      AV70grossigup_Concepto = "" ;
      AV71margenNetoGrossing = DecimalUtil.ZERO ;
      AV72grossigup_Excluir = "" ;
      AV74grossigup_Multiplicador = DecimalUtil.ZERO ;
      GXv_int2 = new int[1] ;
      AV14ParmValue = "" ;
      GXt_char4 = "" ;
      GXt_char3 = "" ;
      GXv_char5 = new String[1] ;
      GXv_char6 = new String[1] ;
      AV44item = new web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem(remoteHandle, context);
      Grid1Row = new com.genexus.webpanels.GXWebRow();
      GXv_boolean8 = new boolean[1] ;
      bttBtnconfirmar_Jsonclick = "" ;
      bttBtncancelar_Jsonclick = "" ;
      bttBtnprogramas_Jsonclick = "" ;
      lblLinkrestconexiones_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid1_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      Grid1Column = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.parametrosbackend__default(),
         new Object[] {
             new Object[] {
            H00MK2_A3CliCod, H00MK2_A340TliqDesc, H00MK2_A32TLiqCod
            }
            , new Object[] {
            H00MK3_AGRID1_nRecordCount
            }
         }
      );
      AV105Pgmname = "ParametrosBackend" ;
      /* GeneXus formulas. */
      AV105Pgmname = "ParametrosBackend" ;
      Gx_err = (short)(0) ;
   }

   private byte GRID1_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte subGrid1_Backcolorstyle ;
   private byte subGrid1_Backstyle ;
   private byte subGrid1_Titlebackstyle ;
   private byte subGrid1_Allowselection ;
   private byte subGrid1_Allowhovering ;
   private byte subGrid1_Allowcollapsing ;
   private byte subGrid1_Collapsed ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV66cantLegPorLoteLiq ;
   private short AV65cantLotePorLiq ;
   private short AV91cantLotPDFPorLote ;
   private short AV67cantReplicasProcesos ;
   private short AV78segundosEsperaPorLegajo ;
   private short AV102MAX_PDF_PARALELOS ;
   private short AV73grossigup_maxIntent ;
   private int nRC_GXsfl_270 ;
   private int subGrid1_Rows ;
   private int nGXsfl_270_idx=1 ;
   private int AV7CliCod ;
   private int edtavAuto_imprimir_pdfliq_Visible ;
   private int edtavLiqmodo_Visible ;
   private int edtavUrl_sqs_calcliqsecundarios_Visible ;
   private int edtavHostnodepublico_Visible ;
   private int subGrid1_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int A3CliCod ;
   private int AV49htmlapdf_puerto ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV106GXV1 ;
   private int nGXsfl_270_fel_idx=1 ;
   private int bttBtnprogramas_Visible ;
   private int edtavGrossigup_concepto_Enabled ;
   private int edtavMargennetogrossing_Enabled ;
   private int edtavGrossigup_excluir_Enabled ;
   private int edtavGrossigup_maxintent_Enabled ;
   private int edtavGrossigup_multiplicador_Enabled ;
   private int edtavBucketname_Enabled ;
   private int edtavBucketnamepdf_Enabled ;
   private int edtavConceptos_aux_metodo_Enabled ;
   private int edtavCantlegporloteliq_Enabled ;
   private int edtavCantloteporliq_Enabled ;
   private int edtavCantlotpdfporlote_Enabled ;
   private int edtavCantreplicasprocesos_Enabled ;
   private int edtavSegundosesperaporlegajo_Enabled ;
   private int edtavEventbr_dettype_genrecibo_Enabled ;
   private int edtavEventbr_source_genrecibo_Enabled ;
   private int edtavUrl_sqs_calcliqtodo_Enabled ;
   private int edtavUrl_sqs_deplsd_Enabled ;
   private int edtavUrl_sqs_contr_Enabled ;
   private int edtavUrl_sqs_otr_Enabled ;
   private int edtavUrl_sqs_generarrecibos_Enabled ;
   private int edtavUrl_sqs_generarpdf_Enabled ;
   private int edtavUrl_sqs_uploadfiless3_Enabled ;
   private int edtavMax_pdf_paralelos_Enabled ;
   private int edtavA3lutilitieshost_Enabled ;
   private int edtavNodebaseurl_Enabled ;
   private int edtavHtmlapdf_puerto_Enabled ;
   private int idxLst ;
   private int subGrid1_Backcolor ;
   private int subGrid1_Allbackcolor ;
   private int subGrid1_Titlebackcolor ;
   private int subGrid1_Selectedindex ;
   private int subGrid1_Selectioncolor ;
   private int subGrid1_Hoveringcolor ;
   private long GRID1_nFirstRecordOnPage ;
   private long GRID1_nCurrentRecord ;
   private long GRID1_nRecordCount ;
   private java.math.BigDecimal AV71margenNetoGrossing ;
   private java.math.BigDecimal AV74grossigup_Multiplicador ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_270_idx="0001" ;
   private String AV105Pgmname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Grid1_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String edtavAuto_imprimir_pdfliq_Internalname ;
   private String AV53auto_imprimir_PDFLiq ;
   private String edtavAuto_imprimir_pdfliq_Jsonclick ;
   private String edtavLiqmodo_Internalname ;
   private String AV85liqModo ;
   private String edtavLiqmodo_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtavUrl_sqs_calcliqsecundarios_Internalname ;
   private String edtavUrl_sqs_calcliqsecundarios_Jsonclick ;
   private String edtavHostnodepublico_Internalname ;
   private String Grid1_empowerer_Internalname ;
   private String sStyleString ;
   private String subGrid1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String A32TLiqCod ;
   private String edtTLiqCod_Internalname ;
   private String edtTliqDesc_Internalname ;
   private String AV54auto_imprimir_PDFLiqLeg ;
   private String AV64pdf_automatico_estilo ;
   private String AV92liqPrinModoPalabra ;
   private String AV93liqLSDModoPalabra ;
   private String AV97liqContrModoPalabra ;
   private String AV94liqOtrosModoPalabra ;
   private String AV95liqRecibosModoPalabra ;
   private String AV98liqUploadModoPalabra ;
   private String AV96liqPDFModoPalabra ;
   private String AV99ImgAS3ModoPalabra ;
   private String AV88metodoInvocaPDF ;
   private String AV89flujo_gen_rec ;
   private String AV68nivelDebug ;
   private String scmdbuf ;
   private String edtavA3lutilitieshost_Internalname ;
   private String edtavNodebaseurl_Internalname ;
   private String edtavHtmlapdf_puerto_Internalname ;
   private String edtavConceptos_aux_metodo_Internalname ;
   private String edtavCantlegporloteliq_Internalname ;
   private String edtavCantloteporliq_Internalname ;
   private String edtavCantlotpdfporlote_Internalname ;
   private String edtavCantreplicasprocesos_Internalname ;
   private String edtavSegundosesperaporlegajo_Internalname ;
   private String edtavMax_pdf_paralelos_Internalname ;
   private String edtavUrl_sqs_calcliqtodo_Internalname ;
   private String edtavUrl_sqs_deplsd_Internalname ;
   private String edtavUrl_sqs_contr_Internalname ;
   private String edtavUrl_sqs_otr_Internalname ;
   private String edtavUrl_sqs_generarrecibos_Internalname ;
   private String edtavUrl_sqs_generarpdf_Internalname ;
   private String edtavUrl_sqs_uploadfiless3_Internalname ;
   private String edtavEventbr_dettype_genrecibo_Internalname ;
   private String edtavEventbr_source_genrecibo_Internalname ;
   private String edtavBucketname_Internalname ;
   private String edtavBucketnamepdf_Internalname ;
   private String AV70grossigup_Concepto ;
   private String edtavGrossigup_concepto_Internalname ;
   private String edtavMargennetogrossing_Internalname ;
   private String edtavGrossigup_excluir_Internalname ;
   private String edtavGrossigup_maxintent_Internalname ;
   private String edtavGrossigup_multiplicador_Internalname ;
   private String lblLinkrestconexiones_Link ;
   private String lblLinkrestconexiones_Internalname ;
   private String GXt_char4 ;
   private String GXt_char3 ;
   private String GXv_char5[] ;
   private String GXv_char6[] ;
   private String sGXsfl_270_fel_idx="0001" ;
   private String bttBtnprogramas_Internalname ;
   private String grpUnnamedgroup24_Class ;
   private String grpUnnamedgroup24_Internalname ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String grpUnnamedgroup2_Internalname ;
   private String grpUnnamedgroup4_Internalname ;
   private String grpUnnamedgroup6_Internalname ;
   private String grpUnnamedgroup8_Internalname ;
   private String grpUnnamedgroup10_Internalname ;
   private String grpUnnamedgroup12_Internalname ;
   private String bttBtnconfirmar_Internalname ;
   private String bttBtnconfirmar_Jsonclick ;
   private String bttBtncancelar_Internalname ;
   private String bttBtncancelar_Jsonclick ;
   private String tblUnnamedtable11_Internalname ;
   private String grpUnnamedgroup14_Internalname ;
   private String grpUnnamedgroup16_Internalname ;
   private String tblUnnamedtable15_Internalname ;
   private String edtavGrossigup_concepto_Jsonclick ;
   private String edtavMargennetogrossing_Jsonclick ;
   private String edtavGrossigup_maxintent_Jsonclick ;
   private String edtavGrossigup_multiplicador_Jsonclick ;
   private String tblUnnamedtable13_Internalname ;
   private String tblUnnamedtable9_Internalname ;
   private String bttBtnprogramas_Jsonclick ;
   private String tblUnnamedtable7_Internalname ;
   private String edtavBucketname_Jsonclick ;
   private String edtavBucketnamepdf_Jsonclick ;
   private String tblUnnamedtable5_Internalname ;
   private String edtavConceptos_aux_metodo_Jsonclick ;
   private String edtavCantlegporloteliq_Jsonclick ;
   private String edtavCantloteporliq_Jsonclick ;
   private String edtavCantlotpdfporlote_Jsonclick ;
   private String edtavCantreplicasprocesos_Jsonclick ;
   private String edtavSegundosesperaporlegajo_Jsonclick ;
   private String grpUnnamedgroup18_Internalname ;
   private String tblUnnamedtable17_Internalname ;
   private String grpUnnamedgroup20_Internalname ;
   private String lblLinkrestconexiones_Jsonclick ;
   private String grpUnnamedgroup22_Internalname ;
   private String tblUnnamedtable23_Internalname ;
   private String tblUnnamedtable21_Internalname ;
   private String edtavUrl_sqs_calcliqtodo_Jsonclick ;
   private String edtavUrl_sqs_deplsd_Jsonclick ;
   private String edtavUrl_sqs_contr_Jsonclick ;
   private String edtavUrl_sqs_otr_Jsonclick ;
   private String edtavUrl_sqs_generarrecibos_Jsonclick ;
   private String edtavUrl_sqs_generarpdf_Jsonclick ;
   private String edtavUrl_sqs_uploadfiless3_Jsonclick ;
   private String tblUnnamedtable19_Internalname ;
   private String edtavMax_pdf_paralelos_Jsonclick ;
   private String tblUnnamedtable3_Internalname ;
   private String edtavNodebaseurl_Jsonclick ;
   private String edtavHtmlapdf_puerto_Jsonclick ;
   private String tblUnnamedtable1_Internalname ;
   private String subGrid1_Class ;
   private String subGrid1_Linesclass ;
   private String ROClassString ;
   private String edtTLiqCod_Jsonclick ;
   private String edtTliqDesc_Jsonclick ;
   private String GXCCtl ;
   private String subGrid1_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_270_Refreshing=false ;
   private boolean AV52modoTest ;
   private boolean AV47a3lutilitiesEsDocker ;
   private boolean AV61scrapeCuil ;
   private boolean AV60liquidarAuxParalelos ;
   private boolean AV79lambda_desgloce ;
   private boolean AV90grabarHtmlReciboDB ;
   private boolean AV55modoAhorroS3 ;
   private boolean AV86s3_Gx_Es ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean AV37TLiqHabilitada ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV101ok ;
   private boolean AV69TempBoolean ;
   private boolean GXt_boolean7 ;
   private boolean GXv_boolean8[] ;
   private String AV14ParmValue ;
   private String wcpOAV46MenuOpcCod ;
   private String AV46MenuOpcCod ;
   private String AV76url_sqs_CalcLiqSecundarios ;
   private String AV59hostNodePublico ;
   private String A340TliqDesc ;
   private String AV48a3lutilitiesHost ;
   private String AV63nodeBaseUrl ;
   private String AV56conceptos_aux_Metodo ;
   private String AV75url_sqs_CalcLiqTodo ;
   private String AV80url_sqs_DEPLSD ;
   private String AV81url_sqs_contr ;
   private String AV82url_sqs_otr ;
   private String AV77url_sqs_GenerarRecibos ;
   private String AV100url_sqs_generarPDF ;
   private String AV87url_sqs_uploadFilesS3 ;
   private String AV83eventBr_detType_genRecibo ;
   private String AV84eventBr_source_genRecibo ;
   private String AV57bucketName ;
   private String AV58bucketNamePDF ;
   private String AV72grossigup_Excluir ;
   private com.genexus.webpanels.GXWebGrid Grid1Container ;
   private com.genexus.webpanels.GXWebRow Grid1Row ;
   private com.genexus.webpanels.GXWebColumn Grid1Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGrid1_empowerer ;
   private ICheckbox chkavModotest ;
   private ICheckbox chkavA3lutilitiesesdocker ;
   private ICheckbox chkavScrapecuil ;
   private ICheckbox chkavLiquidarauxparalelos ;
   private HTMLChoice cmbavAuto_imprimir_pdfliqleg ;
   private HTMLChoice cmbavPdf_automatico_estilo ;
   private HTMLChoice cmbavLiqprinmodopalabra ;
   private HTMLChoice cmbavLiqlsdmodopalabra ;
   private HTMLChoice cmbavLiqcontrmodopalabra ;
   private HTMLChoice cmbavLiqotrosmodopalabra ;
   private HTMLChoice cmbavLiqrecibosmodopalabra ;
   private HTMLChoice cmbavLiquploadmodopalabra ;
   private HTMLChoice cmbavLiqpdfmodopalabra ;
   private HTMLChoice cmbavImgas3modopalabra ;
   private ICheckbox chkavLambda_desgloce ;
   private HTMLChoice cmbavMetodoinvocapdf ;
   private HTMLChoice cmbavFlujo_gen_rec ;
   private ICheckbox chkavGrabarhtmlrecibodb ;
   private ICheckbox chkavModoahorros3 ;
   private HTMLChoice cmbavNiveldebug ;
   private ICheckbox chkavTliqhabilitada ;
   private ICheckbox chkavS3_gx_es ;
   private IDataStoreProvider pr_default ;
   private int[] H00MK2_A3CliCod ;
   private String[] H00MK2_A340TliqDesc ;
   private String[] H00MK2_A32TLiqCod ;
   private long[] H00MK3_AGRID1_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem> AV43sdt_tipo_liqs ;
   private web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem AV44item ;
}

final  class parametrosbackend__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00MK2", "SELECT CliCod, TliqDesc, TLiqCod FROM TipoLiquidacion WHERE CliCod = ? ORDER BY CliCod  OFFSET ? LIMIT CASE WHEN ? > 0 THEN ? ELSE 1e9 END",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00MK3", "SELECT COUNT(*) FROM TipoLiquidacion WHERE CliCod = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

