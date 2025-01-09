package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class librosueldosdigital_impl extends GXDataArea
{
   public librosueldosdigital_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public librosueldosdigital_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( librosueldosdigital_impl.class ));
   }

   public librosueldosdigital_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbavMesperiodo = new HTMLChoice();
      cmbavTipoenvio = new HTMLChoice();
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
            AV81MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81MenuOpcCod", AV81MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV81MenuOpcCod, ""))));
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
      nRC_GXsfl_242 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_242"))) ;
      nGXsfl_242_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_242_idx"))) ;
      sGXsfl_242_idx = httpContext.GetPar( "sGXsfl_242_idx") ;
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
      AV8CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV88WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      AV10EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV20liqNumero = (int)(GXutil.lval( httpContext.GetPar( "liqNumero"))) ;
      AV81MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid1_refresh( subGrid1_Rows, AV8CliCod, AV88WelcomeMessage_NoMostrarMas, AV10EmpCod, AV20liqNumero, AV81MenuOpcCod) ;
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
      pa2N2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2N2( ) ;
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
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.librosueldosdigital", new String[] {GXutil.URLEncode(GXutil.rtrim(AV81MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20liqNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV81MenuOpcCod, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_242", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_242, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGNUMERO_DATA", AV77LegNumero_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGNUMERO_DATA", AV77LegNumero_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSUELDOBASICO_DATA", AV30SueldoBasico_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSUELDOBASICO_DATA", AV30SueldoBasico_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSUELDOBASICOMENSUAL_DATA", AV79SueldoBasicoMensual_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSUELDOBASICOMENSUAL_DATA", AV79SueldoBasicoMensual_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMATERNIDADANSES_DATA", AV32MaternidadAnses_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMATERNIDADANSES_DATA", AV32MaternidadAnses_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vAPORTEADICOS_DATA", AV33AporteAdicOS_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vAPORTEADICOS_DATA", AV33AporteAdicOS_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCONTRADICOS_DATA", AV34ContrAdicOS_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCONTRADICOS_DATA", AV34ContrAdicOS_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vBASECALDIFAPOOS_FSR_DATA", AV71BaseCalDifApoOS_FSR_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBASECALDIFAPOOS_FSR_DATA", AV71BaseCalDifApoOS_FSR_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vBASECALDIFCONTROS_FSR_DATA", AV72BaseCalDifContrOS_FSR_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBASECALDIFCONTROS_FSR_DATA", AV72BaseCalDifContrOS_FSR_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vBASEIMPO1_DATA", AV54BaseImpo1_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBASEIMPO1_DATA", AV54BaseImpo1_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vBASEIMPO2_DATA", AV55BaseImpo2_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBASEIMPO2_DATA", AV55BaseImpo2_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vBASEIMPO3_DATA", AV56BaseImpo3_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBASEIMPO3_DATA", AV56BaseImpo3_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vBASEIMPO4_DATA", AV57BaseImpo4_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBASEIMPO4_DATA", AV57BaseImpo4_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vBASEIMPO5_DATA", AV58BaseImpo5_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBASEIMPO5_DATA", AV58BaseImpo5_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vBASEIMPO6_DATA", AV59BaseImpo6_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBASEIMPO6_DATA", AV59BaseImpo6_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vBASEIMPO7_DATA", AV60BaseImpo7_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBASEIMPO7_DATA", AV60BaseImpo7_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vBASEIMPO8_DATA", AV61BaseImpo8_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBASEIMPO8_DATA", AV61BaseImpo8_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vBASEIMPO9_DATA", AV62BaseImpo9_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBASEIMPO9_DATA", AV62BaseImpo9_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vBASEIMPO10_DATA", AV63BaseImpo10_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBASEIMPO10_DATA", AV63BaseImpo10_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV10EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQPERIODO", localUtil.dtoc( AV19LiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQNUMERO", GXutil.ltrim( localUtil.ntoc( AV20liqNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20liqNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV81MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV81MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPERIODO", localUtil.dtoc( A283LiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQNRO", GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Cls", GXutil.rtrim( Combo_legnumero_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Selectedvalue_set", GXutil.rtrim( Combo_legnumero_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Emptyitemtext", GXutil.rtrim( Combo_legnumero_Emptyitemtext));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIBRO_Width", GXutil.rtrim( Dvpanel_panellibro_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIBRO_Autowidth", GXutil.booltostr( Dvpanel_panellibro_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIBRO_Autoheight", GXutil.booltostr( Dvpanel_panellibro_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIBRO_Cls", GXutil.rtrim( Dvpanel_panellibro_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIBRO_Title", GXutil.rtrim( Dvpanel_panellibro_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIBRO_Collapsible", GXutil.booltostr( Dvpanel_panellibro_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIBRO_Collapsed", GXutil.booltostr( Dvpanel_panellibro_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIBRO_Showcollapseicon", GXutil.booltostr( Dvpanel_panellibro_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIBRO_Iconposition", GXutil.rtrim( Dvpanel_panellibro_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIBRO_Autoscroll", GXutil.booltostr( Dvpanel_panellibro_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUELDOBASICO_Cls", GXutil.rtrim( Combo_sueldobasico_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUELDOBASICO_Selectedvalue_set", GXutil.rtrim( Combo_sueldobasico_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUELDOBASICOMENSUAL_Cls", GXutil.rtrim( Combo_sueldobasicomensual_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUELDOBASICOMENSUAL_Selectedvalue_set", GXutil.rtrim( Combo_sueldobasicomensual_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MATERNIDADANSES_Cls", GXutil.rtrim( Combo_maternidadanses_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MATERNIDADANSES_Selectedvalue_set", GXutil.rtrim( Combo_maternidadanses_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APORTEADICOS_Cls", GXutil.rtrim( Combo_aporteadicos_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APORTEADICOS_Selectedvalue_set", GXutil.rtrim( Combo_aporteadicos_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONTRADICOS_Cls", GXutil.rtrim( Combo_contradicos_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONTRADICOS_Selectedvalue_set", GXutil.rtrim( Combo_contradicos_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM1_Width", GXutil.rtrim( Dvpanel_panelparam1_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM1_Autowidth", GXutil.booltostr( Dvpanel_panelparam1_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM1_Autoheight", GXutil.booltostr( Dvpanel_panelparam1_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM1_Cls", GXutil.rtrim( Dvpanel_panelparam1_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM1_Title", GXutil.rtrim( Dvpanel_panelparam1_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM1_Collapsible", GXutil.booltostr( Dvpanel_panelparam1_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM1_Collapsed", GXutil.booltostr( Dvpanel_panelparam1_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM1_Showcollapseicon", GXutil.booltostr( Dvpanel_panelparam1_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM1_Iconposition", GXutil.rtrim( Dvpanel_panelparam1_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM1_Autoscroll", GXutil.booltostr( Dvpanel_panelparam1_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASECALDIFAPOOS_FSR_Cls", GXutil.rtrim( Combo_basecaldifapoos_fsr_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASECALDIFAPOOS_FSR_Selectedvalue_set", GXutil.rtrim( Combo_basecaldifapoos_fsr_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASECALDIFCONTROS_FSR_Cls", GXutil.rtrim( Combo_basecaldifcontros_fsr_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASECALDIFCONTROS_FSR_Selectedvalue_set", GXutil.rtrim( Combo_basecaldifcontros_fsr_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASESD_Width", GXutil.rtrim( Dvpanel_tblbasesd_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASESD_Autowidth", GXutil.booltostr( Dvpanel_tblbasesd_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASESD_Autoheight", GXutil.booltostr( Dvpanel_tblbasesd_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASESD_Cls", GXutil.rtrim( Dvpanel_tblbasesd_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASESD_Title", GXutil.rtrim( Dvpanel_tblbasesd_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASESD_Collapsible", GXutil.booltostr( Dvpanel_tblbasesd_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASESD_Collapsed", GXutil.booltostr( Dvpanel_tblbasesd_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASESD_Showcollapseicon", GXutil.booltostr( Dvpanel_tblbasesd_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASESD_Iconposition", GXutil.rtrim( Dvpanel_tblbasesd_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASESD_Autoscroll", GXutil.booltostr( Dvpanel_tblbasesd_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO1_Cls", GXutil.rtrim( Combo_baseimpo1_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO1_Selectedvalue_set", GXutil.rtrim( Combo_baseimpo1_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO2_Cls", GXutil.rtrim( Combo_baseimpo2_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO2_Selectedvalue_set", GXutil.rtrim( Combo_baseimpo2_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO3_Cls", GXutil.rtrim( Combo_baseimpo3_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO3_Selectedvalue_set", GXutil.rtrim( Combo_baseimpo3_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO4_Cls", GXutil.rtrim( Combo_baseimpo4_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO4_Selectedvalue_set", GXutil.rtrim( Combo_baseimpo4_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO5_Cls", GXutil.rtrim( Combo_baseimpo5_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO5_Selectedvalue_set", GXutil.rtrim( Combo_baseimpo5_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO6_Cls", GXutil.rtrim( Combo_baseimpo6_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO6_Selectedvalue_set", GXutil.rtrim( Combo_baseimpo6_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO7_Cls", GXutil.rtrim( Combo_baseimpo7_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO7_Selectedvalue_set", GXutil.rtrim( Combo_baseimpo7_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO8_Cls", GXutil.rtrim( Combo_baseimpo8_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO8_Selectedvalue_set", GXutil.rtrim( Combo_baseimpo8_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO9_Cls", GXutil.rtrim( Combo_baseimpo9_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO9_Selectedvalue_set", GXutil.rtrim( Combo_baseimpo9_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO10_Cls", GXutil.rtrim( Combo_baseimpo10_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO10_Selectedvalue_set", GXutil.rtrim( Combo_baseimpo10_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASES_Width", GXutil.rtrim( Dvpanel_tblbases_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASES_Autowidth", GXutil.booltostr( Dvpanel_tblbases_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASES_Autoheight", GXutil.booltostr( Dvpanel_tblbases_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASES_Cls", GXutil.rtrim( Dvpanel_tblbases_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASES_Title", GXutil.rtrim( Dvpanel_tblbases_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASES_Collapsible", GXutil.booltostr( Dvpanel_tblbases_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASES_Collapsed", GXutil.booltostr( Dvpanel_tblbases_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASES_Showcollapseicon", GXutil.booltostr( Dvpanel_tblbases_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASES_Iconposition", GXutil.rtrim( Dvpanel_tblbases_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLBASES_Autoscroll", GXutil.booltostr( Dvpanel_tblbases_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM_Width", GXutil.rtrim( Dvpanel_panelparam_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM_Autowidth", GXutil.booltostr( Dvpanel_panelparam_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM_Autoheight", GXutil.booltostr( Dvpanel_panelparam_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM_Cls", GXutil.rtrim( Dvpanel_panelparam_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM_Title", GXutil.rtrim( Dvpanel_panelparam_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM_Collapsible", GXutil.booltostr( Dvpanel_panelparam_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM_Collapsed", GXutil.booltostr( Dvpanel_panelparam_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM_Showcollapseicon", GXutil.booltostr( Dvpanel_panelparam_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM_Iconposition", GXutil.rtrim( Dvpanel_panelparam_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPARAM_Autoscroll", GXutil.booltostr( Dvpanel_panelparam_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCONCAFIP_Width", GXutil.rtrim( Dvpanel_panelconcafip_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCONCAFIP_Autowidth", GXutil.booltostr( Dvpanel_panelconcafip_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCONCAFIP_Autoheight", GXutil.booltostr( Dvpanel_panelconcafip_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCONCAFIP_Cls", GXutil.rtrim( Dvpanel_panelconcafip_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCONCAFIP_Title", GXutil.rtrim( Dvpanel_panelconcafip_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCONCAFIP_Collapsible", GXutil.booltostr( Dvpanel_panelconcafip_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCONCAFIP_Collapsed", GXutil.booltostr( Dvpanel_panelconcafip_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCONCAFIP_Showcollapseicon", GXutil.booltostr( Dvpanel_panelconcafip_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCONCAFIP_Iconposition", GXutil.rtrim( Dvpanel_panelconcafip_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCONCAFIP_Autoscroll", GXutil.booltostr( Dvpanel_panelconcafip_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS1_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabs1_Pagecount, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS1_Class", GXutil.rtrim( Gxuitabspanel_tabs1_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS1_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabs1_Historymanagement));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid1_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO10_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo10_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO9_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo9_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO8_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo8_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO7_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo7_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO6_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo6_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO5_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo5_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO4_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo4_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO3_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo3_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO2_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo2_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO1_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo1_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASECALDIFCONTROS_FSR_Selectedvalue_get", GXutil.rtrim( Combo_basecaldifcontros_fsr_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASECALDIFAPOOS_FSR_Selectedvalue_get", GXutil.rtrim( Combo_basecaldifapoos_fsr_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONTRADICOS_Selectedvalue_get", GXutil.rtrim( Combo_contradicos_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APORTEADICOS_Selectedvalue_get", GXutil.rtrim( Combo_aporteadicos_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MATERNIDADANSES_Selectedvalue_get", GXutil.rtrim( Combo_maternidadanses_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUELDOBASICOMENSUAL_Selectedvalue_get", GXutil.rtrim( Combo_sueldobasicomensual_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUELDOBASICO_Selectedvalue_get", GXutil.rtrim( Combo_sueldobasico_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Selectedvalue_get", GXutil.rtrim( Combo_legnumero_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO10_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo10_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO9_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo9_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO8_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo8_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO7_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo7_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO6_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo6_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO5_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo5_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO4_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo4_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO3_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo3_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO2_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo2_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASEIMPO1_Selectedvalue_get", GXutil.rtrim( Combo_baseimpo1_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASECALDIFCONTROS_FSR_Selectedvalue_get", GXutil.rtrim( Combo_basecaldifcontros_fsr_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_BASECALDIFAPOOS_FSR_Selectedvalue_get", GXutil.rtrim( Combo_basecaldifapoos_fsr_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONTRADICOS_Selectedvalue_get", GXutil.rtrim( Combo_contradicos_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APORTEADICOS_Selectedvalue_get", GXutil.rtrim( Combo_aporteadicos_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MATERNIDADANSES_Selectedvalue_get", GXutil.rtrim( Combo_maternidadanses_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUELDOBASICOMENSUAL_Selectedvalue_get", GXutil.rtrim( Combo_sueldobasicomensual_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUELDOBASICO_Selectedvalue_get", GXutil.rtrim( Combo_sueldobasico_Selectedvalue_get));
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
         we2N2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2N2( ) ;
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
      return formatLink("web.librosueldosdigital", new String[] {GXutil.URLEncode(GXutil.rtrim(AV81MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "LibroSueldosDigital" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Libro de Sueldos Digital", "") ;
   }

   public void wb2N0( )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableparent_Internalname, divWelcomemessage_welcometableparent_Visible, 0, "px", 0, "px", "WelcomeTableParent", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableprincipal_Internalname, 1, 0, "px", 0, "px", "WelcomeHeaderItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tableclose_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e112n1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomecontentitem_Internalname, 1, 0, "px", 0, "px", "WelcomeContentItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomecontentflex_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "WelcomeTableImagenCell", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableimagen_Internalname, 1, 0, "px", 0, "px", "WelcomeTableImagen", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Welcome Message_Foto", ""), "gx-form-item WelcomeImagenLabel", 0, true, "width: 25%;");
         /* Static Bitmap Variable */
         ClassString = "WelcomeImagen" + " " + ((GXutil.strcmp(imgavWelcomemessage_foto_gximage, "")==0) ? "" : "GX_Image_"+imgavWelcomemessage_foto_gximage+"_Class") ;
         StyleString = "" ;
         AV89WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV89WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV93Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV89WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV89WelcomeMessage_Foto)==0) ? AV93Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV89WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV89WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "WelcomeTableTextoCell", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tabletexto_Internalname, 1, 0, "px", 0, "px", "WelcomeTableTexto", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:flex-start;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table1_24_2N2( true) ;
      }
      else
      {
         wb_table1_24_2N2( false) ;
      }
      return  ;
   }

   public void wb_table1_24_2N2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table2_29_2N2( true) ;
      }
      else
      {
         wb_table2_29_2N2( false) ;
      }
      return  ;
   }

   public void wb_table2_29_2N2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomebottomitem_Internalname, 1, 0, "px", 0, "px", "WelcomeBottomItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tablecmb_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tablec_Internalname, 1, 0, "px", 0, "px", "TableC font14px", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), "gx-form-item AttributeCheckBoxLabel", 0, true, "width: 25%;");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV88WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,39);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tabletext_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
         wb_table3_46_2N2( true) ;
      }
      else
      {
         wb_table3_46_2N2( false) ;
      }
      return  ;
   }

   public void wb_table3_46_2N2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 263,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegnumero_Internalname, GXutil.ltrim( localUtil.ntoc( AV76LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV76LegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,263);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegnumero_Jsonclick, 0, "Attribute", "", "", "", "", edtavLegnumero_Visible, 1, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 264,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSueldobasico_Internalname, GXutil.rtrim( AV29SueldoBasico), GXutil.rtrim( localUtil.format( AV29SueldoBasico, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,264);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSueldobasico_Jsonclick, 0, "Attribute", "", "", "", "", edtavSueldobasico_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 265,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSueldobasicomensual_Internalname, GXutil.rtrim( AV78SueldoBasicoMensual), GXutil.rtrim( localUtil.format( AV78SueldoBasicoMensual, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,265);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSueldobasicomensual_Jsonclick, 0, "Attribute", "", "", "", "", edtavSueldobasicomensual_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 266,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavMaternidadanses_Internalname, GXutil.rtrim( AV27MaternidadAnses), GXutil.rtrim( localUtil.format( AV27MaternidadAnses, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,266);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavMaternidadanses_Jsonclick, 0, "Attribute", "", "", "", "", edtavMaternidadanses_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 267,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavAporteadicos_Internalname, GXutil.rtrim( AV25AporteAdicOS), GXutil.rtrim( localUtil.format( AV25AporteAdicOS, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,267);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAporteadicos_Jsonclick, 0, "Attribute", "", "", "", "", edtavAporteadicos_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 268,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavContradicos_Internalname, GXutil.rtrim( AV26ContrAdicOS), GXutil.rtrim( localUtil.format( AV26ContrAdicOS, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,268);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavContradicos_Jsonclick, 0, "Attribute", "", "", "", "", edtavContradicos_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 269,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBasecaldifapoos_fsr_Internalname, GXutil.rtrim( AV65BaseCalDifApoOS_FSR), GXutil.rtrim( localUtil.format( AV65BaseCalDifApoOS_FSR, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,269);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBasecaldifapoos_fsr_Jsonclick, 0, "Attribute", "", "", "", "", edtavBasecaldifapoos_fsr_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 270,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBasecaldifcontros_fsr_Internalname, GXutil.rtrim( AV66BaseCalDifContrOS_FSR), GXutil.rtrim( localUtil.format( AV66BaseCalDifContrOS_FSR, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,270);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBasecaldifcontros_fsr_Jsonclick, 0, "Attribute", "", "", "", "", edtavBasecaldifcontros_fsr_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 271,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBaseimpo1_Internalname, GXutil.rtrim( AV44BaseImpo1), GXutil.rtrim( localUtil.format( AV44BaseImpo1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,271);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBaseimpo1_Jsonclick, 0, "Attribute", "", "", "", "", edtavBaseimpo1_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 272,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBaseimpo2_Internalname, GXutil.rtrim( AV45BaseImpo2), GXutil.rtrim( localUtil.format( AV45BaseImpo2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,272);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBaseimpo2_Jsonclick, 0, "Attribute", "", "", "", "", edtavBaseimpo2_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 273,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBaseimpo3_Internalname, GXutil.rtrim( AV46BaseImpo3), GXutil.rtrim( localUtil.format( AV46BaseImpo3, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,273);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBaseimpo3_Jsonclick, 0, "Attribute", "", "", "", "", edtavBaseimpo3_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 274,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBaseimpo4_Internalname, GXutil.rtrim( AV47BaseImpo4), GXutil.rtrim( localUtil.format( AV47BaseImpo4, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,274);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBaseimpo4_Jsonclick, 0, "Attribute", "", "", "", "", edtavBaseimpo4_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 275,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBaseimpo5_Internalname, GXutil.rtrim( AV48BaseImpo5), GXutil.rtrim( localUtil.format( AV48BaseImpo5, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,275);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBaseimpo5_Jsonclick, 0, "Attribute", "", "", "", "", edtavBaseimpo5_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 276,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBaseimpo6_Internalname, GXutil.rtrim( AV49BaseImpo6), GXutil.rtrim( localUtil.format( AV49BaseImpo6, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,276);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBaseimpo6_Jsonclick, 0, "Attribute", "", "", "", "", edtavBaseimpo6_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 277,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBaseimpo7_Internalname, GXutil.rtrim( AV50BaseImpo7), GXutil.rtrim( localUtil.format( AV50BaseImpo7, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,277);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBaseimpo7_Jsonclick, 0, "Attribute", "", "", "", "", edtavBaseimpo7_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 278,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBaseimpo8_Internalname, GXutil.rtrim( AV51BaseImpo8), GXutil.rtrim( localUtil.format( AV51BaseImpo8, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,278);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBaseimpo8_Jsonclick, 0, "Attribute", "", "", "", "", edtavBaseimpo8_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 279,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBaseimpo9_Internalname, GXutil.rtrim( AV52BaseImpo9), GXutil.rtrim( localUtil.format( AV52BaseImpo9, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,279);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBaseimpo9_Jsonclick, 0, "Attribute", "", "", "", "", edtavBaseimpo9_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 280,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavBaseimpo10_Internalname, GXutil.rtrim( AV53BaseImpo10), GXutil.rtrim( localUtil.format( AV53BaseImpo10, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,280);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBaseimpo10_Jsonclick, 0, "Attribute", "", "", "", "", edtavBaseimpo10_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LibroSueldosDigital.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 281,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqnro_Internalname, GXutil.ltrim( localUtil.ntoc( AV13LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV13LiqNro), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,281);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqnro_Jsonclick, 0, "Attribute", "", "", "", "", edtavLiqnro_Visible, 1, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LibroSueldosDigital.htm");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 282,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavTipoenvio, cmbavTipoenvio.getInternalname(), GXutil.rtrim( AV16TipoEnvio), 1, cmbavTipoenvio.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavTipoenvio.getVisible(), 1, 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,282);\"", "", true, (byte)(0), "HLP_LibroSueldosDigital.htm");
         cmbavTipoenvio.setValue( GXutil.rtrim( AV16TipoEnvio) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavTipoenvio.getInternalname(), "Values", cmbavTipoenvio.ToJavascriptSource(), true);
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 283,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavFecharubrica_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavFecharubrica_Internalname, localUtil.format(AV11FechaRubrica, "99/99/9999"), localUtil.format( AV11FechaRubrica, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,283);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFecharubrica_Jsonclick, 0, "Attribute", "", "", "", "", edtavFecharubrica_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavFecharubrica_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavFecharubrica_Visible==0)||(1==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LibroSueldosDigital.htm");
         httpContext.writeTextNL( "</div>") ;
         /* User Defined Control */
         ucGrid1_empowerer.render(context, "wwp.gridempowerer", Grid1_empowerer_Internalname, "GRID1_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 242 )
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

   public void start2N2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Libro de Sueldos Digital", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2N0( ) ;
   }

   public void ws2N2( )
   {
      start2N2( ) ;
      evt2N2( ) ;
   }

   public void evt2N2( )
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
                        else if ( GXutil.strcmp(sEvt, "COMBO_SUELDOBASICO.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_SUELDOBASICOMENSUAL.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_MATERNIDADANSES.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e142N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_APORTEADICOS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e152N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_CONTRADICOS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e162N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_BASECALDIFAPOOS_FSR.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e172N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_BASECALDIFCONTROS_FSR.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e182N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_BASEIMPO1.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e192N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_BASEIMPO2.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e202N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_BASEIMPO3.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e212N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_BASEIMPO4.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e222N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_BASEIMPO5.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e232N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_BASEIMPO6.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e242N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_BASEIMPO7.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e252N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_BASEIMPO8.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e262N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_BASEIMPO9.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e272N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_BASEIMPO10.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e282N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOGENERARARCHIVO'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoGenerarArchivo' */
                           e292N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCOMENZARASISTENTE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoComenzarAsistente' */
                           e302N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOGENERARLIQUIDACIONES'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoGenerarLiquidaciones' */
                           e312N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e322N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VANIOPERIODO.ISVALID") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e332N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VMESPERIODO.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e342N2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID1.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 25), "'DORELACIONCONCEPTOSAFIP'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_242_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_242_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_242_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2422( ) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A383ConAfipDesc = httpContext.cgiGet( edtConAfipDesc_Internalname) ;
                           A73ConCodPropio = httpContext.cgiGet( edtConCodPropio_Internalname) ;
                           A386ConAFIPConcepto = httpContext.cgiGet( edtConAFIPConcepto_Internalname) ;
                           n386ConAFIPConcepto = false ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e352N2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID1.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e362N2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e372N2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "'DORELACIONCONCEPTOSAFIP'") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoRelacionConceptosAFIP' */
                                 e382N2 ();
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

   public void we2N2( )
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

   public void pa2N2( )
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
            GX_FocusControl = chkavWelcomemessage_nomostrarmas.getInternalname() ;
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
      subsflControlProps_2422( ) ;
      while ( nGXsfl_242_idx <= nRC_GXsfl_242 )
      {
         sendrow_2422( ) ;
         nGXsfl_242_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_242_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_242_idx+1) ;
         sGXsfl_242_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_242_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2422( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid1Container)) ;
      /* End function gxnrGrid1_newrow */
   }

   public void gxgrgrid1_refresh( int subGrid1_Rows ,
                                  int AV8CliCod ,
                                  boolean AV88WelcomeMessage_NoMostrarMas ,
                                  short AV10EmpCod ,
                                  int AV20liqNumero ,
                                  String AV81MenuOpcCod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e372N2 ();
      GRID1_nCurrentRecord = 0 ;
      rf2N2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid1_refresh */
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
      AV88WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV88WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV88WelcomeMessage_NoMostrarMas", AV88WelcomeMessage_NoMostrarMas);
      if ( cmbavMesperiodo.getItemCount() > 0 )
      {
         AV14MesPeriodo = (byte)(GXutil.lval( cmbavMesperiodo.getValidValue(GXutil.trim( GXutil.str( AV14MesPeriodo, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14MesPeriodo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14MesPeriodo), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavMesperiodo.setValue( GXutil.trim( GXutil.str( AV14MesPeriodo, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMesperiodo.getInternalname(), "Values", cmbavMesperiodo.ToJavascriptSource(), true);
      }
      if ( cmbavTipoenvio.getItemCount() > 0 )
      {
         AV16TipoEnvio = cmbavTipoenvio.getValidValue(AV16TipoEnvio) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16TipoEnvio", AV16TipoEnvio);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavTipoenvio.setValue( GXutil.rtrim( AV16TipoEnvio) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavTipoenvio.getInternalname(), "Values", cmbavTipoenvio.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2N2( ) ;
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

   public void rf2N2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid1Container.ClearRows();
      }
      wbStart = (short)(242) ;
      /* Execute user event: Refresh */
      e372N2 ();
      nGXsfl_242_idx = 1 ;
      sGXsfl_242_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_242_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2422( ) ;
      bGXsfl_242_Refreshing = true ;
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
         subsflControlProps_2422( ) ;
         GXPagingFrom2 = (int)(((subGrid1_Rows==0) ? 0 : GRID1_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid1_Rows==0) ? 10000 : subgrid1_fnc_recordsperpage( )+1) ;
         /* Using cursor H002N2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_242_idx = 1 ;
         sGXsfl_242_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_242_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2422( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid1_Rows == 0 ) || ( GRID1_nCurrentRecord < subgrid1_fnc_recordsperpage( ) ) ) ) )
         {
            A386ConAFIPConcepto = H002N2_A386ConAFIPConcepto[0] ;
            n386ConAFIPConcepto = H002N2_n386ConAFIPConcepto[0] ;
            A73ConCodPropio = H002N2_A73ConCodPropio[0] ;
            A383ConAfipDesc = H002N2_A383ConAfipDesc[0] ;
            A3CliCod = H002N2_A3CliCod[0] ;
            e362N2 ();
            pr_default.readNext(0);
         }
         GRID1_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(242) ;
         wb2N0( ) ;
      }
      bGXsfl_242_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2N2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV10EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQNUMERO", GXutil.ltrim( localUtil.ntoc( AV20liqNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20liqNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV81MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV81MenuOpcCod, ""))));
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
      /* Using cursor H002N3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod)});
      GRID1_nRecordCount = H002N3_AGRID1_nRecordCount[0] ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV8CliCod, AV88WelcomeMessage_NoMostrarMas, AV10EmpCod, AV20liqNumero, AV81MenuOpcCod) ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV8CliCod, AV88WelcomeMessage_NoMostrarMas, AV10EmpCod, AV20liqNumero, AV81MenuOpcCod) ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV8CliCod, AV88WelcomeMessage_NoMostrarMas, AV10EmpCod, AV20liqNumero, AV81MenuOpcCod) ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV8CliCod, AV88WelcomeMessage_NoMostrarMas, AV10EmpCod, AV20liqNumero, AV81MenuOpcCod) ;
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
         gxgrgrid1_refresh( subGrid1_Rows, AV8CliCod, AV88WelcomeMessage_NoMostrarMas, AV10EmpCod, AV20liqNumero, AV81MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup2N0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e352N2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGNUMERO_DATA"), AV77LegNumero_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSUELDOBASICO_DATA"), AV30SueldoBasico_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSUELDOBASICOMENSUAL_DATA"), AV79SueldoBasicoMensual_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMATERNIDADANSES_DATA"), AV32MaternidadAnses_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vAPORTEADICOS_DATA"), AV33AporteAdicOS_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCONTRADICOS_DATA"), AV34ContrAdicOS_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBASECALDIFAPOOS_FSR_DATA"), AV71BaseCalDifApoOS_FSR_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBASECALDIFCONTROS_FSR_DATA"), AV72BaseCalDifContrOS_FSR_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBASEIMPO1_DATA"), AV54BaseImpo1_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBASEIMPO2_DATA"), AV55BaseImpo2_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBASEIMPO3_DATA"), AV56BaseImpo3_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBASEIMPO4_DATA"), AV57BaseImpo4_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBASEIMPO5_DATA"), AV58BaseImpo5_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBASEIMPO6_DATA"), AV59BaseImpo6_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBASEIMPO7_DATA"), AV60BaseImpo7_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBASEIMPO8_DATA"), AV61BaseImpo8_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBASEIMPO9_DATA"), AV62BaseImpo9_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBASEIMPO10_DATA"), AV63BaseImpo10_Data);
         /* Read saved values. */
         nRC_GXsfl_242 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_242"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID1_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID1_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID1_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID1_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid1_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID1_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
         Combo_legnumero_Cls = httpContext.cgiGet( "COMBO_LEGNUMERO_Cls") ;
         Combo_legnumero_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGNUMERO_Selectedvalue_set") ;
         Combo_legnumero_Emptyitemtext = httpContext.cgiGet( "COMBO_LEGNUMERO_Emptyitemtext") ;
         Dvpanel_panellibro_Width = httpContext.cgiGet( "DVPANEL_PANELLIBRO_Width") ;
         Dvpanel_panellibro_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIBRO_Autowidth")) ;
         Dvpanel_panellibro_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIBRO_Autoheight")) ;
         Dvpanel_panellibro_Cls = httpContext.cgiGet( "DVPANEL_PANELLIBRO_Cls") ;
         Dvpanel_panellibro_Title = httpContext.cgiGet( "DVPANEL_PANELLIBRO_Title") ;
         Dvpanel_panellibro_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIBRO_Collapsible")) ;
         Dvpanel_panellibro_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIBRO_Collapsed")) ;
         Dvpanel_panellibro_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIBRO_Showcollapseicon")) ;
         Dvpanel_panellibro_Iconposition = httpContext.cgiGet( "DVPANEL_PANELLIBRO_Iconposition") ;
         Dvpanel_panellibro_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIBRO_Autoscroll")) ;
         Combo_sueldobasico_Cls = httpContext.cgiGet( "COMBO_SUELDOBASICO_Cls") ;
         Combo_sueldobasico_Selectedvalue_set = httpContext.cgiGet( "COMBO_SUELDOBASICO_Selectedvalue_set") ;
         Combo_sueldobasicomensual_Cls = httpContext.cgiGet( "COMBO_SUELDOBASICOMENSUAL_Cls") ;
         Combo_sueldobasicomensual_Selectedvalue_set = httpContext.cgiGet( "COMBO_SUELDOBASICOMENSUAL_Selectedvalue_set") ;
         Combo_maternidadanses_Cls = httpContext.cgiGet( "COMBO_MATERNIDADANSES_Cls") ;
         Combo_maternidadanses_Selectedvalue_set = httpContext.cgiGet( "COMBO_MATERNIDADANSES_Selectedvalue_set") ;
         Combo_aporteadicos_Cls = httpContext.cgiGet( "COMBO_APORTEADICOS_Cls") ;
         Combo_aporteadicos_Selectedvalue_set = httpContext.cgiGet( "COMBO_APORTEADICOS_Selectedvalue_set") ;
         Combo_contradicos_Cls = httpContext.cgiGet( "COMBO_CONTRADICOS_Cls") ;
         Combo_contradicos_Selectedvalue_set = httpContext.cgiGet( "COMBO_CONTRADICOS_Selectedvalue_set") ;
         Dvpanel_panelparam1_Width = httpContext.cgiGet( "DVPANEL_PANELPARAM1_Width") ;
         Dvpanel_panelparam1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPARAM1_Autowidth")) ;
         Dvpanel_panelparam1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPARAM1_Autoheight")) ;
         Dvpanel_panelparam1_Cls = httpContext.cgiGet( "DVPANEL_PANELPARAM1_Cls") ;
         Dvpanel_panelparam1_Title = httpContext.cgiGet( "DVPANEL_PANELPARAM1_Title") ;
         Dvpanel_panelparam1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPARAM1_Collapsible")) ;
         Dvpanel_panelparam1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPARAM1_Collapsed")) ;
         Dvpanel_panelparam1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPARAM1_Showcollapseicon")) ;
         Dvpanel_panelparam1_Iconposition = httpContext.cgiGet( "DVPANEL_PANELPARAM1_Iconposition") ;
         Dvpanel_panelparam1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPARAM1_Autoscroll")) ;
         Combo_basecaldifapoos_fsr_Cls = httpContext.cgiGet( "COMBO_BASECALDIFAPOOS_FSR_Cls") ;
         Combo_basecaldifapoos_fsr_Selectedvalue_set = httpContext.cgiGet( "COMBO_BASECALDIFAPOOS_FSR_Selectedvalue_set") ;
         Combo_basecaldifcontros_fsr_Cls = httpContext.cgiGet( "COMBO_BASECALDIFCONTROS_FSR_Cls") ;
         Combo_basecaldifcontros_fsr_Selectedvalue_set = httpContext.cgiGet( "COMBO_BASECALDIFCONTROS_FSR_Selectedvalue_set") ;
         Dvpanel_tblbasesd_Width = httpContext.cgiGet( "DVPANEL_TBLBASESD_Width") ;
         Dvpanel_tblbasesd_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLBASESD_Autowidth")) ;
         Dvpanel_tblbasesd_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLBASESD_Autoheight")) ;
         Dvpanel_tblbasesd_Cls = httpContext.cgiGet( "DVPANEL_TBLBASESD_Cls") ;
         Dvpanel_tblbasesd_Title = httpContext.cgiGet( "DVPANEL_TBLBASESD_Title") ;
         Dvpanel_tblbasesd_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLBASESD_Collapsible")) ;
         Dvpanel_tblbasesd_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLBASESD_Collapsed")) ;
         Dvpanel_tblbasesd_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLBASESD_Showcollapseicon")) ;
         Dvpanel_tblbasesd_Iconposition = httpContext.cgiGet( "DVPANEL_TBLBASESD_Iconposition") ;
         Dvpanel_tblbasesd_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLBASESD_Autoscroll")) ;
         Combo_baseimpo1_Cls = httpContext.cgiGet( "COMBO_BASEIMPO1_Cls") ;
         Combo_baseimpo1_Selectedvalue_set = httpContext.cgiGet( "COMBO_BASEIMPO1_Selectedvalue_set") ;
         Combo_baseimpo2_Cls = httpContext.cgiGet( "COMBO_BASEIMPO2_Cls") ;
         Combo_baseimpo2_Selectedvalue_set = httpContext.cgiGet( "COMBO_BASEIMPO2_Selectedvalue_set") ;
         Combo_baseimpo3_Cls = httpContext.cgiGet( "COMBO_BASEIMPO3_Cls") ;
         Combo_baseimpo3_Selectedvalue_set = httpContext.cgiGet( "COMBO_BASEIMPO3_Selectedvalue_set") ;
         Combo_baseimpo4_Cls = httpContext.cgiGet( "COMBO_BASEIMPO4_Cls") ;
         Combo_baseimpo4_Selectedvalue_set = httpContext.cgiGet( "COMBO_BASEIMPO4_Selectedvalue_set") ;
         Combo_baseimpo5_Cls = httpContext.cgiGet( "COMBO_BASEIMPO5_Cls") ;
         Combo_baseimpo5_Selectedvalue_set = httpContext.cgiGet( "COMBO_BASEIMPO5_Selectedvalue_set") ;
         Combo_baseimpo6_Cls = httpContext.cgiGet( "COMBO_BASEIMPO6_Cls") ;
         Combo_baseimpo6_Selectedvalue_set = httpContext.cgiGet( "COMBO_BASEIMPO6_Selectedvalue_set") ;
         Combo_baseimpo7_Cls = httpContext.cgiGet( "COMBO_BASEIMPO7_Cls") ;
         Combo_baseimpo7_Selectedvalue_set = httpContext.cgiGet( "COMBO_BASEIMPO7_Selectedvalue_set") ;
         Combo_baseimpo8_Cls = httpContext.cgiGet( "COMBO_BASEIMPO8_Cls") ;
         Combo_baseimpo8_Selectedvalue_set = httpContext.cgiGet( "COMBO_BASEIMPO8_Selectedvalue_set") ;
         Combo_baseimpo9_Cls = httpContext.cgiGet( "COMBO_BASEIMPO9_Cls") ;
         Combo_baseimpo9_Selectedvalue_set = httpContext.cgiGet( "COMBO_BASEIMPO9_Selectedvalue_set") ;
         Combo_baseimpo10_Cls = httpContext.cgiGet( "COMBO_BASEIMPO10_Cls") ;
         Combo_baseimpo10_Selectedvalue_set = httpContext.cgiGet( "COMBO_BASEIMPO10_Selectedvalue_set") ;
         Dvpanel_tblbases_Width = httpContext.cgiGet( "DVPANEL_TBLBASES_Width") ;
         Dvpanel_tblbases_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLBASES_Autowidth")) ;
         Dvpanel_tblbases_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLBASES_Autoheight")) ;
         Dvpanel_tblbases_Cls = httpContext.cgiGet( "DVPANEL_TBLBASES_Cls") ;
         Dvpanel_tblbases_Title = httpContext.cgiGet( "DVPANEL_TBLBASES_Title") ;
         Dvpanel_tblbases_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLBASES_Collapsible")) ;
         Dvpanel_tblbases_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLBASES_Collapsed")) ;
         Dvpanel_tblbases_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLBASES_Showcollapseicon")) ;
         Dvpanel_tblbases_Iconposition = httpContext.cgiGet( "DVPANEL_TBLBASES_Iconposition") ;
         Dvpanel_tblbases_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLBASES_Autoscroll")) ;
         Dvpanel_panelparam_Width = httpContext.cgiGet( "DVPANEL_PANELPARAM_Width") ;
         Dvpanel_panelparam_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPARAM_Autowidth")) ;
         Dvpanel_panelparam_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPARAM_Autoheight")) ;
         Dvpanel_panelparam_Cls = httpContext.cgiGet( "DVPANEL_PANELPARAM_Cls") ;
         Dvpanel_panelparam_Title = httpContext.cgiGet( "DVPANEL_PANELPARAM_Title") ;
         Dvpanel_panelparam_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPARAM_Collapsible")) ;
         Dvpanel_panelparam_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPARAM_Collapsed")) ;
         Dvpanel_panelparam_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPARAM_Showcollapseicon")) ;
         Dvpanel_panelparam_Iconposition = httpContext.cgiGet( "DVPANEL_PANELPARAM_Iconposition") ;
         Dvpanel_panelparam_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPARAM_Autoscroll")) ;
         Dvpanel_panelconcafip_Width = httpContext.cgiGet( "DVPANEL_PANELCONCAFIP_Width") ;
         Dvpanel_panelconcafip_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELCONCAFIP_Autowidth")) ;
         Dvpanel_panelconcafip_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELCONCAFIP_Autoheight")) ;
         Dvpanel_panelconcafip_Cls = httpContext.cgiGet( "DVPANEL_PANELCONCAFIP_Cls") ;
         Dvpanel_panelconcafip_Title = httpContext.cgiGet( "DVPANEL_PANELCONCAFIP_Title") ;
         Dvpanel_panelconcafip_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELCONCAFIP_Collapsible")) ;
         Dvpanel_panelconcafip_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELCONCAFIP_Collapsed")) ;
         Dvpanel_panelconcafip_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELCONCAFIP_Showcollapseicon")) ;
         Dvpanel_panelconcafip_Iconposition = httpContext.cgiGet( "DVPANEL_PANELCONCAFIP_Iconposition") ;
         Dvpanel_panelconcafip_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELCONCAFIP_Autoscroll")) ;
         Gxuitabspanel_tabs1_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_TABS1_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gxuitabspanel_tabs1_Class = httpContext.cgiGet( "GXUITABSPANEL_TABS1_Class") ;
         Gxuitabspanel_tabs1_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_TABS1_Historymanagement")) ;
         Grid1_empowerer_Gridinternalname = httpContext.cgiGet( "GRID1_EMPOWERER_Gridinternalname") ;
         Combo_baseimpo10_Selectedvalue_get = httpContext.cgiGet( "COMBO_BASEIMPO10_Selectedvalue_get") ;
         Combo_baseimpo9_Selectedvalue_get = httpContext.cgiGet( "COMBO_BASEIMPO9_Selectedvalue_get") ;
         Combo_baseimpo8_Selectedvalue_get = httpContext.cgiGet( "COMBO_BASEIMPO8_Selectedvalue_get") ;
         Combo_baseimpo7_Selectedvalue_get = httpContext.cgiGet( "COMBO_BASEIMPO7_Selectedvalue_get") ;
         Combo_baseimpo6_Selectedvalue_get = httpContext.cgiGet( "COMBO_BASEIMPO6_Selectedvalue_get") ;
         Combo_baseimpo5_Selectedvalue_get = httpContext.cgiGet( "COMBO_BASEIMPO5_Selectedvalue_get") ;
         Combo_baseimpo4_Selectedvalue_get = httpContext.cgiGet( "COMBO_BASEIMPO4_Selectedvalue_get") ;
         Combo_baseimpo3_Selectedvalue_get = httpContext.cgiGet( "COMBO_BASEIMPO3_Selectedvalue_get") ;
         Combo_baseimpo2_Selectedvalue_get = httpContext.cgiGet( "COMBO_BASEIMPO2_Selectedvalue_get") ;
         Combo_baseimpo1_Selectedvalue_get = httpContext.cgiGet( "COMBO_BASEIMPO1_Selectedvalue_get") ;
         Combo_basecaldifcontros_fsr_Selectedvalue_get = httpContext.cgiGet( "COMBO_BASECALDIFCONTROS_FSR_Selectedvalue_get") ;
         Combo_basecaldifapoos_fsr_Selectedvalue_get = httpContext.cgiGet( "COMBO_BASECALDIFAPOOS_FSR_Selectedvalue_get") ;
         Combo_contradicos_Selectedvalue_get = httpContext.cgiGet( "COMBO_CONTRADICOS_Selectedvalue_get") ;
         Combo_aporteadicos_Selectedvalue_get = httpContext.cgiGet( "COMBO_APORTEADICOS_Selectedvalue_get") ;
         Combo_maternidadanses_Selectedvalue_get = httpContext.cgiGet( "COMBO_MATERNIDADANSES_Selectedvalue_get") ;
         Combo_sueldobasicomensual_Selectedvalue_get = httpContext.cgiGet( "COMBO_SUELDOBASICOMENSUAL_Selectedvalue_get") ;
         Combo_sueldobasico_Selectedvalue_get = httpContext.cgiGet( "COMBO_SUELDOBASICO_Selectedvalue_get") ;
         /* Read variables values. */
         AV89WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV88WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV88WelcomeMessage_NoMostrarMas", AV88WelcomeMessage_NoMostrarMas);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavAnioperiodo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavAnioperiodo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vANIOPERIODO");
            GX_FocusControl = edtavAnioperiodo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV5AnioPeriodo = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5AnioPeriodo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5AnioPeriodo), 4, 0));
         }
         else
         {
            AV5AnioPeriodo = (short)(localUtil.ctol( httpContext.cgiGet( edtavAnioperiodo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5AnioPeriodo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5AnioPeriodo), 4, 0));
         }
         cmbavMesperiodo.setName( cmbavMesperiodo.getInternalname() );
         cmbavMesperiodo.setValue( httpContext.cgiGet( cmbavMesperiodo.getInternalname()) );
         AV14MesPeriodo = (byte)(GXutil.lval( httpContext.cgiGet( cmbavMesperiodo.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14MesPeriodo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14MesPeriodo), 2, 0));
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLEGNUMERO");
            GX_FocusControl = edtavLegnumero_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV76LegNumero = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV76LegNumero), 8, 0));
         }
         else
         {
            AV76LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtavLegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV76LegNumero), 8, 0));
         }
         AV29SueldoBasico = httpContext.cgiGet( edtavSueldobasico_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29SueldoBasico", AV29SueldoBasico);
         AV78SueldoBasicoMensual = httpContext.cgiGet( edtavSueldobasicomensual_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV78SueldoBasicoMensual", AV78SueldoBasicoMensual);
         AV27MaternidadAnses = httpContext.cgiGet( edtavMaternidadanses_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27MaternidadAnses", AV27MaternidadAnses);
         AV25AporteAdicOS = httpContext.cgiGet( edtavAporteadicos_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25AporteAdicOS", AV25AporteAdicOS);
         AV26ContrAdicOS = httpContext.cgiGet( edtavContradicos_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ContrAdicOS", AV26ContrAdicOS);
         AV65BaseCalDifApoOS_FSR = httpContext.cgiGet( edtavBasecaldifapoos_fsr_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65BaseCalDifApoOS_FSR", AV65BaseCalDifApoOS_FSR);
         AV66BaseCalDifContrOS_FSR = httpContext.cgiGet( edtavBasecaldifcontros_fsr_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV66BaseCalDifContrOS_FSR", AV66BaseCalDifContrOS_FSR);
         AV44BaseImpo1 = httpContext.cgiGet( edtavBaseimpo1_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44BaseImpo1", AV44BaseImpo1);
         AV45BaseImpo2 = httpContext.cgiGet( edtavBaseimpo2_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45BaseImpo2", AV45BaseImpo2);
         AV46BaseImpo3 = httpContext.cgiGet( edtavBaseimpo3_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46BaseImpo3", AV46BaseImpo3);
         AV47BaseImpo4 = httpContext.cgiGet( edtavBaseimpo4_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47BaseImpo4", AV47BaseImpo4);
         AV48BaseImpo5 = httpContext.cgiGet( edtavBaseimpo5_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48BaseImpo5", AV48BaseImpo5);
         AV49BaseImpo6 = httpContext.cgiGet( edtavBaseimpo6_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV49BaseImpo6", AV49BaseImpo6);
         AV50BaseImpo7 = httpContext.cgiGet( edtavBaseimpo7_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50BaseImpo7", AV50BaseImpo7);
         AV51BaseImpo8 = httpContext.cgiGet( edtavBaseimpo8_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51BaseImpo8", AV51BaseImpo8);
         AV52BaseImpo9 = httpContext.cgiGet( edtavBaseimpo9_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52BaseImpo9", AV52BaseImpo9);
         AV53BaseImpo10 = httpContext.cgiGet( edtavBaseimpo10_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV53BaseImpo10", AV53BaseImpo10);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLiqnro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLiqnro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLIQNRO");
            GX_FocusControl = edtavLiqnro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV13LiqNro = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LiqNro), 8, 0));
         }
         else
         {
            AV13LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtavLiqnro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LiqNro), 8, 0));
         }
         cmbavTipoenvio.setName( cmbavTipoenvio.getInternalname() );
         cmbavTipoenvio.setValue( httpContext.cgiGet( cmbavTipoenvio.getInternalname()) );
         AV16TipoEnvio = httpContext.cgiGet( cmbavTipoenvio.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16TipoEnvio", AV16TipoEnvio);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavFecharubrica_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vFECHARUBRICA");
            GX_FocusControl = edtavFecharubrica_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11FechaRubrica = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11FechaRubrica", localUtil.format(AV11FechaRubrica, "99/99/9999"));
         }
         else
         {
            AV11FechaRubrica = localUtil.ctod( httpContext.cgiGet( edtavFecharubrica_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11FechaRubrica", localUtil.format(AV11FechaRubrica, "99/99/9999"));
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
      e352N2 ();
      if (returnInSub) return;
   }

   public void e352N2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_char1 = AV37Normal ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
      librosueldosdigital_impl.this.GXt_char1 = GXv_char2[0] ;
      AV37Normal = GXt_char1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37Normal", AV37Normal);
      GXt_int3 = AV10EmpCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int4) ;
      librosueldosdigital_impl.this.GXt_int3 = GXv_int4[0] ;
      AV10EmpCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10EmpCod), "ZZZ9")));
      new web.setopcionmenusesion(remoteHandle, context).execute( AV81MenuOpcCod, "", "") ;
      AV82headTitle = Form.getCaption() ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", "", AV82headTitle) ;
      GXt_int5 = AV8CliCod ;
      GXv_int6[0] = GXt_int5 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int6) ;
      librosueldosdigital_impl.this.GXt_int5 = GXv_int6[0] ;
      AV8CliCod = GXt_int5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
      edtavBaseimpo10_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBaseimpo10_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBaseimpo10_Visible), 5, 0), true);
      edtavBaseimpo9_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBaseimpo9_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBaseimpo9_Visible), 5, 0), true);
      edtavBaseimpo8_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBaseimpo8_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBaseimpo8_Visible), 5, 0), true);
      edtavBaseimpo7_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBaseimpo7_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBaseimpo7_Visible), 5, 0), true);
      edtavBaseimpo6_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBaseimpo6_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBaseimpo6_Visible), 5, 0), true);
      edtavBaseimpo5_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBaseimpo5_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBaseimpo5_Visible), 5, 0), true);
      edtavBaseimpo4_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBaseimpo4_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBaseimpo4_Visible), 5, 0), true);
      edtavBaseimpo3_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBaseimpo3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBaseimpo3_Visible), 5, 0), true);
      edtavBaseimpo2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBaseimpo2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBaseimpo2_Visible), 5, 0), true);
      edtavBaseimpo1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBaseimpo1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBaseimpo1_Visible), 5, 0), true);
      edtavBasecaldifcontros_fsr_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBasecaldifcontros_fsr_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBasecaldifcontros_fsr_Visible), 5, 0), true);
      edtavBasecaldifapoos_fsr_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBasecaldifapoos_fsr_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBasecaldifapoos_fsr_Visible), 5, 0), true);
      edtavContradicos_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavContradicos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavContradicos_Visible), 5, 0), true);
      edtavAporteadicos_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAporteadicos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAporteadicos_Visible), 5, 0), true);
      edtavMaternidadanses_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMaternidadanses_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMaternidadanses_Visible), 5, 0), true);
      edtavSueldobasicomensual_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSueldobasicomensual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSueldobasicomensual_Visible), 5, 0), true);
      edtavSueldobasico_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSueldobasico_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSueldobasico_Visible), 5, 0), true);
      edtavLegnumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLegnumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegnumero_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOSUELDOBASICO' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOSUELDOBASICOMENSUAL' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOMATERNIDADANSES' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOAPORTEADICOS' */
      S152 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOCONTRADICOS' */
      S162 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOBASECALDIFAPOOS_FSR' */
      S172 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOBASECALDIFCONTROS_FSR' */
      S182 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOBASEIMPO1' */
      S192 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOBASEIMPO2' */
      S202 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOBASEIMPO3' */
      S212 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOBASEIMPO4' */
      S222 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOBASEIMPO5' */
      S232 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOBASEIMPO6' */
      S242 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOBASEIMPO7' */
      S252 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOBASEIMPO8' */
      S262 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOBASEIMPO9' */
      S272 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOBASEIMPO10' */
      S282 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S292 ();
      if (returnInSub) return;
      edtavLiqnro_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqnro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqnro_Visible), 5, 0), true);
      cmbavTipoenvio.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavTipoenvio.getInternalname(), "Visible", GXutil.ltrimstr( cmbavTipoenvio.getVisible(), 5, 0), true);
      edtavFecharubrica_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFecharubrica_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFecharubrica_Visible), 5, 0), true);
      Grid1_empowerer_Gridinternalname = subGrid1_Internalname ;
      ucGrid1_empowerer.sendProperty(context, "", false, Grid1_empowerer_Internalname, "GridInternalName", Grid1_empowerer_Gridinternalname);
      subGrid1_Rows = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
      GXv_char2[0] = AV83MenuBienveImgURL ;
      GXv_char7[0] = AV85MenuBienveTitulo ;
      GXv_char8[0] = AV86MenuBienveTexto ;
      GXv_boolean9[0] = AV87MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV81MenuOpcCod, GXv_char2, GXv_char7, GXv_char8, GXv_boolean9) ;
      librosueldosdigital_impl.this.AV83MenuBienveImgURL = GXv_char2[0] ;
      librosueldosdigital_impl.this.AV85MenuBienveTitulo = GXv_char7[0] ;
      librosueldosdigital_impl.this.AV86MenuBienveTexto = GXv_char8[0] ;
      librosueldosdigital_impl.this.AV87MenuBienveVisible = GXv_boolean9[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV87MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV87MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV85MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV86MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV89WelcomeMessage_Foto = AV83MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV89WelcomeMessage_Foto)==0) ? AV93Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV89WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV89WelcomeMessage_Foto), true);
         AV93Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV83MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV89WelcomeMessage_Foto)==0) ? AV93Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV89WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV89WelcomeMessage_Foto), true);
      }
      GXt_char1 = "" ;
      GXt_char10 = "" ;
      GXv_char8[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char1 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char7) ;
      librosueldosdigital_impl.this.GXt_char1 = GXv_char7[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char1 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV11FechaRubrica = GXutil.serverDate( context, remoteHandle, pr_default) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11FechaRubrica", localUtil.format(AV11FechaRubrica, "99/99/9999"));
      GXv_int4[0] = AV17UltAnio ;
      GXv_int11[0] = AV18UltMes ;
      new web.getperiodoultliq(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, GXv_int4, GXv_int11) ;
      librosueldosdigital_impl.this.AV17UltAnio = GXv_int4[0] ;
      librosueldosdigital_impl.this.AV18UltMes = GXv_int11[0] ;
      AV5AnioPeriodo = AV17UltAnio ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5AnioPeriodo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5AnioPeriodo), 4, 0));
      AV14MesPeriodo = (byte)(AV18UltMes) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14MesPeriodo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14MesPeriodo), 2, 0));
      /* Execute user subroutine: 'LIQUIDACION POR PERIODO' */
      S302 ();
      if (returnInSub) return;
   }

   private void e362N2( )
   {
      /* Grid1_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(242) ;
      }
      sendrow_2422( ) ;
      GRID1_nCurrentRecord = (long)(GRID1_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_242_Refreshing )
      {
         httpContext.doAjaxLoad(242, Grid1Row);
      }
   }

   public void e292N2( )
   {
      /* 'DoGenerarArchivo' Routine */
      returnInSub = false ;
      GXv_char8[0] = AV7archivofullpath ;
      GXv_char7[0] = AV6archivo ;
      new web.genarchivoconcepempafip2(remoteHandle, context).execute( GXv_char8, GXv_char7) ;
      librosueldosdigital_impl.this.AV7archivofullpath = GXv_char8[0] ;
      librosueldosdigital_impl.this.AV6archivo = GXv_char7[0] ;
      callWebObject(formatLink("web.adownload", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "text/plain", ""))),GXutil.URLEncode(GXutil.rtrim(AV6archivo)),GXutil.URLEncode(GXutil.rtrim(AV7archivofullpath))}, new String[] {"contenttype","filename","filepath"}) );
      httpContext.wjLocDisableFrm = (byte)(2) ;
   }

   public void e302N2( )
   {
      /* 'DoComenzarAsistente' Routine */
      returnInSub = false ;
      GXt_boolean12 = AV38hay ;
      GXv_boolean9[0] = GXt_boolean12 ;
      new web.hayconceptosafip(remoteHandle, context).execute( AV8CliCod, GXv_boolean9) ;
      librosueldosdigital_impl.this.GXt_boolean12 = GXv_boolean9[0] ;
      AV38hay = GXt_boolean12 ;
      if ( ! AV38hay )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No hay conceptos AFIP para configurar. Primero debe generar al menos una liquidación", ""));
      }
      else
      {
         callWebObject(formatLink("web.conceptosafipwizard", new String[] {GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.booltostr(false))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
   }

   public void e312N2( )
   {
      /* 'DoGenerarLiquidaciones' Routine */
      returnInSub = false ;
      GXv_char8[0] = AV23error ;
      new web.validacioneslibrodigital(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, AV19LiqPeriodo, AV20liqNumero, GXv_char8) ;
      librosueldosdigital_impl.this.AV23error = GXv_char8[0] ;
      if ( (GXutil.strcmp("", AV23error)==0) )
      {
         GXv_int6[0] = AV80LSDSec ;
         new web.genarchivoliquidacionesafip3(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, AV19LiqPeriodo, AV76LegNumero, AV16TipoEnvio, AV20liqNumero, GXv_int6) ;
         librosueldosdigital_impl.this.AV80LSDSec = GXv_int6[0] ;
         if ( ! (0==AV76LegNumero) )
         {
            GXv_int13[0] = AV90LegCUIL ;
            new web.obtcuillegajo(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, AV76LegNumero, GXv_int13) ;
            librosueldosdigital_impl.this.AV90LegCUIL = GXv_int13[0] ;
         }
         else
         {
            AV90LegCUIL = 0 ;
         }
         GXv_char8[0] = AV7archivofullpath ;
         GXv_char7[0] = AV6archivo ;
         new web.bajalsdaarchivo2(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, 0, AV19LiqPeriodo, AV90LegCUIL, GXv_char8, GXv_char7) ;
         librosueldosdigital_impl.this.AV7archivofullpath = GXv_char8[0] ;
         librosueldosdigital_impl.this.AV6archivo = GXv_char7[0] ;
         callWebObject(formatLink("web.adownload", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "text/plain", ""))),GXutil.URLEncode(GXutil.rtrim(AV6archivo)),GXutil.URLEncode(GXutil.rtrim(AV7archivofullpath))}, new String[] {"contenttype","filename","filepath"}) );
         httpContext.wjLocDisableFrm = (byte)(2) ;
      }
   }

   public void e282N2( )
   {
      /* Combo_baseimpo10_Onoptionclicked Routine */
      returnInSub = false ;
      AV53BaseImpo10 = Combo_baseimpo10_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53BaseImpo10", AV53BaseImpo10);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.parametro_concepto_lsd_baseimponible10(remoteHandle, context).executeUdp( ), AV53BaseImpo10, "") ;
      /*  Sending Event outputs  */
   }

   public void e272N2( )
   {
      /* Combo_baseimpo9_Onoptionclicked Routine */
      returnInSub = false ;
      AV52BaseImpo9 = Combo_baseimpo9_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52BaseImpo9", AV52BaseImpo9);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.parametro_concepto_lsd_baseimponible9(remoteHandle, context).executeUdp( ), AV52BaseImpo9, "") ;
      /*  Sending Event outputs  */
   }

   public void e262N2( )
   {
      /* Combo_baseimpo8_Onoptionclicked Routine */
      returnInSub = false ;
      AV51BaseImpo8 = Combo_baseimpo8_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51BaseImpo8", AV51BaseImpo8);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.parametro_concepto_lsd_baseimponible8(remoteHandle, context).executeUdp( ), AV51BaseImpo8, "") ;
      /*  Sending Event outputs  */
   }

   public void e252N2( )
   {
      /* Combo_baseimpo7_Onoptionclicked Routine */
      returnInSub = false ;
      AV50BaseImpo7 = Combo_baseimpo7_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50BaseImpo7", AV50BaseImpo7);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.parametro_concepto_lsd_baseimponible7(remoteHandle, context).executeUdp( ), AV50BaseImpo7, "") ;
      /*  Sending Event outputs  */
   }

   public void e242N2( )
   {
      /* Combo_baseimpo6_Onoptionclicked Routine */
      returnInSub = false ;
      AV49BaseImpo6 = Combo_baseimpo6_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49BaseImpo6", AV49BaseImpo6);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.parametro_concepto_lsd_baseimponible6(remoteHandle, context).executeUdp( ), AV49BaseImpo6, "") ;
      /*  Sending Event outputs  */
   }

   public void e232N2( )
   {
      /* Combo_baseimpo5_Onoptionclicked Routine */
      returnInSub = false ;
      AV48BaseImpo5 = Combo_baseimpo5_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48BaseImpo5", AV48BaseImpo5);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.parametro_concepto_lsd_baseimponible5(remoteHandle, context).executeUdp( ), AV48BaseImpo5, "") ;
      /*  Sending Event outputs  */
   }

   public void e222N2( )
   {
      /* Combo_baseimpo4_Onoptionclicked Routine */
      returnInSub = false ;
      AV47BaseImpo4 = Combo_baseimpo4_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47BaseImpo4", AV47BaseImpo4);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.parametro_concepto_lsd_baseimponible4(remoteHandle, context).executeUdp( ), AV47BaseImpo4, "") ;
      /*  Sending Event outputs  */
   }

   public void e212N2( )
   {
      /* Combo_baseimpo3_Onoptionclicked Routine */
      returnInSub = false ;
      AV46BaseImpo3 = Combo_baseimpo3_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46BaseImpo3", AV46BaseImpo3);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.parametro_concepto_lsd_baseimponible3(remoteHandle, context).executeUdp( ), AV46BaseImpo3, "") ;
      /*  Sending Event outputs  */
   }

   public void e202N2( )
   {
      /* Combo_baseimpo2_Onoptionclicked Routine */
      returnInSub = false ;
      AV45BaseImpo2 = Combo_baseimpo2_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45BaseImpo2", AV45BaseImpo2);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.parametro_concepto_lsd_baseimponible2(remoteHandle, context).executeUdp( ), AV45BaseImpo2, "") ;
      /*  Sending Event outputs  */
   }

   public void e192N2( )
   {
      /* Combo_baseimpo1_Onoptionclicked Routine */
      returnInSub = false ;
      AV44BaseImpo1 = Combo_baseimpo1_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44BaseImpo1", AV44BaseImpo1);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.parametro_concepto_lsd_baseimponible1(remoteHandle, context).executeUdp( ), AV44BaseImpo1, "") ;
      /*  Sending Event outputs  */
   }

   public void e182N2( )
   {
      /* Combo_basecaldifcontros_fsr_Onoptionclicked Routine */
      returnInSub = false ;
      AV66BaseCalDifContrOS_FSR = Combo_basecaldifcontros_fsr_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66BaseCalDifContrOS_FSR", AV66BaseCalDifContrOS_FSR);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.parametro_concepto_lsd_basedifcontrosfsr(remoteHandle, context).executeUdp( ), AV66BaseCalDifContrOS_FSR, "") ;
      /*  Sending Event outputs  */
   }

   public void e172N2( )
   {
      /* Combo_basecaldifapoos_fsr_Onoptionclicked Routine */
      returnInSub = false ;
      AV65BaseCalDifApoOS_FSR = Combo_basecaldifapoos_fsr_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65BaseCalDifApoOS_FSR", AV65BaseCalDifApoOS_FSR);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.parametro_concepto_lsd_basedifapoosfsr(remoteHandle, context).executeUdp( ), AV65BaseCalDifApoOS_FSR, "") ;
      /*  Sending Event outputs  */
   }

   public void e162N2( )
   {
      /* Combo_contradicos_Onoptionclicked Routine */
      returnInSub = false ;
      AV26ContrAdicOS = Combo_contradicos_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ContrAdicOS", AV26ContrAdicOS);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_contradicos_codigoparam(remoteHandle, context).executeUdp( ), AV26ContrAdicOS, "") ;
      /*  Sending Event outputs  */
   }

   public void e152N2( )
   {
      /* Combo_aporteadicos_Onoptionclicked Routine */
      returnInSub = false ;
      AV25AporteAdicOS = Combo_aporteadicos_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25AporteAdicOS", AV25AporteAdicOS);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_apoadicos_codigoparam(remoteHandle, context).executeUdp( ), AV25AporteAdicOS, "") ;
      /*  Sending Event outputs  */
   }

   public void e142N2( )
   {
      /* Combo_maternidadanses_Onoptionclicked Routine */
      returnInSub = false ;
      AV27MaternidadAnses = Combo_maternidadanses_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27MaternidadAnses", AV27MaternidadAnses);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_licenciapormaternidad_codigoparam(remoteHandle, context).executeUdp( ), AV27MaternidadAnses, "") ;
      /*  Sending Event outputs  */
   }

   public void e132N2( )
   {
      /* Combo_sueldobasicomensual_Onoptionclicked Routine */
      returnInSub = false ;
      AV78SueldoBasicoMensual = Combo_sueldobasicomensual_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78SueldoBasicoMensual", AV78SueldoBasicoMensual);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_sueldomensual_codigoparam(remoteHandle, context).executeUdp( ), AV78SueldoBasicoMensual, "") ;
      /*  Sending Event outputs  */
   }

   public void e122N2( )
   {
      /* Combo_sueldobasico_Onoptionclicked Routine */
      returnInSub = false ;
      AV29SueldoBasico = Combo_sueldobasico_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29SueldoBasico", AV29SueldoBasico);
      new web.grabaparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_sueldojornal_codigoparam(remoteHandle, context).executeUdp( ), AV29SueldoBasico, "") ;
      /*  Sending Event outputs  */
   }

   public void S292( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( false ) )
      {
         divDvpanel_panelconcafip_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divDvpanel_panelconcafip_cell_Internalname, "Class", divDvpanel_panelconcafip_cell_Class, true);
      }
      else
      {
         divDvpanel_panelconcafip_cell_Class = "col-xs-12" ;
         httpContext.ajax_rsp_assign_prop("", false, divDvpanel_panelconcafip_cell_Internalname, "Class", divDvpanel_panelconcafip_cell_Class, true);
      }
   }

   public void S282( )
   {
      /* 'LOADCOMBOBASEIMPO10' Routine */
      returnInSub = false ;
      GXt_char10 = AV53BaseImpo10 ;
      GXv_char8[0] = GXt_char10 ;
      new web.concepto_lsd_baseimponible10(remoteHandle, context).execute( AV8CliCod, GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char8[0] ;
      AV53BaseImpo10 = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53BaseImpo10", AV53BaseImpo10);
      /* Using cursor H002N4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A150ConHabilitado = H002N4_A150ConHabilitado[0] ;
         A37TipoConCod = H002N4_A37TipoConCod[0] ;
         A3CliCod = H002N4_A3CliCod[0] ;
         A26ConCodigo = H002N4_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N4_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N4_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV63BaseImpo10_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(2);
      }
      pr_default.close(2);
      Combo_baseimpo10_Selectedvalue_set = AV53BaseImpo10 ;
      ucCombo_baseimpo10.sendProperty(context, "", false, Combo_baseimpo10_Internalname, "SelectedValue_set", Combo_baseimpo10_Selectedvalue_set);
   }

   public void S272( )
   {
      /* 'LOADCOMBOBASEIMPO9' Routine */
      returnInSub = false ;
      GXt_char10 = AV52BaseImpo9 ;
      GXv_char8[0] = GXt_char10 ;
      new web.concepto_lsd_baseimponible9(remoteHandle, context).execute( AV8CliCod, GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char8[0] ;
      AV52BaseImpo9 = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52BaseImpo9", AV52BaseImpo9);
      /* Using cursor H002N5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A150ConHabilitado = H002N5_A150ConHabilitado[0] ;
         A37TipoConCod = H002N5_A37TipoConCod[0] ;
         A3CliCod = H002N5_A3CliCod[0] ;
         A26ConCodigo = H002N5_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N5_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N5_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV62BaseImpo9_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(3);
      }
      pr_default.close(3);
      Combo_baseimpo9_Selectedvalue_set = AV52BaseImpo9 ;
      ucCombo_baseimpo9.sendProperty(context, "", false, Combo_baseimpo9_Internalname, "SelectedValue_set", Combo_baseimpo9_Selectedvalue_set);
   }

   public void S262( )
   {
      /* 'LOADCOMBOBASEIMPO8' Routine */
      returnInSub = false ;
      GXt_char10 = AV51BaseImpo8 ;
      GXv_char8[0] = GXt_char10 ;
      new web.concepto_lsd_baseimponible8(remoteHandle, context).execute( AV8CliCod, GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char8[0] ;
      AV51BaseImpo8 = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51BaseImpo8", AV51BaseImpo8);
      /* Using cursor H002N6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A150ConHabilitado = H002N6_A150ConHabilitado[0] ;
         A37TipoConCod = H002N6_A37TipoConCod[0] ;
         A3CliCod = H002N6_A3CliCod[0] ;
         A26ConCodigo = H002N6_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N6_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N6_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV61BaseImpo8_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(4);
      }
      pr_default.close(4);
      Combo_baseimpo8_Selectedvalue_set = AV51BaseImpo8 ;
      ucCombo_baseimpo8.sendProperty(context, "", false, Combo_baseimpo8_Internalname, "SelectedValue_set", Combo_baseimpo8_Selectedvalue_set);
   }

   public void S252( )
   {
      /* 'LOADCOMBOBASEIMPO7' Routine */
      returnInSub = false ;
      GXt_char10 = AV50BaseImpo7 ;
      GXv_char8[0] = GXt_char10 ;
      new web.concepto_lsd_baseimponible7(remoteHandle, context).execute( AV8CliCod, GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char8[0] ;
      AV50BaseImpo7 = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50BaseImpo7", AV50BaseImpo7);
      /* Using cursor H002N7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(5) != 101) )
      {
         A150ConHabilitado = H002N7_A150ConHabilitado[0] ;
         A37TipoConCod = H002N7_A37TipoConCod[0] ;
         A3CliCod = H002N7_A3CliCod[0] ;
         A26ConCodigo = H002N7_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N7_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N7_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV60BaseImpo7_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(5);
      }
      pr_default.close(5);
      Combo_baseimpo7_Selectedvalue_set = AV50BaseImpo7 ;
      ucCombo_baseimpo7.sendProperty(context, "", false, Combo_baseimpo7_Internalname, "SelectedValue_set", Combo_baseimpo7_Selectedvalue_set);
   }

   public void S242( )
   {
      /* 'LOADCOMBOBASEIMPO6' Routine */
      returnInSub = false ;
      GXt_char10 = AV49BaseImpo6 ;
      GXv_char8[0] = GXt_char10 ;
      new web.concepto_lsd_baseimponible6(remoteHandle, context).execute( AV8CliCod, GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char8[0] ;
      AV49BaseImpo6 = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49BaseImpo6", AV49BaseImpo6);
      /* Using cursor H002N8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         A150ConHabilitado = H002N8_A150ConHabilitado[0] ;
         A37TipoConCod = H002N8_A37TipoConCod[0] ;
         A3CliCod = H002N8_A3CliCod[0] ;
         A26ConCodigo = H002N8_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N8_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N8_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV59BaseImpo6_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(6);
      }
      pr_default.close(6);
      Combo_baseimpo6_Selectedvalue_set = AV49BaseImpo6 ;
      ucCombo_baseimpo6.sendProperty(context, "", false, Combo_baseimpo6_Internalname, "SelectedValue_set", Combo_baseimpo6_Selectedvalue_set);
   }

   public void S232( )
   {
      /* 'LOADCOMBOBASEIMPO5' Routine */
      returnInSub = false ;
      GXt_char10 = AV48BaseImpo5 ;
      GXv_char8[0] = GXt_char10 ;
      new web.concepto_lsd_baseimponible5(remoteHandle, context).execute( AV8CliCod, GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char8[0] ;
      AV48BaseImpo5 = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48BaseImpo5", AV48BaseImpo5);
      /* Using cursor H002N9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(7) != 101) )
      {
         A150ConHabilitado = H002N9_A150ConHabilitado[0] ;
         A37TipoConCod = H002N9_A37TipoConCod[0] ;
         A3CliCod = H002N9_A3CliCod[0] ;
         A26ConCodigo = H002N9_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N9_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N9_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV58BaseImpo5_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(7);
      }
      pr_default.close(7);
      Combo_baseimpo5_Selectedvalue_set = AV48BaseImpo5 ;
      ucCombo_baseimpo5.sendProperty(context, "", false, Combo_baseimpo5_Internalname, "SelectedValue_set", Combo_baseimpo5_Selectedvalue_set);
   }

   public void S222( )
   {
      /* 'LOADCOMBOBASEIMPO4' Routine */
      returnInSub = false ;
      GXt_char10 = AV47BaseImpo4 ;
      GXv_char8[0] = GXt_char10 ;
      new web.concepto_lsd_baseimponible4(remoteHandle, context).execute( AV8CliCod, GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char8[0] ;
      AV47BaseImpo4 = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47BaseImpo4", AV47BaseImpo4);
      /* Using cursor H002N10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(8) != 101) )
      {
         A150ConHabilitado = H002N10_A150ConHabilitado[0] ;
         A37TipoConCod = H002N10_A37TipoConCod[0] ;
         A3CliCod = H002N10_A3CliCod[0] ;
         A26ConCodigo = H002N10_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N10_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N10_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV57BaseImpo4_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(8);
      }
      pr_default.close(8);
      Combo_baseimpo4_Selectedvalue_set = AV47BaseImpo4 ;
      ucCombo_baseimpo4.sendProperty(context, "", false, Combo_baseimpo4_Internalname, "SelectedValue_set", Combo_baseimpo4_Selectedvalue_set);
   }

   public void S212( )
   {
      /* 'LOADCOMBOBASEIMPO3' Routine */
      returnInSub = false ;
      GXt_char10 = AV46BaseImpo3 ;
      GXv_char8[0] = GXt_char10 ;
      new web.concepto_lsd_baseimponible3(remoteHandle, context).execute( AV8CliCod, GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char8[0] ;
      AV46BaseImpo3 = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46BaseImpo3", AV46BaseImpo3);
      /* Using cursor H002N11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(9) != 101) )
      {
         A150ConHabilitado = H002N11_A150ConHabilitado[0] ;
         A37TipoConCod = H002N11_A37TipoConCod[0] ;
         A3CliCod = H002N11_A3CliCod[0] ;
         A26ConCodigo = H002N11_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N11_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N11_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV56BaseImpo3_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(9);
      }
      pr_default.close(9);
      Combo_baseimpo3_Selectedvalue_set = AV46BaseImpo3 ;
      ucCombo_baseimpo3.sendProperty(context, "", false, Combo_baseimpo3_Internalname, "SelectedValue_set", Combo_baseimpo3_Selectedvalue_set);
   }

   public void S202( )
   {
      /* 'LOADCOMBOBASEIMPO2' Routine */
      returnInSub = false ;
      GXt_char10 = AV45BaseImpo2 ;
      GXv_char8[0] = GXt_char10 ;
      new web.concepto_lsd_baseimponible2(remoteHandle, context).execute( AV8CliCod, GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char8[0] ;
      AV45BaseImpo2 = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45BaseImpo2", AV45BaseImpo2);
      /* Using cursor H002N12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(10) != 101) )
      {
         A150ConHabilitado = H002N12_A150ConHabilitado[0] ;
         A37TipoConCod = H002N12_A37TipoConCod[0] ;
         A3CliCod = H002N12_A3CliCod[0] ;
         A26ConCodigo = H002N12_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N12_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N12_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV55BaseImpo2_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(10);
      }
      pr_default.close(10);
      Combo_baseimpo2_Selectedvalue_set = AV45BaseImpo2 ;
      ucCombo_baseimpo2.sendProperty(context, "", false, Combo_baseimpo2_Internalname, "SelectedValue_set", Combo_baseimpo2_Selectedvalue_set);
   }

   public void S192( )
   {
      /* 'LOADCOMBOBASEIMPO1' Routine */
      returnInSub = false ;
      GXt_char10 = AV44BaseImpo1 ;
      GXv_char8[0] = GXt_char10 ;
      new web.concepto_lsd_baseimponible1(remoteHandle, context).execute( AV8CliCod, GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char8[0] ;
      AV44BaseImpo1 = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44BaseImpo1", AV44BaseImpo1);
      /* Using cursor H002N13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(11) != 101) )
      {
         A150ConHabilitado = H002N13_A150ConHabilitado[0] ;
         A37TipoConCod = H002N13_A37TipoConCod[0] ;
         A3CliCod = H002N13_A3CliCod[0] ;
         A26ConCodigo = H002N13_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N13_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N13_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV54BaseImpo1_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(11);
      }
      pr_default.close(11);
      Combo_baseimpo1_Selectedvalue_set = AV44BaseImpo1 ;
      ucCombo_baseimpo1.sendProperty(context, "", false, Combo_baseimpo1_Internalname, "SelectedValue_set", Combo_baseimpo1_Selectedvalue_set);
   }

   public void S182( )
   {
      /* 'LOADCOMBOBASECALDIFCONTROS_FSR' Routine */
      returnInSub = false ;
      GXt_char10 = AV66BaseCalDifContrOS_FSR ;
      GXt_char1 = AV66BaseCalDifContrOS_FSR ;
      GXv_char8[0] = GXt_char1 ;
      new web.parametro_concepto_lsd_basedifcontrosfsr(remoteHandle, context).execute( GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char1 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char7) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char7[0] ;
      AV66BaseCalDifContrOS_FSR = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66BaseCalDifContrOS_FSR", AV66BaseCalDifContrOS_FSR);
      /* Using cursor H002N14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         A150ConHabilitado = H002N14_A150ConHabilitado[0] ;
         A37TipoConCod = H002N14_A37TipoConCod[0] ;
         A3CliCod = H002N14_A3CliCod[0] ;
         A26ConCodigo = H002N14_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N14_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N14_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV72BaseCalDifContrOS_FSR_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(12);
      }
      pr_default.close(12);
      Combo_basecaldifcontros_fsr_Selectedvalue_set = AV66BaseCalDifContrOS_FSR ;
      ucCombo_basecaldifcontros_fsr.sendProperty(context, "", false, Combo_basecaldifcontros_fsr_Internalname, "SelectedValue_set", Combo_basecaldifcontros_fsr_Selectedvalue_set);
   }

   public void S172( )
   {
      /* 'LOADCOMBOBASECALDIFAPOOS_FSR' Routine */
      returnInSub = false ;
      GXt_char10 = AV65BaseCalDifApoOS_FSR ;
      GXt_char1 = AV65BaseCalDifApoOS_FSR ;
      GXv_char8[0] = GXt_char1 ;
      new web.parametro_concepto_lsd_basedifapoosfsr(remoteHandle, context).execute( GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char1 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char7) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char7[0] ;
      AV65BaseCalDifApoOS_FSR = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65BaseCalDifApoOS_FSR", AV65BaseCalDifApoOS_FSR);
      /* Using cursor H002N15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(13) != 101) )
      {
         A150ConHabilitado = H002N15_A150ConHabilitado[0] ;
         A37TipoConCod = H002N15_A37TipoConCod[0] ;
         A3CliCod = H002N15_A3CliCod[0] ;
         A26ConCodigo = H002N15_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N15_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N15_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV71BaseCalDifApoOS_FSR_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(13);
      }
      pr_default.close(13);
      Combo_basecaldifapoos_fsr_Selectedvalue_set = AV65BaseCalDifApoOS_FSR ;
      ucCombo_basecaldifapoos_fsr.sendProperty(context, "", false, Combo_basecaldifapoos_fsr_Internalname, "SelectedValue_set", Combo_basecaldifapoos_fsr_Selectedvalue_set);
   }

   public void S162( )
   {
      /* 'LOADCOMBOCONTRADICOS' Routine */
      returnInSub = false ;
      GXt_char10 = AV26ContrAdicOS ;
      GXt_char1 = AV26ContrAdicOS ;
      GXv_char8[0] = GXt_char1 ;
      new web.concepto_contradicos_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char1 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char7) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char7[0] ;
      AV26ContrAdicOS = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ContrAdicOS", AV26ContrAdicOS);
      /* Using cursor H002N16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(14) != 101) )
      {
         A150ConHabilitado = H002N16_A150ConHabilitado[0] ;
         A3CliCod = H002N16_A3CliCod[0] ;
         A26ConCodigo = H002N16_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N16_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N16_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV34ContrAdicOS_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(14);
      }
      pr_default.close(14);
      Combo_contradicos_Selectedvalue_set = AV26ContrAdicOS ;
      ucCombo_contradicos.sendProperty(context, "", false, Combo_contradicos_Internalname, "SelectedValue_set", Combo_contradicos_Selectedvalue_set);
   }

   public void S152( )
   {
      /* 'LOADCOMBOAPORTEADICOS' Routine */
      returnInSub = false ;
      GXt_char10 = AV25AporteAdicOS ;
      GXt_char1 = AV25AporteAdicOS ;
      GXv_char8[0] = GXt_char1 ;
      new web.concepto_apoadicos_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char1 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char7) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char7[0] ;
      AV25AporteAdicOS = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25AporteAdicOS", AV25AporteAdicOS);
      /* Using cursor H002N17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(15) != 101) )
      {
         A150ConHabilitado = H002N17_A150ConHabilitado[0] ;
         A3CliCod = H002N17_A3CliCod[0] ;
         A26ConCodigo = H002N17_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N17_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N17_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV33AporteAdicOS_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(15);
      }
      pr_default.close(15);
      Combo_aporteadicos_Selectedvalue_set = AV25AporteAdicOS ;
      ucCombo_aporteadicos.sendProperty(context, "", false, Combo_aporteadicos_Internalname, "SelectedValue_set", Combo_aporteadicos_Selectedvalue_set);
   }

   public void S142( )
   {
      /* 'LOADCOMBOMATERNIDADANSES' Routine */
      returnInSub = false ;
      GXt_char10 = AV27MaternidadAnses ;
      GXt_char1 = AV27MaternidadAnses ;
      GXv_char8[0] = GXt_char1 ;
      new web.concepto_licenciapormaternidad_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char1 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char7) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char7[0] ;
      AV27MaternidadAnses = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27MaternidadAnses", AV27MaternidadAnses);
      /* Using cursor H002N18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(16) != 101) )
      {
         A150ConHabilitado = H002N18_A150ConHabilitado[0] ;
         A37TipoConCod = H002N18_A37TipoConCod[0] ;
         A3CliCod = H002N18_A3CliCod[0] ;
         A26ConCodigo = H002N18_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N18_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N18_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV32MaternidadAnses_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(16);
      }
      pr_default.close(16);
      Combo_maternidadanses_Selectedvalue_set = AV27MaternidadAnses ;
      ucCombo_maternidadanses.sendProperty(context, "", false, Combo_maternidadanses_Internalname, "SelectedValue_set", Combo_maternidadanses_Selectedvalue_set);
   }

   public void S132( )
   {
      /* 'LOADCOMBOSUELDOBASICOMENSUAL' Routine */
      returnInSub = false ;
      GXt_char10 = AV78SueldoBasicoMensual ;
      GXt_char1 = AV78SueldoBasicoMensual ;
      GXv_char8[0] = GXt_char1 ;
      new web.concepto_sueldomensual_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char1 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char7) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char7[0] ;
      AV78SueldoBasicoMensual = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78SueldoBasicoMensual", AV78SueldoBasicoMensual);
      /* Using cursor H002N19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(AV8CliCod), AV37Normal});
      while ( (pr_default.getStatus(17) != 101) )
      {
         A150ConHabilitado = H002N19_A150ConHabilitado[0] ;
         A38SubTipoConCod1 = H002N19_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = H002N19_n38SubTipoConCod1[0] ;
         A37TipoConCod = H002N19_A37TipoConCod[0] ;
         A3CliCod = H002N19_A3CliCod[0] ;
         A26ConCodigo = H002N19_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N19_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N19_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV79SueldoBasicoMensual_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(17);
      }
      pr_default.close(17);
      Combo_sueldobasicomensual_Selectedvalue_set = AV78SueldoBasicoMensual ;
      ucCombo_sueldobasicomensual.sendProperty(context, "", false, Combo_sueldobasicomensual_Internalname, "SelectedValue_set", Combo_sueldobasicomensual_Selectedvalue_set);
   }

   public void S122( )
   {
      /* 'LOADCOMBOSUELDOBASICO' Routine */
      returnInSub = false ;
      GXt_char10 = AV29SueldoBasico ;
      GXt_char1 = AV29SueldoBasico ;
      GXv_char8[0] = GXt_char1 ;
      new web.concepto_sueldojornal_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      librosueldosdigital_impl.this.GXt_char1 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char7) ;
      librosueldosdigital_impl.this.GXt_char10 = GXv_char7[0] ;
      AV29SueldoBasico = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29SueldoBasico", AV29SueldoBasico);
      /* Using cursor H002N20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(AV8CliCod), AV37Normal});
      while ( (pr_default.getStatus(18) != 101) )
      {
         A150ConHabilitado = H002N20_A150ConHabilitado[0] ;
         A38SubTipoConCod1 = H002N20_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = H002N20_n38SubTipoConCod1[0] ;
         A37TipoConCod = H002N20_A37TipoConCod[0] ;
         A3CliCod = H002N20_A3CliCod[0] ;
         A26ConCodigo = H002N20_A26ConCodigo[0] ;
         A42ConCodYDesc = H002N20_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H002N20_n42ConCodYDesc[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV30SueldoBasico_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(18);
      }
      pr_default.close(18);
      Combo_sueldobasico_Selectedvalue_set = AV29SueldoBasico ;
      ucCombo_sueldobasico.sendProperty(context, "", false, Combo_sueldobasico_Internalname, "SelectedValue_set", Combo_sueldobasico_Selectedvalue_set);
   }

   public void S112( )
   {
      /* 'LOADCOMBOLEGNUMERO' Routine */
      returnInSub = false ;
      /* Using cursor H002N21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV10EmpCod)});
      while ( (pr_default.getStatus(19) != 101) )
      {
         A3CliCod = H002N21_A3CliCod[0] ;
         A1EmpCod = H002N21_A1EmpCod[0] ;
         A6LegNumero = H002N21_A6LegNumero[0] ;
         A250LegIdNomApe = H002N21_A250LegIdNomApe[0] ;
         AV31Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
         AV31Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A250LegIdNomApe );
         AV77LegNumero_Data.add(AV31Combo_DataItem, 0);
         pr_default.readNext(19);
      }
      pr_default.close(19);
      Combo_legnumero_Selectedvalue_set = ((0==AV76LegNumero) ? "" : GXutil.trim( GXutil.str( AV76LegNumero, 8, 0))) ;
      ucCombo_legnumero.sendProperty(context, "", false, Combo_legnumero_Internalname, "SelectedValue_set", Combo_legnumero_Selectedvalue_set);
   }

   public void e372N2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int3 = AV10EmpCod ;
      GXv_int11[0] = GXt_int3 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int11) ;
      librosueldosdigital_impl.this.GXt_int3 = GXv_int11[0] ;
      AV10EmpCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10EmpCod), "ZZZ9")));
      GXt_int5 = AV8CliCod ;
      GXv_int6[0] = GXt_int5 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int6) ;
      librosueldosdigital_impl.this.GXt_int5 = GXv_int6[0] ;
      AV8CliCod = GXt_int5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliCod), "ZZZZZ9")));
      /*  Sending Event outputs  */
   }

   public void e322N2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV88WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean9[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV81MenuOpcCod, GXv_boolean9) ;
         GXv_char8[0] = AV84textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char8) ;
         librosueldosdigital_impl.this.AV84textoNoMostrara = GXv_char8[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV84textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean9[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV81MenuOpcCod, GXv_boolean9) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void e382N2( )
   {
      /* 'DoRelacionConceptosAFIP' Routine */
      returnInSub = false ;
      GXv_char8[0] = AV7archivofullpath ;
      GXv_char7[0] = AV6archivo ;
      new web.genarchivoconcepempafip(remoteHandle, context).execute( GXv_char8, GXv_char7) ;
      librosueldosdigital_impl.this.AV7archivofullpath = GXv_char8[0] ;
      librosueldosdigital_impl.this.AV6archivo = GXv_char7[0] ;
      callWebObject(formatLink("web.adownload", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "text/plain", ""))),GXutil.URLEncode(GXutil.rtrim(AV6archivo)),GXutil.URLEncode(GXutil.rtrim(AV7archivofullpath))}, new String[] {"contenttype","filename","filepath"}) );
      httpContext.wjLocDisableFrm = (byte)(2) ;
   }

   public void e332N2( )
   {
      /* Anioperiodo_Isvalid Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LIQUIDACION POR PERIODO' */
      S302 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e342N2( )
   {
      /* Mesperiodo_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LIQUIDACION POR PERIODO' */
      S302 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void S312( )
   {
      /* 'LOADCOMBOBASECALCONTRDIF_SS' Routine */
      returnInSub = false ;
   }

   public void S322( )
   {
      /* 'LOADCOMBOBASECALAPODIF_SS' Routine */
      returnInSub = false ;
   }

   public void S332( )
   {
      /* 'LOADCOMBOBASECALDIF_LRT' Routine */
      returnInSub = false ;
   }

   public void S302( )
   {
      /* 'LIQUIDACION POR PERIODO' Routine */
      returnInSub = false ;
      edtavLiqnro_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqnro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqnro_Visible), 5, 0), true);
      AV22liqUnica = 0 ;
      AV19LiqPeriodo = localUtil.ymdtod( AV5AnioPeriodo, AV14MesPeriodo, 1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19LiqPeriodo", localUtil.format(AV19LiqPeriodo, "99/99/9999"));
      AV21l = (short)(0) ;
      /* Using cursor H002N22 */
      pr_default.execute(20, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV10EmpCod), AV19LiqPeriodo});
      while ( (pr_default.getStatus(20) != 101) )
      {
         A283LiqPeriodo = H002N22_A283LiqPeriodo[0] ;
         A1EmpCod = H002N22_A1EmpCod[0] ;
         A3CliCod = H002N22_A3CliCod[0] ;
         A31LiqNro = H002N22_A31LiqNro[0] ;
         AV22liqUnica = A31LiqNro ;
         AV21l = (short)(AV21l+1) ;
         pr_default.readNext(20);
      }
      pr_default.close(20);
      if ( AV21l > 1 )
      {
         AV22liqUnica = 0 ;
      }
   }

   public void wb_table3_46_2N2( boolean wbgen )
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
         /* User Defined Control */
         ucGxuitabspanel_tabs1.setProperty("PageCount", Gxuitabspanel_tabs1_Pagecount);
         ucGxuitabspanel_tabs1.setProperty("Class", Gxuitabspanel_tabs1_Class);
         ucGxuitabspanel_tabs1.setProperty("HistoryManagement", Gxuitabspanel_tabs1_Historymanagement);
         ucGxuitabspanel_tabs1.render(context, "tab", Gxuitabspanel_tabs1_Internalname, "GXUITABSPANEL_TABS1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABS1Container"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTabliq_title_Internalname, httpContext.getMessage( "Exportar Liquidación", ""), "", "", lblTabliq_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabLiq") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABS1Container"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panellibro.setProperty("Width", Dvpanel_panellibro_Width);
         ucDvpanel_panellibro.setProperty("AutoWidth", Dvpanel_panellibro_Autowidth);
         ucDvpanel_panellibro.setProperty("AutoHeight", Dvpanel_panellibro_Autoheight);
         ucDvpanel_panellibro.setProperty("Cls", Dvpanel_panellibro_Cls);
         ucDvpanel_panellibro.setProperty("Title", Dvpanel_panellibro_Title);
         ucDvpanel_panellibro.setProperty("Collapsible", Dvpanel_panellibro_Collapsible);
         ucDvpanel_panellibro.setProperty("Collapsed", Dvpanel_panellibro_Collapsed);
         ucDvpanel_panellibro.setProperty("ShowCollapseIcon", Dvpanel_panellibro_Showcollapseicon);
         ucDvpanel_panellibro.setProperty("IconPosition", Dvpanel_panellibro_Iconposition);
         ucDvpanel_panellibro.setProperty("AutoScroll", Dvpanel_panellibro_Autoscroll);
         ucDvpanel_panellibro.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panellibro_Internalname, "DVPANEL_PANELLIBROContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELLIBROContainer"+"PanelLibro"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPanellibro_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table4_65_2N2( true) ;
      }
      else
      {
         wb_table4_65_2N2( false) ;
      }
      return  ;
   }

   public void wb_table4_65_2N2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtngenerarliquidaciones_Internalname, "gx.evt.setGridEvt("+GXutil.str( 242, 3, 0)+","+"null"+");", httpContext.getMessage( "Generar Archivo", ""), bttBtngenerarliquidaciones_Jsonclick, 5, httpContext.getMessage( "Generar Archivo", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOGENERARLIQUIDACIONES\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABS1Container"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTabconceptos_title_Internalname, httpContext.getMessage( "Configurar conceptos", ""), "", "", lblTabconceptos_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabConceptos") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABS1Container"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelparam.setProperty("Width", Dvpanel_panelparam_Width);
         ucDvpanel_panelparam.setProperty("AutoWidth", Dvpanel_panelparam_Autowidth);
         ucDvpanel_panelparam.setProperty("AutoHeight", Dvpanel_panelparam_Autoheight);
         ucDvpanel_panelparam.setProperty("Cls", Dvpanel_panelparam_Cls);
         ucDvpanel_panelparam.setProperty("Title", Dvpanel_panelparam_Title);
         ucDvpanel_panelparam.setProperty("Collapsible", Dvpanel_panelparam_Collapsible);
         ucDvpanel_panelparam.setProperty("Collapsed", Dvpanel_panelparam_Collapsed);
         ucDvpanel_panelparam.setProperty("ShowCollapseIcon", Dvpanel_panelparam_Showcollapseicon);
         ucDvpanel_panelparam.setProperty("IconPosition", Dvpanel_panelparam_Iconposition);
         ucDvpanel_panelparam.setProperty("AutoScroll", Dvpanel_panelparam_Autoscroll);
         ucDvpanel_panelparam.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelparam_Internalname, "DVPANEL_PANELPARAMContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELPARAMContainer"+"PanelParam"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPanelparam_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelparam1.setProperty("Width", Dvpanel_panelparam1_Width);
         ucDvpanel_panelparam1.setProperty("AutoWidth", Dvpanel_panelparam1_Autowidth);
         ucDvpanel_panelparam1.setProperty("AutoHeight", Dvpanel_panelparam1_Autoheight);
         ucDvpanel_panelparam1.setProperty("Cls", Dvpanel_panelparam1_Cls);
         ucDvpanel_panelparam1.setProperty("Title", Dvpanel_panelparam1_Title);
         ucDvpanel_panelparam1.setProperty("Collapsible", Dvpanel_panelparam1_Collapsible);
         ucDvpanel_panelparam1.setProperty("Collapsed", Dvpanel_panelparam1_Collapsed);
         ucDvpanel_panelparam1.setProperty("ShowCollapseIcon", Dvpanel_panelparam1_Showcollapseicon);
         ucDvpanel_panelparam1.setProperty("IconPosition", Dvpanel_panelparam1_Iconposition);
         ucDvpanel_panelparam1.setProperty("AutoScroll", Dvpanel_panelparam1_Autoscroll);
         ucDvpanel_panelparam1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelparam1_Internalname, "DVPANEL_PANELPARAM1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELPARAM1Container"+"PanelParam1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPanelparam1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedsueldobasico_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_sueldobasico_Internalname, httpContext.getMessage( "Sueldo Básico Jornal", ""), "", "", lblTextblockcombo_sueldobasico_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_sueldobasico.setProperty("Caption", Combo_sueldobasico_Caption);
         ucCombo_sueldobasico.setProperty("Cls", Combo_sueldobasico_Cls);
         ucCombo_sueldobasico.setProperty("DropDownOptionsData", AV30SueldoBasico_Data);
         ucCombo_sueldobasico.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_sueldobasico_Internalname, "COMBO_SUELDOBASICOContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedsueldobasicomensual_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_sueldobasicomensual_Internalname, httpContext.getMessage( "Sueldo Básico Mensual", ""), "", "", lblTextblockcombo_sueldobasicomensual_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_sueldobasicomensual.setProperty("Caption", Combo_sueldobasicomensual_Caption);
         ucCombo_sueldobasicomensual.setProperty("Cls", Combo_sueldobasicomensual_Cls);
         ucCombo_sueldobasicomensual.setProperty("DropDownOptionsData", AV79SueldoBasicoMensual_Data);
         ucCombo_sueldobasicomensual.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_sueldobasicomensual_Internalname, "COMBO_SUELDOBASICOMENSUALContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedmaternidadanses_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_maternidadanses_Internalname, httpContext.getMessage( "Remuneración Maternidad ANSeS", ""), "", "", lblTextblockcombo_maternidadanses_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_maternidadanses.setProperty("Caption", Combo_maternidadanses_Caption);
         ucCombo_maternidadanses.setProperty("Cls", Combo_maternidadanses_Cls);
         ucCombo_maternidadanses.setProperty("DropDownOptionsData", AV32MaternidadAnses_Data);
         ucCombo_maternidadanses.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_maternidadanses_Internalname, "COMBO_MATERNIDADANSESContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedaporteadicos_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_aporteadicos_Internalname, httpContext.getMessage( "Aporte Adicional Obra Social", ""), "", "", lblTextblockcombo_aporteadicos_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_aporteadicos.setProperty("Caption", Combo_aporteadicos_Caption);
         ucCombo_aporteadicos.setProperty("Cls", Combo_aporteadicos_Cls);
         ucCombo_aporteadicos.setProperty("DropDownOptionsData", AV33AporteAdicOS_Data);
         ucCombo_aporteadicos.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_aporteadicos_Internalname, "COMBO_APORTEADICOSContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedcontradicos_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_contradicos_Internalname, httpContext.getMessage( "Contribución Adicional Obra Social", ""), "", "", lblTextblockcombo_contradicos_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_contradicos.setProperty("Caption", Combo_contradicos_Caption);
         ucCombo_contradicos.setProperty("Cls", Combo_contradicos_Cls);
         ucCombo_contradicos.setProperty("DropDownOptionsData", AV34ContrAdicOS_Data);
         ucCombo_contradicos.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_contradicos_Internalname, "COMBO_CONTRADICOSContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tblbasesd.setProperty("Width", Dvpanel_tblbasesd_Width);
         ucDvpanel_tblbasesd.setProperty("AutoWidth", Dvpanel_tblbasesd_Autowidth);
         ucDvpanel_tblbasesd.setProperty("AutoHeight", Dvpanel_tblbasesd_Autoheight);
         ucDvpanel_tblbasesd.setProperty("Cls", Dvpanel_tblbasesd_Cls);
         ucDvpanel_tblbasesd.setProperty("Title", Dvpanel_tblbasesd_Title);
         ucDvpanel_tblbasesd.setProperty("Collapsible", Dvpanel_tblbasesd_Collapsible);
         ucDvpanel_tblbasesd.setProperty("Collapsed", Dvpanel_tblbasesd_Collapsed);
         ucDvpanel_tblbasesd.setProperty("ShowCollapseIcon", Dvpanel_tblbasesd_Showcollapseicon);
         ucDvpanel_tblbasesd.setProperty("IconPosition", Dvpanel_tblbasesd_Iconposition);
         ucDvpanel_tblbasesd.setProperty("AutoScroll", Dvpanel_tblbasesd_Autoscroll);
         ucDvpanel_tblbasesd.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tblbasesd_Internalname, "DVPANEL_TBLBASESDContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TBLBASESDContainer"+"TblBasesD"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTblbasesd_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedbasecaldifapoos_fsr_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_basecaldifapoos_fsr_Internalname, httpContext.getMessage( "Base de cálculo diferencial Aportes OS y FSR", ""), "", "", lblTextblockcombo_basecaldifapoos_fsr_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_basecaldifapoos_fsr.setProperty("Caption", Combo_basecaldifapoos_fsr_Caption);
         ucCombo_basecaldifapoos_fsr.setProperty("Cls", Combo_basecaldifapoos_fsr_Cls);
         ucCombo_basecaldifapoos_fsr.setProperty("DropDownOptionsData", AV71BaseCalDifApoOS_FSR_Data);
         ucCombo_basecaldifapoos_fsr.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_basecaldifapoos_fsr_Internalname, "COMBO_BASECALDIFAPOOS_FSRContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedbasecaldifcontros_fsr_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_basecaldifcontros_fsr_Internalname, httpContext.getMessage( "Base de cálculo diferencial Contribución OS y FSR", ""), "", "", lblTextblockcombo_basecaldifcontros_fsr_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_basecaldifcontros_fsr.setProperty("Caption", Combo_basecaldifcontros_fsr_Caption);
         ucCombo_basecaldifcontros_fsr.setProperty("Cls", Combo_basecaldifcontros_fsr_Cls);
         ucCombo_basecaldifcontros_fsr.setProperty("DropDownOptionsData", AV72BaseCalDifContrOS_FSR_Data);
         ucCombo_basecaldifcontros_fsr.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_basecaldifcontros_fsr_Internalname, "COMBO_BASECALDIFCONTROS_FSRContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tblbases.setProperty("Width", Dvpanel_tblbases_Width);
         ucDvpanel_tblbases.setProperty("AutoWidth", Dvpanel_tblbases_Autowidth);
         ucDvpanel_tblbases.setProperty("AutoHeight", Dvpanel_tblbases_Autoheight);
         ucDvpanel_tblbases.setProperty("Cls", Dvpanel_tblbases_Cls);
         ucDvpanel_tblbases.setProperty("Title", Dvpanel_tblbases_Title);
         ucDvpanel_tblbases.setProperty("Collapsible", Dvpanel_tblbases_Collapsible);
         ucDvpanel_tblbases.setProperty("Collapsed", Dvpanel_tblbases_Collapsed);
         ucDvpanel_tblbases.setProperty("ShowCollapseIcon", Dvpanel_tblbases_Showcollapseicon);
         ucDvpanel_tblbases.setProperty("IconPosition", Dvpanel_tblbases_Iconposition);
         ucDvpanel_tblbases.setProperty("AutoScroll", Dvpanel_tblbases_Autoscroll);
         ucDvpanel_tblbases.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tblbases_Internalname, "DVPANEL_TBLBASESContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TBLBASESContainer"+"TblBases"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTblbases_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedbaseimpo1_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_baseimpo1_Internalname, httpContext.getMessage( "Base Imponible 1", ""), "", "", lblTextblockcombo_baseimpo1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_baseimpo1.setProperty("Caption", Combo_baseimpo1_Caption);
         ucCombo_baseimpo1.setProperty("Cls", Combo_baseimpo1_Cls);
         ucCombo_baseimpo1.setProperty("DropDownOptionsData", AV54BaseImpo1_Data);
         ucCombo_baseimpo1.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_baseimpo1_Internalname, "COMBO_BASEIMPO1Container");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedbaseimpo2_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_baseimpo2_Internalname, httpContext.getMessage( "Base Imponible 2", ""), "", "", lblTextblockcombo_baseimpo2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_baseimpo2.setProperty("Caption", Combo_baseimpo2_Caption);
         ucCombo_baseimpo2.setProperty("Cls", Combo_baseimpo2_Cls);
         ucCombo_baseimpo2.setProperty("DropDownOptionsData", AV55BaseImpo2_Data);
         ucCombo_baseimpo2.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_baseimpo2_Internalname, "COMBO_BASEIMPO2Container");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedbaseimpo3_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_baseimpo3_Internalname, httpContext.getMessage( "Base Imponible 3", ""), "", "", lblTextblockcombo_baseimpo3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_baseimpo3.setProperty("Caption", Combo_baseimpo3_Caption);
         ucCombo_baseimpo3.setProperty("Cls", Combo_baseimpo3_Cls);
         ucCombo_baseimpo3.setProperty("DropDownOptionsData", AV56BaseImpo3_Data);
         ucCombo_baseimpo3.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_baseimpo3_Internalname, "COMBO_BASEIMPO3Container");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedbaseimpo4_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_baseimpo4_Internalname, httpContext.getMessage( "Base Imponible 4", ""), "", "", lblTextblockcombo_baseimpo4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_baseimpo4.setProperty("Caption", Combo_baseimpo4_Caption);
         ucCombo_baseimpo4.setProperty("Cls", Combo_baseimpo4_Cls);
         ucCombo_baseimpo4.setProperty("DropDownOptionsData", AV57BaseImpo4_Data);
         ucCombo_baseimpo4.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_baseimpo4_Internalname, "COMBO_BASEIMPO4Container");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedbaseimpo5_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_baseimpo5_Internalname, httpContext.getMessage( "Base Imponible 5", ""), "", "", lblTextblockcombo_baseimpo5_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_baseimpo5.setProperty("Caption", Combo_baseimpo5_Caption);
         ucCombo_baseimpo5.setProperty("Cls", Combo_baseimpo5_Cls);
         ucCombo_baseimpo5.setProperty("DropDownOptionsData", AV58BaseImpo5_Data);
         ucCombo_baseimpo5.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_baseimpo5_Internalname, "COMBO_BASEIMPO5Container");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedbaseimpo6_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_baseimpo6_Internalname, httpContext.getMessage( "Base Imponible 6", ""), "", "", lblTextblockcombo_baseimpo6_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_baseimpo6.setProperty("Caption", Combo_baseimpo6_Caption);
         ucCombo_baseimpo6.setProperty("Cls", Combo_baseimpo6_Cls);
         ucCombo_baseimpo6.setProperty("DropDownOptionsData", AV59BaseImpo6_Data);
         ucCombo_baseimpo6.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_baseimpo6_Internalname, "COMBO_BASEIMPO6Container");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedbaseimpo7_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_baseimpo7_Internalname, httpContext.getMessage( "Base Imponible 7", ""), "", "", lblTextblockcombo_baseimpo7_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_baseimpo7.setProperty("Caption", Combo_baseimpo7_Caption);
         ucCombo_baseimpo7.setProperty("Cls", Combo_baseimpo7_Cls);
         ucCombo_baseimpo7.setProperty("DropDownOptionsData", AV60BaseImpo7_Data);
         ucCombo_baseimpo7.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_baseimpo7_Internalname, "COMBO_BASEIMPO7Container");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedbaseimpo8_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_baseimpo8_Internalname, httpContext.getMessage( "Base Imponible 8", ""), "", "", lblTextblockcombo_baseimpo8_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_baseimpo8.setProperty("Caption", Combo_baseimpo8_Caption);
         ucCombo_baseimpo8.setProperty("Cls", Combo_baseimpo8_Cls);
         ucCombo_baseimpo8.setProperty("DropDownOptionsData", AV61BaseImpo8_Data);
         ucCombo_baseimpo8.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_baseimpo8_Internalname, "COMBO_BASEIMPO8Container");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedbaseimpo9_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_baseimpo9_Internalname, httpContext.getMessage( "Base Imponible 9", ""), "", "", lblTextblockcombo_baseimpo9_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_baseimpo9.setProperty("Caption", Combo_baseimpo9_Caption);
         ucCombo_baseimpo9.setProperty("Cls", Combo_baseimpo9_Cls);
         ucCombo_baseimpo9.setProperty("DropDownOptionsData", AV62BaseImpo9_Data);
         ucCombo_baseimpo9.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_baseimpo9_Internalname, "COMBO_BASEIMPO9Container");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedbaseimpo10_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_baseimpo10_Internalname, httpContext.getMessage( "Base Imponible 10", ""), "", "", lblTextblockcombo_baseimpo10_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_baseimpo10.setProperty("Caption", Combo_baseimpo10_Caption);
         ucCombo_baseimpo10.setProperty("Cls", Combo_baseimpo10_Cls);
         ucCombo_baseimpo10.setProperty("DropDownOptionsData", AV63BaseImpo10_Data);
         ucCombo_baseimpo10.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_baseimpo10_Internalname, "COMBO_BASEIMPO10Container");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDvpanel_panelconcafip_cell_Internalname, 1, 0, "px", 0, "px", divDvpanel_panelconcafip_cell_Class, "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelconcafip.setProperty("Width", Dvpanel_panelconcafip_Width);
         ucDvpanel_panelconcafip.setProperty("AutoWidth", Dvpanel_panelconcafip_Autowidth);
         ucDvpanel_panelconcafip.setProperty("AutoHeight", Dvpanel_panelconcafip_Autoheight);
         ucDvpanel_panelconcafip.setProperty("Cls", Dvpanel_panelconcafip_Cls);
         ucDvpanel_panelconcafip.setProperty("Title", Dvpanel_panelconcafip_Title);
         ucDvpanel_panelconcafip.setProperty("Collapsible", Dvpanel_panelconcafip_Collapsible);
         ucDvpanel_panelconcafip.setProperty("Collapsed", Dvpanel_panelconcafip_Collapsed);
         ucDvpanel_panelconcafip.setProperty("ShowCollapseIcon", Dvpanel_panelconcafip_Showcollapseicon);
         ucDvpanel_panelconcafip.setProperty("IconPosition", Dvpanel_panelconcafip_Iconposition);
         ucDvpanel_panelconcafip.setProperty("AutoScroll", Dvpanel_panelconcafip_Autoscroll);
         ucDvpanel_panelconcafip.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelconcafip_Internalname, "DVPANEL_PANELCONCAFIPContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELCONCAFIPContainer"+"PanelConcAfip"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPanelconcafip_Internalname, 1, 0, "px", 0, "px", "CellPaddingTop10", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         Grid1Container.SetWrapped(nGXWrapped);
         startgridcontrol242( ) ;
      }
      if ( wbEnd == 242 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_242 = (int)(nGXsfl_242_idx-1) ;
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
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 248,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncomenzarasistente_Internalname, "gx.evt.setGridEvt("+GXutil.str( 242, 3, 0)+","+"null"+");", httpContext.getMessage( "Comenzar asistente para generación de Archivo", ""), bttBtncomenzarasistente_Jsonclick, 5, httpContext.getMessage( "Comenzar asistente para generación de Archivo", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCOMENZARASISTENTE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABS1Container"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTabexportar_title_Internalname, httpContext.getMessage( "Exportar conceptos", ""), "", "", lblTabexportar_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabExportar") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABS1Container"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 256,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtngenerararchivo_Internalname, "gx.evt.setGridEvt("+GXutil.str( 242, 3, 0)+","+"null"+");", httpContext.getMessage( "Generar archivos de equivalencias con conceptos de AFIP", ""), bttBtngenerararchivo_Jsonclick, 5, httpContext.getMessage( "Generar archivos de equivalencias con conceptos de AFIP", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOGENERARARCHIVO\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LibroSueldosDigital.htm");
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
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_46_2N2e( true) ;
      }
      else
      {
         wb_table3_46_2N2e( false) ;
      }
   }

   public void wb_table4_65_2N2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable4_Internalname, tblUnnamedtable4_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavAnioperiodo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavAnioperiodo_Internalname, httpContext.getMessage( "Periodo", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavAnioperiodo_Internalname, GXutil.ltrim( localUtil.ntoc( AV5AnioPeriodo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavAnioperiodo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV5AnioPeriodo), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV5AnioPeriodo), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,70);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "AAAA", ""), edtavAnioperiodo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavAnioperiodo_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavMesperiodo.getInternalname(), httpContext.getMessage( "Mes Periodo", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'" + sGXsfl_242_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavMesperiodo, cmbavMesperiodo.getInternalname(), GXutil.trim( GXutil.str( AV14MesPeriodo, 2, 0)), 1, cmbavMesperiodo.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVMESPERIODO.CLICK."+"'", "int", "", 1, cmbavMesperiodo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,73);\"", "", true, (byte)(0), "HLP_LibroSueldosDigital.htm");
         cmbavMesperiodo.setValue( GXutil.trim( GXutil.str( AV14MesPeriodo, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMesperiodo.getInternalname(), "Values", cmbavMesperiodo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='ExtendedComboCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegnumero_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_legnumero_Internalname, httpContext.getMessage( "Legajo", ""), "", "", lblTextblockcombo_legnumero_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_legnumero.setProperty("Caption", Combo_legnumero_Caption);
         ucCombo_legnumero.setProperty("Cls", Combo_legnumero_Cls);
         ucCombo_legnumero.setProperty("EmptyItemText", Combo_legnumero_Emptyitemtext);
         ucCombo_legnumero.setProperty("DropDownOptionsData", AV77LegNumero_Data);
         ucCombo_legnumero.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legnumero_Internalname, "COMBO_LEGNUMEROContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_65_2N2e( true) ;
      }
      else
      {
         wb_table4_65_2N2e( false) ;
      }
   }

   public void wb_table2_29_2N2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_29_2N2e( true) ;
      }
      else
      {
         wb_table2_29_2N2e( false) ;
      }
   }

   public void wb_table1_24_2N2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_LibroSueldosDigital.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_24_2N2e( true) ;
      }
      else
      {
         wb_table1_24_2N2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV81MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81MenuOpcCod", AV81MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV81MenuOpcCod, ""))));
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
      pa2N2( ) ;
      ws2N2( ) ;
      we2N2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713502454", true, true);
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
         httpContext.AddJavascriptSource("librosueldosdigital.js", "?20251713502455", false, true);
         httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
         httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
         httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
         httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
         httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_2422( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_242_idx ;
      edtConAfipDesc_Internalname = "CONAFIPDESC_"+sGXsfl_242_idx ;
      edtConCodPropio_Internalname = "CONCODPROPIO_"+sGXsfl_242_idx ;
      edtConAFIPConcepto_Internalname = "CONAFIPCONCEPTO_"+sGXsfl_242_idx ;
   }

   public void subsflControlProps_fel_2422( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_242_fel_idx ;
      edtConAfipDesc_Internalname = "CONAFIPDESC_"+sGXsfl_242_fel_idx ;
      edtConCodPropio_Internalname = "CONCODPROPIO_"+sGXsfl_242_fel_idx ;
      edtConAFIPConcepto_Internalname = "CONAFIPCONCEPTO_"+sGXsfl_242_fel_idx ;
   }

   public void sendrow_2422( )
   {
      subsflControlProps_2422( ) ;
      wb2N0( ) ;
      if ( ( subGrid1_Rows * 1 == 0 ) || ( nGXsfl_242_idx <= subgrid1_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_242_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_242_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(242),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConAfipDesc_Internalname,A383ConAfipDesc,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConAfipDesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(242),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConCodPropio_Internalname,GXutil.rtrim( A73ConCodPropio),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConCodPropio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(242),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConAFIPConcepto_Internalname,GXutil.rtrim( A386ConAFIPConcepto),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConAFIPConcepto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(242),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes2N2( ) ;
         Grid1Container.AddRow(Grid1Row);
         nGXsfl_242_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_242_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_242_idx+1) ;
         sGXsfl_242_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_242_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2422( ) ;
      }
      /* End function sendrow_2422 */
   }

   public void startgridcontrol242( )
   {
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Grid1Container"+"DivS\" data-gxgridid=\"242\">") ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cli Cod", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto propio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código AFIP", "")) ;
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
         Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", A383ConAfipDesc);
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", GXutil.rtrim( A73ConCodPropio));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", GXutil.rtrim( A386ConAFIPConcepto));
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
      lblWelcomemessage_closehelp_Internalname = "WELCOMEMESSAGE_CLOSEHELP" ;
      divWelcomemessage_tableclose_Internalname = "WELCOMEMESSAGE_TABLECLOSE" ;
      divWelcomemessage_welcometableprincipal_Internalname = "WELCOMEMESSAGE_WELCOMETABLEPRINCIPAL" ;
      imgavWelcomemessage_foto_Internalname = "vWELCOMEMESSAGE_FOTO" ;
      divWelcomemessage_welcometableimagen_Internalname = "WELCOMEMESSAGE_WELCOMETABLEIMAGEN" ;
      lblWelcomemessage_titulo_Internalname = "WELCOMEMESSAGE_TITULO" ;
      tblWelcomemessage_tabletitulo_Internalname = "WELCOMEMESSAGE_TABLETITULO" ;
      lblWelcomemessage_descripcion_Internalname = "WELCOMEMESSAGE_DESCRIPCION" ;
      tblWelcomemessage_tabledescripcion_Internalname = "WELCOMEMESSAGE_TABLEDESCRIPCION" ;
      divWelcomemessage_tabletexto_Internalname = "WELCOMEMESSAGE_TABLETEXTO" ;
      divWelcomemessage_welcomecontentflex_Internalname = "WELCOMEMESSAGE_WELCOMECONTENTFLEX" ;
      divWelcomemessage_welcomecontentitem_Internalname = "WELCOMEMESSAGE_WELCOMECONTENTITEM" ;
      chkavWelcomemessage_nomostrarmas.setInternalname( "vWELCOMEMESSAGE_NOMOSTRARMAS" );
      divWelcomemessage_tablec_Internalname = "WELCOMEMESSAGE_TABLEC" ;
      lblWelcomemessage_combotext_Internalname = "WELCOMEMESSAGE_COMBOTEXT" ;
      divWelcomemessage_tabletext_Internalname = "WELCOMEMESSAGE_TABLETEXT" ;
      divWelcomemessage_tablecmb_Internalname = "WELCOMEMESSAGE_TABLECMB" ;
      divWelcomemessage_welcomebottomitem_Internalname = "WELCOMEMESSAGE_WELCOMEBOTTOMITEM" ;
      divWelcomemessage_welcometableparent_Internalname = "WELCOMEMESSAGE_WELCOMETABLEPARENT" ;
      lblTabliq_title_Internalname = "TABLIQ_TITLE" ;
      edtavAnioperiodo_Internalname = "vANIOPERIODO" ;
      cmbavMesperiodo.setInternalname( "vMESPERIODO" );
      lblTextblockcombo_legnumero_Internalname = "TEXTBLOCKCOMBO_LEGNUMERO" ;
      Combo_legnumero_Internalname = "COMBO_LEGNUMERO" ;
      divTablesplittedlegnumero_Internalname = "TABLESPLITTEDLEGNUMERO" ;
      tblUnnamedtable4_Internalname = "UNNAMEDTABLE4" ;
      bttBtngenerarliquidaciones_Internalname = "BTNGENERARLIQUIDACIONES" ;
      divPanellibro_Internalname = "PANELLIBRO" ;
      Dvpanel_panellibro_Internalname = "DVPANEL_PANELLIBRO" ;
      divUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      lblTabconceptos_title_Internalname = "TABCONCEPTOS_TITLE" ;
      lblTextblockcombo_sueldobasico_Internalname = "TEXTBLOCKCOMBO_SUELDOBASICO" ;
      Combo_sueldobasico_Internalname = "COMBO_SUELDOBASICO" ;
      divTablesplittedsueldobasico_Internalname = "TABLESPLITTEDSUELDOBASICO" ;
      lblTextblockcombo_sueldobasicomensual_Internalname = "TEXTBLOCKCOMBO_SUELDOBASICOMENSUAL" ;
      Combo_sueldobasicomensual_Internalname = "COMBO_SUELDOBASICOMENSUAL" ;
      divTablesplittedsueldobasicomensual_Internalname = "TABLESPLITTEDSUELDOBASICOMENSUAL" ;
      lblTextblockcombo_maternidadanses_Internalname = "TEXTBLOCKCOMBO_MATERNIDADANSES" ;
      Combo_maternidadanses_Internalname = "COMBO_MATERNIDADANSES" ;
      divTablesplittedmaternidadanses_Internalname = "TABLESPLITTEDMATERNIDADANSES" ;
      lblTextblockcombo_aporteadicos_Internalname = "TEXTBLOCKCOMBO_APORTEADICOS" ;
      Combo_aporteadicos_Internalname = "COMBO_APORTEADICOS" ;
      divTablesplittedaporteadicos_Internalname = "TABLESPLITTEDAPORTEADICOS" ;
      lblTextblockcombo_contradicos_Internalname = "TEXTBLOCKCOMBO_CONTRADICOS" ;
      Combo_contradicos_Internalname = "COMBO_CONTRADICOS" ;
      divTablesplittedcontradicos_Internalname = "TABLESPLITTEDCONTRADICOS" ;
      divPanelparam1_Internalname = "PANELPARAM1" ;
      Dvpanel_panelparam1_Internalname = "DVPANEL_PANELPARAM1" ;
      lblTextblockcombo_basecaldifapoos_fsr_Internalname = "TEXTBLOCKCOMBO_BASECALDIFAPOOS_FSR" ;
      Combo_basecaldifapoos_fsr_Internalname = "COMBO_BASECALDIFAPOOS_FSR" ;
      divTablesplittedbasecaldifapoos_fsr_Internalname = "TABLESPLITTEDBASECALDIFAPOOS_FSR" ;
      lblTextblockcombo_basecaldifcontros_fsr_Internalname = "TEXTBLOCKCOMBO_BASECALDIFCONTROS_FSR" ;
      Combo_basecaldifcontros_fsr_Internalname = "COMBO_BASECALDIFCONTROS_FSR" ;
      divTablesplittedbasecaldifcontros_fsr_Internalname = "TABLESPLITTEDBASECALDIFCONTROS_FSR" ;
      divTblbasesd_Internalname = "TBLBASESD" ;
      Dvpanel_tblbasesd_Internalname = "DVPANEL_TBLBASESD" ;
      lblTextblockcombo_baseimpo1_Internalname = "TEXTBLOCKCOMBO_BASEIMPO1" ;
      Combo_baseimpo1_Internalname = "COMBO_BASEIMPO1" ;
      divTablesplittedbaseimpo1_Internalname = "TABLESPLITTEDBASEIMPO1" ;
      lblTextblockcombo_baseimpo2_Internalname = "TEXTBLOCKCOMBO_BASEIMPO2" ;
      Combo_baseimpo2_Internalname = "COMBO_BASEIMPO2" ;
      divTablesplittedbaseimpo2_Internalname = "TABLESPLITTEDBASEIMPO2" ;
      lblTextblockcombo_baseimpo3_Internalname = "TEXTBLOCKCOMBO_BASEIMPO3" ;
      Combo_baseimpo3_Internalname = "COMBO_BASEIMPO3" ;
      divTablesplittedbaseimpo3_Internalname = "TABLESPLITTEDBASEIMPO3" ;
      lblTextblockcombo_baseimpo4_Internalname = "TEXTBLOCKCOMBO_BASEIMPO4" ;
      Combo_baseimpo4_Internalname = "COMBO_BASEIMPO4" ;
      divTablesplittedbaseimpo4_Internalname = "TABLESPLITTEDBASEIMPO4" ;
      lblTextblockcombo_baseimpo5_Internalname = "TEXTBLOCKCOMBO_BASEIMPO5" ;
      Combo_baseimpo5_Internalname = "COMBO_BASEIMPO5" ;
      divTablesplittedbaseimpo5_Internalname = "TABLESPLITTEDBASEIMPO5" ;
      lblTextblockcombo_baseimpo6_Internalname = "TEXTBLOCKCOMBO_BASEIMPO6" ;
      Combo_baseimpo6_Internalname = "COMBO_BASEIMPO6" ;
      divTablesplittedbaseimpo6_Internalname = "TABLESPLITTEDBASEIMPO6" ;
      lblTextblockcombo_baseimpo7_Internalname = "TEXTBLOCKCOMBO_BASEIMPO7" ;
      Combo_baseimpo7_Internalname = "COMBO_BASEIMPO7" ;
      divTablesplittedbaseimpo7_Internalname = "TABLESPLITTEDBASEIMPO7" ;
      lblTextblockcombo_baseimpo8_Internalname = "TEXTBLOCKCOMBO_BASEIMPO8" ;
      Combo_baseimpo8_Internalname = "COMBO_BASEIMPO8" ;
      divTablesplittedbaseimpo8_Internalname = "TABLESPLITTEDBASEIMPO8" ;
      lblTextblockcombo_baseimpo9_Internalname = "TEXTBLOCKCOMBO_BASEIMPO9" ;
      Combo_baseimpo9_Internalname = "COMBO_BASEIMPO9" ;
      divTablesplittedbaseimpo9_Internalname = "TABLESPLITTEDBASEIMPO9" ;
      lblTextblockcombo_baseimpo10_Internalname = "TEXTBLOCKCOMBO_BASEIMPO10" ;
      Combo_baseimpo10_Internalname = "COMBO_BASEIMPO10" ;
      divTablesplittedbaseimpo10_Internalname = "TABLESPLITTEDBASEIMPO10" ;
      divTblbases_Internalname = "TBLBASES" ;
      Dvpanel_tblbases_Internalname = "DVPANEL_TBLBASES" ;
      divPanelparam_Internalname = "PANELPARAM" ;
      Dvpanel_panelparam_Internalname = "DVPANEL_PANELPARAM" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtConAfipDesc_Internalname = "CONAFIPDESC" ;
      edtConCodPropio_Internalname = "CONCODPROPIO" ;
      edtConAFIPConcepto_Internalname = "CONAFIPCONCEPTO" ;
      bttBtncomenzarasistente_Internalname = "BTNCOMENZARASISTENTE" ;
      divPanelconcafip_Internalname = "PANELCONCAFIP" ;
      Dvpanel_panelconcafip_Internalname = "DVPANEL_PANELCONCAFIP" ;
      divDvpanel_panelconcafip_cell_Internalname = "DVPANEL_PANELCONCAFIP_CELL" ;
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      lblTabexportar_title_Internalname = "TABEXPORTAR_TITLE" ;
      bttBtngenerararchivo_Internalname = "BTNGENERARARCHIVO" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Gxuitabspanel_tabs1_Internalname = "GXUITABSPANEL_TABS1" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavLegnumero_Internalname = "vLEGNUMERO" ;
      edtavSueldobasico_Internalname = "vSUELDOBASICO" ;
      edtavSueldobasicomensual_Internalname = "vSUELDOBASICOMENSUAL" ;
      edtavMaternidadanses_Internalname = "vMATERNIDADANSES" ;
      edtavAporteadicos_Internalname = "vAPORTEADICOS" ;
      edtavContradicos_Internalname = "vCONTRADICOS" ;
      edtavBasecaldifapoos_fsr_Internalname = "vBASECALDIFAPOOS_FSR" ;
      edtavBasecaldifcontros_fsr_Internalname = "vBASECALDIFCONTROS_FSR" ;
      edtavBaseimpo1_Internalname = "vBASEIMPO1" ;
      edtavBaseimpo2_Internalname = "vBASEIMPO2" ;
      edtavBaseimpo3_Internalname = "vBASEIMPO3" ;
      edtavBaseimpo4_Internalname = "vBASEIMPO4" ;
      edtavBaseimpo5_Internalname = "vBASEIMPO5" ;
      edtavBaseimpo6_Internalname = "vBASEIMPO6" ;
      edtavBaseimpo7_Internalname = "vBASEIMPO7" ;
      edtavBaseimpo8_Internalname = "vBASEIMPO8" ;
      edtavBaseimpo9_Internalname = "vBASEIMPO9" ;
      edtavBaseimpo10_Internalname = "vBASEIMPO10" ;
      edtavLiqnro_Internalname = "vLIQNRO" ;
      cmbavTipoenvio.setInternalname( "vTIPOENVIO" );
      edtavFecharubrica_Internalname = "vFECHARUBRICA" ;
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
      edtConAFIPConcepto_Jsonclick = "" ;
      edtConCodPropio_Jsonclick = "" ;
      edtConAfipDesc_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      subGrid1_Class = "WorkWith" ;
      subGrid1_Backcolorstyle = (byte)(0) ;
      cmbavMesperiodo.setJsonclick( "" );
      cmbavMesperiodo.setEnabled( 1 );
      edtavAnioperiodo_Jsonclick = "" ;
      edtavAnioperiodo_Enabled = 1 ;
      divDvpanel_panelconcafip_cell_Class = "col-xs-12" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      edtavFecharubrica_Jsonclick = "" ;
      edtavFecharubrica_Visible = 1 ;
      cmbavTipoenvio.setJsonclick( "" );
      cmbavTipoenvio.setVisible( 1 );
      edtavLiqnro_Jsonclick = "" ;
      edtavLiqnro_Visible = 1 ;
      edtavBaseimpo10_Jsonclick = "" ;
      edtavBaseimpo10_Visible = 1 ;
      edtavBaseimpo9_Jsonclick = "" ;
      edtavBaseimpo9_Visible = 1 ;
      edtavBaseimpo8_Jsonclick = "" ;
      edtavBaseimpo8_Visible = 1 ;
      edtavBaseimpo7_Jsonclick = "" ;
      edtavBaseimpo7_Visible = 1 ;
      edtavBaseimpo6_Jsonclick = "" ;
      edtavBaseimpo6_Visible = 1 ;
      edtavBaseimpo5_Jsonclick = "" ;
      edtavBaseimpo5_Visible = 1 ;
      edtavBaseimpo4_Jsonclick = "" ;
      edtavBaseimpo4_Visible = 1 ;
      edtavBaseimpo3_Jsonclick = "" ;
      edtavBaseimpo3_Visible = 1 ;
      edtavBaseimpo2_Jsonclick = "" ;
      edtavBaseimpo2_Visible = 1 ;
      edtavBaseimpo1_Jsonclick = "" ;
      edtavBaseimpo1_Visible = 1 ;
      edtavBasecaldifcontros_fsr_Jsonclick = "" ;
      edtavBasecaldifcontros_fsr_Visible = 1 ;
      edtavBasecaldifapoos_fsr_Jsonclick = "" ;
      edtavBasecaldifapoos_fsr_Visible = 1 ;
      edtavContradicos_Jsonclick = "" ;
      edtavContradicos_Visible = 1 ;
      edtavAporteadicos_Jsonclick = "" ;
      edtavAporteadicos_Visible = 1 ;
      edtavMaternidadanses_Jsonclick = "" ;
      edtavMaternidadanses_Visible = 1 ;
      edtavSueldobasicomensual_Jsonclick = "" ;
      edtavSueldobasicomensual_Visible = 1 ;
      edtavSueldobasico_Jsonclick = "" ;
      edtavSueldobasico_Visible = 1 ;
      edtavLegnumero_Jsonclick = "" ;
      edtavLegnumero_Visible = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      Gxuitabspanel_tabs1_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_tabs1_Class = "" ;
      Gxuitabspanel_tabs1_Pagecount = 3 ;
      Dvpanel_panelconcafip_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelconcafip_Iconposition = "Right" ;
      Dvpanel_panelconcafip_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelconcafip_Collapsed = GXutil.toBoolean( 1) ;
      Dvpanel_panelconcafip_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelconcafip_Title = httpContext.getMessage( "Configuración de equivalencias AFIP", "") ;
      Dvpanel_panelconcafip_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelconcafip_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelconcafip_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelconcafip_Width = "100%" ;
      Dvpanel_panelparam_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelparam_Iconposition = "Right" ;
      Dvpanel_panelparam_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelparam_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelparam_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelparam_Title = httpContext.getMessage( "Configuración de conceptos predeterminados  para Libro de Sueldos Digital", "") ;
      Dvpanel_panelparam_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelparam_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelparam_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelparam_Width = "100%" ;
      Dvpanel_tblbases_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tblbases_Iconposition = "Right" ;
      Dvpanel_tblbases_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tblbases_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tblbases_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_tblbases_Title = httpContext.getMessage( "Bases Imponibles", "") ;
      Dvpanel_tblbases_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tblbases_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tblbases_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tblbases_Width = "100%" ;
      Combo_baseimpo10_Cls = "ExtendedCombo Attribute" ;
      Combo_baseimpo9_Cls = "ExtendedCombo Attribute" ;
      Combo_baseimpo8_Cls = "ExtendedCombo Attribute" ;
      Combo_baseimpo7_Cls = "ExtendedCombo Attribute" ;
      Combo_baseimpo6_Cls = "ExtendedCombo Attribute" ;
      Combo_baseimpo5_Cls = "ExtendedCombo Attribute" ;
      Combo_baseimpo4_Cls = "ExtendedCombo Attribute" ;
      Combo_baseimpo3_Cls = "ExtendedCombo Attribute" ;
      Combo_baseimpo2_Cls = "ExtendedCombo Attribute" ;
      Combo_baseimpo1_Cls = "ExtendedCombo Attribute" ;
      Dvpanel_tblbasesd_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tblbasesd_Iconposition = "Right" ;
      Dvpanel_tblbasesd_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tblbasesd_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tblbasesd_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_tblbasesd_Title = httpContext.getMessage( "Bases de cálculo diferencial", "") ;
      Dvpanel_tblbasesd_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tblbasesd_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tblbasesd_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tblbasesd_Width = "100%" ;
      Combo_basecaldifcontros_fsr_Cls = "ExtendedCombo Attribute" ;
      Combo_basecaldifapoos_fsr_Cls = "ExtendedCombo Attribute" ;
      Dvpanel_panelparam1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelparam1_Iconposition = "Right" ;
      Dvpanel_panelparam1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelparam1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelparam1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelparam1_Title = httpContext.getMessage( "Conceptos Varios", "") ;
      Dvpanel_panelparam1_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelparam1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelparam1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelparam1_Width = "100%" ;
      Combo_contradicos_Cls = "ExtendedCombo Attribute" ;
      Combo_aporteadicos_Cls = "ExtendedCombo Attribute" ;
      Combo_maternidadanses_Cls = "ExtendedCombo Attribute" ;
      Combo_sueldobasicomensual_Cls = "ExtendedCombo Attribute" ;
      Combo_sueldobasico_Cls = "ExtendedCombo Attribute" ;
      Dvpanel_panellibro_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panellibro_Iconposition = "Right" ;
      Dvpanel_panellibro_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panellibro_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panellibro_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_panellibro_Title = httpContext.getMessage( "Libro de Sueldos Digital", "") ;
      Dvpanel_panellibro_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panellibro_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panellibro_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panellibro_Width = "100%" ;
      Combo_legnumero_Emptyitemtext = "Todos" ;
      Combo_legnumero_Cls = "ExtendedCombo Attribute" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Libro de Sueldos Digital", "") );
      subGrid1_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      chkavWelcomemessage_nomostrarmas.setName( "vWELCOMEMESSAGE_NOMOSTRARMAS" );
      chkavWelcomemessage_nomostrarmas.setWebtags( "" );
      chkavWelcomemessage_nomostrarmas.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavWelcomemessage_nomostrarmas.getInternalname(), "TitleCaption", chkavWelcomemessage_nomostrarmas.getCaption(), true);
      chkavWelcomemessage_nomostrarmas.setCheckedValue( "false" );
      AV88WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV88WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV88WelcomeMessage_NoMostrarMas", AV88WelcomeMessage_NoMostrarMas);
      cmbavMesperiodo.setName( "vMESPERIODO" );
      cmbavMesperiodo.setWebtags( "" );
      cmbavMesperiodo.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbavMesperiodo.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbavMesperiodo.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbavMesperiodo.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbavMesperiodo.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbavMesperiodo.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbavMesperiodo.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbavMesperiodo.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbavMesperiodo.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbavMesperiodo.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbavMesperiodo.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbavMesperiodo.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbavMesperiodo.getItemCount() > 0 )
      {
         AV14MesPeriodo = (byte)(GXutil.lval( cmbavMesperiodo.getValidValue(GXutil.trim( GXutil.str( AV14MesPeriodo, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14MesPeriodo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14MesPeriodo), 2, 0));
      }
      cmbavTipoenvio.setName( "vTIPOENVIO" );
      cmbavTipoenvio.setWebtags( "" );
      cmbavTipoenvio.addItem("SJ", httpContext.getMessage( "Informa la liquidación de SyJ y datos de la DJ F931", ""), (short)(0));
      cmbavTipoenvio.addItem("RE", httpContext.getMessage( "Sólo informa datos de la DJ F931 a rectificar", ""), (short)(0));
      if ( cmbavTipoenvio.getItemCount() > 0 )
      {
         AV16TipoEnvio = cmbavTipoenvio.getValidValue(AV16TipoEnvio) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16TipoEnvio", AV16TipoEnvio);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV88WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV20liqNumero',fld:'vLIQNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV81MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("GRID1.LOAD","{handler:'e362N2',iparms:[]");
      setEventMetadata("GRID1.LOAD",",oparms:[]}");
      setEventMetadata("'DOGENERARARCHIVO'","{handler:'e292N2',iparms:[]");
      setEventMetadata("'DOGENERARARCHIVO'",",oparms:[]}");
      setEventMetadata("'DOCOMENZARASISTENTE'","{handler:'e302N2',iparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("'DOCOMENZARASISTENTE'",",oparms:[]}");
      setEventMetadata("'DOGENERARLIQUIDACIONES'","{handler:'e312N2',iparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV19LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'AV20liqNumero',fld:'vLIQNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV76LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'cmbavTipoenvio'},{av:'AV16TipoEnvio',fld:'vTIPOENVIO',pic:''}]");
      setEventMetadata("'DOGENERARLIQUIDACIONES'",",oparms:[]}");
      setEventMetadata("COMBO_BASEIMPO10.ONOPTIONCLICKED","{handler:'e282N2',iparms:[{av:'Combo_baseimpo10_Selectedvalue_get',ctrl:'COMBO_BASEIMPO10',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_BASEIMPO10.ONOPTIONCLICKED",",oparms:[{av:'AV53BaseImpo10',fld:'vBASEIMPO10',pic:''}]}");
      setEventMetadata("COMBO_BASEIMPO9.ONOPTIONCLICKED","{handler:'e272N2',iparms:[{av:'Combo_baseimpo9_Selectedvalue_get',ctrl:'COMBO_BASEIMPO9',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_BASEIMPO9.ONOPTIONCLICKED",",oparms:[{av:'AV52BaseImpo9',fld:'vBASEIMPO9',pic:''}]}");
      setEventMetadata("COMBO_BASEIMPO8.ONOPTIONCLICKED","{handler:'e262N2',iparms:[{av:'Combo_baseimpo8_Selectedvalue_get',ctrl:'COMBO_BASEIMPO8',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_BASEIMPO8.ONOPTIONCLICKED",",oparms:[{av:'AV51BaseImpo8',fld:'vBASEIMPO8',pic:''}]}");
      setEventMetadata("COMBO_BASEIMPO7.ONOPTIONCLICKED","{handler:'e252N2',iparms:[{av:'Combo_baseimpo7_Selectedvalue_get',ctrl:'COMBO_BASEIMPO7',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_BASEIMPO7.ONOPTIONCLICKED",",oparms:[{av:'AV50BaseImpo7',fld:'vBASEIMPO7',pic:''}]}");
      setEventMetadata("COMBO_BASEIMPO6.ONOPTIONCLICKED","{handler:'e242N2',iparms:[{av:'Combo_baseimpo6_Selectedvalue_get',ctrl:'COMBO_BASEIMPO6',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_BASEIMPO6.ONOPTIONCLICKED",",oparms:[{av:'AV49BaseImpo6',fld:'vBASEIMPO6',pic:''}]}");
      setEventMetadata("COMBO_BASEIMPO5.ONOPTIONCLICKED","{handler:'e232N2',iparms:[{av:'Combo_baseimpo5_Selectedvalue_get',ctrl:'COMBO_BASEIMPO5',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_BASEIMPO5.ONOPTIONCLICKED",",oparms:[{av:'AV48BaseImpo5',fld:'vBASEIMPO5',pic:''}]}");
      setEventMetadata("COMBO_BASEIMPO4.ONOPTIONCLICKED","{handler:'e222N2',iparms:[{av:'Combo_baseimpo4_Selectedvalue_get',ctrl:'COMBO_BASEIMPO4',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_BASEIMPO4.ONOPTIONCLICKED",",oparms:[{av:'AV47BaseImpo4',fld:'vBASEIMPO4',pic:''}]}");
      setEventMetadata("COMBO_BASEIMPO3.ONOPTIONCLICKED","{handler:'e212N2',iparms:[{av:'Combo_baseimpo3_Selectedvalue_get',ctrl:'COMBO_BASEIMPO3',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_BASEIMPO3.ONOPTIONCLICKED",",oparms:[{av:'AV46BaseImpo3',fld:'vBASEIMPO3',pic:''}]}");
      setEventMetadata("COMBO_BASEIMPO2.ONOPTIONCLICKED","{handler:'e202N2',iparms:[{av:'Combo_baseimpo2_Selectedvalue_get',ctrl:'COMBO_BASEIMPO2',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_BASEIMPO2.ONOPTIONCLICKED",",oparms:[{av:'AV45BaseImpo2',fld:'vBASEIMPO2',pic:''}]}");
      setEventMetadata("COMBO_BASEIMPO1.ONOPTIONCLICKED","{handler:'e192N2',iparms:[{av:'Combo_baseimpo1_Selectedvalue_get',ctrl:'COMBO_BASEIMPO1',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_BASEIMPO1.ONOPTIONCLICKED",",oparms:[{av:'AV44BaseImpo1',fld:'vBASEIMPO1',pic:''}]}");
      setEventMetadata("COMBO_BASECALDIFCONTROS_FSR.ONOPTIONCLICKED","{handler:'e182N2',iparms:[{av:'Combo_basecaldifcontros_fsr_Selectedvalue_get',ctrl:'COMBO_BASECALDIFCONTROS_FSR',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_BASECALDIFCONTROS_FSR.ONOPTIONCLICKED",",oparms:[{av:'AV66BaseCalDifContrOS_FSR',fld:'vBASECALDIFCONTROS_FSR',pic:''}]}");
      setEventMetadata("COMBO_BASECALDIFAPOOS_FSR.ONOPTIONCLICKED","{handler:'e172N2',iparms:[{av:'Combo_basecaldifapoos_fsr_Selectedvalue_get',ctrl:'COMBO_BASECALDIFAPOOS_FSR',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_BASECALDIFAPOOS_FSR.ONOPTIONCLICKED",",oparms:[{av:'AV65BaseCalDifApoOS_FSR',fld:'vBASECALDIFAPOOS_FSR',pic:''}]}");
      setEventMetadata("COMBO_CONTRADICOS.ONOPTIONCLICKED","{handler:'e162N2',iparms:[{av:'Combo_contradicos_Selectedvalue_get',ctrl:'COMBO_CONTRADICOS',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_CONTRADICOS.ONOPTIONCLICKED",",oparms:[{av:'AV26ContrAdicOS',fld:'vCONTRADICOS',pic:''}]}");
      setEventMetadata("COMBO_APORTEADICOS.ONOPTIONCLICKED","{handler:'e152N2',iparms:[{av:'Combo_aporteadicos_Selectedvalue_get',ctrl:'COMBO_APORTEADICOS',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_APORTEADICOS.ONOPTIONCLICKED",",oparms:[{av:'AV25AporteAdicOS',fld:'vAPORTEADICOS',pic:''}]}");
      setEventMetadata("COMBO_MATERNIDADANSES.ONOPTIONCLICKED","{handler:'e142N2',iparms:[{av:'Combo_maternidadanses_Selectedvalue_get',ctrl:'COMBO_MATERNIDADANSES',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_MATERNIDADANSES.ONOPTIONCLICKED",",oparms:[{av:'AV27MaternidadAnses',fld:'vMATERNIDADANSES',pic:''}]}");
      setEventMetadata("COMBO_SUELDOBASICOMENSUAL.ONOPTIONCLICKED","{handler:'e132N2',iparms:[{av:'Combo_sueldobasicomensual_Selectedvalue_get',ctrl:'COMBO_SUELDOBASICOMENSUAL',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_SUELDOBASICOMENSUAL.ONOPTIONCLICKED",",oparms:[{av:'AV78SueldoBasicoMensual',fld:'vSUELDOBASICOMENSUAL',pic:''}]}");
      setEventMetadata("COMBO_SUELDOBASICO.ONOPTIONCLICKED","{handler:'e122N2',iparms:[{av:'Combo_sueldobasico_Selectedvalue_get',ctrl:'COMBO_SUELDOBASICO',prop:'SelectedValue_get'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("COMBO_SUELDOBASICO.ONOPTIONCLICKED",",oparms:[{av:'AV29SueldoBasico',fld:'vSUELDOBASICO',pic:''}]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e322N2',iparms:[{av:'AV88WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV81MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e112N1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("'DORELACIONCONCEPTOSAFIP'","{handler:'e382N2',iparms:[]");
      setEventMetadata("'DORELACIONCONCEPTOSAFIP'",",oparms:[]}");
      setEventMetadata("VANIOPERIODO.ISVALID","{handler:'e332N2',iparms:[{av:'AV5AnioPeriodo',fld:'vANIOPERIODO',pic:'ZZZ9'},{av:'cmbavMesperiodo'},{av:'AV14MesPeriodo',fld:'vMESPERIODO',pic:'Z9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:''},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VANIOPERIODO.ISVALID",",oparms:[{av:'edtavLiqnro_Visible',ctrl:'vLIQNRO',prop:'Visible'},{av:'AV19LiqPeriodo',fld:'vLIQPERIODO',pic:''}]}");
      setEventMetadata("VMESPERIODO.CLICK","{handler:'e342N2',iparms:[{av:'AV5AnioPeriodo',fld:'vANIOPERIODO',pic:'ZZZ9'},{av:'cmbavMesperiodo'},{av:'AV14MesPeriodo',fld:'vMESPERIODO',pic:'Z9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:''},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VMESPERIODO.CLICK",",oparms:[{av:'edtavLiqnro_Visible',ctrl:'vLIQNRO',prop:'Visible'},{av:'AV19LiqPeriodo',fld:'vLIQPERIODO',pic:''}]}");
      setEventMetadata("GRID1_FIRSTPAGE","{handler:'subgrid1_firstpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV20liqNumero',fld:'vLIQNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV81MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV88WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("GRID1_FIRSTPAGE",",oparms:[{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("GRID1_PREVPAGE","{handler:'subgrid1_previouspage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV20liqNumero',fld:'vLIQNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV81MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV88WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("GRID1_PREVPAGE",",oparms:[{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("GRID1_NEXTPAGE","{handler:'subgrid1_nextpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV20liqNumero',fld:'vLIQNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV81MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV88WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("GRID1_NEXTPAGE",",oparms:[{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("GRID1_LASTPAGE","{handler:'subgrid1_lastpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV20liqNumero',fld:'vLIQNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV81MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV88WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("GRID1_LASTPAGE",",oparms:[{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("VALIDV_TIPOENVIO","{handler:'validv_Tipoenvio',iparms:[]");
      setEventMetadata("VALIDV_TIPOENVIO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Conafipconcepto',iparms:[]");
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
      wcpOAV81MenuOpcCod = "" ;
      Combo_baseimpo10_Selectedvalue_get = "" ;
      Combo_baseimpo9_Selectedvalue_get = "" ;
      Combo_baseimpo8_Selectedvalue_get = "" ;
      Combo_baseimpo7_Selectedvalue_get = "" ;
      Combo_baseimpo6_Selectedvalue_get = "" ;
      Combo_baseimpo5_Selectedvalue_get = "" ;
      Combo_baseimpo4_Selectedvalue_get = "" ;
      Combo_baseimpo3_Selectedvalue_get = "" ;
      Combo_baseimpo2_Selectedvalue_get = "" ;
      Combo_baseimpo1_Selectedvalue_get = "" ;
      Combo_basecaldifcontros_fsr_Selectedvalue_get = "" ;
      Combo_basecaldifapoos_fsr_Selectedvalue_get = "" ;
      Combo_contradicos_Selectedvalue_get = "" ;
      Combo_aporteadicos_Selectedvalue_get = "" ;
      Combo_maternidadanses_Selectedvalue_get = "" ;
      Combo_sueldobasicomensual_Selectedvalue_get = "" ;
      Combo_sueldobasico_Selectedvalue_get = "" ;
      Combo_legnumero_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV81MenuOpcCod = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV77LegNumero_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV30SueldoBasico_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV79SueldoBasicoMensual_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV32MaternidadAnses_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV33AporteAdicOS_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV34ContrAdicOS_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV71BaseCalDifApoOS_FSR_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV72BaseCalDifContrOS_FSR_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV54BaseImpo1_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV55BaseImpo2_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV56BaseImpo3_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV57BaseImpo4_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV58BaseImpo5_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV59BaseImpo6_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV60BaseImpo7_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV61BaseImpo8_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV62BaseImpo9_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV63BaseImpo10_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV19LiqPeriodo = GXutil.nullDate() ;
      A283LiqPeriodo = GXutil.nullDate() ;
      Combo_legnumero_Selectedvalue_set = "" ;
      Combo_sueldobasico_Selectedvalue_set = "" ;
      Combo_sueldobasicomensual_Selectedvalue_set = "" ;
      Combo_maternidadanses_Selectedvalue_set = "" ;
      Combo_aporteadicos_Selectedvalue_set = "" ;
      Combo_contradicos_Selectedvalue_set = "" ;
      Combo_basecaldifapoos_fsr_Selectedvalue_set = "" ;
      Combo_basecaldifcontros_fsr_Selectedvalue_set = "" ;
      Combo_baseimpo1_Selectedvalue_set = "" ;
      Combo_baseimpo2_Selectedvalue_set = "" ;
      Combo_baseimpo3_Selectedvalue_set = "" ;
      Combo_baseimpo4_Selectedvalue_set = "" ;
      Combo_baseimpo5_Selectedvalue_set = "" ;
      Combo_baseimpo6_Selectedvalue_set = "" ;
      Combo_baseimpo7_Selectedvalue_set = "" ;
      Combo_baseimpo8_Selectedvalue_set = "" ;
      Combo_baseimpo9_Selectedvalue_set = "" ;
      Combo_baseimpo10_Selectedvalue_set = "" ;
      Grid1_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV89WelcomeMessage_Foto = "" ;
      AV93Welcomemessage_foto_GXI = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      AV29SueldoBasico = "" ;
      AV78SueldoBasicoMensual = "" ;
      AV27MaternidadAnses = "" ;
      AV25AporteAdicOS = "" ;
      AV26ContrAdicOS = "" ;
      AV65BaseCalDifApoOS_FSR = "" ;
      AV66BaseCalDifContrOS_FSR = "" ;
      AV44BaseImpo1 = "" ;
      AV45BaseImpo2 = "" ;
      AV46BaseImpo3 = "" ;
      AV47BaseImpo4 = "" ;
      AV48BaseImpo5 = "" ;
      AV49BaseImpo6 = "" ;
      AV50BaseImpo7 = "" ;
      AV51BaseImpo8 = "" ;
      AV52BaseImpo9 = "" ;
      AV53BaseImpo10 = "" ;
      AV16TipoEnvio = "" ;
      AV11FechaRubrica = GXutil.nullDate() ;
      ucGrid1_empowerer = new com.genexus.webpanels.GXUserControl();
      Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A383ConAfipDesc = "" ;
      A73ConCodPropio = "" ;
      A386ConAFIPConcepto = "" ;
      scmdbuf = "" ;
      H002N2_A386ConAFIPConcepto = new String[] {""} ;
      H002N2_n386ConAFIPConcepto = new boolean[] {false} ;
      H002N2_A73ConCodPropio = new String[] {""} ;
      H002N2_A383ConAfipDesc = new String[] {""} ;
      H002N2_A3CliCod = new int[1] ;
      H002N3_AGRID1_nRecordCount = new long[1] ;
      AV37Normal = "" ;
      AV82headTitle = "" ;
      AV83MenuBienveImgURL = "" ;
      GXv_char2 = new String[1] ;
      AV85MenuBienveTitulo = "" ;
      AV86MenuBienveTexto = "" ;
      GXv_int4 = new short[1] ;
      Grid1Row = new com.genexus.webpanels.GXWebRow();
      AV7archivofullpath = "" ;
      AV6archivo = "" ;
      AV23error = "" ;
      GXv_int13 = new long[1] ;
      H002N4_A150ConHabilitado = new boolean[] {false} ;
      H002N4_A37TipoConCod = new String[] {""} ;
      H002N4_A3CliCod = new int[1] ;
      H002N4_A26ConCodigo = new String[] {""} ;
      H002N4_A42ConCodYDesc = new String[] {""} ;
      H002N4_n42ConCodYDesc = new boolean[] {false} ;
      A37TipoConCod = "" ;
      A26ConCodigo = "" ;
      A42ConCodYDesc = "" ;
      AV31Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      ucCombo_baseimpo10 = new com.genexus.webpanels.GXUserControl();
      H002N5_A150ConHabilitado = new boolean[] {false} ;
      H002N5_A37TipoConCod = new String[] {""} ;
      H002N5_A3CliCod = new int[1] ;
      H002N5_A26ConCodigo = new String[] {""} ;
      H002N5_A42ConCodYDesc = new String[] {""} ;
      H002N5_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_baseimpo9 = new com.genexus.webpanels.GXUserControl();
      H002N6_A150ConHabilitado = new boolean[] {false} ;
      H002N6_A37TipoConCod = new String[] {""} ;
      H002N6_A3CliCod = new int[1] ;
      H002N6_A26ConCodigo = new String[] {""} ;
      H002N6_A42ConCodYDesc = new String[] {""} ;
      H002N6_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_baseimpo8 = new com.genexus.webpanels.GXUserControl();
      H002N7_A150ConHabilitado = new boolean[] {false} ;
      H002N7_A37TipoConCod = new String[] {""} ;
      H002N7_A3CliCod = new int[1] ;
      H002N7_A26ConCodigo = new String[] {""} ;
      H002N7_A42ConCodYDesc = new String[] {""} ;
      H002N7_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_baseimpo7 = new com.genexus.webpanels.GXUserControl();
      H002N8_A150ConHabilitado = new boolean[] {false} ;
      H002N8_A37TipoConCod = new String[] {""} ;
      H002N8_A3CliCod = new int[1] ;
      H002N8_A26ConCodigo = new String[] {""} ;
      H002N8_A42ConCodYDesc = new String[] {""} ;
      H002N8_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_baseimpo6 = new com.genexus.webpanels.GXUserControl();
      H002N9_A150ConHabilitado = new boolean[] {false} ;
      H002N9_A37TipoConCod = new String[] {""} ;
      H002N9_A3CliCod = new int[1] ;
      H002N9_A26ConCodigo = new String[] {""} ;
      H002N9_A42ConCodYDesc = new String[] {""} ;
      H002N9_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_baseimpo5 = new com.genexus.webpanels.GXUserControl();
      H002N10_A150ConHabilitado = new boolean[] {false} ;
      H002N10_A37TipoConCod = new String[] {""} ;
      H002N10_A3CliCod = new int[1] ;
      H002N10_A26ConCodigo = new String[] {""} ;
      H002N10_A42ConCodYDesc = new String[] {""} ;
      H002N10_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_baseimpo4 = new com.genexus.webpanels.GXUserControl();
      H002N11_A150ConHabilitado = new boolean[] {false} ;
      H002N11_A37TipoConCod = new String[] {""} ;
      H002N11_A3CliCod = new int[1] ;
      H002N11_A26ConCodigo = new String[] {""} ;
      H002N11_A42ConCodYDesc = new String[] {""} ;
      H002N11_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_baseimpo3 = new com.genexus.webpanels.GXUserControl();
      H002N12_A150ConHabilitado = new boolean[] {false} ;
      H002N12_A37TipoConCod = new String[] {""} ;
      H002N12_A3CliCod = new int[1] ;
      H002N12_A26ConCodigo = new String[] {""} ;
      H002N12_A42ConCodYDesc = new String[] {""} ;
      H002N12_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_baseimpo2 = new com.genexus.webpanels.GXUserControl();
      H002N13_A150ConHabilitado = new boolean[] {false} ;
      H002N13_A37TipoConCod = new String[] {""} ;
      H002N13_A3CliCod = new int[1] ;
      H002N13_A26ConCodigo = new String[] {""} ;
      H002N13_A42ConCodYDesc = new String[] {""} ;
      H002N13_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_baseimpo1 = new com.genexus.webpanels.GXUserControl();
      H002N14_A150ConHabilitado = new boolean[] {false} ;
      H002N14_A37TipoConCod = new String[] {""} ;
      H002N14_A3CliCod = new int[1] ;
      H002N14_A26ConCodigo = new String[] {""} ;
      H002N14_A42ConCodYDesc = new String[] {""} ;
      H002N14_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_basecaldifcontros_fsr = new com.genexus.webpanels.GXUserControl();
      H002N15_A150ConHabilitado = new boolean[] {false} ;
      H002N15_A37TipoConCod = new String[] {""} ;
      H002N15_A3CliCod = new int[1] ;
      H002N15_A26ConCodigo = new String[] {""} ;
      H002N15_A42ConCodYDesc = new String[] {""} ;
      H002N15_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_basecaldifapoos_fsr = new com.genexus.webpanels.GXUserControl();
      H002N16_A150ConHabilitado = new boolean[] {false} ;
      H002N16_A3CliCod = new int[1] ;
      H002N16_A26ConCodigo = new String[] {""} ;
      H002N16_A42ConCodYDesc = new String[] {""} ;
      H002N16_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_contradicos = new com.genexus.webpanels.GXUserControl();
      H002N17_A150ConHabilitado = new boolean[] {false} ;
      H002N17_A3CliCod = new int[1] ;
      H002N17_A26ConCodigo = new String[] {""} ;
      H002N17_A42ConCodYDesc = new String[] {""} ;
      H002N17_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_aporteadicos = new com.genexus.webpanels.GXUserControl();
      H002N18_A150ConHabilitado = new boolean[] {false} ;
      H002N18_A37TipoConCod = new String[] {""} ;
      H002N18_A3CliCod = new int[1] ;
      H002N18_A26ConCodigo = new String[] {""} ;
      H002N18_A42ConCodYDesc = new String[] {""} ;
      H002N18_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_maternidadanses = new com.genexus.webpanels.GXUserControl();
      H002N19_A150ConHabilitado = new boolean[] {false} ;
      H002N19_A38SubTipoConCod1 = new String[] {""} ;
      H002N19_n38SubTipoConCod1 = new boolean[] {false} ;
      H002N19_A37TipoConCod = new String[] {""} ;
      H002N19_A3CliCod = new int[1] ;
      H002N19_A26ConCodigo = new String[] {""} ;
      H002N19_A42ConCodYDesc = new String[] {""} ;
      H002N19_n42ConCodYDesc = new boolean[] {false} ;
      A38SubTipoConCod1 = "" ;
      ucCombo_sueldobasicomensual = new com.genexus.webpanels.GXUserControl();
      GXt_char10 = "" ;
      GXt_char1 = "" ;
      H002N20_A150ConHabilitado = new boolean[] {false} ;
      H002N20_A38SubTipoConCod1 = new String[] {""} ;
      H002N20_n38SubTipoConCod1 = new boolean[] {false} ;
      H002N20_A37TipoConCod = new String[] {""} ;
      H002N20_A3CliCod = new int[1] ;
      H002N20_A26ConCodigo = new String[] {""} ;
      H002N20_A42ConCodYDesc = new String[] {""} ;
      H002N20_n42ConCodYDesc = new boolean[] {false} ;
      ucCombo_sueldobasico = new com.genexus.webpanels.GXUserControl();
      H002N21_A3CliCod = new int[1] ;
      H002N21_A1EmpCod = new short[1] ;
      H002N21_A6LegNumero = new int[1] ;
      H002N21_A250LegIdNomApe = new String[] {""} ;
      A250LegIdNomApe = "" ;
      ucCombo_legnumero = new com.genexus.webpanels.GXUserControl();
      GXv_int11 = new short[1] ;
      GXv_int6 = new int[1] ;
      AV84textoNoMostrara = "" ;
      GXv_boolean9 = new boolean[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      H002N22_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      H002N22_A1EmpCod = new short[1] ;
      H002N22_A3CliCod = new int[1] ;
      H002N22_A31LiqNro = new int[1] ;
      ucGxuitabspanel_tabs1 = new com.genexus.webpanels.GXUserControl();
      lblTabliq_title_Jsonclick = "" ;
      ucDvpanel_panellibro = new com.genexus.webpanels.GXUserControl();
      bttBtngenerarliquidaciones_Jsonclick = "" ;
      lblTabconceptos_title_Jsonclick = "" ;
      ucDvpanel_panelparam = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_panelparam1 = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_sueldobasico_Jsonclick = "" ;
      Combo_sueldobasico_Caption = "" ;
      lblTextblockcombo_sueldobasicomensual_Jsonclick = "" ;
      Combo_sueldobasicomensual_Caption = "" ;
      lblTextblockcombo_maternidadanses_Jsonclick = "" ;
      Combo_maternidadanses_Caption = "" ;
      lblTextblockcombo_aporteadicos_Jsonclick = "" ;
      Combo_aporteadicos_Caption = "" ;
      lblTextblockcombo_contradicos_Jsonclick = "" ;
      Combo_contradicos_Caption = "" ;
      ucDvpanel_tblbasesd = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_basecaldifapoos_fsr_Jsonclick = "" ;
      Combo_basecaldifapoos_fsr_Caption = "" ;
      lblTextblockcombo_basecaldifcontros_fsr_Jsonclick = "" ;
      Combo_basecaldifcontros_fsr_Caption = "" ;
      ucDvpanel_tblbases = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_baseimpo1_Jsonclick = "" ;
      Combo_baseimpo1_Caption = "" ;
      lblTextblockcombo_baseimpo2_Jsonclick = "" ;
      Combo_baseimpo2_Caption = "" ;
      lblTextblockcombo_baseimpo3_Jsonclick = "" ;
      Combo_baseimpo3_Caption = "" ;
      lblTextblockcombo_baseimpo4_Jsonclick = "" ;
      Combo_baseimpo4_Caption = "" ;
      lblTextblockcombo_baseimpo5_Jsonclick = "" ;
      Combo_baseimpo5_Caption = "" ;
      lblTextblockcombo_baseimpo6_Jsonclick = "" ;
      Combo_baseimpo6_Caption = "" ;
      lblTextblockcombo_baseimpo7_Jsonclick = "" ;
      Combo_baseimpo7_Caption = "" ;
      lblTextblockcombo_baseimpo8_Jsonclick = "" ;
      Combo_baseimpo8_Caption = "" ;
      lblTextblockcombo_baseimpo9_Jsonclick = "" ;
      Combo_baseimpo9_Caption = "" ;
      lblTextblockcombo_baseimpo10_Jsonclick = "" ;
      Combo_baseimpo10_Caption = "" ;
      ucDvpanel_panelconcafip = new com.genexus.webpanels.GXUserControl();
      bttBtncomenzarasistente_Jsonclick = "" ;
      lblTabexportar_title_Jsonclick = "" ;
      bttBtngenerararchivo_Jsonclick = "" ;
      lblTextblockcombo_legnumero_Jsonclick = "" ;
      Combo_legnumero_Caption = "" ;
      lblWelcomemessage_descripcion_Jsonclick = "" ;
      lblWelcomemessage_titulo_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid1_Linesclass = "" ;
      ROClassString = "" ;
      Grid1Column = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.librosueldosdigital__default(),
         new Object[] {
             new Object[] {
            H002N2_A386ConAFIPConcepto, H002N2_n386ConAFIPConcepto, H002N2_A73ConCodPropio, H002N2_A383ConAfipDesc, H002N2_A3CliCod
            }
            , new Object[] {
            H002N3_AGRID1_nRecordCount
            }
            , new Object[] {
            H002N4_A150ConHabilitado, H002N4_A37TipoConCod, H002N4_A3CliCod, H002N4_A26ConCodigo, H002N4_A42ConCodYDesc, H002N4_n42ConCodYDesc
            }
            , new Object[] {
            H002N5_A150ConHabilitado, H002N5_A37TipoConCod, H002N5_A3CliCod, H002N5_A26ConCodigo, H002N5_A42ConCodYDesc, H002N5_n42ConCodYDesc
            }
            , new Object[] {
            H002N6_A150ConHabilitado, H002N6_A37TipoConCod, H002N6_A3CliCod, H002N6_A26ConCodigo, H002N6_A42ConCodYDesc, H002N6_n42ConCodYDesc
            }
            , new Object[] {
            H002N7_A150ConHabilitado, H002N7_A37TipoConCod, H002N7_A3CliCod, H002N7_A26ConCodigo, H002N7_A42ConCodYDesc, H002N7_n42ConCodYDesc
            }
            , new Object[] {
            H002N8_A150ConHabilitado, H002N8_A37TipoConCod, H002N8_A3CliCod, H002N8_A26ConCodigo, H002N8_A42ConCodYDesc, H002N8_n42ConCodYDesc
            }
            , new Object[] {
            H002N9_A150ConHabilitado, H002N9_A37TipoConCod, H002N9_A3CliCod, H002N9_A26ConCodigo, H002N9_A42ConCodYDesc, H002N9_n42ConCodYDesc
            }
            , new Object[] {
            H002N10_A150ConHabilitado, H002N10_A37TipoConCod, H002N10_A3CliCod, H002N10_A26ConCodigo, H002N10_A42ConCodYDesc, H002N10_n42ConCodYDesc
            }
            , new Object[] {
            H002N11_A150ConHabilitado, H002N11_A37TipoConCod, H002N11_A3CliCod, H002N11_A26ConCodigo, H002N11_A42ConCodYDesc, H002N11_n42ConCodYDesc
            }
            , new Object[] {
            H002N12_A150ConHabilitado, H002N12_A37TipoConCod, H002N12_A3CliCod, H002N12_A26ConCodigo, H002N12_A42ConCodYDesc, H002N12_n42ConCodYDesc
            }
            , new Object[] {
            H002N13_A150ConHabilitado, H002N13_A37TipoConCod, H002N13_A3CliCod, H002N13_A26ConCodigo, H002N13_A42ConCodYDesc, H002N13_n42ConCodYDesc
            }
            , new Object[] {
            H002N14_A150ConHabilitado, H002N14_A37TipoConCod, H002N14_A3CliCod, H002N14_A26ConCodigo, H002N14_A42ConCodYDesc, H002N14_n42ConCodYDesc
            }
            , new Object[] {
            H002N15_A150ConHabilitado, H002N15_A37TipoConCod, H002N15_A3CliCod, H002N15_A26ConCodigo, H002N15_A42ConCodYDesc, H002N15_n42ConCodYDesc
            }
            , new Object[] {
            H002N16_A150ConHabilitado, H002N16_A3CliCod, H002N16_A26ConCodigo, H002N16_A42ConCodYDesc, H002N16_n42ConCodYDesc
            }
            , new Object[] {
            H002N17_A150ConHabilitado, H002N17_A3CliCod, H002N17_A26ConCodigo, H002N17_A42ConCodYDesc, H002N17_n42ConCodYDesc
            }
            , new Object[] {
            H002N18_A150ConHabilitado, H002N18_A37TipoConCod, H002N18_A3CliCod, H002N18_A26ConCodigo, H002N18_A42ConCodYDesc, H002N18_n42ConCodYDesc
            }
            , new Object[] {
            H002N19_A150ConHabilitado, H002N19_A38SubTipoConCod1, H002N19_n38SubTipoConCod1, H002N19_A37TipoConCod, H002N19_A3CliCod, H002N19_A26ConCodigo, H002N19_A42ConCodYDesc, H002N19_n42ConCodYDesc
            }
            , new Object[] {
            H002N20_A150ConHabilitado, H002N20_A38SubTipoConCod1, H002N20_n38SubTipoConCod1, H002N20_A37TipoConCod, H002N20_A3CliCod, H002N20_A26ConCodigo, H002N20_A42ConCodYDesc, H002N20_n42ConCodYDesc
            }
            , new Object[] {
            H002N21_A3CliCod, H002N21_A1EmpCod, H002N21_A6LegNumero, H002N21_A250LegIdNomApe
            }
            , new Object[] {
            H002N22_A283LiqPeriodo, H002N22_A1EmpCod, H002N22_A3CliCod, H002N22_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte GRID1_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte AV14MesPeriodo ;
   private byte subGrid1_Backcolorstyle ;
   private byte subGrid1_Backstyle ;
   private byte subGrid1_Titlebackstyle ;
   private byte subGrid1_Allowselection ;
   private byte subGrid1_Allowhovering ;
   private byte subGrid1_Allowcollapsing ;
   private byte subGrid1_Collapsed ;
   private short nRcdExists_21 ;
   private short nIsMod_21 ;
   private short nRcdExists_20 ;
   private short nIsMod_20 ;
   private short nRcdExists_19 ;
   private short nIsMod_19 ;
   private short nRcdExists_18 ;
   private short nIsMod_18 ;
   private short nRcdExists_17 ;
   private short nIsMod_17 ;
   private short nRcdExists_16 ;
   private short nIsMod_16 ;
   private short nRcdExists_15 ;
   private short nIsMod_15 ;
   private short nRcdExists_14 ;
   private short nIsMod_14 ;
   private short nRcdExists_13 ;
   private short nIsMod_13 ;
   private short nRcdExists_12 ;
   private short nIsMod_12 ;
   private short nRcdExists_11 ;
   private short nIsMod_11 ;
   private short nRcdExists_10 ;
   private short nIsMod_10 ;
   private short nRcdExists_9 ;
   private short nIsMod_9 ;
   private short nRcdExists_8 ;
   private short nIsMod_8 ;
   private short nRcdExists_7 ;
   private short nIsMod_7 ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV5AnioPeriodo ;
   private short AV17UltAnio ;
   private short GXv_int4[] ;
   private short AV18UltMes ;
   private short GXt_int3 ;
   private short GXv_int11[] ;
   private short AV21l ;
   private int nRC_GXsfl_242 ;
   private int subGrid1_Rows ;
   private int nGXsfl_242_idx=1 ;
   private int AV8CliCod ;
   private int AV20liqNumero ;
   private int A31LiqNro ;
   private int Gxuitabspanel_tabs1_Pagecount ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int AV76LegNumero ;
   private int edtavLegnumero_Visible ;
   private int edtavSueldobasico_Visible ;
   private int edtavSueldobasicomensual_Visible ;
   private int edtavMaternidadanses_Visible ;
   private int edtavAporteadicos_Visible ;
   private int edtavContradicos_Visible ;
   private int edtavBasecaldifapoos_fsr_Visible ;
   private int edtavBasecaldifcontros_fsr_Visible ;
   private int edtavBaseimpo1_Visible ;
   private int edtavBaseimpo2_Visible ;
   private int edtavBaseimpo3_Visible ;
   private int edtavBaseimpo4_Visible ;
   private int edtavBaseimpo5_Visible ;
   private int edtavBaseimpo6_Visible ;
   private int edtavBaseimpo7_Visible ;
   private int edtavBaseimpo8_Visible ;
   private int edtavBaseimpo9_Visible ;
   private int edtavBaseimpo10_Visible ;
   private int AV13LiqNro ;
   private int edtavLiqnro_Visible ;
   private int edtavFecharubrica_Visible ;
   private int A3CliCod ;
   private int subGrid1_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV80LSDSec ;
   private int A6LegNumero ;
   private int GXt_int5 ;
   private int GXv_int6[] ;
   private int AV22liqUnica ;
   private int edtavAnioperiodo_Enabled ;
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
   private long AV90LegCUIL ;
   private long GXv_int13[] ;
   private String Combo_baseimpo10_Selectedvalue_get ;
   private String Combo_baseimpo9_Selectedvalue_get ;
   private String Combo_baseimpo8_Selectedvalue_get ;
   private String Combo_baseimpo7_Selectedvalue_get ;
   private String Combo_baseimpo6_Selectedvalue_get ;
   private String Combo_baseimpo5_Selectedvalue_get ;
   private String Combo_baseimpo4_Selectedvalue_get ;
   private String Combo_baseimpo3_Selectedvalue_get ;
   private String Combo_baseimpo2_Selectedvalue_get ;
   private String Combo_baseimpo1_Selectedvalue_get ;
   private String Combo_basecaldifcontros_fsr_Selectedvalue_get ;
   private String Combo_basecaldifapoos_fsr_Selectedvalue_get ;
   private String Combo_contradicos_Selectedvalue_get ;
   private String Combo_aporteadicos_Selectedvalue_get ;
   private String Combo_maternidadanses_Selectedvalue_get ;
   private String Combo_sueldobasicomensual_Selectedvalue_get ;
   private String Combo_sueldobasico_Selectedvalue_get ;
   private String Combo_legnumero_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_242_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Combo_legnumero_Cls ;
   private String Combo_legnumero_Selectedvalue_set ;
   private String Combo_legnumero_Emptyitemtext ;
   private String Dvpanel_panellibro_Width ;
   private String Dvpanel_panellibro_Cls ;
   private String Dvpanel_panellibro_Title ;
   private String Dvpanel_panellibro_Iconposition ;
   private String Combo_sueldobasico_Cls ;
   private String Combo_sueldobasico_Selectedvalue_set ;
   private String Combo_sueldobasicomensual_Cls ;
   private String Combo_sueldobasicomensual_Selectedvalue_set ;
   private String Combo_maternidadanses_Cls ;
   private String Combo_maternidadanses_Selectedvalue_set ;
   private String Combo_aporteadicos_Cls ;
   private String Combo_aporteadicos_Selectedvalue_set ;
   private String Combo_contradicos_Cls ;
   private String Combo_contradicos_Selectedvalue_set ;
   private String Dvpanel_panelparam1_Width ;
   private String Dvpanel_panelparam1_Cls ;
   private String Dvpanel_panelparam1_Title ;
   private String Dvpanel_panelparam1_Iconposition ;
   private String Combo_basecaldifapoos_fsr_Cls ;
   private String Combo_basecaldifapoos_fsr_Selectedvalue_set ;
   private String Combo_basecaldifcontros_fsr_Cls ;
   private String Combo_basecaldifcontros_fsr_Selectedvalue_set ;
   private String Dvpanel_tblbasesd_Width ;
   private String Dvpanel_tblbasesd_Cls ;
   private String Dvpanel_tblbasesd_Title ;
   private String Dvpanel_tblbasesd_Iconposition ;
   private String Combo_baseimpo1_Cls ;
   private String Combo_baseimpo1_Selectedvalue_set ;
   private String Combo_baseimpo2_Cls ;
   private String Combo_baseimpo2_Selectedvalue_set ;
   private String Combo_baseimpo3_Cls ;
   private String Combo_baseimpo3_Selectedvalue_set ;
   private String Combo_baseimpo4_Cls ;
   private String Combo_baseimpo4_Selectedvalue_set ;
   private String Combo_baseimpo5_Cls ;
   private String Combo_baseimpo5_Selectedvalue_set ;
   private String Combo_baseimpo6_Cls ;
   private String Combo_baseimpo6_Selectedvalue_set ;
   private String Combo_baseimpo7_Cls ;
   private String Combo_baseimpo7_Selectedvalue_set ;
   private String Combo_baseimpo8_Cls ;
   private String Combo_baseimpo8_Selectedvalue_set ;
   private String Combo_baseimpo9_Cls ;
   private String Combo_baseimpo9_Selectedvalue_set ;
   private String Combo_baseimpo10_Cls ;
   private String Combo_baseimpo10_Selectedvalue_set ;
   private String Dvpanel_tblbases_Width ;
   private String Dvpanel_tblbases_Cls ;
   private String Dvpanel_tblbases_Title ;
   private String Dvpanel_tblbases_Iconposition ;
   private String Dvpanel_panelparam_Width ;
   private String Dvpanel_panelparam_Cls ;
   private String Dvpanel_panelparam_Title ;
   private String Dvpanel_panelparam_Iconposition ;
   private String Dvpanel_panelconcafip_Width ;
   private String Dvpanel_panelconcafip_Cls ;
   private String Dvpanel_panelconcafip_Title ;
   private String Dvpanel_panelconcafip_Iconposition ;
   private String Gxuitabspanel_tabs1_Class ;
   private String Grid1_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String divWelcomemessage_welcometableprincipal_Internalname ;
   private String divWelcomemessage_tableclose_Internalname ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String lblWelcomemessage_closehelp_Jsonclick ;
   private String divWelcomemessage_welcomecontentitem_Internalname ;
   private String divWelcomemessage_welcomecontentflex_Internalname ;
   private String divWelcomemessage_welcometableimagen_Internalname ;
   private String ClassString ;
   private String imgavWelcomemessage_foto_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String divWelcomemessage_tabletexto_Internalname ;
   private String divWelcomemessage_welcomebottomitem_Internalname ;
   private String divWelcomemessage_tablecmb_Internalname ;
   private String divWelcomemessage_tablec_Internalname ;
   private String TempTags ;
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavLegnumero_Internalname ;
   private String edtavLegnumero_Jsonclick ;
   private String edtavSueldobasico_Internalname ;
   private String AV29SueldoBasico ;
   private String edtavSueldobasico_Jsonclick ;
   private String edtavSueldobasicomensual_Internalname ;
   private String AV78SueldoBasicoMensual ;
   private String edtavSueldobasicomensual_Jsonclick ;
   private String edtavMaternidadanses_Internalname ;
   private String AV27MaternidadAnses ;
   private String edtavMaternidadanses_Jsonclick ;
   private String edtavAporteadicos_Internalname ;
   private String AV25AporteAdicOS ;
   private String edtavAporteadicos_Jsonclick ;
   private String edtavContradicos_Internalname ;
   private String AV26ContrAdicOS ;
   private String edtavContradicos_Jsonclick ;
   private String edtavBasecaldifapoos_fsr_Internalname ;
   private String AV65BaseCalDifApoOS_FSR ;
   private String edtavBasecaldifapoos_fsr_Jsonclick ;
   private String edtavBasecaldifcontros_fsr_Internalname ;
   private String AV66BaseCalDifContrOS_FSR ;
   private String edtavBasecaldifcontros_fsr_Jsonclick ;
   private String edtavBaseimpo1_Internalname ;
   private String AV44BaseImpo1 ;
   private String edtavBaseimpo1_Jsonclick ;
   private String edtavBaseimpo2_Internalname ;
   private String AV45BaseImpo2 ;
   private String edtavBaseimpo2_Jsonclick ;
   private String edtavBaseimpo3_Internalname ;
   private String AV46BaseImpo3 ;
   private String edtavBaseimpo3_Jsonclick ;
   private String edtavBaseimpo4_Internalname ;
   private String AV47BaseImpo4 ;
   private String edtavBaseimpo4_Jsonclick ;
   private String edtavBaseimpo5_Internalname ;
   private String AV48BaseImpo5 ;
   private String edtavBaseimpo5_Jsonclick ;
   private String edtavBaseimpo6_Internalname ;
   private String AV49BaseImpo6 ;
   private String edtavBaseimpo6_Jsonclick ;
   private String edtavBaseimpo7_Internalname ;
   private String AV50BaseImpo7 ;
   private String edtavBaseimpo7_Jsonclick ;
   private String edtavBaseimpo8_Internalname ;
   private String AV51BaseImpo8 ;
   private String edtavBaseimpo8_Jsonclick ;
   private String edtavBaseimpo9_Internalname ;
   private String AV52BaseImpo9 ;
   private String edtavBaseimpo9_Jsonclick ;
   private String edtavBaseimpo10_Internalname ;
   private String AV53BaseImpo10 ;
   private String edtavBaseimpo10_Jsonclick ;
   private String edtavLiqnro_Internalname ;
   private String edtavLiqnro_Jsonclick ;
   private String AV16TipoEnvio ;
   private String edtavFecharubrica_Internalname ;
   private String edtavFecharubrica_Jsonclick ;
   private String Grid1_empowerer_Internalname ;
   private String sStyleString ;
   private String subGrid1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtCliCod_Internalname ;
   private String edtConAfipDesc_Internalname ;
   private String A73ConCodPropio ;
   private String edtConCodPropio_Internalname ;
   private String A386ConAFIPConcepto ;
   private String edtConAFIPConcepto_Internalname ;
   private String scmdbuf ;
   private String edtavAnioperiodo_Internalname ;
   private String AV37Normal ;
   private String GXv_char2[] ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String divDvpanel_panelconcafip_cell_Class ;
   private String divDvpanel_panelconcafip_cell_Internalname ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private String Combo_baseimpo10_Internalname ;
   private String Combo_baseimpo9_Internalname ;
   private String Combo_baseimpo8_Internalname ;
   private String Combo_baseimpo7_Internalname ;
   private String Combo_baseimpo6_Internalname ;
   private String Combo_baseimpo5_Internalname ;
   private String Combo_baseimpo4_Internalname ;
   private String Combo_baseimpo3_Internalname ;
   private String Combo_baseimpo2_Internalname ;
   private String Combo_baseimpo1_Internalname ;
   private String Combo_basecaldifcontros_fsr_Internalname ;
   private String Combo_basecaldifapoos_fsr_Internalname ;
   private String Combo_contradicos_Internalname ;
   private String Combo_aporteadicos_Internalname ;
   private String Combo_maternidadanses_Internalname ;
   private String A38SubTipoConCod1 ;
   private String Combo_sueldobasicomensual_Internalname ;
   private String GXt_char10 ;
   private String GXt_char1 ;
   private String Combo_sueldobasico_Internalname ;
   private String Combo_legnumero_Internalname ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Gxuitabspanel_tabs1_Internalname ;
   private String lblTabliq_title_Internalname ;
   private String lblTabliq_title_Jsonclick ;
   private String divUnnamedtable3_Internalname ;
   private String Dvpanel_panellibro_Internalname ;
   private String divPanellibro_Internalname ;
   private String bttBtngenerarliquidaciones_Internalname ;
   private String bttBtngenerarliquidaciones_Jsonclick ;
   private String lblTabconceptos_title_Internalname ;
   private String lblTabconceptos_title_Jsonclick ;
   private String divUnnamedtable2_Internalname ;
   private String Dvpanel_panelparam_Internalname ;
   private String divPanelparam_Internalname ;
   private String Dvpanel_panelparam1_Internalname ;
   private String divPanelparam1_Internalname ;
   private String divTablesplittedsueldobasico_Internalname ;
   private String lblTextblockcombo_sueldobasico_Internalname ;
   private String lblTextblockcombo_sueldobasico_Jsonclick ;
   private String Combo_sueldobasico_Caption ;
   private String divTablesplittedsueldobasicomensual_Internalname ;
   private String lblTextblockcombo_sueldobasicomensual_Internalname ;
   private String lblTextblockcombo_sueldobasicomensual_Jsonclick ;
   private String Combo_sueldobasicomensual_Caption ;
   private String divTablesplittedmaternidadanses_Internalname ;
   private String lblTextblockcombo_maternidadanses_Internalname ;
   private String lblTextblockcombo_maternidadanses_Jsonclick ;
   private String Combo_maternidadanses_Caption ;
   private String divTablesplittedaporteadicos_Internalname ;
   private String lblTextblockcombo_aporteadicos_Internalname ;
   private String lblTextblockcombo_aporteadicos_Jsonclick ;
   private String Combo_aporteadicos_Caption ;
   private String divTablesplittedcontradicos_Internalname ;
   private String lblTextblockcombo_contradicos_Internalname ;
   private String lblTextblockcombo_contradicos_Jsonclick ;
   private String Combo_contradicos_Caption ;
   private String Dvpanel_tblbasesd_Internalname ;
   private String divTblbasesd_Internalname ;
   private String divTablesplittedbasecaldifapoos_fsr_Internalname ;
   private String lblTextblockcombo_basecaldifapoos_fsr_Internalname ;
   private String lblTextblockcombo_basecaldifapoos_fsr_Jsonclick ;
   private String Combo_basecaldifapoos_fsr_Caption ;
   private String divTablesplittedbasecaldifcontros_fsr_Internalname ;
   private String lblTextblockcombo_basecaldifcontros_fsr_Internalname ;
   private String lblTextblockcombo_basecaldifcontros_fsr_Jsonclick ;
   private String Combo_basecaldifcontros_fsr_Caption ;
   private String Dvpanel_tblbases_Internalname ;
   private String divTblbases_Internalname ;
   private String divTablesplittedbaseimpo1_Internalname ;
   private String lblTextblockcombo_baseimpo1_Internalname ;
   private String lblTextblockcombo_baseimpo1_Jsonclick ;
   private String Combo_baseimpo1_Caption ;
   private String divTablesplittedbaseimpo2_Internalname ;
   private String lblTextblockcombo_baseimpo2_Internalname ;
   private String lblTextblockcombo_baseimpo2_Jsonclick ;
   private String Combo_baseimpo2_Caption ;
   private String divTablesplittedbaseimpo3_Internalname ;
   private String lblTextblockcombo_baseimpo3_Internalname ;
   private String lblTextblockcombo_baseimpo3_Jsonclick ;
   private String Combo_baseimpo3_Caption ;
   private String divTablesplittedbaseimpo4_Internalname ;
   private String lblTextblockcombo_baseimpo4_Internalname ;
   private String lblTextblockcombo_baseimpo4_Jsonclick ;
   private String Combo_baseimpo4_Caption ;
   private String divTablesplittedbaseimpo5_Internalname ;
   private String lblTextblockcombo_baseimpo5_Internalname ;
   private String lblTextblockcombo_baseimpo5_Jsonclick ;
   private String Combo_baseimpo5_Caption ;
   private String divTablesplittedbaseimpo6_Internalname ;
   private String lblTextblockcombo_baseimpo6_Internalname ;
   private String lblTextblockcombo_baseimpo6_Jsonclick ;
   private String Combo_baseimpo6_Caption ;
   private String divTablesplittedbaseimpo7_Internalname ;
   private String lblTextblockcombo_baseimpo7_Internalname ;
   private String lblTextblockcombo_baseimpo7_Jsonclick ;
   private String Combo_baseimpo7_Caption ;
   private String divTablesplittedbaseimpo8_Internalname ;
   private String lblTextblockcombo_baseimpo8_Internalname ;
   private String lblTextblockcombo_baseimpo8_Jsonclick ;
   private String Combo_baseimpo8_Caption ;
   private String divTablesplittedbaseimpo9_Internalname ;
   private String lblTextblockcombo_baseimpo9_Internalname ;
   private String lblTextblockcombo_baseimpo9_Jsonclick ;
   private String Combo_baseimpo9_Caption ;
   private String divTablesplittedbaseimpo10_Internalname ;
   private String lblTextblockcombo_baseimpo10_Internalname ;
   private String lblTextblockcombo_baseimpo10_Jsonclick ;
   private String Combo_baseimpo10_Caption ;
   private String Dvpanel_panelconcafip_Internalname ;
   private String divPanelconcafip_Internalname ;
   private String bttBtncomenzarasistente_Internalname ;
   private String bttBtncomenzarasistente_Jsonclick ;
   private String lblTabexportar_title_Internalname ;
   private String lblTabexportar_title_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String bttBtngenerararchivo_Internalname ;
   private String bttBtngenerararchivo_Jsonclick ;
   private String tblUnnamedtable4_Internalname ;
   private String edtavAnioperiodo_Jsonclick ;
   private String divTablesplittedlegnumero_Internalname ;
   private String lblTextblockcombo_legnumero_Internalname ;
   private String lblTextblockcombo_legnumero_Jsonclick ;
   private String Combo_legnumero_Caption ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private String sGXsfl_242_fel_idx="0001" ;
   private String subGrid1_Class ;
   private String subGrid1_Linesclass ;
   private String ROClassString ;
   private String edtCliCod_Jsonclick ;
   private String edtConAfipDesc_Jsonclick ;
   private String edtConCodPropio_Jsonclick ;
   private String edtConAFIPConcepto_Jsonclick ;
   private String subGrid1_Header ;
   private java.util.Date AV19LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date AV11FechaRubrica ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV88WelcomeMessage_NoMostrarMas ;
   private boolean Dvpanel_panellibro_Autowidth ;
   private boolean Dvpanel_panellibro_Autoheight ;
   private boolean Dvpanel_panellibro_Collapsible ;
   private boolean Dvpanel_panellibro_Collapsed ;
   private boolean Dvpanel_panellibro_Showcollapseicon ;
   private boolean Dvpanel_panellibro_Autoscroll ;
   private boolean Dvpanel_panelparam1_Autowidth ;
   private boolean Dvpanel_panelparam1_Autoheight ;
   private boolean Dvpanel_panelparam1_Collapsible ;
   private boolean Dvpanel_panelparam1_Collapsed ;
   private boolean Dvpanel_panelparam1_Showcollapseicon ;
   private boolean Dvpanel_panelparam1_Autoscroll ;
   private boolean Dvpanel_tblbasesd_Autowidth ;
   private boolean Dvpanel_tblbasesd_Autoheight ;
   private boolean Dvpanel_tblbasesd_Collapsible ;
   private boolean Dvpanel_tblbasesd_Collapsed ;
   private boolean Dvpanel_tblbasesd_Showcollapseicon ;
   private boolean Dvpanel_tblbasesd_Autoscroll ;
   private boolean Dvpanel_tblbases_Autowidth ;
   private boolean Dvpanel_tblbases_Autoheight ;
   private boolean Dvpanel_tblbases_Collapsible ;
   private boolean Dvpanel_tblbases_Collapsed ;
   private boolean Dvpanel_tblbases_Showcollapseicon ;
   private boolean Dvpanel_tblbases_Autoscroll ;
   private boolean Dvpanel_panelparam_Autowidth ;
   private boolean Dvpanel_panelparam_Autoheight ;
   private boolean Dvpanel_panelparam_Collapsible ;
   private boolean Dvpanel_panelparam_Collapsed ;
   private boolean Dvpanel_panelparam_Showcollapseicon ;
   private boolean Dvpanel_panelparam_Autoscroll ;
   private boolean Dvpanel_panelconcafip_Autowidth ;
   private boolean Dvpanel_panelconcafip_Autoheight ;
   private boolean Dvpanel_panelconcafip_Collapsible ;
   private boolean Dvpanel_panelconcafip_Collapsed ;
   private boolean Dvpanel_panelconcafip_Showcollapseicon ;
   private boolean Dvpanel_panelconcafip_Autoscroll ;
   private boolean Gxuitabspanel_tabs1_Historymanagement ;
   private boolean wbLoad ;
   private boolean AV89WelcomeMessage_Foto_IsBlob ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n386ConAFIPConcepto ;
   private boolean bGXsfl_242_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV87MenuBienveVisible ;
   private boolean AV38hay ;
   private boolean GXt_boolean12 ;
   private boolean A150ConHabilitado ;
   private boolean n42ConCodYDesc ;
   private boolean n38SubTipoConCod1 ;
   private boolean gx_refresh_fired ;
   private boolean GXv_boolean9[] ;
   private String AV86MenuBienveTexto ;
   private String AV84textoNoMostrara ;
   private String wcpOAV81MenuOpcCod ;
   private String AV81MenuOpcCod ;
   private String AV93Welcomemessage_foto_GXI ;
   private String A383ConAfipDesc ;
   private String AV82headTitle ;
   private String AV83MenuBienveImgURL ;
   private String AV85MenuBienveTitulo ;
   private String AV7archivofullpath ;
   private String AV6archivo ;
   private String AV23error ;
   private String A42ConCodYDesc ;
   private String A250LegIdNomApe ;
   private String AV89WelcomeMessage_Foto ;
   private com.genexus.webpanels.GXWebGrid Grid1Container ;
   private com.genexus.webpanels.GXWebRow Grid1Row ;
   private com.genexus.webpanels.GXWebColumn Grid1Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGrid1_empowerer ;
   private com.genexus.webpanels.GXUserControl ucCombo_baseimpo10 ;
   private com.genexus.webpanels.GXUserControl ucCombo_baseimpo9 ;
   private com.genexus.webpanels.GXUserControl ucCombo_baseimpo8 ;
   private com.genexus.webpanels.GXUserControl ucCombo_baseimpo7 ;
   private com.genexus.webpanels.GXUserControl ucCombo_baseimpo6 ;
   private com.genexus.webpanels.GXUserControl ucCombo_baseimpo5 ;
   private com.genexus.webpanels.GXUserControl ucCombo_baseimpo4 ;
   private com.genexus.webpanels.GXUserControl ucCombo_baseimpo3 ;
   private com.genexus.webpanels.GXUserControl ucCombo_baseimpo2 ;
   private com.genexus.webpanels.GXUserControl ucCombo_baseimpo1 ;
   private com.genexus.webpanels.GXUserControl ucCombo_basecaldifcontros_fsr ;
   private com.genexus.webpanels.GXUserControl ucCombo_basecaldifapoos_fsr ;
   private com.genexus.webpanels.GXUserControl ucCombo_contradicos ;
   private com.genexus.webpanels.GXUserControl ucCombo_aporteadicos ;
   private com.genexus.webpanels.GXUserControl ucCombo_maternidadanses ;
   private com.genexus.webpanels.GXUserControl ucCombo_sueldobasicomensual ;
   private com.genexus.webpanels.GXUserControl ucCombo_sueldobasico ;
   private com.genexus.webpanels.GXUserControl ucCombo_legnumero ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_tabs1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panellibro ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelparam ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelparam1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tblbasesd ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tblbases ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelconcafip ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbavMesperiodo ;
   private HTMLChoice cmbavTipoenvio ;
   private IDataStoreProvider pr_default ;
   private String[] H002N2_A386ConAFIPConcepto ;
   private boolean[] H002N2_n386ConAFIPConcepto ;
   private String[] H002N2_A73ConCodPropio ;
   private String[] H002N2_A383ConAfipDesc ;
   private int[] H002N2_A3CliCod ;
   private long[] H002N3_AGRID1_nRecordCount ;
   private boolean[] H002N4_A150ConHabilitado ;
   private String[] H002N4_A37TipoConCod ;
   private int[] H002N4_A3CliCod ;
   private String[] H002N4_A26ConCodigo ;
   private String[] H002N4_A42ConCodYDesc ;
   private boolean[] H002N4_n42ConCodYDesc ;
   private boolean[] H002N5_A150ConHabilitado ;
   private String[] H002N5_A37TipoConCod ;
   private int[] H002N5_A3CliCod ;
   private String[] H002N5_A26ConCodigo ;
   private String[] H002N5_A42ConCodYDesc ;
   private boolean[] H002N5_n42ConCodYDesc ;
   private boolean[] H002N6_A150ConHabilitado ;
   private String[] H002N6_A37TipoConCod ;
   private int[] H002N6_A3CliCod ;
   private String[] H002N6_A26ConCodigo ;
   private String[] H002N6_A42ConCodYDesc ;
   private boolean[] H002N6_n42ConCodYDesc ;
   private boolean[] H002N7_A150ConHabilitado ;
   private String[] H002N7_A37TipoConCod ;
   private int[] H002N7_A3CliCod ;
   private String[] H002N7_A26ConCodigo ;
   private String[] H002N7_A42ConCodYDesc ;
   private boolean[] H002N7_n42ConCodYDesc ;
   private boolean[] H002N8_A150ConHabilitado ;
   private String[] H002N8_A37TipoConCod ;
   private int[] H002N8_A3CliCod ;
   private String[] H002N8_A26ConCodigo ;
   private String[] H002N8_A42ConCodYDesc ;
   private boolean[] H002N8_n42ConCodYDesc ;
   private boolean[] H002N9_A150ConHabilitado ;
   private String[] H002N9_A37TipoConCod ;
   private int[] H002N9_A3CliCod ;
   private String[] H002N9_A26ConCodigo ;
   private String[] H002N9_A42ConCodYDesc ;
   private boolean[] H002N9_n42ConCodYDesc ;
   private boolean[] H002N10_A150ConHabilitado ;
   private String[] H002N10_A37TipoConCod ;
   private int[] H002N10_A3CliCod ;
   private String[] H002N10_A26ConCodigo ;
   private String[] H002N10_A42ConCodYDesc ;
   private boolean[] H002N10_n42ConCodYDesc ;
   private boolean[] H002N11_A150ConHabilitado ;
   private String[] H002N11_A37TipoConCod ;
   private int[] H002N11_A3CliCod ;
   private String[] H002N11_A26ConCodigo ;
   private String[] H002N11_A42ConCodYDesc ;
   private boolean[] H002N11_n42ConCodYDesc ;
   private boolean[] H002N12_A150ConHabilitado ;
   private String[] H002N12_A37TipoConCod ;
   private int[] H002N12_A3CliCod ;
   private String[] H002N12_A26ConCodigo ;
   private String[] H002N12_A42ConCodYDesc ;
   private boolean[] H002N12_n42ConCodYDesc ;
   private boolean[] H002N13_A150ConHabilitado ;
   private String[] H002N13_A37TipoConCod ;
   private int[] H002N13_A3CliCod ;
   private String[] H002N13_A26ConCodigo ;
   private String[] H002N13_A42ConCodYDesc ;
   private boolean[] H002N13_n42ConCodYDesc ;
   private boolean[] H002N14_A150ConHabilitado ;
   private String[] H002N14_A37TipoConCod ;
   private int[] H002N14_A3CliCod ;
   private String[] H002N14_A26ConCodigo ;
   private String[] H002N14_A42ConCodYDesc ;
   private boolean[] H002N14_n42ConCodYDesc ;
   private boolean[] H002N15_A150ConHabilitado ;
   private String[] H002N15_A37TipoConCod ;
   private int[] H002N15_A3CliCod ;
   private String[] H002N15_A26ConCodigo ;
   private String[] H002N15_A42ConCodYDesc ;
   private boolean[] H002N15_n42ConCodYDesc ;
   private boolean[] H002N16_A150ConHabilitado ;
   private int[] H002N16_A3CliCod ;
   private String[] H002N16_A26ConCodigo ;
   private String[] H002N16_A42ConCodYDesc ;
   private boolean[] H002N16_n42ConCodYDesc ;
   private boolean[] H002N17_A150ConHabilitado ;
   private int[] H002N17_A3CliCod ;
   private String[] H002N17_A26ConCodigo ;
   private String[] H002N17_A42ConCodYDesc ;
   private boolean[] H002N17_n42ConCodYDesc ;
   private boolean[] H002N18_A150ConHabilitado ;
   private String[] H002N18_A37TipoConCod ;
   private int[] H002N18_A3CliCod ;
   private String[] H002N18_A26ConCodigo ;
   private String[] H002N18_A42ConCodYDesc ;
   private boolean[] H002N18_n42ConCodYDesc ;
   private boolean[] H002N19_A150ConHabilitado ;
   private String[] H002N19_A38SubTipoConCod1 ;
   private boolean[] H002N19_n38SubTipoConCod1 ;
   private String[] H002N19_A37TipoConCod ;
   private int[] H002N19_A3CliCod ;
   private String[] H002N19_A26ConCodigo ;
   private String[] H002N19_A42ConCodYDesc ;
   private boolean[] H002N19_n42ConCodYDesc ;
   private boolean[] H002N20_A150ConHabilitado ;
   private String[] H002N20_A38SubTipoConCod1 ;
   private boolean[] H002N20_n38SubTipoConCod1 ;
   private String[] H002N20_A37TipoConCod ;
   private int[] H002N20_A3CliCod ;
   private String[] H002N20_A26ConCodigo ;
   private String[] H002N20_A42ConCodYDesc ;
   private boolean[] H002N20_n42ConCodYDesc ;
   private int[] H002N21_A3CliCod ;
   private short[] H002N21_A1EmpCod ;
   private int[] H002N21_A6LegNumero ;
   private String[] H002N21_A250LegIdNomApe ;
   private java.util.Date[] H002N22_A283LiqPeriodo ;
   private short[] H002N22_A1EmpCod ;
   private int[] H002N22_A3CliCod ;
   private int[] H002N22_A31LiqNro ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV77LegNumero_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV30SueldoBasico_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV79SueldoBasicoMensual_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV32MaternidadAnses_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV33AporteAdicOS_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV34ContrAdicOS_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV71BaseCalDifApoOS_FSR_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV72BaseCalDifContrOS_FSR_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV54BaseImpo1_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV55BaseImpo2_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV56BaseImpo3_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV57BaseImpo4_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV58BaseImpo5_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV59BaseImpo6_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV60BaseImpo7_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV61BaseImpo8_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV62BaseImpo9_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV63BaseImpo10_Data ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV31Combo_DataItem ;
}

final  class librosueldosdigital__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002N2", "SELECT ConAFIPConcepto, ConCodPropio, ConAfipDesc, CliCod FROM ConceptoAFIP WHERE CliCod = ? ORDER BY CliCod  OFFSET ? LIMIT CASE WHEN ? > 0 THEN ? ELSE 1e9 END",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N3", "SELECT COUNT(*) FROM ConceptoAFIP WHERE CliCod = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N4", "SELECT ConHabilitado, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'CAL_ARG')) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N5", "SELECT ConHabilitado, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'CAL_ARG')) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N6", "SELECT ConHabilitado, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'CAL_ARG')) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N7", "SELECT ConHabilitado, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'CAL_ARG')) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N8", "SELECT ConHabilitado, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'CAL_ARG')) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N9", "SELECT ConHabilitado, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'CAL_ARG')) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N10", "SELECT ConHabilitado, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'CAL_ARG')) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N11", "SELECT ConHabilitado, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'CAL_ARG')) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N12", "SELECT ConHabilitado, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'CAL_ARG')) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N13", "SELECT ConHabilitado, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'CAL_ARG')) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N14", "SELECT ConHabilitado, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'CAL_ARG')) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N15", "SELECT ConHabilitado, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'CAL_ARG')) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N16", "SELECT ConHabilitado, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ?) AND (ConHabilitado = TRUE) ORDER BY CliCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N17", "SELECT ConHabilitado, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ?) AND (ConHabilitado = TRUE) ORDER BY CliCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N18", "SELECT ConHabilitado, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'NRE_ARG')) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N19", "SELECT ConHabilitado, SubTipoConCod1, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'REM_ARG') and SubTipoConCod1 = ( ?)) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, SubTipoConCod1, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N20", "SELECT ConHabilitado, SubTipoConCod1, TipoConCod, CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE (CliCod = ? and TipoConCod = ( 'REM_ARG') and SubTipoConCod1 = ( ?)) AND (ConHabilitado = TRUE) ORDER BY CliCod, TipoConCod, SubTipoConCod1, ConCodYDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N21", "SELECT CliCod, EmpCod, LegNumero, LegIdNomApe FROM Legajo WHERE (CliCod = ?) AND (EmpCod = ?) ORDER BY LegIdNomApe ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002N22", "SELECT LiqPeriodo, EmpCod, CliCod, LiqNro FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqPeriodo = ? ORDER BY CliCod, EmpCod, LiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 2 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 3 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 4 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 5 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 6 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 7 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 8 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 9 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 10 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 11 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 12 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 13 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 14 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 15 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 16 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 17 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 10);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 18 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 10);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 20 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
      }
   }

}

