package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importacion_legajoww_impl extends GXDataArea
{
   public importacion_legajoww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importacion_legajoww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_legajoww_impl.class ));
   }

   public importacion_legajoww_impl( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      chkavSelected = UIFactory.getCheckbox(this);
      chkavSelectall = UIFactory.getCheckbox(this);
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
            AV249MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV249MenuOpcCod", AV249MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV249MenuOpcCod, ""))));
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
      nRC_GXsfl_97 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_97"))) ;
      nGXsfl_97_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_97_idx"))) ;
      sGXsfl_97_idx = httpContext.GetPar( "sGXsfl_97_idx") ;
      chkavSelected.setTitleFormat( (short)(GXutil.lval( httpContext.GetNextPar( ))) );
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
      AV269ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV22ColumnsSelector);
      AV289Pgmname = httpContext.GetPar( "Pgmname") ;
      AV210CliCodJson = httpContext.GetPar( "CliCodJson") ;
      AV214EmpCodJson = httpContext.GetPar( "EmpCodJson") ;
      AV218MigrLegNumeroJson = httpContext.GetPar( "MigrLegNumeroJson") ;
      AV249MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV13GridState);
      AV239TFiconoUpdate = httpContext.GetPar( "TFiconoUpdate") ;
      AV240TFiconoUpdateOperator = (short)(GXutil.lval( httpContext.GetPar( "TFiconoUpdateOperator"))) ;
      AV108TFMigrLegId = httpContext.GetPar( "TFMigrLegId") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV109TFMigrLegId_Sels);
      AV43TFMigrLegCUIL = httpContext.GetPar( "TFMigrLegCUIL") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV44TFMigrLegCUIL_Sels);
      AV26TFMigrLegApellido = httpContext.GetPar( "TFMigrLegApellido") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV27TFMigrLegApellido_Sels);
      AV29TFMigrLegNombre = httpContext.GetPar( "TFMigrLegNombre") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30TFMigrLegNombre_Sels);
      AV281TFMigrLegModTra = httpContext.GetPar( "TFMigrLegModTra") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV282TFMigrLegModTra_Sels);
      AV284TFMigrLegTipoTarifa = httpContext.GetPar( "TFMigrLegTipoTarifa") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV285TFMigrLegTipoTarifa_Sels);
      AV75TFMigrLegClase = httpContext.GetPar( "TFMigrLegClase") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV76TFMigrLegClase_Sels);
      AV31TFMigrLegFecNac = localUtil.parseDateParm( httpContext.GetPar( "TFMigrLegFecNac")) ;
      AV32TFMigrLegFecNac_To = localUtil.parseDateParm( httpContext.GetPar( "TFMigrLegFecNac_To")) ;
      AV60TFMigrLegFecIngreso = localUtil.parseDateParm( httpContext.GetPar( "TFMigrLegFecIngreso")) ;
      AV61TFMigrLegFecIngreso_To = localUtil.parseDateParm( httpContext.GetPar( "TFMigrLegFecIngreso_To")) ;
      AV37TFMigrLegSexo = httpContext.GetPar( "TFMigrLegSexo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV38TFMigrLegSexo_Sels);
      AV49TFMigrLegDomici = httpContext.GetPar( "TFMigrLegDomici") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV50TFMigrLegDomici_Sels);
      AV55TFMigrLegCodPos = httpContext.GetPar( "TFMigrLegCodPos") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV56TFMigrLegCodPos_Sels);
      AV58TFMigrLegTelefono = httpContext.GetPar( "TFMigrLegTelefono") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV59TFMigrLegTelefono_Sels);
      AV52TFMigrLegEmail = httpContext.GetPar( "TFMigrLegEmail") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV53TFMigrLegEmail_Sels);
      AV40TFMigrLegEstadoCivil = httpContext.GetPar( "TFMigrLegEstadoCivil") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV41TFMigrLegEstadoCivil_Sels);
      AV69TFMigrLegArea = httpContext.GetPar( "TFMigrLegArea") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV70TFMigrLegArea_Sels);
      AV77TFMigrLegBasico = CommonUtil.decimalVal( httpContext.GetPar( "TFMigrLegBasico"), ".") ;
      AV78TFMigrLegBasico_To = CommonUtil.decimalVal( httpContext.GetPar( "TFMigrLegBasico_To"), ".") ;
      AV120TFMigrLegConvenio = httpContext.GetPar( "TFMigrLegConvenio") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV121TFMigrLegConvenio_Sels);
      AV137TFMigrLegObraSocial = httpContext.GetPar( "TFMigrLegObraSocial") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV138TFMigrLegObraSocial_Sels);
      AV114TFMigrLegCBU = httpContext.GetPar( "TFMigrLegCBU") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV115TFMigrLegCBU_Sels);
      AV134TFMigrLegModalidad = httpContext.GetPar( "TFMigrLegModalidad") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV135TFMigrLegModalidad_Sels);
      AV270TFMigrLegHorSem = CommonUtil.decimalVal( httpContext.GetPar( "TFMigrLegHorSem"), ".") ;
      AV271TFMigrLegHorSem_To = CommonUtil.decimalVal( httpContext.GetPar( "TFMigrLegHorSem_To"), ".") ;
      AV140TFMigrLegObs = httpContext.GetPar( "TFMigrLegObs") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV141TFMigrLegObs_Sels);
      AV92TFMigrLegSindicato = httpContext.GetPar( "TFMigrLegSindicato") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV93TFMigrLegSindicato_Sels);
      AV15OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV16OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV104CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      chkavSelected.setTitleFormat( (short)(GXutil.lval( httpContext.GetNextPar( ))) );
      AV100IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV102IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV208i = GXutil.lval( httpContext.GetPar( "i")) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV209CliCodCol);
      AV212CliCodToFind = (int)(GXutil.lval( httpContext.GetPar( "CliCodToFind"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV213EmpCodCol);
      AV216EmpCodToFind = (short)(GXutil.lval( httpContext.GetPar( "EmpCodToFind"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV217MigrLegNumeroCol);
      AV220MigrLegNumeroToFind = (int)(GXutil.lval( httpContext.GetPar( "MigrLegNumeroToFind"))) ;
      AV105EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV251WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      AV221SelectAll = GXutil.strtobool( httpContext.GetPar( "SelectAll")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV269ManageFiltersExecutionStep, AV22ColumnsSelector, AV289Pgmname, AV210CliCodJson, AV214EmpCodJson, AV218MigrLegNumeroJson, AV249MenuOpcCod, AV13GridState, AV239TFiconoUpdate, AV240TFiconoUpdateOperator, AV108TFMigrLegId, AV109TFMigrLegId_Sels, AV43TFMigrLegCUIL, AV44TFMigrLegCUIL_Sels, AV26TFMigrLegApellido, AV27TFMigrLegApellido_Sels, AV29TFMigrLegNombre, AV30TFMigrLegNombre_Sels, AV281TFMigrLegModTra, AV282TFMigrLegModTra_Sels, AV284TFMigrLegTipoTarifa, AV285TFMigrLegTipoTarifa_Sels, AV75TFMigrLegClase, AV76TFMigrLegClase_Sels, AV31TFMigrLegFecNac, AV32TFMigrLegFecNac_To, AV60TFMigrLegFecIngreso, AV61TFMigrLegFecIngreso_To, AV37TFMigrLegSexo, AV38TFMigrLegSexo_Sels, AV49TFMigrLegDomici, AV50TFMigrLegDomici_Sels, AV55TFMigrLegCodPos, AV56TFMigrLegCodPos_Sels, AV58TFMigrLegTelefono, AV59TFMigrLegTelefono_Sels, AV52TFMigrLegEmail, AV53TFMigrLegEmail_Sels, AV40TFMigrLegEstadoCivil, AV41TFMigrLegEstadoCivil_Sels, AV69TFMigrLegArea, AV70TFMigrLegArea_Sels, AV77TFMigrLegBasico, AV78TFMigrLegBasico_To, AV120TFMigrLegConvenio, AV121TFMigrLegConvenio_Sels, AV137TFMigrLegObraSocial, AV138TFMigrLegObraSocial_Sels, AV114TFMigrLegCBU, AV115TFMigrLegCBU_Sels, AV134TFMigrLegModalidad, AV135TFMigrLegModalidad_Sels, AV270TFMigrLegHorSem, AV271TFMigrLegHorSem_To, AV140TFMigrLegObs, AV141TFMigrLegObs_Sels, AV92TFMigrLegSindicato, AV93TFMigrLegSindicato_Sels, AV15OrderedBy, AV16OrderedDsc, AV104CliCod, AV100IsAuthorized_Update, AV102IsAuthorized_Delete, AV208i, AV209CliCodCol, AV212CliCodToFind, AV213EmpCodCol, AV216EmpCodToFind, AV217MigrLegNumeroCol, AV220MigrLegNumeroToFind, AV105EmpCod, AV251WelcomeMessage_NoMostrarMas, AV221SelectAll) ;
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
      pa282( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start282( ) ;
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
      httpContext.AddJavascriptSource("UserControls/A3LFilterRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.importacion_legajoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV249MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV289Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV249MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV100IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV102IsAuthorized_Delete));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_97", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_97, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV267ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV267ManageFiltersData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV94DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV94DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV22ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV22ColumnsSelector);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV96GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV97GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV98GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vDDO_MIGRLEGFECNACAUXDATE", localUtil.dtoc( AV33DDO_MigrLegFecNacAuxDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vDDO_MIGRLEGFECNACAUXDATETO", localUtil.dtoc( AV34DDO_MigrLegFecNacAuxDateTo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vDDO_MIGRLEGFECINGRESOAUXDATE", localUtil.dtoc( AV62DDO_MigrLegFecIngresoAuxDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vDDO_MIGRLEGFECINGRESOAUXDATETO", localUtil.dtoc( AV63DDO_MigrLegFecIngresoAuxDateTo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV269ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV289Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV289Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICODJSON", AV210CliCodJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCODJSON", AV214EmpCodJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vMIGRLEGNUMEROJSON", AV218MigrLegNumeroJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV249MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV249MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV13GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV13GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFICONOUPDATE", GXutil.rtrim( AV239TFiconoUpdate));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFICONOUPDATEOPERATOR", GXutil.ltrim( localUtil.ntoc( AV240TFiconoUpdateOperator, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGID", GXutil.rtrim( AV108TFMigrLegId));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGID_SELS", AV109TFMigrLegId_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGID_SELS", AV109TFMigrLegId_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGCUIL", GXutil.rtrim( AV43TFMigrLegCUIL));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGCUIL_SELS", AV44TFMigrLegCUIL_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGCUIL_SELS", AV44TFMigrLegCUIL_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGAPELLIDO", AV26TFMigrLegApellido);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGAPELLIDO_SELS", AV27TFMigrLegApellido_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGAPELLIDO_SELS", AV27TFMigrLegApellido_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGNOMBRE", AV29TFMigrLegNombre);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGNOMBRE_SELS", AV30TFMigrLegNombre_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGNOMBRE_SELS", AV30TFMigrLegNombre_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGMODTRA", AV281TFMigrLegModTra);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGMODTRA_SELS", AV282TFMigrLegModTra_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGMODTRA_SELS", AV282TFMigrLegModTra_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGTIPOTARIFA", AV284TFMigrLegTipoTarifa);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGTIPOTARIFA_SELS", AV285TFMigrLegTipoTarifa_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGTIPOTARIFA_SELS", AV285TFMigrLegTipoTarifa_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGCLASE", AV75TFMigrLegClase);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGCLASE_SELS", AV76TFMigrLegClase_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGCLASE_SELS", AV76TFMigrLegClase_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGFECNAC", localUtil.dtoc( AV31TFMigrLegFecNac, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGFECNAC_TO", localUtil.dtoc( AV32TFMigrLegFecNac_To, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGFECINGRESO", localUtil.dtoc( AV60TFMigrLegFecIngreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGFECINGRESO_TO", localUtil.dtoc( AV61TFMigrLegFecIngreso_To, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGSEXO", GXutil.rtrim( AV37TFMigrLegSexo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGSEXO_SELS", AV38TFMigrLegSexo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGSEXO_SELS", AV38TFMigrLegSexo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGDOMICI", AV49TFMigrLegDomici);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGDOMICI_SELS", AV50TFMigrLegDomici_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGDOMICI_SELS", AV50TFMigrLegDomici_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGCODPOS", AV55TFMigrLegCodPos);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGCODPOS_SELS", AV56TFMigrLegCodPos_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGCODPOS_SELS", AV56TFMigrLegCodPos_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGTELEFONO", AV58TFMigrLegTelefono);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGTELEFONO_SELS", AV59TFMigrLegTelefono_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGTELEFONO_SELS", AV59TFMigrLegTelefono_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGEMAIL", AV52TFMigrLegEmail);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGEMAIL_SELS", AV53TFMigrLegEmail_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGEMAIL_SELS", AV53TFMigrLegEmail_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGESTADOCIVIL", AV40TFMigrLegEstadoCivil);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGESTADOCIVIL_SELS", AV41TFMigrLegEstadoCivil_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGESTADOCIVIL_SELS", AV41TFMigrLegEstadoCivil_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGAREA", AV69TFMigrLegArea);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGAREA_SELS", AV70TFMigrLegArea_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGAREA_SELS", AV70TFMigrLegArea_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGBASICO", GXutil.ltrim( localUtil.ntoc( AV77TFMigrLegBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGBASICO_TO", GXutil.ltrim( localUtil.ntoc( AV78TFMigrLegBasico_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGCONVENIO", AV120TFMigrLegConvenio);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGCONVENIO_SELS", AV121TFMigrLegConvenio_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGCONVENIO_SELS", AV121TFMigrLegConvenio_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGOBRASOCIAL", AV137TFMigrLegObraSocial);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGOBRASOCIAL_SELS", AV138TFMigrLegObraSocial_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGOBRASOCIAL_SELS", AV138TFMigrLegObraSocial_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGCBU", AV114TFMigrLegCBU);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGCBU_SELS", AV115TFMigrLegCBU_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGCBU_SELS", AV115TFMigrLegCBU_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGMODALIDAD", AV134TFMigrLegModalidad);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGMODALIDAD_SELS", AV135TFMigrLegModalidad_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGMODALIDAD_SELS", AV135TFMigrLegModalidad_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGHORSEM", GXutil.ltrim( localUtil.ntoc( AV270TFMigrLegHorSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGHORSEM_TO", GXutil.ltrim( localUtil.ntoc( AV271TFMigrLegHorSem_To, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGOBS", AV140TFMigrLegObs);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGOBS_SELS", AV141TFMigrLegObs_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGOBS_SELS", AV141TFMigrLegObs_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGSINDICATO", AV92TFMigrLegSindicato);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFMIGRLEGSINDICATO_SELS", AV93TFMigrLegSindicato_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFMIGRLEGSINDICATO_SELS", AV93TFMigrLegSindicato_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV15OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV16OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV104CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGERRORES", A629MigrLegErrores);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGWARNINGS", A633MigrLegWarnings);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV100IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV100IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV102IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV102IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vI", GXutil.ltrim( localUtil.ntoc( AV208i, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLICODCOL", AV209CliCodCol);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLICODCOL", AV209CliCodCol);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICODTOFIND", GXutil.ltrim( localUtil.ntoc( AV212CliCodToFind, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vEMPCODCOL", AV213EmpCodCol);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vEMPCODCOL", AV213EmpCodCol);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCODTOFIND", GXutil.ltrim( localUtil.ntoc( AV216EmpCodToFind, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMIGRLEGNUMEROCOL", AV217MigrLegNumeroCol);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMIGRLEGNUMEROCOL", AV217MigrLegNumeroCol);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMIGRLEGNUMEROTOFIND", GXutil.ltrim( localUtil.ntoc( AV220MigrLegNumeroToFind, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGID_SELSJSON", AV107TFMigrLegId_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGCUIL_SELSJSON", AV42TFMigrLegCUIL_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGAPELLIDO_SELSJSON", AV25TFMigrLegApellido_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGNOMBRE_SELSJSON", AV28TFMigrLegNombre_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGMODTRA_SELSJSON", AV280TFMigrLegModTra_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGTIPOTARIFA_SELSJSON", AV283TFMigrLegTipoTarifa_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGCLASE_SELSJSON", AV74TFMigrLegClase_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGSEXO_SELSJSON", AV36TFMigrLegSexo_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGDOMICI_SELSJSON", AV48TFMigrLegDomici_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGCODPOS_SELSJSON", AV54TFMigrLegCodPos_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGTELEFONO_SELSJSON", AV57TFMigrLegTelefono_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGEMAIL_SELSJSON", AV51TFMigrLegEmail_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGESTADOCIVIL_SELSJSON", AV39TFMigrLegEstadoCivil_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGAREA_SELSJSON", AV68TFMigrLegArea_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGCONVENIO_SELSJSON", AV119TFMigrLegConvenio_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGOBRASOCIAL_SELSJSON", AV136TFMigrLegObraSocial_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGCBU_SELSJSON", AV113TFMigrLegCBU_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGMODALIDAD_SELSJSON", AV133TFMigrLegModalidad_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGOBS_SELSJSON", AV139TFMigrLegObs_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFMIGRLEGSINDICATO_SELSJSON", AV91TFMigrLegSindicato_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV105EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSELECTEDROWS", AV206SelectedRows);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSELECTEDROWS", AV206SelectedRows);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV234CliCod_Selected, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV235EmpCod_Selected, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMIGRLEGNUMERO_SELECTED", GXutil.ltrim( localUtil.ntoc( AV236MigrLegNumero_Selected, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENSAJETEXTO", AV259mensajeTexto);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vEXTRAPARMS", AV8ExtraParms);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vEXTRAPARMS", AV8ExtraParms);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Icontype", GXutil.rtrim( Ddo_gridcolumnsselector_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Icon", GXutil.rtrim( Ddo_gridcolumnsselector_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Caption", GXutil.rtrim( Ddo_gridcolumnsselector_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Tooltip", GXutil.rtrim( Ddo_gridcolumnsselector_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Cls", GXutil.rtrim( Ddo_gridcolumnsselector_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype", GXutil.rtrim( Ddo_gridcolumnsselector_Dropdownoptionstype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Gridinternalname", GXutil.rtrim( Ddo_gridcolumnsselector_Gridinternalname));
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
      web.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Target", GXutil.rtrim( Innewwindow1_Target));
      web.GxWebStd.gx_hidden_field( httpContext, "POPOVER_ICONOUPDATE_Gridinternalname", GXutil.rtrim( Popover_iconoupdate_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "POPOVER_ICONOUPDATE_Iteminternalname", GXutil.rtrim( Popover_iconoupdate_Iteminternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "POPOVER_ICONOUPDATE_Isgriditem", GXutil.booltostr( Popover_iconoupdate_Isgriditem));
      web.GxWebStd.gx_hidden_field( httpContext, "POPOVER_ICONOUPDATE_Popoverwidth", GXutil.ltrim( localUtil.ntoc( Popover_iconoupdate_Popoverwidth, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "POPOVER_ICONOUPDATE_Visible", GXutil.booltostr( Popover_iconoupdate_Visible));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Fixedfilters", GXutil.rtrim( Ddo_grid_Fixedfilters));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Format", GXutil.rtrim( Ddo_grid_Format));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedfixedfilter", GXutil.rtrim( Ddo_grid_Selectedfixedfilter));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Title", GXutil.rtrim( Dvelop_confirmpanel_btnimportarlegajosalsistema_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_btnimportarlegajosalsistema_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_btnimportarlegajosalsistema_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_btnimportarlegajosalsistema_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_btnimportarlegajosalsistema_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_btnimportarlegajosalsistema_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_btnimportarlegajosalsistema_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Title", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Title", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPORTEXCEL_MODAL_Width", GXutil.rtrim( Importexcel_modal_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPORTEXCEL_MODAL_Title", GXutil.rtrim( Importexcel_modal_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPORTEXCEL_MODAL_Confirmtype", GXutil.rtrim( Importexcel_modal_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPORTEXCEL_MODAL_Bodytype", GXutil.rtrim( Importexcel_modal_Bodytype));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hascolumnsselector", GXutil.booltostr( Grid_empowerer_Hascolumnsselector));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Popoversingrid", GXutil.rtrim( Grid_empowerer_Popoversingrid));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumnfixedfilter", GXutil.rtrim( Ddo_grid_Selectedcolumnfixedfilter));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "vDISPLAY_Link", GXutil.rtrim( edtavDisplay_Link));
      web.GxWebStd.gx_hidden_field( httpContext, "vUPDATE_Link", GXutil.rtrim( edtavUpdate_Link));
      web.GxWebStd.gx_hidden_field( httpContext, "vDELETE_Link", GXutil.rtrim( edtavDelete_Link));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Result", GXutil.rtrim( Dvelop_confirmpanel_btnimportarlegajosalsistema_Result));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Result", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Result));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPORTEXCEL_MODAL_Result", GXutil.rtrim( Importexcel_modal_Result));
      web.GxWebStd.gx_hidden_field( httpContext, "vSELECTED_Titleformat", GXutil.ltrim( localUtil.ntoc( chkavSelected.getTitleFormat(), (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumnfixedfilter", GXutil.rtrim( Ddo_grid_Selectedcolumnfixedfilter));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vDISPLAY_Link", GXutil.rtrim( edtavDisplay_Link));
      web.GxWebStd.gx_hidden_field( httpContext, "vUPDATE_Link", GXutil.rtrim( edtavUpdate_Link));
      web.GxWebStd.gx_hidden_field( httpContext, "vDELETE_Link", GXutil.rtrim( edtavDelete_Link));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Result", GXutil.rtrim( Dvelop_confirmpanel_btnimportarlegajosalsistema_Result));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Result", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Result));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINAR_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPORTEXCEL_MODAL_Result", GXutil.rtrim( Importexcel_modal_Result));
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
      if ( ! ( WebComp_Grid_dwc == null ) )
      {
         WebComp_Grid_dwc.componentjscripts();
      }
      if ( ! ( WebComp_Wwpaux_wc == null ) )
      {
         WebComp_Wwpaux_wc.componentjscripts();
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
         we282( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt282( ) ;
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
      return formatLink("web.importacion_legajoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV249MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "importacion_legajoWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Importación de Legajos", "") ;
   }

   public void wb280( )
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
         wb_table1_9_282( true) ;
      }
      else
      {
         wb_table1_9_282( false) ;
      }
      return  ;
   }

   public void wb_table1_9_282e( boolean wbgen )
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
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table2_170_282( true) ;
      }
      else
      {
         wb_table2_170_282( false) ;
      }
      return  ;
   }

   public void wb_table2_170_282e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table3_180_282( true) ;
      }
      else
      {
         wb_table3_180_282( false) ;
      }
      return  ;
   }

   public void wb_table3_180_282e( boolean wbgen )
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
         /* User Defined Control */
         ucPopover_iconoupdate.setProperty("IsGridItem", Popover_iconoupdate_Isgriditem);
         ucPopover_iconoupdate.setProperty("PopoverWidth", Popover_iconoupdate_Popoverwidth);
         ucPopover_iconoupdate.render(context, "dvelop.wwppopover", Popover_iconoupdate_Internalname, "POPOVER_ICONOUPDATEContainer");
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
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("FixedFilters", Ddo_grid_Fixedfilters);
         ucDdo_grid.setProperty("Format", Ddo_grid_Format);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV94DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 191,'',false,'" + sGXsfl_97_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavSelectall.getInternalname(), GXutil.booltostr( AV221SelectAll), "", "", chkavSelectall.getVisible(), 1, "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,191);\"");
         wb_table4_192_282( true) ;
      }
      else
      {
         wb_table4_192_282( false) ;
      }
      return  ;
   }

   public void wb_table4_192_282e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table5_197_282( true) ;
      }
      else
      {
         wb_table5_197_282( false) ;
      }
      return  ;
   }

   public void wb_table5_197_282e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table6_202_282( true) ;
      }
      else
      {
         wb_table6_202_282( false) ;
      }
      return  ;
   }

   public void wb_table6_202_282e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table7_207_282( true) ;
      }
      else
      {
         wb_table7_207_282( false) ;
      }
      return  ;
   }

   public void wb_table7_207_282e( boolean wbgen )
   {
      if ( wbgen )
      {
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.setProperty("PopoversInGrid", Grid_empowerer_Popoversingrid);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_wwpauxwc_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0214"+"", GXutil.rtrim( WebComp_Wwpaux_wc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0214"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( bGXsfl_97_Refreshing )
            {
               if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
               {
                  if ( GXutil.strcmp(GXutil.lower( OldWwpaux_wc), GXutil.lower( WebComp_Wwpaux_wc_Component)) != 0 )
                  {
                     httpContext.ajax_rspStartCmp("gxHTMLWrpW0214"+"");
                  }
                  WebComp_Wwpaux_wc.componentdraw();
                  if ( GXutil.strcmp(GXutil.lower( OldWwpaux_wc), GXutil.lower( WebComp_Wwpaux_wc_Component)) != 0 )
                  {
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_migrlegfecnacauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 216,'',false,'" + sGXsfl_97_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_migrlegfecnacauxdatetext_Internalname, AV35DDO_MigrLegFecNacAuxDateText, GXutil.rtrim( localUtil.format( AV35DDO_MigrLegFecNacAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,216);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_migrlegfecnacauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoWW.htm");
         /* User Defined Control */
         ucTfmigrlegfecnac_rangepicker.setProperty("Start Date", AV33DDO_MigrLegFecNacAuxDate);
         ucTfmigrlegfecnac_rangepicker.setProperty("End Date", AV34DDO_MigrLegFecNacAuxDateTo);
         ucTfmigrlegfecnac_rangepicker.render(context, "wwp.daterangepicker", Tfmigrlegfecnac_rangepicker_Internalname, "TFMIGRLEGFECNAC_RANGEPICKERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_migrlegfecingresoauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 219,'',false,'" + sGXsfl_97_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_migrlegfecingresoauxdatetext_Internalname, AV64DDO_MigrLegFecIngresoAuxDateText, GXutil.rtrim( localUtil.format( AV64DDO_MigrLegFecIngresoAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,219);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_migrlegfecingresoauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajoWW.htm");
         /* User Defined Control */
         ucTfmigrlegfecingreso_rangepicker.setProperty("Start Date", AV62DDO_MigrLegFecIngresoAuxDate);
         ucTfmigrlegfecingreso_rangepicker.setProperty("End Date", AV63DDO_MigrLegFecIngresoAuxDateTo);
         ucTfmigrlegfecingreso_rangepicker.render(context, "wwp.daterangepicker", Tfmigrlegfecingreso_rangepicker_Internalname, "TFMIGRLEGFECINGRESO_RANGEPICKERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 97 )
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

   public void start282( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Importación de Legajos", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup280( ) ;
   }

   public void ws282( )
   {
      start282( ) ;
      evt282( ) ;
   }

   public void evt282( )
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
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA.CLOSE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e16282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS.CLOSE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "IMPORTEXCEL_MODAL.CLOSE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e19282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOIMPORTARLEGAJOSALSISTEMA'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoImportarLegajosAlSistema' */
                           e20282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOELIMINARTODOS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoEliminarTodos' */
                           e21282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOIMPORTARTODOS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoimportarTodos' */
                           e22282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOGENERARTEMPLATE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoGenerarTemplate' */
                           e23282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VSELECTALL.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e24282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e25282 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS.IMPORTARLEGAJOSEXCEL") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e26282 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VELIMINAR.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VSELECTED.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VSELECTED.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VELIMINAR.CLICK") == 0 ) )
                        {
                           nGXsfl_97_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_97_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_97_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_972( ) ;
                           AV205Selected = GXutil.strtobool( httpContext.cgiGet( chkavSelected.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavSelected.getInternalname(), AV205Selected);
                           AV238iconoUpdateWithTags = httpContext.cgiGet( edtavIconoupdatewithtags_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavIconoupdatewithtags_Internalname, AV238iconoUpdateWithTags);
                           AV237iconoUpdate = httpContext.cgiGet( edtavIconoupdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavIconoupdate_Internalname, AV237iconoUpdate);
                           AV233Eliminar = httpContext.cgiGet( edtavEliminar_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminar_Internalname, AV233Eliminar);
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A87MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtMigrLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A626MigrLegId = httpContext.cgiGet( edtMigrLegId_Internalname) ;
                           A597MigrLegCUIL = httpContext.cgiGet( edtMigrLegCUIL_Internalname) ;
                           A592MigrLegApellido = httpContext.cgiGet( edtMigrLegApellido_Internalname) ;
                           A593MigrLegNombre = httpContext.cgiGet( edtMigrLegNombre_Internalname) ;
                           A2415MigrLegModTra = httpContext.cgiGet( edtMigrLegModTra_Internalname) ;
                           A2427MigrLegTipoTarifa = httpContext.cgiGet( edtMigrLegTipoTarifa_Internalname) ;
                           A607MigrLegClase = httpContext.cgiGet( edtMigrLegClase_Internalname) ;
                           A594MigrLegFecNac = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtMigrLegFecNac_Internalname), 0)) ;
                           A603MigrLegFecIngreso = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtMigrLegFecIngreso_Internalname), 0)) ;
                           A595MigrLegSexo = httpContext.cgiGet( edtMigrLegSexo_Internalname) ;
                           A620MigrLegZona = httpContext.cgiGet( edtMigrLegZona_Internalname) ;
                           A599MigrLegDomici = httpContext.cgiGet( edtMigrLegDomici_Internalname) ;
                           A601MigrLegCodPos = httpContext.cgiGet( edtMigrLegCodPos_Internalname) ;
                           A602MigrLegTelefono = httpContext.cgiGet( edtMigrLegTelefono_Internalname) ;
                           A600MigrLegEmail = httpContext.cgiGet( edtMigrLegEmail_Internalname) ;
                           A596MigrLegEstadoCivil = httpContext.cgiGet( edtMigrLegEstadoCivil_Internalname) ;
                           A598MigrLegDiscapacidad = httpContext.cgiGet( edtMigrLegDiscapacidad_Internalname) ;
                           A605MigrLegArea = httpContext.cgiGet( edtMigrLegArea_Internalname) ;
                           A608MigrLegBasico = localUtil.ctond( httpContext.cgiGet( edtMigrLegBasico_Internalname)) ;
                           A627MigrLegConvenio = httpContext.cgiGet( edtMigrLegConvenio_Internalname) ;
                           AV242MigrLegCategoria_var = httpContext.cgiGet( edtavMigrlegcategoria_var_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavMigrlegcategoria_var_Internalname, AV242MigrLegCategoria_var);
                           web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGCATEGORIA_VAR"+"_"+sGXsfl_97_idx, getSecureSignedToken( sGXsfl_97_idx, GXutil.rtrim( localUtil.format( AV242MigrLegCategoria_var, ""))));
                           A604MigrLegCategoria = httpContext.cgiGet( edtMigrLegCategoria_Internalname) ;
                           A606MigrLegLugarDePago = GXutil.upper( httpContext.cgiGet( edtMigrLegLugarDePago_Internalname)) ;
                           A610MigrLegBanco = httpContext.cgiGet( edtMigrLegBanco_Internalname) ;
                           A614MigrLegObraSocial = httpContext.cgiGet( edtMigrLegObraSocial_Internalname) ;
                           A611MigrLegBanSuc = httpContext.cgiGet( edtMigrLegBanSuc_Internalname) ;
                           A612MigrLegBanTipCuen = GXutil.upper( httpContext.cgiGet( edtMigrLegBanTipCuen_Internalname)) ;
                           A619MigrLegCuentaBanc = GXutil.upper( httpContext.cgiGet( edtMigrLegCuentaBanc_Internalname)) ;
                           A609MigrLegFormaPago = httpContext.cgiGet( edtMigrLegFormaPago_Internalname) ;
                           A621MigrLegCBU = httpContext.cgiGet( edtMigrLegCBU_Internalname) ;
                           A617MigrLegModalidad = httpContext.cgiGet( edtMigrLegModalidad_Internalname) ;
                           A2275MigrLegHorSem = localUtil.ctond( httpContext.cgiGet( edtMigrLegHorSem_Internalname)) ;
                           A616MigrLegActividad = httpContext.cgiGet( edtMigrLegActividad_Internalname) ;
                           A623MigrLegSituacionRevista = GXutil.upper( httpContext.cgiGet( edtMigrLegSituacionRevista_Internalname)) ;
                           A624MigrLegCondicion = GXutil.upper( httpContext.cgiGet( edtMigrLegCondicion_Internalname)) ;
                           A625MigrLegSiniestrado = httpContext.cgiGet( edtMigrLegSiniestrado_Internalname) ;
                           A622MigrLegSCVO = httpContext.cgiGet( edtMigrLegSCVO_Internalname) ;
                           A615MigrLegPlanMedico = httpContext.cgiGet( edtMigrLegPlanMedico_Internalname) ;
                           A631MigrTieneConyuge = httpContext.cgiGet( edtMigrTieneConyuge_Internalname) ;
                           A632MigrCantidadHijos = (short)(localUtil.ctol( httpContext.cgiGet( edtMigrCantidadHijos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A628MigrLegObs = httpContext.cgiGet( edtMigrLegObs_Internalname) ;
                           A2190MigrPeriodo = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtMigrPeriodo_Internalname), 0)) ;
                           A2189MigrSueldos = httpContext.cgiGet( edtMigrSueldos_Internalname) ;
                           A2216MigrPuesto = httpContext.cgiGet( edtMigrPuesto_Internalname) ;
                           A2239MigrLegActLabClas = httpContext.cgiGet( edtMigrLegActLabClas_Internalname) ;
                           A2240MigrLegPueAfip = httpContext.cgiGet( edtMigrLegPueAfip_Internalname) ;
                           A613MigrLegSindicato = httpContext.cgiGet( edtMigrLegSindicato_Internalname) ;
                           AV248Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV248Display);
                           AV99Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV99Update);
                           AV101Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV101Delete);
                           AV262DetailWebComponent = httpContext.cgiGet( edtavDetailwebcomponent_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDetailwebcomponent_Internalname, AV262DetailWebComponent);
                           AV245VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV245VerSVG);
                           AV246ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV246ModificarSVG);
                           AV247EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV247EliminarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e27282 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e28282 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e29282 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VELIMINAR.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e30282 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VSELECTED.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e31282 ();
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
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 164 )
                     {
                        OldGrid_dwc = httpContext.cgiGet( "W0164") ;
                        if ( ( GXutil.len( OldGrid_dwc) == 0 ) || ( GXutil.strcmp(OldGrid_dwc, WebComp_Grid_dwc_Component) != 0 ) )
                        {
                           WebComp_Grid_dwc = WebUtils.getWebComponent(getClass(), "web." + OldGrid_dwc + "_impl", remoteHandle, context);
                           WebComp_Grid_dwc_Component = OldGrid_dwc ;
                        }
                        if ( GXutil.len( WebComp_Grid_dwc_Component) != 0 )
                        {
                           WebComp_Grid_dwc.componentprocess("W0164", "", sEvt);
                        }
                        WebComp_Grid_dwc_Component = OldGrid_dwc ;
                     }
                     else if ( nCmpId == 214 )
                     {
                        OldWwpaux_wc = httpContext.cgiGet( "W0214") ;
                        if ( ( GXutil.len( OldWwpaux_wc) == 0 ) || ( GXutil.strcmp(OldWwpaux_wc, WebComp_Wwpaux_wc_Component) != 0 ) )
                        {
                           WebComp_Wwpaux_wc = WebUtils.getWebComponent(getClass(), "web." + OldWwpaux_wc + "_impl", remoteHandle, context);
                           WebComp_Wwpaux_wc_Component = OldWwpaux_wc ;
                        }
                        if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
                        {
                           WebComp_Wwpaux_wc.componentprocess("W0214", "", sEvt);
                        }
                        WebComp_Wwpaux_wc_Component = OldWwpaux_wc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we282( )
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

   public void pa282( )
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
      subsflControlProps_972( ) ;
      while ( nGXsfl_97_idx <= nRC_GXsfl_97 )
      {
         sendrow_972( ) ;
         nGXsfl_97_idx = ((subGrid_Islastpage==1)&&(nGXsfl_97_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_97_idx+1) ;
         sGXsfl_97_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_97_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_972( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV269ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelector ,
                                 String AV289Pgmname ,
                                 String AV210CliCodJson ,
                                 String AV214EmpCodJson ,
                                 String AV218MigrLegNumeroJson ,
                                 String AV249MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV13GridState ,
                                 String AV239TFiconoUpdate ,
                                 short AV240TFiconoUpdateOperator ,
                                 String AV108TFMigrLegId ,
                                 GXSimpleCollection<String> AV109TFMigrLegId_Sels ,
                                 String AV43TFMigrLegCUIL ,
                                 GXSimpleCollection<String> AV44TFMigrLegCUIL_Sels ,
                                 String AV26TFMigrLegApellido ,
                                 GXSimpleCollection<String> AV27TFMigrLegApellido_Sels ,
                                 String AV29TFMigrLegNombre ,
                                 GXSimpleCollection<String> AV30TFMigrLegNombre_Sels ,
                                 String AV281TFMigrLegModTra ,
                                 GXSimpleCollection<String> AV282TFMigrLegModTra_Sels ,
                                 String AV284TFMigrLegTipoTarifa ,
                                 GXSimpleCollection<String> AV285TFMigrLegTipoTarifa_Sels ,
                                 String AV75TFMigrLegClase ,
                                 GXSimpleCollection<String> AV76TFMigrLegClase_Sels ,
                                 java.util.Date AV31TFMigrLegFecNac ,
                                 java.util.Date AV32TFMigrLegFecNac_To ,
                                 java.util.Date AV60TFMigrLegFecIngreso ,
                                 java.util.Date AV61TFMigrLegFecIngreso_To ,
                                 String AV37TFMigrLegSexo ,
                                 GXSimpleCollection<String> AV38TFMigrLegSexo_Sels ,
                                 String AV49TFMigrLegDomici ,
                                 GXSimpleCollection<String> AV50TFMigrLegDomici_Sels ,
                                 String AV55TFMigrLegCodPos ,
                                 GXSimpleCollection<String> AV56TFMigrLegCodPos_Sels ,
                                 String AV58TFMigrLegTelefono ,
                                 GXSimpleCollection<String> AV59TFMigrLegTelefono_Sels ,
                                 String AV52TFMigrLegEmail ,
                                 GXSimpleCollection<String> AV53TFMigrLegEmail_Sels ,
                                 String AV40TFMigrLegEstadoCivil ,
                                 GXSimpleCollection<String> AV41TFMigrLegEstadoCivil_Sels ,
                                 String AV69TFMigrLegArea ,
                                 GXSimpleCollection<String> AV70TFMigrLegArea_Sels ,
                                 java.math.BigDecimal AV77TFMigrLegBasico ,
                                 java.math.BigDecimal AV78TFMigrLegBasico_To ,
                                 String AV120TFMigrLegConvenio ,
                                 GXSimpleCollection<String> AV121TFMigrLegConvenio_Sels ,
                                 String AV137TFMigrLegObraSocial ,
                                 GXSimpleCollection<String> AV138TFMigrLegObraSocial_Sels ,
                                 String AV114TFMigrLegCBU ,
                                 GXSimpleCollection<String> AV115TFMigrLegCBU_Sels ,
                                 String AV134TFMigrLegModalidad ,
                                 GXSimpleCollection<String> AV135TFMigrLegModalidad_Sels ,
                                 java.math.BigDecimal AV270TFMigrLegHorSem ,
                                 java.math.BigDecimal AV271TFMigrLegHorSem_To ,
                                 String AV140TFMigrLegObs ,
                                 GXSimpleCollection<String> AV141TFMigrLegObs_Sels ,
                                 String AV92TFMigrLegSindicato ,
                                 GXSimpleCollection<String> AV93TFMigrLegSindicato_Sels ,
                                 short AV15OrderedBy ,
                                 boolean AV16OrderedDsc ,
                                 int AV104CliCod ,
                                 boolean AV100IsAuthorized_Update ,
                                 boolean AV102IsAuthorized_Delete ,
                                 long AV208i ,
                                 GXSimpleCollection<Integer> AV209CliCodCol ,
                                 int AV212CliCodToFind ,
                                 GXSimpleCollection<Short> AV213EmpCodCol ,
                                 short AV216EmpCodToFind ,
                                 GXSimpleCollection<Integer> AV217MigrLegNumeroCol ,
                                 int AV220MigrLegNumeroToFind ,
                                 short AV105EmpCod ,
                                 boolean AV251WelcomeMessage_NoMostrarMas ,
                                 boolean AV221SelectAll )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e28282 ();
      GRID_nCurrentRecord = 0 ;
      rf282( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGCATEGORIA_VAR", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV242MigrLegCategoria_var, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMIGRLEGCATEGORIA_VAR", AV242MigrLegCategoria_var);
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
      AV251WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV251WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV251WelcomeMessage_NoMostrarMas", AV251WelcomeMessage_NoMostrarMas);
      AV221SelectAll = GXutil.strtobool( GXutil.booltostr( AV221SelectAll)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV221SelectAll", AV221SelectAll);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf282( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV289Pgmname = "importacion_legajoWW" ;
      Gx_err = (short)(0) ;
      edtavIconoupdatewithtags_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavIconoupdatewithtags_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdatewithtags_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavIconoupdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavIconoupdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdate_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavEliminar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminar_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavMigrlegcategoria_var_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMigrlegcategoria_var_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMigrlegcategoria_var_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavDetailwebcomponent_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDetailwebcomponent_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDetailwebcomponent_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_97_Refreshing);
   }

   public void rf282( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(97) ;
      /* Execute user event: Refresh */
      e28282 ();
      nGXsfl_97_idx = 1 ;
      sGXsfl_97_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_97_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_972( ) ;
      bGXsfl_97_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Grid_dwc_Component) != 0 )
            {
               WebComp_Grid_dwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
            {
               WebComp_Wwpaux_wc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_972( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A626MigrLegId ,
                                              AV293Importacion_legajowwds_4_tfmigrlegid_sels ,
                                              A597MigrLegCUIL ,
                                              AV295Importacion_legajowwds_6_tfmigrlegcuil_sels ,
                                              A592MigrLegApellido ,
                                              AV297Importacion_legajowwds_8_tfmigrlegapellido_sels ,
                                              A593MigrLegNombre ,
                                              AV299Importacion_legajowwds_10_tfmigrlegnombre_sels ,
                                              A2415MigrLegModTra ,
                                              AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels ,
                                              A2427MigrLegTipoTarifa ,
                                              AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels ,
                                              A607MigrLegClase ,
                                              AV305Importacion_legajowwds_16_tfmigrlegclase_sels ,
                                              A595MigrLegSexo ,
                                              AV311Importacion_legajowwds_22_tfmigrlegsexo_sels ,
                                              A599MigrLegDomici ,
                                              AV313Importacion_legajowwds_24_tfmigrlegdomici_sels ,
                                              A601MigrLegCodPos ,
                                              AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels ,
                                              A602MigrLegTelefono ,
                                              AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels ,
                                              A600MigrLegEmail ,
                                              AV319Importacion_legajowwds_30_tfmigrlegemail_sels ,
                                              A596MigrLegEstadoCivil ,
                                              AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels ,
                                              A605MigrLegArea ,
                                              AV323Importacion_legajowwds_34_tfmigrlegarea_sels ,
                                              A627MigrLegConvenio ,
                                              AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels ,
                                              A614MigrLegObraSocial ,
                                              AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels ,
                                              A621MigrLegCBU ,
                                              AV331Importacion_legajowwds_42_tfmigrlegcbu_sels ,
                                              A617MigrLegModalidad ,
                                              AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels ,
                                              A628MigrLegObs ,
                                              AV337Importacion_legajowwds_48_tfmigrlegobs_sels ,
                                              A613MigrLegSindicato ,
                                              AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels ,
                                              Short.valueOf(AV291Importacion_legajowwds_2_tficonoupdateoperator) ,
                                              Integer.valueOf(AV293Importacion_legajowwds_4_tfmigrlegid_sels.size()) ,
                                              AV292Importacion_legajowwds_3_tfmigrlegid ,
                                              Integer.valueOf(AV295Importacion_legajowwds_6_tfmigrlegcuil_sels.size()) ,
                                              AV294Importacion_legajowwds_5_tfmigrlegcuil ,
                                              Integer.valueOf(AV297Importacion_legajowwds_8_tfmigrlegapellido_sels.size()) ,
                                              AV296Importacion_legajowwds_7_tfmigrlegapellido ,
                                              Integer.valueOf(AV299Importacion_legajowwds_10_tfmigrlegnombre_sels.size()) ,
                                              AV298Importacion_legajowwds_9_tfmigrlegnombre ,
                                              Integer.valueOf(AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels.size()) ,
                                              AV300Importacion_legajowwds_11_tfmigrlegmodtra ,
                                              Integer.valueOf(AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels.size()) ,
                                              AV302Importacion_legajowwds_13_tfmigrlegtipotarifa ,
                                              Integer.valueOf(AV305Importacion_legajowwds_16_tfmigrlegclase_sels.size()) ,
                                              AV304Importacion_legajowwds_15_tfmigrlegclase ,
                                              AV306Importacion_legajowwds_17_tfmigrlegfecnac ,
                                              AV307Importacion_legajowwds_18_tfmigrlegfecnac_to ,
                                              AV308Importacion_legajowwds_19_tfmigrlegfecingreso ,
                                              AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to ,
                                              Integer.valueOf(AV311Importacion_legajowwds_22_tfmigrlegsexo_sels.size()) ,
                                              AV310Importacion_legajowwds_21_tfmigrlegsexo ,
                                              Integer.valueOf(AV313Importacion_legajowwds_24_tfmigrlegdomici_sels.size()) ,
                                              AV312Importacion_legajowwds_23_tfmigrlegdomici ,
                                              Integer.valueOf(AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels.size()) ,
                                              AV314Importacion_legajowwds_25_tfmigrlegcodpos ,
                                              Integer.valueOf(AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels.size()) ,
                                              AV316Importacion_legajowwds_27_tfmigrlegtelefono ,
                                              Integer.valueOf(AV319Importacion_legajowwds_30_tfmigrlegemail_sels.size()) ,
                                              AV318Importacion_legajowwds_29_tfmigrlegemail ,
                                              Integer.valueOf(AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels.size()) ,
                                              AV320Importacion_legajowwds_31_tfmigrlegestadocivil ,
                                              Integer.valueOf(AV323Importacion_legajowwds_34_tfmigrlegarea_sels.size()) ,
                                              AV322Importacion_legajowwds_33_tfmigrlegarea ,
                                              AV324Importacion_legajowwds_35_tfmigrlegbasico ,
                                              AV325Importacion_legajowwds_36_tfmigrlegbasico_to ,
                                              Integer.valueOf(AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels.size()) ,
                                              AV326Importacion_legajowwds_37_tfmigrlegconvenio ,
                                              Integer.valueOf(AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels.size()) ,
                                              AV328Importacion_legajowwds_39_tfmigrlegobrasocial ,
                                              Integer.valueOf(AV331Importacion_legajowwds_42_tfmigrlegcbu_sels.size()) ,
                                              AV330Importacion_legajowwds_41_tfmigrlegcbu ,
                                              Integer.valueOf(AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels.size()) ,
                                              AV332Importacion_legajowwds_43_tfmigrlegmodalidad ,
                                              AV334Importacion_legajowwds_45_tfmigrleghorsem ,
                                              AV335Importacion_legajowwds_46_tfmigrleghorsem_to ,
                                              Integer.valueOf(AV337Importacion_legajowwds_48_tfmigrlegobs_sels.size()) ,
                                              AV336Importacion_legajowwds_47_tfmigrlegobs ,
                                              Integer.valueOf(AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels.size()) ,
                                              AV338Importacion_legajowwds_49_tfmigrlegsindicato ,
                                              A629MigrLegErrores ,
                                              A633MigrLegWarnings ,
                                              A594MigrLegFecNac ,
                                              A603MigrLegFecIngreso ,
                                              A608MigrLegBasico ,
                                              A2275MigrLegHorSem ,
                                              Short.valueOf(AV15OrderedBy) ,
                                              Boolean.valueOf(AV16OrderedDsc) ,
                                              Integer.valueOf(AV104CliCod) ,
                                              Short.valueOf(AV105EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                              TypeConstants.SHORT
                                              }
         });
         lV292Importacion_legajowwds_3_tfmigrlegid = GXutil.padr( GXutil.rtrim( AV292Importacion_legajowwds_3_tfmigrlegid), 20, "%") ;
         lV294Importacion_legajowwds_5_tfmigrlegcuil = GXutil.padr( GXutil.rtrim( AV294Importacion_legajowwds_5_tfmigrlegcuil), 13, "%") ;
         lV296Importacion_legajowwds_7_tfmigrlegapellido = GXutil.concat( GXutil.rtrim( AV296Importacion_legajowwds_7_tfmigrlegapellido), "%", "") ;
         lV298Importacion_legajowwds_9_tfmigrlegnombre = GXutil.concat( GXutil.rtrim( AV298Importacion_legajowwds_9_tfmigrlegnombre), "%", "") ;
         lV300Importacion_legajowwds_11_tfmigrlegmodtra = GXutil.concat( GXutil.rtrim( AV300Importacion_legajowwds_11_tfmigrlegmodtra), "%", "") ;
         lV302Importacion_legajowwds_13_tfmigrlegtipotarifa = GXutil.concat( GXutil.rtrim( AV302Importacion_legajowwds_13_tfmigrlegtipotarifa), "%", "") ;
         lV304Importacion_legajowwds_15_tfmigrlegclase = GXutil.concat( GXutil.rtrim( AV304Importacion_legajowwds_15_tfmigrlegclase), "%", "") ;
         lV310Importacion_legajowwds_21_tfmigrlegsexo = GXutil.padr( GXutil.rtrim( AV310Importacion_legajowwds_21_tfmigrlegsexo), 20, "%") ;
         lV312Importacion_legajowwds_23_tfmigrlegdomici = GXutil.concat( GXutil.rtrim( AV312Importacion_legajowwds_23_tfmigrlegdomici), "%", "") ;
         lV314Importacion_legajowwds_25_tfmigrlegcodpos = GXutil.concat( GXutil.rtrim( AV314Importacion_legajowwds_25_tfmigrlegcodpos), "%", "") ;
         lV316Importacion_legajowwds_27_tfmigrlegtelefono = GXutil.concat( GXutil.rtrim( AV316Importacion_legajowwds_27_tfmigrlegtelefono), "%", "") ;
         lV318Importacion_legajowwds_29_tfmigrlegemail = GXutil.concat( GXutil.rtrim( AV318Importacion_legajowwds_29_tfmigrlegemail), "%", "") ;
         lV320Importacion_legajowwds_31_tfmigrlegestadocivil = GXutil.concat( GXutil.rtrim( AV320Importacion_legajowwds_31_tfmigrlegestadocivil), "%", "") ;
         lV322Importacion_legajowwds_33_tfmigrlegarea = GXutil.concat( GXutil.rtrim( AV322Importacion_legajowwds_33_tfmigrlegarea), "%", "") ;
         lV326Importacion_legajowwds_37_tfmigrlegconvenio = GXutil.concat( GXutil.rtrim( AV326Importacion_legajowwds_37_tfmigrlegconvenio), "%", "") ;
         lV328Importacion_legajowwds_39_tfmigrlegobrasocial = GXutil.concat( GXutil.rtrim( AV328Importacion_legajowwds_39_tfmigrlegobrasocial), "%", "") ;
         lV330Importacion_legajowwds_41_tfmigrlegcbu = GXutil.concat( GXutil.rtrim( AV330Importacion_legajowwds_41_tfmigrlegcbu), "%", "") ;
         lV332Importacion_legajowwds_43_tfmigrlegmodalidad = GXutil.concat( GXutil.rtrim( AV332Importacion_legajowwds_43_tfmigrlegmodalidad), "%", "") ;
         lV336Importacion_legajowwds_47_tfmigrlegobs = GXutil.concat( GXutil.rtrim( AV336Importacion_legajowwds_47_tfmigrlegobs), "%", "") ;
         lV338Importacion_legajowwds_49_tfmigrlegsindicato = GXutil.concat( GXutil.rtrim( AV338Importacion_legajowwds_49_tfmigrlegsindicato), "%", "") ;
         /* Using cursor H00282 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV104CliCod), Short.valueOf(AV105EmpCod), lV292Importacion_legajowwds_3_tfmigrlegid, lV294Importacion_legajowwds_5_tfmigrlegcuil, lV296Importacion_legajowwds_7_tfmigrlegapellido, lV298Importacion_legajowwds_9_tfmigrlegnombre, lV300Importacion_legajowwds_11_tfmigrlegmodtra, lV302Importacion_legajowwds_13_tfmigrlegtipotarifa, lV304Importacion_legajowwds_15_tfmigrlegclase, AV306Importacion_legajowwds_17_tfmigrlegfecnac, AV307Importacion_legajowwds_18_tfmigrlegfecnac_to, AV308Importacion_legajowwds_19_tfmigrlegfecingreso, AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to, lV310Importacion_legajowwds_21_tfmigrlegsexo, lV312Importacion_legajowwds_23_tfmigrlegdomici, lV314Importacion_legajowwds_25_tfmigrlegcodpos, lV316Importacion_legajowwds_27_tfmigrlegtelefono, lV318Importacion_legajowwds_29_tfmigrlegemail, lV320Importacion_legajowwds_31_tfmigrlegestadocivil, lV322Importacion_legajowwds_33_tfmigrlegarea, AV324Importacion_legajowwds_35_tfmigrlegbasico, AV325Importacion_legajowwds_36_tfmigrlegbasico_to, lV326Importacion_legajowwds_37_tfmigrlegconvenio, lV328Importacion_legajowwds_39_tfmigrlegobrasocial, lV330Importacion_legajowwds_41_tfmigrlegcbu, lV332Importacion_legajowwds_43_tfmigrlegmodalidad, AV334Importacion_legajowwds_45_tfmigrleghorsem, AV335Importacion_legajowwds_46_tfmigrleghorsem_to, lV336Importacion_legajowwds_47_tfmigrlegobs, lV338Importacion_legajowwds_49_tfmigrlegsindicato, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_97_idx = 1 ;
         sGXsfl_97_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_97_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_972( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A629MigrLegErrores = H00282_A629MigrLegErrores[0] ;
            A633MigrLegWarnings = H00282_A633MigrLegWarnings[0] ;
            A613MigrLegSindicato = H00282_A613MigrLegSindicato[0] ;
            A2240MigrLegPueAfip = H00282_A2240MigrLegPueAfip[0] ;
            A2239MigrLegActLabClas = H00282_A2239MigrLegActLabClas[0] ;
            A2216MigrPuesto = H00282_A2216MigrPuesto[0] ;
            A2189MigrSueldos = H00282_A2189MigrSueldos[0] ;
            A2190MigrPeriodo = H00282_A2190MigrPeriodo[0] ;
            A628MigrLegObs = H00282_A628MigrLegObs[0] ;
            A632MigrCantidadHijos = H00282_A632MigrCantidadHijos[0] ;
            A631MigrTieneConyuge = H00282_A631MigrTieneConyuge[0] ;
            A615MigrLegPlanMedico = H00282_A615MigrLegPlanMedico[0] ;
            A622MigrLegSCVO = H00282_A622MigrLegSCVO[0] ;
            A625MigrLegSiniestrado = H00282_A625MigrLegSiniestrado[0] ;
            A624MigrLegCondicion = H00282_A624MigrLegCondicion[0] ;
            A623MigrLegSituacionRevista = H00282_A623MigrLegSituacionRevista[0] ;
            A616MigrLegActividad = H00282_A616MigrLegActividad[0] ;
            A2275MigrLegHorSem = H00282_A2275MigrLegHorSem[0] ;
            A617MigrLegModalidad = H00282_A617MigrLegModalidad[0] ;
            A621MigrLegCBU = H00282_A621MigrLegCBU[0] ;
            A609MigrLegFormaPago = H00282_A609MigrLegFormaPago[0] ;
            A619MigrLegCuentaBanc = H00282_A619MigrLegCuentaBanc[0] ;
            A612MigrLegBanTipCuen = H00282_A612MigrLegBanTipCuen[0] ;
            A611MigrLegBanSuc = H00282_A611MigrLegBanSuc[0] ;
            A614MigrLegObraSocial = H00282_A614MigrLegObraSocial[0] ;
            A610MigrLegBanco = H00282_A610MigrLegBanco[0] ;
            A606MigrLegLugarDePago = H00282_A606MigrLegLugarDePago[0] ;
            A604MigrLegCategoria = H00282_A604MigrLegCategoria[0] ;
            A627MigrLegConvenio = H00282_A627MigrLegConvenio[0] ;
            A608MigrLegBasico = H00282_A608MigrLegBasico[0] ;
            A605MigrLegArea = H00282_A605MigrLegArea[0] ;
            A598MigrLegDiscapacidad = H00282_A598MigrLegDiscapacidad[0] ;
            A596MigrLegEstadoCivil = H00282_A596MigrLegEstadoCivil[0] ;
            A600MigrLegEmail = H00282_A600MigrLegEmail[0] ;
            A602MigrLegTelefono = H00282_A602MigrLegTelefono[0] ;
            A601MigrLegCodPos = H00282_A601MigrLegCodPos[0] ;
            A599MigrLegDomici = H00282_A599MigrLegDomici[0] ;
            A620MigrLegZona = H00282_A620MigrLegZona[0] ;
            A595MigrLegSexo = H00282_A595MigrLegSexo[0] ;
            A603MigrLegFecIngreso = H00282_A603MigrLegFecIngreso[0] ;
            A594MigrLegFecNac = H00282_A594MigrLegFecNac[0] ;
            A607MigrLegClase = H00282_A607MigrLegClase[0] ;
            A2427MigrLegTipoTarifa = H00282_A2427MigrLegTipoTarifa[0] ;
            A2415MigrLegModTra = H00282_A2415MigrLegModTra[0] ;
            A593MigrLegNombre = H00282_A593MigrLegNombre[0] ;
            A592MigrLegApellido = H00282_A592MigrLegApellido[0] ;
            A597MigrLegCUIL = H00282_A597MigrLegCUIL[0] ;
            A626MigrLegId = H00282_A626MigrLegId[0] ;
            A87MigrLegNumero = H00282_A87MigrLegNumero[0] ;
            A1EmpCod = H00282_A1EmpCod[0] ;
            A3CliCod = H00282_A3CliCod[0] ;
            e29282 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(97) ;
         wb280( ) ;
      }
      bGXsfl_97_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes282( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV289Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV289Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV249MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV249MenuOpcCod, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV100IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV100IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV102IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV102IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGCATEGORIA_VAR"+"_"+sGXsfl_97_idx, getSecureSignedToken( sGXsfl_97_idx, GXutil.rtrim( localUtil.format( AV242MigrLegCategoria_var, ""))));
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
      AV290Importacion_legajowwds_1_tficonoupdate = AV239TFiconoUpdate ;
      AV291Importacion_legajowwds_2_tficonoupdateoperator = AV240TFiconoUpdateOperator ;
      AV292Importacion_legajowwds_3_tfmigrlegid = AV108TFMigrLegId ;
      AV293Importacion_legajowwds_4_tfmigrlegid_sels = AV109TFMigrLegId_Sels ;
      AV294Importacion_legajowwds_5_tfmigrlegcuil = AV43TFMigrLegCUIL ;
      AV295Importacion_legajowwds_6_tfmigrlegcuil_sels = AV44TFMigrLegCUIL_Sels ;
      AV296Importacion_legajowwds_7_tfmigrlegapellido = AV26TFMigrLegApellido ;
      AV297Importacion_legajowwds_8_tfmigrlegapellido_sels = AV27TFMigrLegApellido_Sels ;
      AV298Importacion_legajowwds_9_tfmigrlegnombre = AV29TFMigrLegNombre ;
      AV299Importacion_legajowwds_10_tfmigrlegnombre_sels = AV30TFMigrLegNombre_Sels ;
      AV300Importacion_legajowwds_11_tfmigrlegmodtra = AV281TFMigrLegModTra ;
      AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels = AV282TFMigrLegModTra_Sels ;
      AV302Importacion_legajowwds_13_tfmigrlegtipotarifa = AV284TFMigrLegTipoTarifa ;
      AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels = AV285TFMigrLegTipoTarifa_Sels ;
      AV304Importacion_legajowwds_15_tfmigrlegclase = AV75TFMigrLegClase ;
      AV305Importacion_legajowwds_16_tfmigrlegclase_sels = AV76TFMigrLegClase_Sels ;
      AV306Importacion_legajowwds_17_tfmigrlegfecnac = AV31TFMigrLegFecNac ;
      AV307Importacion_legajowwds_18_tfmigrlegfecnac_to = AV32TFMigrLegFecNac_To ;
      AV308Importacion_legajowwds_19_tfmigrlegfecingreso = AV60TFMigrLegFecIngreso ;
      AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to = AV61TFMigrLegFecIngreso_To ;
      AV310Importacion_legajowwds_21_tfmigrlegsexo = AV37TFMigrLegSexo ;
      AV311Importacion_legajowwds_22_tfmigrlegsexo_sels = AV38TFMigrLegSexo_Sels ;
      AV312Importacion_legajowwds_23_tfmigrlegdomici = AV49TFMigrLegDomici ;
      AV313Importacion_legajowwds_24_tfmigrlegdomici_sels = AV50TFMigrLegDomici_Sels ;
      AV314Importacion_legajowwds_25_tfmigrlegcodpos = AV55TFMigrLegCodPos ;
      AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels = AV56TFMigrLegCodPos_Sels ;
      AV316Importacion_legajowwds_27_tfmigrlegtelefono = AV58TFMigrLegTelefono ;
      AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels = AV59TFMigrLegTelefono_Sels ;
      AV318Importacion_legajowwds_29_tfmigrlegemail = AV52TFMigrLegEmail ;
      AV319Importacion_legajowwds_30_tfmigrlegemail_sels = AV53TFMigrLegEmail_Sels ;
      AV320Importacion_legajowwds_31_tfmigrlegestadocivil = AV40TFMigrLegEstadoCivil ;
      AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels = AV41TFMigrLegEstadoCivil_Sels ;
      AV322Importacion_legajowwds_33_tfmigrlegarea = AV69TFMigrLegArea ;
      AV323Importacion_legajowwds_34_tfmigrlegarea_sels = AV70TFMigrLegArea_Sels ;
      AV324Importacion_legajowwds_35_tfmigrlegbasico = AV77TFMigrLegBasico ;
      AV325Importacion_legajowwds_36_tfmigrlegbasico_to = AV78TFMigrLegBasico_To ;
      AV326Importacion_legajowwds_37_tfmigrlegconvenio = AV120TFMigrLegConvenio ;
      AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels = AV121TFMigrLegConvenio_Sels ;
      AV328Importacion_legajowwds_39_tfmigrlegobrasocial = AV137TFMigrLegObraSocial ;
      AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels = AV138TFMigrLegObraSocial_Sels ;
      AV330Importacion_legajowwds_41_tfmigrlegcbu = AV114TFMigrLegCBU ;
      AV331Importacion_legajowwds_42_tfmigrlegcbu_sels = AV115TFMigrLegCBU_Sels ;
      AV332Importacion_legajowwds_43_tfmigrlegmodalidad = AV134TFMigrLegModalidad ;
      AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels = AV135TFMigrLegModalidad_Sels ;
      AV334Importacion_legajowwds_45_tfmigrleghorsem = AV270TFMigrLegHorSem ;
      AV335Importacion_legajowwds_46_tfmigrleghorsem_to = AV271TFMigrLegHorSem_To ;
      AV336Importacion_legajowwds_47_tfmigrlegobs = AV140TFMigrLegObs ;
      AV337Importacion_legajowwds_48_tfmigrlegobs_sels = AV141TFMigrLegObs_Sels ;
      AV338Importacion_legajowwds_49_tfmigrlegsindicato = AV92TFMigrLegSindicato ;
      AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels = AV93TFMigrLegSindicato_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A626MigrLegId ,
                                           AV293Importacion_legajowwds_4_tfmigrlegid_sels ,
                                           A597MigrLegCUIL ,
                                           AV295Importacion_legajowwds_6_tfmigrlegcuil_sels ,
                                           A592MigrLegApellido ,
                                           AV297Importacion_legajowwds_8_tfmigrlegapellido_sels ,
                                           A593MigrLegNombre ,
                                           AV299Importacion_legajowwds_10_tfmigrlegnombre_sels ,
                                           A2415MigrLegModTra ,
                                           AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels ,
                                           A2427MigrLegTipoTarifa ,
                                           AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels ,
                                           A607MigrLegClase ,
                                           AV305Importacion_legajowwds_16_tfmigrlegclase_sels ,
                                           A595MigrLegSexo ,
                                           AV311Importacion_legajowwds_22_tfmigrlegsexo_sels ,
                                           A599MigrLegDomici ,
                                           AV313Importacion_legajowwds_24_tfmigrlegdomici_sels ,
                                           A601MigrLegCodPos ,
                                           AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels ,
                                           A602MigrLegTelefono ,
                                           AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels ,
                                           A600MigrLegEmail ,
                                           AV319Importacion_legajowwds_30_tfmigrlegemail_sels ,
                                           A596MigrLegEstadoCivil ,
                                           AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels ,
                                           A605MigrLegArea ,
                                           AV323Importacion_legajowwds_34_tfmigrlegarea_sels ,
                                           A627MigrLegConvenio ,
                                           AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels ,
                                           A614MigrLegObraSocial ,
                                           AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels ,
                                           A621MigrLegCBU ,
                                           AV331Importacion_legajowwds_42_tfmigrlegcbu_sels ,
                                           A617MigrLegModalidad ,
                                           AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels ,
                                           A628MigrLegObs ,
                                           AV337Importacion_legajowwds_48_tfmigrlegobs_sels ,
                                           A613MigrLegSindicato ,
                                           AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels ,
                                           Short.valueOf(AV291Importacion_legajowwds_2_tficonoupdateoperator) ,
                                           Integer.valueOf(AV293Importacion_legajowwds_4_tfmigrlegid_sels.size()) ,
                                           AV292Importacion_legajowwds_3_tfmigrlegid ,
                                           Integer.valueOf(AV295Importacion_legajowwds_6_tfmigrlegcuil_sels.size()) ,
                                           AV294Importacion_legajowwds_5_tfmigrlegcuil ,
                                           Integer.valueOf(AV297Importacion_legajowwds_8_tfmigrlegapellido_sels.size()) ,
                                           AV296Importacion_legajowwds_7_tfmigrlegapellido ,
                                           Integer.valueOf(AV299Importacion_legajowwds_10_tfmigrlegnombre_sels.size()) ,
                                           AV298Importacion_legajowwds_9_tfmigrlegnombre ,
                                           Integer.valueOf(AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels.size()) ,
                                           AV300Importacion_legajowwds_11_tfmigrlegmodtra ,
                                           Integer.valueOf(AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels.size()) ,
                                           AV302Importacion_legajowwds_13_tfmigrlegtipotarifa ,
                                           Integer.valueOf(AV305Importacion_legajowwds_16_tfmigrlegclase_sels.size()) ,
                                           AV304Importacion_legajowwds_15_tfmigrlegclase ,
                                           AV306Importacion_legajowwds_17_tfmigrlegfecnac ,
                                           AV307Importacion_legajowwds_18_tfmigrlegfecnac_to ,
                                           AV308Importacion_legajowwds_19_tfmigrlegfecingreso ,
                                           AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to ,
                                           Integer.valueOf(AV311Importacion_legajowwds_22_tfmigrlegsexo_sels.size()) ,
                                           AV310Importacion_legajowwds_21_tfmigrlegsexo ,
                                           Integer.valueOf(AV313Importacion_legajowwds_24_tfmigrlegdomici_sels.size()) ,
                                           AV312Importacion_legajowwds_23_tfmigrlegdomici ,
                                           Integer.valueOf(AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels.size()) ,
                                           AV314Importacion_legajowwds_25_tfmigrlegcodpos ,
                                           Integer.valueOf(AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels.size()) ,
                                           AV316Importacion_legajowwds_27_tfmigrlegtelefono ,
                                           Integer.valueOf(AV319Importacion_legajowwds_30_tfmigrlegemail_sels.size()) ,
                                           AV318Importacion_legajowwds_29_tfmigrlegemail ,
                                           Integer.valueOf(AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels.size()) ,
                                           AV320Importacion_legajowwds_31_tfmigrlegestadocivil ,
                                           Integer.valueOf(AV323Importacion_legajowwds_34_tfmigrlegarea_sels.size()) ,
                                           AV322Importacion_legajowwds_33_tfmigrlegarea ,
                                           AV324Importacion_legajowwds_35_tfmigrlegbasico ,
                                           AV325Importacion_legajowwds_36_tfmigrlegbasico_to ,
                                           Integer.valueOf(AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels.size()) ,
                                           AV326Importacion_legajowwds_37_tfmigrlegconvenio ,
                                           Integer.valueOf(AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels.size()) ,
                                           AV328Importacion_legajowwds_39_tfmigrlegobrasocial ,
                                           Integer.valueOf(AV331Importacion_legajowwds_42_tfmigrlegcbu_sels.size()) ,
                                           AV330Importacion_legajowwds_41_tfmigrlegcbu ,
                                           Integer.valueOf(AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels.size()) ,
                                           AV332Importacion_legajowwds_43_tfmigrlegmodalidad ,
                                           AV334Importacion_legajowwds_45_tfmigrleghorsem ,
                                           AV335Importacion_legajowwds_46_tfmigrleghorsem_to ,
                                           Integer.valueOf(AV337Importacion_legajowwds_48_tfmigrlegobs_sels.size()) ,
                                           AV336Importacion_legajowwds_47_tfmigrlegobs ,
                                           Integer.valueOf(AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels.size()) ,
                                           AV338Importacion_legajowwds_49_tfmigrlegsindicato ,
                                           A629MigrLegErrores ,
                                           A633MigrLegWarnings ,
                                           A594MigrLegFecNac ,
                                           A603MigrLegFecIngreso ,
                                           A608MigrLegBasico ,
                                           A2275MigrLegHorSem ,
                                           Short.valueOf(AV15OrderedBy) ,
                                           Boolean.valueOf(AV16OrderedDsc) ,
                                           Integer.valueOf(AV104CliCod) ,
                                           Short.valueOf(AV105EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV292Importacion_legajowwds_3_tfmigrlegid = GXutil.padr( GXutil.rtrim( AV292Importacion_legajowwds_3_tfmigrlegid), 20, "%") ;
      lV294Importacion_legajowwds_5_tfmigrlegcuil = GXutil.padr( GXutil.rtrim( AV294Importacion_legajowwds_5_tfmigrlegcuil), 13, "%") ;
      lV296Importacion_legajowwds_7_tfmigrlegapellido = GXutil.concat( GXutil.rtrim( AV296Importacion_legajowwds_7_tfmigrlegapellido), "%", "") ;
      lV298Importacion_legajowwds_9_tfmigrlegnombre = GXutil.concat( GXutil.rtrim( AV298Importacion_legajowwds_9_tfmigrlegnombre), "%", "") ;
      lV300Importacion_legajowwds_11_tfmigrlegmodtra = GXutil.concat( GXutil.rtrim( AV300Importacion_legajowwds_11_tfmigrlegmodtra), "%", "") ;
      lV302Importacion_legajowwds_13_tfmigrlegtipotarifa = GXutil.concat( GXutil.rtrim( AV302Importacion_legajowwds_13_tfmigrlegtipotarifa), "%", "") ;
      lV304Importacion_legajowwds_15_tfmigrlegclase = GXutil.concat( GXutil.rtrim( AV304Importacion_legajowwds_15_tfmigrlegclase), "%", "") ;
      lV310Importacion_legajowwds_21_tfmigrlegsexo = GXutil.padr( GXutil.rtrim( AV310Importacion_legajowwds_21_tfmigrlegsexo), 20, "%") ;
      lV312Importacion_legajowwds_23_tfmigrlegdomici = GXutil.concat( GXutil.rtrim( AV312Importacion_legajowwds_23_tfmigrlegdomici), "%", "") ;
      lV314Importacion_legajowwds_25_tfmigrlegcodpos = GXutil.concat( GXutil.rtrim( AV314Importacion_legajowwds_25_tfmigrlegcodpos), "%", "") ;
      lV316Importacion_legajowwds_27_tfmigrlegtelefono = GXutil.concat( GXutil.rtrim( AV316Importacion_legajowwds_27_tfmigrlegtelefono), "%", "") ;
      lV318Importacion_legajowwds_29_tfmigrlegemail = GXutil.concat( GXutil.rtrim( AV318Importacion_legajowwds_29_tfmigrlegemail), "%", "") ;
      lV320Importacion_legajowwds_31_tfmigrlegestadocivil = GXutil.concat( GXutil.rtrim( AV320Importacion_legajowwds_31_tfmigrlegestadocivil), "%", "") ;
      lV322Importacion_legajowwds_33_tfmigrlegarea = GXutil.concat( GXutil.rtrim( AV322Importacion_legajowwds_33_tfmigrlegarea), "%", "") ;
      lV326Importacion_legajowwds_37_tfmigrlegconvenio = GXutil.concat( GXutil.rtrim( AV326Importacion_legajowwds_37_tfmigrlegconvenio), "%", "") ;
      lV328Importacion_legajowwds_39_tfmigrlegobrasocial = GXutil.concat( GXutil.rtrim( AV328Importacion_legajowwds_39_tfmigrlegobrasocial), "%", "") ;
      lV330Importacion_legajowwds_41_tfmigrlegcbu = GXutil.concat( GXutil.rtrim( AV330Importacion_legajowwds_41_tfmigrlegcbu), "%", "") ;
      lV332Importacion_legajowwds_43_tfmigrlegmodalidad = GXutil.concat( GXutil.rtrim( AV332Importacion_legajowwds_43_tfmigrlegmodalidad), "%", "") ;
      lV336Importacion_legajowwds_47_tfmigrlegobs = GXutil.concat( GXutil.rtrim( AV336Importacion_legajowwds_47_tfmigrlegobs), "%", "") ;
      lV338Importacion_legajowwds_49_tfmigrlegsindicato = GXutil.concat( GXutil.rtrim( AV338Importacion_legajowwds_49_tfmigrlegsindicato), "%", "") ;
      /* Using cursor H00283 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV104CliCod), Short.valueOf(AV105EmpCod), lV292Importacion_legajowwds_3_tfmigrlegid, lV294Importacion_legajowwds_5_tfmigrlegcuil, lV296Importacion_legajowwds_7_tfmigrlegapellido, lV298Importacion_legajowwds_9_tfmigrlegnombre, lV300Importacion_legajowwds_11_tfmigrlegmodtra, lV302Importacion_legajowwds_13_tfmigrlegtipotarifa, lV304Importacion_legajowwds_15_tfmigrlegclase, AV306Importacion_legajowwds_17_tfmigrlegfecnac, AV307Importacion_legajowwds_18_tfmigrlegfecnac_to, AV308Importacion_legajowwds_19_tfmigrlegfecingreso, AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to, lV310Importacion_legajowwds_21_tfmigrlegsexo, lV312Importacion_legajowwds_23_tfmigrlegdomici, lV314Importacion_legajowwds_25_tfmigrlegcodpos, lV316Importacion_legajowwds_27_tfmigrlegtelefono, lV318Importacion_legajowwds_29_tfmigrlegemail, lV320Importacion_legajowwds_31_tfmigrlegestadocivil, lV322Importacion_legajowwds_33_tfmigrlegarea, AV324Importacion_legajowwds_35_tfmigrlegbasico, AV325Importacion_legajowwds_36_tfmigrlegbasico_to, lV326Importacion_legajowwds_37_tfmigrlegconvenio, lV328Importacion_legajowwds_39_tfmigrlegobrasocial, lV330Importacion_legajowwds_41_tfmigrlegcbu, lV332Importacion_legajowwds_43_tfmigrlegmodalidad, AV334Importacion_legajowwds_45_tfmigrleghorsem, AV335Importacion_legajowwds_46_tfmigrleghorsem_to, lV336Importacion_legajowwds_47_tfmigrlegobs, lV338Importacion_legajowwds_49_tfmigrlegsindicato});
      GRID_nRecordCount = H00283_AGRID_nRecordCount[0] ;
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
      AV290Importacion_legajowwds_1_tficonoupdate = AV239TFiconoUpdate ;
      AV291Importacion_legajowwds_2_tficonoupdateoperator = AV240TFiconoUpdateOperator ;
      AV292Importacion_legajowwds_3_tfmigrlegid = AV108TFMigrLegId ;
      AV293Importacion_legajowwds_4_tfmigrlegid_sels = AV109TFMigrLegId_Sels ;
      AV294Importacion_legajowwds_5_tfmigrlegcuil = AV43TFMigrLegCUIL ;
      AV295Importacion_legajowwds_6_tfmigrlegcuil_sels = AV44TFMigrLegCUIL_Sels ;
      AV296Importacion_legajowwds_7_tfmigrlegapellido = AV26TFMigrLegApellido ;
      AV297Importacion_legajowwds_8_tfmigrlegapellido_sels = AV27TFMigrLegApellido_Sels ;
      AV298Importacion_legajowwds_9_tfmigrlegnombre = AV29TFMigrLegNombre ;
      AV299Importacion_legajowwds_10_tfmigrlegnombre_sels = AV30TFMigrLegNombre_Sels ;
      AV300Importacion_legajowwds_11_tfmigrlegmodtra = AV281TFMigrLegModTra ;
      AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels = AV282TFMigrLegModTra_Sels ;
      AV302Importacion_legajowwds_13_tfmigrlegtipotarifa = AV284TFMigrLegTipoTarifa ;
      AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels = AV285TFMigrLegTipoTarifa_Sels ;
      AV304Importacion_legajowwds_15_tfmigrlegclase = AV75TFMigrLegClase ;
      AV305Importacion_legajowwds_16_tfmigrlegclase_sels = AV76TFMigrLegClase_Sels ;
      AV306Importacion_legajowwds_17_tfmigrlegfecnac = AV31TFMigrLegFecNac ;
      AV307Importacion_legajowwds_18_tfmigrlegfecnac_to = AV32TFMigrLegFecNac_To ;
      AV308Importacion_legajowwds_19_tfmigrlegfecingreso = AV60TFMigrLegFecIngreso ;
      AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to = AV61TFMigrLegFecIngreso_To ;
      AV310Importacion_legajowwds_21_tfmigrlegsexo = AV37TFMigrLegSexo ;
      AV311Importacion_legajowwds_22_tfmigrlegsexo_sels = AV38TFMigrLegSexo_Sels ;
      AV312Importacion_legajowwds_23_tfmigrlegdomici = AV49TFMigrLegDomici ;
      AV313Importacion_legajowwds_24_tfmigrlegdomici_sels = AV50TFMigrLegDomici_Sels ;
      AV314Importacion_legajowwds_25_tfmigrlegcodpos = AV55TFMigrLegCodPos ;
      AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels = AV56TFMigrLegCodPos_Sels ;
      AV316Importacion_legajowwds_27_tfmigrlegtelefono = AV58TFMigrLegTelefono ;
      AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels = AV59TFMigrLegTelefono_Sels ;
      AV318Importacion_legajowwds_29_tfmigrlegemail = AV52TFMigrLegEmail ;
      AV319Importacion_legajowwds_30_tfmigrlegemail_sels = AV53TFMigrLegEmail_Sels ;
      AV320Importacion_legajowwds_31_tfmigrlegestadocivil = AV40TFMigrLegEstadoCivil ;
      AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels = AV41TFMigrLegEstadoCivil_Sels ;
      AV322Importacion_legajowwds_33_tfmigrlegarea = AV69TFMigrLegArea ;
      AV323Importacion_legajowwds_34_tfmigrlegarea_sels = AV70TFMigrLegArea_Sels ;
      AV324Importacion_legajowwds_35_tfmigrlegbasico = AV77TFMigrLegBasico ;
      AV325Importacion_legajowwds_36_tfmigrlegbasico_to = AV78TFMigrLegBasico_To ;
      AV326Importacion_legajowwds_37_tfmigrlegconvenio = AV120TFMigrLegConvenio ;
      AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels = AV121TFMigrLegConvenio_Sels ;
      AV328Importacion_legajowwds_39_tfmigrlegobrasocial = AV137TFMigrLegObraSocial ;
      AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels = AV138TFMigrLegObraSocial_Sels ;
      AV330Importacion_legajowwds_41_tfmigrlegcbu = AV114TFMigrLegCBU ;
      AV331Importacion_legajowwds_42_tfmigrlegcbu_sels = AV115TFMigrLegCBU_Sels ;
      AV332Importacion_legajowwds_43_tfmigrlegmodalidad = AV134TFMigrLegModalidad ;
      AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels = AV135TFMigrLegModalidad_Sels ;
      AV334Importacion_legajowwds_45_tfmigrleghorsem = AV270TFMigrLegHorSem ;
      AV335Importacion_legajowwds_46_tfmigrleghorsem_to = AV271TFMigrLegHorSem_To ;
      AV336Importacion_legajowwds_47_tfmigrlegobs = AV140TFMigrLegObs ;
      AV337Importacion_legajowwds_48_tfmigrlegobs_sels = AV141TFMigrLegObs_Sels ;
      AV338Importacion_legajowwds_49_tfmigrlegsindicato = AV92TFMigrLegSindicato ;
      AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels = AV93TFMigrLegSindicato_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV269ManageFiltersExecutionStep, AV22ColumnsSelector, AV289Pgmname, AV210CliCodJson, AV214EmpCodJson, AV218MigrLegNumeroJson, AV249MenuOpcCod, AV13GridState, AV239TFiconoUpdate, AV240TFiconoUpdateOperator, AV108TFMigrLegId, AV109TFMigrLegId_Sels, AV43TFMigrLegCUIL, AV44TFMigrLegCUIL_Sels, AV26TFMigrLegApellido, AV27TFMigrLegApellido_Sels, AV29TFMigrLegNombre, AV30TFMigrLegNombre_Sels, AV281TFMigrLegModTra, AV282TFMigrLegModTra_Sels, AV284TFMigrLegTipoTarifa, AV285TFMigrLegTipoTarifa_Sels, AV75TFMigrLegClase, AV76TFMigrLegClase_Sels, AV31TFMigrLegFecNac, AV32TFMigrLegFecNac_To, AV60TFMigrLegFecIngreso, AV61TFMigrLegFecIngreso_To, AV37TFMigrLegSexo, AV38TFMigrLegSexo_Sels, AV49TFMigrLegDomici, AV50TFMigrLegDomici_Sels, AV55TFMigrLegCodPos, AV56TFMigrLegCodPos_Sels, AV58TFMigrLegTelefono, AV59TFMigrLegTelefono_Sels, AV52TFMigrLegEmail, AV53TFMigrLegEmail_Sels, AV40TFMigrLegEstadoCivil, AV41TFMigrLegEstadoCivil_Sels, AV69TFMigrLegArea, AV70TFMigrLegArea_Sels, AV77TFMigrLegBasico, AV78TFMigrLegBasico_To, AV120TFMigrLegConvenio, AV121TFMigrLegConvenio_Sels, AV137TFMigrLegObraSocial, AV138TFMigrLegObraSocial_Sels, AV114TFMigrLegCBU, AV115TFMigrLegCBU_Sels, AV134TFMigrLegModalidad, AV135TFMigrLegModalidad_Sels, AV270TFMigrLegHorSem, AV271TFMigrLegHorSem_To, AV140TFMigrLegObs, AV141TFMigrLegObs_Sels, AV92TFMigrLegSindicato, AV93TFMigrLegSindicato_Sels, AV15OrderedBy, AV16OrderedDsc, AV104CliCod, AV100IsAuthorized_Update, AV102IsAuthorized_Delete, AV208i, AV209CliCodCol, AV212CliCodToFind, AV213EmpCodCol, AV216EmpCodToFind, AV217MigrLegNumeroCol, AV220MigrLegNumeroToFind, AV105EmpCod, AV251WelcomeMessage_NoMostrarMas, AV221SelectAll) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV290Importacion_legajowwds_1_tficonoupdate = AV239TFiconoUpdate ;
      AV291Importacion_legajowwds_2_tficonoupdateoperator = AV240TFiconoUpdateOperator ;
      AV292Importacion_legajowwds_3_tfmigrlegid = AV108TFMigrLegId ;
      AV293Importacion_legajowwds_4_tfmigrlegid_sels = AV109TFMigrLegId_Sels ;
      AV294Importacion_legajowwds_5_tfmigrlegcuil = AV43TFMigrLegCUIL ;
      AV295Importacion_legajowwds_6_tfmigrlegcuil_sels = AV44TFMigrLegCUIL_Sels ;
      AV296Importacion_legajowwds_7_tfmigrlegapellido = AV26TFMigrLegApellido ;
      AV297Importacion_legajowwds_8_tfmigrlegapellido_sels = AV27TFMigrLegApellido_Sels ;
      AV298Importacion_legajowwds_9_tfmigrlegnombre = AV29TFMigrLegNombre ;
      AV299Importacion_legajowwds_10_tfmigrlegnombre_sels = AV30TFMigrLegNombre_Sels ;
      AV300Importacion_legajowwds_11_tfmigrlegmodtra = AV281TFMigrLegModTra ;
      AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels = AV282TFMigrLegModTra_Sels ;
      AV302Importacion_legajowwds_13_tfmigrlegtipotarifa = AV284TFMigrLegTipoTarifa ;
      AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels = AV285TFMigrLegTipoTarifa_Sels ;
      AV304Importacion_legajowwds_15_tfmigrlegclase = AV75TFMigrLegClase ;
      AV305Importacion_legajowwds_16_tfmigrlegclase_sels = AV76TFMigrLegClase_Sels ;
      AV306Importacion_legajowwds_17_tfmigrlegfecnac = AV31TFMigrLegFecNac ;
      AV307Importacion_legajowwds_18_tfmigrlegfecnac_to = AV32TFMigrLegFecNac_To ;
      AV308Importacion_legajowwds_19_tfmigrlegfecingreso = AV60TFMigrLegFecIngreso ;
      AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to = AV61TFMigrLegFecIngreso_To ;
      AV310Importacion_legajowwds_21_tfmigrlegsexo = AV37TFMigrLegSexo ;
      AV311Importacion_legajowwds_22_tfmigrlegsexo_sels = AV38TFMigrLegSexo_Sels ;
      AV312Importacion_legajowwds_23_tfmigrlegdomici = AV49TFMigrLegDomici ;
      AV313Importacion_legajowwds_24_tfmigrlegdomici_sels = AV50TFMigrLegDomici_Sels ;
      AV314Importacion_legajowwds_25_tfmigrlegcodpos = AV55TFMigrLegCodPos ;
      AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels = AV56TFMigrLegCodPos_Sels ;
      AV316Importacion_legajowwds_27_tfmigrlegtelefono = AV58TFMigrLegTelefono ;
      AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels = AV59TFMigrLegTelefono_Sels ;
      AV318Importacion_legajowwds_29_tfmigrlegemail = AV52TFMigrLegEmail ;
      AV319Importacion_legajowwds_30_tfmigrlegemail_sels = AV53TFMigrLegEmail_Sels ;
      AV320Importacion_legajowwds_31_tfmigrlegestadocivil = AV40TFMigrLegEstadoCivil ;
      AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels = AV41TFMigrLegEstadoCivil_Sels ;
      AV322Importacion_legajowwds_33_tfmigrlegarea = AV69TFMigrLegArea ;
      AV323Importacion_legajowwds_34_tfmigrlegarea_sels = AV70TFMigrLegArea_Sels ;
      AV324Importacion_legajowwds_35_tfmigrlegbasico = AV77TFMigrLegBasico ;
      AV325Importacion_legajowwds_36_tfmigrlegbasico_to = AV78TFMigrLegBasico_To ;
      AV326Importacion_legajowwds_37_tfmigrlegconvenio = AV120TFMigrLegConvenio ;
      AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels = AV121TFMigrLegConvenio_Sels ;
      AV328Importacion_legajowwds_39_tfmigrlegobrasocial = AV137TFMigrLegObraSocial ;
      AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels = AV138TFMigrLegObraSocial_Sels ;
      AV330Importacion_legajowwds_41_tfmigrlegcbu = AV114TFMigrLegCBU ;
      AV331Importacion_legajowwds_42_tfmigrlegcbu_sels = AV115TFMigrLegCBU_Sels ;
      AV332Importacion_legajowwds_43_tfmigrlegmodalidad = AV134TFMigrLegModalidad ;
      AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels = AV135TFMigrLegModalidad_Sels ;
      AV334Importacion_legajowwds_45_tfmigrleghorsem = AV270TFMigrLegHorSem ;
      AV335Importacion_legajowwds_46_tfmigrleghorsem_to = AV271TFMigrLegHorSem_To ;
      AV336Importacion_legajowwds_47_tfmigrlegobs = AV140TFMigrLegObs ;
      AV337Importacion_legajowwds_48_tfmigrlegobs_sels = AV141TFMigrLegObs_Sels ;
      AV338Importacion_legajowwds_49_tfmigrlegsindicato = AV92TFMigrLegSindicato ;
      AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels = AV93TFMigrLegSindicato_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV269ManageFiltersExecutionStep, AV22ColumnsSelector, AV289Pgmname, AV210CliCodJson, AV214EmpCodJson, AV218MigrLegNumeroJson, AV249MenuOpcCod, AV13GridState, AV239TFiconoUpdate, AV240TFiconoUpdateOperator, AV108TFMigrLegId, AV109TFMigrLegId_Sels, AV43TFMigrLegCUIL, AV44TFMigrLegCUIL_Sels, AV26TFMigrLegApellido, AV27TFMigrLegApellido_Sels, AV29TFMigrLegNombre, AV30TFMigrLegNombre_Sels, AV281TFMigrLegModTra, AV282TFMigrLegModTra_Sels, AV284TFMigrLegTipoTarifa, AV285TFMigrLegTipoTarifa_Sels, AV75TFMigrLegClase, AV76TFMigrLegClase_Sels, AV31TFMigrLegFecNac, AV32TFMigrLegFecNac_To, AV60TFMigrLegFecIngreso, AV61TFMigrLegFecIngreso_To, AV37TFMigrLegSexo, AV38TFMigrLegSexo_Sels, AV49TFMigrLegDomici, AV50TFMigrLegDomici_Sels, AV55TFMigrLegCodPos, AV56TFMigrLegCodPos_Sels, AV58TFMigrLegTelefono, AV59TFMigrLegTelefono_Sels, AV52TFMigrLegEmail, AV53TFMigrLegEmail_Sels, AV40TFMigrLegEstadoCivil, AV41TFMigrLegEstadoCivil_Sels, AV69TFMigrLegArea, AV70TFMigrLegArea_Sels, AV77TFMigrLegBasico, AV78TFMigrLegBasico_To, AV120TFMigrLegConvenio, AV121TFMigrLegConvenio_Sels, AV137TFMigrLegObraSocial, AV138TFMigrLegObraSocial_Sels, AV114TFMigrLegCBU, AV115TFMigrLegCBU_Sels, AV134TFMigrLegModalidad, AV135TFMigrLegModalidad_Sels, AV270TFMigrLegHorSem, AV271TFMigrLegHorSem_To, AV140TFMigrLegObs, AV141TFMigrLegObs_Sels, AV92TFMigrLegSindicato, AV93TFMigrLegSindicato_Sels, AV15OrderedBy, AV16OrderedDsc, AV104CliCod, AV100IsAuthorized_Update, AV102IsAuthorized_Delete, AV208i, AV209CliCodCol, AV212CliCodToFind, AV213EmpCodCol, AV216EmpCodToFind, AV217MigrLegNumeroCol, AV220MigrLegNumeroToFind, AV105EmpCod, AV251WelcomeMessage_NoMostrarMas, AV221SelectAll) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV290Importacion_legajowwds_1_tficonoupdate = AV239TFiconoUpdate ;
      AV291Importacion_legajowwds_2_tficonoupdateoperator = AV240TFiconoUpdateOperator ;
      AV292Importacion_legajowwds_3_tfmigrlegid = AV108TFMigrLegId ;
      AV293Importacion_legajowwds_4_tfmigrlegid_sels = AV109TFMigrLegId_Sels ;
      AV294Importacion_legajowwds_5_tfmigrlegcuil = AV43TFMigrLegCUIL ;
      AV295Importacion_legajowwds_6_tfmigrlegcuil_sels = AV44TFMigrLegCUIL_Sels ;
      AV296Importacion_legajowwds_7_tfmigrlegapellido = AV26TFMigrLegApellido ;
      AV297Importacion_legajowwds_8_tfmigrlegapellido_sels = AV27TFMigrLegApellido_Sels ;
      AV298Importacion_legajowwds_9_tfmigrlegnombre = AV29TFMigrLegNombre ;
      AV299Importacion_legajowwds_10_tfmigrlegnombre_sels = AV30TFMigrLegNombre_Sels ;
      AV300Importacion_legajowwds_11_tfmigrlegmodtra = AV281TFMigrLegModTra ;
      AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels = AV282TFMigrLegModTra_Sels ;
      AV302Importacion_legajowwds_13_tfmigrlegtipotarifa = AV284TFMigrLegTipoTarifa ;
      AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels = AV285TFMigrLegTipoTarifa_Sels ;
      AV304Importacion_legajowwds_15_tfmigrlegclase = AV75TFMigrLegClase ;
      AV305Importacion_legajowwds_16_tfmigrlegclase_sels = AV76TFMigrLegClase_Sels ;
      AV306Importacion_legajowwds_17_tfmigrlegfecnac = AV31TFMigrLegFecNac ;
      AV307Importacion_legajowwds_18_tfmigrlegfecnac_to = AV32TFMigrLegFecNac_To ;
      AV308Importacion_legajowwds_19_tfmigrlegfecingreso = AV60TFMigrLegFecIngreso ;
      AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to = AV61TFMigrLegFecIngreso_To ;
      AV310Importacion_legajowwds_21_tfmigrlegsexo = AV37TFMigrLegSexo ;
      AV311Importacion_legajowwds_22_tfmigrlegsexo_sels = AV38TFMigrLegSexo_Sels ;
      AV312Importacion_legajowwds_23_tfmigrlegdomici = AV49TFMigrLegDomici ;
      AV313Importacion_legajowwds_24_tfmigrlegdomici_sels = AV50TFMigrLegDomici_Sels ;
      AV314Importacion_legajowwds_25_tfmigrlegcodpos = AV55TFMigrLegCodPos ;
      AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels = AV56TFMigrLegCodPos_Sels ;
      AV316Importacion_legajowwds_27_tfmigrlegtelefono = AV58TFMigrLegTelefono ;
      AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels = AV59TFMigrLegTelefono_Sels ;
      AV318Importacion_legajowwds_29_tfmigrlegemail = AV52TFMigrLegEmail ;
      AV319Importacion_legajowwds_30_tfmigrlegemail_sels = AV53TFMigrLegEmail_Sels ;
      AV320Importacion_legajowwds_31_tfmigrlegestadocivil = AV40TFMigrLegEstadoCivil ;
      AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels = AV41TFMigrLegEstadoCivil_Sels ;
      AV322Importacion_legajowwds_33_tfmigrlegarea = AV69TFMigrLegArea ;
      AV323Importacion_legajowwds_34_tfmigrlegarea_sels = AV70TFMigrLegArea_Sels ;
      AV324Importacion_legajowwds_35_tfmigrlegbasico = AV77TFMigrLegBasico ;
      AV325Importacion_legajowwds_36_tfmigrlegbasico_to = AV78TFMigrLegBasico_To ;
      AV326Importacion_legajowwds_37_tfmigrlegconvenio = AV120TFMigrLegConvenio ;
      AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels = AV121TFMigrLegConvenio_Sels ;
      AV328Importacion_legajowwds_39_tfmigrlegobrasocial = AV137TFMigrLegObraSocial ;
      AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels = AV138TFMigrLegObraSocial_Sels ;
      AV330Importacion_legajowwds_41_tfmigrlegcbu = AV114TFMigrLegCBU ;
      AV331Importacion_legajowwds_42_tfmigrlegcbu_sels = AV115TFMigrLegCBU_Sels ;
      AV332Importacion_legajowwds_43_tfmigrlegmodalidad = AV134TFMigrLegModalidad ;
      AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels = AV135TFMigrLegModalidad_Sels ;
      AV334Importacion_legajowwds_45_tfmigrleghorsem = AV270TFMigrLegHorSem ;
      AV335Importacion_legajowwds_46_tfmigrleghorsem_to = AV271TFMigrLegHorSem_To ;
      AV336Importacion_legajowwds_47_tfmigrlegobs = AV140TFMigrLegObs ;
      AV337Importacion_legajowwds_48_tfmigrlegobs_sels = AV141TFMigrLegObs_Sels ;
      AV338Importacion_legajowwds_49_tfmigrlegsindicato = AV92TFMigrLegSindicato ;
      AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels = AV93TFMigrLegSindicato_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV269ManageFiltersExecutionStep, AV22ColumnsSelector, AV289Pgmname, AV210CliCodJson, AV214EmpCodJson, AV218MigrLegNumeroJson, AV249MenuOpcCod, AV13GridState, AV239TFiconoUpdate, AV240TFiconoUpdateOperator, AV108TFMigrLegId, AV109TFMigrLegId_Sels, AV43TFMigrLegCUIL, AV44TFMigrLegCUIL_Sels, AV26TFMigrLegApellido, AV27TFMigrLegApellido_Sels, AV29TFMigrLegNombre, AV30TFMigrLegNombre_Sels, AV281TFMigrLegModTra, AV282TFMigrLegModTra_Sels, AV284TFMigrLegTipoTarifa, AV285TFMigrLegTipoTarifa_Sels, AV75TFMigrLegClase, AV76TFMigrLegClase_Sels, AV31TFMigrLegFecNac, AV32TFMigrLegFecNac_To, AV60TFMigrLegFecIngreso, AV61TFMigrLegFecIngreso_To, AV37TFMigrLegSexo, AV38TFMigrLegSexo_Sels, AV49TFMigrLegDomici, AV50TFMigrLegDomici_Sels, AV55TFMigrLegCodPos, AV56TFMigrLegCodPos_Sels, AV58TFMigrLegTelefono, AV59TFMigrLegTelefono_Sels, AV52TFMigrLegEmail, AV53TFMigrLegEmail_Sels, AV40TFMigrLegEstadoCivil, AV41TFMigrLegEstadoCivil_Sels, AV69TFMigrLegArea, AV70TFMigrLegArea_Sels, AV77TFMigrLegBasico, AV78TFMigrLegBasico_To, AV120TFMigrLegConvenio, AV121TFMigrLegConvenio_Sels, AV137TFMigrLegObraSocial, AV138TFMigrLegObraSocial_Sels, AV114TFMigrLegCBU, AV115TFMigrLegCBU_Sels, AV134TFMigrLegModalidad, AV135TFMigrLegModalidad_Sels, AV270TFMigrLegHorSem, AV271TFMigrLegHorSem_To, AV140TFMigrLegObs, AV141TFMigrLegObs_Sels, AV92TFMigrLegSindicato, AV93TFMigrLegSindicato_Sels, AV15OrderedBy, AV16OrderedDsc, AV104CliCod, AV100IsAuthorized_Update, AV102IsAuthorized_Delete, AV208i, AV209CliCodCol, AV212CliCodToFind, AV213EmpCodCol, AV216EmpCodToFind, AV217MigrLegNumeroCol, AV220MigrLegNumeroToFind, AV105EmpCod, AV251WelcomeMessage_NoMostrarMas, AV221SelectAll) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV290Importacion_legajowwds_1_tficonoupdate = AV239TFiconoUpdate ;
      AV291Importacion_legajowwds_2_tficonoupdateoperator = AV240TFiconoUpdateOperator ;
      AV292Importacion_legajowwds_3_tfmigrlegid = AV108TFMigrLegId ;
      AV293Importacion_legajowwds_4_tfmigrlegid_sels = AV109TFMigrLegId_Sels ;
      AV294Importacion_legajowwds_5_tfmigrlegcuil = AV43TFMigrLegCUIL ;
      AV295Importacion_legajowwds_6_tfmigrlegcuil_sels = AV44TFMigrLegCUIL_Sels ;
      AV296Importacion_legajowwds_7_tfmigrlegapellido = AV26TFMigrLegApellido ;
      AV297Importacion_legajowwds_8_tfmigrlegapellido_sels = AV27TFMigrLegApellido_Sels ;
      AV298Importacion_legajowwds_9_tfmigrlegnombre = AV29TFMigrLegNombre ;
      AV299Importacion_legajowwds_10_tfmigrlegnombre_sels = AV30TFMigrLegNombre_Sels ;
      AV300Importacion_legajowwds_11_tfmigrlegmodtra = AV281TFMigrLegModTra ;
      AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels = AV282TFMigrLegModTra_Sels ;
      AV302Importacion_legajowwds_13_tfmigrlegtipotarifa = AV284TFMigrLegTipoTarifa ;
      AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels = AV285TFMigrLegTipoTarifa_Sels ;
      AV304Importacion_legajowwds_15_tfmigrlegclase = AV75TFMigrLegClase ;
      AV305Importacion_legajowwds_16_tfmigrlegclase_sels = AV76TFMigrLegClase_Sels ;
      AV306Importacion_legajowwds_17_tfmigrlegfecnac = AV31TFMigrLegFecNac ;
      AV307Importacion_legajowwds_18_tfmigrlegfecnac_to = AV32TFMigrLegFecNac_To ;
      AV308Importacion_legajowwds_19_tfmigrlegfecingreso = AV60TFMigrLegFecIngreso ;
      AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to = AV61TFMigrLegFecIngreso_To ;
      AV310Importacion_legajowwds_21_tfmigrlegsexo = AV37TFMigrLegSexo ;
      AV311Importacion_legajowwds_22_tfmigrlegsexo_sels = AV38TFMigrLegSexo_Sels ;
      AV312Importacion_legajowwds_23_tfmigrlegdomici = AV49TFMigrLegDomici ;
      AV313Importacion_legajowwds_24_tfmigrlegdomici_sels = AV50TFMigrLegDomici_Sels ;
      AV314Importacion_legajowwds_25_tfmigrlegcodpos = AV55TFMigrLegCodPos ;
      AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels = AV56TFMigrLegCodPos_Sels ;
      AV316Importacion_legajowwds_27_tfmigrlegtelefono = AV58TFMigrLegTelefono ;
      AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels = AV59TFMigrLegTelefono_Sels ;
      AV318Importacion_legajowwds_29_tfmigrlegemail = AV52TFMigrLegEmail ;
      AV319Importacion_legajowwds_30_tfmigrlegemail_sels = AV53TFMigrLegEmail_Sels ;
      AV320Importacion_legajowwds_31_tfmigrlegestadocivil = AV40TFMigrLegEstadoCivil ;
      AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels = AV41TFMigrLegEstadoCivil_Sels ;
      AV322Importacion_legajowwds_33_tfmigrlegarea = AV69TFMigrLegArea ;
      AV323Importacion_legajowwds_34_tfmigrlegarea_sels = AV70TFMigrLegArea_Sels ;
      AV324Importacion_legajowwds_35_tfmigrlegbasico = AV77TFMigrLegBasico ;
      AV325Importacion_legajowwds_36_tfmigrlegbasico_to = AV78TFMigrLegBasico_To ;
      AV326Importacion_legajowwds_37_tfmigrlegconvenio = AV120TFMigrLegConvenio ;
      AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels = AV121TFMigrLegConvenio_Sels ;
      AV328Importacion_legajowwds_39_tfmigrlegobrasocial = AV137TFMigrLegObraSocial ;
      AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels = AV138TFMigrLegObraSocial_Sels ;
      AV330Importacion_legajowwds_41_tfmigrlegcbu = AV114TFMigrLegCBU ;
      AV331Importacion_legajowwds_42_tfmigrlegcbu_sels = AV115TFMigrLegCBU_Sels ;
      AV332Importacion_legajowwds_43_tfmigrlegmodalidad = AV134TFMigrLegModalidad ;
      AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels = AV135TFMigrLegModalidad_Sels ;
      AV334Importacion_legajowwds_45_tfmigrleghorsem = AV270TFMigrLegHorSem ;
      AV335Importacion_legajowwds_46_tfmigrleghorsem_to = AV271TFMigrLegHorSem_To ;
      AV336Importacion_legajowwds_47_tfmigrlegobs = AV140TFMigrLegObs ;
      AV337Importacion_legajowwds_48_tfmigrlegobs_sels = AV141TFMigrLegObs_Sels ;
      AV338Importacion_legajowwds_49_tfmigrlegsindicato = AV92TFMigrLegSindicato ;
      AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels = AV93TFMigrLegSindicato_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV269ManageFiltersExecutionStep, AV22ColumnsSelector, AV289Pgmname, AV210CliCodJson, AV214EmpCodJson, AV218MigrLegNumeroJson, AV249MenuOpcCod, AV13GridState, AV239TFiconoUpdate, AV240TFiconoUpdateOperator, AV108TFMigrLegId, AV109TFMigrLegId_Sels, AV43TFMigrLegCUIL, AV44TFMigrLegCUIL_Sels, AV26TFMigrLegApellido, AV27TFMigrLegApellido_Sels, AV29TFMigrLegNombre, AV30TFMigrLegNombre_Sels, AV281TFMigrLegModTra, AV282TFMigrLegModTra_Sels, AV284TFMigrLegTipoTarifa, AV285TFMigrLegTipoTarifa_Sels, AV75TFMigrLegClase, AV76TFMigrLegClase_Sels, AV31TFMigrLegFecNac, AV32TFMigrLegFecNac_To, AV60TFMigrLegFecIngreso, AV61TFMigrLegFecIngreso_To, AV37TFMigrLegSexo, AV38TFMigrLegSexo_Sels, AV49TFMigrLegDomici, AV50TFMigrLegDomici_Sels, AV55TFMigrLegCodPos, AV56TFMigrLegCodPos_Sels, AV58TFMigrLegTelefono, AV59TFMigrLegTelefono_Sels, AV52TFMigrLegEmail, AV53TFMigrLegEmail_Sels, AV40TFMigrLegEstadoCivil, AV41TFMigrLegEstadoCivil_Sels, AV69TFMigrLegArea, AV70TFMigrLegArea_Sels, AV77TFMigrLegBasico, AV78TFMigrLegBasico_To, AV120TFMigrLegConvenio, AV121TFMigrLegConvenio_Sels, AV137TFMigrLegObraSocial, AV138TFMigrLegObraSocial_Sels, AV114TFMigrLegCBU, AV115TFMigrLegCBU_Sels, AV134TFMigrLegModalidad, AV135TFMigrLegModalidad_Sels, AV270TFMigrLegHorSem, AV271TFMigrLegHorSem_To, AV140TFMigrLegObs, AV141TFMigrLegObs_Sels, AV92TFMigrLegSindicato, AV93TFMigrLegSindicato_Sels, AV15OrderedBy, AV16OrderedDsc, AV104CliCod, AV100IsAuthorized_Update, AV102IsAuthorized_Delete, AV208i, AV209CliCodCol, AV212CliCodToFind, AV213EmpCodCol, AV216EmpCodToFind, AV217MigrLegNumeroCol, AV220MigrLegNumeroToFind, AV105EmpCod, AV251WelcomeMessage_NoMostrarMas, AV221SelectAll) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV290Importacion_legajowwds_1_tficonoupdate = AV239TFiconoUpdate ;
      AV291Importacion_legajowwds_2_tficonoupdateoperator = AV240TFiconoUpdateOperator ;
      AV292Importacion_legajowwds_3_tfmigrlegid = AV108TFMigrLegId ;
      AV293Importacion_legajowwds_4_tfmigrlegid_sels = AV109TFMigrLegId_Sels ;
      AV294Importacion_legajowwds_5_tfmigrlegcuil = AV43TFMigrLegCUIL ;
      AV295Importacion_legajowwds_6_tfmigrlegcuil_sels = AV44TFMigrLegCUIL_Sels ;
      AV296Importacion_legajowwds_7_tfmigrlegapellido = AV26TFMigrLegApellido ;
      AV297Importacion_legajowwds_8_tfmigrlegapellido_sels = AV27TFMigrLegApellido_Sels ;
      AV298Importacion_legajowwds_9_tfmigrlegnombre = AV29TFMigrLegNombre ;
      AV299Importacion_legajowwds_10_tfmigrlegnombre_sels = AV30TFMigrLegNombre_Sels ;
      AV300Importacion_legajowwds_11_tfmigrlegmodtra = AV281TFMigrLegModTra ;
      AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels = AV282TFMigrLegModTra_Sels ;
      AV302Importacion_legajowwds_13_tfmigrlegtipotarifa = AV284TFMigrLegTipoTarifa ;
      AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels = AV285TFMigrLegTipoTarifa_Sels ;
      AV304Importacion_legajowwds_15_tfmigrlegclase = AV75TFMigrLegClase ;
      AV305Importacion_legajowwds_16_tfmigrlegclase_sels = AV76TFMigrLegClase_Sels ;
      AV306Importacion_legajowwds_17_tfmigrlegfecnac = AV31TFMigrLegFecNac ;
      AV307Importacion_legajowwds_18_tfmigrlegfecnac_to = AV32TFMigrLegFecNac_To ;
      AV308Importacion_legajowwds_19_tfmigrlegfecingreso = AV60TFMigrLegFecIngreso ;
      AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to = AV61TFMigrLegFecIngreso_To ;
      AV310Importacion_legajowwds_21_tfmigrlegsexo = AV37TFMigrLegSexo ;
      AV311Importacion_legajowwds_22_tfmigrlegsexo_sels = AV38TFMigrLegSexo_Sels ;
      AV312Importacion_legajowwds_23_tfmigrlegdomici = AV49TFMigrLegDomici ;
      AV313Importacion_legajowwds_24_tfmigrlegdomici_sels = AV50TFMigrLegDomici_Sels ;
      AV314Importacion_legajowwds_25_tfmigrlegcodpos = AV55TFMigrLegCodPos ;
      AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels = AV56TFMigrLegCodPos_Sels ;
      AV316Importacion_legajowwds_27_tfmigrlegtelefono = AV58TFMigrLegTelefono ;
      AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels = AV59TFMigrLegTelefono_Sels ;
      AV318Importacion_legajowwds_29_tfmigrlegemail = AV52TFMigrLegEmail ;
      AV319Importacion_legajowwds_30_tfmigrlegemail_sels = AV53TFMigrLegEmail_Sels ;
      AV320Importacion_legajowwds_31_tfmigrlegestadocivil = AV40TFMigrLegEstadoCivil ;
      AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels = AV41TFMigrLegEstadoCivil_Sels ;
      AV322Importacion_legajowwds_33_tfmigrlegarea = AV69TFMigrLegArea ;
      AV323Importacion_legajowwds_34_tfmigrlegarea_sels = AV70TFMigrLegArea_Sels ;
      AV324Importacion_legajowwds_35_tfmigrlegbasico = AV77TFMigrLegBasico ;
      AV325Importacion_legajowwds_36_tfmigrlegbasico_to = AV78TFMigrLegBasico_To ;
      AV326Importacion_legajowwds_37_tfmigrlegconvenio = AV120TFMigrLegConvenio ;
      AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels = AV121TFMigrLegConvenio_Sels ;
      AV328Importacion_legajowwds_39_tfmigrlegobrasocial = AV137TFMigrLegObraSocial ;
      AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels = AV138TFMigrLegObraSocial_Sels ;
      AV330Importacion_legajowwds_41_tfmigrlegcbu = AV114TFMigrLegCBU ;
      AV331Importacion_legajowwds_42_tfmigrlegcbu_sels = AV115TFMigrLegCBU_Sels ;
      AV332Importacion_legajowwds_43_tfmigrlegmodalidad = AV134TFMigrLegModalidad ;
      AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels = AV135TFMigrLegModalidad_Sels ;
      AV334Importacion_legajowwds_45_tfmigrleghorsem = AV270TFMigrLegHorSem ;
      AV335Importacion_legajowwds_46_tfmigrleghorsem_to = AV271TFMigrLegHorSem_To ;
      AV336Importacion_legajowwds_47_tfmigrlegobs = AV140TFMigrLegObs ;
      AV337Importacion_legajowwds_48_tfmigrlegobs_sels = AV141TFMigrLegObs_Sels ;
      AV338Importacion_legajowwds_49_tfmigrlegsindicato = AV92TFMigrLegSindicato ;
      AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels = AV93TFMigrLegSindicato_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV269ManageFiltersExecutionStep, AV22ColumnsSelector, AV289Pgmname, AV210CliCodJson, AV214EmpCodJson, AV218MigrLegNumeroJson, AV249MenuOpcCod, AV13GridState, AV239TFiconoUpdate, AV240TFiconoUpdateOperator, AV108TFMigrLegId, AV109TFMigrLegId_Sels, AV43TFMigrLegCUIL, AV44TFMigrLegCUIL_Sels, AV26TFMigrLegApellido, AV27TFMigrLegApellido_Sels, AV29TFMigrLegNombre, AV30TFMigrLegNombre_Sels, AV281TFMigrLegModTra, AV282TFMigrLegModTra_Sels, AV284TFMigrLegTipoTarifa, AV285TFMigrLegTipoTarifa_Sels, AV75TFMigrLegClase, AV76TFMigrLegClase_Sels, AV31TFMigrLegFecNac, AV32TFMigrLegFecNac_To, AV60TFMigrLegFecIngreso, AV61TFMigrLegFecIngreso_To, AV37TFMigrLegSexo, AV38TFMigrLegSexo_Sels, AV49TFMigrLegDomici, AV50TFMigrLegDomici_Sels, AV55TFMigrLegCodPos, AV56TFMigrLegCodPos_Sels, AV58TFMigrLegTelefono, AV59TFMigrLegTelefono_Sels, AV52TFMigrLegEmail, AV53TFMigrLegEmail_Sels, AV40TFMigrLegEstadoCivil, AV41TFMigrLegEstadoCivil_Sels, AV69TFMigrLegArea, AV70TFMigrLegArea_Sels, AV77TFMigrLegBasico, AV78TFMigrLegBasico_To, AV120TFMigrLegConvenio, AV121TFMigrLegConvenio_Sels, AV137TFMigrLegObraSocial, AV138TFMigrLegObraSocial_Sels, AV114TFMigrLegCBU, AV115TFMigrLegCBU_Sels, AV134TFMigrLegModalidad, AV135TFMigrLegModalidad_Sels, AV270TFMigrLegHorSem, AV271TFMigrLegHorSem_To, AV140TFMigrLegObs, AV141TFMigrLegObs_Sels, AV92TFMigrLegSindicato, AV93TFMigrLegSindicato_Sels, AV15OrderedBy, AV16OrderedDsc, AV104CliCod, AV100IsAuthorized_Update, AV102IsAuthorized_Delete, AV208i, AV209CliCodCol, AV212CliCodToFind, AV213EmpCodCol, AV216EmpCodToFind, AV217MigrLegNumeroCol, AV220MigrLegNumeroToFind, AV105EmpCod, AV251WelcomeMessage_NoMostrarMas, AV221SelectAll) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV289Pgmname = "importacion_legajoWW" ;
      Gx_err = (short)(0) ;
      edtavIconoupdatewithtags_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavIconoupdatewithtags_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdatewithtags_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavIconoupdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavIconoupdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdate_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavEliminar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminar_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavMigrlegcategoria_var_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMigrlegcategoria_var_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMigrlegcategoria_var_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavDetailwebcomponent_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDetailwebcomponent_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDetailwebcomponent_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_97_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup280( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e27282 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV267ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV94DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV22ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vEXTRAPARMS"), AV8ExtraParms);
         /* Read saved values. */
         nRC_GXsfl_97 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_97"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV96GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV97GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV98GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV33DDO_MigrLegFecNacAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_MIGRLEGFECNACAUXDATE"), 0) ;
         AV34DDO_MigrLegFecNacAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_MIGRLEGFECNACAUXDATETO"), 0) ;
         AV62DDO_MigrLegFecIngresoAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_MIGRLEGFECINGRESOAUXDATE"), 0) ;
         AV63DDO_MigrLegFecIngresoAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_MIGRLEGFECINGRESOAUXDATETO"), 0) ;
         AV249MenuOpcCod = httpContext.cgiGet( "vMENUOPCCOD") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Ddo_managefilters_Icontype = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icontype") ;
         Ddo_managefilters_Icon = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icon") ;
         Ddo_managefilters_Tooltip = httpContext.cgiGet( "DDO_MANAGEFILTERS_Tooltip") ;
         Ddo_managefilters_Cls = httpContext.cgiGet( "DDO_MANAGEFILTERS_Cls") ;
         Ddo_gridcolumnsselector_Icontype = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Icontype") ;
         Ddo_gridcolumnsselector_Icon = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Icon") ;
         Ddo_gridcolumnsselector_Caption = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Caption") ;
         Ddo_gridcolumnsselector_Tooltip = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Tooltip") ;
         Ddo_gridcolumnsselector_Cls = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Cls") ;
         Ddo_gridcolumnsselector_Dropdownoptionstype = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype") ;
         Ddo_gridcolumnsselector_Gridinternalname = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Gridinternalname") ;
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
         Innewwindow1_Target = httpContext.cgiGet( "INNEWWINDOW1_Target") ;
         Popover_iconoupdate_Gridinternalname = httpContext.cgiGet( "POPOVER_ICONOUPDATE_Gridinternalname") ;
         Popover_iconoupdate_Iteminternalname = httpContext.cgiGet( "POPOVER_ICONOUPDATE_Iteminternalname") ;
         Popover_iconoupdate_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "POPOVER_ICONOUPDATE_Isgriditem")) ;
         Popover_iconoupdate_Popoverwidth = (int)(localUtil.ctol( httpContext.cgiGet( "POPOVER_ICONOUPDATE_Popoverwidth"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Popover_iconoupdate_Visible = GXutil.strtobool( httpContext.cgiGet( "POPOVER_ICONOUPDATE_Visible")) ;
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
         Ddo_grid_Datalistproc = httpContext.cgiGet( "DDO_GRID_Datalistproc") ;
         Ddo_grid_Fixedfilters = httpContext.cgiGet( "DDO_GRID_Fixedfilters") ;
         Ddo_grid_Format = httpContext.cgiGet( "DDO_GRID_Format") ;
         Ddo_grid_Selectedfixedfilter = httpContext.cgiGet( "DDO_GRID_Selectedfixedfilter") ;
         Dvelop_confirmpanel_btnimportarlegajosalsistema_Title = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Title") ;
         Dvelop_confirmpanel_btnimportarlegajosalsistema_Confirmationtext = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Confirmationtext") ;
         Dvelop_confirmpanel_btnimportarlegajosalsistema_Yesbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Yesbuttoncaption") ;
         Dvelop_confirmpanel_btnimportarlegajosalsistema_Nobuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Nobuttoncaption") ;
         Dvelop_confirmpanel_btnimportarlegajosalsistema_Cancelbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_btnimportarlegajosalsistema_Yesbuttonposition = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Yesbuttonposition") ;
         Dvelop_confirmpanel_btnimportarlegajosalsistema_Confirmtype = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Confirmtype") ;
         Dvelop_confirmpanel_btneliminartodos_Title = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Title") ;
         Dvelop_confirmpanel_btneliminartodos_Confirmationtext = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Confirmationtext") ;
         Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Yesbuttoncaption") ;
         Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Nobuttoncaption") ;
         Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Yesbuttonposition") ;
         Dvelop_confirmpanel_btneliminartodos_Confirmtype = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Confirmtype") ;
         Dvelop_confirmpanel_eliminar_Title = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Title") ;
         Dvelop_confirmpanel_eliminar_Confirmationtext = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Confirmationtext") ;
         Dvelop_confirmpanel_eliminar_Yesbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Nobuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Nobuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Cancelbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Yesbuttonposition = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttonposition") ;
         Dvelop_confirmpanel_eliminar_Confirmtype = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Confirmtype") ;
         Importexcel_modal_Width = httpContext.cgiGet( "IMPORTEXCEL_MODAL_Width") ;
         Importexcel_modal_Title = httpContext.cgiGet( "IMPORTEXCEL_MODAL_Title") ;
         Importexcel_modal_Confirmtype = httpContext.cgiGet( "IMPORTEXCEL_MODAL_Confirmtype") ;
         Importexcel_modal_Bodytype = httpContext.cgiGet( "IMPORTEXCEL_MODAL_Bodytype") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         Grid_empowerer_Hascolumnsselector = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hascolumnsselector")) ;
         Grid_empowerer_Popoversingrid = httpContext.cgiGet( "GRID_EMPOWERER_Popoversingrid") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Selectedcolumnfixedfilter = httpContext.cgiGet( "DDO_GRID_Selectedcolumnfixedfilter") ;
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( "DDO_GRID_Filteredtextto_get") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( "DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( "DDO_GRID_Selectedcolumn") ;
         Ddo_gridcolumnsselector_Columnsselectorvalues = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( "DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         edtavDisplay_Link = httpContext.cgiGet( "vDISPLAY_Link") ;
         edtavUpdate_Link = httpContext.cgiGet( "vUPDATE_Link") ;
         edtavDelete_Link = httpContext.cgiGet( "vDELETE_Link") ;
         Dvelop_confirmpanel_btnimportarlegajosalsistema_Result = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA_Result") ;
         Dvelop_confirmpanel_btneliminartodos_Result = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Result") ;
         Dvelop_confirmpanel_eliminar_Result = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINAR_Result") ;
         Importexcel_modal_Result = httpContext.cgiGet( "IMPORTEXCEL_MODAL_Result") ;
         /* Read variables values. */
         AV257WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV251WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV251WelcomeMessage_NoMostrarMas", AV251WelcomeMessage_NoMostrarMas);
         AV221SelectAll = GXutil.strtobool( httpContext.cgiGet( chkavSelectall.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV221SelectAll", AV221SelectAll);
         AV35DDO_MigrLegFecNacAuxDateText = httpContext.cgiGet( edtavDdo_migrlegfecnacauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35DDO_MigrLegFecNacAuxDateText", AV35DDO_MigrLegFecNacAuxDateText);
         AV64DDO_MigrLegFecIngresoAuxDateText = httpContext.cgiGet( edtavDdo_migrlegfecingresoauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64DDO_MigrLegFecIngresoAuxDateText", AV64DDO_MigrLegFecIngresoAuxDateText);
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
      e27282 ();
      if (returnInSub) return;
   }

   public void e27282( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV249MenuOpcCod, "", "") ;
      GXt_int1 = AV104CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      importacion_legajoww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV104CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV104CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV104CliCod), 6, 0));
      divCell_grid_dwc_Class = "Invisible WCD_"+GXutil.upper( subGrid_Internalname) ;
      httpContext.ajax_rsp_assign_prop("", false, divCell_grid_dwc_Internalname, "Class", divCell_grid_dwc_Class, true);
      this.executeUsercontrolMethod("", false, "TFMIGRLEGFECINGRESO_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_migrlegfecingresoauxdatetext_Internalname});
      this.executeUsercontrolMethod("", false, "TFMIGRLEGFECNAC_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_migrlegfecnacauxdatetext_Internalname});
      Popover_iconoupdate_Gridinternalname = subGrid_Internalname ;
      ucPopover_iconoupdate.sendProperty(context, "", false, Popover_iconoupdate_Internalname, "GridInternalName", Popover_iconoupdate_Gridinternalname);
      Popover_iconoupdate_Iteminternalname = edtavIconoupdatewithtags_Internalname ;
      ucPopover_iconoupdate.sendProperty(context, "", false, Popover_iconoupdate_Internalname, "ItemInternalName", Popover_iconoupdate_Iteminternalname);
      chkavSelectall.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavSelectall.getInternalname(), "Visible", GXutil.ltrimstr( chkavSelectall.getVisible(), 5, 0), true);
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      if ( GXutil.strcmp(AV10HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( " Importación de Legajos", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV15OrderedBy < 1 )
      {
         AV15OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      chkavSelected.setTitleFormat( (short)(1) );
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV94DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV94DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV252MenuBienveImgURL ;
      GXv_char6[0] = AV254MenuBienveTitulo ;
      GXv_char7[0] = AV255MenuBienveTexto ;
      GXv_boolean8[0] = AV256MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV249MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      importacion_legajoww_impl.this.AV252MenuBienveImgURL = GXv_char5[0] ;
      importacion_legajoww_impl.this.AV254MenuBienveTitulo = GXv_char6[0] ;
      importacion_legajoww_impl.this.AV255MenuBienveTexto = GXv_char7[0] ;
      importacion_legajoww_impl.this.AV256MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV256MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV256MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV254MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV255MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV257WelcomeMessage_Foto = AV252MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV257WelcomeMessage_Foto)==0) ? AV288Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV257WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV257WelcomeMessage_Foto), true);
         AV288Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV252MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV257WelcomeMessage_Foto)==0) ? AV288Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV257WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV257WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      importacion_legajoww_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV277observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV277observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      new web.msgdebug_prod(remoteHandle, context).execute( AV289Pgmname, httpContext.getMessage( "script", "")) ;
      Form.getJscriptsrc().add(httpContext.getMessage( "/static/A3LBotonProcesa.js", "")) ;
      AV266modoTest = GXutil.boolval( new web.getparametro(remoteHandle, context).executeUdp( AV104CliCod, new web.modotest_codigoparam(remoteHandle, context).executeUdp( ))) ;
      bttBtnimportartodos_Visible = (AV266modoTest ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnimportartodos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnimportartodos_Visible), 5, 0), true);
   }

   public void e28282( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int11 = AV105EmpCod ;
      GXv_int12[0] = GXt_int11 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int12) ;
      importacion_legajoww_impl.this.GXt_int11 = GXv_int12[0] ;
      AV105EmpCod = GXt_int11 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV105EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV105EmpCod), 4, 0));
      GXt_int1 = AV104CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      importacion_legajoww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV104CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV104CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV104CliCod), 6, 0));
      GXv_SdtWWPContext13[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext13) ;
      AV6WWPContext = GXv_SdtWWPContext13[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV269ManageFiltersExecutionStep == 1 )
      {
         AV269ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV269ManageFiltersExecutionStep", GXutil.str( AV269ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV269ManageFiltersExecutionStep == 2 )
      {
         AV269ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV269ManageFiltersExecutionStep", GXutil.str( AV269ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV24Session.getValue("importacion_legajoWWColumnsSelector"), "") != 0 )
      {
         AV20ColumnsSelectorXML = AV24Session.getValue("importacion_legajoWWColumnsSelector") ;
         AV22ColumnsSelector.fromxml(AV20ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtavIconoupdatewithtags_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavIconoupdatewithtags_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdatewithtags_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegId_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegId_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegCUIL_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCUIL_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCUIL_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegApellido_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegApellido_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegApellido_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegNombre_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNombre_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegModTra_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegModTra_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegModTra_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegTipoTarifa_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegTipoTarifa_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegTipoTarifa_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegClase_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegClase_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegClase_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegFecNac_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFecNac_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFecNac_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegFecIngreso_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFecIngreso_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFecIngreso_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegSexo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSexo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSexo_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegDomici_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegDomici_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegDomici_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegCodPos_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCodPos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCodPos_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegTelefono_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegTelefono_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegTelefono_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegEmail_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegEmail_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegEmail_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegEstadoCivil_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegEstadoCivil_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegEstadoCivil_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegArea_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegArea_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegArea_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegBasico_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBasico_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBasico_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegConvenio_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegConvenio_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtavMigrlegcategoria_var_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMigrlegcategoria_var_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMigrlegcategoria_var_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegObraSocial_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+21)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegObraSocial_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegObraSocial_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegCBU_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+22)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCBU_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCBU_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegModalidad_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+23)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegModalidad_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegModalidad_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegHorSem_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+24)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegHorSem_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegHorSem_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegObs_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+25)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegObs_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegObs_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtMigrLegSindicato_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+26)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSindicato_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSindicato_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+27)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+28)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_97_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+29)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_97_Refreshing);
      chkavSelected.setTitle( GXutil.format( "<input name=\"selectAllCheckbox\" type=\"checkbox\" value=\"Select All\" onchange=\"$(%1).click();\" class=\"AttributeCheckBox\" >", "'#"+chkavSelectall.getInternalname()+"'", "", "", "", "", "", "", "", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavSelected.getInternalname(), "Title", chkavSelected.getTitle(), !bGXsfl_97_Refreshing);
      AV221SelectAll = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV221SelectAll", AV221SelectAll);
      AV96GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV96GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV96GridCurrentPage), 10, 0));
      AV97GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV97GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV97GridPageCount), 10, 0));
      GXt_char10 = AV98GridAppliedFilters ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV289Pgmname, GXv_char7) ;
      importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV98GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV98GridAppliedFilters", AV98GridAppliedFilters);
      AV209CliCodCol.fromJSonString(AV210CliCodJson, null);
      AV213EmpCodCol.fromJSonString(AV214EmpCodJson, null);
      AV217MigrLegNumeroCol.fromJSonString(AV218MigrLegNumeroJson, null);
      GXt_char10 = AV276MenuOpcTitulo ;
      GXv_char7[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV249MenuOpcCod, GXv_char7) ;
      importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV276MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV276MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV276MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int12[0] = (short)(AV278filterCount) ;
      GXv_char7[0] = AV279filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV13GridState, GXv_int12, GXv_char7) ;
      importacion_legajoww_impl.this.AV278filterCount = GXv_int12[0] ;
      importacion_legajoww_impl.this.AV279filtrosTexto = GXv_char7[0] ;
      if ( AV278filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV278filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV279filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      GXt_boolean14 = AV243hay ;
      GXv_boolean8[0] = GXt_boolean14 ;
      new web.haymigrleg(remoteHandle, context).execute( GXv_boolean8) ;
      importacion_legajoww_impl.this.GXt_boolean14 = GXv_boolean8[0] ;
      AV243hay = GXt_boolean14 ;
      bttBtneliminartodos_Visible = (AV243hay ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtneliminartodos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtneliminartodos_Visible), 5, 0), true);
      AV290Importacion_legajowwds_1_tficonoupdate = AV239TFiconoUpdate ;
      AV291Importacion_legajowwds_2_tficonoupdateoperator = AV240TFiconoUpdateOperator ;
      AV292Importacion_legajowwds_3_tfmigrlegid = AV108TFMigrLegId ;
      AV293Importacion_legajowwds_4_tfmigrlegid_sels = AV109TFMigrLegId_Sels ;
      AV294Importacion_legajowwds_5_tfmigrlegcuil = AV43TFMigrLegCUIL ;
      AV295Importacion_legajowwds_6_tfmigrlegcuil_sels = AV44TFMigrLegCUIL_Sels ;
      AV296Importacion_legajowwds_7_tfmigrlegapellido = AV26TFMigrLegApellido ;
      AV297Importacion_legajowwds_8_tfmigrlegapellido_sels = AV27TFMigrLegApellido_Sels ;
      AV298Importacion_legajowwds_9_tfmigrlegnombre = AV29TFMigrLegNombre ;
      AV299Importacion_legajowwds_10_tfmigrlegnombre_sels = AV30TFMigrLegNombre_Sels ;
      AV300Importacion_legajowwds_11_tfmigrlegmodtra = AV281TFMigrLegModTra ;
      AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels = AV282TFMigrLegModTra_Sels ;
      AV302Importacion_legajowwds_13_tfmigrlegtipotarifa = AV284TFMigrLegTipoTarifa ;
      AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels = AV285TFMigrLegTipoTarifa_Sels ;
      AV304Importacion_legajowwds_15_tfmigrlegclase = AV75TFMigrLegClase ;
      AV305Importacion_legajowwds_16_tfmigrlegclase_sels = AV76TFMigrLegClase_Sels ;
      AV306Importacion_legajowwds_17_tfmigrlegfecnac = AV31TFMigrLegFecNac ;
      AV307Importacion_legajowwds_18_tfmigrlegfecnac_to = AV32TFMigrLegFecNac_To ;
      AV308Importacion_legajowwds_19_tfmigrlegfecingreso = AV60TFMigrLegFecIngreso ;
      AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to = AV61TFMigrLegFecIngreso_To ;
      AV310Importacion_legajowwds_21_tfmigrlegsexo = AV37TFMigrLegSexo ;
      AV311Importacion_legajowwds_22_tfmigrlegsexo_sels = AV38TFMigrLegSexo_Sels ;
      AV312Importacion_legajowwds_23_tfmigrlegdomici = AV49TFMigrLegDomici ;
      AV313Importacion_legajowwds_24_tfmigrlegdomici_sels = AV50TFMigrLegDomici_Sels ;
      AV314Importacion_legajowwds_25_tfmigrlegcodpos = AV55TFMigrLegCodPos ;
      AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels = AV56TFMigrLegCodPos_Sels ;
      AV316Importacion_legajowwds_27_tfmigrlegtelefono = AV58TFMigrLegTelefono ;
      AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels = AV59TFMigrLegTelefono_Sels ;
      AV318Importacion_legajowwds_29_tfmigrlegemail = AV52TFMigrLegEmail ;
      AV319Importacion_legajowwds_30_tfmigrlegemail_sels = AV53TFMigrLegEmail_Sels ;
      AV320Importacion_legajowwds_31_tfmigrlegestadocivil = AV40TFMigrLegEstadoCivil ;
      AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels = AV41TFMigrLegEstadoCivil_Sels ;
      AV322Importacion_legajowwds_33_tfmigrlegarea = AV69TFMigrLegArea ;
      AV323Importacion_legajowwds_34_tfmigrlegarea_sels = AV70TFMigrLegArea_Sels ;
      AV324Importacion_legajowwds_35_tfmigrlegbasico = AV77TFMigrLegBasico ;
      AV325Importacion_legajowwds_36_tfmigrlegbasico_to = AV78TFMigrLegBasico_To ;
      AV326Importacion_legajowwds_37_tfmigrlegconvenio = AV120TFMigrLegConvenio ;
      AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels = AV121TFMigrLegConvenio_Sels ;
      AV328Importacion_legajowwds_39_tfmigrlegobrasocial = AV137TFMigrLegObraSocial ;
      AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels = AV138TFMigrLegObraSocial_Sels ;
      AV330Importacion_legajowwds_41_tfmigrlegcbu = AV114TFMigrLegCBU ;
      AV331Importacion_legajowwds_42_tfmigrlegcbu_sels = AV115TFMigrLegCBU_Sels ;
      AV332Importacion_legajowwds_43_tfmigrlegmodalidad = AV134TFMigrLegModalidad ;
      AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels = AV135TFMigrLegModalidad_Sels ;
      AV334Importacion_legajowwds_45_tfmigrleghorsem = AV270TFMigrLegHorSem ;
      AV335Importacion_legajowwds_46_tfmigrleghorsem_to = AV271TFMigrLegHorSem_To ;
      AV336Importacion_legajowwds_47_tfmigrlegobs = AV140TFMigrLegObs ;
      AV337Importacion_legajowwds_48_tfmigrlegobs_sels = AV141TFMigrLegObs_Sels ;
      AV338Importacion_legajowwds_49_tfmigrlegsindicato = AV92TFMigrLegSindicato ;
      AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels = AV93TFMigrLegSindicato_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV209CliCodCol", AV209CliCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV213EmpCodCol", AV213EmpCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV217MigrLegNumeroCol", AV217MigrLegNumeroCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV267ManageFiltersData", AV267ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GridState", AV13GridState);
   }

   public void e13282( )
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
         AV95PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV95PageToGo) ;
      }
   }

   public void e14282( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15282( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV15OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15OrderedBy), 4, 0));
         AV16OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16OrderedDsc", AV16OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "iconoUpdate") == 0 )
         {
            if ( GXutil.strcmp(Ddo_grid_Selectedcolumnfixedfilter, "1") == 0 )
            {
               AV240TFiconoUpdateOperator = (short)(1) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV240TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV240TFiconoUpdateOperator), 4, 0));
               AV239TFiconoUpdate = "" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV239TFiconoUpdate", AV239TFiconoUpdate);
            }
            else if ( GXutil.strcmp(Ddo_grid_Selectedcolumnfixedfilter, "2") == 0 )
            {
               AV240TFiconoUpdateOperator = (short)(2) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV240TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV240TFiconoUpdateOperator), 4, 0));
               AV239TFiconoUpdate = "" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV239TFiconoUpdate", AV239TFiconoUpdate);
            }
            else if ( GXutil.strcmp(Ddo_grid_Selectedcolumnfixedfilter, "3") == 0 )
            {
               AV240TFiconoUpdateOperator = (short)(3) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV240TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV240TFiconoUpdateOperator), 4, 0));
               AV239TFiconoUpdate = "" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV239TFiconoUpdate", AV239TFiconoUpdate);
            }
            else
            {
               AV240TFiconoUpdateOperator = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV240TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV240TFiconoUpdateOperator), 4, 0));
            }
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegId") == 0 )
         {
            AV108TFMigrLegId = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV108TFMigrLegId", AV108TFMigrLegId);
            AV107TFMigrLegId_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV107TFMigrLegId_SelsJson", AV107TFMigrLegId_SelsJson);
            AV109TFMigrLegId_Sels.fromJSonString(AV107TFMigrLegId_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegCUIL") == 0 )
         {
            AV43TFMigrLegCUIL = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFMigrLegCUIL", AV43TFMigrLegCUIL);
            AV42TFMigrLegCUIL_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFMigrLegCUIL_SelsJson", AV42TFMigrLegCUIL_SelsJson);
            AV44TFMigrLegCUIL_Sels.fromJSonString(AV42TFMigrLegCUIL_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegApellido") == 0 )
         {
            AV26TFMigrLegApellido = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFMigrLegApellido", AV26TFMigrLegApellido);
            AV25TFMigrLegApellido_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFMigrLegApellido_SelsJson", AV25TFMigrLegApellido_SelsJson);
            AV27TFMigrLegApellido_Sels.fromJSonString(AV25TFMigrLegApellido_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegNombre") == 0 )
         {
            AV29TFMigrLegNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFMigrLegNombre", AV29TFMigrLegNombre);
            AV28TFMigrLegNombre_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFMigrLegNombre_SelsJson", AV28TFMigrLegNombre_SelsJson);
            AV30TFMigrLegNombre_Sels.fromJSonString(AV28TFMigrLegNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegModTra") == 0 )
         {
            AV281TFMigrLegModTra = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV281TFMigrLegModTra", AV281TFMigrLegModTra);
            AV280TFMigrLegModTra_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV280TFMigrLegModTra_SelsJson", AV280TFMigrLegModTra_SelsJson);
            AV282TFMigrLegModTra_Sels.fromJSonString(AV280TFMigrLegModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegTipoTarifa") == 0 )
         {
            AV284TFMigrLegTipoTarifa = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV284TFMigrLegTipoTarifa", AV284TFMigrLegTipoTarifa);
            AV283TFMigrLegTipoTarifa_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV283TFMigrLegTipoTarifa_SelsJson", AV283TFMigrLegTipoTarifa_SelsJson);
            AV285TFMigrLegTipoTarifa_Sels.fromJSonString(AV283TFMigrLegTipoTarifa_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegClase") == 0 )
         {
            AV75TFMigrLegClase = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFMigrLegClase", AV75TFMigrLegClase);
            AV74TFMigrLegClase_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFMigrLegClase_SelsJson", AV74TFMigrLegClase_SelsJson);
            AV76TFMigrLegClase_Sels.fromJSonString(AV74TFMigrLegClase_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegFecNac") == 0 )
         {
            AV31TFMigrLegFecNac = localUtil.ctod( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFMigrLegFecNac", localUtil.format(AV31TFMigrLegFecNac, "99/99/9999"));
            AV32TFMigrLegFecNac_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFMigrLegFecNac_To", localUtil.format(AV32TFMigrLegFecNac_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegFecIngreso") == 0 )
         {
            AV60TFMigrLegFecIngreso = localUtil.ctod( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFMigrLegFecIngreso", localUtil.format(AV60TFMigrLegFecIngreso, "99/99/9999"));
            AV61TFMigrLegFecIngreso_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFMigrLegFecIngreso_To", localUtil.format(AV61TFMigrLegFecIngreso_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegSexo") == 0 )
         {
            AV37TFMigrLegSexo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFMigrLegSexo", AV37TFMigrLegSexo);
            AV36TFMigrLegSexo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFMigrLegSexo_SelsJson", AV36TFMigrLegSexo_SelsJson);
            AV38TFMigrLegSexo_Sels.fromJSonString(AV36TFMigrLegSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegDomici") == 0 )
         {
            AV49TFMigrLegDomici = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFMigrLegDomici", AV49TFMigrLegDomici);
            AV48TFMigrLegDomici_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFMigrLegDomici_SelsJson", AV48TFMigrLegDomici_SelsJson);
            AV50TFMigrLegDomici_Sels.fromJSonString(AV48TFMigrLegDomici_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegCodPos") == 0 )
         {
            AV55TFMigrLegCodPos = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFMigrLegCodPos", AV55TFMigrLegCodPos);
            AV54TFMigrLegCodPos_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFMigrLegCodPos_SelsJson", AV54TFMigrLegCodPos_SelsJson);
            AV56TFMigrLegCodPos_Sels.fromJSonString(AV54TFMigrLegCodPos_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegTelefono") == 0 )
         {
            AV58TFMigrLegTelefono = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFMigrLegTelefono", AV58TFMigrLegTelefono);
            AV57TFMigrLegTelefono_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFMigrLegTelefono_SelsJson", AV57TFMigrLegTelefono_SelsJson);
            AV59TFMigrLegTelefono_Sels.fromJSonString(AV57TFMigrLegTelefono_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegEmail") == 0 )
         {
            AV52TFMigrLegEmail = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFMigrLegEmail", AV52TFMigrLegEmail);
            AV51TFMigrLegEmail_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFMigrLegEmail_SelsJson", AV51TFMigrLegEmail_SelsJson);
            AV53TFMigrLegEmail_Sels.fromJSonString(AV51TFMigrLegEmail_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegEstadoCivil") == 0 )
         {
            AV40TFMigrLegEstadoCivil = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFMigrLegEstadoCivil", AV40TFMigrLegEstadoCivil);
            AV39TFMigrLegEstadoCivil_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFMigrLegEstadoCivil_SelsJson", AV39TFMigrLegEstadoCivil_SelsJson);
            AV41TFMigrLegEstadoCivil_Sels.fromJSonString(AV39TFMigrLegEstadoCivil_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegArea") == 0 )
         {
            AV69TFMigrLegArea = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFMigrLegArea", AV69TFMigrLegArea);
            AV68TFMigrLegArea_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFMigrLegArea_SelsJson", AV68TFMigrLegArea_SelsJson);
            AV70TFMigrLegArea_Sels.fromJSonString(AV68TFMigrLegArea_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegBasico") == 0 )
         {
            AV77TFMigrLegBasico = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFMigrLegBasico", GXutil.ltrimstr( AV77TFMigrLegBasico, 14, 2));
            AV78TFMigrLegBasico_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFMigrLegBasico_To", GXutil.ltrimstr( AV78TFMigrLegBasico_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegConvenio") == 0 )
         {
            AV120TFMigrLegConvenio = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV120TFMigrLegConvenio", AV120TFMigrLegConvenio);
            AV119TFMigrLegConvenio_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV119TFMigrLegConvenio_SelsJson", AV119TFMigrLegConvenio_SelsJson);
            AV121TFMigrLegConvenio_Sels.fromJSonString(AV119TFMigrLegConvenio_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegObraSocial") == 0 )
         {
            AV137TFMigrLegObraSocial = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV137TFMigrLegObraSocial", AV137TFMigrLegObraSocial);
            AV136TFMigrLegObraSocial_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV136TFMigrLegObraSocial_SelsJson", AV136TFMigrLegObraSocial_SelsJson);
            AV138TFMigrLegObraSocial_Sels.fromJSonString(AV136TFMigrLegObraSocial_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegCBU") == 0 )
         {
            AV114TFMigrLegCBU = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV114TFMigrLegCBU", AV114TFMigrLegCBU);
            AV113TFMigrLegCBU_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV113TFMigrLegCBU_SelsJson", AV113TFMigrLegCBU_SelsJson);
            AV115TFMigrLegCBU_Sels.fromJSonString(AV113TFMigrLegCBU_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegModalidad") == 0 )
         {
            AV134TFMigrLegModalidad = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV134TFMigrLegModalidad", AV134TFMigrLegModalidad);
            AV133TFMigrLegModalidad_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV133TFMigrLegModalidad_SelsJson", AV133TFMigrLegModalidad_SelsJson);
            AV135TFMigrLegModalidad_Sels.fromJSonString(AV133TFMigrLegModalidad_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegHorSem") == 0 )
         {
            AV270TFMigrLegHorSem = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV270TFMigrLegHorSem", GXutil.ltrimstr( AV270TFMigrLegHorSem, 4, 1));
            AV271TFMigrLegHorSem_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV271TFMigrLegHorSem_To", GXutil.ltrimstr( AV271TFMigrLegHorSem_To, 4, 1));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegObs") == 0 )
         {
            AV140TFMigrLegObs = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV140TFMigrLegObs", AV140TFMigrLegObs);
            AV139TFMigrLegObs_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV139TFMigrLegObs_SelsJson", AV139TFMigrLegObs_SelsJson);
            AV141TFMigrLegObs_Sels.fromJSonString(AV139TFMigrLegObs_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegSindicato") == 0 )
         {
            AV92TFMigrLegSindicato = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV92TFMigrLegSindicato", AV92TFMigrLegSindicato);
            AV91TFMigrLegSindicato_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91TFMigrLegSindicato_SelsJson", AV91TFMigrLegSindicato_SelsJson);
            AV93TFMigrLegSindicato_Sels.fromJSonString(AV91TFMigrLegSindicato_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV93TFMigrLegSindicato_Sels", AV93TFMigrLegSindicato_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV141TFMigrLegObs_Sels", AV141TFMigrLegObs_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV135TFMigrLegModalidad_Sels", AV135TFMigrLegModalidad_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV115TFMigrLegCBU_Sels", AV115TFMigrLegCBU_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV138TFMigrLegObraSocial_Sels", AV138TFMigrLegObraSocial_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV121TFMigrLegConvenio_Sels", AV121TFMigrLegConvenio_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV70TFMigrLegArea_Sels", AV70TFMigrLegArea_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41TFMigrLegEstadoCivil_Sels", AV41TFMigrLegEstadoCivil_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53TFMigrLegEmail_Sels", AV53TFMigrLegEmail_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV59TFMigrLegTelefono_Sels", AV59TFMigrLegTelefono_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV56TFMigrLegCodPos_Sels", AV56TFMigrLegCodPos_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFMigrLegDomici_Sels", AV50TFMigrLegDomici_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV38TFMigrLegSexo_Sels", AV38TFMigrLegSexo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76TFMigrLegClase_Sels", AV76TFMigrLegClase_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV285TFMigrLegTipoTarifa_Sels", AV285TFMigrLegTipoTarifa_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV282TFMigrLegModTra_Sels", AV282TFMigrLegModTra_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFMigrLegNombre_Sels", AV30TFMigrLegNombre_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27TFMigrLegApellido_Sels", AV27TFMigrLegApellido_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV44TFMigrLegCUIL_Sels", AV44TFMigrLegCUIL_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV109TFMigrLegId_Sels", AV109TFMigrLegId_Sels);
   }

   private void e29282( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      edtavIconoupdatewithtags_Link = formatLink("web.migrlegupd", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A87MigrLegNumero,8,0))}, new String[] {"Mode","CliCod","EmpCod","MigrLegNumero"})  ;
      new web.msgdebug7(remoteHandle, context).execute( AV289Pgmname, "") ;
      if ( ! (GXutil.strcmp("", A629MigrLegErrores)==0) )
      {
         chkavSelected.setEnabled( 0 );
      }
      else
      {
         chkavSelected.setEnabled( 1 );
      }
      if ( ! (GXutil.strcmp("", A629MigrLegErrores)==0) || ! (GXutil.strcmp("", A633MigrLegWarnings)==0) )
      {
         Popover_iconoupdate_Visible = true ;
         ucPopover_iconoupdate.sendProperty(context, "", false, Popover_iconoupdate_Internalname, "Visible", GXutil.booltostr( Popover_iconoupdate_Visible));
      }
      else
      {
         Popover_iconoupdate_Visible = false ;
         ucPopover_iconoupdate.sendProperty(context, "", false, Popover_iconoupdate_Internalname, "Visible", GXutil.booltostr( Popover_iconoupdate_Visible));
      }
      AV233Eliminar = "<i class=\"fas fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminar_Internalname, AV233Eliminar);
      AV248Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV248Display);
      edtavDisplay_Link = formatLink("web.importacion_legajoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A87MigrLegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","EmpCod","MigrLegNumero","TabCode"})  ;
      AV99Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV99Update);
      if ( AV100IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.importacion_legajo", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A87MigrLegNumero,8,0))}, new String[] {"Mode","CliCod","EmpCod","MigrLegNumero"})  ;
      }
      AV101Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV101Delete);
      if ( AV102IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("web.importacion_legajo", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A87MigrLegNumero,8,0))}, new String[] {"Mode","CliCod","EmpCod","MigrLegNumero"})  ;
      }
      AV262DetailWebComponent = "<i class=\"fas fa-angle-right ArrowIcon\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDetailwebcomponent_Internalname, AV262DetailWebComponent);
      AV205Selected = false ;
      httpContext.ajax_rsp_assign_attri("", false, chkavSelected.getInternalname(), AV205Selected);
      AV237iconoUpdate = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavIconoupdate_Internalname, AV237iconoUpdate);
      if ( (GXutil.strcmp("", A604MigrLegCategoria)==0) )
      {
         AV241MigrLegCategoria = httpContext.getMessage( "Ninguna (Fuera de Convenio)", "") ;
      }
      else
      {
         AV241MigrLegCategoria = A604MigrLegCategoria ;
      }
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV245VerSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV245VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV245VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char10 = AV246ModificarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char7) ;
      importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV246ModificarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV246ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char10 = AV247EliminarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char7) ;
      importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV247EliminarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV247EliminarSVG);
      edtavEliminarsvg_Link = edtavDelete_Link ;
      edtavDelete_Visible = 0 ;
      AV238iconoUpdateWithTags = AV237iconoUpdate ;
      httpContext.ajax_rsp_assign_attri("", false, edtavIconoupdatewithtags_Internalname, AV238iconoUpdateWithTags);
      if ( (GXutil.strcmp("", A629MigrLegErrores)==0) && ! (GXutil.strcmp("", A633MigrLegWarnings)==0) )
      {
         AV238iconoUpdateWithTags += GXutil.format( "<i class='fa fa-circle FontColorIconWarning FontColorIconSmall TagAfterText BootstrapTooltipTop' title='%1'></i>", httpContext.getMessage( "Con Warnings", ""), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_attri("", false, edtavIconoupdatewithtags_Internalname, AV238iconoUpdateWithTags);
      }
      if ( ! (GXutil.strcmp("", A629MigrLegErrores)==0) )
      {
         AV238iconoUpdateWithTags += GXutil.format( "<i class='fa fa-circle FontColorIconDanger FontColorIconSmall TagAfterText BootstrapTooltipTop' title='%1'></i>", httpContext.getMessage( "Con Errores", ""), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_attri("", false, edtavIconoupdatewithtags_Internalname, AV238iconoUpdateWithTags);
      }
      if ( (GXutil.strcmp("", A629MigrLegErrores)==0) && (GXutil.strcmp("", A633MigrLegWarnings)==0) )
      {
         AV238iconoUpdateWithTags += GXutil.format( "<i class='fa fa-circle FontColorIconSuccess FontColorIconSmall TagAfterText BootstrapTooltipTop' title='%1'></i>", httpContext.getMessage( "Validado OK", ""), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_attri("", false, edtavIconoupdatewithtags_Internalname, AV238iconoUpdateWithTags);
      }
      AV238iconoUpdateWithTags += "<i class='WWPPopoverIcon TagAfterText fa fa-caret-down'></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavIconoupdatewithtags_Internalname, AV238iconoUpdateWithTags);
      AV212CliCodToFind = A3CliCod ;
      httpContext.ajax_rsp_assign_attri("", false, "AV212CliCodToFind", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV212CliCodToFind), 6, 0));
      AV216EmpCodToFind = A1EmpCod ;
      httpContext.ajax_rsp_assign_attri("", false, "AV216EmpCodToFind", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV216EmpCodToFind), 4, 0));
      AV220MigrLegNumeroToFind = A87MigrLegNumero ;
      httpContext.ajax_rsp_assign_attri("", false, "AV220MigrLegNumeroToFind", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV220MigrLegNumeroToFind), 8, 0));
      /* Execute user subroutine: 'GETINDEXOFSELECTEDROW' */
      S182 ();
      if (returnInSub) return;
      if ( AV208i > 0 )
      {
         AV205Selected = true ;
         httpContext.ajax_rsp_assign_attri("", false, chkavSelected.getInternalname(), AV205Selected);
      }
      if ( (GXutil.strcmp("", A629MigrLegErrores)==0) && (GXutil.strcmp("", A633MigrLegWarnings)==0) )
      {
         AV238iconoUpdateWithTags = GXutil.strReplace( AV238iconoUpdateWithTags, "<i class='WWPPopoverIcon TagAfterText fa fa-caret-down'></i>", "") ;
         httpContext.ajax_rsp_assign_attri("", false, edtavIconoupdatewithtags_Internalname, AV238iconoUpdateWithTags);
      }
      AV263sueldosTooltip = "" ;
      if ( ! (GXutil.strcmp("", A2189MigrSueldos)==0) )
      {
         AV264migracion_sueldos.clear();
         AV264migracion_sueldos.fromJSonString(GXutil.trim( A2189MigrSueldos), null);
         AV265m = (short)(1) ;
         while ( AV265m <= AV264migracion_sueldos.size() )
         {
            AV263sueldosTooltip += GXutil.trim( localUtil.cmonth( ((web.Sdtmigracion_sueldos_migracion_sueldosItem)AV264migracion_sueldos.elementAt(-1+AV265m)).getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha(), httpContext.getLanguage( ))) + " " + GXutil.trim( GXutil.str( GXutil.year( ((web.Sdtmigracion_sueldos_migracion_sueldosItem)AV264migracion_sueldos.elementAt(-1+AV265m)).getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha()), 10, 0)) + ": " + GXutil.trim( GXutil.str( ((web.Sdtmigracion_sueldos_migracion_sueldosItem)AV264migracion_sueldos.elementAt(-1+AV265m)).getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo(), 14, 2)) ;
            if ( AV265m != AV264migracion_sueldos.size() )
            {
               AV263sueldosTooltip += ", " ;
            }
            AV265m = (short)(AV265m+1) ;
         }
      }
      edtMigrLegBasico_Tooltiptext = GXutil.trim( AV263sueldosTooltip) ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(97) ;
      }
      sendrow_972( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_97_Refreshing )
      {
         httpContext.doAjaxLoad(97, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e31282( )
   {
      /* Selected_Click Routine */
      returnInSub = false ;
      if ( AV205Selected )
      {
         AV209CliCodCol.add((int)(A3CliCod), 0);
         AV213EmpCodCol.add((short)(A1EmpCod), 0);
         AV217MigrLegNumeroCol.add((int)(A87MigrLegNumero), 0);
      }
      else
      {
         AV212CliCodToFind = A3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "AV212CliCodToFind", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV212CliCodToFind), 6, 0));
         AV216EmpCodToFind = A1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "AV216EmpCodToFind", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV216EmpCodToFind), 4, 0));
         AV220MigrLegNumeroToFind = A87MigrLegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "AV220MigrLegNumeroToFind", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV220MigrLegNumeroToFind), 8, 0));
         /* Execute user subroutine: 'GETINDEXOFSELECTEDROW' */
         S182 ();
         if (returnInSub) return;
         AV209CliCodCol.removeItem((int)(AV208i));
         AV213EmpCodCol.removeItem((int)(AV208i));
         AV217MigrLegNumeroCol.removeItem((int)(AV208i));
      }
      AV210CliCodJson = AV209CliCodCol.toJSonString(false) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV210CliCodJson", AV210CliCodJson);
      AV214EmpCodJson = AV213EmpCodCol.toJSonString(false) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV214EmpCodJson", AV214EmpCodJson);
      AV218MigrLegNumeroJson = AV217MigrLegNumeroCol.toJSonString(false) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV218MigrLegNumeroJson", AV218MigrLegNumeroJson);
      divLayoutmaintable_Class = "Table TableWithSelectableGrid"+((AV209CliCodCol.size()>0) ? " WWPMultiRowSelected" : "") ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV209CliCodCol", AV209CliCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV213EmpCodCol", AV213EmpCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV217MigrLegNumeroCol", AV217MigrLegNumeroCol);
   }

   public void e12282( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV20ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV22ColumnsSelector.fromJSonString(AV20ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "importacion_legajoWWColumnsSelector", ((GXutil.strcmp("", AV20ColumnsSelectorXML)==0) ? "" : AV22ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV209CliCodCol", AV209CliCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV213EmpCodCol", AV213EmpCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV217MigrLegNumeroCol", AV217MigrLegNumeroCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV267ManageFiltersData", AV267ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GridState", AV13GridState);
   }

   public void e11282( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S192 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S162 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("importacion_legajoWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV289Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV269ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV269ManageFiltersExecutionStep", GXutil.str( AV269ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("importacion_legajoWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV269ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV269ManageFiltersExecutionStep", GXutil.str( AV269ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char10 = AV268ManageFiltersXml ;
         GXv_char7[0] = GXt_char10 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "importacion_legajoWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
         AV268ManageFiltersXml = GXt_char10 ;
         if ( (GXutil.strcmp("", AV268ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S192 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV289Pgmname+"GridState", AV268ManageFiltersXml) ;
            AV13GridState.fromxml(AV268ManageFiltersXml, null, null);
            AV15OrderedBy = AV13GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15OrderedBy), 4, 0));
            AV16OrderedDsc = AV13GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16OrderedDsc", AV16OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S202 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GridState", AV13GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV109TFMigrLegId_Sels", AV109TFMigrLegId_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV44TFMigrLegCUIL_Sels", AV44TFMigrLegCUIL_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27TFMigrLegApellido_Sels", AV27TFMigrLegApellido_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFMigrLegNombre_Sels", AV30TFMigrLegNombre_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV282TFMigrLegModTra_Sels", AV282TFMigrLegModTra_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV285TFMigrLegTipoTarifa_Sels", AV285TFMigrLegTipoTarifa_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76TFMigrLegClase_Sels", AV76TFMigrLegClase_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV38TFMigrLegSexo_Sels", AV38TFMigrLegSexo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFMigrLegDomici_Sels", AV50TFMigrLegDomici_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV56TFMigrLegCodPos_Sels", AV56TFMigrLegCodPos_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV59TFMigrLegTelefono_Sels", AV59TFMigrLegTelefono_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53TFMigrLegEmail_Sels", AV53TFMigrLegEmail_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41TFMigrLegEstadoCivil_Sels", AV41TFMigrLegEstadoCivil_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV70TFMigrLegArea_Sels", AV70TFMigrLegArea_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV121TFMigrLegConvenio_Sels", AV121TFMigrLegConvenio_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV138TFMigrLegObraSocial_Sels", AV138TFMigrLegObraSocial_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV115TFMigrLegCBU_Sels", AV115TFMigrLegCBU_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV135TFMigrLegModalidad_Sels", AV135TFMigrLegModalidad_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV141TFMigrLegObs_Sels", AV141TFMigrLegObs_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV93TFMigrLegSindicato_Sels", AV93TFMigrLegSindicato_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV209CliCodCol", AV209CliCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV213EmpCodCol", AV213EmpCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV217MigrLegNumeroCol", AV217MigrLegNumeroCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV267ManageFiltersData", AV267ManageFiltersData);
   }

   public void e20282( )
   {
      /* 'DoImportarLegajosAlSistema' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADSELECTEDROWS' */
      S212 ();
      if (returnInSub) return;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.mensajeconfirmacionimportarlegajos(remoteHandle, context).execute( AV104CliCod, AV105EmpCod, AV206SelectedRows, GXv_char7) ;
      importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      Dvelop_confirmpanel_btnimportarlegajosalsistema_Confirmationtext = GXt_char10 ;
      ucDvelop_confirmpanel_btnimportarlegajosalsistema.sendProperty(context, "", false, Dvelop_confirmpanel_btnimportarlegajosalsistema_Internalname, "ConfirmationText", Dvelop_confirmpanel_btnimportarlegajosalsistema_Confirmationtext);
      this.executeUsercontrolMethod("", false, "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMAContainer", "Confirm", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV206SelectedRows", AV206SelectedRows);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV209CliCodCol", AV209CliCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV213EmpCodCol", AV213EmpCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV217MigrLegNumeroCol", AV217MigrLegNumeroCol);
   }

   public void e16282( )
   {
      /* Dvelop_confirmpanel_btnimportarlegajosalsistema_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_btnimportarlegajosalsistema_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'LOADSELECTEDROWS' */
         S212 ();
         if (returnInSub) return;
         if ( AV206SelectedRows.size() > 0 )
         {
            GXv_objcol_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem15[0] = AV206SelectedRows ;
            new web.importarlegajosseleccionados(remoteHandle, context).execute( GXv_objcol_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem15) ;
            AV206SelectedRows = GXv_objcol_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem15[0] ;
         }
         else
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_NoRecordSelected", ""));
         }
      }
      gxgrgrid_refresh( subGrid_Rows, AV269ManageFiltersExecutionStep, AV22ColumnsSelector, AV289Pgmname, AV210CliCodJson, AV214EmpCodJson, AV218MigrLegNumeroJson, AV249MenuOpcCod, AV13GridState, AV239TFiconoUpdate, AV240TFiconoUpdateOperator, AV108TFMigrLegId, AV109TFMigrLegId_Sels, AV43TFMigrLegCUIL, AV44TFMigrLegCUIL_Sels, AV26TFMigrLegApellido, AV27TFMigrLegApellido_Sels, AV29TFMigrLegNombre, AV30TFMigrLegNombre_Sels, AV281TFMigrLegModTra, AV282TFMigrLegModTra_Sels, AV284TFMigrLegTipoTarifa, AV285TFMigrLegTipoTarifa_Sels, AV75TFMigrLegClase, AV76TFMigrLegClase_Sels, AV31TFMigrLegFecNac, AV32TFMigrLegFecNac_To, AV60TFMigrLegFecIngreso, AV61TFMigrLegFecIngreso_To, AV37TFMigrLegSexo, AV38TFMigrLegSexo_Sels, AV49TFMigrLegDomici, AV50TFMigrLegDomici_Sels, AV55TFMigrLegCodPos, AV56TFMigrLegCodPos_Sels, AV58TFMigrLegTelefono, AV59TFMigrLegTelefono_Sels, AV52TFMigrLegEmail, AV53TFMigrLegEmail_Sels, AV40TFMigrLegEstadoCivil, AV41TFMigrLegEstadoCivil_Sels, AV69TFMigrLegArea, AV70TFMigrLegArea_Sels, AV77TFMigrLegBasico, AV78TFMigrLegBasico_To, AV120TFMigrLegConvenio, AV121TFMigrLegConvenio_Sels, AV137TFMigrLegObraSocial, AV138TFMigrLegObraSocial_Sels, AV114TFMigrLegCBU, AV115TFMigrLegCBU_Sels, AV134TFMigrLegModalidad, AV135TFMigrLegModalidad_Sels, AV270TFMigrLegHorSem, AV271TFMigrLegHorSem_To, AV140TFMigrLegObs, AV141TFMigrLegObs_Sels, AV92TFMigrLegSindicato, AV93TFMigrLegSindicato_Sels, AV15OrderedBy, AV16OrderedDsc, AV104CliCod, AV100IsAuthorized_Update, AV102IsAuthorized_Delete, AV208i, AV209CliCodCol, AV212CliCodToFind, AV213EmpCodCol, AV216EmpCodToFind, AV217MigrLegNumeroCol, AV220MigrLegNumeroToFind, AV105EmpCod, AV251WelcomeMessage_NoMostrarMas, AV221SelectAll) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV206SelectedRows", AV206SelectedRows);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV209CliCodCol", AV209CliCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV213EmpCodCol", AV213EmpCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV217MigrLegNumeroCol", AV217MigrLegNumeroCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV267ManageFiltersData", AV267ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GridState", AV13GridState);
   }

   public void e21282( )
   {
      /* 'DoEliminarTodos' Routine */
      returnInSub = false ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.mensajeconfirmaciondefault(remoteHandle, context).execute( AV104CliCod, httpContext.getMessage( "eliminar", ""), httpContext.getMessage( "todos los Registros de Importación", ""), GXv_char7) ;
      importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      Dvelop_confirmpanel_btneliminartodos_Confirmationtext = GXt_char10 ;
      ucDvelop_confirmpanel_btneliminartodos.sendProperty(context, "", false, Dvelop_confirmpanel_btneliminartodos_Internalname, "ConfirmationText", Dvelop_confirmpanel_btneliminartodos_Confirmationtext);
      this.executeUsercontrolMethod("", false, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOSContainer", "Confirm", "", new Object[] {});
      /*  Sending Event outputs  */
   }

   public void e17282( )
   {
      /* Dvelop_confirmpanel_btneliminartodos_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_btneliminartodos_Result, "Yes") == 0 )
      {
         new web.eliminarmigrleg(remoteHandle, context).execute( AV104CliCod, AV105EmpCod, 0) ;
         gxgrgrid_refresh( subGrid_Rows, AV269ManageFiltersExecutionStep, AV22ColumnsSelector, AV289Pgmname, AV210CliCodJson, AV214EmpCodJson, AV218MigrLegNumeroJson, AV249MenuOpcCod, AV13GridState, AV239TFiconoUpdate, AV240TFiconoUpdateOperator, AV108TFMigrLegId, AV109TFMigrLegId_Sels, AV43TFMigrLegCUIL, AV44TFMigrLegCUIL_Sels, AV26TFMigrLegApellido, AV27TFMigrLegApellido_Sels, AV29TFMigrLegNombre, AV30TFMigrLegNombre_Sels, AV281TFMigrLegModTra, AV282TFMigrLegModTra_Sels, AV284TFMigrLegTipoTarifa, AV285TFMigrLegTipoTarifa_Sels, AV75TFMigrLegClase, AV76TFMigrLegClase_Sels, AV31TFMigrLegFecNac, AV32TFMigrLegFecNac_To, AV60TFMigrLegFecIngreso, AV61TFMigrLegFecIngreso_To, AV37TFMigrLegSexo, AV38TFMigrLegSexo_Sels, AV49TFMigrLegDomici, AV50TFMigrLegDomici_Sels, AV55TFMigrLegCodPos, AV56TFMigrLegCodPos_Sels, AV58TFMigrLegTelefono, AV59TFMigrLegTelefono_Sels, AV52TFMigrLegEmail, AV53TFMigrLegEmail_Sels, AV40TFMigrLegEstadoCivil, AV41TFMigrLegEstadoCivil_Sels, AV69TFMigrLegArea, AV70TFMigrLegArea_Sels, AV77TFMigrLegBasico, AV78TFMigrLegBasico_To, AV120TFMigrLegConvenio, AV121TFMigrLegConvenio_Sels, AV137TFMigrLegObraSocial, AV138TFMigrLegObraSocial_Sels, AV114TFMigrLegCBU, AV115TFMigrLegCBU_Sels, AV134TFMigrLegModalidad, AV135TFMigrLegModalidad_Sels, AV270TFMigrLegHorSem, AV271TFMigrLegHorSem_To, AV140TFMigrLegObs, AV141TFMigrLegObs_Sels, AV92TFMigrLegSindicato, AV93TFMigrLegSindicato_Sels, AV15OrderedBy, AV16OrderedDsc, AV104CliCod, AV100IsAuthorized_Update, AV102IsAuthorized_Delete, AV208i, AV209CliCodCol, AV212CliCodToFind, AV213EmpCodCol, AV216EmpCodToFind, AV217MigrLegNumeroCol, AV220MigrLegNumeroToFind, AV105EmpCod, AV251WelcomeMessage_NoMostrarMas, AV221SelectAll) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV209CliCodCol", AV209CliCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV213EmpCodCol", AV213EmpCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV217MigrLegNumeroCol", AV217MigrLegNumeroCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV267ManageFiltersData", AV267ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GridState", AV13GridState);
   }

   public void e22282( )
   {
      /* 'DoimportarTodos' Routine */
      returnInSub = false ;
      new web.importartodoslsd_test(remoteHandle, context).execute( AV104CliCod, AV105EmpCod, (short)(99), httpContext.getMessage( "LEGAJOS", "")) ;
   }

   public void e30282( )
   {
      /* Eliminar_Click Routine */
      returnInSub = false ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.mensajeconfirmaciondefault(remoteHandle, context).execute( AV104CliCod, httpContext.getMessage( "eliminar", ""), httpContext.getMessage( "Registro de Importación", ""), GXv_char7) ;
      importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      Dvelop_confirmpanel_eliminar_Confirmationtext = GXt_char10 ;
      ucDvelop_confirmpanel_eliminar.sendProperty(context, "", false, Dvelop_confirmpanel_eliminar_Internalname, "ConfirmationText", Dvelop_confirmpanel_eliminar_Confirmationtext);
      AV234CliCod_Selected = A3CliCod ;
      httpContext.ajax_rsp_assign_attri("", false, "AV234CliCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV234CliCod_Selected), 6, 0));
      AV235EmpCod_Selected = A1EmpCod ;
      httpContext.ajax_rsp_assign_attri("", false, "AV235EmpCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV235EmpCod_Selected), 4, 0));
      AV236MigrLegNumero_Selected = A87MigrLegNumero ;
      httpContext.ajax_rsp_assign_attri("", false, "AV236MigrLegNumero_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV236MigrLegNumero_Selected), 8, 0));
      this.executeUsercontrolMethod("", false, "DVELOP_CONFIRMPANEL_ELIMINARContainer", "Confirm", "", new Object[] {});
      /*  Sending Event outputs  */
   }

   public void e18282( )
   {
      /* Dvelop_confirmpanel_eliminar_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_eliminar_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ELIMINAR' */
         S222 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV209CliCodCol", AV209CliCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV213EmpCodCol", AV213EmpCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV217MigrLegNumeroCol", AV217MigrLegNumeroCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV267ManageFiltersData", AV267ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GridState", AV13GridState);
   }

   public void e23282( )
   {
      /* 'DoGenerarTemplate' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV244TemplateLink ;
      new web.getparametro(remoteHandle, context).execute( AV104CliCod, new web.importarleggooglelink_codigoparam(remoteHandle, context).executeUdp( ), GXv_char7) ;
      importacion_legajoww_impl.this.AV244TemplateLink = GXv_char7[0] ;
      if ( ! (GXutil.strcmp("", AV244TemplateLink)==0) )
      {
         Innewwindow1_Target = AV244TemplateLink ;
         ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
         this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      }
      else
      {
         AV244TemplateLink = httpContext.getMessage( "templates/template importacion legajo.xlsx", "") ;
         callWebObject(formatLink(AV244TemplateLink, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      /*  Sending Event outputs  */
   }

   public void e19282( )
   {
      /* Importexcel_modal_Close Routine */
      returnInSub = false ;
      if ( false )
      {
         httpContext.doAjaxRefresh();
      }
      else
      {
         AV260ResultTexto = Importexcel_modal_Result ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV289Pgmname, httpContext.getMessage( "&ResultTexto ", "")+AV260ResultTexto) ;
         if ( GXutil.strSearch( AV260ResultTexto, httpContext.getMessage( "Importar", ""), 1) != 0 )
         {
            AV258BlobPath = GXutil.strReplace( AV260ResultTexto, httpContext.getMessage( "Importar ", ""), "") ;
            if ( GXutil.strSearch( GXutil.upper( AV258BlobPath), httpContext.getMessage( "XLSX", ""), 1) != 0 )
            {
               AV258BlobPath = GXutil.strReplace( AV258BlobPath, httpContext.getMessage( " _XLSX", ""), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV289Pgmname, httpContext.getMessage( "Procesando! 1", "")+GXutil.trim( AV258BlobPath)) ;
               callSubmit( 1 , new Object[]{ Integer.valueOf(AV104CliCod),Short.valueOf(AV105EmpCod),AV258BlobPath });
               new web.msgdebug_prod(remoteHandle, context).execute( AV289Pgmname, httpContext.getMessage( "Procesando 2!!!", "")) ;
            }
            else
            {
               AV258BlobPath = GXutil.strReplace( AV258BlobPath, httpContext.getMessage( " _TXT", ""), "") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV289Pgmname, httpContext.getMessage( "Procesando!b 1", "")+GXutil.trim( AV258BlobPath)) ;
               callSubmit( 2 , new Object[]{ Integer.valueOf(AV104CliCod),Short.valueOf(AV105EmpCod),Integer.valueOf(99),AV258BlobPath });
               new web.msgdebug_prod(remoteHandle, context).execute( AV289Pgmname, httpContext.getMessage( "Procesandob 2!!!", "")) ;
            }
            lblJs_Caption = httpContext.getMessage( "<script>console.log(\"script init\");iniciarAnimacion(\"", "")+bttBtnimportexcel_Internalname+httpContext.getMessage( "\");</script>", "") ;
            httpContext.ajax_rsp_assign_prop("", false, lblJs_Internalname, "Caption", lblJs_Caption, true);
            new web.msgdebug_prod(remoteHandle, context).execute( AV289Pgmname, httpContext.getMessage( "Procesando 3!!!", "")) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV209CliCodCol", AV209CliCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV213EmpCodCol", AV213EmpCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV217MigrLegNumeroCol", AV217MigrLegNumeroCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV267ManageFiltersData", AV267ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GridState", AV13GridState);
   }

   public void e24282( )
   {
      /* Selectall_Click Routine */
      returnInSub = false ;
      AV209CliCodCol = new GXSimpleCollection<Integer>(Integer.class, "internal", "") ;
      AV213EmpCodCol = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
      AV217MigrLegNumeroCol = new GXSimpleCollection<Integer>(Integer.class, "internal", "") ;
      if ( AV221SelectAll )
      {
         /* Execute user subroutine: 'ADD ALL RECORDS' */
         S232 ();
         if (returnInSub) return;
      }
      /* Start For Each Line */
      nRC_GXsfl_97 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_97"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      nGXsfl_97_fel_idx = 0 ;
      while ( nGXsfl_97_fel_idx < nRC_GXsfl_97 )
      {
         nGXsfl_97_fel_idx = ((subGrid_Islastpage==1)&&(nGXsfl_97_fel_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_97_fel_idx+1) ;
         sGXsfl_97_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_97_fel_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_fel_972( ) ;
         AV205Selected = GXutil.strtobool( httpContext.cgiGet( chkavSelected.getInternalname())) ;
         AV238iconoUpdateWithTags = httpContext.cgiGet( edtavIconoupdatewithtags_Internalname) ;
         AV237iconoUpdate = httpContext.cgiGet( edtavIconoupdate_Internalname) ;
         AV233Eliminar = httpContext.cgiGet( edtavEliminar_Internalname) ;
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A87MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtMigrLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A626MigrLegId = httpContext.cgiGet( edtMigrLegId_Internalname) ;
         A597MigrLegCUIL = httpContext.cgiGet( edtMigrLegCUIL_Internalname) ;
         A592MigrLegApellido = httpContext.cgiGet( edtMigrLegApellido_Internalname) ;
         A593MigrLegNombre = httpContext.cgiGet( edtMigrLegNombre_Internalname) ;
         A2415MigrLegModTra = httpContext.cgiGet( edtMigrLegModTra_Internalname) ;
         A2427MigrLegTipoTarifa = httpContext.cgiGet( edtMigrLegTipoTarifa_Internalname) ;
         A607MigrLegClase = httpContext.cgiGet( edtMigrLegClase_Internalname) ;
         A594MigrLegFecNac = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtMigrLegFecNac_Internalname), 0)) ;
         A603MigrLegFecIngreso = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtMigrLegFecIngreso_Internalname), 0)) ;
         A595MigrLegSexo = httpContext.cgiGet( edtMigrLegSexo_Internalname) ;
         A620MigrLegZona = httpContext.cgiGet( edtMigrLegZona_Internalname) ;
         A599MigrLegDomici = httpContext.cgiGet( edtMigrLegDomici_Internalname) ;
         A601MigrLegCodPos = httpContext.cgiGet( edtMigrLegCodPos_Internalname) ;
         A602MigrLegTelefono = httpContext.cgiGet( edtMigrLegTelefono_Internalname) ;
         A600MigrLegEmail = httpContext.cgiGet( edtMigrLegEmail_Internalname) ;
         A596MigrLegEstadoCivil = httpContext.cgiGet( edtMigrLegEstadoCivil_Internalname) ;
         A598MigrLegDiscapacidad = httpContext.cgiGet( edtMigrLegDiscapacidad_Internalname) ;
         A605MigrLegArea = httpContext.cgiGet( edtMigrLegArea_Internalname) ;
         A608MigrLegBasico = localUtil.ctond( httpContext.cgiGet( edtMigrLegBasico_Internalname)) ;
         A627MigrLegConvenio = httpContext.cgiGet( edtMigrLegConvenio_Internalname) ;
         AV242MigrLegCategoria_var = httpContext.cgiGet( edtavMigrlegcategoria_var_Internalname) ;
         A604MigrLegCategoria = httpContext.cgiGet( edtMigrLegCategoria_Internalname) ;
         A606MigrLegLugarDePago = GXutil.upper( httpContext.cgiGet( edtMigrLegLugarDePago_Internalname)) ;
         A610MigrLegBanco = httpContext.cgiGet( edtMigrLegBanco_Internalname) ;
         A614MigrLegObraSocial = httpContext.cgiGet( edtMigrLegObraSocial_Internalname) ;
         A611MigrLegBanSuc = httpContext.cgiGet( edtMigrLegBanSuc_Internalname) ;
         A612MigrLegBanTipCuen = GXutil.upper( httpContext.cgiGet( edtMigrLegBanTipCuen_Internalname)) ;
         A619MigrLegCuentaBanc = GXutil.upper( httpContext.cgiGet( edtMigrLegCuentaBanc_Internalname)) ;
         A609MigrLegFormaPago = httpContext.cgiGet( edtMigrLegFormaPago_Internalname) ;
         A621MigrLegCBU = httpContext.cgiGet( edtMigrLegCBU_Internalname) ;
         A617MigrLegModalidad = httpContext.cgiGet( edtMigrLegModalidad_Internalname) ;
         A2275MigrLegHorSem = localUtil.ctond( httpContext.cgiGet( edtMigrLegHorSem_Internalname)) ;
         A616MigrLegActividad = httpContext.cgiGet( edtMigrLegActividad_Internalname) ;
         A623MigrLegSituacionRevista = GXutil.upper( httpContext.cgiGet( edtMigrLegSituacionRevista_Internalname)) ;
         A624MigrLegCondicion = GXutil.upper( httpContext.cgiGet( edtMigrLegCondicion_Internalname)) ;
         A625MigrLegSiniestrado = httpContext.cgiGet( edtMigrLegSiniestrado_Internalname) ;
         A622MigrLegSCVO = httpContext.cgiGet( edtMigrLegSCVO_Internalname) ;
         A615MigrLegPlanMedico = httpContext.cgiGet( edtMigrLegPlanMedico_Internalname) ;
         A631MigrTieneConyuge = httpContext.cgiGet( edtMigrTieneConyuge_Internalname) ;
         A632MigrCantidadHijos = (short)(localUtil.ctol( httpContext.cgiGet( edtMigrCantidadHijos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A628MigrLegObs = httpContext.cgiGet( edtMigrLegObs_Internalname) ;
         A2190MigrPeriodo = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtMigrPeriodo_Internalname), 0)) ;
         A2189MigrSueldos = httpContext.cgiGet( edtMigrSueldos_Internalname) ;
         A2216MigrPuesto = httpContext.cgiGet( edtMigrPuesto_Internalname) ;
         A2239MigrLegActLabClas = httpContext.cgiGet( edtMigrLegActLabClas_Internalname) ;
         A2240MigrLegPueAfip = httpContext.cgiGet( edtMigrLegPueAfip_Internalname) ;
         A613MigrLegSindicato = httpContext.cgiGet( edtMigrLegSindicato_Internalname) ;
         AV248Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
         AV99Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
         AV101Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
         AV262DetailWebComponent = httpContext.cgiGet( edtavDetailwebcomponent_Internalname) ;
         AV245VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
         AV246ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
         AV247EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
         AV205Selected = AV221SelectAll ;
         httpContext.ajax_rsp_assign_attri("", false, chkavSelected.getInternalname(), AV205Selected);
         /* End For Each Line */
      }
      if ( nGXsfl_97_fel_idx == 0 )
      {
         nGXsfl_97_idx = 1 ;
         sGXsfl_97_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_97_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_972( ) ;
      }
      nGXsfl_97_fel_idx = 1 ;
      AV210CliCodJson = AV209CliCodCol.toJSonString(false) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV210CliCodJson", AV210CliCodJson);
      AV214EmpCodJson = AV213EmpCodCol.toJSonString(false) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV214EmpCodJson", AV214EmpCodJson);
      AV218MigrLegNumeroJson = AV217MigrLegNumeroCol.toJSonString(false) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV218MigrLegNumeroJson", AV218MigrLegNumeroJson);
      divLayoutmaintable_Class = "Table TableWithSelectableGrid"+((AV209CliCodCol.size()>0) ? " WWPMultiRowSelected" : "") ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV209CliCodCol", AV209CliCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV213EmpCodCol", AV213EmpCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV217MigrLegNumeroCol", AV217MigrLegNumeroCol);
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV15OrderedBy, 4, 0))+":"+(AV16OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S172( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV22ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "&iconoUpdate", "", "Modificar", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegId", "", "ID/Código", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegCUIL", "", "CUIL", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegApellido", "", "Apellido", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegNombre", "", "Nombres", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegModTra", "", "Relación laboral", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegTipoTarifa", "", "Tipo Tarifa", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegClase", "", "Frecuencia de pago", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegFecNac", "", "Fecha de Nacimiento", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegFecIngreso", "", "Fecha de ingreso", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegSexo", "", "Género", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegDomici", "", "Domicilio", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegCodPos", "", "Código Postal", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegTelefono", "", "Teléfono", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegEmail", "", "Email", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegEstadoCivil", "", "Estado Civil", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegArea", "", "Área", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegBasico", "", "Sueldo fuera de convenio", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegConvenio", "", "Convenio", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "&MigrLegCategoria_var", "", "Categoría", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegObraSocial", "", "Obra Social", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegCBU", "", "CBU", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegModalidad", "", "Modalidad", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegHorSem", "", "Horas normales semanales", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegObs", "", "Observaciones", false, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "MigrLegSindicato", "", "Sindicato", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "&VerSVG", "", "", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "&ModificarSVG", "", "", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXv_SdtWWPColumnsSelector16[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, "&EliminarSVG", "", "", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      GXt_char10 = AV21UserCustomValue ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "importacion_legajoWWColumnsSelector", GXv_char7) ;
      importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV21UserCustomValue = GXt_char10 ;
      if ( ! ( (GXutil.strcmp("", AV21UserCustomValue)==0) ) )
      {
         AV23ColumnsSelectorAux.fromxml(AV21UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector16[0] = AV23ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector17[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector16, GXv_SdtWWPColumnsSelector17) ;
         AV23ColumnsSelectorAux = GXv_SdtWWPColumnsSelector16[0] ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector17[0] ;
      }
      GXv_SdtWWPColumnsSelector17[0] = AV22ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV104CliCod, GXv_SdtWWPColumnsSelector17) ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector17[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean14 = AV100IsAuthorized_Update ;
      GXv_boolean8[0] = GXt_boolean14 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajo_Update", GXv_boolean8) ;
      importacion_legajoww_impl.this.GXt_boolean14 = GXv_boolean8[0] ;
      AV100IsAuthorized_Update = GXt_boolean14 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV100IsAuthorized_Update", AV100IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV100IsAuthorized_Update));
      if ( ! ( AV100IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_97_Refreshing);
      }
      GXt_boolean14 = AV102IsAuthorized_Delete ;
      GXv_boolean8[0] = GXt_boolean14 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajo_Delete", GXv_boolean8) ;
      importacion_legajoww_impl.this.GXt_boolean14 = GXv_boolean8[0] ;
      AV102IsAuthorized_Delete = GXt_boolean14 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV102IsAuthorized_Delete", AV102IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV102IsAuthorized_Delete));
      if ( ! ( AV102IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_97_Refreshing);
      }
      GXt_boolean14 = AV103TempBoolean ;
      GXv_boolean8[0] = GXt_boolean14 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "SaveFilterAs", GXv_boolean8) ;
      importacion_legajoww_impl.this.GXt_boolean14 = GXv_boolean8[0] ;
      AV103TempBoolean = GXt_boolean14 ;
      if ( ! ( AV103TempBoolean ) )
      {
         bttBtnimportexcel_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnimportexcel_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnimportexcel_Visible), 5, 0), true);
      }
   }

   public void S182( )
   {
      /* 'GETINDEXOFSELECTEDROW' Routine */
      returnInSub = false ;
      AV208i = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV208i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV208i), 10, 0));
      AV341GXV1 = 1 ;
      while ( AV341GXV1 <= AV209CliCodCol.size() )
      {
         AV211CliCodColItem = ((Number) AV209CliCodCol.elementAt(-1+AV341GXV1)).intValue() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV211CliCodColItem", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV211CliCodColItem), 6, 0));
         if ( ( AV211CliCodColItem == AV212CliCodToFind ) && ( ((Number) AV213EmpCodCol.elementAt(-1+(int)(AV208i))).shortValue() == AV216EmpCodToFind ) && ( ((Number) AV217MigrLegNumeroCol.elementAt(-1+(int)(AV208i))).intValue() == AV220MigrLegNumeroToFind ) )
         {
            if (true) break;
         }
         AV208i = (long)(AV208i+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV208i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV208i), 10, 0));
         AV341GXV1 = (int)(AV341GXV1+1) ;
      }
      if ( AV208i > AV209CliCodCol.size() )
      {
         AV208i = 0 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV208i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV208i), 10, 0));
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 = AV267ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "importacion_legajoWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19[0] ;
      AV267ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 ;
   }

   public void S192( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV240TFiconoUpdateOperator = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV240TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV240TFiconoUpdateOperator), 4, 0));
      Ddo_grid_Selectedfixedfilter = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedFixedFilter", Ddo_grid_Selectedfixedfilter);
      AV108TFMigrLegId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV108TFMigrLegId", AV108TFMigrLegId);
      AV109TFMigrLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43TFMigrLegCUIL = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43TFMigrLegCUIL", AV43TFMigrLegCUIL);
      AV44TFMigrLegCUIL_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26TFMigrLegApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26TFMigrLegApellido", AV26TFMigrLegApellido);
      AV27TFMigrLegApellido_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29TFMigrLegNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFMigrLegNombre", AV29TFMigrLegNombre);
      AV30TFMigrLegNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV281TFMigrLegModTra = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV281TFMigrLegModTra", AV281TFMigrLegModTra);
      AV282TFMigrLegModTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV284TFMigrLegTipoTarifa = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV284TFMigrLegTipoTarifa", AV284TFMigrLegTipoTarifa);
      AV285TFMigrLegTipoTarifa_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV75TFMigrLegClase = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV75TFMigrLegClase", AV75TFMigrLegClase);
      AV76TFMigrLegClase_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31TFMigrLegFecNac = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFMigrLegFecNac", localUtil.format(AV31TFMigrLegFecNac, "99/99/9999"));
      AV32TFMigrLegFecNac_To = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFMigrLegFecNac_To", localUtil.format(AV32TFMigrLegFecNac_To, "99/99/9999"));
      AV60TFMigrLegFecIngreso = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60TFMigrLegFecIngreso", localUtil.format(AV60TFMigrLegFecIngreso, "99/99/9999"));
      AV61TFMigrLegFecIngreso_To = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61TFMigrLegFecIngreso_To", localUtil.format(AV61TFMigrLegFecIngreso_To, "99/99/9999"));
      AV37TFMigrLegSexo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFMigrLegSexo", AV37TFMigrLegSexo);
      AV38TFMigrLegSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49TFMigrLegDomici = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49TFMigrLegDomici", AV49TFMigrLegDomici);
      AV50TFMigrLegDomici_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55TFMigrLegCodPos = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55TFMigrLegCodPos", AV55TFMigrLegCodPos);
      AV56TFMigrLegCodPos_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58TFMigrLegTelefono = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV58TFMigrLegTelefono", AV58TFMigrLegTelefono);
      AV59TFMigrLegTelefono_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52TFMigrLegEmail = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52TFMigrLegEmail", AV52TFMigrLegEmail);
      AV53TFMigrLegEmail_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV40TFMigrLegEstadoCivil = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFMigrLegEstadoCivil", AV40TFMigrLegEstadoCivil);
      AV41TFMigrLegEstadoCivil_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV69TFMigrLegArea = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69TFMigrLegArea", AV69TFMigrLegArea);
      AV70TFMigrLegArea_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV77TFMigrLegBasico = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77TFMigrLegBasico", GXutil.ltrimstr( AV77TFMigrLegBasico, 14, 2));
      AV78TFMigrLegBasico_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78TFMigrLegBasico_To", GXutil.ltrimstr( AV78TFMigrLegBasico_To, 14, 2));
      AV120TFMigrLegConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV120TFMigrLegConvenio", AV120TFMigrLegConvenio);
      AV121TFMigrLegConvenio_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV137TFMigrLegObraSocial = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV137TFMigrLegObraSocial", AV137TFMigrLegObraSocial);
      AV138TFMigrLegObraSocial_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV114TFMigrLegCBU = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV114TFMigrLegCBU", AV114TFMigrLegCBU);
      AV115TFMigrLegCBU_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV134TFMigrLegModalidad = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV134TFMigrLegModalidad", AV134TFMigrLegModalidad);
      AV135TFMigrLegModalidad_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV270TFMigrLegHorSem = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV270TFMigrLegHorSem", GXutil.ltrimstr( AV270TFMigrLegHorSem, 4, 1));
      AV271TFMigrLegHorSem_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV271TFMigrLegHorSem_To", GXutil.ltrimstr( AV271TFMigrLegHorSem_To, 4, 1));
      AV140TFMigrLegObs = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV140TFMigrLegObs", AV140TFMigrLegObs);
      AV141TFMigrLegObs_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV92TFMigrLegSindicato = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV92TFMigrLegSindicato", AV92TFMigrLegSindicato);
      AV93TFMigrLegSindicato_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S222( )
   {
      /* 'DO ELIMINAR' Routine */
      returnInSub = false ;
      new web.eliminarregistromigracionlegajo(remoteHandle, context).execute( AV234CliCod_Selected, AV235EmpCod_Selected, AV236MigrLegNumero_Selected) ;
      gxgrgrid_refresh( subGrid_Rows, AV269ManageFiltersExecutionStep, AV22ColumnsSelector, AV289Pgmname, AV210CliCodJson, AV214EmpCodJson, AV218MigrLegNumeroJson, AV249MenuOpcCod, AV13GridState, AV239TFiconoUpdate, AV240TFiconoUpdateOperator, AV108TFMigrLegId, AV109TFMigrLegId_Sels, AV43TFMigrLegCUIL, AV44TFMigrLegCUIL_Sels, AV26TFMigrLegApellido, AV27TFMigrLegApellido_Sels, AV29TFMigrLegNombre, AV30TFMigrLegNombre_Sels, AV281TFMigrLegModTra, AV282TFMigrLegModTra_Sels, AV284TFMigrLegTipoTarifa, AV285TFMigrLegTipoTarifa_Sels, AV75TFMigrLegClase, AV76TFMigrLegClase_Sels, AV31TFMigrLegFecNac, AV32TFMigrLegFecNac_To, AV60TFMigrLegFecIngreso, AV61TFMigrLegFecIngreso_To, AV37TFMigrLegSexo, AV38TFMigrLegSexo_Sels, AV49TFMigrLegDomici, AV50TFMigrLegDomici_Sels, AV55TFMigrLegCodPos, AV56TFMigrLegCodPos_Sels, AV58TFMigrLegTelefono, AV59TFMigrLegTelefono_Sels, AV52TFMigrLegEmail, AV53TFMigrLegEmail_Sels, AV40TFMigrLegEstadoCivil, AV41TFMigrLegEstadoCivil_Sels, AV69TFMigrLegArea, AV70TFMigrLegArea_Sels, AV77TFMigrLegBasico, AV78TFMigrLegBasico_To, AV120TFMigrLegConvenio, AV121TFMigrLegConvenio_Sels, AV137TFMigrLegObraSocial, AV138TFMigrLegObraSocial_Sels, AV114TFMigrLegCBU, AV115TFMigrLegCBU_Sels, AV134TFMigrLegModalidad, AV135TFMigrLegModalidad_Sels, AV270TFMigrLegHorSem, AV271TFMigrLegHorSem_To, AV140TFMigrLegObs, AV141TFMigrLegObs_Sels, AV92TFMigrLegSindicato, AV93TFMigrLegSindicato_Sels, AV15OrderedBy, AV16OrderedDsc, AV104CliCod, AV100IsAuthorized_Update, AV102IsAuthorized_Delete, AV208i, AV209CliCodCol, AV212CliCodToFind, AV213EmpCodCol, AV216EmpCodToFind, AV217MigrLegNumeroCol, AV220MigrLegNumeroToFind, AV105EmpCod, AV251WelcomeMessage_NoMostrarMas, AV221SelectAll) ;
   }

   public void S212( )
   {
      /* 'LOADSELECTEDROWS' Routine */
      returnInSub = false ;
      AV206SelectedRows = new GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>(web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem.class, "importacion_legajoWWSDTItem", "PayDay", remoteHandle) ;
      AV209CliCodCol.fromJSonString(AV210CliCodJson, null);
      AV213EmpCodCol.fromJSonString(AV214EmpCodJson, null);
      AV217MigrLegNumeroCol.fromJSonString(AV218MigrLegNumeroJson, null);
      AV208i = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV208i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV208i), 10, 0));
      AV342GXV2 = 1 ;
      while ( AV342GXV2 <= AV209CliCodCol.size() )
      {
         AV211CliCodColItem = ((Number) AV209CliCodCol.elementAt(-1+AV342GXV2)).intValue() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV211CliCodColItem", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV211CliCodColItem), 6, 0));
         AV207SelectedRow = (web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem)new web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem(remoteHandle, context);
         AV215EmpCodColItem = ((Number) AV213EmpCodCol.elementAt(-1+(int)(AV208i))).shortValue() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV215EmpCodColItem", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV215EmpCodColItem), 4, 0));
         AV219MigrLegNumeroColItem = ((Number) AV217MigrLegNumeroCol.elementAt(-1+(int)(AV208i))).intValue() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV219MigrLegNumeroColItem", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV219MigrLegNumeroColItem), 8, 0));
         /* Using cursor H00284 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV211CliCodColItem), Short.valueOf(AV215EmpCodColItem), Integer.valueOf(AV219MigrLegNumeroColItem)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A87MigrLegNumero = H00284_A87MigrLegNumero[0] ;
            A1EmpCod = H00284_A1EmpCod[0] ;
            A3CliCod = H00284_A3CliCod[0] ;
            A626MigrLegId = H00284_A626MigrLegId[0] ;
            A597MigrLegCUIL = H00284_A597MigrLegCUIL[0] ;
            A592MigrLegApellido = H00284_A592MigrLegApellido[0] ;
            A593MigrLegNombre = H00284_A593MigrLegNombre[0] ;
            A2415MigrLegModTra = H00284_A2415MigrLegModTra[0] ;
            A2427MigrLegTipoTarifa = H00284_A2427MigrLegTipoTarifa[0] ;
            A607MigrLegClase = H00284_A607MigrLegClase[0] ;
            A594MigrLegFecNac = H00284_A594MigrLegFecNac[0] ;
            A603MigrLegFecIngreso = H00284_A603MigrLegFecIngreso[0] ;
            A595MigrLegSexo = H00284_A595MigrLegSexo[0] ;
            A620MigrLegZona = H00284_A620MigrLegZona[0] ;
            A599MigrLegDomici = H00284_A599MigrLegDomici[0] ;
            A601MigrLegCodPos = H00284_A601MigrLegCodPos[0] ;
            A602MigrLegTelefono = H00284_A602MigrLegTelefono[0] ;
            A600MigrLegEmail = H00284_A600MigrLegEmail[0] ;
            A596MigrLegEstadoCivil = H00284_A596MigrLegEstadoCivil[0] ;
            A598MigrLegDiscapacidad = H00284_A598MigrLegDiscapacidad[0] ;
            A605MigrLegArea = H00284_A605MigrLegArea[0] ;
            A608MigrLegBasico = H00284_A608MigrLegBasico[0] ;
            A627MigrLegConvenio = H00284_A627MigrLegConvenio[0] ;
            A604MigrLegCategoria = H00284_A604MigrLegCategoria[0] ;
            A606MigrLegLugarDePago = H00284_A606MigrLegLugarDePago[0] ;
            A610MigrLegBanco = H00284_A610MigrLegBanco[0] ;
            A614MigrLegObraSocial = H00284_A614MigrLegObraSocial[0] ;
            A611MigrLegBanSuc = H00284_A611MigrLegBanSuc[0] ;
            A612MigrLegBanTipCuen = H00284_A612MigrLegBanTipCuen[0] ;
            A619MigrLegCuentaBanc = H00284_A619MigrLegCuentaBanc[0] ;
            A609MigrLegFormaPago = H00284_A609MigrLegFormaPago[0] ;
            A621MigrLegCBU = H00284_A621MigrLegCBU[0] ;
            A617MigrLegModalidad = H00284_A617MigrLegModalidad[0] ;
            A2275MigrLegHorSem = H00284_A2275MigrLegHorSem[0] ;
            A616MigrLegActividad = H00284_A616MigrLegActividad[0] ;
            A623MigrLegSituacionRevista = H00284_A623MigrLegSituacionRevista[0] ;
            A624MigrLegCondicion = H00284_A624MigrLegCondicion[0] ;
            A625MigrLegSiniestrado = H00284_A625MigrLegSiniestrado[0] ;
            A622MigrLegSCVO = H00284_A622MigrLegSCVO[0] ;
            A615MigrLegPlanMedico = H00284_A615MigrLegPlanMedico[0] ;
            A631MigrTieneConyuge = H00284_A631MigrTieneConyuge[0] ;
            A632MigrCantidadHijos = H00284_A632MigrCantidadHijos[0] ;
            A628MigrLegObs = H00284_A628MigrLegObs[0] ;
            A2190MigrPeriodo = H00284_A2190MigrPeriodo[0] ;
            A2189MigrSueldos = H00284_A2189MigrSueldos[0] ;
            A2216MigrPuesto = H00284_A2216MigrPuesto[0] ;
            A2239MigrLegActLabClas = H00284_A2239MigrLegActLabClas[0] ;
            A2240MigrLegPueAfip = H00284_A2240MigrLegPueAfip[0] ;
            A613MigrLegSindicato = H00284_A613MigrLegSindicato[0] ;
            AV237iconoUpdate = "<i class=\"fa fa-pen\"></i>" ;
            httpContext.ajax_rsp_assign_attri("", false, edtavIconoupdate_Internalname, AV237iconoUpdate);
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Iconoupdate( AV237iconoUpdate );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Clicod( A3CliCod );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Empcod( A1EmpCod );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnumero( A87MigrLegNumero );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegid( A626MigrLegId );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuil( A597MigrLegCUIL );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegapellido( A592MigrLegApellido );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegnombre( A593MigrLegNombre );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodtra( A2415MigrLegModTra );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtipotarifa( A2427MigrLegTipoTarifa );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegclase( A607MigrLegClase );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecnac( A594MigrLegFecNac );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegfecingreso( A603MigrLegFecIngreso );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsexo( A595MigrLegSexo );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegzona( A620MigrLegZona );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdomici( A599MigrLegDomici );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcodpos( A601MigrLegCodPos );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegtelefono( A602MigrLegTelefono );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegemail( A600MigrLegEmail );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegestadocivil( A596MigrLegEstadoCivil );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegdiscapacidad( A598MigrLegDiscapacidad );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegarea( A605MigrLegArea );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbasico( A608MigrLegBasico );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegconvenio( A627MigrLegConvenio );
            if ( (GXutil.strcmp("", A604MigrLegCategoria)==0) )
            {
               AV241MigrLegCategoria = httpContext.getMessage( "Ninguna (Fuera de Convenio)", "") ;
            }
            else
            {
               AV241MigrLegCategoria = A604MigrLegCategoria ;
            }
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria_var( AV242MigrLegCategoria_var );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcategoria( A604MigrLegCategoria );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleglugardepago( A606MigrLegLugarDePago );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbanco( A610MigrLegBanco );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobrasocial( A614MigrLegObraSocial );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbansuc( A611MigrLegBanSuc );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegbantipcuen( A612MigrLegBanTipCuen );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcuentabanc( A619MigrLegCuentaBanc );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegformapago( A609MigrLegFormaPago );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcbu( A621MigrLegCBU );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegmodalidad( A617MigrLegModalidad );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrleghorsem( A2275MigrLegHorSem );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactividad( A616MigrLegActividad );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsituacionrevista( A623MigrLegSituacionRevista );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegcondicion( A624MigrLegCondicion );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsiniestrado( A625MigrLegSiniestrado );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegscvo( A622MigrLegSCVO );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegplanmedico( A615MigrLegPlanMedico );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrtieneconyuge( A631MigrTieneConyuge );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrcantidadhijos( A632MigrCantidadHijos );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegobs( A628MigrLegObs );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrperiodo( A2190MigrPeriodo );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrsueldos( A2189MigrSueldos );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrpuesto( A2216MigrPuesto );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegactlabclas( A2239MigrLegActLabClas );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegpueafip( A2240MigrLegPueAfip );
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Migrlegsindicato( A613MigrLegSindicato );
            edtavVersvg_Format = (short)(1) ;
            GXt_char10 = AV245VerSVG ;
            GXv_char7[0] = GXt_char10 ;
            new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
            importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
            AV245VerSVG = GXt_char10 ;
            httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV245VerSVG);
            edtavVersvg_Link = edtavDisplay_Link ;
            httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Link", edtavVersvg_Link, !bGXsfl_97_Refreshing);
            edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
            httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Columnclass", edtavVersvg_Columnclass, !bGXsfl_97_Refreshing);
            edtavDisplay_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Visible), 5, 0), !bGXsfl_97_Refreshing);
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Versvg( AV245VerSVG );
            edtavModificarsvg_Format = (short)(1) ;
            GXt_char10 = AV246ModificarSVG ;
            GXv_char7[0] = GXt_char10 ;
            new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char7) ;
            importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
            AV246ModificarSVG = GXt_char10 ;
            httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV246ModificarSVG);
            edtavModificarsvg_Link = edtavUpdate_Link ;
            httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Link", edtavModificarsvg_Link, !bGXsfl_97_Refreshing);
            edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
            httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Columnclass", edtavModificarsvg_Columnclass, !bGXsfl_97_Refreshing);
            edtavUpdate_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_97_Refreshing);
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Modificarsvg( AV246ModificarSVG );
            edtavEliminarsvg_Format = (short)(1) ;
            GXt_char10 = AV247EliminarSVG ;
            GXv_char7[0] = GXt_char10 ;
            new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char7) ;
            importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
            AV247EliminarSVG = GXt_char10 ;
            httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV247EliminarSVG);
            edtavEliminarsvg_Link = edtavDelete_Link ;
            httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Link", edtavEliminarsvg_Link, !bGXsfl_97_Refreshing);
            edtavDelete_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_97_Refreshing);
            AV207SelectedRow.setgxTv_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem_Eliminarsvg( AV247EliminarSVG );
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(2);
         AV206SelectedRows.add(AV207SelectedRow, 0);
         AV208i = (long)(AV208i+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV208i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV208i), 10, 0));
         AV342GXV2 = (int)(AV342GXV2+1) ;
      }
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV24Session.getValue(AV289Pgmname+"GridState"), "") == 0 )
      {
         AV13GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV289Pgmname+"GridState"), null, null);
      }
      else
      {
         AV13GridState.fromxml(AV24Session.getValue(AV289Pgmname+"GridState"), null, null);
      }
      AV15OrderedBy = AV13GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15OrderedBy), 4, 0));
      AV16OrderedDsc = AV13GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16OrderedDsc", AV16OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S202 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV13GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV13GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV13GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S202( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV344GXV3 = 1 ;
      while ( AV344GXV3 <= AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV14GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV344GXV3));
         if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFICONOUPDATE") == 0 )
         {
            AV240TFiconoUpdateOperator = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Operator() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV240TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV240TFiconoUpdateOperator), 4, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGID") == 0 )
         {
            AV108TFMigrLegId = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV108TFMigrLegId", AV108TFMigrLegId);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGID_SEL") == 0 )
         {
            AV107TFMigrLegId_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV107TFMigrLegId_SelsJson", AV107TFMigrLegId_SelsJson);
            AV109TFMigrLegId_Sels.fromJSonString(AV107TFMigrLegId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGCUIL") == 0 )
         {
            AV43TFMigrLegCUIL = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFMigrLegCUIL", AV43TFMigrLegCUIL);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGCUIL_SEL") == 0 )
         {
            AV42TFMigrLegCUIL_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFMigrLegCUIL_SelsJson", AV42TFMigrLegCUIL_SelsJson);
            AV44TFMigrLegCUIL_Sels.fromJSonString(AV42TFMigrLegCUIL_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGAPELLIDO") == 0 )
         {
            AV26TFMigrLegApellido = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFMigrLegApellido", AV26TFMigrLegApellido);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGAPELLIDO_SEL") == 0 )
         {
            AV25TFMigrLegApellido_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFMigrLegApellido_SelsJson", AV25TFMigrLegApellido_SelsJson);
            AV27TFMigrLegApellido_Sels.fromJSonString(AV25TFMigrLegApellido_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGNOMBRE") == 0 )
         {
            AV29TFMigrLegNombre = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFMigrLegNombre", AV29TFMigrLegNombre);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGNOMBRE_SEL") == 0 )
         {
            AV28TFMigrLegNombre_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFMigrLegNombre_SelsJson", AV28TFMigrLegNombre_SelsJson);
            AV30TFMigrLegNombre_Sels.fromJSonString(AV28TFMigrLegNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGMODTRA") == 0 )
         {
            AV281TFMigrLegModTra = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV281TFMigrLegModTra", AV281TFMigrLegModTra);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGMODTRA_SEL") == 0 )
         {
            AV280TFMigrLegModTra_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV280TFMigrLegModTra_SelsJson", AV280TFMigrLegModTra_SelsJson);
            AV282TFMigrLegModTra_Sels.fromJSonString(AV280TFMigrLegModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGTIPOTARIFA") == 0 )
         {
            AV284TFMigrLegTipoTarifa = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV284TFMigrLegTipoTarifa", AV284TFMigrLegTipoTarifa);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGTIPOTARIFA_SEL") == 0 )
         {
            AV283TFMigrLegTipoTarifa_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV283TFMigrLegTipoTarifa_SelsJson", AV283TFMigrLegTipoTarifa_SelsJson);
            AV285TFMigrLegTipoTarifa_Sels.fromJSonString(AV283TFMigrLegTipoTarifa_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGCLASE") == 0 )
         {
            AV75TFMigrLegClase = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFMigrLegClase", AV75TFMigrLegClase);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGCLASE_SEL") == 0 )
         {
            AV74TFMigrLegClase_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFMigrLegClase_SelsJson", AV74TFMigrLegClase_SelsJson);
            AV76TFMigrLegClase_Sels.fromJSonString(AV74TFMigrLegClase_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFECNAC") == 0 )
         {
            AV31TFMigrLegFecNac = localUtil.ctod( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFMigrLegFecNac", localUtil.format(AV31TFMigrLegFecNac, "99/99/9999"));
            AV32TFMigrLegFecNac_To = localUtil.ctod( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFMigrLegFecNac_To", localUtil.format(AV32TFMigrLegFecNac_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFECINGRESO") == 0 )
         {
            AV60TFMigrLegFecIngreso = localUtil.ctod( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFMigrLegFecIngreso", localUtil.format(AV60TFMigrLegFecIngreso, "99/99/9999"));
            AV61TFMigrLegFecIngreso_To = localUtil.ctod( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFMigrLegFecIngreso_To", localUtil.format(AV61TFMigrLegFecIngreso_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGSEXO") == 0 )
         {
            AV37TFMigrLegSexo = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFMigrLegSexo", AV37TFMigrLegSexo);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGSEXO_SEL") == 0 )
         {
            AV36TFMigrLegSexo_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFMigrLegSexo_SelsJson", AV36TFMigrLegSexo_SelsJson);
            AV38TFMigrLegSexo_Sels.fromJSonString(AV36TFMigrLegSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGDOMICI") == 0 )
         {
            AV49TFMigrLegDomici = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFMigrLegDomici", AV49TFMigrLegDomici);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGDOMICI_SEL") == 0 )
         {
            AV48TFMigrLegDomici_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFMigrLegDomici_SelsJson", AV48TFMigrLegDomici_SelsJson);
            AV50TFMigrLegDomici_Sels.fromJSonString(AV48TFMigrLegDomici_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGCODPOS") == 0 )
         {
            AV55TFMigrLegCodPos = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFMigrLegCodPos", AV55TFMigrLegCodPos);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGCODPOS_SEL") == 0 )
         {
            AV54TFMigrLegCodPos_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFMigrLegCodPos_SelsJson", AV54TFMigrLegCodPos_SelsJson);
            AV56TFMigrLegCodPos_Sels.fromJSonString(AV54TFMigrLegCodPos_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGTELEFONO") == 0 )
         {
            AV58TFMigrLegTelefono = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFMigrLegTelefono", AV58TFMigrLegTelefono);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGTELEFONO_SEL") == 0 )
         {
            AV57TFMigrLegTelefono_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFMigrLegTelefono_SelsJson", AV57TFMigrLegTelefono_SelsJson);
            AV59TFMigrLegTelefono_Sels.fromJSonString(AV57TFMigrLegTelefono_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGEMAIL") == 0 )
         {
            AV52TFMigrLegEmail = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFMigrLegEmail", AV52TFMigrLegEmail);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGEMAIL_SEL") == 0 )
         {
            AV51TFMigrLegEmail_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFMigrLegEmail_SelsJson", AV51TFMigrLegEmail_SelsJson);
            AV53TFMigrLegEmail_Sels.fromJSonString(AV51TFMigrLegEmail_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGESTADOCIVIL") == 0 )
         {
            AV40TFMigrLegEstadoCivil = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFMigrLegEstadoCivil", AV40TFMigrLegEstadoCivil);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGESTADOCIVIL_SEL") == 0 )
         {
            AV39TFMigrLegEstadoCivil_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFMigrLegEstadoCivil_SelsJson", AV39TFMigrLegEstadoCivil_SelsJson);
            AV41TFMigrLegEstadoCivil_Sels.fromJSonString(AV39TFMigrLegEstadoCivil_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGAREA") == 0 )
         {
            AV69TFMigrLegArea = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFMigrLegArea", AV69TFMigrLegArea);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGAREA_SEL") == 0 )
         {
            AV68TFMigrLegArea_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFMigrLegArea_SelsJson", AV68TFMigrLegArea_SelsJson);
            AV70TFMigrLegArea_Sels.fromJSonString(AV68TFMigrLegArea_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGBASICO") == 0 )
         {
            AV77TFMigrLegBasico = CommonUtil.decimalVal( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFMigrLegBasico", GXutil.ltrimstr( AV77TFMigrLegBasico, 14, 2));
            AV78TFMigrLegBasico_To = CommonUtil.decimalVal( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFMigrLegBasico_To", GXutil.ltrimstr( AV78TFMigrLegBasico_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGCONVENIO") == 0 )
         {
            AV120TFMigrLegConvenio = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV120TFMigrLegConvenio", AV120TFMigrLegConvenio);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGCONVENIO_SEL") == 0 )
         {
            AV119TFMigrLegConvenio_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV119TFMigrLegConvenio_SelsJson", AV119TFMigrLegConvenio_SelsJson);
            AV121TFMigrLegConvenio_Sels.fromJSonString(AV119TFMigrLegConvenio_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGOBRASOCIAL") == 0 )
         {
            AV137TFMigrLegObraSocial = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV137TFMigrLegObraSocial", AV137TFMigrLegObraSocial);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGOBRASOCIAL_SEL") == 0 )
         {
            AV136TFMigrLegObraSocial_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV136TFMigrLegObraSocial_SelsJson", AV136TFMigrLegObraSocial_SelsJson);
            AV138TFMigrLegObraSocial_Sels.fromJSonString(AV136TFMigrLegObraSocial_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGCBU") == 0 )
         {
            AV114TFMigrLegCBU = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV114TFMigrLegCBU", AV114TFMigrLegCBU);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGCBU_SEL") == 0 )
         {
            AV113TFMigrLegCBU_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV113TFMigrLegCBU_SelsJson", AV113TFMigrLegCBU_SelsJson);
            AV115TFMigrLegCBU_Sels.fromJSonString(AV113TFMigrLegCBU_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGMODALIDAD") == 0 )
         {
            AV134TFMigrLegModalidad = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV134TFMigrLegModalidad", AV134TFMigrLegModalidad);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGMODALIDAD_SEL") == 0 )
         {
            AV133TFMigrLegModalidad_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV133TFMigrLegModalidad_SelsJson", AV133TFMigrLegModalidad_SelsJson);
            AV135TFMigrLegModalidad_Sels.fromJSonString(AV133TFMigrLegModalidad_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGHORSEM") == 0 )
         {
            AV270TFMigrLegHorSem = CommonUtil.decimalVal( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV270TFMigrLegHorSem", GXutil.ltrimstr( AV270TFMigrLegHorSem, 4, 1));
            AV271TFMigrLegHorSem_To = CommonUtil.decimalVal( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV271TFMigrLegHorSem_To", GXutil.ltrimstr( AV271TFMigrLegHorSem_To, 4, 1));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGOBS") == 0 )
         {
            AV140TFMigrLegObs = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV140TFMigrLegObs", AV140TFMigrLegObs);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGOBS_SEL") == 0 )
         {
            AV139TFMigrLegObs_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV139TFMigrLegObs_SelsJson", AV139TFMigrLegObs_SelsJson);
            AV141TFMigrLegObs_Sels.fromJSonString(AV139TFMigrLegObs_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGSINDICATO") == 0 )
         {
            AV92TFMigrLegSindicato = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV92TFMigrLegSindicato", AV92TFMigrLegSindicato);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGSINDICATO_SEL") == 0 )
         {
            AV91TFMigrLegSindicato_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91TFMigrLegSindicato_SelsJson", AV91TFMigrLegSindicato_SelsJson);
            AV93TFMigrLegSindicato_Sels.fromJSonString(AV91TFMigrLegSindicato_SelsJson, null);
         }
         AV344GXV3 = (int)(AV344GXV3+1) ;
      }
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV109TFMigrLegId_Sels.size()==0), AV107TFMigrLegId_SelsJson, GXv_char7) ;
      importacion_legajoww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV44TFMigrLegCUIL_Sels.size()==0), AV42TFMigrLegCUIL_SelsJson, GXv_char6) ;
      importacion_legajoww_impl.this.GXt_char9 = GXv_char6[0] ;
      GXt_char20 = "" ;
      GXv_char5[0] = GXt_char20 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV27TFMigrLegApellido_Sels.size()==0), AV25TFMigrLegApellido_SelsJson, GXv_char5) ;
      importacion_legajoww_impl.this.GXt_char20 = GXv_char5[0] ;
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV30TFMigrLegNombre_Sels.size()==0), AV28TFMigrLegNombre_SelsJson, GXv_char22) ;
      importacion_legajoww_impl.this.GXt_char21 = GXv_char22[0] ;
      GXt_char23 = "" ;
      GXv_char24[0] = GXt_char23 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV282TFMigrLegModTra_Sels.size()==0), AV280TFMigrLegModTra_SelsJson, GXv_char24) ;
      importacion_legajoww_impl.this.GXt_char23 = GXv_char24[0] ;
      GXt_char25 = "" ;
      GXv_char26[0] = GXt_char25 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV285TFMigrLegTipoTarifa_Sels.size()==0), AV283TFMigrLegTipoTarifa_SelsJson, GXv_char26) ;
      importacion_legajoww_impl.this.GXt_char25 = GXv_char26[0] ;
      GXt_char27 = "" ;
      GXv_char28[0] = GXt_char27 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV76TFMigrLegClase_Sels.size()==0), AV74TFMigrLegClase_SelsJson, GXv_char28) ;
      importacion_legajoww_impl.this.GXt_char27 = GXv_char28[0] ;
      GXt_char29 = "" ;
      GXv_char30[0] = GXt_char29 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV38TFMigrLegSexo_Sels.size()==0), AV36TFMigrLegSexo_SelsJson, GXv_char30) ;
      importacion_legajoww_impl.this.GXt_char29 = GXv_char30[0] ;
      GXt_char31 = "" ;
      GXv_char32[0] = GXt_char31 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV50TFMigrLegDomici_Sels.size()==0), AV48TFMigrLegDomici_SelsJson, GXv_char32) ;
      importacion_legajoww_impl.this.GXt_char31 = GXv_char32[0] ;
      GXt_char33 = "" ;
      GXv_char34[0] = GXt_char33 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV56TFMigrLegCodPos_Sels.size()==0), AV54TFMigrLegCodPos_SelsJson, GXv_char34) ;
      importacion_legajoww_impl.this.GXt_char33 = GXv_char34[0] ;
      GXt_char35 = "" ;
      GXv_char36[0] = GXt_char35 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV59TFMigrLegTelefono_Sels.size()==0), AV57TFMigrLegTelefono_SelsJson, GXv_char36) ;
      importacion_legajoww_impl.this.GXt_char35 = GXv_char36[0] ;
      GXt_char37 = "" ;
      GXv_char38[0] = GXt_char37 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV53TFMigrLegEmail_Sels.size()==0), AV51TFMigrLegEmail_SelsJson, GXv_char38) ;
      importacion_legajoww_impl.this.GXt_char37 = GXv_char38[0] ;
      GXt_char39 = "" ;
      GXv_char40[0] = GXt_char39 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV41TFMigrLegEstadoCivil_Sels.size()==0), AV39TFMigrLegEstadoCivil_SelsJson, GXv_char40) ;
      importacion_legajoww_impl.this.GXt_char39 = GXv_char40[0] ;
      GXt_char41 = "" ;
      GXv_char42[0] = GXt_char41 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV70TFMigrLegArea_Sels.size()==0), AV68TFMigrLegArea_SelsJson, GXv_char42) ;
      importacion_legajoww_impl.this.GXt_char41 = GXv_char42[0] ;
      GXt_char43 = "" ;
      GXv_char44[0] = GXt_char43 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV121TFMigrLegConvenio_Sels.size()==0), AV119TFMigrLegConvenio_SelsJson, GXv_char44) ;
      importacion_legajoww_impl.this.GXt_char43 = GXv_char44[0] ;
      GXt_char45 = "" ;
      GXv_char46[0] = GXt_char45 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV138TFMigrLegObraSocial_Sels.size()==0), AV136TFMigrLegObraSocial_SelsJson, GXv_char46) ;
      importacion_legajoww_impl.this.GXt_char45 = GXv_char46[0] ;
      GXt_char47 = "" ;
      GXv_char48[0] = GXt_char47 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV115TFMigrLegCBU_Sels.size()==0), AV113TFMigrLegCBU_SelsJson, GXv_char48) ;
      importacion_legajoww_impl.this.GXt_char47 = GXv_char48[0] ;
      GXt_char49 = "" ;
      GXv_char50[0] = GXt_char49 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV135TFMigrLegModalidad_Sels.size()==0), AV133TFMigrLegModalidad_SelsJson, GXv_char50) ;
      importacion_legajoww_impl.this.GXt_char49 = GXv_char50[0] ;
      GXt_char51 = "" ;
      GXv_char52[0] = GXt_char51 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV141TFMigrLegObs_Sels.size()==0), AV139TFMigrLegObs_SelsJson, GXv_char52) ;
      importacion_legajoww_impl.this.GXt_char51 = GXv_char52[0] ;
      GXt_char53 = "" ;
      GXv_char54[0] = GXt_char53 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV93TFMigrLegSindicato_Sels.size()==0), AV91TFMigrLegSindicato_SelsJson, GXv_char54) ;
      importacion_legajoww_impl.this.GXt_char53 = GXv_char54[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char10+"|"+GXt_char9+"|"+GXt_char20+"|"+GXt_char21+"|"+GXt_char23+"|"+GXt_char25+"|"+GXt_char27+"|||"+GXt_char29+"|"+GXt_char31+"|"+GXt_char33+"|"+GXt_char35+"|"+GXt_char37+"|"+GXt_char39+"|"+GXt_char41+"||"+GXt_char43+"||"+GXt_char45+"|"+GXt_char47+"|"+GXt_char49+"||"+GXt_char51+"|"+GXt_char53 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char53 = "" ;
      GXv_char54[0] = GXt_char53 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV108TFMigrLegId)==0), AV108TFMigrLegId, GXv_char54) ;
      importacion_legajoww_impl.this.GXt_char53 = GXv_char54[0] ;
      GXt_char51 = "" ;
      GXv_char52[0] = GXt_char51 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV43TFMigrLegCUIL)==0), AV43TFMigrLegCUIL, GXv_char52) ;
      importacion_legajoww_impl.this.GXt_char51 = GXv_char52[0] ;
      GXt_char49 = "" ;
      GXv_char50[0] = GXt_char49 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV26TFMigrLegApellido)==0), AV26TFMigrLegApellido, GXv_char50) ;
      importacion_legajoww_impl.this.GXt_char49 = GXv_char50[0] ;
      GXt_char47 = "" ;
      GXv_char48[0] = GXt_char47 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV29TFMigrLegNombre)==0), AV29TFMigrLegNombre, GXv_char48) ;
      importacion_legajoww_impl.this.GXt_char47 = GXv_char48[0] ;
      GXt_char45 = "" ;
      GXv_char46[0] = GXt_char45 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV281TFMigrLegModTra)==0), AV281TFMigrLegModTra, GXv_char46) ;
      importacion_legajoww_impl.this.GXt_char45 = GXv_char46[0] ;
      GXt_char43 = "" ;
      GXv_char44[0] = GXt_char43 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV284TFMigrLegTipoTarifa)==0), AV284TFMigrLegTipoTarifa, GXv_char44) ;
      importacion_legajoww_impl.this.GXt_char43 = GXv_char44[0] ;
      GXt_char41 = "" ;
      GXv_char42[0] = GXt_char41 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV75TFMigrLegClase)==0), AV75TFMigrLegClase, GXv_char42) ;
      importacion_legajoww_impl.this.GXt_char41 = GXv_char42[0] ;
      GXt_char39 = "" ;
      GXv_char40[0] = GXt_char39 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV37TFMigrLegSexo)==0), AV37TFMigrLegSexo, GXv_char40) ;
      importacion_legajoww_impl.this.GXt_char39 = GXv_char40[0] ;
      GXt_char37 = "" ;
      GXv_char38[0] = GXt_char37 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV49TFMigrLegDomici)==0), AV49TFMigrLegDomici, GXv_char38) ;
      importacion_legajoww_impl.this.GXt_char37 = GXv_char38[0] ;
      GXt_char35 = "" ;
      GXv_char36[0] = GXt_char35 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV55TFMigrLegCodPos)==0), AV55TFMigrLegCodPos, GXv_char36) ;
      importacion_legajoww_impl.this.GXt_char35 = GXv_char36[0] ;
      GXt_char33 = "" ;
      GXv_char34[0] = GXt_char33 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV58TFMigrLegTelefono)==0), AV58TFMigrLegTelefono, GXv_char34) ;
      importacion_legajoww_impl.this.GXt_char33 = GXv_char34[0] ;
      GXt_char31 = "" ;
      GXv_char32[0] = GXt_char31 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV52TFMigrLegEmail)==0), AV52TFMigrLegEmail, GXv_char32) ;
      importacion_legajoww_impl.this.GXt_char31 = GXv_char32[0] ;
      GXt_char29 = "" ;
      GXv_char30[0] = GXt_char29 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFMigrLegEstadoCivil)==0), AV40TFMigrLegEstadoCivil, GXv_char30) ;
      importacion_legajoww_impl.this.GXt_char29 = GXv_char30[0] ;
      GXt_char27 = "" ;
      GXv_char28[0] = GXt_char27 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV69TFMigrLegArea)==0), AV69TFMigrLegArea, GXv_char28) ;
      importacion_legajoww_impl.this.GXt_char27 = GXv_char28[0] ;
      GXt_char25 = "" ;
      GXv_char26[0] = GXt_char25 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV120TFMigrLegConvenio)==0), AV120TFMigrLegConvenio, GXv_char26) ;
      importacion_legajoww_impl.this.GXt_char25 = GXv_char26[0] ;
      GXt_char23 = "" ;
      GXv_char24[0] = GXt_char23 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV137TFMigrLegObraSocial)==0), AV137TFMigrLegObraSocial, GXv_char24) ;
      importacion_legajoww_impl.this.GXt_char23 = GXv_char24[0] ;
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV114TFMigrLegCBU)==0), AV114TFMigrLegCBU, GXv_char22) ;
      importacion_legajoww_impl.this.GXt_char21 = GXv_char22[0] ;
      GXt_char20 = "" ;
      GXv_char7[0] = GXt_char20 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV134TFMigrLegModalidad)==0), AV134TFMigrLegModalidad, GXv_char7) ;
      importacion_legajoww_impl.this.GXt_char20 = GXv_char7[0] ;
      GXt_char10 = "" ;
      GXv_char6[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV140TFMigrLegObs)==0), AV140TFMigrLegObs, GXv_char6) ;
      importacion_legajoww_impl.this.GXt_char10 = GXv_char6[0] ;
      GXt_char9 = "" ;
      GXv_char5[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV92TFMigrLegSindicato)==0), AV92TFMigrLegSindicato, GXv_char5) ;
      importacion_legajoww_impl.this.GXt_char9 = GXv_char5[0] ;
      Ddo_grid_Filteredtext_set = "|"+GXt_char53+"|"+GXt_char51+"|"+GXt_char49+"|"+GXt_char47+"|"+GXt_char45+"|"+GXt_char43+"|"+GXt_char41+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV31TFMigrLegFecNac)) ? "" : localUtil.dtoc( AV31TFMigrLegFecNac, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV60TFMigrLegFecIngreso)) ? "" : localUtil.dtoc( AV60TFMigrLegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+GXt_char39+"|"+GXt_char37+"|"+GXt_char35+"|"+GXt_char33+"|"+GXt_char31+"|"+GXt_char29+"|"+GXt_char27+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV77TFMigrLegBasico)==0) ? "" : GXutil.str( AV77TFMigrLegBasico, 14, 2))+"|"+GXt_char25+"||"+GXt_char23+"|"+GXt_char21+"|"+GXt_char20+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV270TFMigrLegHorSem)==0) ? "" : GXutil.str( AV270TFMigrLegHorSem, 4, 1))+"|"+GXt_char10+"|"+GXt_char9 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "||||||||"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV32TFMigrLegFecNac_To)) ? "" : localUtil.dtoc( AV32TFMigrLegFecNac_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV61TFMigrLegFecIngreso_To)) ? "" : localUtil.dtoc( AV61TFMigrLegFecIngreso_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"||||||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV78TFMigrLegBasico_To)==0) ? "" : GXutil.str( AV78TFMigrLegBasico_To, 14, 2))+"||||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV271TFMigrLegHorSem_To)==0) ? "" : GXutil.str( AV271TFMigrLegHorSem_To, 4, 1))+"||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      Ddo_grid_Selectedfixedfilter = ((AV240TFiconoUpdateOperator!=1) ? "" : "1")+((AV240TFiconoUpdateOperator!=2) ? "" : "2")+((AV240TFiconoUpdateOperator!=3) ? "" : "3")+"|||||||||||||||||||||||||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedFixedFilter", Ddo_grid_Selectedfixedfilter);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV13GridState.fromxml(AV24Session.getValue(AV289Pgmname+"GridState"), null, null);
      AV13GridState.setgxTv_SdtWWPGridState_Orderedby( AV15OrderedBy );
      AV13GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV16OrderedDsc );
      AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFICONOUPDATE", httpContext.getMessage( "Modificar", ""), !((GXutil.strcmp("", AV239TFiconoUpdate)==0)&&(0==AV240TFiconoUpdateOperator)), AV240TFiconoUpdateOperator, AV239TFiconoUpdate, "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGID", httpContext.getMessage( "ID/Código", ""), !(GXutil.strcmp("", AV108TFMigrLegId)==0), (short)(0), AV108TFMigrLegId, "", !(AV109TFMigrLegId_Sels.size()==0), AV109TFMigrLegId_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGCUIL", httpContext.getMessage( "CUIL", ""), !(GXutil.strcmp("", AV43TFMigrLegCUIL)==0), (short)(0), AV43TFMigrLegCUIL, "", !(AV44TFMigrLegCUIL_Sels.size()==0), AV44TFMigrLegCUIL_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGAPELLIDO", httpContext.getMessage( "Apellido", ""), !(GXutil.strcmp("", AV26TFMigrLegApellido)==0), (short)(0), AV26TFMigrLegApellido, "", !(AV27TFMigrLegApellido_Sels.size()==0), AV27TFMigrLegApellido_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGNOMBRE", httpContext.getMessage( "Nombres", ""), !(GXutil.strcmp("", AV29TFMigrLegNombre)==0), (short)(0), AV29TFMigrLegNombre, "", !(AV30TFMigrLegNombre_Sels.size()==0), AV30TFMigrLegNombre_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGMODTRA", httpContext.getMessage( "Relación laboral", ""), !(GXutil.strcmp("", AV281TFMigrLegModTra)==0), (short)(0), AV281TFMigrLegModTra, "", !(AV282TFMigrLegModTra_Sels.size()==0), AV282TFMigrLegModTra_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGTIPOTARIFA", httpContext.getMessage( "Tipo Tarifa", ""), !(GXutil.strcmp("", AV284TFMigrLegTipoTarifa)==0), (short)(0), AV284TFMigrLegTipoTarifa, "", !(AV285TFMigrLegTipoTarifa_Sels.size()==0), AV285TFMigrLegTipoTarifa_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGCLASE", httpContext.getMessage( "Frecuencia de pago", ""), !(GXutil.strcmp("", AV75TFMigrLegClase)==0), (short)(0), AV75TFMigrLegClase, "", !(AV76TFMigrLegClase_Sels.size()==0), AV76TFMigrLegClase_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGFECNAC", httpContext.getMessage( "Fecha de Nacimiento", ""), !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV31TFMigrLegFecNac))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV32TFMigrLegFecNac_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV31TFMigrLegFecNac, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), GXutil.trim( localUtil.dtoc( AV32TFMigrLegFecNac_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGFECINGRESO", httpContext.getMessage( "Fecha de ingreso", ""), !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV60TFMigrLegFecIngreso))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV61TFMigrLegFecIngreso_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV60TFMigrLegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), GXutil.trim( localUtil.dtoc( AV61TFMigrLegFecIngreso_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGSEXO", httpContext.getMessage( "Género", ""), !(GXutil.strcmp("", AV37TFMigrLegSexo)==0), (short)(0), AV37TFMigrLegSexo, "", !(AV38TFMigrLegSexo_Sels.size()==0), AV38TFMigrLegSexo_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGDOMICI", httpContext.getMessage( "Domicilio", ""), !(GXutil.strcmp("", AV49TFMigrLegDomici)==0), (short)(0), AV49TFMigrLegDomici, "", !(AV50TFMigrLegDomici_Sels.size()==0), AV50TFMigrLegDomici_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGCODPOS", httpContext.getMessage( "Código Postal", ""), !(GXutil.strcmp("", AV55TFMigrLegCodPos)==0), (short)(0), AV55TFMigrLegCodPos, "", !(AV56TFMigrLegCodPos_Sels.size()==0), AV56TFMigrLegCodPos_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGTELEFONO", httpContext.getMessage( "Teléfono", ""), !(GXutil.strcmp("", AV58TFMigrLegTelefono)==0), (short)(0), AV58TFMigrLegTelefono, "", !(AV59TFMigrLegTelefono_Sels.size()==0), AV59TFMigrLegTelefono_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGEMAIL", httpContext.getMessage( "Email", ""), !(GXutil.strcmp("", AV52TFMigrLegEmail)==0), (short)(0), AV52TFMigrLegEmail, "", !(AV53TFMigrLegEmail_Sels.size()==0), AV53TFMigrLegEmail_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGESTADOCIVIL", httpContext.getMessage( "Estado Civil", ""), !(GXutil.strcmp("", AV40TFMigrLegEstadoCivil)==0), (short)(0), AV40TFMigrLegEstadoCivil, "", !(AV41TFMigrLegEstadoCivil_Sels.size()==0), AV41TFMigrLegEstadoCivil_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGAREA", httpContext.getMessage( "Área", ""), !(GXutil.strcmp("", AV69TFMigrLegArea)==0), (short)(0), AV69TFMigrLegArea, "", !(AV70TFMigrLegArea_Sels.size()==0), AV70TFMigrLegArea_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGBASICO", httpContext.getMessage( "Sueldo fuera de convenio", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV77TFMigrLegBasico)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV78TFMigrLegBasico_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV77TFMigrLegBasico, 14, 2)), GXutil.trim( GXutil.str( AV78TFMigrLegBasico_To, 14, 2))) ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGCONVENIO", httpContext.getMessage( "Convenio", ""), !(GXutil.strcmp("", AV120TFMigrLegConvenio)==0), (short)(0), AV120TFMigrLegConvenio, "", !(AV121TFMigrLegConvenio_Sels.size()==0), AV121TFMigrLegConvenio_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGOBRASOCIAL", httpContext.getMessage( "Obra Social", ""), !(GXutil.strcmp("", AV137TFMigrLegObraSocial)==0), (short)(0), AV137TFMigrLegObraSocial, "", !(AV138TFMigrLegObraSocial_Sels.size()==0), AV138TFMigrLegObraSocial_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGCBU", httpContext.getMessage( "CBU", ""), !(GXutil.strcmp("", AV114TFMigrLegCBU)==0), (short)(0), AV114TFMigrLegCBU, "", !(AV115TFMigrLegCBU_Sels.size()==0), AV115TFMigrLegCBU_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGMODALIDAD", httpContext.getMessage( "Modalidad", ""), !(GXutil.strcmp("", AV134TFMigrLegModalidad)==0), (short)(0), AV134TFMigrLegModalidad, "", !(AV135TFMigrLegModalidad_Sels.size()==0), AV135TFMigrLegModalidad_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGHORSEM", httpContext.getMessage( "Horas normales semanales", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV270TFMigrLegHorSem)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV271TFMigrLegHorSem_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV270TFMigrLegHorSem, 4, 1)), GXutil.trim( GXutil.str( AV271TFMigrLegHorSem_To, 4, 1))) ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGOBS", httpContext.getMessage( "Observaciones", ""), !(GXutil.strcmp("", AV140TFMigrLegObs)==0), (short)(0), AV140TFMigrLegObs, "", !(AV141TFMigrLegObs_Sels.size()==0), AV141TFMigrLegObs_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      GXv_SdtWWPGridState55[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState55, "TFMIGRLEGSINDICATO", httpContext.getMessage( "Sindicato", ""), !(GXutil.strcmp("", AV92TFMigrLegSindicato)==0), (short)(0), AV92TFMigrLegSindicato, "", !(AV93TFMigrLegSindicato_Sels.size()==0), AV93TFMigrLegSindicato_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState55[0] ;
      if ( ! (GXutil.strcmp("", AV249MenuOpcCod)==0) )
      {
         AV14GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV249MenuOpcCod );
         AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV14GridStateFilterValue, 0);
      }
      AV13GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV13GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV289Pgmname+"GridState", AV13GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV11TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV289Pgmname );
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV10HTTPRequest.getScriptName()+"?"+AV10HTTPRequest.getQuerystring() );
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "importacion_legajo" );
      AV24Session.setValue("TrnContext", AV11TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void S232( )
   {
      /* 'ADD ALL RECORDS' Routine */
      returnInSub = false ;
      AV290Importacion_legajowwds_1_tficonoupdate = AV239TFiconoUpdate ;
      AV291Importacion_legajowwds_2_tficonoupdateoperator = AV240TFiconoUpdateOperator ;
      AV292Importacion_legajowwds_3_tfmigrlegid = AV108TFMigrLegId ;
      AV293Importacion_legajowwds_4_tfmigrlegid_sels = AV109TFMigrLegId_Sels ;
      AV294Importacion_legajowwds_5_tfmigrlegcuil = AV43TFMigrLegCUIL ;
      AV295Importacion_legajowwds_6_tfmigrlegcuil_sels = AV44TFMigrLegCUIL_Sels ;
      AV296Importacion_legajowwds_7_tfmigrlegapellido = AV26TFMigrLegApellido ;
      AV297Importacion_legajowwds_8_tfmigrlegapellido_sels = AV27TFMigrLegApellido_Sels ;
      AV298Importacion_legajowwds_9_tfmigrlegnombre = AV29TFMigrLegNombre ;
      AV299Importacion_legajowwds_10_tfmigrlegnombre_sels = AV30TFMigrLegNombre_Sels ;
      AV300Importacion_legajowwds_11_tfmigrlegmodtra = AV281TFMigrLegModTra ;
      AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels = AV282TFMigrLegModTra_Sels ;
      AV302Importacion_legajowwds_13_tfmigrlegtipotarifa = AV284TFMigrLegTipoTarifa ;
      AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels = AV285TFMigrLegTipoTarifa_Sels ;
      AV304Importacion_legajowwds_15_tfmigrlegclase = AV75TFMigrLegClase ;
      AV305Importacion_legajowwds_16_tfmigrlegclase_sels = AV76TFMigrLegClase_Sels ;
      AV306Importacion_legajowwds_17_tfmigrlegfecnac = AV31TFMigrLegFecNac ;
      AV307Importacion_legajowwds_18_tfmigrlegfecnac_to = AV32TFMigrLegFecNac_To ;
      AV308Importacion_legajowwds_19_tfmigrlegfecingreso = AV60TFMigrLegFecIngreso ;
      AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to = AV61TFMigrLegFecIngreso_To ;
      AV310Importacion_legajowwds_21_tfmigrlegsexo = AV37TFMigrLegSexo ;
      AV311Importacion_legajowwds_22_tfmigrlegsexo_sels = AV38TFMigrLegSexo_Sels ;
      AV312Importacion_legajowwds_23_tfmigrlegdomici = AV49TFMigrLegDomici ;
      AV313Importacion_legajowwds_24_tfmigrlegdomici_sels = AV50TFMigrLegDomici_Sels ;
      AV314Importacion_legajowwds_25_tfmigrlegcodpos = AV55TFMigrLegCodPos ;
      AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels = AV56TFMigrLegCodPos_Sels ;
      AV316Importacion_legajowwds_27_tfmigrlegtelefono = AV58TFMigrLegTelefono ;
      AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels = AV59TFMigrLegTelefono_Sels ;
      AV318Importacion_legajowwds_29_tfmigrlegemail = AV52TFMigrLegEmail ;
      AV319Importacion_legajowwds_30_tfmigrlegemail_sels = AV53TFMigrLegEmail_Sels ;
      AV320Importacion_legajowwds_31_tfmigrlegestadocivil = AV40TFMigrLegEstadoCivil ;
      AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels = AV41TFMigrLegEstadoCivil_Sels ;
      AV322Importacion_legajowwds_33_tfmigrlegarea = AV69TFMigrLegArea ;
      AV323Importacion_legajowwds_34_tfmigrlegarea_sels = AV70TFMigrLegArea_Sels ;
      AV324Importacion_legajowwds_35_tfmigrlegbasico = AV77TFMigrLegBasico ;
      AV325Importacion_legajowwds_36_tfmigrlegbasico_to = AV78TFMigrLegBasico_To ;
      AV326Importacion_legajowwds_37_tfmigrlegconvenio = AV120TFMigrLegConvenio ;
      AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels = AV121TFMigrLegConvenio_Sels ;
      AV328Importacion_legajowwds_39_tfmigrlegobrasocial = AV137TFMigrLegObraSocial ;
      AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels = AV138TFMigrLegObraSocial_Sels ;
      AV330Importacion_legajowwds_41_tfmigrlegcbu = AV114TFMigrLegCBU ;
      AV331Importacion_legajowwds_42_tfmigrlegcbu_sels = AV115TFMigrLegCBU_Sels ;
      AV332Importacion_legajowwds_43_tfmigrlegmodalidad = AV134TFMigrLegModalidad ;
      AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels = AV135TFMigrLegModalidad_Sels ;
      AV334Importacion_legajowwds_45_tfmigrleghorsem = AV270TFMigrLegHorSem ;
      AV335Importacion_legajowwds_46_tfmigrleghorsem_to = AV271TFMigrLegHorSem_To ;
      AV336Importacion_legajowwds_47_tfmigrlegobs = AV140TFMigrLegObs ;
      AV337Importacion_legajowwds_48_tfmigrlegobs_sels = AV141TFMigrLegObs_Sels ;
      AV338Importacion_legajowwds_49_tfmigrlegsindicato = AV92TFMigrLegSindicato ;
      AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels = AV93TFMigrLegSindicato_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A626MigrLegId ,
                                           AV293Importacion_legajowwds_4_tfmigrlegid_sels ,
                                           A597MigrLegCUIL ,
                                           AV295Importacion_legajowwds_6_tfmigrlegcuil_sels ,
                                           A592MigrLegApellido ,
                                           AV297Importacion_legajowwds_8_tfmigrlegapellido_sels ,
                                           A593MigrLegNombre ,
                                           AV299Importacion_legajowwds_10_tfmigrlegnombre_sels ,
                                           A2415MigrLegModTra ,
                                           AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels ,
                                           A2427MigrLegTipoTarifa ,
                                           AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels ,
                                           A607MigrLegClase ,
                                           AV305Importacion_legajowwds_16_tfmigrlegclase_sels ,
                                           A595MigrLegSexo ,
                                           AV311Importacion_legajowwds_22_tfmigrlegsexo_sels ,
                                           A599MigrLegDomici ,
                                           AV313Importacion_legajowwds_24_tfmigrlegdomici_sels ,
                                           A601MigrLegCodPos ,
                                           AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels ,
                                           A602MigrLegTelefono ,
                                           AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels ,
                                           A600MigrLegEmail ,
                                           AV319Importacion_legajowwds_30_tfmigrlegemail_sels ,
                                           A596MigrLegEstadoCivil ,
                                           AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels ,
                                           A605MigrLegArea ,
                                           AV323Importacion_legajowwds_34_tfmigrlegarea_sels ,
                                           A627MigrLegConvenio ,
                                           AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels ,
                                           A614MigrLegObraSocial ,
                                           AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels ,
                                           A621MigrLegCBU ,
                                           AV331Importacion_legajowwds_42_tfmigrlegcbu_sels ,
                                           A617MigrLegModalidad ,
                                           AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels ,
                                           A628MigrLegObs ,
                                           AV337Importacion_legajowwds_48_tfmigrlegobs_sels ,
                                           A613MigrLegSindicato ,
                                           AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels ,
                                           Short.valueOf(AV291Importacion_legajowwds_2_tficonoupdateoperator) ,
                                           Integer.valueOf(AV293Importacion_legajowwds_4_tfmigrlegid_sels.size()) ,
                                           AV292Importacion_legajowwds_3_tfmigrlegid ,
                                           Integer.valueOf(AV295Importacion_legajowwds_6_tfmigrlegcuil_sels.size()) ,
                                           AV294Importacion_legajowwds_5_tfmigrlegcuil ,
                                           Integer.valueOf(AV297Importacion_legajowwds_8_tfmigrlegapellido_sels.size()) ,
                                           AV296Importacion_legajowwds_7_tfmigrlegapellido ,
                                           Integer.valueOf(AV299Importacion_legajowwds_10_tfmigrlegnombre_sels.size()) ,
                                           AV298Importacion_legajowwds_9_tfmigrlegnombre ,
                                           Integer.valueOf(AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels.size()) ,
                                           AV300Importacion_legajowwds_11_tfmigrlegmodtra ,
                                           Integer.valueOf(AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels.size()) ,
                                           AV302Importacion_legajowwds_13_tfmigrlegtipotarifa ,
                                           Integer.valueOf(AV305Importacion_legajowwds_16_tfmigrlegclase_sels.size()) ,
                                           AV304Importacion_legajowwds_15_tfmigrlegclase ,
                                           AV306Importacion_legajowwds_17_tfmigrlegfecnac ,
                                           AV307Importacion_legajowwds_18_tfmigrlegfecnac_to ,
                                           AV308Importacion_legajowwds_19_tfmigrlegfecingreso ,
                                           AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to ,
                                           Integer.valueOf(AV311Importacion_legajowwds_22_tfmigrlegsexo_sels.size()) ,
                                           AV310Importacion_legajowwds_21_tfmigrlegsexo ,
                                           Integer.valueOf(AV313Importacion_legajowwds_24_tfmigrlegdomici_sels.size()) ,
                                           AV312Importacion_legajowwds_23_tfmigrlegdomici ,
                                           Integer.valueOf(AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels.size()) ,
                                           AV314Importacion_legajowwds_25_tfmigrlegcodpos ,
                                           Integer.valueOf(AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels.size()) ,
                                           AV316Importacion_legajowwds_27_tfmigrlegtelefono ,
                                           Integer.valueOf(AV319Importacion_legajowwds_30_tfmigrlegemail_sels.size()) ,
                                           AV318Importacion_legajowwds_29_tfmigrlegemail ,
                                           Integer.valueOf(AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels.size()) ,
                                           AV320Importacion_legajowwds_31_tfmigrlegestadocivil ,
                                           Integer.valueOf(AV323Importacion_legajowwds_34_tfmigrlegarea_sels.size()) ,
                                           AV322Importacion_legajowwds_33_tfmigrlegarea ,
                                           AV324Importacion_legajowwds_35_tfmigrlegbasico ,
                                           AV325Importacion_legajowwds_36_tfmigrlegbasico_to ,
                                           Integer.valueOf(AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels.size()) ,
                                           AV326Importacion_legajowwds_37_tfmigrlegconvenio ,
                                           Integer.valueOf(AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels.size()) ,
                                           AV328Importacion_legajowwds_39_tfmigrlegobrasocial ,
                                           Integer.valueOf(AV331Importacion_legajowwds_42_tfmigrlegcbu_sels.size()) ,
                                           AV330Importacion_legajowwds_41_tfmigrlegcbu ,
                                           Integer.valueOf(AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels.size()) ,
                                           AV332Importacion_legajowwds_43_tfmigrlegmodalidad ,
                                           AV334Importacion_legajowwds_45_tfmigrleghorsem ,
                                           AV335Importacion_legajowwds_46_tfmigrleghorsem_to ,
                                           Integer.valueOf(AV337Importacion_legajowwds_48_tfmigrlegobs_sels.size()) ,
                                           AV336Importacion_legajowwds_47_tfmigrlegobs ,
                                           Integer.valueOf(AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels.size()) ,
                                           AV338Importacion_legajowwds_49_tfmigrlegsindicato ,
                                           A629MigrLegErrores ,
                                           A633MigrLegWarnings ,
                                           A594MigrLegFecNac ,
                                           A603MigrLegFecIngreso ,
                                           A608MigrLegBasico ,
                                           A2275MigrLegHorSem ,
                                           Integer.valueOf(AV104CliCod) ,
                                           Short.valueOf(AV105EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV292Importacion_legajowwds_3_tfmigrlegid = GXutil.padr( GXutil.rtrim( AV292Importacion_legajowwds_3_tfmigrlegid), 20, "%") ;
      lV294Importacion_legajowwds_5_tfmigrlegcuil = GXutil.padr( GXutil.rtrim( AV294Importacion_legajowwds_5_tfmigrlegcuil), 13, "%") ;
      lV296Importacion_legajowwds_7_tfmigrlegapellido = GXutil.concat( GXutil.rtrim( AV296Importacion_legajowwds_7_tfmigrlegapellido), "%", "") ;
      lV298Importacion_legajowwds_9_tfmigrlegnombre = GXutil.concat( GXutil.rtrim( AV298Importacion_legajowwds_9_tfmigrlegnombre), "%", "") ;
      lV300Importacion_legajowwds_11_tfmigrlegmodtra = GXutil.concat( GXutil.rtrim( AV300Importacion_legajowwds_11_tfmigrlegmodtra), "%", "") ;
      lV302Importacion_legajowwds_13_tfmigrlegtipotarifa = GXutil.concat( GXutil.rtrim( AV302Importacion_legajowwds_13_tfmigrlegtipotarifa), "%", "") ;
      lV304Importacion_legajowwds_15_tfmigrlegclase = GXutil.concat( GXutil.rtrim( AV304Importacion_legajowwds_15_tfmigrlegclase), "%", "") ;
      lV310Importacion_legajowwds_21_tfmigrlegsexo = GXutil.padr( GXutil.rtrim( AV310Importacion_legajowwds_21_tfmigrlegsexo), 20, "%") ;
      lV312Importacion_legajowwds_23_tfmigrlegdomici = GXutil.concat( GXutil.rtrim( AV312Importacion_legajowwds_23_tfmigrlegdomici), "%", "") ;
      lV314Importacion_legajowwds_25_tfmigrlegcodpos = GXutil.concat( GXutil.rtrim( AV314Importacion_legajowwds_25_tfmigrlegcodpos), "%", "") ;
      lV316Importacion_legajowwds_27_tfmigrlegtelefono = GXutil.concat( GXutil.rtrim( AV316Importacion_legajowwds_27_tfmigrlegtelefono), "%", "") ;
      lV318Importacion_legajowwds_29_tfmigrlegemail = GXutil.concat( GXutil.rtrim( AV318Importacion_legajowwds_29_tfmigrlegemail), "%", "") ;
      lV320Importacion_legajowwds_31_tfmigrlegestadocivil = GXutil.concat( GXutil.rtrim( AV320Importacion_legajowwds_31_tfmigrlegestadocivil), "%", "") ;
      lV322Importacion_legajowwds_33_tfmigrlegarea = GXutil.concat( GXutil.rtrim( AV322Importacion_legajowwds_33_tfmigrlegarea), "%", "") ;
      lV326Importacion_legajowwds_37_tfmigrlegconvenio = GXutil.concat( GXutil.rtrim( AV326Importacion_legajowwds_37_tfmigrlegconvenio), "%", "") ;
      lV328Importacion_legajowwds_39_tfmigrlegobrasocial = GXutil.concat( GXutil.rtrim( AV328Importacion_legajowwds_39_tfmigrlegobrasocial), "%", "") ;
      lV330Importacion_legajowwds_41_tfmigrlegcbu = GXutil.concat( GXutil.rtrim( AV330Importacion_legajowwds_41_tfmigrlegcbu), "%", "") ;
      lV332Importacion_legajowwds_43_tfmigrlegmodalidad = GXutil.concat( GXutil.rtrim( AV332Importacion_legajowwds_43_tfmigrlegmodalidad), "%", "") ;
      lV336Importacion_legajowwds_47_tfmigrlegobs = GXutil.concat( GXutil.rtrim( AV336Importacion_legajowwds_47_tfmigrlegobs), "%", "") ;
      lV338Importacion_legajowwds_49_tfmigrlegsindicato = GXutil.concat( GXutil.rtrim( AV338Importacion_legajowwds_49_tfmigrlegsindicato), "%", "") ;
      /* Using cursor H00285 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV104CliCod), Short.valueOf(AV105EmpCod), lV292Importacion_legajowwds_3_tfmigrlegid, lV294Importacion_legajowwds_5_tfmigrlegcuil, lV296Importacion_legajowwds_7_tfmigrlegapellido, lV298Importacion_legajowwds_9_tfmigrlegnombre, lV300Importacion_legajowwds_11_tfmigrlegmodtra, lV302Importacion_legajowwds_13_tfmigrlegtipotarifa, lV304Importacion_legajowwds_15_tfmigrlegclase, AV306Importacion_legajowwds_17_tfmigrlegfecnac, AV307Importacion_legajowwds_18_tfmigrlegfecnac_to, AV308Importacion_legajowwds_19_tfmigrlegfecingreso, AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to, lV310Importacion_legajowwds_21_tfmigrlegsexo, lV312Importacion_legajowwds_23_tfmigrlegdomici, lV314Importacion_legajowwds_25_tfmigrlegcodpos, lV316Importacion_legajowwds_27_tfmigrlegtelefono, lV318Importacion_legajowwds_29_tfmigrlegemail, lV320Importacion_legajowwds_31_tfmigrlegestadocivil, lV322Importacion_legajowwds_33_tfmigrlegarea, AV324Importacion_legajowwds_35_tfmigrlegbasico, AV325Importacion_legajowwds_36_tfmigrlegbasico_to, lV326Importacion_legajowwds_37_tfmigrlegconvenio, lV328Importacion_legajowwds_39_tfmigrlegobrasocial, lV330Importacion_legajowwds_41_tfmigrlegcbu, lV332Importacion_legajowwds_43_tfmigrlegmodalidad, AV334Importacion_legajowwds_45_tfmigrleghorsem, AV335Importacion_legajowwds_46_tfmigrleghorsem_to, lV336Importacion_legajowwds_47_tfmigrlegobs, lV338Importacion_legajowwds_49_tfmigrlegsindicato});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A1EmpCod = H00285_A1EmpCod[0] ;
         A3CliCod = H00285_A3CliCod[0] ;
         A633MigrLegWarnings = H00285_A633MigrLegWarnings[0] ;
         A629MigrLegErrores = H00285_A629MigrLegErrores[0] ;
         A613MigrLegSindicato = H00285_A613MigrLegSindicato[0] ;
         A628MigrLegObs = H00285_A628MigrLegObs[0] ;
         A2275MigrLegHorSem = H00285_A2275MigrLegHorSem[0] ;
         A617MigrLegModalidad = H00285_A617MigrLegModalidad[0] ;
         A621MigrLegCBU = H00285_A621MigrLegCBU[0] ;
         A614MigrLegObraSocial = H00285_A614MigrLegObraSocial[0] ;
         A627MigrLegConvenio = H00285_A627MigrLegConvenio[0] ;
         A608MigrLegBasico = H00285_A608MigrLegBasico[0] ;
         A605MigrLegArea = H00285_A605MigrLegArea[0] ;
         A596MigrLegEstadoCivil = H00285_A596MigrLegEstadoCivil[0] ;
         A600MigrLegEmail = H00285_A600MigrLegEmail[0] ;
         A602MigrLegTelefono = H00285_A602MigrLegTelefono[0] ;
         A601MigrLegCodPos = H00285_A601MigrLegCodPos[0] ;
         A599MigrLegDomici = H00285_A599MigrLegDomici[0] ;
         A595MigrLegSexo = H00285_A595MigrLegSexo[0] ;
         A603MigrLegFecIngreso = H00285_A603MigrLegFecIngreso[0] ;
         A594MigrLegFecNac = H00285_A594MigrLegFecNac[0] ;
         A607MigrLegClase = H00285_A607MigrLegClase[0] ;
         A2427MigrLegTipoTarifa = H00285_A2427MigrLegTipoTarifa[0] ;
         A2415MigrLegModTra = H00285_A2415MigrLegModTra[0] ;
         A593MigrLegNombre = H00285_A593MigrLegNombre[0] ;
         A592MigrLegApellido = H00285_A592MigrLegApellido[0] ;
         A597MigrLegCUIL = H00285_A597MigrLegCUIL[0] ;
         A626MigrLegId = H00285_A626MigrLegId[0] ;
         A87MigrLegNumero = H00285_A87MigrLegNumero[0] ;
         AV209CliCodCol.add((int)(A3CliCod), 0);
         AV213EmpCodCol.add((short)(A1EmpCod), 0);
         AV217MigrLegNumeroCol.add((int)(A87MigrLegNumero), 0);
         pr_default.readNext(3);
      }
      pr_default.close(3);
   }

   public void e25282( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV251WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV249MenuOpcCod, GXv_boolean8) ;
         GXv_char54[0] = AV253textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV104CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char54) ;
         importacion_legajoww_impl.this.AV253textoNoMostrara = GXv_char54[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV253textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV249MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void e26282( )
   {
      /* GlobalEvents_Importarlegajosexcel Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV289Pgmname, httpContext.getMessage( "se disparó GlobalEvents.importarLegajosExcel ", "")+GXutil.trim( AV259mensajeTexto)) ;
      if ( GXutil.strSearch( AV259mensajeTexto, httpContext.getMessage( "OK", ""), 1) != 0 )
      {
         new web.alert(remoteHandle, context).execute( "success", httpContext.getMessage( "El excel se importó existosamente!", "")) ;
      }
      else
      {
         AV261error = GXutil.strReplace( AV259mensajeTexto, httpContext.getMessage( "IMPORTARLEGAJO_EXCEL Error ", ""), "") ;
         new web.alert(remoteHandle, context).execute( "error", AV261error) ;
      }
      lblJs_Caption = httpContext.getMessage( "<script>console.log(\"script stop\");detenerAnimacion(\"", "")+bttBtnimportexcel_Internalname+httpContext.getMessage( "\", \"\");</script>", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblJs_Internalname, "Caption", lblJs_Caption, true);
      gxgrgrid_refresh( subGrid_Rows, AV269ManageFiltersExecutionStep, AV22ColumnsSelector, AV289Pgmname, AV210CliCodJson, AV214EmpCodJson, AV218MigrLegNumeroJson, AV249MenuOpcCod, AV13GridState, AV239TFiconoUpdate, AV240TFiconoUpdateOperator, AV108TFMigrLegId, AV109TFMigrLegId_Sels, AV43TFMigrLegCUIL, AV44TFMigrLegCUIL_Sels, AV26TFMigrLegApellido, AV27TFMigrLegApellido_Sels, AV29TFMigrLegNombre, AV30TFMigrLegNombre_Sels, AV281TFMigrLegModTra, AV282TFMigrLegModTra_Sels, AV284TFMigrLegTipoTarifa, AV285TFMigrLegTipoTarifa_Sels, AV75TFMigrLegClase, AV76TFMigrLegClase_Sels, AV31TFMigrLegFecNac, AV32TFMigrLegFecNac_To, AV60TFMigrLegFecIngreso, AV61TFMigrLegFecIngreso_To, AV37TFMigrLegSexo, AV38TFMigrLegSexo_Sels, AV49TFMigrLegDomici, AV50TFMigrLegDomici_Sels, AV55TFMigrLegCodPos, AV56TFMigrLegCodPos_Sels, AV58TFMigrLegTelefono, AV59TFMigrLegTelefono_Sels, AV52TFMigrLegEmail, AV53TFMigrLegEmail_Sels, AV40TFMigrLegEstadoCivil, AV41TFMigrLegEstadoCivil_Sels, AV69TFMigrLegArea, AV70TFMigrLegArea_Sels, AV77TFMigrLegBasico, AV78TFMigrLegBasico_To, AV120TFMigrLegConvenio, AV121TFMigrLegConvenio_Sels, AV137TFMigrLegObraSocial, AV138TFMigrLegObraSocial_Sels, AV114TFMigrLegCBU, AV115TFMigrLegCBU_Sels, AV134TFMigrLegModalidad, AV135TFMigrLegModalidad_Sels, AV270TFMigrLegHorSem, AV271TFMigrLegHorSem_To, AV140TFMigrLegObs, AV141TFMigrLegObs_Sels, AV92TFMigrLegSindicato, AV93TFMigrLegSindicato_Sels, AV15OrderedBy, AV16OrderedDsc, AV104CliCod, AV100IsAuthorized_Update, AV102IsAuthorized_Delete, AV208i, AV209CliCodCol, AV212CliCodToFind, AV213EmpCodCol, AV216EmpCodToFind, AV217MigrLegNumeroCol, AV220MigrLegNumeroToFind, AV105EmpCod, AV251WelcomeMessage_NoMostrarMas, AV221SelectAll) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV209CliCodCol", AV209CliCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV213EmpCodCol", AV213EmpCodCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV217MigrLegNumeroCol", AV217MigrLegNumeroCol);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV267ManageFiltersData", AV267ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GridState", AV13GridState);
   }

   public void wb_table7_207_282( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTableimportexcel_modal_Internalname, tblTableimportexcel_modal_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucImportexcel_modal.setProperty("Width", Importexcel_modal_Width);
         ucImportexcel_modal.setProperty("Title", Importexcel_modal_Title);
         ucImportexcel_modal.setProperty("ConfirmType", Importexcel_modal_Confirmtype);
         ucImportexcel_modal.setProperty("BodyType", Importexcel_modal_Bodytype);
         ucImportexcel_modal.render(context, "dvelop.gxbootstrap.confirmpanel", Importexcel_modal_Internalname, "IMPORTEXCEL_MODALContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"IMPORTEXCEL_MODALContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_207_282e( true) ;
      }
      else
      {
         wb_table7_207_282e( false) ;
      }
   }

   public void wb_table6_202_282( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_eliminar_Internalname, tblTabledvelop_confirmpanel_eliminar_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_eliminar.setProperty("Title", Dvelop_confirmpanel_eliminar_Title);
         ucDvelop_confirmpanel_eliminar.setProperty("ConfirmationText", Dvelop_confirmpanel_eliminar_Confirmationtext);
         ucDvelop_confirmpanel_eliminar.setProperty("YesButtonCaption", Dvelop_confirmpanel_eliminar_Yesbuttoncaption);
         ucDvelop_confirmpanel_eliminar.setProperty("NoButtonCaption", Dvelop_confirmpanel_eliminar_Nobuttoncaption);
         ucDvelop_confirmpanel_eliminar.setProperty("CancelButtonCaption", Dvelop_confirmpanel_eliminar_Cancelbuttoncaption);
         ucDvelop_confirmpanel_eliminar.setProperty("YesButtonPosition", Dvelop_confirmpanel_eliminar_Yesbuttonposition);
         ucDvelop_confirmpanel_eliminar.setProperty("ConfirmType", Dvelop_confirmpanel_eliminar_Confirmtype);
         ucDvelop_confirmpanel_eliminar.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_eliminar_Internalname, "DVELOP_CONFIRMPANEL_ELIMINARContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVELOP_CONFIRMPANEL_ELIMINARContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_202_282e( true) ;
      }
      else
      {
         wb_table6_202_282e( false) ;
      }
   }

   public void wb_table5_197_282( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_btneliminartodos_Internalname, tblTabledvelop_confirmpanel_btneliminartodos_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_btneliminartodos.setProperty("Title", Dvelop_confirmpanel_btneliminartodos_Title);
         ucDvelop_confirmpanel_btneliminartodos.setProperty("ConfirmationText", Dvelop_confirmpanel_btneliminartodos_Confirmationtext);
         ucDvelop_confirmpanel_btneliminartodos.setProperty("YesButtonCaption", Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption);
         ucDvelop_confirmpanel_btneliminartodos.setProperty("NoButtonCaption", Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption);
         ucDvelop_confirmpanel_btneliminartodos.setProperty("CancelButtonCaption", Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption);
         ucDvelop_confirmpanel_btneliminartodos.setProperty("YesButtonPosition", Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition);
         ucDvelop_confirmpanel_btneliminartodos.setProperty("ConfirmType", Dvelop_confirmpanel_btneliminartodos_Confirmtype);
         ucDvelop_confirmpanel_btneliminartodos.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_btneliminartodos_Internalname, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOSContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_197_282e( true) ;
      }
      else
      {
         wb_table5_197_282e( false) ;
      }
   }

   public void wb_table4_192_282( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_btnimportarlegajosalsistema_Internalname, tblTabledvelop_confirmpanel_btnimportarlegajosalsistema_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_btnimportarlegajosalsistema.setProperty("Title", Dvelop_confirmpanel_btnimportarlegajosalsistema_Title);
         ucDvelop_confirmpanel_btnimportarlegajosalsistema.setProperty("ConfirmationText", Dvelop_confirmpanel_btnimportarlegajosalsistema_Confirmationtext);
         ucDvelop_confirmpanel_btnimportarlegajosalsistema.setProperty("YesButtonCaption", Dvelop_confirmpanel_btnimportarlegajosalsistema_Yesbuttoncaption);
         ucDvelop_confirmpanel_btnimportarlegajosalsistema.setProperty("NoButtonCaption", Dvelop_confirmpanel_btnimportarlegajosalsistema_Nobuttoncaption);
         ucDvelop_confirmpanel_btnimportarlegajosalsistema.setProperty("CancelButtonCaption", Dvelop_confirmpanel_btnimportarlegajosalsistema_Cancelbuttoncaption);
         ucDvelop_confirmpanel_btnimportarlegajosalsistema.setProperty("YesButtonPosition", Dvelop_confirmpanel_btnimportarlegajosalsistema_Yesbuttonposition);
         ucDvelop_confirmpanel_btnimportarlegajosalsistema.setProperty("ConfirmType", Dvelop_confirmpanel_btnimportarlegajosalsistema_Confirmtype);
         ucDvelop_confirmpanel_btnimportarlegajosalsistema.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_btnimportarlegajosalsistema_Internalname, "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMAContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMAContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_192_282e( true) ;
      }
      else
      {
         wb_table4_192_282e( false) ;
      }
   }

   public void wb_table3_180_282( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedinnewwindow1_Internalname, tblTablemergedinnewwindow1_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblJs_Internalname, lblJs_Caption, "", "", lblJs_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_importacion_legajoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_180_282e( true) ;
      }
      else
      {
         wb_table3_180_282e( false) ;
      }
   }

   public void wb_table2_170_282( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedbtnimportarlegajosalsistema_Internalname, tblTablemergedbtnimportarlegajosalsistema_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 173,'',false,'',0)\"" ;
         ClassString = "Button WWPBtnNeedMultiRowSelection" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnimportarlegajosalsistema_Internalname, "gx.evt.setGridEvt("+GXutil.str( 97, 2, 0)+","+"null"+");", httpContext.getMessage( "Confirmar Importación de Legajos Seleccionados", ""), bttBtnimportarlegajosalsistema_Jsonclick, 5, httpContext.getMessage( "Confirmar Importación de Legajos Seleccionados", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOIMPORTARLEGAJOSALSISTEMA\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_legajoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 175,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtneliminartodos_Internalname, "gx.evt.setGridEvt("+GXutil.str( 97, 2, 0)+","+"null"+");", httpContext.getMessage( "Eliminar todos", ""), bttBtneliminartodos_Jsonclick, 5, httpContext.getMessage( "Eliminar todos", ""), "", StyleString, ClassString, bttBtneliminartodos_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOELIMINARTODOS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_legajoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 177,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnimportartodos_Internalname, "gx.evt.setGridEvt("+GXutil.str( 97, 2, 0)+","+"null"+");", httpContext.getMessage( "Importar todos", ""), bttBtnimportartodos_Jsonclick, 5, httpContext.getMessage( "Importar todos", ""), "", StyleString, ClassString, bttBtnimportartodos_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOIMPORTARTODOS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_legajoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_170_282e( true) ;
      }
      else
      {
         wb_table2_170_282e( false) ;
      }
   }

   public void wb_table1_9_282( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table8_12_282( true) ;
      }
      else
      {
         wb_table8_12_282( false) ;
      }
      return  ;
   }

   public void wb_table8_12_282e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_282e( true) ;
      }
      else
      {
         wb_table1_9_282e( false) ;
      }
   }

   public void wb_table8_12_282( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e32281_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_importacion_legajoWW.htm");
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
         AV257WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV257WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV288Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV257WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV257WelcomeMessage_Foto)==0) ? AV288Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV257WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV257WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_importacion_legajoWW.htm");
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
         wb_table9_30_282( true) ;
      }
      else
      {
         wb_table9_30_282( false) ;
      }
      return  ;
   }

   public void wb_table9_30_282e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table10_35_282( true) ;
      }
      else
      {
         wb_table10_35_282( false) ;
      }
      return  ;
   }

   public void wb_table10_35_282e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_97_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV251WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoWW.htm");
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
         wb_table11_54_282( true) ;
      }
      else
      {
         wb_table11_54_282( false) ;
      }
      return  ;
   }

   public void wb_table11_54_282e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table12_63_282( true) ;
      }
      else
      {
         wb_table12_63_282( false) ;
      }
      return  ;
   }

   public void wb_table12_63_282e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='GridFixedTitles HasGridEmpowerer'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol97( ) ;
      }
      if ( wbEnd == 97 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_97 = (int)(nGXsfl_97_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV96GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV97GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV98GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divCell_grid_dwc_Internalname, 1, 0, "px", 0, "px", divCell_grid_dwc_Class, "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, "W0164"+"", GXutil.rtrim( WebComp_Grid_dwc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0164"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( bGXsfl_97_Refreshing )
            {
               if ( GXutil.len( WebComp_Grid_dwc_Component) != 0 )
               {
                  if ( GXutil.strcmp(GXutil.lower( OldGrid_dwc), GXutil.lower( WebComp_Grid_dwc_Component)) != 0 )
                  {
                     httpContext.ajax_rspStartCmp("gxHTMLWrpW0164"+"");
                  }
                  WebComp_Grid_dwc.componentdraw();
                  if ( GXutil.strcmp(GXutil.lower( OldGrid_dwc), GXutil.lower( WebComp_Grid_dwc_Component)) != 0 )
                  {
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table8_12_282e( true) ;
      }
      else
      {
         wb_table8_12_282e( false) ;
      }
   }

   public void wb_table12_63_282( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablefiltros_Internalname, tblTablefiltros_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtngenerartemplate_Internalname, "gx.evt.setGridEvt("+GXutil.str( 97, 2, 0)+","+"null"+");", httpContext.getMessage( "Descargar Template", ""), bttBtngenerartemplate_Jsonclick, 5, httpContext.getMessage( "Descargar Template", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOGENERARTEMPLATE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_legajoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnimportexcel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 97, 2, 0)+","+"null"+");", httpContext.getMessage( "Importar legajos desde archivo", ""), bttBtnimportexcel_Jsonclick, 7, httpContext.getMessage( "WWP_ImportExcelTooltip", ""), "", StyleString, ClassString, bttBtnimportexcel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e33281_client"+"'", TempTags, "", 2, "HLP_importacion_legajoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV267ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("IconType", Ddo_gridcolumnsselector_Icontype);
         ucDdo_gridcolumnsselector.setProperty("Icon", Ddo_gridcolumnsselector_Icon);
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV94DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV22ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_importacion_legajoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table13_86_282( true) ;
      }
      else
      {
         wb_table13_86_282( false) ;
      }
      return  ;
   }

   public void wb_table13_86_282e( boolean wbgen )
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
         wb_table12_63_282e( true) ;
      }
      else
      {
         wb_table12_63_282e( false) ;
      }
   }

   public void wb_table13_86_282( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table13_86_282e( true) ;
      }
      else
      {
         wb_table13_86_282e( false) ;
      }
   }

   public void wb_table11_54_282( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_importacion_legajoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table11_54_282e( true) ;
      }
      else
      {
         wb_table11_54_282e( false) ;
      }
   }

   public void wb_table10_35_282( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table10_35_282e( true) ;
      }
      else
      {
         wb_table10_35_282e( false) ;
      }
   }

   public void wb_table9_30_282( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table9_30_282e( true) ;
      }
      else
      {
         wb_table9_30_282e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV249MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV249MenuOpcCod", AV249MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV249MenuOpcCod, ""))));
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
      pa282( ) ;
      ws282( ) ;
      we282( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Shared/daterangepicker/daterangepicker.css", "");
      httpContext.AddStyleSheetFile("DVelop/Shared/daterangepicker/daterangepicker.css", "");
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Grid_dwc == null ) )
      {
         if ( GXutil.len( WebComp_Grid_dwc_Component) != 0 )
         {
            WebComp_Grid_dwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Wwpaux_wc == null ) )
      {
         if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
         {
            WebComp_Wwpaux_wc.componentthemes();
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713414728", true, true);
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
      httpContext.AddJavascriptSource("importacion_legajoww.js", "?20251713414730", false, true);
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
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_972( )
   {
      chkavSelected.setInternalname( "vSELECTED_"+sGXsfl_97_idx );
      edtavIconoupdatewithtags_Internalname = "vICONOUPDATEWITHTAGS_"+sGXsfl_97_idx ;
      edtavIconoupdate_Internalname = "vICONOUPDATE_"+sGXsfl_97_idx ;
      edtavEliminar_Internalname = "vELIMINAR_"+sGXsfl_97_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_97_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_97_idx ;
      edtMigrLegNumero_Internalname = "MIGRLEGNUMERO_"+sGXsfl_97_idx ;
      edtMigrLegId_Internalname = "MIGRLEGID_"+sGXsfl_97_idx ;
      edtMigrLegCUIL_Internalname = "MIGRLEGCUIL_"+sGXsfl_97_idx ;
      edtMigrLegApellido_Internalname = "MIGRLEGAPELLIDO_"+sGXsfl_97_idx ;
      edtMigrLegNombre_Internalname = "MIGRLEGNOMBRE_"+sGXsfl_97_idx ;
      edtMigrLegModTra_Internalname = "MIGRLEGMODTRA_"+sGXsfl_97_idx ;
      edtMigrLegTipoTarifa_Internalname = "MIGRLEGTIPOTARIFA_"+sGXsfl_97_idx ;
      edtMigrLegClase_Internalname = "MIGRLEGCLASE_"+sGXsfl_97_idx ;
      edtMigrLegFecNac_Internalname = "MIGRLEGFECNAC_"+sGXsfl_97_idx ;
      edtMigrLegFecIngreso_Internalname = "MIGRLEGFECINGRESO_"+sGXsfl_97_idx ;
      edtMigrLegSexo_Internalname = "MIGRLEGSEXO_"+sGXsfl_97_idx ;
      edtMigrLegZona_Internalname = "MIGRLEGZONA_"+sGXsfl_97_idx ;
      edtMigrLegDomici_Internalname = "MIGRLEGDOMICI_"+sGXsfl_97_idx ;
      edtMigrLegCodPos_Internalname = "MIGRLEGCODPOS_"+sGXsfl_97_idx ;
      edtMigrLegTelefono_Internalname = "MIGRLEGTELEFONO_"+sGXsfl_97_idx ;
      edtMigrLegEmail_Internalname = "MIGRLEGEMAIL_"+sGXsfl_97_idx ;
      edtMigrLegEstadoCivil_Internalname = "MIGRLEGESTADOCIVIL_"+sGXsfl_97_idx ;
      edtMigrLegDiscapacidad_Internalname = "MIGRLEGDISCAPACIDAD_"+sGXsfl_97_idx ;
      edtMigrLegArea_Internalname = "MIGRLEGAREA_"+sGXsfl_97_idx ;
      edtMigrLegBasico_Internalname = "MIGRLEGBASICO_"+sGXsfl_97_idx ;
      edtMigrLegConvenio_Internalname = "MIGRLEGCONVENIO_"+sGXsfl_97_idx ;
      edtavMigrlegcategoria_var_Internalname = "vMIGRLEGCATEGORIA_VAR_"+sGXsfl_97_idx ;
      edtMigrLegCategoria_Internalname = "MIGRLEGCATEGORIA_"+sGXsfl_97_idx ;
      edtMigrLegLugarDePago_Internalname = "MIGRLEGLUGARDEPAGO_"+sGXsfl_97_idx ;
      edtMigrLegBanco_Internalname = "MIGRLEGBANCO_"+sGXsfl_97_idx ;
      edtMigrLegObraSocial_Internalname = "MIGRLEGOBRASOCIAL_"+sGXsfl_97_idx ;
      edtMigrLegBanSuc_Internalname = "MIGRLEGBANSUC_"+sGXsfl_97_idx ;
      edtMigrLegBanTipCuen_Internalname = "MIGRLEGBANTIPCUEN_"+sGXsfl_97_idx ;
      edtMigrLegCuentaBanc_Internalname = "MIGRLEGCUENTABANC_"+sGXsfl_97_idx ;
      edtMigrLegFormaPago_Internalname = "MIGRLEGFORMAPAGO_"+sGXsfl_97_idx ;
      edtMigrLegCBU_Internalname = "MIGRLEGCBU_"+sGXsfl_97_idx ;
      edtMigrLegModalidad_Internalname = "MIGRLEGMODALIDAD_"+sGXsfl_97_idx ;
      edtMigrLegHorSem_Internalname = "MIGRLEGHORSEM_"+sGXsfl_97_idx ;
      edtMigrLegActividad_Internalname = "MIGRLEGACTIVIDAD_"+sGXsfl_97_idx ;
      edtMigrLegSituacionRevista_Internalname = "MIGRLEGSITUACIONREVISTA_"+sGXsfl_97_idx ;
      edtMigrLegCondicion_Internalname = "MIGRLEGCONDICION_"+sGXsfl_97_idx ;
      edtMigrLegSiniestrado_Internalname = "MIGRLEGSINIESTRADO_"+sGXsfl_97_idx ;
      edtMigrLegSCVO_Internalname = "MIGRLEGSCVO_"+sGXsfl_97_idx ;
      edtMigrLegPlanMedico_Internalname = "MIGRLEGPLANMEDICO_"+sGXsfl_97_idx ;
      edtMigrTieneConyuge_Internalname = "MIGRTIENECONYUGE_"+sGXsfl_97_idx ;
      edtMigrCantidadHijos_Internalname = "MIGRCANTIDADHIJOS_"+sGXsfl_97_idx ;
      edtMigrLegObs_Internalname = "MIGRLEGOBS_"+sGXsfl_97_idx ;
      edtMigrPeriodo_Internalname = "MIGRPERIODO_"+sGXsfl_97_idx ;
      edtMigrSueldos_Internalname = "MIGRSUELDOS_"+sGXsfl_97_idx ;
      edtMigrPuesto_Internalname = "MIGRPUESTO_"+sGXsfl_97_idx ;
      edtMigrLegActLabClas_Internalname = "MIGRLEGACTLABCLAS_"+sGXsfl_97_idx ;
      edtMigrLegPueAfip_Internalname = "MIGRLEGPUEAFIP_"+sGXsfl_97_idx ;
      edtMigrLegSindicato_Internalname = "MIGRLEGSINDICATO_"+sGXsfl_97_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_97_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_97_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_97_idx ;
      edtavDetailwebcomponent_Internalname = "vDETAILWEBCOMPONENT_"+sGXsfl_97_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_97_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_97_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_97_idx ;
   }

   public void subsflControlProps_fel_972( )
   {
      chkavSelected.setInternalname( "vSELECTED_"+sGXsfl_97_fel_idx );
      edtavIconoupdatewithtags_Internalname = "vICONOUPDATEWITHTAGS_"+sGXsfl_97_fel_idx ;
      edtavIconoupdate_Internalname = "vICONOUPDATE_"+sGXsfl_97_fel_idx ;
      edtavEliminar_Internalname = "vELIMINAR_"+sGXsfl_97_fel_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_97_fel_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_97_fel_idx ;
      edtMigrLegNumero_Internalname = "MIGRLEGNUMERO_"+sGXsfl_97_fel_idx ;
      edtMigrLegId_Internalname = "MIGRLEGID_"+sGXsfl_97_fel_idx ;
      edtMigrLegCUIL_Internalname = "MIGRLEGCUIL_"+sGXsfl_97_fel_idx ;
      edtMigrLegApellido_Internalname = "MIGRLEGAPELLIDO_"+sGXsfl_97_fel_idx ;
      edtMigrLegNombre_Internalname = "MIGRLEGNOMBRE_"+sGXsfl_97_fel_idx ;
      edtMigrLegModTra_Internalname = "MIGRLEGMODTRA_"+sGXsfl_97_fel_idx ;
      edtMigrLegTipoTarifa_Internalname = "MIGRLEGTIPOTARIFA_"+sGXsfl_97_fel_idx ;
      edtMigrLegClase_Internalname = "MIGRLEGCLASE_"+sGXsfl_97_fel_idx ;
      edtMigrLegFecNac_Internalname = "MIGRLEGFECNAC_"+sGXsfl_97_fel_idx ;
      edtMigrLegFecIngreso_Internalname = "MIGRLEGFECINGRESO_"+sGXsfl_97_fel_idx ;
      edtMigrLegSexo_Internalname = "MIGRLEGSEXO_"+sGXsfl_97_fel_idx ;
      edtMigrLegZona_Internalname = "MIGRLEGZONA_"+sGXsfl_97_fel_idx ;
      edtMigrLegDomici_Internalname = "MIGRLEGDOMICI_"+sGXsfl_97_fel_idx ;
      edtMigrLegCodPos_Internalname = "MIGRLEGCODPOS_"+sGXsfl_97_fel_idx ;
      edtMigrLegTelefono_Internalname = "MIGRLEGTELEFONO_"+sGXsfl_97_fel_idx ;
      edtMigrLegEmail_Internalname = "MIGRLEGEMAIL_"+sGXsfl_97_fel_idx ;
      edtMigrLegEstadoCivil_Internalname = "MIGRLEGESTADOCIVIL_"+sGXsfl_97_fel_idx ;
      edtMigrLegDiscapacidad_Internalname = "MIGRLEGDISCAPACIDAD_"+sGXsfl_97_fel_idx ;
      edtMigrLegArea_Internalname = "MIGRLEGAREA_"+sGXsfl_97_fel_idx ;
      edtMigrLegBasico_Internalname = "MIGRLEGBASICO_"+sGXsfl_97_fel_idx ;
      edtMigrLegConvenio_Internalname = "MIGRLEGCONVENIO_"+sGXsfl_97_fel_idx ;
      edtavMigrlegcategoria_var_Internalname = "vMIGRLEGCATEGORIA_VAR_"+sGXsfl_97_fel_idx ;
      edtMigrLegCategoria_Internalname = "MIGRLEGCATEGORIA_"+sGXsfl_97_fel_idx ;
      edtMigrLegLugarDePago_Internalname = "MIGRLEGLUGARDEPAGO_"+sGXsfl_97_fel_idx ;
      edtMigrLegBanco_Internalname = "MIGRLEGBANCO_"+sGXsfl_97_fel_idx ;
      edtMigrLegObraSocial_Internalname = "MIGRLEGOBRASOCIAL_"+sGXsfl_97_fel_idx ;
      edtMigrLegBanSuc_Internalname = "MIGRLEGBANSUC_"+sGXsfl_97_fel_idx ;
      edtMigrLegBanTipCuen_Internalname = "MIGRLEGBANTIPCUEN_"+sGXsfl_97_fel_idx ;
      edtMigrLegCuentaBanc_Internalname = "MIGRLEGCUENTABANC_"+sGXsfl_97_fel_idx ;
      edtMigrLegFormaPago_Internalname = "MIGRLEGFORMAPAGO_"+sGXsfl_97_fel_idx ;
      edtMigrLegCBU_Internalname = "MIGRLEGCBU_"+sGXsfl_97_fel_idx ;
      edtMigrLegModalidad_Internalname = "MIGRLEGMODALIDAD_"+sGXsfl_97_fel_idx ;
      edtMigrLegHorSem_Internalname = "MIGRLEGHORSEM_"+sGXsfl_97_fel_idx ;
      edtMigrLegActividad_Internalname = "MIGRLEGACTIVIDAD_"+sGXsfl_97_fel_idx ;
      edtMigrLegSituacionRevista_Internalname = "MIGRLEGSITUACIONREVISTA_"+sGXsfl_97_fel_idx ;
      edtMigrLegCondicion_Internalname = "MIGRLEGCONDICION_"+sGXsfl_97_fel_idx ;
      edtMigrLegSiniestrado_Internalname = "MIGRLEGSINIESTRADO_"+sGXsfl_97_fel_idx ;
      edtMigrLegSCVO_Internalname = "MIGRLEGSCVO_"+sGXsfl_97_fel_idx ;
      edtMigrLegPlanMedico_Internalname = "MIGRLEGPLANMEDICO_"+sGXsfl_97_fel_idx ;
      edtMigrTieneConyuge_Internalname = "MIGRTIENECONYUGE_"+sGXsfl_97_fel_idx ;
      edtMigrCantidadHijos_Internalname = "MIGRCANTIDADHIJOS_"+sGXsfl_97_fel_idx ;
      edtMigrLegObs_Internalname = "MIGRLEGOBS_"+sGXsfl_97_fel_idx ;
      edtMigrPeriodo_Internalname = "MIGRPERIODO_"+sGXsfl_97_fel_idx ;
      edtMigrSueldos_Internalname = "MIGRSUELDOS_"+sGXsfl_97_fel_idx ;
      edtMigrPuesto_Internalname = "MIGRPUESTO_"+sGXsfl_97_fel_idx ;
      edtMigrLegActLabClas_Internalname = "MIGRLEGACTLABCLAS_"+sGXsfl_97_fel_idx ;
      edtMigrLegPueAfip_Internalname = "MIGRLEGPUEAFIP_"+sGXsfl_97_fel_idx ;
      edtMigrLegSindicato_Internalname = "MIGRLEGSINDICATO_"+sGXsfl_97_fel_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_97_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_97_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_97_fel_idx ;
      edtavDetailwebcomponent_Internalname = "vDETAILWEBCOMPONENT_"+sGXsfl_97_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_97_fel_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_97_fel_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_97_fel_idx ;
   }

   public void sendrow_972( )
   {
      subsflControlProps_972( ) ;
      wb280( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_97_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_97_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_97_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Check box */
         TempTags = " " + ((chkavSelected.getEnabled()!=0)&&(chkavSelected.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 98,'',false,'"+sGXsfl_97_idx+"',97)\"" : " ") ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vSELECTED_" + sGXsfl_97_idx ;
         chkavSelected.setName( GXCCtl );
         chkavSelected.setWebtags( "" );
         chkavSelected.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavSelected.getInternalname(), "TitleCaption", chkavSelected.getCaption(), !bGXsfl_97_Refreshing);
         chkavSelected.setCheckedValue( "false" );
         AV205Selected = GXutil.strtobool( GXutil.booltostr( AV205Selected)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavSelected.getInternalname(), AV205Selected);
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavSelected.getInternalname(),GXutil.booltostr( AV205Selected),"","",Integer.valueOf(-1),Integer.valueOf(chkavSelected.getEnabled()),"true","",StyleString,ClassString,"","",TempTags+((chkavSelected.getEnabled()!=0)&&(chkavSelected.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,98);\"" : " ")});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavIconoupdatewithtags_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavIconoupdatewithtags_Enabled!=0)&&(edtavIconoupdatewithtags_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 99,'',false,'"+sGXsfl_97_idx+"',97)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavIconoupdatewithtags_Internalname,AV238iconoUpdateWithTags,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavIconoupdatewithtags_Enabled!=0)&&(edtavIconoupdatewithtags_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,99);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavIconoupdatewithtags_Link,"","","",edtavIconoupdatewithtags_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavIconoupdatewithtags_Visible),Integer.valueOf(edtavIconoupdatewithtags_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavIconoupdate_Enabled!=0)&&(edtavIconoupdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 100,'',false,'"+sGXsfl_97_idx+"',97)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavIconoupdate_Internalname,GXutil.rtrim( AV237iconoUpdate),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavIconoupdate_Enabled!=0)&&(edtavIconoupdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,100);\"" : " "),"'"+""+"'"+",false,"+"'"+"e34282_client"+"'","","","","",edtavIconoupdate_Jsonclick,Integer.valueOf(7),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavIconoupdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEliminar_Enabled!=0)&&(edtavEliminar_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 101,'',false,'"+sGXsfl_97_idx+"',97)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminar_Internalname,GXutil.rtrim( AV233Eliminar),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEliminar_Enabled!=0)&&(edtavEliminar_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,101);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVELIMINAR.CLICK."+sGXsfl_97_idx+"'","","","","",edtavEliminar_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavEliminar_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A87MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A87MigrLegNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegId_Internalname,GXutil.rtrim( A626MigrLegId),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMigrLegId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegCUIL_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegCUIL_Internalname,GXutil.rtrim( A597MigrLegCUIL),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegCUIL_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMigrLegCUIL_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Cuit","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegApellido_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegApellido_Internalname,A592MigrLegApellido,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegApellido_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMigrLegApellido_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegNombre_Internalname,A593MigrLegNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMigrLegNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegModTra_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegModTra_Internalname,A2415MigrLegModTra,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegModTra_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMigrLegModTra_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegTipoTarifa_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegTipoTarifa_Internalname,A2427MigrLegTipoTarifa,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegTipoTarifa_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMigrLegTipoTarifa_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegClase_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegClase_Internalname,A607MigrLegClase,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegClase_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMigrLegClase_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtMigrLegFecNac_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFecNac_Internalname,localUtil.format(A594MigrLegFecNac, "99/99/9999"),localUtil.format( A594MigrLegFecNac, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFecNac_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMigrLegFecNac_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtMigrLegFecIngreso_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFecIngreso_Internalname,localUtil.format(A603MigrLegFecIngreso, "99/99/9999"),localUtil.format( A603MigrLegFecIngreso, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFecIngreso_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMigrLegFecIngreso_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegSexo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegSexo_Internalname,GXutil.rtrim( A595MigrLegSexo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegSexo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMigrLegSexo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegZona_Internalname,A620MigrLegZona,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegZona_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegDomici_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegDomici_Internalname,A599MigrLegDomici,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegDomici_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMigrLegDomici_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"VarcharTextArea","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegCodPos_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegCodPos_Internalname,A601MigrLegCodPos,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegCodPos_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMigrLegCodPos_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegTelefono_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegTelefono_Internalname,A602MigrLegTelefono,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegTelefono_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMigrLegTelefono_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegEmail_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegEmail_Internalname,A600MigrLegEmail,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegEmail_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMigrLegEmail_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegEstadoCivil_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegEstadoCivil_Internalname,A596MigrLegEstadoCivil,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegEstadoCivil_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMigrLegEstadoCivil_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegDiscapacidad_Internalname,GXutil.rtrim( A598MigrLegDiscapacidad),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegDiscapacidad_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegArea_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegArea_Internalname,A605MigrLegArea,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegArea_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMigrLegArea_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtMigrLegBasico_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegBasico_Internalname,GXutil.ltrim( localUtil.ntoc( A608MigrLegBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A608MigrLegBasico, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","",edtMigrLegBasico_Tooltiptext,"",edtMigrLegBasico_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtMigrLegBasico_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegConvenio_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegConvenio_Internalname,A627MigrLegConvenio,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegConvenio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMigrLegConvenio_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavMigrlegcategoria_var_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavMigrlegcategoria_var_Enabled!=0)&&(edtavMigrlegcategoria_var_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 125,'',false,'"+sGXsfl_97_idx+"',97)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavMigrlegcategoria_var_Internalname,AV242MigrLegCategoria_var,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavMigrlegcategoria_var_Enabled!=0)&&(edtavMigrlegcategoria_var_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,125);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavMigrlegcategoria_var_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavMigrlegcategoria_var_Visible),Integer.valueOf(edtavMigrlegcategoria_var_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegCategoria_Internalname,A604MigrLegCategoria,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegCategoria_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegLugarDePago_Internalname,A606MigrLegLugarDePago,GXutil.rtrim( localUtil.format( A606MigrLegLugarDePago, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegLugarDePago_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionCorta","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegBanco_Internalname,A610MigrLegBanco,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegBanco_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegObraSocial_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegObraSocial_Internalname,A614MigrLegObraSocial,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegObraSocial_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMigrLegObraSocial_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegBanSuc_Internalname,A611MigrLegBanSuc,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegBanSuc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegBanTipCuen_Internalname,A612MigrLegBanTipCuen,GXutil.rtrim( localUtil.format( A612MigrLegBanTipCuen, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegBanTipCuen_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionCorta","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegCuentaBanc_Internalname,A619MigrLegCuentaBanc,GXutil.rtrim( localUtil.format( A619MigrLegCuentaBanc, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegCuentaBanc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionCorta","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFormaPago_Internalname,A609MigrLegFormaPago,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFormaPago_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegCBU_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegCBU_Internalname,A621MigrLegCBU,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegCBU_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMigrLegCBU_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CBU","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegModalidad_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegModalidad_Internalname,A617MigrLegModalidad,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegModalidad_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMigrLegModalidad_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtMigrLegHorSem_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegHorSem_Internalname,GXutil.ltrim( localUtil.ntoc( A2275MigrLegHorSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A2275MigrLegHorSem, "Z9.9")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegHorSem_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMigrLegHorSem_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegActividad_Internalname,A616MigrLegActividad,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegActividad_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(150),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegSituacionRevista_Internalname,A623MigrLegSituacionRevista,GXutil.rtrim( localUtil.format( A623MigrLegSituacionRevista, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegSituacionRevista_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionLarga","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegCondicion_Internalname,A624MigrLegCondicion,GXutil.rtrim( localUtil.format( A624MigrLegCondicion, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegCondicion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionLarga","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegSiniestrado_Internalname,A625MigrLegSiniestrado,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegSiniestrado_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegSCVO_Internalname,GXutil.rtrim( A622MigrLegSCVO),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegSCVO_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegPlanMedico_Internalname,A615MigrLegPlanMedico,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegPlanMedico_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrTieneConyuge_Internalname,GXutil.rtrim( A631MigrTieneConyuge),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrTieneConyuge_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrCantidadHijos_Internalname,GXutil.ltrim( localUtil.ntoc( A632MigrCantidadHijos, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A632MigrCantidadHijos), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrCantidadHijos_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegObs_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegObs_Internalname,A628MigrLegObs,A628MigrLegObs,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegObs_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMigrLegObs_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"Obs","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrPeriodo_Internalname,localUtil.format(A2190MigrPeriodo, "99/99/99"),localUtil.format( A2190MigrPeriodo, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrPeriodo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Periodo","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrSueldos_Internalname,A2189MigrSueldos,A2189MigrSueldos,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrSueldos_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrPuesto_Internalname,A2216MigrPuesto,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrPuesto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegActLabClas_Internalname,A2239MigrLegActLabClas,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegActLabClas_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegPueAfip_Internalname,A2240MigrLegPueAfip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegPueAfip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(255),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMigrLegSindicato_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegSindicato_Internalname,A613MigrLegSindicato,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegSindicato_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMigrLegSindicato_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 152,'',false,'"+sGXsfl_97_idx+"',97)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV248Display),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,152);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 153,'',false,'"+sGXsfl_97_idx+"',97)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV99Update),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,153);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 154,'',false,'"+sGXsfl_97_idx+"',97)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV101Delete),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,154);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDetailwebcomponent_Enabled!=0)&&(edtavDetailwebcomponent_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 155,'',false,'"+sGXsfl_97_idx+"',97)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDetailwebcomponent_Internalname,GXutil.rtrim( AV262DetailWebComponent),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDetailwebcomponent_Enabled!=0)&&(edtavDetailwebcomponent_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,155);\"" : " "),"'"+""+"'"+",false,"+"'"+"e35282_client"+"'","","","","",edtavDetailwebcomponent_Jsonclick,Integer.valueOf(7),"Attribute","",ROClassString,"WWIconActionColumn WCD_ActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDetailwebcomponent_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 156,'',false,'"+sGXsfl_97_idx+"',97)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV245VerSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,156);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavModificarsvg_Enabled!=0)&&(edtavModificarsvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 157,'',false,'"+sGXsfl_97_idx+"',97)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV246ModificarSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavModificarsvg_Enabled!=0)&&(edtavModificarsvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,157);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEliminarsvg_Enabled!=0)&&(edtavEliminarsvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 158,'',false,'"+sGXsfl_97_idx+"',97)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV247EliminarSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEliminarsvg_Enabled!=0)&&(edtavEliminarsvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,158);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(97),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes282( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_97_idx = ((subGrid_Islastpage==1)&&(nGXsfl_97_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_97_idx+1) ;
         sGXsfl_97_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_97_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_972( ) ;
      }
      /* End function sendrow_972 */
   }

   public void startgridcontrol97( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"97\">") ;
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
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+""+""+"\" "+">") ;
         if ( chkavSelected.getTitleFormat() == 0 )
         {
            httpContext.writeValue( chkavSelected.getTitle()) ;
         }
         else
         {
            httpContext.writeText( chkavSelected.getTitle()) ;
         }
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavIconoupdatewithtags_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Modificar", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "ID/Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegCUIL_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "CUIL", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegApellido_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Apellido", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nombres", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegModTra_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Relación laboral", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegTipoTarifa_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo Tarifa", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegClase_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Frecuencia de pago", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegFecNac_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha de Nacimiento", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegFecIngreso_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha de ingreso", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegSexo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Género", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegDomici_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Domicilio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegCodPos_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código Postal", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegTelefono_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Teléfono", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegEmail_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Email", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegEstadoCivil_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Estado Civil", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegArea_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Área", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegBasico_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sueldo fuera de convenio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegConvenio_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Convenio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavMigrlegcategoria_var_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Categoría", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegObraSocial_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Obra Social", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegCBU_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "CBU", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegModalidad_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Modalidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegHorSem_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Horas normales semanales", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegObs_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Observaciones", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMigrLegSindicato_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sindicato", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV205Selected));
         GridColumn.AddObjectProperty("Title", GXutil.rtrim( chkavSelected.getTitle()));
         GridColumn.AddObjectProperty("Titleformat", GXutil.ltrim( localUtil.ntoc( chkavSelected.getTitleFormat(), (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkavSelected.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV238iconoUpdateWithTags);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavIconoupdatewithtags_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavIconoupdatewithtags_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavIconoupdatewithtags_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV237iconoUpdate));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavIconoupdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV233Eliminar));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminar_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A87MigrLegNumero, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A626MigrLegId));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegId_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A597MigrLegCUIL));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegCUIL_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A592MigrLegApellido);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegApellido_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A593MigrLegNombre);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegNombre_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2415MigrLegModTra);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegModTra_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2427MigrLegTipoTarifa);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegTipoTarifa_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A607MigrLegClase);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegClase_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A594MigrLegFecNac, "99/99/9999"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegFecNac_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A603MigrLegFecIngreso, "99/99/9999"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegFecIngreso_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A595MigrLegSexo));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegSexo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A620MigrLegZona);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A599MigrLegDomici);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegDomici_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A601MigrLegCodPos);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegCodPos_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A602MigrLegTelefono);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegTelefono_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A600MigrLegEmail);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegEmail_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A596MigrLegEstadoCivil);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegEstadoCivil_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A598MigrLegDiscapacidad));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A605MigrLegArea);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegArea_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A608MigrLegBasico, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtMigrLegBasico_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegBasico_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A627MigrLegConvenio);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegConvenio_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV242MigrLegCategoria_var);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavMigrlegcategoria_var_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavMigrlegcategoria_var_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A604MigrLegCategoria);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A606MigrLegLugarDePago);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A610MigrLegBanco);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A614MigrLegObraSocial);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegObraSocial_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A611MigrLegBanSuc);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A612MigrLegBanTipCuen);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A619MigrLegCuentaBanc);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A609MigrLegFormaPago);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A621MigrLegCBU);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegCBU_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A617MigrLegModalidad);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegModalidad_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2275MigrLegHorSem, (byte)(4), (byte)(1), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegHorSem_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A616MigrLegActividad);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A623MigrLegSituacionRevista);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A624MigrLegCondicion);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A625MigrLegSiniestrado);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A622MigrLegSCVO));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A615MigrLegPlanMedico);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A631MigrTieneConyuge));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A632MigrCantidadHijos, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A628MigrLegObs);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegObs_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A2190MigrPeriodo, "99/99/99"));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2189MigrSueldos);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2216MigrPuesto);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2239MigrLegActLabClas);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2240MigrLegPueAfip);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A613MigrLegSindicato);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMigrLegSindicato_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV248Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV99Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV101Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV262DetailWebComponent));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDetailwebcomponent_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV245VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV246ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV247EliminarSVG));
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
      bttBtngenerartemplate_Internalname = "BTNGENERARTEMPLATE" ;
      bttBtnimportexcel_Internalname = "BTNIMPORTEXCEL" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      Ddo_gridcolumnsselector_Internalname = "DDO_GRIDCOLUMNSSELECTOR" ;
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
      chkavSelected.setInternalname( "vSELECTED" );
      edtavIconoupdatewithtags_Internalname = "vICONOUPDATEWITHTAGS" ;
      edtavIconoupdate_Internalname = "vICONOUPDATE" ;
      edtavEliminar_Internalname = "vELIMINAR" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtMigrLegNumero_Internalname = "MIGRLEGNUMERO" ;
      edtMigrLegId_Internalname = "MIGRLEGID" ;
      edtMigrLegCUIL_Internalname = "MIGRLEGCUIL" ;
      edtMigrLegApellido_Internalname = "MIGRLEGAPELLIDO" ;
      edtMigrLegNombre_Internalname = "MIGRLEGNOMBRE" ;
      edtMigrLegModTra_Internalname = "MIGRLEGMODTRA" ;
      edtMigrLegTipoTarifa_Internalname = "MIGRLEGTIPOTARIFA" ;
      edtMigrLegClase_Internalname = "MIGRLEGCLASE" ;
      edtMigrLegFecNac_Internalname = "MIGRLEGFECNAC" ;
      edtMigrLegFecIngreso_Internalname = "MIGRLEGFECINGRESO" ;
      edtMigrLegSexo_Internalname = "MIGRLEGSEXO" ;
      edtMigrLegZona_Internalname = "MIGRLEGZONA" ;
      edtMigrLegDomici_Internalname = "MIGRLEGDOMICI" ;
      edtMigrLegCodPos_Internalname = "MIGRLEGCODPOS" ;
      edtMigrLegTelefono_Internalname = "MIGRLEGTELEFONO" ;
      edtMigrLegEmail_Internalname = "MIGRLEGEMAIL" ;
      edtMigrLegEstadoCivil_Internalname = "MIGRLEGESTADOCIVIL" ;
      edtMigrLegDiscapacidad_Internalname = "MIGRLEGDISCAPACIDAD" ;
      edtMigrLegArea_Internalname = "MIGRLEGAREA" ;
      edtMigrLegBasico_Internalname = "MIGRLEGBASICO" ;
      edtMigrLegConvenio_Internalname = "MIGRLEGCONVENIO" ;
      edtavMigrlegcategoria_var_Internalname = "vMIGRLEGCATEGORIA_VAR" ;
      edtMigrLegCategoria_Internalname = "MIGRLEGCATEGORIA" ;
      edtMigrLegLugarDePago_Internalname = "MIGRLEGLUGARDEPAGO" ;
      edtMigrLegBanco_Internalname = "MIGRLEGBANCO" ;
      edtMigrLegObraSocial_Internalname = "MIGRLEGOBRASOCIAL" ;
      edtMigrLegBanSuc_Internalname = "MIGRLEGBANSUC" ;
      edtMigrLegBanTipCuen_Internalname = "MIGRLEGBANTIPCUEN" ;
      edtMigrLegCuentaBanc_Internalname = "MIGRLEGCUENTABANC" ;
      edtMigrLegFormaPago_Internalname = "MIGRLEGFORMAPAGO" ;
      edtMigrLegCBU_Internalname = "MIGRLEGCBU" ;
      edtMigrLegModalidad_Internalname = "MIGRLEGMODALIDAD" ;
      edtMigrLegHorSem_Internalname = "MIGRLEGHORSEM" ;
      edtMigrLegActividad_Internalname = "MIGRLEGACTIVIDAD" ;
      edtMigrLegSituacionRevista_Internalname = "MIGRLEGSITUACIONREVISTA" ;
      edtMigrLegCondicion_Internalname = "MIGRLEGCONDICION" ;
      edtMigrLegSiniestrado_Internalname = "MIGRLEGSINIESTRADO" ;
      edtMigrLegSCVO_Internalname = "MIGRLEGSCVO" ;
      edtMigrLegPlanMedico_Internalname = "MIGRLEGPLANMEDICO" ;
      edtMigrTieneConyuge_Internalname = "MIGRTIENECONYUGE" ;
      edtMigrCantidadHijos_Internalname = "MIGRCANTIDADHIJOS" ;
      edtMigrLegObs_Internalname = "MIGRLEGOBS" ;
      edtMigrPeriodo_Internalname = "MIGRPERIODO" ;
      edtMigrSueldos_Internalname = "MIGRSUELDOS" ;
      edtMigrPuesto_Internalname = "MIGRPUESTO" ;
      edtMigrLegActLabClas_Internalname = "MIGRLEGACTLABCLAS" ;
      edtMigrLegPueAfip_Internalname = "MIGRLEGPUEAFIP" ;
      edtMigrLegSindicato_Internalname = "MIGRLEGSINDICATO" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDelete_Internalname = "vDELETE" ;
      edtavDetailwebcomponent_Internalname = "vDETAILWEBCOMPONENT" ;
      edtavVersvg_Internalname = "vVERSVG" ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG" ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divCell_grid_dwc_Internalname = "CELL_GRID_DWC" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      tblTablepadding_Internalname = "TABLEPADDING" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      bttBtnimportarlegajosalsistema_Internalname = "BTNIMPORTARLEGAJOSALSISTEMA" ;
      bttBtneliminartodos_Internalname = "BTNELIMINARTODOS" ;
      bttBtnimportartodos_Internalname = "BTNIMPORTARTODOS" ;
      tblTablemergedbtnimportarlegajosalsistema_Internalname = "TABLEMERGEDBTNIMPORTARLEGAJOSALSISTEMA" ;
      Innewwindow1_Internalname = "INNEWWINDOW1" ;
      lblJs_Internalname = "JS" ;
      tblTablemergedinnewwindow1_Internalname = "TABLEMERGEDINNEWWINDOW1" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Popover_iconoupdate_Internalname = "POPOVER_ICONOUPDATE" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      chkavSelectall.setInternalname( "vSELECTALL" );
      Dvelop_confirmpanel_btnimportarlegajosalsistema_Internalname = "DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA" ;
      tblTabledvelop_confirmpanel_btnimportarlegajosalsistema_Internalname = "TABLEDVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA" ;
      Dvelop_confirmpanel_btneliminartodos_Internalname = "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS" ;
      tblTabledvelop_confirmpanel_btneliminartodos_Internalname = "TABLEDVELOP_CONFIRMPANEL_BTNELIMINARTODOS" ;
      Dvelop_confirmpanel_eliminar_Internalname = "DVELOP_CONFIRMPANEL_ELIMINAR" ;
      tblTabledvelop_confirmpanel_eliminar_Internalname = "TABLEDVELOP_CONFIRMPANEL_ELIMINAR" ;
      Importexcel_modal_Internalname = "IMPORTEXCEL_MODAL" ;
      tblTableimportexcel_modal_Internalname = "TABLEIMPORTEXCEL_MODAL" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      divDiv_wwpauxwc_Internalname = "DIV_WWPAUXWC" ;
      edtavDdo_migrlegfecnacauxdatetext_Internalname = "vDDO_MIGRLEGFECNACAUXDATETEXT" ;
      Tfmigrlegfecnac_rangepicker_Internalname = "TFMIGRLEGFECNAC_RANGEPICKER" ;
      divDdo_migrlegfecnacauxdates_Internalname = "DDO_MIGRLEGFECNACAUXDATES" ;
      edtavDdo_migrlegfecingresoauxdatetext_Internalname = "vDDO_MIGRLEGFECINGRESOAUXDATETEXT" ;
      Tfmigrlegfecingreso_rangepicker_Internalname = "TFMIGRLEGFECINGRESO_RANGEPICKER" ;
      divDdo_migrlegfecingresoauxdates_Internalname = "DDO_MIGRLEGFECINGRESOAUXDATES" ;
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
      edtavEliminarsvg_Enabled = 1 ;
      edtavEliminarsvg_Format = (short)(0) ;
      edtavModificarsvg_Jsonclick = "" ;
      edtavModificarsvg_Enabled = 1 ;
      edtavModificarsvg_Format = (short)(0) ;
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Enabled = 1 ;
      edtavVersvg_Format = (short)(0) ;
      edtavDetailwebcomponent_Jsonclick = "" ;
      edtavDetailwebcomponent_Visible = -1 ;
      edtavDetailwebcomponent_Enabled = 1 ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Enabled = 1 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Enabled = 1 ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 1 ;
      edtMigrLegSindicato_Jsonclick = "" ;
      edtMigrLegPueAfip_Jsonclick = "" ;
      edtMigrLegActLabClas_Jsonclick = "" ;
      edtMigrPuesto_Jsonclick = "" ;
      edtMigrSueldos_Jsonclick = "" ;
      edtMigrPeriodo_Jsonclick = "" ;
      edtMigrLegObs_Jsonclick = "" ;
      edtMigrCantidadHijos_Jsonclick = "" ;
      edtMigrTieneConyuge_Jsonclick = "" ;
      edtMigrLegPlanMedico_Jsonclick = "" ;
      edtMigrLegSCVO_Jsonclick = "" ;
      edtMigrLegSiniestrado_Jsonclick = "" ;
      edtMigrLegCondicion_Jsonclick = "" ;
      edtMigrLegSituacionRevista_Jsonclick = "" ;
      edtMigrLegActividad_Jsonclick = "" ;
      edtMigrLegHorSem_Jsonclick = "" ;
      edtMigrLegModalidad_Jsonclick = "" ;
      edtMigrLegCBU_Jsonclick = "" ;
      edtMigrLegFormaPago_Jsonclick = "" ;
      edtMigrLegCuentaBanc_Jsonclick = "" ;
      edtMigrLegBanTipCuen_Jsonclick = "" ;
      edtMigrLegBanSuc_Jsonclick = "" ;
      edtMigrLegObraSocial_Jsonclick = "" ;
      edtMigrLegBanco_Jsonclick = "" ;
      edtMigrLegLugarDePago_Jsonclick = "" ;
      edtMigrLegCategoria_Jsonclick = "" ;
      edtavMigrlegcategoria_var_Jsonclick = "" ;
      edtavMigrlegcategoria_var_Enabled = 1 ;
      edtMigrLegConvenio_Jsonclick = "" ;
      edtMigrLegBasico_Jsonclick = "" ;
      edtMigrLegBasico_Tooltiptext = "" ;
      edtMigrLegArea_Jsonclick = "" ;
      edtMigrLegDiscapacidad_Jsonclick = "" ;
      edtMigrLegEstadoCivil_Jsonclick = "" ;
      edtMigrLegEmail_Jsonclick = "" ;
      edtMigrLegTelefono_Jsonclick = "" ;
      edtMigrLegCodPos_Jsonclick = "" ;
      edtMigrLegDomici_Jsonclick = "" ;
      edtMigrLegZona_Jsonclick = "" ;
      edtMigrLegSexo_Jsonclick = "" ;
      edtMigrLegFecIngreso_Jsonclick = "" ;
      edtMigrLegFecNac_Jsonclick = "" ;
      edtMigrLegClase_Jsonclick = "" ;
      edtMigrLegTipoTarifa_Jsonclick = "" ;
      edtMigrLegModTra_Jsonclick = "" ;
      edtMigrLegNombre_Jsonclick = "" ;
      edtMigrLegApellido_Jsonclick = "" ;
      edtMigrLegCUIL_Jsonclick = "" ;
      edtMigrLegId_Jsonclick = "" ;
      edtMigrLegNumero_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      edtavEliminar_Jsonclick = "" ;
      edtavEliminar_Visible = -1 ;
      edtavEliminar_Enabled = 1 ;
      edtavIconoupdate_Jsonclick = "" ;
      edtavIconoupdate_Visible = 0 ;
      edtavIconoupdate_Enabled = 1 ;
      edtavIconoupdatewithtags_Jsonclick = "" ;
      edtavIconoupdatewithtags_Link = "" ;
      edtavIconoupdatewithtags_Enabled = 1 ;
      chkavSelected.setCaption( "" );
      chkavSelected.setVisible( -1 );
      chkavSelected.setEnabled( 1 );
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblCouttext_Visible = 1 ;
      divButtonfilter1_tablecontent_Visible = 1 ;
      bttBtnimportexcel_Visible = 1 ;
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      bttBtnimportartodos_Visible = 1 ;
      bttBtneliminartodos_Visible = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      edtavEliminarsvg_Link = "" ;
      edtavModificarsvg_Columnclass = "WWColumn" ;
      edtavModificarsvg_Link = "" ;
      edtavDisplay_Visible = -1 ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Link = "" ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      lblJs_Caption = httpContext.getMessage( " js", "") ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      chkavSelected.setTitle( "" );
      edtavEliminarsvg_Visible = -1 ;
      edtavModificarsvg_Visible = -1 ;
      edtavVersvg_Visible = -1 ;
      edtMigrLegSindicato_Visible = -1 ;
      edtMigrLegObs_Visible = -1 ;
      edtMigrLegHorSem_Visible = -1 ;
      edtMigrLegModalidad_Visible = -1 ;
      edtMigrLegCBU_Visible = -1 ;
      edtMigrLegObraSocial_Visible = -1 ;
      edtavMigrlegcategoria_var_Visible = -1 ;
      edtMigrLegConvenio_Visible = -1 ;
      edtMigrLegBasico_Visible = -1 ;
      edtMigrLegArea_Visible = -1 ;
      edtMigrLegEstadoCivil_Visible = -1 ;
      edtMigrLegEmail_Visible = -1 ;
      edtMigrLegTelefono_Visible = -1 ;
      edtMigrLegCodPos_Visible = -1 ;
      edtMigrLegDomici_Visible = -1 ;
      edtMigrLegSexo_Visible = -1 ;
      edtMigrLegFecIngreso_Visible = -1 ;
      edtMigrLegFecNac_Visible = -1 ;
      edtMigrLegClase_Visible = -1 ;
      edtMigrLegTipoTarifa_Visible = -1 ;
      edtMigrLegModTra_Visible = -1 ;
      edtMigrLegNombre_Visible = -1 ;
      edtMigrLegApellido_Visible = -1 ;
      edtMigrLegCUIL_Visible = -1 ;
      edtMigrLegId_Visible = -1 ;
      edtavIconoupdatewithtags_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      divCell_grid_dwc_Class = "col-xs-12" ;
      subGrid_Sortable = (byte)(0) ;
      edtavDdo_migrlegfecingresoauxdatetext_Jsonclick = "" ;
      edtavDdo_migrlegfecnacauxdatetext_Jsonclick = "" ;
      chkavSelectall.setVisible( 1 );
      divLayoutmaintable_Class = "Table TableWithSelectableGrid" ;
      chkavSelected.setTitleFormat( (short)(0) );
      edtavDelete_Link = "" ;
      edtavUpdate_Link = "" ;
      edtavDisplay_Link = "" ;
      Grid_empowerer_Popoversingrid = "Popover_iconoUpdate" ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Importexcel_modal_Bodytype = "WebComponent" ;
      Importexcel_modal_Confirmtype = "" ;
      Importexcel_modal_Title = httpContext.getMessage( "Importar archivo", "") ;
      Importexcel_modal_Width = "400" ;
      Dvelop_confirmpanel_eliminar_Confirmtype = "1" ;
      Dvelop_confirmpanel_eliminar_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_eliminar_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_eliminar_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_eliminar_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_eliminar_Confirmationtext = "" ;
      Dvelop_confirmpanel_eliminar_Title = httpContext.getMessage( "Eliminar", "") ;
      Dvelop_confirmpanel_btneliminartodos_Confirmtype = "1" ;
      Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_btneliminartodos_Confirmationtext = "-" ;
      Dvelop_confirmpanel_btneliminartodos_Title = httpContext.getMessage( "Eliminar", "") ;
      Dvelop_confirmpanel_btnimportarlegajosalsistema_Confirmtype = "1" ;
      Dvelop_confirmpanel_btnimportarlegajosalsistema_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_btnimportarlegajosalsistema_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_btnimportarlegajosalsistema_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_btnimportarlegajosalsistema_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_btnimportarlegajosalsistema_Confirmationtext = "-" ;
      Dvelop_confirmpanel_btnimportarlegajosalsistema_Title = httpContext.getMessage( "Importar Legajos", "") ;
      Ddo_grid_Format = "|||||||||||||||||-14.2||||||4.1||" ;
      Ddo_grid_Fixedfilters = "1:Con Warnings:fa fa-circle FontColorIconWarning FontColorIconSmall ConditionalFormattingFilterIcon,2:Con Errores:fa fa-circle FontColorIconDanger FontColorIconSmall ConditionalFormattingFilterIcon,3:Validados OK:fa fa-circle FontColorIconSuccess FontColorIconSmall ConditionalFormattingFilterIcon|||||||||||||||||||||||||" ;
      Ddo_grid_Datalistproc = "importacion_legajoWWGetFilterData" ;
      Ddo_grid_Allowmultipleselection = "|T|T|T|T|T|T|T|||T|T|T|T|T|T|T||T||T|T|T||T|T" ;
      Ddo_grid_Datalisttype = "|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|||Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic||Dynamic||Dynamic|Dynamic|Dynamic||Dynamic|Dynamic" ;
      Ddo_grid_Includedatalist = "|T|T|T|T|T|T|T|||T|T|T|T|T|T|T||T||T|T|T||T|T" ;
      Ddo_grid_Filterisrange = "||||||||P|P||||||||T||||||T||" ;
      Ddo_grid_Filtertype = "|Character|Character|Character|Character|Character|Character|Character|Date|Date|Character|Character|Character|Character|Character|Character|Character|Numeric|Character||Character|Character|Character|Numeric|Character|Character" ;
      Ddo_grid_Includefilter = "|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T||T|T|T|T|T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T||T|T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18||19|20|21|22|23|24" ;
      Ddo_grid_Columnids = "1:iconoUpdate|7:MigrLegId|8:MigrLegCUIL|9:MigrLegApellido|10:MigrLegNombre|11:MigrLegModTra|12:MigrLegTipoTarifa|13:MigrLegClase|14:MigrLegFecNac|15:MigrLegFecIngreso|16:MigrLegSexo|18:MigrLegDomici|19:MigrLegCodPos|20:MigrLegTelefono|21:MigrLegEmail|22:MigrLegEstadoCivil|24:MigrLegArea|25:MigrLegBasico|26:MigrLegConvenio|27:MigrLegCategoria_var|31:MigrLegObraSocial|36:MigrLegCBU|37:MigrLegModalidad|38:MigrLegHorSem|47:MigrLegObs|53:MigrLegSindicato" ;
      Ddo_grid_Gridinternalname = "" ;
      Popover_iconoupdate_Visible = GXutil.toBoolean( -1) ;
      Popover_iconoupdate_Popoverwidth = 400 ;
      Popover_iconoupdate_Isgriditem = GXutil.toBoolean( -1) ;
      Popover_iconoupdate_Iteminternalname = "" ;
      Innewwindow1_Target = "" ;
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
      Ddo_gridcolumnsselector_Dropdownoptionstype = "GridColumnsSelector" ;
      Ddo_gridcolumnsselector_Cls = "ColumnsSelector" ;
      Ddo_gridcolumnsselector_Tooltip = "WWP_EditColumnsTooltip" ;
      Ddo_gridcolumnsselector_Caption = httpContext.getMessage( "Columnas", "") ;
      Ddo_gridcolumnsselector_Icon = "fas fa-cog" ;
      Ddo_gridcolumnsselector_Icontype = "FontIcon" ;
      Ddo_managefilters_Cls = "ManageFilters" ;
      Ddo_managefilters_Tooltip = "WWP_ManageFiltersTooltip" ;
      Ddo_managefilters_Icon = "fas fa-filter" ;
      Ddo_managefilters_Icontype = "FontIcon" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( " Importación de Legajos", "") );
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
      AV251WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV251WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV251WelcomeMessage_NoMostrarMas", AV251WelcomeMessage_NoMostrarMas);
      GXCCtl = "vSELECTED_" + sGXsfl_97_idx ;
      chkavSelected.setName( GXCCtl );
      chkavSelected.setWebtags( "" );
      chkavSelected.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavSelected.getInternalname(), "TitleCaption", chkavSelected.getCaption(), !bGXsfl_97_Refreshing);
      chkavSelected.setCheckedValue( "false" );
      AV205Selected = GXutil.strtobool( GXutil.booltostr( AV205Selected)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavSelected.getInternalname(), AV205Selected);
      chkavSelectall.setName( "vSELECTALL" );
      chkavSelectall.setWebtags( "" );
      chkavSelectall.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavSelectall.getInternalname(), "TitleCaption", chkavSelectall.getCaption(), true);
      chkavSelectall.setCheckedValue( "false" );
      AV221SelectAll = GXutil.strtobool( GXutil.booltostr( AV221SelectAll)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV221SelectAll", AV221SelectAll);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'chkavSelected.getTitleFormat()',ctrl:'vSELECTED',prop:'Titleformat'},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV289Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'AV249MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV239TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV251WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavIconoupdatewithtags_Visible',ctrl:'vICONOUPDATEWITHTAGS',prop:'Visible'},{av:'edtMigrLegId_Visible',ctrl:'MIGRLEGID',prop:'Visible'},{av:'edtMigrLegCUIL_Visible',ctrl:'MIGRLEGCUIL',prop:'Visible'},{av:'edtMigrLegApellido_Visible',ctrl:'MIGRLEGAPELLIDO',prop:'Visible'},{av:'edtMigrLegNombre_Visible',ctrl:'MIGRLEGNOMBRE',prop:'Visible'},{av:'edtMigrLegModTra_Visible',ctrl:'MIGRLEGMODTRA',prop:'Visible'},{av:'edtMigrLegTipoTarifa_Visible',ctrl:'MIGRLEGTIPOTARIFA',prop:'Visible'},{av:'edtMigrLegClase_Visible',ctrl:'MIGRLEGCLASE',prop:'Visible'},{av:'edtMigrLegFecNac_Visible',ctrl:'MIGRLEGFECNAC',prop:'Visible'},{av:'edtMigrLegFecIngreso_Visible',ctrl:'MIGRLEGFECINGRESO',prop:'Visible'},{av:'edtMigrLegSexo_Visible',ctrl:'MIGRLEGSEXO',prop:'Visible'},{av:'edtMigrLegDomici_Visible',ctrl:'MIGRLEGDOMICI',prop:'Visible'},{av:'edtMigrLegCodPos_Visible',ctrl:'MIGRLEGCODPOS',prop:'Visible'},{av:'edtMigrLegTelefono_Visible',ctrl:'MIGRLEGTELEFONO',prop:'Visible'},{av:'edtMigrLegEmail_Visible',ctrl:'MIGRLEGEMAIL',prop:'Visible'},{av:'edtMigrLegEstadoCivil_Visible',ctrl:'MIGRLEGESTADOCIVIL',prop:'Visible'},{av:'edtMigrLegArea_Visible',ctrl:'MIGRLEGAREA',prop:'Visible'},{av:'edtMigrLegBasico_Visible',ctrl:'MIGRLEGBASICO',prop:'Visible'},{av:'edtMigrLegConvenio_Visible',ctrl:'MIGRLEGCONVENIO',prop:'Visible'},{av:'edtavMigrlegcategoria_var_Visible',ctrl:'vMIGRLEGCATEGORIA_VAR',prop:'Visible'},{av:'edtMigrLegObraSocial_Visible',ctrl:'MIGRLEGOBRASOCIAL',prop:'Visible'},{av:'edtMigrLegCBU_Visible',ctrl:'MIGRLEGCBU',prop:'Visible'},{av:'edtMigrLegModalidad_Visible',ctrl:'MIGRLEGMODALIDAD',prop:'Visible'},{av:'edtMigrLegHorSem_Visible',ctrl:'MIGRLEGHORSEM',prop:'Visible'},{av:'edtMigrLegObs_Visible',ctrl:'MIGRLEGOBS',prop:'Visible'},{av:'edtMigrLegSindicato_Visible',ctrl:'MIGRLEGSINDICATO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'chkavSelected.getTitle()',ctrl:'vSELECTED',prop:'Title'},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'AV96GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV97GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV98GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'},{av:'AV267ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13282',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV289Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'AV249MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV239TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'chkavSelected.getTitleFormat()',ctrl:'vSELECTED',prop:'Titleformat'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV251WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14282',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV289Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'AV249MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV239TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'chkavSelected.getTitleFormat()',ctrl:'vSELECTED',prop:'Titleformat'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV251WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15282',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV289Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'AV249MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV239TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'chkavSelected.getTitleFormat()',ctrl:'vSELECTED',prop:'Titleformat'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV251WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumnfixedfilter',ctrl:'DDO_GRID',prop:'SelectedColumnFixedFilter'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV91TFMigrLegSindicato_SelsJson',fld:'vTFMIGRLEGSINDICATO_SELSJSON',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV139TFMigrLegObs_SelsJson',fld:'vTFMIGRLEGOBS_SELSJSON',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV133TFMigrLegModalidad_SelsJson',fld:'vTFMIGRLEGMODALIDAD_SELSJSON',pic:''},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV113TFMigrLegCBU_SelsJson',fld:'vTFMIGRLEGCBU_SELSJSON',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV136TFMigrLegObraSocial_SelsJson',fld:'vTFMIGRLEGOBRASOCIAL_SELSJSON',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV119TFMigrLegConvenio_SelsJson',fld:'vTFMIGRLEGCONVENIO_SELSJSON',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV68TFMigrLegArea_SelsJson',fld:'vTFMIGRLEGAREA_SELSJSON',pic:''},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV39TFMigrLegEstadoCivil_SelsJson',fld:'vTFMIGRLEGESTADOCIVIL_SELSJSON',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV51TFMigrLegEmail_SelsJson',fld:'vTFMIGRLEGEMAIL_SELSJSON',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV57TFMigrLegTelefono_SelsJson',fld:'vTFMIGRLEGTELEFONO_SELSJSON',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV54TFMigrLegCodPos_SelsJson',fld:'vTFMIGRLEGCODPOS_SELSJSON',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV48TFMigrLegDomici_SelsJson',fld:'vTFMIGRLEGDOMICI_SELSJSON',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV36TFMigrLegSexo_SelsJson',fld:'vTFMIGRLEGSEXO_SELSJSON',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV74TFMigrLegClase_SelsJson',fld:'vTFMIGRLEGCLASE_SELSJSON',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV283TFMigrLegTipoTarifa_SelsJson',fld:'vTFMIGRLEGTIPOTARIFA_SELSJSON',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV280TFMigrLegModTra_SelsJson',fld:'vTFMIGRLEGMODTRA_SELSJSON',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV28TFMigrLegNombre_SelsJson',fld:'vTFMIGRLEGNOMBRE_SELSJSON',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV25TFMigrLegApellido_SelsJson',fld:'vTFMIGRLEGAPELLIDO_SELSJSON',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV42TFMigrLegCUIL_SelsJson',fld:'vTFMIGRLEGCUIL_SELSJSON',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV107TFMigrLegId_SelsJson',fld:'vTFMIGRLEGID_SELSJSON',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV239TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e29282',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV289Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'A629MigrLegErrores',fld:'MIGRLEGERRORES',pic:''},{av:'A633MigrLegWarnings',fld:'MIGRLEGWARNINGS',pic:''},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A604MigrLegCategoria',fld:'MIGRLEGCATEGORIA',pic:''},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'A2189MigrSueldos',fld:'MIGRSUELDOS',pic:''},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'edtavIconoupdatewithtags_Link',ctrl:'vICONOUPDATEWITHTAGS',prop:'Link'},{av:'chkavSelected.getEnabled()',ctrl:'vSELECTED',prop:'Enabled'},{av:'Popover_iconoupdate_Visible',ctrl:'POPOVER_ICONOUPDATE',prop:'Visible'},{av:'AV233Eliminar',fld:'vELIMINAR',pic:''},{av:'AV248Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'AV99Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV101Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV262DetailWebComponent',fld:'vDETAILWEBCOMPONENT',pic:''},{av:'AV205Selected',fld:'vSELECTED',pic:''},{av:'AV237iconoUpdate',fld:'vICONOUPDATE',pic:''},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV245VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV246ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV247EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV238iconoUpdateWithTags',fld:'vICONOUPDATEWITHTAGS',pic:''},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'},{av:'edtMigrLegBasico_Tooltiptext',ctrl:'MIGRLEGBASICO',prop:'Tooltiptext'},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV211CliCodColItem',fld:'vCLICODCOLITEM',pic:'ZZZZZ9'}]}");
      setEventMetadata("VSELECTED.CLICK","{handler:'e31282',iparms:[{av:'AV205Selected',fld:'vSELECTED',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VSELECTED.CLICK",",oparms:[{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'divLayoutmaintable_Class',ctrl:'LAYOUTMAINTABLE',prop:'Class'},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV211CliCodColItem',fld:'vCLICODCOLITEM',pic:'ZZZZZ9'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e12282',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV289Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'AV249MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV239TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'chkavSelected.getTitleFormat()',ctrl:'vSELECTED',prop:'Titleformat'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV251WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtavIconoupdatewithtags_Visible',ctrl:'vICONOUPDATEWITHTAGS',prop:'Visible'},{av:'edtMigrLegId_Visible',ctrl:'MIGRLEGID',prop:'Visible'},{av:'edtMigrLegCUIL_Visible',ctrl:'MIGRLEGCUIL',prop:'Visible'},{av:'edtMigrLegApellido_Visible',ctrl:'MIGRLEGAPELLIDO',prop:'Visible'},{av:'edtMigrLegNombre_Visible',ctrl:'MIGRLEGNOMBRE',prop:'Visible'},{av:'edtMigrLegModTra_Visible',ctrl:'MIGRLEGMODTRA',prop:'Visible'},{av:'edtMigrLegTipoTarifa_Visible',ctrl:'MIGRLEGTIPOTARIFA',prop:'Visible'},{av:'edtMigrLegClase_Visible',ctrl:'MIGRLEGCLASE',prop:'Visible'},{av:'edtMigrLegFecNac_Visible',ctrl:'MIGRLEGFECNAC',prop:'Visible'},{av:'edtMigrLegFecIngreso_Visible',ctrl:'MIGRLEGFECINGRESO',prop:'Visible'},{av:'edtMigrLegSexo_Visible',ctrl:'MIGRLEGSEXO',prop:'Visible'},{av:'edtMigrLegDomici_Visible',ctrl:'MIGRLEGDOMICI',prop:'Visible'},{av:'edtMigrLegCodPos_Visible',ctrl:'MIGRLEGCODPOS',prop:'Visible'},{av:'edtMigrLegTelefono_Visible',ctrl:'MIGRLEGTELEFONO',prop:'Visible'},{av:'edtMigrLegEmail_Visible',ctrl:'MIGRLEGEMAIL',prop:'Visible'},{av:'edtMigrLegEstadoCivil_Visible',ctrl:'MIGRLEGESTADOCIVIL',prop:'Visible'},{av:'edtMigrLegArea_Visible',ctrl:'MIGRLEGAREA',prop:'Visible'},{av:'edtMigrLegBasico_Visible',ctrl:'MIGRLEGBASICO',prop:'Visible'},{av:'edtMigrLegConvenio_Visible',ctrl:'MIGRLEGCONVENIO',prop:'Visible'},{av:'edtavMigrlegcategoria_var_Visible',ctrl:'vMIGRLEGCATEGORIA_VAR',prop:'Visible'},{av:'edtMigrLegObraSocial_Visible',ctrl:'MIGRLEGOBRASOCIAL',prop:'Visible'},{av:'edtMigrLegCBU_Visible',ctrl:'MIGRLEGCBU',prop:'Visible'},{av:'edtMigrLegModalidad_Visible',ctrl:'MIGRLEGMODALIDAD',prop:'Visible'},{av:'edtMigrLegHorSem_Visible',ctrl:'MIGRLEGHORSEM',prop:'Visible'},{av:'edtMigrLegObs_Visible',ctrl:'MIGRLEGOBS',prop:'Visible'},{av:'edtMigrLegSindicato_Visible',ctrl:'MIGRLEGSINDICATO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'chkavSelected.getTitle()',ctrl:'vSELECTED',prop:'Title'},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'AV96GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV97GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV98GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'},{av:'AV267ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e11282',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV289Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'AV249MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV239TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'chkavSelected.getTitleFormat()',ctrl:'vSELECTED',prop:'Titleformat'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV251WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV107TFMigrLegId_SelsJson',fld:'vTFMIGRLEGID_SELSJSON',pic:''},{av:'AV42TFMigrLegCUIL_SelsJson',fld:'vTFMIGRLEGCUIL_SELSJSON',pic:''},{av:'AV25TFMigrLegApellido_SelsJson',fld:'vTFMIGRLEGAPELLIDO_SELSJSON',pic:''},{av:'AV28TFMigrLegNombre_SelsJson',fld:'vTFMIGRLEGNOMBRE_SELSJSON',pic:''},{av:'AV280TFMigrLegModTra_SelsJson',fld:'vTFMIGRLEGMODTRA_SELSJSON',pic:''},{av:'AV283TFMigrLegTipoTarifa_SelsJson',fld:'vTFMIGRLEGTIPOTARIFA_SELSJSON',pic:''},{av:'AV74TFMigrLegClase_SelsJson',fld:'vTFMIGRLEGCLASE_SELSJSON',pic:''},{av:'AV36TFMigrLegSexo_SelsJson',fld:'vTFMIGRLEGSEXO_SELSJSON',pic:''},{av:'AV48TFMigrLegDomici_SelsJson',fld:'vTFMIGRLEGDOMICI_SELSJSON',pic:''},{av:'AV54TFMigrLegCodPos_SelsJson',fld:'vTFMIGRLEGCODPOS_SELSJSON',pic:''},{av:'AV57TFMigrLegTelefono_SelsJson',fld:'vTFMIGRLEGTELEFONO_SELSJSON',pic:''},{av:'AV51TFMigrLegEmail_SelsJson',fld:'vTFMIGRLEGEMAIL_SELSJSON',pic:''},{av:'AV39TFMigrLegEstadoCivil_SelsJson',fld:'vTFMIGRLEGESTADOCIVIL_SELSJSON',pic:''},{av:'AV68TFMigrLegArea_SelsJson',fld:'vTFMIGRLEGAREA_SELSJSON',pic:''},{av:'AV119TFMigrLegConvenio_SelsJson',fld:'vTFMIGRLEGCONVENIO_SELSJSON',pic:''},{av:'AV136TFMigrLegObraSocial_SelsJson',fld:'vTFMIGRLEGOBRASOCIAL_SELSJSON',pic:''},{av:'AV113TFMigrLegCBU_SelsJson',fld:'vTFMIGRLEGCBU_SELSJSON',pic:''},{av:'AV133TFMigrLegModalidad_SelsJson',fld:'vTFMIGRLEGMODALIDAD_SELSJSON',pic:''},{av:'AV139TFMigrLegObs_SelsJson',fld:'vTFMIGRLEGOBS_SELSJSON',pic:''},{av:'AV91TFMigrLegSindicato_SelsJson',fld:'vTFMIGRLEGSINDICATO_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'Ddo_grid_Selectedfixedfilter',ctrl:'DDO_GRID',prop:'SelectedFixedFilter'},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV91TFMigrLegSindicato_SelsJson',fld:'vTFMIGRLEGSINDICATO_SELSJSON',pic:''},{av:'AV139TFMigrLegObs_SelsJson',fld:'vTFMIGRLEGOBS_SELSJSON',pic:''},{av:'AV133TFMigrLegModalidad_SelsJson',fld:'vTFMIGRLEGMODALIDAD_SELSJSON',pic:''},{av:'AV113TFMigrLegCBU_SelsJson',fld:'vTFMIGRLEGCBU_SELSJSON',pic:''},{av:'AV136TFMigrLegObraSocial_SelsJson',fld:'vTFMIGRLEGOBRASOCIAL_SELSJSON',pic:''},{av:'AV119TFMigrLegConvenio_SelsJson',fld:'vTFMIGRLEGCONVENIO_SELSJSON',pic:''},{av:'AV68TFMigrLegArea_SelsJson',fld:'vTFMIGRLEGAREA_SELSJSON',pic:''},{av:'AV39TFMigrLegEstadoCivil_SelsJson',fld:'vTFMIGRLEGESTADOCIVIL_SELSJSON',pic:''},{av:'AV51TFMigrLegEmail_SelsJson',fld:'vTFMIGRLEGEMAIL_SELSJSON',pic:''},{av:'AV57TFMigrLegTelefono_SelsJson',fld:'vTFMIGRLEGTELEFONO_SELSJSON',pic:''},{av:'AV54TFMigrLegCodPos_SelsJson',fld:'vTFMIGRLEGCODPOS_SELSJSON',pic:''},{av:'AV48TFMigrLegDomici_SelsJson',fld:'vTFMIGRLEGDOMICI_SELSJSON',pic:''},{av:'AV36TFMigrLegSexo_SelsJson',fld:'vTFMIGRLEGSEXO_SELSJSON',pic:''},{av:'AV74TFMigrLegClase_SelsJson',fld:'vTFMIGRLEGCLASE_SELSJSON',pic:''},{av:'AV283TFMigrLegTipoTarifa_SelsJson',fld:'vTFMIGRLEGTIPOTARIFA_SELSJSON',pic:''},{av:'AV280TFMigrLegModTra_SelsJson',fld:'vTFMIGRLEGMODTRA_SELSJSON',pic:''},{av:'AV28TFMigrLegNombre_SelsJson',fld:'vTFMIGRLEGNOMBRE_SELSJSON',pic:''},{av:'AV25TFMigrLegApellido_SelsJson',fld:'vTFMIGRLEGAPELLIDO_SELSJSON',pic:''},{av:'AV42TFMigrLegCUIL_SelsJson',fld:'vTFMIGRLEGCUIL_SELSJSON',pic:''},{av:'AV107TFMigrLegId_SelsJson',fld:'vTFMIGRLEGID_SELSJSON',pic:''},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavIconoupdatewithtags_Visible',ctrl:'vICONOUPDATEWITHTAGS',prop:'Visible'},{av:'edtMigrLegId_Visible',ctrl:'MIGRLEGID',prop:'Visible'},{av:'edtMigrLegCUIL_Visible',ctrl:'MIGRLEGCUIL',prop:'Visible'},{av:'edtMigrLegApellido_Visible',ctrl:'MIGRLEGAPELLIDO',prop:'Visible'},{av:'edtMigrLegNombre_Visible',ctrl:'MIGRLEGNOMBRE',prop:'Visible'},{av:'edtMigrLegModTra_Visible',ctrl:'MIGRLEGMODTRA',prop:'Visible'},{av:'edtMigrLegTipoTarifa_Visible',ctrl:'MIGRLEGTIPOTARIFA',prop:'Visible'},{av:'edtMigrLegClase_Visible',ctrl:'MIGRLEGCLASE',prop:'Visible'},{av:'edtMigrLegFecNac_Visible',ctrl:'MIGRLEGFECNAC',prop:'Visible'},{av:'edtMigrLegFecIngreso_Visible',ctrl:'MIGRLEGFECINGRESO',prop:'Visible'},{av:'edtMigrLegSexo_Visible',ctrl:'MIGRLEGSEXO',prop:'Visible'},{av:'edtMigrLegDomici_Visible',ctrl:'MIGRLEGDOMICI',prop:'Visible'},{av:'edtMigrLegCodPos_Visible',ctrl:'MIGRLEGCODPOS',prop:'Visible'},{av:'edtMigrLegTelefono_Visible',ctrl:'MIGRLEGTELEFONO',prop:'Visible'},{av:'edtMigrLegEmail_Visible',ctrl:'MIGRLEGEMAIL',prop:'Visible'},{av:'edtMigrLegEstadoCivil_Visible',ctrl:'MIGRLEGESTADOCIVIL',prop:'Visible'},{av:'edtMigrLegArea_Visible',ctrl:'MIGRLEGAREA',prop:'Visible'},{av:'edtMigrLegBasico_Visible',ctrl:'MIGRLEGBASICO',prop:'Visible'},{av:'edtMigrLegConvenio_Visible',ctrl:'MIGRLEGCONVENIO',prop:'Visible'},{av:'edtavMigrlegcategoria_var_Visible',ctrl:'vMIGRLEGCATEGORIA_VAR',prop:'Visible'},{av:'edtMigrLegObraSocial_Visible',ctrl:'MIGRLEGOBRASOCIAL',prop:'Visible'},{av:'edtMigrLegCBU_Visible',ctrl:'MIGRLEGCBU',prop:'Visible'},{av:'edtMigrLegModalidad_Visible',ctrl:'MIGRLEGMODALIDAD',prop:'Visible'},{av:'edtMigrLegHorSem_Visible',ctrl:'MIGRLEGHORSEM',prop:'Visible'},{av:'edtMigrLegObs_Visible',ctrl:'MIGRLEGOBS',prop:'Visible'},{av:'edtMigrLegSindicato_Visible',ctrl:'MIGRLEGSINDICATO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'chkavSelected.getTitle()',ctrl:'vSELECTED',prop:'Title'},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'AV96GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV97GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV98GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'},{av:'AV267ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOIMPORTARLEGAJOSALSISTEMA'","{handler:'e20282',iparms:[{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV206SelectedRows',fld:'vSELECTEDROWS',pic:''},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'A626MigrLegId',fld:'MIGRLEGID',pic:''},{av:'A597MigrLegCUIL',fld:'MIGRLEGCUIL',pic:''},{av:'A592MigrLegApellido',fld:'MIGRLEGAPELLIDO',pic:''},{av:'A593MigrLegNombre',fld:'MIGRLEGNOMBRE',pic:''},{av:'A2415MigrLegModTra',fld:'MIGRLEGMODTRA',pic:''},{av:'A2427MigrLegTipoTarifa',fld:'MIGRLEGTIPOTARIFA',pic:''},{av:'A607MigrLegClase',fld:'MIGRLEGCLASE',pic:''},{av:'A594MigrLegFecNac',fld:'MIGRLEGFECNAC',pic:''},{av:'A603MigrLegFecIngreso',fld:'MIGRLEGFECINGRESO',pic:''},{av:'A595MigrLegSexo',fld:'MIGRLEGSEXO',pic:''},{av:'A620MigrLegZona',fld:'MIGRLEGZONA',pic:''},{av:'A599MigrLegDomici',fld:'MIGRLEGDOMICI',pic:''},{av:'A601MigrLegCodPos',fld:'MIGRLEGCODPOS',pic:''},{av:'A602MigrLegTelefono',fld:'MIGRLEGTELEFONO',pic:''},{av:'A600MigrLegEmail',fld:'MIGRLEGEMAIL',pic:''},{av:'A596MigrLegEstadoCivil',fld:'MIGRLEGESTADOCIVIL',pic:''},{av:'A598MigrLegDiscapacidad',fld:'MIGRLEGDISCAPACIDAD',pic:''},{av:'A605MigrLegArea',fld:'MIGRLEGAREA',pic:''},{av:'A608MigrLegBasico',fld:'MIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A627MigrLegConvenio',fld:'MIGRLEGCONVENIO',pic:''},{av:'A604MigrLegCategoria',fld:'MIGRLEGCATEGORIA',pic:''},{av:'AV242MigrLegCategoria_var',fld:'vMIGRLEGCATEGORIA_VAR',pic:'',hsh:true},{av:'A606MigrLegLugarDePago',fld:'MIGRLEGLUGARDEPAGO',pic:'@!'},{av:'A610MigrLegBanco',fld:'MIGRLEGBANCO',pic:''},{av:'A614MigrLegObraSocial',fld:'MIGRLEGOBRASOCIAL',pic:''},{av:'A611MigrLegBanSuc',fld:'MIGRLEGBANSUC',pic:''},{av:'A612MigrLegBanTipCuen',fld:'MIGRLEGBANTIPCUEN',pic:'@!'},{av:'A619MigrLegCuentaBanc',fld:'MIGRLEGCUENTABANC',pic:'@!'},{av:'A609MigrLegFormaPago',fld:'MIGRLEGFORMAPAGO',pic:''},{av:'A621MigrLegCBU',fld:'MIGRLEGCBU',pic:''},{av:'A617MigrLegModalidad',fld:'MIGRLEGMODALIDAD',pic:''},{av:'A2275MigrLegHorSem',fld:'MIGRLEGHORSEM',pic:'Z9.9'},{av:'A616MigrLegActividad',fld:'MIGRLEGACTIVIDAD',pic:''},{av:'A623MigrLegSituacionRevista',fld:'MIGRLEGSITUACIONREVISTA',pic:'@!'},{av:'A624MigrLegCondicion',fld:'MIGRLEGCONDICION',pic:'@!'},{av:'A625MigrLegSiniestrado',fld:'MIGRLEGSINIESTRADO',pic:''},{av:'A622MigrLegSCVO',fld:'MIGRLEGSCVO',pic:''},{av:'A615MigrLegPlanMedico',fld:'MIGRLEGPLANMEDICO',pic:''},{av:'A631MigrTieneConyuge',fld:'MIGRTIENECONYUGE',pic:''},{av:'A632MigrCantidadHijos',fld:'MIGRCANTIDADHIJOS',pic:'ZZZ9'},{av:'A628MigrLegObs',fld:'MIGRLEGOBS',pic:''},{av:'A2190MigrPeriodo',fld:'MIGRPERIODO',pic:''},{av:'A2189MigrSueldos',fld:'MIGRSUELDOS',pic:''},{av:'A2216MigrPuesto',fld:'MIGRPUESTO',pic:''},{av:'A2239MigrLegActLabClas',fld:'MIGRLEGACTLABCLAS',pic:''},{av:'A2240MigrLegPueAfip',fld:'MIGRLEGPUEAFIP',pic:''},{av:'A613MigrLegSindicato',fld:'MIGRLEGSINDICATO',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'}]");
      setEventMetadata("'DOIMPORTARLEGAJOSALSISTEMA'",",oparms:[{av:'Dvelop_confirmpanel_btnimportarlegajosalsistema_Confirmationtext',ctrl:'DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA',prop:'ConfirmationText'},{av:'AV206SelectedRows',fld:'vSELECTEDROWS',pic:''},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV211CliCodColItem',fld:'vCLICODCOLITEM',pic:'ZZZZZ9'},{av:'AV215EmpCodColItem',fld:'vEMPCODCOLITEM',pic:'ZZZ9'},{av:'AV219MigrLegNumeroColItem',fld:'vMIGRLEGNUMEROCOLITEM',pic:'ZZZZZZZ9'},{av:'AV237iconoUpdate',fld:'vICONOUPDATE',pic:''},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV245VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV246ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV247EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA.CLOSE","{handler:'e16282',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV289Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'AV249MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV239TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'chkavSelected.getTitleFormat()',ctrl:'vSELECTED',prop:'Titleformat'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV251WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'Dvelop_confirmpanel_btnimportarlegajosalsistema_Result',ctrl:'DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA',prop:'Result'},{av:'AV206SelectedRows',fld:'vSELECTEDROWS',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'A626MigrLegId',fld:'MIGRLEGID',pic:''},{av:'A597MigrLegCUIL',fld:'MIGRLEGCUIL',pic:''},{av:'A592MigrLegApellido',fld:'MIGRLEGAPELLIDO',pic:''},{av:'A593MigrLegNombre',fld:'MIGRLEGNOMBRE',pic:''},{av:'A2415MigrLegModTra',fld:'MIGRLEGMODTRA',pic:''},{av:'A2427MigrLegTipoTarifa',fld:'MIGRLEGTIPOTARIFA',pic:''},{av:'A607MigrLegClase',fld:'MIGRLEGCLASE',pic:''},{av:'A594MigrLegFecNac',fld:'MIGRLEGFECNAC',pic:''},{av:'A603MigrLegFecIngreso',fld:'MIGRLEGFECINGRESO',pic:''},{av:'A595MigrLegSexo',fld:'MIGRLEGSEXO',pic:''},{av:'A620MigrLegZona',fld:'MIGRLEGZONA',pic:''},{av:'A599MigrLegDomici',fld:'MIGRLEGDOMICI',pic:''},{av:'A601MigrLegCodPos',fld:'MIGRLEGCODPOS',pic:''},{av:'A602MigrLegTelefono',fld:'MIGRLEGTELEFONO',pic:''},{av:'A600MigrLegEmail',fld:'MIGRLEGEMAIL',pic:''},{av:'A596MigrLegEstadoCivil',fld:'MIGRLEGESTADOCIVIL',pic:''},{av:'A598MigrLegDiscapacidad',fld:'MIGRLEGDISCAPACIDAD',pic:''},{av:'A605MigrLegArea',fld:'MIGRLEGAREA',pic:''},{av:'A608MigrLegBasico',fld:'MIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A627MigrLegConvenio',fld:'MIGRLEGCONVENIO',pic:''},{av:'A604MigrLegCategoria',fld:'MIGRLEGCATEGORIA',pic:''},{av:'AV242MigrLegCategoria_var',fld:'vMIGRLEGCATEGORIA_VAR',pic:'',hsh:true},{av:'A606MigrLegLugarDePago',fld:'MIGRLEGLUGARDEPAGO',pic:'@!'},{av:'A610MigrLegBanco',fld:'MIGRLEGBANCO',pic:''},{av:'A614MigrLegObraSocial',fld:'MIGRLEGOBRASOCIAL',pic:''},{av:'A611MigrLegBanSuc',fld:'MIGRLEGBANSUC',pic:''},{av:'A612MigrLegBanTipCuen',fld:'MIGRLEGBANTIPCUEN',pic:'@!'},{av:'A619MigrLegCuentaBanc',fld:'MIGRLEGCUENTABANC',pic:'@!'},{av:'A609MigrLegFormaPago',fld:'MIGRLEGFORMAPAGO',pic:''},{av:'A621MigrLegCBU',fld:'MIGRLEGCBU',pic:''},{av:'A617MigrLegModalidad',fld:'MIGRLEGMODALIDAD',pic:''},{av:'A2275MigrLegHorSem',fld:'MIGRLEGHORSEM',pic:'Z9.9'},{av:'A616MigrLegActividad',fld:'MIGRLEGACTIVIDAD',pic:''},{av:'A623MigrLegSituacionRevista',fld:'MIGRLEGSITUACIONREVISTA',pic:'@!'},{av:'A624MigrLegCondicion',fld:'MIGRLEGCONDICION',pic:'@!'},{av:'A625MigrLegSiniestrado',fld:'MIGRLEGSINIESTRADO',pic:''},{av:'A622MigrLegSCVO',fld:'MIGRLEGSCVO',pic:''},{av:'A615MigrLegPlanMedico',fld:'MIGRLEGPLANMEDICO',pic:''},{av:'A631MigrTieneConyuge',fld:'MIGRTIENECONYUGE',pic:''},{av:'A632MigrCantidadHijos',fld:'MIGRCANTIDADHIJOS',pic:'ZZZ9'},{av:'A628MigrLegObs',fld:'MIGRLEGOBS',pic:''},{av:'A2190MigrPeriodo',fld:'MIGRPERIODO',pic:''},{av:'A2189MigrSueldos',fld:'MIGRSUELDOS',pic:''},{av:'A2216MigrPuesto',fld:'MIGRPUESTO',pic:''},{av:'A2239MigrLegActLabClas',fld:'MIGRLEGACTLABCLAS',pic:''},{av:'A2240MigrLegPueAfip',fld:'MIGRLEGPUEAFIP',pic:''},{av:'A613MigrLegSindicato',fld:'MIGRLEGSINDICATO',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_BTNIMPORTARLEGAJOSALSISTEMA.CLOSE",",oparms:[{av:'AV206SelectedRows',fld:'vSELECTEDROWS',pic:''},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV211CliCodColItem',fld:'vCLICODCOLITEM',pic:'ZZZZZ9'},{av:'AV215EmpCodColItem',fld:'vEMPCODCOLITEM',pic:'ZZZ9'},{av:'AV219MigrLegNumeroColItem',fld:'vMIGRLEGNUMEROCOLITEM',pic:'ZZZZZZZ9'},{av:'AV237iconoUpdate',fld:'vICONOUPDATE',pic:''},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV245VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV246ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV247EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavIconoupdatewithtags_Visible',ctrl:'vICONOUPDATEWITHTAGS',prop:'Visible'},{av:'edtMigrLegId_Visible',ctrl:'MIGRLEGID',prop:'Visible'},{av:'edtMigrLegCUIL_Visible',ctrl:'MIGRLEGCUIL',prop:'Visible'},{av:'edtMigrLegApellido_Visible',ctrl:'MIGRLEGAPELLIDO',prop:'Visible'},{av:'edtMigrLegNombre_Visible',ctrl:'MIGRLEGNOMBRE',prop:'Visible'},{av:'edtMigrLegModTra_Visible',ctrl:'MIGRLEGMODTRA',prop:'Visible'},{av:'edtMigrLegTipoTarifa_Visible',ctrl:'MIGRLEGTIPOTARIFA',prop:'Visible'},{av:'edtMigrLegClase_Visible',ctrl:'MIGRLEGCLASE',prop:'Visible'},{av:'edtMigrLegFecNac_Visible',ctrl:'MIGRLEGFECNAC',prop:'Visible'},{av:'edtMigrLegFecIngreso_Visible',ctrl:'MIGRLEGFECINGRESO',prop:'Visible'},{av:'edtMigrLegSexo_Visible',ctrl:'MIGRLEGSEXO',prop:'Visible'},{av:'edtMigrLegDomici_Visible',ctrl:'MIGRLEGDOMICI',prop:'Visible'},{av:'edtMigrLegCodPos_Visible',ctrl:'MIGRLEGCODPOS',prop:'Visible'},{av:'edtMigrLegTelefono_Visible',ctrl:'MIGRLEGTELEFONO',prop:'Visible'},{av:'edtMigrLegEmail_Visible',ctrl:'MIGRLEGEMAIL',prop:'Visible'},{av:'edtMigrLegEstadoCivil_Visible',ctrl:'MIGRLEGESTADOCIVIL',prop:'Visible'},{av:'edtMigrLegArea_Visible',ctrl:'MIGRLEGAREA',prop:'Visible'},{av:'edtMigrLegBasico_Visible',ctrl:'MIGRLEGBASICO',prop:'Visible'},{av:'edtMigrLegConvenio_Visible',ctrl:'MIGRLEGCONVENIO',prop:'Visible'},{av:'edtavMigrlegcategoria_var_Visible',ctrl:'vMIGRLEGCATEGORIA_VAR',prop:'Visible'},{av:'edtMigrLegObraSocial_Visible',ctrl:'MIGRLEGOBRASOCIAL',prop:'Visible'},{av:'edtMigrLegCBU_Visible',ctrl:'MIGRLEGCBU',prop:'Visible'},{av:'edtMigrLegModalidad_Visible',ctrl:'MIGRLEGMODALIDAD',prop:'Visible'},{av:'edtMigrLegHorSem_Visible',ctrl:'MIGRLEGHORSEM',prop:'Visible'},{av:'edtMigrLegObs_Visible',ctrl:'MIGRLEGOBS',prop:'Visible'},{av:'edtMigrLegSindicato_Visible',ctrl:'MIGRLEGSINDICATO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'chkavSelected.getTitle()',ctrl:'vSELECTED',prop:'Title'},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'AV96GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV97GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV98GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'},{av:'AV267ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("'DOELIMINARTODOS'","{handler:'e21282',iparms:[{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("'DOELIMINARTODOS'",",oparms:[{av:'Dvelop_confirmpanel_btneliminartodos_Confirmationtext',ctrl:'DVELOP_CONFIRMPANEL_BTNELIMINARTODOS',prop:'ConfirmationText'}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_BTNELIMINARTODOS.CLOSE","{handler:'e17282',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV289Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'AV249MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV239TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'chkavSelected.getTitleFormat()',ctrl:'vSELECTED',prop:'Titleformat'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV251WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'Dvelop_confirmpanel_btneliminartodos_Result',ctrl:'DVELOP_CONFIRMPANEL_BTNELIMINARTODOS',prop:'Result'}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_BTNELIMINARTODOS.CLOSE",",oparms:[{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavIconoupdatewithtags_Visible',ctrl:'vICONOUPDATEWITHTAGS',prop:'Visible'},{av:'edtMigrLegId_Visible',ctrl:'MIGRLEGID',prop:'Visible'},{av:'edtMigrLegCUIL_Visible',ctrl:'MIGRLEGCUIL',prop:'Visible'},{av:'edtMigrLegApellido_Visible',ctrl:'MIGRLEGAPELLIDO',prop:'Visible'},{av:'edtMigrLegNombre_Visible',ctrl:'MIGRLEGNOMBRE',prop:'Visible'},{av:'edtMigrLegModTra_Visible',ctrl:'MIGRLEGMODTRA',prop:'Visible'},{av:'edtMigrLegTipoTarifa_Visible',ctrl:'MIGRLEGTIPOTARIFA',prop:'Visible'},{av:'edtMigrLegClase_Visible',ctrl:'MIGRLEGCLASE',prop:'Visible'},{av:'edtMigrLegFecNac_Visible',ctrl:'MIGRLEGFECNAC',prop:'Visible'},{av:'edtMigrLegFecIngreso_Visible',ctrl:'MIGRLEGFECINGRESO',prop:'Visible'},{av:'edtMigrLegSexo_Visible',ctrl:'MIGRLEGSEXO',prop:'Visible'},{av:'edtMigrLegDomici_Visible',ctrl:'MIGRLEGDOMICI',prop:'Visible'},{av:'edtMigrLegCodPos_Visible',ctrl:'MIGRLEGCODPOS',prop:'Visible'},{av:'edtMigrLegTelefono_Visible',ctrl:'MIGRLEGTELEFONO',prop:'Visible'},{av:'edtMigrLegEmail_Visible',ctrl:'MIGRLEGEMAIL',prop:'Visible'},{av:'edtMigrLegEstadoCivil_Visible',ctrl:'MIGRLEGESTADOCIVIL',prop:'Visible'},{av:'edtMigrLegArea_Visible',ctrl:'MIGRLEGAREA',prop:'Visible'},{av:'edtMigrLegBasico_Visible',ctrl:'MIGRLEGBASICO',prop:'Visible'},{av:'edtMigrLegConvenio_Visible',ctrl:'MIGRLEGCONVENIO',prop:'Visible'},{av:'edtavMigrlegcategoria_var_Visible',ctrl:'vMIGRLEGCATEGORIA_VAR',prop:'Visible'},{av:'edtMigrLegObraSocial_Visible',ctrl:'MIGRLEGOBRASOCIAL',prop:'Visible'},{av:'edtMigrLegCBU_Visible',ctrl:'MIGRLEGCBU',prop:'Visible'},{av:'edtMigrLegModalidad_Visible',ctrl:'MIGRLEGMODALIDAD',prop:'Visible'},{av:'edtMigrLegHorSem_Visible',ctrl:'MIGRLEGHORSEM',prop:'Visible'},{av:'edtMigrLegObs_Visible',ctrl:'MIGRLEGOBS',prop:'Visible'},{av:'edtMigrLegSindicato_Visible',ctrl:'MIGRLEGSINDICATO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'chkavSelected.getTitle()',ctrl:'vSELECTED',prop:'Title'},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'AV96GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV97GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV98GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'},{av:'AV267ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("'DOIMPORTARTODOS'","{handler:'e22282',iparms:[{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("'DOIMPORTARTODOS'",",oparms:[]}");
      setEventMetadata("VELIMINAR.CLICK","{handler:'e30282',iparms:[{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VELIMINAR.CLICK",",oparms:[{av:'Dvelop_confirmpanel_eliminar_Confirmationtext',ctrl:'DVELOP_CONFIRMPANEL_ELIMINAR',prop:'ConfirmationText'},{av:'AV234CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV235EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV236MigrLegNumero_Selected',fld:'vMIGRLEGNUMERO_SELECTED',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE","{handler:'e18282',iparms:[{av:'Dvelop_confirmpanel_eliminar_Result',ctrl:'DVELOP_CONFIRMPANEL_ELIMINAR',prop:'Result'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV289Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'AV249MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV239TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'chkavSelected.getTitleFormat()',ctrl:'vSELECTED',prop:'Titleformat'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV251WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'AV234CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV235EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV236MigrLegNumero_Selected',fld:'vMIGRLEGNUMERO_SELECTED',pic:'ZZZZZZZ9'}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE",",oparms:[{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavIconoupdatewithtags_Visible',ctrl:'vICONOUPDATEWITHTAGS',prop:'Visible'},{av:'edtMigrLegId_Visible',ctrl:'MIGRLEGID',prop:'Visible'},{av:'edtMigrLegCUIL_Visible',ctrl:'MIGRLEGCUIL',prop:'Visible'},{av:'edtMigrLegApellido_Visible',ctrl:'MIGRLEGAPELLIDO',prop:'Visible'},{av:'edtMigrLegNombre_Visible',ctrl:'MIGRLEGNOMBRE',prop:'Visible'},{av:'edtMigrLegModTra_Visible',ctrl:'MIGRLEGMODTRA',prop:'Visible'},{av:'edtMigrLegTipoTarifa_Visible',ctrl:'MIGRLEGTIPOTARIFA',prop:'Visible'},{av:'edtMigrLegClase_Visible',ctrl:'MIGRLEGCLASE',prop:'Visible'},{av:'edtMigrLegFecNac_Visible',ctrl:'MIGRLEGFECNAC',prop:'Visible'},{av:'edtMigrLegFecIngreso_Visible',ctrl:'MIGRLEGFECINGRESO',prop:'Visible'},{av:'edtMigrLegSexo_Visible',ctrl:'MIGRLEGSEXO',prop:'Visible'},{av:'edtMigrLegDomici_Visible',ctrl:'MIGRLEGDOMICI',prop:'Visible'},{av:'edtMigrLegCodPos_Visible',ctrl:'MIGRLEGCODPOS',prop:'Visible'},{av:'edtMigrLegTelefono_Visible',ctrl:'MIGRLEGTELEFONO',prop:'Visible'},{av:'edtMigrLegEmail_Visible',ctrl:'MIGRLEGEMAIL',prop:'Visible'},{av:'edtMigrLegEstadoCivil_Visible',ctrl:'MIGRLEGESTADOCIVIL',prop:'Visible'},{av:'edtMigrLegArea_Visible',ctrl:'MIGRLEGAREA',prop:'Visible'},{av:'edtMigrLegBasico_Visible',ctrl:'MIGRLEGBASICO',prop:'Visible'},{av:'edtMigrLegConvenio_Visible',ctrl:'MIGRLEGCONVENIO',prop:'Visible'},{av:'edtavMigrlegcategoria_var_Visible',ctrl:'vMIGRLEGCATEGORIA_VAR',prop:'Visible'},{av:'edtMigrLegObraSocial_Visible',ctrl:'MIGRLEGOBRASOCIAL',prop:'Visible'},{av:'edtMigrLegCBU_Visible',ctrl:'MIGRLEGCBU',prop:'Visible'},{av:'edtMigrLegModalidad_Visible',ctrl:'MIGRLEGMODALIDAD',prop:'Visible'},{av:'edtMigrLegHorSem_Visible',ctrl:'MIGRLEGHORSEM',prop:'Visible'},{av:'edtMigrLegObs_Visible',ctrl:'MIGRLEGOBS',prop:'Visible'},{av:'edtMigrLegSindicato_Visible',ctrl:'MIGRLEGSINDICATO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'chkavSelected.getTitle()',ctrl:'vSELECTED',prop:'Title'},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'AV96GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV97GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV98GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'},{av:'AV267ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("'DOGENERARTEMPLATE'","{handler:'e23282',iparms:[{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("'DOGENERARTEMPLATE'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'}]}");
      setEventMetadata("'DOIMPORTEXCEL'","{handler:'e33281',iparms:[]");
      setEventMetadata("'DOIMPORTEXCEL'",",oparms:[]}");
      setEventMetadata("IMPORTEXCEL_MODAL.CLOSE","{handler:'e19282',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV289Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'AV249MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV239TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'chkavSelected.getTitleFormat()',ctrl:'vSELECTED',prop:'Titleformat'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV251WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'Importexcel_modal_Result',ctrl:'IMPORTEXCEL_MODAL',prop:'Result'}]");
      setEventMetadata("IMPORTEXCEL_MODAL.CLOSE",",oparms:[{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'lblJs_Caption',ctrl:'JS',prop:'Caption'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavIconoupdatewithtags_Visible',ctrl:'vICONOUPDATEWITHTAGS',prop:'Visible'},{av:'edtMigrLegId_Visible',ctrl:'MIGRLEGID',prop:'Visible'},{av:'edtMigrLegCUIL_Visible',ctrl:'MIGRLEGCUIL',prop:'Visible'},{av:'edtMigrLegApellido_Visible',ctrl:'MIGRLEGAPELLIDO',prop:'Visible'},{av:'edtMigrLegNombre_Visible',ctrl:'MIGRLEGNOMBRE',prop:'Visible'},{av:'edtMigrLegModTra_Visible',ctrl:'MIGRLEGMODTRA',prop:'Visible'},{av:'edtMigrLegTipoTarifa_Visible',ctrl:'MIGRLEGTIPOTARIFA',prop:'Visible'},{av:'edtMigrLegClase_Visible',ctrl:'MIGRLEGCLASE',prop:'Visible'},{av:'edtMigrLegFecNac_Visible',ctrl:'MIGRLEGFECNAC',prop:'Visible'},{av:'edtMigrLegFecIngreso_Visible',ctrl:'MIGRLEGFECINGRESO',prop:'Visible'},{av:'edtMigrLegSexo_Visible',ctrl:'MIGRLEGSEXO',prop:'Visible'},{av:'edtMigrLegDomici_Visible',ctrl:'MIGRLEGDOMICI',prop:'Visible'},{av:'edtMigrLegCodPos_Visible',ctrl:'MIGRLEGCODPOS',prop:'Visible'},{av:'edtMigrLegTelefono_Visible',ctrl:'MIGRLEGTELEFONO',prop:'Visible'},{av:'edtMigrLegEmail_Visible',ctrl:'MIGRLEGEMAIL',prop:'Visible'},{av:'edtMigrLegEstadoCivil_Visible',ctrl:'MIGRLEGESTADOCIVIL',prop:'Visible'},{av:'edtMigrLegArea_Visible',ctrl:'MIGRLEGAREA',prop:'Visible'},{av:'edtMigrLegBasico_Visible',ctrl:'MIGRLEGBASICO',prop:'Visible'},{av:'edtMigrLegConvenio_Visible',ctrl:'MIGRLEGCONVENIO',prop:'Visible'},{av:'edtavMigrlegcategoria_var_Visible',ctrl:'vMIGRLEGCATEGORIA_VAR',prop:'Visible'},{av:'edtMigrLegObraSocial_Visible',ctrl:'MIGRLEGOBRASOCIAL',prop:'Visible'},{av:'edtMigrLegCBU_Visible',ctrl:'MIGRLEGCBU',prop:'Visible'},{av:'edtMigrLegModalidad_Visible',ctrl:'MIGRLEGMODALIDAD',prop:'Visible'},{av:'edtMigrLegHorSem_Visible',ctrl:'MIGRLEGHORSEM',prop:'Visible'},{av:'edtMigrLegObs_Visible',ctrl:'MIGRLEGOBS',prop:'Visible'},{av:'edtMigrLegSindicato_Visible',ctrl:'MIGRLEGSINDICATO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'chkavSelected.getTitle()',ctrl:'vSELECTED',prop:'Title'},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'AV96GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV97GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV98GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'},{av:'AV267ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("VSELECTALL.CLICK","{handler:'e24282',iparms:[{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV239TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'A3CliCod',fld:'CLICOD',grid:97,pic:'ZZZZZ9'},{av:'GRID_nFirstRecordOnPage'},{av:'nRC_GXsfl_97',ctrl:'GRID',grid:97,prop:'GridRC',grid:97},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',grid:97,pic:'ZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',grid:97,pic:'ZZZZZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''}]");
      setEventMetadata("VSELECTALL.CLICK",",oparms:[{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV205Selected',fld:'vSELECTED',pic:''},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'divLayoutmaintable_Class',ctrl:'LAYOUTMAINTABLE',prop:'Class'}]}");
      setEventMetadata("VDETAILWEBCOMPONENT.CLICK","{handler:'e35282',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VDETAILWEBCOMPONENT.CLICK",",oparms:[{ctrl:'GRID_DWC'}]}");
      setEventMetadata("VICONOUPDATE.CLICK","{handler:'e34282',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VICONOUPDATE.CLICK",",oparms:[{ctrl:'WWPAUX_WC'}]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e25282',iparms:[{av:'AV251WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV249MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e32281',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("GLOBALEVENTS.IMPORTARLEGAJOSEXCEL","{handler:'e26282',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV289Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV210CliCodJson',fld:'vCLICODJSON',pic:''},{av:'AV214EmpCodJson',fld:'vEMPCODJSON',pic:''},{av:'AV218MigrLegNumeroJson',fld:'vMIGRLEGNUMEROJSON',pic:''},{av:'AV249MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV239TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV240TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV108TFMigrLegId',fld:'vTFMIGRLEGID',pic:''},{av:'AV109TFMigrLegId_Sels',fld:'vTFMIGRLEGID_SELS',pic:''},{av:'AV43TFMigrLegCUIL',fld:'vTFMIGRLEGCUIL',pic:''},{av:'AV44TFMigrLegCUIL_Sels',fld:'vTFMIGRLEGCUIL_SELS',pic:''},{av:'AV26TFMigrLegApellido',fld:'vTFMIGRLEGAPELLIDO',pic:''},{av:'AV27TFMigrLegApellido_Sels',fld:'vTFMIGRLEGAPELLIDO_SELS',pic:''},{av:'AV29TFMigrLegNombre',fld:'vTFMIGRLEGNOMBRE',pic:''},{av:'AV30TFMigrLegNombre_Sels',fld:'vTFMIGRLEGNOMBRE_SELS',pic:''},{av:'AV281TFMigrLegModTra',fld:'vTFMIGRLEGMODTRA',pic:''},{av:'AV282TFMigrLegModTra_Sels',fld:'vTFMIGRLEGMODTRA_SELS',pic:''},{av:'AV284TFMigrLegTipoTarifa',fld:'vTFMIGRLEGTIPOTARIFA',pic:''},{av:'AV285TFMigrLegTipoTarifa_Sels',fld:'vTFMIGRLEGTIPOTARIFA_SELS',pic:''},{av:'AV75TFMigrLegClase',fld:'vTFMIGRLEGCLASE',pic:''},{av:'AV76TFMigrLegClase_Sels',fld:'vTFMIGRLEGCLASE_SELS',pic:''},{av:'AV31TFMigrLegFecNac',fld:'vTFMIGRLEGFECNAC',pic:''},{av:'AV32TFMigrLegFecNac_To',fld:'vTFMIGRLEGFECNAC_TO',pic:''},{av:'AV60TFMigrLegFecIngreso',fld:'vTFMIGRLEGFECINGRESO',pic:''},{av:'AV61TFMigrLegFecIngreso_To',fld:'vTFMIGRLEGFECINGRESO_TO',pic:''},{av:'AV37TFMigrLegSexo',fld:'vTFMIGRLEGSEXO',pic:''},{av:'AV38TFMigrLegSexo_Sels',fld:'vTFMIGRLEGSEXO_SELS',pic:''},{av:'AV49TFMigrLegDomici',fld:'vTFMIGRLEGDOMICI',pic:''},{av:'AV50TFMigrLegDomici_Sels',fld:'vTFMIGRLEGDOMICI_SELS',pic:''},{av:'AV55TFMigrLegCodPos',fld:'vTFMIGRLEGCODPOS',pic:''},{av:'AV56TFMigrLegCodPos_Sels',fld:'vTFMIGRLEGCODPOS_SELS',pic:''},{av:'AV58TFMigrLegTelefono',fld:'vTFMIGRLEGTELEFONO',pic:''},{av:'AV59TFMigrLegTelefono_Sels',fld:'vTFMIGRLEGTELEFONO_SELS',pic:''},{av:'AV52TFMigrLegEmail',fld:'vTFMIGRLEGEMAIL',pic:''},{av:'AV53TFMigrLegEmail_Sels',fld:'vTFMIGRLEGEMAIL_SELS',pic:''},{av:'AV40TFMigrLegEstadoCivil',fld:'vTFMIGRLEGESTADOCIVIL',pic:''},{av:'AV41TFMigrLegEstadoCivil_Sels',fld:'vTFMIGRLEGESTADOCIVIL_SELS',pic:''},{av:'AV69TFMigrLegArea',fld:'vTFMIGRLEGAREA',pic:''},{av:'AV70TFMigrLegArea_Sels',fld:'vTFMIGRLEGAREA_SELS',pic:''},{av:'AV77TFMigrLegBasico',fld:'vTFMIGRLEGBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFMigrLegBasico_To',fld:'vTFMIGRLEGBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV120TFMigrLegConvenio',fld:'vTFMIGRLEGCONVENIO',pic:''},{av:'AV121TFMigrLegConvenio_Sels',fld:'vTFMIGRLEGCONVENIO_SELS',pic:''},{av:'AV137TFMigrLegObraSocial',fld:'vTFMIGRLEGOBRASOCIAL',pic:''},{av:'AV138TFMigrLegObraSocial_Sels',fld:'vTFMIGRLEGOBRASOCIAL_SELS',pic:''},{av:'AV114TFMigrLegCBU',fld:'vTFMIGRLEGCBU',pic:''},{av:'AV115TFMigrLegCBU_Sels',fld:'vTFMIGRLEGCBU_SELS',pic:''},{av:'AV134TFMigrLegModalidad',fld:'vTFMIGRLEGMODALIDAD',pic:''},{av:'AV135TFMigrLegModalidad_Sels',fld:'vTFMIGRLEGMODALIDAD_SELS',pic:''},{av:'AV270TFMigrLegHorSem',fld:'vTFMIGRLEGHORSEM',pic:'Z9.9'},{av:'AV271TFMigrLegHorSem_To',fld:'vTFMIGRLEGHORSEM_TO',pic:'Z9.9'},{av:'AV140TFMigrLegObs',fld:'vTFMIGRLEGOBS',pic:''},{av:'AV141TFMigrLegObs_Sels',fld:'vTFMIGRLEGOBS_SELS',pic:''},{av:'AV92TFMigrLegSindicato',fld:'vTFMIGRLEGSINDICATO',pic:''},{av:'AV93TFMigrLegSindicato_Sels',fld:'vTFMIGRLEGSINDICATO_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'chkavSelected.getTitleFormat()',ctrl:'vSELECTED',prop:'Titleformat'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV208i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV212CliCodToFind',fld:'vCLICODTOFIND',pic:'ZZZZZ9'},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV216EmpCodToFind',fld:'vEMPCODTOFIND',pic:'ZZZ9'},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'AV220MigrLegNumeroToFind',fld:'vMIGRLEGNUMEROTOFIND',pic:'ZZZZZZZ9'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV251WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'AV259mensajeTexto',fld:'vMENSAJETEXTO',pic:''}]");
      setEventMetadata("GLOBALEVENTS.IMPORTARLEGAJOSEXCEL",",oparms:[{av:'lblJs_Caption',ctrl:'JS',prop:'Caption'},{av:'AV105EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV104CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV269ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavIconoupdatewithtags_Visible',ctrl:'vICONOUPDATEWITHTAGS',prop:'Visible'},{av:'edtMigrLegId_Visible',ctrl:'MIGRLEGID',prop:'Visible'},{av:'edtMigrLegCUIL_Visible',ctrl:'MIGRLEGCUIL',prop:'Visible'},{av:'edtMigrLegApellido_Visible',ctrl:'MIGRLEGAPELLIDO',prop:'Visible'},{av:'edtMigrLegNombre_Visible',ctrl:'MIGRLEGNOMBRE',prop:'Visible'},{av:'edtMigrLegModTra_Visible',ctrl:'MIGRLEGMODTRA',prop:'Visible'},{av:'edtMigrLegTipoTarifa_Visible',ctrl:'MIGRLEGTIPOTARIFA',prop:'Visible'},{av:'edtMigrLegClase_Visible',ctrl:'MIGRLEGCLASE',prop:'Visible'},{av:'edtMigrLegFecNac_Visible',ctrl:'MIGRLEGFECNAC',prop:'Visible'},{av:'edtMigrLegFecIngreso_Visible',ctrl:'MIGRLEGFECINGRESO',prop:'Visible'},{av:'edtMigrLegSexo_Visible',ctrl:'MIGRLEGSEXO',prop:'Visible'},{av:'edtMigrLegDomici_Visible',ctrl:'MIGRLEGDOMICI',prop:'Visible'},{av:'edtMigrLegCodPos_Visible',ctrl:'MIGRLEGCODPOS',prop:'Visible'},{av:'edtMigrLegTelefono_Visible',ctrl:'MIGRLEGTELEFONO',prop:'Visible'},{av:'edtMigrLegEmail_Visible',ctrl:'MIGRLEGEMAIL',prop:'Visible'},{av:'edtMigrLegEstadoCivil_Visible',ctrl:'MIGRLEGESTADOCIVIL',prop:'Visible'},{av:'edtMigrLegArea_Visible',ctrl:'MIGRLEGAREA',prop:'Visible'},{av:'edtMigrLegBasico_Visible',ctrl:'MIGRLEGBASICO',prop:'Visible'},{av:'edtMigrLegConvenio_Visible',ctrl:'MIGRLEGCONVENIO',prop:'Visible'},{av:'edtavMigrlegcategoria_var_Visible',ctrl:'vMIGRLEGCATEGORIA_VAR',prop:'Visible'},{av:'edtMigrLegObraSocial_Visible',ctrl:'MIGRLEGOBRASOCIAL',prop:'Visible'},{av:'edtMigrLegCBU_Visible',ctrl:'MIGRLEGCBU',prop:'Visible'},{av:'edtMigrLegModalidad_Visible',ctrl:'MIGRLEGMODALIDAD',prop:'Visible'},{av:'edtMigrLegHorSem_Visible',ctrl:'MIGRLEGHORSEM',prop:'Visible'},{av:'edtMigrLegObs_Visible',ctrl:'MIGRLEGOBS',prop:'Visible'},{av:'edtMigrLegSindicato_Visible',ctrl:'MIGRLEGSINDICATO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'chkavSelected.getTitle()',ctrl:'vSELECTED',prop:'Title'},{av:'AV221SelectAll',fld:'vSELECTALL',pic:''},{av:'AV96GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV97GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV98GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV209CliCodCol',fld:'vCLICODCOL',pic:''},{av:'AV213EmpCodCol',fld:'vEMPCODCOL',pic:''},{av:'AV217MigrLegNumeroCol',fld:'vMIGRLEGNUMEROCOL',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV100IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV102IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'},{av:'AV267ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''}]}");
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
                  new web.importarlegajoexcel(remoteHandle, submitContext).execute( ((Number) submitParms[0]).intValue(), ((Number) submitParms[1]).shortValue(), (String)submitParms[2]) ;
                  try { Application.getConnectionManager().disconnect(remoteHandle); } catch(Exception submitExc) { ; }
                  break;
               case 2 :
                  new web.importararchivolsdparalegajos(remoteHandle, submitContext).execute( ((Number) submitParms[0]).intValue(), ((Number) submitParms[1]).shortValue(), (short)(((Number) submitParms[2]).intValue()), (String)submitParms[3]) ;
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
      wcpOAV249MenuOpcCod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Selectedcolumnfixedfilter = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      Dvelop_confirmpanel_btnimportarlegajosalsistema_Result = "" ;
      Dvelop_confirmpanel_btneliminartodos_Result = "" ;
      Dvelop_confirmpanel_eliminar_Result = "" ;
      Importexcel_modal_Result = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV249MenuOpcCod = "" ;
      AV22ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV289Pgmname = "" ;
      AV210CliCodJson = "" ;
      AV214EmpCodJson = "" ;
      AV218MigrLegNumeroJson = "" ;
      AV13GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV239TFiconoUpdate = "" ;
      AV108TFMigrLegId = "" ;
      AV109TFMigrLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFMigrLegCUIL = "" ;
      AV44TFMigrLegCUIL_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26TFMigrLegApellido = "" ;
      AV27TFMigrLegApellido_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29TFMigrLegNombre = "" ;
      AV30TFMigrLegNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV281TFMigrLegModTra = "" ;
      AV282TFMigrLegModTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV284TFMigrLegTipoTarifa = "" ;
      AV285TFMigrLegTipoTarifa_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV75TFMigrLegClase = "" ;
      AV76TFMigrLegClase_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31TFMigrLegFecNac = GXutil.nullDate() ;
      AV32TFMigrLegFecNac_To = GXutil.nullDate() ;
      AV60TFMigrLegFecIngreso = GXutil.nullDate() ;
      AV61TFMigrLegFecIngreso_To = GXutil.nullDate() ;
      AV37TFMigrLegSexo = "" ;
      AV38TFMigrLegSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFMigrLegDomici = "" ;
      AV50TFMigrLegDomici_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55TFMigrLegCodPos = "" ;
      AV56TFMigrLegCodPos_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58TFMigrLegTelefono = "" ;
      AV59TFMigrLegTelefono_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFMigrLegEmail = "" ;
      AV53TFMigrLegEmail_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFMigrLegEstadoCivil = "" ;
      AV41TFMigrLegEstadoCivil_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69TFMigrLegArea = "" ;
      AV70TFMigrLegArea_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77TFMigrLegBasico = DecimalUtil.ZERO ;
      AV78TFMigrLegBasico_To = DecimalUtil.ZERO ;
      AV120TFMigrLegConvenio = "" ;
      AV121TFMigrLegConvenio_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV137TFMigrLegObraSocial = "" ;
      AV138TFMigrLegObraSocial_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV114TFMigrLegCBU = "" ;
      AV115TFMigrLegCBU_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV134TFMigrLegModalidad = "" ;
      AV135TFMigrLegModalidad_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV270TFMigrLegHorSem = DecimalUtil.ZERO ;
      AV271TFMigrLegHorSem_To = DecimalUtil.ZERO ;
      AV140TFMigrLegObs = "" ;
      AV141TFMigrLegObs_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV92TFMigrLegSindicato = "" ;
      AV93TFMigrLegSindicato_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV209CliCodCol = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV213EmpCodCol = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV217MigrLegNumeroCol = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV267ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV94DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV98GridAppliedFilters = "" ;
      AV33DDO_MigrLegFecNacAuxDate = GXutil.nullDate() ;
      AV34DDO_MigrLegFecNacAuxDateTo = GXutil.nullDate() ;
      AV62DDO_MigrLegFecIngresoAuxDate = GXutil.nullDate() ;
      AV63DDO_MigrLegFecIngresoAuxDateTo = GXutil.nullDate() ;
      A629MigrLegErrores = "" ;
      A633MigrLegWarnings = "" ;
      AV107TFMigrLegId_SelsJson = "" ;
      AV42TFMigrLegCUIL_SelsJson = "" ;
      AV25TFMigrLegApellido_SelsJson = "" ;
      AV28TFMigrLegNombre_SelsJson = "" ;
      AV280TFMigrLegModTra_SelsJson = "" ;
      AV283TFMigrLegTipoTarifa_SelsJson = "" ;
      AV74TFMigrLegClase_SelsJson = "" ;
      AV36TFMigrLegSexo_SelsJson = "" ;
      AV48TFMigrLegDomici_SelsJson = "" ;
      AV54TFMigrLegCodPos_SelsJson = "" ;
      AV57TFMigrLegTelefono_SelsJson = "" ;
      AV51TFMigrLegEmail_SelsJson = "" ;
      AV39TFMigrLegEstadoCivil_SelsJson = "" ;
      AV68TFMigrLegArea_SelsJson = "" ;
      AV119TFMigrLegConvenio_SelsJson = "" ;
      AV136TFMigrLegObraSocial_SelsJson = "" ;
      AV113TFMigrLegCBU_SelsJson = "" ;
      AV133TFMigrLegModalidad_SelsJson = "" ;
      AV139TFMigrLegObs_SelsJson = "" ;
      AV91TFMigrLegSindicato_SelsJson = "" ;
      AV206SelectedRows = new GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>(web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem.class, "importacion_legajoWWSDTItem", "PayDay", remoteHandle);
      AV259mensajeTexto = "" ;
      AV8ExtraParms = new GXSimpleCollection<String>(String.class, "internal", "");
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
      Popover_iconoupdate_Gridinternalname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Ddo_grid_Selectedfixedfilter = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucPopover_iconoupdate = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      WebComp_Wwpaux_wc_Component = "" ;
      OldWwpaux_wc = "" ;
      AV35DDO_MigrLegFecNacAuxDateText = "" ;
      ucTfmigrlegfecnac_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV64DDO_MigrLegFecIngresoAuxDateText = "" ;
      ucTfmigrlegfecingreso_rangepicker = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV238iconoUpdateWithTags = "" ;
      AV237iconoUpdate = "" ;
      AV233Eliminar = "" ;
      A626MigrLegId = "" ;
      A597MigrLegCUIL = "" ;
      A592MigrLegApellido = "" ;
      A593MigrLegNombre = "" ;
      A2415MigrLegModTra = "" ;
      A2427MigrLegTipoTarifa = "" ;
      A607MigrLegClase = "" ;
      A594MigrLegFecNac = GXutil.nullDate() ;
      A603MigrLegFecIngreso = GXutil.nullDate() ;
      A595MigrLegSexo = "" ;
      A620MigrLegZona = "" ;
      A599MigrLegDomici = "" ;
      A601MigrLegCodPos = "" ;
      A602MigrLegTelefono = "" ;
      A600MigrLegEmail = "" ;
      A596MigrLegEstadoCivil = "" ;
      A598MigrLegDiscapacidad = "" ;
      A605MigrLegArea = "" ;
      A608MigrLegBasico = DecimalUtil.ZERO ;
      A627MigrLegConvenio = "" ;
      AV242MigrLegCategoria_var = "" ;
      A604MigrLegCategoria = "" ;
      A606MigrLegLugarDePago = "" ;
      A610MigrLegBanco = "" ;
      A614MigrLegObraSocial = "" ;
      A611MigrLegBanSuc = "" ;
      A612MigrLegBanTipCuen = "" ;
      A619MigrLegCuentaBanc = "" ;
      A609MigrLegFormaPago = "" ;
      A621MigrLegCBU = "" ;
      A617MigrLegModalidad = "" ;
      A2275MigrLegHorSem = DecimalUtil.ZERO ;
      A616MigrLegActividad = "" ;
      A623MigrLegSituacionRevista = "" ;
      A624MigrLegCondicion = "" ;
      A625MigrLegSiniestrado = "" ;
      A622MigrLegSCVO = "" ;
      A615MigrLegPlanMedico = "" ;
      A631MigrTieneConyuge = "" ;
      A628MigrLegObs = "" ;
      A2190MigrPeriodo = GXutil.nullDate() ;
      A2189MigrSueldos = "" ;
      A2216MigrPuesto = "" ;
      A2239MigrLegActLabClas = "" ;
      A2240MigrLegPueAfip = "" ;
      A613MigrLegSindicato = "" ;
      AV248Display = "" ;
      AV99Update = "" ;
      AV101Delete = "" ;
      AV262DetailWebComponent = "" ;
      AV245VerSVG = "" ;
      AV246ModificarSVG = "" ;
      AV247EliminarSVG = "" ;
      OldGrid_dwc = "" ;
      WebComp_Grid_dwc_Component = "" ;
      AV293Importacion_legajowwds_4_tfmigrlegid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV295Importacion_legajowwds_6_tfmigrlegcuil_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV297Importacion_legajowwds_8_tfmigrlegapellido_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV299Importacion_legajowwds_10_tfmigrlegnombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV305Importacion_legajowwds_16_tfmigrlegclase_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV311Importacion_legajowwds_22_tfmigrlegsexo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV313Importacion_legajowwds_24_tfmigrlegdomici_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV319Importacion_legajowwds_30_tfmigrlegemail_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV323Importacion_legajowwds_34_tfmigrlegarea_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV331Importacion_legajowwds_42_tfmigrlegcbu_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV337Importacion_legajowwds_48_tfmigrlegobs_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV292Importacion_legajowwds_3_tfmigrlegid = "" ;
      lV294Importacion_legajowwds_5_tfmigrlegcuil = "" ;
      lV296Importacion_legajowwds_7_tfmigrlegapellido = "" ;
      lV298Importacion_legajowwds_9_tfmigrlegnombre = "" ;
      lV300Importacion_legajowwds_11_tfmigrlegmodtra = "" ;
      lV302Importacion_legajowwds_13_tfmigrlegtipotarifa = "" ;
      lV304Importacion_legajowwds_15_tfmigrlegclase = "" ;
      lV310Importacion_legajowwds_21_tfmigrlegsexo = "" ;
      lV312Importacion_legajowwds_23_tfmigrlegdomici = "" ;
      lV314Importacion_legajowwds_25_tfmigrlegcodpos = "" ;
      lV316Importacion_legajowwds_27_tfmigrlegtelefono = "" ;
      lV318Importacion_legajowwds_29_tfmigrlegemail = "" ;
      lV320Importacion_legajowwds_31_tfmigrlegestadocivil = "" ;
      lV322Importacion_legajowwds_33_tfmigrlegarea = "" ;
      lV326Importacion_legajowwds_37_tfmigrlegconvenio = "" ;
      lV328Importacion_legajowwds_39_tfmigrlegobrasocial = "" ;
      lV330Importacion_legajowwds_41_tfmigrlegcbu = "" ;
      lV332Importacion_legajowwds_43_tfmigrlegmodalidad = "" ;
      lV336Importacion_legajowwds_47_tfmigrlegobs = "" ;
      lV338Importacion_legajowwds_49_tfmigrlegsindicato = "" ;
      AV292Importacion_legajowwds_3_tfmigrlegid = "" ;
      AV294Importacion_legajowwds_5_tfmigrlegcuil = "" ;
      AV296Importacion_legajowwds_7_tfmigrlegapellido = "" ;
      AV298Importacion_legajowwds_9_tfmigrlegnombre = "" ;
      AV300Importacion_legajowwds_11_tfmigrlegmodtra = "" ;
      AV302Importacion_legajowwds_13_tfmigrlegtipotarifa = "" ;
      AV304Importacion_legajowwds_15_tfmigrlegclase = "" ;
      AV306Importacion_legajowwds_17_tfmigrlegfecnac = GXutil.nullDate() ;
      AV307Importacion_legajowwds_18_tfmigrlegfecnac_to = GXutil.nullDate() ;
      AV308Importacion_legajowwds_19_tfmigrlegfecingreso = GXutil.nullDate() ;
      AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to = GXutil.nullDate() ;
      AV310Importacion_legajowwds_21_tfmigrlegsexo = "" ;
      AV312Importacion_legajowwds_23_tfmigrlegdomici = "" ;
      AV314Importacion_legajowwds_25_tfmigrlegcodpos = "" ;
      AV316Importacion_legajowwds_27_tfmigrlegtelefono = "" ;
      AV318Importacion_legajowwds_29_tfmigrlegemail = "" ;
      AV320Importacion_legajowwds_31_tfmigrlegestadocivil = "" ;
      AV322Importacion_legajowwds_33_tfmigrlegarea = "" ;
      AV324Importacion_legajowwds_35_tfmigrlegbasico = DecimalUtil.ZERO ;
      AV325Importacion_legajowwds_36_tfmigrlegbasico_to = DecimalUtil.ZERO ;
      AV326Importacion_legajowwds_37_tfmigrlegconvenio = "" ;
      AV328Importacion_legajowwds_39_tfmigrlegobrasocial = "" ;
      AV330Importacion_legajowwds_41_tfmigrlegcbu = "" ;
      AV332Importacion_legajowwds_43_tfmigrlegmodalidad = "" ;
      AV334Importacion_legajowwds_45_tfmigrleghorsem = DecimalUtil.ZERO ;
      AV335Importacion_legajowwds_46_tfmigrleghorsem_to = DecimalUtil.ZERO ;
      AV336Importacion_legajowwds_47_tfmigrlegobs = "" ;
      AV338Importacion_legajowwds_49_tfmigrlegsindicato = "" ;
      H00282_A629MigrLegErrores = new String[] {""} ;
      H00282_A633MigrLegWarnings = new String[] {""} ;
      H00282_A613MigrLegSindicato = new String[] {""} ;
      H00282_A2240MigrLegPueAfip = new String[] {""} ;
      H00282_A2239MigrLegActLabClas = new String[] {""} ;
      H00282_A2216MigrPuesto = new String[] {""} ;
      H00282_A2189MigrSueldos = new String[] {""} ;
      H00282_A2190MigrPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      H00282_A628MigrLegObs = new String[] {""} ;
      H00282_A632MigrCantidadHijos = new short[1] ;
      H00282_A631MigrTieneConyuge = new String[] {""} ;
      H00282_A615MigrLegPlanMedico = new String[] {""} ;
      H00282_A622MigrLegSCVO = new String[] {""} ;
      H00282_A625MigrLegSiniestrado = new String[] {""} ;
      H00282_A624MigrLegCondicion = new String[] {""} ;
      H00282_A623MigrLegSituacionRevista = new String[] {""} ;
      H00282_A616MigrLegActividad = new String[] {""} ;
      H00282_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00282_A617MigrLegModalidad = new String[] {""} ;
      H00282_A621MigrLegCBU = new String[] {""} ;
      H00282_A609MigrLegFormaPago = new String[] {""} ;
      H00282_A619MigrLegCuentaBanc = new String[] {""} ;
      H00282_A612MigrLegBanTipCuen = new String[] {""} ;
      H00282_A611MigrLegBanSuc = new String[] {""} ;
      H00282_A614MigrLegObraSocial = new String[] {""} ;
      H00282_A610MigrLegBanco = new String[] {""} ;
      H00282_A606MigrLegLugarDePago = new String[] {""} ;
      H00282_A604MigrLegCategoria = new String[] {""} ;
      H00282_A627MigrLegConvenio = new String[] {""} ;
      H00282_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00282_A605MigrLegArea = new String[] {""} ;
      H00282_A598MigrLegDiscapacidad = new String[] {""} ;
      H00282_A596MigrLegEstadoCivil = new String[] {""} ;
      H00282_A600MigrLegEmail = new String[] {""} ;
      H00282_A602MigrLegTelefono = new String[] {""} ;
      H00282_A601MigrLegCodPos = new String[] {""} ;
      H00282_A599MigrLegDomici = new String[] {""} ;
      H00282_A620MigrLegZona = new String[] {""} ;
      H00282_A595MigrLegSexo = new String[] {""} ;
      H00282_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      H00282_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      H00282_A607MigrLegClase = new String[] {""} ;
      H00282_A2427MigrLegTipoTarifa = new String[] {""} ;
      H00282_A2415MigrLegModTra = new String[] {""} ;
      H00282_A593MigrLegNombre = new String[] {""} ;
      H00282_A592MigrLegApellido = new String[] {""} ;
      H00282_A597MigrLegCUIL = new String[] {""} ;
      H00282_A626MigrLegId = new String[] {""} ;
      H00282_A87MigrLegNumero = new int[1] ;
      H00282_A1EmpCod = new short[1] ;
      H00282_A3CliCod = new int[1] ;
      AV290Importacion_legajowwds_1_tficonoupdate = "" ;
      H00283_AGRID_nRecordCount = new long[1] ;
      AV257WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV10HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV252MenuBienveImgURL = "" ;
      AV254MenuBienveTitulo = "" ;
      AV255MenuBienveTexto = "" ;
      AV288Welcomemessage_foto_GXI = "" ;
      AV277observerPalabra = "" ;
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext13 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV24Session = httpContext.getWebSession();
      AV20ColumnsSelectorXML = "" ;
      AV276MenuOpcTitulo = "" ;
      GXv_int12 = new short[1] ;
      AV279filtrosTexto = "" ;
      AV241MigrLegCategoria = "" ;
      AV263sueldosTooltip = "" ;
      AV264migracion_sueldos = new GXBaseCollection<web.Sdtmigracion_sueldos_migracion_sueldosItem>(web.Sdtmigracion_sueldos_migracion_sueldosItem.class, "migracion_sueldosItem", "PayDay", remoteHandle);
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV268ManageFiltersXml = "" ;
      ucDvelop_confirmpanel_btnimportarlegajosalsistema = new com.genexus.webpanels.GXUserControl();
      GXv_objcol_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem15 = new GXBaseCollection[1] ;
      ucDvelop_confirmpanel_btneliminartodos = new com.genexus.webpanels.GXUserControl();
      ucDvelop_confirmpanel_eliminar = new com.genexus.webpanels.GXUserControl();
      AV244TemplateLink = "" ;
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      AV260ResultTexto = "" ;
      AV258BlobPath = "" ;
      AV21UserCustomValue = "" ;
      AV23ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector16 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector17 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19 = new GXBaseCollection[1] ;
      AV207SelectedRow = new web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem(remoteHandle, context);
      H00284_A87MigrLegNumero = new int[1] ;
      H00284_A1EmpCod = new short[1] ;
      H00284_A3CliCod = new int[1] ;
      H00284_A626MigrLegId = new String[] {""} ;
      H00284_A597MigrLegCUIL = new String[] {""} ;
      H00284_A592MigrLegApellido = new String[] {""} ;
      H00284_A593MigrLegNombre = new String[] {""} ;
      H00284_A2415MigrLegModTra = new String[] {""} ;
      H00284_A2427MigrLegTipoTarifa = new String[] {""} ;
      H00284_A607MigrLegClase = new String[] {""} ;
      H00284_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      H00284_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      H00284_A595MigrLegSexo = new String[] {""} ;
      H00284_A620MigrLegZona = new String[] {""} ;
      H00284_A599MigrLegDomici = new String[] {""} ;
      H00284_A601MigrLegCodPos = new String[] {""} ;
      H00284_A602MigrLegTelefono = new String[] {""} ;
      H00284_A600MigrLegEmail = new String[] {""} ;
      H00284_A596MigrLegEstadoCivil = new String[] {""} ;
      H00284_A598MigrLegDiscapacidad = new String[] {""} ;
      H00284_A605MigrLegArea = new String[] {""} ;
      H00284_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00284_A627MigrLegConvenio = new String[] {""} ;
      H00284_A604MigrLegCategoria = new String[] {""} ;
      H00284_A606MigrLegLugarDePago = new String[] {""} ;
      H00284_A610MigrLegBanco = new String[] {""} ;
      H00284_A614MigrLegObraSocial = new String[] {""} ;
      H00284_A611MigrLegBanSuc = new String[] {""} ;
      H00284_A612MigrLegBanTipCuen = new String[] {""} ;
      H00284_A619MigrLegCuentaBanc = new String[] {""} ;
      H00284_A609MigrLegFormaPago = new String[] {""} ;
      H00284_A621MigrLegCBU = new String[] {""} ;
      H00284_A617MigrLegModalidad = new String[] {""} ;
      H00284_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00284_A616MigrLegActividad = new String[] {""} ;
      H00284_A623MigrLegSituacionRevista = new String[] {""} ;
      H00284_A624MigrLegCondicion = new String[] {""} ;
      H00284_A625MigrLegSiniestrado = new String[] {""} ;
      H00284_A622MigrLegSCVO = new String[] {""} ;
      H00284_A615MigrLegPlanMedico = new String[] {""} ;
      H00284_A631MigrTieneConyuge = new String[] {""} ;
      H00284_A632MigrCantidadHijos = new short[1] ;
      H00284_A628MigrLegObs = new String[] {""} ;
      H00284_A2190MigrPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      H00284_A2189MigrSueldos = new String[] {""} ;
      H00284_A2216MigrPuesto = new String[] {""} ;
      H00284_A2239MigrLegActLabClas = new String[] {""} ;
      H00284_A2240MigrLegPueAfip = new String[] {""} ;
      H00284_A613MigrLegSindicato = new String[] {""} ;
      AV14GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char53 = "" ;
      GXt_char51 = "" ;
      GXv_char52 = new String[1] ;
      GXt_char49 = "" ;
      GXv_char50 = new String[1] ;
      GXt_char47 = "" ;
      GXv_char48 = new String[1] ;
      GXt_char45 = "" ;
      GXv_char46 = new String[1] ;
      GXt_char43 = "" ;
      GXv_char44 = new String[1] ;
      GXt_char41 = "" ;
      GXv_char42 = new String[1] ;
      GXt_char39 = "" ;
      GXv_char40 = new String[1] ;
      GXt_char37 = "" ;
      GXv_char38 = new String[1] ;
      GXt_char35 = "" ;
      GXv_char36 = new String[1] ;
      GXt_char33 = "" ;
      GXv_char34 = new String[1] ;
      GXt_char31 = "" ;
      GXv_char32 = new String[1] ;
      GXt_char29 = "" ;
      GXv_char30 = new String[1] ;
      GXt_char27 = "" ;
      GXv_char28 = new String[1] ;
      GXt_char25 = "" ;
      GXv_char26 = new String[1] ;
      GXt_char23 = "" ;
      GXv_char24 = new String[1] ;
      GXt_char21 = "" ;
      GXv_char22 = new String[1] ;
      GXt_char20 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char10 = "" ;
      GXv_char6 = new String[1] ;
      GXt_char9 = "" ;
      GXv_char5 = new String[1] ;
      GXv_SdtWWPGridState55 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      H00285_A1EmpCod = new short[1] ;
      H00285_A3CliCod = new int[1] ;
      H00285_A633MigrLegWarnings = new String[] {""} ;
      H00285_A629MigrLegErrores = new String[] {""} ;
      H00285_A613MigrLegSindicato = new String[] {""} ;
      H00285_A628MigrLegObs = new String[] {""} ;
      H00285_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00285_A617MigrLegModalidad = new String[] {""} ;
      H00285_A621MigrLegCBU = new String[] {""} ;
      H00285_A614MigrLegObraSocial = new String[] {""} ;
      H00285_A627MigrLegConvenio = new String[] {""} ;
      H00285_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00285_A605MigrLegArea = new String[] {""} ;
      H00285_A596MigrLegEstadoCivil = new String[] {""} ;
      H00285_A600MigrLegEmail = new String[] {""} ;
      H00285_A602MigrLegTelefono = new String[] {""} ;
      H00285_A601MigrLegCodPos = new String[] {""} ;
      H00285_A599MigrLegDomici = new String[] {""} ;
      H00285_A595MigrLegSexo = new String[] {""} ;
      H00285_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      H00285_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      H00285_A607MigrLegClase = new String[] {""} ;
      H00285_A2427MigrLegTipoTarifa = new String[] {""} ;
      H00285_A2415MigrLegModTra = new String[] {""} ;
      H00285_A593MigrLegNombre = new String[] {""} ;
      H00285_A592MigrLegApellido = new String[] {""} ;
      H00285_A597MigrLegCUIL = new String[] {""} ;
      H00285_A626MigrLegId = new String[] {""} ;
      H00285_A87MigrLegNumero = new int[1] ;
      AV253textoNoMostrara = "" ;
      GXv_char54 = new String[1] ;
      GXv_boolean8 = new boolean[1] ;
      AV261error = "" ;
      ucImportexcel_modal = new com.genexus.webpanels.GXUserControl();
      lblJs_Jsonclick = "" ;
      bttBtnimportarlegajosalsistema_Jsonclick = "" ;
      bttBtneliminartodos_Jsonclick = "" ;
      bttBtnimportartodos_Jsonclick = "" ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      sImgUrl = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      bttBtngenerartemplate_Jsonclick = "" ;
      bttBtnimportexcel_Jsonclick = "" ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
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
      GXCCtl = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_legajoww__default(),
         new Object[] {
             new Object[] {
            H00282_A629MigrLegErrores, H00282_A633MigrLegWarnings, H00282_A613MigrLegSindicato, H00282_A2240MigrLegPueAfip, H00282_A2239MigrLegActLabClas, H00282_A2216MigrPuesto, H00282_A2189MigrSueldos, H00282_A2190MigrPeriodo, H00282_A628MigrLegObs, H00282_A632MigrCantidadHijos,
            H00282_A631MigrTieneConyuge, H00282_A615MigrLegPlanMedico, H00282_A622MigrLegSCVO, H00282_A625MigrLegSiniestrado, H00282_A624MigrLegCondicion, H00282_A623MigrLegSituacionRevista, H00282_A616MigrLegActividad, H00282_A2275MigrLegHorSem, H00282_A617MigrLegModalidad, H00282_A621MigrLegCBU,
            H00282_A609MigrLegFormaPago, H00282_A619MigrLegCuentaBanc, H00282_A612MigrLegBanTipCuen, H00282_A611MigrLegBanSuc, H00282_A614MigrLegObraSocial, H00282_A610MigrLegBanco, H00282_A606MigrLegLugarDePago, H00282_A604MigrLegCategoria, H00282_A627MigrLegConvenio, H00282_A608MigrLegBasico,
            H00282_A605MigrLegArea, H00282_A598MigrLegDiscapacidad, H00282_A596MigrLegEstadoCivil, H00282_A600MigrLegEmail, H00282_A602MigrLegTelefono, H00282_A601MigrLegCodPos, H00282_A599MigrLegDomici, H00282_A620MigrLegZona, H00282_A595MigrLegSexo, H00282_A603MigrLegFecIngreso,
            H00282_A594MigrLegFecNac, H00282_A607MigrLegClase, H00282_A2427MigrLegTipoTarifa, H00282_A2415MigrLegModTra, H00282_A593MigrLegNombre, H00282_A592MigrLegApellido, H00282_A597MigrLegCUIL, H00282_A626MigrLegId, H00282_A87MigrLegNumero, H00282_A1EmpCod,
            H00282_A3CliCod
            }
            , new Object[] {
            H00283_AGRID_nRecordCount
            }
            , new Object[] {
            H00284_A87MigrLegNumero, H00284_A1EmpCod, H00284_A3CliCod, H00284_A626MigrLegId, H00284_A597MigrLegCUIL, H00284_A592MigrLegApellido, H00284_A593MigrLegNombre, H00284_A2415MigrLegModTra, H00284_A2427MigrLegTipoTarifa, H00284_A607MigrLegClase,
            H00284_A594MigrLegFecNac, H00284_A603MigrLegFecIngreso, H00284_A595MigrLegSexo, H00284_A620MigrLegZona, H00284_A599MigrLegDomici, H00284_A601MigrLegCodPos, H00284_A602MigrLegTelefono, H00284_A600MigrLegEmail, H00284_A596MigrLegEstadoCivil, H00284_A598MigrLegDiscapacidad,
            H00284_A605MigrLegArea, H00284_A608MigrLegBasico, H00284_A627MigrLegConvenio, H00284_A604MigrLegCategoria, H00284_A606MigrLegLugarDePago, H00284_A610MigrLegBanco, H00284_A614MigrLegObraSocial, H00284_A611MigrLegBanSuc, H00284_A612MigrLegBanTipCuen, H00284_A619MigrLegCuentaBanc,
            H00284_A609MigrLegFormaPago, H00284_A621MigrLegCBU, H00284_A617MigrLegModalidad, H00284_A2275MigrLegHorSem, H00284_A616MigrLegActividad, H00284_A623MigrLegSituacionRevista, H00284_A624MigrLegCondicion, H00284_A625MigrLegSiniestrado, H00284_A622MigrLegSCVO, H00284_A615MigrLegPlanMedico,
            H00284_A631MigrTieneConyuge, H00284_A632MigrCantidadHijos, H00284_A628MigrLegObs, H00284_A2190MigrPeriodo, H00284_A2189MigrSueldos, H00284_A2216MigrPuesto, H00284_A2239MigrLegActLabClas, H00284_A2240MigrLegPueAfip, H00284_A613MigrLegSindicato
            }
            , new Object[] {
            H00285_A1EmpCod, H00285_A3CliCod, H00285_A633MigrLegWarnings, H00285_A629MigrLegErrores, H00285_A613MigrLegSindicato, H00285_A628MigrLegObs, H00285_A2275MigrLegHorSem, H00285_A617MigrLegModalidad, H00285_A621MigrLegCBU, H00285_A614MigrLegObraSocial,
            H00285_A627MigrLegConvenio, H00285_A608MigrLegBasico, H00285_A605MigrLegArea, H00285_A596MigrLegEstadoCivil, H00285_A600MigrLegEmail, H00285_A602MigrLegTelefono, H00285_A601MigrLegCodPos, H00285_A599MigrLegDomici, H00285_A595MigrLegSexo, H00285_A603MigrLegFecIngreso,
            H00285_A594MigrLegFecNac, H00285_A607MigrLegClase, H00285_A2427MigrLegTipoTarifa, H00285_A2415MigrLegModTra, H00285_A593MigrLegNombre, H00285_A592MigrLegApellido, H00285_A597MigrLegCUIL, H00285_A626MigrLegId, H00285_A87MigrLegNumero
            }
         }
      );
      AV289Pgmname = "importacion_legajoWW" ;
      /* GeneXus formulas. */
      AV289Pgmname = "importacion_legajoWW" ;
      Gx_err = (short)(0) ;
      edtavIconoupdatewithtags_Enabled = 0 ;
      edtavIconoupdate_Enabled = 0 ;
      edtavEliminar_Enabled = 0 ;
      edtavMigrlegcategoria_var_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
      edtavDetailwebcomponent_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
      edtavEliminarsvg_Enabled = 0 ;
      WebComp_Grid_dwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Wwpaux_wc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV269ManageFiltersExecutionStep ;
   private byte gxajaxcallmode ;
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
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV240TFiconoUpdateOperator ;
   private short AV15OrderedBy ;
   private short AV216EmpCodToFind ;
   private short AV105EmpCod ;
   private short AV235EmpCod_Selected ;
   private short wbEnd ;
   private short wbStart ;
   private short A1EmpCod ;
   private short A632MigrCantidadHijos ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV291Importacion_legajowwds_2_tficonoupdateoperator ;
   private short GXt_int11 ;
   private short GXv_int12[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private short AV265m ;
   private short AV215EmpCodColItem ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_97 ;
   private int nGXsfl_97_idx=1 ;
   private int AV104CliCod ;
   private int AV212CliCodToFind ;
   private int AV220MigrLegNumeroToFind ;
   private int AV234CliCod_Selected ;
   private int AV236MigrLegNumero_Selected ;
   private int Gridpaginationbar_Pagestoshow ;
   private int Popover_iconoupdate_Popoverwidth ;
   private int A3CliCod ;
   private int A87MigrLegNumero ;
   private int subGrid_Islastpage ;
   private int edtavIconoupdatewithtags_Enabled ;
   private int edtavIconoupdate_Enabled ;
   private int edtavEliminar_Enabled ;
   private int edtavMigrlegcategoria_var_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDetailwebcomponent_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV293Importacion_legajowwds_4_tfmigrlegid_sels_size ;
   private int AV295Importacion_legajowwds_6_tfmigrlegcuil_sels_size ;
   private int AV297Importacion_legajowwds_8_tfmigrlegapellido_sels_size ;
   private int AV299Importacion_legajowwds_10_tfmigrlegnombre_sels_size ;
   private int AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels_size ;
   private int AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels_size ;
   private int AV305Importacion_legajowwds_16_tfmigrlegclase_sels_size ;
   private int AV311Importacion_legajowwds_22_tfmigrlegsexo_sels_size ;
   private int AV313Importacion_legajowwds_24_tfmigrlegdomici_sels_size ;
   private int AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels_size ;
   private int AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels_size ;
   private int AV319Importacion_legajowwds_30_tfmigrlegemail_sels_size ;
   private int AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels_size ;
   private int AV323Importacion_legajowwds_34_tfmigrlegarea_sels_size ;
   private int AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels_size ;
   private int AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels_size ;
   private int AV331Importacion_legajowwds_42_tfmigrlegcbu_sels_size ;
   private int AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels_size ;
   private int AV337Importacion_legajowwds_48_tfmigrlegobs_sels_size ;
   private int AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int bttBtnimportartodos_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtavIconoupdatewithtags_Visible ;
   private int edtMigrLegId_Visible ;
   private int edtMigrLegCUIL_Visible ;
   private int edtMigrLegApellido_Visible ;
   private int edtMigrLegNombre_Visible ;
   private int edtMigrLegModTra_Visible ;
   private int edtMigrLegTipoTarifa_Visible ;
   private int edtMigrLegClase_Visible ;
   private int edtMigrLegFecNac_Visible ;
   private int edtMigrLegFecIngreso_Visible ;
   private int edtMigrLegSexo_Visible ;
   private int edtMigrLegDomici_Visible ;
   private int edtMigrLegCodPos_Visible ;
   private int edtMigrLegTelefono_Visible ;
   private int edtMigrLegEmail_Visible ;
   private int edtMigrLegEstadoCivil_Visible ;
   private int edtMigrLegArea_Visible ;
   private int edtMigrLegBasico_Visible ;
   private int edtMigrLegConvenio_Visible ;
   private int edtavMigrlegcategoria_var_Visible ;
   private int edtMigrLegObraSocial_Visible ;
   private int edtMigrLegCBU_Visible ;
   private int edtMigrLegModalidad_Visible ;
   private int edtMigrLegHorSem_Visible ;
   private int edtMigrLegObs_Visible ;
   private int edtMigrLegSindicato_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV278filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int bttBtneliminartodos_Visible ;
   private int AV95PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int nGXsfl_97_fel_idx=1 ;
   private int bttBtnimportexcel_Visible ;
   private int AV341GXV1 ;
   private int AV211CliCodColItem ;
   private int AV342GXV2 ;
   private int AV219MigrLegNumeroColItem ;
   private int AV344GXV3 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavIconoupdate_Visible ;
   private int edtavEliminar_Visible ;
   private int edtavDetailwebcomponent_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV208i ;
   private long AV96GridCurrentPage ;
   private long AV97GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV77TFMigrLegBasico ;
   private java.math.BigDecimal AV78TFMigrLegBasico_To ;
   private java.math.BigDecimal AV270TFMigrLegHorSem ;
   private java.math.BigDecimal AV271TFMigrLegHorSem_To ;
   private java.math.BigDecimal A608MigrLegBasico ;
   private java.math.BigDecimal A2275MigrLegHorSem ;
   private java.math.BigDecimal AV324Importacion_legajowwds_35_tfmigrlegbasico ;
   private java.math.BigDecimal AV325Importacion_legajowwds_36_tfmigrlegbasico_to ;
   private java.math.BigDecimal AV334Importacion_legajowwds_45_tfmigrleghorsem ;
   private java.math.BigDecimal AV335Importacion_legajowwds_46_tfmigrleghorsem_to ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumnfixedfilter ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String edtavDisplay_Link ;
   private String edtavUpdate_Link ;
   private String edtavDelete_Link ;
   private String Dvelop_confirmpanel_btnimportarlegajosalsistema_Result ;
   private String Dvelop_confirmpanel_btneliminartodos_Result ;
   private String Dvelop_confirmpanel_eliminar_Result ;
   private String Importexcel_modal_Result ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_97_idx="0001" ;
   private String AV289Pgmname ;
   private String AV239TFiconoUpdate ;
   private String AV108TFMigrLegId ;
   private String AV43TFMigrLegCUIL ;
   private String AV37TFMigrLegSexo ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Ddo_managefilters_Icontype ;
   private String Ddo_managefilters_Icon ;
   private String Ddo_managefilters_Tooltip ;
   private String Ddo_managefilters_Cls ;
   private String Ddo_gridcolumnsselector_Icontype ;
   private String Ddo_gridcolumnsselector_Icon ;
   private String Ddo_gridcolumnsselector_Caption ;
   private String Ddo_gridcolumnsselector_Tooltip ;
   private String Ddo_gridcolumnsselector_Cls ;
   private String Ddo_gridcolumnsselector_Dropdownoptionstype ;
   private String Ddo_gridcolumnsselector_Gridinternalname ;
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
   private String Innewwindow1_Target ;
   private String Popover_iconoupdate_Gridinternalname ;
   private String Popover_iconoupdate_Iteminternalname ;
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
   private String Ddo_grid_Datalistproc ;
   private String Ddo_grid_Fixedfilters ;
   private String Ddo_grid_Format ;
   private String Ddo_grid_Selectedfixedfilter ;
   private String Dvelop_confirmpanel_btnimportarlegajosalsistema_Title ;
   private String Dvelop_confirmpanel_btnimportarlegajosalsistema_Confirmationtext ;
   private String Dvelop_confirmpanel_btnimportarlegajosalsistema_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_btnimportarlegajosalsistema_Nobuttoncaption ;
   private String Dvelop_confirmpanel_btnimportarlegajosalsistema_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_btnimportarlegajosalsistema_Yesbuttonposition ;
   private String Dvelop_confirmpanel_btnimportarlegajosalsistema_Confirmtype ;
   private String Dvelop_confirmpanel_btneliminartodos_Title ;
   private String Dvelop_confirmpanel_btneliminartodos_Confirmationtext ;
   private String Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption ;
   private String Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition ;
   private String Dvelop_confirmpanel_btneliminartodos_Confirmtype ;
   private String Dvelop_confirmpanel_eliminar_Title ;
   private String Dvelop_confirmpanel_eliminar_Confirmationtext ;
   private String Dvelop_confirmpanel_eliminar_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Nobuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Yesbuttonposition ;
   private String Dvelop_confirmpanel_eliminar_Confirmtype ;
   private String Importexcel_modal_Width ;
   private String Importexcel_modal_Title ;
   private String Importexcel_modal_Confirmtype ;
   private String Importexcel_modal_Bodytype ;
   private String Grid_empowerer_Gridinternalname ;
   private String Grid_empowerer_Popoversingrid ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Popover_iconoupdate_Internalname ;
   private String Ddo_grid_Internalname ;
   private String TempTags ;
   private String Grid_empowerer_Internalname ;
   private String divDiv_wwpauxwc_Internalname ;
   private String WebComp_Wwpaux_wc_Component ;
   private String OldWwpaux_wc ;
   private String divDdo_migrlegfecnacauxdates_Internalname ;
   private String edtavDdo_migrlegfecnacauxdatetext_Internalname ;
   private String edtavDdo_migrlegfecnacauxdatetext_Jsonclick ;
   private String Tfmigrlegfecnac_rangepicker_Internalname ;
   private String divDdo_migrlegfecingresoauxdates_Internalname ;
   private String edtavDdo_migrlegfecingresoauxdatetext_Internalname ;
   private String edtavDdo_migrlegfecingresoauxdatetext_Jsonclick ;
   private String Tfmigrlegfecingreso_rangepicker_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavIconoupdatewithtags_Internalname ;
   private String AV237iconoUpdate ;
   private String edtavIconoupdate_Internalname ;
   private String AV233Eliminar ;
   private String edtavEliminar_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtMigrLegNumero_Internalname ;
   private String A626MigrLegId ;
   private String edtMigrLegId_Internalname ;
   private String A597MigrLegCUIL ;
   private String edtMigrLegCUIL_Internalname ;
   private String edtMigrLegApellido_Internalname ;
   private String edtMigrLegNombre_Internalname ;
   private String edtMigrLegModTra_Internalname ;
   private String edtMigrLegTipoTarifa_Internalname ;
   private String edtMigrLegClase_Internalname ;
   private String edtMigrLegFecNac_Internalname ;
   private String edtMigrLegFecIngreso_Internalname ;
   private String A595MigrLegSexo ;
   private String edtMigrLegSexo_Internalname ;
   private String edtMigrLegZona_Internalname ;
   private String edtMigrLegDomici_Internalname ;
   private String edtMigrLegCodPos_Internalname ;
   private String edtMigrLegTelefono_Internalname ;
   private String edtMigrLegEmail_Internalname ;
   private String edtMigrLegEstadoCivil_Internalname ;
   private String A598MigrLegDiscapacidad ;
   private String edtMigrLegDiscapacidad_Internalname ;
   private String edtMigrLegArea_Internalname ;
   private String edtMigrLegBasico_Internalname ;
   private String edtMigrLegConvenio_Internalname ;
   private String edtavMigrlegcategoria_var_Internalname ;
   private String edtMigrLegCategoria_Internalname ;
   private String edtMigrLegLugarDePago_Internalname ;
   private String edtMigrLegBanco_Internalname ;
   private String edtMigrLegObraSocial_Internalname ;
   private String edtMigrLegBanSuc_Internalname ;
   private String edtMigrLegBanTipCuen_Internalname ;
   private String edtMigrLegCuentaBanc_Internalname ;
   private String edtMigrLegFormaPago_Internalname ;
   private String edtMigrLegCBU_Internalname ;
   private String edtMigrLegModalidad_Internalname ;
   private String edtMigrLegHorSem_Internalname ;
   private String edtMigrLegActividad_Internalname ;
   private String edtMigrLegSituacionRevista_Internalname ;
   private String edtMigrLegCondicion_Internalname ;
   private String edtMigrLegSiniestrado_Internalname ;
   private String A622MigrLegSCVO ;
   private String edtMigrLegSCVO_Internalname ;
   private String edtMigrLegPlanMedico_Internalname ;
   private String A631MigrTieneConyuge ;
   private String edtMigrTieneConyuge_Internalname ;
   private String edtMigrCantidadHijos_Internalname ;
   private String edtMigrLegObs_Internalname ;
   private String edtMigrPeriodo_Internalname ;
   private String edtMigrSueldos_Internalname ;
   private String edtMigrPuesto_Internalname ;
   private String edtMigrLegActLabClas_Internalname ;
   private String edtMigrLegPueAfip_Internalname ;
   private String edtMigrLegSindicato_Internalname ;
   private String AV248Display ;
   private String edtavDisplay_Internalname ;
   private String AV99Update ;
   private String edtavUpdate_Internalname ;
   private String AV101Delete ;
   private String edtavDelete_Internalname ;
   private String AV262DetailWebComponent ;
   private String edtavDetailwebcomponent_Internalname ;
   private String AV245VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV246ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV247EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String OldGrid_dwc ;
   private String WebComp_Grid_dwc_Component ;
   private String scmdbuf ;
   private String lV292Importacion_legajowwds_3_tfmigrlegid ;
   private String lV294Importacion_legajowwds_5_tfmigrlegcuil ;
   private String lV310Importacion_legajowwds_21_tfmigrlegsexo ;
   private String AV292Importacion_legajowwds_3_tfmigrlegid ;
   private String AV294Importacion_legajowwds_5_tfmigrlegcuil ;
   private String AV310Importacion_legajowwds_21_tfmigrlegsexo ;
   private String AV290Importacion_legajowwds_1_tficonoupdate ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String divCell_grid_dwc_Class ;
   private String divCell_grid_dwc_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String AV277observerPalabra ;
   private String Buttonfilter1_a3lfilter_Internalname ;
   private String divButtonfilter1_tablecontent_Internalname ;
   private String bttBtnimportartodos_Internalname ;
   private String lblCouttext_Internalname ;
   private String lblCouttext_Caption ;
   private String tblButtonfilter1_tablebadge_Internalname ;
   private String lblButtonfilter1_textblockbadgecount_Caption ;
   private String lblButtonfilter1_textblockbadgecount_Internalname ;
   private String tblButtonfilter1_tablebadge_Tooltiptext ;
   private String bttBtneliminartodos_Internalname ;
   private String edtavIconoupdatewithtags_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtavEliminarsvg_Link ;
   private String edtMigrLegBasico_Tooltiptext ;
   private String Dvelop_confirmpanel_btnimportarlegajosalsistema_Internalname ;
   private String Dvelop_confirmpanel_btneliminartodos_Internalname ;
   private String Dvelop_confirmpanel_eliminar_Internalname ;
   private String Innewwindow1_Internalname ;
   private String AV258BlobPath ;
   private String lblJs_Caption ;
   private String bttBtnimportexcel_Internalname ;
   private String lblJs_Internalname ;
   private String sGXsfl_97_fel_idx="0001" ;
   private String GXt_char53 ;
   private String GXt_char51 ;
   private String GXv_char52[] ;
   private String GXt_char49 ;
   private String GXv_char50[] ;
   private String GXt_char47 ;
   private String GXv_char48[] ;
   private String GXt_char45 ;
   private String GXv_char46[] ;
   private String GXt_char43 ;
   private String GXv_char44[] ;
   private String GXt_char41 ;
   private String GXv_char42[] ;
   private String GXt_char39 ;
   private String GXv_char40[] ;
   private String GXt_char37 ;
   private String GXv_char38[] ;
   private String GXt_char35 ;
   private String GXv_char36[] ;
   private String GXt_char33 ;
   private String GXv_char34[] ;
   private String GXt_char31 ;
   private String GXv_char32[] ;
   private String GXt_char29 ;
   private String GXv_char30[] ;
   private String GXt_char27 ;
   private String GXv_char28[] ;
   private String GXt_char25 ;
   private String GXv_char26[] ;
   private String GXt_char23 ;
   private String GXv_char24[] ;
   private String GXt_char21 ;
   private String GXv_char22[] ;
   private String GXt_char20 ;
   private String GXv_char7[] ;
   private String GXt_char10 ;
   private String GXv_char6[] ;
   private String GXt_char9 ;
   private String GXv_char5[] ;
   private String GXv_char54[] ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String tblTableimportexcel_modal_Internalname ;
   private String Importexcel_modal_Internalname ;
   private String tblTabledvelop_confirmpanel_eliminar_Internalname ;
   private String tblTabledvelop_confirmpanel_btneliminartodos_Internalname ;
   private String tblTabledvelop_confirmpanel_btnimportarlegajosalsistema_Internalname ;
   private String tblTablemergedinnewwindow1_Internalname ;
   private String lblJs_Jsonclick ;
   private String tblTablemergedbtnimportarlegajosalsistema_Internalname ;
   private String bttBtnimportarlegajosalsistema_Internalname ;
   private String bttBtnimportarlegajosalsistema_Jsonclick ;
   private String bttBtneliminartodos_Jsonclick ;
   private String bttBtnimportartodos_Jsonclick ;
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
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String divTablefiltrospadre_Internalname ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String tblTablefiltros_Internalname ;
   private String bttBtngenerartemplate_Internalname ;
   private String bttBtngenerartemplate_Jsonclick ;
   private String bttBtnimportexcel_Jsonclick ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
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
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String GXCCtl ;
   private String ROClassString ;
   private String edtavIconoupdatewithtags_Jsonclick ;
   private String edtavIconoupdate_Jsonclick ;
   private String edtavEliminar_Jsonclick ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtMigrLegNumero_Jsonclick ;
   private String edtMigrLegId_Jsonclick ;
   private String edtMigrLegCUIL_Jsonclick ;
   private String edtMigrLegApellido_Jsonclick ;
   private String edtMigrLegNombre_Jsonclick ;
   private String edtMigrLegModTra_Jsonclick ;
   private String edtMigrLegTipoTarifa_Jsonclick ;
   private String edtMigrLegClase_Jsonclick ;
   private String edtMigrLegFecNac_Jsonclick ;
   private String edtMigrLegFecIngreso_Jsonclick ;
   private String edtMigrLegSexo_Jsonclick ;
   private String edtMigrLegZona_Jsonclick ;
   private String edtMigrLegDomici_Jsonclick ;
   private String edtMigrLegCodPos_Jsonclick ;
   private String edtMigrLegTelefono_Jsonclick ;
   private String edtMigrLegEmail_Jsonclick ;
   private String edtMigrLegEstadoCivil_Jsonclick ;
   private String edtMigrLegDiscapacidad_Jsonclick ;
   private String edtMigrLegArea_Jsonclick ;
   private String edtMigrLegBasico_Jsonclick ;
   private String edtMigrLegConvenio_Jsonclick ;
   private String edtavMigrlegcategoria_var_Jsonclick ;
   private String edtMigrLegCategoria_Jsonclick ;
   private String edtMigrLegLugarDePago_Jsonclick ;
   private String edtMigrLegBanco_Jsonclick ;
   private String edtMigrLegObraSocial_Jsonclick ;
   private String edtMigrLegBanSuc_Jsonclick ;
   private String edtMigrLegBanTipCuen_Jsonclick ;
   private String edtMigrLegCuentaBanc_Jsonclick ;
   private String edtMigrLegFormaPago_Jsonclick ;
   private String edtMigrLegCBU_Jsonclick ;
   private String edtMigrLegModalidad_Jsonclick ;
   private String edtMigrLegHorSem_Jsonclick ;
   private String edtMigrLegActividad_Jsonclick ;
   private String edtMigrLegSituacionRevista_Jsonclick ;
   private String edtMigrLegCondicion_Jsonclick ;
   private String edtMigrLegSiniestrado_Jsonclick ;
   private String edtMigrLegSCVO_Jsonclick ;
   private String edtMigrLegPlanMedico_Jsonclick ;
   private String edtMigrTieneConyuge_Jsonclick ;
   private String edtMigrCantidadHijos_Jsonclick ;
   private String edtMigrLegObs_Jsonclick ;
   private String edtMigrPeriodo_Jsonclick ;
   private String edtMigrSueldos_Jsonclick ;
   private String edtMigrPuesto_Jsonclick ;
   private String edtMigrLegActLabClas_Jsonclick ;
   private String edtMigrLegPueAfip_Jsonclick ;
   private String edtMigrLegSindicato_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavDetailwebcomponent_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date AV31TFMigrLegFecNac ;
   private java.util.Date AV32TFMigrLegFecNac_To ;
   private java.util.Date AV60TFMigrLegFecIngreso ;
   private java.util.Date AV61TFMigrLegFecIngreso_To ;
   private java.util.Date AV33DDO_MigrLegFecNacAuxDate ;
   private java.util.Date AV34DDO_MigrLegFecNacAuxDateTo ;
   private java.util.Date AV62DDO_MigrLegFecIngresoAuxDate ;
   private java.util.Date AV63DDO_MigrLegFecIngresoAuxDateTo ;
   private java.util.Date A594MigrLegFecNac ;
   private java.util.Date A603MigrLegFecIngreso ;
   private java.util.Date A2190MigrPeriodo ;
   private java.util.Date AV306Importacion_legajowwds_17_tfmigrlegfecnac ;
   private java.util.Date AV307Importacion_legajowwds_18_tfmigrlegfecnac_to ;
   private java.util.Date AV308Importacion_legajowwds_19_tfmigrlegfecingreso ;
   private java.util.Date AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV16OrderedDsc ;
   private boolean AV100IsAuthorized_Update ;
   private boolean AV102IsAuthorized_Delete ;
   private boolean AV251WelcomeMessage_NoMostrarMas ;
   private boolean AV221SelectAll ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Popover_iconoupdate_Isgriditem ;
   private boolean Popover_iconoupdate_Visible ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean Grid_empowerer_Hascolumnsselector ;
   private boolean wbLoad ;
   private boolean bGXsfl_97_Refreshing=false ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean AV205Selected ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV256MenuBienveVisible ;
   private boolean AV266modoTest ;
   private boolean gx_refresh_fired ;
   private boolean AV243hay ;
   private boolean AV103TempBoolean ;
   private boolean GXt_boolean14 ;
   private boolean GXv_boolean8[] ;
   private boolean AV257WelcomeMessage_Foto_IsBlob ;
   private String AV210CliCodJson ;
   private String AV214EmpCodJson ;
   private String AV218MigrLegNumeroJson ;
   private String A629MigrLegErrores ;
   private String A633MigrLegWarnings ;
   private String AV107TFMigrLegId_SelsJson ;
   private String AV42TFMigrLegCUIL_SelsJson ;
   private String AV25TFMigrLegApellido_SelsJson ;
   private String AV28TFMigrLegNombre_SelsJson ;
   private String AV280TFMigrLegModTra_SelsJson ;
   private String AV283TFMigrLegTipoTarifa_SelsJson ;
   private String AV74TFMigrLegClase_SelsJson ;
   private String AV36TFMigrLegSexo_SelsJson ;
   private String AV48TFMigrLegDomici_SelsJson ;
   private String AV54TFMigrLegCodPos_SelsJson ;
   private String AV57TFMigrLegTelefono_SelsJson ;
   private String AV51TFMigrLegEmail_SelsJson ;
   private String AV39TFMigrLegEstadoCivil_SelsJson ;
   private String AV68TFMigrLegArea_SelsJson ;
   private String AV119TFMigrLegConvenio_SelsJson ;
   private String AV136TFMigrLegObraSocial_SelsJson ;
   private String AV113TFMigrLegCBU_SelsJson ;
   private String AV133TFMigrLegModalidad_SelsJson ;
   private String AV139TFMigrLegObs_SelsJson ;
   private String AV91TFMigrLegSindicato_SelsJson ;
   private String A628MigrLegObs ;
   private String A2189MigrSueldos ;
   private String AV255MenuBienveTexto ;
   private String AV20ColumnsSelectorXML ;
   private String AV268ManageFiltersXml ;
   private String AV21UserCustomValue ;
   private String AV253textoNoMostrara ;
   private String wcpOAV249MenuOpcCod ;
   private String AV249MenuOpcCod ;
   private String AV26TFMigrLegApellido ;
   private String AV29TFMigrLegNombre ;
   private String AV281TFMigrLegModTra ;
   private String AV284TFMigrLegTipoTarifa ;
   private String AV75TFMigrLegClase ;
   private String AV49TFMigrLegDomici ;
   private String AV55TFMigrLegCodPos ;
   private String AV58TFMigrLegTelefono ;
   private String AV52TFMigrLegEmail ;
   private String AV40TFMigrLegEstadoCivil ;
   private String AV69TFMigrLegArea ;
   private String AV120TFMigrLegConvenio ;
   private String AV137TFMigrLegObraSocial ;
   private String AV114TFMigrLegCBU ;
   private String AV134TFMigrLegModalidad ;
   private String AV140TFMigrLegObs ;
   private String AV92TFMigrLegSindicato ;
   private String AV98GridAppliedFilters ;
   private String AV259mensajeTexto ;
   private String AV35DDO_MigrLegFecNacAuxDateText ;
   private String AV64DDO_MigrLegFecIngresoAuxDateText ;
   private String AV238iconoUpdateWithTags ;
   private String A592MigrLegApellido ;
   private String A593MigrLegNombre ;
   private String A2415MigrLegModTra ;
   private String A2427MigrLegTipoTarifa ;
   private String A607MigrLegClase ;
   private String A620MigrLegZona ;
   private String A599MigrLegDomici ;
   private String A601MigrLegCodPos ;
   private String A602MigrLegTelefono ;
   private String A600MigrLegEmail ;
   private String A596MigrLegEstadoCivil ;
   private String A605MigrLegArea ;
   private String A627MigrLegConvenio ;
   private String AV242MigrLegCategoria_var ;
   private String A604MigrLegCategoria ;
   private String A606MigrLegLugarDePago ;
   private String A610MigrLegBanco ;
   private String A614MigrLegObraSocial ;
   private String A611MigrLegBanSuc ;
   private String A612MigrLegBanTipCuen ;
   private String A619MigrLegCuentaBanc ;
   private String A609MigrLegFormaPago ;
   private String A621MigrLegCBU ;
   private String A617MigrLegModalidad ;
   private String A616MigrLegActividad ;
   private String A623MigrLegSituacionRevista ;
   private String A624MigrLegCondicion ;
   private String A625MigrLegSiniestrado ;
   private String A615MigrLegPlanMedico ;
   private String A2216MigrPuesto ;
   private String A2239MigrLegActLabClas ;
   private String A2240MigrLegPueAfip ;
   private String A613MigrLegSindicato ;
   private String lV296Importacion_legajowwds_7_tfmigrlegapellido ;
   private String lV298Importacion_legajowwds_9_tfmigrlegnombre ;
   private String lV300Importacion_legajowwds_11_tfmigrlegmodtra ;
   private String lV302Importacion_legajowwds_13_tfmigrlegtipotarifa ;
   private String lV304Importacion_legajowwds_15_tfmigrlegclase ;
   private String lV312Importacion_legajowwds_23_tfmigrlegdomici ;
   private String lV314Importacion_legajowwds_25_tfmigrlegcodpos ;
   private String lV316Importacion_legajowwds_27_tfmigrlegtelefono ;
   private String lV318Importacion_legajowwds_29_tfmigrlegemail ;
   private String lV320Importacion_legajowwds_31_tfmigrlegestadocivil ;
   private String lV322Importacion_legajowwds_33_tfmigrlegarea ;
   private String lV326Importacion_legajowwds_37_tfmigrlegconvenio ;
   private String lV328Importacion_legajowwds_39_tfmigrlegobrasocial ;
   private String lV330Importacion_legajowwds_41_tfmigrlegcbu ;
   private String lV332Importacion_legajowwds_43_tfmigrlegmodalidad ;
   private String lV336Importacion_legajowwds_47_tfmigrlegobs ;
   private String lV338Importacion_legajowwds_49_tfmigrlegsindicato ;
   private String AV296Importacion_legajowwds_7_tfmigrlegapellido ;
   private String AV298Importacion_legajowwds_9_tfmigrlegnombre ;
   private String AV300Importacion_legajowwds_11_tfmigrlegmodtra ;
   private String AV302Importacion_legajowwds_13_tfmigrlegtipotarifa ;
   private String AV304Importacion_legajowwds_15_tfmigrlegclase ;
   private String AV312Importacion_legajowwds_23_tfmigrlegdomici ;
   private String AV314Importacion_legajowwds_25_tfmigrlegcodpos ;
   private String AV316Importacion_legajowwds_27_tfmigrlegtelefono ;
   private String AV318Importacion_legajowwds_29_tfmigrlegemail ;
   private String AV320Importacion_legajowwds_31_tfmigrlegestadocivil ;
   private String AV322Importacion_legajowwds_33_tfmigrlegarea ;
   private String AV326Importacion_legajowwds_37_tfmigrlegconvenio ;
   private String AV328Importacion_legajowwds_39_tfmigrlegobrasocial ;
   private String AV330Importacion_legajowwds_41_tfmigrlegcbu ;
   private String AV332Importacion_legajowwds_43_tfmigrlegmodalidad ;
   private String AV336Importacion_legajowwds_47_tfmigrlegobs ;
   private String AV338Importacion_legajowwds_49_tfmigrlegsindicato ;
   private String AV252MenuBienveImgURL ;
   private String AV254MenuBienveTitulo ;
   private String AV288Welcomemessage_foto_GXI ;
   private String AV276MenuOpcTitulo ;
   private String AV279filtrosTexto ;
   private String AV241MigrLegCategoria ;
   private String AV263sueldosTooltip ;
   private String AV244TemplateLink ;
   private String AV260ResultTexto ;
   private String AV261error ;
   private String AV257WelcomeMessage_Foto ;
   private GXSimpleCollection<Short> AV213EmpCodCol ;
   private GXSimpleCollection<Integer> AV209CliCodCol ;
   private GXSimpleCollection<Integer> AV217MigrLegNumeroCol ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Grid_dwc ;
   private GXWebComponent WebComp_Wwpaux_wc ;
   private com.genexus.internet.HttpRequest AV10HTTPRequest ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private com.genexus.webpanels.GXUserControl ucPopover_iconoupdate ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucTfmigrlegfecnac_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucTfmigrlegfecingreso_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_btnimportarlegajosalsistema ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_btneliminartodos ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_eliminar ;
   private com.genexus.webpanels.GXUserControl ucInnewwindow1 ;
   private com.genexus.webpanels.GXUserControl ucImportexcel_modal ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV293Importacion_legajowwds_4_tfmigrlegid_sels ;
   private GXSimpleCollection<String> AV295Importacion_legajowwds_6_tfmigrlegcuil_sels ;
   private GXSimpleCollection<String> AV311Importacion_legajowwds_22_tfmigrlegsexo_sels ;
   private GXSimpleCollection<String> AV297Importacion_legajowwds_8_tfmigrlegapellido_sels ;
   private GXSimpleCollection<String> AV299Importacion_legajowwds_10_tfmigrlegnombre_sels ;
   private GXSimpleCollection<String> AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels ;
   private GXSimpleCollection<String> AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels ;
   private GXSimpleCollection<String> AV305Importacion_legajowwds_16_tfmigrlegclase_sels ;
   private GXSimpleCollection<String> AV313Importacion_legajowwds_24_tfmigrlegdomici_sels ;
   private GXSimpleCollection<String> AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels ;
   private GXSimpleCollection<String> AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels ;
   private GXSimpleCollection<String> AV319Importacion_legajowwds_30_tfmigrlegemail_sels ;
   private GXSimpleCollection<String> AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels ;
   private GXSimpleCollection<String> AV323Importacion_legajowwds_34_tfmigrlegarea_sels ;
   private GXSimpleCollection<String> AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels ;
   private GXSimpleCollection<String> AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels ;
   private GXSimpleCollection<String> AV331Importacion_legajowwds_42_tfmigrlegcbu_sels ;
   private GXSimpleCollection<String> AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels ;
   private GXSimpleCollection<String> AV337Importacion_legajowwds_48_tfmigrlegobs_sels ;
   private GXSimpleCollection<String> AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private ICheckbox chkavSelected ;
   private ICheckbox chkavSelectall ;
   private IDataStoreProvider pr_default ;
   private String[] H00282_A629MigrLegErrores ;
   private String[] H00282_A633MigrLegWarnings ;
   private String[] H00282_A613MigrLegSindicato ;
   private String[] H00282_A2240MigrLegPueAfip ;
   private String[] H00282_A2239MigrLegActLabClas ;
   private String[] H00282_A2216MigrPuesto ;
   private String[] H00282_A2189MigrSueldos ;
   private java.util.Date[] H00282_A2190MigrPeriodo ;
   private String[] H00282_A628MigrLegObs ;
   private short[] H00282_A632MigrCantidadHijos ;
   private String[] H00282_A631MigrTieneConyuge ;
   private String[] H00282_A615MigrLegPlanMedico ;
   private String[] H00282_A622MigrLegSCVO ;
   private String[] H00282_A625MigrLegSiniestrado ;
   private String[] H00282_A624MigrLegCondicion ;
   private String[] H00282_A623MigrLegSituacionRevista ;
   private String[] H00282_A616MigrLegActividad ;
   private java.math.BigDecimal[] H00282_A2275MigrLegHorSem ;
   private String[] H00282_A617MigrLegModalidad ;
   private String[] H00282_A621MigrLegCBU ;
   private String[] H00282_A609MigrLegFormaPago ;
   private String[] H00282_A619MigrLegCuentaBanc ;
   private String[] H00282_A612MigrLegBanTipCuen ;
   private String[] H00282_A611MigrLegBanSuc ;
   private String[] H00282_A614MigrLegObraSocial ;
   private String[] H00282_A610MigrLegBanco ;
   private String[] H00282_A606MigrLegLugarDePago ;
   private String[] H00282_A604MigrLegCategoria ;
   private String[] H00282_A627MigrLegConvenio ;
   private java.math.BigDecimal[] H00282_A608MigrLegBasico ;
   private String[] H00282_A605MigrLegArea ;
   private String[] H00282_A598MigrLegDiscapacidad ;
   private String[] H00282_A596MigrLegEstadoCivil ;
   private String[] H00282_A600MigrLegEmail ;
   private String[] H00282_A602MigrLegTelefono ;
   private String[] H00282_A601MigrLegCodPos ;
   private String[] H00282_A599MigrLegDomici ;
   private String[] H00282_A620MigrLegZona ;
   private String[] H00282_A595MigrLegSexo ;
   private java.util.Date[] H00282_A603MigrLegFecIngreso ;
   private java.util.Date[] H00282_A594MigrLegFecNac ;
   private String[] H00282_A607MigrLegClase ;
   private String[] H00282_A2427MigrLegTipoTarifa ;
   private String[] H00282_A2415MigrLegModTra ;
   private String[] H00282_A593MigrLegNombre ;
   private String[] H00282_A592MigrLegApellido ;
   private String[] H00282_A597MigrLegCUIL ;
   private String[] H00282_A626MigrLegId ;
   private int[] H00282_A87MigrLegNumero ;
   private short[] H00282_A1EmpCod ;
   private int[] H00282_A3CliCod ;
   private long[] H00283_AGRID_nRecordCount ;
   private int[] H00284_A87MigrLegNumero ;
   private short[] H00284_A1EmpCod ;
   private int[] H00284_A3CliCod ;
   private String[] H00284_A626MigrLegId ;
   private String[] H00284_A597MigrLegCUIL ;
   private String[] H00284_A592MigrLegApellido ;
   private String[] H00284_A593MigrLegNombre ;
   private String[] H00284_A2415MigrLegModTra ;
   private String[] H00284_A2427MigrLegTipoTarifa ;
   private String[] H00284_A607MigrLegClase ;
   private java.util.Date[] H00284_A594MigrLegFecNac ;
   private java.util.Date[] H00284_A603MigrLegFecIngreso ;
   private String[] H00284_A595MigrLegSexo ;
   private String[] H00284_A620MigrLegZona ;
   private String[] H00284_A599MigrLegDomici ;
   private String[] H00284_A601MigrLegCodPos ;
   private String[] H00284_A602MigrLegTelefono ;
   private String[] H00284_A600MigrLegEmail ;
   private String[] H00284_A596MigrLegEstadoCivil ;
   private String[] H00284_A598MigrLegDiscapacidad ;
   private String[] H00284_A605MigrLegArea ;
   private java.math.BigDecimal[] H00284_A608MigrLegBasico ;
   private String[] H00284_A627MigrLegConvenio ;
   private String[] H00284_A604MigrLegCategoria ;
   private String[] H00284_A606MigrLegLugarDePago ;
   private String[] H00284_A610MigrLegBanco ;
   private String[] H00284_A614MigrLegObraSocial ;
   private String[] H00284_A611MigrLegBanSuc ;
   private String[] H00284_A612MigrLegBanTipCuen ;
   private String[] H00284_A619MigrLegCuentaBanc ;
   private String[] H00284_A609MigrLegFormaPago ;
   private String[] H00284_A621MigrLegCBU ;
   private String[] H00284_A617MigrLegModalidad ;
   private java.math.BigDecimal[] H00284_A2275MigrLegHorSem ;
   private String[] H00284_A616MigrLegActividad ;
   private String[] H00284_A623MigrLegSituacionRevista ;
   private String[] H00284_A624MigrLegCondicion ;
   private String[] H00284_A625MigrLegSiniestrado ;
   private String[] H00284_A622MigrLegSCVO ;
   private String[] H00284_A615MigrLegPlanMedico ;
   private String[] H00284_A631MigrTieneConyuge ;
   private short[] H00284_A632MigrCantidadHijos ;
   private String[] H00284_A628MigrLegObs ;
   private java.util.Date[] H00284_A2190MigrPeriodo ;
   private String[] H00284_A2189MigrSueldos ;
   private String[] H00284_A2216MigrPuesto ;
   private String[] H00284_A2239MigrLegActLabClas ;
   private String[] H00284_A2240MigrLegPueAfip ;
   private String[] H00284_A613MigrLegSindicato ;
   private short[] H00285_A1EmpCod ;
   private int[] H00285_A3CliCod ;
   private String[] H00285_A633MigrLegWarnings ;
   private String[] H00285_A629MigrLegErrores ;
   private String[] H00285_A613MigrLegSindicato ;
   private String[] H00285_A628MigrLegObs ;
   private java.math.BigDecimal[] H00285_A2275MigrLegHorSem ;
   private String[] H00285_A617MigrLegModalidad ;
   private String[] H00285_A621MigrLegCBU ;
   private String[] H00285_A614MigrLegObraSocial ;
   private String[] H00285_A627MigrLegConvenio ;
   private java.math.BigDecimal[] H00285_A608MigrLegBasico ;
   private String[] H00285_A605MigrLegArea ;
   private String[] H00285_A596MigrLegEstadoCivil ;
   private String[] H00285_A600MigrLegEmail ;
   private String[] H00285_A602MigrLegTelefono ;
   private String[] H00285_A601MigrLegCodPos ;
   private String[] H00285_A599MigrLegDomici ;
   private String[] H00285_A595MigrLegSexo ;
   private java.util.Date[] H00285_A603MigrLegFecIngreso ;
   private java.util.Date[] H00285_A594MigrLegFecNac ;
   private String[] H00285_A607MigrLegClase ;
   private String[] H00285_A2427MigrLegTipoTarifa ;
   private String[] H00285_A2415MigrLegModTra ;
   private String[] H00285_A593MigrLegNombre ;
   private String[] H00285_A592MigrLegApellido ;
   private String[] H00285_A597MigrLegCUIL ;
   private String[] H00285_A626MigrLegId ;
   private int[] H00285_A87MigrLegNumero ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV109TFMigrLegId_Sels ;
   private GXSimpleCollection<String> AV44TFMigrLegCUIL_Sels ;
   private GXSimpleCollection<String> AV38TFMigrLegSexo_Sels ;
   private GXSimpleCollection<String> AV27TFMigrLegApellido_Sels ;
   private GXSimpleCollection<String> AV30TFMigrLegNombre_Sels ;
   private GXSimpleCollection<String> AV282TFMigrLegModTra_Sels ;
   private GXSimpleCollection<String> AV285TFMigrLegTipoTarifa_Sels ;
   private GXSimpleCollection<String> AV76TFMigrLegClase_Sels ;
   private GXSimpleCollection<String> AV50TFMigrLegDomici_Sels ;
   private GXSimpleCollection<String> AV56TFMigrLegCodPos_Sels ;
   private GXSimpleCollection<String> AV59TFMigrLegTelefono_Sels ;
   private GXSimpleCollection<String> AV53TFMigrLegEmail_Sels ;
   private GXSimpleCollection<String> AV41TFMigrLegEstadoCivil_Sels ;
   private GXSimpleCollection<String> AV70TFMigrLegArea_Sels ;
   private GXSimpleCollection<String> AV121TFMigrLegConvenio_Sels ;
   private GXSimpleCollection<String> AV138TFMigrLegObraSocial_Sels ;
   private GXSimpleCollection<String> AV115TFMigrLegCBU_Sels ;
   private GXSimpleCollection<String> AV135TFMigrLegModalidad_Sels ;
   private GXSimpleCollection<String> AV141TFMigrLegObs_Sels ;
   private GXSimpleCollection<String> AV93TFMigrLegSindicato_Sels ;
   private GXSimpleCollection<String> AV8ExtraParms ;
   private GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem> AV206SelectedRows ;
   private GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem> GXv_objcol_Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem15[] ;
   private GXBaseCollection<web.Sdtmigracion_sueldos_migracion_sueldosItem> AV264migracion_sueldos ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV267ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV23ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector16[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector17[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV94DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV13GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState55[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV14GridStateFilterValue ;
   private web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem AV207SelectedRow ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext13[] ;
}

final  class importacion_legajoww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00282( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A626MigrLegId ,
                                          GXSimpleCollection<String> AV293Importacion_legajowwds_4_tfmigrlegid_sels ,
                                          String A597MigrLegCUIL ,
                                          GXSimpleCollection<String> AV295Importacion_legajowwds_6_tfmigrlegcuil_sels ,
                                          String A592MigrLegApellido ,
                                          GXSimpleCollection<String> AV297Importacion_legajowwds_8_tfmigrlegapellido_sels ,
                                          String A593MigrLegNombre ,
                                          GXSimpleCollection<String> AV299Importacion_legajowwds_10_tfmigrlegnombre_sels ,
                                          String A2415MigrLegModTra ,
                                          GXSimpleCollection<String> AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels ,
                                          String A2427MigrLegTipoTarifa ,
                                          GXSimpleCollection<String> AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels ,
                                          String A607MigrLegClase ,
                                          GXSimpleCollection<String> AV305Importacion_legajowwds_16_tfmigrlegclase_sels ,
                                          String A595MigrLegSexo ,
                                          GXSimpleCollection<String> AV311Importacion_legajowwds_22_tfmigrlegsexo_sels ,
                                          String A599MigrLegDomici ,
                                          GXSimpleCollection<String> AV313Importacion_legajowwds_24_tfmigrlegdomici_sels ,
                                          String A601MigrLegCodPos ,
                                          GXSimpleCollection<String> AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels ,
                                          String A602MigrLegTelefono ,
                                          GXSimpleCollection<String> AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels ,
                                          String A600MigrLegEmail ,
                                          GXSimpleCollection<String> AV319Importacion_legajowwds_30_tfmigrlegemail_sels ,
                                          String A596MigrLegEstadoCivil ,
                                          GXSimpleCollection<String> AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels ,
                                          String A605MigrLegArea ,
                                          GXSimpleCollection<String> AV323Importacion_legajowwds_34_tfmigrlegarea_sels ,
                                          String A627MigrLegConvenio ,
                                          GXSimpleCollection<String> AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels ,
                                          String A614MigrLegObraSocial ,
                                          GXSimpleCollection<String> AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels ,
                                          String A621MigrLegCBU ,
                                          GXSimpleCollection<String> AV331Importacion_legajowwds_42_tfmigrlegcbu_sels ,
                                          String A617MigrLegModalidad ,
                                          GXSimpleCollection<String> AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels ,
                                          String A628MigrLegObs ,
                                          GXSimpleCollection<String> AV337Importacion_legajowwds_48_tfmigrlegobs_sels ,
                                          String A613MigrLegSindicato ,
                                          GXSimpleCollection<String> AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels ,
                                          short AV291Importacion_legajowwds_2_tficonoupdateoperator ,
                                          int AV293Importacion_legajowwds_4_tfmigrlegid_sels_size ,
                                          String AV292Importacion_legajowwds_3_tfmigrlegid ,
                                          int AV295Importacion_legajowwds_6_tfmigrlegcuil_sels_size ,
                                          String AV294Importacion_legajowwds_5_tfmigrlegcuil ,
                                          int AV297Importacion_legajowwds_8_tfmigrlegapellido_sels_size ,
                                          String AV296Importacion_legajowwds_7_tfmigrlegapellido ,
                                          int AV299Importacion_legajowwds_10_tfmigrlegnombre_sels_size ,
                                          String AV298Importacion_legajowwds_9_tfmigrlegnombre ,
                                          int AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels_size ,
                                          String AV300Importacion_legajowwds_11_tfmigrlegmodtra ,
                                          int AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels_size ,
                                          String AV302Importacion_legajowwds_13_tfmigrlegtipotarifa ,
                                          int AV305Importacion_legajowwds_16_tfmigrlegclase_sels_size ,
                                          String AV304Importacion_legajowwds_15_tfmigrlegclase ,
                                          java.util.Date AV306Importacion_legajowwds_17_tfmigrlegfecnac ,
                                          java.util.Date AV307Importacion_legajowwds_18_tfmigrlegfecnac_to ,
                                          java.util.Date AV308Importacion_legajowwds_19_tfmigrlegfecingreso ,
                                          java.util.Date AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to ,
                                          int AV311Importacion_legajowwds_22_tfmigrlegsexo_sels_size ,
                                          String AV310Importacion_legajowwds_21_tfmigrlegsexo ,
                                          int AV313Importacion_legajowwds_24_tfmigrlegdomici_sels_size ,
                                          String AV312Importacion_legajowwds_23_tfmigrlegdomici ,
                                          int AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels_size ,
                                          String AV314Importacion_legajowwds_25_tfmigrlegcodpos ,
                                          int AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels_size ,
                                          String AV316Importacion_legajowwds_27_tfmigrlegtelefono ,
                                          int AV319Importacion_legajowwds_30_tfmigrlegemail_sels_size ,
                                          String AV318Importacion_legajowwds_29_tfmigrlegemail ,
                                          int AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels_size ,
                                          String AV320Importacion_legajowwds_31_tfmigrlegestadocivil ,
                                          int AV323Importacion_legajowwds_34_tfmigrlegarea_sels_size ,
                                          String AV322Importacion_legajowwds_33_tfmigrlegarea ,
                                          java.math.BigDecimal AV324Importacion_legajowwds_35_tfmigrlegbasico ,
                                          java.math.BigDecimal AV325Importacion_legajowwds_36_tfmigrlegbasico_to ,
                                          int AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels_size ,
                                          String AV326Importacion_legajowwds_37_tfmigrlegconvenio ,
                                          int AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels_size ,
                                          String AV328Importacion_legajowwds_39_tfmigrlegobrasocial ,
                                          int AV331Importacion_legajowwds_42_tfmigrlegcbu_sels_size ,
                                          String AV330Importacion_legajowwds_41_tfmigrlegcbu ,
                                          int AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels_size ,
                                          String AV332Importacion_legajowwds_43_tfmigrlegmodalidad ,
                                          java.math.BigDecimal AV334Importacion_legajowwds_45_tfmigrleghorsem ,
                                          java.math.BigDecimal AV335Importacion_legajowwds_46_tfmigrleghorsem_to ,
                                          int AV337Importacion_legajowwds_48_tfmigrlegobs_sels_size ,
                                          String AV336Importacion_legajowwds_47_tfmigrlegobs ,
                                          int AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels_size ,
                                          String AV338Importacion_legajowwds_49_tfmigrlegsindicato ,
                                          String A629MigrLegErrores ,
                                          String A633MigrLegWarnings ,
                                          java.util.Date A594MigrLegFecNac ,
                                          java.util.Date A603MigrLegFecIngreso ,
                                          java.math.BigDecimal A608MigrLegBasico ,
                                          java.math.BigDecimal A2275MigrLegHorSem ,
                                          short AV15OrderedBy ,
                                          boolean AV16OrderedDsc ,
                                          int AV104CliCod ,
                                          short AV105EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int56 = new byte[33];
      Object[] GXv_Object57 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " MigrLegErrores, MigrLegWarnings, MigrLegSindicato, MigrLegPueAfip, MigrLegActLabClas, MigrPuesto, MigrSueldos, MigrPeriodo, MigrLegObs, MigrCantidadHijos, MigrTieneConyuge," ;
      sSelectString += " MigrLegPlanMedico, MigrLegSCVO, MigrLegSiniestrado, MigrLegCondicion, MigrLegSituacionRevista, MigrLegActividad, MigrLegHorSem, MigrLegModalidad, MigrLegCBU, MigrLegFormaPago," ;
      sSelectString += " MigrLegCuentaBanc, MigrLegBanTipCuen, MigrLegBanSuc, MigrLegObraSocial, MigrLegBanco, MigrLegLugarDePago, MigrLegCategoria, MigrLegConvenio, MigrLegBasico, MigrLegArea," ;
      sSelectString += " MigrLegDiscapacidad, MigrLegEstadoCivil, MigrLegEmail, MigrLegTelefono, MigrLegCodPos, MigrLegDomici, MigrLegZona, MigrLegSexo, MigrLegFecIngreso, MigrLegFecNac," ;
      sSelectString += " MigrLegClase, MigrLegTipoTarifa, MigrLegModTra, MigrLegNombre, MigrLegApellido, MigrLegCUIL, MigrLegId, MigrLegNumero, EmpCod, CliCod" ;
      sFromString = " FROM importacion_legajo" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( AV291Importacion_legajowwds_2_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegErrores))=0) and Not (char_length(trim(trailing ' ' from MigrLegWarnings))=0))");
      }
      if ( AV291Importacion_legajowwds_2_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from MigrLegErrores))=0))");
      }
      if ( AV291Importacion_legajowwds_2_tficonoupdateoperator == 3 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegErrores))=0) and (char_length(trim(trailing ' ' from MigrLegWarnings))=0))");
      }
      if ( ( AV293Importacion_legajowwds_4_tfmigrlegid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV292Importacion_legajowwds_3_tfmigrlegid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegId) like LOWER(?))");
      }
      else
      {
         GXv_int56[2] = (byte)(1) ;
      }
      if ( AV293Importacion_legajowwds_4_tfmigrlegid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV293Importacion_legajowwds_4_tfmigrlegid_sels, "MigrLegId IN (", ")")+")");
      }
      if ( ( AV295Importacion_legajowwds_6_tfmigrlegcuil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV294Importacion_legajowwds_5_tfmigrlegcuil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegCUIL) like LOWER(?))");
      }
      else
      {
         GXv_int56[3] = (byte)(1) ;
      }
      if ( AV295Importacion_legajowwds_6_tfmigrlegcuil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV295Importacion_legajowwds_6_tfmigrlegcuil_sels, "MigrLegCUIL IN (", ")")+")");
      }
      if ( ( AV297Importacion_legajowwds_8_tfmigrlegapellido_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV296Importacion_legajowwds_7_tfmigrlegapellido)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegApellido) like LOWER(?))");
      }
      else
      {
         GXv_int56[4] = (byte)(1) ;
      }
      if ( AV297Importacion_legajowwds_8_tfmigrlegapellido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV297Importacion_legajowwds_8_tfmigrlegapellido_sels, "MigrLegApellido IN (", ")")+")");
      }
      if ( ( AV299Importacion_legajowwds_10_tfmigrlegnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV298Importacion_legajowwds_9_tfmigrlegnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegNombre) like LOWER(?))");
      }
      else
      {
         GXv_int56[5] = (byte)(1) ;
      }
      if ( AV299Importacion_legajowwds_10_tfmigrlegnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV299Importacion_legajowwds_10_tfmigrlegnombre_sels, "MigrLegNombre IN (", ")")+")");
      }
      if ( ( AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV300Importacion_legajowwds_11_tfmigrlegmodtra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegModTra) like LOWER(?))");
      }
      else
      {
         GXv_int56[6] = (byte)(1) ;
      }
      if ( AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels, "MigrLegModTra IN (", ")")+")");
      }
      if ( ( AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV302Importacion_legajowwds_13_tfmigrlegtipotarifa)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegTipoTarifa) like LOWER(?))");
      }
      else
      {
         GXv_int56[7] = (byte)(1) ;
      }
      if ( AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels, "MigrLegTipoTarifa IN (", ")")+")");
      }
      if ( ( AV305Importacion_legajowwds_16_tfmigrlegclase_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV304Importacion_legajowwds_15_tfmigrlegclase)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegClase) like LOWER(?))");
      }
      else
      {
         GXv_int56[8] = (byte)(1) ;
      }
      if ( AV305Importacion_legajowwds_16_tfmigrlegclase_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV305Importacion_legajowwds_16_tfmigrlegclase_sels, "MigrLegClase IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV306Importacion_legajowwds_17_tfmigrlegfecnac)) )
      {
         addWhere(sWhereString, "(MigrLegFecNac >= ?)");
      }
      else
      {
         GXv_int56[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV307Importacion_legajowwds_18_tfmigrlegfecnac_to)) )
      {
         addWhere(sWhereString, "(MigrLegFecNac <= ?)");
      }
      else
      {
         GXv_int56[10] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV308Importacion_legajowwds_19_tfmigrlegfecingreso)) )
      {
         addWhere(sWhereString, "(MigrLegFecIngreso >= ?)");
      }
      else
      {
         GXv_int56[11] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to)) )
      {
         addWhere(sWhereString, "(MigrLegFecIngreso <= ?)");
      }
      else
      {
         GXv_int56[12] = (byte)(1) ;
      }
      if ( ( AV311Importacion_legajowwds_22_tfmigrlegsexo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV310Importacion_legajowwds_21_tfmigrlegsexo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegSexo) like LOWER(?))");
      }
      else
      {
         GXv_int56[13] = (byte)(1) ;
      }
      if ( AV311Importacion_legajowwds_22_tfmigrlegsexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV311Importacion_legajowwds_22_tfmigrlegsexo_sels, "MigrLegSexo IN (", ")")+")");
      }
      if ( ( AV313Importacion_legajowwds_24_tfmigrlegdomici_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV312Importacion_legajowwds_23_tfmigrlegdomici)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegDomici) like LOWER(?))");
      }
      else
      {
         GXv_int56[14] = (byte)(1) ;
      }
      if ( AV313Importacion_legajowwds_24_tfmigrlegdomici_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV313Importacion_legajowwds_24_tfmigrlegdomici_sels, "MigrLegDomici IN (", ")")+")");
      }
      if ( ( AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV314Importacion_legajowwds_25_tfmigrlegcodpos)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegCodPos) like LOWER(?))");
      }
      else
      {
         GXv_int56[15] = (byte)(1) ;
      }
      if ( AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels, "MigrLegCodPos IN (", ")")+")");
      }
      if ( ( AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV316Importacion_legajowwds_27_tfmigrlegtelefono)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegTelefono) like LOWER(?))");
      }
      else
      {
         GXv_int56[16] = (byte)(1) ;
      }
      if ( AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels, "MigrLegTelefono IN (", ")")+")");
      }
      if ( ( AV319Importacion_legajowwds_30_tfmigrlegemail_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV318Importacion_legajowwds_29_tfmigrlegemail)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegEmail) like LOWER(?))");
      }
      else
      {
         GXv_int56[17] = (byte)(1) ;
      }
      if ( AV319Importacion_legajowwds_30_tfmigrlegemail_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV319Importacion_legajowwds_30_tfmigrlegemail_sels, "MigrLegEmail IN (", ")")+")");
      }
      if ( ( AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV320Importacion_legajowwds_31_tfmigrlegestadocivil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegEstadoCivil) like LOWER(?))");
      }
      else
      {
         GXv_int56[18] = (byte)(1) ;
      }
      if ( AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels, "MigrLegEstadoCivil IN (", ")")+")");
      }
      if ( ( AV323Importacion_legajowwds_34_tfmigrlegarea_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV322Importacion_legajowwds_33_tfmigrlegarea)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegArea) like LOWER(?))");
      }
      else
      {
         GXv_int56[19] = (byte)(1) ;
      }
      if ( AV323Importacion_legajowwds_34_tfmigrlegarea_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV323Importacion_legajowwds_34_tfmigrlegarea_sels, "MigrLegArea IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV324Importacion_legajowwds_35_tfmigrlegbasico)==0) )
      {
         addWhere(sWhereString, "(MigrLegBasico >= ?)");
      }
      else
      {
         GXv_int56[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV325Importacion_legajowwds_36_tfmigrlegbasico_to)==0) )
      {
         addWhere(sWhereString, "(MigrLegBasico <= ?)");
      }
      else
      {
         GXv_int56[21] = (byte)(1) ;
      }
      if ( ( AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV326Importacion_legajowwds_37_tfmigrlegconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int56[22] = (byte)(1) ;
      }
      if ( AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels, "MigrLegConvenio IN (", ")")+")");
      }
      if ( ( AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV328Importacion_legajowwds_39_tfmigrlegobrasocial)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegObraSocial) like LOWER(?))");
      }
      else
      {
         GXv_int56[23] = (byte)(1) ;
      }
      if ( AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels, "MigrLegObraSocial IN (", ")")+")");
      }
      if ( ( AV331Importacion_legajowwds_42_tfmigrlegcbu_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV330Importacion_legajowwds_41_tfmigrlegcbu)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegCBU) like LOWER(?))");
      }
      else
      {
         GXv_int56[24] = (byte)(1) ;
      }
      if ( AV331Importacion_legajowwds_42_tfmigrlegcbu_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV331Importacion_legajowwds_42_tfmigrlegcbu_sels, "MigrLegCBU IN (", ")")+")");
      }
      if ( ( AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV332Importacion_legajowwds_43_tfmigrlegmodalidad)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegModalidad) like LOWER(?))");
      }
      else
      {
         GXv_int56[25] = (byte)(1) ;
      }
      if ( AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels, "MigrLegModalidad IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV334Importacion_legajowwds_45_tfmigrleghorsem)==0) )
      {
         addWhere(sWhereString, "(MigrLegHorSem >= ?)");
      }
      else
      {
         GXv_int56[26] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV335Importacion_legajowwds_46_tfmigrleghorsem_to)==0) )
      {
         addWhere(sWhereString, "(MigrLegHorSem <= ?)");
      }
      else
      {
         GXv_int56[27] = (byte)(1) ;
      }
      if ( ( AV337Importacion_legajowwds_48_tfmigrlegobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV336Importacion_legajowwds_47_tfmigrlegobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegObs) like LOWER(?))");
      }
      else
      {
         GXv_int56[28] = (byte)(1) ;
      }
      if ( AV337Importacion_legajowwds_48_tfmigrlegobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV337Importacion_legajowwds_48_tfmigrlegobs_sels, "MigrLegObs IN (", ")")+")");
      }
      if ( ( AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV338Importacion_legajowwds_49_tfmigrlegsindicato)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegSindicato) like LOWER(?))");
      }
      else
      {
         GXv_int56[29] = (byte)(1) ;
      }
      if ( AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels, "MigrLegSindicato IN (", ")")+")");
      }
      if ( ( AV15OrderedBy == 1 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegId, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 1 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegId DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 2 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegCUIL, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 2 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegCUIL DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 3 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegApellido, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 3 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegApellido DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 4 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegNombre, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 4 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegNombre DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 5 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegModTra, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 5 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegModTra DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 6 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegTipoTarifa, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 6 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegTipoTarifa DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 7 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegClase, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 7 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegClase DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 8 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegFecNac, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 8 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegFecNac DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 9 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegFecIngreso, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 9 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegFecIngreso DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 10 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegSexo, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 10 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegSexo DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 11 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegDomici, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 11 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegDomici DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 12 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegCodPos, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 12 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegCodPos DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 13 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegTelefono, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 13 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegTelefono DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 14 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegEmail, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 14 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegEmail DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 15 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegEstadoCivil, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 15 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegEstadoCivil DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 16 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegArea, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 16 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegArea DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 17 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegBasico, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 17 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegBasico DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 18 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegConvenio, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 18 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegConvenio DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 19 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegObraSocial, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 19 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegObraSocial DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 20 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegCBU, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 20 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegCBU DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 21 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegModalidad, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 21 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegModalidad DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 22 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegHorSem, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 22 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegHorSem DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 23 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegObs, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 23 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegObs DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 24 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY MigrLegSindicato, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( ( AV15OrderedBy == 24 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY MigrLegSindicato DESC, CliCod, EmpCod, MigrLegNumero" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, MigrLegNumero" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object57[0] = scmdbuf ;
      GXv_Object57[1] = GXv_int56 ;
      return GXv_Object57 ;
   }

   protected Object[] conditional_H00283( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A626MigrLegId ,
                                          GXSimpleCollection<String> AV293Importacion_legajowwds_4_tfmigrlegid_sels ,
                                          String A597MigrLegCUIL ,
                                          GXSimpleCollection<String> AV295Importacion_legajowwds_6_tfmigrlegcuil_sels ,
                                          String A592MigrLegApellido ,
                                          GXSimpleCollection<String> AV297Importacion_legajowwds_8_tfmigrlegapellido_sels ,
                                          String A593MigrLegNombre ,
                                          GXSimpleCollection<String> AV299Importacion_legajowwds_10_tfmigrlegnombre_sels ,
                                          String A2415MigrLegModTra ,
                                          GXSimpleCollection<String> AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels ,
                                          String A2427MigrLegTipoTarifa ,
                                          GXSimpleCollection<String> AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels ,
                                          String A607MigrLegClase ,
                                          GXSimpleCollection<String> AV305Importacion_legajowwds_16_tfmigrlegclase_sels ,
                                          String A595MigrLegSexo ,
                                          GXSimpleCollection<String> AV311Importacion_legajowwds_22_tfmigrlegsexo_sels ,
                                          String A599MigrLegDomici ,
                                          GXSimpleCollection<String> AV313Importacion_legajowwds_24_tfmigrlegdomici_sels ,
                                          String A601MigrLegCodPos ,
                                          GXSimpleCollection<String> AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels ,
                                          String A602MigrLegTelefono ,
                                          GXSimpleCollection<String> AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels ,
                                          String A600MigrLegEmail ,
                                          GXSimpleCollection<String> AV319Importacion_legajowwds_30_tfmigrlegemail_sels ,
                                          String A596MigrLegEstadoCivil ,
                                          GXSimpleCollection<String> AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels ,
                                          String A605MigrLegArea ,
                                          GXSimpleCollection<String> AV323Importacion_legajowwds_34_tfmigrlegarea_sels ,
                                          String A627MigrLegConvenio ,
                                          GXSimpleCollection<String> AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels ,
                                          String A614MigrLegObraSocial ,
                                          GXSimpleCollection<String> AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels ,
                                          String A621MigrLegCBU ,
                                          GXSimpleCollection<String> AV331Importacion_legajowwds_42_tfmigrlegcbu_sels ,
                                          String A617MigrLegModalidad ,
                                          GXSimpleCollection<String> AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels ,
                                          String A628MigrLegObs ,
                                          GXSimpleCollection<String> AV337Importacion_legajowwds_48_tfmigrlegobs_sels ,
                                          String A613MigrLegSindicato ,
                                          GXSimpleCollection<String> AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels ,
                                          short AV291Importacion_legajowwds_2_tficonoupdateoperator ,
                                          int AV293Importacion_legajowwds_4_tfmigrlegid_sels_size ,
                                          String AV292Importacion_legajowwds_3_tfmigrlegid ,
                                          int AV295Importacion_legajowwds_6_tfmigrlegcuil_sels_size ,
                                          String AV294Importacion_legajowwds_5_tfmigrlegcuil ,
                                          int AV297Importacion_legajowwds_8_tfmigrlegapellido_sels_size ,
                                          String AV296Importacion_legajowwds_7_tfmigrlegapellido ,
                                          int AV299Importacion_legajowwds_10_tfmigrlegnombre_sels_size ,
                                          String AV298Importacion_legajowwds_9_tfmigrlegnombre ,
                                          int AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels_size ,
                                          String AV300Importacion_legajowwds_11_tfmigrlegmodtra ,
                                          int AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels_size ,
                                          String AV302Importacion_legajowwds_13_tfmigrlegtipotarifa ,
                                          int AV305Importacion_legajowwds_16_tfmigrlegclase_sels_size ,
                                          String AV304Importacion_legajowwds_15_tfmigrlegclase ,
                                          java.util.Date AV306Importacion_legajowwds_17_tfmigrlegfecnac ,
                                          java.util.Date AV307Importacion_legajowwds_18_tfmigrlegfecnac_to ,
                                          java.util.Date AV308Importacion_legajowwds_19_tfmigrlegfecingreso ,
                                          java.util.Date AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to ,
                                          int AV311Importacion_legajowwds_22_tfmigrlegsexo_sels_size ,
                                          String AV310Importacion_legajowwds_21_tfmigrlegsexo ,
                                          int AV313Importacion_legajowwds_24_tfmigrlegdomici_sels_size ,
                                          String AV312Importacion_legajowwds_23_tfmigrlegdomici ,
                                          int AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels_size ,
                                          String AV314Importacion_legajowwds_25_tfmigrlegcodpos ,
                                          int AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels_size ,
                                          String AV316Importacion_legajowwds_27_tfmigrlegtelefono ,
                                          int AV319Importacion_legajowwds_30_tfmigrlegemail_sels_size ,
                                          String AV318Importacion_legajowwds_29_tfmigrlegemail ,
                                          int AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels_size ,
                                          String AV320Importacion_legajowwds_31_tfmigrlegestadocivil ,
                                          int AV323Importacion_legajowwds_34_tfmigrlegarea_sels_size ,
                                          String AV322Importacion_legajowwds_33_tfmigrlegarea ,
                                          java.math.BigDecimal AV324Importacion_legajowwds_35_tfmigrlegbasico ,
                                          java.math.BigDecimal AV325Importacion_legajowwds_36_tfmigrlegbasico_to ,
                                          int AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels_size ,
                                          String AV326Importacion_legajowwds_37_tfmigrlegconvenio ,
                                          int AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels_size ,
                                          String AV328Importacion_legajowwds_39_tfmigrlegobrasocial ,
                                          int AV331Importacion_legajowwds_42_tfmigrlegcbu_sels_size ,
                                          String AV330Importacion_legajowwds_41_tfmigrlegcbu ,
                                          int AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels_size ,
                                          String AV332Importacion_legajowwds_43_tfmigrlegmodalidad ,
                                          java.math.BigDecimal AV334Importacion_legajowwds_45_tfmigrleghorsem ,
                                          java.math.BigDecimal AV335Importacion_legajowwds_46_tfmigrleghorsem_to ,
                                          int AV337Importacion_legajowwds_48_tfmigrlegobs_sels_size ,
                                          String AV336Importacion_legajowwds_47_tfmigrlegobs ,
                                          int AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels_size ,
                                          String AV338Importacion_legajowwds_49_tfmigrlegsindicato ,
                                          String A629MigrLegErrores ,
                                          String A633MigrLegWarnings ,
                                          java.util.Date A594MigrLegFecNac ,
                                          java.util.Date A603MigrLegFecIngreso ,
                                          java.math.BigDecimal A608MigrLegBasico ,
                                          java.math.BigDecimal A2275MigrLegHorSem ,
                                          short AV15OrderedBy ,
                                          boolean AV16OrderedDsc ,
                                          int AV104CliCod ,
                                          short AV105EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int59 = new byte[30];
      Object[] GXv_Object60 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM importacion_legajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( AV291Importacion_legajowwds_2_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegErrores))=0) and Not (char_length(trim(trailing ' ' from MigrLegWarnings))=0))");
      }
      if ( AV291Importacion_legajowwds_2_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from MigrLegErrores))=0))");
      }
      if ( AV291Importacion_legajowwds_2_tficonoupdateoperator == 3 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegErrores))=0) and (char_length(trim(trailing ' ' from MigrLegWarnings))=0))");
      }
      if ( ( AV293Importacion_legajowwds_4_tfmigrlegid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV292Importacion_legajowwds_3_tfmigrlegid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegId) like LOWER(?))");
      }
      else
      {
         GXv_int59[2] = (byte)(1) ;
      }
      if ( AV293Importacion_legajowwds_4_tfmigrlegid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV293Importacion_legajowwds_4_tfmigrlegid_sels, "MigrLegId IN (", ")")+")");
      }
      if ( ( AV295Importacion_legajowwds_6_tfmigrlegcuil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV294Importacion_legajowwds_5_tfmigrlegcuil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegCUIL) like LOWER(?))");
      }
      else
      {
         GXv_int59[3] = (byte)(1) ;
      }
      if ( AV295Importacion_legajowwds_6_tfmigrlegcuil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV295Importacion_legajowwds_6_tfmigrlegcuil_sels, "MigrLegCUIL IN (", ")")+")");
      }
      if ( ( AV297Importacion_legajowwds_8_tfmigrlegapellido_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV296Importacion_legajowwds_7_tfmigrlegapellido)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegApellido) like LOWER(?))");
      }
      else
      {
         GXv_int59[4] = (byte)(1) ;
      }
      if ( AV297Importacion_legajowwds_8_tfmigrlegapellido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV297Importacion_legajowwds_8_tfmigrlegapellido_sels, "MigrLegApellido IN (", ")")+")");
      }
      if ( ( AV299Importacion_legajowwds_10_tfmigrlegnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV298Importacion_legajowwds_9_tfmigrlegnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegNombre) like LOWER(?))");
      }
      else
      {
         GXv_int59[5] = (byte)(1) ;
      }
      if ( AV299Importacion_legajowwds_10_tfmigrlegnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV299Importacion_legajowwds_10_tfmigrlegnombre_sels, "MigrLegNombre IN (", ")")+")");
      }
      if ( ( AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV300Importacion_legajowwds_11_tfmigrlegmodtra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegModTra) like LOWER(?))");
      }
      else
      {
         GXv_int59[6] = (byte)(1) ;
      }
      if ( AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels, "MigrLegModTra IN (", ")")+")");
      }
      if ( ( AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV302Importacion_legajowwds_13_tfmigrlegtipotarifa)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegTipoTarifa) like LOWER(?))");
      }
      else
      {
         GXv_int59[7] = (byte)(1) ;
      }
      if ( AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels, "MigrLegTipoTarifa IN (", ")")+")");
      }
      if ( ( AV305Importacion_legajowwds_16_tfmigrlegclase_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV304Importacion_legajowwds_15_tfmigrlegclase)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegClase) like LOWER(?))");
      }
      else
      {
         GXv_int59[8] = (byte)(1) ;
      }
      if ( AV305Importacion_legajowwds_16_tfmigrlegclase_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV305Importacion_legajowwds_16_tfmigrlegclase_sels, "MigrLegClase IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV306Importacion_legajowwds_17_tfmigrlegfecnac)) )
      {
         addWhere(sWhereString, "(MigrLegFecNac >= ?)");
      }
      else
      {
         GXv_int59[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV307Importacion_legajowwds_18_tfmigrlegfecnac_to)) )
      {
         addWhere(sWhereString, "(MigrLegFecNac <= ?)");
      }
      else
      {
         GXv_int59[10] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV308Importacion_legajowwds_19_tfmigrlegfecingreso)) )
      {
         addWhere(sWhereString, "(MigrLegFecIngreso >= ?)");
      }
      else
      {
         GXv_int59[11] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to)) )
      {
         addWhere(sWhereString, "(MigrLegFecIngreso <= ?)");
      }
      else
      {
         GXv_int59[12] = (byte)(1) ;
      }
      if ( ( AV311Importacion_legajowwds_22_tfmigrlegsexo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV310Importacion_legajowwds_21_tfmigrlegsexo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegSexo) like LOWER(?))");
      }
      else
      {
         GXv_int59[13] = (byte)(1) ;
      }
      if ( AV311Importacion_legajowwds_22_tfmigrlegsexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV311Importacion_legajowwds_22_tfmigrlegsexo_sels, "MigrLegSexo IN (", ")")+")");
      }
      if ( ( AV313Importacion_legajowwds_24_tfmigrlegdomici_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV312Importacion_legajowwds_23_tfmigrlegdomici)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegDomici) like LOWER(?))");
      }
      else
      {
         GXv_int59[14] = (byte)(1) ;
      }
      if ( AV313Importacion_legajowwds_24_tfmigrlegdomici_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV313Importacion_legajowwds_24_tfmigrlegdomici_sels, "MigrLegDomici IN (", ")")+")");
      }
      if ( ( AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV314Importacion_legajowwds_25_tfmigrlegcodpos)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegCodPos) like LOWER(?))");
      }
      else
      {
         GXv_int59[15] = (byte)(1) ;
      }
      if ( AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels, "MigrLegCodPos IN (", ")")+")");
      }
      if ( ( AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV316Importacion_legajowwds_27_tfmigrlegtelefono)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegTelefono) like LOWER(?))");
      }
      else
      {
         GXv_int59[16] = (byte)(1) ;
      }
      if ( AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels, "MigrLegTelefono IN (", ")")+")");
      }
      if ( ( AV319Importacion_legajowwds_30_tfmigrlegemail_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV318Importacion_legajowwds_29_tfmigrlegemail)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegEmail) like LOWER(?))");
      }
      else
      {
         GXv_int59[17] = (byte)(1) ;
      }
      if ( AV319Importacion_legajowwds_30_tfmigrlegemail_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV319Importacion_legajowwds_30_tfmigrlegemail_sels, "MigrLegEmail IN (", ")")+")");
      }
      if ( ( AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV320Importacion_legajowwds_31_tfmigrlegestadocivil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegEstadoCivil) like LOWER(?))");
      }
      else
      {
         GXv_int59[18] = (byte)(1) ;
      }
      if ( AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels, "MigrLegEstadoCivil IN (", ")")+")");
      }
      if ( ( AV323Importacion_legajowwds_34_tfmigrlegarea_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV322Importacion_legajowwds_33_tfmigrlegarea)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegArea) like LOWER(?))");
      }
      else
      {
         GXv_int59[19] = (byte)(1) ;
      }
      if ( AV323Importacion_legajowwds_34_tfmigrlegarea_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV323Importacion_legajowwds_34_tfmigrlegarea_sels, "MigrLegArea IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV324Importacion_legajowwds_35_tfmigrlegbasico)==0) )
      {
         addWhere(sWhereString, "(MigrLegBasico >= ?)");
      }
      else
      {
         GXv_int59[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV325Importacion_legajowwds_36_tfmigrlegbasico_to)==0) )
      {
         addWhere(sWhereString, "(MigrLegBasico <= ?)");
      }
      else
      {
         GXv_int59[21] = (byte)(1) ;
      }
      if ( ( AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV326Importacion_legajowwds_37_tfmigrlegconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int59[22] = (byte)(1) ;
      }
      if ( AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels, "MigrLegConvenio IN (", ")")+")");
      }
      if ( ( AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV328Importacion_legajowwds_39_tfmigrlegobrasocial)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegObraSocial) like LOWER(?))");
      }
      else
      {
         GXv_int59[23] = (byte)(1) ;
      }
      if ( AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels, "MigrLegObraSocial IN (", ")")+")");
      }
      if ( ( AV331Importacion_legajowwds_42_tfmigrlegcbu_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV330Importacion_legajowwds_41_tfmigrlegcbu)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegCBU) like LOWER(?))");
      }
      else
      {
         GXv_int59[24] = (byte)(1) ;
      }
      if ( AV331Importacion_legajowwds_42_tfmigrlegcbu_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV331Importacion_legajowwds_42_tfmigrlegcbu_sels, "MigrLegCBU IN (", ")")+")");
      }
      if ( ( AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV332Importacion_legajowwds_43_tfmigrlegmodalidad)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegModalidad) like LOWER(?))");
      }
      else
      {
         GXv_int59[25] = (byte)(1) ;
      }
      if ( AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels, "MigrLegModalidad IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV334Importacion_legajowwds_45_tfmigrleghorsem)==0) )
      {
         addWhere(sWhereString, "(MigrLegHorSem >= ?)");
      }
      else
      {
         GXv_int59[26] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV335Importacion_legajowwds_46_tfmigrleghorsem_to)==0) )
      {
         addWhere(sWhereString, "(MigrLegHorSem <= ?)");
      }
      else
      {
         GXv_int59[27] = (byte)(1) ;
      }
      if ( ( AV337Importacion_legajowwds_48_tfmigrlegobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV336Importacion_legajowwds_47_tfmigrlegobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegObs) like LOWER(?))");
      }
      else
      {
         GXv_int59[28] = (byte)(1) ;
      }
      if ( AV337Importacion_legajowwds_48_tfmigrlegobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV337Importacion_legajowwds_48_tfmigrlegobs_sels, "MigrLegObs IN (", ")")+")");
      }
      if ( ( AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV338Importacion_legajowwds_49_tfmigrlegsindicato)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegSindicato) like LOWER(?))");
      }
      else
      {
         GXv_int59[29] = (byte)(1) ;
      }
      if ( AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels, "MigrLegSindicato IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV15OrderedBy == 1 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 1 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 2 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 2 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 3 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 3 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 4 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 4 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 5 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 5 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 6 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 6 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 7 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 7 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 8 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 8 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 9 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 9 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 10 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 10 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 11 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 11 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 12 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 12 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 13 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 13 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 14 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 14 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 15 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 15 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 16 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 16 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 17 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 17 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 18 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 18 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 19 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 19 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 20 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 20 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 21 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 21 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 22 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 22 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 23 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 23 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 24 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 24 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object60[0] = scmdbuf ;
      GXv_Object60[1] = GXv_int59 ;
      return GXv_Object60 ;
   }

   protected Object[] conditional_H00285( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A626MigrLegId ,
                                          GXSimpleCollection<String> AV293Importacion_legajowwds_4_tfmigrlegid_sels ,
                                          String A597MigrLegCUIL ,
                                          GXSimpleCollection<String> AV295Importacion_legajowwds_6_tfmigrlegcuil_sels ,
                                          String A592MigrLegApellido ,
                                          GXSimpleCollection<String> AV297Importacion_legajowwds_8_tfmigrlegapellido_sels ,
                                          String A593MigrLegNombre ,
                                          GXSimpleCollection<String> AV299Importacion_legajowwds_10_tfmigrlegnombre_sels ,
                                          String A2415MigrLegModTra ,
                                          GXSimpleCollection<String> AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels ,
                                          String A2427MigrLegTipoTarifa ,
                                          GXSimpleCollection<String> AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels ,
                                          String A607MigrLegClase ,
                                          GXSimpleCollection<String> AV305Importacion_legajowwds_16_tfmigrlegclase_sels ,
                                          String A595MigrLegSexo ,
                                          GXSimpleCollection<String> AV311Importacion_legajowwds_22_tfmigrlegsexo_sels ,
                                          String A599MigrLegDomici ,
                                          GXSimpleCollection<String> AV313Importacion_legajowwds_24_tfmigrlegdomici_sels ,
                                          String A601MigrLegCodPos ,
                                          GXSimpleCollection<String> AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels ,
                                          String A602MigrLegTelefono ,
                                          GXSimpleCollection<String> AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels ,
                                          String A600MigrLegEmail ,
                                          GXSimpleCollection<String> AV319Importacion_legajowwds_30_tfmigrlegemail_sels ,
                                          String A596MigrLegEstadoCivil ,
                                          GXSimpleCollection<String> AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels ,
                                          String A605MigrLegArea ,
                                          GXSimpleCollection<String> AV323Importacion_legajowwds_34_tfmigrlegarea_sels ,
                                          String A627MigrLegConvenio ,
                                          GXSimpleCollection<String> AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels ,
                                          String A614MigrLegObraSocial ,
                                          GXSimpleCollection<String> AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels ,
                                          String A621MigrLegCBU ,
                                          GXSimpleCollection<String> AV331Importacion_legajowwds_42_tfmigrlegcbu_sels ,
                                          String A617MigrLegModalidad ,
                                          GXSimpleCollection<String> AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels ,
                                          String A628MigrLegObs ,
                                          GXSimpleCollection<String> AV337Importacion_legajowwds_48_tfmigrlegobs_sels ,
                                          String A613MigrLegSindicato ,
                                          GXSimpleCollection<String> AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels ,
                                          short AV291Importacion_legajowwds_2_tficonoupdateoperator ,
                                          int AV293Importacion_legajowwds_4_tfmigrlegid_sels_size ,
                                          String AV292Importacion_legajowwds_3_tfmigrlegid ,
                                          int AV295Importacion_legajowwds_6_tfmigrlegcuil_sels_size ,
                                          String AV294Importacion_legajowwds_5_tfmigrlegcuil ,
                                          int AV297Importacion_legajowwds_8_tfmigrlegapellido_sels_size ,
                                          String AV296Importacion_legajowwds_7_tfmigrlegapellido ,
                                          int AV299Importacion_legajowwds_10_tfmigrlegnombre_sels_size ,
                                          String AV298Importacion_legajowwds_9_tfmigrlegnombre ,
                                          int AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels_size ,
                                          String AV300Importacion_legajowwds_11_tfmigrlegmodtra ,
                                          int AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels_size ,
                                          String AV302Importacion_legajowwds_13_tfmigrlegtipotarifa ,
                                          int AV305Importacion_legajowwds_16_tfmigrlegclase_sels_size ,
                                          String AV304Importacion_legajowwds_15_tfmigrlegclase ,
                                          java.util.Date AV306Importacion_legajowwds_17_tfmigrlegfecnac ,
                                          java.util.Date AV307Importacion_legajowwds_18_tfmigrlegfecnac_to ,
                                          java.util.Date AV308Importacion_legajowwds_19_tfmigrlegfecingreso ,
                                          java.util.Date AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to ,
                                          int AV311Importacion_legajowwds_22_tfmigrlegsexo_sels_size ,
                                          String AV310Importacion_legajowwds_21_tfmigrlegsexo ,
                                          int AV313Importacion_legajowwds_24_tfmigrlegdomici_sels_size ,
                                          String AV312Importacion_legajowwds_23_tfmigrlegdomici ,
                                          int AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels_size ,
                                          String AV314Importacion_legajowwds_25_tfmigrlegcodpos ,
                                          int AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels_size ,
                                          String AV316Importacion_legajowwds_27_tfmigrlegtelefono ,
                                          int AV319Importacion_legajowwds_30_tfmigrlegemail_sels_size ,
                                          String AV318Importacion_legajowwds_29_tfmigrlegemail ,
                                          int AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels_size ,
                                          String AV320Importacion_legajowwds_31_tfmigrlegestadocivil ,
                                          int AV323Importacion_legajowwds_34_tfmigrlegarea_sels_size ,
                                          String AV322Importacion_legajowwds_33_tfmigrlegarea ,
                                          java.math.BigDecimal AV324Importacion_legajowwds_35_tfmigrlegbasico ,
                                          java.math.BigDecimal AV325Importacion_legajowwds_36_tfmigrlegbasico_to ,
                                          int AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels_size ,
                                          String AV326Importacion_legajowwds_37_tfmigrlegconvenio ,
                                          int AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels_size ,
                                          String AV328Importacion_legajowwds_39_tfmigrlegobrasocial ,
                                          int AV331Importacion_legajowwds_42_tfmigrlegcbu_sels_size ,
                                          String AV330Importacion_legajowwds_41_tfmigrlegcbu ,
                                          int AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels_size ,
                                          String AV332Importacion_legajowwds_43_tfmigrlegmodalidad ,
                                          java.math.BigDecimal AV334Importacion_legajowwds_45_tfmigrleghorsem ,
                                          java.math.BigDecimal AV335Importacion_legajowwds_46_tfmigrleghorsem_to ,
                                          int AV337Importacion_legajowwds_48_tfmigrlegobs_sels_size ,
                                          String AV336Importacion_legajowwds_47_tfmigrlegobs ,
                                          int AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels_size ,
                                          String AV338Importacion_legajowwds_49_tfmigrlegsindicato ,
                                          String A629MigrLegErrores ,
                                          String A633MigrLegWarnings ,
                                          java.util.Date A594MigrLegFecNac ,
                                          java.util.Date A603MigrLegFecIngreso ,
                                          java.math.BigDecimal A608MigrLegBasico ,
                                          java.math.BigDecimal A2275MigrLegHorSem ,
                                          int AV104CliCod ,
                                          short AV105EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int62 = new byte[30];
      Object[] GXv_Object63 = new Object[2];
      scmdbuf = "SELECT EmpCod, CliCod, MigrLegWarnings, MigrLegErrores, MigrLegSindicato, MigrLegObs, MigrLegHorSem, MigrLegModalidad, MigrLegCBU, MigrLegObraSocial, MigrLegConvenio," ;
      scmdbuf += " MigrLegBasico, MigrLegArea, MigrLegEstadoCivil, MigrLegEmail, MigrLegTelefono, MigrLegCodPos, MigrLegDomici, MigrLegSexo, MigrLegFecIngreso, MigrLegFecNac, MigrLegClase," ;
      scmdbuf += " MigrLegTipoTarifa, MigrLegModTra, MigrLegNombre, MigrLegApellido, MigrLegCUIL, MigrLegId, MigrLegNumero FROM importacion_legajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( AV291Importacion_legajowwds_2_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegErrores))=0) and Not (char_length(trim(trailing ' ' from MigrLegWarnings))=0))");
      }
      if ( AV291Importacion_legajowwds_2_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from MigrLegErrores))=0))");
      }
      if ( AV291Importacion_legajowwds_2_tficonoupdateoperator == 3 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegErrores))=0) and (char_length(trim(trailing ' ' from MigrLegWarnings))=0))");
      }
      if ( ( AV293Importacion_legajowwds_4_tfmigrlegid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV292Importacion_legajowwds_3_tfmigrlegid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegId) like LOWER(?))");
      }
      else
      {
         GXv_int62[2] = (byte)(1) ;
      }
      if ( AV293Importacion_legajowwds_4_tfmigrlegid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV293Importacion_legajowwds_4_tfmigrlegid_sels, "MigrLegId IN (", ")")+")");
      }
      if ( ( AV295Importacion_legajowwds_6_tfmigrlegcuil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV294Importacion_legajowwds_5_tfmigrlegcuil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegCUIL) like LOWER(?))");
      }
      else
      {
         GXv_int62[3] = (byte)(1) ;
      }
      if ( AV295Importacion_legajowwds_6_tfmigrlegcuil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV295Importacion_legajowwds_6_tfmigrlegcuil_sels, "MigrLegCUIL IN (", ")")+")");
      }
      if ( ( AV297Importacion_legajowwds_8_tfmigrlegapellido_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV296Importacion_legajowwds_7_tfmigrlegapellido)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegApellido) like LOWER(?))");
      }
      else
      {
         GXv_int62[4] = (byte)(1) ;
      }
      if ( AV297Importacion_legajowwds_8_tfmigrlegapellido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV297Importacion_legajowwds_8_tfmigrlegapellido_sels, "MigrLegApellido IN (", ")")+")");
      }
      if ( ( AV299Importacion_legajowwds_10_tfmigrlegnombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV298Importacion_legajowwds_9_tfmigrlegnombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegNombre) like LOWER(?))");
      }
      else
      {
         GXv_int62[5] = (byte)(1) ;
      }
      if ( AV299Importacion_legajowwds_10_tfmigrlegnombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV299Importacion_legajowwds_10_tfmigrlegnombre_sels, "MigrLegNombre IN (", ")")+")");
      }
      if ( ( AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV300Importacion_legajowwds_11_tfmigrlegmodtra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegModTra) like LOWER(?))");
      }
      else
      {
         GXv_int62[6] = (byte)(1) ;
      }
      if ( AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV301Importacion_legajowwds_12_tfmigrlegmodtra_sels, "MigrLegModTra IN (", ")")+")");
      }
      if ( ( AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV302Importacion_legajowwds_13_tfmigrlegtipotarifa)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegTipoTarifa) like LOWER(?))");
      }
      else
      {
         GXv_int62[7] = (byte)(1) ;
      }
      if ( AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV303Importacion_legajowwds_14_tfmigrlegtipotarifa_sels, "MigrLegTipoTarifa IN (", ")")+")");
      }
      if ( ( AV305Importacion_legajowwds_16_tfmigrlegclase_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV304Importacion_legajowwds_15_tfmigrlegclase)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegClase) like LOWER(?))");
      }
      else
      {
         GXv_int62[8] = (byte)(1) ;
      }
      if ( AV305Importacion_legajowwds_16_tfmigrlegclase_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV305Importacion_legajowwds_16_tfmigrlegclase_sels, "MigrLegClase IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV306Importacion_legajowwds_17_tfmigrlegfecnac)) )
      {
         addWhere(sWhereString, "(MigrLegFecNac >= ?)");
      }
      else
      {
         GXv_int62[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV307Importacion_legajowwds_18_tfmigrlegfecnac_to)) )
      {
         addWhere(sWhereString, "(MigrLegFecNac <= ?)");
      }
      else
      {
         GXv_int62[10] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV308Importacion_legajowwds_19_tfmigrlegfecingreso)) )
      {
         addWhere(sWhereString, "(MigrLegFecIngreso >= ?)");
      }
      else
      {
         GXv_int62[11] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV309Importacion_legajowwds_20_tfmigrlegfecingreso_to)) )
      {
         addWhere(sWhereString, "(MigrLegFecIngreso <= ?)");
      }
      else
      {
         GXv_int62[12] = (byte)(1) ;
      }
      if ( ( AV311Importacion_legajowwds_22_tfmigrlegsexo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV310Importacion_legajowwds_21_tfmigrlegsexo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegSexo) like LOWER(?))");
      }
      else
      {
         GXv_int62[13] = (byte)(1) ;
      }
      if ( AV311Importacion_legajowwds_22_tfmigrlegsexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV311Importacion_legajowwds_22_tfmigrlegsexo_sels, "MigrLegSexo IN (", ")")+")");
      }
      if ( ( AV313Importacion_legajowwds_24_tfmigrlegdomici_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV312Importacion_legajowwds_23_tfmigrlegdomici)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegDomici) like LOWER(?))");
      }
      else
      {
         GXv_int62[14] = (byte)(1) ;
      }
      if ( AV313Importacion_legajowwds_24_tfmigrlegdomici_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV313Importacion_legajowwds_24_tfmigrlegdomici_sels, "MigrLegDomici IN (", ")")+")");
      }
      if ( ( AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV314Importacion_legajowwds_25_tfmigrlegcodpos)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegCodPos) like LOWER(?))");
      }
      else
      {
         GXv_int62[15] = (byte)(1) ;
      }
      if ( AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV315Importacion_legajowwds_26_tfmigrlegcodpos_sels, "MigrLegCodPos IN (", ")")+")");
      }
      if ( ( AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV316Importacion_legajowwds_27_tfmigrlegtelefono)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegTelefono) like LOWER(?))");
      }
      else
      {
         GXv_int62[16] = (byte)(1) ;
      }
      if ( AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV317Importacion_legajowwds_28_tfmigrlegtelefono_sels, "MigrLegTelefono IN (", ")")+")");
      }
      if ( ( AV319Importacion_legajowwds_30_tfmigrlegemail_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV318Importacion_legajowwds_29_tfmigrlegemail)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegEmail) like LOWER(?))");
      }
      else
      {
         GXv_int62[17] = (byte)(1) ;
      }
      if ( AV319Importacion_legajowwds_30_tfmigrlegemail_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV319Importacion_legajowwds_30_tfmigrlegemail_sels, "MigrLegEmail IN (", ")")+")");
      }
      if ( ( AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV320Importacion_legajowwds_31_tfmigrlegestadocivil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegEstadoCivil) like LOWER(?))");
      }
      else
      {
         GXv_int62[18] = (byte)(1) ;
      }
      if ( AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV321Importacion_legajowwds_32_tfmigrlegestadocivil_sels, "MigrLegEstadoCivil IN (", ")")+")");
      }
      if ( ( AV323Importacion_legajowwds_34_tfmigrlegarea_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV322Importacion_legajowwds_33_tfmigrlegarea)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegArea) like LOWER(?))");
      }
      else
      {
         GXv_int62[19] = (byte)(1) ;
      }
      if ( AV323Importacion_legajowwds_34_tfmigrlegarea_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV323Importacion_legajowwds_34_tfmigrlegarea_sels, "MigrLegArea IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV324Importacion_legajowwds_35_tfmigrlegbasico)==0) )
      {
         addWhere(sWhereString, "(MigrLegBasico >= ?)");
      }
      else
      {
         GXv_int62[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV325Importacion_legajowwds_36_tfmigrlegbasico_to)==0) )
      {
         addWhere(sWhereString, "(MigrLegBasico <= ?)");
      }
      else
      {
         GXv_int62[21] = (byte)(1) ;
      }
      if ( ( AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV326Importacion_legajowwds_37_tfmigrlegconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int62[22] = (byte)(1) ;
      }
      if ( AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV327Importacion_legajowwds_38_tfmigrlegconvenio_sels, "MigrLegConvenio IN (", ")")+")");
      }
      if ( ( AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV328Importacion_legajowwds_39_tfmigrlegobrasocial)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegObraSocial) like LOWER(?))");
      }
      else
      {
         GXv_int62[23] = (byte)(1) ;
      }
      if ( AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV329Importacion_legajowwds_40_tfmigrlegobrasocial_sels, "MigrLegObraSocial IN (", ")")+")");
      }
      if ( ( AV331Importacion_legajowwds_42_tfmigrlegcbu_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV330Importacion_legajowwds_41_tfmigrlegcbu)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegCBU) like LOWER(?))");
      }
      else
      {
         GXv_int62[24] = (byte)(1) ;
      }
      if ( AV331Importacion_legajowwds_42_tfmigrlegcbu_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV331Importacion_legajowwds_42_tfmigrlegcbu_sels, "MigrLegCBU IN (", ")")+")");
      }
      if ( ( AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV332Importacion_legajowwds_43_tfmigrlegmodalidad)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegModalidad) like LOWER(?))");
      }
      else
      {
         GXv_int62[25] = (byte)(1) ;
      }
      if ( AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV333Importacion_legajowwds_44_tfmigrlegmodalidad_sels, "MigrLegModalidad IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV334Importacion_legajowwds_45_tfmigrleghorsem)==0) )
      {
         addWhere(sWhereString, "(MigrLegHorSem >= ?)");
      }
      else
      {
         GXv_int62[26] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV335Importacion_legajowwds_46_tfmigrleghorsem_to)==0) )
      {
         addWhere(sWhereString, "(MigrLegHorSem <= ?)");
      }
      else
      {
         GXv_int62[27] = (byte)(1) ;
      }
      if ( ( AV337Importacion_legajowwds_48_tfmigrlegobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV336Importacion_legajowwds_47_tfmigrlegobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegObs) like LOWER(?))");
      }
      else
      {
         GXv_int62[28] = (byte)(1) ;
      }
      if ( AV337Importacion_legajowwds_48_tfmigrlegobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV337Importacion_legajowwds_48_tfmigrlegobs_sels, "MigrLegObs IN (", ")")+")");
      }
      if ( ( AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV338Importacion_legajowwds_49_tfmigrlegsindicato)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegSindicato) like LOWER(?))");
      }
      else
      {
         GXv_int62[29] = (byte)(1) ;
      }
      if ( AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV339Importacion_legajowwds_50_tfmigrlegsindicato_sels, "MigrLegSindicato IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      GXv_Object63[0] = scmdbuf ;
      GXv_Object63[1] = GXv_int62 ;
      return GXv_Object63 ;
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
                  return conditional_H00282(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (String)dynConstraints[20] , (GXSimpleCollection<String>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (String)dynConstraints[26] , (GXSimpleCollection<String>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , (String)dynConstraints[36] , (GXSimpleCollection<String>)dynConstraints[37] , (String)dynConstraints[38] , (GXSimpleCollection<String>)dynConstraints[39] , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , ((Number) dynConstraints[43]).intValue() , (String)dynConstraints[44] , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , (String)dynConstraints[48] , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (java.util.Date)dynConstraints[55] , (java.util.Date)dynConstraints[56] , (java.util.Date)dynConstraints[57] , (java.util.Date)dynConstraints[58] , ((Number) dynConstraints[59]).intValue() , (String)dynConstraints[60] , ((Number) dynConstraints[61]).intValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , ((Number) dynConstraints[65]).intValue() , (String)dynConstraints[66] , ((Number) dynConstraints[67]).intValue() , (String)dynConstraints[68] , ((Number) dynConstraints[69]).intValue() , (String)dynConstraints[70] , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (java.math.BigDecimal)dynConstraints[73] , (java.math.BigDecimal)dynConstraints[74] , ((Number) dynConstraints[75]).intValue() , (String)dynConstraints[76] , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , ((Number) dynConstraints[79]).intValue() , (String)dynConstraints[80] , ((Number) dynConstraints[81]).intValue() , (String)dynConstraints[82] , (java.math.BigDecimal)dynConstraints[83] , (java.math.BigDecimal)dynConstraints[84] , ((Number) dynConstraints[85]).intValue() , (String)dynConstraints[86] , ((Number) dynConstraints[87]).intValue() , (String)dynConstraints[88] , (String)dynConstraints[89] , (String)dynConstraints[90] , (java.util.Date)dynConstraints[91] , (java.util.Date)dynConstraints[92] , (java.math.BigDecimal)dynConstraints[93] , (java.math.BigDecimal)dynConstraints[94] , ((Number) dynConstraints[95]).shortValue() , ((Boolean) dynConstraints[96]).booleanValue() , ((Number) dynConstraints[97]).intValue() , ((Number) dynConstraints[98]).shortValue() , ((Number) dynConstraints[99]).intValue() , ((Number) dynConstraints[100]).shortValue() );
            case 1 :
                  return conditional_H00283(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (String)dynConstraints[20] , (GXSimpleCollection<String>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (String)dynConstraints[26] , (GXSimpleCollection<String>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , (String)dynConstraints[36] , (GXSimpleCollection<String>)dynConstraints[37] , (String)dynConstraints[38] , (GXSimpleCollection<String>)dynConstraints[39] , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , ((Number) dynConstraints[43]).intValue() , (String)dynConstraints[44] , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , (String)dynConstraints[48] , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (java.util.Date)dynConstraints[55] , (java.util.Date)dynConstraints[56] , (java.util.Date)dynConstraints[57] , (java.util.Date)dynConstraints[58] , ((Number) dynConstraints[59]).intValue() , (String)dynConstraints[60] , ((Number) dynConstraints[61]).intValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , ((Number) dynConstraints[65]).intValue() , (String)dynConstraints[66] , ((Number) dynConstraints[67]).intValue() , (String)dynConstraints[68] , ((Number) dynConstraints[69]).intValue() , (String)dynConstraints[70] , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (java.math.BigDecimal)dynConstraints[73] , (java.math.BigDecimal)dynConstraints[74] , ((Number) dynConstraints[75]).intValue() , (String)dynConstraints[76] , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , ((Number) dynConstraints[79]).intValue() , (String)dynConstraints[80] , ((Number) dynConstraints[81]).intValue() , (String)dynConstraints[82] , (java.math.BigDecimal)dynConstraints[83] , (java.math.BigDecimal)dynConstraints[84] , ((Number) dynConstraints[85]).intValue() , (String)dynConstraints[86] , ((Number) dynConstraints[87]).intValue() , (String)dynConstraints[88] , (String)dynConstraints[89] , (String)dynConstraints[90] , (java.util.Date)dynConstraints[91] , (java.util.Date)dynConstraints[92] , (java.math.BigDecimal)dynConstraints[93] , (java.math.BigDecimal)dynConstraints[94] , ((Number) dynConstraints[95]).shortValue() , ((Boolean) dynConstraints[96]).booleanValue() , ((Number) dynConstraints[97]).intValue() , ((Number) dynConstraints[98]).shortValue() , ((Number) dynConstraints[99]).intValue() , ((Number) dynConstraints[100]).shortValue() );
            case 3 :
                  return conditional_H00285(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (String)dynConstraints[20] , (GXSimpleCollection<String>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (String)dynConstraints[26] , (GXSimpleCollection<String>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , (String)dynConstraints[36] , (GXSimpleCollection<String>)dynConstraints[37] , (String)dynConstraints[38] , (GXSimpleCollection<String>)dynConstraints[39] , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , ((Number) dynConstraints[43]).intValue() , (String)dynConstraints[44] , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , (String)dynConstraints[48] , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (java.util.Date)dynConstraints[55] , (java.util.Date)dynConstraints[56] , (java.util.Date)dynConstraints[57] , (java.util.Date)dynConstraints[58] , ((Number) dynConstraints[59]).intValue() , (String)dynConstraints[60] , ((Number) dynConstraints[61]).intValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , ((Number) dynConstraints[65]).intValue() , (String)dynConstraints[66] , ((Number) dynConstraints[67]).intValue() , (String)dynConstraints[68] , ((Number) dynConstraints[69]).intValue() , (String)dynConstraints[70] , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (java.math.BigDecimal)dynConstraints[73] , (java.math.BigDecimal)dynConstraints[74] , ((Number) dynConstraints[75]).intValue() , (String)dynConstraints[76] , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , ((Number) dynConstraints[79]).intValue() , (String)dynConstraints[80] , ((Number) dynConstraints[81]).intValue() , (String)dynConstraints[82] , (java.math.BigDecimal)dynConstraints[83] , (java.math.BigDecimal)dynConstraints[84] , ((Number) dynConstraints[85]).intValue() , (String)dynConstraints[86] , ((Number) dynConstraints[87]).intValue() , (String)dynConstraints[88] , (String)dynConstraints[89] , (String)dynConstraints[90] , (java.util.Date)dynConstraints[91] , (java.util.Date)dynConstraints[92] , (java.math.BigDecimal)dynConstraints[93] , (java.math.BigDecimal)dynConstraints[94] , ((Number) dynConstraints[95]).intValue() , ((Number) dynConstraints[96]).shortValue() , ((Number) dynConstraints[97]).intValue() , ((Number) dynConstraints[98]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00282", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00283", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00284", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegId, MigrLegCUIL, MigrLegApellido, MigrLegNombre, MigrLegModTra, MigrLegTipoTarifa, MigrLegClase, MigrLegFecNac, MigrLegFecIngreso, MigrLegSexo, MigrLegZona, MigrLegDomici, MigrLegCodPos, MigrLegTelefono, MigrLegEmail, MigrLegEstadoCivil, MigrLegDiscapacidad, MigrLegArea, MigrLegBasico, MigrLegConvenio, MigrLegCategoria, MigrLegLugarDePago, MigrLegBanco, MigrLegObraSocial, MigrLegBanSuc, MigrLegBanTipCuen, MigrLegCuentaBanc, MigrLegFormaPago, MigrLegCBU, MigrLegModalidad, MigrLegHorSem, MigrLegActividad, MigrLegSituacionRevista, MigrLegCondicion, MigrLegSiniestrado, MigrLegSCVO, MigrLegPlanMedico, MigrTieneConyuge, MigrCantidadHijos, MigrLegObs, MigrPeriodo, MigrSueldos, MigrPuesto, MigrLegActLabClas, MigrLegPueAfip, MigrLegSindicato FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00285", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 2);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(18,1);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               ((String[]) buf[22])[0] = rslt.getVarchar(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getVarchar(28);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((java.math.BigDecimal[]) buf[29])[0] = rslt.getBigDecimal(30,2);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((String[]) buf[31])[0] = rslt.getString(32, 2);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getVarchar(36);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getString(39, 20);
               ((java.util.Date[]) buf[39])[0] = rslt.getGXDate(40);
               ((java.util.Date[]) buf[40])[0] = rslt.getGXDate(41);
               ((String[]) buf[41])[0] = rslt.getVarchar(42);
               ((String[]) buf[42])[0] = rslt.getVarchar(43);
               ((String[]) buf[43])[0] = rslt.getVarchar(44);
               ((String[]) buf[44])[0] = rslt.getVarchar(45);
               ((String[]) buf[45])[0] = rslt.getVarchar(46);
               ((String[]) buf[46])[0] = rslt.getString(47, 13);
               ((String[]) buf[47])[0] = rslt.getString(48, 20);
               ((int[]) buf[48])[0] = rslt.getInt(49);
               ((short[]) buf[49])[0] = rslt.getShort(50);
               ((int[]) buf[50])[0] = rslt.getInt(51);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 13);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(11);
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 2);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((String[]) buf[22])[0] = rslt.getVarchar(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getVarchar(28);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((String[]) buf[31])[0] = rslt.getVarchar(32);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
               ((java.math.BigDecimal[]) buf[33])[0] = rslt.getBigDecimal(34,1);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getVarchar(36);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getString(39, 2);
               ((String[]) buf[39])[0] = rslt.getVarchar(40);
               ((String[]) buf[40])[0] = rslt.getString(41, 20);
               ((short[]) buf[41])[0] = rslt.getShort(42);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(43);
               ((java.util.Date[]) buf[43])[0] = rslt.getGXDate(44);
               ((String[]) buf[44])[0] = rslt.getLongVarchar(45);
               ((String[]) buf[45])[0] = rslt.getVarchar(46);
               ((String[]) buf[46])[0] = rslt.getVarchar(47);
               ((String[]) buf[47])[0] = rslt.getVarchar(48);
               ((String[]) buf[48])[0] = rslt.getVarchar(49);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(20);
               ((java.util.Date[]) buf[20])[0] = rslt.getGXDate(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               ((String[]) buf[22])[0] = rslt.getVarchar(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getString(27, 13);
               ((String[]) buf[27])[0] = rslt.getString(28, 20);
               ((int[]) buf[28])[0] = rslt.getInt(29);
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
                  stmt.setInt(sIdx, ((Number) parms[33]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[35], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[36], 13);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[42]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[43]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[44]);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[45]);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[46], 20);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 4000);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 400);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 400);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 400);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 400);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[53], 2);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[54], 2);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 400);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 400);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 22);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 400);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[59], 1);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[60], 1);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 200);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 400);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[63]).intValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[64]).intValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[65]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[30]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[31]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[32], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[33], 13);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[39]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[40]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[41]);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[42]);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[43], 20);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 4000);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 400);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 400);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 400);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 400);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[50], 2);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[51], 2);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 400);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 400);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 22);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 400);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[56], 1);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[57], 1);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 200);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 400);
               }
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[30]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[31]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[32], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[33], 13);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[39]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[40]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[41]);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[42]);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[43], 20);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 4000);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 400);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 400);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 400);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 400);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[50], 2);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[51], 2);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 400);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 400);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 22);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 400);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[56], 1);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[57], 1);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 200);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 400);
               }
               return;
      }
   }

}

