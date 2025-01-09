package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptos_export_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_44") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1112AplIIGG = (short)(GXutil.lval( httpContext.GetPar( "AplIIGG"))) ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_44( A3CliCod, A1112AplIIGG) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_46") == 0 )
      {
         A37TipoConCod = httpContext.GetPar( "TipoConCod") ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_46( A37TipoConCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_47") == 0 )
      {
         A37TipoConCod = httpContext.GetPar( "TipoConCod") ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
         A38SubTipoConCod1 = httpContext.GetPar( "SubTipoConCod1") ;
         n38SubTipoConCod1 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_47( A37TipoConCod, A38SubTipoConCod1) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_48") == 0 )
      {
         A37TipoConCod = httpContext.GetPar( "TipoConCod") ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
         A38SubTipoConCod1 = httpContext.GetPar( "SubTipoConCod1") ;
         n38SubTipoConCod1 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
         A39SubTipoConCod2 = httpContext.GetPar( "SubTipoConCod2") ;
         n39SubTipoConCod2 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_48( A37TipoConCod, A38SubTipoConCod1, A39SubTipoConCod2) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_49") == 0 )
      {
         A953ConCondicion = httpContext.GetPar( "ConCondicion") ;
         n953ConCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_49( A953ConCondicion) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_45") == 0 )
      {
         A1822CliPadre = (int)(GXutil.lval( httpContext.GetPar( "CliPadre"))) ;
         n1822CliPadre = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1822CliPadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1822CliPadre), 6, 0));
         A1112AplIIGG = (short)(GXutil.lval( httpContext.GetPar( "AplIIGG"))) ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_45( A1822CliPadre, A1112AplIIGG) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_50") == 0 )
      {
         A1644ConceptoPais = (short)(GXutil.lval( httpContext.GetPar( "ConceptoPais"))) ;
         n1644ConceptoPais = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1644ConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1644ConceptoPais), 4, 0));
         A1645ConceptoConveCodigo = httpContext.GetPar( "ConceptoConveCodigo") ;
         n1645ConceptoConveCodigo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1645ConceptoConveCodigo", A1645ConceptoConveCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_50( A1644ConceptoPais, A1645ConceptoConveCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_51") == 0 )
      {
         A1822CliPadre = (int)(GXutil.lval( httpContext.GetPar( "CliPadre"))) ;
         n1822CliPadre = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1822CliPadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1822CliPadre), 6, 0));
         A921ConPadre = httpContext.GetPar( "ConPadre") ;
         n921ConPadre = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A921ConPadre", A921ConPadre);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_51( A1822CliPadre, A921ConPadre) ;
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
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV8ConCodigo = httpContext.GetPar( "ConCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8ConCodigo", AV8ConCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8ConCodigo, ""))));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
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
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Conceptos_export", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public conceptos_export_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptos_export_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptos_export_impl.class ));
   }

   public conceptos_export_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
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
      cmbConBaseFer = new HTMLChoice();
      cmbConBaseHorExt = new HTMLChoice();
      cmbavCombotipoconcod = new HTMLChoice();
      cmbavComboconcondicion = new HTMLChoice();
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
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

   public void fix_multi_value_controls( )
   {
      if ( cmbConVigencia.getItemCount() > 0 )
      {
         A162ConVigencia = (byte)(GXutil.lval( cmbConVigencia.getValidValue(GXutil.trim( GXutil.str( A162ConVigencia, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConVigencia.setValue( GXutil.trim( GXutil.str( A162ConVigencia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConVigencia.getInternalname(), "Values", cmbConVigencia.ToJavascriptSource(), true);
      }
      A159ConVariable = GXutil.strtobool( GXutil.booltostr( A159ConVariable)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
      A146ConForEditable = GXutil.strtobool( GXutil.booltostr( A146ConForEditable)) ;
      n146ConForEditable = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A146ConForEditable", A146ConForEditable);
      if ( cmbTipoConCod.getItemCount() > 0 )
      {
         A37TipoConCod = cmbTipoConCod.getValidValue(A37TipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbTipoConCod.setValue( GXutil.rtrim( A37TipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Values", cmbTipoConCod.ToJavascriptSource(), true);
      }
      A762ConRecalcular = GXutil.strtobool( GXutil.booltostr( A762ConRecalcular)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
      if ( cmbConCondicion.getItemCount() > 0 )
      {
         A953ConCondicion = cmbConCondicion.getValidValue(A953ConCondicion) ;
         n953ConCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConCondicion.setValue( GXutil.rtrim( A953ConCondicion) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Values", cmbConCondicion.ToJavascriptSource(), true);
      }
      A1068ConMostrarPos = GXutil.strtobool( GXutil.booltostr( A1068ConMostrarPos)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1068ConMostrarPos", A1068ConMostrarPos);
      if ( cmbConAdelDescu.getItemCount() > 0 )
      {
         A1077ConAdelDescu = (byte)(GXutil.lval( cmbConAdelDescu.getValidValue(GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0))))) ;
         n1077ConAdelDescu = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAdelDescu.setValue( GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAdelDescu.getInternalname(), "Values", cmbConAdelDescu.ToJavascriptSource(), true);
      }
      A1194ConSegunPla = GXutil.strtobool( GXutil.booltostr( A1194ConSegunPla)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1194ConSegunPla", A1194ConSegunPla);
      if ( cmbConSacDeven.getItemCount() > 0 )
      {
         A1539ConSacDeven = (byte)(GXutil.lval( cmbConSacDeven.getValidValue(GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1539ConSacDeven", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1539ConSacDeven), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConSacDeven.setValue( GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConSacDeven.getInternalname(), "Values", cmbConSacDeven.ToJavascriptSource(), true);
      }
      if ( cmbConBaseLic.getItemCount() > 0 )
      {
         A1620ConBaseLic = (byte)(GXutil.lval( cmbConBaseLic.getValidValue(GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConBaseLic.setValue( GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseLic.getInternalname(), "Values", cmbConBaseLic.ToJavascriptSource(), true);
      }
      if ( cmbConBaseFer.getItemCount() > 0 )
      {
         A1621ConBaseFer = (byte)(GXutil.lval( cmbConBaseFer.getValidValue(GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConBaseFer.setValue( GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseFer.getInternalname(), "Values", cmbConBaseFer.ToJavascriptSource(), true);
      }
      if ( cmbConBaseHorExt.getItemCount() > 0 )
      {
         A1622ConBaseHorExt = (byte)(GXutil.lval( cmbConBaseHorExt.getValidValue(GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConBaseHorExt.setValue( GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConBaseHorExt.getInternalname(), "Values", cmbConBaseHorExt.ToJavascriptSource(), true);
      }
      if ( cmbavCombotipoconcod.getItemCount() > 0 )
      {
         AV26ComboTipoConCod = cmbavCombotipoconcod.getValidValue(AV26ComboTipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ComboTipoConCod", AV26ComboTipoConCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavCombotipoconcod.setValue( GXutil.rtrim( AV26ComboTipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavCombotipoconcod.getInternalname(), "Values", cmbavCombotipoconcod.ToJavascriptSource(), true);
      }
      if ( cmbavComboconcondicion.getItemCount() > 0 )
      {
         AV35ComboConCondicion = cmbavComboconcondicion.getValidValue(AV35ComboConCondicion) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35ComboConCondicion", AV35ComboConCondicion);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavComboconcondicion.setValue( GXutil.rtrim( AV35ComboConCondicion) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavComboconcondicion.getInternalname(), "Values", cmbavComboconcondicion.ToJavascriptSource(), true);
      }
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliCod_Internalname, httpContext.getMessage( "Cli Cod", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConCodigo_Internalname, GXutil.rtrim( A26ConCodigo), GXutil.rtrim( localUtil.format( A26ConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConCodigo_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtConDescrip_Internalname, A41ConDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", (short)(0), 1, edtConDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConOrden_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConOrden_Internalname, httpContext.getMessage( "Orden", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConOrden_Internalname, GXutil.ltrim( localUtil.ntoc( A40ConOrden, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConOrden_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A40ConOrden), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A40ConOrden), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConOrden_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConOrden_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConVigencia.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConVigencia.getInternalname(), httpContext.getMessage( "Vigencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConVigencia, cmbConVigencia.getInternalname(), GXutil.trim( GXutil.str( A162ConVigencia, 1, 0)), 1, cmbConVigencia.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConVigencia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(0), "HLP_Conceptos_export.htm");
      cmbConVigencia.setValue( GXutil.trim( GXutil.str( A162ConVigencia, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConVigencia.getInternalname(), "Values", cmbConVigencia.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConLiqBasica_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConLiqBasica_Internalname, httpContext.getMessage( "Basica (borrar)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConLiqBasica_Internalname, GXutil.ltrim( localUtil.ntoc( A1488ConLiqBasica, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConLiqBasica_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1488ConLiqBasica), "9") : localUtil.format( DecimalUtil.doubleToDec(A1488ConLiqBasica), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConLiqBasica_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConLiqBasica_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConFormula_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConFormula_Internalname, httpContext.getMessage( "Formula", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtConFormula_Internalname, A148ConFormula, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", (short)(0), 1, edtConFormula_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConObservacion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConObservacion_Internalname, httpContext.getMessage( "Observacion", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtConObservacion_Internalname, A153ConObservacion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", (short)(0), 1, edtConObservacion_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConVariable.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConVariable.getInternalname(), httpContext.getMessage( "Remuneración variable", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConVariable.getInternalname(), GXutil.booltostr( A159ConVariable), "", httpContext.getMessage( "Remuneración variable", ""), 1, chkConVariable.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(62, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,62);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConForEditable.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConForEditable.getInternalname(), httpContext.getMessage( "Editable (borrar)", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConForEditable.getInternalname(), GXutil.booltostr( A146ConForEditable), "", httpContext.getMessage( "Editable (borrar)", ""), 1, chkConForEditable.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(67, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,67);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedtipoconcod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktipoconcod_Internalname, httpContext.getMessage( "Tipo De Concepto", ""), "", "", lblTextblocktipoconcod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_tipoconcod.setProperty("Caption", Combo_tipoconcod_Caption);
      ucCombo_tipoconcod.setProperty("Cls", Combo_tipoconcod_Cls);
      ucCombo_tipoconcod.setProperty("DataListProc", Combo_tipoconcod_Datalistproc);
      ucCombo_tipoconcod.setProperty("DataListProcParametersPrefix", Combo_tipoconcod_Datalistprocparametersprefix);
      ucCombo_tipoconcod.setProperty("EmptyItem", Combo_tipoconcod_Emptyitem);
      ucCombo_tipoconcod.setProperty("DropDownOptionsTitleSettingsIcons", AV22DDO_TitleSettingsIcons);
      ucCombo_tipoconcod.setProperty("DropDownOptionsData", AV21TipoConCod_Data);
      ucCombo_tipoconcod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_tipoconcod_Internalname, "COMBO_TIPOCONCODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbTipoConCod.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 0, true, "");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbTipoConCod, cmbTipoConCod.getInternalname(), GXutil.rtrim( A37TipoConCod), 1, cmbTipoConCod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbTipoConCod.getVisible(), cmbTipoConCod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,78);\"", "", true, (byte)(0), "HLP_Conceptos_export.htm");
      cmbTipoConCod.setValue( GXutil.rtrim( A37TipoConCod) );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Values", cmbTipoConCod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedsubtipoconcod1_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksubtipoconcod1_Internalname, httpContext.getMessage( "Tipo De Concepto", ""), "", "", lblTextblocksubtipoconcod1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_subtipoconcod1.setProperty("Caption", Combo_subtipoconcod1_Caption);
      ucCombo_subtipoconcod1.setProperty("Cls", Combo_subtipoconcod1_Cls);
      ucCombo_subtipoconcod1.setProperty("DataListProc", Combo_subtipoconcod1_Datalistproc);
      ucCombo_subtipoconcod1.setProperty("DropDownOptionsTitleSettingsIcons", AV22DDO_TitleSettingsIcons);
      ucCombo_subtipoconcod1.setProperty("DropDownOptionsData", AV27SubTipoConCod1_Data);
      ucCombo_subtipoconcod1.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_subtipoconcod1_Internalname, "COMBO_SUBTIPOCONCOD1Container");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSubTipoConCod1_Internalname, httpContext.getMessage( "Clasificación", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSubTipoConCod1_Internalname, GXutil.rtrim( A38SubTipoConCod1), GXutil.rtrim( localUtil.format( A38SubTipoConCod1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,89);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSubTipoConCod1_Jsonclick, 0, "Attribute", "", "", "", "", edtSubTipoConCod1_Visible, edtSubTipoConCod1_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedsubtipoconcod2_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksubtipoconcod2_Internalname, httpContext.getMessage( "Tipo De Concepto", ""), "", "", lblTextblocksubtipoconcod2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_subtipoconcod2.setProperty("Caption", Combo_subtipoconcod2_Caption);
      ucCombo_subtipoconcod2.setProperty("Cls", Combo_subtipoconcod2_Cls);
      ucCombo_subtipoconcod2.setProperty("DataListProc", Combo_subtipoconcod2_Datalistproc);
      ucCombo_subtipoconcod2.setProperty("DropDownOptionsTitleSettingsIcons", AV22DDO_TitleSettingsIcons);
      ucCombo_subtipoconcod2.setProperty("DropDownOptionsData", AV30SubTipoConCod2_Data);
      ucCombo_subtipoconcod2.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_subtipoconcod2_Internalname, "COMBO_SUBTIPOCONCOD2Container");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSubTipoConCod2_Internalname, httpContext.getMessage( "Sub clasif.", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSubTipoConCod2_Internalname, GXutil.rtrim( A39SubTipoConCod2), GXutil.rtrim( localUtil.format( A39SubTipoConCod2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,100);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSubTipoConCod2_Jsonclick, 0, "Attribute", "", "", "", "", edtSubTipoConCod2_Visible, edtSubTipoConCod2_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConTipoLiqAux_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConTipoLiqAux_Internalname, httpContext.getMessage( "Liq Aux", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 105,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConTipoLiqAux_Internalname, A503ConTipoLiqAux, GXutil.rtrim( localUtil.format( A503ConTipoLiqAux, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,105);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConTipoLiqAux_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConTipoLiqAux_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConClasifAux_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConClasifAux_Internalname, httpContext.getMessage( "Clasificación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 110,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConClasifAux_Internalname, A970ConClasifAux, GXutil.rtrim( localUtil.format( A970ConClasifAux, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,110);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConClasifAux_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConClasifAux_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConOrdEjec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConOrdEjec_Internalname, httpContext.getMessage( "Ord Ejec", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 115,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConOrdEjec_Internalname, GXutil.ltrim( localUtil.ntoc( A510ConOrdEjec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConOrdEjec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A510ConOrdEjec), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A510ConOrdEjec), "ZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,115);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConOrdEjec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConOrdEjec_Enabled, 0, "text", "1", 12, "chr", 1, "row", 12, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConFormulaExpl_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConFormulaExpl_Internalname, httpContext.getMessage( "Formula Expl", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtConFormulaExpl_Internalname, A569ConFormulaExpl, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,120);\"", (short)(0), 1, edtConFormulaExpl_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConRecalcular.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConRecalcular.getInternalname(), httpContext.getMessage( "Recalcular por impuesto a las ganancias", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 125,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConRecalcular.getInternalname(), GXutil.booltostr( A762ConRecalcular), "", httpContext.getMessage( "Recalcular por impuesto a las ganancias", ""), 1, chkConRecalcular.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(125, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,125);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConRangoCant_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConRangoCant_Internalname, httpContext.getMessage( "Rango de valores para cantidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 130,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtConRangoCant_Internalname, A1018ConRangoCant, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,130);\"", (short)(0), 1, edtConRangoCant_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedconcondicion_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockconcondicion_Internalname, httpContext.getMessage( "Condición para liquidación", ""), "", "", lblTextblockconcondicion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_concondicion.setProperty("Caption", Combo_concondicion_Caption);
      ucCombo_concondicion.setProperty("Cls", Combo_concondicion_Cls);
      ucCombo_concondicion.setProperty("DataListProc", Combo_concondicion_Datalistproc);
      ucCombo_concondicion.setProperty("DataListProcParametersPrefix", Combo_concondicion_Datalistprocparametersprefix);
      ucCombo_concondicion.setProperty("DropDownOptionsTitleSettingsIcons", AV22DDO_TitleSettingsIcons);
      ucCombo_concondicion.setProperty("DropDownOptionsData", AV34ConCondicion_Data);
      ucCombo_concondicion.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_concondicion_Internalname, "COMBO_CONCONDICIONContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConCondicion.getInternalname(), httpContext.getMessage( "Condición para liquidación", ""), "col-sm-3 AttributeLabel", 0, true, "");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 141,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConCondicion, cmbConCondicion.getInternalname(), GXutil.rtrim( A953ConCondicion), 1, cmbConCondicion.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbConCondicion.getVisible(), cmbConCondicion.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,141);\"", "", true, (byte)(0), "HLP_Conceptos_export.htm");
      cmbConCondicion.setValue( GXutil.rtrim( A953ConCondicion) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Values", cmbConCondicion.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConCondCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConCondCodigo_Internalname, httpContext.getMessage( "Código relacionado a la condición", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 146,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConCondCodigo_Internalname, GXutil.rtrim( A954ConCondCodigo), GXutil.rtrim( localUtil.format( A954ConCondCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,146);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCondCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConCondCodigo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConMostrarPos.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConMostrarPos.getInternalname(), httpContext.getMessage( "Mostrar en recibo solo si es mayor a cero", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 151,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConMostrarPos.getInternalname(), GXutil.booltostr( A1068ConMostrarPos), "", httpContext.getMessage( "Mostrar en recibo solo si es mayor a cero", ""), 1, chkConMostrarPos.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(151, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,151);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAdelDescu.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAdelDescu.getInternalname(), httpContext.getMessage( "Adelanto/Descuento", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 156,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAdelDescu, cmbConAdelDescu.getInternalname(), GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0)), 1, cmbConAdelDescu.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConAdelDescu.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,156);\"", "", true, (byte)(0), "HLP_Conceptos_export.htm");
      cmbConAdelDescu.setValue( GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAdelDescu.getInternalname(), "Values", cmbConAdelDescu.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAplIIGG_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAplIIGG_Internalname, httpContext.getMessage( "Tratamiento IIGG Nro", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 161,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAplIIGG_Internalname, GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1112AplIIGG), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,161);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAplIIGG_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAplIIGG_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConSegunPla.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConSegunPla.getInternalname(), httpContext.getMessage( "Si no se cumple la condición, liquidar en segundo plano a posteriori", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 166,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConSegunPla.getInternalname(), GXutil.booltostr( A1194ConSegunPla), "", httpContext.getMessage( "Si no se cumple la condición, liquidar en segundo plano a posteriori", ""), 1, chkConSegunPla.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(166, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,166);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConNumero_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConNumero_Internalname, httpContext.getMessage( "Numero", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 171,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A1471ConNumero, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1471ConNumero), "9") : localUtil.format( DecimalUtil.doubleToDec(A1471ConNumero), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,171);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConNumero_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConCodAfip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConCodAfip_Internalname, httpContext.getMessage( "Concepto AFIP", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 176,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConCodAfip_Internalname, GXutil.rtrim( A1648ConCodAfip), GXutil.rtrim( localUtil.format( A1648ConCodAfip, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,176);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodAfip_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConCodAfip_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConSIPAApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConSIPAApo_Internalname, httpContext.getMessage( "SIPAApo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 181,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConSIPAApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1472ConSIPAApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConSIPAApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1472ConSIPAApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1472ConSIPAApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,181);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConSIPAApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConSIPAApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConSIPACont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConSIPACont_Internalname, httpContext.getMessage( "SIPACont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 186,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConSIPACont_Internalname, GXutil.ltrim( localUtil.ntoc( A1473ConSIPACont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConSIPACont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1473ConSIPACont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1473ConSIPACont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,186);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConSIPACont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConSIPACont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConINSSJyPApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConINSSJyPApo_Internalname, httpContext.getMessage( "INSSJy PApo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 191,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConINSSJyPApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1474ConINSSJyPApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConINSSJyPApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1474ConINSSJyPApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1474ConINSSJyPApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,191);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConINSSJyPApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConINSSJyPApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConINSSJyPCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConINSSJyPCont_Internalname, httpContext.getMessage( "INSSJy PCont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 196,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConINSSJyPCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1475ConINSSJyPCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConINSSJyPCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1475ConINSSJyPCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1475ConINSSJyPCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,196);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConINSSJyPCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConINSSJyPCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConObraSocApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConObraSocApo_Internalname, httpContext.getMessage( "Soc Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 201,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConObraSocApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1476ConObraSocApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConObraSocApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1476ConObraSocApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1476ConObraSocApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,201);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConObraSocApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConObraSocApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      drawcontrols1( ) ;
   }

   public void drawcontrols1( )
   {
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConObraSocCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConObraSocCont_Internalname, httpContext.getMessage( "Soc Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 206,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConObraSocCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1477ConObraSocCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConObraSocCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1477ConObraSocCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1477ConObraSocCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,206);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConObraSocCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConObraSocCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConFonSolRedApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConFonSolRedApo_Internalname, httpContext.getMessage( "Red Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 211,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConFonSolRedApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1478ConFonSolRedApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConFonSolRedApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1478ConFonSolRedApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1478ConFonSolRedApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,211);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConFonSolRedApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConFonSolRedApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConFonSolRedCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConFonSolRedCont_Internalname, httpContext.getMessage( "Red Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 216,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConFonSolRedCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1479ConFonSolRedCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConFonSolRedCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1479ConFonSolRedCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1479ConFonSolRedCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,216);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConFonSolRedCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConFonSolRedCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConRenateaApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConRenateaApo_Internalname, httpContext.getMessage( "Renatea Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 221,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConRenateaApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1480ConRenateaApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConRenateaApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1480ConRenateaApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1480ConRenateaApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,221);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConRenateaApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConRenateaApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConRenateaCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConRenateaCont_Internalname, httpContext.getMessage( "Renatea Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 226,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConRenateaCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1481ConRenateaCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConRenateaCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1481ConRenateaCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1481ConRenateaCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,226);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConRenateaCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConRenateaCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConAsigFamCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConAsigFamCont_Internalname, httpContext.getMessage( "Fam Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 231,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConAsigFamCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1482ConAsigFamCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConAsigFamCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1482ConAsigFamCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1482ConAsigFamCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,231);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConAsigFamCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConAsigFamCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConFonNacEmpCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConFonNacEmpCont_Internalname, httpContext.getMessage( "Emp Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 236,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConFonNacEmpCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1483ConFonNacEmpCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConFonNacEmpCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1483ConFonNacEmpCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1483ConFonNacEmpCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,236);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConFonNacEmpCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConFonNacEmpCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConLeyRieTrabCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConLeyRieTrabCont_Internalname, httpContext.getMessage( "Trab Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 241,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConLeyRieTrabCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1484ConLeyRieTrabCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConLeyRieTrabCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1484ConLeyRieTrabCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1484ConLeyRieTrabCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,241);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConLeyRieTrabCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConLeyRieTrabCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConRegDifApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConRegDifApo_Internalname, httpContext.getMessage( "Dif Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 246,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConRegDifApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1485ConRegDifApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConRegDifApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1485ConRegDifApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1485ConRegDifApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,246);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConRegDifApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConRegDifApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConRegEspApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConRegEspApo_Internalname, httpContext.getMessage( "Esp Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 251,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConRegEspApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1486ConRegEspApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConRegEspApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1486ConRegEspApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1486ConRegEspApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,251);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConRegEspApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConRegEspApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConSacDeven.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConSacDeven.getInternalname(), httpContext.getMessage( "Tipo devengamiento", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 256,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConSacDeven, cmbConSacDeven.getInternalname(), GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0)), 1, cmbConSacDeven.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConSacDeven.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,256);\"", "", true, (byte)(0), "HLP_Conceptos_export.htm");
      cmbConSacDeven.setValue( GXutil.trim( GXutil.str( A1539ConSacDeven, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConSacDeven.getInternalname(), "Values", cmbConSacDeven.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConceptoPais_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConceptoPais_Internalname, httpContext.getMessage( "Pais", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 261,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConceptoPais_Internalname, GXutil.ltrim( localUtil.ntoc( A1644ConceptoPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1644ConceptoPais), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,261);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConceptoPais_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConceptoPais_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConceptoConveCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConceptoConveCodigo_Internalname, httpContext.getMessage( "Convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 266,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConceptoConveCodigo_Internalname, GXutil.rtrim( A1645ConceptoConveCodigo), GXutil.rtrim( localUtil.format( A1645ConceptoConveCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,266);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConceptoConveCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConceptoConveCodigo_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConBaseLic.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConBaseLic.getInternalname(), httpContext.getMessage( "Base de cálculo para licencias de remuneraciòn actual", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 271,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConBaseLic, cmbConBaseLic.getInternalname(), GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0)), 1, cmbConBaseLic.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConBaseLic.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,271);\"", "", true, (byte)(0), "HLP_Conceptos_export.htm");
      cmbConBaseLic.setValue( GXutil.trim( GXutil.str( A1620ConBaseLic, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseLic.getInternalname(), "Values", cmbConBaseLic.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConBaseFer.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConBaseFer.getInternalname(), httpContext.getMessage( "Base de cálculo para feriados de remuneración actual", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 276,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConBaseFer, cmbConBaseFer.getInternalname(), GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0)), 1, cmbConBaseFer.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConBaseFer.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,276);\"", "", true, (byte)(0), "HLP_Conceptos_export.htm");
      cmbConBaseFer.setValue( GXutil.trim( GXutil.str( A1621ConBaseFer, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseFer.getInternalname(), "Values", cmbConBaseFer.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConBaseHorExt.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConBaseHorExt.getInternalname(), httpContext.getMessage( "Base de cálculo para horas extras de remuneración actual", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 281,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConBaseHorExt, cmbConBaseHorExt.getInternalname(), GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0)), 1, cmbConBaseHorExt.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConBaseHorExt.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,281);\"", "", true, (byte)(0), "HLP_Conceptos_export.htm");
      cmbConBaseHorExt.setValue( GXutil.trim( GXutil.str( A1622ConBaseHorExt, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseHorExt.getInternalname(), "Values", cmbConBaseHorExt.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 289,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 291,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 293,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
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
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_tipoconcod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavCombotipoconcod, cmbavCombotipoconcod.getInternalname(), GXutil.rtrim( AV26ComboTipoConCod), 1, cmbavCombotipoconcod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavCombotipoconcod.getVisible(), cmbavCombotipoconcod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Conceptos_export.htm");
      cmbavCombotipoconcod.setValue( GXutil.rtrim( AV26ComboTipoConCod) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCombotipoconcod.getInternalname(), "Values", cmbavCombotipoconcod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_subtipoconcod1_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombosubtipoconcod1_Internalname, GXutil.rtrim( AV28ComboSubTipoConCod1), GXutil.rtrim( localUtil.format( AV28ComboSubTipoConCod1, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombosubtipoconcod1_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombosubtipoconcod1_Visible, edtavCombosubtipoconcod1_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_subtipoconcod2_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombosubtipoconcod2_Internalname, GXutil.rtrim( AV31ComboSubTipoConCod2), GXutil.rtrim( localUtil.format( AV31ComboSubTipoConCod2, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombosubtipoconcod2_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombosubtipoconcod2_Visible, edtavCombosubtipoconcod2_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Conceptos_export.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_concondicion_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavComboconcondicion, cmbavComboconcondicion.getInternalname(), GXutil.rtrim( AV35ComboConCondicion), 1, cmbavComboconcondicion.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavComboconcondicion.getVisible(), cmbavComboconcondicion.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Conceptos_export.htm");
      cmbavComboconcondicion.setValue( GXutil.rtrim( AV35ComboConCondicion) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavComboconcondicion.getInternalname(), "Values", cmbavComboconcondicion.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11572 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV22DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vTIPOCONCOD_DATA"), AV21TipoConCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSUBTIPOCONCOD1_DATA"), AV27SubTipoConCod1_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSUBTIPOCONCOD2_DATA"), AV30SubTipoConCod2_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCONCONDICION_DATA"), AV34ConCondicion_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z26ConCodigo = httpContext.cgiGet( "Z26ConCodigo") ;
            Z42ConCodYDesc = httpContext.cgiGet( "Z42ConCodYDesc") ;
            Z41ConDescrip = httpContext.cgiGet( "Z41ConDescrip") ;
            Z40ConOrden = (int)(localUtil.ctol( httpContext.cgiGet( "Z40ConOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z162ConVigencia = (byte)(localUtil.ctol( httpContext.cgiGet( "Z162ConVigencia"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1488ConLiqBasica = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1488ConLiqBasica"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z159ConVariable = GXutil.strtobool( httpContext.cgiGet( "Z159ConVariable")) ;
            Z146ConForEditable = GXutil.strtobool( httpContext.cgiGet( "Z146ConForEditable")) ;
            n146ConForEditable = ((false==A146ConForEditable) ? true : false) ;
            Z503ConTipoLiqAux = httpContext.cgiGet( "Z503ConTipoLiqAux") ;
            n503ConTipoLiqAux = ((GXutil.strcmp("", A503ConTipoLiqAux)==0) ? true : false) ;
            Z970ConClasifAux = httpContext.cgiGet( "Z970ConClasifAux") ;
            n970ConClasifAux = ((GXutil.strcmp("", A970ConClasifAux)==0) ? true : false) ;
            Z510ConOrdEjec = localUtil.ctol( httpContext.cgiGet( "Z510ConOrdEjec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z762ConRecalcular = GXutil.strtobool( httpContext.cgiGet( "Z762ConRecalcular")) ;
            Z1018ConRangoCant = httpContext.cgiGet( "Z1018ConRangoCant") ;
            Z954ConCondCodigo = httpContext.cgiGet( "Z954ConCondCodigo") ;
            Z1068ConMostrarPos = GXutil.strtobool( httpContext.cgiGet( "Z1068ConMostrarPos")) ;
            Z1077ConAdelDescu = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1077ConAdelDescu"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1077ConAdelDescu = ((0==A1077ConAdelDescu) ? true : false) ;
            Z1194ConSegunPla = GXutil.strtobool( httpContext.cgiGet( "Z1194ConSegunPla")) ;
            Z1471ConNumero = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1471ConNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1648ConCodAfip = httpContext.cgiGet( "Z1648ConCodAfip") ;
            Z1472ConSIPAApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1472ConSIPAApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1473ConSIPACont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1473ConSIPACont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1474ConINSSJyPApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1474ConINSSJyPApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1475ConINSSJyPCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1475ConINSSJyPCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1476ConObraSocApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1476ConObraSocApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1477ConObraSocCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1477ConObraSocCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1478ConFonSolRedApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1478ConFonSolRedApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1479ConFonSolRedCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1479ConFonSolRedCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1480ConRenateaApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1480ConRenateaApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1481ConRenateaCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1481ConRenateaCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1482ConAsigFamCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1482ConAsigFamCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1483ConFonNacEmpCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1483ConFonNacEmpCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1484ConLeyRieTrabCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1484ConLeyRieTrabCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1485ConRegDifApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1485ConRegDifApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1486ConRegEspApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1486ConRegEspApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1539ConSacDeven = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1539ConSacDeven"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1620ConBaseLic = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1620ConBaseLic"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1797ConBaseLicProm = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1797ConBaseLicProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1621ConBaseFer = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1621ConBaseFer"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1798ConBaseFerProm = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1798ConBaseFerProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1622ConBaseHorExt = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1622ConBaseHorExt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1799ConBaseHorExtProm = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1799ConBaseHorExtProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1800ConBasePres = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1800ConBasePres"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1801ConBaseAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1801ConBaseAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1827ConBaseOSDif = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1827ConBaseOSDif"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1821ConErrorSiCero = GXutil.strtobool( httpContext.cgiGet( "Z1821ConErrorSiCero")) ;
            Z1826ConPueNov = GXutil.strtobool( httpContext.cgiGet( "Z1826ConPueNov")) ;
            Z1822CliPadre = (int)(localUtil.ctol( httpContext.cgiGet( "Z1822CliPadre"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1822CliPadre = ((0==A1822CliPadre) ? true : false) ;
            Z1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( "Z1112AplIIGG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1112AplIIGG = ((0==A1112AplIIGG) ? true : false) ;
            Z37TipoConCod = httpContext.cgiGet( "Z37TipoConCod") ;
            Z38SubTipoConCod1 = httpContext.cgiGet( "Z38SubTipoConCod1") ;
            n38SubTipoConCod1 = ((GXutil.strcmp("", A38SubTipoConCod1)==0) ? true : false) ;
            Z39SubTipoConCod2 = httpContext.cgiGet( "Z39SubTipoConCod2") ;
            n39SubTipoConCod2 = ((GXutil.strcmp("", A39SubTipoConCod2)==0) ? true : false) ;
            Z953ConCondicion = httpContext.cgiGet( "Z953ConCondicion") ;
            n953ConCondicion = ((GXutil.strcmp("", A953ConCondicion)==0) ? true : false) ;
            Z1644ConceptoPais = (short)(localUtil.ctol( httpContext.cgiGet( "Z1644ConceptoPais"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1644ConceptoPais = ((0==A1644ConceptoPais) ? true : false) ;
            Z1645ConceptoConveCodigo = httpContext.cgiGet( "Z1645ConceptoConveCodigo") ;
            n1645ConceptoConveCodigo = ((GXutil.strcmp("", A1645ConceptoConveCodigo)==0) ? true : false) ;
            Z921ConPadre = httpContext.cgiGet( "Z921ConPadre") ;
            n921ConPadre = ((GXutil.strcmp("", A921ConPadre)==0) ? true : false) ;
            A42ConCodYDesc = httpContext.cgiGet( "Z42ConCodYDesc") ;
            n42ConCodYDesc = false ;
            A1797ConBaseLicProm = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1797ConBaseLicProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1798ConBaseFerProm = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1798ConBaseFerProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1799ConBaseHorExtProm = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1799ConBaseHorExtProm"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1800ConBasePres = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1800ConBasePres"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1801ConBaseAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1801ConBaseAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1827ConBaseOSDif = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1827ConBaseOSDif"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1821ConErrorSiCero = GXutil.strtobool( httpContext.cgiGet( "Z1821ConErrorSiCero")) ;
            A1826ConPueNov = GXutil.strtobool( httpContext.cgiGet( "Z1826ConPueNov")) ;
            A1822CliPadre = (int)(localUtil.ctol( httpContext.cgiGet( "Z1822CliPadre"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1822CliPadre = false ;
            n1822CliPadre = ((0==A1822CliPadre) ? true : false) ;
            A921ConPadre = httpContext.cgiGet( "Z921ConPadre") ;
            n921ConPadre = false ;
            n921ConPadre = ((GXutil.strcmp("", A921ConPadre)==0) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N37TipoConCod = httpContext.cgiGet( "N37TipoConCod") ;
            N38SubTipoConCod1 = httpContext.cgiGet( "N38SubTipoConCod1") ;
            n38SubTipoConCod1 = ((GXutil.strcmp("", A38SubTipoConCod1)==0) ? true : false) ;
            N39SubTipoConCod2 = httpContext.cgiGet( "N39SubTipoConCod2") ;
            n39SubTipoConCod2 = ((GXutil.strcmp("", A39SubTipoConCod2)==0) ? true : false) ;
            N953ConCondicion = httpContext.cgiGet( "N953ConCondicion") ;
            n953ConCondicion = ((GXutil.strcmp("", A953ConCondicion)==0) ? true : false) ;
            N1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( "N1112AplIIGG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1112AplIIGG = ((0==A1112AplIIGG) ? true : false) ;
            N1644ConceptoPais = (short)(localUtil.ctol( httpContext.cgiGet( "N1644ConceptoPais"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1644ConceptoPais = ((0==A1644ConceptoPais) ? true : false) ;
            N1645ConceptoConveCodigo = httpContext.cgiGet( "N1645ConceptoConveCodigo") ;
            n1645ConceptoConveCodigo = ((GXutil.strcmp("", A1645ConceptoConveCodigo)==0) ? true : false) ;
            N1822CliPadre = (int)(localUtil.ctol( httpContext.cgiGet( "N1822CliPadre"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1822CliPadre = ((0==A1822CliPadre) ? true : false) ;
            N921ConPadre = httpContext.cgiGet( "N921ConPadre") ;
            n921ConPadre = ((GXutil.strcmp("", A921ConPadre)==0) ? true : false) ;
            AV29Cond_TipoConCod = httpContext.cgiGet( "vCOND_TIPOCONCOD") ;
            AV32Cond_SubTipoConCod1 = httpContext.cgiGet( "vCOND_SUBTIPOCONCOD1") ;
            A42ConCodYDesc = httpContext.cgiGet( "CONCODYDESC") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8ConCodigo = httpContext.cgiGet( "vCONCODIGO") ;
            AV14Insert_TipoConCod = httpContext.cgiGet( "vINSERT_TIPOCONCOD") ;
            AV15Insert_SubTipoConCod1 = httpContext.cgiGet( "vINSERT_SUBTIPOCONCOD1") ;
            AV16Insert_SubTipoConCod2 = httpContext.cgiGet( "vINSERT_SUBTIPOCONCOD2") ;
            AV33Insert_ConCondicion = httpContext.cgiGet( "vINSERT_CONCONDICION") ;
            AV17Insert_AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_APLIIGG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV18Insert_ConceptoPais = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CONCEPTOPAIS"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV19Insert_ConceptoConveCodigo = httpContext.cgiGet( "vINSERT_CONCEPTOCONVECODIGO") ;
            AV36Insert_CliPadre = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CLIPADRE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1822CliPadre = (int)(localUtil.ctol( httpContext.cgiGet( "CLIPADRE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1822CliPadre = ((0==A1822CliPadre) ? true : false) ;
            AV37Insert_ConPadre = httpContext.cgiGet( "vINSERT_CONPADRE") ;
            A921ConPadre = httpContext.cgiGet( "CONPADRE") ;
            n921ConPadre = ((GXutil.strcmp("", A921ConPadre)==0) ? true : false) ;
            A1797ConBaseLicProm = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASELICPROM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1798ConBaseFerProm = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEFERPROM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1799ConBaseHorExtProm = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEHOREXTPROM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1800ConBasePres = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEPRES"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1801ConBaseAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEANT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1827ConBaseOSDif = (byte)(localUtil.ctol( httpContext.cgiGet( "CONBASEOSDIF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1821ConErrorSiCero = GXutil.strtobool( httpContext.cgiGet( "CONERRORSICERO")) ;
            A1826ConPueNov = GXutil.strtobool( httpContext.cgiGet( "CONPUENOV")) ;
            AV38Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_tipoconcod_Objectcall = httpContext.cgiGet( "COMBO_TIPOCONCOD_Objectcall") ;
            Combo_tipoconcod_Class = httpContext.cgiGet( "COMBO_TIPOCONCOD_Class") ;
            Combo_tipoconcod_Icontype = httpContext.cgiGet( "COMBO_TIPOCONCOD_Icontype") ;
            Combo_tipoconcod_Icon = httpContext.cgiGet( "COMBO_TIPOCONCOD_Icon") ;
            Combo_tipoconcod_Caption = httpContext.cgiGet( "COMBO_TIPOCONCOD_Caption") ;
            Combo_tipoconcod_Tooltip = httpContext.cgiGet( "COMBO_TIPOCONCOD_Tooltip") ;
            Combo_tipoconcod_Cls = httpContext.cgiGet( "COMBO_TIPOCONCOD_Cls") ;
            Combo_tipoconcod_Selectedvalue_set = httpContext.cgiGet( "COMBO_TIPOCONCOD_Selectedvalue_set") ;
            Combo_tipoconcod_Selectedvalue_get = httpContext.cgiGet( "COMBO_TIPOCONCOD_Selectedvalue_get") ;
            Combo_tipoconcod_Selectedtext_set = httpContext.cgiGet( "COMBO_TIPOCONCOD_Selectedtext_set") ;
            Combo_tipoconcod_Selectedtext_get = httpContext.cgiGet( "COMBO_TIPOCONCOD_Selectedtext_get") ;
            Combo_tipoconcod_Gamoauthtoken = httpContext.cgiGet( "COMBO_TIPOCONCOD_Gamoauthtoken") ;
            Combo_tipoconcod_Ddointernalname = httpContext.cgiGet( "COMBO_TIPOCONCOD_Ddointernalname") ;
            Combo_tipoconcod_Titlecontrolalign = httpContext.cgiGet( "COMBO_TIPOCONCOD_Titlecontrolalign") ;
            Combo_tipoconcod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_TIPOCONCOD_Dropdownoptionstype") ;
            Combo_tipoconcod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONCOD_Enabled")) ;
            Combo_tipoconcod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONCOD_Visible")) ;
            Combo_tipoconcod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_TIPOCONCOD_Titlecontrolidtoreplace") ;
            Combo_tipoconcod_Datalisttype = httpContext.cgiGet( "COMBO_TIPOCONCOD_Datalisttype") ;
            Combo_tipoconcod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONCOD_Allowmultipleselection")) ;
            Combo_tipoconcod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_TIPOCONCOD_Datalistfixedvalues") ;
            Combo_tipoconcod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONCOD_Isgriditem")) ;
            Combo_tipoconcod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONCOD_Hasdescription")) ;
            Combo_tipoconcod_Datalistproc = httpContext.cgiGet( "COMBO_TIPOCONCOD_Datalistproc") ;
            Combo_tipoconcod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_TIPOCONCOD_Datalistprocparametersprefix") ;
            Combo_tipoconcod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_TIPOCONCOD_Remoteservicesparameters") ;
            Combo_tipoconcod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_TIPOCONCOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_tipoconcod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONCOD_Includeonlyselectedoption")) ;
            Combo_tipoconcod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONCOD_Includeselectalloption")) ;
            Combo_tipoconcod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONCOD_Emptyitem")) ;
            Combo_tipoconcod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPOCONCOD_Includeaddnewoption")) ;
            Combo_tipoconcod_Htmltemplate = httpContext.cgiGet( "COMBO_TIPOCONCOD_Htmltemplate") ;
            Combo_tipoconcod_Multiplevaluestype = httpContext.cgiGet( "COMBO_TIPOCONCOD_Multiplevaluestype") ;
            Combo_tipoconcod_Loadingdata = httpContext.cgiGet( "COMBO_TIPOCONCOD_Loadingdata") ;
            Combo_tipoconcod_Noresultsfound = httpContext.cgiGet( "COMBO_TIPOCONCOD_Noresultsfound") ;
            Combo_tipoconcod_Emptyitemtext = httpContext.cgiGet( "COMBO_TIPOCONCOD_Emptyitemtext") ;
            Combo_tipoconcod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_TIPOCONCOD_Onlyselectedvalues") ;
            Combo_tipoconcod_Selectalltext = httpContext.cgiGet( "COMBO_TIPOCONCOD_Selectalltext") ;
            Combo_tipoconcod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_TIPOCONCOD_Multiplevaluesseparator") ;
            Combo_tipoconcod_Addnewoptiontext = httpContext.cgiGet( "COMBO_TIPOCONCOD_Addnewoptiontext") ;
            Combo_tipoconcod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_TIPOCONCOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_subtipoconcod1_Objectcall = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Objectcall") ;
            Combo_subtipoconcod1_Class = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Class") ;
            Combo_subtipoconcod1_Icontype = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Icontype") ;
            Combo_subtipoconcod1_Icon = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Icon") ;
            Combo_subtipoconcod1_Caption = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Caption") ;
            Combo_subtipoconcod1_Tooltip = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Tooltip") ;
            Combo_subtipoconcod1_Cls = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Cls") ;
            Combo_subtipoconcod1_Selectedvalue_set = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Selectedvalue_set") ;
            Combo_subtipoconcod1_Selectedvalue_get = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Selectedvalue_get") ;
            Combo_subtipoconcod1_Selectedtext_set = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Selectedtext_set") ;
            Combo_subtipoconcod1_Selectedtext_get = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Selectedtext_get") ;
            Combo_subtipoconcod1_Gamoauthtoken = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Gamoauthtoken") ;
            Combo_subtipoconcod1_Ddointernalname = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Ddointernalname") ;
            Combo_subtipoconcod1_Titlecontrolalign = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Titlecontrolalign") ;
            Combo_subtipoconcod1_Dropdownoptionstype = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Dropdownoptionstype") ;
            Combo_subtipoconcod1_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Enabled")) ;
            Combo_subtipoconcod1_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Visible")) ;
            Combo_subtipoconcod1_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Titlecontrolidtoreplace") ;
            Combo_subtipoconcod1_Datalisttype = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Datalisttype") ;
            Combo_subtipoconcod1_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Allowmultipleselection")) ;
            Combo_subtipoconcod1_Datalistfixedvalues = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Datalistfixedvalues") ;
            Combo_subtipoconcod1_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Isgriditem")) ;
            Combo_subtipoconcod1_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Hasdescription")) ;
            Combo_subtipoconcod1_Datalistproc = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Datalistproc") ;
            Combo_subtipoconcod1_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Datalistprocparametersprefix") ;
            Combo_subtipoconcod1_Remoteservicesparameters = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Remoteservicesparameters") ;
            Combo_subtipoconcod1_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_subtipoconcod1_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Includeonlyselectedoption")) ;
            Combo_subtipoconcod1_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Includeselectalloption")) ;
            Combo_subtipoconcod1_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Emptyitem")) ;
            Combo_subtipoconcod1_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Includeaddnewoption")) ;
            Combo_subtipoconcod1_Htmltemplate = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Htmltemplate") ;
            Combo_subtipoconcod1_Multiplevaluestype = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Multiplevaluestype") ;
            Combo_subtipoconcod1_Loadingdata = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Loadingdata") ;
            Combo_subtipoconcod1_Noresultsfound = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Noresultsfound") ;
            Combo_subtipoconcod1_Emptyitemtext = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Emptyitemtext") ;
            Combo_subtipoconcod1_Onlyselectedvalues = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Onlyselectedvalues") ;
            Combo_subtipoconcod1_Selectalltext = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Selectalltext") ;
            Combo_subtipoconcod1_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Multiplevaluesseparator") ;
            Combo_subtipoconcod1_Addnewoptiontext = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Addnewoptiontext") ;
            Combo_subtipoconcod1_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD1_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_subtipoconcod2_Objectcall = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Objectcall") ;
            Combo_subtipoconcod2_Class = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Class") ;
            Combo_subtipoconcod2_Icontype = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Icontype") ;
            Combo_subtipoconcod2_Icon = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Icon") ;
            Combo_subtipoconcod2_Caption = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Caption") ;
            Combo_subtipoconcod2_Tooltip = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Tooltip") ;
            Combo_subtipoconcod2_Cls = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Cls") ;
            Combo_subtipoconcod2_Selectedvalue_set = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Selectedvalue_set") ;
            Combo_subtipoconcod2_Selectedvalue_get = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Selectedvalue_get") ;
            Combo_subtipoconcod2_Selectedtext_set = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Selectedtext_set") ;
            Combo_subtipoconcod2_Selectedtext_get = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Selectedtext_get") ;
            Combo_subtipoconcod2_Gamoauthtoken = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Gamoauthtoken") ;
            Combo_subtipoconcod2_Ddointernalname = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Ddointernalname") ;
            Combo_subtipoconcod2_Titlecontrolalign = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Titlecontrolalign") ;
            Combo_subtipoconcod2_Dropdownoptionstype = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Dropdownoptionstype") ;
            Combo_subtipoconcod2_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Enabled")) ;
            Combo_subtipoconcod2_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Visible")) ;
            Combo_subtipoconcod2_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Titlecontrolidtoreplace") ;
            Combo_subtipoconcod2_Datalisttype = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Datalisttype") ;
            Combo_subtipoconcod2_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Allowmultipleselection")) ;
            Combo_subtipoconcod2_Datalistfixedvalues = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Datalistfixedvalues") ;
            Combo_subtipoconcod2_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Isgriditem")) ;
            Combo_subtipoconcod2_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Hasdescription")) ;
            Combo_subtipoconcod2_Datalistproc = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Datalistproc") ;
            Combo_subtipoconcod2_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Datalistprocparametersprefix") ;
            Combo_subtipoconcod2_Remoteservicesparameters = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Remoteservicesparameters") ;
            Combo_subtipoconcod2_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_subtipoconcod2_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Includeonlyselectedoption")) ;
            Combo_subtipoconcod2_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Includeselectalloption")) ;
            Combo_subtipoconcod2_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Emptyitem")) ;
            Combo_subtipoconcod2_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Includeaddnewoption")) ;
            Combo_subtipoconcod2_Htmltemplate = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Htmltemplate") ;
            Combo_subtipoconcod2_Multiplevaluestype = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Multiplevaluestype") ;
            Combo_subtipoconcod2_Loadingdata = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Loadingdata") ;
            Combo_subtipoconcod2_Noresultsfound = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Noresultsfound") ;
            Combo_subtipoconcod2_Emptyitemtext = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Emptyitemtext") ;
            Combo_subtipoconcod2_Onlyselectedvalues = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Onlyselectedvalues") ;
            Combo_subtipoconcod2_Selectalltext = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Selectalltext") ;
            Combo_subtipoconcod2_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Multiplevaluesseparator") ;
            Combo_subtipoconcod2_Addnewoptiontext = httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Addnewoptiontext") ;
            Combo_subtipoconcod2_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SUBTIPOCONCOD2_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_concondicion_Objectcall = httpContext.cgiGet( "COMBO_CONCONDICION_Objectcall") ;
            Combo_concondicion_Class = httpContext.cgiGet( "COMBO_CONCONDICION_Class") ;
            Combo_concondicion_Icontype = httpContext.cgiGet( "COMBO_CONCONDICION_Icontype") ;
            Combo_concondicion_Icon = httpContext.cgiGet( "COMBO_CONCONDICION_Icon") ;
            Combo_concondicion_Caption = httpContext.cgiGet( "COMBO_CONCONDICION_Caption") ;
            Combo_concondicion_Tooltip = httpContext.cgiGet( "COMBO_CONCONDICION_Tooltip") ;
            Combo_concondicion_Cls = httpContext.cgiGet( "COMBO_CONCONDICION_Cls") ;
            Combo_concondicion_Selectedvalue_set = httpContext.cgiGet( "COMBO_CONCONDICION_Selectedvalue_set") ;
            Combo_concondicion_Selectedvalue_get = httpContext.cgiGet( "COMBO_CONCONDICION_Selectedvalue_get") ;
            Combo_concondicion_Selectedtext_set = httpContext.cgiGet( "COMBO_CONCONDICION_Selectedtext_set") ;
            Combo_concondicion_Selectedtext_get = httpContext.cgiGet( "COMBO_CONCONDICION_Selectedtext_get") ;
            Combo_concondicion_Gamoauthtoken = httpContext.cgiGet( "COMBO_CONCONDICION_Gamoauthtoken") ;
            Combo_concondicion_Ddointernalname = httpContext.cgiGet( "COMBO_CONCONDICION_Ddointernalname") ;
            Combo_concondicion_Titlecontrolalign = httpContext.cgiGet( "COMBO_CONCONDICION_Titlecontrolalign") ;
            Combo_concondicion_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CONCONDICION_Dropdownoptionstype") ;
            Combo_concondicion_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCONDICION_Enabled")) ;
            Combo_concondicion_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCONDICION_Visible")) ;
            Combo_concondicion_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CONCONDICION_Titlecontrolidtoreplace") ;
            Combo_concondicion_Datalisttype = httpContext.cgiGet( "COMBO_CONCONDICION_Datalisttype") ;
            Combo_concondicion_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCONDICION_Allowmultipleselection")) ;
            Combo_concondicion_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CONCONDICION_Datalistfixedvalues") ;
            Combo_concondicion_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCONDICION_Isgriditem")) ;
            Combo_concondicion_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCONDICION_Hasdescription")) ;
            Combo_concondicion_Datalistproc = httpContext.cgiGet( "COMBO_CONCONDICION_Datalistproc") ;
            Combo_concondicion_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CONCONDICION_Datalistprocparametersprefix") ;
            Combo_concondicion_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CONCONDICION_Remoteservicesparameters") ;
            Combo_concondicion_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONCONDICION_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_concondicion_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCONDICION_Includeonlyselectedoption")) ;
            Combo_concondicion_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCONDICION_Includeselectalloption")) ;
            Combo_concondicion_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCONDICION_Emptyitem")) ;
            Combo_concondicion_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCONDICION_Includeaddnewoption")) ;
            Combo_concondicion_Htmltemplate = httpContext.cgiGet( "COMBO_CONCONDICION_Htmltemplate") ;
            Combo_concondicion_Multiplevaluestype = httpContext.cgiGet( "COMBO_CONCONDICION_Multiplevaluestype") ;
            Combo_concondicion_Loadingdata = httpContext.cgiGet( "COMBO_CONCONDICION_Loadingdata") ;
            Combo_concondicion_Noresultsfound = httpContext.cgiGet( "COMBO_CONCONDICION_Noresultsfound") ;
            Combo_concondicion_Emptyitemtext = httpContext.cgiGet( "COMBO_CONCONDICION_Emptyitemtext") ;
            Combo_concondicion_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CONCONDICION_Onlyselectedvalues") ;
            Combo_concondicion_Selectalltext = httpContext.cgiGet( "COMBO_CONCONDICION_Selectalltext") ;
            Combo_concondicion_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CONCONDICION_Multiplevaluesseparator") ;
            Combo_concondicion_Addnewoptiontext = httpContext.cgiGet( "COMBO_CONCONDICION_Addnewoptiontext") ;
            Combo_concondicion_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONCONDICION_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3CliCod = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            else
            {
               A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            A41ConDescrip = httpContext.cgiGet( edtConDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONORDEN");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConOrden_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A40ConOrden = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A40ConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40ConOrden), 8, 0));
            }
            else
            {
               A40ConOrden = (int)(localUtil.ctol( httpContext.cgiGet( edtConOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A40ConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40ConOrden), 8, 0));
            }
            cmbConVigencia.setValue( httpContext.cgiGet( cmbConVigencia.getInternalname()) );
            A162ConVigencia = (byte)(GXutil.lval( httpContext.cgiGet( cmbConVigencia.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConLiqBasica_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConLiqBasica_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONLIQBASICA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConLiqBasica_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1488ConLiqBasica = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1488ConLiqBasica", GXutil.str( A1488ConLiqBasica, 1, 0));
            }
            else
            {
               A1488ConLiqBasica = (byte)(localUtil.ctol( httpContext.cgiGet( edtConLiqBasica_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1488ConLiqBasica", GXutil.str( A1488ConLiqBasica, 1, 0));
            }
            A148ConFormula = httpContext.cgiGet( edtConFormula_Internalname) ;
            n148ConFormula = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A148ConFormula", A148ConFormula);
            n148ConFormula = ((GXutil.strcmp("", A148ConFormula)==0) ? true : false) ;
            A153ConObservacion = httpContext.cgiGet( edtConObservacion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A153ConObservacion", A153ConObservacion);
            A159ConVariable = GXutil.strtobool( httpContext.cgiGet( chkConVariable.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
            A146ConForEditable = GXutil.strtobool( httpContext.cgiGet( chkConForEditable.getInternalname())) ;
            n146ConForEditable = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A146ConForEditable", A146ConForEditable);
            n146ConForEditable = ((false==A146ConForEditable) ? true : false) ;
            cmbTipoConCod.setValue( httpContext.cgiGet( cmbTipoConCod.getInternalname()) );
            A37TipoConCod = httpContext.cgiGet( cmbTipoConCod.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
            A38SubTipoConCod1 = httpContext.cgiGet( edtSubTipoConCod1_Internalname) ;
            n38SubTipoConCod1 = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
            n38SubTipoConCod1 = ((GXutil.strcmp("", A38SubTipoConCod1)==0) ? true : false) ;
            A39SubTipoConCod2 = httpContext.cgiGet( edtSubTipoConCod2_Internalname) ;
            n39SubTipoConCod2 = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
            n39SubTipoConCod2 = ((GXutil.strcmp("", A39SubTipoConCod2)==0) ? true : false) ;
            A503ConTipoLiqAux = httpContext.cgiGet( edtConTipoLiqAux_Internalname) ;
            n503ConTipoLiqAux = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A503ConTipoLiqAux", A503ConTipoLiqAux);
            n503ConTipoLiqAux = ((GXutil.strcmp("", A503ConTipoLiqAux)==0) ? true : false) ;
            A970ConClasifAux = httpContext.cgiGet( edtConClasifAux_Internalname) ;
            n970ConClasifAux = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A970ConClasifAux", A970ConClasifAux);
            n970ConClasifAux = ((GXutil.strcmp("", A970ConClasifAux)==0) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConOrdEjec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < -99999999999L ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConOrdEjec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONORDEJEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConOrdEjec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A510ConOrdEjec = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A510ConOrdEjec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A510ConOrdEjec), 12, 0));
            }
            else
            {
               A510ConOrdEjec = localUtil.ctol( httpContext.cgiGet( edtConOrdEjec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A510ConOrdEjec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A510ConOrdEjec), 12, 0));
            }
            A569ConFormulaExpl = httpContext.cgiGet( edtConFormulaExpl_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A569ConFormulaExpl", A569ConFormulaExpl);
            A762ConRecalcular = GXutil.strtobool( httpContext.cgiGet( chkConRecalcular.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
            A1018ConRangoCant = httpContext.cgiGet( edtConRangoCant_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1018ConRangoCant", A1018ConRangoCant);
            cmbConCondicion.setValue( httpContext.cgiGet( cmbConCondicion.getInternalname()) );
            A953ConCondicion = httpContext.cgiGet( cmbConCondicion.getInternalname()) ;
            n953ConCondicion = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
            n953ConCondicion = ((GXutil.strcmp("", A953ConCondicion)==0) ? true : false) ;
            A954ConCondCodigo = httpContext.cgiGet( edtConCondCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A954ConCondCodigo", A954ConCondCodigo);
            A1068ConMostrarPos = GXutil.strtobool( httpContext.cgiGet( chkConMostrarPos.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1068ConMostrarPos", A1068ConMostrarPos);
            cmbConAdelDescu.setValue( httpContext.cgiGet( cmbConAdelDescu.getInternalname()) );
            A1077ConAdelDescu = (byte)(GXutil.lval( httpContext.cgiGet( cmbConAdelDescu.getInternalname()))) ;
            n1077ConAdelDescu = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
            n1077ConAdelDescu = ((0==A1077ConAdelDescu) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtAplIIGG_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtAplIIGG_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "APLIIGG");
               AnyError = (short)(1) ;
               GX_FocusControl = edtAplIIGG_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1112AplIIGG = (short)(0) ;
               n1112AplIIGG = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
            }
            else
            {
               A1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( edtAplIIGG_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1112AplIIGG = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
            }
            n1112AplIIGG = ((0==A1112AplIIGG) ? true : false) ;
            A1194ConSegunPla = GXutil.strtobool( httpContext.cgiGet( chkConSegunPla.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1194ConSegunPla", A1194ConSegunPla);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONNUMERO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1471ConNumero = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1471ConNumero", GXutil.str( A1471ConNumero, 1, 0));
            }
            else
            {
               A1471ConNumero = (byte)(localUtil.ctol( httpContext.cgiGet( edtConNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1471ConNumero", GXutil.str( A1471ConNumero, 1, 0));
            }
            A1648ConCodAfip = httpContext.cgiGet( edtConCodAfip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1648ConCodAfip", A1648ConCodAfip);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConSIPAApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConSIPAApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONSIPAAPO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConSIPAApo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1472ConSIPAApo = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1472ConSIPAApo", GXutil.str( A1472ConSIPAApo, 1, 0));
            }
            else
            {
               A1472ConSIPAApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConSIPAApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1472ConSIPAApo", GXutil.str( A1472ConSIPAApo, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConSIPACont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConSIPACont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONSIPACONT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConSIPACont_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1473ConSIPACont = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1473ConSIPACont", GXutil.str( A1473ConSIPACont, 1, 0));
            }
            else
            {
               A1473ConSIPACont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConSIPACont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1473ConSIPACont", GXutil.str( A1473ConSIPACont, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConINSSJyPApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConINSSJyPApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONINSSJYPAPO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConINSSJyPApo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1474ConINSSJyPApo = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1474ConINSSJyPApo", GXutil.str( A1474ConINSSJyPApo, 1, 0));
            }
            else
            {
               A1474ConINSSJyPApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConINSSJyPApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1474ConINSSJyPApo", GXutil.str( A1474ConINSSJyPApo, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConINSSJyPCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConINSSJyPCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONINSSJYPCONT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConINSSJyPCont_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1475ConINSSJyPCont = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1475ConINSSJyPCont", GXutil.str( A1475ConINSSJyPCont, 1, 0));
            }
            else
            {
               A1475ConINSSJyPCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConINSSJyPCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1475ConINSSJyPCont", GXutil.str( A1475ConINSSJyPCont, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConObraSocApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConObraSocApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONOBRASOCAPO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConObraSocApo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1476ConObraSocApo = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1476ConObraSocApo", GXutil.str( A1476ConObraSocApo, 1, 0));
            }
            else
            {
               A1476ConObraSocApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConObraSocApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1476ConObraSocApo", GXutil.str( A1476ConObraSocApo, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConObraSocCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConObraSocCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONOBRASOCCONT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConObraSocCont_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1477ConObraSocCont = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1477ConObraSocCont", GXutil.str( A1477ConObraSocCont, 1, 0));
            }
            else
            {
               A1477ConObraSocCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConObraSocCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1477ConObraSocCont", GXutil.str( A1477ConObraSocCont, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConFonSolRedApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConFonSolRedApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONFONSOLREDAPO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConFonSolRedApo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1478ConFonSolRedApo = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1478ConFonSolRedApo", GXutil.str( A1478ConFonSolRedApo, 1, 0));
            }
            else
            {
               A1478ConFonSolRedApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConFonSolRedApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1478ConFonSolRedApo", GXutil.str( A1478ConFonSolRedApo, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConFonSolRedCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConFonSolRedCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONFONSOLREDCONT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConFonSolRedCont_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1479ConFonSolRedCont = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1479ConFonSolRedCont", GXutil.str( A1479ConFonSolRedCont, 1, 0));
            }
            else
            {
               A1479ConFonSolRedCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConFonSolRedCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1479ConFonSolRedCont", GXutil.str( A1479ConFonSolRedCont, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConRenateaApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConRenateaApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONRENATEAAPO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConRenateaApo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1480ConRenateaApo = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1480ConRenateaApo", GXutil.str( A1480ConRenateaApo, 1, 0));
            }
            else
            {
               A1480ConRenateaApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConRenateaApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1480ConRenateaApo", GXutil.str( A1480ConRenateaApo, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConRenateaCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConRenateaCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONRENATEACONT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConRenateaCont_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1481ConRenateaCont = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1481ConRenateaCont", GXutil.str( A1481ConRenateaCont, 1, 0));
            }
            else
            {
               A1481ConRenateaCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConRenateaCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1481ConRenateaCont", GXutil.str( A1481ConRenateaCont, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConAsigFamCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConAsigFamCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONASIGFAMCONT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConAsigFamCont_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1482ConAsigFamCont = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1482ConAsigFamCont", GXutil.str( A1482ConAsigFamCont, 1, 0));
            }
            else
            {
               A1482ConAsigFamCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConAsigFamCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1482ConAsigFamCont", GXutil.str( A1482ConAsigFamCont, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConFonNacEmpCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConFonNacEmpCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONFONNACEMPCONT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConFonNacEmpCont_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1483ConFonNacEmpCont = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1483ConFonNacEmpCont", GXutil.str( A1483ConFonNacEmpCont, 1, 0));
            }
            else
            {
               A1483ConFonNacEmpCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConFonNacEmpCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1483ConFonNacEmpCont", GXutil.str( A1483ConFonNacEmpCont, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConLeyRieTrabCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConLeyRieTrabCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONLEYRIETRABCONT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConLeyRieTrabCont_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1484ConLeyRieTrabCont = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1484ConLeyRieTrabCont", GXutil.str( A1484ConLeyRieTrabCont, 1, 0));
            }
            else
            {
               A1484ConLeyRieTrabCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtConLeyRieTrabCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1484ConLeyRieTrabCont", GXutil.str( A1484ConLeyRieTrabCont, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConRegDifApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConRegDifApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONREGDIFAPO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConRegDifApo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1485ConRegDifApo = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1485ConRegDifApo", GXutil.str( A1485ConRegDifApo, 1, 0));
            }
            else
            {
               A1485ConRegDifApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConRegDifApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1485ConRegDifApo", GXutil.str( A1485ConRegDifApo, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConRegEspApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConRegEspApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONREGESPAPO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConRegEspApo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1486ConRegEspApo = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1486ConRegEspApo", GXutil.str( A1486ConRegEspApo, 1, 0));
            }
            else
            {
               A1486ConRegEspApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtConRegEspApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1486ConRegEspApo", GXutil.str( A1486ConRegEspApo, 1, 0));
            }
            cmbConSacDeven.setValue( httpContext.cgiGet( cmbConSacDeven.getInternalname()) );
            A1539ConSacDeven = (byte)(GXutil.lval( httpContext.cgiGet( cmbConSacDeven.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1539ConSacDeven", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1539ConSacDeven), 2, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConceptoPais_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConceptoPais_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONCEPTOPAIS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConceptoPais_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1644ConceptoPais = (short)(0) ;
               n1644ConceptoPais = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1644ConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1644ConceptoPais), 4, 0));
            }
            else
            {
               A1644ConceptoPais = (short)(localUtil.ctol( httpContext.cgiGet( edtConceptoPais_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1644ConceptoPais = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1644ConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1644ConceptoPais), 4, 0));
            }
            n1644ConceptoPais = ((0==A1644ConceptoPais) ? true : false) ;
            A1645ConceptoConveCodigo = httpContext.cgiGet( edtConceptoConveCodigo_Internalname) ;
            n1645ConceptoConveCodigo = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1645ConceptoConveCodigo", A1645ConceptoConveCodigo);
            n1645ConceptoConveCodigo = ((GXutil.strcmp("", A1645ConceptoConveCodigo)==0) ? true : false) ;
            cmbConBaseLic.setValue( httpContext.cgiGet( cmbConBaseLic.getInternalname()) );
            A1620ConBaseLic = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseLic.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
            cmbConBaseFer.setValue( httpContext.cgiGet( cmbConBaseFer.getInternalname()) );
            A1621ConBaseFer = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseFer.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
            cmbConBaseHorExt.setValue( httpContext.cgiGet( cmbConBaseHorExt.getInternalname()) );
            A1622ConBaseHorExt = (byte)(GXutil.lval( httpContext.cgiGet( cmbConBaseHorExt.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
            cmbavCombotipoconcod.setValue( httpContext.cgiGet( cmbavCombotipoconcod.getInternalname()) );
            AV26ComboTipoConCod = httpContext.cgiGet( cmbavCombotipoconcod.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ComboTipoConCod", AV26ComboTipoConCod);
            AV28ComboSubTipoConCod1 = httpContext.cgiGet( edtavCombosubtipoconcod1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28ComboSubTipoConCod1", AV28ComboSubTipoConCod1);
            AV31ComboSubTipoConCod2 = httpContext.cgiGet( edtavCombosubtipoconcod2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31ComboSubTipoConCod2", AV31ComboSubTipoConCod2);
            cmbavComboconcondicion.setValue( httpContext.cgiGet( cmbavComboconcondicion.getInternalname()) );
            AV35ComboConCondicion = httpContext.cgiGet( cmbavComboconcondicion.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35ComboConCondicion", AV35ComboConCondicion);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Conceptos_export");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ConBaseLicProm", localUtil.format( DecimalUtil.doubleToDec(A1797ConBaseLicProm), "9"));
            forbiddenHiddens.add("ConBaseFerProm", localUtil.format( DecimalUtil.doubleToDec(A1798ConBaseFerProm), "9"));
            forbiddenHiddens.add("ConBaseHorExtProm", localUtil.format( DecimalUtil.doubleToDec(A1799ConBaseHorExtProm), "9"));
            forbiddenHiddens.add("ConBasePres", localUtil.format( DecimalUtil.doubleToDec(A1800ConBasePres), "9"));
            forbiddenHiddens.add("ConBaseAnt", localUtil.format( DecimalUtil.doubleToDec(A1801ConBaseAnt), "9"));
            forbiddenHiddens.add("ConBaseOSDif", localUtil.format( DecimalUtil.doubleToDec(A1827ConBaseOSDif), "9"));
            forbiddenHiddens.add("ConErrorSiCero", GXutil.booltostr( A1821ConErrorSiCero));
            forbiddenHiddens.add("ConPueNov", GXutil.booltostr( A1826ConPueNov));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("conceptos_export:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A26ConCodigo = httpContext.GetPar( "ConCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode7 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode7 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound7 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_570( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
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
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e11572 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12572 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
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

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e12572 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll577( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes577( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, cmbavCombotipoconcod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavCombotipoconcod.getEnabled(), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosubtipoconcod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosubtipoconcod1_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosubtipoconcod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosubtipoconcod2_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, cmbavComboconcondicion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavComboconcondicion.getEnabled(), 5, 0), true);
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_570( )
   {
      beforeValidate577( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls577( ) ;
         }
         else
         {
            checkExtendedTable577( ) ;
            closeExtendedTableCursors577( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption570( )
   {
   }

   public void e11572( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV22DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV22DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      cmbConCondicion.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Visible", GXutil.ltrimstr( cmbConCondicion.getVisible(), 5, 0), true);
      AV35ComboConCondicion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35ComboConCondicion", AV35ComboConCondicion);
      cmbavComboconcondicion.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavComboconcondicion.getInternalname(), "Visible", GXutil.ltrimstr( cmbavComboconcondicion.getVisible(), 5, 0), true);
      edtSubTipoConCod2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod2_Visible), 5, 0), true);
      AV31ComboSubTipoConCod2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31ComboSubTipoConCod2", AV31ComboSubTipoConCod2);
      edtavCombosubtipoconcod2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosubtipoconcod2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosubtipoconcod2_Visible), 5, 0), true);
      edtSubTipoConCod1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod1_Visible), 5, 0), true);
      AV28ComboSubTipoConCod1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28ComboSubTipoConCod1", AV28ComboSubTipoConCod1);
      edtavCombosubtipoconcod1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosubtipoconcod1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosubtipoconcod1_Visible), 5, 0), true);
      cmbTipoConCod.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Visible", GXutil.ltrimstr( cmbTipoConCod.getVisible(), 5, 0), true);
      AV26ComboTipoConCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ComboTipoConCod", AV26ComboTipoConCod);
      cmbavCombotipoconcod.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCombotipoconcod.getInternalname(), "Visible", GXutil.ltrimstr( cmbavCombotipoconcod.getVisible(), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOTIPOCONCOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(9);
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOSUBTIPOCONCOD1' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(9);
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOSUBTIPOCONCOD2' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(9);
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOCONCONDICION' */
      S142 ();
      if ( returnInSub )
      {
         pr_default.close(9);
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV10IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptos_export_Insert", GXv_boolean5) ;
         conceptos_export_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptos_export_Update", GXv_boolean5) ;
         conceptos_export_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptos_export_Delete", GXv_boolean5) ;
         conceptos_export_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV38Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV12TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV38Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV39GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39GXV1), 8, 0));
         while ( AV39GXV1 <= AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV20TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV39GXV1));
            if ( GXutil.strcmp(AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TipoConCod") == 0 )
            {
               AV14Insert_TipoConCod = AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_TipoConCod", AV14Insert_TipoConCod);
               if ( ! (GXutil.strcmp("", AV14Insert_TipoConCod)==0) )
               {
                  AV26ComboTipoConCod = AV14Insert_TipoConCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV26ComboTipoConCod", AV26ComboTipoConCod);
                  Combo_tipoconcod_Selectedvalue_set = AV26ComboTipoConCod ;
                  ucCombo_tipoconcod.sendProperty(context, "", false, Combo_tipoconcod_Internalname, "SelectedValue_set", Combo_tipoconcod_Selectedvalue_set);
                  GXt_char6 = AV25Combo_DataJson ;
                  GXv_char7[0] = AV23ComboSelectedValue ;
                  GXv_char8[0] = AV24ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.conceptos_exportloaddvcombo(remoteHandle, context).execute( "TipoConCod", "GET", false, AV7CliCod, AV8ConCodigo, A37TipoConCod, A38SubTipoConCod1, AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  conceptos_export_impl.this.AV23ComboSelectedValue = GXv_char7[0] ;
                  conceptos_export_impl.this.AV24ComboSelectedText = GXv_char8[0] ;
                  conceptos_export_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedValue", AV23ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV24ComboSelectedText", AV24ComboSelectedText);
                  AV25Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV25Combo_DataJson", AV25Combo_DataJson);
                  Combo_tipoconcod_Selectedtext_set = AV24ComboSelectedText ;
                  ucCombo_tipoconcod.sendProperty(context, "", false, Combo_tipoconcod_Internalname, "SelectedText_set", Combo_tipoconcod_Selectedtext_set);
                  Combo_tipoconcod_Enabled = false ;
                  ucCombo_tipoconcod.sendProperty(context, "", false, Combo_tipoconcod_Internalname, "Enabled", GXutil.booltostr( Combo_tipoconcod_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SubTipoConCod1") == 0 )
            {
               AV15Insert_SubTipoConCod1 = AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15Insert_SubTipoConCod1", AV15Insert_SubTipoConCod1);
               if ( ! (GXutil.strcmp("", AV15Insert_SubTipoConCod1)==0) )
               {
                  AV28ComboSubTipoConCod1 = AV15Insert_SubTipoConCod1 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV28ComboSubTipoConCod1", AV28ComboSubTipoConCod1);
                  Combo_subtipoconcod1_Selectedvalue_set = AV28ComboSubTipoConCod1 ;
                  ucCombo_subtipoconcod1.sendProperty(context, "", false, Combo_subtipoconcod1_Internalname, "SelectedValue_set", Combo_subtipoconcod1_Selectedvalue_set);
                  GXt_char6 = AV25Combo_DataJson ;
                  GXv_char9[0] = AV23ComboSelectedValue ;
                  GXv_char8[0] = AV24ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.conceptos_exportloaddvcombo(remoteHandle, context).execute( "SubTipoConCod1", "GET", false, AV7CliCod, AV8ConCodigo, AV14Insert_TipoConCod, A38SubTipoConCod1, AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  conceptos_export_impl.this.AV23ComboSelectedValue = GXv_char9[0] ;
                  conceptos_export_impl.this.AV24ComboSelectedText = GXv_char8[0] ;
                  conceptos_export_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedValue", AV23ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV24ComboSelectedText", AV24ComboSelectedText);
                  AV25Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV25Combo_DataJson", AV25Combo_DataJson);
                  Combo_subtipoconcod1_Selectedtext_set = AV24ComboSelectedText ;
                  ucCombo_subtipoconcod1.sendProperty(context, "", false, Combo_subtipoconcod1_Internalname, "SelectedText_set", Combo_subtipoconcod1_Selectedtext_set);
                  Combo_subtipoconcod1_Enabled = false ;
                  ucCombo_subtipoconcod1.sendProperty(context, "", false, Combo_subtipoconcod1_Internalname, "Enabled", GXutil.booltostr( Combo_subtipoconcod1_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SubTipoConCod2") == 0 )
            {
               AV16Insert_SubTipoConCod2 = AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_SubTipoConCod2", AV16Insert_SubTipoConCod2);
               if ( ! (GXutil.strcmp("", AV16Insert_SubTipoConCod2)==0) )
               {
                  AV31ComboSubTipoConCod2 = AV16Insert_SubTipoConCod2 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV31ComboSubTipoConCod2", AV31ComboSubTipoConCod2);
                  Combo_subtipoconcod2_Selectedvalue_set = AV31ComboSubTipoConCod2 ;
                  ucCombo_subtipoconcod2.sendProperty(context, "", false, Combo_subtipoconcod2_Internalname, "SelectedValue_set", Combo_subtipoconcod2_Selectedvalue_set);
                  GXt_char6 = AV25Combo_DataJson ;
                  GXv_char9[0] = AV23ComboSelectedValue ;
                  GXv_char8[0] = AV24ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.conceptos_exportloaddvcombo(remoteHandle, context).execute( "SubTipoConCod2", "GET", false, AV7CliCod, AV8ConCodigo, AV14Insert_TipoConCod, AV15Insert_SubTipoConCod1, AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  conceptos_export_impl.this.AV23ComboSelectedValue = GXv_char9[0] ;
                  conceptos_export_impl.this.AV24ComboSelectedText = GXv_char8[0] ;
                  conceptos_export_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedValue", AV23ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV24ComboSelectedText", AV24ComboSelectedText);
                  AV25Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV25Combo_DataJson", AV25Combo_DataJson);
                  Combo_subtipoconcod2_Selectedtext_set = AV24ComboSelectedText ;
                  ucCombo_subtipoconcod2.sendProperty(context, "", false, Combo_subtipoconcod2_Internalname, "SelectedText_set", Combo_subtipoconcod2_Selectedtext_set);
                  Combo_subtipoconcod2_Enabled = false ;
                  ucCombo_subtipoconcod2.sendProperty(context, "", false, Combo_subtipoconcod2_Internalname, "Enabled", GXutil.booltostr( Combo_subtipoconcod2_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConCondicion") == 0 )
            {
               AV33Insert_ConCondicion = AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV33Insert_ConCondicion", AV33Insert_ConCondicion);
               if ( ! (GXutil.strcmp("", AV33Insert_ConCondicion)==0) )
               {
                  AV35ComboConCondicion = AV33Insert_ConCondicion ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV35ComboConCondicion", AV35ComboConCondicion);
                  Combo_concondicion_Selectedvalue_set = AV35ComboConCondicion ;
                  ucCombo_concondicion.sendProperty(context, "", false, Combo_concondicion_Internalname, "SelectedValue_set", Combo_concondicion_Selectedvalue_set);
                  GXt_char6 = AV25Combo_DataJson ;
                  GXv_char9[0] = AV23ComboSelectedValue ;
                  GXv_char8[0] = AV24ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.conceptos_exportloaddvcombo(remoteHandle, context).execute( "ConCondicion", "GET", false, AV7CliCod, AV8ConCodigo, A37TipoConCod, A38SubTipoConCod1, AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  conceptos_export_impl.this.AV23ComboSelectedValue = GXv_char9[0] ;
                  conceptos_export_impl.this.AV24ComboSelectedText = GXv_char8[0] ;
                  conceptos_export_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedValue", AV23ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV24ComboSelectedText", AV24ComboSelectedText);
                  AV25Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV25Combo_DataJson", AV25Combo_DataJson);
                  Combo_concondicion_Selectedtext_set = AV24ComboSelectedText ;
                  ucCombo_concondicion.sendProperty(context, "", false, Combo_concondicion_Internalname, "SelectedText_set", Combo_concondicion_Selectedtext_set);
                  Combo_concondicion_Enabled = false ;
                  ucCombo_concondicion.sendProperty(context, "", false, Combo_concondicion_Internalname, "Enabled", GXutil.booltostr( Combo_concondicion_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "AplIIGG") == 0 )
            {
               AV17Insert_AplIIGG = (short)(GXutil.lval( AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV17Insert_AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17Insert_AplIIGG), 4, 0));
            }
            else if ( GXutil.strcmp(AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConceptoPais") == 0 )
            {
               AV18Insert_ConceptoPais = (short)(GXutil.lval( AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV18Insert_ConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18Insert_ConceptoPais), 4, 0));
            }
            else if ( GXutil.strcmp(AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConceptoConveCodigo") == 0 )
            {
               AV19Insert_ConceptoConveCodigo = AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV19Insert_ConceptoConveCodigo", AV19Insert_ConceptoConveCodigo);
            }
            else if ( GXutil.strcmp(AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CliPadre") == 0 )
            {
               AV36Insert_CliPadre = (int)(GXutil.lval( AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV36Insert_CliPadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36Insert_CliPadre), 6, 0));
            }
            else if ( GXutil.strcmp(AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConPadre") == 0 )
            {
               AV37Insert_ConPadre = AV20TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV37Insert_ConPadre", AV37Insert_ConPadre);
            }
            AV39GXV1 = (int)(AV39GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39GXV1), 8, 0));
         }
      }
   }

   public void e12572( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(9);
      pr_default.close(8);
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S142( )
   {
      /* 'LOADCOMBOCONCONDICION' Routine */
      returnInSub = false ;
      GXt_char6 = AV25Combo_DataJson ;
      GXv_char9[0] = AV23ComboSelectedValue ;
      GXv_char8[0] = AV24ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptos_exportloaddvcombo(remoteHandle, context).execute( "ConCondicion", Gx_mode, false, AV7CliCod, AV8ConCodigo, A37TipoConCod, A38SubTipoConCod1, "", GXv_char9, GXv_char8, GXv_char7) ;
      conceptos_export_impl.this.AV23ComboSelectedValue = GXv_char9[0] ;
      conceptos_export_impl.this.AV24ComboSelectedText = GXv_char8[0] ;
      conceptos_export_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedValue", AV23ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboSelectedText", AV24ComboSelectedText);
      AV25Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Combo_DataJson", AV25Combo_DataJson);
      Combo_concondicion_Selectedvalue_set = AV23ComboSelectedValue ;
      ucCombo_concondicion.sendProperty(context, "", false, Combo_concondicion_Internalname, "SelectedValue_set", Combo_concondicion_Selectedvalue_set);
      Combo_concondicion_Selectedtext_set = AV24ComboSelectedText ;
      ucCombo_concondicion.sendProperty(context, "", false, Combo_concondicion_Internalname, "SelectedText_set", Combo_concondicion_Selectedtext_set);
      AV35ComboConCondicion = AV23ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35ComboConCondicion", AV35ComboConCondicion);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_concondicion_Enabled = false ;
         ucCombo_concondicion.sendProperty(context, "", false, Combo_concondicion_Internalname, "Enabled", GXutil.booltostr( Combo_concondicion_Enabled));
      }
   }

   public void S132( )
   {
      /* 'LOADCOMBOSUBTIPOCONCOD2' Routine */
      returnInSub = false ;
      Combo_subtipoconcod2_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"SubTipoConCod2\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"ConCodigo\": \"\", \"Cond_TipoConCod\": \"#%1#\", \"Cond_SubTipoConCod1\": \"#%2#\"", cmbTipoConCod.getInternalname(), edtSubTipoConCod1_Internalname, "", "", "", "", "", "", "") ;
      ucCombo_subtipoconcod2.sendProperty(context, "", false, Combo_subtipoconcod2_Internalname, "DataListProcParametersPrefix", Combo_subtipoconcod2_Datalistprocparametersprefix);
      GXt_char6 = AV25Combo_DataJson ;
      GXv_char9[0] = AV23ComboSelectedValue ;
      GXv_char8[0] = AV24ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptos_exportloaddvcombo(remoteHandle, context).execute( "SubTipoConCod2", Gx_mode, false, AV7CliCod, AV8ConCodigo, A37TipoConCod, A38SubTipoConCod1, "", GXv_char9, GXv_char8, GXv_char7) ;
      conceptos_export_impl.this.AV23ComboSelectedValue = GXv_char9[0] ;
      conceptos_export_impl.this.AV24ComboSelectedText = GXv_char8[0] ;
      conceptos_export_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedValue", AV23ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboSelectedText", AV24ComboSelectedText);
      AV25Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Combo_DataJson", AV25Combo_DataJson);
      Combo_subtipoconcod2_Selectedvalue_set = AV23ComboSelectedValue ;
      ucCombo_subtipoconcod2.sendProperty(context, "", false, Combo_subtipoconcod2_Internalname, "SelectedValue_set", Combo_subtipoconcod2_Selectedvalue_set);
      Combo_subtipoconcod2_Selectedtext_set = AV24ComboSelectedText ;
      ucCombo_subtipoconcod2.sendProperty(context, "", false, Combo_subtipoconcod2_Internalname, "SelectedText_set", Combo_subtipoconcod2_Selectedtext_set);
      AV31ComboSubTipoConCod2 = AV23ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31ComboSubTipoConCod2", AV31ComboSubTipoConCod2);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_subtipoconcod2_Enabled = false ;
         ucCombo_subtipoconcod2.sendProperty(context, "", false, Combo_subtipoconcod2_Internalname, "Enabled", GXutil.booltostr( Combo_subtipoconcod2_Enabled));
      }
   }

   public void S122( )
   {
      /* 'LOADCOMBOSUBTIPOCONCOD1' Routine */
      returnInSub = false ;
      Combo_subtipoconcod1_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"SubTipoConCod1\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"ConCodigo\": \"\", \"Cond_TipoConCod\": \"#%1#\", \"Cond_SubTipoConCod1\": \"#%2#\"", cmbTipoConCod.getInternalname(), edtSubTipoConCod1_Internalname, "", "", "", "", "", "", "") ;
      ucCombo_subtipoconcod1.sendProperty(context, "", false, Combo_subtipoconcod1_Internalname, "DataListProcParametersPrefix", Combo_subtipoconcod1_Datalistprocparametersprefix);
      GXt_char6 = AV25Combo_DataJson ;
      GXv_char9[0] = AV23ComboSelectedValue ;
      GXv_char8[0] = AV24ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptos_exportloaddvcombo(remoteHandle, context).execute( "SubTipoConCod1", Gx_mode, false, AV7CliCod, AV8ConCodigo, A37TipoConCod, A38SubTipoConCod1, "", GXv_char9, GXv_char8, GXv_char7) ;
      conceptos_export_impl.this.AV23ComboSelectedValue = GXv_char9[0] ;
      conceptos_export_impl.this.AV24ComboSelectedText = GXv_char8[0] ;
      conceptos_export_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedValue", AV23ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboSelectedText", AV24ComboSelectedText);
      AV25Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Combo_DataJson", AV25Combo_DataJson);
      Combo_subtipoconcod1_Selectedvalue_set = AV23ComboSelectedValue ;
      ucCombo_subtipoconcod1.sendProperty(context, "", false, Combo_subtipoconcod1_Internalname, "SelectedValue_set", Combo_subtipoconcod1_Selectedvalue_set);
      Combo_subtipoconcod1_Selectedtext_set = AV24ComboSelectedText ;
      ucCombo_subtipoconcod1.sendProperty(context, "", false, Combo_subtipoconcod1_Internalname, "SelectedText_set", Combo_subtipoconcod1_Selectedtext_set);
      AV28ComboSubTipoConCod1 = AV23ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28ComboSubTipoConCod1", AV28ComboSubTipoConCod1);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_subtipoconcod1_Enabled = false ;
         ucCombo_subtipoconcod1.sendProperty(context, "", false, Combo_subtipoconcod1_Internalname, "Enabled", GXutil.booltostr( Combo_subtipoconcod1_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOTIPOCONCOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV25Combo_DataJson ;
      GXv_char9[0] = AV23ComboSelectedValue ;
      GXv_char8[0] = AV24ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptos_exportloaddvcombo(remoteHandle, context).execute( "TipoConCod", Gx_mode, false, AV7CliCod, AV8ConCodigo, A37TipoConCod, A38SubTipoConCod1, "", GXv_char9, GXv_char8, GXv_char7) ;
      conceptos_export_impl.this.AV23ComboSelectedValue = GXv_char9[0] ;
      conceptos_export_impl.this.AV24ComboSelectedText = GXv_char8[0] ;
      conceptos_export_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedValue", AV23ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboSelectedText", AV24ComboSelectedText);
      AV25Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Combo_DataJson", AV25Combo_DataJson);
      Combo_tipoconcod_Selectedvalue_set = AV23ComboSelectedValue ;
      ucCombo_tipoconcod.sendProperty(context, "", false, Combo_tipoconcod_Internalname, "SelectedValue_set", Combo_tipoconcod_Selectedvalue_set);
      Combo_tipoconcod_Selectedtext_set = AV24ComboSelectedText ;
      ucCombo_tipoconcod.sendProperty(context, "", false, Combo_tipoconcod_Internalname, "SelectedText_set", Combo_tipoconcod_Selectedtext_set);
      AV26ComboTipoConCod = AV23ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ComboTipoConCod", AV26ComboTipoConCod);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_tipoconcod_Enabled = false ;
         ucCombo_tipoconcod.sendProperty(context, "", false, Combo_tipoconcod_Internalname, "Enabled", GXutil.booltostr( Combo_tipoconcod_Enabled));
      }
   }

   public void zm577( int GX_JID )
   {
      if ( ( GX_JID == 43 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z42ConCodYDesc = T00573_A42ConCodYDesc[0] ;
            Z41ConDescrip = T00573_A41ConDescrip[0] ;
            Z40ConOrden = T00573_A40ConOrden[0] ;
            Z162ConVigencia = T00573_A162ConVigencia[0] ;
            Z1488ConLiqBasica = T00573_A1488ConLiqBasica[0] ;
            Z159ConVariable = T00573_A159ConVariable[0] ;
            Z146ConForEditable = T00573_A146ConForEditable[0] ;
            Z503ConTipoLiqAux = T00573_A503ConTipoLiqAux[0] ;
            Z970ConClasifAux = T00573_A970ConClasifAux[0] ;
            Z510ConOrdEjec = T00573_A510ConOrdEjec[0] ;
            Z762ConRecalcular = T00573_A762ConRecalcular[0] ;
            Z1018ConRangoCant = T00573_A1018ConRangoCant[0] ;
            Z954ConCondCodigo = T00573_A954ConCondCodigo[0] ;
            Z1068ConMostrarPos = T00573_A1068ConMostrarPos[0] ;
            Z1077ConAdelDescu = T00573_A1077ConAdelDescu[0] ;
            Z1194ConSegunPla = T00573_A1194ConSegunPla[0] ;
            Z1471ConNumero = T00573_A1471ConNumero[0] ;
            Z1648ConCodAfip = T00573_A1648ConCodAfip[0] ;
            Z1472ConSIPAApo = T00573_A1472ConSIPAApo[0] ;
            Z1473ConSIPACont = T00573_A1473ConSIPACont[0] ;
            Z1474ConINSSJyPApo = T00573_A1474ConINSSJyPApo[0] ;
            Z1475ConINSSJyPCont = T00573_A1475ConINSSJyPCont[0] ;
            Z1476ConObraSocApo = T00573_A1476ConObraSocApo[0] ;
            Z1477ConObraSocCont = T00573_A1477ConObraSocCont[0] ;
            Z1478ConFonSolRedApo = T00573_A1478ConFonSolRedApo[0] ;
            Z1479ConFonSolRedCont = T00573_A1479ConFonSolRedCont[0] ;
            Z1480ConRenateaApo = T00573_A1480ConRenateaApo[0] ;
            Z1481ConRenateaCont = T00573_A1481ConRenateaCont[0] ;
            Z1482ConAsigFamCont = T00573_A1482ConAsigFamCont[0] ;
            Z1483ConFonNacEmpCont = T00573_A1483ConFonNacEmpCont[0] ;
            Z1484ConLeyRieTrabCont = T00573_A1484ConLeyRieTrabCont[0] ;
            Z1485ConRegDifApo = T00573_A1485ConRegDifApo[0] ;
            Z1486ConRegEspApo = T00573_A1486ConRegEspApo[0] ;
            Z1539ConSacDeven = T00573_A1539ConSacDeven[0] ;
            Z1620ConBaseLic = T00573_A1620ConBaseLic[0] ;
            Z1797ConBaseLicProm = T00573_A1797ConBaseLicProm[0] ;
            Z1621ConBaseFer = T00573_A1621ConBaseFer[0] ;
            Z1798ConBaseFerProm = T00573_A1798ConBaseFerProm[0] ;
            Z1622ConBaseHorExt = T00573_A1622ConBaseHorExt[0] ;
            Z1799ConBaseHorExtProm = T00573_A1799ConBaseHorExtProm[0] ;
            Z1800ConBasePres = T00573_A1800ConBasePres[0] ;
            Z1801ConBaseAnt = T00573_A1801ConBaseAnt[0] ;
            Z1827ConBaseOSDif = T00573_A1827ConBaseOSDif[0] ;
            Z1821ConErrorSiCero = T00573_A1821ConErrorSiCero[0] ;
            Z1826ConPueNov = T00573_A1826ConPueNov[0] ;
            Z1822CliPadre = T00573_A1822CliPadre[0] ;
            Z1112AplIIGG = T00573_A1112AplIIGG[0] ;
            Z37TipoConCod = T00573_A37TipoConCod[0] ;
            Z38SubTipoConCod1 = T00573_A38SubTipoConCod1[0] ;
            Z39SubTipoConCod2 = T00573_A39SubTipoConCod2[0] ;
            Z953ConCondicion = T00573_A953ConCondicion[0] ;
            Z1644ConceptoPais = T00573_A1644ConceptoPais[0] ;
            Z1645ConceptoConveCodigo = T00573_A1645ConceptoConveCodigo[0] ;
            Z921ConPadre = T00573_A921ConPadre[0] ;
         }
         else
         {
            Z42ConCodYDesc = A42ConCodYDesc ;
            Z41ConDescrip = A41ConDescrip ;
            Z40ConOrden = A40ConOrden ;
            Z162ConVigencia = A162ConVigencia ;
            Z1488ConLiqBasica = A1488ConLiqBasica ;
            Z159ConVariable = A159ConVariable ;
            Z146ConForEditable = A146ConForEditable ;
            Z503ConTipoLiqAux = A503ConTipoLiqAux ;
            Z970ConClasifAux = A970ConClasifAux ;
            Z510ConOrdEjec = A510ConOrdEjec ;
            Z762ConRecalcular = A762ConRecalcular ;
            Z1018ConRangoCant = A1018ConRangoCant ;
            Z954ConCondCodigo = A954ConCondCodigo ;
            Z1068ConMostrarPos = A1068ConMostrarPos ;
            Z1077ConAdelDescu = A1077ConAdelDescu ;
            Z1194ConSegunPla = A1194ConSegunPla ;
            Z1471ConNumero = A1471ConNumero ;
            Z1648ConCodAfip = A1648ConCodAfip ;
            Z1472ConSIPAApo = A1472ConSIPAApo ;
            Z1473ConSIPACont = A1473ConSIPACont ;
            Z1474ConINSSJyPApo = A1474ConINSSJyPApo ;
            Z1475ConINSSJyPCont = A1475ConINSSJyPCont ;
            Z1476ConObraSocApo = A1476ConObraSocApo ;
            Z1477ConObraSocCont = A1477ConObraSocCont ;
            Z1478ConFonSolRedApo = A1478ConFonSolRedApo ;
            Z1479ConFonSolRedCont = A1479ConFonSolRedCont ;
            Z1480ConRenateaApo = A1480ConRenateaApo ;
            Z1481ConRenateaCont = A1481ConRenateaCont ;
            Z1482ConAsigFamCont = A1482ConAsigFamCont ;
            Z1483ConFonNacEmpCont = A1483ConFonNacEmpCont ;
            Z1484ConLeyRieTrabCont = A1484ConLeyRieTrabCont ;
            Z1485ConRegDifApo = A1485ConRegDifApo ;
            Z1486ConRegEspApo = A1486ConRegEspApo ;
            Z1539ConSacDeven = A1539ConSacDeven ;
            Z1620ConBaseLic = A1620ConBaseLic ;
            Z1797ConBaseLicProm = A1797ConBaseLicProm ;
            Z1621ConBaseFer = A1621ConBaseFer ;
            Z1798ConBaseFerProm = A1798ConBaseFerProm ;
            Z1622ConBaseHorExt = A1622ConBaseHorExt ;
            Z1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
            Z1800ConBasePres = A1800ConBasePres ;
            Z1801ConBaseAnt = A1801ConBaseAnt ;
            Z1827ConBaseOSDif = A1827ConBaseOSDif ;
            Z1821ConErrorSiCero = A1821ConErrorSiCero ;
            Z1826ConPueNov = A1826ConPueNov ;
            Z1822CliPadre = A1822CliPadre ;
            Z1112AplIIGG = A1112AplIIGG ;
            Z37TipoConCod = A37TipoConCod ;
            Z38SubTipoConCod1 = A38SubTipoConCod1 ;
            Z39SubTipoConCod2 = A39SubTipoConCod2 ;
            Z953ConCondicion = A953ConCondicion ;
            Z1644ConceptoPais = A1644ConceptoPais ;
            Z1645ConceptoConveCodigo = A1645ConceptoConveCodigo ;
            Z921ConPadre = A921ConPadre ;
         }
      }
      if ( GX_JID == -43 )
      {
         Z42ConCodYDesc = A42ConCodYDesc ;
         Z26ConCodigo = A26ConCodigo ;
         Z41ConDescrip = A41ConDescrip ;
         Z40ConOrden = A40ConOrden ;
         Z162ConVigencia = A162ConVigencia ;
         Z1488ConLiqBasica = A1488ConLiqBasica ;
         Z148ConFormula = A148ConFormula ;
         Z153ConObservacion = A153ConObservacion ;
         Z159ConVariable = A159ConVariable ;
         Z146ConForEditable = A146ConForEditable ;
         Z503ConTipoLiqAux = A503ConTipoLiqAux ;
         Z970ConClasifAux = A970ConClasifAux ;
         Z510ConOrdEjec = A510ConOrdEjec ;
         Z569ConFormulaExpl = A569ConFormulaExpl ;
         Z762ConRecalcular = A762ConRecalcular ;
         Z1018ConRangoCant = A1018ConRangoCant ;
         Z954ConCondCodigo = A954ConCondCodigo ;
         Z1068ConMostrarPos = A1068ConMostrarPos ;
         Z1077ConAdelDescu = A1077ConAdelDescu ;
         Z1194ConSegunPla = A1194ConSegunPla ;
         Z1471ConNumero = A1471ConNumero ;
         Z1648ConCodAfip = A1648ConCodAfip ;
         Z1472ConSIPAApo = A1472ConSIPAApo ;
         Z1473ConSIPACont = A1473ConSIPACont ;
         Z1474ConINSSJyPApo = A1474ConINSSJyPApo ;
         Z1475ConINSSJyPCont = A1475ConINSSJyPCont ;
         Z1476ConObraSocApo = A1476ConObraSocApo ;
         Z1477ConObraSocCont = A1477ConObraSocCont ;
         Z1478ConFonSolRedApo = A1478ConFonSolRedApo ;
         Z1479ConFonSolRedCont = A1479ConFonSolRedCont ;
         Z1480ConRenateaApo = A1480ConRenateaApo ;
         Z1481ConRenateaCont = A1481ConRenateaCont ;
         Z1482ConAsigFamCont = A1482ConAsigFamCont ;
         Z1483ConFonNacEmpCont = A1483ConFonNacEmpCont ;
         Z1484ConLeyRieTrabCont = A1484ConLeyRieTrabCont ;
         Z1485ConRegDifApo = A1485ConRegDifApo ;
         Z1486ConRegEspApo = A1486ConRegEspApo ;
         Z1539ConSacDeven = A1539ConSacDeven ;
         Z1620ConBaseLic = A1620ConBaseLic ;
         Z1797ConBaseLicProm = A1797ConBaseLicProm ;
         Z1621ConBaseFer = A1621ConBaseFer ;
         Z1798ConBaseFerProm = A1798ConBaseFerProm ;
         Z1622ConBaseHorExt = A1622ConBaseHorExt ;
         Z1799ConBaseHorExtProm = A1799ConBaseHorExtProm ;
         Z1800ConBasePres = A1800ConBasePres ;
         Z1801ConBaseAnt = A1801ConBaseAnt ;
         Z1827ConBaseOSDif = A1827ConBaseOSDif ;
         Z1821ConErrorSiCero = A1821ConErrorSiCero ;
         Z1826ConPueNov = A1826ConPueNov ;
         Z1822CliPadre = A1822CliPadre ;
         Z3CliCod = A3CliCod ;
         Z1112AplIIGG = A1112AplIIGG ;
         Z37TipoConCod = A37TipoConCod ;
         Z38SubTipoConCod1 = A38SubTipoConCod1 ;
         Z39SubTipoConCod2 = A39SubTipoConCod2 ;
         Z953ConCondicion = A953ConCondicion ;
         Z1644ConceptoPais = A1644ConceptoPais ;
         Z1645ConceptoConveCodigo = A1645ConceptoConveCodigo ;
         Z921ConPadre = A921ConPadre ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8ConCodigo)==0) )
      {
         A26ConCodigo = AV8ConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      }
      if ( ! (GXutil.strcmp("", AV8ConCodigo)==0) )
      {
         edtConCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtConCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8ConCodigo)==0) )
      {
         edtConCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_TipoConCod)==0) )
      {
         cmbTipoConCod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTipoConCod.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbTipoConCod.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTipoConCod.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_SubTipoConCod1)==0) )
      {
         edtSubTipoConCod1_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod1_Enabled), 5, 0), true);
      }
      else
      {
         edtSubTipoConCod1_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod1_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV16Insert_SubTipoConCod2)==0) )
      {
         edtSubTipoConCod2_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod2_Enabled), 5, 0), true);
      }
      else
      {
         edtSubTipoConCod2_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod2_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV33Insert_ConCondicion)==0) )
      {
         cmbConCondicion.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConCondicion.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConCondicion.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConCondicion.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV17Insert_AplIIGG) )
      {
         edtAplIIGG_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAplIIGG_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGG_Enabled), 5, 0), true);
      }
      else
      {
         edtAplIIGG_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAplIIGG_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGG_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV18Insert_ConceptoPais) )
      {
         edtConceptoPais_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConceptoPais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConceptoPais_Enabled), 5, 0), true);
      }
      else
      {
         edtConceptoPais_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConceptoPais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConceptoPais_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV19Insert_ConceptoConveCodigo)==0) )
      {
         edtConceptoConveCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConceptoConveCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConceptoConveCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtConceptoConveCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConceptoConveCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConceptoConveCodigo_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV37Insert_ConPadre)==0) )
      {
         A921ConPadre = AV37Insert_ConPadre ;
         n921ConPadre = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A921ConPadre", A921ConPadre);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV36Insert_CliPadre) )
      {
         A1822CliPadre = AV36Insert_CliPadre ;
         n1822CliPadre = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1822CliPadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1822CliPadre), 6, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV19Insert_ConceptoConveCodigo)==0) )
      {
         A1645ConceptoConveCodigo = AV19Insert_ConceptoConveCodigo ;
         n1645ConceptoConveCodigo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1645ConceptoConveCodigo", A1645ConceptoConveCodigo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV18Insert_ConceptoPais) )
      {
         A1644ConceptoPais = AV18Insert_ConceptoPais ;
         n1644ConceptoPais = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1644ConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1644ConceptoPais), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV17Insert_AplIIGG) )
      {
         A1112AplIIGG = AV17Insert_AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_TipoConCod)==0) )
      {
         A37TipoConCod = AV14Insert_TipoConCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      }
      else
      {
         A37TipoConCod = AV26ComboTipoConCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_SubTipoConCod1)==0) )
      {
         A38SubTipoConCod1 = AV15Insert_SubTipoConCod1 ;
         n38SubTipoConCod1 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
      }
      else
      {
         if ( (GXutil.strcmp("", AV28ComboSubTipoConCod1)==0) )
         {
            A38SubTipoConCod1 = "" ;
            n38SubTipoConCod1 = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
            n38SubTipoConCod1 = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV28ComboSubTipoConCod1)==0) )
            {
               A38SubTipoConCod1 = AV28ComboSubTipoConCod1 ;
               n38SubTipoConCod1 = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV16Insert_SubTipoConCod2)==0) )
      {
         A39SubTipoConCod2 = AV16Insert_SubTipoConCod2 ;
         n39SubTipoConCod2 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
      }
      else
      {
         if ( (GXutil.strcmp("", AV31ComboSubTipoConCod2)==0) )
         {
            A39SubTipoConCod2 = "" ;
            n39SubTipoConCod2 = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
            n39SubTipoConCod2 = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV31ComboSubTipoConCod2)==0) )
            {
               A39SubTipoConCod2 = AV31ComboSubTipoConCod2 ;
               n39SubTipoConCod2 = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV33Insert_ConCondicion)==0) )
      {
         A953ConCondicion = AV33Insert_ConCondicion ;
         n953ConCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
      }
      else
      {
         if ( (GXutil.strcmp("", AV35ComboConCondicion)==0) )
         {
            A953ConCondicion = "" ;
            n953ConCondicion = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
            n953ConCondicion = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV35ComboConCondicion)==0) )
            {
               A953ConCondicion = AV35ComboConCondicion ;
               n953ConCondicion = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
            }
         }
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV38Pgmname = "Conceptos_export" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
      }
   }

   public void load577( )
   {
      /* Using cursor T005712 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A42ConCodYDesc = T005712_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T005712_n42ConCodYDesc[0] ;
         A41ConDescrip = T005712_A41ConDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         A40ConOrden = T005712_A40ConOrden[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40ConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40ConOrden), 8, 0));
         A162ConVigencia = T005712_A162ConVigencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
         A1488ConLiqBasica = T005712_A1488ConLiqBasica[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1488ConLiqBasica", GXutil.str( A1488ConLiqBasica, 1, 0));
         A148ConFormula = T005712_A148ConFormula[0] ;
         n148ConFormula = T005712_n148ConFormula[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A148ConFormula", A148ConFormula);
         A153ConObservacion = T005712_A153ConObservacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A153ConObservacion", A153ConObservacion);
         A159ConVariable = T005712_A159ConVariable[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
         A146ConForEditable = T005712_A146ConForEditable[0] ;
         n146ConForEditable = T005712_n146ConForEditable[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A146ConForEditable", A146ConForEditable);
         A503ConTipoLiqAux = T005712_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = T005712_n503ConTipoLiqAux[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A503ConTipoLiqAux", A503ConTipoLiqAux);
         A970ConClasifAux = T005712_A970ConClasifAux[0] ;
         n970ConClasifAux = T005712_n970ConClasifAux[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A970ConClasifAux", A970ConClasifAux);
         A510ConOrdEjec = T005712_A510ConOrdEjec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A510ConOrdEjec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A510ConOrdEjec), 12, 0));
         A569ConFormulaExpl = T005712_A569ConFormulaExpl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A569ConFormulaExpl", A569ConFormulaExpl);
         A762ConRecalcular = T005712_A762ConRecalcular[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
         A1018ConRangoCant = T005712_A1018ConRangoCant[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1018ConRangoCant", A1018ConRangoCant);
         A954ConCondCodigo = T005712_A954ConCondCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A954ConCondCodigo", A954ConCondCodigo);
         A1068ConMostrarPos = T005712_A1068ConMostrarPos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1068ConMostrarPos", A1068ConMostrarPos);
         A1077ConAdelDescu = T005712_A1077ConAdelDescu[0] ;
         n1077ConAdelDescu = T005712_n1077ConAdelDescu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
         A1194ConSegunPla = T005712_A1194ConSegunPla[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1194ConSegunPla", A1194ConSegunPla);
         A1471ConNumero = T005712_A1471ConNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1471ConNumero", GXutil.str( A1471ConNumero, 1, 0));
         A1648ConCodAfip = T005712_A1648ConCodAfip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1648ConCodAfip", A1648ConCodAfip);
         A1472ConSIPAApo = T005712_A1472ConSIPAApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1472ConSIPAApo", GXutil.str( A1472ConSIPAApo, 1, 0));
         A1473ConSIPACont = T005712_A1473ConSIPACont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1473ConSIPACont", GXutil.str( A1473ConSIPACont, 1, 0));
         A1474ConINSSJyPApo = T005712_A1474ConINSSJyPApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1474ConINSSJyPApo", GXutil.str( A1474ConINSSJyPApo, 1, 0));
         A1475ConINSSJyPCont = T005712_A1475ConINSSJyPCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1475ConINSSJyPCont", GXutil.str( A1475ConINSSJyPCont, 1, 0));
         A1476ConObraSocApo = T005712_A1476ConObraSocApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1476ConObraSocApo", GXutil.str( A1476ConObraSocApo, 1, 0));
         A1477ConObraSocCont = T005712_A1477ConObraSocCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1477ConObraSocCont", GXutil.str( A1477ConObraSocCont, 1, 0));
         A1478ConFonSolRedApo = T005712_A1478ConFonSolRedApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1478ConFonSolRedApo", GXutil.str( A1478ConFonSolRedApo, 1, 0));
         A1479ConFonSolRedCont = T005712_A1479ConFonSolRedCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1479ConFonSolRedCont", GXutil.str( A1479ConFonSolRedCont, 1, 0));
         A1480ConRenateaApo = T005712_A1480ConRenateaApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1480ConRenateaApo", GXutil.str( A1480ConRenateaApo, 1, 0));
         A1481ConRenateaCont = T005712_A1481ConRenateaCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1481ConRenateaCont", GXutil.str( A1481ConRenateaCont, 1, 0));
         A1482ConAsigFamCont = T005712_A1482ConAsigFamCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1482ConAsigFamCont", GXutil.str( A1482ConAsigFamCont, 1, 0));
         A1483ConFonNacEmpCont = T005712_A1483ConFonNacEmpCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1483ConFonNacEmpCont", GXutil.str( A1483ConFonNacEmpCont, 1, 0));
         A1484ConLeyRieTrabCont = T005712_A1484ConLeyRieTrabCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1484ConLeyRieTrabCont", GXutil.str( A1484ConLeyRieTrabCont, 1, 0));
         A1485ConRegDifApo = T005712_A1485ConRegDifApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1485ConRegDifApo", GXutil.str( A1485ConRegDifApo, 1, 0));
         A1486ConRegEspApo = T005712_A1486ConRegEspApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1486ConRegEspApo", GXutil.str( A1486ConRegEspApo, 1, 0));
         A1539ConSacDeven = T005712_A1539ConSacDeven[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1539ConSacDeven", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1539ConSacDeven), 2, 0));
         A1620ConBaseLic = T005712_A1620ConBaseLic[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
         A1797ConBaseLicProm = T005712_A1797ConBaseLicProm[0] ;
         A1621ConBaseFer = T005712_A1621ConBaseFer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
         A1798ConBaseFerProm = T005712_A1798ConBaseFerProm[0] ;
         A1622ConBaseHorExt = T005712_A1622ConBaseHorExt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
         A1799ConBaseHorExtProm = T005712_A1799ConBaseHorExtProm[0] ;
         A1800ConBasePres = T005712_A1800ConBasePres[0] ;
         A1801ConBaseAnt = T005712_A1801ConBaseAnt[0] ;
         A1827ConBaseOSDif = T005712_A1827ConBaseOSDif[0] ;
         A1821ConErrorSiCero = T005712_A1821ConErrorSiCero[0] ;
         A1826ConPueNov = T005712_A1826ConPueNov[0] ;
         A1822CliPadre = T005712_A1822CliPadre[0] ;
         n1822CliPadre = T005712_n1822CliPadre[0] ;
         A1112AplIIGG = T005712_A1112AplIIGG[0] ;
         n1112AplIIGG = T005712_n1112AplIIGG[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
         A37TipoConCod = T005712_A37TipoConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
         A38SubTipoConCod1 = T005712_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = T005712_n38SubTipoConCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
         A39SubTipoConCod2 = T005712_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = T005712_n39SubTipoConCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
         A953ConCondicion = T005712_A953ConCondicion[0] ;
         n953ConCondicion = T005712_n953ConCondicion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
         A1644ConceptoPais = T005712_A1644ConceptoPais[0] ;
         n1644ConceptoPais = T005712_n1644ConceptoPais[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1644ConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1644ConceptoPais), 4, 0));
         A1645ConceptoConveCodigo = T005712_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = T005712_n1645ConceptoConveCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1645ConceptoConveCodigo", A1645ConceptoConveCodigo);
         A921ConPadre = T005712_A921ConPadre[0] ;
         n921ConPadre = T005712_n921ConPadre[0] ;
         zm577( -43) ;
      }
      pr_default.close(10);
      onLoadActions577( ) ;
   }

   public void onLoadActions577( )
   {
      AV38Pgmname = "Conceptos_export" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
      A42ConCodYDesc = GXutil.trim( A26ConCodigo) + " - " + GXutil.trim( A41ConDescrip) ;
      n42ConCodYDesc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
   }

   public void checkExtendedTable577( )
   {
      nIsDirty_7 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV38Pgmname = "Conceptos_export" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
      /* Using cursor T00574 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1112AplIIGG) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo aplicacion ganancias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGG");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(3);
      nIsDirty_7 = (short)(1) ;
      A42ConCodYDesc = GXutil.trim( A26ConCodigo) + " - " + GXutil.trim( A41ConDescrip) ;
      n42ConCodYDesc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      if ( ! ( ( A162ConVigencia == 0 ) || ( A162ConVigencia == 1 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Vigencia", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONVIGENCIA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConVigencia.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T00576 */
      pr_default.execute(4, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo De Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      /* Using cursor T00577 */
      pr_default.execute(5, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo1", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD1");
            AnyError = (short)(1) ;
            GX_FocusControl = cmbTipoConCod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(5);
      /* Using cursor T00578 */
      pr_default.execute(6, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) || (GXutil.strcmp("", A39SubTipoConCod2)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo2", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD2");
            AnyError = (short)(1) ;
            GX_FocusControl = cmbTipoConCod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(6);
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "DES_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T00579 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A953ConCondicion)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condiciones_concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCONDICION");
            AnyError = (short)(1) ;
            GX_FocusControl = cmbConCondicion.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(7);
      if ( ! ( ( GXutil.strcmp(A953ConCondicion, "A0") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A3") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A4") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A5") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A8") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A9") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A10") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A11") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A12") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A13") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A14") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B2") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B3") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B4") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B5") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B6") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B7") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B9") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B10") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B11") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B12") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B13") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B14") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B15") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "N01") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B16") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B19") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B20") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B21") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B22") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B23") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B24") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "VP") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "AI") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "R1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "MI") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "H1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "LA") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "GU") == 0 ) || (GXutil.strcmp("", A953ConCondicion)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Condición para liquidación", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONCONDICION");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConCondicion.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A1077ConAdelDescu == 1 ) || ( A1077ConAdelDescu == 2 ) || (0==A1077ConAdelDescu) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Adelanto/Descuento", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONADELDESCU");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAdelDescu.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T00575 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A1822CliPadre) || (0==A1112AplIIGG) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo aplicacion ganancias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGG");
            AnyError = (short)(1) ;
            GX_FocusControl = edtAplIIGG_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(3);
      if ( ! ( ( A1539ConSacDeven == 0 ) || ( A1539ConSacDeven == 1 ) || ( A1539ConSacDeven == 3 ) || ( A1539ConSacDeven == 4 ) || ( A1539ConSacDeven == 6 ) || ( A1539ConSacDeven == 12 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo devengamiento", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONSACDEVEN");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConSacDeven.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T005710 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A1644ConceptoPais) || (GXutil.strcmp("", A1645ConceptoConveCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto_Convenio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCEPTOCONVECODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtConceptoPais_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(8);
      if ( ! ( ( A1620ConBaseLic == 0 ) || ( A1620ConBaseLic == 1 ) || ( A1620ConBaseLic == 2 ) || ( A1620ConBaseLic == 3 ) || ( A1620ConBaseLic == 4 ) || ( A1620ConBaseLic == 5 ) || ( A1620ConBaseLic == 6 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para licencias de remuneraciòn actual", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONBASELIC");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConBaseLic.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A1621ConBaseFer == 0 ) || ( A1621ConBaseFer == 1 ) || ( A1621ConBaseFer == 2 ) || ( A1621ConBaseFer == 3 ) || ( A1621ConBaseFer == 4 ) || ( A1621ConBaseFer == 5 ) || ( A1621ConBaseFer == 6 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para feriados de remuneración actual", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONBASEFER");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConBaseFer.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A1622ConBaseHorExt == 0 ) || ( A1622ConBaseHorExt == 1 ) || ( A1622ConBaseHorExt == 2 ) || ( A1622ConBaseHorExt == 3 ) || ( A1622ConBaseHorExt == 4 ) || ( A1622ConBaseHorExt == 5 ) || ( A1622ConBaseHorExt == 6 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Base de cálculo para horas extras de remuneración actual", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONBASEHOREXT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConBaseHorExt.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T005711 */
      pr_default.execute(9, new Object[] {Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n921ConPadre), A921ConPadre});
      if ( (pr_default.getStatus(9) == 101) )
      {
         if ( ! ( (0==A1822CliPadre) || (GXutil.strcmp("", A921ConPadre)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto Padre Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONPADRE");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void closeExtendedTableCursors577( )
   {
      pr_default.close(2);
      pr_default.close(4);
      pr_default.close(5);
      pr_default.close(6);
      pr_default.close(7);
      pr_default.close(3);
      pr_default.close(8);
      pr_default.close(9);
   }

   public void enableDisable( )
   {
   }

   public void gxload_44( int A3CliCod ,
                          short A1112AplIIGG )
   {
      /* Using cursor T005713 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1112AplIIGG) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo aplicacion ganancias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGG");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void gxload_46( String A37TipoConCod )
   {
      /* Using cursor T005714 */
      pr_default.execute(12, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo De Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(12) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(12);
   }

   public void gxload_47( String A37TipoConCod ,
                          String A38SubTipoConCod1 )
   {
      /* Using cursor T005715 */
      pr_default.execute(13, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
      if ( (pr_default.getStatus(13) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo1", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD1");
            AnyError = (short)(1) ;
            GX_FocusControl = cmbTipoConCod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(13) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(13);
   }

   public void gxload_48( String A37TipoConCod ,
                          String A38SubTipoConCod1 ,
                          String A39SubTipoConCod2 )
   {
      /* Using cursor T005716 */
      pr_default.execute(14, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
      if ( (pr_default.getStatus(14) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) || (GXutil.strcmp("", A39SubTipoConCod2)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo2", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD2");
            AnyError = (short)(1) ;
            GX_FocusControl = cmbTipoConCod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(14) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(14);
   }

   public void gxload_49( String A953ConCondicion )
   {
      /* Using cursor T005717 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
      if ( (pr_default.getStatus(15) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A953ConCondicion)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condiciones_concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCONDICION");
            AnyError = (short)(1) ;
            GX_FocusControl = cmbConCondicion.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(15) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(15);
   }

   public void gxload_45( int A1822CliPadre ,
                          short A1112AplIIGG )
   {
      /* Using cursor T005718 */
      pr_default.execute(16, new Object[] {Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         if ( ! ( (0==A1822CliPadre) || (0==A1112AplIIGG) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo aplicacion ganancias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGG");
            AnyError = (short)(1) ;
            GX_FocusControl = edtAplIIGG_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(16) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(16);
   }

   public void gxload_50( short A1644ConceptoPais ,
                          String A1645ConceptoConveCodigo )
   {
      /* Using cursor T005719 */
      pr_default.execute(17, new Object[] {Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo});
      if ( (pr_default.getStatus(17) == 101) )
      {
         if ( ! ( (0==A1644ConceptoPais) || (GXutil.strcmp("", A1645ConceptoConveCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto_Convenio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCEPTOCONVECODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtConceptoPais_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(17) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(17);
   }

   public void gxload_51( int A1822CliPadre ,
                          String A921ConPadre )
   {
      /* Using cursor T005720 */
      pr_default.execute(18, new Object[] {Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n921ConPadre), A921ConPadre});
      if ( (pr_default.getStatus(18) == 101) )
      {
         if ( ! ( (0==A1822CliPadre) || (GXutil.strcmp("", A921ConPadre)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto Padre Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONPADRE");
            AnyError = (short)(1) ;
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(18) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(18);
   }

   public void getKey577( )
   {
      /* Using cursor T005721 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound7 = (short)(1) ;
      }
      else
      {
         RcdFound7 = (short)(0) ;
      }
      pr_default.close(19);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00573 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm577( 43) ;
         RcdFound7 = (short)(1) ;
         A42ConCodYDesc = T00573_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T00573_n42ConCodYDesc[0] ;
         A26ConCodigo = T00573_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A41ConDescrip = T00573_A41ConDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
         A40ConOrden = T00573_A40ConOrden[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40ConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40ConOrden), 8, 0));
         A162ConVigencia = T00573_A162ConVigencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
         A1488ConLiqBasica = T00573_A1488ConLiqBasica[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1488ConLiqBasica", GXutil.str( A1488ConLiqBasica, 1, 0));
         A148ConFormula = T00573_A148ConFormula[0] ;
         n148ConFormula = T00573_n148ConFormula[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A148ConFormula", A148ConFormula);
         A153ConObservacion = T00573_A153ConObservacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A153ConObservacion", A153ConObservacion);
         A159ConVariable = T00573_A159ConVariable[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
         A146ConForEditable = T00573_A146ConForEditable[0] ;
         n146ConForEditable = T00573_n146ConForEditable[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A146ConForEditable", A146ConForEditable);
         A503ConTipoLiqAux = T00573_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = T00573_n503ConTipoLiqAux[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A503ConTipoLiqAux", A503ConTipoLiqAux);
         A970ConClasifAux = T00573_A970ConClasifAux[0] ;
         n970ConClasifAux = T00573_n970ConClasifAux[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A970ConClasifAux", A970ConClasifAux);
         A510ConOrdEjec = T00573_A510ConOrdEjec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A510ConOrdEjec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A510ConOrdEjec), 12, 0));
         A569ConFormulaExpl = T00573_A569ConFormulaExpl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A569ConFormulaExpl", A569ConFormulaExpl);
         A762ConRecalcular = T00573_A762ConRecalcular[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
         A1018ConRangoCant = T00573_A1018ConRangoCant[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1018ConRangoCant", A1018ConRangoCant);
         A954ConCondCodigo = T00573_A954ConCondCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A954ConCondCodigo", A954ConCondCodigo);
         A1068ConMostrarPos = T00573_A1068ConMostrarPos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1068ConMostrarPos", A1068ConMostrarPos);
         A1077ConAdelDescu = T00573_A1077ConAdelDescu[0] ;
         n1077ConAdelDescu = T00573_n1077ConAdelDescu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
         A1194ConSegunPla = T00573_A1194ConSegunPla[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1194ConSegunPla", A1194ConSegunPla);
         A1471ConNumero = T00573_A1471ConNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1471ConNumero", GXutil.str( A1471ConNumero, 1, 0));
         A1648ConCodAfip = T00573_A1648ConCodAfip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1648ConCodAfip", A1648ConCodAfip);
         A1472ConSIPAApo = T00573_A1472ConSIPAApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1472ConSIPAApo", GXutil.str( A1472ConSIPAApo, 1, 0));
         A1473ConSIPACont = T00573_A1473ConSIPACont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1473ConSIPACont", GXutil.str( A1473ConSIPACont, 1, 0));
         A1474ConINSSJyPApo = T00573_A1474ConINSSJyPApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1474ConINSSJyPApo", GXutil.str( A1474ConINSSJyPApo, 1, 0));
         A1475ConINSSJyPCont = T00573_A1475ConINSSJyPCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1475ConINSSJyPCont", GXutil.str( A1475ConINSSJyPCont, 1, 0));
         A1476ConObraSocApo = T00573_A1476ConObraSocApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1476ConObraSocApo", GXutil.str( A1476ConObraSocApo, 1, 0));
         A1477ConObraSocCont = T00573_A1477ConObraSocCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1477ConObraSocCont", GXutil.str( A1477ConObraSocCont, 1, 0));
         A1478ConFonSolRedApo = T00573_A1478ConFonSolRedApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1478ConFonSolRedApo", GXutil.str( A1478ConFonSolRedApo, 1, 0));
         A1479ConFonSolRedCont = T00573_A1479ConFonSolRedCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1479ConFonSolRedCont", GXutil.str( A1479ConFonSolRedCont, 1, 0));
         A1480ConRenateaApo = T00573_A1480ConRenateaApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1480ConRenateaApo", GXutil.str( A1480ConRenateaApo, 1, 0));
         A1481ConRenateaCont = T00573_A1481ConRenateaCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1481ConRenateaCont", GXutil.str( A1481ConRenateaCont, 1, 0));
         A1482ConAsigFamCont = T00573_A1482ConAsigFamCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1482ConAsigFamCont", GXutil.str( A1482ConAsigFamCont, 1, 0));
         A1483ConFonNacEmpCont = T00573_A1483ConFonNacEmpCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1483ConFonNacEmpCont", GXutil.str( A1483ConFonNacEmpCont, 1, 0));
         A1484ConLeyRieTrabCont = T00573_A1484ConLeyRieTrabCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1484ConLeyRieTrabCont", GXutil.str( A1484ConLeyRieTrabCont, 1, 0));
         A1485ConRegDifApo = T00573_A1485ConRegDifApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1485ConRegDifApo", GXutil.str( A1485ConRegDifApo, 1, 0));
         A1486ConRegEspApo = T00573_A1486ConRegEspApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1486ConRegEspApo", GXutil.str( A1486ConRegEspApo, 1, 0));
         A1539ConSacDeven = T00573_A1539ConSacDeven[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1539ConSacDeven", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1539ConSacDeven), 2, 0));
         A1620ConBaseLic = T00573_A1620ConBaseLic[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
         A1797ConBaseLicProm = T00573_A1797ConBaseLicProm[0] ;
         A1621ConBaseFer = T00573_A1621ConBaseFer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
         A1798ConBaseFerProm = T00573_A1798ConBaseFerProm[0] ;
         A1622ConBaseHorExt = T00573_A1622ConBaseHorExt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
         A1799ConBaseHorExtProm = T00573_A1799ConBaseHorExtProm[0] ;
         A1800ConBasePres = T00573_A1800ConBasePres[0] ;
         A1801ConBaseAnt = T00573_A1801ConBaseAnt[0] ;
         A1827ConBaseOSDif = T00573_A1827ConBaseOSDif[0] ;
         A1821ConErrorSiCero = T00573_A1821ConErrorSiCero[0] ;
         A1826ConPueNov = T00573_A1826ConPueNov[0] ;
         A1822CliPadre = T00573_A1822CliPadre[0] ;
         n1822CliPadre = T00573_n1822CliPadre[0] ;
         A3CliCod = T00573_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1112AplIIGG = T00573_A1112AplIIGG[0] ;
         n1112AplIIGG = T00573_n1112AplIIGG[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
         A37TipoConCod = T00573_A37TipoConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
         A38SubTipoConCod1 = T00573_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = T00573_n38SubTipoConCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
         A39SubTipoConCod2 = T00573_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = T00573_n39SubTipoConCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
         A953ConCondicion = T00573_A953ConCondicion[0] ;
         n953ConCondicion = T00573_n953ConCondicion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
         A1644ConceptoPais = T00573_A1644ConceptoPais[0] ;
         n1644ConceptoPais = T00573_n1644ConceptoPais[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1644ConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1644ConceptoPais), 4, 0));
         A1645ConceptoConveCodigo = T00573_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = T00573_n1645ConceptoConveCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1645ConceptoConveCodigo", A1645ConceptoConveCodigo);
         A921ConPadre = T00573_A921ConPadre[0] ;
         n921ConPadre = T00573_n921ConPadre[0] ;
         Z3CliCod = A3CliCod ;
         Z26ConCodigo = A26ConCodigo ;
         sMode7 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load577( ) ;
         if ( AnyError == 1 )
         {
            RcdFound7 = (short)(0) ;
            initializeNonKey577( ) ;
         }
         Gx_mode = sMode7 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound7 = (short)(0) ;
         initializeNonKey577( ) ;
         sMode7 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode7 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey577( ) ;
      if ( RcdFound7 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound7 = (short)(0) ;
      /* Using cursor T005722 */
      pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(20) != 101) )
      {
         while ( (pr_default.getStatus(20) != 101) && ( ( T005722_A3CliCod[0] < A3CliCod ) || ( T005722_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005722_A26ConCodigo[0], A26ConCodigo) < 0 ) ) )
         {
            pr_default.readNext(20);
         }
         if ( (pr_default.getStatus(20) != 101) && ( ( T005722_A3CliCod[0] > A3CliCod ) || ( T005722_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005722_A26ConCodigo[0], A26ConCodigo) > 0 ) ) )
         {
            A3CliCod = T005722_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A26ConCodigo = T005722_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            RcdFound7 = (short)(1) ;
         }
      }
      pr_default.close(20);
   }

   public void move_previous( )
   {
      RcdFound7 = (short)(0) ;
      /* Using cursor T005723 */
      pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(21) != 101) )
      {
         while ( (pr_default.getStatus(21) != 101) && ( ( T005723_A3CliCod[0] > A3CliCod ) || ( T005723_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005723_A26ConCodigo[0], A26ConCodigo) > 0 ) ) )
         {
            pr_default.readNext(21);
         }
         if ( (pr_default.getStatus(21) != 101) && ( ( T005723_A3CliCod[0] < A3CliCod ) || ( T005723_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005723_A26ConCodigo[0], A26ConCodigo) < 0 ) ) )
         {
            A3CliCod = T005723_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A26ConCodigo = T005723_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            RcdFound7 = (short)(1) ;
         }
      }
      pr_default.close(21);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey577( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert577( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound7 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A26ConCodigo = Z26ConCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update577( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert577( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert577( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = Z26ConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency577( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00572 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Concepto"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z42ConCodYDesc, T00572_A42ConCodYDesc[0]) != 0 ) || ( GXutil.strcmp(Z41ConDescrip, T00572_A41ConDescrip[0]) != 0 ) || ( Z40ConOrden != T00572_A40ConOrden[0] ) || ( Z162ConVigencia != T00572_A162ConVigencia[0] ) || ( Z1488ConLiqBasica != T00572_A1488ConLiqBasica[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z159ConVariable != T00572_A159ConVariable[0] ) || ( Z146ConForEditable != T00572_A146ConForEditable[0] ) || ( GXutil.strcmp(Z503ConTipoLiqAux, T00572_A503ConTipoLiqAux[0]) != 0 ) || ( GXutil.strcmp(Z970ConClasifAux, T00572_A970ConClasifAux[0]) != 0 ) || ( Z510ConOrdEjec != T00572_A510ConOrdEjec[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z762ConRecalcular != T00572_A762ConRecalcular[0] ) || ( GXutil.strcmp(Z1018ConRangoCant, T00572_A1018ConRangoCant[0]) != 0 ) || ( GXutil.strcmp(Z954ConCondCodigo, T00572_A954ConCondCodigo[0]) != 0 ) || ( Z1068ConMostrarPos != T00572_A1068ConMostrarPos[0] ) || ( Z1077ConAdelDescu != T00572_A1077ConAdelDescu[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1194ConSegunPla != T00572_A1194ConSegunPla[0] ) || ( Z1471ConNumero != T00572_A1471ConNumero[0] ) || ( GXutil.strcmp(Z1648ConCodAfip, T00572_A1648ConCodAfip[0]) != 0 ) || ( Z1472ConSIPAApo != T00572_A1472ConSIPAApo[0] ) || ( Z1473ConSIPACont != T00572_A1473ConSIPACont[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1474ConINSSJyPApo != T00572_A1474ConINSSJyPApo[0] ) || ( Z1475ConINSSJyPCont != T00572_A1475ConINSSJyPCont[0] ) || ( Z1476ConObraSocApo != T00572_A1476ConObraSocApo[0] ) || ( Z1477ConObraSocCont != T00572_A1477ConObraSocCont[0] ) || ( Z1478ConFonSolRedApo != T00572_A1478ConFonSolRedApo[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1479ConFonSolRedCont != T00572_A1479ConFonSolRedCont[0] ) || ( Z1480ConRenateaApo != T00572_A1480ConRenateaApo[0] ) || ( Z1481ConRenateaCont != T00572_A1481ConRenateaCont[0] ) || ( Z1482ConAsigFamCont != T00572_A1482ConAsigFamCont[0] ) || ( Z1483ConFonNacEmpCont != T00572_A1483ConFonNacEmpCont[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1484ConLeyRieTrabCont != T00572_A1484ConLeyRieTrabCont[0] ) || ( Z1485ConRegDifApo != T00572_A1485ConRegDifApo[0] ) || ( Z1486ConRegEspApo != T00572_A1486ConRegEspApo[0] ) || ( Z1539ConSacDeven != T00572_A1539ConSacDeven[0] ) || ( Z1620ConBaseLic != T00572_A1620ConBaseLic[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1797ConBaseLicProm != T00572_A1797ConBaseLicProm[0] ) || ( Z1621ConBaseFer != T00572_A1621ConBaseFer[0] ) || ( Z1798ConBaseFerProm != T00572_A1798ConBaseFerProm[0] ) || ( Z1622ConBaseHorExt != T00572_A1622ConBaseHorExt[0] ) || ( Z1799ConBaseHorExtProm != T00572_A1799ConBaseHorExtProm[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1800ConBasePres != T00572_A1800ConBasePres[0] ) || ( Z1801ConBaseAnt != T00572_A1801ConBaseAnt[0] ) || ( Z1827ConBaseOSDif != T00572_A1827ConBaseOSDif[0] ) || ( Z1821ConErrorSiCero != T00572_A1821ConErrorSiCero[0] ) || ( Z1826ConPueNov != T00572_A1826ConPueNov[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1822CliPadre != T00572_A1822CliPadre[0] ) || ( Z1112AplIIGG != T00572_A1112AplIIGG[0] ) || ( GXutil.strcmp(Z37TipoConCod, T00572_A37TipoConCod[0]) != 0 ) || ( GXutil.strcmp(Z38SubTipoConCod1, T00572_A38SubTipoConCod1[0]) != 0 ) || ( GXutil.strcmp(Z39SubTipoConCod2, T00572_A39SubTipoConCod2[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z953ConCondicion, T00572_A953ConCondicion[0]) != 0 ) || ( Z1644ConceptoPais != T00572_A1644ConceptoPais[0] ) || ( GXutil.strcmp(Z1645ConceptoConveCodigo, T00572_A1645ConceptoConveCodigo[0]) != 0 ) || ( GXutil.strcmp(Z921ConPadre, T00572_A921ConPadre[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z42ConCodYDesc, T00572_A42ConCodYDesc[0]) != 0 )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConCodYDesc");
               GXutil.writeLogRaw("Old: ",Z42ConCodYDesc);
               GXutil.writeLogRaw("Current: ",T00572_A42ConCodYDesc[0]);
            }
            if ( GXutil.strcmp(Z41ConDescrip, T00572_A41ConDescrip[0]) != 0 )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConDescrip");
               GXutil.writeLogRaw("Old: ",Z41ConDescrip);
               GXutil.writeLogRaw("Current: ",T00572_A41ConDescrip[0]);
            }
            if ( Z40ConOrden != T00572_A40ConOrden[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConOrden");
               GXutil.writeLogRaw("Old: ",Z40ConOrden);
               GXutil.writeLogRaw("Current: ",T00572_A40ConOrden[0]);
            }
            if ( Z162ConVigencia != T00572_A162ConVigencia[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConVigencia");
               GXutil.writeLogRaw("Old: ",Z162ConVigencia);
               GXutil.writeLogRaw("Current: ",T00572_A162ConVigencia[0]);
            }
            if ( Z1488ConLiqBasica != T00572_A1488ConLiqBasica[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConLiqBasica");
               GXutil.writeLogRaw("Old: ",Z1488ConLiqBasica);
               GXutil.writeLogRaw("Current: ",T00572_A1488ConLiqBasica[0]);
            }
            if ( Z159ConVariable != T00572_A159ConVariable[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConVariable");
               GXutil.writeLogRaw("Old: ",Z159ConVariable);
               GXutil.writeLogRaw("Current: ",T00572_A159ConVariable[0]);
            }
            if ( Z146ConForEditable != T00572_A146ConForEditable[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConForEditable");
               GXutil.writeLogRaw("Old: ",Z146ConForEditable);
               GXutil.writeLogRaw("Current: ",T00572_A146ConForEditable[0]);
            }
            if ( GXutil.strcmp(Z503ConTipoLiqAux, T00572_A503ConTipoLiqAux[0]) != 0 )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConTipoLiqAux");
               GXutil.writeLogRaw("Old: ",Z503ConTipoLiqAux);
               GXutil.writeLogRaw("Current: ",T00572_A503ConTipoLiqAux[0]);
            }
            if ( GXutil.strcmp(Z970ConClasifAux, T00572_A970ConClasifAux[0]) != 0 )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConClasifAux");
               GXutil.writeLogRaw("Old: ",Z970ConClasifAux);
               GXutil.writeLogRaw("Current: ",T00572_A970ConClasifAux[0]);
            }
            if ( Z510ConOrdEjec != T00572_A510ConOrdEjec[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConOrdEjec");
               GXutil.writeLogRaw("Old: ",Z510ConOrdEjec);
               GXutil.writeLogRaw("Current: ",T00572_A510ConOrdEjec[0]);
            }
            if ( Z762ConRecalcular != T00572_A762ConRecalcular[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConRecalcular");
               GXutil.writeLogRaw("Old: ",Z762ConRecalcular);
               GXutil.writeLogRaw("Current: ",T00572_A762ConRecalcular[0]);
            }
            if ( GXutil.strcmp(Z1018ConRangoCant, T00572_A1018ConRangoCant[0]) != 0 )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConRangoCant");
               GXutil.writeLogRaw("Old: ",Z1018ConRangoCant);
               GXutil.writeLogRaw("Current: ",T00572_A1018ConRangoCant[0]);
            }
            if ( GXutil.strcmp(Z954ConCondCodigo, T00572_A954ConCondCodigo[0]) != 0 )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConCondCodigo");
               GXutil.writeLogRaw("Old: ",Z954ConCondCodigo);
               GXutil.writeLogRaw("Current: ",T00572_A954ConCondCodigo[0]);
            }
            if ( Z1068ConMostrarPos != T00572_A1068ConMostrarPos[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConMostrarPos");
               GXutil.writeLogRaw("Old: ",Z1068ConMostrarPos);
               GXutil.writeLogRaw("Current: ",T00572_A1068ConMostrarPos[0]);
            }
            if ( Z1077ConAdelDescu != T00572_A1077ConAdelDescu[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConAdelDescu");
               GXutil.writeLogRaw("Old: ",Z1077ConAdelDescu);
               GXutil.writeLogRaw("Current: ",T00572_A1077ConAdelDescu[0]);
            }
            if ( Z1194ConSegunPla != T00572_A1194ConSegunPla[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConSegunPla");
               GXutil.writeLogRaw("Old: ",Z1194ConSegunPla);
               GXutil.writeLogRaw("Current: ",T00572_A1194ConSegunPla[0]);
            }
            if ( Z1471ConNumero != T00572_A1471ConNumero[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConNumero");
               GXutil.writeLogRaw("Old: ",Z1471ConNumero);
               GXutil.writeLogRaw("Current: ",T00572_A1471ConNumero[0]);
            }
            if ( GXutil.strcmp(Z1648ConCodAfip, T00572_A1648ConCodAfip[0]) != 0 )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConCodAfip");
               GXutil.writeLogRaw("Old: ",Z1648ConCodAfip);
               GXutil.writeLogRaw("Current: ",T00572_A1648ConCodAfip[0]);
            }
            if ( Z1472ConSIPAApo != T00572_A1472ConSIPAApo[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConSIPAApo");
               GXutil.writeLogRaw("Old: ",Z1472ConSIPAApo);
               GXutil.writeLogRaw("Current: ",T00572_A1472ConSIPAApo[0]);
            }
            if ( Z1473ConSIPACont != T00572_A1473ConSIPACont[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConSIPACont");
               GXutil.writeLogRaw("Old: ",Z1473ConSIPACont);
               GXutil.writeLogRaw("Current: ",T00572_A1473ConSIPACont[0]);
            }
            if ( Z1474ConINSSJyPApo != T00572_A1474ConINSSJyPApo[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConINSSJyPApo");
               GXutil.writeLogRaw("Old: ",Z1474ConINSSJyPApo);
               GXutil.writeLogRaw("Current: ",T00572_A1474ConINSSJyPApo[0]);
            }
            if ( Z1475ConINSSJyPCont != T00572_A1475ConINSSJyPCont[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConINSSJyPCont");
               GXutil.writeLogRaw("Old: ",Z1475ConINSSJyPCont);
               GXutil.writeLogRaw("Current: ",T00572_A1475ConINSSJyPCont[0]);
            }
            if ( Z1476ConObraSocApo != T00572_A1476ConObraSocApo[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConObraSocApo");
               GXutil.writeLogRaw("Old: ",Z1476ConObraSocApo);
               GXutil.writeLogRaw("Current: ",T00572_A1476ConObraSocApo[0]);
            }
            if ( Z1477ConObraSocCont != T00572_A1477ConObraSocCont[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConObraSocCont");
               GXutil.writeLogRaw("Old: ",Z1477ConObraSocCont);
               GXutil.writeLogRaw("Current: ",T00572_A1477ConObraSocCont[0]);
            }
            if ( Z1478ConFonSolRedApo != T00572_A1478ConFonSolRedApo[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConFonSolRedApo");
               GXutil.writeLogRaw("Old: ",Z1478ConFonSolRedApo);
               GXutil.writeLogRaw("Current: ",T00572_A1478ConFonSolRedApo[0]);
            }
            if ( Z1479ConFonSolRedCont != T00572_A1479ConFonSolRedCont[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConFonSolRedCont");
               GXutil.writeLogRaw("Old: ",Z1479ConFonSolRedCont);
               GXutil.writeLogRaw("Current: ",T00572_A1479ConFonSolRedCont[0]);
            }
            if ( Z1480ConRenateaApo != T00572_A1480ConRenateaApo[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConRenateaApo");
               GXutil.writeLogRaw("Old: ",Z1480ConRenateaApo);
               GXutil.writeLogRaw("Current: ",T00572_A1480ConRenateaApo[0]);
            }
            if ( Z1481ConRenateaCont != T00572_A1481ConRenateaCont[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConRenateaCont");
               GXutil.writeLogRaw("Old: ",Z1481ConRenateaCont);
               GXutil.writeLogRaw("Current: ",T00572_A1481ConRenateaCont[0]);
            }
            if ( Z1482ConAsigFamCont != T00572_A1482ConAsigFamCont[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConAsigFamCont");
               GXutil.writeLogRaw("Old: ",Z1482ConAsigFamCont);
               GXutil.writeLogRaw("Current: ",T00572_A1482ConAsigFamCont[0]);
            }
            if ( Z1483ConFonNacEmpCont != T00572_A1483ConFonNacEmpCont[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConFonNacEmpCont");
               GXutil.writeLogRaw("Old: ",Z1483ConFonNacEmpCont);
               GXutil.writeLogRaw("Current: ",T00572_A1483ConFonNacEmpCont[0]);
            }
            if ( Z1484ConLeyRieTrabCont != T00572_A1484ConLeyRieTrabCont[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConLeyRieTrabCont");
               GXutil.writeLogRaw("Old: ",Z1484ConLeyRieTrabCont);
               GXutil.writeLogRaw("Current: ",T00572_A1484ConLeyRieTrabCont[0]);
            }
            if ( Z1485ConRegDifApo != T00572_A1485ConRegDifApo[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConRegDifApo");
               GXutil.writeLogRaw("Old: ",Z1485ConRegDifApo);
               GXutil.writeLogRaw("Current: ",T00572_A1485ConRegDifApo[0]);
            }
            if ( Z1486ConRegEspApo != T00572_A1486ConRegEspApo[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConRegEspApo");
               GXutil.writeLogRaw("Old: ",Z1486ConRegEspApo);
               GXutil.writeLogRaw("Current: ",T00572_A1486ConRegEspApo[0]);
            }
            if ( Z1539ConSacDeven != T00572_A1539ConSacDeven[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConSacDeven");
               GXutil.writeLogRaw("Old: ",Z1539ConSacDeven);
               GXutil.writeLogRaw("Current: ",T00572_A1539ConSacDeven[0]);
            }
            if ( Z1620ConBaseLic != T00572_A1620ConBaseLic[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConBaseLic");
               GXutil.writeLogRaw("Old: ",Z1620ConBaseLic);
               GXutil.writeLogRaw("Current: ",T00572_A1620ConBaseLic[0]);
            }
            if ( Z1797ConBaseLicProm != T00572_A1797ConBaseLicProm[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConBaseLicProm");
               GXutil.writeLogRaw("Old: ",Z1797ConBaseLicProm);
               GXutil.writeLogRaw("Current: ",T00572_A1797ConBaseLicProm[0]);
            }
            if ( Z1621ConBaseFer != T00572_A1621ConBaseFer[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConBaseFer");
               GXutil.writeLogRaw("Old: ",Z1621ConBaseFer);
               GXutil.writeLogRaw("Current: ",T00572_A1621ConBaseFer[0]);
            }
            if ( Z1798ConBaseFerProm != T00572_A1798ConBaseFerProm[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConBaseFerProm");
               GXutil.writeLogRaw("Old: ",Z1798ConBaseFerProm);
               GXutil.writeLogRaw("Current: ",T00572_A1798ConBaseFerProm[0]);
            }
            if ( Z1622ConBaseHorExt != T00572_A1622ConBaseHorExt[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConBaseHorExt");
               GXutil.writeLogRaw("Old: ",Z1622ConBaseHorExt);
               GXutil.writeLogRaw("Current: ",T00572_A1622ConBaseHorExt[0]);
            }
            if ( Z1799ConBaseHorExtProm != T00572_A1799ConBaseHorExtProm[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConBaseHorExtProm");
               GXutil.writeLogRaw("Old: ",Z1799ConBaseHorExtProm);
               GXutil.writeLogRaw("Current: ",T00572_A1799ConBaseHorExtProm[0]);
            }
            if ( Z1800ConBasePres != T00572_A1800ConBasePres[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConBasePres");
               GXutil.writeLogRaw("Old: ",Z1800ConBasePres);
               GXutil.writeLogRaw("Current: ",T00572_A1800ConBasePres[0]);
            }
            if ( Z1801ConBaseAnt != T00572_A1801ConBaseAnt[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConBaseAnt");
               GXutil.writeLogRaw("Old: ",Z1801ConBaseAnt);
               GXutil.writeLogRaw("Current: ",T00572_A1801ConBaseAnt[0]);
            }
            if ( Z1827ConBaseOSDif != T00572_A1827ConBaseOSDif[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConBaseOSDif");
               GXutil.writeLogRaw("Old: ",Z1827ConBaseOSDif);
               GXutil.writeLogRaw("Current: ",T00572_A1827ConBaseOSDif[0]);
            }
            if ( Z1821ConErrorSiCero != T00572_A1821ConErrorSiCero[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConErrorSiCero");
               GXutil.writeLogRaw("Old: ",Z1821ConErrorSiCero);
               GXutil.writeLogRaw("Current: ",T00572_A1821ConErrorSiCero[0]);
            }
            if ( Z1826ConPueNov != T00572_A1826ConPueNov[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConPueNov");
               GXutil.writeLogRaw("Old: ",Z1826ConPueNov);
               GXutil.writeLogRaw("Current: ",T00572_A1826ConPueNov[0]);
            }
            if ( Z1822CliPadre != T00572_A1822CliPadre[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"CliPadre");
               GXutil.writeLogRaw("Old: ",Z1822CliPadre);
               GXutil.writeLogRaw("Current: ",T00572_A1822CliPadre[0]);
            }
            if ( Z1112AplIIGG != T00572_A1112AplIIGG[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"AplIIGG");
               GXutil.writeLogRaw("Old: ",Z1112AplIIGG);
               GXutil.writeLogRaw("Current: ",T00572_A1112AplIIGG[0]);
            }
            if ( GXutil.strcmp(Z37TipoConCod, T00572_A37TipoConCod[0]) != 0 )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"TipoConCod");
               GXutil.writeLogRaw("Old: ",Z37TipoConCod);
               GXutil.writeLogRaw("Current: ",T00572_A37TipoConCod[0]);
            }
            if ( GXutil.strcmp(Z38SubTipoConCod1, T00572_A38SubTipoConCod1[0]) != 0 )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"SubTipoConCod1");
               GXutil.writeLogRaw("Old: ",Z38SubTipoConCod1);
               GXutil.writeLogRaw("Current: ",T00572_A38SubTipoConCod1[0]);
            }
            if ( GXutil.strcmp(Z39SubTipoConCod2, T00572_A39SubTipoConCod2[0]) != 0 )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"SubTipoConCod2");
               GXutil.writeLogRaw("Old: ",Z39SubTipoConCod2);
               GXutil.writeLogRaw("Current: ",T00572_A39SubTipoConCod2[0]);
            }
            if ( GXutil.strcmp(Z953ConCondicion, T00572_A953ConCondicion[0]) != 0 )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConCondicion");
               GXutil.writeLogRaw("Old: ",Z953ConCondicion);
               GXutil.writeLogRaw("Current: ",T00572_A953ConCondicion[0]);
            }
            if ( Z1644ConceptoPais != T00572_A1644ConceptoPais[0] )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConceptoPais");
               GXutil.writeLogRaw("Old: ",Z1644ConceptoPais);
               GXutil.writeLogRaw("Current: ",T00572_A1644ConceptoPais[0]);
            }
            if ( GXutil.strcmp(Z1645ConceptoConveCodigo, T00572_A1645ConceptoConveCodigo[0]) != 0 )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConceptoConveCodigo");
               GXutil.writeLogRaw("Old: ",Z1645ConceptoConveCodigo);
               GXutil.writeLogRaw("Current: ",T00572_A1645ConceptoConveCodigo[0]);
            }
            if ( GXutil.strcmp(Z921ConPadre, T00572_A921ConPadre[0]) != 0 )
            {
               GXutil.writeLogln("conceptos_export:[seudo value changed for attri]"+"ConPadre");
               GXutil.writeLogRaw("Old: ",Z921ConPadre);
               GXutil.writeLogRaw("Current: ",T00572_A921ConPadre[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Concepto"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert577( )
   {
      beforeValidate577( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable577( ) ;
      }
      if ( AnyError == 0 )
      {
         zm577( 0) ;
         checkOptimisticConcurrency577( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm577( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert577( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005724 */
                  pr_default.execute(22, new Object[] {Boolean.valueOf(n42ConCodYDesc), A42ConCodYDesc, A26ConCodigo, A41ConDescrip, Integer.valueOf(A40ConOrden), Byte.valueOf(A162ConVigencia), Byte.valueOf(A1488ConLiqBasica), Boolean.valueOf(n148ConFormula), A148ConFormula, A153ConObservacion, Boolean.valueOf(A159ConVariable), Boolean.valueOf(n146ConForEditable), Boolean.valueOf(A146ConForEditable), Boolean.valueOf(n503ConTipoLiqAux), A503ConTipoLiqAux, Boolean.valueOf(n970ConClasifAux), A970ConClasifAux, Long.valueOf(A510ConOrdEjec), A569ConFormulaExpl, Boolean.valueOf(A762ConRecalcular), A1018ConRangoCant, A954ConCondCodigo, Boolean.valueOf(A1068ConMostrarPos), Boolean.valueOf(n1077ConAdelDescu), Byte.valueOf(A1077ConAdelDescu), Boolean.valueOf(A1194ConSegunPla), Byte.valueOf(A1471ConNumero), A1648ConCodAfip, Byte.valueOf(A1472ConSIPAApo), Byte.valueOf(A1473ConSIPACont), Byte.valueOf(A1474ConINSSJyPApo), Byte.valueOf(A1475ConINSSJyPCont), Byte.valueOf(A1476ConObraSocApo), Byte.valueOf(A1477ConObraSocCont), Byte.valueOf(A1478ConFonSolRedApo), Byte.valueOf(A1479ConFonSolRedCont), Byte.valueOf(A1480ConRenateaApo), Byte.valueOf(A1481ConRenateaCont), Byte.valueOf(A1482ConAsigFamCont), Byte.valueOf(A1483ConFonNacEmpCont), Byte.valueOf(A1484ConLeyRieTrabCont), Byte.valueOf(A1485ConRegDifApo), Byte.valueOf(A1486ConRegEspApo), Byte.valueOf(A1539ConSacDeven), Byte.valueOf(A1620ConBaseLic), Byte.valueOf(A1797ConBaseLicProm), Byte.valueOf(A1621ConBaseFer), Byte.valueOf(A1798ConBaseFerProm), Byte.valueOf(A1622ConBaseHorExt), Byte.valueOf(A1799ConBaseHorExtProm), Byte.valueOf(A1800ConBasePres), Byte.valueOf(A1801ConBaseAnt), Byte.valueOf(A1827ConBaseOSDif), Boolean.valueOf(A1821ConErrorSiCero), Boolean.valueOf(A1826ConPueNov), Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG), A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2, Boolean.valueOf(n953ConCondicion), A953ConCondicion, Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo, Boolean.valueOf(n921ConPadre), A921ConPadre});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
                  if ( (pr_default.getStatus(22) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption570( ) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load577( ) ;
         }
         endLevel577( ) ;
      }
      closeExtendedTableCursors577( ) ;
   }

   public void update577( )
   {
      beforeValidate577( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable577( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency577( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm577( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate577( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005725 */
                  pr_default.execute(23, new Object[] {Boolean.valueOf(n42ConCodYDesc), A42ConCodYDesc, A41ConDescrip, Integer.valueOf(A40ConOrden), Byte.valueOf(A162ConVigencia), Byte.valueOf(A1488ConLiqBasica), Boolean.valueOf(n148ConFormula), A148ConFormula, A153ConObservacion, Boolean.valueOf(A159ConVariable), Boolean.valueOf(n146ConForEditable), Boolean.valueOf(A146ConForEditable), Boolean.valueOf(n503ConTipoLiqAux), A503ConTipoLiqAux, Boolean.valueOf(n970ConClasifAux), A970ConClasifAux, Long.valueOf(A510ConOrdEjec), A569ConFormulaExpl, Boolean.valueOf(A762ConRecalcular), A1018ConRangoCant, A954ConCondCodigo, Boolean.valueOf(A1068ConMostrarPos), Boolean.valueOf(n1077ConAdelDescu), Byte.valueOf(A1077ConAdelDescu), Boolean.valueOf(A1194ConSegunPla), Byte.valueOf(A1471ConNumero), A1648ConCodAfip, Byte.valueOf(A1472ConSIPAApo), Byte.valueOf(A1473ConSIPACont), Byte.valueOf(A1474ConINSSJyPApo), Byte.valueOf(A1475ConINSSJyPCont), Byte.valueOf(A1476ConObraSocApo), Byte.valueOf(A1477ConObraSocCont), Byte.valueOf(A1478ConFonSolRedApo), Byte.valueOf(A1479ConFonSolRedCont), Byte.valueOf(A1480ConRenateaApo), Byte.valueOf(A1481ConRenateaCont), Byte.valueOf(A1482ConAsigFamCont), Byte.valueOf(A1483ConFonNacEmpCont), Byte.valueOf(A1484ConLeyRieTrabCont), Byte.valueOf(A1485ConRegDifApo), Byte.valueOf(A1486ConRegEspApo), Byte.valueOf(A1539ConSacDeven), Byte.valueOf(A1620ConBaseLic), Byte.valueOf(A1797ConBaseLicProm), Byte.valueOf(A1621ConBaseFer), Byte.valueOf(A1798ConBaseFerProm), Byte.valueOf(A1622ConBaseHorExt), Byte.valueOf(A1799ConBaseHorExtProm), Byte.valueOf(A1800ConBasePres), Byte.valueOf(A1801ConBaseAnt), Byte.valueOf(A1827ConBaseOSDif), Boolean.valueOf(A1821ConErrorSiCero), Boolean.valueOf(A1826ConPueNov), Boolean.valueOf(n1822CliPadre), Integer.valueOf(A1822CliPadre), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG), A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2, Boolean.valueOf(n953ConCondicion), A953ConCondicion, Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo, Boolean.valueOf(n921ConPadre), A921ConPadre, Integer.valueOf(A3CliCod), A26ConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
                  if ( (pr_default.getStatus(23) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Concepto"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate577( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel577( ) ;
      }
      closeExtendedTableCursors577( ) ;
   }

   public void deferredUpdate577( )
   {
   }

   public void delete( )
   {
      beforeValidate577( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency577( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls577( ) ;
         afterConfirm577( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete577( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005726 */
               pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     if ( isUpd( ) || isDlt( ) )
                     {
                        if ( AnyError == 0 )
                        {
                           httpContext.nUserReturn = (byte)(1) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode7 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel577( ) ;
      Gx_mode = sMode7 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls577( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV38Pgmname = "Conceptos_export" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005727 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
         /* Using cursor T005728 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos remuneración actual", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
         /* Using cursor T005729 */
         pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(27) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "conceptos_horanormal_mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(27);
         /* Using cursor T005730 */
         pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(28) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "conceptos_horanormal_jornalizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(28);
         /* Using cursor T005731 */
         pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(29) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo_sueldosConceptos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
         /* Using cursor T005732 */
         pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(30) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "concepto_operandos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
         /* Using cursor T005733 */
         pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor T005734 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor T005735 */
         pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Convenio_horasextras_por Dia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor T005736 */
         pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor T005737 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "detalle", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor T005738 */
         pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para jornalizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
         /* Using cursor T005739 */
         pr_default.execute(37, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(37) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(37);
         /* Using cursor T005740 */
         pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(38) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Excepciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(38);
         /* Using cursor T005741 */
         pr_default.execute(39, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(39) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Obligacion", "")+" ("+httpContext.getMessage( "Obligacion Concepto", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(39);
         /* Using cursor T005742 */
         pr_default.execute(40, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(40) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Obligacion", "")+" ("+httpContext.getMessage( "Obl Concepto", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(40);
         /* Using cursor T005743 */
         pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(41) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "liquidacion_exencion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(41);
         /* Using cursor T005744 */
         pr_default.execute(42, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(42) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo aplicacion ganancias", "")+" ("+httpContext.getMessage( "Apl IIGGOtros Group", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(42);
         /* Using cursor T005745 */
         pr_default.execute(43, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(43) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo aplicacion ganancias", "")+" ("+httpContext.getMessage( "Apl IIGGCon Exen Group", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(43);
         /* Using cursor T005746 */
         pr_default.execute(44, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(44) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo aplicacion ganancias", "")+" ("+httpContext.getMessage( "Tipo Apl IIGGConc Group", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(44);
         /* Using cursor T005747 */
         pr_default.execute(45, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(45) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "condicion_exencion_iigg", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(45);
         /* Using cursor T005748 */
         pr_default.execute(46, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(46) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "siradig_codigos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(46);
         /* Using cursor T005749 */
         pr_default.execute(47, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(47) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Concepto Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(47);
         /* Using cursor T005750 */
         pr_default.execute(48, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(48) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_dedducciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(48);
         /* Using cursor T005751 */
         pr_default.execute(49, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(49) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Formula Historico", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(49);
         /* Using cursor T005752 */
         pr_default.execute(50, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(50) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Tipo Liquidacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(50);
         /* Using cursor T005753 */
         pr_default.execute(51, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         if ( (pr_default.getStatus(51) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Agenda de Novedades", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(51);
      }
   }

   public void endLevel577( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete577( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "conceptos_export");
         if ( AnyError == 0 )
         {
            confirmValues570( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "conceptos_export");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart577( )
   {
      /* Scan By routine */
      /* Using cursor T005754 */
      pr_default.execute(52);
      RcdFound7 = (short)(0) ;
      if ( (pr_default.getStatus(52) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A3CliCod = T005754_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = T005754_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext577( )
   {
      /* Scan next routine */
      pr_default.readNext(52);
      RcdFound7 = (short)(0) ;
      if ( (pr_default.getStatus(52) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A3CliCod = T005754_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = T005754_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      }
   }

   public void scanEnd577( )
   {
      pr_default.close(52);
   }

   public void afterConfirm577( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert577( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate577( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete577( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete577( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate577( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes577( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtConCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      edtConDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConDescrip_Enabled), 5, 0), true);
      edtConOrden_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConOrden_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConOrden_Enabled), 5, 0), true);
      cmbConVigencia.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConVigencia.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConVigencia.getEnabled(), 5, 0), true);
      edtConLiqBasica_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConLiqBasica_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConLiqBasica_Enabled), 5, 0), true);
      edtConFormula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFormula_Enabled), 5, 0), true);
      edtConObservacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConObservacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConObservacion_Enabled), 5, 0), true);
      chkConVariable.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "Enabled", GXutil.ltrimstr( chkConVariable.getEnabled(), 5, 0), true);
      chkConForEditable.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConForEditable.getInternalname(), "Enabled", GXutil.ltrimstr( chkConForEditable.getEnabled(), 5, 0), true);
      cmbTipoConCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipoConCod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTipoConCod.getEnabled(), 5, 0), true);
      edtSubTipoConCod1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod1_Enabled), 5, 0), true);
      edtSubTipoConCod2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSubTipoConCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSubTipoConCod2_Enabled), 5, 0), true);
      edtConTipoLiqAux_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConTipoLiqAux_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConTipoLiqAux_Enabled), 5, 0), true);
      edtConClasifAux_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConClasifAux_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConClasifAux_Enabled), 5, 0), true);
      edtConOrdEjec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConOrdEjec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConOrdEjec_Enabled), 5, 0), true);
      edtConFormulaExpl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFormulaExpl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFormulaExpl_Enabled), 5, 0), true);
      chkConRecalcular.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConRecalcular.getInternalname(), "Enabled", GXutil.ltrimstr( chkConRecalcular.getEnabled(), 5, 0), true);
      edtConRangoCant_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRangoCant_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRangoCant_Enabled), 5, 0), true);
      cmbConCondicion.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConCondicion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConCondicion.getEnabled(), 5, 0), true);
      edtConCondCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCondCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCondCodigo_Enabled), 5, 0), true);
      chkConMostrarPos.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConMostrarPos.getInternalname(), "Enabled", GXutil.ltrimstr( chkConMostrarPos.getEnabled(), 5, 0), true);
      cmbConAdelDescu.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAdelDescu.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAdelDescu.getEnabled(), 5, 0), true);
      edtAplIIGG_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGG_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGG_Enabled), 5, 0), true);
      chkConSegunPla.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConSegunPla.getInternalname(), "Enabled", GXutil.ltrimstr( chkConSegunPla.getEnabled(), 5, 0), true);
      edtConNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConNumero_Enabled), 5, 0), true);
      edtConCodAfip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodAfip_Enabled), 5, 0), true);
      edtConSIPAApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConSIPAApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConSIPAApo_Enabled), 5, 0), true);
      edtConSIPACont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConSIPACont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConSIPACont_Enabled), 5, 0), true);
      edtConINSSJyPApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConINSSJyPApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConINSSJyPApo_Enabled), 5, 0), true);
      edtConINSSJyPCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConINSSJyPCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConINSSJyPCont_Enabled), 5, 0), true);
      edtConObraSocApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConObraSocApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConObraSocApo_Enabled), 5, 0), true);
      edtConObraSocCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConObraSocCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConObraSocCont_Enabled), 5, 0), true);
      edtConFonSolRedApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFonSolRedApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFonSolRedApo_Enabled), 5, 0), true);
      edtConFonSolRedCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFonSolRedCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFonSolRedCont_Enabled), 5, 0), true);
      edtConRenateaApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRenateaApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRenateaApo_Enabled), 5, 0), true);
      edtConRenateaCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRenateaCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRenateaCont_Enabled), 5, 0), true);
      edtConAsigFamCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConAsigFamCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConAsigFamCont_Enabled), 5, 0), true);
      edtConFonNacEmpCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConFonNacEmpCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConFonNacEmpCont_Enabled), 5, 0), true);
      edtConLeyRieTrabCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConLeyRieTrabCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConLeyRieTrabCont_Enabled), 5, 0), true);
      edtConRegDifApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRegDifApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRegDifApo_Enabled), 5, 0), true);
      edtConRegEspApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConRegEspApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConRegEspApo_Enabled), 5, 0), true);
      cmbConSacDeven.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConSacDeven.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConSacDeven.getEnabled(), 5, 0), true);
      edtConceptoPais_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConceptoPais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConceptoPais_Enabled), 5, 0), true);
      edtConceptoConveCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConceptoConveCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConceptoConveCodigo_Enabled), 5, 0), true);
      cmbConBaseLic.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseLic.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConBaseLic.getEnabled(), 5, 0), true);
      cmbConBaseFer.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseFer.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConBaseFer.getEnabled(), 5, 0), true);
      cmbConBaseHorExt.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConBaseHorExt.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConBaseHorExt.getEnabled(), 5, 0), true);
      cmbavCombotipoconcod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCombotipoconcod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavCombotipoconcod.getEnabled(), 5, 0), true);
      edtavCombosubtipoconcod1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosubtipoconcod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosubtipoconcod1_Enabled), 5, 0), true);
      edtavCombosubtipoconcod2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosubtipoconcod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosubtipoconcod2_Enabled), 5, 0), true);
      cmbavComboconcondicion.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavComboconcondicion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavComboconcondicion.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes577( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues570( )
   {
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
      MasterPageObj.master_styles();
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
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptos_export", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8ConCodigo))}, new String[] {"Gx_mode","CliCod","ConCodigo"}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Conceptos_export");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ConBaseLicProm", localUtil.format( DecimalUtil.doubleToDec(A1797ConBaseLicProm), "9"));
      forbiddenHiddens.add("ConBaseFerProm", localUtil.format( DecimalUtil.doubleToDec(A1798ConBaseFerProm), "9"));
      forbiddenHiddens.add("ConBaseHorExtProm", localUtil.format( DecimalUtil.doubleToDec(A1799ConBaseHorExtProm), "9"));
      forbiddenHiddens.add("ConBasePres", localUtil.format( DecimalUtil.doubleToDec(A1800ConBasePres), "9"));
      forbiddenHiddens.add("ConBaseAnt", localUtil.format( DecimalUtil.doubleToDec(A1801ConBaseAnt), "9"));
      forbiddenHiddens.add("ConBaseOSDif", localUtil.format( DecimalUtil.doubleToDec(A1827ConBaseOSDif), "9"));
      forbiddenHiddens.add("ConErrorSiCero", GXutil.booltostr( A1821ConErrorSiCero));
      forbiddenHiddens.add("ConPueNov", GXutil.booltostr( A1826ConPueNov));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("conceptos_export:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z26ConCodigo", GXutil.rtrim( Z26ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z42ConCodYDesc", Z42ConCodYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z41ConDescrip", Z41ConDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z40ConOrden", GXutil.ltrim( localUtil.ntoc( Z40ConOrden, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z162ConVigencia", GXutil.ltrim( localUtil.ntoc( Z162ConVigencia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1488ConLiqBasica", GXutil.ltrim( localUtil.ntoc( Z1488ConLiqBasica, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z159ConVariable", Z159ConVariable);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z146ConForEditable", Z146ConForEditable);
      web.GxWebStd.gx_hidden_field( httpContext, "Z503ConTipoLiqAux", Z503ConTipoLiqAux);
      web.GxWebStd.gx_hidden_field( httpContext, "Z970ConClasifAux", Z970ConClasifAux);
      web.GxWebStd.gx_hidden_field( httpContext, "Z510ConOrdEjec", GXutil.ltrim( localUtil.ntoc( Z510ConOrdEjec, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z762ConRecalcular", Z762ConRecalcular);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1018ConRangoCant", Z1018ConRangoCant);
      web.GxWebStd.gx_hidden_field( httpContext, "Z954ConCondCodigo", GXutil.rtrim( Z954ConCondCodigo));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1068ConMostrarPos", Z1068ConMostrarPos);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1077ConAdelDescu", GXutil.ltrim( localUtil.ntoc( Z1077ConAdelDescu, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1194ConSegunPla", Z1194ConSegunPla);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1471ConNumero", GXutil.ltrim( localUtil.ntoc( Z1471ConNumero, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1648ConCodAfip", GXutil.rtrim( Z1648ConCodAfip));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1472ConSIPAApo", GXutil.ltrim( localUtil.ntoc( Z1472ConSIPAApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1473ConSIPACont", GXutil.ltrim( localUtil.ntoc( Z1473ConSIPACont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1474ConINSSJyPApo", GXutil.ltrim( localUtil.ntoc( Z1474ConINSSJyPApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1475ConINSSJyPCont", GXutil.ltrim( localUtil.ntoc( Z1475ConINSSJyPCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1476ConObraSocApo", GXutil.ltrim( localUtil.ntoc( Z1476ConObraSocApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1477ConObraSocCont", GXutil.ltrim( localUtil.ntoc( Z1477ConObraSocCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1478ConFonSolRedApo", GXutil.ltrim( localUtil.ntoc( Z1478ConFonSolRedApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1479ConFonSolRedCont", GXutil.ltrim( localUtil.ntoc( Z1479ConFonSolRedCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1480ConRenateaApo", GXutil.ltrim( localUtil.ntoc( Z1480ConRenateaApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1481ConRenateaCont", GXutil.ltrim( localUtil.ntoc( Z1481ConRenateaCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1482ConAsigFamCont", GXutil.ltrim( localUtil.ntoc( Z1482ConAsigFamCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1483ConFonNacEmpCont", GXutil.ltrim( localUtil.ntoc( Z1483ConFonNacEmpCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1484ConLeyRieTrabCont", GXutil.ltrim( localUtil.ntoc( Z1484ConLeyRieTrabCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1485ConRegDifApo", GXutil.ltrim( localUtil.ntoc( Z1485ConRegDifApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1486ConRegEspApo", GXutil.ltrim( localUtil.ntoc( Z1486ConRegEspApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1539ConSacDeven", GXutil.ltrim( localUtil.ntoc( Z1539ConSacDeven, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1620ConBaseLic", GXutil.ltrim( localUtil.ntoc( Z1620ConBaseLic, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1797ConBaseLicProm", GXutil.ltrim( localUtil.ntoc( Z1797ConBaseLicProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1621ConBaseFer", GXutil.ltrim( localUtil.ntoc( Z1621ConBaseFer, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1798ConBaseFerProm", GXutil.ltrim( localUtil.ntoc( Z1798ConBaseFerProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1622ConBaseHorExt", GXutil.ltrim( localUtil.ntoc( Z1622ConBaseHorExt, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1799ConBaseHorExtProm", GXutil.ltrim( localUtil.ntoc( Z1799ConBaseHorExtProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1800ConBasePres", GXutil.ltrim( localUtil.ntoc( Z1800ConBasePres, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1801ConBaseAnt", GXutil.ltrim( localUtil.ntoc( Z1801ConBaseAnt, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1827ConBaseOSDif", GXutil.ltrim( localUtil.ntoc( Z1827ConBaseOSDif, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1821ConErrorSiCero", Z1821ConErrorSiCero);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1826ConPueNov", Z1826ConPueNov);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1822CliPadre", GXutil.ltrim( localUtil.ntoc( Z1822CliPadre, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1112AplIIGG", GXutil.ltrim( localUtil.ntoc( Z1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z37TipoConCod", GXutil.rtrim( Z37TipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z38SubTipoConCod1", GXutil.rtrim( Z38SubTipoConCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z39SubTipoConCod2", GXutil.rtrim( Z39SubTipoConCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z953ConCondicion", GXutil.rtrim( Z953ConCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1644ConceptoPais", GXutil.ltrim( localUtil.ntoc( Z1644ConceptoPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1645ConceptoConveCodigo", GXutil.rtrim( Z1645ConceptoConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z921ConPadre", GXutil.rtrim( Z921ConPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N37TipoConCod", GXutil.rtrim( A37TipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "N38SubTipoConCod1", GXutil.rtrim( A38SubTipoConCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "N39SubTipoConCod2", GXutil.rtrim( A39SubTipoConCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "N953ConCondicion", GXutil.rtrim( A953ConCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, "N1112AplIIGG", GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1644ConceptoPais", GXutil.ltrim( localUtil.ntoc( A1644ConceptoPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1645ConceptoConveCodigo", GXutil.rtrim( A1645ConceptoConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "N1822CliPadre", GXutil.ltrim( localUtil.ntoc( A1822CliPadre, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N921ConPadre", GXutil.rtrim( A921ConPadre));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV22DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV22DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTIPOCONCOD_DATA", AV21TipoConCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTIPOCONCOD_DATA", AV21TipoConCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSUBTIPOCONCOD1_DATA", AV27SubTipoConCod1_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSUBTIPOCONCOD1_DATA", AV27SubTipoConCod1_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSUBTIPOCONCOD2_DATA", AV30SubTipoConCod2_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSUBTIPOCONCOD2_DATA", AV30SubTipoConCod2_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCONCONDICION_DATA", AV34ConCondicion_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCONCONDICION_DATA", AV34ConCondicion_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCOND_TIPOCONCOD", GXutil.rtrim( AV29Cond_TipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "vCOND_SUBTIPOCONCOD1", GXutil.rtrim( AV32Cond_SubTipoConCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCODYDESC", A42ConCodYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONCODIGO", GXutil.rtrim( AV8ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8ConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_TIPOCONCOD", GXutil.rtrim( AV14Insert_TipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SUBTIPOCONCOD1", GXutil.rtrim( AV15Insert_SubTipoConCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SUBTIPOCONCOD2", GXutil.rtrim( AV16Insert_SubTipoConCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONCONDICION", GXutil.rtrim( AV33Insert_ConCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_APLIIGG", GXutil.ltrim( localUtil.ntoc( AV17Insert_AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONCEPTOPAIS", GXutil.ltrim( localUtil.ntoc( AV18Insert_ConceptoPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONCEPTOCONVECODIGO", GXutil.rtrim( AV19Insert_ConceptoConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CLIPADRE", GXutil.ltrim( localUtil.ntoc( AV36Insert_CliPadre, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLIPADRE", GXutil.ltrim( localUtil.ntoc( A1822CliPadre, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONPADRE", GXutil.rtrim( AV37Insert_ConPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "CONPADRE", GXutil.rtrim( A921ConPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASELICPROM", GXutil.ltrim( localUtil.ntoc( A1797ConBaseLicProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEFERPROM", GXutil.ltrim( localUtil.ntoc( A1798ConBaseFerProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEHOREXTPROM", GXutil.ltrim( localUtil.ntoc( A1799ConBaseHorExtProm, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEPRES", GXutil.ltrim( localUtil.ntoc( A1800ConBasePres, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEANT", GXutil.ltrim( localUtil.ntoc( A1801ConBaseAnt, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONBASEOSDIF", GXutil.ltrim( localUtil.ntoc( A1827ConBaseOSDif, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONERRORSICERO", A1821ConErrorSiCero);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONPUENOV", A1826ConPueNov);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV38Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONCOD_Objectcall", GXutil.rtrim( Combo_tipoconcod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONCOD_Cls", GXutil.rtrim( Combo_tipoconcod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONCOD_Selectedvalue_set", GXutil.rtrim( Combo_tipoconcod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONCOD_Selectedtext_set", GXutil.rtrim( Combo_tipoconcod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONCOD_Enabled", GXutil.booltostr( Combo_tipoconcod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONCOD_Datalistproc", GXutil.rtrim( Combo_tipoconcod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONCOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_tipoconcod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPOCONCOD_Emptyitem", GXutil.booltostr( Combo_tipoconcod_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD1_Objectcall", GXutil.rtrim( Combo_subtipoconcod1_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD1_Cls", GXutil.rtrim( Combo_subtipoconcod1_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD1_Selectedvalue_set", GXutil.rtrim( Combo_subtipoconcod1_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD1_Selectedtext_set", GXutil.rtrim( Combo_subtipoconcod1_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD1_Enabled", GXutil.booltostr( Combo_subtipoconcod1_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD1_Datalistproc", GXutil.rtrim( Combo_subtipoconcod1_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD1_Datalistprocparametersprefix", GXutil.rtrim( Combo_subtipoconcod1_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD2_Objectcall", GXutil.rtrim( Combo_subtipoconcod2_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD2_Cls", GXutil.rtrim( Combo_subtipoconcod2_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD2_Selectedvalue_set", GXutil.rtrim( Combo_subtipoconcod2_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD2_Selectedtext_set", GXutil.rtrim( Combo_subtipoconcod2_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD2_Enabled", GXutil.booltostr( Combo_subtipoconcod2_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD2_Datalistproc", GXutil.rtrim( Combo_subtipoconcod2_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUBTIPOCONCOD2_Datalistprocparametersprefix", GXutil.rtrim( Combo_subtipoconcod2_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCONDICION_Objectcall", GXutil.rtrim( Combo_concondicion_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCONDICION_Cls", GXutil.rtrim( Combo_concondicion_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCONDICION_Selectedvalue_set", GXutil.rtrim( Combo_concondicion_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCONDICION_Selectedtext_set", GXutil.rtrim( Combo_concondicion_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCONDICION_Enabled", GXutil.booltostr( Combo_concondicion_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCONDICION_Datalistproc", GXutil.rtrim( Combo_concondicion_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCONDICION_Datalistprocparametersprefix", GXutil.rtrim( Combo_concondicion_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
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

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
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
      return formatLink("web.conceptos_export", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8ConCodigo))}, new String[] {"Gx_mode","CliCod","ConCodigo"})  ;
   }

   public String getPgmname( )
   {
      return "Conceptos_export" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Conceptos_export", "") ;
   }

   public void initializeNonKey577( )
   {
      A37TipoConCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      A38SubTipoConCod1 = "" ;
      n38SubTipoConCod1 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A38SubTipoConCod1", A38SubTipoConCod1);
      n38SubTipoConCod1 = ((GXutil.strcmp("", A38SubTipoConCod1)==0) ? true : false) ;
      A39SubTipoConCod2 = "" ;
      n39SubTipoConCod2 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A39SubTipoConCod2", A39SubTipoConCod2);
      n39SubTipoConCod2 = ((GXutil.strcmp("", A39SubTipoConCod2)==0) ? true : false) ;
      A953ConCondicion = "" ;
      n953ConCondicion = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
      n953ConCondicion = ((GXutil.strcmp("", A953ConCondicion)==0) ? true : false) ;
      A1112AplIIGG = (short)(0) ;
      n1112AplIIGG = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      n1112AplIIGG = ((0==A1112AplIIGG) ? true : false) ;
      A1644ConceptoPais = (short)(0) ;
      n1644ConceptoPais = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1644ConceptoPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1644ConceptoPais), 4, 0));
      n1644ConceptoPais = ((0==A1644ConceptoPais) ? true : false) ;
      A1645ConceptoConveCodigo = "" ;
      n1645ConceptoConveCodigo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1645ConceptoConveCodigo", A1645ConceptoConveCodigo);
      n1645ConceptoConveCodigo = ((GXutil.strcmp("", A1645ConceptoConveCodigo)==0) ? true : false) ;
      A1822CliPadre = 0 ;
      n1822CliPadre = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1822CliPadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1822CliPadre), 6, 0));
      A921ConPadre = "" ;
      n921ConPadre = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A921ConPadre", A921ConPadre);
      A42ConCodYDesc = "" ;
      n42ConCodYDesc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      A41ConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
      A40ConOrden = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A40ConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40ConOrden), 8, 0));
      A162ConVigencia = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
      A1488ConLiqBasica = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1488ConLiqBasica", GXutil.str( A1488ConLiqBasica, 1, 0));
      A148ConFormula = "" ;
      n148ConFormula = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A148ConFormula", A148ConFormula);
      n148ConFormula = ((GXutil.strcmp("", A148ConFormula)==0) ? true : false) ;
      A153ConObservacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A153ConObservacion", A153ConObservacion);
      A159ConVariable = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
      A146ConForEditable = false ;
      n146ConForEditable = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A146ConForEditable", A146ConForEditable);
      n146ConForEditable = ((false==A146ConForEditable) ? true : false) ;
      A503ConTipoLiqAux = "" ;
      n503ConTipoLiqAux = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A503ConTipoLiqAux", A503ConTipoLiqAux);
      n503ConTipoLiqAux = ((GXutil.strcmp("", A503ConTipoLiqAux)==0) ? true : false) ;
      A970ConClasifAux = "" ;
      n970ConClasifAux = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A970ConClasifAux", A970ConClasifAux);
      n970ConClasifAux = ((GXutil.strcmp("", A970ConClasifAux)==0) ? true : false) ;
      A510ConOrdEjec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A510ConOrdEjec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A510ConOrdEjec), 12, 0));
      A569ConFormulaExpl = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A569ConFormulaExpl", A569ConFormulaExpl);
      A762ConRecalcular = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
      A1018ConRangoCant = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1018ConRangoCant", A1018ConRangoCant);
      A954ConCondCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A954ConCondCodigo", A954ConCondCodigo);
      A1068ConMostrarPos = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1068ConMostrarPos", A1068ConMostrarPos);
      A1077ConAdelDescu = (byte)(0) ;
      n1077ConAdelDescu = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
      n1077ConAdelDescu = ((0==A1077ConAdelDescu) ? true : false) ;
      A1194ConSegunPla = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1194ConSegunPla", A1194ConSegunPla);
      A1471ConNumero = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1471ConNumero", GXutil.str( A1471ConNumero, 1, 0));
      A1648ConCodAfip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1648ConCodAfip", A1648ConCodAfip);
      A1472ConSIPAApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1472ConSIPAApo", GXutil.str( A1472ConSIPAApo, 1, 0));
      A1473ConSIPACont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1473ConSIPACont", GXutil.str( A1473ConSIPACont, 1, 0));
      A1474ConINSSJyPApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1474ConINSSJyPApo", GXutil.str( A1474ConINSSJyPApo, 1, 0));
      A1475ConINSSJyPCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1475ConINSSJyPCont", GXutil.str( A1475ConINSSJyPCont, 1, 0));
      A1476ConObraSocApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1476ConObraSocApo", GXutil.str( A1476ConObraSocApo, 1, 0));
      A1477ConObraSocCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1477ConObraSocCont", GXutil.str( A1477ConObraSocCont, 1, 0));
      A1478ConFonSolRedApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1478ConFonSolRedApo", GXutil.str( A1478ConFonSolRedApo, 1, 0));
      A1479ConFonSolRedCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1479ConFonSolRedCont", GXutil.str( A1479ConFonSolRedCont, 1, 0));
      A1480ConRenateaApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1480ConRenateaApo", GXutil.str( A1480ConRenateaApo, 1, 0));
      A1481ConRenateaCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1481ConRenateaCont", GXutil.str( A1481ConRenateaCont, 1, 0));
      A1482ConAsigFamCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1482ConAsigFamCont", GXutil.str( A1482ConAsigFamCont, 1, 0));
      A1483ConFonNacEmpCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1483ConFonNacEmpCont", GXutil.str( A1483ConFonNacEmpCont, 1, 0));
      A1484ConLeyRieTrabCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1484ConLeyRieTrabCont", GXutil.str( A1484ConLeyRieTrabCont, 1, 0));
      A1485ConRegDifApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1485ConRegDifApo", GXutil.str( A1485ConRegDifApo, 1, 0));
      A1486ConRegEspApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1486ConRegEspApo", GXutil.str( A1486ConRegEspApo, 1, 0));
      A1539ConSacDeven = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1539ConSacDeven", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1539ConSacDeven), 2, 0));
      A1620ConBaseLic = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
      A1797ConBaseLicProm = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1797ConBaseLicProm", GXutil.str( A1797ConBaseLicProm, 1, 0));
      A1621ConBaseFer = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
      A1798ConBaseFerProm = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1798ConBaseFerProm", GXutil.str( A1798ConBaseFerProm, 1, 0));
      A1622ConBaseHorExt = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
      A1799ConBaseHorExtProm = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1799ConBaseHorExtProm", GXutil.str( A1799ConBaseHorExtProm, 1, 0));
      A1800ConBasePres = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1800ConBasePres", GXutil.str( A1800ConBasePres, 1, 0));
      A1801ConBaseAnt = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1801ConBaseAnt", GXutil.str( A1801ConBaseAnt, 1, 0));
      A1827ConBaseOSDif = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1827ConBaseOSDif", GXutil.str( A1827ConBaseOSDif, 1, 0));
      A1821ConErrorSiCero = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1821ConErrorSiCero", A1821ConErrorSiCero);
      A1826ConPueNov = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1826ConPueNov", A1826ConPueNov);
      Z42ConCodYDesc = "" ;
      Z41ConDescrip = "" ;
      Z40ConOrden = 0 ;
      Z162ConVigencia = (byte)(0) ;
      Z1488ConLiqBasica = (byte)(0) ;
      Z159ConVariable = false ;
      Z146ConForEditable = false ;
      Z503ConTipoLiqAux = "" ;
      Z970ConClasifAux = "" ;
      Z510ConOrdEjec = 0 ;
      Z762ConRecalcular = false ;
      Z1018ConRangoCant = "" ;
      Z954ConCondCodigo = "" ;
      Z1068ConMostrarPos = false ;
      Z1077ConAdelDescu = (byte)(0) ;
      Z1194ConSegunPla = false ;
      Z1471ConNumero = (byte)(0) ;
      Z1648ConCodAfip = "" ;
      Z1472ConSIPAApo = (byte)(0) ;
      Z1473ConSIPACont = (byte)(0) ;
      Z1474ConINSSJyPApo = (byte)(0) ;
      Z1475ConINSSJyPCont = (byte)(0) ;
      Z1476ConObraSocApo = (byte)(0) ;
      Z1477ConObraSocCont = (byte)(0) ;
      Z1478ConFonSolRedApo = (byte)(0) ;
      Z1479ConFonSolRedCont = (byte)(0) ;
      Z1480ConRenateaApo = (byte)(0) ;
      Z1481ConRenateaCont = (byte)(0) ;
      Z1482ConAsigFamCont = (byte)(0) ;
      Z1483ConFonNacEmpCont = (byte)(0) ;
      Z1484ConLeyRieTrabCont = (byte)(0) ;
      Z1485ConRegDifApo = (byte)(0) ;
      Z1486ConRegEspApo = (byte)(0) ;
      Z1539ConSacDeven = (byte)(0) ;
      Z1620ConBaseLic = (byte)(0) ;
      Z1797ConBaseLicProm = (byte)(0) ;
      Z1621ConBaseFer = (byte)(0) ;
      Z1798ConBaseFerProm = (byte)(0) ;
      Z1622ConBaseHorExt = (byte)(0) ;
      Z1799ConBaseHorExtProm = (byte)(0) ;
      Z1800ConBasePres = (byte)(0) ;
      Z1801ConBaseAnt = (byte)(0) ;
      Z1827ConBaseOSDif = (byte)(0) ;
      Z1821ConErrorSiCero = false ;
      Z1826ConPueNov = false ;
      Z1822CliPadre = 0 ;
      Z1112AplIIGG = (short)(0) ;
      Z37TipoConCod = "" ;
      Z38SubTipoConCod1 = "" ;
      Z39SubTipoConCod2 = "" ;
      Z953ConCondicion = "" ;
      Z1644ConceptoPais = (short)(0) ;
      Z1645ConceptoConveCodigo = "" ;
      Z921ConPadre = "" ;
   }

   public void initAll577( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A26ConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      initializeNonKey577( ) ;
   }

   public void standaloneModalInsert( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251817474143", true, true);
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
      httpContext.AddJavascriptSource("conceptos_export.js", "?20251817474143", false, true);
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
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
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
      lblTextblocktipoconcod_Internalname = "TEXTBLOCKTIPOCONCOD" ;
      Combo_tipoconcod_Internalname = "COMBO_TIPOCONCOD" ;
      cmbTipoConCod.setInternalname( "TIPOCONCOD" );
      divTablesplittedtipoconcod_Internalname = "TABLESPLITTEDTIPOCONCOD" ;
      lblTextblocksubtipoconcod1_Internalname = "TEXTBLOCKSUBTIPOCONCOD1" ;
      Combo_subtipoconcod1_Internalname = "COMBO_SUBTIPOCONCOD1" ;
      edtSubTipoConCod1_Internalname = "SUBTIPOCONCOD1" ;
      divTablesplittedsubtipoconcod1_Internalname = "TABLESPLITTEDSUBTIPOCONCOD1" ;
      lblTextblocksubtipoconcod2_Internalname = "TEXTBLOCKSUBTIPOCONCOD2" ;
      Combo_subtipoconcod2_Internalname = "COMBO_SUBTIPOCONCOD2" ;
      edtSubTipoConCod2_Internalname = "SUBTIPOCONCOD2" ;
      divTablesplittedsubtipoconcod2_Internalname = "TABLESPLITTEDSUBTIPOCONCOD2" ;
      edtConTipoLiqAux_Internalname = "CONTIPOLIQAUX" ;
      edtConClasifAux_Internalname = "CONCLASIFAUX" ;
      edtConOrdEjec_Internalname = "CONORDEJEC" ;
      edtConFormulaExpl_Internalname = "CONFORMULAEXPL" ;
      chkConRecalcular.setInternalname( "CONRECALCULAR" );
      edtConRangoCant_Internalname = "CONRANGOCANT" ;
      lblTextblockconcondicion_Internalname = "TEXTBLOCKCONCONDICION" ;
      Combo_concondicion_Internalname = "COMBO_CONCONDICION" ;
      cmbConCondicion.setInternalname( "CONCONDICION" );
      divTablesplittedconcondicion_Internalname = "TABLESPLITTEDCONCONDICION" ;
      edtConCondCodigo_Internalname = "CONCONDCODIGO" ;
      chkConMostrarPos.setInternalname( "CONMOSTRARPOS" );
      cmbConAdelDescu.setInternalname( "CONADELDESCU" );
      edtAplIIGG_Internalname = "APLIIGG" ;
      chkConSegunPla.setInternalname( "CONSEGUNPLA" );
      edtConNumero_Internalname = "CONNUMERO" ;
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
      cmbConBaseFer.setInternalname( "CONBASEFER" );
      cmbConBaseHorExt.setInternalname( "CONBASEHOREXT" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      cmbavCombotipoconcod.setInternalname( "vCOMBOTIPOCONCOD" );
      divSectionattribute_tipoconcod_Internalname = "SECTIONATTRIBUTE_TIPOCONCOD" ;
      edtavCombosubtipoconcod1_Internalname = "vCOMBOSUBTIPOCONCOD1" ;
      divSectionattribute_subtipoconcod1_Internalname = "SECTIONATTRIBUTE_SUBTIPOCONCOD1" ;
      edtavCombosubtipoconcod2_Internalname = "vCOMBOSUBTIPOCONCOD2" ;
      divSectionattribute_subtipoconcod2_Internalname = "SECTIONATTRIBUTE_SUBTIPOCONCOD2" ;
      cmbavComboconcondicion.setInternalname( "vCOMBOCONCONDICION" );
      divSectionattribute_concondicion_Internalname = "SECTIONATTRIBUTE_CONCONDICION" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Conceptos_export", "") );
      Combo_subtipoconcod1_Datalistprocparametersprefix = "" ;
      Combo_subtipoconcod2_Datalistprocparametersprefix = "" ;
      cmbavComboconcondicion.setJsonclick( "" );
      cmbavComboconcondicion.setVisible( 1 );
      cmbavComboconcondicion.setEnabled( 0 );
      edtavCombosubtipoconcod2_Jsonclick = "" ;
      edtavCombosubtipoconcod2_Enabled = 0 ;
      edtavCombosubtipoconcod2_Visible = 1 ;
      edtavCombosubtipoconcod1_Jsonclick = "" ;
      edtavCombosubtipoconcod1_Enabled = 0 ;
      edtavCombosubtipoconcod1_Visible = 1 ;
      cmbavCombotipoconcod.setJsonclick( "" );
      cmbavCombotipoconcod.setVisible( 1 );
      cmbavCombotipoconcod.setEnabled( 0 );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbConBaseHorExt.setJsonclick( "" );
      cmbConBaseHorExt.setEnabled( 1 );
      cmbConBaseFer.setJsonclick( "" );
      cmbConBaseFer.setEnabled( 1 );
      cmbConBaseLic.setJsonclick( "" );
      cmbConBaseLic.setEnabled( 1 );
      edtConceptoConveCodigo_Jsonclick = "" ;
      edtConceptoConveCodigo_Enabled = 1 ;
      edtConceptoPais_Jsonclick = "" ;
      edtConceptoPais_Enabled = 1 ;
      cmbConSacDeven.setJsonclick( "" );
      cmbConSacDeven.setEnabled( 1 );
      edtConRegEspApo_Jsonclick = "" ;
      edtConRegEspApo_Enabled = 1 ;
      edtConRegDifApo_Jsonclick = "" ;
      edtConRegDifApo_Enabled = 1 ;
      edtConLeyRieTrabCont_Jsonclick = "" ;
      edtConLeyRieTrabCont_Enabled = 1 ;
      edtConFonNacEmpCont_Jsonclick = "" ;
      edtConFonNacEmpCont_Enabled = 1 ;
      edtConAsigFamCont_Jsonclick = "" ;
      edtConAsigFamCont_Enabled = 1 ;
      edtConRenateaCont_Jsonclick = "" ;
      edtConRenateaCont_Enabled = 1 ;
      edtConRenateaApo_Jsonclick = "" ;
      edtConRenateaApo_Enabled = 1 ;
      edtConFonSolRedCont_Jsonclick = "" ;
      edtConFonSolRedCont_Enabled = 1 ;
      edtConFonSolRedApo_Jsonclick = "" ;
      edtConFonSolRedApo_Enabled = 1 ;
      edtConObraSocCont_Jsonclick = "" ;
      edtConObraSocCont_Enabled = 1 ;
      edtConObraSocApo_Jsonclick = "" ;
      edtConObraSocApo_Enabled = 1 ;
      edtConINSSJyPCont_Jsonclick = "" ;
      edtConINSSJyPCont_Enabled = 1 ;
      edtConINSSJyPApo_Jsonclick = "" ;
      edtConINSSJyPApo_Enabled = 1 ;
      edtConSIPACont_Jsonclick = "" ;
      edtConSIPACont_Enabled = 1 ;
      edtConSIPAApo_Jsonclick = "" ;
      edtConSIPAApo_Enabled = 1 ;
      edtConCodAfip_Jsonclick = "" ;
      edtConCodAfip_Enabled = 1 ;
      edtConNumero_Jsonclick = "" ;
      edtConNumero_Enabled = 1 ;
      chkConSegunPla.setEnabled( 1 );
      edtAplIIGG_Jsonclick = "" ;
      edtAplIIGG_Enabled = 1 ;
      cmbConAdelDescu.setJsonclick( "" );
      cmbConAdelDescu.setEnabled( 1 );
      chkConMostrarPos.setEnabled( 1 );
      edtConCondCodigo_Jsonclick = "" ;
      edtConCondCodigo_Enabled = 1 ;
      cmbConCondicion.setJsonclick( "" );
      cmbConCondicion.setVisible( 1 );
      cmbConCondicion.setEnabled( 1 );
      Combo_concondicion_Datalistprocparametersprefix = " \"ComboName\": \"ConCondicion\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"ConCodigo\": \"\"" ;
      Combo_concondicion_Datalistproc = "Conceptos_exportLoadDVCombo" ;
      Combo_concondicion_Cls = "ExtendedCombo Attribute" ;
      Combo_concondicion_Caption = "" ;
      Combo_concondicion_Enabled = GXutil.toBoolean( -1) ;
      edtConRangoCant_Enabled = 1 ;
      chkConRecalcular.setEnabled( 1 );
      edtConFormulaExpl_Enabled = 1 ;
      edtConOrdEjec_Jsonclick = "" ;
      edtConOrdEjec_Enabled = 1 ;
      edtConClasifAux_Jsonclick = "" ;
      edtConClasifAux_Enabled = 1 ;
      edtConTipoLiqAux_Jsonclick = "" ;
      edtConTipoLiqAux_Enabled = 1 ;
      edtSubTipoConCod2_Jsonclick = "" ;
      edtSubTipoConCod2_Enabled = 1 ;
      edtSubTipoConCod2_Visible = 1 ;
      Combo_subtipoconcod2_Datalistproc = "Conceptos_exportLoadDVCombo" ;
      Combo_subtipoconcod2_Cls = "ExtendedCombo Attribute" ;
      Combo_subtipoconcod2_Caption = "" ;
      Combo_subtipoconcod2_Enabled = GXutil.toBoolean( -1) ;
      edtSubTipoConCod1_Jsonclick = "" ;
      edtSubTipoConCod1_Enabled = 1 ;
      edtSubTipoConCod1_Visible = 1 ;
      Combo_subtipoconcod1_Datalistproc = "Conceptos_exportLoadDVCombo" ;
      Combo_subtipoconcod1_Cls = "ExtendedCombo Attribute" ;
      Combo_subtipoconcod1_Caption = "" ;
      Combo_subtipoconcod1_Enabled = GXutil.toBoolean( -1) ;
      cmbTipoConCod.setJsonclick( "" );
      cmbTipoConCod.setVisible( 1 );
      cmbTipoConCod.setEnabled( 1 );
      Combo_tipoconcod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_tipoconcod_Datalistprocparametersprefix = " \"ComboName\": \"TipoConCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"ConCodigo\": \"\"" ;
      Combo_tipoconcod_Datalistproc = "Conceptos_exportLoadDVCombo" ;
      Combo_tipoconcod_Cls = "ExtendedCombo Attribute" ;
      Combo_tipoconcod_Caption = "" ;
      Combo_tipoconcod_Enabled = GXutil.toBoolean( -1) ;
      chkConForEditable.setEnabled( 1 );
      chkConVariable.setEnabled( 1 );
      edtConObservacion_Enabled = 1 ;
      edtConFormula_Enabled = 1 ;
      edtConLiqBasica_Jsonclick = "" ;
      edtConLiqBasica_Enabled = 1 ;
      cmbConVigencia.setJsonclick( "" );
      cmbConVigencia.setEnabled( 1 );
      edtConOrden_Jsonclick = "" ;
      edtConOrden_Enabled = 1 ;
      edtConDescrip_Enabled = 1 ;
      edtConCodigo_Jsonclick = "" ;
      edtConCodigo_Enabled = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
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
      divLayoutmaintable_Class = "Table" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void init_web_controls( )
   {
      cmbConVigencia.setName( "CONVIGENCIA" );
      cmbConVigencia.setWebtags( "" );
      cmbConVigencia.addItem("0", httpContext.getMessage( "Automática", ""), (short)(0));
      cmbConVigencia.addItem("1", httpContext.getMessage( "Por Novedad", ""), (short)(0));
      if ( cmbConVigencia.getItemCount() > 0 )
      {
         A162ConVigencia = (byte)(GXutil.lval( cmbConVigencia.getValidValue(GXutil.trim( GXutil.str( A162ConVigencia, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A162ConVigencia", GXutil.str( A162ConVigencia, 1, 0));
      }
      chkConVariable.setName( "CONVARIABLE" );
      chkConVariable.setWebtags( "" );
      chkConVariable.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConVariable.getInternalname(), "TitleCaption", chkConVariable.getCaption(), true);
      chkConVariable.setCheckedValue( "false" );
      A159ConVariable = GXutil.strtobool( GXutil.booltostr( A159ConVariable)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A159ConVariable", A159ConVariable);
      chkConForEditable.setName( "CONFOREDITABLE" );
      chkConForEditable.setWebtags( "" );
      chkConForEditable.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConForEditable.getInternalname(), "TitleCaption", chkConForEditable.getCaption(), true);
      chkConForEditable.setCheckedValue( "false" );
      A146ConForEditable = GXutil.strtobool( GXutil.booltostr( A146ConForEditable)) ;
      n146ConForEditable = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A146ConForEditable", A146ConForEditable);
      cmbTipoConCod.setName( "TIPOCONCOD" );
      cmbTipoConCod.setWebtags( "" );
      cmbTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbTipoConCod.getItemCount() > 0 )
      {
         A37TipoConCod = cmbTipoConCod.getValidValue(A37TipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "A37TipoConCod", A37TipoConCod);
      }
      chkConRecalcular.setName( "CONRECALCULAR" );
      chkConRecalcular.setWebtags( "" );
      chkConRecalcular.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConRecalcular.getInternalname(), "TitleCaption", chkConRecalcular.getCaption(), true);
      chkConRecalcular.setCheckedValue( "false" );
      A762ConRecalcular = GXutil.strtobool( GXutil.booltostr( A762ConRecalcular)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A762ConRecalcular", A762ConRecalcular);
      cmbConCondicion.setName( "CONCONDICION" );
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
         httpContext.ajax_rsp_assign_attri("", false, "A953ConCondicion", A953ConCondicion);
      }
      chkConMostrarPos.setName( "CONMOSTRARPOS" );
      chkConMostrarPos.setWebtags( "" );
      chkConMostrarPos.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConMostrarPos.getInternalname(), "TitleCaption", chkConMostrarPos.getCaption(), true);
      chkConMostrarPos.setCheckedValue( "false" );
      A1068ConMostrarPos = GXutil.strtobool( GXutil.booltostr( A1068ConMostrarPos)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1068ConMostrarPos", A1068ConMostrarPos);
      cmbConAdelDescu.setName( "CONADELDESCU" );
      cmbConAdelDescu.setWebtags( "" );
      cmbConAdelDescu.addItem(GXutil.trim( GXutil.str( 0, 1, 0)), httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      cmbConAdelDescu.addItem("1", httpContext.getMessage( "Adelanto de mes próximo", ""), (short)(0));
      cmbConAdelDescu.addItem("2", httpContext.getMessage( "Descuento", ""), (short)(0));
      if ( cmbConAdelDescu.getItemCount() > 0 )
      {
         A1077ConAdelDescu = (byte)(GXutil.lval( cmbConAdelDescu.getValidValue(GXutil.trim( GXutil.str( A1077ConAdelDescu, 1, 0))))) ;
         n1077ConAdelDescu = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1077ConAdelDescu", GXutil.str( A1077ConAdelDescu, 1, 0));
      }
      chkConSegunPla.setName( "CONSEGUNPLA" );
      chkConSegunPla.setWebtags( "" );
      chkConSegunPla.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConSegunPla.getInternalname(), "TitleCaption", chkConSegunPla.getCaption(), true);
      chkConSegunPla.setCheckedValue( "false" );
      A1194ConSegunPla = GXutil.strtobool( GXutil.booltostr( A1194ConSegunPla)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1194ConSegunPla", A1194ConSegunPla);
      cmbConSacDeven.setName( "CONSACDEVEN" );
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
         httpContext.ajax_rsp_assign_attri("", false, "A1539ConSacDeven", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1539ConSacDeven), 2, 0));
      }
      cmbConBaseLic.setName( "CONBASELIC" );
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
         httpContext.ajax_rsp_assign_attri("", false, "A1620ConBaseLic", GXutil.str( A1620ConBaseLic, 1, 0));
      }
      cmbConBaseFer.setName( "CONBASEFER" );
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
         httpContext.ajax_rsp_assign_attri("", false, "A1621ConBaseFer", GXutil.str( A1621ConBaseFer, 1, 0));
      }
      cmbConBaseHorExt.setName( "CONBASEHOREXT" );
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
         httpContext.ajax_rsp_assign_attri("", false, "A1622ConBaseHorExt", GXutil.str( A1622ConBaseHorExt, 1, 0));
      }
      cmbavCombotipoconcod.setName( "vCOMBOTIPOCONCOD" );
      cmbavCombotipoconcod.setWebtags( "" );
      cmbavCombotipoconcod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbavCombotipoconcod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbavCombotipoconcod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbavCombotipoconcod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbavCombotipoconcod.getItemCount() > 0 )
      {
         AV26ComboTipoConCod = cmbavCombotipoconcod.getValidValue(AV26ComboTipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ComboTipoConCod", AV26ComboTipoConCod);
      }
      cmbavComboconcondicion.setName( "vCOMBOCONCONDICION" );
      cmbavComboconcondicion.setWebtags( "" );
      cmbavComboconcondicion.addItem("A0", httpContext.getMessage( "Siempre", ""), (short)(0));
      cmbavComboconcondicion.addItem("A1", httpContext.getMessage( "Se ingresó por novedad el concepto de código relacionado a la condición", ""), (short)(0));
      cmbavComboconcondicion.addItem("A3", httpContext.getMessage( "Trabajador no es Jubilado y aplica a liquidación de aportes", ""), (short)(0));
      cmbavComboconcondicion.addItem("A4", httpContext.getMessage( "Resultado de la suma de conceptos agregados en liquidación anterior con la misma clasificación sea mayor a cerO, y que el concepto de la liquidación anterior tenga asignado tipo de liquidación igual al código relacionado a la condición de este concepto", ""), (short)(0));
      cmbavComboconcondicion.addItem("A5", httpContext.getMessage( "Es alcanzado por ganancias y calcula adelanto de retención (parámetro)", ""), (short)(0));
      cmbavComboconcondicion.addItem("A8", httpContext.getMessage( "Legajo tiene saldo distinto de cero en DDJJ F1357 del año anterior", ""), (short)(0));
      cmbavComboconcondicion.addItem("A9", httpContext.getMessage( "Tiene familiares adherentes a la obra social", ""), (short)(0));
      cmbavComboconcondicion.addItem("A10", httpContext.getMessage( "Tiene Sindicato", ""), (short)(0));
      cmbavComboconcondicion.addItem("A11", httpContext.getMessage( "Tiene jornada parcial", ""), (short)(0));
      cmbavComboconcondicion.addItem("A12", httpContext.getMessage( "Obra social tiene aporte adicional", ""), (short)(0));
      cmbavComboconcondicion.addItem("A13", httpContext.getMessage( "Empleador es agente de retención", ""), (short)(0));
      cmbavComboconcondicion.addItem("A14", httpContext.getMessage( "El empleador es agente de retención y el empleado es alcanzado por ganancias", ""), (short)(0));
      cmbavComboconcondicion.addItem("B1", httpContext.getMessage( "Legajo tiene cargado licencia igual al código  relacionado a la condición", ""), (short)(0));
      cmbavComboconcondicion.addItem("B2", httpContext.getMessage( "Legajo tiene cargado SIRADIG de igual código  relacionado a la condición", ""), (short)(0));
      cmbavComboconcondicion.addItem("B3", httpContext.getMessage( "Tiene obligación activa de igual al código relacionado a la condición", ""), (short)(0));
      cmbavComboconcondicion.addItem("B4", httpContext.getMessage( "Hay licencias o feriados con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbavComboconcondicion.addItem("B5", httpContext.getMessage( "Hay feriado no trabajado, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbavComboconcondicion.addItem("B6", httpContext.getMessage( "Hay día no laborable em periodo, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbavComboconcondicion.addItem("B7", httpContext.getMessage( "El legajo es empleado mensual y hay licencia sin goce de sueldo", ""), (short)(0));
      cmbavComboconcondicion.addItem("B9", httpContext.getMessage( "Es egreso y no maneja fondo de cese laboral", ""), (short)(0));
      cmbavComboconcondicion.addItem("B10", httpContext.getMessage( "Tipo de liquidación, mes de liquidación, y marca de SAC en alta de liquidación son compatibles con la liquidación del SAC.", ""), (short)(0));
      cmbavComboconcondicion.addItem("B11", httpContext.getMessage( "Liquida sac o alcanza ganancias", ""), (short)(0));
      cmbavComboconcondicion.addItem("B12", httpContext.getMessage( "Empresa o convenio liquidan antiguedad", ""), (short)(0));
      cmbavComboconcondicion.addItem("B13", httpContext.getMessage( "Empresa o convenio liquidan presentismo", ""), (short)(0));
      cmbavComboconcondicion.addItem("B14", httpContext.getMessage( "Legajo tiene cargado comprobante para reintegro igual al código relacionado a la condición", ""), (short)(0));
      cmbavComboconcondicion.addItem("B15", httpContext.getMessage( "Legajo tiene cargado hijo o hija con asignación de servicio de guardería", ""), (short)(0));
      cmbavComboconcondicion.addItem("N01", httpContext.getMessage( "Nunca  (Calcular siempre en segundo plano luego de generar el recibo)", ""), (short)(0));
      cmbavComboconcondicion.addItem("B16", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\", de frecuencia mensual y el concepto no fué previamente liquidado en el mismo periodo", ""), (short)(0));
      cmbavComboconcondicion.addItem("B19", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado vacaciones y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbavComboconcondicion.addItem("B20", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado días de licencia (distinta a vacaciones) y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbavComboconcondicion.addItem("B21", httpContext.getMessage( "Legajo es empleado mensual, hay feriado no trabajado y la empresa está configurada para exponer los feriados y no proratear el sueldo", ""), (short)(0));
      cmbavComboconcondicion.addItem("B22", httpContext.getMessage( "Legajo es empleado mensual, hay día no laborable no trabajado y la empresa está configurada para exponer los feriados y no prorratear el sueldo", ""), (short)(0));
      cmbavComboconcondicion.addItem("B23", httpContext.getMessage( "Legajo tiene asignado tìtulo igual al código relacionado a la condición", ""), (short)(0));
      cmbavComboconcondicion.addItem("B24", httpContext.getMessage( "Parametro para desglosar adicional está activado, legajo está en convenio y su categoría tiene adicional por zona desfavorable", ""), (short)(0));
      cmbavComboconcondicion.addItem("VP", httpContext.getMessage( "Hay vacaciones con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbavComboconcondicion.addItem("AI", httpContext.getMessage( "Legajo es de clase mensual y tiene cargadas ausencias injustificadas", ""), (short)(0));
      cmbavComboconcondicion.addItem("R1", httpContext.getMessage( "Forma de pago es distinta a transferencia o parámetro está configurado para liquidar siempre redondeo", ""), (short)(0));
      cmbavComboconcondicion.addItem("MI", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\" de frecuencia mensual, empresa está configurada para no prorratear sueldo y fecha de ingreso es mayor al primero o fecha de egreso menor al último día del mes", ""), (short)(0));
      cmbavComboconcondicion.addItem("H1", httpContext.getMessage( "Si liquidación es compatible con SAC liquidar como concepto principal, y si no liquidarlo como concepto auxiliar en segundo plano", ""), (short)(0));
      cmbavComboconcondicion.addItem("LA", httpContext.getMessage( "Legajo aplica a liquidación de aportes", ""), (short)(0));
      cmbavComboconcondicion.addItem("GU", httpContext.getMessage( "Legajo tiene configurado grossing up", ""), (short)(0));
      if ( cmbavComboconcondicion.getItemCount() > 0 )
      {
         AV35ComboConCondicion = cmbavComboconcondicion.getValidValue(AV35ComboConCondicion) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35ComboConCondicion", AV35ComboConCondicion);
      }
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Tipoconcod( )
   {
      A37TipoConCod = cmbTipoConCod.getValue() ;
      /* Using cursor T005755 */
      pr_default.execute(53, new Object[] {A37TipoConCod});
      if ( (pr_default.getStatus(53) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo De Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbTipoConCod.getInternalname() ;
      }
      pr_default.close(53);
      if ( ! ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "DES_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "TIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbTipoConCod.getInternalname() ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Subtipoconcod1( )
   {
      A37TipoConCod = cmbTipoConCod.getValue() ;
      n38SubTipoConCod1 = false ;
      /* Using cursor T005756 */
      pr_default.execute(54, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1});
      if ( (pr_default.getStatus(54) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo1", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD1");
            AnyError = (short)(1) ;
            GX_FocusControl = cmbTipoConCod.getInternalname() ;
         }
      }
      pr_default.close(54);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Subtipoconcod2( )
   {
      A37TipoConCod = cmbTipoConCod.getValue() ;
      n38SubTipoConCod1 = false ;
      n39SubTipoConCod2 = false ;
      /* Using cursor T005757 */
      pr_default.execute(55, new Object[] {A37TipoConCod, Boolean.valueOf(n38SubTipoConCod1), A38SubTipoConCod1, Boolean.valueOf(n39SubTipoConCod2), A39SubTipoConCod2});
      if ( (pr_default.getStatus(55) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A37TipoConCod)==0) || (GXutil.strcmp("", A38SubTipoConCod1)==0) || (GXutil.strcmp("", A39SubTipoConCod2)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Subtipo2", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SUBTIPOCONCOD2");
            AnyError = (short)(1) ;
            GX_FocusControl = cmbTipoConCod.getInternalname() ;
         }
      }
      pr_default.close(55);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Concondicion( )
   {
      n953ConCondicion = false ;
      A953ConCondicion = cmbConCondicion.getValue() ;
      n953ConCondicion = false ;
      /* Using cursor T005758 */
      pr_default.execute(56, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion});
      if ( (pr_default.getStatus(56) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A953ConCondicion)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Condiciones_concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCONDICION");
            AnyError = (short)(1) ;
            GX_FocusControl = cmbConCondicion.getInternalname() ;
         }
      }
      pr_default.close(56);
      if ( ! ( ( GXutil.strcmp(A953ConCondicion, "A0") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A3") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A4") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A5") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A8") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A9") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A10") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A11") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A12") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A13") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "A14") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B2") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B3") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B4") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B5") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B6") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B7") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B9") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B10") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B11") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B12") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B13") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B14") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B15") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "N01") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B16") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B19") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B20") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B21") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B22") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B23") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "B24") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "VP") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "AI") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "R1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "MI") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "H1") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "LA") == 0 ) || ( GXutil.strcmp(A953ConCondicion, "GU") == 0 ) || (GXutil.strcmp("", A953ConCondicion)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Condición para liquidación", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONCONDICION");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConCondicion.getInternalname() ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Apliigg( )
   {
      n1112AplIIGG = false ;
      /* Using cursor T005759 */
      pr_default.execute(57, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(57) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1112AplIIGG) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo aplicacion ganancias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGG");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(57);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Conceptoconvecodigo( )
   {
      n1644ConceptoPais = false ;
      n1645ConceptoConveCodigo = false ;
      /* Using cursor T005760 */
      pr_default.execute(58, new Object[] {Boolean.valueOf(n1644ConceptoPais), Short.valueOf(A1644ConceptoPais), Boolean.valueOf(n1645ConceptoConveCodigo), A1645ConceptoConveCodigo});
      if ( (pr_default.getStatus(58) == 101) )
      {
         if ( ! ( (0==A1644ConceptoPais) || (GXutil.strcmp("", A1645ConceptoConveCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto_Convenio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCEPTOCONVECODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtConceptoPais_Internalname ;
         }
      }
      pr_default.close(58);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8ConCodigo',fld:'vCONCODIGO',pic:'',hsh:true},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8ConCodigo',fld:'vCONCODIGO',pic:'',hsh:true},{av:'A1797ConBaseLicProm',fld:'CONBASELICPROM',pic:'9'},{av:'A1798ConBaseFerProm',fld:'CONBASEFERPROM',pic:'9'},{av:'A1799ConBaseHorExtProm',fld:'CONBASEHOREXTPROM',pic:'9'},{av:'A1800ConBasePres',fld:'CONBASEPRES',pic:'9'},{av:'A1801ConBaseAnt',fld:'CONBASEANT',pic:'9'},{av:'A1827ConBaseOSDif',fld:'CONBASEOSDIF',pic:'9'},{av:'A1821ConErrorSiCero',fld:'CONERRORSICERO',pic:''},{av:'A1826ConPueNov',fld:'CONPUENOV',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e12572',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_CONCODIGO","{handler:'valid_Concodigo',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_CONCODIGO",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_CONDESCRIP","{handler:'valid_Condescrip',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_CONDESCRIP",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_CONVIGENCIA","{handler:'valid_Convigencia',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_CONVIGENCIA",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_TIPOCONCOD","{handler:'valid_Tipoconcod',iparms:[{av:'cmbTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_TIPOCONCOD",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_SUBTIPOCONCOD1","{handler:'valid_Subtipoconcod1',iparms:[{av:'cmbTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_SUBTIPOCONCOD1",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_SUBTIPOCONCOD2","{handler:'valid_Subtipoconcod2',iparms:[{av:'cmbTipoConCod'},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'A39SubTipoConCod2',fld:'SUBTIPOCONCOD2',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_SUBTIPOCONCOD2",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_CONCONDICION","{handler:'valid_Concondicion',iparms:[{av:'cmbConCondicion'},{av:'A953ConCondicion',fld:'CONCONDICION',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_CONCONDICION",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_CONADELDESCU","{handler:'valid_Conadeldescu',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_CONADELDESCU",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_APLIIGG","{handler:'valid_Apliigg',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1112AplIIGG',fld:'APLIIGG',pic:'ZZZ9'},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_APLIIGG",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_CONSACDEVEN","{handler:'valid_Consacdeven',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_CONSACDEVEN",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_CONCEPTOPAIS","{handler:'valid_Conceptopais',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_CONCEPTOPAIS",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_CONCEPTOCONVECODIGO","{handler:'valid_Conceptoconvecodigo',iparms:[{av:'A1644ConceptoPais',fld:'CONCEPTOPAIS',pic:'ZZZ9'},{av:'A1645ConceptoConveCodigo',fld:'CONCEPTOCONVECODIGO',pic:''},{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_CONCEPTOCONVECODIGO",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_CONBASELIC","{handler:'valid_Conbaselic',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_CONBASELIC",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_CONBASEFER","{handler:'valid_Conbasefer',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_CONBASEFER",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALID_CONBASEHOREXT","{handler:'valid_Conbasehorext',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALID_CONBASEHOREXT",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALIDV_COMBOTIPOCONCOD","{handler:'validv_Combotipoconcod',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALIDV_COMBOTIPOCONCOD",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALIDV_COMBOSUBTIPOCONCOD1","{handler:'validv_Combosubtipoconcod1',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALIDV_COMBOSUBTIPOCONCOD1",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALIDV_COMBOSUBTIPOCONCOD2","{handler:'validv_Combosubtipoconcod2',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALIDV_COMBOSUBTIPOCONCOD2",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCONCONDICION","{handler:'validv_Comboconcondicion',iparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]");
      setEventMetadata("VALIDV_COMBOCONCONDICION",",oparms:[{av:'A159ConVariable',fld:'CONVARIABLE',pic:''},{av:'A146ConForEditable',fld:'CONFOREDITABLE',pic:''},{av:'A762ConRecalcular',fld:'CONRECALCULAR',pic:''},{av:'A1068ConMostrarPos',fld:'CONMOSTRARPOS',pic:''},{av:'A1194ConSegunPla',fld:'CONSEGUNPLA',pic:''}]}");
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
      pr_default.close(57);
      pr_default.close(54);
      pr_default.close(55);
      pr_default.close(56);
      pr_default.close(53);
      pr_default.close(58);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8ConCodigo = "" ;
      Z26ConCodigo = "" ;
      Z42ConCodYDesc = "" ;
      Z41ConDescrip = "" ;
      Z503ConTipoLiqAux = "" ;
      Z970ConClasifAux = "" ;
      Z1018ConRangoCant = "" ;
      Z954ConCondCodigo = "" ;
      Z1648ConCodAfip = "" ;
      Z37TipoConCod = "" ;
      Z38SubTipoConCod1 = "" ;
      Z39SubTipoConCod2 = "" ;
      Z953ConCondicion = "" ;
      Z1645ConceptoConveCodigo = "" ;
      Z921ConPadre = "" ;
      N37TipoConCod = "" ;
      N38SubTipoConCod1 = "" ;
      N39SubTipoConCod2 = "" ;
      N953ConCondicion = "" ;
      N1645ConceptoConveCodigo = "" ;
      N921ConPadre = "" ;
      Combo_concondicion_Selectedvalue_get = "" ;
      Combo_subtipoconcod2_Selectedvalue_get = "" ;
      Combo_subtipoconcod1_Selectedvalue_get = "" ;
      Combo_tipoconcod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      A953ConCondicion = "" ;
      A1645ConceptoConveCodigo = "" ;
      A921ConPadre = "" ;
      Gx_mode = "" ;
      AV8ConCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      AV26ComboTipoConCod = "" ;
      AV35ComboConCondicion = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A26ConCodigo = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A41ConDescrip = "" ;
      A148ConFormula = "" ;
      A153ConObservacion = "" ;
      lblTextblocktipoconcod_Jsonclick = "" ;
      ucCombo_tipoconcod = new com.genexus.webpanels.GXUserControl();
      AV22DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV21TipoConCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblocksubtipoconcod1_Jsonclick = "" ;
      ucCombo_subtipoconcod1 = new com.genexus.webpanels.GXUserControl();
      AV27SubTipoConCod1_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblocksubtipoconcod2_Jsonclick = "" ;
      ucCombo_subtipoconcod2 = new com.genexus.webpanels.GXUserControl();
      AV30SubTipoConCod2_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A503ConTipoLiqAux = "" ;
      A970ConClasifAux = "" ;
      A569ConFormulaExpl = "" ;
      A1018ConRangoCant = "" ;
      lblTextblockconcondicion_Jsonclick = "" ;
      ucCombo_concondicion = new com.genexus.webpanels.GXUserControl();
      AV34ConCondicion_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A954ConCondCodigo = "" ;
      A1648ConCodAfip = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV28ComboSubTipoConCod1 = "" ;
      AV31ComboSubTipoConCod2 = "" ;
      A42ConCodYDesc = "" ;
      AV29Cond_TipoConCod = "" ;
      AV32Cond_SubTipoConCod1 = "" ;
      AV14Insert_TipoConCod = "" ;
      AV15Insert_SubTipoConCod1 = "" ;
      AV16Insert_SubTipoConCod2 = "" ;
      AV33Insert_ConCondicion = "" ;
      AV19Insert_ConceptoConveCodigo = "" ;
      AV37Insert_ConPadre = "" ;
      AV38Pgmname = "" ;
      Combo_tipoconcod_Objectcall = "" ;
      Combo_tipoconcod_Class = "" ;
      Combo_tipoconcod_Icontype = "" ;
      Combo_tipoconcod_Icon = "" ;
      Combo_tipoconcod_Tooltip = "" ;
      Combo_tipoconcod_Selectedvalue_set = "" ;
      Combo_tipoconcod_Selectedtext_set = "" ;
      Combo_tipoconcod_Selectedtext_get = "" ;
      Combo_tipoconcod_Gamoauthtoken = "" ;
      Combo_tipoconcod_Ddointernalname = "" ;
      Combo_tipoconcod_Titlecontrolalign = "" ;
      Combo_tipoconcod_Dropdownoptionstype = "" ;
      Combo_tipoconcod_Titlecontrolidtoreplace = "" ;
      Combo_tipoconcod_Datalisttype = "" ;
      Combo_tipoconcod_Datalistfixedvalues = "" ;
      Combo_tipoconcod_Remoteservicesparameters = "" ;
      Combo_tipoconcod_Htmltemplate = "" ;
      Combo_tipoconcod_Multiplevaluestype = "" ;
      Combo_tipoconcod_Loadingdata = "" ;
      Combo_tipoconcod_Noresultsfound = "" ;
      Combo_tipoconcod_Emptyitemtext = "" ;
      Combo_tipoconcod_Onlyselectedvalues = "" ;
      Combo_tipoconcod_Selectalltext = "" ;
      Combo_tipoconcod_Multiplevaluesseparator = "" ;
      Combo_tipoconcod_Addnewoptiontext = "" ;
      Combo_subtipoconcod1_Objectcall = "" ;
      Combo_subtipoconcod1_Class = "" ;
      Combo_subtipoconcod1_Icontype = "" ;
      Combo_subtipoconcod1_Icon = "" ;
      Combo_subtipoconcod1_Tooltip = "" ;
      Combo_subtipoconcod1_Selectedvalue_set = "" ;
      Combo_subtipoconcod1_Selectedtext_set = "" ;
      Combo_subtipoconcod1_Selectedtext_get = "" ;
      Combo_subtipoconcod1_Gamoauthtoken = "" ;
      Combo_subtipoconcod1_Ddointernalname = "" ;
      Combo_subtipoconcod1_Titlecontrolalign = "" ;
      Combo_subtipoconcod1_Dropdownoptionstype = "" ;
      Combo_subtipoconcod1_Titlecontrolidtoreplace = "" ;
      Combo_subtipoconcod1_Datalisttype = "" ;
      Combo_subtipoconcod1_Datalistfixedvalues = "" ;
      Combo_subtipoconcod1_Remoteservicesparameters = "" ;
      Combo_subtipoconcod1_Htmltemplate = "" ;
      Combo_subtipoconcod1_Multiplevaluestype = "" ;
      Combo_subtipoconcod1_Loadingdata = "" ;
      Combo_subtipoconcod1_Noresultsfound = "" ;
      Combo_subtipoconcod1_Emptyitemtext = "" ;
      Combo_subtipoconcod1_Onlyselectedvalues = "" ;
      Combo_subtipoconcod1_Selectalltext = "" ;
      Combo_subtipoconcod1_Multiplevaluesseparator = "" ;
      Combo_subtipoconcod1_Addnewoptiontext = "" ;
      Combo_subtipoconcod2_Objectcall = "" ;
      Combo_subtipoconcod2_Class = "" ;
      Combo_subtipoconcod2_Icontype = "" ;
      Combo_subtipoconcod2_Icon = "" ;
      Combo_subtipoconcod2_Tooltip = "" ;
      Combo_subtipoconcod2_Selectedvalue_set = "" ;
      Combo_subtipoconcod2_Selectedtext_set = "" ;
      Combo_subtipoconcod2_Selectedtext_get = "" ;
      Combo_subtipoconcod2_Gamoauthtoken = "" ;
      Combo_subtipoconcod2_Ddointernalname = "" ;
      Combo_subtipoconcod2_Titlecontrolalign = "" ;
      Combo_subtipoconcod2_Dropdownoptionstype = "" ;
      Combo_subtipoconcod2_Titlecontrolidtoreplace = "" ;
      Combo_subtipoconcod2_Datalisttype = "" ;
      Combo_subtipoconcod2_Datalistfixedvalues = "" ;
      Combo_subtipoconcod2_Remoteservicesparameters = "" ;
      Combo_subtipoconcod2_Htmltemplate = "" ;
      Combo_subtipoconcod2_Multiplevaluestype = "" ;
      Combo_subtipoconcod2_Loadingdata = "" ;
      Combo_subtipoconcod2_Noresultsfound = "" ;
      Combo_subtipoconcod2_Emptyitemtext = "" ;
      Combo_subtipoconcod2_Onlyselectedvalues = "" ;
      Combo_subtipoconcod2_Selectalltext = "" ;
      Combo_subtipoconcod2_Multiplevaluesseparator = "" ;
      Combo_subtipoconcod2_Addnewoptiontext = "" ;
      Combo_concondicion_Objectcall = "" ;
      Combo_concondicion_Class = "" ;
      Combo_concondicion_Icontype = "" ;
      Combo_concondicion_Icon = "" ;
      Combo_concondicion_Tooltip = "" ;
      Combo_concondicion_Selectedvalue_set = "" ;
      Combo_concondicion_Selectedtext_set = "" ;
      Combo_concondicion_Selectedtext_get = "" ;
      Combo_concondicion_Gamoauthtoken = "" ;
      Combo_concondicion_Ddointernalname = "" ;
      Combo_concondicion_Titlecontrolalign = "" ;
      Combo_concondicion_Dropdownoptionstype = "" ;
      Combo_concondicion_Titlecontrolidtoreplace = "" ;
      Combo_concondicion_Datalisttype = "" ;
      Combo_concondicion_Datalistfixedvalues = "" ;
      Combo_concondicion_Remoteservicesparameters = "" ;
      Combo_concondicion_Htmltemplate = "" ;
      Combo_concondicion_Multiplevaluestype = "" ;
      Combo_concondicion_Loadingdata = "" ;
      Combo_concondicion_Noresultsfound = "" ;
      Combo_concondicion_Emptyitemtext = "" ;
      Combo_concondicion_Onlyselectedvalues = "" ;
      Combo_concondicion_Selectalltext = "" ;
      Combo_concondicion_Multiplevaluesseparator = "" ;
      Combo_concondicion_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode7 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      AV20TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV25Combo_DataJson = "" ;
      AV23ComboSelectedValue = "" ;
      AV24ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z148ConFormula = "" ;
      Z153ConObservacion = "" ;
      Z569ConFormulaExpl = "" ;
      T005712_A42ConCodYDesc = new String[] {""} ;
      T005712_n42ConCodYDesc = new boolean[] {false} ;
      T005712_A26ConCodigo = new String[] {""} ;
      T005712_A41ConDescrip = new String[] {""} ;
      T005712_A40ConOrden = new int[1] ;
      T005712_A162ConVigencia = new byte[1] ;
      T005712_A1488ConLiqBasica = new byte[1] ;
      T005712_A148ConFormula = new String[] {""} ;
      T005712_n148ConFormula = new boolean[] {false} ;
      T005712_A153ConObservacion = new String[] {""} ;
      T005712_A159ConVariable = new boolean[] {false} ;
      T005712_A146ConForEditable = new boolean[] {false} ;
      T005712_n146ConForEditable = new boolean[] {false} ;
      T005712_A503ConTipoLiqAux = new String[] {""} ;
      T005712_n503ConTipoLiqAux = new boolean[] {false} ;
      T005712_A970ConClasifAux = new String[] {""} ;
      T005712_n970ConClasifAux = new boolean[] {false} ;
      T005712_A510ConOrdEjec = new long[1] ;
      T005712_A569ConFormulaExpl = new String[] {""} ;
      T005712_A762ConRecalcular = new boolean[] {false} ;
      T005712_A1018ConRangoCant = new String[] {""} ;
      T005712_A954ConCondCodigo = new String[] {""} ;
      T005712_A1068ConMostrarPos = new boolean[] {false} ;
      T005712_A1077ConAdelDescu = new byte[1] ;
      T005712_n1077ConAdelDescu = new boolean[] {false} ;
      T005712_A1194ConSegunPla = new boolean[] {false} ;
      T005712_A1471ConNumero = new byte[1] ;
      T005712_A1648ConCodAfip = new String[] {""} ;
      T005712_A1472ConSIPAApo = new byte[1] ;
      T005712_A1473ConSIPACont = new byte[1] ;
      T005712_A1474ConINSSJyPApo = new byte[1] ;
      T005712_A1475ConINSSJyPCont = new byte[1] ;
      T005712_A1476ConObraSocApo = new byte[1] ;
      T005712_A1477ConObraSocCont = new byte[1] ;
      T005712_A1478ConFonSolRedApo = new byte[1] ;
      T005712_A1479ConFonSolRedCont = new byte[1] ;
      T005712_A1480ConRenateaApo = new byte[1] ;
      T005712_A1481ConRenateaCont = new byte[1] ;
      T005712_A1482ConAsigFamCont = new byte[1] ;
      T005712_A1483ConFonNacEmpCont = new byte[1] ;
      T005712_A1484ConLeyRieTrabCont = new byte[1] ;
      T005712_A1485ConRegDifApo = new byte[1] ;
      T005712_A1486ConRegEspApo = new byte[1] ;
      T005712_A1539ConSacDeven = new byte[1] ;
      T005712_A1620ConBaseLic = new byte[1] ;
      T005712_A1797ConBaseLicProm = new byte[1] ;
      T005712_A1621ConBaseFer = new byte[1] ;
      T005712_A1798ConBaseFerProm = new byte[1] ;
      T005712_A1622ConBaseHorExt = new byte[1] ;
      T005712_A1799ConBaseHorExtProm = new byte[1] ;
      T005712_A1800ConBasePres = new byte[1] ;
      T005712_A1801ConBaseAnt = new byte[1] ;
      T005712_A1827ConBaseOSDif = new byte[1] ;
      T005712_A1821ConErrorSiCero = new boolean[] {false} ;
      T005712_A1826ConPueNov = new boolean[] {false} ;
      T005712_A1822CliPadre = new int[1] ;
      T005712_n1822CliPadre = new boolean[] {false} ;
      T005712_A3CliCod = new int[1] ;
      T005712_A1112AplIIGG = new short[1] ;
      T005712_n1112AplIIGG = new boolean[] {false} ;
      T005712_A37TipoConCod = new String[] {""} ;
      T005712_A38SubTipoConCod1 = new String[] {""} ;
      T005712_n38SubTipoConCod1 = new boolean[] {false} ;
      T005712_A39SubTipoConCod2 = new String[] {""} ;
      T005712_n39SubTipoConCod2 = new boolean[] {false} ;
      T005712_A953ConCondicion = new String[] {""} ;
      T005712_n953ConCondicion = new boolean[] {false} ;
      T005712_A1644ConceptoPais = new short[1] ;
      T005712_n1644ConceptoPais = new boolean[] {false} ;
      T005712_A1645ConceptoConveCodigo = new String[] {""} ;
      T005712_n1645ConceptoConveCodigo = new boolean[] {false} ;
      T005712_A921ConPadre = new String[] {""} ;
      T005712_n921ConPadre = new boolean[] {false} ;
      T00574_A3CliCod = new int[1] ;
      T00576_A37TipoConCod = new String[] {""} ;
      T00577_A37TipoConCod = new String[] {""} ;
      T00578_A37TipoConCod = new String[] {""} ;
      T00579_A953ConCondicion = new String[] {""} ;
      T00579_n953ConCondicion = new boolean[] {false} ;
      T00575_A3CliCod = new int[1] ;
      T005710_A1644ConceptoPais = new short[1] ;
      T005710_n1644ConceptoPais = new boolean[] {false} ;
      T005711_A1822CliPadre = new int[1] ;
      T005711_n1822CliPadre = new boolean[] {false} ;
      T005713_A3CliCod = new int[1] ;
      T005714_A37TipoConCod = new String[] {""} ;
      T005715_A37TipoConCod = new String[] {""} ;
      T005716_A37TipoConCod = new String[] {""} ;
      T005717_A953ConCondicion = new String[] {""} ;
      T005717_n953ConCondicion = new boolean[] {false} ;
      T005718_A3CliCod = new int[1] ;
      T005719_A1644ConceptoPais = new short[1] ;
      T005719_n1644ConceptoPais = new boolean[] {false} ;
      T005720_A1822CliPadre = new int[1] ;
      T005720_n1822CliPadre = new boolean[] {false} ;
      T005721_A3CliCod = new int[1] ;
      T005721_A26ConCodigo = new String[] {""} ;
      T00573_A42ConCodYDesc = new String[] {""} ;
      T00573_n42ConCodYDesc = new boolean[] {false} ;
      T00573_A26ConCodigo = new String[] {""} ;
      T00573_A41ConDescrip = new String[] {""} ;
      T00573_A40ConOrden = new int[1] ;
      T00573_A162ConVigencia = new byte[1] ;
      T00573_A1488ConLiqBasica = new byte[1] ;
      T00573_A148ConFormula = new String[] {""} ;
      T00573_n148ConFormula = new boolean[] {false} ;
      T00573_A153ConObservacion = new String[] {""} ;
      T00573_A159ConVariable = new boolean[] {false} ;
      T00573_A146ConForEditable = new boolean[] {false} ;
      T00573_n146ConForEditable = new boolean[] {false} ;
      T00573_A503ConTipoLiqAux = new String[] {""} ;
      T00573_n503ConTipoLiqAux = new boolean[] {false} ;
      T00573_A970ConClasifAux = new String[] {""} ;
      T00573_n970ConClasifAux = new boolean[] {false} ;
      T00573_A510ConOrdEjec = new long[1] ;
      T00573_A569ConFormulaExpl = new String[] {""} ;
      T00573_A762ConRecalcular = new boolean[] {false} ;
      T00573_A1018ConRangoCant = new String[] {""} ;
      T00573_A954ConCondCodigo = new String[] {""} ;
      T00573_A1068ConMostrarPos = new boolean[] {false} ;
      T00573_A1077ConAdelDescu = new byte[1] ;
      T00573_n1077ConAdelDescu = new boolean[] {false} ;
      T00573_A1194ConSegunPla = new boolean[] {false} ;
      T00573_A1471ConNumero = new byte[1] ;
      T00573_A1648ConCodAfip = new String[] {""} ;
      T00573_A1472ConSIPAApo = new byte[1] ;
      T00573_A1473ConSIPACont = new byte[1] ;
      T00573_A1474ConINSSJyPApo = new byte[1] ;
      T00573_A1475ConINSSJyPCont = new byte[1] ;
      T00573_A1476ConObraSocApo = new byte[1] ;
      T00573_A1477ConObraSocCont = new byte[1] ;
      T00573_A1478ConFonSolRedApo = new byte[1] ;
      T00573_A1479ConFonSolRedCont = new byte[1] ;
      T00573_A1480ConRenateaApo = new byte[1] ;
      T00573_A1481ConRenateaCont = new byte[1] ;
      T00573_A1482ConAsigFamCont = new byte[1] ;
      T00573_A1483ConFonNacEmpCont = new byte[1] ;
      T00573_A1484ConLeyRieTrabCont = new byte[1] ;
      T00573_A1485ConRegDifApo = new byte[1] ;
      T00573_A1486ConRegEspApo = new byte[1] ;
      T00573_A1539ConSacDeven = new byte[1] ;
      T00573_A1620ConBaseLic = new byte[1] ;
      T00573_A1797ConBaseLicProm = new byte[1] ;
      T00573_A1621ConBaseFer = new byte[1] ;
      T00573_A1798ConBaseFerProm = new byte[1] ;
      T00573_A1622ConBaseHorExt = new byte[1] ;
      T00573_A1799ConBaseHorExtProm = new byte[1] ;
      T00573_A1800ConBasePres = new byte[1] ;
      T00573_A1801ConBaseAnt = new byte[1] ;
      T00573_A1827ConBaseOSDif = new byte[1] ;
      T00573_A1821ConErrorSiCero = new boolean[] {false} ;
      T00573_A1826ConPueNov = new boolean[] {false} ;
      T00573_A1822CliPadre = new int[1] ;
      T00573_n1822CliPadre = new boolean[] {false} ;
      T00573_A3CliCod = new int[1] ;
      T00573_A1112AplIIGG = new short[1] ;
      T00573_n1112AplIIGG = new boolean[] {false} ;
      T00573_A37TipoConCod = new String[] {""} ;
      T00573_A38SubTipoConCod1 = new String[] {""} ;
      T00573_n38SubTipoConCod1 = new boolean[] {false} ;
      T00573_A39SubTipoConCod2 = new String[] {""} ;
      T00573_n39SubTipoConCod2 = new boolean[] {false} ;
      T00573_A953ConCondicion = new String[] {""} ;
      T00573_n953ConCondicion = new boolean[] {false} ;
      T00573_A1644ConceptoPais = new short[1] ;
      T00573_n1644ConceptoPais = new boolean[] {false} ;
      T00573_A1645ConceptoConveCodigo = new String[] {""} ;
      T00573_n1645ConceptoConveCodigo = new boolean[] {false} ;
      T00573_A921ConPadre = new String[] {""} ;
      T00573_n921ConPadre = new boolean[] {false} ;
      T005722_A3CliCod = new int[1] ;
      T005722_A26ConCodigo = new String[] {""} ;
      T005723_A3CliCod = new int[1] ;
      T005723_A26ConCodigo = new String[] {""} ;
      T00572_A42ConCodYDesc = new String[] {""} ;
      T00572_n42ConCodYDesc = new boolean[] {false} ;
      T00572_A26ConCodigo = new String[] {""} ;
      T00572_A41ConDescrip = new String[] {""} ;
      T00572_A40ConOrden = new int[1] ;
      T00572_A162ConVigencia = new byte[1] ;
      T00572_A1488ConLiqBasica = new byte[1] ;
      T00572_A148ConFormula = new String[] {""} ;
      T00572_n148ConFormula = new boolean[] {false} ;
      T00572_A153ConObservacion = new String[] {""} ;
      T00572_A159ConVariable = new boolean[] {false} ;
      T00572_A146ConForEditable = new boolean[] {false} ;
      T00572_n146ConForEditable = new boolean[] {false} ;
      T00572_A503ConTipoLiqAux = new String[] {""} ;
      T00572_n503ConTipoLiqAux = new boolean[] {false} ;
      T00572_A970ConClasifAux = new String[] {""} ;
      T00572_n970ConClasifAux = new boolean[] {false} ;
      T00572_A510ConOrdEjec = new long[1] ;
      T00572_A569ConFormulaExpl = new String[] {""} ;
      T00572_A762ConRecalcular = new boolean[] {false} ;
      T00572_A1018ConRangoCant = new String[] {""} ;
      T00572_A954ConCondCodigo = new String[] {""} ;
      T00572_A1068ConMostrarPos = new boolean[] {false} ;
      T00572_A1077ConAdelDescu = new byte[1] ;
      T00572_n1077ConAdelDescu = new boolean[] {false} ;
      T00572_A1194ConSegunPla = new boolean[] {false} ;
      T00572_A1471ConNumero = new byte[1] ;
      T00572_A1648ConCodAfip = new String[] {""} ;
      T00572_A1472ConSIPAApo = new byte[1] ;
      T00572_A1473ConSIPACont = new byte[1] ;
      T00572_A1474ConINSSJyPApo = new byte[1] ;
      T00572_A1475ConINSSJyPCont = new byte[1] ;
      T00572_A1476ConObraSocApo = new byte[1] ;
      T00572_A1477ConObraSocCont = new byte[1] ;
      T00572_A1478ConFonSolRedApo = new byte[1] ;
      T00572_A1479ConFonSolRedCont = new byte[1] ;
      T00572_A1480ConRenateaApo = new byte[1] ;
      T00572_A1481ConRenateaCont = new byte[1] ;
      T00572_A1482ConAsigFamCont = new byte[1] ;
      T00572_A1483ConFonNacEmpCont = new byte[1] ;
      T00572_A1484ConLeyRieTrabCont = new byte[1] ;
      T00572_A1485ConRegDifApo = new byte[1] ;
      T00572_A1486ConRegEspApo = new byte[1] ;
      T00572_A1539ConSacDeven = new byte[1] ;
      T00572_A1620ConBaseLic = new byte[1] ;
      T00572_A1797ConBaseLicProm = new byte[1] ;
      T00572_A1621ConBaseFer = new byte[1] ;
      T00572_A1798ConBaseFerProm = new byte[1] ;
      T00572_A1622ConBaseHorExt = new byte[1] ;
      T00572_A1799ConBaseHorExtProm = new byte[1] ;
      T00572_A1800ConBasePres = new byte[1] ;
      T00572_A1801ConBaseAnt = new byte[1] ;
      T00572_A1827ConBaseOSDif = new byte[1] ;
      T00572_A1821ConErrorSiCero = new boolean[] {false} ;
      T00572_A1826ConPueNov = new boolean[] {false} ;
      T00572_A1822CliPadre = new int[1] ;
      T00572_n1822CliPadre = new boolean[] {false} ;
      T00572_A3CliCod = new int[1] ;
      T00572_A1112AplIIGG = new short[1] ;
      T00572_n1112AplIIGG = new boolean[] {false} ;
      T00572_A37TipoConCod = new String[] {""} ;
      T00572_A38SubTipoConCod1 = new String[] {""} ;
      T00572_n38SubTipoConCod1 = new boolean[] {false} ;
      T00572_A39SubTipoConCod2 = new String[] {""} ;
      T00572_n39SubTipoConCod2 = new boolean[] {false} ;
      T00572_A953ConCondicion = new String[] {""} ;
      T00572_n953ConCondicion = new boolean[] {false} ;
      T00572_A1644ConceptoPais = new short[1] ;
      T00572_n1644ConceptoPais = new boolean[] {false} ;
      T00572_A1645ConceptoConveCodigo = new String[] {""} ;
      T00572_n1645ConceptoConveCodigo = new boolean[] {false} ;
      T00572_A921ConPadre = new String[] {""} ;
      T00572_n921ConPadre = new boolean[] {false} ;
      T005727_A1822CliPadre = new int[1] ;
      T005727_n1822CliPadre = new boolean[] {false} ;
      T005727_A921ConPadre = new String[] {""} ;
      T005727_n921ConPadre = new boolean[] {false} ;
      T005728_A46PaiCod = new short[1] ;
      T005728_A1440PaiBaseClaseLeg = new byte[1] ;
      T005728_A1441PaiBaseTipo = new String[] {""} ;
      T005728_A1442PaiBaseCod1 = new String[] {""} ;
      T005728_A1443PaiBaseCod2 = new String[] {""} ;
      T005728_A1445PaiBaseCliCod = new int[1] ;
      T005728_A1446PaiBaseConCodigo = new String[] {""} ;
      T005729_A46PaiCod = new short[1] ;
      T005729_A1356PaiMenCliCod = new int[1] ;
      T005729_A1358PaiMesConCodigo = new String[] {""} ;
      T005730_A46PaiCod = new short[1] ;
      T005730_A1354PaiJorCliCod = new int[1] ;
      T005730_A1355PaiJorConCodigo = new String[] {""} ;
      T005731_A3CliCod = new int[1] ;
      T005731_A1EmpCod = new short[1] ;
      T005731_A6LegNumero = new int[1] ;
      T005731_A1135LegSuelSec = new short[1] ;
      T005731_A2349LegSuelConcepto = new String[] {""} ;
      T005732_A3CliCod = new int[1] ;
      T005732_A26ConCodigo = new String[] {""} ;
      T005732_A2119ConOpeId = new String[] {""} ;
      T005732_A923ConOperFor = new String[] {""} ;
      T005733_A3CliCod = new int[1] ;
      T005733_A26ConCodigo = new String[] {""} ;
      T005733_A11MegCodigo = new String[] {""} ;
      T005733_A2077ConMegSec = new short[1] ;
      T005734_A3CliCod = new int[1] ;
      T005734_A1EmpCod = new short[1] ;
      T005734_A6LegNumero = new int[1] ;
      T005734_A1829PreliqTLiqCod = new String[] {""} ;
      T005734_A1830PreliqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T005734_A1831PreliqConcepto = new String[] {""} ;
      T005735_A3CliCod = new int[1] ;
      T005735_A1564CliPaiConve = new short[1] ;
      T005735_A1565CliConvenio = new String[] {""} ;
      T005735_A1327ConveHsExSec = new short[1] ;
      T005736_A3CliCod = new int[1] ;
      T005736_A1564CliPaiConve = new short[1] ;
      T005736_A1565CliConvenio = new String[] {""} ;
      T005736_A1381ConveMenCliCod = new int[1] ;
      T005736_A1375ConveMenConCodigo = new String[] {""} ;
      T005737_A3CliCod = new int[1] ;
      T005737_A1EmpCod = new short[1] ;
      T005737_A31LiqNro = new int[1] ;
      T005737_A6LegNumero = new int[1] ;
      T005737_A1541LiqAjuNro = new short[1] ;
      T005737_A1543LiqAjuSec = new short[1] ;
      T005738_A3CliCod = new int[1] ;
      T005738_A1EmpCod = new short[1] ;
      T005738_A1366EmpJorConCodigo = new String[] {""} ;
      T005739_A3CliCod = new int[1] ;
      T005739_A1EmpCod = new short[1] ;
      T005739_A1368EmpMenConCodigo = new String[] {""} ;
      T005740_A3CliCod = new int[1] ;
      T005740_A1EmpCod = new short[1] ;
      T005740_A6LegNumero = new int[1] ;
      T005740_A1172OblSecuencial = new short[1] ;
      T005740_A1170OblExcConCOdigo = new String[] {""} ;
      T005741_A3CliCod = new int[1] ;
      T005741_A1EmpCod = new short[1] ;
      T005741_A6LegNumero = new int[1] ;
      T005741_A1172OblSecuencial = new short[1] ;
      T005742_A3CliCod = new int[1] ;
      T005742_A1EmpCod = new short[1] ;
      T005742_A6LegNumero = new int[1] ;
      T005742_A1172OblSecuencial = new short[1] ;
      T005743_A3CliCod = new int[1] ;
      T005743_A1EmpCod = new short[1] ;
      T005743_A1129LiqExAnio = new short[1] ;
      T005743_A31LiqNro = new int[1] ;
      T005743_A6LegNumero = new int[1] ;
      T005743_A1127LiqExenConCodigo = new String[] {""} ;
      T005743_A1128LiqExAplIIGG = new short[1] ;
      T005744_A3CliCod = new int[1] ;
      T005744_A1112AplIIGG = new short[1] ;
      T005744_n1112AplIIGG = new boolean[] {false} ;
      T005745_A3CliCod = new int[1] ;
      T005745_A1112AplIIGG = new short[1] ;
      T005745_n1112AplIIGG = new boolean[] {false} ;
      T005746_A3CliCod = new int[1] ;
      T005746_A1112AplIIGG = new short[1] ;
      T005746_n1112AplIIGG = new boolean[] {false} ;
      T005747_A3CliCod = new int[1] ;
      T005747_A1105CondExenIIGG = new String[] {""} ;
      T005748_A3CliCod = new int[1] ;
      T005748_A1101SiraTipo = new String[] {""} ;
      T005748_A1102SiraCodigo = new String[] {""} ;
      T005749_A3CliCod = new int[1] ;
      T005749_A1EmpCod = new short[1] ;
      T005749_A869LiqLegConAnio = new short[1] ;
      T005749_A6LegNumero = new int[1] ;
      T005749_A26ConCodigo = new String[] {""} ;
      T005749_A1097LiqAltaNro = new int[1] ;
      T005749_A1098LiqNuevaNro = new int[1] ;
      T005750_A3CliCod = new int[1] ;
      T005750_A1EmpCod = new short[1] ;
      T005750_A6LegNumero = new int[1] ;
      T005750_A83LegDedSec = new int[1] ;
      T005751_A3CliCod = new int[1] ;
      T005751_A26ConCodigo = new String[] {""} ;
      T005751_A51ForHisNum = new short[1] ;
      T005752_A3CliCod = new int[1] ;
      T005752_A26ConCodigo = new String[] {""} ;
      T005752_A32TLiqCod = new String[] {""} ;
      T005753_A3CliCod = new int[1] ;
      T005753_A1EmpCod = new short[1] ;
      T005753_A6LegNumero = new int[1] ;
      T005753_A25AgeOrden = new short[1] ;
      T005754_A3CliCod = new int[1] ;
      T005754_A26ConCodigo = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T005755_A37TipoConCod = new String[] {""} ;
      T005756_A37TipoConCod = new String[] {""} ;
      T005757_A37TipoConCod = new String[] {""} ;
      T005758_A953ConCondicion = new String[] {""} ;
      T005758_n953ConCondicion = new boolean[] {false} ;
      T005759_A3CliCod = new int[1] ;
      T005760_A1644ConceptoPais = new short[1] ;
      T005760_n1644ConceptoPais = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptos_export__default(),
         new Object[] {
             new Object[] {
            T00572_A42ConCodYDesc, T00572_n42ConCodYDesc, T00572_A26ConCodigo, T00572_A41ConDescrip, T00572_A40ConOrden, T00572_A162ConVigencia, T00572_A1488ConLiqBasica, T00572_A148ConFormula, T00572_n148ConFormula, T00572_A153ConObservacion,
            T00572_A159ConVariable, T00572_A146ConForEditable, T00572_n146ConForEditable, T00572_A503ConTipoLiqAux, T00572_n503ConTipoLiqAux, T00572_A970ConClasifAux, T00572_n970ConClasifAux, T00572_A510ConOrdEjec, T00572_A569ConFormulaExpl, T00572_A762ConRecalcular,
            T00572_A1018ConRangoCant, T00572_A954ConCondCodigo, T00572_A1068ConMostrarPos, T00572_A1077ConAdelDescu, T00572_n1077ConAdelDescu, T00572_A1194ConSegunPla, T00572_A1471ConNumero, T00572_A1648ConCodAfip, T00572_A1472ConSIPAApo, T00572_A1473ConSIPACont,
            T00572_A1474ConINSSJyPApo, T00572_A1475ConINSSJyPCont, T00572_A1476ConObraSocApo, T00572_A1477ConObraSocCont, T00572_A1478ConFonSolRedApo, T00572_A1479ConFonSolRedCont, T00572_A1480ConRenateaApo, T00572_A1481ConRenateaCont, T00572_A1482ConAsigFamCont, T00572_A1483ConFonNacEmpCont,
            T00572_A1484ConLeyRieTrabCont, T00572_A1485ConRegDifApo, T00572_A1486ConRegEspApo, T00572_A1539ConSacDeven, T00572_A1620ConBaseLic, T00572_A1797ConBaseLicProm, T00572_A1621ConBaseFer, T00572_A1798ConBaseFerProm, T00572_A1622ConBaseHorExt, T00572_A1799ConBaseHorExtProm,
            T00572_A1800ConBasePres, T00572_A1801ConBaseAnt, T00572_A1827ConBaseOSDif, T00572_A1821ConErrorSiCero, T00572_A1826ConPueNov, T00572_A1822CliPadre, T00572_n1822CliPadre, T00572_A3CliCod, T00572_A1112AplIIGG, T00572_n1112AplIIGG,
            T00572_A37TipoConCod, T00572_A38SubTipoConCod1, T00572_n38SubTipoConCod1, T00572_A39SubTipoConCod2, T00572_n39SubTipoConCod2, T00572_A953ConCondicion, T00572_n953ConCondicion, T00572_A1644ConceptoPais, T00572_n1644ConceptoPais, T00572_A1645ConceptoConveCodigo,
            T00572_n1645ConceptoConveCodigo, T00572_A921ConPadre, T00572_n921ConPadre
            }
            , new Object[] {
            T00573_A42ConCodYDesc, T00573_n42ConCodYDesc, T00573_A26ConCodigo, T00573_A41ConDescrip, T00573_A40ConOrden, T00573_A162ConVigencia, T00573_A1488ConLiqBasica, T00573_A148ConFormula, T00573_n148ConFormula, T00573_A153ConObservacion,
            T00573_A159ConVariable, T00573_A146ConForEditable, T00573_n146ConForEditable, T00573_A503ConTipoLiqAux, T00573_n503ConTipoLiqAux, T00573_A970ConClasifAux, T00573_n970ConClasifAux, T00573_A510ConOrdEjec, T00573_A569ConFormulaExpl, T00573_A762ConRecalcular,
            T00573_A1018ConRangoCant, T00573_A954ConCondCodigo, T00573_A1068ConMostrarPos, T00573_A1077ConAdelDescu, T00573_n1077ConAdelDescu, T00573_A1194ConSegunPla, T00573_A1471ConNumero, T00573_A1648ConCodAfip, T00573_A1472ConSIPAApo, T00573_A1473ConSIPACont,
            T00573_A1474ConINSSJyPApo, T00573_A1475ConINSSJyPCont, T00573_A1476ConObraSocApo, T00573_A1477ConObraSocCont, T00573_A1478ConFonSolRedApo, T00573_A1479ConFonSolRedCont, T00573_A1480ConRenateaApo, T00573_A1481ConRenateaCont, T00573_A1482ConAsigFamCont, T00573_A1483ConFonNacEmpCont,
            T00573_A1484ConLeyRieTrabCont, T00573_A1485ConRegDifApo, T00573_A1486ConRegEspApo, T00573_A1539ConSacDeven, T00573_A1620ConBaseLic, T00573_A1797ConBaseLicProm, T00573_A1621ConBaseFer, T00573_A1798ConBaseFerProm, T00573_A1622ConBaseHorExt, T00573_A1799ConBaseHorExtProm,
            T00573_A1800ConBasePres, T00573_A1801ConBaseAnt, T00573_A1827ConBaseOSDif, T00573_A1821ConErrorSiCero, T00573_A1826ConPueNov, T00573_A1822CliPadre, T00573_n1822CliPadre, T00573_A3CliCod, T00573_A1112AplIIGG, T00573_n1112AplIIGG,
            T00573_A37TipoConCod, T00573_A38SubTipoConCod1, T00573_n38SubTipoConCod1, T00573_A39SubTipoConCod2, T00573_n39SubTipoConCod2, T00573_A953ConCondicion, T00573_n953ConCondicion, T00573_A1644ConceptoPais, T00573_n1644ConceptoPais, T00573_A1645ConceptoConveCodigo,
            T00573_n1645ConceptoConveCodigo, T00573_A921ConPadre, T00573_n921ConPadre
            }
            , new Object[] {
            T00574_A3CliCod
            }
            , new Object[] {
            T00575_A3CliCod
            }
            , new Object[] {
            T00576_A37TipoConCod
            }
            , new Object[] {
            T00577_A37TipoConCod
            }
            , new Object[] {
            T00578_A37TipoConCod
            }
            , new Object[] {
            T00579_A953ConCondicion
            }
            , new Object[] {
            T005710_A1644ConceptoPais
            }
            , new Object[] {
            T005711_A1822CliPadre
            }
            , new Object[] {
            T005712_A42ConCodYDesc, T005712_n42ConCodYDesc, T005712_A26ConCodigo, T005712_A41ConDescrip, T005712_A40ConOrden, T005712_A162ConVigencia, T005712_A1488ConLiqBasica, T005712_A148ConFormula, T005712_n148ConFormula, T005712_A153ConObservacion,
            T005712_A159ConVariable, T005712_A146ConForEditable, T005712_n146ConForEditable, T005712_A503ConTipoLiqAux, T005712_n503ConTipoLiqAux, T005712_A970ConClasifAux, T005712_n970ConClasifAux, T005712_A510ConOrdEjec, T005712_A569ConFormulaExpl, T005712_A762ConRecalcular,
            T005712_A1018ConRangoCant, T005712_A954ConCondCodigo, T005712_A1068ConMostrarPos, T005712_A1077ConAdelDescu, T005712_n1077ConAdelDescu, T005712_A1194ConSegunPla, T005712_A1471ConNumero, T005712_A1648ConCodAfip, T005712_A1472ConSIPAApo, T005712_A1473ConSIPACont,
            T005712_A1474ConINSSJyPApo, T005712_A1475ConINSSJyPCont, T005712_A1476ConObraSocApo, T005712_A1477ConObraSocCont, T005712_A1478ConFonSolRedApo, T005712_A1479ConFonSolRedCont, T005712_A1480ConRenateaApo, T005712_A1481ConRenateaCont, T005712_A1482ConAsigFamCont, T005712_A1483ConFonNacEmpCont,
            T005712_A1484ConLeyRieTrabCont, T005712_A1485ConRegDifApo, T005712_A1486ConRegEspApo, T005712_A1539ConSacDeven, T005712_A1620ConBaseLic, T005712_A1797ConBaseLicProm, T005712_A1621ConBaseFer, T005712_A1798ConBaseFerProm, T005712_A1622ConBaseHorExt, T005712_A1799ConBaseHorExtProm,
            T005712_A1800ConBasePres, T005712_A1801ConBaseAnt, T005712_A1827ConBaseOSDif, T005712_A1821ConErrorSiCero, T005712_A1826ConPueNov, T005712_A1822CliPadre, T005712_n1822CliPadre, T005712_A3CliCod, T005712_A1112AplIIGG, T005712_n1112AplIIGG,
            T005712_A37TipoConCod, T005712_A38SubTipoConCod1, T005712_n38SubTipoConCod1, T005712_A39SubTipoConCod2, T005712_n39SubTipoConCod2, T005712_A953ConCondicion, T005712_n953ConCondicion, T005712_A1644ConceptoPais, T005712_n1644ConceptoPais, T005712_A1645ConceptoConveCodigo,
            T005712_n1645ConceptoConveCodigo, T005712_A921ConPadre, T005712_n921ConPadre
            }
            , new Object[] {
            T005713_A3CliCod
            }
            , new Object[] {
            T005714_A37TipoConCod
            }
            , new Object[] {
            T005715_A37TipoConCod
            }
            , new Object[] {
            T005716_A37TipoConCod
            }
            , new Object[] {
            T005717_A953ConCondicion
            }
            , new Object[] {
            T005718_A3CliCod
            }
            , new Object[] {
            T005719_A1644ConceptoPais
            }
            , new Object[] {
            T005720_A1822CliPadre
            }
            , new Object[] {
            T005721_A3CliCod, T005721_A26ConCodigo
            }
            , new Object[] {
            T005722_A3CliCod, T005722_A26ConCodigo
            }
            , new Object[] {
            T005723_A3CliCod, T005723_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005727_A1822CliPadre, T005727_A921ConPadre
            }
            , new Object[] {
            T005728_A46PaiCod, T005728_A1440PaiBaseClaseLeg, T005728_A1441PaiBaseTipo, T005728_A1442PaiBaseCod1, T005728_A1443PaiBaseCod2, T005728_A1445PaiBaseCliCod, T005728_A1446PaiBaseConCodigo
            }
            , new Object[] {
            T005729_A46PaiCod, T005729_A1356PaiMenCliCod, T005729_A1358PaiMesConCodigo
            }
            , new Object[] {
            T005730_A46PaiCod, T005730_A1354PaiJorCliCod, T005730_A1355PaiJorConCodigo
            }
            , new Object[] {
            T005731_A3CliCod, T005731_A1EmpCod, T005731_A6LegNumero, T005731_A1135LegSuelSec, T005731_A2349LegSuelConcepto
            }
            , new Object[] {
            T005732_A3CliCod, T005732_A26ConCodigo, T005732_A2119ConOpeId, T005732_A923ConOperFor
            }
            , new Object[] {
            T005733_A3CliCod, T005733_A26ConCodigo, T005733_A11MegCodigo, T005733_A2077ConMegSec
            }
            , new Object[] {
            T005734_A3CliCod, T005734_A1EmpCod, T005734_A6LegNumero, T005734_A1829PreliqTLiqCod, T005734_A1830PreliqPeriodo, T005734_A1831PreliqConcepto
            }
            , new Object[] {
            T005735_A3CliCod, T005735_A1564CliPaiConve, T005735_A1565CliConvenio, T005735_A1327ConveHsExSec
            }
            , new Object[] {
            T005736_A3CliCod, T005736_A1564CliPaiConve, T005736_A1565CliConvenio, T005736_A1381ConveMenCliCod, T005736_A1375ConveMenConCodigo
            }
            , new Object[] {
            T005737_A3CliCod, T005737_A1EmpCod, T005737_A31LiqNro, T005737_A6LegNumero, T005737_A1541LiqAjuNro, T005737_A1543LiqAjuSec
            }
            , new Object[] {
            T005738_A3CliCod, T005738_A1EmpCod, T005738_A1366EmpJorConCodigo
            }
            , new Object[] {
            T005739_A3CliCod, T005739_A1EmpCod, T005739_A1368EmpMenConCodigo
            }
            , new Object[] {
            T005740_A3CliCod, T005740_A1EmpCod, T005740_A6LegNumero, T005740_A1172OblSecuencial, T005740_A1170OblExcConCOdigo
            }
            , new Object[] {
            T005741_A3CliCod, T005741_A1EmpCod, T005741_A6LegNumero, T005741_A1172OblSecuencial
            }
            , new Object[] {
            T005742_A3CliCod, T005742_A1EmpCod, T005742_A6LegNumero, T005742_A1172OblSecuencial
            }
            , new Object[] {
            T005743_A3CliCod, T005743_A1EmpCod, T005743_A1129LiqExAnio, T005743_A31LiqNro, T005743_A6LegNumero, T005743_A1127LiqExenConCodigo, T005743_A1128LiqExAplIIGG
            }
            , new Object[] {
            T005744_A3CliCod, T005744_A1112AplIIGG
            }
            , new Object[] {
            T005745_A3CliCod, T005745_A1112AplIIGG
            }
            , new Object[] {
            T005746_A3CliCod, T005746_A1112AplIIGG
            }
            , new Object[] {
            T005747_A3CliCod, T005747_A1105CondExenIIGG
            }
            , new Object[] {
            T005748_A3CliCod, T005748_A1101SiraTipo, T005748_A1102SiraCodigo
            }
            , new Object[] {
            T005749_A3CliCod, T005749_A1EmpCod, T005749_A869LiqLegConAnio, T005749_A6LegNumero, T005749_A26ConCodigo, T005749_A1097LiqAltaNro, T005749_A1098LiqNuevaNro
            }
            , new Object[] {
            T005750_A3CliCod, T005750_A1EmpCod, T005750_A6LegNumero, T005750_A83LegDedSec
            }
            , new Object[] {
            T005751_A3CliCod, T005751_A26ConCodigo, T005751_A51ForHisNum
            }
            , new Object[] {
            T005752_A3CliCod, T005752_A26ConCodigo, T005752_A32TLiqCod
            }
            , new Object[] {
            T005753_A3CliCod, T005753_A1EmpCod, T005753_A6LegNumero, T005753_A25AgeOrden
            }
            , new Object[] {
            T005754_A3CliCod, T005754_A26ConCodigo
            }
            , new Object[] {
            T005755_A37TipoConCod
            }
            , new Object[] {
            T005756_A37TipoConCod
            }
            , new Object[] {
            T005757_A37TipoConCod
            }
            , new Object[] {
            T005758_A953ConCondicion
            }
            , new Object[] {
            T005759_A3CliCod
            }
            , new Object[] {
            T005760_A1644ConceptoPais
            }
         }
      );
      AV38Pgmname = "Conceptos_export" ;
   }

   private byte Z162ConVigencia ;
   private byte Z1488ConLiqBasica ;
   private byte Z1077ConAdelDescu ;
   private byte Z1471ConNumero ;
   private byte Z1472ConSIPAApo ;
   private byte Z1473ConSIPACont ;
   private byte Z1474ConINSSJyPApo ;
   private byte Z1475ConINSSJyPCont ;
   private byte Z1476ConObraSocApo ;
   private byte Z1477ConObraSocCont ;
   private byte Z1478ConFonSolRedApo ;
   private byte Z1479ConFonSolRedCont ;
   private byte Z1480ConRenateaApo ;
   private byte Z1481ConRenateaCont ;
   private byte Z1482ConAsigFamCont ;
   private byte Z1483ConFonNacEmpCont ;
   private byte Z1484ConLeyRieTrabCont ;
   private byte Z1485ConRegDifApo ;
   private byte Z1486ConRegEspApo ;
   private byte Z1539ConSacDeven ;
   private byte Z1620ConBaseLic ;
   private byte Z1797ConBaseLicProm ;
   private byte Z1621ConBaseFer ;
   private byte Z1798ConBaseFerProm ;
   private byte Z1622ConBaseHorExt ;
   private byte Z1799ConBaseHorExtProm ;
   private byte Z1800ConBasePres ;
   private byte Z1801ConBaseAnt ;
   private byte Z1827ConBaseOSDif ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A162ConVigencia ;
   private byte A1077ConAdelDescu ;
   private byte A1539ConSacDeven ;
   private byte A1620ConBaseLic ;
   private byte A1621ConBaseFer ;
   private byte A1622ConBaseHorExt ;
   private byte A1488ConLiqBasica ;
   private byte A1471ConNumero ;
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
   private byte A1797ConBaseLicProm ;
   private byte A1798ConBaseFerProm ;
   private byte A1799ConBaseHorExtProm ;
   private byte A1800ConBasePres ;
   private byte A1801ConBaseAnt ;
   private byte A1827ConBaseOSDif ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z1112AplIIGG ;
   private short Z1644ConceptoPais ;
   private short N1112AplIIGG ;
   private short N1644ConceptoPais ;
   private short A1112AplIIGG ;
   private short A1644ConceptoPais ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV17Insert_AplIIGG ;
   private short AV18Insert_ConceptoPais ;
   private short RcdFound7 ;
   private short nIsDirty_7 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z40ConOrden ;
   private int Z1822CliPadre ;
   private int N1822CliPadre ;
   private int A3CliCod ;
   private int A1822CliPadre ;
   private int AV7CliCod ;
   private int trnEnded ;
   private int edtCliCod_Enabled ;
   private int edtConCodigo_Enabled ;
   private int edtConDescrip_Enabled ;
   private int A40ConOrden ;
   private int edtConOrden_Enabled ;
   private int edtConLiqBasica_Enabled ;
   private int edtConFormula_Enabled ;
   private int edtConObservacion_Enabled ;
   private int edtSubTipoConCod1_Visible ;
   private int edtSubTipoConCod1_Enabled ;
   private int edtSubTipoConCod2_Visible ;
   private int edtSubTipoConCod2_Enabled ;
   private int edtConTipoLiqAux_Enabled ;
   private int edtConClasifAux_Enabled ;
   private int edtConOrdEjec_Enabled ;
   private int edtConFormulaExpl_Enabled ;
   private int edtConRangoCant_Enabled ;
   private int edtConCondCodigo_Enabled ;
   private int edtAplIIGG_Enabled ;
   private int edtConNumero_Enabled ;
   private int edtConCodAfip_Enabled ;
   private int edtConSIPAApo_Enabled ;
   private int edtConSIPACont_Enabled ;
   private int edtConINSSJyPApo_Enabled ;
   private int edtConINSSJyPCont_Enabled ;
   private int edtConObraSocApo_Enabled ;
   private int edtConObraSocCont_Enabled ;
   private int edtConFonSolRedApo_Enabled ;
   private int edtConFonSolRedCont_Enabled ;
   private int edtConRenateaApo_Enabled ;
   private int edtConRenateaCont_Enabled ;
   private int edtConAsigFamCont_Enabled ;
   private int edtConFonNacEmpCont_Enabled ;
   private int edtConLeyRieTrabCont_Enabled ;
   private int edtConRegDifApo_Enabled ;
   private int edtConRegEspApo_Enabled ;
   private int edtConceptoPais_Enabled ;
   private int edtConceptoConveCodigo_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombosubtipoconcod1_Visible ;
   private int edtavCombosubtipoconcod1_Enabled ;
   private int edtavCombosubtipoconcod2_Visible ;
   private int edtavCombosubtipoconcod2_Enabled ;
   private int AV36Insert_CliPadre ;
   private int Combo_tipoconcod_Datalistupdateminimumcharacters ;
   private int Combo_tipoconcod_Gxcontroltype ;
   private int Combo_subtipoconcod1_Datalistupdateminimumcharacters ;
   private int Combo_subtipoconcod1_Gxcontroltype ;
   private int Combo_subtipoconcod2_Datalistupdateminimumcharacters ;
   private int Combo_subtipoconcod2_Gxcontroltype ;
   private int Combo_concondicion_Datalistupdateminimumcharacters ;
   private int Combo_concondicion_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV39GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long Z510ConOrdEjec ;
   private long A510ConOrdEjec ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8ConCodigo ;
   private String Z26ConCodigo ;
   private String Z954ConCondCodigo ;
   private String Z1648ConCodAfip ;
   private String Z37TipoConCod ;
   private String Z38SubTipoConCod1 ;
   private String Z39SubTipoConCod2 ;
   private String Z953ConCondicion ;
   private String Z1645ConceptoConveCodigo ;
   private String Z921ConPadre ;
   private String N37TipoConCod ;
   private String N38SubTipoConCod1 ;
   private String N39SubTipoConCod2 ;
   private String N953ConCondicion ;
   private String N1645ConceptoConveCodigo ;
   private String N921ConPadre ;
   private String Combo_concondicion_Selectedvalue_get ;
   private String Combo_subtipoconcod2_Selectedvalue_get ;
   private String Combo_subtipoconcod1_Selectedvalue_get ;
   private String Combo_tipoconcod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String A953ConCondicion ;
   private String A1645ConceptoConveCodigo ;
   private String A921ConPadre ;
   private String Gx_mode ;
   private String AV8ConCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliCod_Internalname ;
   private String AV26ComboTipoConCod ;
   private String AV35ComboConCondicion ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String edtCliCod_Jsonclick ;
   private String edtConCodigo_Internalname ;
   private String A26ConCodigo ;
   private String edtConCodigo_Jsonclick ;
   private String edtConDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtConOrden_Internalname ;
   private String edtConOrden_Jsonclick ;
   private String edtConLiqBasica_Internalname ;
   private String edtConLiqBasica_Jsonclick ;
   private String edtConFormula_Internalname ;
   private String edtConObservacion_Internalname ;
   private String divTablesplittedtipoconcod_Internalname ;
   private String lblTextblocktipoconcod_Internalname ;
   private String lblTextblocktipoconcod_Jsonclick ;
   private String Combo_tipoconcod_Caption ;
   private String Combo_tipoconcod_Cls ;
   private String Combo_tipoconcod_Datalistproc ;
   private String Combo_tipoconcod_Datalistprocparametersprefix ;
   private String Combo_tipoconcod_Internalname ;
   private String divTablesplittedsubtipoconcod1_Internalname ;
   private String lblTextblocksubtipoconcod1_Internalname ;
   private String lblTextblocksubtipoconcod1_Jsonclick ;
   private String Combo_subtipoconcod1_Caption ;
   private String Combo_subtipoconcod1_Cls ;
   private String Combo_subtipoconcod1_Datalistproc ;
   private String Combo_subtipoconcod1_Internalname ;
   private String edtSubTipoConCod1_Internalname ;
   private String edtSubTipoConCod1_Jsonclick ;
   private String divTablesplittedsubtipoconcod2_Internalname ;
   private String lblTextblocksubtipoconcod2_Internalname ;
   private String lblTextblocksubtipoconcod2_Jsonclick ;
   private String Combo_subtipoconcod2_Caption ;
   private String Combo_subtipoconcod2_Cls ;
   private String Combo_subtipoconcod2_Datalistproc ;
   private String Combo_subtipoconcod2_Internalname ;
   private String edtSubTipoConCod2_Internalname ;
   private String edtSubTipoConCod2_Jsonclick ;
   private String edtConTipoLiqAux_Internalname ;
   private String edtConTipoLiqAux_Jsonclick ;
   private String edtConClasifAux_Internalname ;
   private String edtConClasifAux_Jsonclick ;
   private String edtConOrdEjec_Internalname ;
   private String edtConOrdEjec_Jsonclick ;
   private String edtConFormulaExpl_Internalname ;
   private String edtConRangoCant_Internalname ;
   private String divTablesplittedconcondicion_Internalname ;
   private String lblTextblockconcondicion_Internalname ;
   private String lblTextblockconcondicion_Jsonclick ;
   private String Combo_concondicion_Caption ;
   private String Combo_concondicion_Cls ;
   private String Combo_concondicion_Datalistproc ;
   private String Combo_concondicion_Datalistprocparametersprefix ;
   private String Combo_concondicion_Internalname ;
   private String edtConCondCodigo_Internalname ;
   private String A954ConCondCodigo ;
   private String edtConCondCodigo_Jsonclick ;
   private String edtAplIIGG_Internalname ;
   private String edtAplIIGG_Jsonclick ;
   private String edtConNumero_Internalname ;
   private String edtConNumero_Jsonclick ;
   private String edtConCodAfip_Internalname ;
   private String A1648ConCodAfip ;
   private String edtConCodAfip_Jsonclick ;
   private String edtConSIPAApo_Internalname ;
   private String edtConSIPAApo_Jsonclick ;
   private String edtConSIPACont_Internalname ;
   private String edtConSIPACont_Jsonclick ;
   private String edtConINSSJyPApo_Internalname ;
   private String edtConINSSJyPApo_Jsonclick ;
   private String edtConINSSJyPCont_Internalname ;
   private String edtConINSSJyPCont_Jsonclick ;
   private String edtConObraSocApo_Internalname ;
   private String edtConObraSocApo_Jsonclick ;
   private String edtConObraSocCont_Internalname ;
   private String edtConObraSocCont_Jsonclick ;
   private String edtConFonSolRedApo_Internalname ;
   private String edtConFonSolRedApo_Jsonclick ;
   private String edtConFonSolRedCont_Internalname ;
   private String edtConFonSolRedCont_Jsonclick ;
   private String edtConRenateaApo_Internalname ;
   private String edtConRenateaApo_Jsonclick ;
   private String edtConRenateaCont_Internalname ;
   private String edtConRenateaCont_Jsonclick ;
   private String edtConAsigFamCont_Internalname ;
   private String edtConAsigFamCont_Jsonclick ;
   private String edtConFonNacEmpCont_Internalname ;
   private String edtConFonNacEmpCont_Jsonclick ;
   private String edtConLeyRieTrabCont_Internalname ;
   private String edtConLeyRieTrabCont_Jsonclick ;
   private String edtConRegDifApo_Internalname ;
   private String edtConRegDifApo_Jsonclick ;
   private String edtConRegEspApo_Internalname ;
   private String edtConRegEspApo_Jsonclick ;
   private String edtConceptoPais_Internalname ;
   private String edtConceptoPais_Jsonclick ;
   private String edtConceptoConveCodigo_Internalname ;
   private String edtConceptoConveCodigo_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_tipoconcod_Internalname ;
   private String divSectionattribute_subtipoconcod1_Internalname ;
   private String edtavCombosubtipoconcod1_Internalname ;
   private String AV28ComboSubTipoConCod1 ;
   private String edtavCombosubtipoconcod1_Jsonclick ;
   private String divSectionattribute_subtipoconcod2_Internalname ;
   private String edtavCombosubtipoconcod2_Internalname ;
   private String AV31ComboSubTipoConCod2 ;
   private String edtavCombosubtipoconcod2_Jsonclick ;
   private String divSectionattribute_concondicion_Internalname ;
   private String AV29Cond_TipoConCod ;
   private String AV32Cond_SubTipoConCod1 ;
   private String AV14Insert_TipoConCod ;
   private String AV15Insert_SubTipoConCod1 ;
   private String AV16Insert_SubTipoConCod2 ;
   private String AV33Insert_ConCondicion ;
   private String AV19Insert_ConceptoConveCodigo ;
   private String AV37Insert_ConPadre ;
   private String AV38Pgmname ;
   private String Combo_tipoconcod_Objectcall ;
   private String Combo_tipoconcod_Class ;
   private String Combo_tipoconcod_Icontype ;
   private String Combo_tipoconcod_Icon ;
   private String Combo_tipoconcod_Tooltip ;
   private String Combo_tipoconcod_Selectedvalue_set ;
   private String Combo_tipoconcod_Selectedtext_set ;
   private String Combo_tipoconcod_Selectedtext_get ;
   private String Combo_tipoconcod_Gamoauthtoken ;
   private String Combo_tipoconcod_Ddointernalname ;
   private String Combo_tipoconcod_Titlecontrolalign ;
   private String Combo_tipoconcod_Dropdownoptionstype ;
   private String Combo_tipoconcod_Titlecontrolidtoreplace ;
   private String Combo_tipoconcod_Datalisttype ;
   private String Combo_tipoconcod_Datalistfixedvalues ;
   private String Combo_tipoconcod_Remoteservicesparameters ;
   private String Combo_tipoconcod_Htmltemplate ;
   private String Combo_tipoconcod_Multiplevaluestype ;
   private String Combo_tipoconcod_Loadingdata ;
   private String Combo_tipoconcod_Noresultsfound ;
   private String Combo_tipoconcod_Emptyitemtext ;
   private String Combo_tipoconcod_Onlyselectedvalues ;
   private String Combo_tipoconcod_Selectalltext ;
   private String Combo_tipoconcod_Multiplevaluesseparator ;
   private String Combo_tipoconcod_Addnewoptiontext ;
   private String Combo_subtipoconcod1_Objectcall ;
   private String Combo_subtipoconcod1_Class ;
   private String Combo_subtipoconcod1_Icontype ;
   private String Combo_subtipoconcod1_Icon ;
   private String Combo_subtipoconcod1_Tooltip ;
   private String Combo_subtipoconcod1_Selectedvalue_set ;
   private String Combo_subtipoconcod1_Selectedtext_set ;
   private String Combo_subtipoconcod1_Selectedtext_get ;
   private String Combo_subtipoconcod1_Gamoauthtoken ;
   private String Combo_subtipoconcod1_Ddointernalname ;
   private String Combo_subtipoconcod1_Titlecontrolalign ;
   private String Combo_subtipoconcod1_Dropdownoptionstype ;
   private String Combo_subtipoconcod1_Titlecontrolidtoreplace ;
   private String Combo_subtipoconcod1_Datalisttype ;
   private String Combo_subtipoconcod1_Datalistfixedvalues ;
   private String Combo_subtipoconcod1_Datalistprocparametersprefix ;
   private String Combo_subtipoconcod1_Remoteservicesparameters ;
   private String Combo_subtipoconcod1_Htmltemplate ;
   private String Combo_subtipoconcod1_Multiplevaluestype ;
   private String Combo_subtipoconcod1_Loadingdata ;
   private String Combo_subtipoconcod1_Noresultsfound ;
   private String Combo_subtipoconcod1_Emptyitemtext ;
   private String Combo_subtipoconcod1_Onlyselectedvalues ;
   private String Combo_subtipoconcod1_Selectalltext ;
   private String Combo_subtipoconcod1_Multiplevaluesseparator ;
   private String Combo_subtipoconcod1_Addnewoptiontext ;
   private String Combo_subtipoconcod2_Objectcall ;
   private String Combo_subtipoconcod2_Class ;
   private String Combo_subtipoconcod2_Icontype ;
   private String Combo_subtipoconcod2_Icon ;
   private String Combo_subtipoconcod2_Tooltip ;
   private String Combo_subtipoconcod2_Selectedvalue_set ;
   private String Combo_subtipoconcod2_Selectedtext_set ;
   private String Combo_subtipoconcod2_Selectedtext_get ;
   private String Combo_subtipoconcod2_Gamoauthtoken ;
   private String Combo_subtipoconcod2_Ddointernalname ;
   private String Combo_subtipoconcod2_Titlecontrolalign ;
   private String Combo_subtipoconcod2_Dropdownoptionstype ;
   private String Combo_subtipoconcod2_Titlecontrolidtoreplace ;
   private String Combo_subtipoconcod2_Datalisttype ;
   private String Combo_subtipoconcod2_Datalistfixedvalues ;
   private String Combo_subtipoconcod2_Datalistprocparametersprefix ;
   private String Combo_subtipoconcod2_Remoteservicesparameters ;
   private String Combo_subtipoconcod2_Htmltemplate ;
   private String Combo_subtipoconcod2_Multiplevaluestype ;
   private String Combo_subtipoconcod2_Loadingdata ;
   private String Combo_subtipoconcod2_Noresultsfound ;
   private String Combo_subtipoconcod2_Emptyitemtext ;
   private String Combo_subtipoconcod2_Onlyselectedvalues ;
   private String Combo_subtipoconcod2_Selectalltext ;
   private String Combo_subtipoconcod2_Multiplevaluesseparator ;
   private String Combo_subtipoconcod2_Addnewoptiontext ;
   private String Combo_concondicion_Objectcall ;
   private String Combo_concondicion_Class ;
   private String Combo_concondicion_Icontype ;
   private String Combo_concondicion_Icon ;
   private String Combo_concondicion_Tooltip ;
   private String Combo_concondicion_Selectedvalue_set ;
   private String Combo_concondicion_Selectedtext_set ;
   private String Combo_concondicion_Selectedtext_get ;
   private String Combo_concondicion_Gamoauthtoken ;
   private String Combo_concondicion_Ddointernalname ;
   private String Combo_concondicion_Titlecontrolalign ;
   private String Combo_concondicion_Dropdownoptionstype ;
   private String Combo_concondicion_Titlecontrolidtoreplace ;
   private String Combo_concondicion_Datalisttype ;
   private String Combo_concondicion_Datalistfixedvalues ;
   private String Combo_concondicion_Remoteservicesparameters ;
   private String Combo_concondicion_Htmltemplate ;
   private String Combo_concondicion_Multiplevaluestype ;
   private String Combo_concondicion_Loadingdata ;
   private String Combo_concondicion_Noresultsfound ;
   private String Combo_concondicion_Emptyitemtext ;
   private String Combo_concondicion_Onlyselectedvalues ;
   private String Combo_concondicion_Selectalltext ;
   private String Combo_concondicion_Multiplevaluesseparator ;
   private String Combo_concondicion_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode7 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean Z159ConVariable ;
   private boolean Z146ConForEditable ;
   private boolean Z762ConRecalcular ;
   private boolean Z1068ConMostrarPos ;
   private boolean Z1194ConSegunPla ;
   private boolean Z1821ConErrorSiCero ;
   private boolean Z1826ConPueNov ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1112AplIIGG ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean n953ConCondicion ;
   private boolean n1822CliPadre ;
   private boolean n1644ConceptoPais ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean n921ConPadre ;
   private boolean wbErr ;
   private boolean A159ConVariable ;
   private boolean A146ConForEditable ;
   private boolean n146ConForEditable ;
   private boolean A762ConRecalcular ;
   private boolean A1068ConMostrarPos ;
   private boolean n1077ConAdelDescu ;
   private boolean A1194ConSegunPla ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_tipoconcod_Emptyitem ;
   private boolean n503ConTipoLiqAux ;
   private boolean n970ConClasifAux ;
   private boolean n42ConCodYDesc ;
   private boolean A1821ConErrorSiCero ;
   private boolean A1826ConPueNov ;
   private boolean Combo_tipoconcod_Enabled ;
   private boolean Combo_tipoconcod_Visible ;
   private boolean Combo_tipoconcod_Allowmultipleselection ;
   private boolean Combo_tipoconcod_Isgriditem ;
   private boolean Combo_tipoconcod_Hasdescription ;
   private boolean Combo_tipoconcod_Includeonlyselectedoption ;
   private boolean Combo_tipoconcod_Includeselectalloption ;
   private boolean Combo_tipoconcod_Includeaddnewoption ;
   private boolean Combo_subtipoconcod1_Enabled ;
   private boolean Combo_subtipoconcod1_Visible ;
   private boolean Combo_subtipoconcod1_Allowmultipleselection ;
   private boolean Combo_subtipoconcod1_Isgriditem ;
   private boolean Combo_subtipoconcod1_Hasdescription ;
   private boolean Combo_subtipoconcod1_Includeonlyselectedoption ;
   private boolean Combo_subtipoconcod1_Includeselectalloption ;
   private boolean Combo_subtipoconcod1_Emptyitem ;
   private boolean Combo_subtipoconcod1_Includeaddnewoption ;
   private boolean Combo_subtipoconcod2_Enabled ;
   private boolean Combo_subtipoconcod2_Visible ;
   private boolean Combo_subtipoconcod2_Allowmultipleselection ;
   private boolean Combo_subtipoconcod2_Isgriditem ;
   private boolean Combo_subtipoconcod2_Hasdescription ;
   private boolean Combo_subtipoconcod2_Includeonlyselectedoption ;
   private boolean Combo_subtipoconcod2_Includeselectalloption ;
   private boolean Combo_subtipoconcod2_Emptyitem ;
   private boolean Combo_subtipoconcod2_Includeaddnewoption ;
   private boolean Combo_concondicion_Enabled ;
   private boolean Combo_concondicion_Visible ;
   private boolean Combo_concondicion_Allowmultipleselection ;
   private boolean Combo_concondicion_Isgriditem ;
   private boolean Combo_concondicion_Hasdescription ;
   private boolean Combo_concondicion_Includeonlyselectedoption ;
   private boolean Combo_concondicion_Includeselectalloption ;
   private boolean Combo_concondicion_Emptyitem ;
   private boolean Combo_concondicion_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n148ConFormula ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String A148ConFormula ;
   private String A153ConObservacion ;
   private String A569ConFormulaExpl ;
   private String AV25Combo_DataJson ;
   private String Z148ConFormula ;
   private String Z153ConObservacion ;
   private String Z569ConFormulaExpl ;
   private String Z42ConCodYDesc ;
   private String Z41ConDescrip ;
   private String Z503ConTipoLiqAux ;
   private String Z970ConClasifAux ;
   private String Z1018ConRangoCant ;
   private String A41ConDescrip ;
   private String A503ConTipoLiqAux ;
   private String A970ConClasifAux ;
   private String A1018ConRangoCant ;
   private String A42ConCodYDesc ;
   private String AV23ComboSelectedValue ;
   private String AV24ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_tipoconcod ;
   private com.genexus.webpanels.GXUserControl ucCombo_subtipoconcod1 ;
   private com.genexus.webpanels.GXUserControl ucCombo_subtipoconcod2 ;
   private com.genexus.webpanels.GXUserControl ucCombo_concondicion ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
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
   private HTMLChoice cmbConBaseFer ;
   private HTMLChoice cmbConBaseHorExt ;
   private HTMLChoice cmbavCombotipoconcod ;
   private HTMLChoice cmbavComboconcondicion ;
   private IDataStoreProvider pr_default ;
   private String[] T005712_A42ConCodYDesc ;
   private boolean[] T005712_n42ConCodYDesc ;
   private String[] T005712_A26ConCodigo ;
   private String[] T005712_A41ConDescrip ;
   private int[] T005712_A40ConOrden ;
   private byte[] T005712_A162ConVigencia ;
   private byte[] T005712_A1488ConLiqBasica ;
   private String[] T005712_A148ConFormula ;
   private boolean[] T005712_n148ConFormula ;
   private String[] T005712_A153ConObservacion ;
   private boolean[] T005712_A159ConVariable ;
   private boolean[] T005712_A146ConForEditable ;
   private boolean[] T005712_n146ConForEditable ;
   private String[] T005712_A503ConTipoLiqAux ;
   private boolean[] T005712_n503ConTipoLiqAux ;
   private String[] T005712_A970ConClasifAux ;
   private boolean[] T005712_n970ConClasifAux ;
   private long[] T005712_A510ConOrdEjec ;
   private String[] T005712_A569ConFormulaExpl ;
   private boolean[] T005712_A762ConRecalcular ;
   private String[] T005712_A1018ConRangoCant ;
   private String[] T005712_A954ConCondCodigo ;
   private boolean[] T005712_A1068ConMostrarPos ;
   private byte[] T005712_A1077ConAdelDescu ;
   private boolean[] T005712_n1077ConAdelDescu ;
   private boolean[] T005712_A1194ConSegunPla ;
   private byte[] T005712_A1471ConNumero ;
   private String[] T005712_A1648ConCodAfip ;
   private byte[] T005712_A1472ConSIPAApo ;
   private byte[] T005712_A1473ConSIPACont ;
   private byte[] T005712_A1474ConINSSJyPApo ;
   private byte[] T005712_A1475ConINSSJyPCont ;
   private byte[] T005712_A1476ConObraSocApo ;
   private byte[] T005712_A1477ConObraSocCont ;
   private byte[] T005712_A1478ConFonSolRedApo ;
   private byte[] T005712_A1479ConFonSolRedCont ;
   private byte[] T005712_A1480ConRenateaApo ;
   private byte[] T005712_A1481ConRenateaCont ;
   private byte[] T005712_A1482ConAsigFamCont ;
   private byte[] T005712_A1483ConFonNacEmpCont ;
   private byte[] T005712_A1484ConLeyRieTrabCont ;
   private byte[] T005712_A1485ConRegDifApo ;
   private byte[] T005712_A1486ConRegEspApo ;
   private byte[] T005712_A1539ConSacDeven ;
   private byte[] T005712_A1620ConBaseLic ;
   private byte[] T005712_A1797ConBaseLicProm ;
   private byte[] T005712_A1621ConBaseFer ;
   private byte[] T005712_A1798ConBaseFerProm ;
   private byte[] T005712_A1622ConBaseHorExt ;
   private byte[] T005712_A1799ConBaseHorExtProm ;
   private byte[] T005712_A1800ConBasePres ;
   private byte[] T005712_A1801ConBaseAnt ;
   private byte[] T005712_A1827ConBaseOSDif ;
   private boolean[] T005712_A1821ConErrorSiCero ;
   private boolean[] T005712_A1826ConPueNov ;
   private int[] T005712_A1822CliPadre ;
   private boolean[] T005712_n1822CliPadre ;
   private int[] T005712_A3CliCod ;
   private short[] T005712_A1112AplIIGG ;
   private boolean[] T005712_n1112AplIIGG ;
   private String[] T005712_A37TipoConCod ;
   private String[] T005712_A38SubTipoConCod1 ;
   private boolean[] T005712_n38SubTipoConCod1 ;
   private String[] T005712_A39SubTipoConCod2 ;
   private boolean[] T005712_n39SubTipoConCod2 ;
   private String[] T005712_A953ConCondicion ;
   private boolean[] T005712_n953ConCondicion ;
   private short[] T005712_A1644ConceptoPais ;
   private boolean[] T005712_n1644ConceptoPais ;
   private String[] T005712_A1645ConceptoConveCodigo ;
   private boolean[] T005712_n1645ConceptoConveCodigo ;
   private String[] T005712_A921ConPadre ;
   private boolean[] T005712_n921ConPadre ;
   private int[] T00574_A3CliCod ;
   private String[] T00576_A37TipoConCod ;
   private String[] T00577_A37TipoConCod ;
   private String[] T00578_A37TipoConCod ;
   private String[] T00579_A953ConCondicion ;
   private boolean[] T00579_n953ConCondicion ;
   private int[] T00575_A3CliCod ;
   private short[] T005710_A1644ConceptoPais ;
   private boolean[] T005710_n1644ConceptoPais ;
   private int[] T005711_A1822CliPadre ;
   private boolean[] T005711_n1822CliPadre ;
   private int[] T005713_A3CliCod ;
   private String[] T005714_A37TipoConCod ;
   private String[] T005715_A37TipoConCod ;
   private String[] T005716_A37TipoConCod ;
   private String[] T005717_A953ConCondicion ;
   private boolean[] T005717_n953ConCondicion ;
   private int[] T005718_A3CliCod ;
   private short[] T005719_A1644ConceptoPais ;
   private boolean[] T005719_n1644ConceptoPais ;
   private int[] T005720_A1822CliPadre ;
   private boolean[] T005720_n1822CliPadre ;
   private int[] T005721_A3CliCod ;
   private String[] T005721_A26ConCodigo ;
   private String[] T00573_A42ConCodYDesc ;
   private boolean[] T00573_n42ConCodYDesc ;
   private String[] T00573_A26ConCodigo ;
   private String[] T00573_A41ConDescrip ;
   private int[] T00573_A40ConOrden ;
   private byte[] T00573_A162ConVigencia ;
   private byte[] T00573_A1488ConLiqBasica ;
   private String[] T00573_A148ConFormula ;
   private boolean[] T00573_n148ConFormula ;
   private String[] T00573_A153ConObservacion ;
   private boolean[] T00573_A159ConVariable ;
   private boolean[] T00573_A146ConForEditable ;
   private boolean[] T00573_n146ConForEditable ;
   private String[] T00573_A503ConTipoLiqAux ;
   private boolean[] T00573_n503ConTipoLiqAux ;
   private String[] T00573_A970ConClasifAux ;
   private boolean[] T00573_n970ConClasifAux ;
   private long[] T00573_A510ConOrdEjec ;
   private String[] T00573_A569ConFormulaExpl ;
   private boolean[] T00573_A762ConRecalcular ;
   private String[] T00573_A1018ConRangoCant ;
   private String[] T00573_A954ConCondCodigo ;
   private boolean[] T00573_A1068ConMostrarPos ;
   private byte[] T00573_A1077ConAdelDescu ;
   private boolean[] T00573_n1077ConAdelDescu ;
   private boolean[] T00573_A1194ConSegunPla ;
   private byte[] T00573_A1471ConNumero ;
   private String[] T00573_A1648ConCodAfip ;
   private byte[] T00573_A1472ConSIPAApo ;
   private byte[] T00573_A1473ConSIPACont ;
   private byte[] T00573_A1474ConINSSJyPApo ;
   private byte[] T00573_A1475ConINSSJyPCont ;
   private byte[] T00573_A1476ConObraSocApo ;
   private byte[] T00573_A1477ConObraSocCont ;
   private byte[] T00573_A1478ConFonSolRedApo ;
   private byte[] T00573_A1479ConFonSolRedCont ;
   private byte[] T00573_A1480ConRenateaApo ;
   private byte[] T00573_A1481ConRenateaCont ;
   private byte[] T00573_A1482ConAsigFamCont ;
   private byte[] T00573_A1483ConFonNacEmpCont ;
   private byte[] T00573_A1484ConLeyRieTrabCont ;
   private byte[] T00573_A1485ConRegDifApo ;
   private byte[] T00573_A1486ConRegEspApo ;
   private byte[] T00573_A1539ConSacDeven ;
   private byte[] T00573_A1620ConBaseLic ;
   private byte[] T00573_A1797ConBaseLicProm ;
   private byte[] T00573_A1621ConBaseFer ;
   private byte[] T00573_A1798ConBaseFerProm ;
   private byte[] T00573_A1622ConBaseHorExt ;
   private byte[] T00573_A1799ConBaseHorExtProm ;
   private byte[] T00573_A1800ConBasePres ;
   private byte[] T00573_A1801ConBaseAnt ;
   private byte[] T00573_A1827ConBaseOSDif ;
   private boolean[] T00573_A1821ConErrorSiCero ;
   private boolean[] T00573_A1826ConPueNov ;
   private int[] T00573_A1822CliPadre ;
   private boolean[] T00573_n1822CliPadre ;
   private int[] T00573_A3CliCod ;
   private short[] T00573_A1112AplIIGG ;
   private boolean[] T00573_n1112AplIIGG ;
   private String[] T00573_A37TipoConCod ;
   private String[] T00573_A38SubTipoConCod1 ;
   private boolean[] T00573_n38SubTipoConCod1 ;
   private String[] T00573_A39SubTipoConCod2 ;
   private boolean[] T00573_n39SubTipoConCod2 ;
   private String[] T00573_A953ConCondicion ;
   private boolean[] T00573_n953ConCondicion ;
   private short[] T00573_A1644ConceptoPais ;
   private boolean[] T00573_n1644ConceptoPais ;
   private String[] T00573_A1645ConceptoConveCodigo ;
   private boolean[] T00573_n1645ConceptoConveCodigo ;
   private String[] T00573_A921ConPadre ;
   private boolean[] T00573_n921ConPadre ;
   private int[] T005722_A3CliCod ;
   private String[] T005722_A26ConCodigo ;
   private int[] T005723_A3CliCod ;
   private String[] T005723_A26ConCodigo ;
   private String[] T00572_A42ConCodYDesc ;
   private boolean[] T00572_n42ConCodYDesc ;
   private String[] T00572_A26ConCodigo ;
   private String[] T00572_A41ConDescrip ;
   private int[] T00572_A40ConOrden ;
   private byte[] T00572_A162ConVigencia ;
   private byte[] T00572_A1488ConLiqBasica ;
   private String[] T00572_A148ConFormula ;
   private boolean[] T00572_n148ConFormula ;
   private String[] T00572_A153ConObservacion ;
   private boolean[] T00572_A159ConVariable ;
   private boolean[] T00572_A146ConForEditable ;
   private boolean[] T00572_n146ConForEditable ;
   private String[] T00572_A503ConTipoLiqAux ;
   private boolean[] T00572_n503ConTipoLiqAux ;
   private String[] T00572_A970ConClasifAux ;
   private boolean[] T00572_n970ConClasifAux ;
   private long[] T00572_A510ConOrdEjec ;
   private String[] T00572_A569ConFormulaExpl ;
   private boolean[] T00572_A762ConRecalcular ;
   private String[] T00572_A1018ConRangoCant ;
   private String[] T00572_A954ConCondCodigo ;
   private boolean[] T00572_A1068ConMostrarPos ;
   private byte[] T00572_A1077ConAdelDescu ;
   private boolean[] T00572_n1077ConAdelDescu ;
   private boolean[] T00572_A1194ConSegunPla ;
   private byte[] T00572_A1471ConNumero ;
   private String[] T00572_A1648ConCodAfip ;
   private byte[] T00572_A1472ConSIPAApo ;
   private byte[] T00572_A1473ConSIPACont ;
   private byte[] T00572_A1474ConINSSJyPApo ;
   private byte[] T00572_A1475ConINSSJyPCont ;
   private byte[] T00572_A1476ConObraSocApo ;
   private byte[] T00572_A1477ConObraSocCont ;
   private byte[] T00572_A1478ConFonSolRedApo ;
   private byte[] T00572_A1479ConFonSolRedCont ;
   private byte[] T00572_A1480ConRenateaApo ;
   private byte[] T00572_A1481ConRenateaCont ;
   private byte[] T00572_A1482ConAsigFamCont ;
   private byte[] T00572_A1483ConFonNacEmpCont ;
   private byte[] T00572_A1484ConLeyRieTrabCont ;
   private byte[] T00572_A1485ConRegDifApo ;
   private byte[] T00572_A1486ConRegEspApo ;
   private byte[] T00572_A1539ConSacDeven ;
   private byte[] T00572_A1620ConBaseLic ;
   private byte[] T00572_A1797ConBaseLicProm ;
   private byte[] T00572_A1621ConBaseFer ;
   private byte[] T00572_A1798ConBaseFerProm ;
   private byte[] T00572_A1622ConBaseHorExt ;
   private byte[] T00572_A1799ConBaseHorExtProm ;
   private byte[] T00572_A1800ConBasePres ;
   private byte[] T00572_A1801ConBaseAnt ;
   private byte[] T00572_A1827ConBaseOSDif ;
   private boolean[] T00572_A1821ConErrorSiCero ;
   private boolean[] T00572_A1826ConPueNov ;
   private int[] T00572_A1822CliPadre ;
   private boolean[] T00572_n1822CliPadre ;
   private int[] T00572_A3CliCod ;
   private short[] T00572_A1112AplIIGG ;
   private boolean[] T00572_n1112AplIIGG ;
   private String[] T00572_A37TipoConCod ;
   private String[] T00572_A38SubTipoConCod1 ;
   private boolean[] T00572_n38SubTipoConCod1 ;
   private String[] T00572_A39SubTipoConCod2 ;
   private boolean[] T00572_n39SubTipoConCod2 ;
   private String[] T00572_A953ConCondicion ;
   private boolean[] T00572_n953ConCondicion ;
   private short[] T00572_A1644ConceptoPais ;
   private boolean[] T00572_n1644ConceptoPais ;
   private String[] T00572_A1645ConceptoConveCodigo ;
   private boolean[] T00572_n1645ConceptoConveCodigo ;
   private String[] T00572_A921ConPadre ;
   private boolean[] T00572_n921ConPadre ;
   private int[] T005727_A1822CliPadre ;
   private boolean[] T005727_n1822CliPadre ;
   private String[] T005727_A921ConPadre ;
   private boolean[] T005727_n921ConPadre ;
   private short[] T005728_A46PaiCod ;
   private byte[] T005728_A1440PaiBaseClaseLeg ;
   private String[] T005728_A1441PaiBaseTipo ;
   private String[] T005728_A1442PaiBaseCod1 ;
   private String[] T005728_A1443PaiBaseCod2 ;
   private int[] T005728_A1445PaiBaseCliCod ;
   private String[] T005728_A1446PaiBaseConCodigo ;
   private short[] T005729_A46PaiCod ;
   private int[] T005729_A1356PaiMenCliCod ;
   private String[] T005729_A1358PaiMesConCodigo ;
   private short[] T005730_A46PaiCod ;
   private int[] T005730_A1354PaiJorCliCod ;
   private String[] T005730_A1355PaiJorConCodigo ;
   private int[] T005731_A3CliCod ;
   private short[] T005731_A1EmpCod ;
   private int[] T005731_A6LegNumero ;
   private short[] T005731_A1135LegSuelSec ;
   private String[] T005731_A2349LegSuelConcepto ;
   private int[] T005732_A3CliCod ;
   private String[] T005732_A26ConCodigo ;
   private String[] T005732_A2119ConOpeId ;
   private String[] T005732_A923ConOperFor ;
   private int[] T005733_A3CliCod ;
   private String[] T005733_A26ConCodigo ;
   private String[] T005733_A11MegCodigo ;
   private short[] T005733_A2077ConMegSec ;
   private int[] T005734_A3CliCod ;
   private short[] T005734_A1EmpCod ;
   private int[] T005734_A6LegNumero ;
   private String[] T005734_A1829PreliqTLiqCod ;
   private java.util.Date[] T005734_A1830PreliqPeriodo ;
   private String[] T005734_A1831PreliqConcepto ;
   private int[] T005735_A3CliCod ;
   private short[] T005735_A1564CliPaiConve ;
   private String[] T005735_A1565CliConvenio ;
   private short[] T005735_A1327ConveHsExSec ;
   private int[] T005736_A3CliCod ;
   private short[] T005736_A1564CliPaiConve ;
   private String[] T005736_A1565CliConvenio ;
   private int[] T005736_A1381ConveMenCliCod ;
   private String[] T005736_A1375ConveMenConCodigo ;
   private int[] T005737_A3CliCod ;
   private short[] T005737_A1EmpCod ;
   private int[] T005737_A31LiqNro ;
   private int[] T005737_A6LegNumero ;
   private short[] T005737_A1541LiqAjuNro ;
   private short[] T005737_A1543LiqAjuSec ;
   private int[] T005738_A3CliCod ;
   private short[] T005738_A1EmpCod ;
   private String[] T005738_A1366EmpJorConCodigo ;
   private int[] T005739_A3CliCod ;
   private short[] T005739_A1EmpCod ;
   private String[] T005739_A1368EmpMenConCodigo ;
   private int[] T005740_A3CliCod ;
   private short[] T005740_A1EmpCod ;
   private int[] T005740_A6LegNumero ;
   private short[] T005740_A1172OblSecuencial ;
   private String[] T005740_A1170OblExcConCOdigo ;
   private int[] T005741_A3CliCod ;
   private short[] T005741_A1EmpCod ;
   private int[] T005741_A6LegNumero ;
   private short[] T005741_A1172OblSecuencial ;
   private int[] T005742_A3CliCod ;
   private short[] T005742_A1EmpCod ;
   private int[] T005742_A6LegNumero ;
   private short[] T005742_A1172OblSecuencial ;
   private int[] T005743_A3CliCod ;
   private short[] T005743_A1EmpCod ;
   private short[] T005743_A1129LiqExAnio ;
   private int[] T005743_A31LiqNro ;
   private int[] T005743_A6LegNumero ;
   private String[] T005743_A1127LiqExenConCodigo ;
   private short[] T005743_A1128LiqExAplIIGG ;
   private int[] T005744_A3CliCod ;
   private short[] T005744_A1112AplIIGG ;
   private boolean[] T005744_n1112AplIIGG ;
   private int[] T005745_A3CliCod ;
   private short[] T005745_A1112AplIIGG ;
   private boolean[] T005745_n1112AplIIGG ;
   private int[] T005746_A3CliCod ;
   private short[] T005746_A1112AplIIGG ;
   private boolean[] T005746_n1112AplIIGG ;
   private int[] T005747_A3CliCod ;
   private String[] T005747_A1105CondExenIIGG ;
   private int[] T005748_A3CliCod ;
   private String[] T005748_A1101SiraTipo ;
   private String[] T005748_A1102SiraCodigo ;
   private int[] T005749_A3CliCod ;
   private short[] T005749_A1EmpCod ;
   private short[] T005749_A869LiqLegConAnio ;
   private int[] T005749_A6LegNumero ;
   private String[] T005749_A26ConCodigo ;
   private int[] T005749_A1097LiqAltaNro ;
   private int[] T005749_A1098LiqNuevaNro ;
   private int[] T005750_A3CliCod ;
   private short[] T005750_A1EmpCod ;
   private int[] T005750_A6LegNumero ;
   private int[] T005750_A83LegDedSec ;
   private int[] T005751_A3CliCod ;
   private String[] T005751_A26ConCodigo ;
   private short[] T005751_A51ForHisNum ;
   private int[] T005752_A3CliCod ;
   private String[] T005752_A26ConCodigo ;
   private String[] T005752_A32TLiqCod ;
   private int[] T005753_A3CliCod ;
   private short[] T005753_A1EmpCod ;
   private int[] T005753_A6LegNumero ;
   private short[] T005753_A25AgeOrden ;
   private int[] T005754_A3CliCod ;
   private String[] T005754_A26ConCodigo ;
   private String[] T005755_A37TipoConCod ;
   private String[] T005756_A37TipoConCod ;
   private String[] T005757_A37TipoConCod ;
   private String[] T005758_A953ConCondicion ;
   private boolean[] T005758_n953ConCondicion ;
   private int[] T005759_A3CliCod ;
   private short[] T005760_A1644ConceptoPais ;
   private boolean[] T005760_n1644ConceptoPais ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV21TipoConCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV27SubTipoConCod1_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV30SubTipoConCod2_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV34ConCondicion_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV20TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV22DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class conceptos_export__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00572", "SELECT ConCodYDesc, ConCodigo, ConDescrip, ConOrden, ConVigencia, ConLiqBasica, ConFormula, ConObservacion, ConVariable, ConForEditable, ConTipoLiqAux, ConClasifAux, ConOrdEjec, ConFormulaExpl, ConRecalcular, ConRangoCant, ConCondCodigo, ConMostrarPos, ConAdelDescu, ConSegunPla, ConNumero, ConCodAfip, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConSacDeven, ConBaseLic, ConBaseLicProm, ConBaseFer, ConBaseFerProm, ConBaseHorExt, ConBaseHorExtProm, ConBasePres, ConBaseAnt, ConBaseOSDif, ConErrorSiCero, ConPueNov, CliPadre, CliCod, AplIIGG, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConCondicion, ConceptoPais, ConceptoConveCodigo, ConPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ?  FOR UPDATE OF Concepto NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00573", "SELECT ConCodYDesc, ConCodigo, ConDescrip, ConOrden, ConVigencia, ConLiqBasica, ConFormula, ConObservacion, ConVariable, ConForEditable, ConTipoLiqAux, ConClasifAux, ConOrdEjec, ConFormulaExpl, ConRecalcular, ConRangoCant, ConCondCodigo, ConMostrarPos, ConAdelDescu, ConSegunPla, ConNumero, ConCodAfip, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConSacDeven, ConBaseLic, ConBaseLicProm, ConBaseFer, ConBaseFerProm, ConBaseHorExt, ConBaseHorExtProm, ConBasePres, ConBaseAnt, ConBaseOSDif, ConErrorSiCero, ConPueNov, CliPadre, CliCod, AplIIGG, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConCondicion, ConceptoPais, ConceptoConveCodigo, ConPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00574", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00575", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00576", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00577", "SELECT TipoConCod FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ? AND SubTipoConCod1 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00578", "SELECT TipoConCod FROM tipo_concepto_subtipo2 WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00579", "SELECT ConCondicion FROM Condiciones_concepto WHERE ConCondicion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005710", "SELECT PaiCod AS ConceptoPais FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005711", "SELECT CliCod AS CliPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005712", "SELECT TM1.ConCodYDesc, TM1.ConCodigo, TM1.ConDescrip, TM1.ConOrden, TM1.ConVigencia, TM1.ConLiqBasica, TM1.ConFormula, TM1.ConObservacion, TM1.ConVariable, TM1.ConForEditable, TM1.ConTipoLiqAux, TM1.ConClasifAux, TM1.ConOrdEjec, TM1.ConFormulaExpl, TM1.ConRecalcular, TM1.ConRangoCant, TM1.ConCondCodigo, TM1.ConMostrarPos, TM1.ConAdelDescu, TM1.ConSegunPla, TM1.ConNumero, TM1.ConCodAfip, TM1.ConSIPAApo, TM1.ConSIPACont, TM1.ConINSSJyPApo, TM1.ConINSSJyPCont, TM1.ConObraSocApo, TM1.ConObraSocCont, TM1.ConFonSolRedApo, TM1.ConFonSolRedCont, TM1.ConRenateaApo, TM1.ConRenateaCont, TM1.ConAsigFamCont, TM1.ConFonNacEmpCont, TM1.ConLeyRieTrabCont, TM1.ConRegDifApo, TM1.ConRegEspApo, TM1.ConSacDeven, TM1.ConBaseLic, TM1.ConBaseLicProm, TM1.ConBaseFer, TM1.ConBaseFerProm, TM1.ConBaseHorExt, TM1.ConBaseHorExtProm, TM1.ConBasePres, TM1.ConBaseAnt, TM1.ConBaseOSDif, TM1.ConErrorSiCero, TM1.ConPueNov, TM1.CliPadre AS CliPadre, TM1.CliCod, TM1.AplIIGG, TM1.TipoConCod, TM1.SubTipoConCod1, TM1.SubTipoConCod2, TM1.ConCondicion, TM1.ConceptoPais AS ConceptoPais, TM1.ConceptoConveCodigo AS ConceptoConveCodigo, TM1.ConPadre AS ConPadre FROM Concepto TM1 WHERE TM1.CliCod = ? and TM1.ConCodigo = ( ?) ORDER BY TM1.CliCod, TM1.ConCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005713", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005714", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005715", "SELECT TipoConCod FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ? AND SubTipoConCod1 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005716", "SELECT TipoConCod FROM tipo_concepto_subtipo2 WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005717", "SELECT ConCondicion FROM Condiciones_concepto WHERE ConCondicion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005718", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005719", "SELECT PaiCod AS ConceptoPais FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005720", "SELECT CliCod AS CliPadre FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005721", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005722", "SELECT CliCod, ConCodigo FROM Concepto WHERE ( CliCod > ? or CliCod = ? and ConCodigo > ( ?)) ORDER BY CliCod, ConCodigo  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005723", "SELECT CliCod, ConCodigo FROM Concepto WHERE ( CliCod < ? or CliCod = ? and ConCodigo < ( ?)) ORDER BY CliCod DESC, ConCodigo DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005724", "SAVEPOINT gxupdate;INSERT INTO Concepto(ConCodYDesc, ConCodigo, ConDescrip, ConOrden, ConVigencia, ConLiqBasica, ConFormula, ConObservacion, ConVariable, ConForEditable, ConTipoLiqAux, ConClasifAux, ConOrdEjec, ConFormulaExpl, ConRecalcular, ConRangoCant, ConCondCodigo, ConMostrarPos, ConAdelDescu, ConSegunPla, ConNumero, ConCodAfip, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo, ConSacDeven, ConBaseLic, ConBaseLicProm, ConBaseFer, ConBaseFerProm, ConBaseHorExt, ConBaseHorExtProm, ConBasePres, ConBaseAnt, ConBaseOSDif, ConErrorSiCero, ConPueNov, CliPadre, CliCod, AplIIGG, TipoConCod, SubTipoConCod1, SubTipoConCod2, ConCondicion, ConceptoPais, ConceptoConveCodigo, ConPadre, ConHabilitado, ConCanti, ConValUni, ConImporte, ConValorGen, ConTipoLiqGanancias, ConHisFormula, ConUsuModFor, ConFchModFor, ConTipo, ConCodOld, ConCuenDebe, ConCuenHaber, ConFormulaObs2, ConFormulaPreResuelta, ConRetGanPropor, ConAplicGan, ConImportado, ConTipoOrden, ConUsado, ConObliga, ConObligaSiSac, ConConveAux, ConEdiEnRec, ConPreReq, ConCntPa, ConRelSec, ConRelSecCli, ConOldValues, ConRelRef, ConBaseAus, ConBaseAusProm, ConDescripSinAc, ConOblPalabra) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE, FALSE, FALSE, FALSE, 0, '', '', '', DATE '00010101', 0, '', '', '', '', '', FALSE, 0, FALSE, 0, FALSE, FALSE, FALSE, '', FALSE, '', 0, 0, 0, '', '', 0, 0, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005725", "SAVEPOINT gxupdate;UPDATE Concepto SET ConCodYDesc=?, ConDescrip=?, ConOrden=?, ConVigencia=?, ConLiqBasica=?, ConFormula=?, ConObservacion=?, ConVariable=?, ConForEditable=?, ConTipoLiqAux=?, ConClasifAux=?, ConOrdEjec=?, ConFormulaExpl=?, ConRecalcular=?, ConRangoCant=?, ConCondCodigo=?, ConMostrarPos=?, ConAdelDescu=?, ConSegunPla=?, ConNumero=?, ConCodAfip=?, ConSIPAApo=?, ConSIPACont=?, ConINSSJyPApo=?, ConINSSJyPCont=?, ConObraSocApo=?, ConObraSocCont=?, ConFonSolRedApo=?, ConFonSolRedCont=?, ConRenateaApo=?, ConRenateaCont=?, ConAsigFamCont=?, ConFonNacEmpCont=?, ConLeyRieTrabCont=?, ConRegDifApo=?, ConRegEspApo=?, ConSacDeven=?, ConBaseLic=?, ConBaseLicProm=?, ConBaseFer=?, ConBaseFerProm=?, ConBaseHorExt=?, ConBaseHorExtProm=?, ConBasePres=?, ConBaseAnt=?, ConBaseOSDif=?, ConErrorSiCero=?, ConPueNov=?, CliPadre=?, AplIIGG=?, TipoConCod=?, SubTipoConCod1=?, SubTipoConCod2=?, ConCondicion=?, ConceptoPais=?, ConceptoConveCodigo=?, ConPadre=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005726", "SAVEPOINT gxupdate;DELETE FROM Concepto  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005727", "SELECT CliCod AS CliPadre, ConCodigo AS ConPadre FROM Concepto WHERE CliPadre = ? AND ConPadre = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005728", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseCliCod, PaiBaseConCodigo FROM Paisbase_calculoactual WHERE PaiBaseCliCod = ? AND PaiBaseConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005729", "SELECT PaiCod, PaiMenCliCod, PaiMesConCodigo FROM Paisconceptos_horanormal_mensualizados WHERE PaiMenCliCod = ? AND PaiMesConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005730", "SELECT PaiCod, PaiJorCliCod, PaiJorConCodigo FROM Paisconceptos_horanormal_jornalizados WHERE PaiJorCliCod = ? AND PaiJorConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005731", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelConcepto FROM Legajo_sueldosConceptos WHERE CliCod = ? AND LegSuelConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005732", "SELECT CliCod, ConCodigo, ConOpeId, ConOperFor FROM concepto_operandos WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005733", "SELECT CliCod, ConCodigo, MegCodigo, ConMegSec FROM ConceptoMotivosEgreso WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005734", "SELECT CliCod, EmpCod, LegNumero, PreliqTLiqCod, PreliqPeriodo, PreliqConcepto FROM LegPreliqConceptosExclu WHERE CliCod = ? AND PreliqConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005735", "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsExSec FROM Convenio_horasextras_porDia WHERE CliCod = ? AND ConveHSPDiaConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005736", "SELECT CliCod, CliPaiConve, CliConvenio, ConveMenCliCod, ConveMenConCodigo FROM Convenio_conceptos_horanormal_mensualiza WHERE ConveMenCliCod = ? AND ConveMenConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005737", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro, LiqAjuSec FROM LiquidacionAjustedetalle WHERE CliCod = ? AND LiqAjuConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005738", "SELECT CliCod, EmpCod, EmpJorConCodigo FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpJorConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005739", "SELECT CliCod, EmpCod, EmpMenConCodigo FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpMenConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005740", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, OblExcConCOdigo FROM ObligacionExcepciones WHERE CliCod = ? AND OblExcConCOdigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005741", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND OblConcepto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005742", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND OblConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005743", "SELECT CliCod, EmpCod, LiqExAnio, LiqNro, LegNumero, LiqExenConCodigo, LiqExAplIIGG FROM liquidacion_exencion WHERE CliCod = ? AND LiqExenConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005744", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND ApliIIGGExenOtr = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005745", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGGExenCon = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005746", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGGTopeCon = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005747", "SELECT CliCod, CondExenIIGG FROM condicion_exencion_iigg WHERE CliCod = ? AND CondExenIIGGCon = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005748", "SELECT CliCod, SiraTipo, SiraCodigo FROM siradig_codigos WHERE CliCod = ? AND SiraConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005749", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005750", "SELECT CliCod, EmpCod, LegNumero, LegDedSec FROM legajo_deducciones WHERE CliCod = ? AND LegDedConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005751", "SELECT CliCod, ConCodigo, ForHisNum FROM FormulaHistorico WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005752", "SELECT CliCod, ConCodigo, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005753", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? AND ConCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005754", "SELECT CliCod, ConCodigo FROM Concepto ORDER BY CliCod, ConCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005755", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005756", "SELECT TipoConCod FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ? AND SubTipoConCod1 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005757", "SELECT TipoConCod FROM tipo_concepto_subtipo2 WHERE TipoConCod = ? AND SubTipoConCod1 = ? AND SubTipoConCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005758", "SELECT ConCondicion FROM Condiciones_concepto WHERE ConCondicion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005759", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005760", "SELECT PaiCod AS ConceptoPais FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((byte[]) buf[6])[0] = rslt.getByte(6);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((long[]) buf[17])[0] = rslt.getLong(13);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((boolean[]) buf[22])[0] = rslt.getBoolean(18);
               ((byte[]) buf[23])[0] = rslt.getByte(19);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(20);
               ((byte[]) buf[26])[0] = rslt.getByte(21);
               ((String[]) buf[27])[0] = rslt.getString(22, 6);
               ((byte[]) buf[28])[0] = rslt.getByte(23);
               ((byte[]) buf[29])[0] = rslt.getByte(24);
               ((byte[]) buf[30])[0] = rslt.getByte(25);
               ((byte[]) buf[31])[0] = rslt.getByte(26);
               ((byte[]) buf[32])[0] = rslt.getByte(27);
               ((byte[]) buf[33])[0] = rslt.getByte(28);
               ((byte[]) buf[34])[0] = rslt.getByte(29);
               ((byte[]) buf[35])[0] = rslt.getByte(30);
               ((byte[]) buf[36])[0] = rslt.getByte(31);
               ((byte[]) buf[37])[0] = rslt.getByte(32);
               ((byte[]) buf[38])[0] = rslt.getByte(33);
               ((byte[]) buf[39])[0] = rslt.getByte(34);
               ((byte[]) buf[40])[0] = rslt.getByte(35);
               ((byte[]) buf[41])[0] = rslt.getByte(36);
               ((byte[]) buf[42])[0] = rslt.getByte(37);
               ((byte[]) buf[43])[0] = rslt.getByte(38);
               ((byte[]) buf[44])[0] = rslt.getByte(39);
               ((byte[]) buf[45])[0] = rslt.getByte(40);
               ((byte[]) buf[46])[0] = rslt.getByte(41);
               ((byte[]) buf[47])[0] = rslt.getByte(42);
               ((byte[]) buf[48])[0] = rslt.getByte(43);
               ((byte[]) buf[49])[0] = rslt.getByte(44);
               ((byte[]) buf[50])[0] = rslt.getByte(45);
               ((byte[]) buf[51])[0] = rslt.getByte(46);
               ((byte[]) buf[52])[0] = rslt.getByte(47);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(49);
               ((int[]) buf[55])[0] = rslt.getInt(50);
               ((boolean[]) buf[56])[0] = rslt.wasNull();
               ((int[]) buf[57])[0] = rslt.getInt(51);
               ((short[]) buf[58])[0] = rslt.getShort(52);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((String[]) buf[60])[0] = rslt.getString(53, 20);
               ((String[]) buf[61])[0] = rslt.getString(54, 20);
               ((boolean[]) buf[62])[0] = rslt.wasNull();
               ((String[]) buf[63])[0] = rslt.getString(55, 20);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((String[]) buf[65])[0] = rslt.getString(56, 20);
               ((boolean[]) buf[66])[0] = rslt.wasNull();
               ((short[]) buf[67])[0] = rslt.getShort(57);
               ((boolean[]) buf[68])[0] = rslt.wasNull();
               ((String[]) buf[69])[0] = rslt.getString(58, 20);
               ((boolean[]) buf[70])[0] = rslt.wasNull();
               ((String[]) buf[71])[0] = rslt.getString(59, 10);
               ((boolean[]) buf[72])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((byte[]) buf[6])[0] = rslt.getByte(6);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((long[]) buf[17])[0] = rslt.getLong(13);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((boolean[]) buf[22])[0] = rslt.getBoolean(18);
               ((byte[]) buf[23])[0] = rslt.getByte(19);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(20);
               ((byte[]) buf[26])[0] = rslt.getByte(21);
               ((String[]) buf[27])[0] = rslt.getString(22, 6);
               ((byte[]) buf[28])[0] = rslt.getByte(23);
               ((byte[]) buf[29])[0] = rslt.getByte(24);
               ((byte[]) buf[30])[0] = rslt.getByte(25);
               ((byte[]) buf[31])[0] = rslt.getByte(26);
               ((byte[]) buf[32])[0] = rslt.getByte(27);
               ((byte[]) buf[33])[0] = rslt.getByte(28);
               ((byte[]) buf[34])[0] = rslt.getByte(29);
               ((byte[]) buf[35])[0] = rslt.getByte(30);
               ((byte[]) buf[36])[0] = rslt.getByte(31);
               ((byte[]) buf[37])[0] = rslt.getByte(32);
               ((byte[]) buf[38])[0] = rslt.getByte(33);
               ((byte[]) buf[39])[0] = rslt.getByte(34);
               ((byte[]) buf[40])[0] = rslt.getByte(35);
               ((byte[]) buf[41])[0] = rslt.getByte(36);
               ((byte[]) buf[42])[0] = rslt.getByte(37);
               ((byte[]) buf[43])[0] = rslt.getByte(38);
               ((byte[]) buf[44])[0] = rslt.getByte(39);
               ((byte[]) buf[45])[0] = rslt.getByte(40);
               ((byte[]) buf[46])[0] = rslt.getByte(41);
               ((byte[]) buf[47])[0] = rslt.getByte(42);
               ((byte[]) buf[48])[0] = rslt.getByte(43);
               ((byte[]) buf[49])[0] = rslt.getByte(44);
               ((byte[]) buf[50])[0] = rslt.getByte(45);
               ((byte[]) buf[51])[0] = rslt.getByte(46);
               ((byte[]) buf[52])[0] = rslt.getByte(47);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(49);
               ((int[]) buf[55])[0] = rslt.getInt(50);
               ((boolean[]) buf[56])[0] = rslt.wasNull();
               ((int[]) buf[57])[0] = rslt.getInt(51);
               ((short[]) buf[58])[0] = rslt.getShort(52);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((String[]) buf[60])[0] = rslt.getString(53, 20);
               ((String[]) buf[61])[0] = rslt.getString(54, 20);
               ((boolean[]) buf[62])[0] = rslt.wasNull();
               ((String[]) buf[63])[0] = rslt.getString(55, 20);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((String[]) buf[65])[0] = rslt.getString(56, 20);
               ((boolean[]) buf[66])[0] = rslt.wasNull();
               ((short[]) buf[67])[0] = rslt.getShort(57);
               ((boolean[]) buf[68])[0] = rslt.wasNull();
               ((String[]) buf[69])[0] = rslt.getString(58, 20);
               ((boolean[]) buf[70])[0] = rslt.wasNull();
               ((String[]) buf[71])[0] = rslt.getString(59, 10);
               ((boolean[]) buf[72])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((byte[]) buf[6])[0] = rslt.getByte(6);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((long[]) buf[17])[0] = rslt.getLong(13);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((boolean[]) buf[22])[0] = rslt.getBoolean(18);
               ((byte[]) buf[23])[0] = rslt.getByte(19);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(20);
               ((byte[]) buf[26])[0] = rslt.getByte(21);
               ((String[]) buf[27])[0] = rslt.getString(22, 6);
               ((byte[]) buf[28])[0] = rslt.getByte(23);
               ((byte[]) buf[29])[0] = rslt.getByte(24);
               ((byte[]) buf[30])[0] = rslt.getByte(25);
               ((byte[]) buf[31])[0] = rslt.getByte(26);
               ((byte[]) buf[32])[0] = rslt.getByte(27);
               ((byte[]) buf[33])[0] = rslt.getByte(28);
               ((byte[]) buf[34])[0] = rslt.getByte(29);
               ((byte[]) buf[35])[0] = rslt.getByte(30);
               ((byte[]) buf[36])[0] = rslt.getByte(31);
               ((byte[]) buf[37])[0] = rslt.getByte(32);
               ((byte[]) buf[38])[0] = rslt.getByte(33);
               ((byte[]) buf[39])[0] = rslt.getByte(34);
               ((byte[]) buf[40])[0] = rslt.getByte(35);
               ((byte[]) buf[41])[0] = rslt.getByte(36);
               ((byte[]) buf[42])[0] = rslt.getByte(37);
               ((byte[]) buf[43])[0] = rslt.getByte(38);
               ((byte[]) buf[44])[0] = rslt.getByte(39);
               ((byte[]) buf[45])[0] = rslt.getByte(40);
               ((byte[]) buf[46])[0] = rslt.getByte(41);
               ((byte[]) buf[47])[0] = rslt.getByte(42);
               ((byte[]) buf[48])[0] = rslt.getByte(43);
               ((byte[]) buf[49])[0] = rslt.getByte(44);
               ((byte[]) buf[50])[0] = rslt.getByte(45);
               ((byte[]) buf[51])[0] = rslt.getByte(46);
               ((byte[]) buf[52])[0] = rslt.getByte(47);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(49);
               ((int[]) buf[55])[0] = rslt.getInt(50);
               ((boolean[]) buf[56])[0] = rslt.wasNull();
               ((int[]) buf[57])[0] = rslt.getInt(51);
               ((short[]) buf[58])[0] = rslt.getShort(52);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((String[]) buf[60])[0] = rslt.getString(53, 20);
               ((String[]) buf[61])[0] = rslt.getString(54, 20);
               ((boolean[]) buf[62])[0] = rslt.wasNull();
               ((String[]) buf[63])[0] = rslt.getString(55, 20);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((String[]) buf[65])[0] = rslt.getString(56, 20);
               ((boolean[]) buf[66])[0] = rslt.wasNull();
               ((short[]) buf[67])[0] = rslt.getShort(57);
               ((boolean[]) buf[68])[0] = rslt.wasNull();
               ((String[]) buf[69])[0] = rslt.getString(58, 20);
               ((boolean[]) buf[70])[0] = rslt.wasNull();
               ((String[]) buf[71])[0] = rslt.getString(59, 10);
               ((boolean[]) buf[72])[0] = rslt.wasNull();
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 26 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               return;
            case 27 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 28 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 39 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 40 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 41 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 42 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 43 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 44 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 45 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 46 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 3);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 47 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 48 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 49 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 50 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 51 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 52 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 53 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 54 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 55 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 56 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 57 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 58 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 4 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 20);
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 10);
               }
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 12 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 13 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 14 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 20);
               }
               return;
            case 18 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 10);
               }
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 22 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(1, (String)parms[1], 400);
               }
               stmt.setString(2, (String)parms[2], 10);
               stmt.setVarchar(3, (String)parms[3], 400, false);
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setByte(5, ((Number) parms[5]).byteValue());
               stmt.setByte(6, ((Number) parms[6]).byteValue());
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(7, (String)parms[8]);
               }
               stmt.setNLongVarchar(8, (String)parms[9], false);
               stmt.setBoolean(9, ((Boolean) parms[10]).booleanValue());
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(10, ((Boolean) parms[12]).booleanValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(11, (String)parms[14], 40);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(12, (String)parms[16], 80);
               }
               stmt.setLong(13, ((Number) parms[17]).longValue());
               stmt.setNLongVarchar(14, (String)parms[18], false);
               stmt.setBoolean(15, ((Boolean) parms[19]).booleanValue());
               stmt.setVarchar(16, (String)parms[20], 400, false);
               stmt.setString(17, (String)parms[21], 20);
               stmt.setBoolean(18, ((Boolean) parms[22]).booleanValue());
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(19, ((Number) parms[24]).byteValue());
               }
               stmt.setBoolean(20, ((Boolean) parms[25]).booleanValue());
               stmt.setByte(21, ((Number) parms[26]).byteValue());
               stmt.setString(22, (String)parms[27], 6);
               stmt.setByte(23, ((Number) parms[28]).byteValue());
               stmt.setByte(24, ((Number) parms[29]).byteValue());
               stmt.setByte(25, ((Number) parms[30]).byteValue());
               stmt.setByte(26, ((Number) parms[31]).byteValue());
               stmt.setByte(27, ((Number) parms[32]).byteValue());
               stmt.setByte(28, ((Number) parms[33]).byteValue());
               stmt.setByte(29, ((Number) parms[34]).byteValue());
               stmt.setByte(30, ((Number) parms[35]).byteValue());
               stmt.setByte(31, ((Number) parms[36]).byteValue());
               stmt.setByte(32, ((Number) parms[37]).byteValue());
               stmt.setByte(33, ((Number) parms[38]).byteValue());
               stmt.setByte(34, ((Number) parms[39]).byteValue());
               stmt.setByte(35, ((Number) parms[40]).byteValue());
               stmt.setByte(36, ((Number) parms[41]).byteValue());
               stmt.setByte(37, ((Number) parms[42]).byteValue());
               stmt.setByte(38, ((Number) parms[43]).byteValue());
               stmt.setByte(39, ((Number) parms[44]).byteValue());
               stmt.setByte(40, ((Number) parms[45]).byteValue());
               stmt.setByte(41, ((Number) parms[46]).byteValue());
               stmt.setByte(42, ((Number) parms[47]).byteValue());
               stmt.setByte(43, ((Number) parms[48]).byteValue());
               stmt.setByte(44, ((Number) parms[49]).byteValue());
               stmt.setByte(45, ((Number) parms[50]).byteValue());
               stmt.setByte(46, ((Number) parms[51]).byteValue());
               stmt.setByte(47, ((Number) parms[52]).byteValue());
               stmt.setBoolean(48, ((Boolean) parms[53]).booleanValue());
               stmt.setBoolean(49, ((Boolean) parms[54]).booleanValue());
               if ( ((Boolean) parms[55]).booleanValue() )
               {
                  stmt.setNull( 50 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(50, ((Number) parms[56]).intValue());
               }
               stmt.setInt(51, ((Number) parms[57]).intValue());
               if ( ((Boolean) parms[58]).booleanValue() )
               {
                  stmt.setNull( 52 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(52, ((Number) parms[59]).shortValue());
               }
               stmt.setString(53, (String)parms[60], 20);
               if ( ((Boolean) parms[61]).booleanValue() )
               {
                  stmt.setNull( 54 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(54, (String)parms[62], 20);
               }
               if ( ((Boolean) parms[63]).booleanValue() )
               {
                  stmt.setNull( 55 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(55, (String)parms[64], 20);
               }
               if ( ((Boolean) parms[65]).booleanValue() )
               {
                  stmt.setNull( 56 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(56, (String)parms[66], 20);
               }
               if ( ((Boolean) parms[67]).booleanValue() )
               {
                  stmt.setNull( 57 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(57, ((Number) parms[68]).shortValue());
               }
               if ( ((Boolean) parms[69]).booleanValue() )
               {
                  stmt.setNull( 58 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(58, (String)parms[70], 20);
               }
               if ( ((Boolean) parms[71]).booleanValue() )
               {
                  stmt.setNull( 59 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(59, (String)parms[72], 10);
               }
               return;
            case 23 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(1, (String)parms[1], 400);
               }
               stmt.setVarchar(2, (String)parms[2], 400, false);
               stmt.setInt(3, ((Number) parms[3]).intValue());
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               stmt.setByte(5, ((Number) parms[5]).byteValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(6, (String)parms[7]);
               }
               stmt.setNLongVarchar(7, (String)parms[8], false);
               stmt.setBoolean(8, ((Boolean) parms[9]).booleanValue());
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(9, ((Boolean) parms[11]).booleanValue());
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(10, (String)parms[13], 40);
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(11, (String)parms[15], 80);
               }
               stmt.setLong(12, ((Number) parms[16]).longValue());
               stmt.setNLongVarchar(13, (String)parms[17], false);
               stmt.setBoolean(14, ((Boolean) parms[18]).booleanValue());
               stmt.setVarchar(15, (String)parms[19], 400, false);
               stmt.setString(16, (String)parms[20], 20);
               stmt.setBoolean(17, ((Boolean) parms[21]).booleanValue());
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(18, ((Number) parms[23]).byteValue());
               }
               stmt.setBoolean(19, ((Boolean) parms[24]).booleanValue());
               stmt.setByte(20, ((Number) parms[25]).byteValue());
               stmt.setString(21, (String)parms[26], 6);
               stmt.setByte(22, ((Number) parms[27]).byteValue());
               stmt.setByte(23, ((Number) parms[28]).byteValue());
               stmt.setByte(24, ((Number) parms[29]).byteValue());
               stmt.setByte(25, ((Number) parms[30]).byteValue());
               stmt.setByte(26, ((Number) parms[31]).byteValue());
               stmt.setByte(27, ((Number) parms[32]).byteValue());
               stmt.setByte(28, ((Number) parms[33]).byteValue());
               stmt.setByte(29, ((Number) parms[34]).byteValue());
               stmt.setByte(30, ((Number) parms[35]).byteValue());
               stmt.setByte(31, ((Number) parms[36]).byteValue());
               stmt.setByte(32, ((Number) parms[37]).byteValue());
               stmt.setByte(33, ((Number) parms[38]).byteValue());
               stmt.setByte(34, ((Number) parms[39]).byteValue());
               stmt.setByte(35, ((Number) parms[40]).byteValue());
               stmt.setByte(36, ((Number) parms[41]).byteValue());
               stmt.setByte(37, ((Number) parms[42]).byteValue());
               stmt.setByte(38, ((Number) parms[43]).byteValue());
               stmt.setByte(39, ((Number) parms[44]).byteValue());
               stmt.setByte(40, ((Number) parms[45]).byteValue());
               stmt.setByte(41, ((Number) parms[46]).byteValue());
               stmt.setByte(42, ((Number) parms[47]).byteValue());
               stmt.setByte(43, ((Number) parms[48]).byteValue());
               stmt.setByte(44, ((Number) parms[49]).byteValue());
               stmt.setByte(45, ((Number) parms[50]).byteValue());
               stmt.setByte(46, ((Number) parms[51]).byteValue());
               stmt.setBoolean(47, ((Boolean) parms[52]).booleanValue());
               stmt.setBoolean(48, ((Boolean) parms[53]).booleanValue());
               if ( ((Boolean) parms[54]).booleanValue() )
               {
                  stmt.setNull( 49 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(49, ((Number) parms[55]).intValue());
               }
               if ( ((Boolean) parms[56]).booleanValue() )
               {
                  stmt.setNull( 50 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(50, ((Number) parms[57]).shortValue());
               }
               stmt.setString(51, (String)parms[58], 20);
               if ( ((Boolean) parms[59]).booleanValue() )
               {
                  stmt.setNull( 52 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(52, (String)parms[60], 20);
               }
               if ( ((Boolean) parms[61]).booleanValue() )
               {
                  stmt.setNull( 53 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(53, (String)parms[62], 20);
               }
               if ( ((Boolean) parms[63]).booleanValue() )
               {
                  stmt.setNull( 54 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(54, (String)parms[64], 20);
               }
               if ( ((Boolean) parms[65]).booleanValue() )
               {
                  stmt.setNull( 55 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(55, ((Number) parms[66]).shortValue());
               }
               if ( ((Boolean) parms[67]).booleanValue() )
               {
                  stmt.setNull( 56 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(56, (String)parms[68], 20);
               }
               if ( ((Boolean) parms[69]).booleanValue() )
               {
                  stmt.setNull( 57 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(57, (String)parms[70], 10);
               }
               stmt.setInt(58, ((Number) parms[71]).intValue());
               stmt.setString(59, (String)parms[72], 10);
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 39 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 42 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 43 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 44 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 45 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 46 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 47 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 48 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 49 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 50 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 51 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 53 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 54 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 55 :
               stmt.setString(1, (String)parms[0], 20);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 20);
               }
               return;
            case 56 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 57 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 58 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 20);
               }
               return;
      }
   }

}

