package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptoafip_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel17"+"_"+"CONAFIPSUBT2DEF") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A73ConCodPropio = httpContext.GetPar( "ConCodPropio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx17asaconafipsubt2def0B9( A3CliCod, A73ConCodPropio) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel18"+"_"+"CONAFIPSUBT1DEF") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A73ConCodPropio = httpContext.GetPar( "ConCodPropio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx18asaconafipsubt1def0B9( A3CliCod, A73ConCodPropio) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel19"+"_"+"CONAFIPTIPODEF") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A73ConCodPropio = httpContext.GetPar( "ConCodPropio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx19asaconafiptipodef0B9( A3CliCod, A73ConCodPropio) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel20"+"_"+"CONAFIPDESC") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A73ConCodPropio = httpContext.GetPar( "ConCodPropio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx20asaconafipdesc0B9( A3CliCod, A73ConCodPropio) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel21"+"_"+"CLICOD") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx21asaclicod0B9( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_60") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_60( A3CliCod) ;
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
            AV21ConCodPropio = httpContext.GetPar( "ConCodPropio") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ConCodPropio", AV21ConCodPropio);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCODPROPIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV21ConCodPropio, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "(borrar)", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = cmbConAFIPMarcaRep.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public conceptoafip_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptoafip_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoafip_impl.class ));
   }

   public conceptoafip_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbConAFIPMarcaRep = new HTMLChoice();
      cmbConAFIPSIPAApo = new HTMLChoice();
      cmbConAFIPSIPACont = new HTMLChoice();
      cmbConAFIPINSSJyPApo = new HTMLChoice();
      cmbConAFIPINSSJyPCont = new HTMLChoice();
      cmbConAFIPObraSocApo = new HTMLChoice();
      cmbConAFIPObraSocCont = new HTMLChoice();
      cmbConAFIPFonSolRedApo = new HTMLChoice();
      cmbConAFIPFonSolRedCont = new HTMLChoice();
      cmbConAFIPRenateaApo = new HTMLChoice();
      cmbConAFIPRenateaCont = new HTMLChoice();
      cmbConAFIPAsigFamCont = new HTMLChoice();
      cmbConAFIPFonNacEmpCont = new HTMLChoice();
      cmbConAFIPLeyRieTrabCont = new HTMLChoice();
      cmbConAFIPRegDifApo = new HTMLChoice();
      cmbConAFIPRegEspApo = new HTMLChoice();
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
      if ( cmbConAFIPMarcaRep.getItemCount() > 0 )
      {
         A134ConAFIPMarcaRep = cmbConAFIPMarcaRep.getValidValue(A134ConAFIPMarcaRep) ;
         httpContext.ajax_rsp_assign_attri("", false, "A134ConAFIPMarcaRep", A134ConAFIPMarcaRep);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPMarcaRep.setValue( GXutil.rtrim( A134ConAFIPMarcaRep) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPMarcaRep.getInternalname(), "Values", cmbConAFIPMarcaRep.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPSIPAApo.getItemCount() > 0 )
      {
         A141ConAFIPSIPAApo = cmbConAFIPSIPAApo.getValidValue(A141ConAFIPSIPAApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A141ConAFIPSIPAApo", A141ConAFIPSIPAApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPSIPAApo.setValue( GXutil.rtrim( A141ConAFIPSIPAApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPAApo.getInternalname(), "Values", cmbConAFIPSIPAApo.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPSIPACont.getItemCount() > 0 )
      {
         A142ConAFIPSIPACont = cmbConAFIPSIPACont.getValidValue(A142ConAFIPSIPACont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A142ConAFIPSIPACont", A142ConAFIPSIPACont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPSIPACont.setValue( GXutil.rtrim( A142ConAFIPSIPACont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPACont.getInternalname(), "Values", cmbConAFIPSIPACont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPINSSJyPApo.getItemCount() > 0 )
      {
         A131ConAFIPINSSJyPApo = cmbConAFIPINSSJyPApo.getValidValue(A131ConAFIPINSSJyPApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A131ConAFIPINSSJyPApo", A131ConAFIPINSSJyPApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPINSSJyPApo.setValue( GXutil.rtrim( A131ConAFIPINSSJyPApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPApo.getInternalname(), "Values", cmbConAFIPINSSJyPApo.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPINSSJyPCont.getItemCount() > 0 )
      {
         A132ConAFIPINSSJyPCont = cmbConAFIPINSSJyPCont.getValidValue(A132ConAFIPINSSJyPCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A132ConAFIPINSSJyPCont", A132ConAFIPINSSJyPCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPINSSJyPCont.setValue( GXutil.rtrim( A132ConAFIPINSSJyPCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPCont.getInternalname(), "Values", cmbConAFIPINSSJyPCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPObraSocApo.getItemCount() > 0 )
      {
         A135ConAFIPObraSocApo = cmbConAFIPObraSocApo.getValidValue(A135ConAFIPObraSocApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A135ConAFIPObraSocApo", A135ConAFIPObraSocApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPObraSocApo.setValue( GXutil.rtrim( A135ConAFIPObraSocApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocApo.getInternalname(), "Values", cmbConAFIPObraSocApo.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPObraSocCont.getItemCount() > 0 )
      {
         A136ConAFIPObraSocCont = cmbConAFIPObraSocCont.getValidValue(A136ConAFIPObraSocCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A136ConAFIPObraSocCont", A136ConAFIPObraSocCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPObraSocCont.setValue( GXutil.rtrim( A136ConAFIPObraSocCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocCont.getInternalname(), "Values", cmbConAFIPObraSocCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPFonSolRedApo.getItemCount() > 0 )
      {
         A129ConAFIPFonSolRedApo = cmbConAFIPFonSolRedApo.getValidValue(A129ConAFIPFonSolRedApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A129ConAFIPFonSolRedApo", A129ConAFIPFonSolRedApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPFonSolRedApo.setValue( GXutil.rtrim( A129ConAFIPFonSolRedApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedApo.getInternalname(), "Values", cmbConAFIPFonSolRedApo.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPFonSolRedCont.getItemCount() > 0 )
      {
         A130ConAFIPFonSolRedCont = cmbConAFIPFonSolRedCont.getValidValue(A130ConAFIPFonSolRedCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A130ConAFIPFonSolRedCont", A130ConAFIPFonSolRedCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPFonSolRedCont.setValue( GXutil.rtrim( A130ConAFIPFonSolRedCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedCont.getInternalname(), "Values", cmbConAFIPFonSolRedCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPRenateaApo.getItemCount() > 0 )
      {
         A139ConAFIPRenateaApo = cmbConAFIPRenateaApo.getValidValue(A139ConAFIPRenateaApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A139ConAFIPRenateaApo", A139ConAFIPRenateaApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPRenateaApo.setValue( GXutil.rtrim( A139ConAFIPRenateaApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaApo.getInternalname(), "Values", cmbConAFIPRenateaApo.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPRenateaCont.getItemCount() > 0 )
      {
         A140ConAFIPRenateaCont = cmbConAFIPRenateaCont.getValidValue(A140ConAFIPRenateaCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A140ConAFIPRenateaCont", A140ConAFIPRenateaCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPRenateaCont.setValue( GXutil.rtrim( A140ConAFIPRenateaCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaCont.getInternalname(), "Values", cmbConAFIPRenateaCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPAsigFamCont.getItemCount() > 0 )
      {
         A127ConAFIPAsigFamCont = cmbConAFIPAsigFamCont.getValidValue(A127ConAFIPAsigFamCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A127ConAFIPAsigFamCont", A127ConAFIPAsigFamCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPAsigFamCont.setValue( GXutil.rtrim( A127ConAFIPAsigFamCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPAsigFamCont.getInternalname(), "Values", cmbConAFIPAsigFamCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPFonNacEmpCont.getItemCount() > 0 )
      {
         A128ConAFIPFonNacEmpCont = cmbConAFIPFonNacEmpCont.getValidValue(A128ConAFIPFonNacEmpCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A128ConAFIPFonNacEmpCont", A128ConAFIPFonNacEmpCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPFonNacEmpCont.setValue( GXutil.rtrim( A128ConAFIPFonNacEmpCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonNacEmpCont.getInternalname(), "Values", cmbConAFIPFonNacEmpCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPLeyRieTrabCont.getItemCount() > 0 )
      {
         A133ConAFIPLeyRieTrabCont = cmbConAFIPLeyRieTrabCont.getValidValue(A133ConAFIPLeyRieTrabCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A133ConAFIPLeyRieTrabCont", A133ConAFIPLeyRieTrabCont);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPLeyRieTrabCont.setValue( GXutil.rtrim( A133ConAFIPLeyRieTrabCont) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPLeyRieTrabCont.getInternalname(), "Values", cmbConAFIPLeyRieTrabCont.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPRegDifApo.getItemCount() > 0 )
      {
         A137ConAFIPRegDifApo = cmbConAFIPRegDifApo.getValidValue(A137ConAFIPRegDifApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A137ConAFIPRegDifApo", A137ConAFIPRegDifApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPRegDifApo.setValue( GXutil.rtrim( A137ConAFIPRegDifApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegDifApo.getInternalname(), "Values", cmbConAFIPRegDifApo.ToJavascriptSource(), true);
      }
      if ( cmbConAFIPRegEspApo.getItemCount() > 0 )
      {
         A138ConAFIPRegEspApo = cmbConAFIPRegEspApo.getValidValue(A138ConAFIPRegEspApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A138ConAFIPRegEspApo", A138ConAFIPRegEspApo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConAFIPRegEspApo.setValue( GXutil.rtrim( A138ConAFIPRegEspApo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegEspApo.getInternalname(), "Values", cmbConAFIPRegEspApo.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPMarcaRep.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPMarcaRep.getInternalname(), httpContext.getMessage( "Repeticion", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPMarcaRep, cmbConAFIPMarcaRep.getInternalname(), GXutil.rtrim( A134ConAFIPMarcaRep), 1, cmbConAFIPMarcaRep.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPMarcaRep.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPMarcaRep.setValue( GXutil.rtrim( A134ConAFIPMarcaRep) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPMarcaRep.getInternalname(), "Values", cmbConAFIPMarcaRep.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPSIPAApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPSIPAApo.getInternalname(), httpContext.getMessage( "Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPSIPAApo, cmbConAFIPSIPAApo.getInternalname(), GXutil.rtrim( A141ConAFIPSIPAApo), 1, cmbConAFIPSIPAApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPSIPAApo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPSIPAApo.setValue( GXutil.rtrim( A141ConAFIPSIPAApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPAApo.getInternalname(), "Values", cmbConAFIPSIPAApo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPSIPACont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPSIPACont.getInternalname(), httpContext.getMessage( "Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPSIPACont, cmbConAFIPSIPACont.getInternalname(), GXutil.rtrim( A142ConAFIPSIPACont), 1, cmbConAFIPSIPACont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPSIPACont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPSIPACont.setValue( GXutil.rtrim( A142ConAFIPSIPACont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPACont.getInternalname(), "Values", cmbConAFIPSIPACont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPINSSJyPApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPINSSJyPApo.getInternalname(), httpContext.getMessage( "Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPINSSJyPApo, cmbConAFIPINSSJyPApo.getInternalname(), GXutil.rtrim( A131ConAFIPINSSJyPApo), 1, cmbConAFIPINSSJyPApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPINSSJyPApo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPINSSJyPApo.setValue( GXutil.rtrim( A131ConAFIPINSSJyPApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPApo.getInternalname(), "Values", cmbConAFIPINSSJyPApo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPINSSJyPCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPINSSJyPCont.getInternalname(), httpContext.getMessage( "Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPINSSJyPCont, cmbConAFIPINSSJyPCont.getInternalname(), GXutil.rtrim( A132ConAFIPINSSJyPCont), 1, cmbConAFIPINSSJyPCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPINSSJyPCont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPINSSJyPCont.setValue( GXutil.rtrim( A132ConAFIPINSSJyPCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPCont.getInternalname(), "Values", cmbConAFIPINSSJyPCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPObraSocApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPObraSocApo.getInternalname(), httpContext.getMessage( "Social Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPObraSocApo, cmbConAFIPObraSocApo.getInternalname(), GXutil.rtrim( A135ConAFIPObraSocApo), 1, cmbConAFIPObraSocApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPObraSocApo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPObraSocApo.setValue( GXutil.rtrim( A135ConAFIPObraSocApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocApo.getInternalname(), "Values", cmbConAFIPObraSocApo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPObraSocCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPObraSocCont.getInternalname(), httpContext.getMessage( "Social Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPObraSocCont, cmbConAFIPObraSocCont.getInternalname(), GXutil.rtrim( A136ConAFIPObraSocCont), 1, cmbConAFIPObraSocCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPObraSocCont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPObraSocCont.setValue( GXutil.rtrim( A136ConAFIPObraSocCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocCont.getInternalname(), "Values", cmbConAFIPObraSocCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPFonSolRedApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPFonSolRedApo.getInternalname(), httpContext.getMessage( "Redist. Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPFonSolRedApo, cmbConAFIPFonSolRedApo.getInternalname(), GXutil.rtrim( A129ConAFIPFonSolRedApo), 1, cmbConAFIPFonSolRedApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPFonSolRedApo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPFonSolRedApo.setValue( GXutil.rtrim( A129ConAFIPFonSolRedApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedApo.getInternalname(), "Values", cmbConAFIPFonSolRedApo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPFonSolRedCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPFonSolRedCont.getInternalname(), httpContext.getMessage( "Redist. Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPFonSolRedCont, cmbConAFIPFonSolRedCont.getInternalname(), GXutil.rtrim( A130ConAFIPFonSolRedCont), 1, cmbConAFIPFonSolRedCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPFonSolRedCont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPFonSolRedCont.setValue( GXutil.rtrim( A130ConAFIPFonSolRedCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedCont.getInternalname(), "Values", cmbConAFIPFonSolRedCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPRenateaApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPRenateaApo.getInternalname(), httpContext.getMessage( "Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPRenateaApo, cmbConAFIPRenateaApo.getInternalname(), GXutil.rtrim( A139ConAFIPRenateaApo), 1, cmbConAFIPRenateaApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPRenateaApo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,67);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPRenateaApo.setValue( GXutil.rtrim( A139ConAFIPRenateaApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaApo.getInternalname(), "Values", cmbConAFIPRenateaApo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPRenateaCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPRenateaCont.getInternalname(), httpContext.getMessage( "Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPRenateaCont, cmbConAFIPRenateaCont.getInternalname(), GXutil.rtrim( A140ConAFIPRenateaCont), 1, cmbConAFIPRenateaCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPRenateaCont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,72);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPRenateaCont.setValue( GXutil.rtrim( A140ConAFIPRenateaCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaCont.getInternalname(), "Values", cmbConAFIPRenateaCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPAsigFamCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPAsigFamCont.getInternalname(), httpContext.getMessage( "Familiares Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPAsigFamCont, cmbConAFIPAsigFamCont.getInternalname(), GXutil.rtrim( A127ConAFIPAsigFamCont), 1, cmbConAFIPAsigFamCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPAsigFamCont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,77);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPAsigFamCont.setValue( GXutil.rtrim( A127ConAFIPAsigFamCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPAsigFamCont.getInternalname(), "Values", cmbConAFIPAsigFamCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPFonNacEmpCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPFonNacEmpCont.getInternalname(), httpContext.getMessage( "Empleo Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPFonNacEmpCont, cmbConAFIPFonNacEmpCont.getInternalname(), GXutil.rtrim( A128ConAFIPFonNacEmpCont), 1, cmbConAFIPFonNacEmpCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPFonNacEmpCont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPFonNacEmpCont.setValue( GXutil.rtrim( A128ConAFIPFonNacEmpCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonNacEmpCont.getInternalname(), "Values", cmbConAFIPFonNacEmpCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPLeyRieTrabCont.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPLeyRieTrabCont.getInternalname(), httpContext.getMessage( "Trabajo Contribuciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPLeyRieTrabCont, cmbConAFIPLeyRieTrabCont.getInternalname(), GXutil.rtrim( A133ConAFIPLeyRieTrabCont), 1, cmbConAFIPLeyRieTrabCont.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPLeyRieTrabCont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,87);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPLeyRieTrabCont.setValue( GXutil.rtrim( A133ConAFIPLeyRieTrabCont) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPLeyRieTrabCont.getInternalname(), "Values", cmbConAFIPLeyRieTrabCont.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPRegDifApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPRegDifApo.getInternalname(), httpContext.getMessage( "Diferenciales Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPRegDifApo, cmbConAFIPRegDifApo.getInternalname(), GXutil.rtrim( A137ConAFIPRegDifApo), 1, cmbConAFIPRegDifApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPRegDifApo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,92);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPRegDifApo.setValue( GXutil.rtrim( A137ConAFIPRegDifApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegDifApo.getInternalname(), "Values", cmbConAFIPRegDifApo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConAFIPRegEspApo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConAFIPRegEspApo.getInternalname(), httpContext.getMessage( "Especiales Aportes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConAFIPRegEspApo, cmbConAFIPRegEspApo.getInternalname(), GXutil.rtrim( A138ConAFIPRegEspApo), 1, cmbConAFIPRegEspApo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConAFIPRegEspApo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,97);\"", "", true, (byte)(0), "HLP_ConceptoAFIP.htm");
      cmbConAFIPRegEspApo.setValue( GXutil.rtrim( A138ConAFIPRegEspApo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegEspApo.getInternalname(), "Values", cmbConAFIPRegEspApo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConCodPropio_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConCodPropio_Internalname, httpContext.getMessage( "Cod Propio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConCodPropio_Internalname, GXutil.rtrim( A73ConCodPropio), GXutil.rtrim( localUtil.format( A73ConCodPropio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,102);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodPropio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConCodPropio_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConceptoAFIP.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConAfipEstado_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConAfipEstado_Internalname, httpContext.getMessage( "Afip Estado", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConAfipEstado_Internalname, GXutil.rtrim( A379ConAfipEstado), GXutil.rtrim( localUtil.format( A379ConAfipEstado, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,107);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConAfipEstado_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConAfipEstado_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConceptoAFIP.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 115,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoAFIP.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 117,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoAFIP.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 119,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoAFIP.htm");
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
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 123,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,123);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoAFIP.htm");
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
      e110B2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z73ConCodPropio = httpContext.cgiGet( "Z73ConCodPropio") ;
            Z383ConAfipDesc = httpContext.cgiGet( "Z383ConAfipDesc") ;
            Z386ConAFIPConcepto = httpContext.cgiGet( "Z386ConAFIPConcepto") ;
            n386ConAFIPConcepto = ((GXutil.strcmp("", A386ConAFIPConcepto)==0) ? true : false) ;
            Z134ConAFIPMarcaRep = httpContext.cgiGet( "Z134ConAFIPMarcaRep") ;
            Z141ConAFIPSIPAApo = httpContext.cgiGet( "Z141ConAFIPSIPAApo") ;
            Z142ConAFIPSIPACont = httpContext.cgiGet( "Z142ConAFIPSIPACont") ;
            Z131ConAFIPINSSJyPApo = httpContext.cgiGet( "Z131ConAFIPINSSJyPApo") ;
            Z132ConAFIPINSSJyPCont = httpContext.cgiGet( "Z132ConAFIPINSSJyPCont") ;
            Z135ConAFIPObraSocApo = httpContext.cgiGet( "Z135ConAFIPObraSocApo") ;
            Z136ConAFIPObraSocCont = httpContext.cgiGet( "Z136ConAFIPObraSocCont") ;
            Z129ConAFIPFonSolRedApo = httpContext.cgiGet( "Z129ConAFIPFonSolRedApo") ;
            Z130ConAFIPFonSolRedCont = httpContext.cgiGet( "Z130ConAFIPFonSolRedCont") ;
            Z139ConAFIPRenateaApo = httpContext.cgiGet( "Z139ConAFIPRenateaApo") ;
            Z140ConAFIPRenateaCont = httpContext.cgiGet( "Z140ConAFIPRenateaCont") ;
            Z127ConAFIPAsigFamCont = httpContext.cgiGet( "Z127ConAFIPAsigFamCont") ;
            Z128ConAFIPFonNacEmpCont = httpContext.cgiGet( "Z128ConAFIPFonNacEmpCont") ;
            Z133ConAFIPLeyRieTrabCont = httpContext.cgiGet( "Z133ConAFIPLeyRieTrabCont") ;
            Z137ConAFIPRegDifApo = httpContext.cgiGet( "Z137ConAFIPRegDifApo") ;
            Z138ConAFIPRegEspApo = httpContext.cgiGet( "Z138ConAFIPRegEspApo") ;
            Z379ConAfipEstado = httpContext.cgiGet( "Z379ConAfipEstado") ;
            Z380ConAFIPTipo = httpContext.cgiGet( "Z380ConAFIPTipo") ;
            Z381ConAfipSubT1 = httpContext.cgiGet( "Z381ConAfipSubT1") ;
            Z382ConAfipSubT2 = httpContext.cgiGet( "Z382ConAfipSubT2") ;
            Z703ConAFIPLiquidado = GXutil.strtobool( httpContext.cgiGet( "Z703ConAFIPLiquidado")) ;
            A383ConAfipDesc = httpContext.cgiGet( "Z383ConAfipDesc") ;
            A386ConAFIPConcepto = httpContext.cgiGet( "Z386ConAFIPConcepto") ;
            n386ConAFIPConcepto = false ;
            n386ConAFIPConcepto = ((GXutil.strcmp("", A386ConAFIPConcepto)==0) ? true : false) ;
            A380ConAFIPTipo = httpContext.cgiGet( "Z380ConAFIPTipo") ;
            A381ConAfipSubT1 = httpContext.cgiGet( "Z381ConAfipSubT1") ;
            A382ConAfipSubT2 = httpContext.cgiGet( "Z382ConAfipSubT2") ;
            A703ConAFIPLiquidado = GXutil.strtobool( httpContext.cgiGet( "Z703ConAFIPLiquidado")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N134ConAFIPMarcaRep = httpContext.cgiGet( "N134ConAFIPMarcaRep") ;
            N141ConAFIPSIPAApo = httpContext.cgiGet( "N141ConAFIPSIPAApo") ;
            N142ConAFIPSIPACont = httpContext.cgiGet( "N142ConAFIPSIPACont") ;
            N131ConAFIPINSSJyPApo = httpContext.cgiGet( "N131ConAFIPINSSJyPApo") ;
            N132ConAFIPINSSJyPCont = httpContext.cgiGet( "N132ConAFIPINSSJyPCont") ;
            N135ConAFIPObraSocApo = httpContext.cgiGet( "N135ConAFIPObraSocApo") ;
            N136ConAFIPObraSocCont = httpContext.cgiGet( "N136ConAFIPObraSocCont") ;
            N129ConAFIPFonSolRedApo = httpContext.cgiGet( "N129ConAFIPFonSolRedApo") ;
            N130ConAFIPFonSolRedCont = httpContext.cgiGet( "N130ConAFIPFonSolRedCont") ;
            N139ConAFIPRenateaApo = httpContext.cgiGet( "N139ConAFIPRenateaApo") ;
            N140ConAFIPRenateaCont = httpContext.cgiGet( "N140ConAFIPRenateaCont") ;
            N127ConAFIPAsigFamCont = httpContext.cgiGet( "N127ConAFIPAsigFamCont") ;
            N128ConAFIPFonNacEmpCont = httpContext.cgiGet( "N128ConAFIPFonNacEmpCont") ;
            N133ConAFIPLeyRieTrabCont = httpContext.cgiGet( "N133ConAFIPLeyRieTrabCont") ;
            N137ConAFIPRegDifApo = httpContext.cgiGet( "N137ConAFIPRegDifApo") ;
            N138ConAFIPRegEspApo = httpContext.cgiGet( "N138ConAFIPRegEspApo") ;
            A391ConAfipSubT2Def = httpContext.cgiGet( "CONAFIPSUBT2DEF") ;
            A390ConAfipSubT1Def = httpContext.cgiGet( "CONAFIPSUBT1DEF") ;
            A389ConAFIPTipoDef = httpContext.cgiGet( "CONAFIPTIPODEF") ;
            A383ConAfipDesc = httpContext.cgiGet( "CONAFIPDESC") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV21ConCodPropio = httpContext.cgiGet( "vCONCODPROPIO") ;
            A380ConAFIPTipo = httpContext.cgiGet( "CONAFIPTIPO") ;
            A386ConAFIPConcepto = httpContext.cgiGet( "CONAFIPCONCEPTO") ;
            n386ConAFIPConcepto = ((GXutil.strcmp("", A386ConAFIPConcepto)==0) ? true : false) ;
            A381ConAfipSubT1 = httpContext.cgiGet( "CONAFIPSUBT1") ;
            A382ConAfipSubT2 = httpContext.cgiGet( "CONAFIPSUBT2") ;
            A703ConAFIPLiquidado = GXutil.strtobool( httpContext.cgiGet( "CONAFIPLIQUIDADO")) ;
            AV26Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            cmbConAFIPMarcaRep.setValue( httpContext.cgiGet( cmbConAFIPMarcaRep.getInternalname()) );
            A134ConAFIPMarcaRep = httpContext.cgiGet( cmbConAFIPMarcaRep.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A134ConAFIPMarcaRep", A134ConAFIPMarcaRep);
            cmbConAFIPSIPAApo.setValue( httpContext.cgiGet( cmbConAFIPSIPAApo.getInternalname()) );
            A141ConAFIPSIPAApo = httpContext.cgiGet( cmbConAFIPSIPAApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A141ConAFIPSIPAApo", A141ConAFIPSIPAApo);
            cmbConAFIPSIPACont.setValue( httpContext.cgiGet( cmbConAFIPSIPACont.getInternalname()) );
            A142ConAFIPSIPACont = httpContext.cgiGet( cmbConAFIPSIPACont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A142ConAFIPSIPACont", A142ConAFIPSIPACont);
            cmbConAFIPINSSJyPApo.setValue( httpContext.cgiGet( cmbConAFIPINSSJyPApo.getInternalname()) );
            A131ConAFIPINSSJyPApo = httpContext.cgiGet( cmbConAFIPINSSJyPApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A131ConAFIPINSSJyPApo", A131ConAFIPINSSJyPApo);
            cmbConAFIPINSSJyPCont.setValue( httpContext.cgiGet( cmbConAFIPINSSJyPCont.getInternalname()) );
            A132ConAFIPINSSJyPCont = httpContext.cgiGet( cmbConAFIPINSSJyPCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A132ConAFIPINSSJyPCont", A132ConAFIPINSSJyPCont);
            cmbConAFIPObraSocApo.setValue( httpContext.cgiGet( cmbConAFIPObraSocApo.getInternalname()) );
            A135ConAFIPObraSocApo = httpContext.cgiGet( cmbConAFIPObraSocApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A135ConAFIPObraSocApo", A135ConAFIPObraSocApo);
            cmbConAFIPObraSocCont.setValue( httpContext.cgiGet( cmbConAFIPObraSocCont.getInternalname()) );
            A136ConAFIPObraSocCont = httpContext.cgiGet( cmbConAFIPObraSocCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A136ConAFIPObraSocCont", A136ConAFIPObraSocCont);
            cmbConAFIPFonSolRedApo.setValue( httpContext.cgiGet( cmbConAFIPFonSolRedApo.getInternalname()) );
            A129ConAFIPFonSolRedApo = httpContext.cgiGet( cmbConAFIPFonSolRedApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A129ConAFIPFonSolRedApo", A129ConAFIPFonSolRedApo);
            cmbConAFIPFonSolRedCont.setValue( httpContext.cgiGet( cmbConAFIPFonSolRedCont.getInternalname()) );
            A130ConAFIPFonSolRedCont = httpContext.cgiGet( cmbConAFIPFonSolRedCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A130ConAFIPFonSolRedCont", A130ConAFIPFonSolRedCont);
            cmbConAFIPRenateaApo.setValue( httpContext.cgiGet( cmbConAFIPRenateaApo.getInternalname()) );
            A139ConAFIPRenateaApo = httpContext.cgiGet( cmbConAFIPRenateaApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A139ConAFIPRenateaApo", A139ConAFIPRenateaApo);
            cmbConAFIPRenateaCont.setValue( httpContext.cgiGet( cmbConAFIPRenateaCont.getInternalname()) );
            A140ConAFIPRenateaCont = httpContext.cgiGet( cmbConAFIPRenateaCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A140ConAFIPRenateaCont", A140ConAFIPRenateaCont);
            cmbConAFIPAsigFamCont.setValue( httpContext.cgiGet( cmbConAFIPAsigFamCont.getInternalname()) );
            A127ConAFIPAsigFamCont = httpContext.cgiGet( cmbConAFIPAsigFamCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A127ConAFIPAsigFamCont", A127ConAFIPAsigFamCont);
            cmbConAFIPFonNacEmpCont.setValue( httpContext.cgiGet( cmbConAFIPFonNacEmpCont.getInternalname()) );
            A128ConAFIPFonNacEmpCont = httpContext.cgiGet( cmbConAFIPFonNacEmpCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A128ConAFIPFonNacEmpCont", A128ConAFIPFonNacEmpCont);
            cmbConAFIPLeyRieTrabCont.setValue( httpContext.cgiGet( cmbConAFIPLeyRieTrabCont.getInternalname()) );
            A133ConAFIPLeyRieTrabCont = httpContext.cgiGet( cmbConAFIPLeyRieTrabCont.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A133ConAFIPLeyRieTrabCont", A133ConAFIPLeyRieTrabCont);
            cmbConAFIPRegDifApo.setValue( httpContext.cgiGet( cmbConAFIPRegDifApo.getInternalname()) );
            A137ConAFIPRegDifApo = httpContext.cgiGet( cmbConAFIPRegDifApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A137ConAFIPRegDifApo", A137ConAFIPRegDifApo);
            cmbConAFIPRegEspApo.setValue( httpContext.cgiGet( cmbConAFIPRegEspApo.getInternalname()) );
            A138ConAFIPRegEspApo = httpContext.cgiGet( cmbConAFIPRegEspApo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A138ConAFIPRegEspApo", A138ConAFIPRegEspApo);
            A73ConCodPropio = httpContext.cgiGet( edtConCodPropio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
            A379ConAfipEstado = httpContext.cgiGet( edtConAfipEstado_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A379ConAfipEstado", A379ConAfipEstado);
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
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"ConceptoAFIP");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ConAFIPConcepto", GXutil.rtrim( localUtil.format( A386ConAFIPConcepto, "")));
            forbiddenHiddens.add("ConAFIPTipo", GXutil.rtrim( localUtil.format( A380ConAFIPTipo, "")));
            forbiddenHiddens.add("ConAfipSubT1", GXutil.rtrim( localUtil.format( A381ConAfipSubT1, "")));
            forbiddenHiddens.add("ConAfipSubT2", GXutil.rtrim( localUtil.format( A382ConAfipSubT2, "")));
            forbiddenHiddens.add("ConAFIPLiquidado", GXutil.booltostr( A703ConAFIPLiquidado));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A73ConCodPropio, Z73ConCodPropio) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("conceptoafip:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A73ConCodPropio = httpContext.GetPar( "ConCodPropio") ;
               httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
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
                  sMode9 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode9 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound9 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0B0( ) ;
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
                        e110B2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120B2 ();
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
         e120B2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0B9( ) ;
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
         disableAttributes0B9( ) ;
      }
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

   public void confirm_0B0( )
   {
      beforeValidate0B9( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0B9( ) ;
         }
         else
         {
            checkExtendedTable0B9( ) ;
            closeExtendedTableCursors0B9( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0B0( )
   {
   }

   public void e110B2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      AV11IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoAFIP_Insert", GXv_boolean3) ;
         conceptoafip_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoAFIP_Update", GXv_boolean3) ;
         conceptoafip_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoAFIP_Delete", GXv_boolean3) ;
         conceptoafip_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV26Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
   }

   public void e120B2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm0B9( int GX_JID )
   {
      if ( ( GX_JID == 59 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z383ConAfipDesc = T000B3_A383ConAfipDesc[0] ;
            Z386ConAFIPConcepto = T000B3_A386ConAFIPConcepto[0] ;
            Z134ConAFIPMarcaRep = T000B3_A134ConAFIPMarcaRep[0] ;
            Z141ConAFIPSIPAApo = T000B3_A141ConAFIPSIPAApo[0] ;
            Z142ConAFIPSIPACont = T000B3_A142ConAFIPSIPACont[0] ;
            Z131ConAFIPINSSJyPApo = T000B3_A131ConAFIPINSSJyPApo[0] ;
            Z132ConAFIPINSSJyPCont = T000B3_A132ConAFIPINSSJyPCont[0] ;
            Z135ConAFIPObraSocApo = T000B3_A135ConAFIPObraSocApo[0] ;
            Z136ConAFIPObraSocCont = T000B3_A136ConAFIPObraSocCont[0] ;
            Z129ConAFIPFonSolRedApo = T000B3_A129ConAFIPFonSolRedApo[0] ;
            Z130ConAFIPFonSolRedCont = T000B3_A130ConAFIPFonSolRedCont[0] ;
            Z139ConAFIPRenateaApo = T000B3_A139ConAFIPRenateaApo[0] ;
            Z140ConAFIPRenateaCont = T000B3_A140ConAFIPRenateaCont[0] ;
            Z127ConAFIPAsigFamCont = T000B3_A127ConAFIPAsigFamCont[0] ;
            Z128ConAFIPFonNacEmpCont = T000B3_A128ConAFIPFonNacEmpCont[0] ;
            Z133ConAFIPLeyRieTrabCont = T000B3_A133ConAFIPLeyRieTrabCont[0] ;
            Z137ConAFIPRegDifApo = T000B3_A137ConAFIPRegDifApo[0] ;
            Z138ConAFIPRegEspApo = T000B3_A138ConAFIPRegEspApo[0] ;
            Z379ConAfipEstado = T000B3_A379ConAfipEstado[0] ;
            Z380ConAFIPTipo = T000B3_A380ConAFIPTipo[0] ;
            Z381ConAfipSubT1 = T000B3_A381ConAfipSubT1[0] ;
            Z382ConAfipSubT2 = T000B3_A382ConAfipSubT2[0] ;
            Z703ConAFIPLiquidado = T000B3_A703ConAFIPLiquidado[0] ;
         }
         else
         {
            Z383ConAfipDesc = A383ConAfipDesc ;
            Z386ConAFIPConcepto = A386ConAFIPConcepto ;
            Z134ConAFIPMarcaRep = A134ConAFIPMarcaRep ;
            Z141ConAFIPSIPAApo = A141ConAFIPSIPAApo ;
            Z142ConAFIPSIPACont = A142ConAFIPSIPACont ;
            Z131ConAFIPINSSJyPApo = A131ConAFIPINSSJyPApo ;
            Z132ConAFIPINSSJyPCont = A132ConAFIPINSSJyPCont ;
            Z135ConAFIPObraSocApo = A135ConAFIPObraSocApo ;
            Z136ConAFIPObraSocCont = A136ConAFIPObraSocCont ;
            Z129ConAFIPFonSolRedApo = A129ConAFIPFonSolRedApo ;
            Z130ConAFIPFonSolRedCont = A130ConAFIPFonSolRedCont ;
            Z139ConAFIPRenateaApo = A139ConAFIPRenateaApo ;
            Z140ConAFIPRenateaCont = A140ConAFIPRenateaCont ;
            Z127ConAFIPAsigFamCont = A127ConAFIPAsigFamCont ;
            Z128ConAFIPFonNacEmpCont = A128ConAFIPFonNacEmpCont ;
            Z133ConAFIPLeyRieTrabCont = A133ConAFIPLeyRieTrabCont ;
            Z137ConAFIPRegDifApo = A137ConAFIPRegDifApo ;
            Z138ConAFIPRegEspApo = A138ConAFIPRegEspApo ;
            Z379ConAfipEstado = A379ConAfipEstado ;
            Z380ConAFIPTipo = A380ConAFIPTipo ;
            Z381ConAfipSubT1 = A381ConAfipSubT1 ;
            Z382ConAfipSubT2 = A382ConAfipSubT2 ;
            Z703ConAFIPLiquidado = A703ConAFIPLiquidado ;
         }
      }
      if ( GX_JID == -59 )
      {
         Z383ConAfipDesc = A383ConAfipDesc ;
         Z73ConCodPropio = A73ConCodPropio ;
         Z386ConAFIPConcepto = A386ConAFIPConcepto ;
         Z134ConAFIPMarcaRep = A134ConAFIPMarcaRep ;
         Z141ConAFIPSIPAApo = A141ConAFIPSIPAApo ;
         Z142ConAFIPSIPACont = A142ConAFIPSIPACont ;
         Z131ConAFIPINSSJyPApo = A131ConAFIPINSSJyPApo ;
         Z132ConAFIPINSSJyPCont = A132ConAFIPINSSJyPCont ;
         Z135ConAFIPObraSocApo = A135ConAFIPObraSocApo ;
         Z136ConAFIPObraSocCont = A136ConAFIPObraSocCont ;
         Z129ConAFIPFonSolRedApo = A129ConAFIPFonSolRedApo ;
         Z130ConAFIPFonSolRedCont = A130ConAFIPFonSolRedCont ;
         Z139ConAFIPRenateaApo = A139ConAFIPRenateaApo ;
         Z140ConAFIPRenateaCont = A140ConAFIPRenateaCont ;
         Z127ConAFIPAsigFamCont = A127ConAFIPAsigFamCont ;
         Z128ConAFIPFonNacEmpCont = A128ConAFIPFonNacEmpCont ;
         Z133ConAFIPLeyRieTrabCont = A133ConAFIPLeyRieTrabCont ;
         Z137ConAFIPRegDifApo = A137ConAFIPRegDifApo ;
         Z138ConAFIPRegEspApo = A138ConAFIPRegEspApo ;
         Z379ConAfipEstado = A379ConAfipEstado ;
         Z380ConAFIPTipo = A380ConAFIPTipo ;
         Z381ConAfipSubT1 = A381ConAfipSubT1 ;
         Z382ConAfipSubT2 = A382ConAfipSubT2 ;
         Z703ConAFIPLiquidado = A703ConAFIPLiquidado ;
         Z3CliCod = A3CliCod ;
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
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            conceptoafip_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
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
      if ( ! (GXutil.strcmp("", AV21ConCodPropio)==0) )
      {
         A73ConCodPropio = AV21ConCodPropio ;
         httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
      }
      if ( ! (GXutil.strcmp("", AV21ConCodPropio)==0) )
      {
         edtConCodPropio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodPropio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodPropio_Enabled), 5, 0), true);
      }
      else
      {
         edtConCodPropio_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodPropio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodPropio_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV21ConCodPropio)==0) )
      {
         edtConCodPropio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodPropio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodPropio_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
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
         AV26Pgmname = "ConceptoAFIP" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
         GXt_char6 = A391ConAfipSubT2Def ;
         GXv_char7[0] = GXt_char6 ;
         new web.conceptogetsubt2(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
         conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
         A391ConAfipSubT2Def = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A391ConAfipSubT2Def", A391ConAfipSubT2Def);
         GXt_char6 = A390ConAfipSubT1Def ;
         GXv_char7[0] = GXt_char6 ;
         new web.conceptogetsubt1(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
         conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
         A390ConAfipSubT1Def = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A390ConAfipSubT1Def", A390ConAfipSubT1Def);
         GXt_char6 = A389ConAFIPTipoDef ;
         GXv_char7[0] = GXt_char6 ;
         new web.conceptogettipo(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
         conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
         A389ConAFIPTipoDef = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A389ConAFIPTipoDef", A389ConAFIPTipoDef);
         GXt_char6 = A383ConAfipDesc ;
         GXv_char7[0] = GXt_char6 ;
         new web.conceptogetdescri(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
         conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
         A383ConAfipDesc = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A383ConAfipDesc", A383ConAfipDesc);
      }
   }

   public void load0B9( )
   {
      /* Using cursor T000B5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A73ConCodPropio});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound9 = (short)(1) ;
         A383ConAfipDesc = T000B5_A383ConAfipDesc[0] ;
         A386ConAFIPConcepto = T000B5_A386ConAFIPConcepto[0] ;
         n386ConAFIPConcepto = T000B5_n386ConAFIPConcepto[0] ;
         A134ConAFIPMarcaRep = T000B5_A134ConAFIPMarcaRep[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A134ConAFIPMarcaRep", A134ConAFIPMarcaRep);
         A141ConAFIPSIPAApo = T000B5_A141ConAFIPSIPAApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A141ConAFIPSIPAApo", A141ConAFIPSIPAApo);
         A142ConAFIPSIPACont = T000B5_A142ConAFIPSIPACont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A142ConAFIPSIPACont", A142ConAFIPSIPACont);
         A131ConAFIPINSSJyPApo = T000B5_A131ConAFIPINSSJyPApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A131ConAFIPINSSJyPApo", A131ConAFIPINSSJyPApo);
         A132ConAFIPINSSJyPCont = T000B5_A132ConAFIPINSSJyPCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A132ConAFIPINSSJyPCont", A132ConAFIPINSSJyPCont);
         A135ConAFIPObraSocApo = T000B5_A135ConAFIPObraSocApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A135ConAFIPObraSocApo", A135ConAFIPObraSocApo);
         A136ConAFIPObraSocCont = T000B5_A136ConAFIPObraSocCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A136ConAFIPObraSocCont", A136ConAFIPObraSocCont);
         A129ConAFIPFonSolRedApo = T000B5_A129ConAFIPFonSolRedApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A129ConAFIPFonSolRedApo", A129ConAFIPFonSolRedApo);
         A130ConAFIPFonSolRedCont = T000B5_A130ConAFIPFonSolRedCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A130ConAFIPFonSolRedCont", A130ConAFIPFonSolRedCont);
         A139ConAFIPRenateaApo = T000B5_A139ConAFIPRenateaApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A139ConAFIPRenateaApo", A139ConAFIPRenateaApo);
         A140ConAFIPRenateaCont = T000B5_A140ConAFIPRenateaCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A140ConAFIPRenateaCont", A140ConAFIPRenateaCont);
         A127ConAFIPAsigFamCont = T000B5_A127ConAFIPAsigFamCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A127ConAFIPAsigFamCont", A127ConAFIPAsigFamCont);
         A128ConAFIPFonNacEmpCont = T000B5_A128ConAFIPFonNacEmpCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A128ConAFIPFonNacEmpCont", A128ConAFIPFonNacEmpCont);
         A133ConAFIPLeyRieTrabCont = T000B5_A133ConAFIPLeyRieTrabCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A133ConAFIPLeyRieTrabCont", A133ConAFIPLeyRieTrabCont);
         A137ConAFIPRegDifApo = T000B5_A137ConAFIPRegDifApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A137ConAFIPRegDifApo", A137ConAFIPRegDifApo);
         A138ConAFIPRegEspApo = T000B5_A138ConAFIPRegEspApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A138ConAFIPRegEspApo", A138ConAFIPRegEspApo);
         A379ConAfipEstado = T000B5_A379ConAfipEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A379ConAfipEstado", A379ConAfipEstado);
         A380ConAFIPTipo = T000B5_A380ConAFIPTipo[0] ;
         A381ConAfipSubT1 = T000B5_A381ConAfipSubT1[0] ;
         A382ConAfipSubT2 = T000B5_A382ConAfipSubT2[0] ;
         A703ConAFIPLiquidado = T000B5_A703ConAFIPLiquidado[0] ;
         zm0B9( -59) ;
      }
      pr_default.close(3);
      onLoadActions0B9( ) ;
   }

   public void onLoadActions0B9( )
   {
      AV26Pgmname = "ConceptoAFIP" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      GXt_char6 = A391ConAfipSubT2Def ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetsubt2(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A391ConAfipSubT2Def = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A391ConAfipSubT2Def", A391ConAfipSubT2Def);
      GXt_char6 = A390ConAfipSubT1Def ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetsubt1(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A390ConAfipSubT1Def = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A390ConAfipSubT1Def", A390ConAfipSubT1Def);
      GXt_char6 = A389ConAFIPTipoDef ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogettipo(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A389ConAFIPTipoDef = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A389ConAFIPTipoDef", A389ConAFIPTipoDef);
      GXt_char6 = A383ConAfipDesc ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetdescri(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A383ConAfipDesc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A383ConAfipDesc", A383ConAfipDesc);
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPMarcaRep.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPMarcaRep.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPMarcaRep.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPMarcaRep.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPMarcaRep.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPMarcaRep.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPSIPAApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPAApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPAApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPSIPAApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPAApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPAApo.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPSIPACont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPACont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPACont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPSIPACont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPACont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPACont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPINSSJyPApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPINSSJyPApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPApo.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPINSSJyPCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPINSSJyPCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPCont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPObraSocApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPObraSocApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocApo.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPObraSocCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPObraSocCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocCont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPFonSolRedApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPFonSolRedApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedApo.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPFonSolRedCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPFonSolRedCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedCont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPRenateaApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPRenateaApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaApo.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPRenateaCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPRenateaCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaCont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPAsigFamCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPAsigFamCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPAsigFamCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPAsigFamCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPAsigFamCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPAsigFamCont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPFonNacEmpCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonNacEmpCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonNacEmpCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPFonNacEmpCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonNacEmpCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonNacEmpCont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPLeyRieTrabCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPLeyRieTrabCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPLeyRieTrabCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPLeyRieTrabCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPLeyRieTrabCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPLeyRieTrabCont.getEnabled(), 5, 0), true);
      }
      if ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 )
      {
         cmbConAFIPRegDifApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegDifApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegDifApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPRegDifApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegDifApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegDifApo.getEnabled(), 5, 0), true);
      }
      if ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 )
      {
         cmbConAFIPRegEspApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegEspApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegEspApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPRegEspApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegEspApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegEspApo.getEnabled(), 5, 0), true);
      }
   }

   public void checkExtendedTable0B9( )
   {
      nIsDirty_9 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV26Pgmname = "ConceptoAFIP" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      /* Using cursor T000B4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      nIsDirty_9 = (short)(1) ;
      GXt_char6 = A391ConAfipSubT2Def ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetsubt2(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A391ConAfipSubT2Def = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A391ConAfipSubT2Def", A391ConAfipSubT2Def);
      nIsDirty_9 = (short)(1) ;
      GXt_char6 = A390ConAfipSubT1Def ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetsubt1(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A390ConAfipSubT1Def = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A390ConAfipSubT1Def", A390ConAfipSubT1Def);
      nIsDirty_9 = (short)(1) ;
      GXt_char6 = A389ConAFIPTipoDef ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogettipo(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A389ConAFIPTipoDef = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A389ConAFIPTipoDef", A389ConAFIPTipoDef);
      nIsDirty_9 = (short)(1) ;
      GXt_char6 = A383ConAfipDesc ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetdescri(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A383ConAfipDesc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A383ConAfipDesc", A383ConAfipDesc);
      if ( ! ( ( GXutil.strcmp(A134ConAFIPMarcaRep, "1") == 0 ) || ( GXutil.strcmp(A134ConAFIPMarcaRep, "0") == 0 ) || ( GXutil.strcmp(A134ConAFIPMarcaRep, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Marce Repeticion", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPMARCAREP");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPMarcaRep.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A141ConAFIPSIPAApo, "1") == 0 ) || ( GXutil.strcmp(A141ConAFIPSIPAApo, "0") == 0 ) || ( GXutil.strcmp(A141ConAFIPSIPAApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "SIPA Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPSIPAAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPSIPAApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A142ConAFIPSIPACont, "1") == 0 ) || ( GXutil.strcmp(A142ConAFIPSIPACont, "0") == 0 ) || ( GXutil.strcmp(A142ConAFIPSIPACont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "SIPA Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPSIPACONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPSIPACont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A131ConAFIPINSSJyPApo, "1") == 0 ) || ( GXutil.strcmp(A131ConAFIPINSSJyPApo, "0") == 0 ) || ( GXutil.strcmp(A131ConAFIPINSSJyPApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "INSSJyP Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPINSSJYPAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPINSSJyPApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A132ConAFIPINSSJyPCont, "1") == 0 ) || ( GXutil.strcmp(A132ConAFIPINSSJyPCont, "0") == 0 ) || ( GXutil.strcmp(A132ConAFIPINSSJyPCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "INSSJyP Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPINSSJYPCONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPINSSJyPCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A135ConAFIPObraSocApo, "1") == 0 ) || ( GXutil.strcmp(A135ConAFIPObraSocApo, "0") == 0 ) || ( GXutil.strcmp(A135ConAFIPObraSocApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Obra Social Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPOBRASOCAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPObraSocApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A136ConAFIPObraSocCont, "1") == 0 ) || ( GXutil.strcmp(A136ConAFIPObraSocCont, "0") == 0 ) || ( GXutil.strcmp(A136ConAFIPObraSocCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Obra Social Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPOBRASOCCONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPObraSocCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A129ConAFIPFonSolRedApo, "1") == 0 ) || ( GXutil.strcmp(A129ConAFIPFonSolRedApo, "0") == 0 ) || ( GXutil.strcmp(A129ConAFIPFonSolRedApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Fondo Solidario Redist. Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPFONSOLREDAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPFonSolRedApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A130ConAFIPFonSolRedCont, "1") == 0 ) || ( GXutil.strcmp(A130ConAFIPFonSolRedCont, "0") == 0 ) || ( GXutil.strcmp(A130ConAFIPFonSolRedCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Fondo Solidario Redist. Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPFONSOLREDCONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPFonSolRedCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A139ConAFIPRenateaApo, "1") == 0 ) || ( GXutil.strcmp(A139ConAFIPRenateaApo, "0") == 0 ) || ( GXutil.strcmp(A139ConAFIPRenateaApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "RENATEA Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPRENATEAAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPRenateaApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A140ConAFIPRenateaCont, "1") == 0 ) || ( GXutil.strcmp(A140ConAFIPRenateaCont, "0") == 0 ) || ( GXutil.strcmp(A140ConAFIPRenateaCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "RENATEA Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPRENATEACONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPRenateaCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A127ConAFIPAsigFamCont, "1") == 0 ) || ( GXutil.strcmp(A127ConAFIPAsigFamCont, "0") == 0 ) || ( GXutil.strcmp(A127ConAFIPAsigFamCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Asignaciones Familiares Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPASIGFAMCONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPAsigFamCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A128ConAFIPFonNacEmpCont, "1") == 0 ) || ( GXutil.strcmp(A128ConAFIPFonNacEmpCont, "0") == 0 ) || ( GXutil.strcmp(A128ConAFIPFonNacEmpCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Fondo Nacional Empleo Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPFONNACEMPCONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPFonNacEmpCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A133ConAFIPLeyRieTrabCont, "1") == 0 ) || ( GXutil.strcmp(A133ConAFIPLeyRieTrabCont, "0") == 0 ) || ( GXutil.strcmp(A133ConAFIPLeyRieTrabCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Ley Riesgos Trabajo Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPLEYRIETRABCONT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPLeyRieTrabCont.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A137ConAFIPRegDifApo, "1") == 0 ) || ( GXutil.strcmp(A137ConAFIPRegDifApo, "0") == 0 ) || ( GXutil.strcmp(A137ConAFIPRegDifApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Regimenes Diferenciales Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPREGDIFAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPRegDifApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A138ConAFIPRegEspApo, "1") == 0 ) || ( GXutil.strcmp(A138ConAFIPRegEspApo, "0") == 0 ) || ( GXutil.strcmp(A138ConAFIPRegEspApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Regimenes Especiales Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONAFIPREGESPAPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConAFIPRegEspApo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPMarcaRep.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPMarcaRep.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPMarcaRep.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPMarcaRep.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPMarcaRep.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPMarcaRep.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPSIPAApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPAApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPAApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPSIPAApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPAApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPAApo.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPSIPACont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPACont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPACont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPSIPACont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPACont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPACont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPINSSJyPApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPINSSJyPApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPApo.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPINSSJyPCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPINSSJyPCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPCont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPObraSocApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPObraSocApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocApo.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPObraSocCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPObraSocCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocCont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPFonSolRedApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPFonSolRedApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedApo.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPFonSolRedCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPFonSolRedCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedCont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPRenateaApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPRenateaApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaApo.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPRenateaCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPRenateaCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaCont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPAsigFamCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPAsigFamCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPAsigFamCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPAsigFamCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPAsigFamCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPAsigFamCont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPFonNacEmpCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonNacEmpCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonNacEmpCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPFonNacEmpCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonNacEmpCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonNacEmpCont.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
      {
         cmbConAFIPLeyRieTrabCont.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPLeyRieTrabCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPLeyRieTrabCont.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPLeyRieTrabCont.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPLeyRieTrabCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPLeyRieTrabCont.getEnabled(), 5, 0), true);
      }
      if ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 )
      {
         cmbConAFIPRegDifApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegDifApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegDifApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPRegDifApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegDifApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegDifApo.getEnabled(), 5, 0), true);
      }
      if ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 )
      {
         cmbConAFIPRegEspApo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegEspApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegEspApo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConAFIPRegEspApo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegEspApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegEspApo.getEnabled(), 5, 0), true);
      }
   }

   public void closeExtendedTableCursors0B9( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_60( int A3CliCod )
   {
      /* Using cursor T000B6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
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

   public void getKey0B9( )
   {
      /* Using cursor T000B7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A73ConCodPropio});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound9 = (short)(1) ;
      }
      else
      {
         RcdFound9 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000B3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A73ConCodPropio});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0B9( 59) ;
         RcdFound9 = (short)(1) ;
         A383ConAfipDesc = T000B3_A383ConAfipDesc[0] ;
         A73ConCodPropio = T000B3_A73ConCodPropio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
         A386ConAFIPConcepto = T000B3_A386ConAFIPConcepto[0] ;
         n386ConAFIPConcepto = T000B3_n386ConAFIPConcepto[0] ;
         A134ConAFIPMarcaRep = T000B3_A134ConAFIPMarcaRep[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A134ConAFIPMarcaRep", A134ConAFIPMarcaRep);
         A141ConAFIPSIPAApo = T000B3_A141ConAFIPSIPAApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A141ConAFIPSIPAApo", A141ConAFIPSIPAApo);
         A142ConAFIPSIPACont = T000B3_A142ConAFIPSIPACont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A142ConAFIPSIPACont", A142ConAFIPSIPACont);
         A131ConAFIPINSSJyPApo = T000B3_A131ConAFIPINSSJyPApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A131ConAFIPINSSJyPApo", A131ConAFIPINSSJyPApo);
         A132ConAFIPINSSJyPCont = T000B3_A132ConAFIPINSSJyPCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A132ConAFIPINSSJyPCont", A132ConAFIPINSSJyPCont);
         A135ConAFIPObraSocApo = T000B3_A135ConAFIPObraSocApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A135ConAFIPObraSocApo", A135ConAFIPObraSocApo);
         A136ConAFIPObraSocCont = T000B3_A136ConAFIPObraSocCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A136ConAFIPObraSocCont", A136ConAFIPObraSocCont);
         A129ConAFIPFonSolRedApo = T000B3_A129ConAFIPFonSolRedApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A129ConAFIPFonSolRedApo", A129ConAFIPFonSolRedApo);
         A130ConAFIPFonSolRedCont = T000B3_A130ConAFIPFonSolRedCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A130ConAFIPFonSolRedCont", A130ConAFIPFonSolRedCont);
         A139ConAFIPRenateaApo = T000B3_A139ConAFIPRenateaApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A139ConAFIPRenateaApo", A139ConAFIPRenateaApo);
         A140ConAFIPRenateaCont = T000B3_A140ConAFIPRenateaCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A140ConAFIPRenateaCont", A140ConAFIPRenateaCont);
         A127ConAFIPAsigFamCont = T000B3_A127ConAFIPAsigFamCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A127ConAFIPAsigFamCont", A127ConAFIPAsigFamCont);
         A128ConAFIPFonNacEmpCont = T000B3_A128ConAFIPFonNacEmpCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A128ConAFIPFonNacEmpCont", A128ConAFIPFonNacEmpCont);
         A133ConAFIPLeyRieTrabCont = T000B3_A133ConAFIPLeyRieTrabCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A133ConAFIPLeyRieTrabCont", A133ConAFIPLeyRieTrabCont);
         A137ConAFIPRegDifApo = T000B3_A137ConAFIPRegDifApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A137ConAFIPRegDifApo", A137ConAFIPRegDifApo);
         A138ConAFIPRegEspApo = T000B3_A138ConAFIPRegEspApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A138ConAFIPRegEspApo", A138ConAFIPRegEspApo);
         A379ConAfipEstado = T000B3_A379ConAfipEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A379ConAfipEstado", A379ConAfipEstado);
         A380ConAFIPTipo = T000B3_A380ConAFIPTipo[0] ;
         A381ConAfipSubT1 = T000B3_A381ConAfipSubT1[0] ;
         A382ConAfipSubT2 = T000B3_A382ConAfipSubT2[0] ;
         A703ConAFIPLiquidado = T000B3_A703ConAFIPLiquidado[0] ;
         A3CliCod = T000B3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         Z3CliCod = A3CliCod ;
         Z73ConCodPropio = A73ConCodPropio ;
         sMode9 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0B9( ) ;
         if ( AnyError == 1 )
         {
            RcdFound9 = (short)(0) ;
            initializeNonKey0B9( ) ;
         }
         Gx_mode = sMode9 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound9 = (short)(0) ;
         initializeNonKey0B9( ) ;
         sMode9 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode9 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0B9( ) ;
      if ( RcdFound9 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound9 = (short)(0) ;
      /* Using cursor T000B8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A73ConCodPropio});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T000B8_A3CliCod[0] < A3CliCod ) || ( T000B8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000B8_A73ConCodPropio[0], A73ConCodPropio) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T000B8_A3CliCod[0] > A3CliCod ) || ( T000B8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000B8_A73ConCodPropio[0], A73ConCodPropio) > 0 ) ) )
         {
            A3CliCod = T000B8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A73ConCodPropio = T000B8_A73ConCodPropio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
            RcdFound9 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound9 = (short)(0) ;
      /* Using cursor T000B9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A73ConCodPropio});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T000B9_A3CliCod[0] > A3CliCod ) || ( T000B9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000B9_A73ConCodPropio[0], A73ConCodPropio) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T000B9_A3CliCod[0] < A3CliCod ) || ( T000B9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000B9_A73ConCodPropio[0], A73ConCodPropio) < 0 ) ) )
         {
            A3CliCod = T000B9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A73ConCodPropio = T000B9_A73ConCodPropio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
            RcdFound9 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0B9( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = cmbConAFIPMarcaRep.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0B9( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound9 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A73ConCodPropio, Z73ConCodPropio) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A73ConCodPropio = Z73ConCodPropio ;
               httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = cmbConAFIPMarcaRep.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0B9( ) ;
               GX_FocusControl = cmbConAFIPMarcaRep.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A73ConCodPropio, Z73ConCodPropio) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = cmbConAFIPMarcaRep.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0B9( ) ;
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
                  GX_FocusControl = cmbConAFIPMarcaRep.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0B9( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A73ConCodPropio, Z73ConCodPropio) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A73ConCodPropio = Z73ConCodPropio ;
         httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = cmbConAFIPMarcaRep.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0B9( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000B2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A73ConCodPropio});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoAFIP"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z383ConAfipDesc, T000B2_A383ConAfipDesc[0]) != 0 ) || ( GXutil.strcmp(Z386ConAFIPConcepto, T000B2_A386ConAFIPConcepto[0]) != 0 ) || ( GXutil.strcmp(Z134ConAFIPMarcaRep, T000B2_A134ConAFIPMarcaRep[0]) != 0 ) || ( GXutil.strcmp(Z141ConAFIPSIPAApo, T000B2_A141ConAFIPSIPAApo[0]) != 0 ) || ( GXutil.strcmp(Z142ConAFIPSIPACont, T000B2_A142ConAFIPSIPACont[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z131ConAFIPINSSJyPApo, T000B2_A131ConAFIPINSSJyPApo[0]) != 0 ) || ( GXutil.strcmp(Z132ConAFIPINSSJyPCont, T000B2_A132ConAFIPINSSJyPCont[0]) != 0 ) || ( GXutil.strcmp(Z135ConAFIPObraSocApo, T000B2_A135ConAFIPObraSocApo[0]) != 0 ) || ( GXutil.strcmp(Z136ConAFIPObraSocCont, T000B2_A136ConAFIPObraSocCont[0]) != 0 ) || ( GXutil.strcmp(Z129ConAFIPFonSolRedApo, T000B2_A129ConAFIPFonSolRedApo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z130ConAFIPFonSolRedCont, T000B2_A130ConAFIPFonSolRedCont[0]) != 0 ) || ( GXutil.strcmp(Z139ConAFIPRenateaApo, T000B2_A139ConAFIPRenateaApo[0]) != 0 ) || ( GXutil.strcmp(Z140ConAFIPRenateaCont, T000B2_A140ConAFIPRenateaCont[0]) != 0 ) || ( GXutil.strcmp(Z127ConAFIPAsigFamCont, T000B2_A127ConAFIPAsigFamCont[0]) != 0 ) || ( GXutil.strcmp(Z128ConAFIPFonNacEmpCont, T000B2_A128ConAFIPFonNacEmpCont[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z133ConAFIPLeyRieTrabCont, T000B2_A133ConAFIPLeyRieTrabCont[0]) != 0 ) || ( GXutil.strcmp(Z137ConAFIPRegDifApo, T000B2_A137ConAFIPRegDifApo[0]) != 0 ) || ( GXutil.strcmp(Z138ConAFIPRegEspApo, T000B2_A138ConAFIPRegEspApo[0]) != 0 ) || ( GXutil.strcmp(Z379ConAfipEstado, T000B2_A379ConAfipEstado[0]) != 0 ) || ( GXutil.strcmp(Z380ConAFIPTipo, T000B2_A380ConAFIPTipo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z381ConAfipSubT1, T000B2_A381ConAfipSubT1[0]) != 0 ) || ( GXutil.strcmp(Z382ConAfipSubT2, T000B2_A382ConAfipSubT2[0]) != 0 ) || ( Z703ConAFIPLiquidado != T000B2_A703ConAFIPLiquidado[0] ) )
         {
            if ( GXutil.strcmp(Z383ConAfipDesc, T000B2_A383ConAfipDesc[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAfipDesc");
               GXutil.writeLogRaw("Old: ",Z383ConAfipDesc);
               GXutil.writeLogRaw("Current: ",T000B2_A383ConAfipDesc[0]);
            }
            if ( GXutil.strcmp(Z386ConAFIPConcepto, T000B2_A386ConAFIPConcepto[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPConcepto");
               GXutil.writeLogRaw("Old: ",Z386ConAFIPConcepto);
               GXutil.writeLogRaw("Current: ",T000B2_A386ConAFIPConcepto[0]);
            }
            if ( GXutil.strcmp(Z134ConAFIPMarcaRep, T000B2_A134ConAFIPMarcaRep[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPMarcaRep");
               GXutil.writeLogRaw("Old: ",Z134ConAFIPMarcaRep);
               GXutil.writeLogRaw("Current: ",T000B2_A134ConAFIPMarcaRep[0]);
            }
            if ( GXutil.strcmp(Z141ConAFIPSIPAApo, T000B2_A141ConAFIPSIPAApo[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPSIPAApo");
               GXutil.writeLogRaw("Old: ",Z141ConAFIPSIPAApo);
               GXutil.writeLogRaw("Current: ",T000B2_A141ConAFIPSIPAApo[0]);
            }
            if ( GXutil.strcmp(Z142ConAFIPSIPACont, T000B2_A142ConAFIPSIPACont[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPSIPACont");
               GXutil.writeLogRaw("Old: ",Z142ConAFIPSIPACont);
               GXutil.writeLogRaw("Current: ",T000B2_A142ConAFIPSIPACont[0]);
            }
            if ( GXutil.strcmp(Z131ConAFIPINSSJyPApo, T000B2_A131ConAFIPINSSJyPApo[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPINSSJyPApo");
               GXutil.writeLogRaw("Old: ",Z131ConAFIPINSSJyPApo);
               GXutil.writeLogRaw("Current: ",T000B2_A131ConAFIPINSSJyPApo[0]);
            }
            if ( GXutil.strcmp(Z132ConAFIPINSSJyPCont, T000B2_A132ConAFIPINSSJyPCont[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPINSSJyPCont");
               GXutil.writeLogRaw("Old: ",Z132ConAFIPINSSJyPCont);
               GXutil.writeLogRaw("Current: ",T000B2_A132ConAFIPINSSJyPCont[0]);
            }
            if ( GXutil.strcmp(Z135ConAFIPObraSocApo, T000B2_A135ConAFIPObraSocApo[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPObraSocApo");
               GXutil.writeLogRaw("Old: ",Z135ConAFIPObraSocApo);
               GXutil.writeLogRaw("Current: ",T000B2_A135ConAFIPObraSocApo[0]);
            }
            if ( GXutil.strcmp(Z136ConAFIPObraSocCont, T000B2_A136ConAFIPObraSocCont[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPObraSocCont");
               GXutil.writeLogRaw("Old: ",Z136ConAFIPObraSocCont);
               GXutil.writeLogRaw("Current: ",T000B2_A136ConAFIPObraSocCont[0]);
            }
            if ( GXutil.strcmp(Z129ConAFIPFonSolRedApo, T000B2_A129ConAFIPFonSolRedApo[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPFonSolRedApo");
               GXutil.writeLogRaw("Old: ",Z129ConAFIPFonSolRedApo);
               GXutil.writeLogRaw("Current: ",T000B2_A129ConAFIPFonSolRedApo[0]);
            }
            if ( GXutil.strcmp(Z130ConAFIPFonSolRedCont, T000B2_A130ConAFIPFonSolRedCont[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPFonSolRedCont");
               GXutil.writeLogRaw("Old: ",Z130ConAFIPFonSolRedCont);
               GXutil.writeLogRaw("Current: ",T000B2_A130ConAFIPFonSolRedCont[0]);
            }
            if ( GXutil.strcmp(Z139ConAFIPRenateaApo, T000B2_A139ConAFIPRenateaApo[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPRenateaApo");
               GXutil.writeLogRaw("Old: ",Z139ConAFIPRenateaApo);
               GXutil.writeLogRaw("Current: ",T000B2_A139ConAFIPRenateaApo[0]);
            }
            if ( GXutil.strcmp(Z140ConAFIPRenateaCont, T000B2_A140ConAFIPRenateaCont[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPRenateaCont");
               GXutil.writeLogRaw("Old: ",Z140ConAFIPRenateaCont);
               GXutil.writeLogRaw("Current: ",T000B2_A140ConAFIPRenateaCont[0]);
            }
            if ( GXutil.strcmp(Z127ConAFIPAsigFamCont, T000B2_A127ConAFIPAsigFamCont[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPAsigFamCont");
               GXutil.writeLogRaw("Old: ",Z127ConAFIPAsigFamCont);
               GXutil.writeLogRaw("Current: ",T000B2_A127ConAFIPAsigFamCont[0]);
            }
            if ( GXutil.strcmp(Z128ConAFIPFonNacEmpCont, T000B2_A128ConAFIPFonNacEmpCont[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPFonNacEmpCont");
               GXutil.writeLogRaw("Old: ",Z128ConAFIPFonNacEmpCont);
               GXutil.writeLogRaw("Current: ",T000B2_A128ConAFIPFonNacEmpCont[0]);
            }
            if ( GXutil.strcmp(Z133ConAFIPLeyRieTrabCont, T000B2_A133ConAFIPLeyRieTrabCont[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPLeyRieTrabCont");
               GXutil.writeLogRaw("Old: ",Z133ConAFIPLeyRieTrabCont);
               GXutil.writeLogRaw("Current: ",T000B2_A133ConAFIPLeyRieTrabCont[0]);
            }
            if ( GXutil.strcmp(Z137ConAFIPRegDifApo, T000B2_A137ConAFIPRegDifApo[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPRegDifApo");
               GXutil.writeLogRaw("Old: ",Z137ConAFIPRegDifApo);
               GXutil.writeLogRaw("Current: ",T000B2_A137ConAFIPRegDifApo[0]);
            }
            if ( GXutil.strcmp(Z138ConAFIPRegEspApo, T000B2_A138ConAFIPRegEspApo[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPRegEspApo");
               GXutil.writeLogRaw("Old: ",Z138ConAFIPRegEspApo);
               GXutil.writeLogRaw("Current: ",T000B2_A138ConAFIPRegEspApo[0]);
            }
            if ( GXutil.strcmp(Z379ConAfipEstado, T000B2_A379ConAfipEstado[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAfipEstado");
               GXutil.writeLogRaw("Old: ",Z379ConAfipEstado);
               GXutil.writeLogRaw("Current: ",T000B2_A379ConAfipEstado[0]);
            }
            if ( GXutil.strcmp(Z380ConAFIPTipo, T000B2_A380ConAFIPTipo[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPTipo");
               GXutil.writeLogRaw("Old: ",Z380ConAFIPTipo);
               GXutil.writeLogRaw("Current: ",T000B2_A380ConAFIPTipo[0]);
            }
            if ( GXutil.strcmp(Z381ConAfipSubT1, T000B2_A381ConAfipSubT1[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAfipSubT1");
               GXutil.writeLogRaw("Old: ",Z381ConAfipSubT1);
               GXutil.writeLogRaw("Current: ",T000B2_A381ConAfipSubT1[0]);
            }
            if ( GXutil.strcmp(Z382ConAfipSubT2, T000B2_A382ConAfipSubT2[0]) != 0 )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAfipSubT2");
               GXutil.writeLogRaw("Old: ",Z382ConAfipSubT2);
               GXutil.writeLogRaw("Current: ",T000B2_A382ConAfipSubT2[0]);
            }
            if ( Z703ConAFIPLiquidado != T000B2_A703ConAFIPLiquidado[0] )
            {
               GXutil.writeLogln("conceptoafip:[seudo value changed for attri]"+"ConAFIPLiquidado");
               GXutil.writeLogRaw("Old: ",Z703ConAFIPLiquidado);
               GXutil.writeLogRaw("Current: ",T000B2_A703ConAFIPLiquidado[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ConceptoAFIP"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0B9( )
   {
      beforeValidate0B9( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0B9( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0B9( 0) ;
         checkOptimisticConcurrency0B9( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0B9( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0B9( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000B10 */
                  pr_default.execute(8, new Object[] {A383ConAfipDesc, A73ConCodPropio, Boolean.valueOf(n386ConAFIPConcepto), A386ConAFIPConcepto, A134ConAFIPMarcaRep, A141ConAFIPSIPAApo, A142ConAFIPSIPACont, A131ConAFIPINSSJyPApo, A132ConAFIPINSSJyPCont, A135ConAFIPObraSocApo, A136ConAFIPObraSocCont, A129ConAFIPFonSolRedApo, A130ConAFIPFonSolRedCont, A139ConAFIPRenateaApo, A140ConAFIPRenateaCont, A127ConAFIPAsigFamCont, A128ConAFIPFonNacEmpCont, A133ConAFIPLeyRieTrabCont, A137ConAFIPRegDifApo, A138ConAFIPRegEspApo, A379ConAfipEstado, A380ConAFIPTipo, A381ConAfipSubT1, A382ConAfipSubT2, Boolean.valueOf(A703ConAFIPLiquidado), Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoAFIP");
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
                        resetCaption0B0( ) ;
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
            load0B9( ) ;
         }
         endLevel0B9( ) ;
      }
      closeExtendedTableCursors0B9( ) ;
   }

   public void update0B9( )
   {
      beforeValidate0B9( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0B9( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0B9( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0B9( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0B9( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000B11 */
                  pr_default.execute(9, new Object[] {A383ConAfipDesc, Boolean.valueOf(n386ConAFIPConcepto), A386ConAFIPConcepto, A134ConAFIPMarcaRep, A141ConAFIPSIPAApo, A142ConAFIPSIPACont, A131ConAFIPINSSJyPApo, A132ConAFIPINSSJyPCont, A135ConAFIPObraSocApo, A136ConAFIPObraSocCont, A129ConAFIPFonSolRedApo, A130ConAFIPFonSolRedCont, A139ConAFIPRenateaApo, A140ConAFIPRenateaCont, A127ConAFIPAsigFamCont, A128ConAFIPFonNacEmpCont, A133ConAFIPLeyRieTrabCont, A137ConAFIPRegDifApo, A138ConAFIPRegEspApo, A379ConAfipEstado, A380ConAFIPTipo, A381ConAfipSubT1, A382ConAfipSubT2, Boolean.valueOf(A703ConAFIPLiquidado), Integer.valueOf(A3CliCod), A73ConCodPropio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoAFIP");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoAFIP"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0B9( ) ;
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
         endLevel0B9( ) ;
      }
      closeExtendedTableCursors0B9( ) ;
   }

   public void deferredUpdate0B9( )
   {
   }

   public void delete( )
   {
      beforeValidate0B9( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0B9( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0B9( ) ;
         afterConfirm0B9( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0B9( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000B12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A73ConCodPropio});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoAFIP");
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
      sMode9 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0B9( ) ;
      Gx_mode = sMode9 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0B9( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV26Pgmname = "ConceptoAFIP" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
         GXt_char6 = A391ConAfipSubT2Def ;
         GXv_char7[0] = GXt_char6 ;
         new web.conceptogetsubt2(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
         conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
         A391ConAfipSubT2Def = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A391ConAfipSubT2Def", A391ConAfipSubT2Def);
         GXt_char6 = A390ConAfipSubT1Def ;
         GXv_char7[0] = GXt_char6 ;
         new web.conceptogetsubt1(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
         conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
         A390ConAfipSubT1Def = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A390ConAfipSubT1Def", A390ConAfipSubT1Def);
         GXt_char6 = A389ConAFIPTipoDef ;
         GXv_char7[0] = GXt_char6 ;
         new web.conceptogettipo(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
         conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
         A389ConAFIPTipoDef = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A389ConAFIPTipoDef", A389ConAFIPTipoDef);
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPMarcaRep.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPMarcaRep.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPMarcaRep.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPMarcaRep.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPMarcaRep.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPMarcaRep.getEnabled(), 5, 0), true);
         }
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPSIPAApo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPAApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPAApo.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPSIPAApo.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPAApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPAApo.getEnabled(), 5, 0), true);
         }
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPSIPACont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPACont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPACont.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPSIPACont.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPACont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPACont.getEnabled(), 5, 0), true);
         }
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPINSSJyPApo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPApo.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPINSSJyPApo.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPApo.getEnabled(), 5, 0), true);
         }
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPINSSJyPCont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPCont.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPINSSJyPCont.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPCont.getEnabled(), 5, 0), true);
         }
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPObraSocApo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocApo.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPObraSocApo.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocApo.getEnabled(), 5, 0), true);
         }
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPObraSocCont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocCont.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPObraSocCont.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocCont.getEnabled(), 5, 0), true);
         }
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPFonSolRedApo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedApo.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPFonSolRedApo.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedApo.getEnabled(), 5, 0), true);
         }
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPFonSolRedCont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedCont.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPFonSolRedCont.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedCont.getEnabled(), 5, 0), true);
         }
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPRenateaApo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaApo.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPRenateaApo.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaApo.getEnabled(), 5, 0), true);
         }
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPRenateaCont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaCont.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPRenateaCont.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaCont.getEnabled(), 5, 0), true);
         }
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPAsigFamCont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPAsigFamCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPAsigFamCont.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPAsigFamCont.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPAsigFamCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPAsigFamCont.getEnabled(), 5, 0), true);
         }
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPFonNacEmpCont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonNacEmpCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonNacEmpCont.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPFonNacEmpCont.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonNacEmpCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonNacEmpCont.getEnabled(), 5, 0), true);
         }
         if ( ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) )
         {
            cmbConAFIPLeyRieTrabCont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPLeyRieTrabCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPLeyRieTrabCont.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPLeyRieTrabCont.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPLeyRieTrabCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPLeyRieTrabCont.getEnabled(), 5, 0), true);
         }
         if ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 )
         {
            cmbConAFIPRegDifApo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegDifApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegDifApo.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPRegDifApo.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegDifApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegDifApo.getEnabled(), 5, 0), true);
         }
         if ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 )
         {
            cmbConAFIPRegEspApo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegEspApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegEspApo.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConAFIPRegEspApo.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegEspApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegEspApo.getEnabled(), 5, 0), true);
         }
      }
   }

   public void endLevel0B9( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0B9( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "conceptoafip");
         if ( AnyError == 0 )
         {
            confirmValues0B0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "conceptoafip");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0B9( )
   {
      /* Scan By routine */
      /* Using cursor T000B13 */
      pr_default.execute(11);
      RcdFound9 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound9 = (short)(1) ;
         A3CliCod = T000B13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A73ConCodPropio = T000B13_A73ConCodPropio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0B9( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound9 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound9 = (short)(1) ;
         A3CliCod = T000B13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A73ConCodPropio = T000B13_A73ConCodPropio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
      }
   }

   public void scanEnd0B9( )
   {
      pr_default.close(11);
   }

   public void afterConfirm0B9( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0B9( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0B9( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0B9( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0B9( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0B9( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0B9( )
   {
      cmbConAFIPMarcaRep.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPMarcaRep.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPMarcaRep.getEnabled(), 5, 0), true);
      cmbConAFIPSIPAApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPAApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPAApo.getEnabled(), 5, 0), true);
      cmbConAFIPSIPACont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPSIPACont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPSIPACont.getEnabled(), 5, 0), true);
      cmbConAFIPINSSJyPApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPApo.getEnabled(), 5, 0), true);
      cmbConAFIPINSSJyPCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPINSSJyPCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPINSSJyPCont.getEnabled(), 5, 0), true);
      cmbConAFIPObraSocApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocApo.getEnabled(), 5, 0), true);
      cmbConAFIPObraSocCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPObraSocCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPObraSocCont.getEnabled(), 5, 0), true);
      cmbConAFIPFonSolRedApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedApo.getEnabled(), 5, 0), true);
      cmbConAFIPFonSolRedCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonSolRedCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonSolRedCont.getEnabled(), 5, 0), true);
      cmbConAFIPRenateaApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaApo.getEnabled(), 5, 0), true);
      cmbConAFIPRenateaCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRenateaCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRenateaCont.getEnabled(), 5, 0), true);
      cmbConAFIPAsigFamCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPAsigFamCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPAsigFamCont.getEnabled(), 5, 0), true);
      cmbConAFIPFonNacEmpCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPFonNacEmpCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPFonNacEmpCont.getEnabled(), 5, 0), true);
      cmbConAFIPLeyRieTrabCont.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPLeyRieTrabCont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPLeyRieTrabCont.getEnabled(), 5, 0), true);
      cmbConAFIPRegDifApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegDifApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegDifApo.getEnabled(), 5, 0), true);
      cmbConAFIPRegEspApo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConAFIPRegEspApo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConAFIPRegEspApo.getEnabled(), 5, 0), true);
      edtConCodPropio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodPropio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodPropio_Enabled), 5, 0), true);
      edtConAfipEstado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConAfipEstado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConAfipEstado_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0B9( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0B0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptoafip", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV21ConCodPropio))}, new String[] {"Gx_mode","CliCod","ConCodPropio"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"ConceptoAFIP");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ConAFIPConcepto", GXutil.rtrim( localUtil.format( A386ConAFIPConcepto, "")));
      forbiddenHiddens.add("ConAFIPTipo", GXutil.rtrim( localUtil.format( A380ConAFIPTipo, "")));
      forbiddenHiddens.add("ConAfipSubT1", GXutil.rtrim( localUtil.format( A381ConAfipSubT1, "")));
      forbiddenHiddens.add("ConAfipSubT2", GXutil.rtrim( localUtil.format( A382ConAfipSubT2, "")));
      forbiddenHiddens.add("ConAFIPLiquidado", GXutil.booltostr( A703ConAFIPLiquidado));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("conceptoafip:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z73ConCodPropio", GXutil.rtrim( Z73ConCodPropio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z383ConAfipDesc", Z383ConAfipDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z386ConAFIPConcepto", GXutil.rtrim( Z386ConAFIPConcepto));
      web.GxWebStd.gx_hidden_field( httpContext, "Z134ConAFIPMarcaRep", GXutil.rtrim( Z134ConAFIPMarcaRep));
      web.GxWebStd.gx_hidden_field( httpContext, "Z141ConAFIPSIPAApo", GXutil.rtrim( Z141ConAFIPSIPAApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z142ConAFIPSIPACont", GXutil.rtrim( Z142ConAFIPSIPACont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z131ConAFIPINSSJyPApo", GXutil.rtrim( Z131ConAFIPINSSJyPApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z132ConAFIPINSSJyPCont", GXutil.rtrim( Z132ConAFIPINSSJyPCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z135ConAFIPObraSocApo", GXutil.rtrim( Z135ConAFIPObraSocApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z136ConAFIPObraSocCont", GXutil.rtrim( Z136ConAFIPObraSocCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z129ConAFIPFonSolRedApo", GXutil.rtrim( Z129ConAFIPFonSolRedApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z130ConAFIPFonSolRedCont", GXutil.rtrim( Z130ConAFIPFonSolRedCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z139ConAFIPRenateaApo", GXutil.rtrim( Z139ConAFIPRenateaApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z140ConAFIPRenateaCont", GXutil.rtrim( Z140ConAFIPRenateaCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z127ConAFIPAsigFamCont", GXutil.rtrim( Z127ConAFIPAsigFamCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z128ConAFIPFonNacEmpCont", GXutil.rtrim( Z128ConAFIPFonNacEmpCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z133ConAFIPLeyRieTrabCont", GXutil.rtrim( Z133ConAFIPLeyRieTrabCont));
      web.GxWebStd.gx_hidden_field( httpContext, "Z137ConAFIPRegDifApo", GXutil.rtrim( Z137ConAFIPRegDifApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z138ConAFIPRegEspApo", GXutil.rtrim( Z138ConAFIPRegEspApo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z379ConAfipEstado", GXutil.rtrim( Z379ConAfipEstado));
      web.GxWebStd.gx_hidden_field( httpContext, "Z380ConAFIPTipo", GXutil.rtrim( Z380ConAFIPTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z381ConAfipSubT1", GXutil.rtrim( Z381ConAfipSubT1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z382ConAfipSubT2", GXutil.rtrim( Z382ConAfipSubT2));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z703ConAFIPLiquidado", Z703ConAFIPLiquidado);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N134ConAFIPMarcaRep", GXutil.rtrim( A134ConAFIPMarcaRep));
      web.GxWebStd.gx_hidden_field( httpContext, "N141ConAFIPSIPAApo", GXutil.rtrim( A141ConAFIPSIPAApo));
      web.GxWebStd.gx_hidden_field( httpContext, "N142ConAFIPSIPACont", GXutil.rtrim( A142ConAFIPSIPACont));
      web.GxWebStd.gx_hidden_field( httpContext, "N131ConAFIPINSSJyPApo", GXutil.rtrim( A131ConAFIPINSSJyPApo));
      web.GxWebStd.gx_hidden_field( httpContext, "N132ConAFIPINSSJyPCont", GXutil.rtrim( A132ConAFIPINSSJyPCont));
      web.GxWebStd.gx_hidden_field( httpContext, "N135ConAFIPObraSocApo", GXutil.rtrim( A135ConAFIPObraSocApo));
      web.GxWebStd.gx_hidden_field( httpContext, "N136ConAFIPObraSocCont", GXutil.rtrim( A136ConAFIPObraSocCont));
      web.GxWebStd.gx_hidden_field( httpContext, "N129ConAFIPFonSolRedApo", GXutil.rtrim( A129ConAFIPFonSolRedApo));
      web.GxWebStd.gx_hidden_field( httpContext, "N130ConAFIPFonSolRedCont", GXutil.rtrim( A130ConAFIPFonSolRedCont));
      web.GxWebStd.gx_hidden_field( httpContext, "N139ConAFIPRenateaApo", GXutil.rtrim( A139ConAFIPRenateaApo));
      web.GxWebStd.gx_hidden_field( httpContext, "N140ConAFIPRenateaCont", GXutil.rtrim( A140ConAFIPRenateaCont));
      web.GxWebStd.gx_hidden_field( httpContext, "N127ConAFIPAsigFamCont", GXutil.rtrim( A127ConAFIPAsigFamCont));
      web.GxWebStd.gx_hidden_field( httpContext, "N128ConAFIPFonNacEmpCont", GXutil.rtrim( A128ConAFIPFonNacEmpCont));
      web.GxWebStd.gx_hidden_field( httpContext, "N133ConAFIPLeyRieTrabCont", GXutil.rtrim( A133ConAFIPLeyRieTrabCont));
      web.GxWebStd.gx_hidden_field( httpContext, "N137ConAFIPRegDifApo", GXutil.rtrim( A137ConAFIPRegDifApo));
      web.GxWebStd.gx_hidden_field( httpContext, "N138ConAFIPRegEspApo", GXutil.rtrim( A138ConAFIPRegEspApo));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "CONAFIPSUBT2DEF", GXutil.rtrim( A391ConAfipSubT2Def));
      web.GxWebStd.gx_hidden_field( httpContext, "CONAFIPSUBT1DEF", GXutil.rtrim( A390ConAfipSubT1Def));
      web.GxWebStd.gx_hidden_field( httpContext, "CONAFIPTIPODEF", GXutil.rtrim( A389ConAFIPTipoDef));
      web.GxWebStd.gx_hidden_field( httpContext, "CONAFIPDESC", A383ConAfipDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONCODPROPIO", GXutil.rtrim( AV21ConCodPropio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCODPROPIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV21ConCodPropio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "CONAFIPTIPO", GXutil.rtrim( A380ConAFIPTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "CONAFIPCONCEPTO", GXutil.rtrim( A386ConAFIPConcepto));
      web.GxWebStd.gx_hidden_field( httpContext, "CONAFIPSUBT1", GXutil.rtrim( A381ConAfipSubT1));
      web.GxWebStd.gx_hidden_field( httpContext, "CONAFIPSUBT2", GXutil.rtrim( A382ConAfipSubT2));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONAFIPLIQUIDADO", A703ConAFIPLiquidado);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV26Pgmname));
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
      return formatLink("web.conceptoafip", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV21ConCodPropio))}, new String[] {"Gx_mode","CliCod","ConCodPropio"})  ;
   }

   public String getPgmname( )
   {
      return "ConceptoAFIP" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "(borrar)", "") ;
   }

   public void initializeNonKey0B9( )
   {
      A383ConAfipDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A383ConAfipDesc", A383ConAfipDesc);
      A389ConAFIPTipoDef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A389ConAFIPTipoDef", A389ConAFIPTipoDef);
      A390ConAfipSubT1Def = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A390ConAfipSubT1Def", A390ConAfipSubT1Def);
      A391ConAfipSubT2Def = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A391ConAfipSubT2Def", A391ConAfipSubT2Def);
      A386ConAFIPConcepto = "" ;
      n386ConAFIPConcepto = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A386ConAFIPConcepto", A386ConAFIPConcepto);
      A134ConAFIPMarcaRep = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A134ConAFIPMarcaRep", A134ConAFIPMarcaRep);
      A141ConAFIPSIPAApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A141ConAFIPSIPAApo", A141ConAFIPSIPAApo);
      A142ConAFIPSIPACont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A142ConAFIPSIPACont", A142ConAFIPSIPACont);
      A131ConAFIPINSSJyPApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A131ConAFIPINSSJyPApo", A131ConAFIPINSSJyPApo);
      A132ConAFIPINSSJyPCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A132ConAFIPINSSJyPCont", A132ConAFIPINSSJyPCont);
      A135ConAFIPObraSocApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A135ConAFIPObraSocApo", A135ConAFIPObraSocApo);
      A136ConAFIPObraSocCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A136ConAFIPObraSocCont", A136ConAFIPObraSocCont);
      A129ConAFIPFonSolRedApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A129ConAFIPFonSolRedApo", A129ConAFIPFonSolRedApo);
      A130ConAFIPFonSolRedCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A130ConAFIPFonSolRedCont", A130ConAFIPFonSolRedCont);
      A139ConAFIPRenateaApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A139ConAFIPRenateaApo", A139ConAFIPRenateaApo);
      A140ConAFIPRenateaCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A140ConAFIPRenateaCont", A140ConAFIPRenateaCont);
      A127ConAFIPAsigFamCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A127ConAFIPAsigFamCont", A127ConAFIPAsigFamCont);
      A128ConAFIPFonNacEmpCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A128ConAFIPFonNacEmpCont", A128ConAFIPFonNacEmpCont);
      A133ConAFIPLeyRieTrabCont = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A133ConAFIPLeyRieTrabCont", A133ConAFIPLeyRieTrabCont);
      A137ConAFIPRegDifApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A137ConAFIPRegDifApo", A137ConAFIPRegDifApo);
      A138ConAFIPRegEspApo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A138ConAFIPRegEspApo", A138ConAFIPRegEspApo);
      A379ConAfipEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A379ConAfipEstado", A379ConAfipEstado);
      A380ConAFIPTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A380ConAFIPTipo", A380ConAFIPTipo);
      A381ConAfipSubT1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A381ConAfipSubT1", A381ConAfipSubT1);
      A382ConAfipSubT2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A382ConAfipSubT2", A382ConAfipSubT2);
      A703ConAFIPLiquidado = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A703ConAFIPLiquidado", A703ConAFIPLiquidado);
      Z383ConAfipDesc = "" ;
      Z386ConAFIPConcepto = "" ;
      Z134ConAFIPMarcaRep = "" ;
      Z141ConAFIPSIPAApo = "" ;
      Z142ConAFIPSIPACont = "" ;
      Z131ConAFIPINSSJyPApo = "" ;
      Z132ConAFIPINSSJyPCont = "" ;
      Z135ConAFIPObraSocApo = "" ;
      Z136ConAFIPObraSocCont = "" ;
      Z129ConAFIPFonSolRedApo = "" ;
      Z130ConAFIPFonSolRedCont = "" ;
      Z139ConAFIPRenateaApo = "" ;
      Z140ConAFIPRenateaCont = "" ;
      Z127ConAFIPAsigFamCont = "" ;
      Z128ConAFIPFonNacEmpCont = "" ;
      Z133ConAFIPLeyRieTrabCont = "" ;
      Z137ConAFIPRegDifApo = "" ;
      Z138ConAFIPRegEspApo = "" ;
      Z379ConAfipEstado = "" ;
      Z380ConAFIPTipo = "" ;
      Z381ConAfipSubT1 = "" ;
      Z382ConAfipSubT2 = "" ;
      Z703ConAFIPLiquidado = false ;
   }

   public void initAll0B9( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A73ConCodPropio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A73ConCodPropio", A73ConCodPropio);
      initializeNonKey0B9( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122019463631", true, true);
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
      httpContext.AddJavascriptSource("conceptoafip.js", "?2024122019463631", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      cmbConAFIPMarcaRep.setInternalname( "CONAFIPMARCAREP" );
      cmbConAFIPSIPAApo.setInternalname( "CONAFIPSIPAAPO" );
      cmbConAFIPSIPACont.setInternalname( "CONAFIPSIPACONT" );
      cmbConAFIPINSSJyPApo.setInternalname( "CONAFIPINSSJYPAPO" );
      cmbConAFIPINSSJyPCont.setInternalname( "CONAFIPINSSJYPCONT" );
      cmbConAFIPObraSocApo.setInternalname( "CONAFIPOBRASOCAPO" );
      cmbConAFIPObraSocCont.setInternalname( "CONAFIPOBRASOCCONT" );
      cmbConAFIPFonSolRedApo.setInternalname( "CONAFIPFONSOLREDAPO" );
      cmbConAFIPFonSolRedCont.setInternalname( "CONAFIPFONSOLREDCONT" );
      cmbConAFIPRenateaApo.setInternalname( "CONAFIPRENATEAAPO" );
      cmbConAFIPRenateaCont.setInternalname( "CONAFIPRENATEACONT" );
      cmbConAFIPAsigFamCont.setInternalname( "CONAFIPASIGFAMCONT" );
      cmbConAFIPFonNacEmpCont.setInternalname( "CONAFIPFONNACEMPCONT" );
      cmbConAFIPLeyRieTrabCont.setInternalname( "CONAFIPLEYRIETRABCONT" );
      cmbConAFIPRegDifApo.setInternalname( "CONAFIPREGDIFAPO" );
      cmbConAFIPRegEspApo.setInternalname( "CONAFIPREGESPAPO" );
      edtConCodPropio_Internalname = "CONCODPROPIO" ;
      edtConAfipEstado_Internalname = "CONAFIPESTADO" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
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
      Form.setCaption( httpContext.getMessage( "(borrar)", "") );
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtConAfipEstado_Jsonclick = "" ;
      edtConAfipEstado_Enabled = 1 ;
      edtConCodPropio_Jsonclick = "" ;
      edtConCodPropio_Enabled = 1 ;
      cmbConAFIPRegEspApo.setJsonclick( "" );
      cmbConAFIPRegEspApo.setEnabled( 1 );
      cmbConAFIPRegDifApo.setJsonclick( "" );
      cmbConAFIPRegDifApo.setEnabled( 1 );
      cmbConAFIPLeyRieTrabCont.setJsonclick( "" );
      cmbConAFIPLeyRieTrabCont.setEnabled( 1 );
      cmbConAFIPFonNacEmpCont.setJsonclick( "" );
      cmbConAFIPFonNacEmpCont.setEnabled( 1 );
      cmbConAFIPAsigFamCont.setJsonclick( "" );
      cmbConAFIPAsigFamCont.setEnabled( 1 );
      cmbConAFIPRenateaCont.setJsonclick( "" );
      cmbConAFIPRenateaCont.setEnabled( 1 );
      cmbConAFIPRenateaApo.setJsonclick( "" );
      cmbConAFIPRenateaApo.setEnabled( 1 );
      cmbConAFIPFonSolRedCont.setJsonclick( "" );
      cmbConAFIPFonSolRedCont.setEnabled( 1 );
      cmbConAFIPFonSolRedApo.setJsonclick( "" );
      cmbConAFIPFonSolRedApo.setEnabled( 1 );
      cmbConAFIPObraSocCont.setJsonclick( "" );
      cmbConAFIPObraSocCont.setEnabled( 1 );
      cmbConAFIPObraSocApo.setJsonclick( "" );
      cmbConAFIPObraSocApo.setEnabled( 1 );
      cmbConAFIPINSSJyPCont.setJsonclick( "" );
      cmbConAFIPINSSJyPCont.setEnabled( 1 );
      cmbConAFIPINSSJyPApo.setJsonclick( "" );
      cmbConAFIPINSSJyPApo.setEnabled( 1 );
      cmbConAFIPSIPACont.setJsonclick( "" );
      cmbConAFIPSIPACont.setEnabled( 1 );
      cmbConAFIPSIPAApo.setJsonclick( "" );
      cmbConAFIPSIPAApo.setEnabled( 1 );
      cmbConAFIPMarcaRep.setJsonclick( "" );
      cmbConAFIPMarcaRep.setEnabled( 1 );
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

   public void gx17asaconafipsubt2def0B9( int A3CliCod ,
                                          String A73ConCodPropio )
   {
      GXt_char6 = A391ConAfipSubT2Def ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetsubt2(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A391ConAfipSubT2Def = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A391ConAfipSubT2Def", A391ConAfipSubT2Def);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A391ConAfipSubT2Def))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx18asaconafipsubt1def0B9( int A3CliCod ,
                                          String A73ConCodPropio )
   {
      GXt_char6 = A390ConAfipSubT1Def ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetsubt1(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A390ConAfipSubT1Def = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A390ConAfipSubT1Def", A390ConAfipSubT1Def);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A390ConAfipSubT1Def))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx19asaconafiptipodef0B9( int A3CliCod ,
                                         String A73ConCodPropio )
   {
      GXt_char6 = A389ConAFIPTipoDef ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogettipo(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A389ConAFIPTipoDef = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A389ConAFIPTipoDef", A389ConAFIPTipoDef);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A389ConAFIPTipoDef))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx20asaconafipdesc0B9( int A3CliCod ,
                                      String A73ConCodPropio )
   {
      GXt_char6 = A383ConAfipDesc ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetdescri(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A383ConAfipDesc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A383ConAfipDesc", A383ConAfipDesc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A383ConAfipDesc)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx21asaclicod0B9( int AV7CliCod )
   {
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            conceptoafip_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
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
      cmbConAFIPMarcaRep.setName( "CONAFIPMARCAREP" );
      cmbConAFIPMarcaRep.setWebtags( "" );
      cmbConAFIPMarcaRep.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPMarcaRep.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPMarcaRep.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPMarcaRep.addItem("", "-", (short)(0));
      if ( cmbConAFIPMarcaRep.getItemCount() > 0 )
      {
         A134ConAFIPMarcaRep = cmbConAFIPMarcaRep.getValidValue(A134ConAFIPMarcaRep) ;
         httpContext.ajax_rsp_assign_attri("", false, "A134ConAFIPMarcaRep", A134ConAFIPMarcaRep);
      }
      cmbConAFIPSIPAApo.setName( "CONAFIPSIPAAPO" );
      cmbConAFIPSIPAApo.setWebtags( "" );
      cmbConAFIPSIPAApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPSIPAApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPSIPAApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPSIPAApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPSIPAApo.getItemCount() > 0 )
      {
         A141ConAFIPSIPAApo = cmbConAFIPSIPAApo.getValidValue(A141ConAFIPSIPAApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A141ConAFIPSIPAApo", A141ConAFIPSIPAApo);
      }
      cmbConAFIPSIPACont.setName( "CONAFIPSIPACONT" );
      cmbConAFIPSIPACont.setWebtags( "" );
      cmbConAFIPSIPACont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPSIPACont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPSIPACont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPSIPACont.addItem("", "-", (short)(0));
      if ( cmbConAFIPSIPACont.getItemCount() > 0 )
      {
         A142ConAFIPSIPACont = cmbConAFIPSIPACont.getValidValue(A142ConAFIPSIPACont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A142ConAFIPSIPACont", A142ConAFIPSIPACont);
      }
      cmbConAFIPINSSJyPApo.setName( "CONAFIPINSSJYPAPO" );
      cmbConAFIPINSSJyPApo.setWebtags( "" );
      cmbConAFIPINSSJyPApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPINSSJyPApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPINSSJyPApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPINSSJyPApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPINSSJyPApo.getItemCount() > 0 )
      {
         A131ConAFIPINSSJyPApo = cmbConAFIPINSSJyPApo.getValidValue(A131ConAFIPINSSJyPApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A131ConAFIPINSSJyPApo", A131ConAFIPINSSJyPApo);
      }
      cmbConAFIPINSSJyPCont.setName( "CONAFIPINSSJYPCONT" );
      cmbConAFIPINSSJyPCont.setWebtags( "" );
      cmbConAFIPINSSJyPCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPINSSJyPCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPINSSJyPCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPINSSJyPCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPINSSJyPCont.getItemCount() > 0 )
      {
         A132ConAFIPINSSJyPCont = cmbConAFIPINSSJyPCont.getValidValue(A132ConAFIPINSSJyPCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A132ConAFIPINSSJyPCont", A132ConAFIPINSSJyPCont);
      }
      cmbConAFIPObraSocApo.setName( "CONAFIPOBRASOCAPO" );
      cmbConAFIPObraSocApo.setWebtags( "" );
      cmbConAFIPObraSocApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPObraSocApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPObraSocApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPObraSocApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPObraSocApo.getItemCount() > 0 )
      {
         A135ConAFIPObraSocApo = cmbConAFIPObraSocApo.getValidValue(A135ConAFIPObraSocApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A135ConAFIPObraSocApo", A135ConAFIPObraSocApo);
      }
      cmbConAFIPObraSocCont.setName( "CONAFIPOBRASOCCONT" );
      cmbConAFIPObraSocCont.setWebtags( "" );
      cmbConAFIPObraSocCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPObraSocCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPObraSocCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPObraSocCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPObraSocCont.getItemCount() > 0 )
      {
         A136ConAFIPObraSocCont = cmbConAFIPObraSocCont.getValidValue(A136ConAFIPObraSocCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A136ConAFIPObraSocCont", A136ConAFIPObraSocCont);
      }
      cmbConAFIPFonSolRedApo.setName( "CONAFIPFONSOLREDAPO" );
      cmbConAFIPFonSolRedApo.setWebtags( "" );
      cmbConAFIPFonSolRedApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPFonSolRedApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPFonSolRedApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPFonSolRedApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPFonSolRedApo.getItemCount() > 0 )
      {
         A129ConAFIPFonSolRedApo = cmbConAFIPFonSolRedApo.getValidValue(A129ConAFIPFonSolRedApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A129ConAFIPFonSolRedApo", A129ConAFIPFonSolRedApo);
      }
      cmbConAFIPFonSolRedCont.setName( "CONAFIPFONSOLREDCONT" );
      cmbConAFIPFonSolRedCont.setWebtags( "" );
      cmbConAFIPFonSolRedCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPFonSolRedCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPFonSolRedCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPFonSolRedCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPFonSolRedCont.getItemCount() > 0 )
      {
         A130ConAFIPFonSolRedCont = cmbConAFIPFonSolRedCont.getValidValue(A130ConAFIPFonSolRedCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A130ConAFIPFonSolRedCont", A130ConAFIPFonSolRedCont);
      }
      cmbConAFIPRenateaApo.setName( "CONAFIPRENATEAAPO" );
      cmbConAFIPRenateaApo.setWebtags( "" );
      cmbConAFIPRenateaApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPRenateaApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPRenateaApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPRenateaApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPRenateaApo.getItemCount() > 0 )
      {
         A139ConAFIPRenateaApo = cmbConAFIPRenateaApo.getValidValue(A139ConAFIPRenateaApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A139ConAFIPRenateaApo", A139ConAFIPRenateaApo);
      }
      cmbConAFIPRenateaCont.setName( "CONAFIPRENATEACONT" );
      cmbConAFIPRenateaCont.setWebtags( "" );
      cmbConAFIPRenateaCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPRenateaCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPRenateaCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPRenateaCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPRenateaCont.getItemCount() > 0 )
      {
         A140ConAFIPRenateaCont = cmbConAFIPRenateaCont.getValidValue(A140ConAFIPRenateaCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A140ConAFIPRenateaCont", A140ConAFIPRenateaCont);
      }
      cmbConAFIPAsigFamCont.setName( "CONAFIPASIGFAMCONT" );
      cmbConAFIPAsigFamCont.setWebtags( "" );
      cmbConAFIPAsigFamCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPAsigFamCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPAsigFamCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPAsigFamCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPAsigFamCont.getItemCount() > 0 )
      {
         A127ConAFIPAsigFamCont = cmbConAFIPAsigFamCont.getValidValue(A127ConAFIPAsigFamCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A127ConAFIPAsigFamCont", A127ConAFIPAsigFamCont);
      }
      cmbConAFIPFonNacEmpCont.setName( "CONAFIPFONNACEMPCONT" );
      cmbConAFIPFonNacEmpCont.setWebtags( "" );
      cmbConAFIPFonNacEmpCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPFonNacEmpCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPFonNacEmpCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPFonNacEmpCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPFonNacEmpCont.getItemCount() > 0 )
      {
         A128ConAFIPFonNacEmpCont = cmbConAFIPFonNacEmpCont.getValidValue(A128ConAFIPFonNacEmpCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A128ConAFIPFonNacEmpCont", A128ConAFIPFonNacEmpCont);
      }
      cmbConAFIPLeyRieTrabCont.setName( "CONAFIPLEYRIETRABCONT" );
      cmbConAFIPLeyRieTrabCont.setWebtags( "" );
      cmbConAFIPLeyRieTrabCont.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPLeyRieTrabCont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPLeyRieTrabCont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPLeyRieTrabCont.addItem("", "-", (short)(0));
      if ( cmbConAFIPLeyRieTrabCont.getItemCount() > 0 )
      {
         A133ConAFIPLeyRieTrabCont = cmbConAFIPLeyRieTrabCont.getValidValue(A133ConAFIPLeyRieTrabCont) ;
         httpContext.ajax_rsp_assign_attri("", false, "A133ConAFIPLeyRieTrabCont", A133ConAFIPLeyRieTrabCont);
      }
      cmbConAFIPRegDifApo.setName( "CONAFIPREGDIFAPO" );
      cmbConAFIPRegDifApo.setWebtags( "" );
      cmbConAFIPRegDifApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPRegDifApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPRegDifApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPRegDifApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPRegDifApo.getItemCount() > 0 )
      {
         A137ConAFIPRegDifApo = cmbConAFIPRegDifApo.getValidValue(A137ConAFIPRegDifApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A137ConAFIPRegDifApo", A137ConAFIPRegDifApo);
      }
      cmbConAFIPRegEspApo.setName( "CONAFIPREGESPAPO" );
      cmbConAFIPRegEspApo.setWebtags( "" );
      cmbConAFIPRegEspApo.addItem("", httpContext.getMessage( "-", ""), (short)(0));
      cmbConAFIPRegEspApo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbConAFIPRegEspApo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbConAFIPRegEspApo.addItem("", "-", (short)(0));
      if ( cmbConAFIPRegEspApo.getItemCount() > 0 )
      {
         A138ConAFIPRegEspApo = cmbConAFIPRegEspApo.getValidValue(A138ConAFIPRegEspApo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A138ConAFIPRegEspApo", A138ConAFIPRegEspApo);
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

   public void valid_Clicod( )
   {
      /* Using cursor T000B14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(12);
      GXt_char6 = A391ConAfipSubT2Def ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetsubt2(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A391ConAfipSubT2Def = GXt_char6 ;
      GXt_char6 = A390ConAfipSubT1Def ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetsubt1(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A390ConAfipSubT1Def = GXt_char6 ;
      GXt_char6 = A389ConAFIPTipoDef ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogettipo(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A389ConAFIPTipoDef = GXt_char6 ;
      GXt_char6 = A383ConAfipDesc ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetdescri(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_impl.this.GXt_char6 = GXv_char7[0] ;
      A383ConAfipDesc = GXt_char6 ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A391ConAfipSubT2Def", GXutil.rtrim( A391ConAfipSubT2Def));
      httpContext.ajax_rsp_assign_attri("", false, "A390ConAfipSubT1Def", GXutil.rtrim( A390ConAfipSubT1Def));
      httpContext.ajax_rsp_assign_attri("", false, "A389ConAFIPTipoDef", GXutil.rtrim( A389ConAFIPTipoDef));
      httpContext.ajax_rsp_assign_attri("", false, "A383ConAfipDesc", A383ConAfipDesc);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21ConCodPropio',fld:'vCONCODPROPIO',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21ConCodPropio',fld:'vCONCODPROPIO',pic:'',hsh:true},{av:'A386ConAFIPConcepto',fld:'CONAFIPCONCEPTO',pic:''},{av:'A380ConAFIPTipo',fld:'CONAFIPTIPO',pic:''},{av:'A381ConAfipSubT1',fld:'CONAFIPSUBT1',pic:''},{av:'A382ConAfipSubT2',fld:'CONAFIPSUBT2',pic:''},{av:'A703ConAFIPLiquidado',fld:'CONAFIPLIQUIDADO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120B2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPMARCAREP","{handler:'valid_Conafipmarcarep',iparms:[]");
      setEventMetadata("VALID_CONAFIPMARCAREP",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPSIPAAPO","{handler:'valid_Conafipsipaapo',iparms:[]");
      setEventMetadata("VALID_CONAFIPSIPAAPO",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPSIPACONT","{handler:'valid_Conafipsipacont',iparms:[]");
      setEventMetadata("VALID_CONAFIPSIPACONT",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPINSSJYPAPO","{handler:'valid_Conafipinssjypapo',iparms:[]");
      setEventMetadata("VALID_CONAFIPINSSJYPAPO",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPINSSJYPCONT","{handler:'valid_Conafipinssjypcont',iparms:[]");
      setEventMetadata("VALID_CONAFIPINSSJYPCONT",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPOBRASOCAPO","{handler:'valid_Conafipobrasocapo',iparms:[]");
      setEventMetadata("VALID_CONAFIPOBRASOCAPO",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPOBRASOCCONT","{handler:'valid_Conafipobrasoccont',iparms:[]");
      setEventMetadata("VALID_CONAFIPOBRASOCCONT",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPFONSOLREDAPO","{handler:'valid_Conafipfonsolredapo',iparms:[]");
      setEventMetadata("VALID_CONAFIPFONSOLREDAPO",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPFONSOLREDCONT","{handler:'valid_Conafipfonsolredcont',iparms:[]");
      setEventMetadata("VALID_CONAFIPFONSOLREDCONT",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPRENATEAAPO","{handler:'valid_Conafiprenateaapo',iparms:[]");
      setEventMetadata("VALID_CONAFIPRENATEAAPO",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPRENATEACONT","{handler:'valid_Conafiprenateacont',iparms:[]");
      setEventMetadata("VALID_CONAFIPRENATEACONT",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPASIGFAMCONT","{handler:'valid_Conafipasigfamcont',iparms:[]");
      setEventMetadata("VALID_CONAFIPASIGFAMCONT",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPFONNACEMPCONT","{handler:'valid_Conafipfonnacempcont',iparms:[]");
      setEventMetadata("VALID_CONAFIPFONNACEMPCONT",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPLEYRIETRABCONT","{handler:'valid_Conafipleyrietrabcont',iparms:[]");
      setEventMetadata("VALID_CONAFIPLEYRIETRABCONT",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPREGDIFAPO","{handler:'valid_Conafipregdifapo',iparms:[]");
      setEventMetadata("VALID_CONAFIPREGDIFAPO",",oparms:[]}");
      setEventMetadata("VALID_CONAFIPREGESPAPO","{handler:'valid_Conafipregespapo',iparms:[]");
      setEventMetadata("VALID_CONAFIPREGESPAPO",",oparms:[]}");
      setEventMetadata("VALID_CONCODPROPIO","{handler:'valid_Concodpropio',iparms:[]");
      setEventMetadata("VALID_CONCODPROPIO",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A73ConCodPropio',fld:'CONCODPROPIO',pic:''},{av:'A391ConAfipSubT2Def',fld:'CONAFIPSUBT2DEF',pic:''},{av:'A390ConAfipSubT1Def',fld:'CONAFIPSUBT1DEF',pic:''},{av:'A389ConAFIPTipoDef',fld:'CONAFIPTIPODEF',pic:''},{av:'A383ConAfipDesc',fld:'CONAFIPDESC',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A391ConAfipSubT2Def',fld:'CONAFIPSUBT2DEF',pic:''},{av:'A390ConAfipSubT1Def',fld:'CONAFIPSUBT1DEF',pic:''},{av:'A389ConAFIPTipoDef',fld:'CONAFIPTIPODEF',pic:''},{av:'A383ConAfipDesc',fld:'CONAFIPDESC',pic:''}]}");
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
      return "conceptoafip_Execute";
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
      wcpOAV21ConCodPropio = "" ;
      Z73ConCodPropio = "" ;
      Z383ConAfipDesc = "" ;
      Z386ConAFIPConcepto = "" ;
      Z134ConAFIPMarcaRep = "" ;
      Z141ConAFIPSIPAApo = "" ;
      Z142ConAFIPSIPACont = "" ;
      Z131ConAFIPINSSJyPApo = "" ;
      Z132ConAFIPINSSJyPCont = "" ;
      Z135ConAFIPObraSocApo = "" ;
      Z136ConAFIPObraSocCont = "" ;
      Z129ConAFIPFonSolRedApo = "" ;
      Z130ConAFIPFonSolRedCont = "" ;
      Z139ConAFIPRenateaApo = "" ;
      Z140ConAFIPRenateaCont = "" ;
      Z127ConAFIPAsigFamCont = "" ;
      Z128ConAFIPFonNacEmpCont = "" ;
      Z133ConAFIPLeyRieTrabCont = "" ;
      Z137ConAFIPRegDifApo = "" ;
      Z138ConAFIPRegEspApo = "" ;
      Z379ConAfipEstado = "" ;
      Z380ConAFIPTipo = "" ;
      Z381ConAfipSubT1 = "" ;
      Z382ConAfipSubT2 = "" ;
      N134ConAFIPMarcaRep = "" ;
      N141ConAFIPSIPAApo = "" ;
      N142ConAFIPSIPACont = "" ;
      N131ConAFIPINSSJyPApo = "" ;
      N132ConAFIPINSSJyPCont = "" ;
      N135ConAFIPObraSocApo = "" ;
      N136ConAFIPObraSocCont = "" ;
      N129ConAFIPFonSolRedApo = "" ;
      N130ConAFIPFonSolRedCont = "" ;
      N139ConAFIPRenateaApo = "" ;
      N140ConAFIPRenateaCont = "" ;
      N127ConAFIPAsigFamCont = "" ;
      N128ConAFIPFonNacEmpCont = "" ;
      N133ConAFIPLeyRieTrabCont = "" ;
      N137ConAFIPRegDifApo = "" ;
      N138ConAFIPRegEspApo = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A73ConCodPropio = "" ;
      Gx_mode = "" ;
      AV21ConCodPropio = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A134ConAFIPMarcaRep = "" ;
      A141ConAFIPSIPAApo = "" ;
      A142ConAFIPSIPACont = "" ;
      A131ConAFIPINSSJyPApo = "" ;
      A132ConAFIPINSSJyPCont = "" ;
      A135ConAFIPObraSocApo = "" ;
      A136ConAFIPObraSocCont = "" ;
      A129ConAFIPFonSolRedApo = "" ;
      A130ConAFIPFonSolRedCont = "" ;
      A139ConAFIPRenateaApo = "" ;
      A140ConAFIPRenateaCont = "" ;
      A127ConAFIPAsigFamCont = "" ;
      A128ConAFIPFonNacEmpCont = "" ;
      A133ConAFIPLeyRieTrabCont = "" ;
      A137ConAFIPRegDifApo = "" ;
      A138ConAFIPRegEspApo = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A379ConAfipEstado = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A386ConAFIPConcepto = "" ;
      A383ConAfipDesc = "" ;
      A380ConAFIPTipo = "" ;
      A381ConAfipSubT1 = "" ;
      A382ConAfipSubT2 = "" ;
      A391ConAfipSubT2Def = "" ;
      A390ConAfipSubT1Def = "" ;
      A389ConAFIPTipoDef = "" ;
      AV26Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode9 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      T000B5_A383ConAfipDesc = new String[] {""} ;
      T000B5_A73ConCodPropio = new String[] {""} ;
      T000B5_A386ConAFIPConcepto = new String[] {""} ;
      T000B5_n386ConAFIPConcepto = new boolean[] {false} ;
      T000B5_A134ConAFIPMarcaRep = new String[] {""} ;
      T000B5_A141ConAFIPSIPAApo = new String[] {""} ;
      T000B5_A142ConAFIPSIPACont = new String[] {""} ;
      T000B5_A131ConAFIPINSSJyPApo = new String[] {""} ;
      T000B5_A132ConAFIPINSSJyPCont = new String[] {""} ;
      T000B5_A135ConAFIPObraSocApo = new String[] {""} ;
      T000B5_A136ConAFIPObraSocCont = new String[] {""} ;
      T000B5_A129ConAFIPFonSolRedApo = new String[] {""} ;
      T000B5_A130ConAFIPFonSolRedCont = new String[] {""} ;
      T000B5_A139ConAFIPRenateaApo = new String[] {""} ;
      T000B5_A140ConAFIPRenateaCont = new String[] {""} ;
      T000B5_A127ConAFIPAsigFamCont = new String[] {""} ;
      T000B5_A128ConAFIPFonNacEmpCont = new String[] {""} ;
      T000B5_A133ConAFIPLeyRieTrabCont = new String[] {""} ;
      T000B5_A137ConAFIPRegDifApo = new String[] {""} ;
      T000B5_A138ConAFIPRegEspApo = new String[] {""} ;
      T000B5_A379ConAfipEstado = new String[] {""} ;
      T000B5_A380ConAFIPTipo = new String[] {""} ;
      T000B5_A381ConAfipSubT1 = new String[] {""} ;
      T000B5_A382ConAfipSubT2 = new String[] {""} ;
      T000B5_A703ConAFIPLiquidado = new boolean[] {false} ;
      T000B5_A3CliCod = new int[1] ;
      T000B4_A3CliCod = new int[1] ;
      T000B6_A3CliCod = new int[1] ;
      T000B7_A3CliCod = new int[1] ;
      T000B7_A73ConCodPropio = new String[] {""} ;
      T000B3_A383ConAfipDesc = new String[] {""} ;
      T000B3_A73ConCodPropio = new String[] {""} ;
      T000B3_A386ConAFIPConcepto = new String[] {""} ;
      T000B3_n386ConAFIPConcepto = new boolean[] {false} ;
      T000B3_A134ConAFIPMarcaRep = new String[] {""} ;
      T000B3_A141ConAFIPSIPAApo = new String[] {""} ;
      T000B3_A142ConAFIPSIPACont = new String[] {""} ;
      T000B3_A131ConAFIPINSSJyPApo = new String[] {""} ;
      T000B3_A132ConAFIPINSSJyPCont = new String[] {""} ;
      T000B3_A135ConAFIPObraSocApo = new String[] {""} ;
      T000B3_A136ConAFIPObraSocCont = new String[] {""} ;
      T000B3_A129ConAFIPFonSolRedApo = new String[] {""} ;
      T000B3_A130ConAFIPFonSolRedCont = new String[] {""} ;
      T000B3_A139ConAFIPRenateaApo = new String[] {""} ;
      T000B3_A140ConAFIPRenateaCont = new String[] {""} ;
      T000B3_A127ConAFIPAsigFamCont = new String[] {""} ;
      T000B3_A128ConAFIPFonNacEmpCont = new String[] {""} ;
      T000B3_A133ConAFIPLeyRieTrabCont = new String[] {""} ;
      T000B3_A137ConAFIPRegDifApo = new String[] {""} ;
      T000B3_A138ConAFIPRegEspApo = new String[] {""} ;
      T000B3_A379ConAfipEstado = new String[] {""} ;
      T000B3_A380ConAFIPTipo = new String[] {""} ;
      T000B3_A381ConAfipSubT1 = new String[] {""} ;
      T000B3_A382ConAfipSubT2 = new String[] {""} ;
      T000B3_A703ConAFIPLiquidado = new boolean[] {false} ;
      T000B3_A3CliCod = new int[1] ;
      T000B8_A3CliCod = new int[1] ;
      T000B8_A73ConCodPropio = new String[] {""} ;
      T000B9_A3CliCod = new int[1] ;
      T000B9_A73ConCodPropio = new String[] {""} ;
      T000B2_A383ConAfipDesc = new String[] {""} ;
      T000B2_A73ConCodPropio = new String[] {""} ;
      T000B2_A386ConAFIPConcepto = new String[] {""} ;
      T000B2_n386ConAFIPConcepto = new boolean[] {false} ;
      T000B2_A134ConAFIPMarcaRep = new String[] {""} ;
      T000B2_A141ConAFIPSIPAApo = new String[] {""} ;
      T000B2_A142ConAFIPSIPACont = new String[] {""} ;
      T000B2_A131ConAFIPINSSJyPApo = new String[] {""} ;
      T000B2_A132ConAFIPINSSJyPCont = new String[] {""} ;
      T000B2_A135ConAFIPObraSocApo = new String[] {""} ;
      T000B2_A136ConAFIPObraSocCont = new String[] {""} ;
      T000B2_A129ConAFIPFonSolRedApo = new String[] {""} ;
      T000B2_A130ConAFIPFonSolRedCont = new String[] {""} ;
      T000B2_A139ConAFIPRenateaApo = new String[] {""} ;
      T000B2_A140ConAFIPRenateaCont = new String[] {""} ;
      T000B2_A127ConAFIPAsigFamCont = new String[] {""} ;
      T000B2_A128ConAFIPFonNacEmpCont = new String[] {""} ;
      T000B2_A133ConAFIPLeyRieTrabCont = new String[] {""} ;
      T000B2_A137ConAFIPRegDifApo = new String[] {""} ;
      T000B2_A138ConAFIPRegEspApo = new String[] {""} ;
      T000B2_A379ConAfipEstado = new String[] {""} ;
      T000B2_A380ConAFIPTipo = new String[] {""} ;
      T000B2_A381ConAfipSubT1 = new String[] {""} ;
      T000B2_A382ConAfipSubT2 = new String[] {""} ;
      T000B2_A703ConAFIPLiquidado = new boolean[] {false} ;
      T000B2_A3CliCod = new int[1] ;
      T000B13_A3CliCod = new int[1] ;
      T000B13_A73ConCodPropio = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int5 = new int[1] ;
      T000B14_A3CliCod = new int[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      Z391ConAfipSubT2Def = "" ;
      Z390ConAfipSubT1Def = "" ;
      Z389ConAFIPTipoDef = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptoafip__default(),
         new Object[] {
             new Object[] {
            T000B2_A383ConAfipDesc, T000B2_A73ConCodPropio, T000B2_A386ConAFIPConcepto, T000B2_n386ConAFIPConcepto, T000B2_A134ConAFIPMarcaRep, T000B2_A141ConAFIPSIPAApo, T000B2_A142ConAFIPSIPACont, T000B2_A131ConAFIPINSSJyPApo, T000B2_A132ConAFIPINSSJyPCont, T000B2_A135ConAFIPObraSocApo,
            T000B2_A136ConAFIPObraSocCont, T000B2_A129ConAFIPFonSolRedApo, T000B2_A130ConAFIPFonSolRedCont, T000B2_A139ConAFIPRenateaApo, T000B2_A140ConAFIPRenateaCont, T000B2_A127ConAFIPAsigFamCont, T000B2_A128ConAFIPFonNacEmpCont, T000B2_A133ConAFIPLeyRieTrabCont, T000B2_A137ConAFIPRegDifApo, T000B2_A138ConAFIPRegEspApo,
            T000B2_A379ConAfipEstado, T000B2_A380ConAFIPTipo, T000B2_A381ConAfipSubT1, T000B2_A382ConAfipSubT2, T000B2_A703ConAFIPLiquidado, T000B2_A3CliCod
            }
            , new Object[] {
            T000B3_A383ConAfipDesc, T000B3_A73ConCodPropio, T000B3_A386ConAFIPConcepto, T000B3_n386ConAFIPConcepto, T000B3_A134ConAFIPMarcaRep, T000B3_A141ConAFIPSIPAApo, T000B3_A142ConAFIPSIPACont, T000B3_A131ConAFIPINSSJyPApo, T000B3_A132ConAFIPINSSJyPCont, T000B3_A135ConAFIPObraSocApo,
            T000B3_A136ConAFIPObraSocCont, T000B3_A129ConAFIPFonSolRedApo, T000B3_A130ConAFIPFonSolRedCont, T000B3_A139ConAFIPRenateaApo, T000B3_A140ConAFIPRenateaCont, T000B3_A127ConAFIPAsigFamCont, T000B3_A128ConAFIPFonNacEmpCont, T000B3_A133ConAFIPLeyRieTrabCont, T000B3_A137ConAFIPRegDifApo, T000B3_A138ConAFIPRegEspApo,
            T000B3_A379ConAfipEstado, T000B3_A380ConAFIPTipo, T000B3_A381ConAfipSubT1, T000B3_A382ConAfipSubT2, T000B3_A703ConAFIPLiquidado, T000B3_A3CliCod
            }
            , new Object[] {
            T000B4_A3CliCod
            }
            , new Object[] {
            T000B5_A383ConAfipDesc, T000B5_A73ConCodPropio, T000B5_A386ConAFIPConcepto, T000B5_n386ConAFIPConcepto, T000B5_A134ConAFIPMarcaRep, T000B5_A141ConAFIPSIPAApo, T000B5_A142ConAFIPSIPACont, T000B5_A131ConAFIPINSSJyPApo, T000B5_A132ConAFIPINSSJyPCont, T000B5_A135ConAFIPObraSocApo,
            T000B5_A136ConAFIPObraSocCont, T000B5_A129ConAFIPFonSolRedApo, T000B5_A130ConAFIPFonSolRedCont, T000B5_A139ConAFIPRenateaApo, T000B5_A140ConAFIPRenateaCont, T000B5_A127ConAFIPAsigFamCont, T000B5_A128ConAFIPFonNacEmpCont, T000B5_A133ConAFIPLeyRieTrabCont, T000B5_A137ConAFIPRegDifApo, T000B5_A138ConAFIPRegEspApo,
            T000B5_A379ConAfipEstado, T000B5_A380ConAFIPTipo, T000B5_A381ConAfipSubT1, T000B5_A382ConAfipSubT2, T000B5_A703ConAFIPLiquidado, T000B5_A3CliCod
            }
            , new Object[] {
            T000B6_A3CliCod
            }
            , new Object[] {
            T000B7_A3CliCod, T000B7_A73ConCodPropio
            }
            , new Object[] {
            T000B8_A3CliCod, T000B8_A73ConCodPropio
            }
            , new Object[] {
            T000B9_A3CliCod, T000B9_A73ConCodPropio
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000B13_A3CliCod, T000B13_A73ConCodPropio
            }
            , new Object[] {
            T000B14_A3CliCod
            }
         }
      );
      AV26Pgmname = "ConceptoAFIP" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound9 ;
   private short nIsDirty_9 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int AV7CliCod ;
   private int trnEnded ;
   private int edtConCodPropio_Enabled ;
   private int edtConAfipEstado_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV21ConCodPropio ;
   private String Z73ConCodPropio ;
   private String Z386ConAFIPConcepto ;
   private String Z134ConAFIPMarcaRep ;
   private String Z141ConAFIPSIPAApo ;
   private String Z142ConAFIPSIPACont ;
   private String Z131ConAFIPINSSJyPApo ;
   private String Z132ConAFIPINSSJyPCont ;
   private String Z135ConAFIPObraSocApo ;
   private String Z136ConAFIPObraSocCont ;
   private String Z129ConAFIPFonSolRedApo ;
   private String Z130ConAFIPFonSolRedCont ;
   private String Z139ConAFIPRenateaApo ;
   private String Z140ConAFIPRenateaCont ;
   private String Z127ConAFIPAsigFamCont ;
   private String Z128ConAFIPFonNacEmpCont ;
   private String Z133ConAFIPLeyRieTrabCont ;
   private String Z137ConAFIPRegDifApo ;
   private String Z138ConAFIPRegEspApo ;
   private String Z379ConAfipEstado ;
   private String Z380ConAFIPTipo ;
   private String Z381ConAfipSubT1 ;
   private String Z382ConAfipSubT2 ;
   private String N134ConAFIPMarcaRep ;
   private String N141ConAFIPSIPAApo ;
   private String N142ConAFIPSIPACont ;
   private String N131ConAFIPINSSJyPApo ;
   private String N132ConAFIPINSSJyPCont ;
   private String N135ConAFIPObraSocApo ;
   private String N136ConAFIPObraSocCont ;
   private String N129ConAFIPFonSolRedApo ;
   private String N130ConAFIPFonSolRedCont ;
   private String N139ConAFIPRenateaApo ;
   private String N140ConAFIPRenateaCont ;
   private String N127ConAFIPAsigFamCont ;
   private String N128ConAFIPFonNacEmpCont ;
   private String N133ConAFIPLeyRieTrabCont ;
   private String N137ConAFIPRegDifApo ;
   private String N138ConAFIPRegEspApo ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A73ConCodPropio ;
   private String Gx_mode ;
   private String AV21ConCodPropio ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String A134ConAFIPMarcaRep ;
   private String A141ConAFIPSIPAApo ;
   private String A142ConAFIPSIPACont ;
   private String A131ConAFIPINSSJyPApo ;
   private String A132ConAFIPINSSJyPCont ;
   private String A135ConAFIPObraSocApo ;
   private String A136ConAFIPObraSocCont ;
   private String A129ConAFIPFonSolRedApo ;
   private String A130ConAFIPFonSolRedCont ;
   private String A139ConAFIPRenateaApo ;
   private String A140ConAFIPRenateaCont ;
   private String A127ConAFIPAsigFamCont ;
   private String A128ConAFIPFonNacEmpCont ;
   private String A133ConAFIPLeyRieTrabCont ;
   private String A137ConAFIPRegDifApo ;
   private String A138ConAFIPRegEspApo ;
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
   private String edtConCodPropio_Internalname ;
   private String edtConCodPropio_Jsonclick ;
   private String edtConAfipEstado_Internalname ;
   private String A379ConAfipEstado ;
   private String edtConAfipEstado_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String A386ConAFIPConcepto ;
   private String A380ConAFIPTipo ;
   private String A381ConAfipSubT1 ;
   private String A382ConAfipSubT2 ;
   private String A391ConAfipSubT2Def ;
   private String A390ConAfipSubT1Def ;
   private String A389ConAFIPTipoDef ;
   private String AV26Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode9 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String Z391ConAfipSubT2Def ;
   private String Z390ConAfipSubT1Def ;
   private String Z389ConAFIPTipoDef ;
   private boolean Z703ConAFIPLiquidado ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean n386ConAFIPConcepto ;
   private boolean A703ConAFIPLiquidado ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private String Z383ConAfipDesc ;
   private String A383ConAfipDesc ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbConAFIPMarcaRep ;
   private HTMLChoice cmbConAFIPSIPAApo ;
   private HTMLChoice cmbConAFIPSIPACont ;
   private HTMLChoice cmbConAFIPINSSJyPApo ;
   private HTMLChoice cmbConAFIPINSSJyPCont ;
   private HTMLChoice cmbConAFIPObraSocApo ;
   private HTMLChoice cmbConAFIPObraSocCont ;
   private HTMLChoice cmbConAFIPFonSolRedApo ;
   private HTMLChoice cmbConAFIPFonSolRedCont ;
   private HTMLChoice cmbConAFIPRenateaApo ;
   private HTMLChoice cmbConAFIPRenateaCont ;
   private HTMLChoice cmbConAFIPAsigFamCont ;
   private HTMLChoice cmbConAFIPFonNacEmpCont ;
   private HTMLChoice cmbConAFIPLeyRieTrabCont ;
   private HTMLChoice cmbConAFIPRegDifApo ;
   private HTMLChoice cmbConAFIPRegEspApo ;
   private IDataStoreProvider pr_default ;
   private String[] T000B5_A383ConAfipDesc ;
   private String[] T000B5_A73ConCodPropio ;
   private String[] T000B5_A386ConAFIPConcepto ;
   private boolean[] T000B5_n386ConAFIPConcepto ;
   private String[] T000B5_A134ConAFIPMarcaRep ;
   private String[] T000B5_A141ConAFIPSIPAApo ;
   private String[] T000B5_A142ConAFIPSIPACont ;
   private String[] T000B5_A131ConAFIPINSSJyPApo ;
   private String[] T000B5_A132ConAFIPINSSJyPCont ;
   private String[] T000B5_A135ConAFIPObraSocApo ;
   private String[] T000B5_A136ConAFIPObraSocCont ;
   private String[] T000B5_A129ConAFIPFonSolRedApo ;
   private String[] T000B5_A130ConAFIPFonSolRedCont ;
   private String[] T000B5_A139ConAFIPRenateaApo ;
   private String[] T000B5_A140ConAFIPRenateaCont ;
   private String[] T000B5_A127ConAFIPAsigFamCont ;
   private String[] T000B5_A128ConAFIPFonNacEmpCont ;
   private String[] T000B5_A133ConAFIPLeyRieTrabCont ;
   private String[] T000B5_A137ConAFIPRegDifApo ;
   private String[] T000B5_A138ConAFIPRegEspApo ;
   private String[] T000B5_A379ConAfipEstado ;
   private String[] T000B5_A380ConAFIPTipo ;
   private String[] T000B5_A381ConAfipSubT1 ;
   private String[] T000B5_A382ConAfipSubT2 ;
   private boolean[] T000B5_A703ConAFIPLiquidado ;
   private int[] T000B5_A3CliCod ;
   private int[] T000B4_A3CliCod ;
   private int[] T000B6_A3CliCod ;
   private int[] T000B7_A3CliCod ;
   private String[] T000B7_A73ConCodPropio ;
   private String[] T000B3_A383ConAfipDesc ;
   private String[] T000B3_A73ConCodPropio ;
   private String[] T000B3_A386ConAFIPConcepto ;
   private boolean[] T000B3_n386ConAFIPConcepto ;
   private String[] T000B3_A134ConAFIPMarcaRep ;
   private String[] T000B3_A141ConAFIPSIPAApo ;
   private String[] T000B3_A142ConAFIPSIPACont ;
   private String[] T000B3_A131ConAFIPINSSJyPApo ;
   private String[] T000B3_A132ConAFIPINSSJyPCont ;
   private String[] T000B3_A135ConAFIPObraSocApo ;
   private String[] T000B3_A136ConAFIPObraSocCont ;
   private String[] T000B3_A129ConAFIPFonSolRedApo ;
   private String[] T000B3_A130ConAFIPFonSolRedCont ;
   private String[] T000B3_A139ConAFIPRenateaApo ;
   private String[] T000B3_A140ConAFIPRenateaCont ;
   private String[] T000B3_A127ConAFIPAsigFamCont ;
   private String[] T000B3_A128ConAFIPFonNacEmpCont ;
   private String[] T000B3_A133ConAFIPLeyRieTrabCont ;
   private String[] T000B3_A137ConAFIPRegDifApo ;
   private String[] T000B3_A138ConAFIPRegEspApo ;
   private String[] T000B3_A379ConAfipEstado ;
   private String[] T000B3_A380ConAFIPTipo ;
   private String[] T000B3_A381ConAfipSubT1 ;
   private String[] T000B3_A382ConAfipSubT2 ;
   private boolean[] T000B3_A703ConAFIPLiquidado ;
   private int[] T000B3_A3CliCod ;
   private int[] T000B8_A3CliCod ;
   private String[] T000B8_A73ConCodPropio ;
   private int[] T000B9_A3CliCod ;
   private String[] T000B9_A73ConCodPropio ;
   private String[] T000B2_A383ConAfipDesc ;
   private String[] T000B2_A73ConCodPropio ;
   private String[] T000B2_A386ConAFIPConcepto ;
   private boolean[] T000B2_n386ConAFIPConcepto ;
   private String[] T000B2_A134ConAFIPMarcaRep ;
   private String[] T000B2_A141ConAFIPSIPAApo ;
   private String[] T000B2_A142ConAFIPSIPACont ;
   private String[] T000B2_A131ConAFIPINSSJyPApo ;
   private String[] T000B2_A132ConAFIPINSSJyPCont ;
   private String[] T000B2_A135ConAFIPObraSocApo ;
   private String[] T000B2_A136ConAFIPObraSocCont ;
   private String[] T000B2_A129ConAFIPFonSolRedApo ;
   private String[] T000B2_A130ConAFIPFonSolRedCont ;
   private String[] T000B2_A139ConAFIPRenateaApo ;
   private String[] T000B2_A140ConAFIPRenateaCont ;
   private String[] T000B2_A127ConAFIPAsigFamCont ;
   private String[] T000B2_A128ConAFIPFonNacEmpCont ;
   private String[] T000B2_A133ConAFIPLeyRieTrabCont ;
   private String[] T000B2_A137ConAFIPRegDifApo ;
   private String[] T000B2_A138ConAFIPRegEspApo ;
   private String[] T000B2_A379ConAfipEstado ;
   private String[] T000B2_A380ConAFIPTipo ;
   private String[] T000B2_A381ConAfipSubT1 ;
   private String[] T000B2_A382ConAfipSubT2 ;
   private boolean[] T000B2_A703ConAFIPLiquidado ;
   private int[] T000B2_A3CliCod ;
   private int[] T000B13_A3CliCod ;
   private String[] T000B13_A73ConCodPropio ;
   private int[] T000B14_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
}

final  class conceptoafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000B2", "SELECT ConAfipDesc, ConCodPropio, ConAFIPConcepto, ConAFIPMarcaRep, ConAFIPSIPAApo, ConAFIPSIPACont, ConAFIPINSSJyPApo, ConAFIPINSSJyPCont, ConAFIPObraSocApo, ConAFIPObraSocCont, ConAFIPFonSolRedApo, ConAFIPFonSolRedCont, ConAFIPRenateaApo, ConAFIPRenateaCont, ConAFIPAsigFamCont, ConAFIPFonNacEmpCont, ConAFIPLeyRieTrabCont, ConAFIPRegDifApo, ConAFIPRegEspApo, ConAfipEstado, ConAFIPTipo, ConAfipSubT1, ConAfipSubT2, ConAFIPLiquidado, CliCod FROM ConceptoAFIP WHERE CliCod = ? AND ConCodPropio = ?  FOR UPDATE OF ConceptoAFIP NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B3", "SELECT ConAfipDesc, ConCodPropio, ConAFIPConcepto, ConAFIPMarcaRep, ConAFIPSIPAApo, ConAFIPSIPACont, ConAFIPINSSJyPApo, ConAFIPINSSJyPCont, ConAFIPObraSocApo, ConAFIPObraSocCont, ConAFIPFonSolRedApo, ConAFIPFonSolRedCont, ConAFIPRenateaApo, ConAFIPRenateaCont, ConAFIPAsigFamCont, ConAFIPFonNacEmpCont, ConAFIPLeyRieTrabCont, ConAFIPRegDifApo, ConAFIPRegEspApo, ConAfipEstado, ConAFIPTipo, ConAfipSubT1, ConAfipSubT2, ConAFIPLiquidado, CliCod FROM ConceptoAFIP WHERE CliCod = ? AND ConCodPropio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B4", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B5", "SELECT TM1.ConAfipDesc, TM1.ConCodPropio, TM1.ConAFIPConcepto, TM1.ConAFIPMarcaRep, TM1.ConAFIPSIPAApo, TM1.ConAFIPSIPACont, TM1.ConAFIPINSSJyPApo, TM1.ConAFIPINSSJyPCont, TM1.ConAFIPObraSocApo, TM1.ConAFIPObraSocCont, TM1.ConAFIPFonSolRedApo, TM1.ConAFIPFonSolRedCont, TM1.ConAFIPRenateaApo, TM1.ConAFIPRenateaCont, TM1.ConAFIPAsigFamCont, TM1.ConAFIPFonNacEmpCont, TM1.ConAFIPLeyRieTrabCont, TM1.ConAFIPRegDifApo, TM1.ConAFIPRegEspApo, TM1.ConAfipEstado, TM1.ConAFIPTipo, TM1.ConAfipSubT1, TM1.ConAfipSubT2, TM1.ConAFIPLiquidado, TM1.CliCod FROM ConceptoAFIP TM1 WHERE TM1.CliCod = ? and TM1.ConCodPropio = ( ?) ORDER BY TM1.CliCod, TM1.ConCodPropio ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B6", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B7", "SELECT CliCod, ConCodPropio FROM ConceptoAFIP WHERE CliCod = ? AND ConCodPropio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B8", "SELECT CliCod, ConCodPropio FROM ConceptoAFIP WHERE ( CliCod > ? or CliCod = ? and ConCodPropio > ( ?)) ORDER BY CliCod, ConCodPropio  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000B9", "SELECT CliCod, ConCodPropio FROM ConceptoAFIP WHERE ( CliCod < ? or CliCod = ? and ConCodPropio < ( ?)) ORDER BY CliCod DESC, ConCodPropio DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000B10", "SAVEPOINT gxupdate;INSERT INTO ConceptoAFIP(ConAfipDesc, ConCodPropio, ConAFIPConcepto, ConAFIPMarcaRep, ConAFIPSIPAApo, ConAFIPSIPACont, ConAFIPINSSJyPApo, ConAFIPINSSJyPCont, ConAFIPObraSocApo, ConAFIPObraSocCont, ConAFIPFonSolRedApo, ConAFIPFonSolRedCont, ConAFIPRenateaApo, ConAFIPRenateaCont, ConAFIPAsigFamCont, ConAFIPFonNacEmpCont, ConAFIPLeyRieTrabCont, ConAFIPRegDifApo, ConAFIPRegEspApo, ConAfipEstado, ConAFIPTipo, ConAfipSubT1, ConAfipSubT2, ConAFIPLiquidado, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000B11", "SAVEPOINT gxupdate;UPDATE ConceptoAFIP SET ConAfipDesc=?, ConAFIPConcepto=?, ConAFIPMarcaRep=?, ConAFIPSIPAApo=?, ConAFIPSIPACont=?, ConAFIPINSSJyPApo=?, ConAFIPINSSJyPCont=?, ConAFIPObraSocApo=?, ConAFIPObraSocCont=?, ConAFIPFonSolRedApo=?, ConAFIPFonSolRedCont=?, ConAFIPRenateaApo=?, ConAFIPRenateaCont=?, ConAFIPAsigFamCont=?, ConAFIPFonNacEmpCont=?, ConAFIPLeyRieTrabCont=?, ConAFIPRegDifApo=?, ConAFIPRegEspApo=?, ConAfipEstado=?, ConAFIPTipo=?, ConAfipSubT1=?, ConAfipSubT2=?, ConAFIPLiquidado=?  WHERE CliCod = ? AND ConCodPropio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000B12", "SAVEPOINT gxupdate;DELETE FROM ConceptoAFIP  WHERE CliCod = ? AND ConCodPropio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000B13", "SELECT CliCod, ConCodPropio FROM ConceptoAFIP ORDER BY CliCod, ConCodPropio ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000B14", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getString(5, 1);
               ((String[]) buf[6])[0] = rslt.getString(6, 1);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getString(8, 1);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((String[]) buf[10])[0] = rslt.getString(10, 1);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getString(13, 1);
               ((String[]) buf[14])[0] = rslt.getString(14, 1);
               ((String[]) buf[15])[0] = rslt.getString(15, 1);
               ((String[]) buf[16])[0] = rslt.getString(16, 1);
               ((String[]) buf[17])[0] = rslt.getString(17, 1);
               ((String[]) buf[18])[0] = rslt.getString(18, 1);
               ((String[]) buf[19])[0] = rslt.getString(19, 1);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((String[]) buf[21])[0] = rslt.getString(21, 20);
               ((String[]) buf[22])[0] = rslt.getString(22, 20);
               ((String[]) buf[23])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(24);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getString(5, 1);
               ((String[]) buf[6])[0] = rslt.getString(6, 1);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getString(8, 1);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((String[]) buf[10])[0] = rslt.getString(10, 1);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getString(13, 1);
               ((String[]) buf[14])[0] = rslt.getString(14, 1);
               ((String[]) buf[15])[0] = rslt.getString(15, 1);
               ((String[]) buf[16])[0] = rslt.getString(16, 1);
               ((String[]) buf[17])[0] = rslt.getString(17, 1);
               ((String[]) buf[18])[0] = rslt.getString(18, 1);
               ((String[]) buf[19])[0] = rslt.getString(19, 1);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((String[]) buf[21])[0] = rslt.getString(21, 20);
               ((String[]) buf[22])[0] = rslt.getString(22, 20);
               ((String[]) buf[23])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(24);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getString(5, 1);
               ((String[]) buf[6])[0] = rslt.getString(6, 1);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getString(8, 1);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((String[]) buf[10])[0] = rslt.getString(10, 1);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getString(13, 1);
               ((String[]) buf[14])[0] = rslt.getString(14, 1);
               ((String[]) buf[15])[0] = rslt.getString(15, 1);
               ((String[]) buf[16])[0] = rslt.getString(16, 1);
               ((String[]) buf[17])[0] = rslt.getString(17, 1);
               ((String[]) buf[18])[0] = rslt.getString(18, 1);
               ((String[]) buf[19])[0] = rslt.getString(19, 1);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((String[]) buf[21])[0] = rslt.getString(21, 20);
               ((String[]) buf[22])[0] = rslt.getString(22, 20);
               ((String[]) buf[23])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(24);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 20);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 6);
               }
               stmt.setString(4, (String)parms[4], 1);
               stmt.setString(5, (String)parms[5], 1);
               stmt.setString(6, (String)parms[6], 1);
               stmt.setString(7, (String)parms[7], 1);
               stmt.setString(8, (String)parms[8], 1);
               stmt.setString(9, (String)parms[9], 1);
               stmt.setString(10, (String)parms[10], 1);
               stmt.setString(11, (String)parms[11], 1);
               stmt.setString(12, (String)parms[12], 1);
               stmt.setString(13, (String)parms[13], 1);
               stmt.setString(14, (String)parms[14], 1);
               stmt.setString(15, (String)parms[15], 1);
               stmt.setString(16, (String)parms[16], 1);
               stmt.setString(17, (String)parms[17], 1);
               stmt.setString(18, (String)parms[18], 1);
               stmt.setString(19, (String)parms[19], 1);
               stmt.setString(20, (String)parms[20], 20);
               stmt.setString(21, (String)parms[21], 20);
               stmt.setString(22, (String)parms[22], 20);
               stmt.setString(23, (String)parms[23], 20);
               stmt.setBoolean(24, ((Boolean) parms[24]).booleanValue());
               stmt.setInt(25, ((Number) parms[25]).intValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 6);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setString(4, (String)parms[4], 1);
               stmt.setString(5, (String)parms[5], 1);
               stmt.setString(6, (String)parms[6], 1);
               stmt.setString(7, (String)parms[7], 1);
               stmt.setString(8, (String)parms[8], 1);
               stmt.setString(9, (String)parms[9], 1);
               stmt.setString(10, (String)parms[10], 1);
               stmt.setString(11, (String)parms[11], 1);
               stmt.setString(12, (String)parms[12], 1);
               stmt.setString(13, (String)parms[13], 1);
               stmt.setString(14, (String)parms[14], 1);
               stmt.setString(15, (String)parms[15], 1);
               stmt.setString(16, (String)parms[16], 1);
               stmt.setString(17, (String)parms[17], 1);
               stmt.setString(18, (String)parms[18], 1);
               stmt.setString(19, (String)parms[19], 20);
               stmt.setString(20, (String)parms[20], 20);
               stmt.setString(21, (String)parms[21], 20);
               stmt.setString(22, (String)parms[22], 20);
               stmt.setBoolean(23, ((Boolean) parms[23]).booleanValue());
               stmt.setInt(24, ((Number) parms[24]).intValue());
               stmt.setString(25, (String)parms[25], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

