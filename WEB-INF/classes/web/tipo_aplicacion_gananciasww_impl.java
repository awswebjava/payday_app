package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class tipo_aplicacion_gananciasww_impl extends GXDataArea
{
   public tipo_aplicacion_gananciasww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public tipo_aplicacion_gananciasww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipo_aplicacion_gananciasww_impl.class ));
   }

   public tipo_aplicacion_gananciasww_impl( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbAplIIGGTrat = new HTMLChoice();
      cmbAplIIGGTopeTip = new HTMLChoice();
      cmbAplIIGGPrrtear = new HTMLChoice();
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
            AV77MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77MenuOpcCod", AV77MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV77MenuOpcCod, ""))));
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
      nRC_GXsfl_110 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_110"))) ;
      nGXsfl_110_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_110_idx"))) ;
      sGXsfl_110_idx = httpContext.GetPar( "sGXsfl_110_idx") ;
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
      AV91ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV19ColumnsSelector);
      AV104Pgmname = httpContext.GetPar( "Pgmname") ;
      AV77MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      AV64TFAplIIGG = (short)(GXutil.lval( httpContext.GetPar( "TFAplIIGG"))) ;
      AV65TFAplIIGG_To = (short)(GXutil.lval( httpContext.GetPar( "TFAplIIGG_To"))) ;
      AV23TFAplIIGGNom = httpContext.GetPar( "TFAplIIGGNom") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV24TFAplIIGGNom_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV26TFAplIIGGTrat_Sels);
      AV27TFAplIIGGPropor = CommonUtil.decimalVal( httpContext.GetPar( "TFAplIIGGPropor"), ".") ;
      AV28TFAplIIGGPropor_To = CommonUtil.decimalVal( httpContext.GetPar( "TFAplIIGGPropor_To"), ".") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30TFAplIIGGTopeTip_Sels);
      AV35TFAplIIGGTopeCon = httpContext.GetPar( "TFAplIIGGTopeCon") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV36TFAplIIGGTopeCon_Sels);
      AV37TFAplIIGGTopeFij = CommonUtil.decimalVal( httpContext.GetPar( "TFAplIIGGTopeFij"), ".") ;
      AV38TFAplIIGGTopeFij_To = CommonUtil.decimalVal( httpContext.GetPar( "TFAplIIGGTopeFij_To"), ".") ;
      AV40TFAplIIGGExenCon = httpContext.GetPar( "TFAplIIGGExenCon") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV41TFAplIIGGExenCon_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV72TFAplIIGGPrrtear_Sels);
      AV47TFAplIIGGCondicion = httpContext.GetPar( "TFAplIIGGCondicion") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV48TFAplIIGGCondicion_Sels);
      AV87TFAplIIGGRelRef = httpContext.GetPar( "TFAplIIGGRelRef") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV88TFAplIIGGRelRef_Sels);
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV62CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV55IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV57IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV79WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV91ManageFiltersExecutionStep, AV19ColumnsSelector, AV104Pgmname, AV77MenuOpcCod, AV12GridState, AV64TFAplIIGG, AV65TFAplIIGG_To, AV23TFAplIIGGNom, AV24TFAplIIGGNom_Sels, AV26TFAplIIGGTrat_Sels, AV27TFAplIIGGPropor, AV28TFAplIIGGPropor_To, AV30TFAplIIGGTopeTip_Sels, AV35TFAplIIGGTopeCon, AV36TFAplIIGGTopeCon_Sels, AV37TFAplIIGGTopeFij, AV38TFAplIIGGTopeFij_To, AV40TFAplIIGGExenCon, AV41TFAplIIGGExenCon_Sels, AV72TFAplIIGGPrrtear_Sels, AV47TFAplIIGGCondicion, AV48TFAplIIGGCondicion_Sels, AV87TFAplIIGGRelRef, AV88TFAplIIGGRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV62CliCod, AV55IsAuthorized_Update, AV57IsAuthorized_Delete, AV79WelcomeMessage_NoMostrarMas) ;
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
      paBQ2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startBQ2( ) ;
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
      httpContext.AddJavascriptSource("UserControls/A3LClonEventRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LFilterRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.tipo_aplicacion_gananciasww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV77MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV104Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV77MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV62CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV55IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV57IsAuthorized_Delete));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_110", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_110, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV49DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV49DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV19ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV19ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV89ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV89ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV51GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV52GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV53GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV91ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV104Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV104Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV77MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV77MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGG", GXutil.ltrim( localUtil.ntoc( AV64TFAplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGG_TO", GXutil.ltrim( localUtil.ntoc( AV65TFAplIIGG_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGNOM", AV23TFAplIIGGNom);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFAPLIIGGNOM_SELS", AV24TFAplIIGGNom_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFAPLIIGGNOM_SELS", AV24TFAplIIGGNom_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFAPLIIGGTRAT_SELS", AV26TFAplIIGGTrat_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFAPLIIGGTRAT_SELS", AV26TFAplIIGGTrat_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGPROPOR", GXutil.ltrim( localUtil.ntoc( AV27TFAplIIGGPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGPROPOR_TO", GXutil.ltrim( localUtil.ntoc( AV28TFAplIIGGPropor_To, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFAPLIIGGTOPETIP_SELS", AV30TFAplIIGGTopeTip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFAPLIIGGTOPETIP_SELS", AV30TFAplIIGGTopeTip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGTOPECON", GXutil.rtrim( AV35TFAplIIGGTopeCon));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFAPLIIGGTOPECON_SELS", AV36TFAplIIGGTopeCon_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFAPLIIGGTOPECON_SELS", AV36TFAplIIGGTopeCon_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGTOPEFIJ", GXutil.ltrim( localUtil.ntoc( AV37TFAplIIGGTopeFij, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGTOPEFIJ_TO", GXutil.ltrim( localUtil.ntoc( AV38TFAplIIGGTopeFij_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGEXENCON", GXutil.rtrim( AV40TFAplIIGGExenCon));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFAPLIIGGEXENCON_SELS", AV41TFAplIIGGExenCon_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFAPLIIGGEXENCON_SELS", AV41TFAplIIGGExenCon_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFAPLIIGGPRRTEAR_SELS", AV72TFAplIIGGPrrtear_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFAPLIIGGPRRTEAR_SELS", AV72TFAplIIGGPrrtear_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGCONDICION", GXutil.rtrim( AV47TFAplIIGGCondicion));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFAPLIIGGCONDICION_SELS", AV48TFAplIIGGCondicion_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFAPLIIGGCONDICION_SELS", AV48TFAplIIGGCondicion_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGRELREF", AV87TFAplIIGGRelRef);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFAPLIIGGRELREF_SELS", AV88TFAplIIGGRelRef_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFAPLIIGGRELREF_SELS", AV88TFAplIIGGRelRef_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV62CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV62CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV55IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV55IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV57IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV57IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGNOM_SELSJSON", AV22TFAplIIGGNom_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGTRAT_SELSJSON", AV25TFAplIIGGTrat_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGTOPETIP_SELSJSON", AV29TFAplIIGGTopeTip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGTOPECON_SELSJSON", AV34TFAplIIGGTopeCon_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGEXENCON_SELSJSON", AV39TFAplIIGGExenCon_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGPRRTEAR_SELSJSON", AV71TFAplIIGGPrrtear_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGCONDICION_SELSJSON", AV46TFAplIIGGCondicion_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGGRELREF_SELSJSON", AV86TFAplIIGGRelRef_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONEXPORT1_A3LEXPORT_Observer", GXutil.rtrim( Buttonexport1_a3lexport_Observer));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONEXPORT1_A3LEXPORT_Boton_clon_id", GXutil.rtrim( Buttonexport1_a3lexport_Boton_clon_id));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONEXPORT1_A3LEXPORT_Boton_orig_id", GXutil.rtrim( Buttonexport1_a3lexport_Boton_orig_id));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Icontype", GXutil.rtrim( Ddo_gridcolumnsselector_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Icon", GXutil.rtrim( Ddo_gridcolumnsselector_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Caption", GXutil.rtrim( Ddo_gridcolumnsselector_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Tooltip", GXutil.rtrim( Ddo_gridcolumnsselector_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Cls", GXutil.rtrim( Ddo_gridcolumnsselector_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype", GXutil.rtrim( Ddo_gridcolumnsselector_Dropdownoptionstype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Gridinternalname", GXutil.rtrim( Ddo_gridcolumnsselector_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONFILTER1_A3LFILTER_Observer", GXutil.rtrim( Buttonfilter1_a3lfilter_Observer));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONFILTER1_A3LFILTER_A3l_filter_id", GXutil.rtrim( Buttonfilter1_a3lfilter_A3l_filter_id));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONFILTER1_A3LFILTER_Filter_orig", GXutil.rtrim( Buttonfilter1_a3lfilter_Filter_orig));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_set", GXutil.rtrim( Ddo_grid_Filteredtextto_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Fixable", GXutil.rtrim( Ddo_grid_Fixable));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Format", GXutil.rtrim( Ddo_grid_Format));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hascolumnsselector", GXutil.booltostr( Grid_empowerer_Hascolumnsselector));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
         weBQ2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtBQ2( ) ;
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
      return formatLink("web.tipo_aplicacion_gananciasww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV77MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "tipo_aplicacion_gananciasWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Tratamientos de exención IIGG", "") ;
   }

   public void wbBQ0( )
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
         wb_table1_9_BQ2( true) ;
      }
      else
      {
         wb_table1_9_BQ2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_BQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDdo_grid.setProperty("Caption", Ddo_grid_Caption);
         ucDdo_grid.setProperty("ColumnIds", Ddo_grid_Columnids);
         ucDdo_grid.setProperty("ColumnsSortValues", Ddo_grid_Columnssortvalues);
         ucDdo_grid.setProperty("IncludeSortASC", Ddo_grid_Includesortasc);
         ucDdo_grid.setProperty("Fixable", Ddo_grid_Fixable);
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("FilterIsRange", Ddo_grid_Filterisrange);
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListFixedValues", Ddo_grid_Datalistfixedvalues);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("Format", Ddo_grid_Format);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV49DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 110 )
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

   public void startBQ2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Tratamientos de exención IIGG", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupBQ0( ) ;
   }

   public void wsBQ2( )
   {
      startBQ2( ) ;
      evtBQ2( ) ;
   }

   public void evtBQ2( )
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
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11BQ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12BQ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13BQ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14BQ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15BQ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e16BQ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17BQ2 ();
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
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_110_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1102( ) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( edtAplIIGG_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1113AplIIGGNom = httpContext.cgiGet( edtAplIIGGNom_Internalname) ;
                           cmbAplIIGGTrat.setName( cmbAplIIGGTrat.getInternalname() );
                           cmbAplIIGGTrat.setValue( httpContext.cgiGet( cmbAplIIGGTrat.getInternalname()) );
                           A1120AplIIGGTrat = (byte)(GXutil.lval( httpContext.cgiGet( cmbAplIIGGTrat.getInternalname()))) ;
                           A1114AplIIGGPropor = localUtil.ctond( httpContext.cgiGet( edtAplIIGGPropor_Internalname)) ;
                           cmbAplIIGGTopeTip.setName( cmbAplIIGGTopeTip.getInternalname() );
                           cmbAplIIGGTopeTip.setValue( httpContext.cgiGet( cmbAplIIGGTopeTip.getInternalname()) );
                           A1115AplIIGGTopeTip = (byte)(GXutil.lval( httpContext.cgiGet( cmbAplIIGGTopeTip.getInternalname()))) ;
                           A1109AplIIGGTopeVar = httpContext.cgiGet( edtAplIIGGTopeVar_Internalname) ;
                           n1109AplIIGGTopeVar = false ;
                           AV66OpeCliDescrip = httpContext.cgiGet( edtavOpeclidescrip_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavOpeclidescrip_Internalname, AV66OpeCliDescrip);
                           A1111AplIIGGTopeCon = httpContext.cgiGet( edtAplIIGGTopeCon_Internalname) ;
                           n1111AplIIGGTopeCon = false ;
                           A1119AplIIGGTopeFij = localUtil.ctond( httpContext.cgiGet( edtAplIIGGTopeFij_Internalname)) ;
                           A1117AplIIGGExenCon = httpContext.cgiGet( edtAplIIGGExenCon_Internalname) ;
                           n1117AplIIGGExenCon = false ;
                           cmbAplIIGGPrrtear.setName( cmbAplIIGGPrrtear.getInternalname() );
                           cmbAplIIGGPrrtear.setValue( httpContext.cgiGet( cmbAplIIGGPrrtear.getInternalname()) );
                           A1121AplIIGGPrrtear = httpContext.cgiGet( cmbAplIIGGPrrtear.getInternalname()) ;
                           A1124AplIIGGCondicion = httpContext.cgiGet( edtAplIIGGCondicion_Internalname) ;
                           n1124AplIIGGCondicion = false ;
                           A2020AplIIGGRelRef = httpContext.cgiGet( edtAplIIGGRelRef_Internalname) ;
                           AV54Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV54Update);
                           AV56Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV56Delete);
                           AV76Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV76Display);
                           AV73VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV73VerSVG);
                           AV74ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV74ModificarSVG);
                           AV75EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV75EliminarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e18BQ2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e19BQ2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20BQ2 ();
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

   public void weBQ2( )
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

   public void paBQ2( )
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

   public void gxnrgrid_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1102( ) ;
      while ( nGXsfl_110_idx <= nRC_GXsfl_110 )
      {
         sendrow_1102( ) ;
         nGXsfl_110_idx = ((subGrid_Islastpage==1)&&(nGXsfl_110_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_110_idx+1) ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV91ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ,
                                 String AV104Pgmname ,
                                 String AV77MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 short AV64TFAplIIGG ,
                                 short AV65TFAplIIGG_To ,
                                 String AV23TFAplIIGGNom ,
                                 GXSimpleCollection<String> AV24TFAplIIGGNom_Sels ,
                                 GXSimpleCollection<Byte> AV26TFAplIIGGTrat_Sels ,
                                 java.math.BigDecimal AV27TFAplIIGGPropor ,
                                 java.math.BigDecimal AV28TFAplIIGGPropor_To ,
                                 GXSimpleCollection<Byte> AV30TFAplIIGGTopeTip_Sels ,
                                 String AV35TFAplIIGGTopeCon ,
                                 GXSimpleCollection<String> AV36TFAplIIGGTopeCon_Sels ,
                                 java.math.BigDecimal AV37TFAplIIGGTopeFij ,
                                 java.math.BigDecimal AV38TFAplIIGGTopeFij_To ,
                                 String AV40TFAplIIGGExenCon ,
                                 GXSimpleCollection<String> AV41TFAplIIGGExenCon_Sels ,
                                 GXSimpleCollection<String> AV72TFAplIIGGPrrtear_Sels ,
                                 String AV47TFAplIIGGCondicion ,
                                 GXSimpleCollection<String> AV48TFAplIIGGCondicion_Sels ,
                                 String AV87TFAplIIGGRelRef ,
                                 GXSimpleCollection<String> AV88TFAplIIGGRelRef_Sels ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 int AV62CliCod ,
                                 boolean AV55IsAuthorized_Update ,
                                 boolean AV57IsAuthorized_Delete ,
                                 boolean AV79WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e19BQ2 ();
      GRID_nCurrentRecord = 0 ;
      rfBQ2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
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
      AV79WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV79WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79WelcomeMessage_NoMostrarMas", AV79WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfBQ2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV104Pgmname = "tipo_aplicacion_gananciasWW" ;
      Gx_err = (short)(0) ;
      edtavOpeclidescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpeclidescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpeclidescrip_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
   }

   public void rfBQ2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(110) ;
      /* Execute user event: Refresh */
      e19BQ2 ();
      nGXsfl_110_idx = 1 ;
      sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1102( ) ;
      bGXsfl_110_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1102( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A1113AplIIGGNom ,
                                              AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                              Byte.valueOf(A1120AplIIGGTrat) ,
                                              AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                              Byte.valueOf(A1115AplIIGGTopeTip) ,
                                              AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                              A1111AplIIGGTopeCon ,
                                              AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                              A1117AplIIGGExenCon ,
                                              AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                              A1121AplIIGGPrrtear ,
                                              AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                              A1124AplIIGGCondicion ,
                                              AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                              A2020AplIIGGRelRef ,
                                              AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                              Short.valueOf(AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg) ,
                                              Short.valueOf(AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) ,
                                              Integer.valueOf(AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels.size()) ,
                                              AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                              Integer.valueOf(AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels.size()) ,
                                              AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                              AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                              Integer.valueOf(AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels.size()) ,
                                              Integer.valueOf(AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels.size()) ,
                                              AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                              AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                              AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                              Integer.valueOf(AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels.size()) ,
                                              AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                              Integer.valueOf(AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels.size()) ,
                                              Integer.valueOf(AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels.size()) ,
                                              AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                              Integer.valueOf(AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels.size()) ,
                                              AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                              Short.valueOf(A1112AplIIGG) ,
                                              A1114AplIIGGPropor ,
                                              A1119AplIIGGTopeFij ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) ,
                                              Integer.valueOf(AV62CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = GXutil.concat( GXutil.rtrim( AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom), "%", "") ;
         lV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = GXutil.padr( GXutil.rtrim( AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon), 10, "%") ;
         lV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = GXutil.padr( GXutil.rtrim( AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon), 10, "%") ;
         lV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = GXutil.padr( GXutil.rtrim( AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion), 20, "%") ;
         lV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = GXutil.concat( GXutil.rtrim( AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref), "%", "") ;
         /* Using cursor H00BQ2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV62CliCod), Short.valueOf(AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg), Short.valueOf(AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to), lV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom, AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor, AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to, lV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon, AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij, AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to, lV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon, lV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion, lV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_110_idx = 1 ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A2020AplIIGGRelRef = H00BQ2_A2020AplIIGGRelRef[0] ;
            A1124AplIIGGCondicion = H00BQ2_A1124AplIIGGCondicion[0] ;
            n1124AplIIGGCondicion = H00BQ2_n1124AplIIGGCondicion[0] ;
            A1121AplIIGGPrrtear = H00BQ2_A1121AplIIGGPrrtear[0] ;
            A1117AplIIGGExenCon = H00BQ2_A1117AplIIGGExenCon[0] ;
            n1117AplIIGGExenCon = H00BQ2_n1117AplIIGGExenCon[0] ;
            A1119AplIIGGTopeFij = H00BQ2_A1119AplIIGGTopeFij[0] ;
            A1111AplIIGGTopeCon = H00BQ2_A1111AplIIGGTopeCon[0] ;
            n1111AplIIGGTopeCon = H00BQ2_n1111AplIIGGTopeCon[0] ;
            A1109AplIIGGTopeVar = H00BQ2_A1109AplIIGGTopeVar[0] ;
            n1109AplIIGGTopeVar = H00BQ2_n1109AplIIGGTopeVar[0] ;
            A1115AplIIGGTopeTip = H00BQ2_A1115AplIIGGTopeTip[0] ;
            A1114AplIIGGPropor = H00BQ2_A1114AplIIGGPropor[0] ;
            A1120AplIIGGTrat = H00BQ2_A1120AplIIGGTrat[0] ;
            A1113AplIIGGNom = H00BQ2_A1113AplIIGGNom[0] ;
            A1112AplIIGG = H00BQ2_A1112AplIIGG[0] ;
            A3CliCod = H00BQ2_A3CliCod[0] ;
            e20BQ2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(110) ;
         wbBQ0( ) ;
      }
      bGXsfl_110_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesBQ2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV104Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV104Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV77MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV77MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV62CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV62CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV55IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV55IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV57IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV57IsAuthorized_Delete));
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
      AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg = AV64TFAplIIGG ;
      AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to = AV65TFAplIIGG_To ;
      AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = AV23TFAplIIGGNom ;
      AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = AV24TFAplIIGGNom_Sels ;
      AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = AV26TFAplIIGGTrat_Sels ;
      AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = AV27TFAplIIGGPropor ;
      AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = AV28TFAplIIGGPropor_To ;
      AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = AV30TFAplIIGGTopeTip_Sels ;
      AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = AV35TFAplIIGGTopeCon ;
      AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = AV36TFAplIIGGTopeCon_Sels ;
      AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = AV37TFAplIIGGTopeFij ;
      AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = AV38TFAplIIGGTopeFij_To ;
      AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = AV40TFAplIIGGExenCon ;
      AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = AV41TFAplIIGGExenCon_Sels ;
      AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = AV72TFAplIIGGPrrtear_Sels ;
      AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = AV47TFAplIIGGCondicion ;
      AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = AV48TFAplIIGGCondicion_Sels ;
      AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = AV87TFAplIIGGRelRef ;
      AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = AV88TFAplIIGGRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1113AplIIGGNom ,
                                           AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                           Byte.valueOf(A1120AplIIGGTrat) ,
                                           AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                           Byte.valueOf(A1115AplIIGGTopeTip) ,
                                           AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                           A1111AplIIGGTopeCon ,
                                           AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                           A1117AplIIGGExenCon ,
                                           AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                           A1121AplIIGGPrrtear ,
                                           AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                           A1124AplIIGGCondicion ,
                                           AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                           A2020AplIIGGRelRef ,
                                           AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                           Short.valueOf(AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg) ,
                                           Short.valueOf(AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) ,
                                           Integer.valueOf(AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels.size()) ,
                                           AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                           Integer.valueOf(AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels.size()) ,
                                           AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                           AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                           Integer.valueOf(AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels.size()) ,
                                           Integer.valueOf(AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels.size()) ,
                                           AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                           AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                           AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                           Integer.valueOf(AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels.size()) ,
                                           AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                           Integer.valueOf(AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels.size()) ,
                                           Integer.valueOf(AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels.size()) ,
                                           AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                           Integer.valueOf(AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels.size()) ,
                                           AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           A1114AplIIGGPropor ,
                                           A1119AplIIGGTopeFij ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) ,
                                           Integer.valueOf(AV62CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = GXutil.concat( GXutil.rtrim( AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom), "%", "") ;
      lV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = GXutil.padr( GXutil.rtrim( AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon), 10, "%") ;
      lV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = GXutil.padr( GXutil.rtrim( AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon), 10, "%") ;
      lV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = GXutil.padr( GXutil.rtrim( AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion), 20, "%") ;
      lV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = GXutil.concat( GXutil.rtrim( AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref), "%", "") ;
      /* Using cursor H00BQ3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV62CliCod), Short.valueOf(AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg), Short.valueOf(AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to), lV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom, AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor, AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to, lV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon, AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij, AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to, lV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon, lV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion, lV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref});
      GRID_nRecordCount = H00BQ3_AGRID_nRecordCount[0] ;
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
      AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg = AV64TFAplIIGG ;
      AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to = AV65TFAplIIGG_To ;
      AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = AV23TFAplIIGGNom ;
      AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = AV24TFAplIIGGNom_Sels ;
      AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = AV26TFAplIIGGTrat_Sels ;
      AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = AV27TFAplIIGGPropor ;
      AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = AV28TFAplIIGGPropor_To ;
      AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = AV30TFAplIIGGTopeTip_Sels ;
      AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = AV35TFAplIIGGTopeCon ;
      AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = AV36TFAplIIGGTopeCon_Sels ;
      AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = AV37TFAplIIGGTopeFij ;
      AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = AV38TFAplIIGGTopeFij_To ;
      AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = AV40TFAplIIGGExenCon ;
      AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = AV41TFAplIIGGExenCon_Sels ;
      AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = AV72TFAplIIGGPrrtear_Sels ;
      AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = AV47TFAplIIGGCondicion ;
      AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = AV48TFAplIIGGCondicion_Sels ;
      AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = AV87TFAplIIGGRelRef ;
      AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = AV88TFAplIIGGRelRef_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV91ManageFiltersExecutionStep, AV19ColumnsSelector, AV104Pgmname, AV77MenuOpcCod, AV12GridState, AV64TFAplIIGG, AV65TFAplIIGG_To, AV23TFAplIIGGNom, AV24TFAplIIGGNom_Sels, AV26TFAplIIGGTrat_Sels, AV27TFAplIIGGPropor, AV28TFAplIIGGPropor_To, AV30TFAplIIGGTopeTip_Sels, AV35TFAplIIGGTopeCon, AV36TFAplIIGGTopeCon_Sels, AV37TFAplIIGGTopeFij, AV38TFAplIIGGTopeFij_To, AV40TFAplIIGGExenCon, AV41TFAplIIGGExenCon_Sels, AV72TFAplIIGGPrrtear_Sels, AV47TFAplIIGGCondicion, AV48TFAplIIGGCondicion_Sels, AV87TFAplIIGGRelRef, AV88TFAplIIGGRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV62CliCod, AV55IsAuthorized_Update, AV57IsAuthorized_Delete, AV79WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg = AV64TFAplIIGG ;
      AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to = AV65TFAplIIGG_To ;
      AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = AV23TFAplIIGGNom ;
      AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = AV24TFAplIIGGNom_Sels ;
      AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = AV26TFAplIIGGTrat_Sels ;
      AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = AV27TFAplIIGGPropor ;
      AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = AV28TFAplIIGGPropor_To ;
      AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = AV30TFAplIIGGTopeTip_Sels ;
      AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = AV35TFAplIIGGTopeCon ;
      AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = AV36TFAplIIGGTopeCon_Sels ;
      AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = AV37TFAplIIGGTopeFij ;
      AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = AV38TFAplIIGGTopeFij_To ;
      AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = AV40TFAplIIGGExenCon ;
      AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = AV41TFAplIIGGExenCon_Sels ;
      AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = AV72TFAplIIGGPrrtear_Sels ;
      AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = AV47TFAplIIGGCondicion ;
      AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = AV48TFAplIIGGCondicion_Sels ;
      AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = AV87TFAplIIGGRelRef ;
      AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = AV88TFAplIIGGRelRef_Sels ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV91ManageFiltersExecutionStep, AV19ColumnsSelector, AV104Pgmname, AV77MenuOpcCod, AV12GridState, AV64TFAplIIGG, AV65TFAplIIGG_To, AV23TFAplIIGGNom, AV24TFAplIIGGNom_Sels, AV26TFAplIIGGTrat_Sels, AV27TFAplIIGGPropor, AV28TFAplIIGGPropor_To, AV30TFAplIIGGTopeTip_Sels, AV35TFAplIIGGTopeCon, AV36TFAplIIGGTopeCon_Sels, AV37TFAplIIGGTopeFij, AV38TFAplIIGGTopeFij_To, AV40TFAplIIGGExenCon, AV41TFAplIIGGExenCon_Sels, AV72TFAplIIGGPrrtear_Sels, AV47TFAplIIGGCondicion, AV48TFAplIIGGCondicion_Sels, AV87TFAplIIGGRelRef, AV88TFAplIIGGRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV62CliCod, AV55IsAuthorized_Update, AV57IsAuthorized_Delete, AV79WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg = AV64TFAplIIGG ;
      AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to = AV65TFAplIIGG_To ;
      AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = AV23TFAplIIGGNom ;
      AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = AV24TFAplIIGGNom_Sels ;
      AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = AV26TFAplIIGGTrat_Sels ;
      AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = AV27TFAplIIGGPropor ;
      AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = AV28TFAplIIGGPropor_To ;
      AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = AV30TFAplIIGGTopeTip_Sels ;
      AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = AV35TFAplIIGGTopeCon ;
      AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = AV36TFAplIIGGTopeCon_Sels ;
      AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = AV37TFAplIIGGTopeFij ;
      AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = AV38TFAplIIGGTopeFij_To ;
      AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = AV40TFAplIIGGExenCon ;
      AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = AV41TFAplIIGGExenCon_Sels ;
      AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = AV72TFAplIIGGPrrtear_Sels ;
      AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = AV47TFAplIIGGCondicion ;
      AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = AV48TFAplIIGGCondicion_Sels ;
      AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = AV87TFAplIIGGRelRef ;
      AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = AV88TFAplIIGGRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV91ManageFiltersExecutionStep, AV19ColumnsSelector, AV104Pgmname, AV77MenuOpcCod, AV12GridState, AV64TFAplIIGG, AV65TFAplIIGG_To, AV23TFAplIIGGNom, AV24TFAplIIGGNom_Sels, AV26TFAplIIGGTrat_Sels, AV27TFAplIIGGPropor, AV28TFAplIIGGPropor_To, AV30TFAplIIGGTopeTip_Sels, AV35TFAplIIGGTopeCon, AV36TFAplIIGGTopeCon_Sels, AV37TFAplIIGGTopeFij, AV38TFAplIIGGTopeFij_To, AV40TFAplIIGGExenCon, AV41TFAplIIGGExenCon_Sels, AV72TFAplIIGGPrrtear_Sels, AV47TFAplIIGGCondicion, AV48TFAplIIGGCondicion_Sels, AV87TFAplIIGGRelRef, AV88TFAplIIGGRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV62CliCod, AV55IsAuthorized_Update, AV57IsAuthorized_Delete, AV79WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg = AV64TFAplIIGG ;
      AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to = AV65TFAplIIGG_To ;
      AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = AV23TFAplIIGGNom ;
      AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = AV24TFAplIIGGNom_Sels ;
      AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = AV26TFAplIIGGTrat_Sels ;
      AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = AV27TFAplIIGGPropor ;
      AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = AV28TFAplIIGGPropor_To ;
      AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = AV30TFAplIIGGTopeTip_Sels ;
      AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = AV35TFAplIIGGTopeCon ;
      AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = AV36TFAplIIGGTopeCon_Sels ;
      AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = AV37TFAplIIGGTopeFij ;
      AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = AV38TFAplIIGGTopeFij_To ;
      AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = AV40TFAplIIGGExenCon ;
      AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = AV41TFAplIIGGExenCon_Sels ;
      AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = AV72TFAplIIGGPrrtear_Sels ;
      AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = AV47TFAplIIGGCondicion ;
      AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = AV48TFAplIIGGCondicion_Sels ;
      AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = AV87TFAplIIGGRelRef ;
      AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = AV88TFAplIIGGRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV91ManageFiltersExecutionStep, AV19ColumnsSelector, AV104Pgmname, AV77MenuOpcCod, AV12GridState, AV64TFAplIIGG, AV65TFAplIIGG_To, AV23TFAplIIGGNom, AV24TFAplIIGGNom_Sels, AV26TFAplIIGGTrat_Sels, AV27TFAplIIGGPropor, AV28TFAplIIGGPropor_To, AV30TFAplIIGGTopeTip_Sels, AV35TFAplIIGGTopeCon, AV36TFAplIIGGTopeCon_Sels, AV37TFAplIIGGTopeFij, AV38TFAplIIGGTopeFij_To, AV40TFAplIIGGExenCon, AV41TFAplIIGGExenCon_Sels, AV72TFAplIIGGPrrtear_Sels, AV47TFAplIIGGCondicion, AV48TFAplIIGGCondicion_Sels, AV87TFAplIIGGRelRef, AV88TFAplIIGGRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV62CliCod, AV55IsAuthorized_Update, AV57IsAuthorized_Delete, AV79WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg = AV64TFAplIIGG ;
      AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to = AV65TFAplIIGG_To ;
      AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = AV23TFAplIIGGNom ;
      AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = AV24TFAplIIGGNom_Sels ;
      AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = AV26TFAplIIGGTrat_Sels ;
      AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = AV27TFAplIIGGPropor ;
      AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = AV28TFAplIIGGPropor_To ;
      AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = AV30TFAplIIGGTopeTip_Sels ;
      AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = AV35TFAplIIGGTopeCon ;
      AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = AV36TFAplIIGGTopeCon_Sels ;
      AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = AV37TFAplIIGGTopeFij ;
      AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = AV38TFAplIIGGTopeFij_To ;
      AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = AV40TFAplIIGGExenCon ;
      AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = AV41TFAplIIGGExenCon_Sels ;
      AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = AV72TFAplIIGGPrrtear_Sels ;
      AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = AV47TFAplIIGGCondicion ;
      AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = AV48TFAplIIGGCondicion_Sels ;
      AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = AV87TFAplIIGGRelRef ;
      AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = AV88TFAplIIGGRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV91ManageFiltersExecutionStep, AV19ColumnsSelector, AV104Pgmname, AV77MenuOpcCod, AV12GridState, AV64TFAplIIGG, AV65TFAplIIGG_To, AV23TFAplIIGGNom, AV24TFAplIIGGNom_Sels, AV26TFAplIIGGTrat_Sels, AV27TFAplIIGGPropor, AV28TFAplIIGGPropor_To, AV30TFAplIIGGTopeTip_Sels, AV35TFAplIIGGTopeCon, AV36TFAplIIGGTopeCon_Sels, AV37TFAplIIGGTopeFij, AV38TFAplIIGGTopeFij_To, AV40TFAplIIGGExenCon, AV41TFAplIIGGExenCon_Sels, AV72TFAplIIGGPrrtear_Sels, AV47TFAplIIGGCondicion, AV48TFAplIIGGCondicion_Sels, AV87TFAplIIGGRelRef, AV88TFAplIIGGRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV62CliCod, AV55IsAuthorized_Update, AV57IsAuthorized_Delete, AV79WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV104Pgmname = "tipo_aplicacion_gananciasWW" ;
      Gx_err = (short)(0) ;
      edtavOpeclidescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpeclidescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpeclidescrip_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupBQ0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e18BQ2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV49DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV19ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV89ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_110 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_110"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV51GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV52GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV53GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV62CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Buttonexport1_a3lexport_Observer = httpContext.cgiGet( "BUTTONEXPORT1_A3LEXPORT_Observer") ;
         Buttonexport1_a3lexport_Boton_clon_id = httpContext.cgiGet( "BUTTONEXPORT1_A3LEXPORT_Boton_clon_id") ;
         Buttonexport1_a3lexport_Boton_orig_id = httpContext.cgiGet( "BUTTONEXPORT1_A3LEXPORT_Boton_orig_id") ;
         Ddo_gridcolumnsselector_Icontype = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Icontype") ;
         Ddo_gridcolumnsselector_Icon = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Icon") ;
         Ddo_gridcolumnsselector_Caption = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Caption") ;
         Ddo_gridcolumnsselector_Tooltip = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Tooltip") ;
         Ddo_gridcolumnsselector_Cls = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Cls") ;
         Ddo_gridcolumnsselector_Dropdownoptionstype = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype") ;
         Ddo_gridcolumnsselector_Gridinternalname = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Gridinternalname") ;
         Ddo_managefilters_Icontype = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icontype") ;
         Ddo_managefilters_Icon = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icon") ;
         Ddo_managefilters_Tooltip = httpContext.cgiGet( "DDO_MANAGEFILTERS_Tooltip") ;
         Ddo_managefilters_Cls = httpContext.cgiGet( "DDO_MANAGEFILTERS_Cls") ;
         Buttonfilter1_a3lfilter_Observer = httpContext.cgiGet( "BUTTONFILTER1_A3LFILTER_Observer") ;
         Buttonfilter1_a3lfilter_A3l_filter_id = httpContext.cgiGet( "BUTTONFILTER1_A3LFILTER_A3l_filter_id") ;
         Buttonfilter1_a3lfilter_Filter_orig = httpContext.cgiGet( "BUTTONFILTER1_A3LFILTER_Filter_orig") ;
         Gridpaginationbar_Class = httpContext.cgiGet( "GRIDPAGINATIONBAR_Class") ;
         Gridpaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showfirst")) ;
         Gridpaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showprevious")) ;
         Gridpaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Shownext")) ;
         Gridpaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showlast")) ;
         Gridpaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagestoshow"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridpaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingcaptionposition") ;
         Gridpaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridclass") ;
         Gridpaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselector")) ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageoptions") ;
         Gridpaginationbar_Previous = httpContext.cgiGet( "GRIDPAGINATIONBAR_Previous") ;
         Gridpaginationbar_Next = httpContext.cgiGet( "GRIDPAGINATIONBAR_Next") ;
         Gridpaginationbar_Caption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Caption") ;
         Gridpaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridcaption") ;
         Gridpaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpagecaption") ;
         Ddo_grid_Caption = httpContext.cgiGet( "DDO_GRID_Caption") ;
         Ddo_grid_Filteredtext_set = httpContext.cgiGet( "DDO_GRID_Filteredtext_set") ;
         Ddo_grid_Filteredtextto_set = httpContext.cgiGet( "DDO_GRID_Filteredtextto_set") ;
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( "DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Fixable = httpContext.cgiGet( "DDO_GRID_Fixable") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( "DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( "DDO_GRID_Filtertype") ;
         Ddo_grid_Filterisrange = httpContext.cgiGet( "DDO_GRID_Filterisrange") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( "DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( "DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( "DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistfixedvalues = httpContext.cgiGet( "DDO_GRID_Datalistfixedvalues") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( "DDO_GRID_Datalistproc") ;
         Ddo_grid_Format = httpContext.cgiGet( "DDO_GRID_Format") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         Grid_empowerer_Hascolumnsselector = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hascolumnsselector")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( "DDO_GRID_Filteredtextto_get") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( "DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( "DDO_GRID_Selectedcolumn") ;
         Ddo_gridcolumnsselector_Columnsselectorvalues = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( "DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
         AV85WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV79WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV79WelcomeMessage_NoMostrarMas", AV79WelcomeMessage_NoMostrarMas);
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
      e18BQ2 ();
      if (returnInSub) return;
   }

   public void e18BQ2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV77MenuOpcCod, "", "") ;
      GXt_int1 = AV62CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV62CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV62CliCod), "ZZZZZ9")));
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      if ( GXutil.strcmp(AV9HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( "Tratamientos de exención IIGG", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV14OrderedBy < 1 )
      {
         AV14OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV49DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV49DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV80MenuBienveImgURL ;
      GXv_char6[0] = AV82MenuBienveTitulo ;
      GXv_char7[0] = AV83MenuBienveTexto ;
      GXv_boolean8[0] = AV84MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV77MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      tipo_aplicacion_gananciasww_impl.this.AV80MenuBienveImgURL = GXv_char5[0] ;
      tipo_aplicacion_gananciasww_impl.this.AV82MenuBienveTitulo = GXv_char6[0] ;
      tipo_aplicacion_gananciasww_impl.this.AV83MenuBienveTexto = GXv_char7[0] ;
      tipo_aplicacion_gananciasww_impl.this.AV84MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV84MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV84MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV82MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV83MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV85WelcomeMessage_Foto = AV80MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV85WelcomeMessage_Foto)==0) ? AV103Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV85WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV85WelcomeMessage_Foto), true);
         AV103Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV80MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV85WelcomeMessage_Foto)==0) ? AV103Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV85WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV85WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV100observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV100observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV100observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV100observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
   }

   public void e19BQ2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV62CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV62CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV62CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext11[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext11) ;
      AV6WWPContext = GXv_SdtWWPContext11[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV91ManageFiltersExecutionStep == 1 )
      {
         AV91ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV91ManageFiltersExecutionStep", GXutil.str( AV91ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV91ManageFiltersExecutionStep == 2 )
      {
         AV91ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV91ManageFiltersExecutionStep", GXutil.str( AV91ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV21Session.getValue("tipo_aplicacion_gananciasWWColumnsSelector"), "") != 0 )
      {
         AV17ColumnsSelectorXML = AV21Session.getValue("tipo_aplicacion_gananciasWWColumnsSelector") ;
         AV19ColumnsSelector.fromxml(AV17ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtAplIIGG_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGG_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGG_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtAplIIGGNom_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGNom_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGNom_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbAplIIGGTrat.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGTrat.getInternalname(), "Visible", GXutil.ltrimstr( cmbAplIIGGTrat.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtAplIIGGPropor_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGPropor_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGPropor_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbAplIIGGTopeTip.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGTopeTip.getInternalname(), "Visible", GXutil.ltrimstr( cmbAplIIGGTopeTip.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtavOpeclidescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpeclidescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpeclidescrip_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtAplIIGGTopeCon_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGTopeCon_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGTopeCon_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtAplIIGGTopeFij_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGTopeFij_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGTopeFij_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtAplIIGGExenCon_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGExenCon_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGExenCon_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbAplIIGGPrrtear.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGPrrtear.getInternalname(), "Visible", GXutil.ltrimstr( cmbAplIIGGPrrtear.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtAplIIGGCondicion_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGCondicion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGCondicion_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtAplIIGGRelRef_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGRelRef_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGRelRef_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      AV51GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51GridCurrentPage), 10, 0));
      AV52GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52GridPageCount), 10, 0));
      GXt_char10 = AV53GridAppliedFilters ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV104Pgmname, GXv_char7) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV53GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53GridAppliedFilters", AV53GridAppliedFilters);
      GXt_char10 = AV96MenuOpcTitulo ;
      GXv_char7[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV77MenuOpcCod, GXv_char7) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV96MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV96MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV96MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int12[0] = (short)(AV98filterCount) ;
      GXv_char7[0] = AV99filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int12, GXv_char7) ;
      tipo_aplicacion_gananciasww_impl.this.AV98filterCount = GXv_int12[0] ;
      tipo_aplicacion_gananciasww_impl.this.AV99filtrosTexto = GXv_char7[0] ;
      if ( AV98filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV98filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV99filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg = AV64TFAplIIGG ;
      AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to = AV65TFAplIIGG_To ;
      AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = AV23TFAplIIGGNom ;
      AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = AV24TFAplIIGGNom_Sels ;
      AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = AV26TFAplIIGGTrat_Sels ;
      AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = AV27TFAplIIGGPropor ;
      AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = AV28TFAplIIGGPropor_To ;
      AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = AV30TFAplIIGGTopeTip_Sels ;
      AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = AV35TFAplIIGGTopeCon ;
      AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = AV36TFAplIIGGTopeCon_Sels ;
      AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = AV37TFAplIIGGTopeFij ;
      AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = AV38TFAplIIGGTopeFij_To ;
      AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = AV40TFAplIIGGExenCon ;
      AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = AV41TFAplIIGGExenCon_Sels ;
      AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = AV72TFAplIIGGPrrtear_Sels ;
      AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = AV47TFAplIIGGCondicion ;
      AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = AV48TFAplIIGGCondicion_Sels ;
      AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = AV87TFAplIIGGRelRef ;
      AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = AV88TFAplIIGGRelRef_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89ManageFiltersData", AV89ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV88TFAplIIGGRelRef_Sels", AV88TFAplIIGGRelRef_Sels);
   }

   public void e13BQ2( )
   {
      /* Gridpaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgrid_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Next") == 0 )
      {
         subgrid_nextpage( ) ;
      }
      else
      {
         AV50PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV50PageToGo) ;
      }
   }

   public void e14BQ2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15BQ2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV14OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
         AV15OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedDsc", AV15OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AplIIGG") == 0 )
         {
            AV64TFAplIIGG = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFAplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV64TFAplIIGG), 4, 0));
            AV65TFAplIIGG_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFAplIIGG_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65TFAplIIGG_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AplIIGGNom") == 0 )
         {
            AV23TFAplIIGGNom = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFAplIIGGNom", AV23TFAplIIGGNom);
            AV22TFAplIIGGNom_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFAplIIGGNom_SelsJson", AV22TFAplIIGGNom_SelsJson);
            AV24TFAplIIGGNom_Sels.fromJSonString(AV22TFAplIIGGNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AplIIGGTrat") == 0 )
         {
            AV25TFAplIIGGTrat_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFAplIIGGTrat_SelsJson", AV25TFAplIIGGTrat_SelsJson);
            AV26TFAplIIGGTrat_Sels.fromJSonString(GXutil.strReplace( AV25TFAplIIGGTrat_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AplIIGGPropor") == 0 )
         {
            AV27TFAplIIGGPropor = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFAplIIGGPropor", GXutil.ltrimstr( AV27TFAplIIGGPropor, 6, 4));
            AV28TFAplIIGGPropor_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFAplIIGGPropor_To", GXutil.ltrimstr( AV28TFAplIIGGPropor_To, 6, 4));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AplIIGGTopeTip") == 0 )
         {
            AV29TFAplIIGGTopeTip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFAplIIGGTopeTip_SelsJson", AV29TFAplIIGGTopeTip_SelsJson);
            AV30TFAplIIGGTopeTip_Sels.fromJSonString(GXutil.strReplace( AV29TFAplIIGGTopeTip_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AplIIGGTopeCon") == 0 )
         {
            AV35TFAplIIGGTopeCon = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFAplIIGGTopeCon", AV35TFAplIIGGTopeCon);
            AV34TFAplIIGGTopeCon_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFAplIIGGTopeCon_SelsJson", AV34TFAplIIGGTopeCon_SelsJson);
            AV36TFAplIIGGTopeCon_Sels.fromJSonString(AV34TFAplIIGGTopeCon_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AplIIGGTopeFij") == 0 )
         {
            AV37TFAplIIGGTopeFij = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFAplIIGGTopeFij", GXutil.ltrimstr( AV37TFAplIIGGTopeFij, 14, 2));
            AV38TFAplIIGGTopeFij_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFAplIIGGTopeFij_To", GXutil.ltrimstr( AV38TFAplIIGGTopeFij_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AplIIGGExenCon") == 0 )
         {
            AV40TFAplIIGGExenCon = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFAplIIGGExenCon", AV40TFAplIIGGExenCon);
            AV39TFAplIIGGExenCon_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFAplIIGGExenCon_SelsJson", AV39TFAplIIGGExenCon_SelsJson);
            AV41TFAplIIGGExenCon_Sels.fromJSonString(AV39TFAplIIGGExenCon_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AplIIGGPrrtear") == 0 )
         {
            AV71TFAplIIGGPrrtear_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFAplIIGGPrrtear_SelsJson", AV71TFAplIIGGPrrtear_SelsJson);
            AV72TFAplIIGGPrrtear_Sels.fromJSonString(AV71TFAplIIGGPrrtear_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AplIIGGCondicion") == 0 )
         {
            AV47TFAplIIGGCondicion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFAplIIGGCondicion", AV47TFAplIIGGCondicion);
            AV46TFAplIIGGCondicion_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFAplIIGGCondicion_SelsJson", AV46TFAplIIGGCondicion_SelsJson);
            AV48TFAplIIGGCondicion_Sels.fromJSonString(AV46TFAplIIGGCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AplIIGGRelRef") == 0 )
         {
            AV87TFAplIIGGRelRef = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV87TFAplIIGGRelRef", AV87TFAplIIGGRelRef);
            AV86TFAplIIGGRelRef_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV86TFAplIIGGRelRef_SelsJson", AV86TFAplIIGGRelRef_SelsJson);
            AV88TFAplIIGGRelRef_Sels.fromJSonString(AV86TFAplIIGGRelRef_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV88TFAplIIGGRelRef_Sels", AV88TFAplIIGGRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV48TFAplIIGGCondicion_Sels", AV48TFAplIIGGCondicion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV72TFAplIIGGPrrtear_Sels", AV72TFAplIIGGPrrtear_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41TFAplIIGGExenCon_Sels", AV41TFAplIIGGExenCon_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV36TFAplIIGGTopeCon_Sels", AV36TFAplIIGGTopeCon_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFAplIIGGTopeTip_Sels", AV30TFAplIIGGTopeTip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV26TFAplIIGGTrat_Sels", AV26TFAplIIGGTrat_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24TFAplIIGGNom_Sels", AV24TFAplIIGGNom_Sels);
   }

   private void e20BQ2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV54Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV54Update);
      if ( AV55IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.tipo_aplicacion_ganancias", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1112AplIIGG,4,0))}, new String[] {"Mode","CliCod","AplIIGG"})  ;
      }
      AV56Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV56Delete);
      if ( AV57IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("web.tipo_aplicacion_ganancias", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1112AplIIGG,4,0))}, new String[] {"Mode","CliCod","AplIIGG"})  ;
      }
      AV76Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV76Display);
      edtavDisplay_Link = formatLink("web.tipo_aplicacion_gananciasview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1112AplIIGG,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","AplIIGG","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV73VerSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV73VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV73VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char10 = AV74ModificarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char7) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV74ModificarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV74ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char10 = AV75EliminarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char7) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV75EliminarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV75EliminarSVG);
      edtavEliminarsvg_Link = edtavDelete_Link ;
      edtavDelete_Visible = 0 ;
      GXv_char7[0] = AV66OpeCliDescrip ;
      new web.getopeclidescrip(remoteHandle, context).execute( AV62CliCod, A1109AplIIGGTopeVar, GXv_char7) ;
      tipo_aplicacion_gananciasww_impl.this.AV66OpeCliDescrip = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, edtavOpeclidescrip_Internalname, AV66OpeCliDescrip);
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(110) ;
      }
      sendrow_1102( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_110_Refreshing )
      {
         httpContext.doAjaxLoad(110, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e11BQ2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV17ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV19ColumnsSelector.fromJSonString(AV17ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "tipo_aplicacion_gananciasWWColumnsSelector", ((GXutil.strcmp("", AV17ColumnsSelectorXML)==0) ? "" : AV19ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89ManageFiltersData", AV89ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV88TFAplIIGGRelRef_Sels", AV88TFAplIIGGRelRef_Sels);
   }

   public void e12BQ2( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S182 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S162 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("tipo_aplicacion_gananciasWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV104Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV91ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV91ManageFiltersExecutionStep", GXutil.str( AV91ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("tipo_aplicacion_gananciasWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV91ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV91ManageFiltersExecutionStep", GXutil.str( AV91ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char10 = AV90ManageFiltersXml ;
         GXv_char7[0] = GXt_char10 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "tipo_aplicacion_gananciasWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         tipo_aplicacion_gananciasww_impl.this.GXt_char10 = GXv_char7[0] ;
         AV90ManageFiltersXml = GXt_char10 ;
         if ( (GXutil.strcmp("", AV90ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV104Pgmname+"GridState", AV90ManageFiltersXml) ;
            AV12GridState.fromxml(AV90ManageFiltersXml, null, null);
            AV14OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
            AV15OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedDsc", AV15OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S192 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24TFAplIIGGNom_Sels", AV24TFAplIIGGNom_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV26TFAplIIGGTrat_Sels", AV26TFAplIIGGTrat_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFAplIIGGTopeTip_Sels", AV30TFAplIIGGTopeTip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV36TFAplIIGGTopeCon_Sels", AV36TFAplIIGGTopeCon_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41TFAplIIGGExenCon_Sels", AV41TFAplIIGGExenCon_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV72TFAplIIGGPrrtear_Sels", AV72TFAplIIGGPrrtear_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV48TFAplIIGGCondicion_Sels", AV48TFAplIIGGCondicion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV88TFAplIIGGRelRef_Sels", AV88TFAplIIGGRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89ManageFiltersData", AV89ManageFiltersData);
   }

   public void e16BQ2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV69ExcelFilename ;
      GXv_char6[0] = AV70ErrorMessage ;
      new web.tipo_aplicacion_gananciaswwexport(remoteHandle, context).execute( GXv_char7, GXv_char6) ;
      tipo_aplicacion_gananciasww_impl.this.AV69ExcelFilename = GXv_char7[0] ;
      tipo_aplicacion_gananciasww_impl.this.AV70ErrorMessage = GXv_char6[0] ;
      if ( GXutil.strcmp(AV69ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV69ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV70ErrorMessage);
      }
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV14OrderedBy, 4, 0))+":"+(AV15OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S172( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV19ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "AplIIGG", "", "Nro.", false, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "AplIIGGNom", "", "Descripción", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "AplIIGGTrat", "", "Tratamiento específico", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "AplIIGGPropor", "", "Proporción del tope (1 =100%)", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "AplIIGGTopeTip", "", "Tipo de tope", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&OpeCliDescrip", "", "Variable para tope", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "AplIIGGTopeCon", "", "Concepto para tope", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "AplIIGGTopeFij", "", "Tope fijo", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "AplIIGGExenCon", "", "Concepto exento agrupador para F1357", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "AplIIGGPrrtear", "", "Tipo de cuota", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "AplIIGGCondicion", "", "Condición a cumplir para exención", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV62CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "AplIIGGRelRef", "", "Liberación", true, "") ;
         AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "", "", "", false, "") ;
         AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
         AV87TFAplIIGGRelRef = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV87TFAplIIGGRelRef", AV87TFAplIIGGRelRef);
         AV88TFAplIIGGRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      }
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&VerSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&ModificarSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&EliminarSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXt_char10 = AV18UserCustomValue ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "tipo_aplicacion_gananciasWWColumnsSelector", GXv_char7) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV18UserCustomValue = GXt_char10 ;
      if ( ! ( (GXutil.strcmp("", AV18UserCustomValue)==0) ) )
      {
         AV20ColumnsSelectorAux.fromxml(AV18UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, GXv_SdtWWPColumnsSelector14) ;
         AV20ColumnsSelectorAux = GXv_SdtWWPColumnsSelector13[0] ;
         AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV62CliCod, GXv_SdtWWPColumnsSelector14) ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean15 = AV55IsAuthorized_Update ;
      GXv_boolean8[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_aplicacion_ganancias_Update", GXv_boolean8) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_boolean15 = GXv_boolean8[0] ;
      AV55IsAuthorized_Update = GXt_boolean15 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55IsAuthorized_Update", AV55IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV55IsAuthorized_Update));
      if ( ! ( AV55IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean15 = AV57IsAuthorized_Delete ;
      GXv_boolean8[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_aplicacion_ganancias_Delete", GXv_boolean8) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_boolean15 = GXv_boolean8[0] ;
      AV57IsAuthorized_Delete = GXt_boolean15 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57IsAuthorized_Delete", AV57IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV57IsAuthorized_Delete));
      if ( ! ( AV57IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean15 = AV61TempBoolean ;
      GXv_boolean8[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_aplicacion_ganancias_Insert", GXv_boolean8) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_boolean15 = GXv_boolean8[0] ;
      AV61TempBoolean = GXt_boolean15 ;
      if ( ! ( AV61TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = AV89ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "tipo_aplicacion_gananciasWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] ;
      AV89ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV64TFAplIIGG = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64TFAplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV64TFAplIIGG), 4, 0));
      AV65TFAplIIGG_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65TFAplIIGG_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65TFAplIIGG_To), 4, 0));
      AV23TFAplIIGGNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23TFAplIIGGNom", AV23TFAplIIGGNom);
      AV24TFAplIIGGNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26TFAplIIGGTrat_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV27TFAplIIGGPropor = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFAplIIGGPropor", GXutil.ltrimstr( AV27TFAplIIGGPropor, 6, 4));
      AV28TFAplIIGGPropor_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFAplIIGGPropor_To", GXutil.ltrimstr( AV28TFAplIIGGPropor_To, 6, 4));
      AV30TFAplIIGGTopeTip_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV35TFAplIIGGTopeCon = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFAplIIGGTopeCon", AV35TFAplIIGGTopeCon);
      AV36TFAplIIGGTopeCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV37TFAplIIGGTopeFij = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFAplIIGGTopeFij", GXutil.ltrimstr( AV37TFAplIIGGTopeFij, 14, 2));
      AV38TFAplIIGGTopeFij_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFAplIIGGTopeFij_To", GXutil.ltrimstr( AV38TFAplIIGGTopeFij_To, 14, 2));
      AV40TFAplIIGGExenCon = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFAplIIGGExenCon", AV40TFAplIIGGExenCon);
      AV41TFAplIIGGExenCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV72TFAplIIGGPrrtear_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV47TFAplIIGGCondicion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47TFAplIIGGCondicion", AV47TFAplIIGGCondicion);
      AV48TFAplIIGGCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV87TFAplIIGGRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV87TFAplIIGGRelRef", AV87TFAplIIGGRelRef);
      AV88TFAplIIGGRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue(AV104Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV104Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV21Session.getValue(AV104Pgmname+"GridState"), null, null);
      }
      AV14OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
      AV15OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedDsc", AV15OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S192 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV12GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV12GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV12GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S192( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV124GXV1 = 1 ;
      while ( AV124GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV124GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGG") == 0 )
         {
            AV64TFAplIIGG = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFAplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV64TFAplIIGG), 4, 0));
            AV65TFAplIIGG_To = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFAplIIGG_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65TFAplIIGG_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGNOM") == 0 )
         {
            AV23TFAplIIGGNom = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFAplIIGGNom", AV23TFAplIIGGNom);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGNOM_SEL") == 0 )
         {
            AV22TFAplIIGGNom_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFAplIIGGNom_SelsJson", AV22TFAplIIGGNom_SelsJson);
            AV24TFAplIIGGNom_Sels.fromJSonString(AV22TFAplIIGGNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTRAT_SEL") == 0 )
         {
            AV25TFAplIIGGTrat_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFAplIIGGTrat_SelsJson", AV25TFAplIIGGTrat_SelsJson);
            AV26TFAplIIGGTrat_Sels.fromJSonString(AV25TFAplIIGGTrat_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGPROPOR") == 0 )
         {
            AV27TFAplIIGGPropor = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFAplIIGGPropor", GXutil.ltrimstr( AV27TFAplIIGGPropor, 6, 4));
            AV28TFAplIIGGPropor_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFAplIIGGPropor_To", GXutil.ltrimstr( AV28TFAplIIGGPropor_To, 6, 4));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTOPETIP_SEL") == 0 )
         {
            AV29TFAplIIGGTopeTip_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFAplIIGGTopeTip_SelsJson", AV29TFAplIIGGTopeTip_SelsJson);
            AV30TFAplIIGGTopeTip_Sels.fromJSonString(AV29TFAplIIGGTopeTip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTOPECON") == 0 )
         {
            AV35TFAplIIGGTopeCon = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFAplIIGGTopeCon", AV35TFAplIIGGTopeCon);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTOPECON_SEL") == 0 )
         {
            AV34TFAplIIGGTopeCon_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFAplIIGGTopeCon_SelsJson", AV34TFAplIIGGTopeCon_SelsJson);
            AV36TFAplIIGGTopeCon_Sels.fromJSonString(AV34TFAplIIGGTopeCon_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTOPEFIJ") == 0 )
         {
            AV37TFAplIIGGTopeFij = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFAplIIGGTopeFij", GXutil.ltrimstr( AV37TFAplIIGGTopeFij, 14, 2));
            AV38TFAplIIGGTopeFij_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFAplIIGGTopeFij_To", GXutil.ltrimstr( AV38TFAplIIGGTopeFij_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGEXENCON") == 0 )
         {
            AV40TFAplIIGGExenCon = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFAplIIGGExenCon", AV40TFAplIIGGExenCon);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGEXENCON_SEL") == 0 )
         {
            AV39TFAplIIGGExenCon_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFAplIIGGExenCon_SelsJson", AV39TFAplIIGGExenCon_SelsJson);
            AV41TFAplIIGGExenCon_Sels.fromJSonString(AV39TFAplIIGGExenCon_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGPRRTEAR_SEL") == 0 )
         {
            AV71TFAplIIGGPrrtear_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFAplIIGGPrrtear_SelsJson", AV71TFAplIIGGPrrtear_SelsJson);
            AV72TFAplIIGGPrrtear_Sels.fromJSonString(AV71TFAplIIGGPrrtear_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGCONDICION") == 0 )
         {
            AV47TFAplIIGGCondicion = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFAplIIGGCondicion", AV47TFAplIIGGCondicion);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGCONDICION_SEL") == 0 )
         {
            AV46TFAplIIGGCondicion_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFAplIIGGCondicion_SelsJson", AV46TFAplIIGGCondicion_SelsJson);
            AV48TFAplIIGGCondicion_Sels.fromJSonString(AV46TFAplIIGGCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGRELREF") == 0 )
         {
            AV87TFAplIIGGRelRef = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV87TFAplIIGGRelRef", AV87TFAplIIGGRelRef);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGRELREF_SEL") == 0 )
         {
            AV86TFAplIIGGRelRef_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV86TFAplIIGGRelRef_SelsJson", AV86TFAplIIGGRelRef_SelsJson);
            AV88TFAplIIGGRelRef_Sels.fromJSonString(AV86TFAplIIGGRelRef_SelsJson, null);
         }
         AV124GXV1 = (int)(AV124GXV1+1) ;
      }
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV24TFAplIIGGNom_Sels.size()==0), AV22TFAplIIGGNom_SelsJson, GXv_char7) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV36TFAplIIGGTopeCon_Sels.size()==0), AV34TFAplIIGGTopeCon_SelsJson, GXv_char6) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char9 = GXv_char6[0] ;
      GXt_char18 = "" ;
      GXv_char5[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV41TFAplIIGGExenCon_Sels.size()==0), AV39TFAplIIGGExenCon_SelsJson, GXv_char5) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char18 = GXv_char5[0] ;
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV72TFAplIIGGPrrtear_Sels.size()==0), AV71TFAplIIGGPrrtear_SelsJson, GXv_char20) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char19 = GXv_char20[0] ;
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV48TFAplIIGGCondicion_Sels.size()==0), AV46TFAplIIGGCondicion_SelsJson, GXv_char22) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char21 = GXv_char22[0] ;
      GXt_char23 = "" ;
      GXv_char24[0] = GXt_char23 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV88TFAplIIGGRelRef_Sels.size()==0), AV86TFAplIIGGRelRef_SelsJson, GXv_char24) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char23 = GXv_char24[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char10+"|"+((AV26TFAplIIGGTrat_Sels.size()==0) ? "" : AV25TFAplIIGGTrat_SelsJson)+"||"+((AV30TFAplIIGGTopeTip_Sels.size()==0) ? "" : AV29TFAplIIGGTopeTip_SelsJson)+"||"+GXt_char9+"||"+GXt_char18+"|"+GXt_char19+"|"+GXt_char21+"|"+GXt_char23 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char23 = "" ;
      GXv_char24[0] = GXt_char23 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV23TFAplIIGGNom)==0), AV23TFAplIIGGNom, GXv_char24) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char23 = GXv_char24[0] ;
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV35TFAplIIGGTopeCon)==0), AV35TFAplIIGGTopeCon, GXv_char22) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char21 = GXv_char22[0] ;
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFAplIIGGExenCon)==0), AV40TFAplIIGGExenCon, GXv_char20) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char19 = GXv_char20[0] ;
      GXt_char18 = "" ;
      GXv_char7[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV47TFAplIIGGCondicion)==0), AV47TFAplIIGGCondicion, GXv_char7) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char18 = GXv_char7[0] ;
      GXt_char10 = "" ;
      GXv_char6[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV87TFAplIIGGRelRef)==0), AV87TFAplIIGGRelRef, GXv_char6) ;
      tipo_aplicacion_gananciasww_impl.this.GXt_char10 = GXv_char6[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV64TFAplIIGG) ? "" : GXutil.str( AV64TFAplIIGG, 4, 0))+"|"+GXt_char23+"||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV27TFAplIIGGPropor)==0) ? "" : GXutil.str( AV27TFAplIIGGPropor, 6, 4))+"|||"+GXt_char21+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFAplIIGGTopeFij)==0) ? "" : GXutil.str( AV37TFAplIIGGTopeFij, 14, 2))+"|"+GXt_char19+"||"+GXt_char18+"|"+GXt_char10 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV65TFAplIIGG_To) ? "" : GXutil.str( AV65TFAplIIGG_To, 4, 0))+"|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFAplIIGGPropor_To)==0) ? "" : GXutil.str( AV28TFAplIIGGPropor_To, 6, 4))+"||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFAplIIGGTopeFij_To)==0) ? "" : GXutil.str( AV38TFAplIIGGTopeFij_To, 14, 2))+"||||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV21Session.getValue(AV104Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFAPLIIGG", httpContext.getMessage( "Nro.", ""), !((0==AV64TFAplIIGG)&&(0==AV65TFAplIIGG_To)), (short)(0), GXutil.trim( GXutil.str( AV64TFAplIIGG, 4, 0)), GXutil.trim( GXutil.str( AV65TFAplIIGG_To, 4, 0))) ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFAPLIIGGNOM", httpContext.getMessage( "Descripción", ""), !(GXutil.strcmp("", AV23TFAplIIGGNom)==0), (short)(0), AV23TFAplIIGGNom, "", !(AV24TFAplIIGGNom_Sels.size()==0), AV24TFAplIIGGNom_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFAPLIIGGTRAT_SEL", httpContext.getMessage( "Tratamiento específico", ""), !(AV26TFAplIIGGTrat_Sels.size()==0), (short)(0), AV26TFAplIIGGTrat_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFAPLIIGGPROPOR", httpContext.getMessage( "Proporción del tope (1 =100%)", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV27TFAplIIGGPropor)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFAplIIGGPropor_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV27TFAplIIGGPropor, 6, 4)), GXutil.trim( GXutil.str( AV28TFAplIIGGPropor_To, 6, 4))) ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFAPLIIGGTOPETIP_SEL", httpContext.getMessage( "Tipo de tope", ""), !(AV30TFAplIIGGTopeTip_Sels.size()==0), (short)(0), AV30TFAplIIGGTopeTip_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFAPLIIGGTOPECON", httpContext.getMessage( "Concepto para tope", ""), !(GXutil.strcmp("", AV35TFAplIIGGTopeCon)==0), (short)(0), AV35TFAplIIGGTopeCon, "", !(AV36TFAplIIGGTopeCon_Sels.size()==0), AV36TFAplIIGGTopeCon_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFAPLIIGGTOPEFIJ", httpContext.getMessage( "Tope fijo", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFAplIIGGTopeFij)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFAplIIGGTopeFij_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV37TFAplIIGGTopeFij, 14, 2)), GXutil.trim( GXutil.str( AV38TFAplIIGGTopeFij_To, 14, 2))) ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFAPLIIGGEXENCON", httpContext.getMessage( "Concepto exento agrupador para F1357", ""), !(GXutil.strcmp("", AV40TFAplIIGGExenCon)==0), (short)(0), AV40TFAplIIGGExenCon, "", !(AV41TFAplIIGGExenCon_Sels.size()==0), AV41TFAplIIGGExenCon_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFAPLIIGGPRRTEAR_SEL", httpContext.getMessage( "Tipo de cuota", ""), !(AV72TFAplIIGGPrrtear_Sels.size()==0), (short)(0), AV72TFAplIIGGPrrtear_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFAPLIIGGCONDICION", httpContext.getMessage( "Condición a cumplir para exención", ""), !(GXutil.strcmp("", AV47TFAplIIGGCondicion)==0), (short)(0), AV47TFAplIIGGCondicion, "", !(AV48TFAplIIGGCondicion_Sels.size()==0), AV48TFAplIIGGCondicion_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      GXv_SdtWWPGridState25[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState25, "TFAPLIIGGRELREF", httpContext.getMessage( "Liberación", ""), !(GXutil.strcmp("", AV87TFAplIIGGRelRef)==0), (short)(0), AV87TFAplIIGGRelRef, "", !(AV88TFAplIIGGRelRef_Sels.size()==0), AV88TFAplIIGGRelRef_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState25[0] ;
      if ( ! (GXutil.strcmp("", AV77MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV77MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV104Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV104Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "tipo_aplicacion_ganancias" );
      AV21Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e17BQ2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV79WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV77MenuOpcCod, GXv_boolean8) ;
         GXv_char24[0] = AV81textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV62CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char24) ;
         tipo_aplicacion_gananciasww_impl.this.AV81textoNoMostrara = GXv_char24[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV81textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV77MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_BQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_BQ2( true) ;
      }
      else
      {
         wb_table2_12_BQ2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_BQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_BQ2e( true) ;
      }
      else
      {
         wb_table1_9_BQ2e( false) ;
      }
   }

   public void wb_table2_12_BQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablepadding_Internalname, tblTablepadding_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableparent_Internalname, divWelcomemessage_welcometableparent_Visible, 0, "px", 0, "px", "WelcomeTableParent", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableprincipal_Internalname, 1, 0, "px", 0, "px", "WelcomeHeaderItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tableclose_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e21bq1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_tipo_aplicacion_gananciasWW.htm");
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
         AV85WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV85WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV103Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV85WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV85WelcomeMessage_Foto)==0) ? AV103Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV85WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV85WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_tipo_aplicacion_gananciasWW.htm");
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
         wb_table3_30_BQ2( true) ;
      }
      else
      {
         wb_table3_30_BQ2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_BQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_BQ2( true) ;
      }
      else
      {
         wb_table4_35_BQ2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_BQ2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_110_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV79WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_tipo_aplicacion_gananciasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablefiltrospadre_Internalname, 1, 0, "px", 0, "px", "TableFiltrosPadre", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         wb_table5_54_BQ2( true) ;
      }
      else
      {
         wb_table5_54_BQ2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_BQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_BQ2( true) ;
      }
      else
      {
         wb_table6_63_BQ2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_BQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='SectionGrid GridFixedTitles HasGridEmpowerer'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol110( ) ;
      }
      if ( wbEnd == 110 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_110 = (int)(nGXsfl_110_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
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
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridpaginationbar.setProperty("Class", Gridpaginationbar_Class);
         ucGridpaginationbar.setProperty("ShowFirst", Gridpaginationbar_Showfirst);
         ucGridpaginationbar.setProperty("ShowPrevious", Gridpaginationbar_Showprevious);
         ucGridpaginationbar.setProperty("ShowNext", Gridpaginationbar_Shownext);
         ucGridpaginationbar.setProperty("ShowLast", Gridpaginationbar_Showlast);
         ucGridpaginationbar.setProperty("PagesToShow", Gridpaginationbar_Pagestoshow);
         ucGridpaginationbar.setProperty("PagingButtonsPosition", Gridpaginationbar_Pagingbuttonsposition);
         ucGridpaginationbar.setProperty("PagingCaptionPosition", Gridpaginationbar_Pagingcaptionposition);
         ucGridpaginationbar.setProperty("EmptyGridClass", Gridpaginationbar_Emptygridclass);
         ucGridpaginationbar.setProperty("RowsPerPageSelector", Gridpaginationbar_Rowsperpageselector);
         ucGridpaginationbar.setProperty("RowsPerPageOptions", Gridpaginationbar_Rowsperpageoptions);
         ucGridpaginationbar.setProperty("Previous", Gridpaginationbar_Previous);
         ucGridpaginationbar.setProperty("Next", Gridpaginationbar_Next);
         ucGridpaginationbar.setProperty("Caption", Gridpaginationbar_Caption);
         ucGridpaginationbar.setProperty("EmptyGridCaption", Gridpaginationbar_Emptygridcaption);
         ucGridpaginationbar.setProperty("RowsPerPageCaption", Gridpaginationbar_Rowsperpagecaption);
         ucGridpaginationbar.setProperty("CurrentPage", AV51GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV52GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV53GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_BQ2e( true) ;
      }
      else
      {
         wb_table2_12_BQ2e( false) ;
      }
   }

   public void wb_table6_63_BQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablefiltros_Internalname, tblTablefiltros_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_tablecontentbuttonimport_Internalname, 1, 0, "px", 0, "px", "TableContentButtonImport", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_table_svg_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_tipo_aplicacion_gananciasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_table_texto_Internalname, 1, 0, "px", 0, "px", "ML10", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_tipo_aplicacion_gananciasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* User Defined Control */
         ucButtonexport1_a3lexport.render(context, "a3lclonevent", Buttonexport1_a3lexport_Internalname, "BUTTONEXPORT1_A3LEXPORTContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("IconType", Ddo_gridcolumnsselector_Icontype);
         ucDdo_gridcolumnsselector.setProperty("Icon", Ddo_gridcolumnsselector_Icon);
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV49DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV19ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV89ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 7, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e22bq1_client"+"'", TempTags, "", 2, "HLP_tipo_aplicacion_gananciasWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_tipo_aplicacion_gananciasWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_tablecontent_Internalname, divButtonfilter1_tablecontent_Visible, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_filtros_Internalname, 1, 0, "px", 0, "px", "TableContentButtonImportFiltros", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_table_svg_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_tipo_aplicacion_gananciasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_table_texto_Internalname, 1, 0, "px", 0, "px", "ML10", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_tipo_aplicacion_gananciasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_99_BQ2( true) ;
      }
      else
      {
         wb_table7_99_BQ2( false) ;
      }
      return  ;
   }

   public void wb_table7_99_BQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* User Defined Control */
         ucButtonfilter1_a3lfilter.render(context, "a3lfilter", Buttonfilter1_a3lfilter_Internalname, "BUTTONFILTER1_A3LFILTERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_63_BQ2e( true) ;
      }
      else
      {
         wb_table6_63_BQ2e( false) ;
      }
   }

   public void wb_table7_99_BQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblButtonfilter1_tablebadge_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblButtonfilter1_tablebadge_Internalname, tblButtonfilter1_tablebadge_Internalname, "", "TableBadge", 0, "", tblButtonfilter1_tablebadge_Tooltiptext, 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_tipo_aplicacion_gananciasWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_99_BQ2e( true) ;
      }
      else
      {
         wb_table7_99_BQ2e( false) ;
      }
   }

   public void wb_table5_54_BQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabletotalregistros_Internalname, tblTabletotalregistros_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabletotal_Internalname, 1, 0, "px", 0, "px", "TotalPill ML15", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_tipo_aplicacion_gananciasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_tipo_aplicacion_gananciasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_BQ2e( true) ;
      }
      else
      {
         wb_table5_54_BQ2e( false) ;
      }
   }

   public void wb_table4_35_BQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_tipo_aplicacion_gananciasWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_BQ2e( true) ;
      }
      else
      {
         wb_table4_35_BQ2e( false) ;
      }
   }

   public void wb_table3_30_BQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_tipo_aplicacion_gananciasWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_BQ2e( true) ;
      }
      else
      {
         wb_table3_30_BQ2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV77MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77MenuOpcCod", AV77MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV77MenuOpcCod, ""))));
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
      paBQ2( ) ;
      wsBQ2( ) ;
      weBQ2( ) ;
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
      httpContext.AddStyleSheetFile("a3lfilter.css", "");
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181782888", true, true);
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
      httpContext.AddJavascriptSource("tipo_aplicacion_gananciasww.js", "?2025181782889", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LClonEventRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LFilterRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_1102( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_110_idx ;
      edtAplIIGG_Internalname = "APLIIGG_"+sGXsfl_110_idx ;
      edtAplIIGGNom_Internalname = "APLIIGGNOM_"+sGXsfl_110_idx ;
      cmbAplIIGGTrat.setInternalname( "APLIIGGTRAT_"+sGXsfl_110_idx );
      edtAplIIGGPropor_Internalname = "APLIIGGPROPOR_"+sGXsfl_110_idx ;
      cmbAplIIGGTopeTip.setInternalname( "APLIIGGTOPETIP_"+sGXsfl_110_idx );
      edtAplIIGGTopeVar_Internalname = "APLIIGGTOPEVAR_"+sGXsfl_110_idx ;
      edtavOpeclidescrip_Internalname = "vOPECLIDESCRIP_"+sGXsfl_110_idx ;
      edtAplIIGGTopeCon_Internalname = "APLIIGGTOPECON_"+sGXsfl_110_idx ;
      edtAplIIGGTopeFij_Internalname = "APLIIGGTOPEFIJ_"+sGXsfl_110_idx ;
      edtAplIIGGExenCon_Internalname = "APLIIGGEXENCON_"+sGXsfl_110_idx ;
      cmbAplIIGGPrrtear.setInternalname( "APLIIGGPRRTEAR_"+sGXsfl_110_idx );
      edtAplIIGGCondicion_Internalname = "APLIIGGCONDICION_"+sGXsfl_110_idx ;
      edtAplIIGGRelRef_Internalname = "APLIIGGRELREF_"+sGXsfl_110_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_110_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_110_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_110_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_110_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_110_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_110_idx ;
   }

   public void subsflControlProps_fel_1102( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_110_fel_idx ;
      edtAplIIGG_Internalname = "APLIIGG_"+sGXsfl_110_fel_idx ;
      edtAplIIGGNom_Internalname = "APLIIGGNOM_"+sGXsfl_110_fel_idx ;
      cmbAplIIGGTrat.setInternalname( "APLIIGGTRAT_"+sGXsfl_110_fel_idx );
      edtAplIIGGPropor_Internalname = "APLIIGGPROPOR_"+sGXsfl_110_fel_idx ;
      cmbAplIIGGTopeTip.setInternalname( "APLIIGGTOPETIP_"+sGXsfl_110_fel_idx );
      edtAplIIGGTopeVar_Internalname = "APLIIGGTOPEVAR_"+sGXsfl_110_fel_idx ;
      edtavOpeclidescrip_Internalname = "vOPECLIDESCRIP_"+sGXsfl_110_fel_idx ;
      edtAplIIGGTopeCon_Internalname = "APLIIGGTOPECON_"+sGXsfl_110_fel_idx ;
      edtAplIIGGTopeFij_Internalname = "APLIIGGTOPEFIJ_"+sGXsfl_110_fel_idx ;
      edtAplIIGGExenCon_Internalname = "APLIIGGEXENCON_"+sGXsfl_110_fel_idx ;
      cmbAplIIGGPrrtear.setInternalname( "APLIIGGPRRTEAR_"+sGXsfl_110_fel_idx );
      edtAplIIGGCondicion_Internalname = "APLIIGGCONDICION_"+sGXsfl_110_fel_idx ;
      edtAplIIGGRelRef_Internalname = "APLIIGGRELREF_"+sGXsfl_110_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_110_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_110_fel_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_110_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_110_fel_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_110_fel_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_110_fel_idx ;
   }

   public void sendrow_1102( )
   {
      subsflControlProps_1102( ) ;
      wbBQ0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_110_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            subGrid_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_110_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_110_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtAplIIGG_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAplIIGG_Internalname,GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1112AplIIGG), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAplIIGG_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtAplIIGG_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtAplIIGGNom_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAplIIGGNom_Internalname,A1113AplIIGGNom,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAplIIGGNom_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtAplIIGGNom_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbAplIIGGTrat.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbAplIIGGTrat.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "APLIIGGTRAT_" + sGXsfl_110_idx ;
            cmbAplIIGGTrat.setName( GXCCtl );
            cmbAplIIGGTrat.setWebtags( "" );
            cmbAplIIGGTrat.addItem(GXutil.trim( GXutil.str( 0, 2, 0)), httpContext.getMessage( "Ninguno", ""), (short)(0));
            cmbAplIIGGTrat.addItem("1", httpContext.getMessage( "Exento horas extras feriados y fines de semana", ""), (short)(0));
            cmbAplIIGGTrat.addItem("2", httpContext.getMessage( "SAC", ""), (short)(0));
            if ( cmbAplIIGGTrat.getItemCount() > 0 )
            {
               A1120AplIIGGTrat = (byte)(GXutil.lval( cmbAplIIGGTrat.getValidValue(GXutil.trim( GXutil.str( A1120AplIIGGTrat, 2, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbAplIIGGTrat,cmbAplIIGGTrat.getInternalname(),GXutil.trim( GXutil.str( A1120AplIIGGTrat, 2, 0)),Integer.valueOf(1),cmbAplIIGGTrat.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbAplIIGGTrat.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbAplIIGGTrat.setValue( GXutil.trim( GXutil.str( A1120AplIIGGTrat, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGTrat.getInternalname(), "Values", cmbAplIIGGTrat.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtAplIIGGPropor_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAplIIGGPropor_Internalname,GXutil.ltrim( localUtil.ntoc( A1114AplIIGGPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1114AplIIGGPropor, "9.9999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAplIIGGPropor_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtAplIIGGPropor_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbAplIIGGTopeTip.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbAplIIGGTopeTip.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "APLIIGGTOPETIP_" + sGXsfl_110_idx ;
            cmbAplIIGGTopeTip.setName( GXCCtl );
            cmbAplIIGGTopeTip.setWebtags( "" );
            cmbAplIIGGTopeTip.addItem(GXutil.trim( GXutil.str( 0, 1, 0)), httpContext.getMessage( "Sin Tope", ""), (short)(0));
            cmbAplIIGGTopeTip.addItem("1", httpContext.getMessage( "Variable", ""), (short)(0));
            cmbAplIIGGTopeTip.addItem("2", httpContext.getMessage( "Concepto", ""), (short)(0));
            cmbAplIIGGTopeTip.addItem("3", httpContext.getMessage( "Valor Fijo", ""), (short)(0));
            if ( cmbAplIIGGTopeTip.getItemCount() > 0 )
            {
               A1115AplIIGGTopeTip = (byte)(GXutil.lval( cmbAplIIGGTopeTip.getValidValue(GXutil.trim( GXutil.str( A1115AplIIGGTopeTip, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbAplIIGGTopeTip,cmbAplIIGGTopeTip.getInternalname(),GXutil.trim( GXutil.str( A1115AplIIGGTopeTip, 1, 0)),Integer.valueOf(1),cmbAplIIGGTopeTip.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbAplIIGGTopeTip.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbAplIIGGTopeTip.setValue( GXutil.trim( GXutil.str( A1115AplIIGGTopeTip, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGTopeTip.getInternalname(), "Values", cmbAplIIGGTopeTip.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAplIIGGTopeVar_Internalname,GXutil.rtrim( A1109AplIIGGTopeVar),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAplIIGGTopeVar_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavOpeclidescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavOpeclidescrip_Internalname,AV66OpeCliDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavOpeclidescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavOpeclidescrip_Visible),Integer.valueOf(edtavOpeclidescrip_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtAplIIGGTopeCon_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAplIIGGTopeCon_Internalname,GXutil.rtrim( A1111AplIIGGTopeCon),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAplIIGGTopeCon_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtAplIIGGTopeCon_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtAplIIGGTopeFij_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAplIIGGTopeFij_Internalname,GXutil.ltrim( localUtil.ntoc( A1119AplIIGGTopeFij, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1119AplIIGGTopeFij, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAplIIGGTopeFij_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtAplIIGGTopeFij_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtAplIIGGExenCon_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAplIIGGExenCon_Internalname,GXutil.rtrim( A1117AplIIGGExenCon),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAplIIGGExenCon_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtAplIIGGExenCon_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbAplIIGGPrrtear.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbAplIIGGPrrtear.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "APLIIGGPRRTEAR_" + sGXsfl_110_idx ;
            cmbAplIIGGPrrtear.setName( GXCCtl );
            cmbAplIIGGPrrtear.setWebtags( "" );
            cmbAplIIGGPrrtear.addItem("SIN", httpContext.getMessage( "Sin cuotas", ""), (short)(0));
            cmbAplIIGGPrrtear.addItem("FIJA", httpContext.getMessage( "Cuota fija", ""), (short)(0));
            cmbAplIIGGPrrtear.addItem("VAR", httpContext.getMessage( "Cuota variable", ""), (short)(0));
            if ( cmbAplIIGGPrrtear.getItemCount() > 0 )
            {
               A1121AplIIGGPrrtear = cmbAplIIGGPrrtear.getValidValue(A1121AplIIGGPrrtear) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbAplIIGGPrrtear,cmbAplIIGGPrrtear.getInternalname(),GXutil.rtrim( A1121AplIIGGPrrtear),Integer.valueOf(1),cmbAplIIGGPrrtear.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbAplIIGGPrrtear.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbAplIIGGPrrtear.setValue( GXutil.rtrim( A1121AplIIGGPrrtear) );
         httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGPrrtear.getInternalname(), "Values", cmbAplIIGGPrrtear.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtAplIIGGCondicion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAplIIGGCondicion_Internalname,GXutil.rtrim( A1124AplIIGGCondicion),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAplIIGGCondicion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtAplIIGGCondicion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtAplIIGGRelRef_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAplIIGGRelRef_Internalname,A2020AplIIGGRelRef,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAplIIGGRelRef_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtAplIIGGRelRef_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV54Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV56Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV76Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV73VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV74ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV75EliminarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesBQ2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_110_idx = ((subGrid_Islastpage==1)&&(nGXsfl_110_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_110_idx+1) ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
      }
      /* End function sendrow_1102 */
   }

   public void startgridcontrol110( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"110\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "GridWithPaginationBar WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            subGrid_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid_Class) > 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Title" ;
            }
         }
         else
         {
            subGrid_Titlebackstyle = (byte)(1) ;
            if ( subGrid_Backcolorstyle == 1 )
            {
               subGrid_Titlebackcolor = subGrid_Allbackcolor ;
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAplIIGG_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nro.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAplIIGGNom_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbAplIIGGTrat.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tratamiento específico", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAplIIGGPropor_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Proporción del tope (1 =100%)", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbAplIIGGTopeTip.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de tope", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavOpeclidescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Variable para tope", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAplIIGGTopeCon_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto para tope", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAplIIGGTopeFij_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tope fijo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAplIIGGExenCon_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto exento agrupador para F1357", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbAplIIGGPrrtear.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de cuota", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAplIIGGCondicion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Condición a cumplir para exención", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAplIIGGRelRef_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liberación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
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
         GridContainer.SetWrapped(nGXWrapped);
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAplIIGG_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1113AplIIGGNom);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAplIIGGNom_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1120AplIIGGTrat, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbAplIIGGTrat.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1114AplIIGGPropor, (byte)(6), (byte)(4), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAplIIGGPropor_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1115AplIIGGTopeTip, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbAplIIGGTopeTip.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1109AplIIGGTopeVar));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV66OpeCliDescrip);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavOpeclidescrip_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavOpeclidescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1111AplIIGGTopeCon));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAplIIGGTopeCon_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1119AplIIGGTopeFij, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAplIIGGTopeFij_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1117AplIIGGExenCon));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAplIIGGExenCon_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1121AplIIGGPrrtear));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbAplIIGGPrrtear.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1124AplIIGGCondicion));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAplIIGGCondicion_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2020AplIIGGRelRef);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAplIIGGRelRef_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV54Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV56Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV76Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV73VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV74ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV75EliminarSVG));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavEliminarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
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
      lblTotaltext_Internalname = "TOTALTEXT" ;
      lblCouttext_Internalname = "COUTTEXT" ;
      divTabletotal_Internalname = "TABLETOTAL" ;
      tblTabletotalregistros_Internalname = "TABLETOTALREGISTROS" ;
      lblButtonexport1_textblock_svg_Internalname = "BUTTONEXPORT1_TEXTBLOCK_SVG" ;
      divButtonexport1_table_svg_Internalname = "BUTTONEXPORT1_TABLE_SVG" ;
      lblButtonexport1_textblock_texto_Internalname = "BUTTONEXPORT1_TEXTBLOCK_TEXTO" ;
      divButtonexport1_table_texto_Internalname = "BUTTONEXPORT1_TABLE_TEXTO" ;
      Buttonexport1_a3lexport_Internalname = "BUTTONEXPORT1_A3LEXPORT" ;
      divButtonexport1_tablecontentbuttonimport_Internalname = "BUTTONEXPORT1_TABLECONTENTBUTTONIMPORT" ;
      Ddo_gridcolumnsselector_Internalname = "DDO_GRIDCOLUMNSSELECTOR" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      bttBtninsert_Internalname = "BTNINSERT" ;
      bttBtnexport_Internalname = "BTNEXPORT" ;
      lblButtonfilter1_textblock_svg_Internalname = "BUTTONFILTER1_TEXTBLOCK_SVG" ;
      divButtonfilter1_table_svg_Internalname = "BUTTONFILTER1_TABLE_SVG" ;
      lblButtonfilter1_textblock_texto_Internalname = "BUTTONFILTER1_TEXTBLOCK_TEXTO" ;
      divButtonfilter1_table_texto_Internalname = "BUTTONFILTER1_TABLE_TEXTO" ;
      lblButtonfilter1_textblockbadgecount_Internalname = "BUTTONFILTER1_TEXTBLOCKBADGECOUNT" ;
      tblButtonfilter1_tablebadge_Internalname = "BUTTONFILTER1_TABLEBADGE" ;
      divButtonfilter1_filtros_Internalname = "BUTTONFILTER1_FILTROS" ;
      Buttonfilter1_a3lfilter_Internalname = "BUTTONFILTER1_A3LFILTER" ;
      divButtonfilter1_tablecontent_Internalname = "BUTTONFILTER1_TABLECONTENT" ;
      tblTablefiltros_Internalname = "TABLEFILTROS" ;
      divTablefiltrospadre_Internalname = "TABLEFILTROSPADRE" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtAplIIGG_Internalname = "APLIIGG" ;
      edtAplIIGGNom_Internalname = "APLIIGGNOM" ;
      cmbAplIIGGTrat.setInternalname( "APLIIGGTRAT" );
      edtAplIIGGPropor_Internalname = "APLIIGGPROPOR" ;
      cmbAplIIGGTopeTip.setInternalname( "APLIIGGTOPETIP" );
      edtAplIIGGTopeVar_Internalname = "APLIIGGTOPEVAR" ;
      edtavOpeclidescrip_Internalname = "vOPECLIDESCRIP" ;
      edtAplIIGGTopeCon_Internalname = "APLIIGGTOPECON" ;
      edtAplIIGGTopeFij_Internalname = "APLIIGGTOPEFIJ" ;
      edtAplIIGGExenCon_Internalname = "APLIIGGEXENCON" ;
      cmbAplIIGGPrrtear.setInternalname( "APLIIGGPRRTEAR" );
      edtAplIIGGCondicion_Internalname = "APLIIGGCONDICION" ;
      edtAplIIGGRelRef_Internalname = "APLIIGGRELREF" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDelete_Internalname = "vDELETE" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavVersvg_Internalname = "vVERSVG" ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG" ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      tblTablepadding_Internalname = "TABLEPADDING" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
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
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Header = "" ;
      edtavEliminarsvg_Jsonclick = "" ;
      edtavEliminarsvg_Link = "" ;
      edtavEliminarsvg_Enabled = 0 ;
      edtavEliminarsvg_Format = (short)(0) ;
      edtavModificarsvg_Jsonclick = "" ;
      edtavModificarsvg_Columnclass = "WWColumn" ;
      edtavModificarsvg_Link = "" ;
      edtavModificarsvg_Enabled = 0 ;
      edtavModificarsvg_Format = (short)(0) ;
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Link = "" ;
      edtavVersvg_Enabled = 0 ;
      edtavVersvg_Format = (short)(0) ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 0 ;
      edtavDisplay_Visible = -1 ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Enabled = 0 ;
      edtAplIIGGRelRef_Jsonclick = "" ;
      edtAplIIGGCondicion_Jsonclick = "" ;
      cmbAplIIGGPrrtear.setJsonclick( "" );
      edtAplIIGGExenCon_Jsonclick = "" ;
      edtAplIIGGTopeFij_Jsonclick = "" ;
      edtAplIIGGTopeCon_Jsonclick = "" ;
      edtavOpeclidescrip_Jsonclick = "" ;
      edtavOpeclidescrip_Enabled = 0 ;
      edtAplIIGGTopeVar_Jsonclick = "" ;
      cmbAplIIGGTopeTip.setJsonclick( "" );
      edtAplIIGGPropor_Jsonclick = "" ;
      cmbAplIIGGTrat.setJsonclick( "" );
      edtAplIIGGNom_Jsonclick = "" ;
      edtAplIIGG_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblCouttext_Visible = 1 ;
      divButtonfilter1_tablecontent_Visible = 1 ;
      bttBtnexport_Visible = 1 ;
      bttBtninsert_Visible = 1 ;
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      edtavDelete_Link = "" ;
      edtavUpdate_Link = "" ;
      edtavDisplay_Link = "" ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      edtavEliminarsvg_Visible = -1 ;
      edtavModificarsvg_Visible = -1 ;
      edtavVersvg_Visible = -1 ;
      edtAplIIGGRelRef_Visible = -1 ;
      edtAplIIGGCondicion_Visible = -1 ;
      cmbAplIIGGPrrtear.setVisible( -1 );
      edtAplIIGGExenCon_Visible = -1 ;
      edtAplIIGGTopeFij_Visible = -1 ;
      edtAplIIGGTopeCon_Visible = -1 ;
      edtavOpeclidescrip_Visible = -1 ;
      cmbAplIIGGTopeTip.setVisible( -1 );
      edtAplIIGGPropor_Visible = -1 ;
      cmbAplIIGGTrat.setVisible( -1 );
      edtAplIIGGNom_Visible = -1 ;
      edtAplIIGG_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "4.0|||6.4||||-14.2||||" ;
      Ddo_grid_Datalistproc = "tipo_aplicacion_gananciasWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||1:Exento horas extras feriados y fines de semana,2:SAC||1:Variable,2:Concepto,3:Valor Fijo|||||SIN:Sin cuotas,FIJA:Cuota fija,VAR:Cuota variable||" ;
      Ddo_grid_Allowmultipleselection = "|T|T||T||T||T|T|T|T" ;
      Ddo_grid_Datalisttype = "|Dynamic|FixedValues||FixedValues||Dynamic||Dynamic|FixedValues|Dynamic|Dynamic" ;
      Ddo_grid_Includedatalist = "|T|T||T||T||T|T|T|T" ;
      Ddo_grid_Filterisrange = "T|||T||||T||||" ;
      Ddo_grid_Filtertype = "Numeric|Character||Numeric|||Character|Numeric|Character||Character|Character" ;
      Ddo_grid_Includefilter = "T|T||T|||T|T|T||T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T||T|T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5||6|7|8|9|10|11" ;
      Ddo_grid_Columnids = "1:AplIIGG|2:AplIIGGNom|3:AplIIGGTrat|4:AplIIGGPropor|5:AplIIGGTopeTip|7:OpeCliDescrip|8:AplIIGGTopeCon|9:AplIIGGTopeFij|10:AplIIGGExenCon|11:AplIIGGPrrtear|12:AplIIGGCondicion|13:AplIIGGRelRef" ;
      Ddo_grid_Gridinternalname = "" ;
      Gridpaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridpaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridpaginationbar_Caption = httpContext.getMessage( "WWP_PagingCaption", "") ;
      Gridpaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridpaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridpaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridpaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridpaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridpaginationbar_Pagingcaptionposition = "Left" ;
      Gridpaginationbar_Pagingbuttonsposition = "Right" ;
      Gridpaginationbar_Pagestoshow = 5 ;
      Gridpaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Class = "PaginationBar" ;
      Buttonfilter1_a3lfilter_Filter_orig = "" ;
      Buttonfilter1_a3lfilter_A3l_filter_id = "" ;
      Buttonfilter1_a3lfilter_Observer = "" ;
      Ddo_managefilters_Cls = "ManageFilters" ;
      Ddo_managefilters_Tooltip = "WWP_ManageFiltersTooltip" ;
      Ddo_managefilters_Icon = "fas fa-filter" ;
      Ddo_managefilters_Icontype = "FontIcon" ;
      Ddo_gridcolumnsselector_Dropdownoptionstype = "GridColumnsSelector" ;
      Ddo_gridcolumnsselector_Cls = "ColumnsSelector" ;
      Ddo_gridcolumnsselector_Tooltip = "WWP_EditColumnsTooltip" ;
      Ddo_gridcolumnsselector_Caption = httpContext.getMessage( "Columnas", "") ;
      Ddo_gridcolumnsselector_Icon = "fas fa-cog" ;
      Ddo_gridcolumnsselector_Icontype = "FontIcon" ;
      Buttonexport1_a3lexport_Boton_orig_id = "" ;
      Buttonexport1_a3lexport_Boton_clon_id = "" ;
      Buttonexport1_a3lexport_Observer = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Tratamientos de exención IIGG", "") );
      subGrid_Rows = 0 ;
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
      AV79WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV79WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79WelcomeMessage_NoMostrarMas", AV79WelcomeMessage_NoMostrarMas);
      GXCCtl = "APLIIGGTRAT_" + sGXsfl_110_idx ;
      cmbAplIIGGTrat.setName( GXCCtl );
      cmbAplIIGGTrat.setWebtags( "" );
      cmbAplIIGGTrat.addItem(GXutil.trim( GXutil.str( 0, 2, 0)), httpContext.getMessage( "Ninguno", ""), (short)(0));
      cmbAplIIGGTrat.addItem("1", httpContext.getMessage( "Exento horas extras feriados y fines de semana", ""), (short)(0));
      cmbAplIIGGTrat.addItem("2", httpContext.getMessage( "SAC", ""), (short)(0));
      if ( cmbAplIIGGTrat.getItemCount() > 0 )
      {
         A1120AplIIGGTrat = (byte)(GXutil.lval( cmbAplIIGGTrat.getValidValue(GXutil.trim( GXutil.str( A1120AplIIGGTrat, 2, 0))))) ;
      }
      GXCCtl = "APLIIGGTOPETIP_" + sGXsfl_110_idx ;
      cmbAplIIGGTopeTip.setName( GXCCtl );
      cmbAplIIGGTopeTip.setWebtags( "" );
      cmbAplIIGGTopeTip.addItem(GXutil.trim( GXutil.str( 0, 1, 0)), httpContext.getMessage( "Sin Tope", ""), (short)(0));
      cmbAplIIGGTopeTip.addItem("1", httpContext.getMessage( "Variable", ""), (short)(0));
      cmbAplIIGGTopeTip.addItem("2", httpContext.getMessage( "Concepto", ""), (short)(0));
      cmbAplIIGGTopeTip.addItem("3", httpContext.getMessage( "Valor Fijo", ""), (short)(0));
      if ( cmbAplIIGGTopeTip.getItemCount() > 0 )
      {
         A1115AplIIGGTopeTip = (byte)(GXutil.lval( cmbAplIIGGTopeTip.getValidValue(GXutil.trim( GXutil.str( A1115AplIIGGTopeTip, 1, 0))))) ;
      }
      GXCCtl = "APLIIGGPRRTEAR_" + sGXsfl_110_idx ;
      cmbAplIIGGPrrtear.setName( GXCCtl );
      cmbAplIIGGPrrtear.setWebtags( "" );
      cmbAplIIGGPrrtear.addItem("SIN", httpContext.getMessage( "Sin cuotas", ""), (short)(0));
      cmbAplIIGGPrrtear.addItem("FIJA", httpContext.getMessage( "Cuota fija", ""), (short)(0));
      cmbAplIIGGPrrtear.addItem("VAR", httpContext.getMessage( "Cuota variable", ""), (short)(0));
      if ( cmbAplIIGGPrrtear.getItemCount() > 0 )
      {
         A1121AplIIGGPrrtear = cmbAplIIGGPrrtear.getValidValue(A1121AplIIGGPrrtear) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV91ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV104Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV77MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV64TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV65TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV23TFAplIIGGNom',fld:'vTFAPLIIGGNOM',pic:''},{av:'AV24TFAplIIGGNom_Sels',fld:'vTFAPLIIGGNOM_SELS',pic:''},{av:'AV26TFAplIIGGTrat_Sels',fld:'vTFAPLIIGGTRAT_SELS',pic:''},{av:'AV27TFAplIIGGPropor',fld:'vTFAPLIIGGPROPOR',pic:'9.9999'},{av:'AV28TFAplIIGGPropor_To',fld:'vTFAPLIIGGPROPOR_TO',pic:'9.9999'},{av:'AV30TFAplIIGGTopeTip_Sels',fld:'vTFAPLIIGGTOPETIP_SELS',pic:''},{av:'AV35TFAplIIGGTopeCon',fld:'vTFAPLIIGGTOPECON',pic:''},{av:'AV36TFAplIIGGTopeCon_Sels',fld:'vTFAPLIIGGTOPECON_SELS',pic:''},{av:'AV37TFAplIIGGTopeFij',fld:'vTFAPLIIGGTOPEFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFAplIIGGTopeFij_To',fld:'vTFAPLIIGGTOPEFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFAplIIGGExenCon',fld:'vTFAPLIIGGEXENCON',pic:''},{av:'AV41TFAplIIGGExenCon_Sels',fld:'vTFAPLIIGGEXENCON_SELS',pic:''},{av:'AV72TFAplIIGGPrrtear_Sels',fld:'vTFAPLIIGGPRRTEAR_SELS',pic:''},{av:'AV47TFAplIIGGCondicion',fld:'vTFAPLIIGGCONDICION',pic:''},{av:'AV48TFAplIIGGCondicion_Sels',fld:'vTFAPLIIGGCONDICION_SELS',pic:''},{av:'AV87TFAplIIGGRelRef',fld:'vTFAPLIIGGRELREF',pic:''},{av:'AV88TFAplIIGGRelRef_Sels',fld:'vTFAPLIIGGRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV62CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV55IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV79WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV62CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV91ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtAplIIGG_Visible',ctrl:'APLIIGG',prop:'Visible'},{av:'edtAplIIGGNom_Visible',ctrl:'APLIIGGNOM',prop:'Visible'},{av:'cmbAplIIGGTrat'},{av:'edtAplIIGGPropor_Visible',ctrl:'APLIIGGPROPOR',prop:'Visible'},{av:'cmbAplIIGGTopeTip'},{av:'edtavOpeclidescrip_Visible',ctrl:'vOPECLIDESCRIP',prop:'Visible'},{av:'edtAplIIGGTopeCon_Visible',ctrl:'APLIIGGTOPECON',prop:'Visible'},{av:'edtAplIIGGTopeFij_Visible',ctrl:'APLIIGGTOPEFIJ',prop:'Visible'},{av:'edtAplIIGGExenCon_Visible',ctrl:'APLIIGGEXENCON',prop:'Visible'},{av:'cmbAplIIGGPrrtear'},{av:'edtAplIIGGCondicion_Visible',ctrl:'APLIIGGCONDICION',prop:'Visible'},{av:'edtAplIIGGRelRef_Visible',ctrl:'APLIIGGRELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV51GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV52GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV53GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV55IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV89ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV87TFAplIIGGRelRef',fld:'vTFAPLIIGGRELREF',pic:''},{av:'AV88TFAplIIGGRelRef_Sels',fld:'vTFAPLIIGGRELREF_SELS',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13BQ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV91ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV104Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV77MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV64TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV65TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV23TFAplIIGGNom',fld:'vTFAPLIIGGNOM',pic:''},{av:'AV24TFAplIIGGNom_Sels',fld:'vTFAPLIIGGNOM_SELS',pic:''},{av:'AV26TFAplIIGGTrat_Sels',fld:'vTFAPLIIGGTRAT_SELS',pic:''},{av:'AV27TFAplIIGGPropor',fld:'vTFAPLIIGGPROPOR',pic:'9.9999'},{av:'AV28TFAplIIGGPropor_To',fld:'vTFAPLIIGGPROPOR_TO',pic:'9.9999'},{av:'AV30TFAplIIGGTopeTip_Sels',fld:'vTFAPLIIGGTOPETIP_SELS',pic:''},{av:'AV35TFAplIIGGTopeCon',fld:'vTFAPLIIGGTOPECON',pic:''},{av:'AV36TFAplIIGGTopeCon_Sels',fld:'vTFAPLIIGGTOPECON_SELS',pic:''},{av:'AV37TFAplIIGGTopeFij',fld:'vTFAPLIIGGTOPEFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFAplIIGGTopeFij_To',fld:'vTFAPLIIGGTOPEFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFAplIIGGExenCon',fld:'vTFAPLIIGGEXENCON',pic:''},{av:'AV41TFAplIIGGExenCon_Sels',fld:'vTFAPLIIGGEXENCON_SELS',pic:''},{av:'AV72TFAplIIGGPrrtear_Sels',fld:'vTFAPLIIGGPRRTEAR_SELS',pic:''},{av:'AV47TFAplIIGGCondicion',fld:'vTFAPLIIGGCONDICION',pic:''},{av:'AV48TFAplIIGGCondicion_Sels',fld:'vTFAPLIIGGCONDICION_SELS',pic:''},{av:'AV87TFAplIIGGRelRef',fld:'vTFAPLIIGGRELREF',pic:''},{av:'AV88TFAplIIGGRelRef_Sels',fld:'vTFAPLIIGGRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV62CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV55IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV79WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14BQ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV91ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV104Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV77MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV64TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV65TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV23TFAplIIGGNom',fld:'vTFAPLIIGGNOM',pic:''},{av:'AV24TFAplIIGGNom_Sels',fld:'vTFAPLIIGGNOM_SELS',pic:''},{av:'AV26TFAplIIGGTrat_Sels',fld:'vTFAPLIIGGTRAT_SELS',pic:''},{av:'AV27TFAplIIGGPropor',fld:'vTFAPLIIGGPROPOR',pic:'9.9999'},{av:'AV28TFAplIIGGPropor_To',fld:'vTFAPLIIGGPROPOR_TO',pic:'9.9999'},{av:'AV30TFAplIIGGTopeTip_Sels',fld:'vTFAPLIIGGTOPETIP_SELS',pic:''},{av:'AV35TFAplIIGGTopeCon',fld:'vTFAPLIIGGTOPECON',pic:''},{av:'AV36TFAplIIGGTopeCon_Sels',fld:'vTFAPLIIGGTOPECON_SELS',pic:''},{av:'AV37TFAplIIGGTopeFij',fld:'vTFAPLIIGGTOPEFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFAplIIGGTopeFij_To',fld:'vTFAPLIIGGTOPEFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFAplIIGGExenCon',fld:'vTFAPLIIGGEXENCON',pic:''},{av:'AV41TFAplIIGGExenCon_Sels',fld:'vTFAPLIIGGEXENCON_SELS',pic:''},{av:'AV72TFAplIIGGPrrtear_Sels',fld:'vTFAPLIIGGPRRTEAR_SELS',pic:''},{av:'AV47TFAplIIGGCondicion',fld:'vTFAPLIIGGCONDICION',pic:''},{av:'AV48TFAplIIGGCondicion_Sels',fld:'vTFAPLIIGGCONDICION_SELS',pic:''},{av:'AV87TFAplIIGGRelRef',fld:'vTFAPLIIGGRELREF',pic:''},{av:'AV88TFAplIIGGRelRef_Sels',fld:'vTFAPLIIGGRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV62CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV55IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV79WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15BQ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV91ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV104Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV77MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV64TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV65TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV23TFAplIIGGNom',fld:'vTFAPLIIGGNOM',pic:''},{av:'AV24TFAplIIGGNom_Sels',fld:'vTFAPLIIGGNOM_SELS',pic:''},{av:'AV26TFAplIIGGTrat_Sels',fld:'vTFAPLIIGGTRAT_SELS',pic:''},{av:'AV27TFAplIIGGPropor',fld:'vTFAPLIIGGPROPOR',pic:'9.9999'},{av:'AV28TFAplIIGGPropor_To',fld:'vTFAPLIIGGPROPOR_TO',pic:'9.9999'},{av:'AV30TFAplIIGGTopeTip_Sels',fld:'vTFAPLIIGGTOPETIP_SELS',pic:''},{av:'AV35TFAplIIGGTopeCon',fld:'vTFAPLIIGGTOPECON',pic:''},{av:'AV36TFAplIIGGTopeCon_Sels',fld:'vTFAPLIIGGTOPECON_SELS',pic:''},{av:'AV37TFAplIIGGTopeFij',fld:'vTFAPLIIGGTOPEFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFAplIIGGTopeFij_To',fld:'vTFAPLIIGGTOPEFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFAplIIGGExenCon',fld:'vTFAPLIIGGEXENCON',pic:''},{av:'AV41TFAplIIGGExenCon_Sels',fld:'vTFAPLIIGGEXENCON_SELS',pic:''},{av:'AV72TFAplIIGGPrrtear_Sels',fld:'vTFAPLIIGGPRRTEAR_SELS',pic:''},{av:'AV47TFAplIIGGCondicion',fld:'vTFAPLIIGGCONDICION',pic:''},{av:'AV48TFAplIIGGCondicion_Sels',fld:'vTFAPLIIGGCONDICION_SELS',pic:''},{av:'AV87TFAplIIGGRelRef',fld:'vTFAPLIIGGRELREF',pic:''},{av:'AV88TFAplIIGGRelRef_Sels',fld:'vTFAPLIIGGRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV62CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV55IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV79WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV87TFAplIIGGRelRef',fld:'vTFAPLIIGGRELREF',pic:''},{av:'AV86TFAplIIGGRelRef_SelsJson',fld:'vTFAPLIIGGRELREF_SELSJSON',pic:''},{av:'AV88TFAplIIGGRelRef_Sels',fld:'vTFAPLIIGGRELREF_SELS',pic:''},{av:'AV47TFAplIIGGCondicion',fld:'vTFAPLIIGGCONDICION',pic:''},{av:'AV46TFAplIIGGCondicion_SelsJson',fld:'vTFAPLIIGGCONDICION_SELSJSON',pic:''},{av:'AV48TFAplIIGGCondicion_Sels',fld:'vTFAPLIIGGCONDICION_SELS',pic:''},{av:'AV71TFAplIIGGPrrtear_SelsJson',fld:'vTFAPLIIGGPRRTEAR_SELSJSON',pic:''},{av:'AV72TFAplIIGGPrrtear_Sels',fld:'vTFAPLIIGGPRRTEAR_SELS',pic:''},{av:'AV40TFAplIIGGExenCon',fld:'vTFAPLIIGGEXENCON',pic:''},{av:'AV39TFAplIIGGExenCon_SelsJson',fld:'vTFAPLIIGGEXENCON_SELSJSON',pic:''},{av:'AV41TFAplIIGGExenCon_Sels',fld:'vTFAPLIIGGEXENCON_SELS',pic:''},{av:'AV37TFAplIIGGTopeFij',fld:'vTFAPLIIGGTOPEFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFAplIIGGTopeFij_To',fld:'vTFAPLIIGGTOPEFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV35TFAplIIGGTopeCon',fld:'vTFAPLIIGGTOPECON',pic:''},{av:'AV34TFAplIIGGTopeCon_SelsJson',fld:'vTFAPLIIGGTOPECON_SELSJSON',pic:''},{av:'AV36TFAplIIGGTopeCon_Sels',fld:'vTFAPLIIGGTOPECON_SELS',pic:''},{av:'AV29TFAplIIGGTopeTip_SelsJson',fld:'vTFAPLIIGGTOPETIP_SELSJSON',pic:''},{av:'AV30TFAplIIGGTopeTip_Sels',fld:'vTFAPLIIGGTOPETIP_SELS',pic:''},{av:'AV27TFAplIIGGPropor',fld:'vTFAPLIIGGPROPOR',pic:'9.9999'},{av:'AV28TFAplIIGGPropor_To',fld:'vTFAPLIIGGPROPOR_TO',pic:'9.9999'},{av:'AV25TFAplIIGGTrat_SelsJson',fld:'vTFAPLIIGGTRAT_SELSJSON',pic:''},{av:'AV26TFAplIIGGTrat_Sels',fld:'vTFAPLIIGGTRAT_SELS',pic:''},{av:'AV23TFAplIIGGNom',fld:'vTFAPLIIGGNOM',pic:''},{av:'AV22TFAplIIGGNom_SelsJson',fld:'vTFAPLIIGGNOM_SELSJSON',pic:''},{av:'AV24TFAplIIGGNom_Sels',fld:'vTFAPLIIGGNOM_SELS',pic:''},{av:'AV64TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV65TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e20BQ2',iparms:[{av:'AV55IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1112AplIIGG',fld:'APLIIGG',pic:'ZZZ9'},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV62CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1109AplIIGGTopeVar',fld:'APLIIGGTOPEVAR',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV54Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV56Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV76Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV73VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV74ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV75EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV66OpeCliDescrip',fld:'vOPECLIDESCRIP',pic:''}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11BQ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV91ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV104Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV77MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV64TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV65TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV23TFAplIIGGNom',fld:'vTFAPLIIGGNOM',pic:''},{av:'AV24TFAplIIGGNom_Sels',fld:'vTFAPLIIGGNOM_SELS',pic:''},{av:'AV26TFAplIIGGTrat_Sels',fld:'vTFAPLIIGGTRAT_SELS',pic:''},{av:'AV27TFAplIIGGPropor',fld:'vTFAPLIIGGPROPOR',pic:'9.9999'},{av:'AV28TFAplIIGGPropor_To',fld:'vTFAPLIIGGPROPOR_TO',pic:'9.9999'},{av:'AV30TFAplIIGGTopeTip_Sels',fld:'vTFAPLIIGGTOPETIP_SELS',pic:''},{av:'AV35TFAplIIGGTopeCon',fld:'vTFAPLIIGGTOPECON',pic:''},{av:'AV36TFAplIIGGTopeCon_Sels',fld:'vTFAPLIIGGTOPECON_SELS',pic:''},{av:'AV37TFAplIIGGTopeFij',fld:'vTFAPLIIGGTOPEFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFAplIIGGTopeFij_To',fld:'vTFAPLIIGGTOPEFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFAplIIGGExenCon',fld:'vTFAPLIIGGEXENCON',pic:''},{av:'AV41TFAplIIGGExenCon_Sels',fld:'vTFAPLIIGGEXENCON_SELS',pic:''},{av:'AV72TFAplIIGGPrrtear_Sels',fld:'vTFAPLIIGGPRRTEAR_SELS',pic:''},{av:'AV47TFAplIIGGCondicion',fld:'vTFAPLIIGGCONDICION',pic:''},{av:'AV48TFAplIIGGCondicion_Sels',fld:'vTFAPLIIGGCONDICION_SELS',pic:''},{av:'AV87TFAplIIGGRelRef',fld:'vTFAPLIIGGRELREF',pic:''},{av:'AV88TFAplIIGGRelRef_Sels',fld:'vTFAPLIIGGRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV62CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV55IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV79WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV62CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV91ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtAplIIGG_Visible',ctrl:'APLIIGG',prop:'Visible'},{av:'edtAplIIGGNom_Visible',ctrl:'APLIIGGNOM',prop:'Visible'},{av:'cmbAplIIGGTrat'},{av:'edtAplIIGGPropor_Visible',ctrl:'APLIIGGPROPOR',prop:'Visible'},{av:'cmbAplIIGGTopeTip'},{av:'edtavOpeclidescrip_Visible',ctrl:'vOPECLIDESCRIP',prop:'Visible'},{av:'edtAplIIGGTopeCon_Visible',ctrl:'APLIIGGTOPECON',prop:'Visible'},{av:'edtAplIIGGTopeFij_Visible',ctrl:'APLIIGGTOPEFIJ',prop:'Visible'},{av:'edtAplIIGGExenCon_Visible',ctrl:'APLIIGGEXENCON',prop:'Visible'},{av:'cmbAplIIGGPrrtear'},{av:'edtAplIIGGCondicion_Visible',ctrl:'APLIIGGCONDICION',prop:'Visible'},{av:'edtAplIIGGRelRef_Visible',ctrl:'APLIIGGRELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV51GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV52GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV53GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV55IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV89ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV87TFAplIIGGRelRef',fld:'vTFAPLIIGGRELREF',pic:''},{av:'AV88TFAplIIGGRelRef_Sels',fld:'vTFAPLIIGGRELREF_SELS',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12BQ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV91ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV104Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV77MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV64TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV65TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV23TFAplIIGGNom',fld:'vTFAPLIIGGNOM',pic:''},{av:'AV24TFAplIIGGNom_Sels',fld:'vTFAPLIIGGNOM_SELS',pic:''},{av:'AV26TFAplIIGGTrat_Sels',fld:'vTFAPLIIGGTRAT_SELS',pic:''},{av:'AV27TFAplIIGGPropor',fld:'vTFAPLIIGGPROPOR',pic:'9.9999'},{av:'AV28TFAplIIGGPropor_To',fld:'vTFAPLIIGGPROPOR_TO',pic:'9.9999'},{av:'AV30TFAplIIGGTopeTip_Sels',fld:'vTFAPLIIGGTOPETIP_SELS',pic:''},{av:'AV35TFAplIIGGTopeCon',fld:'vTFAPLIIGGTOPECON',pic:''},{av:'AV36TFAplIIGGTopeCon_Sels',fld:'vTFAPLIIGGTOPECON_SELS',pic:''},{av:'AV37TFAplIIGGTopeFij',fld:'vTFAPLIIGGTOPEFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFAplIIGGTopeFij_To',fld:'vTFAPLIIGGTOPEFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFAplIIGGExenCon',fld:'vTFAPLIIGGEXENCON',pic:''},{av:'AV41TFAplIIGGExenCon_Sels',fld:'vTFAPLIIGGEXENCON_SELS',pic:''},{av:'AV72TFAplIIGGPrrtear_Sels',fld:'vTFAPLIIGGPRRTEAR_SELS',pic:''},{av:'AV47TFAplIIGGCondicion',fld:'vTFAPLIIGGCONDICION',pic:''},{av:'AV48TFAplIIGGCondicion_Sels',fld:'vTFAPLIIGGCONDICION_SELS',pic:''},{av:'AV87TFAplIIGGRelRef',fld:'vTFAPLIIGGRELREF',pic:''},{av:'AV88TFAplIIGGRelRef_Sels',fld:'vTFAPLIIGGRELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV62CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV55IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV79WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV22TFAplIIGGNom_SelsJson',fld:'vTFAPLIIGGNOM_SELSJSON',pic:''},{av:'AV25TFAplIIGGTrat_SelsJson',fld:'vTFAPLIIGGTRAT_SELSJSON',pic:''},{av:'AV29TFAplIIGGTopeTip_SelsJson',fld:'vTFAPLIIGGTOPETIP_SELSJSON',pic:''},{av:'AV34TFAplIIGGTopeCon_SelsJson',fld:'vTFAPLIIGGTOPECON_SELSJSON',pic:''},{av:'AV39TFAplIIGGExenCon_SelsJson',fld:'vTFAPLIIGGEXENCON_SELSJSON',pic:''},{av:'AV71TFAplIIGGPrrtear_SelsJson',fld:'vTFAPLIIGGPRRTEAR_SELSJSON',pic:''},{av:'AV46TFAplIIGGCondicion_SelsJson',fld:'vTFAPLIIGGCONDICION_SELSJSON',pic:''},{av:'AV86TFAplIIGGRelRef_SelsJson',fld:'vTFAPLIIGGRELREF_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV91ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV64TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV65TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV23TFAplIIGGNom',fld:'vTFAPLIIGGNOM',pic:''},{av:'AV24TFAplIIGGNom_Sels',fld:'vTFAPLIIGGNOM_SELS',pic:''},{av:'AV26TFAplIIGGTrat_Sels',fld:'vTFAPLIIGGTRAT_SELS',pic:''},{av:'AV27TFAplIIGGPropor',fld:'vTFAPLIIGGPROPOR',pic:'9.9999'},{av:'AV28TFAplIIGGPropor_To',fld:'vTFAPLIIGGPROPOR_TO',pic:'9.9999'},{av:'AV30TFAplIIGGTopeTip_Sels',fld:'vTFAPLIIGGTOPETIP_SELS',pic:''},{av:'AV35TFAplIIGGTopeCon',fld:'vTFAPLIIGGTOPECON',pic:''},{av:'AV36TFAplIIGGTopeCon_Sels',fld:'vTFAPLIIGGTOPECON_SELS',pic:''},{av:'AV37TFAplIIGGTopeFij',fld:'vTFAPLIIGGTOPEFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFAplIIGGTopeFij_To',fld:'vTFAPLIIGGTOPEFIJ_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFAplIIGGExenCon',fld:'vTFAPLIIGGEXENCON',pic:''},{av:'AV41TFAplIIGGExenCon_Sels',fld:'vTFAPLIIGGEXENCON_SELS',pic:''},{av:'AV72TFAplIIGGPrrtear_Sels',fld:'vTFAPLIIGGPRRTEAR_SELS',pic:''},{av:'AV47TFAplIIGGCondicion',fld:'vTFAPLIIGGCONDICION',pic:''},{av:'AV48TFAplIIGGCondicion_Sels',fld:'vTFAPLIIGGCONDICION_SELS',pic:''},{av:'AV87TFAplIIGGRelRef',fld:'vTFAPLIIGGRELREF',pic:''},{av:'AV88TFAplIIGGRelRef_Sels',fld:'vTFAPLIIGGRELREF_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV86TFAplIIGGRelRef_SelsJson',fld:'vTFAPLIIGGRELREF_SELSJSON',pic:''},{av:'AV46TFAplIIGGCondicion_SelsJson',fld:'vTFAPLIIGGCONDICION_SELSJSON',pic:''},{av:'AV71TFAplIIGGPrrtear_SelsJson',fld:'vTFAPLIIGGPRRTEAR_SELSJSON',pic:''},{av:'AV39TFAplIIGGExenCon_SelsJson',fld:'vTFAPLIIGGEXENCON_SELSJSON',pic:''},{av:'AV34TFAplIIGGTopeCon_SelsJson',fld:'vTFAPLIIGGTOPECON_SELSJSON',pic:''},{av:'AV29TFAplIIGGTopeTip_SelsJson',fld:'vTFAPLIIGGTOPETIP_SELSJSON',pic:''},{av:'AV25TFAplIIGGTrat_SelsJson',fld:'vTFAPLIIGGTRAT_SELSJSON',pic:''},{av:'AV22TFAplIIGGNom_SelsJson',fld:'vTFAPLIIGGNOM_SELSJSON',pic:''},{av:'AV62CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtAplIIGG_Visible',ctrl:'APLIIGG',prop:'Visible'},{av:'edtAplIIGGNom_Visible',ctrl:'APLIIGGNOM',prop:'Visible'},{av:'cmbAplIIGGTrat'},{av:'edtAplIIGGPropor_Visible',ctrl:'APLIIGGPROPOR',prop:'Visible'},{av:'cmbAplIIGGTopeTip'},{av:'edtavOpeclidescrip_Visible',ctrl:'vOPECLIDESCRIP',prop:'Visible'},{av:'edtAplIIGGTopeCon_Visible',ctrl:'APLIIGGTOPECON',prop:'Visible'},{av:'edtAplIIGGTopeFij_Visible',ctrl:'APLIIGGTOPEFIJ',prop:'Visible'},{av:'edtAplIIGGExenCon_Visible',ctrl:'APLIIGGEXENCON',prop:'Visible'},{av:'cmbAplIIGGPrrtear'},{av:'edtAplIIGGCondicion_Visible',ctrl:'APLIIGGCONDICION',prop:'Visible'},{av:'edtAplIIGGRelRef_Visible',ctrl:'APLIIGGRELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV51GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV52GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV53GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV55IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV57IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV89ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e22BQ1',iparms:[{av:'AV62CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e16BQ2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e17BQ2',iparms:[{av:'AV79WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV77MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV62CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e21BQ1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("NULL","{handler:'validv_Eliminarsvg',iparms:[]");
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
      wcpOAV77MenuOpcCod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV77MenuOpcCod = "" ;
      AV19ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV104Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23TFAplIIGGNom = "" ;
      AV24TFAplIIGGNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26TFAplIIGGTrat_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV27TFAplIIGGPropor = DecimalUtil.ZERO ;
      AV28TFAplIIGGPropor_To = DecimalUtil.ZERO ;
      AV30TFAplIIGGTopeTip_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV35TFAplIIGGTopeCon = "" ;
      AV36TFAplIIGGTopeCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFAplIIGGTopeFij = DecimalUtil.ZERO ;
      AV38TFAplIIGGTopeFij_To = DecimalUtil.ZERO ;
      AV40TFAplIIGGExenCon = "" ;
      AV41TFAplIIGGExenCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72TFAplIIGGPrrtear_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47TFAplIIGGCondicion = "" ;
      AV48TFAplIIGGCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV87TFAplIIGGRelRef = "" ;
      AV88TFAplIIGGRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV49DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV89ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV53GridAppliedFilters = "" ;
      AV22TFAplIIGGNom_SelsJson = "" ;
      AV25TFAplIIGGTrat_SelsJson = "" ;
      AV29TFAplIIGGTopeTip_SelsJson = "" ;
      AV34TFAplIIGGTopeCon_SelsJson = "" ;
      AV39TFAplIIGGExenCon_SelsJson = "" ;
      AV71TFAplIIGGPrrtear_SelsJson = "" ;
      AV46TFAplIIGGCondicion_SelsJson = "" ;
      AV86TFAplIIGGRelRef_SelsJson = "" ;
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A1113AplIIGGNom = "" ;
      A1114AplIIGGPropor = DecimalUtil.ZERO ;
      A1109AplIIGGTopeVar = "" ;
      AV66OpeCliDescrip = "" ;
      A1111AplIIGGTopeCon = "" ;
      A1119AplIIGGTopeFij = DecimalUtil.ZERO ;
      A1117AplIIGGExenCon = "" ;
      A1121AplIIGGPrrtear = "" ;
      A1124AplIIGGCondicion = "" ;
      A2020AplIIGGRelRef = "" ;
      AV54Update = "" ;
      AV56Delete = "" ;
      AV76Display = "" ;
      AV73VerSVG = "" ;
      AV74ModificarSVG = "" ;
      AV75EliminarSVG = "" ;
      AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = "" ;
      lV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = "" ;
      lV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = "" ;
      lV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = "" ;
      lV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = "" ;
      AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = "" ;
      AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = DecimalUtil.ZERO ;
      AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = DecimalUtil.ZERO ;
      AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = "" ;
      AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = DecimalUtil.ZERO ;
      AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = DecimalUtil.ZERO ;
      AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = "" ;
      AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = "" ;
      AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = "" ;
      H00BQ2_A2020AplIIGGRelRef = new String[] {""} ;
      H00BQ2_A1124AplIIGGCondicion = new String[] {""} ;
      H00BQ2_n1124AplIIGGCondicion = new boolean[] {false} ;
      H00BQ2_A1121AplIIGGPrrtear = new String[] {""} ;
      H00BQ2_A1117AplIIGGExenCon = new String[] {""} ;
      H00BQ2_n1117AplIIGGExenCon = new boolean[] {false} ;
      H00BQ2_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00BQ2_A1111AplIIGGTopeCon = new String[] {""} ;
      H00BQ2_n1111AplIIGGTopeCon = new boolean[] {false} ;
      H00BQ2_A1109AplIIGGTopeVar = new String[] {""} ;
      H00BQ2_n1109AplIIGGTopeVar = new boolean[] {false} ;
      H00BQ2_A1115AplIIGGTopeTip = new byte[1] ;
      H00BQ2_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00BQ2_A1120AplIIGGTrat = new byte[1] ;
      H00BQ2_A1113AplIIGGNom = new String[] {""} ;
      H00BQ2_A1112AplIIGG = new short[1] ;
      H00BQ2_A3CliCod = new int[1] ;
      H00BQ3_AGRID_nRecordCount = new long[1] ;
      AV85WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV80MenuBienveImgURL = "" ;
      AV82MenuBienveTitulo = "" ;
      AV83MenuBienveTexto = "" ;
      AV103Welcomemessage_foto_GXI = "" ;
      AV100observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext11 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV21Session = httpContext.getWebSession();
      AV17ColumnsSelectorXML = "" ;
      AV96MenuOpcTitulo = "" ;
      GXv_int12 = new short[1] ;
      AV99filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV90ManageFiltersXml = "" ;
      AV69ExcelFilename = "" ;
      AV70ErrorMessage = "" ;
      AV18UserCustomValue = "" ;
      AV20ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char9 = "" ;
      GXv_char5 = new String[1] ;
      GXt_char23 = "" ;
      GXt_char21 = "" ;
      GXv_char22 = new String[1] ;
      GXt_char19 = "" ;
      GXv_char20 = new String[1] ;
      GXt_char18 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char10 = "" ;
      GXv_char6 = new String[1] ;
      GXv_SdtWWPGridState25 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV81textoNoMostrara = "" ;
      GXv_char24 = new String[1] ;
      GXv_boolean8 = new boolean[1] ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      lblButtonexport1_textblock_svg_Jsonclick = "" ;
      lblButtonexport1_textblock_texto_Jsonclick = "" ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      bttBtninsert_Jsonclick = "" ;
      bttBtnexport_Jsonclick = "" ;
      lblButtonfilter1_textblock_svg_Jsonclick = "" ;
      lblButtonfilter1_textblock_texto_Jsonclick = "" ;
      lblButtonfilter1_textblockbadgecount_Jsonclick = "" ;
      lblTotaltext_Jsonclick = "" ;
      lblCouttext_Jsonclick = "" ;
      lblWelcomemessage_descripcion_Jsonclick = "" ;
      lblWelcomemessage_titulo_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipo_aplicacion_gananciasww__default(),
         new Object[] {
             new Object[] {
            H00BQ2_A2020AplIIGGRelRef, H00BQ2_A1124AplIIGGCondicion, H00BQ2_n1124AplIIGGCondicion, H00BQ2_A1121AplIIGGPrrtear, H00BQ2_A1117AplIIGGExenCon, H00BQ2_n1117AplIIGGExenCon, H00BQ2_A1119AplIIGGTopeFij, H00BQ2_A1111AplIIGGTopeCon, H00BQ2_n1111AplIIGGTopeCon, H00BQ2_A1109AplIIGGTopeVar,
            H00BQ2_n1109AplIIGGTopeVar, H00BQ2_A1115AplIIGGTopeTip, H00BQ2_A1114AplIIGGPropor, H00BQ2_A1120AplIIGGTrat, H00BQ2_A1113AplIIGGNom, H00BQ2_A1112AplIIGG, H00BQ2_A3CliCod
            }
            , new Object[] {
            H00BQ3_AGRID_nRecordCount
            }
         }
      );
      AV104Pgmname = "tipo_aplicacion_gananciasWW" ;
      /* GeneXus formulas. */
      AV104Pgmname = "tipo_aplicacion_gananciasWW" ;
      Gx_err = (short)(0) ;
      edtavOpeclidescrip_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
      edtavEliminarsvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV91ManageFiltersExecutionStep ;
   private byte gxajaxcallmode ;
   private byte A1120AplIIGGTrat ;
   private byte A1115AplIIGGTopeTip ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short AV64TFAplIIGG ;
   private short AV65TFAplIIGG_To ;
   private short AV14OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A1112AplIIGG ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg ;
   private short AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to ;
   private short GXv_int12[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_110 ;
   private int nGXsfl_110_idx=1 ;
   private int AV62CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int subGrid_Islastpage ;
   private int edtavOpeclidescrip_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size ;
   private int AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size ;
   private int AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size ;
   private int AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size ;
   private int AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size ;
   private int AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size ;
   private int AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size ;
   private int AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtAplIIGG_Visible ;
   private int edtAplIIGGNom_Visible ;
   private int edtAplIIGGPropor_Visible ;
   private int edtavOpeclidescrip_Visible ;
   private int edtAplIIGGTopeCon_Visible ;
   private int edtAplIIGGTopeFij_Visible ;
   private int edtAplIIGGExenCon_Visible ;
   private int edtAplIIGGCondicion_Visible ;
   private int edtAplIIGGRelRef_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV98filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV50PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int bttBtninsert_Visible ;
   private int AV124GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV51GridCurrentPage ;
   private long AV52GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV27TFAplIIGGPropor ;
   private java.math.BigDecimal AV28TFAplIIGGPropor_To ;
   private java.math.BigDecimal AV37TFAplIIGGTopeFij ;
   private java.math.BigDecimal AV38TFAplIIGGTopeFij_To ;
   private java.math.BigDecimal A1114AplIIGGPropor ;
   private java.math.BigDecimal A1119AplIIGGTopeFij ;
   private java.math.BigDecimal AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ;
   private java.math.BigDecimal AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ;
   private java.math.BigDecimal AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ;
   private java.math.BigDecimal AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_110_idx="0001" ;
   private String AV104Pgmname ;
   private String AV35TFAplIIGGTopeCon ;
   private String AV40TFAplIIGGExenCon ;
   private String AV47TFAplIIGGCondicion ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Buttonexport1_a3lexport_Observer ;
   private String Buttonexport1_a3lexport_Boton_clon_id ;
   private String Buttonexport1_a3lexport_Boton_orig_id ;
   private String Ddo_gridcolumnsselector_Icontype ;
   private String Ddo_gridcolumnsselector_Icon ;
   private String Ddo_gridcolumnsselector_Caption ;
   private String Ddo_gridcolumnsselector_Tooltip ;
   private String Ddo_gridcolumnsselector_Cls ;
   private String Ddo_gridcolumnsselector_Dropdownoptionstype ;
   private String Ddo_gridcolumnsselector_Gridinternalname ;
   private String Ddo_managefilters_Icontype ;
   private String Ddo_managefilters_Icon ;
   private String Ddo_managefilters_Tooltip ;
   private String Ddo_managefilters_Cls ;
   private String Buttonfilter1_a3lfilter_Observer ;
   private String Buttonfilter1_a3lfilter_A3l_filter_id ;
   private String Buttonfilter1_a3lfilter_Filter_orig ;
   private String Gridpaginationbar_Class ;
   private String Gridpaginationbar_Pagingbuttonsposition ;
   private String Gridpaginationbar_Pagingcaptionposition ;
   private String Gridpaginationbar_Emptygridclass ;
   private String Gridpaginationbar_Rowsperpageoptions ;
   private String Gridpaginationbar_Previous ;
   private String Gridpaginationbar_Next ;
   private String Gridpaginationbar_Caption ;
   private String Gridpaginationbar_Emptygridcaption ;
   private String Gridpaginationbar_Rowsperpagecaption ;
   private String Ddo_grid_Caption ;
   private String Ddo_grid_Filteredtext_set ;
   private String Ddo_grid_Filteredtextto_set ;
   private String Ddo_grid_Selectedvalue_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Fixable ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Filterisrange ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistfixedvalues ;
   private String Ddo_grid_Datalistproc ;
   private String Ddo_grid_Format ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtCliCod_Internalname ;
   private String edtAplIIGG_Internalname ;
   private String edtAplIIGGNom_Internalname ;
   private String edtAplIIGGPropor_Internalname ;
   private String A1109AplIIGGTopeVar ;
   private String edtAplIIGGTopeVar_Internalname ;
   private String edtavOpeclidescrip_Internalname ;
   private String A1111AplIIGGTopeCon ;
   private String edtAplIIGGTopeCon_Internalname ;
   private String edtAplIIGGTopeFij_Internalname ;
   private String A1117AplIIGGExenCon ;
   private String edtAplIIGGExenCon_Internalname ;
   private String A1121AplIIGGPrrtear ;
   private String A1124AplIIGGCondicion ;
   private String edtAplIIGGCondicion_Internalname ;
   private String edtAplIIGGRelRef_Internalname ;
   private String AV54Update ;
   private String edtavUpdate_Internalname ;
   private String AV56Delete ;
   private String edtavDelete_Internalname ;
   private String AV76Display ;
   private String edtavDisplay_Internalname ;
   private String AV73VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV74ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV75EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String scmdbuf ;
   private String lV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ;
   private String lV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ;
   private String lV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ;
   private String AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ;
   private String AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ;
   private String AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String AV100observerPalabra ;
   private String Buttonexport1_a3lexport_Internalname ;
   private String divButtonexport1_tablecontentbuttonimport_Internalname ;
   private String bttBtnexport_Internalname ;
   private String Buttonfilter1_a3lfilter_Internalname ;
   private String divButtonfilter1_tablecontent_Internalname ;
   private String lblCouttext_Internalname ;
   private String lblCouttext_Caption ;
   private String tblButtonfilter1_tablebadge_Internalname ;
   private String lblButtonfilter1_textblockbadgecount_Caption ;
   private String lblButtonfilter1_textblockbadgecount_Internalname ;
   private String tblButtonfilter1_tablebadge_Tooltiptext ;
   private String edtavUpdate_Link ;
   private String edtavDelete_Link ;
   private String edtavDisplay_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtavEliminarsvg_Link ;
   private String bttBtninsert_Internalname ;
   private String GXt_char9 ;
   private String GXv_char5[] ;
   private String GXt_char23 ;
   private String GXt_char21 ;
   private String GXv_char22[] ;
   private String GXt_char19 ;
   private String GXv_char20[] ;
   private String GXt_char18 ;
   private String GXv_char7[] ;
   private String GXt_char10 ;
   private String GXv_char6[] ;
   private String GXv_char24[] ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String tblTablemainfix_Internalname ;
   private String tblTablepadding_Internalname ;
   private String divWelcomemessage_welcometableprincipal_Internalname ;
   private String divWelcomemessage_tableclose_Internalname ;
   private String lblWelcomemessage_closehelp_Jsonclick ;
   private String divWelcomemessage_welcomecontentitem_Internalname ;
   private String divWelcomemessage_welcomecontentflex_Internalname ;
   private String divWelcomemessage_welcometableimagen_Internalname ;
   private String imgavWelcomemessage_foto_gximage ;
   private String sImgUrl ;
   private String divWelcomemessage_tabletexto_Internalname ;
   private String divWelcomemessage_welcomebottomitem_Internalname ;
   private String divWelcomemessage_tablecmb_Internalname ;
   private String divWelcomemessage_tablec_Internalname ;
   private String TempTags ;
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String divTablefiltrospadre_Internalname ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String tblTablefiltros_Internalname ;
   private String divButtonexport1_table_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Jsonclick ;
   private String divButtonexport1_table_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Jsonclick ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String bttBtninsert_Jsonclick ;
   private String bttBtnexport_Jsonclick ;
   private String divButtonfilter1_filtros_Internalname ;
   private String divButtonfilter1_table_svg_Internalname ;
   private String lblButtonfilter1_textblock_svg_Internalname ;
   private String lblButtonfilter1_textblock_svg_Jsonclick ;
   private String divButtonfilter1_table_texto_Internalname ;
   private String lblButtonfilter1_textblock_texto_Internalname ;
   private String lblButtonfilter1_textblock_texto_Jsonclick ;
   private String lblButtonfilter1_textblockbadgecount_Jsonclick ;
   private String tblTabletotalregistros_Internalname ;
   private String divTabletotal_Internalname ;
   private String lblTotaltext_Internalname ;
   private String lblTotaltext_Jsonclick ;
   private String lblCouttext_Jsonclick ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private String sGXsfl_110_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtCliCod_Jsonclick ;
   private String edtAplIIGG_Jsonclick ;
   private String edtAplIIGGNom_Jsonclick ;
   private String GXCCtl ;
   private String edtAplIIGGPropor_Jsonclick ;
   private String edtAplIIGGTopeVar_Jsonclick ;
   private String edtavOpeclidescrip_Jsonclick ;
   private String edtAplIIGGTopeCon_Jsonclick ;
   private String edtAplIIGGTopeFij_Jsonclick ;
   private String edtAplIIGGExenCon_Jsonclick ;
   private String edtAplIIGGCondicion_Jsonclick ;
   private String edtAplIIGGRelRef_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV15OrderedDsc ;
   private boolean AV55IsAuthorized_Update ;
   private boolean AV57IsAuthorized_Delete ;
   private boolean AV79WelcomeMessage_NoMostrarMas ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean Grid_empowerer_Hascolumnsselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n1109AplIIGGTopeVar ;
   private boolean n1111AplIIGGTopeCon ;
   private boolean n1117AplIIGGExenCon ;
   private boolean n1124AplIIGGCondicion ;
   private boolean bGXsfl_110_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV84MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean Cond_result ;
   private boolean AV61TempBoolean ;
   private boolean GXt_boolean15 ;
   private boolean GXv_boolean8[] ;
   private boolean AV85WelcomeMessage_Foto_IsBlob ;
   private String AV22TFAplIIGGNom_SelsJson ;
   private String AV25TFAplIIGGTrat_SelsJson ;
   private String AV29TFAplIIGGTopeTip_SelsJson ;
   private String AV34TFAplIIGGTopeCon_SelsJson ;
   private String AV39TFAplIIGGExenCon_SelsJson ;
   private String AV71TFAplIIGGPrrtear_SelsJson ;
   private String AV46TFAplIIGGCondicion_SelsJson ;
   private String AV86TFAplIIGGRelRef_SelsJson ;
   private String AV83MenuBienveTexto ;
   private String AV17ColumnsSelectorXML ;
   private String AV90ManageFiltersXml ;
   private String AV18UserCustomValue ;
   private String AV81textoNoMostrara ;
   private String wcpOAV77MenuOpcCod ;
   private String AV77MenuOpcCod ;
   private String AV23TFAplIIGGNom ;
   private String AV87TFAplIIGGRelRef ;
   private String AV53GridAppliedFilters ;
   private String A1113AplIIGGNom ;
   private String AV66OpeCliDescrip ;
   private String A2020AplIIGGRelRef ;
   private String lV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ;
   private String lV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ;
   private String AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ;
   private String AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ;
   private String AV80MenuBienveImgURL ;
   private String AV82MenuBienveTitulo ;
   private String AV103Welcomemessage_foto_GXI ;
   private String AV96MenuOpcTitulo ;
   private String AV99filtrosTexto ;
   private String AV69ExcelFilename ;
   private String AV70ErrorMessage ;
   private String AV85WelcomeMessage_Foto ;
   private GXSimpleCollection<Byte> AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ;
   private GXSimpleCollection<Byte> AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ;
   private GXSimpleCollection<Byte> AV26TFAplIIGGTrat_Sels ;
   private GXSimpleCollection<Byte> AV30TFAplIIGGTopeTip_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV9HTTPRequest ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ;
   private GXSimpleCollection<String> AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ;
   private GXSimpleCollection<String> AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ;
   private GXSimpleCollection<String> AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ;
   private GXSimpleCollection<String> AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ;
   private GXSimpleCollection<String> AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbAplIIGGTrat ;
   private HTMLChoice cmbAplIIGGTopeTip ;
   private HTMLChoice cmbAplIIGGPrrtear ;
   private IDataStoreProvider pr_default ;
   private String[] H00BQ2_A2020AplIIGGRelRef ;
   private String[] H00BQ2_A1124AplIIGGCondicion ;
   private boolean[] H00BQ2_n1124AplIIGGCondicion ;
   private String[] H00BQ2_A1121AplIIGGPrrtear ;
   private String[] H00BQ2_A1117AplIIGGExenCon ;
   private boolean[] H00BQ2_n1117AplIIGGExenCon ;
   private java.math.BigDecimal[] H00BQ2_A1119AplIIGGTopeFij ;
   private String[] H00BQ2_A1111AplIIGGTopeCon ;
   private boolean[] H00BQ2_n1111AplIIGGTopeCon ;
   private String[] H00BQ2_A1109AplIIGGTopeVar ;
   private boolean[] H00BQ2_n1109AplIIGGTopeVar ;
   private byte[] H00BQ2_A1115AplIIGGTopeTip ;
   private java.math.BigDecimal[] H00BQ2_A1114AplIIGGPropor ;
   private byte[] H00BQ2_A1120AplIIGGTrat ;
   private String[] H00BQ2_A1113AplIIGGNom ;
   private short[] H00BQ2_A1112AplIIGG ;
   private int[] H00BQ2_A3CliCod ;
   private long[] H00BQ3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV36TFAplIIGGTopeCon_Sels ;
   private GXSimpleCollection<String> AV41TFAplIIGGExenCon_Sels ;
   private GXSimpleCollection<String> AV72TFAplIIGGPrrtear_Sels ;
   private GXSimpleCollection<String> AV48TFAplIIGGCondicion_Sels ;
   private GXSimpleCollection<String> AV24TFAplIIGGNom_Sels ;
   private GXSimpleCollection<String> AV88TFAplIIGGRelRef_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV89ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext11[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState25[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV49DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class tipo_aplicacion_gananciasww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00BQ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1113AplIIGGNom ,
                                          GXSimpleCollection<String> AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                          byte A1120AplIIGGTrat ,
                                          GXSimpleCollection<Byte> AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                          byte A1115AplIIGGTopeTip ,
                                          GXSimpleCollection<Byte> AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                          String A1111AplIIGGTopeCon ,
                                          GXSimpleCollection<String> AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                          String A1117AplIIGGExenCon ,
                                          GXSimpleCollection<String> AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                          String A1121AplIIGGPrrtear ,
                                          GXSimpleCollection<String> AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                          String A1124AplIIGGCondicion ,
                                          GXSimpleCollection<String> AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                          String A2020AplIIGGRelRef ,
                                          GXSimpleCollection<String> AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                          short AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg ,
                                          short AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to ,
                                          int AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size ,
                                          String AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                          int AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size ,
                                          java.math.BigDecimal AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                          java.math.BigDecimal AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                          int AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size ,
                                          int AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size ,
                                          String AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                          java.math.BigDecimal AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                          java.math.BigDecimal AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                          int AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size ,
                                          String AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                          int AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size ,
                                          int AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size ,
                                          String AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                          int AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size ,
                                          String AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                          short A1112AplIIGG ,
                                          java.math.BigDecimal A1114AplIIGGPropor ,
                                          java.math.BigDecimal A1119AplIIGGTopeFij ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV62CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int26 = new byte[15];
      Object[] GXv_Object27 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " AplIIGGRelRef, AplIIGGCondicion, AplIIGGPrrtear, AplIIGGExenCon, AplIIGGTopeFij, AplIIGGTopeCon, AplIIGGTopeVar, AplIIGGTopeTip, AplIIGGPropor, AplIIGGTrat, AplIIGGNom," ;
      sSelectString += " AplIIGG, CliCod" ;
      sFromString = " FROM tipo_aplicacion_ganancias" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg) )
      {
         addWhere(sWhereString, "(AplIIGG >= ?)");
      }
      else
      {
         GXv_int26[1] = (byte)(1) ;
      }
      if ( ! (0==AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) )
      {
         addWhere(sWhereString, "(AplIIGG <= ?)");
      }
      else
      {
         GXv_int26[2] = (byte)(1) ;
      }
      if ( ( AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGNom) like LOWER(?))");
      }
      else
      {
         GXv_int26[3] = (byte)(1) ;
      }
      if ( AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels, "AplIIGGNom IN (", ")")+")");
      }
      if ( AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels, "AplIIGGTrat IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor >= ?)");
      }
      else
      {
         GXv_int26[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor <= ?)");
      }
      else
      {
         GXv_int26[5] = (byte)(1) ;
      }
      if ( AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels, "AplIIGGTopeTip IN (", ")")+")");
      }
      if ( ( AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGTopeCon) like LOWER(?))");
      }
      else
      {
         GXv_int26[6] = (byte)(1) ;
      }
      if ( AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels, "AplIIGGTopeCon IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij >= ?)");
      }
      else
      {
         GXv_int26[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij <= ?)");
      }
      else
      {
         GXv_int26[8] = (byte)(1) ;
      }
      if ( ( AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGExenCon) like LOWER(?))");
      }
      else
      {
         GXv_int26[9] = (byte)(1) ;
      }
      if ( AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels, "AplIIGGExenCon IN (", ")")+")");
      }
      if ( AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels, "AplIIGGPrrtear IN (", ")")+")");
      }
      if ( ( AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGCondicion) like LOWER(?))");
      }
      else
      {
         GXv_int26[10] = (byte)(1) ;
      }
      if ( AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels, "AplIIGGCondicion IN (", ")")+")");
      }
      if ( ( AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int26[11] = (byte)(1) ;
      }
      if ( AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels, "AplIIGGRelRef IN (", ")")+")");
      }
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY AplIIGG, CliCod" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY AplIIGG DESC, CliCod" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY AplIIGGNom, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY AplIIGGNom DESC, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY AplIIGGTrat, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY AplIIGGTrat DESC, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY AplIIGGPropor, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY AplIIGGPropor DESC, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY AplIIGGTopeTip, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY AplIIGGTopeTip DESC, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY AplIIGGTopeCon, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY AplIIGGTopeCon DESC, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY AplIIGGTopeFij, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY AplIIGGTopeFij DESC, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY AplIIGGExenCon, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY AplIIGGExenCon DESC, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY AplIIGGPrrtear, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY AplIIGGPrrtear DESC, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY AplIIGGCondicion, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY AplIIGGCondicion DESC, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY AplIIGGRelRef, CliCod, AplIIGG" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY AplIIGGRelRef DESC, CliCod, AplIIGG" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, AplIIGG" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object27[0] = scmdbuf ;
      GXv_Object27[1] = GXv_int26 ;
      return GXv_Object27 ;
   }

   protected Object[] conditional_H00BQ3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1113AplIIGGNom ,
                                          GXSimpleCollection<String> AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                          byte A1120AplIIGGTrat ,
                                          GXSimpleCollection<Byte> AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                          byte A1115AplIIGGTopeTip ,
                                          GXSimpleCollection<Byte> AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                          String A1111AplIIGGTopeCon ,
                                          GXSimpleCollection<String> AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                          String A1117AplIIGGExenCon ,
                                          GXSimpleCollection<String> AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                          String A1121AplIIGGPrrtear ,
                                          GXSimpleCollection<String> AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                          String A1124AplIIGGCondicion ,
                                          GXSimpleCollection<String> AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                          String A2020AplIIGGRelRef ,
                                          GXSimpleCollection<String> AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                          short AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg ,
                                          short AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to ,
                                          int AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size ,
                                          String AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                          int AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size ,
                                          java.math.BigDecimal AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                          java.math.BigDecimal AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                          int AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size ,
                                          int AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size ,
                                          String AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                          java.math.BigDecimal AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                          java.math.BigDecimal AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                          int AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size ,
                                          String AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                          int AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size ,
                                          int AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size ,
                                          String AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                          int AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size ,
                                          String AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                          short A1112AplIIGG ,
                                          java.math.BigDecimal A1114AplIIGGPropor ,
                                          java.math.BigDecimal A1119AplIIGGTopeFij ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV62CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int29 = new byte[12];
      Object[] GXv_Object30 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM tipo_aplicacion_ganancias" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV105Tipo_aplicacion_gananciaswwds_1_tfapliigg) )
      {
         addWhere(sWhereString, "(AplIIGG >= ?)");
      }
      else
      {
         GXv_int29[1] = (byte)(1) ;
      }
      if ( ! (0==AV106Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) )
      {
         addWhere(sWhereString, "(AplIIGG <= ?)");
      }
      else
      {
         GXv_int29[2] = (byte)(1) ;
      }
      if ( ( AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV107Tipo_aplicacion_gananciaswwds_3_tfapliiggnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGNom) like LOWER(?))");
      }
      else
      {
         GXv_int29[3] = (byte)(1) ;
      }
      if ( AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV108Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels, "AplIIGGNom IN (", ")")+")");
      }
      if ( AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV109Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels, "AplIIGGTrat IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV110Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor >= ?)");
      }
      else
      {
         GXv_int29[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV111Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor <= ?)");
      }
      else
      {
         GXv_int29[5] = (byte)(1) ;
      }
      if ( AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV112Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels, "AplIIGGTopeTip IN (", ")")+")");
      }
      if ( ( AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV113Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGTopeCon) like LOWER(?))");
      }
      else
      {
         GXv_int29[6] = (byte)(1) ;
      }
      if ( AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV114Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels, "AplIIGGTopeCon IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV115Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij >= ?)");
      }
      else
      {
         GXv_int29[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij <= ?)");
      }
      else
      {
         GXv_int29[8] = (byte)(1) ;
      }
      if ( ( AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV117Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGExenCon) like LOWER(?))");
      }
      else
      {
         GXv_int29[9] = (byte)(1) ;
      }
      if ( AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV118Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels, "AplIIGGExenCon IN (", ")")+")");
      }
      if ( AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV119Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels, "AplIIGGPrrtear IN (", ")")+")");
      }
      if ( ( AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV120Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGCondicion) like LOWER(?))");
      }
      else
      {
         GXv_int29[10] = (byte)(1) ;
      }
      if ( AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV121Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels, "AplIIGGCondicion IN (", ")")+")");
      }
      if ( ( AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV122Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int29[11] = (byte)(1) ;
      }
      if ( AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV123Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels, "AplIIGGRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object30[0] = scmdbuf ;
      GXv_Object30[1] = GXv_int29 ;
      return GXv_Object30 ;
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
                  return conditional_H00BQ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Number) dynConstraints[33]).intValue() , (String)dynConstraints[34] , ((Number) dynConstraints[35]).shortValue() , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , ((Boolean) dynConstraints[39]).booleanValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() );
            case 1 :
                  return conditional_H00BQ3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Number) dynConstraints[33]).intValue() , (String)dynConstraints[34] , ((Number) dynConstraints[35]).shortValue() , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , ((Boolean) dynConstraints[39]).booleanValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00BQ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00BQ3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((String[]) buf[4])[0] = rslt.getString(4, 10);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[7])[0] = rslt.getString(6, 10);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(7, 40);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,4);
               ((byte[]) buf[13])[0] = rslt.getByte(10);
               ((String[]) buf[14])[0] = rslt.getVarchar(11);
               ((short[]) buf[15])[0] = rslt.getShort(12);
               ((int[]) buf[16])[0] = rslt.getInt(13);
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
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[24], 10);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[25], 20);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 40);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[28]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[29]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[22], 20);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               return;
      }
   }

}

