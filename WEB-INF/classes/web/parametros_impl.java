package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class parametros_impl extends GXDataArea
{
   public parametros_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public parametros_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( parametros_impl.class ));
   }

   public parametros_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavRedondeo = new HTMLChoice();
      chkavLiquidar_adelanto_retencion = UIFactory.getCheckbox(this);
      chkavTodos_30 = UIFactory.getCheckbox(this);
      chkavDesglosar_adicional = UIFactory.getCheckbox(this);
      chkavTliqhabilitada = UIFactory.getCheckbox(this);
      chkavLog_fallido = UIFactory.getCheckbox(this);
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
            AV47MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47MenuOpcCod", AV47MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV47MenuOpcCod, ""))));
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
      nRC_GXsfl_83 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_83"))) ;
      nGXsfl_83_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_83_idx"))) ;
      sGXsfl_83_idx = httpContext.GetPar( "sGXsfl_83_idx") ;
      chkavTliqhabilitada.setEnabled( (int)(GXutil.lval( httpContext.GetNextPar( ))) );
      httpContext.ajax_rsp_assign_prop("", false, chkavTliqhabilitada.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTliqhabilitada.getEnabled(), 5, 0), !bGXsfl_83_Refreshing);
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
      chkavTliqhabilitada.setEnabled( (int)(GXutil.lval( httpContext.GetNextPar( ))) );
      httpContext.ajax_rsp_assign_prop("", false, chkavTliqhabilitada.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTliqhabilitada.getEnabled(), 5, 0), !bGXsfl_83_Refreshing);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV44sdt_tipo_liqs);
      AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV15liquidar_adelanto_retencion = GXutil.strtobool( httpContext.GetPar( "liquidar_adelanto_retencion")) ;
      AV26todos_30 = GXutil.strtobool( httpContext.GetPar( "todos_30")) ;
      AV37desglosar_adicional = GXutil.strtobool( httpContext.GetPar( "desglosar_adicional")) ;
      AV16log_fallido = GXutil.strtobool( httpContext.GetPar( "log_fallido")) ;
      AV57Pgmname = httpContext.GetPar( "Pgmname") ;
      AV49ultimoRedondeo = httpContext.GetPar( "ultimoRedondeo") ;
      AV47MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid1_refresh( subGrid1_Rows, AV44sdt_tipo_liqs, AV7CliCod, AV15liquidar_adelanto_retencion, AV26todos_30, AV37desglosar_adicional, AV16log_fallido, AV57Pgmname, AV49ultimoRedondeo, AV47MenuOpcCod) ;
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
      paCM2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startCM2( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.parametros", new String[] {GXutil.URLEncode(GXutil.rtrim(AV47MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV57Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vULTIMOREDONDEO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV49ultimoRedondeo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV47MenuOpcCod, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_83", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_83, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV11DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV11DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMESESSAC_DATA", AV10mesesSAC_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMESESSAC_DATA", AV10mesesSAC_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFORZADOS_HABITUAL_PARAM_DATA", AV29forzados_habitual_param_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFORZADOS_HABITUAL_PARAM_DATA", AV29forzados_habitual_param_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDT_TIPO_LIQS", AV44sdt_tipo_liqs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDT_TIPO_LIQS", AV44sdt_tipo_liqs);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV57Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV57Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vULTIMOREDONDEO", GXutil.rtrim( AV49ultimoRedondeo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vULTIMOREDONDEO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV49ultimoRedondeo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vVACIAFECHA", localUtil.dtoc( AV50vaciaFecha, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV47MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV47MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMESESSAC", AV9mesesSAC);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMESESSAC", AV9mesesSAC);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFORZADOS_HABITUAL_PARAM", AV28forzados_habitual_param);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFORZADOS_HABITUAL_PARAM", AV28forzados_habitual_param);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MESESSAC_Cls", GXutil.rtrim( Combo_mesessac_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MESESSAC_Selectedvalue_set", GXutil.rtrim( Combo_mesessac_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MESESSAC_Datalisttype", GXutil.rtrim( Combo_mesessac_Datalisttype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MESESSAC_Allowmultipleselection", GXutil.booltostr( Combo_mesessac_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MESESSAC_Datalistfixedvalues", GXutil.rtrim( Combo_mesessac_Datalistfixedvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MESESSAC_Includeonlyselectedoption", GXutil.booltostr( Combo_mesessac_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MESESSAC_Emptyitem", GXutil.booltostr( Combo_mesessac_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MESESSAC_Multiplevaluestype", GXutil.rtrim( Combo_mesessac_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORZADOS_HABITUAL_PARAM_Cls", GXutil.rtrim( Combo_forzados_habitual_param_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORZADOS_HABITUAL_PARAM_Selectedvalue_set", GXutil.rtrim( Combo_forzados_habitual_param_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORZADOS_HABITUAL_PARAM_Allowmultipleselection", GXutil.booltostr( Combo_forzados_habitual_param_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORZADOS_HABITUAL_PARAM_Includeonlyselectedoption", GXutil.booltostr( Combo_forzados_habitual_param_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORZADOS_HABITUAL_PARAM_Emptyitem", GXutil.booltostr( Combo_forzados_habitual_param_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORZADOS_HABITUAL_PARAM_Multiplevaluestype", GXutil.rtrim( Combo_forzados_habitual_param_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid1_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MESESSAC_Selectedvalue_get", GXutil.rtrim( Combo_mesessac_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORZADOS_HABITUAL_PARAM_Selectedvalue_get", GXutil.rtrim( Combo_forzados_habitual_param_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "vTLIQHABILITADA_Enabled", GXutil.ltrim( localUtil.ntoc( chkavTliqhabilitada.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MESESSAC_Selectedvalue_get", GXutil.rtrim( Combo_mesessac_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORZADOS_HABITUAL_PARAM_Selectedvalue_get", GXutil.rtrim( Combo_forzados_habitual_param_Selectedvalue_get));
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
         weCM2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtCM2( ) ;
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
      return formatLink("web.parametros", new String[] {GXutil.URLEncode(GXutil.rtrim(AV47MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "Parametros" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Parámetros", "") ;
   }

   public void wbCM0( )
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
         wb_table1_9_CM2( true) ;
      }
      else
      {
         wb_table1_9_CM2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_CM2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'',false,'" + sGXsfl_83_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSac_no_concodigo_Internalname, GXutil.rtrim( AV20sac_no_ConCodigo), GXutil.rtrim( localUtil.format( AV20sac_no_ConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,100);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSac_no_concodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtavSac_no_concodigo_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Parametros.htm");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 101,'',false,'" + sGXsfl_83_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavLog_fallido.getInternalname(), GXutil.booltostr( AV16log_fallido), "", "", chkavLog_fallido.getVisible(), 1, "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(101, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,101);\"");
         /* User Defined Control */
         ucGrid1_empowerer.render(context, "wwp.gridempowerer", Grid1_empowerer_Internalname, "GRID1_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 83 )
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

   public void startCM2( )
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
      strupCM0( ) ;
   }

   public void wsCM2( )
   {
      startCM2( ) ;
      evtCM2( ) ;
   }

   public void evtCM2( )
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
                           e11CM2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCANCELAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoCancelar' */
                           e12CM2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID1.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "'DOVOLVER'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_83_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_83_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_83_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_832( ) ;
                           A32TLiqCod = httpContext.cgiGet( edtTLiqCod_Internalname) ;
                           A340TliqDesc = GXutil.upper( httpContext.cgiGet( edtTliqDesc_Internalname)) ;
                           AV38TLiqHabilitada = GXutil.strtobool( httpContext.cgiGet( chkavTliqhabilitada.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavTliqhabilitada.getInternalname(), AV38TLiqHabilitada);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13CM2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID1.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e14CM2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e15CM2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "'DOVOLVER'") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoVolver' */
                                 e16CM2 ();
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

   public void weCM2( )
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

   public void paCM2( )
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
            GX_FocusControl = cmbavRedondeo.getInternalname() ;
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
      subsflControlProps_832( ) ;
      while ( nGXsfl_83_idx <= nRC_GXsfl_83 )
      {
         sendrow_832( ) ;
         nGXsfl_83_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_83_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_83_idx+1) ;
         sGXsfl_83_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_83_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_832( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid1Container)) ;
      /* End function gxnrGrid1_newrow */
   }

   public void gxgrgrid1_refresh( int subGrid1_Rows ,
                                  GXBaseCollection<web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem> AV44sdt_tipo_liqs ,
                                  int AV7CliCod ,
                                  boolean AV15liquidar_adelanto_retencion ,
                                  boolean AV26todos_30 ,
                                  boolean AV37desglosar_adicional ,
                                  boolean AV16log_fallido ,
                                  String AV57Pgmname ,
                                  String AV49ultimoRedondeo ,
                                  String AV47MenuOpcCod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e15CM2 ();
      GRID1_nCurrentRecord = 0 ;
      rfCM2( ) ;
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
      if ( cmbavRedondeo.getItemCount() > 0 )
      {
         AV48redondeo = cmbavRedondeo.getValidValue(AV48redondeo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48redondeo", AV48redondeo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavRedondeo.setValue( GXutil.rtrim( AV48redondeo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavRedondeo.getInternalname(), "Values", cmbavRedondeo.ToJavascriptSource(), true);
      }
      AV15liquidar_adelanto_retencion = GXutil.strtobool( GXutil.booltostr( AV15liquidar_adelanto_retencion)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15liquidar_adelanto_retencion", AV15liquidar_adelanto_retencion);
      AV26todos_30 = GXutil.strtobool( GXutil.booltostr( AV26todos_30)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26todos_30", AV26todos_30);
      AV37desglosar_adicional = GXutil.strtobool( GXutil.booltostr( AV37desglosar_adicional)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37desglosar_adicional", AV37desglosar_adicional);
      AV16log_fallido = GXutil.strtobool( GXutil.booltostr( AV16log_fallido)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16log_fallido", AV16log_fallido);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfCM2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV57Pgmname = "Parametros" ;
      Gx_err = (short)(0) ;
   }

   public void rfCM2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid1Container.ClearRows();
      }
      wbStart = (short)(83) ;
      /* Execute user event: Refresh */
      e15CM2 ();
      nGXsfl_83_idx = 1 ;
      sGXsfl_83_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_83_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_832( ) ;
      bGXsfl_83_Refreshing = true ;
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
         subsflControlProps_832( ) ;
         GXPagingFrom2 = (int)(((subGrid1_Rows==0) ? 0 : GRID1_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid1_Rows==0) ? 10000 : subgrid1_fnc_recordsperpage( )+1) ;
         /* Using cursor H00CM2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV7CliCod), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_83_idx = 1 ;
         sGXsfl_83_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_83_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_832( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid1_Rows == 0 ) || ( GRID1_nCurrentRecord < subgrid1_fnc_recordsperpage( ) ) ) ) )
         {
            A3CliCod = H00CM2_A3CliCod[0] ;
            A340TliqDesc = H00CM2_A340TliqDesc[0] ;
            A32TLiqCod = H00CM2_A32TLiqCod[0] ;
            e14CM2 ();
            pr_default.readNext(0);
         }
         GRID1_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(83) ;
         wbCM0( ) ;
      }
      bGXsfl_83_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesCM2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_TLIQCOD"+"_"+sGXsfl_83_idx, getSecureSignedToken( sGXsfl_83_idx, GXutil.rtrim( localUtil.format( A32TLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_TLIQDESC"+"_"+sGXsfl_83_idx, getSecureSignedToken( sGXsfl_83_idx, GXutil.rtrim( localUtil.format( A340TliqDesc, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV57Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV57Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vULTIMOREDONDEO", GXutil.rtrim( AV49ultimoRedondeo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vULTIMOREDONDEO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV49ultimoRedondeo, ""))));
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
      /* Using cursor H00CM3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV7CliCod)});
      GRID1_nRecordCount = H00CM3_AGRID1_nRecordCount[0] ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV44sdt_tipo_liqs, AV7CliCod, AV15liquidar_adelanto_retencion, AV26todos_30, AV37desglosar_adicional, AV16log_fallido, AV57Pgmname, AV49ultimoRedondeo, AV47MenuOpcCod) ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV44sdt_tipo_liqs, AV7CliCod, AV15liquidar_adelanto_retencion, AV26todos_30, AV37desglosar_adicional, AV16log_fallido, AV57Pgmname, AV49ultimoRedondeo, AV47MenuOpcCod) ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV44sdt_tipo_liqs, AV7CliCod, AV15liquidar_adelanto_retencion, AV26todos_30, AV37desglosar_adicional, AV16log_fallido, AV57Pgmname, AV49ultimoRedondeo, AV47MenuOpcCod) ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV44sdt_tipo_liqs, AV7CliCod, AV15liquidar_adelanto_retencion, AV26todos_30, AV37desglosar_adicional, AV16log_fallido, AV57Pgmname, AV49ultimoRedondeo, AV47MenuOpcCod) ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV44sdt_tipo_liqs, AV7CliCod, AV15liquidar_adelanto_retencion, AV26todos_30, AV37desglosar_adicional, AV16log_fallido, AV57Pgmname, AV49ultimoRedondeo, AV47MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV57Pgmname = "Parametros" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupCM0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13CM2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV11DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMESESSAC_DATA"), AV10mesesSAC_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFORZADOS_HABITUAL_PARAM_DATA"), AV29forzados_habitual_param_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMESESSAC"), AV9mesesSAC);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFORZADOS_HABITUAL_PARAM"), AV28forzados_habitual_param);
         /* Read saved values. */
         nRC_GXsfl_83 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_83"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID1_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID1_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID1_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID1_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid1_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID1_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
         Combo_mesessac_Cls = httpContext.cgiGet( "COMBO_MESESSAC_Cls") ;
         Combo_mesessac_Selectedvalue_set = httpContext.cgiGet( "COMBO_MESESSAC_Selectedvalue_set") ;
         Combo_mesessac_Datalisttype = httpContext.cgiGet( "COMBO_MESESSAC_Datalisttype") ;
         Combo_mesessac_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MESESSAC_Allowmultipleselection")) ;
         Combo_mesessac_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MESESSAC_Datalistfixedvalues") ;
         Combo_mesessac_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MESESSAC_Includeonlyselectedoption")) ;
         Combo_mesessac_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MESESSAC_Emptyitem")) ;
         Combo_mesessac_Multiplevaluestype = httpContext.cgiGet( "COMBO_MESESSAC_Multiplevaluestype") ;
         Combo_forzados_habitual_param_Cls = httpContext.cgiGet( "COMBO_FORZADOS_HABITUAL_PARAM_Cls") ;
         Combo_forzados_habitual_param_Selectedvalue_set = httpContext.cgiGet( "COMBO_FORZADOS_HABITUAL_PARAM_Selectedvalue_set") ;
         Combo_forzados_habitual_param_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_FORZADOS_HABITUAL_PARAM_Allowmultipleselection")) ;
         Combo_forzados_habitual_param_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_FORZADOS_HABITUAL_PARAM_Includeonlyselectedoption")) ;
         Combo_forzados_habitual_param_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_FORZADOS_HABITUAL_PARAM_Emptyitem")) ;
         Combo_forzados_habitual_param_Multiplevaluestype = httpContext.cgiGet( "COMBO_FORZADOS_HABITUAL_PARAM_Multiplevaluestype") ;
         Grid1_empowerer_Gridinternalname = httpContext.cgiGet( "GRID1_EMPOWERER_Gridinternalname") ;
         Combo_mesessac_Selectedvalue_get = httpContext.cgiGet( "COMBO_MESESSAC_Selectedvalue_get") ;
         Combo_forzados_habitual_param_Selectedvalue_get = httpContext.cgiGet( "COMBO_FORZADOS_HABITUAL_PARAM_Selectedvalue_get") ;
         /* Read variables values. */
         cmbavRedondeo.setName( cmbavRedondeo.getInternalname() );
         cmbavRedondeo.setValue( httpContext.cgiGet( cmbavRedondeo.getInternalname()) );
         AV48redondeo = httpContext.cgiGet( cmbavRedondeo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48redondeo", AV48redondeo);
         AV15liquidar_adelanto_retencion = GXutil.strtobool( httpContext.cgiGet( chkavLiquidar_adelanto_retencion.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15liquidar_adelanto_retencion", AV15liquidar_adelanto_retencion);
         AV26todos_30 = GXutil.strtobool( httpContext.cgiGet( chkavTodos_30.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26todos_30", AV26todos_30);
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavProporcion_habitual_param_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavProporcion_habitual_param_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPROPORCION_HABITUAL_PARAM");
            GX_FocusControl = edtavProporcion_habitual_param_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV27proporcion_habitual_param = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27proporcion_habitual_param", GXutil.ltrimstr( AV27proporcion_habitual_param, 6, 4));
         }
         else
         {
            AV27proporcion_habitual_param = localUtil.ctond( httpContext.cgiGet( edtavProporcion_habitual_param_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27proporcion_habitual_param", GXutil.ltrimstr( AV27proporcion_habitual_param, 6, 4));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavAntiguedad_fraccion_aniomes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavAntiguedad_fraccion_aniomes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vANTIGUEDAD_FRACCION_ANIOMES");
            GX_FocusControl = edtavAntiguedad_fraccion_aniomes_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV32antiguedad_fraccion_anioMes = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32antiguedad_fraccion_anioMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32antiguedad_fraccion_anioMes), 2, 0));
         }
         else
         {
            AV32antiguedad_fraccion_anioMes = (byte)(localUtil.ctol( httpContext.cgiGet( edtavAntiguedad_fraccion_aniomes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32antiguedad_fraccion_anioMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32antiguedad_fraccion_anioMes), 2, 0));
         }
         AV33jornalConCodigo = httpContext.cgiGet( edtavJornalconcodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33jornalConCodigo", AV33jornalConCodigo);
         AV34mensualConCodigo = httpContext.cgiGet( edtavMensualconcodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34mensualConCodigo", AV34mensualConCodigo);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavHoras_default_feriado_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavHoras_default_feriado_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vHORAS_DEFAULT_FERIADO");
            GX_FocusControl = edtavHoras_default_feriado_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV35horas_default_feriado = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35horas_default_feriado", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35horas_default_feriado), 2, 0));
         }
         else
         {
            AV35horas_default_feriado = (byte)(localUtil.ctol( httpContext.cgiGet( edtavHoras_default_feriado_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35horas_default_feriado", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35horas_default_feriado), 2, 0));
         }
         AV37desglosar_adicional = GXutil.strtobool( httpContext.cgiGet( chkavDesglosar_adicional.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37desglosar_adicional", AV37desglosar_adicional);
         AV20sac_no_ConCodigo = httpContext.cgiGet( edtavSac_no_concodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20sac_no_ConCodigo", AV20sac_no_ConCodigo);
         AV16log_fallido = GXutil.strtobool( httpContext.cgiGet( chkavLog_fallido.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16log_fallido", AV16log_fallido);
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
      e13CM2 ();
      if (returnInSub) return;
   }

   public void e13CM2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV47MenuOpcCod, "", "") ;
      GXt_int1 = AV7CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      parametros_impl.this.GXt_int1 = GXv_int2[0] ;
      AV7CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV11DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV11DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      /* Execute user subroutine: 'LOADCOMBOMESESSAC' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOFORZADOS_HABITUAL_PARAM' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S132 ();
      if (returnInSub) return;
      edtavSac_no_concodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSac_no_concodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSac_no_concodigo_Visible), 5, 0), true);
      chkavLog_fallido.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavLog_fallido.getInternalname(), "Visible", GXutil.ltrimstr( chkavLog_fallido.getVisible(), 5, 0), true);
      Grid1_empowerer_Gridinternalname = subGrid1_Internalname ;
      ucGrid1_empowerer.sendProperty(context, "", false, Grid1_empowerer_Internalname, "GridInternalName", Grid1_empowerer_Gridinternalname);
      subGrid1_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
      GXt_char5 = AV14ParmValue ;
      GXt_char6 = AV14ParmValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.liquidar_adelanto_retencion(remoteHandle, context).execute( GXv_char7) ;
      parametros_impl.this.GXt_char6 = GXv_char7[0] ;
      GXv_char8[0] = GXt_char5 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char6, GXv_char8) ;
      parametros_impl.this.GXt_char5 = GXv_char8[0] ;
      AV14ParmValue = GXt_char5 ;
      AV15liquidar_adelanto_retencion = GXutil.boolval( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15liquidar_adelanto_retencion", AV15liquidar_adelanto_retencion);
      GXt_char6 = AV14ParmValue ;
      GXt_char5 = AV14ParmValue ;
      GXv_char8[0] = GXt_char5 ;
      new web.logfallidos_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      parametros_impl.this.GXt_char5 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char6 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char5, GXv_char7) ;
      parametros_impl.this.GXt_char6 = GXv_char7[0] ;
      AV14ParmValue = GXt_char6 ;
      AV16log_fallido = GXutil.boolval( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16log_fallido", AV16log_fallido);
      GXt_char6 = AV14ParmValue ;
      GXt_char5 = AV14ParmValue ;
      GXv_char8[0] = GXt_char5 ;
      new web.meses30dias_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      parametros_impl.this.GXt_char5 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char6 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char5, GXv_char7) ;
      parametros_impl.this.GXt_char6 = GXv_char7[0] ;
      AV14ParmValue = GXt_char6 ;
      AV26todos_30 = GXutil.boolval( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26todos_30", AV26todos_30);
      GXt_char6 = AV14ParmValue ;
      GXt_char5 = AV14ParmValue ;
      GXv_char8[0] = GXt_char5 ;
      new web.proporcion_habitual_param(remoteHandle, context).execute( GXv_char8) ;
      parametros_impl.this.GXt_char5 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char6 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char5, GXv_char7) ;
      parametros_impl.this.GXt_char6 = GXv_char7[0] ;
      AV14ParmValue = GXt_char6 ;
      AV27proporcion_habitual_param = CommonUtil.decimalVal( AV14ParmValue, ".") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27proporcion_habitual_param", GXutil.ltrimstr( AV27proporcion_habitual_param, 6, 4));
      GXt_char6 = AV14ParmValue ;
      GXt_char5 = AV14ParmValue ;
      GXv_char8[0] = GXt_char5 ;
      new web.antiguedad_fraccion_aniomes_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      parametros_impl.this.GXt_char5 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char6 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char5, GXv_char7) ;
      parametros_impl.this.GXt_char6 = GXv_char7[0] ;
      AV14ParmValue = GXt_char6 ;
      AV32antiguedad_fraccion_anioMes = (byte)(GXutil.lval( AV14ParmValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32antiguedad_fraccion_anioMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32antiguedad_fraccion_anioMes), 2, 0));
      GXt_char6 = AV33jornalConCodigo ;
      GXt_char5 = AV33jornalConCodigo ;
      GXv_char8[0] = GXt_char5 ;
      new web.concepto_sueldojornal_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      parametros_impl.this.GXt_char5 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char6 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char5, GXv_char7) ;
      parametros_impl.this.GXt_char6 = GXv_char7[0] ;
      AV33jornalConCodigo = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33jornalConCodigo", AV33jornalConCodigo);
      GXt_char6 = AV34mensualConCodigo ;
      GXt_char5 = AV34mensualConCodigo ;
      GXv_char8[0] = GXt_char5 ;
      new web.concepto_sueldomensual_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      parametros_impl.this.GXt_char5 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char6 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char5, GXv_char7) ;
      parametros_impl.this.GXt_char6 = GXv_char7[0] ;
      AV34mensualConCodigo = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34mensualConCodigo", AV34mensualConCodigo);
      GXt_char6 = AV14ParmValue ;
      GXt_char5 = AV14ParmValue ;
      GXv_char8[0] = GXt_char5 ;
      new web.horas_default_feriado_param(remoteHandle, context).execute( GXv_char8) ;
      parametros_impl.this.GXt_char5 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char6 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char5, GXv_char7) ;
      parametros_impl.this.GXt_char6 = GXv_char7[0] ;
      AV14ParmValue = GXt_char6 ;
      AV35horas_default_feriado = (byte)(GXutil.lval( AV14ParmValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35horas_default_feriado", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35horas_default_feriado), 2, 0));
      GXt_char6 = AV14ParmValue ;
      GXt_char5 = AV14ParmValue ;
      GXv_char8[0] = GXt_char5 ;
      new web.desglosaradicional_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      parametros_impl.this.GXt_char5 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char6 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char5, GXv_char7) ;
      parametros_impl.this.GXt_char6 = GXv_char7[0] ;
      AV14ParmValue = GXt_char6 ;
      AV37desglosar_adicional = GXutil.boolval( AV14ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37desglosar_adicional", AV37desglosar_adicional);
      new web.gettipoliqshabilitadas(remoteHandle, context).execute( AV7CliCod, true, AV44sdt_tipo_liqs) ;
      chkavTliqhabilitada.setEnabled( 1 );
      httpContext.ajax_rsp_assign_prop("", false, chkavTliqhabilitada.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTliqhabilitada.getEnabled(), 5, 0), !bGXsfl_83_Refreshing);
      GXv_char8[0] = AV48redondeo ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.redondeo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char8) ;
      parametros_impl.this.AV48redondeo = GXv_char8[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48redondeo", AV48redondeo);
      AV49ultimoRedondeo = AV48redondeo ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49ultimoRedondeo", AV49ultimoRedondeo);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vULTIMOREDONDEO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV49ultimoRedondeo, ""))));
   }

   private void e14CM2( )
   {
      /* Grid1_Load Routine */
      returnInSub = false ;
      AV38TLiqHabilitada = false ;
      httpContext.ajax_rsp_assign_attri("", false, chkavTliqhabilitada.getInternalname(), AV38TLiqHabilitada);
      AV55GXV1 = 1 ;
      while ( AV55GXV1 <= AV44sdt_tipo_liqs.size() )
      {
         AV45item = (web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem)((web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem)AV44sdt_tipo_liqs.elementAt(-1+AV55GXV1));
         if ( GXutil.strcmp(AV45item.getgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod(), A32TLiqCod) == 0 )
         {
            AV38TLiqHabilitada = true ;
            httpContext.ajax_rsp_assign_attri("", false, chkavTliqhabilitada.getInternalname(), AV38TLiqHabilitada);
            if (true) break;
         }
         AV55GXV1 = (int)(AV55GXV1+1) ;
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(83) ;
      }
      sendrow_832( ) ;
      GRID1_nCurrentRecord = (long)(GRID1_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_83_Refreshing )
      {
         httpContext.doAjaxLoad(83, Grid1Row);
      }
      /*  Sending Event outputs  */
   }

   public void e11CM2( )
   {
      /* 'DoConfirmar' Routine */
      returnInSub = false ;
      new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.redondeo_codigoparam(remoteHandle, context).executeUdp( ), AV48redondeo, "") ;
      new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.liquidar_adelanto_retencion(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.booltostr( AV15liquidar_adelanto_retencion)), "") ;
      new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.meses_liquidar_sac_param(remoteHandle, context).executeUdp( ), Combo_mesessac_Selectedvalue_get, "") ;
      new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.logfallidos_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.booltostr( AV16log_fallido)), "") ;
      new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.meses30dias_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.booltostr( AV26todos_30)), "") ;
      new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.proporcion_habitual_param(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.str( AV27proporcion_habitual_param, 6, 4)), "") ;
      new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.forzados_habitual_param(remoteHandle, context).executeUdp( ), Combo_forzados_habitual_param_Selectedvalue_get, "") ;
      new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.antiguedad_fraccion_aniomes_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.str( AV32antiguedad_fraccion_anioMes, 2, 0)), "") ;
      new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.concepto_sueldomensual_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV34mensualConCodigo), "") ;
      new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.concepto_sueldojornal_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( AV33jornalConCodigo), "") ;
      new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.horas_default_feriado_param(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.str( AV35horas_default_feriado, 2, 0)), "") ;
      new web.grabaparametro(remoteHandle, context).execute( AV7CliCod, new web.desglosaradicional_codigoparam(remoteHandle, context).executeUdp( ), GXutil.trim( GXutil.booltostr( AV37desglosar_adicional)), "") ;
      AV44sdt_tipo_liqs.clear();
      /* Start For Each Line */
      nRC_GXsfl_83 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_83"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      nGXsfl_83_fel_idx = 0 ;
      while ( nGXsfl_83_fel_idx < nRC_GXsfl_83 )
      {
         nGXsfl_83_fel_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_83_fel_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_83_fel_idx+1) ;
         sGXsfl_83_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_83_fel_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_fel_832( ) ;
         A32TLiqCod = httpContext.cgiGet( edtTLiqCod_Internalname) ;
         A340TliqDesc = GXutil.upper( httpContext.cgiGet( edtTliqDesc_Internalname)) ;
         AV38TLiqHabilitada = GXutil.strtobool( httpContext.cgiGet( chkavTliqhabilitada.getInternalname())) ;
         if ( AV38TLiqHabilitada )
         {
            AV45item = (web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem)new web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem(remoteHandle, context);
            AV45item.setgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod( A32TLiqCod );
            AV45item.setgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc( A340TliqDesc );
            AV44sdt_tipo_liqs.add(AV45item, 0);
         }
         /* End For Each Line */
      }
      if ( nGXsfl_83_fel_idx == 0 )
      {
         nGXsfl_83_idx = 1 ;
         sGXsfl_83_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_83_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_832( ) ;
      }
      nGXsfl_83_fel_idx = 1 ;
      new web.actualizartipoliqshabilitada(remoteHandle, context).execute( AV7CliCod, AV44sdt_tipo_liqs) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV57Pgmname, httpContext.getMessage( "redondeo ", "")+AV48redondeo+httpContext.getMessage( " &ultimoRedondeo ", "")+AV49ultimoRedondeo) ;
      if ( GXutil.strcmp(AV48redondeo, AV49ultimoRedondeo) != 0 )
      {
         AV52hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
         AV51desdeFecha = localUtil.ymdtod( GXutil.year( AV52hoy), GXutil.month( AV52hoy), 1) ;
         AV51desdeFecha = GXutil.addmth( AV51desdeFecha, (short)(-2)) ;
         callSubmit( 1 , new Object[]{ Integer.valueOf(AV7CliCod),AV51desdeFecha,AV50vaciaFecha });
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV44sdt_tipo_liqs", AV44sdt_tipo_liqs);
   }

   public void e12CM2( )
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

   public void S132( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      tblTbltipoliqs_Visible = ((false) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, tblTbltipoliqs_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTbltipoliqs_Visible), 5, 0), true);
   }

   public void S122( )
   {
      /* 'LOADCOMBOFORZADOS_HABITUAL_PARAM' Routine */
      returnInSub = false ;
      GXt_char6 = AV31JSON ;
      GXt_char5 = AV31JSON ;
      GXv_char8[0] = GXt_char5 ;
      new web.forzados_habitual_param(remoteHandle, context).execute( GXv_char8) ;
      parametros_impl.this.GXt_char5 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char6 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char5, GXv_char7) ;
      parametros_impl.this.GXt_char6 = GXv_char7[0] ;
      AV31JSON = GXt_char6 ;
      AV28forzados_habitual_param.fromJSonString(AV31JSON, null);
      /* Using cursor H00CM4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A3CliCod = H00CM4_A3CliCod[0] ;
         A26ConCodigo = H00CM4_A26ConCodigo[0] ;
         A41ConDescrip = H00CM4_A41ConDescrip[0] ;
         AV12Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV12Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A41ConDescrip );
         AV29forzados_habitual_param_Data.add(AV12Combo_DataItem, 0);
         pr_default.readNext(2);
      }
      pr_default.close(2);
      Combo_forzados_habitual_param_Selectedvalue_set = AV28forzados_habitual_param.toJSonString(false) ;
      ucCombo_forzados_habitual_param.sendProperty(context, "", false, Combo_forzados_habitual_param_Internalname, "SelectedValue_set", Combo_forzados_habitual_param_Selectedvalue_set);
   }

   public void S112( )
   {
      /* 'LOADCOMBOMESESSAC' Routine */
      returnInSub = false ;
      GXt_char6 = AV14ParmValue ;
      GXt_char5 = AV14ParmValue ;
      GXv_char8[0] = GXt_char5 ;
      new web.meses_liquidar_sac_param(remoteHandle, context).execute( GXv_char8) ;
      parametros_impl.this.GXt_char5 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char6 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char5, GXv_char7) ;
      parametros_impl.this.GXt_char6 = GXv_char7[0] ;
      AV14ParmValue = GXt_char6 ;
      AV9mesesSAC.fromJSonString(AV14ParmValue, null);
      Combo_mesessac_Selectedvalue_set = AV9mesesSAC.toJSonString(false) ;
      ucCombo_mesessac.sendProperty(context, "", false, Combo_mesessac_Internalname, "SelectedValue_set", Combo_mesessac_Selectedvalue_set);
   }

   public void e15CM2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV7CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      parametros_impl.this.GXt_int1 = GXv_int2[0] ;
      AV7CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      /*  Sending Event outputs  */
   }

   public void e16CM2( )
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

   public void S142( )
   {
      /* 'LOADCOMBOSAC_NO_CONCODIGO' Routine */
      returnInSub = false ;
   }

   public void wb_table1_9_CM2( boolean wbgen )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmesessac_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_mesessac_Internalname, httpContext.getMessage( "Meses de liquidación de SAC'", ""), "", "", lblTextblockcombo_mesessac_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Parametros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_mesessac.setProperty("Caption", Combo_mesessac_Caption);
         ucCombo_mesessac.setProperty("Cls", Combo_mesessac_Cls);
         ucCombo_mesessac.setProperty("DataListType", Combo_mesessac_Datalisttype);
         ucCombo_mesessac.setProperty("AllowMultipleSelection", Combo_mesessac_Allowmultipleselection);
         ucCombo_mesessac.setProperty("DataListFixedValues", Combo_mesessac_Datalistfixedvalues);
         ucCombo_mesessac.setProperty("IncludeOnlySelectedOption", Combo_mesessac_Includeonlyselectedoption);
         ucCombo_mesessac.setProperty("EmptyItem", Combo_mesessac_Emptyitem);
         ucCombo_mesessac.setProperty("MultipleValuesType", Combo_mesessac_Multiplevaluestype);
         ucCombo_mesessac.setProperty("DropDownOptionsTitleSettingsIcons", AV11DDO_TitleSettingsIcons);
         ucCombo_mesessac.setProperty("DropDownOptionsData", AV10mesesSAC_Data);
         ucCombo_mesessac.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_mesessac_Internalname, "COMBO_MESESSACContainer");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavRedondeo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavRedondeo.getInternalname(), httpContext.getMessage( "Liquidar redondeo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'" + sGXsfl_83_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavRedondeo, cmbavRedondeo.getInternalname(), GXutil.rtrim( AV48redondeo), 1, cmbavRedondeo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavRedondeo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "", true, (byte)(0), "HLP_Parametros.htm");
         cmbavRedondeo.setValue( GXutil.rtrim( AV48redondeo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavRedondeo.getInternalname(), "Values", cmbavRedondeo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavLiquidar_adelanto_retencion.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavLiquidar_adelanto_retencion.getInternalname(), httpContext.getMessage( "Liquidar adelanto de retención de ganancias para primera quincena o adelanto de vacaciones", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'" + sGXsfl_83_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavLiquidar_adelanto_retencion.getInternalname(), GXutil.booltostr( AV15liquidar_adelanto_retencion), "", httpContext.getMessage( "Liquidar adelanto de retención de ganancias para primera quincena o adelanto de vacaciones", ""), 1, chkavLiquidar_adelanto_retencion.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(30, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,30);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavTodos_30.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavTodos_30.getInternalname(), httpContext.getMessage( "Todos los meses de 30 dias", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'" + sGXsfl_83_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTodos_30.getInternalname(), GXutil.booltostr( AV26todos_30), "", httpContext.getMessage( "Todos los meses de 30 dias", ""), 1, chkavTodos_30.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(35, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,35);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProporcion_habitual_param_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavProporcion_habitual_param_Internalname, httpContext.getMessage( "Proporción de incurrencia en liquidación de un concepto para considerarlo habitual", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'" + sGXsfl_83_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavProporcion_habitual_param_Internalname, GXutil.ltrim( localUtil.ntoc( AV27proporcion_habitual_param, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavProporcion_habitual_param_Enabled!=0) ? localUtil.format( AV27proporcion_habitual_param, "9.9999") : localUtil.format( AV27proporcion_habitual_param, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,40);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProporcion_habitual_param_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavProporcion_habitual_param_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Parametros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedforzados_habitual_param_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_forzados_habitual_param_Internalname, httpContext.getMessage( "Conceptos a forzar como habituales", ""), "", "", lblTextblockcombo_forzados_habitual_param_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Parametros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_forzados_habitual_param.setProperty("Caption", Combo_forzados_habitual_param_Caption);
         ucCombo_forzados_habitual_param.setProperty("Cls", Combo_forzados_habitual_param_Cls);
         ucCombo_forzados_habitual_param.setProperty("AllowMultipleSelection", Combo_forzados_habitual_param_Allowmultipleselection);
         ucCombo_forzados_habitual_param.setProperty("IncludeOnlySelectedOption", Combo_forzados_habitual_param_Includeonlyselectedoption);
         ucCombo_forzados_habitual_param.setProperty("EmptyItem", Combo_forzados_habitual_param_Emptyitem);
         ucCombo_forzados_habitual_param.setProperty("MultipleValuesType", Combo_forzados_habitual_param_Multiplevaluestype);
         ucCombo_forzados_habitual_param.setProperty("DropDownOptionsTitleSettingsIcons", AV11DDO_TitleSettingsIcons);
         ucCombo_forzados_habitual_param.setProperty("DropDownOptionsData", AV29forzados_habitual_param_Data);
         ucCombo_forzados_habitual_param.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_forzados_habitual_param_Internalname, "COMBO_FORZADOS_HABITUAL_PARAMContainer");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAntiguedad_fraccion_aniomes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavAntiguedad_fraccion_aniomes_Internalname, httpContext.getMessage( "Para indemnizaciones considerar como 1 año de antiguedad fracción mayor a cantidad de meses:", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'" + sGXsfl_83_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavAntiguedad_fraccion_aniomes_Internalname, GXutil.ltrim( localUtil.ntoc( AV32antiguedad_fraccion_anioMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavAntiguedad_fraccion_aniomes_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV32antiguedad_fraccion_anioMes), "Z9") : localUtil.format( DecimalUtil.doubleToDec(AV32antiguedad_fraccion_anioMes), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAntiguedad_fraccion_aniomes_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavAntiguedad_fraccion_aniomes_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Parametros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavJornalconcodigo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavJornalconcodigo_Internalname, httpContext.getMessage( "Concepto de horas básicas Jornal", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'" + sGXsfl_83_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavJornalconcodigo_Internalname, GXutil.rtrim( AV33jornalConCodigo), GXutil.rtrim( localUtil.format( AV33jornalConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavJornalconcodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavJornalconcodigo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Parametros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavMensualconcodigo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavMensualconcodigo_Internalname, httpContext.getMessage( "Concepto de horas básicas Mensual", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'" + sGXsfl_83_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavMensualconcodigo_Internalname, GXutil.rtrim( AV34mensualConCodigo), GXutil.rtrim( localUtil.format( AV34mensualConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavMensualconcodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavMensualconcodigo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Parametros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavHoras_default_feriado_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavHoras_default_feriado_Internalname, httpContext.getMessage( "Cantidad de horas para día feriado, y horas extras (Si se establece en 0 se calcula de la siguiente manera: Si las horas trabajadas (en caso de especificarlas por día) son mayor o igual a las máximas permitidas por país (por ejemplo 9), se calculan 9 horas, y si son menores, se calculan las horas normales por país (por ejemplo 8). Si se establece valor mayor a 0 en este parámetro, se usará siempre ese valor.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'" + sGXsfl_83_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavHoras_default_feriado_Internalname, GXutil.ltrim( localUtil.ntoc( AV35horas_default_feriado, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavHoras_default_feriado_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV35horas_default_feriado), "Z9") : localUtil.format( DecimalUtil.doubleToDec(AV35horas_default_feriado), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavHoras_default_feriado_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavHoras_default_feriado_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Parametros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavDesglosar_adicional.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavDesglosar_adicional.getInternalname(), httpContext.getMessage( "Liquidar adicional de categoría en un concepto aparte del sueldo básico", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'" + sGXsfl_83_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavDesglosar_adicional.getInternalname(), GXutil.booltostr( AV37desglosar_adicional), "", httpContext.getMessage( "Liquidar adicional de categoría en un concepto aparte del sueldo básico", ""), 1, chkavDesglosar_adicional.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(73, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,73);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table2_76_CM2( true) ;
      }
      else
      {
         wb_table2_76_CM2( false) ;
      }
      return  ;
   }

   public void wb_table2_76_CM2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnconfirmar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 83, 2, 0)+","+"null"+");", httpContext.getMessage( "Confirmar", ""), bttBtnconfirmar_Jsonclick, 5, httpContext.getMessage( "Confirmar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCONFIRMAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Parametros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 96,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancelar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 83, 2, 0)+","+"null"+");", httpContext.getMessage( "Cancelar", ""), bttBtncancelar_Jsonclick, 5, httpContext.getMessage( "Cancelar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCANCELAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Parametros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_CM2e( true) ;
      }
      else
      {
         wb_table1_9_CM2e( false) ;
      }
   }

   public void wb_table2_76_CM2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTbltipoliqs_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTbltipoliqs_Internalname, tblTbltipoliqs_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup2_Internalname, httpContext.getMessage( "Tipos de liquidación habilitadas", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_Parametros.htm");
         wb_table3_80_CM2( true) ;
      }
      else
      {
         wb_table3_80_CM2( false) ;
      }
      return  ;
   }

   public void wb_table3_80_CM2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_76_CM2e( true) ;
      }
      else
      {
         wb_table2_76_CM2e( false) ;
      }
   }

   public void wb_table3_80_CM2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='HasGridEmpowerer'>") ;
         /*  Grid Control  */
         Grid1Container.SetWrapped(nGXWrapped);
         startgridcontrol83( ) ;
      }
      if ( wbEnd == 83 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_83 = (int)(nGXsfl_83_idx-1) ;
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
         wb_table3_80_CM2e( true) ;
      }
      else
      {
         wb_table3_80_CM2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV47MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47MenuOpcCod", AV47MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV47MenuOpcCod, ""))));
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
      paCM2( ) ;
      wsCM2( ) ;
      weCM2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181774751", true, true);
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
         httpContext.AddJavascriptSource("parametros.js", "?2025181774751", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_832( )
   {
      edtTLiqCod_Internalname = "TLIQCOD_"+sGXsfl_83_idx ;
      edtTliqDesc_Internalname = "TLIQDESC_"+sGXsfl_83_idx ;
      chkavTliqhabilitada.setInternalname( "vTLIQHABILITADA_"+sGXsfl_83_idx );
   }

   public void subsflControlProps_fel_832( )
   {
      edtTLiqCod_Internalname = "TLIQCOD_"+sGXsfl_83_fel_idx ;
      edtTliqDesc_Internalname = "TLIQDESC_"+sGXsfl_83_fel_idx ;
      chkavTliqhabilitada.setInternalname( "vTLIQHABILITADA_"+sGXsfl_83_fel_idx );
   }

   public void sendrow_832( )
   {
      subsflControlProps_832( ) ;
      wbCM0( ) ;
      if ( ( subGrid1_Rows * 1 == 0 ) || ( nGXsfl_83_idx <= subgrid1_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_83_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_83_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTLiqCod_Internalname,GXutil.rtrim( A32TLiqCod),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTLiqCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(83),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodigoCaracter","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTliqDesc_Internalname,A340TliqDesc,GXutil.rtrim( localUtil.format( A340TliqDesc, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTliqDesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(83),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionMedia","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Check box */
         TempTags = " " + ((chkavTliqhabilitada.getEnabled()!=0)&&(chkavTliqhabilitada.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 86,'',false,'"+sGXsfl_83_idx+"',83)\"" : " ") ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vTLIQHABILITADA_" + sGXsfl_83_idx ;
         chkavTliqhabilitada.setName( GXCCtl );
         chkavTliqhabilitada.setWebtags( "" );
         chkavTliqhabilitada.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavTliqhabilitada.getInternalname(), "TitleCaption", chkavTliqhabilitada.getCaption(), !bGXsfl_83_Refreshing);
         chkavTliqhabilitada.setCheckedValue( "false" );
         AV38TLiqHabilitada = GXutil.strtobool( GXutil.booltostr( AV38TLiqHabilitada)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavTliqhabilitada.getInternalname(), AV38TLiqHabilitada);
         Grid1Row.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavTliqhabilitada.getInternalname(),GXutil.booltostr( AV38TLiqHabilitada),"","",Integer.valueOf(-1),Integer.valueOf(chkavTliqhabilitada.getEnabled()),"true","",StyleString,ClassString,"WWColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(86, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+((chkavTliqhabilitada.getEnabled()!=0)&&(chkavTliqhabilitada.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,86);\"" : " ")});
         send_integrity_lvl_hashesCM2( ) ;
         Grid1Container.AddRow(Grid1Row);
         nGXsfl_83_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_83_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_83_idx+1) ;
         sGXsfl_83_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_83_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_832( ) ;
      }
      /* End function sendrow_832 */
   }

   public void startgridcontrol83( )
   {
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Grid1Container"+"DivS\" data-gxgridid=\"83\">") ;
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
         Grid1Column.AddObjectProperty("Value", GXutil.booltostr( AV38TLiqHabilitada));
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
      lblTextblockcombo_mesessac_Internalname = "TEXTBLOCKCOMBO_MESESSAC" ;
      Combo_mesessac_Internalname = "COMBO_MESESSAC" ;
      divTablesplittedmesessac_Internalname = "TABLESPLITTEDMESESSAC" ;
      cmbavRedondeo.setInternalname( "vREDONDEO" );
      chkavLiquidar_adelanto_retencion.setInternalname( "vLIQUIDAR_ADELANTO_RETENCION" );
      chkavTodos_30.setInternalname( "vTODOS_30" );
      edtavProporcion_habitual_param_Internalname = "vPROPORCION_HABITUAL_PARAM" ;
      lblTextblockcombo_forzados_habitual_param_Internalname = "TEXTBLOCKCOMBO_FORZADOS_HABITUAL_PARAM" ;
      Combo_forzados_habitual_param_Internalname = "COMBO_FORZADOS_HABITUAL_PARAM" ;
      divTablesplittedforzados_habitual_param_Internalname = "TABLESPLITTEDFORZADOS_HABITUAL_PARAM" ;
      edtavAntiguedad_fraccion_aniomes_Internalname = "vANTIGUEDAD_FRACCION_ANIOMES" ;
      edtavJornalconcodigo_Internalname = "vJORNALCONCODIGO" ;
      edtavMensualconcodigo_Internalname = "vMENSUALCONCODIGO" ;
      edtavHoras_default_feriado_Internalname = "vHORAS_DEFAULT_FERIADO" ;
      chkavDesglosar_adicional.setInternalname( "vDESGLOSAR_ADICIONAL" );
      edtTLiqCod_Internalname = "TLIQCOD" ;
      edtTliqDesc_Internalname = "TLIQDESC" ;
      chkavTliqhabilitada.setInternalname( "vTLIQHABILITADA" );
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      grpUnnamedgroup2_Internalname = "UNNAMEDGROUP2" ;
      tblTbltipoliqs_Internalname = "TBLTIPOLIQS" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnconfirmar_Internalname = "BTNCONFIRMAR" ;
      bttBtncancelar_Internalname = "BTNCANCELAR" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavSac_no_concodigo_Internalname = "vSAC_NO_CONCODIGO" ;
      chkavLog_fallido.setInternalname( "vLOG_FALLIDO" );
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
      chkavDesglosar_adicional.setEnabled( 1 );
      edtavHoras_default_feriado_Jsonclick = "" ;
      edtavHoras_default_feriado_Enabled = 1 ;
      edtavMensualconcodigo_Jsonclick = "" ;
      edtavMensualconcodigo_Enabled = 1 ;
      edtavJornalconcodigo_Jsonclick = "" ;
      edtavJornalconcodigo_Enabled = 1 ;
      edtavAntiguedad_fraccion_aniomes_Jsonclick = "" ;
      edtavAntiguedad_fraccion_aniomes_Enabled = 1 ;
      Combo_forzados_habitual_param_Caption = "" ;
      edtavProporcion_habitual_param_Jsonclick = "" ;
      edtavProporcion_habitual_param_Enabled = 1 ;
      chkavTodos_30.setEnabled( 1 );
      chkavLiquidar_adelanto_retencion.setEnabled( 1 );
      cmbavRedondeo.setJsonclick( "" );
      cmbavRedondeo.setEnabled( 1 );
      Combo_mesessac_Caption = "" ;
      tblTbltipoliqs_Visible = 1 ;
      chkavLog_fallido.setVisible( 1 );
      edtavSac_no_concodigo_Jsonclick = "" ;
      edtavSac_no_concodigo_Visible = 1 ;
      Combo_forzados_habitual_param_Multiplevaluestype = "Tags" ;
      Combo_forzados_habitual_param_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_forzados_habitual_param_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_forzados_habitual_param_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_forzados_habitual_param_Cls = "ExtendedCombo Attribute" ;
      Combo_mesessac_Multiplevaluestype = "Tags" ;
      Combo_mesessac_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_mesessac_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_mesessac_Datalistfixedvalues = "Enero:1,Febrero:2,Abril:4,Marzo:3,Mayo:5,Junio:6,Julio:7,Agosto:8,Septiembre:9,Octubre:10,Noviembre:11,Diciembre:12" ;
      Combo_mesessac_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_mesessac_Datalisttype = "FixedValues" ;
      Combo_mesessac_Cls = "ExtendedCombo Attribute" ;
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
      cmbavRedondeo.setName( "vREDONDEO" );
      cmbavRedondeo.setWebtags( "" );
      cmbavRedondeo.addItem("NO_TRANSFERENCIAS", httpContext.getMessage( "Solo para modo de pago distintos a \"Transferencias\"", ""), (short)(0));
      cmbavRedondeo.addItem("SIEMPRE", httpContext.getMessage( "Siempre", ""), (short)(0));
      if ( cmbavRedondeo.getItemCount() > 0 )
      {
         AV48redondeo = cmbavRedondeo.getValidValue(AV48redondeo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48redondeo", AV48redondeo);
      }
      chkavLiquidar_adelanto_retencion.setName( "vLIQUIDAR_ADELANTO_RETENCION" );
      chkavLiquidar_adelanto_retencion.setWebtags( "" );
      chkavLiquidar_adelanto_retencion.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavLiquidar_adelanto_retencion.getInternalname(), "TitleCaption", chkavLiquidar_adelanto_retencion.getCaption(), true);
      chkavLiquidar_adelanto_retencion.setCheckedValue( "false" );
      AV15liquidar_adelanto_retencion = GXutil.strtobool( GXutil.booltostr( AV15liquidar_adelanto_retencion)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15liquidar_adelanto_retencion", AV15liquidar_adelanto_retencion);
      chkavTodos_30.setName( "vTODOS_30" );
      chkavTodos_30.setWebtags( "" );
      chkavTodos_30.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavTodos_30.getInternalname(), "TitleCaption", chkavTodos_30.getCaption(), true);
      chkavTodos_30.setCheckedValue( "false" );
      AV26todos_30 = GXutil.strtobool( GXutil.booltostr( AV26todos_30)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26todos_30", AV26todos_30);
      chkavDesglosar_adicional.setName( "vDESGLOSAR_ADICIONAL" );
      chkavDesglosar_adicional.setWebtags( "" );
      chkavDesglosar_adicional.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavDesglosar_adicional.getInternalname(), "TitleCaption", chkavDesglosar_adicional.getCaption(), true);
      chkavDesglosar_adicional.setCheckedValue( "false" );
      AV37desglosar_adicional = GXutil.strtobool( GXutil.booltostr( AV37desglosar_adicional)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37desglosar_adicional", AV37desglosar_adicional);
      GXCCtl = "vTLIQHABILITADA_" + sGXsfl_83_idx ;
      chkavTliqhabilitada.setName( GXCCtl );
      chkavTliqhabilitada.setWebtags( "" );
      chkavTliqhabilitada.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavTliqhabilitada.getInternalname(), "TitleCaption", chkavTliqhabilitada.getCaption(), !bGXsfl_83_Refreshing);
      chkavTliqhabilitada.setCheckedValue( "false" );
      AV38TLiqHabilitada = GXutil.strtobool( GXutil.booltostr( AV38TLiqHabilitada)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavTliqhabilitada.getInternalname(), AV38TLiqHabilitada);
      chkavLog_fallido.setName( "vLOG_FALLIDO" );
      chkavLog_fallido.setWebtags( "" );
      chkavLog_fallido.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavLog_fallido.getInternalname(), "TitleCaption", chkavLog_fallido.getCaption(), true);
      chkavLog_fallido.setCheckedValue( "false" );
      AV16log_fallido = GXutil.strtobool( GXutil.booltostr( AV16log_fallido)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16log_fallido", AV16log_fallido);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'chkavTliqhabilitada.getEnabled()',ctrl:'vTLIQHABILITADA',prop:'Enabled'},{av:'AV44sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV15liquidar_adelanto_retencion',fld:'vLIQUIDAR_ADELANTO_RETENCION',pic:''},{av:'AV26todos_30',fld:'vTODOS_30',pic:''},{av:'AV37desglosar_adicional',fld:'vDESGLOSAR_ADICIONAL',pic:''},{av:'AV16log_fallido',fld:'vLOG_FALLIDO',pic:''},{av:'AV57Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV49ultimoRedondeo',fld:'vULTIMOREDONDEO',pic:'',hsh:true},{av:'AV47MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRID1.LOAD","{handler:'e14CM2',iparms:[{av:'AV44sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'A32TLiqCod',fld:'TLIQCOD',pic:'',hsh:true}]");
      setEventMetadata("GRID1.LOAD",",oparms:[{av:'AV38TLiqHabilitada',fld:'vTLIQHABILITADA',pic:''}]}");
      setEventMetadata("'DOCONFIRMAR'","{handler:'e11CM2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'cmbavRedondeo'},{av:'AV48redondeo',fld:'vREDONDEO',pic:''},{av:'AV15liquidar_adelanto_retencion',fld:'vLIQUIDAR_ADELANTO_RETENCION',pic:''},{av:'Combo_mesessac_Selectedvalue_get',ctrl:'COMBO_MESESSAC',prop:'SelectedValue_get'},{av:'AV16log_fallido',fld:'vLOG_FALLIDO',pic:''},{av:'AV26todos_30',fld:'vTODOS_30',pic:''},{av:'AV27proporcion_habitual_param',fld:'vPROPORCION_HABITUAL_PARAM',pic:'9.9999'},{av:'Combo_forzados_habitual_param_Selectedvalue_get',ctrl:'COMBO_FORZADOS_HABITUAL_PARAM',prop:'SelectedValue_get'},{av:'AV32antiguedad_fraccion_anioMes',fld:'vANTIGUEDAD_FRACCION_ANIOMES',pic:'Z9'},{av:'AV34mensualConCodigo',fld:'vMENSUALCONCODIGO',pic:''},{av:'AV33jornalConCodigo',fld:'vJORNALCONCODIGO',pic:''},{av:'AV35horas_default_feriado',fld:'vHORAS_DEFAULT_FERIADO',pic:'Z9'},{av:'AV37desglosar_adicional',fld:'vDESGLOSAR_ADICIONAL',pic:''},{av:'AV38TLiqHabilitada',fld:'vTLIQHABILITADA',grid:83,pic:''},{av:'GRID1_nFirstRecordOnPage'},{av:'nRC_GXsfl_83',ctrl:'GRID1',grid:83,prop:'GridRC',grid:83},{av:'A32TLiqCod',fld:'TLIQCOD',grid:83,pic:'',hsh:true},{av:'A340TliqDesc',fld:'TLIQDESC',grid:83,pic:'@!',hsh:true},{av:'AV57Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV49ultimoRedondeo',fld:'vULTIMOREDONDEO',pic:'',hsh:true},{av:'AV50vaciaFecha',fld:'vVACIAFECHA',pic:''}]");
      setEventMetadata("'DOCONFIRMAR'",",oparms:[{av:'AV44sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'AV50vaciaFecha',fld:'vVACIAFECHA',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("'DOCANCELAR'","{handler:'e12CM2',iparms:[]");
      setEventMetadata("'DOCANCELAR'",",oparms:[]}");
      setEventMetadata("'DOVOLVER'","{handler:'e16CM2',iparms:[]");
      setEventMetadata("'DOVOLVER'",",oparms:[]}");
      setEventMetadata("GRID1_FIRSTPAGE","{handler:'subgrid1_firstpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'chkavTliqhabilitada.getEnabled()',ctrl:'vTLIQHABILITADA',prop:'Enabled'},{av:'AV44sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV57Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV49ultimoRedondeo',fld:'vULTIMOREDONDEO',pic:'',hsh:true},{av:'AV47MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV15liquidar_adelanto_retencion',fld:'vLIQUIDAR_ADELANTO_RETENCION',pic:''},{av:'AV26todos_30',fld:'vTODOS_30',pic:''},{av:'AV37desglosar_adicional',fld:'vDESGLOSAR_ADICIONAL',pic:''},{av:'AV16log_fallido',fld:'vLOG_FALLIDO',pic:''}]");
      setEventMetadata("GRID1_FIRSTPAGE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRID1_PREVPAGE","{handler:'subgrid1_previouspage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'chkavTliqhabilitada.getEnabled()',ctrl:'vTLIQHABILITADA',prop:'Enabled'},{av:'AV44sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV57Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV49ultimoRedondeo',fld:'vULTIMOREDONDEO',pic:'',hsh:true},{av:'AV47MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV15liquidar_adelanto_retencion',fld:'vLIQUIDAR_ADELANTO_RETENCION',pic:''},{av:'AV26todos_30',fld:'vTODOS_30',pic:''},{av:'AV37desglosar_adicional',fld:'vDESGLOSAR_ADICIONAL',pic:''},{av:'AV16log_fallido',fld:'vLOG_FALLIDO',pic:''}]");
      setEventMetadata("GRID1_PREVPAGE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRID1_NEXTPAGE","{handler:'subgrid1_nextpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'chkavTliqhabilitada.getEnabled()',ctrl:'vTLIQHABILITADA',prop:'Enabled'},{av:'AV44sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV57Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV49ultimoRedondeo',fld:'vULTIMOREDONDEO',pic:'',hsh:true},{av:'AV47MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV15liquidar_adelanto_retencion',fld:'vLIQUIDAR_ADELANTO_RETENCION',pic:''},{av:'AV26todos_30',fld:'vTODOS_30',pic:''},{av:'AV37desglosar_adicional',fld:'vDESGLOSAR_ADICIONAL',pic:''},{av:'AV16log_fallido',fld:'vLOG_FALLIDO',pic:''}]");
      setEventMetadata("GRID1_NEXTPAGE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRID1_LASTPAGE","{handler:'subgrid1_lastpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'chkavTliqhabilitada.getEnabled()',ctrl:'vTLIQHABILITADA',prop:'Enabled'},{av:'AV44sdt_tipo_liqs',fld:'vSDT_TIPO_LIQS',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV57Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV49ultimoRedondeo',fld:'vULTIMOREDONDEO',pic:'',hsh:true},{av:'AV47MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV15liquidar_adelanto_retencion',fld:'vLIQUIDAR_ADELANTO_RETENCION',pic:''},{av:'AV26todos_30',fld:'vTODOS_30',pic:''},{av:'AV37desglosar_adicional',fld:'vDESGLOSAR_ADICIONAL',pic:''},{av:'AV16log_fallido',fld:'vLOG_FALLIDO',pic:''}]");
      setEventMetadata("GRID1_LASTPAGE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
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
   public void submit( int submitId ,
                       Object [] submitParms ,
                       ModelContext submitContext )
   {
      UserInformation submitUI = (UserInformation) GXObjectHelper.getUserInformation(context, -1);
      int remoteHandle = submitUI.getHandle();
      try
      {
         switch ( submitId )
         {
               case 1 :
                  new web.inicializarsueldoconceptos(remoteHandle, submitContext).execute( ((Number) submitParms[0]).intValue(), (java.util.Date)submitParms[1], (java.util.Date)submitParms[2]) ;
                  try { Application.getConnectionManager().disconnect(remoteHandle); } catch(Exception submitExc) { ; }
                  break;
         }
      }
      catch ( Exception e )
      {
         Application.cleanupConnection(remoteHandle);
         e.printStackTrace();
      }
   }

   public void initialize( )
   {
      wcpOAV47MenuOpcCod = "" ;
      Combo_mesessac_Selectedvalue_get = "" ;
      Combo_forzados_habitual_param_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV47MenuOpcCod = "" ;
      AV44sdt_tipo_liqs = new GXBaseCollection<web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem>(web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem.class, "sdt_tipo_liqsItem", "PayDay", remoteHandle);
      AV57Pgmname = "" ;
      AV49ultimoRedondeo = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV11DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV10mesesSAC_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV29forzados_habitual_param_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV50vaciaFecha = GXutil.nullDate() ;
      AV9mesesSAC = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV28forzados_habitual_param = new GXSimpleCollection<String>(String.class, "internal", "");
      Combo_mesessac_Selectedvalue_set = "" ;
      Combo_forzados_habitual_param_Selectedvalue_set = "" ;
      Grid1_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      AV20sac_no_ConCodigo = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucGrid1_empowerer = new com.genexus.webpanels.GXUserControl();
      Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A32TLiqCod = "" ;
      A340TliqDesc = "" ;
      AV48redondeo = "" ;
      scmdbuf = "" ;
      H00CM2_A3CliCod = new int[1] ;
      H00CM2_A340TliqDesc = new String[] {""} ;
      H00CM2_A32TLiqCod = new String[] {""} ;
      H00CM3_AGRID1_nRecordCount = new long[1] ;
      AV27proporcion_habitual_param = DecimalUtil.ZERO ;
      AV33jornalConCodigo = "" ;
      AV34mensualConCodigo = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV14ParmValue = "" ;
      AV45item = new web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem(remoteHandle, context);
      Grid1Row = new com.genexus.webpanels.GXWebRow();
      AV52hoy = GXutil.nullDate() ;
      AV51desdeFecha = GXutil.nullDate() ;
      AV31JSON = "" ;
      H00CM4_A3CliCod = new int[1] ;
      H00CM4_A26ConCodigo = new String[] {""} ;
      H00CM4_A41ConDescrip = new String[] {""} ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      AV12Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      ucCombo_forzados_habitual_param = new com.genexus.webpanels.GXUserControl();
      GXt_char6 = "" ;
      GXt_char5 = "" ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      ucCombo_mesessac = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      lblTextblockcombo_mesessac_Jsonclick = "" ;
      lblTextblockcombo_forzados_habitual_param_Jsonclick = "" ;
      bttBtnconfirmar_Jsonclick = "" ;
      bttBtncancelar_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid1_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      Grid1Column = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.parametros__default(),
         new Object[] {
             new Object[] {
            H00CM2_A3CliCod, H00CM2_A340TliqDesc, H00CM2_A32TLiqCod
            }
            , new Object[] {
            H00CM3_AGRID1_nRecordCount
            }
            , new Object[] {
            H00CM4_A3CliCod, H00CM4_A26ConCodigo, H00CM4_A41ConDescrip
            }
         }
      );
      AV57Pgmname = "Parametros" ;
      /* GeneXus formulas. */
      AV57Pgmname = "Parametros" ;
      Gx_err = (short)(0) ;
   }

   private byte GRID1_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte subGrid1_Backcolorstyle ;
   private byte AV32antiguedad_fraccion_anioMes ;
   private byte AV35horas_default_feriado ;
   private byte subGrid1_Backstyle ;
   private byte subGrid1_Titlebackstyle ;
   private byte subGrid1_Allowselection ;
   private byte subGrid1_Allowhovering ;
   private byte subGrid1_Allowcollapsing ;
   private byte subGrid1_Collapsed ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_83 ;
   private int subGrid1_Rows ;
   private int nGXsfl_83_idx=1 ;
   private int AV7CliCod ;
   private int edtavSac_no_concodigo_Visible ;
   private int subGrid1_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int A3CliCod ;
   private int AV55GXV1 ;
   private int nGXsfl_83_fel_idx=1 ;
   private int tblTbltipoliqs_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtavProporcion_habitual_param_Enabled ;
   private int edtavAntiguedad_fraccion_aniomes_Enabled ;
   private int edtavJornalconcodigo_Enabled ;
   private int edtavMensualconcodigo_Enabled ;
   private int edtavHoras_default_feriado_Enabled ;
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
   private java.math.BigDecimal AV27proporcion_habitual_param ;
   private String Combo_mesessac_Selectedvalue_get ;
   private String Combo_forzados_habitual_param_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_83_idx="0001" ;
   private String AV57Pgmname ;
   private String AV49ultimoRedondeo ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Combo_mesessac_Cls ;
   private String Combo_mesessac_Selectedvalue_set ;
   private String Combo_mesessac_Datalisttype ;
   private String Combo_mesessac_Datalistfixedvalues ;
   private String Combo_mesessac_Multiplevaluestype ;
   private String Combo_forzados_habitual_param_Cls ;
   private String Combo_forzados_habitual_param_Selectedvalue_set ;
   private String Combo_forzados_habitual_param_Multiplevaluestype ;
   private String Grid1_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String edtavSac_no_concodigo_Internalname ;
   private String AV20sac_no_ConCodigo ;
   private String edtavSac_no_concodigo_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
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
   private String AV48redondeo ;
   private String scmdbuf ;
   private String edtavProporcion_habitual_param_Internalname ;
   private String edtavAntiguedad_fraccion_aniomes_Internalname ;
   private String AV33jornalConCodigo ;
   private String edtavJornalconcodigo_Internalname ;
   private String AV34mensualConCodigo ;
   private String edtavMensualconcodigo_Internalname ;
   private String edtavHoras_default_feriado_Internalname ;
   private String sGXsfl_83_fel_idx="0001" ;
   private String tblTbltipoliqs_Internalname ;
   private String A26ConCodigo ;
   private String Combo_forzados_habitual_param_Internalname ;
   private String GXt_char6 ;
   private String GXt_char5 ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String Combo_mesessac_Internalname ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String divTablesplittedmesessac_Internalname ;
   private String lblTextblockcombo_mesessac_Internalname ;
   private String lblTextblockcombo_mesessac_Jsonclick ;
   private String Combo_mesessac_Caption ;
   private String edtavProporcion_habitual_param_Jsonclick ;
   private String divTablesplittedforzados_habitual_param_Internalname ;
   private String lblTextblockcombo_forzados_habitual_param_Internalname ;
   private String lblTextblockcombo_forzados_habitual_param_Jsonclick ;
   private String Combo_forzados_habitual_param_Caption ;
   private String edtavAntiguedad_fraccion_aniomes_Jsonclick ;
   private String edtavJornalconcodigo_Jsonclick ;
   private String edtavMensualconcodigo_Jsonclick ;
   private String edtavHoras_default_feriado_Jsonclick ;
   private String bttBtnconfirmar_Internalname ;
   private String bttBtnconfirmar_Jsonclick ;
   private String bttBtncancelar_Internalname ;
   private String bttBtncancelar_Jsonclick ;
   private String grpUnnamedgroup2_Internalname ;
   private String tblUnnamedtable1_Internalname ;
   private String subGrid1_Class ;
   private String subGrid1_Linesclass ;
   private String ROClassString ;
   private String edtTLiqCod_Jsonclick ;
   private String edtTliqDesc_Jsonclick ;
   private String GXCCtl ;
   private String subGrid1_Header ;
   private java.util.Date AV50vaciaFecha ;
   private java.util.Date AV52hoy ;
   private java.util.Date AV51desdeFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_83_Refreshing=false ;
   private boolean AV15liquidar_adelanto_retencion ;
   private boolean AV26todos_30 ;
   private boolean AV37desglosar_adicional ;
   private boolean AV16log_fallido ;
   private boolean Combo_mesessac_Allowmultipleselection ;
   private boolean Combo_mesessac_Includeonlyselectedoption ;
   private boolean Combo_mesessac_Emptyitem ;
   private boolean Combo_forzados_habitual_param_Allowmultipleselection ;
   private boolean Combo_forzados_habitual_param_Includeonlyselectedoption ;
   private boolean Combo_forzados_habitual_param_Emptyitem ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean AV38TLiqHabilitada ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String AV14ParmValue ;
   private String wcpOAV47MenuOpcCod ;
   private String AV47MenuOpcCod ;
   private String A340TliqDesc ;
   private String AV31JSON ;
   private String A41ConDescrip ;
   private GXSimpleCollection<Byte> AV9mesesSAC ;
   private com.genexus.webpanels.GXWebGrid Grid1Container ;
   private com.genexus.webpanels.GXWebRow Grid1Row ;
   private com.genexus.webpanels.GXWebColumn Grid1Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGrid1_empowerer ;
   private com.genexus.webpanels.GXUserControl ucCombo_forzados_habitual_param ;
   private com.genexus.webpanels.GXUserControl ucCombo_mesessac ;
   private HTMLChoice cmbavRedondeo ;
   private ICheckbox chkavLiquidar_adelanto_retencion ;
   private ICheckbox chkavTodos_30 ;
   private ICheckbox chkavDesglosar_adicional ;
   private ICheckbox chkavTliqhabilitada ;
   private ICheckbox chkavLog_fallido ;
   private IDataStoreProvider pr_default ;
   private int[] H00CM2_A3CliCod ;
   private String[] H00CM2_A340TliqDesc ;
   private String[] H00CM2_A32TLiqCod ;
   private long[] H00CM3_AGRID1_nRecordCount ;
   private int[] H00CM4_A3CliCod ;
   private String[] H00CM4_A26ConCodigo ;
   private String[] H00CM4_A41ConDescrip ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV28forzados_habitual_param ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV10mesesSAC_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV29forzados_habitual_param_Data ;
   private GXBaseCollection<web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem> AV44sdt_tipo_liqs ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV12Combo_DataItem ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV11DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
   private web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem AV45item ;
}

final  class parametros__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00CM2", "SELECT CliCod, TliqDesc, TLiqCod FROM TipoLiquidacion WHERE CliCod = ? ORDER BY CliCod  OFFSET ? LIMIT CASE WHEN ? > 0 THEN ? ELSE 1e9 END",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00CM3", "SELECT COUNT(*) FROM TipoLiquidacion WHERE CliCod = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00CM4", "SELECT CliCod, ConCodigo, ConDescrip FROM Concepto WHERE CliCod = ? ORDER BY CliCod, ConDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

