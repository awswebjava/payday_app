package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clienteconvenio_particularidadesabm_impl extends GXDataArea
{
   public clienteconvenio_particularidadesabm_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public clienteconvenio_particularidadesabm_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clienteconvenio_particularidadesabm_impl.class ));
   }

   public clienteconvenio_particularidadesabm_impl( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavClienteconvenio_particularidades_convediahspext = new HTMLChoice();
      chkavClienteconvenio_particularidades_convefondocese = UIFactory.getCheckbox(this);
      dynavClienteconvenio_particularidades_converelsec = new HTMLChoice();
      dynavClienteconvenio_particularidades_vacaciones__convevacrelsec = new HTMLChoice();
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CLIENTECONVENIO_PARTICULARIDADES_CONVERELSEC") == 0 )
         {
            AV15CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15CliCod), "ZZZZZ9")));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvclienteconvenio_particularidades_converelsecJH2( AV15CliCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC") == 0 )
         {
            AV15CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15CliCod), "ZZZZZ9")));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvclienteconvenio_particularidades_vacaciones__convevacrelsecJH2( AV15CliCod) ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_vacaciones") == 0 )
         {
            gxnrgridlevel_vacaciones_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridlevel_vacaciones") == 0 )
         {
            gxgrgridlevel_vacaciones_refresh_invoke( ) ;
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
            AV11TrnMode = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11TrnMode", AV11TrnMode);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11TrnMode, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV15CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15CliCod), 6, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15CliCod), "ZZZZZ9")));
               AV16CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliPaiConve), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16CliPaiConve), "ZZZ9")));
               AV17CliConvenio = httpContext.GetPar( "CliConvenio") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV17CliConvenio", AV17CliConvenio);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17CliConvenio, ""))));
               AV18CliConveVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveVig")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV18CliConveVig", localUtil.format(AV18CliConveVig, "99/99/99"));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEVIG", getSecureSignedToken( "", AV18CliConveVig));
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

   public void gxnrgridlevel_vacaciones_newrow_invoke( )
   {
      nRC_GXsfl_78 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_78"))) ;
      nGXsfl_78_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_78_idx"))) ;
      sGXsfl_78_idx = httpContext.GetPar( "sGXsfl_78_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_vacaciones_newrow( ) ;
      /* End function gxnrGridlevel_vacaciones_newrow_invoke */
   }

   public void gxgrgridlevel_vacaciones_refresh_invoke( )
   {
      subGridlevel_vacaciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_vacaciones_Rows"))) ;
      AV11TrnMode = httpContext.GetPar( "TrnMode") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV7ClienteConvenio_Particularidades);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV21ClienteConvenio_ParticularidadesVacacionesDeleted);
      AV15CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Convefondocese( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV16CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      AV17CliConvenio = httpContext.GetPar( "CliConvenio") ;
      AV18CliConveVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveVig")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, AV11TrnMode, AV7ClienteConvenio_Particularidades, AV21ClienteConvenio_ParticularidadesVacacionesDeleted, AV15CliCod, AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese(), AV16CliPaiConve, AV17CliConvenio, AV18CliConveVig) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridlevel_vacaciones_refresh_invoke */
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
      paJH2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startJH2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.clienteconvenio_particularidadesabm", new String[] {GXutil.URLEncode(GXutil.rtrim(AV11TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV15CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV16CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV17CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(AV18CliConveVig))}, new String[] {"TrnMode","CliCod","CliPaiConve","CliConvenio","CliConveVig"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEVIG", getSecureSignedToken( "", AV18CliConveVig));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Clienteconvenio_particularidades", AV7ClienteConvenio_Particularidades);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Clienteconvenio_particularidades", AV7ClienteConvenio_Particularidades);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_78", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_78, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTRNMODE", GXutil.rtrim( AV11TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11TrnMode, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLIENTECONVENIO_PARTICULARIDADESVACACIONESDELETED", AV21ClienteConvenio_ParticularidadesVacacionesDeleted);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLIENTECONVENIO_PARTICULARIDADESVACACIONESDELETED", AV21ClienteConvenio_ParticularidadesVacacionesDeleted);
      }
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCHECKREQUIREDFIELDSRESULT", AV13CheckRequiredFieldsResult);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMESSAGES", AV10Messages);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMESSAGES", AV10Messages);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV16CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV17CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVEVIG", localUtil.dtoc( AV18CliConveVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEVIG", getSecureSignedToken( "", AV18CliConveVig));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV15CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15CliCod), "ZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLIENTECONVENIO_PARTICULARIDADES", AV7ClienteConvenio_Particularidades);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLIENTECONVENIO_PARTICULARIDADES", AV7ClienteConvenio_Particularidades);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Rows, (byte)(6), (byte)(0), ".", "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Width", GXutil.rtrim( Dvpanel_unnamedtable1_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable1_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable1_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Cls", GXutil.rtrim( Dvpanel_unnamedtable1_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Title", GXutil.rtrim( Dvpanel_unnamedtable1_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable1_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable1_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable1_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridlevel_vacaciones_empowerer_Gridinternalname));
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
         weJH2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtJH2( ) ;
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
      return formatLink("web.clienteconvenio_particularidadesabm", new String[] {GXutil.URLEncode(GXutil.rtrim(AV11TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV15CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV16CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV17CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(AV18CliConveVig))}, new String[] {"TrnMode","CliCod","CliPaiConve","CliConvenio","CliConveVig"})  ;
   }

   public String getPgmname( )
   {
      return "ClienteConvenio_ParticularidadesABM" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Cliente Convenio_Particularidades ABM", "") ;
   }

   public void wbJH0( )
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
         wb_table1_9_JH2( true) ;
      }
      else
      {
         wb_table1_9_JH2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_JH2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'',false,'" + sGXsfl_78_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavClienteconvenio_particularidades_clicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Clicod(), (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Clicod()), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,100);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClienteconvenio_particularidades_clicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavClienteconvenio_particularidades_clicod_Visible, 1, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_ParticularidadesABM.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 101,'',false,'" + sGXsfl_78_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavClienteconvenio_particularidades_clipaiconve_Internalname, GXutil.ltrim( localUtil.ntoc( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Clipaiconve(), (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Clipaiconve()), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,101);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClienteconvenio_particularidades_clipaiconve_Jsonclick, 0, "Attribute", "", "", "", "", edtavClienteconvenio_particularidades_clipaiconve_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_ParticularidadesABM.htm");
         /* User Defined Control */
         ucGridlevel_vacaciones_empowerer.render(context, "wwp.gridempowerer", Gridlevel_vacaciones_empowerer_Internalname, "GRIDLEVEL_VACACIONES_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 78 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Gridlevel_vacacionesContainer.AddObjectProperty("GRIDLEVEL_VACACIONES_nEOF", GRIDLEVEL_VACACIONES_nEOF);
               Gridlevel_vacacionesContainer.AddObjectProperty("GRIDLEVEL_VACACIONES_nFirstRecordOnPage", GRIDLEVEL_VACACIONES_nFirstRecordOnPage);
               AV37GXV11 = nGXsfl_78_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Gridlevel_vacacionesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_vacaciones", Gridlevel_vacacionesContainer, subGridlevel_vacaciones_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_vacacionesContainerData", Gridlevel_vacacionesContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_vacacionesContainerData"+"V", Gridlevel_vacacionesContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_vacacionesContainerData"+"V"+"\" value='"+Gridlevel_vacacionesContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startJH2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Cliente Convenio_Particularidades ABM", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupJH0( ) ;
   }

   public void wsJH2( )
   {
      startJH2( ) ;
      evtJH2( ) ;
   }

   public void evtJH2( )
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
                        else if ( GXutil.strcmp(sEvt, "'DOADDGRIDLINEGRIDLEVEL_VACACIONES'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoAddGridLineGridLevel_Vacaciones' */
                           e11JH2 ();
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
                                 e12JH2 ();
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
                        else if ( GXutil.strcmp(sEvt, "GRIDLEVEL_VACACIONESPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDLEVEL_VACACIONESPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridlevel_vacaciones_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridlevel_vacaciones_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridlevel_vacaciones_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridlevel_vacaciones_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 25), "GRIDLEVEL_VACACIONES.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 41), "VDELETEGRIDLINEGRIDLEVEL_VACACIONES.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 41), "VDELETEGRIDLINEGRIDLEVEL_VACACIONES.CLICK") == 0 ) )
                        {
                           nGXsfl_78_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_782( ) ;
                           AV37GXV11 = (int)(nGXsfl_78_idx+GRIDLEVEL_VACACIONES_nFirstRecordOnPage) ;
                           if ( ( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().size() >= AV37GXV11 ) && ( AV37GXV11 > 0 ) )
                           {
                              AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().currentItem( ((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)) );
                              AV8DeleteGridLineGridLevel_Vacaciones = httpContext.cgiGet( edtavDeletegridlinegridlevel_vacaciones_Internalname) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavDeletegridlinegridlevel_vacaciones_Internalname, AV8DeleteGridLineGridLevel_Vacaciones);
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
                                 e13JH2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e14JH2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDLEVEL_VACACIONES.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e15JH2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VDELETEGRIDLINEGRIDLEVEL_VACACIONES.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e16JH2 ();
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

   public void weJH2( )
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

   public void paJH2( )
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
            GX_FocusControl = edtavClienteconvenio_particularidades_cliconvenio_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvclienteconvenio_particularidades_converelsecJH2( int AV15CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvclienteconvenio_particularidades_converelsec_dataJH2( AV15CliCod) ;
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

   public void gxvclienteconvenio_particularidades_converelsec_htmlJH2( int AV15CliCod )
   {
      int gxdynajaxvalue;
      gxdlvclienteconvenio_particularidades_converelsec_dataJH2( AV15CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavClienteconvenio_particularidades_converelsec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavClienteconvenio_particularidades_converelsec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvclienteconvenio_particularidades_converelsec_dataJH2( int AV15CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00JH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV15CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00JH2_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00JH2_A1880CliReDTChar[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvclienteconvenio_particularidades_vacaciones__convevacrelsecJH2( int AV15CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvclienteconvenio_particularidades_vacaciones__convevacrelsec_dataJH2( AV15CliCod) ;
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

   public void gxvclienteconvenio_particularidades_vacaciones__convevacrelsec_htmlJH2( int AV15CliCod )
   {
      int gxdynajaxvalue;
      gxdlvclienteconvenio_particularidades_vacaciones__convevacrelsec_dataJH2( AV15CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvclienteconvenio_particularidades_vacaciones__convevacrelsec_dataJH2( int AV15CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00JH3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV15CliCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00JH3_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00JH3_A1880CliReDTChar[0]);
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxnrgridlevel_vacaciones_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_782( ) ;
      while ( nGXsfl_78_idx <= nRC_GXsfl_78 )
      {
         sendrow_782( ) ;
         nGXsfl_78_idx = ((subGridlevel_vacaciones_Islastpage==1)&&(nGXsfl_78_idx+1>subgridlevel_vacaciones_fnc_recordsperpage( )) ? 1 : nGXsfl_78_idx+1) ;
         sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_782( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_vacacionesContainer)) ;
      /* End function gxnrGridlevel_vacaciones_newrow */
   }

   public void gxgrgridlevel_vacaciones_refresh( int subGridlevel_vacaciones_Rows ,
                                                 String AV11TrnMode ,
                                                 web.SdtClienteConvenio_Particularidades AV7ClienteConvenio_Particularidades ,
                                                 GXSimpleCollection<Short> AV21ClienteConvenio_ParticularidadesVacacionesDeleted ,
                                                 int AV15CliCod ,
                                                 boolean GXV5 ,
                                                 short AV16CliPaiConve ,
                                                 String AV17CliConvenio ,
                                                 java.util.Date AV18CliConveVig )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e14JH2 ();
      GRIDLEVEL_VACACIONES_nCurrentRecord = 0 ;
      rfJH2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridlevel_vacaciones_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         gxvclienteconvenio_particularidades_converelsec_htmlJH2( AV15CliCod) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavClienteconvenio_particularidades_convediahspext.getItemCount() > 0 )
      {
         AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Convediahspext( cmbavClienteconvenio_particularidades_convediahspext.getValidValue(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convediahspext()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavClienteconvenio_particularidades_convediahspext.setValue( GXutil.rtrim( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convediahspext()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavClienteconvenio_particularidades_convediahspext.getInternalname(), "Values", cmbavClienteconvenio_particularidades_convediahspext.ToJavascriptSource(), true);
      }
      if ( dynavClienteconvenio_particularidades_converelsec.getItemCount() > 0 )
      {
         AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Converelsec( (int)(GXutil.lval( dynavClienteconvenio_particularidades_converelsec.getValidValue(GXutil.trim( GXutil.str( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Converelsec(), 6, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavClienteconvenio_particularidades_converelsec.setValue( GXutil.trim( GXutil.str( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Converelsec(), 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavClienteconvenio_particularidades_converelsec.getInternalname(), "Values", dynavClienteconvenio_particularidades_converelsec.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfJH2( ) ;
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
      edtavDeletegridlinegridlevel_vacaciones_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDeletegridlinegridlevel_vacaciones_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDeletegridlinegridlevel_vacaciones_Enabled), 5, 0), !bGXsfl_78_Refreshing);
   }

   public void rfJH2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_vacacionesContainer.ClearRows();
      }
      wbStart = (short)(78) ;
      /* Execute user event: Refresh */
      e14JH2 ();
      nGXsfl_78_idx = 1 ;
      sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_782( ) ;
      bGXsfl_78_Refreshing = true ;
      Gridlevel_vacacionesContainer.AddObjectProperty("GridName", "Gridlevel_vacaciones");
      Gridlevel_vacacionesContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_vacacionesContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_vacacionesContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_vacacionesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_vacacionesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_vacacionesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_vacacionesContainer.setPageSize( subgridlevel_vacaciones_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_782( ) ;
         e15JH2 ();
         if ( ( GRIDLEVEL_VACACIONES_nCurrentRecord > 0 ) && ( GRIDLEVEL_VACACIONES_nGridOutOfScope == 0 ) && ( nGXsfl_78_idx == 1 ) )
         {
            GRIDLEVEL_VACACIONES_nCurrentRecord = 0 ;
            GRIDLEVEL_VACACIONES_nGridOutOfScope = 1 ;
            subgridlevel_vacaciones_firstpage( ) ;
            e15JH2 ();
         }
         wbEnd = (short)(78) ;
         wbJH0( ) ;
      }
      bGXsfl_78_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesJH2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vTRNMODE", GXutil.rtrim( AV11TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV15CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15CliCod), "ZZZZZ9")));
   }

   public int subgridlevel_vacaciones_fnc_pagecount( )
   {
      GRIDLEVEL_VACACIONES_nRecordCount = subgridlevel_vacaciones_fnc_recordcount( ) ;
      if ( ((int)((GRIDLEVEL_VACACIONES_nRecordCount) % (subgridlevel_vacaciones_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDLEVEL_VACACIONES_nRecordCount/ (double) (subgridlevel_vacaciones_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDLEVEL_VACACIONES_nRecordCount/ (double) (subgridlevel_vacaciones_fnc_recordsperpage( )))+1) ;
   }

   public int subgridlevel_vacaciones_fnc_recordcount( )
   {
      return AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().size() ;
   }

   public int subgridlevel_vacaciones_fnc_recordsperpage( )
   {
      if ( subGridlevel_vacaciones_Rows > 0 )
      {
         return subGridlevel_vacaciones_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridlevel_vacaciones_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDLEVEL_VACACIONES_nFirstRecordOnPage/ (double) (subgridlevel_vacaciones_fnc_recordsperpage( )))+1) ;
   }

   public short subgridlevel_vacaciones_firstpage( )
   {
      GRIDLEVEL_VACACIONES_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, AV11TrnMode, AV7ClienteConvenio_Particularidades, AV21ClienteConvenio_ParticularidadesVacacionesDeleted, AV15CliCod, AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese(), AV16CliPaiConve, AV17CliConvenio, AV18CliConveVig) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_vacaciones_nextpage( )
   {
      GRIDLEVEL_VACACIONES_nRecordCount = subgridlevel_vacaciones_fnc_recordcount( ) ;
      if ( ( GRIDLEVEL_VACACIONES_nRecordCount >= subgridlevel_vacaciones_fnc_recordsperpage( ) ) && ( GRIDLEVEL_VACACIONES_nEOF == 0 ) )
      {
         GRIDLEVEL_VACACIONES_nFirstRecordOnPage = (long)(GRIDLEVEL_VACACIONES_nFirstRecordOnPage+subgridlevel_vacaciones_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Gridlevel_vacacionesContainer.AddObjectProperty("GRIDLEVEL_VACACIONES_nFirstRecordOnPage", GRIDLEVEL_VACACIONES_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, AV11TrnMode, AV7ClienteConvenio_Particularidades, AV21ClienteConvenio_ParticularidadesVacacionesDeleted, AV15CliCod, AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese(), AV16CliPaiConve, AV17CliConvenio, AV18CliConveVig) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDLEVEL_VACACIONES_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridlevel_vacaciones_previouspage( )
   {
      if ( GRIDLEVEL_VACACIONES_nFirstRecordOnPage >= subgridlevel_vacaciones_fnc_recordsperpage( ) )
      {
         GRIDLEVEL_VACACIONES_nFirstRecordOnPage = (long)(GRIDLEVEL_VACACIONES_nFirstRecordOnPage-subgridlevel_vacaciones_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, AV11TrnMode, AV7ClienteConvenio_Particularidades, AV21ClienteConvenio_ParticularidadesVacacionesDeleted, AV15CliCod, AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese(), AV16CliPaiConve, AV17CliConvenio, AV18CliConveVig) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_vacaciones_lastpage( )
   {
      GRIDLEVEL_VACACIONES_nRecordCount = subgridlevel_vacaciones_fnc_recordcount( ) ;
      if ( GRIDLEVEL_VACACIONES_nRecordCount > subgridlevel_vacaciones_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDLEVEL_VACACIONES_nRecordCount) % (subgridlevel_vacaciones_fnc_recordsperpage( )))) == 0 )
         {
            GRIDLEVEL_VACACIONES_nFirstRecordOnPage = (long)(GRIDLEVEL_VACACIONES_nRecordCount-subgridlevel_vacaciones_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDLEVEL_VACACIONES_nFirstRecordOnPage = (long)(GRIDLEVEL_VACACIONES_nRecordCount-((int)((GRIDLEVEL_VACACIONES_nRecordCount) % (subgridlevel_vacaciones_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDLEVEL_VACACIONES_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, AV11TrnMode, AV7ClienteConvenio_Particularidades, AV21ClienteConvenio_ParticularidadesVacacionesDeleted, AV15CliCod, AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese(), AV16CliPaiConve, AV17CliConvenio, AV18CliConveVig) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridlevel_vacaciones_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDLEVEL_VACACIONES_nFirstRecordOnPage = (long)(subgridlevel_vacaciones_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDLEVEL_VACACIONES_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, AV11TrnMode, AV7ClienteConvenio_Particularidades, AV21ClienteConvenio_ParticularidadesVacacionesDeleted, AV15CliCod, AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese(), AV16CliPaiConve, AV17CliConvenio, AV18CliConveVig) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavDeletegridlinegridlevel_vacaciones_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDeletegridlinegridlevel_vacaciones_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDeletegridlinegridlevel_vacaciones_Enabled), 5, 0), !bGXsfl_78_Refreshing);
      gxvclienteconvenio_particularidades_converelsec_htmlJH2( AV15CliCod) ;
      gxvclienteconvenio_particularidades_vacaciones__convevacrelsec_htmlJH2( AV15CliCod) ;
      fix_multi_value_controls( ) ;
   }

   public void strupJH0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13JH2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLIENTECONVENIO_PARTICULARIDADES"), AV7ClienteConvenio_Particularidades);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Clienteconvenio_particularidades"), AV7ClienteConvenio_Particularidades);
         /* Read saved values. */
         nRC_GXsfl_78 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_78"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRIDLEVEL_VACACIONES_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDLEVEL_VACACIONES_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRIDLEVEL_VACACIONES_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDLEVEL_VACACIONES_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGridlevel_vacaciones_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDLEVEL_VACACIONES_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Rows, (byte)(6), (byte)(0), ".", "")));
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
         Dvpanel_unnamedtable1_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Width") ;
         Dvpanel_unnamedtable1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autowidth")) ;
         Dvpanel_unnamedtable1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoheight")) ;
         Dvpanel_unnamedtable1_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Cls") ;
         Dvpanel_unnamedtable1_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Title") ;
         Dvpanel_unnamedtable1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsible")) ;
         Dvpanel_unnamedtable1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsed")) ;
         Dvpanel_unnamedtable1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showcollapseicon")) ;
         Dvpanel_unnamedtable1_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Iconposition") ;
         Dvpanel_unnamedtable1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoscroll")) ;
         Gridlevel_vacaciones_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDLEVEL_VACACIONES_EMPOWERER_Gridinternalname") ;
         nRC_GXsfl_78 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_78"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_78_fel_idx = 0 ;
         while ( nGXsfl_78_fel_idx < nRC_GXsfl_78 )
         {
            nGXsfl_78_fel_idx = ((subGridlevel_vacaciones_Islastpage==1)&&(nGXsfl_78_fel_idx+1>subgridlevel_vacaciones_fnc_recordsperpage( )) ? 1 : nGXsfl_78_fel_idx+1) ;
            sGXsfl_78_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_782( ) ;
            AV37GXV11 = (int)(nGXsfl_78_fel_idx+GRIDLEVEL_VACACIONES_nFirstRecordOnPage) ;
            if ( ( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().size() >= AV37GXV11 ) && ( AV37GXV11 > 0 ) )
            {
               AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().currentItem( ((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)) );
               AV8DeleteGridLineGridLevel_Vacaciones = httpContext.cgiGet( edtavDeletegridlinegridlevel_vacaciones_Internalname) ;
            }
         }
         if ( nGXsfl_78_fel_idx == 0 )
         {
            nGXsfl_78_idx = 1 ;
            sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_782( ) ;
         }
         nGXsfl_78_fel_idx = 1 ;
         /* Read variables values. */
         AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio( httpContext.cgiGet( edtavClienteconvenio_particularidades_cliconvenio_Internalname) );
         if ( localUtil.vcdate( httpContext.cgiGet( edtavClienteconvenio_particularidades_cliconvevig_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "CLIENTECONVENIO_PARTICULARIDADES_CLICONVEVIG");
            GX_FocusControl = edtavClienteconvenio_particularidades_cliconvevig_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig( GXutil.nullDate() );
         }
         else
         {
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig( localUtil.ctod( httpContext.cgiGet( edtavClienteconvenio_particularidades_cliconvevig_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) );
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavClienteconvenio_particularidades_convemeshspext_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavClienteconvenio_particularidades_convemeshspext_Internalname)), DecimalUtil.stringToDec("999.9")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIENTECONVENIO_PARTICULARIDADES_CONVEMESHSPEXT");
            GX_FocusControl = edtavClienteconvenio_particularidades_convemeshspext_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Convemeshspext( DecimalUtil.ZERO );
         }
         else
         {
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Convemeshspext( localUtil.ctond( httpContext.cgiGet( edtavClienteconvenio_particularidades_convemeshspext_Internalname)) );
         }
         cmbavClienteconvenio_particularidades_convediahspext.setName( cmbavClienteconvenio_particularidades_convediahspext.getInternalname() );
         cmbavClienteconvenio_particularidades_convediahspext.setValue( httpContext.cgiGet( cmbavClienteconvenio_particularidades_convediahspext.getInternalname()) );
         AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Convediahspext( httpContext.cgiGet( cmbavClienteconvenio_particularidades_convediahspext.getInternalname()) );
         AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Convefondocese( GXutil.strtobool( httpContext.cgiGet( chkavClienteconvenio_particularidades_convefondocese.getInternalname())) );
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_conveguaredadmin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_conveguaredadmin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIENTECONVENIO_PARTICULARIDADES_CONVEGUAREDADMIN");
            GX_FocusControl = edtavClienteconvenio_particularidades_conveguaredadmin_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin( (byte)(0) );
         }
         else
         {
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin( (byte)(localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_conveguaredadmin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_conveguaredadmax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_conveguaredadmax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIENTECONVENIO_PARTICULARIDADES_CONVEGUAREDADMAX");
            GX_FocusControl = edtavClienteconvenio_particularidades_conveguaredadmax_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax( (byte)(0) );
         }
         else
         {
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax( (byte)(localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_conveguaredadmax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         dynavClienteconvenio_particularidades_converelsec.setName( dynavClienteconvenio_particularidades_converelsec.getInternalname() );
         dynavClienteconvenio_particularidades_converelsec.setValue( httpContext.cgiGet( dynavClienteconvenio_particularidades_converelsec.getInternalname()) );
         AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Converelsec( (int)(GXutil.lval( httpContext.cgiGet( dynavClienteconvenio_particularidades_converelsec.getInternalname()))) );
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_conveinterdiasjor_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_conveinterdiasjor_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIENTECONVENIO_PARTICULARIDADES_CONVEINTERDIASJOR");
            GX_FocusControl = edtavClienteconvenio_particularidades_conveinterdiasjor_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor( (short)(0) );
         }
         else
         {
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor( (short)(localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_conveinterdiasjor_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_conveminmesesvac_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_conveminmesesvac_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIENTECONVENIO_PARTICULARIDADES_CONVEMINMESESVAC");
            GX_FocusControl = edtavClienteconvenio_particularidades_conveminmesesvac_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac( (byte)(0) );
         }
         else
         {
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac( (byte)(localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_conveminmesesvac_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIENTECONVENIO_PARTICULARIDADES_CLICOD");
            GX_FocusControl = edtavClienteconvenio_particularidades_clicod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Clicod( 0 );
         }
         else
         {
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Clicod( (int)(localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_clipaiconve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_clipaiconve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIENTECONVENIO_PARTICULARIDADES_CLIPAICONVE");
            GX_FocusControl = edtavClienteconvenio_particularidades_clipaiconve_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve( (short)(0) );
         }
         else
         {
            AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve( (short)(localUtil.ctol( httpContext.cgiGet( edtavClienteconvenio_particularidades_clipaiconve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
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
      e13JH2 ();
      if (returnInSub) return;
   }

   public void e13JH2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      AV12LoadSuccess = true ;
      if ( ( ( GXutil.strcmp(AV11TrnMode, "DSP") == 0 ) ) || ( ( GXutil.strcmp(AV11TrnMode, "INS") == 0 ) ) || ( ( GXutil.strcmp(AV11TrnMode, "UPD") == 0 ) ) || ( ( GXutil.strcmp(AV11TrnMode, "DLT") == 0 ) ) )
      {
         if ( GXutil.strcmp(AV11TrnMode, "INS") != 0 )
         {
            AV7ClienteConvenio_Particularidades.Load(AV15CliCod, AV16CliPaiConve, AV17CliConvenio, AV18CliConveVig);
            gx_BV78 = true ;
            AV12LoadSuccess = AV7ClienteConvenio_Particularidades.Success() ;
            if ( ! AV12LoadSuccess )
            {
               AV10Messages = AV7ClienteConvenio_Particularidades.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
            if ( ( GXutil.strcmp(AV11TrnMode, "DSP") == 0 ) || ( GXutil.strcmp(AV11TrnMode, "DLT") == 0 ) )
            {
               edtavClienteconvenio_particularidades_conveinterdiasjor_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavClienteconvenio_particularidades_conveinterdiasjor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClienteconvenio_particularidades_conveinterdiasjor_Enabled), 5, 0), true);
               edtavClienteconvenio_particularidades_conveminmesesvac_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavClienteconvenio_particularidades_conveminmesesvac_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClienteconvenio_particularidades_conveminmesesvac_Enabled), 5, 0), true);
               edtavClienteconvenio_particularidades_convemeshspext_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavClienteconvenio_particularidades_convemeshspext_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClienteconvenio_particularidades_convemeshspext_Enabled), 5, 0), true);
               cmbavClienteconvenio_particularidades_convediahspext.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavClienteconvenio_particularidades_convediahspext.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavClienteconvenio_particularidades_convediahspext.getEnabled(), 5, 0), true);
               chkavClienteconvenio_particularidades_convefondocese.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavClienteconvenio_particularidades_convefondocese.getInternalname(), "Enabled", GXutil.ltrimstr( chkavClienteconvenio_particularidades_convefondocese.getEnabled(), 5, 0), true);
               edtavClienteconvenio_particularidades_conveguaredadmin_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavClienteconvenio_particularidades_conveguaredadmin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClienteconvenio_particularidades_conveguaredadmin_Enabled), 5, 0), true);
               edtavClienteconvenio_particularidades_conveguaredadmax_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavClienteconvenio_particularidades_conveguaredadmax_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClienteconvenio_particularidades_conveguaredadmax_Enabled), 5, 0), true);
               dynavClienteconvenio_particularidades_converelsec.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, dynavClienteconvenio_particularidades_converelsec.getInternalname(), "Enabled", GXutil.ltrimstr( dynavClienteconvenio_particularidades_converelsec.getEnabled(), 5, 0), true);
            }
            edtavClienteconvenio_particularidades_cliconvenio_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavClienteconvenio_particularidades_cliconvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClienteconvenio_particularidades_cliconvenio_Enabled), 5, 0), true);
            edtavClienteconvenio_particularidades_cliconvevig_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavClienteconvenio_particularidades_cliconvevig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClienteconvenio_particularidades_cliconvevig_Enabled), 5, 0), true);
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
      edtavClienteconvenio_particularidades_clicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClienteconvenio_particularidades_clicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClienteconvenio_particularidades_clicod_Visible), 5, 0), true);
      edtavClienteconvenio_particularidades_clipaiconve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClienteconvenio_particularidades_clipaiconve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClienteconvenio_particularidades_clipaiconve_Visible), 5, 0), true);
      Gridlevel_vacaciones_empowerer_Gridinternalname = subGridlevel_vacaciones_Internalname ;
      ucGridlevel_vacaciones_empowerer.sendProperty(context, "", false, Gridlevel_vacaciones_empowerer_Internalname, "GridInternalName", Gridlevel_vacaciones_empowerer_Gridinternalname);
      subGridlevel_vacaciones_Rows = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Rows, (byte)(6), (byte)(0), ".", "")));
      if ( GXutil.strcmp(AV11TrnMode, "INS") == 0 )
      {
         AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Clicod( AV15CliCod );
         AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve( AV16CliPaiConve );
         AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio( AV17CliConvenio );
      }
   }

   public void e14JH2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S122 ();
      if (returnInSub) return;
      edtavDeletegridlinegridlevel_vacaciones_Columnheaderclass = "WWIconActionColumn" ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDeletegridlinegridlevel_vacaciones_Internalname, "Columnheaderclass", edtavDeletegridlinegridlevel_vacaciones_Columnheaderclass, !bGXsfl_78_Refreshing);
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Columnheaderclass = "WWColumn" ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Internalname, "Columnheaderclass", edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Columnheaderclass, !bGXsfl_78_Refreshing);
      edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Columnheaderclass = "WWColumn" ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Internalname, "Columnheaderclass", edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Columnheaderclass, !bGXsfl_78_Refreshing);
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Columnheaderclass = "WWColumn" ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Internalname, "Columnheaderclass", edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Columnheaderclass, !bGXsfl_78_Refreshing);
      dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setColumnHeaderClass( "WWColumn" );
      httpContext.ajax_rsp_assign_prop("", false, dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getInternalname(), "Columnheaderclass", dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getColumnHeaderClass(), !bGXsfl_78_Refreshing);
      /*  Sending Event outputs  */
   }

   private void e15JH2( )
   {
      /* Gridlevel_vacaciones_Load Routine */
      returnInSub = false ;
      AV37GXV11 = 1 ;
      while ( AV37GXV11 <= AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().size() )
      {
         AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().currentItem( ((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)) );
         AV14LineDeleted = (boolean)(((AV21ClienteConvenio_ParticularidadesVacacionesDeleted.indexof(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().indexof(((web.SdtClienteConvenio_Particularidades_Vacaciones)(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().currentItem()))))>0))) ;
         edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Enabled = (((GXutil.strcmp(AV11TrnMode, "INS")==0)||(GXutil.strcmp(AV11TrnMode, "UPD")==0))&&(!AV14LineDeleted)&&GXutil.contains( ((web.SdtClienteConvenio_Particularidades_Vacaciones)(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().currentItem())).toxml(false, true, "", "PayDay"), "<Mode>INS</Mode>") ? 1 : 0) ;
         edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Enabled = (((GXutil.strcmp(AV11TrnMode, "INS")==0)||(GXutil.strcmp(AV11TrnMode, "UPD")==0))&&(!AV14LineDeleted) ? 1 : 0) ;
         edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Enabled = (((GXutil.strcmp(AV11TrnMode, "INS")==0)||(GXutil.strcmp(AV11TrnMode, "UPD")==0))&&(!AV14LineDeleted) ? 1 : 0) ;
         dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setEnabled( (((GXutil.strcmp(AV11TrnMode, "INS")==0)||(GXutil.strcmp(AV11TrnMode, "UPD")==0))&&(!AV14LineDeleted) ? 1 : 0) );
         AV8DeleteGridLineGridLevel_Vacaciones = "<i class=\"fa fa-times TrnGridDelete\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDeletegridlinegridlevel_vacaciones_Internalname, AV8DeleteGridLineGridLevel_Vacaciones);
         if ( ( GXutil.strcmp(AV11TrnMode, "INS") == 0 ) || ( GXutil.strcmp(AV11TrnMode, "UPD") == 0 ) )
         {
            edtavDeletegridlinegridlevel_vacaciones_Class = "Attribute" ;
         }
         else
         {
            edtavDeletegridlinegridlevel_vacaciones_Class = "Invisible" ;
         }
         edtavDeletegridlinegridlevel_vacaciones_Columnclass = (AV14LineDeleted ? "WWIconActionColumn WWColumnLineThrough WWColumnLineThroughFirstColumn" : "WWIconActionColumn") ;
         edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Columnclass = (AV14LineDeleted ? "WWColumn WWColumnLineThrough" : "WWColumn") ;
         edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Columnclass = (AV14LineDeleted ? "WWColumn WWColumnLineThrough" : "WWColumn") ;
         edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Columnclass = (AV14LineDeleted ? "WWColumn WWColumnLineThrough" : "WWColumn") ;
         dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setColumnClass( (AV14LineDeleted ? "WWColumn WWColumnLineThrough" : "WWColumn") );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(78) ;
         }
         if ( ( subGridlevel_vacaciones_Islastpage == 1 ) || ( subGridlevel_vacaciones_Rows == 0 ) || ( ( GRIDLEVEL_VACACIONES_nCurrentRecord >= GRIDLEVEL_VACACIONES_nFirstRecordOnPage ) && ( GRIDLEVEL_VACACIONES_nCurrentRecord < GRIDLEVEL_VACACIONES_nFirstRecordOnPage + subgridlevel_vacaciones_fnc_recordsperpage( ) ) ) )
         {
            sendrow_782( ) ;
            GRIDLEVEL_VACACIONES_nEOF = (byte)(0) ;
            web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDLEVEL_VACACIONES_nCurrentRecord + 1 >= subgridlevel_vacaciones_fnc_recordcount( ) )
            {
               GRIDLEVEL_VACACIONES_nEOF = (byte)(1) ;
               web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDLEVEL_VACACIONES_nCurrentRecord = (long)(GRIDLEVEL_VACACIONES_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_78_Refreshing )
         {
            httpContext.doAjaxLoad(78, Gridlevel_vacacionesRow);
         }
         AV37GXV11 = (int)(AV37GXV11+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e11JH2( )
   {
      AV37GXV11 = (int)(nGXsfl_78_idx+GRIDLEVEL_VACACIONES_nFirstRecordOnPage) ;
      if ( ( AV37GXV11 > 0 ) && ( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().size() >= AV37GXV11 ) )
      {
         AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().currentItem( ((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)) );
      }
      /* 'DoAddGridLineGridLevel_Vacaciones' Routine */
      returnInSub = false ;
      AV19ClienteConvenio_ParticularidadesVacacionesItem = (web.SdtClienteConvenio_Particularidades_Vacaciones)new web.SdtClienteConvenio_Particularidades_Vacaciones( remoteHandle, context);
      AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().add(AV19ClienteConvenio_ParticularidadesVacacionesItem, 0);
      gx_BV78 = true ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV7ClienteConvenio_Particularidades", AV7ClienteConvenio_Particularidades);
      nGXsfl_78_bak_idx = nGXsfl_78_idx ;
      gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, AV11TrnMode, AV7ClienteConvenio_Particularidades, AV21ClienteConvenio_ParticularidadesVacacionesDeleted, AV15CliCod, AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese(), AV16CliPaiConve, AV17CliConvenio, AV18CliConveVig) ;
      nGXsfl_78_idx = nGXsfl_78_bak_idx ;
      sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_782( ) ;
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e12JH2 ();
      if (returnInSub) return;
   }

   public void e12JH2( )
   {
      AV37GXV11 = (int)(nGXsfl_78_idx+GRIDLEVEL_VACACIONES_nFirstRecordOnPage) ;
      if ( ( AV37GXV11 > 0 ) && ( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().size() >= AV37GXV11 ) )
      {
         AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().currentItem( ((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)) );
      }
      /* Enter Routine */
      returnInSub = false ;
      AV23ok = true ;
      if ( ( GXutil.strcmp(AV11TrnMode, "INS") == 0 ) || ( GXutil.strcmp(AV11TrnMode, "UPD") == 0 ) )
      {
         GXv_boolean1[0] = AV22aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV15CliCod, AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Converelsec(), GXv_boolean1) ;
         clienteconvenio_particularidadesabm_impl.this.AV22aplicadoHay = GXv_boolean1[0] ;
         if ( AV22aplicadoHay )
         {
            new web.alert(remoteHandle, context).execute( "error", new web.txterrorrelease(remoteHandle, context).executeUdp( AV15CliCod)) ;
            AV23ok = false ;
         }
         if ( AV23ok )
         {
            AV24i = (short)(1) ;
            while ( ( AV24i <= AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().size() ) && ( AV23ok ) )
            {
               GXv_boolean1[0] = AV22aplicadoHay ;
               new web.validarfecharelease(remoteHandle, context).execute( AV15CliCod, ((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV24i)).getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec(), GXv_boolean1) ;
               clienteconvenio_particularidadesabm_impl.this.AV22aplicadoHay = GXv_boolean1[0] ;
               if ( AV22aplicadoHay )
               {
                  new web.alert(remoteHandle, context).execute( "error", new web.txterrorrelease(remoteHandle, context).executeUdp( AV15CliCod)) ;
                  AV23ok = false ;
               }
               AV24i = (short)(AV24i+1) ;
            }
         }
      }
      if ( AV23ok )
      {
         if ( GXutil.strcmp(AV11TrnMode, "DSP") != 0 )
         {
            if ( GXutil.strcmp(AV11TrnMode, "DLT") != 0 )
            {
               /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
               S132 ();
               if (returnInSub) return;
            }
            if ( ( GXutil.strcmp(AV11TrnMode, "DLT") == 0 ) || AV13CheckRequiredFieldsResult )
            {
               if ( GXutil.strcmp(AV11TrnMode, "DLT") == 0 )
               {
                  AV7ClienteConvenio_Particularidades.Delete();
                  gx_BV78 = true ;
               }
               else
               {
                  AV21ClienteConvenio_ParticularidadesVacacionesDeleted.sort("");
                  while ( AV21ClienteConvenio_ParticularidadesVacacionesDeleted.size() > 0 )
                  {
                     AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().removeItem(((Number) AV21ClienteConvenio_ParticularidadesVacacionesDeleted.elementAt(-1+AV21ClienteConvenio_ParticularidadesVacacionesDeleted.size())).shortValue());
                     gx_BV78 = true ;
                     AV21ClienteConvenio_ParticularidadesVacacionesDeleted.removeItem(AV21ClienteConvenio_ParticularidadesVacacionesDeleted.size());
                  }
                  AV7ClienteConvenio_Particularidades.Save();
                  gx_BV78 = true ;
               }
               if ( AV7ClienteConvenio_Particularidades.Success() )
               {
                  /* Execute user subroutine: 'AFTER_TRN' */
                  S142 ();
                  if (returnInSub) return;
               }
               else
               {
                  AV10Messages = AV7ClienteConvenio_Particularidades.GetMessages() ;
                  /* Execute user subroutine: 'SHOW MESSAGES' */
                  S112 ();
                  if (returnInSub) return;
               }
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ClienteConvenio_ParticularidadesVacacionesDeleted", AV21ClienteConvenio_ParticularidadesVacacionesDeleted);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV7ClienteConvenio_Particularidades", AV7ClienteConvenio_Particularidades);
      nGXsfl_78_bak_idx = nGXsfl_78_idx ;
      gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, AV11TrnMode, AV7ClienteConvenio_Particularidades, AV21ClienteConvenio_ParticularidadesVacacionesDeleted, AV15CliCod, AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese(), AV16CliPaiConve, AV17CliConvenio, AV18CliConveVig) ;
      nGXsfl_78_idx = nGXsfl_78_bak_idx ;
      sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_782( ) ;
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10Messages", AV10Messages);
   }

   public void e16JH2( )
   {
      AV37GXV11 = (int)(nGXsfl_78_idx+GRIDLEVEL_VACACIONES_nFirstRecordOnPage) ;
      if ( ( AV37GXV11 > 0 ) && ( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().size() >= AV37GXV11 ) )
      {
         AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().currentItem( ((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)) );
      }
      /* Deletegridlinegridlevel_vacaciones_Click Routine */
      returnInSub = false ;
      AV20Index = (short)(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().indexof(((web.SdtClienteConvenio_Particularidades_Vacaciones)(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().currentItem())))) ;
      if ( AV21ClienteConvenio_ParticularidadesVacacionesDeleted.indexof(AV20Index) > 0 )
      {
         AV21ClienteConvenio_ParticularidadesVacacionesDeleted.removeItem(AV21ClienteConvenio_ParticularidadesVacacionesDeleted.indexof(AV20Index));
      }
      else
      {
         AV21ClienteConvenio_ParticularidadesVacacionesDeleted.add((short)(AV20Index), 0);
      }
      gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, AV11TrnMode, AV7ClienteConvenio_Particularidades, AV21ClienteConvenio_ParticularidadesVacacionesDeleted, AV15CliCod, AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese(), AV16CliPaiConve, AV17CliConvenio, AV18CliConveVig) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ClienteConvenio_ParticularidadesVacacionesDeleted", AV21ClienteConvenio_ParticularidadesVacacionesDeleted);
   }

   public void S122( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(AV11TrnMode, "DSP") != 0 ) ) )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      }
      if ( ! ( ( GXutil.strcmp(AV11TrnMode, "INS") == 0 ) || ( GXutil.strcmp(AV11TrnMode, "UPD") == 0 ) ) )
      {
         bttBtnaddgridlinegridlevel_vacaciones_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnaddgridlinegridlevel_vacaciones_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnaddgridlinegridlevel_vacaciones_Visible), 5, 0), true);
      }
   }

   public void S132( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV13CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13CheckRequiredFieldsResult", AV13CheckRequiredFieldsResult);
      if ( (0==AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Converelsec()) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), "error", dynavClienteconvenio_particularidades_converelsec.getInternalname(), "true", ""));
         AV13CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13CheckRequiredFieldsResult", AV13CheckRequiredFieldsResult);
      }
   }

   public void S112( )
   {
      /* 'SHOW MESSAGES' Routine */
      returnInSub = false ;
      AV45GXV18 = 1 ;
      while ( AV45GXV18 <= AV10Messages.size() )
      {
         AV9Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV10Messages.elementAt(-1+AV45GXV18));
         httpContext.GX_msglist.addItem(AV9Message.getgxTv_SdtMessages_Message_Description());
         AV45GXV18 = (int)(AV45GXV18+1) ;
      }
   }

   public void S142( )
   {
      /* 'AFTER_TRN' Routine */
      returnInSub = false ;
      Application.commitDataStores(context, remoteHandle, pr_default, "clienteconvenio_particularidadesabm");
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   public void wb_table1_9_JH2( boolean wbgen )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClienteconvenio_particularidades_cliconvenio_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavClienteconvenio_particularidades_cliconvenio_Internalname, httpContext.getMessage( "Convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'" + sGXsfl_78_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavClienteconvenio_particularidades_cliconvenio_Internalname, GXutil.rtrim( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Cliconvenio()), GXutil.rtrim( localUtil.format( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Cliconvenio(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClienteconvenio_particularidades_cliconvenio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavClienteconvenio_particularidades_cliconvenio_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ClienteConvenio_ParticularidadesABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClienteconvenio_particularidades_cliconvevig_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavClienteconvenio_particularidades_cliconvevig_Internalname, httpContext.getMessage( "Fecha de vigencia", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'" + sGXsfl_78_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavClienteconvenio_particularidades_cliconvevig_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavClienteconvenio_particularidades_cliconvevig_Internalname, localUtil.format(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Cliconvevig(), "99/99/99"), localUtil.format( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Cliconvevig(), "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClienteconvenio_particularidades_cliconvevig_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavClienteconvenio_particularidades_cliconvevig_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_ParticularidadesABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavClienteconvenio_particularidades_cliconvevig_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavClienteconvenio_particularidades_cliconvevig_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_ClienteConvenio_ParticularidadesABM.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClienteconvenio_particularidades_convemeshspext_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavClienteconvenio_particularidades_convemeshspext_Internalname, httpContext.getMessage( "Cantidad de horas del mes para calcular horas extras", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'" + sGXsfl_78_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavClienteconvenio_particularidades_convemeshspext_Internalname, GXutil.ltrim( localUtil.ntoc( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convemeshspext(), (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convemeshspext(), "ZZ9.9")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClienteconvenio_particularidades_convemeshspext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavClienteconvenio_particularidades_convemeshspext_Enabled, 1, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_ParticularidadesABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavClienteconvenio_particularidades_convediahspext.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavClienteconvenio_particularidades_convediahspext.getInternalname(), httpContext.getMessage( "Algoritmo para cantidad de días del mes para cálculo de horas extras", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'" + sGXsfl_78_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavClienteconvenio_particularidades_convediahspext, cmbavClienteconvenio_particularidades_convediahspext.getInternalname(), GXutil.rtrim( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convediahspext()), 1, cmbavClienteconvenio_particularidades_convediahspext.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavClienteconvenio_particularidades_convediahspext.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(0), "HLP_ClienteConvenio_ParticularidadesABM.htm");
         cmbavClienteconvenio_particularidades_convediahspext.setValue( GXutil.rtrim( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convediahspext()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavClienteconvenio_particularidades_convediahspext.getInternalname(), "Values", cmbavClienteconvenio_particularidades_convediahspext.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavClienteconvenio_particularidades_convefondocese.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavClienteconvenio_particularidades_convefondocese.getInternalname(), httpContext.getMessage( "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'" + sGXsfl_78_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavClienteconvenio_particularidades_convefondocese.getInternalname(), GXutil.booltostr( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese()), "", httpContext.getMessage( "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", ""), 1, chkavClienteconvenio_particularidades_convefondocese.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(42, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,42);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClienteconvenio_particularidades_conveguaredadmin_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavClienteconvenio_particularidades_conveguaredadmin_Internalname, httpContext.getMessage( "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'" + sGXsfl_78_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavClienteconvenio_particularidades_conveguaredadmin_Internalname, GXutil.ltrim( localUtil.ntoc( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin(), (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin()), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClienteconvenio_particularidades_conveguaredadmin_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavClienteconvenio_particularidades_conveguaredadmin_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_ParticularidadesABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClienteconvenio_particularidades_conveguaredadmax_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavClienteconvenio_particularidades_conveguaredadmax_Internalname, httpContext.getMessage( "Edad máxima en años del hijo/hija hasta la que puede gozar el beneficio de guardería", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'" + sGXsfl_78_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavClienteconvenio_particularidades_conveguaredadmax_Internalname, GXutil.ltrim( localUtil.ntoc( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax(), (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax()), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClienteconvenio_particularidades_conveguaredadmax_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavClienteconvenio_particularidades_conveguaredadmax_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_ParticularidadesABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavClienteconvenio_particularidades_converelsec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavClienteconvenio_particularidades_converelsec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'" + sGXsfl_78_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavClienteconvenio_particularidades_converelsec, dynavClienteconvenio_particularidades_converelsec.getInternalname(), GXutil.trim( GXutil.str( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Converelsec(), 6, 0)), 1, dynavClienteconvenio_particularidades_converelsec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavClienteconvenio_particularidades_converelsec.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", "", true, (byte)(0), "HLP_ClienteConvenio_ParticularidadesABM.htm");
         dynavClienteconvenio_particularidades_converelsec.setValue( GXutil.trim( GXutil.str( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Converelsec(), 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavClienteconvenio_particularidades_converelsec.getInternalname(), "Values", dynavClienteconvenio_particularidades_converelsec.ToJavascriptSource(), true);
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
         ucDvpanel_unnamedtable1.setProperty("Width", Dvpanel_unnamedtable1_Width);
         ucDvpanel_unnamedtable1.setProperty("AutoWidth", Dvpanel_unnamedtable1_Autowidth);
         ucDvpanel_unnamedtable1.setProperty("AutoHeight", Dvpanel_unnamedtable1_Autoheight);
         ucDvpanel_unnamedtable1.setProperty("Cls", Dvpanel_unnamedtable1_Cls);
         ucDvpanel_unnamedtable1.setProperty("Title", Dvpanel_unnamedtable1_Title);
         ucDvpanel_unnamedtable1.setProperty("Collapsible", Dvpanel_unnamedtable1_Collapsible);
         ucDvpanel_unnamedtable1.setProperty("Collapsed", Dvpanel_unnamedtable1_Collapsed);
         ucDvpanel_unnamedtable1.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable1_Showcollapseicon);
         ucDvpanel_unnamedtable1.setProperty("IconPosition", Dvpanel_unnamedtable1_Iconposition);
         ucDvpanel_unnamedtable1.setProperty("AutoScroll", Dvpanel_unnamedtable1_Autoscroll);
         ucDvpanel_unnamedtable1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable1_Internalname, "DVPANEL_UNNAMEDTABLE1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE1Container"+"UnnamedTable1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClienteconvenio_particularidades_conveinterdiasjor_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavClienteconvenio_particularidades_conveinterdiasjor_Internalname, httpContext.getMessage( "Intervalo de jornadas trabajadas para x días de vacación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'" + sGXsfl_78_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavClienteconvenio_particularidades_conveinterdiasjor_Internalname, GXutil.ltrim( localUtil.ntoc( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor(), (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor()), "ZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClienteconvenio_particularidades_conveinterdiasjor_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavClienteconvenio_particularidades_conveinterdiasjor_Enabled, 1, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_ParticularidadesABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClienteconvenio_particularidades_conveminmesesvac_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavClienteconvenio_particularidades_conveminmesesvac_Internalname, httpContext.getMessage( "Antiguedad en meses mínima para acumular días fijos de vacaciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'" + sGXsfl_78_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavClienteconvenio_particularidades_conveminmesesvac_Internalname, GXutil.ltrim( localUtil.ntoc( AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac(), (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac()), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,72);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClienteconvenio_particularidades_conveminmesesvac_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavClienteconvenio_particularidades_conveminmesesvac_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteConvenio_ParticularidadesABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_vacaciones_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         Gridlevel_vacacionesContainer.SetWrapped(nGXWrapped);
         startgridcontrol78( ) ;
      }
      if ( wbEnd == 78 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_78 = (int)(nGXsfl_78_idx-1) ;
         if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            Gridlevel_vacacionesContainer.AddObjectProperty("GRIDLEVEL_VACACIONES_nEOF", GRIDLEVEL_VACACIONES_nEOF);
            Gridlevel_vacacionesContainer.AddObjectProperty("GRIDLEVEL_VACACIONES_nFirstRecordOnPage", GRIDLEVEL_VACACIONES_nFirstRecordOnPage);
            AV37GXV11 = nGXsfl_78_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Gridlevel_vacacionesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_vacaciones", Gridlevel_vacacionesContainer, subGridlevel_vacaciones_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_vacacionesContainerData", Gridlevel_vacacionesContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_vacacionesContainerData"+"V", Gridlevel_vacacionesContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_vacacionesContainerData"+"V"+"\" value='"+Gridlevel_vacacionesContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ButtonAddGridLineCell", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 86,'',false,'',0)\"" ;
         ClassString = "ButtonAddNewRow" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnaddgridlinegridlevel_vacaciones_Internalname, "gx.evt.setGridEvt("+GXutil.str( 78, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_AddGridLine", ""), bttBtnaddgridlinegridlevel_vacaciones_Jsonclick, 5, httpContext.getMessage( "WWP_AddGridLine", ""), "", StyleString, ClassString, bttBtnaddgridlinegridlevel_vacaciones_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOADDGRIDLINEGRIDLEVEL_VACACIONES\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClienteConvenio_ParticularidadesABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "gx.evt.setGridEvt("+GXutil.str( 78, 2, 0)+","+"null"+");", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClienteConvenio_ParticularidadesABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 96,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 78, 2, 0)+","+"null"+");", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClienteConvenio_ParticularidadesABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_JH2e( true) ;
      }
      else
      {
         wb_table1_9_JH2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV11TrnMode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11TrnMode", AV11TrnMode);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11TrnMode, ""))));
      AV15CliCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15CliCod), "ZZZZZ9")));
      AV16CliPaiConve = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliPaiConve), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16CliPaiConve), "ZZZ9")));
      AV17CliConvenio = (String)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17CliConvenio", AV17CliConvenio);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17CliConvenio, ""))));
      AV18CliConveVig = (java.util.Date)getParm(obj,4) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18CliConveVig", localUtil.format(AV18CliConveVig, "99/99/99"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEVIG", getSecureSignedToken( "", AV18CliConveVig));
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
      paJH2( ) ;
      wsJH2( ) ;
      weJH2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713271930", true, true);
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
      httpContext.AddJavascriptSource("clienteconvenio_particularidadesabm.js", "?20251713271930", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_782( )
   {
      edtavDeletegridlinegridlevel_vacaciones_Internalname = "vDELETEGRIDLINEGRIDLEVEL_VACACIONES_"+sGXsfl_78_idx ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDESANT_"+sGXsfl_78_idx ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACHASANT_"+sGXsfl_78_idx ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDIAS_"+sGXsfl_78_idx ;
      dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setInternalname( "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC_"+sGXsfl_78_idx );
   }

   public void subsflControlProps_fel_782( )
   {
      edtavDeletegridlinegridlevel_vacaciones_Internalname = "vDELETEGRIDLINEGRIDLEVEL_VACACIONES_"+sGXsfl_78_fel_idx ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDESANT_"+sGXsfl_78_fel_idx ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACHASANT_"+sGXsfl_78_fel_idx ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDIAS_"+sGXsfl_78_fel_idx ;
      dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setInternalname( "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC_"+sGXsfl_78_fel_idx );
   }

   public void sendrow_782( )
   {
      subsflControlProps_782( ) ;
      wbJH0( ) ;
      if ( ( subGridlevel_vacaciones_Rows * 1 == 0 ) || ( nGXsfl_78_idx <= subgridlevel_vacaciones_fnc_recordsperpage( ) * 1 ) )
      {
         Gridlevel_vacacionesRow = GXWebRow.GetNew(context,Gridlevel_vacacionesContainer) ;
         if ( subGridlevel_vacaciones_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridlevel_vacaciones_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridlevel_vacaciones_Class, "") != 0 )
            {
               subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Odd" ;
            }
         }
         else if ( subGridlevel_vacaciones_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridlevel_vacaciones_Backstyle = (byte)(0) ;
            subGridlevel_vacaciones_Backcolor = subGridlevel_vacaciones_Allbackcolor ;
            if ( GXutil.strcmp(subGridlevel_vacaciones_Class, "") != 0 )
            {
               subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Uniform" ;
            }
         }
         else if ( subGridlevel_vacaciones_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridlevel_vacaciones_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridlevel_vacaciones_Class, "") != 0 )
            {
               subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Odd" ;
            }
            subGridlevel_vacaciones_Backcolor = (int)(0x0) ;
         }
         else if ( subGridlevel_vacaciones_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridlevel_vacaciones_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_78_idx) % (2))) == 0 )
            {
               subGridlevel_vacaciones_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_vacaciones_Class, "") != 0 )
               {
                  subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Even" ;
               }
            }
            else
            {
               subGridlevel_vacaciones_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_vacaciones_Class, "") != 0 )
               {
                  subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Odd" ;
               }
            }
         }
         if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_78_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDeletegridlinegridlevel_vacaciones_Enabled!=0)&&(edtavDeletegridlinegridlevel_vacaciones_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 79,'',false,'"+sGXsfl_78_idx+"',78)\"" : " ") ;
         ROClassString = edtavDeletegridlinegridlevel_vacaciones_Class ;
         Gridlevel_vacacionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDeletegridlinegridlevel_vacaciones_Internalname,GXutil.rtrim( AV8DeleteGridLineGridLevel_Vacaciones),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDeletegridlinegridlevel_vacaciones_Enabled!=0)&&(edtavDeletegridlinegridlevel_vacaciones_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,79);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVDELETEGRIDLINEGRIDLEVEL_VACACIONES.CLICK."+sGXsfl_78_idx+"'","","","","",edtavDeletegridlinegridlevel_vacaciones_Jsonclick,Integer.valueOf(5),edtavDeletegridlinegridlevel_vacaciones_Class,"",ROClassString,edtavDeletegridlinegridlevel_vacaciones_Columnclass,edtavDeletegridlinegridlevel_vacaciones_Columnheaderclass,Integer.valueOf(-1),Integer.valueOf(edtavDeletegridlinegridlevel_vacaciones_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(78),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Enabled!=0)&&(edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 80,'',false,'"+sGXsfl_78_idx+"',78)\"" : " ") ;
         ROClassString = "Attribute" ;
         Gridlevel_vacacionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Internalname,GXutil.ltrim( localUtil.ntoc( ((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)).getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant(), (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)).getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant()), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Enabled!=0)&&(edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,80);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Columnclass,edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Columnheaderclass,Integer.valueOf(-1),Integer.valueOf(edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(78),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Enabled!=0)&&(edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 81,'',false,'"+sGXsfl_78_idx+"',78)\"" : " ") ;
         ROClassString = "Attribute" ;
         Gridlevel_vacacionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Internalname,GXutil.ltrim( localUtil.ntoc( ((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)).getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant(), (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)).getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevachasant()), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Enabled!=0)&&(edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,81);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Columnclass,edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Columnheaderclass,Integer.valueOf(-1),Integer.valueOf(edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(78),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Enabled!=0)&&(edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 82,'',false,'"+sGXsfl_78_idx+"',78)\"" : " ") ;
         ROClassString = "Attribute" ;
         Gridlevel_vacacionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Internalname,GXutil.ltrim( localUtil.ntoc( ((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)).getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias(), (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)).getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdias()), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Enabled!=0)&&(edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,82);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Columnclass,edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Columnheaderclass,Integer.valueOf(-1),Integer.valueOf(edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(78),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         gxvclienteconvenio_particularidades_vacaciones__convevacrelsec_htmlJH2( AV15CliCod) ;
         /* Subfile cell */
         if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getEnabled()!=0)&&(dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 83,'',false,'"+sGXsfl_78_idx+"',78)\"" : " ") ;
         GXCCtl = "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC_" + sGXsfl_78_idx ;
         dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setName( GXCCtl );
         dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setWebtags( "" );
         /* ComboBox */
         Gridlevel_vacacionesRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynavClienteconvenio_particularidades_vacaciones__convevacrelsec,dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getInternalname(),GXutil.trim( GXutil.str( ((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)).getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec(), 6, 0)),Integer.valueOf(1),dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getEnabled()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute",dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getColumnClass(),dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getColumnHeaderClass(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getEnabled()!=0)&&(dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,83);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setValue( GXutil.trim( GXutil.str( ((web.SdtClienteConvenio_Particularidades_Vacaciones)AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().elementAt(-1+AV37GXV11)).getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Convevacrelsec(), 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getInternalname(), "Values", dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.ToJavascriptSource(), !bGXsfl_78_Refreshing);
         send_integrity_lvl_hashesJH2( ) ;
         Gridlevel_vacacionesContainer.AddRow(Gridlevel_vacacionesRow);
         nGXsfl_78_idx = ((subGridlevel_vacaciones_Islastpage==1)&&(nGXsfl_78_idx+1>subgridlevel_vacaciones_fnc_recordsperpage( )) ? 1 : nGXsfl_78_idx+1) ;
         sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_782( ) ;
      }
      /* End function sendrow_782 */
   }

   public void startgridcontrol78( )
   {
      if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Gridlevel_vacacionesContainer"+"DivS\" data-gxgridid=\"78\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridlevel_vacaciones_Internalname, subGridlevel_vacaciones_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridlevel_vacaciones_Backcolorstyle == 0 )
         {
            subGridlevel_vacaciones_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridlevel_vacaciones_Class) > 0 )
            {
               subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Title" ;
            }
         }
         else
         {
            subGridlevel_vacaciones_Titlebackstyle = (byte)(1) ;
            if ( subGridlevel_vacaciones_Backcolorstyle == 1 )
            {
               subGridlevel_vacaciones_Titlebackcolor = subGridlevel_vacaciones_Allbackcolor ;
               if ( GXutil.len( subGridlevel_vacaciones_Class) > 0 )
               {
                  subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridlevel_vacaciones_Class) > 0 )
               {
                  subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavDeletegridlinegridlevel_vacaciones_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Años de antiguedad desde", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Años de antiguedad hasta", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Días de vacaciones", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liberación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Gridlevel_vacacionesContainer.AddObjectProperty("GridName", "Gridlevel_vacaciones");
      }
      else
      {
         Gridlevel_vacacionesContainer.AddObjectProperty("GridName", "Gridlevel_vacaciones");
         Gridlevel_vacacionesContainer.AddObjectProperty("Header", subGridlevel_vacaciones_Header);
         Gridlevel_vacacionesContainer.AddObjectProperty("Class", "WorkWith");
         Gridlevel_vacacionesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("CmpContext", "");
         Gridlevel_vacacionesContainer.AddObjectProperty("InMasterPage", "false");
         Gridlevel_vacacionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_vacacionesColumn.AddObjectProperty("Value", GXutil.rtrim( AV8DeleteGridLineGridLevel_Vacaciones));
         Gridlevel_vacacionesColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavDeletegridlinegridlevel_vacaciones_Columnclass));
         Gridlevel_vacacionesColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( edtavDeletegridlinegridlevel_vacaciones_Columnheaderclass));
         Gridlevel_vacacionesColumn.AddObjectProperty("Class", GXutil.rtrim( edtavDeletegridlinegridlevel_vacaciones_Class));
         Gridlevel_vacacionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDeletegridlinegridlevel_vacaciones_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddColumnProperties(Gridlevel_vacacionesColumn);
         Gridlevel_vacacionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_vacacionesColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Columnclass));
         Gridlevel_vacacionesColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Columnheaderclass));
         Gridlevel_vacacionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddColumnProperties(Gridlevel_vacacionesColumn);
         Gridlevel_vacacionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_vacacionesColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Columnclass));
         Gridlevel_vacacionesColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Columnheaderclass));
         Gridlevel_vacacionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddColumnProperties(Gridlevel_vacacionesColumn);
         Gridlevel_vacacionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_vacacionesColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Columnclass));
         Gridlevel_vacacionesColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Columnheaderclass));
         Gridlevel_vacacionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddColumnProperties(Gridlevel_vacacionesColumn);
         Gridlevel_vacacionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_vacacionesColumn.AddObjectProperty("Columnclass", GXutil.rtrim( dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getColumnClass()));
         Gridlevel_vacacionesColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getColumnHeaderClass()));
         Gridlevel_vacacionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddColumnProperties(Gridlevel_vacacionesColumn);
         Gridlevel_vacacionesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      edtavClienteconvenio_particularidades_cliconvenio_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_CLICONVENIO" ;
      edtavClienteconvenio_particularidades_cliconvevig_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_CLICONVEVIG" ;
      edtavClienteconvenio_particularidades_convemeshspext_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_CONVEMESHSPEXT" ;
      cmbavClienteconvenio_particularidades_convediahspext.setInternalname( "CLIENTECONVENIO_PARTICULARIDADES_CONVEDIAHSPEXT" );
      chkavClienteconvenio_particularidades_convefondocese.setInternalname( "CLIENTECONVENIO_PARTICULARIDADES_CONVEFONDOCESE" );
      edtavClienteconvenio_particularidades_conveguaredadmin_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_CONVEGUAREDADMIN" ;
      edtavClienteconvenio_particularidades_conveguaredadmax_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_CONVEGUAREDADMAX" ;
      dynavClienteconvenio_particularidades_converelsec.setInternalname( "CLIENTECONVENIO_PARTICULARIDADES_CONVERELSEC" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      edtavClienteconvenio_particularidades_conveinterdiasjor_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_CONVEINTERDIASJOR" ;
      edtavClienteconvenio_particularidades_conveminmesesvac_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_CONVEMINMESESVAC" ;
      edtavDeletegridlinegridlevel_vacaciones_Internalname = "vDELETEGRIDLINEGRIDLEVEL_VACACIONES" ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDESANT" ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACHASANT" ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDIAS" ;
      dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setInternalname( "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC" );
      bttBtnaddgridlinegridlevel_vacaciones_Internalname = "BTNADDGRIDLINEGRIDLEVEL_VACACIONES" ;
      divTableleaflevel_vacaciones_Internalname = "TABLELEAFLEVEL_VACACIONES" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Dvpanel_unnamedtable1_Internalname = "DVPANEL_UNNAMEDTABLE1" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavClienteconvenio_particularidades_clicod_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_CLICOD" ;
      edtavClienteconvenio_particularidades_clipaiconve_Internalname = "CLIENTECONVENIO_PARTICULARIDADES_CLIPAICONVE" ;
      Gridlevel_vacaciones_empowerer_Internalname = "GRIDLEVEL_VACACIONES_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_vacaciones_Internalname = "GRIDLEVEL_VACACIONES" ;
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
      subGridlevel_vacaciones_Allowcollapsing = (byte)(0) ;
      subGridlevel_vacaciones_Allowselection = (byte)(0) ;
      subGridlevel_vacaciones_Header = "" ;
      dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setJsonclick( "" );
      dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setVisible( -1 );
      dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setEnabled( 1 );
      dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setColumnHeaderClass( "" );
      dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setColumnClass( "WWColumn" );
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Jsonclick = "" ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Columnheaderclass = "" ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Columnclass = "WWColumn" ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Visible = -1 ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Enabled = 1 ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Jsonclick = "" ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Columnheaderclass = "" ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Columnclass = "WWColumn" ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Visible = -1 ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Enabled = 1 ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Jsonclick = "" ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Columnheaderclass = "" ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Columnclass = "WWColumn" ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Visible = -1 ;
      edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Enabled = 1 ;
      edtavDeletegridlinegridlevel_vacaciones_Jsonclick = "" ;
      edtavDeletegridlinegridlevel_vacaciones_Columnclass = "WWIconActionColumn" ;
      edtavDeletegridlinegridlevel_vacaciones_Class = "Attribute" ;
      edtavDeletegridlinegridlevel_vacaciones_Visible = -1 ;
      edtavDeletegridlinegridlevel_vacaciones_Enabled = 1 ;
      subGridlevel_vacaciones_Class = "WorkWith" ;
      subGridlevel_vacaciones_Backcolorstyle = (byte)(0) ;
      bttBtnenter_Visible = 1 ;
      bttBtnaddgridlinegridlevel_vacaciones_Visible = 1 ;
      edtavClienteconvenio_particularidades_conveminmesesvac_Jsonclick = "" ;
      edtavClienteconvenio_particularidades_conveminmesesvac_Enabled = 1 ;
      edtavClienteconvenio_particularidades_conveinterdiasjor_Jsonclick = "" ;
      edtavClienteconvenio_particularidades_conveinterdiasjor_Enabled = 1 ;
      dynavClienteconvenio_particularidades_converelsec.setJsonclick( "" );
      dynavClienteconvenio_particularidades_converelsec.setEnabled( 1 );
      edtavClienteconvenio_particularidades_conveguaredadmax_Jsonclick = "" ;
      edtavClienteconvenio_particularidades_conveguaredadmax_Enabled = 1 ;
      edtavClienteconvenio_particularidades_conveguaredadmin_Jsonclick = "" ;
      edtavClienteconvenio_particularidades_conveguaredadmin_Enabled = 1 ;
      chkavClienteconvenio_particularidades_convefondocese.setEnabled( 1 );
      cmbavClienteconvenio_particularidades_convediahspext.setJsonclick( "" );
      cmbavClienteconvenio_particularidades_convediahspext.setEnabled( 1 );
      edtavClienteconvenio_particularidades_convemeshspext_Jsonclick = "" ;
      edtavClienteconvenio_particularidades_convemeshspext_Enabled = 1 ;
      edtavClienteconvenio_particularidades_cliconvevig_Jsonclick = "" ;
      edtavClienteconvenio_particularidades_cliconvevig_Enabled = 1 ;
      edtavClienteconvenio_particularidades_cliconvenio_Jsonclick = "" ;
      edtavClienteconvenio_particularidades_cliconvenio_Enabled = 1 ;
      edtavDeletegridlinegridlevel_vacaciones_Columnheaderclass = "" ;
      edtavClienteconvenio_particularidades_cliconvevig_Enabled = 1 ;
      edtavClienteconvenio_particularidades_cliconvenio_Enabled = 1 ;
      dynavClienteconvenio_particularidades_converelsec.setEnabled( 1 );
      edtavClienteconvenio_particularidades_conveguaredadmax_Enabled = 1 ;
      edtavClienteconvenio_particularidades_conveguaredadmin_Enabled = 1 ;
      chkavClienteconvenio_particularidades_convefondocese.setEnabled( 1 );
      cmbavClienteconvenio_particularidades_convediahspext.setEnabled( 1 );
      edtavClienteconvenio_particularidades_convemeshspext_Enabled = 1 ;
      edtavClienteconvenio_particularidades_conveminmesesvac_Enabled = 1 ;
      edtavClienteconvenio_particularidades_conveinterdiasjor_Enabled = 1 ;
      edtavClienteconvenio_particularidades_clipaiconve_Jsonclick = "" ;
      edtavClienteconvenio_particularidades_clipaiconve_Visible = 1 ;
      edtavClienteconvenio_particularidades_clicod_Jsonclick = "" ;
      edtavClienteconvenio_particularidades_clicod_Visible = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Dvpanel_unnamedtable1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Iconposition = "Right" ;
      Dvpanel_unnamedtable1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Title = httpContext.getMessage( "Vacaciones", "") ;
      Dvpanel_unnamedtable1_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Width = "100%" ;
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
      Form.setCaption( httpContext.getMessage( "Cliente Convenio_Particularidades ABM", "") );
      subGridlevel_vacaciones_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavClienteconvenio_particularidades_convediahspext.setName( "CLIENTECONVENIO_PARTICULARIDADES_CONVEDIAHSPEXT" );
      cmbavClienteconvenio_particularidades_convediahspext.setWebtags( "" );
      cmbavClienteconvenio_particularidades_convediahspext.addItem("", httpContext.getMessage( "(Default)", ""), (short)(0));
      cmbavClienteconvenio_particularidades_convediahspext.addItem("Promedio", httpContext.getMessage( "Promedio anual de días hábiles semanales por mes del empleado", ""), (short)(0));
      cmbavClienteconvenio_particularidades_convediahspext.addItem("diasSemanaX4", httpContext.getMessage( "Cantidad de días hábiles semanales del empleado multiplicados por 4", ""), (short)(0));
      cmbavClienteconvenio_particularidades_convediahspext.addItem("diasSemanaMes", httpContext.getMessage( "Cantidad de días hábiles del empleado en el mes específico de la liquidación", ""), (short)(0));
      if ( cmbavClienteconvenio_particularidades_convediahspext.getItemCount() > 0 )
      {
         AV7ClienteConvenio_Particularidades.setgxTv_SdtClienteConvenio_Particularidades_Convediahspext( cmbavClienteconvenio_particularidades_convediahspext.getValidValue(AV7ClienteConvenio_Particularidades.getgxTv_SdtClienteConvenio_Particularidades_Convediahspext()) );
      }
      chkavClienteconvenio_particularidades_convefondocese.setName( "CLIENTECONVENIO_PARTICULARIDADES_CONVEFONDOCESE" );
      chkavClienteconvenio_particularidades_convefondocese.setWebtags( "" );
      chkavClienteconvenio_particularidades_convefondocese.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavClienteconvenio_particularidades_convefondocese.getInternalname(), "TitleCaption", chkavClienteconvenio_particularidades_convefondocese.getCaption(), true);
      chkavClienteconvenio_particularidades_convefondocese.setCheckedValue( "false" );
      dynavClienteconvenio_particularidades_converelsec.setName( "CLIENTECONVENIO_PARTICULARIDADES_CONVERELSEC" );
      dynavClienteconvenio_particularidades_converelsec.setWebtags( "" );
      GXCCtl = "CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC_" + sGXsfl_78_idx ;
      dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setName( GXCCtl );
      dynavClienteconvenio_particularidades_vacaciones__convevacrelsec.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VACACIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'AV21ClienteConvenio_ParticularidadesVacacionesDeleted',fld:'vCLIENTECONVENIO_PARTICULARIDADESVACACIONESDELETED',pic:''},{av:'AV7ClienteConvenio_Particularidades',fld:'vCLIENTECONVENIO_PARTICULARIDADES',pic:''},{av:'nRC_GXsfl_78',ctrl:'GRIDLEVEL_VACACIONES',prop:'GridRC',grid:78},{av:'GXV5',fld:'CLIENTECONVENIO_PARTICULARIDADES_CONVEFONDOCESE',pic:''},{av:'AV11TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV16CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV17CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV18CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true},{av:'AV15CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'edtavDeletegridlinegridlevel_vacaciones_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_VACACIONES',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDESANT',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACHASANT',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDIAS',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_VACACIONES',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_VACACIONES.LOAD","{handler:'e15JH2',iparms:[{av:'AV7ClienteConvenio_Particularidades',fld:'vCLIENTECONVENIO_PARTICULARIDADES',pic:''},{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'nRC_GXsfl_78',ctrl:'GRIDLEVEL_VACACIONES',prop:'GridRC',grid:78},{av:'AV21ClienteConvenio_ParticularidadesVacacionesDeleted',fld:'vCLIENTECONVENIO_PARTICULARIDADESVACACIONESDELETED',pic:''},{av:'AV11TrnMode',fld:'vTRNMODE',pic:'',hsh:true}]");
      setEventMetadata("GRIDLEVEL_VACACIONES.LOAD",",oparms:[{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDESANT',prop:'Enabled'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACHASANT',prop:'Enabled'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDIAS',prop:'Enabled'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC',prop:'Enabled'},{av:'AV8DeleteGridLineGridLevel_Vacaciones',fld:'vDELETEGRIDLINEGRIDLEVEL_VACACIONES',pic:''},{av:'edtavDeletegridlinegridlevel_vacaciones_Class',ctrl:'vDELETEGRIDLINEGRIDLEVEL_VACACIONES',prop:'Class'},{av:'edtavDeletegridlinegridlevel_vacaciones_Columnclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_VACACIONES',prop:'Columnclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDESANT',prop:'Columnclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACHASANT',prop:'Columnclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDIAS',prop:'Columnclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC',prop:'Columnclass'}]}");
      setEventMetadata("'DOADDGRIDLINEGRIDLEVEL_VACACIONES'","{handler:'e11JH2',iparms:[{av:'AV7ClienteConvenio_Particularidades',fld:'vCLIENTECONVENIO_PARTICULARIDADES',pic:''},{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'nRC_GXsfl_78',ctrl:'GRIDLEVEL_VACACIONES',prop:'GridRC',grid:78},{av:'GRIDLEVEL_VACACIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'AV21ClienteConvenio_ParticularidadesVacacionesDeleted',fld:'vCLIENTECONVENIO_PARTICULARIDADESVACACIONESDELETED',pic:''},{av:'GXV5',fld:'CLIENTECONVENIO_PARTICULARIDADES_CONVEFONDOCESE',pic:''},{av:'AV11TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV16CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV17CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV18CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true},{av:'AV15CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("'DOADDGRIDLINEGRIDLEVEL_VACACIONES'",",oparms:[{av:'AV7ClienteConvenio_Particularidades',fld:'vCLIENTECONVENIO_PARTICULARIDADES',pic:''},{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'nRC_GXsfl_78',ctrl:'GRIDLEVEL_VACACIONES',prop:'GridRC',grid:78}]}");
      setEventMetadata("ENTER","{handler:'e12JH2',iparms:[{av:'AV11TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV15CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7ClienteConvenio_Particularidades',fld:'vCLIENTECONVENIO_PARTICULARIDADES',pic:''},{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'nRC_GXsfl_78',ctrl:'GRIDLEVEL_VACACIONES',prop:'GridRC',grid:78},{av:'AV13CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV21ClienteConvenio_ParticularidadesVacacionesDeleted',fld:'vCLIENTECONVENIO_PARTICULARIDADESVACACIONESDELETED',pic:''},{av:'AV10Messages',fld:'vMESSAGES',pic:''},{av:'GRIDLEVEL_VACACIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'GXV5',fld:'CLIENTECONVENIO_PARTICULARIDADES_CONVEFONDOCESE',pic:''},{av:'AV16CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV17CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV18CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV21ClienteConvenio_ParticularidadesVacacionesDeleted',fld:'vCLIENTECONVENIO_PARTICULARIDADESVACACIONESDELETED',pic:''},{av:'AV7ClienteConvenio_Particularidades',fld:'vCLIENTECONVENIO_PARTICULARIDADES',pic:''},{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'nRC_GXsfl_78',ctrl:'GRIDLEVEL_VACACIONES',prop:'GridRC',grid:78},{av:'AV10Messages',fld:'vMESSAGES',pic:''},{av:'AV13CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("VDELETEGRIDLINEGRIDLEVEL_VACACIONES.CLICK","{handler:'e16JH2',iparms:[{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VACACIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'AV11TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV7ClienteConvenio_Particularidades',fld:'vCLIENTECONVENIO_PARTICULARIDADES',pic:''},{av:'nRC_GXsfl_78',ctrl:'GRIDLEVEL_VACACIONES',prop:'GridRC',grid:78},{av:'AV21ClienteConvenio_ParticularidadesVacacionesDeleted',fld:'vCLIENTECONVENIO_PARTICULARIDADESVACACIONESDELETED',pic:''},{av:'AV15CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'GXV5',fld:'CLIENTECONVENIO_PARTICULARIDADES_CONVEFONDOCESE',pic:''},{av:'AV16CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV17CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV18CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true}]");
      setEventMetadata("VDELETEGRIDLINEGRIDLEVEL_VACACIONES.CLICK",",oparms:[{av:'AV21ClienteConvenio_ParticularidadesVacacionesDeleted',fld:'vCLIENTECONVENIO_PARTICULARIDADESVACACIONESDELETED',pic:''},{av:'edtavDeletegridlinegridlevel_vacaciones_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_VACACIONES',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDESANT',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACHASANT',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDIAS',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_VACACIONES',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_VACACIONES_FIRSTPAGE","{handler:'subgridlevel_vacaciones_firstpage',iparms:[{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VACACIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'AV21ClienteConvenio_ParticularidadesVacacionesDeleted',fld:'vCLIENTECONVENIO_PARTICULARIDADESVACACIONESDELETED',pic:''},{av:'AV16CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV17CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV18CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true},{av:'AV11TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV15CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'GXV5',fld:'CLIENTECONVENIO_PARTICULARIDADES_CONVEFONDOCESE',pic:''},{av:'AV7ClienteConvenio_Particularidades',fld:'vCLIENTECONVENIO_PARTICULARIDADES',pic:''},{av:'nRC_GXsfl_78',ctrl:'GRIDLEVEL_VACACIONES',prop:'GridRC',grid:78}]");
      setEventMetadata("GRIDLEVEL_VACACIONES_FIRSTPAGE",",oparms:[{av:'edtavDeletegridlinegridlevel_vacaciones_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_VACACIONES',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDESANT',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACHASANT',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDIAS',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_VACACIONES',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_VACACIONES_PREVPAGE","{handler:'subgridlevel_vacaciones_previouspage',iparms:[{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VACACIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'AV21ClienteConvenio_ParticularidadesVacacionesDeleted',fld:'vCLIENTECONVENIO_PARTICULARIDADESVACACIONESDELETED',pic:''},{av:'AV16CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV17CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV18CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true},{av:'AV11TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV15CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'GXV5',fld:'CLIENTECONVENIO_PARTICULARIDADES_CONVEFONDOCESE',pic:''},{av:'AV7ClienteConvenio_Particularidades',fld:'vCLIENTECONVENIO_PARTICULARIDADES',pic:''},{av:'nRC_GXsfl_78',ctrl:'GRIDLEVEL_VACACIONES',prop:'GridRC',grid:78}]");
      setEventMetadata("GRIDLEVEL_VACACIONES_PREVPAGE",",oparms:[{av:'edtavDeletegridlinegridlevel_vacaciones_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_VACACIONES',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDESANT',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACHASANT',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDIAS',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_VACACIONES',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_VACACIONES_NEXTPAGE","{handler:'subgridlevel_vacaciones_nextpage',iparms:[{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VACACIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'AV21ClienteConvenio_ParticularidadesVacacionesDeleted',fld:'vCLIENTECONVENIO_PARTICULARIDADESVACACIONESDELETED',pic:''},{av:'AV16CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV17CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV18CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true},{av:'AV11TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV15CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'GXV5',fld:'CLIENTECONVENIO_PARTICULARIDADES_CONVEFONDOCESE',pic:''},{av:'AV7ClienteConvenio_Particularidades',fld:'vCLIENTECONVENIO_PARTICULARIDADES',pic:''},{av:'nRC_GXsfl_78',ctrl:'GRIDLEVEL_VACACIONES',prop:'GridRC',grid:78}]");
      setEventMetadata("GRIDLEVEL_VACACIONES_NEXTPAGE",",oparms:[{av:'edtavDeletegridlinegridlevel_vacaciones_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_VACACIONES',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDESANT',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACHASANT',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDIAS',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_VACACIONES',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_VACACIONES_LASTPAGE","{handler:'subgridlevel_vacaciones_lastpage',iparms:[{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VACACIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'AV21ClienteConvenio_ParticularidadesVacacionesDeleted',fld:'vCLIENTECONVENIO_PARTICULARIDADESVACACIONESDELETED',pic:''},{av:'AV16CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV17CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV18CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true},{av:'AV11TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV15CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'GXV5',fld:'CLIENTECONVENIO_PARTICULARIDADES_CONVEFONDOCESE',pic:''},{av:'AV7ClienteConvenio_Particularidades',fld:'vCLIENTECONVENIO_PARTICULARIDADES',pic:''},{av:'nRC_GXsfl_78',ctrl:'GRIDLEVEL_VACACIONES',prop:'GridRC',grid:78}]");
      setEventMetadata("GRIDLEVEL_VACACIONES_LASTPAGE",",oparms:[{av:'edtavDeletegridlinegridlevel_vacaciones_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_VACACIONES',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDESANT',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACHASANT',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CLICONVEVACDIAS',prop:'Columnheaderclass'},{ctrl:'CLIENTECONVENIO_PARTICULARIDADES_VACACIONES__CONVEVACRELSEC',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_VACACIONES',prop:'Visible'}]}");
      setEventMetadata("VALIDV_GXV4","{handler:'validv_Gxv4',iparms:[]");
      setEventMetadata("VALIDV_GXV4",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv15',iparms:[]");
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
      wcpOAV11TrnMode = "" ;
      wcpOAV17CliConvenio = "" ;
      wcpOAV18CliConveVig = GXutil.nullDate() ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV11TrnMode = "" ;
      AV17CliConvenio = "" ;
      AV18CliConveVig = GXutil.nullDate() ;
      AV7ClienteConvenio_Particularidades = new web.SdtClienteConvenio_Particularidades(remoteHandle);
      AV21ClienteConvenio_ParticularidadesVacacionesDeleted = new GXSimpleCollection<Short>(Short.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV10Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      Gridlevel_vacaciones_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      ucGridlevel_vacaciones_empowerer = new com.genexus.webpanels.GXUserControl();
      Gridlevel_vacacionesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV8DeleteGridLineGridLevel_Vacaciones = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H00JH2_A1885CliRelSec = new int[1] ;
      H00JH2_A1880CliReDTChar = new String[] {""} ;
      H00JH2_A3CliCod = new int[1] ;
      H00JH3_A1885CliRelSec = new int[1] ;
      H00JH3_A1880CliReDTChar = new String[] {""} ;
      H00JH3_A3CliCod = new int[1] ;
      Gx_mode = "" ;
      Gridlevel_vacacionesRow = new com.genexus.webpanels.GXWebRow();
      AV19ClienteConvenio_ParticularidadesVacacionesItem = new web.SdtClienteConvenio_Particularidades_Vacaciones(remoteHandle);
      GXv_boolean1 = new boolean[1] ;
      AV9Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_unnamedtable1 = new com.genexus.webpanels.GXUserControl();
      bttBtnaddgridlinegridlevel_vacaciones_Jsonclick = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridlevel_vacaciones_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      Gridlevel_vacacionesColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clienteconvenio_particularidadesabm__default(),
         new Object[] {
             new Object[] {
            H00JH2_A1885CliRelSec, H00JH2_A1880CliReDTChar, H00JH2_A3CliCod
            }
            , new Object[] {
            H00JH3_A1885CliRelSec, H00JH3_A1880CliReDTChar, H00JH3_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavDeletegridlinegridlevel_vacaciones_Enabled = 0 ;
   }

   private byte GRIDLEVEL_VACACIONES_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGridlevel_vacaciones_Backcolorstyle ;
   private byte nGXWrapped ;
   private byte subGridlevel_vacaciones_Backstyle ;
   private byte subGridlevel_vacaciones_Titlebackstyle ;
   private byte subGridlevel_vacaciones_Allowselection ;
   private byte subGridlevel_vacaciones_Allowhovering ;
   private byte subGridlevel_vacaciones_Allowcollapsing ;
   private byte subGridlevel_vacaciones_Collapsed ;
   private short wcpOAV16CliPaiConve ;
   private short AV16CliPaiConve ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV24i ;
   private short AV20Index ;
   private int wcpOAV15CliCod ;
   private int nRC_GXsfl_78 ;
   private int AV15CliCod ;
   private int subGridlevel_vacaciones_Rows ;
   private int nGXsfl_78_idx=1 ;
   private int edtavClienteconvenio_particularidades_clicod_Visible ;
   private int edtavClienteconvenio_particularidades_clipaiconve_Visible ;
   private int AV37GXV11 ;
   private int gxdynajaxindex ;
   private int subGridlevel_vacaciones_Islastpage ;
   private int edtavDeletegridlinegridlevel_vacaciones_Enabled ;
   private int GRIDLEVEL_VACACIONES_nGridOutOfScope ;
   private int nGXsfl_78_fel_idx=1 ;
   private int edtavClienteconvenio_particularidades_conveinterdiasjor_Enabled ;
   private int edtavClienteconvenio_particularidades_conveminmesesvac_Enabled ;
   private int edtavClienteconvenio_particularidades_convemeshspext_Enabled ;
   private int edtavClienteconvenio_particularidades_conveguaredadmin_Enabled ;
   private int edtavClienteconvenio_particularidades_conveguaredadmax_Enabled ;
   private int edtavClienteconvenio_particularidades_cliconvenio_Enabled ;
   private int edtavClienteconvenio_particularidades_cliconvevig_Enabled ;
   private int edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Enabled ;
   private int edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Enabled ;
   private int edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Enabled ;
   private int nGXsfl_78_bak_idx=1 ;
   private int bttBtnenter_Visible ;
   private int bttBtnaddgridlinegridlevel_vacaciones_Visible ;
   private int AV45GXV18 ;
   private int idxLst ;
   private int subGridlevel_vacaciones_Backcolor ;
   private int subGridlevel_vacaciones_Allbackcolor ;
   private int edtavDeletegridlinegridlevel_vacaciones_Visible ;
   private int edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Visible ;
   private int edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Visible ;
   private int edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Visible ;
   private int subGridlevel_vacaciones_Titlebackcolor ;
   private int subGridlevel_vacaciones_Selectedindex ;
   private int subGridlevel_vacaciones_Selectioncolor ;
   private int subGridlevel_vacaciones_Hoveringcolor ;
   private long GRIDLEVEL_VACACIONES_nFirstRecordOnPage ;
   private long GRIDLEVEL_VACACIONES_nCurrentRecord ;
   private long GRIDLEVEL_VACACIONES_nRecordCount ;
   private String wcpOAV11TrnMode ;
   private String wcpOAV17CliConvenio ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV11TrnMode ;
   private String AV17CliConvenio ;
   private String sGXsfl_78_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_unnamedtable1_Width ;
   private String Dvpanel_unnamedtable1_Cls ;
   private String Dvpanel_unnamedtable1_Title ;
   private String Dvpanel_unnamedtable1_Iconposition ;
   private String Gridlevel_vacaciones_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String edtavClienteconvenio_particularidades_clicod_Internalname ;
   private String edtavClienteconvenio_particularidades_clicod_Jsonclick ;
   private String edtavClienteconvenio_particularidades_clipaiconve_Internalname ;
   private String edtavClienteconvenio_particularidades_clipaiconve_Jsonclick ;
   private String Gridlevel_vacaciones_empowerer_Internalname ;
   private String sStyleString ;
   private String subGridlevel_vacaciones_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV8DeleteGridLineGridLevel_Vacaciones ;
   private String edtavDeletegridlinegridlevel_vacaciones_Internalname ;
   private String edtavClienteconvenio_particularidades_cliconvenio_Internalname ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String sGXsfl_78_fel_idx="0001" ;
   private String edtavClienteconvenio_particularidades_cliconvevig_Internalname ;
   private String edtavClienteconvenio_particularidades_convemeshspext_Internalname ;
   private String edtavClienteconvenio_particularidades_conveguaredadmin_Internalname ;
   private String edtavClienteconvenio_particularidades_conveguaredadmax_Internalname ;
   private String edtavClienteconvenio_particularidades_conveinterdiasjor_Internalname ;
   private String edtavClienteconvenio_particularidades_conveminmesesvac_Internalname ;
   private String Gx_mode ;
   private String edtavDeletegridlinegridlevel_vacaciones_Columnheaderclass ;
   private String edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Columnheaderclass ;
   private String edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Internalname ;
   private String edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Columnheaderclass ;
   private String edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Internalname ;
   private String edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Columnheaderclass ;
   private String edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Internalname ;
   private String edtavDeletegridlinegridlevel_vacaciones_Class ;
   private String edtavDeletegridlinegridlevel_vacaciones_Columnclass ;
   private String edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Columnclass ;
   private String edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Columnclass ;
   private String edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Columnclass ;
   private String bttBtnenter_Internalname ;
   private String bttBtnaddgridlinegridlevel_vacaciones_Internalname ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtavClienteconvenio_particularidades_cliconvenio_Jsonclick ;
   private String edtavClienteconvenio_particularidades_cliconvevig_Jsonclick ;
   private String edtavClienteconvenio_particularidades_convemeshspext_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtavClienteconvenio_particularidades_conveguaredadmin_Jsonclick ;
   private String edtavClienteconvenio_particularidades_conveguaredadmax_Jsonclick ;
   private String Dvpanel_unnamedtable1_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String edtavClienteconvenio_particularidades_conveinterdiasjor_Jsonclick ;
   private String edtavClienteconvenio_particularidades_conveminmesesvac_Jsonclick ;
   private String divTableleaflevel_vacaciones_Internalname ;
   private String bttBtnaddgridlinegridlevel_vacaciones_Jsonclick ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String subGridlevel_vacaciones_Class ;
   private String subGridlevel_vacaciones_Linesclass ;
   private String ROClassString ;
   private String edtavDeletegridlinegridlevel_vacaciones_Jsonclick ;
   private String edtavClienteconvenio_particularidades_vacaciones__cliconvevacdesant_Jsonclick ;
   private String edtavClienteconvenio_particularidades_vacaciones__cliconvevachasant_Jsonclick ;
   private String edtavClienteconvenio_particularidades_vacaciones__cliconvevacdias_Jsonclick ;
   private String GXCCtl ;
   private String subGridlevel_vacaciones_Header ;
   private java.util.Date wcpOAV18CliConveVig ;
   private java.util.Date AV18CliConveVig ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV13CheckRequiredFieldsResult ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_unnamedtable1_Autowidth ;
   private boolean Dvpanel_unnamedtable1_Autoheight ;
   private boolean Dvpanel_unnamedtable1_Collapsible ;
   private boolean Dvpanel_unnamedtable1_Collapsed ;
   private boolean Dvpanel_unnamedtable1_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable1_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_78_Refreshing=false ;
   private boolean returnInSub ;
   private boolean AV12LoadSuccess ;
   private boolean gx_BV78 ;
   private boolean gx_refresh_fired ;
   private boolean AV14LineDeleted ;
   private boolean AV23ok ;
   private boolean AV22aplicadoHay ;
   private boolean GXv_boolean1[] ;
   private GXSimpleCollection<Short> AV21ClienteConvenio_ParticularidadesVacacionesDeleted ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_vacacionesContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_vacacionesRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_vacacionesColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucGridlevel_vacaciones_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private HTMLChoice cmbavClienteconvenio_particularidades_convediahspext ;
   private ICheckbox chkavClienteconvenio_particularidades_convefondocese ;
   private HTMLChoice dynavClienteconvenio_particularidades_converelsec ;
   private HTMLChoice dynavClienteconvenio_particularidades_vacaciones__convevacrelsec ;
   private IDataStoreProvider pr_default ;
   private int[] H00JH2_A1885CliRelSec ;
   private String[] H00JH2_A1880CliReDTChar ;
   private int[] H00JH2_A3CliCod ;
   private int[] H00JH3_A1885CliRelSec ;
   private String[] H00JH3_A1880CliReDTChar ;
   private int[] H00JH3_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV10Messages ;
   private com.genexus.SdtMessages_Message AV9Message ;
   private web.SdtClienteConvenio_Particularidades AV7ClienteConvenio_Particularidades ;
   private web.SdtClienteConvenio_Particularidades_Vacaciones AV19ClienteConvenio_ParticularidadesVacacionesItem ;
}

final  class clienteconvenio_particularidadesabm__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00JH2", "SELECT CliRelSec, CliReDTChar, CliCod FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00JH3", "SELECT CliRelSec, CliReDTChar, CliCod FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               return;
      }
   }

}

