package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class confirmarliquidacion_impl extends GXDataArea
{
   public confirmarliquidacion_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public confirmarliquidacion_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( confirmarliquidacion_impl.class ));
   }

   public confirmarliquidacion_impl( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavSdtlegajos__seleccionado = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdtlegajoss") == 0 )
         {
            gxnrgridsdtlegajoss_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsdtlegajoss") == 0 )
         {
            gxgrgridsdtlegajoss_refresh_invoke( ) ;
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
            AV8CliCod = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV9EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
               AV12LiqPeriodo = localUtil.parseDateParm( httpContext.GetPar( "LiqPeriodo")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12LiqPeriodo", localUtil.format(AV12LiqPeriodo, "99/99/9999"));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQPERIODO", getSecureSignedToken( "", AV12LiqPeriodo));
               AV11TLiqCod = httpContext.GetPar( "TLiqCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11TLiqCod", AV11TLiqCod);
               AV26Respuesta = httpContext.GetPar( "Respuesta") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV26Respuesta", AV26Respuesta);
               AV10LiqNombre = httpContext.GetPar( "LiqNombre") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV10LiqNombre", AV10LiqNombre);
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

   public void gxnrgridsdtlegajoss_newrow_invoke( )
   {
      nRC_GXsfl_25 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_25"))) ;
      nGXsfl_25_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_25_idx"))) ;
      sGXsfl_25_idx = httpContext.GetPar( "sGXsfl_25_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridsdtlegajoss_newrow( ) ;
      /* End function gxnrGridsdtlegajoss_newrow_invoke */
   }

   public void gxgrgridsdtlegajoss_refresh_invoke( )
   {
      subGridsdtlegajoss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtlegajoss_Rows"))) ;
      AV12LiqPeriodo = localUtil.parseDateParm( httpContext.GetPar( "LiqPeriodo")) ;
      AV9EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV8CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridsdtlegajoss_refresh( subGridsdtlegajoss_Rows, AV12LiqPeriodo, AV9EmpCod, AV8CliCod) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridsdtlegajoss_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.workwithplusmasterpageprompt");
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
      pa9W2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start9W2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.confirmarliquidacion", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateParm(AV12LiqPeriodo)),GXutil.URLEncode(GXutil.rtrim(AV11TLiqCod)),GXutil.URLEncode(GXutil.rtrim(AV26Respuesta)),GXutil.URLEncode(GXutil.rtrim(AV10LiqNombre))}, new String[] {"CliCod","EmpCod","LiqPeriodo","TLiqCod","Respuesta","LiqNombre"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQPERIODO", getSecureSignedToken( "", AV12LiqPeriodo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtlegajos", AV5SDTLegajos);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtlegajos", AV5SDTLegajos);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_25", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_25, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQPERIODO", localUtil.dtoc( AV12LiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQPERIODO", getSecureSignedToken( "", AV12LiqPeriodo));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTLEGAJOS", AV5SDTLegajos);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTLEGAJOS", AV5SDTLegajos);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vRESPUESTA", GXutil.rtrim( AV26Respuesta));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTLEGAJOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTLEGAJOSS_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtlegajoss_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_EMPOWERER_Infinitescrolling", GXutil.rtrim( Gridsdtlegajoss_empowerer_Infinitescrolling));
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
         we9W2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt9W2( ) ;
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
      return formatLink("web.confirmarliquidacion", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateParm(AV12LiqPeriodo)),GXutil.URLEncode(GXutil.rtrim(AV11TLiqCod)),GXutil.URLEncode(GXutil.rtrim(AV26Respuesta)),GXutil.URLEncode(GXutil.rtrim(AV10LiqNombre))}, new String[] {"CliCod","EmpCod","LiqPeriodo","TLiqCod","Respuesta","LiqNombre"})  ;
   }

   public String getPgmname( )
   {
      return "ConfirmarLiquidacion" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Confirmar alta de liquidación", "") ;
   }

   public void wb9W0( )
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
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLiqnombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqnombre_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavLiqnombre_Internalname, AV10LiqNombre, "", "", (short)(0), 1, edtavLiqnombre_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_ConfirmarLiquidacion.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCntleg_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavCntleg_Internalname, httpContext.getMessage( "Cantidad de legajos", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'" + sGXsfl_25_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavCntleg_Internalname, GXutil.ltrim( localUtil.ntoc( AV36CntLeg, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCntleg_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV36CntLeg), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV36CntLeg), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCntleg_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavCntleg_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConfirmarLiquidacion.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridsdtlegajossContainer.SetWrapped(nGXWrapped);
         startgridcontrol25( ) ;
      }
      if ( wbEnd == 25 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_25 = (int)(nGXsfl_25_idx-1) ;
         if ( GridsdtlegajossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridsdtlegajossContainer.AddObjectProperty("GRIDSDTLEGAJOSS_nEOF", GRIDSDTLEGAJOSS_nEOF);
            GridsdtlegajossContainer.AddObjectProperty("GRIDSDTLEGAJOSS_nFirstRecordOnPage", GRIDSDTLEGAJOSS_nFirstRecordOnPage);
            AV39GXV1 = nGXsfl_25_idx ;
            if ( subGridsdtlegajoss_Visible != 0 )
            {
               sStyleString = "" ;
            }
            else
            {
               sStyleString = " style=\"display:none;\"" ;
            }
            httpContext.writeText( "<div id=\""+"GridsdtlegajossContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridsdtlegajoss", GridsdtlegajossContainer, subGridsdtlegajoss_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridsdtlegajossContainerData", GridsdtlegajossContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridsdtlegajossContainerData"+"V", GridsdtlegajossContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtlegajossContainerData"+"V"+"\" value='"+GridsdtlegajossContainer.GridValuesHidden()+"'/>") ;
            }
         }
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnconfirmar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 25, 2, 0)+","+"null"+");", httpContext.getMessage( "Confirmar", ""), bttBtnconfirmar_Jsonclick, 5, httpContext.getMessage( "Confirmar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCONFIRMAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConfirmarLiquidacion.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancelar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 25, 2, 0)+","+"null"+");", httpContext.getMessage( "Cancelar", ""), bttBtncancelar_Jsonclick, 5, httpContext.getMessage( "Cancelar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCANCELAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConfirmarLiquidacion.htm");
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
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTliqcod_Internalname, GXutil.rtrim( AV11TLiqCod), GXutil.rtrim( localUtil.format( AV11TLiqCod, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTliqcod_Jsonclick, 0, "Attribute", "", "", "", "", edtavTliqcod_Visible, 0, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConfirmarLiquidacion.htm");
         /* User Defined Control */
         ucGridsdtlegajoss_empowerer.setProperty("InfiniteScrolling", Gridsdtlegajoss_empowerer_Infinitescrolling);
         ucGridsdtlegajoss_empowerer.render(context, "wwp.gridempowerer", Gridsdtlegajoss_empowerer_Internalname, "GRIDSDTLEGAJOSS_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 25 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridsdtlegajossContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridsdtlegajossContainer.AddObjectProperty("GRIDSDTLEGAJOSS_nEOF", GRIDSDTLEGAJOSS_nEOF);
               GridsdtlegajossContainer.AddObjectProperty("GRIDSDTLEGAJOSS_nFirstRecordOnPage", GRIDSDTLEGAJOSS_nFirstRecordOnPage);
               AV39GXV1 = nGXsfl_25_idx ;
               if ( subGridsdtlegajoss_Visible != 0 )
               {
                  sStyleString = "" ;
               }
               else
               {
                  sStyleString = " style=\"display:none;\"" ;
               }
               httpContext.writeText( "<div id=\""+"GridsdtlegajossContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridsdtlegajoss", GridsdtlegajossContainer, subGridsdtlegajoss_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridsdtlegajossContainerData", GridsdtlegajossContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridsdtlegajossContainerData"+"V", GridsdtlegajossContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtlegajossContainerData"+"V"+"\" value='"+GridsdtlegajossContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start9W2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Confirmar alta de liquidación", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup9W0( ) ;
   }

   public void ws9W2( )
   {
      start9W2( ) ;
      evt9W2( ) ;
   }

   public void evt9W2( )
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
                           e119W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCANCELAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoCancelar' */
                           e129W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTLEGAJOSSPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDSDTLEGAJOSSPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridsdtlegajoss_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridsdtlegajoss_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridsdtlegajoss_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridsdtlegajoss_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 20), "GRIDSDTLEGAJOSS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_25_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_25_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_252( ) ;
                           AV39GXV1 = nGXsfl_25_idx ;
                           if ( ( AV5SDTLegajos.size() >= AV39GXV1 ) && ( AV39GXV1 > 0 ) )
                           {
                              AV5SDTLegajos.currentItem( ((web.SdtSDTLegajos_SDTLegajosItem)AV5SDTLegajos.elementAt(-1+AV39GXV1)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e139W2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDSDTLEGAJOSS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e149W2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e159W2 ();
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

   public void we9W2( )
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

   public void pa9W2( )
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
            GX_FocusControl = edtavCntleg_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridsdtlegajoss_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_252( ) ;
      while ( nGXsfl_25_idx <= nRC_GXsfl_25 )
      {
         sendrow_252( ) ;
         nGXsfl_25_idx = ((subGridsdtlegajoss_Islastpage==1)&&(nGXsfl_25_idx+1>subgridsdtlegajoss_fnc_recordsperpage( )) ? 1 : nGXsfl_25_idx+1) ;
         sGXsfl_25_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_252( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtlegajossContainer)) ;
      /* End function gxnrGridsdtlegajoss_newrow */
   }

   public void gxgrgridsdtlegajoss_refresh( int subGridsdtlegajoss_Rows ,
                                            java.util.Date AV12LiqPeriodo ,
                                            short AV9EmpCod ,
                                            int AV8CliCod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e159W2 ();
      GRIDSDTLEGAJOSS_nCurrentRecord = 0 ;
      rf9W2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsdtlegajoss_refresh */
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
      GRIDSDTLEGAJOSS_nFirstRecordOnPage = 0 ;
      GRIDSDTLEGAJOSS_nCurrentRecord = 0 ;
      GXCCtl = "GRIDSDTLEGAJOSS_nFirstRecordOnPage_" + sGXsfl_25_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDSDTLEGAJOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      send_integrity_hashes( ) ;
      rf9W2( ) ;
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
      edtavLiqnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqnombre_Enabled), 5, 0), true);
      edtavCntleg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCntleg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntleg_Enabled), 5, 0), true);
      edtavSdtlegajos__legnumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtlegajos__legnumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtlegajos__legnumero_Enabled), 5, 0), !bGXsfl_25_Refreshing);
      chkavSdtlegajos__seleccionado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavSdtlegajos__seleccionado.getInternalname(), "Enabled", GXutil.ltrimstr( chkavSdtlegajos__seleccionado.getEnabled(), 5, 0), !bGXsfl_25_Refreshing);
      edtavSdtlegajos__legidnomape_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtlegajos__legidnomape_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtlegajos__legidnomape_Enabled), 5, 0), !bGXsfl_25_Refreshing);
   }

   public void rf9W2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtlegajossContainer.ClearRows();
      }
      wbStart = (short)(25) ;
      /* Execute user event: Refresh */
      e159W2 ();
      nGXsfl_25_idx = (int)(1+GRIDSDTLEGAJOSS_nFirstRecordOnPage) ;
      sGXsfl_25_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_252( ) ;
      bGXsfl_25_Refreshing = true ;
      GridsdtlegajossContainer.AddObjectProperty("GridName", "Gridsdtlegajoss");
      GridsdtlegajossContainer.AddObjectProperty("CmpContext", "");
      GridsdtlegajossContainer.AddObjectProperty("InMasterPage", "false");
      GridsdtlegajossContainer.AddObjectProperty("Class", "WorkWith");
      GridsdtlegajossContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridsdtlegajossContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridsdtlegajossContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridsdtlegajossContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Visible, (byte)(5), (byte)(0), ".", "")));
      GridsdtlegajossContainer.setPageSize( subgridsdtlegajoss_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_252( ) ;
         e149W2 ();
         if ( ( GRIDSDTLEGAJOSS_nCurrentRecord > 0 ) && ( GRIDSDTLEGAJOSS_nGridOutOfScope == 0 ) && ( nGXsfl_25_idx == 1 ) )
         {
            GRIDSDTLEGAJOSS_nCurrentRecord = 0 ;
            GRIDSDTLEGAJOSS_nGridOutOfScope = 1 ;
            subgridsdtlegajoss_firstpage( ) ;
            e149W2 ();
         }
         wbEnd = (short)(25) ;
         wb9W0( ) ;
      }
      bGXsfl_25_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes9W2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQPERIODO", localUtil.dtoc( AV12LiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQPERIODO", getSecureSignedToken( "", AV12LiqPeriodo));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
   }

   public int subgridsdtlegajoss_fnc_pagecount( )
   {
      GRIDSDTLEGAJOSS_nRecordCount = subgridsdtlegajoss_fnc_recordcount( ) ;
      if ( ((int)((GRIDSDTLEGAJOSS_nRecordCount) % (subgridsdtlegajoss_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDSDTLEGAJOSS_nRecordCount/ (double) (subgridsdtlegajoss_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDSDTLEGAJOSS_nRecordCount/ (double) (subgridsdtlegajoss_fnc_recordsperpage( )))+1) ;
   }

   public int subgridsdtlegajoss_fnc_recordcount( )
   {
      return AV5SDTLegajos.size() ;
   }

   public int subgridsdtlegajoss_fnc_recordsperpage( )
   {
      if ( subGridsdtlegajoss_Rows > 0 )
      {
         return subGridsdtlegajoss_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridsdtlegajoss_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDSDTLEGAJOSS_nFirstRecordOnPage/ (double) (subgridsdtlegajoss_fnc_recordsperpage( )))+1) ;
   }

   public short subgridsdtlegajoss_firstpage( )
   {
      GRIDSDTLEGAJOSS_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTLEGAJOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtlegajoss_refresh( subGridsdtlegajoss_Rows, AV12LiqPeriodo, AV9EmpCod, AV8CliCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtlegajoss_nextpage( )
   {
      GRIDSDTLEGAJOSS_nRecordCount = subgridsdtlegajoss_fnc_recordcount( ) ;
      if ( ( GRIDSDTLEGAJOSS_nRecordCount >= subgridsdtlegajoss_fnc_recordsperpage( ) ) && ( GRIDSDTLEGAJOSS_nEOF == 0 ) )
      {
         GRIDSDTLEGAJOSS_nFirstRecordOnPage = (long)(GRIDSDTLEGAJOSS_nFirstRecordOnPage+subgridsdtlegajoss_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      if ( GRIDSDTLEGAJOSS_nEOF == 1 )
      {
         GRIDSDTLEGAJOSS_nFirstRecordOnPage = GRIDSDTLEGAJOSS_nCurrentRecord ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTLEGAJOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridsdtlegajossContainer.AddObjectProperty("GRIDSDTLEGAJOSS_nFirstRecordOnPage", GRIDSDTLEGAJOSS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtlegajoss_refresh( subGridsdtlegajoss_Rows, AV12LiqPeriodo, AV9EmpCod, AV8CliCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDSDTLEGAJOSS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridsdtlegajoss_previouspage( )
   {
      if ( GRIDSDTLEGAJOSS_nFirstRecordOnPage >= subgridsdtlegajoss_fnc_recordsperpage( ) )
      {
         GRIDSDTLEGAJOSS_nFirstRecordOnPage = (long)(GRIDSDTLEGAJOSS_nFirstRecordOnPage-subgridsdtlegajoss_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTLEGAJOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtlegajoss_refresh( subGridsdtlegajoss_Rows, AV12LiqPeriodo, AV9EmpCod, AV8CliCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtlegajoss_lastpage( )
   {
      GRIDSDTLEGAJOSS_nRecordCount = subgridsdtlegajoss_fnc_recordcount( ) ;
      if ( GRIDSDTLEGAJOSS_nRecordCount > subgridsdtlegajoss_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDSDTLEGAJOSS_nRecordCount) % (subgridsdtlegajoss_fnc_recordsperpage( )))) == 0 )
         {
            GRIDSDTLEGAJOSS_nFirstRecordOnPage = (long)(GRIDSDTLEGAJOSS_nRecordCount-subgridsdtlegajoss_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDSDTLEGAJOSS_nFirstRecordOnPage = (long)(GRIDSDTLEGAJOSS_nRecordCount-((int)((GRIDSDTLEGAJOSS_nRecordCount) % (subgridsdtlegajoss_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDSDTLEGAJOSS_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTLEGAJOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtlegajoss_refresh( subGridsdtlegajoss_Rows, AV12LiqPeriodo, AV9EmpCod, AV8CliCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridsdtlegajoss_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDSDTLEGAJOSS_nFirstRecordOnPage = (long)(subgridsdtlegajoss_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDSDTLEGAJOSS_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTLEGAJOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtlegajoss_refresh( subGridsdtlegajoss_Rows, AV12LiqPeriodo, AV9EmpCod, AV8CliCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavLiqnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqnombre_Enabled), 5, 0), true);
      edtavCntleg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCntleg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntleg_Enabled), 5, 0), true);
      edtavSdtlegajos__legnumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtlegajos__legnumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtlegajos__legnumero_Enabled), 5, 0), !bGXsfl_25_Refreshing);
      chkavSdtlegajos__seleccionado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavSdtlegajos__seleccionado.getInternalname(), "Enabled", GXutil.ltrimstr( chkavSdtlegajos__seleccionado.getEnabled(), 5, 0), !bGXsfl_25_Refreshing);
      edtavSdtlegajos__legidnomape_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtlegajos__legidnomape_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtlegajos__legidnomape_Enabled), 5, 0), !bGXsfl_25_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup9W0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e139W2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtlegajos"), AV5SDTLegajos);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTLEGAJOS"), AV5SDTLegajos);
         /* Read saved values. */
         nRC_GXsfl_25 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_25"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRIDSDTLEGAJOSS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSDTLEGAJOSS_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRIDSDTLEGAJOSS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTLEGAJOSS_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGridsdtlegajoss_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTLEGAJOSS_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridsdtlegajoss_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTLEGAJOSS_EMPOWERER_Gridinternalname") ;
         Gridsdtlegajoss_empowerer_Infinitescrolling = httpContext.cgiGet( "GRIDSDTLEGAJOSS_EMPOWERER_Infinitescrolling") ;
         nRC_GXsfl_25 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_25"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_25_fel_idx = 0 ;
         while ( nGXsfl_25_fel_idx < nRC_GXsfl_25 )
         {
            nGXsfl_25_fel_idx = ((subGridsdtlegajoss_Islastpage==1)&&(nGXsfl_25_fel_idx+1>subgridsdtlegajoss_fnc_recordsperpage( )) ? 1 : nGXsfl_25_fel_idx+1) ;
            sGXsfl_25_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_252( ) ;
            AV39GXV1 = nGXsfl_25_fel_idx ;
            if ( ( AV5SDTLegajos.size() >= AV39GXV1 ) && ( AV39GXV1 > 0 ) )
            {
               AV5SDTLegajos.currentItem( ((web.SdtSDTLegajos_SDTLegajosItem)AV5SDTLegajos.elementAt(-1+AV39GXV1)) );
            }
         }
         if ( nGXsfl_25_fel_idx == 0 )
         {
            nGXsfl_25_idx = 1 ;
            sGXsfl_25_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_252( ) ;
         }
         nGXsfl_25_fel_idx = 1 ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCntleg_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCntleg_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCNTLEG");
            GX_FocusControl = edtavCntleg_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV36CntLeg = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36CntLeg", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36CntLeg), 6, 0));
         }
         else
         {
            AV36CntLeg = (int)(localUtil.ctol( httpContext.cgiGet( edtavCntleg_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36CntLeg", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36CntLeg), 6, 0));
         }
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
      e139W2 ();
      if (returnInSub) return;
   }

   public void e139W2( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGridsdtlegajoss_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, "GridsdtlegajossContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGridsdtlegajoss_Visible), 5, 0), true);
      edtavTliqcod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTliqcod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTliqcod_Visible), 5, 0), true);
      Gridsdtlegajoss_empowerer_Gridinternalname = subGridsdtlegajoss_Internalname ;
      ucGridsdtlegajoss_empowerer.sendProperty(context, "", false, Gridsdtlegajoss_empowerer_Internalname, "GridInternalName", Gridsdtlegajoss_empowerer_Gridinternalname);
      subGridsdtlegajoss_Rows = 5 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Rows, (byte)(6), (byte)(0), ".", "")));
      GXt_char1 = AV33ConCodigo ;
      GXt_char2 = AV33ConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_sueldojornal_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      confirmarliquidacion_impl.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      confirmarliquidacion_impl.this.GXt_char1 = GXv_char4[0] ;
      AV33ConCodigo = GXt_char1 ;
      AV21LegNumeroJson = AV29websession.getValue(httpContext.getMessage( "&confirmar_LegNumero", "")) ;
      AV20legsIN.fromJSonString(AV21LegNumeroJson, null);
      AV36CntLeg = AV20legsIN.size() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36CntLeg", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36CntLeg), 6, 0));
   }

   private void e149W2( )
   {
      /* Gridsdtlegajoss_Load Routine */
      returnInSub = false ;
      AV39GXV1 = 1 ;
      while ( AV39GXV1 <= AV5SDTLegajos.size() )
      {
         AV5SDTLegajos.currentItem( ((web.SdtSDTLegajos_SDTLegajosItem)AV5SDTLegajos.elementAt(-1+AV39GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(25) ;
         }
         if ( ( subGridsdtlegajoss_Islastpage == 1 ) || ( subGridsdtlegajoss_Rows == 0 ) || ( ( GRIDSDTLEGAJOSS_nCurrentRecord >= GRIDSDTLEGAJOSS_nFirstRecordOnPage ) && ( GRIDSDTLEGAJOSS_nCurrentRecord < GRIDSDTLEGAJOSS_nFirstRecordOnPage + subgridsdtlegajoss_fnc_recordsperpage( ) ) ) )
         {
            sendrow_252( ) ;
            GRIDSDTLEGAJOSS_nEOF = (byte)(0) ;
            web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTLEGAJOSS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTLEGAJOSS_nCurrentRecord + 1 >= subgridsdtlegajoss_fnc_recordcount( ) )
            {
               GRIDSDTLEGAJOSS_nEOF = (byte)(1) ;
               web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTLEGAJOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTLEGAJOSS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTLEGAJOSS_nCurrentRecord = (long)(GRIDSDTLEGAJOSS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_25_Refreshing )
         {
            httpContext.doAjaxLoad(25, GridsdtlegajossRow);
         }
         AV39GXV1 = (int)(AV39GXV1+1) ;
      }
   }

   public void e119W2( )
   {
      /* 'DoConfirmar' Routine */
      returnInSub = false ;
      AV26Respuesta = httpContext.getMessage( "OK", "") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Respuesta", AV26Respuesta);
      httpContext.setWebReturnParms(new Object[] {Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),localUtil.format( AV12LiqPeriodo, "99/99/9999"),AV11TLiqCod,AV26Respuesta});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV8CliCod","AV9EmpCod","AV12LiqPeriodo","AV11TLiqCod","AV26Respuesta"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
      /*  Sending Event outputs  */
   }

   public void e129W2( )
   {
      /* 'DoCancelar' Routine */
      returnInSub = false ;
      AV26Respuesta = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Respuesta", AV26Respuesta);
      httpContext.setWebReturnParms(new Object[] {Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),localUtil.format( AV12LiqPeriodo, "99/99/9999"),AV11TLiqCod,AV26Respuesta});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV8CliCod","AV9EmpCod","AV12LiqPeriodo","AV11TLiqCod","AV26Respuesta"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
      /*  Sending Event outputs  */
   }

   public void e159W2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int5 = AV8CliCod ;
      GXv_int6[0] = GXt_int5 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int6) ;
      confirmarliquidacion_impl.this.GXt_int5 = GXv_int6[0] ;
      AV8CliCod = GXt_int5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
      /*  Sending Event outputs  */
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
      AV9EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpCod), "ZZZ9")));
      AV12LiqPeriodo = (java.util.Date)getParm(obj,2) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12LiqPeriodo", localUtil.format(AV12LiqPeriodo, "99/99/9999"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQPERIODO", getSecureSignedToken( "", AV12LiqPeriodo));
      AV11TLiqCod = (String)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11TLiqCod", AV11TLiqCod);
      AV26Respuesta = (String)getParm(obj,4) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Respuesta", AV26Respuesta);
      AV10LiqNombre = (String)getParm(obj,5) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10LiqNombre", AV10LiqNombre);
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
      pa9W2( ) ;
      ws9W2( ) ;
      we9W2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713321922", true, true);
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
      httpContext.AddJavascriptSource("confirmarliquidacion.js", "?20251713321922", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_252( )
   {
      edtavSdtlegajos__legnumero_Internalname = "SDTLEGAJOS__LEGNUMERO_"+sGXsfl_25_idx ;
      chkavSdtlegajos__seleccionado.setInternalname( "SDTLEGAJOS__SELECCIONADO_"+sGXsfl_25_idx );
      edtavSdtlegajos__legidnomape_Internalname = "SDTLEGAJOS__LEGIDNOMAPE_"+sGXsfl_25_idx ;
   }

   public void subsflControlProps_fel_252( )
   {
      edtavSdtlegajos__legnumero_Internalname = "SDTLEGAJOS__LEGNUMERO_"+sGXsfl_25_fel_idx ;
      chkavSdtlegajos__seleccionado.setInternalname( "SDTLEGAJOS__SELECCIONADO_"+sGXsfl_25_fel_idx );
      edtavSdtlegajos__legidnomape_Internalname = "SDTLEGAJOS__LEGIDNOMAPE_"+sGXsfl_25_fel_idx ;
   }

   public void sendrow_252( )
   {
      subsflControlProps_252( ) ;
      wb9W0( ) ;
      if ( ( subGridsdtlegajoss_Rows * 1 == 0 ) || ( nGXsfl_25_idx - GRIDSDTLEGAJOSS_nFirstRecordOnPage <= subgridsdtlegajoss_fnc_recordsperpage( ) * 1 ) )
      {
         GridsdtlegajossRow = GXWebRow.GetNew(context,GridsdtlegajossContainer) ;
         if ( subGridsdtlegajoss_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridsdtlegajoss_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridsdtlegajoss_Class, "") != 0 )
            {
               subGridsdtlegajoss_Linesclass = subGridsdtlegajoss_Class+"Odd" ;
            }
         }
         else if ( subGridsdtlegajoss_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridsdtlegajoss_Backstyle = (byte)(0) ;
            subGridsdtlegajoss_Backcolor = subGridsdtlegajoss_Allbackcolor ;
            if ( GXutil.strcmp(subGridsdtlegajoss_Class, "") != 0 )
            {
               subGridsdtlegajoss_Linesclass = subGridsdtlegajoss_Class+"Uniform" ;
            }
         }
         else if ( subGridsdtlegajoss_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridsdtlegajoss_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridsdtlegajoss_Class, "") != 0 )
            {
               subGridsdtlegajoss_Linesclass = subGridsdtlegajoss_Class+"Odd" ;
            }
            subGridsdtlegajoss_Backcolor = (int)(0x0) ;
         }
         else if ( subGridsdtlegajoss_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridsdtlegajoss_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_25_idx) % (2))) == 0 )
            {
               subGridsdtlegajoss_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtlegajoss_Class, "") != 0 )
               {
                  subGridsdtlegajoss_Linesclass = subGridsdtlegajoss_Class+"Even" ;
               }
            }
            else
            {
               subGridsdtlegajoss_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtlegajoss_Class, "") != 0 )
               {
                  subGridsdtlegajoss_Linesclass = subGridsdtlegajoss_Class+"Odd" ;
               }
            }
         }
         if ( GridsdtlegajossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_25_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtlegajossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtlegajossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtlegajos__legnumero_Internalname,GXutil.ltrim( localUtil.ntoc( ((web.SdtSDTLegajos_SDTLegajosItem)AV5SDTLegajos.elementAt(-1+AV39GXV1)).getgxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero(), (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavSdtlegajos__legnumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((web.SdtSDTLegajos_SDTLegajosItem)AV5SDTLegajos.elementAt(-1+AV39GXV1)).getgxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero()), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((web.SdtSDTLegajos_SDTLegajosItem)AV5SDTLegajos.elementAt(-1+AV39GXV1)).getgxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero()), "ZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtlegajos__legnumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavSdtlegajos__legnumero_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(25),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsdtlegajossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "SDTLEGAJOS__SELECCIONADO_" + sGXsfl_25_idx ;
         chkavSdtlegajos__seleccionado.setName( GXCCtl );
         chkavSdtlegajos__seleccionado.setWebtags( "" );
         chkavSdtlegajos__seleccionado.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavSdtlegajos__seleccionado.getInternalname(), "TitleCaption", chkavSdtlegajos__seleccionado.getCaption(), !bGXsfl_25_Refreshing);
         chkavSdtlegajos__seleccionado.setCheckedValue( "false" );
         GridsdtlegajossRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavSdtlegajos__seleccionado.getInternalname(),GXutil.booltostr( ((web.SdtSDTLegajos_SDTLegajosItem)AV5SDTLegajos.elementAt(-1+AV39GXV1)).getgxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado()),"","",Integer.valueOf(0),Integer.valueOf(chkavSdtlegajos__seleccionado.getEnabled()),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridsdtlegajossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtlegajossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtlegajos__legidnomape_Internalname,((web.SdtSDTLegajos_SDTLegajosItem)AV5SDTLegajos.elementAt(-1+AV39GXV1)).getgxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtlegajos__legidnomape_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtlegajos__legidnomape_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(25),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes9W2( ) ;
         GridsdtlegajossContainer.AddRow(GridsdtlegajossRow);
         nGXsfl_25_idx = ((subGridsdtlegajoss_Islastpage==1)&&(nGXsfl_25_idx+1>subgridsdtlegajoss_fnc_recordsperpage( )) ? 1 : nGXsfl_25_idx+1) ;
         sGXsfl_25_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_252( ) ;
      }
      /* End function sendrow_252 */
   }

   public void startgridcontrol25( )
   {
      if ( GridsdtlegajossContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridsdtlegajossContainer"+"DivS\" data-gxgridid=\"25\">") ;
         sStyleString = "" ;
         if ( subGridsdtlegajoss_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, subGridsdtlegajoss_Internalname, subGridsdtlegajoss_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridsdtlegajoss_Backcolorstyle == 0 )
         {
            subGridsdtlegajoss_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridsdtlegajoss_Class) > 0 )
            {
               subGridsdtlegajoss_Linesclass = subGridsdtlegajoss_Class+"Title" ;
            }
         }
         else
         {
            subGridsdtlegajoss_Titlebackstyle = (byte)(1) ;
            if ( subGridsdtlegajoss_Backcolorstyle == 1 )
            {
               subGridsdtlegajoss_Titlebackcolor = subGridsdtlegajoss_Allbackcolor ;
               if ( GXutil.len( subGridsdtlegajoss_Class) > 0 )
               {
                  subGridsdtlegajoss_Linesclass = subGridsdtlegajoss_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridsdtlegajoss_Class) > 0 )
               {
                  subGridsdtlegajoss_Linesclass = subGridsdtlegajoss_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Legajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Legajos", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridsdtlegajossContainer.AddObjectProperty("GridName", "Gridsdtlegajoss");
      }
      else
      {
         GridsdtlegajossContainer.AddObjectProperty("GridName", "Gridsdtlegajoss");
         GridsdtlegajossContainer.AddObjectProperty("Header", subGridsdtlegajoss_Header);
         GridsdtlegajossContainer.AddObjectProperty("Class", "WorkWith");
         GridsdtlegajossContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridsdtlegajossContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridsdtlegajossContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridsdtlegajossContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Visible, (byte)(5), (byte)(0), ".", "")));
         GridsdtlegajossContainer.AddObjectProperty("CmpContext", "");
         GridsdtlegajossContainer.AddObjectProperty("InMasterPage", "false");
         GridsdtlegajossColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtlegajossColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtlegajos__legnumero_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridsdtlegajossContainer.AddColumnProperties(GridsdtlegajossColumn);
         GridsdtlegajossColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtlegajossColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkavSdtlegajos__seleccionado.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridsdtlegajossContainer.AddColumnProperties(GridsdtlegajossColumn);
         GridsdtlegajossColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtlegajossColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtlegajos__legidnomape_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridsdtlegajossContainer.AddColumnProperties(GridsdtlegajossColumn);
         GridsdtlegajossContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridsdtlegajossContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridsdtlegajossContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridsdtlegajossContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridsdtlegajossContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridsdtlegajossContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridsdtlegajossContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsdtlegajoss_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      edtavLiqnombre_Internalname = "vLIQNOMBRE" ;
      edtavCntleg_Internalname = "vCNTLEG" ;
      edtavSdtlegajos__legnumero_Internalname = "SDTLEGAJOS__LEGNUMERO" ;
      chkavSdtlegajos__seleccionado.setInternalname( "SDTLEGAJOS__SELECCIONADO" );
      edtavSdtlegajos__legidnomape_Internalname = "SDTLEGAJOS__LEGIDNOMAPE" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnconfirmar_Internalname = "BTNCONFIRMAR" ;
      bttBtncancelar_Internalname = "BTNCANCELAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavTliqcod_Internalname = "vTLIQCOD" ;
      Gridsdtlegajoss_empowerer_Internalname = "GRIDSDTLEGAJOSS_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridsdtlegajoss_Internalname = "GRIDSDTLEGAJOSS" ;
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
      subGridsdtlegajoss_Allowcollapsing = (byte)(0) ;
      subGridsdtlegajoss_Allowselection = (byte)(0) ;
      subGridsdtlegajoss_Header = "" ;
      edtavSdtlegajos__legidnomape_Jsonclick = "" ;
      edtavSdtlegajos__legidnomape_Enabled = 0 ;
      chkavSdtlegajos__seleccionado.setCaption( "" );
      chkavSdtlegajos__seleccionado.setEnabled( 0 );
      edtavSdtlegajos__legnumero_Jsonclick = "" ;
      edtavSdtlegajos__legnumero_Enabled = 0 ;
      subGridsdtlegajoss_Class = "WorkWith" ;
      subGridsdtlegajoss_Backcolorstyle = (byte)(0) ;
      edtavSdtlegajos__legidnomape_Enabled = -1 ;
      chkavSdtlegajos__seleccionado.setEnabled( -1 );
      edtavSdtlegajos__legnumero_Enabled = -1 ;
      edtavTliqcod_Jsonclick = "" ;
      edtavTliqcod_Visible = 1 ;
      subGridsdtlegajoss_Visible = 1 ;
      edtavCntleg_Jsonclick = "" ;
      edtavCntleg_Enabled = 1 ;
      edtavLiqnombre_Enabled = 0 ;
      Gridsdtlegajoss_empowerer_Infinitescrolling = "Grid" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Confirmar alta de liquidación", "") );
      subGridsdtlegajoss_Rows = 50 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "SDTLEGAJOS__SELECCIONADO_" + sGXsfl_25_idx ;
      chkavSdtlegajos__seleccionado.setName( GXCCtl );
      chkavSdtlegajos__seleccionado.setWebtags( "" );
      chkavSdtlegajos__seleccionado.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavSdtlegajos__seleccionado.getInternalname(), "TitleCaption", chkavSdtlegajos__seleccionado.getCaption(), !bGXsfl_25_Refreshing);
      chkavSdtlegajos__seleccionado.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDSDTLEGAJOSS_nFirstRecordOnPage'},{av:'GRIDSDTLEGAJOSS_nEOF'},{av:'AV5SDTLegajos',fld:'vSDTLEGAJOS',grid:25,pic:''},{av:'nGXsfl_25_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:25},{av:'nRC_GXsfl_25',ctrl:'GRIDSDTLEGAJOSS',prop:'GridRC',grid:25},{av:'subGridsdtlegajoss_Rows',ctrl:'GRIDSDTLEGAJOSS',prop:'Rows'},{av:'AV12LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("GRIDSDTLEGAJOSS.LOAD","{handler:'e149W2',iparms:[]");
      setEventMetadata("GRIDSDTLEGAJOSS.LOAD",",oparms:[]}");
      setEventMetadata("'DOCONFIRMAR'","{handler:'e119W2',iparms:[{av:'AV11TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV12LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("'DOCONFIRMAR'",",oparms:[{av:'AV26Respuesta',fld:'vRESPUESTA',pic:''}]}");
      setEventMetadata("'DOCANCELAR'","{handler:'e129W2',iparms:[{av:'AV11TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV12LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("'DOCANCELAR'",",oparms:[{av:'AV26Respuesta',fld:'vRESPUESTA',pic:''}]}");
      setEventMetadata("GRIDSDTLEGAJOSS_FIRSTPAGE","{handler:'subgridsdtlegajoss_firstpage',iparms:[{av:'GRIDSDTLEGAJOSS_nFirstRecordOnPage'},{av:'GRIDSDTLEGAJOSS_nEOF'},{av:'subGridsdtlegajoss_Rows',ctrl:'GRIDSDTLEGAJOSS',prop:'Rows'},{av:'AV12LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV5SDTLegajos',fld:'vSDTLEGAJOS',grid:25,pic:''},{av:'nGXsfl_25_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:25},{av:'nRC_GXsfl_25',ctrl:'GRIDSDTLEGAJOSS',prop:'GridRC',grid:25}]");
      setEventMetadata("GRIDSDTLEGAJOSS_FIRSTPAGE",",oparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("GRIDSDTLEGAJOSS_PREVPAGE","{handler:'subgridsdtlegajoss_previouspage',iparms:[{av:'GRIDSDTLEGAJOSS_nFirstRecordOnPage'},{av:'GRIDSDTLEGAJOSS_nEOF'},{av:'subGridsdtlegajoss_Rows',ctrl:'GRIDSDTLEGAJOSS',prop:'Rows'},{av:'AV12LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV5SDTLegajos',fld:'vSDTLEGAJOS',grid:25,pic:''},{av:'nGXsfl_25_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:25},{av:'nRC_GXsfl_25',ctrl:'GRIDSDTLEGAJOSS',prop:'GridRC',grid:25}]");
      setEventMetadata("GRIDSDTLEGAJOSS_PREVPAGE",",oparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("GRIDSDTLEGAJOSS_NEXTPAGE","{handler:'subgridsdtlegajoss_nextpage',iparms:[{av:'GRIDSDTLEGAJOSS_nFirstRecordOnPage'},{av:'GRIDSDTLEGAJOSS_nEOF'},{av:'subGridsdtlegajoss_Rows',ctrl:'GRIDSDTLEGAJOSS',prop:'Rows'},{av:'AV12LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV5SDTLegajos',fld:'vSDTLEGAJOS',grid:25,pic:''},{av:'nGXsfl_25_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:25},{av:'nRC_GXsfl_25',ctrl:'GRIDSDTLEGAJOSS',prop:'GridRC',grid:25}]");
      setEventMetadata("GRIDSDTLEGAJOSS_NEXTPAGE",",oparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("GRIDSDTLEGAJOSS_LASTPAGE","{handler:'subgridsdtlegajoss_lastpage',iparms:[{av:'GRIDSDTLEGAJOSS_nFirstRecordOnPage'},{av:'GRIDSDTLEGAJOSS_nEOF'},{av:'subGridsdtlegajoss_Rows',ctrl:'GRIDSDTLEGAJOSS',prop:'Rows'},{av:'AV12LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV5SDTLegajos',fld:'vSDTLEGAJOS',grid:25,pic:''},{av:'nGXsfl_25_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:25},{av:'nRC_GXsfl_25',ctrl:'GRIDSDTLEGAJOSS',prop:'GridRC',grid:25}]");
      setEventMetadata("GRIDSDTLEGAJOSS_LASTPAGE",",oparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv4',iparms:[]");
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
      wcpOAV12LiqPeriodo = GXutil.nullDate() ;
      wcpOAV11TLiqCod = "" ;
      wcpOAV26Respuesta = "" ;
      wcpOAV10LiqNombre = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV12LiqPeriodo = GXutil.nullDate() ;
      AV11TLiqCod = "" ;
      AV26Respuesta = "" ;
      AV10LiqNombre = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV5SDTLegajos = new GXBaseCollection<web.SdtSDTLegajos_SDTLegajosItem>(web.SdtSDTLegajos_SDTLegajosItem.class, "SDTLegajosItem", "PayDay", remoteHandle);
      Gridsdtlegajoss_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      GridsdtlegajossContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      bttBtnconfirmar_Jsonclick = "" ;
      bttBtncancelar_Jsonclick = "" ;
      ucGridsdtlegajoss_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GXCCtl = "" ;
      AV33ConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV21LegNumeroJson = "" ;
      AV29websession = httpContext.getWebSession();
      AV20legsIN = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      GridsdtlegajossRow = new com.genexus.webpanels.GXWebRow();
      GXv_int6 = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridsdtlegajoss_Linesclass = "" ;
      ROClassString = "" ;
      GridsdtlegajossColumn = new com.genexus.webpanels.GXWebColumn();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavLiqnombre_Enabled = 0 ;
      edtavCntleg_Enabled = 0 ;
      edtavSdtlegajos__legnumero_Enabled = 0 ;
      chkavSdtlegajos__seleccionado.setEnabled( 0 );
      edtavSdtlegajos__legidnomape_Enabled = 0 ;
   }

   private byte GRIDSDTLEGAJOSS_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGridsdtlegajoss_Backcolorstyle ;
   private byte nGXWrapped ;
   private byte subGridsdtlegajoss_Backstyle ;
   private byte subGridsdtlegajoss_Titlebackstyle ;
   private byte subGridsdtlegajoss_Allowselection ;
   private byte subGridsdtlegajoss_Allowhovering ;
   private byte subGridsdtlegajoss_Allowcollapsing ;
   private byte subGridsdtlegajoss_Collapsed ;
   private short wcpOAV9EmpCod ;
   private short AV9EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV8CliCod ;
   private int nRC_GXsfl_25 ;
   private int subGridsdtlegajoss_Rows ;
   private int AV8CliCod ;
   private int nGXsfl_25_idx=1 ;
   private int edtavLiqnombre_Enabled ;
   private int AV36CntLeg ;
   private int edtavCntleg_Enabled ;
   private int AV39GXV1 ;
   private int subGridsdtlegajoss_Visible ;
   private int edtavTliqcod_Visible ;
   private int subGridsdtlegajoss_Islastpage ;
   private int edtavSdtlegajos__legnumero_Enabled ;
   private int edtavSdtlegajos__legidnomape_Enabled ;
   private int GRIDSDTLEGAJOSS_nGridOutOfScope ;
   private int nGXsfl_25_fel_idx=1 ;
   private int GXt_int5 ;
   private int GXv_int6[] ;
   private int idxLst ;
   private int subGridsdtlegajoss_Backcolor ;
   private int subGridsdtlegajoss_Allbackcolor ;
   private int subGridsdtlegajoss_Titlebackcolor ;
   private int subGridsdtlegajoss_Selectedindex ;
   private int subGridsdtlegajoss_Selectioncolor ;
   private int subGridsdtlegajoss_Hoveringcolor ;
   private long GRIDSDTLEGAJOSS_nFirstRecordOnPage ;
   private long GRIDSDTLEGAJOSS_nCurrentRecord ;
   private long GRIDSDTLEGAJOSS_nRecordCount ;
   private String wcpOAV11TLiqCod ;
   private String wcpOAV26Respuesta ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV11TLiqCod ;
   private String AV26Respuesta ;
   private String sGXsfl_25_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Gridsdtlegajoss_empowerer_Gridinternalname ;
   private String Gridsdtlegajoss_empowerer_Infinitescrolling ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String edtavLiqnombre_Internalname ;
   private String edtavCntleg_Internalname ;
   private String TempTags ;
   private String edtavCntleg_Jsonclick ;
   private String sStyleString ;
   private String subGridsdtlegajoss_Internalname ;
   private String bttBtnconfirmar_Internalname ;
   private String bttBtnconfirmar_Jsonclick ;
   private String bttBtncancelar_Internalname ;
   private String bttBtncancelar_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavTliqcod_Internalname ;
   private String edtavTliqcod_Jsonclick ;
   private String Gridsdtlegajoss_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String GXCCtl ;
   private String edtavSdtlegajos__legnumero_Internalname ;
   private String edtavSdtlegajos__legidnomape_Internalname ;
   private String sGXsfl_25_fel_idx="0001" ;
   private String AV33ConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String subGridsdtlegajoss_Class ;
   private String subGridsdtlegajoss_Linesclass ;
   private String ROClassString ;
   private String edtavSdtlegajos__legnumero_Jsonclick ;
   private String edtavSdtlegajos__legidnomape_Jsonclick ;
   private String subGridsdtlegajoss_Header ;
   private java.util.Date wcpOAV12LiqPeriodo ;
   private java.util.Date AV12LiqPeriodo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_25_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String wcpOAV10LiqNombre ;
   private String AV10LiqNombre ;
   private String AV21LegNumeroJson ;
   private GXSimpleCollection<Integer> AV20legsIN ;
   private com.genexus.webpanels.GXWebGrid GridsdtlegajossContainer ;
   private com.genexus.webpanels.GXWebRow GridsdtlegajossRow ;
   private com.genexus.webpanels.GXWebColumn GridsdtlegajossColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV29websession ;
   private com.genexus.webpanels.GXUserControl ucGridsdtlegajoss_empowerer ;
   private ICheckbox chkavSdtlegajos__seleccionado ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.SdtSDTLegajos_SDTLegajosItem> AV5SDTLegajos ;
}

