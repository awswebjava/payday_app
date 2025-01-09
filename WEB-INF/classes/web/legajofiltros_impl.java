package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajofiltros_impl extends GXDataArea
{
   public legajofiltros_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajofiltros_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajofiltros_impl.class ));
   }

   public legajofiltros_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynavLegsexo = new HTMLChoice();
      cmbavLegmodtra = new HTMLChoice();
      cmbavLegtipotarifa = new HTMLChoice();
      cmbavLegclase = new HTMLChoice();
      cmbavConveniofiltro = new HTMLChoice();
      dynavLegsuccodigo = new HTMLChoice();
      dynavLegactcodigo = new HTMLChoice();
      dynavMprcod = new HTMLChoice();
      dynavZoncod = new HTMLChoice();
      cmbavLegestado = new HTMLChoice();
      chkavLegincompleto = UIFactory.getCheckbox(this);
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vLEGSEXO") == 0 )
         {
            AV35PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvlegsexoMD2( AV35PaiCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vLEGSUCCODIGO") == 0 )
         {
            AV6CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
            AV10EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10EmpCod), "ZZZ9")));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvlegsuccodigoMD2( AV6CliCod, AV10EmpCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vLEGACTCODIGO") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvlegactcodigoMD2( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vMPRCOD") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvmprcodMD2( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vZONCOD") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvzoncodMD2( ) ;
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
            AV6CliCod = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV10EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV10EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10EmpCod), "ZZZ9")));
               AV26LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV26LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26LegNumero), 8, 0));
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
      paMD2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startMD2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.legajofiltros", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV6CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV26LegNumero,8,0))}, new String[] {"CliCod","EmpCod","LegNumero"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV51Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFILTERFULLTEXT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11FilterFullText, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10EmpCod), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV9DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV9DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGSINCOD_DATA", AV32LegSinCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGSINCOD_DATA", AV32LegSinCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGCATCODIGO_DATA", AV20LegCatCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGCATCODIGO_DATA", AV20LegCatCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGSECCODIGO_DATA", AV42LegSecCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGSECCODIGO_DATA", AV42LegSecCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGPUESCODIGO_DATA", AV43LegPuesCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGPUESCODIGO_DATA", AV43LegPuesCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGCONVECODIGO_DATA", AV23LegConveCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGCONVECODIGO_DATA", AV23LegConveCodigo_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV51Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV51Pgmname, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vFILTERFULLTEXT", AV11FilterFullText);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFILTERFULLTEXT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11FilterFullText, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGSINCOD", AV31LegSinCod);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGSINCOD", AV31LegSinCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGCONVECODIGO", AV22LegConveCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGCONVECODIGO", AV22LegConveCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGCATCODIGO", AV19LegCatCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGCATCODIGO", AV19LegCatCodigo);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV26LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGPUESCODIGO", AV27LegPuesCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGPUESCODIGO", AV27LegPuesCodigo);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV35PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV6CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV10EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Cls", GXutil.rtrim( Combo_legsincod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Selectedvalue_set", GXutil.rtrim( Combo_legsincod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Selectedvalue_get", GXutil.rtrim( Combo_legsincod_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Allowmultipleselection", GXutil.booltostr( Combo_legsincod_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Includeonlyselectedoption", GXutil.booltostr( Combo_legsincod_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Emptyitem", GXutil.booltostr( Combo_legsincod_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Multiplevaluestype", GXutil.rtrim( Combo_legsincod_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Cls", GXutil.rtrim( Combo_legcatcodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_legcatcodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legcatcodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Allowmultipleselection", GXutil.booltostr( Combo_legcatcodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_legcatcodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Emptyitem", GXutil.booltostr( Combo_legcatcodigo_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Multiplevaluestype", GXutil.rtrim( Combo_legcatcodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Cls", GXutil.rtrim( Combo_legseccodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_legseccodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legseccodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Allowmultipleselection", GXutil.booltostr( Combo_legseccodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_legseccodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Emptyitem", GXutil.booltostr( Combo_legseccodigo_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Multiplevaluestype", GXutil.rtrim( Combo_legseccodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Emptyitemtext", GXutil.rtrim( Combo_legseccodigo_Emptyitemtext));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Cls", GXutil.rtrim( Combo_legpuescodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_legpuescodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Allowmultipleselection", GXutil.booltostr( Combo_legpuescodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_legpuescodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Emptyitem", GXutil.booltostr( Combo_legpuescodigo_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Multiplevaluestype", GXutil.rtrim( Combo_legpuescodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Cls", GXutil.rtrim( Combo_legconvecodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Selectedvalue_set", GXutil.rtrim( Combo_legconvecodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legconvecodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Allowmultipleselection", GXutil.booltostr( Combo_legconvecodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_legconvecodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Emptyitem", GXutil.booltostr( Combo_legconvecodigo_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Multiplevaluestype", GXutil.rtrim( Combo_legconvecodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legseccodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legpuescodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legconvecodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legcatcodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Selectedvalue_get", GXutil.rtrim( Combo_legsincod_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legseccodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legpuescodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legconvecodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Selectedvalue_get", GXutil.rtrim( Combo_legsincod_Selectedvalue_get));
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
         weMD2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtMD2( ) ;
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
      return formatLink("web.legajofiltros", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV6CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV26LegNumero,8,0))}, new String[] {"CliCod","EmpCod","LegNumero"})  ;
   }

   public String getPgmname( )
   {
      return "LegajoFiltros" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Filtros", "") ;
   }

   public void wbMD0( )
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
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableLegajosFiltro", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecolumna1_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelegsexo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklegsexo_Internalname, httpContext.getMessage( "Género", ""), "", "", lblTextblocklegsexo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavLegsexo.getInternalname(), httpContext.getMessage( "Leg Sexo", ""), "col-sm-3 AttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavLegsexo, dynavLegsexo.getInternalname(), GXutil.trim( GXutil.str( AV29LegSexo, 2, 0)), 1, dynavLegsexo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavLegsexo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,19);\"", "", true, (byte)(0), "HLP_LegajoFiltros.htm");
         dynavLegsexo.setValue( GXutil.trim( GXutil.str( AV29LegSexo, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegsexo.getInternalname(), "Values", dynavLegsexo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelegmodtra_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklegmodtra_Internalname, httpContext.getMessage( "Relación laboral", ""), "", "", lblTextblocklegmodtra_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLegmodtra.getInternalname(), httpContext.getMessage( "Leg Mod Tra", ""), "col-sm-3 AttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLegmodtra, cmbavLegmodtra.getInternalname(), GXutil.rtrim( AV47LegModTra), 1, cmbavLegmodtra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavLegmodtra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "", true, (byte)(0), "HLP_LegajoFiltros.htm");
         cmbavLegmodtra.setValue( GXutil.rtrim( AV47LegModTra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegmodtra.getInternalname(), "Values", cmbavLegmodtra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLegtipotarifa.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLegtipotarifa.getInternalname(), httpContext.getMessage( "Tipo de tarifa", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLegtipotarifa, cmbavLegtipotarifa.getInternalname(), GXutil.rtrim( AV48LegTipoTarifa), 1, cmbavLegtipotarifa.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavLegtipotarifa.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "", true, (byte)(0), "HLP_LegajoFiltros.htm");
         cmbavLegtipotarifa.setValue( GXutil.rtrim( AV48LegTipoTarifa) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegtipotarifa.getInternalname(), "Values", cmbavLegtipotarifa.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelegclase_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklegclase_Internalname, httpContext.getMessage( "Frecuencia de pago", ""), "", "", lblTextblocklegclase_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLegclase.getInternalname(), httpContext.getMessage( "Leg Clase", ""), "col-sm-3 AttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLegclase, cmbavLegclase.getInternalname(), GXutil.trim( GXutil.str( AV21LegClase, 1, 0)), 1, cmbavLegclase.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavLegclase.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "", true, (byte)(0), "HLP_LegajoFiltros.htm");
         cmbavLegclase.setValue( GXutil.trim( GXutil.str( AV21LegClase, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegclase.getInternalname(), "Values", cmbavLegclase.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop ExtendedComboCell", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegsincod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_legsincod_Internalname, httpContext.getMessage( "Sindicato", ""), "", "", lblTextblockcombo_legsincod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_legsincod.setProperty("Caption", Combo_legsincod_Caption);
         ucCombo_legsincod.setProperty("Cls", Combo_legsincod_Cls);
         ucCombo_legsincod.setProperty("AllowMultipleSelection", Combo_legsincod_Allowmultipleselection);
         ucCombo_legsincod.setProperty("IncludeOnlySelectedOption", Combo_legsincod_Includeonlyselectedoption);
         ucCombo_legsincod.setProperty("EmptyItem", Combo_legsincod_Emptyitem);
         ucCombo_legsincod.setProperty("MultipleValuesType", Combo_legsincod_Multiplevaluestype);
         ucCombo_legsincod.setProperty("DropDownOptionsTitleSettingsIcons", AV9DDO_TitleSettingsIcons);
         ucCombo_legsincod.setProperty("DropDownOptionsData", AV32LegSinCod_Data);
         ucCombo_legsincod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legsincod_Internalname, "COMBO_LEGSINCODContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableconveniofiltro_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockconveniofiltro_Internalname, httpContext.getMessage( "Convenio", ""), "", "", lblTextblockconveniofiltro_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConveniofiltro.getInternalname(), httpContext.getMessage( "Convenio Filtro", ""), "col-sm-3 AttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConveniofiltro, cmbavConveniofiltro.getInternalname(), GXutil.rtrim( AV8ConvenioFiltro), 1, cmbavConveniofiltro.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavConveniofiltro.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "", true, (byte)(0), "HLP_LegajoFiltros.htm");
         cmbavConveniofiltro.setValue( GXutil.rtrim( AV8ConvenioFiltro) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavConveniofiltro.getInternalname(), "Values", cmbavConveniofiltro.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop ExtendedComboCell", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegcatcodigo_Internalname, divTablesplittedlegcatcodigo_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_legcatcodigo_Internalname, httpContext.getMessage( "Categorías", ""), "", "", lblTextblockcombo_legcatcodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_legcatcodigo.setProperty("Caption", Combo_legcatcodigo_Caption);
         ucCombo_legcatcodigo.setProperty("Cls", Combo_legcatcodigo_Cls);
         ucCombo_legcatcodigo.setProperty("AllowMultipleSelection", Combo_legcatcodigo_Allowmultipleselection);
         ucCombo_legcatcodigo.setProperty("IncludeOnlySelectedOption", Combo_legcatcodigo_Includeonlyselectedoption);
         ucCombo_legcatcodigo.setProperty("EmptyItem", Combo_legcatcodigo_Emptyitem);
         ucCombo_legcatcodigo.setProperty("MultipleValuesType", Combo_legcatcodigo_Multiplevaluestype);
         ucCombo_legcatcodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV9DDO_TitleSettingsIcons);
         ucCombo_legcatcodigo.setProperty("DropDownOptionsData", AV20LegCatCodigo_Data);
         ucCombo_legcatcodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legcatcodigo_Internalname, "COMBO_LEGCATCODIGOContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelegsuccodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklegsuccodigo_Internalname, httpContext.getMessage( "Sucursal", ""), "", "", lblTextblocklegsuccodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavLegsuccodigo.getInternalname(), httpContext.getMessage( "Leg Suc Codigo", ""), "col-sm-3 AttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavLegsuccodigo, dynavLegsuccodigo.getInternalname(), GXutil.rtrim( AV33LegSucCodigo), 1, dynavLegsuccodigo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavLegsuccodigo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "", true, (byte)(0), "HLP_LegajoFiltros.htm");
         dynavLegsuccodigo.setValue( GXutil.rtrim( AV33LegSucCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegsuccodigo.getInternalname(), "Values", dynavLegsuccodigo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelegfecingreso_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklegfecingreso_Internalname, httpContext.getMessage( "Fecha de Ingreso", ""), "", "", lblTextblocklegfecingreso_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLegfecingreso_Internalname, httpContext.getMessage( "Leg Fec Ingreso", ""), "col-sm-3 AttributeDateLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavLegfecingreso_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegfecingreso_Internalname, localUtil.format(AV25LegFecIngreso, "99/99/9999"), localUtil.format( AV25LegFecIngreso, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,77);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegfecingreso_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavLegfecingreso_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavLegfecingreso_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavLegfecingreso_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LegajoFiltros.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelegfecegreso_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklegfecegreso_Internalname, httpContext.getMessage( "Fecha de Egreso", ""), "", "", lblTextblocklegfecegreso_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLegfecegreso_Internalname, httpContext.getMessage( "Leg Fec Egreso", ""), "col-sm-3 AttributeDateLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavLegfecegreso_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegfecegreso_Internalname, localUtil.format(AV24LegFecEgreso, "99/99/9999"), localUtil.format( AV24LegFecEgreso, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,85);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegfecegreso_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavLegfecegreso_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavLegfecegreso_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavLegfecegreso_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LegajoFiltros.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecolumna2_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop ExtendedComboCell", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegseccodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_legseccodigo_Internalname, httpContext.getMessage( "Áreas", ""), "", "", lblTextblockcombo_legseccodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_legseccodigo.setProperty("Caption", Combo_legseccodigo_Caption);
         ucCombo_legseccodigo.setProperty("Cls", Combo_legseccodigo_Cls);
         ucCombo_legseccodigo.setProperty("AllowMultipleSelection", Combo_legseccodigo_Allowmultipleselection);
         ucCombo_legseccodigo.setProperty("IncludeOnlySelectedOption", Combo_legseccodigo_Includeonlyselectedoption);
         ucCombo_legseccodigo.setProperty("MultipleValuesType", Combo_legseccodigo_Multiplevaluestype);
         ucCombo_legseccodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV9DDO_TitleSettingsIcons);
         ucCombo_legseccodigo.setProperty("DropDownOptionsData", AV42LegSecCodigo_Data);
         ucCombo_legseccodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legseccodigo_Internalname, "COMBO_LEGSECCODIGOContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop ExtendedComboCell", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegpuescodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_legpuescodigo_Internalname, httpContext.getMessage( "Puestos", ""), "", "", lblTextblockcombo_legpuescodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_legpuescodigo.setProperty("Caption", Combo_legpuescodigo_Caption);
         ucCombo_legpuescodigo.setProperty("Cls", Combo_legpuescodigo_Cls);
         ucCombo_legpuescodigo.setProperty("AllowMultipleSelection", Combo_legpuescodigo_Allowmultipleselection);
         ucCombo_legpuescodigo.setProperty("IncludeOnlySelectedOption", Combo_legpuescodigo_Includeonlyselectedoption);
         ucCombo_legpuescodigo.setProperty("EmptyItem", Combo_legpuescodigo_Emptyitem);
         ucCombo_legpuescodigo.setProperty("MultipleValuesType", Combo_legpuescodigo_Multiplevaluestype);
         ucCombo_legpuescodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV9DDO_TitleSettingsIcons);
         ucCombo_legpuescodigo.setProperty("DropDownOptionsData", AV43LegPuesCodigo_Data);
         ucCombo_legpuescodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legpuescodigo_Internalname, "COMBO_LEGPUESCODIGOContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelegactcodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklegactcodigo_Internalname, httpContext.getMessage( "Actividad AFIP", ""), "", "", lblTextblocklegactcodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavLegactcodigo.getInternalname(), httpContext.getMessage( "Leg Act Codigo", ""), "col-sm-3 AttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavLegactcodigo, dynavLegactcodigo.getInternalname(), GXutil.rtrim( AV18LegActCodigo), 1, dynavLegactcodigo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavLegactcodigo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,109);\"", "", true, (byte)(0), "HLP_LegajoFiltros.htm");
         dynavLegactcodigo.setValue( GXutil.rtrim( AV18LegActCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegactcodigo.getInternalname(), "Values", dynavLegactcodigo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop ExtendedComboCell", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegconvecodigo_Internalname, divTablesplittedlegconvecodigo_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_legconvecodigo_Internalname, httpContext.getMessage( "Seleccionar convenios", ""), "", "", lblTextblockcombo_legconvecodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_legconvecodigo.setProperty("Caption", Combo_legconvecodigo_Caption);
         ucCombo_legconvecodigo.setProperty("Cls", Combo_legconvecodigo_Cls);
         ucCombo_legconvecodigo.setProperty("AllowMultipleSelection", Combo_legconvecodigo_Allowmultipleselection);
         ucCombo_legconvecodigo.setProperty("IncludeOnlySelectedOption", Combo_legconvecodigo_Includeonlyselectedoption);
         ucCombo_legconvecodigo.setProperty("EmptyItem", Combo_legconvecodigo_Emptyitem);
         ucCombo_legconvecodigo.setProperty("MultipleValuesType", Combo_legconvecodigo_Multiplevaluestype);
         ucCombo_legconvecodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV9DDO_TitleSettingsIcons);
         ucCombo_legconvecodigo.setProperty("DropDownOptionsData", AV23LegConveCodigo_Data);
         ucCombo_legconvecodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legconvecodigo_Internalname, "COMBO_LEGCONVECODIGOContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablemprcod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmprcod_Internalname, httpContext.getMessage( "Modalidad AFIP", ""), "", "", lblTextblockmprcod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavMprcod.getInternalname(), httpContext.getMessage( "Mpr Cod", ""), "col-sm-3 AttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavMprcod, dynavMprcod.getInternalname(), GXutil.rtrim( AV34MprCod), 1, dynavMprcod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavMprcod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,124);\"", "", true, (byte)(0), "HLP_LegajoFiltros.htm");
         dynavMprcod.setValue( GXutil.rtrim( AV34MprCod) );
         httpContext.ajax_rsp_assign_prop("", false, dynavMprcod.getInternalname(), "Values", dynavMprcod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablezoncod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockzoncod_Internalname, httpContext.getMessage( "Zona AFIP", ""), "", "", lblTextblockzoncod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavZoncod.getInternalname(), httpContext.getMessage( "Zon Cod", ""), "col-sm-3 AttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 132,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavZoncod, dynavZoncod.getInternalname(), GXutil.rtrim( AV39ZonCod), 1, dynavZoncod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavZoncod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,132);\"", "", true, (byte)(0), "HLP_LegajoFiltros.htm");
         dynavZoncod.setValue( GXutil.rtrim( AV39ZonCod) );
         httpContext.ajax_rsp_assign_prop("", false, dynavZoncod.getInternalname(), "Values", dynavZoncod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelegestado_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklegestado_Internalname, httpContext.getMessage( "Estado", ""), "", "", lblTextblocklegestado_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLegestado.getInternalname(), httpContext.getMessage( "Leg Estado", ""), "col-sm-3 AttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 140,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLegestado, cmbavLegestado.getInternalname(), GXutil.trim( GXutil.str( AV44LegEstado, 1, 0)), 1, cmbavLegestado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavLegestado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,140);\"", "", true, (byte)(0), "HLP_LegajoFiltros.htm");
         cmbavLegestado.setValue( GXutil.trim( GXutil.str( AV44LegEstado, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegestado.getInternalname(), "Values", cmbavLegestado.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DscTop", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablelegincompleto_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklegincompleto_Internalname, httpContext.getMessage( "Solo legajos con datos incompletos", ""), "", "", lblTextblocklegincompleto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavLegincompleto.getInternalname(), httpContext.getMessage( "Leg Incompleto", ""), "col-sm-3 AttributeCheckBoxLabel", 0, true, "");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 148,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavLegincompleto.getInternalname(), GXutil.booltostr( AV45LegIncompleto), "", httpContext.getMessage( "Leg Incompleto", ""), 1, chkavLegincompleto.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(148, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,148);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Right", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group mb20 MR30", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 156,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseraction1_Internalname, "", httpContext.getMessage( "Limpiar Filtros", ""), bttBtnuseraction1_Jsonclick, 5, httpContext.getMessage( "Limpiar Filtros", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUSERACTION1\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 158,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnconfirmar_Internalname, "", httpContext.getMessage( "Aplicar Filtros", ""), bttBtnconfirmar_Jsonclick, 5, httpContext.getMessage( "Aplicar Filtros", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCONFIRMAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LegajoFiltros.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "Right", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startMD2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Filtros", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupMD0( ) ;
   }

   public void wsMD2( )
   {
      startMD2( ) ;
      evtMD2( ) ;
   }

   public void evtMD2( )
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
                        else if ( GXutil.strcmp(sEvt, "COMBO_LEGSINCOD.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11MD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_LEGSECCODIGO.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12MD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_LEGCONVECODIGO.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13MD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e14MD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOUSERACTION1'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUserAction1' */
                           e15MD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCONFIRMAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoConfirmar' */
                           e16MD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e17MD2 ();
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

   public void weMD2( )
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

   public void paMD2( )
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
            GX_FocusControl = dynavLegsexo.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvvlegsexoMD2( short AV35PaiCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvlegsexo_dataMD2( AV35PaiCod) ;
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

   public void gxvvlegsexo_htmlMD2( short AV35PaiCod )
   {
      byte gxdynajaxvalue;
      gxdlvvlegsexo_dataMD2( AV35PaiCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavLegsexo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (byte)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavLegsexo.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 2, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvlegsexo_dataMD2( short AV35PaiCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "(Todos)", ""));
      /* Using cursor H00MD2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV35PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00MD2_A1743SexoId[0], (byte)(2), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00MD2_A1744SexoNombre[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvvlegsuccodigoMD2( int AV6CliCod ,
                                      short AV10EmpCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvlegsuccodigo_dataMD2( AV6CliCod, AV10EmpCod) ;
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

   public void gxvvlegsuccodigo_htmlMD2( int AV6CliCod ,
                                         short AV10EmpCod )
   {
      String gxdynajaxvalue;
      gxdlvvlegsuccodigo_dataMD2( AV6CliCod, AV10EmpCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavLegsuccodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavLegsuccodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvlegsuccodigo_dataMD2( int AV6CliCod ,
                                              short AV10EmpCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "(Todas)", ""));
      /* Using cursor H00MD3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV6CliCod), Short.valueOf(AV10EmpCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00MD3_A1243SucCodigo[0]));
         gxdynajaxctrldescr.add(H00MD3_A1244SucDescrip[0]);
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxdlvvlegactcodigoMD2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvlegactcodigo_dataMD2( ) ;
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

   public void gxvvlegactcodigo_htmlMD2( )
   {
      String gxdynajaxvalue;
      gxdlvvlegactcodigo_dataMD2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavLegactcodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavLegactcodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvlegactcodigo_dataMD2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "(Todas)", ""));
      /* Using cursor H00MD4 */
      pr_default.execute(2);
      while ( (pr_default.getStatus(2) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00MD4_A43ActCodigo[0]));
         gxdynajaxctrldescr.add(H00MD4_A108ActDescrip[0]);
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void gxdlvvmprcodMD2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvmprcod_dataMD2( ) ;
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

   public void gxvvmprcod_htmlMD2( )
   {
      String gxdynajaxvalue;
      gxdlvvmprcod_dataMD2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavMprcod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavMprcod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvmprcod_dataMD2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "(Todas)", ""));
      /* Using cursor H00MD5 */
      pr_default.execute(3);
      while ( (pr_default.getStatus(3) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00MD5_A18MprCod[0]));
         gxdynajaxctrldescr.add(H00MD5_A303MprDescrip[0]);
         pr_default.readNext(3);
      }
      pr_default.close(3);
   }

   public void gxdlvvzoncodMD2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvzoncod_dataMD2( ) ;
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

   public void gxvvzoncod_htmlMD2( )
   {
      String gxdynajaxvalue;
      gxdlvvzoncod_dataMD2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavZoncod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavZoncod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvzoncod_dataMD2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "(Todas)", ""));
      /* Using cursor H00MD6 */
      pr_default.execute(4);
      while ( (pr_default.getStatus(4) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00MD6_A20ZonCod[0]));
         gxdynajaxctrldescr.add(H00MD6_A342ZonDescrip[0]);
         pr_default.readNext(4);
      }
      pr_default.close(4);
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         gxvvlegactcodigo_htmlMD2( ) ;
         gxvvmprcod_htmlMD2( ) ;
         gxvvzoncod_htmlMD2( ) ;
         gxvvlegsuccodigo_htmlMD2( AV6CliCod, AV10EmpCod) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynavLegsexo.getItemCount() > 0 )
      {
         AV29LegSexo = (byte)(GXutil.lval( dynavLegsexo.getValidValue(GXutil.trim( GXutil.str( AV29LegSexo, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29LegSexo), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavLegsexo.setValue( GXutil.trim( GXutil.str( AV29LegSexo, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegsexo.getInternalname(), "Values", dynavLegsexo.ToJavascriptSource(), true);
      }
      if ( cmbavLegmodtra.getItemCount() > 0 )
      {
         AV47LegModTra = cmbavLegmodtra.getValidValue(AV47LegModTra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47LegModTra", AV47LegModTra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLegmodtra.setValue( GXutil.rtrim( AV47LegModTra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegmodtra.getInternalname(), "Values", cmbavLegmodtra.ToJavascriptSource(), true);
      }
      if ( cmbavLegtipotarifa.getItemCount() > 0 )
      {
         AV48LegTipoTarifa = cmbavLegtipotarifa.getValidValue(AV48LegTipoTarifa) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48LegTipoTarifa", AV48LegTipoTarifa);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLegtipotarifa.setValue( GXutil.rtrim( AV48LegTipoTarifa) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegtipotarifa.getInternalname(), "Values", cmbavLegtipotarifa.ToJavascriptSource(), true);
      }
      if ( cmbavLegclase.getItemCount() > 0 )
      {
         AV21LegClase = (byte)(GXutil.lval( cmbavLegclase.getValidValue(GXutil.trim( GXutil.str( AV21LegClase, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21LegClase", GXutil.str( AV21LegClase, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLegclase.setValue( GXutil.trim( GXutil.str( AV21LegClase, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegclase.getInternalname(), "Values", cmbavLegclase.ToJavascriptSource(), true);
      }
      if ( cmbavConveniofiltro.getItemCount() > 0 )
      {
         AV8ConvenioFiltro = cmbavConveniofiltro.getValidValue(AV8ConvenioFiltro) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8ConvenioFiltro", AV8ConvenioFiltro);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConveniofiltro.setValue( GXutil.rtrim( AV8ConvenioFiltro) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavConveniofiltro.getInternalname(), "Values", cmbavConveniofiltro.ToJavascriptSource(), true);
      }
      if ( dynavLegsuccodigo.getItemCount() > 0 )
      {
         AV33LegSucCodigo = dynavLegsuccodigo.getValidValue(AV33LegSucCodigo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33LegSucCodigo", AV33LegSucCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavLegsuccodigo.setValue( GXutil.rtrim( AV33LegSucCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegsuccodigo.getInternalname(), "Values", dynavLegsuccodigo.ToJavascriptSource(), true);
      }
      if ( dynavLegactcodigo.getItemCount() > 0 )
      {
         AV18LegActCodigo = dynavLegactcodigo.getValidValue(AV18LegActCodigo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18LegActCodigo", AV18LegActCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavLegactcodigo.setValue( GXutil.rtrim( AV18LegActCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegactcodigo.getInternalname(), "Values", dynavLegactcodigo.ToJavascriptSource(), true);
      }
      if ( dynavMprcod.getItemCount() > 0 )
      {
         AV34MprCod = dynavMprcod.getValidValue(AV34MprCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34MprCod", AV34MprCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavMprcod.setValue( GXutil.rtrim( AV34MprCod) );
         httpContext.ajax_rsp_assign_prop("", false, dynavMprcod.getInternalname(), "Values", dynavMprcod.ToJavascriptSource(), true);
      }
      if ( dynavZoncod.getItemCount() > 0 )
      {
         AV39ZonCod = dynavZoncod.getValidValue(AV39ZonCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39ZonCod", AV39ZonCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavZoncod.setValue( GXutil.rtrim( AV39ZonCod) );
         httpContext.ajax_rsp_assign_prop("", false, dynavZoncod.getInternalname(), "Values", dynavZoncod.ToJavascriptSource(), true);
      }
      if ( cmbavLegestado.getItemCount() > 0 )
      {
         AV44LegEstado = (byte)(GXutil.lval( cmbavLegestado.getValidValue(GXutil.trim( GXutil.str( AV44LegEstado, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44LegEstado", GXutil.str( AV44LegEstado, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLegestado.setValue( GXutil.trim( GXutil.str( AV44LegEstado, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegestado.getInternalname(), "Values", cmbavLegestado.ToJavascriptSource(), true);
      }
      AV45LegIncompleto = GXutil.strtobool( GXutil.booltostr( AV45LegIncompleto)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45LegIncompleto", AV45LegIncompleto);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfMD2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV51Pgmname = "LegajoFiltros" ;
      Gx_err = (short)(0) ;
   }

   public void rfMD2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e17MD2 ();
         wbMD0( ) ;
      }
   }

   public void send_integrity_lvl_hashesMD2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV6CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV51Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV51Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vFILTERFULLTEXT", AV11FilterFullText);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFILTERFULLTEXT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11FilterFullText, ""))));
   }

   public void before_start_formulas( )
   {
      AV51Pgmname = "LegajoFiltros" ;
      Gx_err = (short)(0) ;
      gxvvlegactcodigo_htmlMD2( ) ;
      gxvvmprcod_htmlMD2( ) ;
      gxvvzoncod_htmlMD2( ) ;
      gxvvlegsuccodigo_htmlMD2( AV6CliCod, AV10EmpCod) ;
      fix_multi_value_controls( ) ;
   }

   public void strupMD0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e14MD2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      gxvvlegsexo_htmlMD2( AV35PaiCod) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV9DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGSINCOD_DATA"), AV32LegSinCod_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGCATCODIGO_DATA"), AV20LegCatCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGSECCODIGO_DATA"), AV42LegSecCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGPUESCODIGO_DATA"), AV43LegPuesCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGCONVECODIGO_DATA"), AV23LegConveCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGCATCODIGO"), AV19LegCatCodigo);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGPUESCODIGO"), AV27LegPuesCodigo);
         /* Read saved values. */
         Combo_legsincod_Cls = httpContext.cgiGet( "COMBO_LEGSINCOD_Cls") ;
         Combo_legsincod_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGSINCOD_Selectedvalue_set") ;
         Combo_legsincod_Selectedvalue_get = httpContext.cgiGet( "COMBO_LEGSINCOD_Selectedvalue_get") ;
         Combo_legsincod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGSINCOD_Allowmultipleselection")) ;
         Combo_legsincod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGSINCOD_Includeonlyselectedoption")) ;
         Combo_legsincod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGSINCOD_Emptyitem")) ;
         Combo_legsincod_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGSINCOD_Multiplevaluestype") ;
         Combo_legcatcodigo_Cls = httpContext.cgiGet( "COMBO_LEGCATCODIGO_Cls") ;
         Combo_legcatcodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGCATCODIGO_Selectedvalue_set") ;
         Combo_legcatcodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_LEGCATCODIGO_Selectedvalue_get") ;
         Combo_legcatcodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGCATCODIGO_Allowmultipleselection")) ;
         Combo_legcatcodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGCATCODIGO_Includeonlyselectedoption")) ;
         Combo_legcatcodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGCATCODIGO_Emptyitem")) ;
         Combo_legcatcodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGCATCODIGO_Multiplevaluestype") ;
         Combo_legseccodigo_Cls = httpContext.cgiGet( "COMBO_LEGSECCODIGO_Cls") ;
         Combo_legseccodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGSECCODIGO_Selectedvalue_set") ;
         Combo_legseccodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_LEGSECCODIGO_Selectedvalue_get") ;
         Combo_legseccodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGSECCODIGO_Allowmultipleselection")) ;
         Combo_legseccodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGSECCODIGO_Includeonlyselectedoption")) ;
         Combo_legseccodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGSECCODIGO_Emptyitem")) ;
         Combo_legseccodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGSECCODIGO_Multiplevaluestype") ;
         Combo_legseccodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_LEGSECCODIGO_Emptyitemtext") ;
         Combo_legpuescodigo_Cls = httpContext.cgiGet( "COMBO_LEGPUESCODIGO_Cls") ;
         Combo_legpuescodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGPUESCODIGO_Selectedvalue_set") ;
         Combo_legpuescodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGPUESCODIGO_Allowmultipleselection")) ;
         Combo_legpuescodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGPUESCODIGO_Includeonlyselectedoption")) ;
         Combo_legpuescodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGPUESCODIGO_Emptyitem")) ;
         Combo_legpuescodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGPUESCODIGO_Multiplevaluestype") ;
         Combo_legconvecodigo_Cls = httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Cls") ;
         Combo_legconvecodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Selectedvalue_set") ;
         Combo_legconvecodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Selectedvalue_get") ;
         Combo_legconvecodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Allowmultipleselection")) ;
         Combo_legconvecodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Includeonlyselectedoption")) ;
         Combo_legconvecodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Emptyitem")) ;
         Combo_legconvecodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Multiplevaluestype") ;
         Combo_legseccodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_LEGSECCODIGO_Selectedvalue_get") ;
         Combo_legpuescodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_LEGPUESCODIGO_Selectedvalue_get") ;
         Combo_legconvecodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Selectedvalue_get") ;
         Combo_legsincod_Selectedvalue_get = httpContext.cgiGet( "COMBO_LEGSINCOD_Selectedvalue_get") ;
         /* Read variables values. */
         dynavLegsexo.setValue( httpContext.cgiGet( dynavLegsexo.getInternalname()) );
         AV29LegSexo = (byte)(GXutil.lval( httpContext.cgiGet( dynavLegsexo.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29LegSexo), 2, 0));
         cmbavLegmodtra.setValue( httpContext.cgiGet( cmbavLegmodtra.getInternalname()) );
         AV47LegModTra = httpContext.cgiGet( cmbavLegmodtra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47LegModTra", AV47LegModTra);
         cmbavLegtipotarifa.setValue( httpContext.cgiGet( cmbavLegtipotarifa.getInternalname()) );
         AV48LegTipoTarifa = httpContext.cgiGet( cmbavLegtipotarifa.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48LegTipoTarifa", AV48LegTipoTarifa);
         cmbavLegclase.setValue( httpContext.cgiGet( cmbavLegclase.getInternalname()) );
         AV21LegClase = (byte)(GXutil.lval( httpContext.cgiGet( cmbavLegclase.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21LegClase", GXutil.str( AV21LegClase, 1, 0));
         cmbavConveniofiltro.setValue( httpContext.cgiGet( cmbavConveniofiltro.getInternalname()) );
         AV8ConvenioFiltro = httpContext.cgiGet( cmbavConveniofiltro.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8ConvenioFiltro", AV8ConvenioFiltro);
         dynavLegsuccodigo.setValue( httpContext.cgiGet( dynavLegsuccodigo.getInternalname()) );
         AV33LegSucCodigo = httpContext.cgiGet( dynavLegsuccodigo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33LegSucCodigo", AV33LegSucCodigo);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavLegfecingreso_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vLEGFECINGRESO");
            GX_FocusControl = edtavLegfecingreso_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV25LegFecIngreso = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25LegFecIngreso", localUtil.format(AV25LegFecIngreso, "99/99/9999"));
         }
         else
         {
            AV25LegFecIngreso = localUtil.ctod( httpContext.cgiGet( edtavLegfecingreso_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25LegFecIngreso", localUtil.format(AV25LegFecIngreso, "99/99/9999"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavLegfecegreso_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vLEGFECEGRESO");
            GX_FocusControl = edtavLegfecegreso_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV24LegFecEgreso = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24LegFecEgreso", localUtil.format(AV24LegFecEgreso, "99/99/9999"));
         }
         else
         {
            AV24LegFecEgreso = localUtil.ctod( httpContext.cgiGet( edtavLegfecegreso_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24LegFecEgreso", localUtil.format(AV24LegFecEgreso, "99/99/9999"));
         }
         dynavLegactcodigo.setValue( httpContext.cgiGet( dynavLegactcodigo.getInternalname()) );
         AV18LegActCodigo = httpContext.cgiGet( dynavLegactcodigo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18LegActCodigo", AV18LegActCodigo);
         dynavMprcod.setValue( httpContext.cgiGet( dynavMprcod.getInternalname()) );
         AV34MprCod = httpContext.cgiGet( dynavMprcod.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34MprCod", AV34MprCod);
         dynavZoncod.setValue( httpContext.cgiGet( dynavZoncod.getInternalname()) );
         AV39ZonCod = httpContext.cgiGet( dynavZoncod.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39ZonCod", AV39ZonCod);
         cmbavLegestado.setValue( httpContext.cgiGet( cmbavLegestado.getInternalname()) );
         AV44LegEstado = (byte)(GXutil.lval( httpContext.cgiGet( cmbavLegestado.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44LegEstado", GXutil.str( AV44LegEstado, 1, 0));
         AV45LegIncompleto = GXutil.strtobool( httpContext.cgiGet( chkavLegincompleto.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45LegIncompleto", AV45LegIncompleto);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         gxvvlegactcodigo_htmlMD2( ) ;
         gxvvmprcod_htmlMD2( ) ;
         gxvvzoncod_htmlMD2( ) ;
         gxvvlegsuccodigo_htmlMD2( AV6CliCod, AV10EmpCod) ;
         gxvvlegsexo_htmlMD2( AV35PaiCod) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e14MD2 ();
      if (returnInSub) return;
   }

   public void e14MD2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV35PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV6CliCod, GXv_int2) ;
      legajofiltros_impl.this.GXt_int1 = GXv_int2[0] ;
      AV35PaiCod = GXt_int1 ;
      GXt_char3 = AV5ActComCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.empresagetactcomercial(remoteHandle, context).execute( AV6CliCod, AV10EmpCod, GXv_char4) ;
      legajofiltros_impl.this.GXt_char3 = GXv_char4[0] ;
      AV5ActComCodigo = GXt_char3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5ActComCodigo", AV5ActComCodigo);
      if ( GXutil.strcmp(AV46httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV51Pgmname, "1") ;
         /* Execute user subroutine: 'INICIALIZAR FILTROS VACIOS' */
         S112 ();
         if (returnInSub) return;
         if ( GXutil.strcmp(AV38Session.getValue(httpContext.getMessage( "LegajosWWGridState", "")), "") == 0 )
         {
            AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( httpContext.getMessage( "LegajosWWGridState", "")), null, null);
         }
         else
         {
            AV12GridState.fromxml(AV38Session.getValue(httpContext.getMessage( "LegajosWWGridState", "")), null, null);
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV51Pgmname, httpContext.getMessage( "&GridState ", "")+AV12GridState.toJSonString(false, true)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV51Pgmname, httpContext.getMessage( "&LegClase ", "")+GXutil.trim( GXutil.str( AV21LegClase, 1, 0))) ;
         AV52GXV1 = 1 ;
         while ( AV52GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
         {
            AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV52GXV1));
            if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
            {
               AV11FilterFullText = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11FilterFullText", AV11FilterFullText);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFILTERFULLTEXT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11FilterFullText, ""))));
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGSEXO") == 0 )
            {
               AV29LegSexo = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV29LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29LegSexo), 2, 0));
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGCLASE") == 0 )
            {
               AV21LegClase = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV21LegClase", GXutil.str( AV21LegClase, 1, 0));
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGMODTRA") == 0 )
            {
               AV47LegModTra = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV47LegModTra", AV47LegModTra);
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGTIPOTARIFA") == 0 )
            {
               AV48LegTipoTarifa = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV48LegTipoTarifa", AV48LegTipoTarifa);
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "CONVENIOFILTRO") == 0 )
            {
               AV8ConvenioFiltro = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV8ConvenioFiltro", AV8ConvenioFiltro);
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGSINCOD") == 0 )
            {
               AV31LegSinCod.fromJSonString(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), null);
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGCONVECODIGO") == 0 )
            {
               AV22LegConveCodigo.fromJSonString(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), null);
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGCATCODIGO") == 0 )
            {
               AV19LegCatCodigo.fromJSonString(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), null);
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGFECINGRESO") == 0 )
            {
               AV25LegFecIngreso = localUtil.ctod( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV25LegFecIngreso", localUtil.format(AV25LegFecIngreso, "99/99/9999"));
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGFECEGRESO") == 0 )
            {
               AV24LegFecEgreso = localUtil.ctod( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV24LegFecEgreso", localUtil.format(AV24LegFecEgreso, "99/99/9999"));
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGSECCODIGO") == 0 )
            {
               AV28LegSecCodigo.fromJSonString(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), null);
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGPUESCODIGO") == 0 )
            {
               AV27LegPuesCodigo.fromJSonString(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), null);
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGACTCODIGO") == 0 )
            {
               AV18LegActCodigo = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV18LegActCodigo", AV18LegActCodigo);
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "MPRCOD") == 0 )
            {
               AV34MprCod = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV34MprCod", AV34MprCod);
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "ZONCOD") == 0 )
            {
               AV39ZonCod = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV39ZonCod", AV39ZonCod);
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGSUCCODIGO") == 0 )
            {
               AV33LegSucCodigo = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV33LegSucCodigo", AV33LegSucCodigo);
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGESTADO") == 0 )
            {
               AV44LegEstado = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV44LegEstado", GXutil.str( AV44LegEstado, 1, 0));
            }
            else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGINCOMPLETO") == 0 )
            {
               AV45LegIncompleto = GXutil.boolval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV45LegIncompleto", AV45LegIncompleto);
            }
            AV52GXV1 = (int)(AV52GXV1+1) ;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV6CliCod, AV51Pgmname, httpContext.getMessage( "sesion &LegSecCodigo ", "")+AV28LegSecCodigo.toJSonString(false)) ;
         GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = AV9DDO_TitleSettingsIcons;
         GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
         new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6) ;
         GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] ;
         AV9DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
         /* Execute user subroutine: 'LOADCOMBOLEGSINCOD' */
         S122 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'LOADCOMBOLEGCATCODIGO' */
         S132 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'LOADCOMBOLEGSECCODIGO' */
         S142 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'LOADCOMBOLEGPUESCODIGO' */
         S152 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'LOADCOMBOLEGCONVECODIGO' */
         S162 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'SELECCIONAR CONVENIOS VISIBLE' */
         S172 ();
         if (returnInSub) return;
      }
   }

   public void e15MD2( )
   {
      /* 'DoUserAction1' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'INICIALIZAR FILTROS VACIOS' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'APLICAR Y VOLVER' */
      S182 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavLegestado.setValue( GXutil.trim( GXutil.str( AV44LegEstado, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLegestado.getInternalname(), "Values", cmbavLegestado.ToJavascriptSource(), true);
      dynavLegsexo.setValue( GXutil.trim( GXutil.str( AV29LegSexo, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynavLegsexo.getInternalname(), "Values", dynavLegsexo.ToJavascriptSource(), true);
      cmbavLegclase.setValue( GXutil.trim( GXutil.str( AV21LegClase, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLegclase.getInternalname(), "Values", cmbavLegclase.ToJavascriptSource(), true);
      cmbavLegmodtra.setValue( GXutil.rtrim( AV47LegModTra) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLegmodtra.getInternalname(), "Values", cmbavLegmodtra.ToJavascriptSource(), true);
      cmbavLegtipotarifa.setValue( GXutil.rtrim( AV48LegTipoTarifa) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLegtipotarifa.getInternalname(), "Values", cmbavLegtipotarifa.ToJavascriptSource(), true);
      cmbavConveniofiltro.setValue( GXutil.rtrim( AV8ConvenioFiltro) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavConveniofiltro.getInternalname(), "Values", cmbavConveniofiltro.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31LegSinCod", AV31LegSinCod);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV32LegSinCod_Data", AV32LegSinCod_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22LegConveCodigo", AV22LegConveCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV23LegConveCodigo_Data", AV23LegConveCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19LegCatCodigo", AV19LegCatCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20LegCatCodigo_Data", AV20LegCatCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28LegSecCodigo", AV28LegSecCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42LegSecCodigo_Data", AV42LegSecCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27LegPuesCodigo", AV27LegPuesCodigo);
      dynavLegactcodigo.setValue( GXutil.rtrim( AV18LegActCodigo) );
      httpContext.ajax_rsp_assign_prop("", false, dynavLegactcodigo.getInternalname(), "Values", dynavLegactcodigo.ToJavascriptSource(), true);
      dynavMprcod.setValue( GXutil.rtrim( AV34MprCod) );
      httpContext.ajax_rsp_assign_prop("", false, dynavMprcod.getInternalname(), "Values", dynavMprcod.ToJavascriptSource(), true);
      dynavZoncod.setValue( GXutil.rtrim( AV39ZonCod) );
      httpContext.ajax_rsp_assign_prop("", false, dynavZoncod.getInternalname(), "Values", dynavZoncod.ToJavascriptSource(), true);
      dynavLegsuccodigo.setValue( GXutil.rtrim( AV33LegSucCodigo) );
      httpContext.ajax_rsp_assign_prop("", false, dynavLegsuccodigo.getInternalname(), "Values", dynavLegsuccodigo.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43LegPuesCodigo_Data", AV43LegPuesCodigo_Data);
   }

   public void e16MD2( )
   {
      /* 'DoConfirmar' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'APLICAR Y VOLVER' */
      S182 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22LegConveCodigo", AV22LegConveCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV23LegConveCodigo_Data", AV23LegConveCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19LegCatCodigo", AV19LegCatCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20LegCatCodigo_Data", AV20LegCatCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28LegSecCodigo", AV28LegSecCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27LegPuesCodigo", AV27LegPuesCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV32LegSinCod_Data", AV32LegSinCod_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42LegSecCodigo_Data", AV42LegSecCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43LegPuesCodigo_Data", AV43LegPuesCodigo_Data);
   }

   public void e13MD2( )
   {
      /* Combo_legconvecodigo_Onoptionclicked Routine */
      returnInSub = false ;
      AV22LegConveCodigo.fromJSonString(Combo_legconvecodigo_Selectedvalue_get, null);
      /* Execute user subroutine: 'LOADCOMBOLEGCATCODIGO' */
      S132 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22LegConveCodigo", AV22LegConveCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20LegCatCodigo_Data", AV20LegCatCodigo_Data);
   }

   public void e12MD2( )
   {
      /* Combo_legseccodigo_Onoptionclicked Routine */
      returnInSub = false ;
      AV28LegSecCodigo.fromJSonString(Combo_legseccodigo_Selectedvalue_get, null);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV6CliCod, AV51Pgmname, httpContext.getMessage( "click &LegSecCodigo ", "")+AV28LegSecCodigo.toJSonString(false)) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28LegSecCodigo", AV28LegSecCodigo);
   }

   public void e11MD2( )
   {
      /* Combo_legsincod_Onoptionclicked Routine */
      returnInSub = false ;
      AV31LegSinCod.fromJSonString(Combo_legsincod_Selectedvalue_get, null);
      /* Execute user subroutine: 'LOADCOMBOLEGCONVECODIGO' */
      S162 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31LegSinCod", AV31LegSinCod);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV23LegConveCodigo_Data", AV23LegConveCodigo_Data);
   }

   public void S162( )
   {
      /* 'LOADCOMBOLEGCONVECODIGO' Routine */
      returnInSub = false ;
      Combo_legconvecodigo_Emptyitem = true ;
      ucCombo_legconvecodigo.sendProperty(context, "", false, Combo_legconvecodigo_Internalname, "EmptyItem", GXutil.booltostr( Combo_legconvecodigo_Emptyitem));
      AV23LegConveCodigo_Data.clear();
      if ( AV31LegSinCod.size() > 0 )
      {
         AV15i = (short)(1) ;
         while ( AV15i <= AV31LegSinCod.size() )
         {
            GXv_objcol_Sdtsdt_convenios_sdt_conveniosItem7[0] = AV36sdt_convenios ;
            new web.conveniosdesindicatocoleccion(remoteHandle, context).execute( AV6CliCod, AV10EmpCod, (String)AV31LegSinCod.elementAt(-1+AV15i), GXv_objcol_Sdtsdt_convenios_sdt_conveniosItem7) ;
            AV36sdt_convenios = GXv_objcol_Sdtsdt_convenios_sdt_conveniosItem7[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV51Pgmname, httpContext.getMessage( "combo convenio", "")) ;
            AV53GXV2 = 1 ;
            while ( AV53GXV2 <= AV36sdt_convenios.size() )
            {
               AV17itemSdt_Convenios = (web.Sdtsdt_convenios_sdt_conveniosItem)((web.Sdtsdt_convenios_sdt_conveniosItem)AV36sdt_convenios.elementAt(-1+AV53GXV2));
               AV7Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( AV17itemSdt_Convenios.getgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo() );
               AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( AV17itemSdt_Convenios.getgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri() );
               AV23LegConveCodigo_Data.add(AV7Combo_DataItem, 0);
               AV53GXV2 = (int)(AV53GXV2+1) ;
            }
            AV15i = (short)(AV15i+1) ;
         }
      }
      else
      {
         GXv_objcol_Sdtsdt_convenios_sdt_conveniosItem7[0] = AV36sdt_convenios ;
         new web.conveniosdesindicatocoleccion(remoteHandle, context).execute( AV6CliCod, AV10EmpCod, "", GXv_objcol_Sdtsdt_convenios_sdt_conveniosItem7) ;
         AV36sdt_convenios = GXv_objcol_Sdtsdt_convenios_sdt_conveniosItem7[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV51Pgmname, httpContext.getMessage( "2 combo convenio", "")) ;
         AV54GXV3 = 1 ;
         while ( AV54GXV3 <= AV36sdt_convenios.size() )
         {
            AV17itemSdt_Convenios = (web.Sdtsdt_convenios_sdt_conveniosItem)((web.Sdtsdt_convenios_sdt_conveniosItem)AV36sdt_convenios.elementAt(-1+AV54GXV3));
            AV7Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( AV17itemSdt_Convenios.getgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo() );
            AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( AV17itemSdt_Convenios.getgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri() );
            AV23LegConveCodigo_Data.add(AV7Combo_DataItem, 0);
            AV54GXV3 = (int)(AV54GXV3+1) ;
         }
      }
      Combo_legconvecodigo_Selectedvalue_set = AV22LegConveCodigo.toJSonString(false) ;
      ucCombo_legconvecodigo.sendProperty(context, "", false, Combo_legconvecodigo_Internalname, "SelectedValue_set", Combo_legconvecodigo_Selectedvalue_set);
   }

   public void S152( )
   {
      /* 'LOADCOMBOLEGPUESCODIGO' Routine */
      returnInSub = false ;
      Combo_legpuescodigo_Emptyitem = true ;
      ucCombo_legpuescodigo.sendProperty(context, "", false, Combo_legpuescodigo_Internalname, "EmptyItem", GXutil.booltostr( Combo_legpuescodigo_Emptyitem));
      AV43LegPuesCodigo_Data.clear();
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A13SecCodigo ,
                                           AV28LegSecCodigo ,
                                           Integer.valueOf(AV6CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor H00MD7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV6CliCod)});
      while ( (pr_default.getStatus(5) != 101) )
      {
         A13SecCodigo = H00MD7_A13SecCodigo[0] ;
         A3CliCod = H00MD7_A3CliCod[0] ;
         A1241PuestoDescrip = H00MD7_A1241PuestoDescrip[0] ;
         A1240PuestoCodigo = H00MD7_A1240PuestoCodigo[0] ;
         AV7Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1240PuestoCodigo );
         AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1241PuestoDescrip );
         AV43LegPuesCodigo_Data.add(AV7Combo_DataItem, 0);
         pr_default.readNext(5);
      }
      pr_default.close(5);
      Combo_legpuescodigo_Selectedvalue_set = AV27LegPuesCodigo.toJSonString(false) ;
      ucCombo_legpuescodigo.sendProperty(context, "", false, Combo_legpuescodigo_Internalname, "SelectedValue_set", Combo_legpuescodigo_Selectedvalue_set);
   }

   public void S142( )
   {
      /* 'LOADCOMBOLEGSECCODIGO' Routine */
      returnInSub = false ;
      Combo_legseccodigo_Emptyitem = true ;
      ucCombo_legseccodigo.sendProperty(context, "", false, Combo_legseccodigo_Internalname, "EmptyItem", GXutil.booltostr( Combo_legseccodigo_Emptyitem));
      Combo_legseccodigo_Emptyitemtext = httpContext.getMessage( "(Todas)", "") ;
      ucCombo_legseccodigo.sendProperty(context, "", false, Combo_legseccodigo_Internalname, "EmptyItemText", Combo_legseccodigo_Emptyitemtext);
      AV42LegSecCodigo_Data.clear();
      /* Using cursor H00MD8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(AV6CliCod)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         A3CliCod = H00MD8_A3CliCod[0] ;
         A13SecCodigo = H00MD8_A13SecCodigo[0] ;
         A329SecDescrip = H00MD8_A329SecDescrip[0] ;
         AV7Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A13SecCodigo );
         AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A329SecDescrip );
         AV42LegSecCodigo_Data.add(AV7Combo_DataItem, 0);
         pr_default.readNext(6);
      }
      pr_default.close(6);
      Combo_legseccodigo_Selectedvalue_set = AV28LegSecCodigo.toJSonString(false) ;
      ucCombo_legseccodigo.sendProperty(context, "", false, Combo_legseccodigo_Internalname, "SelectedValue_set", Combo_legseccodigo_Selectedvalue_set);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV6CliCod, AV51Pgmname, httpContext.getMessage( "load combo &LegSecCodigo ", "")+AV28LegSecCodigo.toJSonString(false)+httpContext.getMessage( " &LegSecCodigo_Data ", "")+AV42LegSecCodigo_Data.toJSonString(false)) ;
   }

   public void S132( )
   {
      /* 'LOADCOMBOLEGCATCODIGO' Routine */
      returnInSub = false ;
      Combo_legcatcodigo_Emptyitem = true ;
      ucCombo_legcatcodigo.sendProperty(context, "", false, Combo_legcatcodigo_Internalname, "EmptyItem", GXutil.booltostr( Combo_legcatcodigo_Emptyitem));
      AV20LegCatCodigo_Data.clear();
      AV15i = (short)(1) ;
      while ( AV15i <= AV22LegConveCodigo.size() )
      {
         GXv_objcol_Sdtsdt_categorias_sdt_categoriasItem8[0] = AV41sdt_categorias ;
         new web.categoriasdeconvenio(remoteHandle, context).execute( AV6CliCod, AV6CliCod, (String)AV22LegConveCodigo.elementAt(-1+AV15i), AV21LegClase, (short)(0), GXv_objcol_Sdtsdt_categorias_sdt_categoriasItem8) ;
         AV41sdt_categorias = GXv_objcol_Sdtsdt_categorias_sdt_categoriasItem8[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV51Pgmname, httpContext.getMessage( "&sdt_categorias ", "")+AV41sdt_categorias.toJSonString(false)) ;
         AV57GXV4 = 1 ;
         while ( AV57GXV4 <= AV41sdt_categorias.size() )
         {
            AV40itemCat = (web.Sdtsdt_categorias_sdt_categoriasItem)((web.Sdtsdt_categorias_sdt_categoriasItem)AV41sdt_categorias.elementAt(-1+AV57GXV4));
            AV7Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( AV40itemCat.getgxTv_Sdtsdt_categorias_sdt_categoriasItem_Catcodigo() );
            AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( AV40itemCat.getgxTv_Sdtsdt_categorias_sdt_categoriasItem_Catdescrip() );
            AV20LegCatCodigo_Data.add(AV7Combo_DataItem, 0);
            AV57GXV4 = (int)(AV57GXV4+1) ;
         }
         AV15i = (short)(AV15i+1) ;
      }
      Combo_legcatcodigo_Selectedvalue_set = AV19LegCatCodigo.toJSonString(false) ;
      ucCombo_legcatcodigo.sendProperty(context, "", false, Combo_legcatcodigo_Internalname, "SelectedValue_set", Combo_legcatcodigo_Selectedvalue_set);
   }

   public void S122( )
   {
      /* 'LOADCOMBOLEGSINCOD' Routine */
      returnInSub = false ;
      Combo_legsincod_Emptyitem = true ;
      ucCombo_legsincod.sendProperty(context, "", false, Combo_legsincod_Internalname, "EmptyItem", GXutil.booltostr( Combo_legsincod_Emptyitem));
      AV32LegSinCod_Data.clear();
      /* Using cursor H00MD9 */
      pr_default.execute(7, new Object[] {AV5ActComCodigo});
      while ( (pr_default.getStatus(7) != 101) )
      {
         A903ActComCodigo = H00MD9_A903ActComCodigo[0] ;
         A14SinCod = H00MD9_A14SinCod[0] ;
         A331SinDescrip = H00MD9_A331SinDescrip[0] ;
         AV7Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A14SinCod );
         AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A331SinDescrip );
         AV32LegSinCod_Data.add(AV7Combo_DataItem, 0);
         pr_default.readNext(7);
      }
      pr_default.close(7);
      Combo_legsincod_Selectedvalue_set = AV31LegSinCod.toJSonString(false) ;
      ucCombo_legsincod.sendProperty(context, "", false, Combo_legsincod_Internalname, "SelectedValue_set", Combo_legsincod_Selectedvalue_set);
   }

   public void S192( )
   {
      /* 'GUARDAR FILTROS EN SESION' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV6CliCod, AV51Pgmname, httpContext.getMessage( "guardar en sesion Combo_LegSecCodigo.SelectedValue_get ", "")+Combo_legseccodigo_Selectedvalue_get) ;
      AV28LegSecCodigo.fromJSonString(Combo_legseccodigo_Selectedvalue_get, null);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV6CliCod, AV51Pgmname, httpContext.getMessage( "guardar en sesion seccodigo ", "")+AV28LegSecCodigo.toJSonString(false)) ;
      AV27LegPuesCodigo.fromJSonString(Combo_legpuescodigo_Selectedvalue_get, null);
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "FILTERFULLTEXT", "", !(GXutil.strcmp("", AV11FilterFullText)==0), (short)(0), AV11FilterFullText, "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGSEXO", "", !(0==AV29LegSexo), (short)(0), GXutil.trim( GXutil.str( AV29LegSexo, 2, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGCLASE", "", !(0==AV21LegClase), (short)(0), GXutil.trim( GXutil.str( AV21LegClase, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGMODTRA", "", !(GXutil.strcmp("", AV47LegModTra)==0), (short)(0), GXutil.trim( AV47LegModTra), "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGTIPOTARIFA", "", !(GXutil.strcmp("", AV48LegTipoTarifa)==0), (short)(0), GXutil.trim( AV48LegTipoTarifa), "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "CONVENIOFILTRO", "", true, (short)(0), AV8ConvenioFiltro, "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      GXv_objcol_SdtDVB_SDTComboData_Item10[0] = AV32LegSinCod_Data ;
      new web.wwpbaseobjects.wwp_gridstateaddcombofiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGSINCOD", "", !(AV31LegSinCod.size()==0), AV31LegSinCod.toJSonString(false), GXv_objcol_SdtDVB_SDTComboData_Item10, true) ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      AV32LegSinCod_Data = GXv_objcol_SdtDVB_SDTComboData_Item10[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      GXv_objcol_SdtDVB_SDTComboData_Item10[0] = AV23LegConveCodigo_Data ;
      new web.wwpbaseobjects.wwp_gridstateaddcombofiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGCONVECODIGO", "", !(AV22LegConveCodigo.size()==0), AV22LegConveCodigo.toJSonString(false), GXv_objcol_SdtDVB_SDTComboData_Item10, true) ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      AV23LegConveCodigo_Data = GXv_objcol_SdtDVB_SDTComboData_Item10[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      GXv_objcol_SdtDVB_SDTComboData_Item10[0] = AV20LegCatCodigo_Data ;
      new web.wwpbaseobjects.wwp_gridstateaddcombofiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGCATCODIGO", "", !(AV19LegCatCodigo.size()==0), AV19LegCatCodigo.toJSonString(false), GXv_objcol_SdtDVB_SDTComboData_Item10, true) ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      AV20LegCatCodigo_Data = GXv_objcol_SdtDVB_SDTComboData_Item10[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGFECINGRESO", "", !GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV25LegFecIngreso)), (short)(0), GXutil.trim( localUtil.dtoc( AV25LegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGFECEGRESO", "", !GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV24LegFecEgreso)), (short)(0), GXutil.trim( localUtil.dtoc( AV24LegFecEgreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      GXv_objcol_SdtDVB_SDTComboData_Item10[0] = AV42LegSecCodigo_Data ;
      new web.wwpbaseobjects.wwp_gridstateaddcombofiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGSECCODIGO", "", !(AV28LegSecCodigo.size()==0), AV28LegSecCodigo.toJSonString(false), GXv_objcol_SdtDVB_SDTComboData_Item10, true) ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      AV42LegSecCodigo_Data = GXv_objcol_SdtDVB_SDTComboData_Item10[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      GXv_objcol_SdtDVB_SDTComboData_Item10[0] = AV43LegPuesCodigo_Data ;
      new web.wwpbaseobjects.wwp_gridstateaddcombofiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGPUESCODIGO", "", !(AV27LegPuesCodigo.size()==0), AV27LegPuesCodigo.toJSonString(false), GXv_objcol_SdtDVB_SDTComboData_Item10, true) ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      AV43LegPuesCodigo_Data = GXv_objcol_SdtDVB_SDTComboData_Item10[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGACTCODIGO", "", !(GXutil.strcmp("", AV18LegActCodigo)==0), (short)(0), AV18LegActCodigo, "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "MPRCOD", "", !(GXutil.strcmp("", AV34MprCod)==0), (short)(0), AV34MprCod, "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "ZONCOD", "", !(GXutil.strcmp("", AV39ZonCod)==0), (short)(0), AV39ZonCod, "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGSUCCODIGO", "", !(GXutil.strcmp("", AV33LegSucCodigo)==0), (short)(0), AV33LegSucCodigo, "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGESTADO", "", true, (short)(0), GXutil.trim( GXutil.str( AV44LegEstado, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "LEGINCOMPLETO", "", !(false==AV45LegIncompleto), (short)(0), GXutil.trim( GXutil.booltostr( AV45LegIncompleto)), "") ;
      AV12GridState = GXv_SdtWWPGridState9[0] ;
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( httpContext.getMessage( "LegajosWWGridState", ""), AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S172( )
   {
      /* 'SELECCIONAR CONVENIOS VISIBLE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV8ConvenioFiltro, "EnConvenio") == 0 )
      {
         divTablesplittedlegconvecodigo_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablesplittedlegconvecodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesplittedlegconvecodigo_Visible), 5, 0), true);
         divTablesplittedlegcatcodigo_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablesplittedlegcatcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesplittedlegcatcodigo_Visible), 5, 0), true);
      }
      else
      {
         divTablesplittedlegconvecodigo_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablesplittedlegconvecodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesplittedlegconvecodigo_Visible), 5, 0), true);
         divTablesplittedlegcatcodigo_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablesplittedlegcatcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesplittedlegcatcodigo_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'INICIALIZAR FILTROS VACIOS' Routine */
      returnInSub = false ;
      AV44LegEstado = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44LegEstado", GXutil.str( AV44LegEstado, 1, 0));
      AV29LegSexo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29LegSexo), 2, 0));
      AV21LegClase = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21LegClase", GXutil.str( AV21LegClase, 1, 0));
      AV47LegModTra = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47LegModTra", AV47LegModTra);
      AV48LegTipoTarifa = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48LegTipoTarifa", AV48LegTipoTarifa);
      AV8ConvenioFiltro = "Todos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8ConvenioFiltro", AV8ConvenioFiltro);
      AV31LegSinCod.clear();
      AV32LegSinCod_Data.clear();
      Combo_legsincod_Selectedvalue_set = AV31LegSinCod.toJSonString(false) ;
      ucCombo_legsincod.sendProperty(context, "", false, Combo_legsincod_Internalname, "SelectedValue_set", Combo_legsincod_Selectedvalue_set);
      Combo_legsincod_Selectedvalue_get = AV31LegSinCod.toJSonString(false) ;
      ucCombo_legsincod.sendProperty(context, "", false, Combo_legsincod_Internalname, "SelectedValue_get", Combo_legsincod_Selectedvalue_get);
      AV22LegConveCodigo.clear();
      AV23LegConveCodigo_Data.clear();
      Combo_legconvecodigo_Selectedvalue_set = AV22LegConveCodigo.toJSonString(false) ;
      ucCombo_legconvecodigo.sendProperty(context, "", false, Combo_legconvecodigo_Internalname, "SelectedValue_set", Combo_legconvecodigo_Selectedvalue_set);
      Combo_legconvecodigo_Selectedvalue_get = AV22LegConveCodigo.toJSonString(false) ;
      ucCombo_legconvecodigo.sendProperty(context, "", false, Combo_legconvecodigo_Internalname, "SelectedValue_get", Combo_legconvecodigo_Selectedvalue_get);
      AV19LegCatCodigo.clear();
      AV20LegCatCodigo_Data.clear();
      Combo_legcatcodigo_Selectedvalue_set = AV19LegCatCodigo.toJSonString(false) ;
      ucCombo_legcatcodigo.sendProperty(context, "", false, Combo_legcatcodigo_Internalname, "SelectedValue_set", Combo_legcatcodigo_Selectedvalue_set);
      Combo_legcatcodigo_Selectedvalue_get = AV19LegCatCodigo.toJSonString(false) ;
      ucCombo_legcatcodigo.sendProperty(context, "", false, Combo_legcatcodigo_Internalname, "SelectedValue_get", Combo_legcatcodigo_Selectedvalue_get);
      AV28LegSecCodigo.clear();
      AV42LegSecCodigo_Data.clear();
      Combo_legseccodigo_Selectedvalue_set = AV28LegSecCodigo.toJSonString(false) ;
      ucCombo_legseccodigo.sendProperty(context, "", false, Combo_legseccodigo_Internalname, "SelectedValue_set", Combo_legseccodigo_Selectedvalue_set);
      Combo_legseccodigo_Selectedvalue_get = AV28LegSecCodigo.toJSonString(false) ;
      ucCombo_legseccodigo.sendProperty(context, "", false, Combo_legseccodigo_Internalname, "SelectedValue_get", Combo_legseccodigo_Selectedvalue_get);
      AV25LegFecIngreso = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25LegFecIngreso", localUtil.format(AV25LegFecIngreso, "99/99/9999"));
      AV24LegFecEgreso = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24LegFecEgreso", localUtil.format(AV24LegFecEgreso, "99/99/9999"));
      AV27LegPuesCodigo.clear();
      AV18LegActCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18LegActCodigo", AV18LegActCodigo);
      AV34MprCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34MprCod", AV34MprCod);
      AV39ZonCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39ZonCod", AV39ZonCod);
      AV33LegSucCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33LegSucCodigo", AV33LegSucCodigo);
      AV45LegIncompleto = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45LegIncompleto", AV45LegIncompleto);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV6CliCod, AV51Pgmname, httpContext.getMessage( "INI ", "")+AV28LegSecCodigo.toJSonString(false)) ;
   }

   public void S182( )
   {
      /* 'APLICAR Y VOLVER' Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(AV8ConvenioFiltro, "Todos") == 0 ) || ( GXutil.strcmp(AV8ConvenioFiltro, "Fuera") == 0 ) )
      {
         AV22LegConveCodigo.clear();
         AV23LegConveCodigo_Data.clear();
         AV19LegCatCodigo.clear();
         AV20LegCatCodigo_Data.clear();
      }
      else
      {
      }
      /* Execute user subroutine: 'GUARDAR FILTROS EN SESION' */
      S192 ();
      if (returnInSub) return;
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

   protected void e17MD2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV6CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      AV10EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10EmpCod), "ZZZ9")));
      AV26LegNumero = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26LegNumero), 8, 0));
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
      paMD2( ) ;
      wsMD2( ) ;
      weMD2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713472086", true, true);
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
      httpContext.AddJavascriptSource("legajofiltros.js", "?20251713472086", false, true);
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
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocklegsexo_Internalname = "TEXTBLOCKLEGSEXO" ;
      dynavLegsexo.setInternalname( "vLEGSEXO" );
      divUnnamedtablelegsexo_Internalname = "UNNAMEDTABLELEGSEXO" ;
      lblTextblocklegmodtra_Internalname = "TEXTBLOCKLEGMODTRA" ;
      cmbavLegmodtra.setInternalname( "vLEGMODTRA" );
      divUnnamedtablelegmodtra_Internalname = "UNNAMEDTABLELEGMODTRA" ;
      cmbavLegtipotarifa.setInternalname( "vLEGTIPOTARIFA" );
      lblTextblocklegclase_Internalname = "TEXTBLOCKLEGCLASE" ;
      cmbavLegclase.setInternalname( "vLEGCLASE" );
      divUnnamedtablelegclase_Internalname = "UNNAMEDTABLELEGCLASE" ;
      lblTextblockcombo_legsincod_Internalname = "TEXTBLOCKCOMBO_LEGSINCOD" ;
      Combo_legsincod_Internalname = "COMBO_LEGSINCOD" ;
      divTablesplittedlegsincod_Internalname = "TABLESPLITTEDLEGSINCOD" ;
      lblTextblockconveniofiltro_Internalname = "TEXTBLOCKCONVENIOFILTRO" ;
      cmbavConveniofiltro.setInternalname( "vCONVENIOFILTRO" );
      divUnnamedtableconveniofiltro_Internalname = "UNNAMEDTABLECONVENIOFILTRO" ;
      lblTextblockcombo_legcatcodigo_Internalname = "TEXTBLOCKCOMBO_LEGCATCODIGO" ;
      Combo_legcatcodigo_Internalname = "COMBO_LEGCATCODIGO" ;
      divTablesplittedlegcatcodigo_Internalname = "TABLESPLITTEDLEGCATCODIGO" ;
      lblTextblocklegsuccodigo_Internalname = "TEXTBLOCKLEGSUCCODIGO" ;
      dynavLegsuccodigo.setInternalname( "vLEGSUCCODIGO" );
      divUnnamedtablelegsuccodigo_Internalname = "UNNAMEDTABLELEGSUCCODIGO" ;
      lblTextblocklegfecingreso_Internalname = "TEXTBLOCKLEGFECINGRESO" ;
      edtavLegfecingreso_Internalname = "vLEGFECINGRESO" ;
      divUnnamedtablelegfecingreso_Internalname = "UNNAMEDTABLELEGFECINGRESO" ;
      lblTextblocklegfecegreso_Internalname = "TEXTBLOCKLEGFECEGRESO" ;
      edtavLegfecegreso_Internalname = "vLEGFECEGRESO" ;
      divUnnamedtablelegfecegreso_Internalname = "UNNAMEDTABLELEGFECEGRESO" ;
      divTablecolumna1_Internalname = "TABLECOLUMNA1" ;
      lblTextblockcombo_legseccodigo_Internalname = "TEXTBLOCKCOMBO_LEGSECCODIGO" ;
      Combo_legseccodigo_Internalname = "COMBO_LEGSECCODIGO" ;
      divTablesplittedlegseccodigo_Internalname = "TABLESPLITTEDLEGSECCODIGO" ;
      lblTextblockcombo_legpuescodigo_Internalname = "TEXTBLOCKCOMBO_LEGPUESCODIGO" ;
      Combo_legpuescodigo_Internalname = "COMBO_LEGPUESCODIGO" ;
      divTablesplittedlegpuescodigo_Internalname = "TABLESPLITTEDLEGPUESCODIGO" ;
      lblTextblocklegactcodigo_Internalname = "TEXTBLOCKLEGACTCODIGO" ;
      dynavLegactcodigo.setInternalname( "vLEGACTCODIGO" );
      divUnnamedtablelegactcodigo_Internalname = "UNNAMEDTABLELEGACTCODIGO" ;
      lblTextblockcombo_legconvecodigo_Internalname = "TEXTBLOCKCOMBO_LEGCONVECODIGO" ;
      Combo_legconvecodigo_Internalname = "COMBO_LEGCONVECODIGO" ;
      divTablesplittedlegconvecodigo_Internalname = "TABLESPLITTEDLEGCONVECODIGO" ;
      lblTextblockmprcod_Internalname = "TEXTBLOCKMPRCOD" ;
      dynavMprcod.setInternalname( "vMPRCOD" );
      divUnnamedtablemprcod_Internalname = "UNNAMEDTABLEMPRCOD" ;
      lblTextblockzoncod_Internalname = "TEXTBLOCKZONCOD" ;
      dynavZoncod.setInternalname( "vZONCOD" );
      divUnnamedtablezoncod_Internalname = "UNNAMEDTABLEZONCOD" ;
      lblTextblocklegestado_Internalname = "TEXTBLOCKLEGESTADO" ;
      cmbavLegestado.setInternalname( "vLEGESTADO" );
      divUnnamedtablelegestado_Internalname = "UNNAMEDTABLELEGESTADO" ;
      lblTextblocklegincompleto_Internalname = "TEXTBLOCKLEGINCOMPLETO" ;
      chkavLegincompleto.setInternalname( "vLEGINCOMPLETO" );
      divUnnamedtablelegincompleto_Internalname = "UNNAMEDTABLELEGINCOMPLETO" ;
      divTablecolumna2_Internalname = "TABLECOLUMNA2" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnuseraction1_Internalname = "BTNUSERACTION1" ;
      bttBtnconfirmar_Internalname = "BTNCONFIRMAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      chkavLegincompleto.setEnabled( 1 );
      cmbavLegestado.setJsonclick( "" );
      cmbavLegestado.setEnabled( 1 );
      dynavZoncod.setJsonclick( "" );
      dynavZoncod.setEnabled( 1 );
      dynavMprcod.setJsonclick( "" );
      dynavMprcod.setEnabled( 1 );
      Combo_legconvecodigo_Caption = "" ;
      divTablesplittedlegconvecodigo_Visible = 1 ;
      dynavLegactcodigo.setJsonclick( "" );
      dynavLegactcodigo.setEnabled( 1 );
      Combo_legpuescodigo_Caption = "" ;
      Combo_legseccodigo_Caption = "" ;
      edtavLegfecegreso_Jsonclick = "" ;
      edtavLegfecegreso_Enabled = 1 ;
      edtavLegfecingreso_Jsonclick = "" ;
      edtavLegfecingreso_Enabled = 1 ;
      dynavLegsuccodigo.setJsonclick( "" );
      dynavLegsuccodigo.setEnabled( 1 );
      Combo_legcatcodigo_Caption = "" ;
      divTablesplittedlegcatcodigo_Visible = 1 ;
      cmbavConveniofiltro.setJsonclick( "" );
      cmbavConveniofiltro.setEnabled( 1 );
      Combo_legsincod_Caption = "" ;
      cmbavLegclase.setJsonclick( "" );
      cmbavLegclase.setEnabled( 1 );
      cmbavLegtipotarifa.setJsonclick( "" );
      cmbavLegtipotarifa.setEnabled( 1 );
      cmbavLegmodtra.setJsonclick( "" );
      cmbavLegmodtra.setEnabled( 1 );
      dynavLegsexo.setJsonclick( "" );
      dynavLegsexo.setEnabled( 1 );
      Combo_legconvecodigo_Multiplevaluestype = "Tags" ;
      Combo_legconvecodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legconvecodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_legconvecodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_legconvecodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_legpuescodigo_Multiplevaluestype = "Tags" ;
      Combo_legpuescodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legpuescodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_legpuescodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_legpuescodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_legseccodigo_Emptyitemtext = "GX_EmptyItemText" ;
      Combo_legseccodigo_Multiplevaluestype = "Tags" ;
      Combo_legseccodigo_Emptyitem = GXutil.toBoolean( -1) ;
      Combo_legseccodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_legseccodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_legseccodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_legcatcodigo_Multiplevaluestype = "Tags" ;
      Combo_legcatcodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legcatcodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_legcatcodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_legcatcodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_legsincod_Multiplevaluestype = "Tags" ;
      Combo_legsincod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legsincod_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_legsincod_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_legsincod_Cls = "ExtendedCombo Attribute" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Filtros", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      dynavLegsexo.setName( "vLEGSEXO" );
      dynavLegsexo.setWebtags( "" );
      cmbavLegmodtra.setName( "vLEGMODTRA" );
      cmbavLegmodtra.setWebtags( "" );
      cmbavLegmodtra.addItem("", httpContext.getMessage( "(Todas)", ""), (short)(0));
      cmbavLegmodtra.addItem("E", httpContext.getMessage( "Empleado", ""), (short)(0));
      cmbavLegmodtra.addItem("I", httpContext.getMessage( "Independiente", ""), (short)(0));
      if ( cmbavLegmodtra.getItemCount() > 0 )
      {
         AV47LegModTra = cmbavLegmodtra.getValidValue(AV47LegModTra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47LegModTra", AV47LegModTra);
      }
      cmbavLegtipotarifa.setName( "vLEGTIPOTARIFA" );
      cmbavLegtipotarifa.setWebtags( "" );
      cmbavLegtipotarifa.addItem("", httpContext.getMessage( "(Todos)", ""), (short)(0));
      cmbavLegtipotarifa.addItem("H", httpContext.getMessage( "Por hora trabajada", ""), (short)(0));
      cmbavLegtipotarifa.addItem("P", httpContext.getMessage( "Por periodo trabajado", ""), (short)(0));
      if ( cmbavLegtipotarifa.getItemCount() > 0 )
      {
         AV48LegTipoTarifa = cmbavLegtipotarifa.getValidValue(AV48LegTipoTarifa) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48LegTipoTarifa", AV48LegTipoTarifa);
      }
      cmbavLegclase.setName( "vLEGCLASE" );
      cmbavLegclase.setWebtags( "" );
      cmbavLegclase.addItem(GXutil.trim( GXutil.str( 0, 1, 0)), httpContext.getMessage( "(Todas)", ""), (short)(0));
      cmbavLegclase.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbavLegclase.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbavLegclase.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbavLegclase.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbavLegclase.getItemCount() > 0 )
      {
         AV21LegClase = (byte)(GXutil.lval( cmbavLegclase.getValidValue(GXutil.trim( GXutil.str( AV21LegClase, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21LegClase", GXutil.str( AV21LegClase, 1, 0));
      }
      cmbavConveniofiltro.setName( "vCONVENIOFILTRO" );
      cmbavConveniofiltro.setWebtags( "" );
      cmbavConveniofiltro.addItem("Todos", httpContext.getMessage( "Todos", ""), (short)(0));
      cmbavConveniofiltro.addItem("Fuera", httpContext.getMessage( "Solo fuera de convenio", ""), (short)(0));
      cmbavConveniofiltro.addItem("EnConvenio", httpContext.getMessage( "En convenio", ""), (short)(0));
      if ( cmbavConveniofiltro.getItemCount() > 0 )
      {
         AV8ConvenioFiltro = cmbavConveniofiltro.getValidValue(AV8ConvenioFiltro) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8ConvenioFiltro", AV8ConvenioFiltro);
      }
      dynavLegsuccodigo.setName( "vLEGSUCCODIGO" );
      dynavLegsuccodigo.setWebtags( "" );
      dynavLegactcodigo.setName( "vLEGACTCODIGO" );
      dynavLegactcodigo.setWebtags( "" );
      dynavMprcod.setName( "vMPRCOD" );
      dynavMprcod.setWebtags( "" );
      dynavZoncod.setName( "vZONCOD" );
      dynavZoncod.setWebtags( "" );
      cmbavLegestado.setName( "vLEGESTADO" );
      cmbavLegestado.setWebtags( "" );
      cmbavLegestado.addItem("1", httpContext.getMessage( "Activo", ""), (short)(0));
      cmbavLegestado.addItem("2", httpContext.getMessage( "Baja", ""), (short)(0));
      if ( cmbavLegestado.getItemCount() > 0 )
      {
         AV44LegEstado = (byte)(GXutil.lval( cmbavLegestado.getValidValue(GXutil.trim( GXutil.str( AV44LegEstado, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44LegEstado", GXutil.str( AV44LegEstado, 1, 0));
      }
      chkavLegincompleto.setName( "vLEGINCOMPLETO" );
      chkavLegincompleto.setWebtags( "" );
      chkavLegincompleto.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavLegincompleto.getInternalname(), "TitleCaption", chkavLegincompleto.getCaption(), true);
      chkavLegincompleto.setCheckedValue( "false" );
      AV45LegIncompleto = GXutil.strtobool( GXutil.booltostr( AV45LegIncompleto)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45LegIncompleto", AV45LegIncompleto);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'dynavLegactcodigo'},{av:'AV18LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'dynavMprcod'},{av:'AV34MprCod',fld:'vMPRCOD',pic:''},{av:'dynavZoncod'},{av:'AV39ZonCod',fld:'vZONCOD',pic:''},{av:'dynavLegsuccodigo'},{av:'AV33LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'AV45LegIncompleto',fld:'vLEGINCOMPLETO',pic:''},{av:'AV51Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV11FilterFullText',fld:'vFILTERFULLTEXT',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUSERACTION1'","{handler:'e15MD2',iparms:[{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV51Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavConveniofiltro'},{av:'AV8ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'Combo_legseccodigo_Selectedvalue_get',ctrl:'COMBO_LEGSECCODIGO',prop:'SelectedValue_get'},{av:'Combo_legpuescodigo_Selectedvalue_get',ctrl:'COMBO_LEGPUESCODIGO',prop:'SelectedValue_get'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV11FilterFullText',fld:'vFILTERFULLTEXT',pic:'',hsh:true},{av:'dynavLegsexo'},{av:'AV29LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'cmbavLegclase'},{av:'AV21LegClase',fld:'vLEGCLASE',pic:'9'},{av:'cmbavLegmodtra'},{av:'AV47LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavLegtipotarifa'},{av:'AV48LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'AV31LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV32LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV22LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV23LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV19LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV20LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV25LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV24LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV42LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV43LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'dynavLegactcodigo'},{av:'AV18LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'dynavMprcod'},{av:'AV34MprCod',fld:'vMPRCOD',pic:''},{av:'dynavZoncod'},{av:'AV39ZonCod',fld:'vZONCOD',pic:''},{av:'dynavLegsuccodigo'},{av:'AV33LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV44LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV45LegIncompleto',fld:'vLEGINCOMPLETO',pic:''}]");
      setEventMetadata("'DOUSERACTION1'",",oparms:[{av:'cmbavLegestado'},{av:'AV44LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'dynavLegsexo'},{av:'AV29LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'cmbavLegclase'},{av:'AV21LegClase',fld:'vLEGCLASE',pic:'9'},{av:'cmbavLegmodtra'},{av:'AV47LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavLegtipotarifa'},{av:'AV48LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV8ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV31LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV32LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'Combo_legsincod_Selectedvalue_set',ctrl:'COMBO_LEGSINCOD',prop:'SelectedValue_set'},{av:'Combo_legsincod_Selectedvalue_get',ctrl:'COMBO_LEGSINCOD',prop:'SelectedValue_get'},{av:'AV22LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV23LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'Combo_legconvecodigo_Selectedvalue_set',ctrl:'COMBO_LEGCONVECODIGO',prop:'SelectedValue_set'},{av:'Combo_legconvecodigo_Selectedvalue_get',ctrl:'COMBO_LEGCONVECODIGO',prop:'SelectedValue_get'},{av:'AV19LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV20LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'Combo_legcatcodigo_Selectedvalue_set',ctrl:'COMBO_LEGCATCODIGO',prop:'SelectedValue_set'},{av:'Combo_legcatcodigo_Selectedvalue_get',ctrl:'COMBO_LEGCATCODIGO',prop:'SelectedValue_get'},{av:'AV28LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV42LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'Combo_legseccodigo_Selectedvalue_set',ctrl:'COMBO_LEGSECCODIGO',prop:'SelectedValue_set'},{av:'Combo_legseccodigo_Selectedvalue_get',ctrl:'COMBO_LEGSECCODIGO',prop:'SelectedValue_get'},{av:'AV25LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV24LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV27LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'dynavLegactcodigo'},{av:'AV18LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'dynavMprcod'},{av:'AV34MprCod',fld:'vMPRCOD',pic:''},{av:'dynavZoncod'},{av:'AV39ZonCod',fld:'vZONCOD',pic:''},{av:'dynavLegsuccodigo'},{av:'AV33LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'AV45LegIncompleto',fld:'vLEGINCOMPLETO',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV43LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''}]}");
      setEventMetadata("'DOCONFIRMAR'","{handler:'e16MD2',iparms:[{av:'cmbavConveniofiltro'},{av:'AV8ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV51Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'Combo_legseccodigo_Selectedvalue_get',ctrl:'COMBO_LEGSECCODIGO',prop:'SelectedValue_get'},{av:'Combo_legpuescodigo_Selectedvalue_get',ctrl:'COMBO_LEGPUESCODIGO',prop:'SelectedValue_get'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV11FilterFullText',fld:'vFILTERFULLTEXT',pic:'',hsh:true},{av:'dynavLegsexo'},{av:'AV29LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'cmbavLegclase'},{av:'AV21LegClase',fld:'vLEGCLASE',pic:'9'},{av:'cmbavLegmodtra'},{av:'AV47LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavLegtipotarifa'},{av:'AV48LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'AV31LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV32LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV22LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV23LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV19LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV20LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV25LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV24LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV42LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV43LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'dynavLegactcodigo'},{av:'AV18LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'dynavMprcod'},{av:'AV34MprCod',fld:'vMPRCOD',pic:''},{av:'dynavZoncod'},{av:'AV39ZonCod',fld:'vZONCOD',pic:''},{av:'dynavLegsuccodigo'},{av:'AV33LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV44LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV45LegIncompleto',fld:'vLEGINCOMPLETO',pic:''}]");
      setEventMetadata("'DOCONFIRMAR'",",oparms:[{av:'AV22LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV23LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV19LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV20LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV28LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV27LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV32LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV42LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV43LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''}]}");
      setEventMetadata("COMBO_LEGCONVECODIGO.ONOPTIONCLICKED","{handler:'e13MD2',iparms:[{av:'Combo_legconvecodigo_Selectedvalue_get',ctrl:'COMBO_LEGCONVECODIGO',prop:'SelectedValue_get'},{av:'AV22LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'cmbavLegclase'},{av:'AV21LegClase',fld:'vLEGCLASE',pic:'9'},{av:'AV51Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV19LegCatCodigo',fld:'vLEGCATCODIGO',pic:''}]");
      setEventMetadata("COMBO_LEGCONVECODIGO.ONOPTIONCLICKED",",oparms:[{av:'AV22LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'Combo_legcatcodigo_Emptyitem',ctrl:'COMBO_LEGCATCODIGO',prop:'EmptyItem'},{av:'AV20LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'Combo_legcatcodigo_Selectedvalue_set',ctrl:'COMBO_LEGCATCODIGO',prop:'SelectedValue_set'}]}");
      setEventMetadata("COMBO_LEGSECCODIGO.ONOPTIONCLICKED","{handler:'e12MD2',iparms:[{av:'Combo_legseccodigo_Selectedvalue_get',ctrl:'COMBO_LEGSECCODIGO',prop:'SelectedValue_get'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV51Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("COMBO_LEGSECCODIGO.ONOPTIONCLICKED",",oparms:[{av:'AV28LegSecCodigo',fld:'vLEGSECCODIGO',pic:''}]}");
      setEventMetadata("COMBO_LEGSINCOD.ONOPTIONCLICKED","{handler:'e11MD2',iparms:[{av:'Combo_legsincod_Selectedvalue_get',ctrl:'COMBO_LEGSINCOD',prop:'SelectedValue_get'},{av:'AV31LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV51Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV22LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''}]");
      setEventMetadata("COMBO_LEGSINCOD.ONOPTIONCLICKED",",oparms:[{av:'AV31LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'Combo_legconvecodigo_Emptyitem',ctrl:'COMBO_LEGCONVECODIGO',prop:'EmptyItem'},{av:'AV23LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'Combo_legconvecodigo_Selectedvalue_set',ctrl:'COMBO_LEGCONVECODIGO',prop:'SelectedValue_set'}]}");
      setEventMetadata("VALIDV_LEGMODTRA","{handler:'validv_Legmodtra',iparms:[]");
      setEventMetadata("VALIDV_LEGMODTRA",",oparms:[]}");
      setEventMetadata("VALIDV_LEGTIPOTARIFA","{handler:'validv_Legtipotarifa',iparms:[]");
      setEventMetadata("VALIDV_LEGTIPOTARIFA",",oparms:[]}");
      setEventMetadata("VALIDV_LEGCLASE","{handler:'validv_Legclase',iparms:[]");
      setEventMetadata("VALIDV_LEGCLASE",",oparms:[]}");
      setEventMetadata("VALIDV_CONVENIOFILTRO","{handler:'validv_Conveniofiltro',iparms:[]");
      setEventMetadata("VALIDV_CONVENIOFILTRO",",oparms:[]}");
      setEventMetadata("VALIDV_LEGESTADO","{handler:'validv_Legestado',iparms:[]");
      setEventMetadata("VALIDV_LEGESTADO",",oparms:[]}");
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
      Combo_legseccodigo_Selectedvalue_get = "" ;
      Combo_legpuescodigo_Selectedvalue_get = "" ;
      Combo_legconvecodigo_Selectedvalue_get = "" ;
      Combo_legcatcodigo_Selectedvalue_get = "" ;
      Combo_legsincod_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV51Pgmname = "" ;
      AV11FilterFullText = "" ;
      GXKey = "" ;
      AV9DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV32LegSinCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV20LegCatCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV42LegSecCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV43LegPuesCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV23LegConveCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV31LegSinCod = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22LegConveCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19LegCatCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27LegPuesCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      Combo_legsincod_Selectedvalue_set = "" ;
      Combo_legcatcodigo_Selectedvalue_set = "" ;
      Combo_legseccodigo_Selectedvalue_set = "" ;
      Combo_legpuescodigo_Selectedvalue_set = "" ;
      Combo_legconvecodigo_Selectedvalue_set = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblocklegsexo_Jsonclick = "" ;
      TempTags = "" ;
      lblTextblocklegmodtra_Jsonclick = "" ;
      AV47LegModTra = "" ;
      AV48LegTipoTarifa = "" ;
      lblTextblocklegclase_Jsonclick = "" ;
      lblTextblockcombo_legsincod_Jsonclick = "" ;
      ucCombo_legsincod = new com.genexus.webpanels.GXUserControl();
      lblTextblockconveniofiltro_Jsonclick = "" ;
      AV8ConvenioFiltro = "" ;
      lblTextblockcombo_legcatcodigo_Jsonclick = "" ;
      ucCombo_legcatcodigo = new com.genexus.webpanels.GXUserControl();
      lblTextblocklegsuccodigo_Jsonclick = "" ;
      AV33LegSucCodigo = "" ;
      lblTextblocklegfecingreso_Jsonclick = "" ;
      AV25LegFecIngreso = GXutil.nullDate() ;
      lblTextblocklegfecegreso_Jsonclick = "" ;
      AV24LegFecEgreso = GXutil.nullDate() ;
      lblTextblockcombo_legseccodigo_Jsonclick = "" ;
      ucCombo_legseccodigo = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_legpuescodigo_Jsonclick = "" ;
      ucCombo_legpuescodigo = new com.genexus.webpanels.GXUserControl();
      lblTextblocklegactcodigo_Jsonclick = "" ;
      AV18LegActCodigo = "" ;
      lblTextblockcombo_legconvecodigo_Jsonclick = "" ;
      ucCombo_legconvecodigo = new com.genexus.webpanels.GXUserControl();
      lblTextblockmprcod_Jsonclick = "" ;
      AV34MprCod = "" ;
      lblTextblockzoncod_Jsonclick = "" ;
      AV39ZonCod = "" ;
      lblTextblocklegestado_Jsonclick = "" ;
      lblTextblocklegincompleto_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnuseraction1_Jsonclick = "" ;
      bttBtnconfirmar_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H00MD2_A1743SexoId = new byte[1] ;
      H00MD2_A1744SexoNombre = new String[] {""} ;
      H00MD2_A1742SexoPaiCod = new short[1] ;
      H00MD3_A1243SucCodigo = new String[] {""} ;
      H00MD3_A1244SucDescrip = new String[] {""} ;
      H00MD3_A3CliCod = new int[1] ;
      H00MD3_A1EmpCod = new short[1] ;
      H00MD4_A43ActCodigo = new String[] {""} ;
      H00MD4_A108ActDescrip = new String[] {""} ;
      H00MD5_A18MprCod = new String[] {""} ;
      H00MD5_A303MprDescrip = new String[] {""} ;
      H00MD6_A20ZonCod = new String[] {""} ;
      H00MD6_A342ZonDescrip = new String[] {""} ;
      GXv_int2 = new short[1] ;
      AV5ActComCodigo = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      AV46httpRequest = httpContext.getHttpRequest();
      AV38Session = httpContext.getWebSession();
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV28LegSecCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV36sdt_convenios = new GXBaseCollection<web.Sdtsdt_convenios_sdt_conveniosItem>(web.Sdtsdt_convenios_sdt_conveniosItem.class, "sdt_conveniosItem", "PayDay", remoteHandle);
      AV17itemSdt_Convenios = new web.Sdtsdt_convenios_sdt_conveniosItem(remoteHandle, context);
      AV7Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      GXv_objcol_Sdtsdt_convenios_sdt_conveniosItem7 = new GXBaseCollection[1] ;
      A13SecCodigo = "" ;
      H00MD7_A13SecCodigo = new String[] {""} ;
      H00MD7_A3CliCod = new int[1] ;
      H00MD7_A1241PuestoDescrip = new String[] {""} ;
      H00MD7_A1240PuestoCodigo = new String[] {""} ;
      A1241PuestoDescrip = "" ;
      A1240PuestoCodigo = "" ;
      H00MD8_A3CliCod = new int[1] ;
      H00MD8_A13SecCodigo = new String[] {""} ;
      H00MD8_A329SecDescrip = new String[] {""} ;
      A329SecDescrip = "" ;
      AV41sdt_categorias = new GXBaseCollection<web.Sdtsdt_categorias_sdt_categoriasItem>(web.Sdtsdt_categorias_sdt_categoriasItem.class, "sdt_categoriasItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_categorias_sdt_categoriasItem8 = new GXBaseCollection[1] ;
      AV40itemCat = new web.Sdtsdt_categorias_sdt_categoriasItem(remoteHandle, context);
      H00MD9_A46PaiCod = new short[1] ;
      H00MD9_A903ActComCodigo = new String[] {""} ;
      H00MD9_A14SinCod = new String[] {""} ;
      H00MD9_A331SinDescrip = new String[] {""} ;
      A903ActComCodigo = "" ;
      A14SinCod = "" ;
      A331SinDescrip = "" ;
      GXv_objcol_SdtDVB_SDTComboData_Item10 = new GXBaseCollection[1] ;
      GXv_SdtWWPGridState9 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajofiltros__default(),
         new Object[] {
             new Object[] {
            H00MD2_A1743SexoId, H00MD2_A1744SexoNombre, H00MD2_A1742SexoPaiCod
            }
            , new Object[] {
            H00MD3_A1243SucCodigo, H00MD3_A1244SucDescrip, H00MD3_A3CliCod, H00MD3_A1EmpCod
            }
            , new Object[] {
            H00MD4_A43ActCodigo, H00MD4_A108ActDescrip
            }
            , new Object[] {
            H00MD5_A18MprCod, H00MD5_A303MprDescrip
            }
            , new Object[] {
            H00MD6_A20ZonCod, H00MD6_A342ZonDescrip
            }
            , new Object[] {
            H00MD7_A13SecCodigo, H00MD7_A3CliCod, H00MD7_A1241PuestoDescrip, H00MD7_A1240PuestoCodigo
            }
            , new Object[] {
            H00MD8_A3CliCod, H00MD8_A13SecCodigo, H00MD8_A329SecDescrip
            }
            , new Object[] {
            H00MD9_A46PaiCod, H00MD9_A903ActComCodigo, H00MD9_A14SinCod, H00MD9_A331SinDescrip
            }
         }
      );
      AV51Pgmname = "LegajoFiltros" ;
      /* GeneXus formulas. */
      AV51Pgmname = "LegajoFiltros" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte AV29LegSexo ;
   private byte AV21LegClase ;
   private byte AV44LegEstado ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOAV10EmpCod ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV35PaiCod ;
   private short AV10EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV15i ;
   private int wcpOAV6CliCod ;
   private int wcpOAV26LegNumero ;
   private int AV6CliCod ;
   private int AV26LegNumero ;
   private int divTablesplittedlegcatcodigo_Visible ;
   private int edtavLegfecingreso_Enabled ;
   private int edtavLegfecegreso_Enabled ;
   private int divTablesplittedlegconvecodigo_Visible ;
   private int gxdynajaxindex ;
   private int AV52GXV1 ;
   private int AV53GXV2 ;
   private int AV54GXV3 ;
   private int A3CliCod ;
   private int AV57GXV4 ;
   private int idxLst ;
   private String Combo_legseccodigo_Selectedvalue_get ;
   private String Combo_legpuescodigo_Selectedvalue_get ;
   private String Combo_legconvecodigo_Selectedvalue_get ;
   private String Combo_legcatcodigo_Selectedvalue_get ;
   private String Combo_legsincod_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV51Pgmname ;
   private String GXKey ;
   private String Combo_legsincod_Cls ;
   private String Combo_legsincod_Selectedvalue_set ;
   private String Combo_legsincod_Multiplevaluestype ;
   private String Combo_legcatcodigo_Cls ;
   private String Combo_legcatcodigo_Selectedvalue_set ;
   private String Combo_legcatcodigo_Multiplevaluestype ;
   private String Combo_legseccodigo_Cls ;
   private String Combo_legseccodigo_Selectedvalue_set ;
   private String Combo_legseccodigo_Multiplevaluestype ;
   private String Combo_legseccodigo_Emptyitemtext ;
   private String Combo_legpuescodigo_Cls ;
   private String Combo_legpuescodigo_Selectedvalue_set ;
   private String Combo_legpuescodigo_Multiplevaluestype ;
   private String Combo_legconvecodigo_Cls ;
   private String Combo_legconvecodigo_Selectedvalue_set ;
   private String Combo_legconvecodigo_Multiplevaluestype ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTablecontent_Internalname ;
   private String divTablecolumna1_Internalname ;
   private String divUnnamedtablelegsexo_Internalname ;
   private String lblTextblocklegsexo_Internalname ;
   private String lblTextblocklegsexo_Jsonclick ;
   private String TempTags ;
   private String divUnnamedtablelegmodtra_Internalname ;
   private String lblTextblocklegmodtra_Internalname ;
   private String lblTextblocklegmodtra_Jsonclick ;
   private String AV47LegModTra ;
   private String AV48LegTipoTarifa ;
   private String divUnnamedtablelegclase_Internalname ;
   private String lblTextblocklegclase_Internalname ;
   private String lblTextblocklegclase_Jsonclick ;
   private String divTablesplittedlegsincod_Internalname ;
   private String lblTextblockcombo_legsincod_Internalname ;
   private String lblTextblockcombo_legsincod_Jsonclick ;
   private String Combo_legsincod_Caption ;
   private String Combo_legsincod_Internalname ;
   private String divUnnamedtableconveniofiltro_Internalname ;
   private String lblTextblockconveniofiltro_Internalname ;
   private String lblTextblockconveniofiltro_Jsonclick ;
   private String AV8ConvenioFiltro ;
   private String divTablesplittedlegcatcodigo_Internalname ;
   private String lblTextblockcombo_legcatcodigo_Internalname ;
   private String lblTextblockcombo_legcatcodigo_Jsonclick ;
   private String Combo_legcatcodigo_Caption ;
   private String Combo_legcatcodigo_Internalname ;
   private String divUnnamedtablelegsuccodigo_Internalname ;
   private String lblTextblocklegsuccodigo_Internalname ;
   private String lblTextblocklegsuccodigo_Jsonclick ;
   private String AV33LegSucCodigo ;
   private String divUnnamedtablelegfecingreso_Internalname ;
   private String lblTextblocklegfecingreso_Internalname ;
   private String lblTextblocklegfecingreso_Jsonclick ;
   private String edtavLegfecingreso_Internalname ;
   private String edtavLegfecingreso_Jsonclick ;
   private String divUnnamedtablelegfecegreso_Internalname ;
   private String lblTextblocklegfecegreso_Internalname ;
   private String lblTextblocklegfecegreso_Jsonclick ;
   private String edtavLegfecegreso_Internalname ;
   private String edtavLegfecegreso_Jsonclick ;
   private String divTablecolumna2_Internalname ;
   private String divTablesplittedlegseccodigo_Internalname ;
   private String lblTextblockcombo_legseccodigo_Internalname ;
   private String lblTextblockcombo_legseccodigo_Jsonclick ;
   private String Combo_legseccodigo_Caption ;
   private String Combo_legseccodigo_Internalname ;
   private String divTablesplittedlegpuescodigo_Internalname ;
   private String lblTextblockcombo_legpuescodigo_Internalname ;
   private String lblTextblockcombo_legpuescodigo_Jsonclick ;
   private String Combo_legpuescodigo_Caption ;
   private String Combo_legpuescodigo_Internalname ;
   private String divUnnamedtablelegactcodigo_Internalname ;
   private String lblTextblocklegactcodigo_Internalname ;
   private String lblTextblocklegactcodigo_Jsonclick ;
   private String AV18LegActCodigo ;
   private String divTablesplittedlegconvecodigo_Internalname ;
   private String lblTextblockcombo_legconvecodigo_Internalname ;
   private String lblTextblockcombo_legconvecodigo_Jsonclick ;
   private String Combo_legconvecodigo_Caption ;
   private String Combo_legconvecodigo_Internalname ;
   private String divUnnamedtablemprcod_Internalname ;
   private String lblTextblockmprcod_Internalname ;
   private String lblTextblockmprcod_Jsonclick ;
   private String AV34MprCod ;
   private String divUnnamedtablezoncod_Internalname ;
   private String lblTextblockzoncod_Internalname ;
   private String lblTextblockzoncod_Jsonclick ;
   private String AV39ZonCod ;
   private String divUnnamedtablelegestado_Internalname ;
   private String lblTextblocklegestado_Internalname ;
   private String lblTextblocklegestado_Jsonclick ;
   private String divUnnamedtablelegincompleto_Internalname ;
   private String lblTextblocklegincompleto_Internalname ;
   private String lblTextblocklegincompleto_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnuseraction1_Internalname ;
   private String bttBtnuseraction1_Jsonclick ;
   private String bttBtnconfirmar_Internalname ;
   private String bttBtnconfirmar_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV5ActComCodigo ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private String A13SecCodigo ;
   private String A1240PuestoCodigo ;
   private String A903ActComCodigo ;
   private String A14SinCod ;
   private java.util.Date AV25LegFecIngreso ;
   private java.util.Date AV24LegFecEgreso ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Combo_legsincod_Allowmultipleselection ;
   private boolean Combo_legsincod_Includeonlyselectedoption ;
   private boolean Combo_legsincod_Emptyitem ;
   private boolean Combo_legcatcodigo_Allowmultipleselection ;
   private boolean Combo_legcatcodigo_Includeonlyselectedoption ;
   private boolean Combo_legcatcodigo_Emptyitem ;
   private boolean Combo_legseccodigo_Allowmultipleselection ;
   private boolean Combo_legseccodigo_Includeonlyselectedoption ;
   private boolean Combo_legseccodigo_Emptyitem ;
   private boolean Combo_legpuescodigo_Allowmultipleselection ;
   private boolean Combo_legpuescodigo_Includeonlyselectedoption ;
   private boolean Combo_legpuescodigo_Emptyitem ;
   private boolean Combo_legconvecodigo_Allowmultipleselection ;
   private boolean Combo_legconvecodigo_Includeonlyselectedoption ;
   private boolean Combo_legconvecodigo_Emptyitem ;
   private boolean wbLoad ;
   private boolean AV45LegIncompleto ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV11FilterFullText ;
   private String A1241PuestoDescrip ;
   private String A329SecDescrip ;
   private String A331SinDescrip ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV46httpRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV38Session ;
   private com.genexus.webpanels.GXUserControl ucCombo_legsincod ;
   private com.genexus.webpanels.GXUserControl ucCombo_legcatcodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_legseccodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_legpuescodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_legconvecodigo ;
   private HTMLChoice dynavLegsexo ;
   private HTMLChoice cmbavLegmodtra ;
   private HTMLChoice cmbavLegtipotarifa ;
   private HTMLChoice cmbavLegclase ;
   private HTMLChoice cmbavConveniofiltro ;
   private HTMLChoice dynavLegsuccodigo ;
   private HTMLChoice dynavLegactcodigo ;
   private HTMLChoice dynavMprcod ;
   private HTMLChoice dynavZoncod ;
   private HTMLChoice cmbavLegestado ;
   private ICheckbox chkavLegincompleto ;
   private IDataStoreProvider pr_default ;
   private byte[] H00MD2_A1743SexoId ;
   private String[] H00MD2_A1744SexoNombre ;
   private short[] H00MD2_A1742SexoPaiCod ;
   private String[] H00MD3_A1243SucCodigo ;
   private String[] H00MD3_A1244SucDescrip ;
   private int[] H00MD3_A3CliCod ;
   private short[] H00MD3_A1EmpCod ;
   private String[] H00MD4_A43ActCodigo ;
   private String[] H00MD4_A108ActDescrip ;
   private String[] H00MD5_A18MprCod ;
   private String[] H00MD5_A303MprDescrip ;
   private String[] H00MD6_A20ZonCod ;
   private String[] H00MD6_A342ZonDescrip ;
   private String[] H00MD7_A13SecCodigo ;
   private int[] H00MD7_A3CliCod ;
   private String[] H00MD7_A1241PuestoDescrip ;
   private String[] H00MD7_A1240PuestoCodigo ;
   private int[] H00MD8_A3CliCod ;
   private String[] H00MD8_A13SecCodigo ;
   private String[] H00MD8_A329SecDescrip ;
   private short[] H00MD9_A46PaiCod ;
   private String[] H00MD9_A903ActComCodigo ;
   private String[] H00MD9_A14SinCod ;
   private String[] H00MD9_A331SinDescrip ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV31LegSinCod ;
   private GXSimpleCollection<String> AV22LegConveCodigo ;
   private GXSimpleCollection<String> AV19LegCatCodigo ;
   private GXSimpleCollection<String> AV27LegPuesCodigo ;
   private GXSimpleCollection<String> AV28LegSecCodigo ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV32LegSinCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV20LegCatCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV42LegSecCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV43LegPuesCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV23LegConveCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXv_objcol_SdtDVB_SDTComboData_Item10[] ;
   private GXBaseCollection<web.Sdtsdt_convenios_sdt_conveniosItem> AV36sdt_convenios ;
   private GXBaseCollection<web.Sdtsdt_convenios_sdt_conveniosItem> GXv_objcol_Sdtsdt_convenios_sdt_conveniosItem7[] ;
   private GXBaseCollection<web.Sdtsdt_categorias_sdt_categoriasItem> AV41sdt_categorias ;
   private GXBaseCollection<web.Sdtsdt_categorias_sdt_categoriasItem> GXv_objcol_Sdtsdt_categorias_sdt_categoriasItem8[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV7Combo_DataItem ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV9DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState9[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.Sdtsdt_convenios_sdt_conveniosItem AV17itemSdt_Convenios ;
   private web.Sdtsdt_categorias_sdt_categoriasItem AV40itemCat ;
}

final  class legajofiltros__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00MD7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A13SecCodigo ,
                                          GXSimpleCollection<String> AV28LegSecCodigo ,
                                          int AV6CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[1];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT SecCodigo, CliCod, PuestoDescrip, PuestoCodigo FROM Puesto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV28LegSecCodigo, "SecCodigo IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, SecCodigo, PuestoCodigo" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 5 :
                  return conditional_H00MD7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00MD2", "SELECT SexoId, SexoNombre, SexoPaiCod FROM Sexos WHERE SexoPaiCod = ? ORDER BY SexoNombre ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00MD3", "SELECT SucCodigo, SucDescrip, CliCod, EmpCod FROM Sucursal WHERE (CliCod = ?) AND (EmpCod = ?) ORDER BY SucDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00MD4", "SELECT ActCodigo, ActDescrip FROM Actividad ORDER BY ActDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00MD5", "SELECT MprCod, MprDescrip FROM ModalidadAFIP ORDER BY MprDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00MD6", "SELECT ZonCod, ZonDescrip FROM Zona ORDER BY ZonDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00MD7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00MD8", "SELECT CliCod, SecCodigo, SecDescrip FROM Seccion WHERE CliCod = ? ORDER BY CliCod, SecDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00MD9", "SELECT PaiCod, ActComCodigo, SinCod, SinDescrip FROM Sindicato WHERE ActComCodigo = ( ?) ORDER BY SinDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[1]).intValue());
               }
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

