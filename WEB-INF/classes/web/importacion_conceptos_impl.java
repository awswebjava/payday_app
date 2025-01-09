package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importacion_conceptos_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel20"+"_"+"CLICOD") == 0 )
      {
         AV20CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx20asaclicod2977( AV20CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_33") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A88ImpLiqSec = (short)(GXutil.lval( httpContext.GetPar( "ImpLiqSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_33( A3CliCod, A1EmpCod, A88ImpLiqSec) ;
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
            AV20CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20CliCod), "ZZZZZ9")));
            AV21EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21EmpCod), "ZZZ9")));
            AV22ImpLiqSec = (short)(GXutil.lval( httpContext.GetPar( "ImpLiqSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22ImpLiqSec), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIMPLIQSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV22ImpLiqSec), "ZZZ9")));
            AV23ImpLiqConExtCod = httpContext.GetPar( "ImpLiqConExtCod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ImpLiqConExtCod", AV23ImpLiqConExtCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIMPLIQCONEXTCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23ImpLiqConExtCod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "importacion_conceptos", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtImpLiqConSisCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public importacion_conceptos_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importacion_conceptos_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_conceptos_impl.class ));
   }

   public importacion_conceptos_impl( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbImpLiqSIPAApo = new HTMLChoice();
      cmbImpLiqSIPACont = new HTMLChoice();
      cmbImpLiqINSSJyPApo = new HTMLChoice();
      cmbImpLiqINSSJyPCont = new HTMLChoice();
      cmbImpLiqObraSocApo = new HTMLChoice();
      cmbImpLiqObraSocCont = new HTMLChoice();
      cmbImpLiqFonSolRedApo = new HTMLChoice();
      cmbImpLiqFonSolRedCont = new HTMLChoice();
      cmbImpLiqRenateaApo = new HTMLChoice();
      cmbImpLiqRenateaCont = new HTMLChoice();
      cmbImpLiqAsigFamCont = new HTMLChoice();
      cmbImpLiqFonNacEmpCont = new HTMLChoice();
      cmbImpLiqLeyRieTrabCont = new HTMLChoice();
      cmbImpLiqRegDifApo = new HTMLChoice();
      cmbImpLiqRegEspApo = new HTMLChoice();
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
      if ( cmbImpLiqSIPAApo.getItemCount() > 0 )
      {
         A643ImpLiqSIPAApo = cmbImpLiqSIPAApo.getValidValue(A643ImpLiqSIPAApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A643ImpLiqSIPAApo", A643ImpLiqSIPAApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqSIPAApo.setValue( GXutil.rtrim( A643ImpLiqSIPAApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqSIPAApo.getInternalname(), "Values", cmbImpLiqSIPAApo.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqSIPACont.getItemCount() > 0 )
      {
         A644ImpLiqSIPACont = cmbImpLiqSIPACont.getValidValue(A644ImpLiqSIPACont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A644ImpLiqSIPACont", A644ImpLiqSIPACont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqSIPACont.setValue( GXutil.rtrim( A644ImpLiqSIPACont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqSIPACont.getInternalname(), "Values", cmbImpLiqSIPACont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqINSSJyPApo.getItemCount() > 0 )
      {
         A645ImpLiqINSSJyPApo = cmbImpLiqINSSJyPApo.getValidValue(A645ImpLiqINSSJyPApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A645ImpLiqINSSJyPApo", A645ImpLiqINSSJyPApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqINSSJyPApo.setValue( GXutil.rtrim( A645ImpLiqINSSJyPApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqINSSJyPApo.getInternalname(), "Values", cmbImpLiqINSSJyPApo.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqINSSJyPCont.getItemCount() > 0 )
      {
         A646ImpLiqINSSJyPCont = cmbImpLiqINSSJyPCont.getValidValue(A646ImpLiqINSSJyPCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A646ImpLiqINSSJyPCont", A646ImpLiqINSSJyPCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqINSSJyPCont.setValue( GXutil.rtrim( A646ImpLiqINSSJyPCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqINSSJyPCont.getInternalname(), "Values", cmbImpLiqINSSJyPCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqObraSocApo.getItemCount() > 0 )
      {
         A647ImpLiqObraSocApo = cmbImpLiqObraSocApo.getValidValue(A647ImpLiqObraSocApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A647ImpLiqObraSocApo", A647ImpLiqObraSocApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqObraSocApo.setValue( GXutil.rtrim( A647ImpLiqObraSocApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqObraSocApo.getInternalname(), "Values", cmbImpLiqObraSocApo.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqObraSocCont.getItemCount() > 0 )
      {
         A648ImpLiqObraSocCont = cmbImpLiqObraSocCont.getValidValue(A648ImpLiqObraSocCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A648ImpLiqObraSocCont", A648ImpLiqObraSocCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqObraSocCont.setValue( GXutil.rtrim( A648ImpLiqObraSocCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqObraSocCont.getInternalname(), "Values", cmbImpLiqObraSocCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqFonSolRedApo.getItemCount() > 0 )
      {
         A649ImpLiqFonSolRedApo = cmbImpLiqFonSolRedApo.getValidValue(A649ImpLiqFonSolRedApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A649ImpLiqFonSolRedApo", A649ImpLiqFonSolRedApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqFonSolRedApo.setValue( GXutil.rtrim( A649ImpLiqFonSolRedApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqFonSolRedApo.getInternalname(), "Values", cmbImpLiqFonSolRedApo.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqFonSolRedCont.getItemCount() > 0 )
      {
         A650ImpLiqFonSolRedCont = cmbImpLiqFonSolRedCont.getValidValue(A650ImpLiqFonSolRedCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A650ImpLiqFonSolRedCont", A650ImpLiqFonSolRedCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqFonSolRedCont.setValue( GXutil.rtrim( A650ImpLiqFonSolRedCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqFonSolRedCont.getInternalname(), "Values", cmbImpLiqFonSolRedCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqRenateaApo.getItemCount() > 0 )
      {
         A651ImpLiqRenateaApo = cmbImpLiqRenateaApo.getValidValue(A651ImpLiqRenateaApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A651ImpLiqRenateaApo", A651ImpLiqRenateaApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqRenateaApo.setValue( GXutil.rtrim( A651ImpLiqRenateaApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqRenateaApo.getInternalname(), "Values", cmbImpLiqRenateaApo.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqRenateaCont.getItemCount() > 0 )
      {
         A652ImpLiqRenateaCont = cmbImpLiqRenateaCont.getValidValue(A652ImpLiqRenateaCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A652ImpLiqRenateaCont", A652ImpLiqRenateaCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqRenateaCont.setValue( GXutil.rtrim( A652ImpLiqRenateaCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqRenateaCont.getInternalname(), "Values", cmbImpLiqRenateaCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqAsigFamCont.getItemCount() > 0 )
      {
         A653ImpLiqAsigFamCont = cmbImpLiqAsigFamCont.getValidValue(A653ImpLiqAsigFamCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A653ImpLiqAsigFamCont", A653ImpLiqAsigFamCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqAsigFamCont.setValue( GXutil.rtrim( A653ImpLiqAsigFamCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqAsigFamCont.getInternalname(), "Values", cmbImpLiqAsigFamCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqFonNacEmpCont.getItemCount() > 0 )
      {
         A654ImpLiqFonNacEmpCont = cmbImpLiqFonNacEmpCont.getValidValue(A654ImpLiqFonNacEmpCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A654ImpLiqFonNacEmpCont", A654ImpLiqFonNacEmpCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqFonNacEmpCont.setValue( GXutil.rtrim( A654ImpLiqFonNacEmpCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqFonNacEmpCont.getInternalname(), "Values", cmbImpLiqFonNacEmpCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqLeyRieTrabCont.getItemCount() > 0 )
      {
         A655ImpLiqLeyRieTrabCont = cmbImpLiqLeyRieTrabCont.getValidValue(A655ImpLiqLeyRieTrabCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A655ImpLiqLeyRieTrabCont", A655ImpLiqLeyRieTrabCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqLeyRieTrabCont.setValue( GXutil.rtrim( A655ImpLiqLeyRieTrabCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqLeyRieTrabCont.getInternalname(), "Values", cmbImpLiqLeyRieTrabCont.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqRegDifApo.getItemCount() > 0 )
      {
         A656ImpLiqRegDifApo = cmbImpLiqRegDifApo.getValidValue(A656ImpLiqRegDifApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A656ImpLiqRegDifApo", A656ImpLiqRegDifApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqRegDifApo.setValue( GXutil.rtrim( A656ImpLiqRegDifApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqRegDifApo.getInternalname(), "Values", cmbImpLiqRegDifApo.ToJavascriptSource(), true);
      }
      if ( cmbImpLiqRegEspApo.getItemCount() > 0 )
      {
         A657ImpLiqRegEspApo = cmbImpLiqRegEspApo.getValidValue(A657ImpLiqRegEspApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A657ImpLiqRegEspApo", A657ImpLiqRegEspApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbImpLiqRegEspApo.setValue( GXutil.rtrim( A657ImpLiqRegEspApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqRegEspApo.getInternalname(), "Values", cmbImpLiqRegEspApo.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpLiqConAfipCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtImpLiqConAfipCod_Internalname, httpContext.getMessage( "Concepto AFIP", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtImpLiqConAfipCod_Internalname, GXutil.rtrim( A642ImpLiqConAfipCod), GXutil.rtrim( localUtil.format( A642ImpLiqConAfipCod, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpLiqConAfipCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtImpLiqConAfipCod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_conceptos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpLiqConExtCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtImpLiqConExtCod_Internalname, httpContext.getMessage( "Código Externo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtImpLiqConExtCod_Internalname, GXutil.rtrim( A89ImpLiqConExtCod), GXutil.rtrim( localUtil.format( A89ImpLiqConExtCod, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpLiqConExtCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtImpLiqConExtCod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_conceptos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpLiqConExtDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtImpLiqConExtDescrip_Internalname, httpContext.getMessage( "Descripción Externa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtImpLiqConExtDescrip_Internalname, A640ImpLiqConExtDescrip, "", "", (short)(0), 1, edtImpLiqConExtDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "Descrip", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_conceptos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedimpliqconsiscod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockimpliqconsiscod_Internalname, httpContext.getMessage( "Concepto Sistema", ""), "", "", lblTextblockimpliqconsiscod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_conceptos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_impliqconsiscod.setProperty("Caption", Combo_impliqconsiscod_Caption);
      ucCombo_impliqconsiscod.setProperty("Cls", Combo_impliqconsiscod_Cls);
      ucCombo_impliqconsiscod.setProperty("EmptyItem", Combo_impliqconsiscod_Emptyitem);
      ucCombo_impliqconsiscod.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_impliqconsiscod.setProperty("DropDownOptionsData", AV16ImpLiqConSisCod_Data);
      ucCombo_impliqconsiscod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_impliqconsiscod_Internalname, "COMBO_IMPLIQCONSISCODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtImpLiqConSisCod_Internalname, httpContext.getMessage( "Imp Liq Con Sis Cod", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtImpLiqConSisCod_Internalname, GXutil.rtrim( A641ImpLiqConSisCod), GXutil.rtrim( localUtil.format( A641ImpLiqConSisCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpLiqConSisCod_Jsonclick, 0, "Attribute", "", "", "", "", edtImpLiqConSisCod_Visible, edtImpLiqConSisCod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_conceptos.htm");
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
      /* User Defined Control */
      ucDvpanel_apocontr.setProperty("Width", Dvpanel_apocontr_Width);
      ucDvpanel_apocontr.setProperty("AutoWidth", Dvpanel_apocontr_Autowidth);
      ucDvpanel_apocontr.setProperty("AutoHeight", Dvpanel_apocontr_Autoheight);
      ucDvpanel_apocontr.setProperty("Cls", Dvpanel_apocontr_Cls);
      ucDvpanel_apocontr.setProperty("Title", Dvpanel_apocontr_Title);
      ucDvpanel_apocontr.setProperty("Collapsible", Dvpanel_apocontr_Collapsible);
      ucDvpanel_apocontr.setProperty("Collapsed", Dvpanel_apocontr_Collapsed);
      ucDvpanel_apocontr.setProperty("ShowCollapseIcon", Dvpanel_apocontr_Showcollapseicon);
      ucDvpanel_apocontr.setProperty("IconPosition", Dvpanel_apocontr_Iconposition);
      ucDvpanel_apocontr.setProperty("AutoScroll", Dvpanel_apocontr_Autoscroll);
      ucDvpanel_apocontr.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_apocontr_Internalname, "DVPANEL_APOCONTRContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_APOCONTRContainer"+"ApoContr"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divApocontr_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqSIPAApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqSIPAApo.getInternalname(), httpContext.getMessage( "SIPA Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqSIPAApo, cmbImpLiqSIPAApo.getInternalname(), GXutil.rtrim( A643ImpLiqSIPAApo), 1, cmbImpLiqSIPAApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqSIPAApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqSIPAApo.setValue( GXutil.rtrim( A643ImpLiqSIPAApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqSIPAApo.getInternalname(), "Values", cmbImpLiqSIPAApo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqSIPACont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqSIPACont.getInternalname(), httpContext.getMessage( "SIPA Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqSIPACont, cmbImpLiqSIPACont.getInternalname(), GXutil.rtrim( A644ImpLiqSIPACont), 1, cmbImpLiqSIPACont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqSIPACont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqSIPACont.setValue( GXutil.rtrim( A644ImpLiqSIPACont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqSIPACont.getInternalname(), "Values", cmbImpLiqSIPACont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqINSSJyPApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqINSSJyPApo.getInternalname(), httpContext.getMessage( "INSSJyP Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqINSSJyPApo, cmbImpLiqINSSJyPApo.getInternalname(), GXutil.rtrim( A645ImpLiqINSSJyPApo), 1, cmbImpLiqINSSJyPApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqINSSJyPApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqINSSJyPApo.setValue( GXutil.rtrim( A645ImpLiqINSSJyPApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqINSSJyPApo.getInternalname(), "Values", cmbImpLiqINSSJyPApo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqINSSJyPCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqINSSJyPCont.getInternalname(), httpContext.getMessage( "INSSJyP Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqINSSJyPCont, cmbImpLiqINSSJyPCont.getInternalname(), GXutil.rtrim( A646ImpLiqINSSJyPCont), 1, cmbImpLiqINSSJyPCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqINSSJyPCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqINSSJyPCont.setValue( GXutil.rtrim( A646ImpLiqINSSJyPCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqINSSJyPCont.getInternalname(), "Values", cmbImpLiqINSSJyPCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqObraSocApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqObraSocApo.getInternalname(), httpContext.getMessage( "Obra Social Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqObraSocApo, cmbImpLiqObraSocApo.getInternalname(), GXutil.rtrim( A647ImpLiqObraSocApo), 1, cmbImpLiqObraSocApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqObraSocApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,73);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqObraSocApo.setValue( GXutil.rtrim( A647ImpLiqObraSocApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqObraSocApo.getInternalname(), "Values", cmbImpLiqObraSocApo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqObraSocCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqObraSocCont.getInternalname(), httpContext.getMessage( "Obra Social Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqObraSocCont, cmbImpLiqObraSocCont.getInternalname(), GXutil.rtrim( A648ImpLiqObraSocCont), 1, cmbImpLiqObraSocCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqObraSocCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,78);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqObraSocCont.setValue( GXutil.rtrim( A648ImpLiqObraSocCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqObraSocCont.getInternalname(), "Values", cmbImpLiqObraSocCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqFonSolRedApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqFonSolRedApo.getInternalname(), httpContext.getMessage( "Redist. Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqFonSolRedApo, cmbImpLiqFonSolRedApo.getInternalname(), GXutil.rtrim( A649ImpLiqFonSolRedApo), 1, cmbImpLiqFonSolRedApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqFonSolRedApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,83);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqFonSolRedApo.setValue( GXutil.rtrim( A649ImpLiqFonSolRedApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqFonSolRedApo.getInternalname(), "Values", cmbImpLiqFonSolRedApo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqFonSolRedCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqFonSolRedCont.getInternalname(), httpContext.getMessage( "Redist. Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqFonSolRedCont, cmbImpLiqFonSolRedCont.getInternalname(), GXutil.rtrim( A650ImpLiqFonSolRedCont), 1, cmbImpLiqFonSolRedCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqFonSolRedCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,88);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqFonSolRedCont.setValue( GXutil.rtrim( A650ImpLiqFonSolRedCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqFonSolRedCont.getInternalname(), "Values", cmbImpLiqFonSolRedCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqRenateaApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqRenateaApo.getInternalname(), httpContext.getMessage( "RENATEA Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqRenateaApo, cmbImpLiqRenateaApo.getInternalname(), GXutil.rtrim( A651ImpLiqRenateaApo), 1, cmbImpLiqRenateaApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqRenateaApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,93);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqRenateaApo.setValue( GXutil.rtrim( A651ImpLiqRenateaApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqRenateaApo.getInternalname(), "Values", cmbImpLiqRenateaApo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqRenateaCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqRenateaCont.getInternalname(), httpContext.getMessage( "RENATEA Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqRenateaCont, cmbImpLiqRenateaCont.getInternalname(), GXutil.rtrim( A652ImpLiqRenateaCont), 1, cmbImpLiqRenateaCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqRenateaCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,98);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqRenateaCont.setValue( GXutil.rtrim( A652ImpLiqRenateaCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqRenateaCont.getInternalname(), "Values", cmbImpLiqRenateaCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqAsigFamCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqAsigFamCont.getInternalname(), httpContext.getMessage( "Asignaciones Familiares Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 103,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqAsigFamCont, cmbImpLiqAsigFamCont.getInternalname(), GXutil.rtrim( A653ImpLiqAsigFamCont), 1, cmbImpLiqAsigFamCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqAsigFamCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,103);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqAsigFamCont.setValue( GXutil.rtrim( A653ImpLiqAsigFamCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqAsigFamCont.getInternalname(), "Values", cmbImpLiqAsigFamCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqFonNacEmpCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqFonNacEmpCont.getInternalname(), httpContext.getMessage( "Fondo Nacional Empleo Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqFonNacEmpCont, cmbImpLiqFonNacEmpCont.getInternalname(), GXutil.rtrim( A654ImpLiqFonNacEmpCont), 1, cmbImpLiqFonNacEmpCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqFonNacEmpCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,108);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqFonNacEmpCont.setValue( GXutil.rtrim( A654ImpLiqFonNacEmpCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqFonNacEmpCont.getInternalname(), "Values", cmbImpLiqFonNacEmpCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqLeyRieTrabCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqLeyRieTrabCont.getInternalname(), httpContext.getMessage( "Ley Riesgos Trabajo Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 113,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqLeyRieTrabCont, cmbImpLiqLeyRieTrabCont.getInternalname(), GXutil.rtrim( A655ImpLiqLeyRieTrabCont), 1, cmbImpLiqLeyRieTrabCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqLeyRieTrabCont.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,113);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqLeyRieTrabCont.setValue( GXutil.rtrim( A655ImpLiqLeyRieTrabCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqLeyRieTrabCont.getInternalname(), "Values", cmbImpLiqLeyRieTrabCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqRegDifApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqRegDifApo.getInternalname(), httpContext.getMessage( "Regimenes Diferenciales Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqRegDifApo, cmbImpLiqRegDifApo.getInternalname(), GXutil.rtrim( A656ImpLiqRegDifApo), 1, cmbImpLiqRegDifApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqRegDifApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,118);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqRegDifApo.setValue( GXutil.rtrim( A656ImpLiqRegDifApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqRegDifApo.getInternalname(), "Values", cmbImpLiqRegDifApo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbImpLiqRegEspApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbImpLiqRegEspApo.getInternalname(), httpContext.getMessage( "Regimenes Especiales Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 123,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbImpLiqRegEspApo, cmbImpLiqRegEspApo.getInternalname(), GXutil.rtrim( A657ImpLiqRegEspApo), 1, cmbImpLiqRegEspApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbImpLiqRegEspApo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,123);\"", "", true, (byte)(0), "HLP_importacion_conceptos.htm");
      cmbImpLiqRegEspApo.setValue( GXutil.rtrim( A657ImpLiqRegEspApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqRegEspApo.getInternalname(), "Values", cmbImpLiqRegEspApo.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 131,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_conceptos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 133,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_conceptos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 135,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_conceptos.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_impliqconsiscod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboimpliqconsiscod_Internalname, GXutil.rtrim( AV19ComboImpLiqConSisCod), GXutil.rtrim( localUtil.format( AV19ComboImpLiqConSisCod, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboimpliqconsiscod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboimpliqconsiscod_Visible, edtavComboimpliqconsiscod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_conceptos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 141,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,141);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_conceptos.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 142,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,142);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_importacion_conceptos.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 143,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtImpLiqSec_Internalname, GXutil.ltrim( localUtil.ntoc( A88ImpLiqSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A88ImpLiqSec), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,143);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpLiqSec_Jsonclick, 0, "Attribute", "", "", "", "", edtImpLiqSec_Visible, edtImpLiqSec_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_conceptos.htm");
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
      e11292 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vIMPLIQCONSISCOD_DATA"), AV16ImpLiqConSisCod_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z88ImpLiqSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z88ImpLiqSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z89ImpLiqConExtCod = httpContext.cgiGet( "Z89ImpLiqConExtCod") ;
            Z701ImpLiqConExtCodYDescrip = httpContext.cgiGet( "Z701ImpLiqConExtCodYDescrip") ;
            Z641ImpLiqConSisCod = httpContext.cgiGet( "Z641ImpLiqConSisCod") ;
            Z659ImpLiqConError = httpContext.cgiGet( "Z659ImpLiqConError") ;
            Z660ImpLiqConWarning = httpContext.cgiGet( "Z660ImpLiqConWarning") ;
            Z640ImpLiqConExtDescrip = httpContext.cgiGet( "Z640ImpLiqConExtDescrip") ;
            Z2186ImpLiqConExtDesSinAc = httpContext.cgiGet( "Z2186ImpLiqConExtDesSinAc") ;
            Z642ImpLiqConAfipCod = httpContext.cgiGet( "Z642ImpLiqConAfipCod") ;
            Z912ImpLiqAfipCodMasDesc = httpContext.cgiGet( "Z912ImpLiqAfipCodMasDesc") ;
            Z643ImpLiqSIPAApo = httpContext.cgiGet( "Z643ImpLiqSIPAApo") ;
            Z644ImpLiqSIPACont = httpContext.cgiGet( "Z644ImpLiqSIPACont") ;
            Z645ImpLiqINSSJyPApo = httpContext.cgiGet( "Z645ImpLiqINSSJyPApo") ;
            Z646ImpLiqINSSJyPCont = httpContext.cgiGet( "Z646ImpLiqINSSJyPCont") ;
            Z647ImpLiqObraSocApo = httpContext.cgiGet( "Z647ImpLiqObraSocApo") ;
            Z648ImpLiqObraSocCont = httpContext.cgiGet( "Z648ImpLiqObraSocCont") ;
            Z649ImpLiqFonSolRedApo = httpContext.cgiGet( "Z649ImpLiqFonSolRedApo") ;
            Z650ImpLiqFonSolRedCont = httpContext.cgiGet( "Z650ImpLiqFonSolRedCont") ;
            Z651ImpLiqRenateaApo = httpContext.cgiGet( "Z651ImpLiqRenateaApo") ;
            Z652ImpLiqRenateaCont = httpContext.cgiGet( "Z652ImpLiqRenateaCont") ;
            Z653ImpLiqAsigFamCont = httpContext.cgiGet( "Z653ImpLiqAsigFamCont") ;
            Z654ImpLiqFonNacEmpCont = httpContext.cgiGet( "Z654ImpLiqFonNacEmpCont") ;
            Z655ImpLiqLeyRieTrabCont = httpContext.cgiGet( "Z655ImpLiqLeyRieTrabCont") ;
            Z656ImpLiqRegDifApo = httpContext.cgiGet( "Z656ImpLiqRegDifApo") ;
            Z657ImpLiqRegEspApo = httpContext.cgiGet( "Z657ImpLiqRegEspApo") ;
            Z702ImpLiqConSisCodYDescrip = httpContext.cgiGet( "Z702ImpLiqConSisCodYDescrip") ;
            Z911ImpLiqTipoConCod = httpContext.cgiGet( "Z911ImpLiqTipoConCod") ;
            A701ImpLiqConExtCodYDescrip = httpContext.cgiGet( "Z701ImpLiqConExtCodYDescrip") ;
            A659ImpLiqConError = httpContext.cgiGet( "Z659ImpLiqConError") ;
            A660ImpLiqConWarning = httpContext.cgiGet( "Z660ImpLiqConWarning") ;
            A2186ImpLiqConExtDesSinAc = httpContext.cgiGet( "Z2186ImpLiqConExtDesSinAc") ;
            A912ImpLiqAfipCodMasDesc = httpContext.cgiGet( "Z912ImpLiqAfipCodMasDesc") ;
            A702ImpLiqConSisCodYDescrip = httpContext.cgiGet( "Z702ImpLiqConSisCodYDescrip") ;
            A911ImpLiqTipoConCod = httpContext.cgiGet( "Z911ImpLiqTipoConCod") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            A701ImpLiqConExtCodYDescrip = httpContext.cgiGet( "IMPLIQCONEXTCODYDESCRIP") ;
            AV20CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV21EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV22ImpLiqSec = (short)(localUtil.ctol( httpContext.cgiGet( "vIMPLIQSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV23ImpLiqConExtCod = httpContext.cgiGet( "vIMPLIQCONEXTCOD") ;
            A659ImpLiqConError = httpContext.cgiGet( "IMPLIQCONERROR") ;
            A660ImpLiqConWarning = httpContext.cgiGet( "IMPLIQCONWARNING") ;
            A2186ImpLiqConExtDesSinAc = httpContext.cgiGet( "IMPLIQCONEXTDESSINAC") ;
            A912ImpLiqAfipCodMasDesc = httpContext.cgiGet( "IMPLIQAFIPCODMASDESC") ;
            A702ImpLiqConSisCodYDescrip = httpContext.cgiGet( "IMPLIQCONSISCODYDESCRIP") ;
            A911ImpLiqTipoConCod = httpContext.cgiGet( "IMPLIQTIPOCONCOD") ;
            AV24Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_impliqconsiscod_Objectcall = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Objectcall") ;
            Combo_impliqconsiscod_Class = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Class") ;
            Combo_impliqconsiscod_Icontype = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Icontype") ;
            Combo_impliqconsiscod_Icon = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Icon") ;
            Combo_impliqconsiscod_Caption = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Caption") ;
            Combo_impliqconsiscod_Tooltip = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Tooltip") ;
            Combo_impliqconsiscod_Cls = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Cls") ;
            Combo_impliqconsiscod_Selectedvalue_set = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Selectedvalue_set") ;
            Combo_impliqconsiscod_Selectedvalue_get = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Selectedvalue_get") ;
            Combo_impliqconsiscod_Selectedtext_set = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Selectedtext_set") ;
            Combo_impliqconsiscod_Selectedtext_get = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Selectedtext_get") ;
            Combo_impliqconsiscod_Gamoauthtoken = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Gamoauthtoken") ;
            Combo_impliqconsiscod_Ddointernalname = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Ddointernalname") ;
            Combo_impliqconsiscod_Titlecontrolalign = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Titlecontrolalign") ;
            Combo_impliqconsiscod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Dropdownoptionstype") ;
            Combo_impliqconsiscod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Enabled")) ;
            Combo_impliqconsiscod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Visible")) ;
            Combo_impliqconsiscod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Titlecontrolidtoreplace") ;
            Combo_impliqconsiscod_Datalisttype = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Datalisttype") ;
            Combo_impliqconsiscod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Allowmultipleselection")) ;
            Combo_impliqconsiscod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Datalistfixedvalues") ;
            Combo_impliqconsiscod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Isgriditem")) ;
            Combo_impliqconsiscod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Hasdescription")) ;
            Combo_impliqconsiscod_Datalistproc = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Datalistproc") ;
            Combo_impliqconsiscod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Datalistprocparametersprefix") ;
            Combo_impliqconsiscod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Remoteservicesparameters") ;
            Combo_impliqconsiscod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_impliqconsiscod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Includeonlyselectedoption")) ;
            Combo_impliqconsiscod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Includeselectalloption")) ;
            Combo_impliqconsiscod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Emptyitem")) ;
            Combo_impliqconsiscod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Includeaddnewoption")) ;
            Combo_impliqconsiscod_Htmltemplate = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Htmltemplate") ;
            Combo_impliqconsiscod_Multiplevaluestype = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Multiplevaluestype") ;
            Combo_impliqconsiscod_Loadingdata = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Loadingdata") ;
            Combo_impliqconsiscod_Noresultsfound = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Noresultsfound") ;
            Combo_impliqconsiscod_Emptyitemtext = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Emptyitemtext") ;
            Combo_impliqconsiscod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Onlyselectedvalues") ;
            Combo_impliqconsiscod_Selectalltext = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Selectalltext") ;
            Combo_impliqconsiscod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Multiplevaluesseparator") ;
            Combo_impliqconsiscod_Addnewoptiontext = httpContext.cgiGet( "COMBO_IMPLIQCONSISCOD_Addnewoptiontext") ;
            Dvpanel_apocontr_Objectcall = httpContext.cgiGet( "DVPANEL_APOCONTR_Objectcall") ;
            Dvpanel_apocontr_Class = httpContext.cgiGet( "DVPANEL_APOCONTR_Class") ;
            Dvpanel_apocontr_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_APOCONTR_Enabled")) ;
            Dvpanel_apocontr_Width = httpContext.cgiGet( "DVPANEL_APOCONTR_Width") ;
            Dvpanel_apocontr_Height = httpContext.cgiGet( "DVPANEL_APOCONTR_Height") ;
            Dvpanel_apocontr_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_APOCONTR_Autowidth")) ;
            Dvpanel_apocontr_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_APOCONTR_Autoheight")) ;
            Dvpanel_apocontr_Cls = httpContext.cgiGet( "DVPANEL_APOCONTR_Cls") ;
            Dvpanel_apocontr_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_APOCONTR_Showheader")) ;
            Dvpanel_apocontr_Title = httpContext.cgiGet( "DVPANEL_APOCONTR_Title") ;
            Dvpanel_apocontr_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_APOCONTR_Collapsible")) ;
            Dvpanel_apocontr_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_APOCONTR_Collapsed")) ;
            Dvpanel_apocontr_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_APOCONTR_Showcollapseicon")) ;
            Dvpanel_apocontr_Iconposition = httpContext.cgiGet( "DVPANEL_APOCONTR_Iconposition") ;
            Dvpanel_apocontr_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_APOCONTR_Autoscroll")) ;
            Dvpanel_apocontr_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_APOCONTR_Visible")) ;
            Dvpanel_apocontr_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_APOCONTR_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A642ImpLiqConAfipCod = httpContext.cgiGet( edtImpLiqConAfipCod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A642ImpLiqConAfipCod", A642ImpLiqConAfipCod);
            A89ImpLiqConExtCod = httpContext.cgiGet( edtImpLiqConExtCod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
            A640ImpLiqConExtDescrip = httpContext.cgiGet( edtImpLiqConExtDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A640ImpLiqConExtDescrip", A640ImpLiqConExtDescrip);
            A641ImpLiqConSisCod = httpContext.cgiGet( edtImpLiqConSisCod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A641ImpLiqConSisCod", A641ImpLiqConSisCod);
            cmbImpLiqSIPAApo.setValue( httpContext.cgiGet( cmbImpLiqSIPAApo.getInternalname()) );
            A643ImpLiqSIPAApo = httpContext.cgiGet( cmbImpLiqSIPAApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A643ImpLiqSIPAApo", A643ImpLiqSIPAApo);
            cmbImpLiqSIPACont.setValue( httpContext.cgiGet( cmbImpLiqSIPACont.getInternalname()) );
            A644ImpLiqSIPACont = httpContext.cgiGet( cmbImpLiqSIPACont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A644ImpLiqSIPACont", A644ImpLiqSIPACont);
            cmbImpLiqINSSJyPApo.setValue( httpContext.cgiGet( cmbImpLiqINSSJyPApo.getInternalname()) );
            A645ImpLiqINSSJyPApo = httpContext.cgiGet( cmbImpLiqINSSJyPApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A645ImpLiqINSSJyPApo", A645ImpLiqINSSJyPApo);
            cmbImpLiqINSSJyPCont.setValue( httpContext.cgiGet( cmbImpLiqINSSJyPCont.getInternalname()) );
            A646ImpLiqINSSJyPCont = httpContext.cgiGet( cmbImpLiqINSSJyPCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A646ImpLiqINSSJyPCont", A646ImpLiqINSSJyPCont);
            cmbImpLiqObraSocApo.setValue( httpContext.cgiGet( cmbImpLiqObraSocApo.getInternalname()) );
            A647ImpLiqObraSocApo = httpContext.cgiGet( cmbImpLiqObraSocApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A647ImpLiqObraSocApo", A647ImpLiqObraSocApo);
            cmbImpLiqObraSocCont.setValue( httpContext.cgiGet( cmbImpLiqObraSocCont.getInternalname()) );
            A648ImpLiqObraSocCont = httpContext.cgiGet( cmbImpLiqObraSocCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A648ImpLiqObraSocCont", A648ImpLiqObraSocCont);
            cmbImpLiqFonSolRedApo.setValue( httpContext.cgiGet( cmbImpLiqFonSolRedApo.getInternalname()) );
            A649ImpLiqFonSolRedApo = httpContext.cgiGet( cmbImpLiqFonSolRedApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A649ImpLiqFonSolRedApo", A649ImpLiqFonSolRedApo);
            cmbImpLiqFonSolRedCont.setValue( httpContext.cgiGet( cmbImpLiqFonSolRedCont.getInternalname()) );
            A650ImpLiqFonSolRedCont = httpContext.cgiGet( cmbImpLiqFonSolRedCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A650ImpLiqFonSolRedCont", A650ImpLiqFonSolRedCont);
            cmbImpLiqRenateaApo.setValue( httpContext.cgiGet( cmbImpLiqRenateaApo.getInternalname()) );
            A651ImpLiqRenateaApo = httpContext.cgiGet( cmbImpLiqRenateaApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A651ImpLiqRenateaApo", A651ImpLiqRenateaApo);
            cmbImpLiqRenateaCont.setValue( httpContext.cgiGet( cmbImpLiqRenateaCont.getInternalname()) );
            A652ImpLiqRenateaCont = httpContext.cgiGet( cmbImpLiqRenateaCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A652ImpLiqRenateaCont", A652ImpLiqRenateaCont);
            cmbImpLiqAsigFamCont.setValue( httpContext.cgiGet( cmbImpLiqAsigFamCont.getInternalname()) );
            A653ImpLiqAsigFamCont = httpContext.cgiGet( cmbImpLiqAsigFamCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A653ImpLiqAsigFamCont", A653ImpLiqAsigFamCont);
            cmbImpLiqFonNacEmpCont.setValue( httpContext.cgiGet( cmbImpLiqFonNacEmpCont.getInternalname()) );
            A654ImpLiqFonNacEmpCont = httpContext.cgiGet( cmbImpLiqFonNacEmpCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A654ImpLiqFonNacEmpCont", A654ImpLiqFonNacEmpCont);
            cmbImpLiqLeyRieTrabCont.setValue( httpContext.cgiGet( cmbImpLiqLeyRieTrabCont.getInternalname()) );
            A655ImpLiqLeyRieTrabCont = httpContext.cgiGet( cmbImpLiqLeyRieTrabCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A655ImpLiqLeyRieTrabCont", A655ImpLiqLeyRieTrabCont);
            cmbImpLiqRegDifApo.setValue( httpContext.cgiGet( cmbImpLiqRegDifApo.getInternalname()) );
            A656ImpLiqRegDifApo = httpContext.cgiGet( cmbImpLiqRegDifApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A656ImpLiqRegDifApo", A656ImpLiqRegDifApo);
            cmbImpLiqRegEspApo.setValue( httpContext.cgiGet( cmbImpLiqRegEspApo.getInternalname()) );
            A657ImpLiqRegEspApo = httpContext.cgiGet( cmbImpLiqRegEspApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A657ImpLiqRegEspApo", A657ImpLiqRegEspApo);
            AV19ComboImpLiqConSisCod = httpContext.cgiGet( edtavComboimpliqconsiscod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ComboImpLiqConSisCod", AV19ComboImpLiqConSisCod);
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1EmpCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            else
            {
               A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtImpLiqSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtImpLiqSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "IMPLIQSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtImpLiqSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A88ImpLiqSec = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
            }
            else
            {
               A88ImpLiqSec = (short)(localUtil.ctol( httpContext.cgiGet( edtImpLiqSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"importacion_conceptos");
            A642ImpLiqConAfipCod = httpContext.cgiGet( edtImpLiqConAfipCod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A642ImpLiqConAfipCod", A642ImpLiqConAfipCod);
            forbiddenHiddens.add("ImpLiqConAfipCod", GXutil.rtrim( localUtil.format( A642ImpLiqConAfipCod, "")));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ImpLiqConError", GXutil.rtrim( localUtil.format( A659ImpLiqConError, "")));
            forbiddenHiddens.add("ImpLiqConWarning", GXutil.rtrim( localUtil.format( A660ImpLiqConWarning, "")));
            A640ImpLiqConExtDescrip = httpContext.cgiGet( edtImpLiqConExtDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A640ImpLiqConExtDescrip", A640ImpLiqConExtDescrip);
            forbiddenHiddens.add("ImpLiqConExtDescrip", GXutil.rtrim( localUtil.format( A640ImpLiqConExtDescrip, "")));
            forbiddenHiddens.add("ImpLiqConExtDesSinAc", GXutil.rtrim( localUtil.format( A2186ImpLiqConExtDesSinAc, "")));
            forbiddenHiddens.add("ImpLiqAfipCodMasDesc", GXutil.rtrim( localUtil.format( A912ImpLiqAfipCodMasDesc, "")));
            forbiddenHiddens.add("ImpLiqConSisCodYDescrip", GXutil.rtrim( localUtil.format( A702ImpLiqConSisCodYDescrip, "")));
            forbiddenHiddens.add("ImpLiqTipoConCod", GXutil.rtrim( localUtil.format( A911ImpLiqTipoConCod, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( GXutil.strcmp(A89ImpLiqConExtCod, Z89ImpLiqConExtCod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("importacion_conceptos:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A88ImpLiqSec = (short)(GXutil.lval( httpContext.GetPar( "ImpLiqSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
               A89ImpLiqConExtCod = httpContext.GetPar( "ImpLiqConExtCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
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
                  sMode77 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode77 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound77 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_290( ) ;
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
                        e11292 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12292 ();
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
         e12292 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll2977( ) ;
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
         disableAttributes2977( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboimpliqconsiscod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboimpliqconsiscod_Enabled), 5, 0), true);
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

   public void confirm_290( )
   {
      beforeValidate2977( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2977( ) ;
         }
         else
         {
            checkExtendedTable2977( ) ;
            closeExtendedTableCursors2977( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption290( )
   {
   }

   public void e11292( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV17DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV17DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtImpLiqConSisCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqConSisCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqConSisCod_Visible), 5, 0), true);
      AV19ComboImpLiqConSisCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboImpLiqConSisCod", AV19ComboImpLiqConSisCod);
      edtavComboimpliqconsiscod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboimpliqconsiscod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboimpliqconsiscod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOIMPLIQCONSISCOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV12IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_conceptos_Insert", GXv_boolean5) ;
         importacion_conceptos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_conceptos_Update", GXv_boolean5) ;
         importacion_conceptos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_conceptos_Delete", GXv_boolean5) ;
         importacion_conceptos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV24Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtImpLiqSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqSec_Visible), 5, 0), true);
   }

   public void e12292( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.revalidarimpconceptoerror(remoteHandle, context).execute( AV20CliCod, AV21EmpCod, AV22ImpLiqSec, AV23ImpLiqConExtCod) ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'LOADCOMBOIMPLIQCONSISCOD' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item6 = AV16ImpLiqConSisCod_Data ;
      GXv_char7[0] = AV18ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item8[0] = GXt_objcol_SdtDVB_SDTComboData_Item6 ;
      new web.importacion_conceptosloaddvcombo(remoteHandle, context).execute( "ImpLiqConSisCod", Gx_mode, AV20CliCod, AV21EmpCod, AV22ImpLiqSec, AV23ImpLiqConExtCod, GXv_char7, GXv_objcol_SdtDVB_SDTComboData_Item8) ;
      importacion_conceptos_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item6 = GXv_objcol_SdtDVB_SDTComboData_Item8[0] ;
      AV16ImpLiqConSisCod_Data = GXt_objcol_SdtDVB_SDTComboData_Item6 ;
      Combo_impliqconsiscod_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_impliqconsiscod.sendProperty(context, "", false, Combo_impliqconsiscod_Internalname, "SelectedValue_set", Combo_impliqconsiscod_Selectedvalue_set);
      AV19ComboImpLiqConSisCod = AV18ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboImpLiqConSisCod", AV19ComboImpLiqConSisCod);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_impliqconsiscod_Enabled = false ;
         ucCombo_impliqconsiscod.sendProperty(context, "", false, Combo_impliqconsiscod_Internalname, "Enabled", GXutil.booltostr( Combo_impliqconsiscod_Enabled));
      }
   }

   public void zm2977( int GX_JID )
   {
      if ( ( GX_JID == 32 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z701ImpLiqConExtCodYDescrip = T00293_A701ImpLiqConExtCodYDescrip[0] ;
            Z641ImpLiqConSisCod = T00293_A641ImpLiqConSisCod[0] ;
            Z659ImpLiqConError = T00293_A659ImpLiqConError[0] ;
            Z660ImpLiqConWarning = T00293_A660ImpLiqConWarning[0] ;
            Z640ImpLiqConExtDescrip = T00293_A640ImpLiqConExtDescrip[0] ;
            Z2186ImpLiqConExtDesSinAc = T00293_A2186ImpLiqConExtDesSinAc[0] ;
            Z642ImpLiqConAfipCod = T00293_A642ImpLiqConAfipCod[0] ;
            Z912ImpLiqAfipCodMasDesc = T00293_A912ImpLiqAfipCodMasDesc[0] ;
            Z643ImpLiqSIPAApo = T00293_A643ImpLiqSIPAApo[0] ;
            Z644ImpLiqSIPACont = T00293_A644ImpLiqSIPACont[0] ;
            Z645ImpLiqINSSJyPApo = T00293_A645ImpLiqINSSJyPApo[0] ;
            Z646ImpLiqINSSJyPCont = T00293_A646ImpLiqINSSJyPCont[0] ;
            Z647ImpLiqObraSocApo = T00293_A647ImpLiqObraSocApo[0] ;
            Z648ImpLiqObraSocCont = T00293_A648ImpLiqObraSocCont[0] ;
            Z649ImpLiqFonSolRedApo = T00293_A649ImpLiqFonSolRedApo[0] ;
            Z650ImpLiqFonSolRedCont = T00293_A650ImpLiqFonSolRedCont[0] ;
            Z651ImpLiqRenateaApo = T00293_A651ImpLiqRenateaApo[0] ;
            Z652ImpLiqRenateaCont = T00293_A652ImpLiqRenateaCont[0] ;
            Z653ImpLiqAsigFamCont = T00293_A653ImpLiqAsigFamCont[0] ;
            Z654ImpLiqFonNacEmpCont = T00293_A654ImpLiqFonNacEmpCont[0] ;
            Z655ImpLiqLeyRieTrabCont = T00293_A655ImpLiqLeyRieTrabCont[0] ;
            Z656ImpLiqRegDifApo = T00293_A656ImpLiqRegDifApo[0] ;
            Z657ImpLiqRegEspApo = T00293_A657ImpLiqRegEspApo[0] ;
            Z702ImpLiqConSisCodYDescrip = T00293_A702ImpLiqConSisCodYDescrip[0] ;
            Z911ImpLiqTipoConCod = T00293_A911ImpLiqTipoConCod[0] ;
         }
         else
         {
            Z701ImpLiqConExtCodYDescrip = A701ImpLiqConExtCodYDescrip ;
            Z641ImpLiqConSisCod = A641ImpLiqConSisCod ;
            Z659ImpLiqConError = A659ImpLiqConError ;
            Z660ImpLiqConWarning = A660ImpLiqConWarning ;
            Z640ImpLiqConExtDescrip = A640ImpLiqConExtDescrip ;
            Z2186ImpLiqConExtDesSinAc = A2186ImpLiqConExtDesSinAc ;
            Z642ImpLiqConAfipCod = A642ImpLiqConAfipCod ;
            Z912ImpLiqAfipCodMasDesc = A912ImpLiqAfipCodMasDesc ;
            Z643ImpLiqSIPAApo = A643ImpLiqSIPAApo ;
            Z644ImpLiqSIPACont = A644ImpLiqSIPACont ;
            Z645ImpLiqINSSJyPApo = A645ImpLiqINSSJyPApo ;
            Z646ImpLiqINSSJyPCont = A646ImpLiqINSSJyPCont ;
            Z647ImpLiqObraSocApo = A647ImpLiqObraSocApo ;
            Z648ImpLiqObraSocCont = A648ImpLiqObraSocCont ;
            Z649ImpLiqFonSolRedApo = A649ImpLiqFonSolRedApo ;
            Z650ImpLiqFonSolRedCont = A650ImpLiqFonSolRedCont ;
            Z651ImpLiqRenateaApo = A651ImpLiqRenateaApo ;
            Z652ImpLiqRenateaCont = A652ImpLiqRenateaCont ;
            Z653ImpLiqAsigFamCont = A653ImpLiqAsigFamCont ;
            Z654ImpLiqFonNacEmpCont = A654ImpLiqFonNacEmpCont ;
            Z655ImpLiqLeyRieTrabCont = A655ImpLiqLeyRieTrabCont ;
            Z656ImpLiqRegDifApo = A656ImpLiqRegDifApo ;
            Z657ImpLiqRegEspApo = A657ImpLiqRegEspApo ;
            Z702ImpLiqConSisCodYDescrip = A702ImpLiqConSisCodYDescrip ;
            Z911ImpLiqTipoConCod = A911ImpLiqTipoConCod ;
         }
      }
      if ( GX_JID == -32 )
      {
         Z701ImpLiqConExtCodYDescrip = A701ImpLiqConExtCodYDescrip ;
         Z89ImpLiqConExtCod = A89ImpLiqConExtCod ;
         Z641ImpLiqConSisCod = A641ImpLiqConSisCod ;
         Z659ImpLiqConError = A659ImpLiqConError ;
         Z660ImpLiqConWarning = A660ImpLiqConWarning ;
         Z640ImpLiqConExtDescrip = A640ImpLiqConExtDescrip ;
         Z2186ImpLiqConExtDesSinAc = A2186ImpLiqConExtDesSinAc ;
         Z642ImpLiqConAfipCod = A642ImpLiqConAfipCod ;
         Z912ImpLiqAfipCodMasDesc = A912ImpLiqAfipCodMasDesc ;
         Z643ImpLiqSIPAApo = A643ImpLiqSIPAApo ;
         Z644ImpLiqSIPACont = A644ImpLiqSIPACont ;
         Z645ImpLiqINSSJyPApo = A645ImpLiqINSSJyPApo ;
         Z646ImpLiqINSSJyPCont = A646ImpLiqINSSJyPCont ;
         Z647ImpLiqObraSocApo = A647ImpLiqObraSocApo ;
         Z648ImpLiqObraSocCont = A648ImpLiqObraSocCont ;
         Z649ImpLiqFonSolRedApo = A649ImpLiqFonSolRedApo ;
         Z650ImpLiqFonSolRedCont = A650ImpLiqFonSolRedCont ;
         Z651ImpLiqRenateaApo = A651ImpLiqRenateaApo ;
         Z652ImpLiqRenateaCont = A652ImpLiqRenateaCont ;
         Z653ImpLiqAsigFamCont = A653ImpLiqAsigFamCont ;
         Z654ImpLiqFonNacEmpCont = A654ImpLiqFonNacEmpCont ;
         Z655ImpLiqLeyRieTrabCont = A655ImpLiqLeyRieTrabCont ;
         Z656ImpLiqRegDifApo = A656ImpLiqRegDifApo ;
         Z657ImpLiqRegEspApo = A657ImpLiqRegEspApo ;
         Z702ImpLiqConSisCodYDescrip = A702ImpLiqConSisCodYDescrip ;
         Z911ImpLiqTipoConCod = A911ImpLiqTipoConCod ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
      }
   }

   public void standaloneNotModal( )
   {
      edtImpLiqConAfipCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqConAfipCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqConAfipCod_Enabled), 5, 0), true);
      edtImpLiqConExtCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqConExtCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqConExtCod_Enabled), 5, 0), true);
      edtImpLiqConExtDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqConExtDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqConExtDescrip_Enabled), 5, 0), true);
      edtImpLiqConAfipCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqConAfipCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqConAfipCod_Enabled), 5, 0), true);
      edtImpLiqConExtCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqConExtCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqConExtCod_Enabled), 5, 0), true);
      edtImpLiqConExtDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqConExtDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqConExtDescrip_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV20CliCod) )
      {
         A3CliCod = AV20CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int9 = A3CliCod ;
            GXv_int10[0] = GXt_int9 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int10) ;
            importacion_conceptos_impl.this.GXt_int9 = GXv_int10[0] ;
            A3CliCod = GXt_int9 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV20CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV20CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV21EmpCod) )
      {
         A1EmpCod = AV21EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( ! (0==AV21EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV21EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV22ImpLiqSec) )
      {
         A88ImpLiqSec = AV22ImpLiqSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
      }
      if ( ! (0==AV22ImpLiqSec) )
      {
         edtImpLiqSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtImpLiqSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqSec_Enabled), 5, 0), true);
      }
      else
      {
         edtImpLiqSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtImpLiqSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV22ImpLiqSec) )
      {
         edtImpLiqSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtImpLiqSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqSec_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV23ImpLiqConExtCod)==0) )
      {
         A89ImpLiqConExtCod = AV23ImpLiqConExtCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
      }
   }

   public void standaloneModal( )
   {
      A641ImpLiqConSisCod = AV19ComboImpLiqConSisCod ;
      httpContext.ajax_rsp_assign_attri("", false, "A641ImpLiqConSisCod", A641ImpLiqConSisCod);
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
         AV24Pgmname = "importacion_conceptos" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      }
   }

   public void load2977( )
   {
      /* Using cursor T00295 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound77 = (short)(1) ;
         A701ImpLiqConExtCodYDescrip = T00295_A701ImpLiqConExtCodYDescrip[0] ;
         A641ImpLiqConSisCod = T00295_A641ImpLiqConSisCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A641ImpLiqConSisCod", A641ImpLiqConSisCod);
         A659ImpLiqConError = T00295_A659ImpLiqConError[0] ;
         A660ImpLiqConWarning = T00295_A660ImpLiqConWarning[0] ;
         A640ImpLiqConExtDescrip = T00295_A640ImpLiqConExtDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A640ImpLiqConExtDescrip", A640ImpLiqConExtDescrip);
         A2186ImpLiqConExtDesSinAc = T00295_A2186ImpLiqConExtDesSinAc[0] ;
         A642ImpLiqConAfipCod = T00295_A642ImpLiqConAfipCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A642ImpLiqConAfipCod", A642ImpLiqConAfipCod);
         A912ImpLiqAfipCodMasDesc = T00295_A912ImpLiqAfipCodMasDesc[0] ;
         A643ImpLiqSIPAApo = T00295_A643ImpLiqSIPAApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A643ImpLiqSIPAApo", A643ImpLiqSIPAApo);
         A644ImpLiqSIPACont = T00295_A644ImpLiqSIPACont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A644ImpLiqSIPACont", A644ImpLiqSIPACont);
         A645ImpLiqINSSJyPApo = T00295_A645ImpLiqINSSJyPApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A645ImpLiqINSSJyPApo", A645ImpLiqINSSJyPApo);
         A646ImpLiqINSSJyPCont = T00295_A646ImpLiqINSSJyPCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A646ImpLiqINSSJyPCont", A646ImpLiqINSSJyPCont);
         A647ImpLiqObraSocApo = T00295_A647ImpLiqObraSocApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A647ImpLiqObraSocApo", A647ImpLiqObraSocApo);
         A648ImpLiqObraSocCont = T00295_A648ImpLiqObraSocCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A648ImpLiqObraSocCont", A648ImpLiqObraSocCont);
         A649ImpLiqFonSolRedApo = T00295_A649ImpLiqFonSolRedApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A649ImpLiqFonSolRedApo", A649ImpLiqFonSolRedApo);
         A650ImpLiqFonSolRedCont = T00295_A650ImpLiqFonSolRedCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A650ImpLiqFonSolRedCont", A650ImpLiqFonSolRedCont);
         A651ImpLiqRenateaApo = T00295_A651ImpLiqRenateaApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A651ImpLiqRenateaApo", A651ImpLiqRenateaApo);
         A652ImpLiqRenateaCont = T00295_A652ImpLiqRenateaCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A652ImpLiqRenateaCont", A652ImpLiqRenateaCont);
         A653ImpLiqAsigFamCont = T00295_A653ImpLiqAsigFamCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A653ImpLiqAsigFamCont", A653ImpLiqAsigFamCont);
         A654ImpLiqFonNacEmpCont = T00295_A654ImpLiqFonNacEmpCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A654ImpLiqFonNacEmpCont", A654ImpLiqFonNacEmpCont);
         A655ImpLiqLeyRieTrabCont = T00295_A655ImpLiqLeyRieTrabCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A655ImpLiqLeyRieTrabCont", A655ImpLiqLeyRieTrabCont);
         A656ImpLiqRegDifApo = T00295_A656ImpLiqRegDifApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A656ImpLiqRegDifApo", A656ImpLiqRegDifApo);
         A657ImpLiqRegEspApo = T00295_A657ImpLiqRegEspApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A657ImpLiqRegEspApo", A657ImpLiqRegEspApo);
         A702ImpLiqConSisCodYDescrip = T00295_A702ImpLiqConSisCodYDescrip[0] ;
         A911ImpLiqTipoConCod = T00295_A911ImpLiqTipoConCod[0] ;
         zm2977( -32) ;
      }
      pr_default.close(3);
      onLoadActions2977( ) ;
   }

   public void onLoadActions2977( )
   {
      AV24Pgmname = "importacion_conceptos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      A701ImpLiqConExtCodYDescrip = GXutil.trim( A89ImpLiqConExtCod) + " - " + GXutil.trim( A640ImpLiqConExtDescrip) ;
      httpContext.ajax_rsp_assign_attri("", false, "A701ImpLiqConExtCodYDescrip", A701ImpLiqConExtCodYDescrip);
   }

   public void checkExtendedTable2977( )
   {
      nIsDirty_77 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV24Pgmname = "importacion_conceptos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      /* Using cursor T00294 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      nIsDirty_77 = (short)(1) ;
      A701ImpLiqConExtCodYDescrip = GXutil.trim( A89ImpLiqConExtCod) + " - " + GXutil.trim( A640ImpLiqConExtDescrip) ;
      httpContext.ajax_rsp_assign_attri("", false, "A701ImpLiqConExtCodYDescrip", A701ImpLiqConExtCodYDescrip);
      if ( (GXutil.strcmp("", A641ImpLiqConSisCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Concepto Sistema", ""), "", "", "", "", "", "", "", ""), 1, "IMPLIQCONSISCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtImpLiqConSisCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A643ImpLiqSIPAApo, "1") == 0 ) || ( GXutil.strcmp(A643ImpLiqSIPAApo, "0") == 0 ) || ( GXutil.strcmp(A643ImpLiqSIPAApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq SIPAApo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQSIPAAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqSIPAApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A644ImpLiqSIPACont, "1") == 0 ) || ( GXutil.strcmp(A644ImpLiqSIPACont, "0") == 0 ) || ( GXutil.strcmp(A644ImpLiqSIPACont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq SIPACont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQSIPACONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqSIPACont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A645ImpLiqINSSJyPApo, "1") == 0 ) || ( GXutil.strcmp(A645ImpLiqINSSJyPApo, "0") == 0 ) || ( GXutil.strcmp(A645ImpLiqINSSJyPApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq INSSJy PApo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQINSSJYPAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqINSSJyPApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A646ImpLiqINSSJyPCont, "1") == 0 ) || ( GXutil.strcmp(A646ImpLiqINSSJyPCont, "0") == 0 ) || ( GXutil.strcmp(A646ImpLiqINSSJyPCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq INSSJy PCont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQINSSJYPCONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqINSSJyPCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A647ImpLiqObraSocApo, "1") == 0 ) || ( GXutil.strcmp(A647ImpLiqObraSocApo, "0") == 0 ) || ( GXutil.strcmp(A647ImpLiqObraSocApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Obra Soc Apo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQOBRASOCAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqObraSocApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A648ImpLiqObraSocCont, "1") == 0 ) || ( GXutil.strcmp(A648ImpLiqObraSocCont, "0") == 0 ) || ( GXutil.strcmp(A648ImpLiqObraSocCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Obra Soc Cont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQOBRASOCCONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqObraSocCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A649ImpLiqFonSolRedApo, "1") == 0 ) || ( GXutil.strcmp(A649ImpLiqFonSolRedApo, "0") == 0 ) || ( GXutil.strcmp(A649ImpLiqFonSolRedApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Fon Sol Red Apo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQFONSOLREDAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqFonSolRedApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A650ImpLiqFonSolRedCont, "1") == 0 ) || ( GXutil.strcmp(A650ImpLiqFonSolRedCont, "0") == 0 ) || ( GXutil.strcmp(A650ImpLiqFonSolRedCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Fon Sol Red Cont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQFONSOLREDCONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqFonSolRedCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A651ImpLiqRenateaApo, "1") == 0 ) || ( GXutil.strcmp(A651ImpLiqRenateaApo, "0") == 0 ) || ( GXutil.strcmp(A651ImpLiqRenateaApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Renatea Apo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQRENATEAAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqRenateaApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A652ImpLiqRenateaCont, "1") == 0 ) || ( GXutil.strcmp(A652ImpLiqRenateaCont, "0") == 0 ) || ( GXutil.strcmp(A652ImpLiqRenateaCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Renatea Cont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQRENATEACONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqRenateaCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A653ImpLiqAsigFamCont, "1") == 0 ) || ( GXutil.strcmp(A653ImpLiqAsigFamCont, "0") == 0 ) || ( GXutil.strcmp(A653ImpLiqAsigFamCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Asig Fam Cont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQASIGFAMCONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqAsigFamCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A654ImpLiqFonNacEmpCont, "1") == 0 ) || ( GXutil.strcmp(A654ImpLiqFonNacEmpCont, "0") == 0 ) || ( GXutil.strcmp(A654ImpLiqFonNacEmpCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Fon Nac Emp Cont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQFONNACEMPCONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqFonNacEmpCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A655ImpLiqLeyRieTrabCont, "1") == 0 ) || ( GXutil.strcmp(A655ImpLiqLeyRieTrabCont, "0") == 0 ) || ( GXutil.strcmp(A655ImpLiqLeyRieTrabCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Ley Rie Trab Cont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQLEYRIETRABCONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqLeyRieTrabCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A656ImpLiqRegDifApo, "1") == 0 ) || ( GXutil.strcmp(A656ImpLiqRegDifApo, "0") == 0 ) || ( GXutil.strcmp(A656ImpLiqRegDifApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Reg Dif Apo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQREGDIFAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqRegDifApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A657ImpLiqRegEspApo, "1") == 0 ) || ( GXutil.strcmp(A657ImpLiqRegEspApo, "0") == 0 ) || ( GXutil.strcmp(A657ImpLiqRegEspApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Reg Esp Apo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "IMPLIQREGESPAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbImpLiqRegEspApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors2977( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_33( int A3CliCod ,
                          short A1EmpCod ,
                          short A88ImpLiqSec )
   {
      /* Using cursor T00296 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey2977( )
   {
      /* Using cursor T00297 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound77 = (short)(1) ;
      }
      else
      {
         RcdFound77 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00293 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2977( 32) ;
         RcdFound77 = (short)(1) ;
         A701ImpLiqConExtCodYDescrip = T00293_A701ImpLiqConExtCodYDescrip[0] ;
         A89ImpLiqConExtCod = T00293_A89ImpLiqConExtCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
         A641ImpLiqConSisCod = T00293_A641ImpLiqConSisCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A641ImpLiqConSisCod", A641ImpLiqConSisCod);
         A659ImpLiqConError = T00293_A659ImpLiqConError[0] ;
         A660ImpLiqConWarning = T00293_A660ImpLiqConWarning[0] ;
         A640ImpLiqConExtDescrip = T00293_A640ImpLiqConExtDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A640ImpLiqConExtDescrip", A640ImpLiqConExtDescrip);
         A2186ImpLiqConExtDesSinAc = T00293_A2186ImpLiqConExtDesSinAc[0] ;
         A642ImpLiqConAfipCod = T00293_A642ImpLiqConAfipCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A642ImpLiqConAfipCod", A642ImpLiqConAfipCod);
         A912ImpLiqAfipCodMasDesc = T00293_A912ImpLiqAfipCodMasDesc[0] ;
         A643ImpLiqSIPAApo = T00293_A643ImpLiqSIPAApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A643ImpLiqSIPAApo", A643ImpLiqSIPAApo);
         A644ImpLiqSIPACont = T00293_A644ImpLiqSIPACont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A644ImpLiqSIPACont", A644ImpLiqSIPACont);
         A645ImpLiqINSSJyPApo = T00293_A645ImpLiqINSSJyPApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A645ImpLiqINSSJyPApo", A645ImpLiqINSSJyPApo);
         A646ImpLiqINSSJyPCont = T00293_A646ImpLiqINSSJyPCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A646ImpLiqINSSJyPCont", A646ImpLiqINSSJyPCont);
         A647ImpLiqObraSocApo = T00293_A647ImpLiqObraSocApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A647ImpLiqObraSocApo", A647ImpLiqObraSocApo);
         A648ImpLiqObraSocCont = T00293_A648ImpLiqObraSocCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A648ImpLiqObraSocCont", A648ImpLiqObraSocCont);
         A649ImpLiqFonSolRedApo = T00293_A649ImpLiqFonSolRedApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A649ImpLiqFonSolRedApo", A649ImpLiqFonSolRedApo);
         A650ImpLiqFonSolRedCont = T00293_A650ImpLiqFonSolRedCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A650ImpLiqFonSolRedCont", A650ImpLiqFonSolRedCont);
         A651ImpLiqRenateaApo = T00293_A651ImpLiqRenateaApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A651ImpLiqRenateaApo", A651ImpLiqRenateaApo);
         A652ImpLiqRenateaCont = T00293_A652ImpLiqRenateaCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A652ImpLiqRenateaCont", A652ImpLiqRenateaCont);
         A653ImpLiqAsigFamCont = T00293_A653ImpLiqAsigFamCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A653ImpLiqAsigFamCont", A653ImpLiqAsigFamCont);
         A654ImpLiqFonNacEmpCont = T00293_A654ImpLiqFonNacEmpCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A654ImpLiqFonNacEmpCont", A654ImpLiqFonNacEmpCont);
         A655ImpLiqLeyRieTrabCont = T00293_A655ImpLiqLeyRieTrabCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A655ImpLiqLeyRieTrabCont", A655ImpLiqLeyRieTrabCont);
         A656ImpLiqRegDifApo = T00293_A656ImpLiqRegDifApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A656ImpLiqRegDifApo", A656ImpLiqRegDifApo);
         A657ImpLiqRegEspApo = T00293_A657ImpLiqRegEspApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A657ImpLiqRegEspApo", A657ImpLiqRegEspApo);
         A702ImpLiqConSisCodYDescrip = T00293_A702ImpLiqConSisCodYDescrip[0] ;
         A911ImpLiqTipoConCod = T00293_A911ImpLiqTipoConCod[0] ;
         A3CliCod = T00293_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T00293_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A88ImpLiqSec = T00293_A88ImpLiqSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
         Z89ImpLiqConExtCod = A89ImpLiqConExtCod ;
         sMode77 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2977( ) ;
         if ( AnyError == 1 )
         {
            RcdFound77 = (short)(0) ;
            initializeNonKey2977( ) ;
         }
         Gx_mode = sMode77 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound77 = (short)(0) ;
         initializeNonKey2977( ) ;
         sMode77 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode77 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey2977( ) ;
      if ( RcdFound77 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound77 = (short)(0) ;
      /* Using cursor T00298 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A88ImpLiqSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A89ImpLiqConExtCod});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00298_A3CliCod[0] < A3CliCod ) || ( T00298_A3CliCod[0] == A3CliCod ) && ( T00298_A1EmpCod[0] < A1EmpCod ) || ( T00298_A1EmpCod[0] == A1EmpCod ) && ( T00298_A3CliCod[0] == A3CliCod ) && ( T00298_A88ImpLiqSec[0] < A88ImpLiqSec ) || ( T00298_A88ImpLiqSec[0] == A88ImpLiqSec ) && ( T00298_A1EmpCod[0] == A1EmpCod ) && ( T00298_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00298_A89ImpLiqConExtCod[0], A89ImpLiqConExtCod) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00298_A3CliCod[0] > A3CliCod ) || ( T00298_A3CliCod[0] == A3CliCod ) && ( T00298_A1EmpCod[0] > A1EmpCod ) || ( T00298_A1EmpCod[0] == A1EmpCod ) && ( T00298_A3CliCod[0] == A3CliCod ) && ( T00298_A88ImpLiqSec[0] > A88ImpLiqSec ) || ( T00298_A88ImpLiqSec[0] == A88ImpLiqSec ) && ( T00298_A1EmpCod[0] == A1EmpCod ) && ( T00298_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00298_A89ImpLiqConExtCod[0], A89ImpLiqConExtCod) > 0 ) ) )
         {
            A3CliCod = T00298_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T00298_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A88ImpLiqSec = T00298_A88ImpLiqSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
            A89ImpLiqConExtCod = T00298_A89ImpLiqConExtCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
            RcdFound77 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound77 = (short)(0) ;
      /* Using cursor T00299 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A88ImpLiqSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A89ImpLiqConExtCod});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00299_A3CliCod[0] > A3CliCod ) || ( T00299_A3CliCod[0] == A3CliCod ) && ( T00299_A1EmpCod[0] > A1EmpCod ) || ( T00299_A1EmpCod[0] == A1EmpCod ) && ( T00299_A3CliCod[0] == A3CliCod ) && ( T00299_A88ImpLiqSec[0] > A88ImpLiqSec ) || ( T00299_A88ImpLiqSec[0] == A88ImpLiqSec ) && ( T00299_A1EmpCod[0] == A1EmpCod ) && ( T00299_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00299_A89ImpLiqConExtCod[0], A89ImpLiqConExtCod) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00299_A3CliCod[0] < A3CliCod ) || ( T00299_A3CliCod[0] == A3CliCod ) && ( T00299_A1EmpCod[0] < A1EmpCod ) || ( T00299_A1EmpCod[0] == A1EmpCod ) && ( T00299_A3CliCod[0] == A3CliCod ) && ( T00299_A88ImpLiqSec[0] < A88ImpLiqSec ) || ( T00299_A88ImpLiqSec[0] == A88ImpLiqSec ) && ( T00299_A1EmpCod[0] == A1EmpCod ) && ( T00299_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00299_A89ImpLiqConExtCod[0], A89ImpLiqConExtCod) < 0 ) ) )
         {
            A3CliCod = T00299_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T00299_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A88ImpLiqSec = T00299_A88ImpLiqSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
            A89ImpLiqConExtCod = T00299_A89ImpLiqConExtCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
            RcdFound77 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2977( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtImpLiqConSisCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2977( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound77 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( GXutil.strcmp(A89ImpLiqConExtCod, Z89ImpLiqConExtCod) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A88ImpLiqSec = Z88ImpLiqSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
               A89ImpLiqConExtCod = Z89ImpLiqConExtCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtImpLiqConSisCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update2977( ) ;
               GX_FocusControl = edtImpLiqConSisCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( GXutil.strcmp(A89ImpLiqConExtCod, Z89ImpLiqConExtCod) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtImpLiqConSisCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2977( ) ;
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
                  GX_FocusControl = edtImpLiqConSisCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert2977( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( GXutil.strcmp(A89ImpLiqConExtCod, Z89ImpLiqConExtCod) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A88ImpLiqSec = Z88ImpLiqSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
         A89ImpLiqConExtCod = Z89ImpLiqConExtCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtImpLiqConSisCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency2977( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00292 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_conceptos"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z701ImpLiqConExtCodYDescrip, T00292_A701ImpLiqConExtCodYDescrip[0]) != 0 ) || ( GXutil.strcmp(Z641ImpLiqConSisCod, T00292_A641ImpLiqConSisCod[0]) != 0 ) || ( GXutil.strcmp(Z659ImpLiqConError, T00292_A659ImpLiqConError[0]) != 0 ) || ( GXutil.strcmp(Z660ImpLiqConWarning, T00292_A660ImpLiqConWarning[0]) != 0 ) || ( GXutil.strcmp(Z640ImpLiqConExtDescrip, T00292_A640ImpLiqConExtDescrip[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2186ImpLiqConExtDesSinAc, T00292_A2186ImpLiqConExtDesSinAc[0]) != 0 ) || ( GXutil.strcmp(Z642ImpLiqConAfipCod, T00292_A642ImpLiqConAfipCod[0]) != 0 ) || ( GXutil.strcmp(Z912ImpLiqAfipCodMasDesc, T00292_A912ImpLiqAfipCodMasDesc[0]) != 0 ) || ( GXutil.strcmp(Z643ImpLiqSIPAApo, T00292_A643ImpLiqSIPAApo[0]) != 0 ) || ( GXutil.strcmp(Z644ImpLiqSIPACont, T00292_A644ImpLiqSIPACont[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z645ImpLiqINSSJyPApo, T00292_A645ImpLiqINSSJyPApo[0]) != 0 ) || ( GXutil.strcmp(Z646ImpLiqINSSJyPCont, T00292_A646ImpLiqINSSJyPCont[0]) != 0 ) || ( GXutil.strcmp(Z647ImpLiqObraSocApo, T00292_A647ImpLiqObraSocApo[0]) != 0 ) || ( GXutil.strcmp(Z648ImpLiqObraSocCont, T00292_A648ImpLiqObraSocCont[0]) != 0 ) || ( GXutil.strcmp(Z649ImpLiqFonSolRedApo, T00292_A649ImpLiqFonSolRedApo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z650ImpLiqFonSolRedCont, T00292_A650ImpLiqFonSolRedCont[0]) != 0 ) || ( GXutil.strcmp(Z651ImpLiqRenateaApo, T00292_A651ImpLiqRenateaApo[0]) != 0 ) || ( GXutil.strcmp(Z652ImpLiqRenateaCont, T00292_A652ImpLiqRenateaCont[0]) != 0 ) || ( GXutil.strcmp(Z653ImpLiqAsigFamCont, T00292_A653ImpLiqAsigFamCont[0]) != 0 ) || ( GXutil.strcmp(Z654ImpLiqFonNacEmpCont, T00292_A654ImpLiqFonNacEmpCont[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z655ImpLiqLeyRieTrabCont, T00292_A655ImpLiqLeyRieTrabCont[0]) != 0 ) || ( GXutil.strcmp(Z656ImpLiqRegDifApo, T00292_A656ImpLiqRegDifApo[0]) != 0 ) || ( GXutil.strcmp(Z657ImpLiqRegEspApo, T00292_A657ImpLiqRegEspApo[0]) != 0 ) || ( GXutil.strcmp(Z702ImpLiqConSisCodYDescrip, T00292_A702ImpLiqConSisCodYDescrip[0]) != 0 ) || ( GXutil.strcmp(Z911ImpLiqTipoConCod, T00292_A911ImpLiqTipoConCod[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z701ImpLiqConExtCodYDescrip, T00292_A701ImpLiqConExtCodYDescrip[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqConExtCodYDescrip");
               GXutil.writeLogRaw("Old: ",Z701ImpLiqConExtCodYDescrip);
               GXutil.writeLogRaw("Current: ",T00292_A701ImpLiqConExtCodYDescrip[0]);
            }
            if ( GXutil.strcmp(Z641ImpLiqConSisCod, T00292_A641ImpLiqConSisCod[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqConSisCod");
               GXutil.writeLogRaw("Old: ",Z641ImpLiqConSisCod);
               GXutil.writeLogRaw("Current: ",T00292_A641ImpLiqConSisCod[0]);
            }
            if ( GXutil.strcmp(Z659ImpLiqConError, T00292_A659ImpLiqConError[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqConError");
               GXutil.writeLogRaw("Old: ",Z659ImpLiqConError);
               GXutil.writeLogRaw("Current: ",T00292_A659ImpLiqConError[0]);
            }
            if ( GXutil.strcmp(Z660ImpLiqConWarning, T00292_A660ImpLiqConWarning[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqConWarning");
               GXutil.writeLogRaw("Old: ",Z660ImpLiqConWarning);
               GXutil.writeLogRaw("Current: ",T00292_A660ImpLiqConWarning[0]);
            }
            if ( GXutil.strcmp(Z640ImpLiqConExtDescrip, T00292_A640ImpLiqConExtDescrip[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqConExtDescrip");
               GXutil.writeLogRaw("Old: ",Z640ImpLiqConExtDescrip);
               GXutil.writeLogRaw("Current: ",T00292_A640ImpLiqConExtDescrip[0]);
            }
            if ( GXutil.strcmp(Z2186ImpLiqConExtDesSinAc, T00292_A2186ImpLiqConExtDesSinAc[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqConExtDesSinAc");
               GXutil.writeLogRaw("Old: ",Z2186ImpLiqConExtDesSinAc);
               GXutil.writeLogRaw("Current: ",T00292_A2186ImpLiqConExtDesSinAc[0]);
            }
            if ( GXutil.strcmp(Z642ImpLiqConAfipCod, T00292_A642ImpLiqConAfipCod[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqConAfipCod");
               GXutil.writeLogRaw("Old: ",Z642ImpLiqConAfipCod);
               GXutil.writeLogRaw("Current: ",T00292_A642ImpLiqConAfipCod[0]);
            }
            if ( GXutil.strcmp(Z912ImpLiqAfipCodMasDesc, T00292_A912ImpLiqAfipCodMasDesc[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqAfipCodMasDesc");
               GXutil.writeLogRaw("Old: ",Z912ImpLiqAfipCodMasDesc);
               GXutil.writeLogRaw("Current: ",T00292_A912ImpLiqAfipCodMasDesc[0]);
            }
            if ( GXutil.strcmp(Z643ImpLiqSIPAApo, T00292_A643ImpLiqSIPAApo[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqSIPAApo");
               GXutil.writeLogRaw("Old: ",Z643ImpLiqSIPAApo);
               GXutil.writeLogRaw("Current: ",T00292_A643ImpLiqSIPAApo[0]);
            }
            if ( GXutil.strcmp(Z644ImpLiqSIPACont, T00292_A644ImpLiqSIPACont[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqSIPACont");
               GXutil.writeLogRaw("Old: ",Z644ImpLiqSIPACont);
               GXutil.writeLogRaw("Current: ",T00292_A644ImpLiqSIPACont[0]);
            }
            if ( GXutil.strcmp(Z645ImpLiqINSSJyPApo, T00292_A645ImpLiqINSSJyPApo[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqINSSJyPApo");
               GXutil.writeLogRaw("Old: ",Z645ImpLiqINSSJyPApo);
               GXutil.writeLogRaw("Current: ",T00292_A645ImpLiqINSSJyPApo[0]);
            }
            if ( GXutil.strcmp(Z646ImpLiqINSSJyPCont, T00292_A646ImpLiqINSSJyPCont[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqINSSJyPCont");
               GXutil.writeLogRaw("Old: ",Z646ImpLiqINSSJyPCont);
               GXutil.writeLogRaw("Current: ",T00292_A646ImpLiqINSSJyPCont[0]);
            }
            if ( GXutil.strcmp(Z647ImpLiqObraSocApo, T00292_A647ImpLiqObraSocApo[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqObraSocApo");
               GXutil.writeLogRaw("Old: ",Z647ImpLiqObraSocApo);
               GXutil.writeLogRaw("Current: ",T00292_A647ImpLiqObraSocApo[0]);
            }
            if ( GXutil.strcmp(Z648ImpLiqObraSocCont, T00292_A648ImpLiqObraSocCont[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqObraSocCont");
               GXutil.writeLogRaw("Old: ",Z648ImpLiqObraSocCont);
               GXutil.writeLogRaw("Current: ",T00292_A648ImpLiqObraSocCont[0]);
            }
            if ( GXutil.strcmp(Z649ImpLiqFonSolRedApo, T00292_A649ImpLiqFonSolRedApo[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqFonSolRedApo");
               GXutil.writeLogRaw("Old: ",Z649ImpLiqFonSolRedApo);
               GXutil.writeLogRaw("Current: ",T00292_A649ImpLiqFonSolRedApo[0]);
            }
            if ( GXutil.strcmp(Z650ImpLiqFonSolRedCont, T00292_A650ImpLiqFonSolRedCont[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqFonSolRedCont");
               GXutil.writeLogRaw("Old: ",Z650ImpLiqFonSolRedCont);
               GXutil.writeLogRaw("Current: ",T00292_A650ImpLiqFonSolRedCont[0]);
            }
            if ( GXutil.strcmp(Z651ImpLiqRenateaApo, T00292_A651ImpLiqRenateaApo[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqRenateaApo");
               GXutil.writeLogRaw("Old: ",Z651ImpLiqRenateaApo);
               GXutil.writeLogRaw("Current: ",T00292_A651ImpLiqRenateaApo[0]);
            }
            if ( GXutil.strcmp(Z652ImpLiqRenateaCont, T00292_A652ImpLiqRenateaCont[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqRenateaCont");
               GXutil.writeLogRaw("Old: ",Z652ImpLiqRenateaCont);
               GXutil.writeLogRaw("Current: ",T00292_A652ImpLiqRenateaCont[0]);
            }
            if ( GXutil.strcmp(Z653ImpLiqAsigFamCont, T00292_A653ImpLiqAsigFamCont[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqAsigFamCont");
               GXutil.writeLogRaw("Old: ",Z653ImpLiqAsigFamCont);
               GXutil.writeLogRaw("Current: ",T00292_A653ImpLiqAsigFamCont[0]);
            }
            if ( GXutil.strcmp(Z654ImpLiqFonNacEmpCont, T00292_A654ImpLiqFonNacEmpCont[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqFonNacEmpCont");
               GXutil.writeLogRaw("Old: ",Z654ImpLiqFonNacEmpCont);
               GXutil.writeLogRaw("Current: ",T00292_A654ImpLiqFonNacEmpCont[0]);
            }
            if ( GXutil.strcmp(Z655ImpLiqLeyRieTrabCont, T00292_A655ImpLiqLeyRieTrabCont[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqLeyRieTrabCont");
               GXutil.writeLogRaw("Old: ",Z655ImpLiqLeyRieTrabCont);
               GXutil.writeLogRaw("Current: ",T00292_A655ImpLiqLeyRieTrabCont[0]);
            }
            if ( GXutil.strcmp(Z656ImpLiqRegDifApo, T00292_A656ImpLiqRegDifApo[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqRegDifApo");
               GXutil.writeLogRaw("Old: ",Z656ImpLiqRegDifApo);
               GXutil.writeLogRaw("Current: ",T00292_A656ImpLiqRegDifApo[0]);
            }
            if ( GXutil.strcmp(Z657ImpLiqRegEspApo, T00292_A657ImpLiqRegEspApo[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqRegEspApo");
               GXutil.writeLogRaw("Old: ",Z657ImpLiqRegEspApo);
               GXutil.writeLogRaw("Current: ",T00292_A657ImpLiqRegEspApo[0]);
            }
            if ( GXutil.strcmp(Z702ImpLiqConSisCodYDescrip, T00292_A702ImpLiqConSisCodYDescrip[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqConSisCodYDescrip");
               GXutil.writeLogRaw("Old: ",Z702ImpLiqConSisCodYDescrip);
               GXutil.writeLogRaw("Current: ",T00292_A702ImpLiqConSisCodYDescrip[0]);
            }
            if ( GXutil.strcmp(Z911ImpLiqTipoConCod, T00292_A911ImpLiqTipoConCod[0]) != 0 )
            {
               GXutil.writeLogln("importacion_conceptos:[seudo value changed for attri]"+"ImpLiqTipoConCod");
               GXutil.writeLogRaw("Old: ",Z911ImpLiqTipoConCod);
               GXutil.writeLogRaw("Current: ",T00292_A911ImpLiqTipoConCod[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"importacion_conceptos"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2977( )
   {
      beforeValidate2977( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2977( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2977( 0) ;
         checkOptimisticConcurrency2977( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2977( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2977( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002910 */
                  pr_default.execute(8, new Object[] {A701ImpLiqConExtCodYDescrip, A89ImpLiqConExtCod, A641ImpLiqConSisCod, A659ImpLiqConError, A660ImpLiqConWarning, A640ImpLiqConExtDescrip, A2186ImpLiqConExtDesSinAc, A642ImpLiqConAfipCod, A912ImpLiqAfipCodMasDesc, A643ImpLiqSIPAApo, A644ImpLiqSIPACont, A645ImpLiqINSSJyPApo, A646ImpLiqINSSJyPCont, A647ImpLiqObraSocApo, A648ImpLiqObraSocCont, A649ImpLiqFonSolRedApo, A650ImpLiqFonSolRedCont, A651ImpLiqRenateaApo, A652ImpLiqRenateaCont, A653ImpLiqAsigFamCont, A654ImpLiqFonNacEmpCont, A655ImpLiqLeyRieTrabCont, A656ImpLiqRegDifApo, A657ImpLiqRegEspApo, A702ImpLiqConSisCodYDescrip, A911ImpLiqTipoConCod, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_conceptos");
                  if ( (pr_default.getStatus(8) == 1) )
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
                        resetCaption290( ) ;
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
            load2977( ) ;
         }
         endLevel2977( ) ;
      }
      closeExtendedTableCursors2977( ) ;
   }

   public void update2977( )
   {
      beforeValidate2977( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2977( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2977( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2977( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2977( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002911 */
                  pr_default.execute(9, new Object[] {A701ImpLiqConExtCodYDescrip, A641ImpLiqConSisCod, A659ImpLiqConError, A660ImpLiqConWarning, A640ImpLiqConExtDescrip, A2186ImpLiqConExtDesSinAc, A642ImpLiqConAfipCod, A912ImpLiqAfipCodMasDesc, A643ImpLiqSIPAApo, A644ImpLiqSIPACont, A645ImpLiqINSSJyPApo, A646ImpLiqINSSJyPCont, A647ImpLiqObraSocApo, A648ImpLiqObraSocCont, A649ImpLiqFonSolRedApo, A650ImpLiqFonSolRedCont, A651ImpLiqRenateaApo, A652ImpLiqRenateaCont, A653ImpLiqAsigFamCont, A654ImpLiqFonNacEmpCont, A655ImpLiqLeyRieTrabCont, A656ImpLiqRegDifApo, A657ImpLiqRegEspApo, A702ImpLiqConSisCodYDescrip, A911ImpLiqTipoConCod, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_conceptos");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_conceptos"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2977( ) ;
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
         endLevel2977( ) ;
      }
      closeExtendedTableCursors2977( ) ;
   }

   public void deferredUpdate2977( )
   {
   }

   public void delete( )
   {
      beforeValidate2977( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2977( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2977( ) ;
         afterConfirm2977( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2977( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002912 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_conceptos");
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
      sMode77 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2977( ) ;
      Gx_mode = sMode77 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2977( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV24Pgmname = "importacion_conceptos" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      }
   }

   public void endLevel2977( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2977( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "importacion_conceptos");
         if ( AnyError == 0 )
         {
            confirmValues290( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "importacion_conceptos");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2977( )
   {
      /* Scan By routine */
      /* Using cursor T002913 */
      pr_default.execute(11);
      RcdFound77 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound77 = (short)(1) ;
         A3CliCod = T002913_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002913_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A88ImpLiqSec = T002913_A88ImpLiqSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
         A89ImpLiqConExtCod = T002913_A89ImpLiqConExtCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2977( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound77 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound77 = (short)(1) ;
         A3CliCod = T002913_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002913_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A88ImpLiqSec = T002913_A88ImpLiqSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
         A89ImpLiqConExtCod = T002913_A89ImpLiqConExtCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
      }
   }

   public void scanEnd2977( )
   {
      pr_default.close(11);
   }

   public void afterConfirm2977( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2977( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2977( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2977( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2977( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2977( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2977( )
   {
      edtImpLiqConAfipCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqConAfipCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqConAfipCod_Enabled), 5, 0), true);
      edtImpLiqConExtCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqConExtCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqConExtCod_Enabled), 5, 0), true);
      edtImpLiqConExtDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqConExtDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqConExtDescrip_Enabled), 5, 0), true);
      edtImpLiqConSisCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqConSisCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqConSisCod_Enabled), 5, 0), true);
      cmbImpLiqSIPAApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqSIPAApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqSIPAApo.getEnabled(), 5, 0), true);
      cmbImpLiqSIPACont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqSIPACont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqSIPACont.getEnabled(), 5, 0), true);
      cmbImpLiqINSSJyPApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqINSSJyPApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqINSSJyPApo.getEnabled(), 5, 0), true);
      cmbImpLiqINSSJyPCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqINSSJyPCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqINSSJyPCont.getEnabled(), 5, 0), true);
      cmbImpLiqObraSocApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqObraSocApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqObraSocApo.getEnabled(), 5, 0), true);
      cmbImpLiqObraSocCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqObraSocCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqObraSocCont.getEnabled(), 5, 0), true);
      cmbImpLiqFonSolRedApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqFonSolRedApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqFonSolRedApo.getEnabled(), 5, 0), true);
      cmbImpLiqFonSolRedCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqFonSolRedCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqFonSolRedCont.getEnabled(), 5, 0), true);
      cmbImpLiqRenateaApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqRenateaApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqRenateaApo.getEnabled(), 5, 0), true);
      cmbImpLiqRenateaCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqRenateaCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqRenateaCont.getEnabled(), 5, 0), true);
      cmbImpLiqAsigFamCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqAsigFamCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqAsigFamCont.getEnabled(), 5, 0), true);
      cmbImpLiqFonNacEmpCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqFonNacEmpCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqFonNacEmpCont.getEnabled(), 5, 0), true);
      cmbImpLiqLeyRieTrabCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqLeyRieTrabCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqLeyRieTrabCont.getEnabled(), 5, 0), true);
      cmbImpLiqRegDifApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqRegDifApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqRegDifApo.getEnabled(), 5, 0), true);
      cmbImpLiqRegEspApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbImpLiqRegEspApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbImpLiqRegEspApo.getEnabled(), 5, 0), true);
      edtavComboimpliqconsiscod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboimpliqconsiscod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboimpliqconsiscod_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtImpLiqSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqSec_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2977( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues290( )
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.importacion_conceptos", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV20CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV21EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV22ImpLiqSec,4,0)),GXutil.URLEncode(GXutil.rtrim(AV23ImpLiqConExtCod))}, new String[] {"Gx_mode","CliCod","EmpCod","ImpLiqSec","ImpLiqConExtCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"importacion_conceptos");
      forbiddenHiddens.add("ImpLiqConAfipCod", GXutil.rtrim( localUtil.format( A642ImpLiqConAfipCod, "")));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ImpLiqConError", GXutil.rtrim( localUtil.format( A659ImpLiqConError, "")));
      forbiddenHiddens.add("ImpLiqConWarning", GXutil.rtrim( localUtil.format( A660ImpLiqConWarning, "")));
      forbiddenHiddens.add("ImpLiqConExtDescrip", GXutil.rtrim( localUtil.format( A640ImpLiqConExtDescrip, "")));
      forbiddenHiddens.add("ImpLiqConExtDesSinAc", GXutil.rtrim( localUtil.format( A2186ImpLiqConExtDesSinAc, "")));
      forbiddenHiddens.add("ImpLiqAfipCodMasDesc", GXutil.rtrim( localUtil.format( A912ImpLiqAfipCodMasDesc, "")));
      forbiddenHiddens.add("ImpLiqConSisCodYDescrip", GXutil.rtrim( localUtil.format( A702ImpLiqConSisCodYDescrip, "")));
      forbiddenHiddens.add("ImpLiqTipoConCod", GXutil.rtrim( localUtil.format( A911ImpLiqTipoConCod, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("importacion_conceptos:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z88ImpLiqSec", GXutil.ltrim( localUtil.ntoc( Z88ImpLiqSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z89ImpLiqConExtCod", GXutil.rtrim( Z89ImpLiqConExtCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z701ImpLiqConExtCodYDescrip", Z701ImpLiqConExtCodYDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z641ImpLiqConSisCod", GXutil.rtrim( Z641ImpLiqConSisCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z659ImpLiqConError", Z659ImpLiqConError);
      web.GxWebStd.gx_hidden_field( httpContext, "Z660ImpLiqConWarning", Z660ImpLiqConWarning);
      web.GxWebStd.gx_hidden_field( httpContext, "Z640ImpLiqConExtDescrip", Z640ImpLiqConExtDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2186ImpLiqConExtDesSinAc", Z2186ImpLiqConExtDesSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z642ImpLiqConAfipCod", GXutil.rtrim( Z642ImpLiqConAfipCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z912ImpLiqAfipCodMasDesc", Z912ImpLiqAfipCodMasDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z643ImpLiqSIPAApo", GXutil.rtrim( Z643ImpLiqSIPAApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z644ImpLiqSIPACont", GXutil.rtrim( Z644ImpLiqSIPACont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z645ImpLiqINSSJyPApo", GXutil.rtrim( Z645ImpLiqINSSJyPApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z646ImpLiqINSSJyPCont", GXutil.rtrim( Z646ImpLiqINSSJyPCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z647ImpLiqObraSocApo", GXutil.rtrim( Z647ImpLiqObraSocApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z648ImpLiqObraSocCont", GXutil.rtrim( Z648ImpLiqObraSocCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z649ImpLiqFonSolRedApo", GXutil.rtrim( Z649ImpLiqFonSolRedApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z650ImpLiqFonSolRedCont", GXutil.rtrim( Z650ImpLiqFonSolRedCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z651ImpLiqRenateaApo", GXutil.rtrim( Z651ImpLiqRenateaApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z652ImpLiqRenateaCont", GXutil.rtrim( Z652ImpLiqRenateaCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z653ImpLiqAsigFamCont", GXutil.rtrim( Z653ImpLiqAsigFamCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z654ImpLiqFonNacEmpCont", GXutil.rtrim( Z654ImpLiqFonNacEmpCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z655ImpLiqLeyRieTrabCont", GXutil.rtrim( Z655ImpLiqLeyRieTrabCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z656ImpLiqRegDifApo", GXutil.rtrim( Z656ImpLiqRegDifApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z657ImpLiqRegEspApo", GXutil.rtrim( Z657ImpLiqRegEspApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z702ImpLiqConSisCodYDescrip", Z702ImpLiqConSisCodYDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z911ImpLiqTipoConCod", GXutil.rtrim( Z911ImpLiqTipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vIMPLIQCONSISCOD_DATA", AV16ImpLiqConSisCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vIMPLIQCONSISCOD_DATA", AV16ImpLiqConSisCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPLIQCONEXTCODYDESCRIP", A701ImpLiqConExtCodYDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV20CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV21EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vIMPLIQSEC", GXutil.ltrim( localUtil.ntoc( AV22ImpLiqSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIMPLIQSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV22ImpLiqSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vIMPLIQCONEXTCOD", GXutil.rtrim( AV23ImpLiqConExtCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIMPLIQCONEXTCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23ImpLiqConExtCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPLIQCONERROR", A659ImpLiqConError);
      web.GxWebStd.gx_hidden_field( httpContext, "IMPLIQCONWARNING", A660ImpLiqConWarning);
      web.GxWebStd.gx_hidden_field( httpContext, "IMPLIQCONEXTDESSINAC", A2186ImpLiqConExtDesSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "IMPLIQAFIPCODMASDESC", A912ImpLiqAfipCodMasDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "IMPLIQCONSISCODYDESCRIP", A702ImpLiqConSisCodYDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "IMPLIQTIPOCONCOD", GXutil.rtrim( A911ImpLiqTipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV24Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_IMPLIQCONSISCOD_Objectcall", GXutil.rtrim( Combo_impliqconsiscod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_IMPLIQCONSISCOD_Cls", GXutil.rtrim( Combo_impliqconsiscod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_IMPLIQCONSISCOD_Selectedvalue_set", GXutil.rtrim( Combo_impliqconsiscod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_IMPLIQCONSISCOD_Enabled", GXutil.booltostr( Combo_impliqconsiscod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_IMPLIQCONSISCOD_Emptyitem", GXutil.booltostr( Combo_impliqconsiscod_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_APOCONTR_Objectcall", GXutil.rtrim( Dvpanel_apocontr_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_APOCONTR_Enabled", GXutil.booltostr( Dvpanel_apocontr_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_APOCONTR_Width", GXutil.rtrim( Dvpanel_apocontr_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_APOCONTR_Autowidth", GXutil.booltostr( Dvpanel_apocontr_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_APOCONTR_Autoheight", GXutil.booltostr( Dvpanel_apocontr_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_APOCONTR_Cls", GXutil.rtrim( Dvpanel_apocontr_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_APOCONTR_Title", GXutil.rtrim( Dvpanel_apocontr_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_APOCONTR_Collapsible", GXutil.booltostr( Dvpanel_apocontr_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_APOCONTR_Collapsed", GXutil.booltostr( Dvpanel_apocontr_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_APOCONTR_Showcollapseicon", GXutil.booltostr( Dvpanel_apocontr_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_APOCONTR_Iconposition", GXutil.rtrim( Dvpanel_apocontr_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_APOCONTR_Autoscroll", GXutil.booltostr( Dvpanel_apocontr_Autoscroll));
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
      return formatLink("web.importacion_conceptos", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV20CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV21EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV22ImpLiqSec,4,0)),GXutil.URLEncode(GXutil.rtrim(AV23ImpLiqConExtCod))}, new String[] {"Gx_mode","CliCod","EmpCod","ImpLiqSec","ImpLiqConExtCod"})  ;
   }

   public String getPgmname( )
   {
      return "importacion_conceptos" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "importacion_conceptos", "") ;
   }

   public void initializeNonKey2977( )
   {
      A641ImpLiqConSisCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A641ImpLiqConSisCod", A641ImpLiqConSisCod);
      A701ImpLiqConExtCodYDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A701ImpLiqConExtCodYDescrip", A701ImpLiqConExtCodYDescrip);
      A659ImpLiqConError = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A659ImpLiqConError", A659ImpLiqConError);
      A660ImpLiqConWarning = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A660ImpLiqConWarning", A660ImpLiqConWarning);
      A640ImpLiqConExtDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A640ImpLiqConExtDescrip", A640ImpLiqConExtDescrip);
      A2186ImpLiqConExtDesSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2186ImpLiqConExtDesSinAc", A2186ImpLiqConExtDesSinAc);
      A642ImpLiqConAfipCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A642ImpLiqConAfipCod", A642ImpLiqConAfipCod);
      A912ImpLiqAfipCodMasDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A912ImpLiqAfipCodMasDesc", A912ImpLiqAfipCodMasDesc);
      A643ImpLiqSIPAApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A643ImpLiqSIPAApo", A643ImpLiqSIPAApo);
      A644ImpLiqSIPACont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A644ImpLiqSIPACont", A644ImpLiqSIPACont);
      A645ImpLiqINSSJyPApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A645ImpLiqINSSJyPApo", A645ImpLiqINSSJyPApo);
      A646ImpLiqINSSJyPCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A646ImpLiqINSSJyPCont", A646ImpLiqINSSJyPCont);
      A647ImpLiqObraSocApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A647ImpLiqObraSocApo", A647ImpLiqObraSocApo);
      A648ImpLiqObraSocCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A648ImpLiqObraSocCont", A648ImpLiqObraSocCont);
      A649ImpLiqFonSolRedApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A649ImpLiqFonSolRedApo", A649ImpLiqFonSolRedApo);
      A650ImpLiqFonSolRedCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A650ImpLiqFonSolRedCont", A650ImpLiqFonSolRedCont);
      A651ImpLiqRenateaApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A651ImpLiqRenateaApo", A651ImpLiqRenateaApo);
      A652ImpLiqRenateaCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A652ImpLiqRenateaCont", A652ImpLiqRenateaCont);
      A653ImpLiqAsigFamCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A653ImpLiqAsigFamCont", A653ImpLiqAsigFamCont);
      A654ImpLiqFonNacEmpCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A654ImpLiqFonNacEmpCont", A654ImpLiqFonNacEmpCont);
      A655ImpLiqLeyRieTrabCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A655ImpLiqLeyRieTrabCont", A655ImpLiqLeyRieTrabCont);
      A656ImpLiqRegDifApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A656ImpLiqRegDifApo", A656ImpLiqRegDifApo);
      A657ImpLiqRegEspApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A657ImpLiqRegEspApo", A657ImpLiqRegEspApo);
      A702ImpLiqConSisCodYDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A702ImpLiqConSisCodYDescrip", A702ImpLiqConSisCodYDescrip);
      A911ImpLiqTipoConCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A911ImpLiqTipoConCod", A911ImpLiqTipoConCod);
      Z701ImpLiqConExtCodYDescrip = "" ;
      Z641ImpLiqConSisCod = "" ;
      Z659ImpLiqConError = "" ;
      Z660ImpLiqConWarning = "" ;
      Z640ImpLiqConExtDescrip = "" ;
      Z2186ImpLiqConExtDesSinAc = "" ;
      Z642ImpLiqConAfipCod = "" ;
      Z912ImpLiqAfipCodMasDesc = "" ;
      Z643ImpLiqSIPAApo = "" ;
      Z644ImpLiqSIPACont = "" ;
      Z645ImpLiqINSSJyPApo = "" ;
      Z646ImpLiqINSSJyPCont = "" ;
      Z647ImpLiqObraSocApo = "" ;
      Z648ImpLiqObraSocCont = "" ;
      Z649ImpLiqFonSolRedApo = "" ;
      Z650ImpLiqFonSolRedCont = "" ;
      Z651ImpLiqRenateaApo = "" ;
      Z652ImpLiqRenateaCont = "" ;
      Z653ImpLiqAsigFamCont = "" ;
      Z654ImpLiqFonNacEmpCont = "" ;
      Z655ImpLiqLeyRieTrabCont = "" ;
      Z656ImpLiqRegDifApo = "" ;
      Z657ImpLiqRegEspApo = "" ;
      Z702ImpLiqConSisCodYDescrip = "" ;
      Z911ImpLiqTipoConCod = "" ;
   }

   public void initAll2977( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A88ImpLiqSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
      A89ImpLiqConExtCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
      initializeNonKey2977( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241220209813", true, true);
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
      httpContext.AddJavascriptSource("importacion_conceptos.js", "?20241220209813", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtImpLiqConAfipCod_Internalname = "IMPLIQCONAFIPCOD" ;
      edtImpLiqConExtCod_Internalname = "IMPLIQCONEXTCOD" ;
      edtImpLiqConExtDescrip_Internalname = "IMPLIQCONEXTDESCRIP" ;
      lblTextblockimpliqconsiscod_Internalname = "TEXTBLOCKIMPLIQCONSISCOD" ;
      Combo_impliqconsiscod_Internalname = "COMBO_IMPLIQCONSISCOD" ;
      edtImpLiqConSisCod_Internalname = "IMPLIQCONSISCOD" ;
      divTablesplittedimpliqconsiscod_Internalname = "TABLESPLITTEDIMPLIQCONSISCOD" ;
      cmbImpLiqSIPAApo.setInternalname( "IMPLIQSIPAAPO" );
      cmbImpLiqSIPACont.setInternalname( "IMPLIQSIPACONT" );
      cmbImpLiqINSSJyPApo.setInternalname( "IMPLIQINSSJYPAPO" );
      cmbImpLiqINSSJyPCont.setInternalname( "IMPLIQINSSJYPCONT" );
      cmbImpLiqObraSocApo.setInternalname( "IMPLIQOBRASOCAPO" );
      cmbImpLiqObraSocCont.setInternalname( "IMPLIQOBRASOCCONT" );
      cmbImpLiqFonSolRedApo.setInternalname( "IMPLIQFONSOLREDAPO" );
      cmbImpLiqFonSolRedCont.setInternalname( "IMPLIQFONSOLREDCONT" );
      cmbImpLiqRenateaApo.setInternalname( "IMPLIQRENATEAAPO" );
      cmbImpLiqRenateaCont.setInternalname( "IMPLIQRENATEACONT" );
      cmbImpLiqAsigFamCont.setInternalname( "IMPLIQASIGFAMCONT" );
      cmbImpLiqFonNacEmpCont.setInternalname( "IMPLIQFONNACEMPCONT" );
      cmbImpLiqLeyRieTrabCont.setInternalname( "IMPLIQLEYRIETRABCONT" );
      cmbImpLiqRegDifApo.setInternalname( "IMPLIQREGDIFAPO" );
      cmbImpLiqRegEspApo.setInternalname( "IMPLIQREGESPAPO" );
      divApocontr_Internalname = "APOCONTR" ;
      Dvpanel_apocontr_Internalname = "DVPANEL_APOCONTR" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboimpliqconsiscod_Internalname = "vCOMBOIMPLIQCONSISCOD" ;
      divSectionattribute_impliqconsiscod_Internalname = "SECTIONATTRIBUTE_IMPLIQCONSISCOD" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtImpLiqSec_Internalname = "IMPLIQSEC" ;
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
      Form.setCaption( httpContext.getMessage( "importacion_conceptos", "") );
      edtImpLiqSec_Jsonclick = "" ;
      edtImpLiqSec_Enabled = 1 ;
      edtImpLiqSec_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavComboimpliqconsiscod_Jsonclick = "" ;
      edtavComboimpliqconsiscod_Enabled = 0 ;
      edtavComboimpliqconsiscod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbImpLiqRegEspApo.setJsonclick( "" );
      cmbImpLiqRegEspApo.setEnabled( 1 );
      cmbImpLiqRegDifApo.setJsonclick( "" );
      cmbImpLiqRegDifApo.setEnabled( 1 );
      cmbImpLiqLeyRieTrabCont.setJsonclick( "" );
      cmbImpLiqLeyRieTrabCont.setEnabled( 1 );
      cmbImpLiqFonNacEmpCont.setJsonclick( "" );
      cmbImpLiqFonNacEmpCont.setEnabled( 1 );
      cmbImpLiqAsigFamCont.setJsonclick( "" );
      cmbImpLiqAsigFamCont.setEnabled( 1 );
      cmbImpLiqRenateaCont.setJsonclick( "" );
      cmbImpLiqRenateaCont.setEnabled( 1 );
      cmbImpLiqRenateaApo.setJsonclick( "" );
      cmbImpLiqRenateaApo.setEnabled( 1 );
      cmbImpLiqFonSolRedCont.setJsonclick( "" );
      cmbImpLiqFonSolRedCont.setEnabled( 1 );
      cmbImpLiqFonSolRedApo.setJsonclick( "" );
      cmbImpLiqFonSolRedApo.setEnabled( 1 );
      cmbImpLiqObraSocCont.setJsonclick( "" );
      cmbImpLiqObraSocCont.setEnabled( 1 );
      cmbImpLiqObraSocApo.setJsonclick( "" );
      cmbImpLiqObraSocApo.setEnabled( 1 );
      cmbImpLiqINSSJyPCont.setJsonclick( "" );
      cmbImpLiqINSSJyPCont.setEnabled( 1 );
      cmbImpLiqINSSJyPApo.setJsonclick( "" );
      cmbImpLiqINSSJyPApo.setEnabled( 1 );
      cmbImpLiqSIPACont.setJsonclick( "" );
      cmbImpLiqSIPACont.setEnabled( 1 );
      cmbImpLiqSIPAApo.setJsonclick( "" );
      cmbImpLiqSIPAApo.setEnabled( 1 );
      Dvpanel_apocontr_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_apocontr_Iconposition = "Right" ;
      Dvpanel_apocontr_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_apocontr_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_apocontr_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_apocontr_Title = "" ;
      Dvpanel_apocontr_Cls = "Proximo a desarrollar" ;
      Dvpanel_apocontr_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_apocontr_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_apocontr_Width = "100%" ;
      edtImpLiqConSisCod_Jsonclick = "" ;
      edtImpLiqConSisCod_Enabled = 1 ;
      edtImpLiqConSisCod_Visible = 1 ;
      Combo_impliqconsiscod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_impliqconsiscod_Cls = "ExtendedCombo Attribute" ;
      Combo_impliqconsiscod_Caption = "" ;
      Combo_impliqconsiscod_Enabled = GXutil.toBoolean( -1) ;
      edtImpLiqConExtDescrip_Enabled = 0 ;
      edtImpLiqConExtCod_Jsonclick = "" ;
      edtImpLiqConExtCod_Enabled = 0 ;
      edtImpLiqConAfipCod_Jsonclick = "" ;
      edtImpLiqConAfipCod_Enabled = 0 ;
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

   public void gx20asaclicod2977( int AV20CliCod )
   {
      if ( ! (0==AV20CliCod) )
      {
         A3CliCod = AV20CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int9 = A3CliCod ;
            GXv_int10[0] = GXt_int9 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int10) ;
            importacion_conceptos_impl.this.GXt_int9 = GXv_int10[0] ;
            A3CliCod = GXt_int9 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void init_web_controls( )
   {
      cmbImpLiqSIPAApo.setName( "IMPLIQSIPAAPO" );
      cmbImpLiqSIPAApo.setWebtags( "" );
      cmbImpLiqSIPAApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqSIPAApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqSIPAApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqSIPAApo.getItemCount() > 0 )
      {
         A643ImpLiqSIPAApo = cmbImpLiqSIPAApo.getValidValue(A643ImpLiqSIPAApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A643ImpLiqSIPAApo", A643ImpLiqSIPAApo);
      }
      cmbImpLiqSIPACont.setName( "IMPLIQSIPACONT" );
      cmbImpLiqSIPACont.setWebtags( "" );
      cmbImpLiqSIPACont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqSIPACont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqSIPACont.addItem("", "-", (short)(0));
      if ( cmbImpLiqSIPACont.getItemCount() > 0 )
      {
         A644ImpLiqSIPACont = cmbImpLiqSIPACont.getValidValue(A644ImpLiqSIPACont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A644ImpLiqSIPACont", A644ImpLiqSIPACont);
      }
      cmbImpLiqINSSJyPApo.setName( "IMPLIQINSSJYPAPO" );
      cmbImpLiqINSSJyPApo.setWebtags( "" );
      cmbImpLiqINSSJyPApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqINSSJyPApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqINSSJyPApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqINSSJyPApo.getItemCount() > 0 )
      {
         A645ImpLiqINSSJyPApo = cmbImpLiqINSSJyPApo.getValidValue(A645ImpLiqINSSJyPApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A645ImpLiqINSSJyPApo", A645ImpLiqINSSJyPApo);
      }
      cmbImpLiqINSSJyPCont.setName( "IMPLIQINSSJYPCONT" );
      cmbImpLiqINSSJyPCont.setWebtags( "" );
      cmbImpLiqINSSJyPCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqINSSJyPCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqINSSJyPCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqINSSJyPCont.getItemCount() > 0 )
      {
         A646ImpLiqINSSJyPCont = cmbImpLiqINSSJyPCont.getValidValue(A646ImpLiqINSSJyPCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A646ImpLiqINSSJyPCont", A646ImpLiqINSSJyPCont);
      }
      cmbImpLiqObraSocApo.setName( "IMPLIQOBRASOCAPO" );
      cmbImpLiqObraSocApo.setWebtags( "" );
      cmbImpLiqObraSocApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqObraSocApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqObraSocApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqObraSocApo.getItemCount() > 0 )
      {
         A647ImpLiqObraSocApo = cmbImpLiqObraSocApo.getValidValue(A647ImpLiqObraSocApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A647ImpLiqObraSocApo", A647ImpLiqObraSocApo);
      }
      cmbImpLiqObraSocCont.setName( "IMPLIQOBRASOCCONT" );
      cmbImpLiqObraSocCont.setWebtags( "" );
      cmbImpLiqObraSocCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqObraSocCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqObraSocCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqObraSocCont.getItemCount() > 0 )
      {
         A648ImpLiqObraSocCont = cmbImpLiqObraSocCont.getValidValue(A648ImpLiqObraSocCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A648ImpLiqObraSocCont", A648ImpLiqObraSocCont);
      }
      cmbImpLiqFonSolRedApo.setName( "IMPLIQFONSOLREDAPO" );
      cmbImpLiqFonSolRedApo.setWebtags( "" );
      cmbImpLiqFonSolRedApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqFonSolRedApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqFonSolRedApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqFonSolRedApo.getItemCount() > 0 )
      {
         A649ImpLiqFonSolRedApo = cmbImpLiqFonSolRedApo.getValidValue(A649ImpLiqFonSolRedApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A649ImpLiqFonSolRedApo", A649ImpLiqFonSolRedApo);
      }
      cmbImpLiqFonSolRedCont.setName( "IMPLIQFONSOLREDCONT" );
      cmbImpLiqFonSolRedCont.setWebtags( "" );
      cmbImpLiqFonSolRedCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqFonSolRedCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqFonSolRedCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqFonSolRedCont.getItemCount() > 0 )
      {
         A650ImpLiqFonSolRedCont = cmbImpLiqFonSolRedCont.getValidValue(A650ImpLiqFonSolRedCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A650ImpLiqFonSolRedCont", A650ImpLiqFonSolRedCont);
      }
      cmbImpLiqRenateaApo.setName( "IMPLIQRENATEAAPO" );
      cmbImpLiqRenateaApo.setWebtags( "" );
      cmbImpLiqRenateaApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqRenateaApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqRenateaApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqRenateaApo.getItemCount() > 0 )
      {
         A651ImpLiqRenateaApo = cmbImpLiqRenateaApo.getValidValue(A651ImpLiqRenateaApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A651ImpLiqRenateaApo", A651ImpLiqRenateaApo);
      }
      cmbImpLiqRenateaCont.setName( "IMPLIQRENATEACONT" );
      cmbImpLiqRenateaCont.setWebtags( "" );
      cmbImpLiqRenateaCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqRenateaCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqRenateaCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqRenateaCont.getItemCount() > 0 )
      {
         A652ImpLiqRenateaCont = cmbImpLiqRenateaCont.getValidValue(A652ImpLiqRenateaCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A652ImpLiqRenateaCont", A652ImpLiqRenateaCont);
      }
      cmbImpLiqAsigFamCont.setName( "IMPLIQASIGFAMCONT" );
      cmbImpLiqAsigFamCont.setWebtags( "" );
      cmbImpLiqAsigFamCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqAsigFamCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqAsigFamCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqAsigFamCont.getItemCount() > 0 )
      {
         A653ImpLiqAsigFamCont = cmbImpLiqAsigFamCont.getValidValue(A653ImpLiqAsigFamCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A653ImpLiqAsigFamCont", A653ImpLiqAsigFamCont);
      }
      cmbImpLiqFonNacEmpCont.setName( "IMPLIQFONNACEMPCONT" );
      cmbImpLiqFonNacEmpCont.setWebtags( "" );
      cmbImpLiqFonNacEmpCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqFonNacEmpCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqFonNacEmpCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqFonNacEmpCont.getItemCount() > 0 )
      {
         A654ImpLiqFonNacEmpCont = cmbImpLiqFonNacEmpCont.getValidValue(A654ImpLiqFonNacEmpCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A654ImpLiqFonNacEmpCont", A654ImpLiqFonNacEmpCont);
      }
      cmbImpLiqLeyRieTrabCont.setName( "IMPLIQLEYRIETRABCONT" );
      cmbImpLiqLeyRieTrabCont.setWebtags( "" );
      cmbImpLiqLeyRieTrabCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqLeyRieTrabCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqLeyRieTrabCont.addItem("", "-", (short)(0));
      if ( cmbImpLiqLeyRieTrabCont.getItemCount() > 0 )
      {
         A655ImpLiqLeyRieTrabCont = cmbImpLiqLeyRieTrabCont.getValidValue(A655ImpLiqLeyRieTrabCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A655ImpLiqLeyRieTrabCont", A655ImpLiqLeyRieTrabCont);
      }
      cmbImpLiqRegDifApo.setName( "IMPLIQREGDIFAPO" );
      cmbImpLiqRegDifApo.setWebtags( "" );
      cmbImpLiqRegDifApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqRegDifApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqRegDifApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqRegDifApo.getItemCount() > 0 )
      {
         A656ImpLiqRegDifApo = cmbImpLiqRegDifApo.getValidValue(A656ImpLiqRegDifApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A656ImpLiqRegDifApo", A656ImpLiqRegDifApo);
      }
      cmbImpLiqRegEspApo.setName( "IMPLIQREGESPAPO" );
      cmbImpLiqRegEspApo.setWebtags( "" );
      cmbImpLiqRegEspApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbImpLiqRegEspApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbImpLiqRegEspApo.addItem("", "-", (short)(0));
      if ( cmbImpLiqRegEspApo.getItemCount() > 0 )
      {
         A657ImpLiqRegEspApo = cmbImpLiqRegEspApo.getValidValue(A657ImpLiqRegEspApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A657ImpLiqRegEspApo", A657ImpLiqRegEspApo);
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

   public void valid_Impliqsec( )
   {
      /* Using cursor T002914 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(12);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV20CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV22ImpLiqSec',fld:'vIMPLIQSEC',pic:'ZZZ9',hsh:true},{av:'AV23ImpLiqConExtCod',fld:'vIMPLIQCONEXTCOD',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV20CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV22ImpLiqSec',fld:'vIMPLIQSEC',pic:'ZZZ9',hsh:true},{av:'AV23ImpLiqConExtCod',fld:'vIMPLIQCONEXTCOD',pic:'',hsh:true},{av:'A642ImpLiqConAfipCod',fld:'IMPLIQCONAFIPCOD',pic:''},{av:'A659ImpLiqConError',fld:'IMPLIQCONERROR',pic:''},{av:'A660ImpLiqConWarning',fld:'IMPLIQCONWARNING',pic:''},{av:'A640ImpLiqConExtDescrip',fld:'IMPLIQCONEXTDESCRIP',pic:''},{av:'A2186ImpLiqConExtDesSinAc',fld:'IMPLIQCONEXTDESSINAC',pic:''},{av:'A912ImpLiqAfipCodMasDesc',fld:'IMPLIQAFIPCODMASDESC',pic:''},{av:'A702ImpLiqConSisCodYDescrip',fld:'IMPLIQCONSISCODYDESCRIP',pic:''},{av:'A911ImpLiqTipoConCod',fld:'IMPLIQTIPOCONCOD',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12292',iparms:[{av:'AV20CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV22ImpLiqSec',fld:'vIMPLIQSEC',pic:'ZZZ9',hsh:true},{av:'AV23ImpLiqConExtCod',fld:'vIMPLIQCONEXTCOD',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQCONEXTCOD","{handler:'valid_Impliqconextcod',iparms:[]");
      setEventMetadata("VALID_IMPLIQCONEXTCOD",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQCONEXTDESCRIP","{handler:'valid_Impliqconextdescrip',iparms:[]");
      setEventMetadata("VALID_IMPLIQCONEXTDESCRIP",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQCONSISCOD","{handler:'valid_Impliqconsiscod',iparms:[]");
      setEventMetadata("VALID_IMPLIQCONSISCOD",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQSIPAAPO","{handler:'valid_Impliqsipaapo',iparms:[]");
      setEventMetadata("VALID_IMPLIQSIPAAPO",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQSIPACONT","{handler:'valid_Impliqsipacont',iparms:[]");
      setEventMetadata("VALID_IMPLIQSIPACONT",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQINSSJYPAPO","{handler:'valid_Impliqinssjypapo',iparms:[]");
      setEventMetadata("VALID_IMPLIQINSSJYPAPO",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQINSSJYPCONT","{handler:'valid_Impliqinssjypcont',iparms:[]");
      setEventMetadata("VALID_IMPLIQINSSJYPCONT",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQOBRASOCAPO","{handler:'valid_Impliqobrasocapo',iparms:[]");
      setEventMetadata("VALID_IMPLIQOBRASOCAPO",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQOBRASOCCONT","{handler:'valid_Impliqobrasoccont',iparms:[]");
      setEventMetadata("VALID_IMPLIQOBRASOCCONT",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQFONSOLREDAPO","{handler:'valid_Impliqfonsolredapo',iparms:[]");
      setEventMetadata("VALID_IMPLIQFONSOLREDAPO",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQFONSOLREDCONT","{handler:'valid_Impliqfonsolredcont',iparms:[]");
      setEventMetadata("VALID_IMPLIQFONSOLREDCONT",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQRENATEAAPO","{handler:'valid_Impliqrenateaapo',iparms:[]");
      setEventMetadata("VALID_IMPLIQRENATEAAPO",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQRENATEACONT","{handler:'valid_Impliqrenateacont',iparms:[]");
      setEventMetadata("VALID_IMPLIQRENATEACONT",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQASIGFAMCONT","{handler:'valid_Impliqasigfamcont',iparms:[]");
      setEventMetadata("VALID_IMPLIQASIGFAMCONT",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQFONNACEMPCONT","{handler:'valid_Impliqfonnacempcont',iparms:[]");
      setEventMetadata("VALID_IMPLIQFONNACEMPCONT",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQLEYRIETRABCONT","{handler:'valid_Impliqleyrietrabcont',iparms:[]");
      setEventMetadata("VALID_IMPLIQLEYRIETRABCONT",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQREGDIFAPO","{handler:'valid_Impliqregdifapo',iparms:[]");
      setEventMetadata("VALID_IMPLIQREGDIFAPO",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQREGESPAPO","{handler:'valid_Impliqregespapo',iparms:[]");
      setEventMetadata("VALID_IMPLIQREGESPAPO",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOIMPLIQCONSISCOD","{handler:'validv_Comboimpliqconsiscod',iparms:[]");
      setEventMetadata("VALIDV_COMBOIMPLIQCONSISCOD",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQSEC","{handler:'valid_Impliqsec',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A88ImpLiqSec',fld:'IMPLIQSEC',pic:'ZZZ9'}]");
      setEventMetadata("VALID_IMPLIQSEC",",oparms:[]}");
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
      pr_default.close(12);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV23ImpLiqConExtCod = "" ;
      Z89ImpLiqConExtCod = "" ;
      Z701ImpLiqConExtCodYDescrip = "" ;
      Z641ImpLiqConSisCod = "" ;
      Z659ImpLiqConError = "" ;
      Z660ImpLiqConWarning = "" ;
      Z640ImpLiqConExtDescrip = "" ;
      Z2186ImpLiqConExtDesSinAc = "" ;
      Z642ImpLiqConAfipCod = "" ;
      Z912ImpLiqAfipCodMasDesc = "" ;
      Z643ImpLiqSIPAApo = "" ;
      Z644ImpLiqSIPACont = "" ;
      Z645ImpLiqINSSJyPApo = "" ;
      Z646ImpLiqINSSJyPCont = "" ;
      Z647ImpLiqObraSocApo = "" ;
      Z648ImpLiqObraSocCont = "" ;
      Z649ImpLiqFonSolRedApo = "" ;
      Z650ImpLiqFonSolRedCont = "" ;
      Z651ImpLiqRenateaApo = "" ;
      Z652ImpLiqRenateaCont = "" ;
      Z653ImpLiqAsigFamCont = "" ;
      Z654ImpLiqFonNacEmpCont = "" ;
      Z655ImpLiqLeyRieTrabCont = "" ;
      Z656ImpLiqRegDifApo = "" ;
      Z657ImpLiqRegEspApo = "" ;
      Z702ImpLiqConSisCodYDescrip = "" ;
      Z911ImpLiqTipoConCod = "" ;
      Combo_impliqconsiscod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV23ImpLiqConExtCod = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A643ImpLiqSIPAApo = "" ;
      A644ImpLiqSIPACont = "" ;
      A645ImpLiqINSSJyPApo = "" ;
      A646ImpLiqINSSJyPCont = "" ;
      A647ImpLiqObraSocApo = "" ;
      A648ImpLiqObraSocCont = "" ;
      A649ImpLiqFonSolRedApo = "" ;
      A650ImpLiqFonSolRedCont = "" ;
      A651ImpLiqRenateaApo = "" ;
      A652ImpLiqRenateaCont = "" ;
      A653ImpLiqAsigFamCont = "" ;
      A654ImpLiqFonNacEmpCont = "" ;
      A655ImpLiqLeyRieTrabCont = "" ;
      A656ImpLiqRegDifApo = "" ;
      A657ImpLiqRegEspApo = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      A642ImpLiqConAfipCod = "" ;
      A89ImpLiqConExtCod = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A640ImpLiqConExtDescrip = "" ;
      lblTextblockimpliqconsiscod_Jsonclick = "" ;
      ucCombo_impliqconsiscod = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16ImpLiqConSisCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A641ImpLiqConSisCod = "" ;
      ucDvpanel_apocontr = new com.genexus.webpanels.GXUserControl();
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV19ComboImpLiqConSisCod = "" ;
      A701ImpLiqConExtCodYDescrip = "" ;
      A659ImpLiqConError = "" ;
      A660ImpLiqConWarning = "" ;
      A2186ImpLiqConExtDesSinAc = "" ;
      A912ImpLiqAfipCodMasDesc = "" ;
      A702ImpLiqConSisCodYDescrip = "" ;
      A911ImpLiqTipoConCod = "" ;
      AV24Pgmname = "" ;
      Combo_impliqconsiscod_Objectcall = "" ;
      Combo_impliqconsiscod_Class = "" ;
      Combo_impliqconsiscod_Icontype = "" ;
      Combo_impliqconsiscod_Icon = "" ;
      Combo_impliqconsiscod_Tooltip = "" ;
      Combo_impliqconsiscod_Selectedvalue_set = "" ;
      Combo_impliqconsiscod_Selectedtext_set = "" ;
      Combo_impliqconsiscod_Selectedtext_get = "" ;
      Combo_impliqconsiscod_Gamoauthtoken = "" ;
      Combo_impliqconsiscod_Ddointernalname = "" ;
      Combo_impliqconsiscod_Titlecontrolalign = "" ;
      Combo_impliqconsiscod_Dropdownoptionstype = "" ;
      Combo_impliqconsiscod_Titlecontrolidtoreplace = "" ;
      Combo_impliqconsiscod_Datalisttype = "" ;
      Combo_impliqconsiscod_Datalistfixedvalues = "" ;
      Combo_impliqconsiscod_Datalistproc = "" ;
      Combo_impliqconsiscod_Datalistprocparametersprefix = "" ;
      Combo_impliqconsiscod_Remoteservicesparameters = "" ;
      Combo_impliqconsiscod_Htmltemplate = "" ;
      Combo_impliqconsiscod_Multiplevaluestype = "" ;
      Combo_impliqconsiscod_Loadingdata = "" ;
      Combo_impliqconsiscod_Noresultsfound = "" ;
      Combo_impliqconsiscod_Emptyitemtext = "" ;
      Combo_impliqconsiscod_Onlyselectedvalues = "" ;
      Combo_impliqconsiscod_Selectalltext = "" ;
      Combo_impliqconsiscod_Multiplevaluesseparator = "" ;
      Combo_impliqconsiscod_Addnewoptiontext = "" ;
      Dvpanel_apocontr_Objectcall = "" ;
      Dvpanel_apocontr_Class = "" ;
      Dvpanel_apocontr_Height = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode77 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      GXt_objcol_SdtDVB_SDTComboData_Item6 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV18ComboSelectedValue = "" ;
      GXv_char7 = new String[1] ;
      GXv_objcol_SdtDVB_SDTComboData_Item8 = new GXBaseCollection[1] ;
      T00295_A701ImpLiqConExtCodYDescrip = new String[] {""} ;
      T00295_A89ImpLiqConExtCod = new String[] {""} ;
      T00295_A641ImpLiqConSisCod = new String[] {""} ;
      T00295_A659ImpLiqConError = new String[] {""} ;
      T00295_A660ImpLiqConWarning = new String[] {""} ;
      T00295_A640ImpLiqConExtDescrip = new String[] {""} ;
      T00295_A2186ImpLiqConExtDesSinAc = new String[] {""} ;
      T00295_A642ImpLiqConAfipCod = new String[] {""} ;
      T00295_A912ImpLiqAfipCodMasDesc = new String[] {""} ;
      T00295_A643ImpLiqSIPAApo = new String[] {""} ;
      T00295_A644ImpLiqSIPACont = new String[] {""} ;
      T00295_A645ImpLiqINSSJyPApo = new String[] {""} ;
      T00295_A646ImpLiqINSSJyPCont = new String[] {""} ;
      T00295_A647ImpLiqObraSocApo = new String[] {""} ;
      T00295_A648ImpLiqObraSocCont = new String[] {""} ;
      T00295_A649ImpLiqFonSolRedApo = new String[] {""} ;
      T00295_A650ImpLiqFonSolRedCont = new String[] {""} ;
      T00295_A651ImpLiqRenateaApo = new String[] {""} ;
      T00295_A652ImpLiqRenateaCont = new String[] {""} ;
      T00295_A653ImpLiqAsigFamCont = new String[] {""} ;
      T00295_A654ImpLiqFonNacEmpCont = new String[] {""} ;
      T00295_A655ImpLiqLeyRieTrabCont = new String[] {""} ;
      T00295_A656ImpLiqRegDifApo = new String[] {""} ;
      T00295_A657ImpLiqRegEspApo = new String[] {""} ;
      T00295_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      T00295_A911ImpLiqTipoConCod = new String[] {""} ;
      T00295_A3CliCod = new int[1] ;
      T00295_A1EmpCod = new short[1] ;
      T00295_A88ImpLiqSec = new short[1] ;
      T00294_A3CliCod = new int[1] ;
      T00296_A3CliCod = new int[1] ;
      T00297_A3CliCod = new int[1] ;
      T00297_A1EmpCod = new short[1] ;
      T00297_A88ImpLiqSec = new short[1] ;
      T00297_A89ImpLiqConExtCod = new String[] {""} ;
      T00293_A701ImpLiqConExtCodYDescrip = new String[] {""} ;
      T00293_A89ImpLiqConExtCod = new String[] {""} ;
      T00293_A641ImpLiqConSisCod = new String[] {""} ;
      T00293_A659ImpLiqConError = new String[] {""} ;
      T00293_A660ImpLiqConWarning = new String[] {""} ;
      T00293_A640ImpLiqConExtDescrip = new String[] {""} ;
      T00293_A2186ImpLiqConExtDesSinAc = new String[] {""} ;
      T00293_A642ImpLiqConAfipCod = new String[] {""} ;
      T00293_A912ImpLiqAfipCodMasDesc = new String[] {""} ;
      T00293_A643ImpLiqSIPAApo = new String[] {""} ;
      T00293_A644ImpLiqSIPACont = new String[] {""} ;
      T00293_A645ImpLiqINSSJyPApo = new String[] {""} ;
      T00293_A646ImpLiqINSSJyPCont = new String[] {""} ;
      T00293_A647ImpLiqObraSocApo = new String[] {""} ;
      T00293_A648ImpLiqObraSocCont = new String[] {""} ;
      T00293_A649ImpLiqFonSolRedApo = new String[] {""} ;
      T00293_A650ImpLiqFonSolRedCont = new String[] {""} ;
      T00293_A651ImpLiqRenateaApo = new String[] {""} ;
      T00293_A652ImpLiqRenateaCont = new String[] {""} ;
      T00293_A653ImpLiqAsigFamCont = new String[] {""} ;
      T00293_A654ImpLiqFonNacEmpCont = new String[] {""} ;
      T00293_A655ImpLiqLeyRieTrabCont = new String[] {""} ;
      T00293_A656ImpLiqRegDifApo = new String[] {""} ;
      T00293_A657ImpLiqRegEspApo = new String[] {""} ;
      T00293_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      T00293_A911ImpLiqTipoConCod = new String[] {""} ;
      T00293_A3CliCod = new int[1] ;
      T00293_A1EmpCod = new short[1] ;
      T00293_A88ImpLiqSec = new short[1] ;
      T00298_A3CliCod = new int[1] ;
      T00298_A1EmpCod = new short[1] ;
      T00298_A88ImpLiqSec = new short[1] ;
      T00298_A89ImpLiqConExtCod = new String[] {""} ;
      T00299_A3CliCod = new int[1] ;
      T00299_A1EmpCod = new short[1] ;
      T00299_A88ImpLiqSec = new short[1] ;
      T00299_A89ImpLiqConExtCod = new String[] {""} ;
      T00292_A701ImpLiqConExtCodYDescrip = new String[] {""} ;
      T00292_A89ImpLiqConExtCod = new String[] {""} ;
      T00292_A641ImpLiqConSisCod = new String[] {""} ;
      T00292_A659ImpLiqConError = new String[] {""} ;
      T00292_A660ImpLiqConWarning = new String[] {""} ;
      T00292_A640ImpLiqConExtDescrip = new String[] {""} ;
      T00292_A2186ImpLiqConExtDesSinAc = new String[] {""} ;
      T00292_A642ImpLiqConAfipCod = new String[] {""} ;
      T00292_A912ImpLiqAfipCodMasDesc = new String[] {""} ;
      T00292_A643ImpLiqSIPAApo = new String[] {""} ;
      T00292_A644ImpLiqSIPACont = new String[] {""} ;
      T00292_A645ImpLiqINSSJyPApo = new String[] {""} ;
      T00292_A646ImpLiqINSSJyPCont = new String[] {""} ;
      T00292_A647ImpLiqObraSocApo = new String[] {""} ;
      T00292_A648ImpLiqObraSocCont = new String[] {""} ;
      T00292_A649ImpLiqFonSolRedApo = new String[] {""} ;
      T00292_A650ImpLiqFonSolRedCont = new String[] {""} ;
      T00292_A651ImpLiqRenateaApo = new String[] {""} ;
      T00292_A652ImpLiqRenateaCont = new String[] {""} ;
      T00292_A653ImpLiqAsigFamCont = new String[] {""} ;
      T00292_A654ImpLiqFonNacEmpCont = new String[] {""} ;
      T00292_A655ImpLiqLeyRieTrabCont = new String[] {""} ;
      T00292_A656ImpLiqRegDifApo = new String[] {""} ;
      T00292_A657ImpLiqRegEspApo = new String[] {""} ;
      T00292_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      T00292_A911ImpLiqTipoConCod = new String[] {""} ;
      T00292_A3CliCod = new int[1] ;
      T00292_A1EmpCod = new short[1] ;
      T00292_A88ImpLiqSec = new short[1] ;
      T002913_A3CliCod = new int[1] ;
      T002913_A1EmpCod = new short[1] ;
      T002913_A88ImpLiqSec = new short[1] ;
      T002913_A89ImpLiqConExtCod = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int10 = new int[1] ;
      T002914_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_conceptos__default(),
         new Object[] {
             new Object[] {
            T00292_A701ImpLiqConExtCodYDescrip, T00292_A89ImpLiqConExtCod, T00292_A641ImpLiqConSisCod, T00292_A659ImpLiqConError, T00292_A660ImpLiqConWarning, T00292_A640ImpLiqConExtDescrip, T00292_A2186ImpLiqConExtDesSinAc, T00292_A642ImpLiqConAfipCod, T00292_A912ImpLiqAfipCodMasDesc, T00292_A643ImpLiqSIPAApo,
            T00292_A644ImpLiqSIPACont, T00292_A645ImpLiqINSSJyPApo, T00292_A646ImpLiqINSSJyPCont, T00292_A647ImpLiqObraSocApo, T00292_A648ImpLiqObraSocCont, T00292_A649ImpLiqFonSolRedApo, T00292_A650ImpLiqFonSolRedCont, T00292_A651ImpLiqRenateaApo, T00292_A652ImpLiqRenateaCont, T00292_A653ImpLiqAsigFamCont,
            T00292_A654ImpLiqFonNacEmpCont, T00292_A655ImpLiqLeyRieTrabCont, T00292_A656ImpLiqRegDifApo, T00292_A657ImpLiqRegEspApo, T00292_A702ImpLiqConSisCodYDescrip, T00292_A911ImpLiqTipoConCod, T00292_A3CliCod, T00292_A1EmpCod, T00292_A88ImpLiqSec
            }
            , new Object[] {
            T00293_A701ImpLiqConExtCodYDescrip, T00293_A89ImpLiqConExtCod, T00293_A641ImpLiqConSisCod, T00293_A659ImpLiqConError, T00293_A660ImpLiqConWarning, T00293_A640ImpLiqConExtDescrip, T00293_A2186ImpLiqConExtDesSinAc, T00293_A642ImpLiqConAfipCod, T00293_A912ImpLiqAfipCodMasDesc, T00293_A643ImpLiqSIPAApo,
            T00293_A644ImpLiqSIPACont, T00293_A645ImpLiqINSSJyPApo, T00293_A646ImpLiqINSSJyPCont, T00293_A647ImpLiqObraSocApo, T00293_A648ImpLiqObraSocCont, T00293_A649ImpLiqFonSolRedApo, T00293_A650ImpLiqFonSolRedCont, T00293_A651ImpLiqRenateaApo, T00293_A652ImpLiqRenateaCont, T00293_A653ImpLiqAsigFamCont,
            T00293_A654ImpLiqFonNacEmpCont, T00293_A655ImpLiqLeyRieTrabCont, T00293_A656ImpLiqRegDifApo, T00293_A657ImpLiqRegEspApo, T00293_A702ImpLiqConSisCodYDescrip, T00293_A911ImpLiqTipoConCod, T00293_A3CliCod, T00293_A1EmpCod, T00293_A88ImpLiqSec
            }
            , new Object[] {
            T00294_A3CliCod
            }
            , new Object[] {
            T00295_A701ImpLiqConExtCodYDescrip, T00295_A89ImpLiqConExtCod, T00295_A641ImpLiqConSisCod, T00295_A659ImpLiqConError, T00295_A660ImpLiqConWarning, T00295_A640ImpLiqConExtDescrip, T00295_A2186ImpLiqConExtDesSinAc, T00295_A642ImpLiqConAfipCod, T00295_A912ImpLiqAfipCodMasDesc, T00295_A643ImpLiqSIPAApo,
            T00295_A644ImpLiqSIPACont, T00295_A645ImpLiqINSSJyPApo, T00295_A646ImpLiqINSSJyPCont, T00295_A647ImpLiqObraSocApo, T00295_A648ImpLiqObraSocCont, T00295_A649ImpLiqFonSolRedApo, T00295_A650ImpLiqFonSolRedCont, T00295_A651ImpLiqRenateaApo, T00295_A652ImpLiqRenateaCont, T00295_A653ImpLiqAsigFamCont,
            T00295_A654ImpLiqFonNacEmpCont, T00295_A655ImpLiqLeyRieTrabCont, T00295_A656ImpLiqRegDifApo, T00295_A657ImpLiqRegEspApo, T00295_A702ImpLiqConSisCodYDescrip, T00295_A911ImpLiqTipoConCod, T00295_A3CliCod, T00295_A1EmpCod, T00295_A88ImpLiqSec
            }
            , new Object[] {
            T00296_A3CliCod
            }
            , new Object[] {
            T00297_A3CliCod, T00297_A1EmpCod, T00297_A88ImpLiqSec, T00297_A89ImpLiqConExtCod
            }
            , new Object[] {
            T00298_A3CliCod, T00298_A1EmpCod, T00298_A88ImpLiqSec, T00298_A89ImpLiqConExtCod
            }
            , new Object[] {
            T00299_A3CliCod, T00299_A1EmpCod, T00299_A88ImpLiqSec, T00299_A89ImpLiqConExtCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002913_A3CliCod, T002913_A1EmpCod, T002913_A88ImpLiqSec, T002913_A89ImpLiqConExtCod
            }
            , new Object[] {
            T002914_A3CliCod
            }
         }
      );
      AV24Pgmname = "importacion_conceptos" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV21EmpCod ;
   private short wcpOAV22ImpLiqSec ;
   private short Z1EmpCod ;
   private short Z88ImpLiqSec ;
   private short A1EmpCod ;
   private short A88ImpLiqSec ;
   private short AV21EmpCod ;
   private short AV22ImpLiqSec ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound77 ;
   private short nIsDirty_77 ;
   private int wcpOAV20CliCod ;
   private int Z3CliCod ;
   private int AV20CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtImpLiqConAfipCod_Enabled ;
   private int edtImpLiqConExtCod_Enabled ;
   private int edtImpLiqConExtDescrip_Enabled ;
   private int edtImpLiqConSisCod_Visible ;
   private int edtImpLiqConSisCod_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboimpliqconsiscod_Visible ;
   private int edtavComboimpliqconsiscod_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtImpLiqSec_Visible ;
   private int edtImpLiqSec_Enabled ;
   private int Combo_impliqconsiscod_Datalistupdateminimumcharacters ;
   private int Dvpanel_apocontr_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int GXt_int9 ;
   private int GXv_int10[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV23ImpLiqConExtCod ;
   private String Z89ImpLiqConExtCod ;
   private String Z641ImpLiqConSisCod ;
   private String Z642ImpLiqConAfipCod ;
   private String Z643ImpLiqSIPAApo ;
   private String Z644ImpLiqSIPACont ;
   private String Z645ImpLiqINSSJyPApo ;
   private String Z646ImpLiqINSSJyPCont ;
   private String Z647ImpLiqObraSocApo ;
   private String Z648ImpLiqObraSocCont ;
   private String Z649ImpLiqFonSolRedApo ;
   private String Z650ImpLiqFonSolRedCont ;
   private String Z651ImpLiqRenateaApo ;
   private String Z652ImpLiqRenateaCont ;
   private String Z653ImpLiqAsigFamCont ;
   private String Z654ImpLiqFonNacEmpCont ;
   private String Z655ImpLiqLeyRieTrabCont ;
   private String Z656ImpLiqRegDifApo ;
   private String Z657ImpLiqRegEspApo ;
   private String Z911ImpLiqTipoConCod ;
   private String Combo_impliqconsiscod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV23ImpLiqConExtCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtImpLiqConSisCod_Internalname ;
   private String A643ImpLiqSIPAApo ;
   private String A644ImpLiqSIPACont ;
   private String A645ImpLiqINSSJyPApo ;
   private String A646ImpLiqINSSJyPCont ;
   private String A647ImpLiqObraSocApo ;
   private String A648ImpLiqObraSocCont ;
   private String A649ImpLiqFonSolRedApo ;
   private String A650ImpLiqFonSolRedCont ;
   private String A651ImpLiqRenateaApo ;
   private String A652ImpLiqRenateaCont ;
   private String A653ImpLiqAsigFamCont ;
   private String A654ImpLiqFonNacEmpCont ;
   private String A655ImpLiqLeyRieTrabCont ;
   private String A656ImpLiqRegDifApo ;
   private String A657ImpLiqRegEspApo ;
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
   private String edtImpLiqConAfipCod_Internalname ;
   private String A642ImpLiqConAfipCod ;
   private String edtImpLiqConAfipCod_Jsonclick ;
   private String edtImpLiqConExtCod_Internalname ;
   private String A89ImpLiqConExtCod ;
   private String edtImpLiqConExtCod_Jsonclick ;
   private String edtImpLiqConExtDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablesplittedimpliqconsiscod_Internalname ;
   private String lblTextblockimpliqconsiscod_Internalname ;
   private String lblTextblockimpliqconsiscod_Jsonclick ;
   private String Combo_impliqconsiscod_Caption ;
   private String Combo_impliqconsiscod_Cls ;
   private String Combo_impliqconsiscod_Internalname ;
   private String TempTags ;
   private String A641ImpLiqConSisCod ;
   private String edtImpLiqConSisCod_Jsonclick ;
   private String Dvpanel_apocontr_Width ;
   private String Dvpanel_apocontr_Cls ;
   private String Dvpanel_apocontr_Title ;
   private String Dvpanel_apocontr_Iconposition ;
   private String Dvpanel_apocontr_Internalname ;
   private String divApocontr_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_impliqconsiscod_Internalname ;
   private String edtavComboimpliqconsiscod_Internalname ;
   private String AV19ComboImpLiqConSisCod ;
   private String edtavComboimpliqconsiscod_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtImpLiqSec_Internalname ;
   private String edtImpLiqSec_Jsonclick ;
   private String A911ImpLiqTipoConCod ;
   private String AV24Pgmname ;
   private String Combo_impliqconsiscod_Objectcall ;
   private String Combo_impliqconsiscod_Class ;
   private String Combo_impliqconsiscod_Icontype ;
   private String Combo_impliqconsiscod_Icon ;
   private String Combo_impliqconsiscod_Tooltip ;
   private String Combo_impliqconsiscod_Selectedvalue_set ;
   private String Combo_impliqconsiscod_Selectedtext_set ;
   private String Combo_impliqconsiscod_Selectedtext_get ;
   private String Combo_impliqconsiscod_Gamoauthtoken ;
   private String Combo_impliqconsiscod_Ddointernalname ;
   private String Combo_impliqconsiscod_Titlecontrolalign ;
   private String Combo_impliqconsiscod_Dropdownoptionstype ;
   private String Combo_impliqconsiscod_Titlecontrolidtoreplace ;
   private String Combo_impliqconsiscod_Datalisttype ;
   private String Combo_impliqconsiscod_Datalistfixedvalues ;
   private String Combo_impliqconsiscod_Datalistproc ;
   private String Combo_impliqconsiscod_Datalistprocparametersprefix ;
   private String Combo_impliqconsiscod_Remoteservicesparameters ;
   private String Combo_impliqconsiscod_Htmltemplate ;
   private String Combo_impliqconsiscod_Multiplevaluestype ;
   private String Combo_impliqconsiscod_Loadingdata ;
   private String Combo_impliqconsiscod_Noresultsfound ;
   private String Combo_impliqconsiscod_Emptyitemtext ;
   private String Combo_impliqconsiscod_Onlyselectedvalues ;
   private String Combo_impliqconsiscod_Selectalltext ;
   private String Combo_impliqconsiscod_Multiplevaluesseparator ;
   private String Combo_impliqconsiscod_Addnewoptiontext ;
   private String Dvpanel_apocontr_Objectcall ;
   private String Dvpanel_apocontr_Class ;
   private String Dvpanel_apocontr_Height ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode77 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXv_char7[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_impliqconsiscod_Emptyitem ;
   private boolean Dvpanel_apocontr_Autowidth ;
   private boolean Dvpanel_apocontr_Autoheight ;
   private boolean Dvpanel_apocontr_Collapsible ;
   private boolean Dvpanel_apocontr_Collapsed ;
   private boolean Dvpanel_apocontr_Showcollapseicon ;
   private boolean Dvpanel_apocontr_Autoscroll ;
   private boolean Combo_impliqconsiscod_Enabled ;
   private boolean Combo_impliqconsiscod_Visible ;
   private boolean Combo_impliqconsiscod_Allowmultipleselection ;
   private boolean Combo_impliqconsiscod_Isgriditem ;
   private boolean Combo_impliqconsiscod_Hasdescription ;
   private boolean Combo_impliqconsiscod_Includeonlyselectedoption ;
   private boolean Combo_impliqconsiscod_Includeselectalloption ;
   private boolean Combo_impliqconsiscod_Includeaddnewoption ;
   private boolean Dvpanel_apocontr_Enabled ;
   private boolean Dvpanel_apocontr_Showheader ;
   private boolean Dvpanel_apocontr_Visible ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String Z701ImpLiqConExtCodYDescrip ;
   private String Z659ImpLiqConError ;
   private String Z660ImpLiqConWarning ;
   private String Z640ImpLiqConExtDescrip ;
   private String Z2186ImpLiqConExtDesSinAc ;
   private String Z912ImpLiqAfipCodMasDesc ;
   private String Z702ImpLiqConSisCodYDescrip ;
   private String A640ImpLiqConExtDescrip ;
   private String A701ImpLiqConExtCodYDescrip ;
   private String A659ImpLiqConError ;
   private String A660ImpLiqConWarning ;
   private String A2186ImpLiqConExtDesSinAc ;
   private String A912ImpLiqAfipCodMasDesc ;
   private String A702ImpLiqConSisCodYDescrip ;
   private String AV18ComboSelectedValue ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_impliqconsiscod ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_apocontr ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbImpLiqSIPAApo ;
   private HTMLChoice cmbImpLiqSIPACont ;
   private HTMLChoice cmbImpLiqINSSJyPApo ;
   private HTMLChoice cmbImpLiqINSSJyPCont ;
   private HTMLChoice cmbImpLiqObraSocApo ;
   private HTMLChoice cmbImpLiqObraSocCont ;
   private HTMLChoice cmbImpLiqFonSolRedApo ;
   private HTMLChoice cmbImpLiqFonSolRedCont ;
   private HTMLChoice cmbImpLiqRenateaApo ;
   private HTMLChoice cmbImpLiqRenateaCont ;
   private HTMLChoice cmbImpLiqAsigFamCont ;
   private HTMLChoice cmbImpLiqFonNacEmpCont ;
   private HTMLChoice cmbImpLiqLeyRieTrabCont ;
   private HTMLChoice cmbImpLiqRegDifApo ;
   private HTMLChoice cmbImpLiqRegEspApo ;
   private IDataStoreProvider pr_default ;
   private String[] T00295_A701ImpLiqConExtCodYDescrip ;
   private String[] T00295_A89ImpLiqConExtCod ;
   private String[] T00295_A641ImpLiqConSisCod ;
   private String[] T00295_A659ImpLiqConError ;
   private String[] T00295_A660ImpLiqConWarning ;
   private String[] T00295_A640ImpLiqConExtDescrip ;
   private String[] T00295_A2186ImpLiqConExtDesSinAc ;
   private String[] T00295_A642ImpLiqConAfipCod ;
   private String[] T00295_A912ImpLiqAfipCodMasDesc ;
   private String[] T00295_A643ImpLiqSIPAApo ;
   private String[] T00295_A644ImpLiqSIPACont ;
   private String[] T00295_A645ImpLiqINSSJyPApo ;
   private String[] T00295_A646ImpLiqINSSJyPCont ;
   private String[] T00295_A647ImpLiqObraSocApo ;
   private String[] T00295_A648ImpLiqObraSocCont ;
   private String[] T00295_A649ImpLiqFonSolRedApo ;
   private String[] T00295_A650ImpLiqFonSolRedCont ;
   private String[] T00295_A651ImpLiqRenateaApo ;
   private String[] T00295_A652ImpLiqRenateaCont ;
   private String[] T00295_A653ImpLiqAsigFamCont ;
   private String[] T00295_A654ImpLiqFonNacEmpCont ;
   private String[] T00295_A655ImpLiqLeyRieTrabCont ;
   private String[] T00295_A656ImpLiqRegDifApo ;
   private String[] T00295_A657ImpLiqRegEspApo ;
   private String[] T00295_A702ImpLiqConSisCodYDescrip ;
   private String[] T00295_A911ImpLiqTipoConCod ;
   private int[] T00295_A3CliCod ;
   private short[] T00295_A1EmpCod ;
   private short[] T00295_A88ImpLiqSec ;
   private int[] T00294_A3CliCod ;
   private int[] T00296_A3CliCod ;
   private int[] T00297_A3CliCod ;
   private short[] T00297_A1EmpCod ;
   private short[] T00297_A88ImpLiqSec ;
   private String[] T00297_A89ImpLiqConExtCod ;
   private String[] T00293_A701ImpLiqConExtCodYDescrip ;
   private String[] T00293_A89ImpLiqConExtCod ;
   private String[] T00293_A641ImpLiqConSisCod ;
   private String[] T00293_A659ImpLiqConError ;
   private String[] T00293_A660ImpLiqConWarning ;
   private String[] T00293_A640ImpLiqConExtDescrip ;
   private String[] T00293_A2186ImpLiqConExtDesSinAc ;
   private String[] T00293_A642ImpLiqConAfipCod ;
   private String[] T00293_A912ImpLiqAfipCodMasDesc ;
   private String[] T00293_A643ImpLiqSIPAApo ;
   private String[] T00293_A644ImpLiqSIPACont ;
   private String[] T00293_A645ImpLiqINSSJyPApo ;
   private String[] T00293_A646ImpLiqINSSJyPCont ;
   private String[] T00293_A647ImpLiqObraSocApo ;
   private String[] T00293_A648ImpLiqObraSocCont ;
   private String[] T00293_A649ImpLiqFonSolRedApo ;
   private String[] T00293_A650ImpLiqFonSolRedCont ;
   private String[] T00293_A651ImpLiqRenateaApo ;
   private String[] T00293_A652ImpLiqRenateaCont ;
   private String[] T00293_A653ImpLiqAsigFamCont ;
   private String[] T00293_A654ImpLiqFonNacEmpCont ;
   private String[] T00293_A655ImpLiqLeyRieTrabCont ;
   private String[] T00293_A656ImpLiqRegDifApo ;
   private String[] T00293_A657ImpLiqRegEspApo ;
   private String[] T00293_A702ImpLiqConSisCodYDescrip ;
   private String[] T00293_A911ImpLiqTipoConCod ;
   private int[] T00293_A3CliCod ;
   private short[] T00293_A1EmpCod ;
   private short[] T00293_A88ImpLiqSec ;
   private int[] T00298_A3CliCod ;
   private short[] T00298_A1EmpCod ;
   private short[] T00298_A88ImpLiqSec ;
   private String[] T00298_A89ImpLiqConExtCod ;
   private int[] T00299_A3CliCod ;
   private short[] T00299_A1EmpCod ;
   private short[] T00299_A88ImpLiqSec ;
   private String[] T00299_A89ImpLiqConExtCod ;
   private String[] T00292_A701ImpLiqConExtCodYDescrip ;
   private String[] T00292_A89ImpLiqConExtCod ;
   private String[] T00292_A641ImpLiqConSisCod ;
   private String[] T00292_A659ImpLiqConError ;
   private String[] T00292_A660ImpLiqConWarning ;
   private String[] T00292_A640ImpLiqConExtDescrip ;
   private String[] T00292_A2186ImpLiqConExtDesSinAc ;
   private String[] T00292_A642ImpLiqConAfipCod ;
   private String[] T00292_A912ImpLiqAfipCodMasDesc ;
   private String[] T00292_A643ImpLiqSIPAApo ;
   private String[] T00292_A644ImpLiqSIPACont ;
   private String[] T00292_A645ImpLiqINSSJyPApo ;
   private String[] T00292_A646ImpLiqINSSJyPCont ;
   private String[] T00292_A647ImpLiqObraSocApo ;
   private String[] T00292_A648ImpLiqObraSocCont ;
   private String[] T00292_A649ImpLiqFonSolRedApo ;
   private String[] T00292_A650ImpLiqFonSolRedCont ;
   private String[] T00292_A651ImpLiqRenateaApo ;
   private String[] T00292_A652ImpLiqRenateaCont ;
   private String[] T00292_A653ImpLiqAsigFamCont ;
   private String[] T00292_A654ImpLiqFonNacEmpCont ;
   private String[] T00292_A655ImpLiqLeyRieTrabCont ;
   private String[] T00292_A656ImpLiqRegDifApo ;
   private String[] T00292_A657ImpLiqRegEspApo ;
   private String[] T00292_A702ImpLiqConSisCodYDescrip ;
   private String[] T00292_A911ImpLiqTipoConCod ;
   private int[] T00292_A3CliCod ;
   private short[] T00292_A1EmpCod ;
   private short[] T00292_A88ImpLiqSec ;
   private int[] T002913_A3CliCod ;
   private short[] T002913_A1EmpCod ;
   private short[] T002913_A88ImpLiqSec ;
   private String[] T002913_A89ImpLiqConExtCod ;
   private int[] T002914_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV16ImpLiqConSisCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXt_objcol_SdtDVB_SDTComboData_Item6 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXv_objcol_SdtDVB_SDTComboData_Item8[] ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class importacion_conceptos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00292", "SELECT ImpLiqConExtCodYDescrip, ImpLiqConExtCod, ImpLiqConSisCod, ImpLiqConError, ImpLiqConWarning, ImpLiqConExtDescrip, ImpLiqConExtDesSinAc, ImpLiqConAfipCod, ImpLiqAfipCodMasDesc, ImpLiqSIPAApo, ImpLiqSIPACont, ImpLiqINSSJyPApo, ImpLiqINSSJyPCont, ImpLiqObraSocApo, ImpLiqObraSocCont, ImpLiqFonSolRedApo, ImpLiqFonSolRedCont, ImpLiqRenateaApo, ImpLiqRenateaCont, ImpLiqAsigFamCont, ImpLiqFonNacEmpCont, ImpLiqLeyRieTrabCont, ImpLiqRegDifApo, ImpLiqRegEspApo, ImpLiqConSisCodYDescrip, ImpLiqTipoConCod, CliCod, EmpCod, ImpLiqSec FROM importacion_conceptos WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ?  FOR UPDATE OF importacion_conceptos NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00293", "SELECT ImpLiqConExtCodYDescrip, ImpLiqConExtCod, ImpLiqConSisCod, ImpLiqConError, ImpLiqConWarning, ImpLiqConExtDescrip, ImpLiqConExtDesSinAc, ImpLiqConAfipCod, ImpLiqAfipCodMasDesc, ImpLiqSIPAApo, ImpLiqSIPACont, ImpLiqINSSJyPApo, ImpLiqINSSJyPCont, ImpLiqObraSocApo, ImpLiqObraSocCont, ImpLiqFonSolRedApo, ImpLiqFonSolRedCont, ImpLiqRenateaApo, ImpLiqRenateaCont, ImpLiqAsigFamCont, ImpLiqFonNacEmpCont, ImpLiqLeyRieTrabCont, ImpLiqRegDifApo, ImpLiqRegEspApo, ImpLiqConSisCodYDescrip, ImpLiqTipoConCod, CliCod, EmpCod, ImpLiqSec FROM importacion_conceptos WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00294", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00295", "SELECT TM1.ImpLiqConExtCodYDescrip, TM1.ImpLiqConExtCod, TM1.ImpLiqConSisCod, TM1.ImpLiqConError, TM1.ImpLiqConWarning, TM1.ImpLiqConExtDescrip, TM1.ImpLiqConExtDesSinAc, TM1.ImpLiqConAfipCod, TM1.ImpLiqAfipCodMasDesc, TM1.ImpLiqSIPAApo, TM1.ImpLiqSIPACont, TM1.ImpLiqINSSJyPApo, TM1.ImpLiqINSSJyPCont, TM1.ImpLiqObraSocApo, TM1.ImpLiqObraSocCont, TM1.ImpLiqFonSolRedApo, TM1.ImpLiqFonSolRedCont, TM1.ImpLiqRenateaApo, TM1.ImpLiqRenateaCont, TM1.ImpLiqAsigFamCont, TM1.ImpLiqFonNacEmpCont, TM1.ImpLiqLeyRieTrabCont, TM1.ImpLiqRegDifApo, TM1.ImpLiqRegEspApo, TM1.ImpLiqConSisCodYDescrip, TM1.ImpLiqTipoConCod, TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec FROM importacion_conceptos TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.ImpLiqSec = ? and TM1.ImpLiqConExtCod = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec, TM1.ImpLiqConExtCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00296", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00297", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod FROM importacion_conceptos WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00298", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod FROM importacion_conceptos WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and ImpLiqSec > ? or ImpLiqSec = ? and EmpCod = ? and CliCod = ? and ImpLiqConExtCod > ( ?)) ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00299", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod FROM importacion_conceptos WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and ImpLiqSec < ? or ImpLiqSec = ? and EmpCod = ? and CliCod = ? and ImpLiqConExtCod < ( ?)) ORDER BY CliCod DESC, EmpCod DESC, ImpLiqSec DESC, ImpLiqConExtCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002910", "SAVEPOINT gxupdate;INSERT INTO importacion_conceptos(ImpLiqConExtCodYDescrip, ImpLiqConExtCod, ImpLiqConSisCod, ImpLiqConError, ImpLiqConWarning, ImpLiqConExtDescrip, ImpLiqConExtDesSinAc, ImpLiqConAfipCod, ImpLiqAfipCodMasDesc, ImpLiqSIPAApo, ImpLiqSIPACont, ImpLiqINSSJyPApo, ImpLiqINSSJyPCont, ImpLiqObraSocApo, ImpLiqObraSocCont, ImpLiqFonSolRedApo, ImpLiqFonSolRedCont, ImpLiqRenateaApo, ImpLiqRenateaCont, ImpLiqAsigFamCont, ImpLiqFonNacEmpCont, ImpLiqLeyRieTrabCont, ImpLiqRegDifApo, ImpLiqRegEspApo, ImpLiqConSisCodYDescrip, ImpLiqTipoConCod, CliCod, EmpCod, ImpLiqSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002911", "SAVEPOINT gxupdate;UPDATE importacion_conceptos SET ImpLiqConExtCodYDescrip=?, ImpLiqConSisCod=?, ImpLiqConError=?, ImpLiqConWarning=?, ImpLiqConExtDescrip=?, ImpLiqConExtDesSinAc=?, ImpLiqConAfipCod=?, ImpLiqAfipCodMasDesc=?, ImpLiqSIPAApo=?, ImpLiqSIPACont=?, ImpLiqINSSJyPApo=?, ImpLiqINSSJyPCont=?, ImpLiqObraSocApo=?, ImpLiqObraSocCont=?, ImpLiqFonSolRedApo=?, ImpLiqFonSolRedCont=?, ImpLiqRenateaApo=?, ImpLiqRenateaCont=?, ImpLiqAsigFamCont=?, ImpLiqFonNacEmpCont=?, ImpLiqLeyRieTrabCont=?, ImpLiqRegDifApo=?, ImpLiqRegEspApo=?, ImpLiqConSisCodYDescrip=?, ImpLiqTipoConCod=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002912", "SAVEPOINT gxupdate;DELETE FROM importacion_conceptos  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002913", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod FROM importacion_conceptos ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002914", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 1);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getString(17, 1);
               ((String[]) buf[17])[0] = rslt.getString(18, 1);
               ((String[]) buf[18])[0] = rslt.getString(19, 1);
               ((String[]) buf[19])[0] = rslt.getString(20, 1);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((String[]) buf[21])[0] = rslt.getString(22, 1);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 1);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 20);
               ((int[]) buf[26])[0] = rslt.getInt(27);
               ((short[]) buf[27])[0] = rslt.getShort(28);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 1);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getString(17, 1);
               ((String[]) buf[17])[0] = rslt.getString(18, 1);
               ((String[]) buf[18])[0] = rslt.getString(19, 1);
               ((String[]) buf[19])[0] = rslt.getString(20, 1);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((String[]) buf[21])[0] = rslt.getString(22, 1);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 1);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 20);
               ((int[]) buf[26])[0] = rslt.getInt(27);
               ((short[]) buf[27])[0] = rslt.getShort(28);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 1);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getString(17, 1);
               ((String[]) buf[17])[0] = rslt.getString(18, 1);
               ((String[]) buf[18])[0] = rslt.getString(19, 1);
               ((String[]) buf[19])[0] = rslt.getString(20, 1);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((String[]) buf[21])[0] = rslt.getString(22, 1);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 1);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 20);
               ((int[]) buf[26])[0] = rslt.getInt(27);
               ((short[]) buf[27])[0] = rslt.getShort(28);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 20);
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setVarchar(7, (String)parms[6], 400, false);
               stmt.setString(8, (String)parms[7], 20);
               stmt.setVarchar(9, (String)parms[8], 200, false);
               stmt.setString(10, (String)parms[9], 1);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setString(12, (String)parms[11], 1);
               stmt.setString(13, (String)parms[12], 1);
               stmt.setString(14, (String)parms[13], 1);
               stmt.setString(15, (String)parms[14], 1);
               stmt.setString(16, (String)parms[15], 1);
               stmt.setString(17, (String)parms[16], 1);
               stmt.setString(18, (String)parms[17], 1);
               stmt.setString(19, (String)parms[18], 1);
               stmt.setString(20, (String)parms[19], 1);
               stmt.setString(21, (String)parms[20], 1);
               stmt.setString(22, (String)parms[21], 1);
               stmt.setString(23, (String)parms[22], 1);
               stmt.setString(24, (String)parms[23], 1);
               stmt.setVarchar(25, (String)parms[24], 400, false);
               stmt.setString(26, (String)parms[25], 20);
               stmt.setInt(27, ((Number) parms[26]).intValue());
               stmt.setShort(28, ((Number) parms[27]).shortValue());
               stmt.setShort(29, ((Number) parms[28]).shortValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setVarchar(8, (String)parms[7], 200, false);
               stmt.setString(9, (String)parms[8], 1);
               stmt.setString(10, (String)parms[9], 1);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setString(12, (String)parms[11], 1);
               stmt.setString(13, (String)parms[12], 1);
               stmt.setString(14, (String)parms[13], 1);
               stmt.setString(15, (String)parms[14], 1);
               stmt.setString(16, (String)parms[15], 1);
               stmt.setString(17, (String)parms[16], 1);
               stmt.setString(18, (String)parms[17], 1);
               stmt.setString(19, (String)parms[18], 1);
               stmt.setString(20, (String)parms[19], 1);
               stmt.setString(21, (String)parms[20], 1);
               stmt.setString(22, (String)parms[21], 1);
               stmt.setString(23, (String)parms[22], 1);
               stmt.setVarchar(24, (String)parms[23], 400, false);
               stmt.setString(25, (String)parms[24], 20);
               stmt.setInt(26, ((Number) parms[25]).intValue());
               stmt.setShort(27, ((Number) parms[26]).shortValue());
               stmt.setShort(28, ((Number) parms[27]).shortValue());
               stmt.setString(29, (String)parms[28], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

