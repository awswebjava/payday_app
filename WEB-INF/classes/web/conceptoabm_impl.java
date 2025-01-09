package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptoabm_impl extends GXWebComponent
{
   public conceptoabm_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptoabm_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoabm_impl.class ));
   }

   public conceptoabm_impl( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
      cmbavConcepto_tipoconcod = new HTMLChoice();
      cmbavConcepto_subtipoconcod1 = new HTMLChoice();
      cmbavConcepto_subtipoconcod2 = new HTMLChoice();
      dynavConcepto_conrelsec = new HTMLChoice();
      chkavConcepto_conpuenov = UIFactory.getCheckbox(this);
      chkavConcepto_convariable = UIFactory.getCheckbox(this);
      dynavConcepto_apliigg = new HTMLChoice();
      chkavConcepto_conhabilitado = UIFactory.getCheckbox(this);
      cmbavConcepto_convigencia = new HTMLChoice();
      cmbavConcepto_concondicion = new HTMLChoice();
      chkavConcepto_conrecalcular = UIFactory.getCheckbox(this);
      chkavConcepto_conmostrarpos = UIFactory.getCheckbox(this);
      chkavConcepto_conerrorsicero = UIFactory.getCheckbox(this);
      cmbavConcepto_conadeldescu = new HTMLChoice();
      cmbavConcepto_consacdeven = new HTMLChoice();
      cmbavConcepto_conbaselic = new HTMLChoice();
      cmbavConcepto_conbaselicprom = new HTMLChoice();
      cmbavConcepto_conbasefer = new HTMLChoice();
      cmbavConcepto_conbaseferprom = new HTMLChoice();
      cmbavConcepto_conbasehorext = new HTMLChoice();
      cmbavConcepto_conbasehorextprom = new HTMLChoice();
      cmbavConcepto_conbasepres = new HTMLChoice();
      cmbavConcepto_conbaseant = new HTMLChoice();
      cmbavConcepto_conbaseosdif = new HTMLChoice();
      cmbavConcepto_conbaseaus = new HTMLChoice();
      cmbavConcepto_conbaseausprom = new HTMLChoice();
      dynavConcepto_conceptoconvecodigo = new HTMLChoice();
      dynavConcepto_concuendebe = new HTMLChoice();
      dynavConcepto_concuenhaber = new HTMLChoice();
      dynavConcepto_tipoliquidacion__tliqcod = new HTMLChoice();
      cmbavConcepto_tipoliquidacion__contltipegr = new HTMLChoice();
      dynavConcepto_motivosegreso__megcodigo = new HTMLChoice();
      cmbavConcepto_motivosegreso__megpreatipo = new HTMLChoice();
      cmbavConcepto_motivosegreso__conmegdura = new HTMLChoice();
      cmbavConcepto_consipaapo = new HTMLChoice();
      cmbavConcepto_coninssjypapo = new HTMLChoice();
      cmbavConcepto_conobrasocapo = new HTMLChoice();
      cmbavConcepto_confonsolredapo = new HTMLChoice();
      cmbavConcepto_conrenateaapo = new HTMLChoice();
      cmbavConcepto_conregdifapo = new HTMLChoice();
      cmbavConcepto_conregespapo = new HTMLChoice();
      cmbavConcepto_consipacont = new HTMLChoice();
      cmbavConcepto_coninssjypcont = new HTMLChoice();
      cmbavConcepto_conobrasoccont = new HTMLChoice();
      cmbavConcepto_confonsolredcont = new HTMLChoice();
      cmbavConcepto_conrenateacont = new HTMLChoice();
      cmbavConcepto_conasigfamcont = new HTMLChoice();
      cmbavConcepto_confonnacempcont = new HTMLChoice();
      cmbavConcepto_conleyrietrabcont = new HTMLChoice();
      chkavConcepto_consegunpla = UIFactory.getCheckbox(this);
      cmbavConcepto_conprereq = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
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
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               AV12TrnMode = httpContext.GetPar( "TrnMode") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12TrnMode", AV12TrnMode);
               AV16CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliCod), 6, 0));
               AV17ConCodigo = httpContext.GetPar( "ConCodigo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17ConCodigo", AV17ConCodigo);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV12TrnMode,Integer.valueOf(AV16CliCod),AV17ConCodigo});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONCEPTO_MOTIVOSEGRESO__MEGCODIGO") == 0 )
            {
               AV16CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliCod), 6, 0));
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvconcepto_motivosegreso__megcodigoAJ3( AV16CliCod) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONCEPTO_CONRELSEC") == 0 )
            {
               AV16CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliCod), 6, 0));
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvconcepto_conrelsecAJ2( AV16CliCod) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONCEPTO_APLIIGG") == 0 )
            {
               AV16CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliCod), 6, 0));
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvconcepto_apliiggAJ2( AV16CliCod) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONCEPTO_CONCEPTOCONVECODIGO") == 0 )
            {
               AV16CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliCod), 6, 0));
               AV27PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27PaiCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPAICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV27PaiCod), "ZZZ9")));
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvconcepto_conceptoconvecodigoAJ2( AV16CliCod, AV27PaiCod) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONCEPTO_CONCUENDEBE") == 0 )
            {
               AV16CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliCod), 6, 0));
               AV32EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV32EmpCod), "ZZZ9")));
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvconcepto_concuendebeAJ2( AV16CliCod, AV32EmpCod) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONCEPTO_CONCUENHABER") == 0 )
            {
               AV16CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliCod), 6, 0));
               AV32EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV32EmpCod), "ZZZ9")));
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvconcepto_concuenhaberAJ2( AV16CliCod, AV32EmpCod) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONCEPTO_TIPOLIQUIDACION__TLIQCOD") == 0 )
            {
               AV16CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliCod), 6, 0));
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvconcepto_tipoliquidacion__tliqcodAJ2( AV16CliCod) ;
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
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_tipoliquidacion") == 0 )
            {
               gxnrgridlevel_tipoliquidacion_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridlevel_tipoliquidacion") == 0 )
            {
               gxgrgridlevel_tipoliquidacion_refresh_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_motivos") == 0 )
            {
               gxnrgridlevel_motivos_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridlevel_motivos") == 0 )
            {
               gxgrgridlevel_motivos_refresh_invoke( ) ;
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
               AV12TrnMode = gxfirstwebparm ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12TrnMode", AV12TrnMode);
               if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
               {
                  AV16CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliCod), 6, 0));
                  AV17ConCodigo = httpContext.GetPar( "ConCodigo") ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17ConCodigo", AV17ConCodigo);
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
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void gxnrgridlevel_tipoliquidacion_newrow_invoke( )
   {
      nRC_GXsfl_247 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_247"))) ;
      nGXsfl_247_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_247_idx"))) ;
      sGXsfl_247_idx = httpContext.GetPar( "sGXsfl_247_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_tipoliquidacion_newrow( ) ;
      /* End function gxnrGridlevel_tipoliquidacion_newrow_invoke */
   }

   public void gxgrgridlevel_tipoliquidacion_refresh_invoke( )
   {
      subGridlevel_tipoliquidacion_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_tipoliquidacion_Rows"))) ;
      subGridlevel_motivos_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_motivos_Rows"))) ;
      AV12TrnMode = httpContext.GetPar( "TrnMode") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      AV26permiteModificacion = GXutil.strtobool( httpContext.GetPar( "permiteModificacion")) ;
      AV151Pgmname = httpContext.GetPar( "Pgmname") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV7Concepto);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV22ConceptoTipoLiquidacionDeleted);
      AV28egresoTLiqCod = httpContext.GetPar( "egresoTLiqCod") ;
      AV16CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV7Concepto.setgxTv_SdtConcepto_Conpuenov( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV7Concepto.setgxTv_SdtConcepto_Convariable( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV7Concepto.setgxTv_SdtConcepto_Conhabilitado( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV7Concepto.setgxTv_SdtConcepto_Conrecalcular( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV7Concepto.setgxTv_SdtConcepto_Conmostrarpos( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV7Concepto.setgxTv_SdtConcepto_Conerrorsicero( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV7Concepto.setgxTv_SdtConcepto_Consegunpla( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV25esSistemaConceptosDefault = GXutil.strtobool( httpContext.GetPar( "esSistemaConceptosDefault")) ;
      AV67ClienteConveniador = GXutil.strtobool( httpContext.GetPar( "ClienteConveniador")) ;
      AV30viejoConRecalcular = GXutil.strtobool( httpContext.GetPar( "viejoConRecalcular")) ;
      AV60viejoAplIIGG = (short)(GXutil.lval( httpContext.GetPar( "viejoAplIIGG"))) ;
      AV39ConAFIPSIPAApo = httpContext.GetPar( "ConAFIPSIPAApo") ;
      AV27PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      AV32EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridlevel_tipoliquidacion_refresh_invoke */
   }

   public void gxnrgridlevel_motivos_newrow_invoke( )
   {
      nRC_GXsfl_262 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_262"))) ;
      nGXsfl_262_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_262_idx"))) ;
      sGXsfl_262_idx = httpContext.GetPar( "sGXsfl_262_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_motivos_newrow( ) ;
      /* End function gxnrGridlevel_motivos_newrow_invoke */
   }

   public void gxgrgridlevel_motivos_refresh_invoke( )
   {
      subGridlevel_tipoliquidacion_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_tipoliquidacion_Rows"))) ;
      subGridlevel_motivos_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_motivos_Rows"))) ;
      AV12TrnMode = httpContext.GetPar( "TrnMode") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      AV26permiteModificacion = GXutil.strtobool( httpContext.GetPar( "permiteModificacion")) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV7Concepto);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV63ConceptoMotivosEgresoDeleted);
      AV16CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV7Concepto.setgxTv_SdtConcepto_Conpuenov( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV7Concepto.setgxTv_SdtConcepto_Convariable( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV7Concepto.setgxTv_SdtConcepto_Conhabilitado( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV7Concepto.setgxTv_SdtConcepto_Conrecalcular( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV7Concepto.setgxTv_SdtConcepto_Conmostrarpos( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV7Concepto.setgxTv_SdtConcepto_Conerrorsicero( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV7Concepto.setgxTv_SdtConcepto_Consegunpla( GXutil.strtobool( httpContext.GetNextPar( )) );
      AV151Pgmname = httpContext.GetPar( "Pgmname") ;
      AV28egresoTLiqCod = httpContext.GetPar( "egresoTLiqCod") ;
      AV25esSistemaConceptosDefault = GXutil.strtobool( httpContext.GetPar( "esSistemaConceptosDefault")) ;
      AV67ClienteConveniador = GXutil.strtobool( httpContext.GetPar( "ClienteConveniador")) ;
      AV30viejoConRecalcular = GXutil.strtobool( httpContext.GetPar( "viejoConRecalcular")) ;
      AV60viejoAplIIGG = (short)(GXutil.lval( httpContext.GetPar( "viejoAplIIGG"))) ;
      AV39ConAFIPSIPAApo = httpContext.GetPar( "ConAFIPSIPAApo") ;
      AV27PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      AV32EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridlevel_motivos_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV7Concepto, AV63ConceptoMotivosEgresoDeleted, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV151Pgmname, AV28egresoTLiqCod, AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridlevel_motivos_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paAJ2( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            wsAJ2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  weAJ2( ) ;
               }
            }
         }
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
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto", "")) ;
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
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conceptoabm", new String[] {GXutil.URLEncode(GXutil.rtrim(AV12TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV16CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV17ConCodigo))}, new String[] {"TrnMode","CliCod","ConCodigo"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMODE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPERMITEMODIFICACION", getSecureSignedToken( sPrefix, AV26permiteModificacion));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV151Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEGRESOTLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV28egresoTLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPAICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV27PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vESSISTEMACONCEPTOSDEFAULT", getSecureSignedToken( sPrefix, AV25esSistemaConceptosDefault));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLIENTECONVENIADOR", getSecureSignedToken( sPrefix, AV67ClienteConveniador));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVIEJOCONRECALCULAR", getSecureSignedToken( sPrefix, AV30viejoConRecalcular));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVIEJOAPLIIGG", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV60viejoAplIIGG), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV32EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCONAFIPSIPAAPO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV39ConAFIPSIPAApo, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"Concepto", AV7Concepto);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"Concepto", AV7Concepto);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_247", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_247, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_262", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_262, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV12TrnMode", GXutil.rtrim( wcpOAV12TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV16CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV16CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV17ConCodigo", GXutil.rtrim( wcpOAV17ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTRNMODE", GXutil.rtrim( AV12TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMODE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vPERMITEMODIFICACION", AV26permiteModificacion);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPERMITEMODIFICACION", getSecureSignedToken( sPrefix, AV26permiteModificacion));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCONCEPTOMOTIVOSEGRESODELETED", AV63ConceptoMotivosEgresoDeleted);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCONCEPTOMOTIVOSEGRESODELETED", AV63ConceptoMotivosEgresoDeleted);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV151Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV151Pgmname, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCONCEPTOTIPOLIQUIDACIONDELETED", AV22ConceptoTipoLiquidacionDeleted);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCONCEPTOTIPOLIQUIDACIONDELETED", AV22ConceptoTipoLiquidacionDeleted);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEGRESOTLIQCOD", GXutil.rtrim( AV28egresoTLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEGRESOTLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV28egresoTLiqCod, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vCHECKREQUIREDFIELDSRESULT", AV14CheckRequiredFieldsResult);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vESSISTEMACONCEPTOSDEFAULT", AV25esSistemaConceptosDefault);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vESSISTEMACONCEPTOSDEFAULT", getSecureSignedToken( sPrefix, AV25esSistemaConceptosDefault));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vCLIENTECONVENIADOR", AV67ClienteConveniador);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLIENTECONVENIADOR", getSecureSignedToken( sPrefix, AV67ClienteConveniador));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vVIEJOCONRECALCULAR", AV30viejoConRecalcular);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVIEJOCONRECALCULAR", getSecureSignedToken( sPrefix, AV30viejoConRecalcular));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vVIEJOAPLIIGG", GXutil.ltrim( localUtil.ntoc( AV60viejoAplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVIEJOAPLIIGG", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV60viejoAplIIGG), "ZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vMESSAGES", AV11Messages);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vMESSAGES", AV11Messages);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCONAFIPSIPAAPO", GXutil.rtrim( AV39ConAFIPSIPAApo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCONAFIPSIPAAPO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV39ConAFIPSIPAApo, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vVIENEDECLICK", AV68vieneDeClick);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCONCODIGO", GXutil.rtrim( AV17ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_MOTIVOS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_MOTIVOS_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_TIPOLIQUIDACION_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_MOTIVOS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_MOTIVOS_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV16CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPAICOD", GXutil.ltrim( localUtil.ntoc( AV27PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPAICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV27PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV32EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV32EmpCod), "ZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCONCEPTO", AV7Concepto);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCONCEPTO", AV7Concepto);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_MOTIVOS_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_motivos_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Width", GXutil.rtrim( Dvpanel_unnamedtable4_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable4_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable4_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Cls", GXutil.rtrim( Dvpanel_unnamedtable4_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Title", GXutil.rtrim( Dvpanel_unnamedtable4_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable4_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable4_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable4_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable4_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable4_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Width", GXutil.rtrim( Dvpanel_unnamedtable3_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable3_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable3_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Cls", GXutil.rtrim( Dvpanel_unnamedtable3_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Title", GXutil.rtrim( Dvpanel_unnamedtable3_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable3_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable3_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable3_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable3_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable3_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PANELAPOCONT3_Width", GXutil.rtrim( Dvpanel_panelapocont3_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PANELAPOCONT3_Autowidth", GXutil.booltostr( Dvpanel_panelapocont3_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PANELAPOCONT3_Autoheight", GXutil.booltostr( Dvpanel_panelapocont3_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PANELAPOCONT3_Cls", GXutil.rtrim( Dvpanel_panelapocont3_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PANELAPOCONT3_Title", GXutil.rtrim( Dvpanel_panelapocont3_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PANELAPOCONT3_Collapsible", GXutil.booltostr( Dvpanel_panelapocont3_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PANELAPOCONT3_Collapsed", GXutil.booltostr( Dvpanel_panelapocont3_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PANELAPOCONT3_Showcollapseicon", GXutil.booltostr( Dvpanel_panelapocont3_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PANELAPOCONT3_Iconposition", GXutil.rtrim( Dvpanel_panelapocont3_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PANELAPOCONT3_Autoscroll", GXutil.booltostr( Dvpanel_panelapocont3_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GXUITABSPANEL_TABS1_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabs1_Pagecount, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GXUITABSPANEL_TABS1_Class", GXutil.rtrim( Gxuitabspanel_tabs1_Class));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GXUITABSPANEL_TABS1_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabs1_Historymanagement));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_MOTIVOS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridlevel_motivos_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridlevel_tipoliquidacion_empowerer_Gridinternalname));
   }

   public void renderHtmlCloseFormAJ2( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
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
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "ConceptoABM" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Concepto", "") ;
   }

   public void wbAJ0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.conceptoabm");
            httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
            httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
            httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
            httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
            httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
         wb_table1_9_AJ2( true) ;
      }
      else
      {
         wb_table1_9_AJ2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_AJ2e( boolean wbgen )
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
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 385,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavConcepto_consegunpla.getInternalname(), GXutil.booltostr( AV7Concepto.getgxTv_SdtConcepto_Consegunpla()), "", "", chkavConcepto_consegunpla.getVisible(), 1, "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(385, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,385);\"");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 386,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conprereq, cmbavConcepto_conprereq.getInternalname(), GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Conprereq()), 1, cmbavConcepto_conprereq.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", cmbavConcepto_conprereq.getVisible(), cmbavConcepto_conprereq.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,386);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conprereq.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Conprereq()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conprereq.getInternalname(), "Values", cmbavConcepto_conprereq.ToJavascriptSource(), true);
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 387,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavConcepto_conrangocant_Internalname, AV7Concepto.getgxTv_SdtConcepto_Conrangocant(), "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,387);\"", (short)(0), edtavConcepto_conrangocant_Visible, edtavConcepto_conrangocant_Enabled, 1, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ConceptoABM.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 388,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavConcepto_clicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV7Concepto.getgxTv_SdtConcepto_Clicod(), (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7Concepto.getgxTv_SdtConcepto_Clicod()), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,388);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConcepto_clicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavConcepto_clicod_Visible, 1, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoABM.htm");
         /* User Defined Control */
         ucGridlevel_motivos_empowerer.render(context, "wwp.gridempowerer", Gridlevel_motivos_empowerer_Internalname, sPrefix+"GRIDLEVEL_MOTIVOS_EMPOWERERContainer");
         /* User Defined Control */
         ucGridlevel_tipoliquidacion_empowerer.render(context, "wwp.gridempowerer", Gridlevel_tipoliquidacion_empowerer_Internalname, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 247 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Gridlevel_tipoliquidacionContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Gridlevel_tipoliquidacionContainer.AddObjectProperty("GRIDLEVEL_TIPOLIQUIDACION_nEOF", GRIDLEVEL_TIPOLIQUIDACION_nEOF);
               Gridlevel_tipoliquidacionContainer.AddObjectProperty("GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage", GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage);
               AV122GXV38 = nGXsfl_247_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"Gridlevel_tipoliquidacionContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Gridlevel_tipoliquidacion", Gridlevel_tipoliquidacionContainer, subGridlevel_tipoliquidacion_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gridlevel_tipoliquidacionContainerData", Gridlevel_tipoliquidacionContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gridlevel_tipoliquidacionContainerData"+"V", Gridlevel_tipoliquidacionContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"Gridlevel_tipoliquidacionContainerData"+"V"+"\" value='"+Gridlevel_tipoliquidacionContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 262 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Gridlevel_motivosContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Gridlevel_motivosContainer.AddObjectProperty("GRIDLEVEL_MOTIVOS_nEOF", GRIDLEVEL_MOTIVOS_nEOF);
               Gridlevel_motivosContainer.AddObjectProperty("GRIDLEVEL_MOTIVOS_nFirstRecordOnPage", GRIDLEVEL_MOTIVOS_nFirstRecordOnPage);
               AV125GXV41 = nGXsfl_262_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"Gridlevel_motivosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Gridlevel_motivos", Gridlevel_motivosContainer, subGridlevel_motivos_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gridlevel_motivosContainerData", Gridlevel_motivosContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gridlevel_motivosContainerData"+"V", Gridlevel_motivosContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"Gridlevel_motivosContainerData"+"V"+"\" value='"+Gridlevel_motivosContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startAJ2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
            }
            Form.getMeta().addItem("description", httpContext.getMessage( "Concepto", ""), (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strupAJ0( ) ;
         }
      }
   }

   public void wsAJ2( )
   {
      startAJ2( ) ;
      evtAJ2( ) ;
   }

   public void evtAJ2( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
               if ( GXutil.len( sEvt) > 0 )
               {
                  sEvtType = GXutil.left( sEvt, 1) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoAddGridLineGridLevel_MotivosEgreso' */
                                 e11AJ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOADDGRIDLINEGRIDLEVEL_MOTIVOS'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoAddGridLineGridLevel_Motivos' */
                                 e12AJ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoAddGridLineGridLevel_TipoLiquidacion' */
                                 e13AJ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                       /* Execute user event: Enter */
                                       e14AJ2 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "CONCEPTO_CONVARIABLE.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e15AJ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "CONCEPTO_TIPOCONCOD.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e16AJ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "CONCEPTO_SUBTIPOCONCOD1.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e17AJ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "CONCEPTO_SUBTIPOCONCOD2.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e18AJ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "CONCEPTO_CONCODAFIP.ISVALID") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e19AJ2 ();
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavDeletegridlinegridlevel_tipoliquidacion_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDLEVEL_TIPOLIQUIDACIONPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           sEvt = httpContext.cgiGet( sPrefix+"GRIDLEVEL_TIPOLIQUIDACIONPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridlevel_tipoliquidacion_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridlevel_tipoliquidacion_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridlevel_tipoliquidacion_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridlevel_tipoliquidacion_lastpage( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDLEVEL_MOTIVOSPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           sEvt = httpContext.cgiGet( sPrefix+"GRIDLEVEL_MOTIVOSPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridlevel_motivos_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridlevel_motivos_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridlevel_motivos_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridlevel_motivos_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 30), "GRIDLEVEL_TIPOLIQUIDACION.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 46), "VDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 33), "GRIDLEVEL_TIPOLIQUIDACION.REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 39), "CONCEPTO_TIPOLIQUIDACION__TLIQCOD.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 46), "VDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 39), "CONCEPTO_TIPOLIQUIDACION__TLIQCOD.CLICK") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           nGXsfl_247_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_247_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2472( ) ;
                           AV122GXV38 = (int)(nGXsfl_247_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
                           if ( ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) && ( AV122GXV38 > 0 ) )
                           {
                              AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
                              AV9DeleteGridLineGridLevel_TipoLiquidacion = httpContext.cgiGet( edtavDeletegridlinegridlevel_tipoliquidacion_Internalname) ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDeletegridlinegridlevel_tipoliquidacion_Internalname, AV9DeleteGridLineGridLevel_TipoLiquidacion);
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDeletegridlinegridlevel_tipoliquidacion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e20AJ2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDeletegridlinegridlevel_tipoliquidacion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e21AJ2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDLEVEL_TIPOLIQUIDACION.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDeletegridlinegridlevel_tipoliquidacion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e22AJ2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "VDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDeletegridlinegridlevel_tipoliquidacion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e23AJ2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDLEVEL_TIPOLIQUIDACION.REFRESH") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDeletegridlinegridlevel_tipoliquidacion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e24AJ2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "CONCEPTO_TIPOLIQUIDACION__TLIQCOD.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDeletegridlinegridlevel_tipoliquidacion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e25AJ2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strupAJ0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDeletegridlinegridlevel_tipoliquidacion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                    }
                                 }
                              }
                           }
                           else
                           {
                           }
                        }
                        else if ( ( GXutil.strcmp(GXutil.left( sEvt, 22), "GRIDLEVEL_MOTIVOS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 38), "VDELETEGRIDLINEGRIDLEVEL_MOTIVOS.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 38), "VDELETEGRIDLINEGRIDLEVEL_MOTIVOS.CLICK") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupAJ0( ) ;
                           }
                           nGXsfl_262_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_262_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_262_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2623( ) ;
                           AV125GXV41 = (int)(nGXsfl_262_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
                           if ( ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) && ( AV125GXV41 > 0 ) )
                           {
                              AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
                              AV61DeleteGridLineGridLevel_Motivos = httpContext.cgiGet( edtavDeletegridlinegridlevel_motivos_Internalname) ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDeletegridlinegridlevel_motivos_Internalname, AV61DeleteGridLineGridLevel_Motivos);
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDLEVEL_MOTIVOS.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDeletegridlinegridlevel_motivos_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e26AJ3 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "VDELETEGRIDLINEGRIDLEVEL_MOTIVOS.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDeletegridlinegridlevel_motivos_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e27AJ2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strupAJ0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDeletegridlinegridlevel_tipoliquidacion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                    }
                                 }
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

   public void weAJ2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormAJ2( ) ;
         }
      }
   }

   public void paAJ2( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = cmbavConcepto_tipoconcod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvconcepto_motivosegreso__megcodigoAJ3( int AV16CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvconcepto_motivosegreso__megcodigo_dataAJ3( AV16CliCod) ;
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

   public void gxvconcepto_motivosegreso__megcodigo_htmlAJ3( int AV16CliCod )
   {
      String gxdynajaxvalue;
      gxdlvconcepto_motivosegreso__megcodigo_dataAJ3( AV16CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavConcepto_motivosegreso__megcodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavConcepto_motivosegreso__megcodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavConcepto_motivosegreso__megcodigo.getItemCount() > 0 )
      {
         if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) && (GXutil.strcmp("", ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Megcodigo())==0) )
         {
            ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).setgxTv_SdtConcepto_MotivosEgreso_Megcodigo( dynavConcepto_motivosegreso__megcodigo.getValidValue(((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Megcodigo()) );
         }
      }
   }

   protected void gxdlvconcepto_motivosegreso__megcodigo_dataAJ3( int AV16CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00AJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV16CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00AJ2_A11MegCodigo[0]));
         gxdynajaxctrldescr.add(H00AJ2_A300MegDescrip[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvconcepto_conrelsecAJ2( int AV16CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvconcepto_conrelsec_dataAJ2( AV16CliCod) ;
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

   public void gxvconcepto_conrelsec_htmlAJ2( int AV16CliCod )
   {
      int gxdynajaxvalue;
      gxdlvconcepto_conrelsec_dataAJ2( AV16CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavConcepto_conrelsec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavConcepto_conrelsec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvconcepto_conrelsec_dataAJ2( int AV16CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00AJ3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV16CliCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00AJ3_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00AJ3_A1880CliReDTChar[0]);
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxdlvconcepto_apliiggAJ2( int AV16CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvconcepto_apliigg_dataAJ2( AV16CliCod) ;
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

   public void gxvconcepto_apliigg_htmlAJ2( int AV16CliCod )
   {
      short gxdynajaxvalue;
      gxdlvconcepto_apliigg_dataAJ2( AV16CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavConcepto_apliigg.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavConcepto_apliigg.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvconcepto_apliigg_dataAJ2( int AV16CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00AJ4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV16CliCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00AJ4_A1112AplIIGG[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00AJ4_A1113AplIIGGNom[0]);
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void gxdlvconcepto_conceptoconvecodigoAJ2( int AV16CliCod ,
                                                     short AV27PaiCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvconcepto_conceptoconvecodigo_dataAJ2( AV16CliCod, AV27PaiCod) ;
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

   public void gxvconcepto_conceptoconvecodigo_htmlAJ2( int AV16CliCod ,
                                                        short AV27PaiCod )
   {
      String gxdynajaxvalue;
      gxdlvconcepto_conceptoconvecodigo_dataAJ2( AV16CliCod, AV27PaiCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavConcepto_conceptoconvecodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavConcepto_conceptoconvecodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvconcepto_conceptoconvecodigo_dataAJ2( int AV16CliCod ,
                                                             short AV27PaiCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00AJ5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV16CliCod), Short.valueOf(AV27PaiCod)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00AJ5_A1565CliConvenio[0]));
         gxdynajaxctrldescr.add(H00AJ5_A1567CliConvenioDescrip[0]);
         pr_default.readNext(3);
      }
      pr_default.close(3);
   }

   public void gxdlvconcepto_concuendebeAJ2( int AV16CliCod ,
                                             short AV32EmpCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvconcepto_concuendebe_dataAJ2( AV16CliCod, AV32EmpCod) ;
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

   public void gxvconcepto_concuendebe_htmlAJ2( int AV16CliCod ,
                                                short AV32EmpCod )
   {
      String gxdynajaxvalue;
      gxdlvconcepto_concuendebe_dataAJ2( AV16CliCod, AV32EmpCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavConcepto_concuendebe.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavConcepto_concuendebe.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavConcepto_concuendebe.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Concuendebe( dynavConcepto_concuendebe.getValidValue(AV7Concepto.getgxTv_SdtConcepto_Concuendebe()) );
      }
   }

   protected void gxdlvconcepto_concuendebe_dataAJ2( int AV16CliCod ,
                                                     short AV32EmpCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00AJ6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV16CliCod), Short.valueOf(AV32EmpCod)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00AJ6_A78CuenCodigo[0]));
         gxdynajaxctrldescr.add(H00AJ6_A485CuenDescrip[0]);
         pr_default.readNext(4);
      }
      pr_default.close(4);
   }

   public void gxdlvconcepto_concuenhaberAJ2( int AV16CliCod ,
                                              short AV32EmpCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvconcepto_concuenhaber_dataAJ2( AV16CliCod, AV32EmpCod) ;
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

   public void gxvconcepto_concuenhaber_htmlAJ2( int AV16CliCod ,
                                                 short AV32EmpCod )
   {
      String gxdynajaxvalue;
      gxdlvconcepto_concuenhaber_dataAJ2( AV16CliCod, AV32EmpCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavConcepto_concuenhaber.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavConcepto_concuenhaber.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavConcepto_concuenhaber.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Concuenhaber( dynavConcepto_concuenhaber.getValidValue(AV7Concepto.getgxTv_SdtConcepto_Concuenhaber()) );
      }
   }

   protected void gxdlvconcepto_concuenhaber_dataAJ2( int AV16CliCod ,
                                                      short AV32EmpCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00AJ7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV16CliCod), Short.valueOf(AV32EmpCod)});
      while ( (pr_default.getStatus(5) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00AJ7_A78CuenCodigo[0]));
         gxdynajaxctrldescr.add(H00AJ7_A485CuenDescrip[0]);
         pr_default.readNext(5);
      }
      pr_default.close(5);
   }

   public void gxdlvconcepto_tipoliquidacion__tliqcodAJ2( int AV16CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvconcepto_tipoliquidacion__tliqcod_dataAJ2( AV16CliCod) ;
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

   public void gxvconcepto_tipoliquidacion__tliqcod_htmlAJ2( int AV16CliCod )
   {
      String gxdynajaxvalue;
      gxdlvconcepto_tipoliquidacion__tliqcod_dataAJ2( AV16CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavConcepto_tipoliquidacion__tliqcod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavConcepto_tipoliquidacion__tliqcod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvconcepto_tipoliquidacion__tliqcod_dataAJ2( int AV16CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00AJ8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(AV16CliCod)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00AJ8_A32TLiqCod[0]));
         gxdynajaxctrldescr.add(H00AJ8_A340TliqDesc[0]);
         pr_default.readNext(6);
      }
      pr_default.close(6);
   }

   public void gxnrgridlevel_tipoliquidacion_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2472( ) ;
      while ( nGXsfl_247_idx <= nRC_GXsfl_247 )
      {
         sendrow_2472( ) ;
         nGXsfl_247_idx = ((subGridlevel_tipoliquidacion_Islastpage==1)&&(nGXsfl_247_idx+1>subgridlevel_tipoliquidacion_fnc_recordsperpage( )) ? 1 : nGXsfl_247_idx+1) ;
         sGXsfl_247_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2472( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_tipoliquidacionContainer)) ;
      /* End function gxnrGridlevel_tipoliquidacion_newrow */
   }

   public void gxnrgridlevel_motivos_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2623( ) ;
      while ( nGXsfl_262_idx <= nRC_GXsfl_262 )
      {
         sendrow_2623( ) ;
         nGXsfl_262_idx = ((subGridlevel_motivos_Islastpage==1)&&(nGXsfl_262_idx+1>subgridlevel_motivos_fnc_recordsperpage( )) ? 1 : nGXsfl_262_idx+1) ;
         sGXsfl_262_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_262_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2623( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_motivosContainer)) ;
      /* End function gxnrGridlevel_motivos_newrow */
   }

   public void gxgrgridlevel_tipoliquidacion_refresh( int subGridlevel_tipoliquidacion_Rows ,
                                                      int subGridlevel_motivos_Rows ,
                                                      String AV12TrnMode ,
                                                      String Gx_mode ,
                                                      boolean AV26permiteModificacion ,
                                                      String AV151Pgmname ,
                                                      web.SdtConcepto AV7Concepto ,
                                                      GXSimpleCollection<Short> AV22ConceptoTipoLiquidacionDeleted ,
                                                      String AV28egresoTLiqCod ,
                                                      int AV16CliCod ,
                                                      boolean GXV8 ,
                                                      boolean GXV9 ,
                                                      boolean GXV12 ,
                                                      boolean GXV17 ,
                                                      boolean GXV18 ,
                                                      boolean GXV19 ,
                                                      boolean GXV63 ,
                                                      boolean AV25esSistemaConceptosDefault ,
                                                      boolean AV67ClienteConveniador ,
                                                      boolean AV30viejoConRecalcular ,
                                                      short AV60viejoAplIIGG ,
                                                      String AV39ConAFIPSIPAApo ,
                                                      short AV27PaiCod ,
                                                      short AV32EmpCod ,
                                                      String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e21AJ2 ();
      GRIDLEVEL_TIPOLIQUIDACION_nCurrentRecord = 0 ;
      rfAJ2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridlevel_tipoliquidacion_refresh */
   }

   public void gxgrgridlevel_motivos_refresh( int subGridlevel_tipoliquidacion_Rows ,
                                              int subGridlevel_motivos_Rows ,
                                              String AV12TrnMode ,
                                              String Gx_mode ,
                                              boolean AV26permiteModificacion ,
                                              web.SdtConcepto AV7Concepto ,
                                              GXSimpleCollection<Short> AV63ConceptoMotivosEgresoDeleted ,
                                              int AV16CliCod ,
                                              boolean GXV8 ,
                                              boolean GXV9 ,
                                              boolean GXV12 ,
                                              boolean GXV17 ,
                                              boolean GXV18 ,
                                              boolean GXV19 ,
                                              boolean GXV63 ,
                                              String AV151Pgmname ,
                                              String AV28egresoTLiqCod ,
                                              boolean AV25esSistemaConceptosDefault ,
                                              boolean AV67ClienteConveniador ,
                                              boolean AV30viejoConRecalcular ,
                                              short AV60viejoAplIIGG ,
                                              String AV39ConAFIPSIPAApo ,
                                              short AV27PaiCod ,
                                              short AV32EmpCod ,
                                              String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e21AJ2 ();
      GRIDLEVEL_MOTIVOS_nCurrentRecord = 0 ;
      rfAJ3( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridlevel_motivos_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         gxvconcepto_conrelsec_htmlAJ2( AV16CliCod) ;
         gxvconcepto_apliigg_htmlAJ2( AV16CliCod) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavConcepto_tipoconcod.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Tipoconcod( cmbavConcepto_tipoconcod.getValidValue(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_tipoconcod.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Tipoconcod()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_tipoconcod.getInternalname(), "Values", cmbavConcepto_tipoconcod.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_subtipoconcod1.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Subtipoconcod1( cmbavConcepto_subtipoconcod1.getValidValue(AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod1()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_subtipoconcod1.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod1()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_subtipoconcod1.getInternalname(), "Values", cmbavConcepto_subtipoconcod1.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_subtipoconcod2.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Subtipoconcod2( cmbavConcepto_subtipoconcod2.getValidValue(AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod2()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_subtipoconcod2.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod2()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_subtipoconcod2.getInternalname(), "Values", cmbavConcepto_subtipoconcod2.ToJavascriptSource(), true);
      }
      if ( dynavConcepto_conrelsec.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conrelsec( (int)(GXutil.lval( dynavConcepto_conrelsec.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conrelsec(), 6, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavConcepto_conrelsec.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conrelsec(), 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_conrelsec.getInternalname(), "Values", dynavConcepto_conrelsec.ToJavascriptSource(), true);
      }
      if ( dynavConcepto_apliigg.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Apliigg( (short)(GXutil.lval( dynavConcepto_apliigg.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Apliigg(), 4, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavConcepto_apliigg.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Apliigg(), 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_apliigg.getInternalname(), "Values", dynavConcepto_apliigg.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_convigencia.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Convigencia( (byte)(GXutil.lval( cmbavConcepto_convigencia.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Convigencia(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_convigencia.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Convigencia(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_convigencia.getInternalname(), "Values", cmbavConcepto_convigencia.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_concondicion.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Concondicion( cmbavConcepto_concondicion.getValidValue(AV7Concepto.getgxTv_SdtConcepto_Concondicion()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_concondicion.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Concondicion()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_concondicion.getInternalname(), "Values", cmbavConcepto_concondicion.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conadeldescu.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conadeldescu( (byte)(GXutil.lval( cmbavConcepto_conadeldescu.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conadeldescu(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conadeldescu.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conadeldescu(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conadeldescu.getInternalname(), "Values", cmbavConcepto_conadeldescu.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_consacdeven.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Consacdeven( (byte)(GXutil.lval( cmbavConcepto_consacdeven.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Consacdeven(), 2, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_consacdeven.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Consacdeven(), 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consacdeven.getInternalname(), "Values", cmbavConcepto_consacdeven.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conbaselic.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conbaselic( (byte)(GXutil.lval( cmbavConcepto_conbaselic.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaselic(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conbaselic.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaselic(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaselic.getInternalname(), "Values", cmbavConcepto_conbaselic.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conbaselicprom.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conbaselicprom( (byte)(GXutil.lval( cmbavConcepto_conbaselicprom.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaselicprom(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conbaselicprom.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaselicprom(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaselicprom.getInternalname(), "Values", cmbavConcepto_conbaselicprom.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conbasefer.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conbasefer( (byte)(GXutil.lval( cmbavConcepto_conbasefer.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasefer(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conbasefer.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasefer(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasefer.getInternalname(), "Values", cmbavConcepto_conbasefer.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conbaseferprom.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conbaseferprom( (byte)(GXutil.lval( cmbavConcepto_conbaseferprom.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseferprom(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conbaseferprom.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseferprom(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseferprom.getInternalname(), "Values", cmbavConcepto_conbaseferprom.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conbasehorext.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conbasehorext( (byte)(GXutil.lval( cmbavConcepto_conbasehorext.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasehorext(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conbasehorext.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasehorext(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasehorext.getInternalname(), "Values", cmbavConcepto_conbasehorext.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conbasehorextprom.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conbasehorextprom( (byte)(GXutil.lval( cmbavConcepto_conbasehorextprom.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasehorextprom(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conbasehorextprom.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasehorextprom(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasehorextprom.getInternalname(), "Values", cmbavConcepto_conbasehorextprom.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conbasepres.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conbasepres( (byte)(GXutil.lval( cmbavConcepto_conbasepres.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasepres(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conbasepres.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasepres(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasepres.getInternalname(), "Values", cmbavConcepto_conbasepres.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conbaseant.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conbaseant( (byte)(GXutil.lval( cmbavConcepto_conbaseant.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseant(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conbaseant.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseant(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseant.getInternalname(), "Values", cmbavConcepto_conbaseant.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conbaseosdif.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conbaseosdif( (byte)(GXutil.lval( cmbavConcepto_conbaseosdif.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseosdif(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conbaseosdif.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseosdif(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseosdif.getInternalname(), "Values", cmbavConcepto_conbaseosdif.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conbaseaus.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conbaseaus( (byte)(GXutil.lval( cmbavConcepto_conbaseaus.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseaus(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conbaseaus.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseaus(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseaus.getInternalname(), "Values", cmbavConcepto_conbaseaus.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conbaseausprom.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conbaseausprom( (byte)(GXutil.lval( cmbavConcepto_conbaseausprom.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseausprom(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conbaseausprom.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseausprom(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseausprom.getInternalname(), "Values", cmbavConcepto_conbaseausprom.ToJavascriptSource(), true);
      }
      if ( dynavConcepto_conceptoconvecodigo.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conceptoconvecodigo( dynavConcepto_conceptoconvecodigo.getValidValue(AV7Concepto.getgxTv_SdtConcepto_Conceptoconvecodigo()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavConcepto_conceptoconvecodigo.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Conceptoconvecodigo()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_conceptoconvecodigo.getInternalname(), "Values", dynavConcepto_conceptoconvecodigo.ToJavascriptSource(), true);
      }
      if ( dynavConcepto_concuendebe.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Concuendebe( dynavConcepto_concuendebe.getValidValue(AV7Concepto.getgxTv_SdtConcepto_Concuendebe()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavConcepto_concuendebe.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Concuendebe()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_concuendebe.getInternalname(), "Values", dynavConcepto_concuendebe.ToJavascriptSource(), true);
      }
      if ( dynavConcepto_concuenhaber.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Concuenhaber( dynavConcepto_concuenhaber.getValidValue(AV7Concepto.getgxTv_SdtConcepto_Concuenhaber()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavConcepto_concuenhaber.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Concuenhaber()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_concuenhaber.getInternalname(), "Values", dynavConcepto_concuenhaber.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_consipaapo.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Consipaapo( (byte)(GXutil.lval( cmbavConcepto_consipaapo.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Consipaapo(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_consipaapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Consipaapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consipaapo.getInternalname(), "Values", cmbavConcepto_consipaapo.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_coninssjypapo.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Coninssjypapo( (byte)(GXutil.lval( cmbavConcepto_coninssjypapo.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Coninssjypapo(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_coninssjypapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Coninssjypapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_coninssjypapo.getInternalname(), "Values", cmbavConcepto_coninssjypapo.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conobrasocapo.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conobrasocapo( (byte)(GXutil.lval( cmbavConcepto_conobrasocapo.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conobrasocapo(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conobrasocapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conobrasocapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conobrasocapo.getInternalname(), "Values", cmbavConcepto_conobrasocapo.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_confonsolredapo.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Confonsolredapo( (byte)(GXutil.lval( cmbavConcepto_confonsolredapo.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Confonsolredapo(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_confonsolredapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Confonsolredapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonsolredapo.getInternalname(), "Values", cmbavConcepto_confonsolredapo.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conrenateaapo.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conrenateaapo( (byte)(GXutil.lval( cmbavConcepto_conrenateaapo.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conrenateaapo(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conrenateaapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conrenateaapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conrenateaapo.getInternalname(), "Values", cmbavConcepto_conrenateaapo.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conregdifapo.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conregdifapo( (byte)(GXutil.lval( cmbavConcepto_conregdifapo.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conregdifapo(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conregdifapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conregdifapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conregdifapo.getInternalname(), "Values", cmbavConcepto_conregdifapo.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conregespapo.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conregespapo( (byte)(GXutil.lval( cmbavConcepto_conregespapo.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conregespapo(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conregespapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conregespapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conregespapo.getInternalname(), "Values", cmbavConcepto_conregespapo.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_consipacont.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Consipacont( (byte)(GXutil.lval( cmbavConcepto_consipacont.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Consipacont(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_consipacont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Consipacont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consipacont.getInternalname(), "Values", cmbavConcepto_consipacont.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_coninssjypcont.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Coninssjypcont( (byte)(GXutil.lval( cmbavConcepto_coninssjypcont.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Coninssjypcont(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_coninssjypcont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Coninssjypcont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_coninssjypcont.getInternalname(), "Values", cmbavConcepto_coninssjypcont.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conobrasoccont.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conobrasoccont( (byte)(GXutil.lval( cmbavConcepto_conobrasoccont.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conobrasoccont(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conobrasoccont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conobrasoccont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conobrasoccont.getInternalname(), "Values", cmbavConcepto_conobrasoccont.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_confonsolredcont.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Confonsolredcont( (byte)(GXutil.lval( cmbavConcepto_confonsolredcont.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Confonsolredcont(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_confonsolredcont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Confonsolredcont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonsolredcont.getInternalname(), "Values", cmbavConcepto_confonsolredcont.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conrenateacont.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conrenateacont( (byte)(GXutil.lval( cmbavConcepto_conrenateacont.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conrenateacont(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conrenateacont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conrenateacont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conrenateacont.getInternalname(), "Values", cmbavConcepto_conrenateacont.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conasigfamcont.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conasigfamcont( (byte)(GXutil.lval( cmbavConcepto_conasigfamcont.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conasigfamcont(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conasigfamcont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conasigfamcont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conasigfamcont.getInternalname(), "Values", cmbavConcepto_conasigfamcont.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_confonnacempcont.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Confonnacempcont( (byte)(GXutil.lval( cmbavConcepto_confonnacempcont.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Confonnacempcont(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_confonnacempcont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Confonnacempcont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonnacempcont.getInternalname(), "Values", cmbavConcepto_confonnacempcont.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conleyrietrabcont.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conleyrietrabcont( (byte)(GXutil.lval( cmbavConcepto_conleyrietrabcont.getValidValue(GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conleyrietrabcont(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conleyrietrabcont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conleyrietrabcont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conleyrietrabcont.getInternalname(), "Values", cmbavConcepto_conleyrietrabcont.ToJavascriptSource(), true);
      }
      if ( cmbavConcepto_conprereq.getItemCount() > 0 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Conprereq( cmbavConcepto_conprereq.getValidValue(AV7Concepto.getgxTv_SdtConcepto_Conprereq()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConcepto_conprereq.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Conprereq()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conprereq.getInternalname(), "Values", cmbavConcepto_conprereq.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      /* Execute user event: Refresh */
      e21AJ2 ();
      rfAJ2( ) ;
      rfAJ3( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV151Pgmname = "ConceptoABM" ;
      Gx_err = (short)(0) ;
      edtavConcepto_conformula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_conformula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_conformula_Enabled), 5, 0), true);
      edtavDeletegridlinegridlevel_tipoliquidacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeletegridlinegridlevel_tipoliquidacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDeletegridlinegridlevel_tipoliquidacion_Enabled), 5, 0), !bGXsfl_247_Refreshing);
      dynavConcepto_tipoliquidacion__tliqcod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_tipoliquidacion__tliqcod.getInternalname(), "Enabled", GXutil.ltrimstr( dynavConcepto_tipoliquidacion__tliqcod.getEnabled(), 5, 0), !bGXsfl_247_Refreshing);
      cmbavConcepto_tipoliquidacion__contltipegr.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_tipoliquidacion__contltipegr.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_tipoliquidacion__contltipegr.getEnabled(), 5, 0), !bGXsfl_247_Refreshing);
      edtavDeletegridlinegridlevel_motivos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeletegridlinegridlevel_motivos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDeletegridlinegridlevel_motivos_Enabled), 5, 0), !bGXsfl_262_Refreshing);
      edtavConcepto_motivosegreso__conmegsec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_motivosegreso__conmegsec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_motivosegreso__conmegsec_Enabled), 5, 0), !bGXsfl_262_Refreshing);
   }

   public void rfAJ2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_tipoliquidacionContainer.ClearRows();
      }
      wbStart = (short)(247) ;
      e24AJ2 ();
      nGXsfl_247_idx = 1 ;
      sGXsfl_247_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2472( ) ;
      bGXsfl_247_Refreshing = true ;
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("GridName", "Gridlevel_tipoliquidacion");
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("CmpContext", sPrefix);
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.setPageSize( subgridlevel_tipoliquidacion_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2472( ) ;
         e22AJ2 ();
         if ( ( GRIDLEVEL_TIPOLIQUIDACION_nCurrentRecord > 0 ) && ( GRIDLEVEL_TIPOLIQUIDACION_nGridOutOfScope == 0 ) && ( nGXsfl_247_idx == 1 ) )
         {
            GRIDLEVEL_TIPOLIQUIDACION_nCurrentRecord = 0 ;
            GRIDLEVEL_TIPOLIQUIDACION_nGridOutOfScope = 1 ;
            subgridlevel_tipoliquidacion_firstpage( ) ;
            e22AJ2 ();
         }
         wbEnd = (short)(247) ;
         wbAJ0( ) ;
      }
      bGXsfl_247_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesAJ2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMODE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vPERMITEMODIFICACION", AV26permiteModificacion);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPERMITEMODIFICACION", getSecureSignedToken( sPrefix, AV26permiteModificacion));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV151Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV151Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEGRESOTLIQCOD", GXutil.rtrim( AV28egresoTLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEGRESOTLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV28egresoTLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPAICOD", GXutil.ltrim( localUtil.ntoc( AV27PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPAICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV27PaiCod), "ZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vESSISTEMACONCEPTOSDEFAULT", AV25esSistemaConceptosDefault);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vESSISTEMACONCEPTOSDEFAULT", getSecureSignedToken( sPrefix, AV25esSistemaConceptosDefault));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vCLIENTECONVENIADOR", AV67ClienteConveniador);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLIENTECONVENIADOR", getSecureSignedToken( sPrefix, AV67ClienteConveniador));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vVIEJOCONRECALCULAR", AV30viejoConRecalcular);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVIEJOCONRECALCULAR", getSecureSignedToken( sPrefix, AV30viejoConRecalcular));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vVIEJOAPLIIGG", GXutil.ltrim( localUtil.ntoc( AV60viejoAplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVIEJOAPLIIGG", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV60viejoAplIIGG), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV32EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV32EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCONAFIPSIPAAPO", GXutil.rtrim( AV39ConAFIPSIPAApo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCONAFIPSIPAAPO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV39ConAFIPSIPAApo, ""))));
   }

   public void rfAJ3( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_motivosContainer.ClearRows();
      }
      wbStart = (short)(262) ;
      nGXsfl_262_idx = 1 ;
      sGXsfl_262_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_262_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2623( ) ;
      bGXsfl_262_Refreshing = true ;
      Gridlevel_motivosContainer.AddObjectProperty("GridName", "Gridlevel_motivos");
      Gridlevel_motivosContainer.AddObjectProperty("CmpContext", sPrefix);
      Gridlevel_motivosContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_motivosContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_motivosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_motivosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_motivosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_motivos_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_motivosContainer.setPageSize( subgridlevel_motivos_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2623( ) ;
         e26AJ3 ();
         if ( ( GRIDLEVEL_MOTIVOS_nCurrentRecord > 0 ) && ( GRIDLEVEL_MOTIVOS_nGridOutOfScope == 0 ) && ( nGXsfl_262_idx == 1 ) )
         {
            GRIDLEVEL_MOTIVOS_nCurrentRecord = 0 ;
            GRIDLEVEL_MOTIVOS_nGridOutOfScope = 1 ;
            subgridlevel_motivos_firstpage( ) ;
            e26AJ3 ();
         }
         wbEnd = (short)(262) ;
         wbAJ0( ) ;
      }
      bGXsfl_262_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesAJ3( )
   {
   }

   public int subgridlevel_tipoliquidacion_fnc_pagecount( )
   {
      GRIDLEVEL_TIPOLIQUIDACION_nRecordCount = subgridlevel_tipoliquidacion_fnc_recordcount( ) ;
      if ( ((int)((GRIDLEVEL_TIPOLIQUIDACION_nRecordCount) % (subgridlevel_tipoliquidacion_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDLEVEL_TIPOLIQUIDACION_nRecordCount/ (double) (subgridlevel_tipoliquidacion_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDLEVEL_TIPOLIQUIDACION_nRecordCount/ (double) (subgridlevel_tipoliquidacion_fnc_recordsperpage( )))+1) ;
   }

   public int subgridlevel_tipoliquidacion_fnc_recordcount( )
   {
      return AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() ;
   }

   public int subgridlevel_tipoliquidacion_fnc_recordsperpage( )
   {
      if ( subGridlevel_tipoliquidacion_Rows > 0 )
      {
         return subGridlevel_tipoliquidacion_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridlevel_tipoliquidacion_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage/ (double) (subgridlevel_tipoliquidacion_fnc_recordsperpage( )))+1) ;
   }

   public short subgridlevel_tipoliquidacion_firstpage( )
   {
      GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_tipoliquidacion_nextpage( )
   {
      GRIDLEVEL_TIPOLIQUIDACION_nRecordCount = subgridlevel_tipoliquidacion_fnc_recordcount( ) ;
      if ( ( GRIDLEVEL_TIPOLIQUIDACION_nRecordCount >= subgridlevel_tipoliquidacion_fnc_recordsperpage( ) ) && ( GRIDLEVEL_TIPOLIQUIDACION_nEOF == 0 ) )
      {
         GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage = (long)(GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage+subgridlevel_tipoliquidacion_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacionContainer.AddObjectProperty("GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage", GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDLEVEL_TIPOLIQUIDACION_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridlevel_tipoliquidacion_previouspage( )
   {
      if ( GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage >= subgridlevel_tipoliquidacion_fnc_recordsperpage( ) )
      {
         GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage = (long)(GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage-subgridlevel_tipoliquidacion_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_tipoliquidacion_lastpage( )
   {
      GRIDLEVEL_TIPOLIQUIDACION_nRecordCount = subgridlevel_tipoliquidacion_fnc_recordcount( ) ;
      if ( GRIDLEVEL_TIPOLIQUIDACION_nRecordCount > subgridlevel_tipoliquidacion_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDLEVEL_TIPOLIQUIDACION_nRecordCount) % (subgridlevel_tipoliquidacion_fnc_recordsperpage( )))) == 0 )
         {
            GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage = (long)(GRIDLEVEL_TIPOLIQUIDACION_nRecordCount-subgridlevel_tipoliquidacion_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage = (long)(GRIDLEVEL_TIPOLIQUIDACION_nRecordCount-((int)((GRIDLEVEL_TIPOLIQUIDACION_nRecordCount) % (subgridlevel_tipoliquidacion_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridlevel_tipoliquidacion_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage = (long)(subgridlevel_tipoliquidacion_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridlevel_motivos_fnc_pagecount( )
   {
      GRIDLEVEL_MOTIVOS_nRecordCount = subgridlevel_motivos_fnc_recordcount( ) ;
      if ( ((int)((GRIDLEVEL_MOTIVOS_nRecordCount) % (subgridlevel_motivos_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDLEVEL_MOTIVOS_nRecordCount/ (double) (subgridlevel_motivos_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDLEVEL_MOTIVOS_nRecordCount/ (double) (subgridlevel_motivos_fnc_recordsperpage( )))+1) ;
   }

   public int subgridlevel_motivos_fnc_recordcount( )
   {
      return AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() ;
   }

   public int subgridlevel_motivos_fnc_recordsperpage( )
   {
      if ( subGridlevel_motivos_Rows > 0 )
      {
         return subGridlevel_motivos_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridlevel_motivos_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDLEVEL_MOTIVOS_nFirstRecordOnPage/ (double) (subgridlevel_motivos_fnc_recordsperpage( )))+1) ;
   }

   public short subgridlevel_motivos_firstpage( )
   {
      GRIDLEVEL_MOTIVOS_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_MOTIVOS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_MOTIVOS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_motivos_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV7Concepto, AV63ConceptoMotivosEgresoDeleted, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV151Pgmname, AV28egresoTLiqCod, AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_motivos_nextpage( )
   {
      GRIDLEVEL_MOTIVOS_nRecordCount = subgridlevel_motivos_fnc_recordcount( ) ;
      if ( ( GRIDLEVEL_MOTIVOS_nRecordCount >= subgridlevel_motivos_fnc_recordsperpage( ) ) && ( GRIDLEVEL_MOTIVOS_nEOF == 0 ) )
      {
         GRIDLEVEL_MOTIVOS_nFirstRecordOnPage = (long)(GRIDLEVEL_MOTIVOS_nFirstRecordOnPage+subgridlevel_motivos_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_MOTIVOS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_MOTIVOS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Gridlevel_motivosContainer.AddObjectProperty("GRIDLEVEL_MOTIVOS_nFirstRecordOnPage", GRIDLEVEL_MOTIVOS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_motivos_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV7Concepto, AV63ConceptoMotivosEgresoDeleted, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV151Pgmname, AV28egresoTLiqCod, AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDLEVEL_MOTIVOS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridlevel_motivos_previouspage( )
   {
      if ( GRIDLEVEL_MOTIVOS_nFirstRecordOnPage >= subgridlevel_motivos_fnc_recordsperpage( ) )
      {
         GRIDLEVEL_MOTIVOS_nFirstRecordOnPage = (long)(GRIDLEVEL_MOTIVOS_nFirstRecordOnPage-subgridlevel_motivos_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_MOTIVOS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_MOTIVOS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_motivos_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV7Concepto, AV63ConceptoMotivosEgresoDeleted, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV151Pgmname, AV28egresoTLiqCod, AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_motivos_lastpage( )
   {
      GRIDLEVEL_MOTIVOS_nRecordCount = subgridlevel_motivos_fnc_recordcount( ) ;
      if ( GRIDLEVEL_MOTIVOS_nRecordCount > subgridlevel_motivos_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDLEVEL_MOTIVOS_nRecordCount) % (subgridlevel_motivos_fnc_recordsperpage( )))) == 0 )
         {
            GRIDLEVEL_MOTIVOS_nFirstRecordOnPage = (long)(GRIDLEVEL_MOTIVOS_nRecordCount-subgridlevel_motivos_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDLEVEL_MOTIVOS_nFirstRecordOnPage = (long)(GRIDLEVEL_MOTIVOS_nRecordCount-((int)((GRIDLEVEL_MOTIVOS_nRecordCount) % (subgridlevel_motivos_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDLEVEL_MOTIVOS_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_MOTIVOS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_MOTIVOS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_motivos_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV7Concepto, AV63ConceptoMotivosEgresoDeleted, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV151Pgmname, AV28egresoTLiqCod, AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridlevel_motivos_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDLEVEL_MOTIVOS_nFirstRecordOnPage = (long)(subgridlevel_motivos_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDLEVEL_MOTIVOS_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_MOTIVOS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_MOTIVOS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_motivos_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV7Concepto, AV63ConceptoMotivosEgresoDeleted, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV151Pgmname, AV28egresoTLiqCod, AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV151Pgmname = "ConceptoABM" ;
      Gx_err = (short)(0) ;
      edtavConcepto_conformula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_conformula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_conformula_Enabled), 5, 0), true);
      edtavDeletegridlinegridlevel_tipoliquidacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeletegridlinegridlevel_tipoliquidacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDeletegridlinegridlevel_tipoliquidacion_Enabled), 5, 0), !bGXsfl_247_Refreshing);
      dynavConcepto_tipoliquidacion__tliqcod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_tipoliquidacion__tliqcod.getInternalname(), "Enabled", GXutil.ltrimstr( dynavConcepto_tipoliquidacion__tliqcod.getEnabled(), 5, 0), !bGXsfl_247_Refreshing);
      cmbavConcepto_tipoliquidacion__contltipegr.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_tipoliquidacion__contltipegr.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_tipoliquidacion__contltipegr.getEnabled(), 5, 0), !bGXsfl_247_Refreshing);
      edtavDeletegridlinegridlevel_motivos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeletegridlinegridlevel_motivos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDeletegridlinegridlevel_motivos_Enabled), 5, 0), !bGXsfl_262_Refreshing);
      edtavConcepto_motivosegreso__conmegsec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_motivosegreso__conmegsec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_motivosegreso__conmegsec_Enabled), 5, 0), !bGXsfl_262_Refreshing);
      gxvconcepto_conrelsec_htmlAJ2( AV16CliCod) ;
      gxvconcepto_apliigg_htmlAJ2( AV16CliCod) ;
      gxvconcepto_tipoliquidacion__tliqcod_htmlAJ2( AV16CliCod) ;
      gxvconcepto_motivosegreso__megcodigo_htmlAJ3( AV16CliCod) ;
      fix_multi_value_controls( ) ;
   }

   public void strupAJ0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e20AJ2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      gxvconcepto_conceptoconvecodigo_htmlAJ2( AV16CliCod, AV27PaiCod) ;
      gxvconcepto_concuendebe_htmlAJ2( AV16CliCod, AV32EmpCod) ;
      gxvconcepto_concuenhaber_htmlAJ2( AV16CliCod, AV32EmpCod) ;
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vCONCEPTO"), AV7Concepto);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"Concepto"), AV7Concepto);
         /* Read saved values. */
         nRC_GXsfl_247 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_247"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_262 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_262"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV12TrnMode = httpContext.cgiGet( sPrefix+"wcpOAV12TrnMode") ;
         wcpOAV16CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV16CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV17ConCodigo = httpContext.cgiGet( sPrefix+"wcpOAV17ConCodigo") ;
         GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRIDLEVEL_MOTIVOS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDLEVEL_MOTIVOS_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRIDLEVEL_TIPOLIQUIDACION_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRIDLEVEL_MOTIVOS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDLEVEL_MOTIVOS_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGridlevel_tipoliquidacion_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Rows, (byte)(6), (byte)(0), ".", "")));
         subGridlevel_motivos_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDLEVEL_MOTIVOS_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_MOTIVOS_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_motivos_Rows, (byte)(6), (byte)(0), ".", "")));
         Dvpanel_tableattributes_Width = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Width") ;
         Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
         Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
         Dvpanel_tableattributes_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Cls") ;
         Dvpanel_tableattributes_Title = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Title") ;
         Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
         Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
         Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
         Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Iconposition") ;
         Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
         Dvpanel_unnamedtable4_Width = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Width") ;
         Dvpanel_unnamedtable4_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Autowidth")) ;
         Dvpanel_unnamedtable4_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Autoheight")) ;
         Dvpanel_unnamedtable4_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Cls") ;
         Dvpanel_unnamedtable4_Title = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Title") ;
         Dvpanel_unnamedtable4_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Collapsible")) ;
         Dvpanel_unnamedtable4_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Collapsed")) ;
         Dvpanel_unnamedtable4_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Showcollapseicon")) ;
         Dvpanel_unnamedtable4_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Iconposition") ;
         Dvpanel_unnamedtable4_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Autoscroll")) ;
         Dvpanel_unnamedtable3_Width = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Width") ;
         Dvpanel_unnamedtable3_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Autowidth")) ;
         Dvpanel_unnamedtable3_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Autoheight")) ;
         Dvpanel_unnamedtable3_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Cls") ;
         Dvpanel_unnamedtable3_Title = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Title") ;
         Dvpanel_unnamedtable3_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Collapsible")) ;
         Dvpanel_unnamedtable3_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Collapsed")) ;
         Dvpanel_unnamedtable3_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Showcollapseicon")) ;
         Dvpanel_unnamedtable3_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Iconposition") ;
         Dvpanel_unnamedtable3_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Autoscroll")) ;
         Dvpanel_panelapocont3_Width = httpContext.cgiGet( sPrefix+"DVPANEL_PANELAPOCONT3_Width") ;
         Dvpanel_panelapocont3_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_PANELAPOCONT3_Autowidth")) ;
         Dvpanel_panelapocont3_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_PANELAPOCONT3_Autoheight")) ;
         Dvpanel_panelapocont3_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_PANELAPOCONT3_Cls") ;
         Dvpanel_panelapocont3_Title = httpContext.cgiGet( sPrefix+"DVPANEL_PANELAPOCONT3_Title") ;
         Dvpanel_panelapocont3_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_PANELAPOCONT3_Collapsible")) ;
         Dvpanel_panelapocont3_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_PANELAPOCONT3_Collapsed")) ;
         Dvpanel_panelapocont3_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_PANELAPOCONT3_Showcollapseicon")) ;
         Dvpanel_panelapocont3_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_PANELAPOCONT3_Iconposition") ;
         Dvpanel_panelapocont3_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_PANELAPOCONT3_Autoscroll")) ;
         Gxuitabspanel_tabs1_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GXUITABSPANEL_TABS1_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gxuitabspanel_tabs1_Class = httpContext.cgiGet( sPrefix+"GXUITABSPANEL_TABS1_Class") ;
         Gxuitabspanel_tabs1_Historymanagement = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GXUITABSPANEL_TABS1_Historymanagement")) ;
         Gridlevel_motivos_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRIDLEVEL_MOTIVOS_EMPOWERER_Gridinternalname") ;
         Gridlevel_tipoliquidacion_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_EMPOWERER_Gridinternalname") ;
         nRC_GXsfl_247 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_247"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_247_fel_idx = 0 ;
         while ( nGXsfl_247_fel_idx < nRC_GXsfl_247 )
         {
            nGXsfl_247_fel_idx = ((subGridlevel_tipoliquidacion_Islastpage==1)&&(nGXsfl_247_fel_idx+1>subgridlevel_tipoliquidacion_fnc_recordsperpage( )) ? 1 : nGXsfl_247_fel_idx+1) ;
            sGXsfl_247_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2472( ) ;
            AV122GXV38 = (int)(nGXsfl_247_fel_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
            if ( ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) && ( AV122GXV38 > 0 ) )
            {
               AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
               AV9DeleteGridLineGridLevel_TipoLiquidacion = httpContext.cgiGet( edtavDeletegridlinegridlevel_tipoliquidacion_Internalname) ;
            }
         }
         if ( nGXsfl_247_fel_idx == 0 )
         {
            nGXsfl_247_idx = 1 ;
            sGXsfl_247_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2472( ) ;
         }
         nGXsfl_247_fel_idx = 1 ;
         nRC_GXsfl_262 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_262"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_262_fel_idx = 0 ;
         while ( nGXsfl_262_fel_idx < nRC_GXsfl_262 )
         {
            nGXsfl_262_fel_idx = ((subGridlevel_motivos_Islastpage==1)&&(nGXsfl_262_fel_idx+1>subgridlevel_motivos_fnc_recordsperpage( )) ? 1 : nGXsfl_262_fel_idx+1) ;
            sGXsfl_262_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_262_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2623( ) ;
            AV125GXV41 = (int)(nGXsfl_262_fel_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
            if ( ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) && ( AV125GXV41 > 0 ) )
            {
               AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
               AV61DeleteGridLineGridLevel_Motivos = httpContext.cgiGet( edtavDeletegridlinegridlevel_motivos_Internalname) ;
            }
         }
         if ( nGXsfl_262_fel_idx == 0 )
         {
            nGXsfl_262_idx = 1 ;
            sGXsfl_262_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_262_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2623( ) ;
         }
         nGXsfl_262_fel_idx = 1 ;
         /* Read variables values. */
         cmbavConcepto_tipoconcod.setName( cmbavConcepto_tipoconcod.getInternalname() );
         cmbavConcepto_tipoconcod.setValue( httpContext.cgiGet( cmbavConcepto_tipoconcod.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Tipoconcod( httpContext.cgiGet( cmbavConcepto_tipoconcod.getInternalname()) );
         cmbavConcepto_subtipoconcod1.setName( cmbavConcepto_subtipoconcod1.getInternalname() );
         cmbavConcepto_subtipoconcod1.setValue( httpContext.cgiGet( cmbavConcepto_subtipoconcod1.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Subtipoconcod1( httpContext.cgiGet( cmbavConcepto_subtipoconcod1.getInternalname()) );
         cmbavConcepto_subtipoconcod2.setName( cmbavConcepto_subtipoconcod2.getInternalname() );
         cmbavConcepto_subtipoconcod2.setValue( httpContext.cgiGet( cmbavConcepto_subtipoconcod2.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Subtipoconcod2( httpContext.cgiGet( cmbavConcepto_subtipoconcod2.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Concodigo( httpContext.cgiGet( edtavConcepto_concodigo_Internalname) );
         AV7Concepto.setgxTv_SdtConcepto_Condescrip( httpContext.cgiGet( edtavConcepto_condescrip_Internalname) );
         dynavConcepto_conrelsec.setName( dynavConcepto_conrelsec.getInternalname() );
         dynavConcepto_conrelsec.setValue( httpContext.cgiGet( dynavConcepto_conrelsec.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conrelsec( (int)(GXutil.lval( httpContext.cgiGet( dynavConcepto_conrelsec.getInternalname()))) );
         AV7Concepto.setgxTv_SdtConcepto_Conformula( httpContext.cgiGet( edtavConcepto_conformula_Internalname) );
         AV7Concepto.setgxTv_SdtConcepto_Conpuenov( GXutil.strtobool( httpContext.cgiGet( chkavConcepto_conpuenov.getInternalname())) );
         AV7Concepto.setgxTv_SdtConcepto_Convariable( GXutil.strtobool( httpContext.cgiGet( chkavConcepto_convariable.getInternalname())) );
         dynavConcepto_apliigg.setName( dynavConcepto_apliigg.getInternalname() );
         dynavConcepto_apliigg.setValue( httpContext.cgiGet( dynavConcepto_apliigg.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Apliigg( (short)(GXutil.lval( httpContext.cgiGet( dynavConcepto_apliigg.getInternalname()))) );
         AV7Concepto.setgxTv_SdtConcepto_Concodafip( httpContext.cgiGet( edtavConcepto_concodafip_Internalname) );
         AV7Concepto.setgxTv_SdtConcepto_Conhabilitado( GXutil.strtobool( httpContext.cgiGet( chkavConcepto_conhabilitado.getInternalname())) );
         cmbavConcepto_convigencia.setName( cmbavConcepto_convigencia.getInternalname() );
         cmbavConcepto_convigencia.setValue( httpContext.cgiGet( cmbavConcepto_convigencia.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Convigencia( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_convigencia.getInternalname()))) );
         cmbavConcepto_concondicion.setName( cmbavConcepto_concondicion.getInternalname() );
         cmbavConcepto_concondicion.setValue( httpContext.cgiGet( cmbavConcepto_concondicion.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Concondicion( httpContext.cgiGet( cmbavConcepto_concondicion.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Concondcodigo( httpContext.cgiGet( edtavConcepto_concondcodigo_Internalname) );
         AV7Concepto.setgxTv_SdtConcepto_Conobservacion( httpContext.cgiGet( edtavConcepto_conobservacion_Internalname) );
         AV7Concepto.setgxTv_SdtConcepto_Conrecalcular( GXutil.strtobool( httpContext.cgiGet( chkavConcepto_conrecalcular.getInternalname())) );
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavRangodesde_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavRangodesde_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vRANGODESDE");
            GX_FocusControl = edtavRangodesde_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV71RangoDesde = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71RangoDesde", GXutil.ltrimstr( AV71RangoDesde, 14, 2));
         }
         else
         {
            AV71RangoDesde = localUtil.ctond( httpContext.cgiGet( edtavRangodesde_Internalname)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71RangoDesde", GXutil.ltrimstr( AV71RangoDesde, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavRangohasta_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavRangohasta_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vRANGOHASTA");
            GX_FocusControl = edtavRangohasta_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV72RangoHasta = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72RangoHasta", GXutil.ltrimstr( AV72RangoHasta, 14, 2));
         }
         else
         {
            AV72RangoHasta = localUtil.ctond( httpContext.cgiGet( edtavRangohasta_Internalname)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72RangoHasta", GXutil.ltrimstr( AV72RangoHasta, 14, 2));
         }
         AV7Concepto.setgxTv_SdtConcepto_Conmostrarpos( GXutil.strtobool( httpContext.cgiGet( chkavConcepto_conmostrarpos.getInternalname())) );
         AV7Concepto.setgxTv_SdtConcepto_Conerrorsicero( GXutil.strtobool( httpContext.cgiGet( chkavConcepto_conerrorsicero.getInternalname())) );
         cmbavConcepto_conadeldescu.setName( cmbavConcepto_conadeldescu.getInternalname() );
         cmbavConcepto_conadeldescu.setValue( httpContext.cgiGet( cmbavConcepto_conadeldescu.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conadeldescu( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conadeldescu.getInternalname()))) );
         cmbavConcepto_consacdeven.setName( cmbavConcepto_consacdeven.getInternalname() );
         cmbavConcepto_consacdeven.setValue( httpContext.cgiGet( cmbavConcepto_consacdeven.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Consacdeven( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_consacdeven.getInternalname()))) );
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavConcepto_conorden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavConcepto_conorden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONCEPTO_CONORDEN");
            GX_FocusControl = edtavConcepto_conorden_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7Concepto.setgxTv_SdtConcepto_Conorden( 0 );
         }
         else
         {
            AV7Concepto.setgxTv_SdtConcepto_Conorden( (int)(localUtil.ctol( httpContext.cgiGet( edtavConcepto_conorden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavConcepto_conordejec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < -99999999999L ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavConcepto_conordejec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONCEPTO_CONORDEJEC");
            GX_FocusControl = edtavConcepto_conordejec_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7Concepto.setgxTv_SdtConcepto_Conordejec( 0 );
         }
         else
         {
            AV7Concepto.setgxTv_SdtConcepto_Conordejec( localUtil.ctol( httpContext.cgiGet( edtavConcepto_conordejec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) );
         }
         cmbavConcepto_conbaselic.setName( cmbavConcepto_conbaselic.getInternalname() );
         cmbavConcepto_conbaselic.setValue( httpContext.cgiGet( cmbavConcepto_conbaselic.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conbaselic( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conbaselic.getInternalname()))) );
         cmbavConcepto_conbaselicprom.setName( cmbavConcepto_conbaselicprom.getInternalname() );
         cmbavConcepto_conbaselicprom.setValue( httpContext.cgiGet( cmbavConcepto_conbaselicprom.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conbaselicprom( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conbaselicprom.getInternalname()))) );
         cmbavConcepto_conbasefer.setName( cmbavConcepto_conbasefer.getInternalname() );
         cmbavConcepto_conbasefer.setValue( httpContext.cgiGet( cmbavConcepto_conbasefer.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conbasefer( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conbasefer.getInternalname()))) );
         cmbavConcepto_conbaseferprom.setName( cmbavConcepto_conbaseferprom.getInternalname() );
         cmbavConcepto_conbaseferprom.setValue( httpContext.cgiGet( cmbavConcepto_conbaseferprom.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conbaseferprom( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conbaseferprom.getInternalname()))) );
         cmbavConcepto_conbasehorext.setName( cmbavConcepto_conbasehorext.getInternalname() );
         cmbavConcepto_conbasehorext.setValue( httpContext.cgiGet( cmbavConcepto_conbasehorext.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conbasehorext( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conbasehorext.getInternalname()))) );
         cmbavConcepto_conbasehorextprom.setName( cmbavConcepto_conbasehorextprom.getInternalname() );
         cmbavConcepto_conbasehorextprom.setValue( httpContext.cgiGet( cmbavConcepto_conbasehorextprom.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conbasehorextprom( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conbasehorextprom.getInternalname()))) );
         cmbavConcepto_conbasepres.setName( cmbavConcepto_conbasepres.getInternalname() );
         cmbavConcepto_conbasepres.setValue( httpContext.cgiGet( cmbavConcepto_conbasepres.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conbasepres( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conbasepres.getInternalname()))) );
         cmbavConcepto_conbaseant.setName( cmbavConcepto_conbaseant.getInternalname() );
         cmbavConcepto_conbaseant.setValue( httpContext.cgiGet( cmbavConcepto_conbaseant.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conbaseant( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conbaseant.getInternalname()))) );
         cmbavConcepto_conbaseosdif.setName( cmbavConcepto_conbaseosdif.getInternalname() );
         cmbavConcepto_conbaseosdif.setValue( httpContext.cgiGet( cmbavConcepto_conbaseosdif.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conbaseosdif( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conbaseosdif.getInternalname()))) );
         cmbavConcepto_conbaseaus.setName( cmbavConcepto_conbaseaus.getInternalname() );
         cmbavConcepto_conbaseaus.setValue( httpContext.cgiGet( cmbavConcepto_conbaseaus.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conbaseaus( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conbaseaus.getInternalname()))) );
         cmbavConcepto_conbaseausprom.setName( cmbavConcepto_conbaseausprom.getInternalname() );
         cmbavConcepto_conbaseausprom.setValue( httpContext.cgiGet( cmbavConcepto_conbaseausprom.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conbaseausprom( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conbaseausprom.getInternalname()))) );
         dynavConcepto_conceptoconvecodigo.setName( dynavConcepto_conceptoconvecodigo.getInternalname() );
         dynavConcepto_conceptoconvecodigo.setValue( httpContext.cgiGet( dynavConcepto_conceptoconvecodigo.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conceptoconvecodigo( httpContext.cgiGet( dynavConcepto_conceptoconvecodigo.getInternalname()) );
         dynavConcepto_concuendebe.setName( dynavConcepto_concuendebe.getInternalname() );
         dynavConcepto_concuendebe.setValue( httpContext.cgiGet( dynavConcepto_concuendebe.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Concuendebe( httpContext.cgiGet( dynavConcepto_concuendebe.getInternalname()) );
         dynavConcepto_concuenhaber.setName( dynavConcepto_concuenhaber.getInternalname() );
         dynavConcepto_concuenhaber.setValue( httpContext.cgiGet( dynavConcepto_concuenhaber.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Concuenhaber( httpContext.cgiGet( dynavConcepto_concuenhaber.getInternalname()) );
         cmbavConcepto_consipaapo.setName( cmbavConcepto_consipaapo.getInternalname() );
         cmbavConcepto_consipaapo.setValue( httpContext.cgiGet( cmbavConcepto_consipaapo.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Consipaapo( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_consipaapo.getInternalname()))) );
         cmbavConcepto_coninssjypapo.setName( cmbavConcepto_coninssjypapo.getInternalname() );
         cmbavConcepto_coninssjypapo.setValue( httpContext.cgiGet( cmbavConcepto_coninssjypapo.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Coninssjypapo( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_coninssjypapo.getInternalname()))) );
         cmbavConcepto_conobrasocapo.setName( cmbavConcepto_conobrasocapo.getInternalname() );
         cmbavConcepto_conobrasocapo.setValue( httpContext.cgiGet( cmbavConcepto_conobrasocapo.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conobrasocapo( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conobrasocapo.getInternalname()))) );
         cmbavConcepto_confonsolredapo.setName( cmbavConcepto_confonsolredapo.getInternalname() );
         cmbavConcepto_confonsolredapo.setValue( httpContext.cgiGet( cmbavConcepto_confonsolredapo.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Confonsolredapo( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_confonsolredapo.getInternalname()))) );
         cmbavConcepto_conrenateaapo.setName( cmbavConcepto_conrenateaapo.getInternalname() );
         cmbavConcepto_conrenateaapo.setValue( httpContext.cgiGet( cmbavConcepto_conrenateaapo.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conrenateaapo( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conrenateaapo.getInternalname()))) );
         cmbavConcepto_conregdifapo.setName( cmbavConcepto_conregdifapo.getInternalname() );
         cmbavConcepto_conregdifapo.setValue( httpContext.cgiGet( cmbavConcepto_conregdifapo.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conregdifapo( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conregdifapo.getInternalname()))) );
         cmbavConcepto_conregespapo.setName( cmbavConcepto_conregespapo.getInternalname() );
         cmbavConcepto_conregespapo.setValue( httpContext.cgiGet( cmbavConcepto_conregespapo.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conregespapo( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conregespapo.getInternalname()))) );
         cmbavConcepto_consipacont.setName( cmbavConcepto_consipacont.getInternalname() );
         cmbavConcepto_consipacont.setValue( httpContext.cgiGet( cmbavConcepto_consipacont.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Consipacont( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_consipacont.getInternalname()))) );
         cmbavConcepto_coninssjypcont.setName( cmbavConcepto_coninssjypcont.getInternalname() );
         cmbavConcepto_coninssjypcont.setValue( httpContext.cgiGet( cmbavConcepto_coninssjypcont.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Coninssjypcont( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_coninssjypcont.getInternalname()))) );
         cmbavConcepto_conobrasoccont.setName( cmbavConcepto_conobrasoccont.getInternalname() );
         cmbavConcepto_conobrasoccont.setValue( httpContext.cgiGet( cmbavConcepto_conobrasoccont.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conobrasoccont( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conobrasoccont.getInternalname()))) );
         cmbavConcepto_confonsolredcont.setName( cmbavConcepto_confonsolredcont.getInternalname() );
         cmbavConcepto_confonsolredcont.setValue( httpContext.cgiGet( cmbavConcepto_confonsolredcont.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Confonsolredcont( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_confonsolredcont.getInternalname()))) );
         cmbavConcepto_conrenateacont.setName( cmbavConcepto_conrenateacont.getInternalname() );
         cmbavConcepto_conrenateacont.setValue( httpContext.cgiGet( cmbavConcepto_conrenateacont.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conrenateacont( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conrenateacont.getInternalname()))) );
         cmbavConcepto_conasigfamcont.setName( cmbavConcepto_conasigfamcont.getInternalname() );
         cmbavConcepto_conasigfamcont.setValue( httpContext.cgiGet( cmbavConcepto_conasigfamcont.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conasigfamcont( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conasigfamcont.getInternalname()))) );
         cmbavConcepto_confonnacempcont.setName( cmbavConcepto_confonnacempcont.getInternalname() );
         cmbavConcepto_confonnacempcont.setValue( httpContext.cgiGet( cmbavConcepto_confonnacempcont.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Confonnacempcont( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_confonnacempcont.getInternalname()))) );
         cmbavConcepto_conleyrietrabcont.setName( cmbavConcepto_conleyrietrabcont.getInternalname() );
         cmbavConcepto_conleyrietrabcont.setValue( httpContext.cgiGet( cmbavConcepto_conleyrietrabcont.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conleyrietrabcont( (byte)(GXutil.lval( httpContext.cgiGet( cmbavConcepto_conleyrietrabcont.getInternalname()))) );
         AV7Concepto.setgxTv_SdtConcepto_Consegunpla( GXutil.strtobool( httpContext.cgiGet( chkavConcepto_consegunpla.getInternalname())) );
         cmbavConcepto_conprereq.setName( cmbavConcepto_conprereq.getInternalname() );
         cmbavConcepto_conprereq.setValue( httpContext.cgiGet( cmbavConcepto_conprereq.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conprereq( httpContext.cgiGet( cmbavConcepto_conprereq.getInternalname()) );
         AV7Concepto.setgxTv_SdtConcepto_Conrangocant( httpContext.cgiGet( edtavConcepto_conrangocant_Internalname) );
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavConcepto_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavConcepto_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONCEPTO_CLICOD");
            GX_FocusControl = edtavConcepto_clicod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7Concepto.setgxTv_SdtConcepto_Clicod( 0 );
         }
         else
         {
            AV7Concepto.setgxTv_SdtConcepto_Clicod( (int)(localUtil.ctol( httpContext.cgiGet( edtavConcepto_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
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
      e20AJ2 ();
      if (returnInSub) return;
   }

   public void e20AJ2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV151Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV16CliCod, 6, 0))) ;
      Gx_mode = AV12TrnMode ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      AV13LoadSuccess = true ;
      if ( ( ( GXutil.strcmp(AV12TrnMode, "DSP") == 0 ) ) || ( ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) ) || ( ( GXutil.strcmp(AV12TrnMode, "UPD") == 0 ) ) || ( ( GXutil.strcmp(AV12TrnMode, "DLT") == 0 ) ) )
      {
         if ( GXutil.strcmp(AV12TrnMode, "INS") != 0 )
         {
            AV7Concepto.Load(AV16CliCod, AV17ConCodigo);
            gx_BV247 = true ;
            AV13LoadSuccess = AV7Concepto.Success() ;
            if ( ! AV13LoadSuccess )
            {
               AV11Messages = AV7Concepto.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
            if ( ( GXutil.strcmp(AV12TrnMode, "DSP") == 0 ) || ( GXutil.strcmp(AV12TrnMode, "DLT") == 0 ) )
            {
               cmbavConcepto_consipaapo.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consipaapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_consipaapo.getEnabled(), 5, 0), true);
               cmbavConcepto_coninssjypapo.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_coninssjypapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_coninssjypapo.getEnabled(), 5, 0), true);
               cmbavConcepto_conobrasocapo.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conobrasocapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conobrasocapo.getEnabled(), 5, 0), true);
               cmbavConcepto_confonsolredapo.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonsolredapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_confonsolredapo.getEnabled(), 5, 0), true);
               cmbavConcepto_conrenateaapo.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conrenateaapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conrenateaapo.getEnabled(), 5, 0), true);
               cmbavConcepto_conregdifapo.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conregdifapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conregdifapo.getEnabled(), 5, 0), true);
               cmbavConcepto_conregespapo.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conregespapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conregespapo.getEnabled(), 5, 0), true);
               cmbavConcepto_consipacont.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consipacont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_consipacont.getEnabled(), 5, 0), true);
               cmbavConcepto_coninssjypcont.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_coninssjypcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_coninssjypcont.getEnabled(), 5, 0), true);
               cmbavConcepto_conobrasoccont.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conobrasoccont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conobrasoccont.getEnabled(), 5, 0), true);
               cmbavConcepto_confonsolredcont.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonsolredcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_confonsolredcont.getEnabled(), 5, 0), true);
               cmbavConcepto_conrenateacont.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conrenateacont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conrenateacont.getEnabled(), 5, 0), true);
               cmbavConcepto_conasigfamcont.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conasigfamcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conasigfamcont.getEnabled(), 5, 0), true);
               cmbavConcepto_confonnacempcont.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonnacempcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_confonnacempcont.getEnabled(), 5, 0), true);
               cmbavConcepto_conleyrietrabcont.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conleyrietrabcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conleyrietrabcont.getEnabled(), 5, 0), true);
               chkavConcepto_conpuenov.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conpuenov.getInternalname(), "Enabled", GXutil.ltrimstr( chkavConcepto_conpuenov.getEnabled(), 5, 0), true);
               chkavConcepto_convariable.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_convariable.getInternalname(), "Enabled", GXutil.ltrimstr( chkavConcepto_convariable.getEnabled(), 5, 0), true);
               dynavConcepto_apliigg.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_apliigg.getInternalname(), "Enabled", GXutil.ltrimstr( dynavConcepto_apliigg.getEnabled(), 5, 0), true);
               edtavConcepto_concodafip_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_concodafip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_concodafip_Enabled), 5, 0), true);
               chkavConcepto_conhabilitado.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conhabilitado.getInternalname(), "Enabled", GXutil.ltrimstr( chkavConcepto_conhabilitado.getEnabled(), 5, 0), true);
               cmbavConcepto_convigencia.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_convigencia.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_convigencia.getEnabled(), 5, 0), true);
               cmbavConcepto_concondicion.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_concondicion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_concondicion.getEnabled(), 5, 0), true);
               edtavConcepto_concondcodigo_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_concondcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_concondcodigo_Enabled), 5, 0), true);
               edtavConcepto_conobservacion_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_conobservacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_conobservacion_Enabled), 5, 0), true);
               chkavConcepto_conrecalcular.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conrecalcular.getInternalname(), "Enabled", GXutil.ltrimstr( chkavConcepto_conrecalcular.getEnabled(), 5, 0), true);
               chkavConcepto_conmostrarpos.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conmostrarpos.getInternalname(), "Enabled", GXutil.ltrimstr( chkavConcepto_conmostrarpos.getEnabled(), 5, 0), true);
               chkavConcepto_conerrorsicero.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conerrorsicero.getInternalname(), "Enabled", GXutil.ltrimstr( chkavConcepto_conerrorsicero.getEnabled(), 5, 0), true);
               cmbavConcepto_conadeldescu.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conadeldescu.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conadeldescu.getEnabled(), 5, 0), true);
               cmbavConcepto_consacdeven.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consacdeven.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_consacdeven.getEnabled(), 5, 0), true);
               edtavConcepto_conorden_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_conorden_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_conorden_Enabled), 5, 0), true);
               edtavConcepto_conordejec_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_conordejec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_conordejec_Enabled), 5, 0), true);
               cmbavConcepto_conbaselic.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaselic.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conbaselic.getEnabled(), 5, 0), true);
               cmbavConcepto_conbaselicprom.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaselicprom.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conbaselicprom.getEnabled(), 5, 0), true);
               cmbavConcepto_conbasefer.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasefer.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conbasefer.getEnabled(), 5, 0), true);
               cmbavConcepto_conbaseferprom.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseferprom.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conbaseferprom.getEnabled(), 5, 0), true);
               cmbavConcepto_conbasehorext.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasehorext.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conbasehorext.getEnabled(), 5, 0), true);
               cmbavConcepto_conbasehorextprom.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasehorextprom.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conbasehorextprom.getEnabled(), 5, 0), true);
               cmbavConcepto_conbasepres.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasepres.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conbasepres.getEnabled(), 5, 0), true);
               cmbavConcepto_conbaseant.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseant.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conbaseant.getEnabled(), 5, 0), true);
               cmbavConcepto_conbaseosdif.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseosdif.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conbaseosdif.getEnabled(), 5, 0), true);
               cmbavConcepto_conbaseaus.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseaus.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conbaseaus.getEnabled(), 5, 0), true);
               cmbavConcepto_conbaseausprom.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseausprom.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conbaseausprom.getEnabled(), 5, 0), true);
               dynavConcepto_conceptoconvecodigo.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_conceptoconvecodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynavConcepto_conceptoconvecodigo.getEnabled(), 5, 0), true);
               dynavConcepto_concuendebe.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_concuendebe.getInternalname(), "Enabled", GXutil.ltrimstr( dynavConcepto_concuendebe.getEnabled(), 5, 0), true);
               dynavConcepto_concuenhaber.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_concuenhaber.getInternalname(), "Enabled", GXutil.ltrimstr( dynavConcepto_concuenhaber.getEnabled(), 5, 0), true);
               edtavRangodesde_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavRangodesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRangodesde_Enabled), 5, 0), true);
               edtavRangohasta_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavRangohasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRangohasta_Enabled), 5, 0), true);
               cmbavConcepto_tipoconcod.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_tipoconcod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_tipoconcod.getEnabled(), 5, 0), true);
               cmbavConcepto_subtipoconcod1.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_subtipoconcod1.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_subtipoconcod1.getEnabled(), 5, 0), true);
               cmbavConcepto_subtipoconcod2.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_subtipoconcod2.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_subtipoconcod2.getEnabled(), 5, 0), true);
               edtavConcepto_condescrip_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_condescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_condescrip_Enabled), 5, 0), true);
               dynavConcepto_conrelsec.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_conrelsec.getInternalname(), "Enabled", GXutil.ltrimstr( dynavConcepto_conrelsec.getEnabled(), 5, 0), true);
            }
            edtavConcepto_concodigo_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_concodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_concodigo_Enabled), 5, 0), true);
         }
      }
      else
      {
         AV13LoadSuccess = false ;
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      if ( AV13LoadSuccess )
      {
         if ( GXutil.strcmp(AV12TrnMode, "DLT") == 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "GXM_confdelete", ""));
         }
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if (returnInSub) return;
      chkavConcepto_consegunpla.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_consegunpla.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_consegunpla.getVisible(), 5, 0), true);
      cmbavConcepto_conprereq.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conprereq.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conprereq.getVisible(), 5, 0), true);
      edtavConcepto_conrangocant_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_conrangocant_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_conrangocant_Visible), 5, 0), true);
      edtavConcepto_clicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_clicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_clicod_Visible), 5, 0), true);
      Gridlevel_motivos_empowerer_Gridinternalname = subGridlevel_motivos_Internalname ;
      ucGridlevel_motivos_empowerer.sendProperty(context, sPrefix, false, Gridlevel_motivos_empowerer_Internalname, "GridInternalName", Gridlevel_motivos_empowerer_Gridinternalname);
      subGridlevel_motivos_Rows = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_MOTIVOS_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_motivos_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridlevel_tipoliquidacion_empowerer_Gridinternalname = subGridlevel_tipoliquidacion_Internalname ;
      ucGridlevel_tipoliquidacion_empowerer.sendProperty(context, sPrefix, false, Gridlevel_tipoliquidacion_empowerer_Internalname, "GridInternalName", Gridlevel_tipoliquidacion_empowerer_Gridinternalname);
      subGridlevel_tipoliquidacion_Rows = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Rows, (byte)(6), (byte)(0), ".", "")));
      GXt_int1 = AV27PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV16CliCod, GXv_int2) ;
      conceptoabm_impl.this.GXt_int1 = GXv_int2[0] ;
      AV27PaiCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27PaiCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPAICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV27PaiCod), "ZZZ9")));
      /* Execute user subroutine: 'VISIBILIDAD VARIABLE' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'VISIBILIDAD APLICA GANANCIAS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'TEXTOS BASE' */
      S152 ();
      if (returnInSub) return;
      GXt_boolean3 = AV25esSistemaConceptosDefault ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean4) ;
      conceptoabm_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV25esSistemaConceptosDefault = GXt_boolean3 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25esSistemaConceptosDefault", AV25esSistemaConceptosDefault);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vESSISTEMACONCEPTOSDEFAULT", getSecureSignedToken( sPrefix, AV25esSistemaConceptosDefault));
      GXt_char5 = AV28egresoTLiqCod ;
      GXt_char6 = AV28egresoTLiqCod ;
      GXv_char7[0] = GXt_char6 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char7) ;
      conceptoabm_impl.this.GXt_char6 = GXv_char7[0] ;
      GXv_char8[0] = GXt_char5 ;
      new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char6, GXv_char8) ;
      conceptoabm_impl.this.GXt_char5 = GXv_char8[0] ;
      AV28egresoTLiqCod = GXt_char5 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28egresoTLiqCod", AV28egresoTLiqCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEGRESOTLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV28egresoTLiqCod, ""))));
      GXt_int1 = AV32EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      conceptoabm_impl.this.GXt_int1 = GXv_int2[0] ;
      AV32EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vEMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV32EmpCod), "ZZZ9")));
      GXv_boolean4[0] = AV67ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV16CliCod, GXv_boolean4) ;
      conceptoabm_impl.this.AV67ClienteConveniador = GXv_boolean4[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67ClienteConveniador", AV67ClienteConveniador);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCLIENTECONVENIADOR", getSecureSignedToken( sPrefix, AV67ClienteConveniador));
      if ( ( AV25esSistemaConceptosDefault ) || ( AV67ClienteConveniador ) )
      {
         dynavConcepto_conrelsec.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_conrelsec.getInternalname(), "Visible", GXutil.ltrimstr( dynavConcepto_conrelsec.getVisible(), 5, 0), true);
      }
      else
      {
         dynavConcepto_conrelsec.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_conrelsec.getInternalname(), "Visible", GXutil.ltrimstr( dynavConcepto_conrelsec.getVisible(), 5, 0), true);
      }
      if ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", "")) == 0 )
      {
         if ( AV67ClienteConveniador )
         {
            GXt_char6 = "" ;
            GXv_char8[0] = GXt_char6 ;
            new web.getconvecodsesion(remoteHandle, context).execute( GXv_char8) ;
            conceptoabm_impl.this.GXt_char6 = GXv_char8[0] ;
            AV7Concepto.setgxTv_SdtConcepto_Conceptoconvecodigo( GXt_char6 );
            dynavConcepto_conceptoconvecodigo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_conceptoconvecodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynavConcepto_conceptoconvecodigo.getEnabled(), 5, 0), true);
         }
         AV7Concepto.setgxTv_SdtConcepto_Conrangocant( "[1]" );
         AV7Concepto.setgxTv_SdtConcepto_Clicod( AV16CliCod );
         AV7Concepto.setgxTv_SdtConcepto_Conerrorsicero( true );
         AV7Concepto.setgxTv_SdtConcepto_Convigencia( (byte)(1) );
         AV7Concepto.setgxTv_SdtConcepto_Consacdeven( (byte)(1) );
         AV7Concepto.setgxTv_SdtConcepto_Tipoconcod( "REM_ARG" );
         AV7Concepto.setgxTv_SdtConcepto_Conhabilitado( true );
         tblFormulatbl_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblFormulatbl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblFormulatbl_Visible), 5, 0), true);
         AV26permiteModificacion = true ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26permiteModificacion", AV26permiteModificacion);
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPERMITEMODIFICACION", getSecureSignedToken( sPrefix, AV26permiteModificacion));
         GXt_char6 = "" ;
         GXv_char8[0] = GXt_char6 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char8) ;
         conceptoabm_impl.this.GXt_char6 = GXv_char8[0] ;
         AV7Concepto.setgxTv_SdtConcepto_Subtipoconcod1( GXt_char6 );
         GXt_char6 = "" ;
         GXv_char8[0] = GXt_char6 ;
         new web.conceptoafipsueldo(remoteHandle, context).execute( GXv_char8) ;
         conceptoabm_impl.this.GXt_char6 = GXv_char8[0] ;
         AV7Concepto.setgxTv_SdtConcepto_Subtipoconcod2( GXt_char6 );
         GXv_char8[0] = AV7Concepto.getgxTv_SdtConcepto_Concodigo() ;
         new web.proximoconcodigo(remoteHandle, context).execute( AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), GXv_char8) ;
         AV7Concepto.setgxTv_SdtConcepto_Concodigo( GXv_char8[0] );
         AV68vieneDeClick = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68vieneDeClick", AV68vieneDeClick);
         /* Execute user subroutine: 'AFIP DEFAULT' */
         S162 ();
         if (returnInSub) return;
         AV65itemConcTipoLiq = (web.SdtConcepto_TipoLiquidacion)new web.SdtConcepto_TipoLiquidacion( remoteHandle, context);
         GXt_char6 = "" ;
         GXt_char5 = "" ;
         GXv_char8[0] = GXt_char5 ;
         new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char8) ;
         conceptoabm_impl.this.GXt_char5 = GXv_char8[0] ;
         GXv_char7[0] = GXt_char6 ;
         new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char5, GXv_char7) ;
         conceptoabm_impl.this.GXt_char6 = GXv_char7[0] ;
         AV65itemConcTipoLiq.setgxTv_SdtConcepto_TipoLiquidacion_Tliqcod( GXt_char6 );
         AV65itemConcTipoLiq.setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion( "A0" );
         AV65itemConcTipoLiq.setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_SetNull();
         AV65itemConcTipoLiq.setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_SetNull();
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().add(AV65itemConcTipoLiq, 0);
         gx_BV247 = true ;
         AV65itemConcTipoLiq = (web.SdtConcepto_TipoLiquidacion)new web.SdtConcepto_TipoLiquidacion( remoteHandle, context);
         GXt_char6 = "" ;
         GXt_char5 = "" ;
         GXv_char8[0] = GXt_char5 ;
         new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char8) ;
         conceptoabm_impl.this.GXt_char5 = GXv_char8[0] ;
         GXv_char7[0] = GXt_char6 ;
         new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char5, GXv_char7) ;
         conceptoabm_impl.this.GXt_char6 = GXv_char7[0] ;
         AV65itemConcTipoLiq.setgxTv_SdtConcepto_TipoLiquidacion_Tliqcod( GXt_char6 );
         AV65itemConcTipoLiq.setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion( "A0" );
         AV65itemConcTipoLiq.setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_SetNull();
         AV65itemConcTipoLiq.setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_SetNull();
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().add(AV65itemConcTipoLiq, 0);
         gx_BV247 = true ;
         GXv_int9[0] = AV7Concepto.getgxTv_SdtConcepto_Conorden() ;
         GXv_int10[0] = AV7Concepto.getgxTv_SdtConcepto_Conordejec() ;
         new web.defaultordenconcepto(remoteHandle, context).execute( AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), GXv_int9, GXv_int10) ;
         AV7Concepto.setgxTv_SdtConcepto_Conorden( GXv_int9[0] );
         AV7Concepto.setgxTv_SdtConcepto_Conordejec( GXv_int10[0] );
      }
      else
      {
         tblFormulatbl_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblFormulatbl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblFormulatbl_Visible), 5, 0), true);
         if ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "UPD", "")) == 0 )
         {
            AV30viejoConRecalcular = AV7Concepto.getgxTv_SdtConcepto_Conrecalcular() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30viejoConRecalcular", AV30viejoConRecalcular);
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVIEJOCONRECALCULAR", getSecureSignedToken( sPrefix, AV30viejoConRecalcular));
            AV60viejoAplIIGG = AV7Concepto.getgxTv_SdtConcepto_Apliigg() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60viejoAplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60viejoAplIIGG), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVIEJOAPLIIGG", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV60viejoAplIIGG), "ZZZ9")));
            GXt_boolean3 = AV26permiteModificacion ;
            GXv_boolean4[0] = GXt_boolean3 ;
            new web.permitemodificacionformula(remoteHandle, context).execute( AV16CliCod, AV17ConCodigo, GXv_boolean4) ;
            conceptoabm_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
            AV26permiteModificacion = GXt_boolean3 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26permiteModificacion", AV26permiteModificacion);
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPERMITEMODIFICACION", getSecureSignedToken( sPrefix, AV26permiteModificacion));
            cmbavConcepto_consacdeven.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consacdeven.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_consacdeven.getEnabled(), 5, 0), true);
            dynavConcepto_conceptoconvecodigo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_conceptoconvecodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynavConcepto_conceptoconvecodigo.getEnabled(), 5, 0), true);
            edtavConcepto_concodafip_Enabled = (AV26permiteModificacion ? 1 : 0) ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_concodafip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_concodafip_Enabled), 5, 0), true);
            chkavConcepto_conrecalcular.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conrecalcular.getInternalname(), "Enabled", GXutil.ltrimstr( chkavConcepto_conrecalcular.getEnabled(), 5, 0), true);
            cmbavConcepto_convigencia.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_convigencia.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_convigencia.getEnabled(), 5, 0), true);
            chkavConcepto_conpuenov.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conpuenov.getInternalname(), "Enabled", GXutil.ltrimstr( chkavConcepto_conpuenov.getEnabled(), 5, 0), true);
            edtavConcepto_conobservacion_Visible = (AV26permiteModificacion ? 1 : 0) ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_conobservacion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_conobservacion_Visible), 5, 0), true);
            chkavConcepto_convariable.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_convariable.getInternalname(), "Enabled", GXutil.ltrimstr( chkavConcepto_convariable.getEnabled(), 5, 0), true);
            cmbavConcepto_tipoconcod.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_tipoconcod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_tipoconcod.getEnabled(), 5, 0), true);
            cmbavConcepto_subtipoconcod1.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_subtipoconcod1.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_subtipoconcod1.getEnabled(), 5, 0), true);
            cmbavConcepto_subtipoconcod2.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_subtipoconcod2.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_subtipoconcod2.getEnabled(), 5, 0), true);
            dynavConcepto_apliigg.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_apliigg.getInternalname(), "Enabled", GXutil.ltrimstr( dynavConcepto_apliigg.getEnabled(), 5, 0), true);
            cmbavConcepto_concondicion.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_concondicion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_concondicion.getEnabled(), 5, 0), true);
            edtavConcepto_concondcodigo_Enabled = (AV26permiteModificacion ? 1 : 0) ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_concondcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_concondcodigo_Enabled), 5, 0), true);
            cmbavConcepto_conprereq.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conprereq.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conprereq.getEnabled(), 5, 0), true);
            edtavConcepto_conrangocant_Enabled = (AV26permiteModificacion ? 1 : 0) ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_conrangocant_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_conrangocant_Enabled), 5, 0), true);
            chkavConcepto_conmostrarpos.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conmostrarpos.getInternalname(), "Enabled", GXutil.ltrimstr( chkavConcepto_conmostrarpos.getEnabled(), 5, 0), true);
            chkavConcepto_conerrorsicero.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conerrorsicero.getInternalname(), "Enabled", GXutil.ltrimstr( chkavConcepto_conerrorsicero.getEnabled(), 5, 0), true);
            cmbavConcepto_conadeldescu.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conadeldescu.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conadeldescu.getEnabled(), 5, 0), true);
            cmbavConcepto_conasigfamcont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conasigfamcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conasigfamcont.getEnabled(), 5, 0), true);
            cmbavConcepto_confonnacempcont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonnacempcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_confonnacempcont.getEnabled(), 5, 0), true);
            cmbavConcepto_confonsolredapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonsolredapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_confonsolredapo.getEnabled(), 5, 0), true);
            cmbavConcepto_confonsolredcont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonsolredcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_confonsolredcont.getEnabled(), 5, 0), true);
            cmbavConcepto_coninssjypapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_coninssjypapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_coninssjypapo.getEnabled(), 5, 0), true);
            cmbavConcepto_coninssjypcont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_coninssjypcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_coninssjypcont.getEnabled(), 5, 0), true);
            cmbavConcepto_conleyrietrabcont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conleyrietrabcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conleyrietrabcont.getEnabled(), 5, 0), true);
            cmbavConcepto_conobrasocapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conobrasocapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conobrasocapo.getEnabled(), 5, 0), true);
            cmbavConcepto_conobrasoccont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conobrasoccont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conobrasoccont.getEnabled(), 5, 0), true);
            cmbavConcepto_conregdifapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conregdifapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conregdifapo.getEnabled(), 5, 0), true);
            cmbavConcepto_conregespapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conregespapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conregespapo.getEnabled(), 5, 0), true);
            cmbavConcepto_conrenateaapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conrenateaapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conrenateaapo.getEnabled(), 5, 0), true);
            cmbavConcepto_conrenateacont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conrenateacont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conrenateacont.getEnabled(), 5, 0), true);
            cmbavConcepto_consipaapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consipaapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_consipaapo.getEnabled(), 5, 0), true);
            cmbavConcepto_consipacont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consipacont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_consipacont.getEnabled(), 5, 0), true);
            edtavRangodesde_Enabled = (AV26permiteModificacion ? 1 : 0) ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavRangodesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRangodesde_Enabled), 5, 0), true);
            edtavRangohasta_Enabled = (AV26permiteModificacion ? 1 : 0) ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavRangohasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRangohasta_Enabled), 5, 0), true);
            edtavConcepto_conorden_Enabled = (AV26permiteModificacion ? 1 : 0) ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_conorden_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_conorden_Enabled), 5, 0), true);
            edtavConcepto_conordejec_Enabled = (AV26permiteModificacion ? 1 : 0) ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_conordejec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_conordejec_Enabled), 5, 0), true);
            if ( AV67ClienteConveniador )
            {
               cmbavConcepto_consacdeven.setEnabled( (AV26permiteModificacion ? 1 : 0) );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consacdeven.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_consacdeven.getEnabled(), 5, 0), true);
            }
         }
         else
         {
         }
      }
      /* Execute user subroutine: 'VISIBILIDAD RECALCULAR' */
      S172 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'COMBO SUBTIPO 1' */
      S182 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'COMBO SUBTIPO 2' */
      S192 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'VISIBILIDAD CONDICION' */
      S202 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ACTUALIZAR PERMISIBLES' */
      S212 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SACDEVEN VISIBLE' */
      S222 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'RANGO A VARIABLES' */
      S232 ();
      if (returnInSub) return;
   }

   public void e21AJ2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S242 ();
      if (returnInSub) return;
      edtavDeletegridlinegridlevel_motivos_Columnheaderclass = "WWIconActionColumn" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeletegridlinegridlevel_motivos_Internalname, "Columnheaderclass", edtavDeletegridlinegridlevel_motivos_Columnheaderclass, !bGXsfl_262_Refreshing);
      dynavConcepto_motivosegreso__megcodigo.setColumnHeaderClass( "WWColumn" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_motivosegreso__megcodigo.getInternalname(), "Columnheaderclass", dynavConcepto_motivosegreso__megcodigo.getColumnHeaderClass(), !bGXsfl_262_Refreshing);
      cmbavConcepto_motivosegreso__megpreatipo.setColumnHeaderClass( "WWColumn" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_motivosegreso__megpreatipo.getInternalname(), "Columnheaderclass", cmbavConcepto_motivosegreso__megpreatipo.getColumnHeaderClass(), !bGXsfl_262_Refreshing);
      edtavConcepto_motivosegreso__conmegmeses_Columnheaderclass = "WWColumn" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_motivosegreso__conmegmeses_Internalname, "Columnheaderclass", edtavConcepto_motivosegreso__conmegmeses_Columnheaderclass, !bGXsfl_262_Refreshing);
      cmbavConcepto_motivosegreso__conmegdura.setColumnHeaderClass( "WWColumn" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_motivosegreso__conmegdura.getInternalname(), "Columnheaderclass", cmbavConcepto_motivosegreso__conmegdura.getColumnHeaderClass(), !bGXsfl_262_Refreshing);
      edtavConcepto_motivosegreso__conmegpropor_Columnheaderclass = "WWColumn" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_motivosegreso__conmegpropor_Internalname, "Columnheaderclass", edtavConcepto_motivosegreso__conmegpropor_Columnheaderclass, !bGXsfl_262_Refreshing);
      edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass = "WWIconActionColumn" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeletegridlinegridlevel_tipoliquidacion_Internalname, "Columnheaderclass", edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass, !bGXsfl_247_Refreshing);
      dynavConcepto_tipoliquidacion__tliqcod.setColumnHeaderClass( "WWColumn" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_tipoliquidacion__tliqcod.getInternalname(), "Columnheaderclass", dynavConcepto_tipoliquidacion__tliqcod.getColumnHeaderClass(), !bGXsfl_247_Refreshing);
      /*  Sending Event outputs  */
   }

   private void e22AJ2( )
   {
      /* Gridlevel_tipoliquidacion_Load Routine */
      returnInSub = false ;
      AV122GXV38 = 1 ;
      while ( AV122GXV38 <= AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() )
      {
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
         new web.msgdebug_prod(remoteHandle, context).execute( AV151Pgmname, httpContext.getMessage( "GridLevel_TipoLiquidacion.Load", "")) ;
         AV15LineDeleted = (boolean)(((AV22ConceptoTipoLiquidacionDeleted.indexof(AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().indexof(((web.SdtConcepto_TipoLiquidacion)(AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem()))))>0))) ;
         AV9DeleteGridLineGridLevel_TipoLiquidacion = "<i class=\"fa fa-times TrnGridDelete\"></i>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDeletegridlinegridlevel_tipoliquidacion_Internalname, AV9DeleteGridLineGridLevel_TipoLiquidacion);
         if ( ( ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) || ( GXutil.strcmp(AV12TrnMode, "UPD") == 0 ) ) && ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( AV26permiteModificacion ) ) )
         {
            edtavDeletegridlinegridlevel_tipoliquidacion_Class = "Attribute" ;
         }
         else
         {
            edtavDeletegridlinegridlevel_tipoliquidacion_Class = "Invisible" ;
         }
         edtavDeletegridlinegridlevel_tipoliquidacion_Columnclass = (AV15LineDeleted ? "WWIconActionColumn WWColumnLineThrough WWColumnLineThroughFirstColumn" : "WWIconActionColumn") ;
         dynavConcepto_tipoliquidacion__tliqcod.setColumnClass( (AV15LineDeleted ? "WWColumn WWColumnLineThrough" : "WWColumn") );
         dynavConcepto_tipoliquidacion__tliqcod.setEnabled( (((GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", ""))==0)||(AV26permiteModificacion)) ? 1 : 0) );
         if ( GXutil.strcmp(((web.SdtConcepto_TipoLiquidacion)(AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem())).getgxTv_SdtConcepto_TipoLiquidacion_Tliqcod(), AV28egresoTLiqCod) == 0 )
         {
            divTableleaflevel_motivosegreso_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divTableleaflevel_motivosegreso_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableleaflevel_motivosegreso_Visible), 5, 0), true);
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(247) ;
         }
         if ( ( subGridlevel_tipoliquidacion_Islastpage == 1 ) || ( subGridlevel_tipoliquidacion_Rows == 0 ) || ( ( GRIDLEVEL_TIPOLIQUIDACION_nCurrentRecord >= GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage ) && ( GRIDLEVEL_TIPOLIQUIDACION_nCurrentRecord < GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage + subgridlevel_tipoliquidacion_fnc_recordsperpage( ) ) ) )
         {
            sendrow_2472( ) ;
            GRIDLEVEL_TIPOLIQUIDACION_nEOF = (byte)(0) ;
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_TIPOLIQUIDACION_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDLEVEL_TIPOLIQUIDACION_nCurrentRecord + 1 >= subgridlevel_tipoliquidacion_fnc_recordcount( ) )
            {
               GRIDLEVEL_TIPOLIQUIDACION_nEOF = (byte)(1) ;
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_TIPOLIQUIDACION_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDLEVEL_TIPOLIQUIDACION_nCurrentRecord = (long)(GRIDLEVEL_TIPOLIQUIDACION_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_247_Refreshing )
         {
            httpContext.doAjaxLoad(247, Gridlevel_tipoliquidacionRow);
         }
         AV122GXV38 = (int)(AV122GXV38+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e11AJ2( )
   {
      AV122GXV38 = (int)(nGXsfl_247_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
      if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
      }
      AV125GXV41 = (int)(nGXsfl_262_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
      if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
      }
      /* 'DoAddGridLineGridLevel_MotivosEgreso' Routine */
      returnInSub = false ;
      AV76motivoEgresoItem = (web.SdtConcepto_MotivosEgreso)new web.SdtConcepto_MotivosEgreso( remoteHandle, context);
      AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().add(AV76motivoEgresoItem, 0);
      gx_BV262 = true ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV7Concepto", AV7Concepto);
      nGXsfl_247_bak_idx = nGXsfl_247_idx ;
      gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      nGXsfl_247_idx = nGXsfl_247_bak_idx ;
      sGXsfl_247_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2472( ) ;
   }

   public void e12AJ2( )
   {
      AV122GXV38 = (int)(nGXsfl_247_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
      if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
      }
      AV125GXV41 = (int)(nGXsfl_262_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
      if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
      }
      /* 'DoAddGridLineGridLevel_Motivos' Routine */
      returnInSub = false ;
      AV62ConceptoMotivosEgresoItem = (web.SdtConcepto_MotivosEgreso)new web.SdtConcepto_MotivosEgreso( remoteHandle, context);
      AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().add(AV62ConceptoMotivosEgresoItem, 0);
      gx_BV262 = true ;
      gxgrgridlevel_motivos_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV7Concepto, AV63ConceptoMotivosEgresoDeleted, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV151Pgmname, AV28egresoTLiqCod, AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV7Concepto", AV7Concepto);
      nGXsfl_247_bak_idx = nGXsfl_247_idx ;
      gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      nGXsfl_247_idx = nGXsfl_247_bak_idx ;
      sGXsfl_247_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2472( ) ;
   }

   public void e13AJ2( )
   {
      AV122GXV38 = (int)(nGXsfl_247_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
      if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
      }
      AV125GXV41 = (int)(nGXsfl_262_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
      if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
      }
      /* 'DoAddGridLineGridLevel_TipoLiquidacion' Routine */
      returnInSub = false ;
      if ( false )
      {
         AV21ConceptoTipoLiquidacionItem = (web.SdtConcepto_TipoLiquidacion)new web.SdtConcepto_TipoLiquidacion( remoteHandle, context);
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().add(AV21ConceptoTipoLiquidacionItem, 0);
         gx_BV247 = true ;
      }
      else
      {
         AV21ConceptoTipoLiquidacionItem = (web.SdtConcepto_TipoLiquidacion)new web.SdtConcepto_TipoLiquidacion( remoteHandle, context);
         AV21ConceptoTipoLiquidacionItem.setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion( "A0" );
         AV21ConceptoTipoLiquidacionItem.setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_SetNull();
         AV21ConceptoTipoLiquidacionItem.setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_SetNull();
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().add(AV21ConceptoTipoLiquidacionItem, 0);
         gx_BV247 = true ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV7Concepto", AV7Concepto);
      nGXsfl_247_bak_idx = nGXsfl_247_idx ;
      gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      nGXsfl_247_idx = nGXsfl_247_bak_idx ;
      sGXsfl_247_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2472( ) ;
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e14AJ2 ();
      if (returnInSub) return;
   }

   public void e14AJ2( )
   {
      AV122GXV38 = (int)(nGXsfl_247_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
      if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
      }
      AV125GXV41 = (int)(nGXsfl_262_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
      if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
      }
      /* Enter Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "DSP", "")) != 0 )
      {
         if ( ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "UPD", "")) == 0 ) )
         {
            GXt_char6 = "" ;
            GXv_char8[0] = GXt_char6 ;
            new web.sacaracentos2(remoteHandle, context).execute( AV7Concepto.getgxTv_SdtConcepto_Condescrip(), GXv_char8) ;
            conceptoabm_impl.this.GXt_char6 = GXv_char8[0] ;
            AV7Concepto.setgxTv_SdtConcepto_Condescripsinac( GXt_char6 );
            AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().sort(httpContext.getMessage( "MegCodigo, (ConMegSec)", ""));
            gx_BV262 = true ;
            AV78ultMegCodigo = "" ;
            AV79sdt_mot_egr.clear();
            AV153GXV67 = 1 ;
            while ( AV153GXV67 <= AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() )
            {
               AV76motivoEgresoItem = (web.SdtConcepto_MotivosEgreso)((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV153GXV67));
               if ( GXutil.strcmp(AV76motivoEgresoItem.getgxTv_SdtConcepto_MotivosEgreso_Megcodigo(), AV78ultMegCodigo) != 0 )
               {
                  AV80itemSdtMotEgr = (web.Sdtsdt_mot_egr_sdt_mot_egrItem)new web.Sdtsdt_mot_egr_sdt_mot_egrItem(remoteHandle, context);
                  AV80itemSdtMotEgr.setgxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo( AV76motivoEgresoItem.getgxTv_SdtConcepto_MotivosEgreso_Megcodigo() );
                  AV80itemSdtMotEgr.setgxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec( AV76motivoEgresoItem.getgxTv_SdtConcepto_MotivosEgreso_Conmegsec() );
                  AV79sdt_mot_egr.add(AV80itemSdtMotEgr, 0);
               }
               AV78ultMegCodigo = AV76motivoEgresoItem.getgxTv_SdtConcepto_MotivosEgreso_Megcodigo() ;
               AV153GXV67 = (int)(AV153GXV67+1) ;
            }
            AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().sort(httpContext.getMessage( "MegCodigo, ConMegSec", ""));
            gx_BV262 = true ;
            AV78ultMegCodigo = "" ;
            AV81ConMegSec = (short)(0) ;
            AV154GXV68 = 1 ;
            while ( AV154GXV68 <= AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() )
            {
               AV76motivoEgresoItem = (web.SdtConcepto_MotivosEgreso)((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV154GXV68));
               if ( GXutil.strcmp(AV76motivoEgresoItem.getgxTv_SdtConcepto_MotivosEgreso_Megcodigo(), AV78ultMegCodigo) != 0 )
               {
                  AV155GXV69 = 1 ;
                  while ( AV155GXV69 <= AV79sdt_mot_egr.size() )
                  {
                     AV80itemSdtMotEgr = (web.Sdtsdt_mot_egr_sdt_mot_egrItem)((web.Sdtsdt_mot_egr_sdt_mot_egrItem)AV79sdt_mot_egr.elementAt(-1+AV155GXV69));
                     if ( GXutil.strcmp(AV80itemSdtMotEgr.getgxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Megcodigo(), AV76motivoEgresoItem.getgxTv_SdtConcepto_MotivosEgreso_Megcodigo()) == 0 )
                     {
                        AV81ConMegSec = AV80itemSdtMotEgr.getgxTv_Sdtsdt_mot_egr_sdt_mot_egrItem_Conmegsec() ;
                        if (true) break;
                     }
                     AV155GXV69 = (int)(AV155GXV69+1) ;
                  }
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV151Pgmname, httpContext.getMessage( "ultimo ", "")+GXutil.trim( GXutil.str( AV76motivoEgresoItem.getgxTv_SdtConcepto_MotivosEgreso_Conmegsec(), 4, 0))) ;
               if ( AV76motivoEgresoItem.getgxTv_SdtConcepto_MotivosEgreso_Conmegsec() == 0 )
               {
                  AV81ConMegSec = (short)(AV81ConMegSec+1) ;
                  AV76motivoEgresoItem.setgxTv_SdtConcepto_MotivosEgreso_Conmegsec( AV81ConMegSec );
                  new web.msgdebug_prod(remoteHandle, context).execute( AV151Pgmname, httpContext.getMessage( "asigna &ConMegSec ", "")+GXutil.trim( GXutil.str( AV81ConMegSec, 4, 0))) ;
               }
               AV78ultMegCodigo = AV76motivoEgresoItem.getgxTv_SdtConcepto_MotivosEgreso_Megcodigo() ;
               AV154GXV68 = (int)(AV154GXV68+1) ;
            }
            gxgrgridlevel_motivos_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV7Concepto, AV63ConceptoMotivosEgresoDeleted, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV151Pgmname, AV28egresoTLiqCod, AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
            if ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", "")) == 0 )
            {
               AV7Concepto.setgxTv_SdtConcepto_Clipadre_SetNull();
               AV7Concepto.setgxTv_SdtConcepto_Conpadre_SetNull();
               GXv_int11[0] = AV82ConNumero ;
               new web.getnextconnumero(remoteHandle, context).execute( AV16CliCod, GXv_int11) ;
               conceptoabm_impl.this.AV82ConNumero = GXv_int11[0] ;
               AV7Concepto.setgxTv_SdtConcepto_Connumero( AV82ConNumero );
            }
            /* Execute user subroutine: 'VARIABLES A RANGO' */
            S252 ();
            if (returnInSub) return;
            if ( AV7Concepto.getgxTv_SdtConcepto_Convigencia() == 1 )
            {
               GXt_int12 = (byte)(0) ;
               GXv_int11[0] = GXt_int12 ;
               new web.determinaesbasicoporafip(remoteHandle, context).execute( AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), AV7Concepto.getgxTv_SdtConcepto_Consipaapo(), AV7Concepto.getgxTv_SdtConcepto_Consipacont(), AV7Concepto.getgxTv_SdtConcepto_Coninssjypapo(), AV7Concepto.getgxTv_SdtConcepto_Coninssjypcont(), AV7Concepto.getgxTv_SdtConcepto_Conobrasocapo(), AV7Concepto.getgxTv_SdtConcepto_Conobrasoccont(), AV7Concepto.getgxTv_SdtConcepto_Confonsolredapo(), AV7Concepto.getgxTv_SdtConcepto_Confonsolredcont(), AV7Concepto.getgxTv_SdtConcepto_Conrenateaapo(), AV7Concepto.getgxTv_SdtConcepto_Conrenateacont(), AV7Concepto.getgxTv_SdtConcepto_Conasigfamcont(), AV7Concepto.getgxTv_SdtConcepto_Confonnacempcont(), AV7Concepto.getgxTv_SdtConcepto_Conleyrietrabcont(), AV7Concepto.getgxTv_SdtConcepto_Conregdifapo(), AV7Concepto.getgxTv_SdtConcepto_Conregespapo(), GXv_int11) ;
               conceptoabm_impl.this.GXt_int12 = GXv_int11[0] ;
               AV7Concepto.setgxTv_SdtConcepto_Conliqbasica( GXt_int12 );
               AV7Concepto.setgxTv_SdtConcepto_Conmostrarpos( false );
               AV7Concepto.setgxTv_SdtConcepto_Conerrorsicero( true );
               AV7Concepto.setgxTv_SdtConcepto_Concondicion( "A0" );
               AV7Concepto.setgxTv_SdtConcepto_Concondcodigo( "" );
               AV7Concepto.setgxTv_SdtConcepto_Concondcodigo( "" );
               AV7Concepto.setgxTv_SdtConcepto_Conpuenov( false );
            }
            else
            {
               AV7Concepto.setgxTv_SdtConcepto_Conrangocant( "" );
               GXt_int12 = (byte)(0) ;
               GXv_int11[0] = GXt_int12 ;
               new web.determinaesbasicoporafip(remoteHandle, context).execute( AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), AV7Concepto.getgxTv_SdtConcepto_Consipaapo(), AV7Concepto.getgxTv_SdtConcepto_Consipacont(), AV7Concepto.getgxTv_SdtConcepto_Coninssjypapo(), AV7Concepto.getgxTv_SdtConcepto_Coninssjypcont(), AV7Concepto.getgxTv_SdtConcepto_Conobrasocapo(), AV7Concepto.getgxTv_SdtConcepto_Conobrasoccont(), AV7Concepto.getgxTv_SdtConcepto_Confonsolredapo(), AV7Concepto.getgxTv_SdtConcepto_Confonsolredcont(), AV7Concepto.getgxTv_SdtConcepto_Conrenateaapo(), AV7Concepto.getgxTv_SdtConcepto_Conrenateacont(), AV7Concepto.getgxTv_SdtConcepto_Conasigfamcont(), AV7Concepto.getgxTv_SdtConcepto_Confonnacempcont(), AV7Concepto.getgxTv_SdtConcepto_Conleyrietrabcont(), AV7Concepto.getgxTv_SdtConcepto_Conregdifapo(), AV7Concepto.getgxTv_SdtConcepto_Conregespapo(), GXv_int11) ;
               conceptoabm_impl.this.GXt_int12 = GXv_int11[0] ;
               AV7Concepto.setgxTv_SdtConcepto_Conliqbasica( GXt_int12 );
               GXt_boolean3 = false ;
               GXv_boolean4[0] = GXt_boolean3 ;
               new web.getcondicionbasica(remoteHandle, context).execute( AV7Concepto.getgxTv_SdtConcepto_Concondicion(), GXv_boolean4) ;
               conceptoabm_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
               AV7Concepto.setgxTv_SdtConcepto_Conliqbasica( (byte)((GXt_boolean3 ? 1 : 0)) );
            }
            if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "CAL_ARG") != 0 )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conrecalcular( false );
               if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
               {
                  AV7Concepto.setgxTv_SdtConcepto_Apliigg_SetNull();
               }
            }
            else
            {
               AV7Concepto.setgxTv_SdtConcepto_Conrangocant( "" );
               AV7Concepto.setgxTv_SdtConcepto_Conmostrarpos( false );
               AV7Concepto.setgxTv_SdtConcepto_Conerrorsicero( false );
               AV7Concepto.setgxTv_SdtConcepto_Conadeldescu( (byte)(0) );
               AV7Concepto.setgxTv_SdtConcepto_Concodafip( "" );
               AV7Concepto.setgxTv_SdtConcepto_Convariable( false );
            }
            if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG") == 0 )
            {
               AV7Concepto.setgxTv_SdtConcepto_Contipoorden( (short)(1) );
            }
            else if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "NRE_ARG") == 0 )
            {
               AV7Concepto.setgxTv_SdtConcepto_Contipoorden( (short)(2) );
            }
            else if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
            {
               AV7Concepto.setgxTv_SdtConcepto_Contipoorden( (short)(3) );
            }
            else
            {
               AV7Concepto.setgxTv_SdtConcepto_Contipoorden( (short)(4) );
            }
         }
         AV69palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV7Concepto.getgxTv_SdtConcepto_Condescrip()," ")) ;
         AV7Concepto.setgxTv_SdtConcepto_Concntpa( (byte)(AV69palabras.size()) );
         if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Conceptoconvecodigo())==0) )
         {
            AV7Concepto.setgxTv_SdtConcepto_Conceptoconvecodigo_SetNull();
            AV7Concepto.setgxTv_SdtConcepto_Conceptopais_SetNull();
         }
         else
         {
            AV7Concepto.setgxTv_SdtConcepto_Conceptopais( AV27PaiCod );
         }
         if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod1())==0) )
         {
            AV7Concepto.setgxTv_SdtConcepto_Subtipoconcod1_SetNull();
         }
         if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod2())==0) )
         {
            AV7Concepto.setgxTv_SdtConcepto_Subtipoconcod2_SetNull();
         }
         if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Concuendebe())==0) )
         {
            AV7Concepto.setgxTv_SdtConcepto_Concuendebe_SetNull();
         }
         if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Concuenhaber())==0) )
         {
            AV7Concepto.setgxTv_SdtConcepto_Concuenhaber_SetNull();
         }
         if ( (0==AV7Concepto.getgxTv_SdtConcepto_Apliigg()) || ( ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG") != 0 ) && ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "NRE_ARG") != 0 ) ) )
         {
            AV7Concepto.setgxTv_SdtConcepto_Apliigg_SetNull();
         }
      }
      if ( GXutil.strcmp(AV12TrnMode, "DSP") != 0 )
      {
         if ( GXutil.strcmp(AV12TrnMode, "DLT") != 0 )
         {
            /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
            S262 ();
            if (returnInSub) return;
         }
         if ( ( GXutil.strcmp(AV12TrnMode, "DLT") == 0 ) || AV14CheckRequiredFieldsResult )
         {
            if ( GXutil.strcmp(AV12TrnMode, "DLT") == 0 )
            {
               AV7Concepto.Delete();
               gx_BV247 = true ;
            }
            else
            {
               AV63ConceptoMotivosEgresoDeleted.sort("");
               while ( AV63ConceptoMotivosEgresoDeleted.size() > 0 )
               {
                  AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().removeItem(((Number) AV63ConceptoMotivosEgresoDeleted.elementAt(-1+AV63ConceptoMotivosEgresoDeleted.size())).shortValue());
                  gx_BV262 = true ;
                  AV63ConceptoMotivosEgresoDeleted.removeItem(AV63ConceptoMotivosEgresoDeleted.size());
               }
               AV22ConceptoTipoLiquidacionDeleted.sort("");
               while ( AV22ConceptoTipoLiquidacionDeleted.size() > 0 )
               {
                  AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().removeItem(((Number) AV22ConceptoTipoLiquidacionDeleted.elementAt(-1+AV22ConceptoTipoLiquidacionDeleted.size())).shortValue());
                  gx_BV247 = true ;
                  AV22ConceptoTipoLiquidacionDeleted.removeItem(AV22ConceptoTipoLiquidacionDeleted.size());
               }
               AV7Concepto.Save();
               gx_BV247 = true ;
            }
            if ( AV7Concepto.Success() )
            {
               /* Execute user subroutine: 'AFTER_TRN' */
               S272 ();
               if (returnInSub) return;
            }
            else
            {
               AV11Messages = AV7Concepto.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV7Concepto", AV7Concepto);
      nGXsfl_247_bak_idx = nGXsfl_247_idx ;
      gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      nGXsfl_247_idx = nGXsfl_247_bak_idx ;
      sGXsfl_247_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2472( ) ;
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV63ConceptoMotivosEgresoDeleted", AV63ConceptoMotivosEgresoDeleted);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV22ConceptoTipoLiquidacionDeleted", AV22ConceptoTipoLiquidacionDeleted);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV11Messages", AV11Messages);
   }

   public void e27AJ2( )
   {
      AV122GXV38 = (int)(nGXsfl_247_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
      if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
      }
      AV125GXV41 = (int)(nGXsfl_262_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
      if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
      }
      /* Deletegridlinegridlevel_motivos_Click Routine */
      returnInSub = false ;
      AV19Index = (short)(AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().indexof(((web.SdtConcepto_MotivosEgreso)(AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem())))) ;
      if ( AV63ConceptoMotivosEgresoDeleted.indexof(AV19Index) > 0 )
      {
         AV63ConceptoMotivosEgresoDeleted.removeItem(AV63ConceptoMotivosEgresoDeleted.indexof(AV19Index));
      }
      else
      {
         AV63ConceptoMotivosEgresoDeleted.add((short)(AV19Index), 0);
      }
      gxgrgridlevel_motivos_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV7Concepto, AV63ConceptoMotivosEgresoDeleted, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV151Pgmname, AV28egresoTLiqCod, AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV63ConceptoMotivosEgresoDeleted", AV63ConceptoMotivosEgresoDeleted);
   }

   public void e23AJ2( )
   {
      AV122GXV38 = (int)(nGXsfl_247_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
      if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
      }
      AV125GXV41 = (int)(nGXsfl_262_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
      if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
      }
      /* Deletegridlinegridlevel_tipoliquidacion_Click Routine */
      returnInSub = false ;
      AV19Index = (short)(AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().indexof(((web.SdtConcepto_TipoLiquidacion)(AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem())))) ;
      if ( AV22ConceptoTipoLiquidacionDeleted.indexof(AV19Index) > 0 )
      {
         AV22ConceptoTipoLiquidacionDeleted.removeItem(AV22ConceptoTipoLiquidacionDeleted.indexof(AV19Index));
      }
      else
      {
         AV22ConceptoTipoLiquidacionDeleted.add((short)(AV19Index), 0);
      }
      gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV22ConceptoTipoLiquidacionDeleted", AV22ConceptoTipoLiquidacionDeleted);
   }

   public void S242( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(AV12TrnMode, "DSP") != 0 ) ) )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      }
      if ( ! ( ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) || ( GXutil.strcmp(AV12TrnMode, "UPD") == 0 ) ) )
      {
         bttBtnaddgridlinegridlevel_motivosegreso_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnaddgridlinegridlevel_motivosegreso_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnaddgridlinegridlevel_motivosegreso_Visible), 5, 0), true);
      }
      if ( ! ( ( ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) || ( GXutil.strcmp(AV12TrnMode, "UPD") == 0 ) ) && ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) ) ) )
      {
         bttBtnaddgridlinegridlevel_motivos_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnaddgridlinegridlevel_motivos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnaddgridlinegridlevel_motivos_Visible), 5, 0), true);
      }
      if ( ! ( ( ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) || ( GXutil.strcmp(AV12TrnMode, "UPD") == 0 ) ) && ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( AV26permiteModificacion ) ) ) )
      {
         bttBtnaddgridlinegridlevel_tipoliquidacion_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnaddgridlinegridlevel_tipoliquidacion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnaddgridlinegridlevel_tipoliquidacion_Visible), 5, 0), true);
      }
   }

   public void S262( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV14CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14CheckRequiredFieldsResult", AV14CheckRequiredFieldsResult);
      if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Tipoconcod())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "error", cmbavConcepto_tipoconcod.getInternalname(), "true", ""));
         AV14CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14CheckRequiredFieldsResult", AV14CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod1())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Clasificación", ""), "", "", "", "", "", "", "", ""), "error", cmbavConcepto_subtipoconcod1.getInternalname(), "true", ""));
         AV14CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14CheckRequiredFieldsResult", AV14CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Concodigo())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Código", ""), "", "", "", "", "", "", "", ""), "error", edtavConcepto_concodigo_Internalname, "true", ""));
         AV14CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14CheckRequiredFieldsResult", AV14CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Condescrip())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Descripción", ""), "", "", "", "", "", "", "", ""), "error", edtavConcepto_condescrip_Internalname, "true", ""));
         AV14CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14CheckRequiredFieldsResult", AV14CheckRequiredFieldsResult);
      }
      if ( ( ( AV25esSistemaConceptosDefault ) || ( AV67ClienteConveniador ) ) && (0==AV7Concepto.getgxTv_SdtConcepto_Conrelsec()) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha de liberación", ""), "", "", "", "", "", "", "", ""), "error", dynavConcepto_conrelsec.getInternalname(), "true", ""));
         AV14CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14CheckRequiredFieldsResult", AV14CheckRequiredFieldsResult);
      }
      if ( ( ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "CAL_ARG") != 0 ) ) && (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Concodafip())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Concepto AFIP", ""), "", "", "", "", "", "", "", ""), "error", edtavConcepto_concodafip_Internalname, "true", ""));
         AV14CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14CheckRequiredFieldsResult", AV14CheckRequiredFieldsResult);
      }
      if ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() == 0 )
      {
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Debe ingresar al menos 1 tipo de liquidación", "")) ;
         AV14CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14CheckRequiredFieldsResult", AV14CheckRequiredFieldsResult);
      }
      if ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", "")) == 0 )
      {
         GXv_boolean4[0] = AV29duplicado ;
         new web.existeconcepto(remoteHandle, context).execute( AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Concodigo(), GXv_boolean4) ;
         conceptoabm_impl.this.AV29duplicado = GXv_boolean4[0] ;
         if ( AV29duplicado )
         {
            httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", httpContext.getMessage( "El concepto ", "")+GXutil.trim( AV7Concepto.getgxTv_SdtConcepto_Concodigo())+httpContext.getMessage( " ya existe", ""), "error", edtavConcepto_concodigo_Internalname, "true", ""));
            AV14CheckRequiredFieldsResult = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14CheckRequiredFieldsResult", AV14CheckRequiredFieldsResult);
         }
      }
      if ( AV67ClienteConveniador )
      {
         if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Conceptoconvecodigo())==0) )
         {
            new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Debe ingresar convenio", "")) ;
            AV14CheckRequiredFieldsResult = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14CheckRequiredFieldsResult", AV14CheckRequiredFieldsResult);
         }
         else
         {
            GXv_boolean4[0] = AV70CliConveHab ;
            new web.getclienteconveniohab(remoteHandle, context).execute( AV16CliCod, AV27PaiCod, AV7Concepto.getgxTv_SdtConcepto_Conceptoconvecodigo(), GXv_boolean4) ;
            conceptoabm_impl.this.AV70CliConveHab = GXv_boolean4[0] ;
            if ( ! AV70CliConveHab )
            {
               new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "El convenio ", "")+AV7Concepto.getgxTv_SdtConcepto_Conceptoconvecodigo()+httpContext.getMessage( " es inválido", "")) ;
               AV14CheckRequiredFieldsResult = false ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14CheckRequiredFieldsResult", AV14CheckRequiredFieldsResult);
            }
         }
      }
      if ( ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "UPD", "")) == 0 ) )
      {
         GXv_boolean4[0] = AV74aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conrelsec(), GXv_boolean4) ;
         conceptoabm_impl.this.AV74aplicadoHay = GXv_boolean4[0] ;
         if ( AV74aplicadoHay )
         {
            new web.alert(remoteHandle, context).execute( "error", new web.txterrorrelease(remoteHandle, context).executeUdp( AV16CliCod)) ;
            AV14CheckRequiredFieldsResult = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14CheckRequiredFieldsResult", AV14CheckRequiredFieldsResult);
         }
      }
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "CAL_ARG") != 0 )
      {
         divConcepto_concodafip_cell_Class = "col-xs-12 RequiredDataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConcepto_concodafip_cell_Internalname, "Class", divConcepto_concodafip_cell_Class, true);
      }
      else
      {
         divConcepto_concodafip_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConcepto_concodafip_cell_Internalname, "Class", divConcepto_concodafip_cell_Class, true);
      }
      if ( ( AV25esSistemaConceptosDefault ) || ( AV67ClienteConveniador ) )
      {
         divConcepto_conrelsec_cell_Class = "col-xs-12 RequiredDataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConcepto_conrelsec_cell_Internalname, "Class", divConcepto_conrelsec_cell_Class, true);
      }
      else
      {
         divConcepto_conrelsec_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConcepto_conrelsec_cell_Internalname, "Class", divConcepto_conrelsec_cell_Class, true);
      }
      if ( ! ( false ) )
      {
         divDvpanel_unnamedtable4_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divDvpanel_unnamedtable4_cell_Internalname, "Class", divDvpanel_unnamedtable4_cell_Class, true);
      }
      else
      {
         divDvpanel_unnamedtable4_cell_Class = "col-xs-12" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divDvpanel_unnamedtable4_cell_Internalname, "Class", divDvpanel_unnamedtable4_cell_Class, true);
      }
   }

   public void S112( )
   {
      /* 'SHOW MESSAGES' Routine */
      returnInSub = false ;
      AV156GXV70 = 1 ;
      while ( AV156GXV70 <= AV11Messages.size() )
      {
         AV10Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV11Messages.elementAt(-1+AV156GXV70));
         httpContext.GX_msglist.addItem(AV10Message.getgxTv_SdtMessages_Message_Description());
         AV156GXV70 = (int)(AV156GXV70+1) ;
      }
   }

   public void S272( )
   {
      /* 'AFTER_TRN' Routine */
      returnInSub = false ;
      if ( true )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "conceptoabm");
         if ( ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "DLT", "")) != 0 ) && ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "DSP", "")) != 0 ) )
         {
            new web.conceptograbarrelref(remoteHandle, context).execute( AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Concodigo()) ;
            new web.ajustartiposliq(remoteHandle, context).execute( AV16CliCod, (short)(0), AV7Concepto.getgxTv_SdtConcepto_Concodigo(), "") ;
            new web.grabatipoliqaux(remoteHandle, context).execute( AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Concodigo()) ;
            new web.actualizarrecalculaendetalles(remoteHandle, context).execute( AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Concodigo(), AV30viejoConRecalcular, AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV60viejoAplIIGG, AV7Concepto.getgxTv_SdtConcepto_Apliigg()) ;
            new web.setlegrecalcularliq(remoteHandle, context).execute( AV16CliCod, AV32EmpCod, 0, true) ;
         }
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      else
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "conceptoabm");
      }
   }

   public void e24AJ2( )
   {
      /* Gridlevel_tipoliquidacion_Refresh Routine */
      returnInSub = false ;
      divTableleaflevel_motivosegreso_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTableleaflevel_motivosegreso_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableleaflevel_motivosegreso_Visible), 5, 0), true);
      /*  Sending Event outputs  */
   }

   public void e15AJ2( )
   {
      AV122GXV38 = (int)(nGXsfl_247_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
      if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
      }
      AV125GXV41 = (int)(nGXsfl_262_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
      if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
      }
      /* Concepto_convariable_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'TEXTOS BASE' */
      S152 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e16AJ2( )
   {
      AV122GXV38 = (int)(nGXsfl_247_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
      if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
      }
      AV125GXV41 = (int)(nGXsfl_262_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
      if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
      }
      /* Concepto_tipoconcod_Click Routine */
      returnInSub = false ;
      AV7Concepto.setgxTv_SdtConcepto_Subtipoconcod1( "" );
      AV7Concepto.setgxTv_SdtConcepto_Subtipoconcod2( "" );
      /* Execute user subroutine: 'VISIBILIDAD VARIABLE' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'VISIBILIDAD APLICA GANANCIAS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'VISIBILIDAD RECALCULAR' */
      S172 ();
      if (returnInSub) return;
      GXv_char8[0] = AV7Concepto.getgxTv_SdtConcepto_Concodigo() ;
      new web.proximoconcodigo(remoteHandle, context).execute( AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), GXv_char8) ;
      AV7Concepto.setgxTv_SdtConcepto_Concodigo( GXv_char8[0] );
      /* Execute user subroutine: 'COMBO SUBTIPO 1' */
      S182 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'COMBO SUBTIPO 2' */
      S192 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ACTUALIZAR PERMISIBLES' */
      S212 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SACDEVEN VISIBLE' */
      S222 ();
      if (returnInSub) return;
      GXv_int9[0] = AV7Concepto.getgxTv_SdtConcepto_Conorden() ;
      GXv_int10[0] = AV7Concepto.getgxTv_SdtConcepto_Conordejec() ;
      new web.defaultordenconcepto(remoteHandle, context).execute( AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), GXv_int9, GXv_int10) ;
      AV7Concepto.setgxTv_SdtConcepto_Conorden( GXv_int9[0] );
      AV7Concepto.setgxTv_SdtConcepto_Conordejec( GXv_int10[0] );
      /* Execute user subroutine: 'AFIP DEFAULT' */
      S162 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV7Concepto", AV7Concepto);
      nGXsfl_247_bak_idx = nGXsfl_247_idx ;
      gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      nGXsfl_247_idx = nGXsfl_247_bak_idx ;
      sGXsfl_247_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2472( ) ;
      cmbavConcepto_subtipoconcod1.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod1()) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_subtipoconcod1.getInternalname(), "Values", cmbavConcepto_subtipoconcod1.ToJavascriptSource(), true);
      cmbavConcepto_subtipoconcod2.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod2()) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_subtipoconcod2.getInternalname(), "Values", cmbavConcepto_subtipoconcod2.ToJavascriptSource(), true);
   }

   public void e17AJ2( )
   {
      AV122GXV38 = (int)(nGXsfl_247_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
      if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
      }
      AV125GXV41 = (int)(nGXsfl_262_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
      if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
      }
      /* Concepto_subtipoconcod1_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'COMBO SUBTIPO 2' */
      S192 ();
      if (returnInSub) return;
      AV68vieneDeClick = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68vieneDeClick", AV68vieneDeClick);
      /* Execute user subroutine: 'AFIP DEFAULT' */
      S162 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavConcepto_subtipoconcod2.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod2()) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_subtipoconcod2.getInternalname(), "Values", cmbavConcepto_subtipoconcod2.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV7Concepto", AV7Concepto);
      nGXsfl_247_bak_idx = nGXsfl_247_idx ;
      gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      nGXsfl_247_idx = nGXsfl_247_bak_idx ;
      sGXsfl_247_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2472( ) ;
   }

   public void e18AJ2( )
   {
      AV122GXV38 = (int)(nGXsfl_247_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
      if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
      }
      AV125GXV41 = (int)(nGXsfl_262_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
      if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
      }
      /* Concepto_subtipoconcod2_Click Routine */
      returnInSub = false ;
      AV68vieneDeClick = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68vieneDeClick", AV68vieneDeClick);
      /* Execute user subroutine: 'AFIP DEFAULT' */
      S162 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV7Concepto", AV7Concepto);
      nGXsfl_247_bak_idx = nGXsfl_247_idx ;
      gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      nGXsfl_247_idx = nGXsfl_247_bak_idx ;
      sGXsfl_247_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2472( ) ;
   }

   public void e25AJ2( )
   {
      AV122GXV38 = (int)(nGXsfl_247_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
      if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
      }
      AV125GXV41 = (int)(nGXsfl_262_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
      if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
      }
      /* Concepto_tipoliquidacion__tliqcod_Click Routine */
      returnInSub = false ;
      cmbavConcepto_tipoliquidacion__contltipegr.setVisible( (((GXutil.strcmp(((web.SdtConcepto_TipoLiquidacion)(AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem())).getgxTv_SdtConcepto_TipoLiquidacion_Tliqcod(), AV28egresoTLiqCod)==0)) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_tipoliquidacion__contltipegr.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_tipoliquidacion__contltipegr.getVisible(), 5, 0), !bGXsfl_247_Refreshing);
      /*  Sending Event outputs  */
   }

   public void e19AJ2( )
   {
      AV122GXV38 = (int)(nGXsfl_247_idx+GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage) ;
      if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().currentItem( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)) );
      }
      AV125GXV41 = (int)(nGXsfl_262_idx+GRIDLEVEL_MOTIVOS_nFirstRecordOnPage) ;
      if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) )
      {
         AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
      }
      /* Concepto_concodafip_Isvalid Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ACTUALIZAR PERMISIBLES' */
      S212 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV7Concepto", AV7Concepto);
      nGXsfl_247_bak_idx = nGXsfl_247_idx ;
      gxgrgridlevel_tipoliquidacion_refresh( subGridlevel_tipoliquidacion_Rows, subGridlevel_motivos_Rows, AV12TrnMode, Gx_mode, AV26permiteModificacion, AV151Pgmname, AV7Concepto, AV22ConceptoTipoLiquidacionDeleted, AV28egresoTLiqCod, AV16CliCod, AV7Concepto.getgxTv_SdtConcepto_Conpuenov(), AV7Concepto.getgxTv_SdtConcepto_Convariable(), AV7Concepto.getgxTv_SdtConcepto_Conhabilitado(), AV7Concepto.getgxTv_SdtConcepto_Conrecalcular(), AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos(), AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero(), AV7Concepto.getgxTv_SdtConcepto_Consegunpla(), AV25esSistemaConceptosDefault, AV67ClienteConveniador, AV30viejoConRecalcular, AV60viejoAplIIGG, AV39ConAFIPSIPAApo, AV27PaiCod, AV32EmpCod, sPrefix) ;
      nGXsfl_247_idx = nGXsfl_247_bak_idx ;
      sGXsfl_247_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2472( ) ;
   }

   public void S172( )
   {
      /* 'VISIBILIDAD RECALCULAR' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "CAL_ARG") == 0 )
      {
         chkavConcepto_conrecalcular.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conrecalcular.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_conrecalcular.getVisible(), 5, 0), true);
         divTablerango_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablerango_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablerango_Visible), 5, 0), true);
         chkavConcepto_conmostrarpos.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conmostrarpos.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_conmostrarpos.getVisible(), 5, 0), true);
         chkavConcepto_conerrorsicero.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conerrorsicero.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_conerrorsicero.getVisible(), 5, 0), true);
         cmbavConcepto_conadeldescu.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conadeldescu.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conadeldescu.getVisible(), 5, 0), true);
      }
      else
      {
         chkavConcepto_conrecalcular.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conrecalcular.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_conrecalcular.getVisible(), 5, 0), true);
         AV7Concepto.setgxTv_SdtConcepto_Conrecalcular( false );
         divTablerango_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablerango_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablerango_Visible), 5, 0), true);
         chkavConcepto_conmostrarpos.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conmostrarpos.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_conmostrarpos.getVisible(), 5, 0), true);
         chkavConcepto_conerrorsicero.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conerrorsicero.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_conerrorsicero.getVisible(), 5, 0), true);
         cmbavConcepto_conadeldescu.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conadeldescu.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conadeldescu.getVisible(), 5, 0), true);
      }
   }

   public void S132( )
   {
      /* 'VISIBILIDAD VARIABLE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "CAL_ARG") == 0 )
      {
         edtavConcepto_concodafip_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_concodafip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_concodafip_Enabled), 5, 0), true);
         chkavConcepto_convariable.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_convariable.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_convariable.getVisible(), 5, 0), true);
      }
      else
      {
         edtavConcepto_concodafip_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_concodafip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_concodafip_Enabled), 5, 0), true);
         chkavConcepto_convariable.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_convariable.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_convariable.getVisible(), 5, 0), true);
      }
   }

   public void S152( )
   {
      /* 'TEXTOS BASE' Routine */
      returnInSub = false ;
      cmbavConcepto_conbaselicprom.setVisible( (AV7Concepto.getgxTv_SdtConcepto_Convariable() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaselicprom.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbaselicprom.getVisible(), 5, 0), true);
      cmbavConcepto_conbaseferprom.setVisible( (AV7Concepto.getgxTv_SdtConcepto_Convariable() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseferprom.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbaseferprom.getVisible(), 5, 0), true);
      cmbavConcepto_conbasehorextprom.setVisible( (AV7Concepto.getgxTv_SdtConcepto_Convariable() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasehorextprom.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbasehorextprom.getVisible(), 5, 0), true);
      cmbavConcepto_conbaselic.setCaption( httpContext.getMessage( "Base de cálculo para licencias de remuneración fija", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaselic.getInternalname(), "Caption", cmbavConcepto_conbaselic.getCaption(), true);
      cmbavConcepto_conbasefer.setCaption( httpContext.getMessage( "Base de cálculo para feriados de remuneración fija ", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasefer.getInternalname(), "Caption", cmbavConcepto_conbasefer.getCaption(), true);
      cmbavConcepto_conbasepres.setCaption( httpContext.getMessage( "Base de cálculo para presentismo", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasepres.getInternalname(), "Caption", cmbavConcepto_conbasepres.getCaption(), true);
      cmbavConcepto_conbaseant.setCaption( httpContext.getMessage( "Base de cálculo para antiguedad", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseant.getInternalname(), "Caption", cmbavConcepto_conbaseant.getCaption(), true);
      if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod1(), new web.subtipoextras(remoteHandle, context).executeUdp( )) == 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         cmbavConcepto_conbaselic.setCaption( cmbavConcepto_conbaselic.getCaption()+httpContext.getMessage( " (porción normal sin el extra)", "") );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaselic.getInternalname(), "Caption", cmbavConcepto_conbaselic.getCaption(), true);
         cmbavConcepto_conbasefer.setCaption( cmbavConcepto_conbasefer.getCaption()+httpContext.getMessage( " (porción normal sin el extra)", "") );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasefer.getInternalname(), "Caption", cmbavConcepto_conbasefer.getCaption(), true);
         cmbavConcepto_conbasepres.setCaption( cmbavConcepto_conbasepres.getCaption()+httpContext.getMessage( " (porción normal sin el extra)", "") );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasepres.getInternalname(), "Caption", cmbavConcepto_conbasepres.getCaption(), true);
         cmbavConcepto_conbaseant.setCaption( cmbavConcepto_conbaseant.getCaption()+httpContext.getMessage( " (porción normal sin el extra)", "") );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseant.getInternalname(), "Caption", cmbavConcepto_conbaseant.getCaption(), true);
      }
   }

   public void S142( )
   {
      /* 'VISIBILIDAD APLICA GANANCIAS' Routine */
      returnInSub = false ;
      dynavConcepto_apliigg.setVisible( (((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG")!=0)) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_apliigg.getInternalname(), "Visible", GXutil.ltrimstr( dynavConcepto_apliigg.getVisible(), 5, 0), true);
   }

   public void S182( )
   {
      /* 'COMBO SUBTIPO 1' Routine */
      returnInSub = false ;
      cmbavConcepto_subtipoconcod1.removeAllItems();
      GXv_objcol_Sdtsdt_subtipos_sdt_subtiposItem13[0] = AV35sdt_subtipos ;
      new web.subtipos1(remoteHandle, context).execute( AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), GXv_objcol_Sdtsdt_subtipos_sdt_subtiposItem13) ;
      AV35sdt_subtipos = GXv_objcol_Sdtsdt_subtipos_sdt_subtiposItem13[0] ;
      AV157GXV71 = 1 ;
      while ( AV157GXV71 <= AV35sdt_subtipos.size() )
      {
         AV37itemSdt_Subtipos = (web.Sdtsdt_subtipos_sdt_subtiposItem)((web.Sdtsdt_subtipos_sdt_subtiposItem)AV35sdt_subtipos.elementAt(-1+AV157GXV71));
         cmbavConcepto_subtipoconcod1.addItem(AV37itemSdt_Subtipos.getgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1(), AV37itemSdt_Subtipos.getgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1(), (short)(0));
         if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod1())==0) && ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", "")) == 0 ) )
         {
            AV7Concepto.setgxTv_SdtConcepto_Subtipoconcod1( AV37itemSdt_Subtipos.getgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1() );
         }
         AV157GXV71 = (int)(AV157GXV71+1) ;
      }
   }

   public void S192( )
   {
      /* 'COMBO SUBTIPO 2' Routine */
      returnInSub = false ;
      cmbavConcepto_subtipoconcod2.removeAllItems();
      cmbavConcepto_subtipoconcod2.addItem("", httpContext.getMessage( "(Ninguno)", ""), (short)(0));
      GXv_objcol_Sdtsdt_subtipos_sdt_subtiposItem13[0] = AV35sdt_subtipos ;
      new web.subtipos2(remoteHandle, context).execute( AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod1(), GXv_objcol_Sdtsdt_subtipos_sdt_subtiposItem13) ;
      AV35sdt_subtipos = GXv_objcol_Sdtsdt_subtipos_sdt_subtiposItem13[0] ;
      AV158GXV72 = 1 ;
      while ( AV158GXV72 <= AV35sdt_subtipos.size() )
      {
         AV37itemSdt_Subtipos = (web.Sdtsdt_subtipos_sdt_subtiposItem)((web.Sdtsdt_subtipos_sdt_subtiposItem)AV35sdt_subtipos.elementAt(-1+AV158GXV72));
         cmbavConcepto_subtipoconcod2.addItem(AV37itemSdt_Subtipos.getgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1(), AV37itemSdt_Subtipos.getgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1(), (short)(0));
         if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod2())==0) && ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", "")) == 0 ) )
         {
            AV7Concepto.setgxTv_SdtConcepto_Subtipoconcod2( AV37itemSdt_Subtipos.getgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1() );
         }
         AV158GXV72 = (int)(AV158GXV72+1) ;
      }
   }

   public void S232( )
   {
      /* 'RANGO A VARIABLES' Routine */
      returnInSub = false ;
      if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Conrangocant())==0) )
      {
         AV71RangoDesde = DecimalUtil.ZERO ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71RangoDesde", GXutil.ltrimstr( AV71RangoDesde, 14, 2));
         AV72RangoHasta = DecimalUtil.ZERO ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72RangoHasta", GXutil.ltrimstr( AV72RangoHasta, 14, 2));
      }
      else
      {
         AV73auxRangoPalabra.fromJSonString(AV7Concepto.getgxTv_SdtConcepto_Conrangocant(), null);
         if ( AV73auxRangoPalabra.size() > 0 )
         {
            AV71RangoDesde = CommonUtil.decimalVal( (String)AV73auxRangoPalabra.elementAt(-1+1), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71RangoDesde", GXutil.ltrimstr( AV71RangoDesde, 14, 2));
            AV72RangoHasta = CommonUtil.decimalVal( (String)AV73auxRangoPalabra.elementAt(-1+AV73auxRangoPalabra.size()), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72RangoHasta", GXutil.ltrimstr( AV72RangoHasta, 14, 2));
         }
      }
   }

   public void S252( )
   {
      /* 'VARIABLES A RANGO' Routine */
      returnInSub = false ;
      AV73auxRangoPalabra.clear();
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71RangoDesde)==0) || ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72RangoHasta)==0) )
      {
         AV73auxRangoPalabra.add(GXutil.trim( GXutil.str( AV71RangoDesde, 14, 2)), 0);
         if ( DecimalUtil.compareTo(AV72RangoHasta, AV71RangoDesde) != 0 )
         {
            AV73auxRangoPalabra.add(GXutil.trim( GXutil.str( AV72RangoHasta, 14, 2)), 0);
         }
         AV7Concepto.setgxTv_SdtConcepto_Conrangocant( AV73auxRangoPalabra.toJSonString(false) );
      }
      else
      {
         AV7Concepto.setgxTv_SdtConcepto_Conrangocant( "" );
      }
   }

   public void S202( )
   {
      /* 'VISIBILIDAD CONDICION' Routine */
      returnInSub = false ;
      if ( AV7Concepto.getgxTv_SdtConcepto_Convigencia() == 1 )
      {
         AV7Concepto.setgxTv_SdtConcepto_Concondicion( "A0" );
         AV7Concepto.setgxTv_SdtConcepto_Concondcodigo( "" );
         cmbavConcepto_concondicion.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_concondicion.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_concondicion.getVisible(), 5, 0), true);
         edtavConcepto_concondcodigo_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_concondcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_concondcodigo_Visible), 5, 0), true);
         chkavConcepto_conmostrarpos.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conmostrarpos.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_conmostrarpos.getVisible(), 5, 0), true);
         chkavConcepto_conerrorsicero.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conerrorsicero.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_conerrorsicero.getVisible(), 5, 0), true);
         chkavConcepto_conpuenov.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conpuenov.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_conpuenov.getVisible(), 5, 0), true);
         divTablerango_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablerango_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablerango_Visible), 5, 0), true);
      }
      else
      {
         cmbavConcepto_concondicion.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_concondicion.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_concondicion.getVisible(), 5, 0), true);
         edtavConcepto_concondcodigo_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcepto_concondcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_concondcodigo_Visible), 5, 0), true);
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "CAL_ARG") != 0 )
         {
            chkavConcepto_conmostrarpos.setVisible( 1 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conmostrarpos.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_conmostrarpos.getVisible(), 5, 0), true);
         }
         else
         {
            chkavConcepto_conmostrarpos.setVisible( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conmostrarpos.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_conmostrarpos.getVisible(), 5, 0), true);
         }
         chkavConcepto_conerrorsicero.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conerrorsicero.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_conerrorsicero.getVisible(), 5, 0), true);
         chkavConcepto_conpuenov.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conpuenov.getInternalname(), "Visible", GXutil.ltrimstr( chkavConcepto_conpuenov.getVisible(), 5, 0), true);
         divTablerango_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablerango_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablerango_Visible), 5, 0), true);
      }
   }

   public void S162( )
   {
      /* 'AFIP DEFAULT' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV151Pgmname, httpContext.getMessage( "AFIP default 1", "")) ;
      AV7Concepto.setgxTv_SdtConcepto_Concodafip( "" );
      if ( (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Concodafip())==0) )
      {
         if ( ( GXutil.strcmp(AV12TrnMode, httpContext.getMessage( "INS", "")) == 0 ) || ( AV68vieneDeClick ) )
         {
            if ( ! (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod2())==0) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Concodafip( GXutil.trim( AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod2()) );
               new web.msgdebug_prod(remoteHandle, context).execute( AV151Pgmname, httpContext.getMessage( "AFIP default 2 &ConAFIPConcepto ", "")+GXutil.trim( AV7Concepto.getgxTv_SdtConcepto_Concodafip())) ;
            }
            else
            {
               if ( ! (GXutil.strcmp("", AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod1())==0) )
               {
                  AV7Concepto.setgxTv_SdtConcepto_Concodafip( GXutil.trim( AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod1()) );
               }
            }
         }
      }
   }

   public void S212( )
   {
      /* 'ACTUALIZAR PERMISIBLES' Routine */
      returnInSub = false ;
      AV54aplicaAlgo = false ;
      GXv_char8[0] = AV56ConAfipSubT1 ;
      new web.getsubtipo1por2(remoteHandle, context).execute( AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), AV7Concepto.getgxTv_SdtConcepto_Concodafip(), GXv_char8) ;
      conceptoabm_impl.this.AV56ConAfipSubT1 = GXv_char8[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV151Pgmname, httpContext.getMessage( "permis &ConAfipSubT1 ", "")+AV56ConAfipSubT1+httpContext.getMessage( " &&Concepto.ConCodAfip ", "")+AV7Concepto.getgxTv_SdtConcepto_Concodafip()+httpContext.getMessage( "  &Concepto.TipoConCod ", "")+AV7Concepto.getgxTv_SdtConcepto_Tipoconcod()) ;
      if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "CAL_ARG") != 0 )
      {
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_consipaapo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consipaapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_consipaapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Consipaapo( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_consipaapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consipaapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_consipaapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Consipaapo( (byte)(((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG")==0) ? 1 : 0)) );
               new web.msgdebug_prod(remoteHandle, context).execute( AV151Pgmname, httpContext.getMessage( "default &ConAFIPSIPAApo ", "")+AV39ConAFIPSIPAApo) ;
            }
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_consipacont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consipacont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_consipacont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Consipacont( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_consipacont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consipacont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_consipacont.getEnabled(), 5, 0), true);
            AV7Concepto.setgxTv_SdtConcepto_Consipacont( (byte)(((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG")==0) ? 1 : 0)) );
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_coninssjypapo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_coninssjypapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_coninssjypapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Coninssjypapo( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_coninssjypapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_coninssjypapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_coninssjypapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Coninssjypapo( (byte)(((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG")==0) ? 1 : 0)) );
            }
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_coninssjypcont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_coninssjypcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_coninssjypcont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Coninssjypcont( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_coninssjypcont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_coninssjypcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_coninssjypcont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Coninssjypcont( (byte)(((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG")==0) ? 1 : 0)) );
            }
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_conobrasocapo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conobrasocapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conobrasocapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conobrasocapo( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_conobrasocapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conobrasocapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conobrasocapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conobrasocapo( (byte)(((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG")==0) ? 1 : 0)) );
            }
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_conobrasoccont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conobrasoccont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conobrasoccont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conobrasoccont( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_conobrasoccont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conobrasoccont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conobrasoccont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conobrasoccont( (byte)(((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG")==0) ? 1 : 0)) );
            }
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_confonsolredapo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonsolredapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_confonsolredapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Confonsolredapo( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_confonsolredapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonsolredapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_confonsolredapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Confonsolredapo( (byte)(((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG")==0) ? 1 : 0)) );
            }
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_confonsolredcont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonsolredcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_confonsolredcont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Confonsolredcont( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_confonsolredcont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonsolredcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_confonsolredcont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Confonsolredcont( (byte)(((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG")==0) ? 1 : 0)) );
            }
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_conrenateaapo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conrenateaapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conrenateaapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conrenateaapo( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_conrenateaapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conrenateaapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conrenateaapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conrenateaapo( (byte)(((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG")==0) ? 1 : 0)) );
            }
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_conrenateacont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conrenateacont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conrenateacont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conrenateacont( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_conrenateacont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conrenateacont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conrenateacont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conrenateacont( (byte)(((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG")==0) ? 1 : 0)) );
            }
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_conasigfamcont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conasigfamcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conasigfamcont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conasigfamcont( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_conasigfamcont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conasigfamcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conasigfamcont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conasigfamcont( (byte)(((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG")==0) ? 1 : 0)) );
            }
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_confonnacempcont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonnacempcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_confonnacempcont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Confonnacempcont( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_confonnacempcont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonnacempcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_confonnacempcont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Confonnacempcont( (byte)(((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG")==0) ? 1 : 0)) );
            }
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_conleyrietrabcont.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conleyrietrabcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conleyrietrabcont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conleyrietrabcont( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_conleyrietrabcont.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conleyrietrabcont.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conleyrietrabcont.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conleyrietrabcont( (byte)(((GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "REM_ARG")==0) ? 1 : 0)) );
            }
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_conregdifapo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conregdifapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conregdifapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conregdifapo( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_conregdifapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conregdifapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conregdifapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conregdifapo( (byte)(0) );
            }
            AV54aplicaAlgo = true ;
         }
         if ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 )
         {
            cmbavConcepto_conregespapo.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conregespapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conregespapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conregespapo( (byte)(0) );
            }
         }
         else
         {
            cmbavConcepto_conregespapo.setEnabled( (AV26permiteModificacion ? 1 : 0) );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conregespapo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConcepto_conregespapo.getEnabled(), 5, 0), true);
            if ( ! ( GXutil.strcmp(AV57httpRequest.getMethod(), httpContext.getMessage( "GET", "")) == 0 ) && ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) )
            {
               AV7Concepto.setgxTv_SdtConcepto_Conregespapo( (byte)(0) );
            }
            AV54aplicaAlgo = true ;
         }
         AV54aplicaAlgo = true ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV151Pgmname, httpContext.getMessage( "permisssssssss ok ", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV151Pgmname, httpContext.getMessage( "permis &aplicaAlgo ", "")+GXutil.trim( GXutil.booltostr( AV54aplicaAlgo))) ;
      tblTblapocon3_Visible = (AV54aplicaAlgo ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTblapocon3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTblapocon3_Visible), 5, 0), true);
   }

   public void S222( )
   {
      /* 'SACDEVEN VISIBLE' Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "CAL_ARG") == 0 ) || ( GXutil.strcmp(AV7Concepto.getgxTv_SdtConcepto_Tipoconcod(), "DES_ARG") == 0 ) )
      {
         cmbavConcepto_consacdeven.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consacdeven.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_consacdeven.getVisible(), 5, 0), true);
         cmbavConcepto_conbasefer.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasefer.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbasefer.getVisible(), 5, 0), true);
         cmbavConcepto_conbasehorext.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasehorext.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbasehorext.getVisible(), 5, 0), true);
         cmbavConcepto_conbaselic.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaselic.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbaselic.getVisible(), 5, 0), true);
         cmbavConcepto_conbaseferprom.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseferprom.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbaseferprom.getVisible(), 5, 0), true);
         cmbavConcepto_conbasehorextprom.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasehorextprom.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbasehorextprom.getVisible(), 5, 0), true);
         cmbavConcepto_conbaselicprom.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaselicprom.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbaselicprom.getVisible(), 5, 0), true);
         cmbavConcepto_conbasepres.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasepres.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbasepres.getVisible(), 5, 0), true);
         cmbavConcepto_conbaseant.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseant.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbaseant.getVisible(), 5, 0), true);
      }
      else
      {
         cmbavConcepto_consacdeven.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consacdeven.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_consacdeven.getVisible(), 5, 0), true);
         cmbavConcepto_conbasefer.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasefer.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbasefer.getVisible(), 5, 0), true);
         cmbavConcepto_conbasehorext.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasehorext.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbasehorext.getVisible(), 5, 0), true);
         cmbavConcepto_conbaselic.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaselic.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbaselic.getVisible(), 5, 0), true);
         cmbavConcepto_conbaseferprom.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseferprom.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbaseferprom.getVisible(), 5, 0), true);
         cmbavConcepto_conbasehorextprom.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasehorextprom.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbasehorextprom.getVisible(), 5, 0), true);
         cmbavConcepto_conbaselicprom.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaselicprom.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbaselicprom.getVisible(), 5, 0), true);
         cmbavConcepto_conbasepres.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasepres.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbasepres.getVisible(), 5, 0), true);
         cmbavConcepto_conbaseant.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseant.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConcepto_conbaseant.getVisible(), 5, 0), true);
      }
   }

   private void e26AJ3( )
   {
      /* Gridlevel_motivos_Load Routine */
      returnInSub = false ;
      AV125GXV41 = 1 ;
      while ( AV125GXV41 <= AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() )
      {
         AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)) );
         AV15LineDeleted = (boolean)(((AV63ConceptoMotivosEgresoDeleted.indexof(AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().indexof(((web.SdtConcepto_MotivosEgreso)(AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem()))))>0))) ;
         dynavConcepto_motivosegreso__megcodigo.setEnabled( (((GXutil.strcmp(AV12TrnMode, "INS")==0)||(GXutil.strcmp(AV12TrnMode, "UPD")==0))&&(!AV15LineDeleted)&&GXutil.contains( ((web.SdtConcepto_MotivosEgreso)(AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().currentItem())).toxml(false, true, "", "PayDay"), "<Mode>INS</Mode>") ? 1 : 0) );
         cmbavConcepto_motivosegreso__megpreatipo.setEnabled( (((GXutil.strcmp(AV12TrnMode, "INS")==0)||(GXutil.strcmp(AV12TrnMode, "UPD")==0))&&(!AV15LineDeleted) ? 1 : 0) );
         edtavConcepto_motivosegreso__conmegmeses_Enabled = (((GXutil.strcmp(AV12TrnMode, "INS")==0)||(GXutil.strcmp(AV12TrnMode, "UPD")==0))&&(!AV15LineDeleted) ? 1 : 0) ;
         cmbavConcepto_motivosegreso__conmegdura.setEnabled( (((GXutil.strcmp(AV12TrnMode, "INS")==0)||(GXutil.strcmp(AV12TrnMode, "UPD")==0))&&(!AV15LineDeleted) ? 1 : 0) );
         edtavConcepto_motivosegreso__conmegpropor_Enabled = (((GXutil.strcmp(AV12TrnMode, "INS")==0)||(GXutil.strcmp(AV12TrnMode, "UPD")==0))&&(!AV15LineDeleted) ? 1 : 0) ;
         AV61DeleteGridLineGridLevel_Motivos = "<i class=\"fa fa-times TrnGridDelete\"></i>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDeletegridlinegridlevel_motivos_Internalname, AV61DeleteGridLineGridLevel_Motivos);
         if ( ( ( GXutil.strcmp(AV12TrnMode, "INS") == 0 ) || ( GXutil.strcmp(AV12TrnMode, "UPD") == 0 ) ) && ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( AV26permiteModificacion ) ) )
         {
            edtavDeletegridlinegridlevel_motivos_Class = "Attribute" ;
         }
         else
         {
            edtavDeletegridlinegridlevel_motivos_Class = "Invisible" ;
         }
         edtavDeletegridlinegridlevel_motivos_Columnclass = (AV15LineDeleted ? "WWIconActionColumn WWColumnLineThrough WWColumnLineThroughFirstColumn" : "WWIconActionColumn") ;
         dynavConcepto_motivosegreso__megcodigo.setColumnClass( (AV15LineDeleted ? "WWColumn WWColumnLineThrough" : "WWColumn") );
         cmbavConcepto_motivosegreso__megpreatipo.setColumnClass( (AV15LineDeleted ? "WWColumn WWColumnLineThrough" : "WWColumn") );
         edtavConcepto_motivosegreso__conmegmeses_Columnclass = (AV15LineDeleted ? "WWColumn WWColumnLineThrough" : "WWColumn") ;
         cmbavConcepto_motivosegreso__conmegdura.setColumnClass( (AV15LineDeleted ? "WWColumn WWColumnLineThrough" : "WWColumn") );
         edtavConcepto_motivosegreso__conmegpropor_Columnclass = (AV15LineDeleted ? "WWColumn WWColumnLineThrough" : "WWColumn") ;
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(262) ;
         }
         if ( ( subGridlevel_motivos_Islastpage == 1 ) || ( subGridlevel_motivos_Rows == 0 ) || ( ( GRIDLEVEL_MOTIVOS_nCurrentRecord >= GRIDLEVEL_MOTIVOS_nFirstRecordOnPage ) && ( GRIDLEVEL_MOTIVOS_nCurrentRecord < GRIDLEVEL_MOTIVOS_nFirstRecordOnPage + subgridlevel_motivos_fnc_recordsperpage( ) ) ) )
         {
            sendrow_2623( ) ;
            GRIDLEVEL_MOTIVOS_nEOF = (byte)(0) ;
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_MOTIVOS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_MOTIVOS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDLEVEL_MOTIVOS_nCurrentRecord + 1 >= subgridlevel_motivos_fnc_recordcount( ) )
            {
               GRIDLEVEL_MOTIVOS_nEOF = (byte)(1) ;
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDLEVEL_MOTIVOS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_MOTIVOS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDLEVEL_MOTIVOS_nCurrentRecord = (long)(GRIDLEVEL_MOTIVOS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_262_Refreshing )
         {
            httpContext.doAjaxLoad(262, Gridlevel_motivosRow);
         }
         AV125GXV41 = (int)(AV125GXV41+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_AJ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGxuitabspanel_tabs1.setProperty("PageCount", Gxuitabspanel_tabs1_Pagecount);
         ucGxuitabspanel_tabs1.setProperty("Class", Gxuitabspanel_tabs1_Class);
         ucGxuitabspanel_tabs1.setProperty("HistoryManagement", Gxuitabspanel_tabs1_Historymanagement);
         ucGxuitabspanel_tabs1.render(context, "tab", Gxuitabspanel_tabs1_Internalname, sPrefix+"GXUITABSPANEL_TABS1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABS1Container"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTab1_title_Internalname, httpContext.getMessage( "Concepto", ""), "", "", lblTab1_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Tab1") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABS1Container"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
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
         ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, sPrefix+"DVPANEL_TABLEATTRIBUTESContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_tipoconcod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_tipoconcod.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_tipoconcod, cmbavConcepto_tipoconcod.getInternalname(), GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Tipoconcod()), 1, cmbavConcepto_tipoconcod.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ECONCEPTO_TIPOCONCOD.CLICK."+"'", "char", "", 1, cmbavConcepto_tipoconcod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_tipoconcod.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Tipoconcod()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_tipoconcod.getInternalname(), "Values", cmbavConcepto_tipoconcod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_subtipoconcod1.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_subtipoconcod1.getInternalname(), httpContext.getMessage( "Clasificación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_subtipoconcod1, cmbavConcepto_subtipoconcod1.getInternalname(), GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod1()), 1, cmbavConcepto_subtipoconcod1.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ECONCEPTO_SUBTIPOCONCOD1.CLICK."+"'", "char", "", 1, cmbavConcepto_subtipoconcod1.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_subtipoconcod1.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod1()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_subtipoconcod1.getInternalname(), "Values", cmbavConcepto_subtipoconcod1.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_subtipoconcod2.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_subtipoconcod2.getInternalname(), httpContext.getMessage( "Sub clasif.", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_subtipoconcod2, cmbavConcepto_subtipoconcod2.getInternalname(), GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod2()), 1, cmbavConcepto_subtipoconcod2.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ECONCEPTO_SUBTIPOCONCOD2.CLICK."+"'", "char", "", 1, cmbavConcepto_subtipoconcod2.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,40);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_subtipoconcod2.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Subtipoconcod2()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_subtipoconcod2.getInternalname(), "Values", cmbavConcepto_subtipoconcod2.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConcepto_concodigo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavConcepto_concodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavConcepto_concodigo_Internalname, GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Concodigo()), GXutil.rtrim( localUtil.format( AV7Concepto.getgxTv_SdtConcepto_Concodigo(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConcepto_concodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavConcepto_concodigo_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConcepto_condescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavConcepto_condescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavConcepto_condescrip_Internalname, AV7Concepto.getgxTv_SdtConcepto_Condescrip(), "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,50);\"", (short)(0), 1, edtavConcepto_condescrip_Enabled, 1, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConcepto_conrelsec_cell_Internalname, 1, 0, "px", 0, "px", divConcepto_conrelsec_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", dynavConcepto_conrelsec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavConcepto_conrelsec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavConcepto_conrelsec.getInternalname(), httpContext.getMessage( "Fecha de liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavConcepto_conrelsec, dynavConcepto_conrelsec.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conrelsec(), 6, 0)), 1, dynavConcepto_conrelsec.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", dynavConcepto_conrelsec.getVisible(), dynavConcepto_conrelsec.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,55);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         dynavConcepto_conrelsec.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conrelsec(), 6, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_conrelsec.getInternalname(), "Values", dynavConcepto_conrelsec.ToJavascriptSource(), true);
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
         ucDvpanel_unnamedtable3.setProperty("Width", Dvpanel_unnamedtable3_Width);
         ucDvpanel_unnamedtable3.setProperty("AutoWidth", Dvpanel_unnamedtable3_Autowidth);
         ucDvpanel_unnamedtable3.setProperty("AutoHeight", Dvpanel_unnamedtable3_Autoheight);
         ucDvpanel_unnamedtable3.setProperty("Cls", Dvpanel_unnamedtable3_Cls);
         ucDvpanel_unnamedtable3.setProperty("Title", Dvpanel_unnamedtable3_Title);
         ucDvpanel_unnamedtable3.setProperty("Collapsible", Dvpanel_unnamedtable3_Collapsible);
         ucDvpanel_unnamedtable3.setProperty("Collapsed", Dvpanel_unnamedtable3_Collapsed);
         ucDvpanel_unnamedtable3.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable3_Showcollapseicon);
         ucDvpanel_unnamedtable3.setProperty("IconPosition", Dvpanel_unnamedtable3_Iconposition);
         ucDvpanel_unnamedtable3.setProperty("AutoScroll", Dvpanel_unnamedtable3_Autoscroll);
         ucDvpanel_unnamedtable3.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable3_Internalname, sPrefix+"DVPANEL_UNNAMEDTABLE3Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_UNNAMEDTABLE3Container"+"UnnamedTable3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table2_63_AJ2( true) ;
      }
      else
      {
         wb_table2_63_AJ2( false) ;
      }
      return  ;
   }

   public void wb_table2_63_AJ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkavConcepto_conpuenov.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavConcepto_conpuenov.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavConcepto_conpuenov.getInternalname(), httpContext.getMessage( "Se puede ingresar como novedad", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavConcepto_conpuenov.getInternalname(), GXutil.booltostr( AV7Concepto.getgxTv_SdtConcepto_Conpuenov()), "", httpContext.getMessage( "Se puede ingresar como novedad", ""), chkavConcepto_conpuenov.getVisible(), chkavConcepto_conpuenov.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(73, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,73);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkavConcepto_convariable.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavConcepto_convariable.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavConcepto_convariable.getInternalname(), httpContext.getMessage( "Remuneración variable", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavConcepto_convariable.getInternalname(), GXutil.booltostr( AV7Concepto.getgxTv_SdtConcepto_Convariable()), "", httpContext.getMessage( "Remuneración variable", ""), chkavConcepto_convariable.getVisible(), chkavConcepto_convariable.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,78);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", dynavConcepto_apliigg.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavConcepto_apliigg.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavConcepto_apliigg.getInternalname(), httpContext.getMessage( "Tratamiento IIGG", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavConcepto_apliigg, dynavConcepto_apliigg.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Apliigg(), 4, 0)), 1, dynavConcepto_apliigg.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", dynavConcepto_apliigg.getVisible(), dynavConcepto_apliigg.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,83);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         dynavConcepto_apliigg.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Apliigg(), 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_apliigg.getInternalname(), "Values", dynavConcepto_apliigg.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divConcepto_concodafip_cell_Internalname, 1, 0, "px", 0, "px", divConcepto_concodafip_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConcepto_concodafip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavConcepto_concodafip_Internalname, httpContext.getMessage( "Concepto AFIP", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavConcepto_concodafip_Internalname, GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Concodafip()), GXutil.rtrim( localUtil.format( AV7Concepto.getgxTv_SdtConcepto_Concodafip(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,88);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConcepto_concodafip_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavConcepto_concodafip_Enabled, 1, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavConcepto_conhabilitado.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavConcepto_conhabilitado.getInternalname(), httpContext.getMessage( "Habilitado", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavConcepto_conhabilitado.getInternalname(), GXutil.booltostr( AV7Concepto.getgxTv_SdtConcepto_Conhabilitado()), "", httpContext.getMessage( "Habilitado", ""), 1, chkavConcepto_conhabilitado.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(93, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,93);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_convigencia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_convigencia.getInternalname(), httpContext.getMessage( "Aplicación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_convigencia, cmbavConcepto_convigencia.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Convigencia(), 1, 0)), 1, cmbavConcepto_convigencia.getJsonclick(), 7, "'"+sPrefix+"'"+",false,"+"'"+"e28aj1_client"+"'", "int", "", 1, cmbavConcepto_convigencia.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,98);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_convigencia.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Convigencia(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_convigencia.getInternalname(), "Values", cmbavConcepto_convigencia.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavConcepto_concondicion.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_concondicion.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_concondicion.getInternalname(), httpContext.getMessage( "Condición para liquidación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 103,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_concondicion, cmbavConcepto_concondicion.getInternalname(), GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Concondicion()), 1, cmbavConcepto_concondicion.getJsonclick(), 7, "'"+sPrefix+"'"+",false,"+"'"+"e29aj1_client"+"'", "char", "", cmbavConcepto_concondicion.getVisible(), cmbavConcepto_concondicion.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,103);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_concondicion.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Concondicion()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_concondicion.getInternalname(), "Values", cmbavConcepto_concondicion.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavConcepto_concondcodigo_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConcepto_concondcodigo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavConcepto_concondcodigo_Internalname, httpContext.getMessage( "Código relacionado a la condición", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavConcepto_concondcodigo_Internalname, GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Concondcodigo()), GXutil.rtrim( localUtil.format( AV7Concepto.getgxTv_SdtConcepto_Concondcodigo(), "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,108);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConcepto_concondcodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtavConcepto_concondcodigo_Visible, edtavConcepto_concondcodigo_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavConcepto_conobservacion_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConcepto_conobservacion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavConcepto_conobservacion_Internalname, httpContext.getMessage( "Observacion", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 113,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavConcepto_conobservacion_Internalname, AV7Concepto.getgxTv_SdtConcepto_Conobservacion(), "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,113);\"", (short)(0), edtavConcepto_conobservacion_Visible, edtavConcepto_conobservacion_Enabled, 1, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkavConcepto_conrecalcular.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavConcepto_conrecalcular.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavConcepto_conrecalcular.getInternalname(), httpContext.getMessage( "Recalcular por impuesto a las ganancias", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavConcepto_conrecalcular.getInternalname(), GXutil.booltostr( AV7Concepto.getgxTv_SdtConcepto_Conrecalcular()), "", httpContext.getMessage( "Recalcular por impuesto a las ganancias", ""), chkavConcepto_conrecalcular.getVisible(), chkavConcepto_conrecalcular.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(118, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,118);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablerango_Internalname, divTablerango_Visible, 0, "px", 0, "px", "MB15", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DataContentCell", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablerangodesde_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-5 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockrangodesde_Internalname, httpContext.getMessage( "Rango para cantidad desde", ""), "", "", lblTextblockrangodesde_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-7", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavRangodesde_Internalname, httpContext.getMessage( "Rango Desde", ""), "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavRangodesde_Internalname, GXutil.ltrim( localUtil.ntoc( AV71RangoDesde, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( AV71RangoDesde, "ZZ,ZZZ,ZZZ,ZZ9.99")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,129);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavRangodesde_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavRangodesde_Enabled, 1, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DataContentCell", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtablerangohasta_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 MergeLabelCell CellWidth_12_5", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockrangohasta_Internalname, httpContext.getMessage( "hasta", ""), "", "", lblTextblockrangohasta_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 CellWidth_87_5", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavRangohasta_Internalname, httpContext.getMessage( "Rango Hasta", ""), "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 137,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavRangohasta_Internalname, GXutil.ltrim( localUtil.ntoc( AV72RangoHasta, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( AV72RangoHasta, "ZZ,ZZZ,ZZZ,ZZ9.99")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,137);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavRangohasta_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavRangohasta_Enabled, 1, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_ConceptoABM.htm");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkavConcepto_conmostrarpos.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavConcepto_conmostrarpos.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavConcepto_conmostrarpos.getInternalname(), httpContext.getMessage( "Mostrar en recibo solo si es mayor a cero", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 142,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavConcepto_conmostrarpos.getInternalname(), GXutil.booltostr( AV7Concepto.getgxTv_SdtConcepto_Conmostrarpos()), "", httpContext.getMessage( "Mostrar en recibo solo si es mayor a cero", ""), chkavConcepto_conmostrarpos.getVisible(), chkavConcepto_conmostrarpos.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(142, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,142);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkavConcepto_conerrorsicero.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavConcepto_conerrorsicero.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavConcepto_conerrorsicero.getInternalname(), httpContext.getMessage( "Dar error si el concepto se calcula en cero", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 147,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavConcepto_conerrorsicero.getInternalname(), GXutil.booltostr( AV7Concepto.getgxTv_SdtConcepto_Conerrorsicero()), "", httpContext.getMessage( "Dar error si el concepto se calcula en cero", ""), chkavConcepto_conerrorsicero.getVisible(), chkavConcepto_conerrorsicero.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(147, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,147);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavConcepto_conadeldescu.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_conadeldescu.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conadeldescu.getInternalname(), httpContext.getMessage( "Adelanto/Descuento", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 152,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conadeldescu, cmbavConcepto_conadeldescu.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conadeldescu(), 1, 0)), 1, cmbavConcepto_conadeldescu.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbavConcepto_conadeldescu.getVisible(), cmbavConcepto_conadeldescu.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,152);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conadeldescu.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conadeldescu(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conadeldescu.getInternalname(), "Values", cmbavConcepto_conadeldescu.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavConcepto_consacdeven.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_consacdeven.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_consacdeven.getInternalname(), httpContext.getMessage( "Tipo devengamiento", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 157,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_consacdeven, cmbavConcepto_consacdeven.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Consacdeven(), 2, 0)), 1, cmbavConcepto_consacdeven.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbavConcepto_consacdeven.getVisible(), cmbavConcepto_consacdeven.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,157);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_consacdeven.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Consacdeven(), 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consacdeven.getInternalname(), "Values", cmbavConcepto_consacdeven.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConcepto_conorden_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavConcepto_conorden_Internalname, httpContext.getMessage( "Orden visualización", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 162,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavConcepto_conorden_Internalname, GXutil.ltrim( localUtil.ntoc( AV7Concepto.getgxTv_SdtConcepto_Conorden(), (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7Concepto.getgxTv_SdtConcepto_Conorden()), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,162);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConcepto_conorden_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavConcepto_conorden_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConcepto_conordejec_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavConcepto_conordejec_Internalname, httpContext.getMessage( "Orden ejecución", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 167,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavConcepto_conordejec_Internalname, GXutil.ltrim( localUtil.ntoc( AV7Concepto.getgxTv_SdtConcepto_Conordejec(), (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7Concepto.getgxTv_SdtConcepto_Conordejec()), "ZZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,167);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConcepto_conordejec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavConcepto_conordejec_Enabled, 1, "text", "1", 12, "chr", 1, "row", 12, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavConcepto_conbaselic.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_conbaselic.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conbaselic.getInternalname(), cmbavConcepto_conbaselic.getCaption(), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 172,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conbaselic, cmbavConcepto_conbaselic.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaselic(), 1, 0)), 1, cmbavConcepto_conbaselic.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbavConcepto_conbaselic.getVisible(), cmbavConcepto_conbaselic.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,172);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conbaselic.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaselic(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaselic.getInternalname(), "Values", cmbavConcepto_conbaselic.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavConcepto_conbaselicprom.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_conbaselicprom.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conbaselicprom.getInternalname(), httpContext.getMessage( "Base de cálculo para licencias de remuneración promedio variable", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 177,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conbaselicprom, cmbavConcepto_conbaselicprom.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaselicprom(), 1, 0)), 1, cmbavConcepto_conbaselicprom.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbavConcepto_conbaselicprom.getVisible(), cmbavConcepto_conbaselicprom.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,177);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conbaselicprom.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaselicprom(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaselicprom.getInternalname(), "Values", cmbavConcepto_conbaselicprom.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavConcepto_conbasefer.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_conbasefer.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conbasefer.getInternalname(), cmbavConcepto_conbasefer.getCaption(), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 182,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conbasefer, cmbavConcepto_conbasefer.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasefer(), 1, 0)), 1, cmbavConcepto_conbasefer.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbavConcepto_conbasefer.getVisible(), cmbavConcepto_conbasefer.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,182);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conbasefer.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasefer(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasefer.getInternalname(), "Values", cmbavConcepto_conbasefer.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavConcepto_conbaseferprom.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_conbaseferprom.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conbaseferprom.getInternalname(), httpContext.getMessage( "Base de cálculo para feriados de remuneración promedio variable", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 187,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conbaseferprom, cmbavConcepto_conbaseferprom.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseferprom(), 1, 0)), 1, cmbavConcepto_conbaseferprom.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbavConcepto_conbaseferprom.getVisible(), cmbavConcepto_conbaseferprom.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,187);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conbaseferprom.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseferprom(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseferprom.getInternalname(), "Values", cmbavConcepto_conbaseferprom.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavConcepto_conbasehorext.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_conbasehorext.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conbasehorext.getInternalname(), httpContext.getMessage( "Base de cálculo para horas extras de remuneración fija", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 192,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conbasehorext, cmbavConcepto_conbasehorext.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasehorext(), 1, 0)), 1, cmbavConcepto_conbasehorext.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbavConcepto_conbasehorext.getVisible(), cmbavConcepto_conbasehorext.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,192);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conbasehorext.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasehorext(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasehorext.getInternalname(), "Values", cmbavConcepto_conbasehorext.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavConcepto_conbasehorextprom.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_conbasehorextprom.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conbasehorextprom.getInternalname(), httpContext.getMessage( "Base de cálculo para horas extras de remuneración promedio variable", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 197,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conbasehorextprom, cmbavConcepto_conbasehorextprom.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasehorextprom(), 1, 0)), 1, cmbavConcepto_conbasehorextprom.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbavConcepto_conbasehorextprom.getVisible(), cmbavConcepto_conbasehorextprom.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,197);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conbasehorextprom.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasehorextprom(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasehorextprom.getInternalname(), "Values", cmbavConcepto_conbasehorextprom.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavConcepto_conbasepres.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_conbasepres.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conbasepres.getInternalname(), cmbavConcepto_conbasepres.getCaption(), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 202,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conbasepres, cmbavConcepto_conbasepres.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasepres(), 1, 0)), 1, cmbavConcepto_conbasepres.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbavConcepto_conbasepres.getVisible(), cmbavConcepto_conbasepres.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,202);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conbasepres.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbasepres(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbasepres.getInternalname(), "Values", cmbavConcepto_conbasepres.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavConcepto_conbaseant.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_conbaseant.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conbaseant.getInternalname(), cmbavConcepto_conbaseant.getCaption(), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 207,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conbaseant, cmbavConcepto_conbaseant.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseant(), 1, 0)), 1, cmbavConcepto_conbaseant.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbavConcepto_conbaseant.getVisible(), cmbavConcepto_conbaseant.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,207);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conbaseant.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseant(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseant.getInternalname(), "Values", cmbavConcepto_conbaseant.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_conbaseosdif.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conbaseosdif.getInternalname(), httpContext.getMessage( "Base de cálculo para obra social diferencial", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 212,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conbaseosdif, cmbavConcepto_conbaseosdif.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseosdif(), 1, 0)), 1, cmbavConcepto_conbaseosdif.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_conbaseosdif.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,212);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conbaseosdif.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseosdif(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseosdif.getInternalname(), "Values", cmbavConcepto_conbaseosdif.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_conbaseaus.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conbaseaus.getInternalname(), httpContext.getMessage( "Base de cálculo para ausencias/licencias sin goce de sueldo de remuneración fija", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 217,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conbaseaus, cmbavConcepto_conbaseaus.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseaus(), 1, 0)), 1, cmbavConcepto_conbaseaus.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_conbaseaus.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,217);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conbaseaus.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseaus(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseaus.getInternalname(), "Values", cmbavConcepto_conbaseaus.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConcepto_conbaseausprom.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conbaseausprom.getInternalname(), httpContext.getMessage( "Base de cálculo para ausencias/licencias sin goce de sueldo de remuneración promedio variable", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 222,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conbaseausprom, cmbavConcepto_conbaseausprom.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseausprom(), 1, 0)), 1, cmbavConcepto_conbaseausprom.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_conbaseausprom.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,222);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conbaseausprom.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conbaseausprom(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conbaseausprom.getInternalname(), "Values", cmbavConcepto_conbaseausprom.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavConcepto_conceptoconvecodigo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavConcepto_conceptoconvecodigo.getInternalname(), httpContext.getMessage( "Convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 227,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavConcepto_conceptoconvecodigo, dynavConcepto_conceptoconvecodigo.getInternalname(), GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Conceptoconvecodigo()), 1, dynavConcepto_conceptoconvecodigo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavConcepto_conceptoconvecodigo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,227);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         dynavConcepto_conceptoconvecodigo.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Conceptoconvecodigo()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_conceptoconvecodigo.getInternalname(), "Values", dynavConcepto_conceptoconvecodigo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDvpanel_unnamedtable4_cell_Internalname, 1, 0, "px", 0, "px", divDvpanel_unnamedtable4_cell_Class, "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable4.setProperty("Width", Dvpanel_unnamedtable4_Width);
         ucDvpanel_unnamedtable4.setProperty("AutoWidth", Dvpanel_unnamedtable4_Autowidth);
         ucDvpanel_unnamedtable4.setProperty("AutoHeight", Dvpanel_unnamedtable4_Autoheight);
         ucDvpanel_unnamedtable4.setProperty("Cls", Dvpanel_unnamedtable4_Cls);
         ucDvpanel_unnamedtable4.setProperty("Title", Dvpanel_unnamedtable4_Title);
         ucDvpanel_unnamedtable4.setProperty("Collapsible", Dvpanel_unnamedtable4_Collapsible);
         ucDvpanel_unnamedtable4.setProperty("Collapsed", Dvpanel_unnamedtable4_Collapsed);
         ucDvpanel_unnamedtable4.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable4_Showcollapseicon);
         ucDvpanel_unnamedtable4.setProperty("IconPosition", Dvpanel_unnamedtable4_Iconposition);
         ucDvpanel_unnamedtable4.setProperty("AutoScroll", Dvpanel_unnamedtable4_Autoscroll);
         ucDvpanel_unnamedtable4.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable4_Internalname, sPrefix+"DVPANEL_UNNAMEDTABLE4Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_UNNAMEDTABLE4Container"+"UnnamedTable4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable4_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavConcepto_concuendebe.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavConcepto_concuendebe.getInternalname(), httpContext.getMessage( "Cuenta debe", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 237,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavConcepto_concuendebe, dynavConcepto_concuendebe.getInternalname(), GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Concuendebe()), 1, dynavConcepto_concuendebe.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavConcepto_concuendebe.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,237);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         dynavConcepto_concuendebe.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Concuendebe()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_concuendebe.getInternalname(), "Values", dynavConcepto_concuendebe.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavConcepto_concuenhaber.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavConcepto_concuenhaber.getInternalname(), httpContext.getMessage( "Cuenta haber", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 241,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavConcepto_concuenhaber, dynavConcepto_concuenhaber.getInternalname(), GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Concuenhaber()), 1, dynavConcepto_concuenhaber.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavConcepto_concuenhaber.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,241);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         dynavConcepto_concuenhaber.setValue( GXutil.rtrim( AV7Concepto.getgxTv_SdtConcepto_Concuenhaber()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_concuenhaber.getInternalname(), "Values", dynavConcepto_concuenhaber.ToJavascriptSource(), true);
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_tipoliquidacion_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         Gridlevel_tipoliquidacionContainer.SetWrapped(nGXWrapped);
         startgridcontrol247( ) ;
      }
      if ( wbEnd == 247 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_247 = (int)(nGXsfl_247_idx-1) ;
         if ( Gridlevel_tipoliquidacionContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            Gridlevel_tipoliquidacionContainer.AddObjectProperty("GRIDLEVEL_TIPOLIQUIDACION_nEOF", GRIDLEVEL_TIPOLIQUIDACION_nEOF);
            Gridlevel_tipoliquidacionContainer.AddObjectProperty("GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage", GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage);
            AV122GXV38 = nGXsfl_247_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"Gridlevel_tipoliquidacionContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Gridlevel_tipoliquidacion", Gridlevel_tipoliquidacionContainer, subGridlevel_tipoliquidacion_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gridlevel_tipoliquidacionContainerData", Gridlevel_tipoliquidacionContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gridlevel_tipoliquidacionContainerData"+"V", Gridlevel_tipoliquidacionContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"Gridlevel_tipoliquidacionContainerData"+"V"+"\" value='"+Gridlevel_tipoliquidacionContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ButtonAddGridLineCell", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 253,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonAddNewRow" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnaddgridlinegridlevel_tipoliquidacion_Internalname, "gx.evt.setGridEvt("+GXutil.str( 247, 3, 0)+","+"null"+");", httpContext.getMessage( "WWP_AddGridLine", ""), bttBtnaddgridlinegridlevel_tipoliquidacion_Jsonclick, 5, httpContext.getMessage( "WWP_AddGridLine", ""), "", StyleString, ClassString, bttBtnaddgridlinegridlevel_tipoliquidacion_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_motivosegreso_Internalname, divTableleaflevel_motivosegreso_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ButtonAddGridLineCell", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 259,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonAddNewRow" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnaddgridlinegridlevel_motivosegreso_Internalname, "gx.evt.setGridEvt("+GXutil.str( 247, 3, 0)+","+"null"+");", httpContext.getMessage( "WWP_AddGridLine", ""), bttBtnaddgridlinegridlevel_motivosegreso_Jsonclick, 5, httpContext.getMessage( "WWP_AddGridLine", ""), "", StyleString, ClassString, bttBtnaddgridlinegridlevel_motivosegreso_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         Gridlevel_motivosContainer.SetWrapped(nGXWrapped);
         startgridcontrol262( ) ;
      }
      if ( wbEnd == 262 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_262 = (int)(nGXsfl_262_idx-1) ;
         if ( Gridlevel_motivosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            Gridlevel_motivosContainer.AddObjectProperty("GRIDLEVEL_MOTIVOS_nEOF", GRIDLEVEL_MOTIVOS_nEOF);
            Gridlevel_motivosContainer.AddObjectProperty("GRIDLEVEL_MOTIVOS_nFirstRecordOnPage", GRIDLEVEL_MOTIVOS_nFirstRecordOnPage);
            AV125GXV41 = nGXsfl_262_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"Gridlevel_motivosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Gridlevel_motivos", Gridlevel_motivosContainer, subGridlevel_motivos_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gridlevel_motivosContainerData", Gridlevel_motivosContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gridlevel_motivosContainerData"+"V", Gridlevel_motivosContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"Gridlevel_motivosContainerData"+"V"+"\" value='"+Gridlevel_motivosContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ButtonAddGridLineCell", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 272,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonAddNewRow" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnaddgridlinegridlevel_motivos_Internalname, "gx.evt.setGridEvt("+GXutil.str( 247, 3, 0)+","+"null"+");", httpContext.getMessage( "WWP_AddGridLine", ""), bttBtnaddgridlinegridlevel_motivos_Jsonclick, 5, httpContext.getMessage( "WWP_AddGridLine", ""), "", StyleString, ClassString, bttBtnaddgridlinegridlevel_motivos_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOADDGRIDLINEGRIDLEVEL_MOTIVOS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoABM.htm");
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
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABS1Container"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTab3_title_Internalname, httpContext.getMessage( "Aportes y Contribuciones AFIP", ""), "", "", lblTab3_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Tab3") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABS1Container"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table3_280_AJ2( true) ;
      }
      else
      {
         wb_table3_280_AJ2( false) ;
      }
      return  ;
   }

   public void wb_table3_280_AJ2e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 379,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "gx.evt.setGridEvt("+GXutil.str( 247, 3, 0)+","+"null"+");", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 381,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 247, 3, 0)+","+"null"+");", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_AJ2e( true) ;
      }
      else
      {
         wb_table1_9_AJ2e( false) ;
      }
   }

   public void wb_table3_280_AJ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTblapocon3_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTblapocon3_Internalname, tblTblapocon3_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDvpanel_panelapocont3.setProperty("Width", Dvpanel_panelapocont3_Width);
         ucDvpanel_panelapocont3.setProperty("AutoWidth", Dvpanel_panelapocont3_Autowidth);
         ucDvpanel_panelapocont3.setProperty("AutoHeight", Dvpanel_panelapocont3_Autoheight);
         ucDvpanel_panelapocont3.setProperty("Cls", Dvpanel_panelapocont3_Cls);
         ucDvpanel_panelapocont3.setProperty("Title", Dvpanel_panelapocont3_Title);
         ucDvpanel_panelapocont3.setProperty("Collapsible", Dvpanel_panelapocont3_Collapsible);
         ucDvpanel_panelapocont3.setProperty("Collapsed", Dvpanel_panelapocont3_Collapsed);
         ucDvpanel_panelapocont3.setProperty("ShowCollapseIcon", Dvpanel_panelapocont3_Showcollapseicon);
         ucDvpanel_panelapocont3.setProperty("IconPosition", Dvpanel_panelapocont3_Iconposition);
         ucDvpanel_panelapocont3.setProperty("AutoScroll", Dvpanel_panelapocont3_Autoscroll);
         ucDvpanel_panelapocont3.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelapocont3_Internalname, sPrefix+"DVPANEL_PANELAPOCONT3Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_PANELAPOCONT3Container"+"PanelApoCont3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPanelapocont3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table4_288_AJ2( true) ;
      }
      else
      {
         wb_table4_288_AJ2( false) ;
      }
      return  ;
   }

   public void wb_table4_288_AJ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_280_AJ2e( true) ;
      }
      else
      {
         wb_table3_280_AJ2e( false) ;
      }
   }

   public void wb_table4_288_AJ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTbl23_Internalname, tblTbl23_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblS13_Internalname, " ", "", "", lblS13_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblSipatxt_3_Internalname, httpContext.getMessage( "SIPA", ""), "", "", lblSipatxt_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblInjtxt_3_Internalname, httpContext.getMessage( "INSSJyP", ""), "", "", lblInjtxt_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblOstxt_3_Internalname, httpContext.getMessage( "Obra Social", ""), "", "", lblOstxt_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblFsr_3_Internalname, httpContext.getMessage( "FSR", ""), "", "", lblFsr_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblUatretxt_3_Internalname, httpContext.getMessage( "UATRE", ""), "", "", lblUatretxt_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblAafftxt_3_Internalname, httpContext.getMessage( "AAFF", ""), "", "", lblAafftxt_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblFnetxt_3_Internalname, httpContext.getMessage( "FNE", ""), "", "", lblFnetxt_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblDiftxt_3_Internalname, httpContext.getMessage( "Diferenciales", ""), "", "", lblDiftxt_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblRegesptxt_3_Internalname, httpContext.getMessage( "Reg. Especiales", ""), "", "", lblRegesptxt_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblAportxt_3_Internalname, httpContext.getMessage( "Aportes", ""), "", "", lblAportxt_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_consipaapo.getInternalname(), httpContext.getMessage( "Con SIPAApo", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 315,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_consipaapo, cmbavConcepto_consipaapo.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Consipaapo(), 1, 0)), 1, cmbavConcepto_consipaapo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_consipaapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,315);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_consipaapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Consipaapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consipaapo.getInternalname(), "Values", cmbavConcepto_consipaapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_coninssjypapo.getInternalname(), httpContext.getMessage( "Con INSSJy PApo", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 318,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_coninssjypapo, cmbavConcepto_coninssjypapo.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Coninssjypapo(), 1, 0)), 1, cmbavConcepto_coninssjypapo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_coninssjypapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,318);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_coninssjypapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Coninssjypapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_coninssjypapo.getInternalname(), "Values", cmbavConcepto_coninssjypapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conobrasocapo.getInternalname(), httpContext.getMessage( "Con Obra Soc Apo", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 321,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conobrasocapo, cmbavConcepto_conobrasocapo.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conobrasocapo(), 1, 0)), 1, cmbavConcepto_conobrasocapo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_conobrasocapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,321);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conobrasocapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conobrasocapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conobrasocapo.getInternalname(), "Values", cmbavConcepto_conobrasocapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_confonsolredapo.getInternalname(), httpContext.getMessage( "Con Fon Sol Red Apo", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 324,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_confonsolredapo, cmbavConcepto_confonsolredapo.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Confonsolredapo(), 1, 0)), 1, cmbavConcepto_confonsolredapo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_confonsolredapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,324);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_confonsolredapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Confonsolredapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonsolredapo.getInternalname(), "Values", cmbavConcepto_confonsolredapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conrenateaapo.getInternalname(), httpContext.getMessage( "Con Renatea Apo", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 327,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conrenateaapo, cmbavConcepto_conrenateaapo.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conrenateaapo(), 1, 0)), 1, cmbavConcepto_conrenateaapo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_conrenateaapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,327);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conrenateaapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conrenateaapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conrenateaapo.getInternalname(), "Values", cmbavConcepto_conrenateaapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblGuion1_3_Internalname, "-", "", "", lblGuion1_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblGuion2_3_Internalname, "-", "", "", lblGuion2_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conregdifapo.getInternalname(), httpContext.getMessage( "Con Reg Dif Apo", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 334,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conregdifapo, cmbavConcepto_conregdifapo.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conregdifapo(), 1, 0)), 1, cmbavConcepto_conregdifapo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_conregdifapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,334);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conregdifapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conregdifapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conregdifapo.getInternalname(), "Values", cmbavConcepto_conregdifapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conregespapo.getInternalname(), httpContext.getMessage( "Con Reg Esp Apo", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 337,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conregespapo, cmbavConcepto_conregespapo.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conregespapo(), 1, 0)), 1, cmbavConcepto_conregespapo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_conregespapo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,337);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conregespapo.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conregespapo(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conregespapo.getInternalname(), "Values", cmbavConcepto_conregespapo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblContrtxt_3_Internalname, httpContext.getMessage( "Contribuciones", ""), "", "", lblContrtxt_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_consipacont.getInternalname(), httpContext.getMessage( "Con SIPACont", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 343,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_consipacont, cmbavConcepto_consipacont.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Consipacont(), 1, 0)), 1, cmbavConcepto_consipacont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_consipacont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,343);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_consipacont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Consipacont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_consipacont.getInternalname(), "Values", cmbavConcepto_consipacont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_coninssjypcont.getInternalname(), httpContext.getMessage( "Con INSSJy PCont", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 346,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_coninssjypcont, cmbavConcepto_coninssjypcont.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Coninssjypcont(), 1, 0)), 1, cmbavConcepto_coninssjypcont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_coninssjypcont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,346);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_coninssjypcont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Coninssjypcont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_coninssjypcont.getInternalname(), "Values", cmbavConcepto_coninssjypcont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conobrasoccont.getInternalname(), httpContext.getMessage( "Con Obra Soc Cont", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 349,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conobrasoccont, cmbavConcepto_conobrasoccont.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conobrasoccont(), 1, 0)), 1, cmbavConcepto_conobrasoccont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_conobrasoccont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,349);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conobrasoccont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conobrasoccont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conobrasoccont.getInternalname(), "Values", cmbavConcepto_conobrasoccont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_confonsolredcont.getInternalname(), httpContext.getMessage( "Con Fon Sol Red Cont", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 352,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_confonsolredcont, cmbavConcepto_confonsolredcont.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Confonsolredcont(), 1, 0)), 1, cmbavConcepto_confonsolredcont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_confonsolredcont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,352);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_confonsolredcont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Confonsolredcont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonsolredcont.getInternalname(), "Values", cmbavConcepto_confonsolredcont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conrenateacont.getInternalname(), httpContext.getMessage( "Con Renatea Cont", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 355,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conrenateacont, cmbavConcepto_conrenateacont.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conrenateacont(), 1, 0)), 1, cmbavConcepto_conrenateacont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_conrenateacont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,355);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conrenateacont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conrenateacont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conrenateacont.getInternalname(), "Values", cmbavConcepto_conrenateacont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conasigfamcont.getInternalname(), httpContext.getMessage( "Con Asig Fam Cont", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 358,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conasigfamcont, cmbavConcepto_conasigfamcont.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conasigfamcont(), 1, 0)), 1, cmbavConcepto_conasigfamcont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_conasigfamcont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,358);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conasigfamcont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conasigfamcont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conasigfamcont.getInternalname(), "Values", cmbavConcepto_conasigfamcont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_confonnacempcont.getInternalname(), httpContext.getMessage( "Con Fon Nac Emp Cont", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 361,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_confonnacempcont, cmbavConcepto_confonnacempcont.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Confonnacempcont(), 1, 0)), 1, cmbavConcepto_confonnacempcont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_confonnacempcont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,361);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_confonnacempcont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Confonnacempcont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_confonnacempcont.getInternalname(), "Values", cmbavConcepto_confonnacempcont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblGuion3_3_Internalname, "-", "", "", lblGuion3_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblGuion4_3_Internalname, "-", "", "", lblGuion4_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblLrt_txt_3_Internalname, httpContext.getMessage( "LRT", ""), "", "", lblLrt_txt_3_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConceptoABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConcepto_conleyrietrabcont.getInternalname(), httpContext.getMessage( "Con Ley Rie Trab Cont", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 371,'" + sPrefix + "',false,'" + sGXsfl_247_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConcepto_conleyrietrabcont, cmbavConcepto_conleyrietrabcont.getInternalname(), GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conleyrietrabcont(), 1, 0)), 1, cmbavConcepto_conleyrietrabcont.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavConcepto_conleyrietrabcont.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,371);\"", "", true, (byte)(0), "HLP_ConceptoABM.htm");
         cmbavConcepto_conleyrietrabcont.setValue( GXutil.trim( GXutil.str( AV7Concepto.getgxTv_SdtConcepto_Conleyrietrabcont(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_conleyrietrabcont.getInternalname(), "Values", cmbavConcepto_conleyrietrabcont.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_288_AJ2e( true) ;
      }
      else
      {
         wb_table4_288_AJ2e( false) ;
      }
   }

   public void wb_table2_63_AJ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblFormulatbl_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblFormulatbl_Internalname, tblFormulatbl_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavConcepto_conformula_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavConcepto_conformula_Internalname, httpContext.getMessage( "Formula", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavConcepto_conformula_Internalname, AV7Concepto.getgxTv_SdtConcepto_Conformula(), "", "", (short)(0), 1, edtavConcepto_conformula_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ConceptoABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_63_AJ2e( true) ;
      }
      else
      {
         wb_table2_63_AJ2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV12TrnMode = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12TrnMode", AV12TrnMode);
      AV16CliCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliCod), 6, 0));
      AV17ConCodigo = (String)getParm(obj,2,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17ConCodigo", AV17ConCodigo);
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
      paAJ2( ) ;
      wsAJ2( ) ;
      weAJ2( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
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

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlAV12TrnMode = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV16CliCod = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV17ConCodigo = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paAJ2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "conceptoabm", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paAJ2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV12TrnMode = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12TrnMode", AV12TrnMode);
         AV16CliCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliCod), 6, 0));
         AV17ConCodigo = (String)getParm(obj,4,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17ConCodigo", AV17ConCodigo);
      }
      wcpOAV12TrnMode = httpContext.cgiGet( sPrefix+"wcpOAV12TrnMode") ;
      wcpOAV16CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV16CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV17ConCodigo = httpContext.cgiGet( sPrefix+"wcpOAV17ConCodigo") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV12TrnMode, wcpOAV12TrnMode) != 0 ) || ( AV16CliCod != wcpOAV16CliCod ) || ( GXutil.strcmp(AV17ConCodigo, wcpOAV17ConCodigo) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV12TrnMode = AV12TrnMode ;
      wcpOAV16CliCod = AV16CliCod ;
      wcpOAV17ConCodigo = AV17ConCodigo ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV12TrnMode = httpContext.cgiGet( sPrefix+"AV12TrnMode_CTRL") ;
      if ( GXutil.len( sCtrlAV12TrnMode) > 0 )
      {
         AV12TrnMode = httpContext.cgiGet( sCtrlAV12TrnMode) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12TrnMode", AV12TrnMode);
      }
      else
      {
         AV12TrnMode = httpContext.cgiGet( sPrefix+"AV12TrnMode_PARM") ;
      }
      sCtrlAV16CliCod = httpContext.cgiGet( sPrefix+"AV16CliCod_CTRL") ;
      if ( GXutil.len( sCtrlAV16CliCod) > 0 )
      {
         AV16CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV16CliCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CliCod), 6, 0));
      }
      else
      {
         AV16CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV16CliCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV17ConCodigo = httpContext.cgiGet( sPrefix+"AV17ConCodigo_CTRL") ;
      if ( GXutil.len( sCtrlAV17ConCodigo) > 0 )
      {
         AV17ConCodigo = httpContext.cgiGet( sCtrlAV17ConCodigo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17ConCodigo", AV17ConCodigo);
      }
      else
      {
         AV17ConCodigo = httpContext.cgiGet( sPrefix+"AV17ConCodigo_PARM") ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      paAJ2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsAJ2( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wsAJ2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV12TrnMode_PARM", GXutil.rtrim( AV12TrnMode));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV12TrnMode)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV12TrnMode_CTRL", GXutil.rtrim( sCtrlAV12TrnMode));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV16CliCod_PARM", GXutil.ltrim( localUtil.ntoc( AV16CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV16CliCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV16CliCod_CTRL", GXutil.rtrim( sCtrlAV16CliCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV17ConCodigo_PARM", GXutil.rtrim( AV17ConCodigo));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV17ConCodigo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV17ConCodigo_CTRL", GXutil.rtrim( sCtrlAV17ConCodigo));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      weAJ2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025187193121", true, true);
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
      httpContext.AddJavascriptSource("conceptoabm.js", "?2025187193122", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_2472( )
   {
      edtavDeletegridlinegridlevel_tipoliquidacion_Internalname = sPrefix+"vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION_"+sGXsfl_247_idx ;
      dynavConcepto_tipoliquidacion__tliqcod.setInternalname( sPrefix+"CONCEPTO_TIPOLIQUIDACION__TLIQCOD_"+sGXsfl_247_idx );
      cmbavConcepto_tipoliquidacion__contltipegr.setInternalname( sPrefix+"CONCEPTO_TIPOLIQUIDACION__CONTLTIPEGR_"+sGXsfl_247_idx );
   }

   public void subsflControlProps_fel_2472( )
   {
      edtavDeletegridlinegridlevel_tipoliquidacion_Internalname = sPrefix+"vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION_"+sGXsfl_247_fel_idx ;
      dynavConcepto_tipoliquidacion__tliqcod.setInternalname( sPrefix+"CONCEPTO_TIPOLIQUIDACION__TLIQCOD_"+sGXsfl_247_fel_idx );
      cmbavConcepto_tipoliquidacion__contltipegr.setInternalname( sPrefix+"CONCEPTO_TIPOLIQUIDACION__CONTLTIPEGR_"+sGXsfl_247_fel_idx );
   }

   public void sendrow_2472( )
   {
      subsflControlProps_2472( ) ;
      wbAJ0( ) ;
      if ( ( subGridlevel_tipoliquidacion_Rows * 1 == 0 ) || ( nGXsfl_247_idx <= subgridlevel_tipoliquidacion_fnc_recordsperpage( ) * 1 ) )
      {
         Gridlevel_tipoliquidacionRow = GXWebRow.GetNew(context,Gridlevel_tipoliquidacionContainer) ;
         if ( subGridlevel_tipoliquidacion_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridlevel_tipoliquidacion_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridlevel_tipoliquidacion_Class, "") != 0 )
            {
               subGridlevel_tipoliquidacion_Linesclass = subGridlevel_tipoliquidacion_Class+"Odd" ;
            }
         }
         else if ( subGridlevel_tipoliquidacion_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridlevel_tipoliquidacion_Backstyle = (byte)(0) ;
            subGridlevel_tipoliquidacion_Backcolor = subGridlevel_tipoliquidacion_Allbackcolor ;
            if ( GXutil.strcmp(subGridlevel_tipoliquidacion_Class, "") != 0 )
            {
               subGridlevel_tipoliquidacion_Linesclass = subGridlevel_tipoliquidacion_Class+"Uniform" ;
            }
         }
         else if ( subGridlevel_tipoliquidacion_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridlevel_tipoliquidacion_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridlevel_tipoliquidacion_Class, "") != 0 )
            {
               subGridlevel_tipoliquidacion_Linesclass = subGridlevel_tipoliquidacion_Class+"Odd" ;
            }
            subGridlevel_tipoliquidacion_Backcolor = (int)(0x0) ;
         }
         else if ( subGridlevel_tipoliquidacion_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridlevel_tipoliquidacion_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_247_idx) % (2))) == 0 )
            {
               subGridlevel_tipoliquidacion_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_tipoliquidacion_Class, "") != 0 )
               {
                  subGridlevel_tipoliquidacion_Linesclass = subGridlevel_tipoliquidacion_Class+"Even" ;
               }
            }
            else
            {
               subGridlevel_tipoliquidacion_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_tipoliquidacion_Class, "") != 0 )
               {
                  subGridlevel_tipoliquidacion_Linesclass = subGridlevel_tipoliquidacion_Class+"Odd" ;
               }
            }
         }
         if ( Gridlevel_tipoliquidacionContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_247_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Gridlevel_tipoliquidacionContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDeletegridlinegridlevel_tipoliquidacion_Enabled!=0)&&(edtavDeletegridlinegridlevel_tipoliquidacion_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 248,'"+sPrefix+"',false,'"+sGXsfl_247_idx+"',247)\"" : " ") ;
         ROClassString = edtavDeletegridlinegridlevel_tipoliquidacion_Class ;
         Gridlevel_tipoliquidacionRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDeletegridlinegridlevel_tipoliquidacion_Internalname,GXutil.rtrim( AV9DeleteGridLineGridLevel_TipoLiquidacion),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDeletegridlinegridlevel_tipoliquidacion_Enabled!=0)&&(edtavDeletegridlinegridlevel_tipoliquidacion_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,248);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION.CLICK."+sGXsfl_247_idx+"'","","","","",edtavDeletegridlinegridlevel_tipoliquidacion_Jsonclick,Integer.valueOf(5),edtavDeletegridlinegridlevel_tipoliquidacion_Class,"",ROClassString,edtavDeletegridlinegridlevel_tipoliquidacion_Columnclass,edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass,Integer.valueOf(-1),Integer.valueOf(edtavDeletegridlinegridlevel_tipoliquidacion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(247),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         gxvconcepto_tipoliquidacion__tliqcod_htmlAJ2( AV16CliCod) ;
         /* Subfile cell */
         if ( Gridlevel_tipoliquidacionContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((dynavConcepto_tipoliquidacion__tliqcod.getEnabled()!=0)&&(dynavConcepto_tipoliquidacion__tliqcod.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 249,'"+sPrefix+"',false,'"+sGXsfl_247_idx+"',247)\"" : " ") ;
         GXCCtl = "CONCEPTO_TIPOLIQUIDACION__TLIQCOD_" + sGXsfl_247_idx ;
         dynavConcepto_tipoliquidacion__tliqcod.setName( GXCCtl );
         dynavConcepto_tipoliquidacion__tliqcod.setWebtags( "" );
         /* ComboBox */
         Gridlevel_tipoliquidacionRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynavConcepto_tipoliquidacion__tliqcod,dynavConcepto_tipoliquidacion__tliqcod.getInternalname(),GXutil.rtrim( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)).getgxTv_SdtConcepto_TipoLiquidacion_Tliqcod()),Integer.valueOf(1),dynavConcepto_tipoliquidacion__tliqcod.getJsonclick(),Integer.valueOf(5),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ECONCEPTO_TIPOLIQUIDACION__TLIQCOD.CLICK."+sGXsfl_247_idx+"'","char","",Integer.valueOf(-1),Integer.valueOf(dynavConcepto_tipoliquidacion__tliqcod.getEnabled()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute",dynavConcepto_tipoliquidacion__tliqcod.getColumnClass(),dynavConcepto_tipoliquidacion__tliqcod.getColumnHeaderClass(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((dynavConcepto_tipoliquidacion__tliqcod.getEnabled()!=0)&&(dynavConcepto_tipoliquidacion__tliqcod.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,249);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         dynavConcepto_tipoliquidacion__tliqcod.setValue( GXutil.rtrim( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)).getgxTv_SdtConcepto_TipoLiquidacion_Tliqcod()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_tipoliquidacion__tliqcod.getInternalname(), "Values", dynavConcepto_tipoliquidacion__tliqcod.ToJavascriptSource(), !bGXsfl_247_Refreshing);
         /* Subfile cell */
         if ( Gridlevel_tipoliquidacionContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbavConcepto_tipoliquidacion__contltipegr.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbavConcepto_tipoliquidacion__contltipegr.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONCEPTO_TIPOLIQUIDACION__CONTLTIPEGR_" + sGXsfl_247_idx ;
            cmbavConcepto_tipoliquidacion__contltipegr.setName( GXCCtl );
            cmbavConcepto_tipoliquidacion__contltipegr.setWebtags( "" );
            cmbavConcepto_tipoliquidacion__contltipegr.addItem("", httpContext.getMessage( "Todos", ""), (short)(0));
            cmbavConcepto_tipoliquidacion__contltipegr.addItem("SINCAUSA", httpContext.getMessage( "Despido Sin Causa", ""), (short)(0));
            cmbavConcepto_tipoliquidacion__contltipegr.addItem("SINPREAVISO", httpContext.getMessage( "Despido sin causa y sin preaviso", ""), (short)(0));
            if ( cmbavConcepto_tipoliquidacion__contltipegr.getItemCount() > 0 )
            {
               if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) && (GXutil.strcmp("", ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)).getgxTv_SdtConcepto_TipoLiquidacion_Contltipegr())==0) )
               {
                  ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)).setgxTv_SdtConcepto_TipoLiquidacion_Contltipegr( cmbavConcepto_tipoliquidacion__contltipegr.getValidValue(((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)).getgxTv_SdtConcepto_TipoLiquidacion_Contltipegr()) );
               }
            }
         }
         /* ComboBox */
         Gridlevel_tipoliquidacionRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavConcepto_tipoliquidacion__contltipegr,cmbavConcepto_tipoliquidacion__contltipegr.getInternalname(),GXutil.rtrim( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)).getgxTv_SdtConcepto_TipoLiquidacion_Contltipegr()),Integer.valueOf(1),cmbavConcepto_tipoliquidacion__contltipegr.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbavConcepto_tipoliquidacion__contltipegr.getVisible()),Integer.valueOf(cmbavConcepto_tipoliquidacion__contltipegr.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavConcepto_tipoliquidacion__contltipegr.setValue( GXutil.rtrim( ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)).getgxTv_SdtConcepto_TipoLiquidacion_Contltipegr()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_tipoliquidacion__contltipegr.getInternalname(), "Values", cmbavConcepto_tipoliquidacion__contltipegr.ToJavascriptSource(), !bGXsfl_247_Refreshing);
         send_integrity_lvl_hashesAJ2( ) ;
         Gridlevel_tipoliquidacionContainer.AddRow(Gridlevel_tipoliquidacionRow);
         nGXsfl_247_idx = ((subGridlevel_tipoliquidacion_Islastpage==1)&&(nGXsfl_247_idx+1>subgridlevel_tipoliquidacion_fnc_recordsperpage( )) ? 1 : nGXsfl_247_idx+1) ;
         sGXsfl_247_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_247_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2472( ) ;
      }
      /* End function sendrow_2472 */
   }

   public void subsflControlProps_2623( )
   {
      edtavDeletegridlinegridlevel_motivos_Internalname = sPrefix+"vDELETEGRIDLINEGRIDLEVEL_MOTIVOS_"+sGXsfl_262_idx ;
      dynavConcepto_motivosegreso__megcodigo.setInternalname( sPrefix+"CONCEPTO_MOTIVOSEGRESO__MEGCODIGO_"+sGXsfl_262_idx );
      cmbavConcepto_motivosegreso__megpreatipo.setInternalname( sPrefix+"CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO_"+sGXsfl_262_idx );
      edtavConcepto_motivosegreso__conmegmeses_Internalname = sPrefix+"CONCEPTO_MOTIVOSEGRESO__CONMEGMESES_"+sGXsfl_262_idx ;
      cmbavConcepto_motivosegreso__conmegdura.setInternalname( sPrefix+"CONCEPTO_MOTIVOSEGRESO__CONMEGDURA_"+sGXsfl_262_idx );
      edtavConcepto_motivosegreso__conmegpropor_Internalname = sPrefix+"CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR_"+sGXsfl_262_idx ;
      edtavConcepto_motivosegreso__conmegsec_Internalname = sPrefix+"CONCEPTO_MOTIVOSEGRESO__CONMEGSEC_"+sGXsfl_262_idx ;
   }

   public void subsflControlProps_fel_2623( )
   {
      edtavDeletegridlinegridlevel_motivos_Internalname = sPrefix+"vDELETEGRIDLINEGRIDLEVEL_MOTIVOS_"+sGXsfl_262_fel_idx ;
      dynavConcepto_motivosegreso__megcodigo.setInternalname( sPrefix+"CONCEPTO_MOTIVOSEGRESO__MEGCODIGO_"+sGXsfl_262_fel_idx );
      cmbavConcepto_motivosegreso__megpreatipo.setInternalname( sPrefix+"CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO_"+sGXsfl_262_fel_idx );
      edtavConcepto_motivosegreso__conmegmeses_Internalname = sPrefix+"CONCEPTO_MOTIVOSEGRESO__CONMEGMESES_"+sGXsfl_262_fel_idx ;
      cmbavConcepto_motivosegreso__conmegdura.setInternalname( sPrefix+"CONCEPTO_MOTIVOSEGRESO__CONMEGDURA_"+sGXsfl_262_fel_idx );
      edtavConcepto_motivosegreso__conmegpropor_Internalname = sPrefix+"CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR_"+sGXsfl_262_fel_idx ;
      edtavConcepto_motivosegreso__conmegsec_Internalname = sPrefix+"CONCEPTO_MOTIVOSEGRESO__CONMEGSEC_"+sGXsfl_262_fel_idx ;
   }

   public void sendrow_2623( )
   {
      subsflControlProps_2623( ) ;
      wbAJ0( ) ;
      if ( ( subGridlevel_motivos_Rows * 1 == 0 ) || ( nGXsfl_262_idx <= subgridlevel_motivos_fnc_recordsperpage( ) * 1 ) )
      {
         Gridlevel_motivosRow = GXWebRow.GetNew(context,Gridlevel_motivosContainer) ;
         if ( subGridlevel_motivos_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridlevel_motivos_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridlevel_motivos_Class, "") != 0 )
            {
               subGridlevel_motivos_Linesclass = subGridlevel_motivos_Class+"Odd" ;
            }
         }
         else if ( subGridlevel_motivos_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridlevel_motivos_Backstyle = (byte)(0) ;
            subGridlevel_motivos_Backcolor = subGridlevel_motivos_Allbackcolor ;
            if ( GXutil.strcmp(subGridlevel_motivos_Class, "") != 0 )
            {
               subGridlevel_motivos_Linesclass = subGridlevel_motivos_Class+"Uniform" ;
            }
         }
         else if ( subGridlevel_motivos_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridlevel_motivos_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridlevel_motivos_Class, "") != 0 )
            {
               subGridlevel_motivos_Linesclass = subGridlevel_motivos_Class+"Odd" ;
            }
            subGridlevel_motivos_Backcolor = (int)(0x0) ;
         }
         else if ( subGridlevel_motivos_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridlevel_motivos_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_262_idx) % (2))) == 0 )
            {
               subGridlevel_motivos_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_motivos_Class, "") != 0 )
               {
                  subGridlevel_motivos_Linesclass = subGridlevel_motivos_Class+"Even" ;
               }
            }
            else
            {
               subGridlevel_motivos_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_motivos_Class, "") != 0 )
               {
                  subGridlevel_motivos_Linesclass = subGridlevel_motivos_Class+"Odd" ;
               }
            }
         }
         if ( Gridlevel_motivosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_262_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Gridlevel_motivosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDeletegridlinegridlevel_motivos_Enabled!=0)&&(edtavDeletegridlinegridlevel_motivos_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 263,'"+sPrefix+"',false,'"+sGXsfl_262_idx+"',262)\"" : " ") ;
         ROClassString = edtavDeletegridlinegridlevel_motivos_Class ;
         Gridlevel_motivosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDeletegridlinegridlevel_motivos_Internalname,GXutil.rtrim( AV61DeleteGridLineGridLevel_Motivos),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDeletegridlinegridlevel_motivos_Enabled!=0)&&(edtavDeletegridlinegridlevel_motivos_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,263);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVDELETEGRIDLINEGRIDLEVEL_MOTIVOS.CLICK."+sGXsfl_262_idx+"'","","","","",edtavDeletegridlinegridlevel_motivos_Jsonclick,Integer.valueOf(5),edtavDeletegridlinegridlevel_motivos_Class,"",ROClassString,edtavDeletegridlinegridlevel_motivos_Columnclass,edtavDeletegridlinegridlevel_motivos_Columnheaderclass,Integer.valueOf(-1),Integer.valueOf(edtavDeletegridlinegridlevel_motivos_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(262),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         gxvconcepto_motivosegreso__megcodigo_htmlAJ3( AV16CliCod) ;
         /* Subfile cell */
         if ( Gridlevel_motivosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((dynavConcepto_motivosegreso__megcodigo.getEnabled()!=0)&&(dynavConcepto_motivosegreso__megcodigo.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 264,'"+sPrefix+"',false,'"+sGXsfl_262_idx+"',262)\"" : " ") ;
         GXCCtl = "CONCEPTO_MOTIVOSEGRESO__MEGCODIGO_" + sGXsfl_262_idx ;
         dynavConcepto_motivosegreso__megcodigo.setName( GXCCtl );
         dynavConcepto_motivosegreso__megcodigo.setWebtags( "" );
         /* ComboBox */
         Gridlevel_motivosRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynavConcepto_motivosegreso__megcodigo,dynavConcepto_motivosegreso__megcodigo.getInternalname(),GXutil.rtrim( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Megcodigo()),Integer.valueOf(1),dynavConcepto_motivosegreso__megcodigo.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(dynavConcepto_motivosegreso__megcodigo.getEnabled()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute",dynavConcepto_motivosegreso__megcodigo.getColumnClass(),dynavConcepto_motivosegreso__megcodigo.getColumnHeaderClass(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((dynavConcepto_motivosegreso__megcodigo.getEnabled()!=0)&&(dynavConcepto_motivosegreso__megcodigo.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,264);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         dynavConcepto_motivosegreso__megcodigo.setValue( GXutil.rtrim( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Megcodigo()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavConcepto_motivosegreso__megcodigo.getInternalname(), "Values", dynavConcepto_motivosegreso__megcodigo.ToJavascriptSource(), !bGXsfl_262_Refreshing);
         /* Subfile cell */
         if ( Gridlevel_motivosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((cmbavConcepto_motivosegreso__megpreatipo.getEnabled()!=0)&&(cmbavConcepto_motivosegreso__megpreatipo.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 265,'"+sPrefix+"',false,'"+sGXsfl_262_idx+"',262)\"" : " ") ;
         GXCCtl = "CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO_" + sGXsfl_262_idx ;
         cmbavConcepto_motivosegreso__megpreatipo.setName( GXCCtl );
         cmbavConcepto_motivosegreso__megpreatipo.setWebtags( "" );
         cmbavConcepto_motivosegreso__megpreatipo.addItem("CON", httpContext.getMessage( "Con preaviso", ""), (short)(0));
         cmbavConcepto_motivosegreso__megpreatipo.addItem("SIN", httpContext.getMessage( "Sin preaviso", ""), (short)(0));
         cmbavConcepto_motivosegreso__megpreatipo.addItem("", httpContext.getMessage( "Ambos (Con o sin preaviso)", ""), (short)(0));
         if ( cmbavConcepto_motivosegreso__megpreatipo.getItemCount() > 0 )
         {
            if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) && (GXutil.strcmp("", ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Megpreatipo())==0) )
            {
               ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).setgxTv_SdtConcepto_MotivosEgreso_Megpreatipo( cmbavConcepto_motivosegreso__megpreatipo.getValidValue(((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Megpreatipo()) );
            }
         }
         /* ComboBox */
         Gridlevel_motivosRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavConcepto_motivosegreso__megpreatipo,cmbavConcepto_motivosegreso__megpreatipo.getInternalname(),GXutil.rtrim( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Megpreatipo()),Integer.valueOf(1),cmbavConcepto_motivosegreso__megpreatipo.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbavConcepto_motivosegreso__megpreatipo.getEnabled()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute",cmbavConcepto_motivosegreso__megpreatipo.getColumnClass(),cmbavConcepto_motivosegreso__megpreatipo.getColumnHeaderClass(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavConcepto_motivosegreso__megpreatipo.getEnabled()!=0)&&(cmbavConcepto_motivosegreso__megpreatipo.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,265);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavConcepto_motivosegreso__megpreatipo.setValue( GXutil.rtrim( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Megpreatipo()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_motivosegreso__megpreatipo.getInternalname(), "Values", cmbavConcepto_motivosegreso__megpreatipo.ToJavascriptSource(), !bGXsfl_262_Refreshing);
         /* Subfile cell */
         if ( Gridlevel_motivosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavConcepto_motivosegreso__conmegmeses_Enabled!=0)&&(edtavConcepto_motivosegreso__conmegmeses_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 266,'"+sPrefix+"',false,'"+sGXsfl_262_idx+"',262)\"" : " ") ;
         ROClassString = "Attribute" ;
         Gridlevel_motivosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavConcepto_motivosegreso__conmegmeses_Internalname,GXutil.ltrim( localUtil.ntoc( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Conmegmeses(), (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Conmegmeses()), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavConcepto_motivosegreso__conmegmeses_Enabled!=0)&&(edtavConcepto_motivosegreso__conmegmeses_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,266);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavConcepto_motivosegreso__conmegmeses_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,edtavConcepto_motivosegreso__conmegmeses_Columnclass,edtavConcepto_motivosegreso__conmegmeses_Columnheaderclass,Integer.valueOf(-1),Integer.valueOf(edtavConcepto_motivosegreso__conmegmeses_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(262),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridlevel_motivosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((cmbavConcepto_motivosegreso__conmegdura.getEnabled()!=0)&&(cmbavConcepto_motivosegreso__conmegdura.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 267,'"+sPrefix+"',false,'"+sGXsfl_262_idx+"',262)\"" : " ") ;
         GXCCtl = "CONCEPTO_MOTIVOSEGRESO__CONMEGDURA_" + sGXsfl_262_idx ;
         cmbavConcepto_motivosegreso__conmegdura.setName( GXCCtl );
         cmbavConcepto_motivosegreso__conmegdura.setWebtags( "" );
         cmbavConcepto_motivosegreso__conmegdura.addItem("años", httpContext.getMessage( "años", ""), (short)(0));
         cmbavConcepto_motivosegreso__conmegdura.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
         if ( cmbavConcepto_motivosegreso__conmegdura.getItemCount() > 0 )
         {
            if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) && (GXutil.strcmp("", ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Conmegdura())==0) )
            {
               ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).setgxTv_SdtConcepto_MotivosEgreso_Conmegdura( cmbavConcepto_motivosegreso__conmegdura.getValidValue(((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Conmegdura()) );
            }
         }
         /* ComboBox */
         Gridlevel_motivosRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavConcepto_motivosegreso__conmegdura,cmbavConcepto_motivosegreso__conmegdura.getInternalname(),GXutil.rtrim( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Conmegdura()),Integer.valueOf(1),cmbavConcepto_motivosegreso__conmegdura.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbavConcepto_motivosegreso__conmegdura.getEnabled()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute",cmbavConcepto_motivosegreso__conmegdura.getColumnClass(),cmbavConcepto_motivosegreso__conmegdura.getColumnHeaderClass(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavConcepto_motivosegreso__conmegdura.getEnabled()!=0)&&(cmbavConcepto_motivosegreso__conmegdura.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,267);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavConcepto_motivosegreso__conmegdura.setValue( GXutil.rtrim( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Conmegdura()) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConcepto_motivosegreso__conmegdura.getInternalname(), "Values", cmbavConcepto_motivosegreso__conmegdura.ToJavascriptSource(), !bGXsfl_262_Refreshing);
         /* Subfile cell */
         if ( Gridlevel_motivosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavConcepto_motivosegreso__conmegpropor_Enabled!=0)&&(edtavConcepto_motivosegreso__conmegpropor_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 268,'"+sPrefix+"',false,'"+sGXsfl_262_idx+"',262)\"" : " ") ;
         ROClassString = "Attribute" ;
         Gridlevel_motivosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavConcepto_motivosegreso__conmegpropor_Internalname,GXutil.ltrim( localUtil.ntoc( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Conmegpropor(), (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Conmegpropor(), "9.9999")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+((edtavConcepto_motivosegreso__conmegpropor_Enabled!=0)&&(edtavConcepto_motivosegreso__conmegpropor_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,268);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavConcepto_motivosegreso__conmegpropor_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,edtavConcepto_motivosegreso__conmegpropor_Columnclass,edtavConcepto_motivosegreso__conmegpropor_Columnheaderclass,Integer.valueOf(-1),Integer.valueOf(edtavConcepto_motivosegreso__conmegpropor_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(262),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridlevel_motivosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_motivosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavConcepto_motivosegreso__conmegsec_Internalname,GXutil.ltrim( localUtil.ntoc( ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Conmegsec(), (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavConcepto_motivosegreso__conmegsec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Conmegsec()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Conmegsec()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavConcepto_motivosegreso__conmegsec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavConcepto_motivosegreso__conmegsec_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(262),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashesAJ3( ) ;
         GXCCtl = "vCONCEPTO_" + sGXsfl_262_idx ;
         if ( httpContext.isAjaxRequest( ) )
         {
            httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+GXCCtl, AV7Concepto);
         }
         else
         {
            httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+GXCCtl, AV7Concepto);
         }
         Gridlevel_motivosContainer.AddRow(Gridlevel_motivosRow);
         nGXsfl_262_idx = ((subGridlevel_motivos_Islastpage==1)&&(nGXsfl_262_idx+1>subgridlevel_motivos_fnc_recordsperpage( )) ? 1 : nGXsfl_262_idx+1) ;
         sGXsfl_262_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_262_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2623( ) ;
      }
      /* End function sendrow_2623 */
   }

   public void startgridcontrol247( )
   {
      if ( Gridlevel_tipoliquidacionContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"Gridlevel_tipoliquidacionContainer"+"DivS\" data-gxgridid=\"247\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridlevel_tipoliquidacion_Internalname, subGridlevel_tipoliquidacion_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridlevel_tipoliquidacion_Backcolorstyle == 0 )
         {
            subGridlevel_tipoliquidacion_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridlevel_tipoliquidacion_Class) > 0 )
            {
               subGridlevel_tipoliquidacion_Linesclass = subGridlevel_tipoliquidacion_Class+"Title" ;
            }
         }
         else
         {
            subGridlevel_tipoliquidacion_Titlebackstyle = (byte)(1) ;
            if ( subGridlevel_tipoliquidacion_Backcolorstyle == 1 )
            {
               subGridlevel_tipoliquidacion_Titlebackcolor = subGridlevel_tipoliquidacion_Allbackcolor ;
               if ( GXutil.len( subGridlevel_tipoliquidacion_Class) > 0 )
               {
                  subGridlevel_tipoliquidacion_Linesclass = subGridlevel_tipoliquidacion_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridlevel_tipoliquidacion_Class) > 0 )
               {
                  subGridlevel_tipoliquidacion_Linesclass = subGridlevel_tipoliquidacion_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavDeletegridlinegridlevel_tipoliquidacion_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de Liquidación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbavConcepto_tipoliquidacion__contltipegr.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Motivo de egreso", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("GridName", "Gridlevel_tipoliquidacion");
      }
      else
      {
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("GridName", "Gridlevel_tipoliquidacion");
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("Header", subGridlevel_tipoliquidacion_Header);
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("Class", "WorkWith");
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("CmpContext", sPrefix);
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("InMasterPage", "false");
         Gridlevel_tipoliquidacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_tipoliquidacionColumn.AddObjectProperty("Value", GXutil.rtrim( AV9DeleteGridLineGridLevel_TipoLiquidacion));
         Gridlevel_tipoliquidacionColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavDeletegridlinegridlevel_tipoliquidacion_Columnclass));
         Gridlevel_tipoliquidacionColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass));
         Gridlevel_tipoliquidacionColumn.AddObjectProperty("Class", GXutil.rtrim( edtavDeletegridlinegridlevel_tipoliquidacion_Class));
         Gridlevel_tipoliquidacionColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDeletegridlinegridlevel_tipoliquidacion_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridlevel_tipoliquidacionContainer.AddColumnProperties(Gridlevel_tipoliquidacionColumn);
         Gridlevel_tipoliquidacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_tipoliquidacionColumn.AddObjectProperty("Columnclass", GXutil.rtrim( dynavConcepto_tipoliquidacion__tliqcod.getColumnClass()));
         Gridlevel_tipoliquidacionColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( dynavConcepto_tipoliquidacion__tliqcod.getColumnHeaderClass()));
         Gridlevel_tipoliquidacionColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynavConcepto_tipoliquidacion__tliqcod.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         Gridlevel_tipoliquidacionContainer.AddColumnProperties(Gridlevel_tipoliquidacionColumn);
         Gridlevel_tipoliquidacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_tipoliquidacionColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbavConcepto_tipoliquidacion__contltipegr.getVisible(), (byte)(5), (byte)(0), ".", "")));
         Gridlevel_tipoliquidacionColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavConcepto_tipoliquidacion__contltipegr.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         Gridlevel_tipoliquidacionContainer.AddColumnProperties(Gridlevel_tipoliquidacionColumn);
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_tipoliquidacionContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_tipoliquidacion_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol262( )
   {
      if ( Gridlevel_motivosContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"Gridlevel_motivosContainer"+"DivS\" data-gxgridid=\"262\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridlevel_motivos_Internalname, subGridlevel_motivos_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridlevel_motivos_Backcolorstyle == 0 )
         {
            subGridlevel_motivos_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridlevel_motivos_Class) > 0 )
            {
               subGridlevel_motivos_Linesclass = subGridlevel_motivos_Class+"Title" ;
            }
         }
         else
         {
            subGridlevel_motivos_Titlebackstyle = (byte)(1) ;
            if ( subGridlevel_motivos_Backcolorstyle == 1 )
            {
               subGridlevel_motivos_Titlebackcolor = subGridlevel_motivos_Allbackcolor ;
               if ( GXutil.len( subGridlevel_motivos_Class) > 0 )
               {
                  subGridlevel_motivos_Linesclass = subGridlevel_motivos_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridlevel_motivos_Class) > 0 )
               {
                  subGridlevel_motivos_Linesclass = subGridlevel_motivos_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavDeletegridlinegridlevel_motivos_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Motivo Egreso", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Preaviso", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Con antiguedad mayor a", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Proporción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Con Meg Sec", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Gridlevel_motivosContainer.AddObjectProperty("GridName", "Gridlevel_motivos");
      }
      else
      {
         Gridlevel_motivosContainer.AddObjectProperty("GridName", "Gridlevel_motivos");
         Gridlevel_motivosContainer.AddObjectProperty("Header", subGridlevel_motivos_Header);
         Gridlevel_motivosContainer.AddObjectProperty("Class", "WorkWith");
         Gridlevel_motivosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_motivos_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddObjectProperty("CmpContext", sPrefix);
         Gridlevel_motivosContainer.AddObjectProperty("InMasterPage", "false");
         Gridlevel_motivosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_motivosColumn.AddObjectProperty("Value", GXutil.rtrim( AV61DeleteGridLineGridLevel_Motivos));
         Gridlevel_motivosColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavDeletegridlinegridlevel_motivos_Columnclass));
         Gridlevel_motivosColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( edtavDeletegridlinegridlevel_motivos_Columnheaderclass));
         Gridlevel_motivosColumn.AddObjectProperty("Class", GXutil.rtrim( edtavDeletegridlinegridlevel_motivos_Class));
         Gridlevel_motivosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDeletegridlinegridlevel_motivos_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddColumnProperties(Gridlevel_motivosColumn);
         Gridlevel_motivosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_motivosColumn.AddObjectProperty("Columnclass", GXutil.rtrim( dynavConcepto_motivosegreso__megcodigo.getColumnClass()));
         Gridlevel_motivosColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( dynavConcepto_motivosegreso__megcodigo.getColumnHeaderClass()));
         Gridlevel_motivosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynavConcepto_motivosegreso__megcodigo.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddColumnProperties(Gridlevel_motivosColumn);
         Gridlevel_motivosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_motivosColumn.AddObjectProperty("Columnclass", GXutil.rtrim( cmbavConcepto_motivosegreso__megpreatipo.getColumnClass()));
         Gridlevel_motivosColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( cmbavConcepto_motivosegreso__megpreatipo.getColumnHeaderClass()));
         Gridlevel_motivosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavConcepto_motivosegreso__megpreatipo.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddColumnProperties(Gridlevel_motivosColumn);
         Gridlevel_motivosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_motivosColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavConcepto_motivosegreso__conmegmeses_Columnclass));
         Gridlevel_motivosColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( edtavConcepto_motivosegreso__conmegmeses_Columnheaderclass));
         Gridlevel_motivosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavConcepto_motivosegreso__conmegmeses_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddColumnProperties(Gridlevel_motivosColumn);
         Gridlevel_motivosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_motivosColumn.AddObjectProperty("Columnclass", GXutil.rtrim( cmbavConcepto_motivosegreso__conmegdura.getColumnClass()));
         Gridlevel_motivosColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( cmbavConcepto_motivosegreso__conmegdura.getColumnHeaderClass()));
         Gridlevel_motivosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavConcepto_motivosegreso__conmegdura.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddColumnProperties(Gridlevel_motivosColumn);
         Gridlevel_motivosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_motivosColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavConcepto_motivosegreso__conmegpropor_Columnclass));
         Gridlevel_motivosColumn.AddObjectProperty("Columnheaderclass", GXutil.rtrim( edtavConcepto_motivosegreso__conmegpropor_Columnheaderclass));
         Gridlevel_motivosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavConcepto_motivosegreso__conmegpropor_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddColumnProperties(Gridlevel_motivosColumn);
         Gridlevel_motivosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_motivosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavConcepto_motivosegreso__conmegsec_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddColumnProperties(Gridlevel_motivosColumn);
         Gridlevel_motivosContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_motivos_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_motivos_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_motivos_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_motivos_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_motivos_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_motivos_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_motivosContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_motivos_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblTab1_title_Internalname = sPrefix+"TAB1_TITLE" ;
      cmbavConcepto_tipoconcod.setInternalname( sPrefix+"CONCEPTO_TIPOCONCOD" );
      cmbavConcepto_subtipoconcod1.setInternalname( sPrefix+"CONCEPTO_SUBTIPOCONCOD1" );
      cmbavConcepto_subtipoconcod2.setInternalname( sPrefix+"CONCEPTO_SUBTIPOCONCOD2" );
      edtavConcepto_concodigo_Internalname = sPrefix+"CONCEPTO_CONCODIGO" ;
      edtavConcepto_condescrip_Internalname = sPrefix+"CONCEPTO_CONDESCRIP" ;
      dynavConcepto_conrelsec.setInternalname( sPrefix+"CONCEPTO_CONRELSEC" );
      divConcepto_conrelsec_cell_Internalname = sPrefix+"CONCEPTO_CONRELSEC_CELL" ;
      divTableattributes_Internalname = sPrefix+"TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = sPrefix+"DVPANEL_TABLEATTRIBUTES" ;
      edtavConcepto_conformula_Internalname = sPrefix+"CONCEPTO_CONFORMULA" ;
      tblFormulatbl_Internalname = sPrefix+"FORMULATBL" ;
      chkavConcepto_conpuenov.setInternalname( sPrefix+"CONCEPTO_CONPUENOV" );
      chkavConcepto_convariable.setInternalname( sPrefix+"CONCEPTO_CONVARIABLE" );
      dynavConcepto_apliigg.setInternalname( sPrefix+"CONCEPTO_APLIIGG" );
      edtavConcepto_concodafip_Internalname = sPrefix+"CONCEPTO_CONCODAFIP" ;
      divConcepto_concodafip_cell_Internalname = sPrefix+"CONCEPTO_CONCODAFIP_CELL" ;
      chkavConcepto_conhabilitado.setInternalname( sPrefix+"CONCEPTO_CONHABILITADO" );
      cmbavConcepto_convigencia.setInternalname( sPrefix+"CONCEPTO_CONVIGENCIA" );
      cmbavConcepto_concondicion.setInternalname( sPrefix+"CONCEPTO_CONCONDICION" );
      edtavConcepto_concondcodigo_Internalname = sPrefix+"CONCEPTO_CONCONDCODIGO" ;
      edtavConcepto_conobservacion_Internalname = sPrefix+"CONCEPTO_CONOBSERVACION" ;
      chkavConcepto_conrecalcular.setInternalname( sPrefix+"CONCEPTO_CONRECALCULAR" );
      lblTextblockrangodesde_Internalname = sPrefix+"TEXTBLOCKRANGODESDE" ;
      edtavRangodesde_Internalname = sPrefix+"vRANGODESDE" ;
      divUnnamedtablerangodesde_Internalname = sPrefix+"UNNAMEDTABLERANGODESDE" ;
      lblTextblockrangohasta_Internalname = sPrefix+"TEXTBLOCKRANGOHASTA" ;
      edtavRangohasta_Internalname = sPrefix+"vRANGOHASTA" ;
      divUnnamedtablerangohasta_Internalname = sPrefix+"UNNAMEDTABLERANGOHASTA" ;
      divTablerango_Internalname = sPrefix+"TABLERANGO" ;
      chkavConcepto_conmostrarpos.setInternalname( sPrefix+"CONCEPTO_CONMOSTRARPOS" );
      chkavConcepto_conerrorsicero.setInternalname( sPrefix+"CONCEPTO_CONERRORSICERO" );
      cmbavConcepto_conadeldescu.setInternalname( sPrefix+"CONCEPTO_CONADELDESCU" );
      cmbavConcepto_consacdeven.setInternalname( sPrefix+"CONCEPTO_CONSACDEVEN" );
      edtavConcepto_conorden_Internalname = sPrefix+"CONCEPTO_CONORDEN" ;
      edtavConcepto_conordejec_Internalname = sPrefix+"CONCEPTO_CONORDEJEC" ;
      cmbavConcepto_conbaselic.setInternalname( sPrefix+"CONCEPTO_CONBASELIC" );
      cmbavConcepto_conbaselicprom.setInternalname( sPrefix+"CONCEPTO_CONBASELICPROM" );
      cmbavConcepto_conbasefer.setInternalname( sPrefix+"CONCEPTO_CONBASEFER" );
      cmbavConcepto_conbaseferprom.setInternalname( sPrefix+"CONCEPTO_CONBASEFERPROM" );
      cmbavConcepto_conbasehorext.setInternalname( sPrefix+"CONCEPTO_CONBASEHOREXT" );
      cmbavConcepto_conbasehorextprom.setInternalname( sPrefix+"CONCEPTO_CONBASEHOREXTPROM" );
      cmbavConcepto_conbasepres.setInternalname( sPrefix+"CONCEPTO_CONBASEPRES" );
      cmbavConcepto_conbaseant.setInternalname( sPrefix+"CONCEPTO_CONBASEANT" );
      cmbavConcepto_conbaseosdif.setInternalname( sPrefix+"CONCEPTO_CONBASEOSDIF" );
      cmbavConcepto_conbaseaus.setInternalname( sPrefix+"CONCEPTO_CONBASEAUS" );
      cmbavConcepto_conbaseausprom.setInternalname( sPrefix+"CONCEPTO_CONBASEAUSPROM" );
      dynavConcepto_conceptoconvecodigo.setInternalname( sPrefix+"CONCEPTO_CONCEPTOCONVECODIGO" );
      dynavConcepto_concuendebe.setInternalname( sPrefix+"CONCEPTO_CONCUENDEBE" );
      dynavConcepto_concuenhaber.setInternalname( sPrefix+"CONCEPTO_CONCUENHABER" );
      divUnnamedtable4_Internalname = sPrefix+"UNNAMEDTABLE4" ;
      Dvpanel_unnamedtable4_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE4" ;
      divDvpanel_unnamedtable4_cell_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE4_CELL" ;
      edtavDeletegridlinegridlevel_tipoliquidacion_Internalname = sPrefix+"vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION" ;
      dynavConcepto_tipoliquidacion__tliqcod.setInternalname( sPrefix+"CONCEPTO_TIPOLIQUIDACION__TLIQCOD" );
      cmbavConcepto_tipoliquidacion__contltipegr.setInternalname( sPrefix+"CONCEPTO_TIPOLIQUIDACION__CONTLTIPEGR" );
      bttBtnaddgridlinegridlevel_tipoliquidacion_Internalname = sPrefix+"BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION" ;
      divTableleaflevel_tipoliquidacion_Internalname = sPrefix+"TABLELEAFLEVEL_TIPOLIQUIDACION" ;
      bttBtnaddgridlinegridlevel_motivosegreso_Internalname = sPrefix+"BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO" ;
      edtavDeletegridlinegridlevel_motivos_Internalname = sPrefix+"vDELETEGRIDLINEGRIDLEVEL_MOTIVOS" ;
      dynavConcepto_motivosegreso__megcodigo.setInternalname( sPrefix+"CONCEPTO_MOTIVOSEGRESO__MEGCODIGO" );
      cmbavConcepto_motivosegreso__megpreatipo.setInternalname( sPrefix+"CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO" );
      edtavConcepto_motivosegreso__conmegmeses_Internalname = sPrefix+"CONCEPTO_MOTIVOSEGRESO__CONMEGMESES" ;
      cmbavConcepto_motivosegreso__conmegdura.setInternalname( sPrefix+"CONCEPTO_MOTIVOSEGRESO__CONMEGDURA" );
      edtavConcepto_motivosegreso__conmegpropor_Internalname = sPrefix+"CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR" ;
      edtavConcepto_motivosegreso__conmegsec_Internalname = sPrefix+"CONCEPTO_MOTIVOSEGRESO__CONMEGSEC" ;
      bttBtnaddgridlinegridlevel_motivos_Internalname = sPrefix+"BTNADDGRIDLINEGRIDLEVEL_MOTIVOS" ;
      divTableleaflevel_motivosegreso_Internalname = sPrefix+"TABLELEAFLEVEL_MOTIVOSEGRESO" ;
      divUnnamedtable3_Internalname = sPrefix+"UNNAMEDTABLE3" ;
      Dvpanel_unnamedtable3_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE3" ;
      divUnnamedtable2_Internalname = sPrefix+"UNNAMEDTABLE2" ;
      lblTab3_title_Internalname = sPrefix+"TAB3_TITLE" ;
      lblS13_Internalname = sPrefix+"S13" ;
      lblSipatxt_3_Internalname = sPrefix+"SIPATXT_3" ;
      lblInjtxt_3_Internalname = sPrefix+"INJTXT_3" ;
      lblOstxt_3_Internalname = sPrefix+"OSTXT_3" ;
      lblFsr_3_Internalname = sPrefix+"FSR_3" ;
      lblUatretxt_3_Internalname = sPrefix+"UATRETXT_3" ;
      lblAafftxt_3_Internalname = sPrefix+"AAFFTXT_3" ;
      lblFnetxt_3_Internalname = sPrefix+"FNETXT_3" ;
      lblDiftxt_3_Internalname = sPrefix+"DIFTXT_3" ;
      lblRegesptxt_3_Internalname = sPrefix+"REGESPTXT_3" ;
      lblAportxt_3_Internalname = sPrefix+"APORTXT_3" ;
      cmbavConcepto_consipaapo.setInternalname( sPrefix+"CONCEPTO_CONSIPAAPO" );
      cmbavConcepto_coninssjypapo.setInternalname( sPrefix+"CONCEPTO_CONINSSJYPAPO" );
      cmbavConcepto_conobrasocapo.setInternalname( sPrefix+"CONCEPTO_CONOBRASOCAPO" );
      cmbavConcepto_confonsolredapo.setInternalname( sPrefix+"CONCEPTO_CONFONSOLREDAPO" );
      cmbavConcepto_conrenateaapo.setInternalname( sPrefix+"CONCEPTO_CONRENATEAAPO" );
      lblGuion1_3_Internalname = sPrefix+"GUION1_3" ;
      lblGuion2_3_Internalname = sPrefix+"GUION2_3" ;
      cmbavConcepto_conregdifapo.setInternalname( sPrefix+"CONCEPTO_CONREGDIFAPO" );
      cmbavConcepto_conregespapo.setInternalname( sPrefix+"CONCEPTO_CONREGESPAPO" );
      lblContrtxt_3_Internalname = sPrefix+"CONTRTXT_3" ;
      cmbavConcepto_consipacont.setInternalname( sPrefix+"CONCEPTO_CONSIPACONT" );
      cmbavConcepto_coninssjypcont.setInternalname( sPrefix+"CONCEPTO_CONINSSJYPCONT" );
      cmbavConcepto_conobrasoccont.setInternalname( sPrefix+"CONCEPTO_CONOBRASOCCONT" );
      cmbavConcepto_confonsolredcont.setInternalname( sPrefix+"CONCEPTO_CONFONSOLREDCONT" );
      cmbavConcepto_conrenateacont.setInternalname( sPrefix+"CONCEPTO_CONRENATEACONT" );
      cmbavConcepto_conasigfamcont.setInternalname( sPrefix+"CONCEPTO_CONASIGFAMCONT" );
      cmbavConcepto_confonnacempcont.setInternalname( sPrefix+"CONCEPTO_CONFONNACEMPCONT" );
      lblGuion3_3_Internalname = sPrefix+"GUION3_3" ;
      lblGuion4_3_Internalname = sPrefix+"GUION4_3" ;
      lblLrt_txt_3_Internalname = sPrefix+"LRT_TXT_3" ;
      cmbavConcepto_conleyrietrabcont.setInternalname( sPrefix+"CONCEPTO_CONLEYRIETRABCONT" );
      tblTbl23_Internalname = sPrefix+"TBL23" ;
      divPanelapocont3_Internalname = sPrefix+"PANELAPOCONT3" ;
      Dvpanel_panelapocont3_Internalname = sPrefix+"DVPANEL_PANELAPOCONT3" ;
      tblTblapocon3_Internalname = sPrefix+"TBLAPOCON3" ;
      divUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      Gxuitabspanel_tabs1_Internalname = sPrefix+"GXUITABSPANEL_TABS1" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      bttBtnenter_Internalname = sPrefix+"BTNENTER" ;
      bttBtncancel_Internalname = sPrefix+"BTNCANCEL" ;
      tblTablemainfix_Internalname = sPrefix+"TABLEMAINFIX" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      chkavConcepto_consegunpla.setInternalname( sPrefix+"CONCEPTO_CONSEGUNPLA" );
      cmbavConcepto_conprereq.setInternalname( sPrefix+"CONCEPTO_CONPREREQ" );
      edtavConcepto_conrangocant_Internalname = sPrefix+"CONCEPTO_CONRANGOCANT" ;
      edtavConcepto_clicod_Internalname = sPrefix+"CONCEPTO_CLICOD" ;
      Gridlevel_motivos_empowerer_Internalname = sPrefix+"GRIDLEVEL_MOTIVOS_EMPOWERER" ;
      Gridlevel_tipoliquidacion_empowerer_Internalname = sPrefix+"GRIDLEVEL_TIPOLIQUIDACION_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGridlevel_tipoliquidacion_Internalname = sPrefix+"GRIDLEVEL_TIPOLIQUIDACION" ;
      subGridlevel_motivos_Internalname = sPrefix+"GRIDLEVEL_MOTIVOS" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      subGridlevel_motivos_Allowcollapsing = (byte)(0) ;
      subGridlevel_motivos_Allowselection = (byte)(0) ;
      subGridlevel_motivos_Header = "" ;
      subGridlevel_tipoliquidacion_Allowcollapsing = (byte)(0) ;
      subGridlevel_tipoliquidacion_Allowselection = (byte)(0) ;
      subGridlevel_tipoliquidacion_Header = "" ;
      edtavConcepto_motivosegreso__conmegsec_Jsonclick = "" ;
      edtavConcepto_motivosegreso__conmegsec_Enabled = 0 ;
      edtavConcepto_motivosegreso__conmegpropor_Jsonclick = "" ;
      edtavConcepto_motivosegreso__conmegpropor_Columnheaderclass = "" ;
      edtavConcepto_motivosegreso__conmegpropor_Columnclass = "WWColumn" ;
      edtavConcepto_motivosegreso__conmegpropor_Visible = -1 ;
      edtavConcepto_motivosegreso__conmegpropor_Enabled = 1 ;
      cmbavConcepto_motivosegreso__conmegdura.setJsonclick( "" );
      cmbavConcepto_motivosegreso__conmegdura.setVisible( -1 );
      cmbavConcepto_motivosegreso__conmegdura.setEnabled( 1 );
      cmbavConcepto_motivosegreso__conmegdura.setColumnHeaderClass( "" );
      cmbavConcepto_motivosegreso__conmegdura.setColumnClass( "WWColumn" );
      edtavConcepto_motivosegreso__conmegmeses_Jsonclick = "" ;
      edtavConcepto_motivosegreso__conmegmeses_Columnheaderclass = "" ;
      edtavConcepto_motivosegreso__conmegmeses_Columnclass = "WWColumn" ;
      edtavConcepto_motivosegreso__conmegmeses_Visible = -1 ;
      edtavConcepto_motivosegreso__conmegmeses_Enabled = 1 ;
      cmbavConcepto_motivosegreso__megpreatipo.setJsonclick( "" );
      cmbavConcepto_motivosegreso__megpreatipo.setVisible( -1 );
      cmbavConcepto_motivosegreso__megpreatipo.setEnabled( 1 );
      cmbavConcepto_motivosegreso__megpreatipo.setColumnHeaderClass( "" );
      cmbavConcepto_motivosegreso__megpreatipo.setColumnClass( "WWColumn" );
      dynavConcepto_motivosegreso__megcodigo.setJsonclick( "" );
      dynavConcepto_motivosegreso__megcodigo.setVisible( -1 );
      dynavConcepto_motivosegreso__megcodigo.setEnabled( 1 );
      dynavConcepto_motivosegreso__megcodigo.setColumnHeaderClass( "" );
      dynavConcepto_motivosegreso__megcodigo.setColumnClass( "WWColumn" );
      edtavDeletegridlinegridlevel_motivos_Jsonclick = "" ;
      edtavDeletegridlinegridlevel_motivos_Columnclass = "WWIconActionColumn" ;
      edtavDeletegridlinegridlevel_motivos_Class = "Attribute" ;
      edtavDeletegridlinegridlevel_motivos_Visible = -1 ;
      edtavDeletegridlinegridlevel_motivos_Enabled = 1 ;
      subGridlevel_motivos_Class = "WorkWith" ;
      subGridlevel_motivos_Backcolorstyle = (byte)(0) ;
      cmbavConcepto_tipoliquidacion__contltipegr.setJsonclick( "" );
      cmbavConcepto_tipoliquidacion__contltipegr.setEnabled( 0 );
      cmbavConcepto_tipoliquidacion__contltipegr.setVisible( 0 );
      dynavConcepto_tipoliquidacion__tliqcod.setJsonclick( "" );
      dynavConcepto_tipoliquidacion__tliqcod.setVisible( -1 );
      dynavConcepto_tipoliquidacion__tliqcod.setEnabled( 0 );
      dynavConcepto_tipoliquidacion__tliqcod.setColumnHeaderClass( "" );
      dynavConcepto_tipoliquidacion__tliqcod.setColumnClass( "WWColumn" );
      edtavDeletegridlinegridlevel_tipoliquidacion_Jsonclick = "" ;
      edtavDeletegridlinegridlevel_tipoliquidacion_Columnclass = "WWIconActionColumn" ;
      edtavDeletegridlinegridlevel_tipoliquidacion_Class = "Attribute" ;
      edtavDeletegridlinegridlevel_tipoliquidacion_Visible = -1 ;
      edtavDeletegridlinegridlevel_tipoliquidacion_Enabled = 1 ;
      subGridlevel_tipoliquidacion_Class = "WorkWith" ;
      subGridlevel_tipoliquidacion_Backcolorstyle = (byte)(0) ;
      edtavConcepto_conformula_Enabled = 0 ;
      cmbavConcepto_conleyrietrabcont.setJsonclick( "" );
      cmbavConcepto_conleyrietrabcont.setEnabled( 1 );
      cmbavConcepto_confonnacempcont.setJsonclick( "" );
      cmbavConcepto_confonnacempcont.setEnabled( 1 );
      cmbavConcepto_conasigfamcont.setJsonclick( "" );
      cmbavConcepto_conasigfamcont.setEnabled( 1 );
      cmbavConcepto_conrenateacont.setJsonclick( "" );
      cmbavConcepto_conrenateacont.setEnabled( 1 );
      cmbavConcepto_confonsolredcont.setJsonclick( "" );
      cmbavConcepto_confonsolredcont.setEnabled( 1 );
      cmbavConcepto_conobrasoccont.setJsonclick( "" );
      cmbavConcepto_conobrasoccont.setEnabled( 1 );
      cmbavConcepto_coninssjypcont.setJsonclick( "" );
      cmbavConcepto_coninssjypcont.setEnabled( 1 );
      cmbavConcepto_consipacont.setJsonclick( "" );
      cmbavConcepto_consipacont.setEnabled( 1 );
      cmbavConcepto_conregespapo.setJsonclick( "" );
      cmbavConcepto_conregespapo.setEnabled( 1 );
      cmbavConcepto_conregdifapo.setJsonclick( "" );
      cmbavConcepto_conregdifapo.setEnabled( 1 );
      cmbavConcepto_conrenateaapo.setJsonclick( "" );
      cmbavConcepto_conrenateaapo.setEnabled( 1 );
      cmbavConcepto_confonsolredapo.setJsonclick( "" );
      cmbavConcepto_confonsolredapo.setEnabled( 1 );
      cmbavConcepto_conobrasocapo.setJsonclick( "" );
      cmbavConcepto_conobrasocapo.setEnabled( 1 );
      cmbavConcepto_coninssjypapo.setJsonclick( "" );
      cmbavConcepto_coninssjypapo.setEnabled( 1 );
      cmbavConcepto_consipaapo.setJsonclick( "" );
      cmbavConcepto_consipaapo.setEnabled( 1 );
      bttBtnenter_Visible = 1 ;
      bttBtnaddgridlinegridlevel_motivos_Visible = 1 ;
      bttBtnaddgridlinegridlevel_motivosegreso_Visible = 1 ;
      divTableleaflevel_motivosegreso_Visible = 1 ;
      bttBtnaddgridlinegridlevel_tipoliquidacion_Visible = 1 ;
      dynavConcepto_concuenhaber.setJsonclick( "" );
      dynavConcepto_concuenhaber.setEnabled( 1 );
      dynavConcepto_concuendebe.setJsonclick( "" );
      dynavConcepto_concuendebe.setEnabled( 1 );
      dynavConcepto_conceptoconvecodigo.setJsonclick( "" );
      dynavConcepto_conceptoconvecodigo.setEnabled( 1 );
      cmbavConcepto_conbaseausprom.setJsonclick( "" );
      cmbavConcepto_conbaseausprom.setEnabled( 1 );
      cmbavConcepto_conbaseaus.setJsonclick( "" );
      cmbavConcepto_conbaseaus.setEnabled( 1 );
      cmbavConcepto_conbaseosdif.setJsonclick( "" );
      cmbavConcepto_conbaseosdif.setEnabled( 1 );
      cmbavConcepto_conbaseant.setJsonclick( "" );
      cmbavConcepto_conbaseant.setEnabled( 1 );
      cmbavConcepto_conbaseant.setCaption( httpContext.getMessage( "Base de cálculo para antiguedad", "") );
      cmbavConcepto_conbaseant.setVisible( 1 );
      cmbavConcepto_conbasepres.setJsonclick( "" );
      cmbavConcepto_conbasepres.setEnabled( 1 );
      cmbavConcepto_conbasepres.setCaption( httpContext.getMessage( "Base de cálculo para presentismo", "") );
      cmbavConcepto_conbasepres.setVisible( 1 );
      cmbavConcepto_conbasehorextprom.setJsonclick( "" );
      cmbavConcepto_conbasehorextprom.setEnabled( 1 );
      cmbavConcepto_conbasehorextprom.setVisible( 1 );
      cmbavConcepto_conbasehorext.setJsonclick( "" );
      cmbavConcepto_conbasehorext.setEnabled( 1 );
      cmbavConcepto_conbasehorext.setVisible( 1 );
      cmbavConcepto_conbaseferprom.setJsonclick( "" );
      cmbavConcepto_conbaseferprom.setEnabled( 1 );
      cmbavConcepto_conbaseferprom.setVisible( 1 );
      cmbavConcepto_conbasefer.setJsonclick( "" );
      cmbavConcepto_conbasefer.setEnabled( 1 );
      cmbavConcepto_conbasefer.setCaption( httpContext.getMessage( "Base de cálculo para feriados de remuneración fija", "") );
      cmbavConcepto_conbasefer.setVisible( 1 );
      cmbavConcepto_conbaselicprom.setJsonclick( "" );
      cmbavConcepto_conbaselicprom.setEnabled( 1 );
      cmbavConcepto_conbaselicprom.setVisible( 1 );
      cmbavConcepto_conbaselic.setJsonclick( "" );
      cmbavConcepto_conbaselic.setEnabled( 1 );
      cmbavConcepto_conbaselic.setCaption( httpContext.getMessage( "Base de cálculo para licencias de remuneraciòn fija", "") );
      cmbavConcepto_conbaselic.setVisible( 1 );
      edtavConcepto_conordejec_Jsonclick = "" ;
      edtavConcepto_conordejec_Enabled = 1 ;
      edtavConcepto_conorden_Jsonclick = "" ;
      edtavConcepto_conorden_Enabled = 1 ;
      cmbavConcepto_consacdeven.setJsonclick( "" );
      cmbavConcepto_consacdeven.setEnabled( 1 );
      cmbavConcepto_consacdeven.setVisible( 1 );
      cmbavConcepto_conadeldescu.setJsonclick( "" );
      cmbavConcepto_conadeldescu.setEnabled( 1 );
      cmbavConcepto_conadeldescu.setVisible( 1 );
      chkavConcepto_conerrorsicero.setEnabled( 1 );
      chkavConcepto_conerrorsicero.setVisible( 1 );
      chkavConcepto_conmostrarpos.setEnabled( 1 );
      chkavConcepto_conmostrarpos.setVisible( 1 );
      edtavRangohasta_Jsonclick = "" ;
      edtavRangodesde_Jsonclick = "" ;
      divTablerango_Visible = 1 ;
      chkavConcepto_conrecalcular.setEnabled( 1 );
      chkavConcepto_conrecalcular.setVisible( 1 );
      edtavConcepto_conobservacion_Enabled = 1 ;
      edtavConcepto_conobservacion_Visible = 1 ;
      edtavConcepto_concondcodigo_Jsonclick = "" ;
      edtavConcepto_concondcodigo_Enabled = 1 ;
      edtavConcepto_concondcodigo_Visible = 1 ;
      cmbavConcepto_concondicion.setJsonclick( "" );
      cmbavConcepto_concondicion.setEnabled( 1 );
      cmbavConcepto_concondicion.setVisible( 1 );
      cmbavConcepto_convigencia.setJsonclick( "" );
      cmbavConcepto_convigencia.setEnabled( 1 );
      chkavConcepto_conhabilitado.setEnabled( 1 );
      edtavConcepto_concodafip_Jsonclick = "" ;
      edtavConcepto_concodafip_Enabled = 1 ;
      dynavConcepto_apliigg.setJsonclick( "" );
      dynavConcepto_apliigg.setEnabled( 1 );
      dynavConcepto_apliigg.setVisible( 1 );
      chkavConcepto_convariable.setEnabled( 1 );
      chkavConcepto_convariable.setVisible( 1 );
      chkavConcepto_conpuenov.setEnabled( 1 );
      chkavConcepto_conpuenov.setVisible( 1 );
      dynavConcepto_conrelsec.setJsonclick( "" );
      dynavConcepto_conrelsec.setEnabled( 1 );
      dynavConcepto_conrelsec.setVisible( 1 );
      edtavConcepto_condescrip_Enabled = 1 ;
      edtavConcepto_concodigo_Jsonclick = "" ;
      edtavConcepto_concodigo_Enabled = 1 ;
      cmbavConcepto_subtipoconcod2.setJsonclick( "" );
      cmbavConcepto_subtipoconcod2.setEnabled( 1 );
      cmbavConcepto_subtipoconcod1.setJsonclick( "" );
      cmbavConcepto_subtipoconcod1.setEnabled( 1 );
      cmbavConcepto_tipoconcod.setJsonclick( "" );
      cmbavConcepto_tipoconcod.setEnabled( 1 );
      tblTblapocon3_Visible = 1 ;
      cmbavConcepto_conbaseant.setCaption( httpContext.getMessage( "Base de cálculo para antiguedad", "") );
      cmbavConcepto_conbasepres.setCaption( httpContext.getMessage( "Base de cálculo para presentismo", "") );
      cmbavConcepto_conbasefer.setCaption( httpContext.getMessage( "Base de cálculo para feriados de remuneración fija", "") );
      cmbavConcepto_conbaselic.setCaption( httpContext.getMessage( "Base de cálculo para licencias de remuneraciòn fija", "") );
      cmbavConcepto_tipoliquidacion__contltipegr.setVisible( 0 );
      divDvpanel_unnamedtable4_cell_Class = "col-xs-12" ;
      divConcepto_conrelsec_cell_Class = "col-xs-12" ;
      divConcepto_concodafip_cell_Class = "col-xs-12" ;
      edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass = "" ;
      edtavDeletegridlinegridlevel_motivos_Columnheaderclass = "" ;
      edtavConcepto_conrangocant_Enabled = 1 ;
      cmbavConcepto_conprereq.setEnabled( 1 );
      tblFormulatbl_Visible = 1 ;
      edtavConcepto_concodigo_Enabled = 1 ;
      dynavConcepto_conrelsec.setEnabled( 1 );
      edtavConcepto_condescrip_Enabled = 1 ;
      cmbavConcepto_subtipoconcod2.setEnabled( 1 );
      cmbavConcepto_subtipoconcod1.setEnabled( 1 );
      cmbavConcepto_tipoconcod.setEnabled( 1 );
      edtavRangohasta_Enabled = 1 ;
      edtavRangodesde_Enabled = 1 ;
      dynavConcepto_concuenhaber.setEnabled( 1 );
      dynavConcepto_concuendebe.setEnabled( 1 );
      dynavConcepto_conceptoconvecodigo.setEnabled( 1 );
      cmbavConcepto_conbaseausprom.setEnabled( 1 );
      cmbavConcepto_conbaseaus.setEnabled( 1 );
      cmbavConcepto_conbaseosdif.setEnabled( 1 );
      cmbavConcepto_conbaseant.setEnabled( 1 );
      cmbavConcepto_conbasepres.setEnabled( 1 );
      cmbavConcepto_conbasehorextprom.setEnabled( 1 );
      cmbavConcepto_conbasehorext.setEnabled( 1 );
      cmbavConcepto_conbaseferprom.setEnabled( 1 );
      cmbavConcepto_conbasefer.setEnabled( 1 );
      cmbavConcepto_conbaselicprom.setEnabled( 1 );
      cmbavConcepto_conbaselic.setEnabled( 1 );
      edtavConcepto_conordejec_Enabled = 1 ;
      edtavConcepto_conorden_Enabled = 1 ;
      cmbavConcepto_consacdeven.setEnabled( 1 );
      cmbavConcepto_conadeldescu.setEnabled( 1 );
      chkavConcepto_conerrorsicero.setEnabled( 1 );
      chkavConcepto_conmostrarpos.setEnabled( 1 );
      chkavConcepto_conrecalcular.setEnabled( 1 );
      edtavConcepto_conobservacion_Enabled = 1 ;
      edtavConcepto_concondcodigo_Enabled = 1 ;
      cmbavConcepto_concondicion.setEnabled( 1 );
      cmbavConcepto_convigencia.setEnabled( 1 );
      chkavConcepto_conhabilitado.setEnabled( 1 );
      edtavConcepto_concodafip_Enabled = 1 ;
      dynavConcepto_apliigg.setEnabled( 1 );
      chkavConcepto_convariable.setEnabled( 1 );
      chkavConcepto_conpuenov.setEnabled( 1 );
      cmbavConcepto_conleyrietrabcont.setEnabled( 1 );
      cmbavConcepto_confonnacempcont.setEnabled( 1 );
      cmbavConcepto_conasigfamcont.setEnabled( 1 );
      cmbavConcepto_conrenateacont.setEnabled( 1 );
      cmbavConcepto_confonsolredcont.setEnabled( 1 );
      cmbavConcepto_conobrasoccont.setEnabled( 1 );
      cmbavConcepto_coninssjypcont.setEnabled( 1 );
      cmbavConcepto_consipacont.setEnabled( 1 );
      cmbavConcepto_conregespapo.setEnabled( 1 );
      cmbavConcepto_conregdifapo.setEnabled( 1 );
      cmbavConcepto_conrenateaapo.setEnabled( 1 );
      cmbavConcepto_confonsolredapo.setEnabled( 1 );
      cmbavConcepto_conobrasocapo.setEnabled( 1 );
      cmbavConcepto_coninssjypapo.setEnabled( 1 );
      cmbavConcepto_consipaapo.setEnabled( 1 );
      edtavConcepto_motivosegreso__conmegsec_Enabled = -1 ;
      cmbavConcepto_tipoliquidacion__contltipegr.setEnabled( -1 );
      dynavConcepto_tipoliquidacion__tliqcod.setEnabled( -1 );
      edtavConcepto_conformula_Enabled = -1 ;
      edtavConcepto_clicod_Jsonclick = "" ;
      edtavConcepto_clicod_Visible = 1 ;
      edtavConcepto_conrangocant_Enabled = 1 ;
      edtavConcepto_conrangocant_Visible = 1 ;
      cmbavConcepto_conprereq.setJsonclick( "" );
      cmbavConcepto_conprereq.setVisible( 1 );
      cmbavConcepto_conprereq.setEnabled( 1 );
      chkavConcepto_consegunpla.setVisible( 1 );
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Gxuitabspanel_tabs1_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_tabs1_Class = "" ;
      Gxuitabspanel_tabs1_Pagecount = 2 ;
      Dvpanel_panelapocont3_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelapocont3_Iconposition = "Right" ;
      Dvpanel_panelapocont3_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelapocont3_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelapocont3_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_panelapocont3_Title = httpContext.getMessage( "Aportes y Contribuciones", "") ;
      Dvpanel_panelapocont3_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelapocont3_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelapocont3_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelapocont3_Width = "100%" ;
      Dvpanel_unnamedtable3_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Iconposition = "Right" ;
      Dvpanel_unnamedtable3_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Collapsed = GXutil.toBoolean( 1) ;
      Dvpanel_unnamedtable3_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable3_Title = httpContext.getMessage( "Configuración avanzada", "") ;
      Dvpanel_unnamedtable3_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable3_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable3_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Width = "100%" ;
      Dvpanel_unnamedtable4_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Iconposition = "Right" ;
      Dvpanel_unnamedtable4_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable4_Title = httpContext.getMessage( "Cuentas contables", "") ;
      Dvpanel_unnamedtable4_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable4_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable4_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Width = "100%" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "Datos principales", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      subGridlevel_motivos_Rows = 0 ;
      subGridlevel_tipoliquidacion_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void init_web_controls( )
   {
      cmbavConcepto_tipoconcod.setName( "CONCEPTO_TIPOCONCOD" );
      cmbavConcepto_tipoconcod.setWebtags( "" );
      cmbavConcepto_tipoconcod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbavConcepto_tipoconcod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbavConcepto_tipoconcod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbavConcepto_tipoconcod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbavConcepto_tipoconcod.getItemCount() > 0 )
      {
      }
      cmbavConcepto_subtipoconcod1.setName( "CONCEPTO_SUBTIPOCONCOD1" );
      cmbavConcepto_subtipoconcod1.setWebtags( "" );
      if ( cmbavConcepto_subtipoconcod1.getItemCount() > 0 )
      {
      }
      cmbavConcepto_subtipoconcod2.setName( "CONCEPTO_SUBTIPOCONCOD2" );
      cmbavConcepto_subtipoconcod2.setWebtags( "" );
      cmbavConcepto_subtipoconcod2.addItem("", httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      if ( cmbavConcepto_subtipoconcod2.getItemCount() > 0 )
      {
      }
      dynavConcepto_conrelsec.setName( "CONCEPTO_CONRELSEC" );
      dynavConcepto_conrelsec.setWebtags( "" );
      chkavConcepto_conpuenov.setName( "CONCEPTO_CONPUENOV" );
      chkavConcepto_conpuenov.setWebtags( "" );
      chkavConcepto_conpuenov.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conpuenov.getInternalname(), "TitleCaption", chkavConcepto_conpuenov.getCaption(), true);
      chkavConcepto_conpuenov.setCheckedValue( "false" );
      chkavConcepto_convariable.setName( "CONCEPTO_CONVARIABLE" );
      chkavConcepto_convariable.setWebtags( "" );
      chkavConcepto_convariable.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_convariable.getInternalname(), "TitleCaption", chkavConcepto_convariable.getCaption(), true);
      chkavConcepto_convariable.setCheckedValue( "false" );
      dynavConcepto_apliigg.setName( "CONCEPTO_APLIIGG" );
      dynavConcepto_apliigg.setWebtags( "" );
      chkavConcepto_conhabilitado.setName( "CONCEPTO_CONHABILITADO" );
      chkavConcepto_conhabilitado.setWebtags( "" );
      chkavConcepto_conhabilitado.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conhabilitado.getInternalname(), "TitleCaption", chkavConcepto_conhabilitado.getCaption(), true);
      chkavConcepto_conhabilitado.setCheckedValue( "false" );
      cmbavConcepto_convigencia.setName( "CONCEPTO_CONVIGENCIA" );
      cmbavConcepto_convigencia.setWebtags( "" );
      cmbavConcepto_convigencia.addItem("0", httpContext.getMessage( "Automática", ""), (short)(0));
      cmbavConcepto_convigencia.addItem("1", httpContext.getMessage( "Por Novedad", ""), (short)(0));
      if ( cmbavConcepto_convigencia.getItemCount() > 0 )
      {
      }
      cmbavConcepto_concondicion.setName( "CONCEPTO_CONCONDICION" );
      cmbavConcepto_concondicion.setWebtags( "" );
      cmbavConcepto_concondicion.addItem("A0", httpContext.getMessage( "Siempre", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("A1", httpContext.getMessage( "Se ingresó por novedad el concepto de código relacionado a la condición", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("A3", httpContext.getMessage( "Trabajador no es Jubilado y aplica a liquidación de aportes", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("A4", httpContext.getMessage( "Resultado de la suma de conceptos agregados en liquidación anterior con la misma clasificación sea mayor a cerO, y que el concepto de la liquidación anterior tenga asignado tipo de liquidación igual al código relacionado a la condición de este concepto", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("A5", httpContext.getMessage( "Es alcanzado por ganancias y calcula adelanto de retención (parámetro)", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("A8", httpContext.getMessage( "Legajo tiene saldo distinto de cero en DDJJ F1357 del año anterior", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("A9", httpContext.getMessage( "Tiene familiares adherentes a la obra social", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("A10", httpContext.getMessage( "Tiene Sindicato", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("A11", httpContext.getMessage( "Tiene jornada parcial", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("A12", httpContext.getMessage( "Obra social tiene aporte adicional", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("A13", httpContext.getMessage( "Empleador es agente de retención", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("A14", httpContext.getMessage( "El empleador es agente de retención y el empleado es alcanzado por ganancias", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B1", httpContext.getMessage( "Legajo tiene cargado licencia igual al código  relacionado a la condición", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B2", httpContext.getMessage( "Legajo tiene cargado SIRADIG de igual código  relacionado a la condición", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B3", httpContext.getMessage( "Tiene obligación activa de igual al código relacionado a la condición", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B4", httpContext.getMessage( "Hay licencias o feriados con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B5", httpContext.getMessage( "Hay feriado no trabajado, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B6", httpContext.getMessage( "Hay día no laborable em periodo, y la empresa está configurada para exponer los feriados", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B7", httpContext.getMessage( "El legajo es empleado mensual y hay licencia sin goce de sueldo", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B9", httpContext.getMessage( "Es egreso y no maneja fondo de cese laboral", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B10", httpContext.getMessage( "Tipo de liquidación, mes de liquidación, y marca de SAC en alta de liquidación son compatibles con la liquidación del SAC.", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B11", httpContext.getMessage( "Liquida sac o alcanza ganancias", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B12", httpContext.getMessage( "Empresa o convenio liquidan antiguedad", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B13", httpContext.getMessage( "Empresa o convenio liquidan presentismo", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B14", httpContext.getMessage( "Legajo tiene cargado comprobante para reintegro igual al código relacionado a la condición", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B15", httpContext.getMessage( "Legajo tiene cargado hijo o hija con asignación de servicio de guardería", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("N01", httpContext.getMessage( "Nunca  (Calcular siempre en segundo plano luego de generar el recibo)", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B16", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\", de frecuencia mensual y el concepto no fué previamente liquidado en el mismo periodo", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B19", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado vacaciones y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B20", httpContext.getMessage( "Legajo es empleado mensual, tiene cargado días de licencia (distinta a vacaciones) y la empresa está configurada para no prorratear el sueldo", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B21", httpContext.getMessage( "Legajo es empleado mensual, hay feriado no trabajado y la empresa está configurada para exponer los feriados y no proratear el sueldo", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B22", httpContext.getMessage( "Legajo es empleado mensual, hay día no laborable no trabajado y la empresa está configurada para exponer los feriados y no prorratear el sueldo", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B23", httpContext.getMessage( "Legajo tiene asignado tìtulo igual al código relacionado a la condición", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("B24", httpContext.getMessage( "Parametro para desglosar adicional está activado, legajo está en convenio y su categoría tiene adicional por zona desfavorable", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("VP", httpContext.getMessage( "Hay vacaciones con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("AI", httpContext.getMessage( "Legajo es de clase mensual y tiene cargadas ausencias injustificadas", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("R1", httpContext.getMessage( "Forma de pago es distinta a transferencia o parámetro está configurado para liquidar siempre redondeo", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("MI", httpContext.getMessage( "Legajo tiene tipo de tarifa \"por periodo\" de frecuencia mensual, empresa está configurada para no prorratear sueldo y fecha de ingreso es mayor al primero o fecha de egreso menor al último día del mes", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("H1", httpContext.getMessage( "Si liquidación es compatible con SAC liquidar como concepto principal, y si no liquidarlo como concepto auxiliar en segundo plano", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("LA", httpContext.getMessage( "Legajo aplica a liquidación de aportes", ""), (short)(0));
      cmbavConcepto_concondicion.addItem("GU", httpContext.getMessage( "Legajo tiene configurado grossing up", ""), (short)(0));
      if ( cmbavConcepto_concondicion.getItemCount() > 0 )
      {
      }
      chkavConcepto_conrecalcular.setName( "CONCEPTO_CONRECALCULAR" );
      chkavConcepto_conrecalcular.setWebtags( "" );
      chkavConcepto_conrecalcular.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conrecalcular.getInternalname(), "TitleCaption", chkavConcepto_conrecalcular.getCaption(), true);
      chkavConcepto_conrecalcular.setCheckedValue( "false" );
      chkavConcepto_conmostrarpos.setName( "CONCEPTO_CONMOSTRARPOS" );
      chkavConcepto_conmostrarpos.setWebtags( "" );
      chkavConcepto_conmostrarpos.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conmostrarpos.getInternalname(), "TitleCaption", chkavConcepto_conmostrarpos.getCaption(), true);
      chkavConcepto_conmostrarpos.setCheckedValue( "false" );
      chkavConcepto_conerrorsicero.setName( "CONCEPTO_CONERRORSICERO" );
      chkavConcepto_conerrorsicero.setWebtags( "" );
      chkavConcepto_conerrorsicero.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_conerrorsicero.getInternalname(), "TitleCaption", chkavConcepto_conerrorsicero.getCaption(), true);
      chkavConcepto_conerrorsicero.setCheckedValue( "false" );
      cmbavConcepto_conadeldescu.setName( "CONCEPTO_CONADELDESCU" );
      cmbavConcepto_conadeldescu.setWebtags( "" );
      cmbavConcepto_conadeldescu.addItem(GXutil.trim( GXutil.str( 0, 1, 0)), httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      cmbavConcepto_conadeldescu.addItem("1", httpContext.getMessage( "Adelanto de mes próximo", ""), (short)(0));
      cmbavConcepto_conadeldescu.addItem("2", httpContext.getMessage( "Descuento", ""), (short)(0));
      if ( cmbavConcepto_conadeldescu.getItemCount() > 0 )
      {
      }
      cmbavConcepto_consacdeven.setName( "CONCEPTO_CONSACDEVEN" );
      cmbavConcepto_consacdeven.setWebtags( "" );
      cmbavConcepto_consacdeven.addItem("0", httpContext.getMessage( "No aplica", ""), (short)(0));
      cmbavConcepto_consacdeven.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbavConcepto_consacdeven.addItem("3", httpContext.getMessage( "Trimestral", ""), (short)(0));
      cmbavConcepto_consacdeven.addItem("4", httpContext.getMessage( "Cuatrimestral", ""), (short)(0));
      cmbavConcepto_consacdeven.addItem("6", httpContext.getMessage( "Semestral", ""), (short)(0));
      cmbavConcepto_consacdeven.addItem("12", httpContext.getMessage( "Anual", ""), (short)(0));
      if ( cmbavConcepto_consacdeven.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conbaselic.setName( "CONCEPTO_CONBASELIC" );
      cmbavConcepto_conbaselic.setWebtags( "" );
      cmbavConcepto_conbaselic.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConcepto_conbaselic.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbavConcepto_conbaselic.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbavConcepto_conbaselic.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbavConcepto_conbaselic.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbaselic.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbaselic.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbavConcepto_conbaselic.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conbaselicprom.setName( "CONCEPTO_CONBASELICPROM" );
      cmbavConcepto_conbaselicprom.setWebtags( "" );
      cmbavConcepto_conbaselicprom.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConcepto_conbaselicprom.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbavConcepto_conbaselicprom.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbavConcepto_conbaselicprom.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbavConcepto_conbaselicprom.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbaselicprom.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbaselicprom.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbavConcepto_conbaselicprom.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conbasefer.setName( "CONCEPTO_CONBASEFER" );
      cmbavConcepto_conbasefer.setWebtags( "" );
      cmbavConcepto_conbasefer.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConcepto_conbasefer.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbavConcepto_conbasefer.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbavConcepto_conbasefer.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbavConcepto_conbasefer.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbasefer.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbasefer.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbavConcepto_conbasefer.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conbaseferprom.setName( "CONCEPTO_CONBASEFERPROM" );
      cmbavConcepto_conbaseferprom.setWebtags( "" );
      cmbavConcepto_conbaseferprom.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConcepto_conbaseferprom.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbavConcepto_conbaseferprom.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbavConcepto_conbaseferprom.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbavConcepto_conbaseferprom.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbaseferprom.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbaseferprom.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbavConcepto_conbaseferprom.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conbasehorext.setName( "CONCEPTO_CONBASEHOREXT" );
      cmbavConcepto_conbasehorext.setWebtags( "" );
      cmbavConcepto_conbasehorext.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConcepto_conbasehorext.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbavConcepto_conbasehorext.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbavConcepto_conbasehorext.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbavConcepto_conbasehorext.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbasehorext.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbasehorext.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbavConcepto_conbasehorext.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conbasehorextprom.setName( "CONCEPTO_CONBASEHOREXTPROM" );
      cmbavConcepto_conbasehorextprom.setWebtags( "" );
      cmbavConcepto_conbasehorextprom.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConcepto_conbasehorextprom.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbavConcepto_conbasehorextprom.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbavConcepto_conbasehorextprom.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbavConcepto_conbasehorextprom.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbasehorextprom.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbasehorextprom.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbavConcepto_conbasehorextprom.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conbasepres.setName( "CONCEPTO_CONBASEPRES" );
      cmbavConcepto_conbasepres.setWebtags( "" );
      cmbavConcepto_conbasepres.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConcepto_conbasepres.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbavConcepto_conbasepres.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbavConcepto_conbasepres.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbavConcepto_conbasepres.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbasepres.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbasepres.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbavConcepto_conbasepres.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conbaseant.setName( "CONCEPTO_CONBASEANT" );
      cmbavConcepto_conbaseant.setWebtags( "" );
      cmbavConcepto_conbaseant.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConcepto_conbaseant.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbavConcepto_conbaseant.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbavConcepto_conbaseant.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbavConcepto_conbaseant.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbaseant.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbaseant.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbavConcepto_conbaseant.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conbaseosdif.setName( "CONCEPTO_CONBASEOSDIF" );
      cmbavConcepto_conbaseosdif.setWebtags( "" );
      cmbavConcepto_conbaseosdif.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConcepto_conbaseosdif.addItem("1", httpContext.getMessage( "Sí. Recalcular proporcional a jornada completa", ""), (short)(0));
      cmbavConcepto_conbaseosdif.addItem("2", httpContext.getMessage( "Sí, el valor liquidado", ""), (short)(0));
      cmbavConcepto_conbaseosdif.addItem("3", httpContext.getMessage( "Sí, el valor liquidado proporcional a jornada completa", ""), (short)(0));
      if ( cmbavConcepto_conbaseosdif.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conbaseaus.setName( "CONCEPTO_CONBASEAUS" );
      cmbavConcepto_conbaseaus.setWebtags( "" );
      cmbavConcepto_conbaseaus.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConcepto_conbaseaus.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbavConcepto_conbaseaus.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbavConcepto_conbaseaus.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbavConcepto_conbaseaus.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbaseaus.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbaseaus.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbavConcepto_conbaseaus.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conbaseausprom.setName( "CONCEPTO_CONBASEAUSPROM" );
      cmbavConcepto_conbaseausprom.setWebtags( "" );
      cmbavConcepto_conbaseausprom.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      cmbavConcepto_conbaseausprom.addItem("1", httpContext.getMessage( "Sí", ""), (short)(0));
      cmbavConcepto_conbaseausprom.addItem("2", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\"", ""), (short)(0));
      cmbavConcepto_conbaseausprom.addItem("3", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\"", ""), (short)(0));
      cmbavConcepto_conbaseausprom.addItem("4", httpContext.getMessage( "Sí, mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbaseausprom.addItem("5", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual", ""), (short)(0));
      cmbavConcepto_conbaseausprom.addItem("6", httpContext.getMessage( "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual", ""), (short)(0));
      if ( cmbavConcepto_conbaseausprom.getItemCount() > 0 )
      {
      }
      dynavConcepto_conceptoconvecodigo.setName( "CONCEPTO_CONCEPTOCONVECODIGO" );
      dynavConcepto_conceptoconvecodigo.setWebtags( "" );
      dynavConcepto_concuendebe.setName( "CONCEPTO_CONCUENDEBE" );
      dynavConcepto_concuendebe.setWebtags( "" );
      dynavConcepto_concuenhaber.setName( "CONCEPTO_CONCUENHABER" );
      dynavConcepto_concuenhaber.setWebtags( "" );
      GXCCtl = "CONCEPTO_TIPOLIQUIDACION__TLIQCOD_" + sGXsfl_247_idx ;
      dynavConcepto_tipoliquidacion__tliqcod.setName( GXCCtl );
      dynavConcepto_tipoliquidacion__tliqcod.setWebtags( "" );
      GXCCtl = "CONCEPTO_TIPOLIQUIDACION__CONTLTIPEGR_" + sGXsfl_247_idx ;
      cmbavConcepto_tipoliquidacion__contltipegr.setName( GXCCtl );
      cmbavConcepto_tipoliquidacion__contltipegr.setWebtags( "" );
      cmbavConcepto_tipoliquidacion__contltipegr.addItem("", httpContext.getMessage( "Todos", ""), (short)(0));
      cmbavConcepto_tipoliquidacion__contltipegr.addItem("SINCAUSA", httpContext.getMessage( "Despido Sin Causa", ""), (short)(0));
      cmbavConcepto_tipoliquidacion__contltipegr.addItem("SINPREAVISO", httpContext.getMessage( "Despido sin causa y sin preaviso", ""), (short)(0));
      if ( cmbavConcepto_tipoliquidacion__contltipegr.getItemCount() > 0 )
      {
         if ( ( AV122GXV38 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().size() >= AV122GXV38 ) && (GXutil.strcmp("", ((web.SdtConcepto_TipoLiquidacion)AV7Concepto.getgxTv_SdtConcepto_Tipoliquidacion().elementAt(-1+AV122GXV38)).getgxTv_SdtConcepto_TipoLiquidacion_Contltipegr())==0) )
         {
         }
      }
      GXCCtl = "CONCEPTO_MOTIVOSEGRESO__MEGCODIGO_" + sGXsfl_262_idx ;
      dynavConcepto_motivosegreso__megcodigo.setName( GXCCtl );
      dynavConcepto_motivosegreso__megcodigo.setWebtags( "" );
      GXCCtl = "CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO_" + sGXsfl_262_idx ;
      cmbavConcepto_motivosegreso__megpreatipo.setName( GXCCtl );
      cmbavConcepto_motivosegreso__megpreatipo.setWebtags( "" );
      cmbavConcepto_motivosegreso__megpreatipo.addItem("CON", httpContext.getMessage( "Con preaviso", ""), (short)(0));
      cmbavConcepto_motivosegreso__megpreatipo.addItem("SIN", httpContext.getMessage( "Sin preaviso", ""), (short)(0));
      cmbavConcepto_motivosegreso__megpreatipo.addItem("", httpContext.getMessage( "Ambos (Con o sin preaviso)", ""), (short)(0));
      if ( cmbavConcepto_motivosegreso__megpreatipo.getItemCount() > 0 )
      {
         if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) && (GXutil.strcmp("", ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Megpreatipo())==0) )
         {
         }
      }
      GXCCtl = "CONCEPTO_MOTIVOSEGRESO__CONMEGDURA_" + sGXsfl_262_idx ;
      cmbavConcepto_motivosegreso__conmegdura.setName( GXCCtl );
      cmbavConcepto_motivosegreso__conmegdura.setWebtags( "" );
      cmbavConcepto_motivosegreso__conmegdura.addItem("años", httpContext.getMessage( "años", ""), (short)(0));
      cmbavConcepto_motivosegreso__conmegdura.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
      if ( cmbavConcepto_motivosegreso__conmegdura.getItemCount() > 0 )
      {
         if ( ( AV125GXV41 > 0 ) && ( AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().size() >= AV125GXV41 ) && (GXutil.strcmp("", ((web.SdtConcepto_MotivosEgreso)AV7Concepto.getgxTv_SdtConcepto_Motivosegreso().elementAt(-1+AV125GXV41)).getgxTv_SdtConcepto_MotivosEgreso_Conmegdura())==0) )
         {
         }
      }
      cmbavConcepto_consipaapo.setName( "CONCEPTO_CONSIPAAPO" );
      cmbavConcepto_consipaapo.setWebtags( "" );
      cmbavConcepto_consipaapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_consipaapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_consipaapo.getItemCount() > 0 )
      {
      }
      cmbavConcepto_coninssjypapo.setName( "CONCEPTO_CONINSSJYPAPO" );
      cmbavConcepto_coninssjypapo.setWebtags( "" );
      cmbavConcepto_coninssjypapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_coninssjypapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_coninssjypapo.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conobrasocapo.setName( "CONCEPTO_CONOBRASOCAPO" );
      cmbavConcepto_conobrasocapo.setWebtags( "" );
      cmbavConcepto_conobrasocapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_conobrasocapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_conobrasocapo.getItemCount() > 0 )
      {
      }
      cmbavConcepto_confonsolredapo.setName( "CONCEPTO_CONFONSOLREDAPO" );
      cmbavConcepto_confonsolredapo.setWebtags( "" );
      cmbavConcepto_confonsolredapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_confonsolredapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_confonsolredapo.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conrenateaapo.setName( "CONCEPTO_CONRENATEAAPO" );
      cmbavConcepto_conrenateaapo.setWebtags( "" );
      cmbavConcepto_conrenateaapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_conrenateaapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_conrenateaapo.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conregdifapo.setName( "CONCEPTO_CONREGDIFAPO" );
      cmbavConcepto_conregdifapo.setWebtags( "" );
      cmbavConcepto_conregdifapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_conregdifapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_conregdifapo.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conregespapo.setName( "CONCEPTO_CONREGESPAPO" );
      cmbavConcepto_conregespapo.setWebtags( "" );
      cmbavConcepto_conregespapo.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_conregespapo.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_conregespapo.getItemCount() > 0 )
      {
      }
      cmbavConcepto_consipacont.setName( "CONCEPTO_CONSIPACONT" );
      cmbavConcepto_consipacont.setWebtags( "" );
      cmbavConcepto_consipacont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_consipacont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_consipacont.getItemCount() > 0 )
      {
      }
      cmbavConcepto_coninssjypcont.setName( "CONCEPTO_CONINSSJYPCONT" );
      cmbavConcepto_coninssjypcont.setWebtags( "" );
      cmbavConcepto_coninssjypcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_coninssjypcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_coninssjypcont.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conobrasoccont.setName( "CONCEPTO_CONOBRASOCCONT" );
      cmbavConcepto_conobrasoccont.setWebtags( "" );
      cmbavConcepto_conobrasoccont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_conobrasoccont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_conobrasoccont.getItemCount() > 0 )
      {
      }
      cmbavConcepto_confonsolredcont.setName( "CONCEPTO_CONFONSOLREDCONT" );
      cmbavConcepto_confonsolredcont.setWebtags( "" );
      cmbavConcepto_confonsolredcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_confonsolredcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_confonsolredcont.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conrenateacont.setName( "CONCEPTO_CONRENATEACONT" );
      cmbavConcepto_conrenateacont.setWebtags( "" );
      cmbavConcepto_conrenateacont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_conrenateacont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_conrenateacont.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conasigfamcont.setName( "CONCEPTO_CONASIGFAMCONT" );
      cmbavConcepto_conasigfamcont.setWebtags( "" );
      cmbavConcepto_conasigfamcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_conasigfamcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_conasigfamcont.getItemCount() > 0 )
      {
      }
      cmbavConcepto_confonnacempcont.setName( "CONCEPTO_CONFONNACEMPCONT" );
      cmbavConcepto_confonnacempcont.setWebtags( "" );
      cmbavConcepto_confonnacempcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_confonnacempcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_confonnacempcont.getItemCount() > 0 )
      {
      }
      cmbavConcepto_conleyrietrabcont.setName( "CONCEPTO_CONLEYRIETRABCONT" );
      cmbavConcepto_conleyrietrabcont.setWebtags( "" );
      cmbavConcepto_conleyrietrabcont.addItem("1", httpContext.getMessage( "Si", ""), (short)(0));
      cmbavConcepto_conleyrietrabcont.addItem("0", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavConcepto_conleyrietrabcont.getItemCount() > 0 )
      {
      }
      chkavConcepto_consegunpla.setName( "CONCEPTO_CONSEGUNPLA" );
      chkavConcepto_consegunpla.setWebtags( "" );
      chkavConcepto_consegunpla.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavConcepto_consegunpla.getInternalname(), "TitleCaption", chkavConcepto_consegunpla.getCaption(), true);
      chkavConcepto_consegunpla.setCheckedValue( "false" );
      cmbavConcepto_conprereq.setName( "CONCEPTO_CONPREREQ" );
      cmbavConcepto_conprereq.setWebtags( "" );
      cmbavConcepto_conprereq.addItem("", httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("APO_SIPA", httpContext.getMessage( "Conceptos que aporten a SIPA o Renatre", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("APO_SIPA_NoSacNiVac", httpContext.getMessage( "Conceptos que aporten a SIPA o Renatre distintos a SAC y vacaciones", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("APO_INSSJyP", httpContext.getMessage( "Conceptos que aporten a INSSJyP", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("APO_OS", httpContext.getMessage( "Conceptos que aporten a Obra Social o FSR", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("APO_DIF", httpContext.getMessage( "Conceptos que aporten a Diferenciales", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("APO_ESP", httpContext.getMessage( "Conceptos que aporten a Especiales", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("CON_SIPA", httpContext.getMessage( "Conceptos que contribuyan a SIPA o INSSJyP", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("CON_OS", httpContext.getMessage( "Conceptos que contribuyan a Obra social o FSR", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("CON_FNE", httpContext.getMessage( "Conceptos que contribuyan a AAFF, Renatre,o FNE", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("CON_LRT", httpContext.getMessage( "Conceptos que contribuyan a LRT", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("BRUTA", httpContext.getMessage( "Conceptos remunerativos y no remunerativos", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("REM", httpContext.getMessage( "Conceptos remunerativos", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("NRE", httpContext.getMessage( "Conceptos no remunerativos", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("REMNOSAC", httpContext.getMessage( "Conceptos remunerativos exceptuando SAC", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("EXENTOS", httpContext.getMessage( "Conceptos totalmente exentos de IIGG (excepto sac) y conceptos prorrateables", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("LICENCIAS", httpContext.getMessage( "Conceptos relacionados a licencias o feriados", ""), (short)(0));
      cmbavConcepto_conprereq.addItem("FIJAS", httpContext.getMessage( "Conceptos de remuneración fija de tipo remunerativos y no remunerativos con clasificacion distinta a vacaciones", ""), (short)(0));
      if ( cmbavConcepto_conprereq.getItemCount() > 0 )
      {
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'sPrefix'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'edtavDeletegridlinegridlevel_motivos_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnheaderclass'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_MOTIVOS.LOAD","{handler:'e26AJ3',iparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true}]");
      setEventMetadata("GRIDLEVEL_MOTIVOS.LOAD",",oparms:[{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Enabled'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Enabled'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Enabled'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Enabled'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Enabled'},{av:'AV61DeleteGridLineGridLevel_Motivos',fld:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',pic:''},{av:'edtavDeletegridlinegridlevel_motivos_Class',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Class'},{av:'edtavDeletegridlinegridlevel_motivos_Columnclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnclass'}]}");
      setEventMetadata("GRIDLEVEL_TIPOLIQUIDACION.LOAD","{handler:'e22AJ2',iparms:[{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true}]");
      setEventMetadata("GRIDLEVEL_TIPOLIQUIDACION.LOAD",",oparms:[{av:'AV9DeleteGridLineGridLevel_TipoLiquidacion',fld:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',pic:''},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Class',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Class'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Enabled'},{av:'divTableleaflevel_motivosegreso_Visible',ctrl:'TABLELEAFLEVEL_MOTIVOSEGRESO',prop:'Visible'}]}");
      setEventMetadata("'DOADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO'","{handler:'e11AJ2',iparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'sPrefix'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO'",",oparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262}]}");
      setEventMetadata("'DOADDGRIDLINEGRIDLEVEL_MOTIVOS'","{handler:'e12AJ2',iparms:[{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'sPrefix'},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''}]");
      setEventMetadata("'DOADDGRIDLINEGRIDLEVEL_MOTIVOS'",",oparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'edtavDeletegridlinegridlevel_motivos_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnheaderclass'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Visible'}]}");
      setEventMetadata("'DOADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION'","{handler:'e13AJ2',iparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'sPrefix'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION'",",oparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262}]}");
      setEventMetadata("ENTER","{handler:'e14AJ2',iparms:[{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'sPrefix'},{av:'AV14CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'AV71RangoDesde',fld:'vRANGODESDE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72RangoHasta',fld:'vRANGOHASTA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV11Messages',fld:'vMESSAGES',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'AV11Messages',fld:'vMESSAGES',pic:''},{av:'AV14CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'edtavDeletegridlinegridlevel_motivos_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnheaderclass'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Visible'}]}");
      setEventMetadata("VDELETEGRIDLINEGRIDLEVEL_MOTIVOS.CLICK","{handler:'e27AJ2',iparms:[{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'sPrefix'},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''}]");
      setEventMetadata("VDELETEGRIDLINEGRIDLEVEL_MOTIVOS.CLICK",",oparms:[{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'edtavDeletegridlinegridlevel_motivos_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnheaderclass'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Visible'}]}");
      setEventMetadata("VDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION.CLICK","{handler:'e23AJ2',iparms:[{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'sPrefix'},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''}]");
      setEventMetadata("VDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION.CLICK",",oparms:[{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'edtavDeletegridlinegridlevel_motivos_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnheaderclass'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_TIPOLIQUIDACION.REFRESH","{handler:'e24AJ2',iparms:[]");
      setEventMetadata("GRIDLEVEL_TIPOLIQUIDACION.REFRESH",",oparms:[{av:'divTableleaflevel_motivosegreso_Visible',ctrl:'TABLELEAFLEVEL_MOTIVOSEGRESO',prop:'Visible'}]}");
      setEventMetadata("CONCEPTO_CONVARIABLE.CLICK","{handler:'e15AJ2',iparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262}]");
      setEventMetadata("CONCEPTO_CONVARIABLE.CLICK",",oparms:[{ctrl:'CONCEPTO_CONBASELICPROM',prop:'Visible'},{ctrl:'CONCEPTO_CONBASEFERPROM',prop:'Visible'},{ctrl:'CONCEPTO_CONBASEHOREXTPROM',prop:'Visible'},{ctrl:'CONCEPTO_CONBASELIC',prop:'Caption'},{ctrl:'CONCEPTO_CONBASEFER',prop:'Caption'},{ctrl:'CONCEPTO_CONBASEPRES',prop:'Caption'},{ctrl:'CONCEPTO_CONBASEANT',prop:'Caption'}]}");
      setEventMetadata("CONCEPTO_CONCONDICION.CLICK","{handler:'e29AJ1',iparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'sPrefix'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("CONCEPTO_CONCONDICION.CLICK",",oparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{ctrl:'CONCEPTO_CONCONDICION',prop:'Visible'},{ctrl:'CONCEPTO_CONCONDCODIGO',prop:'Visible'},{ctrl:'CONCEPTO_CONMOSTRARPOS',prop:'Visible'},{ctrl:'CONCEPTO_CONERRORSICERO',prop:'Visible'},{ctrl:'CONCEPTO_CONPUENOV',prop:'Visible'},{av:'divTablerango_Visible',ctrl:'TABLERANGO',prop:'Visible'}]}");
      setEventMetadata("CONCEPTO_CONVIGENCIA.CLICK","{handler:'e28AJ1',iparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'sPrefix'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("CONCEPTO_CONVIGENCIA.CLICK",",oparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{ctrl:'CONCEPTO_CONCONDICION',prop:'Visible'},{ctrl:'CONCEPTO_CONCONDCODIGO',prop:'Visible'},{ctrl:'CONCEPTO_CONMOSTRARPOS',prop:'Visible'},{ctrl:'CONCEPTO_CONERRORSICERO',prop:'Visible'},{ctrl:'CONCEPTO_CONPUENOV',prop:'Visible'},{av:'divTablerango_Visible',ctrl:'TABLERANGO',prop:'Visible'}]}");
      setEventMetadata("CONCEPTO_TIPOCONCOD.CLICK","{handler:'e16AJ2',iparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV68vieneDeClick',fld:'vVIENEDECLICK',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'sPrefix'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("CONCEPTO_TIPOCONCOD.CLICK",",oparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{ctrl:'CONCEPTO_CONCODAFIP',prop:'Enabled'},{ctrl:'CONCEPTO_CONVARIABLE',prop:'Visible'},{ctrl:'CONCEPTO_APLIIGG',prop:'Visible'},{ctrl:'CONCEPTO_CONRECALCULAR',prop:'Visible'},{av:'divTablerango_Visible',ctrl:'TABLERANGO',prop:'Visible'},{ctrl:'CONCEPTO_CONMOSTRARPOS',prop:'Visible'},{ctrl:'CONCEPTO_CONERRORSICERO',prop:'Visible'},{ctrl:'CONCEPTO_CONADELDESCU',prop:'Visible'},{ctrl:'CONCEPTO_CONSIPAAPO',prop:'Enabled'},{ctrl:'CONCEPTO_CONSIPACONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONINSSJYPAPO',prop:'Enabled'},{ctrl:'CONCEPTO_CONINSSJYPCONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONOBRASOCAPO',prop:'Enabled'},{ctrl:'CONCEPTO_CONOBRASOCCONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONFONSOLREDAPO',prop:'Enabled'},{ctrl:'CONCEPTO_CONFONSOLREDCONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONRENATEAAPO',prop:'Enabled'},{ctrl:'CONCEPTO_CONRENATEACONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONASIGFAMCONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONFONNACEMPCONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONLEYRIETRABCONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONREGDIFAPO',prop:'Enabled'},{ctrl:'CONCEPTO_CONREGESPAPO',prop:'Enabled'},{av:'tblTblapocon3_Visible',ctrl:'TBLAPOCON3',prop:'Visible'},{ctrl:'CONCEPTO_CONSACDEVEN',prop:'Visible'},{ctrl:'CONCEPTO_CONBASEFER',prop:'Visible'},{ctrl:'CONCEPTO_CONBASEHOREXT',prop:'Visible'},{ctrl:'CONCEPTO_CONBASELIC',prop:'Visible'},{ctrl:'CONCEPTO_CONBASEFERPROM',prop:'Visible'},{ctrl:'CONCEPTO_CONBASEHOREXTPROM',prop:'Visible'},{ctrl:'CONCEPTO_CONBASELICPROM',prop:'Visible'},{ctrl:'CONCEPTO_CONBASEPRES',prop:'Visible'},{ctrl:'CONCEPTO_CONBASEANT',prop:'Visible'}]}");
      setEventMetadata("CONCEPTO_SUBTIPOCONCOD1.CLICK","{handler:'e17AJ2',iparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV68vieneDeClick',fld:'vVIENEDECLICK',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'sPrefix'},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("CONCEPTO_SUBTIPOCONCOD1.CLICK",",oparms:[{av:'AV68vieneDeClick',fld:'vVIENEDECLICK',pic:''},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262}]}");
      setEventMetadata("CONCEPTO_SUBTIPOCONCOD2.CLICK","{handler:'e18AJ2',iparms:[{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'AV68vieneDeClick',fld:'vVIENEDECLICK',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'sPrefix'},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("CONCEPTO_SUBTIPOCONCOD2.CLICK",",oparms:[{av:'AV68vieneDeClick',fld:'vVIENEDECLICK',pic:''},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262}]}");
      setEventMetadata("CONCEPTO_TIPOLIQUIDACION__TLIQCOD.CLICK","{handler:'e25AJ2',iparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true}]");
      setEventMetadata("CONCEPTO_TIPOLIQUIDACION__TLIQCOD.CLICK",",oparms:[{ctrl:'CONCEPTO_TIPOLIQUIDACION__CONTLTIPEGR',prop:'Visible'}]}");
      setEventMetadata("CONCEPTO_CONCODAFIP.ISVALID","{handler:'e19AJ2',iparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'sPrefix'},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("CONCEPTO_CONCODAFIP.ISVALID",",oparms:[{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262},{ctrl:'CONCEPTO_CONSIPAAPO',prop:'Enabled'},{ctrl:'CONCEPTO_CONSIPACONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONINSSJYPAPO',prop:'Enabled'},{ctrl:'CONCEPTO_CONINSSJYPCONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONOBRASOCAPO',prop:'Enabled'},{ctrl:'CONCEPTO_CONOBRASOCCONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONFONSOLREDAPO',prop:'Enabled'},{ctrl:'CONCEPTO_CONFONSOLREDCONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONRENATEAAPO',prop:'Enabled'},{ctrl:'CONCEPTO_CONRENATEACONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONASIGFAMCONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONFONNACEMPCONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONLEYRIETRABCONT',prop:'Enabled'},{ctrl:'CONCEPTO_CONREGDIFAPO',prop:'Enabled'},{ctrl:'CONCEPTO_CONREGESPAPO',prop:'Enabled'},{av:'tblTblapocon3_Visible',ctrl:'TBLAPOCON3',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_TIPOLIQUIDACION_FIRSTPAGE","{handler:'subgridlevel_tipoliquidacion_firstpage',iparms:[{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'sPrefix'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262}]");
      setEventMetadata("GRIDLEVEL_TIPOLIQUIDACION_FIRSTPAGE",",oparms:[{av:'edtavDeletegridlinegridlevel_motivos_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnheaderclass'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_TIPOLIQUIDACION_PREVPAGE","{handler:'subgridlevel_tipoliquidacion_previouspage',iparms:[{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'sPrefix'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262}]");
      setEventMetadata("GRIDLEVEL_TIPOLIQUIDACION_PREVPAGE",",oparms:[{av:'edtavDeletegridlinegridlevel_motivos_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnheaderclass'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_TIPOLIQUIDACION_NEXTPAGE","{handler:'subgridlevel_tipoliquidacion_nextpage',iparms:[{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'sPrefix'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262}]");
      setEventMetadata("GRIDLEVEL_TIPOLIQUIDACION_NEXTPAGE",",oparms:[{av:'edtavDeletegridlinegridlevel_motivos_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnheaderclass'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_TIPOLIQUIDACION_LASTPAGE","{handler:'subgridlevel_tipoliquidacion_lastpage',iparms:[{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'GRIDLEVEL_TIPOLIQUIDACION_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV22ConceptoTipoLiquidacionDeleted',fld:'vCONCEPTOTIPOLIQUIDACIONDELETED',pic:''},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'sPrefix'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262}]");
      setEventMetadata("GRIDLEVEL_TIPOLIQUIDACION_LASTPAGE",",oparms:[{av:'edtavDeletegridlinegridlevel_motivos_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnheaderclass'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_MOTIVOS_FIRSTPAGE","{handler:'subgridlevel_motivos_firstpage',iparms:[{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'sPrefix'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262}]");
      setEventMetadata("GRIDLEVEL_MOTIVOS_FIRSTPAGE",",oparms:[{av:'edtavDeletegridlinegridlevel_motivos_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnheaderclass'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_MOTIVOS_PREVPAGE","{handler:'subgridlevel_motivos_previouspage',iparms:[{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'sPrefix'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262}]");
      setEventMetadata("GRIDLEVEL_MOTIVOS_PREVPAGE",",oparms:[{av:'edtavDeletegridlinegridlevel_motivos_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnheaderclass'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_MOTIVOS_NEXTPAGE","{handler:'subgridlevel_motivos_nextpage',iparms:[{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'sPrefix'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262}]");
      setEventMetadata("GRIDLEVEL_MOTIVOS_NEXTPAGE",",oparms:[{av:'edtavDeletegridlinegridlevel_motivos_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnheaderclass'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Visible'}]}");
      setEventMetadata("GRIDLEVEL_MOTIVOS_LASTPAGE","{handler:'subgridlevel_motivos_lastpage',iparms:[{av:'GRIDLEVEL_MOTIVOS_nFirstRecordOnPage'},{av:'GRIDLEVEL_MOTIVOS_nEOF'},{av:'subGridlevel_tipoliquidacion_Rows',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'Rows'},{av:'subGridlevel_motivos_Rows',ctrl:'GRIDLEVEL_MOTIVOS',prop:'Rows'},{av:'AV63ConceptoMotivosEgresoDeleted',fld:'vCONCEPTOMOTIVOSEGRESODELETED',pic:''},{av:'AV151Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV28egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:'',hsh:true},{av:'AV25esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV67ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV30viejoConRecalcular',fld:'vVIEJOCONRECALCULAR',pic:'',hsh:true},{av:'AV60viejoAplIIGG',fld:'vVIEJOAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV39ConAFIPSIPAApo',fld:'vCONAFIPSIPAAPO',pic:'',hsh:true},{av:'AV27PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV32EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'sPrefix'},{av:'AV12TrnMode',fld:'vTRNMODE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26permiteModificacion',fld:'vPERMITEMODIFICACION',pic:'',hsh:true},{av:'AV16CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'GXV8',fld:'CONCEPTO_CONPUENOV',pic:''},{av:'GXV9',fld:'CONCEPTO_CONVARIABLE',pic:''},{av:'GXV12',fld:'CONCEPTO_CONHABILITADO',pic:''},{av:'GXV17',fld:'CONCEPTO_CONRECALCULAR',pic:''},{av:'GXV18',fld:'CONCEPTO_CONMOSTRARPOS',pic:''},{av:'GXV19',fld:'CONCEPTO_CONERRORSICERO',pic:''},{av:'GXV63',fld:'CONCEPTO_CONSEGUNPLA',pic:''},{av:'AV7Concepto',fld:'vCONCEPTO',pic:''},{av:'GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_247',ctrl:'GRIDLEVEL_TIPOLIQUIDACION',prop:'GridRC',grid:247},{av:'nRC_GXsfl_262',ctrl:'GRIDLEVEL_MOTIVOS',prop:'GridRC',grid:262}]");
      setEventMetadata("GRIDLEVEL_MOTIVOS_LASTPAGE",",oparms:[{av:'edtavDeletegridlinegridlevel_motivos_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGCODIGO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__MEGPREATIPO',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGMESES',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGDURA',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_MOTIVOSEGRESO__CONMEGPROPOR',prop:'Columnheaderclass'},{av:'edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass',ctrl:'vDELETEGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Columnheaderclass'},{ctrl:'CONCEPTO_TIPOLIQUIDACION__TLIQCOD',prop:'Columnheaderclass'},{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOSEGRESO',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_MOTIVOS',prop:'Visible'},{ctrl:'BTNADDGRIDLINEGRIDLEVEL_TIPOLIQUIDACION',prop:'Visible'}]}");
      setEventMetadata("VALIDV_GXV1","{handler:'validv_Gxv1',iparms:[]");
      setEventMetadata("VALIDV_GXV1",",oparms:[]}");
      setEventMetadata("VALIDV_GXV13","{handler:'validv_Gxv13',iparms:[]");
      setEventMetadata("VALIDV_GXV13",",oparms:[]}");
      setEventMetadata("VALIDV_GXV14","{handler:'validv_Gxv14',iparms:[]");
      setEventMetadata("VALIDV_GXV14",",oparms:[]}");
      setEventMetadata("VALIDV_GXV20","{handler:'validv_Gxv20',iparms:[]");
      setEventMetadata("VALIDV_GXV20",",oparms:[]}");
      setEventMetadata("VALIDV_GXV21","{handler:'validv_Gxv21',iparms:[]");
      setEventMetadata("VALIDV_GXV21",",oparms:[]}");
      setEventMetadata("VALIDV_GXV24","{handler:'validv_Gxv24',iparms:[]");
      setEventMetadata("VALIDV_GXV24",",oparms:[]}");
      setEventMetadata("VALIDV_GXV25","{handler:'validv_Gxv25',iparms:[]");
      setEventMetadata("VALIDV_GXV25",",oparms:[]}");
      setEventMetadata("VALIDV_GXV26","{handler:'validv_Gxv26',iparms:[]");
      setEventMetadata("VALIDV_GXV26",",oparms:[]}");
      setEventMetadata("VALIDV_GXV27","{handler:'validv_Gxv27',iparms:[]");
      setEventMetadata("VALIDV_GXV27",",oparms:[]}");
      setEventMetadata("VALIDV_GXV28","{handler:'validv_Gxv28',iparms:[]");
      setEventMetadata("VALIDV_GXV28",",oparms:[]}");
      setEventMetadata("VALIDV_GXV29","{handler:'validv_Gxv29',iparms:[]");
      setEventMetadata("VALIDV_GXV29",",oparms:[]}");
      setEventMetadata("VALIDV_GXV30","{handler:'validv_Gxv30',iparms:[]");
      setEventMetadata("VALIDV_GXV30",",oparms:[]}");
      setEventMetadata("VALIDV_GXV31","{handler:'validv_Gxv31',iparms:[]");
      setEventMetadata("VALIDV_GXV31",",oparms:[]}");
      setEventMetadata("VALIDV_GXV32","{handler:'validv_Gxv32',iparms:[]");
      setEventMetadata("VALIDV_GXV32",",oparms:[]}");
      setEventMetadata("VALIDV_GXV33","{handler:'validv_Gxv33',iparms:[]");
      setEventMetadata("VALIDV_GXV33",",oparms:[]}");
      setEventMetadata("VALIDV_GXV34","{handler:'validv_Gxv34',iparms:[]");
      setEventMetadata("VALIDV_GXV34",",oparms:[]}");
      setEventMetadata("VALIDV_GXV64","{handler:'validv_Gxv64',iparms:[]");
      setEventMetadata("VALIDV_GXV64",",oparms:[]}");
      setEventMetadata("VALIDV_GXV40","{handler:'validv_Gxv40',iparms:[]");
      setEventMetadata("VALIDV_GXV40",",oparms:[]}");
      setEventMetadata("VALIDV_GXV43","{handler:'validv_Gxv43',iparms:[]");
      setEventMetadata("VALIDV_GXV43",",oparms:[]}");
      setEventMetadata("VALIDV_GXV45","{handler:'validv_Gxv45',iparms:[]");
      setEventMetadata("VALIDV_GXV45",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv47',iparms:[]");
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
      wcpOAV12TrnMode = "" ;
      wcpOAV17ConCodigo = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV12TrnMode = "" ;
      AV17ConCodigo = "" ;
      Gx_mode = "" ;
      AV151Pgmname = "" ;
      AV7Concepto = new web.SdtConcepto(remoteHandle);
      AV22ConceptoTipoLiquidacionDeleted = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV28egresoTLiqCod = "" ;
      AV39ConAFIPSIPAApo = "" ;
      AV63ConceptoMotivosEgresoDeleted = new GXSimpleCollection<Short>(Short.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV11Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      Gridlevel_motivos_empowerer_Gridinternalname = "" ;
      Gridlevel_tipoliquidacion_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucGridlevel_motivos_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridlevel_tipoliquidacion_empowerer = new com.genexus.webpanels.GXUserControl();
      Gridlevel_tipoliquidacionContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      Gridlevel_motivosContainer = new com.genexus.webpanels.GXWebGrid(context);
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV9DeleteGridLineGridLevel_TipoLiquidacion = "" ;
      AV61DeleteGridLineGridLevel_Motivos = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H00AJ2_A11MegCodigo = new String[] {""} ;
      H00AJ2_A300MegDescrip = new String[] {""} ;
      H00AJ2_A3CliCod = new int[1] ;
      H00AJ3_A1885CliRelSec = new int[1] ;
      H00AJ3_A1880CliReDTChar = new String[] {""} ;
      H00AJ3_A3CliCod = new int[1] ;
      H00AJ4_A1112AplIIGG = new short[1] ;
      H00AJ4_A1113AplIIGGNom = new String[] {""} ;
      H00AJ4_A3CliCod = new int[1] ;
      H00AJ5_A1565CliConvenio = new String[] {""} ;
      H00AJ5_A1567CliConvenioDescrip = new String[] {""} ;
      H00AJ5_A3CliCod = new int[1] ;
      H00AJ5_A1564CliPaiConve = new short[1] ;
      H00AJ6_A78CuenCodigo = new String[] {""} ;
      H00AJ6_A485CuenDescrip = new String[] {""} ;
      H00AJ6_A3CliCod = new int[1] ;
      H00AJ6_A1EmpCod = new short[1] ;
      H00AJ6_A486CuenTipo = new String[] {""} ;
      H00AJ7_A78CuenCodigo = new String[] {""} ;
      H00AJ7_A485CuenDescrip = new String[] {""} ;
      H00AJ7_A3CliCod = new int[1] ;
      H00AJ7_A1EmpCod = new short[1] ;
      H00AJ7_A486CuenTipo = new String[] {""} ;
      H00AJ8_A32TLiqCod = new String[] {""} ;
      H00AJ8_A340TliqDesc = new String[] {""} ;
      H00AJ8_A3CliCod = new int[1] ;
      AV71RangoDesde = DecimalUtil.ZERO ;
      AV72RangoHasta = DecimalUtil.ZERO ;
      GXv_int2 = new short[1] ;
      AV65itemConcTipoLiq = new web.SdtConcepto_TipoLiquidacion(remoteHandle);
      GXt_char5 = "" ;
      GXv_char7 = new String[1] ;
      Gridlevel_tipoliquidacionRow = new com.genexus.webpanels.GXWebRow();
      AV76motivoEgresoItem = new web.SdtConcepto_MotivosEgreso(remoteHandle);
      AV62ConceptoMotivosEgresoItem = new web.SdtConcepto_MotivosEgreso(remoteHandle);
      AV21ConceptoTipoLiquidacionItem = new web.SdtConcepto_TipoLiquidacion(remoteHandle);
      GXt_char6 = "" ;
      AV78ultMegCodigo = "" ;
      AV79sdt_mot_egr = new GXBaseCollection<web.Sdtsdt_mot_egr_sdt_mot_egrItem>(web.Sdtsdt_mot_egr_sdt_mot_egrItem.class, "sdt_mot_egrItem", "PayDay", remoteHandle);
      AV80itemSdtMotEgr = new web.Sdtsdt_mot_egr_sdt_mot_egrItem(remoteHandle, context);
      GXv_int11 = new byte[1] ;
      AV69palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean4 = new boolean[1] ;
      AV10Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      GXv_int9 = new int[1] ;
      GXv_int10 = new long[1] ;
      AV35sdt_subtipos = new GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem>(web.Sdtsdt_subtipos_sdt_subtiposItem.class, "sdt_subtiposItem", "PayDay", remoteHandle);
      AV37itemSdt_Subtipos = new web.Sdtsdt_subtipos_sdt_subtiposItem(remoteHandle, context);
      GXv_objcol_Sdtsdt_subtipos_sdt_subtiposItem13 = new GXBaseCollection[1] ;
      AV73auxRangoPalabra = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56ConAfipSubT1 = "" ;
      GXv_char8 = new String[1] ;
      AV57httpRequest = httpContext.getHttpRequest();
      Gridlevel_motivosRow = new com.genexus.webpanels.GXWebRow();
      ucGxuitabspanel_tabs1 = new com.genexus.webpanels.GXUserControl();
      lblTab1_title_Jsonclick = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_unnamedtable3 = new com.genexus.webpanels.GXUserControl();
      lblTextblockrangodesde_Jsonclick = "" ;
      lblTextblockrangohasta_Jsonclick = "" ;
      ucDvpanel_unnamedtable4 = new com.genexus.webpanels.GXUserControl();
      bttBtnaddgridlinegridlevel_tipoliquidacion_Jsonclick = "" ;
      bttBtnaddgridlinegridlevel_motivosegreso_Jsonclick = "" ;
      bttBtnaddgridlinegridlevel_motivos_Jsonclick = "" ;
      lblTab3_title_Jsonclick = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      ucDvpanel_panelapocont3 = new com.genexus.webpanels.GXUserControl();
      lblS13_Jsonclick = "" ;
      lblSipatxt_3_Jsonclick = "" ;
      lblInjtxt_3_Jsonclick = "" ;
      lblOstxt_3_Jsonclick = "" ;
      lblFsr_3_Jsonclick = "" ;
      lblUatretxt_3_Jsonclick = "" ;
      lblAafftxt_3_Jsonclick = "" ;
      lblFnetxt_3_Jsonclick = "" ;
      lblDiftxt_3_Jsonclick = "" ;
      lblRegesptxt_3_Jsonclick = "" ;
      lblAportxt_3_Jsonclick = "" ;
      lblGuion1_3_Jsonclick = "" ;
      lblGuion2_3_Jsonclick = "" ;
      lblContrtxt_3_Jsonclick = "" ;
      lblGuion3_3_Jsonclick = "" ;
      lblGuion4_3_Jsonclick = "" ;
      lblLrt_txt_3_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV12TrnMode = "" ;
      sCtrlAV16CliCod = "" ;
      sCtrlAV17ConCodigo = "" ;
      subGridlevel_tipoliquidacion_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      subGridlevel_motivos_Linesclass = "" ;
      Gridlevel_tipoliquidacionColumn = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_motivosColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptoabm__default(),
         new Object[] {
             new Object[] {
            H00AJ2_A11MegCodigo, H00AJ2_A300MegDescrip, H00AJ2_A3CliCod
            }
            , new Object[] {
            H00AJ3_A1885CliRelSec, H00AJ3_A1880CliReDTChar, H00AJ3_A3CliCod
            }
            , new Object[] {
            H00AJ4_A1112AplIIGG, H00AJ4_A1113AplIIGGNom, H00AJ4_A3CliCod
            }
            , new Object[] {
            H00AJ5_A1565CliConvenio, H00AJ5_A1567CliConvenioDescrip, H00AJ5_A3CliCod, H00AJ5_A1564CliPaiConve
            }
            , new Object[] {
            H00AJ6_A78CuenCodigo, H00AJ6_A485CuenDescrip, H00AJ6_A3CliCod, H00AJ6_A1EmpCod, H00AJ6_A486CuenTipo
            }
            , new Object[] {
            H00AJ7_A78CuenCodigo, H00AJ7_A485CuenDescrip, H00AJ7_A3CliCod, H00AJ7_A1EmpCod, H00AJ7_A486CuenTipo
            }
            , new Object[] {
            H00AJ8_A32TLiqCod, H00AJ8_A340TliqDesc, H00AJ8_A3CliCod
            }
         }
      );
      AV151Pgmname = "ConceptoABM" ;
      /* GeneXus formulas. */
      AV151Pgmname = "ConceptoABM" ;
      Gx_err = (short)(0) ;
      edtavConcepto_conformula_Enabled = 0 ;
      edtavDeletegridlinegridlevel_tipoliquidacion_Enabled = 0 ;
      dynavConcepto_tipoliquidacion__tliqcod.setEnabled( 0 );
      cmbavConcepto_tipoliquidacion__contltipegr.setEnabled( 0 );
      edtavDeletegridlinegridlevel_motivos_Enabled = 0 ;
      edtavConcepto_motivosegreso__conmegsec_Enabled = 0 ;
   }

   private byte GRIDLEVEL_TIPOLIQUIDACION_nEOF ;
   private byte GRIDLEVEL_MOTIVOS_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subGridlevel_tipoliquidacion_Backcolorstyle ;
   private byte subGridlevel_motivos_Backcolorstyle ;
   private byte AV82ConNumero ;
   private byte GXt_int12 ;
   private byte GXv_int11[] ;
   private byte nGXWrapped ;
   private byte subGridlevel_tipoliquidacion_Backstyle ;
   private byte subGridlevel_motivos_Backstyle ;
   private byte subGridlevel_tipoliquidacion_Titlebackstyle ;
   private byte subGridlevel_tipoliquidacion_Allowselection ;
   private byte subGridlevel_tipoliquidacion_Allowhovering ;
   private byte subGridlevel_tipoliquidacion_Allowcollapsing ;
   private byte subGridlevel_tipoliquidacion_Collapsed ;
   private byte subGridlevel_motivos_Titlebackstyle ;
   private byte subGridlevel_motivos_Allowselection ;
   private byte subGridlevel_motivos_Allowhovering ;
   private byte subGridlevel_motivos_Allowcollapsing ;
   private byte subGridlevel_motivos_Collapsed ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV27PaiCod ;
   private short AV32EmpCod ;
   private short AV60viejoAplIIGG ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV81ConMegSec ;
   private short AV19Index ;
   private int wcpOAV16CliCod ;
   private int nRC_GXsfl_247 ;
   private int nRC_GXsfl_262 ;
   private int AV16CliCod ;
   private int subGridlevel_tipoliquidacion_Rows ;
   private int subGridlevel_motivos_Rows ;
   private int nGXsfl_247_idx=1 ;
   private int nGXsfl_262_idx=1 ;
   private int Gxuitabspanel_tabs1_Pagecount ;
   private int edtavConcepto_conrangocant_Visible ;
   private int edtavConcepto_conrangocant_Enabled ;
   private int edtavConcepto_clicod_Visible ;
   private int AV122GXV38 ;
   private int AV125GXV41 ;
   private int gxdynajaxindex ;
   private int subGridlevel_tipoliquidacion_Islastpage ;
   private int subGridlevel_motivos_Islastpage ;
   private int edtavConcepto_conformula_Enabled ;
   private int edtavDeletegridlinegridlevel_tipoliquidacion_Enabled ;
   private int edtavDeletegridlinegridlevel_motivos_Enabled ;
   private int edtavConcepto_motivosegreso__conmegsec_Enabled ;
   private int GRIDLEVEL_TIPOLIQUIDACION_nGridOutOfScope ;
   private int GRIDLEVEL_MOTIVOS_nGridOutOfScope ;
   private int nGXsfl_247_fel_idx=1 ;
   private int nGXsfl_262_fel_idx=1 ;
   private int edtavConcepto_concodafip_Enabled ;
   private int edtavConcepto_concondcodigo_Enabled ;
   private int edtavConcepto_conobservacion_Enabled ;
   private int edtavConcepto_conorden_Enabled ;
   private int edtavConcepto_conordejec_Enabled ;
   private int edtavRangodesde_Enabled ;
   private int edtavRangohasta_Enabled ;
   private int edtavConcepto_condescrip_Enabled ;
   private int edtavConcepto_concodigo_Enabled ;
   private int tblFormulatbl_Visible ;
   private int edtavConcepto_conobservacion_Visible ;
   private int divTableleaflevel_motivosegreso_Visible ;
   private int nGXsfl_247_bak_idx=1 ;
   private int AV153GXV67 ;
   private int AV154GXV68 ;
   private int AV155GXV69 ;
   private int bttBtnenter_Visible ;
   private int bttBtnaddgridlinegridlevel_motivosegreso_Visible ;
   private int bttBtnaddgridlinegridlevel_motivos_Visible ;
   private int bttBtnaddgridlinegridlevel_tipoliquidacion_Visible ;
   private int AV156GXV70 ;
   private int GXv_int9[] ;
   private int divTablerango_Visible ;
   private int AV157GXV71 ;
   private int AV158GXV72 ;
   private int edtavConcepto_concondcodigo_Visible ;
   private int tblTblapocon3_Visible ;
   private int edtavConcepto_motivosegreso__conmegmeses_Enabled ;
   private int edtavConcepto_motivosegreso__conmegpropor_Enabled ;
   private int idxLst ;
   private int subGridlevel_tipoliquidacion_Backcolor ;
   private int subGridlevel_tipoliquidacion_Allbackcolor ;
   private int edtavDeletegridlinegridlevel_tipoliquidacion_Visible ;
   private int subGridlevel_motivos_Backcolor ;
   private int subGridlevel_motivos_Allbackcolor ;
   private int edtavDeletegridlinegridlevel_motivos_Visible ;
   private int edtavConcepto_motivosegreso__conmegmeses_Visible ;
   private int edtavConcepto_motivosegreso__conmegpropor_Visible ;
   private int subGridlevel_tipoliquidacion_Titlebackcolor ;
   private int subGridlevel_tipoliquidacion_Selectedindex ;
   private int subGridlevel_tipoliquidacion_Selectioncolor ;
   private int subGridlevel_tipoliquidacion_Hoveringcolor ;
   private int subGridlevel_motivos_Titlebackcolor ;
   private int subGridlevel_motivos_Selectedindex ;
   private int subGridlevel_motivos_Selectioncolor ;
   private int subGridlevel_motivos_Hoveringcolor ;
   private long GRIDLEVEL_TIPOLIQUIDACION_nFirstRecordOnPage ;
   private long GRIDLEVEL_MOTIVOS_nFirstRecordOnPage ;
   private long GRIDLEVEL_TIPOLIQUIDACION_nCurrentRecord ;
   private long GRIDLEVEL_MOTIVOS_nCurrentRecord ;
   private long GRIDLEVEL_TIPOLIQUIDACION_nRecordCount ;
   private long GRIDLEVEL_MOTIVOS_nRecordCount ;
   private long GXv_int10[] ;
   private java.math.BigDecimal AV71RangoDesde ;
   private java.math.BigDecimal AV72RangoHasta ;
   private String wcpOAV12TrnMode ;
   private String wcpOAV17ConCodigo ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String AV12TrnMode ;
   private String AV17ConCodigo ;
   private String sGXsfl_247_idx="0001" ;
   private String Gx_mode ;
   private String AV151Pgmname ;
   private String AV28egresoTLiqCod ;
   private String AV39ConAFIPSIPAApo ;
   private String sGXsfl_262_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_unnamedtable4_Width ;
   private String Dvpanel_unnamedtable4_Cls ;
   private String Dvpanel_unnamedtable4_Title ;
   private String Dvpanel_unnamedtable4_Iconposition ;
   private String Dvpanel_unnamedtable3_Width ;
   private String Dvpanel_unnamedtable3_Cls ;
   private String Dvpanel_unnamedtable3_Title ;
   private String Dvpanel_unnamedtable3_Iconposition ;
   private String Dvpanel_panelapocont3_Width ;
   private String Dvpanel_panelapocont3_Cls ;
   private String Dvpanel_panelapocont3_Title ;
   private String Dvpanel_panelapocont3_Iconposition ;
   private String Gxuitabspanel_tabs1_Class ;
   private String Gridlevel_motivos_empowerer_Gridinternalname ;
   private String Gridlevel_tipoliquidacion_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String edtavConcepto_conrangocant_Internalname ;
   private String edtavConcepto_clicod_Internalname ;
   private String edtavConcepto_clicod_Jsonclick ;
   private String Gridlevel_motivos_empowerer_Internalname ;
   private String Gridlevel_tipoliquidacion_empowerer_Internalname ;
   private String sStyleString ;
   private String subGridlevel_tipoliquidacion_Internalname ;
   private String subGridlevel_motivos_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavDeletegridlinegridlevel_tipoliquidacion_Internalname ;
   private String AV9DeleteGridLineGridLevel_TipoLiquidacion ;
   private String AV61DeleteGridLineGridLevel_Motivos ;
   private String edtavDeletegridlinegridlevel_motivos_Internalname ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String edtavConcepto_conformula_Internalname ;
   private String edtavConcepto_motivosegreso__conmegsec_Internalname ;
   private String sGXsfl_247_fel_idx="0001" ;
   private String sGXsfl_262_fel_idx="0001" ;
   private String edtavConcepto_concodigo_Internalname ;
   private String edtavConcepto_condescrip_Internalname ;
   private String edtavConcepto_concodafip_Internalname ;
   private String edtavConcepto_concondcodigo_Internalname ;
   private String edtavConcepto_conobservacion_Internalname ;
   private String edtavRangodesde_Internalname ;
   private String edtavRangohasta_Internalname ;
   private String edtavConcepto_conorden_Internalname ;
   private String edtavConcepto_conordejec_Internalname ;
   private String tblFormulatbl_Internalname ;
   private String GXt_char5 ;
   private String GXv_char7[] ;
   private String edtavDeletegridlinegridlevel_motivos_Columnheaderclass ;
   private String edtavConcepto_motivosegreso__conmegmeses_Columnheaderclass ;
   private String edtavConcepto_motivosegreso__conmegmeses_Internalname ;
   private String edtavConcepto_motivosegreso__conmegpropor_Columnheaderclass ;
   private String edtavConcepto_motivosegreso__conmegpropor_Internalname ;
   private String edtavDeletegridlinegridlevel_tipoliquidacion_Columnheaderclass ;
   private String edtavDeletegridlinegridlevel_tipoliquidacion_Class ;
   private String edtavDeletegridlinegridlevel_tipoliquidacion_Columnclass ;
   private String divTableleaflevel_motivosegreso_Internalname ;
   private String GXt_char6 ;
   private String AV78ultMegCodigo ;
   private String bttBtnenter_Internalname ;
   private String bttBtnaddgridlinegridlevel_motivosegreso_Internalname ;
   private String bttBtnaddgridlinegridlevel_motivos_Internalname ;
   private String bttBtnaddgridlinegridlevel_tipoliquidacion_Internalname ;
   private String divConcepto_concodafip_cell_Class ;
   private String divConcepto_concodafip_cell_Internalname ;
   private String divConcepto_conrelsec_cell_Class ;
   private String divConcepto_conrelsec_cell_Internalname ;
   private String divDvpanel_unnamedtable4_cell_Class ;
   private String divDvpanel_unnamedtable4_cell_Internalname ;
   private String divTablerango_Internalname ;
   private String AV56ConAfipSubT1 ;
   private String GXv_char8[] ;
   private String tblTblapocon3_Internalname ;
   private String edtavDeletegridlinegridlevel_motivos_Class ;
   private String edtavDeletegridlinegridlevel_motivos_Columnclass ;
   private String edtavConcepto_motivosegreso__conmegmeses_Columnclass ;
   private String edtavConcepto_motivosegreso__conmegpropor_Columnclass ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Gxuitabspanel_tabs1_Internalname ;
   private String lblTab1_title_Internalname ;
   private String lblTab1_title_Jsonclick ;
   private String divUnnamedtable2_Internalname ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtavConcepto_concodigo_Jsonclick ;
   private String Dvpanel_unnamedtable3_Internalname ;
   private String divUnnamedtable3_Internalname ;
   private String edtavConcepto_concodafip_Jsonclick ;
   private String edtavConcepto_concondcodigo_Jsonclick ;
   private String divUnnamedtablerangodesde_Internalname ;
   private String lblTextblockrangodesde_Internalname ;
   private String lblTextblockrangodesde_Jsonclick ;
   private String edtavRangodesde_Jsonclick ;
   private String divUnnamedtablerangohasta_Internalname ;
   private String lblTextblockrangohasta_Internalname ;
   private String lblTextblockrangohasta_Jsonclick ;
   private String edtavRangohasta_Jsonclick ;
   private String edtavConcepto_conorden_Jsonclick ;
   private String edtavConcepto_conordejec_Jsonclick ;
   private String Dvpanel_unnamedtable4_Internalname ;
   private String divUnnamedtable4_Internalname ;
   private String divTableleaflevel_tipoliquidacion_Internalname ;
   private String bttBtnaddgridlinegridlevel_tipoliquidacion_Jsonclick ;
   private String bttBtnaddgridlinegridlevel_motivosegreso_Jsonclick ;
   private String bttBtnaddgridlinegridlevel_motivos_Jsonclick ;
   private String lblTab3_title_Internalname ;
   private String lblTab3_title_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String Dvpanel_panelapocont3_Internalname ;
   private String divPanelapocont3_Internalname ;
   private String tblTbl23_Internalname ;
   private String lblS13_Internalname ;
   private String lblS13_Jsonclick ;
   private String lblSipatxt_3_Internalname ;
   private String lblSipatxt_3_Jsonclick ;
   private String lblInjtxt_3_Internalname ;
   private String lblInjtxt_3_Jsonclick ;
   private String lblOstxt_3_Internalname ;
   private String lblOstxt_3_Jsonclick ;
   private String lblFsr_3_Internalname ;
   private String lblFsr_3_Jsonclick ;
   private String lblUatretxt_3_Internalname ;
   private String lblUatretxt_3_Jsonclick ;
   private String lblAafftxt_3_Internalname ;
   private String lblAafftxt_3_Jsonclick ;
   private String lblFnetxt_3_Internalname ;
   private String lblFnetxt_3_Jsonclick ;
   private String lblDiftxt_3_Internalname ;
   private String lblDiftxt_3_Jsonclick ;
   private String lblRegesptxt_3_Internalname ;
   private String lblRegesptxt_3_Jsonclick ;
   private String lblAportxt_3_Internalname ;
   private String lblAportxt_3_Jsonclick ;
   private String lblGuion1_3_Internalname ;
   private String lblGuion1_3_Jsonclick ;
   private String lblGuion2_3_Internalname ;
   private String lblGuion2_3_Jsonclick ;
   private String lblContrtxt_3_Internalname ;
   private String lblContrtxt_3_Jsonclick ;
   private String lblGuion3_3_Internalname ;
   private String lblGuion3_3_Jsonclick ;
   private String lblGuion4_3_Internalname ;
   private String lblGuion4_3_Jsonclick ;
   private String lblLrt_txt_3_Internalname ;
   private String lblLrt_txt_3_Jsonclick ;
   private String sCtrlAV12TrnMode ;
   private String sCtrlAV16CliCod ;
   private String sCtrlAV17ConCodigo ;
   private String subGridlevel_tipoliquidacion_Class ;
   private String subGridlevel_tipoliquidacion_Linesclass ;
   private String ROClassString ;
   private String edtavDeletegridlinegridlevel_tipoliquidacion_Jsonclick ;
   private String GXCCtl ;
   private String subGridlevel_motivos_Class ;
   private String subGridlevel_motivos_Linesclass ;
   private String edtavDeletegridlinegridlevel_motivos_Jsonclick ;
   private String edtavConcepto_motivosegreso__conmegmeses_Jsonclick ;
   private String edtavConcepto_motivosegreso__conmegpropor_Jsonclick ;
   private String edtavConcepto_motivosegreso__conmegsec_Jsonclick ;
   private String subGridlevel_tipoliquidacion_Header ;
   private String subGridlevel_motivos_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV26permiteModificacion ;
   private boolean AV25esSistemaConceptosDefault ;
   private boolean AV67ClienteConveniador ;
   private boolean AV30viejoConRecalcular ;
   private boolean AV14CheckRequiredFieldsResult ;
   private boolean AV68vieneDeClick ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_unnamedtable4_Autowidth ;
   private boolean Dvpanel_unnamedtable4_Autoheight ;
   private boolean Dvpanel_unnamedtable4_Collapsible ;
   private boolean Dvpanel_unnamedtable4_Collapsed ;
   private boolean Dvpanel_unnamedtable4_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable4_Autoscroll ;
   private boolean Dvpanel_unnamedtable3_Autowidth ;
   private boolean Dvpanel_unnamedtable3_Autoheight ;
   private boolean Dvpanel_unnamedtable3_Collapsible ;
   private boolean Dvpanel_unnamedtable3_Collapsed ;
   private boolean Dvpanel_unnamedtable3_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable3_Autoscroll ;
   private boolean Dvpanel_panelapocont3_Autowidth ;
   private boolean Dvpanel_panelapocont3_Autoheight ;
   private boolean Dvpanel_panelapocont3_Collapsible ;
   private boolean Dvpanel_panelapocont3_Collapsed ;
   private boolean Dvpanel_panelapocont3_Showcollapseicon ;
   private boolean Dvpanel_panelapocont3_Autoscroll ;
   private boolean Gxuitabspanel_tabs1_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_247_Refreshing=false ;
   private boolean bGXsfl_262_Refreshing=false ;
   private boolean returnInSub ;
   private boolean AV13LoadSuccess ;
   private boolean gx_BV247 ;
   private boolean gx_refresh_fired ;
   private boolean AV15LineDeleted ;
   private boolean gx_BV262 ;
   private boolean GXt_boolean3 ;
   private boolean AV29duplicado ;
   private boolean AV70CliConveHab ;
   private boolean AV74aplicadoHay ;
   private boolean GXv_boolean4[] ;
   private boolean Cond_result ;
   private boolean AV54aplicaAlgo ;
   private GXSimpleCollection<Short> AV22ConceptoTipoLiquidacionDeleted ;
   private GXSimpleCollection<Short> AV63ConceptoMotivosEgresoDeleted ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_tipoliquidacionContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_motivosContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_tipoliquidacionRow ;
   private com.genexus.webpanels.GXWebRow Gridlevel_motivosRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_tipoliquidacionColumn ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_motivosColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV57httpRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucGridlevel_motivos_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridlevel_tipoliquidacion_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_tabs1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable3 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable4 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelapocont3 ;
   private HTMLChoice cmbavConcepto_tipoconcod ;
   private HTMLChoice cmbavConcepto_subtipoconcod1 ;
   private HTMLChoice cmbavConcepto_subtipoconcod2 ;
   private HTMLChoice dynavConcepto_conrelsec ;
   private ICheckbox chkavConcepto_conpuenov ;
   private ICheckbox chkavConcepto_convariable ;
   private HTMLChoice dynavConcepto_apliigg ;
   private ICheckbox chkavConcepto_conhabilitado ;
   private HTMLChoice cmbavConcepto_convigencia ;
   private HTMLChoice cmbavConcepto_concondicion ;
   private ICheckbox chkavConcepto_conrecalcular ;
   private ICheckbox chkavConcepto_conmostrarpos ;
   private ICheckbox chkavConcepto_conerrorsicero ;
   private HTMLChoice cmbavConcepto_conadeldescu ;
   private HTMLChoice cmbavConcepto_consacdeven ;
   private HTMLChoice cmbavConcepto_conbaselic ;
   private HTMLChoice cmbavConcepto_conbaselicprom ;
   private HTMLChoice cmbavConcepto_conbasefer ;
   private HTMLChoice cmbavConcepto_conbaseferprom ;
   private HTMLChoice cmbavConcepto_conbasehorext ;
   private HTMLChoice cmbavConcepto_conbasehorextprom ;
   private HTMLChoice cmbavConcepto_conbasepres ;
   private HTMLChoice cmbavConcepto_conbaseant ;
   private HTMLChoice cmbavConcepto_conbaseosdif ;
   private HTMLChoice cmbavConcepto_conbaseaus ;
   private HTMLChoice cmbavConcepto_conbaseausprom ;
   private HTMLChoice dynavConcepto_conceptoconvecodigo ;
   private HTMLChoice dynavConcepto_concuendebe ;
   private HTMLChoice dynavConcepto_concuenhaber ;
   private HTMLChoice dynavConcepto_tipoliquidacion__tliqcod ;
   private HTMLChoice cmbavConcepto_tipoliquidacion__contltipegr ;
   private HTMLChoice dynavConcepto_motivosegreso__megcodigo ;
   private HTMLChoice cmbavConcepto_motivosegreso__megpreatipo ;
   private HTMLChoice cmbavConcepto_motivosegreso__conmegdura ;
   private HTMLChoice cmbavConcepto_consipaapo ;
   private HTMLChoice cmbavConcepto_coninssjypapo ;
   private HTMLChoice cmbavConcepto_conobrasocapo ;
   private HTMLChoice cmbavConcepto_confonsolredapo ;
   private HTMLChoice cmbavConcepto_conrenateaapo ;
   private HTMLChoice cmbavConcepto_conregdifapo ;
   private HTMLChoice cmbavConcepto_conregespapo ;
   private HTMLChoice cmbavConcepto_consipacont ;
   private HTMLChoice cmbavConcepto_coninssjypcont ;
   private HTMLChoice cmbavConcepto_conobrasoccont ;
   private HTMLChoice cmbavConcepto_confonsolredcont ;
   private HTMLChoice cmbavConcepto_conrenateacont ;
   private HTMLChoice cmbavConcepto_conasigfamcont ;
   private HTMLChoice cmbavConcepto_confonnacempcont ;
   private HTMLChoice cmbavConcepto_conleyrietrabcont ;
   private ICheckbox chkavConcepto_consegunpla ;
   private HTMLChoice cmbavConcepto_conprereq ;
   private IDataStoreProvider pr_default ;
   private String[] H00AJ2_A11MegCodigo ;
   private String[] H00AJ2_A300MegDescrip ;
   private int[] H00AJ2_A3CliCod ;
   private int[] H00AJ3_A1885CliRelSec ;
   private String[] H00AJ3_A1880CliReDTChar ;
   private int[] H00AJ3_A3CliCod ;
   private short[] H00AJ4_A1112AplIIGG ;
   private String[] H00AJ4_A1113AplIIGGNom ;
   private int[] H00AJ4_A3CliCod ;
   private String[] H00AJ5_A1565CliConvenio ;
   private String[] H00AJ5_A1567CliConvenioDescrip ;
   private int[] H00AJ5_A3CliCod ;
   private short[] H00AJ5_A1564CliPaiConve ;
   private String[] H00AJ6_A78CuenCodigo ;
   private String[] H00AJ6_A485CuenDescrip ;
   private int[] H00AJ6_A3CliCod ;
   private short[] H00AJ6_A1EmpCod ;
   private String[] H00AJ6_A486CuenTipo ;
   private String[] H00AJ7_A78CuenCodigo ;
   private String[] H00AJ7_A485CuenDescrip ;
   private int[] H00AJ7_A3CliCod ;
   private short[] H00AJ7_A1EmpCod ;
   private String[] H00AJ7_A486CuenTipo ;
   private String[] H00AJ8_A32TLiqCod ;
   private String[] H00AJ8_A340TliqDesc ;
   private int[] H00AJ8_A3CliCod ;
   private GXSimpleCollection<String> AV69palabras ;
   private GXSimpleCollection<String> AV73auxRangoPalabra ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV11Messages ;
   private GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem> AV35sdt_subtipos ;
   private GXBaseCollection<web.Sdtsdt_subtipos_sdt_subtiposItem> GXv_objcol_Sdtsdt_subtipos_sdt_subtiposItem13[] ;
   private GXBaseCollection<web.Sdtsdt_mot_egr_sdt_mot_egrItem> AV79sdt_mot_egr ;
   private com.genexus.SdtMessages_Message AV10Message ;
   private web.SdtConcepto AV7Concepto ;
   private web.SdtConcepto_TipoLiquidacion AV65itemConcTipoLiq ;
   private web.SdtConcepto_TipoLiquidacion AV21ConceptoTipoLiquidacionItem ;
   private web.SdtConcepto_MotivosEgreso AV76motivoEgresoItem ;
   private web.SdtConcepto_MotivosEgreso AV62ConceptoMotivosEgresoItem ;
   private web.Sdtsdt_subtipos_sdt_subtiposItem AV37itemSdt_Subtipos ;
   private web.Sdtsdt_mot_egr_sdt_mot_egrItem AV80itemSdtMotEgr ;
}

final  class conceptoabm__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00AJ2", "SELECT MegCodigo, MegDescrip, CliCod FROM MotivoEgreso WHERE CliCod = ? ORDER BY MegDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00AJ3", "SELECT CliRelSec, CliReDTChar, CliCod FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00AJ4", "SELECT AplIIGG, AplIIGGNom, CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? ORDER BY AplIIGGNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00AJ5", "SELECT T1.CliConvenio AS CliConvenio, T2.ConveDescri AS CliConvenioDescrip, T1.CliCod, T1.CliPaiConve AS CliPaiConve FROM (ClienteConvenios T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE (T1.CliCod = ?) AND (T1.CliPaiConve = ?) ORDER BY T2.ConveDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00AJ6", "SELECT CuenCodigo, CuenDescrip, CliCod, EmpCod, CuenTipo FROM CuentaContable WHERE (CliCod = ?) AND (EmpCod = ?) AND (CuenTipo = ( 'D')) ORDER BY CuenDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00AJ7", "SELECT CuenCodigo, CuenDescrip, CliCod, EmpCod, CuenTipo FROM CuentaContable WHERE (CliCod = ?) AND (EmpCod = ?) AND (CuenTipo = ( 'H')) ORDER BY CuenDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00AJ8", "SELECT TLiqCod, TliqDesc, CliCod FROM TipoLiquidacion WHERE CliCod = ? ORDER BY TliqDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

