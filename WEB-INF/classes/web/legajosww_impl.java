package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajosww_impl extends GXDataArea
{
   public legajosww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajosww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajosww_impl.class ));
   }

   public legajosww_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavLegtipotarifa = new HTMLChoice();
      cmbavLegmodtra = new HTMLChoice();
      cmbavConveniofiltro = new HTMLChoice();
      cmbavLegestado = new HTMLChoice();
      chkavLegincompleto = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "SelectedCliCod") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "SelectedCliCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "SelectedCliCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
         {
            gxnrgrid_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid") == 0 )
         {
            gxgrgrid_refresh_invoke( ) ;
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
            AV20SelectedCliCod = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20SelectedCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20SelectedCliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20SelectedCliCod), "ZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV21SelectedEmpCod = (short)(GXutil.lval( httpContext.GetPar( "SelectedEmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV21SelectedEmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21SelectedEmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21SelectedEmpCod), "ZZZ9")));
               AV23SelectedLegNumero = (int)(GXutil.lval( httpContext.GetPar( "SelectedLegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV23SelectedLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23SelectedLegNumero), 8, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV23SelectedLegNumero), "ZZZZZZZ9")));
               AV38MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV38MenuOpcCod", AV38MenuOpcCod);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV38MenuOpcCod, ""))));
               AV74modoPalabra = httpContext.GetPar( "modoPalabra") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV74modoPalabra", AV74modoPalabra);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODOPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV74modoPalabra, ""))));
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

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_41 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_41"))) ;
      nGXsfl_41_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_41_idx"))) ;
      sGXsfl_41_idx = httpContext.GetPar( "sGXsfl_41_idx") ;
      edtLegCUIL_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCUIL_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCUIL_Visible), 5, 0), !bGXsfl_41_Refreshing);
      edtEmpCod_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), !bGXsfl_41_Refreshing);
      edtLegNumero_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Visible), 5, 0), !bGXsfl_41_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid_newrow( ) ;
      /* End function gxnrGrid_newrow_invoke */
   }

   public void gxgrgrid_refresh_invoke( )
   {
      subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
      AV14FilterFullText = httpContext.GetPar( "FilterFullText") ;
      AV62LegSexo = (byte)(GXutil.lval( httpContext.GetPar( "LegSexo"))) ;
      AV52LegClase = (short)(GXutil.lval( httpContext.GetPar( "LegClase"))) ;
      cmbavLegtipotarifa.fromJSonString( httpContext.GetNextPar( ));
      AV80LegTipoTarifa = httpContext.GetPar( "LegTipoTarifa") ;
      cmbavLegmodtra.fromJSonString( httpContext.GetNextPar( ));
      AV79LegModTra = httpContext.GetPar( "LegModTra") ;
      cmbavConveniofiltro.fromJSonString( httpContext.GetNextPar( ));
      AV46ConvenioFiltro = httpContext.GetPar( "ConvenioFiltro") ;
      AV56LegFecIngreso = localUtil.parseDateParm( httpContext.GetPar( "LegFecIngreso")) ;
      AV55LegFecEgreso = localUtil.parseDateParm( httpContext.GetPar( "LegFecEgreso")) ;
      AV49LegActCodigo = httpContext.GetPar( "LegActCodigo") ;
      AV67MprCod = httpContext.GetPar( "MprCod") ;
      AV71ZonCod = httpContext.GetPar( "ZonCod") ;
      AV66LegSucCodigo = httpContext.GetPar( "LegSucCodigo") ;
      cmbavLegestado.fromJSonString( httpContext.GetNextPar( ));
      AV76LegEstado = (byte)(GXutil.lval( httpContext.GetPar( "LegEstado"))) ;
      AV77LegIncompleto = GXutil.strtobool( httpContext.GetPar( "LegIncompleto")) ;
      AV83Pgmname = httpContext.GetPar( "Pgmname") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV64LegSinCod);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV53LegConveCodigo);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV50LegCatCodigo);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV60LegSecCodigo);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV58LegPuesCodigo);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV65LegSinCod_Data);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV54LegConveCodigo_Data);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV51LegCatCodigo_Data);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV61LegSecCodigo_Data);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV59LegPuesCodigo_Data);
      edtLegCUIL_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCUIL_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCUIL_Visible), 5, 0), !bGXsfl_41_Refreshing);
      edtEmpCod_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), !bGXsfl_41_Refreshing);
      edtLegNumero_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Visible), 5, 0), !bGXsfl_41_Refreshing);
      AV17CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV18EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV20SelectedCliCod = (int)(GXutil.lval( httpContext.GetPar( "SelectedCliCod"))) ;
      AV21SelectedEmpCod = (short)(GXutil.lval( httpContext.GetPar( "SelectedEmpCod"))) ;
      AV23SelectedLegNumero = (int)(GXutil.lval( httpContext.GetPar( "SelectedLegNumero"))) ;
      AV38MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      AV74modoPalabra = httpContext.GetPar( "modoPalabra") ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV14FilterFullText, AV62LegSexo, AV52LegClase, AV80LegTipoTarifa, AV79LegModTra, AV46ConvenioFiltro, AV56LegFecIngreso, AV55LegFecEgreso, AV49LegActCodigo, AV67MprCod, AV71ZonCod, AV66LegSucCodigo, AV76LegEstado, AV77LegIncompleto, AV83Pgmname, AV64LegSinCod, AV53LegConveCodigo, AV50LegCatCodigo, AV60LegSecCodigo, AV58LegPuesCodigo, AV12GridState, AV65LegSinCod_Data, AV54LegConveCodigo_Data, AV51LegCatCodigo_Data, AV61LegSecCodigo_Data, AV59LegPuesCodigo_Data, AV17CliCod, AV18EmpCod, AV20SelectedCliCod, AV21SelectedEmpCod, AV23SelectedLegNumero, AV38MenuOpcCod, AV74modoPalabra, A3CliCod) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
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
      paJU2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startJU2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.legajosww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV20SelectedCliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV21SelectedEmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV23SelectedLegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(AV38MenuOpcCod)),GXutil.URLEncode(GXutil.rtrim(AV74modoPalabra))}, new String[] {"SelectedCliCod","SelectedEmpCod","SelectedLegNumero","MenuOpcCod","modoPalabra"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV83Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGRIDSTATE", getSecureSignedToken( "", AV12GridState));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20SelectedCliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21SelectedEmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV23SelectedLegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV38MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODOPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV74modoPalabra, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vFILTERFULLTEXT", AV14FilterFullText);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vLEGSEXO", GXutil.ltrim( localUtil.ntoc( AV62LegSexo, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vLEGCLASE", GXutil.ltrim( localUtil.ntoc( AV52LegClase, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vLEGTIPOTARIFA", GXutil.rtrim( AV80LegTipoTarifa));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vLEGMODTRA", GXutil.rtrim( AV79LegModTra));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vCONVENIOFILTRO", GXutil.rtrim( AV46ConvenioFiltro));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vLEGFECINGRESO", localUtil.format(AV56LegFecIngreso, "99/99/9999"));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vLEGFECEGRESO", localUtil.format(AV55LegFecEgreso, "99/99/9999"));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vLEGACTCODIGO", GXutil.rtrim( AV49LegActCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vMPRCOD", GXutil.rtrim( AV67MprCod));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vZONCOD", GXutil.rtrim( AV71ZonCod));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vLEGSUCCODIGO", GXutil.rtrim( AV66LegSucCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vLEGESTADO", GXutil.ltrim( localUtil.ntoc( AV76LegEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vLEGINCOMPLETO", GXutil.booltostr( AV77LegIncompleto));
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_41", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_41, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV47DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV47DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGSINCOD_DATA", AV65LegSinCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGSINCOD_DATA", AV65LegSinCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGCONVECODIGO_DATA", AV54LegConveCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGCONVECODIGO_DATA", AV54LegConveCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGCATCODIGO_DATA", AV51LegCatCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGCATCODIGO_DATA", AV51LegCatCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGSECCODIGO_DATA", AV61LegSecCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGSECCODIGO_DATA", AV61LegSecCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGPUESCODIGO_DATA", AV59LegPuesCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGPUESCODIGO_DATA", AV59LegPuesCodigo_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV83Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV83Pgmname, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGSINCOD", AV64LegSinCod);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGSINCOD", AV64LegSinCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGCONVECODIGO", AV53LegConveCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGCONVECODIGO", AV53LegConveCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGCATCODIGO", AV50LegCatCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGCATCODIGO", AV50LegCatCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGSECCODIGO", AV60LegSecCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGSECCODIGO", AV60LegSecCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGPUESCODIGO", AV58LegPuesCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGPUESCODIGO", AV58LegPuesCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGRIDSTATE", getSecureSignedToken( "", AV12GridState));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV17CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV18EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGFOTONOM", A1030LegFotoNom);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNOMBRE", A251LegNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGAPELLIDO", A230LegApellido);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCLASE", GXutil.ltrim( localUtil.ntoc( A235LegClase, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCATCODIGO", GXutil.rtrim( A939LegCatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCONVECODIGO", GXutil.rtrim( A937LegConveCodigo));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "LEGINCOMPLETO", A2267LegIncompleto);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGMIGRWARN", A2263LegMigrWarn);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDETAILWCHISTORY", AV24DetailWCHistory);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDETAILWCHISTORY", AV24DetailWCHistory);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vDETAILTABLENAME", AV25DetailTableName);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vREFRESHGRID", AV31RefreshGrid);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDETAILWCINFO", AV30DetailWCInfo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDETAILWCINFO", AV30DetailWCInfo);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vLOADDETAILACTION", GXutil.ltrim( localUtil.ntoc( AV26LoadDetailAction, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDCLICOD", GXutil.ltrim( localUtil.ntoc( AV20SelectedCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20SelectedCliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDEMPCOD", GXutil.ltrim( localUtil.ntoc( AV21SelectedEmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21SelectedEmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV23SelectedLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV23SelectedLegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV38MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV38MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODOPALABRA", GXutil.rtrim( AV74modoPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODOPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV74modoPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Cls", GXutil.rtrim( Combo_legsincod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Selectedvalue_set", GXutil.rtrim( Combo_legsincod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Allowmultipleselection", GXutil.booltostr( Combo_legsincod_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Includeonlyselectedoption", GXutil.booltostr( Combo_legsincod_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Multiplevaluestype", GXutil.rtrim( Combo_legsincod_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Cls", GXutil.rtrim( Combo_legconvecodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Selectedvalue_set", GXutil.rtrim( Combo_legconvecodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Allowmultipleselection", GXutil.booltostr( Combo_legconvecodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_legconvecodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Emptyitem", GXutil.booltostr( Combo_legconvecodigo_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Multiplevaluestype", GXutil.rtrim( Combo_legconvecodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Cls", GXutil.rtrim( Combo_legcatcodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_legcatcodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Allowmultipleselection", GXutil.booltostr( Combo_legcatcodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_legcatcodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Multiplevaluestype", GXutil.rtrim( Combo_legcatcodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Cls", GXutil.rtrim( Combo_legseccodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_legseccodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Allowmultipleselection", GXutil.booltostr( Combo_legseccodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_legseccodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Emptyitem", GXutil.booltostr( Combo_legseccodigo_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Multiplevaluestype", GXutil.rtrim( Combo_legseccodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Cls", GXutil.rtrim( Combo_legpuescodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_legpuescodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Allowmultipleselection", GXutil.booltostr( Combo_legpuescodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_legpuescodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Emptyitem", GXutil.booltostr( Combo_legpuescodigo_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Multiplevaluestype", GXutil.rtrim( Combo_legpuescodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGPUESCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legpuescodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSECCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legseccodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCATCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legcatcodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGCONVECODIGO_Selectedvalue_get", GXutil.rtrim( Combo_legconvecodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGSINCOD_Selectedvalue_get", GXutil.rtrim( Combo_legsincod_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCUIL_Visible", GXutil.ltrim( localUtil.ntoc( edtLegCUIL_Visible, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD_Visible", GXutil.ltrim( localUtil.ntoc( edtEmpCod_Visible, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNUMERO_Visible", GXutil.ltrim( localUtil.ntoc( edtLegNumero_Visible, (byte)(5), (byte)(0), ".", "")));
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
      if ( ! ( WebComp_Detailwc == null ) )
      {
         WebComp_Detailwc.componentjscripts();
      }
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
         weJU2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtJU2( ) ;
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
      return formatLink("web.legajosww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV20SelectedCliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV21SelectedEmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV23SelectedLegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(AV38MenuOpcCod)),GXutil.URLEncode(GXutil.rtrim(AV74modoPalabra))}, new String[] {"SelectedCliCod","SelectedEmpCod","SelectedLegNumero","MenuOpcCod","modoPalabra"})  ;
   }

   public String getPgmname( )
   {
      return "LegajosWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Legajos", "") ;
   }

   public void wbJU0( )
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
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divSplitparent_Internalname, 1, 0, "px", 0, "px", "Splitparent", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divSplitleft_Internalname, 1, 0, "px", 0, "px", "SplitLeft", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "TableHeaderSplitScreen", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "mt18", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablevolversvgleg_Internalname, 1, 0, "px", 0, "px", "TableVolverSVGLeg", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:flex-end;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblVolversvg_Internalname, httpContext.getMessage( "<svg width=\"30\" height=\"30\" viewBox=\"0 0 28 28\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><g id=\"arrow-back-circle-outline\"><path id=\"Vector\" d=\"M14.75 18.6083L10.4249 14.2333L14.75 9.85834M11.0259 14.2333H19.7964\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-linecap=\"round\" stroke-linejoin=\"round\"></path><path id=\"Vector_2\" d=\"M25.5719 14.2333C25.5719 8.43646 20.8861 3.73334 15.1107 3.73334C9.33519 3.73334 4.64943 8.43646 4.64943 14.2333C4.64943 20.0302 9.33519 24.7333 15.1107 24.7333C20.8861 24.7333 25.5719 20.0302 25.5719 14.2333Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-miterlimit=\"10\"></path></g></svg>", ""), "", "", lblVolversvg_Jsonclick, "'"+""+"'"+",false,"+"'"+"EVOLVERSVG.CLICK."+"'", "", "VolverSVG", 5, "", 1, 1, 0, (short)(1), "HLP_LegajosWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablevolver_pgmname_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblHtmlhormiga_Internalname, httpContext.getMessage( "Home  /  Nómina", ""), "", "", lblHtmlhormiga_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "NewTextBlockTitleWWP", 0, "", 1, 1, 0, (short)(1), "HLP_LegajosWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblPgmdesc_Internalname, httpContext.getMessage( "Legajos", ""), "", "", lblPgmdesc_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "PgmDesc", 0, "", 1, 1, 0, (short)(0), "HLP_LegajosWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabletotal_Internalname, 1, 0, "px", 0, "px", "TotalPill mb3n ML5", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", 1, 1, 0, (short)(0), "HLP_LegajosWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "MT30", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledFullWidth" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnagregar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 41, 2, 0)+","+"null"+");", httpContext.getMessage( "Agregar", ""), bttBtnagregar_Jsonclick, 5, httpContext.getMessage( "Agregar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOAGREGAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LegajosWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellNoPaddingHorizontal", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesearchlegajo_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavFilterfulltext_Internalname, httpContext.getMessage( "Filter Full Text", ""), "gx-form-item AttributeSearchSplitScreenLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV14FilterFullText, GXutil.rtrim( localUtil.format( AV14FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "WWP_Search", ""), edtavFilterfulltext_Jsonclick, 0, "AttributeSearchSplitScreen", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_LegajosWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table1_34_JU2( true) ;
      }
      else
      {
         wb_table1_34_JU2( false) ;
      }
      return  ;
   }

   public void wb_table1_34_JU2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /*  Grid Control  */
         GridContainer.SetIsFreestyle(true);
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol41( ) ;
      }
      if ( wbEnd == 41 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_41 = (int)(nGXsfl_41_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
            GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divSplitright_Internalname, 1, 0, "px", 0, "px", "SplitRight", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0069"+"", GXutil.rtrim( WebComp_Detailwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0069"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( bGXsfl_41_Refreshing )
            {
               if ( GXutil.len( WebComp_Detailwc_Component) != 0 )
               {
                  if ( GXutil.strcmp(GXutil.lower( OldDetailwc), GXutil.lower( WebComp_Detailwc_Component)) != 0 )
                  {
                     httpContext.ajax_rspStartCmp("gxHTMLWrpW0069"+"");
                  }
                  WebComp_Detailwc.componentdraw();
                  if ( GXutil.strcmp(GXutil.lower( OldDetailwc), GXutil.lower( WebComp_Detailwc_Component)) != 0 )
                  {
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, httpContext.getMessage( "js", ""), "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "displayNone", 0, "", 1, 1, 0, (short)(1), "HLP_LegajosWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         wb_table2_71_JU2( true) ;
      }
      else
      {
         wb_table2_71_JU2( false) ;
      }
      return  ;
   }

   public void wb_table2_71_JU2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 41 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
               GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startJU2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Legajos", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupJU0( ) ;
   }

   public void wsJU2( )
   {
      startJU2( ) ;
      evtJU2( ) ;
   }

   public void evtJU2( )
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
                        else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS.SPLITSCREEN_LOADDETAIL") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11JU2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "TEXTBLOCKFILTROS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12JU2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VOLVERSVG.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13JU2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOAGREGAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoAgregar' */
                           e14JU2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "FSGRIDTABLEROW.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15JU2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           AV84Legajoswwds_1_filterfulltext = AV14FilterFullText ;
                           AV85Legajoswwds_2_legsexo = AV62LegSexo ;
                           AV86Legajoswwds_3_legclase = AV52LegClase ;
                           AV87Legajoswwds_4_legtipotarifa = AV80LegTipoTarifa ;
                           AV88Legajoswwds_5_legmodtra = AV79LegModTra ;
                           AV89Legajoswwds_6_conveniofiltro = AV46ConvenioFiltro ;
                           AV90Legajoswwds_7_legsincod = AV64LegSinCod ;
                           AV91Legajoswwds_8_legconvecodigo = AV53LegConveCodigo ;
                           AV92Legajoswwds_9_legcatcodigo = AV50LegCatCodigo ;
                           AV93Legajoswwds_10_legfecingreso = AV56LegFecIngreso ;
                           AV94Legajoswwds_11_legfecegreso = AV55LegFecEgreso ;
                           AV95Legajoswwds_12_legseccodigo = AV60LegSecCodigo ;
                           AV96Legajoswwds_13_legpuescodigo = AV58LegPuesCodigo ;
                           AV97Legajoswwds_14_legactcodigo = AV49LegActCodigo ;
                           AV98Legajoswwds_15_mprcod = AV67MprCod ;
                           AV99Legajoswwds_16_zoncod = AV71ZonCod ;
                           AV100Legajoswwds_17_legsuccodigo = AV66LegSucCodigo ;
                           AV101Legajoswwds_18_legestado = AV76LegEstado ;
                           AV102Legajoswwds_19_legincompleto = AV77LegIncompleto ;
                           sEvt = httpContext.cgiGet( "GRIDPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 20), "FSGRIDTABLEROW.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_41_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_412( ) ;
                           A239LegCUIL = localUtil.ctol( httpContext.cgiGet( edtLegCUIL_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           AV37img_legajo = httpContext.cgiGet( edtavImg_legajo_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavImg_legajo_Internalname, "Bitmap", ((GXutil.strcmp("", AV37img_legajo)==0) ? AV103Img_legajo_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV37img_legajo))), !bGXsfl_41_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavImg_legajo_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV37img_legajo), true);
                           A591LegNomApe = httpContext.cgiGet( edtLegNomApe_Internalname) ;
                           AV15CatDescrip = httpContext.cgiGet( edtavCatdescrip_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavCatdescrip_Internalname, AV15CatDescrip);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e16JU2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e17JU2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e18JU2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "FSGRIDTABLEROW.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e15JU2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Filterfulltext Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV14FilterFullText) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Legsexo Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vLEGSEXO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV62LegSexo )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Legclase Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vLEGCLASE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV52LegClase )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Legtipotarifa Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vLEGTIPOTARIFA"), AV80LegTipoTarifa) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Legmodtra Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vLEGMODTRA"), AV79LegModTra) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Conveniofiltro Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vCONVENIOFILTRO"), AV46ConvenioFiltro) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Legfecingreso Changed */
                                    if ( !( GXutil.dateCompare(localUtil.ctot( httpContext.cgiGet( "GXH_vLEGFECINGRESO"), 0), AV56LegFecIngreso) ) )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Legfecegreso Changed */
                                    if ( !( GXutil.dateCompare(localUtil.ctot( httpContext.cgiGet( "GXH_vLEGFECEGRESO"), 0), AV55LegFecEgreso) ) )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Legactcodigo Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vLEGACTCODIGO"), AV49LegActCodigo) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Mprcod Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vMPRCOD"), AV67MprCod) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Zoncod Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vZONCOD"), AV71ZonCod) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Legsuccodigo Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vLEGSUCCODIGO"), AV66LegSucCodigo) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Legestado Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vLEGESTADO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV76LegEstado )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Legincompleto Changed */
                                    if ( GXutil.strtobool( httpContext.cgiGet( "GXH_vLEGINCOMPLETO")) != AV77LegIncompleto )
                                    {
                                       Rfr0gs = true ;
                                    }
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
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 69 )
                     {
                        OldDetailwc = httpContext.cgiGet( "W0069") ;
                        if ( ( GXutil.len( OldDetailwc) == 0 ) || ( GXutil.strcmp(OldDetailwc, WebComp_Detailwc_Component) != 0 ) )
                        {
                           WebComp_Detailwc = WebUtils.getWebComponent(getClass(), "web." + OldDetailwc + "_impl", remoteHandle, context);
                           WebComp_Detailwc_Component = OldDetailwc ;
                        }
                        if ( GXutil.len( WebComp_Detailwc_Component) != 0 )
                        {
                           WebComp_Detailwc.componentprocess("W0069", "", sEvt);
                        }
                        WebComp_Detailwc_Component = OldDetailwc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void weJU2( )
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

   public void paJU2( )
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
            GX_FocusControl = edtavFilterfulltext_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_412( ) ;
      while ( nGXsfl_41_idx <= nRC_GXsfl_41 )
      {
         sendrow_412( ) ;
         nGXsfl_41_idx = ((subGrid_Islastpage==1)&&(nGXsfl_41_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_41_idx+1) ;
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_412( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV14FilterFullText ,
                                 byte AV62LegSexo ,
                                 short AV52LegClase ,
                                 String AV80LegTipoTarifa ,
                                 String AV79LegModTra ,
                                 String AV46ConvenioFiltro ,
                                 java.util.Date AV56LegFecIngreso ,
                                 java.util.Date AV55LegFecEgreso ,
                                 String AV49LegActCodigo ,
                                 String AV67MprCod ,
                                 String AV71ZonCod ,
                                 String AV66LegSucCodigo ,
                                 byte AV76LegEstado ,
                                 boolean AV77LegIncompleto ,
                                 String AV83Pgmname ,
                                 GXSimpleCollection<String> AV64LegSinCod ,
                                 GXSimpleCollection<String> AV53LegConveCodigo ,
                                 GXSimpleCollection<String> AV50LegCatCodigo ,
                                 GXSimpleCollection<String> AV60LegSecCodigo ,
                                 GXSimpleCollection<String> AV58LegPuesCodigo ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV65LegSinCod_Data ,
                                 GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV54LegConveCodigo_Data ,
                                 GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV51LegCatCodigo_Data ,
                                 GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV61LegSecCodigo_Data ,
                                 GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV59LegPuesCodigo_Data ,
                                 int AV17CliCod ,
                                 short AV18EmpCod ,
                                 int AV20SelectedCliCod ,
                                 short AV21SelectedEmpCod ,
                                 int AV23SelectedLegNumero ,
                                 String AV38MenuOpcCod ,
                                 String AV74modoPalabra ,
                                 int A3CliCod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e17JU2 ();
      GRID_nCurrentRecord = 0 ;
      rfJU2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_EMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_LEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNUMERO", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), ".", "")));
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
      if ( cmbavLegtipotarifa.getItemCount() > 0 )
      {
         AV80LegTipoTarifa = cmbavLegtipotarifa.getValidValue(AV80LegTipoTarifa) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV80LegTipoTarifa", AV80LegTipoTarifa);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLegtipotarifa.setValue( GXutil.rtrim( AV80LegTipoTarifa) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegtipotarifa.getInternalname(), "Values", cmbavLegtipotarifa.ToJavascriptSource(), true);
      }
      if ( cmbavLegmodtra.getItemCount() > 0 )
      {
         AV79LegModTra = cmbavLegmodtra.getValidValue(AV79LegModTra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV79LegModTra", AV79LegModTra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLegmodtra.setValue( GXutil.rtrim( AV79LegModTra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegmodtra.getInternalname(), "Values", cmbavLegmodtra.ToJavascriptSource(), true);
      }
      if ( cmbavConveniofiltro.getItemCount() > 0 )
      {
         AV46ConvenioFiltro = cmbavConveniofiltro.getValidValue(AV46ConvenioFiltro) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46ConvenioFiltro", AV46ConvenioFiltro);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConveniofiltro.setValue( GXutil.rtrim( AV46ConvenioFiltro) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavConveniofiltro.getInternalname(), "Values", cmbavConveniofiltro.ToJavascriptSource(), true);
      }
      if ( cmbavLegestado.getItemCount() > 0 )
      {
         AV76LegEstado = (byte)(GXutil.lval( cmbavLegestado.getValidValue(GXutil.trim( GXutil.str( AV76LegEstado, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76LegEstado", GXutil.str( AV76LegEstado, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLegestado.setValue( GXutil.trim( GXutil.str( AV76LegEstado, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegestado.getInternalname(), "Values", cmbavLegestado.ToJavascriptSource(), true);
      }
      AV77LegIncompleto = GXutil.strtobool( GXutil.booltostr( AV77LegIncompleto)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77LegIncompleto", AV77LegIncompleto);
   }

   public void refresh( )
   {
      GRID_nFirstRecordOnPage = 0 ;
      GRID_nCurrentRecord = 0 ;
      GXCCtl = "GRID_nFirstRecordOnPage_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      send_integrity_hashes( ) ;
      rfJU2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV83Pgmname = "LegajosWW" ;
      Gx_err = (short)(0) ;
      edtavCatdescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCatdescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCatdescrip_Enabled), 5, 0), !bGXsfl_41_Refreshing);
   }

   public void rfJU2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(41) ;
      /* Execute user event: Refresh */
      e17JU2 ();
      nGXsfl_41_idx = (int)(1+GRID_nFirstRecordOnPage) ;
      sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_412( ) ;
      bGXsfl_41_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", GXutil.rtrim( "FSGridAutoUnselectAll"));
      GridContainer.AddObjectProperty("Class", "FSGridAutoUnselectAll");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Detailwc_Component) != 0 )
            {
               WebComp_Detailwc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_412( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A910LegSinCod ,
                                              AV90Legajoswwds_7_legsincod ,
                                              A937LegConveCodigo ,
                                              AV91Legajoswwds_8_legconvecodigo ,
                                              A939LegCatCodigo ,
                                              AV92Legajoswwds_9_legcatcodigo ,
                                              A1579LegSecCodigo ,
                                              AV95Legajoswwds_12_legseccodigo ,
                                              A1578LegPuesCodigo ,
                                              AV96Legajoswwds_13_legpuescodigo ,
                                              AV84Legajoswwds_1_filterfulltext ,
                                              Byte.valueOf(AV85Legajoswwds_2_legsexo) ,
                                              Short.valueOf(AV86Legajoswwds_3_legclase) ,
                                              AV87Legajoswwds_4_legtipotarifa ,
                                              AV88Legajoswwds_5_legmodtra ,
                                              AV89Legajoswwds_6_conveniofiltro ,
                                              Integer.valueOf(AV90Legajoswwds_7_legsincod.size()) ,
                                              Integer.valueOf(AV91Legajoswwds_8_legconvecodigo.size()) ,
                                              Integer.valueOf(AV92Legajoswwds_9_legcatcodigo.size()) ,
                                              AV93Legajoswwds_10_legfecingreso ,
                                              AV94Legajoswwds_11_legfecegreso ,
                                              Integer.valueOf(AV95Legajoswwds_12_legseccodigo.size()) ,
                                              Integer.valueOf(AV96Legajoswwds_13_legpuescodigo.size()) ,
                                              AV97Legajoswwds_14_legactcodigo ,
                                              AV98Legajoswwds_15_mprcod ,
                                              AV99Legajoswwds_16_zoncod ,
                                              AV100Legajoswwds_17_legsuccodigo ,
                                              Byte.valueOf(AV101Legajoswwds_18_legestado) ,
                                              Boolean.valueOf(AV102Legajoswwds_19_legincompleto) ,
                                              A591LegNomApe ,
                                              Long.valueOf(A239LegCUIL) ,
                                              A93LegId ,
                                              Byte.valueOf(A263LegSexo) ,
                                              Byte.valueOf(A235LegClase) ,
                                              A2417LegTipoTarifa ,
                                              A2404LegModTra ,
                                              A245LegFecIngreso ,
                                              A244LegFecEgreso ,
                                              A15LegActCodigo ,
                                              A18MprCod ,
                                              A20ZonCod ,
                                              A1577LegSucCodigo ,
                                              Byte.valueOf(A1818LegEstado) ,
                                              Boolean.valueOf(A2267LegIncompleto) ,
                                              Integer.valueOf(AV17CliCod) ,
                                              Short.valueOf(AV18EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                              TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                              TypeConstants.LONG, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                              TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                              TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         lV84Legajoswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Legajoswwds_1_filterfulltext), "%", "") ;
         lV84Legajoswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Legajoswwds_1_filterfulltext), "%", "") ;
         lV84Legajoswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Legajoswwds_1_filterfulltext), "%", "") ;
         lV97Legajoswwds_14_legactcodigo = GXutil.padr( GXutil.rtrim( AV97Legajoswwds_14_legactcodigo), 8, "%") ;
         lV98Legajoswwds_15_mprcod = GXutil.padr( GXutil.rtrim( AV98Legajoswwds_15_mprcod), 20, "%") ;
         lV99Legajoswwds_16_zoncod = GXutil.padr( GXutil.rtrim( AV99Legajoswwds_16_zoncod), 20, "%") ;
         lV100Legajoswwds_17_legsuccodigo = GXutil.padr( GXutil.rtrim( AV100Legajoswwds_17_legsuccodigo), 20, "%") ;
         /* Using cursor H00JU2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV17CliCod), Short.valueOf(AV18EmpCod), lV84Legajoswwds_1_filterfulltext, lV84Legajoswwds_1_filterfulltext, lV84Legajoswwds_1_filterfulltext, Byte.valueOf(AV85Legajoswwds_2_legsexo), Short.valueOf(AV86Legajoswwds_3_legclase), AV87Legajoswwds_4_legtipotarifa, AV88Legajoswwds_5_legmodtra, AV93Legajoswwds_10_legfecingreso, AV94Legajoswwds_11_legfecegreso, lV97Legajoswwds_14_legactcodigo, lV98Legajoswwds_15_mprcod, lV99Legajoswwds_16_zoncod, lV100Legajoswwds_17_legsuccodigo, Byte.valueOf(AV101Legajoswwds_18_legestado), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_41_idx = (int)(1+GRID_nFirstRecordOnPage) ;
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_412( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A3CliCod = H00JU2_A3CliCod[0] ;
            A1EmpCod = H00JU2_A1EmpCod[0] ;
            A1577LegSucCodigo = H00JU2_A1577LegSucCodigo[0] ;
            n1577LegSucCodigo = H00JU2_n1577LegSucCodigo[0] ;
            A20ZonCod = H00JU2_A20ZonCod[0] ;
            n20ZonCod = H00JU2_n20ZonCod[0] ;
            A18MprCod = H00JU2_A18MprCod[0] ;
            n18MprCod = H00JU2_n18MprCod[0] ;
            A15LegActCodigo = H00JU2_A15LegActCodigo[0] ;
            n15LegActCodigo = H00JU2_n15LegActCodigo[0] ;
            A93LegId = H00JU2_A93LegId[0] ;
            n93LegId = H00JU2_n93LegId[0] ;
            A1818LegEstado = H00JU2_A1818LegEstado[0] ;
            A1578LegPuesCodigo = H00JU2_A1578LegPuesCodigo[0] ;
            n1578LegPuesCodigo = H00JU2_n1578LegPuesCodigo[0] ;
            A1579LegSecCodigo = H00JU2_A1579LegSecCodigo[0] ;
            n1579LegSecCodigo = H00JU2_n1579LegSecCodigo[0] ;
            A244LegFecEgreso = H00JU2_A244LegFecEgreso[0] ;
            n244LegFecEgreso = H00JU2_n244LegFecEgreso[0] ;
            A245LegFecIngreso = H00JU2_A245LegFecIngreso[0] ;
            A910LegSinCod = H00JU2_A910LegSinCod[0] ;
            n910LegSinCod = H00JU2_n910LegSinCod[0] ;
            A2404LegModTra = H00JU2_A2404LegModTra[0] ;
            A2417LegTipoTarifa = H00JU2_A2417LegTipoTarifa[0] ;
            A263LegSexo = H00JU2_A263LegSexo[0] ;
            n263LegSexo = H00JU2_n263LegSexo[0] ;
            A1030LegFotoNom = H00JU2_A1030LegFotoNom[0] ;
            A251LegNombre = H00JU2_A251LegNombre[0] ;
            A230LegApellido = H00JU2_A230LegApellido[0] ;
            A235LegClase = H00JU2_A235LegClase[0] ;
            A939LegCatCodigo = H00JU2_A939LegCatCodigo[0] ;
            n939LegCatCodigo = H00JU2_n939LegCatCodigo[0] ;
            A937LegConveCodigo = H00JU2_A937LegConveCodigo[0] ;
            n937LegConveCodigo = H00JU2_n937LegConveCodigo[0] ;
            A2267LegIncompleto = H00JU2_A2267LegIncompleto[0] ;
            A2263LegMigrWarn = H00JU2_A2263LegMigrWarn[0] ;
            n2263LegMigrWarn = H00JU2_n2263LegMigrWarn[0] ;
            A591LegNomApe = H00JU2_A591LegNomApe[0] ;
            A6LegNumero = H00JU2_A6LegNumero[0] ;
            A239LegCUIL = H00JU2_A239LegCUIL[0] ;
            e18JU2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(41) ;
         wbJU0( ) ;
      }
      bGXsfl_41_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesJU2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV83Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV83Pgmname, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGRIDSTATE", getSecureSignedToken( "", AV12GridState));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_EMPCOD"+"_"+sGXsfl_41_idx, getSecureSignedToken( sGXsfl_41_idx, localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_LEGNUMERO"+"_"+sGXsfl_41_idx, getSecureSignedToken( sGXsfl_41_idx, localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")));
   }

   public int subgrid_fnc_pagecount( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid_fnc_recordcount( )
   {
      AV84Legajoswwds_1_filterfulltext = AV14FilterFullText ;
      AV85Legajoswwds_2_legsexo = AV62LegSexo ;
      AV86Legajoswwds_3_legclase = AV52LegClase ;
      AV87Legajoswwds_4_legtipotarifa = AV80LegTipoTarifa ;
      AV88Legajoswwds_5_legmodtra = AV79LegModTra ;
      AV89Legajoswwds_6_conveniofiltro = AV46ConvenioFiltro ;
      AV90Legajoswwds_7_legsincod = AV64LegSinCod ;
      AV91Legajoswwds_8_legconvecodigo = AV53LegConveCodigo ;
      AV92Legajoswwds_9_legcatcodigo = AV50LegCatCodigo ;
      AV93Legajoswwds_10_legfecingreso = AV56LegFecIngreso ;
      AV94Legajoswwds_11_legfecegreso = AV55LegFecEgreso ;
      AV95Legajoswwds_12_legseccodigo = AV60LegSecCodigo ;
      AV96Legajoswwds_13_legpuescodigo = AV58LegPuesCodigo ;
      AV97Legajoswwds_14_legactcodigo = AV49LegActCodigo ;
      AV98Legajoswwds_15_mprcod = AV67MprCod ;
      AV99Legajoswwds_16_zoncod = AV71ZonCod ;
      AV100Legajoswwds_17_legsuccodigo = AV66LegSucCodigo ;
      AV101Legajoswwds_18_legestado = AV76LegEstado ;
      AV102Legajoswwds_19_legincompleto = AV77LegIncompleto ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A910LegSinCod ,
                                           AV90Legajoswwds_7_legsincod ,
                                           A937LegConveCodigo ,
                                           AV91Legajoswwds_8_legconvecodigo ,
                                           A939LegCatCodigo ,
                                           AV92Legajoswwds_9_legcatcodigo ,
                                           A1579LegSecCodigo ,
                                           AV95Legajoswwds_12_legseccodigo ,
                                           A1578LegPuesCodigo ,
                                           AV96Legajoswwds_13_legpuescodigo ,
                                           AV84Legajoswwds_1_filterfulltext ,
                                           Byte.valueOf(AV85Legajoswwds_2_legsexo) ,
                                           Short.valueOf(AV86Legajoswwds_3_legclase) ,
                                           AV87Legajoswwds_4_legtipotarifa ,
                                           AV88Legajoswwds_5_legmodtra ,
                                           AV89Legajoswwds_6_conveniofiltro ,
                                           Integer.valueOf(AV90Legajoswwds_7_legsincod.size()) ,
                                           Integer.valueOf(AV91Legajoswwds_8_legconvecodigo.size()) ,
                                           Integer.valueOf(AV92Legajoswwds_9_legcatcodigo.size()) ,
                                           AV93Legajoswwds_10_legfecingreso ,
                                           AV94Legajoswwds_11_legfecegreso ,
                                           Integer.valueOf(AV95Legajoswwds_12_legseccodigo.size()) ,
                                           Integer.valueOf(AV96Legajoswwds_13_legpuescodigo.size()) ,
                                           AV97Legajoswwds_14_legactcodigo ,
                                           AV98Legajoswwds_15_mprcod ,
                                           AV99Legajoswwds_16_zoncod ,
                                           AV100Legajoswwds_17_legsuccodigo ,
                                           Byte.valueOf(AV101Legajoswwds_18_legestado) ,
                                           Boolean.valueOf(AV102Legajoswwds_19_legincompleto) ,
                                           A591LegNomApe ,
                                           Long.valueOf(A239LegCUIL) ,
                                           A93LegId ,
                                           Byte.valueOf(A263LegSexo) ,
                                           Byte.valueOf(A235LegClase) ,
                                           A2417LegTipoTarifa ,
                                           A2404LegModTra ,
                                           A245LegFecIngreso ,
                                           A244LegFecEgreso ,
                                           A15LegActCodigo ,
                                           A18MprCod ,
                                           A20ZonCod ,
                                           A1577LegSucCodigo ,
                                           Byte.valueOf(A1818LegEstado) ,
                                           Boolean.valueOf(A2267LegIncompleto) ,
                                           Integer.valueOf(AV17CliCod) ,
                                           Short.valueOf(AV18EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.LONG, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV84Legajoswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Legajoswwds_1_filterfulltext), "%", "") ;
      lV84Legajoswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Legajoswwds_1_filterfulltext), "%", "") ;
      lV84Legajoswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV84Legajoswwds_1_filterfulltext), "%", "") ;
      lV97Legajoswwds_14_legactcodigo = GXutil.padr( GXutil.rtrim( AV97Legajoswwds_14_legactcodigo), 8, "%") ;
      lV98Legajoswwds_15_mprcod = GXutil.padr( GXutil.rtrim( AV98Legajoswwds_15_mprcod), 20, "%") ;
      lV99Legajoswwds_16_zoncod = GXutil.padr( GXutil.rtrim( AV99Legajoswwds_16_zoncod), 20, "%") ;
      lV100Legajoswwds_17_legsuccodigo = GXutil.padr( GXutil.rtrim( AV100Legajoswwds_17_legsuccodigo), 20, "%") ;
      /* Using cursor H00JU3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV17CliCod), Short.valueOf(AV18EmpCod), lV84Legajoswwds_1_filterfulltext, lV84Legajoswwds_1_filterfulltext, lV84Legajoswwds_1_filterfulltext, Byte.valueOf(AV85Legajoswwds_2_legsexo), Short.valueOf(AV86Legajoswwds_3_legclase), AV87Legajoswwds_4_legtipotarifa, AV88Legajoswwds_5_legmodtra, AV93Legajoswwds_10_legfecingreso, AV94Legajoswwds_11_legfecegreso, lV97Legajoswwds_14_legactcodigo, lV98Legajoswwds_15_mprcod, lV99Legajoswwds_16_zoncod, lV100Legajoswwds_17_legsuccodigo, Byte.valueOf(AV101Legajoswwds_18_legestado)});
      GRID_nRecordCount = H00JU3_AGRID_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID_nRecordCount) ;
   }

   public int subgrid_fnc_recordsperpage( )
   {
      if ( subGrid_Rows > 0 )
      {
         return subGrid_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRID_nFirstRecordOnPage/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid_firstpage( )
   {
      AV84Legajoswwds_1_filterfulltext = AV14FilterFullText ;
      AV85Legajoswwds_2_legsexo = AV62LegSexo ;
      AV86Legajoswwds_3_legclase = AV52LegClase ;
      AV87Legajoswwds_4_legtipotarifa = AV80LegTipoTarifa ;
      AV88Legajoswwds_5_legmodtra = AV79LegModTra ;
      AV89Legajoswwds_6_conveniofiltro = AV46ConvenioFiltro ;
      AV90Legajoswwds_7_legsincod = AV64LegSinCod ;
      AV91Legajoswwds_8_legconvecodigo = AV53LegConveCodigo ;
      AV92Legajoswwds_9_legcatcodigo = AV50LegCatCodigo ;
      AV93Legajoswwds_10_legfecingreso = AV56LegFecIngreso ;
      AV94Legajoswwds_11_legfecegreso = AV55LegFecEgreso ;
      AV95Legajoswwds_12_legseccodigo = AV60LegSecCodigo ;
      AV96Legajoswwds_13_legpuescodigo = AV58LegPuesCodigo ;
      AV97Legajoswwds_14_legactcodigo = AV49LegActCodigo ;
      AV98Legajoswwds_15_mprcod = AV67MprCod ;
      AV99Legajoswwds_16_zoncod = AV71ZonCod ;
      AV100Legajoswwds_17_legsuccodigo = AV66LegSucCodigo ;
      AV101Legajoswwds_18_legestado = AV76LegEstado ;
      AV102Legajoswwds_19_legincompleto = AV77LegIncompleto ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV14FilterFullText, AV62LegSexo, AV52LegClase, AV80LegTipoTarifa, AV79LegModTra, AV46ConvenioFiltro, AV56LegFecIngreso, AV55LegFecEgreso, AV49LegActCodigo, AV67MprCod, AV71ZonCod, AV66LegSucCodigo, AV76LegEstado, AV77LegIncompleto, AV83Pgmname, AV64LegSinCod, AV53LegConveCodigo, AV50LegCatCodigo, AV60LegSecCodigo, AV58LegPuesCodigo, AV12GridState, AV65LegSinCod_Data, AV54LegConveCodigo_Data, AV51LegCatCodigo_Data, AV61LegSecCodigo_Data, AV59LegPuesCodigo_Data, AV17CliCod, AV18EmpCod, AV20SelectedCliCod, AV21SelectedEmpCod, AV23SelectedLegNumero, AV38MenuOpcCod, AV74modoPalabra, A3CliCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV84Legajoswwds_1_filterfulltext = AV14FilterFullText ;
      AV85Legajoswwds_2_legsexo = AV62LegSexo ;
      AV86Legajoswwds_3_legclase = AV52LegClase ;
      AV87Legajoswwds_4_legtipotarifa = AV80LegTipoTarifa ;
      AV88Legajoswwds_5_legmodtra = AV79LegModTra ;
      AV89Legajoswwds_6_conveniofiltro = AV46ConvenioFiltro ;
      AV90Legajoswwds_7_legsincod = AV64LegSinCod ;
      AV91Legajoswwds_8_legconvecodigo = AV53LegConveCodigo ;
      AV92Legajoswwds_9_legcatcodigo = AV50LegCatCodigo ;
      AV93Legajoswwds_10_legfecingreso = AV56LegFecIngreso ;
      AV94Legajoswwds_11_legfecegreso = AV55LegFecEgreso ;
      AV95Legajoswwds_12_legseccodigo = AV60LegSecCodigo ;
      AV96Legajoswwds_13_legpuescodigo = AV58LegPuesCodigo ;
      AV97Legajoswwds_14_legactcodigo = AV49LegActCodigo ;
      AV98Legajoswwds_15_mprcod = AV67MprCod ;
      AV99Legajoswwds_16_zoncod = AV71ZonCod ;
      AV100Legajoswwds_17_legsuccodigo = AV66LegSucCodigo ;
      AV101Legajoswwds_18_legestado = AV76LegEstado ;
      AV102Legajoswwds_19_legincompleto = AV77LegIncompleto ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      if ( GRID_nEOF == 1 )
      {
         GRID_nFirstRecordOnPage = GRID_nCurrentRecord ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV14FilterFullText, AV62LegSexo, AV52LegClase, AV80LegTipoTarifa, AV79LegModTra, AV46ConvenioFiltro, AV56LegFecIngreso, AV55LegFecEgreso, AV49LegActCodigo, AV67MprCod, AV71ZonCod, AV66LegSucCodigo, AV76LegEstado, AV77LegIncompleto, AV83Pgmname, AV64LegSinCod, AV53LegConveCodigo, AV50LegCatCodigo, AV60LegSecCodigo, AV58LegPuesCodigo, AV12GridState, AV65LegSinCod_Data, AV54LegConveCodigo_Data, AV51LegCatCodigo_Data, AV61LegSecCodigo_Data, AV59LegPuesCodigo_Data, AV17CliCod, AV18EmpCod, AV20SelectedCliCod, AV21SelectedEmpCod, AV23SelectedLegNumero, AV38MenuOpcCod, AV74modoPalabra, A3CliCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV84Legajoswwds_1_filterfulltext = AV14FilterFullText ;
      AV85Legajoswwds_2_legsexo = AV62LegSexo ;
      AV86Legajoswwds_3_legclase = AV52LegClase ;
      AV87Legajoswwds_4_legtipotarifa = AV80LegTipoTarifa ;
      AV88Legajoswwds_5_legmodtra = AV79LegModTra ;
      AV89Legajoswwds_6_conveniofiltro = AV46ConvenioFiltro ;
      AV90Legajoswwds_7_legsincod = AV64LegSinCod ;
      AV91Legajoswwds_8_legconvecodigo = AV53LegConveCodigo ;
      AV92Legajoswwds_9_legcatcodigo = AV50LegCatCodigo ;
      AV93Legajoswwds_10_legfecingreso = AV56LegFecIngreso ;
      AV94Legajoswwds_11_legfecegreso = AV55LegFecEgreso ;
      AV95Legajoswwds_12_legseccodigo = AV60LegSecCodigo ;
      AV96Legajoswwds_13_legpuescodigo = AV58LegPuesCodigo ;
      AV97Legajoswwds_14_legactcodigo = AV49LegActCodigo ;
      AV98Legajoswwds_15_mprcod = AV67MprCod ;
      AV99Legajoswwds_16_zoncod = AV71ZonCod ;
      AV100Legajoswwds_17_legsuccodigo = AV66LegSucCodigo ;
      AV101Legajoswwds_18_legestado = AV76LegEstado ;
      AV102Legajoswwds_19_legincompleto = AV77LegIncompleto ;
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV14FilterFullText, AV62LegSexo, AV52LegClase, AV80LegTipoTarifa, AV79LegModTra, AV46ConvenioFiltro, AV56LegFecIngreso, AV55LegFecEgreso, AV49LegActCodigo, AV67MprCod, AV71ZonCod, AV66LegSucCodigo, AV76LegEstado, AV77LegIncompleto, AV83Pgmname, AV64LegSinCod, AV53LegConveCodigo, AV50LegCatCodigo, AV60LegSecCodigo, AV58LegPuesCodigo, AV12GridState, AV65LegSinCod_Data, AV54LegConveCodigo_Data, AV51LegCatCodigo_Data, AV61LegSecCodigo_Data, AV59LegPuesCodigo_Data, AV17CliCod, AV18EmpCod, AV20SelectedCliCod, AV21SelectedEmpCod, AV23SelectedLegNumero, AV38MenuOpcCod, AV74modoPalabra, A3CliCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV84Legajoswwds_1_filterfulltext = AV14FilterFullText ;
      AV85Legajoswwds_2_legsexo = AV62LegSexo ;
      AV86Legajoswwds_3_legclase = AV52LegClase ;
      AV87Legajoswwds_4_legtipotarifa = AV80LegTipoTarifa ;
      AV88Legajoswwds_5_legmodtra = AV79LegModTra ;
      AV89Legajoswwds_6_conveniofiltro = AV46ConvenioFiltro ;
      AV90Legajoswwds_7_legsincod = AV64LegSinCod ;
      AV91Legajoswwds_8_legconvecodigo = AV53LegConveCodigo ;
      AV92Legajoswwds_9_legcatcodigo = AV50LegCatCodigo ;
      AV93Legajoswwds_10_legfecingreso = AV56LegFecIngreso ;
      AV94Legajoswwds_11_legfecegreso = AV55LegFecEgreso ;
      AV95Legajoswwds_12_legseccodigo = AV60LegSecCodigo ;
      AV96Legajoswwds_13_legpuescodigo = AV58LegPuesCodigo ;
      AV97Legajoswwds_14_legactcodigo = AV49LegActCodigo ;
      AV98Legajoswwds_15_mprcod = AV67MprCod ;
      AV99Legajoswwds_16_zoncod = AV71ZonCod ;
      AV100Legajoswwds_17_legsuccodigo = AV66LegSucCodigo ;
      AV101Legajoswwds_18_legestado = AV76LegEstado ;
      AV102Legajoswwds_19_legincompleto = AV77LegIncompleto ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( GRID_nRecordCount > subgrid_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-subgrid_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV14FilterFullText, AV62LegSexo, AV52LegClase, AV80LegTipoTarifa, AV79LegModTra, AV46ConvenioFiltro, AV56LegFecIngreso, AV55LegFecEgreso, AV49LegActCodigo, AV67MprCod, AV71ZonCod, AV66LegSucCodigo, AV76LegEstado, AV77LegIncompleto, AV83Pgmname, AV64LegSinCod, AV53LegConveCodigo, AV50LegCatCodigo, AV60LegSecCodigo, AV58LegPuesCodigo, AV12GridState, AV65LegSinCod_Data, AV54LegConveCodigo_Data, AV51LegCatCodigo_Data, AV61LegSecCodigo_Data, AV59LegPuesCodigo_Data, AV17CliCod, AV18EmpCod, AV20SelectedCliCod, AV21SelectedEmpCod, AV23SelectedLegNumero, AV38MenuOpcCod, AV74modoPalabra, A3CliCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV84Legajoswwds_1_filterfulltext = AV14FilterFullText ;
      AV85Legajoswwds_2_legsexo = AV62LegSexo ;
      AV86Legajoswwds_3_legclase = AV52LegClase ;
      AV87Legajoswwds_4_legtipotarifa = AV80LegTipoTarifa ;
      AV88Legajoswwds_5_legmodtra = AV79LegModTra ;
      AV89Legajoswwds_6_conveniofiltro = AV46ConvenioFiltro ;
      AV90Legajoswwds_7_legsincod = AV64LegSinCod ;
      AV91Legajoswwds_8_legconvecodigo = AV53LegConveCodigo ;
      AV92Legajoswwds_9_legcatcodigo = AV50LegCatCodigo ;
      AV93Legajoswwds_10_legfecingreso = AV56LegFecIngreso ;
      AV94Legajoswwds_11_legfecegreso = AV55LegFecEgreso ;
      AV95Legajoswwds_12_legseccodigo = AV60LegSecCodigo ;
      AV96Legajoswwds_13_legpuescodigo = AV58LegPuesCodigo ;
      AV97Legajoswwds_14_legactcodigo = AV49LegActCodigo ;
      AV98Legajoswwds_15_mprcod = AV67MprCod ;
      AV99Legajoswwds_16_zoncod = AV71ZonCod ;
      AV100Legajoswwds_17_legsuccodigo = AV66LegSucCodigo ;
      AV101Legajoswwds_18_legestado = AV76LegEstado ;
      AV102Legajoswwds_19_legincompleto = AV77LegIncompleto ;
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV14FilterFullText, AV62LegSexo, AV52LegClase, AV80LegTipoTarifa, AV79LegModTra, AV46ConvenioFiltro, AV56LegFecIngreso, AV55LegFecEgreso, AV49LegActCodigo, AV67MprCod, AV71ZonCod, AV66LegSucCodigo, AV76LegEstado, AV77LegIncompleto, AV83Pgmname, AV64LegSinCod, AV53LegConveCodigo, AV50LegCatCodigo, AV60LegSecCodigo, AV58LegPuesCodigo, AV12GridState, AV65LegSinCod_Data, AV54LegConveCodigo_Data, AV51LegCatCodigo_Data, AV61LegSecCodigo_Data, AV59LegPuesCodigo_Data, AV17CliCod, AV18EmpCod, AV20SelectedCliCod, AV21SelectedEmpCod, AV23SelectedLegNumero, AV38MenuOpcCod, AV74modoPalabra, A3CliCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV83Pgmname = "LegajosWW" ;
      Gx_err = (short)(0) ;
      edtavCatdescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCatdescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCatdescrip_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupJU0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e16JU2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV47DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGSINCOD_DATA"), AV65LegSinCod_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGCONVECODIGO_DATA"), AV54LegConveCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGCATCODIGO_DATA"), AV51LegCatCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGSECCODIGO_DATA"), AV61LegSecCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGPUESCODIGO_DATA"), AV59LegPuesCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGSINCOD"), AV64LegSinCod);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGCONVECODIGO"), AV53LegConveCodigo);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGCATCODIGO"), AV50LegCatCodigo);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGSECCODIGO"), AV60LegSecCodigo);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGPUESCODIGO"), AV58LegPuesCodigo);
         /* Read saved values. */
         nRC_GXsfl_41 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_41"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Combo_legsincod_Cls = httpContext.cgiGet( "COMBO_LEGSINCOD_Cls") ;
         Combo_legsincod_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGSINCOD_Selectedvalue_set") ;
         Combo_legsincod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGSINCOD_Allowmultipleselection")) ;
         Combo_legsincod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGSINCOD_Includeonlyselectedoption")) ;
         Combo_legsincod_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGSINCOD_Multiplevaluestype") ;
         Combo_legconvecodigo_Cls = httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Cls") ;
         Combo_legconvecodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Selectedvalue_set") ;
         Combo_legconvecodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Allowmultipleselection")) ;
         Combo_legconvecodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Includeonlyselectedoption")) ;
         Combo_legconvecodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Emptyitem")) ;
         Combo_legconvecodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGCONVECODIGO_Multiplevaluestype") ;
         Combo_legcatcodigo_Cls = httpContext.cgiGet( "COMBO_LEGCATCODIGO_Cls") ;
         Combo_legcatcodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGCATCODIGO_Selectedvalue_set") ;
         Combo_legcatcodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGCATCODIGO_Allowmultipleselection")) ;
         Combo_legcatcodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGCATCODIGO_Includeonlyselectedoption")) ;
         Combo_legcatcodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGCATCODIGO_Multiplevaluestype") ;
         Combo_legseccodigo_Cls = httpContext.cgiGet( "COMBO_LEGSECCODIGO_Cls") ;
         Combo_legseccodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGSECCODIGO_Selectedvalue_set") ;
         Combo_legseccodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGSECCODIGO_Allowmultipleselection")) ;
         Combo_legseccodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGSECCODIGO_Includeonlyselectedoption")) ;
         Combo_legseccodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGSECCODIGO_Emptyitem")) ;
         Combo_legseccodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGSECCODIGO_Multiplevaluestype") ;
         Combo_legpuescodigo_Cls = httpContext.cgiGet( "COMBO_LEGPUESCODIGO_Cls") ;
         Combo_legpuescodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGPUESCODIGO_Selectedvalue_set") ;
         Combo_legpuescodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGPUESCODIGO_Allowmultipleselection")) ;
         Combo_legpuescodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGPUESCODIGO_Includeonlyselectedoption")) ;
         Combo_legpuescodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGPUESCODIGO_Emptyitem")) ;
         Combo_legpuescodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGPUESCODIGO_Multiplevaluestype") ;
         /* Read variables values. */
         AV14FilterFullText = httpContext.cgiGet( edtavFilterfulltext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14FilterFullText", AV14FilterFullText);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLegsexo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLegsexo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLEGSEXO");
            GX_FocusControl = edtavLegsexo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV62LegSexo = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62LegSexo), 2, 0));
         }
         else
         {
            AV62LegSexo = (byte)(localUtil.ctol( httpContext.cgiGet( edtavLegsexo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62LegSexo), 2, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLegclase_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLegclase_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLEGCLASE");
            GX_FocusControl = edtavLegclase_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV52LegClase = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52LegClase", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52LegClase), 4, 0));
         }
         else
         {
            AV52LegClase = (short)(localUtil.ctol( httpContext.cgiGet( edtavLegclase_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52LegClase", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52LegClase), 4, 0));
         }
         cmbavLegtipotarifa.setName( cmbavLegtipotarifa.getInternalname() );
         cmbavLegtipotarifa.setValue( httpContext.cgiGet( cmbavLegtipotarifa.getInternalname()) );
         AV80LegTipoTarifa = httpContext.cgiGet( cmbavLegtipotarifa.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV80LegTipoTarifa", AV80LegTipoTarifa);
         cmbavLegmodtra.setName( cmbavLegmodtra.getInternalname() );
         cmbavLegmodtra.setValue( httpContext.cgiGet( cmbavLegmodtra.getInternalname()) );
         AV79LegModTra = httpContext.cgiGet( cmbavLegmodtra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV79LegModTra", AV79LegModTra);
         cmbavConveniofiltro.setName( cmbavConveniofiltro.getInternalname() );
         cmbavConveniofiltro.setValue( httpContext.cgiGet( cmbavConveniofiltro.getInternalname()) );
         AV46ConvenioFiltro = httpContext.cgiGet( cmbavConveniofiltro.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46ConvenioFiltro", AV46ConvenioFiltro);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavLegfecingreso_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vLEGFECINGRESO");
            GX_FocusControl = edtavLegfecingreso_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV56LegFecIngreso = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56LegFecIngreso", localUtil.format(AV56LegFecIngreso, "99/99/9999"));
         }
         else
         {
            AV56LegFecIngreso = localUtil.ctod( httpContext.cgiGet( edtavLegfecingreso_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56LegFecIngreso", localUtil.format(AV56LegFecIngreso, "99/99/9999"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavLegfecegreso_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vLEGFECEGRESO");
            GX_FocusControl = edtavLegfecegreso_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV55LegFecEgreso = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55LegFecEgreso", localUtil.format(AV55LegFecEgreso, "99/99/9999"));
         }
         else
         {
            AV55LegFecEgreso = localUtil.ctod( httpContext.cgiGet( edtavLegfecegreso_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55LegFecEgreso", localUtil.format(AV55LegFecEgreso, "99/99/9999"));
         }
         AV49LegActCodigo = httpContext.cgiGet( edtavLegactcodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV49LegActCodigo", AV49LegActCodigo);
         AV67MprCod = httpContext.cgiGet( edtavMprcod_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV67MprCod", AV67MprCod);
         AV71ZonCod = httpContext.cgiGet( edtavZoncod_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV71ZonCod", AV71ZonCod);
         AV66LegSucCodigo = httpContext.cgiGet( edtavLegsuccodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV66LegSucCodigo", AV66LegSucCodigo);
         cmbavLegestado.setName( cmbavLegestado.getInternalname() );
         cmbavLegestado.setValue( httpContext.cgiGet( cmbavLegestado.getInternalname()) );
         AV76LegEstado = (byte)(GXutil.lval( httpContext.cgiGet( cmbavLegestado.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76LegEstado", GXutil.str( AV76LegEstado, 1, 0));
         AV77LegIncompleto = GXutil.strtobool( httpContext.cgiGet( chkavLegincompleto.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV77LegIncompleto", AV77LegIncompleto);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV14FilterFullText) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vLEGSEXO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV62LegSexo )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vLEGCLASE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV52LegClase )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vLEGTIPOTARIFA"), AV80LegTipoTarifa) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vLEGMODTRA"), AV79LegModTra) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vCONVENIOFILTRO"), AV46ConvenioFiltro) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( !( GXutil.dateCompare(GXutil.resetTime(localUtil.ctod( httpContext.cgiGet( "GXH_vLEGFECINGRESO"), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))), GXutil.resetTime(AV56LegFecIngreso)) ) )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( !( GXutil.dateCompare(GXutil.resetTime(localUtil.ctod( httpContext.cgiGet( "GXH_vLEGFECEGRESO"), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))), GXutil.resetTime(AV55LegFecEgreso)) ) )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vLEGACTCODIGO"), AV49LegActCodigo) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vMPRCOD"), AV67MprCod) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vZONCOD"), AV71ZonCod) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vLEGSUCCODIGO"), AV66LegSucCodigo) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vLEGESTADO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV76LegEstado )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strtobool( httpContext.cgiGet( "GXH_vLEGINCOMPLETO")) != AV77LegIncompleto )
         {
            GRID_nFirstRecordOnPage = 0 ;
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
      e16JU2 ();
      if (returnInSub) return;
   }

   public void e16JU2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_char1 = AV73filtrosSVGValor ;
      GXt_char2 = AV73filtrosSVGValor ;
      GXv_char3[0] = GXt_char2 ;
      new web.svgid_legajofiltros(remoteHandle, context).execute( GXv_char3) ;
      legajosww_impl.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char2, GXv_char4) ;
      legajosww_impl.this.GXt_char1 = GXv_char4[0] ;
      AV73filtrosSVGValor = GXt_char1 ;
      lblTextblockfiltros_Caption = AV73filtrosSVGValor ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockfiltros_Internalname, "Caption", lblTextblockfiltros_Caption, true);
      GXt_int5 = AV18EmpCod ;
      GXv_int6[0] = GXt_int5 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int6) ;
      legajosww_impl.this.GXt_int5 = GXv_int6[0] ;
      AV18EmpCod = GXt_int5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18EmpCod), 4, 0));
      /* Execute user subroutine: 'INICIALIZAR FILTROS VACIOS' */
      S112 ();
      if (returnInSub) return;
      AV34websession.setValue(httpContext.getMessage( "MODO_LEGAJO", ""), AV74modoPalabra);
      new web.setopcionmenusesion(remoteHandle, context).execute( AV38MenuOpcCod, "", "") ;
      GXt_int7 = AV17CliCod ;
      GXv_int8[0] = GXt_int7 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
      legajosww_impl.this.GXt_int7 = GXv_int8[0] ;
      AV17CliCod = GXt_int7 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17CliCod), 6, 0));
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9 = AV47DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10[0] ;
      AV47DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9;
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if (returnInSub) return;
      edtLegCUIL_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCUIL_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCUIL_Visible), 5, 0), !bGXsfl_41_Refreshing);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), !bGXsfl_41_Refreshing);
      edtLegNumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Visible), 5, 0), !bGXsfl_41_Refreshing);
      subGrid_Rows = 50 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      AV52LegClase = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52LegClase", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52LegClase), 4, 0));
      AV80LegTipoTarifa = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV80LegTipoTarifa", AV80LegTipoTarifa);
      AV79LegModTra = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79LegModTra", AV79LegModTra);
      AV46ConvenioFiltro = "Todos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46ConvenioFiltro", AV46ConvenioFiltro);
      AV76LegEstado = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76LegEstado", GXutil.str( AV76LegEstado, 1, 0));
      Form.setCaption( httpContext.getMessage( " Legajos", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      /* Object Property */
      if ( true )
      {
         bDynCreated_Detailwc = true ;
      }
      if ( GXutil.strcmp(GXutil.lower( WebComp_Detailwc_Component), GXutil.lower( "LegajosView")) != 0 )
      {
         WebComp_Detailwc = WebUtils.getWebComponent(getClass(), "web.legajosview_impl", remoteHandle, context);
         WebComp_Detailwc_Component = "LegajosView" ;
      }
      if ( GXutil.len( WebComp_Detailwc_Component) != 0 )
      {
         WebComp_Detailwc.setjustcreated();
         WebComp_Detailwc.componentprepare(new Object[] {"W0069","",Integer.valueOf(AV20SelectedCliCod),Short.valueOf(AV21SelectedEmpCod),Integer.valueOf(AV23SelectedLegNumero),""});
         WebComp_Detailwc.componentbind(new Object[] {"","","",""});
      }
      GXv_int6[0] = AV68PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV17CliCod, GXv_int6) ;
      legajosww_impl.this.AV68PaiCod = GXv_int6[0] ;
   }

   public void e17JU2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV16Session.getValue(GXutil.trim( AV83Pgmname)+httpContext.getMessage( "clickPopUpFiltros", "")), "1") == 0 )
      {
         /* Execute user subroutine: 'INICIALIZAR FILTROS VACIOS' */
         S112 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S142 ();
         if (returnInSub) return;
         AV16Session.setValue(GXutil.trim( AV83Pgmname)+httpContext.getMessage( "clickPopUpFiltros", ""), "0");
      }
      GXt_int5 = AV18EmpCod ;
      GXv_int6[0] = GXt_int5 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int6) ;
      legajosww_impl.this.GXt_int5 = GXv_int6[0] ;
      AV18EmpCod = GXt_int5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18EmpCod), 4, 0));
      GXt_int7 = AV17CliCod ;
      GXv_int8[0] = GXt_int7 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
      legajosww_impl.this.GXt_int7 = GXv_int8[0] ;
      AV17CliCod = GXt_int7 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17CliCod), 6, 0));
      GXv_SdtWWPContext11[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext11) ;
      AV6WWPContext = GXv_SdtWWPContext11[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S152 ();
      if (returnInSub) return;
      lblCouttext_Caption = GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0)) ;
      httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      AV84Legajoswwds_1_filterfulltext = AV14FilterFullText ;
      AV85Legajoswwds_2_legsexo = AV62LegSexo ;
      AV86Legajoswwds_3_legclase = AV52LegClase ;
      AV87Legajoswwds_4_legtipotarifa = AV80LegTipoTarifa ;
      AV88Legajoswwds_5_legmodtra = AV79LegModTra ;
      AV89Legajoswwds_6_conveniofiltro = AV46ConvenioFiltro ;
      AV90Legajoswwds_7_legsincod = AV64LegSinCod ;
      AV91Legajoswwds_8_legconvecodigo = AV53LegConveCodigo ;
      AV92Legajoswwds_9_legcatcodigo = AV50LegCatCodigo ;
      AV93Legajoswwds_10_legfecingreso = AV56LegFecIngreso ;
      AV94Legajoswwds_11_legfecegreso = AV55LegFecEgreso ;
      AV95Legajoswwds_12_legseccodigo = AV60LegSecCodigo ;
      AV96Legajoswwds_13_legpuescodigo = AV58LegPuesCodigo ;
      AV97Legajoswwds_14_legactcodigo = AV49LegActCodigo ;
      AV98Legajoswwds_15_mprcod = AV67MprCod ;
      AV99Legajoswwds_16_zoncod = AV71ZonCod ;
      AV100Legajoswwds_17_legsuccodigo = AV66LegSucCodigo ;
      AV101Legajoswwds_18_legestado = AV76LegEstado ;
      AV102Legajoswwds_19_legincompleto = AV77LegIncompleto ;
      /*  Sending Event outputs  */
      cmbavLegmodtra.setValue( GXutil.rtrim( AV79LegModTra) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLegmodtra.getInternalname(), "Values", cmbavLegmodtra.ToJavascriptSource(), true);
      cmbavLegtipotarifa.setValue( GXutil.rtrim( AV80LegTipoTarifa) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLegtipotarifa.getInternalname(), "Values", cmbavLegtipotarifa.ToJavascriptSource(), true);
      cmbavConveniofiltro.setValue( GXutil.rtrim( AV46ConvenioFiltro) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavConveniofiltro.getInternalname(), "Values", cmbavConveniofiltro.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64LegSinCod", AV64LegSinCod);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53LegConveCodigo", AV53LegConveCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50LegCatCodigo", AV50LegCatCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60LegSecCodigo", AV60LegSecCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV58LegPuesCodigo", AV58LegPuesCodigo);
      cmbavLegestado.setValue( GXutil.trim( GXutil.str( AV76LegEstado, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLegestado.getInternalname(), "Values", cmbavLegestado.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV65LegSinCod_Data", AV65LegSinCod_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV54LegConveCodigo_Data", AV54LegConveCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV51LegCatCodigo_Data", AV51LegCatCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV61LegSecCodigo_Data", AV61LegSecCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV59LegPuesCodigo_Data", AV59LegPuesCodigo_Data);
   }

   private void e18JU2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV83Pgmname, httpContext.getMessage( "&!!FilterFullText ", "")+AV14FilterFullText) ;
      GXv_char4[0] = AV36urlFoto ;
      new web.devuelveurlfoto(remoteHandle, context).execute( AV17CliCod, AV18EmpCod, A6LegNumero, httpContext.getMessage( "legajo", ""), GXutil.trim( A1030LegFotoNom), GXv_char4) ;
      legajosww_impl.this.AV36urlFoto = GXv_char4[0] ;
      if ( (GXutil.strcmp("", AV36urlFoto)==0) )
      {
         edtavImg_legajo_Visible = 0 ;
         lblTextblockbadgename_Visible = 1 ;
         GXt_char2 = AV78inicialesPalabra ;
         GXv_char4[0] = GXt_char2 ;
         new web.getinicialesleg(remoteHandle, context).execute( A251LegNombre, A230LegApellido, GXv_char4) ;
         legajosww_impl.this.GXt_char2 = GXv_char4[0] ;
         AV78inicialesPalabra = GXt_char2 ;
         lblTextblockbadgename_Caption = GXutil.trim( AV78inicialesPalabra) ;
      }
      else
      {
         edtavImg_legajo_Visible = 1 ;
         AV37img_legajo = context.getHttpContext().getImagePath( AV36urlFoto, "", context.getHttpContext().getTheme( )) ;
         httpContext.ajax_rsp_assign_attri("", false, edtavImg_legajo_Internalname, AV37img_legajo);
         AV103Img_legajo_GXI = GXDbFile.pathToUrl( AV36urlFoto, context.getHttpContext()) ;
         lblTextblockbadgename_Visible = 0 ;
      }
      edtavImg_legajo_Class = httpContext.getMessage( "avatarLegajo", "") ;
      AV15CatDescrip = GXutil.trim( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)A235LegClase), "")) + " - " ;
      httpContext.ajax_rsp_assign_attri("", false, edtavCatdescrip_Internalname, AV15CatDescrip);
      if ( (GXutil.strcmp("", A939LegCatCodigo)==0) || (GXutil.strcmp("", A939LegCatCodigo)==0) )
      {
         AV15CatDescrip += httpContext.getMessage( "Fuera de Convenio", "") ;
         httpContext.ajax_rsp_assign_attri("", false, edtavCatdescrip_Internalname, AV15CatDescrip);
      }
      else
      {
         GXv_int8[0] = AV32CliConveVer ;
         new web.getversiondelegajo(remoteHandle, context).execute( AV17CliCod, AV18EmpCod, A6LegNumero, GXv_int8) ;
         legajosww_impl.this.AV32CliConveVer = GXv_int8[0] ;
         GXt_char2 = AV33AuxCatDescrip ;
         GXv_char4[0] = GXt_char2 ;
         new web.getclasificacionlegtxt(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, GXv_char4) ;
         legajosww_impl.this.GXt_char2 = GXv_char4[0] ;
         AV33AuxCatDescrip = GXt_char2 ;
         AV15CatDescrip += GXutil.trim( AV33AuxCatDescrip) ;
         httpContext.ajax_rsp_assign_attri("", false, edtavCatdescrip_Internalname, AV15CatDescrip);
         GXv_char4[0] = AV40ConveDescri ;
         GXv_boolean12[0] = false ;
         new web.getconvenio(remoteHandle, context).execute( AV17CliCod, A937LegConveCodigo, GXv_char4, GXv_boolean12) ;
         legajosww_impl.this.AV40ConveDescri = GXv_char4[0] ;
         AV15CatDescrip += " - " + GXutil.trim( AV40ConveDescri) ;
         httpContext.ajax_rsp_assign_attri("", false, edtavCatdescrip_Internalname, AV15CatDescrip);
      }
      if ( A2267LegIncompleto )
      {
         lblTextblockbadgename_Tooltiptext = GXutil.trim( A2263LegMigrWarn) ;
      }
      else
      {
         lblTextblockbadgename_Tooltiptext = "" ;
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(41) ;
      }
      sendrow_412( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_41_Refreshing )
      {
         httpContext.doAjaxLoad(41, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e15JU2( )
   {
      /* Fsgridtablerow_Click Routine */
      returnInSub = false ;
      AV34websession.setValue(httpContext.getMessage( "MODO_LEGAJO", ""), httpContext.getMessage( "DSP", ""));
      AV27DetailWCLink = formatLink("web.legajosview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","EmpCod","LegNumero","TabCode"})  ;
      AV27DetailWCLink = formatLink("web.legajosview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","EmpCod","LegNumero","TabCode"})  ;
      if ( 1 == 0 )
      {
         AV16Session.setValue("", "");
      }
      AV30DetailWCInfo = (web.wwpbaseobjects.SdtSplitScreenDetailInfo)new web.wwpbaseobjects.SdtSplitScreenDetailInfo(remoteHandle, context);
      AV30DetailWCInfo.setgxTv_SdtSplitScreenDetailInfo_Link( AV27DetailWCLink );
      AV24DetailWCHistory.add(AV30DetailWCInfo, 0);
      /* Object Property */
      if ( true )
      {
         bDynCreated_Detailwc = true ;
      }
      if ( ! httpContext.IsSameComponent( WebComp_Detailwc_Component, AV27DetailWCLink) )
      {
         WebComp_Detailwc = WebUtils.getWebComponent(getClass(), "web." + AV27DetailWCLink + "_impl", remoteHandle, context);
         WebComp_Detailwc_Component = AV27DetailWCLink ;
      }
      if ( GXutil.len( WebComp_Detailwc_Component) != 0 )
      {
         WebComp_Detailwc.setjustcreated();
         WebComp_Detailwc.componentprepare(new Object[] {"W0069",""});
         WebComp_Detailwc.componentbind(new Object[] {});
      }
      if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Detailwc )
      {
         httpContext.ajax_rspStartCmp("gxHTMLWrpW0069"+"");
         WebComp_Detailwc.componentdraw();
         httpContext.ajax_rspEndCmp();
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30DetailWCInfo", AV30DetailWCInfo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24DetailWCHistory", AV24DetailWCHistory);
   }

   public void e11JU2( )
   {
      /* GlobalEvents_Splitscreen_loaddetail Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV25DetailTableName, "legajo") != 0 )
      {
         if ( AV26LoadDetailAction == 3 )
         {
            AV26LoadDetailAction = (byte)(2) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26LoadDetailAction", GXutil.str( AV26LoadDetailAction, 1, 0));
         }
      }
      if ( ( AV26LoadDetailAction == 1 ) || ( AV26LoadDetailAction == 3 ) )
      {
         AV27DetailWCLink = AV30DetailWCInfo.getgxTv_SdtSplitScreenDetailInfo_Link() ;
         AV24DetailWCHistory.add(AV30DetailWCInfo, 0);
      }
      else
      {
         if ( AV24DetailWCHistory.size() > 0 )
         {
            AV24DetailWCHistory.removeItem(AV24DetailWCHistory.size());
         }
         if ( ( AV26LoadDetailAction == 4 ) && ( AV24DetailWCHistory.size() > 0 ) && ( GXutil.strcmp(((web.wwpbaseobjects.SdtSplitScreenDetailInfo)AV24DetailWCHistory.elementAt(-1+AV24DetailWCHistory.size())).getgxTv_SdtSplitScreenDetailInfo_Link(), AV30DetailWCInfo.getgxTv_SdtSplitScreenDetailInfo_Link()) == 0 ) )
         {
            AV24DetailWCHistory.removeItem(AV24DetailWCHistory.size());
         }
         if ( AV24DetailWCHistory.size() > 0 )
         {
            AV30DetailWCInfo = (web.wwpbaseobjects.SdtSplitScreenDetailInfo)((web.wwpbaseobjects.SdtSplitScreenDetailInfo)AV24DetailWCHistory.elementAt(-1+AV24DetailWCHistory.size()));
            AV27DetailWCLink = AV30DetailWCInfo.getgxTv_SdtSplitScreenDetailInfo_Link() ;
         }
         else
         {
            AV27DetailWCLink = formatLink("web.legajosview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","EmpCod","LegNumero","TabCode"})  ;
         }
      }
      /* Object Property */
      if ( true )
      {
         bDynCreated_Detailwc = true ;
      }
      if ( ! httpContext.IsSameComponent( WebComp_Detailwc_Component, AV27DetailWCLink) )
      {
         WebComp_Detailwc = WebUtils.getWebComponent(getClass(), "web." + AV27DetailWCLink + "_impl", remoteHandle, context);
         WebComp_Detailwc_Component = AV27DetailWCLink ;
      }
      if ( GXutil.len( WebComp_Detailwc_Component) != 0 )
      {
         WebComp_Detailwc.setjustcreated();
         WebComp_Detailwc.componentprepare(new Object[] {"W0069",""});
         WebComp_Detailwc.componentbind(new Object[] {});
      }
      if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Detailwc )
      {
         httpContext.ajax_rspStartCmp("gxHTMLWrpW0069"+"");
         WebComp_Detailwc.componentdraw();
         httpContext.ajax_rspEndCmp();
      }
      if ( AV31RefreshGrid && ( GXutil.strcmp(AV25DetailTableName, "legajo") == 0 ) )
      {
         GRID_nFirstRecordOnPage = 0 ;
         GRID_nCurrentRecord = 0 ;
         GXCCtl = "GRID_nFirstRecordOnPage_" + sGXsfl_41_idx ;
         web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         gxgrgrid_refresh( subGrid_Rows, AV14FilterFullText, AV62LegSexo, AV52LegClase, AV80LegTipoTarifa, AV79LegModTra, AV46ConvenioFiltro, AV56LegFecIngreso, AV55LegFecEgreso, AV49LegActCodigo, AV67MprCod, AV71ZonCod, AV66LegSucCodigo, AV76LegEstado, AV77LegIncompleto, AV83Pgmname, AV64LegSinCod, AV53LegConveCodigo, AV50LegCatCodigo, AV60LegSecCodigo, AV58LegPuesCodigo, AV12GridState, AV65LegSinCod_Data, AV54LegConveCodigo_Data, AV51LegCatCodigo_Data, AV61LegSecCodigo_Data, AV59LegPuesCodigo_Data, AV17CliCod, AV18EmpCod, AV20SelectedCliCod, AV21SelectedEmpCod, AV23SelectedLegNumero, AV38MenuOpcCod, AV74modoPalabra, A3CliCod) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24DetailWCHistory", AV24DetailWCHistory);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30DetailWCInfo", AV30DetailWCInfo);
      cmbavLegmodtra.setValue( GXutil.rtrim( AV79LegModTra) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLegmodtra.getInternalname(), "Values", cmbavLegmodtra.ToJavascriptSource(), true);
      cmbavLegtipotarifa.setValue( GXutil.rtrim( AV80LegTipoTarifa) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLegtipotarifa.getInternalname(), "Values", cmbavLegtipotarifa.ToJavascriptSource(), true);
      cmbavConveniofiltro.setValue( GXutil.rtrim( AV46ConvenioFiltro) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavConveniofiltro.getInternalname(), "Values", cmbavConveniofiltro.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64LegSinCod", AV64LegSinCod);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53LegConveCodigo", AV53LegConveCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50LegCatCodigo", AV50LegCatCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60LegSecCodigo", AV60LegSecCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV58LegPuesCodigo", AV58LegPuesCodigo);
      cmbavLegestado.setValue( GXutil.trim( GXutil.str( AV76LegEstado, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLegestado.getInternalname(), "Values", cmbavLegestado.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV65LegSinCod_Data", AV65LegSinCod_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV54LegConveCodigo_Data", AV54LegConveCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV51LegCatCodigo_Data", AV51LegCatCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV61LegSecCodigo_Data", AV61LegSecCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV59LegPuesCodigo_Data", AV59LegPuesCodigo_Data);
   }

   public void e14JU2( )
   {
      /* 'DoAgregar' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.abmlegajo", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV17CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV18EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "LegajoINS", "")))}, new String[] {"CliCod","EmpCod","LegNumero","ParmTrnMode","MenuOpcCod"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
      /*  Sending Event outputs  */
   }

   public void S142( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV83Pgmname, httpContext.getMessage( "antes de loadgridstate ", "")+AV12GridState.toJSonString(false, true)) ;
      if ( GXutil.strcmp(AV16Session.getValue(AV83Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV83Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV16Session.getValue(AV83Pgmname+"GridState"), null, null);
      }
      AV104GXV1 = 1 ;
      while ( AV104GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV104GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV14FilterFullText = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14FilterFullText", AV14FilterFullText);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGSEXO") == 0 )
         {
            AV62LegSexo = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62LegSexo), 2, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGCLASE") == 0 )
         {
            AV52LegClase = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52LegClase", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52LegClase), 4, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGTIPOTARIFA") == 0 )
         {
            AV80LegTipoTarifa = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80LegTipoTarifa", AV80LegTipoTarifa);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGMODTRA") == 0 )
         {
            AV79LegModTra = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79LegModTra", AV79LegModTra);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "CONVENIOFILTRO") == 0 )
         {
            AV46ConvenioFiltro = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46ConvenioFiltro", AV46ConvenioFiltro);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGSINCOD") == 0 )
         {
            AV64LegSinCod.fromJSonString(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGCONVECODIGO") == 0 )
         {
            AV53LegConveCodigo.fromJSonString(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGCATCODIGO") == 0 )
         {
            AV50LegCatCodigo.fromJSonString(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGFECINGRESO") == 0 )
         {
            AV56LegFecIngreso = localUtil.ctod( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56LegFecIngreso", localUtil.format(AV56LegFecIngreso, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGFECEGRESO") == 0 )
         {
            AV55LegFecEgreso = localUtil.ctod( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55LegFecEgreso", localUtil.format(AV55LegFecEgreso, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGSECCODIGO") == 0 )
         {
            AV60LegSecCodigo.fromJSonString(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGPUESCODIGO") == 0 )
         {
            AV58LegPuesCodigo.fromJSonString(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGACTCODIGO") == 0 )
         {
            AV49LegActCodigo = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49LegActCodigo", AV49LegActCodigo);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "MPRCOD") == 0 )
         {
            AV67MprCod = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67MprCod", AV67MprCod);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "ZONCOD") == 0 )
         {
            AV71ZonCod = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71ZonCod", AV71ZonCod);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGSUCCODIGO") == 0 )
         {
            AV66LegSucCodigo = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66LegSucCodigo", AV66LegSucCodigo);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGESTADO") == 0 )
         {
            AV76LegEstado = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76LegEstado", GXutil.str( AV76LegEstado, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGINCOMPLETO") == 0 )
         {
            AV77LegIncompleto = GXutil.boolval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77LegIncompleto", AV77LegIncompleto);
         }
         AV104GXV1 = (int)(AV104GXV1+1) ;
      }
      /* Execute user subroutine: 'LOADCOMBOLEGSINCOD' */
      S202 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOLEGCONVECODIGO' */
      S162 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOLEGCATCODIGO' */
      S172 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOLEGSECCODIGO' */
      S182 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOLEGPUESCODIGO' */
      S192 ();
      if (returnInSub) return;
      new web.msgdebug_prod(remoteHandle, context).execute( AV83Pgmname, httpContext.getMessage( "despues de loadgridstate ", "")+AV12GridState.toJSonString(false, true)) ;
      if ( AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S152 ();
         if (returnInSub) return;
      }
      GXv_int6[0] = AV41cantFiltros ;
      GXv_char4[0] = AV48filtrosTexto ;
      new web.countfiltroslegajos(remoteHandle, context).execute( AV12GridState, GXv_int6, GXv_char4) ;
      legajosww_impl.this.AV41cantFiltros = GXv_int6[0] ;
      legajosww_impl.this.AV48filtrosTexto = GXv_char4[0] ;
      if ( AV41cantFiltros > 0 )
      {
         lblTextblockbadgefiltersplitscreen_Caption = GXutil.trim( GXutil.str( AV41cantFiltros, 4, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockbadgefiltersplitscreen_Internalname, "Caption", lblTextblockbadgefiltersplitscreen_Caption, true);
         lblTextblockbadgefiltersplitscreen_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockbadgefiltersplitscreen_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTextblockbadgefiltersplitscreen_Visible), 5, 0), true);
      }
      else
      {
         lblTextblockbadgefiltersplitscreen_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockbadgefiltersplitscreen_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTextblockbadgefiltersplitscreen_Visible), 5, 0), true);
      }
      lblTextblockbadgefiltersplitscreen_Tooltiptext = GXutil.trim( AV48filtrosTexto) ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockbadgefiltersplitscreen_Internalname, "Tooltiptext", lblTextblockbadgefiltersplitscreen_Tooltiptext, true);
      lblTextblockfiltros_Tooltiptext = GXutil.trim( AV48filtrosTexto) ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockfiltros_Internalname, "Tooltiptext", lblTextblockfiltros_Tooltiptext, true);
      new web.msgdebug_prod(remoteHandle, context).execute( AV83Pgmname, httpContext.getMessage( "&&GridState ", "")+GXutil.trim( AV12GridState.toJSonString(false, true))) ;
   }

   public void S152( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      if ( true )
      {
         AV105GXV2 = 1 ;
         while ( AV105GXV2 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
         {
            AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV105GXV2));
            if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
            {
               AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV14FilterFullText );
               new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV83Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
            }
            AV105GXV2 = (int)(AV105GXV2+1) ;
         }
      }
      else
      {
         AV12GridState.fromxml(AV16Session.getValue(AV83Pgmname+"GridState"), null, null);
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "FILTERFULLTEXT", "", !(GXutil.strcmp("", AV14FilterFullText)==0), (short)(0), AV14FilterFullText, "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGSEXO", "", !(0==AV62LegSexo), (short)(0), GXutil.trim( GXutil.str( AV62LegSexo, 2, 0)), "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGCLASE", "", !(0==AV52LegClase), (short)(0), GXutil.trim( GXutil.str( AV52LegClase, 4, 0)), "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGTIPOTARIFA", "", !(GXutil.strcmp("", AV80LegTipoTarifa)==0), (short)(0), AV80LegTipoTarifa, "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGMODTRA", "", !(GXutil.strcmp("", AV79LegModTra)==0), (short)(0), AV79LegModTra, "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "CONVENIOFILTRO", "", true, (short)(0), AV46ConvenioFiltro, "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         GXv_objcol_SdtDVB_SDTComboData_Item14[0] = AV65LegSinCod_Data ;
         new web.wwpbaseobjects.wwp_gridstateaddcombofiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGSINCOD", "", !(AV64LegSinCod.size()==0), AV64LegSinCod.toJSonString(false), GXv_objcol_SdtDVB_SDTComboData_Item14, true) ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         AV65LegSinCod_Data = GXv_objcol_SdtDVB_SDTComboData_Item14[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         GXv_objcol_SdtDVB_SDTComboData_Item14[0] = AV54LegConveCodigo_Data ;
         new web.wwpbaseobjects.wwp_gridstateaddcombofiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGCONVECODIGO", "", !(AV53LegConveCodigo.size()==0), AV53LegConveCodigo.toJSonString(false), GXv_objcol_SdtDVB_SDTComboData_Item14, true) ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         AV54LegConveCodigo_Data = GXv_objcol_SdtDVB_SDTComboData_Item14[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         GXv_objcol_SdtDVB_SDTComboData_Item14[0] = AV51LegCatCodigo_Data ;
         new web.wwpbaseobjects.wwp_gridstateaddcombofiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGCATCODIGO", "", !(AV50LegCatCodigo.size()==0), AV50LegCatCodigo.toJSonString(false), GXv_objcol_SdtDVB_SDTComboData_Item14, true) ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         AV51LegCatCodigo_Data = GXv_objcol_SdtDVB_SDTComboData_Item14[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGFECINGRESO", "", !GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV56LegFecIngreso)), (short)(0), GXutil.trim( localUtil.dtoc( AV56LegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGFECEGRESO", "", !GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV55LegFecEgreso)), (short)(0), GXutil.trim( localUtil.dtoc( AV55LegFecEgreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         GXv_objcol_SdtDVB_SDTComboData_Item14[0] = AV61LegSecCodigo_Data ;
         new web.wwpbaseobjects.wwp_gridstateaddcombofiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGSECCODIGO", "", !(AV60LegSecCodigo.size()==0), AV60LegSecCodigo.toJSonString(false), GXv_objcol_SdtDVB_SDTComboData_Item14, true) ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         AV61LegSecCodigo_Data = GXv_objcol_SdtDVB_SDTComboData_Item14[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         GXv_objcol_SdtDVB_SDTComboData_Item14[0] = AV59LegPuesCodigo_Data ;
         new web.wwpbaseobjects.wwp_gridstateaddcombofiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGPUESCODIGO", "", !(AV58LegPuesCodigo.size()==0), AV58LegPuesCodigo.toJSonString(false), GXv_objcol_SdtDVB_SDTComboData_Item14, true) ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         AV59LegPuesCodigo_Data = GXv_objcol_SdtDVB_SDTComboData_Item14[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGACTCODIGO", "", !(GXutil.strcmp("", AV49LegActCodigo)==0), (short)(0), AV49LegActCodigo, "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "MPRCOD", "", !(GXutil.strcmp("", AV67MprCod)==0), (short)(0), AV67MprCod, "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "ZONCOD", "", !(GXutil.strcmp("", AV71ZonCod)==0), (short)(0), AV71ZonCod, "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGSUCCODIGO", "", !(GXutil.strcmp("", AV66LegSucCodigo)==0), (short)(0), AV66LegSucCodigo, "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGESTADO", "", true, (short)(0), GXutil.trim( GXutil.str( AV76LegEstado, 1, 0)), "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         GXv_SdtWWPGridState13[0] = AV12GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState13, "LEGINCOMPLETO", "", !(false==AV77LegIncompleto), (short)(0), GXutil.trim( GXutil.booltostr( AV77LegIncompleto)), "") ;
         AV12GridState = GXv_SdtWWPGridState13[0] ;
         new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV83Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
      }
   }

   public void S132( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV83Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Legajos" );
      AV16Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      tblTblfiltrosinvisibles_Visible = ((false) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, tblTblfiltrosinvisibles_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTblfiltrosinvisibles_Visible), 5, 0), true);
   }

   public void S192( )
   {
      /* 'LOADCOMBOLEGPUESCODIGO' Routine */
      returnInSub = false ;
      Combo_legpuescodigo_Selectedvalue_set = AV58LegPuesCodigo.toJSonString(false) ;
      ucCombo_legpuescodigo.sendProperty(context, "", false, Combo_legpuescodigo_Internalname, "SelectedValue_set", Combo_legpuescodigo_Selectedvalue_set);
   }

   public void S182( )
   {
      /* 'LOADCOMBOLEGSECCODIGO' Routine */
      returnInSub = false ;
      Combo_legseccodigo_Selectedvalue_set = AV60LegSecCodigo.toJSonString(false) ;
      ucCombo_legseccodigo.sendProperty(context, "", false, Combo_legseccodigo_Internalname, "SelectedValue_set", Combo_legseccodigo_Selectedvalue_set);
   }

   public void S172( )
   {
      /* 'LOADCOMBOLEGCATCODIGO' Routine */
      returnInSub = false ;
      Combo_legcatcodigo_Selectedvalue_set = AV50LegCatCodigo.toJSonString(false) ;
      ucCombo_legcatcodigo.sendProperty(context, "", false, Combo_legcatcodigo_Internalname, "SelectedValue_set", Combo_legcatcodigo_Selectedvalue_set);
   }

   public void S162( )
   {
      /* 'LOADCOMBOLEGCONVECODIGO' Routine */
      returnInSub = false ;
      AV54LegConveCodigo_Data.sort("Title");
      Combo_legconvecodigo_Selectedvalue_set = AV53LegConveCodigo.toJSonString(false) ;
      ucCombo_legconvecodigo.sendProperty(context, "", false, Combo_legconvecodigo_Internalname, "SelectedValue_set", Combo_legconvecodigo_Selectedvalue_set);
   }

   public void S202( )
   {
      /* 'LOADCOMBOLEGSINCOD' Routine */
      returnInSub = false ;
      AV65LegSinCod_Data.sort("Title");
      Combo_legsincod_Selectedvalue_set = AV64LegSinCod.toJSonString(false) ;
      ucCombo_legsincod.sendProperty(context, "", false, Combo_legsincod_Internalname, "SelectedValue_set", Combo_legsincod_Selectedvalue_set);
   }

   public void e12JU2( )
   {
      /* Textblockfiltros_Click Routine */
      returnInSub = false ;
      AV16Session.setValue(GXutil.trim( AV83Pgmname)+httpContext.getMessage( "clickPopUpFiltros", ""), "1");
      AV70window.setWidth( 500 );
      AV70window.setHeight( 500 );
      /* Window Datatype Object Property */
      AV70window.setUrl( formatLink("web.legajofiltros", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV17CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV18EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"CliCod","EmpCod","LegNumero"})  );
      AV70window.setReturnParms(new Object[] {});
      httpContext.newWindow(AV70window);
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      cmbavLegmodtra.setValue( GXutil.rtrim( AV79LegModTra) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLegmodtra.getInternalname(), "Values", cmbavLegmodtra.ToJavascriptSource(), true);
      cmbavLegtipotarifa.setValue( GXutil.rtrim( AV80LegTipoTarifa) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLegtipotarifa.getInternalname(), "Values", cmbavLegtipotarifa.ToJavascriptSource(), true);
      cmbavConveniofiltro.setValue( GXutil.rtrim( AV46ConvenioFiltro) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavConveniofiltro.getInternalname(), "Values", cmbavConveniofiltro.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64LegSinCod", AV64LegSinCod);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53LegConveCodigo", AV53LegConveCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50LegCatCodigo", AV50LegCatCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60LegSecCodigo", AV60LegSecCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV58LegPuesCodigo", AV58LegPuesCodigo);
      cmbavLegestado.setValue( GXutil.trim( GXutil.str( AV76LegEstado, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLegestado.getInternalname(), "Values", cmbavLegestado.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV65LegSinCod_Data", AV65LegSinCod_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV54LegConveCodigo_Data", AV54LegConveCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV51LegCatCodigo_Data", AV51LegCatCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV61LegSecCodigo_Data", AV61LegSecCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV59LegPuesCodigo_Data", AV59LegPuesCodigo_Data);
   }

   public void e13JU2( )
   {
      /* Volversvg_Click Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'INICIALIZAR FILTROS VACIOS' Routine */
      returnInSub = false ;
      AV62LegSexo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62LegSexo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62LegSexo), 2, 0));
      AV52LegClase = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52LegClase", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52LegClase), 4, 0));
      AV79LegModTra = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79LegModTra", AV79LegModTra);
      AV80LegTipoTarifa = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV80LegTipoTarifa", AV80LegTipoTarifa);
      AV46ConvenioFiltro = "Todos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46ConvenioFiltro", AV46ConvenioFiltro);
      AV64LegSinCod.clear();
      AV53LegConveCodigo.clear();
      AV50LegCatCodigo.clear();
      AV56LegFecIngreso = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56LegFecIngreso", localUtil.format(AV56LegFecIngreso, "99/99/9999"));
      AV55LegFecEgreso = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55LegFecEgreso", localUtil.format(AV55LegFecEgreso, "99/99/9999"));
      AV60LegSecCodigo.clear();
      AV58LegPuesCodigo.clear();
      AV49LegActCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49LegActCodigo", AV49LegActCodigo);
      AV67MprCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67MprCod", AV67MprCod);
      AV71ZonCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71ZonCod", AV71ZonCod);
      AV66LegSucCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66LegSucCodigo", AV66LegSucCodigo);
      AV76LegEstado = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76LegEstado", GXutil.str( AV76LegEstado, 1, 0));
      AV77LegIncompleto = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77LegIncompleto", AV77LegIncompleto);
   }

   public void wb_table2_71_JU2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTblfiltrosinvisibles_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTblfiltrosinvisibles_Internalname, tblTblfiltrosinvisibles_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavLegsexo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLegsexo_Internalname, httpContext.getMessage( "Sexo", ""), "gx-form-item AttributeSearchSplitScreenLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegsexo_Internalname, GXutil.ltrim( localUtil.ntoc( AV62LegSexo, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavLegsexo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV62LegSexo), "Z9") : localUtil.format( DecimalUtil.doubleToDec(AV62LegSexo), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,76);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "WWP_Search", ""), edtavLegsexo_Jsonclick, 0, "AttributeSearchSplitScreen", "", "", "", "", 1, edtavLegsexo_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajosWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavLegclase_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLegclase_Internalname, httpContext.getMessage( "Clase", ""), "gx-form-item AttributeSearchSplitScreenLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegclase_Internalname, GXutil.ltrim( localUtil.ntoc( AV52LegClase, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavLegclase_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV52LegClase), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV52LegClase), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,81);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "WWP_Search", ""), edtavLegclase_Jsonclick, 0, "AttributeSearchSplitScreen", "", "", "", "", 1, edtavLegclase_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajosWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLegtipotarifa.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLegtipotarifa.getInternalname(), httpContext.getMessage( "Tipo de tarifa", ""), "gx-form-item AttributeSearchSplitScreenLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 86,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLegtipotarifa, cmbavLegtipotarifa.getInternalname(), GXutil.rtrim( AV80LegTipoTarifa), 1, cmbavLegtipotarifa.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavLegtipotarifa.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeSearchSplitScreen", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,86);\"", "", true, (byte)(0), "HLP_LegajosWW.htm");
         cmbavLegtipotarifa.setValue( GXutil.rtrim( AV80LegTipoTarifa) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegtipotarifa.getInternalname(), "Values", cmbavLegtipotarifa.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLegmodtra.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLegmodtra.getInternalname(), httpContext.getMessage( "Relación", ""), "gx-form-item AttributeSearchSplitScreenLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 91,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLegmodtra, cmbavLegmodtra.getInternalname(), GXutil.rtrim( AV79LegModTra), 1, cmbavLegmodtra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavLegmodtra.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeSearchSplitScreen", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,91);\"", "", true, (byte)(0), "HLP_LegajosWW.htm");
         cmbavLegmodtra.setValue( GXutil.rtrim( AV79LegModTra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegmodtra.getInternalname(), "Values", cmbavLegmodtra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConveniofiltro.getInternalname()+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 96,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConveniofiltro, cmbavConveniofiltro.getInternalname(), GXutil.rtrim( AV46ConvenioFiltro), 1, cmbavConveniofiltro.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavConveniofiltro.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeSearchSplitScreen", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,96);\"", "", true, (byte)(0), "HLP_LegajosWW.htm");
         cmbavConveniofiltro.setValue( GXutil.rtrim( AV46ConvenioFiltro) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavConveniofiltro.getInternalname(), "Values", cmbavConveniofiltro.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* User Defined Control */
         ucCombo_legsincod.setProperty("Caption", Combo_legsincod_Caption);
         ucCombo_legsincod.setProperty("Cls", Combo_legsincod_Cls);
         ucCombo_legsincod.setProperty("AllowMultipleSelection", Combo_legsincod_Allowmultipleselection);
         ucCombo_legsincod.setProperty("IncludeOnlySelectedOption", Combo_legsincod_Includeonlyselectedoption);
         ucCombo_legsincod.setProperty("MultipleValuesType", Combo_legsincod_Multiplevaluestype);
         ucCombo_legsincod.setProperty("DropDownOptionsTitleSettingsIcons", AV47DDO_TitleSettingsIcons);
         ucCombo_legsincod.setProperty("DropDownOptionsData", AV65LegSinCod_Data);
         ucCombo_legsincod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legsincod_Internalname, "COMBO_LEGSINCODContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* User Defined Control */
         ucCombo_legconvecodigo.setProperty("Caption", Combo_legconvecodigo_Caption);
         ucCombo_legconvecodigo.setProperty("Cls", Combo_legconvecodigo_Cls);
         ucCombo_legconvecodigo.setProperty("AllowMultipleSelection", Combo_legconvecodigo_Allowmultipleselection);
         ucCombo_legconvecodigo.setProperty("IncludeOnlySelectedOption", Combo_legconvecodigo_Includeonlyselectedoption);
         ucCombo_legconvecodigo.setProperty("EmptyItem", Combo_legconvecodigo_Emptyitem);
         ucCombo_legconvecodigo.setProperty("MultipleValuesType", Combo_legconvecodigo_Multiplevaluestype);
         ucCombo_legconvecodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV47DDO_TitleSettingsIcons);
         ucCombo_legconvecodigo.setProperty("DropDownOptionsData", AV54LegConveCodigo_Data);
         ucCombo_legconvecodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legconvecodigo_Internalname, "COMBO_LEGCONVECODIGOContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* User Defined Control */
         ucCombo_legcatcodigo.setProperty("Caption", Combo_legcatcodigo_Caption);
         ucCombo_legcatcodigo.setProperty("Cls", Combo_legcatcodigo_Cls);
         ucCombo_legcatcodigo.setProperty("AllowMultipleSelection", Combo_legcatcodigo_Allowmultipleselection);
         ucCombo_legcatcodigo.setProperty("IncludeOnlySelectedOption", Combo_legcatcodigo_Includeonlyselectedoption);
         ucCombo_legcatcodigo.setProperty("MultipleValuesType", Combo_legcatcodigo_Multiplevaluestype);
         ucCombo_legcatcodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV47DDO_TitleSettingsIcons);
         ucCombo_legcatcodigo.setProperty("DropDownOptionsData", AV51LegCatCodigo_Data);
         ucCombo_legcatcodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legcatcodigo_Internalname, "COMBO_LEGCATCODIGOContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLegfecingreso_Internalname, httpContext.getMessage( "Leg Fec Ingreso", ""), "gx-form-item AttributeSearchSplitScreenDateLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavLegfecingreso_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegfecingreso_Internalname, localUtil.format(AV56LegFecIngreso, "99/99/9999"), localUtil.format( AV56LegFecIngreso, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegfecingreso_Jsonclick, 0, "AttributeSearchSplitScreenDate", "", "", "", "", 1, edtavLegfecingreso_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajosWW.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavLegfecingreso_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavLegfecingreso_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LegajosWW.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLegfecegreso_Internalname, httpContext.getMessage( "Leg Fec Egreso", ""), "gx-form-item AttributeSearchSplitScreenDateLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 113,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavLegfecegreso_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegfecegreso_Internalname, localUtil.format(AV55LegFecEgreso, "99/99/9999"), localUtil.format( AV55LegFecEgreso, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,113);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegfecegreso_Jsonclick, 0, "AttributeSearchSplitScreenDate", "", "", "", "", 1, edtavLegfecegreso_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajosWW.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavLegfecegreso_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavLegfecegreso_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LegajosWW.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* User Defined Control */
         ucCombo_legseccodigo.setProperty("Caption", Combo_legseccodigo_Caption);
         ucCombo_legseccodigo.setProperty("Cls", Combo_legseccodigo_Cls);
         ucCombo_legseccodigo.setProperty("AllowMultipleSelection", Combo_legseccodigo_Allowmultipleselection);
         ucCombo_legseccodigo.setProperty("IncludeOnlySelectedOption", Combo_legseccodigo_Includeonlyselectedoption);
         ucCombo_legseccodigo.setProperty("EmptyItem", Combo_legseccodigo_Emptyitem);
         ucCombo_legseccodigo.setProperty("MultipleValuesType", Combo_legseccodigo_Multiplevaluestype);
         ucCombo_legseccodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV47DDO_TitleSettingsIcons);
         ucCombo_legseccodigo.setProperty("DropDownOptionsData", AV61LegSecCodigo_Data);
         ucCombo_legseccodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legseccodigo_Internalname, "COMBO_LEGSECCODIGOContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* User Defined Control */
         ucCombo_legpuescodigo.setProperty("Caption", Combo_legpuescodigo_Caption);
         ucCombo_legpuescodigo.setProperty("Cls", Combo_legpuescodigo_Cls);
         ucCombo_legpuescodigo.setProperty("AllowMultipleSelection", Combo_legpuescodigo_Allowmultipleselection);
         ucCombo_legpuescodigo.setProperty("IncludeOnlySelectedOption", Combo_legpuescodigo_Includeonlyselectedoption);
         ucCombo_legpuescodigo.setProperty("EmptyItem", Combo_legpuescodigo_Emptyitem);
         ucCombo_legpuescodigo.setProperty("MultipleValuesType", Combo_legpuescodigo_Multiplevaluestype);
         ucCombo_legpuescodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV47DDO_TitleSettingsIcons);
         ucCombo_legpuescodigo.setProperty("DropDownOptionsData", AV59LegPuesCodigo_Data);
         ucCombo_legpuescodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legpuescodigo_Internalname, "COMBO_LEGPUESCODIGOContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLegactcodigo_Internalname, httpContext.getMessage( "Leg Act Codigo", ""), "gx-form-item AttributeSearchSplitScreenLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 123,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegactcodigo_Internalname, GXutil.rtrim( AV49LegActCodigo), GXutil.rtrim( localUtil.format( AV49LegActCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,123);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "WWP_Search", ""), edtavLegactcodigo_Jsonclick, 0, "AttributeSearchSplitScreen", "", "", "", "", 1, edtavLegactcodigo_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LegajosWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavMprcod_Internalname, httpContext.getMessage( "Mpr Cod", ""), "gx-form-item AttributeSearchSplitScreenLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 127,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavMprcod_Internalname, GXutil.rtrim( AV67MprCod), GXutil.rtrim( localUtil.format( AV67MprCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,127);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "WWP_Search", ""), edtavMprcod_Jsonclick, 0, "AttributeSearchSplitScreen", "", "", "", "", 1, edtavMprcod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LegajosWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavZoncod_Internalname, httpContext.getMessage( "Zon Cod", ""), "gx-form-item AttributeSearchSplitScreenLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 131,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavZoncod_Internalname, GXutil.rtrim( AV71ZonCod), GXutil.rtrim( localUtil.format( AV71ZonCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,131);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "WWP_Search", ""), edtavZoncod_Jsonclick, 0, "AttributeSearchSplitScreen", "", "", "", "", 1, edtavZoncod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LegajosWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLegsuccodigo_Internalname, httpContext.getMessage( "Leg Suc Codigo", ""), "gx-form-item AttributeSearchSplitScreenLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 135,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegsuccodigo_Internalname, GXutil.rtrim( AV66LegSucCodigo), GXutil.rtrim( localUtil.format( AV66LegSucCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,135);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "WWP_Search", ""), edtavLegsuccodigo_Jsonclick, 0, "AttributeSearchSplitScreen", "", "", "", "", 1, edtavLegsuccodigo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LegajosWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLegestado.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLegestado.getInternalname(), httpContext.getMessage( "Estado", ""), "gx-form-item AttributeSearchSplitScreenLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 140,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLegestado, cmbavLegestado.getInternalname(), GXutil.trim( GXutil.str( AV76LegEstado, 1, 0)), 1, cmbavLegestado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavLegestado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeSearchSplitScreen", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,140);\"", "", true, (byte)(0), "HLP_LegajosWW.htm");
         cmbavLegestado.setValue( GXutil.trim( GXutil.str( AV76LegEstado, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLegestado.getInternalname(), "Values", cmbavLegestado.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellNoPaddingHorizontal'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+chkavLegincompleto.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavLegincompleto.getInternalname(), httpContext.getMessage( "Datos incompletos", ""), "gx-form-item AttributeSearchSplitScreenCheckBoxLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 145,'',false,'" + sGXsfl_41_idx + "',0)\"" ;
         ClassString = "AttributeSearchSplitScreenCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavLegincompleto.getInternalname(), GXutil.booltostr( AV77LegIncompleto), "", httpContext.getMessage( "Datos incompletos", ""), 1, chkavLegincompleto.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(145, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,145);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_71_JU2e( true) ;
      }
      else
      {
         wb_table2_71_JU2e( false) ;
      }
   }

   public void wb_table1_34_JU2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablebuttonfiltros_Internalname, tblTablebuttonfiltros_Internalname, "", "tablebuttonfiltros ML10", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockbadgefiltersplitscreen_Internalname, lblTextblockbadgefiltersplitscreen_Caption, "", "", lblTextblockbadgefiltersplitscreen_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "BadgeFilterSplit", 0, lblTextblockbadgefiltersplitscreen_Tooltiptext, lblTextblockbadgefiltersplitscreen_Visible, 1, 0, (short)(0), "HLP_LegajosWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockfiltros_Internalname, lblTextblockfiltros_Caption, "", "", lblTextblockfiltros_Jsonclick, "'"+""+"'"+",false,"+"'"+"ETEXTBLOCKFILTROS.CLICK."+"'", "", "TextBlock", 5, lblTextblockfiltros_Tooltiptext, 1, 1, 0, (short)(1), "HLP_LegajosWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_34_JU2e( true) ;
      }
      else
      {
         wb_table1_34_JU2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV20SelectedCliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20SelectedCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20SelectedCliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20SelectedCliCod), "ZZZZZ9")));
      AV21SelectedEmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21SelectedEmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21SelectedEmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21SelectedEmpCod), "ZZZ9")));
      AV23SelectedLegNumero = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23SelectedLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23SelectedLegNumero), 8, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSELECTEDLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV23SelectedLegNumero), "ZZZZZZZ9")));
      AV38MenuOpcCod = (String)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38MenuOpcCod", AV38MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV38MenuOpcCod, ""))));
      AV74modoPalabra = (String)getParm(obj,4) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74modoPalabra", AV74modoPalabra);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODOPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV74modoPalabra, ""))));
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
      paJU2( ) ;
      wsJU2( ) ;
      weJU2( ) ;
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
      if ( ! ( WebComp_Detailwc == null ) )
      {
         if ( GXutil.len( WebComp_Detailwc_Component) != 0 )
         {
            WebComp_Detailwc.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713474737", true, true);
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
      httpContext.AddJavascriptSource("legajosww.js", "?20251713474738", false, true);
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

   public void subsflControlProps_412( )
   {
      edtLegCUIL_Internalname = "LEGCUIL_"+sGXsfl_41_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_41_idx ;
      edtLegNumero_Internalname = "LEGNUMERO_"+sGXsfl_41_idx ;
      lblTextblockbadgename_Internalname = "TEXTBLOCKBADGENAME_"+sGXsfl_41_idx ;
      edtavImg_legajo_Internalname = "vIMG_LEGAJO_"+sGXsfl_41_idx ;
      edtLegNomApe_Internalname = "LEGNOMAPE_"+sGXsfl_41_idx ;
      edtavCatdescrip_Internalname = "vCATDESCRIP_"+sGXsfl_41_idx ;
   }

   public void subsflControlProps_fel_412( )
   {
      edtLegCUIL_Internalname = "LEGCUIL_"+sGXsfl_41_fel_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_41_fel_idx ;
      edtLegNumero_Internalname = "LEGNUMERO_"+sGXsfl_41_fel_idx ;
      lblTextblockbadgename_Internalname = "TEXTBLOCKBADGENAME_"+sGXsfl_41_fel_idx ;
      edtavImg_legajo_Internalname = "vIMG_LEGAJO_"+sGXsfl_41_fel_idx ;
      edtLegNomApe_Internalname = "LEGNOMAPE_"+sGXsfl_41_fel_idx ;
      edtavCatdescrip_Internalname = "vCATDESCRIP_"+sGXsfl_41_fel_idx ;
   }

   public void sendrow_412( )
   {
      subsflControlProps_412( ) ;
      wbJU0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_41_idx - GRID_nFirstRecordOnPage <= subgrid_fnc_recordsperpage( ) * 1 ) )
      {
         GridRow = GXWebRow.GetNew(context,GridContainer) ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            subGrid_Backcolor = subGrid_Allbackcolor ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Uniform" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
            subGrid_Backcolor = (int)(0xFFFFFF) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_41_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0xFFFFFF) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         /* Start of Columns property logic. */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr"+" class=\""+subGrid_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_41_idx+"\">") ;
         }
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divFsgridtablerow_Internalname+"_"+sGXsfl_41_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableSplitMasterListRow CellSplitScreenFS borderNone","left","top"," "+"data-gx-flex"+" ","align-items:center;","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Invisible","left","top","","flex-grow:1;","div"});
         /* Table start */
         GridRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsgrid_Internalname+"_"+sGXsfl_41_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
         GridRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
         GridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtLegCUIL_Internalname,httpContext.getMessage( "Número de CUIL", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCUIL_Internalname,GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(13), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A239LegCUIL), "ZZ-ZZZZZZZZ-9")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCUIL_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtLegCUIL_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(13),"chr",Integer.valueOf(1),"row",Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         if ( GridContainer.GetWrapped() == 1 )
         {
            GridContainer.CloseTag("cell");
         }
         GridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,httpContext.getMessage( "Empresa", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtEmpCod_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         if ( GridContainer.GetWrapped() == 1 )
         {
            GridContainer.CloseTag("cell");
         }
         GridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtLegNumero_Internalname,httpContext.getMessage( "Legajo", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtLegNumero_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         if ( GridContainer.GetWrapped() == 1 )
         {
            GridContainer.CloseTag("cell");
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            GridContainer.CloseTag("row");
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            GridContainer.CloseTag("table");
         }
         /* End of table */
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","align-self:center;","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableimagelegajo_Internalname+"_"+sGXsfl_41_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","align-items:center;","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
         /* Text block */
         GridRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTextblockbadgename_Internalname,lblTextblockbadgename_Caption,"","",lblTextblockbadgename_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","BadgeName",Integer.valueOf(0),lblTextblockbadgename_Tooltiptext,Integer.valueOf(lblTextblockbadgename_Visible),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "img_legajo", ""),"gx-form-item avatarLegajoLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Static Bitmap Variable */
         ClassString = edtavImg_legajo_Class + " " + ((GXutil.strcmp(edtavImg_legajo_gximage, "")==0) ? "" : "GX_Image_"+edtavImg_legajo_gximage+"_Class") ;
         StyleString = "" ;
         AV37img_legajo_IsBlob = (boolean)(((GXutil.strcmp("", AV37img_legajo)==0)&&(GXutil.strcmp("", AV103Img_legajo_GXI)==0))||!(GXutil.strcmp("", AV37img_legajo)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV37img_legajo)==0) ? AV103Img_legajo_GXI : httpContext.getResourceRelative(AV37img_legajo)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavImg_legajo_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtavImg_legajo_Visible),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV37img_legajo_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTablelegajosplit_Internalname+"_"+sGXsfl_41_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Section","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtLegNomApe_Internalname,httpContext.getMessage( "Leg Nom Ape", ""),"gx-form-item AttributeTitleSplitScreen,Label tituloSplitScreenLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Single line edit */
         ROClassString = "AttributeTitleSplitScreen, tituloSplitScreen" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNomApe_Internalname,A591LegNomApe,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegNomApe_Jsonclick,Integer.valueOf(0),"AttributeTitleSplitScreen, tituloSplitScreen","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCatdescrip_Internalname,httpContext.getMessage( "Cat Descrip", ""),"gx-form-item SubtituloSplitScreenLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Multiple line edit */
         ClassString = "SubtituloSplitScreen" ;
         StyleString = "" ;
         ClassString = "SubtituloSplitScreen" ;
         StyleString = "" ;
         GridRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCatdescrip_Internalname,AV15CatDescrip,"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavCatdescrip_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(5),"row",Integer.valueOf(0),StyleString,ClassString,"","","400",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         send_integrity_lvl_hashesJU2( ) ;
         /* End of Columns property logic. */
         GridContainer.AddRow(GridRow);
         nGXsfl_41_idx = ((subGrid_Islastpage==1)&&(nGXsfl_41_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_41_idx+1) ;
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_412( ) ;
      }
      /* End function sendrow_412 */
   }

   public void startgridcontrol41( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"41\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "FSGridAutoUnselectAll", 0, "", "", 1, 2, sStyleString, "", "", 0);
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            GridContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            GridContainer.Clear();
         }
         GridContainer.SetIsFreestyle(true);
         GridContainer.SetWrapped(nGXWrapped);
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", GXutil.rtrim( "FSGridAutoUnselectAll"));
         GridContainer.AddObjectProperty("Class", "FSGridAutoUnselectAll");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(13), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCUIL_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtEmpCod_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegNumero_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", lblTextblockbadgename_Caption);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", httpContext.convertURL( AV37img_legajo));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavImg_legajo_Class));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavImg_legajo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A591LegNomApe);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV15CatDescrip);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCatdescrip_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblVolversvg_Internalname = "VOLVERSVG" ;
      divTablevolversvgleg_Internalname = "TABLEVOLVERSVGLEG" ;
      lblHtmlhormiga_Internalname = "HTMLHORMIGA" ;
      lblPgmdesc_Internalname = "PGMDESC" ;
      divTablevolver_pgmname_Internalname = "TABLEVOLVER_PGMNAME" ;
      lblCouttext_Internalname = "COUTTEXT" ;
      divTabletotal_Internalname = "TABLETOTAL" ;
      divTableactions_Internalname = "TABLEACTIONS" ;
      bttBtnagregar_Internalname = "BTNAGREGAR" ;
      edtavFilterfulltext_Internalname = "vFILTERFULLTEXT" ;
      lblTextblockbadgefiltersplitscreen_Internalname = "TEXTBLOCKBADGEFILTERSPLITSCREEN" ;
      lblTextblockfiltros_Internalname = "TEXTBLOCKFILTROS" ;
      tblTablebuttonfiltros_Internalname = "TABLEBUTTONFILTROS" ;
      divTablesearchlegajo_Internalname = "TABLESEARCHLEGAJO" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtLegCUIL_Internalname = "LEGCUIL" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      tblUnnamedtablecontentfsgrid_Internalname = "UNNAMEDTABLECONTENTFSGRID" ;
      lblTextblockbadgename_Internalname = "TEXTBLOCKBADGENAME" ;
      edtavImg_legajo_Internalname = "vIMG_LEGAJO" ;
      divTableimagelegajo_Internalname = "TABLEIMAGELEGAJO" ;
      edtLegNomApe_Internalname = "LEGNOMAPE" ;
      edtavCatdescrip_Internalname = "vCATDESCRIP" ;
      divTablelegajosplit_Internalname = "TABLELEGAJOSPLIT" ;
      divFsgridtablerow_Internalname = "FSGRIDTABLEROW" ;
      divSplitleft_Internalname = "SPLITLEFT" ;
      divSplitright_Internalname = "SPLITRIGHT" ;
      lblTextblock1_Internalname = "TEXTBLOCK1" ;
      divSplitparent_Internalname = "SPLITPARENT" ;
      edtavLegsexo_Internalname = "vLEGSEXO" ;
      edtavLegclase_Internalname = "vLEGCLASE" ;
      cmbavLegtipotarifa.setInternalname( "vLEGTIPOTARIFA" );
      cmbavLegmodtra.setInternalname( "vLEGMODTRA" );
      cmbavConveniofiltro.setInternalname( "vCONVENIOFILTRO" );
      Combo_legsincod_Internalname = "COMBO_LEGSINCOD" ;
      Combo_legconvecodigo_Internalname = "COMBO_LEGCONVECODIGO" ;
      Combo_legcatcodigo_Internalname = "COMBO_LEGCATCODIGO" ;
      edtavLegfecingreso_Internalname = "vLEGFECINGRESO" ;
      edtavLegfecegreso_Internalname = "vLEGFECEGRESO" ;
      Combo_legseccodigo_Internalname = "COMBO_LEGSECCODIGO" ;
      Combo_legpuescodigo_Internalname = "COMBO_LEGPUESCODIGO" ;
      edtavLegactcodigo_Internalname = "vLEGACTCODIGO" ;
      edtavMprcod_Internalname = "vMPRCOD" ;
      edtavZoncod_Internalname = "vZONCOD" ;
      edtavLegsuccodigo_Internalname = "vLEGSUCCODIGO" ;
      cmbavLegestado.setInternalname( "vLEGESTADO" );
      chkavLegincompleto.setInternalname( "vLEGINCOMPLETO" );
      tblTblfiltrosinvisibles_Internalname = "TBLFILTROSINVISIBLES" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
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
      subGrid_Allowcollapsing = (byte)(0) ;
      lblTextblockbadgename_Caption = httpContext.getMessage( "LO", "") ;
      edtavCatdescrip_Enabled = 0 ;
      edtLegNomApe_Jsonclick = "" ;
      edtavImg_legajo_gximage = "" ;
      edtavImg_legajo_Class = "avatarLegajo" ;
      edtavImg_legajo_Visible = 1 ;
      lblTextblockbadgename_Tooltiptext = "" ;
      lblTextblockbadgename_Caption = httpContext.getMessage( "LO", "") ;
      lblTextblockbadgename_Visible = 1 ;
      edtLegNumero_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtLegCUIL_Jsonclick = "" ;
      subGrid_Class = "FSGridAutoUnselectAll" ;
      lblTextblockbadgefiltersplitscreen_Visible = 1 ;
      chkavLegincompleto.setEnabled( 1 );
      cmbavLegestado.setJsonclick( "" );
      cmbavLegestado.setEnabled( 1 );
      edtavLegsuccodigo_Jsonclick = "" ;
      edtavLegsuccodigo_Enabled = 1 ;
      edtavZoncod_Jsonclick = "" ;
      edtavZoncod_Enabled = 1 ;
      edtavMprcod_Jsonclick = "" ;
      edtavMprcod_Enabled = 1 ;
      edtavLegactcodigo_Jsonclick = "" ;
      edtavLegactcodigo_Enabled = 1 ;
      Combo_legpuescodigo_Caption = "" ;
      Combo_legseccodigo_Caption = "" ;
      edtavLegfecegreso_Jsonclick = "" ;
      edtavLegfecegreso_Enabled = 1 ;
      edtavLegfecingreso_Jsonclick = "" ;
      edtavLegfecingreso_Enabled = 1 ;
      Combo_legcatcodigo_Caption = "" ;
      Combo_legconvecodigo_Caption = "" ;
      Combo_legsincod_Caption = "" ;
      cmbavConveniofiltro.setJsonclick( "" );
      cmbavConveniofiltro.setEnabled( 1 );
      cmbavLegmodtra.setJsonclick( "" );
      cmbavLegmodtra.setEnabled( 1 );
      cmbavLegtipotarifa.setJsonclick( "" );
      cmbavLegtipotarifa.setEnabled( 1 );
      edtavLegclase_Jsonclick = "" ;
      edtavLegclase_Enabled = 1 ;
      edtavLegsexo_Jsonclick = "" ;
      edtavLegsexo_Enabled = 1 ;
      tblTblfiltrosinvisibles_Visible = 1 ;
      lblTextblockfiltros_Tooltiptext = "" ;
      lblTextblockbadgefiltersplitscreen_Tooltiptext = "" ;
      lblTextblockbadgefiltersplitscreen_Caption = "3" ;
      lblTextblockfiltros_Caption = httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      lblCouttext_Caption = "100" ;
      Combo_legpuescodigo_Multiplevaluestype = "Tags" ;
      Combo_legpuescodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legpuescodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_legpuescodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_legpuescodigo_Cls = "ExtendedCombo AttributeSearchSplitScreen" ;
      Combo_legseccodigo_Multiplevaluestype = "Tags" ;
      Combo_legseccodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legseccodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_legseccodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_legseccodigo_Cls = "ExtendedCombo AttributeSearchSplitScreen" ;
      Combo_legcatcodigo_Multiplevaluestype = "Tags" ;
      Combo_legcatcodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_legcatcodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_legcatcodigo_Cls = "ExtendedCombo AttributeSearchSplitScreen" ;
      Combo_legconvecodigo_Multiplevaluestype = "Tags" ;
      Combo_legconvecodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legconvecodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_legconvecodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_legconvecodigo_Cls = "ExtendedCombo AttributeSearchSplitScreen" ;
      Combo_legsincod_Multiplevaluestype = "Tags" ;
      Combo_legsincod_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_legsincod_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_legsincod_Cls = "ExtendedCombo AttributeSearchSplitScreen" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( " Legajos", "") );
      edtLegNumero_Visible = 1 ;
      edtEmpCod_Visible = 1 ;
      edtLegCUIL_Visible = 1 ;
      subGrid_Rows = 50 ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavLegtipotarifa.setName( "vLEGTIPOTARIFA" );
      cmbavLegtipotarifa.setWebtags( "" );
      cmbavLegtipotarifa.addItem("", httpContext.getMessage( "WWP_AllInCombo", ""), (short)(0));
      cmbavLegtipotarifa.addItem("H", httpContext.getMessage( "Por hora trabajada", ""), (short)(0));
      cmbavLegtipotarifa.addItem("P", httpContext.getMessage( "Por periodo trabajado", ""), (short)(0));
      if ( cmbavLegtipotarifa.getItemCount() > 0 )
      {
         AV80LegTipoTarifa = cmbavLegtipotarifa.getValidValue(AV80LegTipoTarifa) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV80LegTipoTarifa", AV80LegTipoTarifa);
      }
      cmbavLegmodtra.setName( "vLEGMODTRA" );
      cmbavLegmodtra.setWebtags( "" );
      cmbavLegmodtra.addItem("", httpContext.getMessage( "WWP_AllInCombo", ""), (short)(0));
      cmbavLegmodtra.addItem("E", httpContext.getMessage( "Empleado", ""), (short)(0));
      cmbavLegmodtra.addItem("I", httpContext.getMessage( "Independiente", ""), (short)(0));
      if ( cmbavLegmodtra.getItemCount() > 0 )
      {
         AV79LegModTra = cmbavLegmodtra.getValidValue(AV79LegModTra) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV79LegModTra", AV79LegModTra);
      }
      cmbavConveniofiltro.setName( "vCONVENIOFILTRO" );
      cmbavConveniofiltro.setWebtags( "" );
      cmbavConveniofiltro.addItem("Todos", httpContext.getMessage( "Todos", ""), (short)(0));
      cmbavConveniofiltro.addItem("Fuera", httpContext.getMessage( "Solo fuera de convenio", ""), (short)(0));
      cmbavConveniofiltro.addItem("EnConvenio", httpContext.getMessage( "En convenio", ""), (short)(0));
      if ( cmbavConveniofiltro.getItemCount() > 0 )
      {
         AV46ConvenioFiltro = cmbavConveniofiltro.getValidValue(AV46ConvenioFiltro) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46ConvenioFiltro", AV46ConvenioFiltro);
      }
      cmbavLegestado.setName( "vLEGESTADO" );
      cmbavLegestado.setWebtags( "" );
      cmbavLegestado.addItem("1", httpContext.getMessage( "Activo", ""), (short)(0));
      cmbavLegestado.addItem("2", httpContext.getMessage( "Baja", ""), (short)(0));
      if ( cmbavLegestado.getItemCount() > 0 )
      {
         AV76LegEstado = (byte)(GXutil.lval( cmbavLegestado.getValidValue(GXutil.trim( GXutil.str( AV76LegEstado, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76LegEstado", GXutil.str( AV76LegEstado, 1, 0));
      }
      chkavLegincompleto.setName( "vLEGINCOMPLETO" );
      chkavLegincompleto.setWebtags( "" );
      chkavLegincompleto.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavLegincompleto.getInternalname(), "TitleCaption", chkavLegincompleto.getCaption(), true);
      chkavLegincompleto.setCheckedValue( "false" );
      AV77LegIncompleto = GXutil.strtobool( GXutil.booltostr( AV77LegIncompleto)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77LegIncompleto", AV77LegIncompleto);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtEmpCod_Visible',ctrl:'EMPCOD',prop:'Visible'},{av:'edtLegNumero_Visible',ctrl:'LEGNUMERO',prop:'Visible'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''},{av:'AV83Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV20SelectedCliCod',fld:'vSELECTEDCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21SelectedEmpCod',fld:'vSELECTEDEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV23SelectedLegNumero',fld:'vSELECTEDLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV38MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV74modoPalabra',fld:'vMODOPALABRA',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'lblTextblockbadgefiltersplitscreen_Caption',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Caption'},{av:'lblTextblockbadgefiltersplitscreen_Visible',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Visible'},{av:'lblTextblockbadgefiltersplitscreen_Tooltiptext',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Tooltiptext'},{av:'lblTextblockfiltros_Tooltiptext',ctrl:'TEXTBLOCKFILTROS',prop:'Tooltiptext'},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'Combo_legsincod_Selectedvalue_set',ctrl:'COMBO_LEGSINCOD',prop:'SelectedValue_set'},{av:'Combo_legconvecodigo_Selectedvalue_set',ctrl:'COMBO_LEGCONVECODIGO',prop:'SelectedValue_set'},{av:'Combo_legcatcodigo_Selectedvalue_set',ctrl:'COMBO_LEGCATCODIGO',prop:'SelectedValue_set'},{av:'Combo_legseccodigo_Selectedvalue_set',ctrl:'COMBO_LEGSECCODIGO',prop:'SelectedValue_set'},{av:'Combo_legpuescodigo_Selectedvalue_set',ctrl:'COMBO_LEGPUESCODIGO',prop:'SelectedValue_set'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e18JU2',iparms:[{av:'AV83Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'A1030LegFotoNom',fld:'LEGFOTONOM',pic:''},{av:'A251LegNombre',fld:'LEGNOMBRE',pic:''},{av:'A230LegApellido',fld:'LEGAPELLIDO',pic:''},{av:'A235LegClase',fld:'LEGCLASE',pic:'9'},{av:'A939LegCatCodigo',fld:'LEGCATCODIGO',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'A2267LegIncompleto',fld:'LEGINCOMPLETO',pic:''},{av:'A2263LegMigrWarn',fld:'LEGMIGRWARN',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'lblTextblockbadgename_Caption',ctrl:'TEXTBLOCKBADGENAME',prop:'Caption'},{av:'AV37img_legajo',fld:'vIMG_LEGAJO',pic:''},{av:'edtavImg_legajo_Visible',ctrl:'vIMG_LEGAJO',prop:'Visible'},{av:'lblTextblockbadgename_Visible',ctrl:'TEXTBLOCKBADGENAME',prop:'Visible'},{av:'edtavImg_legajo_Class',ctrl:'vIMG_LEGAJO',prop:'Class'},{av:'AV15CatDescrip',fld:'vCATDESCRIP',pic:''},{av:'lblTextblockbadgename_Tooltiptext',ctrl:'TEXTBLOCKBADGENAME',prop:'Tooltiptext'}]}");
      setEventMetadata("FSGRIDTABLEROW.CLICK","{handler:'e15JU2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV24DetailWCHistory',fld:'vDETAILWCHISTORY',pic:''}]");
      setEventMetadata("FSGRIDTABLEROW.CLICK",",oparms:[{av:'AV30DetailWCInfo',fld:'vDETAILWCINFO',pic:''},{av:'AV24DetailWCHistory',fld:'vDETAILWCHISTORY',pic:''},{ctrl:'DETAILWC'}]}");
      setEventMetadata("GLOBALEVENTS.SPLITSCREEN_LOADDETAIL","{handler:'e11JU2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''},{av:'AV83Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtEmpCod_Visible',ctrl:'EMPCOD',prop:'Visible'},{av:'edtLegNumero_Visible',ctrl:'LEGNUMERO',prop:'Visible'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV20SelectedCliCod',fld:'vSELECTEDCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21SelectedEmpCod',fld:'vSELECTEDEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV23SelectedLegNumero',fld:'vSELECTEDLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV38MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV74modoPalabra',fld:'vMODOPALABRA',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25DetailTableName',fld:'vDETAILTABLENAME',pic:''},{av:'AV31RefreshGrid',fld:'vREFRESHGRID',pic:''},{av:'AV30DetailWCInfo',fld:'vDETAILWCINFO',pic:''},{av:'AV26LoadDetailAction',fld:'vLOADDETAILACTION',pic:'9'},{av:'AV24DetailWCHistory',fld:'vDETAILWCHISTORY',pic:''}]");
      setEventMetadata("GLOBALEVENTS.SPLITSCREEN_LOADDETAIL",",oparms:[{av:'AV26LoadDetailAction',fld:'vLOADDETAILACTION',pic:'9'},{av:'AV24DetailWCHistory',fld:'vDETAILWCHISTORY',pic:''},{av:'AV30DetailWCInfo',fld:'vDETAILWCINFO',pic:''},{ctrl:'DETAILWC'},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'lblTextblockbadgefiltersplitscreen_Caption',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Caption'},{av:'lblTextblockbadgefiltersplitscreen_Visible',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Visible'},{av:'lblTextblockbadgefiltersplitscreen_Tooltiptext',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Tooltiptext'},{av:'lblTextblockfiltros_Tooltiptext',ctrl:'TEXTBLOCKFILTROS',prop:'Tooltiptext'},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'Combo_legsincod_Selectedvalue_set',ctrl:'COMBO_LEGSINCOD',prop:'SelectedValue_set'},{av:'Combo_legconvecodigo_Selectedvalue_set',ctrl:'COMBO_LEGCONVECODIGO',prop:'SelectedValue_set'},{av:'Combo_legcatcodigo_Selectedvalue_set',ctrl:'COMBO_LEGCATCODIGO',prop:'SelectedValue_set'},{av:'Combo_legseccodigo_Selectedvalue_set',ctrl:'COMBO_LEGSECCODIGO',prop:'SelectedValue_set'},{av:'Combo_legpuescodigo_Selectedvalue_set',ctrl:'COMBO_LEGPUESCODIGO',prop:'SelectedValue_set'}]}");
      setEventMetadata("'DOAGREGAR'","{handler:'e14JU2',iparms:[{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("'DOAGREGAR'",",oparms:[{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("TEXTBLOCKFILTROS.CLICK","{handler:'e12JU2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''},{av:'AV83Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtEmpCod_Visible',ctrl:'EMPCOD',prop:'Visible'},{av:'edtLegNumero_Visible',ctrl:'LEGNUMERO',prop:'Visible'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV20SelectedCliCod',fld:'vSELECTEDCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21SelectedEmpCod',fld:'vSELECTEDEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV23SelectedLegNumero',fld:'vSELECTEDLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV38MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV74modoPalabra',fld:'vMODOPALABRA',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("TEXTBLOCKFILTROS.CLICK",",oparms:[{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'lblTextblockbadgefiltersplitscreen_Caption',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Caption'},{av:'lblTextblockbadgefiltersplitscreen_Visible',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Visible'},{av:'lblTextblockbadgefiltersplitscreen_Tooltiptext',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Tooltiptext'},{av:'lblTextblockfiltros_Tooltiptext',ctrl:'TEXTBLOCKFILTROS',prop:'Tooltiptext'},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'Combo_legsincod_Selectedvalue_set',ctrl:'COMBO_LEGSINCOD',prop:'SelectedValue_set'},{av:'Combo_legconvecodigo_Selectedvalue_set',ctrl:'COMBO_LEGCONVECODIGO',prop:'SelectedValue_set'},{av:'Combo_legcatcodigo_Selectedvalue_set',ctrl:'COMBO_LEGCATCODIGO',prop:'SelectedValue_set'},{av:'Combo_legseccodigo_Selectedvalue_set',ctrl:'COMBO_LEGSECCODIGO',prop:'SelectedValue_set'},{av:'Combo_legpuescodigo_Selectedvalue_set',ctrl:'COMBO_LEGPUESCODIGO',prop:'SelectedValue_set'}]}");
      setEventMetadata("VOLVERSVG.CLICK","{handler:'e13JU2',iparms:[]");
      setEventMetadata("VOLVERSVG.CLICK",",oparms:[]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtEmpCod_Visible',ctrl:'EMPCOD',prop:'Visible'},{av:'edtLegNumero_Visible',ctrl:'LEGNUMERO',prop:'Visible'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV20SelectedCliCod',fld:'vSELECTEDCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21SelectedEmpCod',fld:'vSELECTEDEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV23SelectedLegNumero',fld:'vSELECTEDLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV38MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV74modoPalabra',fld:'vMODOPALABRA',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV83Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'lblTextblockbadgefiltersplitscreen_Caption',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Caption'},{av:'lblTextblockbadgefiltersplitscreen_Visible',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Visible'},{av:'lblTextblockbadgefiltersplitscreen_Tooltiptext',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Tooltiptext'},{av:'lblTextblockfiltros_Tooltiptext',ctrl:'TEXTBLOCKFILTROS',prop:'Tooltiptext'},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'Combo_legsincod_Selectedvalue_set',ctrl:'COMBO_LEGSINCOD',prop:'SelectedValue_set'},{av:'Combo_legconvecodigo_Selectedvalue_set',ctrl:'COMBO_LEGCONVECODIGO',prop:'SelectedValue_set'},{av:'Combo_legcatcodigo_Selectedvalue_set',ctrl:'COMBO_LEGCATCODIGO',prop:'SelectedValue_set'},{av:'Combo_legseccodigo_Selectedvalue_set',ctrl:'COMBO_LEGSECCODIGO',prop:'SelectedValue_set'},{av:'Combo_legpuescodigo_Selectedvalue_set',ctrl:'COMBO_LEGPUESCODIGO',prop:'SelectedValue_set'}]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtEmpCod_Visible',ctrl:'EMPCOD',prop:'Visible'},{av:'edtLegNumero_Visible',ctrl:'LEGNUMERO',prop:'Visible'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV20SelectedCliCod',fld:'vSELECTEDCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21SelectedEmpCod',fld:'vSELECTEDEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV23SelectedLegNumero',fld:'vSELECTEDLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV38MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV74modoPalabra',fld:'vMODOPALABRA',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV83Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'lblTextblockbadgefiltersplitscreen_Caption',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Caption'},{av:'lblTextblockbadgefiltersplitscreen_Visible',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Visible'},{av:'lblTextblockbadgefiltersplitscreen_Tooltiptext',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Tooltiptext'},{av:'lblTextblockfiltros_Tooltiptext',ctrl:'TEXTBLOCKFILTROS',prop:'Tooltiptext'},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'Combo_legsincod_Selectedvalue_set',ctrl:'COMBO_LEGSINCOD',prop:'SelectedValue_set'},{av:'Combo_legconvecodigo_Selectedvalue_set',ctrl:'COMBO_LEGCONVECODIGO',prop:'SelectedValue_set'},{av:'Combo_legcatcodigo_Selectedvalue_set',ctrl:'COMBO_LEGCATCODIGO',prop:'SelectedValue_set'},{av:'Combo_legseccodigo_Selectedvalue_set',ctrl:'COMBO_LEGSECCODIGO',prop:'SelectedValue_set'},{av:'Combo_legpuescodigo_Selectedvalue_set',ctrl:'COMBO_LEGPUESCODIGO',prop:'SelectedValue_set'}]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtEmpCod_Visible',ctrl:'EMPCOD',prop:'Visible'},{av:'edtLegNumero_Visible',ctrl:'LEGNUMERO',prop:'Visible'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV20SelectedCliCod',fld:'vSELECTEDCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21SelectedEmpCod',fld:'vSELECTEDEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV23SelectedLegNumero',fld:'vSELECTEDLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV38MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV74modoPalabra',fld:'vMODOPALABRA',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV83Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'lblTextblockbadgefiltersplitscreen_Caption',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Caption'},{av:'lblTextblockbadgefiltersplitscreen_Visible',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Visible'},{av:'lblTextblockbadgefiltersplitscreen_Tooltiptext',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Tooltiptext'},{av:'lblTextblockfiltros_Tooltiptext',ctrl:'TEXTBLOCKFILTROS',prop:'Tooltiptext'},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'Combo_legsincod_Selectedvalue_set',ctrl:'COMBO_LEGSINCOD',prop:'SelectedValue_set'},{av:'Combo_legconvecodigo_Selectedvalue_set',ctrl:'COMBO_LEGCONVECODIGO',prop:'SelectedValue_set'},{av:'Combo_legcatcodigo_Selectedvalue_set',ctrl:'COMBO_LEGCATCODIGO',prop:'SelectedValue_set'},{av:'Combo_legseccodigo_Selectedvalue_set',ctrl:'COMBO_LEGSECCODIGO',prop:'SelectedValue_set'},{av:'Combo_legpuescodigo_Selectedvalue_set',ctrl:'COMBO_LEGPUESCODIGO',prop:'SelectedValue_set'}]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtEmpCod_Visible',ctrl:'EMPCOD',prop:'Visible'},{av:'edtLegNumero_Visible',ctrl:'LEGNUMERO',prop:'Visible'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV20SelectedCliCod',fld:'vSELECTEDCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21SelectedEmpCod',fld:'vSELECTEDEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV23SelectedLegNumero',fld:'vSELECTEDLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV38MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV74modoPalabra',fld:'vMODOPALABRA',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV83Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''}]");
      setEventMetadata("GRID_LASTPAGE",",oparms:[{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'AV62LegSexo',fld:'vLEGSEXO',pic:'Z9'},{av:'AV52LegClase',fld:'vLEGCLASE',pic:'ZZZ9'},{av:'cmbavLegmodtra'},{av:'AV79LegModTra',fld:'vLEGMODTRA',pic:''},{av:'cmbavLegtipotarifa'},{av:'AV80LegTipoTarifa',fld:'vLEGTIPOTARIFA',pic:''},{av:'cmbavConveniofiltro'},{av:'AV46ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV64LegSinCod',fld:'vLEGSINCOD',pic:''},{av:'AV53LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV50LegCatCodigo',fld:'vLEGCATCODIGO',pic:''},{av:'AV56LegFecIngreso',fld:'vLEGFECINGRESO',pic:''},{av:'AV55LegFecEgreso',fld:'vLEGFECEGRESO',pic:''},{av:'AV60LegSecCodigo',fld:'vLEGSECCODIGO',pic:''},{av:'AV58LegPuesCodigo',fld:'vLEGPUESCODIGO',pic:''},{av:'AV49LegActCodigo',fld:'vLEGACTCODIGO',pic:''},{av:'AV67MprCod',fld:'vMPRCOD',pic:''},{av:'AV71ZonCod',fld:'vZONCOD',pic:''},{av:'AV66LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'cmbavLegestado'},{av:'AV76LegEstado',fld:'vLEGESTADO',pic:'9'},{av:'AV77LegIncompleto',fld:'vLEGINCOMPLETO',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:'',hsh:true},{av:'AV14FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'lblTextblockbadgefiltersplitscreen_Caption',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Caption'},{av:'lblTextblockbadgefiltersplitscreen_Visible',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Visible'},{av:'lblTextblockbadgefiltersplitscreen_Tooltiptext',ctrl:'TEXTBLOCKBADGEFILTERSPLITSCREEN',prop:'Tooltiptext'},{av:'lblTextblockfiltros_Tooltiptext',ctrl:'TEXTBLOCKFILTROS',prop:'Tooltiptext'},{av:'AV65LegSinCod_Data',fld:'vLEGSINCOD_DATA',pic:''},{av:'AV54LegConveCodigo_Data',fld:'vLEGCONVECODIGO_DATA',pic:''},{av:'AV51LegCatCodigo_Data',fld:'vLEGCATCODIGO_DATA',pic:''},{av:'AV61LegSecCodigo_Data',fld:'vLEGSECCODIGO_DATA',pic:''},{av:'AV59LegPuesCodigo_Data',fld:'vLEGPUESCODIGO_DATA',pic:''},{av:'Combo_legsincod_Selectedvalue_set',ctrl:'COMBO_LEGSINCOD',prop:'SelectedValue_set'},{av:'Combo_legconvecodigo_Selectedvalue_set',ctrl:'COMBO_LEGCONVECODIGO',prop:'SelectedValue_set'},{av:'Combo_legcatcodigo_Selectedvalue_set',ctrl:'COMBO_LEGCATCODIGO',prop:'SelectedValue_set'},{av:'Combo_legseccodigo_Selectedvalue_set',ctrl:'COMBO_LEGSECCODIGO',prop:'SelectedValue_set'},{av:'Combo_legpuescodigo_Selectedvalue_set',ctrl:'COMBO_LEGPUESCODIGO',prop:'SelectedValue_set'}]}");
      setEventMetadata("VALIDV_LEGTIPOTARIFA","{handler:'validv_Legtipotarifa',iparms:[]");
      setEventMetadata("VALIDV_LEGTIPOTARIFA",",oparms:[]}");
      setEventMetadata("VALIDV_LEGMODTRA","{handler:'validv_Legmodtra',iparms:[]");
      setEventMetadata("VALIDV_LEGMODTRA",",oparms:[]}");
      setEventMetadata("VALIDV_CONVENIOFILTRO","{handler:'validv_Conveniofiltro',iparms:[]");
      setEventMetadata("VALIDV_CONVENIOFILTRO",",oparms:[]}");
      setEventMetadata("VALIDV_LEGESTADO","{handler:'validv_Legestado',iparms:[]");
      setEventMetadata("VALIDV_LEGESTADO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Catdescrip',iparms:[]");
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
      wcpOAV38MenuOpcCod = "" ;
      wcpOAV74modoPalabra = "" ;
      Combo_legpuescodigo_Selectedvalue_get = "" ;
      Combo_legseccodigo_Selectedvalue_get = "" ;
      Combo_legcatcodigo_Selectedvalue_get = "" ;
      Combo_legconvecodigo_Selectedvalue_get = "" ;
      Combo_legsincod_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV38MenuOpcCod = "" ;
      AV74modoPalabra = "" ;
      AV14FilterFullText = "" ;
      AV80LegTipoTarifa = "" ;
      AV79LegModTra = "" ;
      AV46ConvenioFiltro = "" ;
      AV56LegFecIngreso = GXutil.nullDate() ;
      AV55LegFecEgreso = GXutil.nullDate() ;
      AV49LegActCodigo = "" ;
      AV67MprCod = "" ;
      AV71ZonCod = "" ;
      AV66LegSucCodigo = "" ;
      AV83Pgmname = "" ;
      AV64LegSinCod = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53LegConveCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50LegCatCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60LegSecCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58LegPuesCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV65LegSinCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV54LegConveCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV51LegCatCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV61LegSecCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV59LegPuesCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV47DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      A1030LegFotoNom = "" ;
      A251LegNombre = "" ;
      A230LegApellido = "" ;
      A939LegCatCodigo = "" ;
      A937LegConveCodigo = "" ;
      A2263LegMigrWarn = "" ;
      AV24DetailWCHistory = new GXBaseCollection<web.wwpbaseobjects.SdtSplitScreenDetailInfo>(web.wwpbaseobjects.SdtSplitScreenDetailInfo.class, "SplitScreenDetailInfo", "PayDay", remoteHandle);
      AV25DetailTableName = "" ;
      AV30DetailWCInfo = new web.wwpbaseobjects.SdtSplitScreenDetailInfo(remoteHandle, context);
      Combo_legsincod_Selectedvalue_set = "" ;
      Combo_legconvecodigo_Selectedvalue_set = "" ;
      Combo_legcatcodigo_Selectedvalue_set = "" ;
      Combo_legseccodigo_Selectedvalue_set = "" ;
      Combo_legpuescodigo_Selectedvalue_set = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblVolversvg_Jsonclick = "" ;
      lblHtmlhormiga_Jsonclick = "" ;
      lblPgmdesc_Jsonclick = "" ;
      lblCouttext_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnagregar_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      WebComp_Detailwc_Component = "" ;
      OldDetailwc = "" ;
      lblTextblock1_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV84Legajoswwds_1_filterfulltext = "" ;
      AV87Legajoswwds_4_legtipotarifa = "" ;
      AV88Legajoswwds_5_legmodtra = "" ;
      AV89Legajoswwds_6_conveniofiltro = "" ;
      AV90Legajoswwds_7_legsincod = new GXSimpleCollection<String>(String.class, "internal", "");
      AV91Legajoswwds_8_legconvecodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV92Legajoswwds_9_legcatcodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV93Legajoswwds_10_legfecingreso = GXutil.nullDate() ;
      AV94Legajoswwds_11_legfecegreso = GXutil.nullDate() ;
      AV95Legajoswwds_12_legseccodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV96Legajoswwds_13_legpuescodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV97Legajoswwds_14_legactcodigo = "" ;
      AV98Legajoswwds_15_mprcod = "" ;
      AV99Legajoswwds_16_zoncod = "" ;
      AV100Legajoswwds_17_legsuccodigo = "" ;
      AV37img_legajo = "" ;
      AV103Img_legajo_GXI = "" ;
      A591LegNomApe = "" ;
      AV15CatDescrip = "" ;
      GXCCtl = "" ;
      scmdbuf = "" ;
      lV84Legajoswwds_1_filterfulltext = "" ;
      lV97Legajoswwds_14_legactcodigo = "" ;
      lV98Legajoswwds_15_mprcod = "" ;
      lV99Legajoswwds_16_zoncod = "" ;
      lV100Legajoswwds_17_legsuccodigo = "" ;
      A910LegSinCod = "" ;
      A1579LegSecCodigo = "" ;
      A1578LegPuesCodigo = "" ;
      A93LegId = "" ;
      A2417LegTipoTarifa = "" ;
      A2404LegModTra = "" ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A244LegFecEgreso = GXutil.nullDate() ;
      A15LegActCodigo = "" ;
      A18MprCod = "" ;
      A20ZonCod = "" ;
      A1577LegSucCodigo = "" ;
      H00JU2_A3CliCod = new int[1] ;
      H00JU2_A1EmpCod = new short[1] ;
      H00JU2_A1577LegSucCodigo = new String[] {""} ;
      H00JU2_n1577LegSucCodigo = new boolean[] {false} ;
      H00JU2_A20ZonCod = new String[] {""} ;
      H00JU2_n20ZonCod = new boolean[] {false} ;
      H00JU2_A18MprCod = new String[] {""} ;
      H00JU2_n18MprCod = new boolean[] {false} ;
      H00JU2_A15LegActCodigo = new String[] {""} ;
      H00JU2_n15LegActCodigo = new boolean[] {false} ;
      H00JU2_A93LegId = new String[] {""} ;
      H00JU2_n93LegId = new boolean[] {false} ;
      H00JU2_A1818LegEstado = new byte[1] ;
      H00JU2_A1578LegPuesCodigo = new String[] {""} ;
      H00JU2_n1578LegPuesCodigo = new boolean[] {false} ;
      H00JU2_A1579LegSecCodigo = new String[] {""} ;
      H00JU2_n1579LegSecCodigo = new boolean[] {false} ;
      H00JU2_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      H00JU2_n244LegFecEgreso = new boolean[] {false} ;
      H00JU2_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      H00JU2_A910LegSinCod = new String[] {""} ;
      H00JU2_n910LegSinCod = new boolean[] {false} ;
      H00JU2_A2404LegModTra = new String[] {""} ;
      H00JU2_A2417LegTipoTarifa = new String[] {""} ;
      H00JU2_A263LegSexo = new byte[1] ;
      H00JU2_n263LegSexo = new boolean[] {false} ;
      H00JU2_A1030LegFotoNom = new String[] {""} ;
      H00JU2_A251LegNombre = new String[] {""} ;
      H00JU2_A230LegApellido = new String[] {""} ;
      H00JU2_A235LegClase = new byte[1] ;
      H00JU2_A939LegCatCodigo = new String[] {""} ;
      H00JU2_n939LegCatCodigo = new boolean[] {false} ;
      H00JU2_A937LegConveCodigo = new String[] {""} ;
      H00JU2_n937LegConveCodigo = new boolean[] {false} ;
      H00JU2_A2267LegIncompleto = new boolean[] {false} ;
      H00JU2_A2263LegMigrWarn = new String[] {""} ;
      H00JU2_n2263LegMigrWarn = new boolean[] {false} ;
      H00JU2_A591LegNomApe = new String[] {""} ;
      H00JU2_A6LegNumero = new int[1] ;
      H00JU2_A239LegCUIL = new long[1] ;
      H00JU3_AGRID_nRecordCount = new long[1] ;
      AV73filtrosSVGValor = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV34websession = httpContext.getWebSession();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV16Session = httpContext.getWebSession();
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext11 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV36urlFoto = "" ;
      AV78inicialesPalabra = "" ;
      GXv_int8 = new int[1] ;
      AV33AuxCatDescrip = "" ;
      GXt_char2 = "" ;
      AV40ConveDescri = "" ;
      GXv_boolean12 = new boolean[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV27DetailWCLink = "" ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_int6 = new short[1] ;
      AV48filtrosTexto = "" ;
      GXv_char4 = new String[1] ;
      GXv_objcol_SdtDVB_SDTComboData_Item14 = new GXBaseCollection[1] ;
      GXv_SdtWWPGridState13 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9HTTPRequest = httpContext.getHttpRequest();
      ucCombo_legpuescodigo = new com.genexus.webpanels.GXUserControl();
      ucCombo_legseccodigo = new com.genexus.webpanels.GXUserControl();
      ucCombo_legcatcodigo = new com.genexus.webpanels.GXUserControl();
      ucCombo_legconvecodigo = new com.genexus.webpanels.GXUserControl();
      ucCombo_legsincod = new com.genexus.webpanels.GXUserControl();
      AV70window = new com.genexus.webpanels.GXWindow();
      lblTextblockbadgefiltersplitscreen_Jsonclick = "" ;
      lblTextblockfiltros_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      lblTextblockbadgename_Jsonclick = "" ;
      sImgUrl = "" ;
      subGrid_Header = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajosww__default(),
         new Object[] {
             new Object[] {
            H00JU2_A3CliCod, H00JU2_A1EmpCod, H00JU2_A1577LegSucCodigo, H00JU2_n1577LegSucCodigo, H00JU2_A20ZonCod, H00JU2_n20ZonCod, H00JU2_A18MprCod, H00JU2_n18MprCod, H00JU2_A15LegActCodigo, H00JU2_n15LegActCodigo,
            H00JU2_A93LegId, H00JU2_n93LegId, H00JU2_A1818LegEstado, H00JU2_A1578LegPuesCodigo, H00JU2_n1578LegPuesCodigo, H00JU2_A1579LegSecCodigo, H00JU2_n1579LegSecCodigo, H00JU2_A244LegFecEgreso, H00JU2_n244LegFecEgreso, H00JU2_A245LegFecIngreso,
            H00JU2_A910LegSinCod, H00JU2_n910LegSinCod, H00JU2_A2404LegModTra, H00JU2_A2417LegTipoTarifa, H00JU2_A263LegSexo, H00JU2_n263LegSexo, H00JU2_A1030LegFotoNom, H00JU2_A251LegNombre, H00JU2_A230LegApellido, H00JU2_A235LegClase,
            H00JU2_A939LegCatCodigo, H00JU2_n939LegCatCodigo, H00JU2_A937LegConveCodigo, H00JU2_n937LegConveCodigo, H00JU2_A2267LegIncompleto, H00JU2_A2263LegMigrWarn, H00JU2_n2263LegMigrWarn, H00JU2_A591LegNomApe, H00JU2_A6LegNumero, H00JU2_A239LegCUIL
            }
            , new Object[] {
            H00JU3_AGRID_nRecordCount
            }
         }
      );
      AV83Pgmname = "LegajosWW" ;
      /* GeneXus formulas. */
      AV83Pgmname = "LegajosWW" ;
      Gx_err = (short)(0) ;
      edtavCatdescrip_Enabled = 0 ;
      WebComp_Detailwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV62LegSexo ;
   private byte AV76LegEstado ;
   private byte gxajaxcallmode ;
   private byte A235LegClase ;
   private byte AV26LoadDetailAction ;
   private byte AV85Legajoswwds_2_legsexo ;
   private byte AV101Legajoswwds_18_legestado ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte A263LegSexo ;
   private byte A1818LegEstado ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short wcpOAV21SelectedEmpCod ;
   private short AV21SelectedEmpCod ;
   private short AV52LegClase ;
   private short AV18EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short AV86Legajoswwds_3_legclase ;
   private short A1EmpCod ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV68PaiCod ;
   private short GXt_int5 ;
   private short AV41cantFiltros ;
   private short GXv_int6[] ;
   private int wcpOAV20SelectedCliCod ;
   private int wcpOAV23SelectedLegNumero ;
   private int edtLegCUIL_Visible ;
   private int edtEmpCod_Visible ;
   private int edtLegNumero_Visible ;
   private int nRC_GXsfl_41 ;
   private int subGrid_Rows ;
   private int AV20SelectedCliCod ;
   private int AV23SelectedLegNumero ;
   private int nGXsfl_41_idx=1 ;
   private int AV17CliCod ;
   private int A3CliCod ;
   private int edtavFilterfulltext_Enabled ;
   private int A6LegNumero ;
   private int subGrid_Islastpage ;
   private int edtavCatdescrip_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV90Legajoswwds_7_legsincod_size ;
   private int AV91Legajoswwds_8_legconvecodigo_size ;
   private int AV92Legajoswwds_9_legcatcodigo_size ;
   private int AV95Legajoswwds_12_legseccodigo_size ;
   private int AV96Legajoswwds_13_legpuescodigo_size ;
   private int GXt_int7 ;
   private int edtavImg_legajo_Visible ;
   private int lblTextblockbadgename_Visible ;
   private int AV32CliConveVer ;
   private int GXv_int8[] ;
   private int AV104GXV1 ;
   private int lblTextblockbadgefiltersplitscreen_Visible ;
   private int AV105GXV2 ;
   private int tblTblfiltrosinvisibles_Visible ;
   private int edtavLegsexo_Enabled ;
   private int edtavLegclase_Enabled ;
   private int edtavLegfecingreso_Enabled ;
   private int edtavLegfecegreso_Enabled ;
   private int edtavLegactcodigo_Enabled ;
   private int edtavMprcod_Enabled ;
   private int edtavZoncod_Enabled ;
   private int edtavLegsuccodigo_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long A239LegCUIL ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String wcpOAV74modoPalabra ;
   private String Combo_legpuescodigo_Selectedvalue_get ;
   private String Combo_legseccodigo_Selectedvalue_get ;
   private String Combo_legcatcodigo_Selectedvalue_get ;
   private String Combo_legconvecodigo_Selectedvalue_get ;
   private String Combo_legsincod_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV74modoPalabra ;
   private String sGXsfl_41_idx="0001" ;
   private String edtLegCUIL_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtLegNumero_Internalname ;
   private String AV80LegTipoTarifa ;
   private String AV79LegModTra ;
   private String AV46ConvenioFiltro ;
   private String AV49LegActCodigo ;
   private String AV67MprCod ;
   private String AV71ZonCod ;
   private String AV66LegSucCodigo ;
   private String AV83Pgmname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String A939LegCatCodigo ;
   private String A937LegConveCodigo ;
   private String Combo_legsincod_Cls ;
   private String Combo_legsincod_Selectedvalue_set ;
   private String Combo_legsincod_Multiplevaluestype ;
   private String Combo_legconvecodigo_Cls ;
   private String Combo_legconvecodigo_Selectedvalue_set ;
   private String Combo_legconvecodigo_Multiplevaluestype ;
   private String Combo_legcatcodigo_Cls ;
   private String Combo_legcatcodigo_Selectedvalue_set ;
   private String Combo_legcatcodigo_Multiplevaluestype ;
   private String Combo_legseccodigo_Cls ;
   private String Combo_legseccodigo_Selectedvalue_set ;
   private String Combo_legseccodigo_Multiplevaluestype ;
   private String Combo_legpuescodigo_Cls ;
   private String Combo_legpuescodigo_Selectedvalue_set ;
   private String Combo_legpuescodigo_Multiplevaluestype ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divSplitparent_Internalname ;
   private String divSplitleft_Internalname ;
   private String divTableheader_Internalname ;
   private String divTableactions_Internalname ;
   private String divTablevolversvgleg_Internalname ;
   private String lblVolversvg_Internalname ;
   private String lblVolversvg_Jsonclick ;
   private String divTablevolver_pgmname_Internalname ;
   private String lblHtmlhormiga_Internalname ;
   private String lblHtmlhormiga_Jsonclick ;
   private String lblPgmdesc_Internalname ;
   private String lblPgmdesc_Jsonclick ;
   private String divTabletotal_Internalname ;
   private String lblCouttext_Internalname ;
   private String lblCouttext_Caption ;
   private String lblCouttext_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnagregar_Internalname ;
   private String bttBtnagregar_Jsonclick ;
   private String divTablesearchlegajo_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String divSplitright_Internalname ;
   private String WebComp_Detailwc_Component ;
   private String OldDetailwc ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV87Legajoswwds_4_legtipotarifa ;
   private String AV88Legajoswwds_5_legmodtra ;
   private String AV89Legajoswwds_6_conveniofiltro ;
   private String AV97Legajoswwds_14_legactcodigo ;
   private String AV98Legajoswwds_15_mprcod ;
   private String AV99Legajoswwds_16_zoncod ;
   private String AV100Legajoswwds_17_legsuccodigo ;
   private String edtavImg_legajo_Internalname ;
   private String edtLegNomApe_Internalname ;
   private String edtavCatdescrip_Internalname ;
   private String GXCCtl ;
   private String scmdbuf ;
   private String lV97Legajoswwds_14_legactcodigo ;
   private String lV98Legajoswwds_15_mprcod ;
   private String lV99Legajoswwds_16_zoncod ;
   private String lV100Legajoswwds_17_legsuccodigo ;
   private String A910LegSinCod ;
   private String A1579LegSecCodigo ;
   private String A1578LegPuesCodigo ;
   private String A93LegId ;
   private String A2417LegTipoTarifa ;
   private String A2404LegModTra ;
   private String A15LegActCodigo ;
   private String A18MprCod ;
   private String A20ZonCod ;
   private String A1577LegSucCodigo ;
   private String edtavLegsexo_Internalname ;
   private String edtavLegclase_Internalname ;
   private String edtavLegfecingreso_Internalname ;
   private String edtavLegfecegreso_Internalname ;
   private String edtavLegactcodigo_Internalname ;
   private String edtavMprcod_Internalname ;
   private String edtavZoncod_Internalname ;
   private String edtavLegsuccodigo_Internalname ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String lblTextblockfiltros_Caption ;
   private String lblTextblockfiltros_Internalname ;
   private String AV78inicialesPalabra ;
   private String lblTextblockbadgename_Caption ;
   private String edtavImg_legajo_Class ;
   private String GXt_char2 ;
   private String lblTextblockbadgename_Tooltiptext ;
   private String GXv_char4[] ;
   private String lblTextblockbadgefiltersplitscreen_Caption ;
   private String lblTextblockbadgefiltersplitscreen_Internalname ;
   private String lblTextblockbadgefiltersplitscreen_Tooltiptext ;
   private String lblTextblockfiltros_Tooltiptext ;
   private String tblTblfiltrosinvisibles_Internalname ;
   private String Combo_legpuescodigo_Internalname ;
   private String Combo_legseccodigo_Internalname ;
   private String Combo_legcatcodigo_Internalname ;
   private String Combo_legconvecodigo_Internalname ;
   private String Combo_legsincod_Internalname ;
   private String edtavLegsexo_Jsonclick ;
   private String edtavLegclase_Jsonclick ;
   private String Combo_legsincod_Caption ;
   private String Combo_legconvecodigo_Caption ;
   private String Combo_legcatcodigo_Caption ;
   private String edtavLegfecingreso_Jsonclick ;
   private String edtavLegfecegreso_Jsonclick ;
   private String Combo_legseccodigo_Caption ;
   private String Combo_legpuescodigo_Caption ;
   private String edtavLegactcodigo_Jsonclick ;
   private String edtavMprcod_Jsonclick ;
   private String edtavZoncod_Jsonclick ;
   private String edtavLegsuccodigo_Jsonclick ;
   private String tblTablebuttonfiltros_Internalname ;
   private String lblTextblockbadgefiltersplitscreen_Jsonclick ;
   private String lblTextblockfiltros_Jsonclick ;
   private String lblTextblockbadgename_Internalname ;
   private String sGXsfl_41_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String divFsgridtablerow_Internalname ;
   private String tblUnnamedtablecontentfsgrid_Internalname ;
   private String ROClassString ;
   private String edtLegCUIL_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegNumero_Jsonclick ;
   private String divTableimagelegajo_Internalname ;
   private String lblTextblockbadgename_Jsonclick ;
   private String edtavImg_legajo_gximage ;
   private String sImgUrl ;
   private String divTablelegajosplit_Internalname ;
   private String edtLegNomApe_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date AV56LegFecIngreso ;
   private java.util.Date AV55LegFecEgreso ;
   private java.util.Date AV93Legajoswwds_10_legfecingreso ;
   private java.util.Date AV94Legajoswwds_11_legfecegreso ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date A244LegFecEgreso ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_41_Refreshing=false ;
   private boolean AV77LegIncompleto ;
   private boolean A2267LegIncompleto ;
   private boolean AV31RefreshGrid ;
   private boolean Combo_legsincod_Allowmultipleselection ;
   private boolean Combo_legsincod_Includeonlyselectedoption ;
   private boolean Combo_legconvecodigo_Allowmultipleselection ;
   private boolean Combo_legconvecodigo_Includeonlyselectedoption ;
   private boolean Combo_legconvecodigo_Emptyitem ;
   private boolean Combo_legcatcodigo_Allowmultipleselection ;
   private boolean Combo_legcatcodigo_Includeonlyselectedoption ;
   private boolean Combo_legseccodigo_Allowmultipleselection ;
   private boolean Combo_legseccodigo_Includeonlyselectedoption ;
   private boolean Combo_legseccodigo_Emptyitem ;
   private boolean Combo_legpuescodigo_Allowmultipleselection ;
   private boolean Combo_legpuescodigo_Includeonlyselectedoption ;
   private boolean Combo_legpuescodigo_Emptyitem ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean AV102Legajoswwds_19_legincompleto ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1577LegSucCodigo ;
   private boolean n20ZonCod ;
   private boolean n18MprCod ;
   private boolean n15LegActCodigo ;
   private boolean n93LegId ;
   private boolean n1578LegPuesCodigo ;
   private boolean n1579LegSecCodigo ;
   private boolean n244LegFecEgreso ;
   private boolean n910LegSinCod ;
   private boolean n263LegSexo ;
   private boolean n939LegCatCodigo ;
   private boolean n937LegConveCodigo ;
   private boolean n2263LegMigrWarn ;
   private boolean returnInSub ;
   private boolean bDynCreated_Detailwc ;
   private boolean gx_refresh_fired ;
   private boolean GXv_boolean12[] ;
   private boolean AV37img_legajo_IsBlob ;
   private String A2263LegMigrWarn ;
   private String AV73filtrosSVGValor ;
   private String wcpOAV38MenuOpcCod ;
   private String AV38MenuOpcCod ;
   private String AV14FilterFullText ;
   private String A1030LegFotoNom ;
   private String A251LegNombre ;
   private String A230LegApellido ;
   private String AV25DetailTableName ;
   private String AV84Legajoswwds_1_filterfulltext ;
   private String AV103Img_legajo_GXI ;
   private String A591LegNomApe ;
   private String AV15CatDescrip ;
   private String lV84Legajoswwds_1_filterfulltext ;
   private String AV36urlFoto ;
   private String AV33AuxCatDescrip ;
   private String AV40ConveDescri ;
   private String AV27DetailWCLink ;
   private String AV48filtrosTexto ;
   private String AV37img_legajo ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWindow AV70window ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Detailwc ;
   private com.genexus.internet.HttpRequest AV9HTTPRequest ;
   private com.genexus.webpanels.WebSession AV16Session ;
   private com.genexus.webpanels.GXUserControl ucCombo_legpuescodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_legseccodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_legcatcodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_legconvecodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_legsincod ;
   private HTMLChoice cmbavLegtipotarifa ;
   private HTMLChoice cmbavLegmodtra ;
   private HTMLChoice cmbavConveniofiltro ;
   private HTMLChoice cmbavLegestado ;
   private ICheckbox chkavLegincompleto ;
   private IDataStoreProvider pr_default ;
   private int[] H00JU2_A3CliCod ;
   private short[] H00JU2_A1EmpCod ;
   private String[] H00JU2_A1577LegSucCodigo ;
   private boolean[] H00JU2_n1577LegSucCodigo ;
   private String[] H00JU2_A20ZonCod ;
   private boolean[] H00JU2_n20ZonCod ;
   private String[] H00JU2_A18MprCod ;
   private boolean[] H00JU2_n18MprCod ;
   private String[] H00JU2_A15LegActCodigo ;
   private boolean[] H00JU2_n15LegActCodigo ;
   private String[] H00JU2_A93LegId ;
   private boolean[] H00JU2_n93LegId ;
   private byte[] H00JU2_A1818LegEstado ;
   private String[] H00JU2_A1578LegPuesCodigo ;
   private boolean[] H00JU2_n1578LegPuesCodigo ;
   private String[] H00JU2_A1579LegSecCodigo ;
   private boolean[] H00JU2_n1579LegSecCodigo ;
   private java.util.Date[] H00JU2_A244LegFecEgreso ;
   private boolean[] H00JU2_n244LegFecEgreso ;
   private java.util.Date[] H00JU2_A245LegFecIngreso ;
   private String[] H00JU2_A910LegSinCod ;
   private boolean[] H00JU2_n910LegSinCod ;
   private String[] H00JU2_A2404LegModTra ;
   private String[] H00JU2_A2417LegTipoTarifa ;
   private byte[] H00JU2_A263LegSexo ;
   private boolean[] H00JU2_n263LegSexo ;
   private String[] H00JU2_A1030LegFotoNom ;
   private String[] H00JU2_A251LegNombre ;
   private String[] H00JU2_A230LegApellido ;
   private byte[] H00JU2_A235LegClase ;
   private String[] H00JU2_A939LegCatCodigo ;
   private boolean[] H00JU2_n939LegCatCodigo ;
   private String[] H00JU2_A937LegConveCodigo ;
   private boolean[] H00JU2_n937LegConveCodigo ;
   private boolean[] H00JU2_A2267LegIncompleto ;
   private String[] H00JU2_A2263LegMigrWarn ;
   private boolean[] H00JU2_n2263LegMigrWarn ;
   private String[] H00JU2_A591LegNomApe ;
   private int[] H00JU2_A6LegNumero ;
   private long[] H00JU2_A239LegCUIL ;
   private long[] H00JU3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV34websession ;
   private GXSimpleCollection<String> AV64LegSinCod ;
   private GXSimpleCollection<String> AV53LegConveCodigo ;
   private GXSimpleCollection<String> AV50LegCatCodigo ;
   private GXSimpleCollection<String> AV60LegSecCodigo ;
   private GXSimpleCollection<String> AV58LegPuesCodigo ;
   private GXSimpleCollection<String> AV90Legajoswwds_7_legsincod ;
   private GXSimpleCollection<String> AV91Legajoswwds_8_legconvecodigo ;
   private GXSimpleCollection<String> AV92Legajoswwds_9_legcatcodigo ;
   private GXSimpleCollection<String> AV95Legajoswwds_12_legseccodigo ;
   private GXSimpleCollection<String> AV96Legajoswwds_13_legpuescodigo ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV65LegSinCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV54LegConveCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV51LegCatCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV61LegSecCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV59LegPuesCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXv_objcol_SdtDVB_SDTComboData_Item14[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtSplitScreenDetailInfo> AV24DetailWCHistory ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV47DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10[] ;
   private web.wwpbaseobjects.SdtSplitScreenDetailInfo AV30DetailWCInfo ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState13[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext11[] ;
}

final  class legajosww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00JU2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A910LegSinCod ,
                                          GXSimpleCollection<String> AV90Legajoswwds_7_legsincod ,
                                          String A937LegConveCodigo ,
                                          GXSimpleCollection<String> AV91Legajoswwds_8_legconvecodigo ,
                                          String A939LegCatCodigo ,
                                          GXSimpleCollection<String> AV92Legajoswwds_9_legcatcodigo ,
                                          String A1579LegSecCodigo ,
                                          GXSimpleCollection<String> AV95Legajoswwds_12_legseccodigo ,
                                          String A1578LegPuesCodigo ,
                                          GXSimpleCollection<String> AV96Legajoswwds_13_legpuescodigo ,
                                          String AV84Legajoswwds_1_filterfulltext ,
                                          byte AV85Legajoswwds_2_legsexo ,
                                          short AV86Legajoswwds_3_legclase ,
                                          String AV87Legajoswwds_4_legtipotarifa ,
                                          String AV88Legajoswwds_5_legmodtra ,
                                          String AV89Legajoswwds_6_conveniofiltro ,
                                          int AV90Legajoswwds_7_legsincod_size ,
                                          int AV91Legajoswwds_8_legconvecodigo_size ,
                                          int AV92Legajoswwds_9_legcatcodigo_size ,
                                          java.util.Date AV93Legajoswwds_10_legfecingreso ,
                                          java.util.Date AV94Legajoswwds_11_legfecegreso ,
                                          int AV95Legajoswwds_12_legseccodigo_size ,
                                          int AV96Legajoswwds_13_legpuescodigo_size ,
                                          String AV97Legajoswwds_14_legactcodigo ,
                                          String AV98Legajoswwds_15_mprcod ,
                                          String AV99Legajoswwds_16_zoncod ,
                                          String AV100Legajoswwds_17_legsuccodigo ,
                                          byte AV101Legajoswwds_18_legestado ,
                                          boolean AV102Legajoswwds_19_legincompleto ,
                                          String A591LegNomApe ,
                                          long A239LegCUIL ,
                                          String A93LegId ,
                                          byte A263LegSexo ,
                                          byte A235LegClase ,
                                          String A2417LegTipoTarifa ,
                                          String A2404LegModTra ,
                                          java.util.Date A245LegFecIngreso ,
                                          java.util.Date A244LegFecEgreso ,
                                          String A15LegActCodigo ,
                                          String A18MprCod ,
                                          String A20ZonCod ,
                                          String A1577LegSucCodigo ,
                                          byte A1818LegEstado ,
                                          boolean A2267LegIncompleto ,
                                          int AV17CliCod ,
                                          short AV18EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int15 = new byte[19];
      Object[] GXv_Object16 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " CliCod, EmpCod, LegSucCodigo, ZonCod, MprCod, LegActCodigo, LegId, LegEstado, LegPuesCodigo, LegSecCodigo, LegFecEgreso, LegFecIngreso, LegSinCod, LegModTra, LegTipoTarifa," ;
      sSelectString += " LegSexo, LegFotoNom, LegNombre, LegApellido, LegClase, LegCatCodigo, LegConveCodigo, LegIncompleto, LegMigrWarn, LegNomApe, LegNumero, LegCUIL" ;
      sFromString = " FROM Legajo" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (GXutil.strcmp("", AV84Legajoswwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( LOWER(LegNomApe) like '%' || LOWER(?)) or ( SUBSTR(TO_CHAR(LegCUIL,'99999999999'), 2) like '%' || ?) or ( LOWER(LegId) like '%' || LOWER(?)))");
      }
      else
      {
         GXv_int15[2] = (byte)(1) ;
         GXv_int15[3] = (byte)(1) ;
         GXv_int15[4] = (byte)(1) ;
      }
      if ( ! (0==AV85Legajoswwds_2_legsexo) )
      {
         addWhere(sWhereString, "(LegSexo = ?)");
      }
      else
      {
         GXv_int15[5] = (byte)(1) ;
      }
      if ( ! (0==AV86Legajoswwds_3_legclase) )
      {
         addWhere(sWhereString, "(LegClase = ?)");
      }
      else
      {
         GXv_int15[6] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Legajoswwds_4_legtipotarifa)==0) )
      {
         addWhere(sWhereString, "(LegTipoTarifa = ( ?))");
      }
      else
      {
         GXv_int15[7] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Legajoswwds_5_legmodtra)==0) )
      {
         addWhere(sWhereString, "(LegModTra = ( ?))");
      }
      else
      {
         GXv_int15[8] = (byte)(1) ;
      }
      if ( GXutil.strcmp(AV89Legajoswwds_6_conveniofiltro, "Fuera") == 0 )
      {
         addWhere(sWhereString, "(LegConveCodigo IS NULL)");
      }
      if ( AV90Legajoswwds_7_legsincod_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV90Legajoswwds_7_legsincod, "LegSinCod IN (", ")")+")");
      }
      if ( AV91Legajoswwds_8_legconvecodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Legajoswwds_8_legconvecodigo, "LegConveCodigo IN (", ")")+")");
      }
      if ( AV92Legajoswwds_9_legcatcodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV92Legajoswwds_9_legcatcodigo, "LegCatCodigo IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Legajoswwds_10_legfecingreso)) )
      {
         addWhere(sWhereString, "(LegFecIngreso >= ?)");
      }
      else
      {
         GXv_int15[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Legajoswwds_11_legfecegreso)) )
      {
         addWhere(sWhereString, "(LegFecEgreso >= ?)");
      }
      else
      {
         GXv_int15[10] = (byte)(1) ;
      }
      if ( AV95Legajoswwds_12_legseccodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Legajoswwds_12_legseccodigo, "LegSecCodigo IN (", ")")+")");
      }
      if ( AV96Legajoswwds_13_legpuescodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV96Legajoswwds_13_legpuescodigo, "LegPuesCodigo IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV97Legajoswwds_14_legactcodigo)==0) )
      {
         addWhere(sWhereString, "(LOWER(LegActCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int15[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Legajoswwds_15_mprcod)==0) )
      {
         addWhere(sWhereString, "(LOWER(MprCod) like LOWER(?))");
      }
      else
      {
         GXv_int15[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Legajoswwds_16_zoncod)==0) )
      {
         addWhere(sWhereString, "(LOWER(ZonCod) like LOWER(?))");
      }
      else
      {
         GXv_int15[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Legajoswwds_17_legsuccodigo)==0) )
      {
         addWhere(sWhereString, "(LOWER(LegSucCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int15[14] = (byte)(1) ;
      }
      if ( ! (0==AV101Legajoswwds_18_legestado) )
      {
         addWhere(sWhereString, "(LegEstado = ?)");
      }
      else
      {
         GXv_int15[15] = (byte)(1) ;
      }
      if ( AV102Legajoswwds_19_legincompleto )
      {
         addWhere(sWhereString, "(LegIncompleto = TRUE)");
      }
      sOrderString += " ORDER BY CliCod, EmpCod, LegNumero DESC" ;
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object16[0] = scmdbuf ;
      GXv_Object16[1] = GXv_int15 ;
      return GXv_Object16 ;
   }

   protected Object[] conditional_H00JU3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A910LegSinCod ,
                                          GXSimpleCollection<String> AV90Legajoswwds_7_legsincod ,
                                          String A937LegConveCodigo ,
                                          GXSimpleCollection<String> AV91Legajoswwds_8_legconvecodigo ,
                                          String A939LegCatCodigo ,
                                          GXSimpleCollection<String> AV92Legajoswwds_9_legcatcodigo ,
                                          String A1579LegSecCodigo ,
                                          GXSimpleCollection<String> AV95Legajoswwds_12_legseccodigo ,
                                          String A1578LegPuesCodigo ,
                                          GXSimpleCollection<String> AV96Legajoswwds_13_legpuescodigo ,
                                          String AV84Legajoswwds_1_filterfulltext ,
                                          byte AV85Legajoswwds_2_legsexo ,
                                          short AV86Legajoswwds_3_legclase ,
                                          String AV87Legajoswwds_4_legtipotarifa ,
                                          String AV88Legajoswwds_5_legmodtra ,
                                          String AV89Legajoswwds_6_conveniofiltro ,
                                          int AV90Legajoswwds_7_legsincod_size ,
                                          int AV91Legajoswwds_8_legconvecodigo_size ,
                                          int AV92Legajoswwds_9_legcatcodigo_size ,
                                          java.util.Date AV93Legajoswwds_10_legfecingreso ,
                                          java.util.Date AV94Legajoswwds_11_legfecegreso ,
                                          int AV95Legajoswwds_12_legseccodigo_size ,
                                          int AV96Legajoswwds_13_legpuescodigo_size ,
                                          String AV97Legajoswwds_14_legactcodigo ,
                                          String AV98Legajoswwds_15_mprcod ,
                                          String AV99Legajoswwds_16_zoncod ,
                                          String AV100Legajoswwds_17_legsuccodigo ,
                                          byte AV101Legajoswwds_18_legestado ,
                                          boolean AV102Legajoswwds_19_legincompleto ,
                                          String A591LegNomApe ,
                                          long A239LegCUIL ,
                                          String A93LegId ,
                                          byte A263LegSexo ,
                                          byte A235LegClase ,
                                          String A2417LegTipoTarifa ,
                                          String A2404LegModTra ,
                                          java.util.Date A245LegFecIngreso ,
                                          java.util.Date A244LegFecEgreso ,
                                          String A15LegActCodigo ,
                                          String A18MprCod ,
                                          String A20ZonCod ,
                                          String A1577LegSucCodigo ,
                                          byte A1818LegEstado ,
                                          boolean A2267LegIncompleto ,
                                          int AV17CliCod ,
                                          short AV18EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int18 = new byte[16];
      Object[] GXv_Object19 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM Legajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (GXutil.strcmp("", AV84Legajoswwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( LOWER(LegNomApe) like '%' || LOWER(?)) or ( SUBSTR(TO_CHAR(LegCUIL,'99999999999'), 2) like '%' || ?) or ( LOWER(LegId) like '%' || LOWER(?)))");
      }
      else
      {
         GXv_int18[2] = (byte)(1) ;
         GXv_int18[3] = (byte)(1) ;
         GXv_int18[4] = (byte)(1) ;
      }
      if ( ! (0==AV85Legajoswwds_2_legsexo) )
      {
         addWhere(sWhereString, "(LegSexo = ?)");
      }
      else
      {
         GXv_int18[5] = (byte)(1) ;
      }
      if ( ! (0==AV86Legajoswwds_3_legclase) )
      {
         addWhere(sWhereString, "(LegClase = ?)");
      }
      else
      {
         GXv_int18[6] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Legajoswwds_4_legtipotarifa)==0) )
      {
         addWhere(sWhereString, "(LegTipoTarifa = ( ?))");
      }
      else
      {
         GXv_int18[7] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Legajoswwds_5_legmodtra)==0) )
      {
         addWhere(sWhereString, "(LegModTra = ( ?))");
      }
      else
      {
         GXv_int18[8] = (byte)(1) ;
      }
      if ( GXutil.strcmp(AV89Legajoswwds_6_conveniofiltro, "Fuera") == 0 )
      {
         addWhere(sWhereString, "(LegConveCodigo IS NULL)");
      }
      if ( AV90Legajoswwds_7_legsincod_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV90Legajoswwds_7_legsincod, "LegSinCod IN (", ")")+")");
      }
      if ( AV91Legajoswwds_8_legconvecodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Legajoswwds_8_legconvecodigo, "LegConveCodigo IN (", ")")+")");
      }
      if ( AV92Legajoswwds_9_legcatcodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV92Legajoswwds_9_legcatcodigo, "LegCatCodigo IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Legajoswwds_10_legfecingreso)) )
      {
         addWhere(sWhereString, "(LegFecIngreso >= ?)");
      }
      else
      {
         GXv_int18[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Legajoswwds_11_legfecegreso)) )
      {
         addWhere(sWhereString, "(LegFecEgreso >= ?)");
      }
      else
      {
         GXv_int18[10] = (byte)(1) ;
      }
      if ( AV95Legajoswwds_12_legseccodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Legajoswwds_12_legseccodigo, "LegSecCodigo IN (", ")")+")");
      }
      if ( AV96Legajoswwds_13_legpuescodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV96Legajoswwds_13_legpuescodigo, "LegPuesCodigo IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV97Legajoswwds_14_legactcodigo)==0) )
      {
         addWhere(sWhereString, "(LOWER(LegActCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int18[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Legajoswwds_15_mprcod)==0) )
      {
         addWhere(sWhereString, "(LOWER(MprCod) like LOWER(?))");
      }
      else
      {
         GXv_int18[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Legajoswwds_16_zoncod)==0) )
      {
         addWhere(sWhereString, "(LOWER(ZonCod) like LOWER(?))");
      }
      else
      {
         GXv_int18[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Legajoswwds_17_legsuccodigo)==0) )
      {
         addWhere(sWhereString, "(LOWER(LegSucCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int18[14] = (byte)(1) ;
      }
      if ( ! (0==AV101Legajoswwds_18_legestado) )
      {
         addWhere(sWhereString, "(LegEstado = ?)");
      }
      else
      {
         GXv_int18[15] = (byte)(1) ;
      }
      if ( AV102Legajoswwds_19_legincompleto )
      {
         addWhere(sWhereString, "(LegIncompleto = TRUE)");
      }
      scmdbuf += sWhereString ;
      GXv_Object19[0] = scmdbuf ;
      GXv_Object19[1] = GXv_int18 ;
      return GXv_Object19 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_H00JU2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , ((Number) dynConstraints[27]).byteValue() , ((Boolean) dynConstraints[28]).booleanValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).longValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , ((Number) dynConstraints[33]).byteValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , (java.util.Date)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , ((Number) dynConstraints[42]).byteValue() , ((Boolean) dynConstraints[43]).booleanValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).shortValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).shortValue() );
            case 1 :
                  return conditional_H00JU3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , ((Number) dynConstraints[27]).byteValue() , ((Boolean) dynConstraints[28]).booleanValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).longValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , ((Number) dynConstraints[33]).byteValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , (java.util.Date)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , ((Number) dynConstraints[42]).byteValue() , ((Boolean) dynConstraints[43]).booleanValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).shortValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00JU2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,51, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00JU3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(6, 8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(8);
               ((String[]) buf[13])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[17])[0] = rslt.getGXDate(11);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(12);
               ((String[]) buf[20])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(14, 1);
               ((String[]) buf[23])[0] = rslt.getString(15, 1);
               ((byte[]) buf[24])[0] = rslt.getByte(16);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getVarchar(17);
               ((String[]) buf[27])[0] = rslt.getVarchar(18);
               ((String[]) buf[28])[0] = rslt.getVarchar(19);
               ((byte[]) buf[29])[0] = rslt.getByte(20);
               ((String[]) buf[30])[0] = rslt.getString(21, 40);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(22, 20);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((boolean[]) buf[34])[0] = rslt.getBoolean(23);
               ((String[]) buf[35])[0] = rslt.getLongVarchar(24);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((String[]) buf[37])[0] = rslt.getVarchar(25);
               ((int[]) buf[38])[0] = rslt.getInt(26);
               ((long[]) buf[39])[0] = rslt.getLong(27);
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
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[24]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[26], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[27], 1);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[28]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[29]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[30], 8);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[31], 20);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[32], 20);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[33], 20);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[34]).byteValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[35]).intValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[36]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[37]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[24], 1);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[25]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[26]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[27], 8);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[28], 20);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 20);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[30], 20);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[31]).byteValue());
               }
               return;
      }
   }

}

