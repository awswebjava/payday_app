package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptos_exportww_impl extends GXDataArea
{
   public conceptos_exportww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptos_exportww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptos_exportww_impl.class ));
   }

   public conceptos_exportww_impl( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbConVigencia = new HTMLChoice();
      chkConVariable = UIFactory.getCheckbox(this);
      chkConForEditable = UIFactory.getCheckbox(this);
      cmbTipoConCod = new HTMLChoice();
      chkConRecalcular = UIFactory.getCheckbox(this);
      cmbConCondicion = new HTMLChoice();
      chkConMostrarPos = UIFactory.getCheckbox(this);
      cmbConAdelDescu = new HTMLChoice();
      chkConSegunPla = UIFactory.getCheckbox(this);
      cmbConSacDeven = new HTMLChoice();
      cmbConBaseLic = new HTMLChoice();
      cmbConBaseLicProm = new HTMLChoice();
      cmbConBaseFer = new HTMLChoice();
      cmbConBaseFerProm = new HTMLChoice();
      cmbConBaseHorExt = new HTMLChoice();
      cmbConBaseHorExtProm = new HTMLChoice();
      cmbConBasePres = new HTMLChoice();
      cmbConBaseAnt = new HTMLChoice();
      cmbConBaseOSDif = new HTMLChoice();
      chkConErrorSiCero = UIFactory.getCheckbox(this);
      chkConPueNov = UIFactory.getCheckbox(this);
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
            AV159MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV159MenuOpcCod", AV159MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV159MenuOpcCod, ""))));
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
      AV170ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV21ColumnsSelector);
      AV183Pgmname = httpContext.GetPar( "Pgmname") ;
      AV159MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      AV24TFCliCod = (int)(GXutil.lval( httpContext.GetPar( "TFCliCod"))) ;
      AV25TFCliCod_To = (int)(GXutil.lval( httpContext.GetPar( "TFCliCod_To"))) ;
      AV27TFConCodigo = httpContext.GetPar( "TFConCodigo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV28TFConCodigo_Sels);
      AV30TFConDescrip = httpContext.GetPar( "TFConDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV31TFConDescrip_Sels);
      AV32TFConOrden = (int)(GXutil.lval( httpContext.GetPar( "TFConOrden"))) ;
      AV33TFConOrden_To = (int)(GXutil.lval( httpContext.GetPar( "TFConOrden_To"))) ;
      AV36TFConLiqBasica = (byte)(GXutil.lval( httpContext.GetPar( "TFConLiqBasica"))) ;
      AV37TFConLiqBasica_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConLiqBasica_To"))) ;
      AV39TFConFormula = httpContext.GetPar( "TFConFormula") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV40TFConFormula_Sels);
      AV42TFConObservacion = httpContext.GetPar( "TFConObservacion") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV43TFConObservacion_Sels);
      AV44TFConVariable_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConVariable_Sel"))) ;
      AV45TFConForEditable_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConForEditable_Sel"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV47TFTipoConCod_Sels);
      AV49TFSubTipoConCod1 = httpContext.GetPar( "TFSubTipoConCod1") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV50TFSubTipoConCod1_Sels);
      AV52TFSubTipoConCod2 = httpContext.GetPar( "TFSubTipoConCod2") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV53TFSubTipoConCod2_Sels);
      AV55TFConTipoLiqAux = httpContext.GetPar( "TFConTipoLiqAux") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV56TFConTipoLiqAux_Sels);
      AV58TFConClasifAux = httpContext.GetPar( "TFConClasifAux") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV59TFConClasifAux_Sels);
      AV60TFConOrdEjec = GXutil.lval( httpContext.GetPar( "TFConOrdEjec")) ;
      AV61TFConOrdEjec_To = GXutil.lval( httpContext.GetPar( "TFConOrdEjec_To")) ;
      AV65TFConRecalcular_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConRecalcular_Sel"))) ;
      AV67TFConRangoCant = httpContext.GetPar( "TFConRangoCant") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV68TFConRangoCant_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV70TFConCondicion_Sels);
      AV72TFConCondCodigo = httpContext.GetPar( "TFConCondCodigo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV73TFConCondCodigo_Sels);
      AV74TFConMostrarPos_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConMostrarPos_Sel"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV76TFConAdelDescu_Sels);
      AV77TFAplIIGG = (short)(GXutil.lval( httpContext.GetPar( "TFAplIIGG"))) ;
      AV78TFAplIIGG_To = (short)(GXutil.lval( httpContext.GetPar( "TFAplIIGG_To"))) ;
      AV79TFConSegunPla_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConSegunPla_Sel"))) ;
      AV92TFConCodAfip = httpContext.GetPar( "TFConCodAfip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV93TFConCodAfip_Sels);
      AV94TFConSIPAApo = (byte)(GXutil.lval( httpContext.GetPar( "TFConSIPAApo"))) ;
      AV95TFConSIPAApo_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConSIPAApo_To"))) ;
      AV96TFConSIPACont = (byte)(GXutil.lval( httpContext.GetPar( "TFConSIPACont"))) ;
      AV97TFConSIPACont_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConSIPACont_To"))) ;
      AV98TFConINSSJyPApo = (byte)(GXutil.lval( httpContext.GetPar( "TFConINSSJyPApo"))) ;
      AV99TFConINSSJyPApo_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConINSSJyPApo_To"))) ;
      AV100TFConINSSJyPCont = (byte)(GXutil.lval( httpContext.GetPar( "TFConINSSJyPCont"))) ;
      AV101TFConINSSJyPCont_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConINSSJyPCont_To"))) ;
      AV102TFConObraSocApo = (byte)(GXutil.lval( httpContext.GetPar( "TFConObraSocApo"))) ;
      AV103TFConObraSocApo_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConObraSocApo_To"))) ;
      AV104TFConObraSocCont = (byte)(GXutil.lval( httpContext.GetPar( "TFConObraSocCont"))) ;
      AV105TFConObraSocCont_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConObraSocCont_To"))) ;
      AV106TFConFonSolRedApo = (byte)(GXutil.lval( httpContext.GetPar( "TFConFonSolRedApo"))) ;
      AV107TFConFonSolRedApo_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConFonSolRedApo_To"))) ;
      AV108TFConFonSolRedCont = (byte)(GXutil.lval( httpContext.GetPar( "TFConFonSolRedCont"))) ;
      AV109TFConFonSolRedCont_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConFonSolRedCont_To"))) ;
      AV110TFConRenateaApo = (byte)(GXutil.lval( httpContext.GetPar( "TFConRenateaApo"))) ;
      AV111TFConRenateaApo_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConRenateaApo_To"))) ;
      AV112TFConRenateaCont = (byte)(GXutil.lval( httpContext.GetPar( "TFConRenateaCont"))) ;
      AV113TFConRenateaCont_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConRenateaCont_To"))) ;
      AV114TFConAsigFamCont = (byte)(GXutil.lval( httpContext.GetPar( "TFConAsigFamCont"))) ;
      AV115TFConAsigFamCont_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConAsigFamCont_To"))) ;
      AV116TFConFonNacEmpCont = (byte)(GXutil.lval( httpContext.GetPar( "TFConFonNacEmpCont"))) ;
      AV117TFConFonNacEmpCont_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConFonNacEmpCont_To"))) ;
      AV118TFConLeyRieTrabCont = (byte)(GXutil.lval( httpContext.GetPar( "TFConLeyRieTrabCont"))) ;
      AV119TFConLeyRieTrabCont_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConLeyRieTrabCont_To"))) ;
      AV120TFConRegDifApo = (byte)(GXutil.lval( httpContext.GetPar( "TFConRegDifApo"))) ;
      AV121TFConRegDifApo_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConRegDifApo_To"))) ;
      AV122TFConRegEspApo = (byte)(GXutil.lval( httpContext.GetPar( "TFConRegEspApo"))) ;
      AV123TFConRegEspApo_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConRegEspApo_To"))) ;
      AV126TFConceptoPais = (short)(GXutil.lval( httpContext.GetPar( "TFConceptoPais"))) ;
      AV127TFConceptoPais_To = (short)(GXutil.lval( httpContext.GetPar( "TFConceptoPais_To"))) ;
      AV129TFConceptoConveCodigo = httpContext.GetPar( "TFConceptoConveCodigo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV130TFConceptoConveCodigo_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV138TFConBaseLicProm_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV140TFConBaseFerProm_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV142TFConBaseHorExtProm_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV144TFConBasePres_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV146TFConBaseAnt_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV148TFConBaseOSDif_Sels);
      AV149TFConErrorSiCero_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConErrorSiCero_Sel"))) ;
      AV150TFCliPadre = (int)(GXutil.lval( httpContext.GetPar( "TFCliPadre"))) ;
      AV151TFCliPadre_To = (int)(GXutil.lval( httpContext.GetPar( "TFCliPadre_To"))) ;
      AV153TFConPadre = httpContext.GetPar( "TFConPadre") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV154TFConPadre_Sels);
      AV155TFConPueNov_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConPueNov_Sel"))) ;
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV87CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV161WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV170ManageFiltersExecutionStep, AV21ColumnsSelector, AV183Pgmname, AV159MenuOpcCod, AV12GridState, AV24TFCliCod, AV25TFCliCod_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV30TFConDescrip, AV31TFConDescrip_Sels, AV32TFConOrden, AV33TFConOrden_To, AV36TFConLiqBasica, AV37TFConLiqBasica_To, AV39TFConFormula, AV40TFConFormula_Sels, AV42TFConObservacion, AV43TFConObservacion_Sels, AV44TFConVariable_Sel, AV45TFConForEditable_Sel, AV47TFTipoConCod_Sels, AV49TFSubTipoConCod1, AV50TFSubTipoConCod1_Sels, AV52TFSubTipoConCod2, AV53TFSubTipoConCod2_Sels, AV55TFConTipoLiqAux, AV56TFConTipoLiqAux_Sels, AV58TFConClasifAux, AV59TFConClasifAux_Sels, AV60TFConOrdEjec, AV61TFConOrdEjec_To, AV65TFConRecalcular_Sel, AV67TFConRangoCant, AV68TFConRangoCant_Sels, AV70TFConCondicion_Sels, AV72TFConCondCodigo, AV73TFConCondCodigo_Sels, AV74TFConMostrarPos_Sel, AV76TFConAdelDescu_Sels, AV77TFAplIIGG, AV78TFAplIIGG_To, AV79TFConSegunPla_Sel, AV92TFConCodAfip, AV93TFConCodAfip_Sels, AV94TFConSIPAApo, AV95TFConSIPAApo_To, AV96TFConSIPACont, AV97TFConSIPACont_To, AV98TFConINSSJyPApo, AV99TFConINSSJyPApo_To, AV100TFConINSSJyPCont, AV101TFConINSSJyPCont_To, AV102TFConObraSocApo, AV103TFConObraSocApo_To, AV104TFConObraSocCont, AV105TFConObraSocCont_To, AV106TFConFonSolRedApo, AV107TFConFonSolRedApo_To, AV108TFConFonSolRedCont, AV109TFConFonSolRedCont_To, AV110TFConRenateaApo, AV111TFConRenateaApo_To, AV112TFConRenateaCont, AV113TFConRenateaCont_To, AV114TFConAsigFamCont, AV115TFConAsigFamCont_To, AV116TFConFonNacEmpCont, AV117TFConFonNacEmpCont_To, AV118TFConLeyRieTrabCont, AV119TFConLeyRieTrabCont_To, AV120TFConRegDifApo, AV121TFConRegDifApo_To, AV122TFConRegEspApo, AV123TFConRegEspApo_To, AV126TFConceptoPais, AV127TFConceptoPais_To, AV129TFConceptoConveCodigo, AV130TFConceptoConveCodigo_Sels, AV138TFConBaseLicProm_Sels, AV140TFConBaseFerProm_Sels, AV142TFConBaseHorExtProm_Sels, AV144TFConBasePres_Sels, AV146TFConBaseAnt_Sels, AV148TFConBaseOSDif_Sels, AV149TFConErrorSiCero_Sel, AV150TFCliPadre, AV151TFCliPadre_To, AV153TFConPadre, AV154TFConPadre_Sels, AV155TFConPueNov_Sel, AV14OrderedBy, AV15OrderedDsc, AV87CliCod, AV161WelcomeMessage_NoMostrarMas) ;
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
      paIB2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startIB2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptos_exportww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV159MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV183Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV159MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV87CliCod), "ZZZZZ9")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV80DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV80DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV168ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV168ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV82GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV83GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV84GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV170ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV183Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV183Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV159MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV159MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICOD", GXutil.ltrim( localUtil.ntoc( AV24TFCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLICOD_TO", GXutil.ltrim( localUtil.ntoc( AV25TFCliCod_To, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCODIGO", GXutil.rtrim( AV27TFConCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCODIGO_SELS", AV28TFConCodigo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCODIGO_SELS", AV28TFConCodigo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONDESCRIP", AV30TFConDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONDESCRIP_SELS", AV31TFConDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONDESCRIP_SELS", AV31TFConDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONORDEN", GXutil.ltrim( localUtil.ntoc( AV32TFConOrden, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONORDEN_TO", GXutil.ltrim( localUtil.ntoc( AV33TFConOrden_To, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONLIQBASICA", GXutil.ltrim( localUtil.ntoc( AV36TFConLiqBasica, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONLIQBASICA_TO", GXutil.ltrim( localUtil.ntoc( AV37TFConLiqBasica_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONFORMULA", AV39TFConFormula);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONFORMULA_SELS", AV40TFConFormula_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONFORMULA_SELS", AV40TFConFormula_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONOBSERVACION", AV42TFConObservacion);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONOBSERVACION_SELS", AV43TFConObservacion_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONOBSERVACION_SELS", AV43TFConObservacion_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVARIABLE_SEL", GXutil.ltrim( localUtil.ntoc( AV44TFConVariable_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONFOREDITABLE_SEL", GXutil.ltrim( localUtil.ntoc( AV45TFConForEditable_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFTIPOCONCOD_SELS", AV47TFTipoConCod_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFTIPOCONCOD_SELS", AV47TFTipoConCod_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSUBTIPOCONCOD1", GXutil.rtrim( AV49TFSubTipoConCod1));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSUBTIPOCONCOD1_SELS", AV50TFSubTipoConCod1_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSUBTIPOCONCOD1_SELS", AV50TFSubTipoConCod1_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSUBTIPOCONCOD2", GXutil.rtrim( AV52TFSubTipoConCod2));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSUBTIPOCONCOD2_SELS", AV53TFSubTipoConCod2_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSUBTIPOCONCOD2_SELS", AV53TFSubTipoConCod2_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONTIPOLIQAUX", AV55TFConTipoLiqAux);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONTIPOLIQAUX_SELS", AV56TFConTipoLiqAux_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONTIPOLIQAUX_SELS", AV56TFConTipoLiqAux_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCLASIFAUX", AV58TFConClasifAux);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCLASIFAUX_SELS", AV59TFConClasifAux_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCLASIFAUX_SELS", AV59TFConClasifAux_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONORDEJEC", GXutil.ltrim( localUtil.ntoc( AV60TFConOrdEjec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONORDEJEC_TO", GXutil.ltrim( localUtil.ntoc( AV61TFConOrdEjec_To, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONRECALCULAR_SEL", GXutil.ltrim( localUtil.ntoc( AV65TFConRecalcular_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONRANGOCANT", AV67TFConRangoCant);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONRANGOCANT_SELS", AV68TFConRangoCant_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONRANGOCANT_SELS", AV68TFConRangoCant_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCONDICION_SELS", AV70TFConCondicion_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCONDICION_SELS", AV70TFConCondicion_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCONDCODIGO", GXutil.rtrim( AV72TFConCondCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCONDCODIGO_SELS", AV73TFConCondCodigo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCONDCODIGO_SELS", AV73TFConCondCodigo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONMOSTRARPOS_SEL", GXutil.ltrim( localUtil.ntoc( AV74TFConMostrarPos_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONADELDESCU_SELS", AV76TFConAdelDescu_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONADELDESCU_SELS", AV76TFConAdelDescu_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGG", GXutil.ltrim( localUtil.ntoc( AV77TFAplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFAPLIIGG_TO", GXutil.ltrim( localUtil.ntoc( AV78TFAplIIGG_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONSEGUNPLA_SEL", GXutil.ltrim( localUtil.ntoc( AV79TFConSegunPla_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCODAFIP", GXutil.rtrim( AV92TFConCodAfip));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCODAFIP_SELS", AV93TFConCodAfip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCODAFIP_SELS", AV93TFConCodAfip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONSIPAAPO", GXutil.ltrim( localUtil.ntoc( AV94TFConSIPAApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONSIPAAPO_TO", GXutil.ltrim( localUtil.ntoc( AV95TFConSIPAApo_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONSIPACONT", GXutil.ltrim( localUtil.ntoc( AV96TFConSIPACont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONSIPACONT_TO", GXutil.ltrim( localUtil.ntoc( AV97TFConSIPACont_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONINSSJYPAPO", GXutil.ltrim( localUtil.ntoc( AV98TFConINSSJyPApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONINSSJYPAPO_TO", GXutil.ltrim( localUtil.ntoc( AV99TFConINSSJyPApo_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONINSSJYPCONT", GXutil.ltrim( localUtil.ntoc( AV100TFConINSSJyPCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONINSSJYPCONT_TO", GXutil.ltrim( localUtil.ntoc( AV101TFConINSSJyPCont_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONOBRASOCAPO", GXutil.ltrim( localUtil.ntoc( AV102TFConObraSocApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONOBRASOCAPO_TO", GXutil.ltrim( localUtil.ntoc( AV103TFConObraSocApo_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONOBRASOCCONT", GXutil.ltrim( localUtil.ntoc( AV104TFConObraSocCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONOBRASOCCONT_TO", GXutil.ltrim( localUtil.ntoc( AV105TFConObraSocCont_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONFONSOLREDAPO", GXutil.ltrim( localUtil.ntoc( AV106TFConFonSolRedApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONFONSOLREDAPO_TO", GXutil.ltrim( localUtil.ntoc( AV107TFConFonSolRedApo_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONFONSOLREDCONT", GXutil.ltrim( localUtil.ntoc( AV108TFConFonSolRedCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONFONSOLREDCONT_TO", GXutil.ltrim( localUtil.ntoc( AV109TFConFonSolRedCont_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONRENATEAAPO", GXutil.ltrim( localUtil.ntoc( AV110TFConRenateaApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONRENATEAAPO_TO", GXutil.ltrim( localUtil.ntoc( AV111TFConRenateaApo_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONRENATEACONT", GXutil.ltrim( localUtil.ntoc( AV112TFConRenateaCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONRENATEACONT_TO", GXutil.ltrim( localUtil.ntoc( AV113TFConRenateaCont_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONASIGFAMCONT", GXutil.ltrim( localUtil.ntoc( AV114TFConAsigFamCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONASIGFAMCONT_TO", GXutil.ltrim( localUtil.ntoc( AV115TFConAsigFamCont_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONFONNACEMPCONT", GXutil.ltrim( localUtil.ntoc( AV116TFConFonNacEmpCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONFONNACEMPCONT_TO", GXutil.ltrim( localUtil.ntoc( AV117TFConFonNacEmpCont_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONLEYRIETRABCONT", GXutil.ltrim( localUtil.ntoc( AV118TFConLeyRieTrabCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONLEYRIETRABCONT_TO", GXutil.ltrim( localUtil.ntoc( AV119TFConLeyRieTrabCont_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONREGDIFAPO", GXutil.ltrim( localUtil.ntoc( AV120TFConRegDifApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONREGDIFAPO_TO", GXutil.ltrim( localUtil.ntoc( AV121TFConRegDifApo_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONREGESPAPO", GXutil.ltrim( localUtil.ntoc( AV122TFConRegEspApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONREGESPAPO_TO", GXutil.ltrim( localUtil.ntoc( AV123TFConRegEspApo_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCEPTOPAIS", GXutil.ltrim( localUtil.ntoc( AV126TFConceptoPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCEPTOPAIS_TO", GXutil.ltrim( localUtil.ntoc( AV127TFConceptoPais_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCEPTOCONVECODIGO", GXutil.rtrim( AV129TFConceptoConveCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCEPTOCONVECODIGO_SELS", AV130TFConceptoConveCodigo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCEPTOCONVECODIGO_SELS", AV130TFConceptoConveCodigo_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASELICPROM_SELS", AV138TFConBaseLicProm_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASELICPROM_SELS", AV138TFConBaseLicProm_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASEFERPROM_SELS", AV140TFConBaseFerProm_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASEFERPROM_SELS", AV140TFConBaseFerProm_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASEHOREXTPROM_SELS", AV142TFConBaseHorExtProm_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASEHOREXTPROM_SELS", AV142TFConBaseHorExtProm_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASEPRES_SELS", AV144TFConBasePres_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASEPRES_SELS", AV144TFConBasePres_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASEANT_SELS", AV146TFConBaseAnt_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASEANT_SELS", AV146TFConBaseAnt_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONBASEOSDIF_SELS", AV148TFConBaseOSDif_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONBASEOSDIF_SELS", AV148TFConBaseOSDif_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONERRORSICERO_SEL", GXutil.ltrim( localUtil.ntoc( AV149TFConErrorSiCero_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLIPADRE", GXutil.ltrim( localUtil.ntoc( AV150TFCliPadre, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCLIPADRE_TO", GXutil.ltrim( localUtil.ntoc( AV151TFCliPadre_To, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONPADRE", GXutil.rtrim( AV153TFConPadre));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONPADRE_SELS", AV154TFConPadre_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONPADRE_SELS", AV154TFConPadre_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONPUENOV_SEL", GXutil.ltrim( localUtil.ntoc( AV155TFConPueNov_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV87CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV87CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCODIGO_SELSJSON", AV26TFConCodigo_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONDESCRIP_SELSJSON", AV29TFConDescrip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONFORMULA_SELSJSON", AV38TFConFormula_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONOBSERVACION_SELSJSON", AV41TFConObservacion_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFTIPOCONCOD_SELSJSON", AV46TFTipoConCod_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSUBTIPOCONCOD1_SELSJSON", AV48TFSubTipoConCod1_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSUBTIPOCONCOD2_SELSJSON", AV51TFSubTipoConCod2_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONTIPOLIQAUX_SELSJSON", AV54TFConTipoLiqAux_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCLASIFAUX_SELSJSON", AV57TFConClasifAux_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONRANGOCANT_SELSJSON", AV66TFConRangoCant_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCONDICION_SELSJSON", AV69TFConCondicion_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCONDCODIGO_SELSJSON", AV71TFConCondCodigo_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONADELDESCU_SELSJSON", AV75TFConAdelDescu_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCODAFIP_SELSJSON", AV91TFConCodAfip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCEPTOCONVECODIGO_SELSJSON", AV128TFConceptoConveCodigo_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASELICPROM_SELSJSON", AV137TFConBaseLicProm_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASEFERPROM_SELSJSON", AV139TFConBaseFerProm_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASEHOREXTPROM_SELSJSON", AV141TFConBaseHorExtProm_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASEPRES_SELSJSON", AV143TFConBasePres_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASEANT_SELSJSON", AV145TFConBaseAnt_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONBASEOSDIF_SELSJSON", AV147TFConBaseOSDif_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONPADRE_SELSJSON", AV152TFConPadre_SelsJson);
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
         weIB2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtIB2( ) ;
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
      return formatLink("web.conceptos_exportww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV159MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "Conceptos_exportWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Conceptos_export", "") ;
   }

   public void wbIB0( )
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
         wb_table1_9_IB2( true) ;
      }
      else
      {
         wb_table1_9_IB2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_IB2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 177,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnmotivos_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Motivos de egreso", ""), bttBtnmotivos_Jsonclick, 7, httpContext.getMessage( "Motivos de egreso", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e11ib1_client"+"'", TempTags, "", 2, "HLP_Conceptos_exportWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 180,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtntiposliq_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Tipos de liquidación", ""), bttBtntiposliq_Jsonclick, 7, httpContext.getMessage( "Tipos de liquidación", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e12ib1_client"+"'", TempTags, "", 2, "HLP_Conceptos_exportWW.htm");
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV80DDO_TitleSettingsIcons);
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

   public void startIB2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Conceptos_export", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupIB0( ) ;
   }

   public void wsIB2( )
   {
      startIB2( ) ;
      evtIB2( ) ;
   }

   public void evtIB2( )
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
                           e13IB2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14IB2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15IB2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e16IB2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17IB2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e18IB2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e19IB2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e20IB2 ();
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
                           A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
                           A41ConDescrip = httpContext.cgiGet( edtConDescrip_Internalname) ;
                           A40ConOrden = (int)(localUtil.ctol( httpContext.cgiGet( edtConOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           cmbConVigencia.setName( cmbConVigencia.getInternalname() );
                           cmbConVigencia.setValue( httpContext.cgiGet( cmbConVigencia.getInternalname()) );
                           A162ConVigencia = (byte)(GXutil.lval( httpContext.cgiGet( cmbConVigencia.getInternalname()))) ;
                           A1488ConLiqBasica = (byte)(localUtil.ctol( httpContext.cgiGet( edtConLiqBasica_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A148ConFormula = httpContext.cgiGet( edtConFormula_Internalname) ;
                           n148ConFormula = false ;
                           A153ConObservacion = httpContext.cgiGet( edtConObservacion_Internalname) ;
                           A159ConVariable = GXutil.strtobool( httpContext.cgiGet( chkConVariable.getInternalname())) ;
                           A146ConForEditable = GXutil.strtobool( httpContext.cgiGet( chkConForEditable.getInternalname())) ;
                           n146ConForEditable = false ;
                           cmbTipoConCod.setName( cmbTipoConCod.getInternalname() );
                           cmbTipoConCod.setValue( httpContext.cgiGet( cmbTipoConCod.getInternalname()) );
                           A37TipoConCod = httpContext.cgiGet( cmbTipoConCod.getInternalname()) ;
                           A38SubTipoConCod1 = httpContext.cgiGet( edtSubTipoConCod1_Internalname) ;
                           n38SubTipoConCod1 = false ;
                           A39SubTipoConCod2 = httpContext.cgiGet( edtSubTipoConCod2_Internalname) ;
                           n39SubTipoConCod2 = false ;
                           A503ConTipoLiqAux = httpContext.cgiGet( edtConTipoLiqAux_Internalname) ;
                           n503ConTipoLiqAux = false ;
                           A970ConClasifAux = httpContext.cgiGet( edtConClasifAux_Internalname) ;
                           n970ConClasifAux = false ;
                           A510ConOrdEjec = localUtil.ctol( httpContext.cgiGet( edtConOrdEjec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A762ConRecalcular = GXutil.strtobool( httpContext.cgiGet( chkConRecalcular.getInternalname())) ;
                           A1018ConRangoCant = httpContext.cgiGet( edtConRangoCant_Internalname) ;
                           cmbConCondicion.setName( cmbConCondicion.getInternalname() );
                           cmbConCondicion.setValue( httpContext.cgiGet( cmbConCondicion.getInternalname()) );
                           A953ConCondicion = httpContext.cgiGet( cmbConCondicion.getInternalname()) ;
                           n953ConCondicion = false ;
                           A954ConCondCodigo = httpContext.cgiGet( edtConCondCodigo_Internalname) ;
                           A1068ConMostrarPos = GXutil.strtobool( httpContext.cgiGet( chkConMostrarPos.getInternalname())) ;
                           cmbConAdelDescu.setName( cmbConAdelDescu.getInternalname() );
                           cmbConAdelDescu.setValue( httpContext.cgiGet( cmbConAdelDescu.getInternalname()) );
                           A1077ConAdelDescu = (byte)(GXutil.lval( httpContext.cgiGet( cmbConAdelDescu.getInternalname()))) ;
                           n1077ConAdelDescu = false ;
                           A1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( edtAplIIGG_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n1112AplIIGG = false ;
                           A1194ConSegunPla = GXutil.strtobool( httpContext.cgiGet( chkConSegunPla.getInternalname())) ;
                           AV158Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV158Display);
                           AV157VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV157VerSVG);
                           A1648ConCodAfip = httpContext.cgiGet( edtConCodAfip_Internalname) ;
                           A1472ConSIPAApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConSIPAApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1473ConSIPACont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConSIPACont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1474ConINSSJyPApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConINSSJyPApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1475ConINSSJyPCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConINSSJyPCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1476ConObraSocApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConObraSocApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1477ConObraSocCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConObraSocCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1478ConFonSolRedApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConFonSolRedApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1479ConFonSolRedCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConFonSolRedCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1480ConRenateaApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConRenateaApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1481ConRenateaCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConRenateaCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1482ConAsigFamCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConAsigFamCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1483ConFonNacEmpCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConFonNacEmpCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1484ConLeyRieTrabCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConLeyRieTrabCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1485ConRegDifApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConRegDifApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1486ConRegEspApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConRegEspApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           cmbConSacDeven.setName( cmbConSacDeven.getInternalname() );
                           cmbConSacDeven.setValue( httpContext.cgiGet( cmbConSacDeven.getInternalname()) );
                           A1539ConSacDeven = (byte)(GXutil.lval( httpContext.cgiGet( cmbConSacDeven.getInternalname()))) ;
                           A1644ConceptoPais = (short)(localUtil.ctol( httpContext.cgiGet( edtConceptoPais_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n1644ConceptoPais = false ;
                           A1645ConceptoConveCodigo = httpContext.cgiGet( edtConceptoConveCodigo_Internalname) ;
                           n1645ConceptoConveCodigo = false ;
                           cmbConBaseLic.setName( cmbConBaseLic.getInternalname() );
                           cmbConBaseLic.setValue( httpContext.cgiGet( cmbConBaseLic.getInternalname()) );
                           A1620ConBaseLic = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseLic.getInternalname()))) ;
                           cmbConBaseLicProm.setName( cmbConBaseLicProm.getInternalname() );
                           cmbConBaseLicProm.setValue( httpContext.cgiGet( cmbConBaseLicProm.getInternalname()) );
                           A1797ConBaseLicProm = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseLicProm.getInternalname()))) ;
                           cmbConBaseFer.setName( cmbConBaseFer.getInternalname() );
                           cmbConBaseFer.setValue( httpContext.cgiGet( cmbConBaseFer.getInternalname()) );
                           A1621ConBaseFer = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseFer.getInternalname()))) ;
                           cmbConBaseFerProm.setName( cmbConBaseFerProm.getInternalname() );
                           cmbConBaseFerProm.setValue( httpContext.cgiGet( cmbConBaseFerProm.getInternalname()) );
                           A1798ConBaseFerProm = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseFerProm.getInternalname()))) ;
                           cmbConBaseHorExt.setName( cmbConBaseHorExt.getInternalname() );
                           cmbConBaseHorExt.setValue( httpContext.cgiGet( cmbConBaseHorExt.getInternalname()) );
                           A1622ConBaseHorExt = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseHorExt.getInternalname()))) ;
                           cmbConBaseHorExtProm.setName( cmbConBaseHorExtProm.getInternalname() );
                           cmbConBaseHorExtProm.setValue( httpContext.cgiGet( cmbConBaseHorExtProm.getInternalname()) );
                           A1799ConBaseHorExtProm = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseHorExtProm.getInternalname()))) ;
                           cmbConBasePres.setName( cmbConBasePres.getInternalname() );
                           cmbConBasePres.setValue( httpContext.cgiGet( cmbConBasePres.getInternalname()) );
                           A1800ConBasePres = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBasePres.getInternalname()))) ;
                           cmbConBaseAnt.setName( cmbConBaseAnt.getInternalname() );
                           cmbConBaseAnt.setValue( httpContext.cgiGet( cmbConBaseAnt.getInternalname()) );
                           A1801ConBaseAnt = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseAnt.getInternalname()))) ;
                           cmbConBaseOSDif.setName( cmbConBaseOSDif.getInternalname() );
                           cmbConBaseOSDif.setValue( httpContext.cgiGet( cmbConBaseOSDif.getInternalname()) );
                           A1827ConBaseOSDif = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseOSDif.getInternalname()))) ;
                           A1821ConErrorSiCero = GXutil.strtobool( httpContext.cgiGet( chkConErrorSiCero.getInternalname())) ;
                           A1822CliPadre = (int)(localUtil.ctol( httpContext.cgiGet( edtCliPadre_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n1822CliPadre = false ;
                           A921ConPadre = httpContext.cgiGet( edtConPadre_Internalname) ;
                           n921ConPadre = false ;
                           A1826ConPueNov = GXutil.strtobool( httpContext.cgiGet( chkConPueNov.getInternalname())) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e21IB2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e22IB2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e23IB2 ();
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

   public void weIB2( )
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

   public void paIB2( )
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
                                 byte AV170ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ,
                                 String AV183Pgmname ,
                                 String AV159MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 int AV24TFCliCod ,
                                 int AV25TFCliCod_To ,
                                 String AV27TFConCodigo ,
                                 GXSimpleCollection<String> AV28TFConCodigo_Sels ,
                                 String AV30TFConDescrip ,
                                 GXSimpleCollection<String> AV31TFConDescrip_Sels ,
                                 int AV32TFConOrden ,
                                 int AV33TFConOrden_To ,
                                 byte AV36TFConLiqBasica ,
                                 byte AV37TFConLiqBasica_To ,
                                 String AV39TFConFormula ,
                                 GXSimpleCollection<String> AV40TFConFormula_Sels ,
                                 String AV42TFConObservacion ,
                                 GXSimpleCollection<String> AV43TFConObservacion_Sels ,
                                 byte AV44TFConVariable_Sel ,
                                 byte AV45TFConForEditable_Sel ,
                                 GXSimpleCollection<String> AV47TFTipoConCod_Sels ,
                                 String AV49TFSubTipoConCod1 ,
                                 GXSimpleCollection<String> AV50TFSubTipoConCod1_Sels ,
                                 String AV52TFSubTipoConCod2 ,
                                 GXSimpleCollection<String> AV53TFSubTipoConCod2_Sels ,
                                 String AV55TFConTipoLiqAux ,
                                 GXSimpleCollection<String> AV56TFConTipoLiqAux_Sels ,
                                 String AV58TFConClasifAux ,
                                 GXSimpleCollection<String> AV59TFConClasifAux_Sels ,
                                 long AV60TFConOrdEjec ,
                                 long AV61TFConOrdEjec_To ,
                                 byte AV65TFConRecalcular_Sel ,
                                 String AV67TFConRangoCant ,
                                 GXSimpleCollection<String> AV68TFConRangoCant_Sels ,
                                 GXSimpleCollection<String> AV70TFConCondicion_Sels ,
                                 String AV72TFConCondCodigo ,
                                 GXSimpleCollection<String> AV73TFConCondCodigo_Sels ,
                                 byte AV74TFConMostrarPos_Sel ,
                                 GXSimpleCollection<Byte> AV76TFConAdelDescu_Sels ,
                                 short AV77TFAplIIGG ,
                                 short AV78TFAplIIGG_To ,
                                 byte AV79TFConSegunPla_Sel ,
                                 String AV92TFConCodAfip ,
                                 GXSimpleCollection<String> AV93TFConCodAfip_Sels ,
                                 byte AV94TFConSIPAApo ,
                                 byte AV95TFConSIPAApo_To ,
                                 byte AV96TFConSIPACont ,
                                 byte AV97TFConSIPACont_To ,
                                 byte AV98TFConINSSJyPApo ,
                                 byte AV99TFConINSSJyPApo_To ,
                                 byte AV100TFConINSSJyPCont ,
                                 byte AV101TFConINSSJyPCont_To ,
                                 byte AV102TFConObraSocApo ,
                                 byte AV103TFConObraSocApo_To ,
                                 byte AV104TFConObraSocCont ,
                                 byte AV105TFConObraSocCont_To ,
                                 byte AV106TFConFonSolRedApo ,
                                 byte AV107TFConFonSolRedApo_To ,
                                 byte AV108TFConFonSolRedCont ,
                                 byte AV109TFConFonSolRedCont_To ,
                                 byte AV110TFConRenateaApo ,
                                 byte AV111TFConRenateaApo_To ,
                                 byte AV112TFConRenateaCont ,
                                 byte AV113TFConRenateaCont_To ,
                                 byte AV114TFConAsigFamCont ,
                                 byte AV115TFConAsigFamCont_To ,
                                 byte AV116TFConFonNacEmpCont ,
                                 byte AV117TFConFonNacEmpCont_To ,
                                 byte AV118TFConLeyRieTrabCont ,
                                 byte AV119TFConLeyRieTrabCont_To ,
                                 byte AV120TFConRegDifApo ,
                                 byte AV121TFConRegDifApo_To ,
                                 byte AV122TFConRegEspApo ,
                                 byte AV123TFConRegEspApo_To ,
                                 short AV126TFConceptoPais ,
                                 short AV127TFConceptoPais_To ,
                                 String AV129TFConceptoConveCodigo ,
                                 GXSimpleCollection<String> AV130TFConceptoConveCodigo_Sels ,
                                 GXSimpleCollection<Byte> AV138TFConBaseLicProm_Sels ,
                                 GXSimpleCollection<Byte> AV140TFConBaseFerProm_Sels ,
                                 GXSimpleCollection<Byte> AV142TFConBaseHorExtProm_Sels ,
                                 GXSimpleCollection<Byte> AV144TFConBasePres_Sels ,
                                 GXSimpleCollection<Byte> AV146TFConBaseAnt_Sels ,
                                 GXSimpleCollection<Byte> AV148TFConBaseOSDif_Sels ,
                                 byte AV149TFConErrorSiCero_Sel ,
                                 int AV150TFCliPadre ,
                                 int AV151TFCliPadre_To ,
                                 String AV153TFConPadre ,
                                 GXSimpleCollection<String> AV154TFConPadre_Sels ,
                                 byte AV155TFConPueNov_Sel ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 int AV87CliCod ,
                                 boolean AV161WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e22IB2 ();
      GRID_nCurrentRecord = 0 ;
      rfIB2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A26ConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCODIGO", GXutil.rtrim( A26ConCodigo));
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
      AV161WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV161WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV161WelcomeMessage_NoMostrarMas", AV161WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfIB2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV183Pgmname = "Conceptos_exportWW" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
   }

   public void rfIB2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(110) ;
      /* Execute user event: Refresh */
      e22IB2 ();
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
                                              A26ConCodigo ,
                                              AV187Conceptos_exportwwds_4_tfconcodigo_sels ,
                                              A41ConDescrip ,
                                              AV189Conceptos_exportwwds_6_tfcondescrip_sels ,
                                              A148ConFormula ,
                                              AV195Conceptos_exportwwds_12_tfconformula_sels ,
                                              A153ConObservacion ,
                                              AV197Conceptos_exportwwds_14_tfconobservacion_sels ,
                                              A37TipoConCod ,
                                              AV200Conceptos_exportwwds_17_tftipoconcod_sels ,
                                              A38SubTipoConCod1 ,
                                              AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels ,
                                              A39SubTipoConCod2 ,
                                              AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels ,
                                              A503ConTipoLiqAux ,
                                              AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels ,
                                              A970ConClasifAux ,
                                              AV208Conceptos_exportwwds_25_tfconclasifaux_sels ,
                                              A1018ConRangoCant ,
                                              AV213Conceptos_exportwwds_30_tfconrangocant_sels ,
                                              A953ConCondicion ,
                                              AV214Conceptos_exportwwds_31_tfconcondicion_sels ,
                                              A954ConCondCodigo ,
                                              AV216Conceptos_exportwwds_33_tfconcondcodigo_sels ,
                                              Byte.valueOf(A1077ConAdelDescu) ,
                                              AV218Conceptos_exportwwds_35_tfconadeldescu_sels ,
                                              A1648ConCodAfip ,
                                              AV223Conceptos_exportwwds_40_tfconcodafip_sels ,
                                              A1645ConceptoConveCodigo ,
                                              AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels ,
                                              Byte.valueOf(A1797ConBaseLicProm) ,
                                              AV258Conceptos_exportwwds_75_tfconbaselicprom_sels ,
                                              Byte.valueOf(A1798ConBaseFerProm) ,
                                              AV259Conceptos_exportwwds_76_tfconbaseferprom_sels ,
                                              Byte.valueOf(A1799ConBaseHorExtProm) ,
                                              AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels ,
                                              Byte.valueOf(A1800ConBasePres) ,
                                              AV261Conceptos_exportwwds_78_tfconbasepres_sels ,
                                              Byte.valueOf(A1801ConBaseAnt) ,
                                              AV262Conceptos_exportwwds_79_tfconbaseant_sels ,
                                              Byte.valueOf(A1827ConBaseOSDif) ,
                                              AV263Conceptos_exportwwds_80_tfconbaseosdif_sels ,
                                              A921ConPadre ,
                                              AV268Conceptos_exportwwds_85_tfconpadre_sels ,
                                              Integer.valueOf(AV184Conceptos_exportwwds_1_tfclicod) ,
                                              Integer.valueOf(AV185Conceptos_exportwwds_2_tfclicod_to) ,
                                              Integer.valueOf(AV187Conceptos_exportwwds_4_tfconcodigo_sels.size()) ,
                                              AV186Conceptos_exportwwds_3_tfconcodigo ,
                                              Integer.valueOf(AV189Conceptos_exportwwds_6_tfcondescrip_sels.size()) ,
                                              AV188Conceptos_exportwwds_5_tfcondescrip ,
                                              Integer.valueOf(AV190Conceptos_exportwwds_7_tfconorden) ,
                                              Integer.valueOf(AV191Conceptos_exportwwds_8_tfconorden_to) ,
                                              Byte.valueOf(AV192Conceptos_exportwwds_9_tfconliqbasica) ,
                                              Byte.valueOf(AV193Conceptos_exportwwds_10_tfconliqbasica_to) ,
                                              Integer.valueOf(AV195Conceptos_exportwwds_12_tfconformula_sels.size()) ,
                                              AV194Conceptos_exportwwds_11_tfconformula ,
                                              Integer.valueOf(AV197Conceptos_exportwwds_14_tfconobservacion_sels.size()) ,
                                              AV196Conceptos_exportwwds_13_tfconobservacion ,
                                              Byte.valueOf(AV198Conceptos_exportwwds_15_tfconvariable_sel) ,
                                              Byte.valueOf(AV199Conceptos_exportwwds_16_tfconforeditable_sel) ,
                                              Integer.valueOf(AV200Conceptos_exportwwds_17_tftipoconcod_sels.size()) ,
                                              Integer.valueOf(AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels.size()) ,
                                              AV201Conceptos_exportwwds_18_tfsubtipoconcod1 ,
                                              Integer.valueOf(AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels.size()) ,
                                              AV203Conceptos_exportwwds_20_tfsubtipoconcod2 ,
                                              Integer.valueOf(AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels.size()) ,
                                              AV205Conceptos_exportwwds_22_tfcontipoliqaux ,
                                              Integer.valueOf(AV208Conceptos_exportwwds_25_tfconclasifaux_sels.size()) ,
                                              AV207Conceptos_exportwwds_24_tfconclasifaux ,
                                              Long.valueOf(AV209Conceptos_exportwwds_26_tfconordejec) ,
                                              Long.valueOf(AV210Conceptos_exportwwds_27_tfconordejec_to) ,
                                              Byte.valueOf(AV211Conceptos_exportwwds_28_tfconrecalcular_sel) ,
                                              Integer.valueOf(AV213Conceptos_exportwwds_30_tfconrangocant_sels.size()) ,
                                              AV212Conceptos_exportwwds_29_tfconrangocant ,
                                              Integer.valueOf(AV214Conceptos_exportwwds_31_tfconcondicion_sels.size()) ,
                                              Integer.valueOf(AV216Conceptos_exportwwds_33_tfconcondcodigo_sels.size()) ,
                                              AV215Conceptos_exportwwds_32_tfconcondcodigo ,
                                              Byte.valueOf(AV217Conceptos_exportwwds_34_tfconmostrarpos_sel) ,
                                              Integer.valueOf(AV218Conceptos_exportwwds_35_tfconadeldescu_sels.size()) ,
                                              Short.valueOf(AV219Conceptos_exportwwds_36_tfapliigg) ,
                                              Short.valueOf(AV220Conceptos_exportwwds_37_tfapliigg_to) ,
                                              Byte.valueOf(AV221Conceptos_exportwwds_38_tfconsegunpla_sel) ,
                                              Integer.valueOf(AV223Conceptos_exportwwds_40_tfconcodafip_sels.size()) ,
                                              AV222Conceptos_exportwwds_39_tfconcodafip ,
                                              Byte.valueOf(AV224Conceptos_exportwwds_41_tfconsipaapo) ,
                                              Byte.valueOf(AV225Conceptos_exportwwds_42_tfconsipaapo_to) ,
                                              Byte.valueOf(AV226Conceptos_exportwwds_43_tfconsipacont) ,
                                              Byte.valueOf(AV227Conceptos_exportwwds_44_tfconsipacont_to) ,
                                              Byte.valueOf(AV228Conceptos_exportwwds_45_tfconinssjypapo) ,
                                              Byte.valueOf(AV229Conceptos_exportwwds_46_tfconinssjypapo_to) ,
                                              Byte.valueOf(AV230Conceptos_exportwwds_47_tfconinssjypcont) ,
                                              Byte.valueOf(AV231Conceptos_exportwwds_48_tfconinssjypcont_to) ,
                                              Byte.valueOf(AV232Conceptos_exportwwds_49_tfconobrasocapo) ,
                                              Byte.valueOf(AV233Conceptos_exportwwds_50_tfconobrasocapo_to) ,
                                              Byte.valueOf(AV234Conceptos_exportwwds_51_tfconobrasoccont) ,
                                              Byte.valueOf(AV235Conceptos_exportwwds_52_tfconobrasoccont_to) ,
                                              Byte.valueOf(AV236Conceptos_exportwwds_53_tfconfonsolredapo) ,
                                              Byte.valueOf(AV237Conceptos_exportwwds_54_tfconfonsolredapo_to) ,
                                              Byte.valueOf(AV238Conceptos_exportwwds_55_tfconfonsolredcont) ,
                                              Byte.valueOf(AV239Conceptos_exportwwds_56_tfconfonsolredcont_to) ,
                                              Byte.valueOf(AV240Conceptos_exportwwds_57_tfconrenateaapo) ,
                                              Byte.valueOf(AV241Conceptos_exportwwds_58_tfconrenateaapo_to) ,
                                              Byte.valueOf(AV242Conceptos_exportwwds_59_tfconrenateacont) ,
                                              Byte.valueOf(AV243Conceptos_exportwwds_60_tfconrenateacont_to) ,
                                              Byte.valueOf(AV244Conceptos_exportwwds_61_tfconasigfamcont) ,
                                              Byte.valueOf(AV245Conceptos_exportwwds_62_tfconasigfamcont_to) ,
                                              Byte.valueOf(AV246Conceptos_exportwwds_63_tfconfonnacempcont) ,
                                              Byte.valueOf(AV247Conceptos_exportwwds_64_tfconfonnacempcont_to) ,
                                              Byte.valueOf(AV248Conceptos_exportwwds_65_tfconleyrietrabcont) ,
                                              Byte.valueOf(AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to) ,
                                              Byte.valueOf(AV250Conceptos_exportwwds_67_tfconregdifapo) ,
                                              Byte.valueOf(AV251Conceptos_exportwwds_68_tfconregdifapo_to) ,
                                              Byte.valueOf(AV252Conceptos_exportwwds_69_tfconregespapo) ,
                                              Byte.valueOf(AV253Conceptos_exportwwds_70_tfconregespapo_to) ,
                                              Short.valueOf(AV254Conceptos_exportwwds_71_tfconceptopais) ,
                                              Short.valueOf(AV255Conceptos_exportwwds_72_tfconceptopais_to) ,
                                              Integer.valueOf(AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels.size()) ,
                                              AV256Conceptos_exportwwds_73_tfconceptoconvecodigo ,
                                              Integer.valueOf(AV258Conceptos_exportwwds_75_tfconbaselicprom_sels.size()) ,
                                              Integer.valueOf(AV259Conceptos_exportwwds_76_tfconbaseferprom_sels.size()) ,
                                              Integer.valueOf(AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels.size()) ,
                                              Integer.valueOf(AV261Conceptos_exportwwds_78_tfconbasepres_sels.size()) ,
                                              Integer.valueOf(AV262Conceptos_exportwwds_79_tfconbaseant_sels.size()) ,
                                              Integer.valueOf(AV263Conceptos_exportwwds_80_tfconbaseosdif_sels.size()) ,
                                              Byte.valueOf(AV264Conceptos_exportwwds_81_tfconerrorsicero_sel) ,
                                              Integer.valueOf(AV265Conceptos_exportwwds_82_tfclipadre) ,
                                              Integer.valueOf(AV266Conceptos_exportwwds_83_tfclipadre_to) ,
                                              Integer.valueOf(AV268Conceptos_exportwwds_85_tfconpadre_sels.size()) ,
                                              AV267Conceptos_exportwwds_84_tfconpadre ,
                                              Byte.valueOf(AV269Conceptos_exportwwds_86_tfconpuenov_sel) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Integer.valueOf(A40ConOrden) ,
                                              Byte.valueOf(A1488ConLiqBasica) ,
                                              Boolean.valueOf(A159ConVariable) ,
                                              Boolean.valueOf(A146ConForEditable) ,
                                              Long.valueOf(A510ConOrdEjec) ,
                                              Boolean.valueOf(A762ConRecalcular) ,
                                              Boolean.valueOf(A1068ConMostrarPos) ,
                                              Short.valueOf(A1112AplIIGG) ,
                                              Boolean.valueOf(A1194ConSegunPla) ,
                                              Byte.valueOf(A1472ConSIPAApo) ,
                                              Byte.valueOf(A1473ConSIPACont) ,
                                              Byte.valueOf(A1474ConINSSJyPApo) ,
                                              Byte.valueOf(A1475ConINSSJyPCont) ,
                                              Byte.valueOf(A1476ConObraSocApo) ,
                                              Byte.valueOf(A1477ConObraSocCont) ,
                                              Byte.valueOf(A1478ConFonSolRedApo) ,
                                              Byte.valueOf(A1479ConFonSolRedCont) ,
                                              Byte.valueOf(A1480ConRenateaApo) ,
                                              Byte.valueOf(A1481ConRenateaCont) ,
                                              Byte.valueOf(A1482ConAsigFamCont) ,
                                              Byte.valueOf(A1483ConFonNacEmpCont) ,
                                              Byte.valueOf(A1484ConLeyRieTrabCont) ,
                                              Byte.valueOf(A1485ConRegDifApo) ,
                                              Byte.valueOf(A1486ConRegEspApo) ,
                                              Short.valueOf(A1644ConceptoPais) ,
                                              Boolean.valueOf(A1821ConErrorSiCero) ,
                                              Integer.valueOf(A1822CliPadre) ,
                                              Boolean.valueOf(A1826ConPueNov) ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) ,
                                              Integer.valueOf(AV87CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING,
                                              TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.BYTE, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.BYTE,
                                              TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT
                                              }
         });
         lV186Conceptos_exportwwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV186Conceptos_exportwwds_3_tfconcodigo), 10, "%") ;
         lV188Conceptos_exportwwds_5_tfcondescrip = GXutil.concat( GXutil.rtrim( AV188Conceptos_exportwwds_5_tfcondescrip), "%", "") ;
         lV194Conceptos_exportwwds_11_tfconformula = GXutil.concat( GXutil.rtrim( AV194Conceptos_exportwwds_11_tfconformula), "%", "") ;
         lV196Conceptos_exportwwds_13_tfconobservacion = GXutil.concat( GXutil.rtrim( AV196Conceptos_exportwwds_13_tfconobservacion), "%", "") ;
         lV201Conceptos_exportwwds_18_tfsubtipoconcod1 = GXutil.padr( GXutil.rtrim( AV201Conceptos_exportwwds_18_tfsubtipoconcod1), 20, "%") ;
         lV203Conceptos_exportwwds_20_tfsubtipoconcod2 = GXutil.padr( GXutil.rtrim( AV203Conceptos_exportwwds_20_tfsubtipoconcod2), 20, "%") ;
         lV205Conceptos_exportwwds_22_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV205Conceptos_exportwwds_22_tfcontipoliqaux), "%", "") ;
         lV207Conceptos_exportwwds_24_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV207Conceptos_exportwwds_24_tfconclasifaux), "%", "") ;
         lV212Conceptos_exportwwds_29_tfconrangocant = GXutil.concat( GXutil.rtrim( AV212Conceptos_exportwwds_29_tfconrangocant), "%", "") ;
         lV215Conceptos_exportwwds_32_tfconcondcodigo = GXutil.padr( GXutil.rtrim( AV215Conceptos_exportwwds_32_tfconcondcodigo), 20, "%") ;
         lV222Conceptos_exportwwds_39_tfconcodafip = GXutil.padr( GXutil.rtrim( AV222Conceptos_exportwwds_39_tfconcodafip), 6, "%") ;
         lV256Conceptos_exportwwds_73_tfconceptoconvecodigo = GXutil.padr( GXutil.rtrim( AV256Conceptos_exportwwds_73_tfconceptoconvecodigo), 20, "%") ;
         lV267Conceptos_exportwwds_84_tfconpadre = GXutil.padr( GXutil.rtrim( AV267Conceptos_exportwwds_84_tfconpadre), 10, "%") ;
         /* Using cursor H00IB2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV87CliCod), Integer.valueOf(AV184Conceptos_exportwwds_1_tfclicod), Integer.valueOf(AV185Conceptos_exportwwds_2_tfclicod_to), lV186Conceptos_exportwwds_3_tfconcodigo, lV188Conceptos_exportwwds_5_tfcondescrip, Integer.valueOf(AV190Conceptos_exportwwds_7_tfconorden), Integer.valueOf(AV191Conceptos_exportwwds_8_tfconorden_to), Byte.valueOf(AV192Conceptos_exportwwds_9_tfconliqbasica), Byte.valueOf(AV193Conceptos_exportwwds_10_tfconliqbasica_to), lV194Conceptos_exportwwds_11_tfconformula, lV196Conceptos_exportwwds_13_tfconobservacion, lV201Conceptos_exportwwds_18_tfsubtipoconcod1, lV203Conceptos_exportwwds_20_tfsubtipoconcod2, lV205Conceptos_exportwwds_22_tfcontipoliqaux, lV207Conceptos_exportwwds_24_tfconclasifaux, Long.valueOf(AV209Conceptos_exportwwds_26_tfconordejec), Long.valueOf(AV210Conceptos_exportwwds_27_tfconordejec_to), lV212Conceptos_exportwwds_29_tfconrangocant, lV215Conceptos_exportwwds_32_tfconcondcodigo, Short.valueOf(AV219Conceptos_exportwwds_36_tfapliigg), Short.valueOf(AV220Conceptos_exportwwds_37_tfapliigg_to), lV222Conceptos_exportwwds_39_tfconcodafip, Byte.valueOf(AV224Conceptos_exportwwds_41_tfconsipaapo), Byte.valueOf(AV225Conceptos_exportwwds_42_tfconsipaapo_to), Byte.valueOf(AV226Conceptos_exportwwds_43_tfconsipacont), Byte.valueOf(AV227Conceptos_exportwwds_44_tfconsipacont_to), Byte.valueOf(AV228Conceptos_exportwwds_45_tfconinssjypapo), Byte.valueOf(AV229Conceptos_exportwwds_46_tfconinssjypapo_to), Byte.valueOf(AV230Conceptos_exportwwds_47_tfconinssjypcont), Byte.valueOf(AV231Conceptos_exportwwds_48_tfconinssjypcont_to), Byte.valueOf(AV232Conceptos_exportwwds_49_tfconobrasocapo), Byte.valueOf(AV233Conceptos_exportwwds_50_tfconobrasocapo_to), Byte.valueOf(AV234Conceptos_exportwwds_51_tfconobrasoccont), Byte.valueOf(AV235Conceptos_exportwwds_52_tfconobrasoccont_to), Byte.valueOf(AV236Conceptos_exportwwds_53_tfconfonsolredapo), Byte.valueOf(AV237Conceptos_exportwwds_54_tfconfonsolredapo_to), Byte.valueOf(AV238Conceptos_exportwwds_55_tfconfonsolredcont), Byte.valueOf(AV239Conceptos_exportwwds_56_tfconfonsolredcont_to), Byte.valueOf(AV240Conceptos_exportwwds_57_tfconrenateaapo), Byte.valueOf(AV241Conceptos_exportwwds_58_tfconrenateaapo_to), Byte.valueOf(AV242Conceptos_exportwwds_59_tfconrenateacont), Byte.valueOf(AV243Conceptos_exportwwds_60_tfconrenateacont_to), Byte.valueOf(AV244Conceptos_exportwwds_61_tfconasigfamcont), Byte.valueOf(AV245Conceptos_exportwwds_62_tfconasigfamcont_to), Byte.valueOf(AV246Conceptos_exportwwds_63_tfconfonnacempcont), Byte.valueOf(AV247Conceptos_exportwwds_64_tfconfonnacempcont_to), Byte.valueOf(AV248Conceptos_exportwwds_65_tfconleyrietrabcont), Byte.valueOf(AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to), Byte.valueOf(AV250Conceptos_exportwwds_67_tfconregdifapo), Byte.valueOf(AV251Conceptos_exportwwds_68_tfconregdifapo_to), Byte.valueOf(AV252Conceptos_exportwwds_69_tfconregespapo), Byte.valueOf(AV253Conceptos_exportwwds_70_tfconregespapo_to), Short.valueOf(AV254Conceptos_exportwwds_71_tfconceptopais), Short.valueOf(AV255Conceptos_exportwwds_72_tfconceptopais_to), lV256Conceptos_exportwwds_73_tfconceptoconvecodigo, Integer.valueOf(AV265Conceptos_exportwwds_82_tfclipadre), Integer.valueOf(AV266Conceptos_exportwwds_83_tfclipadre_to), lV267Conceptos_exportwwds_84_tfconpadre, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_110_idx = 1 ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1826ConPueNov = H00IB2_A1826ConPueNov[0] ;
            A921ConPadre = H00IB2_A921ConPadre[0] ;
            n921ConPadre = H00IB2_n921ConPadre[0] ;
            A1822CliPadre = H00IB2_A1822CliPadre[0] ;
            n1822CliPadre = H00IB2_n1822CliPadre[0] ;
            A1821ConErrorSiCero = H00IB2_A1821ConErrorSiCero[0] ;
            A1827ConBaseOSDif = H00IB2_A1827ConBaseOSDif[0] ;
            A1801ConBaseAnt = H00IB2_A1801ConBaseAnt[0] ;
            A1800ConBasePres = H00IB2_A1800ConBasePres[0] ;
            A1799ConBaseHorExtProm = H00IB2_A1799ConBaseHorExtProm[0] ;
            A1622ConBaseHorExt = H00IB2_A1622ConBaseHorExt[0] ;
            A1798ConBaseFerProm = H00IB2_A1798ConBaseFerProm[0] ;
            A1621ConBaseFer = H00IB2_A1621ConBaseFer[0] ;
            A1797ConBaseLicProm = H00IB2_A1797ConBaseLicProm[0] ;
            A1620ConBaseLic = H00IB2_A1620ConBaseLic[0] ;
            A1645ConceptoConveCodigo = H00IB2_A1645ConceptoConveCodigo[0] ;
            n1645ConceptoConveCodigo = H00IB2_n1645ConceptoConveCodigo[0] ;
            A1644ConceptoPais = H00IB2_A1644ConceptoPais[0] ;
            n1644ConceptoPais = H00IB2_n1644ConceptoPais[0] ;
            A1539ConSacDeven = H00IB2_A1539ConSacDeven[0] ;
            A1486ConRegEspApo = H00IB2_A1486ConRegEspApo[0] ;
            A1485ConRegDifApo = H00IB2_A1485ConRegDifApo[0] ;
            A1484ConLeyRieTrabCont = H00IB2_A1484ConLeyRieTrabCont[0] ;
            A1483ConFonNacEmpCont = H00IB2_A1483ConFonNacEmpCont[0] ;
            A1482ConAsigFamCont = H00IB2_A1482ConAsigFamCont[0] ;
            A1481ConRenateaCont = H00IB2_A1481ConRenateaCont[0] ;
            A1480ConRenateaApo = H00IB2_A1480ConRenateaApo[0] ;
            A1479ConFonSolRedCont = H00IB2_A1479ConFonSolRedCont[0] ;
            A1478ConFonSolRedApo = H00IB2_A1478ConFonSolRedApo[0] ;
            A1477ConObraSocCont = H00IB2_A1477ConObraSocCont[0] ;
            A1476ConObraSocApo = H00IB2_A1476ConObraSocApo[0] ;
            A1475ConINSSJyPCont = H00IB2_A1475ConINSSJyPCont[0] ;
            A1474ConINSSJyPApo = H00IB2_A1474ConINSSJyPApo[0] ;
            A1473ConSIPACont = H00IB2_A1473ConSIPACont[0] ;
            A1472ConSIPAApo = H00IB2_A1472ConSIPAApo[0] ;
            A1648ConCodAfip = H00IB2_A1648ConCodAfip[0] ;
            A1194ConSegunPla = H00IB2_A1194ConSegunPla[0] ;
            A1112AplIIGG = H00IB2_A1112AplIIGG[0] ;
            n1112AplIIGG = H00IB2_n1112AplIIGG[0] ;
            A1077ConAdelDescu = H00IB2_A1077ConAdelDescu[0] ;
            n1077ConAdelDescu = H00IB2_n1077ConAdelDescu[0] ;
            A1068ConMostrarPos = H00IB2_A1068ConMostrarPos[0] ;
            A954ConCondCodigo = H00IB2_A954ConCondCodigo[0] ;
            A953ConCondicion = H00IB2_A953ConCondicion[0] ;
            n953ConCondicion = H00IB2_n953ConCondicion[0] ;
            A1018ConRangoCant = H00IB2_A1018ConRangoCant[0] ;
            A762ConRecalcular = H00IB2_A762ConRecalcular[0] ;
            A510ConOrdEjec = H00IB2_A510ConOrdEjec[0] ;
            A970ConClasifAux = H00IB2_A970ConClasifAux[0] ;
            n970ConClasifAux = H00IB2_n970ConClasifAux[0] ;
            A503ConTipoLiqAux = H00IB2_A503ConTipoLiqAux[0] ;
            n503ConTipoLiqAux = H00IB2_n503ConTipoLiqAux[0] ;
            A39SubTipoConCod2 = H00IB2_A39SubTipoConCod2[0] ;
            n39SubTipoConCod2 = H00IB2_n39SubTipoConCod2[0] ;
            A38SubTipoConCod1 = H00IB2_A38SubTipoConCod1[0] ;
            n38SubTipoConCod1 = H00IB2_n38SubTipoConCod1[0] ;
            A37TipoConCod = H00IB2_A37TipoConCod[0] ;
            A146ConForEditable = H00IB2_A146ConForEditable[0] ;
            n146ConForEditable = H00IB2_n146ConForEditable[0] ;
            A159ConVariable = H00IB2_A159ConVariable[0] ;
            A153ConObservacion = H00IB2_A153ConObservacion[0] ;
            A148ConFormula = H00IB2_A148ConFormula[0] ;
            n148ConFormula = H00IB2_n148ConFormula[0] ;
            A1488ConLiqBasica = H00IB2_A1488ConLiqBasica[0] ;
            A162ConVigencia = H00IB2_A162ConVigencia[0] ;
            A40ConOrden = H00IB2_A40ConOrden[0] ;
            A41ConDescrip = H00IB2_A41ConDescrip[0] ;
            A26ConCodigo = H00IB2_A26ConCodigo[0] ;
            A3CliCod = H00IB2_A3CliCod[0] ;
            e23IB2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(110) ;
         wbIB0( ) ;
      }
      bGXsfl_110_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesIB2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV183Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV183Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV159MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV159MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV87CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV87CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CONCODIGO"+"_"+sGXsfl_110_idx, getSecureSignedToken( sGXsfl_110_idx, GXutil.rtrim( localUtil.format( A26ConCodigo, ""))));
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
      AV184Conceptos_exportwwds_1_tfclicod = AV24TFCliCod ;
      AV185Conceptos_exportwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV186Conceptos_exportwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV187Conceptos_exportwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV188Conceptos_exportwwds_5_tfcondescrip = AV30TFConDescrip ;
      AV189Conceptos_exportwwds_6_tfcondescrip_sels = AV31TFConDescrip_Sels ;
      AV190Conceptos_exportwwds_7_tfconorden = AV32TFConOrden ;
      AV191Conceptos_exportwwds_8_tfconorden_to = AV33TFConOrden_To ;
      AV192Conceptos_exportwwds_9_tfconliqbasica = AV36TFConLiqBasica ;
      AV193Conceptos_exportwwds_10_tfconliqbasica_to = AV37TFConLiqBasica_To ;
      AV194Conceptos_exportwwds_11_tfconformula = AV39TFConFormula ;
      AV195Conceptos_exportwwds_12_tfconformula_sels = AV40TFConFormula_Sels ;
      AV196Conceptos_exportwwds_13_tfconobservacion = AV42TFConObservacion ;
      AV197Conceptos_exportwwds_14_tfconobservacion_sels = AV43TFConObservacion_Sels ;
      AV198Conceptos_exportwwds_15_tfconvariable_sel = AV44TFConVariable_Sel ;
      AV199Conceptos_exportwwds_16_tfconforeditable_sel = AV45TFConForEditable_Sel ;
      AV200Conceptos_exportwwds_17_tftipoconcod_sels = AV47TFTipoConCod_Sels ;
      AV201Conceptos_exportwwds_18_tfsubtipoconcod1 = AV49TFSubTipoConCod1 ;
      AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels = AV50TFSubTipoConCod1_Sels ;
      AV203Conceptos_exportwwds_20_tfsubtipoconcod2 = AV52TFSubTipoConCod2 ;
      AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels = AV53TFSubTipoConCod2_Sels ;
      AV205Conceptos_exportwwds_22_tfcontipoliqaux = AV55TFConTipoLiqAux ;
      AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels = AV56TFConTipoLiqAux_Sels ;
      AV207Conceptos_exportwwds_24_tfconclasifaux = AV58TFConClasifAux ;
      AV208Conceptos_exportwwds_25_tfconclasifaux_sels = AV59TFConClasifAux_Sels ;
      AV209Conceptos_exportwwds_26_tfconordejec = AV60TFConOrdEjec ;
      AV210Conceptos_exportwwds_27_tfconordejec_to = AV61TFConOrdEjec_To ;
      AV211Conceptos_exportwwds_28_tfconrecalcular_sel = AV65TFConRecalcular_Sel ;
      AV212Conceptos_exportwwds_29_tfconrangocant = AV67TFConRangoCant ;
      AV213Conceptos_exportwwds_30_tfconrangocant_sels = AV68TFConRangoCant_Sels ;
      AV214Conceptos_exportwwds_31_tfconcondicion_sels = AV70TFConCondicion_Sels ;
      AV215Conceptos_exportwwds_32_tfconcondcodigo = AV72TFConCondCodigo ;
      AV216Conceptos_exportwwds_33_tfconcondcodigo_sels = AV73TFConCondCodigo_Sels ;
      AV217Conceptos_exportwwds_34_tfconmostrarpos_sel = AV74TFConMostrarPos_Sel ;
      AV218Conceptos_exportwwds_35_tfconadeldescu_sels = AV76TFConAdelDescu_Sels ;
      AV219Conceptos_exportwwds_36_tfapliigg = AV77TFAplIIGG ;
      AV220Conceptos_exportwwds_37_tfapliigg_to = AV78TFAplIIGG_To ;
      AV221Conceptos_exportwwds_38_tfconsegunpla_sel = AV79TFConSegunPla_Sel ;
      AV222Conceptos_exportwwds_39_tfconcodafip = AV92TFConCodAfip ;
      AV223Conceptos_exportwwds_40_tfconcodafip_sels = AV93TFConCodAfip_Sels ;
      AV224Conceptos_exportwwds_41_tfconsipaapo = AV94TFConSIPAApo ;
      AV225Conceptos_exportwwds_42_tfconsipaapo_to = AV95TFConSIPAApo_To ;
      AV226Conceptos_exportwwds_43_tfconsipacont = AV96TFConSIPACont ;
      AV227Conceptos_exportwwds_44_tfconsipacont_to = AV97TFConSIPACont_To ;
      AV228Conceptos_exportwwds_45_tfconinssjypapo = AV98TFConINSSJyPApo ;
      AV229Conceptos_exportwwds_46_tfconinssjypapo_to = AV99TFConINSSJyPApo_To ;
      AV230Conceptos_exportwwds_47_tfconinssjypcont = AV100TFConINSSJyPCont ;
      AV231Conceptos_exportwwds_48_tfconinssjypcont_to = AV101TFConINSSJyPCont_To ;
      AV232Conceptos_exportwwds_49_tfconobrasocapo = AV102TFConObraSocApo ;
      AV233Conceptos_exportwwds_50_tfconobrasocapo_to = AV103TFConObraSocApo_To ;
      AV234Conceptos_exportwwds_51_tfconobrasoccont = AV104TFConObraSocCont ;
      AV235Conceptos_exportwwds_52_tfconobrasoccont_to = AV105TFConObraSocCont_To ;
      AV236Conceptos_exportwwds_53_tfconfonsolredapo = AV106TFConFonSolRedApo ;
      AV237Conceptos_exportwwds_54_tfconfonsolredapo_to = AV107TFConFonSolRedApo_To ;
      AV238Conceptos_exportwwds_55_tfconfonsolredcont = AV108TFConFonSolRedCont ;
      AV239Conceptos_exportwwds_56_tfconfonsolredcont_to = AV109TFConFonSolRedCont_To ;
      AV240Conceptos_exportwwds_57_tfconrenateaapo = AV110TFConRenateaApo ;
      AV241Conceptos_exportwwds_58_tfconrenateaapo_to = AV111TFConRenateaApo_To ;
      AV242Conceptos_exportwwds_59_tfconrenateacont = AV112TFConRenateaCont ;
      AV243Conceptos_exportwwds_60_tfconrenateacont_to = AV113TFConRenateaCont_To ;
      AV244Conceptos_exportwwds_61_tfconasigfamcont = AV114TFConAsigFamCont ;
      AV245Conceptos_exportwwds_62_tfconasigfamcont_to = AV115TFConAsigFamCont_To ;
      AV246Conceptos_exportwwds_63_tfconfonnacempcont = AV116TFConFonNacEmpCont ;
      AV247Conceptos_exportwwds_64_tfconfonnacempcont_to = AV117TFConFonNacEmpCont_To ;
      AV248Conceptos_exportwwds_65_tfconleyrietrabcont = AV118TFConLeyRieTrabCont ;
      AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to = AV119TFConLeyRieTrabCont_To ;
      AV250Conceptos_exportwwds_67_tfconregdifapo = AV120TFConRegDifApo ;
      AV251Conceptos_exportwwds_68_tfconregdifapo_to = AV121TFConRegDifApo_To ;
      AV252Conceptos_exportwwds_69_tfconregespapo = AV122TFConRegEspApo ;
      AV253Conceptos_exportwwds_70_tfconregespapo_to = AV123TFConRegEspApo_To ;
      AV254Conceptos_exportwwds_71_tfconceptopais = AV126TFConceptoPais ;
      AV255Conceptos_exportwwds_72_tfconceptopais_to = AV127TFConceptoPais_To ;
      AV256Conceptos_exportwwds_73_tfconceptoconvecodigo = AV129TFConceptoConveCodigo ;
      AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels = AV130TFConceptoConveCodigo_Sels ;
      AV258Conceptos_exportwwds_75_tfconbaselicprom_sels = AV138TFConBaseLicProm_Sels ;
      AV259Conceptos_exportwwds_76_tfconbaseferprom_sels = AV140TFConBaseFerProm_Sels ;
      AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels = AV142TFConBaseHorExtProm_Sels ;
      AV261Conceptos_exportwwds_78_tfconbasepres_sels = AV144TFConBasePres_Sels ;
      AV262Conceptos_exportwwds_79_tfconbaseant_sels = AV146TFConBaseAnt_Sels ;
      AV263Conceptos_exportwwds_80_tfconbaseosdif_sels = AV148TFConBaseOSDif_Sels ;
      AV264Conceptos_exportwwds_81_tfconerrorsicero_sel = AV149TFConErrorSiCero_Sel ;
      AV265Conceptos_exportwwds_82_tfclipadre = AV150TFCliPadre ;
      AV266Conceptos_exportwwds_83_tfclipadre_to = AV151TFCliPadre_To ;
      AV267Conceptos_exportwwds_84_tfconpadre = AV153TFConPadre ;
      AV268Conceptos_exportwwds_85_tfconpadre_sels = AV154TFConPadre_Sels ;
      AV269Conceptos_exportwwds_86_tfconpuenov_sel = AV155TFConPueNov_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV187Conceptos_exportwwds_4_tfconcodigo_sels ,
                                           A41ConDescrip ,
                                           AV189Conceptos_exportwwds_6_tfcondescrip_sels ,
                                           A148ConFormula ,
                                           AV195Conceptos_exportwwds_12_tfconformula_sels ,
                                           A153ConObservacion ,
                                           AV197Conceptos_exportwwds_14_tfconobservacion_sels ,
                                           A37TipoConCod ,
                                           AV200Conceptos_exportwwds_17_tftipoconcod_sels ,
                                           A38SubTipoConCod1 ,
                                           AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels ,
                                           A39SubTipoConCod2 ,
                                           AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels ,
                                           A503ConTipoLiqAux ,
                                           AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels ,
                                           A970ConClasifAux ,
                                           AV208Conceptos_exportwwds_25_tfconclasifaux_sels ,
                                           A1018ConRangoCant ,
                                           AV213Conceptos_exportwwds_30_tfconrangocant_sels ,
                                           A953ConCondicion ,
                                           AV214Conceptos_exportwwds_31_tfconcondicion_sels ,
                                           A954ConCondCodigo ,
                                           AV216Conceptos_exportwwds_33_tfconcondcodigo_sels ,
                                           Byte.valueOf(A1077ConAdelDescu) ,
                                           AV218Conceptos_exportwwds_35_tfconadeldescu_sels ,
                                           A1648ConCodAfip ,
                                           AV223Conceptos_exportwwds_40_tfconcodafip_sels ,
                                           A1645ConceptoConveCodigo ,
                                           AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels ,
                                           Byte.valueOf(A1797ConBaseLicProm) ,
                                           AV258Conceptos_exportwwds_75_tfconbaselicprom_sels ,
                                           Byte.valueOf(A1798ConBaseFerProm) ,
                                           AV259Conceptos_exportwwds_76_tfconbaseferprom_sels ,
                                           Byte.valueOf(A1799ConBaseHorExtProm) ,
                                           AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels ,
                                           Byte.valueOf(A1800ConBasePres) ,
                                           AV261Conceptos_exportwwds_78_tfconbasepres_sels ,
                                           Byte.valueOf(A1801ConBaseAnt) ,
                                           AV262Conceptos_exportwwds_79_tfconbaseant_sels ,
                                           Byte.valueOf(A1827ConBaseOSDif) ,
                                           AV263Conceptos_exportwwds_80_tfconbaseosdif_sels ,
                                           A921ConPadre ,
                                           AV268Conceptos_exportwwds_85_tfconpadre_sels ,
                                           Integer.valueOf(AV184Conceptos_exportwwds_1_tfclicod) ,
                                           Integer.valueOf(AV185Conceptos_exportwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV187Conceptos_exportwwds_4_tfconcodigo_sels.size()) ,
                                           AV186Conceptos_exportwwds_3_tfconcodigo ,
                                           Integer.valueOf(AV189Conceptos_exportwwds_6_tfcondescrip_sels.size()) ,
                                           AV188Conceptos_exportwwds_5_tfcondescrip ,
                                           Integer.valueOf(AV190Conceptos_exportwwds_7_tfconorden) ,
                                           Integer.valueOf(AV191Conceptos_exportwwds_8_tfconorden_to) ,
                                           Byte.valueOf(AV192Conceptos_exportwwds_9_tfconliqbasica) ,
                                           Byte.valueOf(AV193Conceptos_exportwwds_10_tfconliqbasica_to) ,
                                           Integer.valueOf(AV195Conceptos_exportwwds_12_tfconformula_sels.size()) ,
                                           AV194Conceptos_exportwwds_11_tfconformula ,
                                           Integer.valueOf(AV197Conceptos_exportwwds_14_tfconobservacion_sels.size()) ,
                                           AV196Conceptos_exportwwds_13_tfconobservacion ,
                                           Byte.valueOf(AV198Conceptos_exportwwds_15_tfconvariable_sel) ,
                                           Byte.valueOf(AV199Conceptos_exportwwds_16_tfconforeditable_sel) ,
                                           Integer.valueOf(AV200Conceptos_exportwwds_17_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels.size()) ,
                                           AV201Conceptos_exportwwds_18_tfsubtipoconcod1 ,
                                           Integer.valueOf(AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels.size()) ,
                                           AV203Conceptos_exportwwds_20_tfsubtipoconcod2 ,
                                           Integer.valueOf(AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels.size()) ,
                                           AV205Conceptos_exportwwds_22_tfcontipoliqaux ,
                                           Integer.valueOf(AV208Conceptos_exportwwds_25_tfconclasifaux_sels.size()) ,
                                           AV207Conceptos_exportwwds_24_tfconclasifaux ,
                                           Long.valueOf(AV209Conceptos_exportwwds_26_tfconordejec) ,
                                           Long.valueOf(AV210Conceptos_exportwwds_27_tfconordejec_to) ,
                                           Byte.valueOf(AV211Conceptos_exportwwds_28_tfconrecalcular_sel) ,
                                           Integer.valueOf(AV213Conceptos_exportwwds_30_tfconrangocant_sels.size()) ,
                                           AV212Conceptos_exportwwds_29_tfconrangocant ,
                                           Integer.valueOf(AV214Conceptos_exportwwds_31_tfconcondicion_sels.size()) ,
                                           Integer.valueOf(AV216Conceptos_exportwwds_33_tfconcondcodigo_sels.size()) ,
                                           AV215Conceptos_exportwwds_32_tfconcondcodigo ,
                                           Byte.valueOf(AV217Conceptos_exportwwds_34_tfconmostrarpos_sel) ,
                                           Integer.valueOf(AV218Conceptos_exportwwds_35_tfconadeldescu_sels.size()) ,
                                           Short.valueOf(AV219Conceptos_exportwwds_36_tfapliigg) ,
                                           Short.valueOf(AV220Conceptos_exportwwds_37_tfapliigg_to) ,
                                           Byte.valueOf(AV221Conceptos_exportwwds_38_tfconsegunpla_sel) ,
                                           Integer.valueOf(AV223Conceptos_exportwwds_40_tfconcodafip_sels.size()) ,
                                           AV222Conceptos_exportwwds_39_tfconcodafip ,
                                           Byte.valueOf(AV224Conceptos_exportwwds_41_tfconsipaapo) ,
                                           Byte.valueOf(AV225Conceptos_exportwwds_42_tfconsipaapo_to) ,
                                           Byte.valueOf(AV226Conceptos_exportwwds_43_tfconsipacont) ,
                                           Byte.valueOf(AV227Conceptos_exportwwds_44_tfconsipacont_to) ,
                                           Byte.valueOf(AV228Conceptos_exportwwds_45_tfconinssjypapo) ,
                                           Byte.valueOf(AV229Conceptos_exportwwds_46_tfconinssjypapo_to) ,
                                           Byte.valueOf(AV230Conceptos_exportwwds_47_tfconinssjypcont) ,
                                           Byte.valueOf(AV231Conceptos_exportwwds_48_tfconinssjypcont_to) ,
                                           Byte.valueOf(AV232Conceptos_exportwwds_49_tfconobrasocapo) ,
                                           Byte.valueOf(AV233Conceptos_exportwwds_50_tfconobrasocapo_to) ,
                                           Byte.valueOf(AV234Conceptos_exportwwds_51_tfconobrasoccont) ,
                                           Byte.valueOf(AV235Conceptos_exportwwds_52_tfconobrasoccont_to) ,
                                           Byte.valueOf(AV236Conceptos_exportwwds_53_tfconfonsolredapo) ,
                                           Byte.valueOf(AV237Conceptos_exportwwds_54_tfconfonsolredapo_to) ,
                                           Byte.valueOf(AV238Conceptos_exportwwds_55_tfconfonsolredcont) ,
                                           Byte.valueOf(AV239Conceptos_exportwwds_56_tfconfonsolredcont_to) ,
                                           Byte.valueOf(AV240Conceptos_exportwwds_57_tfconrenateaapo) ,
                                           Byte.valueOf(AV241Conceptos_exportwwds_58_tfconrenateaapo_to) ,
                                           Byte.valueOf(AV242Conceptos_exportwwds_59_tfconrenateacont) ,
                                           Byte.valueOf(AV243Conceptos_exportwwds_60_tfconrenateacont_to) ,
                                           Byte.valueOf(AV244Conceptos_exportwwds_61_tfconasigfamcont) ,
                                           Byte.valueOf(AV245Conceptos_exportwwds_62_tfconasigfamcont_to) ,
                                           Byte.valueOf(AV246Conceptos_exportwwds_63_tfconfonnacempcont) ,
                                           Byte.valueOf(AV247Conceptos_exportwwds_64_tfconfonnacempcont_to) ,
                                           Byte.valueOf(AV248Conceptos_exportwwds_65_tfconleyrietrabcont) ,
                                           Byte.valueOf(AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to) ,
                                           Byte.valueOf(AV250Conceptos_exportwwds_67_tfconregdifapo) ,
                                           Byte.valueOf(AV251Conceptos_exportwwds_68_tfconregdifapo_to) ,
                                           Byte.valueOf(AV252Conceptos_exportwwds_69_tfconregespapo) ,
                                           Byte.valueOf(AV253Conceptos_exportwwds_70_tfconregespapo_to) ,
                                           Short.valueOf(AV254Conceptos_exportwwds_71_tfconceptopais) ,
                                           Short.valueOf(AV255Conceptos_exportwwds_72_tfconceptopais_to) ,
                                           Integer.valueOf(AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels.size()) ,
                                           AV256Conceptos_exportwwds_73_tfconceptoconvecodigo ,
                                           Integer.valueOf(AV258Conceptos_exportwwds_75_tfconbaselicprom_sels.size()) ,
                                           Integer.valueOf(AV259Conceptos_exportwwds_76_tfconbaseferprom_sels.size()) ,
                                           Integer.valueOf(AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels.size()) ,
                                           Integer.valueOf(AV261Conceptos_exportwwds_78_tfconbasepres_sels.size()) ,
                                           Integer.valueOf(AV262Conceptos_exportwwds_79_tfconbaseant_sels.size()) ,
                                           Integer.valueOf(AV263Conceptos_exportwwds_80_tfconbaseosdif_sels.size()) ,
                                           Byte.valueOf(AV264Conceptos_exportwwds_81_tfconerrorsicero_sel) ,
                                           Integer.valueOf(AV265Conceptos_exportwwds_82_tfclipadre) ,
                                           Integer.valueOf(AV266Conceptos_exportwwds_83_tfclipadre_to) ,
                                           Integer.valueOf(AV268Conceptos_exportwwds_85_tfconpadre_sels.size()) ,
                                           AV267Conceptos_exportwwds_84_tfconpadre ,
                                           Byte.valueOf(AV269Conceptos_exportwwds_86_tfconpuenov_sel) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(A40ConOrden) ,
                                           Byte.valueOf(A1488ConLiqBasica) ,
                                           Boolean.valueOf(A159ConVariable) ,
                                           Boolean.valueOf(A146ConForEditable) ,
                                           Long.valueOf(A510ConOrdEjec) ,
                                           Boolean.valueOf(A762ConRecalcular) ,
                                           Boolean.valueOf(A1068ConMostrarPos) ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           Boolean.valueOf(A1194ConSegunPla) ,
                                           Byte.valueOf(A1472ConSIPAApo) ,
                                           Byte.valueOf(A1473ConSIPACont) ,
                                           Byte.valueOf(A1474ConINSSJyPApo) ,
                                           Byte.valueOf(A1475ConINSSJyPCont) ,
                                           Byte.valueOf(A1476ConObraSocApo) ,
                                           Byte.valueOf(A1477ConObraSocCont) ,
                                           Byte.valueOf(A1478ConFonSolRedApo) ,
                                           Byte.valueOf(A1479ConFonSolRedCont) ,
                                           Byte.valueOf(A1480ConRenateaApo) ,
                                           Byte.valueOf(A1481ConRenateaCont) ,
                                           Byte.valueOf(A1482ConAsigFamCont) ,
                                           Byte.valueOf(A1483ConFonNacEmpCont) ,
                                           Byte.valueOf(A1484ConLeyRieTrabCont) ,
                                           Byte.valueOf(A1485ConRegDifApo) ,
                                           Byte.valueOf(A1486ConRegEspApo) ,
                                           Short.valueOf(A1644ConceptoPais) ,
                                           Boolean.valueOf(A1821ConErrorSiCero) ,
                                           Integer.valueOf(A1822CliPadre) ,
                                           Boolean.valueOf(A1826ConPueNov) ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) ,
                                           Integer.valueOf(AV87CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT
                                           }
      });
      lV186Conceptos_exportwwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV186Conceptos_exportwwds_3_tfconcodigo), 10, "%") ;
      lV188Conceptos_exportwwds_5_tfcondescrip = GXutil.concat( GXutil.rtrim( AV188Conceptos_exportwwds_5_tfcondescrip), "%", "") ;
      lV194Conceptos_exportwwds_11_tfconformula = GXutil.concat( GXutil.rtrim( AV194Conceptos_exportwwds_11_tfconformula), "%", "") ;
      lV196Conceptos_exportwwds_13_tfconobservacion = GXutil.concat( GXutil.rtrim( AV196Conceptos_exportwwds_13_tfconobservacion), "%", "") ;
      lV201Conceptos_exportwwds_18_tfsubtipoconcod1 = GXutil.padr( GXutil.rtrim( AV201Conceptos_exportwwds_18_tfsubtipoconcod1), 20, "%") ;
      lV203Conceptos_exportwwds_20_tfsubtipoconcod2 = GXutil.padr( GXutil.rtrim( AV203Conceptos_exportwwds_20_tfsubtipoconcod2), 20, "%") ;
      lV205Conceptos_exportwwds_22_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV205Conceptos_exportwwds_22_tfcontipoliqaux), "%", "") ;
      lV207Conceptos_exportwwds_24_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV207Conceptos_exportwwds_24_tfconclasifaux), "%", "") ;
      lV212Conceptos_exportwwds_29_tfconrangocant = GXutil.concat( GXutil.rtrim( AV212Conceptos_exportwwds_29_tfconrangocant), "%", "") ;
      lV215Conceptos_exportwwds_32_tfconcondcodigo = GXutil.padr( GXutil.rtrim( AV215Conceptos_exportwwds_32_tfconcondcodigo), 20, "%") ;
      lV222Conceptos_exportwwds_39_tfconcodafip = GXutil.padr( GXutil.rtrim( AV222Conceptos_exportwwds_39_tfconcodafip), 6, "%") ;
      lV256Conceptos_exportwwds_73_tfconceptoconvecodigo = GXutil.padr( GXutil.rtrim( AV256Conceptos_exportwwds_73_tfconceptoconvecodigo), 20, "%") ;
      lV267Conceptos_exportwwds_84_tfconpadre = GXutil.padr( GXutil.rtrim( AV267Conceptos_exportwwds_84_tfconpadre), 10, "%") ;
      /* Using cursor H00IB3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV87CliCod), Integer.valueOf(AV184Conceptos_exportwwds_1_tfclicod), Integer.valueOf(AV185Conceptos_exportwwds_2_tfclicod_to), lV186Conceptos_exportwwds_3_tfconcodigo, lV188Conceptos_exportwwds_5_tfcondescrip, Integer.valueOf(AV190Conceptos_exportwwds_7_tfconorden), Integer.valueOf(AV191Conceptos_exportwwds_8_tfconorden_to), Byte.valueOf(AV192Conceptos_exportwwds_9_tfconliqbasica), Byte.valueOf(AV193Conceptos_exportwwds_10_tfconliqbasica_to), lV194Conceptos_exportwwds_11_tfconformula, lV196Conceptos_exportwwds_13_tfconobservacion, lV201Conceptos_exportwwds_18_tfsubtipoconcod1, lV203Conceptos_exportwwds_20_tfsubtipoconcod2, lV205Conceptos_exportwwds_22_tfcontipoliqaux, lV207Conceptos_exportwwds_24_tfconclasifaux, Long.valueOf(AV209Conceptos_exportwwds_26_tfconordejec), Long.valueOf(AV210Conceptos_exportwwds_27_tfconordejec_to), lV212Conceptos_exportwwds_29_tfconrangocant, lV215Conceptos_exportwwds_32_tfconcondcodigo, Short.valueOf(AV219Conceptos_exportwwds_36_tfapliigg), Short.valueOf(AV220Conceptos_exportwwds_37_tfapliigg_to), lV222Conceptos_exportwwds_39_tfconcodafip, Byte.valueOf(AV224Conceptos_exportwwds_41_tfconsipaapo), Byte.valueOf(AV225Conceptos_exportwwds_42_tfconsipaapo_to), Byte.valueOf(AV226Conceptos_exportwwds_43_tfconsipacont), Byte.valueOf(AV227Conceptos_exportwwds_44_tfconsipacont_to), Byte.valueOf(AV228Conceptos_exportwwds_45_tfconinssjypapo), Byte.valueOf(AV229Conceptos_exportwwds_46_tfconinssjypapo_to), Byte.valueOf(AV230Conceptos_exportwwds_47_tfconinssjypcont), Byte.valueOf(AV231Conceptos_exportwwds_48_tfconinssjypcont_to), Byte.valueOf(AV232Conceptos_exportwwds_49_tfconobrasocapo), Byte.valueOf(AV233Conceptos_exportwwds_50_tfconobrasocapo_to), Byte.valueOf(AV234Conceptos_exportwwds_51_tfconobrasoccont), Byte.valueOf(AV235Conceptos_exportwwds_52_tfconobrasoccont_to), Byte.valueOf(AV236Conceptos_exportwwds_53_tfconfonsolredapo), Byte.valueOf(AV237Conceptos_exportwwds_54_tfconfonsolredapo_to), Byte.valueOf(AV238Conceptos_exportwwds_55_tfconfonsolredcont), Byte.valueOf(AV239Conceptos_exportwwds_56_tfconfonsolredcont_to), Byte.valueOf(AV240Conceptos_exportwwds_57_tfconrenateaapo), Byte.valueOf(AV241Conceptos_exportwwds_58_tfconrenateaapo_to), Byte.valueOf(AV242Conceptos_exportwwds_59_tfconrenateacont), Byte.valueOf(AV243Conceptos_exportwwds_60_tfconrenateacont_to), Byte.valueOf(AV244Conceptos_exportwwds_61_tfconasigfamcont), Byte.valueOf(AV245Conceptos_exportwwds_62_tfconasigfamcont_to), Byte.valueOf(AV246Conceptos_exportwwds_63_tfconfonnacempcont), Byte.valueOf(AV247Conceptos_exportwwds_64_tfconfonnacempcont_to), Byte.valueOf(AV248Conceptos_exportwwds_65_tfconleyrietrabcont), Byte.valueOf(AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to), Byte.valueOf(AV250Conceptos_exportwwds_67_tfconregdifapo), Byte.valueOf(AV251Conceptos_exportwwds_68_tfconregdifapo_to), Byte.valueOf(AV252Conceptos_exportwwds_69_tfconregespapo), Byte.valueOf(AV253Conceptos_exportwwds_70_tfconregespapo_to), Short.valueOf(AV254Conceptos_exportwwds_71_tfconceptopais), Short.valueOf(AV255Conceptos_exportwwds_72_tfconceptopais_to), lV256Conceptos_exportwwds_73_tfconceptoconvecodigo, Integer.valueOf(AV265Conceptos_exportwwds_82_tfclipadre), Integer.valueOf(AV266Conceptos_exportwwds_83_tfclipadre_to), lV267Conceptos_exportwwds_84_tfconpadre});
      GRID_nRecordCount = H00IB3_AGRID_nRecordCount[0] ;
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
      AV184Conceptos_exportwwds_1_tfclicod = AV24TFCliCod ;
      AV185Conceptos_exportwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV186Conceptos_exportwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV187Conceptos_exportwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV188Conceptos_exportwwds_5_tfcondescrip = AV30TFConDescrip ;
      AV189Conceptos_exportwwds_6_tfcondescrip_sels = AV31TFConDescrip_Sels ;
      AV190Conceptos_exportwwds_7_tfconorden = AV32TFConOrden ;
      AV191Conceptos_exportwwds_8_tfconorden_to = AV33TFConOrden_To ;
      AV192Conceptos_exportwwds_9_tfconliqbasica = AV36TFConLiqBasica ;
      AV193Conceptos_exportwwds_10_tfconliqbasica_to = AV37TFConLiqBasica_To ;
      AV194Conceptos_exportwwds_11_tfconformula = AV39TFConFormula ;
      AV195Conceptos_exportwwds_12_tfconformula_sels = AV40TFConFormula_Sels ;
      AV196Conceptos_exportwwds_13_tfconobservacion = AV42TFConObservacion ;
      AV197Conceptos_exportwwds_14_tfconobservacion_sels = AV43TFConObservacion_Sels ;
      AV198Conceptos_exportwwds_15_tfconvariable_sel = AV44TFConVariable_Sel ;
      AV199Conceptos_exportwwds_16_tfconforeditable_sel = AV45TFConForEditable_Sel ;
      AV200Conceptos_exportwwds_17_tftipoconcod_sels = AV47TFTipoConCod_Sels ;
      AV201Conceptos_exportwwds_18_tfsubtipoconcod1 = AV49TFSubTipoConCod1 ;
      AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels = AV50TFSubTipoConCod1_Sels ;
      AV203Conceptos_exportwwds_20_tfsubtipoconcod2 = AV52TFSubTipoConCod2 ;
      AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels = AV53TFSubTipoConCod2_Sels ;
      AV205Conceptos_exportwwds_22_tfcontipoliqaux = AV55TFConTipoLiqAux ;
      AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels = AV56TFConTipoLiqAux_Sels ;
      AV207Conceptos_exportwwds_24_tfconclasifaux = AV58TFConClasifAux ;
      AV208Conceptos_exportwwds_25_tfconclasifaux_sels = AV59TFConClasifAux_Sels ;
      AV209Conceptos_exportwwds_26_tfconordejec = AV60TFConOrdEjec ;
      AV210Conceptos_exportwwds_27_tfconordejec_to = AV61TFConOrdEjec_To ;
      AV211Conceptos_exportwwds_28_tfconrecalcular_sel = AV65TFConRecalcular_Sel ;
      AV212Conceptos_exportwwds_29_tfconrangocant = AV67TFConRangoCant ;
      AV213Conceptos_exportwwds_30_tfconrangocant_sels = AV68TFConRangoCant_Sels ;
      AV214Conceptos_exportwwds_31_tfconcondicion_sels = AV70TFConCondicion_Sels ;
      AV215Conceptos_exportwwds_32_tfconcondcodigo = AV72TFConCondCodigo ;
      AV216Conceptos_exportwwds_33_tfconcondcodigo_sels = AV73TFConCondCodigo_Sels ;
      AV217Conceptos_exportwwds_34_tfconmostrarpos_sel = AV74TFConMostrarPos_Sel ;
      AV218Conceptos_exportwwds_35_tfconadeldescu_sels = AV76TFConAdelDescu_Sels ;
      AV219Conceptos_exportwwds_36_tfapliigg = AV77TFAplIIGG ;
      AV220Conceptos_exportwwds_37_tfapliigg_to = AV78TFAplIIGG_To ;
      AV221Conceptos_exportwwds_38_tfconsegunpla_sel = AV79TFConSegunPla_Sel ;
      AV222Conceptos_exportwwds_39_tfconcodafip = AV92TFConCodAfip ;
      AV223Conceptos_exportwwds_40_tfconcodafip_sels = AV93TFConCodAfip_Sels ;
      AV224Conceptos_exportwwds_41_tfconsipaapo = AV94TFConSIPAApo ;
      AV225Conceptos_exportwwds_42_tfconsipaapo_to = AV95TFConSIPAApo_To ;
      AV226Conceptos_exportwwds_43_tfconsipacont = AV96TFConSIPACont ;
      AV227Conceptos_exportwwds_44_tfconsipacont_to = AV97TFConSIPACont_To ;
      AV228Conceptos_exportwwds_45_tfconinssjypapo = AV98TFConINSSJyPApo ;
      AV229Conceptos_exportwwds_46_tfconinssjypapo_to = AV99TFConINSSJyPApo_To ;
      AV230Conceptos_exportwwds_47_tfconinssjypcont = AV100TFConINSSJyPCont ;
      AV231Conceptos_exportwwds_48_tfconinssjypcont_to = AV101TFConINSSJyPCont_To ;
      AV232Conceptos_exportwwds_49_tfconobrasocapo = AV102TFConObraSocApo ;
      AV233Conceptos_exportwwds_50_tfconobrasocapo_to = AV103TFConObraSocApo_To ;
      AV234Conceptos_exportwwds_51_tfconobrasoccont = AV104TFConObraSocCont ;
      AV235Conceptos_exportwwds_52_tfconobrasoccont_to = AV105TFConObraSocCont_To ;
      AV236Conceptos_exportwwds_53_tfconfonsolredapo = AV106TFConFonSolRedApo ;
      AV237Conceptos_exportwwds_54_tfconfonsolredapo_to = AV107TFConFonSolRedApo_To ;
      AV238Conceptos_exportwwds_55_tfconfonsolredcont = AV108TFConFonSolRedCont ;
      AV239Conceptos_exportwwds_56_tfconfonsolredcont_to = AV109TFConFonSolRedCont_To ;
      AV240Conceptos_exportwwds_57_tfconrenateaapo = AV110TFConRenateaApo ;
      AV241Conceptos_exportwwds_58_tfconrenateaapo_to = AV111TFConRenateaApo_To ;
      AV242Conceptos_exportwwds_59_tfconrenateacont = AV112TFConRenateaCont ;
      AV243Conceptos_exportwwds_60_tfconrenateacont_to = AV113TFConRenateaCont_To ;
      AV244Conceptos_exportwwds_61_tfconasigfamcont = AV114TFConAsigFamCont ;
      AV245Conceptos_exportwwds_62_tfconasigfamcont_to = AV115TFConAsigFamCont_To ;
      AV246Conceptos_exportwwds_63_tfconfonnacempcont = AV116TFConFonNacEmpCont ;
      AV247Conceptos_exportwwds_64_tfconfonnacempcont_to = AV117TFConFonNacEmpCont_To ;
      AV248Conceptos_exportwwds_65_tfconleyrietrabcont = AV118TFConLeyRieTrabCont ;
      AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to = AV119TFConLeyRieTrabCont_To ;
      AV250Conceptos_exportwwds_67_tfconregdifapo = AV120TFConRegDifApo ;
      AV251Conceptos_exportwwds_68_tfconregdifapo_to = AV121TFConRegDifApo_To ;
      AV252Conceptos_exportwwds_69_tfconregespapo = AV122TFConRegEspApo ;
      AV253Conceptos_exportwwds_70_tfconregespapo_to = AV123TFConRegEspApo_To ;
      AV254Conceptos_exportwwds_71_tfconceptopais = AV126TFConceptoPais ;
      AV255Conceptos_exportwwds_72_tfconceptopais_to = AV127TFConceptoPais_To ;
      AV256Conceptos_exportwwds_73_tfconceptoconvecodigo = AV129TFConceptoConveCodigo ;
      AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels = AV130TFConceptoConveCodigo_Sels ;
      AV258Conceptos_exportwwds_75_tfconbaselicprom_sels = AV138TFConBaseLicProm_Sels ;
      AV259Conceptos_exportwwds_76_tfconbaseferprom_sels = AV140TFConBaseFerProm_Sels ;
      AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels = AV142TFConBaseHorExtProm_Sels ;
      AV261Conceptos_exportwwds_78_tfconbasepres_sels = AV144TFConBasePres_Sels ;
      AV262Conceptos_exportwwds_79_tfconbaseant_sels = AV146TFConBaseAnt_Sels ;
      AV263Conceptos_exportwwds_80_tfconbaseosdif_sels = AV148TFConBaseOSDif_Sels ;
      AV264Conceptos_exportwwds_81_tfconerrorsicero_sel = AV149TFConErrorSiCero_Sel ;
      AV265Conceptos_exportwwds_82_tfclipadre = AV150TFCliPadre ;
      AV266Conceptos_exportwwds_83_tfclipadre_to = AV151TFCliPadre_To ;
      AV267Conceptos_exportwwds_84_tfconpadre = AV153TFConPadre ;
      AV268Conceptos_exportwwds_85_tfconpadre_sels = AV154TFConPadre_Sels ;
      AV269Conceptos_exportwwds_86_tfconpuenov_sel = AV155TFConPueNov_Sel ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV170ManageFiltersExecutionStep, AV21ColumnsSelector, AV183Pgmname, AV159MenuOpcCod, AV12GridState, AV24TFCliCod, AV25TFCliCod_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV30TFConDescrip, AV31TFConDescrip_Sels, AV32TFConOrden, AV33TFConOrden_To, AV36TFConLiqBasica, AV37TFConLiqBasica_To, AV39TFConFormula, AV40TFConFormula_Sels, AV42TFConObservacion, AV43TFConObservacion_Sels, AV44TFConVariable_Sel, AV45TFConForEditable_Sel, AV47TFTipoConCod_Sels, AV49TFSubTipoConCod1, AV50TFSubTipoConCod1_Sels, AV52TFSubTipoConCod2, AV53TFSubTipoConCod2_Sels, AV55TFConTipoLiqAux, AV56TFConTipoLiqAux_Sels, AV58TFConClasifAux, AV59TFConClasifAux_Sels, AV60TFConOrdEjec, AV61TFConOrdEjec_To, AV65TFConRecalcular_Sel, AV67TFConRangoCant, AV68TFConRangoCant_Sels, AV70TFConCondicion_Sels, AV72TFConCondCodigo, AV73TFConCondCodigo_Sels, AV74TFConMostrarPos_Sel, AV76TFConAdelDescu_Sels, AV77TFAplIIGG, AV78TFAplIIGG_To, AV79TFConSegunPla_Sel, AV92TFConCodAfip, AV93TFConCodAfip_Sels, AV94TFConSIPAApo, AV95TFConSIPAApo_To, AV96TFConSIPACont, AV97TFConSIPACont_To, AV98TFConINSSJyPApo, AV99TFConINSSJyPApo_To, AV100TFConINSSJyPCont, AV101TFConINSSJyPCont_To, AV102TFConObraSocApo, AV103TFConObraSocApo_To, AV104TFConObraSocCont, AV105TFConObraSocCont_To, AV106TFConFonSolRedApo, AV107TFConFonSolRedApo_To, AV108TFConFonSolRedCont, AV109TFConFonSolRedCont_To, AV110TFConRenateaApo, AV111TFConRenateaApo_To, AV112TFConRenateaCont, AV113TFConRenateaCont_To, AV114TFConAsigFamCont, AV115TFConAsigFamCont_To, AV116TFConFonNacEmpCont, AV117TFConFonNacEmpCont_To, AV118TFConLeyRieTrabCont, AV119TFConLeyRieTrabCont_To, AV120TFConRegDifApo, AV121TFConRegDifApo_To, AV122TFConRegEspApo, AV123TFConRegEspApo_To, AV126TFConceptoPais, AV127TFConceptoPais_To, AV129TFConceptoConveCodigo, AV130TFConceptoConveCodigo_Sels, AV138TFConBaseLicProm_Sels, AV140TFConBaseFerProm_Sels, AV142TFConBaseHorExtProm_Sels, AV144TFConBasePres_Sels, AV146TFConBaseAnt_Sels, AV148TFConBaseOSDif_Sels, AV149TFConErrorSiCero_Sel, AV150TFCliPadre, AV151TFCliPadre_To, AV153TFConPadre, AV154TFConPadre_Sels, AV155TFConPueNov_Sel, AV14OrderedBy, AV15OrderedDsc, AV87CliCod, AV161WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV184Conceptos_exportwwds_1_tfclicod = AV24TFCliCod ;
      AV185Conceptos_exportwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV186Conceptos_exportwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV187Conceptos_exportwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV188Conceptos_exportwwds_5_tfcondescrip = AV30TFConDescrip ;
      AV189Conceptos_exportwwds_6_tfcondescrip_sels = AV31TFConDescrip_Sels ;
      AV190Conceptos_exportwwds_7_tfconorden = AV32TFConOrden ;
      AV191Conceptos_exportwwds_8_tfconorden_to = AV33TFConOrden_To ;
      AV192Conceptos_exportwwds_9_tfconliqbasica = AV36TFConLiqBasica ;
      AV193Conceptos_exportwwds_10_tfconliqbasica_to = AV37TFConLiqBasica_To ;
      AV194Conceptos_exportwwds_11_tfconformula = AV39TFConFormula ;
      AV195Conceptos_exportwwds_12_tfconformula_sels = AV40TFConFormula_Sels ;
      AV196Conceptos_exportwwds_13_tfconobservacion = AV42TFConObservacion ;
      AV197Conceptos_exportwwds_14_tfconobservacion_sels = AV43TFConObservacion_Sels ;
      AV198Conceptos_exportwwds_15_tfconvariable_sel = AV44TFConVariable_Sel ;
      AV199Conceptos_exportwwds_16_tfconforeditable_sel = AV45TFConForEditable_Sel ;
      AV200Conceptos_exportwwds_17_tftipoconcod_sels = AV47TFTipoConCod_Sels ;
      AV201Conceptos_exportwwds_18_tfsubtipoconcod1 = AV49TFSubTipoConCod1 ;
      AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels = AV50TFSubTipoConCod1_Sels ;
      AV203Conceptos_exportwwds_20_tfsubtipoconcod2 = AV52TFSubTipoConCod2 ;
      AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels = AV53TFSubTipoConCod2_Sels ;
      AV205Conceptos_exportwwds_22_tfcontipoliqaux = AV55TFConTipoLiqAux ;
      AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels = AV56TFConTipoLiqAux_Sels ;
      AV207Conceptos_exportwwds_24_tfconclasifaux = AV58TFConClasifAux ;
      AV208Conceptos_exportwwds_25_tfconclasifaux_sels = AV59TFConClasifAux_Sels ;
      AV209Conceptos_exportwwds_26_tfconordejec = AV60TFConOrdEjec ;
      AV210Conceptos_exportwwds_27_tfconordejec_to = AV61TFConOrdEjec_To ;
      AV211Conceptos_exportwwds_28_tfconrecalcular_sel = AV65TFConRecalcular_Sel ;
      AV212Conceptos_exportwwds_29_tfconrangocant = AV67TFConRangoCant ;
      AV213Conceptos_exportwwds_30_tfconrangocant_sels = AV68TFConRangoCant_Sels ;
      AV214Conceptos_exportwwds_31_tfconcondicion_sels = AV70TFConCondicion_Sels ;
      AV215Conceptos_exportwwds_32_tfconcondcodigo = AV72TFConCondCodigo ;
      AV216Conceptos_exportwwds_33_tfconcondcodigo_sels = AV73TFConCondCodigo_Sels ;
      AV217Conceptos_exportwwds_34_tfconmostrarpos_sel = AV74TFConMostrarPos_Sel ;
      AV218Conceptos_exportwwds_35_tfconadeldescu_sels = AV76TFConAdelDescu_Sels ;
      AV219Conceptos_exportwwds_36_tfapliigg = AV77TFAplIIGG ;
      AV220Conceptos_exportwwds_37_tfapliigg_to = AV78TFAplIIGG_To ;
      AV221Conceptos_exportwwds_38_tfconsegunpla_sel = AV79TFConSegunPla_Sel ;
      AV222Conceptos_exportwwds_39_tfconcodafip = AV92TFConCodAfip ;
      AV223Conceptos_exportwwds_40_tfconcodafip_sels = AV93TFConCodAfip_Sels ;
      AV224Conceptos_exportwwds_41_tfconsipaapo = AV94TFConSIPAApo ;
      AV225Conceptos_exportwwds_42_tfconsipaapo_to = AV95TFConSIPAApo_To ;
      AV226Conceptos_exportwwds_43_tfconsipacont = AV96TFConSIPACont ;
      AV227Conceptos_exportwwds_44_tfconsipacont_to = AV97TFConSIPACont_To ;
      AV228Conceptos_exportwwds_45_tfconinssjypapo = AV98TFConINSSJyPApo ;
      AV229Conceptos_exportwwds_46_tfconinssjypapo_to = AV99TFConINSSJyPApo_To ;
      AV230Conceptos_exportwwds_47_tfconinssjypcont = AV100TFConINSSJyPCont ;
      AV231Conceptos_exportwwds_48_tfconinssjypcont_to = AV101TFConINSSJyPCont_To ;
      AV232Conceptos_exportwwds_49_tfconobrasocapo = AV102TFConObraSocApo ;
      AV233Conceptos_exportwwds_50_tfconobrasocapo_to = AV103TFConObraSocApo_To ;
      AV234Conceptos_exportwwds_51_tfconobrasoccont = AV104TFConObraSocCont ;
      AV235Conceptos_exportwwds_52_tfconobrasoccont_to = AV105TFConObraSocCont_To ;
      AV236Conceptos_exportwwds_53_tfconfonsolredapo = AV106TFConFonSolRedApo ;
      AV237Conceptos_exportwwds_54_tfconfonsolredapo_to = AV107TFConFonSolRedApo_To ;
      AV238Conceptos_exportwwds_55_tfconfonsolredcont = AV108TFConFonSolRedCont ;
      AV239Conceptos_exportwwds_56_tfconfonsolredcont_to = AV109TFConFonSolRedCont_To ;
      AV240Conceptos_exportwwds_57_tfconrenateaapo = AV110TFConRenateaApo ;
      AV241Conceptos_exportwwds_58_tfconrenateaapo_to = AV111TFConRenateaApo_To ;
      AV242Conceptos_exportwwds_59_tfconrenateacont = AV112TFConRenateaCont ;
      AV243Conceptos_exportwwds_60_tfconrenateacont_to = AV113TFConRenateaCont_To ;
      AV244Conceptos_exportwwds_61_tfconasigfamcont = AV114TFConAsigFamCont ;
      AV245Conceptos_exportwwds_62_tfconasigfamcont_to = AV115TFConAsigFamCont_To ;
      AV246Conceptos_exportwwds_63_tfconfonnacempcont = AV116TFConFonNacEmpCont ;
      AV247Conceptos_exportwwds_64_tfconfonnacempcont_to = AV117TFConFonNacEmpCont_To ;
      AV248Conceptos_exportwwds_65_tfconleyrietrabcont = AV118TFConLeyRieTrabCont ;
      AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to = AV119TFConLeyRieTrabCont_To ;
      AV250Conceptos_exportwwds_67_tfconregdifapo = AV120TFConRegDifApo ;
      AV251Conceptos_exportwwds_68_tfconregdifapo_to = AV121TFConRegDifApo_To ;
      AV252Conceptos_exportwwds_69_tfconregespapo = AV122TFConRegEspApo ;
      AV253Conceptos_exportwwds_70_tfconregespapo_to = AV123TFConRegEspApo_To ;
      AV254Conceptos_exportwwds_71_tfconceptopais = AV126TFConceptoPais ;
      AV255Conceptos_exportwwds_72_tfconceptopais_to = AV127TFConceptoPais_To ;
      AV256Conceptos_exportwwds_73_tfconceptoconvecodigo = AV129TFConceptoConveCodigo ;
      AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels = AV130TFConceptoConveCodigo_Sels ;
      AV258Conceptos_exportwwds_75_tfconbaselicprom_sels = AV138TFConBaseLicProm_Sels ;
      AV259Conceptos_exportwwds_76_tfconbaseferprom_sels = AV140TFConBaseFerProm_Sels ;
      AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels = AV142TFConBaseHorExtProm_Sels ;
      AV261Conceptos_exportwwds_78_tfconbasepres_sels = AV144TFConBasePres_Sels ;
      AV262Conceptos_exportwwds_79_tfconbaseant_sels = AV146TFConBaseAnt_Sels ;
      AV263Conceptos_exportwwds_80_tfconbaseosdif_sels = AV148TFConBaseOSDif_Sels ;
      AV264Conceptos_exportwwds_81_tfconerrorsicero_sel = AV149TFConErrorSiCero_Sel ;
      AV265Conceptos_exportwwds_82_tfclipadre = AV150TFCliPadre ;
      AV266Conceptos_exportwwds_83_tfclipadre_to = AV151TFCliPadre_To ;
      AV267Conceptos_exportwwds_84_tfconpadre = AV153TFConPadre ;
      AV268Conceptos_exportwwds_85_tfconpadre_sels = AV154TFConPadre_Sels ;
      AV269Conceptos_exportwwds_86_tfconpuenov_sel = AV155TFConPueNov_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV170ManageFiltersExecutionStep, AV21ColumnsSelector, AV183Pgmname, AV159MenuOpcCod, AV12GridState, AV24TFCliCod, AV25TFCliCod_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV30TFConDescrip, AV31TFConDescrip_Sels, AV32TFConOrden, AV33TFConOrden_To, AV36TFConLiqBasica, AV37TFConLiqBasica_To, AV39TFConFormula, AV40TFConFormula_Sels, AV42TFConObservacion, AV43TFConObservacion_Sels, AV44TFConVariable_Sel, AV45TFConForEditable_Sel, AV47TFTipoConCod_Sels, AV49TFSubTipoConCod1, AV50TFSubTipoConCod1_Sels, AV52TFSubTipoConCod2, AV53TFSubTipoConCod2_Sels, AV55TFConTipoLiqAux, AV56TFConTipoLiqAux_Sels, AV58TFConClasifAux, AV59TFConClasifAux_Sels, AV60TFConOrdEjec, AV61TFConOrdEjec_To, AV65TFConRecalcular_Sel, AV67TFConRangoCant, AV68TFConRangoCant_Sels, AV70TFConCondicion_Sels, AV72TFConCondCodigo, AV73TFConCondCodigo_Sels, AV74TFConMostrarPos_Sel, AV76TFConAdelDescu_Sels, AV77TFAplIIGG, AV78TFAplIIGG_To, AV79TFConSegunPla_Sel, AV92TFConCodAfip, AV93TFConCodAfip_Sels, AV94TFConSIPAApo, AV95TFConSIPAApo_To, AV96TFConSIPACont, AV97TFConSIPACont_To, AV98TFConINSSJyPApo, AV99TFConINSSJyPApo_To, AV100TFConINSSJyPCont, AV101TFConINSSJyPCont_To, AV102TFConObraSocApo, AV103TFConObraSocApo_To, AV104TFConObraSocCont, AV105TFConObraSocCont_To, AV106TFConFonSolRedApo, AV107TFConFonSolRedApo_To, AV108TFConFonSolRedCont, AV109TFConFonSolRedCont_To, AV110TFConRenateaApo, AV111TFConRenateaApo_To, AV112TFConRenateaCont, AV113TFConRenateaCont_To, AV114TFConAsigFamCont, AV115TFConAsigFamCont_To, AV116TFConFonNacEmpCont, AV117TFConFonNacEmpCont_To, AV118TFConLeyRieTrabCont, AV119TFConLeyRieTrabCont_To, AV120TFConRegDifApo, AV121TFConRegDifApo_To, AV122TFConRegEspApo, AV123TFConRegEspApo_To, AV126TFConceptoPais, AV127TFConceptoPais_To, AV129TFConceptoConveCodigo, AV130TFConceptoConveCodigo_Sels, AV138TFConBaseLicProm_Sels, AV140TFConBaseFerProm_Sels, AV142TFConBaseHorExtProm_Sels, AV144TFConBasePres_Sels, AV146TFConBaseAnt_Sels, AV148TFConBaseOSDif_Sels, AV149TFConErrorSiCero_Sel, AV150TFCliPadre, AV151TFCliPadre_To, AV153TFConPadre, AV154TFConPadre_Sels, AV155TFConPueNov_Sel, AV14OrderedBy, AV15OrderedDsc, AV87CliCod, AV161WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV184Conceptos_exportwwds_1_tfclicod = AV24TFCliCod ;
      AV185Conceptos_exportwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV186Conceptos_exportwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV187Conceptos_exportwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV188Conceptos_exportwwds_5_tfcondescrip = AV30TFConDescrip ;
      AV189Conceptos_exportwwds_6_tfcondescrip_sels = AV31TFConDescrip_Sels ;
      AV190Conceptos_exportwwds_7_tfconorden = AV32TFConOrden ;
      AV191Conceptos_exportwwds_8_tfconorden_to = AV33TFConOrden_To ;
      AV192Conceptos_exportwwds_9_tfconliqbasica = AV36TFConLiqBasica ;
      AV193Conceptos_exportwwds_10_tfconliqbasica_to = AV37TFConLiqBasica_To ;
      AV194Conceptos_exportwwds_11_tfconformula = AV39TFConFormula ;
      AV195Conceptos_exportwwds_12_tfconformula_sels = AV40TFConFormula_Sels ;
      AV196Conceptos_exportwwds_13_tfconobservacion = AV42TFConObservacion ;
      AV197Conceptos_exportwwds_14_tfconobservacion_sels = AV43TFConObservacion_Sels ;
      AV198Conceptos_exportwwds_15_tfconvariable_sel = AV44TFConVariable_Sel ;
      AV199Conceptos_exportwwds_16_tfconforeditable_sel = AV45TFConForEditable_Sel ;
      AV200Conceptos_exportwwds_17_tftipoconcod_sels = AV47TFTipoConCod_Sels ;
      AV201Conceptos_exportwwds_18_tfsubtipoconcod1 = AV49TFSubTipoConCod1 ;
      AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels = AV50TFSubTipoConCod1_Sels ;
      AV203Conceptos_exportwwds_20_tfsubtipoconcod2 = AV52TFSubTipoConCod2 ;
      AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels = AV53TFSubTipoConCod2_Sels ;
      AV205Conceptos_exportwwds_22_tfcontipoliqaux = AV55TFConTipoLiqAux ;
      AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels = AV56TFConTipoLiqAux_Sels ;
      AV207Conceptos_exportwwds_24_tfconclasifaux = AV58TFConClasifAux ;
      AV208Conceptos_exportwwds_25_tfconclasifaux_sels = AV59TFConClasifAux_Sels ;
      AV209Conceptos_exportwwds_26_tfconordejec = AV60TFConOrdEjec ;
      AV210Conceptos_exportwwds_27_tfconordejec_to = AV61TFConOrdEjec_To ;
      AV211Conceptos_exportwwds_28_tfconrecalcular_sel = AV65TFConRecalcular_Sel ;
      AV212Conceptos_exportwwds_29_tfconrangocant = AV67TFConRangoCant ;
      AV213Conceptos_exportwwds_30_tfconrangocant_sels = AV68TFConRangoCant_Sels ;
      AV214Conceptos_exportwwds_31_tfconcondicion_sels = AV70TFConCondicion_Sels ;
      AV215Conceptos_exportwwds_32_tfconcondcodigo = AV72TFConCondCodigo ;
      AV216Conceptos_exportwwds_33_tfconcondcodigo_sels = AV73TFConCondCodigo_Sels ;
      AV217Conceptos_exportwwds_34_tfconmostrarpos_sel = AV74TFConMostrarPos_Sel ;
      AV218Conceptos_exportwwds_35_tfconadeldescu_sels = AV76TFConAdelDescu_Sels ;
      AV219Conceptos_exportwwds_36_tfapliigg = AV77TFAplIIGG ;
      AV220Conceptos_exportwwds_37_tfapliigg_to = AV78TFAplIIGG_To ;
      AV221Conceptos_exportwwds_38_tfconsegunpla_sel = AV79TFConSegunPla_Sel ;
      AV222Conceptos_exportwwds_39_tfconcodafip = AV92TFConCodAfip ;
      AV223Conceptos_exportwwds_40_tfconcodafip_sels = AV93TFConCodAfip_Sels ;
      AV224Conceptos_exportwwds_41_tfconsipaapo = AV94TFConSIPAApo ;
      AV225Conceptos_exportwwds_42_tfconsipaapo_to = AV95TFConSIPAApo_To ;
      AV226Conceptos_exportwwds_43_tfconsipacont = AV96TFConSIPACont ;
      AV227Conceptos_exportwwds_44_tfconsipacont_to = AV97TFConSIPACont_To ;
      AV228Conceptos_exportwwds_45_tfconinssjypapo = AV98TFConINSSJyPApo ;
      AV229Conceptos_exportwwds_46_tfconinssjypapo_to = AV99TFConINSSJyPApo_To ;
      AV230Conceptos_exportwwds_47_tfconinssjypcont = AV100TFConINSSJyPCont ;
      AV231Conceptos_exportwwds_48_tfconinssjypcont_to = AV101TFConINSSJyPCont_To ;
      AV232Conceptos_exportwwds_49_tfconobrasocapo = AV102TFConObraSocApo ;
      AV233Conceptos_exportwwds_50_tfconobrasocapo_to = AV103TFConObraSocApo_To ;
      AV234Conceptos_exportwwds_51_tfconobrasoccont = AV104TFConObraSocCont ;
      AV235Conceptos_exportwwds_52_tfconobrasoccont_to = AV105TFConObraSocCont_To ;
      AV236Conceptos_exportwwds_53_tfconfonsolredapo = AV106TFConFonSolRedApo ;
      AV237Conceptos_exportwwds_54_tfconfonsolredapo_to = AV107TFConFonSolRedApo_To ;
      AV238Conceptos_exportwwds_55_tfconfonsolredcont = AV108TFConFonSolRedCont ;
      AV239Conceptos_exportwwds_56_tfconfonsolredcont_to = AV109TFConFonSolRedCont_To ;
      AV240Conceptos_exportwwds_57_tfconrenateaapo = AV110TFConRenateaApo ;
      AV241Conceptos_exportwwds_58_tfconrenateaapo_to = AV111TFConRenateaApo_To ;
      AV242Conceptos_exportwwds_59_tfconrenateacont = AV112TFConRenateaCont ;
      AV243Conceptos_exportwwds_60_tfconrenateacont_to = AV113TFConRenateaCont_To ;
      AV244Conceptos_exportwwds_61_tfconasigfamcont = AV114TFConAsigFamCont ;
      AV245Conceptos_exportwwds_62_tfconasigfamcont_to = AV115TFConAsigFamCont_To ;
      AV246Conceptos_exportwwds_63_tfconfonnacempcont = AV116TFConFonNacEmpCont ;
      AV247Conceptos_exportwwds_64_tfconfonnacempcont_to = AV117TFConFonNacEmpCont_To ;
      AV248Conceptos_exportwwds_65_tfconleyrietrabcont = AV118TFConLeyRieTrabCont ;
      AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to = AV119TFConLeyRieTrabCont_To ;
      AV250Conceptos_exportwwds_67_tfconregdifapo = AV120TFConRegDifApo ;
      AV251Conceptos_exportwwds_68_tfconregdifapo_to = AV121TFConRegDifApo_To ;
      AV252Conceptos_exportwwds_69_tfconregespapo = AV122TFConRegEspApo ;
      AV253Conceptos_exportwwds_70_tfconregespapo_to = AV123TFConRegEspApo_To ;
      AV254Conceptos_exportwwds_71_tfconceptopais = AV126TFConceptoPais ;
      AV255Conceptos_exportwwds_72_tfconceptopais_to = AV127TFConceptoPais_To ;
      AV256Conceptos_exportwwds_73_tfconceptoconvecodigo = AV129TFConceptoConveCodigo ;
      AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels = AV130TFConceptoConveCodigo_Sels ;
      AV258Conceptos_exportwwds_75_tfconbaselicprom_sels = AV138TFConBaseLicProm_Sels ;
      AV259Conceptos_exportwwds_76_tfconbaseferprom_sels = AV140TFConBaseFerProm_Sels ;
      AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels = AV142TFConBaseHorExtProm_Sels ;
      AV261Conceptos_exportwwds_78_tfconbasepres_sels = AV144TFConBasePres_Sels ;
      AV262Conceptos_exportwwds_79_tfconbaseant_sels = AV146TFConBaseAnt_Sels ;
      AV263Conceptos_exportwwds_80_tfconbaseosdif_sels = AV148TFConBaseOSDif_Sels ;
      AV264Conceptos_exportwwds_81_tfconerrorsicero_sel = AV149TFConErrorSiCero_Sel ;
      AV265Conceptos_exportwwds_82_tfclipadre = AV150TFCliPadre ;
      AV266Conceptos_exportwwds_83_tfclipadre_to = AV151TFCliPadre_To ;
      AV267Conceptos_exportwwds_84_tfconpadre = AV153TFConPadre ;
      AV268Conceptos_exportwwds_85_tfconpadre_sels = AV154TFConPadre_Sels ;
      AV269Conceptos_exportwwds_86_tfconpuenov_sel = AV155TFConPueNov_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV170ManageFiltersExecutionStep, AV21ColumnsSelector, AV183Pgmname, AV159MenuOpcCod, AV12GridState, AV24TFCliCod, AV25TFCliCod_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV30TFConDescrip, AV31TFConDescrip_Sels, AV32TFConOrden, AV33TFConOrden_To, AV36TFConLiqBasica, AV37TFConLiqBasica_To, AV39TFConFormula, AV40TFConFormula_Sels, AV42TFConObservacion, AV43TFConObservacion_Sels, AV44TFConVariable_Sel, AV45TFConForEditable_Sel, AV47TFTipoConCod_Sels, AV49TFSubTipoConCod1, AV50TFSubTipoConCod1_Sels, AV52TFSubTipoConCod2, AV53TFSubTipoConCod2_Sels, AV55TFConTipoLiqAux, AV56TFConTipoLiqAux_Sels, AV58TFConClasifAux, AV59TFConClasifAux_Sels, AV60TFConOrdEjec, AV61TFConOrdEjec_To, AV65TFConRecalcular_Sel, AV67TFConRangoCant, AV68TFConRangoCant_Sels, AV70TFConCondicion_Sels, AV72TFConCondCodigo, AV73TFConCondCodigo_Sels, AV74TFConMostrarPos_Sel, AV76TFConAdelDescu_Sels, AV77TFAplIIGG, AV78TFAplIIGG_To, AV79TFConSegunPla_Sel, AV92TFConCodAfip, AV93TFConCodAfip_Sels, AV94TFConSIPAApo, AV95TFConSIPAApo_To, AV96TFConSIPACont, AV97TFConSIPACont_To, AV98TFConINSSJyPApo, AV99TFConINSSJyPApo_To, AV100TFConINSSJyPCont, AV101TFConINSSJyPCont_To, AV102TFConObraSocApo, AV103TFConObraSocApo_To, AV104TFConObraSocCont, AV105TFConObraSocCont_To, AV106TFConFonSolRedApo, AV107TFConFonSolRedApo_To, AV108TFConFonSolRedCont, AV109TFConFonSolRedCont_To, AV110TFConRenateaApo, AV111TFConRenateaApo_To, AV112TFConRenateaCont, AV113TFConRenateaCont_To, AV114TFConAsigFamCont, AV115TFConAsigFamCont_To, AV116TFConFonNacEmpCont, AV117TFConFonNacEmpCont_To, AV118TFConLeyRieTrabCont, AV119TFConLeyRieTrabCont_To, AV120TFConRegDifApo, AV121TFConRegDifApo_To, AV122TFConRegEspApo, AV123TFConRegEspApo_To, AV126TFConceptoPais, AV127TFConceptoPais_To, AV129TFConceptoConveCodigo, AV130TFConceptoConveCodigo_Sels, AV138TFConBaseLicProm_Sels, AV140TFConBaseFerProm_Sels, AV142TFConBaseHorExtProm_Sels, AV144TFConBasePres_Sels, AV146TFConBaseAnt_Sels, AV148TFConBaseOSDif_Sels, AV149TFConErrorSiCero_Sel, AV150TFCliPadre, AV151TFCliPadre_To, AV153TFConPadre, AV154TFConPadre_Sels, AV155TFConPueNov_Sel, AV14OrderedBy, AV15OrderedDsc, AV87CliCod, AV161WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV184Conceptos_exportwwds_1_tfclicod = AV24TFCliCod ;
      AV185Conceptos_exportwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV186Conceptos_exportwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV187Conceptos_exportwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV188Conceptos_exportwwds_5_tfcondescrip = AV30TFConDescrip ;
      AV189Conceptos_exportwwds_6_tfcondescrip_sels = AV31TFConDescrip_Sels ;
      AV190Conceptos_exportwwds_7_tfconorden = AV32TFConOrden ;
      AV191Conceptos_exportwwds_8_tfconorden_to = AV33TFConOrden_To ;
      AV192Conceptos_exportwwds_9_tfconliqbasica = AV36TFConLiqBasica ;
      AV193Conceptos_exportwwds_10_tfconliqbasica_to = AV37TFConLiqBasica_To ;
      AV194Conceptos_exportwwds_11_tfconformula = AV39TFConFormula ;
      AV195Conceptos_exportwwds_12_tfconformula_sels = AV40TFConFormula_Sels ;
      AV196Conceptos_exportwwds_13_tfconobservacion = AV42TFConObservacion ;
      AV197Conceptos_exportwwds_14_tfconobservacion_sels = AV43TFConObservacion_Sels ;
      AV198Conceptos_exportwwds_15_tfconvariable_sel = AV44TFConVariable_Sel ;
      AV199Conceptos_exportwwds_16_tfconforeditable_sel = AV45TFConForEditable_Sel ;
      AV200Conceptos_exportwwds_17_tftipoconcod_sels = AV47TFTipoConCod_Sels ;
      AV201Conceptos_exportwwds_18_tfsubtipoconcod1 = AV49TFSubTipoConCod1 ;
      AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels = AV50TFSubTipoConCod1_Sels ;
      AV203Conceptos_exportwwds_20_tfsubtipoconcod2 = AV52TFSubTipoConCod2 ;
      AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels = AV53TFSubTipoConCod2_Sels ;
      AV205Conceptos_exportwwds_22_tfcontipoliqaux = AV55TFConTipoLiqAux ;
      AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels = AV56TFConTipoLiqAux_Sels ;
      AV207Conceptos_exportwwds_24_tfconclasifaux = AV58TFConClasifAux ;
      AV208Conceptos_exportwwds_25_tfconclasifaux_sels = AV59TFConClasifAux_Sels ;
      AV209Conceptos_exportwwds_26_tfconordejec = AV60TFConOrdEjec ;
      AV210Conceptos_exportwwds_27_tfconordejec_to = AV61TFConOrdEjec_To ;
      AV211Conceptos_exportwwds_28_tfconrecalcular_sel = AV65TFConRecalcular_Sel ;
      AV212Conceptos_exportwwds_29_tfconrangocant = AV67TFConRangoCant ;
      AV213Conceptos_exportwwds_30_tfconrangocant_sels = AV68TFConRangoCant_Sels ;
      AV214Conceptos_exportwwds_31_tfconcondicion_sels = AV70TFConCondicion_Sels ;
      AV215Conceptos_exportwwds_32_tfconcondcodigo = AV72TFConCondCodigo ;
      AV216Conceptos_exportwwds_33_tfconcondcodigo_sels = AV73TFConCondCodigo_Sels ;
      AV217Conceptos_exportwwds_34_tfconmostrarpos_sel = AV74TFConMostrarPos_Sel ;
      AV218Conceptos_exportwwds_35_tfconadeldescu_sels = AV76TFConAdelDescu_Sels ;
      AV219Conceptos_exportwwds_36_tfapliigg = AV77TFAplIIGG ;
      AV220Conceptos_exportwwds_37_tfapliigg_to = AV78TFAplIIGG_To ;
      AV221Conceptos_exportwwds_38_tfconsegunpla_sel = AV79TFConSegunPla_Sel ;
      AV222Conceptos_exportwwds_39_tfconcodafip = AV92TFConCodAfip ;
      AV223Conceptos_exportwwds_40_tfconcodafip_sels = AV93TFConCodAfip_Sels ;
      AV224Conceptos_exportwwds_41_tfconsipaapo = AV94TFConSIPAApo ;
      AV225Conceptos_exportwwds_42_tfconsipaapo_to = AV95TFConSIPAApo_To ;
      AV226Conceptos_exportwwds_43_tfconsipacont = AV96TFConSIPACont ;
      AV227Conceptos_exportwwds_44_tfconsipacont_to = AV97TFConSIPACont_To ;
      AV228Conceptos_exportwwds_45_tfconinssjypapo = AV98TFConINSSJyPApo ;
      AV229Conceptos_exportwwds_46_tfconinssjypapo_to = AV99TFConINSSJyPApo_To ;
      AV230Conceptos_exportwwds_47_tfconinssjypcont = AV100TFConINSSJyPCont ;
      AV231Conceptos_exportwwds_48_tfconinssjypcont_to = AV101TFConINSSJyPCont_To ;
      AV232Conceptos_exportwwds_49_tfconobrasocapo = AV102TFConObraSocApo ;
      AV233Conceptos_exportwwds_50_tfconobrasocapo_to = AV103TFConObraSocApo_To ;
      AV234Conceptos_exportwwds_51_tfconobrasoccont = AV104TFConObraSocCont ;
      AV235Conceptos_exportwwds_52_tfconobrasoccont_to = AV105TFConObraSocCont_To ;
      AV236Conceptos_exportwwds_53_tfconfonsolredapo = AV106TFConFonSolRedApo ;
      AV237Conceptos_exportwwds_54_tfconfonsolredapo_to = AV107TFConFonSolRedApo_To ;
      AV238Conceptos_exportwwds_55_tfconfonsolredcont = AV108TFConFonSolRedCont ;
      AV239Conceptos_exportwwds_56_tfconfonsolredcont_to = AV109TFConFonSolRedCont_To ;
      AV240Conceptos_exportwwds_57_tfconrenateaapo = AV110TFConRenateaApo ;
      AV241Conceptos_exportwwds_58_tfconrenateaapo_to = AV111TFConRenateaApo_To ;
      AV242Conceptos_exportwwds_59_tfconrenateacont = AV112TFConRenateaCont ;
      AV243Conceptos_exportwwds_60_tfconrenateacont_to = AV113TFConRenateaCont_To ;
      AV244Conceptos_exportwwds_61_tfconasigfamcont = AV114TFConAsigFamCont ;
      AV245Conceptos_exportwwds_62_tfconasigfamcont_to = AV115TFConAsigFamCont_To ;
      AV246Conceptos_exportwwds_63_tfconfonnacempcont = AV116TFConFonNacEmpCont ;
      AV247Conceptos_exportwwds_64_tfconfonnacempcont_to = AV117TFConFonNacEmpCont_To ;
      AV248Conceptos_exportwwds_65_tfconleyrietrabcont = AV118TFConLeyRieTrabCont ;
      AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to = AV119TFConLeyRieTrabCont_To ;
      AV250Conceptos_exportwwds_67_tfconregdifapo = AV120TFConRegDifApo ;
      AV251Conceptos_exportwwds_68_tfconregdifapo_to = AV121TFConRegDifApo_To ;
      AV252Conceptos_exportwwds_69_tfconregespapo = AV122TFConRegEspApo ;
      AV253Conceptos_exportwwds_70_tfconregespapo_to = AV123TFConRegEspApo_To ;
      AV254Conceptos_exportwwds_71_tfconceptopais = AV126TFConceptoPais ;
      AV255Conceptos_exportwwds_72_tfconceptopais_to = AV127TFConceptoPais_To ;
      AV256Conceptos_exportwwds_73_tfconceptoconvecodigo = AV129TFConceptoConveCodigo ;
      AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels = AV130TFConceptoConveCodigo_Sels ;
      AV258Conceptos_exportwwds_75_tfconbaselicprom_sels = AV138TFConBaseLicProm_Sels ;
      AV259Conceptos_exportwwds_76_tfconbaseferprom_sels = AV140TFConBaseFerProm_Sels ;
      AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels = AV142TFConBaseHorExtProm_Sels ;
      AV261Conceptos_exportwwds_78_tfconbasepres_sels = AV144TFConBasePres_Sels ;
      AV262Conceptos_exportwwds_79_tfconbaseant_sels = AV146TFConBaseAnt_Sels ;
      AV263Conceptos_exportwwds_80_tfconbaseosdif_sels = AV148TFConBaseOSDif_Sels ;
      AV264Conceptos_exportwwds_81_tfconerrorsicero_sel = AV149TFConErrorSiCero_Sel ;
      AV265Conceptos_exportwwds_82_tfclipadre = AV150TFCliPadre ;
      AV266Conceptos_exportwwds_83_tfclipadre_to = AV151TFCliPadre_To ;
      AV267Conceptos_exportwwds_84_tfconpadre = AV153TFConPadre ;
      AV268Conceptos_exportwwds_85_tfconpadre_sels = AV154TFConPadre_Sels ;
      AV269Conceptos_exportwwds_86_tfconpuenov_sel = AV155TFConPueNov_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV170ManageFiltersExecutionStep, AV21ColumnsSelector, AV183Pgmname, AV159MenuOpcCod, AV12GridState, AV24TFCliCod, AV25TFCliCod_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV30TFConDescrip, AV31TFConDescrip_Sels, AV32TFConOrden, AV33TFConOrden_To, AV36TFConLiqBasica, AV37TFConLiqBasica_To, AV39TFConFormula, AV40TFConFormula_Sels, AV42TFConObservacion, AV43TFConObservacion_Sels, AV44TFConVariable_Sel, AV45TFConForEditable_Sel, AV47TFTipoConCod_Sels, AV49TFSubTipoConCod1, AV50TFSubTipoConCod1_Sels, AV52TFSubTipoConCod2, AV53TFSubTipoConCod2_Sels, AV55TFConTipoLiqAux, AV56TFConTipoLiqAux_Sels, AV58TFConClasifAux, AV59TFConClasifAux_Sels, AV60TFConOrdEjec, AV61TFConOrdEjec_To, AV65TFConRecalcular_Sel, AV67TFConRangoCant, AV68TFConRangoCant_Sels, AV70TFConCondicion_Sels, AV72TFConCondCodigo, AV73TFConCondCodigo_Sels, AV74TFConMostrarPos_Sel, AV76TFConAdelDescu_Sels, AV77TFAplIIGG, AV78TFAplIIGG_To, AV79TFConSegunPla_Sel, AV92TFConCodAfip, AV93TFConCodAfip_Sels, AV94TFConSIPAApo, AV95TFConSIPAApo_To, AV96TFConSIPACont, AV97TFConSIPACont_To, AV98TFConINSSJyPApo, AV99TFConINSSJyPApo_To, AV100TFConINSSJyPCont, AV101TFConINSSJyPCont_To, AV102TFConObraSocApo, AV103TFConObraSocApo_To, AV104TFConObraSocCont, AV105TFConObraSocCont_To, AV106TFConFonSolRedApo, AV107TFConFonSolRedApo_To, AV108TFConFonSolRedCont, AV109TFConFonSolRedCont_To, AV110TFConRenateaApo, AV111TFConRenateaApo_To, AV112TFConRenateaCont, AV113TFConRenateaCont_To, AV114TFConAsigFamCont, AV115TFConAsigFamCont_To, AV116TFConFonNacEmpCont, AV117TFConFonNacEmpCont_To, AV118TFConLeyRieTrabCont, AV119TFConLeyRieTrabCont_To, AV120TFConRegDifApo, AV121TFConRegDifApo_To, AV122TFConRegEspApo, AV123TFConRegEspApo_To, AV126TFConceptoPais, AV127TFConceptoPais_To, AV129TFConceptoConveCodigo, AV130TFConceptoConveCodigo_Sels, AV138TFConBaseLicProm_Sels, AV140TFConBaseFerProm_Sels, AV142TFConBaseHorExtProm_Sels, AV144TFConBasePres_Sels, AV146TFConBaseAnt_Sels, AV148TFConBaseOSDif_Sels, AV149TFConErrorSiCero_Sel, AV150TFCliPadre, AV151TFCliPadre_To, AV153TFConPadre, AV154TFConPadre_Sels, AV155TFConPueNov_Sel, AV14OrderedBy, AV15OrderedDsc, AV87CliCod, AV161WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV184Conceptos_exportwwds_1_tfclicod = AV24TFCliCod ;
      AV185Conceptos_exportwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV186Conceptos_exportwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV187Conceptos_exportwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV188Conceptos_exportwwds_5_tfcondescrip = AV30TFConDescrip ;
      AV189Conceptos_exportwwds_6_tfcondescrip_sels = AV31TFConDescrip_Sels ;
      AV190Conceptos_exportwwds_7_tfconorden = AV32TFConOrden ;
      AV191Conceptos_exportwwds_8_tfconorden_to = AV33TFConOrden_To ;
      AV192Conceptos_exportwwds_9_tfconliqbasica = AV36TFConLiqBasica ;
      AV193Conceptos_exportwwds_10_tfconliqbasica_to = AV37TFConLiqBasica_To ;
      AV194Conceptos_exportwwds_11_tfconformula = AV39TFConFormula ;
      AV195Conceptos_exportwwds_12_tfconformula_sels = AV40TFConFormula_Sels ;
      AV196Conceptos_exportwwds_13_tfconobservacion = AV42TFConObservacion ;
      AV197Conceptos_exportwwds_14_tfconobservacion_sels = AV43TFConObservacion_Sels ;
      AV198Conceptos_exportwwds_15_tfconvariable_sel = AV44TFConVariable_Sel ;
      AV199Conceptos_exportwwds_16_tfconforeditable_sel = AV45TFConForEditable_Sel ;
      AV200Conceptos_exportwwds_17_tftipoconcod_sels = AV47TFTipoConCod_Sels ;
      AV201Conceptos_exportwwds_18_tfsubtipoconcod1 = AV49TFSubTipoConCod1 ;
      AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels = AV50TFSubTipoConCod1_Sels ;
      AV203Conceptos_exportwwds_20_tfsubtipoconcod2 = AV52TFSubTipoConCod2 ;
      AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels = AV53TFSubTipoConCod2_Sels ;
      AV205Conceptos_exportwwds_22_tfcontipoliqaux = AV55TFConTipoLiqAux ;
      AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels = AV56TFConTipoLiqAux_Sels ;
      AV207Conceptos_exportwwds_24_tfconclasifaux = AV58TFConClasifAux ;
      AV208Conceptos_exportwwds_25_tfconclasifaux_sels = AV59TFConClasifAux_Sels ;
      AV209Conceptos_exportwwds_26_tfconordejec = AV60TFConOrdEjec ;
      AV210Conceptos_exportwwds_27_tfconordejec_to = AV61TFConOrdEjec_To ;
      AV211Conceptos_exportwwds_28_tfconrecalcular_sel = AV65TFConRecalcular_Sel ;
      AV212Conceptos_exportwwds_29_tfconrangocant = AV67TFConRangoCant ;
      AV213Conceptos_exportwwds_30_tfconrangocant_sels = AV68TFConRangoCant_Sels ;
      AV214Conceptos_exportwwds_31_tfconcondicion_sels = AV70TFConCondicion_Sels ;
      AV215Conceptos_exportwwds_32_tfconcondcodigo = AV72TFConCondCodigo ;
      AV216Conceptos_exportwwds_33_tfconcondcodigo_sels = AV73TFConCondCodigo_Sels ;
      AV217Conceptos_exportwwds_34_tfconmostrarpos_sel = AV74TFConMostrarPos_Sel ;
      AV218Conceptos_exportwwds_35_tfconadeldescu_sels = AV76TFConAdelDescu_Sels ;
      AV219Conceptos_exportwwds_36_tfapliigg = AV77TFAplIIGG ;
      AV220Conceptos_exportwwds_37_tfapliigg_to = AV78TFAplIIGG_To ;
      AV221Conceptos_exportwwds_38_tfconsegunpla_sel = AV79TFConSegunPla_Sel ;
      AV222Conceptos_exportwwds_39_tfconcodafip = AV92TFConCodAfip ;
      AV223Conceptos_exportwwds_40_tfconcodafip_sels = AV93TFConCodAfip_Sels ;
      AV224Conceptos_exportwwds_41_tfconsipaapo = AV94TFConSIPAApo ;
      AV225Conceptos_exportwwds_42_tfconsipaapo_to = AV95TFConSIPAApo_To ;
      AV226Conceptos_exportwwds_43_tfconsipacont = AV96TFConSIPACont ;
      AV227Conceptos_exportwwds_44_tfconsipacont_to = AV97TFConSIPACont_To ;
      AV228Conceptos_exportwwds_45_tfconinssjypapo = AV98TFConINSSJyPApo ;
      AV229Conceptos_exportwwds_46_tfconinssjypapo_to = AV99TFConINSSJyPApo_To ;
      AV230Conceptos_exportwwds_47_tfconinssjypcont = AV100TFConINSSJyPCont ;
      AV231Conceptos_exportwwds_48_tfconinssjypcont_to = AV101TFConINSSJyPCont_To ;
      AV232Conceptos_exportwwds_49_tfconobrasocapo = AV102TFConObraSocApo ;
      AV233Conceptos_exportwwds_50_tfconobrasocapo_to = AV103TFConObraSocApo_To ;
      AV234Conceptos_exportwwds_51_tfconobrasoccont = AV104TFConObraSocCont ;
      AV235Conceptos_exportwwds_52_tfconobrasoccont_to = AV105TFConObraSocCont_To ;
      AV236Conceptos_exportwwds_53_tfconfonsolredapo = AV106TFConFonSolRedApo ;
      AV237Conceptos_exportwwds_54_tfconfonsolredapo_to = AV107TFConFonSolRedApo_To ;
      AV238Conceptos_exportwwds_55_tfconfonsolredcont = AV108TFConFonSolRedCont ;
      AV239Conceptos_exportwwds_56_tfconfonsolredcont_to = AV109TFConFonSolRedCont_To ;
      AV240Conceptos_exportwwds_57_tfconrenateaapo = AV110TFConRenateaApo ;
      AV241Conceptos_exportwwds_58_tfconrenateaapo_to = AV111TFConRenateaApo_To ;
      AV242Conceptos_exportwwds_59_tfconrenateacont = AV112TFConRenateaCont ;
      AV243Conceptos_exportwwds_60_tfconrenateacont_to = AV113TFConRenateaCont_To ;
      AV244Conceptos_exportwwds_61_tfconasigfamcont = AV114TFConAsigFamCont ;
      AV245Conceptos_exportwwds_62_tfconasigfamcont_to = AV115TFConAsigFamCont_To ;
      AV246Conceptos_exportwwds_63_tfconfonnacempcont = AV116TFConFonNacEmpCont ;
      AV247Conceptos_exportwwds_64_tfconfonnacempcont_to = AV117TFConFonNacEmpCont_To ;
      AV248Conceptos_exportwwds_65_tfconleyrietrabcont = AV118TFConLeyRieTrabCont ;
      AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to = AV119TFConLeyRieTrabCont_To ;
      AV250Conceptos_exportwwds_67_tfconregdifapo = AV120TFConRegDifApo ;
      AV251Conceptos_exportwwds_68_tfconregdifapo_to = AV121TFConRegDifApo_To ;
      AV252Conceptos_exportwwds_69_tfconregespapo = AV122TFConRegEspApo ;
      AV253Conceptos_exportwwds_70_tfconregespapo_to = AV123TFConRegEspApo_To ;
      AV254Conceptos_exportwwds_71_tfconceptopais = AV126TFConceptoPais ;
      AV255Conceptos_exportwwds_72_tfconceptopais_to = AV127TFConceptoPais_To ;
      AV256Conceptos_exportwwds_73_tfconceptoconvecodigo = AV129TFConceptoConveCodigo ;
      AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels = AV130TFConceptoConveCodigo_Sels ;
      AV258Conceptos_exportwwds_75_tfconbaselicprom_sels = AV138TFConBaseLicProm_Sels ;
      AV259Conceptos_exportwwds_76_tfconbaseferprom_sels = AV140TFConBaseFerProm_Sels ;
      AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels = AV142TFConBaseHorExtProm_Sels ;
      AV261Conceptos_exportwwds_78_tfconbasepres_sels = AV144TFConBasePres_Sels ;
      AV262Conceptos_exportwwds_79_tfconbaseant_sels = AV146TFConBaseAnt_Sels ;
      AV263Conceptos_exportwwds_80_tfconbaseosdif_sels = AV148TFConBaseOSDif_Sels ;
      AV264Conceptos_exportwwds_81_tfconerrorsicero_sel = AV149TFConErrorSiCero_Sel ;
      AV265Conceptos_exportwwds_82_tfclipadre = AV150TFCliPadre ;
      AV266Conceptos_exportwwds_83_tfclipadre_to = AV151TFCliPadre_To ;
      AV267Conceptos_exportwwds_84_tfconpadre = AV153TFConPadre ;
      AV268Conceptos_exportwwds_85_tfconpadre_sels = AV154TFConPadre_Sels ;
      AV269Conceptos_exportwwds_86_tfconpuenov_sel = AV155TFConPueNov_Sel ;
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
         gxgrgrid_refresh( subGrid_Rows, AV170ManageFiltersExecutionStep, AV21ColumnsSelector, AV183Pgmname, AV159MenuOpcCod, AV12GridState, AV24TFCliCod, AV25TFCliCod_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV30TFConDescrip, AV31TFConDescrip_Sels, AV32TFConOrden, AV33TFConOrden_To, AV36TFConLiqBasica, AV37TFConLiqBasica_To, AV39TFConFormula, AV40TFConFormula_Sels, AV42TFConObservacion, AV43TFConObservacion_Sels, AV44TFConVariable_Sel, AV45TFConForEditable_Sel, AV47TFTipoConCod_Sels, AV49TFSubTipoConCod1, AV50TFSubTipoConCod1_Sels, AV52TFSubTipoConCod2, AV53TFSubTipoConCod2_Sels, AV55TFConTipoLiqAux, AV56TFConTipoLiqAux_Sels, AV58TFConClasifAux, AV59TFConClasifAux_Sels, AV60TFConOrdEjec, AV61TFConOrdEjec_To, AV65TFConRecalcular_Sel, AV67TFConRangoCant, AV68TFConRangoCant_Sels, AV70TFConCondicion_Sels, AV72TFConCondCodigo, AV73TFConCondCodigo_Sels, AV74TFConMostrarPos_Sel, AV76TFConAdelDescu_Sels, AV77TFAplIIGG, AV78TFAplIIGG_To, AV79TFConSegunPla_Sel, AV92TFConCodAfip, AV93TFConCodAfip_Sels, AV94TFConSIPAApo, AV95TFConSIPAApo_To, AV96TFConSIPACont, AV97TFConSIPACont_To, AV98TFConINSSJyPApo, AV99TFConINSSJyPApo_To, AV100TFConINSSJyPCont, AV101TFConINSSJyPCont_To, AV102TFConObraSocApo, AV103TFConObraSocApo_To, AV104TFConObraSocCont, AV105TFConObraSocCont_To, AV106TFConFonSolRedApo, AV107TFConFonSolRedApo_To, AV108TFConFonSolRedCont, AV109TFConFonSolRedCont_To, AV110TFConRenateaApo, AV111TFConRenateaApo_To, AV112TFConRenateaCont, AV113TFConRenateaCont_To, AV114TFConAsigFamCont, AV115TFConAsigFamCont_To, AV116TFConFonNacEmpCont, AV117TFConFonNacEmpCont_To, AV118TFConLeyRieTrabCont, AV119TFConLeyRieTrabCont_To, AV120TFConRegDifApo, AV121TFConRegDifApo_To, AV122TFConRegEspApo, AV123TFConRegEspApo_To, AV126TFConceptoPais, AV127TFConceptoPais_To, AV129TFConceptoConveCodigo, AV130TFConceptoConveCodigo_Sels, AV138TFConBaseLicProm_Sels, AV140TFConBaseFerProm_Sels, AV142TFConBaseHorExtProm_Sels, AV144TFConBasePres_Sels, AV146TFConBaseAnt_Sels, AV148TFConBaseOSDif_Sels, AV149TFConErrorSiCero_Sel, AV150TFCliPadre, AV151TFCliPadre_To, AV153TFConPadre, AV154TFConPadre_Sels, AV155TFConPueNov_Sel, AV14OrderedBy, AV15OrderedDsc, AV87CliCod, AV161WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV183Pgmname = "Conceptos_exportWW" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupIB0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e21IB2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV80DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV168ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_110 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_110"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV82GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV83GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV84GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV159MenuOpcCod = httpContext.cgiGet( "vMENUOPCCOD") ;
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
         AV167WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV161WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV161WelcomeMessage_NoMostrarMas", AV161WelcomeMessage_NoMostrarMas);
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
      e21IB2 ();
      if (returnInSub) return;
   }

   public void e21IB2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV159MenuOpcCod, "", "") ;
      GXt_int1 = AV87CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptos_exportww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV87CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV87CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV87CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV87CliCod), "ZZZZZ9")));
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
      Form.setCaption( httpContext.getMessage( " Conceptos_export", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV80DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV80DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV162MenuBienveImgURL ;
      GXv_char6[0] = AV164MenuBienveTitulo ;
      GXv_char7[0] = AV165MenuBienveTexto ;
      GXv_boolean8[0] = AV166MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV159MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      conceptos_exportww_impl.this.AV162MenuBienveImgURL = GXv_char5[0] ;
      conceptos_exportww_impl.this.AV164MenuBienveTitulo = GXv_char6[0] ;
      conceptos_exportww_impl.this.AV165MenuBienveTexto = GXv_char7[0] ;
      conceptos_exportww_impl.this.AV166MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV166MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV166MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV164MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV165MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV167WelcomeMessage_Foto = AV162MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV167WelcomeMessage_Foto)==0) ? AV182Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV167WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV167WelcomeMessage_Foto), true);
         AV182Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV162MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV167WelcomeMessage_Foto)==0) ? AV182Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV167WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV167WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      conceptos_exportww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      conceptos_exportww_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV179observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV179observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV179observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV179observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
   }

   public void e22IB2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV87CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptos_exportww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV87CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV87CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV87CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV87CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext11[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext11) ;
      AV6WWPContext = GXv_SdtWWPContext11[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV170ManageFiltersExecutionStep == 1 )
      {
         AV170ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV170ManageFiltersExecutionStep", GXutil.str( AV170ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV170ManageFiltersExecutionStep == 2 )
      {
         AV170ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV170ManageFiltersExecutionStep", GXutil.str( AV170ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV23Session.getValue("Conceptos_exportWWColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("Conceptos_exportWWColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtCliCod_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConCodigo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConDescrip_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConOrden_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConOrden_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConOrden_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbConVigencia.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConVigencia.getInternalname(), "Visible", GXutil.ltrimstr( cmbConVigencia.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtConLiqBasica_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConLiqBasica_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConLiqBasica_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConFormula_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFormula_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFormula_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConObservacion_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConObservacion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConObservacion_Visible), 5, 0), !bGXsfl_110_Refreshing);
      chkConVariable.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "Visible", GXutil.ltrimstr( chkConVariable.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      chkConForEditable.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConForEditable.getInternalname(), "Visible", GXutil.ltrimstr( chkConForEditable.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      cmbTipoConCod.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Visible", GXutil.ltrimstr( cmbTipoConCod.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtSubTipoConCod1_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod1_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtSubTipoConCod2_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod2_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConTipoLiqAux_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConTipoLiqAux_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConTipoLiqAux_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConClasifAux_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConClasifAux_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConClasifAux_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConOrdEjec_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConOrdEjec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConOrdEjec_Visible), 5, 0), !bGXsfl_110_Refreshing);
      chkConRecalcular.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConRecalcular.getInternalname(), "Visible", GXutil.ltrimstr( chkConRecalcular.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtConRangoCant_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRangoCant_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRangoCant_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbConCondicion.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Visible", GXutil.ltrimstr( cmbConCondicion.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtConCondCodigo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCondCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCondCodigo_Visible), 5, 0), !bGXsfl_110_Refreshing);
      chkConMostrarPos.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+21)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConMostrarPos.getInternalname(), "Visible", GXutil.ltrimstr( chkConMostrarPos.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      cmbConAdelDescu.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+22)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAdelDescu.getInternalname(), "Visible", GXutil.ltrimstr( cmbConAdelDescu.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtAplIIGG_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+23)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGG_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGG_Visible), 5, 0), !bGXsfl_110_Refreshing);
      chkConSegunPla.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+24)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConSegunPla.getInternalname(), "Visible", GXutil.ltrimstr( chkConSegunPla.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+25)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConCodAfip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+26)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodAfip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodAfip_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConSIPAApo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+27)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConSIPAApo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConSIPAApo_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConSIPACont_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+28)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConSIPACont_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConSIPACont_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConINSSJyPApo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+29)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConINSSJyPApo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConINSSJyPApo_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConINSSJyPCont_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+30)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConINSSJyPCont_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConINSSJyPCont_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConObraSocApo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+31)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConObraSocApo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConObraSocApo_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConObraSocCont_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+32)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConObraSocCont_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConObraSocCont_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConFonSolRedApo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+33)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFonSolRedApo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFonSolRedApo_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConFonSolRedCont_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+34)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFonSolRedCont_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFonSolRedCont_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConRenateaApo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+35)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRenateaApo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRenateaApo_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConRenateaCont_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+36)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRenateaCont_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRenateaCont_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConAsigFamCont_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+37)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConAsigFamCont_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConAsigFamCont_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConFonNacEmpCont_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+38)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFonNacEmpCont_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFonNacEmpCont_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConLeyRieTrabCont_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+39)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConLeyRieTrabCont_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConLeyRieTrabCont_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConRegDifApo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+40)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRegDifApo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRegDifApo_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConRegEspApo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+41)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRegEspApo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRegEspApo_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbConSacDeven.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+42)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConSacDeven.getInternalname(), "Visible", GXutil.ltrimstr( cmbConSacDeven.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtConceptoPais_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+43)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConceptoPais_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConceptoPais_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConceptoConveCodigo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+44)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConceptoConveCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConceptoConveCodigo_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbConBaseLic.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+45)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseLic.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseLic.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      cmbConBaseLicProm.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+46)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseLicProm.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseLicProm.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      cmbConBaseFer.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+47)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseFer.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseFer.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      cmbConBaseFerProm.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+48)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseFerProm.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseFerProm.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      cmbConBaseHorExt.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+49)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseHorExt.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseHorExt.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      cmbConBaseHorExtProm.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+50)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseHorExtProm.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseHorExtProm.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      cmbConBasePres.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+51)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBasePres.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBasePres.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      cmbConBaseAnt.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+52)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseAnt.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseAnt.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      cmbConBaseOSDif.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+53)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseOSDif.getInternalname(), "Visible", GXutil.ltrimstr( cmbConBaseOSDif.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      chkConErrorSiCero.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+54)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConErrorSiCero.getInternalname(), "Visible", GXutil.ltrimstr( chkConErrorSiCero.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtCliPadre_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+55)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPadre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPadre_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConPadre_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+56)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConPadre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConPadre_Visible), 5, 0), !bGXsfl_110_Refreshing);
      chkConPueNov.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+57)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConPueNov.getInternalname(), "Visible", GXutil.ltrimstr( chkConPueNov.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      AV82GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV82GridCurrentPage), 10, 0));
      AV83GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV83GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV83GridPageCount), 10, 0));
      GXt_char10 = AV84GridAppliedFilters ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV183Pgmname, GXv_char7) ;
      conceptos_exportww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV84GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV84GridAppliedFilters", AV84GridAppliedFilters);
      GXt_char10 = AV175MenuOpcTitulo ;
      GXv_char7[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV159MenuOpcCod, GXv_char7) ;
      conceptos_exportww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV175MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV175MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV175MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int12[0] = (short)(AV177filterCount) ;
      GXv_char7[0] = AV178filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int12, GXv_char7) ;
      conceptos_exportww_impl.this.AV177filterCount = GXv_int12[0] ;
      conceptos_exportww_impl.this.AV178filtrosTexto = GXv_char7[0] ;
      if ( AV177filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV177filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV178filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV184Conceptos_exportwwds_1_tfclicod = AV24TFCliCod ;
      AV185Conceptos_exportwwds_2_tfclicod_to = AV25TFCliCod_To ;
      AV186Conceptos_exportwwds_3_tfconcodigo = AV27TFConCodigo ;
      AV187Conceptos_exportwwds_4_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV188Conceptos_exportwwds_5_tfcondescrip = AV30TFConDescrip ;
      AV189Conceptos_exportwwds_6_tfcondescrip_sels = AV31TFConDescrip_Sels ;
      AV190Conceptos_exportwwds_7_tfconorden = AV32TFConOrden ;
      AV191Conceptos_exportwwds_8_tfconorden_to = AV33TFConOrden_To ;
      AV192Conceptos_exportwwds_9_tfconliqbasica = AV36TFConLiqBasica ;
      AV193Conceptos_exportwwds_10_tfconliqbasica_to = AV37TFConLiqBasica_To ;
      AV194Conceptos_exportwwds_11_tfconformula = AV39TFConFormula ;
      AV195Conceptos_exportwwds_12_tfconformula_sels = AV40TFConFormula_Sels ;
      AV196Conceptos_exportwwds_13_tfconobservacion = AV42TFConObservacion ;
      AV197Conceptos_exportwwds_14_tfconobservacion_sels = AV43TFConObservacion_Sels ;
      AV198Conceptos_exportwwds_15_tfconvariable_sel = AV44TFConVariable_Sel ;
      AV199Conceptos_exportwwds_16_tfconforeditable_sel = AV45TFConForEditable_Sel ;
      AV200Conceptos_exportwwds_17_tftipoconcod_sels = AV47TFTipoConCod_Sels ;
      AV201Conceptos_exportwwds_18_tfsubtipoconcod1 = AV49TFSubTipoConCod1 ;
      AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels = AV50TFSubTipoConCod1_Sels ;
      AV203Conceptos_exportwwds_20_tfsubtipoconcod2 = AV52TFSubTipoConCod2 ;
      AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels = AV53TFSubTipoConCod2_Sels ;
      AV205Conceptos_exportwwds_22_tfcontipoliqaux = AV55TFConTipoLiqAux ;
      AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels = AV56TFConTipoLiqAux_Sels ;
      AV207Conceptos_exportwwds_24_tfconclasifaux = AV58TFConClasifAux ;
      AV208Conceptos_exportwwds_25_tfconclasifaux_sels = AV59TFConClasifAux_Sels ;
      AV209Conceptos_exportwwds_26_tfconordejec = AV60TFConOrdEjec ;
      AV210Conceptos_exportwwds_27_tfconordejec_to = AV61TFConOrdEjec_To ;
      AV211Conceptos_exportwwds_28_tfconrecalcular_sel = AV65TFConRecalcular_Sel ;
      AV212Conceptos_exportwwds_29_tfconrangocant = AV67TFConRangoCant ;
      AV213Conceptos_exportwwds_30_tfconrangocant_sels = AV68TFConRangoCant_Sels ;
      AV214Conceptos_exportwwds_31_tfconcondicion_sels = AV70TFConCondicion_Sels ;
      AV215Conceptos_exportwwds_32_tfconcondcodigo = AV72TFConCondCodigo ;
      AV216Conceptos_exportwwds_33_tfconcondcodigo_sels = AV73TFConCondCodigo_Sels ;
      AV217Conceptos_exportwwds_34_tfconmostrarpos_sel = AV74TFConMostrarPos_Sel ;
      AV218Conceptos_exportwwds_35_tfconadeldescu_sels = AV76TFConAdelDescu_Sels ;
      AV219Conceptos_exportwwds_36_tfapliigg = AV77TFAplIIGG ;
      AV220Conceptos_exportwwds_37_tfapliigg_to = AV78TFAplIIGG_To ;
      AV221Conceptos_exportwwds_38_tfconsegunpla_sel = AV79TFConSegunPla_Sel ;
      AV222Conceptos_exportwwds_39_tfconcodafip = AV92TFConCodAfip ;
      AV223Conceptos_exportwwds_40_tfconcodafip_sels = AV93TFConCodAfip_Sels ;
      AV224Conceptos_exportwwds_41_tfconsipaapo = AV94TFConSIPAApo ;
      AV225Conceptos_exportwwds_42_tfconsipaapo_to = AV95TFConSIPAApo_To ;
      AV226Conceptos_exportwwds_43_tfconsipacont = AV96TFConSIPACont ;
      AV227Conceptos_exportwwds_44_tfconsipacont_to = AV97TFConSIPACont_To ;
      AV228Conceptos_exportwwds_45_tfconinssjypapo = AV98TFConINSSJyPApo ;
      AV229Conceptos_exportwwds_46_tfconinssjypapo_to = AV99TFConINSSJyPApo_To ;
      AV230Conceptos_exportwwds_47_tfconinssjypcont = AV100TFConINSSJyPCont ;
      AV231Conceptos_exportwwds_48_tfconinssjypcont_to = AV101TFConINSSJyPCont_To ;
      AV232Conceptos_exportwwds_49_tfconobrasocapo = AV102TFConObraSocApo ;
      AV233Conceptos_exportwwds_50_tfconobrasocapo_to = AV103TFConObraSocApo_To ;
      AV234Conceptos_exportwwds_51_tfconobrasoccont = AV104TFConObraSocCont ;
      AV235Conceptos_exportwwds_52_tfconobrasoccont_to = AV105TFConObraSocCont_To ;
      AV236Conceptos_exportwwds_53_tfconfonsolredapo = AV106TFConFonSolRedApo ;
      AV237Conceptos_exportwwds_54_tfconfonsolredapo_to = AV107TFConFonSolRedApo_To ;
      AV238Conceptos_exportwwds_55_tfconfonsolredcont = AV108TFConFonSolRedCont ;
      AV239Conceptos_exportwwds_56_tfconfonsolredcont_to = AV109TFConFonSolRedCont_To ;
      AV240Conceptos_exportwwds_57_tfconrenateaapo = AV110TFConRenateaApo ;
      AV241Conceptos_exportwwds_58_tfconrenateaapo_to = AV111TFConRenateaApo_To ;
      AV242Conceptos_exportwwds_59_tfconrenateacont = AV112TFConRenateaCont ;
      AV243Conceptos_exportwwds_60_tfconrenateacont_to = AV113TFConRenateaCont_To ;
      AV244Conceptos_exportwwds_61_tfconasigfamcont = AV114TFConAsigFamCont ;
      AV245Conceptos_exportwwds_62_tfconasigfamcont_to = AV115TFConAsigFamCont_To ;
      AV246Conceptos_exportwwds_63_tfconfonnacempcont = AV116TFConFonNacEmpCont ;
      AV247Conceptos_exportwwds_64_tfconfonnacempcont_to = AV117TFConFonNacEmpCont_To ;
      AV248Conceptos_exportwwds_65_tfconleyrietrabcont = AV118TFConLeyRieTrabCont ;
      AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to = AV119TFConLeyRieTrabCont_To ;
      AV250Conceptos_exportwwds_67_tfconregdifapo = AV120TFConRegDifApo ;
      AV251Conceptos_exportwwds_68_tfconregdifapo_to = AV121TFConRegDifApo_To ;
      AV252Conceptos_exportwwds_69_tfconregespapo = AV122TFConRegEspApo ;
      AV253Conceptos_exportwwds_70_tfconregespapo_to = AV123TFConRegEspApo_To ;
      AV254Conceptos_exportwwds_71_tfconceptopais = AV126TFConceptoPais ;
      AV255Conceptos_exportwwds_72_tfconceptopais_to = AV127TFConceptoPais_To ;
      AV256Conceptos_exportwwds_73_tfconceptoconvecodigo = AV129TFConceptoConveCodigo ;
      AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels = AV130TFConceptoConveCodigo_Sels ;
      AV258Conceptos_exportwwds_75_tfconbaselicprom_sels = AV138TFConBaseLicProm_Sels ;
      AV259Conceptos_exportwwds_76_tfconbaseferprom_sels = AV140TFConBaseFerProm_Sels ;
      AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels = AV142TFConBaseHorExtProm_Sels ;
      AV261Conceptos_exportwwds_78_tfconbasepres_sels = AV144TFConBasePres_Sels ;
      AV262Conceptos_exportwwds_79_tfconbaseant_sels = AV146TFConBaseAnt_Sels ;
      AV263Conceptos_exportwwds_80_tfconbaseosdif_sels = AV148TFConBaseOSDif_Sels ;
      AV264Conceptos_exportwwds_81_tfconerrorsicero_sel = AV149TFConErrorSiCero_Sel ;
      AV265Conceptos_exportwwds_82_tfclipadre = AV150TFCliPadre ;
      AV266Conceptos_exportwwds_83_tfclipadre_to = AV151TFCliPadre_To ;
      AV267Conceptos_exportwwds_84_tfconpadre = AV153TFConPadre ;
      AV268Conceptos_exportwwds_85_tfconpadre_sels = AV154TFConPadre_Sels ;
      AV269Conceptos_exportwwds_86_tfconpuenov_sel = AV155TFConPueNov_Sel ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV168ManageFiltersData", AV168ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e15IB2( )
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
         AV81PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV81PageToGo) ;
      }
   }

   public void e16IB2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e17IB2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CliCod") == 0 )
         {
            AV24TFCliCod = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24TFCliCod), 6, 0));
            AV25TFCliCod_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFCliCod_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25TFCliCod_To), 6, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConCodigo") == 0 )
         {
            AV27TFConCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFConCodigo", AV27TFConCodigo);
            AV26TFConCodigo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFConCodigo_SelsJson", AV26TFConCodigo_SelsJson);
            AV28TFConCodigo_Sels.fromJSonString(AV26TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConDescrip") == 0 )
         {
            AV30TFConDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFConDescrip", AV30TFConDescrip);
            AV29TFConDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFConDescrip_SelsJson", AV29TFConDescrip_SelsJson);
            AV31TFConDescrip_Sels.fromJSonString(AV29TFConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConOrden") == 0 )
         {
            AV32TFConOrden = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFConOrden), 8, 0));
            AV33TFConOrden_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFConOrden_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFConOrden_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConVigencia") == 0 )
         {
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConLiqBasica") == 0 )
         {
            AV36TFConLiqBasica = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFConLiqBasica", GXutil.str( AV36TFConLiqBasica, 1, 0));
            AV37TFConLiqBasica_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFConLiqBasica_To", GXutil.str( AV37TFConLiqBasica_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConFormula") == 0 )
         {
            AV39TFConFormula = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFConFormula", AV39TFConFormula);
            AV38TFConFormula_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFConFormula_SelsJson", AV38TFConFormula_SelsJson);
            AV40TFConFormula_Sels.fromJSonString(AV38TFConFormula_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConObservacion") == 0 )
         {
            AV42TFConObservacion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFConObservacion", AV42TFConObservacion);
            AV41TFConObservacion_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFConObservacion_SelsJson", AV41TFConObservacion_SelsJson);
            AV43TFConObservacion_Sels.fromJSonString(AV41TFConObservacion_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConVariable") == 0 )
         {
            AV44TFConVariable_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFConVariable_Sel", GXutil.str( AV44TFConVariable_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConForEditable") == 0 )
         {
            AV45TFConForEditable_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFConForEditable_Sel", GXutil.str( AV45TFConForEditable_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "TipoConCod") == 0 )
         {
            AV46TFTipoConCod_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFTipoConCod_SelsJson", AV46TFTipoConCod_SelsJson);
            AV47TFTipoConCod_Sels.fromJSonString(AV46TFTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SubTipoConCod1") == 0 )
         {
            AV49TFSubTipoConCod1 = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFSubTipoConCod1", AV49TFSubTipoConCod1);
            AV48TFSubTipoConCod1_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFSubTipoConCod1_SelsJson", AV48TFSubTipoConCod1_SelsJson);
            AV50TFSubTipoConCod1_Sels.fromJSonString(AV48TFSubTipoConCod1_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SubTipoConCod2") == 0 )
         {
            AV52TFSubTipoConCod2 = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFSubTipoConCod2", AV52TFSubTipoConCod2);
            AV51TFSubTipoConCod2_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFSubTipoConCod2_SelsJson", AV51TFSubTipoConCod2_SelsJson);
            AV53TFSubTipoConCod2_Sels.fromJSonString(AV51TFSubTipoConCod2_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConTipoLiqAux") == 0 )
         {
            AV55TFConTipoLiqAux = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFConTipoLiqAux", AV55TFConTipoLiqAux);
            AV54TFConTipoLiqAux_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFConTipoLiqAux_SelsJson", AV54TFConTipoLiqAux_SelsJson);
            AV56TFConTipoLiqAux_Sels.fromJSonString(AV54TFConTipoLiqAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConClasifAux") == 0 )
         {
            AV58TFConClasifAux = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFConClasifAux", AV58TFConClasifAux);
            AV57TFConClasifAux_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFConClasifAux_SelsJson", AV57TFConClasifAux_SelsJson);
            AV59TFConClasifAux_Sels.fromJSonString(AV57TFConClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConOrdEjec") == 0 )
         {
            AV60TFConOrdEjec = GXutil.lval( Ddo_grid_Filteredtext_get) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFConOrdEjec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60TFConOrdEjec), 12, 0));
            AV61TFConOrdEjec_To = GXutil.lval( Ddo_grid_Filteredtextto_get) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFConOrdEjec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61TFConOrdEjec_To), 12, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConRecalcular") == 0 )
         {
            AV65TFConRecalcular_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFConRecalcular_Sel", GXutil.str( AV65TFConRecalcular_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConRangoCant") == 0 )
         {
            AV67TFConRangoCant = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFConRangoCant", AV67TFConRangoCant);
            AV66TFConRangoCant_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFConRangoCant_SelsJson", AV66TFConRangoCant_SelsJson);
            AV68TFConRangoCant_Sels.fromJSonString(AV66TFConRangoCant_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConCondicion") == 0 )
         {
            AV69TFConCondicion_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFConCondicion_SelsJson", AV69TFConCondicion_SelsJson);
            AV70TFConCondicion_Sels.fromJSonString(AV69TFConCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConCondCodigo") == 0 )
         {
            AV72TFConCondCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72TFConCondCodigo", AV72TFConCondCodigo);
            AV71TFConCondCodigo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFConCondCodigo_SelsJson", AV71TFConCondCodigo_SelsJson);
            AV73TFConCondCodigo_Sels.fromJSonString(AV71TFConCondCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConMostrarPos") == 0 )
         {
            AV74TFConMostrarPos_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFConMostrarPos_Sel", GXutil.str( AV74TFConMostrarPos_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConAdelDescu") == 0 )
         {
            AV75TFConAdelDescu_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFConAdelDescu_SelsJson", AV75TFConAdelDescu_SelsJson);
            AV76TFConAdelDescu_Sels.fromJSonString(GXutil.strReplace( AV75TFConAdelDescu_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "AplIIGG") == 0 )
         {
            AV77TFAplIIGG = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFAplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77TFAplIIGG), 4, 0));
            AV78TFAplIIGG_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFAplIIGG_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFAplIIGG_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConSegunPla") == 0 )
         {
            AV79TFConSegunPla_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79TFConSegunPla_Sel", GXutil.str( AV79TFConSegunPla_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConCodAfip") == 0 )
         {
            AV92TFConCodAfip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV92TFConCodAfip", AV92TFConCodAfip);
            AV91TFConCodAfip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91TFConCodAfip_SelsJson", AV91TFConCodAfip_SelsJson);
            AV93TFConCodAfip_Sels.fromJSonString(AV91TFConCodAfip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConSIPAApo") == 0 )
         {
            AV94TFConSIPAApo = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV94TFConSIPAApo", GXutil.str( AV94TFConSIPAApo, 1, 0));
            AV95TFConSIPAApo_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV95TFConSIPAApo_To", GXutil.str( AV95TFConSIPAApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConSIPACont") == 0 )
         {
            AV96TFConSIPACont = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV96TFConSIPACont", GXutil.str( AV96TFConSIPACont, 1, 0));
            AV97TFConSIPACont_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV97TFConSIPACont_To", GXutil.str( AV97TFConSIPACont_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConINSSJyPApo") == 0 )
         {
            AV98TFConINSSJyPApo = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV98TFConINSSJyPApo", GXutil.str( AV98TFConINSSJyPApo, 1, 0));
            AV99TFConINSSJyPApo_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV99TFConINSSJyPApo_To", GXutil.str( AV99TFConINSSJyPApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConINSSJyPCont") == 0 )
         {
            AV100TFConINSSJyPCont = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV100TFConINSSJyPCont", GXutil.str( AV100TFConINSSJyPCont, 1, 0));
            AV101TFConINSSJyPCont_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV101TFConINSSJyPCont_To", GXutil.str( AV101TFConINSSJyPCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConObraSocApo") == 0 )
         {
            AV102TFConObraSocApo = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV102TFConObraSocApo", GXutil.str( AV102TFConObraSocApo, 1, 0));
            AV103TFConObraSocApo_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV103TFConObraSocApo_To", GXutil.str( AV103TFConObraSocApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConObraSocCont") == 0 )
         {
            AV104TFConObraSocCont = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV104TFConObraSocCont", GXutil.str( AV104TFConObraSocCont, 1, 0));
            AV105TFConObraSocCont_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV105TFConObraSocCont_To", GXutil.str( AV105TFConObraSocCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConFonSolRedApo") == 0 )
         {
            AV106TFConFonSolRedApo = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV106TFConFonSolRedApo", GXutil.str( AV106TFConFonSolRedApo, 1, 0));
            AV107TFConFonSolRedApo_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV107TFConFonSolRedApo_To", GXutil.str( AV107TFConFonSolRedApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConFonSolRedCont") == 0 )
         {
            AV108TFConFonSolRedCont = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV108TFConFonSolRedCont", GXutil.str( AV108TFConFonSolRedCont, 1, 0));
            AV109TFConFonSolRedCont_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV109TFConFonSolRedCont_To", GXutil.str( AV109TFConFonSolRedCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConRenateaApo") == 0 )
         {
            AV110TFConRenateaApo = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV110TFConRenateaApo", GXutil.str( AV110TFConRenateaApo, 1, 0));
            AV111TFConRenateaApo_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV111TFConRenateaApo_To", GXutil.str( AV111TFConRenateaApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConRenateaCont") == 0 )
         {
            AV112TFConRenateaCont = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV112TFConRenateaCont", GXutil.str( AV112TFConRenateaCont, 1, 0));
            AV113TFConRenateaCont_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV113TFConRenateaCont_To", GXutil.str( AV113TFConRenateaCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConAsigFamCont") == 0 )
         {
            AV114TFConAsigFamCont = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV114TFConAsigFamCont", GXutil.str( AV114TFConAsigFamCont, 1, 0));
            AV115TFConAsigFamCont_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV115TFConAsigFamCont_To", GXutil.str( AV115TFConAsigFamCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConFonNacEmpCont") == 0 )
         {
            AV116TFConFonNacEmpCont = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV116TFConFonNacEmpCont", GXutil.str( AV116TFConFonNacEmpCont, 1, 0));
            AV117TFConFonNacEmpCont_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV117TFConFonNacEmpCont_To", GXutil.str( AV117TFConFonNacEmpCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConLeyRieTrabCont") == 0 )
         {
            AV118TFConLeyRieTrabCont = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV118TFConLeyRieTrabCont", GXutil.str( AV118TFConLeyRieTrabCont, 1, 0));
            AV119TFConLeyRieTrabCont_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV119TFConLeyRieTrabCont_To", GXutil.str( AV119TFConLeyRieTrabCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConRegDifApo") == 0 )
         {
            AV120TFConRegDifApo = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV120TFConRegDifApo", GXutil.str( AV120TFConRegDifApo, 1, 0));
            AV121TFConRegDifApo_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV121TFConRegDifApo_To", GXutil.str( AV121TFConRegDifApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConRegEspApo") == 0 )
         {
            AV122TFConRegEspApo = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV122TFConRegEspApo", GXutil.str( AV122TFConRegEspApo, 1, 0));
            AV123TFConRegEspApo_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV123TFConRegEspApo_To", GXutil.str( AV123TFConRegEspApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConSacDeven") == 0 )
         {
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConceptoPais") == 0 )
         {
            AV126TFConceptoPais = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV126TFConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV126TFConceptoPais), 4, 0));
            AV127TFConceptoPais_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV127TFConceptoPais_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV127TFConceptoPais_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConceptoConveCodigo") == 0 )
         {
            AV129TFConceptoConveCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV129TFConceptoConveCodigo", AV129TFConceptoConveCodigo);
            AV128TFConceptoConveCodigo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV128TFConceptoConveCodigo_SelsJson", AV128TFConceptoConveCodigo_SelsJson);
            AV130TFConceptoConveCodigo_Sels.fromJSonString(AV128TFConceptoConveCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseLic") == 0 )
         {
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseLicProm") == 0 )
         {
            AV137TFConBaseLicProm_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV137TFConBaseLicProm_SelsJson", AV137TFConBaseLicProm_SelsJson);
            AV138TFConBaseLicProm_Sels.fromJSonString(GXutil.strReplace( AV137TFConBaseLicProm_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseFer") == 0 )
         {
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseFerProm") == 0 )
         {
            AV139TFConBaseFerProm_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV139TFConBaseFerProm_SelsJson", AV139TFConBaseFerProm_SelsJson);
            AV140TFConBaseFerProm_Sels.fromJSonString(GXutil.strReplace( AV139TFConBaseFerProm_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseHorExt") == 0 )
         {
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseHorExtProm") == 0 )
         {
            AV141TFConBaseHorExtProm_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV141TFConBaseHorExtProm_SelsJson", AV141TFConBaseHorExtProm_SelsJson);
            AV142TFConBaseHorExtProm_Sels.fromJSonString(GXutil.strReplace( AV141TFConBaseHorExtProm_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBasePres") == 0 )
         {
            AV143TFConBasePres_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV143TFConBasePres_SelsJson", AV143TFConBasePres_SelsJson);
            AV144TFConBasePres_Sels.fromJSonString(GXutil.strReplace( AV143TFConBasePres_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseAnt") == 0 )
         {
            AV145TFConBaseAnt_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV145TFConBaseAnt_SelsJson", AV145TFConBaseAnt_SelsJson);
            AV146TFConBaseAnt_Sels.fromJSonString(GXutil.strReplace( AV145TFConBaseAnt_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConBaseOSDif") == 0 )
         {
            AV147TFConBaseOSDif_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV147TFConBaseOSDif_SelsJson", AV147TFConBaseOSDif_SelsJson);
            AV148TFConBaseOSDif_Sels.fromJSonString(GXutil.strReplace( AV147TFConBaseOSDif_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConErrorSiCero") == 0 )
         {
            AV149TFConErrorSiCero_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV149TFConErrorSiCero_Sel", GXutil.str( AV149TFConErrorSiCero_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CliPadre") == 0 )
         {
            AV150TFCliPadre = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV150TFCliPadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV150TFCliPadre), 6, 0));
            AV151TFCliPadre_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV151TFCliPadre_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV151TFCliPadre_To), 6, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConPadre") == 0 )
         {
            AV153TFConPadre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV153TFConPadre", AV153TFConPadre);
            AV152TFConPadre_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV152TFConPadre_SelsJson", AV152TFConPadre_SelsJson);
            AV154TFConPadre_Sels.fromJSonString(AV152TFConPadre_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConPueNov") == 0 )
         {
            AV155TFConPueNov_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV155TFConPueNov_Sel", GXutil.str( AV155TFConPueNov_Sel, 1, 0));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV154TFConPadre_Sels", AV154TFConPadre_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV148TFConBaseOSDif_Sels", AV148TFConBaseOSDif_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV146TFConBaseAnt_Sels", AV146TFConBaseAnt_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV144TFConBasePres_Sels", AV144TFConBasePres_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV142TFConBaseHorExtProm_Sels", AV142TFConBaseHorExtProm_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV140TFConBaseFerProm_Sels", AV140TFConBaseFerProm_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV138TFConBaseLicProm_Sels", AV138TFConBaseLicProm_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV130TFConceptoConveCodigo_Sels", AV130TFConceptoConveCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV93TFConCodAfip_Sels", AV93TFConCodAfip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76TFConAdelDescu_Sels", AV76TFConAdelDescu_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV73TFConCondCodigo_Sels", AV73TFConCondCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV70TFConCondicion_Sels", AV70TFConCondicion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV68TFConRangoCant_Sels", AV68TFConRangoCant_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV59TFConClasifAux_Sels", AV59TFConClasifAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV56TFConTipoLiqAux_Sels", AV56TFConTipoLiqAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53TFSubTipoConCod2_Sels", AV53TFSubTipoConCod2_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFSubTipoConCod1_Sels", AV50TFSubTipoConCod1_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV47TFTipoConCod_Sels", AV47TFTipoConCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43TFConObservacion_Sels", AV43TFConObservacion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFConFormula_Sels", AV40TFConFormula_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31TFConDescrip_Sels", AV31TFConDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28TFConCodigo_Sels", AV28TFConCodigo_Sels);
   }

   private void e23IB2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV158Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV158Display);
      edtavDisplay_Link = formatLink("web.conceptos_exportview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(A26ConCodigo)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","ConCodigo","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV157VerSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      conceptos_exportww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV157VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV157VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
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

   public void e13IB2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "Conceptos_exportWWColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV168ManageFiltersData", AV168ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e14IB2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("Conceptos_exportWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV183Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV170ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV170ManageFiltersExecutionStep", GXutil.str( AV170ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("Conceptos_exportWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV170ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV170ManageFiltersExecutionStep", GXutil.str( AV170ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char10 = AV169ManageFiltersXml ;
         GXv_char7[0] = GXt_char10 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "Conceptos_exportWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         conceptos_exportww_impl.this.GXt_char10 = GXv_char7[0] ;
         AV169ManageFiltersXml = GXt_char10 ;
         if ( (GXutil.strcmp("", AV169ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV183Pgmname+"GridState", AV169ManageFiltersXml) ;
            AV12GridState.fromxml(AV169ManageFiltersXml, null, null);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28TFConCodigo_Sels", AV28TFConCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31TFConDescrip_Sels", AV31TFConDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40TFConFormula_Sels", AV40TFConFormula_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43TFConObservacion_Sels", AV43TFConObservacion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV47TFTipoConCod_Sels", AV47TFTipoConCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFSubTipoConCod1_Sels", AV50TFSubTipoConCod1_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53TFSubTipoConCod2_Sels", AV53TFSubTipoConCod2_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV56TFConTipoLiqAux_Sels", AV56TFConTipoLiqAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV59TFConClasifAux_Sels", AV59TFConClasifAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV68TFConRangoCant_Sels", AV68TFConRangoCant_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV70TFConCondicion_Sels", AV70TFConCondicion_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV73TFConCondCodigo_Sels", AV73TFConCondCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76TFConAdelDescu_Sels", AV76TFConAdelDescu_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV93TFConCodAfip_Sels", AV93TFConCodAfip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV130TFConceptoConveCodigo_Sels", AV130TFConceptoConveCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV138TFConBaseLicProm_Sels", AV138TFConBaseLicProm_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV140TFConBaseFerProm_Sels", AV140TFConBaseFerProm_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV142TFConBaseHorExtProm_Sels", AV142TFConBaseHorExtProm_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV144TFConBasePres_Sels", AV144TFConBasePres_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV146TFConBaseAnt_Sels", AV146TFConBaseAnt_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV148TFConBaseOSDif_Sels", AV148TFConBaseOSDif_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV154TFConPadre_Sels", AV154TFConPadre_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV168ManageFiltersData", AV168ManageFiltersData);
   }

   public void e18IB2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.conceptos_export", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","CliCod","ConCodigo"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e19IB2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV17ExcelFilename ;
      GXv_char6[0] = AV18ErrorMessage ;
      new web.conceptos_exportwwexport(remoteHandle, context).execute( GXv_char7, GXv_char6) ;
      conceptos_exportww_impl.this.AV17ExcelFilename = GXv_char7[0] ;
      conceptos_exportww_impl.this.AV18ErrorMessage = GXv_char6[0] ;
      if ( GXutil.strcmp(AV17ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV17ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV18ErrorMessage);
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
      AV21ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "CliCod", "", "Cod", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConCodigo", "", "Código", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConDescrip", "", "Descripción", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConOrden", "", "Orden", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConVigencia", "", "Vigencia", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConLiqBasica", "", "Basica (borrar)", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConFormula", "", "Formula", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConObservacion", "", "Observacion", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConVariable", "", "Remuneración variable", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConForEditable", "", "Editable (borrar)", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "TipoConCod", "", "Tipo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "SubTipoConCod1", "", "Clasificación", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "SubTipoConCod2", "", "Sub clasif.", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConTipoLiqAux", "", "Liq Aux", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConClasifAux", "", "Clasificación", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConOrdEjec", "", "Ord Ejec", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConRecalcular", "", "Recalcular por impuesto a las ganancias", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConRangoCant", "", "Rango de valores para cantidad", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConCondicion", "", "Condición para liquidación", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConCondCodigo", "", "Código relacionado a la condición", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConMostrarPos", "", "Mostrar en recibo solo si es mayor a cero", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConAdelDescu", "", "Adelanto/Descuento", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "AplIIGG", "", "Tratamiento IIGG Nro", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConSegunPla", "", "Si no se cumple la condición, liquidar en segundo plano a posteriori", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&VerSVG", "", "", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConCodAfip", "", "Concepto AFIP", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConSIPAApo", "", "SIPAApo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConSIPACont", "", "SIPACont", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConINSSJyPApo", "", "INSSJy PApo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConINSSJyPCont", "", "INSSJy PCont", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConObraSocApo", "", "Soc Apo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConObraSocCont", "", "Soc Cont", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConFonSolRedApo", "", "Red Apo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConFonSolRedCont", "", "Red Cont", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConRenateaApo", "", "Renatea Apo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConRenateaCont", "", "Renatea Cont", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConAsigFamCont", "", "Fam Cont", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConFonNacEmpCont", "", "Emp Cont", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConLeyRieTrabCont", "", "Trab Cont", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConRegDifApo", "", "Dif Apo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConRegEspApo", "", "Esp Apo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConSacDeven", "", "Tipo devengamiento", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConceptoPais", "", "Pais", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConceptoConveCodigo", "", "Convenio", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConBaseLic", "", "Base de cálculo para licencias de remuneraciòn actual", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConBaseLicProm", "", "Base de cálculo para licencias de remuneración promedio variable", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConBaseFer", "", "Base de cálculo para feriados de remuneración actual", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConBaseFerProm", "", "Base de cálculo para feriados de remuneración promedio variable", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConBaseHorExt", "", "Base de cálculo para horas extras de remuneración actual", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConBaseHorExtProm", "", "Base de cálculo para horas extras de remuneración promedio variable", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConBasePres", "", "Base de cálculo para presentismo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConBaseAnt", "", "Base de cálculo para antiguedad", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConBaseOSDif", "", "Base de cálculo para obra social diferencial", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConErrorSiCero", "", "Dar error si el concepto se calcula en cero", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "CliPadre", "", "Padre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConPadre", "", "Padre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConPueNov", "", "Se puede ingresar como novedad", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXt_char10 = AV20UserCustomValue ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Conceptos_exportWWColumnsSelector", GXv_char7) ;
      conceptos_exportww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV20UserCustomValue = GXt_char10 ;
      if ( ! ( (GXutil.strcmp("", AV20UserCustomValue)==0) ) )
      {
         AV22ColumnsSelectorAux.fromxml(AV20UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector13[0] = AV22ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, GXv_SdtWWPColumnsSelector14) ;
         AV22ColumnsSelectorAux = GXv_SdtWWPColumnsSelector13[0] ;
         AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV87CliCod, GXv_SdtWWPColumnsSelector14) ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean15 = AV86TempBoolean ;
      GXv_boolean8[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptos_export_Insert", GXv_boolean8) ;
      conceptos_exportww_impl.this.GXt_boolean15 = GXv_boolean8[0] ;
      AV86TempBoolean = GXt_boolean15 ;
      if ( ! ( AV86TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = AV168ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "Conceptos_exportWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] ;
      AV168ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV24TFCliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24TFCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24TFCliCod), 6, 0));
      AV25TFCliCod_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25TFCliCod_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25TFCliCod_To), 6, 0));
      AV27TFConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27TFConCodigo", AV27TFConCodigo);
      AV28TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV30TFConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30TFConDescrip", AV30TFConDescrip);
      AV31TFConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV32TFConOrden = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFConOrden), 8, 0));
      AV33TFConOrden_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFConOrden_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFConOrden_To), 8, 0));
      AV36TFConLiqBasica = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFConLiqBasica", GXutil.str( AV36TFConLiqBasica, 1, 0));
      AV37TFConLiqBasica_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFConLiqBasica_To", GXutil.str( AV37TFConLiqBasica_To, 1, 0));
      AV39TFConFormula = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFConFormula", AV39TFConFormula);
      AV40TFConFormula_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV42TFConObservacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42TFConObservacion", AV42TFConObservacion);
      AV43TFConObservacion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV44TFConVariable_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44TFConVariable_Sel", GXutil.str( AV44TFConVariable_Sel, 1, 0));
      AV45TFConForEditable_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFConForEditable_Sel", GXutil.str( AV45TFConForEditable_Sel, 1, 0));
      AV47TFTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49TFSubTipoConCod1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49TFSubTipoConCod1", AV49TFSubTipoConCod1);
      AV50TFSubTipoConCod1_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52TFSubTipoConCod2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52TFSubTipoConCod2", AV52TFSubTipoConCod2);
      AV53TFSubTipoConCod2_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55TFConTipoLiqAux = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55TFConTipoLiqAux", AV55TFConTipoLiqAux);
      AV56TFConTipoLiqAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58TFConClasifAux = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV58TFConClasifAux", AV58TFConClasifAux);
      AV59TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV60TFConOrdEjec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60TFConOrdEjec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60TFConOrdEjec), 12, 0));
      AV61TFConOrdEjec_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61TFConOrdEjec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61TFConOrdEjec_To), 12, 0));
      AV65TFConRecalcular_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65TFConRecalcular_Sel", GXutil.str( AV65TFConRecalcular_Sel, 1, 0));
      AV67TFConRangoCant = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67TFConRangoCant", AV67TFConRangoCant);
      AV68TFConRangoCant_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV70TFConCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV72TFConCondCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72TFConCondCodigo", AV72TFConCondCodigo);
      AV73TFConCondCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV74TFConMostrarPos_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74TFConMostrarPos_Sel", GXutil.str( AV74TFConMostrarPos_Sel, 1, 0));
      AV76TFConAdelDescu_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV77TFAplIIGG = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77TFAplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77TFAplIIGG), 4, 0));
      AV78TFAplIIGG_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78TFAplIIGG_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFAplIIGG_To), 4, 0));
      AV79TFConSegunPla_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79TFConSegunPla_Sel", GXutil.str( AV79TFConSegunPla_Sel, 1, 0));
      AV92TFConCodAfip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV92TFConCodAfip", AV92TFConCodAfip);
      AV93TFConCodAfip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV94TFConSIPAApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV94TFConSIPAApo", GXutil.str( AV94TFConSIPAApo, 1, 0));
      AV95TFConSIPAApo_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV95TFConSIPAApo_To", GXutil.str( AV95TFConSIPAApo_To, 1, 0));
      AV96TFConSIPACont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV96TFConSIPACont", GXutil.str( AV96TFConSIPACont, 1, 0));
      AV97TFConSIPACont_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV97TFConSIPACont_To", GXutil.str( AV97TFConSIPACont_To, 1, 0));
      AV98TFConINSSJyPApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV98TFConINSSJyPApo", GXutil.str( AV98TFConINSSJyPApo, 1, 0));
      AV99TFConINSSJyPApo_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV99TFConINSSJyPApo_To", GXutil.str( AV99TFConINSSJyPApo_To, 1, 0));
      AV100TFConINSSJyPCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV100TFConINSSJyPCont", GXutil.str( AV100TFConINSSJyPCont, 1, 0));
      AV101TFConINSSJyPCont_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV101TFConINSSJyPCont_To", GXutil.str( AV101TFConINSSJyPCont_To, 1, 0));
      AV102TFConObraSocApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV102TFConObraSocApo", GXutil.str( AV102TFConObraSocApo, 1, 0));
      AV103TFConObraSocApo_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV103TFConObraSocApo_To", GXutil.str( AV103TFConObraSocApo_To, 1, 0));
      AV104TFConObraSocCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV104TFConObraSocCont", GXutil.str( AV104TFConObraSocCont, 1, 0));
      AV105TFConObraSocCont_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV105TFConObraSocCont_To", GXutil.str( AV105TFConObraSocCont_To, 1, 0));
      AV106TFConFonSolRedApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV106TFConFonSolRedApo", GXutil.str( AV106TFConFonSolRedApo, 1, 0));
      AV107TFConFonSolRedApo_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV107TFConFonSolRedApo_To", GXutil.str( AV107TFConFonSolRedApo_To, 1, 0));
      AV108TFConFonSolRedCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV108TFConFonSolRedCont", GXutil.str( AV108TFConFonSolRedCont, 1, 0));
      AV109TFConFonSolRedCont_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV109TFConFonSolRedCont_To", GXutil.str( AV109TFConFonSolRedCont_To, 1, 0));
      AV110TFConRenateaApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV110TFConRenateaApo", GXutil.str( AV110TFConRenateaApo, 1, 0));
      AV111TFConRenateaApo_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV111TFConRenateaApo_To", GXutil.str( AV111TFConRenateaApo_To, 1, 0));
      AV112TFConRenateaCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV112TFConRenateaCont", GXutil.str( AV112TFConRenateaCont, 1, 0));
      AV113TFConRenateaCont_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV113TFConRenateaCont_To", GXutil.str( AV113TFConRenateaCont_To, 1, 0));
      AV114TFConAsigFamCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV114TFConAsigFamCont", GXutil.str( AV114TFConAsigFamCont, 1, 0));
      AV115TFConAsigFamCont_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV115TFConAsigFamCont_To", GXutil.str( AV115TFConAsigFamCont_To, 1, 0));
      AV116TFConFonNacEmpCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV116TFConFonNacEmpCont", GXutil.str( AV116TFConFonNacEmpCont, 1, 0));
      AV117TFConFonNacEmpCont_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV117TFConFonNacEmpCont_To", GXutil.str( AV117TFConFonNacEmpCont_To, 1, 0));
      AV118TFConLeyRieTrabCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV118TFConLeyRieTrabCont", GXutil.str( AV118TFConLeyRieTrabCont, 1, 0));
      AV119TFConLeyRieTrabCont_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV119TFConLeyRieTrabCont_To", GXutil.str( AV119TFConLeyRieTrabCont_To, 1, 0));
      AV120TFConRegDifApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV120TFConRegDifApo", GXutil.str( AV120TFConRegDifApo, 1, 0));
      AV121TFConRegDifApo_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV121TFConRegDifApo_To", GXutil.str( AV121TFConRegDifApo_To, 1, 0));
      AV122TFConRegEspApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV122TFConRegEspApo", GXutil.str( AV122TFConRegEspApo, 1, 0));
      AV123TFConRegEspApo_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV123TFConRegEspApo_To", GXutil.str( AV123TFConRegEspApo_To, 1, 0));
      AV126TFConceptoPais = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV126TFConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV126TFConceptoPais), 4, 0));
      AV127TFConceptoPais_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV127TFConceptoPais_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV127TFConceptoPais_To), 4, 0));
      AV129TFConceptoConveCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV129TFConceptoConveCodigo", AV129TFConceptoConveCodigo);
      AV130TFConceptoConveCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV138TFConBaseLicProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV140TFConBaseFerProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV142TFConBaseHorExtProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV144TFConBasePres_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV146TFConBaseAnt_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV148TFConBaseOSDif_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV149TFConErrorSiCero_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV149TFConErrorSiCero_Sel", GXutil.str( AV149TFConErrorSiCero_Sel, 1, 0));
      AV150TFCliPadre = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV150TFCliPadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV150TFCliPadre), 6, 0));
      AV151TFCliPadre_To = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV151TFCliPadre_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV151TFCliPadre_To), 6, 0));
      AV153TFConPadre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV153TFConPadre", AV153TFConPadre);
      AV154TFConPadre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV155TFConPueNov_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV155TFConPueNov_Sel", GXutil.str( AV155TFConPueNov_Sel, 1, 0));
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
      if ( GXutil.strcmp(AV23Session.getValue(AV183Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV183Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV23Session.getValue(AV183Pgmname+"GridState"), null, null);
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
      AV270GXV1 = 1 ;
      while ( AV270GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV270GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV24TFCliCod = (int)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24TFCliCod), 6, 0));
            AV25TFCliCod_To = (int)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFCliCod_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25TFCliCod_To), 6, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV27TFConCodigo = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFConCodigo", AV27TFConCodigo);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV26TFConCodigo_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFConCodigo_SelsJson", AV26TFConCodigo_SelsJson);
            AV28TFConCodigo_Sels.fromJSonString(AV26TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP") == 0 )
         {
            AV30TFConDescrip = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFConDescrip", AV30TFConDescrip);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP_SEL") == 0 )
         {
            AV29TFConDescrip_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFConDescrip_SelsJson", AV29TFConDescrip_SelsJson);
            AV31TFConDescrip_Sels.fromJSonString(AV29TFConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONORDEN") == 0 )
         {
            AV32TFConOrden = (int)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32TFConOrden), 8, 0));
            AV33TFConOrden_To = (int)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFConOrden_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFConOrden_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONLIQBASICA") == 0 )
         {
            AV36TFConLiqBasica = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFConLiqBasica", GXutil.str( AV36TFConLiqBasica, 1, 0));
            AV37TFConLiqBasica_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFConLiqBasica_To", GXutil.str( AV37TFConLiqBasica_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFORMULA") == 0 )
         {
            AV39TFConFormula = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFConFormula", AV39TFConFormula);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFORMULA_SEL") == 0 )
         {
            AV38TFConFormula_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFConFormula_SelsJson", AV38TFConFormula_SelsJson);
            AV40TFConFormula_Sels.fromJSonString(AV38TFConFormula_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBSERVACION") == 0 )
         {
            AV42TFConObservacion = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42TFConObservacion", AV42TFConObservacion);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBSERVACION_SEL") == 0 )
         {
            AV41TFConObservacion_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFConObservacion_SelsJson", AV41TFConObservacion_SelsJson);
            AV43TFConObservacion_Sels.fromJSonString(AV41TFConObservacion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVARIABLE_SEL") == 0 )
         {
            AV44TFConVariable_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFConVariable_Sel", GXutil.str( AV44TFConVariable_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFOREDITABLE_SEL") == 0 )
         {
            AV45TFConForEditable_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFConForEditable_Sel", GXutil.str( AV45TFConForEditable_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONCOD_SEL") == 0 )
         {
            AV46TFTipoConCod_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFTipoConCod_SelsJson", AV46TFTipoConCod_SelsJson);
            AV47TFTipoConCod_Sels.fromJSonString(AV46TFTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSUBTIPOCONCOD1") == 0 )
         {
            AV49TFSubTipoConCod1 = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFSubTipoConCod1", AV49TFSubTipoConCod1);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSUBTIPOCONCOD1_SEL") == 0 )
         {
            AV48TFSubTipoConCod1_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFSubTipoConCod1_SelsJson", AV48TFSubTipoConCod1_SelsJson);
            AV50TFSubTipoConCod1_Sels.fromJSonString(AV48TFSubTipoConCod1_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSUBTIPOCONCOD2") == 0 )
         {
            AV52TFSubTipoConCod2 = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFSubTipoConCod2", AV52TFSubTipoConCod2);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSUBTIPOCONCOD2_SEL") == 0 )
         {
            AV51TFSubTipoConCod2_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFSubTipoConCod2_SelsJson", AV51TFSubTipoConCod2_SelsJson);
            AV53TFSubTipoConCod2_Sels.fromJSonString(AV51TFSubTipoConCod2_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTIPOLIQAUX") == 0 )
         {
            AV55TFConTipoLiqAux = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFConTipoLiqAux", AV55TFConTipoLiqAux);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTIPOLIQAUX_SEL") == 0 )
         {
            AV54TFConTipoLiqAux_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFConTipoLiqAux_SelsJson", AV54TFConTipoLiqAux_SelsJson);
            AV56TFConTipoLiqAux_Sels.fromJSonString(AV54TFConTipoLiqAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX") == 0 )
         {
            AV58TFConClasifAux = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFConClasifAux", AV58TFConClasifAux);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX_SEL") == 0 )
         {
            AV57TFConClasifAux_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFConClasifAux_SelsJson", AV57TFConClasifAux_SelsJson);
            AV59TFConClasifAux_Sels.fromJSonString(AV57TFConClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONORDEJEC") == 0 )
         {
            AV60TFConOrdEjec = GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFConOrdEjec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60TFConOrdEjec), 12, 0));
            AV61TFConOrdEjec_To = GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFConOrdEjec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61TFConOrdEjec_To), 12, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRECALCULAR_SEL") == 0 )
         {
            AV65TFConRecalcular_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFConRecalcular_Sel", GXutil.str( AV65TFConRecalcular_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRANGOCANT") == 0 )
         {
            AV67TFConRangoCant = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFConRangoCant", AV67TFConRangoCant);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRANGOCANT_SEL") == 0 )
         {
            AV66TFConRangoCant_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFConRangoCant_SelsJson", AV66TFConRangoCant_SelsJson);
            AV68TFConRangoCant_Sels.fromJSonString(AV66TFConRangoCant_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCONDICION_SEL") == 0 )
         {
            AV69TFConCondicion_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFConCondicion_SelsJson", AV69TFConCondicion_SelsJson);
            AV70TFConCondicion_Sels.fromJSonString(AV69TFConCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCONDCODIGO") == 0 )
         {
            AV72TFConCondCodigo = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72TFConCondCodigo", AV72TFConCondCodigo);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCONDCODIGO_SEL") == 0 )
         {
            AV71TFConCondCodigo_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFConCondCodigo_SelsJson", AV71TFConCondCodigo_SelsJson);
            AV73TFConCondCodigo_Sels.fromJSonString(AV71TFConCondCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONMOSTRARPOS_SEL") == 0 )
         {
            AV74TFConMostrarPos_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFConMostrarPos_Sel", GXutil.str( AV74TFConMostrarPos_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONADELDESCU_SEL") == 0 )
         {
            AV75TFConAdelDescu_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFConAdelDescu_SelsJson", AV75TFConAdelDescu_SelsJson);
            AV76TFConAdelDescu_Sels.fromJSonString(AV75TFConAdelDescu_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGG") == 0 )
         {
            AV77TFAplIIGG = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFAplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77TFAplIIGG), 4, 0));
            AV78TFAplIIGG_To = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFAplIIGG_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFAplIIGG_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONSEGUNPLA_SEL") == 0 )
         {
            AV79TFConSegunPla_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79TFConSegunPla_Sel", GXutil.str( AV79TFConSegunPla_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODAFIP") == 0 )
         {
            AV92TFConCodAfip = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV92TFConCodAfip", AV92TFConCodAfip);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODAFIP_SEL") == 0 )
         {
            AV91TFConCodAfip_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91TFConCodAfip_SelsJson", AV91TFConCodAfip_SelsJson);
            AV93TFConCodAfip_Sels.fromJSonString(AV91TFConCodAfip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONSIPAAPO") == 0 )
         {
            AV94TFConSIPAApo = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV94TFConSIPAApo", GXutil.str( AV94TFConSIPAApo, 1, 0));
            AV95TFConSIPAApo_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV95TFConSIPAApo_To", GXutil.str( AV95TFConSIPAApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONSIPACONT") == 0 )
         {
            AV96TFConSIPACont = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV96TFConSIPACont", GXutil.str( AV96TFConSIPACont, 1, 0));
            AV97TFConSIPACont_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV97TFConSIPACont_To", GXutil.str( AV97TFConSIPACont_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONINSSJYPAPO") == 0 )
         {
            AV98TFConINSSJyPApo = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV98TFConINSSJyPApo", GXutil.str( AV98TFConINSSJyPApo, 1, 0));
            AV99TFConINSSJyPApo_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV99TFConINSSJyPApo_To", GXutil.str( AV99TFConINSSJyPApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONINSSJYPCONT") == 0 )
         {
            AV100TFConINSSJyPCont = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV100TFConINSSJyPCont", GXutil.str( AV100TFConINSSJyPCont, 1, 0));
            AV101TFConINSSJyPCont_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV101TFConINSSJyPCont_To", GXutil.str( AV101TFConINSSJyPCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBRASOCAPO") == 0 )
         {
            AV102TFConObraSocApo = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV102TFConObraSocApo", GXutil.str( AV102TFConObraSocApo, 1, 0));
            AV103TFConObraSocApo_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV103TFConObraSocApo_To", GXutil.str( AV103TFConObraSocApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBRASOCCONT") == 0 )
         {
            AV104TFConObraSocCont = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV104TFConObraSocCont", GXutil.str( AV104TFConObraSocCont, 1, 0));
            AV105TFConObraSocCont_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV105TFConObraSocCont_To", GXutil.str( AV105TFConObraSocCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFONSOLREDAPO") == 0 )
         {
            AV106TFConFonSolRedApo = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV106TFConFonSolRedApo", GXutil.str( AV106TFConFonSolRedApo, 1, 0));
            AV107TFConFonSolRedApo_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV107TFConFonSolRedApo_To", GXutil.str( AV107TFConFonSolRedApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFONSOLREDCONT") == 0 )
         {
            AV108TFConFonSolRedCont = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV108TFConFonSolRedCont", GXutil.str( AV108TFConFonSolRedCont, 1, 0));
            AV109TFConFonSolRedCont_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV109TFConFonSolRedCont_To", GXutil.str( AV109TFConFonSolRedCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRENATEAAPO") == 0 )
         {
            AV110TFConRenateaApo = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV110TFConRenateaApo", GXutil.str( AV110TFConRenateaApo, 1, 0));
            AV111TFConRenateaApo_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV111TFConRenateaApo_To", GXutil.str( AV111TFConRenateaApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRENATEACONT") == 0 )
         {
            AV112TFConRenateaCont = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV112TFConRenateaCont", GXutil.str( AV112TFConRenateaCont, 1, 0));
            AV113TFConRenateaCont_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV113TFConRenateaCont_To", GXutil.str( AV113TFConRenateaCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONASIGFAMCONT") == 0 )
         {
            AV114TFConAsigFamCont = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV114TFConAsigFamCont", GXutil.str( AV114TFConAsigFamCont, 1, 0));
            AV115TFConAsigFamCont_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV115TFConAsigFamCont_To", GXutil.str( AV115TFConAsigFamCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFONNACEMPCONT") == 0 )
         {
            AV116TFConFonNacEmpCont = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV116TFConFonNacEmpCont", GXutil.str( AV116TFConFonNacEmpCont, 1, 0));
            AV117TFConFonNacEmpCont_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV117TFConFonNacEmpCont_To", GXutil.str( AV117TFConFonNacEmpCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONLEYRIETRABCONT") == 0 )
         {
            AV118TFConLeyRieTrabCont = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV118TFConLeyRieTrabCont", GXutil.str( AV118TFConLeyRieTrabCont, 1, 0));
            AV119TFConLeyRieTrabCont_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV119TFConLeyRieTrabCont_To", GXutil.str( AV119TFConLeyRieTrabCont_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONREGDIFAPO") == 0 )
         {
            AV120TFConRegDifApo = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV120TFConRegDifApo", GXutil.str( AV120TFConRegDifApo, 1, 0));
            AV121TFConRegDifApo_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV121TFConRegDifApo_To", GXutil.str( AV121TFConRegDifApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONREGESPAPO") == 0 )
         {
            AV122TFConRegEspApo = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV122TFConRegEspApo", GXutil.str( AV122TFConRegEspApo, 1, 0));
            AV123TFConRegEspApo_To = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV123TFConRegEspApo_To", GXutil.str( AV123TFConRegEspApo_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCEPTOPAIS") == 0 )
         {
            AV126TFConceptoPais = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV126TFConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV126TFConceptoPais), 4, 0));
            AV127TFConceptoPais_To = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV127TFConceptoPais_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV127TFConceptoPais_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCEPTOCONVECODIGO") == 0 )
         {
            AV129TFConceptoConveCodigo = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV129TFConceptoConveCodigo", AV129TFConceptoConveCodigo);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCEPTOCONVECODIGO_SEL") == 0 )
         {
            AV128TFConceptoConveCodigo_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV128TFConceptoConveCodigo_SelsJson", AV128TFConceptoConveCodigo_SelsJson);
            AV130TFConceptoConveCodigo_Sels.fromJSonString(AV128TFConceptoConveCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASELICPROM_SEL") == 0 )
         {
            AV137TFConBaseLicProm_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV137TFConBaseLicProm_SelsJson", AV137TFConBaseLicProm_SelsJson);
            AV138TFConBaseLicProm_Sels.fromJSonString(AV137TFConBaseLicProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEFERPROM_SEL") == 0 )
         {
            AV139TFConBaseFerProm_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV139TFConBaseFerProm_SelsJson", AV139TFConBaseFerProm_SelsJson);
            AV140TFConBaseFerProm_Sels.fromJSonString(AV139TFConBaseFerProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEHOREXTPROM_SEL") == 0 )
         {
            AV141TFConBaseHorExtProm_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV141TFConBaseHorExtProm_SelsJson", AV141TFConBaseHorExtProm_SelsJson);
            AV142TFConBaseHorExtProm_Sels.fromJSonString(AV141TFConBaseHorExtProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEPRES_SEL") == 0 )
         {
            AV143TFConBasePres_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV143TFConBasePres_SelsJson", AV143TFConBasePres_SelsJson);
            AV144TFConBasePres_Sels.fromJSonString(AV143TFConBasePres_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEANT_SEL") == 0 )
         {
            AV145TFConBaseAnt_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV145TFConBaseAnt_SelsJson", AV145TFConBaseAnt_SelsJson);
            AV146TFConBaseAnt_Sels.fromJSonString(AV145TFConBaseAnt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEOSDIF_SEL") == 0 )
         {
            AV147TFConBaseOSDif_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV147TFConBaseOSDif_SelsJson", AV147TFConBaseOSDif_SelsJson);
            AV148TFConBaseOSDif_Sels.fromJSonString(AV147TFConBaseOSDif_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONERRORSICERO_SEL") == 0 )
         {
            AV149TFConErrorSiCero_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV149TFConErrorSiCero_Sel", GXutil.str( AV149TFConErrorSiCero_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIPADRE") == 0 )
         {
            AV150TFCliPadre = (int)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV150TFCliPadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV150TFCliPadre), 6, 0));
            AV151TFCliPadre_To = (int)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV151TFCliPadre_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV151TFCliPadre_To), 6, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONPADRE") == 0 )
         {
            AV153TFConPadre = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV153TFConPadre", AV153TFConPadre);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONPADRE_SEL") == 0 )
         {
            AV152TFConPadre_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV152TFConPadre_SelsJson", AV152TFConPadre_SelsJson);
            AV154TFConPadre_Sels.fromJSonString(AV152TFConPadre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONPUENOV_SEL") == 0 )
         {
            AV155TFConPueNov_Sel = (byte)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV155TFConPueNov_Sel", GXutil.str( AV155TFConPueNov_Sel, 1, 0));
         }
         AV270GXV1 = (int)(AV270GXV1+1) ;
      }
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV28TFConCodigo_Sels.size()==0), AV26TFConCodigo_SelsJson, GXv_char7) ;
      conceptos_exportww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV31TFConDescrip_Sels.size()==0), AV29TFConDescrip_SelsJson, GXv_char6) ;
      conceptos_exportww_impl.this.GXt_char9 = GXv_char6[0] ;
      GXt_char18 = "" ;
      GXv_char5[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV40TFConFormula_Sels.size()==0), AV38TFConFormula_SelsJson, GXv_char5) ;
      conceptos_exportww_impl.this.GXt_char18 = GXv_char5[0] ;
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV43TFConObservacion_Sels.size()==0), AV41TFConObservacion_SelsJson, GXv_char20) ;
      conceptos_exportww_impl.this.GXt_char19 = GXv_char20[0] ;
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV47TFTipoConCod_Sels.size()==0), AV46TFTipoConCod_SelsJson, GXv_char22) ;
      conceptos_exportww_impl.this.GXt_char21 = GXv_char22[0] ;
      GXt_char23 = "" ;
      GXv_char24[0] = GXt_char23 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV50TFSubTipoConCod1_Sels.size()==0), AV48TFSubTipoConCod1_SelsJson, GXv_char24) ;
      conceptos_exportww_impl.this.GXt_char23 = GXv_char24[0] ;
      GXt_char25 = "" ;
      GXv_char26[0] = GXt_char25 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV53TFSubTipoConCod2_Sels.size()==0), AV51TFSubTipoConCod2_SelsJson, GXv_char26) ;
      conceptos_exportww_impl.this.GXt_char25 = GXv_char26[0] ;
      GXt_char27 = "" ;
      GXv_char28[0] = GXt_char27 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV56TFConTipoLiqAux_Sels.size()==0), AV54TFConTipoLiqAux_SelsJson, GXv_char28) ;
      conceptos_exportww_impl.this.GXt_char27 = GXv_char28[0] ;
      GXt_char29 = "" ;
      GXv_char30[0] = GXt_char29 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV59TFConClasifAux_Sels.size()==0), AV57TFConClasifAux_SelsJson, GXv_char30) ;
      conceptos_exportww_impl.this.GXt_char29 = GXv_char30[0] ;
      GXt_char31 = "" ;
      GXv_char32[0] = GXt_char31 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV68TFConRangoCant_Sels.size()==0), AV66TFConRangoCant_SelsJson, GXv_char32) ;
      conceptos_exportww_impl.this.GXt_char31 = GXv_char32[0] ;
      GXt_char33 = "" ;
      GXv_char34[0] = GXt_char33 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV70TFConCondicion_Sels.size()==0), AV69TFConCondicion_SelsJson, GXv_char34) ;
      conceptos_exportww_impl.this.GXt_char33 = GXv_char34[0] ;
      GXt_char35 = "" ;
      GXv_char36[0] = GXt_char35 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV73TFConCondCodigo_Sels.size()==0), AV71TFConCondCodigo_SelsJson, GXv_char36) ;
      conceptos_exportww_impl.this.GXt_char35 = GXv_char36[0] ;
      GXt_char37 = "" ;
      GXv_char38[0] = GXt_char37 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV93TFConCodAfip_Sels.size()==0), AV91TFConCodAfip_SelsJson, GXv_char38) ;
      conceptos_exportww_impl.this.GXt_char37 = GXv_char38[0] ;
      GXt_char39 = "" ;
      GXv_char40[0] = GXt_char39 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV130TFConceptoConveCodigo_Sels.size()==0), AV128TFConceptoConveCodigo_SelsJson, GXv_char40) ;
      conceptos_exportww_impl.this.GXt_char39 = GXv_char40[0] ;
      GXt_char41 = "" ;
      GXv_char42[0] = GXt_char41 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV154TFConPadre_Sels.size()==0), AV152TFConPadre_SelsJson, GXv_char42) ;
      conceptos_exportww_impl.this.GXt_char41 = GXv_char42[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char10+"|"+GXt_char9+"||||"+GXt_char18+"|"+GXt_char19+"|"+((0==AV44TFConVariable_Sel) ? "" : GXutil.str( AV44TFConVariable_Sel, 1, 0))+"|"+((0==AV45TFConForEditable_Sel) ? "" : GXutil.str( AV45TFConForEditable_Sel, 1, 0))+"|"+GXt_char21+"|"+GXt_char23+"|"+GXt_char25+"|"+GXt_char27+"|"+GXt_char29+"||"+((0==AV65TFConRecalcular_Sel) ? "" : GXutil.str( AV65TFConRecalcular_Sel, 1, 0))+"|"+GXt_char31+"|"+GXt_char33+"|"+GXt_char35+"|"+((0==AV74TFConMostrarPos_Sel) ? "" : GXutil.str( AV74TFConMostrarPos_Sel, 1, 0))+"|"+((AV76TFConAdelDescu_Sels.size()==0) ? "" : AV75TFConAdelDescu_SelsJson)+"||"+((0==AV79TFConSegunPla_Sel) ? "" : GXutil.str( AV79TFConSegunPla_Sel, 1, 0))+"|"+GXt_char37+"||||||||||||||||||"+GXt_char39+"||"+((AV138TFConBaseLicProm_Sels.size()==0) ? "" : AV137TFConBaseLicProm_SelsJson)+"||"+((AV140TFConBaseFerProm_Sels.size()==0) ? "" : AV139TFConBaseFerProm_SelsJson)+"||"+((AV142TFConBaseHorExtProm_Sels.size()==0) ? "" : AV141TFConBaseHorExtProm_SelsJson)+"|"+((AV144TFConBasePres_Sels.size()==0) ? "" : AV143TFConBasePres_SelsJson)+"|"+((AV146TFConBaseAnt_Sels.size()==0) ? "" : AV145TFConBaseAnt_SelsJson)+"|"+((AV148TFConBaseOSDif_Sels.size()==0) ? "" : AV147TFConBaseOSDif_SelsJson)+"|"+((0==AV149TFConErrorSiCero_Sel) ? "" : GXutil.str( AV149TFConErrorSiCero_Sel, 1, 0))+"||"+GXt_char41+"|"+((0==AV155TFConPueNov_Sel) ? "" : GXutil.str( AV155TFConPueNov_Sel, 1, 0)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char41 = "" ;
      GXv_char42[0] = GXt_char41 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV27TFConCodigo)==0), AV27TFConCodigo, GXv_char42) ;
      conceptos_exportww_impl.this.GXt_char41 = GXv_char42[0] ;
      GXt_char39 = "" ;
      GXv_char40[0] = GXt_char39 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV30TFConDescrip)==0), AV30TFConDescrip, GXv_char40) ;
      conceptos_exportww_impl.this.GXt_char39 = GXv_char40[0] ;
      GXt_char37 = "" ;
      GXv_char38[0] = GXt_char37 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV39TFConFormula)==0), AV39TFConFormula, GXv_char38) ;
      conceptos_exportww_impl.this.GXt_char37 = GXv_char38[0] ;
      GXt_char35 = "" ;
      GXv_char36[0] = GXt_char35 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV42TFConObservacion)==0), AV42TFConObservacion, GXv_char36) ;
      conceptos_exportww_impl.this.GXt_char35 = GXv_char36[0] ;
      GXt_char33 = "" ;
      GXv_char34[0] = GXt_char33 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV49TFSubTipoConCod1)==0), AV49TFSubTipoConCod1, GXv_char34) ;
      conceptos_exportww_impl.this.GXt_char33 = GXv_char34[0] ;
      GXt_char31 = "" ;
      GXv_char32[0] = GXt_char31 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV52TFSubTipoConCod2)==0), AV52TFSubTipoConCod2, GXv_char32) ;
      conceptos_exportww_impl.this.GXt_char31 = GXv_char32[0] ;
      GXt_char29 = "" ;
      GXv_char30[0] = GXt_char29 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV55TFConTipoLiqAux)==0), AV55TFConTipoLiqAux, GXv_char30) ;
      conceptos_exportww_impl.this.GXt_char29 = GXv_char30[0] ;
      GXt_char27 = "" ;
      GXv_char28[0] = GXt_char27 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV58TFConClasifAux)==0), AV58TFConClasifAux, GXv_char28) ;
      conceptos_exportww_impl.this.GXt_char27 = GXv_char28[0] ;
      GXt_char25 = "" ;
      GXv_char26[0] = GXt_char25 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV67TFConRangoCant)==0), AV67TFConRangoCant, GXv_char26) ;
      conceptos_exportww_impl.this.GXt_char25 = GXv_char26[0] ;
      GXt_char23 = "" ;
      GXv_char24[0] = GXt_char23 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV72TFConCondCodigo)==0), AV72TFConCondCodigo, GXv_char24) ;
      conceptos_exportww_impl.this.GXt_char23 = GXv_char24[0] ;
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV92TFConCodAfip)==0), AV92TFConCodAfip, GXv_char22) ;
      conceptos_exportww_impl.this.GXt_char21 = GXv_char22[0] ;
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV129TFConceptoConveCodigo)==0), AV129TFConceptoConveCodigo, GXv_char20) ;
      conceptos_exportww_impl.this.GXt_char19 = GXv_char20[0] ;
      GXt_char18 = "" ;
      GXv_char7[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV153TFConPadre)==0), AV153TFConPadre, GXv_char7) ;
      conceptos_exportww_impl.this.GXt_char18 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV24TFCliCod) ? "" : GXutil.str( AV24TFCliCod, 6, 0))+"|"+GXt_char41+"|"+GXt_char39+"|"+((0==AV32TFConOrden) ? "" : GXutil.str( AV32TFConOrden, 8, 0))+"||"+((0==AV36TFConLiqBasica) ? "" : GXutil.str( AV36TFConLiqBasica, 1, 0))+"|"+GXt_char37+"|"+GXt_char35+"||||"+GXt_char33+"|"+GXt_char31+"|"+GXt_char29+"|"+GXt_char27+"|"+((0==AV60TFConOrdEjec) ? "" : GXutil.str( AV60TFConOrdEjec, 12, 0))+"||"+GXt_char25+"||"+GXt_char23+"|||"+((0==AV77TFAplIIGG) ? "" : GXutil.str( AV77TFAplIIGG, 4, 0))+"||"+GXt_char21+"|"+((0==AV94TFConSIPAApo) ? "" : GXutil.str( AV94TFConSIPAApo, 1, 0))+"|"+((0==AV96TFConSIPACont) ? "" : GXutil.str( AV96TFConSIPACont, 1, 0))+"|"+((0==AV98TFConINSSJyPApo) ? "" : GXutil.str( AV98TFConINSSJyPApo, 1, 0))+"|"+((0==AV100TFConINSSJyPCont) ? "" : GXutil.str( AV100TFConINSSJyPCont, 1, 0))+"|"+((0==AV102TFConObraSocApo) ? "" : GXutil.str( AV102TFConObraSocApo, 1, 0))+"|"+((0==AV104TFConObraSocCont) ? "" : GXutil.str( AV104TFConObraSocCont, 1, 0))+"|"+((0==AV106TFConFonSolRedApo) ? "" : GXutil.str( AV106TFConFonSolRedApo, 1, 0))+"|"+((0==AV108TFConFonSolRedCont) ? "" : GXutil.str( AV108TFConFonSolRedCont, 1, 0))+"|"+((0==AV110TFConRenateaApo) ? "" : GXutil.str( AV110TFConRenateaApo, 1, 0))+"|"+((0==AV112TFConRenateaCont) ? "" : GXutil.str( AV112TFConRenateaCont, 1, 0))+"|"+((0==AV114TFConAsigFamCont) ? "" : GXutil.str( AV114TFConAsigFamCont, 1, 0))+"|"+((0==AV116TFConFonNacEmpCont) ? "" : GXutil.str( AV116TFConFonNacEmpCont, 1, 0))+"|"+((0==AV118TFConLeyRieTrabCont) ? "" : GXutil.str( AV118TFConLeyRieTrabCont, 1, 0))+"|"+((0==AV120TFConRegDifApo) ? "" : GXutil.str( AV120TFConRegDifApo, 1, 0))+"|"+((0==AV122TFConRegEspApo) ? "" : GXutil.str( AV122TFConRegEspApo, 1, 0))+"||"+((0==AV126TFConceptoPais) ? "" : GXutil.str( AV126TFConceptoPais, 4, 0))+"|"+GXt_char19+"|||||||||||"+((0==AV150TFCliPadre) ? "" : GXutil.str( AV150TFCliPadre, 6, 0))+"|"+GXt_char18+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV25TFCliCod_To) ? "" : GXutil.str( AV25TFCliCod_To, 6, 0))+"|||"+((0==AV33TFConOrden_To) ? "" : GXutil.str( AV33TFConOrden_To, 8, 0))+"||"+((0==AV37TFConLiqBasica_To) ? "" : GXutil.str( AV37TFConLiqBasica_To, 1, 0))+"||||||||||"+((0==AV61TFConOrdEjec_To) ? "" : GXutil.str( AV61TFConOrdEjec_To, 12, 0))+"|||||||"+((0==AV78TFAplIIGG_To) ? "" : GXutil.str( AV78TFAplIIGG_To, 4, 0))+"|||"+((0==AV95TFConSIPAApo_To) ? "" : GXutil.str( AV95TFConSIPAApo_To, 1, 0))+"|"+((0==AV97TFConSIPACont_To) ? "" : GXutil.str( AV97TFConSIPACont_To, 1, 0))+"|"+((0==AV99TFConINSSJyPApo_To) ? "" : GXutil.str( AV99TFConINSSJyPApo_To, 1, 0))+"|"+((0==AV101TFConINSSJyPCont_To) ? "" : GXutil.str( AV101TFConINSSJyPCont_To, 1, 0))+"|"+((0==AV103TFConObraSocApo_To) ? "" : GXutil.str( AV103TFConObraSocApo_To, 1, 0))+"|"+((0==AV105TFConObraSocCont_To) ? "" : GXutil.str( AV105TFConObraSocCont_To, 1, 0))+"|"+((0==AV107TFConFonSolRedApo_To) ? "" : GXutil.str( AV107TFConFonSolRedApo_To, 1, 0))+"|"+((0==AV109TFConFonSolRedCont_To) ? "" : GXutil.str( AV109TFConFonSolRedCont_To, 1, 0))+"|"+((0==AV111TFConRenateaApo_To) ? "" : GXutil.str( AV111TFConRenateaApo_To, 1, 0))+"|"+((0==AV113TFConRenateaCont_To) ? "" : GXutil.str( AV113TFConRenateaCont_To, 1, 0))+"|"+((0==AV115TFConAsigFamCont_To) ? "" : GXutil.str( AV115TFConAsigFamCont_To, 1, 0))+"|"+((0==AV117TFConFonNacEmpCont_To) ? "" : GXutil.str( AV117TFConFonNacEmpCont_To, 1, 0))+"|"+((0==AV119TFConLeyRieTrabCont_To) ? "" : GXutil.str( AV119TFConLeyRieTrabCont_To, 1, 0))+"|"+((0==AV121TFConRegDifApo_To) ? "" : GXutil.str( AV121TFConRegDifApo_To, 1, 0))+"|"+((0==AV123TFConRegEspApo_To) ? "" : GXutil.str( AV123TFConRegEspApo_To, 1, 0))+"||"+((0==AV127TFConceptoPais_To) ? "" : GXutil.str( AV127TFConceptoPais_To, 4, 0))+"||||||||||||"+((0==AV151TFCliPadre_To) ? "" : GXutil.str( AV151TFCliPadre_To, 6, 0))+"||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV23Session.getValue(AV183Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCLICOD", httpContext.getMessage( "Cod", ""), !((0==AV24TFCliCod)&&(0==AV25TFCliCod_To)), (short)(0), GXutil.trim( GXutil.str( AV24TFCliCod, 6, 0)), GXutil.trim( GXutil.str( AV25TFCliCod_To, 6, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONCODIGO", httpContext.getMessage( "Código", ""), !(GXutil.strcmp("", AV27TFConCodigo)==0), (short)(0), AV27TFConCodigo, "", !(AV28TFConCodigo_Sels.size()==0), AV28TFConCodigo_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONDESCRIP", httpContext.getMessage( "Descripción", ""), !(GXutil.strcmp("", AV30TFConDescrip)==0), (short)(0), AV30TFConDescrip, "", !(AV31TFConDescrip_Sels.size()==0), AV31TFConDescrip_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONORDEN", httpContext.getMessage( "Orden", ""), !((0==AV32TFConOrden)&&(0==AV33TFConOrden_To)), (short)(0), GXutil.trim( GXutil.str( AV32TFConOrden, 8, 0)), GXutil.trim( GXutil.str( AV33TFConOrden_To, 8, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONLIQBASICA", httpContext.getMessage( "Basica (borrar)", ""), !((0==AV36TFConLiqBasica)&&(0==AV37TFConLiqBasica_To)), (short)(0), GXutil.trim( GXutil.str( AV36TFConLiqBasica, 1, 0)), GXutil.trim( GXutil.str( AV37TFConLiqBasica_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONFORMULA", httpContext.getMessage( "Formula", ""), !(GXutil.strcmp("", AV39TFConFormula)==0), (short)(0), AV39TFConFormula, "", !(AV40TFConFormula_Sels.size()==0), AV40TFConFormula_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONOBSERVACION", httpContext.getMessage( "Observacion", ""), !(GXutil.strcmp("", AV42TFConObservacion)==0), (short)(0), AV42TFConObservacion, "", !(AV43TFConObservacion_Sels.size()==0), AV43TFConObservacion_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONVARIABLE_SEL", httpContext.getMessage( "Remuneración variable", ""), !(0==AV44TFConVariable_Sel), (short)(0), GXutil.trim( GXutil.str( AV44TFConVariable_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONFOREDITABLE_SEL", httpContext.getMessage( "Editable (borrar)", ""), !(0==AV45TFConForEditable_Sel), (short)(0), GXutil.trim( GXutil.str( AV45TFConForEditable_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFTIPOCONCOD_SEL", httpContext.getMessage( "Tipo", ""), !(AV47TFTipoConCod_Sels.size()==0), (short)(0), AV47TFTipoConCod_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFSUBTIPOCONCOD1", httpContext.getMessage( "Clasificación", ""), !(GXutil.strcmp("", AV49TFSubTipoConCod1)==0), (short)(0), AV49TFSubTipoConCod1, "", !(AV50TFSubTipoConCod1_Sels.size()==0), AV50TFSubTipoConCod1_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFSUBTIPOCONCOD2", httpContext.getMessage( "Sub clasif.", ""), !(GXutil.strcmp("", AV52TFSubTipoConCod2)==0), (short)(0), AV52TFSubTipoConCod2, "", !(AV53TFSubTipoConCod2_Sels.size()==0), AV53TFSubTipoConCod2_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONTIPOLIQAUX", httpContext.getMessage( "Liq Aux", ""), !(GXutil.strcmp("", AV55TFConTipoLiqAux)==0), (short)(0), AV55TFConTipoLiqAux, "", !(AV56TFConTipoLiqAux_Sels.size()==0), AV56TFConTipoLiqAux_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONCLASIFAUX", httpContext.getMessage( "Clasificación", ""), !(GXutil.strcmp("", AV58TFConClasifAux)==0), (short)(0), AV58TFConClasifAux, "", !(AV59TFConClasifAux_Sels.size()==0), AV59TFConClasifAux_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONORDEJEC", httpContext.getMessage( "Ord Ejec", ""), !((0==AV60TFConOrdEjec)&&(0==AV61TFConOrdEjec_To)), (short)(0), GXutil.trim( GXutil.str( AV60TFConOrdEjec, 12, 0)), GXutil.trim( GXutil.str( AV61TFConOrdEjec_To, 12, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONRECALCULAR_SEL", httpContext.getMessage( "Recalcular por impuesto a las ganancias", ""), !(0==AV65TFConRecalcular_Sel), (short)(0), GXutil.trim( GXutil.str( AV65TFConRecalcular_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONRANGOCANT", httpContext.getMessage( "Rango de valores para cantidad", ""), !(GXutil.strcmp("", AV67TFConRangoCant)==0), (short)(0), AV67TFConRangoCant, "", !(AV68TFConRangoCant_Sels.size()==0), AV68TFConRangoCant_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONCONDICION_SEL", httpContext.getMessage( "Condición para liquidación", ""), !(AV70TFConCondicion_Sels.size()==0), (short)(0), AV70TFConCondicion_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONCONDCODIGO", httpContext.getMessage( "Código relacionado a la condición", ""), !(GXutil.strcmp("", AV72TFConCondCodigo)==0), (short)(0), AV72TFConCondCodigo, "", !(AV73TFConCondCodigo_Sels.size()==0), AV73TFConCondCodigo_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONMOSTRARPOS_SEL", httpContext.getMessage( "Mostrar en recibo solo si es mayor a cero", ""), !(0==AV74TFConMostrarPos_Sel), (short)(0), GXutil.trim( GXutil.str( AV74TFConMostrarPos_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONADELDESCU_SEL", httpContext.getMessage( "Adelanto/Descuento", ""), !(AV76TFConAdelDescu_Sels.size()==0), (short)(0), AV76TFConAdelDescu_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFAPLIIGG", httpContext.getMessage( "Tratamiento IIGG Nro", ""), !((0==AV77TFAplIIGG)&&(0==AV78TFAplIIGG_To)), (short)(0), GXutil.trim( GXutil.str( AV77TFAplIIGG, 4, 0)), GXutil.trim( GXutil.str( AV78TFAplIIGG_To, 4, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONSEGUNPLA_SEL", httpContext.getMessage( "Si no se cumple la condición, liquidar en segundo plano a posteriori", ""), !(0==AV79TFConSegunPla_Sel), (short)(0), GXutil.trim( GXutil.str( AV79TFConSegunPla_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONCODAFIP", httpContext.getMessage( "Concepto AFIP", ""), !(GXutil.strcmp("", AV92TFConCodAfip)==0), (short)(0), AV92TFConCodAfip, "", !(AV93TFConCodAfip_Sels.size()==0), AV93TFConCodAfip_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONSIPAAPO", httpContext.getMessage( "SIPAApo", ""), !((0==AV94TFConSIPAApo)&&(0==AV95TFConSIPAApo_To)), (short)(0), GXutil.trim( GXutil.str( AV94TFConSIPAApo, 1, 0)), GXutil.trim( GXutil.str( AV95TFConSIPAApo_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONSIPACONT", httpContext.getMessage( "SIPACont", ""), !((0==AV96TFConSIPACont)&&(0==AV97TFConSIPACont_To)), (short)(0), GXutil.trim( GXutil.str( AV96TFConSIPACont, 1, 0)), GXutil.trim( GXutil.str( AV97TFConSIPACont_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONINSSJYPAPO", httpContext.getMessage( "INSSJy PApo", ""), !((0==AV98TFConINSSJyPApo)&&(0==AV99TFConINSSJyPApo_To)), (short)(0), GXutil.trim( GXutil.str( AV98TFConINSSJyPApo, 1, 0)), GXutil.trim( GXutil.str( AV99TFConINSSJyPApo_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONINSSJYPCONT", httpContext.getMessage( "INSSJy PCont", ""), !((0==AV100TFConINSSJyPCont)&&(0==AV101TFConINSSJyPCont_To)), (short)(0), GXutil.trim( GXutil.str( AV100TFConINSSJyPCont, 1, 0)), GXutil.trim( GXutil.str( AV101TFConINSSJyPCont_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONOBRASOCAPO", httpContext.getMessage( "Soc Apo", ""), !((0==AV102TFConObraSocApo)&&(0==AV103TFConObraSocApo_To)), (short)(0), GXutil.trim( GXutil.str( AV102TFConObraSocApo, 1, 0)), GXutil.trim( GXutil.str( AV103TFConObraSocApo_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONOBRASOCCONT", httpContext.getMessage( "Soc Cont", ""), !((0==AV104TFConObraSocCont)&&(0==AV105TFConObraSocCont_To)), (short)(0), GXutil.trim( GXutil.str( AV104TFConObraSocCont, 1, 0)), GXutil.trim( GXutil.str( AV105TFConObraSocCont_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONFONSOLREDAPO", httpContext.getMessage( "Red Apo", ""), !((0==AV106TFConFonSolRedApo)&&(0==AV107TFConFonSolRedApo_To)), (short)(0), GXutil.trim( GXutil.str( AV106TFConFonSolRedApo, 1, 0)), GXutil.trim( GXutil.str( AV107TFConFonSolRedApo_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONFONSOLREDCONT", httpContext.getMessage( "Red Cont", ""), !((0==AV108TFConFonSolRedCont)&&(0==AV109TFConFonSolRedCont_To)), (short)(0), GXutil.trim( GXutil.str( AV108TFConFonSolRedCont, 1, 0)), GXutil.trim( GXutil.str( AV109TFConFonSolRedCont_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONRENATEAAPO", httpContext.getMessage( "Renatea Apo", ""), !((0==AV110TFConRenateaApo)&&(0==AV111TFConRenateaApo_To)), (short)(0), GXutil.trim( GXutil.str( AV110TFConRenateaApo, 1, 0)), GXutil.trim( GXutil.str( AV111TFConRenateaApo_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONRENATEACONT", httpContext.getMessage( "Renatea Cont", ""), !((0==AV112TFConRenateaCont)&&(0==AV113TFConRenateaCont_To)), (short)(0), GXutil.trim( GXutil.str( AV112TFConRenateaCont, 1, 0)), GXutil.trim( GXutil.str( AV113TFConRenateaCont_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONASIGFAMCONT", httpContext.getMessage( "Fam Cont", ""), !((0==AV114TFConAsigFamCont)&&(0==AV115TFConAsigFamCont_To)), (short)(0), GXutil.trim( GXutil.str( AV114TFConAsigFamCont, 1, 0)), GXutil.trim( GXutil.str( AV115TFConAsigFamCont_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONFONNACEMPCONT", httpContext.getMessage( "Emp Cont", ""), !((0==AV116TFConFonNacEmpCont)&&(0==AV117TFConFonNacEmpCont_To)), (short)(0), GXutil.trim( GXutil.str( AV116TFConFonNacEmpCont, 1, 0)), GXutil.trim( GXutil.str( AV117TFConFonNacEmpCont_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONLEYRIETRABCONT", httpContext.getMessage( "Trab Cont", ""), !((0==AV118TFConLeyRieTrabCont)&&(0==AV119TFConLeyRieTrabCont_To)), (short)(0), GXutil.trim( GXutil.str( AV118TFConLeyRieTrabCont, 1, 0)), GXutil.trim( GXutil.str( AV119TFConLeyRieTrabCont_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONREGDIFAPO", httpContext.getMessage( "Dif Apo", ""), !((0==AV120TFConRegDifApo)&&(0==AV121TFConRegDifApo_To)), (short)(0), GXutil.trim( GXutil.str( AV120TFConRegDifApo, 1, 0)), GXutil.trim( GXutil.str( AV121TFConRegDifApo_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONREGESPAPO", httpContext.getMessage( "Esp Apo", ""), !((0==AV122TFConRegEspApo)&&(0==AV123TFConRegEspApo_To)), (short)(0), GXutil.trim( GXutil.str( AV122TFConRegEspApo, 1, 0)), GXutil.trim( GXutil.str( AV123TFConRegEspApo_To, 1, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONCEPTOPAIS", httpContext.getMessage( "Pais", ""), !((0==AV126TFConceptoPais)&&(0==AV127TFConceptoPais_To)), (short)(0), GXutil.trim( GXutil.str( AV126TFConceptoPais, 4, 0)), GXutil.trim( GXutil.str( AV127TFConceptoPais_To, 4, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONCEPTOCONVECODIGO", httpContext.getMessage( "Convenio", ""), !(GXutil.strcmp("", AV129TFConceptoConveCodigo)==0), (short)(0), AV129TFConceptoConveCodigo, "", !(AV130TFConceptoConveCodigo_Sels.size()==0), AV130TFConceptoConveCodigo_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONBASELICPROM_SEL", httpContext.getMessage( "Base de cálculo para licencias de remuneración promedio variable", ""), !(AV138TFConBaseLicProm_Sels.size()==0), (short)(0), AV138TFConBaseLicProm_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONBASEFERPROM_SEL", httpContext.getMessage( "Base de cálculo para feriados de remuneración promedio variable", ""), !(AV140TFConBaseFerProm_Sels.size()==0), (short)(0), AV140TFConBaseFerProm_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONBASEHOREXTPROM_SEL", httpContext.getMessage( "Base de cálculo para horas extras de remuneración promedio variable", ""), !(AV142TFConBaseHorExtProm_Sels.size()==0), (short)(0), AV142TFConBaseHorExtProm_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONBASEPRES_SEL", httpContext.getMessage( "Base de cálculo para presentismo", ""), !(AV144TFConBasePres_Sels.size()==0), (short)(0), AV144TFConBasePres_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONBASEANT_SEL", httpContext.getMessage( "Base de cálculo para antiguedad", ""), !(AV146TFConBaseAnt_Sels.size()==0), (short)(0), AV146TFConBaseAnt_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONBASEOSDIF_SEL", httpContext.getMessage( "Base de cálculo para obra social diferencial", ""), !(AV148TFConBaseOSDif_Sels.size()==0), (short)(0), AV148TFConBaseOSDif_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONERRORSICERO_SEL", httpContext.getMessage( "Dar error si el concepto se calcula en cero", ""), !(0==AV149TFConErrorSiCero_Sel), (short)(0), GXutil.trim( GXutil.str( AV149TFConErrorSiCero_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCLIPADRE", httpContext.getMessage( "Padre", ""), !((0==AV150TFCliPadre)&&(0==AV151TFCliPadre_To)), (short)(0), GXutil.trim( GXutil.str( AV150TFCliPadre, 6, 0)), GXutil.trim( GXutil.str( AV151TFCliPadre_To, 6, 0))) ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONPADRE", httpContext.getMessage( "Padre", ""), !(GXutil.strcmp("", AV153TFConPadre)==0), (short)(0), AV153TFConPadre, "", !(AV154TFConPadre_Sels.size()==0), AV154TFConPadre_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      GXv_SdtWWPGridState43[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState43, "TFCONPUENOV_SEL", httpContext.getMessage( "Se puede ingresar como novedad", ""), !(0==AV155TFConPueNov_Sel), (short)(0), GXutil.trim( GXutil.str( AV155TFConPueNov_Sel, 1, 0)), "") ;
      AV12GridState = GXv_SdtWWPGridState43[0] ;
      if ( ! (GXutil.strcmp("", AV159MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV159MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV183Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV183Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Conceptos_export" );
      AV23Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e20IB2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV161WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV159MenuOpcCod, GXv_boolean8) ;
         GXv_char42[0] = AV163textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV87CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char42) ;
         conceptos_exportww_impl.this.AV163textoNoMostrara = GXv_char42[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV163textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV159MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_IB2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_IB2( true) ;
      }
      else
      {
         wb_table2_12_IB2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_IB2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_IB2e( true) ;
      }
      else
      {
         wb_table1_9_IB2e( false) ;
      }
   }

   public void wb_table2_12_IB2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e24ib1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_Conceptos_exportWW.htm");
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
         AV167WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV167WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV182Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV167WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV167WelcomeMessage_Foto)==0) ? AV182Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV167WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV167WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Conceptos_exportWW.htm");
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
         wb_table3_30_IB2( true) ;
      }
      else
      {
         wb_table3_30_IB2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_IB2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_IB2( true) ;
      }
      else
      {
         wb_table4_35_IB2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_IB2e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV161WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_Conceptos_exportWW.htm");
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
         wb_table5_54_IB2( true) ;
      }
      else
      {
         wb_table5_54_IB2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_IB2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_IB2( true) ;
      }
      else
      {
         wb_table6_63_IB2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_IB2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV82GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV83GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV84GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_IB2e( true) ;
      }
      else
      {
         wb_table2_12_IB2e( false) ;
      }
   }

   public void wb_table6_63_IB2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Conceptos_exportWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_Conceptos_exportWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV80DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV21ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV168ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Conceptos_exportWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Conceptos_exportWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Conceptos_exportWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_Conceptos_exportWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_99_IB2( true) ;
      }
      else
      {
         wb_table7_99_IB2( false) ;
      }
      return  ;
   }

   public void wb_table7_99_IB2e( boolean wbgen )
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
         wb_table6_63_IB2e( true) ;
      }
      else
      {
         wb_table6_63_IB2e( false) ;
      }
   }

   public void wb_table7_99_IB2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_Conceptos_exportWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_99_IB2e( true) ;
      }
      else
      {
         wb_table7_99_IB2e( false) ;
      }
   }

   public void wb_table5_54_IB2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_Conceptos_exportWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_Conceptos_exportWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_IB2e( true) ;
      }
      else
      {
         wb_table5_54_IB2e( false) ;
      }
   }

   public void wb_table4_35_IB2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_Conceptos_exportWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_IB2e( true) ;
      }
      else
      {
         wb_table4_35_IB2e( false) ;
      }
   }

   public void wb_table3_30_IB2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_Conceptos_exportWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_IB2e( true) ;
      }
      else
      {
         wb_table3_30_IB2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV159MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV159MenuOpcCod", AV159MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV159MenuOpcCod, ""))));
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
      paIB2( ) ;
      wsIB2( ) ;
      weIB2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713293628", true, true);
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
      httpContext.AddJavascriptSource("conceptos_exportww.js", "?20251713293629", false, true);
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
      edtConCodigo_Internalname = "CONCODIGO_"+sGXsfl_110_idx ;
      edtConDescrip_Internalname = "CONDESCRIP_"+sGXsfl_110_idx ;
      edtConOrden_Internalname = "CONORDEN_"+sGXsfl_110_idx ;
      cmbConVigencia.setInternalname( "CONVIGENCIA_"+sGXsfl_110_idx );
      edtConLiqBasica_Internalname = "CONLIQBASICA_"+sGXsfl_110_idx ;
      edtConFormula_Internalname = "CONFORMULA_"+sGXsfl_110_idx ;
      edtConObservacion_Internalname = "CONOBSERVACION_"+sGXsfl_110_idx ;
      chkConVariable.setInternalname( "CONVARIABLE_"+sGXsfl_110_idx );
      chkConForEditable.setInternalname( "CONFOREDITABLE_"+sGXsfl_110_idx );
      cmbTipoConCod.setInternalname( "TIPOCONCOD_"+sGXsfl_110_idx );
      edtSubTipoConCod1_Internalname = "SUBTIPOCONCOD1_"+sGXsfl_110_idx ;
      edtSubTipoConCod2_Internalname = "SUBTIPOCONCOD2_"+sGXsfl_110_idx ;
      edtConTipoLiqAux_Internalname = "CONTIPOLIQAUX_"+sGXsfl_110_idx ;
      edtConClasifAux_Internalname = "CONCLASIFAUX_"+sGXsfl_110_idx ;
      edtConOrdEjec_Internalname = "CONORDEJEC_"+sGXsfl_110_idx ;
      chkConRecalcular.setInternalname( "CONRECALCULAR_"+sGXsfl_110_idx );
      edtConRangoCant_Internalname = "CONRANGOCANT_"+sGXsfl_110_idx ;
      cmbConCondicion.setInternalname( "CONCONDICION_"+sGXsfl_110_idx );
      edtConCondCodigo_Internalname = "CONCONDCODIGO_"+sGXsfl_110_idx ;
      chkConMostrarPos.setInternalname( "CONMOSTRARPOS_"+sGXsfl_110_idx );
      cmbConAdelDescu.setInternalname( "CONADELDESCU_"+sGXsfl_110_idx );
      edtAplIIGG_Internalname = "APLIIGG_"+sGXsfl_110_idx ;
      chkConSegunPla.setInternalname( "CONSEGUNPLA_"+sGXsfl_110_idx );
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_110_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_110_idx ;
      edtConCodAfip_Internalname = "CONCODAFIP_"+sGXsfl_110_idx ;
      edtConSIPAApo_Internalname = "CONSIPAAPO_"+sGXsfl_110_idx ;
      edtConSIPACont_Internalname = "CONSIPACONT_"+sGXsfl_110_idx ;
      edtConINSSJyPApo_Internalname = "CONINSSJYPAPO_"+sGXsfl_110_idx ;
      edtConINSSJyPCont_Internalname = "CONINSSJYPCONT_"+sGXsfl_110_idx ;
      edtConObraSocApo_Internalname = "CONOBRASOCAPO_"+sGXsfl_110_idx ;
      edtConObraSocCont_Internalname = "CONOBRASOCCONT_"+sGXsfl_110_idx ;
      edtConFonSolRedApo_Internalname = "CONFONSOLREDAPO_"+sGXsfl_110_idx ;
      edtConFonSolRedCont_Internalname = "CONFONSOLREDCONT_"+sGXsfl_110_idx ;
      edtConRenateaApo_Internalname = "CONRENATEAAPO_"+sGXsfl_110_idx ;
      edtConRenateaCont_Internalname = "CONRENATEACONT_"+sGXsfl_110_idx ;
      edtConAsigFamCont_Internalname = "CONASIGFAMCONT_"+sGXsfl_110_idx ;
      edtConFonNacEmpCont_Internalname = "CONFONNACEMPCONT_"+sGXsfl_110_idx ;
      edtConLeyRieTrabCont_Internalname = "CONLEYRIETRABCONT_"+sGXsfl_110_idx ;
      edtConRegDifApo_Internalname = "CONREGDIFAPO_"+sGXsfl_110_idx ;
      edtConRegEspApo_Internalname = "CONREGESPAPO_"+sGXsfl_110_idx ;
      cmbConSacDeven.setInternalname( "CONSACDEVEN_"+sGXsfl_110_idx );
      edtConceptoPais_Internalname = "CONCEPTOPAIS_"+sGXsfl_110_idx ;
      edtConceptoConveCodigo_Internalname = "CONCEPTOCONVECODIGO_"+sGXsfl_110_idx ;
      cmbConBaseLic.setInternalname( "CONBASELIC_"+sGXsfl_110_idx );
      cmbConBaseLicProm.setInternalname( "CONBASELICPROM_"+sGXsfl_110_idx );
      cmbConBaseFer.setInternalname( "CONBASEFER_"+sGXsfl_110_idx );
      cmbConBaseFerProm.setInternalname( "CONBASEFERPROM_"+sGXsfl_110_idx );
      cmbConBaseHorExt.setInternalname( "CONBASEHOREXT_"+sGXsfl_110_idx );
      cmbConBaseHorExtProm.setInternalname( "CONBASEHOREXTPROM_"+sGXsfl_110_idx );
      cmbConBasePres.setInternalname( "CONBASEPRES_"+sGXsfl_110_idx );
      cmbConBaseAnt.setInternalname( "CONBASEANT_"+sGXsfl_110_idx );
      cmbConBaseOSDif.setInternalname( "CONBASEOSDIF_"+sGXsfl_110_idx );
      chkConErrorSiCero.setInternalname( "CONERRORSICERO_"+sGXsfl_110_idx );
      edtCliPadre_Internalname = "CLIPADRE_"+sGXsfl_110_idx ;
      edtConPadre_Internalname = "CONPADRE_"+sGXsfl_110_idx ;
      chkConPueNov.setInternalname( "CONPUENOV_"+sGXsfl_110_idx );
   }

   public void subsflControlProps_fel_1102( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_110_fel_idx ;
      edtConCodigo_Internalname = "CONCODIGO_"+sGXsfl_110_fel_idx ;
      edtConDescrip_Internalname = "CONDESCRIP_"+sGXsfl_110_fel_idx ;
      edtConOrden_Internalname = "CONORDEN_"+sGXsfl_110_fel_idx ;
      cmbConVigencia.setInternalname( "CONVIGENCIA_"+sGXsfl_110_fel_idx );
      edtConLiqBasica_Internalname = "CONLIQBASICA_"+sGXsfl_110_fel_idx ;
      edtConFormula_Internalname = "CONFORMULA_"+sGXsfl_110_fel_idx ;
      edtConObservacion_Internalname = "CONOBSERVACION_"+sGXsfl_110_fel_idx ;
      chkConVariable.setInternalname( "CONVARIABLE_"+sGXsfl_110_fel_idx );
      chkConForEditable.setInternalname( "CONFOREDITABLE_"+sGXsfl_110_fel_idx );
      cmbTipoConCod.setInternalname( "TIPOCONCOD_"+sGXsfl_110_fel_idx );
      edtSubTipoConCod1_Internalname = "SUBTIPOCONCOD1_"+sGXsfl_110_fel_idx ;
      edtSubTipoConCod2_Internalname = "SUBTIPOCONCOD2_"+sGXsfl_110_fel_idx ;
      edtConTipoLiqAux_Internalname = "CONTIPOLIQAUX_"+sGXsfl_110_fel_idx ;
      edtConClasifAux_Internalname = "CONCLASIFAUX_"+sGXsfl_110_fel_idx ;
      edtConOrdEjec_Internalname = "CONORDEJEC_"+sGXsfl_110_fel_idx ;
      chkConRecalcular.setInternalname( "CONRECALCULAR_"+sGXsfl_110_fel_idx );
      edtConRangoCant_Internalname = "CONRANGOCANT_"+sGXsfl_110_fel_idx ;
      cmbConCondicion.setInternalname( "CONCONDICION_"+sGXsfl_110_fel_idx );
      edtConCondCodigo_Internalname = "CONCONDCODIGO_"+sGXsfl_110_fel_idx ;
      chkConMostrarPos.setInternalname( "CONMOSTRARPOS_"+sGXsfl_110_fel_idx );
      cmbConAdelDescu.setInternalname( "CONADELDESCU_"+sGXsfl_110_fel_idx );
      edtAplIIGG_Internalname = "APLIIGG_"+sGXsfl_110_fel_idx ;
      chkConSegunPla.setInternalname( "CONSEGUNPLA_"+sGXsfl_110_fel_idx );
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_110_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_110_fel_idx ;
      edtConCodAfip_Internalname = "CONCODAFIP_"+sGXsfl_110_fel_idx ;
      edtConSIPAApo_Internalname = "CONSIPAAPO_"+sGXsfl_110_fel_idx ;
      edtConSIPACont_Internalname = "CONSIPACONT_"+sGXsfl_110_fel_idx ;
      edtConINSSJyPApo_Internalname = "CONINSSJYPAPO_"+sGXsfl_110_fel_idx ;
      edtConINSSJyPCont_Internalname = "CONINSSJYPCONT_"+sGXsfl_110_fel_idx ;
      edtConObraSocApo_Internalname = "CONOBRASOCAPO_"+sGXsfl_110_fel_idx ;
      edtConObraSocCont_Internalname = "CONOBRASOCCONT_"+sGXsfl_110_fel_idx ;
      edtConFonSolRedApo_Internalname = "CONFONSOLREDAPO_"+sGXsfl_110_fel_idx ;
      edtConFonSolRedCont_Internalname = "CONFONSOLREDCONT_"+sGXsfl_110_fel_idx ;
      edtConRenateaApo_Internalname = "CONRENATEAAPO_"+sGXsfl_110_fel_idx ;
      edtConRenateaCont_Internalname = "CONRENATEACONT_"+sGXsfl_110_fel_idx ;
      edtConAsigFamCont_Internalname = "CONASIGFAMCONT_"+sGXsfl_110_fel_idx ;
      edtConFonNacEmpCont_Internalname = "CONFONNACEMPCONT_"+sGXsfl_110_fel_idx ;
      edtConLeyRieTrabCont_Internalname = "CONLEYRIETRABCONT_"+sGXsfl_110_fel_idx ;
      edtConRegDifApo_Internalname = "CONREGDIFAPO_"+sGXsfl_110_fel_idx ;
      edtConRegEspApo_Internalname = "CONREGESPAPO_"+sGXsfl_110_fel_idx ;
      cmbConSacDeven.setInternalname( "CONSACDEVEN_"+sGXsfl_110_fel_idx );
      edtConceptoPais_Internalname = "CONCEPTOPAIS_"+sGXsfl_110_fel_idx ;
      edtConceptoConveCodigo_Internalname = "CONCEPTOCONVECODIGO_"+sGXsfl_110_fel_idx ;
      cmbConBaseLic.setInternalname( "CONBASELIC_"+sGXsfl_110_fel_idx );
      cmbConBaseLicProm.setInternalname( "CONBASELICPROM_"+sGXsfl_110_fel_idx );
      cmbConBaseFer.setInternalname( "CONBASEFER_"+sGXsfl_110_fel_idx );
      cmbConBaseFerProm.setInternalname( "CONBASEFERPROM_"+sGXsfl_110_fel_idx );
      cmbConBaseHorExt.setInternalname( "CONBASEHOREXT_"+sGXsfl_110_fel_idx );
      cmbConBaseHorExtProm.setInternalname( "CONBASEHOREXTPROM_"+sGXsfl_110_fel_idx );
      cmbConBasePres.setInternalname( "CONBASEPRES_"+sGXsfl_110_fel_idx );
      cmbConBaseAnt.setInternalname( "CONBASEANT_"+sGXsfl_110_fel_idx );
      cmbConBaseOSDif.setInternalname( "CONBASEOSDIF_"+sGXsfl_110_fel_idx );
      chkConErrorSiCero.setInternalname( "CONERRORSICERO_"+sGXsfl_110_fel_idx );
      edtCliPadre_Internalname = "CLIPADRE_"+sGXsfl_110_fel_idx ;
      edtConPadre_Internalname = "CONPADRE_"+sGXsfl_110_fel_idx ;
      chkConPueNov.setInternalname( "CONPUENOV_"+sGXsfl_110_fel_idx );
   }

   public void sendrow_1102( )
   {
      subsflControlProps_1102( ) ;
      wbIB0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtCliCod_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCliCod_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConCodigo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConCodigo_Internalname,GXutil.rtrim( A26ConCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConCodigo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConDescrip_Internalname,A41ConDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConOrden_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConOrden_Internalname,GXutil.ltrim( localUtil.ntoc( A40ConOrden, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A40ConOrden), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConOrden_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConOrden_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConVigencia.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConVigencia.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONVIGENCIA_" + sGXsfl_110_idx ;
            cmbConVigencia.setName( GXCCtl );
            cmbConVigencia.setWebtags( "" );
            cmbConVigencia.addItem("0", httpContext.getMessage( "Automática", ""), (short)(0));
            cmbConVigencia.addItem("1", httpContext.getMessage( "Por Novedad", ""), (short)(0));
            if ( cmbConVigencia.getItemCount() > 0 )
            {
               A162ConVigencia = (byte)(GXutil.lval( cmbConVigencia.getValidValue(GXutil.trim( GXutil.str( A162ConVigencia, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConVigencia,cmbConVigencia.getInternalname(),GXutil.trim( GXutil.str( A162ConVigencia, 1, 0)),Integer.valueOf(1),cmbConVigencia.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConVigencia.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConVigencia.setValue( GXutil.trim( GXutil.str( A162ConVigencia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConVigencia.getInternalname(), "Values", cmbConVigencia.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConLiqBasica_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConLiqBasica_Internalname,GXutil.ltrim( localUtil.ntoc( A1488ConLiqBasica, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1488ConLiqBasica), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConLiqBasica_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConLiqBasica_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConFormula_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConFormula_Internalname,A148ConFormula,A148ConFormula,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConFormula_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConFormula_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"Obs","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConObservacion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConObservacion_Internalname,A153ConObservacion,A153ConObservacion,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConObservacion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConObservacion_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConVariable.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONVARIABLE_" + sGXsfl_110_idx ;
         chkConVariable.setName( GXCCtl );
         chkConVariable.setWebtags( "" );
         chkConVariable.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "TitleCaption", chkConVariable.getCaption(), !bGXsfl_110_Refreshing);
         chkConVariable.setCheckedValue( "false" );
         A159ConVariable = GXutil.strtobool( GXutil.booltostr( A159ConVariable)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConVariable.getInternalname(),GXutil.booltostr( A159ConVariable),"","",Integer.valueOf(chkConVariable.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConForEditable.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONFOREDITABLE_" + sGXsfl_110_idx ;
         chkConForEditable.setName( GXCCtl );
         chkConForEditable.setWebtags( "" );
         chkConForEditable.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConForEditable.getInternalname(), "TitleCaption", chkConForEditable.getCaption(), !bGXsfl_110_Refreshing);
         chkConForEditable.setCheckedValue( "false" );
         A146ConForEditable = GXutil.strtobool( GXutil.booltostr( A146ConForEditable)) ;
         n146ConForEditable = false ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConForEditable.getInternalname(),GXutil.booltostr( A146ConForEditable),"","",Integer.valueOf(chkConForEditable.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbTipoConCod.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbTipoConCod.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "TIPOCONCOD_" + sGXsfl_110_idx ;
            cmbTipoConCod.setName( GXCCtl );
            cmbTipoConCod.setWebtags( "" );
            cmbTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
            cmbTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
            cmbTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
            cmbTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
            if ( cmbTipoConCod.getItemCount() > 0 )
            {
               A37TipoConCod = cmbTipoConCod.getValidValue(A37TipoConCod) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbTipoConCod,cmbTipoConCod.getInternalname(),GXutil.rtrim( A37TipoConCod),Integer.valueOf(1),cmbTipoConCod.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbTipoConCod.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbTipoConCod.setValue( GXutil.rtrim( A37TipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Values", cmbTipoConCod.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSubTipoConCod1_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSubTipoConCod1_Internalname,GXutil.rtrim( A38SubTipoConCod1),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSubTipoConCod1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSubTipoConCod1_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSubTipoConCod2_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSubTipoConCod2_Internalname,GXutil.rtrim( A39SubTipoConCod2),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSubTipoConCod2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSubTipoConCod2_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConTipoLiqAux_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConTipoLiqAux_Internalname,A503ConTipoLiqAux,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConTipoLiqAux_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConTipoLiqAux_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConClasifAux_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConClasifAux_Internalname,A970ConClasifAux,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConClasifAux_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConClasifAux_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConOrdEjec_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConOrdEjec_Internalname,GXutil.ltrim( localUtil.ntoc( A510ConOrdEjec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A510ConOrdEjec), "ZZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConOrdEjec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConOrdEjec_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(12),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConRecalcular.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONRECALCULAR_" + sGXsfl_110_idx ;
         chkConRecalcular.setName( GXCCtl );
         chkConRecalcular.setWebtags( "" );
         chkConRecalcular.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConRecalcular.getInternalname(), "TitleCaption", chkConRecalcular.getCaption(), !bGXsfl_110_Refreshing);
         chkConRecalcular.setCheckedValue( "false" );
         A762ConRecalcular = GXutil.strtobool( GXutil.booltostr( A762ConRecalcular)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConRecalcular.getInternalname(),GXutil.booltostr( A762ConRecalcular),"","",Integer.valueOf(chkConRecalcular.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConRangoCant_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConRangoCant_Internalname,A1018ConRangoCant,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConRangoCant_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConRangoCant_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbConCondicion.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConCondicion.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONCONDICION_" + sGXsfl_110_idx ;
            cmbConCondicion.setName( GXCCtl );
            cmbConCondicion.setWebtags( "" );
            cmbConCondicion.addItem("A0", httpContext.getMessage( "Siempre", ""), (short)(0));
            cmbConCondicion.addItem("A1", httpContext.getMessage( "Se ingresó por novedad el concepto de código relacionado a la condición", ""), (short)(0));
            cmbConCondicion.addItem("A3", httpContext.getMessage( "Trabajador no es Jubilado y aplica a liquidación de aportes", ""), (short)(0));
            cmbConCondicion.addItem("A4", httpContext.getMessage( "Resultado de la suma de conceptos agregados en liquidación anterior con la misma clasificación sea mayor a cerO, y que el concepto de la liquidación anterior tenga asignado tipo de liquidación igual al código relacionado a la condición de este concepto", ""), (short)(0));
            cmbConCondicion.addItem("A5", httpContext.getMessage( "Es alcanzado por ganancias y calcula adelanto de retención (parámetro)", ""), (short)(0));
            cmbConCondicion.addItem("A8", httpContext.getMessage( "Legajo tiene saldo distinto de cero en DDJJ F1357 del año anterior", ""), (short)(0));
            cmbConCondicion.addItem("A9", httpContext.getMessage( "Tiene familiares adherentes a la obra social", ""), (short)(0));
            cmbConCondicion.addItem("A10", httpContext.getMessage( "Tiene Sindicato", ""), (short)(0));
            cmbConCondicion.addItem("A11", httpContext.getMessage( "Tiene jornada parcial", ""), (short)(0));
            cmbConCondicion.addItem("A12", httpContext.getMessage( "Obra social tiene aporte adicional", ""), (short)(0));
            cmbConCondicion.addItem("A13", httpContext.getMessage( "Empleador es agente de retención", ""), (short)(0));
            cmbConCondicion.addItem("A14", httpContext.getMessage( "El empleador es agente de retención y el empleado es alcanzado por ganancias", ""), (short)(0));
            cmbConCondicion.addItem("B1", httpContext.getMessage( "Legajo tiene cargado licencia igual al código  relacionado a la condición", ""), (short)(0));
            cmbConCondicion.addItem("B2", httpContext.getMessage( "Legajo tiene cargado SIRADIG de igual código  relacionado a la condición", ""), (short)(0));
            cmbConCondicion.addItem("B3", httpContext.getMessage( "Tiene obligación activa de igual al código relacionado a la condición", ""), (short)(0));
            cmbConCondicion.addItem("B4", httpContext.getMessage( "Hay licencias o feriados con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
            cmbConCondicion.addItem("B5", httpContext.getMessage( "Hay feriado no trabajado, y la empresa está configurada para exponer los feriados", ""), (short)(0));
            cmbConCondicion.addItem("B6", httpContext.getMessage( "Hay día no laborable em periodo, y la empresa está configurada para exponer los feriados", ""), (short)(0));
            cmbConCondicion.addItem("B7", httpContext.getMessage( "El legajo es empleado mensual y hay licencia sin goce de sueldo", ""), (short)(0));
            cmbConCondicion.addItem("B9", httpContext.getMessage( "Es egreso y no maneja fondo de cese laboral", ""), (short)(0));
            cmbConCondicion.addItem("B10", httpContext.getMessage( "Tipo de liquidación, mes de liquidación, y marca de SAC en alta de liquidación son compatibles con la liquidación del SAC.", ""), (short)(0));
            cmbConCondicion.addItem("B11", httpContext.getMessage( "Liquida sac o alcanza ganancias", ""), (short)(0));
            cmbConCondicion.addItem("B12", httpContext.getMessage( "Empresa o convenio liquidan antiguedad", ""), (short)(0));
            cmbConCondicion.addItem("B13", httpContext.getMessage( "Empresa o convenio liquidan presentismo", ""), (short)(0));
            cmbConCondicion.addItem("B14", httpContext.getMessage( "Legajo tiene cargado comprobante para reintegro igual al código relacionado a la condición", ""), (short)(0));
            cmbConCondicion.addItem("B15", httpContext.getMessage( "Legajo tiene cargado hijo o hija con asignación de servicio de guardería", ""), (short)(0));
            cmbConCondicion.addItem("N01", httpContext.getMessage( "Nunca  (Calcular siempre en segundo plano luego de generar el recibo)", ""), (short)(0));
            cmbConCondicion.addItem("B16", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\", de frecuencia mensual y el concepto no fué previamente liquidado en el mismo periodo", ""), (short)(0));
            cmbConCondicion.addItem("B19", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado vacaciones y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
            cmbConCondicion.addItem("B20", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado días de licencia (distinta a vacaciones) y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
            cmbConCondicion.addItem("B21", httpContext.getMessage( "Legajo es empleado mensual, hay feriado no trabajado y la empresa está configurada para exponer los feriados y no proratear el sueldo", ""), (short)(0));
            cmbConCondicion.addItem("B22", httpContext.getMessage( "Legajo es empleado mensual, hay día no laborable no trabajado y la empresa está configurada para exponer los feriados y no prorratear el sueldo", ""), (short)(0));
            cmbConCondicion.addItem("B23", httpContext.getMessage( "Legajo tiene asignado tìtulo igual al código relacionado a la condición", ""), (short)(0));
            cmbConCondicion.addItem("B24", httpContext.getMessage( "Parametro para desglosar adicional está activado, legajo está en convenio y su categoría tiene adicional por zona desfavorable", ""), (short)(0));
            cmbConCondicion.addItem("VP", httpContext.getMessage( "Hay vacaciones con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
            cmbConCondicion.addItem("AI", httpContext.getMessage( "Legajo es de clase mensual y tiene cargadas ausencias injustificadas", ""), (short)(0));
            cmbConCondicion.addItem("R1", httpContext.getMessage( "Forma de pago es distinta a transferencia o parámetro está configurado para liquidar siempre redondeo", ""), (short)(0));
            cmbConCondicion.addItem("MI", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\" de frecuencia mensual, empresa está configurada para no prorratear sueldo y fecha de ingreso es mayor al primero o fecha de egreso menor al último día del mes", ""), (short)(0));
            cmbConCondicion.addItem("H1", httpContext.getMessage( "Si liquidación es compatible con SAC liquidar como concepto principal, y si no liquidarlo como concepto auxiliar en segundo plano", ""), (short)(0));
            cmbConCondicion.addItem("LA", httpContext.getMessage( "Legajo aplica a liquidación de aportes", ""), (short)(0));
            cmbConCondicion.addItem("GU", httpContext.getMessage( "Legajo tiene configurado grossing up", ""), (short)(0));
            if ( cmbConCondicion.getItemCount() > 0 )
            {
               A953ConCondicion = cmbConCondicion.getValidValue(A953ConCondicion) ;
               n953ConCondicion = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConCondicion,cmbConCondicion.getInternalname(),GXutil.rtrim( A953ConCondicion),Integer.valueOf(1),cmbConCondicion.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbConCondicion.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConCondicion.setValue( GXutil.rtrim( A953ConCondicion) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Values", cmbConCondicion.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConCondCodigo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConCondCodigo_Internalname,GXutil.rtrim( A954ConCondCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConCondCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConCondCodigo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConMostrarPos.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONMOSTRARPOS_" + sGXsfl_110_idx ;
         chkConMostrarPos.setName( GXCCtl );
         chkConMostrarPos.setWebtags( "" );
         chkConMostrarPos.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConMostrarPos.getInternalname(), "TitleCaption", chkConMostrarPos.getCaption(), !bGXsfl_110_Refreshing);
         chkConMostrarPos.setCheckedValue( "false" );
         A1068ConMostrarPos = GXutil.strtobool( GXutil.booltostr( A1068ConMostrarPos)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConMostrarPos.getInternalname(),GXutil.booltostr( A1068ConMostrarPos),"","",Integer.valueOf(chkConMostrarPos.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConAdelDescu.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConAdelDescu.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONADELDESCU_" + sGXsfl_110_idx ;
            cmbConAdelDescu.setName( GXCCtl );
            cmbConAdelDescu.setWebtags( "" );
            cmbConAdelDescu.addItem(GXutil.trim( GXutil.str( 0, 1, 0)), httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
            cmbConAdelDescu.addItem("1", httpContext.getMessage( "Adelanto de mes próximo", ""), (short)(0));
            cmbConAdelDescu.addItem("2", httpContext.getMessage( "Descuento", ""), (short)(0));
            if ( cmbConAdelDescu.getItemCount() > 0 )
            {
               A1077ConAdelDescu = (byte)(GXutil.lval( cmbConAdelDescu.getValidValue(GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0))))) ;
               n1077ConAdelDescu = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConAdelDescu,cmbConAdelDescu.getInternalname(),GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0)),Integer.valueOf(1),cmbConAdelDescu.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConAdelDescu.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConAdelDescu.setValue( GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAdelDescu.getInternalname(), "Values", cmbConAdelDescu.ToJavascriptSource(), !bGXsfl_110_Refreshing);
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConSegunPla.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONSEGUNPLA_" + sGXsfl_110_idx ;
         chkConSegunPla.setName( GXCCtl );
         chkConSegunPla.setWebtags( "" );
         chkConSegunPla.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConSegunPla.getInternalname(), "TitleCaption", chkConSegunPla.getCaption(), !bGXsfl_110_Refreshing);
         chkConSegunPla.setCheckedValue( "false" );
         A1194ConSegunPla = GXutil.strtobool( GXutil.booltostr( A1194ConSegunPla)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConSegunPla.getInternalname(),GXutil.booltostr( A1194ConSegunPla),"","",Integer.valueOf(chkConSegunPla.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV158Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV157VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConCodAfip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConCodAfip_Internalname,GXutil.rtrim( A1648ConCodAfip),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConCodAfip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConCodAfip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConSIPAApo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConSIPAApo_Internalname,GXutil.ltrim( localUtil.ntoc( A1472ConSIPAApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1472ConSIPAApo), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConSIPAApo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConSIPAApo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConSIPACont_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConSIPACont_Internalname,GXutil.ltrim( localUtil.ntoc( A1473ConSIPACont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1473ConSIPACont), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConSIPACont_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConSIPACont_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConINSSJyPApo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConINSSJyPApo_Internalname,GXutil.ltrim( localUtil.ntoc( A1474ConINSSJyPApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1474ConINSSJyPApo), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConINSSJyPApo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConINSSJyPApo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConINSSJyPCont_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConINSSJyPCont_Internalname,GXutil.ltrim( localUtil.ntoc( A1475ConINSSJyPCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1475ConINSSJyPCont), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConINSSJyPCont_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConINSSJyPCont_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConObraSocApo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConObraSocApo_Internalname,GXutil.ltrim( localUtil.ntoc( A1476ConObraSocApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1476ConObraSocApo), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConObraSocApo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConObraSocApo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConObraSocCont_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConObraSocCont_Internalname,GXutil.ltrim( localUtil.ntoc( A1477ConObraSocCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1477ConObraSocCont), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConObraSocCont_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConObraSocCont_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConFonSolRedApo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConFonSolRedApo_Internalname,GXutil.ltrim( localUtil.ntoc( A1478ConFonSolRedApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1478ConFonSolRedApo), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConFonSolRedApo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConFonSolRedApo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConFonSolRedCont_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConFonSolRedCont_Internalname,GXutil.ltrim( localUtil.ntoc( A1479ConFonSolRedCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1479ConFonSolRedCont), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConFonSolRedCont_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConFonSolRedCont_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConRenateaApo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConRenateaApo_Internalname,GXutil.ltrim( localUtil.ntoc( A1480ConRenateaApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1480ConRenateaApo), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConRenateaApo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConRenateaApo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConRenateaCont_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConRenateaCont_Internalname,GXutil.ltrim( localUtil.ntoc( A1481ConRenateaCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1481ConRenateaCont), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConRenateaCont_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConRenateaCont_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConAsigFamCont_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConAsigFamCont_Internalname,GXutil.ltrim( localUtil.ntoc( A1482ConAsigFamCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1482ConAsigFamCont), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConAsigFamCont_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConAsigFamCont_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConFonNacEmpCont_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConFonNacEmpCont_Internalname,GXutil.ltrim( localUtil.ntoc( A1483ConFonNacEmpCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1483ConFonNacEmpCont), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConFonNacEmpCont_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConFonNacEmpCont_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConLeyRieTrabCont_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConLeyRieTrabCont_Internalname,GXutil.ltrim( localUtil.ntoc( A1484ConLeyRieTrabCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1484ConLeyRieTrabCont), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConLeyRieTrabCont_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConLeyRieTrabCont_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConRegDifApo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConRegDifApo_Internalname,GXutil.ltrim( localUtil.ntoc( A1485ConRegDifApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1485ConRegDifApo), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConRegDifApo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConRegDifApo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConRegEspApo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConRegEspApo_Internalname,GXutil.ltrim( localUtil.ntoc( A1486ConRegEspApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1486ConRegEspApo), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConRegEspApo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConRegEspApo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConSacDeven.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConSacDeven.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONSACDEVEN_" + sGXsfl_110_idx ;
            cmbConSacDeven.setName( GXCCtl );
            cmbConSacDeven.setWebtags( "" );
            cmbConSacDeven.addItem("0", httpContext.getMessage( "No aplica", ""), (short)(0));
            cmbConSacDeven.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
            cmbConSacDeven.addItem("3", httpContext.getMessage( "Trimestral", ""), (short)(0));
            cmbConSacDeven.addItem("4", httpContext.getMessage( "Cuatrimestral", ""), (short)(0));
            cmbConSacDeven.addItem("6", httpContext.getMessage( "Semestral", ""), (short)(0));
            cmbConSacDeven.addItem("12", httpContext.getMessage( "Anual", ""), (short)(0));
            if ( cmbConSacDeven.getItemCount() > 0 )
            {
               A1539ConSacDeven = (byte)(GXutil.lval( cmbConSacDeven.getValidValue(GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConSacDeven,cmbConSacDeven.getInternalname(),GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0)),Integer.valueOf(1),cmbConSacDeven.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConSacDeven.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConSacDeven.setValue( GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConSacDeven.getInternalname(), "Values", cmbConSacDeven.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConceptoPais_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConceptoPais_Internalname,GXutil.ltrim( localUtil.ntoc( A1644ConceptoPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1644ConceptoPais), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConceptoPais_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConceptoPais_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConceptoConveCodigo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConceptoConveCodigo_Internalname,GXutil.rtrim( A1645ConceptoConveCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConceptoConveCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConceptoConveCodigo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseLic.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseLic.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASELIC_" + sGXsfl_110_idx ;
            cmbConBaseLic.setName( GXCCtl );
            cmbConBaseLic.setWebtags( "" );
            cmbConBaseLic.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseLic.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseLic.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseLic.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseLic.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseLic.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseLic.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseLic.getItemCount() > 0 )
            {
               A1620ConBaseLic = (byte)(GXutil.lval( cmbConBaseLic.getValidValue(GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseLic,cmbConBaseLic.getInternalname(),GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0)),Integer.valueOf(1),cmbConBaseLic.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseLic.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseLic.setValue( GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseLic.getInternalname(), "Values", cmbConBaseLic.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseLicProm.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseLicProm.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASELICPROM_" + sGXsfl_110_idx ;
            cmbConBaseLicProm.setName( GXCCtl );
            cmbConBaseLicProm.setWebtags( "" );
            cmbConBaseLicProm.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseLicProm.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseLicProm.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseLicProm.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseLicProm.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseLicProm.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseLicProm.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseLicProm.getItemCount() > 0 )
            {
               A1797ConBaseLicProm = (byte)(GXutil.lval( cmbConBaseLicProm.getValidValue(GXutil.trim( GXutil.str( A1797ConBaseLicProm, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseLicProm,cmbConBaseLicProm.getInternalname(),GXutil.trim( GXutil.str( A1797ConBaseLicProm, 1, 0)),Integer.valueOf(1),cmbConBaseLicProm.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseLicProm.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseLicProm.setValue( GXutil.trim( GXutil.str( A1797ConBaseLicProm, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseLicProm.getInternalname(), "Values", cmbConBaseLicProm.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseFer.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseFer.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEFER_" + sGXsfl_110_idx ;
            cmbConBaseFer.setName( GXCCtl );
            cmbConBaseFer.setWebtags( "" );
            cmbConBaseFer.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseFer.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseFer.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseFer.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseFer.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseFer.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseFer.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseFer.getItemCount() > 0 )
            {
               A1621ConBaseFer = (byte)(GXutil.lval( cmbConBaseFer.getValidValue(GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseFer,cmbConBaseFer.getInternalname(),GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0)),Integer.valueOf(1),cmbConBaseFer.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseFer.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseFer.setValue( GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseFer.getInternalname(), "Values", cmbConBaseFer.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseFerProm.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseFerProm.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEFERPROM_" + sGXsfl_110_idx ;
            cmbConBaseFerProm.setName( GXCCtl );
            cmbConBaseFerProm.setWebtags( "" );
            cmbConBaseFerProm.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseFerProm.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseFerProm.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseFerProm.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseFerProm.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseFerProm.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseFerProm.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseFerProm.getItemCount() > 0 )
            {
               A1798ConBaseFerProm = (byte)(GXutil.lval( cmbConBaseFerProm.getValidValue(GXutil.trim( GXutil.str( A1798ConBaseFerProm, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseFerProm,cmbConBaseFerProm.getInternalname(),GXutil.trim( GXutil.str( A1798ConBaseFerProm, 1, 0)),Integer.valueOf(1),cmbConBaseFerProm.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseFerProm.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseFerProm.setValue( GXutil.trim( GXutil.str( A1798ConBaseFerProm, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseFerProm.getInternalname(), "Values", cmbConBaseFerProm.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseHorExt.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseHorExt.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEHOREXT_" + sGXsfl_110_idx ;
            cmbConBaseHorExt.setName( GXCCtl );
            cmbConBaseHorExt.setWebtags( "" );
            cmbConBaseHorExt.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseHorExt.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseHorExt.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseHorExt.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseHorExt.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseHorExt.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseHorExt.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseHorExt.getItemCount() > 0 )
            {
               A1622ConBaseHorExt = (byte)(GXutil.lval( cmbConBaseHorExt.getValidValue(GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseHorExt,cmbConBaseHorExt.getInternalname(),GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0)),Integer.valueOf(1),cmbConBaseHorExt.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseHorExt.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseHorExt.setValue( GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseHorExt.getInternalname(), "Values", cmbConBaseHorExt.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseHorExtProm.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseHorExtProm.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEHOREXTPROM_" + sGXsfl_110_idx ;
            cmbConBaseHorExtProm.setName( GXCCtl );
            cmbConBaseHorExtProm.setWebtags( "" );
            cmbConBaseHorExtProm.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseHorExtProm.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseHorExtProm.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseHorExtProm.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseHorExtProm.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseHorExtProm.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseHorExtProm.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseHorExtProm.getItemCount() > 0 )
            {
               A1799ConBaseHorExtProm = (byte)(GXutil.lval( cmbConBaseHorExtProm.getValidValue(GXutil.trim( GXutil.str( A1799ConBaseHorExtProm, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseHorExtProm,cmbConBaseHorExtProm.getInternalname(),GXutil.trim( GXutil.str( A1799ConBaseHorExtProm, 1, 0)),Integer.valueOf(1),cmbConBaseHorExtProm.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseHorExtProm.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseHorExtProm.setValue( GXutil.trim( GXutil.str( A1799ConBaseHorExtProm, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseHorExtProm.getInternalname(), "Values", cmbConBaseHorExtProm.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBasePres.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBasePres.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEPRES_" + sGXsfl_110_idx ;
            cmbConBasePres.setName( GXCCtl );
            cmbConBasePres.setWebtags( "" );
            cmbConBasePres.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBasePres.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBasePres.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBasePres.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBasePres.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBasePres.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBasePres.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBasePres.getItemCount() > 0 )
            {
               A1800ConBasePres = (byte)(GXutil.lval( cmbConBasePres.getValidValue(GXutil.trim( GXutil.str( A1800ConBasePres, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBasePres,cmbConBasePres.getInternalname(),GXutil.trim( GXutil.str( A1800ConBasePres, 1, 0)),Integer.valueOf(1),cmbConBasePres.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBasePres.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBasePres.setValue( GXutil.trim( GXutil.str( A1800ConBasePres, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBasePres.getInternalname(), "Values", cmbConBasePres.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseAnt.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseAnt.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEANT_" + sGXsfl_110_idx ;
            cmbConBaseAnt.setName( GXCCtl );
            cmbConBaseAnt.setWebtags( "" );
            cmbConBaseAnt.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseAnt.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
            cmbConBaseAnt.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
            cmbConBaseAnt.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
            cmbConBaseAnt.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
            cmbConBaseAnt.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
            cmbConBaseAnt.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
            if ( cmbConBaseAnt.getItemCount() > 0 )
            {
               A1801ConBaseAnt = (byte)(GXutil.lval( cmbConBaseAnt.getValidValue(GXutil.trim( GXutil.str( A1801ConBaseAnt, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseAnt,cmbConBaseAnt.getInternalname(),GXutil.trim( GXutil.str( A1801ConBaseAnt, 1, 0)),Integer.valueOf(1),cmbConBaseAnt.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseAnt.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseAnt.setValue( GXutil.trim( GXutil.str( A1801ConBaseAnt, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseAnt.getInternalname(), "Values", cmbConBaseAnt.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConBaseOSDif.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConBaseOSDif.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONBASEOSDIF_" + sGXsfl_110_idx ;
            cmbConBaseOSDif.setName( GXCCtl );
            cmbConBaseOSDif.setWebtags( "" );
            cmbConBaseOSDif.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
            cmbConBaseOSDif.addItem("1", httpContext.getMessage( "Sí. Recalcular proporcional a jornada completa", ""), (short)(0));
            cmbConBaseOSDif.addItem("2", httpContext.getMessage( "Sí, el valor liquidado", ""), (short)(0));
            cmbConBaseOSDif.addItem("3", httpContext.getMessage( "Sí, el valor liquidado proporcional a jornada completa", ""), (short)(0));
            if ( cmbConBaseOSDif.getItemCount() > 0 )
            {
               A1827ConBaseOSDif = (byte)(GXutil.lval( cmbConBaseOSDif.getValidValue(GXutil.trim( GXutil.str( A1827ConBaseOSDif, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConBaseOSDif,cmbConBaseOSDif.getInternalname(),GXutil.trim( GXutil.str( A1827ConBaseOSDif, 1, 0)),Integer.valueOf(1),cmbConBaseOSDif.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConBaseOSDif.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConBaseOSDif.setValue( GXutil.trim( GXutil.str( A1827ConBaseOSDif, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseOSDif.getInternalname(), "Values", cmbConBaseOSDif.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConErrorSiCero.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONERRORSICERO_" + sGXsfl_110_idx ;
         chkConErrorSiCero.setName( GXCCtl );
         chkConErrorSiCero.setWebtags( "" );
         chkConErrorSiCero.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConErrorSiCero.getInternalname(), "TitleCaption", chkConErrorSiCero.getCaption(), !bGXsfl_110_Refreshing);
         chkConErrorSiCero.setCheckedValue( "false" );
         A1821ConErrorSiCero = GXutil.strtobool( GXutil.booltostr( A1821ConErrorSiCero)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConErrorSiCero.getInternalname(),GXutil.booltostr( A1821ConErrorSiCero),"","",Integer.valueOf(chkConErrorSiCero.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtCliPadre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliPadre_Internalname,GXutil.ltrim( localUtil.ntoc( A1822CliPadre, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1822CliPadre), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliPadre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCliPadre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConPadre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConPadre_Internalname,GXutil.rtrim( A921ConPadre),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConPadre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConPadre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConPueNov.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONPUENOV_" + sGXsfl_110_idx ;
         chkConPueNov.setName( GXCCtl );
         chkConPueNov.setWebtags( "" );
         chkConPueNov.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConPueNov.getInternalname(), "TitleCaption", chkConPueNov.getCaption(), !bGXsfl_110_Refreshing);
         chkConPueNov.setCheckedValue( "false" );
         A1826ConPueNov = GXutil.strtobool( GXutil.booltostr( A1826ConPueNov)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConPueNov.getInternalname(),GXutil.booltostr( A1826ConPueNov),"","",Integer.valueOf(chkConPueNov.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         send_integrity_lvl_hashesIB2( ) ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCliCod_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cod", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConCodigo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConOrden_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Orden", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConVigencia.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Vigencia", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConLiqBasica_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Basica (borrar)", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConFormula_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Formula", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConObservacion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Observacion", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConVariable.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Remuneración variable", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConForEditable.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Editable (borrar)", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbTipoConCod.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSubTipoConCod1_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Clasificación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSubTipoConCod2_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sub clasif.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConTipoLiqAux_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liq Aux", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConClasifAux_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Clasificación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConOrdEjec_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Ord Ejec", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConRecalcular.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Recalcular por impuesto a las ganancias", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConRangoCant_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Rango de valores para cantidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConCondicion.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Condición para liquidación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConCondCodigo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código relacionado a la condición", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConMostrarPos.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Mostrar en recibo solo si es mayor a cero", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConAdelDescu.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Adelanto/Descuento", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtAplIIGG_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tratamiento IIGG Nro", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConSegunPla.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Si no se cumple la condición, liquidar en segundo plano a posteriori", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConCodAfip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto AFIP", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConSIPAApo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "SIPAApo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConSIPACont_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "SIPACont", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConINSSJyPApo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "INSSJy PApo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConINSSJyPCont_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "INSSJy PCont", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConObraSocApo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Soc Apo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConObraSocCont_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Soc Cont", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConFonSolRedApo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Red Apo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConFonSolRedCont_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Red Cont", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConRenateaApo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Renatea Apo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConRenateaCont_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Renatea Cont", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConAsigFamCont_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fam Cont", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConFonNacEmpCont_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Emp Cont", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConLeyRieTrabCont_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Trab Cont", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConRegDifApo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Dif Apo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConRegEspApo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Esp Apo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConSacDeven.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo devengamiento", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConceptoPais_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Pais", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConceptoConveCodigo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Convenio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseLic.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para licencias de remuneraciòn actual", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseLicProm.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para licencias de remuneración promedio variable", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseFer.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para feriados de remuneración actual", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseFerProm.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para feriados de remuneración promedio variable", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseHorExt.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para horas extras de remuneración actual", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseHorExtProm.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para horas extras de remuneración promedio variable", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBasePres.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para presentismo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseAnt.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para antiguedad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConBaseOSDif.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base de cálculo para obra social diferencial", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConErrorSiCero.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Dar error si el concepto se calcula en cero", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCliPadre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Padre", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConPadre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Padre", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConPueNov.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Se puede ingresar como novedad", "")) ;
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
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCliCod_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A26ConCodigo));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConCodigo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A41ConDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A40ConOrden, (byte)(8), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConOrden_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A162ConVigencia, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConVigencia.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1488ConLiqBasica, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConLiqBasica_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A148ConFormula);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConFormula_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A153ConObservacion);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConObservacion_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A159ConVariable));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConVariable.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A146ConForEditable));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConForEditable.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A37TipoConCod));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbTipoConCod.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A38SubTipoConCod1));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSubTipoConCod1_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A39SubTipoConCod2));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSubTipoConCod2_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A503ConTipoLiqAux);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConTipoLiqAux_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A970ConClasifAux);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConClasifAux_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A510ConOrdEjec, (byte)(12), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConOrdEjec_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A762ConRecalcular));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConRecalcular.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1018ConRangoCant);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConRangoCant_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A953ConCondicion));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConCondicion.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A954ConCondCodigo));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConCondCodigo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1068ConMostrarPos));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConMostrarPos.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1077ConAdelDescu, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConAdelDescu.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtAplIIGG_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1194ConSegunPla));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConSegunPla.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV158Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV157VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1648ConCodAfip));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConCodAfip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1472ConSIPAApo, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConSIPAApo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1473ConSIPACont, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConSIPACont_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1474ConINSSJyPApo, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConINSSJyPApo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1475ConINSSJyPCont, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConINSSJyPCont_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1476ConObraSocApo, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConObraSocApo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1477ConObraSocCont, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConObraSocCont_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1478ConFonSolRedApo, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConFonSolRedApo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1479ConFonSolRedCont, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConFonSolRedCont_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1480ConRenateaApo, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConRenateaApo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1481ConRenateaCont, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConRenateaCont_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1482ConAsigFamCont, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConAsigFamCont_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1483ConFonNacEmpCont, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConFonNacEmpCont_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1484ConLeyRieTrabCont, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConLeyRieTrabCont_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1485ConRegDifApo, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConRegDifApo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1486ConRegEspApo, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConRegEspApo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1539ConSacDeven, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConSacDeven.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1644ConceptoPais, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConceptoPais_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1645ConceptoConveCodigo));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConceptoConveCodigo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1620ConBaseLic, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseLic.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1797ConBaseLicProm, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseLicProm.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1621ConBaseFer, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseFer.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1798ConBaseFerProm, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseFerProm.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1622ConBaseHorExt, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseHorExt.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1799ConBaseHorExtProm, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseHorExtProm.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1800ConBasePres, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBasePres.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1801ConBaseAnt, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseAnt.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1827ConBaseOSDif, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConBaseOSDif.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1821ConErrorSiCero));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConErrorSiCero.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1822CliPadre, (byte)(6), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCliPadre_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A921ConPadre));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConPadre_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1826ConPueNov));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConPueNov.getVisible(), (byte)(5), (byte)(0), ".", "")));
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
      edtConCodigo_Internalname = "CONCODIGO" ;
      edtConDescrip_Internalname = "CONDESCRIP" ;
      edtConOrden_Internalname = "CONORDEN" ;
      cmbConVigencia.setInternalname( "CONVIGENCIA" );
      edtConLiqBasica_Internalname = "CONLIQBASICA" ;
      edtConFormula_Internalname = "CONFORMULA" ;
      edtConObservacion_Internalname = "CONOBSERVACION" ;
      chkConVariable.setInternalname( "CONVARIABLE" );
      chkConForEditable.setInternalname( "CONFOREDITABLE" );
      cmbTipoConCod.setInternalname( "TIPOCONCOD" );
      edtSubTipoConCod1_Internalname = "SUBTIPOCONCOD1" ;
      edtSubTipoConCod2_Internalname = "SUBTIPOCONCOD2" ;
      edtConTipoLiqAux_Internalname = "CONTIPOLIQAUX" ;
      edtConClasifAux_Internalname = "CONCLASIFAUX" ;
      edtConOrdEjec_Internalname = "CONORDEJEC" ;
      chkConRecalcular.setInternalname( "CONRECALCULAR" );
      edtConRangoCant_Internalname = "CONRANGOCANT" ;
      cmbConCondicion.setInternalname( "CONCONDICION" );
      edtConCondCodigo_Internalname = "CONCONDCODIGO" ;
      chkConMostrarPos.setInternalname( "CONMOSTRARPOS" );
      cmbConAdelDescu.setInternalname( "CONADELDESCU" );
      edtAplIIGG_Internalname = "APLIIGG" ;
      chkConSegunPla.setInternalname( "CONSEGUNPLA" );
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavVersvg_Internalname = "vVERSVG" ;
      edtConCodAfip_Internalname = "CONCODAFIP" ;
      edtConSIPAApo_Internalname = "CONSIPAAPO" ;
      edtConSIPACont_Internalname = "CONSIPACONT" ;
      edtConINSSJyPApo_Internalname = "CONINSSJYPAPO" ;
      edtConINSSJyPCont_Internalname = "CONINSSJYPCONT" ;
      edtConObraSocApo_Internalname = "CONOBRASOCAPO" ;
      edtConObraSocCont_Internalname = "CONOBRASOCCONT" ;
      edtConFonSolRedApo_Internalname = "CONFONSOLREDAPO" ;
      edtConFonSolRedCont_Internalname = "CONFONSOLREDCONT" ;
      edtConRenateaApo_Internalname = "CONRENATEAAPO" ;
      edtConRenateaCont_Internalname = "CONRENATEACONT" ;
      edtConAsigFamCont_Internalname = "CONASIGFAMCONT" ;
      edtConFonNacEmpCont_Internalname = "CONFONNACEMPCONT" ;
      edtConLeyRieTrabCont_Internalname = "CONLEYRIETRABCONT" ;
      edtConRegDifApo_Internalname = "CONREGDIFAPO" ;
      edtConRegEspApo_Internalname = "CONREGESPAPO" ;
      cmbConSacDeven.setInternalname( "CONSACDEVEN" );
      edtConceptoPais_Internalname = "CONCEPTOPAIS" ;
      edtConceptoConveCodigo_Internalname = "CONCEPTOCONVECODIGO" ;
      cmbConBaseLic.setInternalname( "CONBASELIC" );
      cmbConBaseLicProm.setInternalname( "CONBASELICPROM" );
      cmbConBaseFer.setInternalname( "CONBASEFER" );
      cmbConBaseFerProm.setInternalname( "CONBASEFERPROM" );
      cmbConBaseHorExt.setInternalname( "CONBASEHOREXT" );
      cmbConBaseHorExtProm.setInternalname( "CONBASEHOREXTPROM" );
      cmbConBasePres.setInternalname( "CONBASEPRES" );
      cmbConBaseAnt.setInternalname( "CONBASEANT" );
      cmbConBaseOSDif.setInternalname( "CONBASEOSDIF" );
      chkConErrorSiCero.setInternalname( "CONERRORSICERO" );
      edtCliPadre_Internalname = "CLIPADRE" ;
      edtConPadre_Internalname = "CONPADRE" ;
      chkConPueNov.setInternalname( "CONPUENOV" );
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      tblTablepadding_Internalname = "TABLEPADDING" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      bttBtnmotivos_Internalname = "BTNMOTIVOS" ;
      bttBtntiposliq_Internalname = "BTNTIPOSLIQ" ;
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
      chkConPueNov.setCaption( "" );
      edtConPadre_Jsonclick = "" ;
      edtCliPadre_Jsonclick = "" ;
      chkConErrorSiCero.setCaption( "" );
      cmbConBaseOSDif.setJsonclick( "" );
      cmbConBaseAnt.setJsonclick( "" );
      cmbConBasePres.setJsonclick( "" );
      cmbConBaseHorExtProm.setJsonclick( "" );
      cmbConBaseHorExt.setJsonclick( "" );
      cmbConBaseFerProm.setJsonclick( "" );
      cmbConBaseFer.setJsonclick( "" );
      cmbConBaseLicProm.setJsonclick( "" );
      cmbConBaseLic.setJsonclick( "" );
      edtConceptoConveCodigo_Jsonclick = "" ;
      edtConceptoPais_Jsonclick = "" ;
      cmbConSacDeven.setJsonclick( "" );
      edtConRegEspApo_Jsonclick = "" ;
      edtConRegDifApo_Jsonclick = "" ;
      edtConLeyRieTrabCont_Jsonclick = "" ;
      edtConFonNacEmpCont_Jsonclick = "" ;
      edtConAsigFamCont_Jsonclick = "" ;
      edtConRenateaCont_Jsonclick = "" ;
      edtConRenateaApo_Jsonclick = "" ;
      edtConFonSolRedCont_Jsonclick = "" ;
      edtConFonSolRedApo_Jsonclick = "" ;
      edtConObraSocCont_Jsonclick = "" ;
      edtConObraSocApo_Jsonclick = "" ;
      edtConINSSJyPCont_Jsonclick = "" ;
      edtConINSSJyPApo_Jsonclick = "" ;
      edtConSIPACont_Jsonclick = "" ;
      edtConSIPAApo_Jsonclick = "" ;
      edtConCodAfip_Jsonclick = "" ;
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Link = "" ;
      edtavVersvg_Enabled = 0 ;
      edtavVersvg_Format = (short)(0) ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 0 ;
      edtavDisplay_Visible = -1 ;
      chkConSegunPla.setCaption( "" );
      edtAplIIGG_Jsonclick = "" ;
      cmbConAdelDescu.setJsonclick( "" );
      chkConMostrarPos.setCaption( "" );
      edtConCondCodigo_Jsonclick = "" ;
      cmbConCondicion.setJsonclick( "" );
      edtConRangoCant_Jsonclick = "" ;
      chkConRecalcular.setCaption( "" );
      edtConOrdEjec_Jsonclick = "" ;
      edtConClasifAux_Jsonclick = "" ;
      edtConTipoLiqAux_Jsonclick = "" ;
      edtSubTipoConCod2_Jsonclick = "" ;
      edtSubTipoConCod1_Jsonclick = "" ;
      cmbTipoConCod.setJsonclick( "" );
      chkConForEditable.setCaption( "" );
      chkConVariable.setCaption( "" );
      edtConObservacion_Jsonclick = "" ;
      edtConFormula_Jsonclick = "" ;
      edtConLiqBasica_Jsonclick = "" ;
      cmbConVigencia.setJsonclick( "" );
      edtConOrden_Jsonclick = "" ;
      edtConDescrip_Jsonclick = "" ;
      edtConCodigo_Jsonclick = "" ;
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
      edtavDisplay_Link = "" ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      chkConPueNov.setVisible( -1 );
      edtConPadre_Visible = -1 ;
      edtCliPadre_Visible = -1 ;
      chkConErrorSiCero.setVisible( -1 );
      cmbConBaseOSDif.setVisible( -1 );
      cmbConBaseAnt.setVisible( -1 );
      cmbConBasePres.setVisible( -1 );
      cmbConBaseHorExtProm.setVisible( -1 );
      cmbConBaseHorExt.setVisible( -1 );
      cmbConBaseFerProm.setVisible( -1 );
      cmbConBaseFer.setVisible( -1 );
      cmbConBaseLicProm.setVisible( -1 );
      cmbConBaseLic.setVisible( -1 );
      edtConceptoConveCodigo_Visible = -1 ;
      edtConceptoPais_Visible = -1 ;
      cmbConSacDeven.setVisible( -1 );
      edtConRegEspApo_Visible = -1 ;
      edtConRegDifApo_Visible = -1 ;
      edtConLeyRieTrabCont_Visible = -1 ;
      edtConFonNacEmpCont_Visible = -1 ;
      edtConAsigFamCont_Visible = -1 ;
      edtConRenateaCont_Visible = -1 ;
      edtConRenateaApo_Visible = -1 ;
      edtConFonSolRedCont_Visible = -1 ;
      edtConFonSolRedApo_Visible = -1 ;
      edtConObraSocCont_Visible = -1 ;
      edtConObraSocApo_Visible = -1 ;
      edtConINSSJyPCont_Visible = -1 ;
      edtConINSSJyPApo_Visible = -1 ;
      edtConSIPACont_Visible = -1 ;
      edtConSIPAApo_Visible = -1 ;
      edtConCodAfip_Visible = -1 ;
      edtavVersvg_Visible = -1 ;
      chkConSegunPla.setVisible( -1 );
      edtAplIIGG_Visible = -1 ;
      cmbConAdelDescu.setVisible( -1 );
      chkConMostrarPos.setVisible( -1 );
      edtConCondCodigo_Visible = -1 ;
      cmbConCondicion.setVisible( -1 );
      edtConRangoCant_Visible = -1 ;
      chkConRecalcular.setVisible( -1 );
      edtConOrdEjec_Visible = -1 ;
      edtConClasifAux_Visible = -1 ;
      edtConTipoLiqAux_Visible = -1 ;
      edtSubTipoConCod2_Visible = -1 ;
      edtSubTipoConCod1_Visible = -1 ;
      cmbTipoConCod.setVisible( -1 );
      chkConForEditable.setVisible( -1 );
      chkConVariable.setVisible( -1 );
      edtConObservacion_Visible = -1 ;
      edtConFormula_Visible = -1 ;
      edtConLiqBasica_Visible = -1 ;
      cmbConVigencia.setVisible( -1 );
      edtConOrden_Visible = -1 ;
      edtConDescrip_Visible = -1 ;
      edtConCodigo_Visible = -1 ;
      edtCliCod_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "6.0|||8.0|1.0|1.0||||||||||-12.0|||||||4.0|||1.0|1.0|1.0|1.0|1.0|1.0|1.0|1.0|1.0|1.0|1.0|1.0|1.0|1.0|1.0|2.0|4.0||1.0||1.0||1.0||||||6.0||" ;
      Ddo_grid_Datalistproc = "Conceptos_exportWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||||||||1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked|||||||1:WWP_TSChecked,2:WWP_TSUnChecked||||1:WWP_TSChecked,2:WWP_TSUnChecked|1:Adelanto de mes próximo,2:Descuento||1:WWP_TSChecked,2:WWP_TSUnChecked|||||||||||||||||||||0:No,1:Sí,2:Sí\\\\, para trabajadores de clase Jornal,3:Sí\\\\, para trabajadores de clase Mensual,4:Sí\\\\, mientras sea habitual,5:Sí\\\\, para trabajadores de clase Jornal\\\\, mientras sea habitual,6:Sí\\\\, para trabajadores de clase Mensual\\\\, mientras sea habitual||0:No,1:Sí,2:Sí\\\\, para trabajadores de clase Jornal,3:Sí\\\\, para trabajadores de clase Mensual,4:Sí\\\\, mientras sea habitual,5:Sí\\\\, para trabajadores de clase Jornal\\\\, mientras sea habitual,6:Sí\\\\, para trabajadores de clase Mensual\\\\, mientras sea habitual||0:No,1:Sí,2:Sí\\\\, para trabajadores de clase Jornal,3:Sí\\\\, para trabajadores de clase Mensual,4:Sí\\\\, mientras sea habitual,5:Sí\\\\, para trabajadores de clase Jornal\\\\, mientras sea habitual,6:Sí\\\\, para trabajadores de clase Mensual\\\\, mientras sea habitual|0:No,1:Sí,2:Sí\\\\, para trabajadores de clase Jornal,3:Sí\\\\, para trabajadores de clase Mensual,4:Sí\\\\, mientras sea habitual,5:Sí\\\\, para trabajadores de clase Jornal\\\\, mientras sea habitual,6:Sí\\\\, para trabajadores de clase Mensual\\\\, mientras sea habitual|0:No,1:Sí,2:Sí\\\\, para trabajadores de clase Jornal,3:Sí\\\\, para trabajadores de clase Mensual,4:Sí\\\\, mientras sea habitual,5:Sí\\\\, para trabajadores de clase Jornal\\\\, mientras sea habitual,6:Sí\\\\, para trabajadores de clase Mensual\\\\, mientras sea habitual|0:No,1:Sí. Recalcular proporcional a jornada completa,2:Sí\\\\, el valor liquidado,3:Sí\\\\, el valor liquidado proporcional a jornada completa|1:WWP_TSChecked,2:WWP_TSUnChecked|||1:WWP_TSChecked,2:WWP_TSUnChecked" ;
      Ddo_grid_Allowmultipleselection = "|T|T||||T|T|||T|T|T|T|T|||T|T|T||T|||T||||||||||||||||||T||T||T||T|T|T|T|||T|" ;
      Ddo_grid_Datalisttype = "|Dynamic|Dynamic||||Dynamic|Dynamic|FixedValues|FixedValues|Dynamic (with fixedValues)|Dynamic|Dynamic|Dynamic|Dynamic||FixedValues|Dynamic|Dynamic (with fixedValues)|Dynamic|FixedValues|FixedValues||FixedValues|Dynamic||||||||||||||||||Dynamic||FixedValues||FixedValues||FixedValues|FixedValues|FixedValues|FixedValues|FixedValues||Dynamic|FixedValues" ;
      Ddo_grid_Includedatalist = "|T|T||||T|T|T|T|T|T|T|T|T||T|T|T|T|T|T||T|T||||||||||||||||||T||T||T||T|T|T|T|T||T|T" ;
      Ddo_grid_Filterisrange = "T|||T|T|T||||||||||T|||||||T|||T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T||T||T||T||||||T||" ;
      Ddo_grid_Filtertype = "Numeric|Character|Character|Numeric|Numeric|Numeric|Character|Character|||Character|Character|Character|Character|Character|Numeric||Character|Character|Character|||Numeric||Character|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Character|Numeric||Numeric||Numeric||||||Numeric|Character|" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T|T|T|||T|T|T|T|T|T||T|T|T|||T||T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T||T||T||||||T|T|" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56" ;
      Ddo_grid_Columnids = "0:CliCod|1:ConCodigo|2:ConDescrip|3:ConOrden|4:ConVigencia|5:ConLiqBasica|6:ConFormula|7:ConObservacion|8:ConVariable|9:ConForEditable|10:TipoConCod|11:SubTipoConCod1|12:SubTipoConCod2|13:ConTipoLiqAux|14:ConClasifAux|15:ConOrdEjec|16:ConRecalcular|17:ConRangoCant|18:ConCondicion|19:ConCondCodigo|20:ConMostrarPos|21:ConAdelDescu|22:AplIIGG|23:ConSegunPla|26:ConCodAfip|27:ConSIPAApo|28:ConSIPACont|29:ConINSSJyPApo|30:ConINSSJyPCont|31:ConObraSocApo|32:ConObraSocCont|33:ConFonSolRedApo|34:ConFonSolRedCont|35:ConRenateaApo|36:ConRenateaCont|37:ConAsigFamCont|38:ConFonNacEmpCont|39:ConLeyRieTrabCont|40:ConRegDifApo|41:ConRegEspApo|42:ConSacDeven|43:ConceptoPais|44:ConceptoConveCodigo|45:ConBaseLic|46:ConBaseLicProm|47:ConBaseFer|48:ConBaseFerProm|49:ConBaseHorExt|50:ConBaseHorExtProm|51:ConBasePres|52:ConBaseAnt|53:ConBaseOSDif|54:ConErrorSiCero|55:CliPadre|56:ConPadre|57:ConPueNov" ;
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
      Form.setCaption( httpContext.getMessage( " Conceptos_export", "") );
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
      AV161WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV161WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV161WelcomeMessage_NoMostrarMas", AV161WelcomeMessage_NoMostrarMas);
      GXCCtl = "CONVIGENCIA_" + sGXsfl_110_idx ;
      cmbConVigencia.setName( GXCCtl );
      cmbConVigencia.setWebtags( "" );
      cmbConVigencia.addItem("0", httpContext.getMessage( "Automática", ""), (short)(0));
      cmbConVigencia.addItem("1", httpContext.getMessage( "Por Novedad", ""), (short)(0));
      if ( cmbConVigencia.getItemCount() > 0 )
      {
         A162ConVigencia = (byte)(GXutil.lval( cmbConVigencia.getValidValue(GXutil.trim( GXutil.str( A162ConVigencia, 1, 0))))) ;
      }
      GXCCtl = "CONVARIABLE_" + sGXsfl_110_idx ;
      chkConVariable.setName( GXCCtl );
      chkConVariable.setWebtags( "" );
      chkConVariable.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "TitleCaption", chkConVariable.getCaption(), !bGXsfl_110_Refreshing);
      chkConVariable.setCheckedValue( "false" );
      A159ConVariable = GXutil.strtobool( GXutil.booltostr( A159ConVariable)) ;
      GXCCtl = "CONFOREDITABLE_" + sGXsfl_110_idx ;
      chkConForEditable.setName( GXCCtl );
      chkConForEditable.setWebtags( "" );
      chkConForEditable.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConForEditable.getInternalname(), "TitleCaption", chkConForEditable.getCaption(), !bGXsfl_110_Refreshing);
      chkConForEditable.setCheckedValue( "false" );
      A146ConForEditable = GXutil.strtobool( GXutil.booltostr( A146ConForEditable)) ;
      n146ConForEditable = false ;
      GXCCtl = "TIPOCONCOD_" + sGXsfl_110_idx ;
      cmbTipoConCod.setName( GXCCtl );
      cmbTipoConCod.setWebtags( "" );
      cmbTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbTipoConCod.getItemCount() > 0 )
      {
         A37TipoConCod = cmbTipoConCod.getValidValue(A37TipoConCod) ;
      }
      GXCCtl = "CONRECALCULAR_" + sGXsfl_110_idx ;
      chkConRecalcular.setName( GXCCtl );
      chkConRecalcular.setWebtags( "" );
      chkConRecalcular.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConRecalcular.getInternalname(), "TitleCaption", chkConRecalcular.getCaption(), !bGXsfl_110_Refreshing);
      chkConRecalcular.setCheckedValue( "false" );
      A762ConRecalcular = GXutil.strtobool( GXutil.booltostr( A762ConRecalcular)) ;
      GXCCtl = "CONCONDICION_" + sGXsfl_110_idx ;
      cmbConCondicion.setName( GXCCtl );
      cmbConCondicion.setWebtags( "" );
      cmbConCondicion.addItem("A0", httpContext.getMessage( "Siempre", ""), (short)(0));
      cmbConCondicion.addItem("A1", httpContext.getMessage( "Se ingresó por novedad el concepto de código relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("A3", httpContext.getMessage( "Trabajador no es Jubilado y aplica a liquidación de aportes", ""), (short)(0));
      cmbConCondicion.addItem("A4", httpContext.getMessage( "Resultado de la suma de conceptos agregados en liquidación anterior con la misma clasificación sea mayor a cerO, y que el concepto de la liquidación anterior tenga asignado tipo de liquidación igual al código relacionado a la condición de este concepto", ""), (short)(0));
      cmbConCondicion.addItem("A5", httpContext.getMessage( "Es alcanzado por ganancias y calcula adelanto de retención (parámetro)", ""), (short)(0));
      cmbConCondicion.addItem("A8", httpContext.getMessage( "Legajo tiene saldo distinto de cero en DDJJ F1357 del año anterior", ""), (short)(0));
      cmbConCondicion.addItem("A9", httpContext.getMessage( "Tiene familiares adherentes a la obra social", ""), (short)(0));
      cmbConCondicion.addItem("A10", httpContext.getMessage( "Tiene Sindicato", ""), (short)(0));
      cmbConCondicion.addItem("A11", httpContext.getMessage( "Tiene jornada parcial", ""), (short)(0));
      cmbConCondicion.addItem("A12", httpContext.getMessage( "Obra social tiene aporte adicional", ""), (short)(0));
      cmbConCondicion.addItem("A13", httpContext.getMessage( "Empleador es agente de retención", ""), (short)(0));
      cmbConCondicion.addItem("A14", httpContext.getMessage( "El empleador es agente de retención y el empleado es alcanzado por ganancias", ""), (short)(0));
      cmbConCondicion.addItem("B1", httpContext.getMessage( "Legajo tiene cargado licencia igual al código  relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B2", httpContext.getMessage( "Legajo tiene cargado SIRADIG de igual código  relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B3", httpContext.getMessage( "Tiene obligación activa de igual al código relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B4", httpContext.getMessage( "Hay licencias o feriados con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbConCondicion.addItem("B5", httpContext.getMessage( "Hay feriado no trabajado, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbConCondicion.addItem("B6", httpContext.getMessage( "Hay día no laborable em periodo, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbConCondicion.addItem("B7", httpContext.getMessage( "El legajo es empleado mensual y hay licencia sin goce de sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B9", httpContext.getMessage( "Es egreso y no maneja fondo de cese laboral", ""), (short)(0));
      cmbConCondicion.addItem("B10", httpContext.getMessage( "Tipo de liquidación, mes de liquidación, y marca de SAC en alta de liquidación son compatibles con la liquidación del SAC.", ""), (short)(0));
      cmbConCondicion.addItem("B11", httpContext.getMessage( "Liquida sac o alcanza ganancias", ""), (short)(0));
      cmbConCondicion.addItem("B12", httpContext.getMessage( "Empresa o convenio liquidan antiguedad", ""), (short)(0));
      cmbConCondicion.addItem("B13", httpContext.getMessage( "Empresa o convenio liquidan presentismo", ""), (short)(0));
      cmbConCondicion.addItem("B14", httpContext.getMessage( "Legajo tiene cargado comprobante para reintegro igual al código relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B15", httpContext.getMessage( "Legajo tiene cargado hijo o hija con asignación de servicio de guardería", ""), (short)(0));
      cmbConCondicion.addItem("N01", httpContext.getMessage( "Nunca  (Calcular siempre en segundo plano luego de generar el recibo)", ""), (short)(0));
      cmbConCondicion.addItem("B16", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\", de frecuencia mensual y el concepto no fué previamente liquidado en el mismo periodo", ""), (short)(0));
      cmbConCondicion.addItem("B19", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado vacaciones y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B20", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado días de licencia (distinta a vacaciones) y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B21", httpContext.getMessage( "Legajo es empleado mensual, hay feriado no trabajado y la empresa está configurada para exponer los feriados y no proratear el sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B22", httpContext.getMessage( "Legajo es empleado mensual, hay día no laborable no trabajado y la empresa está configurada para exponer los feriados y no prorratear el sueldo", ""), (short)(0));
      cmbConCondicion.addItem("B23", httpContext.getMessage( "Legajo tiene asignado tìtulo igual al código relacionado a la condición", ""), (short)(0));
      cmbConCondicion.addItem("B24", httpContext.getMessage( "Parametro para desglosar adicional está activado, legajo está en convenio y su categoría tiene adicional por zona desfavorable", ""), (short)(0));
      cmbConCondicion.addItem("VP", httpContext.getMessage( "Hay vacaciones con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbConCondicion.addItem("AI", httpContext.getMessage( "Legajo es de clase mensual y tiene cargadas ausencias injustificadas", ""), (short)(0));
      cmbConCondicion.addItem("R1", httpContext.getMessage( "Forma de pago es distinta a transferencia o parámetro está configurado para liquidar siempre redondeo", ""), (short)(0));
      cmbConCondicion.addItem("MI", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\" de frecuencia mensual, empresa está configurada para no prorratear sueldo y fecha de ingreso es mayor al primero o fecha de egreso menor al último día del mes", ""), (short)(0));
      cmbConCondicion.addItem("H1", httpContext.getMessage( "Si liquidación es compatible con SAC liquidar como concepto principal, y si no liquidarlo como concepto auxiliar en segundo plano", ""), (short)(0));
      cmbConCondicion.addItem("LA", httpContext.getMessage( "Legajo aplica a liquidación de aportes", ""), (short)(0));
      cmbConCondicion.addItem("GU", httpContext.getMessage( "Legajo tiene configurado grossing up", ""), (short)(0));
      if ( cmbConCondicion.getItemCount() > 0 )
      {
         A953ConCondicion = cmbConCondicion.getValidValue(A953ConCondicion) ;
         n953ConCondicion = false ;
      }
      GXCCtl = "CONMOSTRARPOS_" + sGXsfl_110_idx ;
      chkConMostrarPos.setName( GXCCtl );
      chkConMostrarPos.setWebtags( "" );
      chkConMostrarPos.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConMostrarPos.getInternalname(), "TitleCaption", chkConMostrarPos.getCaption(), !bGXsfl_110_Refreshing);
      chkConMostrarPos.setCheckedValue( "false" );
      A1068ConMostrarPos = GXutil.strtobool( GXutil.booltostr( A1068ConMostrarPos)) ;
      GXCCtl = "CONADELDESCU_" + sGXsfl_110_idx ;
      cmbConAdelDescu.setName( GXCCtl );
      cmbConAdelDescu.setWebtags( "" );
      cmbConAdelDescu.addItem(GXutil.trim( GXutil.str( 0, 1, 0)), httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      cmbConAdelDescu.addItem("1", httpContext.getMessage( "Adelanto de mes próximo", ""), (short)(0));
      cmbConAdelDescu.addItem("2", httpContext.getMessage( "Descuento", ""), (short)(0));
      if ( cmbConAdelDescu.getItemCount() > 0 )
      {
         A1077ConAdelDescu = (byte)(GXutil.lval( cmbConAdelDescu.getValidValue(GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0))))) ;
         n1077ConAdelDescu = false ;
      }
      GXCCtl = "CONSEGUNPLA_" + sGXsfl_110_idx ;
      chkConSegunPla.setName( GXCCtl );
      chkConSegunPla.setWebtags( "" );
      chkConSegunPla.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConSegunPla.getInternalname(), "TitleCaption", chkConSegunPla.getCaption(), !bGXsfl_110_Refreshing);
      chkConSegunPla.setCheckedValue( "false" );
      A1194ConSegunPla = GXutil.strtobool( GXutil.booltostr( A1194ConSegunPla)) ;
      GXCCtl = "CONSACDEVEN_" + sGXsfl_110_idx ;
      cmbConSacDeven.setName( GXCCtl );
      cmbConSacDeven.setWebtags( "" );
      cmbConSacDeven.addItem("0", httpContext.getMessage( "No aplica", ""), (short)(0));
      cmbConSacDeven.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbConSacDeven.addItem("3", httpContext.getMessage( "Trimestral", ""), (short)(0));
      cmbConSacDeven.addItem("4", httpContext.getMessage( "Cuatrimestral", ""), (short)(0));
      cmbConSacDeven.addItem("6", httpContext.getMessage( "Semestral", ""), (short)(0));
      cmbConSacDeven.addItem("12", httpContext.getMessage( "Anual", ""), (short)(0));
      if ( cmbConSacDeven.getItemCount() > 0 )
      {
         A1539ConSacDeven = (byte)(GXutil.lval( cmbConSacDeven.getValidValue(GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0))))) ;
      }
      GXCCtl = "CONBASELIC_" + sGXsfl_110_idx ;
      cmbConBaseLic.setName( GXCCtl );
      cmbConBaseLic.setWebtags( "" );
      cmbConBaseLic.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseLic.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseLic.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseLic.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseLic.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseLic.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseLic.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseLic.getItemCount() > 0 )
      {
         A1620ConBaseLic = (byte)(GXutil.lval( cmbConBaseLic.getValidValue(GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0))))) ;
      }
      GXCCtl = "CONBASELICPROM_" + sGXsfl_110_idx ;
      cmbConBaseLicProm.setName( GXCCtl );
      cmbConBaseLicProm.setWebtags( "" );
      cmbConBaseLicProm.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseLicProm.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseLicProm.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseLicProm.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseLicProm.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseLicProm.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseLicProm.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseLicProm.getItemCount() > 0 )
      {
         A1797ConBaseLicProm = (byte)(GXutil.lval( cmbConBaseLicProm.getValidValue(GXutil.trim( GXutil.str( A1797ConBaseLicProm, 1, 0))))) ;
      }
      GXCCtl = "CONBASEFER_" + sGXsfl_110_idx ;
      cmbConBaseFer.setName( GXCCtl );
      cmbConBaseFer.setWebtags( "" );
      cmbConBaseFer.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseFer.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseFer.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseFer.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseFer.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseFer.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseFer.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseFer.getItemCount() > 0 )
      {
         A1621ConBaseFer = (byte)(GXutil.lval( cmbConBaseFer.getValidValue(GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0))))) ;
      }
      GXCCtl = "CONBASEFERPROM_" + sGXsfl_110_idx ;
      cmbConBaseFerProm.setName( GXCCtl );
      cmbConBaseFerProm.setWebtags( "" );
      cmbConBaseFerProm.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseFerProm.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseFerProm.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseFerProm.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseFerProm.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseFerProm.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseFerProm.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseFerProm.getItemCount() > 0 )
      {
         A1798ConBaseFerProm = (byte)(GXutil.lval( cmbConBaseFerProm.getValidValue(GXutil.trim( GXutil.str( A1798ConBaseFerProm, 1, 0))))) ;
      }
      GXCCtl = "CONBASEHOREXT_" + sGXsfl_110_idx ;
      cmbConBaseHorExt.setName( GXCCtl );
      cmbConBaseHorExt.setWebtags( "" );
      cmbConBaseHorExt.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseHorExt.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseHorExt.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseHorExt.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseHorExt.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseHorExt.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseHorExt.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseHorExt.getItemCount() > 0 )
      {
         A1622ConBaseHorExt = (byte)(GXutil.lval( cmbConBaseHorExt.getValidValue(GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0))))) ;
      }
      GXCCtl = "CONBASEHOREXTPROM_" + sGXsfl_110_idx ;
      cmbConBaseHorExtProm.setName( GXCCtl );
      cmbConBaseHorExtProm.setWebtags( "" );
      cmbConBaseHorExtProm.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseHorExtProm.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseHorExtProm.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseHorExtProm.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseHorExtProm.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseHorExtProm.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseHorExtProm.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseHorExtProm.getItemCount() > 0 )
      {
         A1799ConBaseHorExtProm = (byte)(GXutil.lval( cmbConBaseHorExtProm.getValidValue(GXutil.trim( GXutil.str( A1799ConBaseHorExtProm, 1, 0))))) ;
      }
      GXCCtl = "CONBASEPRES_" + sGXsfl_110_idx ;
      cmbConBasePres.setName( GXCCtl );
      cmbConBasePres.setWebtags( "" );
      cmbConBasePres.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBasePres.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBasePres.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBasePres.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBasePres.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBasePres.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBasePres.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBasePres.getItemCount() > 0 )
      {
         A1800ConBasePres = (byte)(GXutil.lval( cmbConBasePres.getValidValue(GXutil.trim( GXutil.str( A1800ConBasePres, 1, 0))))) ;
      }
      GXCCtl = "CONBASEANT_" + sGXsfl_110_idx ;
      cmbConBaseAnt.setName( GXCCtl );
      cmbConBaseAnt.setWebtags( "" );
      cmbConBaseAnt.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseAnt.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbConBaseAnt.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbConBaseAnt.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbConBaseAnt.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbConBaseAnt.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbConBaseAnt.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbConBaseAnt.getItemCount() > 0 )
      {
         A1801ConBaseAnt = (byte)(GXutil.lval( cmbConBaseAnt.getValidValue(GXutil.trim( GXutil.str( A1801ConBaseAnt, 1, 0))))) ;
      }
      GXCCtl = "CONBASEOSDIF_" + sGXsfl_110_idx ;
      cmbConBaseOSDif.setName( GXCCtl );
      cmbConBaseOSDif.setWebtags( "" );
      cmbConBaseOSDif.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConBaseOSDif.addItem("1", httpContext.getMessage( "Sí. Recalcular proporcional a jornada completa", ""), (short)(0));
      cmbConBaseOSDif.addItem("2", httpContext.getMessage( "Sí, el valor liquidado", ""), (short)(0));
      cmbConBaseOSDif.addItem("3", httpContext.getMessage( "Sí, el valor liquidado proporcional a jornada completa", ""), (short)(0));
      if ( cmbConBaseOSDif.getItemCount() > 0 )
      {
         A1827ConBaseOSDif = (byte)(GXutil.lval( cmbConBaseOSDif.getValidValue(GXutil.trim( GXutil.str( A1827ConBaseOSDif, 1, 0))))) ;
      }
      GXCCtl = "CONERRORSICERO_" + sGXsfl_110_idx ;
      chkConErrorSiCero.setName( GXCCtl );
      chkConErrorSiCero.setWebtags( "" );
      chkConErrorSiCero.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConErrorSiCero.getInternalname(), "TitleCaption", chkConErrorSiCero.getCaption(), !bGXsfl_110_Refreshing);
      chkConErrorSiCero.setCheckedValue( "false" );
      A1821ConErrorSiCero = GXutil.strtobool( GXutil.booltostr( A1821ConErrorSiCero)) ;
      GXCCtl = "CONPUENOV_" + sGXsfl_110_idx ;
      chkConPueNov.setName( GXCCtl );
      chkConPueNov.setWebtags( "" );
      chkConPueNov.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConPueNov.getInternalname(), "TitleCaption", chkConPueNov.getCaption(), !bGXsfl_110_Refreshing);
      chkConPueNov.setCheckedValue( "false" );
      A1826ConPueNov = GXutil.strtobool( GXutil.booltostr( A1826ConPueNov)) ;
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV170ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV183Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV159MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV31TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV32TFConOrden',fld:'vTFCONORDEN',pic:'ZZZZZZZ9'},{av:'AV33TFConOrden_To',fld:'vTFCONORDEN_TO',pic:'ZZZZZZZ9'},{av:'AV36TFConLiqBasica',fld:'vTFCONLIQBASICA',pic:'9'},{av:'AV37TFConLiqBasica_To',fld:'vTFCONLIQBASICA_TO',pic:'9'},{av:'AV39TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV40TFConFormula_Sels',fld:'vTFCONFORMULA_SELS',pic:''},{av:'AV42TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV43TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV44TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV45TFConForEditable_Sel',fld:'vTFCONFOREDITABLE_SEL',pic:'9'},{av:'AV47TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV49TFSubTipoConCod1',fld:'vTFSUBTIPOCONCOD1',pic:''},{av:'AV50TFSubTipoConCod1_Sels',fld:'vTFSUBTIPOCONCOD1_SELS',pic:''},{av:'AV52TFSubTipoConCod2',fld:'vTFSUBTIPOCONCOD2',pic:''},{av:'AV53TFSubTipoConCod2_Sels',fld:'vTFSUBTIPOCONCOD2_SELS',pic:''},{av:'AV55TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV56TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV58TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV59TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV60TFConOrdEjec',fld:'vTFCONORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV61TFConOrdEjec_To',fld:'vTFCONORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV65TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV67TFConRangoCant',fld:'vTFCONRANGOCANT',pic:''},{av:'AV68TFConRangoCant_Sels',fld:'vTFCONRANGOCANT_SELS',pic:''},{av:'AV70TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV72TFConCondCodigo',fld:'vTFCONCONDCODIGO',pic:''},{av:'AV73TFConCondCodigo_Sels',fld:'vTFCONCONDCODIGO_SELS',pic:''},{av:'AV74TFConMostrarPos_Sel',fld:'vTFCONMOSTRARPOS_SEL',pic:'9'},{av:'AV76TFConAdelDescu_Sels',fld:'vTFCONADELDESCU_SELS',pic:''},{av:'AV77TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV78TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV79TFConSegunPla_Sel',fld:'vTFCONSEGUNPLA_SEL',pic:'9'},{av:'AV92TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV93TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV94TFConSIPAApo',fld:'vTFCONSIPAAPO',pic:'9'},{av:'AV95TFConSIPAApo_To',fld:'vTFCONSIPAAPO_TO',pic:'9'},{av:'AV96TFConSIPACont',fld:'vTFCONSIPACONT',pic:'9'},{av:'AV97TFConSIPACont_To',fld:'vTFCONSIPACONT_TO',pic:'9'},{av:'AV98TFConINSSJyPApo',fld:'vTFCONINSSJYPAPO',pic:'9'},{av:'AV99TFConINSSJyPApo_To',fld:'vTFCONINSSJYPAPO_TO',pic:'9'},{av:'AV100TFConINSSJyPCont',fld:'vTFCONINSSJYPCONT',pic:'9'},{av:'AV101TFConINSSJyPCont_To',fld:'vTFCONINSSJYPCONT_TO',pic:'9'},{av:'AV102TFConObraSocApo',fld:'vTFCONOBRASOCAPO',pic:'9'},{av:'AV103TFConObraSocApo_To',fld:'vTFCONOBRASOCAPO_TO',pic:'9'},{av:'AV104TFConObraSocCont',fld:'vTFCONOBRASOCCONT',pic:'9'},{av:'AV105TFConObraSocCont_To',fld:'vTFCONOBRASOCCONT_TO',pic:'9'},{av:'AV106TFConFonSolRedApo',fld:'vTFCONFONSOLREDAPO',pic:'9'},{av:'AV107TFConFonSolRedApo_To',fld:'vTFCONFONSOLREDAPO_TO',pic:'9'},{av:'AV108TFConFonSolRedCont',fld:'vTFCONFONSOLREDCONT',pic:'9'},{av:'AV109TFConFonSolRedCont_To',fld:'vTFCONFONSOLREDCONT_TO',pic:'9'},{av:'AV110TFConRenateaApo',fld:'vTFCONRENATEAAPO',pic:'9'},{av:'AV111TFConRenateaApo_To',fld:'vTFCONRENATEAAPO_TO',pic:'9'},{av:'AV112TFConRenateaCont',fld:'vTFCONRENATEACONT',pic:'9'},{av:'AV113TFConRenateaCont_To',fld:'vTFCONRENATEACONT_TO',pic:'9'},{av:'AV114TFConAsigFamCont',fld:'vTFCONASIGFAMCONT',pic:'9'},{av:'AV115TFConAsigFamCont_To',fld:'vTFCONASIGFAMCONT_TO',pic:'9'},{av:'AV116TFConFonNacEmpCont',fld:'vTFCONFONNACEMPCONT',pic:'9'},{av:'AV117TFConFonNacEmpCont_To',fld:'vTFCONFONNACEMPCONT_TO',pic:'9'},{av:'AV118TFConLeyRieTrabCont',fld:'vTFCONLEYRIETRABCONT',pic:'9'},{av:'AV119TFConLeyRieTrabCont_To',fld:'vTFCONLEYRIETRABCONT_TO',pic:'9'},{av:'AV120TFConRegDifApo',fld:'vTFCONREGDIFAPO',pic:'9'},{av:'AV121TFConRegDifApo_To',fld:'vTFCONREGDIFAPO_TO',pic:'9'},{av:'AV122TFConRegEspApo',fld:'vTFCONREGESPAPO',pic:'9'},{av:'AV123TFConRegEspApo_To',fld:'vTFCONREGESPAPO_TO',pic:'9'},{av:'AV126TFConceptoPais',fld:'vTFCONCEPTOPAIS',pic:'ZZZ9'},{av:'AV127TFConceptoPais_To',fld:'vTFCONCEPTOPAIS_TO',pic:'ZZZ9'},{av:'AV129TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV130TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV138TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV140TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV142TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV144TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV146TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV148TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV149TFConErrorSiCero_Sel',fld:'vTFCONERRORSICERO_SEL',pic:'9'},{av:'AV150TFCliPadre',fld:'vTFCLIPADRE',pic:'ZZZZZ9'},{av:'AV151TFCliPadre_To',fld:'vTFCLIPADRE_TO',pic:'ZZZZZ9'},{av:'AV153TFConPadre',fld:'vTFCONPADRE',pic:''},{av:'AV154TFConPadre_Sels',fld:'vTFCONPADRE_SELS',pic:''},{av:'AV155TFConPueNov_Sel',fld:'vTFCONPUENOV_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV87CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV161WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV87CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV170ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtCliCod_Visible',ctrl:'CLICOD',prop:'Visible'},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtConDescrip_Visible',ctrl:'CONDESCRIP',prop:'Visible'},{av:'edtConOrden_Visible',ctrl:'CONORDEN',prop:'Visible'},{av:'cmbConVigencia'},{av:'edtConLiqBasica_Visible',ctrl:'CONLIQBASICA',prop:'Visible'},{av:'edtConFormula_Visible',ctrl:'CONFORMULA',prop:'Visible'},{av:'edtConObservacion_Visible',ctrl:'CONOBSERVACION',prop:'Visible'},{av:'chkConVariable.getVisible()',ctrl:'CONVARIABLE',prop:'Visible'},{av:'chkConForEditable.getVisible()',ctrl:'CONFOREDITABLE',prop:'Visible'},{av:'cmbTipoConCod'},{av:'edtSubTipoConCod1_Visible',ctrl:'SUBTIPOCONCOD1',prop:'Visible'},{av:'edtSubTipoConCod2_Visible',ctrl:'SUBTIPOCONCOD2',prop:'Visible'},{av:'edtConTipoLiqAux_Visible',ctrl:'CONTIPOLIQAUX',prop:'Visible'},{av:'edtConClasifAux_Visible',ctrl:'CONCLASIFAUX',prop:'Visible'},{av:'edtConOrdEjec_Visible',ctrl:'CONORDEJEC',prop:'Visible'},{av:'chkConRecalcular.getVisible()',ctrl:'CONRECALCULAR',prop:'Visible'},{av:'edtConRangoCant_Visible',ctrl:'CONRANGOCANT',prop:'Visible'},{av:'cmbConCondicion'},{av:'edtConCondCodigo_Visible',ctrl:'CONCONDCODIGO',prop:'Visible'},{av:'chkConMostrarPos.getVisible()',ctrl:'CONMOSTRARPOS',prop:'Visible'},{av:'cmbConAdelDescu'},{av:'edtAplIIGG_Visible',ctrl:'APLIIGG',prop:'Visible'},{av:'chkConSegunPla.getVisible()',ctrl:'CONSEGUNPLA',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtConCodAfip_Visible',ctrl:'CONCODAFIP',prop:'Visible'},{av:'edtConSIPAApo_Visible',ctrl:'CONSIPAAPO',prop:'Visible'},{av:'edtConSIPACont_Visible',ctrl:'CONSIPACONT',prop:'Visible'},{av:'edtConINSSJyPApo_Visible',ctrl:'CONINSSJYPAPO',prop:'Visible'},{av:'edtConINSSJyPCont_Visible',ctrl:'CONINSSJYPCONT',prop:'Visible'},{av:'edtConObraSocApo_Visible',ctrl:'CONOBRASOCAPO',prop:'Visible'},{av:'edtConObraSocCont_Visible',ctrl:'CONOBRASOCCONT',prop:'Visible'},{av:'edtConFonSolRedApo_Visible',ctrl:'CONFONSOLREDAPO',prop:'Visible'},{av:'edtConFonSolRedCont_Visible',ctrl:'CONFONSOLREDCONT',prop:'Visible'},{av:'edtConRenateaApo_Visible',ctrl:'CONRENATEAAPO',prop:'Visible'},{av:'edtConRenateaCont_Visible',ctrl:'CONRENATEACONT',prop:'Visible'},{av:'edtConAsigFamCont_Visible',ctrl:'CONASIGFAMCONT',prop:'Visible'},{av:'edtConFonNacEmpCont_Visible',ctrl:'CONFONNACEMPCONT',prop:'Visible'},{av:'edtConLeyRieTrabCont_Visible',ctrl:'CONLEYRIETRABCONT',prop:'Visible'},{av:'edtConRegDifApo_Visible',ctrl:'CONREGDIFAPO',prop:'Visible'},{av:'edtConRegEspApo_Visible',ctrl:'CONREGESPAPO',prop:'Visible'},{av:'cmbConSacDeven'},{av:'edtConceptoPais_Visible',ctrl:'CONCEPTOPAIS',prop:'Visible'},{av:'edtConceptoConveCodigo_Visible',ctrl:'CONCEPTOCONVECODIGO',prop:'Visible'},{av:'cmbConBaseLic'},{av:'cmbConBaseLicProm'},{av:'cmbConBaseFer'},{av:'cmbConBaseFerProm'},{av:'cmbConBaseHorExt'},{av:'cmbConBaseHorExtProm'},{av:'cmbConBasePres'},{av:'cmbConBaseAnt'},{av:'cmbConBaseOSDif'},{av:'chkConErrorSiCero.getVisible()',ctrl:'CONERRORSICERO',prop:'Visible'},{av:'edtCliPadre_Visible',ctrl:'CLIPADRE',prop:'Visible'},{av:'edtConPadre_Visible',ctrl:'CONPADRE',prop:'Visible'},{av:'chkConPueNov.getVisible()',ctrl:'CONPUENOV',prop:'Visible'},{av:'AV82GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV83GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV84GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV168ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e15IB2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV170ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV183Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV159MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV31TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV32TFConOrden',fld:'vTFCONORDEN',pic:'ZZZZZZZ9'},{av:'AV33TFConOrden_To',fld:'vTFCONORDEN_TO',pic:'ZZZZZZZ9'},{av:'AV36TFConLiqBasica',fld:'vTFCONLIQBASICA',pic:'9'},{av:'AV37TFConLiqBasica_To',fld:'vTFCONLIQBASICA_TO',pic:'9'},{av:'AV39TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV40TFConFormula_Sels',fld:'vTFCONFORMULA_SELS',pic:''},{av:'AV42TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV43TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV44TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV45TFConForEditable_Sel',fld:'vTFCONFOREDITABLE_SEL',pic:'9'},{av:'AV47TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV49TFSubTipoConCod1',fld:'vTFSUBTIPOCONCOD1',pic:''},{av:'AV50TFSubTipoConCod1_Sels',fld:'vTFSUBTIPOCONCOD1_SELS',pic:''},{av:'AV52TFSubTipoConCod2',fld:'vTFSUBTIPOCONCOD2',pic:''},{av:'AV53TFSubTipoConCod2_Sels',fld:'vTFSUBTIPOCONCOD2_SELS',pic:''},{av:'AV55TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV56TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV58TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV59TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV60TFConOrdEjec',fld:'vTFCONORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV61TFConOrdEjec_To',fld:'vTFCONORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV65TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV67TFConRangoCant',fld:'vTFCONRANGOCANT',pic:''},{av:'AV68TFConRangoCant_Sels',fld:'vTFCONRANGOCANT_SELS',pic:''},{av:'AV70TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV72TFConCondCodigo',fld:'vTFCONCONDCODIGO',pic:''},{av:'AV73TFConCondCodigo_Sels',fld:'vTFCONCONDCODIGO_SELS',pic:''},{av:'AV74TFConMostrarPos_Sel',fld:'vTFCONMOSTRARPOS_SEL',pic:'9'},{av:'AV76TFConAdelDescu_Sels',fld:'vTFCONADELDESCU_SELS',pic:''},{av:'AV77TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV78TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV79TFConSegunPla_Sel',fld:'vTFCONSEGUNPLA_SEL',pic:'9'},{av:'AV92TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV93TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV94TFConSIPAApo',fld:'vTFCONSIPAAPO',pic:'9'},{av:'AV95TFConSIPAApo_To',fld:'vTFCONSIPAAPO_TO',pic:'9'},{av:'AV96TFConSIPACont',fld:'vTFCONSIPACONT',pic:'9'},{av:'AV97TFConSIPACont_To',fld:'vTFCONSIPACONT_TO',pic:'9'},{av:'AV98TFConINSSJyPApo',fld:'vTFCONINSSJYPAPO',pic:'9'},{av:'AV99TFConINSSJyPApo_To',fld:'vTFCONINSSJYPAPO_TO',pic:'9'},{av:'AV100TFConINSSJyPCont',fld:'vTFCONINSSJYPCONT',pic:'9'},{av:'AV101TFConINSSJyPCont_To',fld:'vTFCONINSSJYPCONT_TO',pic:'9'},{av:'AV102TFConObraSocApo',fld:'vTFCONOBRASOCAPO',pic:'9'},{av:'AV103TFConObraSocApo_To',fld:'vTFCONOBRASOCAPO_TO',pic:'9'},{av:'AV104TFConObraSocCont',fld:'vTFCONOBRASOCCONT',pic:'9'},{av:'AV105TFConObraSocCont_To',fld:'vTFCONOBRASOCCONT_TO',pic:'9'},{av:'AV106TFConFonSolRedApo',fld:'vTFCONFONSOLREDAPO',pic:'9'},{av:'AV107TFConFonSolRedApo_To',fld:'vTFCONFONSOLREDAPO_TO',pic:'9'},{av:'AV108TFConFonSolRedCont',fld:'vTFCONFONSOLREDCONT',pic:'9'},{av:'AV109TFConFonSolRedCont_To',fld:'vTFCONFONSOLREDCONT_TO',pic:'9'},{av:'AV110TFConRenateaApo',fld:'vTFCONRENATEAAPO',pic:'9'},{av:'AV111TFConRenateaApo_To',fld:'vTFCONRENATEAAPO_TO',pic:'9'},{av:'AV112TFConRenateaCont',fld:'vTFCONRENATEACONT',pic:'9'},{av:'AV113TFConRenateaCont_To',fld:'vTFCONRENATEACONT_TO',pic:'9'},{av:'AV114TFConAsigFamCont',fld:'vTFCONASIGFAMCONT',pic:'9'},{av:'AV115TFConAsigFamCont_To',fld:'vTFCONASIGFAMCONT_TO',pic:'9'},{av:'AV116TFConFonNacEmpCont',fld:'vTFCONFONNACEMPCONT',pic:'9'},{av:'AV117TFConFonNacEmpCont_To',fld:'vTFCONFONNACEMPCONT_TO',pic:'9'},{av:'AV118TFConLeyRieTrabCont',fld:'vTFCONLEYRIETRABCONT',pic:'9'},{av:'AV119TFConLeyRieTrabCont_To',fld:'vTFCONLEYRIETRABCONT_TO',pic:'9'},{av:'AV120TFConRegDifApo',fld:'vTFCONREGDIFAPO',pic:'9'},{av:'AV121TFConRegDifApo_To',fld:'vTFCONREGDIFAPO_TO',pic:'9'},{av:'AV122TFConRegEspApo',fld:'vTFCONREGESPAPO',pic:'9'},{av:'AV123TFConRegEspApo_To',fld:'vTFCONREGESPAPO_TO',pic:'9'},{av:'AV126TFConceptoPais',fld:'vTFCONCEPTOPAIS',pic:'ZZZ9'},{av:'AV127TFConceptoPais_To',fld:'vTFCONCEPTOPAIS_TO',pic:'ZZZ9'},{av:'AV129TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV130TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV138TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV140TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV142TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV144TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV146TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV148TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV149TFConErrorSiCero_Sel',fld:'vTFCONERRORSICERO_SEL',pic:'9'},{av:'AV150TFCliPadre',fld:'vTFCLIPADRE',pic:'ZZZZZ9'},{av:'AV151TFCliPadre_To',fld:'vTFCLIPADRE_TO',pic:'ZZZZZ9'},{av:'AV153TFConPadre',fld:'vTFCONPADRE',pic:''},{av:'AV154TFConPadre_Sels',fld:'vTFCONPADRE_SELS',pic:''},{av:'AV155TFConPueNov_Sel',fld:'vTFCONPUENOV_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV87CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV161WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e16IB2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV170ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV183Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV159MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV31TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV32TFConOrden',fld:'vTFCONORDEN',pic:'ZZZZZZZ9'},{av:'AV33TFConOrden_To',fld:'vTFCONORDEN_TO',pic:'ZZZZZZZ9'},{av:'AV36TFConLiqBasica',fld:'vTFCONLIQBASICA',pic:'9'},{av:'AV37TFConLiqBasica_To',fld:'vTFCONLIQBASICA_TO',pic:'9'},{av:'AV39TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV40TFConFormula_Sels',fld:'vTFCONFORMULA_SELS',pic:''},{av:'AV42TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV43TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV44TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV45TFConForEditable_Sel',fld:'vTFCONFOREDITABLE_SEL',pic:'9'},{av:'AV47TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV49TFSubTipoConCod1',fld:'vTFSUBTIPOCONCOD1',pic:''},{av:'AV50TFSubTipoConCod1_Sels',fld:'vTFSUBTIPOCONCOD1_SELS',pic:''},{av:'AV52TFSubTipoConCod2',fld:'vTFSUBTIPOCONCOD2',pic:''},{av:'AV53TFSubTipoConCod2_Sels',fld:'vTFSUBTIPOCONCOD2_SELS',pic:''},{av:'AV55TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV56TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV58TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV59TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV60TFConOrdEjec',fld:'vTFCONORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV61TFConOrdEjec_To',fld:'vTFCONORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV65TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV67TFConRangoCant',fld:'vTFCONRANGOCANT',pic:''},{av:'AV68TFConRangoCant_Sels',fld:'vTFCONRANGOCANT_SELS',pic:''},{av:'AV70TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV72TFConCondCodigo',fld:'vTFCONCONDCODIGO',pic:''},{av:'AV73TFConCondCodigo_Sels',fld:'vTFCONCONDCODIGO_SELS',pic:''},{av:'AV74TFConMostrarPos_Sel',fld:'vTFCONMOSTRARPOS_SEL',pic:'9'},{av:'AV76TFConAdelDescu_Sels',fld:'vTFCONADELDESCU_SELS',pic:''},{av:'AV77TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV78TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV79TFConSegunPla_Sel',fld:'vTFCONSEGUNPLA_SEL',pic:'9'},{av:'AV92TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV93TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV94TFConSIPAApo',fld:'vTFCONSIPAAPO',pic:'9'},{av:'AV95TFConSIPAApo_To',fld:'vTFCONSIPAAPO_TO',pic:'9'},{av:'AV96TFConSIPACont',fld:'vTFCONSIPACONT',pic:'9'},{av:'AV97TFConSIPACont_To',fld:'vTFCONSIPACONT_TO',pic:'9'},{av:'AV98TFConINSSJyPApo',fld:'vTFCONINSSJYPAPO',pic:'9'},{av:'AV99TFConINSSJyPApo_To',fld:'vTFCONINSSJYPAPO_TO',pic:'9'},{av:'AV100TFConINSSJyPCont',fld:'vTFCONINSSJYPCONT',pic:'9'},{av:'AV101TFConINSSJyPCont_To',fld:'vTFCONINSSJYPCONT_TO',pic:'9'},{av:'AV102TFConObraSocApo',fld:'vTFCONOBRASOCAPO',pic:'9'},{av:'AV103TFConObraSocApo_To',fld:'vTFCONOBRASOCAPO_TO',pic:'9'},{av:'AV104TFConObraSocCont',fld:'vTFCONOBRASOCCONT',pic:'9'},{av:'AV105TFConObraSocCont_To',fld:'vTFCONOBRASOCCONT_TO',pic:'9'},{av:'AV106TFConFonSolRedApo',fld:'vTFCONFONSOLREDAPO',pic:'9'},{av:'AV107TFConFonSolRedApo_To',fld:'vTFCONFONSOLREDAPO_TO',pic:'9'},{av:'AV108TFConFonSolRedCont',fld:'vTFCONFONSOLREDCONT',pic:'9'},{av:'AV109TFConFonSolRedCont_To',fld:'vTFCONFONSOLREDCONT_TO',pic:'9'},{av:'AV110TFConRenateaApo',fld:'vTFCONRENATEAAPO',pic:'9'},{av:'AV111TFConRenateaApo_To',fld:'vTFCONRENATEAAPO_TO',pic:'9'},{av:'AV112TFConRenateaCont',fld:'vTFCONRENATEACONT',pic:'9'},{av:'AV113TFConRenateaCont_To',fld:'vTFCONRENATEACONT_TO',pic:'9'},{av:'AV114TFConAsigFamCont',fld:'vTFCONASIGFAMCONT',pic:'9'},{av:'AV115TFConAsigFamCont_To',fld:'vTFCONASIGFAMCONT_TO',pic:'9'},{av:'AV116TFConFonNacEmpCont',fld:'vTFCONFONNACEMPCONT',pic:'9'},{av:'AV117TFConFonNacEmpCont_To',fld:'vTFCONFONNACEMPCONT_TO',pic:'9'},{av:'AV118TFConLeyRieTrabCont',fld:'vTFCONLEYRIETRABCONT',pic:'9'},{av:'AV119TFConLeyRieTrabCont_To',fld:'vTFCONLEYRIETRABCONT_TO',pic:'9'},{av:'AV120TFConRegDifApo',fld:'vTFCONREGDIFAPO',pic:'9'},{av:'AV121TFConRegDifApo_To',fld:'vTFCONREGDIFAPO_TO',pic:'9'},{av:'AV122TFConRegEspApo',fld:'vTFCONREGESPAPO',pic:'9'},{av:'AV123TFConRegEspApo_To',fld:'vTFCONREGESPAPO_TO',pic:'9'},{av:'AV126TFConceptoPais',fld:'vTFCONCEPTOPAIS',pic:'ZZZ9'},{av:'AV127TFConceptoPais_To',fld:'vTFCONCEPTOPAIS_TO',pic:'ZZZ9'},{av:'AV129TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV130TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV138TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV140TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV142TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV144TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV146TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV148TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV149TFConErrorSiCero_Sel',fld:'vTFCONERRORSICERO_SEL',pic:'9'},{av:'AV150TFCliPadre',fld:'vTFCLIPADRE',pic:'ZZZZZ9'},{av:'AV151TFCliPadre_To',fld:'vTFCLIPADRE_TO',pic:'ZZZZZ9'},{av:'AV153TFConPadre',fld:'vTFCONPADRE',pic:''},{av:'AV154TFConPadre_Sels',fld:'vTFCONPADRE_SELS',pic:''},{av:'AV155TFConPueNov_Sel',fld:'vTFCONPUENOV_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV87CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV161WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e17IB2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV170ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV183Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV159MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV31TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV32TFConOrden',fld:'vTFCONORDEN',pic:'ZZZZZZZ9'},{av:'AV33TFConOrden_To',fld:'vTFCONORDEN_TO',pic:'ZZZZZZZ9'},{av:'AV36TFConLiqBasica',fld:'vTFCONLIQBASICA',pic:'9'},{av:'AV37TFConLiqBasica_To',fld:'vTFCONLIQBASICA_TO',pic:'9'},{av:'AV39TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV40TFConFormula_Sels',fld:'vTFCONFORMULA_SELS',pic:''},{av:'AV42TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV43TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV44TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV45TFConForEditable_Sel',fld:'vTFCONFOREDITABLE_SEL',pic:'9'},{av:'AV47TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV49TFSubTipoConCod1',fld:'vTFSUBTIPOCONCOD1',pic:''},{av:'AV50TFSubTipoConCod1_Sels',fld:'vTFSUBTIPOCONCOD1_SELS',pic:''},{av:'AV52TFSubTipoConCod2',fld:'vTFSUBTIPOCONCOD2',pic:''},{av:'AV53TFSubTipoConCod2_Sels',fld:'vTFSUBTIPOCONCOD2_SELS',pic:''},{av:'AV55TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV56TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV58TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV59TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV60TFConOrdEjec',fld:'vTFCONORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV61TFConOrdEjec_To',fld:'vTFCONORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV65TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV67TFConRangoCant',fld:'vTFCONRANGOCANT',pic:''},{av:'AV68TFConRangoCant_Sels',fld:'vTFCONRANGOCANT_SELS',pic:''},{av:'AV70TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV72TFConCondCodigo',fld:'vTFCONCONDCODIGO',pic:''},{av:'AV73TFConCondCodigo_Sels',fld:'vTFCONCONDCODIGO_SELS',pic:''},{av:'AV74TFConMostrarPos_Sel',fld:'vTFCONMOSTRARPOS_SEL',pic:'9'},{av:'AV76TFConAdelDescu_Sels',fld:'vTFCONADELDESCU_SELS',pic:''},{av:'AV77TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV78TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV79TFConSegunPla_Sel',fld:'vTFCONSEGUNPLA_SEL',pic:'9'},{av:'AV92TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV93TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV94TFConSIPAApo',fld:'vTFCONSIPAAPO',pic:'9'},{av:'AV95TFConSIPAApo_To',fld:'vTFCONSIPAAPO_TO',pic:'9'},{av:'AV96TFConSIPACont',fld:'vTFCONSIPACONT',pic:'9'},{av:'AV97TFConSIPACont_To',fld:'vTFCONSIPACONT_TO',pic:'9'},{av:'AV98TFConINSSJyPApo',fld:'vTFCONINSSJYPAPO',pic:'9'},{av:'AV99TFConINSSJyPApo_To',fld:'vTFCONINSSJYPAPO_TO',pic:'9'},{av:'AV100TFConINSSJyPCont',fld:'vTFCONINSSJYPCONT',pic:'9'},{av:'AV101TFConINSSJyPCont_To',fld:'vTFCONINSSJYPCONT_TO',pic:'9'},{av:'AV102TFConObraSocApo',fld:'vTFCONOBRASOCAPO',pic:'9'},{av:'AV103TFConObraSocApo_To',fld:'vTFCONOBRASOCAPO_TO',pic:'9'},{av:'AV104TFConObraSocCont',fld:'vTFCONOBRASOCCONT',pic:'9'},{av:'AV105TFConObraSocCont_To',fld:'vTFCONOBRASOCCONT_TO',pic:'9'},{av:'AV106TFConFonSolRedApo',fld:'vTFCONFONSOLREDAPO',pic:'9'},{av:'AV107TFConFonSolRedApo_To',fld:'vTFCONFONSOLREDAPO_TO',pic:'9'},{av:'AV108TFConFonSolRedCont',fld:'vTFCONFONSOLREDCONT',pic:'9'},{av:'AV109TFConFonSolRedCont_To',fld:'vTFCONFONSOLREDCONT_TO',pic:'9'},{av:'AV110TFConRenateaApo',fld:'vTFCONRENATEAAPO',pic:'9'},{av:'AV111TFConRenateaApo_To',fld:'vTFCONRENATEAAPO_TO',pic:'9'},{av:'AV112TFConRenateaCont',fld:'vTFCONRENATEACONT',pic:'9'},{av:'AV113TFConRenateaCont_To',fld:'vTFCONRENATEACONT_TO',pic:'9'},{av:'AV114TFConAsigFamCont',fld:'vTFCONASIGFAMCONT',pic:'9'},{av:'AV115TFConAsigFamCont_To',fld:'vTFCONASIGFAMCONT_TO',pic:'9'},{av:'AV116TFConFonNacEmpCont',fld:'vTFCONFONNACEMPCONT',pic:'9'},{av:'AV117TFConFonNacEmpCont_To',fld:'vTFCONFONNACEMPCONT_TO',pic:'9'},{av:'AV118TFConLeyRieTrabCont',fld:'vTFCONLEYRIETRABCONT',pic:'9'},{av:'AV119TFConLeyRieTrabCont_To',fld:'vTFCONLEYRIETRABCONT_TO',pic:'9'},{av:'AV120TFConRegDifApo',fld:'vTFCONREGDIFAPO',pic:'9'},{av:'AV121TFConRegDifApo_To',fld:'vTFCONREGDIFAPO_TO',pic:'9'},{av:'AV122TFConRegEspApo',fld:'vTFCONREGESPAPO',pic:'9'},{av:'AV123TFConRegEspApo_To',fld:'vTFCONREGESPAPO_TO',pic:'9'},{av:'AV126TFConceptoPais',fld:'vTFCONCEPTOPAIS',pic:'ZZZ9'},{av:'AV127TFConceptoPais_To',fld:'vTFCONCEPTOPAIS_TO',pic:'ZZZ9'},{av:'AV129TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV130TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV138TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV140TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV142TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV144TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV146TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV148TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV149TFConErrorSiCero_Sel',fld:'vTFCONERRORSICERO_SEL',pic:'9'},{av:'AV150TFCliPadre',fld:'vTFCLIPADRE',pic:'ZZZZZ9'},{av:'AV151TFCliPadre_To',fld:'vTFCLIPADRE_TO',pic:'ZZZZZ9'},{av:'AV153TFConPadre',fld:'vTFCONPADRE',pic:''},{av:'AV154TFConPadre_Sels',fld:'vTFCONPADRE_SELS',pic:''},{av:'AV155TFConPueNov_Sel',fld:'vTFCONPUENOV_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV87CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV161WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV155TFConPueNov_Sel',fld:'vTFCONPUENOV_SEL',pic:'9'},{av:'AV153TFConPadre',fld:'vTFCONPADRE',pic:''},{av:'AV152TFConPadre_SelsJson',fld:'vTFCONPADRE_SELSJSON',pic:''},{av:'AV154TFConPadre_Sels',fld:'vTFCONPADRE_SELS',pic:''},{av:'AV150TFCliPadre',fld:'vTFCLIPADRE',pic:'ZZZZZ9'},{av:'AV151TFCliPadre_To',fld:'vTFCLIPADRE_TO',pic:'ZZZZZ9'},{av:'AV149TFConErrorSiCero_Sel',fld:'vTFCONERRORSICERO_SEL',pic:'9'},{av:'AV147TFConBaseOSDif_SelsJson',fld:'vTFCONBASEOSDIF_SELSJSON',pic:''},{av:'AV148TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV145TFConBaseAnt_SelsJson',fld:'vTFCONBASEANT_SELSJSON',pic:''},{av:'AV146TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV143TFConBasePres_SelsJson',fld:'vTFCONBASEPRES_SELSJSON',pic:''},{av:'AV144TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV141TFConBaseHorExtProm_SelsJson',fld:'vTFCONBASEHOREXTPROM_SELSJSON',pic:''},{av:'AV142TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV139TFConBaseFerProm_SelsJson',fld:'vTFCONBASEFERPROM_SELSJSON',pic:''},{av:'AV140TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV137TFConBaseLicProm_SelsJson',fld:'vTFCONBASELICPROM_SELSJSON',pic:''},{av:'AV138TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV129TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV128TFConceptoConveCodigo_SelsJson',fld:'vTFCONCEPTOCONVECODIGO_SELSJSON',pic:''},{av:'AV130TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV126TFConceptoPais',fld:'vTFCONCEPTOPAIS',pic:'ZZZ9'},{av:'AV127TFConceptoPais_To',fld:'vTFCONCEPTOPAIS_TO',pic:'ZZZ9'},{av:'AV122TFConRegEspApo',fld:'vTFCONREGESPAPO',pic:'9'},{av:'AV123TFConRegEspApo_To',fld:'vTFCONREGESPAPO_TO',pic:'9'},{av:'AV120TFConRegDifApo',fld:'vTFCONREGDIFAPO',pic:'9'},{av:'AV121TFConRegDifApo_To',fld:'vTFCONREGDIFAPO_TO',pic:'9'},{av:'AV118TFConLeyRieTrabCont',fld:'vTFCONLEYRIETRABCONT',pic:'9'},{av:'AV119TFConLeyRieTrabCont_To',fld:'vTFCONLEYRIETRABCONT_TO',pic:'9'},{av:'AV116TFConFonNacEmpCont',fld:'vTFCONFONNACEMPCONT',pic:'9'},{av:'AV117TFConFonNacEmpCont_To',fld:'vTFCONFONNACEMPCONT_TO',pic:'9'},{av:'AV114TFConAsigFamCont',fld:'vTFCONASIGFAMCONT',pic:'9'},{av:'AV115TFConAsigFamCont_To',fld:'vTFCONASIGFAMCONT_TO',pic:'9'},{av:'AV112TFConRenateaCont',fld:'vTFCONRENATEACONT',pic:'9'},{av:'AV113TFConRenateaCont_To',fld:'vTFCONRENATEACONT_TO',pic:'9'},{av:'AV110TFConRenateaApo',fld:'vTFCONRENATEAAPO',pic:'9'},{av:'AV111TFConRenateaApo_To',fld:'vTFCONRENATEAAPO_TO',pic:'9'},{av:'AV108TFConFonSolRedCont',fld:'vTFCONFONSOLREDCONT',pic:'9'},{av:'AV109TFConFonSolRedCont_To',fld:'vTFCONFONSOLREDCONT_TO',pic:'9'},{av:'AV106TFConFonSolRedApo',fld:'vTFCONFONSOLREDAPO',pic:'9'},{av:'AV107TFConFonSolRedApo_To',fld:'vTFCONFONSOLREDAPO_TO',pic:'9'},{av:'AV104TFConObraSocCont',fld:'vTFCONOBRASOCCONT',pic:'9'},{av:'AV105TFConObraSocCont_To',fld:'vTFCONOBRASOCCONT_TO',pic:'9'},{av:'AV102TFConObraSocApo',fld:'vTFCONOBRASOCAPO',pic:'9'},{av:'AV103TFConObraSocApo_To',fld:'vTFCONOBRASOCAPO_TO',pic:'9'},{av:'AV100TFConINSSJyPCont',fld:'vTFCONINSSJYPCONT',pic:'9'},{av:'AV101TFConINSSJyPCont_To',fld:'vTFCONINSSJYPCONT_TO',pic:'9'},{av:'AV98TFConINSSJyPApo',fld:'vTFCONINSSJYPAPO',pic:'9'},{av:'AV99TFConINSSJyPApo_To',fld:'vTFCONINSSJYPAPO_TO',pic:'9'},{av:'AV96TFConSIPACont',fld:'vTFCONSIPACONT',pic:'9'},{av:'AV97TFConSIPACont_To',fld:'vTFCONSIPACONT_TO',pic:'9'},{av:'AV94TFConSIPAApo',fld:'vTFCONSIPAAPO',pic:'9'},{av:'AV95TFConSIPAApo_To',fld:'vTFCONSIPAAPO_TO',pic:'9'},{av:'AV92TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV91TFConCodAfip_SelsJson',fld:'vTFCONCODAFIP_SELSJSON',pic:''},{av:'AV93TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV79TFConSegunPla_Sel',fld:'vTFCONSEGUNPLA_SEL',pic:'9'},{av:'AV77TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV78TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV75TFConAdelDescu_SelsJson',fld:'vTFCONADELDESCU_SELSJSON',pic:''},{av:'AV76TFConAdelDescu_Sels',fld:'vTFCONADELDESCU_SELS',pic:''},{av:'AV74TFConMostrarPos_Sel',fld:'vTFCONMOSTRARPOS_SEL',pic:'9'},{av:'AV72TFConCondCodigo',fld:'vTFCONCONDCODIGO',pic:''},{av:'AV71TFConCondCodigo_SelsJson',fld:'vTFCONCONDCODIGO_SELSJSON',pic:''},{av:'AV73TFConCondCodigo_Sels',fld:'vTFCONCONDCODIGO_SELS',pic:''},{av:'AV69TFConCondicion_SelsJson',fld:'vTFCONCONDICION_SELSJSON',pic:''},{av:'AV70TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV67TFConRangoCant',fld:'vTFCONRANGOCANT',pic:''},{av:'AV66TFConRangoCant_SelsJson',fld:'vTFCONRANGOCANT_SELSJSON',pic:''},{av:'AV68TFConRangoCant_Sels',fld:'vTFCONRANGOCANT_SELS',pic:''},{av:'AV65TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV60TFConOrdEjec',fld:'vTFCONORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV61TFConOrdEjec_To',fld:'vTFCONORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV58TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV57TFConClasifAux_SelsJson',fld:'vTFCONCLASIFAUX_SELSJSON',pic:''},{av:'AV59TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV55TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV54TFConTipoLiqAux_SelsJson',fld:'vTFCONTIPOLIQAUX_SELSJSON',pic:''},{av:'AV56TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV52TFSubTipoConCod2',fld:'vTFSUBTIPOCONCOD2',pic:''},{av:'AV51TFSubTipoConCod2_SelsJson',fld:'vTFSUBTIPOCONCOD2_SELSJSON',pic:''},{av:'AV53TFSubTipoConCod2_Sels',fld:'vTFSUBTIPOCONCOD2_SELS',pic:''},{av:'AV49TFSubTipoConCod1',fld:'vTFSUBTIPOCONCOD1',pic:''},{av:'AV48TFSubTipoConCod1_SelsJson',fld:'vTFSUBTIPOCONCOD1_SELSJSON',pic:''},{av:'AV50TFSubTipoConCod1_Sels',fld:'vTFSUBTIPOCONCOD1_SELS',pic:''},{av:'AV46TFTipoConCod_SelsJson',fld:'vTFTIPOCONCOD_SELSJSON',pic:''},{av:'AV47TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV45TFConForEditable_Sel',fld:'vTFCONFOREDITABLE_SEL',pic:'9'},{av:'AV44TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV42TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV41TFConObservacion_SelsJson',fld:'vTFCONOBSERVACION_SELSJSON',pic:''},{av:'AV43TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV39TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV38TFConFormula_SelsJson',fld:'vTFCONFORMULA_SELSJSON',pic:''},{av:'AV40TFConFormula_Sels',fld:'vTFCONFORMULA_SELS',pic:''},{av:'AV36TFConLiqBasica',fld:'vTFCONLIQBASICA',pic:'9'},{av:'AV37TFConLiqBasica_To',fld:'vTFCONLIQBASICA_TO',pic:'9'},{av:'AV32TFConOrden',fld:'vTFCONORDEN',pic:'ZZZZZZZ9'},{av:'AV33TFConOrden_To',fld:'vTFCONORDEN_TO',pic:'ZZZZZZZ9'},{av:'AV30TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV29TFConDescrip_SelsJson',fld:'vTFCONDESCRIP_SELSJSON',pic:''},{av:'AV31TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV26TFConCodigo_SelsJson',fld:'vTFCONCODIGO_SELSJSON',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e23IB2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A26ConCodigo',fld:'CONCODIGO',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV158Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV157VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e13IB2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV170ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV183Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV159MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV31TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV32TFConOrden',fld:'vTFCONORDEN',pic:'ZZZZZZZ9'},{av:'AV33TFConOrden_To',fld:'vTFCONORDEN_TO',pic:'ZZZZZZZ9'},{av:'AV36TFConLiqBasica',fld:'vTFCONLIQBASICA',pic:'9'},{av:'AV37TFConLiqBasica_To',fld:'vTFCONLIQBASICA_TO',pic:'9'},{av:'AV39TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV40TFConFormula_Sels',fld:'vTFCONFORMULA_SELS',pic:''},{av:'AV42TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV43TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV44TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV45TFConForEditable_Sel',fld:'vTFCONFOREDITABLE_SEL',pic:'9'},{av:'AV47TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV49TFSubTipoConCod1',fld:'vTFSUBTIPOCONCOD1',pic:''},{av:'AV50TFSubTipoConCod1_Sels',fld:'vTFSUBTIPOCONCOD1_SELS',pic:''},{av:'AV52TFSubTipoConCod2',fld:'vTFSUBTIPOCONCOD2',pic:''},{av:'AV53TFSubTipoConCod2_Sels',fld:'vTFSUBTIPOCONCOD2_SELS',pic:''},{av:'AV55TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV56TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV58TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV59TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV60TFConOrdEjec',fld:'vTFCONORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV61TFConOrdEjec_To',fld:'vTFCONORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV65TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV67TFConRangoCant',fld:'vTFCONRANGOCANT',pic:''},{av:'AV68TFConRangoCant_Sels',fld:'vTFCONRANGOCANT_SELS',pic:''},{av:'AV70TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV72TFConCondCodigo',fld:'vTFCONCONDCODIGO',pic:''},{av:'AV73TFConCondCodigo_Sels',fld:'vTFCONCONDCODIGO_SELS',pic:''},{av:'AV74TFConMostrarPos_Sel',fld:'vTFCONMOSTRARPOS_SEL',pic:'9'},{av:'AV76TFConAdelDescu_Sels',fld:'vTFCONADELDESCU_SELS',pic:''},{av:'AV77TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV78TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV79TFConSegunPla_Sel',fld:'vTFCONSEGUNPLA_SEL',pic:'9'},{av:'AV92TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV93TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV94TFConSIPAApo',fld:'vTFCONSIPAAPO',pic:'9'},{av:'AV95TFConSIPAApo_To',fld:'vTFCONSIPAAPO_TO',pic:'9'},{av:'AV96TFConSIPACont',fld:'vTFCONSIPACONT',pic:'9'},{av:'AV97TFConSIPACont_To',fld:'vTFCONSIPACONT_TO',pic:'9'},{av:'AV98TFConINSSJyPApo',fld:'vTFCONINSSJYPAPO',pic:'9'},{av:'AV99TFConINSSJyPApo_To',fld:'vTFCONINSSJYPAPO_TO',pic:'9'},{av:'AV100TFConINSSJyPCont',fld:'vTFCONINSSJYPCONT',pic:'9'},{av:'AV101TFConINSSJyPCont_To',fld:'vTFCONINSSJYPCONT_TO',pic:'9'},{av:'AV102TFConObraSocApo',fld:'vTFCONOBRASOCAPO',pic:'9'},{av:'AV103TFConObraSocApo_To',fld:'vTFCONOBRASOCAPO_TO',pic:'9'},{av:'AV104TFConObraSocCont',fld:'vTFCONOBRASOCCONT',pic:'9'},{av:'AV105TFConObraSocCont_To',fld:'vTFCONOBRASOCCONT_TO',pic:'9'},{av:'AV106TFConFonSolRedApo',fld:'vTFCONFONSOLREDAPO',pic:'9'},{av:'AV107TFConFonSolRedApo_To',fld:'vTFCONFONSOLREDAPO_TO',pic:'9'},{av:'AV108TFConFonSolRedCont',fld:'vTFCONFONSOLREDCONT',pic:'9'},{av:'AV109TFConFonSolRedCont_To',fld:'vTFCONFONSOLREDCONT_TO',pic:'9'},{av:'AV110TFConRenateaApo',fld:'vTFCONRENATEAAPO',pic:'9'},{av:'AV111TFConRenateaApo_To',fld:'vTFCONRENATEAAPO_TO',pic:'9'},{av:'AV112TFConRenateaCont',fld:'vTFCONRENATEACONT',pic:'9'},{av:'AV113TFConRenateaCont_To',fld:'vTFCONRENATEACONT_TO',pic:'9'},{av:'AV114TFConAsigFamCont',fld:'vTFCONASIGFAMCONT',pic:'9'},{av:'AV115TFConAsigFamCont_To',fld:'vTFCONASIGFAMCONT_TO',pic:'9'},{av:'AV116TFConFonNacEmpCont',fld:'vTFCONFONNACEMPCONT',pic:'9'},{av:'AV117TFConFonNacEmpCont_To',fld:'vTFCONFONNACEMPCONT_TO',pic:'9'},{av:'AV118TFConLeyRieTrabCont',fld:'vTFCONLEYRIETRABCONT',pic:'9'},{av:'AV119TFConLeyRieTrabCont_To',fld:'vTFCONLEYRIETRABCONT_TO',pic:'9'},{av:'AV120TFConRegDifApo',fld:'vTFCONREGDIFAPO',pic:'9'},{av:'AV121TFConRegDifApo_To',fld:'vTFCONREGDIFAPO_TO',pic:'9'},{av:'AV122TFConRegEspApo',fld:'vTFCONREGESPAPO',pic:'9'},{av:'AV123TFConRegEspApo_To',fld:'vTFCONREGESPAPO_TO',pic:'9'},{av:'AV126TFConceptoPais',fld:'vTFCONCEPTOPAIS',pic:'ZZZ9'},{av:'AV127TFConceptoPais_To',fld:'vTFCONCEPTOPAIS_TO',pic:'ZZZ9'},{av:'AV129TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV130TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV138TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV140TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV142TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV144TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV146TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV148TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV149TFConErrorSiCero_Sel',fld:'vTFCONERRORSICERO_SEL',pic:'9'},{av:'AV150TFCliPadre',fld:'vTFCLIPADRE',pic:'ZZZZZ9'},{av:'AV151TFCliPadre_To',fld:'vTFCLIPADRE_TO',pic:'ZZZZZ9'},{av:'AV153TFConPadre',fld:'vTFCONPADRE',pic:''},{av:'AV154TFConPadre_Sels',fld:'vTFCONPADRE_SELS',pic:''},{av:'AV155TFConPueNov_Sel',fld:'vTFCONPUENOV_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV87CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV161WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV170ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtCliCod_Visible',ctrl:'CLICOD',prop:'Visible'},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtConDescrip_Visible',ctrl:'CONDESCRIP',prop:'Visible'},{av:'edtConOrden_Visible',ctrl:'CONORDEN',prop:'Visible'},{av:'cmbConVigencia'},{av:'edtConLiqBasica_Visible',ctrl:'CONLIQBASICA',prop:'Visible'},{av:'edtConFormula_Visible',ctrl:'CONFORMULA',prop:'Visible'},{av:'edtConObservacion_Visible',ctrl:'CONOBSERVACION',prop:'Visible'},{av:'chkConVariable.getVisible()',ctrl:'CONVARIABLE',prop:'Visible'},{av:'chkConForEditable.getVisible()',ctrl:'CONFOREDITABLE',prop:'Visible'},{av:'cmbTipoConCod'},{av:'edtSubTipoConCod1_Visible',ctrl:'SUBTIPOCONCOD1',prop:'Visible'},{av:'edtSubTipoConCod2_Visible',ctrl:'SUBTIPOCONCOD2',prop:'Visible'},{av:'edtConTipoLiqAux_Visible',ctrl:'CONTIPOLIQAUX',prop:'Visible'},{av:'edtConClasifAux_Visible',ctrl:'CONCLASIFAUX',prop:'Visible'},{av:'edtConOrdEjec_Visible',ctrl:'CONORDEJEC',prop:'Visible'},{av:'chkConRecalcular.getVisible()',ctrl:'CONRECALCULAR',prop:'Visible'},{av:'edtConRangoCant_Visible',ctrl:'CONRANGOCANT',prop:'Visible'},{av:'cmbConCondicion'},{av:'edtConCondCodigo_Visible',ctrl:'CONCONDCODIGO',prop:'Visible'},{av:'chkConMostrarPos.getVisible()',ctrl:'CONMOSTRARPOS',prop:'Visible'},{av:'cmbConAdelDescu'},{av:'edtAplIIGG_Visible',ctrl:'APLIIGG',prop:'Visible'},{av:'chkConSegunPla.getVisible()',ctrl:'CONSEGUNPLA',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtConCodAfip_Visible',ctrl:'CONCODAFIP',prop:'Visible'},{av:'edtConSIPAApo_Visible',ctrl:'CONSIPAAPO',prop:'Visible'},{av:'edtConSIPACont_Visible',ctrl:'CONSIPACONT',prop:'Visible'},{av:'edtConINSSJyPApo_Visible',ctrl:'CONINSSJYPAPO',prop:'Visible'},{av:'edtConINSSJyPCont_Visible',ctrl:'CONINSSJYPCONT',prop:'Visible'},{av:'edtConObraSocApo_Visible',ctrl:'CONOBRASOCAPO',prop:'Visible'},{av:'edtConObraSocCont_Visible',ctrl:'CONOBRASOCCONT',prop:'Visible'},{av:'edtConFonSolRedApo_Visible',ctrl:'CONFONSOLREDAPO',prop:'Visible'},{av:'edtConFonSolRedCont_Visible',ctrl:'CONFONSOLREDCONT',prop:'Visible'},{av:'edtConRenateaApo_Visible',ctrl:'CONRENATEAAPO',prop:'Visible'},{av:'edtConRenateaCont_Visible',ctrl:'CONRENATEACONT',prop:'Visible'},{av:'edtConAsigFamCont_Visible',ctrl:'CONASIGFAMCONT',prop:'Visible'},{av:'edtConFonNacEmpCont_Visible',ctrl:'CONFONNACEMPCONT',prop:'Visible'},{av:'edtConLeyRieTrabCont_Visible',ctrl:'CONLEYRIETRABCONT',prop:'Visible'},{av:'edtConRegDifApo_Visible',ctrl:'CONREGDIFAPO',prop:'Visible'},{av:'edtConRegEspApo_Visible',ctrl:'CONREGESPAPO',prop:'Visible'},{av:'cmbConSacDeven'},{av:'edtConceptoPais_Visible',ctrl:'CONCEPTOPAIS',prop:'Visible'},{av:'edtConceptoConveCodigo_Visible',ctrl:'CONCEPTOCONVECODIGO',prop:'Visible'},{av:'cmbConBaseLic'},{av:'cmbConBaseLicProm'},{av:'cmbConBaseFer'},{av:'cmbConBaseFerProm'},{av:'cmbConBaseHorExt'},{av:'cmbConBaseHorExtProm'},{av:'cmbConBasePres'},{av:'cmbConBaseAnt'},{av:'cmbConBaseOSDif'},{av:'chkConErrorSiCero.getVisible()',ctrl:'CONERRORSICERO',prop:'Visible'},{av:'edtCliPadre_Visible',ctrl:'CLIPADRE',prop:'Visible'},{av:'edtConPadre_Visible',ctrl:'CONPADRE',prop:'Visible'},{av:'chkConPueNov.getVisible()',ctrl:'CONPUENOV',prop:'Visible'},{av:'AV82GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV83GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV84GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV168ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e14IB2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV170ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV183Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV159MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV31TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV32TFConOrden',fld:'vTFCONORDEN',pic:'ZZZZZZZ9'},{av:'AV33TFConOrden_To',fld:'vTFCONORDEN_TO',pic:'ZZZZZZZ9'},{av:'AV36TFConLiqBasica',fld:'vTFCONLIQBASICA',pic:'9'},{av:'AV37TFConLiqBasica_To',fld:'vTFCONLIQBASICA_TO',pic:'9'},{av:'AV39TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV40TFConFormula_Sels',fld:'vTFCONFORMULA_SELS',pic:''},{av:'AV42TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV43TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV44TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV45TFConForEditable_Sel',fld:'vTFCONFOREDITABLE_SEL',pic:'9'},{av:'AV47TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV49TFSubTipoConCod1',fld:'vTFSUBTIPOCONCOD1',pic:''},{av:'AV50TFSubTipoConCod1_Sels',fld:'vTFSUBTIPOCONCOD1_SELS',pic:''},{av:'AV52TFSubTipoConCod2',fld:'vTFSUBTIPOCONCOD2',pic:''},{av:'AV53TFSubTipoConCod2_Sels',fld:'vTFSUBTIPOCONCOD2_SELS',pic:''},{av:'AV55TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV56TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV58TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV59TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV60TFConOrdEjec',fld:'vTFCONORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV61TFConOrdEjec_To',fld:'vTFCONORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV65TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV67TFConRangoCant',fld:'vTFCONRANGOCANT',pic:''},{av:'AV68TFConRangoCant_Sels',fld:'vTFCONRANGOCANT_SELS',pic:''},{av:'AV70TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV72TFConCondCodigo',fld:'vTFCONCONDCODIGO',pic:''},{av:'AV73TFConCondCodigo_Sels',fld:'vTFCONCONDCODIGO_SELS',pic:''},{av:'AV74TFConMostrarPos_Sel',fld:'vTFCONMOSTRARPOS_SEL',pic:'9'},{av:'AV76TFConAdelDescu_Sels',fld:'vTFCONADELDESCU_SELS',pic:''},{av:'AV77TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV78TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV79TFConSegunPla_Sel',fld:'vTFCONSEGUNPLA_SEL',pic:'9'},{av:'AV92TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV93TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV94TFConSIPAApo',fld:'vTFCONSIPAAPO',pic:'9'},{av:'AV95TFConSIPAApo_To',fld:'vTFCONSIPAAPO_TO',pic:'9'},{av:'AV96TFConSIPACont',fld:'vTFCONSIPACONT',pic:'9'},{av:'AV97TFConSIPACont_To',fld:'vTFCONSIPACONT_TO',pic:'9'},{av:'AV98TFConINSSJyPApo',fld:'vTFCONINSSJYPAPO',pic:'9'},{av:'AV99TFConINSSJyPApo_To',fld:'vTFCONINSSJYPAPO_TO',pic:'9'},{av:'AV100TFConINSSJyPCont',fld:'vTFCONINSSJYPCONT',pic:'9'},{av:'AV101TFConINSSJyPCont_To',fld:'vTFCONINSSJYPCONT_TO',pic:'9'},{av:'AV102TFConObraSocApo',fld:'vTFCONOBRASOCAPO',pic:'9'},{av:'AV103TFConObraSocApo_To',fld:'vTFCONOBRASOCAPO_TO',pic:'9'},{av:'AV104TFConObraSocCont',fld:'vTFCONOBRASOCCONT',pic:'9'},{av:'AV105TFConObraSocCont_To',fld:'vTFCONOBRASOCCONT_TO',pic:'9'},{av:'AV106TFConFonSolRedApo',fld:'vTFCONFONSOLREDAPO',pic:'9'},{av:'AV107TFConFonSolRedApo_To',fld:'vTFCONFONSOLREDAPO_TO',pic:'9'},{av:'AV108TFConFonSolRedCont',fld:'vTFCONFONSOLREDCONT',pic:'9'},{av:'AV109TFConFonSolRedCont_To',fld:'vTFCONFONSOLREDCONT_TO',pic:'9'},{av:'AV110TFConRenateaApo',fld:'vTFCONRENATEAAPO',pic:'9'},{av:'AV111TFConRenateaApo_To',fld:'vTFCONRENATEAAPO_TO',pic:'9'},{av:'AV112TFConRenateaCont',fld:'vTFCONRENATEACONT',pic:'9'},{av:'AV113TFConRenateaCont_To',fld:'vTFCONRENATEACONT_TO',pic:'9'},{av:'AV114TFConAsigFamCont',fld:'vTFCONASIGFAMCONT',pic:'9'},{av:'AV115TFConAsigFamCont_To',fld:'vTFCONASIGFAMCONT_TO',pic:'9'},{av:'AV116TFConFonNacEmpCont',fld:'vTFCONFONNACEMPCONT',pic:'9'},{av:'AV117TFConFonNacEmpCont_To',fld:'vTFCONFONNACEMPCONT_TO',pic:'9'},{av:'AV118TFConLeyRieTrabCont',fld:'vTFCONLEYRIETRABCONT',pic:'9'},{av:'AV119TFConLeyRieTrabCont_To',fld:'vTFCONLEYRIETRABCONT_TO',pic:'9'},{av:'AV120TFConRegDifApo',fld:'vTFCONREGDIFAPO',pic:'9'},{av:'AV121TFConRegDifApo_To',fld:'vTFCONREGDIFAPO_TO',pic:'9'},{av:'AV122TFConRegEspApo',fld:'vTFCONREGESPAPO',pic:'9'},{av:'AV123TFConRegEspApo_To',fld:'vTFCONREGESPAPO_TO',pic:'9'},{av:'AV126TFConceptoPais',fld:'vTFCONCEPTOPAIS',pic:'ZZZ9'},{av:'AV127TFConceptoPais_To',fld:'vTFCONCEPTOPAIS_TO',pic:'ZZZ9'},{av:'AV129TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV130TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV138TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV140TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV142TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV144TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV146TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV148TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV149TFConErrorSiCero_Sel',fld:'vTFCONERRORSICERO_SEL',pic:'9'},{av:'AV150TFCliPadre',fld:'vTFCLIPADRE',pic:'ZZZZZ9'},{av:'AV151TFCliPadre_To',fld:'vTFCLIPADRE_TO',pic:'ZZZZZ9'},{av:'AV153TFConPadre',fld:'vTFCONPADRE',pic:''},{av:'AV154TFConPadre_Sels',fld:'vTFCONPADRE_SELS',pic:''},{av:'AV155TFConPueNov_Sel',fld:'vTFCONPUENOV_SEL',pic:'9'},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV87CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV161WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV26TFConCodigo_SelsJson',fld:'vTFCONCODIGO_SELSJSON',pic:''},{av:'AV29TFConDescrip_SelsJson',fld:'vTFCONDESCRIP_SELSJSON',pic:''},{av:'AV38TFConFormula_SelsJson',fld:'vTFCONFORMULA_SELSJSON',pic:''},{av:'AV41TFConObservacion_SelsJson',fld:'vTFCONOBSERVACION_SELSJSON',pic:''},{av:'AV46TFTipoConCod_SelsJson',fld:'vTFTIPOCONCOD_SELSJSON',pic:''},{av:'AV48TFSubTipoConCod1_SelsJson',fld:'vTFSUBTIPOCONCOD1_SELSJSON',pic:''},{av:'AV51TFSubTipoConCod2_SelsJson',fld:'vTFSUBTIPOCONCOD2_SELSJSON',pic:''},{av:'AV54TFConTipoLiqAux_SelsJson',fld:'vTFCONTIPOLIQAUX_SELSJSON',pic:''},{av:'AV57TFConClasifAux_SelsJson',fld:'vTFCONCLASIFAUX_SELSJSON',pic:''},{av:'AV66TFConRangoCant_SelsJson',fld:'vTFCONRANGOCANT_SELSJSON',pic:''},{av:'AV69TFConCondicion_SelsJson',fld:'vTFCONCONDICION_SELSJSON',pic:''},{av:'AV71TFConCondCodigo_SelsJson',fld:'vTFCONCONDCODIGO_SELSJSON',pic:''},{av:'AV75TFConAdelDescu_SelsJson',fld:'vTFCONADELDESCU_SELSJSON',pic:''},{av:'AV91TFConCodAfip_SelsJson',fld:'vTFCONCODAFIP_SELSJSON',pic:''},{av:'AV128TFConceptoConveCodigo_SelsJson',fld:'vTFCONCEPTOCONVECODIGO_SELSJSON',pic:''},{av:'AV137TFConBaseLicProm_SelsJson',fld:'vTFCONBASELICPROM_SELSJSON',pic:''},{av:'AV139TFConBaseFerProm_SelsJson',fld:'vTFCONBASEFERPROM_SELSJSON',pic:''},{av:'AV141TFConBaseHorExtProm_SelsJson',fld:'vTFCONBASEHOREXTPROM_SELSJSON',pic:''},{av:'AV143TFConBasePres_SelsJson',fld:'vTFCONBASEPRES_SELSJSON',pic:''},{av:'AV145TFConBaseAnt_SelsJson',fld:'vTFCONBASEANT_SELSJSON',pic:''},{av:'AV147TFConBaseOSDif_SelsJson',fld:'vTFCONBASEOSDIF_SELSJSON',pic:''},{av:'AV152TFConPadre_SelsJson',fld:'vTFCONPADRE_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV170ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV24TFCliCod',fld:'vTFCLICOD',pic:'ZZZZZ9'},{av:'AV25TFCliCod_To',fld:'vTFCLICOD_TO',pic:'ZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV30TFConDescrip',fld:'vTFCONDESCRIP',pic:''},{av:'AV31TFConDescrip_Sels',fld:'vTFCONDESCRIP_SELS',pic:''},{av:'AV32TFConOrden',fld:'vTFCONORDEN',pic:'ZZZZZZZ9'},{av:'AV33TFConOrden_To',fld:'vTFCONORDEN_TO',pic:'ZZZZZZZ9'},{av:'AV36TFConLiqBasica',fld:'vTFCONLIQBASICA',pic:'9'},{av:'AV37TFConLiqBasica_To',fld:'vTFCONLIQBASICA_TO',pic:'9'},{av:'AV39TFConFormula',fld:'vTFCONFORMULA',pic:''},{av:'AV40TFConFormula_Sels',fld:'vTFCONFORMULA_SELS',pic:''},{av:'AV42TFConObservacion',fld:'vTFCONOBSERVACION',pic:''},{av:'AV43TFConObservacion_Sels',fld:'vTFCONOBSERVACION_SELS',pic:''},{av:'AV44TFConVariable_Sel',fld:'vTFCONVARIABLE_SEL',pic:'9'},{av:'AV45TFConForEditable_Sel',fld:'vTFCONFOREDITABLE_SEL',pic:'9'},{av:'AV47TFTipoConCod_Sels',fld:'vTFTIPOCONCOD_SELS',pic:''},{av:'AV49TFSubTipoConCod1',fld:'vTFSUBTIPOCONCOD1',pic:''},{av:'AV50TFSubTipoConCod1_Sels',fld:'vTFSUBTIPOCONCOD1_SELS',pic:''},{av:'AV52TFSubTipoConCod2',fld:'vTFSUBTIPOCONCOD2',pic:''},{av:'AV53TFSubTipoConCod2_Sels',fld:'vTFSUBTIPOCONCOD2_SELS',pic:''},{av:'AV55TFConTipoLiqAux',fld:'vTFCONTIPOLIQAUX',pic:''},{av:'AV56TFConTipoLiqAux_Sels',fld:'vTFCONTIPOLIQAUX_SELS',pic:''},{av:'AV58TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV59TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV60TFConOrdEjec',fld:'vTFCONORDEJEC',pic:'ZZZZZZZZZZZ9'},{av:'AV61TFConOrdEjec_To',fld:'vTFCONORDEJEC_TO',pic:'ZZZZZZZZZZZ9'},{av:'AV65TFConRecalcular_Sel',fld:'vTFCONRECALCULAR_SEL',pic:'9'},{av:'AV67TFConRangoCant',fld:'vTFCONRANGOCANT',pic:''},{av:'AV68TFConRangoCant_Sels',fld:'vTFCONRANGOCANT_SELS',pic:''},{av:'AV70TFConCondicion_Sels',fld:'vTFCONCONDICION_SELS',pic:''},{av:'AV72TFConCondCodigo',fld:'vTFCONCONDCODIGO',pic:''},{av:'AV73TFConCondCodigo_Sels',fld:'vTFCONCONDCODIGO_SELS',pic:''},{av:'AV74TFConMostrarPos_Sel',fld:'vTFCONMOSTRARPOS_SEL',pic:'9'},{av:'AV76TFConAdelDescu_Sels',fld:'vTFCONADELDESCU_SELS',pic:''},{av:'AV77TFAplIIGG',fld:'vTFAPLIIGG',pic:'ZZZ9'},{av:'AV78TFAplIIGG_To',fld:'vTFAPLIIGG_TO',pic:'ZZZ9'},{av:'AV79TFConSegunPla_Sel',fld:'vTFCONSEGUNPLA_SEL',pic:'9'},{av:'AV92TFConCodAfip',fld:'vTFCONCODAFIP',pic:''},{av:'AV93TFConCodAfip_Sels',fld:'vTFCONCODAFIP_SELS',pic:''},{av:'AV94TFConSIPAApo',fld:'vTFCONSIPAAPO',pic:'9'},{av:'AV95TFConSIPAApo_To',fld:'vTFCONSIPAAPO_TO',pic:'9'},{av:'AV96TFConSIPACont',fld:'vTFCONSIPACONT',pic:'9'},{av:'AV97TFConSIPACont_To',fld:'vTFCONSIPACONT_TO',pic:'9'},{av:'AV98TFConINSSJyPApo',fld:'vTFCONINSSJYPAPO',pic:'9'},{av:'AV99TFConINSSJyPApo_To',fld:'vTFCONINSSJYPAPO_TO',pic:'9'},{av:'AV100TFConINSSJyPCont',fld:'vTFCONINSSJYPCONT',pic:'9'},{av:'AV101TFConINSSJyPCont_To',fld:'vTFCONINSSJYPCONT_TO',pic:'9'},{av:'AV102TFConObraSocApo',fld:'vTFCONOBRASOCAPO',pic:'9'},{av:'AV103TFConObraSocApo_To',fld:'vTFCONOBRASOCAPO_TO',pic:'9'},{av:'AV104TFConObraSocCont',fld:'vTFCONOBRASOCCONT',pic:'9'},{av:'AV105TFConObraSocCont_To',fld:'vTFCONOBRASOCCONT_TO',pic:'9'},{av:'AV106TFConFonSolRedApo',fld:'vTFCONFONSOLREDAPO',pic:'9'},{av:'AV107TFConFonSolRedApo_To',fld:'vTFCONFONSOLREDAPO_TO',pic:'9'},{av:'AV108TFConFonSolRedCont',fld:'vTFCONFONSOLREDCONT',pic:'9'},{av:'AV109TFConFonSolRedCont_To',fld:'vTFCONFONSOLREDCONT_TO',pic:'9'},{av:'AV110TFConRenateaApo',fld:'vTFCONRENATEAAPO',pic:'9'},{av:'AV111TFConRenateaApo_To',fld:'vTFCONRENATEAAPO_TO',pic:'9'},{av:'AV112TFConRenateaCont',fld:'vTFCONRENATEACONT',pic:'9'},{av:'AV113TFConRenateaCont_To',fld:'vTFCONRENATEACONT_TO',pic:'9'},{av:'AV114TFConAsigFamCont',fld:'vTFCONASIGFAMCONT',pic:'9'},{av:'AV115TFConAsigFamCont_To',fld:'vTFCONASIGFAMCONT_TO',pic:'9'},{av:'AV116TFConFonNacEmpCont',fld:'vTFCONFONNACEMPCONT',pic:'9'},{av:'AV117TFConFonNacEmpCont_To',fld:'vTFCONFONNACEMPCONT_TO',pic:'9'},{av:'AV118TFConLeyRieTrabCont',fld:'vTFCONLEYRIETRABCONT',pic:'9'},{av:'AV119TFConLeyRieTrabCont_To',fld:'vTFCONLEYRIETRABCONT_TO',pic:'9'},{av:'AV120TFConRegDifApo',fld:'vTFCONREGDIFAPO',pic:'9'},{av:'AV121TFConRegDifApo_To',fld:'vTFCONREGDIFAPO_TO',pic:'9'},{av:'AV122TFConRegEspApo',fld:'vTFCONREGESPAPO',pic:'9'},{av:'AV123TFConRegEspApo_To',fld:'vTFCONREGESPAPO_TO',pic:'9'},{av:'AV126TFConceptoPais',fld:'vTFCONCEPTOPAIS',pic:'ZZZ9'},{av:'AV127TFConceptoPais_To',fld:'vTFCONCEPTOPAIS_TO',pic:'ZZZ9'},{av:'AV129TFConceptoConveCodigo',fld:'vTFCONCEPTOCONVECODIGO',pic:''},{av:'AV130TFConceptoConveCodigo_Sels',fld:'vTFCONCEPTOCONVECODIGO_SELS',pic:''},{av:'AV138TFConBaseLicProm_Sels',fld:'vTFCONBASELICPROM_SELS',pic:''},{av:'AV140TFConBaseFerProm_Sels',fld:'vTFCONBASEFERPROM_SELS',pic:''},{av:'AV142TFConBaseHorExtProm_Sels',fld:'vTFCONBASEHOREXTPROM_SELS',pic:''},{av:'AV144TFConBasePres_Sels',fld:'vTFCONBASEPRES_SELS',pic:''},{av:'AV146TFConBaseAnt_Sels',fld:'vTFCONBASEANT_SELS',pic:''},{av:'AV148TFConBaseOSDif_Sels',fld:'vTFCONBASEOSDIF_SELS',pic:''},{av:'AV149TFConErrorSiCero_Sel',fld:'vTFCONERRORSICERO_SEL',pic:'9'},{av:'AV150TFCliPadre',fld:'vTFCLIPADRE',pic:'ZZZZZ9'},{av:'AV151TFCliPadre_To',fld:'vTFCLIPADRE_TO',pic:'ZZZZZ9'},{av:'AV153TFConPadre',fld:'vTFCONPADRE',pic:''},{av:'AV154TFConPadre_Sels',fld:'vTFCONPADRE_SELS',pic:''},{av:'AV155TFConPueNov_Sel',fld:'vTFCONPUENOV_SEL',pic:'9'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV152TFConPadre_SelsJson',fld:'vTFCONPADRE_SELSJSON',pic:''},{av:'AV147TFConBaseOSDif_SelsJson',fld:'vTFCONBASEOSDIF_SELSJSON',pic:''},{av:'AV145TFConBaseAnt_SelsJson',fld:'vTFCONBASEANT_SELSJSON',pic:''},{av:'AV143TFConBasePres_SelsJson',fld:'vTFCONBASEPRES_SELSJSON',pic:''},{av:'AV141TFConBaseHorExtProm_SelsJson',fld:'vTFCONBASEHOREXTPROM_SELSJSON',pic:''},{av:'AV139TFConBaseFerProm_SelsJson',fld:'vTFCONBASEFERPROM_SELSJSON',pic:''},{av:'AV137TFConBaseLicProm_SelsJson',fld:'vTFCONBASELICPROM_SELSJSON',pic:''},{av:'AV128TFConceptoConveCodigo_SelsJson',fld:'vTFCONCEPTOCONVECODIGO_SELSJSON',pic:''},{av:'AV91TFConCodAfip_SelsJson',fld:'vTFCONCODAFIP_SELSJSON',pic:''},{av:'AV75TFConAdelDescu_SelsJson',fld:'vTFCONADELDESCU_SELSJSON',pic:''},{av:'AV71TFConCondCodigo_SelsJson',fld:'vTFCONCONDCODIGO_SELSJSON',pic:''},{av:'AV69TFConCondicion_SelsJson',fld:'vTFCONCONDICION_SELSJSON',pic:''},{av:'AV66TFConRangoCant_SelsJson',fld:'vTFCONRANGOCANT_SELSJSON',pic:''},{av:'AV57TFConClasifAux_SelsJson',fld:'vTFCONCLASIFAUX_SELSJSON',pic:''},{av:'AV54TFConTipoLiqAux_SelsJson',fld:'vTFCONTIPOLIQAUX_SELSJSON',pic:''},{av:'AV51TFSubTipoConCod2_SelsJson',fld:'vTFSUBTIPOCONCOD2_SELSJSON',pic:''},{av:'AV48TFSubTipoConCod1_SelsJson',fld:'vTFSUBTIPOCONCOD1_SELSJSON',pic:''},{av:'AV46TFTipoConCod_SelsJson',fld:'vTFTIPOCONCOD_SELSJSON',pic:''},{av:'AV41TFConObservacion_SelsJson',fld:'vTFCONOBSERVACION_SELSJSON',pic:''},{av:'AV38TFConFormula_SelsJson',fld:'vTFCONFORMULA_SELSJSON',pic:''},{av:'AV29TFConDescrip_SelsJson',fld:'vTFCONDESCRIP_SELSJSON',pic:''},{av:'AV26TFConCodigo_SelsJson',fld:'vTFCONCODIGO_SELSJSON',pic:''},{av:'AV87CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtCliCod_Visible',ctrl:'CLICOD',prop:'Visible'},{av:'edtConCodigo_Visible',ctrl:'CONCODIGO',prop:'Visible'},{av:'edtConDescrip_Visible',ctrl:'CONDESCRIP',prop:'Visible'},{av:'edtConOrden_Visible',ctrl:'CONORDEN',prop:'Visible'},{av:'cmbConVigencia'},{av:'edtConLiqBasica_Visible',ctrl:'CONLIQBASICA',prop:'Visible'},{av:'edtConFormula_Visible',ctrl:'CONFORMULA',prop:'Visible'},{av:'edtConObservacion_Visible',ctrl:'CONOBSERVACION',prop:'Visible'},{av:'chkConVariable.getVisible()',ctrl:'CONVARIABLE',prop:'Visible'},{av:'chkConForEditable.getVisible()',ctrl:'CONFOREDITABLE',prop:'Visible'},{av:'cmbTipoConCod'},{av:'edtSubTipoConCod1_Visible',ctrl:'SUBTIPOCONCOD1',prop:'Visible'},{av:'edtSubTipoConCod2_Visible',ctrl:'SUBTIPOCONCOD2',prop:'Visible'},{av:'edtConTipoLiqAux_Visible',ctrl:'CONTIPOLIQAUX',prop:'Visible'},{av:'edtConClasifAux_Visible',ctrl:'CONCLASIFAUX',prop:'Visible'},{av:'edtConOrdEjec_Visible',ctrl:'CONORDEJEC',prop:'Visible'},{av:'chkConRecalcular.getVisible()',ctrl:'CONRECALCULAR',prop:'Visible'},{av:'edtConRangoCant_Visible',ctrl:'CONRANGOCANT',prop:'Visible'},{av:'cmbConCondicion'},{av:'edtConCondCodigo_Visible',ctrl:'CONCONDCODIGO',prop:'Visible'},{av:'chkConMostrarPos.getVisible()',ctrl:'CONMOSTRARPOS',prop:'Visible'},{av:'cmbConAdelDescu'},{av:'edtAplIIGG_Visible',ctrl:'APLIIGG',prop:'Visible'},{av:'chkConSegunPla.getVisible()',ctrl:'CONSEGUNPLA',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtConCodAfip_Visible',ctrl:'CONCODAFIP',prop:'Visible'},{av:'edtConSIPAApo_Visible',ctrl:'CONSIPAAPO',prop:'Visible'},{av:'edtConSIPACont_Visible',ctrl:'CONSIPACONT',prop:'Visible'},{av:'edtConINSSJyPApo_Visible',ctrl:'CONINSSJYPAPO',prop:'Visible'},{av:'edtConINSSJyPCont_Visible',ctrl:'CONINSSJYPCONT',prop:'Visible'},{av:'edtConObraSocApo_Visible',ctrl:'CONOBRASOCAPO',prop:'Visible'},{av:'edtConObraSocCont_Visible',ctrl:'CONOBRASOCCONT',prop:'Visible'},{av:'edtConFonSolRedApo_Visible',ctrl:'CONFONSOLREDAPO',prop:'Visible'},{av:'edtConFonSolRedCont_Visible',ctrl:'CONFONSOLREDCONT',prop:'Visible'},{av:'edtConRenateaApo_Visible',ctrl:'CONRENATEAAPO',prop:'Visible'},{av:'edtConRenateaCont_Visible',ctrl:'CONRENATEACONT',prop:'Visible'},{av:'edtConAsigFamCont_Visible',ctrl:'CONASIGFAMCONT',prop:'Visible'},{av:'edtConFonNacEmpCont_Visible',ctrl:'CONFONNACEMPCONT',prop:'Visible'},{av:'edtConLeyRieTrabCont_Visible',ctrl:'CONLEYRIETRABCONT',prop:'Visible'},{av:'edtConRegDifApo_Visible',ctrl:'CONREGDIFAPO',prop:'Visible'},{av:'edtConRegEspApo_Visible',ctrl:'CONREGESPAPO',prop:'Visible'},{av:'cmbConSacDeven'},{av:'edtConceptoPais_Visible',ctrl:'CONCEPTOPAIS',prop:'Visible'},{av:'edtConceptoConveCodigo_Visible',ctrl:'CONCEPTOCONVECODIGO',prop:'Visible'},{av:'cmbConBaseLic'},{av:'cmbConBaseLicProm'},{av:'cmbConBaseFer'},{av:'cmbConBaseFerProm'},{av:'cmbConBaseHorExt'},{av:'cmbConBaseHorExtProm'},{av:'cmbConBasePres'},{av:'cmbConBaseAnt'},{av:'cmbConBaseOSDif'},{av:'chkConErrorSiCero.getVisible()',ctrl:'CONERRORSICERO',prop:'Visible'},{av:'edtCliPadre_Visible',ctrl:'CLIPADRE',prop:'Visible'},{av:'edtConPadre_Visible',ctrl:'CONPADRE',prop:'Visible'},{av:'chkConPueNov.getVisible()',ctrl:'CONPUENOV',prop:'Visible'},{av:'AV82GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV83GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV84GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV168ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOMOTIVOS'","{handler:'e11IB1',iparms:[{av:'AV159MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true}]");
      setEventMetadata("'DOMOTIVOS'",",oparms:[]}");
      setEventMetadata("'DOTIPOSLIQ'","{handler:'e12IB1',iparms:[{av:'AV159MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true}]");
      setEventMetadata("'DOTIPOSLIQ'",",oparms:[]}");
      setEventMetadata("'DOINSERT'","{handler:'e18IB2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A26ConCodigo',fld:'CONCODIGO',pic:'',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e19IB2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e20IB2',iparms:[{av:'AV161WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV159MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV87CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e24IB1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("NULL","{handler:'valid_Conpuenov',iparms:[]");
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
      wcpOAV159MenuOpcCod = "" ;
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
      AV159MenuOpcCod = "" ;
      AV21ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV183Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV27TFConCodigo = "" ;
      AV28TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV30TFConDescrip = "" ;
      AV31TFConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFConFormula = "" ;
      AV40TFConFormula_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFConObservacion = "" ;
      AV43TFConObservacion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47TFTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFSubTipoConCod1 = "" ;
      AV50TFSubTipoConCod1_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFSubTipoConCod2 = "" ;
      AV53TFSubTipoConCod2_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55TFConTipoLiqAux = "" ;
      AV56TFConTipoLiqAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58TFConClasifAux = "" ;
      AV59TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV67TFConRangoCant = "" ;
      AV68TFConRangoCant_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70TFConCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72TFConCondCodigo = "" ;
      AV73TFConCondCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76TFConAdelDescu_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV92TFConCodAfip = "" ;
      AV93TFConCodAfip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV129TFConceptoConveCodigo = "" ;
      AV130TFConceptoConveCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV138TFConBaseLicProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV140TFConBaseFerProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV142TFConBaseHorExtProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV144TFConBasePres_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV146TFConBaseAnt_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV148TFConBaseOSDif_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV153TFConPadre = "" ;
      AV154TFConPadre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV80DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV168ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV84GridAppliedFilters = "" ;
      AV26TFConCodigo_SelsJson = "" ;
      AV29TFConDescrip_SelsJson = "" ;
      AV38TFConFormula_SelsJson = "" ;
      AV41TFConObservacion_SelsJson = "" ;
      AV46TFTipoConCod_SelsJson = "" ;
      AV48TFSubTipoConCod1_SelsJson = "" ;
      AV51TFSubTipoConCod2_SelsJson = "" ;
      AV54TFConTipoLiqAux_SelsJson = "" ;
      AV57TFConClasifAux_SelsJson = "" ;
      AV66TFConRangoCant_SelsJson = "" ;
      AV69TFConCondicion_SelsJson = "" ;
      AV71TFConCondCodigo_SelsJson = "" ;
      AV75TFConAdelDescu_SelsJson = "" ;
      AV91TFConCodAfip_SelsJson = "" ;
      AV128TFConceptoConveCodigo_SelsJson = "" ;
      AV137TFConBaseLicProm_SelsJson = "" ;
      AV139TFConBaseFerProm_SelsJson = "" ;
      AV141TFConBaseHorExtProm_SelsJson = "" ;
      AV143TFConBasePres_SelsJson = "" ;
      AV145TFConBaseAnt_SelsJson = "" ;
      AV147TFConBaseOSDif_SelsJson = "" ;
      AV152TFConPadre_SelsJson = "" ;
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
      TempTags = "" ;
      bttBtnmotivos_Jsonclick = "" ;
      bttBtntiposliq_Jsonclick = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      A148ConFormula = "" ;
      A153ConObservacion = "" ;
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      A503ConTipoLiqAux = "" ;
      A970ConClasifAux = "" ;
      A1018ConRangoCant = "" ;
      A953ConCondicion = "" ;
      A954ConCondCodigo = "" ;
      AV158Display = "" ;
      AV157VerSVG = "" ;
      A1648ConCodAfip = "" ;
      A1645ConceptoConveCodigo = "" ;
      A921ConPadre = "" ;
      AV187Conceptos_exportwwds_4_tfconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV189Conceptos_exportwwds_6_tfcondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV195Conceptos_exportwwds_12_tfconformula_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV197Conceptos_exportwwds_14_tfconobservacion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV200Conceptos_exportwwds_17_tftipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV208Conceptos_exportwwds_25_tfconclasifaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV213Conceptos_exportwwds_30_tfconrangocant_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV214Conceptos_exportwwds_31_tfconcondicion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV216Conceptos_exportwwds_33_tfconcondcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV218Conceptos_exportwwds_35_tfconadeldescu_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV223Conceptos_exportwwds_40_tfconcodafip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV258Conceptos_exportwwds_75_tfconbaselicprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV259Conceptos_exportwwds_76_tfconbaseferprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV261Conceptos_exportwwds_78_tfconbasepres_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV262Conceptos_exportwwds_79_tfconbaseant_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV263Conceptos_exportwwds_80_tfconbaseosdif_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV268Conceptos_exportwwds_85_tfconpadre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV186Conceptos_exportwwds_3_tfconcodigo = "" ;
      lV188Conceptos_exportwwds_5_tfcondescrip = "" ;
      lV194Conceptos_exportwwds_11_tfconformula = "" ;
      lV196Conceptos_exportwwds_13_tfconobservacion = "" ;
      lV201Conceptos_exportwwds_18_tfsubtipoconcod1 = "" ;
      lV203Conceptos_exportwwds_20_tfsubtipoconcod2 = "" ;
      lV205Conceptos_exportwwds_22_tfcontipoliqaux = "" ;
      lV207Conceptos_exportwwds_24_tfconclasifaux = "" ;
      lV212Conceptos_exportwwds_29_tfconrangocant = "" ;
      lV215Conceptos_exportwwds_32_tfconcondcodigo = "" ;
      lV222Conceptos_exportwwds_39_tfconcodafip = "" ;
      lV256Conceptos_exportwwds_73_tfconceptoconvecodigo = "" ;
      lV267Conceptos_exportwwds_84_tfconpadre = "" ;
      AV186Conceptos_exportwwds_3_tfconcodigo = "" ;
      AV188Conceptos_exportwwds_5_tfcondescrip = "" ;
      AV194Conceptos_exportwwds_11_tfconformula = "" ;
      AV196Conceptos_exportwwds_13_tfconobservacion = "" ;
      AV201Conceptos_exportwwds_18_tfsubtipoconcod1 = "" ;
      AV203Conceptos_exportwwds_20_tfsubtipoconcod2 = "" ;
      AV205Conceptos_exportwwds_22_tfcontipoliqaux = "" ;
      AV207Conceptos_exportwwds_24_tfconclasifaux = "" ;
      AV212Conceptos_exportwwds_29_tfconrangocant = "" ;
      AV215Conceptos_exportwwds_32_tfconcondcodigo = "" ;
      AV222Conceptos_exportwwds_39_tfconcodafip = "" ;
      AV256Conceptos_exportwwds_73_tfconceptoconvecodigo = "" ;
      AV267Conceptos_exportwwds_84_tfconpadre = "" ;
      H00IB2_A1826ConPueNov = new boolean[] {false} ;
      H00IB2_A921ConPadre = new String[] {""} ;
      H00IB2_n921ConPadre = new boolean[] {false} ;
      H00IB2_A1822CliPadre = new int[1] ;
      H00IB2_n1822CliPadre = new boolean[] {false} ;
      H00IB2_A1821ConErrorSiCero = new boolean[] {false} ;
      H00IB2_A1827ConBaseOSDif = new byte[1] ;
      H00IB2_A1801ConBaseAnt = new byte[1] ;
      H00IB2_A1800ConBasePres = new byte[1] ;
      H00IB2_A1799ConBaseHorExtProm = new byte[1] ;
      H00IB2_A1622ConBaseHorExt = new byte[1] ;
      H00IB2_A1798ConBaseFerProm = new byte[1] ;
      H00IB2_A1621ConBaseFer = new byte[1] ;
      H00IB2_A1797ConBaseLicProm = new byte[1] ;
      H00IB2_A1620ConBaseLic = new byte[1] ;
      H00IB2_A1645ConceptoConveCodigo = new String[] {""} ;
      H00IB2_n1645ConceptoConveCodigo = new boolean[] {false} ;
      H00IB2_A1644ConceptoPais = new short[1] ;
      H00IB2_n1644ConceptoPais = new boolean[] {false} ;
      H00IB2_A1539ConSacDeven = new byte[1] ;
      H00IB2_A1486ConRegEspApo = new byte[1] ;
      H00IB2_A1485ConRegDifApo = new byte[1] ;
      H00IB2_A1484ConLeyRieTrabCont = new byte[1] ;
      H00IB2_A1483ConFonNacEmpCont = new byte[1] ;
      H00IB2_A1482ConAsigFamCont = new byte[1] ;
      H00IB2_A1481ConRenateaCont = new byte[1] ;
      H00IB2_A1480ConRenateaApo = new byte[1] ;
      H00IB2_A1479ConFonSolRedCont = new byte[1] ;
      H00IB2_A1478ConFonSolRedApo = new byte[1] ;
      H00IB2_A1477ConObraSocCont = new byte[1] ;
      H00IB2_A1476ConObraSocApo = new byte[1] ;
      H00IB2_A1475ConINSSJyPCont = new byte[1] ;
      H00IB2_A1474ConINSSJyPApo = new byte[1] ;
      H00IB2_A1473ConSIPACont = new byte[1] ;
      H00IB2_A1472ConSIPAApo = new byte[1] ;
      H00IB2_A1648ConCodAfip = new String[] {""} ;
      H00IB2_A1194ConSegunPla = new boolean[] {false} ;
      H00IB2_A1112AplIIGG = new short[1] ;
      H00IB2_n1112AplIIGG = new boolean[] {false} ;
      H00IB2_A1077ConAdelDescu = new byte[1] ;
      H00IB2_n1077ConAdelDescu = new boolean[] {false} ;
      H00IB2_A1068ConMostrarPos = new boolean[] {false} ;
      H00IB2_A954ConCondCodigo = new String[] {""} ;
      H00IB2_A953ConCondicion = new String[] {""} ;
      H00IB2_n953ConCondicion = new boolean[] {false} ;
      H00IB2_A1018ConRangoCant = new String[] {""} ;
      H00IB2_A762ConRecalcular = new boolean[] {false} ;
      H00IB2_A510ConOrdEjec = new long[1] ;
      H00IB2_A970ConClasifAux = new String[] {""} ;
      H00IB2_n970ConClasifAux = new boolean[] {false} ;
      H00IB2_A503ConTipoLiqAux = new String[] {""} ;
      H00IB2_n503ConTipoLiqAux = new boolean[] {false} ;
      H00IB2_A39SubTipoConCod2 = new String[] {""} ;
      H00IB2_n39SubTipoConCod2 = new boolean[] {false} ;
      H00IB2_A38SubTipoConCod1 = new String[] {""} ;
      H00IB2_n38SubTipoConCod1 = new boolean[] {false} ;
      H00IB2_A37TipoConCod = new String[] {""} ;
      H00IB2_A146ConForEditable = new boolean[] {false} ;
      H00IB2_n146ConForEditable = new boolean[] {false} ;
      H00IB2_A159ConVariable = new boolean[] {false} ;
      H00IB2_A153ConObservacion = new String[] {""} ;
      H00IB2_A148ConFormula = new String[] {""} ;
      H00IB2_n148ConFormula = new boolean[] {false} ;
      H00IB2_A1488ConLiqBasica = new byte[1] ;
      H00IB2_A162ConVigencia = new byte[1] ;
      H00IB2_A40ConOrden = new int[1] ;
      H00IB2_A41ConDescrip = new String[] {""} ;
      H00IB2_A26ConCodigo = new String[] {""} ;
      H00IB2_A3CliCod = new int[1] ;
      H00IB3_AGRID_nRecordCount = new long[1] ;
      AV167WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV162MenuBienveImgURL = "" ;
      AV164MenuBienveTitulo = "" ;
      AV165MenuBienveTexto = "" ;
      AV182Welcomemessage_foto_GXI = "" ;
      AV179observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext11 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV19ColumnsSelectorXML = "" ;
      AV175MenuOpcTitulo = "" ;
      GXv_int12 = new short[1] ;
      AV178filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV169ManageFiltersXml = "" ;
      AV17ExcelFilename = "" ;
      AV18ErrorMessage = "" ;
      AV20UserCustomValue = "" ;
      AV22ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char10 = "" ;
      GXt_char9 = "" ;
      GXv_char6 = new String[1] ;
      GXv_char5 = new String[1] ;
      GXt_char41 = "" ;
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
      GXt_char19 = "" ;
      GXv_char20 = new String[1] ;
      GXt_char18 = "" ;
      GXv_char7 = new String[1] ;
      GXv_SdtWWPGridState43 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV163textoNoMostrara = "" ;
      GXv_char42 = new String[1] ;
      GXv_boolean8 = new boolean[1] ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      sImgUrl = "" ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptos_exportww__default(),
         new Object[] {
             new Object[] {
            H00IB2_A1826ConPueNov, H00IB2_A921ConPadre, H00IB2_n921ConPadre, H00IB2_A1822CliPadre, H00IB2_n1822CliPadre, H00IB2_A1821ConErrorSiCero, H00IB2_A1827ConBaseOSDif, H00IB2_A1801ConBaseAnt, H00IB2_A1800ConBasePres, H00IB2_A1799ConBaseHorExtProm,
            H00IB2_A1622ConBaseHorExt, H00IB2_A1798ConBaseFerProm, H00IB2_A1621ConBaseFer, H00IB2_A1797ConBaseLicProm, H00IB2_A1620ConBaseLic, H00IB2_A1645ConceptoConveCodigo, H00IB2_n1645ConceptoConveCodigo, H00IB2_A1644ConceptoPais, H00IB2_n1644ConceptoPais, H00IB2_A1539ConSacDeven,
            H00IB2_A1486ConRegEspApo, H00IB2_A1485ConRegDifApo, H00IB2_A1484ConLeyRieTrabCont, H00IB2_A1483ConFonNacEmpCont, H00IB2_A1482ConAsigFamCont, H00IB2_A1481ConRenateaCont, H00IB2_A1480ConRenateaApo, H00IB2_A1479ConFonSolRedCont, H00IB2_A1478ConFonSolRedApo, H00IB2_A1477ConObraSocCont,
            H00IB2_A1476ConObraSocApo, H00IB2_A1475ConINSSJyPCont, H00IB2_A1474ConINSSJyPApo, H00IB2_A1473ConSIPACont, H00IB2_A1472ConSIPAApo, H00IB2_A1648ConCodAfip, H00IB2_A1194ConSegunPla, H00IB2_A1112AplIIGG, H00IB2_n1112AplIIGG, H00IB2_A1077ConAdelDescu,
            H00IB2_n1077ConAdelDescu, H00IB2_A1068ConMostrarPos, H00IB2_A954ConCondCodigo, H00IB2_A953ConCondicion, H00IB2_n953ConCondicion, H00IB2_A1018ConRangoCant, H00IB2_A762ConRecalcular, H00IB2_A510ConOrdEjec, H00IB2_A970ConClasifAux, H00IB2_n970ConClasifAux,
            H00IB2_A503ConTipoLiqAux, H00IB2_n503ConTipoLiqAux, H00IB2_A39SubTipoConCod2, H00IB2_n39SubTipoConCod2, H00IB2_A38SubTipoConCod1, H00IB2_n38SubTipoConCod1, H00IB2_A37TipoConCod, H00IB2_A146ConForEditable, H00IB2_n146ConForEditable, H00IB2_A159ConVariable,
            H00IB2_A153ConObservacion, H00IB2_A148ConFormula, H00IB2_n148ConFormula, H00IB2_A1488ConLiqBasica, H00IB2_A162ConVigencia, H00IB2_A40ConOrden, H00IB2_A41ConDescrip, H00IB2_A26ConCodigo, H00IB2_A3CliCod
            }
            , new Object[] {
            H00IB3_AGRID_nRecordCount
            }
         }
      );
      AV183Pgmname = "Conceptos_exportWW" ;
      /* GeneXus formulas. */
      AV183Pgmname = "Conceptos_exportWW" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV170ManageFiltersExecutionStep ;
   private byte AV36TFConLiqBasica ;
   private byte AV37TFConLiqBasica_To ;
   private byte AV44TFConVariable_Sel ;
   private byte AV45TFConForEditable_Sel ;
   private byte AV65TFConRecalcular_Sel ;
   private byte AV74TFConMostrarPos_Sel ;
   private byte AV79TFConSegunPla_Sel ;
   private byte AV94TFConSIPAApo ;
   private byte AV95TFConSIPAApo_To ;
   private byte AV96TFConSIPACont ;
   private byte AV97TFConSIPACont_To ;
   private byte AV98TFConINSSJyPApo ;
   private byte AV99TFConINSSJyPApo_To ;
   private byte AV100TFConINSSJyPCont ;
   private byte AV101TFConINSSJyPCont_To ;
   private byte AV102TFConObraSocApo ;
   private byte AV103TFConObraSocApo_To ;
   private byte AV104TFConObraSocCont ;
   private byte AV105TFConObraSocCont_To ;
   private byte AV106TFConFonSolRedApo ;
   private byte AV107TFConFonSolRedApo_To ;
   private byte AV108TFConFonSolRedCont ;
   private byte AV109TFConFonSolRedCont_To ;
   private byte AV110TFConRenateaApo ;
   private byte AV111TFConRenateaApo_To ;
   private byte AV112TFConRenateaCont ;
   private byte AV113TFConRenateaCont_To ;
   private byte AV114TFConAsigFamCont ;
   private byte AV115TFConAsigFamCont_To ;
   private byte AV116TFConFonNacEmpCont ;
   private byte AV117TFConFonNacEmpCont_To ;
   private byte AV118TFConLeyRieTrabCont ;
   private byte AV119TFConLeyRieTrabCont_To ;
   private byte AV120TFConRegDifApo ;
   private byte AV121TFConRegDifApo_To ;
   private byte AV122TFConRegEspApo ;
   private byte AV123TFConRegEspApo_To ;
   private byte AV149TFConErrorSiCero_Sel ;
   private byte AV155TFConPueNov_Sel ;
   private byte gxajaxcallmode ;
   private byte A162ConVigencia ;
   private byte A1488ConLiqBasica ;
   private byte A1077ConAdelDescu ;
   private byte A1472ConSIPAApo ;
   private byte A1473ConSIPACont ;
   private byte A1474ConINSSJyPApo ;
   private byte A1475ConINSSJyPCont ;
   private byte A1476ConObraSocApo ;
   private byte A1477ConObraSocCont ;
   private byte A1478ConFonSolRedApo ;
   private byte A1479ConFonSolRedCont ;
   private byte A1480ConRenateaApo ;
   private byte A1481ConRenateaCont ;
   private byte A1482ConAsigFamCont ;
   private byte A1483ConFonNacEmpCont ;
   private byte A1484ConLeyRieTrabCont ;
   private byte A1485ConRegDifApo ;
   private byte A1486ConRegEspApo ;
   private byte A1539ConSacDeven ;
   private byte A1620ConBaseLic ;
   private byte A1797ConBaseLicProm ;
   private byte A1621ConBaseFer ;
   private byte A1798ConBaseFerProm ;
   private byte A1622ConBaseHorExt ;
   private byte A1799ConBaseHorExtProm ;
   private byte A1800ConBasePres ;
   private byte A1801ConBaseAnt ;
   private byte A1827ConBaseOSDif ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV192Conceptos_exportwwds_9_tfconliqbasica ;
   private byte AV193Conceptos_exportwwds_10_tfconliqbasica_to ;
   private byte AV198Conceptos_exportwwds_15_tfconvariable_sel ;
   private byte AV199Conceptos_exportwwds_16_tfconforeditable_sel ;
   private byte AV211Conceptos_exportwwds_28_tfconrecalcular_sel ;
   private byte AV217Conceptos_exportwwds_34_tfconmostrarpos_sel ;
   private byte AV221Conceptos_exportwwds_38_tfconsegunpla_sel ;
   private byte AV224Conceptos_exportwwds_41_tfconsipaapo ;
   private byte AV225Conceptos_exportwwds_42_tfconsipaapo_to ;
   private byte AV226Conceptos_exportwwds_43_tfconsipacont ;
   private byte AV227Conceptos_exportwwds_44_tfconsipacont_to ;
   private byte AV228Conceptos_exportwwds_45_tfconinssjypapo ;
   private byte AV229Conceptos_exportwwds_46_tfconinssjypapo_to ;
   private byte AV230Conceptos_exportwwds_47_tfconinssjypcont ;
   private byte AV231Conceptos_exportwwds_48_tfconinssjypcont_to ;
   private byte AV232Conceptos_exportwwds_49_tfconobrasocapo ;
   private byte AV233Conceptos_exportwwds_50_tfconobrasocapo_to ;
   private byte AV234Conceptos_exportwwds_51_tfconobrasoccont ;
   private byte AV235Conceptos_exportwwds_52_tfconobrasoccont_to ;
   private byte AV236Conceptos_exportwwds_53_tfconfonsolredapo ;
   private byte AV237Conceptos_exportwwds_54_tfconfonsolredapo_to ;
   private byte AV238Conceptos_exportwwds_55_tfconfonsolredcont ;
   private byte AV239Conceptos_exportwwds_56_tfconfonsolredcont_to ;
   private byte AV240Conceptos_exportwwds_57_tfconrenateaapo ;
   private byte AV241Conceptos_exportwwds_58_tfconrenateaapo_to ;
   private byte AV242Conceptos_exportwwds_59_tfconrenateacont ;
   private byte AV243Conceptos_exportwwds_60_tfconrenateacont_to ;
   private byte AV244Conceptos_exportwwds_61_tfconasigfamcont ;
   private byte AV245Conceptos_exportwwds_62_tfconasigfamcont_to ;
   private byte AV246Conceptos_exportwwds_63_tfconfonnacempcont ;
   private byte AV247Conceptos_exportwwds_64_tfconfonnacempcont_to ;
   private byte AV248Conceptos_exportwwds_65_tfconleyrietrabcont ;
   private byte AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to ;
   private byte AV250Conceptos_exportwwds_67_tfconregdifapo ;
   private byte AV251Conceptos_exportwwds_68_tfconregdifapo_to ;
   private byte AV252Conceptos_exportwwds_69_tfconregespapo ;
   private byte AV253Conceptos_exportwwds_70_tfconregespapo_to ;
   private byte AV264Conceptos_exportwwds_81_tfconerrorsicero_sel ;
   private byte AV269Conceptos_exportwwds_86_tfconpuenov_sel ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short AV77TFAplIIGG ;
   private short AV78TFAplIIGG_To ;
   private short AV126TFConceptoPais ;
   private short AV127TFConceptoPais_To ;
   private short AV14OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A1112AplIIGG ;
   private short A1644ConceptoPais ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV219Conceptos_exportwwds_36_tfapliigg ;
   private short AV220Conceptos_exportwwds_37_tfapliigg_to ;
   private short AV254Conceptos_exportwwds_71_tfconceptopais ;
   private short AV255Conceptos_exportwwds_72_tfconceptopais_to ;
   private short GXv_int12[] ;
   private short edtavVersvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_110 ;
   private int nGXsfl_110_idx=1 ;
   private int AV24TFCliCod ;
   private int AV25TFCliCod_To ;
   private int AV32TFConOrden ;
   private int AV33TFConOrden_To ;
   private int AV150TFCliPadre ;
   private int AV151TFCliPadre_To ;
   private int AV87CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int A40ConOrden ;
   private int A1822CliPadre ;
   private int subGrid_Islastpage ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV187Conceptos_exportwwds_4_tfconcodigo_sels_size ;
   private int AV189Conceptos_exportwwds_6_tfcondescrip_sels_size ;
   private int AV195Conceptos_exportwwds_12_tfconformula_sels_size ;
   private int AV197Conceptos_exportwwds_14_tfconobservacion_sels_size ;
   private int AV200Conceptos_exportwwds_17_tftipoconcod_sels_size ;
   private int AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels_size ;
   private int AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels_size ;
   private int AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels_size ;
   private int AV208Conceptos_exportwwds_25_tfconclasifaux_sels_size ;
   private int AV213Conceptos_exportwwds_30_tfconrangocant_sels_size ;
   private int AV214Conceptos_exportwwds_31_tfconcondicion_sels_size ;
   private int AV216Conceptos_exportwwds_33_tfconcondcodigo_sels_size ;
   private int AV218Conceptos_exportwwds_35_tfconadeldescu_sels_size ;
   private int AV223Conceptos_exportwwds_40_tfconcodafip_sels_size ;
   private int AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels_size ;
   private int AV258Conceptos_exportwwds_75_tfconbaselicprom_sels_size ;
   private int AV259Conceptos_exportwwds_76_tfconbaseferprom_sels_size ;
   private int AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels_size ;
   private int AV261Conceptos_exportwwds_78_tfconbasepres_sels_size ;
   private int AV262Conceptos_exportwwds_79_tfconbaseant_sels_size ;
   private int AV263Conceptos_exportwwds_80_tfconbaseosdif_sels_size ;
   private int AV268Conceptos_exportwwds_85_tfconpadre_sels_size ;
   private int AV184Conceptos_exportwwds_1_tfclicod ;
   private int AV185Conceptos_exportwwds_2_tfclicod_to ;
   private int AV190Conceptos_exportwwds_7_tfconorden ;
   private int AV191Conceptos_exportwwds_8_tfconorden_to ;
   private int AV265Conceptos_exportwwds_82_tfclipadre ;
   private int AV266Conceptos_exportwwds_83_tfclipadre_to ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtCliCod_Visible ;
   private int edtConCodigo_Visible ;
   private int edtConDescrip_Visible ;
   private int edtConOrden_Visible ;
   private int edtConLiqBasica_Visible ;
   private int edtConFormula_Visible ;
   private int edtConObservacion_Visible ;
   private int edtSubTipoConCod1_Visible ;
   private int edtSubTipoConCod2_Visible ;
   private int edtConTipoLiqAux_Visible ;
   private int edtConClasifAux_Visible ;
   private int edtConOrdEjec_Visible ;
   private int edtConRangoCant_Visible ;
   private int edtConCondCodigo_Visible ;
   private int edtAplIIGG_Visible ;
   private int edtavVersvg_Visible ;
   private int edtConCodAfip_Visible ;
   private int edtConSIPAApo_Visible ;
   private int edtConSIPACont_Visible ;
   private int edtConINSSJyPApo_Visible ;
   private int edtConINSSJyPCont_Visible ;
   private int edtConObraSocApo_Visible ;
   private int edtConObraSocCont_Visible ;
   private int edtConFonSolRedApo_Visible ;
   private int edtConFonSolRedCont_Visible ;
   private int edtConRenateaApo_Visible ;
   private int edtConRenateaCont_Visible ;
   private int edtConAsigFamCont_Visible ;
   private int edtConFonNacEmpCont_Visible ;
   private int edtConLeyRieTrabCont_Visible ;
   private int edtConRegDifApo_Visible ;
   private int edtConRegEspApo_Visible ;
   private int edtConceptoPais_Visible ;
   private int edtConceptoConveCodigo_Visible ;
   private int edtCliPadre_Visible ;
   private int edtConPadre_Visible ;
   private int lblCouttext_Visible ;
   private int AV177filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV81PageToGo ;
   private int edtavDisplay_Visible ;
   private int bttBtninsert_Visible ;
   private int AV270GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV60TFConOrdEjec ;
   private long AV61TFConOrdEjec_To ;
   private long AV82GridCurrentPage ;
   private long AV83GridPageCount ;
   private long A510ConOrdEjec ;
   private long GRID_nCurrentRecord ;
   private long AV209Conceptos_exportwwds_26_tfconordejec ;
   private long AV210Conceptos_exportwwds_27_tfconordejec_to ;
   private long GRID_nRecordCount ;
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
   private String AV183Pgmname ;
   private String AV27TFConCodigo ;
   private String AV49TFSubTipoConCod1 ;
   private String AV52TFSubTipoConCod2 ;
   private String AV72TFConCondCodigo ;
   private String AV92TFConCodAfip ;
   private String AV129TFConceptoConveCodigo ;
   private String AV153TFConPadre ;
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
   private String TempTags ;
   private String bttBtnmotivos_Internalname ;
   private String bttBtnmotivos_Jsonclick ;
   private String bttBtntiposliq_Internalname ;
   private String bttBtntiposliq_Jsonclick ;
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
   private String A26ConCodigo ;
   private String edtConCodigo_Internalname ;
   private String edtConDescrip_Internalname ;
   private String edtConOrden_Internalname ;
   private String edtConLiqBasica_Internalname ;
   private String edtConFormula_Internalname ;
   private String edtConObservacion_Internalname ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String edtSubTipoConCod1_Internalname ;
   private String A39SubTipoConCod2 ;
   private String edtSubTipoConCod2_Internalname ;
   private String edtConTipoLiqAux_Internalname ;
   private String edtConClasifAux_Internalname ;
   private String edtConOrdEjec_Internalname ;
   private String edtConRangoCant_Internalname ;
   private String A953ConCondicion ;
   private String A954ConCondCodigo ;
   private String edtConCondCodigo_Internalname ;
   private String edtAplIIGG_Internalname ;
   private String AV158Display ;
   private String edtavDisplay_Internalname ;
   private String AV157VerSVG ;
   private String edtavVersvg_Internalname ;
   private String A1648ConCodAfip ;
   private String edtConCodAfip_Internalname ;
   private String edtConSIPAApo_Internalname ;
   private String edtConSIPACont_Internalname ;
   private String edtConINSSJyPApo_Internalname ;
   private String edtConINSSJyPCont_Internalname ;
   private String edtConObraSocApo_Internalname ;
   private String edtConObraSocCont_Internalname ;
   private String edtConFonSolRedApo_Internalname ;
   private String edtConFonSolRedCont_Internalname ;
   private String edtConRenateaApo_Internalname ;
   private String edtConRenateaCont_Internalname ;
   private String edtConAsigFamCont_Internalname ;
   private String edtConFonNacEmpCont_Internalname ;
   private String edtConLeyRieTrabCont_Internalname ;
   private String edtConRegDifApo_Internalname ;
   private String edtConRegEspApo_Internalname ;
   private String edtConceptoPais_Internalname ;
   private String A1645ConceptoConveCodigo ;
   private String edtConceptoConveCodigo_Internalname ;
   private String edtCliPadre_Internalname ;
   private String A921ConPadre ;
   private String edtConPadre_Internalname ;
   private String scmdbuf ;
   private String lV186Conceptos_exportwwds_3_tfconcodigo ;
   private String lV201Conceptos_exportwwds_18_tfsubtipoconcod1 ;
   private String lV203Conceptos_exportwwds_20_tfsubtipoconcod2 ;
   private String lV215Conceptos_exportwwds_32_tfconcondcodigo ;
   private String lV222Conceptos_exportwwds_39_tfconcodafip ;
   private String lV256Conceptos_exportwwds_73_tfconceptoconvecodigo ;
   private String lV267Conceptos_exportwwds_84_tfconpadre ;
   private String AV186Conceptos_exportwwds_3_tfconcodigo ;
   private String AV201Conceptos_exportwwds_18_tfsubtipoconcod1 ;
   private String AV203Conceptos_exportwwds_20_tfsubtipoconcod2 ;
   private String AV215Conceptos_exportwwds_32_tfconcondcodigo ;
   private String AV222Conceptos_exportwwds_39_tfconcodafip ;
   private String AV256Conceptos_exportwwds_73_tfconceptoconvecodigo ;
   private String AV267Conceptos_exportwwds_84_tfconpadre ;
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
   private String AV179observerPalabra ;
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
   private String edtavDisplay_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String bttBtninsert_Internalname ;
   private String GXt_char10 ;
   private String GXt_char9 ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String GXt_char41 ;
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
   private String GXt_char19 ;
   private String GXv_char20[] ;
   private String GXt_char18 ;
   private String GXv_char7[] ;
   private String GXv_char42[] ;
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
   private String edtConCodigo_Jsonclick ;
   private String edtConDescrip_Jsonclick ;
   private String edtConOrden_Jsonclick ;
   private String GXCCtl ;
   private String edtConLiqBasica_Jsonclick ;
   private String edtConFormula_Jsonclick ;
   private String edtConObservacion_Jsonclick ;
   private String edtSubTipoConCod1_Jsonclick ;
   private String edtSubTipoConCod2_Jsonclick ;
   private String edtConTipoLiqAux_Jsonclick ;
   private String edtConClasifAux_Jsonclick ;
   private String edtConOrdEjec_Jsonclick ;
   private String edtConRangoCant_Jsonclick ;
   private String edtConCondCodigo_Jsonclick ;
   private String edtAplIIGG_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtConCodAfip_Jsonclick ;
   private String edtConSIPAApo_Jsonclick ;
   private String edtConSIPACont_Jsonclick ;
   private String edtConINSSJyPApo_Jsonclick ;
   private String edtConINSSJyPCont_Jsonclick ;
   private String edtConObraSocApo_Jsonclick ;
   private String edtConObraSocCont_Jsonclick ;
   private String edtConFonSolRedApo_Jsonclick ;
   private String edtConFonSolRedCont_Jsonclick ;
   private String edtConRenateaApo_Jsonclick ;
   private String edtConRenateaCont_Jsonclick ;
   private String edtConAsigFamCont_Jsonclick ;
   private String edtConFonNacEmpCont_Jsonclick ;
   private String edtConLeyRieTrabCont_Jsonclick ;
   private String edtConRegDifApo_Jsonclick ;
   private String edtConRegEspApo_Jsonclick ;
   private String edtConceptoPais_Jsonclick ;
   private String edtConceptoConveCodigo_Jsonclick ;
   private String edtCliPadre_Jsonclick ;
   private String edtConPadre_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV15OrderedDsc ;
   private boolean AV161WelcomeMessage_NoMostrarMas ;
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
   private boolean n148ConFormula ;
   private boolean A159ConVariable ;
   private boolean A146ConForEditable ;
   private boolean n146ConForEditable ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean n503ConTipoLiqAux ;
   private boolean n970ConClasifAux ;
   private boolean A762ConRecalcular ;
   private boolean n953ConCondicion ;
   private boolean A1068ConMostrarPos ;
   private boolean n1077ConAdelDescu ;
   private boolean n1112AplIIGG ;
   private boolean A1194ConSegunPla ;
   private boolean n1644ConceptoPais ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean A1821ConErrorSiCero ;
   private boolean n1822CliPadre ;
   private boolean n921ConPadre ;
   private boolean A1826ConPueNov ;
   private boolean bGXsfl_110_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV166MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean AV86TempBoolean ;
   private boolean GXt_boolean15 ;
   private boolean GXv_boolean8[] ;
   private boolean AV167WelcomeMessage_Foto_IsBlob ;
   private String AV26TFConCodigo_SelsJson ;
   private String AV29TFConDescrip_SelsJson ;
   private String AV38TFConFormula_SelsJson ;
   private String AV41TFConObservacion_SelsJson ;
   private String AV46TFTipoConCod_SelsJson ;
   private String AV48TFSubTipoConCod1_SelsJson ;
   private String AV51TFSubTipoConCod2_SelsJson ;
   private String AV54TFConTipoLiqAux_SelsJson ;
   private String AV57TFConClasifAux_SelsJson ;
   private String AV66TFConRangoCant_SelsJson ;
   private String AV69TFConCondicion_SelsJson ;
   private String AV71TFConCondCodigo_SelsJson ;
   private String AV75TFConAdelDescu_SelsJson ;
   private String AV91TFConCodAfip_SelsJson ;
   private String AV128TFConceptoConveCodigo_SelsJson ;
   private String AV137TFConBaseLicProm_SelsJson ;
   private String AV139TFConBaseFerProm_SelsJson ;
   private String AV141TFConBaseHorExtProm_SelsJson ;
   private String AV143TFConBasePres_SelsJson ;
   private String AV145TFConBaseAnt_SelsJson ;
   private String AV147TFConBaseOSDif_SelsJson ;
   private String AV152TFConPadre_SelsJson ;
   private String A148ConFormula ;
   private String A153ConObservacion ;
   private String AV165MenuBienveTexto ;
   private String AV19ColumnsSelectorXML ;
   private String AV169ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV163textoNoMostrara ;
   private String wcpOAV159MenuOpcCod ;
   private String AV159MenuOpcCod ;
   private String AV30TFConDescrip ;
   private String AV39TFConFormula ;
   private String AV42TFConObservacion ;
   private String AV55TFConTipoLiqAux ;
   private String AV58TFConClasifAux ;
   private String AV67TFConRangoCant ;
   private String AV84GridAppliedFilters ;
   private String A41ConDescrip ;
   private String A503ConTipoLiqAux ;
   private String A970ConClasifAux ;
   private String A1018ConRangoCant ;
   private String lV188Conceptos_exportwwds_5_tfcondescrip ;
   private String lV194Conceptos_exportwwds_11_tfconformula ;
   private String lV196Conceptos_exportwwds_13_tfconobservacion ;
   private String lV205Conceptos_exportwwds_22_tfcontipoliqaux ;
   private String lV207Conceptos_exportwwds_24_tfconclasifaux ;
   private String lV212Conceptos_exportwwds_29_tfconrangocant ;
   private String AV188Conceptos_exportwwds_5_tfcondescrip ;
   private String AV194Conceptos_exportwwds_11_tfconformula ;
   private String AV196Conceptos_exportwwds_13_tfconobservacion ;
   private String AV205Conceptos_exportwwds_22_tfcontipoliqaux ;
   private String AV207Conceptos_exportwwds_24_tfconclasifaux ;
   private String AV212Conceptos_exportwwds_29_tfconrangocant ;
   private String AV162MenuBienveImgURL ;
   private String AV164MenuBienveTitulo ;
   private String AV182Welcomemessage_foto_GXI ;
   private String AV175MenuOpcTitulo ;
   private String AV178filtrosTexto ;
   private String AV17ExcelFilename ;
   private String AV18ErrorMessage ;
   private String AV167WelcomeMessage_Foto ;
   private GXSimpleCollection<Byte> AV218Conceptos_exportwwds_35_tfconadeldescu_sels ;
   private GXSimpleCollection<Byte> AV258Conceptos_exportwwds_75_tfconbaselicprom_sels ;
   private GXSimpleCollection<Byte> AV259Conceptos_exportwwds_76_tfconbaseferprom_sels ;
   private GXSimpleCollection<Byte> AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels ;
   private GXSimpleCollection<Byte> AV261Conceptos_exportwwds_78_tfconbasepres_sels ;
   private GXSimpleCollection<Byte> AV262Conceptos_exportwwds_79_tfconbaseant_sels ;
   private GXSimpleCollection<Byte> AV263Conceptos_exportwwds_80_tfconbaseosdif_sels ;
   private GXSimpleCollection<Byte> AV76TFConAdelDescu_Sels ;
   private GXSimpleCollection<Byte> AV138TFConBaseLicProm_Sels ;
   private GXSimpleCollection<Byte> AV140TFConBaseFerProm_Sels ;
   private GXSimpleCollection<Byte> AV142TFConBaseHorExtProm_Sels ;
   private GXSimpleCollection<Byte> AV144TFConBasePres_Sels ;
   private GXSimpleCollection<Byte> AV146TFConBaseAnt_Sels ;
   private GXSimpleCollection<Byte> AV148TFConBaseOSDif_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV9HTTPRequest ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV187Conceptos_exportwwds_4_tfconcodigo_sels ;
   private GXSimpleCollection<String> AV200Conceptos_exportwwds_17_tftipoconcod_sels ;
   private GXSimpleCollection<String> AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels ;
   private GXSimpleCollection<String> AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels ;
   private GXSimpleCollection<String> AV214Conceptos_exportwwds_31_tfconcondicion_sels ;
   private GXSimpleCollection<String> AV216Conceptos_exportwwds_33_tfconcondcodigo_sels ;
   private GXSimpleCollection<String> AV223Conceptos_exportwwds_40_tfconcodafip_sels ;
   private GXSimpleCollection<String> AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels ;
   private GXSimpleCollection<String> AV268Conceptos_exportwwds_85_tfconpadre_sels ;
   private GXSimpleCollection<String> AV189Conceptos_exportwwds_6_tfcondescrip_sels ;
   private GXSimpleCollection<String> AV195Conceptos_exportwwds_12_tfconformula_sels ;
   private GXSimpleCollection<String> AV197Conceptos_exportwwds_14_tfconobservacion_sels ;
   private GXSimpleCollection<String> AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels ;
   private GXSimpleCollection<String> AV208Conceptos_exportwwds_25_tfconclasifaux_sels ;
   private GXSimpleCollection<String> AV213Conceptos_exportwwds_30_tfconrangocant_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbConVigencia ;
   private ICheckbox chkConVariable ;
   private ICheckbox chkConForEditable ;
   private HTMLChoice cmbTipoConCod ;
   private ICheckbox chkConRecalcular ;
   private HTMLChoice cmbConCondicion ;
   private ICheckbox chkConMostrarPos ;
   private HTMLChoice cmbConAdelDescu ;
   private ICheckbox chkConSegunPla ;
   private HTMLChoice cmbConSacDeven ;
   private HTMLChoice cmbConBaseLic ;
   private HTMLChoice cmbConBaseLicProm ;
   private HTMLChoice cmbConBaseFer ;
   private HTMLChoice cmbConBaseFerProm ;
   private HTMLChoice cmbConBaseHorExt ;
   private HTMLChoice cmbConBaseHorExtProm ;
   private HTMLChoice cmbConBasePres ;
   private HTMLChoice cmbConBaseAnt ;
   private HTMLChoice cmbConBaseOSDif ;
   private ICheckbox chkConErrorSiCero ;
   private ICheckbox chkConPueNov ;
   private IDataStoreProvider pr_default ;
   private boolean[] H00IB2_A1826ConPueNov ;
   private String[] H00IB2_A921ConPadre ;
   private boolean[] H00IB2_n921ConPadre ;
   private int[] H00IB2_A1822CliPadre ;
   private boolean[] H00IB2_n1822CliPadre ;
   private boolean[] H00IB2_A1821ConErrorSiCero ;
   private byte[] H00IB2_A1827ConBaseOSDif ;
   private byte[] H00IB2_A1801ConBaseAnt ;
   private byte[] H00IB2_A1800ConBasePres ;
   private byte[] H00IB2_A1799ConBaseHorExtProm ;
   private byte[] H00IB2_A1622ConBaseHorExt ;
   private byte[] H00IB2_A1798ConBaseFerProm ;
   private byte[] H00IB2_A1621ConBaseFer ;
   private byte[] H00IB2_A1797ConBaseLicProm ;
   private byte[] H00IB2_A1620ConBaseLic ;
   private String[] H00IB2_A1645ConceptoConveCodigo ;
   private boolean[] H00IB2_n1645ConceptoConveCodigo ;
   private short[] H00IB2_A1644ConceptoPais ;
   private boolean[] H00IB2_n1644ConceptoPais ;
   private byte[] H00IB2_A1539ConSacDeven ;
   private byte[] H00IB2_A1486ConRegEspApo ;
   private byte[] H00IB2_A1485ConRegDifApo ;
   private byte[] H00IB2_A1484ConLeyRieTrabCont ;
   private byte[] H00IB2_A1483ConFonNacEmpCont ;
   private byte[] H00IB2_A1482ConAsigFamCont ;
   private byte[] H00IB2_A1481ConRenateaCont ;
   private byte[] H00IB2_A1480ConRenateaApo ;
   private byte[] H00IB2_A1479ConFonSolRedCont ;
   private byte[] H00IB2_A1478ConFonSolRedApo ;
   private byte[] H00IB2_A1477ConObraSocCont ;
   private byte[] H00IB2_A1476ConObraSocApo ;
   private byte[] H00IB2_A1475ConINSSJyPCont ;
   private byte[] H00IB2_A1474ConINSSJyPApo ;
   private byte[] H00IB2_A1473ConSIPACont ;
   private byte[] H00IB2_A1472ConSIPAApo ;
   private String[] H00IB2_A1648ConCodAfip ;
   private boolean[] H00IB2_A1194ConSegunPla ;
   private short[] H00IB2_A1112AplIIGG ;
   private boolean[] H00IB2_n1112AplIIGG ;
   private byte[] H00IB2_A1077ConAdelDescu ;
   private boolean[] H00IB2_n1077ConAdelDescu ;
   private boolean[] H00IB2_A1068ConMostrarPos ;
   private String[] H00IB2_A954ConCondCodigo ;
   private String[] H00IB2_A953ConCondicion ;
   private boolean[] H00IB2_n953ConCondicion ;
   private String[] H00IB2_A1018ConRangoCant ;
   private boolean[] H00IB2_A762ConRecalcular ;
   private long[] H00IB2_A510ConOrdEjec ;
   private String[] H00IB2_A970ConClasifAux ;
   private boolean[] H00IB2_n970ConClasifAux ;
   private String[] H00IB2_A503ConTipoLiqAux ;
   private boolean[] H00IB2_n503ConTipoLiqAux ;
   private String[] H00IB2_A39SubTipoConCod2 ;
   private boolean[] H00IB2_n39SubTipoConCod2 ;
   private String[] H00IB2_A38SubTipoConCod1 ;
   private boolean[] H00IB2_n38SubTipoConCod1 ;
   private String[] H00IB2_A37TipoConCod ;
   private boolean[] H00IB2_A146ConForEditable ;
   private boolean[] H00IB2_n146ConForEditable ;
   private boolean[] H00IB2_A159ConVariable ;
   private String[] H00IB2_A153ConObservacion ;
   private String[] H00IB2_A148ConFormula ;
   private boolean[] H00IB2_n148ConFormula ;
   private byte[] H00IB2_A1488ConLiqBasica ;
   private byte[] H00IB2_A162ConVigencia ;
   private int[] H00IB2_A40ConOrden ;
   private String[] H00IB2_A41ConDescrip ;
   private String[] H00IB2_A26ConCodigo ;
   private int[] H00IB2_A3CliCod ;
   private long[] H00IB3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV28TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV47TFTipoConCod_Sels ;
   private GXSimpleCollection<String> AV50TFSubTipoConCod1_Sels ;
   private GXSimpleCollection<String> AV53TFSubTipoConCod2_Sels ;
   private GXSimpleCollection<String> AV70TFConCondicion_Sels ;
   private GXSimpleCollection<String> AV73TFConCondCodigo_Sels ;
   private GXSimpleCollection<String> AV93TFConCodAfip_Sels ;
   private GXSimpleCollection<String> AV130TFConceptoConveCodigo_Sels ;
   private GXSimpleCollection<String> AV154TFConPadre_Sels ;
   private GXSimpleCollection<String> AV31TFConDescrip_Sels ;
   private GXSimpleCollection<String> AV40TFConFormula_Sels ;
   private GXSimpleCollection<String> AV43TFConObservacion_Sels ;
   private GXSimpleCollection<String> AV56TFConTipoLiqAux_Sels ;
   private GXSimpleCollection<String> AV59TFConClasifAux_Sels ;
   private GXSimpleCollection<String> AV68TFConRangoCant_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV168ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext11[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState43[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV80DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class conceptos_exportww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00IB2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV187Conceptos_exportwwds_4_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV189Conceptos_exportwwds_6_tfcondescrip_sels ,
                                          String A148ConFormula ,
                                          GXSimpleCollection<String> AV195Conceptos_exportwwds_12_tfconformula_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV197Conceptos_exportwwds_14_tfconobservacion_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV200Conceptos_exportwwds_17_tftipoconcod_sels ,
                                          String A38SubTipoConCod1 ,
                                          GXSimpleCollection<String> AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels ,
                                          String A39SubTipoConCod2 ,
                                          GXSimpleCollection<String> AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV208Conceptos_exportwwds_25_tfconclasifaux_sels ,
                                          String A1018ConRangoCant ,
                                          GXSimpleCollection<String> AV213Conceptos_exportwwds_30_tfconrangocant_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV214Conceptos_exportwwds_31_tfconcondicion_sels ,
                                          String A954ConCondCodigo ,
                                          GXSimpleCollection<String> AV216Conceptos_exportwwds_33_tfconcondcodigo_sels ,
                                          byte A1077ConAdelDescu ,
                                          GXSimpleCollection<Byte> AV218Conceptos_exportwwds_35_tfconadeldescu_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV223Conceptos_exportwwds_40_tfconcodafip_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV258Conceptos_exportwwds_75_tfconbaselicprom_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV259Conceptos_exportwwds_76_tfconbaseferprom_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV261Conceptos_exportwwds_78_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV262Conceptos_exportwwds_79_tfconbaseant_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV263Conceptos_exportwwds_80_tfconbaseosdif_sels ,
                                          String A921ConPadre ,
                                          GXSimpleCollection<String> AV268Conceptos_exportwwds_85_tfconpadre_sels ,
                                          int AV184Conceptos_exportwwds_1_tfclicod ,
                                          int AV185Conceptos_exportwwds_2_tfclicod_to ,
                                          int AV187Conceptos_exportwwds_4_tfconcodigo_sels_size ,
                                          String AV186Conceptos_exportwwds_3_tfconcodigo ,
                                          int AV189Conceptos_exportwwds_6_tfcondescrip_sels_size ,
                                          String AV188Conceptos_exportwwds_5_tfcondescrip ,
                                          int AV190Conceptos_exportwwds_7_tfconorden ,
                                          int AV191Conceptos_exportwwds_8_tfconorden_to ,
                                          byte AV192Conceptos_exportwwds_9_tfconliqbasica ,
                                          byte AV193Conceptos_exportwwds_10_tfconliqbasica_to ,
                                          int AV195Conceptos_exportwwds_12_tfconformula_sels_size ,
                                          String AV194Conceptos_exportwwds_11_tfconformula ,
                                          int AV197Conceptos_exportwwds_14_tfconobservacion_sels_size ,
                                          String AV196Conceptos_exportwwds_13_tfconobservacion ,
                                          byte AV198Conceptos_exportwwds_15_tfconvariable_sel ,
                                          byte AV199Conceptos_exportwwds_16_tfconforeditable_sel ,
                                          int AV200Conceptos_exportwwds_17_tftipoconcod_sels_size ,
                                          int AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels_size ,
                                          String AV201Conceptos_exportwwds_18_tfsubtipoconcod1 ,
                                          int AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels_size ,
                                          String AV203Conceptos_exportwwds_20_tfsubtipoconcod2 ,
                                          int AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels_size ,
                                          String AV205Conceptos_exportwwds_22_tfcontipoliqaux ,
                                          int AV208Conceptos_exportwwds_25_tfconclasifaux_sels_size ,
                                          String AV207Conceptos_exportwwds_24_tfconclasifaux ,
                                          long AV209Conceptos_exportwwds_26_tfconordejec ,
                                          long AV210Conceptos_exportwwds_27_tfconordejec_to ,
                                          byte AV211Conceptos_exportwwds_28_tfconrecalcular_sel ,
                                          int AV213Conceptos_exportwwds_30_tfconrangocant_sels_size ,
                                          String AV212Conceptos_exportwwds_29_tfconrangocant ,
                                          int AV214Conceptos_exportwwds_31_tfconcondicion_sels_size ,
                                          int AV216Conceptos_exportwwds_33_tfconcondcodigo_sels_size ,
                                          String AV215Conceptos_exportwwds_32_tfconcondcodigo ,
                                          byte AV217Conceptos_exportwwds_34_tfconmostrarpos_sel ,
                                          int AV218Conceptos_exportwwds_35_tfconadeldescu_sels_size ,
                                          short AV219Conceptos_exportwwds_36_tfapliigg ,
                                          short AV220Conceptos_exportwwds_37_tfapliigg_to ,
                                          byte AV221Conceptos_exportwwds_38_tfconsegunpla_sel ,
                                          int AV223Conceptos_exportwwds_40_tfconcodafip_sels_size ,
                                          String AV222Conceptos_exportwwds_39_tfconcodafip ,
                                          byte AV224Conceptos_exportwwds_41_tfconsipaapo ,
                                          byte AV225Conceptos_exportwwds_42_tfconsipaapo_to ,
                                          byte AV226Conceptos_exportwwds_43_tfconsipacont ,
                                          byte AV227Conceptos_exportwwds_44_tfconsipacont_to ,
                                          byte AV228Conceptos_exportwwds_45_tfconinssjypapo ,
                                          byte AV229Conceptos_exportwwds_46_tfconinssjypapo_to ,
                                          byte AV230Conceptos_exportwwds_47_tfconinssjypcont ,
                                          byte AV231Conceptos_exportwwds_48_tfconinssjypcont_to ,
                                          byte AV232Conceptos_exportwwds_49_tfconobrasocapo ,
                                          byte AV233Conceptos_exportwwds_50_tfconobrasocapo_to ,
                                          byte AV234Conceptos_exportwwds_51_tfconobrasoccont ,
                                          byte AV235Conceptos_exportwwds_52_tfconobrasoccont_to ,
                                          byte AV236Conceptos_exportwwds_53_tfconfonsolredapo ,
                                          byte AV237Conceptos_exportwwds_54_tfconfonsolredapo_to ,
                                          byte AV238Conceptos_exportwwds_55_tfconfonsolredcont ,
                                          byte AV239Conceptos_exportwwds_56_tfconfonsolredcont_to ,
                                          byte AV240Conceptos_exportwwds_57_tfconrenateaapo ,
                                          byte AV241Conceptos_exportwwds_58_tfconrenateaapo_to ,
                                          byte AV242Conceptos_exportwwds_59_tfconrenateacont ,
                                          byte AV243Conceptos_exportwwds_60_tfconrenateacont_to ,
                                          byte AV244Conceptos_exportwwds_61_tfconasigfamcont ,
                                          byte AV245Conceptos_exportwwds_62_tfconasigfamcont_to ,
                                          byte AV246Conceptos_exportwwds_63_tfconfonnacempcont ,
                                          byte AV247Conceptos_exportwwds_64_tfconfonnacempcont_to ,
                                          byte AV248Conceptos_exportwwds_65_tfconleyrietrabcont ,
                                          byte AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to ,
                                          byte AV250Conceptos_exportwwds_67_tfconregdifapo ,
                                          byte AV251Conceptos_exportwwds_68_tfconregdifapo_to ,
                                          byte AV252Conceptos_exportwwds_69_tfconregespapo ,
                                          byte AV253Conceptos_exportwwds_70_tfconregespapo_to ,
                                          short AV254Conceptos_exportwwds_71_tfconceptopais ,
                                          short AV255Conceptos_exportwwds_72_tfconceptopais_to ,
                                          int AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels_size ,
                                          String AV256Conceptos_exportwwds_73_tfconceptoconvecodigo ,
                                          int AV258Conceptos_exportwwds_75_tfconbaselicprom_sels_size ,
                                          int AV259Conceptos_exportwwds_76_tfconbaseferprom_sels_size ,
                                          int AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels_size ,
                                          int AV261Conceptos_exportwwds_78_tfconbasepres_sels_size ,
                                          int AV262Conceptos_exportwwds_79_tfconbaseant_sels_size ,
                                          int AV263Conceptos_exportwwds_80_tfconbaseosdif_sels_size ,
                                          byte AV264Conceptos_exportwwds_81_tfconerrorsicero_sel ,
                                          int AV265Conceptos_exportwwds_82_tfclipadre ,
                                          int AV266Conceptos_exportwwds_83_tfclipadre_to ,
                                          int AV268Conceptos_exportwwds_85_tfconpadre_sels_size ,
                                          String AV267Conceptos_exportwwds_84_tfconpadre ,
                                          byte AV269Conceptos_exportwwds_86_tfconpuenov_sel ,
                                          int A3CliCod ,
                                          int A40ConOrden ,
                                          byte A1488ConLiqBasica ,
                                          boolean A159ConVariable ,
                                          boolean A146ConForEditable ,
                                          long A510ConOrdEjec ,
                                          boolean A762ConRecalcular ,
                                          boolean A1068ConMostrarPos ,
                                          short A1112AplIIGG ,
                                          boolean A1194ConSegunPla ,
                                          byte A1472ConSIPAApo ,
                                          byte A1473ConSIPACont ,
                                          byte A1474ConINSSJyPApo ,
                                          byte A1475ConINSSJyPCont ,
                                          byte A1476ConObraSocApo ,
                                          byte A1477ConObraSocCont ,
                                          byte A1478ConFonSolRedApo ,
                                          byte A1479ConFonSolRedCont ,
                                          byte A1480ConRenateaApo ,
                                          byte A1481ConRenateaCont ,
                                          byte A1482ConAsigFamCont ,
                                          byte A1483ConFonNacEmpCont ,
                                          byte A1484ConLeyRieTrabCont ,
                                          byte A1485ConRegDifApo ,
                                          byte A1486ConRegEspApo ,
                                          short A1644ConceptoPais ,
                                          boolean A1821ConErrorSiCero ,
                                          int A1822CliPadre ,
                                          boolean A1826ConPueNov ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV87CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int44 = new byte[61];
      Object[] GXv_Object45 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " ConPueNov, ConPadre, CliPadre, ConErrorSiCero, ConBaseOSDif, ConBaseAnt, ConBasePres, ConBaseHorExtProm, ConBaseHorExt, ConBaseFerProm, ConBaseFer, ConBaseLicProm," ;
      sSelectString += " ConBaseLic, ConceptoConveCodigo, ConceptoPais, ConSacDeven, ConRegEspApo, ConRegDifApo, ConLeyRieTrabCont, ConFonNacEmpCont, ConAsigFamCont, ConRenateaCont, ConRenateaApo," ;
      sSelectString += " ConFonSolRedCont, ConFonSolRedApo, ConObraSocCont, ConObraSocApo, ConINSSJyPCont, ConINSSJyPApo, ConSIPACont, ConSIPAApo, ConCodAfip, ConSegunPla, AplIIGG, ConAdelDescu," ;
      sSelectString += " ConMostrarPos, ConCondCodigo, ConCondicion, ConRangoCant, ConRecalcular, ConOrdEjec, ConClasifAux, ConTipoLiqAux, SubTipoConCod2, SubTipoConCod1, TipoConCod, ConForEditable," ;
      sSelectString += " ConVariable, ConObservacion, ConFormula, ConLiqBasica, ConVigencia, ConOrden, ConDescrip, ConCodigo, CliCod" ;
      sFromString = " FROM Concepto" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV184Conceptos_exportwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int44[1] = (byte)(1) ;
      }
      if ( ! (0==AV185Conceptos_exportwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int44[2] = (byte)(1) ;
      }
      if ( ( AV187Conceptos_exportwwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV186Conceptos_exportwwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int44[3] = (byte)(1) ;
      }
      if ( AV187Conceptos_exportwwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV187Conceptos_exportwwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV189Conceptos_exportwwds_6_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV188Conceptos_exportwwds_5_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int44[4] = (byte)(1) ;
      }
      if ( AV189Conceptos_exportwwds_6_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV189Conceptos_exportwwds_6_tfcondescrip_sels, "ConDescrip IN (", ")")+")");
      }
      if ( ! (0==AV190Conceptos_exportwwds_7_tfconorden) )
      {
         addWhere(sWhereString, "(ConOrden >= ?)");
      }
      else
      {
         GXv_int44[5] = (byte)(1) ;
      }
      if ( ! (0==AV191Conceptos_exportwwds_8_tfconorden_to) )
      {
         addWhere(sWhereString, "(ConOrden <= ?)");
      }
      else
      {
         GXv_int44[6] = (byte)(1) ;
      }
      if ( ! (0==AV192Conceptos_exportwwds_9_tfconliqbasica) )
      {
         addWhere(sWhereString, "(ConLiqBasica >= ?)");
      }
      else
      {
         GXv_int44[7] = (byte)(1) ;
      }
      if ( ! (0==AV193Conceptos_exportwwds_10_tfconliqbasica_to) )
      {
         addWhere(sWhereString, "(ConLiqBasica <= ?)");
      }
      else
      {
         GXv_int44[8] = (byte)(1) ;
      }
      if ( ( AV195Conceptos_exportwwds_12_tfconformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV194Conceptos_exportwwds_11_tfconformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConFormula) like LOWER(?))");
      }
      else
      {
         GXv_int44[9] = (byte)(1) ;
      }
      if ( AV195Conceptos_exportwwds_12_tfconformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV195Conceptos_exportwwds_12_tfconformula_sels, "ConFormula IN (", ")")+")");
      }
      if ( ( AV197Conceptos_exportwwds_14_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV196Conceptos_exportwwds_13_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int44[10] = (byte)(1) ;
      }
      if ( AV197Conceptos_exportwwds_14_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV197Conceptos_exportwwds_14_tfconobservacion_sels, "ConObservacion IN (", ")")+")");
      }
      if ( AV198Conceptos_exportwwds_15_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(ConVariable = TRUE)");
      }
      if ( AV198Conceptos_exportwwds_15_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(ConVariable = FALSE)");
      }
      if ( AV199Conceptos_exportwwds_16_tfconforeditable_sel == 1 )
      {
         addWhere(sWhereString, "(ConForEditable = TRUE)");
      }
      if ( AV199Conceptos_exportwwds_16_tfconforeditable_sel == 2 )
      {
         addWhere(sWhereString, "(ConForEditable = FALSE)");
      }
      if ( AV200Conceptos_exportwwds_17_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV200Conceptos_exportwwds_17_tftipoconcod_sels, "TipoConCod IN (", ")")+")");
      }
      if ( ( AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV201Conceptos_exportwwds_18_tfsubtipoconcod1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SubTipoConCod1) like LOWER(?))");
      }
      else
      {
         GXv_int44[11] = (byte)(1) ;
      }
      if ( AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels, "SubTipoConCod1 IN (", ")")+")");
      }
      if ( ( AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV203Conceptos_exportwwds_20_tfsubtipoconcod2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SubTipoConCod2) like LOWER(?))");
      }
      else
      {
         GXv_int44[12] = (byte)(1) ;
      }
      if ( AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels, "SubTipoConCod2 IN (", ")")+")");
      }
      if ( ( AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV205Conceptos_exportwwds_22_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int44[13] = (byte)(1) ;
      }
      if ( AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels, "ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV208Conceptos_exportwwds_25_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV207Conceptos_exportwwds_24_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int44[14] = (byte)(1) ;
      }
      if ( AV208Conceptos_exportwwds_25_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV208Conceptos_exportwwds_25_tfconclasifaux_sels, "ConClasifAux IN (", ")")+")");
      }
      if ( ! (0==AV209Conceptos_exportwwds_26_tfconordejec) )
      {
         addWhere(sWhereString, "(ConOrdEjec >= ?)");
      }
      else
      {
         GXv_int44[15] = (byte)(1) ;
      }
      if ( ! (0==AV210Conceptos_exportwwds_27_tfconordejec_to) )
      {
         addWhere(sWhereString, "(ConOrdEjec <= ?)");
      }
      else
      {
         GXv_int44[16] = (byte)(1) ;
      }
      if ( AV211Conceptos_exportwwds_28_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(ConRecalcular = TRUE)");
      }
      if ( AV211Conceptos_exportwwds_28_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(ConRecalcular = FALSE)");
      }
      if ( ( AV213Conceptos_exportwwds_30_tfconrangocant_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV212Conceptos_exportwwds_29_tfconrangocant)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConRangoCant) like LOWER(?))");
      }
      else
      {
         GXv_int44[17] = (byte)(1) ;
      }
      if ( AV213Conceptos_exportwwds_30_tfconrangocant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV213Conceptos_exportwwds_30_tfconrangocant_sels, "ConRangoCant IN (", ")")+")");
      }
      if ( AV214Conceptos_exportwwds_31_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV214Conceptos_exportwwds_31_tfconcondicion_sels, "ConCondicion IN (", ")")+")");
      }
      if ( ( AV216Conceptos_exportwwds_33_tfconcondcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV215Conceptos_exportwwds_32_tfconcondcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCondCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int44[18] = (byte)(1) ;
      }
      if ( AV216Conceptos_exportwwds_33_tfconcondcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV216Conceptos_exportwwds_33_tfconcondcodigo_sels, "ConCondCodigo IN (", ")")+")");
      }
      if ( AV217Conceptos_exportwwds_34_tfconmostrarpos_sel == 1 )
      {
         addWhere(sWhereString, "(ConMostrarPos = TRUE)");
      }
      if ( AV217Conceptos_exportwwds_34_tfconmostrarpos_sel == 2 )
      {
         addWhere(sWhereString, "(ConMostrarPos = FALSE)");
      }
      if ( AV218Conceptos_exportwwds_35_tfconadeldescu_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV218Conceptos_exportwwds_35_tfconadeldescu_sels, "ConAdelDescu IN (", ")")+")");
      }
      if ( ! (0==AV219Conceptos_exportwwds_36_tfapliigg) )
      {
         addWhere(sWhereString, "(AplIIGG >= ?)");
      }
      else
      {
         GXv_int44[19] = (byte)(1) ;
      }
      if ( ! (0==AV220Conceptos_exportwwds_37_tfapliigg_to) )
      {
         addWhere(sWhereString, "(AplIIGG <= ?)");
      }
      else
      {
         GXv_int44[20] = (byte)(1) ;
      }
      if ( AV221Conceptos_exportwwds_38_tfconsegunpla_sel == 1 )
      {
         addWhere(sWhereString, "(ConSegunPla = TRUE)");
      }
      if ( AV221Conceptos_exportwwds_38_tfconsegunpla_sel == 2 )
      {
         addWhere(sWhereString, "(ConSegunPla = FALSE)");
      }
      if ( ( AV223Conceptos_exportwwds_40_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV222Conceptos_exportwwds_39_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int44[21] = (byte)(1) ;
      }
      if ( AV223Conceptos_exportwwds_40_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV223Conceptos_exportwwds_40_tfconcodafip_sels, "ConCodAfip IN (", ")")+")");
      }
      if ( ! (0==AV224Conceptos_exportwwds_41_tfconsipaapo) )
      {
         addWhere(sWhereString, "(ConSIPAApo >= ?)");
      }
      else
      {
         GXv_int44[22] = (byte)(1) ;
      }
      if ( ! (0==AV225Conceptos_exportwwds_42_tfconsipaapo_to) )
      {
         addWhere(sWhereString, "(ConSIPAApo <= ?)");
      }
      else
      {
         GXv_int44[23] = (byte)(1) ;
      }
      if ( ! (0==AV226Conceptos_exportwwds_43_tfconsipacont) )
      {
         addWhere(sWhereString, "(ConSIPACont >= ?)");
      }
      else
      {
         GXv_int44[24] = (byte)(1) ;
      }
      if ( ! (0==AV227Conceptos_exportwwds_44_tfconsipacont_to) )
      {
         addWhere(sWhereString, "(ConSIPACont <= ?)");
      }
      else
      {
         GXv_int44[25] = (byte)(1) ;
      }
      if ( ! (0==AV228Conceptos_exportwwds_45_tfconinssjypapo) )
      {
         addWhere(sWhereString, "(ConINSSJyPApo >= ?)");
      }
      else
      {
         GXv_int44[26] = (byte)(1) ;
      }
      if ( ! (0==AV229Conceptos_exportwwds_46_tfconinssjypapo_to) )
      {
         addWhere(sWhereString, "(ConINSSJyPApo <= ?)");
      }
      else
      {
         GXv_int44[27] = (byte)(1) ;
      }
      if ( ! (0==AV230Conceptos_exportwwds_47_tfconinssjypcont) )
      {
         addWhere(sWhereString, "(ConINSSJyPCont >= ?)");
      }
      else
      {
         GXv_int44[28] = (byte)(1) ;
      }
      if ( ! (0==AV231Conceptos_exportwwds_48_tfconinssjypcont_to) )
      {
         addWhere(sWhereString, "(ConINSSJyPCont <= ?)");
      }
      else
      {
         GXv_int44[29] = (byte)(1) ;
      }
      if ( ! (0==AV232Conceptos_exportwwds_49_tfconobrasocapo) )
      {
         addWhere(sWhereString, "(ConObraSocApo >= ?)");
      }
      else
      {
         GXv_int44[30] = (byte)(1) ;
      }
      if ( ! (0==AV233Conceptos_exportwwds_50_tfconobrasocapo_to) )
      {
         addWhere(sWhereString, "(ConObraSocApo <= ?)");
      }
      else
      {
         GXv_int44[31] = (byte)(1) ;
      }
      if ( ! (0==AV234Conceptos_exportwwds_51_tfconobrasoccont) )
      {
         addWhere(sWhereString, "(ConObraSocCont >= ?)");
      }
      else
      {
         GXv_int44[32] = (byte)(1) ;
      }
      if ( ! (0==AV235Conceptos_exportwwds_52_tfconobrasoccont_to) )
      {
         addWhere(sWhereString, "(ConObraSocCont <= ?)");
      }
      else
      {
         GXv_int44[33] = (byte)(1) ;
      }
      if ( ! (0==AV236Conceptos_exportwwds_53_tfconfonsolredapo) )
      {
         addWhere(sWhereString, "(ConFonSolRedApo >= ?)");
      }
      else
      {
         GXv_int44[34] = (byte)(1) ;
      }
      if ( ! (0==AV237Conceptos_exportwwds_54_tfconfonsolredapo_to) )
      {
         addWhere(sWhereString, "(ConFonSolRedApo <= ?)");
      }
      else
      {
         GXv_int44[35] = (byte)(1) ;
      }
      if ( ! (0==AV238Conceptos_exportwwds_55_tfconfonsolredcont) )
      {
         addWhere(sWhereString, "(ConFonSolRedCont >= ?)");
      }
      else
      {
         GXv_int44[36] = (byte)(1) ;
      }
      if ( ! (0==AV239Conceptos_exportwwds_56_tfconfonsolredcont_to) )
      {
         addWhere(sWhereString, "(ConFonSolRedCont <= ?)");
      }
      else
      {
         GXv_int44[37] = (byte)(1) ;
      }
      if ( ! (0==AV240Conceptos_exportwwds_57_tfconrenateaapo) )
      {
         addWhere(sWhereString, "(ConRenateaApo >= ?)");
      }
      else
      {
         GXv_int44[38] = (byte)(1) ;
      }
      if ( ! (0==AV241Conceptos_exportwwds_58_tfconrenateaapo_to) )
      {
         addWhere(sWhereString, "(ConRenateaApo <= ?)");
      }
      else
      {
         GXv_int44[39] = (byte)(1) ;
      }
      if ( ! (0==AV242Conceptos_exportwwds_59_tfconrenateacont) )
      {
         addWhere(sWhereString, "(ConRenateaCont >= ?)");
      }
      else
      {
         GXv_int44[40] = (byte)(1) ;
      }
      if ( ! (0==AV243Conceptos_exportwwds_60_tfconrenateacont_to) )
      {
         addWhere(sWhereString, "(ConRenateaCont <= ?)");
      }
      else
      {
         GXv_int44[41] = (byte)(1) ;
      }
      if ( ! (0==AV244Conceptos_exportwwds_61_tfconasigfamcont) )
      {
         addWhere(sWhereString, "(ConAsigFamCont >= ?)");
      }
      else
      {
         GXv_int44[42] = (byte)(1) ;
      }
      if ( ! (0==AV245Conceptos_exportwwds_62_tfconasigfamcont_to) )
      {
         addWhere(sWhereString, "(ConAsigFamCont <= ?)");
      }
      else
      {
         GXv_int44[43] = (byte)(1) ;
      }
      if ( ! (0==AV246Conceptos_exportwwds_63_tfconfonnacempcont) )
      {
         addWhere(sWhereString, "(ConFonNacEmpCont >= ?)");
      }
      else
      {
         GXv_int44[44] = (byte)(1) ;
      }
      if ( ! (0==AV247Conceptos_exportwwds_64_tfconfonnacempcont_to) )
      {
         addWhere(sWhereString, "(ConFonNacEmpCont <= ?)");
      }
      else
      {
         GXv_int44[45] = (byte)(1) ;
      }
      if ( ! (0==AV248Conceptos_exportwwds_65_tfconleyrietrabcont) )
      {
         addWhere(sWhereString, "(ConLeyRieTrabCont >= ?)");
      }
      else
      {
         GXv_int44[46] = (byte)(1) ;
      }
      if ( ! (0==AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to) )
      {
         addWhere(sWhereString, "(ConLeyRieTrabCont <= ?)");
      }
      else
      {
         GXv_int44[47] = (byte)(1) ;
      }
      if ( ! (0==AV250Conceptos_exportwwds_67_tfconregdifapo) )
      {
         addWhere(sWhereString, "(ConRegDifApo >= ?)");
      }
      else
      {
         GXv_int44[48] = (byte)(1) ;
      }
      if ( ! (0==AV251Conceptos_exportwwds_68_tfconregdifapo_to) )
      {
         addWhere(sWhereString, "(ConRegDifApo <= ?)");
      }
      else
      {
         GXv_int44[49] = (byte)(1) ;
      }
      if ( ! (0==AV252Conceptos_exportwwds_69_tfconregespapo) )
      {
         addWhere(sWhereString, "(ConRegEspApo >= ?)");
      }
      else
      {
         GXv_int44[50] = (byte)(1) ;
      }
      if ( ! (0==AV253Conceptos_exportwwds_70_tfconregespapo_to) )
      {
         addWhere(sWhereString, "(ConRegEspApo <= ?)");
      }
      else
      {
         GXv_int44[51] = (byte)(1) ;
      }
      if ( ! (0==AV254Conceptos_exportwwds_71_tfconceptopais) )
      {
         addWhere(sWhereString, "(ConceptoPais >= ?)");
      }
      else
      {
         GXv_int44[52] = (byte)(1) ;
      }
      if ( ! (0==AV255Conceptos_exportwwds_72_tfconceptopais_to) )
      {
         addWhere(sWhereString, "(ConceptoPais <= ?)");
      }
      else
      {
         GXv_int44[53] = (byte)(1) ;
      }
      if ( ( AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV256Conceptos_exportwwds_73_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConceptoConveCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int44[54] = (byte)(1) ;
      }
      if ( AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels, "ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV258Conceptos_exportwwds_75_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV258Conceptos_exportwwds_75_tfconbaselicprom_sels, "ConBaseLicProm IN (", ")")+")");
      }
      if ( AV259Conceptos_exportwwds_76_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV259Conceptos_exportwwds_76_tfconbaseferprom_sels, "ConBaseFerProm IN (", ")")+")");
      }
      if ( AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels, "ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV261Conceptos_exportwwds_78_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV261Conceptos_exportwwds_78_tfconbasepres_sels, "ConBasePres IN (", ")")+")");
      }
      if ( AV262Conceptos_exportwwds_79_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV262Conceptos_exportwwds_79_tfconbaseant_sels, "ConBaseAnt IN (", ")")+")");
      }
      if ( AV263Conceptos_exportwwds_80_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV263Conceptos_exportwwds_80_tfconbaseosdif_sels, "ConBaseOSDif IN (", ")")+")");
      }
      if ( AV264Conceptos_exportwwds_81_tfconerrorsicero_sel == 1 )
      {
         addWhere(sWhereString, "(ConErrorSiCero = TRUE)");
      }
      if ( AV264Conceptos_exportwwds_81_tfconerrorsicero_sel == 2 )
      {
         addWhere(sWhereString, "(ConErrorSiCero = FALSE)");
      }
      if ( ! (0==AV265Conceptos_exportwwds_82_tfclipadre) )
      {
         addWhere(sWhereString, "(CliPadre >= ?)");
      }
      else
      {
         GXv_int44[55] = (byte)(1) ;
      }
      if ( ! (0==AV266Conceptos_exportwwds_83_tfclipadre_to) )
      {
         addWhere(sWhereString, "(CliPadre <= ?)");
      }
      else
      {
         GXv_int44[56] = (byte)(1) ;
      }
      if ( ( AV268Conceptos_exportwwds_85_tfconpadre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV267Conceptos_exportwwds_84_tfconpadre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConPadre) like LOWER(?))");
      }
      else
      {
         GXv_int44[57] = (byte)(1) ;
      }
      if ( AV268Conceptos_exportwwds_85_tfconpadre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV268Conceptos_exportwwds_85_tfconpadre_sels, "ConPadre IN (", ")")+")");
      }
      if ( AV269Conceptos_exportwwds_86_tfconpuenov_sel == 1 )
      {
         addWhere(sWhereString, "(ConPueNov = TRUE)");
      }
      if ( AV269Conceptos_exportwwds_86_tfconpuenov_sel == 2 )
      {
         addWhere(sWhereString, "(ConPueNov = FALSE)");
      }
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConCodigo, CliCod" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConCodigo DESC, CliCod" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConDescrip, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConDescrip DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConOrden, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConOrden DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConVigencia, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConVigencia DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConLiqBasica, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConLiqBasica DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConFormula, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConFormula DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConObservacion, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConObservacion DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConVariable, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConVariable DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConForEditable, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 10 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConForEditable DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY TipoConCod, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 11 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY TipoConCod DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 12 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY SubTipoConCod1, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 12 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY SubTipoConCod1 DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY SubTipoConCod2, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY SubTipoConCod2 DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConTipoLiqAux, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConTipoLiqAux DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 15 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConClasifAux, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 15 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConClasifAux DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 16 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConOrdEjec, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 16 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConOrdEjec DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 17 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConRecalcular, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 17 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConRecalcular DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 18 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConRangoCant, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 18 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConRangoCant DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 19 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConCondicion, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 19 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConCondicion DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 20 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConCondCodigo, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 20 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConCondCodigo DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 21 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConMostrarPos, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 21 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConMostrarPos DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 22 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConAdelDescu, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 22 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConAdelDescu DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 23 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY AplIIGG, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 23 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY AplIIGG DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 24 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConSegunPla, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 24 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConSegunPla DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 25 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConCodAfip, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 25 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConCodAfip DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 26 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConSIPAApo, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 26 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConSIPAApo DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 27 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConSIPACont, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 27 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConSIPACont DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 28 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConINSSJyPApo, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 28 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConINSSJyPApo DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 29 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConINSSJyPCont, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 29 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConINSSJyPCont DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 30 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConObraSocApo, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 30 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConObraSocApo DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 31 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConObraSocCont, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 31 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConObraSocCont DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 32 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConFonSolRedApo, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 32 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConFonSolRedApo DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 33 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConFonSolRedCont, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 33 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConFonSolRedCont DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 34 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConRenateaApo, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 34 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConRenateaApo DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 35 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConRenateaCont, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 35 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConRenateaCont DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 36 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConAsigFamCont, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 36 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConAsigFamCont DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 37 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConFonNacEmpCont, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 37 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConFonNacEmpCont DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 38 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConLeyRieTrabCont, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 38 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConLeyRieTrabCont DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 39 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConRegDifApo, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 39 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConRegDifApo DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 40 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConRegEspApo, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 40 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConRegEspApo DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 41 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConSacDeven, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 41 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConSacDeven DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 42 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConceptoPais, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 42 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConceptoPais DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 43 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConceptoConveCodigo, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 43 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConceptoConveCodigo DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 44 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConBaseLic, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 44 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConBaseLic DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 45 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConBaseLicProm, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 45 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConBaseLicProm DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 46 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConBaseFer, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 46 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConBaseFer DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 47 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConBaseFerProm, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 47 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConBaseFerProm DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 48 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConBaseHorExt, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 48 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConBaseHorExt DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 49 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConBaseHorExtProm, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 49 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConBaseHorExtProm DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 50 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConBasePres, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 50 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConBasePres DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 51 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConBaseAnt, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 51 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConBaseAnt DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 52 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConBaseOSDif, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 52 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConBaseOSDif DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 53 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConErrorSiCero, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 53 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConErrorSiCero DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 54 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY CliPadre, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 54 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliPadre DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 55 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConPadre, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 55 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConPadre DESC, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 56 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConPueNov, CliCod, ConCodigo" ;
      }
      else if ( ( AV14OrderedBy == 56 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConPueNov DESC, CliCod, ConCodigo" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, ConCodigo" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object45[0] = scmdbuf ;
      GXv_Object45[1] = GXv_int44 ;
      return GXv_Object45 ;
   }

   protected Object[] conditional_H00IB3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV187Conceptos_exportwwds_4_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV189Conceptos_exportwwds_6_tfcondescrip_sels ,
                                          String A148ConFormula ,
                                          GXSimpleCollection<String> AV195Conceptos_exportwwds_12_tfconformula_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV197Conceptos_exportwwds_14_tfconobservacion_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV200Conceptos_exportwwds_17_tftipoconcod_sels ,
                                          String A38SubTipoConCod1 ,
                                          GXSimpleCollection<String> AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels ,
                                          String A39SubTipoConCod2 ,
                                          GXSimpleCollection<String> AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV208Conceptos_exportwwds_25_tfconclasifaux_sels ,
                                          String A1018ConRangoCant ,
                                          GXSimpleCollection<String> AV213Conceptos_exportwwds_30_tfconrangocant_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV214Conceptos_exportwwds_31_tfconcondicion_sels ,
                                          String A954ConCondCodigo ,
                                          GXSimpleCollection<String> AV216Conceptos_exportwwds_33_tfconcondcodigo_sels ,
                                          byte A1077ConAdelDescu ,
                                          GXSimpleCollection<Byte> AV218Conceptos_exportwwds_35_tfconadeldescu_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV223Conceptos_exportwwds_40_tfconcodafip_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV258Conceptos_exportwwds_75_tfconbaselicprom_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV259Conceptos_exportwwds_76_tfconbaseferprom_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV261Conceptos_exportwwds_78_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV262Conceptos_exportwwds_79_tfconbaseant_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV263Conceptos_exportwwds_80_tfconbaseosdif_sels ,
                                          String A921ConPadre ,
                                          GXSimpleCollection<String> AV268Conceptos_exportwwds_85_tfconpadre_sels ,
                                          int AV184Conceptos_exportwwds_1_tfclicod ,
                                          int AV185Conceptos_exportwwds_2_tfclicod_to ,
                                          int AV187Conceptos_exportwwds_4_tfconcodigo_sels_size ,
                                          String AV186Conceptos_exportwwds_3_tfconcodigo ,
                                          int AV189Conceptos_exportwwds_6_tfcondescrip_sels_size ,
                                          String AV188Conceptos_exportwwds_5_tfcondescrip ,
                                          int AV190Conceptos_exportwwds_7_tfconorden ,
                                          int AV191Conceptos_exportwwds_8_tfconorden_to ,
                                          byte AV192Conceptos_exportwwds_9_tfconliqbasica ,
                                          byte AV193Conceptos_exportwwds_10_tfconliqbasica_to ,
                                          int AV195Conceptos_exportwwds_12_tfconformula_sels_size ,
                                          String AV194Conceptos_exportwwds_11_tfconformula ,
                                          int AV197Conceptos_exportwwds_14_tfconobservacion_sels_size ,
                                          String AV196Conceptos_exportwwds_13_tfconobservacion ,
                                          byte AV198Conceptos_exportwwds_15_tfconvariable_sel ,
                                          byte AV199Conceptos_exportwwds_16_tfconforeditable_sel ,
                                          int AV200Conceptos_exportwwds_17_tftipoconcod_sels_size ,
                                          int AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels_size ,
                                          String AV201Conceptos_exportwwds_18_tfsubtipoconcod1 ,
                                          int AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels_size ,
                                          String AV203Conceptos_exportwwds_20_tfsubtipoconcod2 ,
                                          int AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels_size ,
                                          String AV205Conceptos_exportwwds_22_tfcontipoliqaux ,
                                          int AV208Conceptos_exportwwds_25_tfconclasifaux_sels_size ,
                                          String AV207Conceptos_exportwwds_24_tfconclasifaux ,
                                          long AV209Conceptos_exportwwds_26_tfconordejec ,
                                          long AV210Conceptos_exportwwds_27_tfconordejec_to ,
                                          byte AV211Conceptos_exportwwds_28_tfconrecalcular_sel ,
                                          int AV213Conceptos_exportwwds_30_tfconrangocant_sels_size ,
                                          String AV212Conceptos_exportwwds_29_tfconrangocant ,
                                          int AV214Conceptos_exportwwds_31_tfconcondicion_sels_size ,
                                          int AV216Conceptos_exportwwds_33_tfconcondcodigo_sels_size ,
                                          String AV215Conceptos_exportwwds_32_tfconcondcodigo ,
                                          byte AV217Conceptos_exportwwds_34_tfconmostrarpos_sel ,
                                          int AV218Conceptos_exportwwds_35_tfconadeldescu_sels_size ,
                                          short AV219Conceptos_exportwwds_36_tfapliigg ,
                                          short AV220Conceptos_exportwwds_37_tfapliigg_to ,
                                          byte AV221Conceptos_exportwwds_38_tfconsegunpla_sel ,
                                          int AV223Conceptos_exportwwds_40_tfconcodafip_sels_size ,
                                          String AV222Conceptos_exportwwds_39_tfconcodafip ,
                                          byte AV224Conceptos_exportwwds_41_tfconsipaapo ,
                                          byte AV225Conceptos_exportwwds_42_tfconsipaapo_to ,
                                          byte AV226Conceptos_exportwwds_43_tfconsipacont ,
                                          byte AV227Conceptos_exportwwds_44_tfconsipacont_to ,
                                          byte AV228Conceptos_exportwwds_45_tfconinssjypapo ,
                                          byte AV229Conceptos_exportwwds_46_tfconinssjypapo_to ,
                                          byte AV230Conceptos_exportwwds_47_tfconinssjypcont ,
                                          byte AV231Conceptos_exportwwds_48_tfconinssjypcont_to ,
                                          byte AV232Conceptos_exportwwds_49_tfconobrasocapo ,
                                          byte AV233Conceptos_exportwwds_50_tfconobrasocapo_to ,
                                          byte AV234Conceptos_exportwwds_51_tfconobrasoccont ,
                                          byte AV235Conceptos_exportwwds_52_tfconobrasoccont_to ,
                                          byte AV236Conceptos_exportwwds_53_tfconfonsolredapo ,
                                          byte AV237Conceptos_exportwwds_54_tfconfonsolredapo_to ,
                                          byte AV238Conceptos_exportwwds_55_tfconfonsolredcont ,
                                          byte AV239Conceptos_exportwwds_56_tfconfonsolredcont_to ,
                                          byte AV240Conceptos_exportwwds_57_tfconrenateaapo ,
                                          byte AV241Conceptos_exportwwds_58_tfconrenateaapo_to ,
                                          byte AV242Conceptos_exportwwds_59_tfconrenateacont ,
                                          byte AV243Conceptos_exportwwds_60_tfconrenateacont_to ,
                                          byte AV244Conceptos_exportwwds_61_tfconasigfamcont ,
                                          byte AV245Conceptos_exportwwds_62_tfconasigfamcont_to ,
                                          byte AV246Conceptos_exportwwds_63_tfconfonnacempcont ,
                                          byte AV247Conceptos_exportwwds_64_tfconfonnacempcont_to ,
                                          byte AV248Conceptos_exportwwds_65_tfconleyrietrabcont ,
                                          byte AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to ,
                                          byte AV250Conceptos_exportwwds_67_tfconregdifapo ,
                                          byte AV251Conceptos_exportwwds_68_tfconregdifapo_to ,
                                          byte AV252Conceptos_exportwwds_69_tfconregespapo ,
                                          byte AV253Conceptos_exportwwds_70_tfconregespapo_to ,
                                          short AV254Conceptos_exportwwds_71_tfconceptopais ,
                                          short AV255Conceptos_exportwwds_72_tfconceptopais_to ,
                                          int AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels_size ,
                                          String AV256Conceptos_exportwwds_73_tfconceptoconvecodigo ,
                                          int AV258Conceptos_exportwwds_75_tfconbaselicprom_sels_size ,
                                          int AV259Conceptos_exportwwds_76_tfconbaseferprom_sels_size ,
                                          int AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels_size ,
                                          int AV261Conceptos_exportwwds_78_tfconbasepres_sels_size ,
                                          int AV262Conceptos_exportwwds_79_tfconbaseant_sels_size ,
                                          int AV263Conceptos_exportwwds_80_tfconbaseosdif_sels_size ,
                                          byte AV264Conceptos_exportwwds_81_tfconerrorsicero_sel ,
                                          int AV265Conceptos_exportwwds_82_tfclipadre ,
                                          int AV266Conceptos_exportwwds_83_tfclipadre_to ,
                                          int AV268Conceptos_exportwwds_85_tfconpadre_sels_size ,
                                          String AV267Conceptos_exportwwds_84_tfconpadre ,
                                          byte AV269Conceptos_exportwwds_86_tfconpuenov_sel ,
                                          int A3CliCod ,
                                          int A40ConOrden ,
                                          byte A1488ConLiqBasica ,
                                          boolean A159ConVariable ,
                                          boolean A146ConForEditable ,
                                          long A510ConOrdEjec ,
                                          boolean A762ConRecalcular ,
                                          boolean A1068ConMostrarPos ,
                                          short A1112AplIIGG ,
                                          boolean A1194ConSegunPla ,
                                          byte A1472ConSIPAApo ,
                                          byte A1473ConSIPACont ,
                                          byte A1474ConINSSJyPApo ,
                                          byte A1475ConINSSJyPCont ,
                                          byte A1476ConObraSocApo ,
                                          byte A1477ConObraSocCont ,
                                          byte A1478ConFonSolRedApo ,
                                          byte A1479ConFonSolRedCont ,
                                          byte A1480ConRenateaApo ,
                                          byte A1481ConRenateaCont ,
                                          byte A1482ConAsigFamCont ,
                                          byte A1483ConFonNacEmpCont ,
                                          byte A1484ConLeyRieTrabCont ,
                                          byte A1485ConRegDifApo ,
                                          byte A1486ConRegEspApo ,
                                          short A1644ConceptoPais ,
                                          boolean A1821ConErrorSiCero ,
                                          int A1822CliPadre ,
                                          boolean A1826ConPueNov ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV87CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int47 = new byte[58];
      Object[] GXv_Object48 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV184Conceptos_exportwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int47[1] = (byte)(1) ;
      }
      if ( ! (0==AV185Conceptos_exportwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int47[2] = (byte)(1) ;
      }
      if ( ( AV187Conceptos_exportwwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV186Conceptos_exportwwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int47[3] = (byte)(1) ;
      }
      if ( AV187Conceptos_exportwwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV187Conceptos_exportwwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV189Conceptos_exportwwds_6_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV188Conceptos_exportwwds_5_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int47[4] = (byte)(1) ;
      }
      if ( AV189Conceptos_exportwwds_6_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV189Conceptos_exportwwds_6_tfcondescrip_sels, "ConDescrip IN (", ")")+")");
      }
      if ( ! (0==AV190Conceptos_exportwwds_7_tfconorden) )
      {
         addWhere(sWhereString, "(ConOrden >= ?)");
      }
      else
      {
         GXv_int47[5] = (byte)(1) ;
      }
      if ( ! (0==AV191Conceptos_exportwwds_8_tfconorden_to) )
      {
         addWhere(sWhereString, "(ConOrden <= ?)");
      }
      else
      {
         GXv_int47[6] = (byte)(1) ;
      }
      if ( ! (0==AV192Conceptos_exportwwds_9_tfconliqbasica) )
      {
         addWhere(sWhereString, "(ConLiqBasica >= ?)");
      }
      else
      {
         GXv_int47[7] = (byte)(1) ;
      }
      if ( ! (0==AV193Conceptos_exportwwds_10_tfconliqbasica_to) )
      {
         addWhere(sWhereString, "(ConLiqBasica <= ?)");
      }
      else
      {
         GXv_int47[8] = (byte)(1) ;
      }
      if ( ( AV195Conceptos_exportwwds_12_tfconformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV194Conceptos_exportwwds_11_tfconformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConFormula) like LOWER(?))");
      }
      else
      {
         GXv_int47[9] = (byte)(1) ;
      }
      if ( AV195Conceptos_exportwwds_12_tfconformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV195Conceptos_exportwwds_12_tfconformula_sels, "ConFormula IN (", ")")+")");
      }
      if ( ( AV197Conceptos_exportwwds_14_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV196Conceptos_exportwwds_13_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int47[10] = (byte)(1) ;
      }
      if ( AV197Conceptos_exportwwds_14_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV197Conceptos_exportwwds_14_tfconobservacion_sels, "ConObservacion IN (", ")")+")");
      }
      if ( AV198Conceptos_exportwwds_15_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(ConVariable = TRUE)");
      }
      if ( AV198Conceptos_exportwwds_15_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(ConVariable = FALSE)");
      }
      if ( AV199Conceptos_exportwwds_16_tfconforeditable_sel == 1 )
      {
         addWhere(sWhereString, "(ConForEditable = TRUE)");
      }
      if ( AV199Conceptos_exportwwds_16_tfconforeditable_sel == 2 )
      {
         addWhere(sWhereString, "(ConForEditable = FALSE)");
      }
      if ( AV200Conceptos_exportwwds_17_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV200Conceptos_exportwwds_17_tftipoconcod_sels, "TipoConCod IN (", ")")+")");
      }
      if ( ( AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV201Conceptos_exportwwds_18_tfsubtipoconcod1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SubTipoConCod1) like LOWER(?))");
      }
      else
      {
         GXv_int47[11] = (byte)(1) ;
      }
      if ( AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV202Conceptos_exportwwds_19_tfsubtipoconcod1_sels, "SubTipoConCod1 IN (", ")")+")");
      }
      if ( ( AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV203Conceptos_exportwwds_20_tfsubtipoconcod2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SubTipoConCod2) like LOWER(?))");
      }
      else
      {
         GXv_int47[12] = (byte)(1) ;
      }
      if ( AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV204Conceptos_exportwwds_21_tfsubtipoconcod2_sels, "SubTipoConCod2 IN (", ")")+")");
      }
      if ( ( AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV205Conceptos_exportwwds_22_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int47[13] = (byte)(1) ;
      }
      if ( AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV206Conceptos_exportwwds_23_tfcontipoliqaux_sels, "ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV208Conceptos_exportwwds_25_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV207Conceptos_exportwwds_24_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int47[14] = (byte)(1) ;
      }
      if ( AV208Conceptos_exportwwds_25_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV208Conceptos_exportwwds_25_tfconclasifaux_sels, "ConClasifAux IN (", ")")+")");
      }
      if ( ! (0==AV209Conceptos_exportwwds_26_tfconordejec) )
      {
         addWhere(sWhereString, "(ConOrdEjec >= ?)");
      }
      else
      {
         GXv_int47[15] = (byte)(1) ;
      }
      if ( ! (0==AV210Conceptos_exportwwds_27_tfconordejec_to) )
      {
         addWhere(sWhereString, "(ConOrdEjec <= ?)");
      }
      else
      {
         GXv_int47[16] = (byte)(1) ;
      }
      if ( AV211Conceptos_exportwwds_28_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(ConRecalcular = TRUE)");
      }
      if ( AV211Conceptos_exportwwds_28_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(ConRecalcular = FALSE)");
      }
      if ( ( AV213Conceptos_exportwwds_30_tfconrangocant_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV212Conceptos_exportwwds_29_tfconrangocant)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConRangoCant) like LOWER(?))");
      }
      else
      {
         GXv_int47[17] = (byte)(1) ;
      }
      if ( AV213Conceptos_exportwwds_30_tfconrangocant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV213Conceptos_exportwwds_30_tfconrangocant_sels, "ConRangoCant IN (", ")")+")");
      }
      if ( AV214Conceptos_exportwwds_31_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV214Conceptos_exportwwds_31_tfconcondicion_sels, "ConCondicion IN (", ")")+")");
      }
      if ( ( AV216Conceptos_exportwwds_33_tfconcondcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV215Conceptos_exportwwds_32_tfconcondcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCondCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int47[18] = (byte)(1) ;
      }
      if ( AV216Conceptos_exportwwds_33_tfconcondcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV216Conceptos_exportwwds_33_tfconcondcodigo_sels, "ConCondCodigo IN (", ")")+")");
      }
      if ( AV217Conceptos_exportwwds_34_tfconmostrarpos_sel == 1 )
      {
         addWhere(sWhereString, "(ConMostrarPos = TRUE)");
      }
      if ( AV217Conceptos_exportwwds_34_tfconmostrarpos_sel == 2 )
      {
         addWhere(sWhereString, "(ConMostrarPos = FALSE)");
      }
      if ( AV218Conceptos_exportwwds_35_tfconadeldescu_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV218Conceptos_exportwwds_35_tfconadeldescu_sels, "ConAdelDescu IN (", ")")+")");
      }
      if ( ! (0==AV219Conceptos_exportwwds_36_tfapliigg) )
      {
         addWhere(sWhereString, "(AplIIGG >= ?)");
      }
      else
      {
         GXv_int47[19] = (byte)(1) ;
      }
      if ( ! (0==AV220Conceptos_exportwwds_37_tfapliigg_to) )
      {
         addWhere(sWhereString, "(AplIIGG <= ?)");
      }
      else
      {
         GXv_int47[20] = (byte)(1) ;
      }
      if ( AV221Conceptos_exportwwds_38_tfconsegunpla_sel == 1 )
      {
         addWhere(sWhereString, "(ConSegunPla = TRUE)");
      }
      if ( AV221Conceptos_exportwwds_38_tfconsegunpla_sel == 2 )
      {
         addWhere(sWhereString, "(ConSegunPla = FALSE)");
      }
      if ( ( AV223Conceptos_exportwwds_40_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV222Conceptos_exportwwds_39_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int47[21] = (byte)(1) ;
      }
      if ( AV223Conceptos_exportwwds_40_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV223Conceptos_exportwwds_40_tfconcodafip_sels, "ConCodAfip IN (", ")")+")");
      }
      if ( ! (0==AV224Conceptos_exportwwds_41_tfconsipaapo) )
      {
         addWhere(sWhereString, "(ConSIPAApo >= ?)");
      }
      else
      {
         GXv_int47[22] = (byte)(1) ;
      }
      if ( ! (0==AV225Conceptos_exportwwds_42_tfconsipaapo_to) )
      {
         addWhere(sWhereString, "(ConSIPAApo <= ?)");
      }
      else
      {
         GXv_int47[23] = (byte)(1) ;
      }
      if ( ! (0==AV226Conceptos_exportwwds_43_tfconsipacont) )
      {
         addWhere(sWhereString, "(ConSIPACont >= ?)");
      }
      else
      {
         GXv_int47[24] = (byte)(1) ;
      }
      if ( ! (0==AV227Conceptos_exportwwds_44_tfconsipacont_to) )
      {
         addWhere(sWhereString, "(ConSIPACont <= ?)");
      }
      else
      {
         GXv_int47[25] = (byte)(1) ;
      }
      if ( ! (0==AV228Conceptos_exportwwds_45_tfconinssjypapo) )
      {
         addWhere(sWhereString, "(ConINSSJyPApo >= ?)");
      }
      else
      {
         GXv_int47[26] = (byte)(1) ;
      }
      if ( ! (0==AV229Conceptos_exportwwds_46_tfconinssjypapo_to) )
      {
         addWhere(sWhereString, "(ConINSSJyPApo <= ?)");
      }
      else
      {
         GXv_int47[27] = (byte)(1) ;
      }
      if ( ! (0==AV230Conceptos_exportwwds_47_tfconinssjypcont) )
      {
         addWhere(sWhereString, "(ConINSSJyPCont >= ?)");
      }
      else
      {
         GXv_int47[28] = (byte)(1) ;
      }
      if ( ! (0==AV231Conceptos_exportwwds_48_tfconinssjypcont_to) )
      {
         addWhere(sWhereString, "(ConINSSJyPCont <= ?)");
      }
      else
      {
         GXv_int47[29] = (byte)(1) ;
      }
      if ( ! (0==AV232Conceptos_exportwwds_49_tfconobrasocapo) )
      {
         addWhere(sWhereString, "(ConObraSocApo >= ?)");
      }
      else
      {
         GXv_int47[30] = (byte)(1) ;
      }
      if ( ! (0==AV233Conceptos_exportwwds_50_tfconobrasocapo_to) )
      {
         addWhere(sWhereString, "(ConObraSocApo <= ?)");
      }
      else
      {
         GXv_int47[31] = (byte)(1) ;
      }
      if ( ! (0==AV234Conceptos_exportwwds_51_tfconobrasoccont) )
      {
         addWhere(sWhereString, "(ConObraSocCont >= ?)");
      }
      else
      {
         GXv_int47[32] = (byte)(1) ;
      }
      if ( ! (0==AV235Conceptos_exportwwds_52_tfconobrasoccont_to) )
      {
         addWhere(sWhereString, "(ConObraSocCont <= ?)");
      }
      else
      {
         GXv_int47[33] = (byte)(1) ;
      }
      if ( ! (0==AV236Conceptos_exportwwds_53_tfconfonsolredapo) )
      {
         addWhere(sWhereString, "(ConFonSolRedApo >= ?)");
      }
      else
      {
         GXv_int47[34] = (byte)(1) ;
      }
      if ( ! (0==AV237Conceptos_exportwwds_54_tfconfonsolredapo_to) )
      {
         addWhere(sWhereString, "(ConFonSolRedApo <= ?)");
      }
      else
      {
         GXv_int47[35] = (byte)(1) ;
      }
      if ( ! (0==AV238Conceptos_exportwwds_55_tfconfonsolredcont) )
      {
         addWhere(sWhereString, "(ConFonSolRedCont >= ?)");
      }
      else
      {
         GXv_int47[36] = (byte)(1) ;
      }
      if ( ! (0==AV239Conceptos_exportwwds_56_tfconfonsolredcont_to) )
      {
         addWhere(sWhereString, "(ConFonSolRedCont <= ?)");
      }
      else
      {
         GXv_int47[37] = (byte)(1) ;
      }
      if ( ! (0==AV240Conceptos_exportwwds_57_tfconrenateaapo) )
      {
         addWhere(sWhereString, "(ConRenateaApo >= ?)");
      }
      else
      {
         GXv_int47[38] = (byte)(1) ;
      }
      if ( ! (0==AV241Conceptos_exportwwds_58_tfconrenateaapo_to) )
      {
         addWhere(sWhereString, "(ConRenateaApo <= ?)");
      }
      else
      {
         GXv_int47[39] = (byte)(1) ;
      }
      if ( ! (0==AV242Conceptos_exportwwds_59_tfconrenateacont) )
      {
         addWhere(sWhereString, "(ConRenateaCont >= ?)");
      }
      else
      {
         GXv_int47[40] = (byte)(1) ;
      }
      if ( ! (0==AV243Conceptos_exportwwds_60_tfconrenateacont_to) )
      {
         addWhere(sWhereString, "(ConRenateaCont <= ?)");
      }
      else
      {
         GXv_int47[41] = (byte)(1) ;
      }
      if ( ! (0==AV244Conceptos_exportwwds_61_tfconasigfamcont) )
      {
         addWhere(sWhereString, "(ConAsigFamCont >= ?)");
      }
      else
      {
         GXv_int47[42] = (byte)(1) ;
      }
      if ( ! (0==AV245Conceptos_exportwwds_62_tfconasigfamcont_to) )
      {
         addWhere(sWhereString, "(ConAsigFamCont <= ?)");
      }
      else
      {
         GXv_int47[43] = (byte)(1) ;
      }
      if ( ! (0==AV246Conceptos_exportwwds_63_tfconfonnacempcont) )
      {
         addWhere(sWhereString, "(ConFonNacEmpCont >= ?)");
      }
      else
      {
         GXv_int47[44] = (byte)(1) ;
      }
      if ( ! (0==AV247Conceptos_exportwwds_64_tfconfonnacempcont_to) )
      {
         addWhere(sWhereString, "(ConFonNacEmpCont <= ?)");
      }
      else
      {
         GXv_int47[45] = (byte)(1) ;
      }
      if ( ! (0==AV248Conceptos_exportwwds_65_tfconleyrietrabcont) )
      {
         addWhere(sWhereString, "(ConLeyRieTrabCont >= ?)");
      }
      else
      {
         GXv_int47[46] = (byte)(1) ;
      }
      if ( ! (0==AV249Conceptos_exportwwds_66_tfconleyrietrabcont_to) )
      {
         addWhere(sWhereString, "(ConLeyRieTrabCont <= ?)");
      }
      else
      {
         GXv_int47[47] = (byte)(1) ;
      }
      if ( ! (0==AV250Conceptos_exportwwds_67_tfconregdifapo) )
      {
         addWhere(sWhereString, "(ConRegDifApo >= ?)");
      }
      else
      {
         GXv_int47[48] = (byte)(1) ;
      }
      if ( ! (0==AV251Conceptos_exportwwds_68_tfconregdifapo_to) )
      {
         addWhere(sWhereString, "(ConRegDifApo <= ?)");
      }
      else
      {
         GXv_int47[49] = (byte)(1) ;
      }
      if ( ! (0==AV252Conceptos_exportwwds_69_tfconregespapo) )
      {
         addWhere(sWhereString, "(ConRegEspApo >= ?)");
      }
      else
      {
         GXv_int47[50] = (byte)(1) ;
      }
      if ( ! (0==AV253Conceptos_exportwwds_70_tfconregespapo_to) )
      {
         addWhere(sWhereString, "(ConRegEspApo <= ?)");
      }
      else
      {
         GXv_int47[51] = (byte)(1) ;
      }
      if ( ! (0==AV254Conceptos_exportwwds_71_tfconceptopais) )
      {
         addWhere(sWhereString, "(ConceptoPais >= ?)");
      }
      else
      {
         GXv_int47[52] = (byte)(1) ;
      }
      if ( ! (0==AV255Conceptos_exportwwds_72_tfconceptopais_to) )
      {
         addWhere(sWhereString, "(ConceptoPais <= ?)");
      }
      else
      {
         GXv_int47[53] = (byte)(1) ;
      }
      if ( ( AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV256Conceptos_exportwwds_73_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConceptoConveCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int47[54] = (byte)(1) ;
      }
      if ( AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV257Conceptos_exportwwds_74_tfconceptoconvecodigo_sels, "ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV258Conceptos_exportwwds_75_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV258Conceptos_exportwwds_75_tfconbaselicprom_sels, "ConBaseLicProm IN (", ")")+")");
      }
      if ( AV259Conceptos_exportwwds_76_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV259Conceptos_exportwwds_76_tfconbaseferprom_sels, "ConBaseFerProm IN (", ")")+")");
      }
      if ( AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV260Conceptos_exportwwds_77_tfconbasehorextprom_sels, "ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV261Conceptos_exportwwds_78_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV261Conceptos_exportwwds_78_tfconbasepres_sels, "ConBasePres IN (", ")")+")");
      }
      if ( AV262Conceptos_exportwwds_79_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV262Conceptos_exportwwds_79_tfconbaseant_sels, "ConBaseAnt IN (", ")")+")");
      }
      if ( AV263Conceptos_exportwwds_80_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV263Conceptos_exportwwds_80_tfconbaseosdif_sels, "ConBaseOSDif IN (", ")")+")");
      }
      if ( AV264Conceptos_exportwwds_81_tfconerrorsicero_sel == 1 )
      {
         addWhere(sWhereString, "(ConErrorSiCero = TRUE)");
      }
      if ( AV264Conceptos_exportwwds_81_tfconerrorsicero_sel == 2 )
      {
         addWhere(sWhereString, "(ConErrorSiCero = FALSE)");
      }
      if ( ! (0==AV265Conceptos_exportwwds_82_tfclipadre) )
      {
         addWhere(sWhereString, "(CliPadre >= ?)");
      }
      else
      {
         GXv_int47[55] = (byte)(1) ;
      }
      if ( ! (0==AV266Conceptos_exportwwds_83_tfclipadre_to) )
      {
         addWhere(sWhereString, "(CliPadre <= ?)");
      }
      else
      {
         GXv_int47[56] = (byte)(1) ;
      }
      if ( ( AV268Conceptos_exportwwds_85_tfconpadre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV267Conceptos_exportwwds_84_tfconpadre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConPadre) like LOWER(?))");
      }
      else
      {
         GXv_int47[57] = (byte)(1) ;
      }
      if ( AV268Conceptos_exportwwds_85_tfconpadre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV268Conceptos_exportwwds_85_tfconpadre_sels, "ConPadre IN (", ")")+")");
      }
      if ( AV269Conceptos_exportwwds_86_tfconpuenov_sel == 1 )
      {
         addWhere(sWhereString, "(ConPueNov = TRUE)");
      }
      if ( AV269Conceptos_exportwwds_86_tfconpuenov_sel == 2 )
      {
         addWhere(sWhereString, "(ConPueNov = FALSE)");
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
      else if ( ( AV14OrderedBy == 12 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 12 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 13 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 14 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 15 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 15 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 16 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 16 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 17 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 17 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 18 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 18 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 19 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 19 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 20 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 20 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 21 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 21 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 22 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 22 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 23 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 23 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 24 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 24 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 25 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 25 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 26 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 26 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 27 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 27 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 28 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 28 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 29 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 29 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 30 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 30 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 31 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 31 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 32 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 32 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 33 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 33 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 34 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 34 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 35 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 35 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 36 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 36 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 37 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 37 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 38 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 38 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 39 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 39 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 40 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 40 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 41 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 41 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 42 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 42 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 43 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 43 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 44 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 44 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 45 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 45 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 46 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 46 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 47 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 47 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 48 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 48 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 49 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 49 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 50 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 50 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 51 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 51 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 52 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 52 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 53 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 53 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 54 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 54 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 55 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 55 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 56 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 56 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object48[0] = scmdbuf ;
      GXv_Object48[1] = GXv_int47 ;
      return GXv_Object48 ;
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
                  return conditional_H00IB2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (String)dynConstraints[20] , (GXSimpleCollection<String>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , (String)dynConstraints[26] , (GXSimpleCollection<String>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , ((Number) dynConstraints[50]).intValue() , ((Number) dynConstraints[51]).intValue() , ((Number) dynConstraints[52]).byteValue() , ((Number) dynConstraints[53]).byteValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).byteValue() , ((Number) dynConstraints[59]).byteValue() , ((Number) dynConstraints[60]).intValue() , ((Number) dynConstraints[61]).intValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , ((Number) dynConstraints[65]).intValue() , (String)dynConstraints[66] , ((Number) dynConstraints[67]).intValue() , (String)dynConstraints[68] , ((Number) dynConstraints[69]).longValue() , ((Number) dynConstraints[70]).longValue() , ((Number) dynConstraints[71]).byteValue() , ((Number) dynConstraints[72]).intValue() , (String)dynConstraints[73] , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , (String)dynConstraints[76] , ((Number) dynConstraints[77]).byteValue() , ((Number) dynConstraints[78]).intValue() , ((Number) dynConstraints[79]).shortValue() , ((Number) dynConstraints[80]).shortValue() , ((Number) dynConstraints[81]).byteValue() , ((Number) dynConstraints[82]).intValue() , (String)dynConstraints[83] , ((Number) dynConstraints[84]).byteValue() , ((Number) dynConstraints[85]).byteValue() , ((Number) dynConstraints[86]).byteValue() , ((Number) dynConstraints[87]).byteValue() , ((Number) dynConstraints[88]).byteValue() , ((Number) dynConstraints[89]).byteValue() , ((Number) dynConstraints[90]).byteValue() , ((Number) dynConstraints[91]).byteValue() , ((Number) dynConstraints[92]).byteValue() , ((Number) dynConstraints[93]).byteValue() , ((Number) dynConstraints[94]).byteValue() , ((Number) dynConstraints[95]).byteValue() , ((Number) dynConstraints[96]).byteValue() , ((Number) dynConstraints[97]).byteValue() , ((Number) dynConstraints[98]).byteValue() , ((Number) dynConstraints[99]).byteValue() , ((Number) dynConstraints[100]).byteValue() , ((Number) dynConstraints[101]).byteValue() , ((Number) dynConstraints[102]).byteValue() , ((Number) dynConstraints[103]).byteValue() , ((Number) dynConstraints[104]).byteValue() , ((Number) dynConstraints[105]).byteValue() , ((Number) dynConstraints[106]).byteValue() , ((Number) dynConstraints[107]).byteValue() , ((Number) dynConstraints[108]).byteValue() , ((Number) dynConstraints[109]).byteValue() , ((Number) dynConstraints[110]).byteValue() , ((Number) dynConstraints[111]).byteValue() , ((Number) dynConstraints[112]).byteValue() , ((Number) dynConstraints[113]).byteValue() , ((Number) dynConstraints[114]).shortValue() , ((Number) dynConstraints[115]).shortValue() , ((Number) dynConstraints[116]).intValue() , (String)dynConstraints[117] , ((Number) dynConstraints[118]).intValue() , ((Number) dynConstraints[119]).intValue() , ((Number) dynConstraints[120]).intValue() , ((Number) dynConstraints[121]).intValue() , ((Number) dynConstraints[122]).intValue() , ((Number) dynConstraints[123]).intValue() , ((Number) dynConstraints[124]).byteValue() , ((Number) dynConstraints[125]).intValue() , ((Number) dynConstraints[126]).intValue() , ((Number) dynConstraints[127]).intValue() , (String)dynConstraints[128] , ((Number) dynConstraints[129]).byteValue() , ((Number) dynConstraints[130]).intValue() , ((Number) dynConstraints[131]).intValue() , ((Number) dynConstraints[132]).byteValue() , ((Boolean) dynConstraints[133]).booleanValue() , ((Boolean) dynConstraints[134]).booleanValue() , ((Number) dynConstraints[135]).longValue() , ((Boolean) dynConstraints[136]).booleanValue() , ((Boolean) dynConstraints[137]).booleanValue() , ((Number) dynConstraints[138]).shortValue() , ((Boolean) dynConstraints[139]).booleanValue() , ((Number) dynConstraints[140]).byteValue() , ((Number) dynConstraints[141]).byteValue() , ((Number) dynConstraints[142]).byteValue() , ((Number) dynConstraints[143]).byteValue() , ((Number) dynConstraints[144]).byteValue() , ((Number) dynConstraints[145]).byteValue() , ((Number) dynConstraints[146]).byteValue() , ((Number) dynConstraints[147]).byteValue() , ((Number) dynConstraints[148]).byteValue() , ((Number) dynConstraints[149]).byteValue() , ((Number) dynConstraints[150]).byteValue() , ((Number) dynConstraints[151]).byteValue() , ((Number) dynConstraints[152]).byteValue() , ((Number) dynConstraints[153]).byteValue() , ((Number) dynConstraints[154]).byteValue() , ((Number) dynConstraints[155]).shortValue() , ((Boolean) dynConstraints[156]).booleanValue() , ((Number) dynConstraints[157]).intValue() , ((Boolean) dynConstraints[158]).booleanValue() , ((Number) dynConstraints[159]).shortValue() , ((Boolean) dynConstraints[160]).booleanValue() , ((Number) dynConstraints[161]).intValue() );
            case 1 :
                  return conditional_H00IB3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (String)dynConstraints[20] , (GXSimpleCollection<String>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , (String)dynConstraints[26] , (GXSimpleCollection<String>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , ((Number) dynConstraints[50]).intValue() , ((Number) dynConstraints[51]).intValue() , ((Number) dynConstraints[52]).byteValue() , ((Number) dynConstraints[53]).byteValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).byteValue() , ((Number) dynConstraints[59]).byteValue() , ((Number) dynConstraints[60]).intValue() , ((Number) dynConstraints[61]).intValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , ((Number) dynConstraints[65]).intValue() , (String)dynConstraints[66] , ((Number) dynConstraints[67]).intValue() , (String)dynConstraints[68] , ((Number) dynConstraints[69]).longValue() , ((Number) dynConstraints[70]).longValue() , ((Number) dynConstraints[71]).byteValue() , ((Number) dynConstraints[72]).intValue() , (String)dynConstraints[73] , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , (String)dynConstraints[76] , ((Number) dynConstraints[77]).byteValue() , ((Number) dynConstraints[78]).intValue() , ((Number) dynConstraints[79]).shortValue() , ((Number) dynConstraints[80]).shortValue() , ((Number) dynConstraints[81]).byteValue() , ((Number) dynConstraints[82]).intValue() , (String)dynConstraints[83] , ((Number) dynConstraints[84]).byteValue() , ((Number) dynConstraints[85]).byteValue() , ((Number) dynConstraints[86]).byteValue() , ((Number) dynConstraints[87]).byteValue() , ((Number) dynConstraints[88]).byteValue() , ((Number) dynConstraints[89]).byteValue() , ((Number) dynConstraints[90]).byteValue() , ((Number) dynConstraints[91]).byteValue() , ((Number) dynConstraints[92]).byteValue() , ((Number) dynConstraints[93]).byteValue() , ((Number) dynConstraints[94]).byteValue() , ((Number) dynConstraints[95]).byteValue() , ((Number) dynConstraints[96]).byteValue() , ((Number) dynConstraints[97]).byteValue() , ((Number) dynConstraints[98]).byteValue() , ((Number) dynConstraints[99]).byteValue() , ((Number) dynConstraints[100]).byteValue() , ((Number) dynConstraints[101]).byteValue() , ((Number) dynConstraints[102]).byteValue() , ((Number) dynConstraints[103]).byteValue() , ((Number) dynConstraints[104]).byteValue() , ((Number) dynConstraints[105]).byteValue() , ((Number) dynConstraints[106]).byteValue() , ((Number) dynConstraints[107]).byteValue() , ((Number) dynConstraints[108]).byteValue() , ((Number) dynConstraints[109]).byteValue() , ((Number) dynConstraints[110]).byteValue() , ((Number) dynConstraints[111]).byteValue() , ((Number) dynConstraints[112]).byteValue() , ((Number) dynConstraints[113]).byteValue() , ((Number) dynConstraints[114]).shortValue() , ((Number) dynConstraints[115]).shortValue() , ((Number) dynConstraints[116]).intValue() , (String)dynConstraints[117] , ((Number) dynConstraints[118]).intValue() , ((Number) dynConstraints[119]).intValue() , ((Number) dynConstraints[120]).intValue() , ((Number) dynConstraints[121]).intValue() , ((Number) dynConstraints[122]).intValue() , ((Number) dynConstraints[123]).intValue() , ((Number) dynConstraints[124]).byteValue() , ((Number) dynConstraints[125]).intValue() , ((Number) dynConstraints[126]).intValue() , ((Number) dynConstraints[127]).intValue() , (String)dynConstraints[128] , ((Number) dynConstraints[129]).byteValue() , ((Number) dynConstraints[130]).intValue() , ((Number) dynConstraints[131]).intValue() , ((Number) dynConstraints[132]).byteValue() , ((Boolean) dynConstraints[133]).booleanValue() , ((Boolean) dynConstraints[134]).booleanValue() , ((Number) dynConstraints[135]).longValue() , ((Boolean) dynConstraints[136]).booleanValue() , ((Boolean) dynConstraints[137]).booleanValue() , ((Number) dynConstraints[138]).shortValue() , ((Boolean) dynConstraints[139]).booleanValue() , ((Number) dynConstraints[140]).byteValue() , ((Number) dynConstraints[141]).byteValue() , ((Number) dynConstraints[142]).byteValue() , ((Number) dynConstraints[143]).byteValue() , ((Number) dynConstraints[144]).byteValue() , ((Number) dynConstraints[145]).byteValue() , ((Number) dynConstraints[146]).byteValue() , ((Number) dynConstraints[147]).byteValue() , ((Number) dynConstraints[148]).byteValue() , ((Number) dynConstraints[149]).byteValue() , ((Number) dynConstraints[150]).byteValue() , ((Number) dynConstraints[151]).byteValue() , ((Number) dynConstraints[152]).byteValue() , ((Number) dynConstraints[153]).byteValue() , ((Number) dynConstraints[154]).byteValue() , ((Number) dynConstraints[155]).shortValue() , ((Boolean) dynConstraints[156]).booleanValue() , ((Number) dynConstraints[157]).intValue() , ((Boolean) dynConstraints[158]).booleanValue() , ((Number) dynConstraints[159]).shortValue() , ((Boolean) dynConstraints[160]).booleanValue() , ((Number) dynConstraints[161]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00IB2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00IB3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(4);
               ((byte[]) buf[6])[0] = rslt.getByte(5);
               ((byte[]) buf[7])[0] = rslt.getByte(6);
               ((byte[]) buf[8])[0] = rslt.getByte(7);
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((byte[]) buf[10])[0] = rslt.getByte(9);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((byte[]) buf[12])[0] = rslt.getByte(11);
               ((byte[]) buf[13])[0] = rslt.getByte(12);
               ((byte[]) buf[14])[0] = rslt.getByte(13);
               ((String[]) buf[15])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((short[]) buf[17])[0] = rslt.getShort(15);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((byte[]) buf[19])[0] = rslt.getByte(16);
               ((byte[]) buf[20])[0] = rslt.getByte(17);
               ((byte[]) buf[21])[0] = rslt.getByte(18);
               ((byte[]) buf[22])[0] = rslt.getByte(19);
               ((byte[]) buf[23])[0] = rslt.getByte(20);
               ((byte[]) buf[24])[0] = rslt.getByte(21);
               ((byte[]) buf[25])[0] = rslt.getByte(22);
               ((byte[]) buf[26])[0] = rslt.getByte(23);
               ((byte[]) buf[27])[0] = rslt.getByte(24);
               ((byte[]) buf[28])[0] = rslt.getByte(25);
               ((byte[]) buf[29])[0] = rslt.getByte(26);
               ((byte[]) buf[30])[0] = rslt.getByte(27);
               ((byte[]) buf[31])[0] = rslt.getByte(28);
               ((byte[]) buf[32])[0] = rslt.getByte(29);
               ((byte[]) buf[33])[0] = rslt.getByte(30);
               ((byte[]) buf[34])[0] = rslt.getByte(31);
               ((String[]) buf[35])[0] = rslt.getString(32, 6);
               ((boolean[]) buf[36])[0] = rslt.getBoolean(33);
               ((short[]) buf[37])[0] = rslt.getShort(34);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
               ((byte[]) buf[39])[0] = rslt.getByte(35);
               ((boolean[]) buf[40])[0] = rslt.wasNull();
               ((boolean[]) buf[41])[0] = rslt.getBoolean(36);
               ((String[]) buf[42])[0] = rslt.getString(37, 20);
               ((String[]) buf[43])[0] = rslt.getString(38, 20);
               ((boolean[]) buf[44])[0] = rslt.wasNull();
               ((String[]) buf[45])[0] = rslt.getVarchar(39);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(40);
               ((long[]) buf[47])[0] = rslt.getLong(41);
               ((String[]) buf[48])[0] = rslt.getVarchar(42);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((String[]) buf[50])[0] = rslt.getVarchar(43);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((String[]) buf[52])[0] = rslt.getString(44, 20);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((String[]) buf[54])[0] = rslt.getString(45, 20);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getString(46, 20);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(47);
               ((boolean[]) buf[58])[0] = rslt.wasNull();
               ((boolean[]) buf[59])[0] = rslt.getBoolean(48);
               ((String[]) buf[60])[0] = rslt.getLongVarchar(49);
               ((String[]) buf[61])[0] = rslt.getLongVarchar(50);
               ((boolean[]) buf[62])[0] = rslt.wasNull();
               ((byte[]) buf[63])[0] = rslt.getByte(51);
               ((byte[]) buf[64])[0] = rslt.getByte(52);
               ((int[]) buf[65])[0] = rslt.getInt(53);
               ((String[]) buf[66])[0] = rslt.getVarchar(54);
               ((String[]) buf[67])[0] = rslt.getString(55, 10);
               ((int[]) buf[68])[0] = rslt.getInt(56);
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
                  stmt.setInt(sIdx, ((Number) parms[61]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[62]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[63]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[64], 10);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[66]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[67]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[68]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[69]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 200);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[72], 20);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[73], 20);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 40);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 80);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[76]).longValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[77]).longValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 400);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[79], 20);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[80]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[81]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[82], 6);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[83]).byteValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[84]).byteValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[85]).byteValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[86]).byteValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[87]).byteValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[88]).byteValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[89]).byteValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[90]).byteValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[91]).byteValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[92]).byteValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[93]).byteValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[94]).byteValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[95]).byteValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[96]).byteValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[97]).byteValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[98]).byteValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[99]).byteValue());
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[100]).byteValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[101]).byteValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[102]).byteValue());
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[103]).byteValue());
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[104]).byteValue());
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[105]).byteValue());
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[106]).byteValue());
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[107]).byteValue());
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[108]).byteValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[109]).byteValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[110]).byteValue());
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[111]).byteValue());
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[112]).byteValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[113]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[114]).shortValue());
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[115], 20);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[118], 10);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[119]).intValue());
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[120]).intValue());
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[121]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[58]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[59]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[60]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[61], 10);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[63]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[64]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[65]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[66]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 200);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[69], 20);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[70], 20);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 40);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 80);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[73]).longValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[74]).longValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 400);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 20);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[77]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[78]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[79], 6);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[80]).byteValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[81]).byteValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[82]).byteValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[83]).byteValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[84]).byteValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[85]).byteValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[86]).byteValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[87]).byteValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[88]).byteValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[89]).byteValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[90]).byteValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[91]).byteValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[92]).byteValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[93]).byteValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[94]).byteValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[95]).byteValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[96]).byteValue());
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[97]).byteValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[98]).byteValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[99]).byteValue());
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[100]).byteValue());
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[101]).byteValue());
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[102]).byteValue());
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[103]).byteValue());
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[104]).byteValue());
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[105]).byteValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[106]).byteValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[107]).byteValue());
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[108]).byteValue());
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[109]).byteValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[112], 20);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[114]).intValue());
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[115], 10);
               }
               return;
      }
   }

}

