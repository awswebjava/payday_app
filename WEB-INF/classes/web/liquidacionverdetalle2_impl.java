package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liquidacionverdetalle2_impl extends GXDataArea
{
   public liquidacionverdetalle2_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liquidacionverdetalle2_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionverdetalle2_impl.class ));
   }

   public liquidacionverdetalle2_impl( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbavMostrar = new HTMLChoice();
      cmbDTipoConCod = new HTMLChoice();
      cmbLiqDMostrar = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "auxMenuOpcCod") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "auxMenuOpcCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "auxMenuOpcCod") ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdt_liquidacion2s") == 0 )
         {
            gxnrgridsdt_liquidacion2s_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsdt_liquidacion2s") == 0 )
         {
            gxgrgridsdt_liquidacion2s_refresh_invoke( ) ;
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
            AV207auxMenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV207auxMenuOpcCod", AV207auxMenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV207auxMenuOpcCod, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV14CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14CliCod), 6, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
               AV25EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV25EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV25EmpCod), "ZZZ9")));
               AV9LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9LiqNro), 8, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LiqNro), "ZZZZZZZ9")));
               AV5LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5LegNumero), 8, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5LegNumero), "ZZZZZZZ9")));
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
      nRC_GXsfl_138 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_138"))) ;
      nGXsfl_138_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_138_idx"))) ;
      sGXsfl_138_idx = httpContext.GetPar( "sGXsfl_138_idx") ;
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
      subGridsdt_liquidacion2s_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdt_liquidacion2s_Rows"))) ;
      cmbavMostrar.fromJSonString( httpContext.GetNextPar( ));
      AV62Mostrar = httpContext.GetPar( "Mostrar") ;
      AV14CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV25EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV9LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
      AV5LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
      AV59ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV15ColumnsSelector);
      AV223Pgmname = httpContext.GetPar( "Pgmname") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV37GridState);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV102TFDTipoConCod_Sels);
      AV198TFLiqDClasifAux = httpContext.GetPar( "TFLiqDClasifAux") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV199TFLiqDClasifAux_Sels);
      AV88TFDConCodigo = httpContext.GetPar( "TFDConCodigo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV89TFDConCodigo_Sels);
      AV91TFDConDescrip = httpContext.GetPar( "TFDConDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV92TFDConDescrip_Sels);
      AV147TFLiqDValUni = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDValUni"), ".") ;
      AV148TFLiqDValUni_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDValUni_To"), ".") ;
      AV134TFLiqDImpReCalcu = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDImpReCalcu"), ".") ;
      AV135TFLiqDImpReCalcu_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDImpReCalcu_To"), ".") ;
      AV123TFLiqDErrorDesc = httpContext.GetPar( "TFLiqDErrorDesc") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV124TFLiqDErrorDesc_Sels);
      AV188modoTestEs = GXutil.strtobool( httpContext.GetPar( "modoTestEs")) ;
      AV54LiqEstado = (byte)(GXutil.lval( httpContext.GetPar( "LiqEstado"))) ;
      AV63OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV65OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV207auxMenuOpcCod = httpContext.GetPar( "auxMenuOpcCod") ;
      AV179TFConClasifAux = httpContext.GetPar( "TFConClasifAux") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV180TFConClasifAux_Sels);
      AV18ConVariable = GXutil.strtobool( httpContext.GetPar( "ConVariable")) ;
      AV168TotLiqDImpReCalcu = CommonUtil.decimalVal( httpContext.GetPar( "TotLiqDImpReCalcu"), ".") ;
      AV183TotLiqDSeg = CommonUtil.decimalVal( httpContext.GetPar( "TotLiqDSeg"), ".") ;
      AV167TotLiqDImpCalcu = CommonUtil.decimalVal( httpContext.GetPar( "TotLiqDImpCalcu"), ".") ;
      AV42IsAuthorized_InfoOriginal = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_InfoOriginal")) ;
      AV211LiqFecImp = localUtil.parseDTimeParm( httpContext.GetPar( "LiqFecImp")) ;
      AV209sistemaPalabra = httpContext.GetPar( "sistemaPalabra") ;
      AV200WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV192sdt_liquidacion2);
      AV190MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, subGridsdt_liquidacion2s_Rows, AV62Mostrar, AV14CliCod, AV25EmpCod, AV9LiqNro, AV5LegNumero, AV59ManageFiltersExecutionStep, AV15ColumnsSelector, AV223Pgmname, AV37GridState, AV102TFDTipoConCod_Sels, AV198TFLiqDClasifAux, AV199TFLiqDClasifAux_Sels, AV88TFDConCodigo, AV89TFDConCodigo_Sels, AV91TFDConDescrip, AV92TFDConDescrip_Sels, AV147TFLiqDValUni, AV148TFLiqDValUni_To, AV134TFLiqDImpReCalcu, AV135TFLiqDImpReCalcu_To, AV123TFLiqDErrorDesc, AV124TFLiqDErrorDesc_Sels, AV188modoTestEs, AV54LiqEstado, AV63OrderedBy, AV65OrderedDsc, AV207auxMenuOpcCod, AV179TFConClasifAux, AV180TFConClasifAux_Sels, AV18ConVariable, AV168TotLiqDImpReCalcu, AV183TotLiqDSeg, AV167TotLiqDImpCalcu, AV42IsAuthorized_InfoOriginal, AV211LiqFecImp, AV209sistemaPalabra, AV200WelcomeMessage_NoMostrarMas, AV192sdt_liquidacion2, AV190MenuOpcCod) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void gxnrgridsdt_liquidacion2s_newrow_invoke( )
   {
      nRC_GXsfl_197 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_197"))) ;
      nGXsfl_197_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_197_idx"))) ;
      sGXsfl_197_idx = httpContext.GetPar( "sGXsfl_197_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridsdt_liquidacion2s_newrow( ) ;
      /* End function gxnrGridsdt_liquidacion2s_newrow_invoke */
   }

   public void gxgrgridsdt_liquidacion2s_refresh_invoke( )
   {
      subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
      subGridsdt_liquidacion2s_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdt_liquidacion2s_Rows"))) ;
      cmbavMostrar.fromJSonString( httpContext.GetNextPar( ));
      AV62Mostrar = httpContext.GetPar( "Mostrar") ;
      AV14CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV25EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV9LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
      AV59ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV15ColumnsSelector);
      AV223Pgmname = httpContext.GetPar( "Pgmname") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV37GridState);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV102TFDTipoConCod_Sels);
      AV198TFLiqDClasifAux = httpContext.GetPar( "TFLiqDClasifAux") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV199TFLiqDClasifAux_Sels);
      AV88TFDConCodigo = httpContext.GetPar( "TFDConCodigo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV89TFDConCodigo_Sels);
      AV91TFDConDescrip = httpContext.GetPar( "TFDConDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV92TFDConDescrip_Sels);
      AV147TFLiqDValUni = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDValUni"), ".") ;
      AV148TFLiqDValUni_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDValUni_To"), ".") ;
      AV134TFLiqDImpReCalcu = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDImpReCalcu"), ".") ;
      AV135TFLiqDImpReCalcu_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDImpReCalcu_To"), ".") ;
      AV123TFLiqDErrorDesc = httpContext.GetPar( "TFLiqDErrorDesc") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV124TFLiqDErrorDesc_Sels);
      AV188modoTestEs = GXutil.strtobool( httpContext.GetPar( "modoTestEs")) ;
      AV54LiqEstado = (byte)(GXutil.lval( httpContext.GetPar( "LiqEstado"))) ;
      AV63OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV65OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV207auxMenuOpcCod = httpContext.GetPar( "auxMenuOpcCod") ;
      AV5LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
      AV179TFConClasifAux = httpContext.GetPar( "TFConClasifAux") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV180TFConClasifAux_Sels);
      AV18ConVariable = GXutil.strtobool( httpContext.GetPar( "ConVariable")) ;
      A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      A31LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
      A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A764LiqDImpReCalcu = CommonUtil.decimalVal( httpContext.GetPar( "LiqDImpReCalcu"), ".") ;
      AV168TotLiqDImpReCalcu = CommonUtil.decimalVal( httpContext.GetPar( "TotLiqDImpReCalcu"), ".") ;
      A1469LiqDSeg = CommonUtil.decimalVal( httpContext.GetPar( "LiqDSeg"), ".") ;
      AV183TotLiqDSeg = CommonUtil.decimalVal( httpContext.GetPar( "TotLiqDSeg"), ".") ;
      cmbDTipoConCod.fromJSonString( httpContext.GetNextPar( ));
      A464DTipoConCod = httpContext.GetPar( "DTipoConCod") ;
      AV167TotLiqDImpCalcu = CommonUtil.decimalVal( httpContext.GetPar( "TotLiqDImpCalcu"), ".") ;
      A275LiqDImpCalcu = CommonUtil.decimalVal( httpContext.GetPar( "LiqDImpCalcu"), ".") ;
      n275LiqDImpCalcu = false ;
      AV200WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV192sdt_liquidacion2);
      AV42IsAuthorized_InfoOriginal = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_InfoOriginal")) ;
      AV211LiqFecImp = localUtil.parseDTimeParm( httpContext.GetPar( "LiqFecImp")) ;
      AV209sistemaPalabra = httpContext.GetPar( "sistemaPalabra") ;
      AV190MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridsdt_liquidacion2s_refresh( subGrid_Rows, subGridsdt_liquidacion2s_Rows, AV62Mostrar, AV14CliCod, AV25EmpCod, AV9LiqNro, AV59ManageFiltersExecutionStep, AV15ColumnsSelector, AV223Pgmname, AV37GridState, AV102TFDTipoConCod_Sels, AV198TFLiqDClasifAux, AV199TFLiqDClasifAux_Sels, AV88TFDConCodigo, AV89TFDConCodigo_Sels, AV91TFDConDescrip, AV92TFDConDescrip_Sels, AV147TFLiqDValUni, AV148TFLiqDValUni_To, AV134TFLiqDImpReCalcu, AV135TFLiqDImpReCalcu_To, AV123TFLiqDErrorDesc, AV124TFLiqDErrorDesc_Sels, AV188modoTestEs, AV54LiqEstado, AV63OrderedBy, AV65OrderedDsc, AV207auxMenuOpcCod, AV5LegNumero, AV179TFConClasifAux, AV180TFConClasifAux_Sels, AV18ConVariable, A1EmpCod, A31LiqNro, A6LegNumero, A3CliCod, A764LiqDImpReCalcu, AV168TotLiqDImpReCalcu, A1469LiqDSeg, AV183TotLiqDSeg, A464DTipoConCod, AV167TotLiqDImpCalcu, A275LiqDImpCalcu, AV200WelcomeMessage_NoMostrarMas, AV192sdt_liquidacion2, AV42IsAuthorized_InfoOriginal, AV211LiqFecImp, AV209sistemaPalabra, AV190MenuOpcCod) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridsdt_liquidacion2s_refresh_invoke */
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
      paH62( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startH62( ) ;
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
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liquidacionverdetalle2", new String[] {GXutil.URLEncode(GXutil.rtrim(AV207auxMenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV14CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV25EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LiqNro,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV5LegNumero,8,0))}, new String[] {"auxMenuOpcCod","CliCod","EmpCod","LiqNro","LegNumero"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV25EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV223Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODOTESTES", getSecureSignedToken( "", AV188modoTestEs));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQESTADO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV54LiqEstado), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTFCONCLASIFAUX", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV179TFConClasifAux, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTFCONCLASIFAUX_SELS", getSecureSignedToken( "", AV180TFConClasifAux_Sels));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVARIABLE", getSecureSignedToken( "", AV18ConVariable));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDIMPRECALCU", getSecureSignedToken( "", localUtil.format( AV168TotLiqDImpReCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDSEG", getSecureSignedToken( "", localUtil.format( AV183TotLiqDSeg, "9.999")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDIMPCALCU", getSecureSignedToken( "", localUtil.format( AV167TotLiqDImpCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INFOORIGINAL", getSecureSignedToken( "", AV42IsAuthorized_InfoOriginal));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQFECIMP", getSecureSignedToken( "", localUtil.format( AV211LiqFecImp, "99/99/99 99:99")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSISTEMAPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV209sistemaPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV190MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDT_LIQUIDACION2", getSecureSignedToken( "", AV192sdt_liquidacion2));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV207auxMenuOpcCod, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vMOSTRAR", GXutil.rtrim( AV62Mostrar));
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdt_liquidacion2", AV192sdt_liquidacion2);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdt_liquidacion2", AV192sdt_liquidacion2);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdt_liquidacion2", getSecureSignedToken( "", AV192sdt_liquidacion2));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_138", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_138, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_197", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_197, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV21DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV21DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV15ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV15ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV58ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV58ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV35GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV36GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV34GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDT_LIQUIDACION2SCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV194Gridsdt_liquidacion2sCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDT_LIQUIDACION2SPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV195Gridsdt_liquidacion2sPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDT_LIQUIDACION2SAPPLIEDFILTERS", AV196Gridsdt_liquidacion2sAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vACTIONGROUP2DATA", AV216ActionGroup2Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vACTIONGROUP2DATA", AV216ActionGroup2Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV14CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV25EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV25EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQNRO", GXutil.ltrim( localUtil.ntoc( AV9LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV59ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV223Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV223Pgmname, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV37GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV37GridState);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFDTIPOCONCOD_SELS", AV102TFDTipoConCod_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFDTIPOCONCOD_SELS", AV102TFDTipoConCod_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDCLASIFAUX", AV198TFLiqDClasifAux);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLIQDCLASIFAUX_SELS", AV199TFLiqDClasifAux_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLIQDCLASIFAUX_SELS", AV199TFLiqDClasifAux_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFDCONCODIGO", GXutil.rtrim( AV88TFDConCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFDCONCODIGO_SELS", AV89TFDConCodigo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFDCONCODIGO_SELS", AV89TFDConCodigo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFDCONDESCRIP", AV91TFDConDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFDCONDESCRIP_SELS", AV92TFDConDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFDCONDESCRIP_SELS", AV92TFDConDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDVALUNI", GXutil.ltrim( localUtil.ntoc( AV147TFLiqDValUni, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDVALUNI_TO", GXutil.ltrim( localUtil.ntoc( AV148TFLiqDValUni_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDIMPRECALCU", GXutil.ltrim( localUtil.ntoc( AV134TFLiqDImpReCalcu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDIMPRECALCU_TO", GXutil.ltrim( localUtil.ntoc( AV135TFLiqDImpReCalcu_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDERRORDESC", AV123TFLiqDErrorDesc);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLIQDERRORDESC_SELS", AV124TFLiqDErrorDesc_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLIQDERRORDESC_SELS", AV124TFLiqDErrorDesc_Sels);
      }
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vMODOTESTES", AV188modoTestEs);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODOTESTES", getSecureSignedToken( "", AV188modoTestEs));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQESTADO", GXutil.ltrim( localUtil.ntoc( AV54LiqEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQESTADO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV54LiqEstado), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV63OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV65OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vAUXMENUOPCCOD", AV207auxMenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV207auxMenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV5LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCLASIFAUX", AV179TFConClasifAux);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTFCONCLASIFAUX", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV179TFConClasifAux, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCLASIFAUX_SELS", AV180TFConClasifAux_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCLASIFAUX_SELS", AV180TFConClasifAux_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTFCONCLASIFAUX_SELS", getSecureSignedToken( "", AV180TFConClasifAux_Sels));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCONVARIABLE", AV18ConVariable);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVARIABLE", getSecureSignedToken( "", AV18ConVariable));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQNRO", GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNUMERO", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTOTLIQDIMPRECALCU", GXutil.ltrim( localUtil.ntoc( AV168TotLiqDImpReCalcu, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDIMPRECALCU", getSecureSignedToken( "", localUtil.format( AV168TotLiqDImpReCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTOTLIQDSEG", GXutil.ltrim( localUtil.ntoc( AV183TotLiqDSeg, (byte)(18), (byte)(3), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDSEG", getSecureSignedToken( "", localUtil.format( AV183TotLiqDSeg, "9.999")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTOTLIQDIMPCALCU", GXutil.ltrim( localUtil.ntoc( AV167TotLiqDImpCalcu, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDIMPCALCU", getSecureSignedToken( "", localUtil.format( AV167TotLiqDImpCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQDIMPCALCU", GXutil.ltrim( localUtil.ntoc( A275LiqDImpCalcu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDERRORDESC_SELSJSON", AV125TFLiqDErrorDesc_SelsJson);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INFOORIGINAL", AV42IsAuthorized_InfoOriginal);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INFOORIGINAL", getSecureSignedToken( "", AV42IsAuthorized_InfoOriginal));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQDFORORIG", A504LiqDForOrig);
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQFECIMP", localUtil.ttoc( AV211LiqFecImp, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQFECIMP", getSecureSignedToken( "", localUtil.format( AV211LiqFecImp, "99/99/99 99:99")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSISTEMAPALABRA", GXutil.rtrim( AV209sistemaPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSISTEMAPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV209sistemaPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFDTIPOCONCOD_SELSJSON", AV103TFDTipoConCod_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDCLASIFAUX_SELSJSON", AV197TFLiqDClasifAux_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFDCONCODIGO_SELSJSON", AV90TFDConCodigo_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFDCONDESCRIP_SELSJSON", AV93TFDConDescrip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV181CliCod_Selected, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV26EmpCod_Selected, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQNRO_SELECTED", GXutil.ltrim( localUtil.ntoc( AV57LiqNro_Selected, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO_SELECTED", GXutil.ltrim( localUtil.ntoc( AV49LegNumero_Selected, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vDCONCODIGO_SELECTED", GXutil.rtrim( AV20DConCodigo_Selected));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV190MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV190MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDT_LIQUIDACION2", AV192sdt_liquidacion2);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDT_LIQUIDACION2", AV192sdt_liquidacion2);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDT_LIQUIDACION2", getSecureSignedToken( "", AV192sdt_liquidacion2));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDT_LIQUIDACION2S_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdt_liquidacion2s_Rows, (byte)(6), (byte)(0), ".", "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Target", GXutil.rtrim( Innewwindow1_Target));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Class", GXutil.rtrim( Gridsdt_liquidacion2spaginationbar_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdt_liquidacion2spaginationbar_Showfirst));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdt_liquidacion2spaginationbar_Showprevious));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdt_liquidacion2spaginationbar_Shownext));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdt_liquidacion2spaginationbar_Showlast));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdt_liquidacion2spaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdt_liquidacion2spaginationbar_Pagingbuttonsposition));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdt_liquidacion2spaginationbar_Pagingcaptionposition));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdt_liquidacion2spaginationbar_Emptygridclass));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdt_liquidacion2spaginationbar_Rowsperpageselector));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdt_liquidacion2spaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdt_liquidacion2spaginationbar_Rowsperpageoptions));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdt_liquidacion2spaginationbar_Previous));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Next", GXutil.rtrim( Gridsdt_liquidacion2spaginationbar_Next));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdt_liquidacion2spaginationbar_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdt_liquidacion2spaginationbar_Emptygridcaption));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdt_liquidacion2spaginationbar_Rowsperpagecaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_ACTIONGROUP2_Icontype", GXutil.rtrim( Ddo_actiongroup2_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_ACTIONGROUP2_Icon", GXutil.rtrim( Ddo_actiongroup2_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_ACTIONGROUP2_Caption", GXutil.rtrim( Ddo_actiongroup2_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_ACTIONGROUP2_Cls", GXutil.rtrim( Ddo_actiongroup2_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_ACTIONGROUP2_Titlecontrolidtoreplace", GXutil.rtrim( Ddo_actiongroup2_Titlecontrolidtoreplace));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Title", GXutil.rtrim( Dvelop_confirmpanel_eliminardetalle_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_eliminardetalle_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminardetalle_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminardetalle_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminardetalle_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_eliminardetalle_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_eliminardetalle_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hascolumnsselector", GXutil.booltostr( Grid_empowerer_Hascolumnsselector));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdt_liquidacion2s_empowerer_Gridinternalname));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminardetalle_Result));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_ACTIONGROUP2_Activeeventkey", GXutil.rtrim( Ddo_actiongroup2_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdt_liquidacion2spaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdt_liquidacion2spaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminardetalle_Result));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_ACTIONGROUP2_Activeeventkey", GXutil.rtrim( Ddo_actiongroup2_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdt_liquidacion2spaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdt_liquidacion2spaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
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
         weH62( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtH62( ) ;
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
      return formatLink("web.liquidacionverdetalle2", new String[] {GXutil.URLEncode(GXutil.rtrim(AV207auxMenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV14CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV25EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LiqNro,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV5LegNumero,8,0))}, new String[] {"auxMenuOpcCod","CliCod","EmpCod","LiqNro","LegNumero"})  ;
   }

   public String getPgmname( )
   {
      return "LiquidacionVerDetalle2" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Conceptos de la Liquidación", "") ;
   }

   public void wbH60( )
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
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableparent_Internalname, divWelcomemessage_welcometableparent_Visible, 0, "px", 0, "px", "WelcomeTableParent", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableprincipal_Internalname, 1, 0, "px", 0, "px", "WelcomeHeaderItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tableclose_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e11h61_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_LiquidacionVerDetalle2.htm");
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
         AV201WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV201WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV224Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV201WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV201WelcomeMessage_Foto)==0) ? AV224Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV201WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV201WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_LiquidacionVerDetalle2.htm");
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
         wb_table1_24_H62( true) ;
      }
      else
      {
         wb_table1_24_H62( false) ;
      }
      return  ;
   }

   public void wb_table1_24_H62e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table2_29_H62( true) ;
      }
      else
      {
         wb_table2_29_H62( false) ;
      }
      return  ;
   }

   public void wb_table2_29_H62e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'" + sGXsfl_138_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV200WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,39);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionVerDetalle2.htm");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingBottom", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheadercontent_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, lblTextblocktitle_Caption, "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockColaborador", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "MB15 MT10", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavMostrar.getInternalname(), httpContext.getMessage( "Mostrar", ""), "gx-form-item AttributeLabel h40Label", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'" + sGXsfl_138_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavMostrar, cmbavMostrar.getInternalname(), GXutil.rtrim( AV62Mostrar), 1, cmbavMostrar.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavMostrar.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute h40", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,55);\"", "", true, (byte)(0), "HLP_LiquidacionVerDetalle2.htm");
         cmbavMostrar.setValue( GXutil.rtrim( AV62Mostrar) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Values", cmbavMostrar.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
         ClassString = "ColumnsSelector" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnactiongroup2_Internalname, "gx.evt.setGridEvt("+GXutil.str( 138, 3, 0)+","+"null"+");", httpContext.getMessage( "Recibo", ""), bttBtnactiongroup2_Jsonclick, 0, httpContext.getMessage( "Recibo", ""), "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_tablecontentbuttonimport_Internalname, 1, 0, "px", 0, "px", "TableContentButtonImport", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_table_svg_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_LiquidacionVerDetalle2.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* User Defined Control */
         ucButtonexport1_a3lexport.render(context, "a3lclonevent", Buttonexport1_a3lexport_Internalname, "BUTTONEXPORT1_A3LEXPORTContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("IconType", Ddo_gridcolumnsselector_Icontype);
         ucDdo_gridcolumnsselector.setProperty("Icon", Ddo_gridcolumnsselector_Icon);
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV21DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV15ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV58ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnreliquidar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 138, 3, 0)+","+"null"+");", httpContext.getMessage( "Re-Liquidar", ""), bttBtnreliquidar_Jsonclick, 5, httpContext.getMessage( "Re-Liquidar", ""), "", StyleString, ClassString, bttBtnreliquidar_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DORELIQUIDAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 138, 3, 0)+","+"null"+");", httpContext.getMessage( "WWP_ExportCaption", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_tablecontent_Internalname, divButtonfilter1_tablecontent_Visible, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilters1_filtros_Internalname, 1, 0, "px", 0, "px", "TableContentButtonImportFiltros", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilters1_table_svg_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilters1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilters1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilters1_table_texto_Internalname, 1, 0, "px", 0, "px", "ML10", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilters1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilters1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table3_93_H62( true) ;
      }
      else
      {
         wb_table3_93_H62( false) ;
      }
      return  ;
   }

   public void wb_table3_93_H62e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* User Defined Control */
         ucButtonfilter1_a3lfilter.render(context, "a3lfilter", Buttonfilter1_a3lfilter_Internalname, "BUTTONFILTER1_A3LFILTERContainer");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabletotales_Internalname, 1, 0, "px", 0, "px", "TableTotalesRecibo MB15", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableremu_Internalname, 1, 0, "px", 0, "px", "TableTotalReciboSeparador", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, httpContext.getMessage( "Remunerativos", ""), "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "LabelTotalesRecibo", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqlegimptotremu_Internalname, httpContext.getMessage( "Total remunerativos", ""), "gx-form-item AttributeLabel FS24Label fw500Label", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 111,'',false,'" + sGXsfl_138_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqlegimptotremu_Internalname, GXutil.ltrim( localUtil.ntoc( AV8LiqLegImpTotRemu, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavLiqlegimptotremu_Enabled!=0) ? localUtil.format( AV8LiqLegImpTotRemu, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV8LiqLegImpTotRemu, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,111);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqlegimptotremu_Jsonclick, 0, "Attribute FS24 fw500", "", "", "", "", 1, edtavLiqlegimptotremu_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablenoremu_Internalname, 1, 0, "px", 0, "px", "TableTotalReciboSeparador", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock2_Internalname, httpContext.getMessage( "No Remunerativos", ""), "", "", lblTextblock2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "LabelTotalesRecibo", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqlegimptotnoremu_Internalname, httpContext.getMessage( "Total no remunerativos", ""), "gx-form-item AttributeLabel FS24Label fw500Label", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'" + sGXsfl_138_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqlegimptotnoremu_Internalname, GXutil.ltrim( localUtil.ntoc( AV7LiqLegImpTotNoRemu, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavLiqlegimptotnoremu_Enabled!=0) ? localUtil.format( AV7LiqLegImpTotNoRemu, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV7LiqLegImpTotNoRemu, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,118);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqlegimptotnoremu_Jsonclick, 0, "Attribute FS24 fw500", "", "", "", "", 1, edtavLiqlegimptotnoremu_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabledesc_Internalname, 1, 0, "px", 0, "px", "TableTotalReciboSeparador", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock3_Internalname, httpContext.getMessage( "Descuentos", ""), "", "", lblTextblock3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "LabelTotalesRecibo", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqlegimptotdescu_Internalname, httpContext.getMessage( "Total descuentos", ""), "gx-form-item AttributeLabel FS24Label fw500Label", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 125,'',false,'" + sGXsfl_138_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqlegimptotdescu_Internalname, GXutil.ltrim( localUtil.ntoc( AV6LiqLegImpTotDescu, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavLiqlegimptotdescu_Enabled!=0) ? localUtil.format( AV6LiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV6LiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,125);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqlegimptotdescu_Jsonclick, 0, "Attribute FS24 fw500", "", "", "", "", 1, edtavLiqlegimptotdescu_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableneto_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock4_Internalname, httpContext.getMessage( "Neto", ""), "", "", lblTextblock4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "LabelTotalesRecibo", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqlegimptotal_Internalname, httpContext.getMessage( "Liq Leg Imp Total", ""), "gx-form-item AttributeLabel FS24Label fw500Label", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 132,'',false,'" + sGXsfl_138_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqlegimptotal_Internalname, GXutil.ltrim( localUtil.ntoc( AV55LiqLegImpTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavLiqlegimptotal_Enabled!=0) ? localUtil.format( AV55LiqLegImpTotal, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV55LiqLegImpTotal, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,132);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqlegimptotal_Jsonclick, 0, "Attribute FS24 fw500", "", "", "", "", 1, edtavLiqlegimptotal_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionVerDetalle2.htm");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol138( ) ;
      }
      if ( wbEnd == 138 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_138 = (int)(nGXsfl_138_idx-1) ;
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row Invisible", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table4_158_H62( true) ;
      }
      else
      {
         wb_table4_158_H62( false) ;
      }
      return  ;
   }

   public void wb_table4_158_H62e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         ucGridpaginationbar.setProperty("CurrentPage", AV35GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV36GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV34GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table5_187_H62( true) ;
      }
      else
      {
         wb_table5_187_H62( false) ;
      }
      return  ;
   }

   public void wb_table5_187_H62e( boolean wbgen )
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
         ucDdo_actiongroup2.setProperty("IconType", Ddo_actiongroup2_Icontype);
         ucDdo_actiongroup2.setProperty("Icon", Ddo_actiongroup2_Icon);
         ucDdo_actiongroup2.setProperty("Caption", Ddo_actiongroup2_Caption);
         ucDdo_actiongroup2.setProperty("Cls", Ddo_actiongroup2_Cls);
         ucDdo_actiongroup2.setProperty("DropDownOptionsData", AV216ActionGroup2Data);
         ucDdo_actiongroup2.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_actiongroup2_Internalname, "DDO_ACTIONGROUP2Container");
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV21DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         wb_table6_209_H62( true) ;
      }
      else
      {
         wb_table6_209_H62( false) ;
      }
      return  ;
   }

   public void wb_table6_209_H62e( boolean wbgen )
   {
      if ( wbgen )
      {
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* User Defined Control */
         ucGridsdt_liquidacion2s_empowerer.render(context, "wwp.gridempowerer", Gridsdt_liquidacion2s_empowerer_Internalname, "GRIDSDT_LIQUIDACION2S_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 138 )
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
      if ( wbEnd == 197 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Gridsdt_liquidacion2sContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV220GXV1 = nGXsfl_197_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Gridsdt_liquidacion2sContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridsdt_liquidacion2s", Gridsdt_liquidacion2sContainer, subGridsdt_liquidacion2s_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridsdt_liquidacion2sContainerData", Gridsdt_liquidacion2sContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridsdt_liquidacion2sContainerData"+"V", Gridsdt_liquidacion2sContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridsdt_liquidacion2sContainerData"+"V"+"\" value='"+Gridsdt_liquidacion2sContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startH62( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Conceptos de la Liquidación", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupH60( ) ;
   }

   public void wsH62( )
   {
      startH62( ) ;
      evtH62( ) ;
   }

   public void evtH62( )
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
                           e12H62 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13H62 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14H62 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15H62 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e16H62 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDT_LIQUIDACION2SPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17H62 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_ACTIONGROUP2.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18H62 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e19H62 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_ELIMINARDETALLE.CLOSE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e20H62 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DORELIQUIDAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoReLiquidar' */
                           e21H62 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e22H62 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e23H62 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "GRID.REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_138_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_138_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_138_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1382( ) ;
                           AV24EliminarDetalle = httpContext.cgiGet( edtavEliminardetalle_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminardetalle_Internalname, AV24EliminarDetalle);
                           cmbDTipoConCod.setName( cmbDTipoConCod.getInternalname() );
                           cmbDTipoConCod.setValue( httpContext.cgiGet( cmbDTipoConCod.getInternalname()) );
                           A464DTipoConCod = httpContext.cgiGet( cmbDTipoConCod.getInternalname()) ;
                           A2149LiqDClasifAux = httpContext.cgiGet( edtLiqDClasifAux_Internalname) ;
                           A394DConCodigo = httpContext.cgiGet( edtDConCodigo_Internalname) ;
                           A393DConDescrip = httpContext.cgiGet( edtDConDescrip_Internalname) ;
                           A277LiqDValUni = localUtil.ctond( httpContext.cgiGet( edtLiqDValUni_Internalname)) ;
                           n277LiqDValUni = false ;
                           A269LiqDCanti = localUtil.ctond( httpContext.cgiGet( edtLiqDCanti_Internalname)) ;
                           n269LiqDCanti = false ;
                           A276LiqDImporte = localUtil.ctond( httpContext.cgiGet( edtLiqDImporte_Internalname)) ;
                           n276LiqDImporte = false ;
                           A764LiqDImpReCalcu = localUtil.ctond( httpContext.cgiGet( edtLiqDImpReCalcu_Internalname)) ;
                           A876LiqDReFormulaHTML = httpContext.cgiGet( edtLiqDReFormulaHTML_Internalname) ;
                           n876LiqDReFormulaHTML = false ;
                           A270LiqDErrorDesc = httpContext.cgiGet( edtLiqDErrorDesc_Internalname) ;
                           n270LiqDErrorDesc = false ;
                           cmbLiqDMostrar.setName( cmbLiqDMostrar.getInternalname() );
                           cmbLiqDMostrar.setValue( httpContext.cgiGet( cmbLiqDMostrar.getInternalname()) );
                           A502LiqDMostrar = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqDMostrar.getInternalname()))) ;
                           A471DConOrden = (int)(localUtil.ctol( httpContext.cgiGet( edtDConOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A81LiqDSecuencial = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqDSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1072LiqDLogRecal = httpContext.cgiGet( edtLiqDLogRecal_Internalname) ;
                           A1469LiqDSeg = localUtil.ctond( httpContext.cgiGet( edtLiqDSeg_Internalname)) ;
                           AV40InfoOriginal = httpContext.cgiGet( edtavInfooriginal_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavInfooriginal_Internalname, "Bitmap", ((GXutil.strcmp("", AV40InfoOriginal)==0) ? AV239Infooriginal_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV40InfoOriginal))), !bGXsfl_138_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavInfooriginal_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV40InfoOriginal), true);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e24H62 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e25H62 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e26H62 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e27H62 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Mostrar Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vMOSTRAR"), AV62Mostrar) != 0 )
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
                        else if ( ( GXutil.strcmp(GXutil.left( sEvt, 26), "GRIDSDT_LIQUIDACION2S.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "VVERSVG.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "VVERSVG.CLICK") == 0 ) )
                        {
                           nGXsfl_197_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_197_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_197_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1973( ) ;
                           AV220GXV1 = (int)(nGXsfl_197_idx+GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage) ;
                           if ( ( AV192sdt_liquidacion2.size() >= AV220GXV1 ) && ( AV220GXV1 > 0 ) )
                           {
                              AV192sdt_liquidacion2.currentItem( ((web.Sdtsdt_liquidacion2_sdt_liquidacion2Item)AV192sdt_liquidacion2.elementAt(-1+AV220GXV1)) );
                              AV193VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV193VerSVG);
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDSDT_LIQUIDACION2S.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e28H63 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VVERSVG.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e29H62 ();
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

   public void weH62( )
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

   public void paH62( )
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
      subsflControlProps_1382( ) ;
      while ( nGXsfl_138_idx <= nRC_GXsfl_138 )
      {
         sendrow_1382( ) ;
         nGXsfl_138_idx = ((subGrid_Islastpage==1)&&(nGXsfl_138_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_138_idx+1) ;
         sGXsfl_138_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_138_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1382( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxnrgridsdt_liquidacion2s_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1973( ) ;
      while ( nGXsfl_197_idx <= nRC_GXsfl_197 )
      {
         sendrow_1973( ) ;
         nGXsfl_197_idx = ((subGridsdt_liquidacion2s_Islastpage==1)&&(nGXsfl_197_idx+1>subgridsdt_liquidacion2s_fnc_recordsperpage( )) ? 1 : nGXsfl_197_idx+1) ;
         sGXsfl_197_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_197_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1973( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridsdt_liquidacion2sContainer)) ;
      /* End function gxnrGridsdt_liquidacion2s_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 int subGridsdt_liquidacion2s_Rows ,
                                 String AV62Mostrar ,
                                 int AV14CliCod ,
                                 short AV25EmpCod ,
                                 int AV9LiqNro ,
                                 int AV5LegNumero ,
                                 byte AV59ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV15ColumnsSelector ,
                                 String AV223Pgmname ,
                                 web.wwpbaseobjects.SdtWWPGridState AV37GridState ,
                                 GXSimpleCollection<String> AV102TFDTipoConCod_Sels ,
                                 String AV198TFLiqDClasifAux ,
                                 GXSimpleCollection<String> AV199TFLiqDClasifAux_Sels ,
                                 String AV88TFDConCodigo ,
                                 GXSimpleCollection<String> AV89TFDConCodigo_Sels ,
                                 String AV91TFDConDescrip ,
                                 GXSimpleCollection<String> AV92TFDConDescrip_Sels ,
                                 java.math.BigDecimal AV147TFLiqDValUni ,
                                 java.math.BigDecimal AV148TFLiqDValUni_To ,
                                 java.math.BigDecimal AV134TFLiqDImpReCalcu ,
                                 java.math.BigDecimal AV135TFLiqDImpReCalcu_To ,
                                 String AV123TFLiqDErrorDesc ,
                                 GXSimpleCollection<String> AV124TFLiqDErrorDesc_Sels ,
                                 boolean AV188modoTestEs ,
                                 byte AV54LiqEstado ,
                                 short AV63OrderedBy ,
                                 boolean AV65OrderedDsc ,
                                 String AV207auxMenuOpcCod ,
                                 String AV179TFConClasifAux ,
                                 GXSimpleCollection<String> AV180TFConClasifAux_Sels ,
                                 boolean AV18ConVariable ,
                                 java.math.BigDecimal AV168TotLiqDImpReCalcu ,
                                 java.math.BigDecimal AV183TotLiqDSeg ,
                                 java.math.BigDecimal AV167TotLiqDImpCalcu ,
                                 boolean AV42IsAuthorized_InfoOriginal ,
                                 java.util.Date AV211LiqFecImp ,
                                 String AV209sistemaPalabra ,
                                 boolean AV200WelcomeMessage_NoMostrarMas ,
                                 GXBaseCollection<web.Sdtsdt_liquidacion2_sdt_liquidacion2Item> AV192sdt_liquidacion2 ,
                                 String AV190MenuOpcCod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e25H62 ();
      GRID_nCurrentRecord = 0 ;
      rfH62( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void gxgrgridsdt_liquidacion2s_refresh( int subGrid_Rows ,
                                                  int subGridsdt_liquidacion2s_Rows ,
                                                  String AV62Mostrar ,
                                                  int AV14CliCod ,
                                                  short AV25EmpCod ,
                                                  int AV9LiqNro ,
                                                  byte AV59ManageFiltersExecutionStep ,
                                                  web.wwpbaseobjects.SdtWWPColumnsSelector AV15ColumnsSelector ,
                                                  String AV223Pgmname ,
                                                  web.wwpbaseobjects.SdtWWPGridState AV37GridState ,
                                                  GXSimpleCollection<String> AV102TFDTipoConCod_Sels ,
                                                  String AV198TFLiqDClasifAux ,
                                                  GXSimpleCollection<String> AV199TFLiqDClasifAux_Sels ,
                                                  String AV88TFDConCodigo ,
                                                  GXSimpleCollection<String> AV89TFDConCodigo_Sels ,
                                                  String AV91TFDConDescrip ,
                                                  GXSimpleCollection<String> AV92TFDConDescrip_Sels ,
                                                  java.math.BigDecimal AV147TFLiqDValUni ,
                                                  java.math.BigDecimal AV148TFLiqDValUni_To ,
                                                  java.math.BigDecimal AV134TFLiqDImpReCalcu ,
                                                  java.math.BigDecimal AV135TFLiqDImpReCalcu_To ,
                                                  String AV123TFLiqDErrorDesc ,
                                                  GXSimpleCollection<String> AV124TFLiqDErrorDesc_Sels ,
                                                  boolean AV188modoTestEs ,
                                                  byte AV54LiqEstado ,
                                                  short AV63OrderedBy ,
                                                  boolean AV65OrderedDsc ,
                                                  String AV207auxMenuOpcCod ,
                                                  int AV5LegNumero ,
                                                  String AV179TFConClasifAux ,
                                                  GXSimpleCollection<String> AV180TFConClasifAux_Sels ,
                                                  boolean AV18ConVariable ,
                                                  short A1EmpCod ,
                                                  int A31LiqNro ,
                                                  int A6LegNumero ,
                                                  int A3CliCod ,
                                                  java.math.BigDecimal A764LiqDImpReCalcu ,
                                                  java.math.BigDecimal AV168TotLiqDImpReCalcu ,
                                                  java.math.BigDecimal A1469LiqDSeg ,
                                                  java.math.BigDecimal AV183TotLiqDSeg ,
                                                  String A464DTipoConCod ,
                                                  java.math.BigDecimal AV167TotLiqDImpCalcu ,
                                                  java.math.BigDecimal A275LiqDImpCalcu ,
                                                  boolean AV200WelcomeMessage_NoMostrarMas ,
                                                  GXBaseCollection<web.Sdtsdt_liquidacion2_sdt_liquidacion2Item> AV192sdt_liquidacion2 ,
                                                  boolean AV42IsAuthorized_InfoOriginal ,
                                                  java.util.Date AV211LiqFecImp ,
                                                  String AV209sistemaPalabra ,
                                                  String AV190MenuOpcCod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e25H62 ();
      GRIDSDT_LIQUIDACION2S_nCurrentRecord = 0 ;
      rfH63( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsdt_liquidacion2s_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_LIQDSECUENCIAL", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A81LiqDSecuencial), "ZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQDSECUENCIAL", GXutil.ltrim( localUtil.ntoc( A81LiqDSecuencial, (byte)(5), (byte)(0), ".", "")));
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
      AV200WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV200WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV200WelcomeMessage_NoMostrarMas", AV200WelcomeMessage_NoMostrarMas);
      if ( cmbavMostrar.getItemCount() > 0 )
      {
         AV62Mostrar = cmbavMostrar.getValidValue(AV62Mostrar) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV62Mostrar", AV62Mostrar);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavMostrar.setValue( GXutil.rtrim( AV62Mostrar) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Values", cmbavMostrar.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      /* Execute user event: Refresh */
      e25H62 ();
      rfH62( ) ;
      rfH63( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV223Pgmname = "LiquidacionVerDetalle2" ;
      Gx_err = (short)(0) ;
      edtavLiqlegimptotremu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqlegimptotremu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotremu_Enabled), 5, 0), true);
      edtavLiqlegimptotnoremu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqlegimptotnoremu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotnoremu_Enabled), 5, 0), true);
      edtavLiqlegimptotdescu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqlegimptotdescu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotdescu_Enabled), 5, 0), true);
      edtavLiqlegimptotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqlegimptotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotal_Enabled), 5, 0), true);
      edtavEliminardetalle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminardetalle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminardetalle_Enabled), 5, 0), !bGXsfl_138_Refreshing);
      edtavTotvalueliqdimprecalcu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTotvalueliqdimprecalcu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueliqdimprecalcu_Enabled), 5, 0), true);
      edtavSdt_liquidacion2__liqnro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdt_liquidacion2__liqnro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_liquidacion2__liqnro_Enabled), 5, 0), !bGXsfl_197_Refreshing);
      edtavSdt_liquidacion2__liqnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdt_liquidacion2__liqnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_liquidacion2__liqnombre_Enabled), 5, 0), !bGXsfl_197_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_197_Refreshing);
   }

   public void rfH62( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(138) ;
      e27H62 ();
      nGXsfl_138_idx = 1 ;
      sGXsfl_138_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_138_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1382( ) ;
      bGXsfl_138_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithTotalizer GridWithPaginationBar WorkWith");
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
         subsflControlProps_1382( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A464DTipoConCod ,
                                              AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                              A2149LiqDClasifAux ,
                                              AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                              A394DConCodigo ,
                                              AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                              A393DConDescrip ,
                                              AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                              A270LiqDErrorDesc ,
                                              AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                              AV225Liquidacionverdetalle2ds_1_mostrar ,
                                              Integer.valueOf(AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels.size()) ,
                                              Integer.valueOf(AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels.size()) ,
                                              AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                              Integer.valueOf(AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels.size()) ,
                                              AV229Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                              Integer.valueOf(AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels.size()) ,
                                              AV231Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                              AV233Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                              AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                              AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                              AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                              Integer.valueOf(AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels.size()) ,
                                              AV237Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                              Byte.valueOf(A502LiqDMostrar) ,
                                              A277LiqDValUni ,
                                              A764LiqDImpReCalcu ,
                                              Short.valueOf(AV63OrderedBy) ,
                                              Boolean.valueOf(AV65OrderedDsc) ,
                                              Integer.valueOf(AV14CliCod) ,
                                              Short.valueOf(AV25EmpCod) ,
                                              Integer.valueOf(AV9LiqNro) ,
                                              Integer.valueOf(AV5LegNumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A31LiqNro) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = GXutil.concat( GXutil.rtrim( AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux), "%", "") ;
         lV229Liquidacionverdetalle2ds_5_tfdconcodigo = GXutil.padr( GXutil.rtrim( AV229Liquidacionverdetalle2ds_5_tfdconcodigo), 10, "%") ;
         lV231Liquidacionverdetalle2ds_7_tfdcondescrip = GXutil.concat( GXutil.rtrim( AV231Liquidacionverdetalle2ds_7_tfdcondescrip), "%", "") ;
         lV237Liquidacionverdetalle2ds_13_tfliqderrordesc = GXutil.concat( GXutil.rtrim( AV237Liquidacionverdetalle2ds_13_tfliqderrordesc), "%", "") ;
         /* Using cursor H00H62 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV5LegNumero), lV227Liquidacionverdetalle2ds_3_tfliqdclasifaux, lV229Liquidacionverdetalle2ds_5_tfdconcodigo, lV231Liquidacionverdetalle2ds_7_tfdcondescrip, AV233Liquidacionverdetalle2ds_9_tfliqdvaluni, AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to, AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu, AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to, lV237Liquidacionverdetalle2ds_13_tfliqderrordesc, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_138_idx = 1 ;
         sGXsfl_138_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_138_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1382( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1134LiqDOrdVis = H00H62_A1134LiqDOrdVis[0] ;
            A275LiqDImpCalcu = H00H62_A275LiqDImpCalcu[0] ;
            n275LiqDImpCalcu = H00H62_n275LiqDImpCalcu[0] ;
            A504LiqDForOrig = H00H62_A504LiqDForOrig[0] ;
            A1469LiqDSeg = H00H62_A1469LiqDSeg[0] ;
            A1072LiqDLogRecal = H00H62_A1072LiqDLogRecal[0] ;
            A81LiqDSecuencial = H00H62_A81LiqDSecuencial[0] ;
            A471DConOrden = H00H62_A471DConOrden[0] ;
            A502LiqDMostrar = H00H62_A502LiqDMostrar[0] ;
            A270LiqDErrorDesc = H00H62_A270LiqDErrorDesc[0] ;
            n270LiqDErrorDesc = H00H62_n270LiqDErrorDesc[0] ;
            A876LiqDReFormulaHTML = H00H62_A876LiqDReFormulaHTML[0] ;
            n876LiqDReFormulaHTML = H00H62_n876LiqDReFormulaHTML[0] ;
            A764LiqDImpReCalcu = H00H62_A764LiqDImpReCalcu[0] ;
            A276LiqDImporte = H00H62_A276LiqDImporte[0] ;
            n276LiqDImporte = H00H62_n276LiqDImporte[0] ;
            A269LiqDCanti = H00H62_A269LiqDCanti[0] ;
            n269LiqDCanti = H00H62_n269LiqDCanti[0] ;
            A277LiqDValUni = H00H62_A277LiqDValUni[0] ;
            n277LiqDValUni = H00H62_n277LiqDValUni[0] ;
            A393DConDescrip = H00H62_A393DConDescrip[0] ;
            A394DConCodigo = H00H62_A394DConCodigo[0] ;
            A2149LiqDClasifAux = H00H62_A2149LiqDClasifAux[0] ;
            A464DTipoConCod = H00H62_A464DTipoConCod[0] ;
            A3CliCod = H00H62_A3CliCod[0] ;
            A1EmpCod = H00H62_A1EmpCod[0] ;
            A31LiqNro = H00H62_A31LiqNro[0] ;
            A6LegNumero = H00H62_A6LegNumero[0] ;
            e26H62 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(138) ;
         wbH60( ) ;
      }
      bGXsfl_138_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesH62( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV14CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV25EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV25EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQNRO", GXutil.ltrim( localUtil.ntoc( AV9LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV223Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV223Pgmname, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vMODOTESTES", AV188modoTestEs);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODOTESTES", getSecureSignedToken( "", AV188modoTestEs));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQESTADO", GXutil.ltrim( localUtil.ntoc( AV54LiqEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQESTADO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV54LiqEstado), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV5LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCLASIFAUX", AV179TFConClasifAux);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTFCONCLASIFAUX", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV179TFConClasifAux, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCLASIFAUX_SELS", AV180TFConClasifAux_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCLASIFAUX_SELS", AV180TFConClasifAux_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTFCONCLASIFAUX_SELS", getSecureSignedToken( "", AV180TFConClasifAux_Sels));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCONVARIABLE", AV18ConVariable);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVARIABLE", getSecureSignedToken( "", AV18ConVariable));
      web.GxWebStd.gx_hidden_field( httpContext, "vTOTLIQDIMPRECALCU", GXutil.ltrim( localUtil.ntoc( AV168TotLiqDImpReCalcu, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDIMPRECALCU", getSecureSignedToken( "", localUtil.format( AV168TotLiqDImpReCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTOTLIQDSEG", GXutil.ltrim( localUtil.ntoc( AV183TotLiqDSeg, (byte)(18), (byte)(3), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDSEG", getSecureSignedToken( "", localUtil.format( AV183TotLiqDSeg, "9.999")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTOTLIQDIMPCALCU", GXutil.ltrim( localUtil.ntoc( AV167TotLiqDImpCalcu, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDIMPCALCU", getSecureSignedToken( "", localUtil.format( AV167TotLiqDImpCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INFOORIGINAL", AV42IsAuthorized_InfoOriginal);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INFOORIGINAL", getSecureSignedToken( "", AV42IsAuthorized_InfoOriginal));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQFECIMP", localUtil.ttoc( AV211LiqFecImp, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQFECIMP", getSecureSignedToken( "", localUtil.format( AV211LiqFecImp, "99/99/99 99:99")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSISTEMAPALABRA", GXutil.rtrim( AV209sistemaPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSISTEMAPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV209sistemaPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_LIQDSECUENCIAL"+"_"+sGXsfl_138_idx, getSecureSignedToken( sGXsfl_138_idx, localUtil.format( DecimalUtil.doubleToDec(A81LiqDSecuencial), "ZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV190MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV190MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDT_LIQUIDACION2", AV192sdt_liquidacion2);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDT_LIQUIDACION2", AV192sdt_liquidacion2);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDT_LIQUIDACION2", getSecureSignedToken( "", AV192sdt_liquidacion2));
   }

   public void rfH63( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Gridsdt_liquidacion2sContainer.ClearRows();
      }
      wbStart = (short)(197) ;
      nGXsfl_197_idx = 1 ;
      sGXsfl_197_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_197_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1973( ) ;
      bGXsfl_197_Refreshing = true ;
      Gridsdt_liquidacion2sContainer.AddObjectProperty("GridName", "Gridsdt_liquidacion2s");
      Gridsdt_liquidacion2sContainer.AddObjectProperty("CmpContext", "");
      Gridsdt_liquidacion2sContainer.AddObjectProperty("InMasterPage", "false");
      Gridsdt_liquidacion2sContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      Gridsdt_liquidacion2sContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridsdt_liquidacion2sContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridsdt_liquidacion2sContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdt_liquidacion2s_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridsdt_liquidacion2sContainer.setPageSize( subgridsdt_liquidacion2s_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1973( ) ;
         e28H63 ();
         if ( ( GRIDSDT_LIQUIDACION2S_nCurrentRecord > 0 ) && ( GRIDSDT_LIQUIDACION2S_nGridOutOfScope == 0 ) && ( nGXsfl_197_idx == 1 ) )
         {
            GRIDSDT_LIQUIDACION2S_nCurrentRecord = 0 ;
            GRIDSDT_LIQUIDACION2S_nGridOutOfScope = 1 ;
            subgridsdt_liquidacion2s_firstpage( ) ;
            e28H63 ();
         }
         wbEnd = (short)(197) ;
         wbH60( ) ;
      }
      bGXsfl_197_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesH63( )
   {
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
      AV225Liquidacionverdetalle2ds_1_mostrar = AV62Mostrar ;
      AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV102TFDTipoConCod_Sels ;
      AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV198TFLiqDClasifAux ;
      AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV199TFLiqDClasifAux_Sels ;
      AV229Liquidacionverdetalle2ds_5_tfdconcodigo = AV88TFDConCodigo ;
      AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV89TFDConCodigo_Sels ;
      AV231Liquidacionverdetalle2ds_7_tfdcondescrip = AV91TFDConDescrip ;
      AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV92TFDConDescrip_Sels ;
      AV233Liquidacionverdetalle2ds_9_tfliqdvaluni = AV147TFLiqDValUni ;
      AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV148TFLiqDValUni_To ;
      AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV134TFLiqDImpReCalcu ;
      AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV135TFLiqDImpReCalcu_To ;
      AV237Liquidacionverdetalle2ds_13_tfliqderrordesc = AV123TFLiqDErrorDesc ;
      AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV124TFLiqDErrorDesc_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A464DTipoConCod ,
                                           AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                           A2149LiqDClasifAux ,
                                           AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                           A394DConCodigo ,
                                           AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                           A393DConDescrip ,
                                           AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                           A270LiqDErrorDesc ,
                                           AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                           AV225Liquidacionverdetalle2ds_1_mostrar ,
                                           Integer.valueOf(AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels.size()) ,
                                           Integer.valueOf(AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels.size()) ,
                                           AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                           Integer.valueOf(AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels.size()) ,
                                           AV229Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                           Integer.valueOf(AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels.size()) ,
                                           AV231Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                           AV233Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                           AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                           AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                           AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                           Integer.valueOf(AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels.size()) ,
                                           AV237Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                           Byte.valueOf(A502LiqDMostrar) ,
                                           A277LiqDValUni ,
                                           A764LiqDImpReCalcu ,
                                           Short.valueOf(AV63OrderedBy) ,
                                           Boolean.valueOf(AV65OrderedDsc) ,
                                           Integer.valueOf(AV14CliCod) ,
                                           Short.valueOf(AV25EmpCod) ,
                                           Integer.valueOf(AV9LiqNro) ,
                                           Integer.valueOf(AV5LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = GXutil.concat( GXutil.rtrim( AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux), "%", "") ;
      lV229Liquidacionverdetalle2ds_5_tfdconcodigo = GXutil.padr( GXutil.rtrim( AV229Liquidacionverdetalle2ds_5_tfdconcodigo), 10, "%") ;
      lV231Liquidacionverdetalle2ds_7_tfdcondescrip = GXutil.concat( GXutil.rtrim( AV231Liquidacionverdetalle2ds_7_tfdcondescrip), "%", "") ;
      lV237Liquidacionverdetalle2ds_13_tfliqderrordesc = GXutil.concat( GXutil.rtrim( AV237Liquidacionverdetalle2ds_13_tfliqderrordesc), "%", "") ;
      /* Using cursor H00H63 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV5LegNumero), lV227Liquidacionverdetalle2ds_3_tfliqdclasifaux, lV229Liquidacionverdetalle2ds_5_tfdconcodigo, lV231Liquidacionverdetalle2ds_7_tfdcondescrip, AV233Liquidacionverdetalle2ds_9_tfliqdvaluni, AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to, AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu, AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to, lV237Liquidacionverdetalle2ds_13_tfliqderrordesc});
      GRID_nRecordCount = H00H63_AGRID_nRecordCount[0] ;
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
      AV225Liquidacionverdetalle2ds_1_mostrar = AV62Mostrar ;
      AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV102TFDTipoConCod_Sels ;
      AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV198TFLiqDClasifAux ;
      AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV199TFLiqDClasifAux_Sels ;
      AV229Liquidacionverdetalle2ds_5_tfdconcodigo = AV88TFDConCodigo ;
      AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV89TFDConCodigo_Sels ;
      AV231Liquidacionverdetalle2ds_7_tfdcondescrip = AV91TFDConDescrip ;
      AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV92TFDConDescrip_Sels ;
      AV233Liquidacionverdetalle2ds_9_tfliqdvaluni = AV147TFLiqDValUni ;
      AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV148TFLiqDValUni_To ;
      AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV134TFLiqDImpReCalcu ;
      AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV135TFLiqDImpReCalcu_To ;
      AV237Liquidacionverdetalle2ds_13_tfliqderrordesc = AV123TFLiqDErrorDesc ;
      AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV124TFLiqDErrorDesc_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, subGridsdt_liquidacion2s_Rows, AV62Mostrar, AV14CliCod, AV25EmpCod, AV9LiqNro, AV5LegNumero, AV59ManageFiltersExecutionStep, AV15ColumnsSelector, AV223Pgmname, AV37GridState, AV102TFDTipoConCod_Sels, AV198TFLiqDClasifAux, AV199TFLiqDClasifAux_Sels, AV88TFDConCodigo, AV89TFDConCodigo_Sels, AV91TFDConDescrip, AV92TFDConDescrip_Sels, AV147TFLiqDValUni, AV148TFLiqDValUni_To, AV134TFLiqDImpReCalcu, AV135TFLiqDImpReCalcu_To, AV123TFLiqDErrorDesc, AV124TFLiqDErrorDesc_Sels, AV188modoTestEs, AV54LiqEstado, AV63OrderedBy, AV65OrderedDsc, AV207auxMenuOpcCod, AV179TFConClasifAux, AV180TFConClasifAux_Sels, AV18ConVariable, AV168TotLiqDImpReCalcu, AV183TotLiqDSeg, AV167TotLiqDImpCalcu, AV42IsAuthorized_InfoOriginal, AV211LiqFecImp, AV209sistemaPalabra, AV200WelcomeMessage_NoMostrarMas, AV192sdt_liquidacion2, AV190MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV225Liquidacionverdetalle2ds_1_mostrar = AV62Mostrar ;
      AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV102TFDTipoConCod_Sels ;
      AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV198TFLiqDClasifAux ;
      AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV199TFLiqDClasifAux_Sels ;
      AV229Liquidacionverdetalle2ds_5_tfdconcodigo = AV88TFDConCodigo ;
      AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV89TFDConCodigo_Sels ;
      AV231Liquidacionverdetalle2ds_7_tfdcondescrip = AV91TFDConDescrip ;
      AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV92TFDConDescrip_Sels ;
      AV233Liquidacionverdetalle2ds_9_tfliqdvaluni = AV147TFLiqDValUni ;
      AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV148TFLiqDValUni_To ;
      AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV134TFLiqDImpReCalcu ;
      AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV135TFLiqDImpReCalcu_To ;
      AV237Liquidacionverdetalle2ds_13_tfliqderrordesc = AV123TFLiqDErrorDesc ;
      AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV124TFLiqDErrorDesc_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, subGridsdt_liquidacion2s_Rows, AV62Mostrar, AV14CliCod, AV25EmpCod, AV9LiqNro, AV5LegNumero, AV59ManageFiltersExecutionStep, AV15ColumnsSelector, AV223Pgmname, AV37GridState, AV102TFDTipoConCod_Sels, AV198TFLiqDClasifAux, AV199TFLiqDClasifAux_Sels, AV88TFDConCodigo, AV89TFDConCodigo_Sels, AV91TFDConDescrip, AV92TFDConDescrip_Sels, AV147TFLiqDValUni, AV148TFLiqDValUni_To, AV134TFLiqDImpReCalcu, AV135TFLiqDImpReCalcu_To, AV123TFLiqDErrorDesc, AV124TFLiqDErrorDesc_Sels, AV188modoTestEs, AV54LiqEstado, AV63OrderedBy, AV65OrderedDsc, AV207auxMenuOpcCod, AV179TFConClasifAux, AV180TFConClasifAux_Sels, AV18ConVariable, AV168TotLiqDImpReCalcu, AV183TotLiqDSeg, AV167TotLiqDImpCalcu, AV42IsAuthorized_InfoOriginal, AV211LiqFecImp, AV209sistemaPalabra, AV200WelcomeMessage_NoMostrarMas, AV192sdt_liquidacion2, AV190MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV225Liquidacionverdetalle2ds_1_mostrar = AV62Mostrar ;
      AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV102TFDTipoConCod_Sels ;
      AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV198TFLiqDClasifAux ;
      AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV199TFLiqDClasifAux_Sels ;
      AV229Liquidacionverdetalle2ds_5_tfdconcodigo = AV88TFDConCodigo ;
      AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV89TFDConCodigo_Sels ;
      AV231Liquidacionverdetalle2ds_7_tfdcondescrip = AV91TFDConDescrip ;
      AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV92TFDConDescrip_Sels ;
      AV233Liquidacionverdetalle2ds_9_tfliqdvaluni = AV147TFLiqDValUni ;
      AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV148TFLiqDValUni_To ;
      AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV134TFLiqDImpReCalcu ;
      AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV135TFLiqDImpReCalcu_To ;
      AV237Liquidacionverdetalle2ds_13_tfliqderrordesc = AV123TFLiqDErrorDesc ;
      AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV124TFLiqDErrorDesc_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, subGridsdt_liquidacion2s_Rows, AV62Mostrar, AV14CliCod, AV25EmpCod, AV9LiqNro, AV5LegNumero, AV59ManageFiltersExecutionStep, AV15ColumnsSelector, AV223Pgmname, AV37GridState, AV102TFDTipoConCod_Sels, AV198TFLiqDClasifAux, AV199TFLiqDClasifAux_Sels, AV88TFDConCodigo, AV89TFDConCodigo_Sels, AV91TFDConDescrip, AV92TFDConDescrip_Sels, AV147TFLiqDValUni, AV148TFLiqDValUni_To, AV134TFLiqDImpReCalcu, AV135TFLiqDImpReCalcu_To, AV123TFLiqDErrorDesc, AV124TFLiqDErrorDesc_Sels, AV188modoTestEs, AV54LiqEstado, AV63OrderedBy, AV65OrderedDsc, AV207auxMenuOpcCod, AV179TFConClasifAux, AV180TFConClasifAux_Sels, AV18ConVariable, AV168TotLiqDImpReCalcu, AV183TotLiqDSeg, AV167TotLiqDImpCalcu, AV42IsAuthorized_InfoOriginal, AV211LiqFecImp, AV209sistemaPalabra, AV200WelcomeMessage_NoMostrarMas, AV192sdt_liquidacion2, AV190MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV225Liquidacionverdetalle2ds_1_mostrar = AV62Mostrar ;
      AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV102TFDTipoConCod_Sels ;
      AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV198TFLiqDClasifAux ;
      AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV199TFLiqDClasifAux_Sels ;
      AV229Liquidacionverdetalle2ds_5_tfdconcodigo = AV88TFDConCodigo ;
      AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV89TFDConCodigo_Sels ;
      AV231Liquidacionverdetalle2ds_7_tfdcondescrip = AV91TFDConDescrip ;
      AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV92TFDConDescrip_Sels ;
      AV233Liquidacionverdetalle2ds_9_tfliqdvaluni = AV147TFLiqDValUni ;
      AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV148TFLiqDValUni_To ;
      AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV134TFLiqDImpReCalcu ;
      AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV135TFLiqDImpReCalcu_To ;
      AV237Liquidacionverdetalle2ds_13_tfliqderrordesc = AV123TFLiqDErrorDesc ;
      AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV124TFLiqDErrorDesc_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, subGridsdt_liquidacion2s_Rows, AV62Mostrar, AV14CliCod, AV25EmpCod, AV9LiqNro, AV5LegNumero, AV59ManageFiltersExecutionStep, AV15ColumnsSelector, AV223Pgmname, AV37GridState, AV102TFDTipoConCod_Sels, AV198TFLiqDClasifAux, AV199TFLiqDClasifAux_Sels, AV88TFDConCodigo, AV89TFDConCodigo_Sels, AV91TFDConDescrip, AV92TFDConDescrip_Sels, AV147TFLiqDValUni, AV148TFLiqDValUni_To, AV134TFLiqDImpReCalcu, AV135TFLiqDImpReCalcu_To, AV123TFLiqDErrorDesc, AV124TFLiqDErrorDesc_Sels, AV188modoTestEs, AV54LiqEstado, AV63OrderedBy, AV65OrderedDsc, AV207auxMenuOpcCod, AV179TFConClasifAux, AV180TFConClasifAux_Sels, AV18ConVariable, AV168TotLiqDImpReCalcu, AV183TotLiqDSeg, AV167TotLiqDImpCalcu, AV42IsAuthorized_InfoOriginal, AV211LiqFecImp, AV209sistemaPalabra, AV200WelcomeMessage_NoMostrarMas, AV192sdt_liquidacion2, AV190MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV225Liquidacionverdetalle2ds_1_mostrar = AV62Mostrar ;
      AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV102TFDTipoConCod_Sels ;
      AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV198TFLiqDClasifAux ;
      AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV199TFLiqDClasifAux_Sels ;
      AV229Liquidacionverdetalle2ds_5_tfdconcodigo = AV88TFDConCodigo ;
      AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV89TFDConCodigo_Sels ;
      AV231Liquidacionverdetalle2ds_7_tfdcondescrip = AV91TFDConDescrip ;
      AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV92TFDConDescrip_Sels ;
      AV233Liquidacionverdetalle2ds_9_tfliqdvaluni = AV147TFLiqDValUni ;
      AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV148TFLiqDValUni_To ;
      AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV134TFLiqDImpReCalcu ;
      AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV135TFLiqDImpReCalcu_To ;
      AV237Liquidacionverdetalle2ds_13_tfliqderrordesc = AV123TFLiqDErrorDesc ;
      AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV124TFLiqDErrorDesc_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, subGridsdt_liquidacion2s_Rows, AV62Mostrar, AV14CliCod, AV25EmpCod, AV9LiqNro, AV5LegNumero, AV59ManageFiltersExecutionStep, AV15ColumnsSelector, AV223Pgmname, AV37GridState, AV102TFDTipoConCod_Sels, AV198TFLiqDClasifAux, AV199TFLiqDClasifAux_Sels, AV88TFDConCodigo, AV89TFDConCodigo_Sels, AV91TFDConDescrip, AV92TFDConDescrip_Sels, AV147TFLiqDValUni, AV148TFLiqDValUni_To, AV134TFLiqDImpReCalcu, AV135TFLiqDImpReCalcu_To, AV123TFLiqDErrorDesc, AV124TFLiqDErrorDesc_Sels, AV188modoTestEs, AV54LiqEstado, AV63OrderedBy, AV65OrderedDsc, AV207auxMenuOpcCod, AV179TFConClasifAux, AV180TFConClasifAux_Sels, AV18ConVariable, AV168TotLiqDImpReCalcu, AV183TotLiqDSeg, AV167TotLiqDImpCalcu, AV42IsAuthorized_InfoOriginal, AV211LiqFecImp, AV209sistemaPalabra, AV200WelcomeMessage_NoMostrarMas, AV192sdt_liquidacion2, AV190MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridsdt_liquidacion2s_fnc_pagecount( )
   {
      GRIDSDT_LIQUIDACION2S_nRecordCount = subgridsdt_liquidacion2s_fnc_recordcount( ) ;
      if ( ((int)((GRIDSDT_LIQUIDACION2S_nRecordCount) % (subgridsdt_liquidacion2s_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDSDT_LIQUIDACION2S_nRecordCount/ (double) (subgridsdt_liquidacion2s_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDSDT_LIQUIDACION2S_nRecordCount/ (double) (subgridsdt_liquidacion2s_fnc_recordsperpage( )))+1) ;
   }

   public int subgridsdt_liquidacion2s_fnc_recordcount( )
   {
      return AV192sdt_liquidacion2.size() ;
   }

   public int subgridsdt_liquidacion2s_fnc_recordsperpage( )
   {
      if ( subGridsdt_liquidacion2s_Rows > 0 )
      {
         return subGridsdt_liquidacion2s_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridsdt_liquidacion2s_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage/ (double) (subgridsdt_liquidacion2s_fnc_recordsperpage( )))+1) ;
   }

   public short subgridsdt_liquidacion2s_firstpage( )
   {
      GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_liquidacion2s_refresh( subGrid_Rows, subGridsdt_liquidacion2s_Rows, AV62Mostrar, AV14CliCod, AV25EmpCod, AV9LiqNro, AV59ManageFiltersExecutionStep, AV15ColumnsSelector, AV223Pgmname, AV37GridState, AV102TFDTipoConCod_Sels, AV198TFLiqDClasifAux, AV199TFLiqDClasifAux_Sels, AV88TFDConCodigo, AV89TFDConCodigo_Sels, AV91TFDConDescrip, AV92TFDConDescrip_Sels, AV147TFLiqDValUni, AV148TFLiqDValUni_To, AV134TFLiqDImpReCalcu, AV135TFLiqDImpReCalcu_To, AV123TFLiqDErrorDesc, AV124TFLiqDErrorDesc_Sels, AV188modoTestEs, AV54LiqEstado, AV63OrderedBy, AV65OrderedDsc, AV207auxMenuOpcCod, AV5LegNumero, AV179TFConClasifAux, AV180TFConClasifAux_Sels, AV18ConVariable, A1EmpCod, A31LiqNro, A6LegNumero, A3CliCod, A764LiqDImpReCalcu, AV168TotLiqDImpReCalcu, A1469LiqDSeg, AV183TotLiqDSeg, A464DTipoConCod, AV167TotLiqDImpCalcu, A275LiqDImpCalcu, AV200WelcomeMessage_NoMostrarMas, AV192sdt_liquidacion2, AV42IsAuthorized_InfoOriginal, AV211LiqFecImp, AV209sistemaPalabra, AV190MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdt_liquidacion2s_nextpage( )
   {
      GRIDSDT_LIQUIDACION2S_nRecordCount = subgridsdt_liquidacion2s_fnc_recordcount( ) ;
      if ( ( GRIDSDT_LIQUIDACION2S_nRecordCount >= subgridsdt_liquidacion2s_fnc_recordsperpage( ) ) && ( GRIDSDT_LIQUIDACION2S_nEOF == 0 ) )
      {
         GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage = (long)(GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage+subgridsdt_liquidacion2s_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Gridsdt_liquidacion2sContainer.AddObjectProperty("GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage", GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_liquidacion2s_refresh( subGrid_Rows, subGridsdt_liquidacion2s_Rows, AV62Mostrar, AV14CliCod, AV25EmpCod, AV9LiqNro, AV59ManageFiltersExecutionStep, AV15ColumnsSelector, AV223Pgmname, AV37GridState, AV102TFDTipoConCod_Sels, AV198TFLiqDClasifAux, AV199TFLiqDClasifAux_Sels, AV88TFDConCodigo, AV89TFDConCodigo_Sels, AV91TFDConDescrip, AV92TFDConDescrip_Sels, AV147TFLiqDValUni, AV148TFLiqDValUni_To, AV134TFLiqDImpReCalcu, AV135TFLiqDImpReCalcu_To, AV123TFLiqDErrorDesc, AV124TFLiqDErrorDesc_Sels, AV188modoTestEs, AV54LiqEstado, AV63OrderedBy, AV65OrderedDsc, AV207auxMenuOpcCod, AV5LegNumero, AV179TFConClasifAux, AV180TFConClasifAux_Sels, AV18ConVariable, A1EmpCod, A31LiqNro, A6LegNumero, A3CliCod, A764LiqDImpReCalcu, AV168TotLiqDImpReCalcu, A1469LiqDSeg, AV183TotLiqDSeg, A464DTipoConCod, AV167TotLiqDImpCalcu, A275LiqDImpCalcu, AV200WelcomeMessage_NoMostrarMas, AV192sdt_liquidacion2, AV42IsAuthorized_InfoOriginal, AV211LiqFecImp, AV209sistemaPalabra, AV190MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDSDT_LIQUIDACION2S_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridsdt_liquidacion2s_previouspage( )
   {
      if ( GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage >= subgridsdt_liquidacion2s_fnc_recordsperpage( ) )
      {
         GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage = (long)(GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage-subgridsdt_liquidacion2s_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_liquidacion2s_refresh( subGrid_Rows, subGridsdt_liquidacion2s_Rows, AV62Mostrar, AV14CliCod, AV25EmpCod, AV9LiqNro, AV59ManageFiltersExecutionStep, AV15ColumnsSelector, AV223Pgmname, AV37GridState, AV102TFDTipoConCod_Sels, AV198TFLiqDClasifAux, AV199TFLiqDClasifAux_Sels, AV88TFDConCodigo, AV89TFDConCodigo_Sels, AV91TFDConDescrip, AV92TFDConDescrip_Sels, AV147TFLiqDValUni, AV148TFLiqDValUni_To, AV134TFLiqDImpReCalcu, AV135TFLiqDImpReCalcu_To, AV123TFLiqDErrorDesc, AV124TFLiqDErrorDesc_Sels, AV188modoTestEs, AV54LiqEstado, AV63OrderedBy, AV65OrderedDsc, AV207auxMenuOpcCod, AV5LegNumero, AV179TFConClasifAux, AV180TFConClasifAux_Sels, AV18ConVariable, A1EmpCod, A31LiqNro, A6LegNumero, A3CliCod, A764LiqDImpReCalcu, AV168TotLiqDImpReCalcu, A1469LiqDSeg, AV183TotLiqDSeg, A464DTipoConCod, AV167TotLiqDImpCalcu, A275LiqDImpCalcu, AV200WelcomeMessage_NoMostrarMas, AV192sdt_liquidacion2, AV42IsAuthorized_InfoOriginal, AV211LiqFecImp, AV209sistemaPalabra, AV190MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdt_liquidacion2s_lastpage( )
   {
      GRIDSDT_LIQUIDACION2S_nRecordCount = subgridsdt_liquidacion2s_fnc_recordcount( ) ;
      if ( GRIDSDT_LIQUIDACION2S_nRecordCount > subgridsdt_liquidacion2s_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDSDT_LIQUIDACION2S_nRecordCount) % (subgridsdt_liquidacion2s_fnc_recordsperpage( )))) == 0 )
         {
            GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage = (long)(GRIDSDT_LIQUIDACION2S_nRecordCount-subgridsdt_liquidacion2s_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage = (long)(GRIDSDT_LIQUIDACION2S_nRecordCount-((int)((GRIDSDT_LIQUIDACION2S_nRecordCount) % (subgridsdt_liquidacion2s_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_liquidacion2s_refresh( subGrid_Rows, subGridsdt_liquidacion2s_Rows, AV62Mostrar, AV14CliCod, AV25EmpCod, AV9LiqNro, AV59ManageFiltersExecutionStep, AV15ColumnsSelector, AV223Pgmname, AV37GridState, AV102TFDTipoConCod_Sels, AV198TFLiqDClasifAux, AV199TFLiqDClasifAux_Sels, AV88TFDConCodigo, AV89TFDConCodigo_Sels, AV91TFDConDescrip, AV92TFDConDescrip_Sels, AV147TFLiqDValUni, AV148TFLiqDValUni_To, AV134TFLiqDImpReCalcu, AV135TFLiqDImpReCalcu_To, AV123TFLiqDErrorDesc, AV124TFLiqDErrorDesc_Sels, AV188modoTestEs, AV54LiqEstado, AV63OrderedBy, AV65OrderedDsc, AV207auxMenuOpcCod, AV5LegNumero, AV179TFConClasifAux, AV180TFConClasifAux_Sels, AV18ConVariable, A1EmpCod, A31LiqNro, A6LegNumero, A3CliCod, A764LiqDImpReCalcu, AV168TotLiqDImpReCalcu, A1469LiqDSeg, AV183TotLiqDSeg, A464DTipoConCod, AV167TotLiqDImpCalcu, A275LiqDImpCalcu, AV200WelcomeMessage_NoMostrarMas, AV192sdt_liquidacion2, AV42IsAuthorized_InfoOriginal, AV211LiqFecImp, AV209sistemaPalabra, AV190MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridsdt_liquidacion2s_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage = (long)(subgridsdt_liquidacion2s_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_liquidacion2s_refresh( subGrid_Rows, subGridsdt_liquidacion2s_Rows, AV62Mostrar, AV14CliCod, AV25EmpCod, AV9LiqNro, AV59ManageFiltersExecutionStep, AV15ColumnsSelector, AV223Pgmname, AV37GridState, AV102TFDTipoConCod_Sels, AV198TFLiqDClasifAux, AV199TFLiqDClasifAux_Sels, AV88TFDConCodigo, AV89TFDConCodigo_Sels, AV91TFDConDescrip, AV92TFDConDescrip_Sels, AV147TFLiqDValUni, AV148TFLiqDValUni_To, AV134TFLiqDImpReCalcu, AV135TFLiqDImpReCalcu_To, AV123TFLiqDErrorDesc, AV124TFLiqDErrorDesc_Sels, AV188modoTestEs, AV54LiqEstado, AV63OrderedBy, AV65OrderedDsc, AV207auxMenuOpcCod, AV5LegNumero, AV179TFConClasifAux, AV180TFConClasifAux_Sels, AV18ConVariable, A1EmpCod, A31LiqNro, A6LegNumero, A3CliCod, A764LiqDImpReCalcu, AV168TotLiqDImpReCalcu, A1469LiqDSeg, AV183TotLiqDSeg, A464DTipoConCod, AV167TotLiqDImpCalcu, A275LiqDImpCalcu, AV200WelcomeMessage_NoMostrarMas, AV192sdt_liquidacion2, AV42IsAuthorized_InfoOriginal, AV211LiqFecImp, AV209sistemaPalabra, AV190MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV223Pgmname = "LiquidacionVerDetalle2" ;
      Gx_err = (short)(0) ;
      edtavLiqlegimptotremu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqlegimptotremu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotremu_Enabled), 5, 0), true);
      edtavLiqlegimptotnoremu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqlegimptotnoremu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotnoremu_Enabled), 5, 0), true);
      edtavLiqlegimptotdescu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqlegimptotdescu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotdescu_Enabled), 5, 0), true);
      edtavLiqlegimptotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqlegimptotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotal_Enabled), 5, 0), true);
      edtavEliminardetalle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminardetalle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminardetalle_Enabled), 5, 0), !bGXsfl_138_Refreshing);
      edtavTotvalueliqdimprecalcu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTotvalueliqdimprecalcu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueliqdimprecalcu_Enabled), 5, 0), true);
      edtavSdt_liquidacion2__liqnro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdt_liquidacion2__liqnro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_liquidacion2__liqnro_Enabled), 5, 0), !bGXsfl_197_Refreshing);
      edtavSdt_liquidacion2__liqnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdt_liquidacion2__liqnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_liquidacion2__liqnombre_Enabled), 5, 0), !bGXsfl_197_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_197_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupH60( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e24H62 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdt_liquidacion2"), AV192sdt_liquidacion2);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV21DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV15ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV58ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vACTIONGROUP2DATA"), AV216ActionGroup2Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDT_LIQUIDACION2"), AV192sdt_liquidacion2);
         /* Read saved values. */
         nRC_GXsfl_138 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_138"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_197 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_197"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV35GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV36GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV34GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV194Gridsdt_liquidacion2sCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDSDT_LIQUIDACION2SCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV195Gridsdt_liquidacion2sPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDSDT_LIQUIDACION2SPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV196Gridsdt_liquidacion2sAppliedFilters = httpContext.cgiGet( "vGRIDSDT_LIQUIDACION2SAPPLIEDFILTERS") ;
         AV9LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "vLIQNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV25EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV14CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV207auxMenuOpcCod = httpContext.cgiGet( "vAUXMENUOPCCOD") ;
         AV5LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV20DConCodigo_Selected = httpContext.cgiGet( "vDCONCODIGO_SELECTED") ;
         A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "LEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV49LegNumero_Selected = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGNUMERO_SELECTED"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "LIQNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV57LiqNro_Selected = (int)(localUtil.ctol( httpContext.cgiGet( "vLIQNRO_SELECTED"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "EMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV26EmpCod_Selected = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD_SELECTED"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "CLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV181CliCod_Selected = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD_SELECTED"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRIDSDT_LIQUIDACION2S_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSDT_LIQUIDACION2S_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         subGridsdt_liquidacion2s_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDT_LIQUIDACION2S_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdt_liquidacion2s_Rows, (byte)(6), (byte)(0), ".", "")));
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
         Innewwindow1_Target = httpContext.cgiGet( "INNEWWINDOW1_Target") ;
         Gridsdt_liquidacion2spaginationbar_Class = httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Class") ;
         Gridsdt_liquidacion2spaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Showfirst")) ;
         Gridsdt_liquidacion2spaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Showprevious")) ;
         Gridsdt_liquidacion2spaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Shownext")) ;
         Gridsdt_liquidacion2spaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Showlast")) ;
         Gridsdt_liquidacion2spaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Pagestoshow"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridsdt_liquidacion2spaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridsdt_liquidacion2spaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Pagingcaptionposition") ;
         Gridsdt_liquidacion2spaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Emptygridclass") ;
         Gridsdt_liquidacion2spaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Rowsperpageselector")) ;
         Gridsdt_liquidacion2spaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridsdt_liquidacion2spaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Rowsperpageoptions") ;
         Gridsdt_liquidacion2spaginationbar_Previous = httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Previous") ;
         Gridsdt_liquidacion2spaginationbar_Next = httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Next") ;
         Gridsdt_liquidacion2spaginationbar_Caption = httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Caption") ;
         Gridsdt_liquidacion2spaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Emptygridcaption") ;
         Gridsdt_liquidacion2spaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Rowsperpagecaption") ;
         Ddo_actiongroup2_Icontype = httpContext.cgiGet( "DDO_ACTIONGROUP2_Icontype") ;
         Ddo_actiongroup2_Icon = httpContext.cgiGet( "DDO_ACTIONGROUP2_Icon") ;
         Ddo_actiongroup2_Caption = httpContext.cgiGet( "DDO_ACTIONGROUP2_Caption") ;
         Ddo_actiongroup2_Cls = httpContext.cgiGet( "DDO_ACTIONGROUP2_Cls") ;
         Ddo_actiongroup2_Titlecontrolidtoreplace = httpContext.cgiGet( "DDO_ACTIONGROUP2_Titlecontrolidtoreplace") ;
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
         Dvelop_confirmpanel_eliminardetalle_Title = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Title") ;
         Dvelop_confirmpanel_eliminardetalle_Confirmationtext = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Confirmationtext") ;
         Dvelop_confirmpanel_eliminardetalle_Yesbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Yesbuttoncaption") ;
         Dvelop_confirmpanel_eliminardetalle_Nobuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Nobuttoncaption") ;
         Dvelop_confirmpanel_eliminardetalle_Cancelbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_eliminardetalle_Yesbuttonposition = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Yesbuttonposition") ;
         Dvelop_confirmpanel_eliminardetalle_Confirmtype = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Confirmtype") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         Grid_empowerer_Hascolumnsselector = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hascolumnsselector")) ;
         Gridsdt_liquidacion2s_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDT_LIQUIDACION2S_EMPOWERER_Gridinternalname") ;
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
         Dvelop_confirmpanel_eliminardetalle_Result = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_ELIMINARDETALLE_Result") ;
         Ddo_actiongroup2_Activeeventkey = httpContext.cgiGet( "DDO_ACTIONGROUP2_Activeeventkey") ;
         Gridsdt_liquidacion2spaginationbar_Selectedpage = httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Selectedpage") ;
         Gridsdt_liquidacion2spaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDT_LIQUIDACION2SPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_197 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_197"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_197_fel_idx = 0 ;
         while ( nGXsfl_197_fel_idx < nRC_GXsfl_197 )
         {
            nGXsfl_197_fel_idx = ((subGridsdt_liquidacion2s_Islastpage==1)&&(nGXsfl_197_fel_idx+1>subgridsdt_liquidacion2s_fnc_recordsperpage( )) ? 1 : nGXsfl_197_fel_idx+1) ;
            sGXsfl_197_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_197_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1973( ) ;
            AV220GXV1 = (int)(nGXsfl_197_fel_idx+GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage) ;
            if ( ( AV192sdt_liquidacion2.size() >= AV220GXV1 ) && ( AV220GXV1 > 0 ) )
            {
               AV192sdt_liquidacion2.currentItem( ((web.Sdtsdt_liquidacion2_sdt_liquidacion2Item)AV192sdt_liquidacion2.elementAt(-1+AV220GXV1)) );
               AV193VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
            }
         }
         if ( nGXsfl_197_fel_idx == 0 )
         {
            nGXsfl_197_idx = 1 ;
            sGXsfl_197_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_197_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1973( ) ;
         }
         nGXsfl_197_fel_idx = 1 ;
         /* Read variables values. */
         AV201WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV200WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV200WelcomeMessage_NoMostrarMas", AV200WelcomeMessage_NoMostrarMas);
         cmbavMostrar.setName( cmbavMostrar.getInternalname() );
         cmbavMostrar.setValue( httpContext.cgiGet( cmbavMostrar.getInternalname()) );
         AV62Mostrar = httpContext.cgiGet( cmbavMostrar.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV62Mostrar", AV62Mostrar);
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotremu_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotremu_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLIQLEGIMPTOTREMU");
            GX_FocusControl = edtavLiqlegimptotremu_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV8LiqLegImpTotRemu = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8LiqLegImpTotRemu", GXutil.ltrimstr( AV8LiqLegImpTotRemu, 14, 2));
         }
         else
         {
            AV8LiqLegImpTotRemu = localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotremu_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8LiqLegImpTotRemu", GXutil.ltrimstr( AV8LiqLegImpTotRemu, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotnoremu_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotnoremu_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLIQLEGIMPTOTNOREMU");
            GX_FocusControl = edtavLiqlegimptotnoremu_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7LiqLegImpTotNoRemu", GXutil.ltrimstr( AV7LiqLegImpTotNoRemu, 14, 2));
         }
         else
         {
            AV7LiqLegImpTotNoRemu = localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotnoremu_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7LiqLegImpTotNoRemu", GXutil.ltrimstr( AV7LiqLegImpTotNoRemu, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotdescu_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotdescu_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLIQLEGIMPTOTDESCU");
            GX_FocusControl = edtavLiqlegimptotdescu_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV6LiqLegImpTotDescu = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6LiqLegImpTotDescu", GXutil.ltrimstr( AV6LiqLegImpTotDescu, 14, 2));
         }
         else
         {
            AV6LiqLegImpTotDescu = localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotdescu_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6LiqLegImpTotDescu", GXutil.ltrimstr( AV6LiqLegImpTotDescu, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotal_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotal_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLIQLEGIMPTOTAL");
            GX_FocusControl = edtavLiqlegimptotal_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV55LiqLegImpTotal = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55LiqLegImpTotal", GXutil.ltrimstr( AV55LiqLegImpTotal, 14, 2));
         }
         else
         {
            AV55LiqLegImpTotal = localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotal_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55LiqLegImpTotal", GXutil.ltrimstr( AV55LiqLegImpTotal, 14, 2));
         }
         AV171TotValueLiqDImpReCalcu = httpContext.cgiGet( edtavTotvalueliqdimprecalcu_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV171TotValueLiqDImpReCalcu", AV171TotValueLiqDImpReCalcu);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vMOSTRAR"), AV62Mostrar) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
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
      e24H62 ();
      if (returnInSub) return;
   }

   public void e24H62( )
   {
      /* Start Routine */
      returnInSub = false ;
      Ddo_gridcolumnsselector_Caption = httpContext.getMessage( "Columnas", "") ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "Caption", Ddo_gridcolumnsselector_Caption);
      new web.setearensesion(remoteHandle, context).execute( httpContext.getMessage( "&LegNumero", ""), GXutil.trim( GXutil.str( AV5LegNumero, 8, 0))) ;
      GXv_dtime1[0] = AV211LiqFecImp ;
      new web.getliqfecimp(remoteHandle, context).execute( AV14CliCod, AV25EmpCod, AV9LiqNro, GXv_dtime1) ;
      liquidacionverdetalle2_impl.this.AV211LiqFecImp = GXv_dtime1[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV211LiqFecImp", localUtil.ttoc( AV211LiqFecImp, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQFECIMP", getSecureSignedToken( "", localUtil.format( AV211LiqFecImp, "99/99/99 99:99")));
      GXt_char2 = AV209sistemaPalabra ;
      GXv_char3[0] = GXt_char2 ;
      new web.sistemanombre(remoteHandle, context).execute( GXv_char3) ;
      liquidacionverdetalle2_impl.this.GXt_char2 = GXv_char3[0] ;
      AV209sistemaPalabra = GXt_char2 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV209sistemaPalabra", AV209sistemaPalabra);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSISTEMAPALABRA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV209sistemaPalabra, ""))));
      GXv_char3[0] = AV189ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV14CliCod, new web.modotest_codigoparam(remoteHandle, context).executeUdp( ), GXv_char3) ;
      liquidacionverdetalle2_impl.this.AV189ParmValue = GXv_char3[0] ;
      AV188modoTestEs = GXutil.boolval( AV189ParmValue) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV188modoTestEs", AV188modoTestEs);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODOTESTES", getSecureSignedToken( "", AV188modoTestEs));
      GXv_int4[0] = AV54LiqEstado ;
      new web.getliqestado(remoteHandle, context).execute( AV14CliCod, AV25EmpCod, AV9LiqNro, GXv_int4) ;
      liquidacionverdetalle2_impl.this.AV54LiqEstado = GXv_int4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54LiqEstado", GXutil.str( AV54LiqEstado, 1, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQESTADO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV54LiqEstado), "9")));
      GXv_char3[0] = AV23diasTopeConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV14CliCod, new web.concepto_diasproportopesueldo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char3) ;
      liquidacionverdetalle2_impl.this.AV23diasTopeConCodigo = GXv_char3[0] ;
      GXv_decimal5[0] = AV8LiqLegImpTotRemu ;
      GXv_decimal6[0] = AV7LiqLegImpTotNoRemu ;
      GXv_decimal7[0] = AV6LiqLegImpTotDescu ;
      GXv_decimal8[0] = AV55LiqLegImpTotal ;
      new web.gettotalesliquidacionlegajo(remoteHandle, context).execute( AV14CliCod, AV25EmpCod, AV9LiqNro, AV5LegNumero, GXv_decimal5, GXv_decimal6, GXv_decimal7, GXv_decimal8) ;
      liquidacionverdetalle2_impl.this.AV8LiqLegImpTotRemu = GXv_decimal5[0] ;
      liquidacionverdetalle2_impl.this.AV7LiqLegImpTotNoRemu = GXv_decimal6[0] ;
      liquidacionverdetalle2_impl.this.AV6LiqLegImpTotDescu = GXv_decimal7[0] ;
      liquidacionverdetalle2_impl.this.AV55LiqLegImpTotal = GXv_decimal8[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8LiqLegImpTotRemu", GXutil.ltrimstr( AV8LiqLegImpTotRemu, 14, 2));
      httpContext.ajax_rsp_assign_attri("", false, "AV7LiqLegImpTotNoRemu", GXutil.ltrimstr( AV7LiqLegImpTotNoRemu, 14, 2));
      httpContext.ajax_rsp_assign_attri("", false, "AV6LiqLegImpTotDescu", GXutil.ltrimstr( AV6LiqLegImpTotDescu, 14, 2));
      httpContext.ajax_rsp_assign_attri("", false, "AV55LiqLegImpTotal", GXutil.ltrimstr( AV55LiqLegImpTotal, 14, 2));
      new web.msgdebug_prod(remoteHandle, context).execute( AV223Pgmname, httpContext.getMessage( "pone variable en true", "")) ;
      AV190MenuOpcCod = httpContext.getMessage( "LiquidacionRecibo", "") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV190MenuOpcCod", AV190MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV190MenuOpcCod, ""))));
      new web.setopcionmenusesion(remoteHandle, context).execute( AV190MenuOpcCod, "", "") ;
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      if ( GXutil.strcmp(AV39HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      Ddo_actiongroup2_Titlecontrolidtoreplace = bttBtnactiongroup2_Internalname ;
      ucDdo_actiongroup2.sendProperty(context, "", false, Ddo_actiongroup2_Internalname, "TitleControlIdToReplace", Ddo_actiongroup2_Titlecontrolidtoreplace);
      AV216ActionGroup2Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle) ;
      AV217ActionGroup2DataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV217ActionGroup2DataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "Un Recibo de Sueldo por Hoja (Vertical)", "") );
      AV217ActionGroup2DataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "far fa-file-pdf far fa-file-pdf" );
      AV217ActionGroup2DataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "ReciboSueldo1" );
      AV217ActionGroup2DataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV216ActionGroup2Data.add(AV217ActionGroup2DataItem, 0);
      AV217ActionGroup2DataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV217ActionGroup2DataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "Dos Recibos de Sueldo por Hoja (Apaisada)", "") );
      AV217ActionGroup2DataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fas fa-file-pdf fas fa-file-pdf" );
      AV217ActionGroup2DataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "ReciboSueldo2" );
      AV217ActionGroup2DataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV216ActionGroup2Data.add(AV217ActionGroup2DataItem, 0);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( "Conceptos de la Liquidación", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV63OrderedBy < 1 )
      {
         AV63OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV63OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9 = AV21DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10[0] ;
      AV21DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      Gridsdt_liquidacion2s_empowerer_Gridinternalname = subGridsdt_liquidacion2s_Internalname ;
      ucGridsdt_liquidacion2s_empowerer.sendProperty(context, "", false, Gridsdt_liquidacion2s_empowerer_Internalname, "GridInternalName", Gridsdt_liquidacion2s_empowerer_Gridinternalname);
      subGridsdt_liquidacion2s_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdt_liquidacion2s_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridsdt_liquidacion2spaginationbar_Rowsperpageselectedvalue = subGridsdt_liquidacion2s_Rows ;
      ucGridsdt_liquidacion2spaginationbar.sendProperty(context, "", false, Gridsdt_liquidacion2spaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridsdt_liquidacion2spaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char3[0] = AV202MenuBienveImgURL ;
      GXv_char11[0] = AV204MenuBienveTitulo ;
      GXv_char12[0] = AV205MenuBienveTexto ;
      GXv_boolean13[0] = AV206MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV190MenuOpcCod, GXv_char3, GXv_char11, GXv_char12, GXv_boolean13) ;
      liquidacionverdetalle2_impl.this.AV202MenuBienveImgURL = GXv_char3[0] ;
      liquidacionverdetalle2_impl.this.AV204MenuBienveTitulo = GXv_char11[0] ;
      liquidacionverdetalle2_impl.this.AV205MenuBienveTexto = GXv_char12[0] ;
      liquidacionverdetalle2_impl.this.AV206MenuBienveVisible = GXv_boolean13[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV206MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV206MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV204MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV205MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV201WelcomeMessage_Foto = AV202MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV201WelcomeMessage_Foto)==0) ? AV224Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV201WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV201WelcomeMessage_Foto), true);
         AV224Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV202MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV201WelcomeMessage_Foto)==0) ? AV224Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV201WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV201WelcomeMessage_Foto), true);
      }
      GXt_char2 = "" ;
      GXt_char14 = "" ;
      GXv_char12[0] = GXt_char14 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char12) ;
      liquidacionverdetalle2_impl.this.GXt_char14 = GXv_char12[0] ;
      GXv_char11[0] = GXt_char2 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char14, GXv_char11) ;
      liquidacionverdetalle2_impl.this.GXt_char2 = GXv_char11[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char2 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV215observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV215observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV215observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV215observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      GXt_char14 = AV48LegNomApe ;
      GXv_char12[0] = GXt_char14 ;
      new web.getlegnomape(remoteHandle, context).execute( AV14CliCod, AV25EmpCod, AV5LegNumero, GXv_char12) ;
      liquidacionverdetalle2_impl.this.GXt_char14 = GXv_char12[0] ;
      AV48LegNomApe = GXt_char14 ;
      GXv_char12[0] = AV12CatCodigo ;
      GXv_char11[0] = AV19ConveCodigo ;
      new web.obtcategorialegajo(remoteHandle, context).execute( AV14CliCod, AV25EmpCod, AV9LiqNro, AV5LegNumero, GXv_char12, GXv_char11) ;
      liquidacionverdetalle2_impl.this.AV12CatCodigo = GXv_char12[0] ;
      liquidacionverdetalle2_impl.this.AV19ConveCodigo = GXv_char11[0] ;
      if ( (GXutil.strcmp("", AV12CatCodigo)==0) )
      {
         GXt_char14 = AV13CatDescrip ;
         GXv_char12[0] = GXt_char14 ;
         new web.textofueradeconvenio(remoteHandle, context).execute( AV14CliCod, GXv_char12) ;
         liquidacionverdetalle2_impl.this.GXt_char14 = GXv_char12[0] ;
         AV13CatDescrip = GXt_char14 ;
      }
      else
      {
         GXv_int15[0] = AV187CliConveVer ;
         new web.getversiondelegajo(remoteHandle, context).execute( AV14CliCod, AV25EmpCod, AV5LegNumero, GXv_int15) ;
         liquidacionverdetalle2_impl.this.AV187CliConveVer = GXv_int15[0] ;
         GXv_char12[0] = AV13CatDescrip ;
         GXv_boolean13[0] = false ;
         new web.getcategoria(remoteHandle, context).execute( AV14CliCod, AV187CliConveVer, AV19ConveCodigo, AV12CatCodigo, GXv_char12, GXv_boolean13) ;
         liquidacionverdetalle2_impl.this.AV13CatDescrip = GXv_char12[0] ;
      }
      lblTextblocktitle_Caption = GXutil.trim( AV48LegNomApe)+" - "+GXutil.trim( AV13CatDescrip) ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblocktitle_Internalname, "Caption", lblTextblocktitle_Caption, true);
      GXv_objcol_Sdtsdt_liquidacion2_sdt_liquidacion2Item16[0] = AV192sdt_liquidacion2 ;
      new web.getliqretros(remoteHandle, context).execute( AV14CliCod, AV25EmpCod, AV9LiqNro, GXv_objcol_Sdtsdt_liquidacion2_sdt_liquidacion2Item16) ;
      AV192sdt_liquidacion2 = GXv_objcol_Sdtsdt_liquidacion2_sdt_liquidacion2Item16[0] ;
      gx_BV197 = true ;
      tblTableretro_Visible = (((AV192sdt_liquidacion2.size()>0)) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, tblTableretro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTableretro_Visible), 5, 0), true);
   }

   public void e25H62( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_int4[0] = AV54LiqEstado ;
      new web.getliqestado(remoteHandle, context).execute( AV14CliCod, AV25EmpCod, AV9LiqNro, GXv_int4) ;
      liquidacionverdetalle2_impl.this.AV54LiqEstado = GXv_int4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54LiqEstado", GXutil.str( AV54LiqEstado, 1, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQESTADO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV54LiqEstado), "9")));
      GXv_SdtWWPContext17[0] = AV177WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext17) ;
      AV177WWPContext = GXv_SdtWWPContext17[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV59ManageFiltersExecutionStep == 1 )
      {
         AV59ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59ManageFiltersExecutionStep", GXutil.str( AV59ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV59ManageFiltersExecutionStep == 2 )
      {
         AV59ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59ManageFiltersExecutionStep", GXutil.str( AV59ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV68Session.getValue("LiquidacionVerDetalle2ColumnsSelector"), "") != 0 )
      {
         AV17ColumnsSelectorXML = AV68Session.getValue("LiquidacionVerDetalle2ColumnsSelector") ;
         AV15ColumnsSelector.fromxml(AV17ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      cmbDTipoConCod.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV15ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDTipoConCod.getInternalname(), "Visible", GXutil.ltrimstr( cmbDTipoConCod.getVisible(), 5, 0), !bGXsfl_138_Refreshing);
      edtLiqDClasifAux_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV15ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDClasifAux_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDClasifAux_Visible), 5, 0), !bGXsfl_138_Refreshing);
      edtDConCodigo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV15ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtDConCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDConCodigo_Visible), 5, 0), !bGXsfl_138_Refreshing);
      edtDConDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV15ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtDConDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDConDescrip_Visible), 5, 0), !bGXsfl_138_Refreshing);
      edtLiqDValUni_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV15ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDValUni_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDValUni_Visible), 5, 0), !bGXsfl_138_Refreshing);
      edtLiqDCanti_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV15ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDCanti_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDCanti_Visible), 5, 0), !bGXsfl_138_Refreshing);
      edtLiqDImpReCalcu_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV15ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDImpReCalcu_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDImpReCalcu_Visible), 5, 0), !bGXsfl_138_Refreshing);
      edtLiqDReFormulaHTML_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV15ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDReFormulaHTML_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDReFormulaHTML_Visible), 5, 0), !bGXsfl_138_Refreshing);
      edtLiqDErrorDesc_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV15ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDErrorDesc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDErrorDesc_Visible), 5, 0), !bGXsfl_138_Refreshing);
      edtLiqDLogRecal_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV15ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDLogRecal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDLogRecal_Visible), 5, 0), !bGXsfl_138_Refreshing);
      /* Execute user subroutine: 'INITIALIZETOTALIZERS' */
      S182 ();
      if (returnInSub) return;
      AV35GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35GridCurrentPage), 10, 0));
      AV36GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36GridPageCount), 10, 0));
      GXt_char14 = AV34GridAppliedFilters ;
      GXv_char12[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV223Pgmname, GXv_char12) ;
      liquidacionverdetalle2_impl.this.GXt_char14 = GXv_char12[0] ;
      AV34GridAppliedFilters = GXt_char14 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34GridAppliedFilters", AV34GridAppliedFilters);
      /* Execute user subroutine: 'CALCULATETOTALIZERS' */
      S192 ();
      if (returnInSub) return;
      edtDConCodigo_Columnheaderclass = "WWColumn" ;
      httpContext.ajax_rsp_assign_prop("", false, edtDConCodigo_Internalname, "Columnheaderclass", edtDConCodigo_Columnheaderclass, !bGXsfl_138_Refreshing);
      edtDConDescrip_Columnheaderclass = "WWColumn" ;
      httpContext.ajax_rsp_assign_prop("", false, edtDConDescrip_Internalname, "Columnheaderclass", edtDConDescrip_Columnheaderclass, !bGXsfl_138_Refreshing);
      edtLiqDImpReCalcu_Columnheaderclass = "WWColumn" ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDImpReCalcu_Internalname, "Columnheaderclass", edtLiqDImpReCalcu_Columnheaderclass, !bGXsfl_138_Refreshing);
      edtLiqDErrorDesc_Columnheaderclass = "WWColumn" ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDErrorDesc_Internalname, "Columnheaderclass", edtLiqDErrorDesc_Columnheaderclass, !bGXsfl_138_Refreshing);
      AV194Gridsdt_liquidacion2sCurrentPage = subgridsdt_liquidacion2s_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV194Gridsdt_liquidacion2sCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV194Gridsdt_liquidacion2sCurrentPage), 10, 0));
      AV195Gridsdt_liquidacion2sPageCount = subgridsdt_liquidacion2s_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV195Gridsdt_liquidacion2sPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV195Gridsdt_liquidacion2sPageCount), 10, 0));
      GXv_int18[0] = (short)(AV213filterCount) ;
      GXv_char12[0] = AV214filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV37GridState, GXv_int18, GXv_char12) ;
      liquidacionverdetalle2_impl.this.AV213filterCount = GXv_int18[0] ;
      liquidacionverdetalle2_impl.this.AV214filtrosTexto = GXv_char12[0] ;
      if ( AV213filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV213filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV214filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV225Liquidacionverdetalle2ds_1_mostrar = AV62Mostrar ;
      AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV102TFDTipoConCod_Sels ;
      AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV198TFLiqDClasifAux ;
      AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV199TFLiqDClasifAux_Sels ;
      AV229Liquidacionverdetalle2ds_5_tfdconcodigo = AV88TFDConCodigo ;
      AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV89TFDConCodigo_Sels ;
      AV231Liquidacionverdetalle2ds_7_tfdcondescrip = AV91TFDConDescrip ;
      AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV92TFDConDescrip_Sels ;
      AV233Liquidacionverdetalle2ds_9_tfliqdvaluni = AV147TFLiqDValUni ;
      AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV148TFLiqDValUni_To ;
      AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV134TFLiqDImpReCalcu ;
      AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV135TFLiqDImpReCalcu_To ;
      AV237Liquidacionverdetalle2ds_13_tfliqderrordesc = AV123TFLiqDErrorDesc ;
      AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV124TFLiqDErrorDesc_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV15ColumnsSelector", AV15ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV58ManageFiltersData", AV58ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV37GridState", AV37GridState);
   }

   public void e14H62( )
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
         AV66PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV66PageToGo) ;
      }
   }

   public void e15H62( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e19H62( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV63OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV63OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63OrderedBy), 4, 0));
         AV65OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65OrderedDsc", AV65OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DTipoConCod") == 0 )
         {
            AV103TFDTipoConCod_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV103TFDTipoConCod_SelsJson", AV103TFDTipoConCod_SelsJson);
            AV102TFDTipoConCod_Sels.fromJSonString(AV103TFDTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqDClasifAux") == 0 )
         {
            AV198TFLiqDClasifAux = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV198TFLiqDClasifAux", AV198TFLiqDClasifAux);
            AV197TFLiqDClasifAux_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV197TFLiqDClasifAux_SelsJson", AV197TFLiqDClasifAux_SelsJson);
            AV199TFLiqDClasifAux_Sels.fromJSonString(AV197TFLiqDClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DConCodigo") == 0 )
         {
            AV88TFDConCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFDConCodigo", AV88TFDConCodigo);
            AV90TFDConCodigo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFDConCodigo_SelsJson", AV90TFDConCodigo_SelsJson);
            AV89TFDConCodigo_Sels.fromJSonString(AV90TFDConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DConDescrip") == 0 )
         {
            AV91TFDConDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91TFDConDescrip", AV91TFDConDescrip);
            AV93TFDConDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV93TFDConDescrip_SelsJson", AV93TFDConDescrip_SelsJson);
            AV92TFDConDescrip_Sels.fromJSonString(AV93TFDConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqDValUni") == 0 )
         {
            AV147TFLiqDValUni = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV147TFLiqDValUni", GXutil.ltrimstr( AV147TFLiqDValUni, 14, 2));
            AV148TFLiqDValUni_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV148TFLiqDValUni_To", GXutil.ltrimstr( AV148TFLiqDValUni_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqDImpReCalcu") == 0 )
         {
            AV134TFLiqDImpReCalcu = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV134TFLiqDImpReCalcu", GXutil.ltrimstr( AV134TFLiqDImpReCalcu, 14, 2));
            AV135TFLiqDImpReCalcu_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV135TFLiqDImpReCalcu_To", GXutil.ltrimstr( AV135TFLiqDImpReCalcu_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqDErrorDesc") == 0 )
         {
            AV123TFLiqDErrorDesc = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV123TFLiqDErrorDesc", AV123TFLiqDErrorDesc);
            AV125TFLiqDErrorDesc_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV125TFLiqDErrorDesc_SelsJson", AV125TFLiqDErrorDesc_SelsJson);
            AV124TFLiqDErrorDesc_Sels.fromJSonString(AV125TFLiqDErrorDesc_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV223Pgmname, httpContext.getMessage( "&TFLiqDErrorDesc_SelsJson ", "")+AV125TFLiqDErrorDesc_SelsJson) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV124TFLiqDErrorDesc_Sels", AV124TFLiqDErrorDesc_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV92TFDConDescrip_Sels", AV92TFDConDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89TFDConCodigo_Sels", AV89TFDConCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV199TFLiqDClasifAux_Sels", AV199TFLiqDClasifAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV102TFDTipoConCod_Sels", AV102TFDTipoConCod_Sels);
   }

   private void e26H62( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV24EliminarDetalle = "<i class=\"fas fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminardetalle_Internalname, AV24EliminarDetalle);
      if ( false )
      {
         edtavEliminardetalle_Class = "Attribute" ;
      }
      else
      {
         edtavEliminardetalle_Class = "Invisible" ;
      }
      edtavInfooriginal_gximage = "WarningIcon" ;
      AV40InfoOriginal = context.getHttpContext().getImagePath( "4041cec4-85fe-4bd8-aaa2-a8a2026c306c", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavInfooriginal_Internalname, AV40InfoOriginal);
      AV239Infooriginal_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "4041cec4-85fe-4bd8-aaa2-a8a2026c306c", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      edtavInfooriginal_Tooltiptext = httpContext.getMessage( "Se recalculó el importe por novedad. (Este ícono debería ser una \"I\" de info...) ", "") ;
      if ( AV42IsAuthorized_InfoOriginal )
      {
         if ( DecimalUtil.compareTo(A764LiqDImpReCalcu, A275LiqDImpCalcu) != 0 )
         {
            edtavInfooriginal_Class = "rotate180" ;
         }
         else
         {
            edtavInfooriginal_Class = "Invisible" ;
         }
      }
      edtDConCodigo_Columnclass = (!(GXutil.strcmp("", A270LiqDErrorDesc)==0) ? "WWColumn WWColumnTag WWColumnTagWarning WWColumnTagWarningSingleCell" : "WWColumn") ;
      edtDConDescrip_Columnclass = (!(GXutil.strcmp("", A270LiqDErrorDesc)==0) ? "WWColumn WWColumnTag WWColumnTagWarning WWColumnTagWarningSingleCell" : "WWColumn") ;
      edtLiqDImpReCalcu_Columnclass = (!(GXutil.strcmp("", A270LiqDErrorDesc)==0) ? "WWColumn WWColumnTag WWColumnTagDanger WWColumnTagDangerSingleCell" : "WWColumn") ;
      edtLiqDErrorDesc_Columnclass = (!(GXutil.strcmp("", A270LiqDErrorDesc)==0) ? "WWColumn WWColumnTag WWColumnTagDanger WWColumnTagDangerSingleCell" : "WWColumn") ;
      if ( A502LiqDMostrar == 3 )
      {
         edtDConCodigo_Fontbold = (byte)(1) ;
         edtDConDescrip_Fontbold = (byte)(1) ;
         edtLiqDImpReCalcu_Fontbold = (byte)(1) ;
         edtLiqDCanti_Fontbold = (byte)(1) ;
      }
      else
      {
         edtDConCodigo_Fontbold = (byte)(0) ;
         edtDConDescrip_Fontbold = (byte)(0) ;
         edtLiqDImpReCalcu_Fontbold = (byte)(0) ;
         edtLiqDCanti_Fontbold = (byte)(0) ;
      }
      edtLiqDImpReCalcu_Tooltiptext = GXutil.trim( A504LiqDForOrig) ;
      if ( ! (GXutil.strcmp("", A270LiqDErrorDesc)==0) )
      {
         edtLiqDLogRecal_Tooltiptext = GXutil.trim( A1072LiqDLogRecal) ;
      }
      else
      {
         edtLiqDLogRecal_Tooltiptext = "" ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV211LiqFecImp) )
      {
         GXv_char12[0] = AV210ConDescrip ;
         new web.conceptogetdescri(remoteHandle, context).execute( A3CliCod, A394DConCodigo, GXv_char12) ;
         liquidacionverdetalle2_impl.this.AV210ConDescrip = GXv_char12[0] ;
         edtDConDescrip_Tooltiptext = httpContext.getMessage( "Concepto ", "")+GXutil.trim( AV209sistemaPalabra)+": \""+GXutil.trim( AV210ConDescrip)+"\"" ;
      }
      else
      {
         edtDConDescrip_Tooltiptext = "" ;
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(138) ;
      }
      sendrow_1382( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_138_Refreshing )
      {
         httpContext.doAjaxLoad(138, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e12H62( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV17ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV15ColumnsSelector.fromJSonString(AV17ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "LiquidacionVerDetalle2ColumnsSelector", ((GXutil.strcmp("", AV17ColumnsSelectorXML)==0) ? "" : AV15ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV15ColumnsSelector", AV15ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV58ManageFiltersData", AV58ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV37GridState", AV37GridState);
   }

   public void e13H62( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S202 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S162 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("LiquidacionVerDetalle2Filters")),GXutil.URLEncode(GXutil.rtrim(AV223Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV59ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59ManageFiltersExecutionStep", GXutil.str( AV59ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("LiquidacionVerDetalle2Filters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV59ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59ManageFiltersExecutionStep", GXutil.str( AV59ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char14 = AV60ManageFiltersXml ;
         GXv_char12[0] = GXt_char14 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "LiquidacionVerDetalle2Filters", Ddo_managefilters_Activeeventkey, GXv_char12) ;
         liquidacionverdetalle2_impl.this.GXt_char14 = GXv_char12[0] ;
         AV60ManageFiltersXml = GXt_char14 ;
         if ( (GXutil.strcmp("", AV60ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S202 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV223Pgmname+"GridState", AV60ManageFiltersXml) ;
            AV37GridState.fromxml(AV60ManageFiltersXml, null, null);
            AV63OrderedBy = AV37GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63OrderedBy), 4, 0));
            AV65OrderedDsc = AV37GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65OrderedDsc", AV65OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S212 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV37GridState", AV37GridState);
      cmbavMostrar.setValue( GXutil.rtrim( AV62Mostrar) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Values", cmbavMostrar.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV199TFLiqDClasifAux_Sels", AV199TFLiqDClasifAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV102TFDTipoConCod_Sels", AV102TFDTipoConCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89TFDConCodigo_Sels", AV89TFDConCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV92TFDConDescrip_Sels", AV92TFDConDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV124TFLiqDErrorDesc_Sels", AV124TFLiqDErrorDesc_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV15ColumnsSelector", AV15ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV58ManageFiltersData", AV58ManageFiltersData);
   }

   public void e20H62( )
   {
      /* Dvelop_confirmpanel_eliminardetalle_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_eliminardetalle_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ELIMINARDETALLE' */
         S222 ();
         if (returnInSub) return;
      }
   }

   public void e18H62( )
   {
      /* Ddo_actiongroup2_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_actiongroup2_Activeeventkey, "ReciboSueldo1") == 0 )
      {
         /* Execute user subroutine: 'DO RECIBOSUELDO1' */
         S232 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(Ddo_actiongroup2_Activeeventkey, "ReciboSueldo2") == 0 )
      {
         /* Execute user subroutine: 'DO RECIBOSUELDO2' */
         S242 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
   }

   public void e21H62( )
   {
      /* 'DoReLiquidar' Routine */
      returnInSub = false ;
      new web.resetealiquidacion(remoteHandle, context).execute( AV14CliCod, AV25EmpCod, AV9LiqNro) ;
   }

   public void e22H62( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char12[0] = AV29ExcelFilename ;
      GXv_char11[0] = AV27ErrorMessage ;
      new web.liquidacionverdetalle2export(remoteHandle, context).execute( GXv_char12, GXv_char11) ;
      liquidacionverdetalle2_impl.this.AV29ExcelFilename = GXv_char12[0] ;
      liquidacionverdetalle2_impl.this.AV27ErrorMessage = GXv_char11[0] ;
      if ( GXutil.strcmp(AV29ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV29ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV27ErrorMessage);
      }
   }

   public void e16H62( )
   {
      /* Gridsdt_liquidacion2spaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridsdt_liquidacion2spaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgridsdt_liquidacion2s_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridsdt_liquidacion2spaginationbar_Selectedpage, "Next") == 0 )
      {
         AV66PageToGo = subgridsdt_liquidacion2s_fnc_currentpage( ) ;
         AV66PageToGo = (int)(AV66PageToGo+1) ;
         subgridsdt_liquidacion2s_gotopage( AV66PageToGo) ;
      }
      else
      {
         AV66PageToGo = (int)(GXutil.lval( Gridsdt_liquidacion2spaginationbar_Selectedpage)) ;
         subgridsdt_liquidacion2s_gotopage( AV66PageToGo) ;
      }
   }

   public void e17H62( )
   {
      /* Gridsdt_liquidacion2spaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGridsdt_liquidacion2s_Rows = Gridsdt_liquidacion2spaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdt_liquidacion2s_Rows, (byte)(6), (byte)(0), ".", "")));
      subgridsdt_liquidacion2s_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV63OrderedBy, 4, 0))+":"+(AV65OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S172( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV15ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector19[0] = AV15ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector19, "DTipoConCod", "", "Tipo", true, "") ;
      AV15ColumnsSelector = GXv_SdtWWPColumnsSelector19[0] ;
      GXv_SdtWWPColumnsSelector19[0] = AV15ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector19, "LiqDClasifAux", "", "Clasificación", true, "") ;
      AV15ColumnsSelector = GXv_SdtWWPColumnsSelector19[0] ;
      GXv_SdtWWPColumnsSelector19[0] = AV15ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector19, "DConCodigo", "", "Código", true, "") ;
      AV15ColumnsSelector = GXv_SdtWWPColumnsSelector19[0] ;
      GXv_SdtWWPColumnsSelector19[0] = AV15ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector19, "DConDescrip", "", "Descripción", true, "") ;
      AV15ColumnsSelector = GXv_SdtWWPColumnsSelector19[0] ;
      GXv_SdtWWPColumnsSelector19[0] = AV15ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector19, "LiqDValUni", "", "Base", false, "") ;
      AV15ColumnsSelector = GXv_SdtWWPColumnsSelector19[0] ;
      GXv_SdtWWPColumnsSelector19[0] = AV15ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector19, "LiqDCanti", "", "Cantidad", true, "") ;
      AV15ColumnsSelector = GXv_SdtWWPColumnsSelector19[0] ;
      GXv_SdtWWPColumnsSelector19[0] = AV15ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector19, "LiqDImpReCalcu", "", "Importe", true, "") ;
      AV15ColumnsSelector = GXv_SdtWWPColumnsSelector19[0] ;
      GXv_SdtWWPColumnsSelector19[0] = AV15ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector19, "LiqDReFormulaHTML", "", "Fórmula", false, "") ;
      AV15ColumnsSelector = GXv_SdtWWPColumnsSelector19[0] ;
      GXv_SdtWWPColumnsSelector19[0] = AV15ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector19, "LiqDErrorDesc", "", "Error", false, "") ;
      AV15ColumnsSelector = GXv_SdtWWPColumnsSelector19[0] ;
      GXv_SdtWWPColumnsSelector19[0] = AV15ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector19, "LiqDLogRecal", "", "Log", true, "") ;
      AV15ColumnsSelector = GXv_SdtWWPColumnsSelector19[0] ;
      GXt_char14 = AV174UserCustomValue ;
      GXv_char12[0] = GXt_char14 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LiquidacionVerDetalle2ColumnsSelector", GXv_char12) ;
      liquidacionverdetalle2_impl.this.GXt_char14 = GXv_char12[0] ;
      AV174UserCustomValue = GXt_char14 ;
      if ( ! ( (GXutil.strcmp("", AV174UserCustomValue)==0) ) )
      {
         AV16ColumnsSelectorAux.fromxml(AV174UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector19[0] = AV16ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector20[0] = AV15ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector19, GXv_SdtWWPColumnsSelector20) ;
         AV16ColumnsSelectorAux = GXv_SdtWWPColumnsSelector19[0] ;
         AV15ColumnsSelector = GXv_SdtWWPColumnsSelector20[0] ;
      }
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean21 = AV42IsAuthorized_InfoOriginal ;
      GXv_boolean13[0] = GXt_boolean21 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "ImporteOriginal", GXv_boolean13) ;
      liquidacionverdetalle2_impl.this.GXt_boolean21 = GXv_boolean13[0] ;
      AV42IsAuthorized_InfoOriginal = GXt_boolean21 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42IsAuthorized_InfoOriginal", AV42IsAuthorized_InfoOriginal);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INFOORIGINAL", getSecureSignedToken( "", AV42IsAuthorized_InfoOriginal));
      if ( ! ( AV42IsAuthorized_InfoOriginal ) )
      {
         edtavInfooriginal_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavInfooriginal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInfooriginal_Visible), 5, 0), !bGXsfl_138_Refreshing);
      }
      if ( ! ( ( AV188modoTestEs ) && ( ( AV54LiqEstado == 3 ) || ( AV54LiqEstado == 2 ) ) ) )
      {
         bttBtnreliquidar_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnreliquidar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnreliquidar_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item22 = AV58ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item23[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item22 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "LiquidacionVerDetalle2Filters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item23) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item22 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item23[0] ;
      AV58ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item22 ;
   }

   public void S202( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      if ( false )
      {
         AV62Mostrar = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV62Mostrar", AV62Mostrar);
         AV102TFDTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
         AV198TFLiqDClasifAux = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV198TFLiqDClasifAux", AV198TFLiqDClasifAux);
         AV199TFLiqDClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
         AV88TFDConCodigo = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV88TFDConCodigo", AV88TFDConCodigo);
         AV89TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
         AV91TFDConDescrip = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV91TFDConDescrip", AV91TFDConDescrip);
         AV92TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
         AV147TFLiqDValUni = DecimalUtil.ZERO ;
         httpContext.ajax_rsp_assign_attri("", false, "AV147TFLiqDValUni", GXutil.ltrimstr( AV147TFLiqDValUni, 14, 2));
         AV148TFLiqDValUni_To = DecimalUtil.ZERO ;
         httpContext.ajax_rsp_assign_attri("", false, "AV148TFLiqDValUni_To", GXutil.ltrimstr( AV148TFLiqDValUni_To, 14, 2));
         AV134TFLiqDImpReCalcu = DecimalUtil.ZERO ;
         httpContext.ajax_rsp_assign_attri("", false, "AV134TFLiqDImpReCalcu", GXutil.ltrimstr( AV134TFLiqDImpReCalcu, 14, 2));
         AV135TFLiqDImpReCalcu_To = DecimalUtil.ZERO ;
         httpContext.ajax_rsp_assign_attri("", false, "AV135TFLiqDImpReCalcu_To", GXutil.ltrimstr( AV135TFLiqDImpReCalcu_To, 14, 2));
         AV123TFLiqDErrorDesc = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV123TFLiqDErrorDesc", AV123TFLiqDErrorDesc);
         AV124TFLiqDErrorDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
         Ddo_grid_Selectedvalue_set = "" ;
         ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
         Ddo_grid_Filteredtext_set = "" ;
         ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
         Ddo_grid_Filteredtextto_set = "" ;
         ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      }
      else
      {
         AV102TFDTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
         AV88TFDConCodigo = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV88TFDConCodigo", AV88TFDConCodigo);
         AV89TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
         AV91TFDConDescrip = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV91TFDConDescrip", AV91TFDConDescrip);
         AV92TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
         AV147TFLiqDValUni = DecimalUtil.ZERO ;
         httpContext.ajax_rsp_assign_attri("", false, "AV147TFLiqDValUni", GXutil.ltrimstr( AV147TFLiqDValUni, 14, 2));
         AV148TFLiqDValUni_To = DecimalUtil.ZERO ;
         httpContext.ajax_rsp_assign_attri("", false, "AV148TFLiqDValUni_To", GXutil.ltrimstr( AV148TFLiqDValUni_To, 14, 2));
         AV134TFLiqDImpReCalcu = DecimalUtil.ZERO ;
         httpContext.ajax_rsp_assign_attri("", false, "AV134TFLiqDImpReCalcu", GXutil.ltrimstr( AV134TFLiqDImpReCalcu, 14, 2));
         AV135TFLiqDImpReCalcu_To = DecimalUtil.ZERO ;
         httpContext.ajax_rsp_assign_attri("", false, "AV135TFLiqDImpReCalcu_To", GXutil.ltrimstr( AV135TFLiqDImpReCalcu_To, 14, 2));
         AV123TFLiqDErrorDesc = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV123TFLiqDErrorDesc", AV123TFLiqDErrorDesc);
         AV124TFLiqDErrorDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
         Ddo_grid_Selectedvalue_set = "" ;
         ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
         Ddo_grid_Filteredtext_set = "" ;
         ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
         Ddo_grid_Filteredtextto_set = "" ;
         ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      }
   }

   public void S222( )
   {
      /* 'DO ELIMINARDETALLE' Routine */
      returnInSub = false ;
      new web.eliminaliquidaciondetalle(remoteHandle, context).execute( AV181CliCod_Selected, AV26EmpCod_Selected, AV57LiqNro_Selected, AV49LegNumero_Selected, AV20DConCodigo_Selected) ;
   }

   public void S232( )
   {
      /* 'DO RECIBOSUELDO1' Routine */
      returnInSub = false ;
      GXv_char12[0] = AV50linkPDF ;
      GXv_char11[0] = AV28errorPDF ;
      new web.armaurlrecibopdf(remoteHandle, context).execute( AV14CliCod, AV25EmpCod, AV9LiqNro, AV5LegNumero, "Vertical", false, false, GXv_char12, GXv_char11) ;
      liquidacionverdetalle2_impl.this.AV50linkPDF = GXv_char12[0] ;
      liquidacionverdetalle2_impl.this.AV28errorPDF = GXv_char11[0] ;
      if ( ! (GXutil.strcmp("", AV28errorPDF)==0) )
      {
         new web.alert(remoteHandle, context).execute( "error", AV28errorPDF) ;
      }
      else
      {
         Innewwindow1_Target = AV50linkPDF ;
         ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
         this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      }
   }

   public void S242( )
   {
      /* 'DO RECIBOSUELDO2' Routine */
      returnInSub = false ;
      GXv_char12[0] = AV50linkPDF ;
      GXv_char11[0] = AV28errorPDF ;
      new web.armaurlrecibopdf(remoteHandle, context).execute( AV14CliCod, AV25EmpCod, AV9LiqNro, AV5LegNumero, "Apaisado", false, false, GXv_char12, GXv_char11) ;
      liquidacionverdetalle2_impl.this.AV50linkPDF = GXv_char12[0] ;
      liquidacionverdetalle2_impl.this.AV28errorPDF = GXv_char11[0] ;
      if ( ! (GXutil.strcmp("", AV28errorPDF)==0) )
      {
         new web.alert(remoteHandle, context).execute( "error", AV28errorPDF) ;
      }
      else
      {
         Innewwindow1_Target = AV50linkPDF ;
         ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
         this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      }
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV223Pgmname, httpContext.getMessage( "LoadGridState 1", "")) ;
      if ( GXutil.strcmp(AV68Session.getValue(AV223Pgmname+"GridState"), "") == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV223Pgmname, httpContext.getMessage( "LoadGridState 2", "")) ;
         AV37GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV223Pgmname+"GridState"), null, null);
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV223Pgmname, httpContext.getMessage( "LoadGridState 3", "")) ;
         AV37GridState.fromxml(AV68Session.getValue(AV223Pgmname+"GridState"), null, null);
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV223Pgmname, httpContext.getMessage( "LoadGridState &GridState.FilterValues ", "")+GXutil.trim( GXutil.str( AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().size(), 9, 0))) ;
      AV240GXV4 = 1 ;
      while ( AV240GXV4 <= AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV240GXV4));
         new web.msgdebug_prod(remoteHandle, context).execute( AV223Pgmname, httpContext.getMessage( "&GridStateFilterValue.Name ", "")+AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name()) ;
         if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "CONVARIABLE") == 0 )
         {
            AV18ConVariable = GXutil.boolval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18ConVariable", AV18ConVariable);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVARIABLE", getSecureSignedToken( "", AV18ConVariable));
            new web.msgdebug_prod(remoteHandle, context).execute( AV223Pgmname, httpContext.getMessage( "LoadGridState encuentra &GridStateFilterValue.Value ", "")+AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()+httpContext.getMessage( " &ConVariable ", "")+GXutil.trim( GXutil.booltostr( AV18ConVariable))) ;
         }
         AV240GXV4 = (int)(AV240GXV4+1) ;
      }
      if ( GXutil.strcmp(AV68Session.getValue(AV223Pgmname+"GridState"), "") == 0 )
      {
         AV37GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV223Pgmname+"GridState"), null, null);
      }
      else
      {
         AV37GridState.fromxml(AV68Session.getValue(AV223Pgmname+"GridState"), null, null);
      }
      AV63OrderedBy = AV37GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63OrderedBy), 4, 0));
      AV65OrderedDsc = AV37GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65OrderedDsc", AV65OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S212 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV37GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV37GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV37GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S212( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV241GXV5 = 1 ;
      while ( AV241GXV5 <= AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV241GXV5));
         if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "MOSTRAR") == 0 )
         {
            AV62Mostrar = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62Mostrar", AV62Mostrar);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDTIPOCONCOD_SEL") == 0 )
         {
            AV103TFDTipoConCod_SelsJson = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV103TFDTipoConCod_SelsJson", AV103TFDTipoConCod_SelsJson);
            AV102TFDTipoConCod_Sels.fromJSonString(AV103TFDTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDCLASIFAUX") == 0 )
         {
            AV198TFLiqDClasifAux = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV198TFLiqDClasifAux", AV198TFLiqDClasifAux);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDCLASIFAUX_SEL") == 0 )
         {
            AV197TFLiqDClasifAux_SelsJson = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV197TFLiqDClasifAux_SelsJson", AV197TFLiqDClasifAux_SelsJson);
            AV199TFLiqDClasifAux_Sels.fromJSonString(AV197TFLiqDClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO") == 0 )
         {
            AV88TFDConCodigo = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFDConCodigo", AV88TFDConCodigo);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO_SEL") == 0 )
         {
            AV90TFDConCodigo_SelsJson = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFDConCodigo_SelsJson", AV90TFDConCodigo_SelsJson);
            AV89TFDConCodigo_Sels.fromJSonString(AV90TFDConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP") == 0 )
         {
            AV91TFDConDescrip = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91TFDConDescrip", AV91TFDConDescrip);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP_SEL") == 0 )
         {
            AV93TFDConDescrip_SelsJson = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV93TFDConDescrip_SelsJson", AV93TFDConDescrip_SelsJson);
            AV92TFDConDescrip_Sels.fromJSonString(AV93TFDConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDVALUNI") == 0 )
         {
            AV147TFLiqDValUni = CommonUtil.decimalVal( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV147TFLiqDValUni", GXutil.ltrimstr( AV147TFLiqDValUni, 14, 2));
            AV148TFLiqDValUni_To = CommonUtil.decimalVal( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV148TFLiqDValUni_To", GXutil.ltrimstr( AV148TFLiqDValUni_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDIMPRECALCU") == 0 )
         {
            AV134TFLiqDImpReCalcu = CommonUtil.decimalVal( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV134TFLiqDImpReCalcu", GXutil.ltrimstr( AV134TFLiqDImpReCalcu, 14, 2));
            AV135TFLiqDImpReCalcu_To = CommonUtil.decimalVal( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV135TFLiqDImpReCalcu_To", GXutil.ltrimstr( AV135TFLiqDImpReCalcu_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDERRORDESC") == 0 )
         {
            AV123TFLiqDErrorDesc = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV123TFLiqDErrorDesc", AV123TFLiqDErrorDesc);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDERRORDESC_SEL") == 0 )
         {
            AV125TFLiqDErrorDesc_SelsJson = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV125TFLiqDErrorDesc_SelsJson", AV125TFLiqDErrorDesc_SelsJson);
            AV124TFLiqDErrorDesc_Sels.fromJSonString(AV125TFLiqDErrorDesc_SelsJson, null);
         }
         AV241GXV5 = (int)(AV241GXV5+1) ;
      }
      GXt_char14 = "" ;
      GXv_char12[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV102TFDTipoConCod_Sels.size()==0), AV103TFDTipoConCod_SelsJson, GXv_char12) ;
      liquidacionverdetalle2_impl.this.GXt_char14 = GXv_char12[0] ;
      GXt_char2 = "" ;
      GXv_char11[0] = GXt_char2 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV199TFLiqDClasifAux_Sels.size()==0), AV197TFLiqDClasifAux_SelsJson, GXv_char11) ;
      liquidacionverdetalle2_impl.this.GXt_char2 = GXv_char11[0] ;
      GXt_char24 = "" ;
      GXv_char3[0] = GXt_char24 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV89TFDConCodigo_Sels.size()==0), AV90TFDConCodigo_SelsJson, GXv_char3) ;
      liquidacionverdetalle2_impl.this.GXt_char24 = GXv_char3[0] ;
      GXt_char25 = "" ;
      GXv_char26[0] = GXt_char25 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV92TFDConDescrip_Sels.size()==0), AV93TFDConDescrip_SelsJson, GXv_char26) ;
      liquidacionverdetalle2_impl.this.GXt_char25 = GXv_char26[0] ;
      GXt_char27 = "" ;
      GXv_char28[0] = GXt_char27 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV124TFLiqDErrorDesc_Sels.size()==0), AV125TFLiqDErrorDesc_SelsJson, GXv_char28) ;
      liquidacionverdetalle2_impl.this.GXt_char27 = GXv_char28[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char14+"|"+GXt_char2+"|"+GXt_char24+"|"+GXt_char25+"|||"+GXt_char27+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char27 = "" ;
      GXv_char28[0] = GXt_char27 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV198TFLiqDClasifAux)==0), AV198TFLiqDClasifAux, GXv_char28) ;
      liquidacionverdetalle2_impl.this.GXt_char27 = GXv_char28[0] ;
      GXt_char25 = "" ;
      GXv_char26[0] = GXt_char25 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV88TFDConCodigo)==0), AV88TFDConCodigo, GXv_char26) ;
      liquidacionverdetalle2_impl.this.GXt_char25 = GXv_char26[0] ;
      GXt_char24 = "" ;
      GXv_char12[0] = GXt_char24 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV91TFDConDescrip)==0), AV91TFDConDescrip, GXv_char12) ;
      liquidacionverdetalle2_impl.this.GXt_char24 = GXv_char12[0] ;
      GXt_char14 = "" ;
      GXv_char11[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV123TFLiqDErrorDesc)==0), AV123TFLiqDErrorDesc, GXv_char11) ;
      liquidacionverdetalle2_impl.this.GXt_char14 = GXv_char11[0] ;
      Ddo_grid_Filteredtext_set = "|"+GXt_char27+"|"+GXt_char25+"|"+GXt_char24+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV147TFLiqDValUni)==0) ? "" : GXutil.str( AV147TFLiqDValUni, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV134TFLiqDImpReCalcu)==0) ? "" : GXutil.str( AV134TFLiqDImpReCalcu, 14, 2))+"|"+GXt_char14+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV148TFLiqDValUni_To)==0) ? "" : GXutil.str( AV148TFLiqDValUni_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV135TFLiqDImpReCalcu_To)==0) ? "" : GXutil.str( AV135TFLiqDImpReCalcu_To, 14, 2))+"||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      if ( true )
      {
         AV37GridState.fromxml(AV68Session.getValue(AV223Pgmname+"GridState"), null, null);
         AV37GridState.setgxTv_SdtWWPGridState_Orderedby( AV63OrderedBy );
         AV37GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV65OrderedDsc );
         AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState29, "MOSTRAR", httpContext.getMessage( "Ver", ""), !(GXutil.strcmp("", AV62Mostrar)==0), (short)(0), AV62Mostrar, "") ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFDTIPOCONCOD_SEL", httpContext.getMessage( "Tipo", ""), !(AV102TFDTipoConCod_Sels.size()==0), (short)(0), AV102TFDTipoConCod_Sels.toJSonString(false), "") ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFLIQDCLASIFAUX", httpContext.getMessage( "Clasificación", ""), !(GXutil.strcmp("", AV198TFLiqDClasifAux)==0), (short)(0), AV198TFLiqDClasifAux, "", !(AV199TFLiqDClasifAux_Sels.size()==0), AV199TFLiqDClasifAux_Sels.toJSonString(false), "") ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFDCONCODIGO", httpContext.getMessage( "Código", ""), !(GXutil.strcmp("", AV88TFDConCodigo)==0), (short)(0), AV88TFDConCodigo, "", !(AV89TFDConCodigo_Sels.size()==0), AV89TFDConCodigo_Sels.toJSonString(false), "") ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFDCONDESCRIP", httpContext.getMessage( "Descripción", ""), !(GXutil.strcmp("", AV91TFDConDescrip)==0), (short)(0), AV91TFDConDescrip, "", !(AV92TFDConDescrip_Sels.size()==0), AV92TFDConDescrip_Sels.toJSonString(false), "") ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFLIQDVALUNI", httpContext.getMessage( "Base", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV147TFLiqDValUni)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV148TFLiqDValUni_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV147TFLiqDValUni, 14, 2)), GXutil.trim( GXutil.str( AV148TFLiqDValUni_To, 14, 2))) ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFLIQDIMPRECALCU", httpContext.getMessage( "Importe", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV134TFLiqDImpReCalcu)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV135TFLiqDImpReCalcu_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV134TFLiqDImpReCalcu, 14, 2)), GXutil.trim( GXutil.str( AV135TFLiqDImpReCalcu_To, 14, 2))) ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFLIQDERRORDESC", httpContext.getMessage( "Error", ""), !(GXutil.strcmp("", AV123TFLiqDErrorDesc)==0), (short)(0), AV123TFLiqDErrorDesc, "", !(AV124TFLiqDErrorDesc_Sels.size()==0), AV124TFLiqDErrorDesc_Sels.toJSonString(false), "") ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         if ( ! (GXutil.strcmp("", AV207auxMenuOpcCod)==0) )
         {
            AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&AUXMENUOPCCOD" );
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV207auxMenuOpcCod );
            AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV38GridStateFilterValue, 0);
         }
         if ( ! (0==AV14CliCod) )
         {
            AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&CLICOD" );
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV14CliCod, 6, 0) );
            AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV38GridStateFilterValue, 0);
         }
         if ( ! (0==AV25EmpCod) )
         {
            AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&EMPCOD" );
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV25EmpCod, 4, 0) );
            AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV38GridStateFilterValue, 0);
         }
         if ( ! (0==AV9LiqNro) )
         {
            AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&LIQNRO" );
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV9LiqNro, 8, 0) );
            AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV38GridStateFilterValue, 0);
         }
         if ( ! (0==AV5LegNumero) )
         {
            AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&LEGNUMERO" );
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV5LegNumero, 8, 0) );
            AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV38GridStateFilterValue, 0);
         }
         AV37GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
         AV37GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
         new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV223Pgmname+"GridState", AV37GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
      }
      else
      {
         AV37GridState.fromxml(AV68Session.getValue(AV223Pgmname+"GridState"), null, null);
         AV37GridState.setgxTv_SdtWWPGridState_Orderedby( AV63OrderedBy );
         AV37GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV65OrderedDsc );
         AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState29, "MOSTRAR", httpContext.getMessage( "Ver", ""), true, (short)(0), AV62Mostrar, "") ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFDTIPOCONCOD_SEL", httpContext.getMessage( "Tipo de Concepto", ""), !(AV102TFDTipoConCod_Sels.size()==0), (short)(0), AV102TFDTipoConCod_Sels.toJSonString(false), "") ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFCONCLASIFAUX", httpContext.getMessage( "Clasificación", ""), !(GXutil.strcmp("", AV179TFConClasifAux)==0), (short)(0), AV179TFConClasifAux, "", !(AV180TFConClasifAux_Sels.size()==0), AV180TFConClasifAux_Sels.toJSonString(false), "") ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFDCONCODIGO", httpContext.getMessage( "Código", ""), !(GXutil.strcmp("", AV88TFDConCodigo)==0), (short)(0), AV88TFDConCodigo, "", !(AV89TFDConCodigo_Sels.size()==0), AV89TFDConCodigo_Sels.toJSonString(false), "") ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFDCONDESCRIP", httpContext.getMessage( "Descripción", ""), !(GXutil.strcmp("", AV91TFDConDescrip)==0), (short)(0), AV91TFDConDescrip, "", !(AV92TFDConDescrip_Sels.size()==0), AV92TFDConDescrip_Sels.toJSonString(false), "") ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFLIQDVALUNI", httpContext.getMessage( "Base", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV147TFLiqDValUni)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV148TFLiqDValUni_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV147TFLiqDValUni, 14, 2)), GXutil.trim( GXutil.str( AV148TFLiqDValUni_To, 14, 2))) ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFLIQDIMPRECALCU", httpContext.getMessage( "Importe", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV134TFLiqDImpReCalcu)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV135TFLiqDImpReCalcu_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV134TFLiqDImpReCalcu, 14, 2)), GXutil.trim( GXutil.str( AV135TFLiqDImpReCalcu_To, 14, 2))) ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         GXv_SdtWWPGridState29[0] = AV37GridState;
         new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState29, "TFLIQDERRORDESC", httpContext.getMessage( "Error", ""), !(GXutil.strcmp("", AV123TFLiqDErrorDesc)==0), (short)(0), AV123TFLiqDErrorDesc, "", !(AV124TFLiqDErrorDesc_Sels.size()==0), AV124TFLiqDErrorDesc_Sels.toJSonString(false), "") ;
         AV37GridState = GXv_SdtWWPGridState29[0] ;
         if ( ! (0==AV14CliCod) )
         {
            AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&CLICOD" );
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV14CliCod, 6, 0) );
            AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV38GridStateFilterValue, 0);
         }
         if ( ! (0==AV25EmpCod) )
         {
            AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&EMPCOD" );
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV25EmpCod, 4, 0) );
            AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV38GridStateFilterValue, 0);
         }
         if ( ! (0==AV9LiqNro) )
         {
            AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&LIQNRO" );
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV9LiqNro, 8, 0) );
            AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV38GridStateFilterValue, 0);
         }
         if ( ! (0==AV5LegNumero) )
         {
            AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&LEGNUMERO" );
            AV38GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV5LegNumero, 8, 0) );
            AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV38GridStateFilterValue, 0);
         }
         AV37GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
         AV37GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
         new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV223Pgmname+"GridState", AV37GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV223Pgmname, httpContext.getMessage( "guarda en la sesion ", "")+GXutil.trim( GXutil.booltostr( AV18ConVariable))) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV172TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV172TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV223Pgmname );
      AV172TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV172TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV39HTTPRequest.getScriptName()+"?"+AV39HTTPRequest.getQuerystring() );
      AV172TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "LiquidacionDetalle" );
      AV68Session.setValue("TrnContext", AV172TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void S182( )
   {
      /* 'INITIALIZETOTALIZERS' Routine */
      returnInSub = false ;
      AV168TotLiqDImpReCalcu = DecimalUtil.doubleToDec(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV168TotLiqDImpReCalcu", GXutil.ltrimstr( AV168TotLiqDImpReCalcu, 18, 2));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDIMPRECALCU", getSecureSignedToken( "", localUtil.format( AV168TotLiqDImpReCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      AV183TotLiqDSeg = DecimalUtil.doubleToDec(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV183TotLiqDSeg", GXutil.ltrimstr( AV183TotLiqDSeg, 18, 3));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDSEG", getSecureSignedToken( "", localUtil.format( AV183TotLiqDSeg, "9.999")));
   }

   public void S192( )
   {
      /* 'CALCULATETOTALIZERS' Routine */
      returnInSub = false ;
      if ( false )
      {
         AV225Liquidacionverdetalle2ds_1_mostrar = AV62Mostrar ;
         AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV102TFDTipoConCod_Sels ;
         AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV198TFLiqDClasifAux ;
         AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV199TFLiqDClasifAux_Sels ;
         AV229Liquidacionverdetalle2ds_5_tfdconcodigo = AV88TFDConCodigo ;
         AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV89TFDConCodigo_Sels ;
         AV231Liquidacionverdetalle2ds_7_tfdcondescrip = AV91TFDConDescrip ;
         AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV92TFDConDescrip_Sels ;
         AV233Liquidacionverdetalle2ds_9_tfliqdvaluni = AV147TFLiqDValUni ;
         AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV148TFLiqDValUni_To ;
         AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV134TFLiqDImpReCalcu ;
         AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV135TFLiqDImpReCalcu_To ;
         AV237Liquidacionverdetalle2ds_13_tfliqderrordesc = AV123TFLiqDErrorDesc ;
         AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV124TFLiqDErrorDesc_Sels ;
         pr_default.dynParam(2, new Object[]{ new Object[]{
                                              A464DTipoConCod ,
                                              AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                              A2149LiqDClasifAux ,
                                              AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                              A394DConCodigo ,
                                              AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                              A393DConDescrip ,
                                              AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                              A270LiqDErrorDesc ,
                                              AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                              AV225Liquidacionverdetalle2ds_1_mostrar ,
                                              Integer.valueOf(AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels.size()) ,
                                              Integer.valueOf(AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels.size()) ,
                                              AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                              Integer.valueOf(AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels.size()) ,
                                              AV229Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                              Integer.valueOf(AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels.size()) ,
                                              AV231Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                              AV233Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                              AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                              AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                              AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                              Integer.valueOf(AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels.size()) ,
                                              AV237Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                              Byte.valueOf(A502LiqDMostrar) ,
                                              A277LiqDValUni ,
                                              A764LiqDImpReCalcu ,
                                              Integer.valueOf(AV14CliCod) ,
                                              Short.valueOf(AV25EmpCod) ,
                                              Integer.valueOf(AV9LiqNro) ,
                                              Integer.valueOf(AV5LegNumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A31LiqNro) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                              TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = GXutil.concat( GXutil.rtrim( AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux), "%", "") ;
         lV229Liquidacionverdetalle2ds_5_tfdconcodigo = GXutil.padr( GXutil.rtrim( AV229Liquidacionverdetalle2ds_5_tfdconcodigo), 10, "%") ;
         lV231Liquidacionverdetalle2ds_7_tfdcondescrip = GXutil.concat( GXutil.rtrim( AV231Liquidacionverdetalle2ds_7_tfdcondescrip), "%", "") ;
         lV237Liquidacionverdetalle2ds_13_tfliqderrordesc = GXutil.concat( GXutil.rtrim( AV237Liquidacionverdetalle2ds_13_tfliqderrordesc), "%", "") ;
         /* Using cursor H00H64 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV5LegNumero), lV227Liquidacionverdetalle2ds_3_tfliqdclasifaux, lV229Liquidacionverdetalle2ds_5_tfdconcodigo, lV231Liquidacionverdetalle2ds_7_tfdcondescrip, AV233Liquidacionverdetalle2ds_9_tfliqdvaluni, AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to, AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu, AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to, lV237Liquidacionverdetalle2ds_13_tfliqderrordesc});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A3CliCod = H00H64_A3CliCod[0] ;
            A6LegNumero = H00H64_A6LegNumero[0] ;
            A31LiqNro = H00H64_A31LiqNro[0] ;
            A1EmpCod = H00H64_A1EmpCod[0] ;
            A270LiqDErrorDesc = H00H64_A270LiqDErrorDesc[0] ;
            n270LiqDErrorDesc = H00H64_n270LiqDErrorDesc[0] ;
            A764LiqDImpReCalcu = H00H64_A764LiqDImpReCalcu[0] ;
            A277LiqDValUni = H00H64_A277LiqDValUni[0] ;
            n277LiqDValUni = H00H64_n277LiqDValUni[0] ;
            A393DConDescrip = H00H64_A393DConDescrip[0] ;
            A394DConCodigo = H00H64_A394DConCodigo[0] ;
            A2149LiqDClasifAux = H00H64_A2149LiqDClasifAux[0] ;
            A464DTipoConCod = H00H64_A464DTipoConCod[0] ;
            A502LiqDMostrar = H00H64_A502LiqDMostrar[0] ;
            A1469LiqDSeg = H00H64_A1469LiqDSeg[0] ;
            AV168TotLiqDImpReCalcu = A764LiqDImpReCalcu.add(AV168TotLiqDImpReCalcu) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV168TotLiqDImpReCalcu", GXutil.ltrimstr( AV168TotLiqDImpReCalcu, 18, 2));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDIMPRECALCU", getSecureSignedToken( "", localUtil.format( AV168TotLiqDImpReCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
            AV183TotLiqDSeg = A1469LiqDSeg.add(AV183TotLiqDSeg) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV183TotLiqDSeg", GXutil.ltrimstr( AV183TotLiqDSeg, 18, 3));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDSEG", getSecureSignedToken( "", localUtil.format( AV183TotLiqDSeg, "9.999")));
            pr_default.readNext(2);
         }
         pr_default.close(2);
         AV171TotValueLiqDImpReCalcu = localUtil.format( AV168TotLiqDImpReCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV171TotValueLiqDImpReCalcu", AV171TotValueLiqDImpReCalcu);
         AV184TotValueLiqDSeg = localUtil.format( AV183TotLiqDSeg, "9.999") ;
      }
      else
      {
         /* Using cursor H00H65 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV5LegNumero)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A3CliCod = H00H65_A3CliCod[0] ;
            A6LegNumero = H00H65_A6LegNumero[0] ;
            A31LiqNro = H00H65_A31LiqNro[0] ;
            A1EmpCod = H00H65_A1EmpCod[0] ;
            A464DTipoConCod = H00H65_A464DTipoConCod[0] ;
            A275LiqDImpCalcu = H00H65_A275LiqDImpCalcu[0] ;
            n275LiqDImpCalcu = H00H65_n275LiqDImpCalcu[0] ;
            A1469LiqDSeg = H00H65_A1469LiqDSeg[0] ;
            if ( GXutil.strcmp(A464DTipoConCod, "DES_ARG") == 0 )
            {
               AV167TotLiqDImpCalcu = AV167TotLiqDImpCalcu.subtract(A275LiqDImpCalcu) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV167TotLiqDImpCalcu", GXutil.ltrimstr( AV167TotLiqDImpCalcu, 18, 2));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDIMPCALCU", getSecureSignedToken( "", localUtil.format( AV167TotLiqDImpCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
            }
            else
            {
               AV167TotLiqDImpCalcu = AV167TotLiqDImpCalcu.add(A275LiqDImpCalcu) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV167TotLiqDImpCalcu", GXutil.ltrimstr( AV167TotLiqDImpCalcu, 18, 2));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDIMPCALCU", getSecureSignedToken( "", localUtil.format( AV167TotLiqDImpCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
            }
            AV183TotLiqDSeg = A1469LiqDSeg.add(AV183TotLiqDSeg) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV183TotLiqDSeg", GXutil.ltrimstr( AV183TotLiqDSeg, 18, 3));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLIQDSEG", getSecureSignedToken( "", localUtil.format( AV183TotLiqDSeg, "9.999")));
            pr_default.readNext(3);
         }
         pr_default.close(3);
         AV170TotValueLiqDImpCalcu = localUtil.format( AV167TotLiqDImpCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         AV184TotValueLiqDSeg = localUtil.format( AV183TotLiqDSeg, "9.999") ;
      }
   }

   public void e23H62( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV200WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean13[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV190MenuOpcCod, GXv_boolean13) ;
         GXv_char28[0] = AV203textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char28) ;
         liquidacionverdetalle2_impl.this.AV203textoNoMostrara = GXv_char28[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV203textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean13[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV190MenuOpcCod, GXv_boolean13) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void e29H62( )
   {
      AV220GXV1 = (int)(nGXsfl_197_idx+GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage) ;
      if ( ( AV220GXV1 > 0 ) && ( AV192sdt_liquidacion2.size() >= AV220GXV1 ) )
      {
         AV192sdt_liquidacion2.currentItem( ((web.Sdtsdt_liquidacion2_sdt_liquidacion2Item)AV192sdt_liquidacion2.elementAt(-1+AV220GXV1)) );
      }
      /* Versvg_Click Routine */
      returnInSub = false ;
      httpContext.popup(formatLink("web.verliqretro2", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV25EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(((web.Sdtsdt_liquidacion2_sdt_liquidacion2Item)(AV192sdt_liquidacion2.currentItem())).getgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro(),8,0))}, new String[] {"CliCod","EmpCod","LiqNro"}) , new Object[] {});
   }

   public void S252( )
   {
      /* 'DO ACTION RELIQUIDAR' Routine */
      returnInSub = false ;
      gxgrgrid_refresh( subGrid_Rows, subGridsdt_liquidacion2s_Rows, AV62Mostrar, AV14CliCod, AV25EmpCod, AV9LiqNro, AV5LegNumero, AV59ManageFiltersExecutionStep, AV15ColumnsSelector, AV223Pgmname, AV37GridState, AV102TFDTipoConCod_Sels, AV198TFLiqDClasifAux, AV199TFLiqDClasifAux_Sels, AV88TFDConCodigo, AV89TFDConCodigo_Sels, AV91TFDConDescrip, AV92TFDConDescrip_Sels, AV147TFLiqDValUni, AV148TFLiqDValUni_To, AV134TFLiqDImpReCalcu, AV135TFLiqDImpReCalcu_To, AV123TFLiqDErrorDesc, AV124TFLiqDErrorDesc_Sels, AV188modoTestEs, AV54LiqEstado, AV63OrderedBy, AV65OrderedDsc, AV207auxMenuOpcCod, AV179TFConClasifAux, AV180TFConClasifAux_Sels, AV18ConVariable, AV168TotLiqDImpReCalcu, AV183TotLiqDSeg, AV167TotLiqDImpCalcu, AV42IsAuthorized_InfoOriginal, AV211LiqFecImp, AV209sistemaPalabra, AV200WelcomeMessage_NoMostrarMas, AV192sdt_liquidacion2, AV190MenuOpcCod) ;
   }

   public void S262( )
   {
      /* 'DO PDFVIEJOVERTICAL' Routine */
      returnInSub = false ;
   }

   public void S272( )
   {
      /* 'DO RELIQUIDAR' Routine */
      returnInSub = false ;
   }

   public void S282( )
   {
      /* 'DOEXPORT' Routine */
      returnInSub = false ;
   }

   public void e27H62( )
   {
      /* Grid_Refresh Routine */
      returnInSub = false ;
      AV225Liquidacionverdetalle2ds_1_mostrar = AV62Mostrar ;
      AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV102TFDTipoConCod_Sels ;
      AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV198TFLiqDClasifAux ;
      AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV199TFLiqDClasifAux_Sels ;
      AV229Liquidacionverdetalle2ds_5_tfdconcodigo = AV88TFDConCodigo ;
      AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV89TFDConCodigo_Sels ;
      AV231Liquidacionverdetalle2ds_7_tfdcondescrip = AV91TFDConDescrip ;
      AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV92TFDConDescrip_Sels ;
      AV233Liquidacionverdetalle2ds_9_tfliqdvaluni = AV147TFLiqDValUni ;
      AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV148TFLiqDValUni_To ;
      AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV134TFLiqDImpReCalcu ;
      AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV135TFLiqDImpReCalcu_To ;
      AV237Liquidacionverdetalle2ds_13_tfliqderrordesc = AV123TFLiqDErrorDesc ;
      AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV124TFLiqDErrorDesc_Sels ;
   }

   private void e28H63( )
   {
      /* Gridsdt_liquidacion2s_Load Routine */
      returnInSub = false ;
      AV220GXV1 = 1 ;
      while ( AV220GXV1 <= AV192sdt_liquidacion2.size() )
      {
         AV192sdt_liquidacion2.currentItem( ((web.Sdtsdt_liquidacion2_sdt_liquidacion2Item)AV192sdt_liquidacion2.elementAt(-1+AV220GXV1)) );
         edtavVersvg_Format = (short)(1) ;
         GXt_char27 = AV193VerSVG ;
         GXv_char28[0] = GXt_char27 ;
         new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char28) ;
         liquidacionverdetalle2_impl.this.GXt_char27 = GXv_char28[0] ;
         AV193VerSVG = GXt_char27 ;
         httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV193VerSVG);
         edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(197) ;
         }
         if ( ( subGridsdt_liquidacion2s_Islastpage == 1 ) || ( subGridsdt_liquidacion2s_Rows == 0 ) || ( ( GRIDSDT_LIQUIDACION2S_nCurrentRecord >= GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage ) && ( GRIDSDT_LIQUIDACION2S_nCurrentRecord < GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage + subgridsdt_liquidacion2s_fnc_recordsperpage( ) ) ) )
         {
            sendrow_1973( ) ;
            GRIDSDT_LIQUIDACION2S_nEOF = (byte)(0) ;
            web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDT_LIQUIDACION2S_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDT_LIQUIDACION2S_nCurrentRecord + 1 >= subgridsdt_liquidacion2s_fnc_recordcount( ) )
            {
               GRIDSDT_LIQUIDACION2S_nEOF = (byte)(1) ;
               web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_LIQUIDACION2S_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDT_LIQUIDACION2S_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDT_LIQUIDACION2S_nCurrentRecord = (long)(GRIDSDT_LIQUIDACION2S_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_197_Refreshing )
         {
            httpContext.doAjaxLoad(197, Gridsdt_liquidacion2sRow);
         }
         AV220GXV1 = (int)(AV220GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void wb_table6_209_H62( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_eliminardetalle_Internalname, tblTabledvelop_confirmpanel_eliminardetalle_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_eliminardetalle.setProperty("Title", Dvelop_confirmpanel_eliminardetalle_Title);
         ucDvelop_confirmpanel_eliminardetalle.setProperty("ConfirmationText", Dvelop_confirmpanel_eliminardetalle_Confirmationtext);
         ucDvelop_confirmpanel_eliminardetalle.setProperty("YesButtonCaption", Dvelop_confirmpanel_eliminardetalle_Yesbuttoncaption);
         ucDvelop_confirmpanel_eliminardetalle.setProperty("NoButtonCaption", Dvelop_confirmpanel_eliminardetalle_Nobuttoncaption);
         ucDvelop_confirmpanel_eliminardetalle.setProperty("CancelButtonCaption", Dvelop_confirmpanel_eliminardetalle_Cancelbuttoncaption);
         ucDvelop_confirmpanel_eliminardetalle.setProperty("YesButtonPosition", Dvelop_confirmpanel_eliminardetalle_Yesbuttonposition);
         ucDvelop_confirmpanel_eliminardetalle.setProperty("ConfirmType", Dvelop_confirmpanel_eliminardetalle_Confirmtype);
         ucDvelop_confirmpanel_eliminardetalle.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_eliminardetalle_Internalname, "DVELOP_CONFIRMPANEL_ELIMINARDETALLEContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVELOP_CONFIRMPANEL_ELIMINARDETALLEContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_209_H62e( true) ;
      }
      else
      {
         wb_table6_209_H62e( false) ;
      }
   }

   public void wb_table5_187_H62( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTableretro_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTableretro_Internalname, tblTableretro_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup2_Internalname, httpContext.getMessage( "Liquidaciones retroactivas", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_LiquidacionVerDetalle2.htm");
         wb_table7_191_H62( true) ;
      }
      else
      {
         wb_table7_191_H62( false) ;
      }
      return  ;
   }

   public void wb_table7_191_H62e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_187_H62e( true) ;
      }
      else
      {
         wb_table5_187_H62e( false) ;
      }
   }

   public void wb_table7_191_H62( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='HasGridEmpowerer'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridsdt_liquidacion2stablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Gridsdt_liquidacion2sContainer.SetWrapped(nGXWrapped);
         startgridcontrol197( ) ;
      }
      if ( wbEnd == 197 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_197 = (int)(nGXsfl_197_idx-1) ;
         if ( Gridsdt_liquidacion2sContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV220GXV1 = nGXsfl_197_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Gridsdt_liquidacion2sContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridsdt_liquidacion2s", Gridsdt_liquidacion2sContainer, subGridsdt_liquidacion2s_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Gridsdt_liquidacion2sContainerData", Gridsdt_liquidacion2sContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Gridsdt_liquidacion2sContainerData"+"V", Gridsdt_liquidacion2sContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridsdt_liquidacion2sContainerData"+"V"+"\" value='"+Gridsdt_liquidacion2sContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridsdt_liquidacion2spaginationbar.setProperty("Class", Gridsdt_liquidacion2spaginationbar_Class);
         ucGridsdt_liquidacion2spaginationbar.setProperty("ShowFirst", Gridsdt_liquidacion2spaginationbar_Showfirst);
         ucGridsdt_liquidacion2spaginationbar.setProperty("ShowPrevious", Gridsdt_liquidacion2spaginationbar_Showprevious);
         ucGridsdt_liquidacion2spaginationbar.setProperty("ShowNext", Gridsdt_liquidacion2spaginationbar_Shownext);
         ucGridsdt_liquidacion2spaginationbar.setProperty("ShowLast", Gridsdt_liquidacion2spaginationbar_Showlast);
         ucGridsdt_liquidacion2spaginationbar.setProperty("PagesToShow", Gridsdt_liquidacion2spaginationbar_Pagestoshow);
         ucGridsdt_liquidacion2spaginationbar.setProperty("PagingButtonsPosition", Gridsdt_liquidacion2spaginationbar_Pagingbuttonsposition);
         ucGridsdt_liquidacion2spaginationbar.setProperty("PagingCaptionPosition", Gridsdt_liquidacion2spaginationbar_Pagingcaptionposition);
         ucGridsdt_liquidacion2spaginationbar.setProperty("EmptyGridClass", Gridsdt_liquidacion2spaginationbar_Emptygridclass);
         ucGridsdt_liquidacion2spaginationbar.setProperty("RowsPerPageSelector", Gridsdt_liquidacion2spaginationbar_Rowsperpageselector);
         ucGridsdt_liquidacion2spaginationbar.setProperty("RowsPerPageOptions", Gridsdt_liquidacion2spaginationbar_Rowsperpageoptions);
         ucGridsdt_liquidacion2spaginationbar.setProperty("Previous", Gridsdt_liquidacion2spaginationbar_Previous);
         ucGridsdt_liquidacion2spaginationbar.setProperty("Next", Gridsdt_liquidacion2spaginationbar_Next);
         ucGridsdt_liquidacion2spaginationbar.setProperty("Caption", Gridsdt_liquidacion2spaginationbar_Caption);
         ucGridsdt_liquidacion2spaginationbar.setProperty("EmptyGridCaption", Gridsdt_liquidacion2spaginationbar_Emptygridcaption);
         ucGridsdt_liquidacion2spaginationbar.setProperty("RowsPerPageCaption", Gridsdt_liquidacion2spaginationbar_Rowsperpagecaption);
         ucGridsdt_liquidacion2spaginationbar.setProperty("CurrentPage", AV194Gridsdt_liquidacion2sCurrentPage);
         ucGridsdt_liquidacion2spaginationbar.setProperty("PageCount", AV195Gridsdt_liquidacion2sPageCount);
         ucGridsdt_liquidacion2spaginationbar.setProperty("AppliedFilters", AV196Gridsdt_liquidacion2sAppliedFilters);
         ucGridsdt_liquidacion2spaginationbar.render(context, "dvelop.dvpaginationbar", Gridsdt_liquidacion2spaginationbar_Internalname, "GRIDSDT_LIQUIDACION2SPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_191_H62e( true) ;
      }
      else
      {
         wb_table7_191_H62e( false) ;
      }
   }

   public void wb_table4_158_H62( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblGridtabletotalizer_Internalname, tblGridtabletotalizer_Internalname, "", "TableTotalizerAl", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavTotvalueliqdimprecalcu_Internalname, httpContext.getMessage( "Tot Value Liq DImp Re Calcu", ""), "gx-form-item AttributeTotalizerLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 170,'',false,'" + sGXsfl_138_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTotvalueliqdimprecalcu_Internalname, AV171TotValueLiqDImpReCalcu, GXutil.rtrim( localUtil.format( AV171TotValueLiqDImpReCalcu, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,170);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotvalueliqdimprecalcu_Jsonclick, 0, "AttributeTotalizer", "", "", "", "", 1, edtavTotvalueliqdimprecalcu_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LiquidacionVerDetalle2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_158_H62e( true) ;
      }
      else
      {
         wb_table4_158_H62e( false) ;
      }
   }

   public void wb_table3_93_H62( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionVerDetalle2.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_93_H62e( true) ;
      }
      else
      {
         wb_table3_93_H62e( false) ;
      }
   }

   public void wb_table2_29_H62( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionVerDetalle2.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_29_H62e( true) ;
      }
      else
      {
         wb_table2_29_H62e( false) ;
      }
   }

   public void wb_table1_24_H62( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionVerDetalle2.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_24_H62e( true) ;
      }
      else
      {
         wb_table1_24_H62e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV207auxMenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV207auxMenuOpcCod", AV207auxMenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV207auxMenuOpcCod, ""))));
      AV14CliCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
      AV25EmpCod = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV25EmpCod), "ZZZ9")));
      AV9LiqNro = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9LiqNro), 8, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LiqNro), "ZZZZZZZ9")));
      AV5LegNumero = ((Number) GXutil.testNumericType( getParm(obj,4), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5LegNumero), 8, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5LegNumero), "ZZZZZZZ9")));
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
      paH62( ) ;
      wsH62( ) ;
      weH62( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713522394", true, true);
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
      httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("liquidacionverdetalle2.js", "?20251713522395", false, true);
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
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_1382( )
   {
      edtavEliminardetalle_Internalname = "vELIMINARDETALLE_"+sGXsfl_138_idx ;
      cmbDTipoConCod.setInternalname( "DTIPOCONCOD_"+sGXsfl_138_idx );
      edtLiqDClasifAux_Internalname = "LIQDCLASIFAUX_"+sGXsfl_138_idx ;
      edtDConCodigo_Internalname = "DCONCODIGO_"+sGXsfl_138_idx ;
      edtDConDescrip_Internalname = "DCONDESCRIP_"+sGXsfl_138_idx ;
      edtLiqDValUni_Internalname = "LIQDVALUNI_"+sGXsfl_138_idx ;
      edtLiqDCanti_Internalname = "LIQDCANTI_"+sGXsfl_138_idx ;
      edtLiqDImporte_Internalname = "LIQDIMPORTE_"+sGXsfl_138_idx ;
      edtLiqDImpReCalcu_Internalname = "LIQDIMPRECALCU_"+sGXsfl_138_idx ;
      edtLiqDReFormulaHTML_Internalname = "LIQDREFORMULAHTML_"+sGXsfl_138_idx ;
      edtLiqDErrorDesc_Internalname = "LIQDERRORDESC_"+sGXsfl_138_idx ;
      cmbLiqDMostrar.setInternalname( "LIQDMOSTRAR_"+sGXsfl_138_idx );
      edtDConOrden_Internalname = "DCONORDEN_"+sGXsfl_138_idx ;
      edtLiqDSecuencial_Internalname = "LIQDSECUENCIAL_"+sGXsfl_138_idx ;
      edtLiqDLogRecal_Internalname = "LIQDLOGRECAL_"+sGXsfl_138_idx ;
      edtLiqDSeg_Internalname = "LIQDSEG_"+sGXsfl_138_idx ;
      edtavInfooriginal_Internalname = "vINFOORIGINAL_"+sGXsfl_138_idx ;
   }

   public void subsflControlProps_fel_1382( )
   {
      edtavEliminardetalle_Internalname = "vELIMINARDETALLE_"+sGXsfl_138_fel_idx ;
      cmbDTipoConCod.setInternalname( "DTIPOCONCOD_"+sGXsfl_138_fel_idx );
      edtLiqDClasifAux_Internalname = "LIQDCLASIFAUX_"+sGXsfl_138_fel_idx ;
      edtDConCodigo_Internalname = "DCONCODIGO_"+sGXsfl_138_fel_idx ;
      edtDConDescrip_Internalname = "DCONDESCRIP_"+sGXsfl_138_fel_idx ;
      edtLiqDValUni_Internalname = "LIQDVALUNI_"+sGXsfl_138_fel_idx ;
      edtLiqDCanti_Internalname = "LIQDCANTI_"+sGXsfl_138_fel_idx ;
      edtLiqDImporte_Internalname = "LIQDIMPORTE_"+sGXsfl_138_fel_idx ;
      edtLiqDImpReCalcu_Internalname = "LIQDIMPRECALCU_"+sGXsfl_138_fel_idx ;
      edtLiqDReFormulaHTML_Internalname = "LIQDREFORMULAHTML_"+sGXsfl_138_fel_idx ;
      edtLiqDErrorDesc_Internalname = "LIQDERRORDESC_"+sGXsfl_138_fel_idx ;
      cmbLiqDMostrar.setInternalname( "LIQDMOSTRAR_"+sGXsfl_138_fel_idx );
      edtDConOrden_Internalname = "DCONORDEN_"+sGXsfl_138_fel_idx ;
      edtLiqDSecuencial_Internalname = "LIQDSECUENCIAL_"+sGXsfl_138_fel_idx ;
      edtLiqDLogRecal_Internalname = "LIQDLOGRECAL_"+sGXsfl_138_fel_idx ;
      edtLiqDSeg_Internalname = "LIQDSEG_"+sGXsfl_138_fel_idx ;
      edtavInfooriginal_Internalname = "vINFOORIGINAL_"+sGXsfl_138_fel_idx ;
   }

   public void sendrow_1382( )
   {
      subsflControlProps_1382( ) ;
      wbH60( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_138_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_138_idx) % (2))) == 0 )
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
            httpContext.writeText( " class=\""+"GridWithTotalizer GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_138_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEliminardetalle_Enabled!=0)&&(edtavEliminardetalle_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 139,'',false,'"+sGXsfl_138_idx+"',138)\"" : " ") ;
         ROClassString = edtavEliminardetalle_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminardetalle_Internalname,GXutil.rtrim( AV24EliminarDetalle),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEliminardetalle_Enabled!=0)&&(edtavEliminardetalle_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,139);\"" : " "),"'"+""+"'"+",false,"+"'"+"e30h62_client"+"'","","","","",edtavEliminardetalle_Jsonclick,Integer.valueOf(7),edtavEliminardetalle_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavEliminardetalle_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbDTipoConCod.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbDTipoConCod.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "DTIPOCONCOD_" + sGXsfl_138_idx ;
            cmbDTipoConCod.setName( GXCCtl );
            cmbDTipoConCod.setWebtags( "" );
            cmbDTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
            cmbDTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
            cmbDTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
            cmbDTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
            if ( cmbDTipoConCod.getItemCount() > 0 )
            {
               A464DTipoConCod = cmbDTipoConCod.getValidValue(A464DTipoConCod) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbDTipoConCod,cmbDTipoConCod.getInternalname(),GXutil.rtrim( A464DTipoConCod),Integer.valueOf(1),cmbDTipoConCod.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbDTipoConCod.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbDTipoConCod.setValue( GXutil.rtrim( A464DTipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDTipoConCod.getInternalname(), "Values", cmbDTipoConCod.ToJavascriptSource(), !bGXsfl_138_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqDClasifAux_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDClasifAux_Internalname,A2149LiqDClasifAux,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDClasifAux_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqDClasifAux_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtDConCodigo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDConCodigo_Internalname,GXutil.rtrim( A394DConCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDConCodigo_Jsonclick,Integer.valueOf(0),"Attribute",((edtDConCodigo_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"),ROClassString,edtDConCodigo_Columnclass,edtDConCodigo_Columnheaderclass,Integer.valueOf(edtDConCodigo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtDConDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDConDescrip_Internalname,A393DConDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","",edtDConDescrip_Tooltiptext,"",edtDConDescrip_Jsonclick,Integer.valueOf(0),"Attribute",((edtDConDescrip_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"),ROClassString,edtDConDescrip_Columnclass,edtDConDescrip_Columnheaderclass,Integer.valueOf(edtDConDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqDValUni_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDValUni_Internalname,GXutil.ltrim( localUtil.ntoc( A277LiqDValUni, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A277LiqDValUni, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDValUni_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqDValUni_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqDCanti_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDCanti_Internalname,GXutil.ltrim( localUtil.ntoc( A269LiqDCanti, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A269LiqDCanti, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDCanti_Jsonclick,Integer.valueOf(0),"Attribute",((edtLiqDCanti_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"),ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLiqDCanti_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDImporte_Internalname,GXutil.ltrim( localUtil.ntoc( A276LiqDImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A276LiqDImporte, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDImporte_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqDImpReCalcu_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDImpReCalcu_Internalname,GXutil.ltrim( localUtil.ntoc( A764LiqDImpReCalcu, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A764LiqDImpReCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","",edtLiqDImpReCalcu_Tooltiptext,"",edtLiqDImpReCalcu_Jsonclick,Integer.valueOf(0),"Attribute",((edtLiqDImpReCalcu_Fontbold==1) ? "font-weight:bold;" : "font-weight:normal;"),ROClassString,edtLiqDImpReCalcu_Columnclass,edtLiqDImpReCalcu_Columnheaderclass,Integer.valueOf(edtLiqDImpReCalcu_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"ImportesSigned","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqDReFormulaHTML_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDReFormulaHTML_Internalname,A876LiqDReFormulaHTML,A876LiqDReFormulaHTML,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDReFormulaHTML_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqDReFormulaHTML_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2000),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"Obs","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqDErrorDesc_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDErrorDesc_Internalname,A270LiqDErrorDesc,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDErrorDesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,edtLiqDErrorDesc_Columnclass,edtLiqDErrorDesc_Columnheaderclass,Integer.valueOf(edtLiqDErrorDesc_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbLiqDMostrar.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LIQDMOSTRAR_" + sGXsfl_138_idx ;
            cmbLiqDMostrar.setName( GXCCtl );
            cmbLiqDMostrar.setWebtags( "" );
            cmbLiqDMostrar.addItem("3", httpContext.getMessage( "Conceptos del recibo", ""), (short)(0));
            cmbLiqDMostrar.addItem("2", httpContext.getMessage( "Conceptos del recibo más cálculos usados mayores a cero", ""), (short)(0));
            cmbLiqDMostrar.addItem("1", httpContext.getMessage( "Todos", ""), (short)(0));
            if ( cmbLiqDMostrar.getItemCount() > 0 )
            {
               A502LiqDMostrar = (byte)(GXutil.lval( cmbLiqDMostrar.getValidValue(GXutil.trim( GXutil.str( A502LiqDMostrar, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqDMostrar,cmbLiqDMostrar.getInternalname(),GXutil.trim( GXutil.str( A502LiqDMostrar, 1, 0)),Integer.valueOf(1),cmbLiqDMostrar.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqDMostrar.setValue( GXutil.trim( GXutil.str( A502LiqDMostrar, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLiqDMostrar.getInternalname(), "Values", cmbLiqDMostrar.ToJavascriptSource(), !bGXsfl_138_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDConOrden_Internalname,GXutil.ltrim( localUtil.ntoc( A471DConOrden, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A471DConOrden), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDConOrden_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDSecuencial_Internalname,GXutil.ltrim( localUtil.ntoc( A81LiqDSecuencial, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A81LiqDSecuencial), "ZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDSecuencial_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqDLogRecal_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDLogRecal_Internalname,A1072LiqDLogRecal,A1072LiqDLogRecal,"","'"+""+"'"+",false,"+"'"+""+"'","","",edtLiqDLogRecal_Tooltiptext,"",edtLiqDLogRecal_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqDLogRecal_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDSeg_Internalname,GXutil.ltrim( localUtil.ntoc( A1469LiqDSeg, (byte)(5), (byte)(3), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1469LiqDSeg, "9.999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDSeg_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(138),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((edtavInfooriginal_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Active Bitmap Variable */
         TempTags = " " + ((edtavInfooriginal_Enabled!=0)&&(edtavInfooriginal_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 155,'',false,'',138)\"" : " ") ;
         ClassString = edtavInfooriginal_Class + " " + ((GXutil.strcmp(edtavInfooriginal_gximage, "")==0) ? "" : "GX_Image_"+edtavInfooriginal_gximage+"_Class") ;
         StyleString = "" ;
         AV40InfoOriginal_IsBlob = (boolean)(((GXutil.strcmp("", AV40InfoOriginal)==0)&&(GXutil.strcmp("", AV239Infooriginal_GXI)==0))||!(GXutil.strcmp("", AV40InfoOriginal)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV40InfoOriginal)==0) ? AV239Infooriginal_GXI : httpContext.getResourceRelative(AV40InfoOriginal)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavInfooriginal_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtavInfooriginal_Visible),Integer.valueOf(1),"",edtavInfooriginal_Tooltiptext,Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(7),edtavInfooriginal_Jsonclick,"'"+""+"'"+",false,"+"'"+"e31h62_client"+"'",StyleString,ClassString,"WWActionColumn","","","",""+TempTags,"","",Integer.valueOf(1),Boolean.valueOf(AV40InfoOriginal_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         send_integrity_lvl_hashesH62( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_138_idx = ((subGrid_Islastpage==1)&&(nGXsfl_138_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_138_idx+1) ;
         sGXsfl_138_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_138_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1382( ) ;
      }
      /* End function sendrow_1382 */
   }

   public void subsflControlProps_1973( )
   {
      edtavSdt_liquidacion2__liqnro_Internalname = "SDT_LIQUIDACION2__LIQNRO_"+sGXsfl_197_idx ;
      edtavSdt_liquidacion2__liqnombre_Internalname = "SDT_LIQUIDACION2__LIQNOMBRE_"+sGXsfl_197_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_197_idx ;
   }

   public void subsflControlProps_fel_1973( )
   {
      edtavSdt_liquidacion2__liqnro_Internalname = "SDT_LIQUIDACION2__LIQNRO_"+sGXsfl_197_fel_idx ;
      edtavSdt_liquidacion2__liqnombre_Internalname = "SDT_LIQUIDACION2__LIQNOMBRE_"+sGXsfl_197_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_197_fel_idx ;
   }

   public void sendrow_1973( )
   {
      subsflControlProps_1973( ) ;
      wbH60( ) ;
      if ( ( subGridsdt_liquidacion2s_Rows * 1 == 0 ) || ( nGXsfl_197_idx <= subgridsdt_liquidacion2s_fnc_recordsperpage( ) * 1 ) )
      {
         Gridsdt_liquidacion2sRow = GXWebRow.GetNew(context,Gridsdt_liquidacion2sContainer) ;
         if ( subGridsdt_liquidacion2s_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridsdt_liquidacion2s_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridsdt_liquidacion2s_Class, "") != 0 )
            {
               subGridsdt_liquidacion2s_Linesclass = subGridsdt_liquidacion2s_Class+"Odd" ;
            }
         }
         else if ( subGridsdt_liquidacion2s_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridsdt_liquidacion2s_Backstyle = (byte)(0) ;
            subGridsdt_liquidacion2s_Backcolor = subGridsdt_liquidacion2s_Allbackcolor ;
            if ( GXutil.strcmp(subGridsdt_liquidacion2s_Class, "") != 0 )
            {
               subGridsdt_liquidacion2s_Linesclass = subGridsdt_liquidacion2s_Class+"Uniform" ;
            }
         }
         else if ( subGridsdt_liquidacion2s_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridsdt_liquidacion2s_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridsdt_liquidacion2s_Class, "") != 0 )
            {
               subGridsdt_liquidacion2s_Linesclass = subGridsdt_liquidacion2s_Class+"Odd" ;
            }
            subGridsdt_liquidacion2s_Backcolor = (int)(0x0) ;
         }
         else if ( subGridsdt_liquidacion2s_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridsdt_liquidacion2s_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_197_idx) % (2))) == 0 )
            {
               subGridsdt_liquidacion2s_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdt_liquidacion2s_Class, "") != 0 )
               {
                  subGridsdt_liquidacion2s_Linesclass = subGridsdt_liquidacion2s_Class+"Even" ;
               }
            }
            else
            {
               subGridsdt_liquidacion2s_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdt_liquidacion2s_Class, "") != 0 )
               {
                  subGridsdt_liquidacion2s_Linesclass = subGridsdt_liquidacion2s_Class+"Odd" ;
               }
            }
         }
         if ( Gridsdt_liquidacion2sContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_197_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Gridsdt_liquidacion2sContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridsdt_liquidacion2sRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdt_liquidacion2__liqnro_Internalname,GXutil.ltrim( localUtil.ntoc( ((web.Sdtsdt_liquidacion2_sdt_liquidacion2Item)AV192sdt_liquidacion2.elementAt(-1+AV220GXV1)).getgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro(), (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavSdt_liquidacion2__liqnro_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((web.Sdtsdt_liquidacion2_sdt_liquidacion2Item)AV192sdt_liquidacion2.elementAt(-1+AV220GXV1)).getgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro()), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((web.Sdtsdt_liquidacion2_sdt_liquidacion2Item)AV192sdt_liquidacion2.elementAt(-1+AV220GXV1)).getgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro()), "ZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdt_liquidacion2__liqnro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavSdt_liquidacion2__liqnro_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(197),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridsdt_liquidacion2sContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridsdt_liquidacion2sRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdt_liquidacion2__liqnombre_Internalname,((web.Sdtsdt_liquidacion2_sdt_liquidacion2Item)AV192sdt_liquidacion2.elementAt(-1+AV220GXV1)).getgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdt_liquidacion2__liqnombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdt_liquidacion2__liqnombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(197),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Gridsdt_liquidacion2sContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 200,'',false,'"+sGXsfl_197_idx+"',197)\"" : " ") ;
         ROClassString = "GridAction" ;
         Gridsdt_liquidacion2sRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV193VerSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,200);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVVERSVG.CLICK."+sGXsfl_197_idx+"'","","","","",edtavVersvg_Jsonclick,Integer.valueOf(5),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(-1),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(197),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesH63( ) ;
         Gridsdt_liquidacion2sContainer.AddRow(Gridsdt_liquidacion2sRow);
         nGXsfl_197_idx = ((subGridsdt_liquidacion2s_Islastpage==1)&&(nGXsfl_197_idx+1>subgridsdt_liquidacion2s_fnc_recordsperpage( )) ? 1 : nGXsfl_197_idx+1) ;
         sGXsfl_197_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_197_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1973( ) ;
      }
      /* End function sendrow_1973 */
   }

   public void startgridcontrol138( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"138\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "GridWithTotalizer GridWithPaginationBar WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavEliminardetalle_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbDTipoConCod.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDClasifAux_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Clasificación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDConCodigo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDConDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDValUni_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDCanti_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDImpReCalcu_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Importe", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDReFormulaHTML_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fórmula", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDErrorDesc_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Error", "")) ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDLogRecal_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Log", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavInfooriginal_Class+" "+((GXutil.strcmp(edtavInfooriginal_gximage, "")==0) ? "" : "GX_Image_"+edtavInfooriginal_gximage+"_Class")+"\" "+" style=\""+((edtavInfooriginal_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
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
         GridContainer.AddObjectProperty("Class", "GridWithTotalizer GridWithPaginationBar WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV24EliminarDetalle));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavEliminardetalle_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminardetalle_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A464DTipoConCod));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbDTipoConCod.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2149LiqDClasifAux);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDClasifAux_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A394DConCodigo));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtDConCodigo_Columnclass));
         GridColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( edtDConCodigo_Columnheaderclass));
         GridColumn.AddObjectProperty("Fontbold", GXutil.ltrim( localUtil.ntoc( edtDConCodigo_Fontbold, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDConCodigo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A393DConDescrip);
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtDConDescrip_Columnclass));
         GridColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( edtDConDescrip_Columnheaderclass));
         GridColumn.AddObjectProperty("Fontbold", GXutil.ltrim( localUtil.ntoc( edtDConDescrip_Fontbold, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtDConDescrip_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDConDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A277LiqDValUni, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDValUni_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A269LiqDCanti, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Fontbold", GXutil.ltrim( localUtil.ntoc( edtLiqDCanti_Fontbold, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDCanti_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A276LiqDImporte, (byte)(17), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A764LiqDImpReCalcu, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtLiqDImpReCalcu_Columnclass));
         GridColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( edtLiqDImpReCalcu_Columnheaderclass));
         GridColumn.AddObjectProperty("Fontbold", GXutil.ltrim( localUtil.ntoc( edtLiqDImpReCalcu_Fontbold, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtLiqDImpReCalcu_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDImpReCalcu_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A876LiqDReFormulaHTML);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDReFormulaHTML_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A270LiqDErrorDesc);
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtLiqDErrorDesc_Columnclass));
         GridColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( edtLiqDErrorDesc_Columnheaderclass));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDErrorDesc_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A502LiqDMostrar, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A471DConOrden, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A81LiqDSecuencial, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1072LiqDLogRecal);
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtLiqDLogRecal_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDLogRecal_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1469LiqDSeg, (byte)(5), (byte)(3), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", httpContext.convertURL( AV40InfoOriginal));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavInfooriginal_Class));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavInfooriginal_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavInfooriginal_Visible, (byte)(5), (byte)(0), ".", "")));
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

   public void startgridcontrol197( )
   {
      if ( Gridsdt_liquidacion2sContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Gridsdt_liquidacion2sContainer"+"DivS\" data-gxgridid=\"197\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridsdt_liquidacion2s_Internalname, subGridsdt_liquidacion2s_Internalname, "", "GridWithPaginationBar WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridsdt_liquidacion2s_Backcolorstyle == 0 )
         {
            subGridsdt_liquidacion2s_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridsdt_liquidacion2s_Class) > 0 )
            {
               subGridsdt_liquidacion2s_Linesclass = subGridsdt_liquidacion2s_Class+"Title" ;
            }
         }
         else
         {
            subGridsdt_liquidacion2s_Titlebackstyle = (byte)(1) ;
            if ( subGridsdt_liquidacion2s_Backcolorstyle == 1 )
            {
               subGridsdt_liquidacion2s_Titlebackcolor = subGridsdt_liquidacion2s_Allbackcolor ;
               if ( GXutil.len( subGridsdt_liquidacion2s_Class) > 0 )
               {
                  subGridsdt_liquidacion2s_Linesclass = subGridsdt_liquidacion2s_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridsdt_liquidacion2s_Class) > 0 )
               {
                  subGridsdt_liquidacion2s_Linesclass = subGridsdt_liquidacion2s_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liquidacion", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liquidación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Gridsdt_liquidacion2sContainer.AddObjectProperty("GridName", "Gridsdt_liquidacion2s");
      }
      else
      {
         Gridsdt_liquidacion2sContainer.AddObjectProperty("GridName", "Gridsdt_liquidacion2s");
         Gridsdt_liquidacion2sContainer.AddObjectProperty("Header", subGridsdt_liquidacion2s_Header);
         Gridsdt_liquidacion2sContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
         Gridsdt_liquidacion2sContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Gridsdt_liquidacion2sContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Gridsdt_liquidacion2sContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdt_liquidacion2s_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Gridsdt_liquidacion2sContainer.AddObjectProperty("CmpContext", "");
         Gridsdt_liquidacion2sContainer.AddObjectProperty("InMasterPage", "false");
         Gridsdt_liquidacion2sColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridsdt_liquidacion2sColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdt_liquidacion2__liqnro_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridsdt_liquidacion2sContainer.AddColumnProperties(Gridsdt_liquidacion2sColumn);
         Gridsdt_liquidacion2sColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridsdt_liquidacion2sColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdt_liquidacion2__liqnombre_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridsdt_liquidacion2sContainer.AddColumnProperties(Gridsdt_liquidacion2sColumn);
         Gridsdt_liquidacion2sColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridsdt_liquidacion2sColumn.AddObjectProperty("Value", GXutil.rtrim( AV193VerSVG));
         Gridsdt_liquidacion2sColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         Gridsdt_liquidacion2sColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridsdt_liquidacion2sColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         Gridsdt_liquidacion2sContainer.AddColumnProperties(Gridsdt_liquidacion2sColumn);
         Gridsdt_liquidacion2sContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsdt_liquidacion2s_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Gridsdt_liquidacion2sContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsdt_liquidacion2s_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Gridsdt_liquidacion2sContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsdt_liquidacion2s_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Gridsdt_liquidacion2sContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsdt_liquidacion2s_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Gridsdt_liquidacion2sContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsdt_liquidacion2s_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Gridsdt_liquidacion2sContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsdt_liquidacion2s_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Gridsdt_liquidacion2sContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsdt_liquidacion2s_Collapsed, (byte)(1), (byte)(0), ".", "")));
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
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      cmbavMostrar.setInternalname( "vMOSTRAR" );
      bttBtnactiongroup2_Internalname = "BTNACTIONGROUP2" ;
      lblButtonexport1_textblock_svg_Internalname = "BUTTONEXPORT1_TEXTBLOCK_SVG" ;
      divButtonexport1_table_svg_Internalname = "BUTTONEXPORT1_TABLE_SVG" ;
      lblButtonexport1_textblock_texto_Internalname = "BUTTONEXPORT1_TEXTBLOCK_TEXTO" ;
      divButtonexport1_table_texto_Internalname = "BUTTONEXPORT1_TABLE_TEXTO" ;
      Buttonexport1_a3lexport_Internalname = "BUTTONEXPORT1_A3LEXPORT" ;
      divButtonexport1_tablecontentbuttonimport_Internalname = "BUTTONEXPORT1_TABLECONTENTBUTTONIMPORT" ;
      Ddo_gridcolumnsselector_Internalname = "DDO_GRIDCOLUMNSSELECTOR" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      bttBtnreliquidar_Internalname = "BTNRELIQUIDAR" ;
      bttBtnexport_Internalname = "BTNEXPORT" ;
      lblButtonfilters1_textblock_svg_Internalname = "BUTTONFILTERS1_TEXTBLOCK_SVG" ;
      divButtonfilters1_table_svg_Internalname = "BUTTONFILTERS1_TABLE_SVG" ;
      lblButtonfilters1_textblock_texto_Internalname = "BUTTONFILTERS1_TEXTBLOCK_TEXTO" ;
      divButtonfilters1_table_texto_Internalname = "BUTTONFILTERS1_TABLE_TEXTO" ;
      lblButtonfilter1_textblockbadgecount_Internalname = "BUTTONFILTER1_TEXTBLOCKBADGECOUNT" ;
      tblButtonfilter1_tablebadge_Internalname = "BUTTONFILTER1_TABLEBADGE" ;
      divButtonfilters1_filtros_Internalname = "BUTTONFILTERS1_FILTROS" ;
      Buttonfilter1_a3lfilter_Internalname = "BUTTONFILTER1_A3LFILTER" ;
      divButtonfilter1_tablecontent_Internalname = "BUTTONFILTER1_TABLECONTENT" ;
      divTableactions_Internalname = "TABLEACTIONS" ;
      divTableheadercontent_Internalname = "TABLEHEADERCONTENT" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      lblTextblock1_Internalname = "TEXTBLOCK1" ;
      edtavLiqlegimptotremu_Internalname = "vLIQLEGIMPTOTREMU" ;
      divTableremu_Internalname = "TABLEREMU" ;
      lblTextblock2_Internalname = "TEXTBLOCK2" ;
      edtavLiqlegimptotnoremu_Internalname = "vLIQLEGIMPTOTNOREMU" ;
      divTablenoremu_Internalname = "TABLENOREMU" ;
      lblTextblock3_Internalname = "TEXTBLOCK3" ;
      edtavLiqlegimptotdescu_Internalname = "vLIQLEGIMPTOTDESCU" ;
      divTabledesc_Internalname = "TABLEDESC" ;
      lblTextblock4_Internalname = "TEXTBLOCK4" ;
      edtavLiqlegimptotal_Internalname = "vLIQLEGIMPTOTAL" ;
      divTableneto_Internalname = "TABLENETO" ;
      divTabletotales_Internalname = "TABLETOTALES" ;
      edtavEliminardetalle_Internalname = "vELIMINARDETALLE" ;
      cmbDTipoConCod.setInternalname( "DTIPOCONCOD" );
      edtLiqDClasifAux_Internalname = "LIQDCLASIFAUX" ;
      edtDConCodigo_Internalname = "DCONCODIGO" ;
      edtDConDescrip_Internalname = "DCONDESCRIP" ;
      edtLiqDValUni_Internalname = "LIQDVALUNI" ;
      edtLiqDCanti_Internalname = "LIQDCANTI" ;
      edtLiqDImporte_Internalname = "LIQDIMPORTE" ;
      edtLiqDImpReCalcu_Internalname = "LIQDIMPRECALCU" ;
      edtLiqDReFormulaHTML_Internalname = "LIQDREFORMULAHTML" ;
      edtLiqDErrorDesc_Internalname = "LIQDERRORDESC" ;
      cmbLiqDMostrar.setInternalname( "LIQDMOSTRAR" );
      edtDConOrden_Internalname = "DCONORDEN" ;
      edtLiqDSecuencial_Internalname = "LIQDSECUENCIAL" ;
      edtLiqDLogRecal_Internalname = "LIQDLOGRECAL" ;
      edtLiqDSeg_Internalname = "LIQDSEG" ;
      edtavInfooriginal_Internalname = "vINFOORIGINAL" ;
      edtavTotvalueliqdimprecalcu_Internalname = "vTOTVALUELIQDIMPRECALCU" ;
      tblGridtabletotalizer_Internalname = "GRIDTABLETOTALIZER" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      Innewwindow1_Internalname = "INNEWWINDOW1" ;
      edtavSdt_liquidacion2__liqnro_Internalname = "SDT_LIQUIDACION2__LIQNRO" ;
      edtavSdt_liquidacion2__liqnombre_Internalname = "SDT_LIQUIDACION2__LIQNOMBRE" ;
      edtavVersvg_Internalname = "vVERSVG" ;
      Gridsdt_liquidacion2spaginationbar_Internalname = "GRIDSDT_LIQUIDACION2SPAGINATIONBAR" ;
      divGridsdt_liquidacion2stablewithpaginationbar_Internalname = "GRIDSDT_LIQUIDACION2STABLEWITHPAGINATIONBAR" ;
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      grpUnnamedgroup2_Internalname = "UNNAMEDGROUP2" ;
      tblTableretro_Internalname = "TABLERETRO" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_actiongroup2_Internalname = "DDO_ACTIONGROUP2" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Dvelop_confirmpanel_eliminardetalle_Internalname = "DVELOP_CONFIRMPANEL_ELIMINARDETALLE" ;
      tblTabledvelop_confirmpanel_eliminardetalle_Internalname = "TABLEDVELOP_CONFIRMPANEL_ELIMINARDETALLE" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      Gridsdt_liquidacion2s_empowerer_Internalname = "GRIDSDT_LIQUIDACION2S_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
      subGridsdt_liquidacion2s_Internalname = "GRIDSDT_LIQUIDACION2S" ;
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
      subGridsdt_liquidacion2s_Allowcollapsing = (byte)(0) ;
      subGridsdt_liquidacion2s_Allowselection = (byte)(0) ;
      subGridsdt_liquidacion2s_Header = "" ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Header = "" ;
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Visible = -1 ;
      edtavVersvg_Enabled = 1 ;
      edtavVersvg_Format = (short)(0) ;
      edtavSdt_liquidacion2__liqnombre_Jsonclick = "" ;
      edtavSdt_liquidacion2__liqnombre_Enabled = 0 ;
      edtavSdt_liquidacion2__liqnro_Jsonclick = "" ;
      edtavSdt_liquidacion2__liqnro_Enabled = 0 ;
      subGridsdt_liquidacion2s_Class = "GridWithPaginationBar WorkWith" ;
      subGridsdt_liquidacion2s_Backcolorstyle = (byte)(0) ;
      edtavInfooriginal_Jsonclick = "" ;
      edtavInfooriginal_gximage = "" ;
      edtavInfooriginal_Class = "rotate180" ;
      edtavInfooriginal_Enabled = 1 ;
      edtavInfooriginal_Tooltiptext = httpContext.getMessage( "Se recalculó el importe por novedad. (Este ícono debería ser una \"I\" de info...) ", "") ;
      edtLiqDSeg_Jsonclick = "" ;
      edtLiqDLogRecal_Jsonclick = "" ;
      edtLiqDLogRecal_Tooltiptext = "" ;
      edtLiqDSecuencial_Jsonclick = "" ;
      edtDConOrden_Jsonclick = "" ;
      cmbLiqDMostrar.setJsonclick( "" );
      edtLiqDErrorDesc_Jsonclick = "" ;
      edtLiqDErrorDesc_Columnclass = "WWColumn" ;
      edtLiqDReFormulaHTML_Jsonclick = "" ;
      edtLiqDImpReCalcu_Jsonclick = "" ;
      edtLiqDImpReCalcu_Columnclass = "WWColumn" ;
      edtLiqDImpReCalcu_Fontbold = (byte)(0) ;
      edtLiqDImpReCalcu_Tooltiptext = "" ;
      edtLiqDImporte_Jsonclick = "" ;
      edtLiqDCanti_Jsonclick = "" ;
      edtLiqDCanti_Fontbold = (byte)(0) ;
      edtLiqDValUni_Jsonclick = "" ;
      edtDConDescrip_Jsonclick = "" ;
      edtDConDescrip_Columnclass = "WWColumn" ;
      edtDConDescrip_Fontbold = (byte)(0) ;
      edtDConDescrip_Tooltiptext = "" ;
      edtDConCodigo_Jsonclick = "" ;
      edtDConCodigo_Columnclass = "WWColumn" ;
      edtDConCodigo_Fontbold = (byte)(0) ;
      edtLiqDClasifAux_Jsonclick = "" ;
      cmbDTipoConCod.setJsonclick( "" );
      edtavEliminardetalle_Jsonclick = "" ;
      edtavEliminardetalle_Class = "Attribute" ;
      edtavEliminardetalle_Visible = -1 ;
      edtavEliminardetalle_Enabled = 1 ;
      subGrid_Class = "GridWithTotalizer GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtavTotvalueliqdimprecalcu_Jsonclick = "" ;
      edtavTotvalueliqdimprecalcu_Enabled = 1 ;
      edtavInfooriginal_Visible = -1 ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      edtLiqDErrorDesc_Columnheaderclass = "" ;
      edtLiqDImpReCalcu_Columnheaderclass = "" ;
      edtDConDescrip_Columnheaderclass = "" ;
      edtDConCodigo_Columnheaderclass = "" ;
      edtLiqDLogRecal_Visible = -1 ;
      edtLiqDErrorDesc_Visible = -1 ;
      edtLiqDReFormulaHTML_Visible = -1 ;
      edtLiqDImpReCalcu_Visible = -1 ;
      edtLiqDCanti_Visible = -1 ;
      edtLiqDValUni_Visible = -1 ;
      edtDConDescrip_Visible = -1 ;
      edtDConCodigo_Visible = -1 ;
      edtLiqDClasifAux_Visible = -1 ;
      cmbDTipoConCod.setVisible( -1 );
      tblTableretro_Visible = 1 ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      edtavSdt_liquidacion2__liqnombre_Enabled = -1 ;
      edtavSdt_liquidacion2__liqnro_Enabled = -1 ;
      edtavLiqlegimptotal_Jsonclick = "" ;
      edtavLiqlegimptotal_Enabled = 1 ;
      edtavLiqlegimptotdescu_Jsonclick = "" ;
      edtavLiqlegimptotdescu_Enabled = 1 ;
      edtavLiqlegimptotnoremu_Jsonclick = "" ;
      edtavLiqlegimptotnoremu_Enabled = 1 ;
      edtavLiqlegimptotremu_Jsonclick = "" ;
      edtavLiqlegimptotremu_Enabled = 1 ;
      divButtonfilter1_tablecontent_Visible = 1 ;
      bttBtnexport_Visible = 1 ;
      bttBtnreliquidar_Visible = 1 ;
      cmbavMostrar.setJsonclick( "" );
      cmbavMostrar.setEnabled( 1 );
      lblTextblocktitle_Caption = httpContext.getMessage( "Conceptos de Legajo X, Liquidacion X", "") ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Dvelop_confirmpanel_eliminardetalle_Confirmtype = "1" ;
      Dvelop_confirmpanel_eliminardetalle_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_eliminardetalle_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_eliminardetalle_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_eliminardetalle_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_eliminardetalle_Confirmationtext = "¿Está seguro de Eliminar el registro?" ;
      Dvelop_confirmpanel_eliminardetalle_Title = "" ;
      Ddo_grid_Format = "||||-14.2|-14.2||" ;
      Ddo_grid_Datalistproc = "LiquidacionVerDetalle2GetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "REM_ARG:Remunerativo,NRE_ARG:No Remunerativo,DES_ARG:Retención,CAL_ARG:Cálculo|||||||" ;
      Ddo_grid_Allowmultipleselection = "T|T|T|T|||T|" ;
      Ddo_grid_Datalisttype = "FixedValues|Dynamic|Dynamic|Dynamic|||Dynamic|" ;
      Ddo_grid_Includedatalist = "T|T|T|T|||T|" ;
      Ddo_grid_Filterisrange = "||||T|T||" ;
      Ddo_grid_Filtertype = "|Character|Character|Character|Numeric|Numeric|Character|" ;
      Ddo_grid_Includefilter = "|T|T|T|T|T|T|" ;
      Ddo_grid_Fixable = "|T|||T|||T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T|T||T" ;
      Ddo_grid_Columnssortvalues = "2|3|4|5|6|7||8" ;
      Ddo_grid_Columnids = "1:DTipoConCod|2:LiqDClasifAux|3:DConCodigo|4:DConDescrip|5:LiqDValUni|8:LiqDImpReCalcu|10:LiqDErrorDesc|14:LiqDLogRecal" ;
      Ddo_grid_Gridinternalname = "" ;
      Ddo_actiongroup2_Titlecontrolidtoreplace = "" ;
      Ddo_actiongroup2_Cls = "ColumnsSelector" ;
      Ddo_actiongroup2_Icon = "fa fa-print fa fa-print" ;
      Ddo_actiongroup2_Icontype = "FontIcon" ;
      Gridsdt_liquidacion2spaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridsdt_liquidacion2spaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridsdt_liquidacion2spaginationbar_Caption = httpContext.getMessage( "WWP_PagingCaption", "") ;
      Gridsdt_liquidacion2spaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridsdt_liquidacion2spaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridsdt_liquidacion2spaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridsdt_liquidacion2spaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridsdt_liquidacion2spaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridsdt_liquidacion2spaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridsdt_liquidacion2spaginationbar_Pagingcaptionposition = "Left" ;
      Gridsdt_liquidacion2spaginationbar_Pagingbuttonsposition = "Right" ;
      Gridsdt_liquidacion2spaginationbar_Pagestoshow = 5 ;
      Gridsdt_liquidacion2spaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridsdt_liquidacion2spaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridsdt_liquidacion2spaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridsdt_liquidacion2spaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridsdt_liquidacion2spaginationbar_Class = "PaginationBar" ;
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
      Ddo_managefilters_Cls = "ManageFilters" ;
      Ddo_managefilters_Tooltip = "WWP_ManageFiltersTooltip" ;
      Ddo_managefilters_Icon = "fas fa-filter" ;
      Ddo_managefilters_Icontype = "FontIcon" ;
      Ddo_gridcolumnsselector_Dropdownoptionstype = "GridColumnsSelector" ;
      Ddo_gridcolumnsselector_Cls = "ColumnsSelector" ;
      Ddo_gridcolumnsselector_Tooltip = "WWP_EditColumnsTooltip" ;
      Ddo_gridcolumnsselector_Caption = httpContext.getMessage( "WWP_EditColumnsCaption", "") ;
      Ddo_gridcolumnsselector_Icon = "fas fa-cog" ;
      Ddo_gridcolumnsselector_Icontype = "FontIcon" ;
      Buttonexport1_a3lexport_Boton_orig_id = "" ;
      Buttonexport1_a3lexport_Boton_clon_id = "" ;
      Buttonexport1_a3lexport_Observer = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Conceptos de la Liquidación", "") );
      subGridsdt_liquidacion2s_Rows = 0 ;
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
      AV200WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV200WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV200WelcomeMessage_NoMostrarMas", AV200WelcomeMessage_NoMostrarMas);
      cmbavMostrar.setName( "vMOSTRAR" );
      cmbavMostrar.setWebtags( "" );
      cmbavMostrar.addItem("RECIBO", httpContext.getMessage( "Conceptos del recibo", ""), (short)(0));
      cmbavMostrar.addItem("TODOS", httpContext.getMessage( "Todos", ""), (short)(0));
      if ( cmbavMostrar.getItemCount() > 0 )
      {
         AV62Mostrar = cmbavMostrar.getValidValue(AV62Mostrar) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV62Mostrar", AV62Mostrar);
      }
      GXCCtl = "DTIPOCONCOD_" + sGXsfl_138_idx ;
      cmbDTipoConCod.setName( GXCCtl );
      cmbDTipoConCod.setWebtags( "" );
      cmbDTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbDTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbDTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbDTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbDTipoConCod.getItemCount() > 0 )
      {
         A464DTipoConCod = cmbDTipoConCod.getValidValue(A464DTipoConCod) ;
      }
      GXCCtl = "LIQDMOSTRAR_" + sGXsfl_138_idx ;
      cmbLiqDMostrar.setName( GXCCtl );
      cmbLiqDMostrar.setWebtags( "" );
      cmbLiqDMostrar.addItem("3", httpContext.getMessage( "Conceptos del recibo", ""), (short)(0));
      cmbLiqDMostrar.addItem("2", httpContext.getMessage( "Conceptos del recibo más cálculos usados mayores a cero", ""), (short)(0));
      cmbLiqDMostrar.addItem("1", httpContext.getMessage( "Todos", ""), (short)(0));
      if ( cmbLiqDMostrar.getItemCount() > 0 )
      {
         A502LiqDMostrar = (byte)(GXutil.lval( cmbLiqDMostrar.getValidValue(GXutil.trim( GXutil.str( A502LiqDMostrar, 1, 0))))) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage'},{av:'GRIDSDT_LIQUIDACION2S_nEOF'},{av:'subGridsdt_liquidacion2s_Rows',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'Rows'},{av:'AV59ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV15ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavMostrar'},{av:'AV62Mostrar',fld:'vMOSTRAR',pic:''},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV5LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV223Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''},{av:'AV102TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV198TFLiqDClasifAux',fld:'vTFLIQDCLASIFAUX',pic:''},{av:'AV199TFLiqDClasifAux_Sels',fld:'vTFLIQDCLASIFAUX_SELS',pic:''},{av:'AV88TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV89TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV91TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV92TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV147TFLiqDValUni',fld:'vTFLIQDVALUNI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV148TFLiqDValUni_To',fld:'vTFLIQDVALUNI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV134TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV135TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV123TFLiqDErrorDesc',fld:'vTFLIQDERRORDESC',pic:''},{av:'AV124TFLiqDErrorDesc_Sels',fld:'vTFLIQDERRORDESC_SELS',pic:''},{av:'AV188modoTestEs',fld:'vMODOTESTES',pic:'',hsh:true},{av:'AV54LiqEstado',fld:'vLIQESTADO',pic:'9',hsh:true},{av:'AV63OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV65OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV207auxMenuOpcCod',fld:'vAUXMENUOPCCOD',pic:'',hsh:true},{av:'AV179TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:'',hsh:true},{av:'AV180TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:'',hsh:true},{av:'AV18ConVariable',fld:'vCONVARIABLE',pic:'',hsh:true},{av:'AV168TotLiqDImpReCalcu',fld:'vTOTLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV183TotLiqDSeg',fld:'vTOTLIQDSEG',pic:'9.999',hsh:true},{av:'AV167TotLiqDImpCalcu',fld:'vTOTLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV42IsAuthorized_InfoOriginal',fld:'vISAUTHORIZED_INFOORIGINAL',pic:'',hsh:true},{av:'AV211LiqFecImp',fld:'vLIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'AV209sistemaPalabra',fld:'vSISTEMAPALABRA',pic:'',hsh:true},{av:'AV200WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV192sdt_liquidacion2',fld:'vSDT_LIQUIDACION2',grid:197,pic:'',hsh:true},{av:'nGXsfl_197_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:197},{av:'nRC_GXsfl_197',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'GridRC',grid:197},{av:'AV190MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A764LiqDImpReCalcu',fld:'LIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1469LiqDSeg',fld:'LIQDSEG',pic:'9.999'},{av:'cmbDTipoConCod'},{av:'A464DTipoConCod',fld:'DTIPOCONCOD',pic:''},{av:'A275LiqDImpCalcu',fld:'LIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV54LiqEstado',fld:'vLIQESTADO',pic:'9',hsh:true},{av:'AV59ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV15ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'cmbDTipoConCod'},{av:'edtLiqDClasifAux_Visible',ctrl:'LIQDCLASIFAUX',prop:'Visible'},{av:'edtDConCodigo_Visible',ctrl:'DCONCODIGO',prop:'Visible'},{av:'edtDConDescrip_Visible',ctrl:'DCONDESCRIP',prop:'Visible'},{av:'edtLiqDValUni_Visible',ctrl:'LIQDVALUNI',prop:'Visible'},{av:'edtLiqDCanti_Visible',ctrl:'LIQDCANTI',prop:'Visible'},{av:'edtLiqDImpReCalcu_Visible',ctrl:'LIQDIMPRECALCU',prop:'Visible'},{av:'edtLiqDReFormulaHTML_Visible',ctrl:'LIQDREFORMULAHTML',prop:'Visible'},{av:'edtLiqDErrorDesc_Visible',ctrl:'LIQDERRORDESC',prop:'Visible'},{av:'edtLiqDLogRecal_Visible',ctrl:'LIQDLOGRECAL',prop:'Visible'},{av:'AV35GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV36GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV34GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'edtDConCodigo_Columnheaderclass',ctrl:'DCONCODIGO',prop:'Columnheaderclass'},{av:'edtDConDescrip_Columnheaderclass',ctrl:'DCONDESCRIP',prop:'Columnheaderclass'},{av:'edtLiqDImpReCalcu_Columnheaderclass',ctrl:'LIQDIMPRECALCU',prop:'Columnheaderclass'},{av:'edtLiqDErrorDesc_Columnheaderclass',ctrl:'LIQDERRORDESC',prop:'Columnheaderclass'},{av:'AV194Gridsdt_liquidacion2sCurrentPage',fld:'vGRIDSDT_LIQUIDACION2SCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV195Gridsdt_liquidacion2sPageCount',fld:'vGRIDSDT_LIQUIDACION2SPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV42IsAuthorized_InfoOriginal',fld:'vISAUTHORIZED_INFOORIGINAL',pic:'',hsh:true},{av:'edtavInfooriginal_Visible',ctrl:'vINFOORIGINAL',prop:'Visible'},{ctrl:'BTNRELIQUIDAR',prop:'Visible'},{av:'AV58ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''},{av:'AV168TotLiqDImpReCalcu',fld:'vTOTLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV183TotLiqDSeg',fld:'vTOTLIQDSEG',pic:'9.999',hsh:true},{av:'AV171TotValueLiqDImpReCalcu',fld:'vTOTVALUELIQDIMPRECALCU',pic:''},{av:'AV167TotLiqDImpCalcu',fld:'vTOTLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e14H62',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'subGridsdt_liquidacion2s_Rows',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'Rows'},{av:'cmbavMostrar'},{av:'AV62Mostrar',fld:'vMOSTRAR',pic:''},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV5LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV59ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV15ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV223Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''},{av:'AV102TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV198TFLiqDClasifAux',fld:'vTFLIQDCLASIFAUX',pic:''},{av:'AV199TFLiqDClasifAux_Sels',fld:'vTFLIQDCLASIFAUX_SELS',pic:''},{av:'AV88TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV89TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV91TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV92TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV147TFLiqDValUni',fld:'vTFLIQDVALUNI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV148TFLiqDValUni_To',fld:'vTFLIQDVALUNI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV134TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV135TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV123TFLiqDErrorDesc',fld:'vTFLIQDERRORDESC',pic:''},{av:'AV124TFLiqDErrorDesc_Sels',fld:'vTFLIQDERRORDESC_SELS',pic:''},{av:'AV188modoTestEs',fld:'vMODOTESTES',pic:'',hsh:true},{av:'AV54LiqEstado',fld:'vLIQESTADO',pic:'9',hsh:true},{av:'AV63OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV65OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV207auxMenuOpcCod',fld:'vAUXMENUOPCCOD',pic:'',hsh:true},{av:'AV179TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:'',hsh:true},{av:'AV180TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:'',hsh:true},{av:'AV18ConVariable',fld:'vCONVARIABLE',pic:'',hsh:true},{av:'AV168TotLiqDImpReCalcu',fld:'vTOTLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV183TotLiqDSeg',fld:'vTOTLIQDSEG',pic:'9.999',hsh:true},{av:'AV167TotLiqDImpCalcu',fld:'vTOTLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV42IsAuthorized_InfoOriginal',fld:'vISAUTHORIZED_INFOORIGINAL',pic:'',hsh:true},{av:'AV211LiqFecImp',fld:'vLIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'AV209sistemaPalabra',fld:'vSISTEMAPALABRA',pic:'',hsh:true},{av:'AV200WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV192sdt_liquidacion2',fld:'vSDT_LIQUIDACION2',grid:197,pic:'',hsh:true},{av:'nGXsfl_197_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:197},{av:'GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage'},{av:'nRC_GXsfl_197',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'GridRC',grid:197},{av:'AV190MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e15H62',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'subGridsdt_liquidacion2s_Rows',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'Rows'},{av:'cmbavMostrar'},{av:'AV62Mostrar',fld:'vMOSTRAR',pic:''},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV5LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV59ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV15ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV223Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''},{av:'AV102TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV198TFLiqDClasifAux',fld:'vTFLIQDCLASIFAUX',pic:''},{av:'AV199TFLiqDClasifAux_Sels',fld:'vTFLIQDCLASIFAUX_SELS',pic:''},{av:'AV88TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV89TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV91TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV92TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV147TFLiqDValUni',fld:'vTFLIQDVALUNI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV148TFLiqDValUni_To',fld:'vTFLIQDVALUNI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV134TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV135TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV123TFLiqDErrorDesc',fld:'vTFLIQDERRORDESC',pic:''},{av:'AV124TFLiqDErrorDesc_Sels',fld:'vTFLIQDERRORDESC_SELS',pic:''},{av:'AV188modoTestEs',fld:'vMODOTESTES',pic:'',hsh:true},{av:'AV54LiqEstado',fld:'vLIQESTADO',pic:'9',hsh:true},{av:'AV63OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV65OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV207auxMenuOpcCod',fld:'vAUXMENUOPCCOD',pic:'',hsh:true},{av:'AV179TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:'',hsh:true},{av:'AV180TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:'',hsh:true},{av:'AV18ConVariable',fld:'vCONVARIABLE',pic:'',hsh:true},{av:'AV168TotLiqDImpReCalcu',fld:'vTOTLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV183TotLiqDSeg',fld:'vTOTLIQDSEG',pic:'9.999',hsh:true},{av:'AV167TotLiqDImpCalcu',fld:'vTOTLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV42IsAuthorized_InfoOriginal',fld:'vISAUTHORIZED_INFOORIGINAL',pic:'',hsh:true},{av:'AV211LiqFecImp',fld:'vLIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'AV209sistemaPalabra',fld:'vSISTEMAPALABRA',pic:'',hsh:true},{av:'AV200WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV192sdt_liquidacion2',fld:'vSDT_LIQUIDACION2',grid:197,pic:'',hsh:true},{av:'nGXsfl_197_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:197},{av:'GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage'},{av:'nRC_GXsfl_197',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'GridRC',grid:197},{av:'AV190MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e19H62',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'subGridsdt_liquidacion2s_Rows',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'Rows'},{av:'cmbavMostrar'},{av:'AV62Mostrar',fld:'vMOSTRAR',pic:''},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV5LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV59ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV15ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV223Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''},{av:'AV102TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV198TFLiqDClasifAux',fld:'vTFLIQDCLASIFAUX',pic:''},{av:'AV199TFLiqDClasifAux_Sels',fld:'vTFLIQDCLASIFAUX_SELS',pic:''},{av:'AV88TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV89TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV91TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV92TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV147TFLiqDValUni',fld:'vTFLIQDVALUNI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV148TFLiqDValUni_To',fld:'vTFLIQDVALUNI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV134TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV135TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV123TFLiqDErrorDesc',fld:'vTFLIQDERRORDESC',pic:''},{av:'AV124TFLiqDErrorDesc_Sels',fld:'vTFLIQDERRORDESC_SELS',pic:''},{av:'AV188modoTestEs',fld:'vMODOTESTES',pic:'',hsh:true},{av:'AV54LiqEstado',fld:'vLIQESTADO',pic:'9',hsh:true},{av:'AV63OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV65OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV207auxMenuOpcCod',fld:'vAUXMENUOPCCOD',pic:'',hsh:true},{av:'AV179TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:'',hsh:true},{av:'AV180TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:'',hsh:true},{av:'AV18ConVariable',fld:'vCONVARIABLE',pic:'',hsh:true},{av:'AV168TotLiqDImpReCalcu',fld:'vTOTLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV183TotLiqDSeg',fld:'vTOTLIQDSEG',pic:'9.999',hsh:true},{av:'AV167TotLiqDImpCalcu',fld:'vTOTLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV42IsAuthorized_InfoOriginal',fld:'vISAUTHORIZED_INFOORIGINAL',pic:'',hsh:true},{av:'AV211LiqFecImp',fld:'vLIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'AV209sistemaPalabra',fld:'vSISTEMAPALABRA',pic:'',hsh:true},{av:'AV200WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV192sdt_liquidacion2',fld:'vSDT_LIQUIDACION2',grid:197,pic:'',hsh:true},{av:'nGXsfl_197_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:197},{av:'GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage'},{av:'nRC_GXsfl_197',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'GridRC',grid:197},{av:'AV190MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'AV125TFLiqDErrorDesc_SelsJson',fld:'vTFLIQDERRORDESC_SELSJSON',pic:''}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV63OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV65OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV123TFLiqDErrorDesc',fld:'vTFLIQDERRORDESC',pic:''},{av:'AV125TFLiqDErrorDesc_SelsJson',fld:'vTFLIQDERRORDESC_SELSJSON',pic:''},{av:'AV124TFLiqDErrorDesc_Sels',fld:'vTFLIQDERRORDESC_SELS',pic:''},{av:'AV134TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV135TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV147TFLiqDValUni',fld:'vTFLIQDVALUNI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV148TFLiqDValUni_To',fld:'vTFLIQDVALUNI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV91TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV93TFDConDescrip_SelsJson',fld:'vTFDCONDESCRIP_SELSJSON',pic:''},{av:'AV92TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV88TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV90TFDConCodigo_SelsJson',fld:'vTFDCONCODIGO_SELSJSON',pic:''},{av:'AV89TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV198TFLiqDClasifAux',fld:'vTFLIQDCLASIFAUX',pic:''},{av:'AV197TFLiqDClasifAux_SelsJson',fld:'vTFLIQDCLASIFAUX_SELSJSON',pic:''},{av:'AV199TFLiqDClasifAux_Sels',fld:'vTFLIQDCLASIFAUX_SELS',pic:''},{av:'AV103TFDTipoConCod_SelsJson',fld:'vTFDTIPOCONCOD_SELSJSON',pic:''},{av:'AV102TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e26H62',iparms:[{av:'AV42IsAuthorized_InfoOriginal',fld:'vISAUTHORIZED_INFOORIGINAL',pic:'',hsh:true},{av:'A764LiqDImpReCalcu',fld:'LIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A275LiqDImpCalcu',fld:'LIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A270LiqDErrorDesc',fld:'LIQDERRORDESC',pic:''},{av:'cmbLiqDMostrar'},{av:'A502LiqDMostrar',fld:'LIQDMOSTRAR',pic:'9'},{av:'A504LiqDForOrig',fld:'LIQDFORORIG',pic:''},{av:'A1072LiqDLogRecal',fld:'LIQDLOGRECAL',pic:''},{av:'AV211LiqFecImp',fld:'vLIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A394DConCodigo',fld:'DCONCODIGO',pic:''},{av:'AV209sistemaPalabra',fld:'vSISTEMAPALABRA',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV24EliminarDetalle',fld:'vELIMINARDETALLE',pic:''},{av:'edtavEliminardetalle_Class',ctrl:'vELIMINARDETALLE',prop:'Class'},{av:'AV40InfoOriginal',fld:'vINFOORIGINAL',pic:''},{av:'edtavInfooriginal_Tooltiptext',ctrl:'vINFOORIGINAL',prop:'Tooltiptext'},{av:'edtavInfooriginal_Class',ctrl:'vINFOORIGINAL',prop:'Class'},{av:'edtDConCodigo_Columnclass',ctrl:'DCONCODIGO',prop:'Columnclass'},{av:'edtDConDescrip_Columnclass',ctrl:'DCONDESCRIP',prop:'Columnclass'},{av:'edtLiqDImpReCalcu_Columnclass',ctrl:'LIQDIMPRECALCU',prop:'Columnclass'},{av:'edtLiqDErrorDesc_Columnclass',ctrl:'LIQDERRORDESC',prop:'Columnclass'},{av:'edtDConCodigo_Fontbold',ctrl:'DCONCODIGO',prop:'Fontbold'},{av:'edtDConDescrip_Fontbold',ctrl:'DCONDESCRIP',prop:'Fontbold'},{av:'edtLiqDImpReCalcu_Fontbold',ctrl:'LIQDIMPRECALCU',prop:'Fontbold'},{av:'edtLiqDCanti_Fontbold',ctrl:'LIQDCANTI',prop:'Fontbold'},{av:'edtLiqDImpReCalcu_Tooltiptext',ctrl:'LIQDIMPRECALCU',prop:'Tooltiptext'},{av:'edtLiqDLogRecal_Tooltiptext',ctrl:'LIQDLOGRECAL',prop:'Tooltiptext'},{av:'edtDConDescrip_Tooltiptext',ctrl:'DCONDESCRIP',prop:'Tooltiptext'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e12H62',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'subGridsdt_liquidacion2s_Rows',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'Rows'},{av:'cmbavMostrar'},{av:'AV62Mostrar',fld:'vMOSTRAR',pic:''},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV5LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV59ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV15ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV223Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''},{av:'AV102TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV198TFLiqDClasifAux',fld:'vTFLIQDCLASIFAUX',pic:''},{av:'AV199TFLiqDClasifAux_Sels',fld:'vTFLIQDCLASIFAUX_SELS',pic:''},{av:'AV88TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV89TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV91TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV92TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV147TFLiqDValUni',fld:'vTFLIQDVALUNI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV148TFLiqDValUni_To',fld:'vTFLIQDVALUNI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV134TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV135TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV123TFLiqDErrorDesc',fld:'vTFLIQDERRORDESC',pic:''},{av:'AV124TFLiqDErrorDesc_Sels',fld:'vTFLIQDERRORDESC_SELS',pic:''},{av:'AV188modoTestEs',fld:'vMODOTESTES',pic:'',hsh:true},{av:'AV54LiqEstado',fld:'vLIQESTADO',pic:'9',hsh:true},{av:'AV63OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV65OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV207auxMenuOpcCod',fld:'vAUXMENUOPCCOD',pic:'',hsh:true},{av:'AV179TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:'',hsh:true},{av:'AV180TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:'',hsh:true},{av:'AV18ConVariable',fld:'vCONVARIABLE',pic:'',hsh:true},{av:'AV168TotLiqDImpReCalcu',fld:'vTOTLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV183TotLiqDSeg',fld:'vTOTLIQDSEG',pic:'9.999',hsh:true},{av:'AV167TotLiqDImpCalcu',fld:'vTOTLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV42IsAuthorized_InfoOriginal',fld:'vISAUTHORIZED_INFOORIGINAL',pic:'',hsh:true},{av:'AV211LiqFecImp',fld:'vLIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'AV209sistemaPalabra',fld:'vSISTEMAPALABRA',pic:'',hsh:true},{av:'AV200WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV192sdt_liquidacion2',fld:'vSDT_LIQUIDACION2',grid:197,pic:'',hsh:true},{av:'nGXsfl_197_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:197},{av:'GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage'},{av:'nRC_GXsfl_197',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'GridRC',grid:197},{av:'AV190MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'},{av:'GRIDSDT_LIQUIDACION2S_nEOF'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A764LiqDImpReCalcu',fld:'LIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1469LiqDSeg',fld:'LIQDSEG',pic:'9.999'},{av:'cmbDTipoConCod'},{av:'A464DTipoConCod',fld:'DTIPOCONCOD',pic:''},{av:'A275LiqDImpCalcu',fld:'LIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV15ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV54LiqEstado',fld:'vLIQESTADO',pic:'9',hsh:true},{av:'AV59ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'cmbDTipoConCod'},{av:'edtLiqDClasifAux_Visible',ctrl:'LIQDCLASIFAUX',prop:'Visible'},{av:'edtDConCodigo_Visible',ctrl:'DCONCODIGO',prop:'Visible'},{av:'edtDConDescrip_Visible',ctrl:'DCONDESCRIP',prop:'Visible'},{av:'edtLiqDValUni_Visible',ctrl:'LIQDVALUNI',prop:'Visible'},{av:'edtLiqDCanti_Visible',ctrl:'LIQDCANTI',prop:'Visible'},{av:'edtLiqDImpReCalcu_Visible',ctrl:'LIQDIMPRECALCU',prop:'Visible'},{av:'edtLiqDReFormulaHTML_Visible',ctrl:'LIQDREFORMULAHTML',prop:'Visible'},{av:'edtLiqDErrorDesc_Visible',ctrl:'LIQDERRORDESC',prop:'Visible'},{av:'edtLiqDLogRecal_Visible',ctrl:'LIQDLOGRECAL',prop:'Visible'},{av:'AV35GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV36GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV34GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'edtDConCodigo_Columnheaderclass',ctrl:'DCONCODIGO',prop:'Columnheaderclass'},{av:'edtDConDescrip_Columnheaderclass',ctrl:'DCONDESCRIP',prop:'Columnheaderclass'},{av:'edtLiqDImpReCalcu_Columnheaderclass',ctrl:'LIQDIMPRECALCU',prop:'Columnheaderclass'},{av:'edtLiqDErrorDesc_Columnheaderclass',ctrl:'LIQDERRORDESC',prop:'Columnheaderclass'},{av:'AV194Gridsdt_liquidacion2sCurrentPage',fld:'vGRIDSDT_LIQUIDACION2SCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV195Gridsdt_liquidacion2sPageCount',fld:'vGRIDSDT_LIQUIDACION2SPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV42IsAuthorized_InfoOriginal',fld:'vISAUTHORIZED_INFOORIGINAL',pic:'',hsh:true},{av:'edtavInfooriginal_Visible',ctrl:'vINFOORIGINAL',prop:'Visible'},{ctrl:'BTNRELIQUIDAR',prop:'Visible'},{av:'AV58ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''},{av:'AV168TotLiqDImpReCalcu',fld:'vTOTLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV183TotLiqDSeg',fld:'vTOTLIQDSEG',pic:'9.999',hsh:true},{av:'AV171TotValueLiqDImpReCalcu',fld:'vTOTVALUELIQDIMPRECALCU',pic:''},{av:'AV167TotLiqDImpCalcu',fld:'vTOTLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e13H62',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'subGridsdt_liquidacion2s_Rows',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'Rows'},{av:'cmbavMostrar'},{av:'AV62Mostrar',fld:'vMOSTRAR',pic:''},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV5LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV59ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV15ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV223Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''},{av:'AV102TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV198TFLiqDClasifAux',fld:'vTFLIQDCLASIFAUX',pic:''},{av:'AV199TFLiqDClasifAux_Sels',fld:'vTFLIQDCLASIFAUX_SELS',pic:''},{av:'AV88TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV89TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV91TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV92TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV147TFLiqDValUni',fld:'vTFLIQDVALUNI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV148TFLiqDValUni_To',fld:'vTFLIQDVALUNI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV134TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV135TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV123TFLiqDErrorDesc',fld:'vTFLIQDERRORDESC',pic:''},{av:'AV124TFLiqDErrorDesc_Sels',fld:'vTFLIQDERRORDESC_SELS',pic:''},{av:'AV188modoTestEs',fld:'vMODOTESTES',pic:'',hsh:true},{av:'AV54LiqEstado',fld:'vLIQESTADO',pic:'9',hsh:true},{av:'AV63OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV65OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV207auxMenuOpcCod',fld:'vAUXMENUOPCCOD',pic:'',hsh:true},{av:'AV179TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:'',hsh:true},{av:'AV180TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:'',hsh:true},{av:'AV18ConVariable',fld:'vCONVARIABLE',pic:'',hsh:true},{av:'AV168TotLiqDImpReCalcu',fld:'vTOTLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV183TotLiqDSeg',fld:'vTOTLIQDSEG',pic:'9.999',hsh:true},{av:'AV167TotLiqDImpCalcu',fld:'vTOTLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV42IsAuthorized_InfoOriginal',fld:'vISAUTHORIZED_INFOORIGINAL',pic:'',hsh:true},{av:'AV211LiqFecImp',fld:'vLIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'AV209sistemaPalabra',fld:'vSISTEMAPALABRA',pic:'',hsh:true},{av:'AV200WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV192sdt_liquidacion2',fld:'vSDT_LIQUIDACION2',grid:197,pic:'',hsh:true},{av:'nGXsfl_197_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:197},{av:'GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage'},{av:'nRC_GXsfl_197',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'GridRC',grid:197},{av:'AV190MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV103TFDTipoConCod_SelsJson',fld:'vTFDTIPOCONCOD_SELSJSON',pic:''},{av:'AV197TFLiqDClasifAux_SelsJson',fld:'vTFLIQDCLASIFAUX_SELSJSON',pic:''},{av:'AV90TFDConCodigo_SelsJson',fld:'vTFDCONCODIGO_SELSJSON',pic:''},{av:'AV93TFDConDescrip_SelsJson',fld:'vTFDCONDESCRIP_SELSJSON',pic:''},{av:'AV125TFLiqDErrorDesc_SelsJson',fld:'vTFLIQDERRORDESC_SELSJSON',pic:''},{av:'GRIDSDT_LIQUIDACION2S_nEOF'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A764LiqDImpReCalcu',fld:'LIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1469LiqDSeg',fld:'LIQDSEG',pic:'9.999'},{av:'cmbDTipoConCod'},{av:'A464DTipoConCod',fld:'DTIPOCONCOD',pic:''},{av:'A275LiqDImpCalcu',fld:'LIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV59ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''},{av:'AV63OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV65OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'cmbavMostrar'},{av:'AV62Mostrar',fld:'vMOSTRAR',pic:''},{av:'AV198TFLiqDClasifAux',fld:'vTFLIQDCLASIFAUX',pic:''},{av:'AV199TFLiqDClasifAux_Sels',fld:'vTFLIQDCLASIFAUX_SELS',pic:''},{av:'AV102TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV88TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV89TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV91TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV92TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV147TFLiqDValUni',fld:'vTFLIQDVALUNI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV148TFLiqDValUni_To',fld:'vTFLIQDVALUNI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV134TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV135TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV123TFLiqDErrorDesc',fld:'vTFLIQDERRORDESC',pic:''},{av:'AV124TFLiqDErrorDesc_Sels',fld:'vTFLIQDERRORDESC_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV125TFLiqDErrorDesc_SelsJson',fld:'vTFLIQDERRORDESC_SELSJSON',pic:''},{av:'AV93TFDConDescrip_SelsJson',fld:'vTFDCONDESCRIP_SELSJSON',pic:''},{av:'AV90TFDConCodigo_SelsJson',fld:'vTFDCONCODIGO_SELSJSON',pic:''},{av:'AV197TFLiqDClasifAux_SelsJson',fld:'vTFLIQDCLASIFAUX_SELSJSON',pic:''},{av:'AV103TFDTipoConCod_SelsJson',fld:'vTFDTIPOCONCOD_SELSJSON',pic:''},{av:'AV54LiqEstado',fld:'vLIQESTADO',pic:'9',hsh:true},{av:'AV15ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'cmbDTipoConCod'},{av:'edtLiqDClasifAux_Visible',ctrl:'LIQDCLASIFAUX',prop:'Visible'},{av:'edtDConCodigo_Visible',ctrl:'DCONCODIGO',prop:'Visible'},{av:'edtDConDescrip_Visible',ctrl:'DCONDESCRIP',prop:'Visible'},{av:'edtLiqDValUni_Visible',ctrl:'LIQDVALUNI',prop:'Visible'},{av:'edtLiqDCanti_Visible',ctrl:'LIQDCANTI',prop:'Visible'},{av:'edtLiqDImpReCalcu_Visible',ctrl:'LIQDIMPRECALCU',prop:'Visible'},{av:'edtLiqDReFormulaHTML_Visible',ctrl:'LIQDREFORMULAHTML',prop:'Visible'},{av:'edtLiqDErrorDesc_Visible',ctrl:'LIQDERRORDESC',prop:'Visible'},{av:'edtLiqDLogRecal_Visible',ctrl:'LIQDLOGRECAL',prop:'Visible'},{av:'AV35GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV36GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV34GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'edtDConCodigo_Columnheaderclass',ctrl:'DCONCODIGO',prop:'Columnheaderclass'},{av:'edtDConDescrip_Columnheaderclass',ctrl:'DCONDESCRIP',prop:'Columnheaderclass'},{av:'edtLiqDImpReCalcu_Columnheaderclass',ctrl:'LIQDIMPRECALCU',prop:'Columnheaderclass'},{av:'edtLiqDErrorDesc_Columnheaderclass',ctrl:'LIQDERRORDESC',prop:'Columnheaderclass'},{av:'AV194Gridsdt_liquidacion2sCurrentPage',fld:'vGRIDSDT_LIQUIDACION2SCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV195Gridsdt_liquidacion2sPageCount',fld:'vGRIDSDT_LIQUIDACION2SPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV42IsAuthorized_InfoOriginal',fld:'vISAUTHORIZED_INFOORIGINAL',pic:'',hsh:true},{av:'edtavInfooriginal_Visible',ctrl:'vINFOORIGINAL',prop:'Visible'},{ctrl:'BTNRELIQUIDAR',prop:'Visible'},{av:'AV58ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV168TotLiqDImpReCalcu',fld:'vTOTLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV183TotLiqDSeg',fld:'vTOTLIQDSEG',pic:'9.999',hsh:true},{av:'AV171TotValueLiqDImpReCalcu',fld:'vTOTVALUELIQDIMPRECALCU',pic:''},{av:'AV167TotLiqDImpCalcu',fld:'vTOTLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true}]}");
      setEventMetadata("VELIMINARDETALLE.CLICK","{handler:'e30H62',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A394DConCodigo',fld:'DCONCODIGO',pic:''}]");
      setEventMetadata("VELIMINARDETALLE.CLICK",",oparms:[{av:'AV181CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV26EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV57LiqNro_Selected',fld:'vLIQNRO_SELECTED',pic:'ZZZZZZZ9'},{av:'AV49LegNumero_Selected',fld:'vLEGNUMERO_SELECTED',pic:'ZZZZZZZ9'},{av:'AV20DConCodigo_Selected',fld:'vDCONCODIGO_SELECTED',pic:''}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINARDETALLE.CLOSE","{handler:'e20H62',iparms:[{av:'Dvelop_confirmpanel_eliminardetalle_Result',ctrl:'DVELOP_CONFIRMPANEL_ELIMINARDETALLE',prop:'Result'},{av:'AV181CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV26EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV57LiqNro_Selected',fld:'vLIQNRO_SELECTED',pic:'ZZZZZZZ9'},{av:'AV49LegNumero_Selected',fld:'vLEGNUMERO_SELECTED',pic:'ZZZZZZZ9'},{av:'AV20DConCodigo_Selected',fld:'vDCONCODIGO_SELECTED',pic:''}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINARDETALLE.CLOSE",",oparms:[]}");
      setEventMetadata("'DOINFOORIGINAL'","{handler:'e31H62',iparms:[{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV5LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'A81LiqDSecuencial',fld:'LIQDSECUENCIAL',pic:'ZZZZ9',hsh:true}]");
      setEventMetadata("'DOINFOORIGINAL'",",oparms:[]}");
      setEventMetadata("DDO_ACTIONGROUP2.ONOPTIONCLICKED","{handler:'e18H62',iparms:[{av:'Ddo_actiongroup2_Activeeventkey',ctrl:'DDO_ACTIONGROUP2',prop:'ActiveEventKey'},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV5LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("DDO_ACTIONGROUP2.ONOPTIONCLICKED",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'}]}");
      setEventMetadata("'DORELIQUIDAR'","{handler:'e21H62',iparms:[{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DORELIQUIDAR'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e22H62',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("GRIDSDT_LIQUIDACION2S.LOAD","{handler:'e28H63',iparms:[]");
      setEventMetadata("GRIDSDT_LIQUIDACION2S.LOAD",",oparms:[{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV193VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'}]}");
      setEventMetadata("GRIDSDT_LIQUIDACION2SPAGINATIONBAR.CHANGEPAGE","{handler:'e16H62',iparms:[{av:'GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage'},{av:'GRIDSDT_LIQUIDACION2S_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'subGridsdt_liquidacion2s_Rows',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'Rows'},{av:'cmbavMostrar'},{av:'AV62Mostrar',fld:'vMOSTRAR',pic:''},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV59ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV15ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV223Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''},{av:'AV102TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV198TFLiqDClasifAux',fld:'vTFLIQDCLASIFAUX',pic:''},{av:'AV199TFLiqDClasifAux_Sels',fld:'vTFLIQDCLASIFAUX_SELS',pic:''},{av:'AV88TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV89TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV91TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV92TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV147TFLiqDValUni',fld:'vTFLIQDVALUNI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV148TFLiqDValUni_To',fld:'vTFLIQDVALUNI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV134TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV135TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV123TFLiqDErrorDesc',fld:'vTFLIQDERRORDESC',pic:''},{av:'AV124TFLiqDErrorDesc_Sels',fld:'vTFLIQDERRORDESC_SELS',pic:''},{av:'AV188modoTestEs',fld:'vMODOTESTES',pic:'',hsh:true},{av:'AV54LiqEstado',fld:'vLIQESTADO',pic:'9',hsh:true},{av:'AV63OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV65OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV207auxMenuOpcCod',fld:'vAUXMENUOPCCOD',pic:'',hsh:true},{av:'AV5LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV179TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:'',hsh:true},{av:'AV180TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:'',hsh:true},{av:'AV18ConVariable',fld:'vCONVARIABLE',pic:'',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A764LiqDImpReCalcu',fld:'LIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV168TotLiqDImpReCalcu',fld:'vTOTLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'A1469LiqDSeg',fld:'LIQDSEG',pic:'9.999'},{av:'AV183TotLiqDSeg',fld:'vTOTLIQDSEG',pic:'9.999',hsh:true},{av:'cmbDTipoConCod'},{av:'A464DTipoConCod',fld:'DTIPOCONCOD',pic:''},{av:'AV167TotLiqDImpCalcu',fld:'vTOTLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'A275LiqDImpCalcu',fld:'LIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV200WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV192sdt_liquidacion2',fld:'vSDT_LIQUIDACION2',grid:197,pic:'',hsh:true},{av:'nGXsfl_197_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:197},{av:'nRC_GXsfl_197',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'GridRC',grid:197},{av:'AV42IsAuthorized_InfoOriginal',fld:'vISAUTHORIZED_INFOORIGINAL',pic:'',hsh:true},{av:'AV211LiqFecImp',fld:'vLIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'AV209sistemaPalabra',fld:'vSISTEMAPALABRA',pic:'',hsh:true},{av:'AV190MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'Gridsdt_liquidacion2spaginationbar_Selectedpage',ctrl:'GRIDSDT_LIQUIDACION2SPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDSDT_LIQUIDACION2SPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDT_LIQUIDACION2SPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e17H62',iparms:[{av:'GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage'},{av:'GRIDSDT_LIQUIDACION2S_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'subGridsdt_liquidacion2s_Rows',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'Rows'},{av:'cmbavMostrar'},{av:'AV62Mostrar',fld:'vMOSTRAR',pic:''},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV59ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV15ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV223Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''},{av:'AV102TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV198TFLiqDClasifAux',fld:'vTFLIQDCLASIFAUX',pic:''},{av:'AV199TFLiqDClasifAux_Sels',fld:'vTFLIQDCLASIFAUX_SELS',pic:''},{av:'AV88TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV89TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV91TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV92TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV147TFLiqDValUni',fld:'vTFLIQDVALUNI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV148TFLiqDValUni_To',fld:'vTFLIQDVALUNI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV134TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV135TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV123TFLiqDErrorDesc',fld:'vTFLIQDERRORDESC',pic:''},{av:'AV124TFLiqDErrorDesc_Sels',fld:'vTFLIQDERRORDESC_SELS',pic:''},{av:'AV188modoTestEs',fld:'vMODOTESTES',pic:'',hsh:true},{av:'AV54LiqEstado',fld:'vLIQESTADO',pic:'9',hsh:true},{av:'AV63OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV65OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV207auxMenuOpcCod',fld:'vAUXMENUOPCCOD',pic:'',hsh:true},{av:'AV5LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV179TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:'',hsh:true},{av:'AV180TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:'',hsh:true},{av:'AV18ConVariable',fld:'vCONVARIABLE',pic:'',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A764LiqDImpReCalcu',fld:'LIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV168TotLiqDImpReCalcu',fld:'vTOTLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'A1469LiqDSeg',fld:'LIQDSEG',pic:'9.999'},{av:'AV183TotLiqDSeg',fld:'vTOTLIQDSEG',pic:'9.999',hsh:true},{av:'cmbDTipoConCod'},{av:'A464DTipoConCod',fld:'DTIPOCONCOD',pic:''},{av:'AV167TotLiqDImpCalcu',fld:'vTOTLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'A275LiqDImpCalcu',fld:'LIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV200WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV192sdt_liquidacion2',fld:'vSDT_LIQUIDACION2',grid:197,pic:'',hsh:true},{av:'nGXsfl_197_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:197},{av:'nRC_GXsfl_197',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'GridRC',grid:197},{av:'AV42IsAuthorized_InfoOriginal',fld:'vISAUTHORIZED_INFOORIGINAL',pic:'',hsh:true},{av:'AV211LiqFecImp',fld:'vLIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'AV209sistemaPalabra',fld:'vSISTEMAPALABRA',pic:'',hsh:true},{av:'AV190MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'Gridsdt_liquidacion2spaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDSDT_LIQUIDACION2SPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDSDT_LIQUIDACION2SPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGridsdt_liquidacion2s_Rows',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'Rows'}]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e23H62',iparms:[{av:'AV200WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV190MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e11H61',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("VVERSVG.CLICK","{handler:'e29H62',iparms:[{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV25EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV192sdt_liquidacion2',fld:'vSDT_LIQUIDACION2',grid:197,pic:'',hsh:true},{av:'nGXsfl_197_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:197},{av:'GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage'},{av:'nRC_GXsfl_197',ctrl:'GRIDSDT_LIQUIDACION2S',prop:'GridRC',grid:197}]");
      setEventMetadata("VVERSVG.CLICK",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Infooriginal',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Versvg',iparms:[]");
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
      wcpOAV207auxMenuOpcCod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      Dvelop_confirmpanel_eliminardetalle_Result = "" ;
      Ddo_actiongroup2_Activeeventkey = "" ;
      Gridsdt_liquidacion2spaginationbar_Selectedpage = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV207auxMenuOpcCod = "" ;
      AV62Mostrar = "" ;
      AV15ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV223Pgmname = "" ;
      AV37GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV102TFDTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV198TFLiqDClasifAux = "" ;
      AV199TFLiqDClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV88TFDConCodigo = "" ;
      AV89TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV91TFDConDescrip = "" ;
      AV92TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV147TFLiqDValUni = DecimalUtil.ZERO ;
      AV148TFLiqDValUni_To = DecimalUtil.ZERO ;
      AV134TFLiqDImpReCalcu = DecimalUtil.ZERO ;
      AV135TFLiqDImpReCalcu_To = DecimalUtil.ZERO ;
      AV123TFLiqDErrorDesc = "" ;
      AV124TFLiqDErrorDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV179TFConClasifAux = "" ;
      AV180TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV168TotLiqDImpReCalcu = DecimalUtil.ZERO ;
      AV183TotLiqDSeg = DecimalUtil.ZERO ;
      AV167TotLiqDImpCalcu = DecimalUtil.ZERO ;
      AV211LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      AV209sistemaPalabra = "" ;
      AV192sdt_liquidacion2 = new GXBaseCollection<web.Sdtsdt_liquidacion2_sdt_liquidacion2Item>(web.Sdtsdt_liquidacion2_sdt_liquidacion2Item.class, "sdt_liquidacion2Item", "PayDay", remoteHandle);
      AV190MenuOpcCod = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A1469LiqDSeg = DecimalUtil.ZERO ;
      A464DTipoConCod = "" ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV21DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV58ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV34GridAppliedFilters = "" ;
      AV196Gridsdt_liquidacion2sAppliedFilters = "" ;
      AV216ActionGroup2Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV125TFLiqDErrorDesc_SelsJson = "" ;
      A504LiqDForOrig = "" ;
      AV103TFDTipoConCod_SelsJson = "" ;
      AV197TFLiqDClasifAux_SelsJson = "" ;
      AV90TFDConCodigo_SelsJson = "" ;
      AV93TFDConDescrip_SelsJson = "" ;
      AV20DConCodigo_Selected = "" ;
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
      Ddo_actiongroup2_Caption = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      Gridsdt_liquidacion2s_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV201WelcomeMessage_Foto = "" ;
      AV224Welcomemessage_foto_GXI = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      bttBtnactiongroup2_Jsonclick = "" ;
      lblButtonexport1_textblock_svg_Jsonclick = "" ;
      lblButtonexport1_textblock_texto_Jsonclick = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      bttBtnreliquidar_Jsonclick = "" ;
      bttBtnexport_Jsonclick = "" ;
      lblButtonfilters1_textblock_svg_Jsonclick = "" ;
      lblButtonfilters1_textblock_texto_Jsonclick = "" ;
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      lblTextblock1_Jsonclick = "" ;
      AV8LiqLegImpTotRemu = DecimalUtil.ZERO ;
      lblTextblock2_Jsonclick = "" ;
      AV7LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      lblTextblock3_Jsonclick = "" ;
      AV6LiqLegImpTotDescu = DecimalUtil.ZERO ;
      lblTextblock4_Jsonclick = "" ;
      AV55LiqLegImpTotal = DecimalUtil.ZERO ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_actiongroup2 = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridsdt_liquidacion2s_empowerer = new com.genexus.webpanels.GXUserControl();
      Gridsdt_liquidacion2sContainer = new com.genexus.webpanels.GXWebGrid(context);
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV24EliminarDetalle = "" ;
      A2149LiqDClasifAux = "" ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      A277LiqDValUni = DecimalUtil.ZERO ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A276LiqDImporte = DecimalUtil.ZERO ;
      A876LiqDReFormulaHTML = "" ;
      A270LiqDErrorDesc = "" ;
      A1072LiqDLogRecal = "" ;
      AV40InfoOriginal = "" ;
      AV239Infooriginal_GXI = "" ;
      AV193VerSVG = "" ;
      AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = "" ;
      lV229Liquidacionverdetalle2ds_5_tfdconcodigo = "" ;
      lV231Liquidacionverdetalle2ds_7_tfdcondescrip = "" ;
      lV237Liquidacionverdetalle2ds_13_tfliqderrordesc = "" ;
      AV225Liquidacionverdetalle2ds_1_mostrar = "" ;
      AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux = "" ;
      AV229Liquidacionverdetalle2ds_5_tfdconcodigo = "" ;
      AV231Liquidacionverdetalle2ds_7_tfdcondescrip = "" ;
      AV233Liquidacionverdetalle2ds_9_tfliqdvaluni = DecimalUtil.ZERO ;
      AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to = DecimalUtil.ZERO ;
      AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu = DecimalUtil.ZERO ;
      AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = DecimalUtil.ZERO ;
      AV237Liquidacionverdetalle2ds_13_tfliqderrordesc = "" ;
      H00H62_A1134LiqDOrdVis = new short[1] ;
      H00H62_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00H62_n275LiqDImpCalcu = new boolean[] {false} ;
      H00H62_A504LiqDForOrig = new String[] {""} ;
      H00H62_A1469LiqDSeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00H62_A1072LiqDLogRecal = new String[] {""} ;
      H00H62_A81LiqDSecuencial = new int[1] ;
      H00H62_A471DConOrden = new int[1] ;
      H00H62_A502LiqDMostrar = new byte[1] ;
      H00H62_A270LiqDErrorDesc = new String[] {""} ;
      H00H62_n270LiqDErrorDesc = new boolean[] {false} ;
      H00H62_A876LiqDReFormulaHTML = new String[] {""} ;
      H00H62_n876LiqDReFormulaHTML = new boolean[] {false} ;
      H00H62_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00H62_A276LiqDImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00H62_n276LiqDImporte = new boolean[] {false} ;
      H00H62_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00H62_n269LiqDCanti = new boolean[] {false} ;
      H00H62_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00H62_n277LiqDValUni = new boolean[] {false} ;
      H00H62_A393DConDescrip = new String[] {""} ;
      H00H62_A394DConCodigo = new String[] {""} ;
      H00H62_A2149LiqDClasifAux = new String[] {""} ;
      H00H62_A464DTipoConCod = new String[] {""} ;
      H00H62_A3CliCod = new int[1] ;
      H00H62_A1EmpCod = new short[1] ;
      H00H62_A31LiqNro = new int[1] ;
      H00H62_A6LegNumero = new int[1] ;
      H00H63_AGRID_nRecordCount = new long[1] ;
      AV171TotValueLiqDImpReCalcu = "" ;
      GXv_dtime1 = new java.util.Date[1] ;
      AV189ParmValue = "" ;
      AV23diasTopeConCodigo = "" ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      AV39HTTPRequest = httpContext.getHttpRequest();
      AV217ActionGroup2DataItem = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridsdt_liquidacion2spaginationbar = new com.genexus.webpanels.GXUserControl();
      AV202MenuBienveImgURL = "" ;
      AV204MenuBienveTitulo = "" ;
      AV205MenuBienveTexto = "" ;
      AV215observerPalabra = "" ;
      AV48LegNomApe = "" ;
      AV12CatCodigo = "" ;
      AV19ConveCodigo = "" ;
      AV13CatDescrip = "" ;
      GXv_int15 = new int[1] ;
      GXv_objcol_Sdtsdt_liquidacion2_sdt_liquidacion2Item16 = new GXBaseCollection[1] ;
      GXv_int4 = new byte[1] ;
      AV177WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext17 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV68Session = httpContext.getWebSession();
      AV17ColumnsSelectorXML = "" ;
      GXv_int18 = new short[1] ;
      AV214filtrosTexto = "" ;
      AV210ConDescrip = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV60ManageFiltersXml = "" ;
      AV29ExcelFilename = "" ;
      AV27ErrorMessage = "" ;
      AV174UserCustomValue = "" ;
      AV16ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector19 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector20 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item22 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item23 = new GXBaseCollection[1] ;
      AV50linkPDF = "" ;
      AV28errorPDF = "" ;
      AV38GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXt_char25 = "" ;
      GXv_char26 = new String[1] ;
      GXt_char24 = "" ;
      GXv_char12 = new String[1] ;
      GXt_char14 = "" ;
      GXv_char11 = new String[1] ;
      GXv_SdtWWPGridState29 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV172TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      H00H64_A81LiqDSecuencial = new int[1] ;
      H00H64_A3CliCod = new int[1] ;
      H00H64_A6LegNumero = new int[1] ;
      H00H64_A31LiqNro = new int[1] ;
      H00H64_A1EmpCod = new short[1] ;
      H00H64_A270LiqDErrorDesc = new String[] {""} ;
      H00H64_n270LiqDErrorDesc = new boolean[] {false} ;
      H00H64_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00H64_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00H64_n277LiqDValUni = new boolean[] {false} ;
      H00H64_A393DConDescrip = new String[] {""} ;
      H00H64_A394DConCodigo = new String[] {""} ;
      H00H64_A2149LiqDClasifAux = new String[] {""} ;
      H00H64_A464DTipoConCod = new String[] {""} ;
      H00H64_A502LiqDMostrar = new byte[1] ;
      H00H64_A1469LiqDSeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV184TotValueLiqDSeg = "" ;
      H00H65_A81LiqDSecuencial = new int[1] ;
      H00H65_A3CliCod = new int[1] ;
      H00H65_A6LegNumero = new int[1] ;
      H00H65_A31LiqNro = new int[1] ;
      H00H65_A1EmpCod = new short[1] ;
      H00H65_A464DTipoConCod = new String[] {""} ;
      H00H65_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00H65_n275LiqDImpCalcu = new boolean[] {false} ;
      H00H65_A1469LiqDSeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV170TotValueLiqDImpCalcu = "" ;
      AV203textoNoMostrara = "" ;
      GXv_boolean13 = new boolean[1] ;
      GXt_char27 = "" ;
      GXv_char28 = new String[1] ;
      Gridsdt_liquidacion2sRow = new com.genexus.webpanels.GXWebRow();
      ucDvelop_confirmpanel_eliminardetalle = new com.genexus.webpanels.GXUserControl();
      lblButtonfilter1_textblockbadgecount_Jsonclick = "" ;
      lblWelcomemessage_descripcion_Jsonclick = "" ;
      lblWelcomemessage_titulo_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      subGridsdt_liquidacion2s_Linesclass = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      Gridsdt_liquidacion2sColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionverdetalle2__default(),
         new Object[] {
             new Object[] {
            H00H62_A1134LiqDOrdVis, H00H62_A275LiqDImpCalcu, H00H62_n275LiqDImpCalcu, H00H62_A504LiqDForOrig, H00H62_A1469LiqDSeg, H00H62_A1072LiqDLogRecal, H00H62_A81LiqDSecuencial, H00H62_A471DConOrden, H00H62_A502LiqDMostrar, H00H62_A270LiqDErrorDesc,
            H00H62_n270LiqDErrorDesc, H00H62_A876LiqDReFormulaHTML, H00H62_n876LiqDReFormulaHTML, H00H62_A764LiqDImpReCalcu, H00H62_A276LiqDImporte, H00H62_n276LiqDImporte, H00H62_A269LiqDCanti, H00H62_n269LiqDCanti, H00H62_A277LiqDValUni, H00H62_n277LiqDValUni,
            H00H62_A393DConDescrip, H00H62_A394DConCodigo, H00H62_A2149LiqDClasifAux, H00H62_A464DTipoConCod, H00H62_A3CliCod, H00H62_A1EmpCod, H00H62_A31LiqNro, H00H62_A6LegNumero
            }
            , new Object[] {
            H00H63_AGRID_nRecordCount
            }
            , new Object[] {
            H00H64_A81LiqDSecuencial, H00H64_A3CliCod, H00H64_A6LegNumero, H00H64_A31LiqNro, H00H64_A1EmpCod, H00H64_A270LiqDErrorDesc, H00H64_n270LiqDErrorDesc, H00H64_A764LiqDImpReCalcu, H00H64_A277LiqDValUni, H00H64_n277LiqDValUni,
            H00H64_A393DConDescrip, H00H64_A394DConCodigo, H00H64_A2149LiqDClasifAux, H00H64_A464DTipoConCod, H00H64_A502LiqDMostrar, H00H64_A1469LiqDSeg
            }
            , new Object[] {
            H00H65_A81LiqDSecuencial, H00H65_A3CliCod, H00H65_A6LegNumero, H00H65_A31LiqNro, H00H65_A1EmpCod, H00H65_A464DTipoConCod, H00H65_A275LiqDImpCalcu, H00H65_n275LiqDImpCalcu, H00H65_A1469LiqDSeg
            }
         }
      );
      AV223Pgmname = "LiquidacionVerDetalle2" ;
      /* GeneXus formulas. */
      AV223Pgmname = "LiquidacionVerDetalle2" ;
      Gx_err = (short)(0) ;
      edtavLiqlegimptotremu_Enabled = 0 ;
      edtavLiqlegimptotnoremu_Enabled = 0 ;
      edtavLiqlegimptotdescu_Enabled = 0 ;
      edtavLiqlegimptotal_Enabled = 0 ;
      edtavEliminardetalle_Enabled = 0 ;
      edtavTotvalueliqdimprecalcu_Enabled = 0 ;
      edtavSdt_liquidacion2__liqnro_Enabled = 0 ;
      edtavSdt_liquidacion2__liqnombre_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte GRIDSDT_LIQUIDACION2S_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV59ManageFiltersExecutionStep ;
   private byte AV54LiqEstado ;
   private byte gxajaxcallmode ;
   private byte A502LiqDMostrar ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte subGridsdt_liquidacion2s_Backcolorstyle ;
   private byte GXv_int4[] ;
   private byte edtDConCodigo_Fontbold ;
   private byte edtDConDescrip_Fontbold ;
   private byte edtLiqDImpReCalcu_Fontbold ;
   private byte edtLiqDCanti_Fontbold ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGridsdt_liquidacion2s_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte subGridsdt_liquidacion2s_Titlebackstyle ;
   private byte subGridsdt_liquidacion2s_Allowselection ;
   private byte subGridsdt_liquidacion2s_Allowhovering ;
   private byte subGridsdt_liquidacion2s_Allowcollapsing ;
   private byte subGridsdt_liquidacion2s_Collapsed ;
   private short wcpOAV25EmpCod ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV25EmpCod ;
   private short AV63OrderedBy ;
   private short A1EmpCod ;
   private short AV26EmpCod_Selected ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A1134LiqDOrdVis ;
   private short GXv_int18[] ;
   private short edtavVersvg_Format ;
   private int wcpOAV14CliCod ;
   private int wcpOAV9LiqNro ;
   private int wcpOAV5LegNumero ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int Gridsdt_liquidacion2spaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_138 ;
   private int nRC_GXsfl_197 ;
   private int subGridsdt_liquidacion2s_Rows ;
   private int AV14CliCod ;
   private int AV9LiqNro ;
   private int AV5LegNumero ;
   private int nGXsfl_138_idx=1 ;
   private int nGXsfl_197_idx=1 ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int AV181CliCod_Selected ;
   private int AV57LiqNro_Selected ;
   private int AV49LegNumero_Selected ;
   private int Gridpaginationbar_Pagestoshow ;
   private int Gridsdt_liquidacion2spaginationbar_Pagestoshow ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnreliquidar_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int edtavLiqlegimptotremu_Enabled ;
   private int edtavLiqlegimptotnoremu_Enabled ;
   private int edtavLiqlegimptotdescu_Enabled ;
   private int edtavLiqlegimptotal_Enabled ;
   private int AV220GXV1 ;
   private int A471DConOrden ;
   private int A81LiqDSecuencial ;
   private int subGrid_Islastpage ;
   private int subGridsdt_liquidacion2s_Islastpage ;
   private int edtavEliminardetalle_Enabled ;
   private int edtavTotvalueliqdimprecalcu_Enabled ;
   private int edtavSdt_liquidacion2__liqnro_Enabled ;
   private int edtavSdt_liquidacion2__liqnombre_Enabled ;
   private int edtavVersvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size ;
   private int AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size ;
   private int AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size ;
   private int AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size ;
   private int AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size ;
   private int GRIDSDT_LIQUIDACION2S_nGridOutOfScope ;
   private int nGXsfl_197_fel_idx=1 ;
   private int AV187CliConveVer ;
   private int GXv_int15[] ;
   private int tblTableretro_Visible ;
   private int edtLiqDClasifAux_Visible ;
   private int edtDConCodigo_Visible ;
   private int edtDConDescrip_Visible ;
   private int edtLiqDValUni_Visible ;
   private int edtLiqDCanti_Visible ;
   private int edtLiqDImpReCalcu_Visible ;
   private int edtLiqDReFormulaHTML_Visible ;
   private int edtLiqDErrorDesc_Visible ;
   private int edtLiqDLogRecal_Visible ;
   private int AV213filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV66PageToGo ;
   private int edtavInfooriginal_Visible ;
   private int AV240GXV4 ;
   private int AV241GXV5 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavEliminardetalle_Visible ;
   private int edtavInfooriginal_Enabled ;
   private int subGridsdt_liquidacion2s_Backcolor ;
   private int subGridsdt_liquidacion2s_Allbackcolor ;
   private int edtavVersvg_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGridsdt_liquidacion2s_Titlebackcolor ;
   private int subGridsdt_liquidacion2s_Selectedindex ;
   private int subGridsdt_liquidacion2s_Selectioncolor ;
   private int subGridsdt_liquidacion2s_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long GRIDSDT_LIQUIDACION2S_nFirstRecordOnPage ;
   private long AV35GridCurrentPage ;
   private long AV36GridPageCount ;
   private long AV194Gridsdt_liquidacion2sCurrentPage ;
   private long AV195Gridsdt_liquidacion2sPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRIDSDT_LIQUIDACION2S_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private long GRIDSDT_LIQUIDACION2S_nRecordCount ;
   private java.math.BigDecimal AV147TFLiqDValUni ;
   private java.math.BigDecimal AV148TFLiqDValUni_To ;
   private java.math.BigDecimal AV134TFLiqDImpReCalcu ;
   private java.math.BigDecimal AV135TFLiqDImpReCalcu_To ;
   private java.math.BigDecimal AV168TotLiqDImpReCalcu ;
   private java.math.BigDecimal AV183TotLiqDSeg ;
   private java.math.BigDecimal AV167TotLiqDImpCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A1469LiqDSeg ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal AV8LiqLegImpTotRemu ;
   private java.math.BigDecimal AV7LiqLegImpTotNoRemu ;
   private java.math.BigDecimal AV6LiqLegImpTotDescu ;
   private java.math.BigDecimal AV55LiqLegImpTotal ;
   private java.math.BigDecimal A277LiqDValUni ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A276LiqDImporte ;
   private java.math.BigDecimal AV233Liquidacionverdetalle2ds_9_tfliqdvaluni ;
   private java.math.BigDecimal AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to ;
   private java.math.BigDecimal AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu ;
   private java.math.BigDecimal AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String Dvelop_confirmpanel_eliminardetalle_Result ;
   private String Ddo_actiongroup2_Activeeventkey ;
   private String Gridsdt_liquidacion2spaginationbar_Selectedpage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_138_idx="0001" ;
   private String AV62Mostrar ;
   private String AV223Pgmname ;
   private String AV88TFDConCodigo ;
   private String AV209sistemaPalabra ;
   private String sGXsfl_197_idx="0001" ;
   private String A464DTipoConCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV20DConCodigo_Selected ;
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
   private String Innewwindow1_Target ;
   private String Gridsdt_liquidacion2spaginationbar_Class ;
   private String Gridsdt_liquidacion2spaginationbar_Pagingbuttonsposition ;
   private String Gridsdt_liquidacion2spaginationbar_Pagingcaptionposition ;
   private String Gridsdt_liquidacion2spaginationbar_Emptygridclass ;
   private String Gridsdt_liquidacion2spaginationbar_Rowsperpageoptions ;
   private String Gridsdt_liquidacion2spaginationbar_Previous ;
   private String Gridsdt_liquidacion2spaginationbar_Next ;
   private String Gridsdt_liquidacion2spaginationbar_Caption ;
   private String Gridsdt_liquidacion2spaginationbar_Emptygridcaption ;
   private String Gridsdt_liquidacion2spaginationbar_Rowsperpagecaption ;
   private String Ddo_actiongroup2_Icontype ;
   private String Ddo_actiongroup2_Icon ;
   private String Ddo_actiongroup2_Caption ;
   private String Ddo_actiongroup2_Cls ;
   private String Ddo_actiongroup2_Titlecontrolidtoreplace ;
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
   private String Dvelop_confirmpanel_eliminardetalle_Title ;
   private String Dvelop_confirmpanel_eliminardetalle_Confirmationtext ;
   private String Dvelop_confirmpanel_eliminardetalle_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_eliminardetalle_Nobuttoncaption ;
   private String Dvelop_confirmpanel_eliminardetalle_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_eliminardetalle_Yesbuttonposition ;
   private String Dvelop_confirmpanel_eliminardetalle_Confirmtype ;
   private String Grid_empowerer_Gridinternalname ;
   private String Gridsdt_liquidacion2s_empowerer_Gridinternalname ;
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
   private String divTableheader_Internalname ;
   private String divTableheadercontent_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Caption ;
   private String lblTextblocktitle_Jsonclick ;
   private String divTableactions_Internalname ;
   private String bttBtnactiongroup2_Internalname ;
   private String bttBtnactiongroup2_Jsonclick ;
   private String divButtonexport1_tablecontentbuttonimport_Internalname ;
   private String divButtonexport1_table_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Jsonclick ;
   private String divButtonexport1_table_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Jsonclick ;
   private String Buttonexport1_a3lexport_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String bttBtnreliquidar_Internalname ;
   private String bttBtnreliquidar_Jsonclick ;
   private String bttBtnexport_Internalname ;
   private String bttBtnexport_Jsonclick ;
   private String divButtonfilter1_tablecontent_Internalname ;
   private String divButtonfilters1_filtros_Internalname ;
   private String divButtonfilters1_table_svg_Internalname ;
   private String lblButtonfilters1_textblock_svg_Internalname ;
   private String lblButtonfilters1_textblock_svg_Jsonclick ;
   private String divButtonfilters1_table_texto_Internalname ;
   private String lblButtonfilters1_textblock_texto_Internalname ;
   private String lblButtonfilters1_textblock_texto_Jsonclick ;
   private String Buttonfilter1_a3lfilter_Internalname ;
   private String divTabletotales_Internalname ;
   private String divTableremu_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String edtavLiqlegimptotremu_Internalname ;
   private String edtavLiqlegimptotremu_Jsonclick ;
   private String divTablenoremu_Internalname ;
   private String lblTextblock2_Internalname ;
   private String lblTextblock2_Jsonclick ;
   private String edtavLiqlegimptotnoremu_Internalname ;
   private String edtavLiqlegimptotnoremu_Jsonclick ;
   private String divTabledesc_Internalname ;
   private String lblTextblock3_Internalname ;
   private String lblTextblock3_Jsonclick ;
   private String edtavLiqlegimptotdescu_Internalname ;
   private String edtavLiqlegimptotdescu_Jsonclick ;
   private String divTableneto_Internalname ;
   private String lblTextblock4_Internalname ;
   private String lblTextblock4_Jsonclick ;
   private String edtavLiqlegimptotal_Internalname ;
   private String edtavLiqlegimptotal_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String Innewwindow1_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_actiongroup2_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String Gridsdt_liquidacion2s_empowerer_Internalname ;
   private String subGridsdt_liquidacion2s_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV24EliminarDetalle ;
   private String edtavEliminardetalle_Internalname ;
   private String edtLiqDClasifAux_Internalname ;
   private String A394DConCodigo ;
   private String edtDConCodigo_Internalname ;
   private String edtDConDescrip_Internalname ;
   private String edtLiqDValUni_Internalname ;
   private String edtLiqDCanti_Internalname ;
   private String edtLiqDImporte_Internalname ;
   private String edtLiqDImpReCalcu_Internalname ;
   private String edtLiqDReFormulaHTML_Internalname ;
   private String edtLiqDErrorDesc_Internalname ;
   private String edtDConOrden_Internalname ;
   private String edtLiqDSecuencial_Internalname ;
   private String edtLiqDLogRecal_Internalname ;
   private String edtLiqDSeg_Internalname ;
   private String edtavInfooriginal_Internalname ;
   private String AV193VerSVG ;
   private String edtavVersvg_Internalname ;
   private String edtavTotvalueliqdimprecalcu_Internalname ;
   private String edtavSdt_liquidacion2__liqnro_Internalname ;
   private String edtavSdt_liquidacion2__liqnombre_Internalname ;
   private String scmdbuf ;
   private String lV229Liquidacionverdetalle2ds_5_tfdconcodigo ;
   private String AV225Liquidacionverdetalle2ds_1_mostrar ;
   private String AV229Liquidacionverdetalle2ds_5_tfdconcodigo ;
   private String sGXsfl_197_fel_idx="0001" ;
   private String AV23diasTopeConCodigo ;
   private String Gridsdt_liquidacion2spaginationbar_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String AV215observerPalabra ;
   private String AV12CatCodigo ;
   private String AV19ConveCodigo ;
   private String tblTableretro_Internalname ;
   private String edtDConCodigo_Columnheaderclass ;
   private String edtDConDescrip_Columnheaderclass ;
   private String edtLiqDImpReCalcu_Columnheaderclass ;
   private String edtLiqDErrorDesc_Columnheaderclass ;
   private String tblButtonfilter1_tablebadge_Internalname ;
   private String lblButtonfilter1_textblockbadgecount_Caption ;
   private String lblButtonfilter1_textblockbadgecount_Internalname ;
   private String tblButtonfilter1_tablebadge_Tooltiptext ;
   private String edtavEliminardetalle_Class ;
   private String edtavInfooriginal_gximage ;
   private String edtavInfooriginal_Tooltiptext ;
   private String edtavInfooriginal_Class ;
   private String edtDConCodigo_Columnclass ;
   private String edtDConDescrip_Columnclass ;
   private String edtLiqDImpReCalcu_Columnclass ;
   private String edtLiqDErrorDesc_Columnclass ;
   private String edtLiqDImpReCalcu_Tooltiptext ;
   private String edtLiqDLogRecal_Tooltiptext ;
   private String edtDConDescrip_Tooltiptext ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXt_char25 ;
   private String GXv_char26[] ;
   private String GXt_char24 ;
   private String GXv_char12[] ;
   private String GXt_char14 ;
   private String GXv_char11[] ;
   private String GXt_char27 ;
   private String GXv_char28[] ;
   private String edtavVersvg_Columnclass ;
   private String tblTabledvelop_confirmpanel_eliminardetalle_Internalname ;
   private String Dvelop_confirmpanel_eliminardetalle_Internalname ;
   private String grpUnnamedgroup2_Internalname ;
   private String tblUnnamedtable1_Internalname ;
   private String divGridsdt_liquidacion2stablewithpaginationbar_Internalname ;
   private String tblGridtabletotalizer_Internalname ;
   private String edtavTotvalueliqdimprecalcu_Jsonclick ;
   private String lblButtonfilter1_textblockbadgecount_Jsonclick ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private String sGXsfl_138_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavEliminardetalle_Jsonclick ;
   private String GXCCtl ;
   private String edtLiqDClasifAux_Jsonclick ;
   private String edtDConCodigo_Jsonclick ;
   private String edtDConDescrip_Jsonclick ;
   private String edtLiqDValUni_Jsonclick ;
   private String edtLiqDCanti_Jsonclick ;
   private String edtLiqDImporte_Jsonclick ;
   private String edtLiqDImpReCalcu_Jsonclick ;
   private String edtLiqDReFormulaHTML_Jsonclick ;
   private String edtLiqDErrorDesc_Jsonclick ;
   private String edtDConOrden_Jsonclick ;
   private String edtLiqDSecuencial_Jsonclick ;
   private String edtLiqDLogRecal_Jsonclick ;
   private String edtLiqDSeg_Jsonclick ;
   private String edtavInfooriginal_Jsonclick ;
   private String subGridsdt_liquidacion2s_Class ;
   private String subGridsdt_liquidacion2s_Linesclass ;
   private String edtavSdt_liquidacion2__liqnro_Jsonclick ;
   private String edtavSdt_liquidacion2__liqnombre_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String subGrid_Header ;
   private String subGridsdt_liquidacion2s_Header ;
   private java.util.Date AV211LiqFecImp ;
   private java.util.Date GXv_dtime1[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV188modoTestEs ;
   private boolean AV65OrderedDsc ;
   private boolean AV18ConVariable ;
   private boolean AV42IsAuthorized_InfoOriginal ;
   private boolean AV200WelcomeMessage_NoMostrarMas ;
   private boolean n275LiqDImpCalcu ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Gridsdt_liquidacion2spaginationbar_Showfirst ;
   private boolean Gridsdt_liquidacion2spaginationbar_Showprevious ;
   private boolean Gridsdt_liquidacion2spaginationbar_Shownext ;
   private boolean Gridsdt_liquidacion2spaginationbar_Showlast ;
   private boolean Gridsdt_liquidacion2spaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean Grid_empowerer_Hascolumnsselector ;
   private boolean wbLoad ;
   private boolean AV201WelcomeMessage_Foto_IsBlob ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n277LiqDValUni ;
   private boolean n269LiqDCanti ;
   private boolean n276LiqDImporte ;
   private boolean n876LiqDReFormulaHTML ;
   private boolean n270LiqDErrorDesc ;
   private boolean bGXsfl_138_Refreshing=false ;
   private boolean bGXsfl_197_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV206MenuBienveVisible ;
   private boolean gx_BV197 ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean21 ;
   private boolean GXv_boolean13[] ;
   private boolean AV40InfoOriginal_IsBlob ;
   private String AV125TFLiqDErrorDesc_SelsJson ;
   private String A504LiqDForOrig ;
   private String AV103TFDTipoConCod_SelsJson ;
   private String AV197TFLiqDClasifAux_SelsJson ;
   private String AV90TFDConCodigo_SelsJson ;
   private String AV93TFDConDescrip_SelsJson ;
   private String A876LiqDReFormulaHTML ;
   private String A1072LiqDLogRecal ;
   private String AV189ParmValue ;
   private String AV205MenuBienveTexto ;
   private String AV17ColumnsSelectorXML ;
   private String AV60ManageFiltersXml ;
   private String AV174UserCustomValue ;
   private String AV203textoNoMostrara ;
   private String wcpOAV207auxMenuOpcCod ;
   private String AV207auxMenuOpcCod ;
   private String AV198TFLiqDClasifAux ;
   private String AV91TFDConDescrip ;
   private String AV123TFLiqDErrorDesc ;
   private String AV179TFConClasifAux ;
   private String AV190MenuOpcCod ;
   private String AV34GridAppliedFilters ;
   private String AV196Gridsdt_liquidacion2sAppliedFilters ;
   private String AV224Welcomemessage_foto_GXI ;
   private String A2149LiqDClasifAux ;
   private String A393DConDescrip ;
   private String A270LiqDErrorDesc ;
   private String AV239Infooriginal_GXI ;
   private String lV227Liquidacionverdetalle2ds_3_tfliqdclasifaux ;
   private String lV231Liquidacionverdetalle2ds_7_tfdcondescrip ;
   private String lV237Liquidacionverdetalle2ds_13_tfliqderrordesc ;
   private String AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux ;
   private String AV231Liquidacionverdetalle2ds_7_tfdcondescrip ;
   private String AV237Liquidacionverdetalle2ds_13_tfliqderrordesc ;
   private String AV171TotValueLiqDImpReCalcu ;
   private String AV202MenuBienveImgURL ;
   private String AV204MenuBienveTitulo ;
   private String AV48LegNomApe ;
   private String AV13CatDescrip ;
   private String AV214filtrosTexto ;
   private String AV210ConDescrip ;
   private String AV29ExcelFilename ;
   private String AV27ErrorMessage ;
   private String AV50linkPDF ;
   private String AV28errorPDF ;
   private String AV184TotValueLiqDSeg ;
   private String AV170TotValueLiqDImpCalcu ;
   private String AV201WelcomeMessage_Foto ;
   private String AV40InfoOriginal ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebGrid Gridsdt_liquidacion2sContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebRow Gridsdt_liquidacion2sRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebColumn Gridsdt_liquidacion2sColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV39HTTPRequest ;
   private com.genexus.webpanels.WebSession AV68Session ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucInnewwindow1 ;
   private com.genexus.webpanels.GXUserControl ucDdo_actiongroup2 ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsdt_liquidacion2s_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsdt_liquidacion2spaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_eliminardetalle ;
   private GXSimpleCollection<String> AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ;
   private GXSimpleCollection<String> AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels ;
   private GXSimpleCollection<String> AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ;
   private GXSimpleCollection<String> AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels ;
   private GXSimpleCollection<String> AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbavMostrar ;
   private HTMLChoice cmbDTipoConCod ;
   private HTMLChoice cmbLiqDMostrar ;
   private IDataStoreProvider pr_default ;
   private short[] H00H62_A1134LiqDOrdVis ;
   private java.math.BigDecimal[] H00H62_A275LiqDImpCalcu ;
   private boolean[] H00H62_n275LiqDImpCalcu ;
   private String[] H00H62_A504LiqDForOrig ;
   private java.math.BigDecimal[] H00H62_A1469LiqDSeg ;
   private String[] H00H62_A1072LiqDLogRecal ;
   private int[] H00H62_A81LiqDSecuencial ;
   private int[] H00H62_A471DConOrden ;
   private byte[] H00H62_A502LiqDMostrar ;
   private String[] H00H62_A270LiqDErrorDesc ;
   private boolean[] H00H62_n270LiqDErrorDesc ;
   private String[] H00H62_A876LiqDReFormulaHTML ;
   private boolean[] H00H62_n876LiqDReFormulaHTML ;
   private java.math.BigDecimal[] H00H62_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] H00H62_A276LiqDImporte ;
   private boolean[] H00H62_n276LiqDImporte ;
   private java.math.BigDecimal[] H00H62_A269LiqDCanti ;
   private boolean[] H00H62_n269LiqDCanti ;
   private java.math.BigDecimal[] H00H62_A277LiqDValUni ;
   private boolean[] H00H62_n277LiqDValUni ;
   private String[] H00H62_A393DConDescrip ;
   private String[] H00H62_A394DConCodigo ;
   private String[] H00H62_A2149LiqDClasifAux ;
   private String[] H00H62_A464DTipoConCod ;
   private int[] H00H62_A3CliCod ;
   private short[] H00H62_A1EmpCod ;
   private int[] H00H62_A31LiqNro ;
   private int[] H00H62_A6LegNumero ;
   private long[] H00H63_AGRID_nRecordCount ;
   private int[] H00H64_A81LiqDSecuencial ;
   private int[] H00H64_A3CliCod ;
   private int[] H00H64_A6LegNumero ;
   private int[] H00H64_A31LiqNro ;
   private short[] H00H64_A1EmpCod ;
   private String[] H00H64_A270LiqDErrorDesc ;
   private boolean[] H00H64_n270LiqDErrorDesc ;
   private java.math.BigDecimal[] H00H64_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] H00H64_A277LiqDValUni ;
   private boolean[] H00H64_n277LiqDValUni ;
   private String[] H00H64_A393DConDescrip ;
   private String[] H00H64_A394DConCodigo ;
   private String[] H00H64_A2149LiqDClasifAux ;
   private String[] H00H64_A464DTipoConCod ;
   private byte[] H00H64_A502LiqDMostrar ;
   private java.math.BigDecimal[] H00H64_A1469LiqDSeg ;
   private int[] H00H65_A81LiqDSecuencial ;
   private int[] H00H65_A3CliCod ;
   private int[] H00H65_A6LegNumero ;
   private int[] H00H65_A31LiqNro ;
   private short[] H00H65_A1EmpCod ;
   private String[] H00H65_A464DTipoConCod ;
   private java.math.BigDecimal[] H00H65_A275LiqDImpCalcu ;
   private boolean[] H00H65_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] H00H65_A1469LiqDSeg ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV102TFDTipoConCod_Sels ;
   private GXSimpleCollection<String> AV89TFDConCodigo_Sels ;
   private GXSimpleCollection<String> AV199TFLiqDClasifAux_Sels ;
   private GXSimpleCollection<String> AV92TFDConDescrip_Sels ;
   private GXSimpleCollection<String> AV124TFLiqDErrorDesc_Sels ;
   private GXSimpleCollection<String> AV180TFConClasifAux_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV58ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV216ActionGroup2Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item22 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item23[] ;
   private GXBaseCollection<web.Sdtsdt_liquidacion2_sdt_liquidacion2Item> AV192sdt_liquidacion2 ;
   private GXBaseCollection<web.Sdtsdt_liquidacion2_sdt_liquidacion2Item> GXv_objcol_Sdtsdt_liquidacion2_sdt_liquidacion2Item16[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item AV217ActionGroup2DataItem ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV15ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV16ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector19[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector20[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV21DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons9 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons10[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV37GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState29[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV38GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV172TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV177WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext17[] ;
}

final  class liquidacionverdetalle2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00H62( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                          String A2149LiqDClasifAux ,
                                          GXSimpleCollection<String> AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                          String A270LiqDErrorDesc ,
                                          GXSimpleCollection<String> AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                          String AV225Liquidacionverdetalle2ds_1_mostrar ,
                                          int AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size ,
                                          int AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size ,
                                          String AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                          int AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size ,
                                          String AV229Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                          int AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size ,
                                          String AV231Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                          java.math.BigDecimal AV233Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                          java.math.BigDecimal AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                          java.math.BigDecimal AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                          java.math.BigDecimal AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                          int AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size ,
                                          String AV237Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                          byte A502LiqDMostrar ,
                                          java.math.BigDecimal A277LiqDValUni ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          short AV63OrderedBy ,
                                          boolean AV65OrderedDsc ,
                                          int AV14CliCod ,
                                          short AV25EmpCod ,
                                          int AV9LiqNro ,
                                          int AV5LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int30 = new byte[15];
      Object[] GXv_Object31 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " LiqDOrdVis, LiqDImpCalcu, LiqDForOrig, LiqDSeg, LiqDLogRecal, LiqDSecuencial, DConOrden, LiqDMostrar, LiqDErrorDesc, LiqDReFormulaHTML, LiqDImpReCalcu, LiqDImporte," ;
      sSelectString += " LiqDCanti, LiqDValUni, DConDescrip, DConCodigo, LiqDClasifAux, DTipoConCod, CliCod, EmpCod, LiqNro, LegNumero" ;
      sFromString = " FROM LiquidacionDetalle" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      if ( GXutil.strcmp(AV225Liquidacionverdetalle2ds_1_mostrar, httpContext.getMessage( "RECIBO", "")) == 0 )
      {
         addWhere(sWhereString, "(LiqDMostrar = 3)");
      }
      if ( AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels, "DTipoConCod IN (", ")")+")");
      }
      if ( ( AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int30[4] = (byte)(1) ;
      }
      if ( AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels, "LiqDClasifAux IN (", ")")+")");
      }
      if ( ( AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV229Liquidacionverdetalle2ds_5_tfdconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int30[5] = (byte)(1) ;
      }
      if ( AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels, "DConCodigo IN (", ")")+")");
      }
      if ( ( AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV231Liquidacionverdetalle2ds_7_tfdcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int30[6] = (byte)(1) ;
      }
      if ( AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels, "DConDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV233Liquidacionverdetalle2ds_9_tfliqdvaluni)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni >= ?)");
      }
      else
      {
         GXv_int30[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni <= ?)");
      }
      else
      {
         GXv_int30[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int30[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int30[10] = (byte)(1) ;
      }
      if ( ( AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV237Liquidacionverdetalle2ds_13_tfliqderrordesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDErrorDesc) like LOWER(?))");
      }
      else
      {
         GXv_int30[11] = (byte)(1) ;
      }
      if ( AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels, "LiqDErrorDesc IN (", ")")+")");
      }
      if ( AV63OrderedBy == 1 )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDMostrar DESC, LiqDOrdVis, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 2 ) && ! AV65OrderedDsc )
      {
         sOrderString += " ORDER BY DTipoConCod, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 2 ) && ( AV65OrderedDsc ) )
      {
         sOrderString += " ORDER BY DTipoConCod DESC, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 3 ) && ! AV65OrderedDsc )
      {
         sOrderString += " ORDER BY LiqDClasifAux, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 3 ) && ( AV65OrderedDsc ) )
      {
         sOrderString += " ORDER BY LiqDClasifAux DESC, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 4 ) && ! AV65OrderedDsc )
      {
         sOrderString += " ORDER BY DConCodigo, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 4 ) && ( AV65OrderedDsc ) )
      {
         sOrderString += " ORDER BY DConCodigo DESC, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 5 ) && ! AV65OrderedDsc )
      {
         sOrderString += " ORDER BY DConDescrip, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 5 ) && ( AV65OrderedDsc ) )
      {
         sOrderString += " ORDER BY DConDescrip DESC, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 6 ) && ! AV65OrderedDsc )
      {
         sOrderString += " ORDER BY LiqDValUni, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 6 ) && ( AV65OrderedDsc ) )
      {
         sOrderString += " ORDER BY LiqDValUni DESC, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 7 ) && ! AV65OrderedDsc )
      {
         sOrderString += " ORDER BY LiqDImpReCalcu, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 7 ) && ( AV65OrderedDsc ) )
      {
         sOrderString += " ORDER BY LiqDImpReCalcu DESC, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 8 ) && ! AV65OrderedDsc )
      {
         sOrderString += " ORDER BY LiqDLogRecal, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV63OrderedBy == 8 ) && ( AV65OrderedDsc ) )
      {
         sOrderString += " ORDER BY LiqDLogRecal DESC, CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object31[0] = scmdbuf ;
      GXv_Object31[1] = GXv_int30 ;
      return GXv_Object31 ;
   }

   protected Object[] conditional_H00H63( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                          String A2149LiqDClasifAux ,
                                          GXSimpleCollection<String> AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                          String A270LiqDErrorDesc ,
                                          GXSimpleCollection<String> AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                          String AV225Liquidacionverdetalle2ds_1_mostrar ,
                                          int AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size ,
                                          int AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size ,
                                          String AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                          int AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size ,
                                          String AV229Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                          int AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size ,
                                          String AV231Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                          java.math.BigDecimal AV233Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                          java.math.BigDecimal AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                          java.math.BigDecimal AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                          java.math.BigDecimal AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                          int AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size ,
                                          String AV237Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                          byte A502LiqDMostrar ,
                                          java.math.BigDecimal A277LiqDValUni ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          short AV63OrderedBy ,
                                          boolean AV65OrderedDsc ,
                                          int AV14CliCod ,
                                          short AV25EmpCod ,
                                          int AV9LiqNro ,
                                          int AV5LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int33 = new byte[12];
      Object[] GXv_Object34 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      if ( GXutil.strcmp(AV225Liquidacionverdetalle2ds_1_mostrar, httpContext.getMessage( "RECIBO", "")) == 0 )
      {
         addWhere(sWhereString, "(LiqDMostrar = 3)");
      }
      if ( AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels, "DTipoConCod IN (", ")")+")");
      }
      if ( ( AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int33[4] = (byte)(1) ;
      }
      if ( AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels, "LiqDClasifAux IN (", ")")+")");
      }
      if ( ( AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV229Liquidacionverdetalle2ds_5_tfdconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int33[5] = (byte)(1) ;
      }
      if ( AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels, "DConCodigo IN (", ")")+")");
      }
      if ( ( AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV231Liquidacionverdetalle2ds_7_tfdcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int33[6] = (byte)(1) ;
      }
      if ( AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels, "DConDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV233Liquidacionverdetalle2ds_9_tfliqdvaluni)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni >= ?)");
      }
      else
      {
         GXv_int33[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni <= ?)");
      }
      else
      {
         GXv_int33[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int33[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int33[10] = (byte)(1) ;
      }
      if ( ( AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV237Liquidacionverdetalle2ds_13_tfliqderrordesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDErrorDesc) like LOWER(?))");
      }
      else
      {
         GXv_int33[11] = (byte)(1) ;
      }
      if ( AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels, "LiqDErrorDesc IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( AV63OrderedBy == 1 )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 2 ) && ! AV65OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 2 ) && ( AV65OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 3 ) && ! AV65OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 3 ) && ( AV65OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 4 ) && ! AV65OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 4 ) && ( AV65OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 5 ) && ! AV65OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 5 ) && ( AV65OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 6 ) && ! AV65OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 6 ) && ( AV65OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 7 ) && ! AV65OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 7 ) && ( AV65OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 8 ) && ! AV65OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV63OrderedBy == 8 ) && ( AV65OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object34[0] = scmdbuf ;
      GXv_Object34[1] = GXv_int33 ;
      return GXv_Object34 ;
   }

   protected Object[] conditional_H00H64( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                          String A2149LiqDClasifAux ,
                                          GXSimpleCollection<String> AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                          String A270LiqDErrorDesc ,
                                          GXSimpleCollection<String> AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                          String AV225Liquidacionverdetalle2ds_1_mostrar ,
                                          int AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size ,
                                          int AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size ,
                                          String AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                          int AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size ,
                                          String AV229Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                          int AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size ,
                                          String AV231Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                          java.math.BigDecimal AV233Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                          java.math.BigDecimal AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                          java.math.BigDecimal AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                          java.math.BigDecimal AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                          int AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size ,
                                          String AV237Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                          byte A502LiqDMostrar ,
                                          java.math.BigDecimal A277LiqDValUni ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          int AV14CliCod ,
                                          short AV25EmpCod ,
                                          int AV9LiqNro ,
                                          int AV5LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int36 = new byte[12];
      Object[] GXv_Object37 = new Object[2];
      scmdbuf = "SELECT LiqDSecuencial, CliCod, LegNumero, LiqNro, EmpCod, LiqDErrorDesc, LiqDImpReCalcu, LiqDValUni, DConDescrip, DConCodigo, LiqDClasifAux, DTipoConCod, LiqDMostrar," ;
      scmdbuf += " LiqDSeg FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      if ( GXutil.strcmp(AV225Liquidacionverdetalle2ds_1_mostrar, httpContext.getMessage( httpContext.getMessage( "RECIBO", ""), "")) == 0 )
      {
         addWhere(sWhereString, "(LiqDMostrar = 3)");
      }
      if ( AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV226Liquidacionverdetalle2ds_2_tfdtipoconcod_sels, "DTipoConCod IN (", ")")+")");
      }
      if ( ( AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV227Liquidacionverdetalle2ds_3_tfliqdclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int36[4] = (byte)(1) ;
      }
      if ( AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV228Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels, "LiqDClasifAux IN (", ")")+")");
      }
      if ( ( AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV229Liquidacionverdetalle2ds_5_tfdconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int36[5] = (byte)(1) ;
      }
      if ( AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV230Liquidacionverdetalle2ds_6_tfdconcodigo_sels, "DConCodigo IN (", ")")+")");
      }
      if ( ( AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV231Liquidacionverdetalle2ds_7_tfdcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int36[6] = (byte)(1) ;
      }
      if ( AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV232Liquidacionverdetalle2ds_8_tfdcondescrip_sels, "DConDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV233Liquidacionverdetalle2ds_9_tfliqdvaluni)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni >= ?)");
      }
      else
      {
         GXv_int36[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV234Liquidacionverdetalle2ds_10_tfliqdvaluni_to)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni <= ?)");
      }
      else
      {
         GXv_int36[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV235Liquidacionverdetalle2ds_11_tfliqdimprecalcu)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int36[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV236Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int36[10] = (byte)(1) ;
      }
      if ( ( AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV237Liquidacionverdetalle2ds_13_tfliqderrordesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDErrorDesc) like LOWER(?))");
      }
      else
      {
         GXv_int36[11] = (byte)(1) ;
      }
      if ( AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV238Liquidacionverdetalle2ds_14_tfliqderrordesc_sels, "LiqDErrorDesc IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero" ;
      GXv_Object37[0] = scmdbuf ;
      GXv_Object37[1] = GXv_int36 ;
      return GXv_Object37 ;
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
                  return conditional_H00H62(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).shortValue() , ((Boolean) dynConstraints[28]).booleanValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).intValue() );
            case 1 :
                  return conditional_H00H63(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).shortValue() , ((Boolean) dynConstraints[28]).booleanValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).intValue() );
            case 2 :
                  return conditional_H00H64(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00H62", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00H63", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00H64", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00H65", "SELECT LiqDSecuencial, CliCod, LegNumero, LiqNro, EmpCod, DTipoConCod, LiqDImpCalcu, LiqDSeg FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getLongVarchar(3);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,3);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getLongVarchar(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(13,2);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(14,2);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((String[]) buf[21])[0] = rslt.getString(16, 10);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getString(18, 20);
               ((int[]) buf[24])[0] = rslt.getInt(19);
               ((short[]) buf[25])[0] = rslt.getShort(20);
               ((int[]) buf[26])[0] = rslt.getInt(21);
               ((int[]) buf[27])[0] = rslt.getInt(22);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 10);
               ((String[]) buf[12])[0] = rslt.getVarchar(11);
               ((String[]) buf[13])[0] = rslt.getString(12, 20);
               ((byte[]) buf[14])[0] = rslt.getByte(13);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(14,3);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,3);
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
                  stmt.setInt(sIdx, ((Number) parms[17]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 80);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 400);
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
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 400);
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
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 80);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
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
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 400);
               }
               return;
            case 2 :
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
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 80);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
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
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 400);
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

